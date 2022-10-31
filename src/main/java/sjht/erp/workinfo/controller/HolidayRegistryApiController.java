package sjht.erp.workinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sjht.erp.login.dto.EmployeeDto;
import sjht.erp.workinfo.dto.request.HolidayRequestDto;
import sjht.erp.workinfo.dto.request.UpdateHolidayRequestDto;
import sjht.erp.workinfo.service.HolidayRegistryService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HolidayRegistryApiController {

    @Autowired
    HolidayRegistryService holidayRegistryService;

    @PostMapping("/api/workTimeInsert")
    public boolean insert(HttpServletRequest request,
                          @RequestBody HolidayRequestDto holidayRequestDto) {
        EmployeeDto employeeDto = (EmployeeDto) request.getAttribute("empNo");

        System.out.println(holidayRequestDto.toString());
        holidayRequestDto.setEmpno(employeeDto.getEmpno());
        return holidayRegistryService.insert(holidayRequestDto);
    }

    @PostMapping("api/updateHoliday")
    public boolean update(
            HttpServletRequest request,
            @RequestBody UpdateHolidayRequestDto updateHolidayRequestDto
    ) {
        EmployeeDto employeeDto = (EmployeeDto) request.getAttribute("empNo");
        updateHolidayRequestDto.setApprover(employeeDto.getName());
        return holidayRegistryService.updateHoliday(updateHolidayRequestDto);
    }
}
