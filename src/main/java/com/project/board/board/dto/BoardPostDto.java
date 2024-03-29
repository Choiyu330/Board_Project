package com.project.board.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardPostDto {

    @NotBlank(message = "게시글 제목을 입력해주세요")
    private String title;

    @NotBlank(message = "게시글 내용을 입력해주세요")
    private String content;

}
