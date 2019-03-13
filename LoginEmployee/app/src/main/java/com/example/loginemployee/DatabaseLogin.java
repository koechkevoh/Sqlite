package com.example.loginemployee;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseLogin extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="Employee.db";
    public static final String TABLE_NAME ="Emp_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "FIRST_NAME";
    public static final String COL_3 = "SECOND_NAME";
    public static final String COL_4 = "EMAIL";
    public static final String COL_5 = "EMPLOYEE_NO";
    public static final String COL_6 = "SALARY";

    public DatabaseLogin( Context context) {
        super(context, "Employee.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(email text primary key, password text)");
        db.execSQL("create table "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,FIRST_NAME TEXT,SECOND_NAME TEXT,EMAIL TEXT, EMPLOYEE_NO INTEGER,SALARY INTEGER)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertDataLogin(String email,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email",email);
        contentValues.put("password",password);

        long ins =db.insert("user",null,contentValues);
        if(ins ==-1)
            return false;
            else
                return true;
    }
    public boolean insertData(String firstName,String secondName,String email,String employeeNo,String salary){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,firstName);
        contentValues.put(COL_3,secondName);
        contentValues.put(COL_4,email);
        contentValues.put(COL_5,employeeNo);
        contentValues.put(COL_6,salary );
        long insertD = db.insert(TABLE_NAME,null,contentValues);
        if( insertD==1)
            return false;
        else
            return true;
    }
    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
    public boolean chkEmail(String Email){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor =  db.rawQuery("select* from user where email=?",new String[]{Email});
        if(cursor.getCount()>0)
            return false;
        else
            return true;
    }
    public boolean updateData(String id,String firstName,String secondName,String email,String employeeNo,String salary){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,firstName);
        contentValues.put(COL_3,secondName);
        contentValues.put(COL_4,email);
        contentValues.put(COL_5,employeeNo);
        contentValues.put(COL_6,salary);
        db.update(TABLE_NAME,contentValues,"ID =?",new String[]{id});
        return true;
    }
    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID=?",new String[]{id});
    }

}
