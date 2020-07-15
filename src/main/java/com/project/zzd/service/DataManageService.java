package com.project.zzd.service;

import com.project.zzd.dao.FaultQueryDao;
import com.project.zzd.entiy.FaultQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DataManageService {

    @Autowired
    FaultQueryDao faultQueryDao;

    public int createOrUpdateRecords(List<FaultQuery> faultQuerys) {
        return faultQueryDao.saveAll(faultQuerys).size();
    }

    @Transactional
    public int deleteRecord(List<Integer> ids) {
        return faultQueryDao.batchDelete(ids);
    }

    public Page<FaultQuery> findByPage(Pageable pageable) {
        return faultQueryDao.findAllByIsDeletedFalse(pageable);
    }
}
