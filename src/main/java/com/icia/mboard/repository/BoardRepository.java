package com.icia.mboard.repository;


import com.icia.mboard.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepository extends JpaRepository<BoardEntity,Long> {
    Page<BoardEntity> findByBoardTitleContainingIgnoreCase(String keyword, Pageable paging);
    Page<BoardEntity> findByBoardWriterContainingIgnoreCase(String keyword,Pageable paging);
}

