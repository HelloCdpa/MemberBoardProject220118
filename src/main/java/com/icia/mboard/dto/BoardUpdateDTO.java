package com.icia.mboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardUpdateDTO {
    private Long boardId;
    private Long memberId;
    private String boardWriter;
    private String boardPassword;
    private String boardTitle;
    private String boardContents;
    private String boardFileName;
    private MultipartFile boardFile;
}
