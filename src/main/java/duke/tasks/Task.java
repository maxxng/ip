package duke.tasks;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public boolean toggleIsDone() {
        isDone = !isDone;
        return isDone;
    }

    public String getDescription() {
        return description;
    }

    public String saveString() {
        return isDone ? "Task *** 1 *** " + description : "Task *** 0 *** " + description;
    }

    public String toString() {
        return String.format("[%s] %s", getStatusIcon(), description);
    }
}
