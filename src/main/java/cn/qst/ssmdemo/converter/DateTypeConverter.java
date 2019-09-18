package cn.qst.ssmdemo.converter;
import org.springframework.core.convert.converter.Converter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jiangheng
 * @date 2019/9/18 15:58
 * @description   时间和字符串之间的转换
 */
public class DateTypeConverter implements  Converter<String,Date> {

    private static final String  STR_DATE = "yyyy-MM-dd";
    private static final String  STR_DATETIME = "yyyy-MM-dd hh:mm:ss";
    private static final String  STR_ALLDATE = "yyyy-MM-dd hh:mm:ss:sss";

    @Override
    public Date convert(String s) {
        return stringToDate(s);
    }
    private Date stringToDate(String value){
        Date date = null;
        if(!"".equals(value)&& value!=null){
            //去除字符串中的空格
            String strValue = value.trim();
            String formateStr = STR_DATE;
            if(strValue.length()<=10){

            }else if (strValue.length()<=19){
                formateStr = STR_DATETIME;
            }else if(strValue.length()<=23){
                formateStr = STR_ALLDATE;
            }

            //使用SimpleDateFormate转换,先定义转换成的模板类型
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formateStr);
           //将需要转换的字符串转换成模板样式
            try {
                if(strValue.contains("/")){
                    //replaceAll的用法，第一个参数是字符串中要替换的字符，第二个参数是替换成按个字符
                    strValue = strValue.replaceAll("/","-");
                }
                date = simpleDateFormat.parse(strValue);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }


        return date;
    }
}
