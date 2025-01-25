package com.microservice.post.Controller;

import com.microservice.post.Entity.Post;
import com.microservice.post.PostApplication;
import com.microservice.post.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping("/upload")
    public ResponseEntity<Post> addPost(@RequestBody Post post){
        Post post1 = postService.uploadPost(post);
        return new ResponseEntity<>(post1, HttpStatus.CREATED);
    }
    //http://localhost:8081/api/post/{postId}
    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPost(@PathVariable String postId){
        Post post = postService.getPost(postId);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }
}
