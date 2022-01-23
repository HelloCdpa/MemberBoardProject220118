package com.icia.mboard.service;

import com.icia.mboard.dto.BoardDetailDTO;
import com.icia.mboard.dto.BoardPagingDTO;
import com.icia.mboard.dto.BoardSaveDTO;
import com.icia.mboard.dto.BoardUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.List;

public interface BoardService {
    Long save(BoardSaveDTO boardSaveDTO)throws IllegalStateException, IOException;

    BoardDetailDTO findById(Long boardId);

    Page<BoardPagingDTO> paging(Pageable pageable);

    Long update(BoardUpdateDTO boardUpdateDTO) throws IllegalStateException, IOException ;

    void deleteById(Long boardId);


    Page<BoardPagingDTO> search(String type, String keyword,Pageable pageable);
}
