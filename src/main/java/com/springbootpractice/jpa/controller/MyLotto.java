package com.springbootpractice.jpa.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootpractice.jpa.entity.lotto.LottoWinningNumbers;
import com.springbootpractice.jpa.entity.lotto.Result;
import com.springbootpractice.jpa.service.LottoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("myLotto/")
@Slf4j
public class MyLotto {

    private final RestTemplate restTemplate;

    private final ObjectMapper objectMapper;

    private final LottoService lottoService;

    public MyLotto(ObjectMapper objectMapper, LottoService lottoService) {
        this.objectMapper = objectMapper;
        this.lottoService = lottoService;
        this.restTemplate = new RestTemplate();
    }


    @GetMapping("/result/{id}")
    public ResponseEntity<LottoWinningNumbers> getLottoResult(@PathVariable Long id) throws JsonProcessingException {

        LottoWinningNumbers result = lottoService.getLottoResult(id);

        return ResponseEntity.ok(result);
    }


}
