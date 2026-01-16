import java.util.*;
import java.util.stream.*;
import java.io.*;

class Country {
	private String code;
	private String name;
	private String continent;
	private double surfaceArea;
	private double population;
	private double gnp;
	private int capital;
	

	// Setters
	
	void setCode(String code){
		this.code = code;
	}

	void setName(String name){
		this.name = name;
	}

	void setContinent(String continent){
		this.continent = continent;
	}

	void setSurfaceArea(double surfaceArea){
		this.surfaceArea = surfaceArea;
	}

	void setPopulation(double population){
		this.population = population;
	}

	void setGNP(double gnp){
		this.gnp = gnp;
	}

	void setCapital(int capital){
		this.capital = capital;
	}

	// Getters 

	String getCode(){
		return this.code;
	}

	String getName(){
		return this.name;
	}

	String getContinent(){
		return this.continent;
	}

	double getSurfaceArea(){
		return this.surfaceArea;
	}

	double getPopulation(){
		return this.population;
	}

	double getGNP(){
		return this.gnp;
	}

	int getCapital(){
		return this.capital;
	}

}

class City {
	private int id;
	private String name;
	private int population;
	private String countryCode;

	// Setters
	
	void setID(int id){
		this.id = id;
	}

	void setName(String name){
		this.name = name;
	}

	void setPopulation(int population){
		this.population = population;
	}

	void setCountryCode(String countryCode){
		this.countryCode = countryCode;
	}

	// Getters

	
	int getID(){
		return this.id;
	}

	String getName(){
		return this.name;
	}

	int getPopulation(){
		return this.population;
	}

	String getCountryCode(){
		return this.countryCode;
	}


}

public class StreamAPI{
	public static void main(String[] args){
	
	// File paths
	String countriesFilePath = "../Excel_Sheets/Countries.csv";
	String citiesFilePath = "../Excel_Sheets/Cities.csv";
		
	// Array Lists
	ArrayList<Country> countriesList = new ArrayList(); 
	ArrayList<City> citiesList = new ArrayList(); 
	
	String line = "";
	try{

	// Putting Countries csv file data into the countriesList array list
	BufferedReader countries = new BufferedReader(new FileReader(countriesFilePath));
	while((line = countries.readLine()) != null){
		String row[] = line.split(",");

		Country countryObj = new Country();
		
		countryObj.setCode(row[0]);
		countryObj.setName(row[1]);
		countryObj.setContinent(row[2]);
		countryObj.setSurfaceArea(Double.parseDouble(row[3]));
		countryObj.setPopulation(Double.parseDouble(row[4]));
		countryObj.setGNP(Double.parseDouble(row[5]));
		countryObj.setCapital(Integer.parseInt(row[6]));
		
		countriesList.add(countryObj);
	}

	// Putting Cities csv file data into the citiesList array list
	BufferedReader cities = new BufferedReader(new FileReader(citiesFilePath));
	while((line = cities.readLine()) != null){
		String row[] = line.split(",");

		City cityObj = new City();
		cityObj.setID(Integer.parseInt(row[0]));
		cityObj.setName(row[1]);
		cityObj.setPopulation(Integer.parseInt(row[2]));
		cityObj.setCountryCode(row[3]);
		
		citiesList.add(cityObj);
	}
} catch(Exception e) {
	e.printStackTrace();
} 

	// For testing
	 /*
	City city = citiesList.get(5);
	System.out.println(city.getPopulation());
	*/

	/*
	Country country = countriesList.get(9);
	System.out.println(country.getCapital());
	*/
	

	// Finding the highest populated city per country
	Map<String, Optional<City>> highestPopPerCountry = citiesList.stream()
            .collect(Collectors.groupingBy(
                City::getCountryCode, 
                Collectors.maxBy(Comparator.comparingInt(City::getPopulation))
            ));

	System.out.println("Highest Population for each country : ");

	highestPopPerCountry.values().forEach(opt -> opt.ifPresent(c -> {
   	System.out.println(c.getCountryCode() + "\t" + c.getName() + "\t" + c.getPopulation());
	}));
		
	// Finding the most populated country of each continent
	

	// Finding the highest populated capital city
	} 

}










