package com.drivebuzz.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

	private OfferService offerService;
	private UserService userService;

	@Autowired
	public OfferRestController(OfferService offerService, UserService userService) {
		this.offerService = offerService;
		this.userService = userService;
	}
	
	@GetMapping("/offers")
	public List<Offer> findAll() {
		
		return offerService.findAll();
	}
	
	@GetMapping("/offers/active")
	public List<Offer> findAllActive() {
		
		return offerService.findAllActive();
	}
	
	@GetMapping("/offers/inactive")
	public List<Offer> findAllInactive() {
		
		return offerService.findAllInactive();
	}
	
	@GetMapping("/offers/latest/{pageNumber}")
	public List<Offer> findLatestOffersByPage(@PathVariable int pageNumber) {
		
		List<Offer> offers = offerService.findLatestOffersByPage(pageNumber);
		
		if (offers.isEmpty()) {
			throw new RuntimeException("There are no offers for page: " + pageNumber);
		}
		
		return offers;
	}
	
	@GetMapping("/offers/today/{pageNumber}")
	public List<Offer> findTodayOffersByPage(@PathVariable int pageNumber) {
		
		List<Offer> offers = offerService.findTodayOffersByPage(pageNumber);
		
		if (offers.isEmpty()) {
			throw new RuntimeException("There are no offers for page: " + pageNumber);
		}
		
		return offers;
	}
	
	@GetMapping("/offers/next-7-days/{pageNumber}")
	public List<Offer> findNextSevenDaysOffersByPage(@PathVariable int pageNumber) {
		
		List<Offer> offers = offerService.findNextSevenDaysOffersByPage(pageNumber);
		
		if (offers.isEmpty()) {
			throw new RuntimeException("There are no offers for page: " + pageNumber);
		}
		
		return offers;
	}
	
	@GetMapping("/offers/next-month/{pageNumber}")
	public List<Offer> findNextMonthOffersByPage(@PathVariable int pageNumber) {
		
		List<Offer> offers = offerService.findNextMonthOffersByPage(pageNumber);
		
		if (offers.isEmpty()) {
			throw new RuntimeException("There are no offers for page: " + pageNumber);
		}
		
		return offers;
	}

	@GetMapping("/offers/{offerId}")
	public Offer getOffer(@PathVariable int offerId) {
		
		Offer theOffer = offerService.findById(offerId);
		
		if (theOffer == null) {
			throw new RuntimeException("Offer id not found - " + offerId);
		}
		
		return theOffer;
	}
	
	@GetMapping("/offers/user/{userId}")
	public List<Offer> getOffersForSpecificUser(@PathVariable int userId) {
		
		User theUser = userService.findById(userId);
		
		if (theUser == null) {
			throw new RuntimeException("User with id: "+ userId +" does not exist.");
		}
		
		return theUser.getOffers();
	}
	
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
			throw new RuntimeException("Offer id not found - " + offerId);
		}
		
		offerService.deleteById(offerId);
		
		return "Deleted offer with id: " + offerId;
	}
	
}
