package zoo;

import java.util.ArrayList;
import java.util.List;

public class Enclosure {
    private List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        if (animal == null) throw new IllegalArgumentException("Animal не должен быть null");
        animals.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public List<Animal> getAnimals() {
        return new ArrayList<>(animals); // защита от внешних модификаций
    }
}
