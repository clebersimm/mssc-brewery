package guru.springframework.msscbrewery.web.controller.v2;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.msscbrewery.services.v2.BeerServiceV2;
import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;

/**
 * Created by jt on 2019-04-20.
 */
@RequestMapping("/api/v2/beer")
@RestController
public class BeerControllerV2 {

	private final BeerServiceV2 beerService;

	public BeerControllerV2(BeerServiceV2 beerService) {
		this.beerService = beerService;
	}

	@GetMapping({ "/{beerId}" })
	public ResponseEntity<BeerDtoV2> getBeer(@PathVariable("beerId") UUID beerId) {

		return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping
	public ResponseEntity handlePost(@RequestBody BeerDtoV2 BeerDtoV2) {

		BeerDtoV2 savedDto = beerService.saveNewBeer(BeerDtoV2);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/beer/" + savedDto.getId().toString());
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@SuppressWarnings("rawtypes")
	@PutMapping({ "/{beerId}" })
	public ResponseEntity handleUpdate(@PathVariable("beerId") UUID beerId, @RequestBody BeerDtoV2 BeerDtoV2) {
		beerService.updateBeer(beerId, BeerDtoV2);
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping({ "/{beerId}" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteBeer(@PathVariable("beerId") UUID beerId) {
		beerService.deleteBeer(beerId);
	}

}
