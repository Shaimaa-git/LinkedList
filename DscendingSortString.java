import java.util.*;

public class SortingStringFruitInDescending {
    public static void main(String[] args) {
        //create a new array of fruits
        ArrayList<String> fruits =new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("orange");
        fruits.add("Chery");
        fruits.add("watermelon");
        //call selectionSortString method
        selectionSortStrings(fruits, 0, fruits.size() - 1);
        //print the array in order of alpha
        System.out.println("Fruits in revers order: ");
        System.out.println(fruits);
    }
    //create a method of selectionSortStrings to store array recursively
    public static void selectionSortStrings(ArrayList<String> fruits, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(fruits, low, high);
            selectionSortStrings(fruits, low, pivotIndex - 1);
            selectionSortStrings(fruits, pivotIndex + 1, high);
        }
    }
    //create a function to partition the array around the elements
    public static int partition(ArrayList<String> fruits, int low, int high) {
        String capital = fruits.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (compare(fruits.get(j), capital) <= 0) {
                i++;
                swap(fruits, i, j);
            }
        }

        swap(fruits, i + 1, high);
        return i + 1;
    }
    //create compare function to compare between capital letter and lower letter
    public static int compare(String fruit1, String fruit2) {
            //use compareToIgnoreCase to print string in descending order by comparing fruit 2 by fruit 1
            return fruit2.compareToIgnoreCase(fruit1);
        }
    //create a function to swap the element in the array
    public static void swap(ArrayList<String> fruits, int i, int j) {
        String temp = fruits.get(i);
        fruits.set(i, fruits.get(j));
        fruits.set(j, temp);
    }
}
