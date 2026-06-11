class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        for(String s: strs){
            char[] chs = s.toCharArray();
            // Sorting solution
            // Arrays.sort(chs);
            // String key = new String(chs);

            // Solution with counts array
            int[] count = new int[26];
            for(char ch: chs){
                count[ch - 'a']++;
            }
            String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
