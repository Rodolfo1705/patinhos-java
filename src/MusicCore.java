import Animals.Abstract.Animal;
import Animals.Cat;
import Animals.Duck;

import java.lang.reflect.Method;

public class MusicCore {
    private final Settings settings = Settings.getInstance();
    private Animal selectedAnimal;
    private Music music;

    public void start() {
        this.welcome();
        this.showMenu();
    }

    private void welcome() {
        System.out.println("Bem-vindo ao Desafio da música dos animais!");
        int selectedAnimalOption;

        do {
            selectedAnimalOption = InputHandler.getIntInput("Escolha um animal! 1 (Pato); 2 (Gato): ");
            selectedAnimal = getSelectedAnimalInstance(selectedAnimalOption);
            music = new Music(selectedAnimal);
        } while (selectedAnimal == null);

        System.out.println(selectedAnimal.getAsciiArt());
    }

    private Animal getSelectedAnimalInstance(int selectedOption) {
        return switch (selectedOption) {
            case 1 -> new Duck();

            case 2 -> new Cat();

            default -> null;
        };
    }

    private void farewell() {
        System.out.println("Obrigado por usar este programa!");
        System.exit(0);
    }

    private void showMenu() {
        while (true) {
            System.out.println("Selecione uma das opções à seguir.");
            int selectedOption = InputHandler.getIntInput("1 (Iniciar); 2 (Configurações); 3 (Sair): ");

            try {
                String concat = "option" + selectedOption;
                Method method = this.getClass().getDeclaredMethod(concat, null);
                method.invoke(this);
            } catch (Exception e) {
                System.out.println("Opção inválida!");
            }
        }
    }

    private void option1() {
        this.requestNumberOfAnimals();
        this.printRefrain(selectedAnimal.getQuantity());
        this.printEnd(selectedAnimal.getQuantity());
    }

    private void option2() {
        settings.showMenu();
    }

    private void option3() {
        farewell();
    }

    private void requestNumberOfAnimals() {
        int quantity;

        do {
            quantity = InputHandler.getIntInput("Digite a quantidade de " + selectedAnimal.getMalePluralName() + ": ");
        } while (quantity <= 0);

        selectedAnimal.setQuantity(quantity);
    }

    private void printRefrain(int quantityOfDucks) {
        int currentAnimals;

        for (currentAnimals = quantityOfDucks; currentAnimals > 2; currentAnimals--) {
            if (settings.getShowEmojis())
                selectedAnimal.print(currentAnimals);
            music.writeRefrain(currentAnimals);
        }

        for (; currentAnimals > 0; currentAnimals--) {
            if (settings.getShowEmojis())
                selectedAnimal.print(currentAnimals);
            music.writeRefrain(currentAnimals);
            if (currentAnimals == 2) {
                music.writeSingularRefrainEnding();
            } else if (currentAnimals == 1) {
                music.writeNoneRefrainEnding();
            } else {
                music.writePluralRefrainEnding(currentAnimals);
            }
        }
    }

    private void printEnd(int quantityOfAnimals) {
        music.writeEnd();

        if (quantityOfAnimals == 1) {
            music.writeSingularEndEnding();
        } else {
            music.writePluralEndEnding(quantityOfAnimals);
        }
        if (settings.getShowEmojis()) selectedAnimal.print(quantityOfAnimals);
    }
}
