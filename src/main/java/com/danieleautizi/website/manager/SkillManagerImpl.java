package com.danieleautizi.website.manager;

import com.danieleautizi.website.model.presentation.Skill;
import com.danieleautizi.website.service.PersonalDataService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillManagerImpl implements SkillManager {

    @NonNull
    private final PersonalDataService personalDataService;

    /**
     * Find all Skills
     * @return List<Skill>
     */
    @Override
    public List<Skill> getSkills() {

        return personalDataService.getSkills();
    }

}
