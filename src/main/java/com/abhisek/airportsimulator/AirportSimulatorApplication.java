package com.abhisek.airportsimulator;

import com.abhisek.airportsimulator.service.AirportService;
import com.abhisek.airportsimulator.threads.RunwayController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AirportSimulatorApplication {

	@Autowired
	private AirportService airportService;

	public static void main(String[] args) {
		SpringApplication.run(AirportSimulatorApplication.class, args);
	}

	@Bean
	CommandLineRunner run() {

		return args -> {

			// Generator removed.
			// It will be started using the /start API.

			Thread runway = new Thread(new RunwayController(airportService));

			runway.start();

		};

	}

}