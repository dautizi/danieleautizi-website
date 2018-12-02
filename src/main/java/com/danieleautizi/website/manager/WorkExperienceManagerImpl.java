package com.danieleautizi.website.manager;

import com.danieleautizi.website.model.presentation.WorkExperience;
import com.danieleautizi.website.service.PersonalDataService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkExperienceManagerImpl implements WorkExperienceManager {

    @NonNull
    private final PersonalDataService personalDataService;

    /**
     * Find all Work experiences
     * @return List<WorkExperience>
     */
    @Override
    public List<WorkExperience> getWorkExperiences() {

        return personalDataService.getWorkExperiences();
    }

}
