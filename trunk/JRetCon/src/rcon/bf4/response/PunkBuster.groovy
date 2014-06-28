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
enum PunkBuster {
	
    OK('OK'),
    INVALIDARGUMENTS('InvalidArguments'),
    INVALIDPBSERVERCOMMAND('InvalidPbServerCommand'),
    
    String code
    
    String toString(){
        code
    }
    
    PunkBuster(code){
        this.code = code
    }
}

