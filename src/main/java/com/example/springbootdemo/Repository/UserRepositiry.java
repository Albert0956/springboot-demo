package com.example.springbootdemo.Repository;

import com.example.springbootdemo.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositiry extends CrudRepository<User, Long>{
    public User findByName(String name);
}
