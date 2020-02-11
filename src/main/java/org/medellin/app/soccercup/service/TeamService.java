package org.medellin.app.soccercup.service;

import java.util.List;
import javax.persistence.*;

import org.medellin.app.soccercup.entity.Team;

public class TeamService {
	private  EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "soccercupJPA" );

	public Team persistTeam(Team team) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist( team );
		entityManager.getTransaction().commit();
		entityManager.close();
		return team;

	}

	public List<Team> getAllTeams() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery( "Select o from Team o" );
		List<Team> teamList = query.getResultList();
		entityManager.close();
		return teamList;
	}


	public Team getById(Long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Team team = entityManager.find(Team.class, id);
		entityManager.close();
		return team;
	}

	public Team deleteTeam(Long id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		Team team = entityManager.find(Team.class, id);
		entityManager.remove(team);

		entityManager.getTransaction().commit();
		entityManager.close();
		return team;

	}

	public Team updateTeam(Team team) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge( team );
		entityManager.getTransaction().commit();
		entityManager.close();
		return team;

	}

}
