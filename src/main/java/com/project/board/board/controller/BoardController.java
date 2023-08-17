package com.project.board.board.controller;

import com.project.board.board.dto.BoardPatchDto;
import com.project.board.board.dto.BoardPostDto;
import com.project.board.board.dto.BoardResponseDto;
import com.project.board.board.entity.Board;
import com.project.board.board.mapper.BoardMapper;
import com.project.board.board.service.BoardService;
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
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    private final BoardMapper boardMapper;

    /* 게시글 등록 */
    @PostMapping
    public ResponseEntity postBoard(@Valid @RequestBody BoardPostDto requestBody) {

        Board board = boardService.createBoard(boardMapper.postDtoToBoard(requestBody));
        BoardResponseDto boardResponseDto = boardMapper.boardToBoardResponseDto(board);

        return new ResponseEntity<>(boardResponseDto, HttpStatus.CREATED);
    }

    /* 게시글 수정 */
    @PatchMapping("/{boardId}")
    public ResponseEntity patchBoard(@PathVariable("boardId") @Positive Long boardId,
                                     @RequestBody @Valid BoardPatchDto requestBody) {

        requestBody.setBoardId(boardId);

        Board board = boardService.updateBoard(boardMapper.patchDtoToBoard(requestBody));
        BoardResponseDto boardResponseDto = boardMapper.boardToBoardResponseDto(board);

        return new ResponseEntity<>(boardResponseDto, HttpStatus.OK);
    }

    /* 게시글 단건 조회 */
    @GetMapping("/{boardId}")
    public ResponseEntity getBoard(@PathVariable("boardId") @Positive Long boardId) {
        Board board = boardService.findBoard(boardId);
        return new ResponseEntity<>(boardMapper.boardToBoardResponseDto(board), HttpStatus.OK);
    }

    /* 게시글 삭제 */
    @DeleteMapping("/{boardId}")
    public ResponseEntity deleteBoard(@PathVariable("boardId") @Positive Long boardId) {
        boardService.deleteBoard(boardId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
