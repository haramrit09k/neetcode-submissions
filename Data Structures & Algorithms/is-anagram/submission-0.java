class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if (!mapS.containsKey(s.charAt(i))) {
                mapS.put(s.charAt(i), 1);
            }
            else {
                mapS.put(s.charAt(i), mapS.get(s.charAt(i)) + 1);
            }
        }

        for(int j = 0; j < t.length(); j++){
            if(!mapT.containsKey(t.charAt(j))) {
                mapT.put(t.charAt(j), 1);
            }
            else {
                mapT.put(t.charAt(j), mapT.get(t.charAt(j)) + 1);
            }
        }

        return mapS.equals(mapT);
    }
}
