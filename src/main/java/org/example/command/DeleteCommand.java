package org.example.command;

public class DeleteCommand implements CommandImpl {
    @Override
    public void commandExecute(String avitoId) {
        System.out.println("deleteCommand for avitoId: " + avitoId);
    }
}
