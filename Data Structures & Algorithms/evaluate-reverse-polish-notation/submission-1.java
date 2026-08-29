class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for(String token: tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")){
                int op2 = stack.pop();
                int op1 = stack.pop();
                int res = 0;
                if(token.equals("+")) res = op1 + op2;
                else if(token.equals("-")) res = op1 - op2;
                else if(token.equals("*")) res = op1 * op2;
                else if(token.equals("/")) res = op1 / op2;
                else throw new IllegalArgumentException();
                stack.push(res);
            }
            else{
                stack.push(Integer.parseInt(token)); // assuming an integer otherwise
            }
        }

        return stack.pop();
    }
}
