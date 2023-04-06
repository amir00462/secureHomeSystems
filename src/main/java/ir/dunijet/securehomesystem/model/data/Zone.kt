package ir.dunijet.securehomesystem.model.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.dunijet.securehomesystem.util.ZoneNooe
import ir.dunijet.securehomesystem.util.ZoneType

@Entity("zone_table")
data class Zone(

    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    val typeIsWire: Boolean,
    val title :String ,
    val icon :Int ,
    val zoneId :String ,
    val zoneType :Int ,
    val zoneStatus :ZoneType ,
    val zoneNooe : ZoneNooe? = ZoneNooe.Cheshmi

    )