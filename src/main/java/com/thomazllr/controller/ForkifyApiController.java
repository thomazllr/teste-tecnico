package com.thomazllr.controller;

import com.thomazllr.controller.dto.ForkifySearchResponse;
import com.thomazllr.controller.openapi.ForkifyApiControllerDocs;
import com.thomazllr.service.ForkifyApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/forkify")
@RequiredArgsConstructor
public class ForkifyApiController implements ForkifyApiControllerDocs {

    private final ForkifyApiService forkifyApiService;

    @GetMapping
    public ResponseEntity<ForkifySearchResponse> search(@RequestParam String query) {
        var response = forkifyApiService.search(query);
        return ResponseEntity.ok(response);
    }
}
