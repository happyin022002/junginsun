/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CSRApprovalCommonManagementDBDAO.java
*@FileTitle : Approval Step & Comments
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.10
*@LastModifier : 9014787
*@LastVersion : 1.0
* 2014.07.10 9014787
* 1.0 Creation
* -------------------------------------------------------
* History
* 
=========================================================*/
package com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.vo.CSRApprovalCommonManagementVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS CSRApprovalCommonManagementDBDAO <br>
 * - ALPS-CSRCommonManagement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author 9014787
 * @see CSRApprovalCommonManagementBCImpl 참조
 * @since J2EE 1.6
 */

public class CSRApprovalCommonManagementDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;
	private String dataSource = "";

	/**
	 * COM_CSR_0020 조회 이벤트 처리
	 * Approval Step & Comments :COM_CSR_0020 화면에 대한 조회 이벤트 처리
	 * @param CSRApprovalCommonManagementVO vo
	 * @return List<CSRApprovalCommonManagementVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CSRApprovalCommonManagementVO> aproStepAndCmt(CSRApprovalCommonManagementVO vo) throws DAOException {
		DBRowSet dbRowset = null;  
		List<CSRApprovalCommonManagementVO> list = null;
			
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>(); 
		try{ 
			/*Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("login_usr_id", "pkg0024");
			mapVO.put("apro_rqst_no", "2014071089818");*/
			
			
			Map<String, String> mapVO = vo.getColumnValues();
		    
			param.putAll(mapVO);           
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate)new CSRApprovalCommonManagementDBDAOAproStepAndCmtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CSRApprovalCommonManagementVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se); 
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		} 
		return list;
	}

	
	/**
	 * COM_CSR_0020 멀티 이벤트 처리
	 * Approval Step & Comments : COM_CSR_0020  화면에 대한 멀티 이벤트 처리
	 * @param CSRApprovalCommonManagementVO vo
	 * @throws DAOException, Exception
	 */
	public void commentSave(CSRApprovalCommonManagementVO vo) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = vo.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			SQLExecuter sqlExe = new SQLExecuter(this.dataSource);
			int result = sqlExe.executeUpdate((ISQLTemplate)new CSRApprovalCommonManagementDBDAOSavCmtUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		log.debug("commentSave");
	}
	
	/**
	 * COM_CSR_0016 멀티 이벤트 처리
	 * 결재 유형 저장
	 * @param csrNo
	 * @param aproTpCd
	 * @throws DAOException
	 * @throws Exception
	 */
	public void saveCsrAproTpCd(String csrNo, String aproTpCd) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {

			param.put("csr_no", csrNo);
			param.put("apro_tp_cd", aproTpCd);
				
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CSRApprovalCommonManagementDBDAOsaveCsrAproTpCdUSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}
