package br.com.ulbra.aula27.services;

import br.com.ulbra.aula27.dto.users.UserPostDTO;
import br.com.ulbra.aula27.dto.users.UserResponseDTO;
import br.com.ulbra.aula27.entities.User;
import br.com.ulbra.aula27.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static java.util.stream.Collectors.toList;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(Long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Usuário com ID " + id + " não encontrado"
                ));
    }

    public Page<UserResponseDTO> getUsers(Pageable pageable) {
        return this.userRepository.findAll(pageable)
                .map(item -> new UserResponseDTO(
                        item.getName(),
                        item.getEmail(),
                        item.getPosts().stream().map(
                                posts -> new UserPostDTO(posts.getContent())
                        ).toList()
                ));
    }

    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Usuário com ID " + id + " não encontrado"
                ));

        this.userRepository.delete(user);
    }

}