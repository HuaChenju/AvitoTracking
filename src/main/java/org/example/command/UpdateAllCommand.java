package org.example.command;

public class UpdateAllCommand implements CommandImpl {
    @Override
    public void commandExecute(String avitoId) {
        System.out.println("updateAllCommand for avitoId: " + avitoId);
    }
}
