package org.medellin.app.soccercup.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.medellin.app.soccercup.entity.Team;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TeamServiceTest {

    @InjectMocks
    private TeamService teamService;

    @Mock
    private EntityManager entityManager;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void toDoPersistOfATeam() {
        Team aTeam = new Team("My Team");
        EntityTransaction entityTransaction = mock(EntityTransaction.class);

        doNothing().when(entityTransaction).begin();
        doNothing().when(entityTransaction).commit();
        when(entityManager.getTransaction()).thenReturn(entityTransaction);
        doNothing().when(entityManager).persist(aTeam);

        InOrder order = inOrder(entityTransaction);

        Team newTeam = teamService.persistTeam(aTeam);

        assertEquals(aTeam, newTeam);

        verify(entityManager).persist(aTeam);
        verify(entityManager).getTransaction();
        order.verify(entityTransaction).begin();
        order.verify(entityTransaction).commit();

    }

    @Test
    void toDoGetAllTeams() {
        Query query = mock(Query.class);
        List<Team> teams = Arrays.asList(new Team("My Team 1"), new Team("My Team 2"));
        when(entityManager.createQuery( "Select o from Team o" )).thenReturn(query);
        when(query.getResultList()).thenReturn(teams);

        List<Team> teamResult = teamService.getAllTeams();
        assertEquals(teams, teamResult);

        verify(entityManager).createQuery("Select o from Team o");
        verify(query).getResultList();


    }

    @Test
    void toDoGetATeamById() {
        Long idOfTeam = 1L;
        Team aTeam = new Team("My Team");
        when(entityManager.find(Team.class, idOfTeam)).thenReturn(aTeam);

        Team team = teamService.getById(idOfTeam);
        assertEquals(aTeam, team);

        verify(entityManager).find(Team.class, idOfTeam);

    }

    @Test
    void toDoDeleteATeam() {
        Long idOfTeam = 1L;
        Team aTeam = new Team("My Team");
        EntityTransaction entityTransaction = mock(EntityTransaction.class);

        doNothing().when(entityTransaction).begin();
        doNothing().when(entityTransaction).commit();
        when(entityManager.getTransaction()).thenReturn(entityTransaction);
        when(entityManager.find(Team.class, idOfTeam)).thenReturn(aTeam);
        doNothing().when(entityManager).remove(aTeam);

        InOrder order = inOrder(entityTransaction);

        Team newTeam = teamService.deleteTeam(idOfTeam);

        assertEquals(aTeam, newTeam);

        verify(entityManager).remove(aTeam);
        verify(entityManager).getTransaction();
        verify(entityManager).find(Team.class, idOfTeam);
        order.verify(entityTransaction).begin();
        order.verify(entityTransaction).commit();

    }

    @Test
    void toDoUpdateATeam() {
        Team aTeam = new Team("My Team");
        EntityTransaction entityTransaction = mock(EntityTransaction.class);

        doNothing().when(entityTransaction).begin();
        doNothing().when(entityTransaction).commit();
        when(entityManager.getTransaction()).thenReturn(entityTransaction);
        when(entityManager.merge(aTeam)).thenReturn(aTeam);

        InOrder order = inOrder(entityTransaction);

        Team newTeam = teamService.updateTeam(aTeam);

        assertEquals(aTeam, newTeam);

        verify(entityManager).merge(aTeam);
        verify(entityManager).getTransaction();
        order.verify(entityTransaction).begin();
        order.verify(entityTransaction).commit();
    }

    @Test
    void toCloseSession(){
        doNothing().when(entityManager).close();

        teamService.close();

        verify(entityManager).close();

    }
}