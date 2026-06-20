package pl.pjatk.jazs34060nbp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Currency Rate API",
                version = "1.0",
                description = "API for fetching currency rates from NBP"
        )
)
public class JazS34060NbpApplication {

    public static void main(String[] args) {
        SpringApplication.run(JazS34060NbpApplication.class, args);
    }

}
