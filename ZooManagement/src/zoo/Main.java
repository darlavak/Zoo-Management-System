package zoo;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Создаём животных
        Lion lion = new Lion("Симба", 5, 190);
        Elephant elephant = new Elephant("Дамбо", 10, 1200);
        Snake snake = new Snake("Каа", 3, 8);

        Enclosure enclosure = new Enclosure();
        enclosure.addAnimal(lion);
        enclosure.addAnimal(elephant);
        enclosure.addAnimal(snake);

        // Создаём персонал
        Veterinarian vet = new Veterinarian("Доктор Айболит", "VET-001", 2000);
        Zookeeper keeper = new Zookeeper("Иван", 5);

        // GUI (Swing)
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Zoo Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);

            JTextArea area = new JTextArea();
            area.setEditable(false);
            area.setLineWrap(true);
            area.setWrapStyleWord(true);

            JButton btnSounds = new JButton("Издать звуки всех животных");
            JButton btnFeed = new JButton("Покормить всех животных");
            JButton btnShowList = new JButton("Показать список животных");
            JButton btnStaffDemo = new JButton("Демонстрация персонала");

            btnSounds.addActionListener(e -> {
                area.append("=== Звуки ===\n");
                for (Animal a : enclosure.getAnimals()) {
                    a.makeSound();
                    area.append("- " + a.getName() + " издал звук\n");
                }
                area.append("\n");
            });

            btnFeed.addActionListener(e -> {
                area.append("=== Кормление ===\n");
                for (Animal a : enclosure.getAnimals()) {
                    a.feed();
                    area.append("- " + a.getName() + " покормлен\n");
                }
                area.append("\n");
            });

            btnShowList.addActionListener(e -> {
                area.append("=== Список вольера ===\n");
                for (Animal a : enclosure.getAnimals()) {
                    if (a instanceof Vertebrate) {
                        Vertebrate v = (Vertebrate) a;
                        area.append(v.getClass().getSimpleName() + " - имя: " + v.getName()
                                + ", возраст: " + v.getAge() + ", вес: " + v.getWeight() + "\n");
                    } else {
                        area.append(a.getClass().getSimpleName() + "\n");
                    }
                }
                area.append("\n");
            });

            btnStaffDemo.addActionListener(e -> {
                area.append("=== Демонстрация персонала ===\n");
                area.append(vet.getName() + " (ветеринар) работает.\n");
                vet.work();
                area.append(keeper.getName() + " (смотритель) работает.\n");
                keeper.work();

                area.append("\nВетеринар осматривает животных (и слушает звук):\n");
                vet.inspectAnimal(lion);
                vet.inspectAnimal(elephant);
                vet.inspectAnimal(snake);
                area.append("- Ветеринар провёл осмотр (см. консоль для звуков).\n");

                area.append("\nСмотритель кормит животных в вольере:\n");
                keeper.feedAnimalsInEnclosure(enclosure);
                area.append("- Смотритель накормил животных.\n\n");
            });

            JPanel buttons = new JPanel();
            buttons.add(btnSounds);
            buttons.add(btnFeed);
            buttons.add(btnShowList);
            buttons.add(btnStaffDemo);

            frame.setLayout(new BorderLayout());
            frame.add(new JScrollPane(area), BorderLayout.CENTER);
            frame.add(buttons, BorderLayout.SOUTH);

            frame.setVisible(true);

            System.out.println("Приложение запущено. Демонстрация персонала доступна по кнопке.");
        });
    }
}
