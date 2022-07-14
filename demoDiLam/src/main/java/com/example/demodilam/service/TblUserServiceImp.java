package com.example.demodilam.service;

import com.example.demodilam.model.TblUser;
import com.example.demodilam.repository.TblUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TblUserServiceImp implements TblUserService{
    @Autowired
    private TblUserRepository tblUserRepository;

    @Override
    public List<TblUser> getAllUser() {
       return tblUserRepository.findAll();
    }

    @Override
    public void saveUser(TblUser user) {
        tblUserRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        tblUserRepository.deleteById(id);
    }

    @Override
    public Optional<TblUser> findUserByID(Long id) {
        return tblUserRepository.findById(id);
    }

    @Override
    public TblUser getOne(Long id) {
        return tblUserRepository.findById(id).get();
    }
}
