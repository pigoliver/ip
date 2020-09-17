package duke;

import duke.tasks.TaskList;

import java.io.IOException;

public class DeleteCommand {
    public void execute(String others, Ui ui, Storage storage, TaskList taskList) throws DukeException, IOException {
        if(others.isEmpty()){
            throw new DukeException("The index of a delete command cannot be empty.");
        }
        int index = Integer.parseInt(others);
        ui.indentPrint("Noted. I've removed this task: ");
        ui.indentPrint("  "+taskList.deleteTaskAt(index-1).toString());
        storage.saveToFile(taskList);
    }
}
