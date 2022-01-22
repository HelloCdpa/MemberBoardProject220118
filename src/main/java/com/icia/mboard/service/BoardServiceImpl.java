package com.icia.mboard.service;

import com.icia.mboard.common.PagingConst;
import com.icia.mboard.dto.BoardDetailDTO;
import com.icia.mboard.dto.BoardPagingDTO;
import com.icia.mboard.dto.BoardSaveDTO;
import com.icia.mboard.dto.BoardUpdateDTO;
import com.icia.mboard.entity.BoardEntity;
import com.icia.mboard.entity.MemberEntity;
import com.icia.mboard.repository.BoardRepository;
import com.icia.mboard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository br;
    private final MemberRepository mr;

    @Override
    public Long save(BoardSaveDTO boardSaveDTO) throws IllegalStateException, IOException {

        MultipartFile b_file = boardSaveDTO.getBoardFile();
        String b_filename = b_file.getOriginalFilename();
        b_filename = System.currentTimeMillis() + "-" + b_filename;
        // 파일 저장하기
        String savePath = "D:\\development_Phl\\source\\springboot\\MemberBoardProject\\src\\main\\resources\\board_uploadfile\\"+b_filename;
        if(!b_file.isEmpty()) {
            b_file.transferTo(new File(savePath));
        }
        boardSaveDTO.setBoardFileName(b_filename);

        MemberEntity memberEntity = mr.findById(boardSaveDTO.getMemberId()).get();
        BoardEntity boardEntity = BoardEntity.toBoardEntitySave(boardSaveDTO,memberEntity);

        return br.save(boardEntity).getId();
    }

    @Override
    public BoardDetailDTO findById(Long boardId) {
        Optional<BoardEntity> optionalBoard = br.findById(boardId);
        BoardDetailDTO boardDetailDTO = BoardDetailDTO.toBoardDetailDTO(optionalBoard.get());
        return boardDetailDTO;
    }

    @Override
    public Page<BoardPagingDTO> paging(Pageable pageable) {
        int page = pageable.getPageNumber();
        page = (page==1)? 0 : (page-1);

        Page<BoardEntity> boardEntities = br.findAll(PageRequest.of(page, PagingConst.PAGE_LIMIT, Sort.by(Sort.Direction.DESC, "id")));

        Page<BoardPagingDTO> boardList = boardEntities.map(
                board -> new BoardPagingDTO(board.getId(),
                        board.getBoardWriter(),
                        board.getBoardTitle())
        );

        return boardList;
    }

    @Override
    public Long update(BoardUpdateDTO boardUpdateDTO)  throws IllegalStateException, IOException {
        MultipartFile b_file = boardUpdateDTO.getBoardFile();
        String b_filename = b_file.getOriginalFilename();
        b_filename = System.currentTimeMillis() + "-" + b_filename;
        // 파일 저장하기
        String savePath = "D:\\development_Phl\\source\\springboot\\MemberBoardProject\\src\\main\\resources\\board_uploadfile\\"+b_filename;
        if(!b_file.isEmpty()) {
            b_file.transferTo(new File(savePath));
        }
        boardUpdateDTO.setBoardFileName(b_filename);

        MemberEntity memberEntity = mr.findById(boardUpdateDTO.getMemberId()).get();
        BoardEntity boardEntity = BoardEntity.toBoardUpdateEntity(boardUpdateDTO,memberEntity);

        return br.save(boardEntity).getId();

    }
}
