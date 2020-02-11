package org.medellin.app.soccercup.service;

import java.util.List;
import javax.persistence.*;

import org.medellin.app.soccercup.entity.Team;

public class TeamService {
	private final EntityManager entityManager;

	public TeamService(final EntityManager entityManager){
		this.entityManager = entityManager;
	}

	public Team persistTeam(final Team team) {
		final var transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist( team );
		transaction.commit();

		return team;

	}

	public List<Team> getAllTeams() {
		final var query = entityManager.createQuery( "Select o from Team o" );
		return query.getResultList();
	}

	public Team getById(final Long idOfTeam) {
		return entityManager.find(Team.class, idOfTeam);
	}

	public Team deleteTeam(final Long idOfTeam) {

		final var transaction = entityManager.getTransaction();
		transaction.begin();

		final var team = entityManager.find(Team.class, idOfTeam);
		entityManager.remove(team);

		transaction.commit();

		return team;

	}

	public Team updateTeam(final Team team) {
		final var transaction = entityManager.getTransaction();

		transaction.begin();
		entityManager.merge( team );
		transaction.commit();

		return team;
	}

	public void close(){
		entityManager.close();
	}
}
