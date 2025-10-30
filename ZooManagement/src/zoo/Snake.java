package zoo;

public class Snake extends Vertebrate {
    public Snake(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " (Змея) шипит: Sssssss!");
    }

    @Override
    public void feed() {
        System.out.println(getName() + " глотает добычу.");
    }
}