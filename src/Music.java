import Animals.Abstract.Animal;

public class Music {
    private final String montainEmoji = "🏔️";  //char montainsUnicodeChar = Character.toChars(0x26F0)[0];
    private final Settings settings = Settings.getInstance();
    private final Animal selectedAnimal;

    public Music(Animal selectedAnimal) {
        this.selectedAnimal = selectedAnimal;
    }

    public void writeRefrain(int quantityOfAnimals) {
        writeWithSleep(quantityOfAnimals + " " + (quantityOfAnimals == 1 ? selectedAnimal.getMaleName() : selectedAnimal.getMalePluralName()));
        writeWithSleep(quantityOfAnimals == 1 ? "foi passear" : "foram passear");
        this.montainsSnippet();
        writeWithSleep("Para brincar");
        this.animalMomSnippet();
    }

    public void writeEnd() {
        writeWithSleep("Puxa!");
        writeWithSleep("A mamãe" + selectedAnimal.getFemaleName() + "Ficou tão triste naquele dia");
        writeWithSleep("Aonde será que estavam seus filhotinhos?");
        writeWithSleep("Mas essa história vai ter um final feliz");
        writeWithSleep("Sabe por quê?");

        writeWithSleep("A mamãe " + selectedAnimal.getFemaleName() + " foi procurar");
        this.montainsSnippet();
        writeWithSleep("Na beira do mar");
        this.animalMomSnippet();
    }

    public void writePluralRefrainEnding(int quantityOfDucks) {
        writeWithSleep("Mas só " + (quantityOfDucks - 1) + " " + selectedAnimal.getMalePluralName());
        this.pluralComebackSnippet();
    }

    public void writePluralEndEnding(int quantityOfDucks) {
        writeWithSleep("E os " + quantityOfDucks + " " + selectedAnimal.getMalePluralName());
        this.pluralComebackSnippet();
    }

    public void writeSingularRefrainEnding() {
        writeWithSleep("Mas só 1 " + selectedAnimal.getMaleName());
        this.singularComebackSnippet();
    }

    public void writeSingularEndEnding() {
        writeWithSleep("E o " + selectedAnimal.getMaleName());
        this.singularComebackSnippet();
    }

    public void writeNoneRefrainEnding() {
        writeWithSleep("Mas nenhum " + selectedAnimal.getMaleName());
        this.singularComebackSnippet();
    }

    public void singularComebackSnippet() {
        writeWithSleep("voltou de lá.");
    }

    public void pluralComebackSnippet() {
        writeWithSleep("voltaram de lá.");
    }

    public void animalMomSnippet() {
        writeWithSleep("A mamãe gritou");
        writeWithSleep(selectedAnimal.getSound());
    }

    public void montainsSnippet() {
        writeWithSleep("Além das montanhas " + (settings.getShowEmojis() ? this.montainEmoji : ""));
    }

    public <T> void writeWithSleep(T text) {
        System.out.println(text);
        try {
            Thread.sleep(settings.getMillisecondsDelay());
        } catch (InterruptedException e) {
            System.out.println("Error at Sleep");
        }
    }
}
