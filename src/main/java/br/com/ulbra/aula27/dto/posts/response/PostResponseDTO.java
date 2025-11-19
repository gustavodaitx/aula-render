package br.com.ulbra.aula27.dto.posts.response;

public class PostResponseDTO {
    private String content;
    private PostUserDTO user;

    public PostResponseDTO() {}

    public PostResponseDTO(String content, PostUserDTO user) {
        this.content = content;
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PostUserDTO getUser() {
        return user;
    }

    public void setUser(PostUserDTO user) {
        this.user = user;
    }
}