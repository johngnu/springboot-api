package com.heyma.service.core.service.app;

import com.heyma.service.core.controller.vo.ClientVo;
import com.heyma.service.core.model.dao.Dao;
import com.heyma.service.core.model.entity.app.Client;
import com.heyma.service.core.model.repository.app.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    Dao dao;

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<ClientVo> getVo(long id) {
        Map<String, Object> result = (Map<String, Object>) dao.executeSigleResult("SELECT cli.id, cli.complete_name, cli.birthday, (SELECT description FROM config.parameter_item WHERE parameter_id = 11 AND approved = cli.gender) gender, cli.email, cli.mobile_number, cli.nit, cli.business_name, cli.enabled \n" +
                "            FROM dms.client cli \n" +
                "            WHERE cli.\"id\" = " + id);
        if (result != null) {
            ClientVo clientVo = new ClientVo();
            clientVo.setId(Long.parseLong(result.get("id").toString()));
            clientVo.setCompleteName(result.get("complete_name").toString());
            clientVo.setBirthday(result.get("birthday") != null ? result.get("birthday").toString() : null);
            clientVo.setGender((String) result.get("gender"));
            clientVo.setEmail(result.get("email").toString());
            clientVo.setMobileNumber(result.get("mobile_number").toString());
            clientVo.setNit((String) result.get("nit"));
            clientVo.setBusinessName((String) result.get("business_name"));
            clientVo.setEnabled((Boolean) result.get("enabled"));
            return Optional.of(clientVo);
        }

        return Optional.empty();
    }

    @Override
    public Optional<Client> get(long id) {
        return clientRepository.findById(id);
    }

    @Override
    public void update(Client client) {
        clientRepository.save(client);
    }
}