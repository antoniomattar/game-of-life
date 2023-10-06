package datastruct;

public interface Lens<S> {
    S get();

    void set(S value);
}
