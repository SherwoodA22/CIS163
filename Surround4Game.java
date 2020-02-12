package Project2;

public class Surround4Game {
    private Cell[][] board;
    private int player;

    public Surround4Game() {
        //super();
        board = new Cell[10][10];
        this.player = 1;
    }

    public void reset() {
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                board[r][c] = null;
            }
        }
    }

    public Cell getCell(int row, int col) {
        return board[row][col];
    }

    public int getCurrentPlayer() {
        return player;
    }

    public int nextPlayer() {
        	//player = player + 1;
        	//if (player == 2)
        	//	player = 0;

        player = (player + 1) % 2;
        return player;
    }

    public boolean select(int row, int col) {
        if (board[row][col] == null) {  //|| (cats() && board[row][col].getCurrentPlayer() != player)) {
            Cell c = new Cell(player);
            board[row][col] = c;
            return true;
        } else
            return false;
    }

    public int getWinner() {

        // top-left corner case (check 2 sides only)
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board.length; col++)
        if (row == 0 && col == 0)
            if (board[0][1] != null && board[1][0] != null)
                if (board[0][1].getPlayeNumber() == board[1][0].getPlayeNumber())
                    return player;

        // left-border case (excluding corners - check 3 sides only)
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board.length; col++)
        if (row != 0 && row != board.length-1 && col == 0)
            if (board[row-1][col] != null && board[row][col+1] != null && board[row+1][col] != null)
                if (board[row-1][col].getPlayeNumber() == board[row][col+1].getPlayeNumber() &&
                        board[row-1][col].getPlayeNumber() == board[row+1][col].getPlayeNumber())
                         return player;

        // bottom-left corner case (check 2 sides only)
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board.length; col++)
                if (row == board.length-1 && col == 0)
                    if (board[board.length-1][1] != null && board[board.length-2][0] != null)
                        if (board[board.length-1][1].getPlayeNumber() == board[board.length-2][0].getPlayeNumber())
                            return player;

        // bottom-right corner case (check 2 sides only)
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board.length; col++)
                if (row == board.length-1 && col == board.length-1)
                    if (board[board.length-1][board.length-2] != null && board[board.length-2][board.length-1] != null)
                        if (board[board.length-1][board.length-2].getPlayeNumber() == board[board.length-2][board.length-1].getPlayeNumber())
                            return player;

        // top-right corner case (check 2 sides only)
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board.length; col++)
                if (row == 0 && col == board.length-1)
                    if (board[0][board.length-2] != null && board[1][board.length-1] != null)
                        if (board[0][board.length-2].getPlayeNumber() == board[1][board.length-1].getPlayeNumber())
                            return player;

        // right-border case (excluding corners - check 3 sides only)
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board.length; col++)
                if (row != 0 && row != board.length-1 && col == board.length-1)
                    if (board[row-1][board.length-1] != null && board[row][board.length-2] != null && board[row+1][board.length-1] != null)
                        if (board[row-1][board.length-1].getPlayeNumber() == board[row][board.length-2].getPlayeNumber() &&
                                board[row-1][board.length-1].getPlayeNumber() == board[row+1][board.length-1].getPlayeNumber())
                                return player;

        // bottom-border case (excluding corners - check 3 sides only)
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board.length; col++)
                if (row == board.length-1  && col != 0 && col != board.length-1)
                    if (board[board.length-1][col-1] != null && board[board.length-2][col] != null && board[board.length-1][col+1] != null)
                        if (board[board.length-1][col-1].getPlayeNumber() == board[board.length-2][col].getPlayeNumber() &&
                                board[board.length-1][col-1].getPlayeNumber() == board[board.length-1][col+1].getPlayeNumber())
                            return player;

        // top-border case (excluding corners - check 3 sides only)
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board.length; col++)
                if (row == 0  && col != 0 && col != board.length-1)
                    if (board[row][col-1] != null && board[1][col] != null && board[0][col+1] != null)
                        if (board[0][col-1].getPlayeNumber() == board[1][col].getPlayeNumber() &&
                                board[0][col-1].getPlayeNumber() == board[0][col+1].getPlayeNumber())
                            return player;

        // non-border case
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board.length; col++)
                if (row != 0  && row != board.length-1 && col != 0 && col != board.length-1)
                    if (board[row][col-1] != null && board[row][col+1] != null &&
                            board[row-1][col] != null && board[row+1][col] != null)
                        if (board[row][col-1].getPlayeNumber() == board[row-1][col].getPlayeNumber() &&
                                board[row][col+1].getPlayeNumber() == board[row+1][col].getPlayeNumber()
                             && board[row][col+1].getPlayeNumber() == board[row-1][col].getPlayeNumber())
                            return player;


        return -1;
    }

}





