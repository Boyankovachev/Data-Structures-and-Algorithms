public class BST {

    private class Node {
        int key;
        public Node left, right;

        public Node(int data){
            key = data;
            left = right = null;
        }
    }

    private Node root;

    public BST(){
        root = null;
    }



    public void deleteKey(int key){
        root = deleteRecursive(root, key);
    }

    private Node deleteRecursive(Node root, int key){
        //tree is empty
        if(root == null){
            return root;
        }

        if(key < root.key){
            root.left = deleteRecursive(root.left, key);
        }
        else if(key > root.key){
            root.right = deleteRecursive(root.right, key);
        }
        else {
            //if only 1 child
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            //if 2 children
            root.key = minValue(root.right);

            root.right = deleteRecursive(root.right, root.key);
        }
        return root;
    }

    private int minValue(Node root){
        int minVal = root.key;
        while (root.left != null){
            minVal = root.left.key;
            root = root.left;
        }
        return minVal;
    }



    public void insert(int key){
        root = insertRecursive(root, key);
    }

    private Node insertRecursive(Node root, int key){
        //tree is empty
        if(root == null){
            root = new Node(key);
        }

        //traverse the tree
        if(key < root.key){
            root.left = insertRecursive(root.left, key);
        }
        else if(key > root.key){
            root.right = insertRecursive(root.right, key);
        }

        return root;
    }



    public boolean isKeyPresent(int key){
        root = searchRecursive(root, key);
        if(root!=null){
            return true;
        }
        else {
            return false;
        }
    }

    private Node searchRecursive(Node root, int key){
        if(root == null || root.key==key){
            return root;
        }
        if(root.key > key){
            return searchRecursive(root.left, key);
        }else {
            return searchRecursive(root.right, key);
        }
    }



    public void inorder(){
        inorderRecursive(root);
    }

    private void inorderRecursive(Node root){
        if (root != null){
            inorderRecursive(root.left);
            System.out.print(root.key + " ");
            inorderRecursive(root.right);
        }
    }


}
