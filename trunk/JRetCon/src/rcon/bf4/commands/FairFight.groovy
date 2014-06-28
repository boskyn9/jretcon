package rcon.bf4.commands
/**
 *
 * @author JoaoBosco
 */

enum FairFight {
	
    /**
     * Attempts to activate FairFight if it is not currently runnin
     * */
    ACTIVATE('fairFight.activate'),
    /**
     * Attempts to deactivate FairFight if it is currently running 
    * */
    DEACTIVATE('fairFight.deactivate'),
    /**
     * Returns whether or not FairFight currently is active 
     * */
    ISACTIVE('fairFight.isActive')
    
    String command    

    String toString(){
        command
    }
    
    FairFight(command){
        this.command = command        
    }
}

