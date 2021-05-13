package io.arimac.demo;


import org.junit.jupiter.api.*;

class TestLifeCycle {

    @BeforeAll
    static void initAll() {
        System.out.println("Initialize Test Class");
    }

    @BeforeEach
    void init() {
        System.out.println("Called Before Every Method");
    }

    @Test
    void succeedingTest() {
        System.out.println("Run Testing");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Called After Every Method");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Close Test Class");
    }

}
