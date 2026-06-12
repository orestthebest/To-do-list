# Requirements Design – To-Do-Liste

## Projektbeschreibung
Das Programm ist eine To-Do-Listen-Anwendung mit grafischer Oberfläche (Swing).
Der Benutzer kann Aufgaben anlegen, als erledigt markieren und wieder löschen.

## Ziele (Was soll das Programm können?)
- **Z1 – Aufgaben hinzufügen:** Der Benutzer kann über ein Eingabefeld und einen
  Button eine neue Aufgabe zur Liste hinzufügen.
- **Z2 – Aufgaben anzeigen:** Alle Aufgaben werden in einer scrollbaren Liste
  grafisch dargestellt.
- **Z3 – Aufgaben als erledigt markieren:** Eine ausgewählte Aufgabe kann als
  erledigt bzw. wieder als offen markiert werden.
- **Z4 – Erledigte Aufgaben optisch unterscheiden:** Erledigte Aufgaben werden
  grau und durchgestrichen dargestellt (Grafikelement).
- **Z5 – Aufgaben löschen:** Eine ausgewählte Aufgabe kann aus der Liste entfernt
  werden.
- **Z6 – Robuste Bedienung:** Bei ungültiger Bedienung (z. B. löschen ohne Auswahl)
  erscheint ein verständlicher Hinweis; leere Eingaben werden ignoriert.

## Nicht-Ziele (Was ist explizit nicht Teil des Projekts?)
- **N1 – Keine dauerhafte Speicherung:** Die Aufgaben werden nicht in einer Datei
  oder Datenbank gespeichert; beim Beenden gehen sie verloren.
- **N2 – Keine Fälligkeitsdaten oder Erinnerungen.**
- **N3 – Keine Kategorien, Prioritäten oder Sortierung.**
- **N4 – Keine Mehrbenutzerfähigkeit und kein Netzwerk/Cloud-Zugriff.**
- **N5 – Keine mobile App und keine Web-Version.**

## Zuständigkeiten (für die Präsentation wichtig)
| Mitglied        | Ziele            | Umgesetzt in                       |
|-----------------|------------------|------------------------------------|
| Projektleiter   | Z1, Z3, Z5, Z6   | `Task.java`, `TaskManager.java`    |
| Mitglied        | Z2, Z4           | `MainWindow.java`, `TaskCellRenderer.java` |
