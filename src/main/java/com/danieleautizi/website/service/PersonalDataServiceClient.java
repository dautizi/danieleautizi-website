package com.danieleautizi.website.service;

import com.danieleautizi.website.model.presentation.Adventure;
import com.danieleautizi.website.model.presentation.Article;
import com.danieleautizi.website.model.presentation.Blog;
import com.danieleautizi.website.model.presentation.Education;
import com.danieleautizi.website.model.presentation.Skill;
import com.danieleautizi.website.model.presentation.WorkExperience;
import com.danieleautizi.website.service.utils.UrlParamsBuilder;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Service implementation to get Personal Data info.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PersonalDataServiceClient {

    @NonNull
    private final RestTemplate restTemplate;

    public Adventure getAdventure(final String adventureId) {

        val urlVariables = UrlParamsBuilder.start()
                                           .put("adventureId", adventureId)
                                           .build();

        return restTemplate.getForObject("http://personalDataService/adventures/{adventureId}",
                                         Adventure.class,
                                         urlVariables);
    }

    public List<Adventure> getActiveAdventures() {

        return restTemplate.getForObject("http://personalDataService/adventures/active",
                                         Adventures.class);
    }

    public Set<String> getAdventureTypes() {

        return restTemplate.getForObject("http://personalDataService/adventures/types",
                                         AdventureTypes.class);
    }

    public Article getArticle(final String articleId) {

        val urlVariables = UrlParamsBuilder.start()
                                           .put("articleId", articleId)
                                           .build();

        return restTemplate.getForObject("http://personalDataService/articles/{articleId}",
                                         Article.class,
                                         urlVariables);
    }

    public List<Article> getActiveArticles() {

        return restTemplate.getForObject("http://personalDataService/articles/active",
                                         Articles.class);
    }

    public Blog getBlog(final String blogId) {

        val urlVariables = UrlParamsBuilder.start()
                                           .put("blogId", blogId)
                                           .build();

        return restTemplate.getForObject("http://personalDataService/blogs/{blogId}",
                                         Blog.class,
                                         urlVariables);
    }

    public List<Blog> getActiveBlogs() {

        return restTemplate.getForObject("http://personalDataService/blogs/active",
                                         Blogs.class);
    }

    public List<Education> getActiveEducations() {

        return restTemplate.getForObject("http://personalDataService/educations/active",
                                         Educations.class);
    }

    public List<Skill> getActiveSkills() {

        return restTemplate.getForObject("http://personalDataService/skills/active",
                                         Skills.class);
    }

    public List<WorkExperience> getActiveWorkExperiences() {

        return restTemplate.getForObject("http://personalDataService/work-experiences/active",
                                         WorkExperiences.class);
    }

    private static class Adventures extends ArrayList<Adventure> {}
    private static class AdventureTypes extends HashSet<String> {}
    private static class Articles extends ArrayList<Article> {}
    private static class Blogs extends ArrayList<Blog> {}
    private static class Educations extends ArrayList<Education> {}
    private static class Skills extends ArrayList<Skill> {}
    private static class WorkExperiences extends ArrayList<WorkExperience> {}
}
