import java.util.*;

public class SortingStringFruit {
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
        System.out.println("Fruits in order: ");
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
        boolean fruit1IsCapital = Character.isUpperCase(fruit1.charAt(0));
        boolean fruit2IsCapital = Character.isUpperCase(fruit2.charAt(0));

        if (fruit1IsCapital && !fruit2IsCapital) {
            // fruit1 comes before fruit2
            return -1;
        } else if (!fruit1IsCapital && fruit2IsCapital) {
            // fruit2 comes before fruit1
            return 1;
        } else {
            // Alphabetical order ignoring case
            return fruit1.compareToIgnoreCase(fruit2);
        }
    }
    //create a function to swap the element in the array
    public static void swap(ArrayList<String> fruits, int i, int j) {
        String temp = fruits.get(i);
        fruits.set(i, fruits.get(j));
        fruits.set(j, temp);
    }
}
