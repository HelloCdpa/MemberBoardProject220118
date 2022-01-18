package com.icia.mboard.entity;

import com.icia.mboard.dto.MemberDetailDTO;
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
    @UniqueElements
    @Length(min = 6, max = 30)
    private String memberEmail;

    @OneToMany(mappedBy = "memberEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<BoardEntity> boardEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "memberEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CommentEntity> commentEntityList = new ArrayList<>();

    @Column
    @Length(min = 8, max = 50)
    private String memberPassword;

    @Column
    private String memberName;

    @Column
    private String memberPhone;

    @Column
    private String memberProfileName;

    public static MemberEntity toMemberEntity(MemberDetailDTO memberDetailDTO){
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberEmail(memberDetailDTO.getMemberEmail());
        memberEntity.setMemberPassword(memberDetailDTO.getMemberPassword());
        memberEntity.setMemberName(memberDetailDTO.getMemberName());
        memberEntity.setMemberPhone(memberDetailDTO.getMemberPhone());
        memberEntity.setMemberProfileName(memberDetailDTO.getMemberProfileName());

        return memberEntity;
    }




}
