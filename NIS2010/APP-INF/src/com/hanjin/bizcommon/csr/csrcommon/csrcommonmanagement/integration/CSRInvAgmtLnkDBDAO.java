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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.vo.CSRComApFileUpldVO;
import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.vo.CSRInvAgmtLnkInVO;
import com.hanjin.bizcommon.csr.csrcommon.csrcommonmanagement.vo.SelComApFileVO;
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

public class CSRInvAgmtLnkDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;
	private String dataSource = "";

	/**
	 * COM_CSR_0023 등록 이벤트 처리<br>
	 * CSR Invoice Agreement Link :COM_CSR_0023 Contract & Files 화면에 대한 등록 이벤트 처리
	 * 
	 * @param List<CSRComApFileUpldVO> listVO
	 * @return int
	 * @throws DAOException
	 */
	public int insComApFile(List<CSRComApFileUpldVO> listVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
        int size = listVO.size();
		int insCnt = 0;

        try {

	        if(size > 0) {
	    		//query parameter
	    		Map<String, Object> param = new HashMap<String, Object>();
	    		//velocity parameter
	    		Map<String, Object> velParam = new HashMap<String, Object>();
	        	Iterator<CSRComApFileUpldVO> list = listVO.iterator();
	        	while(list.hasNext()){
	        		CSRComApFileUpldVO csrComApFileUpldVO = (CSRComApFileUpldVO)list.next();
					Map<String, String> mapVO = csrComApFileUpldVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					insCnt = sqlExe.executeUpdate((ISQLTemplate)new CSRInvAgmtLnkDBDAOInsComApFileCSQL(), param, velParam);
	    			if(insCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert SQL");

	    			// AGMT FILE 추가, 삭제시 AP TABLE기록하기
					sqlExe.executeUpdate((ISQLTemplate)new CSRInvAgmtLnkDBDAOUpdApInvHdrUSQL(), param, velParam);
	        	}
	        }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}

	/**
	 * COM_CSR_0023 삭제 이벤트 처리<br>
	 * CSR Invoice Agreement Link :COM_CSR_0023 Contract & Files 화면에 대한 삭제 이벤트 처리
	 * 
	 * @param List<CSRComApFileUpldVO> listVO
	 * @return int
	 * @throws DAOException
	 */
	public int delComApFile(List<CSRComApFileUpldVO> listVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
        int size = listVO.size();
		int delCnt = 0;

        try {

	        if(size > 0) {
	    		//query parameter
	    		Map<String, Object> param = new HashMap<String, Object>();
	    		//velocity parameter
	    		Map<String, Object> velParam = new HashMap<String, Object>();
	        	Iterator<CSRComApFileUpldVO> list = listVO.iterator();
	        	while(list.hasNext()){
	        		CSRComApFileUpldVO csrComApFileUpldVO = (CSRComApFileUpldVO)list.next();
					Map<String, String> mapVO = csrComApFileUpldVO.getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					delCnt = sqlExe.executeUpdate((ISQLTemplate)new CSRInvAgmtLnkDBDAODelComApFileDSQL(), param,velParam);
	    			if(delCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");

	    			// AGMT FILE 추가, 삭제시 AP TABLE기록하기
					sqlExe.executeUpdate((ISQLTemplate)new CSRInvAgmtLnkDBDAOUpdApInvHdrUSQL(), param, velParam);
	        	}
	        }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return delCnt;
	}
	
	/**
	 * COM_CSR_0023 수정 이벤트 처리<br>
	 * CSR Invoice Agreement Link :COM_CSR_0023 Contract & Files 화면에 대한 수정 이벤트 처리
	 * 
	 * @param List<CSRComApFileUpldVO> listVO
	 * @return int
	 * @throws DAOException
	 */
	public int updComApFile(List<CSRComApFileUpldVO> listVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
        int size = listVO.size();
		int updCnt = 0;

        try {

	        if(size > 0) {
	    		//query parameter
	    		Map<String, Object> param = new HashMap<String, Object>();
	    		//velocity parameter
	    		Map<String, Object> velParam = new HashMap<String, Object>();
	        	Iterator<CSRComApFileUpldVO> list = listVO.iterator();
	        	while(list.hasNext()){
	        		CSRComApFileUpldVO csrComApFileUpldVO = (CSRComApFileUpldVO)list.next();
					Map<String, String> mapVO = csrComApFileUpldVO .getColumnValues();
					param.putAll(mapVO);
					velParam.putAll(mapVO);
					updCnt = sqlExe.executeUpdate((ISQLTemplate)new CSRInvAgmtLnkDBDAOUpdComApFileUSQL(), param,velParam);
	    			if(updCnt == Statement.EXECUTE_FAILED) throw new DAOException("Fail to delete SQL");
	        	}
	        }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return updCnt;
	}

	
	/**
	 * COM_CSR_0023 조회 이벤트 처리<br>
	 * CSR Invoice Agreement Link :COM_CSR_0023 화면에 대한 조회 이벤트 처리
	 * 
	 * @param CSRInvAgmtLnkInVO csrInvAgmtLnkInVO
	 * @return List<SelComApFileVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SelComApFileVO> search02ComApFileUpld(CSRInvAgmtLnkInVO csrInvAgmtLnkInVO) throws DAOException {
		DBRowSet dbRowset = null;  
		List<SelComApFileVO> list = null;
			
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>(); 
		try{ 
			
			Map<String, String> mapVO = csrInvAgmtLnkInVO.getColumnValues();
			mapVO.put("cre_usr_id", csrInvAgmtLnkInVO.getAccount().getUsr_id());

			param.putAll(mapVO);           
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter(this.dataSource).executeQuery((ISQLTemplate)new CSRInvAgmtLnkDBDAOSelComApFileRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SelComApFileVO.class);
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
	 * COM_CSR_0023 조회 이벤트 처리<br>
	 * CSR Invoice Agreement Link :COM_CSR_0023 RQST_APRO_STEP_FLG 조회
	 * 
	 * @param String csrNo
	 * @return String
	 * @throws DAOException
	 */
	public String getRqstAproStepFlg(String csrNo) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnStr = "";

        try {
    		//query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		//velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();

			param.put("csr_no", csrNo);
			velParam.put("csr_no", csrNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CSRInvAgmtLnkDBDAOSelRqstAproStepFlgRSQL(), param, velParam);

			while(dbRowset.next()){
				rtnStr = dbRowset.getString("rqst_apro_step_flg");
            }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return rtnStr;
	}
	
	/**
	 * COM_CSR_0023 조회 이벤트 처리<br>
	 * CSR Invoice Agreement Link :COM_CSR_0023 CSR_FILE_UPLD_TP_CD 별 건수조회
	 * 
	 * @param String csrNo
	 * @return String
	 * @throws DAOException
	 */
	public int getComApFileUpldCnt(CSRInvAgmtLnkInVO csrInvAgmtLnkInVO) throws DAOException {
		DBRowSet dbRowset = null;
		int insCnt = 0;

        try {
    		//query parameter
    		Map<String, Object> param = new HashMap<String, Object>();
    		//velocity parameter
    		Map<String, Object> velParam = new HashMap<String, Object>();

    		param.put("csr_no", csrInvAgmtLnkInVO.getCsrNo());
			velParam.put("csr_no", csrInvAgmtLnkInVO.getCsrNo());
			
			param.put("csr_file_upld_tp_cd", csrInvAgmtLnkInVO.getCsrFileUpldTpCd());
			velParam.put("csr_file_upld_tp_cd", csrInvAgmtLnkInVO.getCsrFileUpldTpCd());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CSRInvAgmtLnkDBDAOgetComApFileUpldCntRSQL(), param, velParam);

			while(dbRowset.next()){
				String resultNo = dbRowset.getString("atch_file_cnt");
				if (resultNo != null) {
					insCnt = Integer.valueOf(resultNo);
				}
            }
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return insCnt;
	}
	
	
}
