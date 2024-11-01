package io.benny.finance_backend.controllers;

import io.benny.finance_backend.models.UserPreference;
import io.benny.finance_backend.services.UserPreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/preferences")
public class UserPreferenceController {

    private final UserPreferenceService service;

    @Autowired
    public UserPreferenceController(UserPreferenceService service) {
        this.service = service;
    }

    // Existing CRUD operations
    @GetMapping
    public Iterable<UserPreference> getPreferences() {
        return service.readAllPreferences();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserPreference> getPreference(@PathVariable Long id) {
        UserPreference preference = service.readOnePreference(id);
        return preference != null
                ? new ResponseEntity<>(preference, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createPreference(@RequestBody UserPreference preference) {
        service.createUserPreference(preference);
        return new ResponseEntity<>("User preference created", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePreference(@PathVariable Long id, @RequestBody UserPreference preference) {
        service.updateUserPreference(id, preference);
        return new ResponseEntity<>("User preference updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePreference(@PathVariable Long id) {
        service.deleteUserPreference(id);
        return new ResponseEntity<>("User preference deleted", HttpStatus.OK);
    }

    // New endpoints for mock financial data
    @GetMapping("/stock/{ticker}")
    public ResponseEntity<String> getMockStockPrice(@PathVariable String ticker) {
        String stockPrice = service.getMockStockPrice(ticker);
        return new ResponseEntity<>(stockPrice, HttpStatus.OK);
    }

    @GetMapping("/exchange/{currencyPair}")
    public ResponseEntity<String> getMockExchangeRate(@PathVariable String currencyPair) {
        String exchangeRate = service.getMockExchangeRate(currencyPair);
        return new ResponseEntity<>(exchangeRate, HttpStatus.OK);
    }
}
