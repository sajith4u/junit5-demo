package io.arimac.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Nested Test Example")
class NetstedExampleTest {

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
    class InnerLogicTest {

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
