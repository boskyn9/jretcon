package rcon.bf4.response

/**
 *
 * @author JoaoBosco
 */
enum PlayerResponse {

    OK('OK'),
    INVALIDARGUMENTS('InvalidArguments'),
    INVALIDPLAYERNAME('InvalidPlayerName'),
    
    String code
    
    String toString(){
        code
    }
    
    PlayerResponse(code){
        this.code = code
    }
}

