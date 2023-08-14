import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

public class Manual extends JPanel {

    private JTextField sugarField, coeffField;
    private JButton calculateButton, plusButton, minusButton;

    ArrayList <Double> carbs = new ArrayList<>();
    ArrayList <String> sklad = new ArrayList<>();
    HashMap<String, Double> menu = new HashMap<>();
    final double MMOL_TO_MGDL = 18.01559;

    private double hashMenu(String s){

        menu.put("Борщ",0.067);
        menu.put("Хліб білий",0.48);
        menu.put("Хліб чорний",0.41);
        menu.put("Майонез",0.03);
        menu.put("Котлети зі свинини",0.058);
        menu.put("Котлета куряча",0.138);
        menu.put("Пюре",0.094);
        menu.put("Смажена картопля",0.231);
        menu.put("Вареники з картоплею",0.299);
        menu.put("Вареники з сиром",0.317);
        menu.put("Яйце смажене",0.007);
        menu.put("Яйце варене",0.0112);
        menu.put("Гречка",0.175);
        menu.put("Макарони",0.2374);
        menu.put("Рис",0.252);
        menu.put("Огірок свіжий",0.0228);
        menu.put("Помідор",0.039);
        menu.put("Яблуко",0.1295);
        menu.put("Шоколад молочний",0.524);
        menu.put("Вівсяне печево",0.718);
        menu.put("Торт Наполеон",0.387);

        return menu.get(s);

    }
    String[] options = {"Борщ","Хліб білий","Хліб чорний","Майонез","Котлети зі свинини","Котлета куряча","Пюре","Смажена картопля",
            "Вареники з картоплею","Вареники з сиром","Яйце смажене","Яйце варене","Гречка",
            "Макарони","Рис","Огірок свіжий","Помідор","Яблуко","Шоколад молочний","Вівсяне печево","Торт Наполеон"};

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Додаємо зображення на фон
        Image image = new ImageIcon("src/main/resources/Manual.jpg").getImage();
        g.drawImage(image, 0, 0, this);
    }


    public Manual(){

        JLabel coeffLabel = new JLabel("              ");
        coeffField = new JTextField("10.0",5);
        coeffField.setBackground(new Color(102, 46, 28));
        coeffField.setForeground(new Color(235, 220, 178));
        coeffField.setFont((new Font("Century", Font.PLAIN, 16)));
        coeffField.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel sugarLabel = new JLabel("              ");
        sugarField = new JTextField(5);
        sugarField.setBackground(new Color(102, 46, 28));
        sugarField.setForeground(new Color(235, 220, 178));
        sugarField.setFont((new Font("Century", Font.PLAIN, 16)));
        sugarField.setHorizontalAlignment(SwingConstants.CENTER);

        calculateButton = new JButton("Розрахувати");
        calculateButton.setFont((new Font("Century Gothic", Font.PLAIN, 16)));
        calculateButton.setBackground(new Color(102, 46, 28));
        calculateButton.setForeground(new Color(235, 220, 178));

        plusButton = new JButton("Додати їжу");
        plusButton.setFont((new Font("Century Gothic", Font.PLAIN, 16)));
        plusButton.setBackground(new Color(0, 96, 13));
        plusButton.setForeground(new Color(255, 255, 255));

        minusButton = new JButton("Вилучити їжу");
        minusButton.setFont((new Font("Century Gothic", Font.PLAIN, 16)));
        minusButton.setBackground(new Color(108, 0, 0));
        minusButton.setForeground(new Color(255, 255, 255));

        JLabel menuLabel = new JLabel("              ");
        JTextArea textArea = new JTextArea(8, 20);
        textArea.setBorder(BorderFactory.createLineBorder((new Color(255, 255, 255)), 2));
        textArea.setFont((new Font("Century Gothic", Font.PLAIN, 16)));
        textArea.setEditable(false);
        textArea.setBackground(new Color(102, 46, 28));
        textArea.setForeground(new Color(235, 220, 178));
        JScrollPane scrollPane = new JScrollPane(textArea);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(10, 10, 10, 10);
        c.gridwidth = 2;
        add(menuLabel, c);

        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(10, 10, 10, 150);
        c.gridwidth = 2;
        c.gridheight = 3;
        add(scrollPane, c);

        c.gridx = 0;
        c.gridy = 4;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(10, 25, 10, 10);
        c.gridwidth = 1;
        c.gridheight = 1;
        add(plusButton, c);

        c.gridx = 1;
        c.gridy = 4;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(10, 10, 10, 100);
        c.gridwidth = 1;
        c.gridheight = 1;
        add(minusButton, c);

        c.gridx = 2;
        c.gridy = 0;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(10, 10, 10, 10);
        c.gridwidth = 2;
        c.gridheight = 1;
        add(sugarLabel, c);

        c.gridx = 2;
        c.gridy = 1;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(10, 0, 10, 10);
        c.gridwidth = 2;
        c.gridheight = 1;
        add(sugarField, c);

        c.gridx = 2;
        c.gridy = 2;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(10, 10, 10, 10);
        c.gridwidth = 2;
        c.gridheight = 1;
        add(coeffLabel, c);

        c.gridx = 2;
        c.gridy = 3;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(10, 0, 10, 10);
        c.gridwidth = 2;
        c.gridheight = 1;
        add(coeffField, c);

        c.gridx = 1;
        c.gridy = 4;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(10, 200, 10, 10);
        c.gridwidth = 3;
        c.gridheight = 1;
        add(calculateButton, c);

        plusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                try {
                    String n = (String)JOptionPane.showInputDialog(null, "Оберіть іжу зі списку",
                            "Додати", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    double m = Double.parseDouble(JOptionPane.showInputDialog("Кількість грам:"));
                    carbs.add(m*hashMenu(n));
                    sklad.add(n+" - "+m+" грам");
                    textArea.setText("");
                    sklad.forEach((e) ->{
                        textArea.append(e+"\n");
                    });

                }catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Будь ласка, введіть числові значення в поля введення.", "Error", 0);

                }
            }
        });
        minusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if(!sklad.isEmpty()){
                    String[] temp = sklad.toArray(new String[0]);
                    String del = (String)JOptionPane.showInputDialog(null, "Оберіть іжу зі списку",
                            "Видалити", JOptionPane.QUESTION_MESSAGE, null, temp, temp[0]);
                    carbs.remove(sklad.indexOf(del));
                    sklad.remove(del);
                    textArea.setText("");
                    sklad.forEach((e) ->{
                        textArea.append(e+"\n");
                    });
                }else{
                    JOptionPane.showMessageDialog(null, "Список їжі поки-що пустий", "Error", 0);
                }
            }
        });
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (sugarField.getText().isEmpty()||coeffField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Будь ласка, заповніть усі поля введення.", "Error", 0);
                    return;
                }
                if(sklad.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Список їжі поки-що пустий", "Error", 0);
                    return;
                }
                try {
                    double carb = 0.0;
                    for (int i = 0; i < carbs.size(); i++) {
                        carb+= carbs.get(i);
                    }
                    double sugar = Double.parseDouble(sugarField.getText());
                    double coeff = Double.parseDouble(coeffField.getText());
                    if (carb < 0 || sugar < 0|| coeff<0) {
                        JOptionPane.showMessageDialog(null, "Будь ласка, введіть позитивні значення в поля введення.", "Error", 0);
                        return;
                    }
                    double dose = (carb/coeff)+((sugar* MMOL_TO_MGDL)-100)/40.0;
                    //округлення
                    dose = Math.round(dose * 10.0) / 10.0;
                    if (dose < 0) {
                        dose = 0;
                    }

                    String message = "<html>Рекомендована доза інсуліну: <font color='red'>" + dose + "</font><br><br> Введені дані:<br>" + textArea.getText() + "Рівень цукру: " + sugar +
                            " Індивід. коеф.: " + coeff + "\nВуглеводи: " + (Math.round((carb) * 10.0) / 10.0)+" ХО: "+ (Math.round((carb/12) * 10.0) / 10.0)+"";
                    JOptionPane.showMessageDialog(null, message, "Рекомендована доза інсуліну", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Будь ласка, введіть числові значення в поля введення.", "Error", 0);
                }
            }
        });
    }
}
