class Solution {
    public boolean isValid(String s) {
        // with stack
        Stack<Character> st = new Stack<>();

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
