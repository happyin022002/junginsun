/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ApprovalSteHistorypMgtDBDAO.java
*@FileTitle : Approval Step History Management
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.17
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2012.12.17 조경완
* 1.0 Creation
* 2014-02-26 Jonghee HAN Live malfunction fixed
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.basic.ApprovalStepMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.vo.ApprovalStepGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.vo.ApprovalStepINVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.vo.CustomApprovalStepHistoryVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
/** 
 * alps ApprovalStepHistoryMgtDBDAO <br>
 * - alps-GeneralManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 조경완
 * @see ApprovalStepMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class ApprovalStepHistoryMgtDBDAO extends DBDAOSupport{
	/**
	 * [EES_MNR_0262]Approval Step History의 정보를 조회 합니다. <br>
	 *
	 * @param ApprovalStepGRPVO approvalStepGRPVO
	 * @return List<CustomApprovalStepHistoryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomApprovalStepHistoryVO> searchApprovalStepHistoryListData(ApprovalStepGRPVO approvalStepGRPVO) throws DAOException {
		DBRowSet dbRowset = null; 
		List<CustomApprovalStepHistoryVO> list = null;  
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter  
		Map<String, Object> velParam = new HashMap<String, Object>();
		ApprovalStepINVO approvalStepHistoryINVO  = approvalStepGRPVO.getApprovalStepINVO();
		try{         
			Map<String, String> mapVO = approvalStepHistoryINVO.getColumnValues();
			
			param.putAll(mapVO);  	                     
			velParam.putAll(mapVO);   
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalStepHistoryMgtDBDAOsearchApprovalStepHistoryListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomApprovalStepHistoryVO .class);
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
	 * [EES_MNR_0262]Approval Step History의 정보를 추가 합니다. <br>
	 * 
	 * @param List<CustomApprovalStepHistoryVO> customApprovalStepHistoryVOs
	 * @exception DAOException
	 */
	public void addApprovalStepHistoryData(List<CustomApprovalStepHistoryVO> customApprovalStepHistoryVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (customApprovalStepHistoryVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ApprovalStepHistoryMgtDBDAOaddApprovalStepHistoryListDataCSQL(), customApprovalStepHistoryVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to addWriteOffHeaderData No" + i+ " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [EES_MNR_0262]Write Off Detail 정보를 수정 합니다. <br>
	 * 
	 * @param List<CustomApprovalStepHistoryVO> customApprovalStepHistoryVOs
	 * @exception DAOException
	 */
	public void modifyApprovalStepHistoryData(List<CustomApprovalStepHistoryVO> customApprovalStepHistoryVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (customApprovalStepHistoryVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ApprovalStepHistoryMgtDBDAOmodifyApprovalStepHistoryListDataUSQL(), customApprovalStepHistoryVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modifyWriteOffDetailData No" + i+ " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_MNR_0262]Approval Step History의 정보를 체크 합니다. <br>
	 *
	 * @param ApprovalStepGRPVO approvalStepGRPVO
	 * @return List<CustomApprovalStepHistoryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomApprovalStepHistoryVO> searchApprovalStepHistoryChkData(ApprovalStepGRPVO approvalStepGRPVO) throws DAOException {
		DBRowSet dbRowset = null; 
		List<CustomApprovalStepHistoryVO> list = null;  
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter  
		Map<String, Object> velParam = new HashMap<String, Object>();
		ApprovalStepINVO approvalStepHistoryINVO  = approvalStepGRPVO.getApprovalStepINVO();
		try{         
			Map<String, String> mapVO = approvalStepHistoryINVO.getColumnValues();
			
			param.putAll(mapVO);  	                     
			velParam.putAll(mapVO);   
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalStepHistoryMgtDBDAOsearchApprovalStepHistoryChkDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomApprovalStepHistoryVO .class);
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
	 * [EES_MNR_0262]Approval Step 의 정보를 조회 합니다. <br>
	 *
	 * @param ApprovalStepGRPVO approvalStepGRPVO
	 * @return List<CustomApprovalStepHistoryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomApprovalStepHistoryVO> searchApprovalStepListData(ApprovalStepGRPVO approvalStepGRPVO) throws DAOException {
		DBRowSet dbRowset = null; 
		List<CustomApprovalStepHistoryVO> list = null;  
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter  
		Map<String, Object> velParam = new HashMap<String, Object>();
		ApprovalStepINVO approvalStepINVO  = approvalStepGRPVO.getApprovalStepINVO();
		try{         
			Map<String, String> mapVO = approvalStepINVO.getColumnValues();
			
			param.putAll(mapVO);  	                     
			velParam.putAll(mapVO);   
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalStepMgtDBDAOsearchApprovalStepListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomApprovalStepHistoryVO .class);
		}catch(SQLException se){  
			log.error(se.getMessage(),se); 
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){ 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}    
		return list;  
	}
}
