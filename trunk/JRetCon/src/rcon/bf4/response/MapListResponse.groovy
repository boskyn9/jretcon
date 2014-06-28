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
enum MapListResponse {

    OK('OK'),
    INVALIDARGUMENTS('InvalidArguments'),
    INVALIDMAP('InvalidMap'),
    INVALIDGAMEMODEONMAP('InvalidGameModeOnMap'),
    INVALIDROUNDSPERMAP('InvalidRoundsPerMap'),
    FULL('Full'),
    INVALIDMAPINDEX('InvalidMapIndex'),
    ACCESSERROR('AccessError')
    
    
    String code
    
    String toString(){
        code
    }
    
    MapListResponse(code){
        this.code = code
    }
}

