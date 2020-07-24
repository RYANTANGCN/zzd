package com.project.zzd.dao;

import com.project.zzd.entiy.FaultQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FaultQueryDao extends JpaRepository<FaultQuery,Integer> {
    @Query(
            "select q from FaultQuery q where " +
                    "q.carBrand=:carBrand and q.carType=:carType and " +
                    "q.carModel=:carModel and q.faultNo= :faultNo " +
                    "and q.isDeleted=false "
    )
    FaultQuery findByCarBrandAndCarTypeAndCarModelAndFaultNoLike(
            String carBrand,
            String carType,
            String carModel,
            String faultNo
    );

    @Query("select distinct q.carBrand from FaultQuery q where q.carBrand is not null " +
            "and q.isDeleted=false ")
    List<String> getDistinctCarBrand();

    @Query("select distinct q.carType from FaultQuery q where q.carType is not null " +
            "and q.isDeleted=false ")
    List<String> getDistinctCarType();

    @Query("select distinct q.carModel from FaultQuery q where q.carModel is not null " +
            "and q.isDeleted=false ")
    List<String> getDistinctCarModel();

    @Query("select distinct q.carType from FaultQuery q where q.carBrand=?1 and q.carType is not null " +
            "and q.isDeleted=false ")
    List<String> getCarType(String carType);

    @Query("select distinct q.carModel from FaultQuery q where q.carBrand=?1 and q.carType=?2 and q.carModel is not null " +
            "and q.isDeleted=false ")
    List<String> getCarModel(String carType,String carModel);

    @Modifying
    @Query("update FaultQuery q set q.isDeleted=true where q.id in :ids " +
            "and q.isDeleted=false ")
    int batchDelete(List<Integer> ids);

    Page<FaultQuery> findAllByIsDeletedFalse(Pageable pageable);
}
