package crud.com.example.crudspring.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import crud.com.example.crudspring.DTO.UserDTO;
import crud.com.example.crudspring.exceptions.BadRequestException;

import crud.com.example.crudspring.mapper.UserMapper;
import crud.com.example.crudspring.repositories.UserRepository;



@Service
public class UserService {
    
private final UserMapper _UserMapper;   
private final UserRepository _UserRepository;

 public UserService( UserRepository UserRepository, UserMapper UserMapper){
    this._UserRepository = UserRepository;
    this._UserMapper = UserMapper;
 }

 
public List<UserDTO> list(){
Sort sort = Sort.by("name").descending().and(Sort.by("age").ascending());
return this._UserRepository.findAll(sort)
.stream()
.map(user -> _UserMapper.entityToDto(user))
.collect(Collectors.toList());

  
}

public List<UserDTO> createUser(UserDTO userDTO){   

   
    this._UserRepository.save(_UserMapper.dtoToEntity(userDTO));
    
    return list();
 }

 public List<UserDTO> deleteUser(Long id){
   this._UserRepository.findById(id).ifPresentOrElse((user) -> {
      _UserRepository.delete(user);
   }, ()->{
    throw new BadRequestException("User Id not exist".formatted(id));
   });
   
   return list();
}



public UserDTO findByIdUser(Long id){
  
   if(this._UserRepository.findById(id).isEmpty()){
      throw new BadRequestException("User not found".formatted(id));
   }

   return this._UserRepository.findById(id).map(user -> _UserMapper.entityToDto(user)).get();
}

public List<UserDTO> updateUser(long id,UserDTO userDTO){
   this._UserRepository.findById(id).ifPresentOrElse((user)->{
      
      this._UserRepository.save(_UserMapper.dtoToEntity(userDTO));
   },()->{
      throw new BadRequestException("User id Not Exist".formatted(id));
   });
   
   return list();
}
 
}
