package com.example.demodilam.controller;

import com.example.demodilam.model.TblUser;
import com.example.demodilam.service.TblUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TblUserController {
    @Autowired
    TblUserService tblUserService;

    @RequestMapping(value = "/User", method = RequestMethod.GET)
    public ResponseEntity<List<TblUser>> listAllUser(){
        List<TblUser> listUser = tblUserService.getAllUser();
        if (listUser.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<TblUser>>(listUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/User/{id}", method = RequestMethod.GET)
    public ResponseEntity<TblUser> getUserById(@PathVariable("id") Long id){
        TblUser u = tblUserService.getOne(id);
        return new ResponseEntity<TblUser>(u, HttpStatus.OK);
    }

    @RequestMapping(value = "/User", method = RequestMethod.POST)
    public ResponseEntity<TblUser> saveUser(@RequestBody TblUser user){
        tblUserService.saveUser(user);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/User/{id}", method = RequestMethod.PUT)
    public ResponseEntity<TblUser> updateUser(@PathVariable("id") Long id,
                                              @RequestBody TblUser user) {
        TblUser oldUser = tblUserService.getOne(id);
        if (oldUser == null) {
            return ResponseEntity.notFound().build();
        } else {
            oldUser.setName(user.getName());
            oldUser.setEmail(user.getEmail());
            oldUser.setPhone(user.getPhone());
            tblUserService.saveUser(oldUser);
            return ResponseEntity.ok(oldUser);
        }
    }
    @RequestMapping(value = "/User/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<TblUser> deleteUser(@PathVariable("id") Long id){
        Optional<TblUser> _oldUser = tblUserService.findUserByID(id);
        if (_oldUser == null) {
            return ResponseEntity.notFound().build();
        } else {
            tblUserService.deleteUser(id);
            return ResponseEntity.ok().build();
        }
    }

}
