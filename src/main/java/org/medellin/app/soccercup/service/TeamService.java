package org.medellin.app.soccercup.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.medellin.app.soccercup.entity.Team;

public class TeamService {
	private  EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "soccercupJPA" );


	public Team persistTeam(Team team) {

		//entityManagerFactory = Persistence.createEntityManagerFactory( "worldcupJPA" );
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist( team );
		entityManager.getTransaction().commit();
		entityManager.close();
		return team;

	}

	public List<Team> getAllTeams() {

		//entityManagerFactory = Persistence.createEntityManagerFactory( "worldcupJPA" );

		EntityManager entityManager = entityManagerFactory.createEntityManager();
//entityManager.getTransaction().begin();
		Query query = entityManager.createQuery( "Select o from Team o" );
		List<Team> teamList = query.getResultList();
//entityManager.getTransaction().commit();
		entityManager.close();

		return teamList;
	}
}
