class Solution
{
    int ans = 1;
	boolean isSumTree(Node root)
	{
	    if(root == null)return false;
             // Your code here
             return f(root)!=Long.MAX_VALUE;
	}
	long f(Node root){
	    if(root == null)return 0l;
	    
	    long left = f(root.left);
	    long right = f(root.right);
	    
	    if(left == Long.MAX_VALUE || right == Long.MAX_VALUE)return Long.MAX_VALUE;
	    if(!isLeaf(root) && left+right!=root.data)return Long.MAX_VALUE;
	    
	    return (left+right+(long)root.data);
	    
	    
	}
	boolean isLeaf(Node root){
	    return (root.left == null && root.right == null);
	}
}
