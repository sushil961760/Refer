package com.ezetap.refer.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public interface scratchRepository extends CrudRepository<scratch,Integer> {
    @Override
    List<scratch> findAll();
}
