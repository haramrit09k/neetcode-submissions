class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
       int[][] cars = new int[position.length][2];
       for(int i = 0; i < position.length; i++){
        cars[i][0] = position[i];
        cars[i][1] = speed[i];
       }

       Arrays.sort(cars, (a, b) -> Integer.compare(a[0], b[0]));

        Stack<Double> stack = new Stack<>();
        // go in descending order
        for(int i = position.length - 1; i>= 0; i--){
            double time = (double)(target - cars[i][0])/cars[i][1];
            if(!stack.isEmpty()){
                if(time > stack.peek()) stack.push(time);
            }
            else{
                stack.push(time);
            }
        }

        return stack.size();
    }
}