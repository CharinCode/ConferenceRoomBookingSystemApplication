package com.example.conference_room_booking_system.service;

import com.example.conference_room_booking_system.model.Booking;
import com.example.conference_room_booking_system.model.MeetingRoom;
import com.example.conference_room_booking_system.repository.BookingRepository;
import com.example.conference_room_booking_system.repository.MeetingRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;


    @Autowired
    private MeetingRoomRepository meetingRoomRepository;

    public List<Booking> getAllBookings(){
        return  bookingRepository.findAll();
    }

    public Booking saveBooking(Booking booking) {

        // ตรวจสอบว่าห้องประชุมที่ระบุมีอยู่ในระบบหรือไม่
        MeetingRoom meetingRoom = meetingRoomRepository.findById(booking.getMeetingRoom().getId())
                .orElseThrow(() -> new RuntimeException("Meeting Room with ID " + booking.getMeetingRoom().getId() + " does not exist"));

        if (booking.getMeetingRoom() == null || booking.getMeetingRoom().getId() == null) {
            throw new RuntimeException("Meeting Room ID is required");
        }

        // ตรวจสอบว่าห้องประชุมมีการจองอยู่แล้วหรือไม่
        boolean isRoomAlreadyBooked = bookingRepository.findAll().stream()
                .anyMatch(existingBooking -> existingBooking.getMeetingRoom().getId().equals(booking.getMeetingRoom().getId()));

        if (isRoomAlreadyBooked) {
            throw new RuntimeException("This meeting room is already booked.");
        }

        if (booking.getStartTime() == null) {
            booking.setStartTime(LocalDateTime.now());
        }
        if (booking.getEndTime() == null) {
            booking.setEndTime(booking.getStartTime().plusHours(1));
        }

        return bookingRepository.save(booking);
    }
}
