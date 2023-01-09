package com.example.nbpapispring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
class APIController {

    @Autowired
    private RestTemplate restTemplate;

        @Autowired
        private NbpRepository nbpRepository;

    @GetMapping("/nbp")
    public String getNbpData() {
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/eur/";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        String nbpData = response.getBody();

        // Save the data to the database
        NbpEntity nbpEntity = new NbpEntity();
        nbpEntity.setData(nbpData);
        nbpRepository.save(nbpEntity);

        return "Data saved to database!";
    }
}