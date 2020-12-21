package array;

public class IncreasingTripletSubsequence {
    // O(n)
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;
        int small = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;
        for(int num : nums) {
            if(num <= small) {
                small = num;
            } else if (num <= mid) {
                mid = num;
            } else {
                return true;
            }
        }
        return false;
    }

    // worst: O(n ^ 3)
    public boolean increasingTriplet1(int[] nums) {
        if(nums.length < 3) return false;
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                if(nums[i] >= nums[j]) continue;
                for(int k = j + 1; k < nums.length; k++) {
                    if(nums[i] < nums[j] && nums[j] < nums[k]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


}
