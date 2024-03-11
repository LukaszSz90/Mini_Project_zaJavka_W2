package pl.zajavka;

import javax.swing.text.html.ListView;

public class CommandProcessor {
    private QueueCommand<Person> queueCommand;

    public CommandProcessor(QueueCommand<Person> queueCommand) {
        this.queueCommand = queueCommand;
    }

    public void processCommand(String command) {
        if (command.contains("ADD PERSON")) {
            addIncomePerson(command, command.contains("VIP"));
        } else if (command.contains("LEAVE")) {
            leavePerson(command);
        } else if (command.contains("PROCESS")) {
            processPerson(command);
        } else {
            throw new RuntimeException("Unknown command");
        }
    }

    private void addIncomePerson(String command, boolean isVip) {
        System.out.println(command);
        Person incomePerson = createPerson(command, isVip);

        if (isVip) {
            queueCommand.joinToQueueVip(incomePerson);
        } else {
            queueCommand.joinToQueue(incomePerson);
        }
    }

    private void leavePerson(String command) {
        System.out.println(command);
        Person leavingPerson = createLeavingPerson(command);
        queueCommand.leaveQueue(leavingPerson);
    }

    private void processPerson(String command) {
        System.out.println(command);
        queueCommand.enterToStore();
    }


    private Person createPerson(String command, boolean vip) {
        String replaceCommand = command
                .replace("ADD PERSON(", "")
                .replace(vip ? ",VIP)" : ")", "");

        String[] splitData = replaceCommand.split("_");

        if (splitData.length == 2) {
            return new Person(splitData[0], splitData[1], queueCommand.checkAndIncrementCount(command));
        } else {
            throw new IllegalArgumentException("Illegal argument: " + command);
        }
    }

    private Person createLeavingPerson(String command) {
        String replaceCommand = command
                .replace("LEAVE PERSON(", "")
                .replace(")", "");

        String[] splitData = replaceCommand.split("_");

        if(splitData.length == 2) {
            return new Person(splitData[0], splitData[1], 1);
        } else if (splitData.length == 3) {
            return new Person(splitData[0], splitData[1], Integer.parseInt(splitData[2]));
        } else {
            throw new IllegalArgumentException("Illegal argument: " + command);
        }
    }
}
