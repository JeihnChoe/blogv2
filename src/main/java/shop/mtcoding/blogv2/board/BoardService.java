package shop.mtcoding.blogv2.board;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.blogv2.board.BoardRequest.업데이트DTO;
import shop.mtcoding.blogv2.user.User;
    
    /*  Service 가 해야하는 일
    * 1. 비지니스(핵심)로직 처리
    * 2. 트랜잭션 관리
    * 3. 예외처리
    * 4. DTO 변환   <-----------
    */
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

    public Board 상세보기(Integer id) {
        return boardRepository.findById(id).get();
    }

    public Board 업데이트조회(Integer id) {
        return boardRepository.findById(id).get();
    }

    @Transactional
    public void 삭제하기(Integer id) {
        boardRepository.deleteById(id);
    }

    @Transactional
    public void 업데이트(Integer id, 업데이트DTO 업데이트dto) {
        Optional<Board> boardOP = boardRepository.findById(id);
        if(boardOP.isPresent()){
            Board board = boardOP.get();
            board.setTitle(업데이트dto.getTitle()); 
            board.setContent(업데이트dto.getContent());            
        }
    }
}