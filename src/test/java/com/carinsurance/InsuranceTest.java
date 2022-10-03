package com.carinsurance;

import com.carinsurance.model.Insurance;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.Assert.*;

class InsuranceTest {

    private Insurance insurance;

    @Test
    void shouldSayThatPeriodIsNotExceeded(){
        insurance = new Insurance("Mercedes Test", 300000, 30000, "VIP 0007", LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(2021, Month.DECEMBER, 30));
        assertTrue(insurance.isInsurancePeriodNotExceeded());
    }

    @Test
    void shouldSayThatPeriodIsExceeded(){
        insurance = new Insurance("Mercedes Test", 300000, 30000, "VIP 0007", LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(2020, Month.DECEMBER, 30));
        assertFalse(insurance.isInsurancePeriodNotExceeded());
    }

    @Test
    void shouldSayThatDamageValueIsBiggerThanSeventyPercentOfCarValue(){
        insurance = new Insurance("Mercedes Test", 10000, 8000, "VIP 0007", LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(2020, Month.DECEMBER, 30));
        assertTrue(insurance.isValueOfDamageBiggerThanSeventyPercentOfCarValue());
    }

    @Test
    void shouldSayThatDamageValueIsLowerThanSeventyPercentOfCarValue(){
        insurance = new Insurance("Mercedes Test", 10000, 2000, "VIP 0007", LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(2020, Month.DECEMBER, 30));
        assertFalse(insurance.isValueOfDamageBiggerThanSeventyPercentOfCarValue());
    }

    @Test
    void shouldCountCurrentValueOfCar(){
        insurance = new Insurance("Mercedes Test", 10000, 3000, "VIP 0007", LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(2021, Month.NOVEMBER, 30));
        assertEquals(9800, insurance.currentValueOfCar());
    }

    @Test
    void shouldCountTotalDamage(){
        insurance = new Insurance("Mercedes Test", 10000, 3000, "VIP 0007", LocalDate.of(2022, Month.JANUARY, 1), LocalDate.of(2021, Month.NOVEMBER, 30));
        assertEquals(6860, insurance.totalDamage());
    }
}
