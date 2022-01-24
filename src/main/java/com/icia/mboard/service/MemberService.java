package com.icia.mboard.service;

import com.icia.mboard.dto.MemberDetailDTO;
import com.icia.mboard.dto.MemberLoginDTO;
import com.icia.mboard.dto.MemberSaveDTO;
import com.icia.mboard.dto.MemberUpdateDTO;

import java.io.IOException;
import java.util.List;

public interface MemberService {
    Long save(MemberSaveDTO memberSaveDTO) throws IllegalStateException, IOException;

    boolean findByEmail(MemberLoginDTO memberLoginDTO);

    List<MemberDetailDTO> findAll();

    MemberDetailDTO findById(Long memberId);

    Long findByMemberId(String memberEmail);

    String emailDuplication(String memberEmail);

    void deleteById(Long memberId);


    void update(MemberUpdateDTO memberUpdateDTO) throws IllegalStateException, IOException;

    public Long saveTest(MemberSaveDTO memberSaveDTO);
}

