package com.icia.mboard;

import com.icia.mboard.dto.MemberDetailDTO;
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
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

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
    public void testMemberSave(){

        IntStream.rangeClosed(1, 30).forEach(i->{
            MemberSaveDTO memberSaveDTO = new MemberSaveDTO("이메일"+i, "비번"+i, "이름"+i, "전화번호"+i, "프로필"+i);
            ms.saveTest(memberSaveDTO);

            // 되는거 아닌가??
            // IO 예외처리를 try catch 로 한거고
            // 지금 실패나는 이유는 서비스에서 파일을 처리해야 하는데 파일은 없다보니 에러가 난거예요. 그래서 이거는 회원가입 페이지 띄워서 하는게 좋을듯
          /*  MemberSaveDTO memberSaveDTO = new MemberSaveDTO("이메일"+i, "비번"+i, "이름"+i, "전화번호"+i, "프로필"+i);
            try {
                ms.save(memberSaveDTO);
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        });
    }

    @Test
    @Transactional
    @Rollback(value = false)
    @DisplayName("회원전체보기테스트")
    public void MemberFindAllTest(){
        List<MemberDetailDTO> memberList = ms.findAll();

        assertThat(memberList.size()).isEqualTo(30);
    }

    @Test
    @Transactional
    @Rollback
    @DisplayName("회원상세보기테스트")
    public void MemberFindById(){
        String email = "상세보기 이메일";
        String password = "상세보기 비번";
        String name = "상세보기 이름";
        String phone = "상세보기 전화번호";
        String file = "상세보기 프로필사진";

        MemberSaveDTO memberSaveDTO = new MemberSaveDTO(email,password,name,phone,file);
        Long memberSaveId = ms.saveTest(memberSaveDTO);

        MemberDetailDTO memberDetailDTO = ms.findById(memberSaveId);

        assertThat(memberSaveId).isEqualTo(memberDetailDTO.getMemberId());

    }










}
