package com.project.board.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPatchDto {

    private Long userId;

    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&]).{8,16}", message = "비밀번호는 영문, 특수문자, 숫자 포함 8-16자 이내여야 합니다.")
    private String password;

    @Size(min = 1, max = 16)
    private String nickname;
}
