package com.lyess.network_device_inventory.service;

import com.lyess.network_device_inventory.domain.enums.ElementType;
import com.lyess.network_device_inventory.dto.entities.NetworkDeviceDto;
import com.lyess.network_device_inventory.exception.NetworkDeviceNotFoundException;
import com.lyess.network_device_inventory.repository.INetworkDeviceRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-27 7:58 p.m.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class NetworkDeviceServiceIntegrationTest {

    private final IService<NetworkDeviceDto> networkDeviceService;

    private final INetworkDeviceRepository networkDeviceRepository;

    private NetworkDeviceDto networkDeviceDto;

    @Autowired
    public NetworkDeviceServiceIntegrationTest(IService<NetworkDeviceDto> networkDeviceService, INetworkDeviceRepository networkDeviceRepository) {
        this.networkDeviceService = networkDeviceService;
        this.networkDeviceRepository = networkDeviceRepository;
    }


    @BeforeEach
    void setUp() {
        // given
         networkDeviceDto = NetworkDeviceDto.builder()
                .address("10.133.10.20")
                .elementType(ElementType.LAPTOP.getValue())
                .neighbors(new HashSet<>())
                .build();
    }

    @Test
    @Order(1)
    @DisplayName("Save Network Device")
    public void testSave() {
        // given networkDeviceDto
        // when
        NetworkDeviceDto savedNetworkDeviceDto = networkDeviceService.save(networkDeviceDto);
        // then
        assertNotNull(savedNetworkDeviceDto);
        assertEquals(networkDeviceDto, savedNetworkDeviceDto);
    }

    @Test
    @Order(2)
    @DisplayName("Find Network Device By Id")
    public void testFindById() {
        // given
        String id = "10.133.10.20";
        // when
        NetworkDeviceDto savedNetworkDeviceDto = networkDeviceService.findById(id);
        // then
        assertNotNull(savedNetworkDeviceDto);
        assertEquals(id, savedNetworkDeviceDto.getAddress());
    }

    @Test
    @Order(3)
    @DisplayName("Update Network Device")
    public void testUpdate() {
        // given
        networkDeviceDto.setElementType(ElementType.SWITCH.getValue());
        // when
        NetworkDeviceDto updatedNetworkDeviceDto = networkDeviceService.update(networkDeviceDto, "10.133.10.20");
        // then
        assertNotNull(updatedNetworkDeviceDto);
        assertEquals(networkDeviceDto, updatedNetworkDeviceDto);
    }


    @Test
    @Order(4)
    @DisplayName("Delete Network Device")
    public void testDelete() {
        // given networkDeviceDto
        // when
        networkDeviceService.delete("10.133.10.20");
        // then
        assertThrows(NetworkDeviceNotFoundException.class, () -> networkDeviceService.findById(networkDeviceDto.getAddress()));
    }


}
