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
//		if(this.hashTable[address] != null) { // ù��° ����. Ű�� ���� ������ �ּҸ� ���� ��������� ������� �ִ��� ������ (Slot��ü�� ����� ������ �ִٸ� ó���� �� null�� �� ���Դϴ�.)
//			
//			if(this.hashTable[address].key == key) { // �ι�° ����. Slot ��ü�� �ν��Ͻ��� hashTable�� key���� �����Ϸ��� Ű�� ���³� ���� �ʴ���
//				this.hashTable[address].value = value; // ���� Ű�� ������(David == David) �����͸� ���ڰ����� �ٲپ� ����
//				return true; // �޼ҵ� ���� true ����
//			}else {
//				int currAddress = address+1; //���� Ű���� ���� �ʴٸ� (�ּҰ��� ������ Ű���� �Ȱ��� ���) �ٸ����� �����ϱ� ���� �ּҿ� 1�� ���� ���¿��� ���� �ڵ带 ����
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
