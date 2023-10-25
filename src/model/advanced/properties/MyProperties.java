package model.advanced.properties;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 配置文件类
 *
 * @author: east
 * @date: 2023/10/25
 */

public class MyProperties {
    private String oracleUrl;
    private String oracleUser;
    private String oraclePassword;

    public MyProperties() {
        loadProperties();
    }

    private void loadProperties() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("config.properties")) {
            properties.load(fileInputStream);
            this.oracleUrl = properties.getProperty("ds.ds1.url");
            this.oracleUser = properties.getProperty("ds.ds1.user");
            this.oraclePassword = properties.getProperty("ds.ds1.password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getOracleUrl() {
        return oracleUrl;
    }

    public String getOracleUser() {
        return oracleUser;
    }

    public String getOraclePassword() {
        return oraclePassword;
    }

    public static void main(String[] args) {
        MyProperties myProperties = new MyProperties();
        System.out.println(myProperties.getOracleUrl());
    }
}
