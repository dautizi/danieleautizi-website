package com.danieleautizi.website.manager;

import com.danieleautizi.website.model.presentation.Adventure;

import java.util.List;
import java.util.Set;

/**
 * Manager for {@link Adventure} operations.
 */
public interface AdventureManager {

    /**
     * Find an Adventure by its id
     * @param adventureId
     * @return Adventure
     */
    Adventure getAdventureById(final String adventureId);

    /**
     * Find all Adventures
     * @return List<Adventure>
     */
    List<Adventure> getAdventures();

    /**
     * Get all adventure types
     * @return List<String> types
     */
    Set<String> getAdventureTypes();
}
