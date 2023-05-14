package com.study.Controller;

import com.study.Service.PostService;
import com.study.common.dto.MessageDto;
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
        public String savePost(final PostRequest params,Model model){
            postService.savePost(params);
        MessageDto message = new MessageDto("게시글 생성이 완료되었습니다.", "/post/list.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
        }

    // 게시글 리스트 페이지
    @GetMapping("/list.do")
    public String openPostList(Model model) {
        List<PostResponse> posts = postService.findAllPost();
        model.addAttribute("posts", posts);
        return "post/list";
    }
    //게시글 상세 페이지
    @GetMapping("/view.do")
    public String openPostView(@RequestParam final Long id, Model model){
        PostResponse post = postService.findById(id);
        model.addAttribute("post",post);
        return "post/view";
    }

    //기존 게시글 수정
    @PostMapping("/update.do")
    public String updatePost(final PostRequest params,Model model){
        postService.UpdateById(params);
        MessageDto message = new MessageDto("게시글 수정이 완료되었습니다.", "/post/list.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    //게시글 삭제하기
    @PostMapping("/delete.do")
    public String deletePost(@RequestParam final Long id, Model model){
        postService.deletePost(id);
        MessageDto message = new MessageDto("게시글 삭제가 완료되었습니다.", "/post/list.do", RequestMethod.GET, null);
        return showMessageAndRedirect(message, model);
    }

    //사용자에게 메시지를 전달하고 페이지를 리다이렉트한다
    private String showMessageAndRedirect(final MessageDto params, Model model){
        model.addAttribute("params",params);
        return "common/messageRedirect";
    }


}

