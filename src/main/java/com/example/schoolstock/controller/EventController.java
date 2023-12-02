package com.example.schoolstock.controller;

import com.example.schoolstock.Model.Event;
import com.example.schoolstock.eventdtos.CreateEventDto;
import com.example.schoolstock.eventdtos.UpdateEventDto;
import com.example.schoolstock.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/events")
public class EventController {

    private final EventService eventService;

    @GetMapping("id")
    public Event getEVent(@RequestParam String id){
        return eventService.getEvent(id);
    }

    @GetMapping("All-events")
    public List<Event> getAllEvents(){
        List<Event> events=eventService.findAllEvents();
     if (events.isEmpty()){
         throw new RuntimeException("The events are not found");
     }
     return events;
    }

    @PostMapping("create-events")
    public ResponseEntity<Event>CreateEvents(@RequestBody CreateEventDto dto){
     try {
         Event existingevents=eventService.findById(dto.getId());
         if (existingevents!=null){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
         }
         Event savedevent=eventService.CreateEvent(dto);
         if (savedevent!=null){
             return ResponseEntity.ok(savedevent);
         }
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
     }catch (Exception e){
         e.printStackTrace();
     }
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("delete{id}")
    public void DeleteById(@RequestParam String id){
        eventService.deleteById(id);
    }

    @PutMapping("update-events")
    public ResponseEntity<Event>UpdateEvents(@RequestBody UpdateEventDto dto){
        Event updateevent=eventService.findById(dto.getId());
        if (updateevent!=null){
            return ResponseEntity.ok(updateevent);
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
