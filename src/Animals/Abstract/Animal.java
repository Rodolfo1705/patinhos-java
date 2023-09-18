package Animals.Abstract;

public abstract class Animal {
    private final String emoji;
    private final String sound;
    private final String maleName;
    private final String femaleName;
    private final String malePluralName;
    private final String asciiArt;

    private int quantity;

    public String getSound() {
        return sound;
    }

    public String getMaleName(){
        return maleName;
    }

    public String getFemaleName() {
        return femaleName;
    }

    public String getMalePluralName() {
        return malePluralName;
    }

    public String getAsciiArt() {
        return asciiArt;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    protected Animal(String emoji, String sound, String name, String femaleName, String malePluralName, String asciiArt) {
        this.emoji = emoji;
        this.sound = sound;
        this.maleName = name;
        this.femaleName = femaleName;
        this.malePluralName = malePluralName;
        this.asciiArt = asciiArt;
    }

    public void print(int quantity){
        for (int currentQuantity = quantity; currentQuantity > 0; currentQuantity--) {
            if (currentQuantity == 1) {
                System.out.println(this.emoji);
                return;
            }
            System.out.print(this.emoji);
        }
    }
}
