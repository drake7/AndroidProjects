package com.example.todolist.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.todolist.model.ToDoModel;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private SQLiteDatabase db;

    private static final String DATABASE_NAME = "TODO_DATABASE";
    private static final String TABLE_NAME = "TODO_TABLE";
    private static final String COL1 = "ID";
    private static final String COL2 = "TASk";
    private static final String COL3 = "Status";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME+"(ID INTEGER PRIMArY KEY AUTOINCREMENT ," +
                "TASK text,STATUS INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTs "+ TABLE_NAME);
        onCreate(db);
    }


    public void insertTask(ToDoModel model)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL2,model.getTask());
        values.put(COL3,model.getStatus());
        db.insert(TABLE_NAME,null,values);

    }

    public void updateTask(int id, String task)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL2,task);
        db.update(TABLE_NAME,values,"ID=?",new String[]{String.valueOf(id)});
    }

    public void updateStatus(int id ,int status)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL3,status);
        db.update(TABLE_NAME,values,"ID=?",new String[]{String.valueOf(id)});
    }

    public void deleteTask(int  id)
    {
        db = this.getWritableDatabase();
        db.delete(TABLE_NAME,"ID=?",new String[]{String.valueOf(id)});
    }

    public List<ToDoModel> getAllTask() {
        db = this.getWritableDatabase();
        Cursor cursor = null;

        List<ToDoModel> modelList = new ArrayList<>();
        db.beginTransaction();
        try {
            cursor = db.query(TABLE_NAME, null, null, null, null, null, null);
            if (cursor != null) {
                if (cursor.moveToFirst())
                    do {
                        ToDoModel task = new ToDoModel();
                        task.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COL1)));
                        task.setTask(cursor.getString(cursor.getColumnIndexOrThrow(COL2)));
                        task.setStatus(Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(COL3))));
                        modelList.add(task);
                    } while (cursor.moveToNext());
            }
        } finally {
            db.endTransaction();
            cursor.close();

        }
        return modelList;
}
}
