package com.study.Controller;

import com.study.Service.PostService;
import com.study.domain.post.PostRequest;
import com.study.domain.post.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    //게시글 작성 페이지 로딩
    @GetMapping("/write.do")
    public String openWrite(@RequestParam(value = "id", required = false) final Long id, Model model){
        if(id!=null){
            PostResponse post = postService.findById(id);
            model.addAttribute("post",post);
        }
        return "post/write";
    }

    //신규 게시글 생성
    @PostMapping("/save.do")
        public String savePost(final PostRequest params){
            postService.savePost(params);
            return "redirect:/post/list";
        }

    // 게시글 리스트 페이지
    @GetMapping("/list.do")
    public String openPostList(Model model) {
        List<PostResponse> posts = postService.findAllPost();
        model.addAttribute("posts", posts);
        return "post/list";
    }

}

