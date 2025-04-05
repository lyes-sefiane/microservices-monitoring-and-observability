package com.lyess.network_device_inventory_service.domain.entites;

import lombok.*;

import jakarta.persistence.*;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-23 10:53 a.m.
 */
@Entity
@Table(name = "neighbor")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Neighbor {

    @Id
    @Column(name = "ipaddress")
    private String ipAddress;

}
