package com.example.loginexample.board;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class BoardRepository {
    private final EntityManager em;


    public void save(String title, String content, int userId) {
        Query query = em.createNativeQuery("insert into board_tb(title, content, user_id, created_at) values(?, ?, ?, now())");
        query.setParameter(1, title);
        query.setParameter(2, content);
        query.setParameter(3, userId);
        query.executeUpdate();
    }

    public List<Board> findAll() {
        Query query = em.createNativeQuery("select * from board_tb order by id desc", Board.class);
        List<Board> boardList = query.getResultList();
        return boardList;
    }

    public Board findById(int boardId) {
        Query query = em.createNativeQuery("select * from board_tb where id = ?", Board.class);
        query.setParameter(1, boardId);
        return (Board) query.getSingleResult();
    }

    public void deleteById(int boardId) {
        Query query = em.createNativeQuery("delete from board_tb where id = ?");
        query.setParameter(1, boardId);
        query.executeUpdate();
    }

    public void updateById(String title, String content, int boardId) {
        Query q = em.createNativeQuery("update board_tb set title = ?, content = ? where id = ?");
        q.setParameter(1, title);
        q.setParameter(2, content);
        q.setParameter(3, boardId);
        q.executeUpdate();
    }
}
