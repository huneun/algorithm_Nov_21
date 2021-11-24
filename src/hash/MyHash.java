package hash;

public class MyHash {
	public Slot[] hashTable;
	
	public MyHash(int size) {
		this.hashTable = new Slot[size];
	}

	public class Slot {
		String value;
		Slot(String value) {
			this.value = value;
		}
	}
	
	public int hashFunc(String key) {
		return (int)(key.charAt(0))%this.hashTable.length;
	}
	
	/**
	 * 해쉬 테이블 클래스에 데이터 저장 메서드 추가
	 * 객체 배열 선언시, 각 배열의 아이템은 각 객체를 참조할 수 있는 주소를 담을 수 있는 공간만 할당
	 * 각 아이템 생성시 별도로 각 객체를 생성해줘야 함
	 * 즉, 객체 배열 선언시, 각 생성할 객체를 가리킬 주소만 저장할 공간을 배열로 만드는 것임
	 * 초기화를 하지 않은 사이즈만 할당된 배열을 의미 Slot[] hashTable = new Slot[20];
	 * 
	 * 그럼 hashTable[0] = new Slot("test"); 이렇게 초기화까지 하면? 주소값이 설정이 된 상태를 의미! 주소값으로 데이터인 "test"를 찾을 수 있음
	 * */
	
	//저장하고 저장을 성공했냐 안했냐에 대한 리턴 값을 받는 메소드
	
	public boolean saveData(String key, String value) {
		Integer address = this.hashFunc(key);
		if(this.hashTable[address] != null) {
			this.hashTable[address].value = value;
		}else {
			this.hashTable[address] = new Slot(value);
		}
		
		return true;
	}
	
	//특정 키에 대한 데이터를 뽑아오는 메소드
	public String getData(String key) {
		int address = (int)(key.charAt(0))%this.hashTable.length;
		if(this.hashTable[address] != null) {
			return this.hashTable[address].value;
		}else {
			return null;
		}
	}

}
