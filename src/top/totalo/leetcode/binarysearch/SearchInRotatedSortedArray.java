package top.totalo.leetcode.binarysearch;

/**
 * 题目链接：<a href="https://leetcode.cn/problems/search-in-rotated-sorted-array/">33. 搜索旋转排序数组</a>
 *
 */
public class SearchInRotatedSortedArray {
    
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(new SearchInRotatedSortedArray().search(nums, target));
    }
    
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = ((r - l) >> 1) + l;
            if (nums[mid] == target) {
                return mid;
                // 如果中间值 右边的最大值大，需要在下一个端点查找
            }
            if (nums[mid] > nums[r]) {
                // 中间节点比结果值大,结果值比左端点大，说明区间为[l, mid]
                if (nums[mid] > target && target >= nums[l]) {
                    r = mid - 1;
                } else {
                    // 否则说明区间为[mid, l]
                    l = mid + 1;
                }
            } else {
                // 中间值比右边的值小。且中间值小于所需要的值，结果值也小于右边最大值说明需要更新到[mid+ 1 ]
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
