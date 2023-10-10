package model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static model.State.count;
import static org.junit.jupiter.api.Assertions.*;

class StateTest {
    @Test
    public void testCountMethodWithInteger() {
        List<Integer> neighbours = List.of(1, 2, 1, 3, 1);
        int result = count(1, neighbours);
        assertEquals(3, result);
    }

    @Test
    public void testCountMethodWithString() {
        List<String> neighbours = List.of("apple", "banana", "apple", "cherry", "apple");
        int result = count("apple", neighbours);
        assertEquals(3, result);
    }

    @Test
    public void testCountMethodWithEmptyList() {
        List<Double> neighbours = List.of();
        int result = count(5.0, neighbours);
        assertEquals(0, result);
    }

    @Test
    public void testCountMethodWithNoMatchingElements() {
        List<Character> neighbours = List.of('a', 'b', 'c');
        int result = count('x', neighbours);
        assertEquals(0, result);
    }

}