package codingLecture;


class Node {
	// 노드는 데이터와 왼쪽 오른쪽 값을 갖는다.
	int data;
	Node left;
	Node right;
	
}

class Tree {
	// 시작점 루트를 선언한다
	private Node root;
	
	// 겟, 셋 루트를 정의해야 한다
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	// 노드를 만드는 함수를 생성
	public Node makeNode(Node left, int data, Node right) {
		Node node = new Node();
		node.data = data;
		node.left = left;
		node.right = right;
		return node;
	}
	
	// inorder함수를 생성
	public void inorder(Node node) {
		if(node != null) {
			// 왼쪽 출력
			inorder(node.left);
			// 자기 자신 출력
			System.out.println(node.data);
			// 오른쪽 출력
			inorder(node.right);
		}
	}
	
	// preorder 함수 생성
	public void preorder(Node node) {
		 if(node != null) {
			 // 자기 자신 출력
			 System.out.println(node.data);
			 // 왼쪽 출력
			 preorder(node.left);
			 // 오른쪽 출력
			 preorder(node.right);
		 }
	}
	
	// postorder 함수 생성
	public void postorder(Node node) {
		if(node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.println(node.data);
		}
	}
	
}
public class ClassBinaryTreeTraversal {

	public static void main(String[] args) {
		Tree t = new Tree();
		// 트리를 구성하고
		Node n4 = t.makeNode(null, 4, null);
		Node n5 = t.makeNode(null, 5, null);
		Node n2 = t.makeNode(n4, 2, n5);
		Node n3 = t.makeNode(null, 3, null);
		Node n1 = t.makeNode(n2, 1, n3);
		// n1의 값을 root로 지정한다
		t.setRoot(n1);
		//t.inorder(t.getRoot());
		//t.preorder(t.getRoot());
		t.postorder(t.getRoot());

	}

}

// Binary Tree Traversals의 종류에는 크게 3가지가 있다. 
// Inorder(Left, Root, Right), Preorder(Root, Left, Right), Postorder(Left, Right, Root)다. 
// Inorder는 왼쪽 선, 다음 루트, 다음 오른쪽
// Preorder는 루트 선, 다음 왼쪽, 다음 오른쪽
// Postorder는 왼쪽 선, 다음 오른쪽, 다음 루트

/* 
 * 			(1)
 * 		(2)		(3)
 * 	(4) 	(5)
 * Inorder : 42513
 * Preorder : 12453
 * Postorder : 45231
*/
