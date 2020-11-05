package com.skodoskxx.techie.springngblog.repository;

import com.skodoskxx.techie.springngblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {
}
