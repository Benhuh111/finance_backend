package io.benny.finance_backend.repositories;

import io.benny.finance_backend.models.UserPreference;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserPreferenceRepository extends CrudRepository<UserPreference, String> {
    Optional<UserPreference> findById(Long id);

    void deleteById(Long id);
}
