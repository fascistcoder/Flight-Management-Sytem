package com.fms.flight_management_system.service.impl;

import com.fms.flight_management_system.model.Address;
import com.fms.flight_management_system.model.Passengers;
import com.fms.flight_management_system.repository.PassengerRepository;
import com.fms.flight_management_system.rest.dtos.PassengerRequestDto;
import com.fms.flight_management_system.rest.dtos.PassengerResponseDto;
import com.fms.flight_management_system.service.PassengerService;
import com.fms.flight_management_system.util.MD5Util;
import com.fms.flight_management_system.util.PassengersUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author <a>Pulkit Aggarwal</a>
 * @version 1.0
 * @since 23/05/22
 */
@AllArgsConstructor
@Slf4j
@Service
public class PassengerServiceImpl implements PassengerService {

	private final PassengerRepository passengerRepository;
	private final PassengersUtil passengersUtil;
	private final MD5Util md5Util;

	@Override public List<Passengers> getAllPassengers() {

		return passengerRepository.findAll();
	}

	@Override public Optional<Passengers> getPassengerByEmailAndPhoneNumber(String email, Long phoneNumber) {

		log.info("Searching By Passenger Email {} and PhoneNumber {} ", email, phoneNumber);

		return passengerRepository.findPassengersByPassengerUniqueId(email)
				.or(() -> passengerRepository.findPassengersByEmailAndPhoneNumber(email, phoneNumber))
				.or(() -> findByEmail(email))
				.or(() -> findByPhoneNUmber(phoneNumber));

	}

	private Optional<Passengers> findByEmail(String email) {

		log.info("Searching By Passenger Email {} ", email);

		return passengerRepository.findByEmail(email);
	}

	private Optional<Passengers> findByPhoneNUmber(Long phoneNumber) {

		log.info("Searching By Passenger PhoneNumber {} ", phoneNumber);

		return passengerRepository.findPassengersByPhoneNumber(phoneNumber);
	}

	@Override public PassengerResponseDto savePassenger(PassengerRequestDto passengerRequestDto) {

		Optional<Passengers> passengersOptional = getPassengerByEmailAndPhoneNumber(passengerRequestDto.getEmail(), passengerRequestDto.getPhoneNumber());

		if (passengersOptional.isPresent()) {
			log.info("Passenger is already present and update Passenger with email {}, phoneNumber {} ", passengerRequestDto.getEmail(), passengerRequestDto.getPhoneNumber());

			updatePassengerByDetails(passengerRequestDto, passengersOptional.get());

			return passengersUtil.buildPassengerResponseDto(passengersOptional.get());
		}

		Passengers passengers = new Passengers();
		Address address = new Address();

		passengers.setFirstName(passengerRequestDto.getFirstName());
		passengers.setLastName(passengerRequestDto.getLastName());
		passengers.setEmail(passengerRequestDto.getEmail());
		passengers.setPhoneNumber(passengerRequestDto.getPhoneNumber());
		passengers.setPassengerUniqueId(md5Util.generateMD5(passengerRequestDto.getEmail()));
		address.setCity(passengerRequestDto.getCity());
		address.setCountry(passengerRequestDto.getCountry());
		address.setDistrict(passengerRequestDto.getDistrict());
		address.setPostalCode(passengerRequestDto.getPostalCode());
		address.setState(passengerRequestDto.getState());

		passengers.setAddress(address);

		log.info("Passenger is saved with email {}, phoneNumber {} ", passengers.getEmail(), passengers.getPhoneNumber());

		passengerRepository.save(passengers);

		return passengersUtil.buildPassengerResponseDto(passengers);
	}

	@Transactional @Override public void deletePassengerByEmail(String email) {

		passengerRepository.deleteByEmail(email);

	}

	@Override public void deletePassengerById(UUID id) {
		passengerRepository.deleteById(id);
	}

	private void updatePassengerByDetails(PassengerRequestDto passengerRequestDto, Passengers existingPassengers) {

		log.info("Update Passengers Basic Details Not updating Email");

		Address address = new Address();

		existingPassengers.setFirstName(passengerRequestDto.getFirstName());
		existingPassengers.setLastName(passengerRequestDto.getLastName());
		existingPassengers.setPhoneNumber(passengerRequestDto.getPhoneNumber());
		address.setCity(passengerRequestDto.getCity());
		address.setCountry(passengerRequestDto.getCountry());
		address.setDistrict(passengerRequestDto.getDistrict());
		address.setPostalCode(passengerRequestDto.getPostalCode());
		address.setState(passengerRequestDto.getState());

		passengerRepository.save(existingPassengers);
	}

	@Override public PassengerResponseDto getPassengerById(UUID uuid) {

		Optional<Passengers> passengers = passengerRepository.findById(uuid);

		return passengers.map(passengersUtil::buildPassengerResponseDto).orElse(null);

	}
}
