package com.oguilhermeviana.parkingcontrol.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.oguilhermeviana.parkingcontrol.models.ParkingSpotModel;
import com.oguilhermeviana.parkingcontrol.repositories.ParkingSpotRepository;

import jakarta.transaction.Transactional;

@Service
public class ParkingSpotService {

  final ParkingSpotRepository repo;

  public ParkingSpotService(ParkingSpotRepository repo) {
    this.repo = repo;
  }

  @Transactional
  public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
    return repo.save(parkingSpotModel);
  }

  public boolean existsByLicensePlateCar(String licensePlateCar) {
    return repo.existsByLicensePlateCar(licensePlateCar);
  }

  public boolean existsbyParkingSpotNumber(String parkingSpotNumber) {
    return repo.existsByParkingSpotNumber(parkingSpotNumber);
  }

  public boolean existsByApartmentAndBlock(String apartment, String block) {
    return repo.existsByApartmentAndBlock(apartment, block);
  }

  public Page<ParkingSpotModel> findAll(Pageable pageable) {
    return repo.findAll(pageable);
  }

  public Optional<ParkingSpotModel> findById(UUID id) {
    return repo.findById(id);
  }

  @Transactional
  public void delete(ParkingSpotModel parkingSpotModel) {
    repo.delete(parkingSpotModel);
  }

}
