package codingLecture;

import java.util.NoSuchElementException;

public class ClassQueue {

	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.peek());
		System.out.println(q.remove());
		System.out.println(q.isEmpty());
		System.out.println(q.remove());
		System.out.println(q.isEmpty());

	}

}


class Queue<T> {
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


