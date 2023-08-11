package shop.mtcoding.blogv2.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import shop.mtcoding.blogv2.user.User;

@DataJpaTest // 모든 repository, EntityManager 이렇게만 뜸. 다른건 띄울필요가없다. 
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void save_test(){
        /* 1)
            // Jpa 에서 제공하는 인터페이스를 쓰면 CRUD를 만들지않아도된다
            // BoardRepository 에서 이미 인터페이스로 상속해놔서
            // CRUD는 가져다 쓰기만하면됨

                Board board= new Board(); // 담아줄 객체를 소환하고,
                
                board.setTitle("제목6");    //
                board.setContent("내용6");  // 내용을 담고
                
                boardRepository.save(board); 

            // Jpa의 상속된 인터페이스의 메소드 save()
            // DB에 알아서 인서트
            // 동기화까지 완료해줌
            // board 객체에 id가 없음 => insert가 자동으로 이루어짐 save가 되었으니 영속성객체 가 됨
            // 영속성객체가 되어 DB 에 작업이 이루어지고 난 다음에 알아서 자바와 동기화됨.
        */

        /* 2) 
            // Title이나 content는 단일 데이터타입이라 그냥 set 하면 들어감
            // 그러나 user_id 에 있는 User는 객체임.
            // 바로넣을수가없다
            // 그런데 생각해보면, 어차피 user_id 라는 FK 하나만 넣어주면된다.
            // 그래서 User 를 new 한다음에
            // user.setId(1) 로 유저의 아이디를 1로 바꿔준다음 (회원가입/로그인 페이지가 완성되면 세션을 대신 넣어주면 됨.)
            // user를 board 객체에 넣어준다.

                Board board= new Board();
                board.setTitle("제목6");
                board.setContent("내용6");
        
                User user = new User();
                user.setId(1);
                board.setUser(user);

                boardRepository.save(board); 
                
            //이러면 DB 에 작성자(userId) FK 까지 넣을수있다.
        */ 
            
            
        /* 3)
            근데 이것도 불편하다.
            그래서 builder 를 쓴다.

            모델(Board.java) 가서 생성자를 생성해주고 @Builder 를 달아줌.
            Builder 를 이용하여 코드를 최종 완성한다.
         */

        Board board = Board.builder()
                .title("제목6")
                .content("내용6")
                .user(User.builder().id(1).build())
                .build();
                        








        
    }
}