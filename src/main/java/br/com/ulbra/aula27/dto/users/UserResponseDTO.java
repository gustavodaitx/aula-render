package br.com.ulbra.aula27.dto.users;

import java.util.ArrayList;
import java.util.List;

public class UserResponseDTO {
    private String name;
    private String email;
    private List<UserPostDTO> posts = new ArrayList<>();

    public UserResponseDTO(String name, String email, List<UserPostDTO> posts) {
        this.name = name;
        this.email = email;
        this.posts = posts;
    }

    public List<UserPostDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<UserPostDTO> posts) {
        this.posts = posts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}