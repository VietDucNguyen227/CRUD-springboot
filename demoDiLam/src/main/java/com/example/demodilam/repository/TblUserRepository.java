package com.example.demodilam.repository;

import com.example.demodilam.model.TblUser;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TblUserRepository extends JpaRepository<TblUser, Long> {
    public List<TblUser> findAllByOrderByIdAsc();
    public List<TblUser> findAllByOrderByIdDesc();
    public List<TblUser> findAllByOrderByNameDesc();
}
