
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import javax.swing.JPanel;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import java.text.DecimalFormat;

public class Scientific extends JFrame implements ActionListener, KeyListener {

    Color background = new Color(27, 27, 27);
    Color buttons = new Color(42, 42, 42);
    Color sci = new Color(82, 82, 82);
    Color eq = new Color(178, 89, 4);

    double first_num, second_num;
    String operations = null;
    JPanel panel;

    JTextField textField;

    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, comma, plus, minus,
            divide, multiple, cos, sin, tan, sqrt, clear, back, equal, power, modulo, exponential, pi, Bin, Hex, stander, equation;

    JTextArea historyText;
    //  JScrollPane historyScroller;

    DecimalFormat format = new DecimalFormat("0.###############");

    // ظ„طھط­ط¯ظٹط¯ ظ†ظˆط¹ ط®ط· ظˆ ط­ط¬ظ… ط§ظ„ط£ط´ظٹط§ط، ط§ظ„طھظٹ ط³ظ†ط¶ظٹظپظ‡ط§ ظپظٹ ط§ظ„ظ†ط§ظپط°ط© font ط³ظ†ط³طھط®ط¯ظ… ط§ظ„ظƒط§ط¦ظ†ط§طھ
    Font font1 = new Font("Arial", Font.BOLD, 17);
    Font font2 = new Font("Arial", Font.BOLD, 9);
    Font font3 = new Font("Arial", Font.BOLD, 12);

    private void b0_isClicked() {
        String iNum = textField.getText() + b0.getText();
        textField.setText(iNum);

    }

    private void b1_isClicked() {
        String iNum = textField.getText() + b1.getText();
        textField.setText(iNum);
    }

    private void b2_isClicked() {
        String iNum = textField.getText() + b2.getText();
        textField.setText(iNum);
    }

    private void b3_isClicked() {
        String iNum = textField.getText() + b3.getText();
        textField.setText(iNum);
    }

    private void b4_isClicked() {
        String iNum = textField.getText() + b4.getText();
        textField.setText(iNum);
    }

    private void b5_isClicked() {
        String iNum = textField.getText() + b5.getText();
        textField.setText(iNum);
    }

    private void b6_isClicked() {
        String iNum = textField.getText() + b6.getText();
        textField.setText(iNum);
    }

    private void b7_isClicked() {
        String iNum = textField.getText() + b7.getText();
        textField.setText(iNum);
    }

    private void b8_isClicked() {
        String iNum = textField.getText() + b8.getText();
        textField.setText(iNum);
    }

    private void b9_isClicked() {
        String iNum = textField.getText() + b9.getText();
        textField.setText(iNum);
    }

    private void sin_isClicked() {
        double ops = Double.parseDouble(textField.getText());
        ops = Math.sin((ops / 180) * (double) 22 / 7);
        textField.setText(String.valueOf(ops));
    }

    private void cos_isClicked() {
        double ops = Double.parseDouble(textField.getText());
        ops = Math.cos((ops / 180) * (double) 22 / 7);
        textField.setText(String.valueOf(ops));
    }

    private void tan_isClicked() {
        double ops = Double.parseDouble(textField.getText());
        ops = Math.tan((ops / 180) * (double) 22 / 7);
        textField.setText(String.valueOf(ops));
    }

    private void sqrt_isClicked() {
        double ops = Double.parseDouble(textField.getText());
        if (ops > 0) {
            ops = Math.sqrt(ops);
            textField.setText(String.valueOf(ops));
        } else {
            textField.setText("Undefind...");
        }
    }

    private void exponential_isClicked() {

        String iNum = textField.getText() + String.valueOf((double) 2.71828);
        textField.setText(iNum);
    }

    private void pi_isClicked() {
        String iNum = textField.getText() + String.valueOf((double) 22 / 7);
        textField.setText(iNum);
    }

    private void plus_isClicked() {

        first_num = Double.parseDouble(textField.getText());
        textField.setText(null);
        operations = "+";
    }

    private void minus_isClicked() {
        first_num = Double.parseDouble(textField.getText());
        textField.setText(null);
        operations = "-";
    }

    private void multiple_isClicked() {
        first_num = Double.parseDouble(textField.getText());
        textField.setText(null);
        operations = "*";
    }

    private void divide_isClicked() {
        first_num = Double.parseDouble(textField.getText());
        textField.setText(null);
        operations = "/";
    }

    private void modulo_isClicked() {
        first_num = Double.parseDouble(textField.getText());
        textField.setText(null);
        operations = "%";
    }

    private void power_isClicked() {
        first_num = Double.parseDouble(textField.getText());
        textField.setText(null);
        operations = "^";
    }

    private void comma_isClicked() {
        if (!textField.getText().contains(".")) {
            textField.setText(textField.getText() + comma.getText());
        }
    }

    private void equal_isClicked() {
        double result;
        second_num = Double.parseDouble(textField.getText());
        if (null != operations) {
            switch (operations) {
                case "+":
                    result = first_num + second_num;
                    textField.setText(String.valueOf(result));
                    break;
                case "-":
                    result = first_num - second_num;
                    textField.setText(String.valueOf(result));
                    break;
                case "*":
                    result = first_num * second_num;
                    textField.setText(String.valueOf(result));
                    break;
                case "/":
                    result = first_num / second_num;
                    textField.setText(String.valueOf(result));
                    break;
                case "^":
                    result = Math.pow(first_num, second_num);
                    textField.setText(String.valueOf(result));
                    break;
                case "%":
                    result = first_num % second_num;
                    textField.setText(String.valueOf(result));
                    break;
                default:
                    break;
            }
        }
    }

    private void back_isClicked() {
        String bks = "";
        if (textField.getText().length() > 0) {
            StringBuilder strB = new StringBuilder(textField.getText());
            strB.deleteCharAt(textField.getText().length() - 1);
            bks = strB.toString();
            textField.setText(bks);
        }
    }

    private void clear_isClicked() {
        textField.setText("");
    }

    private void createAndShowGUI() {

        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }

        panel = new JPanel(null);
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        comma = new JButton(".");
        plus = new JButton("+");
        minus = new JButton("-");
        multiple = new JButton("×");
        divide = new JButton("÷");
        cos = new JButton("cos");
        sin = new JButton("sin");
        tan = new JButton("tan");
        sqrt = new JButton("√");
        power = new JButton("^");
        modulo = new JButton("%");
        exponential = new JButton("e");
        pi = new JButton("π");
        stander = new JButton("Stander");
        equation = new JButton("Equation");
        equal = new JButton("=");
        clear = new JButton("C");
        back = new JButton("←");
        textField = new JTextField("");
        Bin = new JButton("Bin");
        Hex = new JButton("Hex");

        historyText = new JTextArea();

        panel.setBounds(0, 0, 256, 400);
        panel.setBackground(background);

        textField.setBounds(11, 11, 234, 60);
        textField.setBackground(sci);

        cos.setBounds(10, 80, 45, 38);
        sin.setBounds(58, 80, 45, 38);
        tan.setBounds(106, 80, 45, 38);
        back.setBounds(154, 80, 45, 38);
        clear.setBounds(202, 80, 45, 38);
        pi.setBounds(10, 121, 45, 38);
        exponential.setBounds(58, 121, 45, 38);
        modulo.setBounds(106, 121, 45, 38);
        b7.setBounds(10, 161, 45, 38);
        b8.setBounds(58, 161, 45, 38);
        b9.setBounds(106, 161, 45, 38);
        plus.setBounds(154, 161, 45, 38);
        power.setBounds(202, 161, 45, 38);
        b4.setBounds(10, 201, 45, 38);
        b5.setBounds(58, 201, 45, 38);
        b6.setBounds(106, 201, 45, 38);
        minus.setBounds(154, 201, 45, 38);
        sqrt.setBounds(202, 201, 45, 38);
        b1.setBounds(10, 241, 45, 38);
        b2.setBounds(58, 241, 45, 38);
        b3.setBounds(106, 241, 45, 38);
        multiple.setBounds(154, 241, 45, 38);
        equal.setBounds(202, 241, 45, 78);
        b0.setBounds(10, 281, 93, 38);
        comma.setBounds(106, 281, 45, 38);
        divide.setBounds(154, 281, 45, 38);
        Bin.setBounds(154, 121, 45, 38);
        Hex.setBounds(202, 121, 45, 38);
        stander.setBounds(10, 321, 100, 38);
        equation.setBounds(154, 321, 100, 38);

        b0.setFont(font1);
        b1.setFont(font1);
        b2.setFont(font1);
        b3.setFont(font1);
        b4.setFont(font1);
        b5.setFont(font1);
        b6.setFont(font1);
        b7.setFont(font1);
        b8.setFont(font1);
        b9.setFont(font1);
        comma.setFont(font1);
        equal.setFont(font1);
        plus.setFont(font1);
        minus.setFont(font1);
        multiple.setFont(font1);
        divide.setFont(font1);
        cos.setFont(font2);
        sin.setFont(font2);
        tan.setFont(font2);
        sqrt.setFont(font1);
        power.setFont(font1);
        modulo.setFont(font1);
        exponential.setFont(font1);
        pi.setFont(font1);
        clear.setFont(font1);
        back.setFont(font1);
        Bin.setFont(font2);
        Hex.setFont(font2);
        stander.setFont(font1);
        equation.setFont(font1);

        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setFont(new Font("Monospaced", Font.BOLD, 19));

        historyText.setFont(new Font("Arial", Font.BOLD, 16));

b0.setForeground(Color.WHITE);
        b1.setForeground(Color.WHITE);
        b2.setForeground(Color.WHITE);
        b3.setForeground(Color.WHITE);
        b4.setForeground(Color.WHITE);
        b5.setForeground(Color.WHITE);
        b6.setForeground(Color.WHITE);
        b7.setForeground(Color.WHITE);
        b8.setForeground(Color.WHITE);
        b9.setForeground(Color.WHITE);
        comma.setForeground(Color.WHITE);
        equal.setForeground(Color.WHITE);
        plus.setForeground(Color.WHITE);
        minus.setForeground(Color.WHITE);
        multiple.setForeground(Color.WHITE);
        divide.setForeground(Color.WHITE);
        cos.setForeground(Color.WHITE);
        sin.setForeground(Color.WHITE);
        tan.setForeground(Color.WHITE);
        sqrt.setForeground(Color.WHITE);
        power.setForeground(Color.WHITE);
        modulo.setForeground(Color.WHITE);
        exponential.setForeground(Color.WHITE);
        pi.setForeground(Color.WHITE);
        clear.setForeground(Color.WHITE);
        back.setForeground(Color.WHITE);
        Bin.setForeground(Color.WHITE);
        Hex.setForeground(Color.WHITE);
        stander.setForeground(Color.WHITE);
        equation.setForeground(Color.WHITE);
        
        
        b0.setBackground(buttons);
        b1.setBackground(buttons);
        b2.setBackground(buttons);
        b3.setBackground(buttons);
        b4.setBackground(buttons);
        b5.setBackground(buttons);
        b6.setBackground(buttons);
        b7.setBackground(buttons);
        b8.setBackground(buttons);
        b9.setBackground(buttons);
        comma.setBackground(buttons);
        
        plus.setBackground(sci);
        multiple.setBackground(sci);
        minus.setBackground(sci);
        divide.setBackground(sci);
        cos.setBackground(sci);
        sin.setBackground(sci);
        tan.setBackground(sci);
        sqrt.setBackground(sci);
        power.setBackground(sci);
        modulo.setBackground(sci);
        exponential.setBackground(sci);
        pi.setBackground(sci);
        clear.setBackground(sci);
        back.setBackground(sci);
        textField.setBackground(sci);
        Bin.setBackground(sci);
        Hex.setBackground(sci);
        stander.setBackground(sci);
        equation.setBackground(sci);
        equal.setBackground(eq);
        
        panel.add(b0);
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(comma);
        panel.add(equal);
        panel.add(plus);
        panel.add(multiple);
        panel.add(minus);
        panel.add(divide);
        panel.add(cos);
        panel.add(sin);
        panel.add(tan);
        panel.add(sqrt);
        panel.add(power);
        panel.add(modulo);
        panel.add(exponential);
        panel.add(pi);
        panel.add(clear);
        panel.add(back);
        panel.add(textField);
        panel.add(Bin);
        panel.add(Hex);
        panel.add(stander);
        panel.add(equation);

        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        comma.addActionListener(this);
        exponential.addActionListener(this);
        pi.addActionListener(this);
        cos.addActionListener(this);
        sin.addActionListener(this);
        tan.addActionListener(this);
        sqrt.addActionListener(this);
        power.addActionListener(this);
        modulo.addActionListener(this);
        plus.addActionListener(this);
        multiple.addActionListener(this);
        divide.addActionListener(this);
        minus.addActionListener(this);
        equal.addActionListener(this);
        clear.addActionListener(this);
        back.addActionListener(this);
        Bin.addActionListener(this);
        Hex.addActionListener(this);
        stander.addActionListener(this);
        equation.addActionListener(this);

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Scientific Calculator");
        setSize(262, 400);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b0) {
            b0_isClicked();
        } else if (e.getSource() == b1) {
            b1_isClicked();
        } else if (e.getSource() == b2) {
            b2_isClicked();
        } else if (e.getSource() == b3) {
            b3_isClicked();
        } else if (e.getSource() == b4) {
            b4_isClicked();
        } else if (e.getSource() == b5) {
            b5_isClicked();
        } else if (e.getSource() == b6) {
            b6_isClicked();
        } else if (e.getSource() == b7) {
            b7_isClicked();
        } else if (e.getSource() == b8) {
            b8_isClicked();
        } else if (e.getSource() == b9) {
            b9_isClicked();
        } else if (e.getSource() == sin) {
            sin_isClicked();
        } else if (e.getSource() == cos) {
            cos_isClicked();
        } else if (e.getSource() == tan) {
            tan_isClicked();
        } else if (e.getSource() == sqrt) {
            sqrt_isClicked();
        } else if (e.getSource() == exponential) {
            exponential_isClicked();
        } else if (e.getSource() == pi) {
            pi_isClicked();
        } else if (e.getSource() == plus) {
            plus_isClicked();
        } else if (e.getSource() == minus) {
            minus_isClicked();
        } else if (e.getSource() == multiple) {
            multiple_isClicked();
        } else if (e.getSource() == divide) {
            divide_isClicked();
        } else if (e.getSource() == modulo) {
            modulo_isClicked();
        } else if (e.getSource() == power) {
            power_isClicked();
        } else if (e.getSource() == comma) {
            comma_isClicked();
        } else if (e.getSource() == equal) {
            equal_isClicked();
        } else if (e.getSource() == back) {
            back_isClicked();
        } else if (e.getSource() == clear) {
            clear_isClicked();
        } else if (e.getSource() == Bin) {
            Bin_isClicked();
        } else if (e.getSource() == Hex) {
            Hex_isClicked();
        } else if (e.getSource() == stander) {
            dispose();
            new Stander();
        } else if (e.getSource() == equation) {
            dispose();
            new Equation();
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyChar()) {
            case '0':
            case '٠':
                b0_isClicked();
                break;

            case '1':
            case '١':
                b1_isClicked();
                break;

            case '2':
            case '٢':
                b2_isClicked();
                break;

            case '3':
            case '٣':
                b3_isClicked();
                break;

            case '4':
            case '٤':
                b4_isClicked();
                break;

            case '5':
            case '٥':
                b5_isClicked();
                break;

            case '6':
            case '٦':
                b6_isClicked();
                break;

            case '7':
            case '٧':
                b7_isClicked();
                break;

            case '8':
            case '٨':
                b8_isClicked();
                break;

            case '9':
            case '٩':
                b9_isClicked();
                break;

            case 's':
            case 'س':
                sin_isClicked();
                break;

            case 'c':
            case 'ؤ':
                cos_isClicked();
                break;

            case 't':
            case 'ف':
                tan_isClicked();
                break;

            case 'v':
            case 'ر':
                sqrt_isClicked();
                break;

            case 'e':
            case 'ث':
                exponential_isClicked();
                break;

            case 'p':
            case 'ح':
                pi_isClicked();
                break;

            case '+':
                plus_isClicked();
                break;

            case '-':
                minus_isClicked();
                break;

            case '*':
            case '×':
                multiple_isClicked();
                break;

            case '/':
            case '÷':
                divide_isClicked();
                break;

            case '%':
                modulo_isClicked();
                break;

            case '^':
                power_isClicked();
                break;

            case '.':
                comma_isClicked();
                break;

            case '=':
            case '\n':
                equal_isClicked();
                break;

        }

        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            back_isClicked();
        } else if (e.getKeyCode() == KeyEvent.VK_DELETE) {
            clear_isClicked();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public Scientific() {
        createAndShowGUI();
    }

   

    private void Bin_isClicked() {
        int bin = Integer.parseInt(textField.getText());
        textField.setText(Integer.toString(bin, 2));
    }

    private void Hex_isClicked() {
        int hex = Integer.parseInt(textField.getText());
        textField.setText(Integer.toString(hex, 16));
    }

}
