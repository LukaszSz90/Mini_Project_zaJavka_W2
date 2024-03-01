package pl.zajavka;

import java.util.List;
import java.util.Random;

public final class PersonGenerator {

    private final static List<String> listOfName = List.of(
            "Jan", "Kamil", "Antoni","Filip", "Szymon", "Igor",
            "Tomasz", "Zenon", "Bogdan", "Arkadiusz", "Cezary", "Kornel");

    private final static List<String> listOfSurname = List.of(
            "Kowalski", "Nowak", "Szymanowski", "Krosinski", "Wisniewski",
            "Palminski", "Kozak", "Szczepaniak", "Leszczynski", "Wilczek");

    public static String personBuild() {
        int listNameSize = listOfName.size();
        int listSurnameSize = listOfSurname.size();

        Random rand = new Random();
        int genNameNumber = rand.nextInt(listNameSize) + 1;
        int genSurnameNumber = rand.nextInt(listSurnameSize) + 1;

        return listOfName.get(genNameNumber) + "_" + listOfSurname.get(genSurnameNumber);
    }
}
