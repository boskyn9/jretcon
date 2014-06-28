/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rcon.bf4.util

/**
 *
 * @author JoaoBosco
 */
enum GameMode {

    
    CONQUESTLARGE('ConquestLarge0'),
    CONQUESTSMALL('ConquestSmall0'),
    DOMINATION('Domination0'),
    DEFUSE('Elimination0'),
    OBLITERATION('Obliteration'),
    RUSH('RushLarge0'),
    SQUADDEATHMATCH('SquadDeathMatch0'),
    TEAMDEATMARCH('TeamDeathMatch0')

    String gameModeCode
    
    String toString(){
        gameModeCode
    }
    
    GameMode(gameModeCode){
        this.gameModeCode = gameModeCode
    }
}

