package com.icia.mboard.dto;

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
    private LocalDateTime boardCreateDate;
    private LocalDateTime boardUpdateDate;

}
