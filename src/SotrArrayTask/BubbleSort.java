package SotrArrayTask;

public class BubbleSort implements ArraySortInterface {

    @Override
    public <T extends Integer> boolean sort(T[] array) {
        if(array == null) return false;
        boolean flag = true;
        T temp;
        while (flag) {
            flag = false;
            for (int j = 0; j < array.length-1; j++) {
                if (array[j].compareTo(array[j+1])>0) {
                   temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                   flag = true;
                }
            }
        }
        return true;
    }
}
