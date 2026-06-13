class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            int l = s.length();
            sb.append(l).append("#").append(s);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        List<String> res = new ArrayList<String>();
        while(i < str.length()){
            int j = str.indexOf('#', i); // index of # starting from i
            int strLen = Integer.parseInt(str.substring(i, j));
            String s = str.substring(j+1, j+1+strLen);
            res.add(s);
            i = j + 1 + strLen;
        }
        return res;
    }
}
