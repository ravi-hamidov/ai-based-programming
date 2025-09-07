public class MagicBox<T> {
    private T item;

    public void store(T item) {
        this.item = item;
    }

    public T retrieve() {
        return this.item;
    }
}
