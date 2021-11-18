package hello.core.singleton;

public class SingletonService {

	//class 레벨에 올라가기때문에 딱 하나만 올라간다! static, final
	private static final SingletonService instance = new SingletonService();

	public static SingletonService getInstance(){
		return instance;
	}

	private SingletonService() {
	}

	public void logic() {
		System.out.println("싱글톤 객체 로직 호출");
	}
}
