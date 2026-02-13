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
}
