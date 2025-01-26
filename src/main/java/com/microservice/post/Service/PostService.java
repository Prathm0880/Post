package com.microservice.post.Service;

import com.microservice.post.Configuration.RestTemplateConfig;
import com.microservice.post.Entity.Post;
import com.microservice.post.Payload.PostDto;
import com.microservice.post.Reposatory.PostReposatory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {
    @Autowired
    private PostReposatory postReposatory;
    @Autowired
    private RestTemplateConfig restTemplateConfig;
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

    public PostDto findPostWithComments(String postId) {
        Optional<Post> byId = postReposatory.findById(postId);
        if(byId.isEmpty()){
            throw new RuntimeException("Post not found.");
        }
        Post post = byId.get();
        ArrayList comments = restTemplateConfig.getRestTemplate().getForObject("http://localhost:8082/api/comments/"+postId, ArrayList.class);
        PostDto postDto = new PostDto();
        postDto.setComments(comments==null?new ArrayList<>():comments);
        postDto.setPostId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setDescription(post.getDescription());
        return postDto;
    }
}
