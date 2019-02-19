package com.example.timecoder.gateway.controller;

import com.example.timecoder.gateway.proxy.TimecoderServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class PostController {

    @Autowired
    private TimecoderServiceProxy timecoderServiceProxy;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public Object getAllPosts() {
        return timecoderServiceProxy.getAllPosts();
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public Object getPostById(@PathVariable("id") Long id) {
        return timecoderServiceProxy.getPostById(id);
    }

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public Object createPost(@RequestBody Object post) {
        return timecoderServiceProxy.createPost(post);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    public Object updatePost(@PathVariable("id") Long id, @RequestBody Object post) {
        return timecoderServiceProxy.updatePost(id, post);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    public Object deletePost(@PathVariable("id") Long id) {
        return timecoderServiceProxy.deletePost(id);
    }
}
