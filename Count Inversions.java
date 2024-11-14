class Solution {
    // Function to count inversions in the array.
    static int inversionCount(int arr[]) {
        int temp[] = new int[arr.length];
        return mergeSortAndCount(arr, temp, 0, arr.length - 1);
    }
    
    // Recursive function to perform merge sort and count inversions.
    private static int mergeSortAndCount(int arr[], int temp[], int left, int right) {
        int mid, invCount = 0;
        if (left < right) {
            mid = (left + right) / 2;

            // Count inversions in the left half and right half separately
            invCount += mergeSortAndCount(arr, temp, left, mid);
            invCount += mergeSortAndCount(arr, temp, mid + 1, right);

            // Count split inversions while merging
            invCount += mergeAndCount(arr, temp, left, mid + 1, right);
        }
        return invCount;
    }
    
    // Merge two halves and count split inversions
    private static int mergeAndCount(int arr[], int temp[], int left, int mid, int right) {
        int i = left;   // Starting index for left subarray
        int j = mid;    // Starting index for right subarray
        int k = left;   // Starting index to be sorted
        int invCount = 0;

        // Merge the two halves and count inversions
        while ((i <= mid - 1) && (j <= right)) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                // There are mid - i inversions because all elements left to i in the left subarray are greater than arr[j]
                invCount += (mid - i);
            }
        }

        // Copy the remaining elements of left subarray, if any
        while (i <= mid - 1) {
            temp[k++] = arr[i++];
        }

        // Copy the remaining elements of right subarray, if any
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy the merged elements back into the original array
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return invCount;
    }
}
