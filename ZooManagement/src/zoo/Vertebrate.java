package zoo;

public abstract class Vertebrate implements Animal {
    private String name;
    private int age;
    private double weight;

    public Vertebrate(String name, int age, double weight) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Имя не может быть пустым");
        if (age < 0 || weight <= 0)
            throw new IllegalArgumentException("Возраст и вес должны быть положительными!");

        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    @Override
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getWeight() { return weight; }

    public void setWeight(double weight) {
        if (weight <= 0) throw new IllegalArgumentException("Вес должен быть положительным!");
        this.weight = weight;
    }

    public void sleep() {
        System.out.println(name + " спит...");
    }

    public void move() {
        System.out.println(name + " двигается.");
    }
}
