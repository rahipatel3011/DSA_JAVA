class Solution {
    
    public static class Node{
        Node[] children;
        boolean eow;
        public Node(){
            children = new Node[26];
            eow = false;
        }
    }
    
    public static void buildTree(String str, Node root, int idx){
        if(idx == str.length()){
            return;
        }
        int nodeNumber = str.charAt(idx) - 'a';
        if(root.children[nodeNumber] == null){
            Node newNode = new Node(); 
            root.children[nodeNumber] = newNode;
        }
        if(idx == str.length() - 1){
            root.children[nodeNumber].eow = true;
        }
        idx++;
        buildTree(str, root.children[nodeNumber], idx);
            
    }

    public static void getAllWord(Node root, String word){
        if(root.eow == true){
            System.out.println(word);
        }
        for(int i=0; i<26; i++){
            Node children = root.children[i];
            if (children != null) {
                char ch = (char) ('a' + i);
                String newWord = word + ch;
                getAllWord(root.children[i], newWord);
            }
        }
    }

    public static String commonPrefix(Node root, String common){
        if(root.eow){
            return common;
        }
        int numberOfChildren = 0;
        int childrenNode = 0;
        for(int i=0; i<26; i++){
            if(root.children[i] != null){
                numberOfChildren++;
                childrenNode = i;
            }
        }
        if(numberOfChildren == 1){
            char ch = (char) ('a' + childrenNode);
            return commonPrefix(root.children[childrenNode], common + ch );
        }
        return common;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flowerpot","dfg"};
        Node root = new Node();
        for(String str: strs){
            buildTree(str, root, 0);
        }

        String s = commonPrefix(root, "");
        System.out.println(s);
    }
}