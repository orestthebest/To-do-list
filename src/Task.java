/**
 * Repräsentiert eine einzelne Aufgabe (To-Do) innerhalb der Anwendung.
 * <p>
 * Eine Aufgabe besteht aus einer Beschreibung und einem Status, der angibt,
 * ob die Aufgabe bereits erledigt wurde.
 * </p>
 *
 * @author Projektleiter
 * @version 1.0
 */
public class Task {

    /** Die textuelle Beschreibung der Aufgabe. */
    private String description;

    /** Gibt an, ob die Aufgabe erledigt ist ({@code true}) oder nicht ({@code false}). */
    private boolean completed;

    /**
     * Erstellt eine neue, noch nicht erledigte Aufgabe.
     *
     * @param description die Beschreibung der Aufgabe
     */
    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    /**
     * Gibt die Beschreibung der Aufgabe zurück.
     *
     * @return die Beschreibung der Aufgabe
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setzt eine neue Beschreibung für die Aufgabe.
     *
     * @param description die neue Beschreibung
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Prüft, ob die Aufgabe als erledigt markiert ist.
     *
     * @return {@code true}, wenn die Aufgabe erledigt ist, sonst {@code false}
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Setzt den Erledigt-Status der Aufgabe.
     *
     * @param completed der neue Status
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    /**
     * Kehrt den Erledigt-Status der Aufgabe um.
     * Eine erledigte Aufgabe wird wieder offen, eine offene wird erledigt.
     */
    public void toggleCompleted() {
        this.completed = !this.completed;
    }

    /**
     * Gibt eine lesbare Darstellung der Aufgabe zurück.
     * Erledigte Aufgaben werden mit "[x]", offene mit "[ ]" gekennzeichnet.
     *
     * @return die String-Darstellung der Aufgabe
     */
    @Override
    public String toString() {
        return (completed ? "[x] " : "[ ] ") + description;
    }
}
