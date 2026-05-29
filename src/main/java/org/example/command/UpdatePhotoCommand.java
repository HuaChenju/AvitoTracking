package org.example.command;

public class UpdatePhotoCommand implements CommandImpl {
    @Override
    public void commandExecute(String avitoId) {
        System.out.println("updatePhotoCommand for avitoId: " + avitoId);
    }
}
