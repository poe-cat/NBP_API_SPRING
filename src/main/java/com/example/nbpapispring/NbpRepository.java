package com.example.nbpapispring;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NbpRepository extends JpaRepository<NbpEntity, Long> {
}
