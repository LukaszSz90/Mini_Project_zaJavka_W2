package pl.zajavka;

import java.util.ArrayDeque;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        QueueCommand<Person> queue = new QueueCommand<>(new ArrayDeque<>(), new ArrayDeque<>());
        CommandProcessor commandProcessor = new CommandProcessor(queue);

        List<String> listOfProcess =   List.of(
            "ADD PERSON(Tomasz_Romański)",
                    "ADD PERSON(Rafał_Adamczuk)",
                    "ADD PERSON(Tomasz_Romański)",
                    "ADD PERSON(Mariusz_Wilczek)",
                    "ADD PERSON(Zbigniew_Ratownik)",
                    "PROCESS",
                    "LEAVE PERSON(Tomasz_Romański_2)",
                    "LEAVE PERSON(Mariusz_Wilczek)",
                    "PROCESS",
                    "PROCESS",
                    "PROCESS"
);

        for (String process : listOfProcess) {
            commandProcessor.processCommand(process);
        }

    }
}