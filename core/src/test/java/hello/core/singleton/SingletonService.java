package hello.core.singleton;

// 테스트용 서비스
public class SingletonService {

    // 클래스 레벨에 올라가기 때문에, 하나만 존재.
    // static 영역에 객체를 1개만 생성해준다.
    private static final SingletonService instance = new SingletonService();

    // public으로 열어, 객체 인스턴스가 필요하다면 getInstance 메소드를 통해서만 조회하도록 허용한다.
    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자를 private로 선언해, 외부에서 new 키워드를 사용한 객체 생성을 막는다.
    private SingletonService() {}

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
