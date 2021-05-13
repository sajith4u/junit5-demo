package io.arimac.demo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Nested Advanced Example")
class NetstedAdvancedExampleTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before all test methods");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After all test methods");
    }

    @Test
    @DisplayName("Test1")
    void testDemo() {
        assertEquals(1, 1);
    }


    @Test
    @DisplayName("Test2")
    void testLogic2() {
        assertEquals(1, 1);
    }


    @Nested
    @DisplayName("Inner Class")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class InnerLogicTest {

        @BeforeAll
        void beforeAll() {
            System.out.println("Before all test methods [InnerClass]");
        }

        @AfterAll
        void afterAll() {
            System.out.println("After all test methods [InnerClass]");
        }

        @Test
        @DisplayName("Layer1")
        void testLogic2() {
            assertEquals(1, 1);
        }


        @Nested
        @DisplayName("Layer One Class")
        class LayerOneTest {

            @Test
            @DisplayName("Layer2")
            void testLogic2() {
                assertEquals(1, 1);
            }
        }
    }

}
