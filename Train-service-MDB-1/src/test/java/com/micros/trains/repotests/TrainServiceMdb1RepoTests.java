package com.micros.trains.repotests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.micros.trains.document.Train;
import com.micros.trains.repo.TrainRepo;

@SpringBootTest
class TrainServiceMdb1RepoTests {

	@Autowired
	private TrainRepo trainRepo;
	
	@Test
    void testFindTrainByName() {
        List<Train> trains = trainRepo.trainName("Express123");
        assertTrue(trains.size() > 0);
    }
	@Test
    void testFindTrainsBetweenStations() {
        List<Train> trains = trainRepo.findtrains("Station1", "station2");
        assertEquals(1, trains.size());
    }
	
	@Test
    void testFindByTrainNameLike() {
        // Create sample data and add it to the in-memory repository
        Train train1 = new Train(/* provide required data */);
        trainRepo.save(train1);

        // Call the method you want to test
        List<Train> trains = trainRepo.FindByTrain_nameLike("Express");

        // Assertions
        assertEquals(1, trains.size()); // Verify that the method returns the expected number of results
    }
}

