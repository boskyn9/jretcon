package rcon.bf4.commands

/**
 *
 * @author JoaoBosco
 */
enum EventsCommands {
	
    PLAYER_onAUTHENTICATED('player.onAuthenticated'),    //Player with name <soldier name> has joined the server 
    PLAYER_onJOIN('player.onJoin'),   //Player with name <soldier name> has joined the server 
    PLAYER_onLEAVE('player.onLeave'),  //with name <soldier name> has left the server 
    PLAYER_onSPAWN('player.onSpawn'),  //Player with name <soldier name> has spawned in 
    PLAYER_onKILL('player.onKill'),    //Player with name <killing soldier name> has killed <killed soldier name> 
    PLAYER_onCHAT('player.onChat'),   //Chat message has been sent to a group of people 
    PLAYER_onSQUADCHANGE('player.onSquadChange'),  //Player might have changed squad 
    PLAYER_onTEAMCHANGE('player.onTeamChange'),  //Player might have changed team 
    PUNKbUSTER_onMESSAGE('punkBuster.onMessage'),  //PunkBuster server has output a message 
    SERVER_onMAXPLAYERCOUNTCHANGE('server.onMaxPlayerCountChange'), //Effective max player count has changed 
    SERVER_onLEVELLOADED('server.onLevelLoaded'),  //Level has loaded server.onRoundOver  Round has ended 
    SERVER_onROUNDOVERPLAYES('server.onRoundOverPlayers'),  //Player stats at end-of-round 
    SERVER_onROUNDoVERTEAMSCORES('server.onRoundOverTeamScores') //Team stats at end-of-round 
    
    String command
    
    String toString(){
        command
    }
    
    EventsCommands(command){
        this.command = command
    }
}

