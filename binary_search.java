class Solution {
    public int binarysearch(int[] arr, int k) {
        // Code Here
        int min=0;
        int max=arr.length-1;
        int mid=(max+min)/2;
        
        while(min<=max){
            mid=(max+min)/2;
            if(arr[mid]==k){
                return mid;
            }
            else if(arr[mid]>k){
            max=mid-1;
            }
            else if(arr[mid]<k){
                min=mid+1;
            }
        }
        return -1;
    }
}
