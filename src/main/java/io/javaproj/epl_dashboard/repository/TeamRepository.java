package io.javaproj.epl_dashboard.repository;

import org.springframework.data.repository.CrudRepository;

import io.javaproj.epl_dashboard.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {

    Team findByTeamName(String teamName);

}
