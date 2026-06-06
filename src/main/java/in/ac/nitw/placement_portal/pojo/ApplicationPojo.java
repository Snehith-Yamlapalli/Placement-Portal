package in.ac.nitw.placement_portal.pojo;

import in.ac.nitw.placement_portal.constants.ApplicationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "applications", uniqueConstraints = @UniqueConstraint(columnNames = {"studentEmail", "proforma_id"}))
@Getter
@Setter
public class ApplicationPojo extends BaseEntity {

    @Column(nullable = false)
    private String studentEmail;

    @ManyToOne(optional = false)
    @JoinColumn(name = "proforma_id")
    private ProformaPojo proforma;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApplicationStatus status = ApplicationStatus.APPLIED;
}
