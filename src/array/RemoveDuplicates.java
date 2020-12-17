package array;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int i = 1, j = 0;
        for(;i<nums.length;i++) {
            if(nums[i] != nums[j]) {
                nums[++j] = nums[i];
            }
        }
        return j + 1;
    }
}
