import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {

    static class Color {
        private String name;
        public Color(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        // On this file we will practice Stream API methods only using the colors
        List<Color> colors = List.of(new Color("Red"), new Color("Green"), new Color("Blue"));
        
        // Using for each to print color names
        colors.forEach(color -> color.getName());

        // Attempting to skip the first element (this does not modify the original list)
        List<Color> c1 = colors.stream().skip(1).toList();
        c1.forEach(color -> color.getName());

        // Limiting to the first two elements
        List<Color> c2 = colors.stream().limit(2).toList();
        c2.forEach(color -> color.getName());

        List<Color> c3 = colors.stream().dropWhile(color -> color.getName().length() > 3).toList();
        c3.forEach(color -> color.getName());

        Stream<Color> colorStream = colors.stream().limit(2);
        System.out.println(colorStream);


        List<String> greetings = List.of("Hello", "!", " I'm Hicham");
        Stream<String> greetingStream = greetings.stream().limit(2).sorted();
        List<String> result = greetingStream.collect(Collectors.toList());
        System.out.println(result);
    }
}