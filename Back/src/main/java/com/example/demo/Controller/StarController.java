package com.example.demo.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.PlanetDTO;
import com.example.demo.DTO.StarDTO;
import com.example.demo.Service.StarService;
@CrossOrigin("*") 
@Controller
@RestController
@RequestMapping(path = "api/v1/stars")
public class StarController {

	private StarService starService;
	
	public StarController(StarService starService) {
		this.starService = starService;
	}
	
	
	
	//localhost:9000/api/v1/stars/{id}
	@GetMapping(path="/{id}")
	public StarDTO getOne(@PathVariable int id) {
	
		return ResponseEntity.status(200).body(starService.getOne(id)).getBody();
	}
	
	//localhost:9000/api/v1/stars/
	@GetMapping(path="/")
	@CrossOrigin("*") 
	public List<StarDTO> getAll() {
		return ResponseEntity.status(200).body(starService.getAll()).getBody();
	}
	
	@PostMapping(path="/")
	public ResponseEntity post(@RequestBody StarDTO starDTO) {
		
		StarDTO result = new StarDTO();
		
		try {
			
			result = starService.post(starDTO);
			
		} catch (Exception e) {

		}
		
		return ResponseEntity.status(201).body(result);
		
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity put(@RequestBody StarDTO starDTO, @PathVariable int id) {
		
		StarDTO result = new StarDTO();
		
		try {
			
			result = starService.put(starDTO, id);
			
		} catch (Exception e) {

		}
		
		starDTO.setId(result.getId());
		
		return ResponseEntity.status(201).body(starDTO);
		
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity delete(@PathVariable int id) {
		
		boolean result = starService.delete(id);
		
		if(result) {
			return ResponseEntity.status(204).body("");
		}
		else {
			return ResponseEntity.status(204).body("No funciona");
		}
		
		
		
	}
	
}
