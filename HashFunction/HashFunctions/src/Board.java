import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * JavaDocs written by Patrick Riley
 * 
 * @author Terri Kelly
 * 
 *
 */
abstract class Board extends JFrame implements ActionListener {

	private JButton buttons[][];
	private JLabel lblHashCode;
	private JLabel lblWinTitle;

	private String boardString = "";

	/**
	 * Creates a new board with a given title
	 * 
	 * @param title
	 *            the title for the JFrame
	 */
	public Board(String title) {
		super(title);
		setupFrame();
	}

	/**
	 * Sets the hash code label on the frame
	 * 
	 * @param hashcode
	 *            the hashcode to be displayed
	 */
	public void setHashCodeLabel(int hashcode) {
		lblHashCode.setText("" + hashcode);
	}

	/**
	 * Sets the winner label on the frame
	 * 
	 * @param result
	 *            the result of the board
	 */
	public void setWinnerLabel(String result) {
		lblWinTitle.setText(result);
	}

	/**
	 * Sets the winner label on the frame, but with a boolean
	 * 
	 * @param result
	 *            the result of the board
	 */
	public void setWinnerLabel(boolean result) {
		if (result)
			setWinnerLabel("Winner");
		else
			setWinnerLabel("Loser");
	}

	// required because of abstract method, but not used
	@Override
	public void actionPerformed(ActionEvent e) {
	}

	/**
	 * Sets up the first JPanel, adds buttons to it
	 * 
	 * @return new JPanel
	 */
	JPanel setupPanelOne() {
		JPanel panel = new JPanel();
		JLabel lblHCTitle = new JLabel("Hash Code");
		;
		lblHashCode = new JLabel("" + myHashCode());
		lblWinTitle = new JLabel(""); // Will say either Winner or Loser
		setWinnerLabel(TicTacToe.isWin(boardString));
		panel.setLayout(new FlowLayout());
		panel.add(lblHCTitle);
		panel.add(lblHashCode);
		panel.add(lblWinTitle);
		return panel;
	}

	/**
	 * Sets up the second JPanel, the TTT grid
	 * 
	 * @return the new JPanel
	 */
	private JPanel setupPanelTwo() {
		JButton b;
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(TicTacToe.ROWS, TicTacToe.COLS));
		buttons = new JButton[TicTacToe.ROWS][TicTacToe.COLS];

		int count = 1;

		for (int r = 0; r < TicTacToe.ROWS; r++)
			for (int c = 0; c < TicTacToe.COLS; c++) {
				char ch = randomXO();
				b = new JButton("" + ch);
				boardString += ch;
				b.setActionCommand("" + r + ", " + c);
				b.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton btn = (JButton) e.getSource();
						btn.setText("" + cycleValue(btn.getText().charAt(0)));
						resetBoardString();
						setHashCodeLabel(myHashCode());
						setWinnerLabel(isWin());

					}
				});
				panel.add(b);
				buttons[r][c] = b;
			}

		return panel;
	}

	/**
	 * Changes the value of the board square
	 * 
	 * @param ch
	 *            the cell value to be cycled
	 * @return the new char for the button
	 */
	private static char cycleValue(char ch) {
		switch (ch) {
		case 'x':
			return 'o';
		case 'o':
			return ' ';
		default:
			return 'x';
		}
	}

	/**
	 * Sets up the JFrame for the TTT window, and adds panel 1 and 2 to the board
	 */
	private void setupFrame() {
		JPanel panel2 = new JPanel();

		// Setup Frame
		super.setSize(250, 200);
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

		// Setup Panels
		panel2 = setupPanelTwo(); // panelOne displays a value that requires panelTwo to be ready
		super.add(setupPanelOne());
		super.add(panel2);

		super.setVisible(true);
	}

	/**
	 * generates a random x o or space
	 * 
	 * @return a random square value
	 */
	private char randomXO() {
		int rnd = (int) (Math.random() * TicTacToe.CHAR_POSSIBILITIES);
		switch (rnd) {
		case 1:
			return 'x';
		case 2:
			return 'o';
		default:
			return ' ';
		}
	}

	/**
	 * creates a hash code for the current board String
	 * 
	 * @return the hash code value of the board string
	 */
	abstract int myHashCode();

	/**
	 * Determines if the board is a winning board or not
	 * 
	 * @param s
	 *            the string representation of the board
	 * @return if the board is a winner or not
	 */
	abstract boolean isWin(String s);

	/**
	 * Determines if the board is a winning board or not
	 * 
	 * @return if the board is a winner or not
	 */
	abstract boolean isWin();

	/**
	 * gets the value of the button at the specified row and column
	 * 
	 * @param row
	 *            the row of the button
	 * @param col
	 *            the column of the button
	 * @return the value of the button at (r,c)
	 */
	public char charAt(int row, int col) {
		String value = buttons[row][col].getText();
		if (value.length() > 0)
			return value.charAt(0);
		else
			return '*';
	}

	/**
	 * Gets the value of a cell of a board from a string representation of it
	 * @param s the board string
	 * @param row the row of the desired cell
	 * @param col the column of the desired cell
	 * @return the char at (r,c)
	 */
	public char charAt(String s, int row, int col) {
		int pos = row * TicTacToe.COLS + col;
		if (s.length() >= pos)
			return s.charAt(pos);
		else
			return '*';
	}
	
	/**
	 * Updates the buttons on the board to reflect a new value
	 * @param s the string value of the new board
	 */
	public void show(String s) {
		int pos = 0;
		String letter;
		for (int r = 0; r < TicTacToe.ROWS; r++)
			for (int c = 0; c < TicTacToe.COLS; c++) {
				char ch = s.charAt(pos);
				switch (ch) {
				case '1':
					letter = "x";
					break;
				case '2':
					letter = "o";
					break;
				case '0':
					letter = " ";
					break;
				default:
					letter = "" + ch;
				}
				buttons[r][c].setText(letter);
				pos++;
			}
	}
	
	/**
	 * resets the board to the current boardString
	 */
	public void resetBoardString() {
		boardString = "";
		for (int r = 0; r < TicTacToe.ROWS; r++)
			for (int c = 0; c < TicTacToe.COLS; c++) {
				boardString += buttons[r][c].getText();
			}
	}
	
	/**
	 * Sets the board based on a string
	 * @param s the new board represented as a string
	 */
	public void setBoardString(String s) {
		boardString = s;
		show(s);
	}
	
	/**
	 * Gets the board string
	 * @return the boardString
	 */
	public String getBoardString() {
		return boardString;
	}
	
	/**
	 * Displays a random String on the board and updates the win and hash code areas of the panel
	 */
	public void displayRandomString() {
		for (int r = 0; r < TicTacToe.ROWS; r++)
			for (int c = 0; c < TicTacToe.COLS; c++) {
				char ch = randomXO();
				boardString += ch;
				buttons[r][c].setText("" + ch);
			}
		setHashCodeLabel(myHashCode());
		setWinnerLabel(isWin());
	}

}