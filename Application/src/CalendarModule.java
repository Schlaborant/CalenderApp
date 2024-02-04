import javax.swing.JFrame;

public class CalendarModule extends JFrame {
    private CalendarPanel calendarPanel;

    public CalendarModule() {
        setTitle("Kalender-Modul");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Fenster zentrieren

        initializeComponents();
    }

    private void initializeComponents() {
        calendarPanel = new CalendarPanel();
        add(calendarPanel);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new CalendarModule().setVisible(true);
        });
    }
}
