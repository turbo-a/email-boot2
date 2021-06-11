package com.yaorange.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class BackupMySQLJob extends QuartzJobBean {
    private static final Logger logger = LoggerFactory.getLogger(BackupMySQLJob.class);

    @Value("${mysql.backup.dbname}")
    private String dbName;
    @Value("${mysql.backup.path}")
    private String path;

//    private final String DB_NAME = "crm";
//    private final String BACKUP_PATH="E:\\CRM_DB_BACKUP\\";
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info(new Date().toLocaleString()+":开始备份......");
        long start = System.currentTimeMillis();
        //准备命令，注意空格
        String cmd = "mysqldump -uroot -proot "+dbName;
        try {
            //创建Runtime
            Runtime runtime = Runtime.getRuntime();
            //调用方法获取
            Process process = runtime.exec(cmd);
            //调用方法获取生成的sql文件输入流
            InputStream inputStream = process.getInputStream();
            //转换字节流为字符流
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            //准备定义输出文件名
            //定义目录名
            String dirName = new SimpleDateFormat("yyyy-MM").format(new Date());
            //定义文件后缀名
            String fileName = new SimpleDateFormat("yyyy-MM-dd-HHmmss").format(new Date());
            fileName = dbName+"-"+fileName+".sql";
            //创建File对象
            File file = new File(path + dirName, fileName);
            if(!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            //数据输出
            //准备输出流
            PrintWriter writer = new PrintWriter(file);
            //通过输入流循环读取数据，使用输出流输出
            String lineData = null;
            while ((lineData = bufferedReader.readLine()) != null){
                writer.println(lineData);//换行输出
            }
            writer.flush();
            writer.close();

            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

            //TODO 后期基础日志框架后，应该将备份信息记录日志
            //日志记录：备份耗时，备份文件大小
            long end = System.currentTimeMillis();
            double times = end - start;
            long fileSize = file.length();
            logger.info(new Date().toLocaleString()+":备份结束......");
            logger.info("文件名："+fileName);
            logger.info("文件大小："+(fileSize/1024.0));
            logger.info("总共耗时："+(times/1000)+"秒");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
