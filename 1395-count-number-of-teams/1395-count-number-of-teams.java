class Solution {
    public int numTeams(int[] rating) {
        int totalteams=0;
        int n=rating.length;
        for(int j=1;j<n-1;j++){
            int leftSmaller=0,leftLarger=0;
            int rightSmaller=0,rightLarger=0;
            for(int i=0;i<j;i++){
                if(rating[i]<rating[j]){
                    leftSmaller++;

                }else if(rating[i]> rating[j]){
                    leftLarger++;
                }
            }
            for(int k=j+1;k<n;k++){
                if(rating[k]<rating[j]){
                    rightSmaller++;
                }else if(rating[k]>rating[j]){
                    rightLarger++;
                }
            }
            totalteams+=(leftSmaller*rightLarger)+(leftLarger*rightSmaller);
        }
        return totalteams;
        
    }
}