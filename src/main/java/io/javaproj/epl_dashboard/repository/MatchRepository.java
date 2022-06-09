package io.javaproj.epl_dashboard.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import io.javaproj.epl_dashboard.model.Match;

public interface MatchRepository extends CrudRepository<Match, Long> {

    List<Match> getByHomeTeamOrAwayTeamOrderByDateDesc(String teamName, String teamName2, Pageable pageable);

    @Query("select m from Match m where (m.homeTeam = :teamName or m.awayTeam = :teamName) and m.date between :dateStart and :dateEnd order by date desc")
    List<Match> getMatchesByTeamBetweenDates(
            @Param("teamName") String teamName,
            @Param("dateStart") LocalDate dateStart,
            @Param("dateEnd") LocalDate dateEnd);

    /*
     * List<Match>
     * getByHomeTeamAndDateBetweenOrAwayTeamAndDateBetweenOrderByDateDesc(
     * String teamName,
     * LocalDate date1,
     * LocalDate date2,
     * String teamName2,
     * LocalDate date3,
     * LocalDate date4);
     */
    default List<Match> findLatestMatchesByTeam(String teamName, int count) {

        return getByHomeTeamOrAwayTeamOrderByDateDesc(teamName, teamName, PageRequest.of(0, count));
    }
}
