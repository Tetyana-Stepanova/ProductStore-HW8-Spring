package com.goit.productstore;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class ProductStoreApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testUUID(){
        System.out.println(UUID.randomUUID());
    }
}
