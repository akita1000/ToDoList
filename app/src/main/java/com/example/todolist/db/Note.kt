package com.example.todolist.db
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.text.DateFormat

@Entity(tableName = "note_table")
@Parcelize
data class Note(
    val created: Long = System.currentTimeMillis(),
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val _id: String,
    val title: String,
    val note: String
) : Parcelable {
    val createdData : String
        get() = DateFormat.getDateTimeInstance().format(created)
}
