package com.icia.mboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardSaveDTO {

    private Long memberId;
    private String boardWriter;
    private String boardPassword;
    private String boardTitle;
    private String boardContents;
    private String boardFileName;
    private MultipartFile boardFile;

    public BoardSaveDTO(Long memberId, String boardWriter, String boardPassword, String boardTitle, String boardContents, String boardFileName) {
        this.memberId = memberId;
        this.boardWriter = boardWriter;
        this.boardPassword = boardPassword;
        this.boardTitle = boardTitle;
        this.boardContents = boardContents;
        this.boardFileName = boardFileName;
    }
}
