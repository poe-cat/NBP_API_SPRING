package com.example.nbpapispring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class NbpRepositoryTest {

    @Autowired
    private NbpRepository nbpRepository;

    @Test
    public void testSave() {
        NbpEntity nbpEntity = new NbpEntity();
        nbpEntity.setData("USD");
        nbpEntity = nbpRepository.save(nbpEntity);
        assertNotNull(nbpEntity.getId());
    }

    @Test
    public void testFindAll() {
        NbpEntity nbpEntity = new NbpEntity();
        nbpEntity.setData("USD");
        nbpRepository.save(nbpEntity);

        int expectedSize = 1;
        assertEquals(expectedSize, nbpRepository.findAll().size());
    }
}
