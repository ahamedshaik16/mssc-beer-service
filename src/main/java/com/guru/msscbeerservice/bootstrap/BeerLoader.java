package com.guru.msscbeerservice.bootstrap;

import com.guru.msscbeerservice.repositories.BeerRepository;
import com.guru.msscbeerservice.domain.Beer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

//@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "080987675785";
    public static final String BEER_2_UPC = "080985475785";
    public static final String BEER_3_UPC = "870243475785";

    public static final UUID BEER_1_UUID = UUID.fromString("69855ba4-ede5-11eb-9a03-0242ac130003");
    public static final UUID BEER_2_UUID = UUID.fromString("69855df2-ede5-11eb-9a03-0242ac130003");
    public static final UUID BEER_3_UUID = UUID.fromString("69855eec-ede5-11eb-9a03-0242ac130003");

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle("IPA")
                    .minOnHand(12)
                    .qualityToBeer(200)
                    .upc(BEER_1_UPC)
                    .price(new BigDecimal("12.75"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE_ALE")
                    .minOnHand(12)
                    .qualityToBeer(200)
                    .upc(BEER_2_UPC)
                    .price(new BigDecimal("15.75"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("No Hammers")
                    .beerStyle("PALE_ALE")
                    .minOnHand(12)
                    .qualityToBeer(200)
                    .upc(BEER_3_UPC)
                    .price(new BigDecimal("15.75"))
                    .build());
        }

        System.out.println("Loaded Beers: " + beerRepository.count());
    }
}
