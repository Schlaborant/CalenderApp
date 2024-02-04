import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class CalendarPanel extends JPanel {
    private Calendar cal = new GregorianCalendar();
    private JLabel monthLabel = new JLabel("", SwingConstants.CENTER);
    private JPanel calendarDaysPanel = new JPanel();

    public CalendarPanel() {
        setLayout(new BorderLayout());
        initializeUI();
        updateCalendar();
    }

    private void initializeUI() {
        addNavigation();
        calendarDaysPanel.setLayout(new GridLayout(0, 7, 5, 5)); // 7 columns for days of the week
        add(calendarDaysPanel, BorderLayout.CENTER);
    }

    private void addNavigation() {
        JPanel navigationPanel = new JPanel();
        JButton prevMonth = new JButton("<");
        JButton nextMonth = new JButton(">");
        
        prevMonth.addActionListener(e -> {
            cal.add(Calendar.MONTH, -1);
            updateCalendar();
        });
        
        nextMonth.addActionListener(e -> {
            cal.add(Calendar.MONTH, 1);
            updateCalendar();
        });
        
        navigationPanel.add(prevMonth);
        navigationPanel.add(monthLabel);
        navigationPanel.add(nextMonth);
        
        add(navigationPanel, BorderLayout.NORTH);
    }

    private void updateCalendar() {
        monthLabel.setText(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()) + " " + cal.get(Calendar.YEAR));
        calendarDaysPanel.removeAll();

        // Add day of the week headers
        String[] daysOfWeek = {"So", "Mo", "Di", "Mi", "Do", "Fr", "Sa"};
        for (String day : daysOfWeek) {
            calendarDaysPanel.add(new JLabel(day, SwingConstants.CENTER));
        }

        int startDay = cal.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Adjust for the start of the week (Sunday=1, Monday=2, ...)
        int blankDays = (startDay - cal.getFirstDayOfWeek() + 7) % 7;

        for (int i = 0; i < blankDays; i++) {
            calendarDaysPanel.add(new JLabel(""));
        }

        for (int i = 1; i <= daysInMonth; i++) {
            JButton dayButton = new JButton(Integer.toString(i));
            calendarDaysPanel.add(dayButton);
            // Add ActionListeners to dayButton here if needed
        }

        calendarDaysPanel.revalidate();
        calendarDaysPanel.repaint();
    }
}
