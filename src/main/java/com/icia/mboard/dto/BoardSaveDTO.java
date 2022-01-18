package com.icia.mboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardSaveDTO {

    private String boardWriter;
    private String boardPassword;
    private String boardTitle;
    private String boardContents;
    private String boardFileName;

}
