package com.challenge.api.rest_challenge.controller;

import com.challenge.api.rest_challenge.dto.TopicoDTO;
import com.challenge.api.rest_challenge.service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @GetMapping()
    public List<TopicoDTO> obtenerTopicos(){
        return topicoService.obtenerTodosLosTopicos();
    }
}
