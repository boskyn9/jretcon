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
enum FairFightResponse {

    OK('OK'),
    OK_ALREADYACTIVE('OK AlreadyActive'),
    OK_CONNECTIING('OK Connecting'),
    DENIED('denied')
    
    String code
    
    String toString(){
        code
    }
    
    FairFightResponse(code){
        this.code = code
    }
}

