package dio.aula;

import dio.aula.model.User;
import dio.aula.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

// sempre inicializar o CommandLineRunner. funciona como o main
@Component
public class StartAPP implements CommandLineRunner {

    @Autowired
    private UserRepository repository;
    @Override
    public void run(String... args) throws Exception {
        List<User> users = repository.filtrarPorNome("Lucca"); //repository.findByNameContainer
        for (User i : users) {
            System.out.println(i);
        }
    }

    @Autowired
    private User user;

    private void insertUser() {
        user.setName("Lucca");
        user.setUsername("elice");
        user.setPassword("123");


        for (User u : repository.findAll()) {
            System.out.println(u);
        }
    }
}

