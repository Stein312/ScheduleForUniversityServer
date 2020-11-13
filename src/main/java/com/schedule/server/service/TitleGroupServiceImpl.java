package com.schedule.server.service;

import com.schedule.server.entity.TitleGroup;
import com.schedule.server.repository.TitleGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TitleGroupServiceImpl implements TitleGroupService {
    @Autowired
    private TitleGroupRepository service;

    @Override
    public List<TitleGroup> getAll() {
        return service.findAll();
    }

    @Override
    public TitleGroup getByID(long id) {
        return service.getOne(id);
    }

    @Override
    public TitleGroup save(TitleGroup titleGroup) {
        return service.saveAndFlush(titleGroup);
    }

    @Override
    public void remove(long id) {
               service.deleteById(id);
    }

    @Override
    public void removeAll() {
                service.deleteAll();
    }
}
