class PrefixTree {

    PrefixTree[] children;
    boolean isEnd;

    public PrefixTree() {
        this.children = new PrefixTree[26];
    }

    public void insert(String word) {
        PrefixTree curr = this;
        for(char c: word.toCharArray()){
            int index = c - 'a';

            if(curr.children[index] == null){
                curr.children[index] = new PrefixTree();
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        PrefixTree curr = this;
        for(char c: word.toCharArray()){
            int index = c - 'a';

            if(curr.children[index] == null){
                return false;
            }
            else{
                curr = curr.children[index];
            }
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        PrefixTree curr = this;
        for(char c: prefix.toCharArray()){
            int index = c - 'a';

            if(curr.children[index] == null){
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }
}
