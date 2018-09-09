package com.andreitop.newco.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
public class TripDto implements Serializable {

    private static final long serialVersionUID = 5914366185889783660L;

    @Id
    @Column
    private Long id;

    @NotNull
    @Pattern(regexp = "^[A-Z]{3}$", message = "IATA airport code should be right format")
    @Column
    private String origin;

    @Size(min = 3, max = 3)
    @Column
    private String destination;

    @Min(0)
    @Max(500000)
    @Column
    private Integer price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
