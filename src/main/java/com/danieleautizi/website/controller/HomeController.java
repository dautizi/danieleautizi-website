package com.danieleautizi.website.controller;

import com.danieleautizi.website.configuration.GoogleProperties;
import com.danieleautizi.website.configuration.StaticProperties;
import com.danieleautizi.website.controller.dictionary.RequestDictionary;
import com.danieleautizi.website.manager.AdventureManager;
import com.danieleautizi.website.manager.BlogManager;
import com.danieleautizi.website.manager.CurriculumVitaeManager;
import com.danieleautizi.website.manager.EducationManager;
import com.danieleautizi.website.manager.SkillManager;
import com.danieleautizi.website.manager.WorkExperienceManager;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

    @NonNull
    private StaticProperties staticProperties;
    @NonNull
    private GoogleProperties googleProperties;

    @NonNull
    private AdventureManager adventureManager;
    @NonNull
    private BlogManager blogManager;
    @NonNull
    private CurriculumVitaeManager curriculumVitaeManager;
    @NonNull
    private EducationManager educationManager;
    @NonNull
    private SkillManager skillManager;
    @NonNull
    private WorkExperienceManager workExperienceManager;

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(HttpServletRequest request) {

        // fetch adventures
        val adventures = adventureManager.getAdventures();
        request.setAttribute(RequestDictionary.ADVENTURES, adventures);

        // filter adventure types
        val adventureTypes = adventureManager.getAdventureTypes();
        request.setAttribute(RequestDictionary.ADVENTURE_TYPES, adventureTypes);

        // fetch blogs
        val blogs = blogManager.getBlogs();
        request.setAttribute(RequestDictionary.BLOGS, blogs);

        // fetch last curriculum vitae
        val curriculumVitae = curriculumVitaeManager.getCurriculumVitae();
        request.setAttribute(RequestDictionary.CURRICULUM_VITAE, curriculumVitae);

        // fetch educations
        val educations = educationManager.getEducations();
        request.setAttribute(RequestDictionary.EDUCATIONS, educations);

        // fetch skills
        val skillMap = skillManager.getSkills();
        request.setAttribute(RequestDictionary.SKILL_MAP, skillMap);

        // fetch work experiences
        val workExperiences = workExperienceManager.getWorkExperiences();
        request.setAttribute(RequestDictionary.WORK_EXPERIENCES, workExperiences);

        request.setAttribute("staticConfig", staticProperties);
        request.setAttribute("googleConfig", googleProperties);
        return "/home";
    }

}
