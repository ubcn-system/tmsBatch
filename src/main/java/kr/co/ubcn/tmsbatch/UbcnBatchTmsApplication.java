package kr.co.ubcn.tmsbatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UbcnBatchTmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UbcnBatchTmsApplication.class, args);
	}

}
