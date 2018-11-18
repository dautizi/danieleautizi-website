package com.danieleautizi.website.manager;

import com.danieleautizi.website.model.presentation.Blog;
import com.danieleautizi.website.service.PersonalDataService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogManagerImpl implements BlogManager {

    @NonNull
    private final PersonalDataService personalDataService;

    /**
     * Find an Blog by its id
     * @param blogId
     * @return Blog
     */
    @Override
    public Blog getBlogById(final String blogId) {

        return personalDataService.getBlog(blogId);
    }

    /**
     * Find all Blogs
     * @return List<Blog>
     */
    @Override
    public List<Blog> getBlogs() {

        return personalDataService.getBlogs();
    }
}
