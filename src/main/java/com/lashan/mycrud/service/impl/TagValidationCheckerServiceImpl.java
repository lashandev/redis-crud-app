package com.lashan.mycrud.service.impl;

import com.lashan.mycrud.entity.SwtMtTagValidation;
import com.lashan.mycrud.repository.SwtMtTagValidationRepository;
import com.lashan.mycrud.service.TagValidationChecker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TagValidationCheckerServiceImpl implements TagValidationChecker {
    private final SwtMtTagValidationRepository swtMtTagValidationRepository;
    @Override
    public String validateTag(String tag,String value) {
        Optional<SwtMtTagValidation> byId = swtMtTagValidationRepository.findById(tag);
        SwtMtTagValidation swtMtTagValidation = byId.orElseGet(null);

        return "";
    }
}
