package shop.mtcoding.blogv2.user;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

@Import(UserQueryRepository.class)
@DataJpaTest  // JpaRepository 만 메모리에 올려줌
public class UserQueryRepositoryTest {

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    private EntityManager em;

    @Test
        public void save_test(){
        User user = User.builder()
            .username("love")
            .password("1234")
            .email("love@nate.com")
            .build();
        
    }
}
