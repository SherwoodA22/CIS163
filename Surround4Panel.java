package Project2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Surround4Panel extends JPanel {

    private JButton[][] board;
    private JPanel panel1;
    private int player;
    private ButtonListener listen;
    private JMenuItem quitItem, newGameItem;
    private Surround4Game game;

    public Surround4Panel(JMenuItem pQuitItem, JMenuItem pNewGame) {

        quitItem = pQuitItem;
        listen = new ButtonListener();
        newGameItem = pNewGame;

        setLayout(new BorderLayout());
        panel1 = new JPanel();

        createBoard();
        add(panel1, BorderLayout.CENTER);
        game = new Surround4Game();
        quitItem.addActionListener(listen);
        newGameItem.addActionListener(listen);

    }

    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == quitItem)
                System.exit(1);

            for (int row = 0; row < board.length; row++)
                for (int col = 0; col < board.length; col++)
                    if (board[row][col] == e.getSource())
                        if (game.select(row, col)) {
                           //board[row][col].setText(""+c.getPlayeNumber());
                            player = game.nextPlayer();
                        } else
                            JOptionPane.showMessageDialog(null, "Not a valid square! Pick again.");

            displayBoard();
            int winner = game.getWinner();
            if (winner != -1) {
                JOptionPane.showMessageDialog(null, "Player " + winner + " Wins!");
                game = new Surround4Game();
                displayBoard();

            }
        }
    }

    private void createBoard() {
        int boardSize = 0;
        board = new JButton[10][10];
        panel1.setLayout(new GridLayout(10, 10));
        String strBdSize = JOptionPane.showInputDialog (null, "Enter in the size of the board: ");
        if(Integer.parseInt(strBdSize)<=20 && Integer.parseInt(strBdSize)>=3 ) {
            boardSize = Integer.parseInt(strBdSize);
            board = new JButton[boardSize][boardSize];
            panel1.setLayout(new GridLayout(boardSize, boardSize));

            for (int i = 0; i < boardSize; i++) // rows
                for (int j = 0; j < boardSize; j++) {
                    board[i][j] = new JButton("");
                    board[i][j].addActionListener(listen);
                    panel1.add(board[i][j]);
                }
        }
        else
        for (int i = 0; i < 10; i++) // rows
            for (int j = 0; j < 10; j++) {
                board[i][j] = new JButton("");
                board[i][j].addActionListener(listen);
                panel1.add(board[i][j]);
            }
    }

    private void displayBoard() {

        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board.length; col++) {
                Cell c = game.getCell(row, col);
                if (c != null)
                    board[row][col].setText("" + c.getPlayeNumber());
                else
                    board[row][col].setText("");
            }
    }
}

