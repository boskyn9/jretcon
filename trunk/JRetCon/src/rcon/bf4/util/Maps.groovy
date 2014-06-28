package rcon.bf4.util

/**
 *
 * @author JoaoBosco
 */
enum Maps {
    
    ZAVOD_311('MP_Abandoned'),
    LANCANG_DAM('MP_Damage'),
    FLOOD_ZONE('MP_Flooded'),
    GOLMUD_RAILWAY('MP_Journey'),
    PARACEL_STORM('MP_Naval'), 
    OPERATION_LOCKER('MP_Prison'),
    HAINAN_RESORT('MP_Resort'),
    SIEGE_OF_SHANGHAI('MP_Siege'),
    ROGUE_TRANSMISSION('MP_TheDish'),
    DAWNBREAKER('MP_Tremors')
    
    String mapCode
    
    String toString(){
        mapCode
    }
    
    Maps(mapCode) {
        this.mapCode = mapCode
    }    
}

