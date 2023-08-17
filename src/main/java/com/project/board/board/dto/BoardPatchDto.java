package com.project.board.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardPatchDto {
/*
    TODO: userId 주석해제
    private Long userId;
*/
    private Long boardId;

    private String title;

    private String content;
}
