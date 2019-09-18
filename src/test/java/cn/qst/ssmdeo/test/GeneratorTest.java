package cn.qst.ssmdeo.test;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangheng
 * @date 2019/9/16 12:49
 * @description
 */
public class GeneratorTest {
    @Test
    public void test(){
       /* String path =this.getClass().getClassLoader().getResource("generator-config.xml").getPath( );
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File(path);
        ConfigurationParser cp = new ConfigurationParser(warnings);

        DefaultShellCallback callback = null;
        try {
            Configuration config = cp.parseConfiguration(configFile);
            callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
    }

}
