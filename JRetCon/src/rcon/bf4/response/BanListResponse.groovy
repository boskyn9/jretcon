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
enum BanListResponse {

    OK('OK'),
    INVALIDARGUMENTS('InvalidArguments'),
    INVALIDIDTYPE('InvalidIdType'),
    INVALIDBANTYPE('InvalidBanType'),
    INVALIDTIMESTAMP('InvalidTimeStamp'),
    INCOMPLETEBAN('IncompleteBan'),
    ACCESSERROR('AccessError'),
    NOTFOUND('NotFound'),
    BANLISTFULL('banListFull'),
    
    
    String code
    
    String toString(){
        code
    }
    
    BanListResponse(code){
        this.code = code
    }
}

