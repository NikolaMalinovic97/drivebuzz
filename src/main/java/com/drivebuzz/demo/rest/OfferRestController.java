package com.drivebuzz.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.GetMapping;
>>>>>>> Implemented finding offer by id in 'OfferRestController'.
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drivebuzz.demo.entity.Offer;
import com.drivebuzz.demo.entity.User;
import com.drivebuzz.demo.service.OfferService;
import com.drivebuzz.demo.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/offer-api")
public class OfferRestController {

	OfferService offerService;
	UserService userService;

	@Autowired
	public OfferRestController(OfferService offerService, UserService userService) {
		this.offerService = offerService;
		this.userService = userService;
	}
	
<<<<<<< HEAD
=======
	@GetMapping("/offers/{offerId}")
	public Offer getOffer(@PathVariable int offerId) {
		
		Offer theOffer = offerService.findById(offerId);
		
		if (theOffer == null) {
			throw new RuntimeException("Offer id not found - " + offerId);
		}
		
		return theOffer;
	}
	
>>>>>>> Implemented finding offer by id in 'OfferRestController'.
	@PostMapping("/offers/{userId}")
	public Offer addOffer(@PathVariable int userId, @RequestBody Offer theOffer) {
				
		User theUser = userService.findById(userId);
		theUser.addOffer(theOffer);
		
		theOffer.setId(0);
		
		offerService.save(theOffer);
		
		return theOffer;
	}
	
	@DeleteMapping("/offers/{offerId}")
	public String deleteOffer(@PathVariable int offerId) {
		
		Offer theOffer = offerService.findById(offerId);
		
		if (theOffer == null) {
			throw new RuntimeException("User id not found - " + offerId);
		}
		
		offerService.deleteById(offerId);
		
		return "Deleted offer with id: " + offerId;
	}
	
}
