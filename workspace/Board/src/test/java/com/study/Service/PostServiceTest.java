package com.study.Service;

import com.study.domain.post.PostRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceTest {
    
    @Autowired
    PostService postService;
    
    @Test
    void saveTest(){
        PostRequest postRequest = new PostRequest();
        postRequest.setTitle("1번 게시글 제목");
        postRequest.setContent("1번 게시글 내용");
        postRequest.setWriter("테스터");
        postRequest.setNoticeYn(false);
        Long id = postService.savePost(postRequest);
        System.out.println("id = " + id);
    }
    
    @Test
    void DeleteTest(){
        Long aLong = postService.deletePost(2L);
        System.out.println("aLong = " + aLong);
    }

}