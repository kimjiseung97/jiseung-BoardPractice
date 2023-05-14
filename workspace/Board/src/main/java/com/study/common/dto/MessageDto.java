package com.study.common.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;
import java.util.Objects;

@Getter
@AllArgsConstructor
public class MessageDto {

    private String message; //사용자에게 전달할 메시지
    private String redirectUri; //리다이렉트 uri
    private RequestMethod method; //http요청 메서드
    private Map<String, Object> data; //화ㅣ면으로 전달할 데이터 (파라미터)
}
