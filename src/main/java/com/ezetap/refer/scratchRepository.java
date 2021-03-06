package com.ezetap.refer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface scratchRepository extends JpaRepository<Scratch,Integer> {
    @Override
    List<Scratch> findAll();


}
