package in.ac.nitw.placement_portal.api;

import in.ac.nitw.placement_portal.dao.ApplicationDao;
import in.ac.nitw.placement_portal.pojo.ApplicationPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationApi {

    @Autowired
    private ApplicationDao applicationDao;

    public void saveApplication(ApplicationPojo application) {
        applicationDao.persist(application);
    }

    public List<ApplicationPojo> getByStudentEmail(String studentEmail) {
        return applicationDao.findByStudentEmail(studentEmail);
    }
}
