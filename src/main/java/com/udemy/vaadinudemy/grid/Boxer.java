package com.udemy.vaadinudemy.grid;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Boxer {
	private String fullName;
	private String weightClass;
	@NotNull
	@Min(value=16, message="The boxer must have at least 16 years old")
	private int nuberOfFights;
	private boolean isActive;
	
	public Boxer() {
	}

	public Boxer(String fullName, String weightClass, int nuberOfFights, boolean isActive) {
		super();
		this.fullName = fullName;
		this.weightClass = weightClass;
		this.nuberOfFights = nuberOfFights;
		this.isActive = isActive;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getWeightClass() {
		return weightClass;
	}

	public void setWeightClass(String weightClass) {
		this.weightClass = weightClass;
	}

	public int getNuberOfFights() {
		return nuberOfFights;
	}

	public void setNuberOfFights(int nuberOfFights) {
		this.nuberOfFights = nuberOfFights;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Boxer [fullName=" + fullName + ", weightClass=" + weightClass + ", nuberOfFights=" + nuberOfFights
				+ ", isActive=" + isActive + "]";
	}
}
