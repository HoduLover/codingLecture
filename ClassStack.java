package codingLecture;

import java.util.EmptyStackException;

public class ClassStack {

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
		
	}

}

class Stack<T> {
	// 1. 기본 변수들과 생성자
	// 데이터 타입을 꼭 명시해주고
	private Node<T> top; // 스택은 맨위에 위치한 것만 알면 된다
	
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
		Node<T> t = new Node<T>(item);
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
 

class Node<T> { // 같은 타입을 받는 노드를 생성한다.
	private T data; // 데이터를 선언하고
	private Node<T> next; // 다음 노드도 선언합니다
	
	public Node(T data) { 
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

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
	
}


