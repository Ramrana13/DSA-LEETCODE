class NumArray {
    private int[] tree;
    private int n;

    public NumArray(int[] nums) {
        if(nums.length>0){
            n=nums.length;
            tree=new int[n*4];
            buildTree(nums,0,0, n-1);

        }
        
    }
    private void buildTree(int[] nums,int treeIndex,int lo, int hi){
        if(lo==hi){
            tree[treeIndex]=nums[lo];
            return;
        }
        int mid=lo+(hi-lo)/2;
        int leftChild=2*treeIndex+1;
        int rightChild=2*treeIndex+2;

        buildTree(nums,leftChild,lo,mid);
        buildTree(nums,rightChild,mid+1,hi);

        tree[treeIndex]=tree[leftChild]+tree[rightChild];   
            
    }
    
    public void update(int index, int val) {
        updateTree(0,0,n-1,index,val);

        
    }
    private void updateTree(int treeIndex,int lo,int hi, int arrIndex, int val){
        if(lo==hi){
            tree[treeIndex]=val;
            return;
        }
        int mid=lo+(hi-lo)/2;
        int leftChild=2*treeIndex+1;
        int rightChild=2*treeIndex+2;

        if(arrIndex<=mid){
            updateTree(leftChild,lo,mid, arrIndex,val);
        }else{
            updateTree(rightChild,mid+1,hi,arrIndex, val);
        }
        tree[treeIndex]=tree[leftChild]+tree[rightChild];
    }
    
    public int sumRange(int left, int right) {
        return numquery(0,0,n-1,left,right);
        }
        
    private int numquery(int treeIndex, int lo ,int hi, int i, int j){
        if(lo>j || hi<i){
            return 0;
        }
        if(i<=lo && hi<=j){
            return tree[treeIndex];
        }
        int mid=lo+(hi-lo)/2;
        int leftChild=2*treeIndex+1;
        int rightChild=2*treeIndex+2;

        int leftSum=numquery(leftChild, lo, mid, i, j);
        int rightSum=numquery(rightChild,mid+1,hi,i,j);

        return leftSum+rightSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */