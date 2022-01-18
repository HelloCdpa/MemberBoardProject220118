package com.icia.mboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentSaveDTO {

    private String commentWriter;
    private String commentContents;

}
