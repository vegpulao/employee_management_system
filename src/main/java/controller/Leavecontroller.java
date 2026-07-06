package controller;

import entity.Leave;
import org.springframework.web.bind.annotation.*;
import service.Leaveservice;
import java.util.Optional;
import java.util.List;

@RequestMapping("/leave")
@RestController
public class Leavecontroller {
    private final Leaveservice service;

    public Leavecontroller(Leaveservice service) {

        this.service = service;
    }
    @PostMapping
    public Leave addLeave(@RequestBody Leave leave_request) {
        return service.addLeave(leave_request);
    }
    @GetMapping
    public List<Leave> getAllLeave() {
        return service.getAllLeaves();
    }
    @GetMapping("/{id}")
    public Optional<Leave> getLeaveById(@PathVariable int id) {
        return service.getLeaveById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteLeave(@PathVariable int id) {
        service.deleteLeave(id);
    }
    @PutMapping("/{id}")
    public Leave updateLeave(@PathVariable int id,
                                   @RequestBody Leave leave_request) {

        leave_request.setId(id);

        return service.updateLeave(leave_request);
    }
}