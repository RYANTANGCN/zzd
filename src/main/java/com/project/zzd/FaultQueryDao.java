package com.project.zzd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FaultQueryDao extends JpaRepository<FaultQuery,Integer> {
    @Query(
            "select q from FaultQuery q where " +
                    "q.carBrand=:carBrand and q.carType=:carType and " +
                    "q.carModel=:carModel and q.faultNo like %:faultNo%"
    )
    FaultQuery findByCarBrandAndCarTypeAndCarModelAndFaultNoLike(
            String carBrand,
            String carType,
            String carModel,
            String faultNo
    );

    @Query("select distinct q.carBrand from FaultQuery q")
    List<String> getDistinctCarBrand();

    @Query("select distinct q.carType from FaultQuery q")
    List<String> getDistinctCarType();

    @Query("select distinct q.carModel from FaultQuery q")
    List<String> getDistinctCarModel();
}
