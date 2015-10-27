// Given an array nums, write a function to move all 0's to the end of it while
// maintaining the relative order of the non-zero elements.
//
// For example, given nums = [0, 1, 0, 3, 12], after calling your function,
// nums should be [1, 3, 12, 0, 0].

// Note: You must do this in-place without making a copy of the array.
// Minimize the total number of operations.

// Time: 33:38.82

public class Solution
{
    public void moveZeroes(int[] nums)
    {
        DoubleReference.moveZeroes(nums);
    }

    private static class DoubleReference
    {
        public static void moveZeroes(int[] nums)
        {
            final int NO_ZEROES = -1;

            // Points to the left-most zero, so that the next non-zero number
            // can be inserted here. This should always point to a zero.
            int insert = NO_ZEROES;

            // Finds the next non-zero number to swap with insert.
            int select = NO_ZEROES;

            for (int i = 0; i < nums.length; i++)
            {
                if (nums[i] == 0)
                {
                    insert = i;
                    select = i;
                    break;
                }
            }

            if (insert == NO_ZEROES && select == NO_ZEROES)
            {
                return;
            }

            while ((insert != NO_ZEROES && select != NO_ZEROES)
                && (insert < nums.length && select < nums.length))
            {
                if (insert == select)
                {
                    select++;
                }
                else if (nums[select] != 0)
                {
                    nums[insert] = nums[select];
                    nums[select] = 0;

                    insert++;
                    while (nums[select] != 0)
                    {
                        select++;
                    }
                }
                else
                {
                    select++;
                }
            }
        }
    }

    private static class Bubble
    {
        public static void moveZeroes(int[] nums)
        {
            // Set nextZeroSlot to where the next 0 belongs.
            // The check for nextZeroSlot being positive must occur first, so that
            // if nextZeroSlot ends up negative, that it does not result in an
            // exception from trying to index a negative value.
            int nextZeroSlot = nums.length - 1;
            while (nextZeroSlot >= 0 && nums[nextZeroSlot] == 0)
            {
                nextZeroSlot--;
            }

            // If there is only one non-zero value in the array, and it is at the
            // start, then there is nothing to do here.
            //
            //      nextZeroSlot
            //      |
            //      v
            // EX: [1, 0, 0, 0]
            if (nextZeroSlot <= 0)
            {
                return;
            }

            // By starting at nextZeroSlot, if some of the last values are already
            // 0, then we save time not needing to look at them.
            for (int i = nextZeroSlot; i >= 0; i--)
            {
                if (nums[i] == 0)
                {
                    // If we detect a 0, then bubble it towards the end of
                    // the array.
                    for (int j = i; j < nextZeroSlot; j++)
                    {
                        swap(nums, j, j + 1);
                    }
                }
            }
        }

        private static void swap(int[] nums, int i, int j)
        {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
}

/*

IN-PLACE: Swaps only.
0's at end.

Some approaches:
- RTL bubbling.
- LTR bubbling.

(We cannot do a naive swap and then sort non-zeroes, because it has to maintain
a relative order of the non-zero elements, which are *not* guaranteed to come in
a sorted order to begin with.)

================== (Right to left.)
0   1   0   3   12 *** START
------------------
0   1   0   3   12
0   1   3   0   12
0   1   3   12  0
------------------
0   1   3   12  0
1   0   3   12  0
1   3   0   12  0
1   3   12  0   0
------------------
1   3   12  0   0  *** FINISH
==================

================== (Left to right.)
0   1   0   3   12 *** START
------------------
0   1   0   3   12
1   0   0   3   12
1   0   0   3   12
1   0   3   0   12
1   0   3   12  0
------------------
1   0   3   12  0
1   3   0   12  0
1   3   12  0   0
------------------
1   3   12  0   0  *** FINISH
==================

Left to right is not ideal; you'll end up 'bubbling' the same items over and
over. Meanwhile, right to left avoids duplicate 0's taking up extra steps.

Both approaches are O(n ** 2). You have one loop searching for zeroes and that
loop has a loop in it for each zero it encounters where it has to bubble that
loop towards the end of the array.

---

There's a better solution that involves using two references. (If you're ever
considering bubbling, see if two references works; it often makes a nice
replacement, especially since it avoids the O(n ** 2) process of bubbling.) This
solution is O(n) instead.

insert (i) keeps track of where to insert the next lowest value.
select (s) finds the next lowest value.

0   1   0   3   12

i
s
0   1   0   3   12

i
    s
0   1   0   3   12

    i
        s
1   0   0   3   12

    i
            s
1   0   0   3   12

        i
                s
1   3   0   0   12

            i
                s
1   3   12  0   0

1   3   12  0   0

// Move the insert and select pointers.
// insert should point to the next left-most zero.
// select should point to the next non-zero number.
// Note that select moves ahead of insert, and anything
// between select and insert should be established as
// zero values, since select tries to find the next
// non-zero number. Meanwhile, everything before insert
// should be a non-zero number.
//
// Basically:
//
//         i
//               s
// <----|              all non-zero numbers
//         |--|        all zeroes
//               |---> unknown
// [ 1, 2, 0, 0, ?, ?]
//
// This means that the range between insert and select will
// gradually grow as more zeroes are accumulated, and it
// will gradually 'crawl' forward until it touches the end.

*/
