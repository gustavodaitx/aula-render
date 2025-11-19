package br.com.ulbra.aula27.services;

import br.com.ulbra.aula27.dto.posts.request.PostRequest;
import br.com.ulbra.aula27.dto.posts.response.PostResponseDTO;
import br.com.ulbra.aula27.dto.posts.response.PostUserDTO;
import br.com.ulbra.aula27.entities.Post;
import br.com.ulbra.aula27.entities.User;
import br.com.ulbra.aula27.repositories.PostRepository;
import br.com.ulbra.aula27.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<PostResponseDTO> getAllPosts() {
        return this.postRepository.findAll()
                .stream()
                .map(item ->
                        new PostResponseDTO(
                                item.getContent(),
                                new PostUserDTO(item.getUser().getName())
                        )).toList();
    }

    public Post createPost(PostRequest postRequest) {
        User user = userRepository.findById(postRequest.getUserId()).orElseThrow();

        Post post = new Post();
        post.setContent(postRequest.getContent());
        post.setUser(user);


        return postRepository.save(post);
    }
}