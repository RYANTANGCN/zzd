package com.project.zzd;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "pm_fault_query")
public class FaultQuery {

    @Id
    private Integer id;

    private String carBrand;

    private String carType;

    private String carModel;

    private String faultNo;

    private String faultName;

    private String faultDescribe;

    private String codeDescribe;

    private String faultEliminate;

}
