package com.facebook_clone_backend.controller;

import com.facebook_clone_backend.model.Post;
import com.facebook_clone_backend.service.PostEntityService;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;
import java.util.Map;

@CrossOrigin(value = "http://localhost:3000/")
@RestController
@RequestMapping("/api/v1/post")
public class PostEntityController {

    private PostEntityService postEntityService;

    public PostEntityController(PostEntityService postEntityService) {
        this.postEntityService = postEntityService;
    }

    @PostMapping
    public Post addPost(@RequestParam Map<String, String> requestParams) throws Exception {
        String strpost = requestParams.get("post");
        String email = requestParams.get("email");
        String name = requestParams.get("name");
        String file = requestParams.get("file");
        String profilePic = requestParams.get("profilePic");

        Post post = Post.builder()
                .file(file)
                .name(name)
                .email(email)
                .post(strpost)
                .profilePic(profilePic)
                .timeStamp(new Date().toString())
                .build();

        post = postEntityService.addPost(post);
        return post;
    }

    @GetMapping
    public List<Post> getPost(){
        return postEntityService.getPost();
    }
}
