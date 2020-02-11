package org.medellin.app.soccercup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.medellin.app.soccercup.entity.Team;
import org.medellin.app.soccercup.service.TeamService;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SoccerCupClient {

	private static final  Logger logger = LoggerFactory.getLogger( SoccerCupClient.class );

	public static void main(String[] args) throws IOException {
		logger.info( "Starting Soccer Cup Console client" );

		TeamService teamService = new TeamService();

		logger.info( "Create teams" );

		BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );

		System.out.println( "Enter the name: " );
		String name = bufferedReader.readLine();
		Team team = new Team();
		team.setName(name);
		team = teamService.persistTeam( team );

		List<Team> teamList = teamService.getAllTeams();

		System.out.println( teamList );

		logger.info( "Closing Soccer Cup Console client" );
	}



}
