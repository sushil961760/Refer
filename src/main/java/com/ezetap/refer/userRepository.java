package com.ezetap.refer;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface userRepository extends JpaRepository<User,Integer> {
    @Override
    List<User> findAll();
}
