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
enum SquadResponse {

    OK('OK'),
    INVALIDTEAM('InvalidTeam'),
    INVALIDSQUAD('InvalidSquad'),
    EMPTYSQUAD('EmptySquad'),
    INVALIDARGUMENTS('InvalidArguments'),
    
    String code
    
    String toString(){
        code
    }
    
    SquadResponse(code){
        this.code = code
    }
}


