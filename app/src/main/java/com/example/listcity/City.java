package com.example.listcity;
/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {
    private String city;
    private String province;

    /**
     * Constructor for City
     * @param city name of the city
     * @param province name of the province
     */
    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the city name
     * @return city name
     */
    public String getCityName() {
        return this.city;
    }

    /**
     * Gets the province name
     * @return province name
     */
    public String getProvinceName() {
        return this.province;
    }

    /**
     * Compare cities based on city name
     * Used for sorting cities alphabetically
     *
     * * @param other the other city to compare with
     *  * @return comparison result based on city name
     */
    @Override
    public int compareTo(City other) {
        return this.city.compareTo(other.getCityName());
    }

    /**
     * Checks whether two cities are equal.
     * Two cities are equal if both city name and province match.
     *
     * @param o object to compare
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City other = (City) o;

        // Compare by content (city + province)
        return this.city.equals(other.city) && this.province.equals(other.province);
    }

    /**
     * Generates hash code for the city.
     * Required when equals() is overridden.
     *
     * @return hash code value
     */
    @Override
    public int hashCode() {
        int result = city.hashCode();
        result = 31 * result + province.hashCode();
        return result;
    }
}
