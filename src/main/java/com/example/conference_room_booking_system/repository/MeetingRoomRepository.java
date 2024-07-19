package com.example.conference_room_booking_system.repository;

import com.example.conference_room_booking_system.model.MeetingRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRoomRepository extends JpaRepository<MeetingRoom,Long> {
}
