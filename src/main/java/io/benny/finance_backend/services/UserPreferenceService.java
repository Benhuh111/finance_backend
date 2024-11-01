package io.benny.finance_backend.services;

import io.benny.finance_backend.models.UserPreference;
import io.benny.finance_backend.repositories.UserPreferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserPreferenceService {

    private final UserPreferenceRepository repository;

    // Mock data for stock prices and exchange rates
    private final Map<String, String> stockPrices = new HashMap<>();
    private final Map<String, String> exchangeRates = new HashMap<>();

    @Autowired
    public UserPreferenceService(UserPreferenceRepository repository) {
        this.repository = repository;

        // Initialize static mock data
        stockPrices.put("AAPL", "150.00");
        stockPrices.put("GOOGL", "2800.00");
        exchangeRates.put("USDEUR", "0.85");
        exchangeRates.put("USDJPY", "110.00");
    }

    public void createUserPreference(UserPreference userPreference) {
        repository.save(userPreference);
    }

    public Iterable<UserPreference> readAllPreferences() {
        return repository.findAll();
    }

    public UserPreference readOnePreference(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void updateUserPreference(Long id, UserPreference updatedPreference) {
        Optional<UserPreference> existingPreference = repository.findById(id);

        if (existingPreference.isPresent()) {
            UserPreference preference = existingPreference.get();

            preference.setPreferenceKey(updatedPreference.getPreferenceKey());
            preference.setPreferenceValue(updatedPreference.getPreferenceValue());
            preference.setFavoriteStock(updatedPreference.getFavoriteStock());
            preference.setCurrencyPair(updatedPreference.getCurrencyPair());

            repository.save(preference);
        }
    }

    public void deleteUserPreference(Long id) {
        repository.deleteById(id);
    }

    // New methods to retrieve mock financial data
    public String getMockStockPrice(String ticker) {
        return stockPrices.getOrDefault(ticker, "Stock not available");
    }

    public String getMockExchangeRate(String currencyPair) {
        return exchangeRates.getOrDefault(currencyPair, "Exchange rate not available");
    }
}
