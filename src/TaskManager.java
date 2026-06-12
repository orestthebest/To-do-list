import java.util.ArrayList;
import java.util.List;

/**
 * Verwaltet die Sammlung aller Aufgaben der To-Do-Liste.
 * <p>
 * Diese Klasse stellt Methoden zum Hinzufügen, Löschen und Ändern von
 * Aufgaben bereit und kapselt die zugrunde liegende Datenstruktur.
 * </p>
 *
 * @author Projektleiter
 * @version 1.0
 */
public class TaskManager {

    /** Interne Liste, in der alle Aufgaben gespeichert werden. */
    private final List<Task> tasks;

    /**
     * Erstellt einen neuen, leeren TaskManager.
     */
    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Fügt eine neue Aufgabe mit der angegebenen Beschreibung hinzu.
     * Leere oder nur aus Leerzeichen bestehende Beschreibungen werden ignoriert.
     *
     * @param description die Beschreibung der neuen Aufgabe
     */
    public void addTask(String description) {
        if (description != null && !description.trim().isEmpty()) {
            tasks.add(new Task(description.trim()));
        }
    }

    /**
     * Entfernt die Aufgabe am angegebenen Index.
     *
     * @param index der Index der zu entfernenden Aufgabe
     * @throws IndexOutOfBoundsException wenn der Index ungültig ist
     */
    public void removeTask(int index) {
        tasks.remove(index);
    }

    /**
     * Kehrt den Erledigt-Status der Aufgabe am angegebenen Index um.
     *
     * @param index der Index der betreffenden Aufgabe
     * @throws IndexOutOfBoundsException wenn der Index ungültig ist
     */
    public void toggleTaskCompleted(int index) {
        tasks.get(index).toggleCompleted();
    }

    /**
     * Gibt die Aufgabe am angegebenen Index zurück.
     *
     * @param index der Index der gewünschten Aufgabe
     * @return die Aufgabe am angegebenen Index
     * @throws IndexOutOfBoundsException wenn der Index ungültig ist
     */
    public Task getTask(int index) {
        return tasks.get(index);
    }

    /**
     * Gibt die Anzahl aller verwalteten Aufgaben zurück.
     *
     * @return die Anzahl der Aufgaben
     */
    public int getTaskCount() {
        return tasks.size();
    }

    /**
     * Gibt eine Kopie der Liste aller Aufgaben zurück.
     *
     * @return eine Liste mit allen Aufgaben
     */
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }
}
