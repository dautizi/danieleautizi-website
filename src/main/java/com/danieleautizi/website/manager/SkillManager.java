package com.danieleautizi.website.manager;

import com.danieleautizi.website.model.presentation.Skill;

import java.util.List;
import java.util.Map;

/**
 * Manager for {@link Skill} operations.
 */
public interface SkillManager {

    /**
     * Find all Skills grouped by GroupName
     * @return Map<String, List<Skill>>
     */
    Map<String, List<Skill>> getSkills();
}
