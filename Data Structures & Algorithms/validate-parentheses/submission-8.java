class Solution {
    public boolean isValid(String s) {
        // with stack
        Stack<Character> st = new Stack<>();

        if (s.length() < 2)
            return false; // less than 2 chars implies no matching pairs

        for (char ch : s.toCharArray()) {
            if (ch == '[' || ch == '{' || ch == '(') {
                // push on stack
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                char top = st.pop();
                if (top == '[' && ch != ']')
                    return false;
                else if (top == '{' && ch != '}')
                    return false;
                else if (top == '(' && ch != ')')
                    return false;
            }
        }

        return st.isEmpty();
    }
}
