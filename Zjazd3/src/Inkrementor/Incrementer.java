package Inkrementor;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author bartosz.kalinowski
 */
public class Incrementer implements Iterable<Integer> {

    private int start, end, step;
    private IncrementIterator iterator;

    public Incrementer(int start, int end, int step) {
        this.start = start;
        this.end = end;
        this.step = step;
        iterator = new IncrementIterator();
    }

    @Override
    public Iterator<Integer> iterator() {
        return iterator;
    }

    public static Incrementer in(int i, int j) {
        if (i < j) {
            return new Incrementer(i, j, 1);
        } else {
            return new Incrementer(i, j, -1);
        }

    }

    public Incrementer by(int i) {
        iterator.setStep(i);

        return this;
    }

    private class IncrementIterator implements Iterator<Integer> {

        private int current;
        private boolean growing = true;

        private IncrementIterator() {
            this.current = start - step;
            this.growing = start < end;
        }

        @Override
        public boolean hasNext() {
            if (growing) {
                return current + step <= end;
            } else {
                return current + step >= end;
            }
        }

        @Override
        public void remove() {
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            current += step;
            return current;
        }

        public void setStep(int i) {
            if ((step > 0 && i > 0) || (step < 0 && i < 0)) {
                if (current == start - step) {
                    current = start - i;
                }
            } else /*if ((step < 0 && i > 0) || (step > 0 && i < 0))*/ {
                if (current == start - step) {
                    current = end - i;
                }
                int temp = start;
                start = end;
                end = temp;
                growing = i > 0;
            }
            step = i;

        }
    }
}
