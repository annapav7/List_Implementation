package org.example.linkedlist;

import java.util.*;



    public class MyListImplementList<E> implements List<E> {
        private Object[] elements;
        private int size;
        private final int DEFAULT_CAPACITY = 10;

        public MyListImplementList() {
            elements = new Object[DEFAULT_CAPACITY];
            size = 0;
        }

        private void ensureCapacity() {
            if (size == elements.length) {
                int newCapacity = elements.length * 2;
                elements = Arrays.copyOf(elements, newCapacity);
            }
        }

        @Override
        public boolean add(E e) {
            ensureCapacity();
            elements[size++] = e;
            return true;
        }

        @Override
        public void add(int index, E element) {
            rangeCheckForAdd(index);
            ensureCapacity();
            System.arraycopy(elements, index, elements, index + 1, size - index);
            elements[index] = element;
            size++;
        }

        @Override
        public E get(int index) {
            rangeCheck(index);
            return (E) elements[index];
        }

        @Override
        public E set(int index, E element) {
            rangeCheck(index);
            E oldElement = (E) elements[index];
            elements[index] = element;
            return oldElement;
        }

        @Override
        public E remove(int index) {
            rangeCheck(index);
            E oldElement = (E) elements[index];
            int numMoved = size - index - 1;
            if (numMoved > 0) {
                System.arraycopy(elements, index + 1, elements, index, numMoved);
            }
            elements[--size] = null;
            return oldElement;
        }

        @Override
        public boolean remove(Object o) {
            for (int index = 0; index < size; index++) {
                if (o.equals(elements[index])) {
                    remove(index);
                    return true;
                }
            }
            return false;
        }

        @Override
        public boolean containsAll(Collection<?> c) {

            return false;
        }

        @Override
        public boolean contains(Object o) {

            return indexOf(o) >= 0;
        }

        @Override
        public Iterator<E> iterator() {

            return null;
        }

        @Override
        public Object[] toArray() {

            return new Object[0];
        }

        @Override
        public <T> T[] toArray(T[] a) {

            return null;
        }

        @Override
        public int size() {

            return size;
        }

        @Override
        public boolean isEmpty() {

            return size == 0;
        }

        @Override
        public void clear() {
            Arrays.fill(elements, 0, size, null);
            size = 0;
        }

        @Override
        public int indexOf(Object o) {
            for (int index = 0; index < size; index++) {
                if (o.equals(elements[index])) {
                    return index;
                }
            }
            return -1;
        }

        @Override
        public int lastIndexOf(Object o) {
            for (int index = size - 1; index >= 0; index--) {
                if (o.equals(elements[index])) {
                    return index;
                }
            }
            return -1;
        }

        @Override
        public ListIterator<E> listIterator() {

            return listIterator(0);
        }

        @Override
        public ListIterator<E> listIterator(int index) {
            rangeCheck(index);
            return new ListIterator<E>() {
                private int cursor = index;
                private int lastRet = -1;

                @Override
                public boolean hasNext() {
                    return cursor < size;
                }

                @Override
                public E next() {
                    if (cursor >= size) {
                        throw new NoSuchElementException();
                    }
                    lastRet = cursor;
                    return (E) elements[cursor++];
                }

                @Override
                public boolean hasPrevious() {
                    return cursor > 0;
                }

                @Override
                public E previous() {
                    if (cursor <= 0) {
                        throw new NoSuchElementException();
                    }
                    lastRet = --cursor;
                    return (E) elements[cursor];
                }

                @Override
                public int nextIndex() {

                    return cursor;
                }

                @Override
                public int previousIndex() {

                    return cursor - 1;
                }

                @Override
                public void remove() {
                    if (lastRet < 0) {
                        throw new IllegalStateException();
                    }
                    MyListImplementList.this.remove(lastRet);
                    cursor = lastRet;
                    lastRet = -1;
                }

                @Override
                public void set(E e) {
                    if (lastRet < 0) {
                        throw new IllegalStateException();
                    }
                    MyListImplementList.this.set(lastRet, e);
                }

                @Override
                public void add(E e) {
                    MyListImplementList.this.add(cursor++, e);
                    lastRet = -1;
                }
            };
        }

        @Override
        public boolean addAll(Collection<? extends E> c) {
            Object[] arr = c.toArray();
            int numNew = arr.length;
            ensureCapacity();
            System.arraycopy(arr, 0, elements, size, numNew);
            size += numNew;
            return numNew != 0;
        }

        @Override
        public boolean addAll(int index, Collection<? extends E> c) {
            rangeCheckForAdd(index);
            Object[] arr = c.toArray();
            int numNew = arr.length;
            ensureCapacity();
            int numMoved = size - index;
            if (numMoved > 0) {
                System.arraycopy(elements, index, elements, index + numNew, numMoved);
            }
            System.arraycopy(arr, 0, elements, index, numNew);
            size += numNew;
            return numNew != 0;
        }

        @Override
        public boolean removeAll(Collection<?> c) {
            Objects.requireNonNull(c);
            boolean modified = false;
            Iterator<?> itr = c.iterator();
            while (itr.hasNext()) {
                Object element = itr.next();
                while (remove(element)) {
                    modified = true;
                }
            }
            return modified;
        }

        @Override
        public boolean retainAll(Collection<?> c) {
            Objects.requireNonNull(c);
            boolean modified = false;
            Iterator<E> itr = iterator();
            while (itr.hasNext()) {
                if (!c.contains(itr.next())) {
                    itr.remove();
                    modified = true;
                }
            }
            return modified;
        }

        @Override
        public List<E> subList(int fromIndex, int toIndex) {
            rangeCheck(fromIndex);
            rangeCheck(toIndex);
            if (fromIndex > toIndex) {
                throw new IllegalArgumentException("fromIndex > toIndex");
            }
            return new MyListImplementList<E>() {
                {
                    for (int i = fromIndex; i < toIndex; i++) {
                        add((E) elements[i]);
                    }
                }

                @Override
                public boolean add(E e) {

                    throw new UnsupportedOperationException();
                }

                @Override
                public E set(int index, E element) {

                    throw new UnsupportedOperationException();
                }

                @Override
                public void add(int index, E element) {

                    throw new UnsupportedOperationException();
                }

                @Override
                public E remove(int index) {

                    throw new UnsupportedOperationException();
                }

                @Override
                public void clear() {

                    throw new UnsupportedOperationException();
                }
            };
        }

        private void rangeCheck(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
        }

        private void rangeCheckForAdd(int index) {
            if (index < 0 || index > size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
        }

        // Other List interface methods such as equals, hashCode, toString can be overridden if needed

}
