/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rcon.bf4.response

/**
 *
 * @author extra
 */
enum AdminResponse {

    OK('OK'),
    INVALIDARGUMENTS('InvalidArguments'),
    PLAYERNOTFOUND('PlayerNotFound'),
    INVALIDPLAYERNAME('InvalidPlayerName'),
    SOLDIERNOTALIVE('SoldierNotAlive'), 
    
    INVALIDTEAMID('InvalidTeamId'),
    INVALIDTEAM('InvalidTeam'),
    INVALIDSQUADID('InvalidSquadId'),
    INVALIDSQUAD('InvalidSquad'),
    INVALIDFORCEKILL('InvalidForceKill'),
    PLAYERNOTDEAD('PlayerNotDead'),
    SETTEAMFAILED('SetTeamFailed'),
    SETSQUADFAILED('SetSquadFailed'),
    
    INVALIDPASSWORD('InvalidPassword'),
    TOOLONGMESSAGE('TooLongMessage'),
    MESSAGEISTOOLONG('MessageIsTooLong')
    
    
    String code
    
    String toString(){
        code
    }
    
    AdminResponse(code){
        this.code = code
    }
}

