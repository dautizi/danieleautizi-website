package com.danieleautizi.website.manager;

import com.danieleautizi.website.model.presentation.Skill;
import com.danieleautizi.website.service.PersonalDataService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public Map<String, List<Skill>> getSkills() {

        val skills = personalDataService.getSkills();
        if (CollectionUtils.isEmpty(skills)) {

            return null;
        }

        return skills.stream()
                     .collect(Collectors.groupingBy(Skill::getGroupName));
    }

}
