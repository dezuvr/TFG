package com.musicratings.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    
    // Navigation buttons
    private Button btnHome, btnSongs, btnAlbums, btnProfile;
    
    // Content containers
    private LinearLayout homeContent, songsContent, albumsContent, profileContent;
    private FrameLayout contentContainer;
    
    // Search bars
    private EditText searchSongs, searchAlbums;
    
    // Profile elements
    private TextView profileName, profileEmail;
    
    // RecyclerViews
    private RecyclerView songsRecyclerView, albumsRecyclerView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initializeViews();
        setupClickListeners();
        setupRecyclerViews();
        
        // Show home by default
        showHome();
    }
    
    private void initializeViews() {
        // Navigation buttons
        btnHome = findViewById(R.id.btnHome);
        btnSongs = findViewById(R.id.btnSongs);
        btnAlbums = findViewById(R.id.btnAlbums);
        btnProfile = findViewById(R.id.btnProfile);
        
        // Content containers
        contentContainer = findViewById(R.id.contentContainer);
        homeContent = findViewById(R.id.homeContent);
        songsContent = findViewById(R.id.songsContent);
        albumsContent = findViewById(R.id.albumsContent);
