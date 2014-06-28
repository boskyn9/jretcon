package rcon.bf4.commands
/**
 *
 * @author JoaoBosco
 */
enum ReservedSlotsList {	
    
    ADD('reservedSlotsList.add'),
    AGGRESSIVEJOIN('reservedSlotsList.aggressiveJoin'),
    CLEAR('reservedSlotsList.clear'),
    LIST('reservedSlotsList.list'),
    LOAD('reservedSlotsList.load'),
    REMOVE('reservedSlotsList.remove'),
    SAVE('reservedSlotsList.save')
    
    String command    

    String toString(){
        command
    }
    
    ReservedSlotsList(command){
        this.command = command        
    }
    
}

