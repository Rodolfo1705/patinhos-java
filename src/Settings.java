import java.io.*;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Settings {
    private static final String folderPath = System.getenv("APPDATA") + "\\duck-song";
    private static final String filePath = folderPath + "\\settings.json";
    private boolean showEmojis = false;
    private int millisecondsDelay = 400;
    private static Settings uniqueInstance;

    public static Settings getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new Settings();
        }

        uniqueInstance.loadSettings();

        return uniqueInstance;
    }
    public boolean getShowEmojis(){
        return this.showEmojis;
    }
    public int getMillisecondsDelay(){
        return millisecondsDelay;
    }

    private static void save() {
        try {
            File folder = new File(folderPath);

            if (!folder.exists()){
                folder.mkdirs();
            }

            FileWriter file = new FileWriter(filePath);
            PrintWriter recordFile = new PrintWriter(file);

            recordFile.println(uniqueInstance.toJson());

            file.close();
        } catch (IOException e){
            System.out.println("Failed to save file");
        }
    }

    private String toJson(){
        return "{\"millisecondsDelay\":"+ this.getMillisecondsDelay() + "," + "\"showEmojis\":" + this.getShowEmojis() + "}";
    }

    private void loadSettings(){
        File file = new File(filePath);

        if(!file.exists()) return;

        String line = getTextFromFile();
        boolean showEmojisUpdated = getJsonBooleanValueByKey(line, "showEmojis");
        int millisecondsDelayUpdated = getJsonIntValueByKey(line, "millisecondsDelay");

        showEmojis = showEmojisUpdated;
        millisecondsDelay = millisecondsDelayUpdated;
    }

    private String getTextFromFile(){
        try {
            FileReader file = new FileReader(filePath);
            BufferedReader myBuffer = new BufferedReader(file);

            String line = myBuffer.readLine();

            file.close();

            return line;
        } catch (IOException e){
            System.out.println("File not found!");
        }

        return "";
    }

    private int getJsonIntValueByKey(String json, String key){
        Pattern pattern = Pattern.compile("\"" + key + "\":(\\d+)");
        Matcher matcher = pattern.matcher(json);
        boolean found = matcher.find();

        if(!found) return 0;

        String value = matcher.group(1);

        return Integer.parseInt(value);
    }

    private boolean getJsonBooleanValueByKey(String json, String key){
        Pattern pattern = Pattern.compile("\"" + key + "\":(true|false)");
        Matcher matcher = pattern.matcher(json);
        boolean found = matcher.find();

        if (!found) return false;

        String value = matcher.group(1);

        return value.equals("true");
    }

    public void showMenu(){
        while (true){
            System.out.println("Selecione uma das opções à seguir.");
            int selectedOption = InputHandler.getIntInput("1 (Voltar); 2 (Mudar milissegundos de delay); 3 (Exibir emojis ou não): ");

            if(selectedOption == 1) return;

            try {
                String concat = "option" + selectedOption;
                Method method = this.getClass().getDeclaredMethod(concat, null);
                method.invoke(this);
            } catch (Exception e){
                System.out.println("Opção inválida!");
            }
        }
    }

    private void option2(){
        printDelayCurrentValue();
        confirmDelayChange();
    }

    private void option3(){
        changeShowEmoji();
    }

    private void printDelayCurrentValue(){
        System.out.println("Valor atual do delay: " + millisecondsDelay);
    }

    private void confirmDelayChange(){
        int selectedInputOption;

        do {
            selectedInputOption = InputHandler.getIntInput("Deseja alterar o valor do delay? 1 (Sim); 2 (Não): ");

            if(selectedInputOption == 1 ){
                requestMillisecondsDelayChange();
                save();
            }

        } while (selectedInputOption < 1 || selectedInputOption > 2);
    }

    private int requestMillisecondsDelayChange(){
        millisecondsDelay = InputHandler.getIntInput("Digite a quantidade de delay em milissegundos: ");

        return millisecondsDelay;
    }

    private void printShowEmojiSelectedOption(){
        System.out.println("Opção selecionada: " + (showEmojis ? "Exibir" : "Não exibir"));
    }

    public void changeShowEmoji(){
        int selectedInputOption;

        do {
            printShowEmojiSelectedOption();
            selectedInputOption = InputHandler.getIntInput("Deseja alterar? 1 (Sim); 2 (Não): ");

            if(selectedInputOption == 1){
                this.showEmojis = !this.showEmojis;
                save();
            }

        } while (selectedInputOption <1 || selectedInputOption > 2);
    }
}
