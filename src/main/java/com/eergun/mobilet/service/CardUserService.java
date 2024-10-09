package com.eergun.mobilet.service;

import com.eergun.mobilet.entity.CardUser;
import com.eergun.mobilet.repository.CardUserRepository;
import com.eergun.mobilet.view.VwCardUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CardUserService{
	private final CardUserRepository cardUserRepository;
	
	public List<CardUser> findAllByNameContaining(String name){
		return cardUserRepository.findAllByNameContainingIgnoreCase(name);
	}

	public VwCardUser save(CardUser cardUser) {
		cardUserRepository.save(cardUser);
		return VwCardUser.builder()
				                           .phone(cardUser.getPhone())
				                           .adress(cardUser.getAdress())
				                           .lastName(cardUser.getLastName())
				                           .name(cardUser.getName())
		                                     .build();
	}
}