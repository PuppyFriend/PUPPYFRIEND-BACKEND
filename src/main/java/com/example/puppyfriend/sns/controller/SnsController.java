package com.example.puppyfriend.sns.controller;

import com.example.puppyfriend.sns.dto.GetPostRes;
import com.example.puppyfriend.sns.dto.GetUserSnsRes;
import com.example.puppyfriend.sns.dto.PostReq;
import com.example.puppyfriend.sns.service.SnsService;
import com.example.puppyfriend.util.BaseException;
import com.example.puppyfriend.util.BaseResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sns")
public class SnsController {

    private final SnsService snsService;

    public SnsController(SnsService snsService) {
        this.snsService = snsService;
    }

    //게시글 작성
    @ResponseBody
    @PostMapping("/post")
    public BaseResponse<String> createSnsPost(@RequestBody PostReq postReq) {
        try{
            snsService.createSnsPost(postReq);
            return new BaseResponse<>("게시글 등록 완료");
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

    //특정 사용자 게시글 조회
    @ResponseBody
    @GetMapping("/{userIdx}")
    public BaseResponse<GetUserSnsRes> getUserPosts(@PathVariable int userIdx) {
        try {
            return snsService.getUserPosts(userIdx);
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

    //둘러보기 - 전체
    @ResponseBody
    @GetMapping("/all")
    public BaseResponse<List<GetPostRes.SnsInfo>> getAllSnsPosts() {
        try {
            return snsService.getAllSnsPosts();
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

    //둘러보기 - 고민
    @ResponseBody
    @GetMapping("/worry")
    public BaseResponse<List<GetPostRes.SnsInfo>> getWorryPosts() {
        try {
            return snsService.getWorrySnsPosts();
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }

    //둘러보기 - 질문
    @ResponseBody
    @GetMapping("/question")
    public BaseResponse<List<GetPostRes.SnsInfo>> getQuestionPosts() {
        try {
            return snsService.getQuestionSnsPosts();
        } catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }
}
