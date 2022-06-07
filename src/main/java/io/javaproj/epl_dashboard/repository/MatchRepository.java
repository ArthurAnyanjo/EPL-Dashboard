package io.javaproj.epl_dashboard.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import io.javaproj.epl_dashboard.model.Match;

public interface MatchRepository extends CrudRepository<Match, Long> {

    List<Match> getByHomeTeamOrAwayTeamOrderByDateDesc(String teamName, String teamName2, Pageable pageable);

    default List<Match> findLatestMatchesByTeam(String teamName, int count) {

        return getByHomeTeamOrAwayTeamOrderByDateDesc(teamName, teamName, PageRequest.of(0, count));
    }
}
