package com.icia.mboard;

import com.icia.mboard.dto.CommentSaveDTO;
import com.icia.mboard.repository.BoardRepository;
import com.icia.mboard.repository.CommentRepository;
import com.icia.mboard.repository.MemberRepository;
import com.icia.mboard.service.BoardService;
import com.icia.mboard.service.CommentService;
import com.icia.mboard.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CommentTest {
    @Autowired
    private MemberService ms;
    @Autowired
    private CommentService cs;
    @Autowired
    private BoardService bs;

    @Autowired
    private MemberRepository mr;
    @Autowired
    private CommentRepository cr;
    @Autowired
    private BoardRepository br;


    @Test
    @Transactional
    @Rollback(value = false)
    @DisplayName("회원댓글작성테스트")
    public void MemberCommentSaveTest(){
        long boardId = 1;
        long memberId = 1;

        String commentWriter = "commentWriter";
        String commentContents = "commentContents";
        CommentSaveDTO commentSaveDTO = new CommentSaveDTO(boardId,memberId,commentWriter,commentContents);
        cs.save(commentSaveDTO);
    }
}
