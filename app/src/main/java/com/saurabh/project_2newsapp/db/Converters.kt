package com.saurabh.project_2newsapp.db

import androidx.room.TypeConverter
import com.saurabh.project_2newsapp.models.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source?): String? {
        return source?.name
    }

    @TypeConverter
    fun toSource(name: String?): Source? {
        return name?.let { Source(it, it) }
    }
}