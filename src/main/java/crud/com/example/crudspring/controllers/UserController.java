package crud.com.example.crudspring.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import crud.com.example.crudspring.DTO.UserDTO;

import crud.com.example.crudspring.services.UserService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("api/user")
public class UserController {

   
    final private UserService _userService;

    public UserController(UserService UserService){
        this._userService = UserService;
    }

    @GetMapping()   
    public ResponseEntity<List<UserDTO>> getUser(){
        return new ResponseEntity<>(this._userService.list(),HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<List<UserDTO>> createUser(@Valid @RequestBody UserDTO UserDTO) {
        
        return new ResponseEntity<>(this._userService.createUser(UserDTO),HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<List<UserDTO>> updateUser(@PathVariable long id,@RequestBody UserDTO UserDTO) {
        
        return new ResponseEntity<>(this._userService.updateUser(id,UserDTO),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<List<UserDTO>> deleteUser(@PathVariable("id") Long id){
        return new ResponseEntity<>(this._userService.deleteUser(id),HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(this._userService.findByIdUser(id),HttpStatus.OK);
    }
    
}
