package com.heyma.service.core.model.repository.app;

import com.heyma.service.core.model.entity.app.ClientAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientAddressRepository extends JpaRepository<ClientAddress, Long> {

}