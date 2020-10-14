import java.util.*;

public class BinaryTree {

	private char[] items = {'F','B','A','D','C','E','G','I','H'};
	private final static String PREORDER = "Pre Order";
	private final static String POSTORDER = "Post Order";
	private final static String INORDER = "In Order";
	private final static String BREADTHFIRSTSEARCH = "Breath First Search";
	
	public static void main(String[] args) {
		
		BinaryTree bt = new BinaryTree();
		/*System.out.println("-------------------------------");
		bt.loadBinaryTree(PREORDER);
		System.out.println("-------------------------------");
		bt.loadBinaryTree(INORDER);
		System.out.println("-------------------------------");
		bt.loadBinaryTree(POSTORDER);
		System.out.println("-------------------------------");
		bt.loadBinaryTree(BREADTHFIRSTSEARCH);		
		*/
		System.out.println("Rendom numbers: " + bt.hashFunction());
		System.out.println("Rendom numbers: " + bt.hashFunction());
		System.out.println("Rendom numbers: " + bt.hashFunction());
		System.out.println("Rendom numbers: " + bt.hashFunction());
		System.out.println("Rendom numbers: " + bt.hashFunction());
		System.out.println("Rendom numbers: " + bt.hashFunction());
		System.out.println("Rendom numbers: " + bt.hashFunction());
		System.out.println("Rendom numbers: " + bt.hashFunction());
		System.out.println("Rendom numbers: " + bt.hashFunction());
		System.out.println("Rendom numbers: " + bt.hashFunction());
		
		bt.test();
	}
	
	class Node {
		
		char value;
		
		Node leftNode;
		Node rightNode;
		
		Node(char value) { this.value = value; }
		void setRightNode(Node rightNode) {this.rightNode = rightNode; }
		void setLeftNode(Node leftNode) {this.leftNode = leftNode; }
	}
	
	public void loadBinaryTree(String style) {
		
		if (style.equals(PREORDER)) {
			for (int i = 0; i < items.length; i++ ) {
				Node node = new Node(items[i]);
				iterativePreorder(node);
			}
		} else if (style.equals(POSTORDER)) {
			for (int i = 0; i < items.length; i++ ) {
				Node node = new Node(items[i]);
				iterativePostOrder(node);
			}			
		} else if (style.equals(INORDER)) {
			for (int i = 0; i < items.length; i++ ) {
				Node node = new Node(items[i]);
				iterativeInOrder(node);
			}			
		} else if (style.equals(BREADTHFIRSTSEARCH)) {
			for (int i = 0; i < items.length; i++ ) {
				Node node = new Node(items[i]);
				breathFirstSearch(node);
			}
		}
	}
	
	public void iterativePreorder(Node root) {
		Stack<Node> nodes = new Stack<Node>();
        nodes.push(root);
        Node currentNode;
        while (!nodes.isEmpty()) {
                currentNode = nodes.pop();
                Node right = currentNode.rightNode;
                if (right != null) {
                	nodes.push(right);
                }
                Node left = currentNode.leftNode;
                if (left != null) {
                	nodes.push(left);      
                }
                System.out.println("Node data: " + currentNode.value);
        }
	}
	
	public void iterativePostOrder(Node root) {
		if (root == null) 
			return;
		Stack<Node> nodes = new Stack<Node>();
		
		Node currentNode = root;
		while (true) {
			if(currentNode != null) {
				Node right = currentNode.rightNode;
				if (right != null) {
					nodes.push(right);
				}
				nodes.push(currentNode);
				currentNode = currentNode.leftNode;
				break;
			}
			
			if (nodes.isEmpty()) {
				return;
			}
			
			currentNode = nodes.peek();
			nodes.pop();
			
			if (currentNode.rightNode != null && !nodes.isEmpty() && currentNode.rightNode == nodes.peek()) {
				nodes.pop();
				nodes.push(currentNode);
				currentNode = currentNode.rightNode;
			} else {
				System.out.println("Node data: "+ currentNode.value);
				currentNode = null;
			}
		}
	}
	
	public void iterativeInOrder(Node node) {
	    Stack<Node> nodes = new Stack<Node>();
	    while (!nodes.isEmpty() || null != node) {
	        if (null != node) {
	            nodes.push(node);
	            node = node.leftNode;
	        } else {
	            node = nodes.pop();
	            System.out.println("Node value: " + node.value);
	            node = node.rightNode;
	        }
	    }
	}	
	
	public void breathFirstSearch(Node root) {
		Queue<Node> q = new java.util.concurrent.ConcurrentLinkedQueue<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			Node node = q.poll();
			System.out.println("Node value: " + node.value);
			if (node.leftNode != null)
				q.add(node.leftNode);
			if (node.rightNode != null)
				q.add(node.rightNode);
		}
		
	}
	
	public int rand5() {
		Random randomGenerator = new Random();
		while (true) {
	      int num = randomGenerator.nextInt(100);
	      if (num >= 1 && num <= 5) return num;
	    }
	}
	
	public void test() {
		int x = 7;
		int y = x << 1;
	    System.out.println(y);
	}
	
	public int hashFunction() {
		int r1 = rand5();
    	int r2 = rand5();
	    while(true) {
	    	r1 = 36969 * (r1 & 65535) + (r1 >> 1);
	    	r2 = 18000 * (r2 & 65535) + (r2 >> 1);
	    	int num = ((r1 << 1) + r2) / 36969;
	    	if (num >= 1 && num <= 7) return num; 
	    }
	}

}
