package com.app.demo.service;

import com.app.demo.model.entity.PostEntity;
import com.app.demo.model.request.post.PostRequest;
import com.app.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;
    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostEntity create(PostRequest req) throws Exception {
        try {
            return this.postRepository.save(req.toEntity());
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

}
