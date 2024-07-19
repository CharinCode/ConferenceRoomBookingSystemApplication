package com.example.conference_room_booking_system.controller;

import com.example.conference_room_booking_system.model.MeetingRoom;
import com.example.conference_room_booking_system.repository.MeetingRoomRepository;
import com.example.conference_room_booking_system.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meeting-rooms")
public class MeetingRoomController {

    @Autowired
    MeetingRoomService meetingRoomService;

    @GetMapping
    public List<MeetingRoom> getAllMeetingRooms(){
        return  meetingRoomService.getAllMeetingRooms();
    }

    @PostMapping
    public  MeetingRoom saveMeetingRoom(
            @RequestBody MeetingRoom meetingRoom
    ){
        return  meetingRoomService.saveMeetingRoom(meetingRoom);
    }
}
