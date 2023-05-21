package com.example.demo.repository;

import com.example.demo.model.entity.CountryEntity;
import com.example.demo.model.entity.JobHistoryEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class CountriesRepositoryTest {

    @Autowired
    private CountryRepository countriesRepository;

    @Autowired
    private JobHistoryRepository jobHistoryRepository;

    @Test
    void 매핑_테스트(){
        String region = "IT";

        Optional<CountryEntity> entity = countriesRepository.findById(region);

        String regionName= entity.get().getRegionId().getRegionName();

        Assertions.assertEquals(regionName,"Europe");
    }

    @Test
    void 이력_조회_테스트() {
        Integer emId = 200;
        List<JobHistoryEntity> historyEntityList= jobHistoryRepository.findAllByEmployeeId(emId);

        historyEntityList.forEach(l-> Assertions.assertEquals("Public Accountant",l.getJobId().getJobTitle()));

    }
}