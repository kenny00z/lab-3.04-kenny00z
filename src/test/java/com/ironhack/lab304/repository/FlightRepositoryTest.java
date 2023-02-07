package com.ironhack.lab304.repository;

import com.ironhack.lab304.model.Aircraft;
import com.ironhack.lab304.model.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FlightRepositoryTest {
    private Flight testFlight;
    private Flight testFlight2;
    @Autowired
    FlightRepository flightRepository;

    @BeforeEach
    void setup(){
        testFlight = new Flight("F1",200L,"Boeing 1");
        testFlight2 = new Flight("F2",600L,"Boeing 2");
    }
    @AfterEach
            void tearDown(){
        flightRepository.deleteAll();
    }
    
    @Test
    void createFlight_validFlight_addedToDatabase(){

        flightRepository.save(testFlight);

        Optional<Flight>foundFlight = flightRepository.findByNumber(testFlight.getNumber());

        assertTrue(foundFlight.isPresent());

        assertEquals(testFlight.getNumber(), foundFlight.get().getNumber());

    }

    @Test
    void findFlightDistanceGreaterThan_Min500Mileage_Founded(){
        flightRepository.save(testFlight);
        flightRepository.save(testFlight2);

        List<Flight> foundFlightGreaterThan = flightRepository.findByMileageGreaterThan(500L);

        assertEquals(1, foundFlightGreaterThan.size());
        assertEquals(600, testFlight2.getMileage());
        assertEquals(200,testFlight.getMileage());
    } // preguntar a un profe para hacerlo bien


}