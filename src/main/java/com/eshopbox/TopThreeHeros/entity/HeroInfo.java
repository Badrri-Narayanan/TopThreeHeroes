package com.eshopbox.TopThreeHeros.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)	
public class HeroInfo {
	
	@JsonProperty("id")
	private int heroId;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("localized_name")
	private String localizedName;
	
	public HeroInfo() {
	}

	public int getHeroId() {
		return heroId;
	}

	public void setHeroId(int heroId) {
		this.heroId = heroId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocalizedName() {
		return localizedName;
	}

	public void setLocalizedName(String localizedName) {
		this.localizedName = localizedName;
	}

	@Override
	public String toString() {
		return "HeroInfo [heroId=" + heroId + ", name=" + name + ", localizedName=" + localizedName + "]";
	}

}
