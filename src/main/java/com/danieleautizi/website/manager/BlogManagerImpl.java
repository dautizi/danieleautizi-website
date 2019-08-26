package com.danieleautizi.website.manager;

import com.danieleautizi.website.model.presentation.Blog;
import com.danieleautizi.website.service.PersonalDataService;
import com.danieleautizi.website.service.utils.DateTimeZoneUtil;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlogManagerImpl implements BlogManager {

    public static ZonedDateTime FIRST_AVAILABLE = ZonedDateTime.of(2016, 10, 6, 10, 0, 0, 0,
                                                                   ZoneId.of("Europe/Stockholm"));

    @NonNull
    private final PersonalDataService personalDataService;

    /**
     * Find an Blog by its id
     * @param blogId
     * @return Blog
     */
    @Override
    public Blog getBlogById(final String blogId) {

        return enrichBlog(personalDataService.getBlog(blogId));
    }

    /**
     * Find all Blogs
     * @return List<Blog>
     */
    @Override
    public List<Blog> getBlogs() {

        val blogs = personalDataService.getBlogs();

        if (CollectionUtils.isEmpty(blogs)) {
            return Collections.EMPTY_LIST;
        }

        return blogs.stream()
                    .map(this::enrichBlog)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
    }

    private Blog enrichBlog(final Blog blog) {

        if (blog == null) {
            return null;
        }

        val datetime = Optional.ofNullable(blog.getDatetime())
                               .map(DateTimeZoneUtil::fromZonedDateTimeToDate)
                               .orElse(DateTimeZoneUtil.fromZonedDateTimeToDate(FIRST_AVAILABLE));

        blog.setFormattedDatetime(datetime);
        blog.setFormattedLastUpdate(Optional.ofNullable(blog.getDatetime())
                                            .map(DateTimeZoneUtil::fromZonedDateTimeToDate)
                                            .orElse(DateTimeZoneUtil.fromZonedDateTimeToDate(FIRST_AVAILABLE)));
        return blog;
    }
}
