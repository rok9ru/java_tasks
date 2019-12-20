package com.company;


import java.io.*;
import java.util.Properties;

public class ProperReader {
    public ProperReader(){
    }

    public ProperReader(String file) throws IOException {
        this.setFile(file);
    }

    public ProperReader(String[] files) throws IOException {
        for (String file : files)
            this.setFile(file);
    }

    private Properties properties = new Properties();
    private String path = ".";
    private File file = new File(path);


    public String readValue(String key) throws PropertyNotFoundException {
        if (properties.containsKey(key)) {
            return properties.getProperty(key);
        }

        throw new PropertyNotFoundException(key);
    }

    public ProperReader setFile(String path) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(
                new FileInputStream(new File(file.getPath() + '/' + path + ".properties"))
        );
        properties.load(bufferedInputStream);
        return this;
    }
}
