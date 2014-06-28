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
enum ReservdSlotsResponse {
    
    OK('OK'),
    INVALIDARGUMENTS('InvalidArguments'),
    INVALIDNAME('InvalidName'),
    ACCESSERROR('AccessError'),
    INCOMPLETEREAD('IncompleteRead'),
    PLAYERALREADYINLIST('PlayerAlreadyInList'),
    FULL('Full'),
    
    String code
    
    String toString(){
        code
    }
    
    ReservdSlotsResponse(code){
        this.code = code
    }
}

