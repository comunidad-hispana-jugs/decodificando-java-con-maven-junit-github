package org.medellin.app.soccercup;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.medellin.app.calculator.CalculatorClient;
import org.medellin.app.soccercup.entity.Team;
import org.medellin.app.soccercup.service.TeamService;

public class SoccerCupClient {

	final static  Logger logger = LoggerFactory.getLogger( CalculatorClient.class );

	public static void main(String[] args) {
		logger.info( "Starting Soccer Cup Console client" );

		TeamService teamService = new TeamService();

		logger.info( "Create teams" );

		var team = new Team();
		team.setName( "My Team 1" );
		team = teamService.persistTeam( team );

		var team2 = new Team();
		team2.setName( "My Team 2" );
		team2 = teamService.persistTeam( team2 );

		List<Team> teamList = teamService.getAllTeams();

		System.out.println( teamList );

		logger.info( "Delete team 1" );

		Team teamDeleted = teamService.deleteTeam(1L);

		teamList = teamService.getAllTeams();

		System.out.println( teamList );

		logger.info( "Update team 0 name" );

		Team team1 = teamService.getById(0L);

		team1.setName("My team name changed");

		teamService.updateTeam(team1);

		teamList = teamService.getAllTeams();

		System.out.println( teamList );

		logger.info( "Closing Soccer Cup Console client" );
	}



}
