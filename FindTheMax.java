import java.util.Comparator;
import java.util.List;

public class FindTheMax {

    public static int findMax(int[] numbers) {
        List<Integer> numberList = java.util.Arrays.stream(numbers).boxed().toList();
        return numberList.stream().max(Comparator.naturalOrder()).get();
    }

    public static void main(String[] args) {
        int[] numbers = {3, 5, 7, 2, 8, -1, 4};
        int max = findMax(numbers);
        System.out.println("The maximum value is: " + max);
    }
}
