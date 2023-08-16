package shop.mtcoding.blogv2.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// @Repository
// public class BoardRepository {
//     public save(){ }
//     public findById(){ }
//     public findAll(){ }
//     public count(){ }
//     public deleteById(){ }
// }  <----- 이렇게 써도 됨. 근데 JPA에서 제공하는데 CRUD 만드는데 시간쓰지말것

/* 
 * save(), findById(), findAll(), count(), deleteById()
 */

public interface BoardRepository extends JpaRepository<Board, Integer> {
                    // 상속받기 위해서 Entity, PK값의 타입형을 써준다.

        
    @Query("select b from Board b join b.user")
    // == select id, title, content, user_id, created_at from board_tb b inner join user_tb u on b.user_id = u.id;
    // 위는 ORM 으로 연결해준거, 밑은 그냥 무식하게 다적은거.
    List<Board> mFindAll();
    
}
