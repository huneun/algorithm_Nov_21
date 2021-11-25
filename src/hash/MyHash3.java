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
		int address = this.hashFunc(key);
		if(this.hashTable[address] != null) {
			
			if(this.hashTable[address].key == key) {
				this.hashTable[address].value = value;
				return true;
			}else {
				int currAddress = address+1;
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
				this.hashTable[currAddress] = new Slot(value, key);
				return true;
			}
			
		}else {
			this.hashTable[address] = new Slot(value, key);
		}
		
		return true;
	}
	
	public void gitAddAll() {
		
	}
	public String getData(String key) {
		int address = (int)(key.charAt(0))%this.hashTable.length;
		if(this.hashTable[address] != null) {
			//return this.hashTable[address].value;
			
			Slot findSlot = this.hashTable[address];
			while(findSlot != null) {
				if(findSlot.key == key) {
					return findSlot.value;
				}else {
					//findSlot = findSlot.next;
				}
			}
			return null;
		}else {
			return null;
		}
	}

}
