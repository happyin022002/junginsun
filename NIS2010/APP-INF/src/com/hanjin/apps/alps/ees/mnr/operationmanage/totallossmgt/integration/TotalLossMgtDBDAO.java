/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TotalLossMgtDBDAO.java
*@FileTitle : Total Loss No Inquiry_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.09.15 김완규
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.03.06 신혜정 [CHM-201216409] 3rd Party 탭 [CHNG INV No] 버튼 클릭시, invoice no 업데이트  
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.basic.TotalLossMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.CustomMnrTtlLssCltVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.CustomMnrTtlLssRqstDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.CustomMnrTtlLssRqstHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.TotalLossGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.TotalLossINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.TotalLossInfoGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.TotalLossInfoINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.TotalLossLessorReportINVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.totallossmgt.vo.TotalLossLessorReportVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/** 
 * TotalLoss관련 디비 처리를 합니다.
 * @author WanGyu Kim
 * @see TotalLossMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class TotalLossMgtDBDAO extends DBDAOSupport {
	/**
	 * [EES_MNR_0098]Total Loss Collection & Inquiry의 정보를 삭제 합니다. <br>
	 *
	 * @param CustomMnrTtlLssRqstHdrVO customMnrTtlLssRqstHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeTotalLossHDRData(CustomMnrTtlLssRqstHdrVO customMnrTtlLssRqstHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try { 
			Map<String, String> mapVO = customMnrTtlLssRqstHdrVO.getColumnValues();
						
			param.putAll(mapVO);   
			velParam.putAll(mapVO);    
				
			SQLExecuter sqlExe = new SQLExecuter("");  
				
			result = sqlExe.executeUpdate((ISQLTemplate)new TotalLossMgtDBDAOremoveTotalLossHDRDataDSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)      
				throw new DAOException("Fail to Remove removeTotalLossHDRData"); 
		} catch (SQLException se) { 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){ 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * [EES_MNR_0095]Total Loss Request의 정보를 삭제 합니다. <br>
	 *
	 * @param CustomMnrTtlLssRqstHdrVO customMnrTtlLssRqstHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeTotalLossHdrGRPData(CustomMnrTtlLssRqstHdrVO customMnrTtlLssRqstHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try { 
			Map<String, String> mapVO = customMnrTtlLssRqstHdrVO.getColumnValues();
						
			param.putAll(mapVO);   
			velParam.putAll(mapVO);    
				
			SQLExecuter sqlExe = new SQLExecuter("");  
				
			result = sqlExe.executeUpdate((ISQLTemplate)new TotalLossMgtDBDAOremoveTotalLossHdrGRPDataDSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)      
				throw new DAOException("Fail to Remove removeTotalLossHdrGRPData"); 
		} catch (SQLException se) { 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){ 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * [EES_MNR_0098]Total Loss Request의 정보를 삭제 합니다. <br>
	 *
	 * @param CustomMnrTtlLssRqstHdrVO customMnrTtlLssRqstHdrVO
	 * @return int
	 * @exception DAOException
	 */ 
	public int removeTotalLossCLTData(CustomMnrTtlLssRqstHdrVO customMnrTtlLssRqstHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try { 
			Map<String, String> mapVO = customMnrTtlLssRqstHdrVO.getColumnValues();
			
			param.putAll(mapVO);   
			velParam.putAll(mapVO);    
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new TotalLossMgtDBDAOremoveTotalLossCLTDataDSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)      
				throw new DAOException("Fail to Remove removeTotalLossCLTData"); 
		} catch (SQLException se) { 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){ 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * [EES_MNR_0098]Total Loss Collection & Inquiry의 정보를 삭제 합니다. <br>
	 *
	 * @param CustomMnrTtlLssRqstHdrVO customMnrTtlLssRqstHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeTotalLossDTLData(CustomMnrTtlLssRqstHdrVO customMnrTtlLssRqstHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try { 
			Map<String, String> mapVO = customMnrTtlLssRqstHdrVO.getColumnValues();
			
			param.putAll(mapVO);   
			velParam.putAll(mapVO);     
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			      
			result = sqlExe.executeUpdate((ISQLTemplate)new TotalLossMgtDBDAOremoveTotalLossDTLDataDSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)      
				throw new DAOException("Fail to Remove removeTotalLossDTLData"); 
		} catch (SQLException se) { 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){ 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * [EES_MNR_0095]Total Loss Request의 정보를 삭제 합니다. <br>
	 *
	 * @param CustomMnrTtlLssRqstHdrVO customMnrTtlLssRqstHdrVO
	 * @return int
	 * @exception DAOException
	 */
	public int removeTotalLossDtlGRPData(CustomMnrTtlLssRqstHdrVO customMnrTtlLssRqstHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try { 
			Map<String, String> mapVO = customMnrTtlLssRqstHdrVO.getColumnValues();
			
			param.putAll(mapVO);   
			velParam.putAll(mapVO);     
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			      
			result = sqlExe.executeUpdate((ISQLTemplate)new TotalLossMgtDBDAOremoveTotalLossDtlGRPDataDSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)      
				throw new DAOException("Fail to Remove removeTotalLossDtlGRPData"); 
		} catch (SQLException se) { 
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){ 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * [EES_MNR_0195]Total Loss No Inquiry_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param TotalLossInfoGRPVO totalLossInfoGRPVO
	 * @param SignOnUserAccount account
	 * @return List<CustomMnrTtlLssRqstHdrVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrTtlLssRqstHdrVO> searchTotalLossInfoByOFCListData(TotalLossInfoGRPVO totalLossInfoGRPVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;  
		List<CustomMnrTtlLssRqstHdrVO> customMnrTtlLssRqstHdrVOs = null;
			
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>(); 
		
		try{ 
			TotalLossInfoINVO totalLossInfoINVO = totalLossInfoGRPVO.getTotalLossInfoINVO();
			Map<String, String> mapVO = totalLossInfoINVO.getColumnValues();
			  	
			param.putAll(mapVO);                      
			velParam.putAll(mapVO);
			param.put("user_ofc_cd", account.getOfc_cd());
			velParam.put("user_ofc_cd", account.getOfc_cd());
			 		 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TotalLossMgtDBDAOsearchTotalLossInfoByOFCListDataRSQL(), param, velParam);
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
	  * [EES_MNR_0098]Total Loss Collection & Inquiry의 정보를 조회 합니다. <br>
	  *
	  * @param TotalLossINVO totalLossINVO
	  * @return List<CustomMnrTtlLssCltVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrTtlLssCltVO> searchTotalLossCLTData(TotalLossINVO totalLossINVO) throws DAOException {
		 DBRowSet dbRowset = null;  
		 List<CustomMnrTtlLssCltVO> customMnrTtlLssCltVOs = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 
		 Map<String, Object> velParam = new HashMap<String, Object>(); 
		 		
		 try{  
			 Map<String, String> mapVO = totalLossINVO.getColumnValues();
			 	
			 param.putAll(mapVO);                      
			 velParam.putAll(mapVO);          
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TotalLossMgtDBDAOsearchTotalLossCLTDataRSQL(), param, velParam);
			 customMnrTtlLssCltVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrTtlLssCltVO .class);
		 }catch(SQLException se){ 
			 log.error(se.getMessage(),se);  
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
		 return customMnrTtlLssCltVOs;
	 }	
	 
	 /**
	  * [EES_MNR_0098]Total Loss Request의 정보를 조회 합니다. <br>
	  *
	  * @param TotalLossGRPVO totalLossGRPVO
	  * @param SignOnUserAccount account
	  * @return List<CustomMnrTtlLssRqstHdrVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrTtlLssRqstHdrVO> searchTotalLossData(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws DAOException {
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
			 param.put("user_ofc_cd", account.getOfc_cd());
			 velParam.put("user_ofc_cd", account.getOfc_cd());
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TotalLossMgtDBDAOsearchTotalLossDataRSQL(), param, velParam);
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
	  * [EES_MNR_0098]Total Loss Request의 정보를 조회 합니다. <br>
	  *
	  * @param TotalLossGRPVO totalLossGRPVO
	  * @param SignOnUserAccount account
	  * @return List<CustomMnrTtlLssRqstHdrVO> 
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked") 
	 public List<CustomMnrTtlLssRqstHdrVO> searchTotalLossListData(TotalLossGRPVO totalLossGRPVO, SignOnUserAccount account) throws DAOException {
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
			 param.put("user_ofc_cd", account.getOfc_cd());
			 velParam.put("user_ofc_cd", account.getOfc_cd()); 
			 
			 //멀티 조회조건용 	
			 if (totalLossINVO.getInTtlLssNo() != null && totalLossINVO.getInTtlLssNo().trim().length() > 0) {
				 List<String> ttlNos = new ArrayList();
				 String[] arrayTtlNo =  totalLossINVO.getInTtlLssNo().split(",");
				 for(int i = 0; i < arrayTtlNo.length; i ++){      
					 ttlNos.add(arrayTtlNo[i]);  	      
				 } 			
				 param.put("ttlNos",ttlNos);  	  	                    
				 velParam.put("ttlNos",ttlNos);  
			 } 
			 
			 if (totalLossINVO.getInRqstEqNo() != null && totalLossINVO.getInRqstEqNo().trim().length() > 0) {
				 List<String> eqNos = new ArrayList<String>(); 
				 String[] arrayEqNo =  totalLossINVO.getInRqstEqNo().split(",");
				 for(int i = 0; i < arrayEqNo.length; i ++){      
					 eqNos.add(arrayEqNo[i]);	      
				 } 			
				 	
				 param.put("eqNos",eqNos);  	  	                    
				 velParam.put("eqNos",eqNos); 
			}
			 	
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TotalLossMgtDBDAOsearchTotalLossListDataRSQL(), param, velParam);
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
	  * [EES_MNR_0098]Total Loss Request의 정보를 조회 합니다. <br>
	  *
	  * @param TotalLossGRPVO totalLossGRPVO
	  * @return List<CustomMnrTtlLssRqstDtlVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrTtlLssRqstDtlVO> searchTotalLossDetailListData(TotalLossGRPVO totalLossGRPVO) throws DAOException {
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
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TotalLossMgtDBDAOsearchTotalLossDetailListDataRSQL(), param, velParam);
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
	  * [EES_MNR_0098]Total Loss Request의 정보를 조회 합니다. <br>
	  *
	  * @param String preTotalLossNo
	  * @return String
	  * @exception DAOException
	  */
	 public String searchTotalLossNoData(String preTotalLossNo) throws DAOException {
		 DBRowSet dbRowset = null;
		 String totalLossNo = ""; 
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(preTotalLossNo != null){
				 param.put("pre_total_loss_no", preTotalLossNo);
				 velParam.put("pre_total_loss_no", preTotalLossNo); 
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TotalLossMgtDBDAOsearchTotalLossNoDataRSQL(), param, velParam);
			 
			 if(dbRowset.next()){
				 totalLossNo = dbRowset.getString(1); 
			 }
			 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return totalLossNo;
	 }
	 
	 /**
	  * [EES_MNR_0098]Total Loss Request의 정보를 삭제 합니다. <br>
	  *
	  * @param List<CustomMnrTtlLssRqstHdrVO> customMnrTtlLssRqstHdrVOs
	  * @exception DAOException
	  */
	public void removeTotalLossHeaderData(List<CustomMnrTtlLssRqstHdrVO> customMnrTtlLssRqstHdrVOs) throws DAOException,Exception {
		
		try {

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customMnrTtlLssRqstHdrVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TotalLossMgtDBDAOremoveTotalLossHeaderDataDSQL(), customMnrTtlLssRqstHdrVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to removeTotalLossHeaderData No"+ i + " SQL");
				}
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
	 * [EES_MNR_0098]Total Loss Request의 정보를 추가 합니다. <br>
	 *
	 * @param List<CustomMnrTtlLssCltVO> customMnrTtlLssCltVOs
	 * @exception DAOException
	 */ 		
	public void addTotalLossCLTData(List<CustomMnrTtlLssCltVO> customMnrTtlLssCltVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrTtlLssCltVOs.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TotalLossMgtDBDAOaddTotalLossCLTDataCSQL(), customMnrTtlLssCltVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to addTotalLossCLTData No"+ i + " SQL");
				}		     
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
	 * [EES_MNR_0098]Total Loss Request의 정보를 추가 합니다. <br>
	 *
	 * @param List<CustomMnrTtlLssRqstHdrVO> customMnrTtlLssRqstHdrVOs
	 * @exception DAOException
	 */
	public void addTotalLossHeaderData(List<CustomMnrTtlLssRqstHdrVO> customMnrTtlLssRqstHdrVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrTtlLssRqstHdrVOs.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TotalLossMgtDBDAOaddTotalLossHeaderDataCSQL(), customMnrTtlLssRqstHdrVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to addTotalLossHeaderData No"+ i + " SQL");
				}  
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
	 * [EES_MNR_0098]Total Loss Request의 Hearder 정보를 수정 합니다. <br>
	 *
	 * @param List<CustomMnrTtlLssRqstHdrVO> customMnrTtlLssRqstHdrVOs
	 * @exception DAOException
	 */
	public void modifyTotalLossHeaderData(List<CustomMnrTtlLssRqstHdrVO> customMnrTtlLssRqstHdrVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrTtlLssRqstHdrVOs.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TotalLossMgtDBDAOmodifyTotalLossHeaderDataUSQL(), customMnrTtlLssRqstHdrVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to addTotalLossHeaderData No"+ i + " SQL");
				}  
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
	 * [EES_MNR_0098]Total Loss Request의 정보를 수정 합니다. <br>
	 *
	 * @param List<CustomMnrTtlLssRqstDtlVO> customMnrTtlLssRqstDtlVOs
	 * @exception DAOException
	 */
	public void modifyTotalLossDetailData(List<CustomMnrTtlLssRqstDtlVO> customMnrTtlLssRqstDtlVOs) throws DAOException,Exception {
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customMnrTtlLssRqstDtlVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TotalLossMgtDBDAOmodifyTotalLossDetailDataUSQL(), customMnrTtlLssRqstDtlVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modifyTotalLossDetailData No"+ i + " SQL");
				}
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
	 * [EES_MNR_0098]Total Loss Request의 정보를 추가 합니다. <br>
	 *
	 * @param List<CustomMnrTtlLssRqstDtlVO> customMnrTtlLssRqstDtlVOs
	 * @exception DAOException
	 */
	public void addTotalLossDetailData(List<CustomMnrTtlLssRqstDtlVO> customMnrTtlLssRqstDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			if(customMnrTtlLssRqstDtlVOs.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new TotalLossMgtDBDAOaddTotalLossDetailDataCSQL(), customMnrTtlLssRqstDtlVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to addTotalLossDetailData No"+ i + " SQL");
				}  
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
	 * [EES_MNR_0098]Total Loss Request의 정보를 삭제 합니다. <br>
	 *
	 * @param List<CustomMnrTtlLssRqstDtlVO> customMnrTtlLssRqstDtlVOs
	 * @exception DAOException
	 */
	public void removeTotalLossDetailData(List<CustomMnrTtlLssRqstDtlVO> customMnrTtlLssRqstDtlVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customMnrTtlLssRqstDtlVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new TotalLossMgtDBDAOremoveTotalLossDetailDataDSQL(), customMnrTtlLssRqstDtlVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to removeTotalLossDetailData No"+ i + " SQL");
				}
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
	 * [EES_MNR_0105]Total Loss Payment to Lessor Report의 정보를 조회 합니다. <br>
	 *
	 * @param TotalLossLessorReportINVO totalLossLessorReportINVO
	 * @return List<TotalLossLessorReportVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TotalLossLessorReportVO> searchTotalLossLessorReportListData(TotalLossLessorReportINVO totalLossLessorReportINVO) throws DAOException {
		 
		DBRowSet dbRowset = null;
		List<TotalLossLessorReportVO> totalLossLessorReportVOs = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(totalLossLessorReportINVO != null){
				Map<String, String> mapVO = totalLossLessorReportINVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//rep_Multiful_inquiry eq_no	
				List<String> eqNos = new ArrayList<String>();      
				String[] arrEqNo =  totalLossLessorReportINVO.getEqNo().split(",");
				for(int i = 0; i < arrEqNo.length; i ++){         
					eqNos.add(arrEqNo[i]);           
				}     
				velParam.put("eqNos", eqNos);  	
				
				//rep_Multiful_inquiry total_loss_no
				List<String> totalLossNos = new ArrayList<String>();      
				String[] arrTotalLossNo =  totalLossLessorReportINVO.getTotalLossNo().split(",");
				for(int i = 0; i < arrTotalLossNo.length; i ++){         
					totalLossNos.add(arrTotalLossNo[i]);           
				}     
				velParam.put("totalLossNos", totalLossNos);  					
				
			}
			
			// By Buyer
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TotalLossMgtDBDAOSearchTotalLossLessorReportListDataRSQL(), param, velParam);																		  			
			totalLossLessorReportVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, TotalLossLessorReportVO .class);
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return totalLossLessorReportVOs; 
	}			

	 /**
	  * [EES_MNR_0095]Total Loss Request 에서 Total Loss No 를 체크 합니다. <br>
	  *
	  * @param String searchTtlLssNo
	  * @param String rqstOfcCd
	  * @return int
	  * @exception DAOException
	  */
	 public int checkTotalLossNoData(String searchTtlLssNo, String rqstOfcCd) throws DAOException {
//	 public int checkTotalLossNoData(String searchTtlLssNo, String rqstOfcCd, String pageSeparator) throws DAOException {
		 DBRowSet dbRowset = null; 
		 int totalLossNoCnt = 0;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if(searchTtlLssNo != null){
				 param.put("search_ttl_lss_no", searchTtlLssNo);
				 velParam.put("search_ttl_lss_no", searchTtlLssNo); 
			 }
			 if(rqstOfcCd != null){
				 param.put("rqst_ofc_cd", rqstOfcCd);
				 velParam.put("rqst_ofc_cd", rqstOfcCd); 
			 }
//			 if(pageSeparator != null){
//				 param.put("page_separator", pageSeparator);
//				 velParam.put("page_separator", pageSeparator); 
//			 }
			 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TotalLossMgtDBDAOcheckTotalLossNoDataRSQL(), param, velParam);
			 
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
	 * [EES_MNR_0098]Total Loss Collection & Inquiry 의 invoice no를 수정 합니다.<br>
	 *
	 * @param List<CustomMnrTtlLssRqstDtlVO> customMnrTtlLssRqstDtlVOs
	 * @exception DAOException
	 */
	public void modifyTotalLossDetailInvNoData(List<CustomMnrTtlLssRqstDtlVO> customMnrTtlLssRqstDtlVOs) throws DAOException,Exception {
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customMnrTtlLssRqstDtlVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new TotalLossMgtDBDAOmodifyTotalLossDetailInvNoDataUSQL(), customMnrTtlLssRqstDtlVOs, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to modifyTotalLossDetailInvNoData No"+ i + " SQL");
				}
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
	  * [EES_MNR_0095]Total Loss Request 에서 로그인 Office의 지역이 US인지 조회합니다. <br>
	  *
	  * @param String rqstOfcCd
	  * @return int
	  * @exception DAOException
	  */
	 public int searchOfficeAreaUS(String rqstOfcCd) throws DAOException {
		 DBRowSet dbRowset = null; 
		 int totalCnt = 0;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 param.put("rqst_ofc_cd", rqstOfcCd);
			 velParam.put("rqst_ofc_cd", rqstOfcCd); 

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TotalLossMgtDBDAOsearchOfficeAreaUSRSQL(), param, velParam);
			 
			 if(dbRowset.next()){ 
				 totalCnt = Integer.parseInt(dbRowset.getString(1)); 
			 }
			 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return totalCnt;
	 }
	 
	 	/**
		 * [EES_MNR_0098]Total Loss Request Office를 수정합니다. <br>
		 *
		 * @param List<CustomMnrTtlLssRqstDtlVO> customMnrTtlLssRqstDtlVOs
		 * @exception DAOException
		 */
		public void modifyTotalLossRequestOffficeModification(List<CustomMnrTtlLssRqstDtlVO> customMnrTtlLssRqstDtlVOs) throws DAOException,Exception {
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			try{
				if (customMnrTtlLssRqstDtlVOs.get(0) != null) {
					Map<String, String> mapVO= customMnrTtlLssRqstDtlVOs.get(0).getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				new SQLExecuter("").executeUpdate((ISQLTemplate)new TotalLossMgtDBDAOmodifyTotalLossRespbOfcUSQL(), param, velParam);
			} catch(SQLException se) {
				log.error(se.getMessage(), se);
				throw new DAOException(new ErrorHandler(se).getMessage());
			} catch(Exception ex) {
				log.error(ex.getMessage(), ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
		}
		
		/**
		 * [EES_MNR_0098]장비가 현재 활성화(A)인지 비활성화(I)인지 확인합니다. <br>
		 *
		 * @param String eq_kind_cd
		 * @param String eq_no
		 * @return List<String>
		 * @exception DAOException
		 */
		public List<String> searchEqCurrentStatus(String eq_kind_cd, String eq_no) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			DBRowSet dbRowset = null;
			
			List<String> returnVal = new ArrayList<String>();
			
			try { 
							
				param.put("eq_kind_cd", eq_kind_cd);
				param.put("eq_no", eq_no);
				
				velParam.put("eq_kind_cd", eq_kind_cd);
				velParam.put("eq_no", eq_no);
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new TotalLossMgtDBDAOsearchEqCurrentStatusRSQL(), param, velParam);
				 
				if(dbRowset.next()){
					returnVal.add(dbRowset.getString(1));
					returnVal.add(dbRowset.getString(2));
				}
				if("".equals(returnVal.get(0)))      
					throw new DAOException("Fail to check current eq status"); 
			} catch (SQLException se) { 
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage()); 
			}catch(Exception ex){ 
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage());
			}
			return returnVal;
		}
}
