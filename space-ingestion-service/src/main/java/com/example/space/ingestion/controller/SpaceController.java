package com.example.space.ingestion.controller;

import com.example.space.ingestion.service.IngestionService;

import org.springframework.web.bind.annotation.*;

import com.example.space.ingestion.primarymodel.MinuteStats;
import com.example.space.ingestion.service.*;
@RestController
@RequestMapping("/api/space")
public class SpaceController {

    private final IngestionService ingestionService;
    
    private final KafkaProducerService kafkaProducerService;

    public SpaceController(IngestionService ingestionService, KafkaProducerService kafkaProducerService) {
        this.ingestionService = ingestionService;
		this.kafkaProducerService = kafkaProducerService;
    }

    @GetMapping("/accept")
    public String accept(
            @RequestParam("id") String id,
            @RequestParam(value = "endpoint", required = false) String endpoint) {

        try {
        	System.out.println(":::::Hitted" );
            ingestionService.processRequest(id, endpoint);
            return "ok";
        } catch (Exception e) {
            return "failed";
        }
        
        
        
        
    }
    
    public MinuteStats getProduct(@PathVariable Long id) {
		return null;
       /* return findProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));*/
    }
    
    @GetMapping("/accept")
    public String accept(@RequestParam String id) {
        kafkaProducerService.send(id);
        return "ok";
    }
}
