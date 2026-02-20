import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.text.DecimalFormat;

class Calculator extends JFrame {

    private JTextField firstNumberField, secondNumberField;
    private JLabel statusLabel, operatorLabel, equalLabel, answerLabel;
    private JButton clearButton, addButton, subtractButton, multiplyButton, divideButton;

    private final DecimalFormat formatter = new DecimalFormat("#,###.########"); // فرمت عدد

    public Calculator() {
        setTitle("Calculator");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(230, 230, 230));

        initComponents();
        addComponents();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initComponents() {
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Font fieldFont = new Font("Arial", Font.PLAIN, 16);
        Font buttonFont = new Font("Arial", Font.BOLD, 16);

        statusLabel = new JLabel("Calculator is ready!", JLabel.CENTER);
        statusLabel.setPreferredSize(new Dimension(320, 30));
        statusLabel.setBorder(new LineBorder(Color.BLACK));
        statusLabel.setForeground(Color.BLACK);
        statusLabel.setFont(labelFont);
        statusLabel.setOpaque(true);
        statusLabel.setBackground(Color.WHITE);

        firstNumberField = new JTextField();
        firstNumberField.setFont(fieldFont);
        firstNumberField.setHorizontalAlignment(JTextField.CENTER);
        firstNumberField.setPreferredSize(new Dimension(100, 40));

        operatorLabel = new JLabel("", JLabel.CENTER);
        operatorLabel.setFont(labelFont);
        operatorLabel.setPreferredSize(new Dimension(40, 40));

        secondNumberField = new JTextField();
        secondNumberField.setFont(fieldFont);
        secondNumberField.setHorizontalAlignment(JTextField.CENTER);
        secondNumberField.setPreferredSize(new Dimension(100, 40));

        equalLabel = new JLabel("", JLabel.CENTER);
        equalLabel.setFont(labelFont);
        equalLabel.setPreferredSize(new Dimension(40, 40));

        answerLabel = new JLabel("", JLabel.CENTER);
        answerLabel.setFont(labelFont);
        answerLabel.setForeground(Color.BLACK);
        answerLabel.setPreferredSize(new Dimension(100, 40));

        clearButton = createButton("C", buttonFont, new Color(200, 200, 200), Color.BLACK);
        addButton = createButton("+", buttonFont, new Color(180, 180, 180), Color.BLACK);
        subtractButton = createButton("-", buttonFont, new Color(180, 180, 180), Color.BLACK);
        multiplyButton = createButton("*", buttonFont, new Color(180, 180, 180), Color.BLACK);
        divideButton = createButton("/", buttonFont, new Color(180, 180, 180), Color.BLACK);

        clearButton.addActionListener(e -> clearCalculator());
        addButton.addActionListener(e -> performOperation("+"));
        subtractButton.addActionListener(e -> performOperation("-"));
        multiplyButton.addActionListener(e -> performOperation("*"));
        divideButton.addActionListener(e -> performOperation("/"));
    }

    private JButton createButton(String text, Font font, Color bg, Color fg) {
        JButton btn = new JButton(text);
        btn.setFont(font);
        btn.setBackground(bg);
        btn.setForeground(fg);
        btn.setFocusPainted(false);
        btn.setBorder(new LineBorder(Color.DARK_GRAY));
        btn.setPreferredSize(new Dimension(60, 50));
        return btn;
    }

    private void addComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(230, 230, 230));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(statusLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(new Color(230, 230, 230));
        inputPanel.add(firstNumberField);
        inputPanel.add(operatorLabel);
        inputPanel.add(secondNumberField);
        mainPanel.add(inputPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel resultPanel = new JPanel();
        resultPanel.setBackground(new Color(230, 230, 230));
        resultPanel.add(equalLabel);
        resultPanel.add(answerLabel);
        mainPanel.add(resultPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(230, 230, 230));
        buttonPanel.add(clearButton);
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);

        mainPanel.add(buttonPanel);

        add(mainPanel);
    }

    private void clearCalculator() {
        statusLabel.setText("Calculator is ready!");
        statusLabel.setForeground(Color.BLACK);

        firstNumberField.setText("");
        secondNumberField.setText("");
        operatorLabel.setText("");
        answerLabel.setText("");
        equalLabel.setText("");
    }

    private void performOperation(String op) {
        String num1Text = firstNumberField.getText().trim();
        String num2Text = secondNumberField.getText().trim();

        if (num1Text.isEmpty() || num2Text.isEmpty()) {
            showError("Both fields are required!");
            return;
        }

        double n1, n2;
        try {
            n1 = Double.parseDouble(num1Text.replace(",", ""));
            n2 = Double.parseDouble(num2Text.replace(",", ""));
        } catch (NumberFormatException e) {
            showError("Invalid number!");
            return;
        }

        operatorLabel.setText(op);
        equalLabel.setText("=");

        double result;
        switch (op) {
            case "+" -> result = n1 + n2;
            case "-" -> result = n1 - n2;
            case "*" -> result = n1 * n2;
            case "/" -> {
                if (n2 == 0) {
                    showError("Cannot divide by zero!");
                    answerLabel.setText("");
                    return;
                } else {
                    result = n1 / n2;
                }
            }
            default -> {
                showError("Unknown operation!");
                return;
            }
        }

        // نمایش اعداد با جداکننده هزارگان
        firstNumberField.setText(formatter.format(n1));
        secondNumberField.setText(formatter.format(n2));
        answerLabel.setText(formatter.format(result));
    }

    private void showError(String message) {
        statusLabel.setText(message);
        statusLabel.setForeground(Color.RED);
    }

    public static void main(String[] args) {
        new Calculator();
    }
}