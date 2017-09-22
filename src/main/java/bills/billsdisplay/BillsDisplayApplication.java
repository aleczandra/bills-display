package bills.billsdisplay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("bills.billsdisplay")
public class BillsDisplayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillsDisplayApplication.class, args);
	}
}
