package com.rickywong.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rickywong.relationships.models.License;
import com.rickywong.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository lRepo;
	
	public LicenseService(LicenseRepository lRepo) {
		this.lRepo = lRepo;
	}
	
	
	public License createLicense(License license) {
		return lRepo.save(license);
	}
	
	public List<License> allLicense(){
		return lRepo.findAll();
	}
	
}
