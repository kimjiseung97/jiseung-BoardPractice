package com.study.Controller;

import com.study.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    //게시글 작성 페이지 로딩
    @GetMapping("/write.do")
    public String openWrite(Model model){
        String title = "제목";
        String content = "내용";
        String writer = "홍길동";
        model.addAttribute("t",title);
        model.addAttribute("c",content);
        model.addAttribute("w",writer);
        return "post/write";
    }
}
