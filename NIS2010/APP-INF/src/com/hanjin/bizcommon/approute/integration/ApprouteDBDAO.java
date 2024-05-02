/*=========================================================
*Copyright(c) 2008 CyberLogitec
*@FileName : ModifyDBDAO.java
*@FileTitle : VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2008-08-29
*@LastModifier : Jeong-Hoon Kim
*@LastVersion : 1.1
* 2006-10-31 Jeong-Hoon KIM
* 1.0 최초 생성
* 
* 2011.10.20 민정호 [CHM-201113843] 공통 CSR R4J Rule 품질결함 조치
* 2011.11.14 민정호 [CHM-201114322] ALPS CSR R4J 소스결함 수정
=========================================================*/
package com.hanjin.bizcommon.approute.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.bizcommon.approute.event.ApprouteEvent;
import com.hanjin.bizcommon.approval.basic.ApprovalBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;

import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;

/**
 * ALPS BrcsCustomsTransmissionDBDAO <br>
 * - ALPS-CustomsDeclaration system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Jeong-Hoon, KIM
 * @see ApprovalBCImpl 참조
 * @since J2EE 1.4
 */
public class ApprouteDBDAO extends DBDAOSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
		
	/**
	 * StaffList를 찾는다.
	 * 
	 * @param Event et
	 * @return DBRowSet
	 * @throws DAOException03
	 */
	public DBRowSet searchStaffList(Event et) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
    	ApprouteEvent event=(ApprouteEvent)et;
        String ofc_cd_deptsrch = event.getOfc_cd_deptsrch();    	
    	
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();        
        
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd_deptsrch", ofc_cd_deptsrch);

			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ApprouteDBDAOsearchStaffListRSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbRowset;    			
	}
	
	/**
	 * Department를 찾는다.
	 * @author Jeong-Hoon, KIM
	 * @return
	 * @throws DAOException
	 * 2008. 09. 03
	 */
	public DBRowSet searchDeptList() throws DAOException {		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();        
        
		try {			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ApprouteDBDAOsearchDeptListRSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbRowset;  				
	}
	
	/**
	 * ApprovalRoute List를 찾는다.
	 * @author Jeong-Hoon, KIM
	 * @param et
	 * @return
	 * @throws DAOException
	 * 2008. 09. 03
	 */
	public DBRowSet searchApprovalRouteList(Event et) throws DAOException {
		// PDTO(Data Transfer Object including Parameters)
    	ApprouteEvent event=(ApprouteEvent)et;		
    	String csrNo = event.getCsrNo();
    	
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();        
        
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("csr_no", csrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ApprouteDBDAOsearchStaffListRSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return dbRowset;      	    	
	}
	
	/**
	 * Approval Route 정보를 저장한다.<br>
	 * 
	 * @param et 
	 * @param user_id 
	 * @throws DAOException
	 */
	public void saveApprovalRoute(Event et, String user_id) throws DAOException {
		ApprouteEvent event=(ApprouteEvent)et;
		String csrNo = event.getCsrNo();
			
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam2 = new HashMap<String, Object>();		
		
		int result = -1;
		
		try {
			ArrayList<ComAproRqstRoutVO> comAproRqstRoutVOs = new ArrayList<ComAproRqstRoutVO> ();
						
			String apro_rqst_no = getApro_rqst_no(csrNo);
            if(!"".equals(apro_rqst_no)){  			// Delete          
    			Map<String, String> mapVO = new HashMap<String, String>();            	
				mapVO.put("apro_rqst_no", apro_rqst_no);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
            	SQLExecuter sqlExe = new SQLExecuter("");
				result = sqlExe.executeUpdate((ISQLTemplate) new ApprouteDBDAOdeleteApprovalRouteDSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");            	            	
            }
			
            // 화면 Sheet1에서 입력된 정보 받기  
            String[] arr_apro_seq         	= (String[])event.getObject("apro_seq");          
            String[] arr_usr_id         	= (String[])event.getObject("apro_usr_id");       
            String[] arr_usr_nm             = (String[])event.getObject("apro_usr_nm");           
            String[] arr_ofc_cd 	       	= (String[])event.getObject("apro_ofc_cd");      
            String[] arr_title        		= (String[])event.getObject("apro_usr_jb_tit_nm");       
            String[] arr_apspo_cd        	= (String[])event.getObject("apspo_cd");  
            
			int rowCount = (arr_apro_seq==null) ? 0 : arr_apro_seq.length;
//			int insCnt = 0;
			String spspo_cd = "";
			
			for(int k=0; k<rowCount; k++) {
				ComAproRqstRoutVO comAproRqstRoutVO = new ComAproRqstRoutVO();
				
				comAproRqstRoutVO.setAproRqstNo(apro_rqst_no);
				comAproRqstRoutVO.setAproRqstSeq(arr_apro_seq[k]);
				comAproRqstRoutVO.setAproUsrId(arr_usr_id[k]);
				comAproRqstRoutVO.setAproUsrNm(arr_usr_nm[k]);
				comAproRqstRoutVO.setAproOfcCd(arr_ofc_cd[k]);
				comAproRqstRoutVO.setAproUsrJbTitNm(arr_title[k]);
				comAproRqstRoutVO.setCreUsrId(user_id);
				comAproRqstRoutVO.setUpdUsrId(user_id);
				comAproRqstRoutVO.setDeltFlg("N");
				spspo_cd = "Approved".equals(arr_apspo_cd[k]) ? "C" : null;
				comAproRqstRoutVO.setApstsCd(spspo_cd);
				
				comAproRqstRoutVOs.add(comAproRqstRoutVO);
			}
			
			if ( comAproRqstRoutVOs.size() > 0){
				int updCnt[] = null;
				SQLExecuter sqlExe = new SQLExecuter("");
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ApprouteDBDAOaddApprovalRouteCSQL(), comAproRqstRoutVOs, velParam2);
				for (int i = 0; i < updCnt.length; i++)
				{
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");

				}
			}			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}				
	}


	/**
	 * Approval Requst No 정보를 조회한다.<br>
	 * 
	 * @param et 
	 * @param user_id 
	 * @throws DAOException
	 */	
	private String getApro_rqst_no(String csrNo) throws DAOException {		
		String sRtn = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("csr_no", csrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ApprouteDBDAOsearchAproRqstNoRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				sRtn = dbRowset.getString("APRO_RQST_NO");
			} else {
				sRtn = "";
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return sRtn;		
	}
}