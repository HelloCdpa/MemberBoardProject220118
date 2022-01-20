package com.icia.mboard.entity;

import com.icia.mboard.dto.CommentDetailDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "comment_table")
public class CommentEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_table")
    private BoardEntity boardEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_table")
    private MemberEntity memberEntity;

    @Column
    private String commentWriter;

    @Column
    private String commentContents;

    public static CommentEntity toCommentEntity(CommentDetailDTO commentDetailDTO, BoardEntity boardEntity, MemberEntity memberEntity){
        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setBoardEntity(boardEntity);
        commentEntity.setMemberEntity(memberEntity);
        commentEntity.setCommentWriter(memberEntity.getMemberEmail());
        commentEntity.setCommentContents(commentDetailDTO.getCommentContents());
        return commentEntity;
    }




}
