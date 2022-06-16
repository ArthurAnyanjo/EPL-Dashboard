package io.javaproj.epl_dashboard.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Match {

    @Id
    private Long id;
    private LocalDate date;
    private String homeTeam;
    private String awayTeam;
    private Integer FTHG;
    private Integer FTAG;
    private String FTR;
    private Integer HTGS;
    private Integer ATGS;
    private Integer HTGC;
    private Integer ATGC;
    private String HM1;
    private String HM2;
    private String HM3;
    private String HM4;
    private String HM5;
    private String AM1;
    private String AM2;
    private String AM3;
    private String AM4;
    private String AM5;
    private Float MW;
    private String HTFormPtsStr;
    private String ATFormPtsStr;
    private Integer HTWinStreak3;
    private Integer HTWinStreak5;
    private Integer ATWinStreak3;
    private Integer ATWinStreak5;
    private Integer ATLossStreak3;
    private Integer ATLossStreak5;
    private String HTGD;
    private String ATGD;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Integer getFTHG() {
        return FTHG;
    }

    public void setFTHG(Integer fTHG) {
        FTHG = fTHG;
    }

    public Integer getFTAG() {
        return FTAG;
    }

    public void setFTAG(Integer fTAG) {
        FTAG = fTAG;
    }

    public String getFTR() {
        return FTR;
    }

    public void setFTR(String fTR) {
        this.FTR = fTR;
    }

    public Integer getHTGS() {
        return HTGS;
    }

    public void setHTGS(Integer hTGS) {
        HTGS = hTGS;
    }

    public Integer getATGS() {
        return ATGS;
    }

    public void setATGS(Integer aTGS) {
        ATGS = aTGS;
    }

    public Integer getHTGC() {
        return HTGC;
    }

    public void setHTGC(Integer hTGC) {
        HTGC = hTGC;
    }

    public Integer getATGC() {
        return ATGC;
    }

    public void setATGC(Integer aTGC) {
        ATGC = aTGC;
    }

    public String getHM1() {
        return HM1;
    }

    public void setHM1(String hM1) {
        HM1 = hM1;
    }

    public String getHM2() {
        return HM2;
    }

    public void setHM2(String hM2) {
        HM2 = hM2;
    }

    public String getHM3() {
        return HM3;
    }

    public void setHM3(String hM3) {
        HM3 = hM3;
    }

    public String getHM4() {
        return HM4;
    }

    public void setHM4(String hM4) {
        HM4 = hM4;
    }

    public String getHM5() {
        return HM5;
    }

    public void setHM5(String hM5) {
        HM5 = hM5;
    }

    public String getAM1() {
        return AM1;
    }

    public void setAM1(String aM1) {
        AM1 = aM1;
    }

    public String getAM2() {
        return AM2;
    }

    public void setAM2(String aM2) {
        AM2 = aM2;
    }

    public String getAM3() {
        return AM3;
    }

    public void setAM3(String aM3) {
        AM3 = aM3;
    }

    public String getAM4() {
        return AM4;
    }

    public void setAM4(String aM4) {
        AM4 = aM4;
    }

    public String getAM5() {
        return AM5;
    }

    public void setAM5(String aM5) {
        AM5 = aM5;
    }

    public Float getMW() {
        return MW;
    }

    public void setMW(Float mW) {
        MW = mW;
    }

    public String getHTFormPtsStr() {
        return HTFormPtsStr;
    }

    public void setHTFormPtsStr(String hTFormPtsStr) {
        HTFormPtsStr = hTFormPtsStr;
    }

    public String getATFormPtsStr() {
        return ATFormPtsStr;
    }

    public void setATFormPtsStr(String aTFormPtsStr) {
        ATFormPtsStr = aTFormPtsStr;
    }

    public Integer getHTWinStreak3() {
        return HTWinStreak3;
    }

    public void setHTWinStreak3(Integer hTWinStreak3) {
        HTWinStreak3 = hTWinStreak3;
    }

    public Integer getHTWinStreak5() {
        return HTWinStreak5;
    }

    public void setHTWinStreak5(Integer hTWinStreak5) {
        HTWinStreak5 = hTWinStreak5;
    }

    public Integer getATWinStreak3() {
        return ATWinStreak3;
    }

    public void setATWinStreak3(Integer aTWinStreak3) {
        ATWinStreak3 = aTWinStreak3;
    }

    public Integer getATWinStreak5() {
        return ATWinStreak5;
    }

    public void setATWinStreak5(Integer aTWinStreak5) {
        ATWinStreak5 = aTWinStreak5;
    }

    public Integer getATLossStreak3() {
        return ATLossStreak3;
    }

    public void setATLossStreak3(Integer aTLossStreak3) {
        ATLossStreak3 = aTLossStreak3;
    }

    public Integer getATLossStreak5() {
        return ATLossStreak5;
    }

    public void setATLossStreak5(Integer aTLossStreak5) {
        ATLossStreak5 = aTLossStreak5;
    }

    public String getHTGD() {
        return HTGD;
    }

    public void setHTGD(String hTGD) {
        HTGD = hTGD;
    }

    public String getATGD() {
        return ATGD;
    }

    public void setATGD(String aTGD) {
        ATGD = aTGD;
    }

}
