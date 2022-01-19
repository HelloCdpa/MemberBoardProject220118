package com.icia.mboard.controller;

import com.icia.mboard.dto.MemberDetailDTO;
import com.icia.mboard.dto.MemberLoginDTO;
import com.icia.mboard.dto.MemberSaveDTO;
import com.icia.mboard.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService ms;
    //MemberSaveDTO 에서 유효성검사한 에러를 보여주기 위해 담아감
    @GetMapping("/save")
    public String saveForm(Model model){
        model.addAttribute("member",new MemberSaveDTO());
        return "/member/save";
    }
    //회원가입
    @PostMapping("/save")
    public String save(@Validated @ModelAttribute("member") MemberSaveDTO memberSaveDTO, BindingResult bindingResult) throws IllegalStateException, IOException {
      //유효성을 검증하는 조건문
       if(bindingResult.hasErrors()) {
           return "/member/save";
       }
       // 이메일 중복체크 오류를 던져주는 트라이캐치문
           try {
               ms.save(memberSaveDTO);

           }catch (IllegalStateException e){

               bindingResult.reject("emailCheck",e.getMessage());
               return "/member/save";
           }
           return "redirect:/member/login";

    }



    //유효성검증 결과를 보여주기 위해 모델에 데이터 저장
    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("member",new MemberLoginDTO());
        return "/member/login";
    }
    //로그인 세션값 저장 - 유효성검증 -> 이메일 확인 -> 비밀번호 확인 -> 세션아이디 저장
    @PostMapping("/login")
    public String login(@Validated @ModelAttribute("member") MemberLoginDTO memberLoginDTO,
                        BindingResult bindingResult,HttpSession session){
        if (bindingResult.hasErrors()){
            return "/member/login";
        }

        if(ms.findByEmail(memberLoginDTO)){
            session.setAttribute("loginEmail",memberLoginDTO.getMemberEmail());
            Long loginId = ms.findByMemberId(memberLoginDTO.getMemberEmail());
            session.setAttribute("loginId",loginId);
            System.out.println(loginId);
            return "index";
        }else{
            return "/member/login";
        }

    }
    //전체조회
    @GetMapping("/")
    public String findAll(Model model){
        List<MemberDetailDTO> memberList = ms.findAll();
        model.addAttribute("memberList",memberList);
        return "/member/findAll";
    }

    @GetMapping("{memberId}")
    public String findById(@PathVariable ("memberId") Long memberId,Model model){

       MemberDetailDTO memberDetailDTO = ms.findById(memberId);
       model.addAttribute("member",memberDetailDTO);
       return "/member/findById";
    }






















}
