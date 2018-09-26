package com.suda.yzune.wakeupschedule.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.suda.yzune.wakeupschedule.bean.TableBean
import com.suda.yzune.wakeupschedule.bean.TableSelectBean

@Dao
interface TableDao {
    @Insert
    fun insertTable(tableBean: TableBean)

    @Update
    fun updateTable(tableBean: TableBean)

    @Query("select * from tablebean where id = :tableId")
    fun getTableByIdInThread(tableId: Int): TableBean

    @Query("select * from tablebean where id = :tableId")
    fun getTableById(tableId: Int): LiveData<TableBean>

    @Query("select * from tablebean where type = 1")
    fun getDefaultTable(): LiveData<TableBean>

    @Query("select id, tableName, background, type from tablebean")
    fun getTableSelectList(): LiveData<List<TableSelectBean>>
}