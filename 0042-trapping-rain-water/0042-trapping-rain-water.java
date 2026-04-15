class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int totalwater=0;
        int left=0;
        int right=n-1;
        int lmax=0; 
        int rmax=0;
        while(left<right){
            lmax=Math.max(lmax,height[left]);
            rmax=Math.max(rmax,height[right]);
            if(lmax<rmax){
                totalwater+=lmax-height[left];
                left++;

            }else{
                totalwater+=rmax-height[right];
                right--;
            }
        }
        return totalwater;
        
    }
}