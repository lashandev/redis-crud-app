package com.lashan.mycrud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "swt_mt_tag_validation")
public class SwtMtTagValidation {
    @Id
    @Size(max = 3)
    @Column(name = "TAG_NAME", nullable = false, length = 3)
    private String tagName;

    @Size(max = 2)
    @ColumnDefault("'7'")
    @Column(name = "ACQUIRING_TAG_AVAILABILITY_STATUS", length = 2)
    private String acquiringTagValidationStatus;

    @Size(max = 2)
    @ColumnDefault("'7'")
    @Column(name = "ACQUIRING_LENGTH_VALIDATION_STATUS", length = 2)
    private String acquiringLengthValidationStatus;

    @Size(max = 3)
    @ColumnDefault("'10'")
    @Column(name = "ACQUIRING_LENGTH", length = 3)
    private String acquiringLength;

    @Size(max = 2)
    @ColumnDefault("'8'")
    @Column(name = "ISSUING_TAG_VALIDATION_STATUS", length = 2)
    private String issuingTagValidationStatus;

    @Size(max = 2)
    @ColumnDefault("'8'")
    @Column(name = "ISSUING_LENGTH_VALIDATION_STATUS", length = 2)
    private String issuingLengthValidationStatus;

    @Size(max = 3)
    @ColumnDefault("'10'")
    @Column(name = "ISSUING_LENGTH", length = 3)
    private String issuingLength;

}
