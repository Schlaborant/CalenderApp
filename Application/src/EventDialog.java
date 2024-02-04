import javax.swing.JDialog;
import javax.swing.JFrame;

public class EventDialog extends JDialog {
    public EventDialog(JFrame owner, boolean modal, int year, int month, int day) {
        super(owner, "Ereignis erstellen/bearbeiten", modal);
        setSize(300, 200);
        // UI-Komponenten und Logik für Ereignisverwaltung hier hinzufügen
    }
}
