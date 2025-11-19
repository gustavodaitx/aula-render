package br.com.ulbra.aula27.dto.posts.response;

public class PostUserDTO {
    private String name;

    public PostUserDTO(){}

    public PostUserDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}