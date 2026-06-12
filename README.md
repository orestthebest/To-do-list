# To-Do-Liste (Java + Swing)

Ein einfaches Aufgabenverwaltungs-Programm mit grafischer Oberfläche.
Entwickelt im Rahmen des Softwareentwicklungsprojekts mit Git und Grafikelementen.

## Funktionen
- Aufgaben hinzufügen
- Aufgaben als erledigt markieren bzw. wieder als offen markieren
- Aufgaben löschen
- Erledigte Aufgaben werden grau und durchgestrichen dargestellt

## Team
- **Projektleiter:** <dein Name> – Logik (`Task`, `TaskManager`), Einstiegspunkt (`Main`)
- **Mitglied:** <Name deines Freundes> – Oberfläche (`MainWindow`, `TaskCellRenderer`)

## Projektstruktur
```
todo/
├── src/
│   ├── Main.java              // Einstiegspunkt
│   ├── Task.java              // Modellklasse für eine Aufgabe
│   ├── TaskManager.java       // Verwaltung aller Aufgaben (Logik)
│   ├── MainWindow.java        // Grafische Oberfläche (Swing)
│   └── TaskCellRenderer.java  // Darstellung erledigter Aufgaben
├── .gitignore
└── README.md
```

## Kompilieren und Starten
```bash
javac -d out -encoding UTF-8 src/*.java
java -cp out Main
```

## Javadoc erzeugen
```bash
javadoc -d docs -encoding UTF-8 -charset UTF-8 src/*.java
```
Danach `docs/index.html` im Browser öffnen.
