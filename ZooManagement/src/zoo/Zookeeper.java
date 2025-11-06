package zoo;

import java.util.List;

public class Zookeeper implements Staff {
    private String name;
    private int experienceYears;

    public Zookeeper(String name, int experienceYears) {
        this.name = name;
        this.experienceYears = experienceYears;
    }

    public String getName() { return name; }
    public int getExperienceYears() { return experienceYears; }

    @Override
    public void work() {
        System.out.println(name + " (смотритель) ухаживает за животными.");
    }

    @Override
    public void cleanEnclosure(Enclosure enclosure) {
        System.out.println(name + " (смотритель) чистит вольер.");
    }

    public void feedAnimalsInEnclosure(Enclosure enclosure) {
        List<Animal> animals = enclosure.getAnimals();
        System.out.println(name + " начинает кормить животных...");
        for (Animal animal : animals) {
            animal.feed(); // полиморфизм: конкретная реализация feed()
        }
        System.out.println(name + " закончил кормить животных.");
    }
}
