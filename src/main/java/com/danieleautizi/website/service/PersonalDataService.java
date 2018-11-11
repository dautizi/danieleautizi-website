package com.danieleautizi.website.service;

import com.danieleautizi.website.exception.InternalServerErrorException;
import com.danieleautizi.website.model.presentation.Adventure;
import com.danieleautizi.website.model.presentation.Article;
import com.danieleautizi.website.model.presentation.Blog;
import com.danieleautizi.website.model.presentation.Education;
import com.danieleautizi.website.model.presentation.Skill;
import com.danieleautizi.website.model.presentation.WorkExperience;
import com.danieleautizi.website.service.utils.MessageService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Service implementation to get Personal Data information.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PersonalDataService {

    private static final String HYSTRIX_KEY = "personalDataService";

    @NonNull
    private final PersonalDataServiceClient personalServiceClient;

    @NonNull
    private final MessageService messageService;


    /* Adventure [begin] */
    @HystrixCommand(commandKey = HYSTRIX_KEY, threadPoolKey = HYSTRIX_KEY)
    public Adventure getAdventure(final String adventureId) {

        try {

            return personalServiceClient.getAdventure(adventureId);
        } catch (final Exception ex) {

            LOG.error("Could not store file", ex);
            throw new InternalServerErrorException(messageService.getMessage("service.personalDataService.failure"));
        }

    }

    @HystrixCommand(commandKey = HYSTRIX_KEY, threadPoolKey = HYSTRIX_KEY)
    public List<Adventure> getAdventures() {

        return personalServiceClient.getActiveAdventures();
    }

    @HystrixCommand(commandKey = HYSTRIX_KEY, threadPoolKey = HYSTRIX_KEY)
    public Set<String> getAdventureTypes() {

        return personalServiceClient.getAdventureTypes();
    }
    /* Adventure [end] */


    /* Article [begin] */
    @HystrixCommand(commandKey = HYSTRIX_KEY, threadPoolKey = HYSTRIX_KEY)
    public Article getArticle(final String articleId) {

        return personalServiceClient.getArticle(articleId);
    }

    @HystrixCommand(commandKey = HYSTRIX_KEY, threadPoolKey = HYSTRIX_KEY)
    public List<Article> getArticles() {

        return personalServiceClient.getActiveArticles();
    }
    /* Article [end] */


    /* Blog [begin] */
    @HystrixCommand(commandKey = HYSTRIX_KEY, threadPoolKey = HYSTRIX_KEY)
    public Blog getBlog(final String blogId) {

        return personalServiceClient.getBlog(blogId);
    }

    @HystrixCommand(commandKey = HYSTRIX_KEY, threadPoolKey = HYSTRIX_KEY)
    public List<Blog> getBlogs() {

        return personalServiceClient.getActiveBlogs();
    }
    /* Blog [end] */


    /* Education [begin] */
    @HystrixCommand(commandKey = HYSTRIX_KEY, threadPoolKey = HYSTRIX_KEY)
    public List<Education> getEducations() {

        return personalServiceClient.getActiveEducations();
    }
    /* Education [end] */


    /* Skill [begin] */
    @HystrixCommand(commandKey = HYSTRIX_KEY, threadPoolKey = HYSTRIX_KEY)
    public List<Skill> getSkills() {

        return personalServiceClient.getActiveSkills();
    }
    /* Skill [end] */


    /* Work Experience [begin] */
    @HystrixCommand(commandKey = HYSTRIX_KEY, threadPoolKey = HYSTRIX_KEY)
    public List<WorkExperience> getWorkExperiences() {

        return personalServiceClient.getActiveWorkExperiences();
    }
    /* Work Experience [end] */

}
