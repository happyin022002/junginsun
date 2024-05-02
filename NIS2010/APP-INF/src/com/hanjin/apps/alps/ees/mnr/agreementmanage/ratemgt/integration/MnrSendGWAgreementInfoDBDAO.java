/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MnrSendGWAgreementInfoBCImpl.java
*@FileTitle : G/W 전송 xmlData Agreement, AttachFile Info
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.04
*@LastModifier : Chang Young Kim
*@LastVersion : 1.0
* 2009.05.19 Chang Young Kim
* 1.0 Creation 
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestFileVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS MnrSendGWAgreementInfoDBDAO <br>
 * - ALPS - G/W as Agreement, AttachFile Info Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Chang Young Kim
 * @see MnrSendGWAgreementInfoBCImpl 참조
 * @since J2EE 1.4
 */
public class MnrSendGWAgreementInfoDBDAO extends DBDAOSupport {
	 
	/**
	 * groupware 전송 xmlData Agreement info<br>
	 * 
	 * @author Chang Young Kim
	 * @category COM_CSR_0008
	 * @category printComCsrAgmtInfo 
	 * @param String csrNo
	 * @return List<ComCsrRequestAgmtVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ComCsrRequestAgmtVO> printComCsrAgmtInfo(String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComCsrRequestAgmtVO> list = null;
		
		try{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			// csr No
			param.put("csr_no", csrNo);
			
			// velocity parameter 설정 
			velParam.putAll(param);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MnrSendGWAgreementInfoDBDAOPrintComCsrAgmtInfoRSQL(), param, velParam);		  
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComCsrRequestAgmtVO.class);		 
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}		
		return list;	  
	}
		
	/**
	 * groupware 전송 xmlData Agreement info<br>
	 * CSR No. , VNDR Seq. , Inv No. 추가
	 * 
	 * @author Chang Young Kim
	 * @category COM_CSR_0008
	 * @category printComCsrAgmtInfo 
	 * @param String csrNo
	 * @return List<ComCsrRequestAgmtVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ComCsrRequestAgmtVO> printComCsrAgmtInfo2(String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComCsrRequestAgmtVO> list = null;
		
		try{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			// csr No
			param.put("csr_no", csrNo);
			
			// velocity parameter 설정 
			velParam.putAll(param);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MnrSendGWAgreementInfoDBDAOPrintComCsrAgmtInfo2RSQL(), param, velParam);		  
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComCsrRequestAgmtVO.class);		 
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}		
		return list;	  
	}
	
	/**
	 * groupware 전송 xmlData File info<br>
	 * 
	 * @author Chang Young Kim
	 * @category COM_CSR_0008
	 * @category printComCsrFileInfo 
	 * @param String csrNo
	 * @return List<ComCsrRequestFileVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ComCsrRequestFileVO> printComCsrFileInfo(String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ComCsrRequestFileVO> list = null;
		
		try{
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			// csr No
			param.put("csr_no", csrNo);
			
			// velocity parameter 설정 
			velParam.putAll(param);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new MnrSendGWAgreementInfoDBDAOPrintComCsrFileInfoRSQL(), param, velParam);		  
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComCsrRequestFileVO.class);		 
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}		
		return list;
	}
}
