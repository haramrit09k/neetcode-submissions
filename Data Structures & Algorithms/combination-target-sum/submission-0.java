class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(nums, target, 0, 0, path, res);
        return res;
    }

    public void dfs(int[] nums, int target, int index, int sum, List<Integer> path, List<List<Integer>> candidates) {
        if(sum == target){
            candidates.add(new ArrayList<>(path));
            return;
        }

        if(sum > target || index >= nums.length){
            return;
        }

        path.add(nums[index]);
        dfs(nums, target, index, sum + nums[index], path, candidates);

        path.remove(path.size() - 1);

        dfs(nums, target, index+1, sum, path, candidates);
    }
}
