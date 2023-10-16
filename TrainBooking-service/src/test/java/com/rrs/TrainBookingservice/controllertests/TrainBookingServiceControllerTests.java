package com.rrs.TrainBookingservice.controllertests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rrs.TrainBookingservice.controllers.Bookingcontroller;
import com.rrs.TrainBookingservice.models.Booking;
import com.rrs.TrainBookingservice.models.BookingDetails;
import com.rrs.TrainBookingservice.models.BookingInfo;
import com.rrs.TrainBookingservice.repository.BookingRepo;

@SpringBootTest
public class TrainBookingServiceControllerTests {

	@Autowired
	private Bookingcontroller bookingController;
	
	@Autowired
	private BookingRepo bookingRepo;
	
	@Test
    public void testSaveBooking() {
        Booking booking = new Booking();
        BookingDetails details = new BookingDetails();
        details.setName("John Doe");
        List<BookingDetails> passengerList = new ArrayList<>();
        passengerList.add(details);
        booking.setPassengerList(passengerList);
        booking.setBookingDetails(new BookingInfo());

        String result = bookingController.saveBooking(booking);
        assertEquals("Added booking details", result);
    }
	
	@Test
    public void testGetByUserId() {
        List<Booking> bookings = new ArrayList<>();
        // Add test data to the database using repository

        for (int i = 0; i < 5; i++) {
            Booking booking = new Booking();
            booking.setUserId("user");
            bookingRepo.save(booking);
            bookings.add(booking);
        }

        List<Booking> result = bookingController.getByUserId("user123");

        assertEquals(10, result.size());
    }
	
	@Test
    public void testGetBookedTicket() {
        Booking booking = new Booking();
        booking.setPnr("1695000666049");
        bookingRepo.save(booking);

        Booking result = bookingController.getBookedTicket("1695000666049");

        assertNotNull(result);
        assertEquals("1695000666049", result.getPnr());
    }
}