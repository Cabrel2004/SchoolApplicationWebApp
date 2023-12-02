package com.example.schoolstock.service;

import com.example.schoolstock.Model.Event;
import com.example.schoolstock.eventdtos.CreateEventDto;
import com.example.schoolstock.eventdtos.UpdateEventDto;
import com.example.schoolstock.repo.EventRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepo eventRepo;

    public Event getEvent(String id) {
        return eventRepo.findById(id).orElse(null);
    }

    public List<Event> findAllEvents() {
        List<Event> events=eventRepo.findAll();
        if (events.isEmpty()){
            throw new RuntimeException("The events are not found");
        }
        return events;
    }

    public Event CreateEvent(CreateEventDto dto){
        try {
            var event = findById(dto.getId());
            if (event==null){
                event=new Event();
                event.setId(dto.getId());
                event.setDate(dto.getDate());
                event.setName(dto.getName());
                return eventRepo.save(event);
            }
            else {
                throw new RuntimeException("The events were  found");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
       throw new RuntimeException("Events not found");
    }

    public Event findById(String id) {
        return eventRepo.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        eventRepo.deleteById(id);
    }

    public Event UpdateEvents(UpdateEventDto dto) {
        try {
            var event = findById(dto.getId());
            if (event != null) {
                event.setName(dto.getName());
                event.setId(dto.getId());
                event.setDate(dto.getDate());
                return eventRepo.save(event);
            } else {
                throw new RuntimeException("Event is updated " + dto.getId() + "Event not updated");

            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
