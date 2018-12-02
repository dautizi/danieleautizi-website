package com.danieleautizi.website.manager;

import com.danieleautizi.website.model.presentation.WorkExperience;

import java.util.List;

/**
 * Manager for {@link WorkExperience} operations.
 */
public interface WorkExperienceManager {

    /**
     * Find all Work experiences
     * @return List<WorkExperience>
     */
    List<WorkExperience> getWorkExperiences();
}
