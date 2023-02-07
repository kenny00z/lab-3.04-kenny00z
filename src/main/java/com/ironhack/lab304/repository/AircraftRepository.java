package com.ironhack.lab304.repository;


import com.ironhack.lab304.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, String> {


    Collection<Object> findByModel(String boeing);
}
