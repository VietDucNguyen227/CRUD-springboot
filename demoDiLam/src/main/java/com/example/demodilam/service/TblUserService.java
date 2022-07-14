package com.example.demodilam.service;

import com.example.demodilam.model.TblUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface TblUserService {

    List<TblUser> getAllUser();

    void saveUser(TblUser user);

    void deleteUser(Long id);

    Optional<TblUser> findUserByID(Long id);

    public TblUser getOne(Long id);
}
