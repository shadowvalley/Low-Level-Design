import models.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    Deque<Player> players = new LinkedList<>();
    Board playingBoard;

    // Initialise Game
    public void initialiseGame() {
        // Create players
        PlayingPieceX crossPiece = new PlayingPieceX();
        PlayingPieceO zeroPiece = new PlayingPieceO();
        Player player1 = new Player("Satyam", crossPiece);
        Player player2 = new Player("Shubham", zeroPiece);
        players.add(player1);
        players.add(player2);

        // Create board
        playingBoard = new Board(3);
    }

    public String startGame() {
        boolean noWinner = true;
        while(noWinner) {
            //take out the player whose turn is and also put the player in the list back
            Player playerTurn = players.removeFirst();

            // Print the board
            playingBoard.printBoard();

            // Find free cells where player can place his piece
            List<Pair<Integer, Integer>> freeCells = playingBoard.getAllFreeCells();

            // if no free cells
            if(freeCells.isEmpty()) {
                noWinner = false;
                continue;
            }

            // Get user choice
            System.out.print("Player:" + playerTurn.name + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            // User can place his piece anywhere in the free cells
            boolean isPiecePlacedSuccessfully = playingBoard.addPieceToBoard(inputRow, inputColumn,
                    playerTurn.getPlayingPiece());

            if(isPiecePlacedSuccessfully) {
                //player can not insert the piece into this cell, player has to choose another cell
                System.out.println("Incorrect position chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }
            // if placed successfully
            players.addLast(playerTurn);

            // Check for winner
            boolean winner = isThereAWinner(inputRow, inputColumn, playerTurn.playingPiece.pieceType);
            if(winner) {
                return playerTurn.name;
            }
        }
        return "Tie!!";
    }

    private boolean isThereAWinner(int row, int col, PieceType pieceType) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        // Check row
        for(int i=0;i<playingBoard.size;i++) {
            if(playingBoard.board[row][i] == null || playingBoard.getPieceType(row, i) != pieceType) {
                rowMatch = false;
            }
        }

        // Check col
        for(int i=0;i<playingBoard.size;i++) {
            if(playingBoard.board[i][col] == null || playingBoard.getPieceType(i, col) != pieceType) {
                columnMatch = false;
            }
        }

        // Check diagonals
        for(int i=0, j=0 ;i<playingBoard.size;i++, j++) {
            if(playingBoard.board[i][j] == null || playingBoard.getPieceType(i, j) != pieceType) {
                diagonalMatch = false;
            }
        }

        // Check anti-diagonals
        for(int i=0, j=playingBoard.size-1 ;i<playingBoard.size;i++, j--) {
            if(playingBoard.board[i][j] == null || playingBoard.getPieceType(i, j) != pieceType) {
                antiDiagonalMatch = false;
            }
        }
        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}
