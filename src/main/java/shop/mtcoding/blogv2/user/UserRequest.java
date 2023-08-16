package shop.mtcoding.blogv2.user;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class UserRequest {
    
    @Getter
    @Setter
    @Builder
    public static class JoinDTO{

        private String username;
        private String password;
        private String email;
    }

    @Getter
    @Setter
    @Builder
    public static class LoginDTO{

        private String username;
        private String password;
    }
    @Getter
    @Setter
    @Builder
    public static class UpdateDTO{
        
        private String password;
    }
}
