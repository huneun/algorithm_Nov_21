package hash;

public class MyHash3 {
	public Slot[] hashTable;
	
	public MyHash3(int size) {
		this.hashTable = new Slot[size];
	}

	/**
	 * ��ũ�� ����Ʈ ������� ���ο� ��������� �÷� �浹�� �����ϴ� ������ �ؽ����̺���� ��������
	 * ��ó�� �����ϰ� �Ǵ� ��������� ó������ key�� �´� �����Ͱ� �������� �ʾ� �ٸ� ��������� ã�� �����͸� �����ؾ� �Ѵٴ� ��찡 �ִٴ� ���̴�.
	 * �׷��� ������ ���� Ű�� �������� key�� �����͸� �Բ� ������ �����ϴ� ����� ���ؾ��ϴ� ���� �ٸ��� �ʴ�
	 * �׷��� Slot ��ü�� String key�� String value�� �״�� �ΰ� ��ũ�� ����Ʈ ����� ������ ��ȸ�� ���� pointer ������ next�� �������� 
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
