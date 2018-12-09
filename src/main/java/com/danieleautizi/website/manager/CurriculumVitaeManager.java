package com.danieleautizi.website.manager;

import com.danieleautizi.website.model.presentation.CurriculumVitae;


/**
 * Manager for {@link CurriculumVitae} operations.
 */
public interface CurriculumVitaeManager {

    /**
     * Find last active CurriculumVitae
     * @return CurriculumVitae
     */
    CurriculumVitae getCurriculumVitae();
}
