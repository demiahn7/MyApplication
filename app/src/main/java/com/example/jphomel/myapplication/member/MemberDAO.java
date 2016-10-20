package com.example.jphomel.myapplication.member;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.jphomel.myapplication.util.Retval;

import java.util.ArrayList;

/**
 * Created by jpHomeL on 2016-10-01.
 */

public class MemberDAO extends SQLiteOpenHelper {
    public static final String DB_NAME = "hanbit.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "member";
    public static final String ID = "id";
    public static final String PW = "pw";
    public static final String NAME = "name";
    public static final String ADDR = "addr";
    public static final String PHONE = "phone";
    public static final String EMAIL = "email";
    public static final String PROFILEIMG = "profileImg";    
    
    //생성자
    public MemberDAO(Context context) {             //Context 는 실제 물리 메모리칩 상에 산재되어 있는 어플리케이션의 실제 주소(위치, 인덱스) 값이다.
        super(context, DB_NAME, null, DB_VERSION);  //위치값, 만들려는 db 명, 팩토리, 버전
        this.getWritableDatabase();                 //입력 가능한 db 로 만든다.
        Log.i("db 생성되면 로그가 보인다.....", "");
    }

    //FIXME - db 최초 생성시 한 번만 실행된다.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql =
        "create table if not exists member("
                +"id          text    primary key,"
                +"pw          text,"
                +"name        text,"
                +"addr        text,"
                +"phone       text,"
                +"email       text,"
                +"profileImg  text "
        +");";
        db.execSQL(sql);

        db.execSQL("insert into member(id, pw, name, addr, phone, email, profileImg)values('hong1','1','홍일동','seoul','010-1111-2222','hong1@gamil.com','');");
        db.execSQL("insert into member(id, pw, name, addr, phone, email, profileImg)values('hong2','2','홍이동','37.5597680,126.9423080','010-1111-2222','hong2@gamil.com','');");
        db.execSQL("insert into member(id, pw, name, addr, phone, email, profileImg)values('hong3','3','홍삼동','37.5597680,126.9423080','010-1111-2222','hong3@gamil.com','');");
        db.execSQL("insert into member(id, pw, name, addr, phone, email, profileImg)values('hong4','4','홍사동','seoul','010-1111-2222','hong4@gamil.com','');");
    }

    //TODO - 의미 확인!
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("insert into Android values(null, 'android_6.0.0', 1);");
        db.execSQL("insert into Android values(null, 'android_6.0.1', 2);");
        this.onCreate(db);
    }


    public ArrayList<MemberDTO> selectList() {
        Log.i("=== DAO 다건조회", "selectList() 진입");

        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
        String sql = "select "
                        +String.format(" %s, %s, %s, %s, %s, %s, %s", ID, PW, NAME, ADDR, PHONE, EMAIL, PROFILEIMG)
                        +" from member;";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null); //for readable

        if (cursor != null) {
            Log.i("=== DAO list 조회결과", "success");
            cursor.moveToFirst();   //블록 카피
        }

        do {
            MemberDTO temp = new MemberDTO();
            temp.setId(cursor.getString(0));
            temp.setPw(cursor.getString(1));
            temp.setName(cursor.getString(2));
            temp.setAddr(cursor.getString(3));
            temp.setPhone(cursor.getString(4));
            temp.setEmail(cursor.getString(5));
            temp.setProfileImg(cursor.getString(6));

            list.add(temp);
        }
        while (cursor.moveToNext());

        return list;
    }

    //메서드 명은 같지만 파라미터가 다르므로 사용가능 --> 오버로드
    public ArrayList<MemberDTO> selectList(MemberDTO params) {
        Log.i("=== DAO 다건조회", "selectList() 진입 2");

        ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
        String sql = ""
                +String.format(" select %s, %s, %s, %s, %s, %s, %s", ID, PW, NAME, ADDR, PHONE, EMAIL, PROFILEIMG)
                +String.format("   from %s  where %s = '%s'", TABLE_NAME, NAME, params.getName());

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null); //for readable

        if (cursor != null) {
            Log.i("=== DAO list 조회결과", "success");
            cursor.moveToFirst();   //두 라인 이상일때 블록 카피
        }

        do {
            MemberDTO temp = new MemberDTO();
            temp.setId(cursor.getString(0));
            temp.setPw(cursor.getString(1));
            temp.setName(cursor.getString(2));
            temp.setAddr(cursor.getString(3));
            temp.setPhone(cursor.getString(4));
            temp.setEmail(cursor.getString(5));
            temp.setProfileImg(cursor.getString(6));

            list.add(temp);
        }
        while (cursor.moveToNext());

        return list;
    }

    public MemberDTO selectOne(MemberDTO params) {
        Log.i("=== DAO 단건조회", "selectOne() 진입");

        String sql = ""
                +String.format(" select %s, %s, %s, %s, %s, %s, %s", ID, PW, NAME, ADDR, PHONE, EMAIL, PROFILEIMG)
                +String.format("   from %s  where %s = '%s'", TABLE_NAME, ID, params.getId());

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null); //for readable

        MemberDTO temp = new MemberDTO();
        if (cursor.moveToNext()) {
            //temp = new MemberDTO();
            temp.setId(cursor.getString(0));
            temp.setPw(cursor.getString(1));
            temp.setName(cursor.getString(2));
            temp.setAddr(cursor.getString(3));
            temp.setPhone(cursor.getString(4));
            temp.setEmail(cursor.getString(5));
            temp.setProfileImg(cursor.getString(6));
        }

        return temp;
    }

    public int count() {
        Log.i("=== DAO 전체 회원 수", "count()");

        String sql = " select count(*) as cnt from member;";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null); //for readable

        int cnt = 0;
        if (cursor.moveToNext()) {
            cnt = cursor.getInt(cursor.getColumnIndex("cnt"));
        }

        return cnt;
    }

    public Retval insert(MemberDTO params) {
        Log.i("=== DAO 등록", "insert() 진입");

        String sql = "insert into "+TABLE_NAME
                +String.format(" (%s, %s, %s, %s, %s, %s, %s)", ID, PW, NAME, ADDR, PHONE, EMAIL, PROFILEIMG)
                +String.format(" values('%s', '%s', '%s', '%s', '%s', '%s', '%s')", params.getId(), params.getPw(), params.getName(), params.getAddr(), params.getPhone(), params.getEmail(), params.getProfileImg())
                     ;
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);    //for writable
        db.close();         //for writable

        Retval retval = new Retval();
        if (true) {
            retval.setMessage("SUCCESS");
        }
        else {
            retval.setMessage("FAIL");
        }

        return retval;
    }

    public void update(MemberDTO params) {
        Log.i("=== DAO 수정", "update() 진입");

        String sql = ""
                +String.format(" update %s", TABLE_NAME)
                +String.format("    set %s = '%s', %s = '%s', %s = '%s', %s = '%s'", PW, params.getPw(), ADDR, params.getAddr(), EMAIL, params.getEmail(), PROFILEIMG, params.getProfileImg())
                +String.format( " where %s = '%s'", ID, params.getId());

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);    //for writable
        db.close();         //for writable
    }

    public void delete(MemberDTO params) {
        Log.i("=== DAO 삭제", "delete() 진입");

        String sql = ""
                +String.format(" delete from %s", TABLE_NAME)
                +String.format( " where %s = '%s'", ID, params.getId());

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);    //for writable
        db.close();         //for writable
    }
}
