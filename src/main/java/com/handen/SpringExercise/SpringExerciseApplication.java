package com.handen.SpringExercise;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.handen.SpringExercise")
public class SpringExerciseApplication {
	@Autowired
	MyBatisConfig mMyBatisConfig;

	public static void main(String[] args)
	{
		SpringApplication.run(SpringExerciseApplication.class, args);
	}
}
