public class Main {
    public static void main(String[] args) {
        System.out.println("Tic Tac Toe!");
        TicTacToe game = new TicTacToe();
        game.initialiseGame();
        System.out.println("game winner is: " + game.startGame());
    }
}