package com.migrad.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {
    private String subject;
    private String content;
    private String userName;
    private Long parentPostId;
}
