package com.project.zzd;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FaultQueryDao extends JpaRepository<FaultQuery,Integer> {

    FaultQuery findByCarBrandAndCarTypeAndCarModelAndFaultNo(
            String carBrand,
            String carType,
            String carModel,
            String faultNo
    );

}
