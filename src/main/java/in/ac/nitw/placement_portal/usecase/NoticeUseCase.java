package in.ac.nitw.placement_portal.usecase;

import in.ac.nitw.placement_portal.api.NoticeApi;
import in.ac.nitw.placement_portal.dto.NoticeForm;
import in.ac.nitw.placement_portal.pojo.NoticePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class NoticeUseCase {

    @Autowired
    private NoticeApi noticeApi;

    public void createNotice(NoticeForm form, String postedBy) {
        NoticePojo notice = new NoticePojo();
        notice.setTitle(form.getTitle());
        notice.setContent(form.getContent());
        notice.setPostedBy(postedBy);
        noticeApi.saveNotice(notice);
    }

    public List<NoticePojo> getAllNotices() {
        return noticeApi.getAllNotices();
    }

    @Transactional
    public void deleteNotice(Long id) {
        NoticePojo notice = noticeApi.getNotice(id);
        if (notice == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Notice not found");
        }
        noticeApi.removeNotice(notice);
    }
}
