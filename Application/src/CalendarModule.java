import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarModule extends JFrame {
    
    private Calendar cal = new GregorianCalendar();
    
    public CalendarModule() {
        setTitle("KalenderApp");
        setSize(300, 200); // Setze die Größe des Fensters
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Beendet die Anwendung, wenn das Fenster geschlossen wird
        createCalendarView();
    }
    
    private void createCalendarView() {
        JPanel panel = new JPanel(new GridLayout(0, 7)); // 7 Spalten für Tage der Woche
        
        // Buttons für Tage (vereinfacht, nur als Platzhalter)
        for (int i = 1; i <= 31; i++) {
            JButton btn = new JButton(String.valueOf(i));
            panel.add(btn);
        }
        
        this.add(panel);
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new CalendarModule().setVisible(true);
        });
    }
}
