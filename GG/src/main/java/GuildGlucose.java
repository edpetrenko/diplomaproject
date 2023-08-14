import javax.swing.*;

public class GuildGlucose {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InsulinCalculator();
            }
        });
    }
}