package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.DTO.PlanetDTO;
import com.example.demo.DTO.StarDTO;
import com.example.demo.Entity.Planet;
import com.example.demo.Repository.PlanetRepository;

@Service
public class PlanetService {

	private PlanetRepository planetRepository;
	


	public PlanetService(PlanetRepository planetRepository) {
		this.planetRepository = planetRepository;
	}
	


	
	public PlanetDTO getOne(int id) {	
		Optional<Planet> bd = planetRepository.findById(id);
		PlanetDTO planetDTO = new PlanetDTO();	
		try {

			Planet planet = bd.get();			
			planetDTO.setId(planet.getId());
			planetDTO.setName(planet.getName());
			planetDTO.setSize(planet.getSize());
//			planetDTO.setStar(planet.getStar());
			return planetDTO;
			
		} catch (Exception e) {
			
			return planetDTO;
		}
		
	}
	
	public List<PlanetDTO> getAll(){	
		List<PlanetDTO> lista = new ArrayList<>();	
		// comunico la lectura al repositorio y me devuelve Entidad
		for (Planet planet : planetRepository.findAll()) {
			// cargo de la entidad al Dto
			PlanetDTO temp = new PlanetDTO();
			temp.setId(planet.getId());
			temp.setName(planet.getName());
			temp.setSize(planet.getSize());
			
			StarDTO starDTO = new StarDTO();
			starDTO.setId(planet.getStar().getId());
			starDTO.setNombre(planet.getStar().getNombre());
			starDTO.setDensidad(planet.getStar().getDensidad());
			temp.setStar(starDTO);
			
//			Cargo a cada elemento el dto
			lista.add(temp);			
		}
		
		return lista;
		
	}
	
	public PlanetDTO post(PlanetDTO planetDTO) {		
		Planet planet = new Planet();		
		planet.setId(planetDTO.getId());
		planet.setName(planetDTO.getName());
		planet.setSize(planetDTO.getSize());
//		planet.setStar(planetDTO.getStar());
		try {			
			planetRepository.save(planet);			
		} catch (Exception e) {	
			
		}	
		planetDTO.setId(planet.getId());
		return planetDTO;
		
	}
	
	public PlanetDTO put(PlanetDTO planetDTO, int id) {
		Optional<Planet> temp = planetRepository.findById(id);			
		try {		
			Planet planet = temp.get();
			planet.setName(planetDTO.getName());
			planet.setSize(planetDTO.getSize());
//			planet.setStar(planetDTO.getStar());
			planetRepository.save(planet);		
		
			planetDTO.setId(planet.getId());		
		} catch (Exception e) {			
			System.out.print("Bad request");
		}			
		return planetDTO;	
	}
	
	public boolean delete(int id) {
		Optional<Planet> temp = planetRepository.findById(id);	
		try {					
			planetRepository.delete(temp.get());
			return true;		
		} catch (Exception e) {
			return false;
			
		}
		
	}
	
}
