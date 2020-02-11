package org.medellin.app.soccercup;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.medellin.app.soccercup.entity.Team;
import org.medellin.app.soccercup.service.TeamService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SoccerCupClient {

	private static final  Logger logger = LoggerFactory.getLogger( SoccerCupClient.class );
	private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "soccercupJPA" );

	public static void main(String[] args) {
		logger.info( "Starting Soccer Cup Console client" );

		TeamService teamService = new TeamService(entityManagerFactory.createEntityManager());

		logger.info( "Create teams" );

		teamService.persistTeam( new Team("My Team 1") );
		teamService.persistTeam( new Team("My Team 2" ) );

		List<Team> teamList = teamService.getAllTeams();

		System.out.println( teamList );

		logger.info( "Update team 0 name" );

		var teamCreated = teamService.getById(0L);

		var teamUpdated = new Team(teamCreated.getId(), "My team name changed");

		teamService.updateTeam(teamUpdated);

		teamList = teamService.getAllTeams();

		System.out.println( teamList );

		logger.info( "Delete all teams" );

		teamList.forEach((aTeam) ->
				teamService.deleteTeam(aTeam.getId())
		);

		logger.info( "Closing Soccer Cup Console client" );
		teamService.close();
	}



}
