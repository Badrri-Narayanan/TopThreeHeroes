package com.eshopbox.TopThreeHeros.rest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eshopbox.TopThreeHeros.entity.Hero;
import com.eshopbox.TopThreeHeros.entity.HeroInfo;

@RestController
@RequestMapping("/dota2")
public class TopThreeHerosRestController {

	public static List<HeroInfo> heroInfoList;
	
	//get the list of heroes using @PostContruct at the time of bean creation. Done only once
	@PostConstruct
	public void loadListOfHeroesData() {
		String REQUEST_URL_HERO_INFO = "https://api.opendota.com/api/heroes/";
		//fetching from opendota REST API
		ResponseEntity<HeroInfo[]> responseEntity1 = TopThreeHeroesRestAPIUtilities.restTemplate.getForEntity(REQUEST_URL_HERO_INFO, HeroInfo[].class);
		
		HeroInfo[] listOfHeroInfo = responseEntity1.getBody();
		heroInfoList = Arrays.asList(listOfHeroInfo);
	}
	
	// defining endpoint to fetch top 3 most played heroes for the account_id
	@GetMapping("/top3heroes/{accountId}")
	public List<HeroInfo> getHeroes(@PathVariable int accountId) 
			throws InvalidAccountIdException, NoGamesPlayedException {
		
		//check if account ID is valid or not
		if(accountId <= 0) {
			throw new InvalidAccountIdException("The Account ID: " + accountId + " is invalid");
		}
		
		List<Hero> heroesList = TopThreeHeroesRestAPIUtilities.fetchHeroesList(accountId);
		
		TopThreeHeroesRestAPIUtilities.checkIfUserEverPlayedGame(heroesList, accountId);
		
		//Sorting the heroesList based on games field and getting the highest 3 items from list.
		List<Hero> top3heroes = heroesList.parallelStream().sorted((h1, h2) -> h2.getGames() - h1.getGames()).limit(3).collect(Collectors.toList());
		Map<Integer, Integer> top3heroesId = new HashMap<>();
		
		for(Hero hero : top3heroes) {
			//search optimization using hashmap
			top3heroesId.put(hero.getHeroId(), 1);
		}
		
		//filtering the heroesInfo list based on about 3 top hero_ids
		List<HeroInfo> top3heroInfo = heroInfoList.parallelStream().filter(heroInfo -> top3heroesId.get(heroInfo.getHeroId()) != null).collect(Collectors.toList());
		
		return top3heroInfo;
	}

}
