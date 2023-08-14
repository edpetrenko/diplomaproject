import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;

public class InsulinCalculator extends JFrame {

    private JTabbedPane tabbedPane;


    public InsulinCalculator() {
        super("GlucoseGuardian");
        ImageIcon icon = new ImageIcon("src/main/resources/icon2.jpg");
        setIconImage(icon.getImage());
        // Установка LAF Nimbus и цвета декорации окна
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    UIManager.getLookAndFeelDefaults().put("nimbusBase", Color.RED); // установка цвета декорации окна
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        getRootPane().setBackground(Color.RED);

        // Створення табів
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Ручний", new Manual());
        tabbedPane.addTab("Вуглеводи", new PersonalCarb());
        tabbedPane.addTab("Хлібні одиниці", new Personal_HO());

        // Додавання табів на фрейм
        add(tabbedPane);

        // Налаштування фрейма
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setSize(610, 472);
        setVisible(true);

        //
    }

    public static void main(String[] args) {
        InsulinCalculator frame = new InsulinCalculator();
    }
}