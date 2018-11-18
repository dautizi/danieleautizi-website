package com.danieleautizi.website.manager;

import com.danieleautizi.website.model.presentation.Blog;

import java.util.List;

/**
 * Manager for {@link Blog} operations.
 */
public interface BlogManager {

    /**
     * Find an Blog by its id
     * @param blogId
     * @return Blog
     */
    Blog getBlogById(final String blogId);

    /**
     * Find all Blogs
     * @return List<Blog>
     */
    List<Blog> getBlogs();
}
