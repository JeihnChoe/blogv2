package shop.mtcoding.blogv2.board;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.blogv2.user.User;
@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    // 1. 데이터 받기
    // 2. 인증체크
    // 3. 유효성 검사
    // 4. 핵심로직 호출(서비스)
    // 5. view or data 응답
    
    @Transactional
    public void 글쓰기(BoardRequest.SaveDTO saveDTO, int sessionUserId) {
        Board board = Board.builder()
                .title(saveDTO.getTitle())
                .content(saveDTO.getContent())
                .user(User.builder().id(sessionUserId).build())
                .build();
        boardRepository.save(board);
    }

    // public Page<Board> 게시글목록보기(Integer page) {
    //     Pageable pageable = PageRequest.of(page, 3, Sort.Direction.DESC, "id");
    //     return boardRepository.findAll(pageable);
    // }
    public Page<Board> 게시글목록보기(Integer page){
            Pageable pageable = PageRequest.of(page, 3, Sort.Direction.DESC, "id");
            return boardRepository.findAll(pageable);
    }
}