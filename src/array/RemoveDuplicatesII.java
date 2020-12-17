package array;

public class RemoveDuplicatesII {
    public int removeDuplicates(int[] nums) {
        int i = 1, j = 0, time = 1;
        for(;i<nums.length;i++) {
            if(nums[i] != nums[j]) {
                nums[++j] = nums[i];
                time = 1;
            } else if(time < 2) {
                nums[++j] = nums[i];
                time++;
            }
        }
        return j + 1;
    }
}
