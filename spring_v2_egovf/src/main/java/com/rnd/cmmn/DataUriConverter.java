package com.rnd.cmmn;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.com.util.StringUtil;

/**
* <pre>
* 1. 패키지명 : com.rnd.cmmn
* 2. 타입명 : DataUriConverter.java
* 3. 작성일 : 2017. 11. 3.
* 4. 설명 : DataUriConverter > dataUri를 이미지로 컨버팅하는 클래스
* </pre>
 */
public class DataUriConverter {
	  
	static final Logger logger = LoggerFactory.getLogger(DataUriConverter.class);
	
	/**
	* <pre>
	* 1. 메소드명 : fileUpload
	* 2. 작성일 : 2017. 11. 3.
	* 3. 설명 : 
	* </pre>
	* @param request
	* @param commandMap
	* @param dirName    : 업로드 경로 폴더 이름
	* @return
	* @throws IOException
	 */
	public Map<String, Object> fileUpload(HttpServletRequest request, Map<String, Object> commandMap, String dirName) throws IOException
	{ 
		logger.info("============================= DataUriConverter 시작 ==============================");
		
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		String webRootPath = (String) request.getAttribute("webRootPath");
		String uploadPath  = (String) request.getAttribute("uploadPath");
		String examMngNo   = StringUtil.getString(commandMap.get("EXAM_MNG_NO"), "");
	    String userId      = StringUtil.getString(commandMap.get("USER_ID"), "");
		 
		String signData = StringUtil.getString(commandMap.get("AGREE_SIGN_DATAURL"), "");
		String signId   = StringUtil.getString(commandMap.get("AGREE_SIGN_ID"), "");
		signData = signData.substring(signData.indexOf(",")+1);
		byte[] imgBtyes = Base64.decodeBase64(signData.getBytes());
		  
		
	    Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
	
        // 디렉토리 경로 설정
        webRootPath = webRootPath + dirName +"/"+ sdf.format(d) +"/"+"NO"+ examMngNo+ "_" +userId +"_"+ signId+".png";
        uploadPath  = uploadPath  + dirName +"/"+ sdf.format(d) +"/"+"NO"+ examMngNo+ "_" +userId +"_"+ signId+".png";
	    
        // 디렉토리 존재하지 않을경우 디렉토리 생성
        File file = new File(uploadPath);
        if(!file.exists()) 
        {
            file.mkdirs();
        }
        
        // 파일 존재 시 파일 삭제
        if(file.exists()){
            if(file.delete()){
            	logger.info("파일삭제 성공");
            }else{
            	logger.info("파일삭제 실패");
            }
        }
        
        OutputStream os = new FileOutputStream(uploadPath);
        returnMap.put("webRootPath", webRootPath);
        
		os.write(imgBtyes);
		os.close();
		os.flush();
			
		logger.info("============================== DataUriConverter 종료 ==============================");
		 
		return returnMap; 
	}

}
