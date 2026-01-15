import java.util.ArrayList;

class Country {
	private String code;
	private String name;
	private String continent;
	private double surfaceArea;
	private int population;
	private double gnp;
	private int capital;

	// Constructor
	
	public Country(String code, String name, String continent,
		double surfaceArea, int population, double gnp, int capital){
			this.code = code;
			this.name = name;
			this.continent = continent;
			this.surfaceArea = surfaceArea;
			this.population = population;
			this.gnp = gnp;
			this.capital = capital;
		}
}

class City {
	private int id;
	private String name;
	private int population;
	private String countryCode;

	// Constructor
	
	public City(int id, String name, int population, String countryCode){
		this.id = id;
		this.name = name;
		this.population = population;
		this.countryCode = countryCode;
	}
}

public class StreamAPI{
	public static void main(String[] args){
		
	} 
}









