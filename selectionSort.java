import java.util.*;
public class SortingAlgorithm {
    public static void main(String[] args) {
        //create a new array and add value 
        ArrayList<Integer> salary=new ArrayList<>();
        salary.add(1300);
        salary.add(1600);
        salary.add(4300);
        salary.add(1100);
        salary.add(1800);
        //return the selection sort for selectionSort method
        SelectionSort(salary,0);
        //print the array in order
        System.out.println("Th salary in order:");
        System.out.println(salary.toString());
    }
    //do recursion method to sort the element from lower to higher
    public static void SelectionSort(ArrayList<Integer> array, int index) {
        if (index == array.size())
            return;

        int minIndex = findMinimumIndex(array, index);
        if (minIndex != index) {
            int temp = array.get(index);
            array.set(index, array.get(minIndex));
            array.set(minIndex, temp);
        }
        SelectionSort(array, index + 1);
    }
    // do recursion to find the minimum index so, we can use it in selectionSort method
    public static int findMinimumIndex(ArrayList<Integer> array, int start) {
        int minIndex = start;
        for (int i = start + 1; i < array.size(); i++) {
            if (array.get(i) < array.get(minIndex)) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}

