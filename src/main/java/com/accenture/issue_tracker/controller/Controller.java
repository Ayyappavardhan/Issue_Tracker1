package com.accenture.issue_tracker.controller;

import com.accenture.issue_tracker.model.DataInsertRequest;
import com.accenture.issue_tracker.model.IssueTableData;
import com.accenture.issue_tracker.model.Tags;
import com.accenture.issue_tracker.service.Service;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/fetch/all/issues")
public class Controller {

    private final Service service;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Controller(Service service) {
        this.service = service;
    }
    @GetMapping("get")
    public int getAllUniqueTagCount(){
       return service.getAllUniqueTagCount();
    }
    @GetMapping("from/{start}/to/{end}")
    public int getAllUniqueTagCountWithRangeDate( @PathVariable String start,@PathVariable String end) throws ParseException {
        LocalDateTime startDate = LocalDate.parse(start).atStartOfDay();

        LocalDateTime endDate = LocalDate.parse(end).atStartOfDay()
                .plusDays(1L)
                .minusNanos(1L);

//        System.out.println(endDate);
//        // Create a Calendar instance and set it to the endDate
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(endDate);
//
//// Add one day to the Calendar
//        calendar.add(Calendar.DAY_OF_MONTH, 1);
//
//// Get the updated endDate
//        endDate = calendar.getTime();
//        System.out.println(endDate);
        return service.getAllUniqueTagCountWithRangeDate(startDate,endDate);
    }
    @GetMapping("all/from/{start}/to/{end}")
    public List<Tags> getAllUniqueTagDataCountWithRangeDate(@PathVariable String start, @PathVariable String end) throws ParseException {
        LocalDateTime startDate = LocalDate.parse(start).atStartOfDay();

        LocalDateTime endDate = LocalDate.parse(end).atStartOfDay()
                .plusDays(1L)
                .minusNanos(1L);
//        System.out.println(endDate);
//        // Create a Calendar instance and set it to the endDate
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(endDate);
//
//// Add one day to the Calendar
//        calendar.add(Calendar.DAY_OF_MONTH, 1);
//
//// Get the updated endDate
//        endDate = calendar.getTime();
//        System.out.println(endDate);
        return service.getAllUniqueTagDataCountWithRangeDate(startDate,endDate);
    }
    @GetMapping("allIssuesTableData")
    public List<IssueTableData> getAllTheIssues(){
         return service.getAllTheIssues();
    }

    @PostMapping
    public void saveData(@RequestBody DataInsertRequest dataInsertRequest){
        service.saveData(dataInsertRequest);
    }
}
