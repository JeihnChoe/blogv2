package shop.mtcoding.blogv2.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {
    
    @Autowired
    private UserRepository userRepository;

    @Test
    public void save_test(){
        // User user = user.builder()
        //         .username("love")
        //         .password("1234")
        //         .email("love@nate.com")
        //         .build();
        // userRepository.save(user);

        User user = User.builder().username("love").password("1234").email("love@nate.com").build();
        userRepository.save(user);
    }

    @Test
    public void update_test(){
        User user = userRepository.findById(1).get();
        
        /* 1) 
            user.builder().password("5678").build();  
         */  // 이렇게하면 password 업데이트되고 나머지 값들은 모두 null 이 된다.

        user.setPassword("5678"); // 어떤값을 넣을지는 받아와야함.
        userRepository.save(user);
    }
}
