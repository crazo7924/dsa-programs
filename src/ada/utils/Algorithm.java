package ada.utils;

public abstract class Algorithm {
    public void sort(int[] list) {

    }

    public int search(int[] list, int x) {
        return -1;
    }

    public void swap(int[] list, int a, int b) {
        int temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }
}
