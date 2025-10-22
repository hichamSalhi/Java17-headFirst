import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TheMostRepeatedNumber {

    public static int findMostRepeatedNumber(List<Integer> numbers) {
        int repeatedNumber = -1;
        Map<Integer, Integer> countMap = new LinkedHashMap<>();
        numbers.forEach(n -> countMap.put(n, countMap.getOrDefault(n, 0) + 1));
        
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if(entry.getValue() > countMap.getOrDefault(repeatedNumber, -1)) {
                repeatedNumber = entry.getKey();
            }
        }
        return repeatedNumber;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 3, 7, 3, 2, 1, 3, 4, 1, 3, 2, 1, 1);

        int mostRepeated = findMostRepeatedNumber(numbers);
        System.out.println("The most repeated number is: " + mostRepeated);
    }
}
