import { React } from 'react'
import { Link } from 'react-router-dom';

export const MatchDetailCard = ({ teamName, match }) => {
  if (!match) return null;
  const otherTeam = match.homeTeam === teamName ? match.awayTeam : match.homeTeam;
  const otherTeamRoute = `/teams/${otherTeam}`;
  return (
    <div className="MatchDetailCard">
      <h3>Latest Matches</h3>
      <h1>vs <Link to={otherTeamRoute}>{otherTeam}</Link></h1>
      <h2>{match.date}</h2>
      <h2>Matchweek: {match.mw}</h2>
      <h4>Home Team Form: {match.htformPtsStr}</h4>
      <h4>Away Team Form: {match.atformPtsStr}</h4>
      <h3>Full Time Score: {match.fthg} : {match.ftag}</h3>
    </div>
  );
}

