package com.accenture.issue_tracker.controller;

import com.accenture.issue_tracker.model.DataInsertRequest;
import com.accenture.issue_tracker.model.IssueTableData;
import com.accenture.issue_tracker.model.Tags;
import com.accenture.issue_tracker.service.AllService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/fetch/all/issues")
public class Controller {

    private final AllService service;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Controller(AllService service) {
        this.service = service;
    }
    @GetMapping("get")
    public int getAllUniqueTagCount(){
       return service.getAllUniqueTagCount();
    }
    @GetMapping("from/{start}/to/{end}")
    public int getAllUniqueTagCountWithRangeDate( @PathVariable String start,@PathVariable String end)
            throws ParseException {
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
    public List<Tags> getAllUniqueTagDataCountWithRangeDate(@PathVariable String start,
                                                            @PathVariable String end)
            throws ParseException {
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

    @PostMapping("post")
    public void saveData(@RequestBody DataInsertRequest dataInsertRequest){
        service.saveData(dataInsertRequest);
    }
    //Fetch all tags ,area wise
    @GetMapping("area/{area}")
    public int getAllTagsByArea( @PathVariable("area") String area){
       return service.getAllTagsByArea(area);
    }
    //Fetch all tags , area wise within date
    @GetMapping("area/{area}/all/from/{start}/to/{end}")
    public int getAllTagsByAreaBetweenDates(@PathVariable String area,@PathVariable String start,
                                            @PathVariable String end){
        LocalDateTime startDate=LocalDate.parse(start).atStartOfDay();
        LocalDateTime endDate=LocalDate.parse(end).atStartOfDay()
                .plusDays(1)
                .minusNanos(1);
         return service.getAllTagsByAreaBetweenDates(area,startDate,endDate);

    }
    //Fetch how many incident are associated with particular tag.
    @GetMapping("tag/{tag}")
    public int getCountUniqueIncidentsByTag(@PathVariable String tag){
         return service.countUniqueIncidentsByTag(tag);
    }
    @GetMapping("incident/tag/{tag}")
    public List<String> getUniqueIncidentsByTag(@PathVariable String tag){
        return service.uniqueIncidentsByTag(tag);
    }
    //Fetch how many incident are associated with particular tag within time.
    @GetMapping("tag/{tag}/all/from/{start}/to/{end}")
    public int getAllIncidentCountByTagBetweenDates(@PathVariable String tag, @PathVariable String start,
                                                    @PathVariable String end){
        LocalDateTime startDate = LocalDate.parse(start).atStartOfDay();

        LocalDateTime endDate = LocalDate.parse(end).atStartOfDay()
                .plusDays(1L)
                .minusNanos(1L);
        return service.getAllIncidentCountByTagBetweenDates(tag,startDate,endDate);
    }
    //Fetch all the incidents numbers, with respect to assignee
@GetMapping("/assignee/{assignee}")
    public List<String> getAllIncidentByAssignee( @PathVariable String assignee){
        return service.getAllIncidentByAssignee(assignee);
    }
}
