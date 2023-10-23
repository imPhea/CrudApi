package com.app.demo.controller;

import com.app.demo.model.entity.PostEntity;
import com.app.demo.model.request.post.PostRequest;
import com.app.demo.model.response.post.PostResponse;
import com.app.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
public class PostController{
    private final PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<PostResponse> create(@RequestBody PostRequest req) throws Exception {
        PostEntity data = this.postService.create(req);
        try {
            return ResponseEntity.ok(PostResponse.fromEntity(data));
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
