package com.quizpro;

import java.util.Random;

public class Test {
	public static void main(String[] args) {
		String x = String.valueOf(new Random().nextInt(1000000));
		System.out.println(x);
	}
}
