package com.danieleautizi.website.controller;

import com.danieleautizi.website.configuration.GoogleProperties;
import com.danieleautizi.website.configuration.StaticProperties;
import com.danieleautizi.website.controller.dictionary.RequestDictionary;
import com.danieleautizi.website.manager.AdventureManager;
import com.danieleautizi.website.manager.BlogManager;
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
    private SkillManager skillManager;
    @NonNull
    private WorkExperienceManager workExperienceManager;

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(HttpServletRequest request) {

        // get the Adventures
        val adventures = adventureManager.getAdventures();
        request.setAttribute(RequestDictionary.ADVENTURES, adventures);

        // set the Adventure Types
        val adventureTypes = adventureManager.getAdventureTypes();
        request.setAttribute(RequestDictionary.ADVENTURE_TYPES, adventureTypes);

        // set the Blogs
        val blogs = blogManager.getBlogs();
        request.setAttribute(RequestDictionary.BLOGS, blogs);

        // set Skills
        val skillMap = skillManager.getSkills();
        request.setAttribute(RequestDictionary.SKILL_MAP, skillMap);

        // set WorkExperiences
        val workExperiences = workExperienceManager.getWorkExperiences();
        request.setAttribute(RequestDictionary.WORK_EXPERIENCES, workExperiences);

        request.setAttribute("staticConfig", staticProperties);
        request.setAttribute("googleConfig", googleProperties);
        return "/home";
    }
}
