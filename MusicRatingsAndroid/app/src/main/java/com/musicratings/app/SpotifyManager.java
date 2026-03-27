package com.musicratings.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.spotify.android.appremote.api.ConnectionParams;
import com.spotify.android.appremote.api.Connector;
import com.spotify.android.appremote.api.SpotifyAppRemote;
import com.spotify.android.appremote.api.SpotifyAppRemote.ConnectionResult;
import com.spotify.sdk.android.auth.AuthorizationClient;
import com.spotify.sdk.android.auth.AuthorizationRequest;
import com.spotify.sdk.android.auth.AuthorizationResponse;

public class SpotifyManager {
    private static final String CLIENT_ID = "TU_CLIENT_ID_AQUI";
    private static final String REDIRECT_URI = "musicratings://callback";
    private static final int REQUEST_CODE = 1337;
    
    private static SpotifyAppRemote mSpotifyAppRemote;
    private static String accessToken;
    private static Context context;
    
    public interface SpotifyCallback {
        void onSuccess();
        void onError(String error);
    }
    
    public static void initialize(Context ctx) {
        context = ctx;
        loadStoredToken();
    }
    
    // Autenticación con Spotify
    public static void authenticate(SpotifyCallback callback) {
        AuthorizationRequest.Builder builder = new AuthorizationRequest.Builder(CLIENT_ID, AuthorizationResponse.Type.TOKEN, REDIRECT_URI);
        builder.setScopes(new String[]{"user-read-private", "user-read-email", "playlist-read-private"});
        AuthorizationRequest request = builder.build();
        
        AuthorizationClient.openLoginActivity(context, REQUEST_CODE, request);
    }
    
    // Conexión con Spotify App Remote
    public static void connectSpotifyAppRemote(SpotifyCallback callback) {
        ConnectionParams connectionParams = new ConnectionParams.Builder(CLIENT_ID)
                .setRedirectUri(REDIRECT_URI)
                .showAuthView(true)
                .build();
        
        SpotifyAppRemote.connect(context, connectionParams, new Connector.ConnectionListener() {
            @Override
            public void onConnected(SpotifyAppRemote spotifyAppRemote) {
                mSpotifyAppRemote = spotifyAppRemote;
                Log.d("SpotifyManager", "Connected to Spotify App Remote");
                callback.onSuccess();
            }
            
            @Override
            public void onFailure(Throwable throwable) {
                Log.e("SpotifyManager", "Could not connect to Spotify App Remote", throwable);
                callback.onError("Error connecting to Spotify: " + throwable.getMessage());
            }
        });
    }
    
    // Guardar token de acceso
    public static void saveToken(String token) {
        accessToken = token;
        SharedPreferences prefs = context.getSharedPreferences("SpotifyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("access_token", token);
        editor.apply();
    }
    
    // Cargar token guardado
    private static void loadStoredToken() {
        SharedPreferences prefs = context.getSharedPreferences("SpotifyPrefs", Context.MODE_PRIVATE);
        accessToken = prefs.getString("access_token", null);
    }
    
    // Getters
    public static String getAccessToken() {
        return accessToken;
    }
    
    public static SpotifyAppRemote getSpotifyAppRemote() {
        return mSpotifyAppRemote;
    }
    
    public static boolean isAuthenticated() {
        return accessToken != null && !accessToken.isEmpty();
    }
    
    // Desconectar
    public static void disconnect() {
        if (mSpotifyAppRemote != null) {
            SpotifyAppRemote.disconnect(mSpotifyAppRemote);
        }
    }
}
