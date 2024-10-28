package com.dress_size_picker.personalProject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DressSizeSelectorTest {

	private DressSizeSelector dressSizeSelector;

	@BeforeEach
	public void setup() {
		dressSizeSelector = new DressSizeSelector();
	}

	@Test
	public void shouldReturnUnknown() {
		String size = dressSizeSelector.pickSize(24, 20, 28);
		assertEquals("U", size);
	}

	@Test
	public void shouldReturnXL() {
		String size = dressSizeSelector.pickSize(45, 41, 59);
		assertEquals("XL", size);
	}

	@Test
	public void shouldReturnLarge() {
		String size = dressSizeSelector.pickSize(35, 38, 41);
		assertEquals("L", size);
	}

	@Test
	public void shouldReturnMedium() {
		String size = dressSizeSelector.pickSize(35, 32, 40);
		assertEquals("M", size);
	}

	@Test
	public void shouldReturnSmall() {
		String size = dressSizeSelector.pickSize(29, 24, 39);
		assertEquals("S", size);
	}

}

