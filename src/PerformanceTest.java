import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PerformanceTest {
    public static void main(String[] args) {

      List<Integer> array = new ArrayList<>();
      List<Integer> linked = new LinkedList<>();

      long startarray = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++){
            array.add(i);
        }
        long endarray = System.currentTimeMillis();

        long startlink = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++){
            linked.add(i);
        }
        long endlink = System.currentTimeMillis();

        long getArrayStart = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++){
            array.get(i);
        }
        long getArrayend = System.currentTimeMillis();

        long getLinkedStart = System.currentTimeMillis();
        for (int i = 0; i < 100_000; i++){
            linked.get(i);
        }
        long getLinkedEnd = System.currentTimeMillis();


        System.out.println("Array: " + (endarray-startarray) + " ms");
        System.out.println("link: " + (endlink-startlink) + " ms");

        System.out.println("array: " + (getArrayend-getArrayStart) + " ms");
        System.out.println("link: " + (getLinkedEnd-getLinkedStart) + " ms");
    }
}