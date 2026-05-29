package org.example.command;

public class AddCommand implements CommandImpl {
    @Override
    public void commandExecute(String avitoId) {
        System.out.println("addCommand for avitoId: " + avitoId);
    }
}
