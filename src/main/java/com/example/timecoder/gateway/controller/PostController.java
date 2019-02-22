package com.example.timecoder.gateway.controller;

import com.example.timecoder.gateway.Page;
import com.example.timecoder.gateway.model.Post;
import com.example.timecoder.gateway.model.PostDto;
import com.example.timecoder.gateway.proxy.TimecoderServiceProxy;
import com.example.timecoder.gateway.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PostController {

    @Autowired
    private TimecoderServiceProxy timecoderServiceProxy;

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public List<Post> getAllPosts(Page page) {
        return timecoderServiceProxy.getAllPosts(page);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public PostDto getPostById(@PathVariable("id") Long id) {
        return postService.getPostById(id);
    }

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public Object createPost(@RequestBody Post post) {
        return timecoderServiceProxy.createPost(post);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    public Object updatePost(@PathVariable("id") Long id, @RequestBody Post post) {
        return timecoderServiceProxy.updatePost(id, post);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    public Object deletePost(@PathVariable("id") Long id) {
        return timecoderServiceProxy.deletePost(id);
    }
}
