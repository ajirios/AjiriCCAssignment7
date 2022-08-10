package com.unittest.list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomArrayListTest 

{
	@Test
	void should_throw_exception_on_get_if_empty()
	
	{
		CustomArrayList<String> list = new CustomArrayList<String>();
		
		IndexOutOfBoundsException exception1 = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			list.get(0);
		});

		IndexOutOfBoundsException exception2 = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			list.get(1000);
		});

		IndexOutOfBoundsException exception3 = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			list.get(-1);
		});
		
		assertEquals("Index out of bounds.", exception1.getMessage());
		assertEquals("Index out of bounds.", exception2.getMessage());
		assertEquals("Index out of bounds.", exception3.getMessage());
	}
	
	@Test
	void should_return_zero_size_if_empty()
	
	{
		CustomArrayList<String> list;
		
		list = new CustomArrayList<String>();
		
		assertEquals(list.getSize(), 0);
	}

	@Test
	void should_add_object_to_list() 
	
	{
		CustomArrayList<String> list = new CustomArrayList<String>();
		
		list.add("Verdant");	
		
		assertEquals("Verdant", list.get(0));
		assertEquals(list.getSize(), 1);
		
	}

	@Test
	void should_add_eleven_objects_to_list() 
	
	{
		CustomArrayList<String> list = new CustomArrayList<String>();
		
		list.add("Verdant");
		list.add("Salvatore");
		list.add("Gemini");
		list.add("Watchman");
		list.add("Gaara");
		list.add("Venturi");
		list.add("Passo");
		list.add("Bikini");
		list.add("Denora");
		list.add("King");
		list.add("Calypso");
		
		assertEquals("Verdant", list.get(0));
		assertEquals("Calypso", list.get(10));
		assertEquals(list.getSize(), 11);
	}

	@Test
	void should_add_21_objects_to_list() 
	
	{
		CustomArrayList<String> list = new CustomArrayList<String>();
		
		list.add("Verdant");
		list.add("Salvatore");
		list.add("Gemini");
		list.add("Watchman");
		list.add("Gaara");
		list.add("Venturi");
		list.add("Passo");
		list.add("Bikini");
		list.add("Denora");
		list.add("King");
		list.add("Calypso");
		list.add("Bridget");
		list.add("Ingerwood");
		list.add("Telaviv");
		list.add("Spotted");
		list.add("Carat");
		list.add("Physis");
		list.add("Cherish");
		list.add("Bazaar");
		list.add("Scale");
		list.add("Tropica");
		
		assertEquals("Verdant", list.get(0));
		assertEquals("Calypso", list.get(10));
		assertEquals("Tropica", list.get(20));
		assertEquals(list.getSize(), 21);
		
	}

	@Test
	void should_add_a_million_objects_to_list() 
	
	{
		CustomArrayList<String> list = new CustomArrayList<String>();
			
		for (int count = 0; count < 1000000; count++)
		{
			list.add("Element " + (count + 1));
		}

		IndexOutOfBoundsException exception1 = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			list.get(1000000);
		});

		IndexOutOfBoundsException exception2 = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			list.get(-1);
		});
		
		assertEquals("Element 1", list.get(0));
		assertEquals("Element 1000000", list.get(999999));
		assertEquals("Index out of bounds.", exception1.getMessage());
		assertEquals("Index out of bounds.", exception2.getMessage());
		assertEquals(list.getSize(), 1000000);
		
	}

	@Test
	void should_add_object_at_index_to_list() 
	
	{
		CustomArrayList<String> list = new CustomArrayList<String>();
		
		list.add("Verdant");
		list.add("Salvatore");
		list.add("Gemini");
		list.add("Watchman");
		list.add("Gaara");
		list.add("Venturi");
		list.add("Passo");
		list.add("Bikini");
		list.add("Denora");
		list.add("King");
		list.add("Calypso");
		
		list.add(4, "Granger");
		
		assertEquals("Granger", list.get(4));
		assertEquals("Gaara", list.get(5));
		assertEquals("Calypso", list.get(11));
		assertEquals(list.getSize(), 12);
		
		list.add(11, "Bossman");

		assertEquals("King", list.get(10));
		assertEquals("Bossman", list.get(11));
		assertEquals("Calypso", list.get(12));
		assertEquals(list.getSize(), 13);
	}
	
	@Test
	void should_throw_exception_if_add_index_out_of_bounds()
	
	{
		CustomArrayList<String> list = new CustomArrayList<String>();
		
		list.add("Verdant");
		list.add("Salvatore");
		list.add("Gemini");
		list.add("Watchman");
		list.add("Gaara");
		list.add("Venturi");
		list.add("Passo");
		list.add("Bikini");
		list.add("Denora");
		list.add("King");
		list.add("Calypso");
		
		IndexOutOfBoundsException exception1 = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			list.add(-4, "Granger");
		});
		IndexOutOfBoundsException exception2 = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			list.add(11, "Granger");
		});
		
		assertEquals("Gaara", list.get(4));
		assertEquals("Calypso", list.get(10));
		assertEquals(list.getSize(), 11);
		assertEquals("Index out of bounds.", exception1.getMessage());
		assertEquals("Index out of bounds.", exception2.getMessage());
	}
	
	@Test
	void should_remove_object_from_list()
	
	{
		CustomArrayList<String> list = new CustomArrayList<String>();
		
		list.add("Verdant");
		list.add("Salvatore");
		list.add("Gemini");
		list.add("Watchman");
		list.add("Gaara");
		list.add("Venturi");
		list.add("Passo");
		list.add("Bikini");
		list.add("Denora");
		list.add("King");
		list.add("Calypso");
		
		list.remove(4);
		
		assertEquals("Venturi", list.get(4));
		assertEquals("Calypso", list.get(9));
		assertEquals(list.getSize(), 10);

		list.remove(9);
		
		assertEquals("Venturi", list.get(4));
		assertEquals("King", list.get(8));
		assertEquals(list.getSize(), 9);
	}
	
	@Test
	void should_throw_exception_if_remove_index_out_of_bounds()
	
	{
		CustomArrayList<String> list = new CustomArrayList<String>();
		
		list.add("Verdant");
		list.add("Salvatore");
		list.add("Gemini");
		list.add("Watchman");
		list.add("Gaara");
		list.add("Venturi");
		list.add("Passo");
		list.add("Bikini");
		list.add("Denora");
		list.add("King");
		list.add("Calypso");
		
		IndexOutOfBoundsException exception1 = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			list.remove(-4);
		});
		IndexOutOfBoundsException exception2 = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			list.remove(11);
		});
		
		assertEquals("Gaara", list.get(4));
		assertEquals("Calypso", list.get(10));
		assertEquals(list.getSize(), 11);
		assertEquals("Index out of bounds.", exception1.getMessage());
		assertEquals("Index out of bounds.", exception2.getMessage());
	}
	
	@Test
	void should_remove_item_9_from_list_size_10()
	
	{
		CustomArrayList<String> list = new CustomArrayList<String>();
		
		list.add("Verdant");
		list.add("Salvatore");
		list.add("Gemini");
		list.add("Watchman");
		list.add("Gaara");
		list.add("Venturi");
		list.add("Passo");
		list.add("Bikini");
		list.add("Denora");
		list.add("King");
		
		list.remove(9);
		list.add("Calypso");
		list.add(7, "10000");
		list.add(3, "10000");

		assertEquals("10000", list.get(3));
		assertEquals("10000", list.get(8));
		assertEquals("Calypso", list.get(11));
		assertEquals(list.getSize(), 12);
	}

}
