package org.medellin.app.soccercup.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import org.medellin.app.soccercup.entity.Team;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class TeamServiceTest {

    private TeamService teamService;

    @BeforeEach
    void setUp() {
        teamService = new TeamService();
    }

    @Test
    @DisplayName("Adding a new Team")
    void persistTeam() {
        Team team = new Team();
        team.setName( "My Team" );
        team = this.teamService.persistTeam( team );

        assertNotNull(this.teamService.getById( team.getId()));
    }

    @ParameterizedTest
    @DisplayName("Adding several Teams from a csv file")
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void persistTeams(String inputName, String expectedName) {
        Team team = new Team();
        team.setName( inputName );
        team = this.teamService.persistTeam( team );

        Team teamSaved = this.teamService.getById( team.getId());
        assertEquals(expectedName, teamSaved.getName());
    }






}