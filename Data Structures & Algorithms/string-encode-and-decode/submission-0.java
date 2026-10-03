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
            int strLen = Integer.parseInt(str.substring(i, i+1));
            String s = str.substring(i+2, i+2+strLen);
            res.add(s);
            i = i + 2 + strLen;
        }
        return res;
    }
}
