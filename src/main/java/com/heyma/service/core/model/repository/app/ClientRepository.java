package com.heyma.service.core.model.repository.app;

import com.heyma.service.core.model.entity.app.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query(value = "SELECT cli.id, cli.complete_name, cli.birthday, (SELECT description FROM config.parameter_item WHERE parameter_id = 11 AND approved = cli.gender) gender, cli.email, cli.mobile_number, cli.nit, cli.business_name, cli.enabled \n" +
            "FROM dms.client cli\n" +
            "WHERE cli.\"id\" = :clientId", nativeQuery = true)
    Object[] findByClientId(@Param("clientId") long clientId);
}
