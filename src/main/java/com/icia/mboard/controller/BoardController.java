package com.icia.mboard.controller;

import com.icia.mboard.dto.BoardSaveDTO;
import com.icia.mboard.dto.MemberSaveDTO;
import com.icia.mboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService bs;

    @GetMapping("/save")
    public String saveForm(Model model){
        model.addAttribute("board",new BoardSaveDTO());
        return "/board/save";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute BoardSaveDTO boardSaveDTO, BindingResult bindingResult)throws IllegalStateException, IOException {
         Long boardId = bs.save(boardSaveDTO);

        return "redirect:/board/";
    }




}
