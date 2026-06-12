import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;

/**
 * Eigener Renderer für die Darstellung von {@link Task}-Objekten in einer {@link JList}.
 * <p>
 * Erledigte Aufgaben werden grau und durchgestrichen dargestellt, offene
 * Aufgaben in normaler Schrift. Dadurch sind erledigte Aufgaben grafisch
 * sofort von offenen zu unterscheiden.
 * </p>
 *
 * @author Mitglied
 * @version 1.0
 */
public class TaskCellRenderer extends DefaultListCellRenderer {

    /**
     * Liefert die grafische Komponente, mit der eine einzelne Aufgabe
     * in der Liste angezeigt wird.
     *
     * @param list         die Liste, in der die Aufgabe angezeigt wird
     * @param value        das anzuzeigende Objekt (eine {@link Task})
     * @param index        der Index der Aufgabe in der Liste
     * @param isSelected   ob der Eintrag ausgewählt ist
     * @param cellHasFocus ob der Eintrag den Fokus hat
     * @return die konfigurierte Anzeigekomponente
     */
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {

        // Die Oberklasse liefert ein fertig konfiguriertes JLabel zurück.
        JLabel label = (JLabel) super.getListCellRendererComponent(
                list, value, index, isSelected, cellHasFocus);

        if (value instanceof Task) {
            Task task = (Task) value;
            label.setText(task.getDescription());

            if (task.isCompleted()) {
                // Schrift durchstreichen und ausgegraut darstellen.
                Font font = label.getFont();
                Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
                attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                label.setFont(font.deriveFont(attributes));
                if (!isSelected) {
                    label.setForeground(Color.GRAY);
                }
            }
        }
        return label;
    }
}
