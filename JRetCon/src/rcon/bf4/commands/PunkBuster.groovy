package rcon.bf4.commands
/**
 *
 * @author JoaoBosco
 */
enum PunkBuster {

    ACTIVATE('punkBuster.activate'),
    ISACTIVE('punkBuster.isActive'),
    PB_SV_COMMAND('punkBuster.pb_sv_command')
    
    String command    

    String toString(){
        command
    }
    
    PunkBuster(command){
        this.command = command        
    }  
    
}

