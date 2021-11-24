package hash;

public class MyHash2 {
	public Slot[] hashTable;
	
	public MyHash2(int size) {
		this.hashTable = new Slot[size];
	}

	public class Slot {
		String key;
		String value;
		Slot next; // 링크드 리스트의 검색을 가능하도록하는 pointer 역할의 변수
		Slot(String value, String key) {
			this.value = value;
			this.key = key;
			this.next = null;
		}
	}
	
	public int hashFunc(String key) {
		return (int)(key.charAt(0))%this.hashTable.length;
	}
	
	public boolean saveData(String key, String value) {
		Integer address = this.hashFunc(key);
		if(this.hashTable[address] != null) {
			//this.hashTable[address].value = value;
			Slot findSlot = this.hashTable[address];
			Slot prevSlot = this.hashTable[address];
			while(findSlot != null) {
				if(findSlot.key == key) {
					findSlot.value = value;
					return true;
				}else {
					prevSlot = findSlot;
					findSlot = findSlot.next;
				}
			}
			prevSlot.next = new Slot(value, key);
			
		}else {
			this.hashTable[address] = new Slot(value, key);
		}
		
		return true;
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
					findSlot = findSlot.next;
				}
			}
			return null;
		}else {
			return null;
		}
	}

}
