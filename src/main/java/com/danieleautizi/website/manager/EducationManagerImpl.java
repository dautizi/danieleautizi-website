package com.danieleautizi.website.manager;

import com.danieleautizi.website.model.presentation.Education;
import com.danieleautizi.website.service.PersonalDataService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationManagerImpl implements EducationManager {

    @NonNull
    private final PersonalDataService personalDataService;

    /**
     * Find all Educations
     * @return List<Education>
     */
    @Override
    public List<Education> getEducations() {

        return personalDataService.getEducations();
    }
}
