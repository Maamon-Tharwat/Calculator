
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextArea;

public class Stander extends JFrame implements ActionListener {

    Color background = new Color(27, 27, 27);
    Color buttons = new Color(42, 42, 42);
    Color sci = new Color(82, 82, 82);
    Color eq = new Color(178, 89, 4);

    Font font1 = new Font("Arial", Font.BOLD, 13);

    JButton eql, ad, sub, mult, stop, div, clear, scientific, equation;
    JTextArea t;
    JPanel panel;
    int i = 0, addc = 0, subc = 0, multc = 0, divc = 0;
    double num1, num2, result;
    JButton[] arr = new JButton[10];

    Stander() {
        panel = new JPanel(null);
        panel.setBounds(0, 0, 256, 319);
        panel.setBackground(background);

        for (int x = 0; x < 10; ++x) {
            arr[x] = new JButton("" + x);
            arr[x].addActionListener(this);
        }

        ad = new JButton("+");
        sub = new JButton("-");
        mult = new JButton("×");
        div = new JButton("÷");
        scientific = new JButton("Scientific");
        equation = new JButton("Equation");
        eql = new JButton("=");
        clear = new JButton("C");
        t = new JTextArea("");

        panel.setBounds(0, 0, 256, 319);
        panel.setBackground(background);

        t.setBounds(11, 11, 234, 60);
        t.setBackground(sci);

        clear.setBounds(202, 80, 45, 38);
        arr[7].setBounds(10, 80, 45, 38);
        arr[8].setBounds(58, 80, 45, 38);
        arr[9].setBounds(106, 80, 45, 38);
        ad.setBounds(154, 80, 45, 38);
        arr[4].setBounds(10, 120, 45, 38);
        arr[5].setBounds(58, 120, 45, 38);
        arr[6].setBounds(106, 120, 45, 38);
        sub.setBounds(154, 120, 45, 38);
        arr[1].setBounds(10, 160, 45, 38);
        arr[2].setBounds(58, 160, 45, 38);
        arr[3].setBounds(106, 160, 45, 38);
        mult.setBounds(154, 160, 45, 38);
        eql.setBounds(202, 120, 45, 118);
        arr[0].setBounds(10, 200, 141, 38);
        div.setBounds(154, 200, 45, 38);
        scientific.setBounds(10, 240, 100, 38);
        equation.setBounds(154, 240, 100, 38);

        arr[0].setFont(font1);
        arr[1].setFont(font1);
        arr[2].setFont(font1);
        arr[3].setFont(font1);
        arr[4].setFont(font1);
        arr[5].setFont(font1);
        arr[6].setFont(font1);
        arr[7].setFont(font1);
        arr[8].setFont(font1);
        arr[9].setFont(font1);
        eql.setFont(font1);
        ad.setFont(font1);
        sub.setFont(font1);
        mult.setFont(font1);
        div.setFont(font1);
        clear.setFont(font1);
        scientific.setFont(font1);
        equation.setFont(font1);

        t.setFont(new Font("Monospaced", Font.BOLD, 19));

        arr[0].setForeground(Color.WHITE);
        arr[1].setForeground(Color.WHITE);
        arr[2].setForeground(Color.WHITE);
        arr[3].setForeground(Color.WHITE);
        arr[4].setForeground(Color.WHITE);
        arr[5].setForeground(Color.WHITE);
        arr[6].setForeground(Color.WHITE);
        arr[7].setForeground(Color.WHITE);
        arr[8].setForeground(Color.WHITE);
        arr[9].setForeground(Color.WHITE);
        eql.setForeground(Color.WHITE);
        ad.setForeground(Color.WHITE);
        sub.setForeground(Color.WHITE);
        mult.setForeground(Color.WHITE);
        div.setForeground(Color.WHITE);
        clear.setForeground(Color.WHITE);
        scientific.setForeground(Color.WHITE);
        equation.setForeground(Color.WHITE);

        arr[0].setBackground(buttons);
        arr[1].setBackground(buttons);
        arr[2].setBackground(buttons);
        arr[3].setBackground(buttons);
        arr[4].setBackground(buttons);
        arr[5].setBackground(buttons);
        arr[6].setBackground(buttons);
        arr[7].setBackground(buttons);
        arr[8].setBackground(buttons);
        arr[9].setBackground(buttons);
        ad.setBackground(sci);
        mult.setBackground(sci);
        sub.setBackground(sci);
        div.setBackground(sci);
        clear.setBackground(sci);
        t.setBackground(sci);
        scientific.setBackground(sci);
        equation.setBackground(sci);
        eql.setBackground(eq);

        panel.add(arr[0]);
        panel.add(arr[1]);
        panel.add(arr[2]);
        panel.add(arr[3]);
        panel.add(arr[4]);
        panel.add(arr[5]);
        panel.add(arr[6]);
        panel.add(arr[7]);
        panel.add(arr[8]);
        panel.add(arr[9]);
        panel.add(eql);
        panel.add(ad);
        panel.add(mult);
        panel.add(sub);
        panel.add(div);
        panel.add(clear);
        panel.add(t);
        panel.add(scientific);
        panel.add(equation);

        ad.addActionListener(this);
        mult.addActionListener(this);
        div.addActionListener(this);
        sub.addActionListener(this);
        eql.addActionListener(this);
        clear.addActionListener(this);
        scientific.addActionListener(this);
        equation.addActionListener(this);

        add(panel);

        setTitle("Scientific Calculator");
        setSize(262, 319);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //  throw new UnsupportedOperationException("Not supported yet."); //To change arr[ody of generated methods, choose Tools | Templates.
        for (i = 0; i < arr.length; i++) {
            if (e.getSource() == arr[i]) {
                t.setText(t.getText() + arr[i].getText());

            }
        }
        if (e.getSource() == ad) {
            num1 = getNumber();
            t.setText("");
            addc = 1;
            subc = 0;
            multc = 0;
            divc = 0;
        }

        if (e.getSource() == sub) {
            num1 = getNumber();
            t.setText("");
            addc = 0;
            subc = 1;
            multc = 0;
            divc = 0;
        }

        if (e.getSource() == mult) {
            num1 = getNumber();
            t.setText("");
            addc = 0;
            subc = 0;
            multc = 1;
            divc = 0;
        }
        if (e.getSource() == div) {
            num1 = getNumber();
            t.setText("");
            addc = 0;
            subc = 0;
            multc = 0;
            divc = 1;
        }
        if (e.getSource() == clear) {
            t.setText(" ");
        }
        if (e.getSource() == stop) {
            t.setText(t.getText() + stop.getText());
        }
        if (e.getSource() == eql) {
            num2 = getNumber();
            if (addc == 1) {
                result = num1 + num2;
                t.setText("" + result);
            }

            if (subc == 1) {
                result = num1 - num2;
                t.setText("" + result);
            }

            if (multc == 1) {
                result = num1 * num2;
                t.setText("" + result);
            }

            if (divc == 1) {
                result = num1 / num2;
                t.setText("" + result);
            }

        } else if (e.getSource() == scientific) {
            dispose();
            new Scientific();
        } else if (e.getSource() == equation) {
            dispose();
            new Equation();
        }
    }

    public double getNumber() {
        double number;
        String s;
        s = t.getText();
        number = Double.parseDouble(s);

        return number;
    }

}
