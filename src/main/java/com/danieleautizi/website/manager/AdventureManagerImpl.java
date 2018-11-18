package com.danieleautizi.website.manager;

import com.danieleautizi.website.model.presentation.Adventure;
import com.danieleautizi.website.service.PersonalDataService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AdventureManagerImpl implements AdventureManager {

    @NonNull
    private final PersonalDataService personalDataService;

    /**
     * Find an Adventure by its id
     * @param adventureId
     * @return Adventure
     */
    @Override
    public Adventure getAdventureById(final String adventureId) {

        return personalDataService.getAdventure(adventureId);
    }

    /**
     * Find all Adventures
     * @return List<Adventure>
     */
    @Override
    public List<Adventure> getAdventures() {

        return personalDataService.getAdventures();
    }

    /**
     * Get all adventure types
     * @return types in String
     */
    public Set<String> getAdventureTypes() {

        return personalDataService.getAdventureTypes();
    }
}
