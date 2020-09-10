package codingLecture;

import java.util.LinkedList;

public class ClassHashTable {

	public static void main(String[] args) {
		HashTable h = new HashTable(3);
		// 해쉬테이블이 3으로 고정된 배열방을 생성한다. 
		h.put("sung", "she is pretty");
		h.put("jin", "she is a model");
		h.put("hee", "she is an angel");
		h.put("min", "she is cute");
		System.out.println(h.get("sung"));
		System.out.println(h.get("jin"));
		System.out.println(h.get("hee"));
		System.out.println(h.get("min"));
		System.out.println(h.get("jae"));
		
		h.put("sung", "she is beautiful");
		System.out.println(h.get("sung"));

	}

}

class HashTable {
	// 데이터를 저장할 링크드리스트를 선언한다
	LinkedList<Node3>[] data;

	// 배열 방도 미리 만들어 놓는다
	HashTable(int size) {
		this.data = new LinkedList[size];
	}

	// 1. 해쉬 알고리즘에서 가장 중요한 메서드로
	// 키 값을 받아서 해쉬코드를 반환한다.
	public int getHashCode(String key) {
		int hashcode = 0;
		// 입력받은 키에서 아스키값을 가져와서 해시 코드에 넣는다
		for (char c : key.toCharArray()) {
			hashcode += c;
		}
		return hashcode;

	}

	// 2. 해쉬코드를 받아서 배열 방의 인덱스로 변환할 메서드
	public int convertToIndex(int hashcode) {
		return hashcode % data.length;
	}

	// 3. 키를 이용해 배열 방에서 노드를 통해 해당 데이터를 가져오기 위한 메서드
	public Node3 searchKey(LinkedList<Node3> list, String key) {
		// 노드가 널이면 널을 반환하고
		if (list == null) {
			return null;
		}

		// 배열 방에 있는 링크드리스트가 돌면서
		// 노드의 키가 검색하는 키와 같은지를 확인한다
		// 같으면 노드 값을 반환한다.
		for (Node3 node3 : list) {
			if (node3.getKey().equals(key)) {
				return node3;
			}
		}
		// 같은 게 없으면 null을 반환
		return null;
	}

	// 4. 데이터를 방아서 저장하는 메서드
	public void put(String key, String value) {
		// key를 이용해서 해쉬코드 생성
		int hashcode = getHashCode(key);
		// 해쉬코드를 이용해서 배열방 인덱스 생성
		int index = convertToIndex(hashcode);
		// 배열 방에 있는 데이터를 가져와서 링크드리스트에 넣는다
		
		System.out.println(key + ", hashcode(" + hashcode + "), index(" + index + ")");
		LinkedList<Node3> list = data[index];
		
		// 배열방이 없으면
		if (list == null) {
			// 링크드리스트를 생성한다
			list = new LinkedList<Node3>();
			// 해당 리스트를 배열방에 넣어준다
			data[index] = list;
		}
		// 배열 방에 혹시 기존의 해당 키로 데이터를 가졌는지 노드를 받아온다
		Node3 node3 = searchKey(list, key);
		// 데이터가 없으면
		if(node3 == null) {
			// 노드 객체를 생성해서 리스트에 추가한다
			list.addLast(new Node3(key, value));
		} else {
			// 노드가 널이 아닌 경우에는 해당 노드의 값이 대체해주는 걸로 
			// 중복키를 처리한다. 
			node3.setValue(value);
		}
	}
	
	// 5. 키를 가지고 데이터 값을 가져오는 메서드
	public String get(String key) {
		// key를 이용해서 해쉬코드 생성
		int hashcode = getHashCode(key);
		// 해쉬코드를 이용해서 배열방 인덱스 생성
		int index = convertToIndex(hashcode);
		// 배열 방에 있는 데이터를 가져와서 링크드리스트에 넣는다
		LinkedList<Node3> list = data[index];
		// 배열 방에 혹시 기존의 해당 키로 데이터를 가졌는지 노드를 받아온다
		Node3 node3 = searchKey(list, key);
		
		// 값이 없으면 없다는 문자열을 표시, 아니면 값을 반환한다
		return node3 == null ? "Not found" : node3.getValue();
		
	}
}

class Node3 {
	String key;
	String value;

	public Node3(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}