package com.example.demo.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassGen {
	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		System.out.println(encoder.encode("yash"));
		System.out.println(encoder.encode("aman"));
		System.out.println(encoder.encode("nayan"));		
	}
}
/*
 * $2a$10$mCNHziu1HbrODr0PCkhfsuY/YJW1MAzOG5AGOkl9ip7Wf1nLx5YeW
 * $2a$10$J4RarxtkOt/hPCe/2TgIpunZeOyCtKxU3h67jrmJnrdE8reo3xkK.
 * $2a$10$Lix38iZKZ//G/mMUu0a4s.LOgW7NJOi6YWMPkgZJmqrreulF1W4UK
 */