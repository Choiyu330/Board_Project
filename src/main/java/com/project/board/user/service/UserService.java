package com.project.board.user.service;

import com.project.board.exception.BusinessLogicException;
import com.project.board.exception.ExceptionCode;
import com.project.board.user.entity.User;
import com.project.board.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    /* 회원 등록 */
    public User createUser(User user) {
        verifiedUser(user.getEmail());
        return userRepository.save(user);
    }

    /* 회원 수정 */
    public User updateUser(User user) {
        User findUser = existUser(user.getUserId());

        Optional.ofNullable(user.getNickname())
                .ifPresent(findUser::setNickname);

        Optional.ofNullable(user.getPassword())
                .ifPresent(findUser::setPassword);

        return userRepository.save(findUser);
    }

    /* 회원 단건 조회 */
    public User findUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new BusinessLogicException(ExceptionCode.USER_NOT_FOUND));
    }

    /* 회원 삭제 */
    public void deleteUser(Long userId) {
        User findUser = existUser(userId);
        userRepository.delete(findUser);
    }

    /* 회원 존재 유무 */
    private User existUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new BusinessLogicException(ExceptionCode.USER_NOT_FOUND));
    }
    /* 회원 이메일 중복 확인 */
    private void verifiedUser(String email) {
        Optional<User> findUser = userRepository.findByEmail(email);
        if(findUser.isPresent()) {
            throw new BusinessLogicException(ExceptionCode.USER_EXIST);
        }
    }
}
