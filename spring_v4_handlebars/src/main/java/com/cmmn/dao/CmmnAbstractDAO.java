//package com.cmmn.dao;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.Resource;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Repository;
//
//import com.cmmn.util.StringUtil;
//import com.ibatis.sqlmap.client.SqlMapClient;
//import egovframework.rte.psl.dataaccess.EgovAbstractDAO;
//
//
///**
//* <pre>
//* 1. 패키지명 : com.cmmn.dao
//* 2. 타입명 : cmmnAbstractDAO.java
//* 3. 작성일 : 2017. 12. 15.
//* 4. 작성자 : linked2ev
//* 5. 설명 : Data Access Object (ibatis)
//* </pre>
// */
//@Repository("cmmnAbstractDAO")
//public class CmmnAbstractDAO extends EgovAbstractDAO { 
//	
//	static final Logger logger = LoggerFactory.getLogger(CmmnAbstractDAO.class);
//
//	@Resource(name = "sqlMapClient")
//    public void setSuperSqlMapClient(SqlMapClient sqlMapClient) { 
//        super.setSqlMapClient(sqlMapClient);
//    }
//	
//	/** 등록 */
//	@SuppressWarnings("rawtypes")
//	public int insert(String queryID,  Map param) throws Exception {
//		return (Integer)StringUtil.getInt(super.insert(queryID, (Object)param), 1);
//	}
//	
//	/** 등록 */
//	@SuppressWarnings("rawtypes")
//	public int insertObj(String queryID, Object obj) throws Exception {
//		return (Integer)StringUtil.getInt(super.insert(queryID, obj), 1);
//	}
//	
//	/** 수정 */
//	@SuppressWarnings("rawtypes")
//	public int update(String queryID, Map param) throws Exception {
//		return (int)update(queryID, (Object)param);
//	}
//
//	/** 수정 */
//	@SuppressWarnings("rawtypes")
//	public int updateObj(String queryID, Object obj) throws Exception {
//		return (int)update(queryID, (Object)obj);
//	}
//
//	/** 삭제 */
//	@SuppressWarnings("rawtypes")
//	public int delete(String queryID, Map param) throws Exception {
//		return (int)delete(queryID, (Object)param);
//	}
//
//	/** 조회 */
//	@SuppressWarnings("rawtypes")
//	public Map select(String queryID, Map param) throws Exception {
//		return (Map) selectByPk(queryID, param);
//	}
//	
//	/** 목록 조회 */
//	@SuppressWarnings("rawtypes")
//	public List selectList(String queryID, Map param) throws Exception {
//		List returnList =  list(queryID, param);
//		if(returnList == null) {
//			returnList = new ArrayList();
//		}
//		return returnList;
//	}
//	
//	/** 목록 총 갯수를 조회 */
//	@SuppressWarnings("rawtypes")
//	public int selectCount(String queryID, Map param) {
//		return (Integer)getSqlMapClientTemplate().queryForObject(queryID, param);
//	}
//	
//	/** 목록 총 갯수를 조회 */
//	@SuppressWarnings("rawtypes")
//	public int selectCount(String queryID, Object object) {
//		return (Integer)getSqlMapClientTemplate().queryForObject(queryID, object);
//	}
//	
//}