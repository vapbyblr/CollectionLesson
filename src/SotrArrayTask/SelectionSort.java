package SotrArrayTask;

public class SelectionSort implements ArraySortInterface {
    @Override
    public <T extends Integer> boolean sort(T[] array) {
        if(array == null) return false;
        for (int i = 0; i < array.length; i++) {
            T min = array[i];
            int minId = i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j].compareTo(min)<0) {
                    min = array[j];
                    minId = j;
                }
            }
            T temp = array[i];
            array[i] = min;
            array[minId] = temp;
        }
        return false;
    }
}
