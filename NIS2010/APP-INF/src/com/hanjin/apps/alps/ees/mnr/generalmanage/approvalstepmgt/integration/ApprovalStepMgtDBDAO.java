/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ApprovalStepMgtDBDAO.java
*@FileTitle : Approval Step Management
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.17
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2012.12.17 조경완
* 1.0 Creation
* 2014-01-27 Jonghee HAN Recovery R4J Defects 
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
import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.vo.CustomApprovalStepVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.approvalstepmgt.vo.CustomMnrAproStepVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
/** 
 * alps ApprovalStepMgtDBDAO <br>
 * - alps-GeneralManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 조경완
 * @see ApprovalStepMgtBCImpl 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class ApprovalStepMgtDBDAO extends DBDAOSupport {
	/**
	 * [EES_MNR_0262]Approval Step 의 정보를 조회 합니다. <br>
	 *
	 * @param ApprovalStepGRPVO approvalStepGRPVO
	 * @return List<CustomApprovalStepVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CustomApprovalStepVO> searchApprovalStepListData(ApprovalStepGRPVO approvalStepGRPVO) throws DAOException {
		DBRowSet dbRowset = null; 
		List<CustomApprovalStepVO> list = null;  
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
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomApprovalStepVO .class);
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
	 * [EES_MNR_0263]Approval Step 의 office code type를 조회 합니다. <br>
	 *
	 * @param ApprovalStepINVO approvalStepINVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchApprovalOfcTypeData(ApprovalStepINVO approvalStepINVO) throws DAOException {
		DBRowSet dbRowset = null; 
		String ofcTpCd = "";
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter  
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{         
			Map<String, String> mapVO = approvalStepINVO.getColumnValues();
			
			param.putAll(mapVO);  	                     
			velParam.putAll(mapVO);   
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalStepMgtDBDAOsearchApprovalOfcTypeDataRSQL(), param, velParam);
			
			if(dbRowset.next()){
				 ofcTpCd = dbRowset.getString(1); 
			 }
			
		}catch(SQLException se){  
			log.error(se.getMessage(),se); 
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){ 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}    
		return ofcTpCd;  
	}

	/**
	 *  [EES_MNR_0265]Approval Step을 조회 합니다. <br>
	 *
	 * @param ApprovalStepINVO approvalStepINVO
	 * @return List<CustomMnrAproStepVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CustomMnrAproStepVO> searchApprovalStepRankDataList(ApprovalStepINVO approvalStepINVO) throws DAOException{
		// TODO Auto-generated method stub
		DBRowSet dbRowset = null; 
		List<CustomMnrAproStepVO> list = null;  
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter  
		Map<String, Object> velParam = new HashMap<String, Object>();
		
//		ApprovalStepINVO approvalStepINVO  = approvalStepGRPVO.getApprovalStepINVO();
		try{         
			Map<String, String> mapVO = approvalStepINVO.getColumnValues();
			
			param.putAll(mapVO);  	                     
			velParam.putAll(mapVO);   
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalStepMgtDBDAOsearchApprovalStepRankListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrAproStepVO .class);
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
	 * Office Code 값을 체크한다<br>
	 * 
	 * @param ApprovalStepINVO approvalStepINVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkOfficeData(ApprovalStepINVO approvalStepINVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (approvalStepINVO != null) {
				Map<String, String> mapVO = approvalStepINVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ApprovalStepMgtDBDAOcheckOfficeDataRSQL(), param, velParam);
			if (dbRowset.next())
				result = dbRowset.getInt(1) > 0 ? true : false;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * Office Code 값의 중복여부를 체크한다<br>
	 * 
	 * @param ApprovalStepINVO approvalStepINVO
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkAproOfcData(ApprovalStepINVO approvalStepINVO) throws DAOException {
		DBRowSet dbRowset = null;
		boolean result = false;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (approvalStepINVO != null) {
				Map<String, String> mapVO = approvalStepINVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ApprovalStepMgtDBDAOcheckDupAproOfcDataRSQL(), param, velParam);
			if (dbRowset.next())
				result = dbRowset.getInt(1) > 0 ? true : false;
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * [EES_MNR_0265]User Name 을 조회합니다 <br>
	 *
	 * @param ApprovalStepINVO approvalStepINVO
	 * @return List<CustomApprovalStepVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CustomApprovalStepVO> searchUserNameData(ApprovalStepINVO approvalStepINVO) throws DAOException {
		DBRowSet dbRowset = null; 
		List<CustomApprovalStepVO> list = null;  
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter  
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{         
			Map<String, String> mapVO = approvalStepINVO.getColumnValues();
			
			param.putAll(mapVO);  	                     
			velParam.putAll(mapVO);   
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ApprovalStepMgtDBDAOsearchUserNameDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomApprovalStepVO .class);
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
	 * [EES_MNR_0265]Approval Step 정보를 추가 합니다. <br>
	 * 
	 * @param List<CustomApprovalStepVO> customApprovalStepVOS
	 * @exception DAOException
	 */
	public void addApprovalStepData(List<CustomApprovalStepVO> customApprovalStepVOS) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (customApprovalStepVOS.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ApprovalStepMgtDBDAOaddAproStepDataCSQL(), customApprovalStepVOS, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to addApprovalStepData No" + i+ " SQL");
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
	 * [EES_MNR_0265]Approval Step 정보를 삭제합니다<br>
	 * 
	 * @param CustomApprovalStepVO customApprovalStepVO
	 * @exception DAOException
	 */
	public void removeAproStepData(CustomApprovalStepVO customApprovalStepVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(customApprovalStepVO != null){
				//query parameter
		        Map<String, String> param = customApprovalStepVO.getColumnValues();
		        //삭제 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ApprovalStepMgtDBDAOremoveAproStepDataDSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_MNR_0265]Approval Step History 정보를 수정합니다<br>
	 * 
	 * @param CustomApprovalStepHistoryVO customApprovalStepHistoryVO
	 * @exception DAOException
	 */
	public void modifyAproStepHisData(CustomApprovalStepHistoryVO customApprovalStepHistoryVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(customApprovalStepHistoryVO != null){
				//query parameter
		        Map<String, String> param = customApprovalStepHistoryVO.getColumnValues();
		        //삭제 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ApprovalStepMgtDBDAOmodifyAproStepHisDataUSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 *  [EES_MNR_0265]Approval Step History 정보를 삭제합니다<br>
	 *
	 * @param CustomApprovalStepHistoryVO customApprovalStepHistoryVO
	 * @exception DAOException
	 */
	public void removeAproStepHisData(CustomApprovalStepHistoryVO customApprovalStepHistoryVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(customApprovalStepHistoryVO != null){
				//query parameter
		        Map<String, String> param = customApprovalStepHistoryVO.getColumnValues();
		        //삭제 
		        int result = sqlExe.executeUpdate((ISQLTemplate) new ApprovalStepMgtDBDAOremoveAproStepHisDataDSQL() , param, null);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete SQL");
				
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}
