package Animals;

import Animals.Abstract.Animal;

public class Duck extends Animal {
    private static final String emoji = "🦆";
    private static final String sound = "Quá, quá, quá, quá";
    private static final String maleName = "patinho";
    private static final String femaleName = "patinha";
    private static final String malePluralName = "patinhos";

    private static final String asciiArt = """
                                                                                                   \s
                                                ██████████                                 \s
                                          ░░  ██░░░░░░░░░░██                               \s
                                            ██░░░░░░░░░░░░░░██                             \s
                                            ██░░░░░░░░████░░██████████                     \s
                                ██          ██░░░░░░░░████░░██▒▒▒▒▒▒██                     \s
                              ██░░██        ██░░░░░░░░░░░░░░██▒▒▒▒▒▒██                     \s
                              ██░░░░██      ██░░░░░░░░░░░░░░████████                       \s
                            ██░░░░░░░░██      ██░░░░░░░░░░░░██                             \s
                            ██░░░░░░░░████████████░░░░░░░░██                               \s
                            ██░░░░░░░░██░░░░░░░░░░░░░░░░░░░░██                             \s
                            ██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██                           \s
                            ██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██                           \s
                            ██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██                           \s
                            ██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██                           \s
                            ██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██                           \s
                            ██░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██                             \s
                              ██░░░░░░░░░░░░░░░░░░░░░░░░░░██                               \s
                                ██████░░░░░░░░░░░░░░░░████                                 \s
                                      ████████████████                                     \s
                                                                                           \s
            """;

    public Duck() {
        super(emoji, sound, maleName, femaleName, malePluralName, asciiArt);
    }
}
