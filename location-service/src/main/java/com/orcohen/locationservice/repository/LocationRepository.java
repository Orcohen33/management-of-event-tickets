package com.orcohen.locationservice.repository;

import com.orcohen.locationservice.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
