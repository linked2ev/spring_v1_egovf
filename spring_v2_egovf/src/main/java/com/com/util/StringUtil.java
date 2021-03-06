package com.com.util;

/**
* <pre>
* 1. 패키지명 : com.com.util
* 2. 타입명 : StringUtil.java
* 3. 작성일 : 2017. 9. 26.
* 4. 설명 : StringUtil
* </pre>
 */
public class StringUtil {


	/**
	* <pre>
	* 1. 메소드명 : getInt
	* 2. 작성일 : 2017. 9. 26.
	* 3. 설명 : String형을 int형으로 변환한다. null 또는 ""이면 0으로 return
	* </pre>
	* @param obj
	* @return
	 */
    public static int getInt(Object obj){
        if(obj == null || obj.toString().equals("")) {
            return 0;
        } else {
            return Integer.parseInt(obj.toString());
        }
    }
    
    /**
    * <pre>
    * 1. 메소드명 : getInt
    * 2. 작성일 : 2017. 9. 26.
    * 3. 설명 : String형을 int형으로 변환한다. null 또는 ""이면 defaultNum(임의값)으로 return
    * </pre>
    * @param obj
    * @param defNum
    * @return
     */
    public static int getInt(Object obj, int defaultNum){
        if(obj == null || obj.toString().equals("")) {
            return defaultNum;
        } else {
            return Integer.parseInt(obj.toString());
        }
    }

    /**
    * <pre>
    * 1. 메소드명 : getString
    * 2. 작성일 : 2017. 9. 26.
    * 3. 설명 : null 또는 ""이면 defaultStr(임의값)으로 return
    * </pre>
    * @param obj
    * @param defStr
    * @return
     */
    public static String getString(Object obj, String defaultStr){
        if(obj == null || obj.toString().equals("")) {
            return defaultStr;
        } else {
            if ("".equals(obj.toString())){
                return defaultStr;
            } else {
                return obj.toString();
            }
        }
    }
      
    /**
    * <pre>
    * 1. 메소드명 : getDateFmt
    * 2. 작성일 : 2017. 10. 11.
    * 3. 설명 : 날짜 형식이 1~9일, 1월~9월 일 경우 01~09 형식으로 return
    * </pre>
    * @param obj
    * @return
     */
    public static String getDateFmt(Object obj){
    	if(obj.toString().length() < 2){
    		return "0" + obj.toString();
    	}else{
    		return obj.toString();
    	}
    }
    
    /**
    * <pre>
    * 1. 메소드명 : getDateReFmt
    * 2. 작성일 : 2017. 12. 1.
    * 3. 설명 : 날짜 형식이 01~09일, 01월~09월 일 경우 1~9 형식으로 return
    * </pre>
    * @param obj
    * @return
     */
    public static String getDateReFmt(Object obj){
    	String str = obj.toString();
       	if(str.length() == 2 && str.substring(0, 1).equals("0")){
    		return str.replace("0", "");
    	}else{
    		return str;
    	}
    }
    
}
