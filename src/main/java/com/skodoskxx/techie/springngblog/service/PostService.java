package com.skodoskxx.techie.springngblog.service;

import com.skodoskxx.techie.springngblog.dto.PostDto;
import com.skodoskxx.techie.springngblog.exception.PostNotFoundException;
import com.skodoskxx.techie.springngblog.model.Post;
import com.skodoskxx.techie.springngblog.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class PostService {

    @Autowired
    private AuthService authService;
    @Autowired
    private PostRepo postRepo;

//    public void createPost(PostDto postDto){
//        Post post = new Post();
//        post.setTitle(postDto.getTitle());
//        post.setContent(postDto.getContent());
//        User username = authService.getCurrentUser().orElseThrow(()-> new IllegalArgumentException("No user logged in"));
//        post.setUsername(username.getUsername());
//        post.setCreatedOn(Instant.now());
//        postRepo.save(post);
//    }

    @Transactional
    public List<PostDto> showAllPosts() {
        List<Post> posts = postRepo.findAll();
        return posts.stream().map(this::mapFromPostToDto).collect(toList());
    }

    @Transactional
    public void createPost(PostDto postDto) {
        Post post = mapFromDtoToPost(postDto);
        postRepo.save(post);
    }

    @Transactional
    public PostDto readSinglePost(Long id) {
        Post post = postRepo.findById(id).orElseThrow(() -> new PostNotFoundException("For id " + id));
        return mapFromPostToDto(post);
    }

    private PostDto mapFromPostToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setUsername(post.getUsername());
        return postDto;
    }

    private Post mapFromDtoToPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        User loggedInUser = authService.getCurrentUser().orElseThrow(() -> new IllegalArgumentException("User Not Found"));
        post.setCreatedOn(Instant.now());
        post.setUsername(loggedInUser.getUsername());
        post.setUpdatedOn(Instant.now());
        return post;
    }
}
