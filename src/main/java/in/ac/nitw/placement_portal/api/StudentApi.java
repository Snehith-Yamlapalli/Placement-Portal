package in.ac.nitw.placement_portal.api;

import in.ac.nitw.placement_portal.dao.StudentDao;
import in.ac.nitw.placement_portal.pojo.StudentPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentApi {

    @Autowired
    private StudentDao studentDao;

    public void saveStudentDetails(StudentPojo student){
        studentDao.persist(student);
    }
}
