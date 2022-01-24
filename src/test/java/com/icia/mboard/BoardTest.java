package com.icia.mboard;

import com.icia.mboard.dto.BoardSaveDTO;
import com.icia.mboard.entity.BoardEntity;
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

import java.util.stream.IntStream;

@SpringBootTest
public class BoardTest {

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
        IntStream.rangeClosed(1,30).forEach(i->{
            BoardSaveDTO boardSaveDTO = new BoardSaveDTO((long) i,"작성자"+i, "비번"+i, "제목"+i, "내용"+i,"파일이름"+i);
            bs.saveTest(boardSaveDTO);
        });

    }







}
