package com.ezetap.refer.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface userRepository extends CrudRepository<user,Integer> {
    @Override
    List<user> findAll();
}
