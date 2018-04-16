package vn.edu.imic.clonelazada.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Environment;
import android.support.v4.media.session.PlaybackStateCompat;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by MyPC on 01/03/2018.
 */

public class ImageUtils {
    /**
     *
     * @param bitmap
     * @param maxSize
     * @return
     */
    public static Bitmap resizedBitmap(Bitmap bitmap, int maxSize){
        //Khai báo kich thước ảnh ra
        int outWidth;
        int outHeight;
        //Kích thước ảnh vào
        int intWidth = bitmap.getWidth();
        int intHeight = bitmap.getHeight();
        if (intWidth > intHeight){
            outWidth = maxSize;
            outHeight = (intHeight * maxSize)/intWidth;
        }else {
            outHeight = maxSize;
            outWidth = (intWidth * maxSize)/intHeight;
        }
        return Bitmap.createScaledBitmap(bitmap,outWidth,outHeight,false);
    }

    public static int[] getImageSize(String path){
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path,options);
        int width = options.outWidth;
        int height = options.outHeight;
        return new int[]{width,height};
    }

    public static int[] getImageDimension(String filePath){
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath,options);
        int imageWidth = options.outWidth;
        int imageHeight = options.outHeight;
        return new int[]{imageWidth,imageHeight};
    }

    public static int getImageSizeByKB(String filePath){
        return Integer.parseInt(String.valueOf(
                new File(filePath).length()/ PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID));
    }

    public static String copyAndResizeImage(String filePath){
        int imageSize = getImageSizeByKB(filePath);
        Logger.d("Image twitter size is: " + imageSize);
        if (imageSize < 3072){
            Logger.d("Image size is smaller than 3M");
            return filePath;
        }
        File dir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES + File.separator + Logger.TAG);
        boolean success = true;
        if (!dir.exists()){
            success = dir.mkdirs();
        }
        if (!success){
            return "";
        }

        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
        Bitmap out = resizedBitmap(bitmap,1024);
        File newFile = new File(dir,System.currentTimeMillis() + ".png");
        try{
            FileOutputStream fos = new FileOutputStream(newFile);
            out.compress(Bitmap.CompressFormat.PNG,100,fos);
            fos.flush();
            fos.close();
            bitmap.recycle();
            out.recycle();
        }catch (Exception ex){
            Logger.d("Can't write the file");
        }
        return newFile.getAbsolutePath();
    }
}
