package minpq;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Unsorted array (or {@link ArrayList}) implementation of the {@link ExtrinsicMinPQ} interface.
 *
 * @param <T> the type of elements in this priority queue.
 * @see ExtrinsicMinPQ
 */
public class UnsortedArrayMinPQ<T> implements ExtrinsicMinPQ<T> {
    /**
     * {@link List} of {@link PriorityNode} objects representing the item-priority pairs in no specific order.
     */
    private final List<PriorityNode<T>> items;

    /**
     * Constructs an empty instance.
     */
    public UnsortedArrayMinPQ() {
        items = new ArrayList<>();
    }

    @Override
    public void add(T item, double priority) {
        if (contains(item)) {
            throw new IllegalArgumentException("Already contains " + item);
        }
        // TODO: Replace with your code
        PriorityNode<T> itemsWithPriority = new PriorityNode<>(item, priority);
        items.add(itemsWithPriority);
        //throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public boolean contains(T item) {
        // TODO: Replace with your code
        for (PriorityNode<T> itemsWithPriority : items) {
            if (itemsWithPriority.item() == item) {
                return true;
            }
        }
        return false;
        //throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public T peekMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("PQ is empty");
        }
        // TODO: Replace with your code
        return peekMinObject().item();
        //throw new UnsupportedOperationException("Not implemented yet");
    }

    private PriorityNode<T> peekMinObject() {
        PriorityNode<T> ansItem = items.get(0);
        //System.out.println();
        double minValue = Double.MAX_VALUE;
        for (PriorityNode<T> itemsWithPriority : items) {
            if (itemsWithPriority.priority() < minValue) {
                minValue = itemsWithPriority.priority();
                //System.out.println("minValue" + minValue);
                ansItem = itemsWithPriority;
                //System.out.println("ansItem" + ansItem);
            }
        }
        return ansItem;
    }

    @Override
    public T removeMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("PQ is empty");
        }
        // TODO: Replace with your code
        PriorityNode<T> ansItem = peekMinObject();
        items.remove(ansItem);
        return ansItem.item();
        //throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public void changePriority(T item, double priority) {
        if (!contains(item)) {
            throw new NoSuchElementException("PQ does not contain " + item);
        }
        // TODO: Replace with your code
        for (PriorityNode<T> itemsWithPriority : items) {
            if (itemsWithPriority.item() == item) {
                itemsWithPriority.setPriority(priority);
            }
        }
        //throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public int size() {
        // TODO: Replace with your code
        return items.size();
        //throw new UnsupportedOperationException("Not implemented yet");
    }
}
