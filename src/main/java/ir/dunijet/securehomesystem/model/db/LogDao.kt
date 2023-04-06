package ir.dunijet.securehomesystem.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.dunijet.securehomesystem.model.data.Log

@Dao
interface LogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(newLog: Log)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(newLogs: List<Log>)

    @Query("SELECT * FROM log_table")
    suspend fun getAll(): List<Log>

}