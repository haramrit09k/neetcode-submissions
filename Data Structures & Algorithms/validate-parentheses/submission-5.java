class Solution {
    public boolean isValid(String s) {
        // with stack
        Stack<Character> st = new Stack<>();

        if(s.length() < 2) return false; //less than 2 chars implies no matching pairs

        for (char ch : s.toCharArray()) {
            if (ch == '[' || ch == '{' || ch == '(') {
                // push on stack
                st.push(ch);
            } else {
                if (st.peek() == '[' && ch == ']')
                    st.pop();
                else if (st.peek() == '{' && ch == '}')
                    st.pop();
                else if (st.peek() == '(' && ch == ')')
                    st.pop();
            }
        }

        return st.isEmpty();
    }
}
