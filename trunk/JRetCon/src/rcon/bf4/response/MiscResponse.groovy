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
enum MiscResponse {
	
    OK('OK'),
    INVALIDPASSWORD('InvalidPassword'),
    PASSWORDNOTSET('PasswordNotSet'),
    INVALIDARGUMENTS('InvalidArguments')
    
    String code
    
    String toString(){
        code
    }
    
    MiscResponse(code){
        this.code = code
    }
    
}

