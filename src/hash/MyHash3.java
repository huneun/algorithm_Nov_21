package hash;

public class MyHash3 {
	public Slot[] hashTable;
	
	public MyHash3(int size) {
		this.hashTable = new Slot[size];
	}

	/**
	 * 링크드 리스트 방식으로 새로운 저장공간을 늘려 충돌을 방지하는 개방형 해쉬테이블과의 공통점은
	 * 맨처음 접근하게 되는 저장공간에 처음부터 key에 맞는 데이터가 존재하지 않아 다른 저장공간을 찾아 데이터를 저장해야 한다는 경우가 있다는 점이다.
	 * 그렇기 때문에 같은 키를 가질지라도 key와 데이터를 함께 저장해 구분하는 방식을 취해야하는 것은 다르지 않다
	 * 그래서 Slot 객체의 String key와 String value는 그대로 두고 링크드 리스트 방식의 순차적 조회를 위한 pointer 역할의 next는 삭제하자 
	 * */
	public class Slot {
		String key;
		String value;
		Slot(String value, String key) {
			this.value = value;
			this.key = key;
		}
	}
	
	public int hashFunc(String key) {
		return (int)(key.charAt(0))%this.hashTable.length;
	}
	
	public boolean saveData(String key, String value) {
		int address = hashFunc(key);
		if(this.hashTable[address] != null) {
			if(this.hashTable[address].key == key) {
				this.hashTable[address].value = value;
				return true;
			}else {
				int currAddress = address +1;
				while(this.hashTable[currAddress] != null) {
					if(this.hashTable[currAddress].key == key) {
						this.hashTable[currAddress].value = value;
						return true;
					}else {
						currAddress++;
						if(currAddress >= this.hashTable.length) {
							return false;
						}
					}
				}
				this.hashTable[currAddress] = new Slot(key, value);
				return true;
			}
		}else {
			this.hashTable[address] = new Slot(key, value);
		}
		return true;
	}
	
//	public boolean saveData(String key, String value) { 
//		int address = this.hashFunc(key);
//		
//		if(this.hashTable[address] != null) { // 첫번째 조건. 키에 따라 정해진 주소를 가진 저장공간이 만들어져 있느냐 없느냐 (Slot객체가 사이즈만 정해져 있다면 처음은 다 null이 될 것입니다.)
//			
//			if(this.hashTable[address].key == key) { // 두번째 조건. Slot 객체의 인스턴스인 hashTable의 key값이 저장하려는 키와 같는냐 같지 않느냐
//				this.hashTable[address].value = value; // 만일 키가 같으면(David == David) 데이터를 인자값으로 바꾸어 저장
//				return true; // 메소드 실행 true 리턴
//			}else {
//				int currAddress = address+1; //만일 키값이 같지 않다면 (주소값은 같은데 키값은 안같은 경우) 다른곳에 저장하기 위해 주소에 1을 더한 상태에서 다음 코드를 실행
//				while(this.hashTable[currAddress] != null) {
//					if(this.hashTable[currAddress].key == key) {
//						this.hashTable[currAddress].value = value;
//						return true;
//					}else {
//						currAddress++;
//						if(currAddress >= this.hashTable.length) {
//							return false;
//						}
//					}
//				}
//				this.hashTable[currAddress] = new Slot(value, key);
//				return true;
//			}
//			
//		}else {
//			this.hashTable[address] = new Slot(value, key);
//		}
//		
//		return true;
//	}
//	
	public String getData(String key) {
		int address = hashFunc(key);
		if(this.hashTable[address] != null) {
			if(this.hashTable[address].key == key) {
				return this.hashTable[address].value;
			}else {
				int currAddress = address +1;
				while(this.hashTable[currAddress] != null) {
					if(this.hashTable[currAddress].key == key) {
						return this.hashTable[currAddress].value;
					}else {
						currAddress++;
						if(currAddress >= this.hashTable.length) {
							return null;
						}
					}
				}
				return null;
			}
		}else {
			return null;
		}
	}

}
