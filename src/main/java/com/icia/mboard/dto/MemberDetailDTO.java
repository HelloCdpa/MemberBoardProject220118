package com.icia.mboard.dto;

import com.icia.mboard.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDetailDTO {

    private Long memberId;
    private String memberEmail;
    private String memberPassword;
    private String memberName;
    private String memberPhone;
    private String memberProfileName;
    private LocalDateTime memberCreateTime;
    private LocalDateTime memberUpdateTime;

    public static MemberDetailDTO toMemberDetailDTO(MemberEntity memberEntity){
        MemberDetailDTO memberDetailDTO = new MemberDetailDTO();
        memberEntity.setMemberName(memberEntity.getMemberName());
        memberEntity.setMemberPhone(memberEntity.getMemberPhone());
        memberEntity.setMemberEmail(memberEntity.getMemberEmail());
        memberEntity.setMemberPassword(memberEntity.getMemberPassword());
        memberEntity.setMemberProfileName(memberDetailDTO.getMemberProfileName());

        return memberDetailDTO;

    }





}
