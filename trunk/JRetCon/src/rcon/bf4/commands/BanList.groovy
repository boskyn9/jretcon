package rcon.bf4.commands
/**
 *
 * @author JoaoBosco
 */
enum BanList {

    ADD('banList.add'),
    CLEAR('banList.clear'),
    LIST('banList.list'),
    LOAD('banList.load'),
    REMOVE('banList.remove'),
    SAVE('banList.save')
    
    String command    

    String toString(){
        command
    }
    
    BanList(command){
        this.command = command        
    }
}

