package rcon.bf4.commands

/**
 *
 * @author JoaoBosco
 */

enum Admin {
    EVENTSENABLED('admin.eventsEnabled'),
    HELP('admin.help'),
    KICKPLAYER('admin.kickPlayer'),
    KILLPLAYER('admin.killPlayer'),
    LISTPLAYERS('admin.listPlayers'),
    MOVEPLAYER('admin.movePlayer'),
    PASSWORD('admin.password'),
    SAY('admin.say'),
    SHUTDOWN('admin.shutDown'),
    TEAMSWITCHPLAYER('admin.teamSwitchPlayer'),
    YELL('admin.yell')    

    String command    

    String toString(){
        command
    }
    
    Admin(command){
        this.command = command        
    }

}
