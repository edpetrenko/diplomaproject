import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Personal_HO extends JPanel {

    private JTextField hoField, sugarField, doseField, coeffField;
    private JButton calculateButton;
    final double MMOL_TO_MGDL = 18.01559;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Додаємо зображення на фон
        Image image = new ImageIcon("src/main/resources/personalHO.jpg").getImage();
        g.drawImage(image, 0, 0, this);
    }

    public Personal_HO() {
        // Створення елементів користувацького інтерфейсу
        JLabel hoLabel = new JLabel("                     ");
        hoLabel.setFont((new Font("Arial", Font.BOLD, 16)));

        hoField = new JTextField(5);
        hoField.setFont((new Font("Century", Font.PLAIN, 16)));
        hoField.setBackground(new Color(108, 45, 44));
        hoField.setForeground(new Color(241, 220, 201));

        JLabel sugarLabel = new JLabel("                                 ");
        sugarLabel.setFont((new Font("Arial", Font.BOLD, 16)));

        JLabel coeffLabel = new JLabel("                                 ");
        sugarLabel.setFont((new Font("Arial", Font.BOLD, 16)));

        coeffField = new JTextField("10.0",5);
        coeffField.setBackground(new Color(108, 45, 44));
        coeffField.setForeground(new Color(241, 220, 201));
        coeffField.setFont((new Font("Century", Font.PLAIN, 16)));

        sugarField = new JTextField(5);
        sugarField.setBackground(new Color(108, 45, 44));
        sugarField.setForeground(new Color(241, 220, 201));
        sugarField.setFont((new Font("Century", Font.PLAIN, 16)));

        calculateButton = new JButton("Розрахувати");
        calculateButton.setFont((new Font("Century Gothic", Font.PLAIN, 16)));
        calculateButton.setBackground(new Color(159, 70, 54));
        calculateButton.setForeground(new Color(241, 220, 201));

        JLabel doseLabel = new JLabel("                            ");
        doseLabel.setFont((new Font("Arial", Font.BOLD, 16)));

        doseField = new JTextField(5);
        doseField.setBackground(new Color(159, 70, 54));
        doseField.setForeground(new Color(241, 220, 201));
        doseField.setFont((new Font("Century", Font.PLAIN, 16)));
        doseField.setEditable(false);

        JButton helpButton = new JButton("Help");
        helpButton.setFont((new Font("Century Gothic", Font.PLAIN, 16)));
        helpButton.setBackground(new Color(108, 45, 44));
        helpButton.setForeground(new Color(241, 220, 201));

        JButton infoButton = new JButton("Info");
        infoButton.setFont((new Font("Century Gothic", Font.PLAIN, 16)));
        infoButton.setBackground(new Color(241, 220, 201));
        infoButton.setForeground(new Color(108, 45, 44));

        // Додавання елементів на панель
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(10, 10, 10, 210);
        add(hoLabel, c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(15, 10, 10, 10);
        hoField.setHorizontalAlignment(SwingConstants.CENTER);
        add(hoField, c);

        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(10, 10, 10, 210);
        add(sugarLabel, c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(10, 10, 10, 10);
        sugarField.setHorizontalAlignment(SwingConstants.CENTER);
        add(sugarField, c);

        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(10, 10, 10, 210);
        add(coeffLabel, c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(10, 10, 10, 10);
        coeffField.setHorizontalAlignment(SwingConstants.CENTER);
        add(coeffField, c);

        c.gridx = 0;
        c.gridy = 3;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(10, 10, 10, 210);
        add(doseLabel, c);

        c.gridx = 1;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(10, 10, 10, 10);
        doseField.setHorizontalAlignment(SwingConstants.CENTER);
        add(doseField, c);

        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(20, 10, 10, 75);
        add(helpButton, c);

        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(20, 175, 10, 10);
        add(calculateButton, c);

        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(20, 10, 10, 225);
        add(infoButton, c);


        helpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Цей калькулятор рахує необхідну дозу інсуліну на основі прийнятих Вами вуглеводів, а також враховує\nіндивідуальний коефіцієнт, заповніть поля і натисніть на кнопку \"Розрахувати\".\n" +
                                "\n" +
                                "Щоб дізнатися більше про індивідуальний коефіцієнт натисніть на кнопку \"Info\"\n" +
                                "\n" +
                                "1. Значення мають бути позитивними \n" +
                                "2. Поля \"Кількість вуглеводів\", \"Рівень цукру в крові\" та \"Індивідуальний коефіцієнт\" мають бути заповнені\n" +
                                "3. Значення в полі \"Рівень цукру в крові\" має бути в ммоль/л, якщо ваш глюкометр показує значення в mg/dl, \nто Ви можете розділити це значення на 18 і отримаєте mmol/l (наприклад, 180 mg/dl=10 mmol/l)."
                        , "Help", 1);
            }
        });
        infoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(null, "Індивідуальний коефіцієнт, також відомий як коефіцієнт чутливості до інсуліну,\n" +
                                "може бути різним у кожної людини і залежить від різних чинників, таких як вага,\nвік, рівень активності, стан здоров'я, наявність " +
                                "інших медичних проблем тощо." +
                                "\n\n" +
                                "Зазвичай, для визначення індивідуального коефіцієнта, лікарі рекомендують \nпровести тестування, яке називається тестування чутливості" +
                                " до інсуліну. Під\nчас тестування вимірюють рівень глюкози в крові до і після вживання певної \nкількості вуглеводів та інсуліну. Потім, " +
                                "на підставі цих даних, можна обчислити\nіндивідуальний коефіцієнт чутливості до інсуліну." +
                                "\n\n" +
                                "Якщо ви не проводили тестування, то для початку можна скористатися\nстандартними коефіцієнтами, які рекомендуються лікарями. " +
                                "Наприклад, для\nлюдей із типом 1 діабету зазвичай рекомендується використовувати коефіцієнт\n1:10 - це означає, що на кожні 10 грамів " +
                                "вуглеводів потрібна 1 одиниця інсуліну.\nОднак, цей коефіцієнт може бути скоригований залежно від індивідуальних\nпотреб і рекомендацій лікаря."
                        , "Info", 1);
            }
        });
        // Додавання ActionListener для кнопки "Розрахува
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (hoField.getText().isEmpty() || sugarField.getText().isEmpty()||coeffField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Будь ласка, заповніть усі поля введення.", "Error", 0);
                    return;
                }

                try {
                    double ho = Double.parseDouble(hoField.getText());
                    double sugar = Double.parseDouble(sugarField.getText());
                    double coeff = Double.parseDouble(coeffField.getText());
                    if (ho < 0 || sugar < 0|| coeff<0) {
                        JOptionPane.showMessageDialog(null, "Будь ласка, введіть позитивні значення в поля введення.", "Error", 0);
                        return;
                    }

                    double dose = ((ho*12)/coeff)+((sugar* MMOL_TO_MGDL)-100)/40.0;

                    //округлення
                    dose = Math.round(dose * 10.0) / 10.0;
                    if (dose < 0) {
                        dose = 0;
                    }
                    doseField.setBackground(new Color(80, 0, 21));
                    doseField.setForeground(new Color(255, 255, 255));
                    doseField.setText(String.valueOf(dose));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Будь ласка, введіть числові значення в поля введення.", "Error", 0);
                }
            }
        });
    }
}