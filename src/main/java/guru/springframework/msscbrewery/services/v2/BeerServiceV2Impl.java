package guru.springframework.msscbrewery.services.v2;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.msscbrewery.web.model.v2.BeerDtoV2;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jt on 2019-04-20.
 */
@Slf4j
@Service
public class BeerServiceV2Impl implements BeerServiceV2 {
	@Override
	public BeerDtoV2 getBeerById(UUID beerId) {
		return BeerDtoV2.builder().id(UUID.randomUUID()).beerName("Galaxy Cat").beerStyle("Pale Ale").build();
	}

	@Override
	public BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto) {
		return BeerDtoV2.builder().id(UUID.randomUUID()).build();
	}

	@Override
	public void updateBeer(UUID beerId, BeerDtoV2 beerDto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBeer(UUID beerId) {
		log.debug("Deleting");
	}
}
