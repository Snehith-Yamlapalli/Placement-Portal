package in.ac.nitw.placement_portal.api;

import in.ac.nitw.placement_portal.dao.NoticeDao;
import in.ac.nitw.placement_portal.pojo.NoticePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeApi {

    @Autowired
    private NoticeDao noticeDao;

    public void saveNotice(NoticePojo notice) {
        noticeDao.persist(notice);
    }

    public NoticePojo getNotice(Long id) {
        return noticeDao.select(id);
    }

    public List<NoticePojo> getAllNotices() {
        return noticeDao.selectAll();
    }

    public void removeNotice(NoticePojo notice) {
        noticeDao.remove(notice);
    }
}
