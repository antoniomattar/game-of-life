package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    private record Change<T>(T oldValue, T newValue) {}
    private static class MockListener<T> implements OnChangeListener<T> {
        private Change<T> lastChange = null;

        public boolean checksLastChange(T oldValue, T newValue) {
            return this.lastChange != null
                    && this.lastChange.oldValue.equals(oldValue)
                    && this.lastChange.newValue.equals(newValue);
        }

        @Override
        public void valueChanged(T oldValue, T newValue) {
            lastChange = new Change<>(oldValue, newValue);
        }
    }
    @Test
    public void testCellValueChangeWithListener() {
        Cell<Integer> cell = new Cell<>(42);
        MockListener<Integer> mockListener = new MockListener<>();
        cell.addOnChangeListener(mockListener);
        cell.set(99);
        assertTrue(mockListener.checksLastChange(42, 99));
        assertEquals(99, cell.get());
    }

    @Test
    public void testCellWithoutListener() {
        Cell<String> cell = new Cell<>("Foo");
        cell.set("Bar");
        assertEquals("Bar", cell.get());
    }
}