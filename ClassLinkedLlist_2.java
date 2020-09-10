package codingLecture;

// ClassLinkedList에서 header값을 조정하지 못한
// 구현을 개선한 것으로
// LinkedList 안에 Node를 넣어서 첫 번째 값을
// 조정한다
class LinkedList {
	Node header;
	
	public static class Node {
		int data;
		Node next = null;
		
		public Node(int data) {
			super();
			this.data = data;
		}
		
		public Node() {
			
		}
	}
	
	LinkedList() {
		header = new Node();
	}
	
	// 일단 헤더값은 변경하지 않는다는 전제하에 만든 메서드다. 
	public void append(int data) {
		Node end = new Node(data);
		// 헤더로 변경
		Node n= header;
		
		while(n.next != null) {
			n = n.next;
			// 다음 노드로 이동한다.
		}
		n.next = end;
		// 마지막 노드에 마지막 노드를 입력하면
		// 입력값이 마지막이 된다. 
	}
	
	// 데이터를 삭제하는 함수
	public void delete(int data) {
		// 헤더를 시작점으로 삭제 시작
		Node n = header;
		// while문으로 마지막 노드까지 돌리는데
		while(n.next != null) {
			// 마지막 노드까지 가지 않기에 일단
			// 전에서 다음 데이터 값을 먼저 확인 하여 if문 판단
			if(n.next.data == data) {
				// 노드를 그 다음의 값으로 바꿔주고
				n.next = n.next.next;
			} else {
				// 아니면 원래처럼 다음 노드로 이동한다.
				n = n.next;
			}
		}
	}
	
	// 결과 값을 보여주는 함수
	public void retrieve() {
		// 헤더 다음 데이터를 n에 할당해서
		// n부터 출력되도록 한다
		Node n = header.next;
		while(n.next != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		// 마지막 데이터 출력
		System.out.println(n.data);
	}
}
public class ClassLinkedLlist_2 {

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.retrieve();
		ll.delete(1);
		ll.retrieve();

	}

}
