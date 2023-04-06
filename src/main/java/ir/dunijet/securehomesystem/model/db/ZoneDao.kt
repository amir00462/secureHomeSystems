package ir.dunijet.securehomesystem.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.dunijet.securehomesystem.model.data.Log
import ir.dunijet.securehomesystem.model.data.Member
import ir.dunijet.securehomesystem.model.data.Remote
import ir.dunijet.securehomesystem.model.data.Zone
import ir.dunijet.securehomesystem.util.ZoneNooe

@Dao
interface ZoneDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(zone: Zone)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(zones: List<Zone>)

    @Query("SELECT * FROM zone_table WHERE typeIsWire = 1")
    suspend fun getAllWire(): List<Zone>

    @Query("SELECT * FROM zone_table WHERE typeIsWire = 0")
    suspend fun getAllWireless(): List<Zone>

    @Query("UPDATE zone_table SET title = :newTitle WHERE zoneId = :id AND typeIsWire = :isWired")
    suspend fun editById(id:String , isWired :Boolean , newTitle: String)

    @Query("UPDATE zone_table SET title = :newTitle AND zoneNooe = :newZoneNooe WHERE zoneId = :id AND typeIsWire = :isWired")
    suspend fun editByIdNooeZone(id:String , isWired :Boolean , newTitle: String , newZoneNooe: ZoneNooe)

    @Query("DELETE FROM zone_table WHERE zoneId = :id AND typeIsWire = :isWired")
    suspend fun deleteById(id: String , isWired :Boolean)

}