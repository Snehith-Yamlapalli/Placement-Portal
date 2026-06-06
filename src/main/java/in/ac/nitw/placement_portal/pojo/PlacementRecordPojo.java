package in.ac.nitw.placement_portal.pojo;

import in.ac.nitw.placement_portal.constants.OfferType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "placement_records")
@Getter
@Setter
public class PlacementRecordPojo extends BaseEntity {

    @Column(nullable = false)
    private String studentName;

    @Column(nullable = false)
    private String rollNumber;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private String profile;

    @Column(nullable = false)
    private String branch;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OfferType offerType;

    @Column(nullable = false)
    private Integer academicYear;

    @Column(nullable = false)
    private String year; //Example : 2015-16
}
