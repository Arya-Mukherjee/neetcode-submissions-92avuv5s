class TrieNode{
    TrieNode child[];
    boolean end;

    TrieNode(){
        child = new TrieNode[26];
        end = false;
    }
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char ch :  word.toCharArray()){
            int idx = ch - 'a';
            if(curr.child[idx] == null){
                curr.child[idx] = new TrieNode();
            }
            curr = curr.child[idx];
        }
        curr.end = true;
    }

    public boolean search(String word) {
        return dfs(word, 0,root);
    }
    boolean dfs(String word, int index, TrieNode node){
        if(node == null)
            return false;
        if(index == word.length())
            return node.end;
        char ch = word.charAt(index);
        if(ch == '.'){
            for(int i = 0; i< 26;i++){
                if(dfs(word, index+1, node.child[i]))
                    return true;
            }
            return false;
        }
        return dfs(word, index+1, node.child[ch - 'a']);
    }
}
