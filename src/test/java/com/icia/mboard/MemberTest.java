package com.icia.mboard;

import com.icia.mboard.dto.MemberSaveDTO;
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

import java.io.IOException;
import java.util.stream.IntStream;

@SpringBootTest
public class MemberTest {
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
    @DisplayName("테스트 회원 30명 등록")
    public void testMemberSave()throws IllegalStateException, IOException  {

        IntStream.rangeClosed(1, 30).forEach(i->{


        });



    }




    @Test
    @Transactional
    @Rollback(value = false)
    @DisplayName("회원댓글작성테스트")
    public void MemberCommentSaveTest(){








    }




}
