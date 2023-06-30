class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int n = nums2.length;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            if(st.isEmpty())st.push(nums2[i]);
            else{
                if(st.peek()<nums2[i]){
                    while(!st.isEmpty() && st.peek()<nums2[i]){
                        int x = st.pop();
                        hm.put(x,nums2[i]);
                    }
                }
                st.push(nums2[i]);
            }
        }
        int ans[] = new int[nums1.length];
        int j = 0;
        for(int i:nums1){
            if(hm.containsKey(i))ans[j++] = hm.get(i);
            else ans[j++] = -1;
        }
        return ans;
    }
}
// My Approach


//Type 2
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        
        int cnt = 0;
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums[i%n]){
                st.pop();
                cnt++;
            }
            
            if(i<n){
                if(!st.isEmpty())ans[i%n] = st.peek();
                else ans[i%n] = -1;
            }
            
            st.push(nums[i%n]);
        }
        //System.out.println(cnt);
        return ans;
    }
}

Type III
class Solution {
    public int nextGreaterElement(int n) {
        List<Integer> dig = new ArrayList<>();
        while(n>0){
            int x = n%10;
            dig.add(0,x);
            n/=10;
        }
        int break_point = -1;
        int prev = 15;
        for(int i=0;i<dig.size();i++){
            if(prev<dig.get(i)){
                break_point = i-1;
            }
            prev = dig.get(i);
        }
        
        if(dig.size() == 1 || break_point  == -1)return -1;
        else{
            for(int i = dig.size()-1;i>break_point;i--){
                if(dig.get(break_point)<dig.get(i)){
                    int y = dig.get(i);
                    dig.set(i,dig.get(break_point));
                    dig.set(break_point,y);
                    break;
                }
            }
        }
        //for(int i=break_point+1;i<dig.size())
        long ans = 0;
        int y = 0;
        for(int i = break_point+1;i<dig.size();i++){
            long pow = (long)dig.get(i)*(long)Math.pow(10,y);
            ans += (long)pow;
            y++;
        }
        for(int i=break_point;i>=0;i--){
            long pow = (long)dig.get(i)*(long)Math.pow(10,y);
            ans += (long)pow;
            y++;
        }
        return (ans>Integer.MAX_VALUE?-1:(int) ans);
    }
}
