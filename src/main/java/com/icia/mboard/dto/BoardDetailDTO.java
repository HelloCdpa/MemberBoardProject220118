package com.icia.mboard.dto;

import com.icia.mboard.entity.BaseEntity;
import com.icia.mboard.entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDetailDTO {
    private Long boardId;
    private Long memberId;
    private String boardWriter;
    private String boardPassword;
    private String boardTitle;
    private String boardContents;
    private String boardFileName;
    private LocalDateTime CreateBoardDate;
    private LocalDateTime UpdateBoardDate;

    public static BoardDetailDTO toBoardDetailDTO(BoardEntity boardEntity){
        BoardDetailDTO boardDetailDTO = new BoardDetailDTO();
        boardDetailDTO.setBoardWriter(boardEntity.getBoardWriter());
        boardDetailDTO.setBoardPassword(boardEntity.getBoardPassword());
        boardDetailDTO.setBoardTitle(boardEntity.getBoardTitle());
        boardDetailDTO.setBoardContents(boardEntity.getBoardContents());
        boardDetailDTO.setBoardFileName(boardEntity.getBoardFileName());

        return boardDetailDTO;

    }

}
