package zoo;

public class Veterinarian implements Staff {
    private String name;
    private String licenseNumber;
    private double salary;

    public Veterinarian(String name, String licenseNumber, double salary) {
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.salary = salary;
    }

    public String getName() { return name; }
    public String getLicenseNumber() { return licenseNumber; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) {
        if (salary > 0) this.salary = salary;
    }

    @Override
    public void work() {
        System.out.println(name + " (ветеринар) проверяет животных.");
    }

    @Override
    public void cleanEnclosure(Enclosure enclosure) {
        System.out.println(name + " (ветеринар) помогает почистить вольер.");
    }

    // Полиморфный метод: принимает любой Animal (интерфейс имеет getName())
    public void inspectAnimal(Animal animal) {
        System.out.println(name + " осматривает " + animal.getName() + " (" + animal.getClass().getSimpleName() + ").");
        animal.makeSound(); // полиморфный вызов — будет конкретный звук
    }
}
