class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for(String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            res.putIfAbsent(sortedStr, new ArrayList<>());
            res.get(sortedStr).add(str);
        }
        return new ArrayList<>(res.values());
    }
}
