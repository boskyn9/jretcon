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
enum SpectatorListResponse {
	
    OK('OK'),
    INVALIDARGUMENTS('InvalidArguments'),
    
    String code
    
    String toString(){
        code
    }
    
    SpectatorListResponse(code){
        this.code = code
    }
}

