package Day5_DSA.Homework1;

public class MyList<E> implements Cloneable {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be >= 0");
        }
        this.elements = new Object[Math.max(capacity, DEFAULT_CAPACITY)];
    }

    public int size() {
        return size;
    }

    public E get(int i) {
        checkIndex(i);
        return (E) elements[i];
    }

    public boolean add(E e) {
        ensureCapacity(size + 1);
        elements[size++] = e;
        return true;
    }

    public void add(int index, E element) {
        checkIndexForAdd(index);

        ensureCapacity(size + 1);

        // Shift right from last to index
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }

        elements[index] = element;
        size++;
    }

    public E remove(int index) {
        checkIndex(index);

        E removed = (E) elements[index];

        // Shift left from index+1 to end
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        // Avoid memory leak
        elements[size - 1] = null;
        size--;

        return removed;
    }

    public void clear() {
        // Avoid memory leak
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(E o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) return i;
            }
        }
        return -1;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity <= elements.length) return;

        int newCapacity = elements.length * 2;
        if (newCapacity < minCapacity) newCapacity = minCapacity;

        Object[] newArr = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArr[i] = elements[i];
        }
        elements = newArr;
    }

    @Override
    public MyList<E> clone() {
        try {
            MyList<E> copy = (MyList<E>) super.clone();
            copy.elements = new Object[this.elements.length];
            for (int i = 0; i < this.size; i++) {
                copy.elements[i] = this.elements[i];
            }
            // size is primitive, already copied
            return copy;
        } catch (CloneNotSupportedException e) {
            // Should not happen because we implement Cloneable
            throw new AssertionError(e);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size
            );
        }
    }

    private void checkIndexForAdd(int index) {
        // add(index, e) allows index == size (add to end)
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size
            );
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
