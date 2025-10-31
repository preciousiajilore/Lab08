package com.example.lab08;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CustomListTest {
    @Test
    public void testHasCity() {
        CustomList list = new CustomList();
        City calgary = new City("Calgary", "AB");
        list.addCity(calgary);
        // This will fail initially because hasCity() doesn't exist
        assertTrue(list.hasCity(calgary));


    }

    @Test
    void testDelete() {
        //This makes a mock city list
        CustomList cityList = new CustomList();

        //Create a new city
        City city = new City("Yellowknife", "Northwest Territories");

        //Try and remove the city from the list
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });

        //Add the city to the list
        cityList.addCity(city);

        //Remove the city from the list
        cityList.delete(city);

        //Check if the city is in the list
        assertFalse(cityList.hasCity(city));

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });


    }
    @Test
    void testCountCities(){
        //This makes a mock city list
        CustomList cityList = new CustomList();

        //Checks if the size of the cityList is 1
        assertEquals(1, cityList.countCities());

        //Make a new city
        City city = new City("Yellowknife", "Northwest Territories");

        //Add the city to the list
        cityList.addCity(city);

        //Checks if the size of the cityList is 2
        assertEquals(2, cityList.countCities());

        //Remove the city from the list
        cityList.delete(city);

        //Checks if the size of the cityList is 1
        assertEquals(1, cityList.countCities());
    }


}
