import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;

/**
 * Das Hauptfenster der To-Do-Listen-Anwendung.
 * <p>
 * Diese Klasse baut die grafische Benutzeroberfläche (GUI) mit Swing auf und
 * verbindet die Bedienelemente (Eingabefeld, Buttons, Liste) mit der Logik
 * des {@link TaskManager}.
 * </p>
 *
 * @author Mitglied
 * @version 1.0
 */
public class MainWindow extends JFrame {

    /** Verwaltet die Aufgaben im Hintergrund. */
    private final TaskManager taskManager;

    /** Datenmodell für die grafische Aufgabenliste. */
    private final DefaultListModel<Task> listModel;

    /** Grafische Komponente zur Anzeige der Aufgaben. */
    private final JList<Task> taskList;

    /** Eingabefeld für neue Aufgaben. */
    private final JTextField inputField;

    /**
     * Erstellt das Hauptfenster und baut die gesamte Oberfläche auf.
     */
    public MainWindow() {
        this.taskManager = new TaskManager();
        this.listModel = new DefaultListModel<>();
        this.taskList = new JList<>(listModel);
        this.inputField = new JTextField();

        initUI();
    }

    /**
     * Initialisiert und ordnet alle grafischen Komponenten an.
     */
    private void initUI() {
        setTitle("To-Do-Liste");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Aufgabenliste mit eigenem Renderer (erledigte Aufgaben durchgestrichen).
        taskList.setCellRenderer(new TaskCellRenderer());
        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Aufgaben"));
        add(scrollPane, BorderLayout.CENTER);

        // Oberer Bereich: Eingabefeld + Hinzufügen-Button.
        JPanel topPanel = new JPanel(new BorderLayout(5, 5));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        JButton addButton = new JButton("Hinzufügen");
        topPanel.add(inputField, BorderLayout.CENTER);
        topPanel.add(addButton, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);

        // Unterer Bereich: Erledigt- und Löschen-Button.
        JPanel bottomPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        JButton toggleButton = new JButton("Erledigt / Offen");
        JButton deleteButton = new JButton("Löschen");
        bottomPanel.add(toggleButton);
        bottomPanel.add(deleteButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Aktionen mit den Buttons verknüpfen.
        addButton.addActionListener(e -> addTask());
        inputField.addActionListener(e -> addTask()); // Reaktion auf die Enter-Taste.
        toggleButton.addActionListener(e -> toggleSelectedTask());
        deleteButton.addActionListener(e -> deleteSelectedTask());
    }

    /**
     * Liest den Text aus dem Eingabefeld, legt eine neue Aufgabe an
     * und aktualisiert die Anzeige.
     */
    private void addTask() {
        String text = inputField.getText();
        taskManager.addTask(text);
        inputField.setText("");
        refreshList();
    }

    /**
     * Ändert den Status der aktuell ausgewählten Aufgabe (erledigt/offen).
     * Ist keine Aufgabe ausgewählt, wird ein Hinweis angezeigt.
     */
    private void toggleSelectedTask() {
        int index = taskList.getSelectedIndex();
        if (index >= 0) {
            taskManager.toggleTaskCompleted(index);
            refreshList();
            taskList.setSelectedIndex(index);
        } else {
            JOptionPane.showMessageDialog(this, "Bitte zuerst eine Aufgabe auswählen.");
        }
    }

    /**
     * Löscht die aktuell ausgewählte Aufgabe.
     * Ist keine Aufgabe ausgewählt, wird ein Hinweis angezeigt.
     */
    private void deleteSelectedTask() {
        int index = taskList.getSelectedIndex();
        if (index >= 0) {
            taskManager.removeTask(index);
            refreshList();
        } else {
            JOptionPane.showMessageDialog(this, "Bitte zuerst eine Aufgabe auswählen.");
        }
    }

    /**
     * Aktualisiert die grafische Liste anhand der aktuellen Daten
     * des {@link TaskManager}.
     */
    private void refreshList() {
        listModel.clear();
        for (Task task : taskManager.getAllTasks()) {
            listModel.addElement(task);
        }
    }
}
