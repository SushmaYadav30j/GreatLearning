package greatlearning.bst.model.com;

	class Node
	{
	    int val;
	    Node left, right;
	    
	    Node(int item)
	    {
	        val = item;
	        left = right = null;
	    }
	}
public	class Skewedtree{
	    public static Node node;
	    static Node prevNode = null;
	    static Node headNode = null;
	   
	    static void flattenBTToSkewed(Node root)
	    {
	       
	        if(root == null)
	        {
	            return;
	        }
	        flattenBTToSkewed(root.left);
	        Node rightNode = root.right;
	        Node leftNode = root.left;
	      
	        if(headNode == null)
	        {
	            headNode = root;
	            root.left = null;
	            prevNode = root;
	        }
	        else
	        {
	            prevNode.right = root;
	            root.left = null;
	            prevNode = root;
	        }
	            flattenBTToSkewed(rightNode);
	    }
	   
	    static void traverseRightSkewed(Node root)
	    {
	        if(root == null)
	        {
	            return;
	        }
	        System.out.print(root.val + " ");
	        traverseRightSkewed(root.right);       
	    } 

	    public static void main (String[] args)
	    {
	    	Skewedtree tree = new Skewedtree();
	    	tree.node = new Node(50);
	    	tree.node.left = new Node(30);
	    	tree.node.right = new Node(60);
	    	tree.node.left.left = new Node(10);
	    	tree.node.right.left = new Node(55);
	       
	        flattenBTToSkewed(node);
	        traverseRightSkewed(headNode);
	    }
	}
	
