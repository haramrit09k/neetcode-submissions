class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];

            int len = Math.min(first.length(), second.length());

            if (first.length() > second.length() && first.startsWith(second))
                return ""; // invalid prefix type shit

            for (int j = 0; j < len; j++) {
                char c1 = first.charAt(j);
                char c2 = second.charAt(j);

                if (c1 != c2) {
                    // add edge
                    if (!adj.get(c1).contains(c2)) { // if edge does not exist already
                        adj.get(c1).add(c2); // add edge
                        indegree.put(c2, indegree.get(c2) + 1); // increment indegree by 1
                    }
                    break;
                }
            }
        }

        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        while (!queue.isEmpty()) {
            char el = queue.poll();
            sb.append(el);

            for (char c : adj.get(el)) {
                int temp = indegree.get(c);
                temp--;
                indegree.put(c, temp);
                if (temp == 0)
                    queue.offer(c);
            }
        }

        if (sb.toString().length() != indegree.size()) {
            return "";
        }

        return sb.toString();
    }
}
