package rcon.bf4.commands
/**
 *
 * @author JoaoBosco
 */
enum Squad {
	
    LEADER('squad.leader'),
    LISTACTIVE('squad.listActive'),
    LISTPLAYERS('squad.listPlayers'),
    PRIVATE('squad.private')
    
    String command    

    String toString(){
        command
    }
    
    Squad(command){
        this.command = command        
    }
}

