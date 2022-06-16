import { React } from 'react'
import { Link } from 'react-router-dom';

import'./MatchSmallCard.scss'

export const MatchSmallCard = ({ match, teamName }) => {
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
    <div className = {MatchWinner ? 'MatchSmallCard won-card': 'MatchSmallCard lost-card'} >
      <span className='vs'>Vs</span>
      <h1><Link to={otherTeamRoute}>{otherTeam}</Link></h1>
      <p>Score: {match.fthg} : {match.ftag}</p>
    </div>
  );
}

