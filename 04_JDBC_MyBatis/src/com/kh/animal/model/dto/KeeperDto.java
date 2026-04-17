package com.kh.animal.model.dto;

import java.util.ArrayList;
import java.util.List;

public class KeeperDto {
	private String KeeperId;
	private String keeperName;
	
	List<AnimalDto> animals = new ArrayList();

	public KeeperDto() {
		super();
	}

	public KeeperDto(String keeperId, String keeperName, List<AnimalDto> animals) {
		super();
		KeeperId = keeperId;
		this.keeperName = keeperName;
		this.animals = animals;
	}

	public String getKeeperId() {
		return KeeperId;
	}

	public void setKeeperId(String keeperId) {
		KeeperId = keeperId;
	}

	public String getKeeperName() {
		return keeperName;
	}

	public void setKeeperName(String keeperName) {
		this.keeperName = keeperName;
	}

	public List<AnimalDto> getAnimals() {
		return animals;
	}

	public void setAnimals(List<AnimalDto> animals) {
		this.animals = animals;
	}

	@Override
	public String toString() {
		return "KeeperDto [KeeperId=" + KeeperId + ", keeperName=" + keeperName + ", animals=" + animals + "]";
	}
	
	
}
