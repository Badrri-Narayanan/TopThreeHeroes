package com.eshopbox.TopThreeHeros.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)	
public class Hero {
	
	@JsonProperty("hero_id")
	private int heroId;
	
	@JsonProperty("games")
	private int games;
	
//	private long lastPlayed;
//	private int withGames;
//	private int withWin;
//	private int againstGames;
//	private int againstWin;
	
	public Hero() {
	}

	public int getHeroId() {
		return heroId;
	}

	public void setHeroId(int heroId) {
		this.heroId = heroId;
	}

	public int getGames() {
		return games;
	}

	public void setGames(int games) {
		this.games = games;
	}

	@Override
	public String toString() {
		return "Hero [heroId=" + heroId + ", games=" + games + "]";
	}
	
}
