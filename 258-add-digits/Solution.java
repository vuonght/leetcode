// Given a non-negative integer num, repeatedly add all its digits until the
// result has only one digit.

// For example:

// Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only
// one digit, return it.

// Follow Up: Could you do it without any loop / recursion in O(1) runtime?

// Time (Basic): 10:43.99
// Time (Follow Up): 36:24.58 (+25:40.49)
public class Solution
{
    public static final int INVALID = -1;

    public int addDigits(int num)
    {
        return ConstantTime.addDigits(num);
    }

    private static class ConstantTime
    {
        public static int addDigits(int num)
        {
            // Precondition: num is a non-negative integer.
            if (num < 0)
            {
                return INVALID;
            }

            if (num == 0)
            {
                // (num == 0): 0
                return 0;
            }
            else if (num % 9 == 0)
            {
                // (num % 9 == 0): 9
                return 9;
            }
            else
            {
                // (num % 9 != 0): num % 9
                return num % 9;
            }
        }
    }

    private static class Iterative
    {
        public static int addDigits(int num)
        {
            // Precondition: num is a non-negative integer.
            if (num < 0)
            {
                return INVALID;
            }

            while (num / 10 > 0)
            {
                num = sumOfDigits(num);
            }

            return num;
        }

        /** Returns the sum of the digits for non-negative integer num. */
        private static int sumOfDigits(int num)
        {
            // Precondition: num is a non-negative integer.
            if (num < 0)
            {
                return INVALID;
            }

            int acc = 0;
            while (num > 0)
            {
                // Add the digit.
                acc += num % 10;
                // Shift the num to the right.
                num /= 10;
            }
            return acc;
        }
    }
}

/*
7777 -> 28 -> 10 -> 1

38 -> 11 -> 2
5555 -> 20 -> 2
55554 -> 29 -> 11 -> 2

66 -> 12 -> 3

365 -> 14 -> 5
1337 -> 14 -> 5
8888 -> 32 -> 5

54321 -> 15 -> 6

198 -> 18 -> 9
666 -> 18 -> 9
9999 -> 36 -> 9

1 -> 1, 10, 19, 28, 37, 46, 55, 64, 73, 82, 91, 100
2 -> 2, 11, 20, 5555, 44444
3 -> 3, 12, 21, 111


10 -> 1
11 -> 2
12 -> 3
13 -> 4
14 -> 5
15 -> 6
16 -> 7
17 -> 8
18 -> 9
---
19 -> 1
20 -> 2
21 -> 3
22 -> 4
23 -> 5
24 -> 6
25 -> 7
26 -> 8
27 -> 9
---
28 -> 1
29 -> 2
30 -> 3

90 -> 9
91 -> 10 -> 1
92 -> 11 -> 2
93 -> 12 -> 3

110 -> 2 (110's == 20's)
111 -> 3
112 -> 4
113 -> 5
114 -> 6
115 -> 7
116 -> 8
117 -> 9
118 -> 10 -> 1
119 -> 11 -> 2
120 -> 3

1230 -> 6
1231 -> 7
1232 -> 8
1233 -> 9
1234 -> 10 -> 1
1235 -> 11 -> 2
1236 -> 12 -> 3
1237 -> 13 -> 4
1238 -> 14 -> 5
1239 -> 15 -> 6
1240 -> 16 -> 7
1241 -> 17 -> 8
1242 -> 18 -> 9
1243 -> 19 -> 10 -> 1

(num == 0): 0
(num % 9 == 0): 9
(num % 9 != 0): num % 9
*/
