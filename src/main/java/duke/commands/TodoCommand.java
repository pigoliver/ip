package duke.commands;

import duke.DukeException;
import duke.Storage;
import duke.Ui;
import duke.tasks.TaskList;

import java.io.IOException;

public class TodoCommand {
    public void execute(String others, Ui ui, Storage storage, TaskList taskList) throws DukeException, IOException {
        if(others.isEmpty()){
            throw new DukeException("The description of a todo cannot be empty.");
        }
        taskList.addTodoToTemp(others);
        ui.indentPrint("Got it. I've added this task: ");
        ui.indentPrint("  "+taskList.getTask(taskList.getSize()-1).toString());
        ui.indentPrint( "Now you have "+taskList.getSize()+" tasks in the list.");
        storage.saveToFile(taskList);
    }
}