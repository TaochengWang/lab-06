package com.example.listcity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for CityList class.
 * This class tests add(), exception handling, and getCities() behavior.
 */
class CityListTest {

    /**
     * Creates a CityList containing one mock city.
     * This is used to avoid repeating setup code in every test.
     */
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    /**
     * Creates a mock City object used in tests.
     */
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testHasCity() {

        CityList cityList = mockCityList();

        // Edmonton already exists in mock list
        assertTrue(cityList.hasCity(mockCity()));

        // This city was not added
        City city = new City("Calgary", "Alberta");
        assertFalse(cityList.hasCity(city));
    }

    /**
     * Test that adding a city increases list size
     * and that the city exists in the list.
     */
    @Test
    void testAdd() {
        CityList cityList = mockCityList();

        // Initially there should be one city
        assertEquals(1, cityList.getCities().size());

        // Add another city
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        // Now there should be two cities
        assertEquals(2, cityList.getCities().size());

        // The new city should exist in the list
        assertTrue(cityList.getCities().contains(city));
    }

    /**
     * Test that adding a duplicate city throws an exception.
     */
    @Test
    void testAddException() {
        CityList cityList = mockCityList();

        // Same city as mockCity()
        City city = new City("Edmonton", "Alberta");

        // Expect IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    /**
     * Test deleting a city from the list.
     * The city should be removed and the list size should decrease.
     */
    @Test
    void testDelete() {
        // Create a CityList with one existing city
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        // Delete the existing city
        cityList.delete(mockCity());

        // Now list should be empty and should not contain the city
        assertEquals(0, cityList.getCities().size());
        assertFalse(cityList.getCities().contains(mockCity()));
    }

    /**
     * Test that deleting a non-existing city throws an exception.
     */
    @Test
    void testDeleteException() {
        // Create a CityList with one city
        CityList cityList = mockCityList();

        // Create a city that is NOT in the list
        City city = new City("Calgary", "Alberta");

        // Expect IllegalArgumentException when deleting a non-existing city
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });
    }

    /**
     * Test the behavior of getCities().
     * The list should remain sorted alphabetically by city name.
     */
    @Test
    void testGetCities() {

        // Create a list containing Edmonton
        CityList cityList = mockCityList();

        // The first city should be Edmonton
        // compareTo() returns 0 when cities are equal
        assertEquals(
                0,
                mockCity().compareTo(cityList.getCities().get(0))
        );

        // Add a city that should come before Edmonton alphabetically
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        // The new city should now be at position 0
        assertEquals(
                0,
                city.compareTo(cityList.getCities().get(0))
        );

        // Edmonton should now be at position 1
        assertEquals(
                0,
                mockCity().compareTo(cityList.getCities().get(1))
        );
    }

    /**
     * Test that countCities() correctly returns
     * the number of cities in the list.
     */
    @Test
    void testCountCities() {

        // mockCityList() already contains one city
        CityList cityList = mockCityList();

        // should start with one city
        assertEquals(1, cityList.countCities());

        // add another city
        cityList.add(new City("Calgary", "Alberta"));

        // now should be two cities
        assertEquals(2, cityList.countCities());
    }
}
