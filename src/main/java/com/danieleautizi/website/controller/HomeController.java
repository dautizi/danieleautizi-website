package com.danieleautizi.website.controller;

import com.danieleautizi.website.manager.SkillManager;

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
    private SkillManager skillManager;

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcome(HttpServletRequest request) {

        val skills = skillManager.getSkills();
        LOG.info("  # SKILLS # ", skills);

        request.setAttribute("name", "LogSearcher");
        return "/home";
    }
}
