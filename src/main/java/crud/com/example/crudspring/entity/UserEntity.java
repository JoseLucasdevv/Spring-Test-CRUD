package crud.com.example.crudspring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity()
@Table(name="Users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="This field may not be empty")
    private String name;
    @NotNull(message="This field may not be null")
    private Integer age;
    @NotBlank(message="This field may ne be empty")
    private String cpf;

    public Long getId(){
        return this.id;
    };

    public void setId(Long id){
        this.id = id;
    };

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getAge(){
        return this.age;
    }
    public void setAge(Integer age){
        this.age = age;
    }

    public String getCpf(){
        return this.cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }
 }
