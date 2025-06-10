Game Mechanics:
A player moves a marker from the top-left (0, 0) to the bottom-right (7, 7) of an 8x8 grid.

Player 1 uses a fixed strategy (based on even/odd values of current position).

Player 2 makes random moves using the Random object passed into the constructor.

Player Movement Options:
'd': Diagonal (down + right)

'r': Right

'b': Down

Gameplay Loop:
Players take turns.

After each move, check if marker reached (7, 7).

The player who makes the final move (to reach (7, 7)) is returned as the winner (1 or 2).

Key Features
Deterministic testing: Each game has a different random seed, ensuring varied and reproducible outcomes.

Fixed AI strategy for Player 1: Tries diagonal moves when on even rows/columns, otherwise moves either down or right.

Random AI for Player 2: Chooses randomly between the three move options until a valid one is made.
