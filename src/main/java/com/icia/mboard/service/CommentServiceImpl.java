package com.icia.mboard.service;

import com.icia.mboard.dto.CommentDetailDTO;
import com.icia.mboard.dto.CommentSaveDTO;
import com.icia.mboard.entity.BoardEntity;
import com.icia.mboard.entity.CommentEntity;
import com.icia.mboard.entity.MemberEntity;
import com.icia.mboard.repository.BoardRepository;
import com.icia.mboard.repository.CommentRepository;
import com.icia.mboard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final CommentRepository cr;
    private final BoardRepository br;
    private final MemberRepository mr;

    //댓글 저장 참조하는 키들의 데이터를 가져와서 활용
    @Override
    public Long save(CommentSaveDTO commentSaveDTO) {
        BoardEntity boardEntity = br.findById(commentSaveDTO.getBoardId()).get();
        MemberEntity memberEntity = mr.findById(commentSaveDTO.getMemberId()).get();
        CommentEntity commentEntity = CommentEntity.toCommentEntity(commentSaveDTO, boardEntity, memberEntity);
        return cr.save(commentEntity).getId();
    }

    @Override
    public List<CommentDetailDTO> findAll(Long boardId) {
        BoardEntity boardEntity = br.findById(boardId).get();
        List<CommentEntity> commentEntityList = boardEntity.getCommentEntityList();
        List<CommentDetailDTO> commentList = new ArrayList<>();
        for(CommentEntity c: commentEntityList){
            CommentDetailDTO commentDetailDTO = CommentDetailDTO.toCommentDetail(c);
            commentList.add(commentDetailDTO);
        }

        return commentList;

    }

    @Override
    public void deleteById(Long commentId) {
        br.deleteById(commentId);
    }


}
