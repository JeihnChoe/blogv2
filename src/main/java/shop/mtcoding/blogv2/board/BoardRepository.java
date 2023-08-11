package shop.mtcoding.blogv2.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository
// public class BoardRepository {
//     public save(){ }
//     public findById(){ }
//     public findAll(){ }
//     public count(){ }
//     public deleteById(){ }
// }

/* 
 * save(), findById(), findAll(), count(), deleteById()
 */

public interface BoardRepository extends JpaRepository<Board, Integer> {
                    // 상속받기 위해서 모델, PK값의 타입형을 써준다.
    
}
