package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void findWhiskiesByYear() {
		List<Whisky> found = whiskyRepository.findWhiskiesByYear(2018);
		assertEquals("The Glendronach Revival", found.get(0).getName());
	}

	@Test
	public void findDistilleriesByRegion() {
		List<Distillery> found = distilleryRepository.findByRegion("Lowland");
		assertEquals("Rosebank", found.get(0).getName());
	}

	@Test
	public void findWhiskiesByDistilleryIdAndAge() {
		List<Whisky> found = whiskyRepository.findWhiskiesByAgeAndDistilleryId(15,1L);
		assertEquals("The Glendronach Revival", found.get(0).getName());
	}

	@Test
	public void findWhiskiesByDistilleryRegion() {
		List<Whisky> found = whiskyRepository.findWhiskiesByDistilleryRegion("Lowland");
		assertEquals("The Rosebank 12 - Flora and Fona", found.get(0).getName());
	}

	@Test
	public void findDistilleriesByWhiskiesAge() {
		List<Distillery> found = distilleryRepository.findDistilleriesByWhiskiesAge(12);
		assertEquals(2, found.size());
	}

}
