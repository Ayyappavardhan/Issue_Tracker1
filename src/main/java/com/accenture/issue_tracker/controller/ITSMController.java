package com.accenture.issue_tracker.controller;

import com.accenture.issue_tracker.model.ITSMDataInsertRequest;
import com.accenture.issue_tracker.model.ITSMTableData;
import com.accenture.issue_tracker.service.ITSMTableDataService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/itsm")
public class ITSMController {
    private  final ITSMTableDataService service;

    public ITSMController(ITSMTableDataService service) {
        this.service = service;
    }
    //String incident, String summary, String notes, LocalDateTime slaTime,
    //LocalDateTime dateOfCreation, LocalDateTime resolved, String status, String assignee,String service
@PostMapping
    public String insertNewRecord(@RequestBody ITSMDataInsertRequest itsmDataInsertRequest){
        ITSMTableData data= new ITSMTableData(
                itsmDataInsertRequest.incident(),
                itsmDataInsertRequest.summary(),
                itsmDataInsertRequest.notes(),
                itsmDataInsertRequest.slaTime(),
                itsmDataInsertRequest.dateOfCreation(),
                itsmDataInsertRequest.resolved(),
                itsmDataInsertRequest.status(),
                itsmDataInsertRequest.assignee(),
                itsmDataInsertRequest.service()
        );
    String s = service.insertNewRecord(data);
    return s;

}
}
