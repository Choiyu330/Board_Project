package com.project.board.board.service;

import com.project.board.board.entity.Board;
import com.project.board.board.repository.BoardRepository;
import com.project.board.exception.BusinessLogicException;
import com.project.board.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    /* 게시글 생성 */
    public Board createBoard(Board board) {
        boardRepository.save(board);
        return board;
    }

    /* 게시글 수정 */
    public Board updateBoard(Board board) {
        // 게시글 존재 유무 확인
        Board findBoard = existBoard(board.getBoardId());

        Optional.ofNullable(board.getTitle())
                .ifPresent(findBoard::setTitle);

        Optional.ofNullable(board.getContent())
                .ifPresent(findBoard::setContent);

        return boardRepository.save(findBoard);
    }

    /* 게시글 조회 */
    public Board findBoard(Long boardId) {
        return existBoard(boardId);
    }

    /* 게시글 삭제 */
    public void deleteBoard(Long boardId) {
        // 게시글 존재 유무 확인
        Board findBoard = existBoard(boardId);
        boardRepository.delete(findBoard);
    }

    /* 게시글 존재 유무 확인 */
    public Board existBoard(Long boardId) {
        return boardRepository.findById(boardId).orElseThrow(() -> new BusinessLogicException(ExceptionCode.BOARD_NOT_FOUND));
    }
}
