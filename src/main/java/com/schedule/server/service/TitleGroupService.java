package com.schedule.server.service;



import com.schedule.server.entity.TitleGroup;

import java.util.List;

public interface TitleGroupService {
    List<TitleGroup> getAll();
    TitleGroup getByID(long id);
    TitleGroup save(TitleGroup titleGroup);
    void remove(long id);
    void removeAll();
}
