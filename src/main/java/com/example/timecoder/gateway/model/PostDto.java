package com.example.timecoder.gateway.model;


public class PostDto {

    private Object post;
    private Object episode;
    private Object patrons;

    public PostDto() {
    }

    public PostDto(Object post, Object episode, Object patrons) {
        this.post = post;
        this.episode = episode;
        this.patrons = patrons;
    }

    public Object getPost() {
        return post;
    }

    public void setPost(Object post) {
        this.post = post;
    }

    public Object getEpisode() {
        return episode;
    }

    public void setEpisode(Object episode) {
        this.episode = episode;
    }

    public Object getPatrons() {
        return patrons;
    }

    public void setPatrons(Object patrons) {
        this.patrons = patrons;
    }
}
