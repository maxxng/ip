package customClass;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    public Deadline(String description, boolean isDone, String by) {
        super(description, isDone);
        this.by = by;
    }

    public String saveString() {
        return isDone ? "D --- 1 --- " + description + " --- " + by : "D --- 0 --- " + description + " --- " + by;
    }

    public static String convertToDate(String input) {
        try {
            LocalDate date = LocalDate.parse(input);
            return date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        } catch (DateTimeException e) {
            return input;
        }
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + Deadline.convertToDate(by) + ")";
    }
}
