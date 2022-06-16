import { React} from 'react'
import './TeamTiles.scss';
import { Link } from 'react-router-dom';
 
 
 export const TeamTile = ({teamName}) => {

    return(
        <div className='TeamTiles'>

            <h1>
               <Link to={`/teams/${teamName}`}>
               {teamName}
               </Link>
               </h1>
        </div>
    )

 }