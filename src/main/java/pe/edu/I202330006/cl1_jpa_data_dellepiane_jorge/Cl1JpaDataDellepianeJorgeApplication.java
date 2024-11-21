package pe.edu.I202330006.cl1_jpa_data_dellepiane_jorge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.I202330006.cl1_jpa_data_dellepiane_jorge.entity.country;
import pe.edu.I202330006.cl1_jpa_data_dellepiane_jorge.repository.CountryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class Cl1JpaDataDellepianeJorgeApplication implements CommandLineRunner {

	@Autowired
	CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataDellepianeJorgeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Optional<country> optional = countryRepository.findById("ARG");
		optional.ifPresentOrElse(
				country -> {
					System.out.println("Lenguajes hablados en Argentina:");
					country.getCountrylanguages().forEach(language ->
							System.out.println(language.getCountry()));
				},
				() -> {
					Optional<country> optional2 = countryRepository.findById("PER");
					optional2.ifPresent(country -> {
						System.out.println("Lenguajes hablados en Perú:");
						country.getCountrylanguages().forEach(language ->
								System.out.println(language.getCountry()));
					});
				}
		);

			List<String> lista = List.of("COL", "ARG");
			lista.stream().filter(countryRepository::existsById).collect(Collectors.toList());

			countryRepository.deleteAll(lista);
	}
}
