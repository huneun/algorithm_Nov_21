package hash;

public class NotTwice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 해쉬 테이블은 간단히 말하면 키에 데이터를 매핑 할 수 있는 테이터 구조다
		 * 전화번호를 저장하려면 이름이 있고 전화번호가 있을 것이다. 이름-전화번호가 key-value(데이터) 가 된다.
		 * 이름을 알면 전화번호를 빠르게 검색할 수 있는 구조가 있을까? 하여 나타난 것이 해쉬테이블 자료구조 이다.
		 * hashFunction에 key를 넣으면 이 키에 해당하는 데이터를 저장할 수 있는 주소를 리턴해준다. 이 주소에 해당하는 데이터를 저장한다.
		 * 실제로 hashFunction의 정의는 임의의 데이터를 고정된 길이의 값으로 리턴해주는 함수이다.
		 * 요즘 블록체인도 그러하다. 거래된 기록들을 특별한 암호화 해쉬펑션에 넣어 항상 일정한 256자의 데이터로 만들어준다. 이 기록들의 크기가 1테라바이트이든 1바이트이든 상관없이
		 * 이러한 개념의 해쉬펑션을 구성하여 해쉬테이블의 구조를 이해하는것이 학습 목표이다.
		 * 쉬운 예를 들어 시작해보자
		 * 데이터인 전화번호를 배열에 넣는다고 생각해보자. 각각의 키와 데이터가 각 인덱스 별로 넣어 있다면 0번의 인덱스 부터 사이즈 끝까지 찾는 값이 나올때까지 같은 기능을 반복할 것이다.
		 * 해쉬 펑션이 있다면 key만 알고 있어도 그 키가 가지고 있는 주소값에 의해 원하는 데이터를 조회 할수 있게된다.
		 * 이러한 원리로 저장 및 탐색 속도가 획기적으로 빨라진다.
		 * 해쉬 테이블은 해쉬 펑션이 리턴할 수 있는 주소 값들을 저장하기 위해 미리 공간을 확보한다. 보통 배열로 확보를 해 놓는다.
		 * 각각의 key-value 한쌍이 저장되는 공간을 Slot 이라고 한다. 이 Slot의 집합을 해쉬 테이블이라고 하는 것이다.
		 * 해쉬 펑션 메소드의 리턴 값을 해쉬 주소, 해쉬 값, 해쉬 라고도 부른다.
		 * 
		 * */
		
		MyHash mainOj = new MyHash(20);
		
		mainOj.saveData("DaveLee", "01022223333");
		mainOj.saveData("fun-coding", "01033334444");
		String value = mainOj.getData("DaveLee");

		System.out.println("value : "+value);
		
		/**
		 * 자료구조 해쉬 테이블의 장단점과 주요 용도
		 * 장점1. 데이터 저장/읽기 속도가 빠르다. 검색속도가 획기적으로 빠르다. (= 해당 데이터가 중복되는지 확인이 쉬움)
		 *   저장이라하는 것은 해당 데이터가 있는지 여부를 검색한뒤 실행해야 하는 것이기에 링크드 리스트같은 경우 이점에 불리한 구조를 가지고 있다.
		 *   
		 * 단점2. 일반적으로 저장공간이 좀더 많이 필요하다. 여러키에 해당하는 주소가 동일할 경우 충돌(Collision)을 해결하기 위한 별도의 자료구조가 필요함
		 *   key 값의 첫번째 character 값을 아스키코드값으로 변환하여 해쉬테이블 사이즈로 나눈 나머지 값을 이용해 데이터를 저장하는 경우의 선행 코드를 봐도 확인할 수 있다. Key 값이 "David" 이든, "Dog"이든 같은 인텍스 값을 갖게 되고 그 결과 먼저 저장되어 있던 데이터는 찾을 수 없이 붕뜨게 되어 버리는 것!
		 * 
		 * */
		
		
		/**
		 * 해쉬테이블 구조의 충돌을 방지하는 별도의 알고리즘 중 첫번째,
		 * Chaning 기법 충돌이 되는 해당 데이터 저장 공간에 이어 링크드 리스트로 추가 공간을 할당하는 방식
		 * 그렇담 링크드 리스트의 알고리즘을 차용하고 데이터의 짝이되는 key가 무엇인지 구분하기 위해 데이터 저장공간에 키도 함께 저장될 수 있도록 하자
		 * 
		 * */
		
		MyHash2 mainOj2 = new MyHash2(20);
		
		mainOj2.saveData("DaveLee", "01022223333");
		mainOj2.saveData("fun-coding", "01033334444");
		mainOj2.saveData("David", "01044445555");
		mainOj2.saveData("Dave", "01055556666");
		String value2 = mainOj2.getData("David");

		System.out.println("value2 : "+value2);
		
	}

}
