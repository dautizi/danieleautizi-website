package com.danieleautizi.website.manager;

import com.danieleautizi.website.configuration.StaticProperties;
import com.danieleautizi.website.model.presentation.CurriculumVitae;
import com.danieleautizi.website.service.PersonalDataService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CurriculumVitaeManagerImpl implements CurriculumVitaeManager {

    @NonNull
    private final PersonalDataService personalDataService;

    @NonNull
    private final StaticProperties staticProperties;

    /**
     * Find last CurriculumVitae
     * @return CurriculumVitae
     */
    @Override
    public CurriculumVitae getCurriculumVitae() {

        val curriculumVitae = personalDataService.getCurriculumVitae();
        if (curriculumVitae == null) {

            return null;
        }

        val curriculumVitaeLink = StringUtils.isNotEmpty(curriculumVitae.getPath())
                                  ? String.format("%s%s",
                                                  staticProperties.getStaticBaseUrl(),
                                                  curriculumVitae.getPath())
                                  : StringUtils.EMPTY;

        curriculumVitae.setLink(curriculumVitaeLink);
        return curriculumVitae;
    }

}
