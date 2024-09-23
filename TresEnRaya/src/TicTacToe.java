import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame implements ActionListener {
    private JButton[] buttons;
    private JLabel playerLabel;
    private boolean playerXTurn = true;

    public TicTacToe() {
        super("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(new BorderLayout());

        // Create the grid of buttons
        buttons = new JButton[9];
        JPanel gridPanel = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.BOLD, 30));
            buttons[i].addActionListener(this);
            gridPanel.add(buttons[i]);
        }
        add(gridPanel, BorderLayout.CENTER);

        // Create the player label
        playerLabel = new JLabel("Player X's turn");
        playerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(playerLabel, BorderLayout.NORTH);

        // Create the reset button
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        add(resetButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i] && buttons[i].getText().isEmpty()) {
                if (playerXTurn) {
                    buttons[i].setText("X");
                    playerLabel.setText("Player O's turn");
                } else {
                    buttons[i].setText("O");
                    playerLabel.setText("Player X's turn");
                }
                playerXTurn = !playerXTurn;
                checkWin();
            }
        }
        if (e.getSource() == buttons[9]) {
            resetGame();
        }
    }

    private void checkWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (buttons[i * 3].getText().equals(buttons[i * 3 + 1].getText()) &&
                buttons[i * 3].getText().equals(buttons[i * 3 + 2].getText()) &&
                !buttons[i * 3].getText().isEmpty()) {
                showWinner(buttons[i * 3].getText());
                return;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (buttons[i].getText().equals(buttons[i + 3].getText()) &&
                buttons[i].getText().equals(buttons[i + 6].getText()) &&
                !buttons[i].getText().isEmpty()) {
                showWinner(buttons[i].getText());
                return;
            }
        }

        // Check diagonals
        if ((buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText()) && !buttons[0].getText().isEmpty()) ||
            (buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText()) && !buttons[2].getText().isEmpty())) {
            showWinner(buttons[4].getText());
            return;
        }

        // Check for a draw
        if (isBoardFull()) {
            showWinner("Draw");
        }
    }

    private boolean isBoardFull() {
        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private void showWinner(String winner) {
        JOptionPane.showMessageDialog(this, "Player " + winner + " wins!");
        resetGame();
    }

    private void resetGame() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setText("");
        }
        playerXTurn = true;
        playerLabel.setText("Player X's turn");
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}