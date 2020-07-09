package com.project.zzd.web;

import com.project.zzd.common.RequestResult;
import com.project.zzd.entiy.FaultQuery;
import com.project.zzd.service.DataManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("data")
@Validated
public class DataManageController {

    @Autowired
    DataManageService dataManageService;

    @PostMapping("page")
    public RequestResult<Page<FaultQuery>> faultQueryPage(@Min(1)@NotNull Integer pageIndex, @NotNull @Min(1) Integer pageNum){
        return RequestResult.success(dataManageService.findByPage(PageRequest.of(pageIndex,pageNum, Sort.Direction.DESC,"createDateTime")));
    }

    @PostMapping("createOrUpdate")
    public RequestResult<Integer> createOrUpdateFaultQueryRecord(@RequestBody List<FaultQuery> faultQuerys){
        return RequestResult.success(dataManageService.createOrUpdateRecords(faultQuerys));
    }

    @PostMapping("delete")
    public RequestResult<Integer> deleteFaultQueryRecord(@RequestBody List<Integer> ids){
        return RequestResult.success(dataManageService.deleteRecord(ids));
    }

}
