class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        int[] count = new int[26];

        for(String s: strs){
            char[] chs = s.toCharArray();
            // n = num of strings, k = length of longest string in input array
            // Sorting solution - O(n * klogk)
            // Arrays.sort(chs);
            // String key = new String(chs);

            // Solution with counts array - O(n * k)
            for(char ch: chs){
                count[ch - 'a']++;
            }
            String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);

            Arrays.fill(count, 0);
        }

        return new ArrayList<>(map.values());
    }
}
