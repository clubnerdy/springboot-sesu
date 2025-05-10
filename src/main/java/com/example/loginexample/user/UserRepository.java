package com.example.loginexample.user;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepository {
    private final EntityManager em;

    public void save(String username, String password, String email) {
        Query query = em.createNativeQuery("insert into user_tb (username, password, email, created_at) values (?, ?, ?, now())");
        query.setParameter(1, username);
        query.setParameter(2, password);
        query.setParameter(3, email);
        query.executeUpdate();
    }

    public User findByUsername(String username) {
        Query query = em.createNativeQuery("select * from user_tb where username = ?", User.class);
        query.setParameter(1, username);
        return (User) query.getSingleResult();
    }

    public User findById(int userId) {
        Query query = em.createNativeQuery("select * from user_tb where id = ?", User.class);
        query.setParameter(1, userId);
        return (User) query.getSingleResult();
    }

    public User updateById(String password, String email, int userId) {
        Query q = em.createNativeQuery("update user_tb set password = ?, email = ? where id = ?");
        q.setParameter(1, password);
        q.setParameter(2, email);
        q.setParameter(3, userId);
        q.executeUpdate();
        return findById(userId);
    }
}
