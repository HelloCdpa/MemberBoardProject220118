package com.icia.mboard.controller;

import com.icia.mboard.dto.CommentDetailDTO;
import com.icia.mboard.dto.CommentSaveDTO;
import com.icia.mboard.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService cs;

    @PostMapping("/save")
    public @ResponseBody
    List<CommentDetailDTO> save (@ModelAttribute CommentSaveDTO commentSaveDTO, Model model){
        //저장
        cs.save(commentSaveDTO);
        //리스트로 전체 댓글 가져오기
        List<CommentDetailDTO> commentList = cs.findAll(commentSaveDTO.getBoardId());
        model.addAttribute("commentList",commentList);
        return commentList;
    }

    @GetMapping("/{boardId}")
    public @ResponseBody List<CommentDetailDTO> findAll(@PathVariable ("boardId") Long boardId, Model model,@ModelAttribute CommentDetailDTO commentDetailDTO){
        List<CommentDetailDTO> commentList = cs.findAll(commentDetailDTO.getBoardId());
        model.addAttribute("commentList",commentList);
        return commentList;
    }




    @DeleteMapping("/{commentId}")
    public ResponseEntity deleteById(@PathVariable ("commentId") Long commentId){
        System.out.println("commentId = " + commentId);
        cs.deleteById(commentId);

        return new ResponseEntity(HttpStatus.OK);
    }


}
