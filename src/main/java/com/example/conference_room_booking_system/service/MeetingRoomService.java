package com.example.conference_room_booking_system.service;

import com.example.conference_room_booking_system.model.MeetingRoom;
import com.example.conference_room_booking_system.repository.MeetingRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingRoomService {

    @Autowired
    MeetingRoomRepository meetingRoomRepository;

    public List<MeetingRoom> getAllMeetingRooms(){
        return   meetingRoomRepository.findAll();
    }
    public  MeetingRoom saveMeetingRoom(MeetingRoom meetingRoom){
        return meetingRoomRepository.save(meetingRoom);
    }

}
