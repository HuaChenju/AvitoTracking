package org.example.command;

public class UpdatePartCommand implements CommandImpl {
    @Override
    public void commandExecute(String avitoId) {
        System.out.println("updatePartCommand for avitoId: " + avitoId);
    }
}
