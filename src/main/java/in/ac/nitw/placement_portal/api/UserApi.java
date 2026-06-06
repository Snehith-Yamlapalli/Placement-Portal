package in.ac.nitw.placement_portal.api;

import in.ac.nitw.placement_portal.dao.UserDao;
import in.ac.nitw.placement_portal.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserApi {

    @Autowired
    private UserDao userDao;

    public void saveUser(UserPojo user) {
        userDao.persist(user);
    }

    public Optional<UserPojo> getByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
