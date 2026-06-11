class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        for(String s: strs){
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String key = new String(chs);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
