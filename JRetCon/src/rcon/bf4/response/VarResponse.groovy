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
enum VarResponse {

    OK('OK'),
    INVALIDARGUMENTS('InvalidArguments'),
    INVALIDPASSWORD('InvalidPassword'),
    INVALIDCONFIG('InvalidConfig'),
    INVALIDNROFPLAYERS('InvalidNrOfPlayers'),
    COMMANISREADONLY('CommanIsReadOnly'),
    TOOLONGNAME('TooLongName'),
        
    String code
    
    String toString(){
        code
    }
    
    VarResponse(code){
        this.code = code
    }
}

