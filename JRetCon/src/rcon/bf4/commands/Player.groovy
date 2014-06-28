package rcon.bf4.commands
/**
 *
 * @author JoaoBosco
 */
enum Player {

    IDLEDURATION('player.idleDuration'),
    ISALIVE('player.isAlive'),
    PING('player.ping')
    
    String command    

    String toString(){
        command
    }
    
    Player (command){
        this.command = command        
    }
}

