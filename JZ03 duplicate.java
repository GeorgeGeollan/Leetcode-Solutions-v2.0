public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param numbers int整型一维数组 
     * @return int整型
     */
    public int duplicate(int[] numbers) {
        // 定义一个HashSet
        HashSet<Integer> set = new HashSet<>();
        // 遍历数组
        for (int num : numbers) {
            // 添加数据，若存在，则返回true，否则返回false
            if(!set.add(num)) {
                return num;
            }
        }
        return -1;
    }
}
