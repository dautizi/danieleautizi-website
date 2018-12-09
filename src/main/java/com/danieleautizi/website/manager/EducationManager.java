package com.danieleautizi.website.manager;

import com.danieleautizi.website.model.presentation.Education;

import java.util.List;

/**
 * Manager for {@link Education} operations.
 */
public interface EducationManager {

    /**
     * Find all Educations
     * @return List<Education>
     */
    List<Education> getEducations();
}
