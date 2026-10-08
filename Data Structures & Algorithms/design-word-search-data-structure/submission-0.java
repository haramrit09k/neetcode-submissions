class WordDictionary {

    class TrieNode{ 
        TrieNode[] children;
        boolean isEnd;

        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for(char c: word.toCharArray()){
            int index = c - 'a';

            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
       return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node){
        if(index == word.length()){
            return node.isEnd;
        }

        char c = word.charAt(index);

        if(c == '.'){
            for(TrieNode child: node.children){
                if(child != null && dfs(word, index+1, child)){
                    return true;
                }
            }
            return false;
        }

        int childIndex = c - 'a';

        if(node.children[childIndex] == null){
            return false;
        }

        return dfs(word, index+1, node.children[childIndex]);
    }
}
