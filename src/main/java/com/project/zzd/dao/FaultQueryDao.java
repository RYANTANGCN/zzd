package com.project.zzd.dao;

import com.project.zzd.entiy.FaultQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FaultQueryDao extends JpaRepository<FaultQuery,Integer> {
    @Query(
            "select q from FaultQuery q where " +
                    "q.carBrand=:carBrand and q.carType=:carType and " +
                    "q.carModel=:carModel and q.faultNo=:faultNo"
    )
    FaultQuery findByCarBrandAndCarTypeAndCarModelAndFaultNoLike(
            String carBrand,
            String carType,
            String carModel,
            String faultNo
    );

    @Query("select distinct q.carBrand from FaultQuery q where q.carBrand is not null ")
    List<String> getDistinctCarBrand();

    @Query("select distinct q.carType from FaultQuery q where q.carType is not null ")
    List<String> getDistinctCarType();

    @Query("select distinct q.carModel from FaultQuery q where q.carModel is not null ")
    List<String> getDistinctCarModel();

    @Query("select distinct q.carType from FaultQuery q where q.carBrand=?1 and q.carType is not null ")
    List<String> getCarType(String carType);

    @Query("select distinct q.carModel from FaultQuery q where q.carBrand=?1 and q.carType=?2 and q.carModel is not null")
    List<String> getCarModel(String carType,String carModel);
}
