package app.vercel.machadoah.userapi;

import app.vercel.machadoah.userapi.domain.User;
import app.vercel.machadoah.userapi.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Component
@RequiredArgsConstructor
@SpringBootApplication
public class UserApiApplication implements CommandLineRunner {

	private final UserRepository userRepository;

	/**
	 * 	Se trata do nosso main, classe principal por startar toda a interface desenvolvida
	 */

	public static void main(String[] args) {
		SpringApplication.run(UserApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.saveAll(List.of(
				new User(null, "Isadora", "isadora@email.com","124", 40.7)
		));
	}
}
