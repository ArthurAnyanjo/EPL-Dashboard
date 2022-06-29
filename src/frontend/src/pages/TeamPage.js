import { React , useEffect, useState} from 'react'
import { useParams, Link } from 'react-router-dom';
import { MatchDetailCard } from '../components/MatchDetailCard';
import { MatchSmallCard } from '../components/MatchSmallCard';


import './TeamPage.scss';

export const TeamPage = () => {

    const [team, setTeam] = useState({matches: []});
    const {teamName} = useParams();
 
    useEffect(
    
        () => {
            const fetchTeam = async() =>{
                const response = await fetch(`${process.env.REACT_APP_API_ROOT_URL}/team/${teamName}`);
                const data = await response.json();
                setTeam(data)
            };
            fetchTeam();

        },[teamName]
        
    );

    if(!team || !team.teamName){
      return<h1>Cannot Find Team</h1>
    }
  
    return (
  

    <div className="TeamPage">
    <div className='team-name-section'><h1 className='team-name'>{team.teamName}</h1></div>
    
   
    <div className='match-detail-section'>
    <h3>Latest Match</h3>
     <MatchDetailCard match={team.matches[0]}/>
     </div>
     {team.matches.slice(1).map(match => <MatchSmallCard key = {match.id} teamName={team.teamName} match={match}/>)}
     <div className='more-info'>
     <Link to={`/teams/${teamName}/matches/${process.env.REACT_APP_DATA_END_YEAR}`}>More &gt;</Link>
     </div>
    </div>
  );
}

export default TeamPage;
