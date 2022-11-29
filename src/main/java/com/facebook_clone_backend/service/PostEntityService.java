package com.facebook_clone_backend.service;

import com.facebook_clone_backend.model.Post;

import java.util.List;

public interface PostEntityService {
    Post addPost(Post post) throws Exception;

    List<Post> getPost();
}
