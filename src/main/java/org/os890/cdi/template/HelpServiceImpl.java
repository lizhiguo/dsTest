package org.os890.cdi.template;

import org.mybatis.cdi.Mapper;

import javax.inject.Inject;

public class HelpServiceImpl implements HelpService {

    @Inject
    @Mapper
    private HelpRepository helpRepository;

    @Override
    public Help getHelp(Long id) {
        return helpRepository.getHelp(id);
    }
}
