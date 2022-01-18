package com.icia.mboard.entity;

import com.icia.mboard.dto.BoardDetailDTO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "board_table")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_table")
    private MemberEntity memberEntity;

    @OneToMany(mappedBy = "boardEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentEntity> commentEntityList = new ArrayList<>();

    @Column
    private String boardWriter;

    @Column
    @Length(min = 2,max = 20)
    private String boardPassword;

    @Column
    private String boardTitle;

    @Column
    private String boardContents;

    @Column
    private String boardFileName;

    public static BoardEntity toBoardEntity(BoardDetailDTO boardDetailDTO, MemberEntity memberEntity){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardWriter(memberEntity.getMemberEmail());
        boardEntity.setBoardTitle(boardDetailDTO.getBoardTitle());
        boardEntity.setBoardContents(boardDetailDTO.getBoardContents());
        boardEntity.setBoardPassword(boardDetailDTO.getBoardPassword());
        boardEntity.setBoardFileName(boardDetailDTO.getBoardFileName());

        return boardEntity;
    }


}
