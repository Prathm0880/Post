package com.microservice.post.Service;

import com.microservice.post.Entity.Post;
import com.microservice.post.Reposatory.PostReposatory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {
    @Autowired
    private PostReposatory postReposatory;
    public Post uploadPost(Post post){
        String postId = UUID.randomUUID().toString();
        post.setId(postId);
        Post savedPost = postReposatory.save(post);
        return savedPost;
    }

    public Post getPost(String postId) {
        Optional<Post> byId = postReposatory.findById(postId);
        if(byId.isEmpty()){
            throw new RuntimeException("Post not found.");
        }
        Post post = byId.get();
        return post;
    }
}
