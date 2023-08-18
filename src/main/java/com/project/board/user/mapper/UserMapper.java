package com.project.board.user.mapper;

import com.project.board.user.dto.UserPatchDto;
import com.project.board.user.dto.UserPostDto;
import com.project.board.user.dto.UserResponseDto;
import com.project.board.user.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User postDtoToUser(UserPostDto requestBody);

    User patchDtoToUser(UserPatchDto requestBody);

    UserResponseDto userToUserResponseDto(User user);
}
