package com.heyma.service.core.controller.v1;

import com.heyma.service.core.util.RestConstant;
import com.heyma.service.core.util.ResultResponse;
import com.heyma.service.core.controller.vo.ClientVo;
import com.heyma.service.core.service.app.ClientService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Log4j2
@CrossOrigin
@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(ResultResponse.builder().status(true).message(RestConstant.RESPONSE_FIND_SUCCESSFULLY).data(clientService.findAll()).build(),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClient(@PathVariable("id") long id) {
        Optional<ClientVo> clientVo = clientService.getVo(id);
        if (clientVo.isPresent()) {
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(RestConstant.RESPONSE_FIND_SUCCESSFULLY).data(clientVo.get()).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResultResponse.builder().status(false).message(RestConstant.RESPONSE_NOT_FOUND_RECORD + id).data(null).build(), HttpStatus.OK);
    }

}
