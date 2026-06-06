package in.ac.nitw.placement_portal.usecase;

import in.ac.nitw.placement_portal.api.StudentApi;
import in.ac.nitw.placement_portal.dto.SaveStudentForm;
import in.ac.nitw.placement_portal.pojo.StudentPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentUseCase {

    @Autowired
    private StudentApi studentApi;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveStudentDetails(SaveStudentForm form) {
        StudentPojo student = new StudentPojo();
        student.setRollNumber(form.getRollNumber());
        student.setName(form.getName());
        student.setInstituteEmail(form.getInstituteEmail());
        student.setPersonalEmail(form.getPersonalEmail());
        student.setBranch(form.getBranch());
        student.setYearOfStudy(form.getYearOfStudy());
        student.setCgpa(form.getCgpa());
        studentApi.saveStudentDetails(student);
    }
}
