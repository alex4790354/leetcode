package com.github.alex4790354;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestLeetcodeExamplesApplication {

	public static void main(String[] args) {
		SpringApplication.from(LeetcodeExamplesApplication::main).with(TestLeetcodeExamplesApplication.class).run(args);
	}

}
