// Java code to find floor of a key in BST
class Main {
 
    /*Structure of each Node in the tree*/
    static class Node {
        int data;
        Node left, right;
    }
 
    /*This function is used to create and
initializes new Nodes*/
    static Node newNode(int key)
    {
        Node temp = new Node();
        temp.left = null;
        temp.right = null;
        temp.data = key;
        return temp;
    }
 
    /* This function is used to insert
new values in BST*/
    static Node insert(Node root, int key)
    {
        if (root == null)
            return newNode(key);
        if (key < root.data)
            root.left = insert(root.left, key);
        else
            root.right = insert(root.right, key);
        return root;
    }
 
    /*This function is used to find floor of a key*/
    static int floor(Node root, int key)
    {
        if (root == null)
            return Integer.MAX_VALUE;
 
        /* If root->data is equal to key */
        if (root.data == key)
            return root.data;
 
        /* If root->data is greater than the key */
        if (root.data > key)
            return floor(root.left, key);
 
        /* Else, the floor may lie in right subtree
    or may be equal to the root*/
        int floorValue = floor(root.right, key);
       
        if(floorValue<=key){
            return floorValue;
        }
        else{
            return root.data;
        }
    }
    
    static int ceil(Node root,int x){
        //if root is null return -1 that is the condition of base case
        if(root==null){
            return -1;
        }
        //if root's data = given key then our value is already fiiund
        else if(root.data==x){
            return root.data;
        }
        /*if root's data is less than key then we need not go into left sub tree we are sure to find the value in right sub tree if it exists*/
        else if(root.data<x){
            return ceil(root.right,x);
        }
        /* here we call an integer type variable Ceil if the root's data is greater than that of the given key */
       int Ceil= ceil(root.left,x);
        /* if Ceil>= key then return it else return the root's value*/
        if(Ceil>=x){
            return Ceil;
        }
        else{
            return root.data;
        }
    }
 
    public static void main(String[] args)
    {
        /* Let us create following BST
            7
            / \
        5     10
        / \ / \
        3 6 8 12 */
        Node root = null;
        root = insert(root, 7);
        insert(root, 10);
        insert(root, 5);
        insert(root, 3);
        insert(root, 6);
        insert(root, 8);
        insert(root, 12);
        System.out.println(floor(root, 9));
        System.out.println(ceil(root, 9));
    }
}
