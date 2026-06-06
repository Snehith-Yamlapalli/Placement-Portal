package in.ac.nitw.placement_portal.api;

import in.ac.nitw.placement_portal.dao.ProformaDao;
import in.ac.nitw.placement_portal.pojo.ProformaPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProformaApi {

    @Autowired
    private ProformaDao proformaDao;

    public void saveProforma(ProformaPojo proforma) {
        proformaDao.persist(proforma);
    }

    public ProformaPojo getProforma(Long id) {
        return proformaDao.select(id);
    }

    public List<ProformaPojo> getAllProformas() {
        return proformaDao.selectAll();
    }

    public void removeProforma(ProformaPojo proforma) {
        proformaDao.remove(proforma);
    }
}
