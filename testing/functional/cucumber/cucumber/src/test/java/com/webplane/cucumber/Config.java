package com.webplane.cucumber;

public class Config {
	public static class HomePage{
	public static String baseURL = "http://localhost:8080/";
	public static String content = "Home";
	}
	
	public static class SimulatorPage{
	public static String baseURL = "http://localhost:8080/simulator";
	public static String content = "simulator";
	}
	
	public static class TheoryPage{
	public static String baseURL = "http://localhost:8080/theory";
	public static String content = "theory";
	}
	
	public static class Menu{
		public static String homeTopLinkText = "Home";
		public static String simulatorTopLinkText = "Simulator";
		public static String theoryTopLinkText = "Theory";
		
		//URL
		public static String homeTopLinkURL = "http://localhost:8080/";
		public static String simulatorTopLinkURL = "http://localhost:8080/simulator";
		public static String theoryTopLinkURL = "http://localhost:8080/theory";
	}

}
