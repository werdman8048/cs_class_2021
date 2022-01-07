import java.util.Scanner;

public class ConnectFour {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

		int inputnum = -1;

			System.out.println("0: Quit");
      System.out.println("1: Play Connect-Four");

			inputnum = scanner.nextInt();

			switch (inputnum) {
				case 0: 
					break;
				case 1: 
					Board b = new Board();
          b.runGame();
          break;
				default:
					System.out.println("Illegal value entered");
			}
		}
  }


class Board {
  String[][] board = {
    {".", ".", ".", ".", ".", ".", "."},
    {".", ".", ".", ".", ".", ".", "."},
    {".", ".", ".", ".", ".", ".", "."},
    {".", ".", ".", ".", ".", ".", "."},
    {".", ".", ".", ".", ".", ".", "."},
    {".", ".", ".", ".", ".", ".", "."}
  };

  boolean dropToken(int x, String piece) {
    int height = 6;
    int width = 7;

    for (int i = height - 1; i >= 0; i--) {
      if (moveAllowed(i, x)) {
        board[i][x] = piece;
        return true;
      }
    }
    System.out.println("Move invalid, please try again");
    return false;
  }
  
  private boolean moveAllowed(int y, int x) {
    if (board[y][x] != ".") {
      return false;
    }
    return true;
  }

  public void runGame() {
    Scanner scanner = new Scanner(System.in);
    int player = 1;
    String piece;
    while (update()) {
      if (player == 1) {
        System.out.print("Player one ");
        piece = "X";
        player++;
      } else {
        System.out.print("Player two ");
        piece = "O";
        player--;
      }
      System.out.println("enter row:");
      int inputNum = scanner.nextInt();
      dropToken(inputNum, piece);
    }
  }

  private boolean update() {
    printBoard();
    if (checkTie()) {return false;}
    if (checkWinner("X")) {return false;}
    if (checkWinner("O")) {return false;}
    return true;
  }
  private void printBoard() {
    int height = 6;
    int width = 7;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        System.out.print(board[i][j]);
      }
      System.out.println();
    }
  }

  boolean checkTie() {
    int height = 6;
    int width = 7;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (board[i][j] == ".") {return false;}
      }
      System.out.println();
    }
    return true;
  }

  boolean checkWinner(String piece) {
    int height = 6;
    int width = 7;

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (winHelper(i, j, piece)) {return true;}
      }
    }
    return false;
  }

  //It's probably possible to better optimize all this win checking, because if the 2nd piece isn't the same then doesn't need to check the third and the fourth. Also don't have to check both X's and O's every time the board is updated, only the piece that is played.
  private boolean winHelper(int posy, int posx, String piece) {
    boolean a = true;
    boolean b = true;
    boolean c = true;
    for (int i = 0; i < 4; i++) {
      try {
        if (board[posy + i][posx] != piece) {
          a = false;
        };   
      } catch (Exception e) {
        a = false;
      }
      try {
        if (board[posy][posx + i] != piece) {
          b = false;
        }
      } catch (Exception e) {
        b = false;
      }
    }

    c = diagonalWins(posy, posx, piece);

    if (a || b || c) {
      System.out.println("The " + piece + " pieces won!");
      return true;
    }
    return false;
  }
  private boolean diagonalWins(int posy, int posx, String piece) {
    boolean a = true;
    boolean b = true;
    for (int i = 0; i < 4; i++) {
      try {
        if (board[posy + i][posx + i] != piece) {
          a = false;
        }
      } catch (Exception e) {
        a = false;
      }
      try {
        if (board[posy - i][posx + i] != piece) {
          b = false;
        }
      } catch (Exception e) {
        b = false;
      }
    }

    if (a || b) {
      return true;
    }
    return false;
  }
}

