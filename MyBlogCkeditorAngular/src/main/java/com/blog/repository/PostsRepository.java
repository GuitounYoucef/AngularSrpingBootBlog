package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.models.Posts;


@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
