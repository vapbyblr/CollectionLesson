package SotrArrayTask;

public class Sorter {
    private ArraySortInterface arraySortInterface;

    public Sorter() {
    }

    public Sorter(ArraySortInterface arraySortInterface) {
        this.arraySortInterface = arraySortInterface;
    }

    public void setArraySortInterface(ArraySortInterface arraySortInterface) {
        this.arraySortInterface = arraySortInterface;
    }

    public <T extends Integer> boolean sort(T[] array){
        if(arraySortInterface == null) return false;
        arraySortInterface.sort(array);
        return true;
    }
}
