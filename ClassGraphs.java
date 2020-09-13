package codingLecture;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ClassGraphs {

	public static void main(String[] args) {
		

	}

}

class Graph {
	class Node {
		int data;
		// 인접한 데이터의 관계는 링크리스트로 표현
		LinkedList<Node> adjacent;
		// 방문 여부의 marked
		boolean marked;
		
		// 데이터를 파라로 받고
		public Node(int data) {
			super();
			// 데이터를 저장하고
			this.data = data;
			// 링크드리스트를 준비시킨다.
			this.adjacent = new LinkedList<Node>();
			// 마크를 false로 하고
			this.marked = false;
		}
	}
	// 노드들을 저장할 배열을 생성
	Node[] nodes;
	
	// 배열방 사이즈를 미리 정하고
	public Graph(int size) {
		// 노드를 생성한다
		nodes = new Node[size];
		// 편의를 위해 노드와 배열의 인덱스가 같도록 한다
		for (int i = 0; i < size; i++) {
			nodes[i] = new Node(i);
		}		
	}
	
	// 1. 두 노드의 관계를 저장하는 함수 생성
	public void addEdge(int i1, int i2) {
		// 받은 수가 인덱스와 같기에 받은 수로 인덱스를 사용한다.
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		
		// 연결된 노드가 있는지 확인하고 없다면 서로 추가한다.
		if(!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		} 
		
		if(!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		} 
	}
	
	public void dfs() {
		dfs(0);
	}
	
	// 2. dfs 순회 결과를 출력하는 함수(깊이 우선 탐색)
	public void dfs(int index) {
		// 해당 인덱스로 노드를 생성하고
		Node root = nodes[index];
		// 스택 하나를 선언한다.
		Stack2<Node> stack = new Stack2<Node>();
		// 현재 노드를 스택에 추가한다.
		stack.push(root); 
		// 스택에 들어갔다고 표시한다
		root.marked = true;
		// 스택에 데이터가 없을 때까지 작업을 반복
		while(!stack.isEmpty()) {
			// 데이터를 가져오고
			Node r = stack.pop();
			// 가져온 노드의 자식들을 스택에 추가한다
			for (Node n : r.adjacent) {
				// 이때 스택에 추가되지 않은 노드를만 추가한다
				if(n.marked == false) {
					n.marked = true;
					stack.push(n);
				}
			}
			// 방문할 때 출력해주는 함수를 만들어준다.
			visit(r);
		}
	}
	
	public void bfs() {
		// 너비 우선 탐색도 0번부터 시작
		bfs(0);
	}
	
	public void bfs(int index) {
		// 인덱스로 받은 인자로 노드를 생성한다.
		Node root = nodes[index];
		// 노드를 받는 큐 클래스를 생성한다
		Queue2<Node> queue = new Queue2<Node>();
		// 큐에 데이터를 추가한다.
		queue.add(root);
		// 추가한 사항을 마킹하고
		root.marked = true;
		// 큐에 데이터가 없어질때까지 반복하는 작업
		while(!queue.isEmpty()) {
			// 큐에서 데이터를 하나 가져오고
			Node r = queue.remove();
			// 자식노드들을 반복해서 넣어주는데
			for (Node n : r.adjacent) {
				// 큐에 들어가지 않은 경우에만
				if(n.marked == false) {
					// 들어갔다고 체크하고
					n.marked = true;
					// 큐에 데이터를 넣어준다
					queue.add(n);
				}
			}
			// 가져온애를 출력한다
			visit(r);
		}
	}
	// 다음 시간에
	// 재귀호출을 활용한 dfs함수 생성
	// 재귀호출을 할때는 LinkList가 노드의 주소를 가지고 있기에
	// 재귀함수는 노드를 받는 형태가 되어야 한다.
	public void dfsR(Node r) {
		
	}
	
	
	public void visit(Node n) {
		System.out.println(n.data + " "); 
	}
}




// #스택 클래스

class Stack2<T> {
	// 1. 기본 변수들과 생성자
	// 데이터 타입을 꼭 명시해주고
	class Node<t> {
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	private Node<T> top; // 스택은 맨위에 위치한 것만 알면 된다

	// 1. pop 제일 상단에 있는 top을 빼온다
	public T pop() {
		// 맨 위의 데이터가 없으면 익셉션 에러를 띄우고
		if(top == null) {
			throw new EmptyStackException();
		}
		
		T item = top.data;
		// 데이터를 백업하고
		top = top.next;
		// 다음에 있는 데이터를 탑으로 올린다
		return item;
	}
	
	// 2. push 입력할 데이터를 top에 위치시킨다 
	public void push(T item) {
		// T타입을 받는 새로운 노드를 생성
		Node<T> t = new Node<T>(item);
		// top 앞에 그 노드를 위치시키고
		t = top;
		// 그 노드를 탑으로 대입한다
		top = t;
	}
	
	// 3. top에 있는 데이터를 읽어온다(없애지X)
	public T peek() {
		if(top == null) {
			throw new EmptyStackException();
		}
		// 현재 탑이 가르키고 있는 데이터를 반환한다. 
		return top.data;
	}
	
	// 4.top이 비었는지 체크
	public boolean isEmpty() {
		return top == null;
	}
}
 

// #큐 클래스
class Queue2<T> {
	class Node<T> {
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}
	// 큐는 앞뒤로 주소를 알고 있어야 해서
	// 2개의 멤버변수를 선언한다
	private Node<T> first;
	private Node<T> last;
	
	public void add(T item) {
		// 추가할 t 타입의 아이템을 받아서
		Node<T> t = new Node<T>(item);
		// 아이템으로 노드를 하나 생성하고
		
		// 만약에 마지막 노드가 있다면
		if(last != null) {
			last = t;
			// 그 뒤에 새로 생성한 노드를 붙이고
		}
		last = t;
		// 마지막 노드는 이제 t가 된다
		
		// 만약에 첫번째 값이 널이면 
		if(first == null) {
			first = last;
			// 같은 값을 할당해준다. 
		}
	}
	
	public T remove() {
		// 첫 번째 노드가 널 값이면 에러를 띄우고
		if(first == null) {
			throw new NoSuchElementException();
		}
		
		// 데이터를 백업해준다.
		T data = first.data;
		// 첫 번째 다음 값을 first로 만들어준다.
		first = first.next;
		
		// 첫번째가 널일때 마지막도 널로 해줘야 한다는 걸 유의!
		if(first == null) {
			last = null;
		}
		
		return data;
	}
	
	public T peek() {
		// first가 널이면 에러를 띄우고
		if(first == null) {
			throw new NoSuchElementException();
		}
		// 아니면 first가 가르키는 값을 반환한다
		return first.data;
	}
	
	public boolean isEmpty() {
		// 비었는지 확인
		return first == null;
	}
}
	
