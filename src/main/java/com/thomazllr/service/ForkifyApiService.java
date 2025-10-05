package com.thomazllr.service;

import com.thomazllr.controller.dto.ForkifySearchResponse;
import com.thomazllr.exception.ForkifySearchException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientResponseException;

@Service
@RequiredArgsConstructor
public class ForkifyApiService {

    private final RestClient forkifyApiClient;

    public ForkifySearchResponse search(String query) {
        try {
            return forkifyApiClient.get()
                    .uri(uri -> uri.path("/search").queryParam("q", query).build())
                    .retrieve()
                    .body(ForkifySearchResponse.class);
        } catch (RestClientResponseException e) {
            throw new ForkifySearchException(query);
        }
    }


}
