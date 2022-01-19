package com.icia.mboard.service;

import com.icia.mboard.dto.BoardSaveDTO;
import com.icia.mboard.dto.MemberSaveDTO;
import com.icia.mboard.entity.BoardEntity;
import com.icia.mboard.entity.MemberEntity;
import com.icia.mboard.repository.BoardRepository;
import com.icia.mboard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

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
}
