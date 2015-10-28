// Given an array of integers, find if the array contains any duplicates.
// Your function should return true if any value appears at least twice in the
// array, and it should return false if every element is distinct.

// Time: 07:55.23

import java.util.Set;
import java.util.HashSet;

public class Solution
{
    public boolean containsDuplicate(int[] nums)
    {
        // Contains all seen before numbers. If a number shows up that
        // is already in this set, then there exist duplicates here.
        // This is an O(n) time and O(n) space solution.
        Set<Integer> existent = new HashSet<>();
        for (int i = 0; i < nums.length; i++)
        {
            if (existent.contains(nums[i]))
            {
                return true;
            }
            existent.add(nums[i]);
        }
        return false;
    }
}

// Alternatively, there does exist a way for an O(n ** 2) time and O(1) space
// solution, where for each number in the array, you check all of the numbers
// ahead of it in the array via a nested loop.
