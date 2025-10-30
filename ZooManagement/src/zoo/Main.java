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

        // GUI (Swing)
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Zoo Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 350);
            frame.setLocationRelativeTo(null);

            JTextArea area = new JTextArea();
            area.setEditable(false);
            area.setLineWrap(true);
            area.setWrapStyleWord(true);

            JButton btnSounds = new JButton("Издать звуки всех животных");
            JButton btnFeed = new JButton("Покормить всех животных");
            JButton btnShowList = new JButton("Показать список животных");

            btnSounds.addActionListener(e -> {
                area.append("=== Звуки ===\n");
                for (Animal a : enclosure.getAnimals()) {
                    a.makeSound(); // вывод в консоль для демонстрации полиморфизма
                    area.append("- " + a.getClass().getSimpleName() + " издал звук\n");
                }
                area.append("\n");
            });

            btnFeed.addActionListener(e -> {
                area.append("=== Кормление ===\n");
                for (Animal a : enclosure.getAnimals()) {
                    a.feed(); // консоль
                    area.append("- " + a.getClass().getSimpleName() + " покормлен\n");
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

            JPanel buttons = new JPanel();
            buttons.add(btnSounds);
            buttons.add(btnFeed);
            buttons.add(btnShowList);

            frame.setLayout(new BorderLayout());
            frame.add(new JScrollPane(area), BorderLayout.CENTER);
            frame.add(buttons, BorderLayout.SOUTH);

            frame.setVisible(true);

            // Демонстрация: попытка создать Vertebrate приведёт к ошибке (строка закомментирована)
            // Vertebrate v = new Vertebrate("Test", 1, 1); // <-- так нельзя, класс абстрактный
            System.out.println("Приложение запущено. Попытка new Vertebrate(...) невозможна (abstract).");
        });
    }
}
