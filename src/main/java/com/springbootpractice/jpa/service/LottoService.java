package com.springbootpractice.jpa.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootpractice.jpa.entity.lotto.LottoWinningNumbers;
import com.springbootpractice.jpa.entity.lotto.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class LottoService {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public LottoService(ObjectMapper objectMapper) {
        this.restTemplate = new RestTemplate();
        this.objectMapper = objectMapper;
    }


    public LottoWinningNumbers getLottoResult(Long id) throws JsonProcessingException {

        String url = "https://gateway.mylotto.co.nz/api/results/v1/results/lotto/";

        String result = restTemplate.getForObject(url + id, String.class);
        log.debug(result);
        Result lottoResult = objectMapper.readValue(result, Result.class);

        LottoWinningNumbers lottoWinningNumbers = lottoResult.lotto.lottoWinningNumbers;
        lottoWinningNumbers.setPowerballWinningNumber(lottoResult.getPowerBall().getPowerballWinningNumber());
        log.debug("drawDate: {}",lottoResult.getLotto().getDrawDate());
        log.debug("drawDay: {}",lottoResult.getLotto().getDrawDay().getWeekDay());

        return lottoResult.lotto.lottoWinningNumbers;

    }
}
