/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : WriteOffMgtDBDAO.java
*@FileTitle : WriteOffMgtDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.26
*@LastModifier : 조경완
*@LastVersion : 1.0
* 2012.12.26 조경완
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.basic.TotalLossMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.CustomMnrTtlLssRqstDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.CustomMnrTtlLssRqstHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.CustomMnrWrtfRqstHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.TotalLossGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.TotalLossINVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/** 
 * Write Off 관련 디비 처리를 합니다.
 * @author Cho Kyoung Wan
 * @see TotalLossMgtBCImpl 참조
 * @since J2EE 1.4
 */

public class WriteOffMgtDBDAO extends DBDAOSupport{
	/**
	  * [EES_MNR_0262] Write Off Header 의 정보를 조회 합니다. <br>
	  *
	  * @param TotalLossGRPVO totalLossGRPVO
	  * @return List<CustomMnrTtlLssRqstHdrVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrTtlLssRqstHdrVO> searchTotalLossWriteOffHdrListData(TotalLossGRPVO totalLossGRPVO) throws DAOException {
		 DBRowSet dbRowset = null;  
		 List<CustomMnrTtlLssRqstHdrVO> customMnrTtlLssRqstHdrVOs = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 
		 try{ 
			 TotalLossINVO totalLossINVO = totalLossGRPVO.getTotalLossINVO();
			 Map<String, String> mapVO = totalLossINVO.getColumnValues();
			 
			 param.putAll(mapVO);                      
			 velParam.putAll(mapVO);          
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WriteOffMgtDBDAOsearchWriteOffRequestHeaderDataRSQL(), param, velParam);
			 customMnrTtlLssRqstHdrVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrTtlLssRqstHdrVO .class);
		 }catch(SQLException se){ 
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customMnrTtlLssRqstHdrVOs; 
	 }
	 
	 /**
	  * [EES_MNR_0262]Write Off Detail 정보를 조회 합니다. <br>
	  *
	  * @param TotalLossGRPVO totalLossGRPVO
	  * @return List<CustomMnrTtlLssRqstDtlVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrTtlLssRqstDtlVO> searchTotalWriteOffDtlListData(TotalLossGRPVO totalLossGRPVO) throws DAOException {
		 DBRowSet dbRowset = null;  
		 List<CustomMnrTtlLssRqstDtlVO> customMnrTtlLssRqstDtlVOs = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 
		 try{
			 TotalLossINVO totalLossINVO = totalLossGRPVO.getTotalLossINVO();
			 Map<String, String> mapVO = totalLossINVO.getColumnValues();
			 
			 param.putAll(mapVO);                      
			 velParam.putAll(mapVO);          
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WriteOffMgtDBDAOsearchWriteOffRequestDetailDataRSQL(), param, velParam);
			 customMnrTtlLssRqstDtlVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrTtlLssRqstDtlVO .class);
		 }catch(SQLException se){ 
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customMnrTtlLssRqstDtlVOs; 
	 }
	 
	 /**
	  * [EES_MNR_0262]Write Off Remark 정보를 조회 합니다. <br>
	  *
	  * @param TotalLossGRPVO totalLossGRPVO
	  * @return List<CustomMnrWrtfRqstHdrVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrWrtfRqstHdrVO> searchTotalWriteOffRmkListData(TotalLossGRPVO totalLossGRPVO) throws DAOException {
		 DBRowSet dbRowset = null;  
		 List<CustomMnrWrtfRqstHdrVO> customMnrWrtfRqstHdrVOs = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 
		 try{
			 TotalLossINVO totalLossINVO = totalLossGRPVO.getTotalLossINVO();
			 Map<String, String> mapVO = totalLossINVO.getColumnValues();
			 
			 param.putAll(mapVO);                      
			 velParam.putAll(mapVO);          
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WriteOffMgtDBDAOsearchWriteOffRemarkListDataRSQL(), param, velParam);
			 customMnrWrtfRqstHdrVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrWrtfRqstHdrVO .class);
		 }catch(SQLException se){ 
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customMnrWrtfRqstHdrVOs; 
	 }
	 
	 /**
	  * [EES_MNR_0262]Write Off No 의 정보를 조회 합니다. <br>
	  *
	  * @param String preWrtfNo
	  * @return String
	  * @exception DAOException
	  */
	 public String searchWriteOffNoData(String preWrtfNo) throws DAOException {
		 DBRowSet dbRowset = null;
		 String wrtfNo = ""; 
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(preWrtfNo != null){
				 param.put("pre_wrtf_no", preWrtfNo);
				 velParam.put("pre_wrtf_no", preWrtfNo); 
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WriteOffMgtDBDAOsearchWriteOffNoListDataRSQL(), param, velParam);
			 
			 if(dbRowset.next()){
				 wrtfNo = dbRowset.getString(1); 
			 }
			 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return wrtfNo;
	 }
	 
	 /**
	 * [EES_MNR_0262]Write Off Request의 정보를 추가 합니다. <br>
	 * 
	 * @param List<CustomMnrWrtfRqstHdrVO> customMnrWrtfRqstHdrVOs
	 * @exception DAOException
	 */
	public void addWriteOffHeaderData(List<CustomMnrWrtfRqstHdrVO> customMnrWrtfRqstHdrVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (customMnrWrtfRqstHdrVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new WriteOffMgtDBDAOaddWriteOffRequestHeaderDataCSQL(), customMnrWrtfRqstHdrVOs, null);
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
	 * @param List<CustomMnrTtlLssRqstDtlVO> customMnrTtlLssRqstDtlVOs
	 * @exception DAOException
	 */
	public void modifyWriteOffDetailData(List<CustomMnrTtlLssRqstDtlVO> customMnrTtlLssRqstDtlVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (customMnrTtlLssRqstDtlVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new WriteOffMgtDBDAOmodifyWriteOffRequestDetailDataUSQL(), customMnrTtlLssRqstDtlVOs, null);
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
	 * [EES_MNR_0262]Write Off Header 정보를 수정 합니다.(Save) <br>
	 * 
	 * @param List<CustomMnrWrtfRqstHdrVO> customMnrWrtfRqstHdrVOs
	 * @exception DAOException
	 */
	public void modifyWriteOffHeaderData(List<CustomMnrWrtfRqstHdrVO> customMnrWrtfRqstHdrVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (customMnrWrtfRqstHdrVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new WriteOffMgtDBDAOmodifyWriteOffRequestHeaderDataUSQL(), customMnrWrtfRqstHdrVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modifyWriteOffHeaderData No" + i+ " SQL");
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
	 * [EES_MNR_0262]Write Off Header 정보를 수정 합니다.(Request) <br>
	 * 
	 * @param List<CustomMnrWrtfRqstHdrVO> customMnrWrtfRqstHdrVOs
	 * @exception DAOException
	 */
	public void modifyWriteOffHdrData(List<CustomMnrWrtfRqstHdrVO> customMnrWrtfRqstHdrVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (customMnrWrtfRqstHdrVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new WriteOffMgtDBDAOmodifyWriteOffRequestHdrDataUSQL(), customMnrWrtfRqstHdrVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modifyWriteOffHeaderData No" + i+ " SQL");
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
	 * [EES_MNR_0262]Write Off Detail 정보를 삭제 합니다. <br>
	 * 
	 * @param List<CustomMnrTtlLssRqstDtlVO> customMnrTtlLssRqstDtlVOs
	 * @exception DAOException
	 */
	public void removeWriteOffDetailData(List<CustomMnrTtlLssRqstDtlVO> customMnrTtlLssRqstDtlVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (customMnrTtlLssRqstDtlVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new WriteOffMgtDBDAOremoveWriteOffDetailDataUSQL(), customMnrTtlLssRqstDtlVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to removeWriteOffDetailData No" + i+ " SQL");
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
	 * [EES_MNR_0262]Write Off Header 정보를 삭제 합니다.(Request) <br>
	 * 
	 * @param List<CustomMnrWrtfRqstHdrVO> customMnrWrtfRqstHdrVOs
	 * @exception DAOException
	 */
	public void removeWriteOffHeaderData(List<CustomMnrWrtfRqstHdrVO> customMnrWrtfRqstHdrVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (customMnrWrtfRqstHdrVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new WriteOffMgtDBDAOremoveWriteOffRequestHeaderDataUSQL(), customMnrWrtfRqstHdrVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to removeWriteOffHeaderData No" + i+ " SQL");
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
	  * [EES_MNR_0262]Write Off No 의 최신 정보를 조회 합니다. <br>
	  *
	  * @param TotalLossINVO totalLossINVO
	  * @return String
	  * @exception DAOException
	  */
	 public String searchMaxWriteOffNoData(TotalLossINVO totalLossINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 String wrtfNo = ""; 
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(totalLossINVO != null){
				 param.put("ttl_lss_no", totalLossINVO.getSearchTtlLssNo());
				 velParam.put("ttl_lss_no", totalLossINVO.getSearchTtlLssNo());
				 
				 param.put("in_rqst_eq_no", totalLossINVO.getInRqstEqNo());
				 velParam.put("in_rqst_eq_no", totalLossINVO.getInRqstEqNo());
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WriteOffMgtDBDAOsearchMaxWriteOffNoDataRSQL(), param, velParam);
			 
			 if(dbRowset.next()){
				 wrtfNo = dbRowset.getString(1); 
			 }
			 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return wrtfNo;
	 }
	 
	 /**
	  * [EES_MNR_0262]Total Loss No 에서 Write Off 대상을 체크 합니다. <br>
	  *
	  * @param String searchTtlLssNo
	  * @return int
	  * @exception DAOException
	  */
	 public int checkTotalLossWriteOFfData(String searchTtlLssNo) throws DAOException {
		 DBRowSet dbRowset = null; 
		 int totalLossNoCnt = 0;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(searchTtlLssNo != null){
				 param.put("ttl_lss_no", searchTtlLssNo);
				 velParam.put("ttl_lss_no", searchTtlLssNo); 
			 }
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WriteOffMgtDBDAOsearchTtlLssWrtfNoDataRSQL(), param, velParam);
			 
			 if(dbRowset.next()){ 
				 totalLossNoCnt = Integer.parseInt(dbRowset.getString(1)); 
			 }
			 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return totalLossNoCnt;
	 }
	 
	 /**
	  * [EES_MNR_0263] Write Off Approval 의 정보를 조회 합니다. <br>
	  *
	  * @param TotalLossGRPVO totalLossGRPVO
	  * @param SignOnUserAccount account
	  * @return List<CustomMnrTtlLssRqstHdrVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrTtlLssRqstHdrVO> searchWriteOffApprovalListData(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws DAOException {
		 DBRowSet dbRowset = null;  
		 List<CustomMnrTtlLssRqstHdrVO> customMnrTtlLssRqstHdrVOs = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 
		 try{ 
			 TotalLossINVO totalLossINVO = totalLossGRPVO.getTotalLossINVO();
			 Map<String, String> mapVO = totalLossINVO.getColumnValues();
			 
			 param.put("user_ofc_cd", account.getOfc_cd());
			 velParam.put("user_ofc_cd", account.getOfc_cd());
			 
			 param.putAll(mapVO);                      
			 velParam.putAll(mapVO);          
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WriteOffMgtDBDAOsearchWriteOffApprovalDataRSQL(), param, velParam);
			 customMnrTtlLssRqstHdrVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrTtlLssRqstHdrVO .class);
		 }catch(SQLException se){ 
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customMnrTtlLssRqstHdrVOs; 
	 }
	 
	 /**
	  * [EES_MNR_0263]Write Off Approval Detail 정보를 조회 합니다. <br>
	  *
	  * @param TotalLossGRPVO totalLossGRPVO
	  * @return List<CustomMnrTtlLssRqstDtlVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrTtlLssRqstDtlVO> searchWriteOffApprovalDetailListData(TotalLossGRPVO totalLossGRPVO) throws DAOException {
		 DBRowSet dbRowset = null;  
		 List<CustomMnrTtlLssRqstDtlVO> customMnrTtlLssRqstDtlVOs = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 
		 try{
			 TotalLossINVO totalLossINVO = totalLossGRPVO.getTotalLossINVO();
			 Map<String, String> mapVO = totalLossINVO.getColumnValues();
			 
			 param.putAll(mapVO);                      
			 velParam.putAll(mapVO);          
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WriteOffMgtDBDAOsearchWriteOffApprovalDetailDataRSQL(), param, velParam);
			 customMnrTtlLssRqstDtlVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrTtlLssRqstDtlVO .class);
		 }catch(SQLException se){ 
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customMnrTtlLssRqstDtlVOs; 
	 }
	 
	 /**
	  * [EES_MNR_0263]Write Off Approval 정보를 수정 합니다.(Approval/Reject) <br>
	  * 
	  * @param List<CustomMnrWrtfRqstHdrVO> customMnrWrtfRqstHdrVOs
	  * @exception DAOException
	  */
	 public void modifyWriteOffApprovalData(List<CustomMnrWrtfRqstHdrVO> customMnrWrtfRqstHdrVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (customMnrWrtfRqstHdrVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new WriteOffMgtDBDAOmodifyWriteOffApprovalDataUSQL(), customMnrWrtfRqstHdrVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modifyWriteOffApprovalData" + i+ " SQL");
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
	  * [EES_MNR_0263]Write Off Approval 정보를 수정 합니다.(Confirm) <br>
	  * 
	  * @param List<CustomMnrWrtfRqstHdrVO> customMnrWrtfRqstHdrVOs
	  * @exception DAOException
	  */
	 public void modifyWriteOffConfirmData(List<CustomMnrWrtfRqstHdrVO> customMnrWrtfRqstHdrVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (customMnrWrtfRqstHdrVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new WriteOffMgtDBDAOmodifyWriteOffConfirmDataUSQL(), customMnrWrtfRqstHdrVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modifyWriteOffConfirmData" + i+ " SQL");
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
	  * [EES_MNR_0264] Write Off Approval 의 정보를 조회 합니다. <br>
	  *
	  * @param TotalLossGRPVO totalLossGRPVO
	  * @param SignOnUserAccount account
	  * @return List<CustomMnrTtlLssRqstHdrVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrTtlLssRqstHdrVO> searchWriteOffApprovalInquiryData(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws DAOException {
		 DBRowSet dbRowset = null;  
		 List<CustomMnrTtlLssRqstHdrVO> customMnrTtlLssRqstHdrVOs = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 
		 try{ 
			 TotalLossINVO totalLossINVO = totalLossGRPVO.getTotalLossINVO();
			 Map<String, String> mapVO = totalLossINVO.getColumnValues();
			 
			 param.put("user_ofc_cd", account.getOfc_cd());
			 velParam.put("user_ofc_cd", account.getOfc_cd());
			 
			 param.putAll(mapVO);                      
			 velParam.putAll(mapVO);          
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new WriteOffMgtDBDAOsearchWriteOffApprovalInquiryDataRSQL(), param, velParam);
			 customMnrTtlLssRqstHdrVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrTtlLssRqstHdrVO .class);
		 }catch(SQLException se){ 
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customMnrTtlLssRqstHdrVOs; 
	 } 
}
