package zoo;

public class Elephant extends Vertebrate {
    public Elephant(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " (Слон) трубит: Tooooo!");
    }

    @Override
    public void feed() {
        System.out.println(getName() + " ест листья и траву.");
    }
}
