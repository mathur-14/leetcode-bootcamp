class Solution {
    public int maxArea(int[] height) {
        int vol = 0;
        for( int i=0, j=height.length-1; i<j;) {
            int l = height[i]<height[j]?height[i]:height[j];
            if (l*(j-i) > vol)
                vol = l*(j-i);
            if(height[i]<height[j])
                i++;
            else
                j--;
        }
        return vol;
    }
}