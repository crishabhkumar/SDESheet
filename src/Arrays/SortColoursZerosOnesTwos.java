package Arrays;

import java.util.Arrays;

public class SortColoursZerosOnesTwos {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0,1,2,0,2,1,0,2,1,0,2,0,2,1,0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    //Brute Force
//    public void sortColors(int[] nums) {
//        Arrays.sort(nums);
//    }

    //Better solution
//    public static void sortColors(int[] nums) {
//        int count0 = 0;
//        int count1 = 1;
//        int count2 = 2;
//        for(int i : nums){
//            if(i == 0) count0++;
//            else if (i == 1) count1++;
//            else count2++;
//        }
//        for(int i = 0;i<count0;i++){
//            nums[i] = 0;
//        }
//        for(int i = count0 ;i<count0 + count1;i++){
//            nums[i] = 1;
//        }
//        for (int i = count0 + count1; i <nums.length ; i++) {
//            nums[i] = 2;
//        }
//    }

    //Best - DNF(Dutch National Flag Algorithm)
    public static void sortColors(int[] nums) {
        int low = 0,mid = 0,high = nums.length-1;
        while(mid <= high){
            if(nums[mid] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            }else if(nums[mid] == 1){
                mid++;
            }else if(nums[mid] == 2){
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }
}

