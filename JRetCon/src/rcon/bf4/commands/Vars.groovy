package rcon.bf4.commands
/**
 *
 * @author JoaoBosco
 */
enum Vars {
    
    _3DSPOTTING('vars.3dSpotting'),
    _3PCAM('vars.3pCam'),
    ALWAYSALLOWSPECTATORS('vars.alwaysAllowSpectators'),
    AUTOBALANCE('vars.autoBalance'),
    BULLETDAMAGE('vars.bulletDamage'),
    COMMANDER('vars.commander'),
    FORCERELOADWHOLEMAGS('vars.forceReloadWholeMags'),
    FRIENDLYFIRE('vars.friendlyFire'),
    GAMEMODECOUNTER('vars.gameModeCounter'),
    GAMEPASSWORD('vars.gamePassword'),
    HITINDICATORENABLED('vars.hitIndicatorsEnabled'),
    HUD('vars.hud'),
    IDLEBANROUNDS('vars.idleBanRounds'),
    IDLETIMEOUT('vars.idleTimeout'),
    KILLCAM('vars.killCam'),
    MAXPLAYERS('vars.maxPlayers'),
    MINIMAP('vars.minimap'),
    MINIMAPSPOTTING('vars.miniMapSpotting'),
    MPEXERIENCE('vars.mpExperience'),
    NOMETAG('vars.nameTag'),
    ONLYSQUADLEADERSPAWN('vars.onlySquadLeaderSpawn'),
    PLAYERRESPAWNTIME('vars.playerRespawnTime'),
    PRESET('vars.preset'),
    REGENERATEHEALTH('vars.regenerateHealth'),
    ROUNDLOCKDOWNCOUNTDOWN('vars.roundLockdownCountdown'),
    ROUNDRESTARTPLAYERCOUNT('vars.roundRestartPlayerCount'),
    ROUNDSTARTPLAYERCOUNT('vars.roundStartPlayerCount'),
    ROUNDTIMELIMIT('vars.roundTimeLimit'),
    ROUNDWARMUPTIMEOUT('vars.roundWarmupTimeout'),
    SERVERDESCRIPTION('vars.serverDescription'),
    SERVERMESSAGE('vars.serverMessage'),
    SERVERNAME('vars.serverName'),
    SERVERTYPE('vars.serverType'),
    SOLDIERHEALTH('vars.soldierHealth'),
    TEAMFACTIONOVERRIDE('vars.teamFactionOverride'),
    TEAMKILLCOUNTFORKICK('vars.teamKillCountForKick'),
    TEAMKILLKICKFORBAN('vars.teamKillKickForBan'),
    TEAMKILLVALUEDECREASEPERSECOND('vars.teamKillValueDecreasePerSecond'),
    TEAMKILLVALUEFORKICK('vars.teamKillValueForKick'),
    TEAMKILLVALUEINCREASE('vars.teamKillValueIncrease'),
    TICKETBLEEDRATE('vars.ticketBleedRate'),
    INLOCKMODE('vars.unlockMode'),
    VEHICLESPAWNALLOWED('vars.vehicleSpawnAllowed'),
    VEHICLESPAWNDELAY('vars.vehicleSpawnDelay')
    
    String command    

    String toString(){
        command
    }
    
    Vars(command){
        this.command = command        
    }
}

