package com.example.nbpapispring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
class APIControllerTest {
    @Mock
    RestTemplate restTemplate;
    @Mock
    NbpRepository nbpRepository;
    @InjectMocks
    APIController apiController;

    @Test
    void testGetNbpData() {

        //given
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/eur/";
        String expectedData = "{\"table\":\"A\",\"currency\":\"euro\",\"code\"" +
                ":\"EUR\",\"rates\":[{\"no\":\"020/A/NBP/2021\",\"effectiveDate\"" +
                ":\"2021-03-03\",\"mid\":4.7166}]}";

        //when
        when(restTemplate.getForEntity(url, String.class))
                .thenReturn(new ResponseEntity<>(expectedData, HttpStatusCode.valueOf(200)));
        String actualData = apiController.getNbpData();

        //then
        assertEquals("Data saved to database!", actualData);
    }
}
