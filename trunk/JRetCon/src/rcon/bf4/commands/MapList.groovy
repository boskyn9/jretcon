package rcon.bf4.commands
/**
 *
 * @author JoaoBosco
 */
enum MapList {
    
    ADD('mapList.add'),
    AVAILABLEMAPS('mapList.availableMaps'),
    CLEAR('mapList.clear'),
    ENDROUND('mapList.endRound'),
    GETMAPINDICES('mapList.getMapIndices'),
    GETROUNDS('mapList.getRounds'),
    LIST('mapList.list'),
    LOAD('mapList.load'),
    REMOVE('mapList.remove'),
    RESTARTROUND('mapList.restartRound'),
    RUNNEXTROUND('mapList.runNextRound'),
    SAVE('mapList.save'),
    SETNEXTMAPINDEX('mapList.setNextMapIndex')
	
    String command    

    String toString(){
        command
    }
    
    MapList(command){
        this.command = command        
    }
}

