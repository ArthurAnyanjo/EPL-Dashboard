import { React } from 'react'
import { Link } from 'react-router-dom';
import "./MatchDetailCard.scss"

export const MatchDetailCard = ({ teamName, match }) => {
  if (!match) return null;
  const otherTeam = match.homeTeam === teamName ? match.awayTeam : match.homeTeam;
  const otherTeamRoute = `/teams/${otherTeam}`;
  let MatchWinner = teamName === match.ftr;

  if(match.ftr === 'H'){
    MatchWinner = true;
  }else{
    MatchWinner = false;
  }

  return (
    <div className = {MatchWinner ? 'MatchDetailCard won-card': 'MatchDetailCard lost-card'} >
  
      <div>
      <span className='vs'>Vs</span>
      <h1><Link to={otherTeamRoute}>{otherTeam}</Link></h1>
      <h2 className='match-date'>{match.date}</h2>
      <h2 className='match-week'>Matchweek: {match.mw}</h2>
      <h3 className='score'>Full Time Score: {match.fthg} : {match.ftag}</h3>
      </div>
      <div className='additional-detail'>
      <h4>Home Team Form </h4>
      <p>{match.htformPtsStr}</p>
      <h4>Away Team Form</h4>
      <p>{match.atformPtsStr}</p>
      <h4>Full Time Result</h4>
      <p>{match.ftr}</p>
      </div>
      
    </div>
    
  );
}

