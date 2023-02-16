package com.globallogic.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.config.UserDto;
import com.globallogic.models.Owner;
import com.globallogic.mongodb.repository.OwnerRepository;
@Service
public class OwnerServiceimpl implements OwnerService{
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	//@Autowired
	//private Producer publisher;
	
	@Override
	public Owner createOwnerprofile(Owner owner) {
		owner.setOwnerEmail(owner.getOwnerEmail());
		owner.setOwnerPassword(owner.getOwnerPassword());
        //publisher.sendMessageTOConsumer(userDto);
        return ownerRepository.save(owner);
	}
	@Override
	public Optional<Owner> findById(String ownerEmail){
		return ownerRepository.findById(ownerEmail);
	}
	@Override
	public Owner updateOwnerprofile(Owner owner, String ownerEmail) {
		return ownerRepository.save(owner);
	}
	@Override
	public List<Owner> getAllOwners() {
		return ownerRepository.findAll();
	}
	
	@Override
	public void deleteProfileById(String ownerEmail) {
		if(!ownerRepository.existsById(ownerEmail)) {
			throw new RuntimeException("SERVICE.GUEST_NOT_FOUND");
			
		}
		ownerRepository.deleteById(ownerEmail);
	}
	
	
}
