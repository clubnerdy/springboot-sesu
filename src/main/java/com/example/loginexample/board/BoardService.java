package com.example.loginexample.board;


import com.example.loginexample.user.UserRepository;
import com.example.loginexample.user.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    @Transactional
    public void 글쓰기(BoardRequest.SaveDTO saveDTO, int userId) {
        boardRepository.save(saveDTO.getTitle(), saveDTO.getContent(), userId);
    }

    public List<Board> 글목록보기() {
        List<Board> boardList = boardRepository.findAll();
        return boardList;
    }

    public BoardResponse.DetailDTO 글상세보기(int boardId) {
        Board board = boardRepository.findById(boardId);
        BoardResponse.DetailDTO detailDTO = new BoardResponse.DetailDTO(board.getId(), board.getTitle(), board.getContent(), userRepository.findById(board.getUserId()).getUsername());
        return detailDTO;
    }

    @Transactional
    public void 글삭제(int boardId) {
        Board board = boardRepository.findById(boardId);
        if(board == null) throw new RuntimeException("해당하는 글이 없습니다.");
        boardRepository.deleteById(boardId);
    }

    @Transactional
    public void 글수정(int boardId, BoardRequest.UpdateDTO updateDTO) {
        Board board = boardRepository.findById(boardId);
        if(board == null) throw new RuntimeException("해당하는 글이 없습니다.");
        boardRepository.updateById(updateDTO.getTitle(), updateDTO.getContent(), boardId);
    }


    public BoardResponse.UpdateDTO 글수정화면(int boardId) {
        Board board = boardRepository.findById(boardId);
        if(board == null) throw new RuntimeException("해당하는 글이 없습니다.");
        return new BoardResponse.UpdateDTO(board.getId(), board.getTitle(), board.getContent());
    }
}
