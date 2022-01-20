package com.icia.mboard.entity;

import com.icia.mboard.dto.MemberDetailDTO;
import com.icia.mboard.dto.MemberSaveDTO;
import com.icia.mboard.dto.MemberUpdateDTO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "member_table")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column
    private String memberEmail;

    @OneToMany(mappedBy = "memberEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<BoardEntity> boardEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "memberEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CommentEntity> commentEntityList = new ArrayList<>();

    @Column
    private String memberPassword;

    @Column
    private String memberName;

    @Column
    private String memberPhone;

    @Column
    private String memberProfileName;

    public static MemberEntity toMemberEntitySave(MemberSaveDTO memberSaveDTO){
        MemberEntity memberEntity = new MemberEntity();

        memberEntity.setMemberEmail(memberSaveDTO.getMemberEmail());
        memberEntity.setMemberPhone(memberSaveDTO.getMemberPhone());
        memberEntity.setMemberName(memberSaveDTO.getMemberName());
        memberEntity.setMemberPassword(memberSaveDTO.getMemberPassword());
        memberEntity.setMemberProfileName(memberSaveDTO.getMemberProfileName());

        return memberEntity;
    }


    public static MemberEntity toMemberUpdateEntity(MemberUpdateDTO memberUpdateDTO){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(memberUpdateDTO.getMemberId());
        memberEntity.setMemberName(memberUpdateDTO.getMemberName());
        memberEntity.setMemberEmail(memberUpdateDTO.getMemberEmail());
        memberEntity.setMemberPassword(memberUpdateDTO.getMemberPassword());
        memberEntity.setMemberPhone(memberUpdateDTO.getMemberPhone());
        memberEntity.setMemberProfileName(memberUpdateDTO.getMemberProfileName());

        return memberEntity;
    }




}
