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
	 * �ؽ� ���̺� Ŭ������ ������ ���� �޼��� �߰�
	 * ��ü �迭 �����, �� �迭�� �������� �� ��ü�� ������ �� �ִ� �ּҸ� ���� �� �ִ� ������ �Ҵ�
	 * �� ������ ������ ������ �� ��ü�� ��������� ��
	 * ��, ��ü �迭 �����, �� ������ ��ü�� ����ų �ּҸ� ������ ������ �迭�� ����� ����
	 * �ʱ�ȭ�� ���� ���� ����� �Ҵ�� �迭�� �ǹ� Slot[] hashTable = new Slot[20];
	 * 
	 * �׷� hashTable[0] = new Slot("test"); �̷��� �ʱ�ȭ���� �ϸ�? �ּҰ��� ������ �� ���¸� �ǹ�! �ּҰ����� �������� "test"�� ã�� �� ����
	 * */
	
	//�����ϰ� ������ �����߳� ���߳Ŀ� ���� ���� ���� �޴� �޼ҵ�
	
	public boolean saveData(String key, String value) {
		Integer address = this.hashFunc(key);
		if(this.hashTable[address] != null) {
			this.hashTable[address].value = value;
		}else {
			this.hashTable[address] = new Slot(value);
		}
		
		return true;
	}
	
	//Ư�� Ű�� ���� �����͸� �̾ƿ��� �޼ҵ�
	public String getData(String key) {
		int address = (int)(key.charAt(0))%this.hashTable.length;
		if(this.hashTable[address] != null) {
			return this.hashTable[address].value;
		}else {
			return null;
		}
	}

}
