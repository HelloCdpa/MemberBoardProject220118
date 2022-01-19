package com.icia.mboard.service;

import com.icia.mboard.dto.MemberDetailDTO;
import com.icia.mboard.dto.MemberLoginDTO;
import com.icia.mboard.dto.MemberSaveDTO;
import com.icia.mboard.entity.MemberEntity;
import com.icia.mboard.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepository mr;
    //엔티티로 저장
    @Override
    public Long save(MemberSaveDTO memberSaveDTO)throws IllegalStateException, IOException {
        // 프로필 사진 저장하기 파일 -> 이름
        MultipartFile m_file = memberSaveDTO.getMemberProfile();
        String m_filename = m_file.getOriginalFilename();
        m_filename = System.currentTimeMillis() + "-" + m_filename;
        // 파일 저장하기
        String savePath = "D:\\development_Phl\\source\\springboot\\MemberBoardProject\\src\\main\\resources\\member_uploadfile\\"+m_filename;
        if(!m_file.isEmpty()) {
            m_file.transferTo(new File(savePath));
        }
        memberSaveDTO.setMemberProfileName(m_filename);

        MemberEntity memberEntity = MemberEntity.toMemberEntitySave(memberSaveDTO);
        MemberEntity emailCheck = mr.findByMemberEmail(memberSaveDTO.getMemberEmail());

        if (emailCheck != null){
            throw new IllegalStateException("중복된 이메일 입니다!");
        }
        return mr.save(memberEntity).getId();
    }
    //이메일, 비밀번호 체크
    @Override
    public boolean findByEmail(MemberLoginDTO memberLoginDTO) {
        MemberEntity memberEntity = mr.findByMemberEmail(memberLoginDTO.getMemberEmail());
        if(memberEntity!=null){
            if(memberEntity.getMemberPassword().equals(memberLoginDTO.getMemberPassword())){
                return true;
            }else {
            return false;
            }
        }else {
        return false;
        }
    }
    //반복문으로 DTOList 에 Entity dto 로 변환한 값 담기
    @Override
    public List<MemberDetailDTO> findAll() {
        List<MemberEntity> memberEntityList = mr.findAll();
        List <MemberDetailDTO> memberList = new ArrayList<>();
        for (MemberEntity e : memberEntityList){
            memberList.add(MemberDetailDTO.toMemberDetailDTO(e));
        }
        return memberList;
    }

    @Override
    public MemberDetailDTO findById(Long memberId) {
        Optional<MemberEntity> memberEntityOptional = mr.findById(memberId);
        MemberEntity memberEntity = memberEntityOptional.get();
        MemberDetailDTO memberDetailDTO = MemberDetailDTO.toMemberDetailDTO(memberEntity);

        return memberDetailDTO;
    }

    @Override
    public Long findByMemberId(String memberEmail) {
        MemberEntity memberEntity = mr.findByMemberEmail(memberEmail);
        Long memberId = memberEntity.getId();
        return memberId;
    }
}
