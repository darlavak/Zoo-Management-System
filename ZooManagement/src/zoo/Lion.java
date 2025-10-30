package zoo;

public class Lion extends Vertebrate {
    public Lion(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " (Лев) рычит: Rooooar!");
    }

    @Override
    public void feed() {
        System.out.println(getName() + " ест мясо.");
    }
}