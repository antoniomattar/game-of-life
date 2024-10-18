package matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstantMatrixInitializerTest {
    @Test
    public void testMatrixInitializationWithConstantValue() {
        ListMatrix<String> matrix = new ListMatrix<>(3, 3, new ConstantMatrixInitializer<>("X"));

        // Test that all cells have the constant value.
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                assertEquals("X", matrix.get(x, y));
            }
        }
    }

    @Test
    public void testMatrixInitializationWithConstantValue2() {
        ListMatrix<Integer> matrix = new ListMatrix<>(3, 5, new ConstantMatrixInitializer<>(12));

        // Test that all cells have the constant value.
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 5; y++) {
                assertEquals(12, matrix.get(x, y));
            }
        }
    }
}