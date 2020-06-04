//Runtime: 1 ms, faster than 99.95% of Java online submissions for Two Sum
//Memory Usage: 39.4 MB, less than 5.65% of Java online submissions for Two Sum.

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target
*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
     int[] result={0,0};
        Map<Integer, Integer> map=new HashMap<>();
        for(int iter=0;iter<nums.length;iter++){
            
            int complement=target-nums[iter];
            if(map.containsKey(complement)){
                result[0]=map.get(complement);
                result[1]=iter;
                break;
            }
            map.put(nums[iter],iter);
        }
        
        return result;
        
        
    }
}
