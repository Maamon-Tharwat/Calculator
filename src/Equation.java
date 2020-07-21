
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class Equation extends JFrame implements ActionListener {
    
    
    Font designFont=new Font("Major Mono Display", Font.BOLD, 12);
    Color desginColor=new Color(28, 28, 28);

    //declar the arrays and varibles to be used in program
    double matrix[][];      // matrix that will hold the coefficient for variables in the equations
    double solution[];      // array that will hold the value of each variable after the solution
    int EQ;                 //the number of equations
    int var;                // the number of variables

    //declar component
    JButton submit;
    JButton resystem;
    JButton stander;
    JButton scientific;
    JTextField coffiecient[][];
    JLabel variables[][];
    JPanel mpane = new JPanel(null);

    // constructor
    public Equation() {
        intialFrame();
    }

    //get the number of equation and variable and set textbox and label to accept the coefficient int the equations
    public void intialFrame() { 
        //get the number of variables and equations
        EQ = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of equations"));
        var = 1 + Integer.parseInt(JOptionPane.showInputDialog("Enter the number of variables"));
        if (EQ != var - 1) {
            JOptionPane.showMessageDialog(null, "Number of equation must equal number of variables", "Error", ERROR_MESSAGE);
            intialFrame();
        }

        //create panel and lay out for out size and locate
        GridLayout grid = new GridLayout(0, 2 * var, 20, 20);
        JPanel pane = new JPanel(grid);

        //create arrays
        matrix = new double[EQ][var];
        solution = new double[var - 1];
        coffiecient = new JTextField[EQ][var];
        variables = new JLabel[EQ][var];

        //add the textfields for coffiecient and labels for variables
        for (int x = 0; x < EQ; ++x) {
            for (int y = 0; y < var; ++y) {
                //left hand side in equation
                if (y != var - 1) {
                    //create object and and to panel
                    coffiecient[x][y] = new JTextField();
                    coffiecient[x][y].setFont(designFont);
                    coffiecient[x][y].setForeground(Color.WHITE);
                    coffiecient[x][y].setBackground(new Color(45, 45, 45));
                    pane.add(coffiecient[x][y]);

                    variables[x][y] = new JLabel("X" + (y + 1));
                    variables[x][y].setFont(designFont);
                    variables[x][y].setForeground(Color.WHITE);
                    pane.add(variables[x][y]);
                } else {
                    //right hand side of equation
                    variables[x][y] = new JLabel(" = ");
                    variables[x][y].setFont(designFont);
                    variables[x][y].setForeground(Color.WHITE);
                    pane.add(variables[x][y]);

                    coffiecient[x][y] = new JTextField();
                    coffiecient[x][y].setFont(designFont);
                    coffiecient[x][y].setForeground(Color.WHITE);
                    coffiecient[x][y].setBackground(new Color(45, 45, 45));
                    pane.add(coffiecient[x][y]);

                }
            }
        }

        //create buttons for solve and resystem and move for stander and Scientific
        //and setting action listener
        submit = new JButton("Sovle");
        submit.setFont(designFont);
        submit.setBackground(new Color(173, 91, 3));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);

        resystem = new JButton("New System");
        resystem.setFont(designFont);
        resystem.setBackground(new Color(173, 91, 3));
        resystem.setForeground(Color.WHITE);
        resystem.addActionListener(this);

        stander = new JButton("Stander");
        stander.setFont(designFont);
        stander.setBackground(new Color(173, 91, 3));
        stander.setForeground(Color.WHITE);
        stander.addActionListener(this);

        scientific = new JButton("Scientific");
        scientific.setFont(designFont);
        scientific.setBackground(new Color(173, 91, 3));
        scientific.setForeground(Color.WHITE);
        scientific.addActionListener(this);

        //add buttons to panel
        pane.add(submit);
        pane.add(resystem);
        pane.add(stander);
        pane.add(scientific);
        pane.setBackground(desginColor);
        pane.setForeground(Color.WHITE);
        
        //add scroll bars to appear when needed
        JScrollPane bar = new JScrollPane(pane);
        bar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        bar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        bar.setBounds(0, 0, 1024, 700);
        
        mpane.setBackground(desginColor);
        mpane.setPreferredSize(new Dimension(1024, 700));
        mpane.add(bar);
        
        //set frame properties
        setContentPane(mpane);
        pack();
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Equation");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //get coffiecient from textfields and set intial solution  for variables 0
    public void setUpMatrix() {
        for (int x = 0; x < EQ; ++x) {
            for (int y = 0; y < var; ++y) {
                matrix[x][y] = Double.parseDouble(coffiecient[x][y].getText());
            }
        }
        for (int x = 0; x < var - 1; ++x) {
            solution[x] = 0;
        }
    }

    //check for duplicated equation
    public boolean checkMatrix() {
        boolean flag = false;
        for (int x = 0; x < EQ && !flag; ++x) {
            for (int y = x + 1; y < EQ && !flag; ++y) {
                flag = true;
                for (int z = 0; z < var - 1; ++z) {
                    if ((matrix[x][z] / matrix[y][z]) != (matrix[x][z + 1] / matrix[y][z + 1])) {
                        flag = false;
                        break;
                    }
                }

            }
        }
        return flag;
    }

    //solve the system
    public void solve() {
        //move any zero from main diagonal
        for (int y = 0; y < EQ; ++y) {
            if (matrix[y][y] == 0) {
                double[] tempArray = matrix[y];
                int x;
                for (x = y+1; x < matrix.length; ++x) {
                    if (matrix[x][y] != 0) {
                        break;
                    }
                }
                matrix[y] = matrix[x];
                matrix[x] = tempArray;
            }
        }
        //get the first element to 1
        double temp = matrix[0][0];
        for (int x = 0; x < var; ++x) {
            matrix[0][x] = matrix[0][x] / temp;
        }

        //get the lower triangle to be zeros
        for (int x = 0; x < var - 1; ++x) {
            for (int y = x + 1; y < EQ; ++y) {
                temp = -1 * matrix[y][x] / matrix[x][x];
                for (int z = 0; z < var; ++z) {
                    matrix[y][z] = (temp * matrix[x][z]) + matrix[y][z];
                }
            }
        }

        //get the main diagonal to 1
        for (int x = 1; x < EQ; ++x) {
            temp = matrix[x][x];
            for (int y = 0; y < var; ++y) {
                matrix[x][y] = matrix[x][y] / temp;
            }
        }

        
        //claculate the variables
        double sum;
        for (int x = EQ - 1; x > -1; --x) {
            sum = 0;
            for (int y = 0; y < var - 1; ++y) {
                sum += matrix[x][y] * solution[y];
            }
            solution[x] = matrix[x][var - 1] - sum;
        }

    }

    //print the final solution for variables
    public void showSolution() {
        for (int y = 0; y < var; ++y) {
            String ti = "X" + (y + 1);
            String mes = "X" + (y + 1) + " = " + solution[y];
            JOptionPane.showMessageDialog(null, mes, ti, INFORMATION_MESSAGE);
        }
    }

    //resystem event that remove panel component 
    public void newEquation() {
        mpane.removeAll();
        intialFrame();
    }

    //the actions event from the abstract class action listener
    @Override
    public void actionPerformed(ActionEvent e) {
        //get source return the reference of the object that was clicked
        if (e.getSource() == submit) {
            setUpMatrix();
            if (!checkMatrix()) {
                solve();
                showSolution();
            } else {
                JOptionPane.showMessageDialog(null, "There's a duplicated equation", "Error", ERROR_MESSAGE);
                newEquation();
            }
        } else if (e.getSource() == resystem) {
            newEquation();
        } else if (e.getSource() == stander) {
            //close current frame from dispose 
            dispose();
            new Stander();
        } else if (e.getSource() == scientific) {
            dispose();
            new Scientific();
        }
    }

}
