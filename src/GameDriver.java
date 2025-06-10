/* Thomas Wilson
Dr. Steinberg
COP3503 Spring 2025
Programming Assignment 1
*/

import java.util.Random;
public class GameDriver
{
    public static void main(String [] args) throws Exception
    {
//different seeds for each random object
        Random rand1 = new Random(1);
        Random rand2 = new Random(2);
        Random rand3 = new Random(3);
        Random rand4 = new Random(4);
        Random rand5 = new Random(5);
        Random rand6 = new Random(6);
        Random rand7 = new Random(7);
        Random rand8 = new Random(8);
        Random rand9 = new Random(9);
        Random rand10 = new Random(10);
        System.out.println("Testing to See if Player 1 will always win with the 10 random seeds.");
        Game g1 = new Game(rand1);
        Game g2 = new Game(rand2);
        Game g3 = new Game(rand3);
        Game g4 = new Game(rand4);
        Game g5 = new Game(rand5);
        Game g6 = new Game(rand6);
        Game g7 = new Game(rand7);
        Game g8 = new Game(rand8);
        Game g9 = new Game(rand9);
        Game g10 = new Game(rand10);
        if(g1.play() == 1)
            System.out.println("Game 1 Pass!");
        else
            System.out.println("Game 1 Fail!");
        if(g2.play() == 1)
            System.out.println("Game 2 Pass!");
        else
            System.out.println("Game 2 Fail!");
        if(g3.play() == 1)
            System.out.println("Game 3 Pass!");
        else
            System.out.println("Game 3 Fail!");
        if(g4.play() == 1)
            System.out.println("Game 4 Pass!");
        else
            System.out.println("Game 4 Fail!");
        if(g5.play() == 1)
            System.out.println("Game 5 Pass!");
        else
            System.out.println("Game 5 Fail!");
        if(g6.play() == 1)
            System.out.println("Game 6 Pass!");
        else
            System.out.println("Game 6 Fail!");
        if(g7.play() == 1)
            System.out.println("Game 7 Pass!");
        else
            System.out.println("Game 7 Fail!");
        if(g8.play() == 1)
            System.out.println("Game 8 Pass!");
        else
            System.out.println("Game 8 Fail!");
        if(g9.play() == 1)
            System.out.println("Game 9 Pass!");
        else
            System.out.println("Game 9 Fail!");
        if(g10.play() == 1)
            System.out.println("Game 10 Pass!");
        else
            System.out.println("Game 10 Fail!");
    }
}

class Game {
    int[][] mapArray = new int[8][8];
    char[] characterArray = {'d', 'r', 'b'};
    int currentRow = 0;
    int currentColumn = 0;
    Random randomSeed;

    public Game(Random rand) {
        this.randomSeed = rand;
    }

    public int play() {
        int playerTurn = 1;

        while (true) {
            if (playerTurn == 1) {
                selectPlayerOneMove();
            } else {
                while (true) {
                    if (simulateMove(selectPlayerTwoMove())) {
                        break;
                    }
                }
            }

            // If at Row 8 and Column 8, end simulation;
            if (mapArray[7][7] == 1) {
                break;
            }

            // After each play, swap whose turn it is.
            playerTurn = playerTurn == 1 ? 2 : 1;
        }

        // Return who's last turn it was.
        return playerTurn;
    }

    private void selectPlayerOneMove() {
        boolean changeRow = false;
        boolean changeColumn = false;

        if ((currentRow & 1) == 0) {
            changeRow = true;
        }

        if ((currentColumn & 1) == 0) {
            changeColumn = true;
        }

        if (changeColumn && changeRow) {
            simulateMove('d');
        } else if (changeColumn) {
            simulateMove('r');
        } else if (changeRow){
            simulateMove('b');
        }
    }

    private char selectPlayerTwoMove() {
        return characterArray[randomSeed.nextInt(3)];
    }

    private boolean simulateMove(char moveChoice) {
        if (moveChoice == 'd') {
            if (validLocation(currentRow + 1, currentColumn + 1)) {
                mapArray[currentRow][currentColumn] = 0;
                mapArray[currentRow + 1][currentColumn + 1] = 1;
                currentRow++;
                currentColumn++;
                return true;
            }
        } else if (moveChoice == 'r') {
            if (validLocation(currentRow, currentColumn + 1)) {
                mapArray[currentRow][currentColumn] = 0;
                mapArray[currentRow][currentColumn + 1] = 1;
                currentColumn++;
                return true;
            }
        } else if (moveChoice == 'b') {
            if (validLocation(currentRow + 1, currentColumn)) {
                mapArray[currentRow][currentColumn] = 0;
                mapArray[currentRow + 1][currentColumn] = 1;
                currentRow++;
                return true;
            }
        }
        return false;
    }

    private boolean validLocation(int row, int column) {
        return row >= 0 && row <= 7 && column >= 0 && column <= 7;
    }
}