package lab4;
import java.util.Iterator;

public class Sequence<E> implements Iterable<E> {
    
    private E[] partialArray;
    private int arraySize;
    
    public Sequence(E[] partialArray) {
        this.partialArray = partialArray;
        this.arraySize = partialArray.length;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
        
        private int arrayIndex = 0;
        
        public boolean hasNext() {
            return arrayIndex < arraySize && partialArray[arrayIndex] != null;
        }
        
        public E next() {
            return partialArray[arrayIndex++];
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }
        };
    }
    
}
