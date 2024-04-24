package crud.com.example.crudspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import crud.com.example.crudspring.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long>{
}
