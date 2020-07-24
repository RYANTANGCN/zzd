package com.project.zzd.service;

import com.project.zzd.dao.FaultQueryDao;
import com.project.zzd.entiy.FaultQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataManageService {

    @Autowired
    FaultQueryDao faultQueryDao;

    @Transactional
    public int createOrUpdateRecords(List<FaultQuery> faultQuerys) {
        faultQueryDao.saveAll(faultQuerys.stream().filter(w -> w.getId() == null).collect(Collectors.toList())).size();
        faultQuerys.stream().filter(w->w.getId()!=null).forEach(o->{
            FaultQuery oldFaultQuery = faultQueryDao.findById(o.getId()).get();
            o.setDeleted(oldFaultQuery.getDeleted());
            o.setCreateDateTime(oldFaultQuery.getCreateDateTime());
            o.setUpdateDateTime(LocalDateTime.now());

            faultQueryDao.save(o);
        });

        return faultQuerys.size();
    }

    @Transactional
    public int deleteRecord(List<Integer> ids) {
        return faultQueryDao.batchDelete(ids);
    }

    public Page<FaultQuery> findByPage(Pageable pageable) {
        return faultQueryDao.findAllByIsDeletedFalse(pageable);
    }
}
