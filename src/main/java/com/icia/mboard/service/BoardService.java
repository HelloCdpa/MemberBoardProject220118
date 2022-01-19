package com.icia.mboard.service;

import com.icia.mboard.dto.BoardSaveDTO;

import java.io.IOException;

public interface BoardService {
    Long save(BoardSaveDTO boardSaveDTO)throws IllegalStateException, IOException;
}
