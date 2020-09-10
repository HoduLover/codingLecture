package codingLecture;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class ClassGraphs {

	public static void main(String[] args) {
		

	}

}

class Graph {
	// 노드들을 저장할 배열을 생성
	Node5[] nodes;
	
	// 배열방 사이즈를 미리 정하고
	public Graph(int size) {
		// 노드를 생성한다
		nodes = new Node5[size];
		// 편의를 위해 노드와 배열의 인덱스가 같도록 한다
		for (int i = 0; i < size; i++) {
			nodes[i] = new Node5(i);
		}		
	}
	
	// 1. 두 노드의 관계를 저장하는 함수 생성
	public void addEdge(int i1, int i2) {
		// 받은 수가 인덱스와 같기에 받은 수로 인덱스를 사용한다.
		Node5 n1 = nodes[i1];
		Node5 n2 = nodes[i2];
		
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
		Node5 root = nodes[index];
		// 스택 하나를 선언한다.
		Stack2<Node5> stack = new Stack2<Node5>();
		// 현재 노드를 스택에 추가한다.
		stack.push(root); 
		// 스택에 들어갔다고 표시한다
		root.marked = true;
		// 스택에 데이터가 없을 때까지 작업을 반복
		while(!stack.isEmpty()) {
			// 데이터를 가져오고
			Node5 r = stack.pop();
			// 가져온 노드의 자식들을 스택에 추가한다
			for (Node5 n : r.adjacent) {
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
		Node5 root = nodes[index];
		// 노드를 받는 큐 클래스를 생성한다
		Queue2<Node5> queue = new Queue2<Node5>();
		// 큐에 데이터를 추가한다.
		queue.add(root);
		// 추가한 사항을 마킹하고
		root.marked = true;
		// 큐에 데이터가 없어질때까지 반복하는 작업
		while(!queue.isEmpty()) {
			// 큐에서 데이터를 하나 가져오고
			Node5 r = queue.remove();
			// 자식노드들을 반복해서 넣어주는데
			for (Node5 n : r.adjacent) {
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
	public void dfsR(Node5 r) {
		
	}
	
	
	public void visit(Node5 n) {
		System.out.println(n.data + " "); 
	}
}

class Node5 {
	int data;
	// 인접한 데이터의 관계는 링크리스트로 표현
	LinkedList<Node5> adjacent;
	// 방문 여부의 marked
	boolean marked;
	
	// 데이터를 파라로 받고
	public Node5(int data) {
		super();
		// 데이터를 저장하고
		this.data = data;
		// 링크드리스트를 준비시킨다.
		this.adjacent = new LinkedList<Node5>();
		// 마크를 false로 하고
		this.marked = false;
	}
}


// #스택 클래스

class Stack2<T> {
	// 1. 기본 변수들과 생성자
	// 데이터 타입을 꼭 명시해주고
	private Node6<T> top; // 스택은 맨위에 위치한 것만 알면 된다
	
	// 1. pop 제일 상단에 있는 top을 빼온다
	public T pop() {
		// 맨 위의 데이터가 없으면 익셉션 에러를 띄우고
		if(top == null) {
			throw new EmptyStackException();
		}
		
		T item = top.getData(); 
		// 데이터를 백업하고
		top = top.getNext();
		// 다음에 있는 데이터를 탑으로 올린다
		return item;
	}
	
	// 2. push 입력할 데이터를 top에 위치시킨다 
	public void push(T item) {
		// T타입을 받는 새로운 노드를 생성
		Node6<T> t = new Node6<T>(item);
		// top 앞에 그 노드를 위치시키고
		t.setNext(top);
		// 그 노드를 탑으로 대입한다
		top = t;
	}
	
	// 3. top에 있는 데이터를 읽어온다(없애지X)
	public T peek() {
		if(top == null) {
			throw new EmptyStackException();
		}
		// 현재 탑이 가르키고 있는 데이터를 반환한다. 
		return top.getData();
	}
	
	// 4.top이 비었는지 체크
	public boolean isEmpty() {
		return top == null;
	}
}
 

class Node6<T> { // 같은 타입을 받는 노드를 생성한다.
	private T data; // 데이터를 선언하고
	private Node6<T> next; // 다음 노드도 선언합니다
	
	public Node6(T data) { 
		// 생성자에서 해당 타입의 데이터를 하나 받아서
		this.data = data;
		// 내부 변수에 저장합니다. 
	}

	// 데이터와 넥스트 변수의 게터와 세터 생성
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node6<T> getNext() {
		return next;
	}

	public void setNext(Node6<T> next) {
		this.next = next;
	}
	
}

// #큐 클래스


class Queue2<T> {
	// 큐는 앞뒤로 주소를 알고 있어야 해서
	// 2개의 멤버변수를 선언한다
	private Node4<T> first;
	private Node4<T> last;
	
	public void add(T item) {
		// 추가할 t 타입의 아이템을 받아서
		Node4<T> t = new Node4<T>(item);
		// 아이템으로 노드를 하나 생성하고
		
		// 만약에 마지막 노드가 있다면
		if(last != null) {
			last.setNext(t);
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
		T data = first.getData();
		// 첫 번째 다음 값을 first로 만들어준다.
		first = first.getNext();
		
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
		return first.getData();
	}
	
	public boolean isEmpty() {
		// 비었는지 확인
		return first == null;
	}
}

class Node4<T> {
	private T data;
	private Node4<T> next;
	
	
	//생성자로 데이터를 받아서 내부 변수에 저장한다
	public Node4(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node4<T> getNext() {
		return next;
	}

	public void setNext(Node4<T> next) {
		this.next = next;
	}
}
	
