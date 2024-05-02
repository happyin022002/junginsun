/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ReceiveQueueDBDAO.java
 *@FileTitle : ENIS Interface 연동결과 DB Access 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-03-05
 *@LastModifier : Jung-Hyung,Kim
 *@LastVersion : 1.0
 * 2007-03-05 Jung-Hyung,Kim
 * 1.0 최초 생성
 * 
 * 2011.10.20 민정호 [CHM-201113843] 공통 CSR R4J Rule 품질결함 조치
 =========================================================*/
package com.hanjin.bizcommon.erpcom.jms.integration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.HashMap;
import java.sql.Statement;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.loggable.LoggableStateFactory;
import com.hanjin.framework.component.util.loggable.LoggableStatement;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.AP_INV_IF;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 * JMS에서 받은 데이터 DB Logic 처리를 담당한다.<br>
 * 
 * @author Jung-Hyung,Kim
 * @see ReceiveQueueBCImpl 참조
 * @since J2EE 1.4
 */
public class ReceiveQueueDBDAO extends DBDAOSupport{

	/**
	 * AP Interface 결과를 AP_TEMP 테이블에 반영한다. 
	 * @param String div
	 * @param Object obj
	 * @return String
	 */
	public String modifyFNS008R003(String div, Object obj) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		
		try {
			AP_INV_IF model = (AP_INV_IF)obj; 
			String csrNo = model.getHdr_csr_no();
			String ifDate = model.getHdr_if_dt();
			String ifFlag = model.getHdr_if_flg();
			String ifErrRsn = model.getHdr_if_err_rsn();
			String pgmId = "";

			Map<String, String> mapVO = new HashMap<String, String>();			
			mapVO.put("csr_no", csrNo);
			mapVO.put("if_date", ifDate);
			mapVO.put("if_flag", ifFlag);
			mapVO.put("if_err_rsn", ifErrRsn);
					    
			log.debug("csrNo = "+csrNo);
			log.debug("ifDate = "+ifDate);
			log.debug("ifFlag = "+ifFlag);
			log.debug("ifErrRsn = "+ifErrRsn);			
			
			param.putAll(mapVO);           
			velParam.putAll(mapVO);			
					
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ReceiveQueueDBDAOsearchApPgmNoRSQL(), param, velParam);

			while(dbRowset.next()){
				pgmId = dbRowset.getString(1);
			}
			
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.debug(">>>>> pgmId    : " + pgmId);
			log.debug(">>>>> csrNo    : " + csrNo);
			log.debug(">>>>> ifDate   : " + ifDate);
			log.debug(">>>>> ifFlag   : " + ifFlag);
			log.debug(">>>>> ifErrRsn : " + ifErrRsn);
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			
			if(div.equals("I")){	//EAI Interface Result
				int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueDBDAOupdateApInvHdrUSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");			
				
				int result2 = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueDBDAOupdateApPayInvUSQL(), param, velParam);
				if(result2 == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");							
			}else{
				int result3 = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueDBDAOupdateApInvHdr2USQL(), param, velParam);
				if(result3 == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");											
			}
			
			return pgmId;						
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}						
	}
	
	/**
	 * PgmId 를 조회 리턴한다. 
	 * @param String div
	 * @param Object obj
	 * @return String
	 */
	public String getPgmId(String div, Object obj) throws DAOException {
		DBRowSet dbRowset = null;		
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			////변수값 구하기
			AP_INV_IF model = (AP_INV_IF)obj; 
			String csrNo = model.getHdr_csr_no();
			String pgmId = "";						
			mapVO.put("csr_no", csrNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ReceiveQueueDBDAOsearchPgmIdRSQL(), param, velParam);			
			
			while(dbRowset.next()){
				pgmId = dbRowset.getString(1);
			}
			
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.debug(">>>>> pgmId    : " + pgmId);
			log.debug(">>>>> csrNo    : " + csrNo);
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");			
			
			////모듈분기를 위한 리턴값 세팅
			return pgmId;
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
	
	/**
	 * AP Interface 결과를 AP_TEMP 테이블에 반영한다. 
	 * @param Object o
	 * @return String
	 */
	public String modifyFNS0100002(Object o) throws DAOException {
		log.debug("\n\nDAO.modifyFNS0100002 *************************************1818181\n");
		
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			////변수값 구하기
			AP_INV_IF model = (AP_INV_IF)o;  
			String csrNo = model.getHdr_csr_no();
			String pgmId = "";
						
			Map<String, String> mapVO = new HashMap<String, String>();										
			mapVO.put("csr_no", csrNo);			
			mapVO.put("hdr_pay_amt", model.getHdr_pay_amt());			
			mapVO.put("hdr_pay_dt", model.getHdr_pay_dt());
			mapVO.put("hdr_ftu_use_ctnt1", model.getHdr_ftu_use_ctnt1());
			mapVO.put("pay_mzd_lu_cd", model.getHdr_pay_mzd_lu_cd());
			mapVO.put("csr_no", model.getHdr_csr_no());		
						
			param.putAll(mapVO);           
			velParam.putAll(mapVO);				
					
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ReceiveQueueDBDAOsearchPgmIdRSQL(), param, velParam);

			while(dbRowset.next()){
				pgmId = dbRowset.getString(1);
			}		
			
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.debug(">>>>> pgmId    : " + pgmId);
			log.debug(">>>>> csrNo    : " + csrNo);
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");			
				
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueDBDAOupdateApInvHdr3USQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");											
			
			return pgmId!=null&&!pgmId.equals("")?pgmId:"";		
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
		
	}
	
	/**
	 * AP Interface 결과를 TES SO HDR 테이블에 반영한다. 
	 * @param Object o
	 */
	public void modifyTESInvHdr(Object o) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			////변수값 구하기
			AP_INV_IF model = (AP_INV_IF)o; 
			
			Map<String, String> mapVO = new HashMap<String, String>();				
			mapVO.put("hdr_pay_dt", model.getHdr_pay_dt());
			mapVO.put("hdr_csr_no", model.getHdr_csr_no());		
			
			param.putAll(mapVO);           
			velParam.putAll(mapVO);				
													
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueDBDAOupdateTesTmlSoHdrUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");											
			
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}			

	}
	
	/**
	 * AP Interface 결과를 AP_PAY_INV 테이블에 반영한다. 
	 * @param Object o
	 */
	public void modifyCSRPayInv(Object o) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			////변수값 구하기
			AP_INV_IF model = (AP_INV_IF)o; 
			
			Map<String, String> mapVO = new HashMap<String, String>();				
			mapVO.put("hdr_pay_dt", model.getHdr_pay_dt());
			mapVO.put("hdr_pay_amt", model.getHdr_pay_amt());			
			mapVO.put("hdr_csr_no", model.getHdr_csr_no());		
			
			param.putAll(mapVO);           
			velParam.putAll(mapVO);				
													
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueDBDAOupdateApPayInv2USQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");											
			
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}	
	
	public void modifyAPReject(Object obj) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			////변수값 구하기
			AP_INV_IF model = (AP_INV_IF)obj; 
			
			Map<String, String> mapVO = new HashMap<String, String>();				
			mapVO.put("if_flg", "E");	
			mapVO.put("if_err_rsn", "CSR Receipt Error");		
			mapVO.put("csr_no", model.getHdr_csr_no());		
			mapVO.put("cxl_dt", model.getHdr_pay_dt());
			
			param.putAll(mapVO);           
			velParam.putAll(mapVO);				
													
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate)new ReceiveQueueDBDAOupdateApInvHdr4USQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");											
			
		} catch (SQLException ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}		
	}
}