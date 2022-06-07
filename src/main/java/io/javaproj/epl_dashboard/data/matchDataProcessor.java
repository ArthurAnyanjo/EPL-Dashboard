package io.javaproj.epl_dashboard.data;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import io.javaproj.epl_dashboard.model.Match;

public class matchDataProcessor implements ItemProcessor<matchInput, Match> {

    private static final Logger log = LoggerFactory.getLogger(matchDataProcessor.class);

    @Override
    public Match process(final matchInput matchinput) throws Exception {
        Match match = new Match();
        match.setId(Long.parseLong(matchinput.getId()));
        match.setDate(LocalDate.parse(matchinput.getDate()));
        match.setHomeTeam(matchinput.getHomeTeam());
        match.setAwayTeam(matchinput.getAwayTeam());
        match.setFTHG(Integer.parseInt(matchinput.getFTHG()));
        match.setFTAG(Integer.parseInt(matchinput.getFTAG()));
        match.setFTR(matchinput.getFTR());
        match.setHTGS(Integer.parseInt(matchinput.getHTGS()));
        match.setATGS(Integer.parseInt(matchinput.getATGS()));
        match.setHTGC(Integer.parseInt(matchinput.getHTGC()));
        match.setATGC(Integer.parseInt(matchinput.getATGC()));
        match.setHM1(matchinput.getHM1());
        match.setHM2(matchinput.getHM2());
        match.setHM3(matchinput.getHM3());
        match.setHM4(matchinput.getHM4());
        match.setHM5(matchinput.getHM5());
        match.setAM1(matchinput.getAM1());
        match.setAM2(matchinput.getAM2());
        match.setAM3(matchinput.getAM3());
        match.setAM4(matchinput.getAM4());
        match.setAM5(matchinput.getAM5());
        match.setMW(Float.parseFloat(matchinput.getMW()));
        match.setHTFormPtsStr(matchinput.getHTFormPtsStr());
        match.setATFormPtsStr(matchinput.getATFormPtsStr());
        match.setHTWinStreak3(Integer.parseInt(matchinput.getHTWinStreak3()));
        match.setHTWinStreak5(Integer.parseInt(matchinput.getHTWinStreak5()));
        match.setATWinStreak3(Integer.parseInt(matchinput.getATWinStreak3()));
        match.setATWinStreak5(Integer.parseInt(matchinput.getATWinStreak5()));
        match.setATLossStreak3(Integer.parseInt(matchinput.getATLossStreak3()));
        match.setATWinStreak5(Integer.parseInt(matchinput.getATLossStreak5()));
        match.setHTGD(matchinput.getHTGD());
        match.setATGD(matchinput.getATGD());

        return match;

    }

}
