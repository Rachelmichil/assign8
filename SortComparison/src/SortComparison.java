package assign7;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SortComparison<T extends Comparable<T>> {

    public static <T extends Comparable<T>> ArrayList<T> createRandomArrayList(int size) {
        ArrayList<T> randomList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            randomList.add((T) Integer.valueOf(random.nextInt(101))); // Generates random integers between 0 and 100
        }
        return randomList;
    }

    public static <T> void printArrayList(ArrayList<T> list) {
        for (T item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static <T extends Comparable<T>> void bubbleSort(ArrayList<T> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j).compareTo(list.get(j + 1)) > 0) {
                    // swap
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    public static <T extends Comparable<T>> ArrayList<T> mergeSort(ArrayList<T> list) {
        if (list.size() <= 1) {
            return list;
        }

        int middle = list.size() / 2;
        ArrayList<T> left = new ArrayList<>(list.subList(0, middle));
        ArrayList<T> right = new ArrayList<>(list.subList(middle, list.size()));

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static <T extends Comparable<T>> ArrayList<T> merge(ArrayList<T> left, ArrayList<T> right) {
        ArrayList<T> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) < 0) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        // Add the remaining elements
        result.addAll(left.subList(i, left.size()));
        result.addAll(right.subList(j, right.size()));

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the ArrayList:");
        int size = scanner.nextInt();

        ArrayList<Integer> randomArrayList = createRandomArrayList(size);

        // Copy the ArrayList for BubbleSort since it modifies the original list
        ArrayList<Integer> bubbleSortList = new ArrayList<>(randomArrayList);
        System.out.println("\nRandom ArrayList:");
        printArrayList(randomArrayList);

        long startTime = System.currentTimeMillis();
        bubbleSort(bubbleSortList);
        long endTime = System.currentTimeMillis();
        System.out.println("\nBubbleSorted ArrayList:");
        printArrayList(bubbleSortList);
        System.out.println("BubbleSort Time: " + (endTime - startTime) + " milliseconds");

        // MergeSort
        ArrayList<Integer> mergeSortList = new ArrayList<>(randomArrayList);
        startTime = System.currentTimeMillis();
        ArrayList<Integer> sortedList = mergeSort(mergeSortList);
        endTime = System.currentTimeMillis();
        System.out.println("\nMergeSorted ArrayList:");
        printArrayList(sortedList);
        System.out.println("MergeSort Time: " + (endTime - startTime) + " milliseconds");

        scanner.close();
    }
}
