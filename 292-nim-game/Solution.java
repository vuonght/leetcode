// You are playing the following Nim Game with your friend: There is a heap of
// stones on the table, each time one of you take turns to remove 1 to 3 stones.
// The one who removes the last stone will be the winner. You will take the
// first turn to remove the stones.

// Both of you are very clever and have optimal strategies for the game. Write
// a function to determine whether you can win the game given the number of
// stones in the heap.

// For example, if there are 4 stones in the heap, then you will never win the
// game: no matter 1, 2, or 3 stones you remove, the last stone will always be
// removed by your friend.

// Time: 22:39.75
public class Solution
{
    public boolean canWinNim(int n)
    {
        if (n <= 0)
        {
            // Precondition: n must be a positive integer.
            // Failing to meet this indicates an invalid game.
            return false;
        }

        // 4 is problematic. Starting on any multiple of 4 will get the first
        // player eventually back to 4, which is completely unwinnable assuming
        // optimal strategies.
        return n % 4 != 0;
    }
}

/*

tree recursion? may branch a lot

trie: max 3 choices with potentially max 3 choices each; win if possible path is odd

remove 1-3 per turn
last removal WINS
optimal; try to get opponent down to x, where x -> false
x + 1..3 is autowin, since you can force x on opponent
player goes FIRST

precondition: n > 0

1
    0*

2
    1
        0
    0*

3
    2
        1
            0
    1
        0
    0*

4x
    3
        0
    2
        0
    1
        0

5
    4*
    3
    2

6
    5
    4*
    3

7
    6
    5
    4*

8x
    7
    6
    5

9
    8*
    7
    6

10
    9
    8*
    7

11
    10
    9
    8*

12
    11
    10
    9
*/

