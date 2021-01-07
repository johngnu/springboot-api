package com.heyma.service.core.service.app;

import com.heyma.service.core.controller.vo.ClientVo;
import com.heyma.service.core.model.entity.app.Client;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    @Transactional(readOnly = true)
    List<Client> findAll();

    @Transactional(readOnly = true)
    Optional<ClientVo> getVo(long id);

    @Transactional(readOnly = true)
    Optional<Client> get(long id);

    @Transactional
    void update(Client client);
}
