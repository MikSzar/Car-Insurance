package com.carinsurance.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Insurance {
	
	@Id
	@GeneratedValue
	@Getter
	@Setter
	private Integer id;

	@Getter
	@Setter
	private int value, damageAssessment;
	@Getter
	@Setter
	private String name, registrationNumber, imageurl;

	@Getter
	@Setter
	private LocalDate damageDate, insuranceDate;
	public Insurance() {}

	public Insurance(String name, int value, int damageAssessment, String registrationNumber, LocalDate damageDate, LocalDate insuranceDate) {
		super();
		this.name = name;
		this.value = value;
		this.damageAssessment = damageAssessment;
		this.registrationNumber = registrationNumber;
		this.damageDate = damageDate;
		this.insuranceDate = insuranceDate;
	}
	
	public Insurance(Integer id, String name, int value, int damageAssessment, String registrationNumber, LocalDate damageDate, LocalDate insuranceDate) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.damageAssessment = damageAssessment;
		this.registrationNumber = registrationNumber;
		this.damageDate = damageDate;
		this.insuranceDate = insuranceDate;
	}

	public boolean isInsurancePeriodNotExceeded(){

		return insuranceDate.plusYears(1).isAfter(damageDate);
	}

	public boolean isValueOfDamageBiggerThanSeventyPercentOfCarValue(){

		return (currentValueOfCar()*0.7 < damageAssessment);

	}

	public int totalDamage(){

		return (int) (currentValueOfCar()*0.7);
	}

	public int currentValueOfCar(){

		int currentValue = 0;
		int valueDecrease = (int) (value * 0.01);
		int monthsBetween = (int) ChronoUnit.MONTHS.between(insuranceDate.withDayOfMonth(1), damageDate.withDayOfMonth(1));
		currentValue = value - monthsBetween*valueDecrease;

		return currentValue;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Insurance insurance = (Insurance) o;
		return value == insurance.value && damageAssessment == insurance.damageAssessment && id.equals(insurance.id) && name.equals(insurance.name) && registrationNumber.equals(insurance.registrationNumber) && imageurl.equals(insurance.imageurl) && damageDate.equals(insurance.damageDate) && insuranceDate.equals(insurance.insuranceDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, value, damageAssessment, name, registrationNumber, imageurl, damageDate, insuranceDate);
	}

	@Override
	public String toString() {
		return "Insurance{" +
				"id=" + id +
				", value=" + value +
				", damageAssessment=" + damageAssessment +
				", name='" + name + '\'' +
				", registrationNumber='" + registrationNumber + '\'' +
				", imageurl='" + imageurl + '\'' +
				", damageDate=" + damageDate +
				", insuranceDate=" + insuranceDate +
				'}';
	}
}
