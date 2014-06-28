package rcon.bf4.commands
/**
 *
 * @author JoaoBosco
 */
enum Misc {

    CURRENTLEVEL('currentLevel'),
    LISTPLAYERS('listPlayers'),
    LOGIN_HASHED('login.hashed'),
    LOGIN_PLAINTEXT('login.plainText'),
    LOGOUT('logout'),
    QUIT('quit'),
    SERVERINFO('serverInfo'),
    VERSION('version')
    
    String command    

    String toString(){
        command
    }
    
    Misc(command){
        this.command = command        
    }
}

