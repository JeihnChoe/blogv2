package shop.mtcoding.blogv2.board;

import lombok.Getter;
import lombok.Setter;

//내부클래스로 요청DTO (Request DTO)를 관리
public class BoardRequest {
    
    @Getter
    @Setter
    public static class SaveDTO {
        private String title;
        private String content;
    }
    

    @Getter
    @Setter
    public static class 업데이트조회DTO{
        private String title;
        private String content;
        
        public 업데이트조회DTO(String title, String content) {
            this.title = title;
            this.content = content;
        }
    }

    @Getter
    @Setter
    public static class 업데이트DTO{
            private String title;
            private String content;
        }
}
