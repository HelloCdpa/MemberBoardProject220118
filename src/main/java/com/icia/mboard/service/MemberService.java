package com.icia.mboard.service;

import com.icia.mboard.dto.MemberDetailDTO;
import com.icia.mboard.dto.MemberLoginDTO;
import com.icia.mboard.dto.MemberSaveDTO;

import java.io.IOException;
import java.util.List;

public interface MemberService {
    Long save(MemberSaveDTO memberSaveDTO) throws IllegalStateException, IOException;

    boolean findByEmail(MemberLoginDTO memberLoginDTO);

    List<MemberDetailDTO> findAll();
}

