package shop.mtcoding.blogv2;
class MyController {
    MyService myService = new MyService();
    void home(boolean check) throws Exception {
        myService.홈가기(check);
    }
}
class MyService {
    MyRepository myRepository = new MyRepository();
    void 홈가기(boolean check) throws Exception {
        myRepository.findHome(check);
    }
}
class MyRepository {
    void findHome(boolean check) throws Exception {
        if (check) {
            System.out.println("조회 완료");
        } else {
            throw new Exception("조회 오류");
        }
    }
}
public class HelloTest {
    public static void main(String[] args) throws Exception {
        MyController myController = new MyController();
        myController.home(true);
    }
}