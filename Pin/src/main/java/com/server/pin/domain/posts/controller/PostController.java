package com.server.pin.domain.posts.controller;

import com.server.pin.domain.posts.service.PostService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
@Tag(name = "게시물", description = "게시물 API")
public class PostController {
    private final PostService postService;

}
