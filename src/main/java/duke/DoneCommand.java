package duke;

import duke.tasks.TaskList;

import java.io.IOException;

public class DoneCommand {
    public void execute(String others, Ui ui, Storage storage, TaskList taskList) throws DukeException, IOException {
        if(others.isEmpty()){
            throw new DukeException("The index of a done command cannot be empty.");
        }
        int index = Integer.parseInt(others);
        taskList.setDoneAt(index-1);
        ui.indentPrint("Nice! I've marked this task as done: ");
        ui.indentPrint("  "+taskList.getTask(index-1).toString());
        storage.saveToFile(taskList);
    }
}