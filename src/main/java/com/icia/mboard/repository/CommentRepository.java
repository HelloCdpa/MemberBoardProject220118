package com.icia.mboard.repository;

import com.icia.mboard.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<CommentEntity,Long> {

}
