package in.ac.nitw.placement_portal.pojo;

import in.ac.nitw.placement_portal.constants.DriveMode;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "proformas")
@Getter
@Setter
public class ProformaPojo extends BaseEntity {

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String jobRole;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DriveMode driveMode;

    private Double cgpaCutoff;

    private String tentativeLocation;

    @Column(columnDefinition = "TEXT")
    private String ctcBreakup;

    @ElementCollection
    @CollectionTable(name = "proforma_eligible_batches", joinColumns = @JoinColumn(name = "proforma_id"))
    @Column(name = "batch")
    private List<String> eligibleBatch;

    @ElementCollection
    @CollectionTable(name = "proforma_eligible_branches", joinColumns = @JoinColumn(name = "proforma_id"))
    @Column(name = "branch")
    private List<String> eligibleBranches;

    @Column(columnDefinition = "TEXT")
    private String driveInfo;

    @ElementCollection
    @CollectionTable(name = "proforma_assessment_dates", joinColumns = @JoinColumn(name = "proforma_id"))
    @Column(name = "assessment_date")
    private List<ZonedDateTime> assessmentDates;

    private ZonedDateTime deadlineForForm;

    private String spoc;

    private String jobDescriptionUrl;

    private String jobDescriptionName;
}
