package soBadWithNames.utils;

import soBadWithNames.constants.EnvType;

import java.util.Properties;

public class configLoader {
    private final Properties properties;
    private static configLoader configLoader;

    private configLoader(){
        String env = System.getProperty("env", String.valueOf(EnvType.STAGE));
        if(env.equals(String.valueOf(EnvType.PROD))){
            properties = propertyUtils.propertyLoader("src/test/resources/prod_config.properties");
        }else if (env.equals(String.valueOf(EnvType.STAGE))){
            properties = propertyUtils.propertyLoader("src/test/resources/stage_config.properties");
        }else{
            throw new IllegalStateException("INVALID ENV: " + env);
        }
    }

    public static configLoader getInstance() {
        if(configLoader == null){
            configLoader = new configLoader();
        }
        return configLoader;
    }

    public String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if(prop != null) return prop;
        else throw new RuntimeException("property baseUrl is not specified in stage_config.properties file.");
    }
}
