package com.heyma.service.core.controller.v1;

import com.heyma.service.core.controller.dto.ParameterDto;
import com.heyma.service.core.model.entity.config.Parameter;
import com.heyma.service.core.util.RestConstant;
import com.heyma.service.core.util.ResultResponse;
import com.heyma.service.core.service.config.ParameterItemService;
import com.heyma.service.core.service.config.ParameterService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Log4j2
@CrossOrigin
@RestController
@RequestMapping("/api/v1/parameters")
public class ParameterController {

    @Autowired
    ParameterService parameterService;
    @Autowired
    ParameterItemService parameterItemService;

    @GetMapping
    public ResponseEntity<?> findAll(String identifier) {
        if (identifier != null) {
            Optional<Parameter> parameter = parameterService.findByIdentifier(identifier);
            if (parameter.isPresent()) {
                return new ResponseEntity<>(ResultResponse.builder().status(true).message(RestConstant.RESPONSE_FIND_SUCCESSFULLY).data(parameterItemService.findAllByParameterId(parameter.get().getId())).build(),
                        HttpStatus.OK);
            }
            return new ResponseEntity<>(ResultResponse.builder().status(false).message("Identificador no encontrado").data(null).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResultResponse.builder().status(true).message(RestConstant.RESPONSE_FIND_SUCCESSFULLY).data(parameterService.findAll()).build(),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") long id) {
        Optional<Parameter> parametro = parameterService.get(id);
        return parametro.map(value -> new ResponseEntity<>(ResultResponse.builder().status(true).message(RestConstant.RESPONSE_FIND_SUCCESSFULLY).data(value).build(), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(ResultResponse.builder().status(false).message(RestConstant.RESPONSE_NOT_FOUND_RECORD + id).data(null).build(), HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<?> persist(@RequestBody ParameterDto parameterDto) {
        if (!parameterService.findByIdentifier(parameterDto.getIdentifier()).isPresent()) {
            Parameter parameter = parameterService.persist(parameterDto);
            log.info(RestConstant.LOG_PERSIST, parameter.getId());
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(RestConstant.RESPONSE_PERSIST_SUCCESSFULY).data(parameter.getId()).build(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(ResultResponse.builder().status(false).message("Identificador ya registrado").data(null).build(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ParameterDto parameterDto) {
        Optional<Parameter> parameter = parameterService.get(id);
        if (parameter.isPresent()) {
            parameterService.update(parameter.get(), parameterDto);
            log.info(RestConstant.LOG_UPDATE, id);
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(RestConstant.RESPONSE_UPDATE_SUCCESSFULY).data(parameter.get().getId()).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResultResponse.builder().status(false).message(RestConstant.RESPONSE_NOT_FOUND_RECORD + id).data(null).build(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        Optional<Parameter> parametro = parameterService.get(id);
        if (parametro.isPresent()) {
            parameterService.delete(parametro.get());
            log.info(RestConstant.LOG_DELETE, id);
            return new ResponseEntity<>(ResultResponse.builder().status(true).message(RestConstant.RESPONSE_UPDATE_SUCCESSFULY).data(parametro.get().getId()).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(ResultResponse.builder().status(false).message(RestConstant.RESPONSE_NOT_FOUND_RECORD + id).data(null).build(), HttpStatus.OK);
    }
}
