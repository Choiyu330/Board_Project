package com.project.board.board.mapper;

import com.project.board.board.dto.BoardPatchDto;
import com.project.board.board.dto.BoardPostDto;
import com.project.board.board.dto.BoardResponseDto;
import com.project.board.board.entity.Board;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BoardMapper {

    Board postDtoToBoard(BoardPostDto requestBody);

    Board patchDtoToBoard(BoardPatchDto requestBody);

    BoardResponseDto boardToBoardResponseDto(Board board);
}
