package com.musicratings.app;

import com.google.gson.annotations.SerializedName;

public class Song {
    @SerializedName("id")
    private String id;
    
    @SerializedName("name")
    private String title;
    
    @SerializedName("artists")
    private java.util.List<Artist> artists;
    
    @SerializedName("album")
    private Album album;
    
    @SerializedName("duration_ms")
    private int durationMs;
    
    @SerializedName("popularity")
    private int popularity;
    
    @SerializedName("preview_url")
    private String previewUrl;
    
    @SerializedName("external_urls")
    private ExternalUrls externalUrls;
    
    // Campos adicionales para nuestra app
    private String genre;
    private float rating;
    private int ratingCount;
    private String imageUrl;
    
    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public java.util.List<Artist> getArtists() { return artists; }
    public void setArtists(java.util.List<Artist> artists) { this.artists = artists; }
    
    public Album getAlbum() { return album; }
    public void setAlbum(Album album) { this.album = album; }
    
    public int getDurationMs() { return durationMs; }
    public void setDurationMs(int durationMs) { this.durationMs = durationMs; }
    
    public String getDuration() {
        int minutes = (durationMs / 1000) / 60;
        int seconds = (durationMs / 1000) % 60;
        return String.format("%d:%02d", minutes, seconds);
    }
    
    public int getPopularity() { return popularity; }
    public void setPopularity(int popularity) { this.popularity = popularity; }
    
    public String getPreviewUrl() { return previewUrl; }
    public void setPreviewUrl(String previewUrl) { this.previewUrl = previewUrl; }
    
    public ExternalUrls getExternalUrls() { return externalUrls; }
    public void setExternalUrls(ExternalUrls externalUrls) { this.externalUrls = externalUrls; }
    
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    
    public float getRating() { return rating; }
    public void setRating(float rating) { this.rating = rating; }
    
    public int getRatingCount() { return ratingCount; }
    public void setRatingCount(int ratingCount) { this.ratingCount = ratingCount; }
    
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    
    public String getArtistName() {
        if (artists != null && !artists.isEmpty()) {
            return artists.get(0).getName();
        }
        return "Unknown Artist";
    }
    
    public String getAlbumName() {
        if (album != null) {
            return album.getName();
        }
        return "Unknown Album";
    }
    
    // Clases internas
    public static class Artist {
        @SerializedName("id")
        private String id;
        
        @SerializedName("name")
        private String name;
        
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }
    
    public static class Album {
        @SerializedName("id")
        private String id;
        
        @SerializedName("name")
        private String name;
        
        @SerializedName("images")
        private java.util.List<Image> images;
        
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        
        public java.util.List<Image> getImages() { return images; }
        public void setImages(java.util.List<Image> images) { this.images = images; }
        
        public String getMainImageUrl() {
            if (images != null && !images.isEmpty()) {
                return images.get(0).getUrl();
            }
            return null;
        }
    }
    
    public static class Image {
        @SerializedName("url")
        private String url;
        
        @SerializedName("height")
        private int height;
        
        @SerializedName("width")
        private int width;
        
        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }
        
        public int getHeight() { return height; }
        public void setHeight(int height) { this.height = height; }
        
        public int getWidth() { return width; }
        public void setWidth(int width) { this.width = width; }
    }
    
    public static class ExternalUrls {
        @SerializedName("spotify")
        private String spotify;
        
        public String getSpotify() { return spotify; }
        public void setSpotify(String spotify) { this.spotify = spotify; }
    }
}
