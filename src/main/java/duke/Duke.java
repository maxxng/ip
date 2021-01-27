package duke;

import duke.customClass.Command;
import duke.customClass.Ui;
import duke.customClass.Storage;
import duke.customClass.TaskList;
import duke.customClass.Parser;
import duke.customClass.CommandRouter;


public class Duke {
    private Ui ui;
    private Storage storage;
    private TaskList tasks;

    public Duke(String path) {
        ui = new Ui();
        storage = new Storage(path);
        tasks = new TaskList();
        tasks.dataInput(storage.loadData());
    }

    public void run() {
        CommandRouter commandRouter = new CommandRouter();
        boolean isExit = false;

        ui.greetingMessage();

        while (!isExit) {
            String inputCommand = ui.readInput();
            ui.separatorLine();
            Command parsedCommand = Parser.parse(inputCommand);
            commandRouter.route(parsedCommand, tasks, inputCommand);
            isExit = commandRouter.isExit();
            ui.separatorLine();
        }
        storage.save(tasks.getList());

        ui.exitMessage();
    }

    public static void main(String[] args) {
        new Duke("src/data/duke.tasks.txt").run();
    }
}


