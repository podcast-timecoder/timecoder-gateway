package com.example.timecoder.gateway.service;

import com.example.timecoder.gateway.model.Post;
import com.example.timecoder.gateway.model.PostDto;
import com.example.timecoder.gateway.proxy.PatronsServiceProxy;
import com.example.timecoder.gateway.proxy.TimecoderServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostService {

    @Autowired
    private TimecoderServiceProxy timecoderServiceProxy;

    @Autowired
    private PatronsServiceProxy patronsServiceProxy;


    public PostDto getPostById(Long id) {
        Post post = null;
        Object episode = null;
        Object patronsList = null;
        try {
            post = timecoderServiceProxy.getPostById(id);
            episode = timecoderServiceProxy.getEpisodeById(post.getEpisodeId());
            patronsList = patronsServiceProxy.getAllActivePatrons();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new PostDto(post, episode, patronsList);
    }
}
