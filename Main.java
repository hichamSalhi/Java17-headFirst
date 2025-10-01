import java.util.ArrayList;

public class Main {

    abstract public class Animal {
            
        static int staticVariable;

        static {
            staticVariable = 40;
        }
        
        String name;

        public Animal (String name) {
            System.out.println("I'm an animal");
            this.name = name;
        }

        abstract public void makeNoise();

        @Override
        public String toString() {
            return this.name;
        }
    }

    public class Dog extends Animal {

        public Dog(String name){
            super(name);
        }

        @Override
        public void makeNoise() {
            System.out.println("i/'m barking");
        }
    }

    public class Cat extends Animal {

        public Cat(String name){
            super("kitty");
        }

        @Override
        public void makeNoise() {
            System.out.println("i/'m meowing");
        }
    }

    public static void animalslogic() {
        Main mainClass = new Main();
        ArrayList<Object>  animals = new ArrayList<Object>();
        
        Dog max =  mainClass.new Dog("max");
        Cat cat = mainClass.new Cat(null);

        animals.add(max);
        animals.add(cat);

        for (Object object : animals) {
            if(object instanceof Dog) {
                System.out.println((Dog)object);
            }
            if (object instanceof Cat) {
                System.out.println((Cat) object);
            }
        }
    }

    public static void main(String[] args) {
        //animalslogic();
        Structures.go();
    }
}