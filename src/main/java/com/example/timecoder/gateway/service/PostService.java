package com.example.timecoder.gateway.service;

import com.example.timecoder.gateway.model.Post;
import com.example.timecoder.gateway.model.PostDto;
import com.example.timecoder.gateway.proxy.PatronsServiceProxy;
import com.example.timecoder.gateway.proxy.TimecoderServiceProxy;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostService {

    @Autowired
    private TimecoderServiceProxy timecoderServiceProxy;

    @Autowired
    private PatronsServiceProxy patronsServiceProxy;


    public PostDto getPostById(Long id) {
        ObjectMapper mapper = new ObjectMapper();
        Post post = mapper.convertValue(timecoderServiceProxy.getPostById(id), Post.class);
        Object episode = timecoderServiceProxy.getEpisodeById(post.getEpisodeId());
        Object patronsList = patronsServiceProxy.getAllActivePatrons();

        return new PostDto(post, episode, patronsList);
    }
}
