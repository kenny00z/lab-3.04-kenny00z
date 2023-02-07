package com.ironhack.lab304.repository;

import com.ironhack.lab304.model.Customer;
import com.ironhack.lab304.model.CustomerStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest  //
class CustomerRepositoryTest {
    private Customer testCustomer; // esto para usar en el before y el after each
    @Autowired // le pedimos que automaticamente importe el CustomerRepository;
    CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        // lo creamos para la base de datos
        testCustomer = new Customer("Paco Paquito", CustomerStatus.SILVER);
    }

    @AfterEach
    void tearDown() {
        // lo borramos al acabar el test
        customerRepository.deleteById(testCustomer.getId());
    }

    @Test
    public void createCustomer_validCustomer_addedToDatabase() {


        // Customer customer = new Customer("David", CustomerStatus.GOLD); // crearlo

        customerRepository.save(testCustomer); // guardarlo en la base de datos

        // para recuperar de bases de datos, en este caso queremos recuperar uno y le pedimos que nos busque por la Id , esto nos devolverá un valor (customerRepository.findById(customer.getId()).
        //Optional<> es para traerse un elemento , si nos traemos muchos no, usariamos List<> o otra cosa.

        Optional<Customer>foundCustomer = customerRepository.findById(testCustomer.getId());

        //aqui comprobamos si es true y si existe lo recojo

        assertTrue(foundCustomer.isPresent());

        //Mira lo que viene de base de datos, compara lo que me traigo y tiene que ser el mismo contra el que lo comparo (foundCustomer.get.getname)

        assertEquals(testCustomer.getName(), foundCustomer.get().getName());

        //y con esta linea lo borramos para así cerrar la comprobación sin dejar "basura"
        //customerRepository.deleteById(customer.getId());

        // esto borraria todo el contenido de la tabla en cuestion.
        // customerRepository.deleteAll();
    }


}