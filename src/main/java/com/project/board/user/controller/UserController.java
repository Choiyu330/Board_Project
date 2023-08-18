package com.project.board.user.controller;

import com.project.board.user.dto.UserPatchDto;
import com.project.board.user.dto.UserPostDto;
import com.project.board.user.dto.UserResponseDto;
import com.project.board.user.entity.User;
import com.project.board.user.mapper.UserMapper;
import com.project.board.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    
    private final UserService userService;
    private final UserMapper userMapper;
    
    /* 회원 등록 */
    @PostMapping
    public ResponseEntity postUser(@Valid @RequestBody UserPostDto requestBody) {

        User user = userService.createUser(userMapper.postDtoToUser(requestBody));
        UserResponseDto userResponseDto = userMapper.userToUserResponseDto(user);

        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

    /* 회원 수정 */
    @PatchMapping("/{userId}")
    public ResponseEntity patchUser(@PathVariable("userId") @Positive Long userId,
                                    @RequestBody @Valid UserPatchDto requestBody) {

        requestBody.setUserId(userId);

        User user = userService.updateUser(userMapper.patchDtoToUser(requestBody));
        UserResponseDto userResponseDto = userMapper.userToUserResponseDto(user);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    /* 회원 단건 조회 */
    @GetMapping("/{userId}")
    public ResponseEntity getUser(@PathVariable("userId") @Positive Long userId) {
        User user = userService.findUser(userId);
        return new ResponseEntity<>(userMapper.userToUserResponseDto(user), HttpStatus.OK);
    }

    /* 회원 탈퇴 */
    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser(@PathVariable("userId") @Positive Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
