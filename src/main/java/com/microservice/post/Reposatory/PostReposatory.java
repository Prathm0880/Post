package com.microservice.post.Reposatory;

import com.microservice.post.Entity.Post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostReposatory extends JpaRepository<Post,String> {

}
