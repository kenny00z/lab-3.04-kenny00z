package com.ironhack.lab304.repository;

import com.ironhack.lab304.model.Aircraft;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AircraftRepositoryTest {

    private Aircraft testAircraft;
    private Aircraft testAircraft2;

@Autowired
    AircraftRepository aircraftRepository;


@BeforeEach
    void setup(){

    testAircraft = new Aircraft("Boeing", 500);
    testAircraft2 = new Aircraft("Airbus", 400);
}

@AfterEach
    void tearDown(){
    aircraftRepository.delete(testAircraft);
    aircraftRepository.delete(testAircraft2);
}

@Test
    void createAircraft_Validate_addedToDatabase(){
    aircraftRepository.save(testAircraft);
    aircraftRepository.save(testAircraft2);

    List<Aircraft> foundAircraft = aircraftRepository.findAll();
    assertEquals(2, foundAircraft.size());

}


@Test
void findAircraft_ContainBoeingOnName_Founded(){
    aircraftRepository.save(testAircraft);
    aircraftRepository.save(testAircraft2);

    assertEquals(1, aircraftRepository.findByModel("Boeing").size());
}

}