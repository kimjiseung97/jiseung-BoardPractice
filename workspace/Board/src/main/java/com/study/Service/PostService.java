package com.study.Service;

import com.study.domain.post.PostMapper;
import com.study.domain.post.PostRequest;
import com.study.domain.post.PostResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;


    //게시글 등록기능
    @Transactional
    public Long savePost(final PostRequest params){
        postMapper.save(params);
        return params.getId();
    }

    //게시글 상세정보 조회
    public PostResponse findById(final Long id){
        return postMapper.findById(id);
    }

    //게시글 수정

    @Transactional
    public Long UpdateById(final PostRequest params){
        postMapper.update(params);
        return params.getId();
    }

    //게시글 삭제
    public Long deletePost(final Long id){
        postMapper.deleteById(id);
        return id;
    }

    //게시글 리스트 조회
    public List<PostResponse> findAllPost(){
        return postMapper.findAll();
    }


}
