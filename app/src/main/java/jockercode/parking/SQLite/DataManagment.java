package jockercode.parking.SQLite;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class DataManagment {

    public static void Backup(){
        try{
            String inFileName,outFileName;
                inFileName = "/data/data/com.parking" +
                        ".parking/databases/parking.db";
                outFileName = Environment.getExternalStorageState()+"/parkingDB.db";

            File dbFile = new File(inFileName);
            FileInputStream fis = new FileInputStream(dbFile);

            OutputStream output = new FileOutputStream(outFileName);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer))>0){
                output.write(buffer, 0, length);
            }

            output.flush();
            output.close();
            fis.close();
        }catch (Exception e){
            Log.i("sync<>", "Error save sqlite "+ e.getMessage());
        }
    }
    public static void Restore(){
        try{
            String inFileName,outFileName;
            inFileName = Environment.getExternalStorageState()+"/parkingDB.db";
            outFileName = "/data/data/com.parking" +
                    ".parking/databases/parking.db";

            File dbFile = new File(inFileName);
            FileInputStream fis = new FileInputStream(dbFile);

            OutputStream output = new FileOutputStream(outFileName);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer))>0){
                output.write(buffer, 0, length);
            }

            output.flush();
            output.close();
            fis.close();
        }catch (Exception e){
            Log.i("sync<>", "Error save sqlite "+ e.getMessage());
        }
    }
}
