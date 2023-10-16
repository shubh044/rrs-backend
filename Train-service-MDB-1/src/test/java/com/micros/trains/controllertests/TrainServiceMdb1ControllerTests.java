package com.micros.trains.controllertests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import com.micros.trains.controller.trainControl;

import com.micros.trains.document.Train;
import com.micros.trains.repo.TrainRepo;
import com.micros.trains.service.TrainService;

@SpringBootTest
class TrainServiceMdb1ServiceTests {

	@Autowired
	private trainControl trainControl;
	
	@Autowired
	private TrainService trainService; 
	
	@Autowired
	private TrainRepo trainRepo;
	
	@Test
	void testViewAllTrains() {
	
	    ResponseEntity<List<Train>> trainList = trainControl.viewAllTrains();
	
	    assertNotNull(trainList);
	}
	
	@Test
    void testSaveTrain() {
        Train train = new Train();
        train.setTrain_id(94345);
        train.setTotal_Seat_sleeper(50);
        train.setTotal_Seat_ac3(40);
        train.setTotal_Seat_ac2(30);
        train.setTotal_Seat_ac1(20);
        train.setPrice_sleeper(1000);
        train.setPrice_ac3(2000);
        train.setPrice_ac2(2500);
        train.setPrice_ac1(3000);
        train.setTrain_name("Express9");
        train.setFrom_station("Station5");
        train.setTo_station("Station6");

        Train savedTrain = trainControl.saveTrain(train);
        assertNotNull(savedTrain);
    }

	@Test
    void testUpdateTrain() {
        Train train = new Train();
        train.setTrain_id(11111);
        train.setTotal_Seat_sleeper(50);
        train.setTotal_Seat_ac3(40);
        train.setTotal_Seat_ac2(30);
        train.setTotal_Seat_ac1(20);
        train.setPrice_sleeper(1000);
        train.setPrice_ac3(2000);
        train.setPrice_ac2(2500);
        train.setPrice_ac1(3000);
        train.setTrain_name("Express10");
        train.setFrom_station("Station5");
        train.setTo_station("Station10");
        trainService.saveTrain(train);

        Train updatedTrain = new Train();
        updatedTrain.setFrom_station("UpdatedStation5");
        updatedTrain.setTo_station("UpdatedStation10");
        updatedTrain.setTotal_Seat_ac1(25);
        updatedTrain.setTotal_Seat_ac2(35);
        updatedTrain.setTotal_Seat_ac3(45);
        updatedTrain.setPrice_sleeper(600);
        updatedTrain.setPrice_ac3(1100);
        updatedTrain.setPrice_ac2(1600);
        updatedTrain.setPrice_ac1(2100);
        updatedTrain.setTotal_Seat_sleeper(55);
        updatedTrain.setTrain_name("UpdatedExpress10");
       
        Train oldTrain = trainControl.updateTrain(train.getTrain_id(), updatedTrain);

        assertNotNull(oldTrain);
        assertEquals("UpdatedStation5", oldTrain.getFrom_station());
        assertEquals("UpdatedStation10", oldTrain.getTo_station());
        assertEquals(25, oldTrain.getTotal_Seat_ac1());
        assertEquals(35, oldTrain.getTotal_Seat_ac2());
        assertEquals(45, oldTrain.getTotal_Seat_ac3());
        assertEquals(600, oldTrain.getPrice_sleeper());
        assertEquals(1100, oldTrain.getPrice_ac3());
        assertEquals(1600, oldTrain.getPrice_ac2());
        assertEquals(2100, oldTrain.getPrice_ac1());
        assertEquals(55, oldTrain.getTotal_Seat_sleeper());
        assertEquals("UpdatedExpress10", oldTrain.getTrain_name());
    }
	
	@Test
    void testDeleteTrainById() {
        // Create a sample Train object and add it to the in-memory repository
//        Train train = new Train(/* provide required data */);
//        trainRepo.save(train);

        // Call the method you want to test
        String result = trainControl.deletebyid(34532);

        // Assertions
        assertNotNull(result); // Verify that the result of the deletion operation is not null
    }
	
	@Test
    void testGetTrainsByName() {
        // Create sample data for the test
        Train train1 = new Train(/* provide required data */);

        trainRepo.save(train1);

        // Call the method you want to test
        List<Train> retrievedTrains = trainControl.getName("Express9");

        // Assertions
        assertNotNull(retrievedTrains); // Verify that the retrieved list of Trains is not null
    }
	
	@Test
    void testGetTrainsByStations() {
        // Create sample data for the test
        Train train1 = new Train(/* provide required data */);
        trainRepo.save(train1);

        // Call the method you want to test
        List<Train> retrievedTrains = trainControl.getTrains("Station5", "Station6");

        // Assertions
        assertNotNull(retrievedTrains); // Verify that the retrieved list of Trains is not null
    }
}