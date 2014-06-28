package rcon.bf4.commands
/**
 *
 * @author JoaoBosco
 */
enum SpectatorList {
        
    ADD('spectatorList.add'),
    CLEAR('spectatorList.clear'),
    LIST('spectatorList.list'),
    REMOVE('spectatorList.remove'),
    SAVE('spectatorList.save')
    
    String command    

    String toString(){
        command
    }
    
    SpectatorList(command){
        this.command = command        
    }
}

