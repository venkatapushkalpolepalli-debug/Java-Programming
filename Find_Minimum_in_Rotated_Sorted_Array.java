
import java.util.Scanner;

public class Find_Minimum_in_Rotated_Sorted_Array {

    int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Find_Minimum_in_Rotated_Sorted_Array obj =
                new Find_Minimum_in_Rotated_Sorted_Array();

        System.out.println(obj.findMin(nums));

        sc.close();
    }
}
