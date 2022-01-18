package com.icia.mboard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDetailDTO {
    private Long commentId;
    private Long boardId;
    private Long memberId;
    private String commentWriter;
    private String commentContents;

    private LocalDateTime commentCreateDate;
    private LocalDateTime commentUpdateDate;

}
