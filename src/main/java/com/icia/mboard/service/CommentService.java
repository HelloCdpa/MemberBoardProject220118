package com.icia.mboard.service;

import com.icia.mboard.dto.CommentDetailDTO;
import com.icia.mboard.dto.CommentSaveDTO;

import java.util.List;

public interface CommentService {
    Long save(CommentSaveDTO commentSaveDTO);

    List<CommentDetailDTO> findAll(Long boardId);
}
