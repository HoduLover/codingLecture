package codingLecture;

class Node7 {
	// 보통 노드 안에 객체를 갖는다
	int data;
	// 다음 노드를 가져야해서 노드를 next라는 이름으로 초기화한다.
	Node7 next = null;
	
	public Node7(int data) {
		super();
		this.data = data;
	}
	
	// 일단 헤더값은 변경하지 않는다는 전제하에 만든 메서드다. 
	public void append(int data) {
		Node7 end = new Node7(data);
		Node7 n= this;
		
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
		Node7 n = this;
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
		Node7 n = this;
		while(n.next != null) {
			System.out.print(n.data + "->");
			n = n.next;
		}
		// 마지막 데이터 출력
		System.out.println(n.data);
	}
	
}
public class ClassLinkedList {

	public static void main(String[] args) {
		Node7 head = new Node7(1);
		head.append(2);
		head.append(3);
		head.append(4);
		head.retrieve();
		head.delete(2);
		head.retrieve();
	}

}

//1.Linked List의 개념
//일렬로 저장된 데이터를 저장할 떄 쓴다. 
//앞의 데이터가 다음 데이터의 주소를 가진다
//배열은 물리적으로 자리가 정해져 있다. 
//배열과 달리 중간에 값을 삽입하면
//새로들어온 값이 다음 값을 가르키고
//앞의 노드가 자신을 향하도록한다

//만약에 삭제를 하게 되면 그 값을 참고하는 노드가 지워지고
//노드는 삭제된 값이 가르키던 값의 주소를 다시 가리키게 된다
//삭제된 데이터가 다음값을 가르키는 건 상관없으며
//어차피 그 데이터를 참조하지 않기에 데이터는 제거된것처럼 된다
//자바에서는 가비지컬렉터가 알아서 처리한다

//2.Linked List의 단방향/양방향 개념
// Linked List는 한방향의 노드만 가지고 있을 떄가 있다. 
// 이런 것을 단방향 링크드리스트라고 한다. 
// 그와 달리, 양방향 링크드리스트는 앞에 있는 노드를 가르킬 때가 있다. 
// 그래서 값을  삭제를 할때 
// 뒤에서 자신을 가르키던 노드를 자신이 가리키던 다음 주소로
// 앞에서 자신을 가르키던 노드를 자신을 가르키던 전 주소로 옮겨준다

