package model;

public interface OnChangeListener<T> {
    void valueChanged(T oldValue, T newValue);
}
