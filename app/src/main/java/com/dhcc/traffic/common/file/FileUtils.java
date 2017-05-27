package com.dhcc.traffic.common.file;

import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Jinx on 2017/5/25.
 */

public class FileUtils {
    /**
     * 应用缓存文件夹
     */
    private static File dir;

    /**
     * 临时文件夹
     */
    private static File cacheDir;
    /**
     * 长时间保存文件夹
     */
    private static File download;

    /**
     * 唯一实例
     */

    private static FileUtils sInstance;

    private FileUtils() {
        dir = new File(Environment.getExternalStorageDirectory(), "Traffic");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        cacheDir = new File(dir, "CacheDir");
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        download = new File(dir, "Download");
        if (!download.exists()) {
            download.mkdirs();
        }
    }

    public static FileUtils getInstance() {
        if (null == sInstance) {
            synchronized (FileUtils.class) {
                if (null == sInstance) {
                    sInstance = new FileUtils();
                }
            }
        }
        return sInstance;
    }

    /**
     * 缓存文件夹
     *
     * @return
     */
    public static File getCacheDir() {
        return cacheDir;
    }

    /**
     * 下载默认存储路径
     *
     * @return
     */
    public static File getDownload() {
        return download;
    }

    /**
     * 用于（退出程序前）清除临时文件
     */
    public void clearCache() {
        deleteFile(cacheDir);
    }

    /**
     * 删除文件
     *
     * @param file
     */
    private void deleteFile(File file) {

        if (file == null || !file.exists()) {
            return;
        } else {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (int i = 0; i < files.length; i++) {
                    deleteFile(files[i]);
                }
            }
            file.delete();
        }
    }

    /**
     * 复制文件
     *
     * @param source
     * @param dest
     * @throws IOException
     */
    private static void copyFile(File source, File dest)
            throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } finally {
            input.close();
            output.close();
        }
    }

}
