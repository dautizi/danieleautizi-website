package com.danieleautizi.website.manager;

import com.danieleautizi.website.model.presentation.Skill;
import com.danieleautizi.website.service.PersonalDataService;
import com.danieleautizi.website.utility.PersonalDataUtil;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillManagerImpl implements SkillManager {

    @NonNull
    private final PersonalDataUtil personalDataUtil;
    @NonNull
    private final PersonalDataService personalDataService;

    public static final String SKILL_NOT_FOUND_MESSAGE = "skill.error.notfound";
    public static final String SKILL_BAD_REQUEST_MESSAGE = "skill.error.badrequest";

    /**
     * Find all Skills
     * @return List<Skill>
     */
    @Override
    public List<Skill> getSkills() {

        return personalDataService.getSkills();
    }

}
