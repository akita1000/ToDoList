package com.example.todolist.db
import android.os.Parcelable
import android.text.Editable
import android.widget.EditText
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.text.DateFormat

@Entity(tableName = "note_table")
@Parcelize
data class Note(
  //  val created: String = System.currentTimeMillis(),
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String
) : Parcelable {
  //  val createdData : String
       // get() = DateFormat.getDateTimeInstance().format(created)
}
