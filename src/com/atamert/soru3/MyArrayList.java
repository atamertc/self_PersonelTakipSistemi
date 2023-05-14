package com.atamert.soru3;

public class MyArrayList<T> {

    private static final int ILK_KAPASITE = 10;
    private int boyut;
    private T[] dizi;

    public MyArrayList() {
        dizi = (T[]) new Object[ILK_KAPASITE];
        boyut = 0;
    }

        public int size() {
        return boyut;
    }

    public boolean isEmpty() {
        return boyut == 0;
    }

    private void increaseCapacity() {
        T[] yeniDizi = (T[]) new Object[dizi.length * 2];
        for (int i = 0; i < dizi.length; i++) {
            yeniDizi[i] = dizi[i];
        }
        dizi = yeniDizi;
    }

    public T get(int index) {
        if (index < 0 || index >= boyut) {
            throw new IndexOutOfBoundsException();
        }
        return dizi[index];
    }

    public void add(T eleman) {
        if (boyut == dizi.length) {
            increaseCapacity();
        }
        dizi[boyut++] = eleman;
    }

    public void add(int index, T eleman) {
        if (index < 0 || index > boyut) {
            throw new IndexOutOfBoundsException();
        }
        if (boyut == dizi.length) {
            increaseCapacity();
        }
        for (int i = boyut - 1; i >= index; i--) {
            dizi[i + 1] = dizi[i];
        }
        dizi[index] = eleman;
        boyut++;
    }

    public T remove(int index) {
        if (index < 0 || index >= boyut) {
            throw new IndexOutOfBoundsException();
        }
        T kaldirilanEleman = dizi[index];
        for (int i = index; i < boyut - 1; i++) {
            dizi[i] = dizi[i + 1];
        }
        dizi[boyut - 1] = null;
        boyut--;
        return kaldirilanEleman;
    }

    public boolean contains(T eleman) {
        for (int i = 0; i < boyut; i++) {
            if (dizi[i].equals(eleman)) {
                return true;
            }
        }
        return false;
    }

    public T set(int index, T eleman) {
        if (index < 0 || index >= boyut) {
            throw new IndexOutOfBoundsException();
        }
        T eskiEleman = dizi[index];
        dizi[index] = eleman;
        return eskiEleman;
    }

    public void clear() {
        dizi = (T[]) new Object[ILK_KAPASITE];
        boyut = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < boyut; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(dizi[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
