package com.icia.mboard.entity;

import com.icia.mboard.dto.BoardDetailDTO;
import com.icia.mboard.dto.BoardSaveDTO;
import com.icia.mboard.dto.BoardUpdateDTO;
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
public class BoardEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
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


    public static BoardEntity toBoardEntitySave(BoardSaveDTO boardSaveDTO, MemberEntity memberEntity){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setMemberEntity(memberEntity);
        boardEntity.setBoardWriter(boardSaveDTO.getBoardWriter());
        boardEntity.setBoardPassword(boardSaveDTO.getBoardPassword());
        boardEntity.setBoardTitle(boardSaveDTO.getBoardTitle());
        boardEntity.setBoardContents(boardSaveDTO.getBoardContents());
        boardEntity.setBoardFileName(boardSaveDTO.getBoardFileName());

        return boardEntity;


    }



    public static BoardEntity toBoardUpdateEntity(BoardUpdateDTO boardUpdateDTO, MemberEntity memberEntity){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setId(boardUpdateDTO.getBoardId());
        boardEntity.setMemberEntity(memberEntity);

        boardEntity.setBoardWriter(memberEntity.getMemberEmail());
        boardEntity.setBoardTitle(boardUpdateDTO.getBoardTitle());
        boardEntity.setBoardContents(boardUpdateDTO.getBoardContents());
        boardEntity.setBoardPassword(boardUpdateDTO.getBoardPassword());
        boardEntity.setBoardFileName(boardUpdateDTO.getBoardFileName());

        return boardEntity;
    }


}
