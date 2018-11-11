package com.danieleautizi.website.manager;

import com.danieleautizi.website.model.presentation.Skill;

import java.util.List;

/**
 * Manager for {@link Skill} operations.
 */
public interface SkillManager {

    /**
     * Find all Skills
     * @return List<Skill>
     */
    List<Skill> getSkills();

}
