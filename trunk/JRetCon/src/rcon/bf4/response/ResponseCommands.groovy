package rcon.bf4.response

/**
 *
 * @author JoaoBosco
 */
enum ResponseCommands {

    // TODO inserir todos os elementos de resposta
    
    OK('OK'),
    INVALIDPASSWORD('InvalidPassword'),
    PASSWORDNOTSET('PasswordNotSet'),
    INVALIDARGUMENTS('InvalidArguments')
    
    String code
    
    String toString(){
        code
    }
    
    ResponseCommands(code){
        this.code = code
    }
}

