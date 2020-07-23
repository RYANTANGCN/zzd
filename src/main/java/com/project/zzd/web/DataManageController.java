package com.project.zzd.web;

import com.project.zzd.common.RequestResult;
import com.project.zzd.entiy.FaultQuery;
import com.project.zzd.service.DataManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("data")
@Validated
public class DataManageController {

    private Logger logger = LoggerFactory.getLogger(DataManageController.class);

    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 100, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

    @Autowired
    DataManageService dataManageService;

    @PostMapping("page")
    public RequestResult faultQueryPage(@Min(1) @NotNull Integer pageIndex, @NotNull @Min(1) Integer pageNum) {
        Page<FaultQuery> faultQueryPage = dataManageService.findByPage(PageRequest.of(pageIndex, pageNum, Sort.Direction.DESC, "createDateTime"));
        RequestResult requestResult = RequestResult.success(faultQueryPage.getContent());
        requestResult.setCount(faultQueryPage.getTotalElements());
        return requestResult;
    }

    @PostMapping("createOrUpdate")
    public RequestResult<Integer> createOrUpdateFaultQueryRecord(@Valid @RequestBody List<FaultQuery> faultQueries) {
        return RequestResult.success(dataManageService.createOrUpdateRecords(faultQueries));
    }

    @PostMapping("delete")
    public RequestResult<Integer> deleteFaultQueryRecord(@RequestBody List<Integer> ids) {
        return RequestResult.success(dataManageService.deleteRecord(ids));
    }

}
