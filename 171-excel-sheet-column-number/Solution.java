// Given a column title as appear in an Excel sheet, return its corresponding
// column number.
//
// For example:
//
//    A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28

// Time: 11:02.67

public class Solution
{
    public int titleToNumber(String s)
    {
        final int RADIX = 26; // 26 chars in alphabet.

        // Assumption: Valid string.
        String title = s.toUpperCase();

        // Go right to left on the string. This is an O(n) time solution.
        int colNumber = 0;
        for (int i = title.length() - 1; i >= 0; i--)
        {
            int exponent = title.length() - 1 - i;
            int digitValue = title.charAt(i) - 'A' + 1;
            colNumber += digitValue * Math.pow(RADIX, exponent);
        }

        return colNumber;
    }
}

/*

AA = (1 * (26 ** 1)) + (1 * (26 ** 0)) = 26 + 1 = 27
DA = (4 * (26 ** 1)) + (1 * (26 ** 0)) = 104 + 1 = 105
EB = (5 * (26 ** 1)) + (2 * (26 ** 0)) = 130 + 2 = 132

*/
