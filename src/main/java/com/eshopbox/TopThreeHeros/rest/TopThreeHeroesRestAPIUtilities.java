package com.eshopbox.TopThreeHeros.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.eshopbox.TopThreeHeros.entity.Hero;

public class TopThreeHeroesRestAPIUtilities {

	public static RestTemplate restTemplate = new RestTemplate();
	
	public static List<Hero> fetchHeroesList(int accountId) {
		String REQUEST_URL_HERO_LIST = "https://api.opendota.com/api/players/" + accountId + "/heroes";
		//fetching from opendota REST API
		ResponseEntity<Hero[]> responseEntity2 = restTemplate.getForEntity(REQUEST_URL_HERO_LIST, Hero[].class);
		
		Hero[] listOfHeroes = responseEntity2.getBody();
		return Arrays.asList(listOfHeroes);
	}
	
	public static void checkIfUserEverPlayedGame(List<Hero> heroesList, int accountId) 
			throws NoGamesPlayedException {
		int totalGames = 0;
		
		for(Hero hero : heroesList) {
			totalGames += hero.getGames();
		}
		
		if(totalGames == 0) {
			throw new NoGamesPlayedException("Account ID: " + accountId + " has played zero games.");
		}
	}
}
