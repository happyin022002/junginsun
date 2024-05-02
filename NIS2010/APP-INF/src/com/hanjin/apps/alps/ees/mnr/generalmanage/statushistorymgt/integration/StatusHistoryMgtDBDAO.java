/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : StatusHistoryMgtDBDAO.java
*@FileTitle : StatusHistory
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.09.22 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.statushistorymgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.mnr.generalmanage.statushistorymgt.basic.StatusHistoryMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.generalmanage.statushistorymgt.vo.CustomMnrStsHisVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.statushistorymgt.vo.StatusHistoryGRPVO;
import com.hanjin.apps.alps.ees.mnr.generalmanage.statushistorymgt.vo.StatusHistoryINVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/** 
 * StatusHistory관련 디비 처리를 합니다.
 * @author WanGyu Kim
 * @see StatusHistoryMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class StatusHistoryMgtDBDAO extends DBDAOSupport {
	
	/**
	 * [EES_MNR_0098]Total Loss Request의 정보를 조회 합니다. <br>
	 *
	 * @param StatusHistoryGRPVO statusHistoryGRPVO
	 * @return List<CustomMnrStsHisVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrStsHisVO> searchStatusHistoryData(StatusHistoryGRPVO statusHistoryGRPVO) throws DAOException {
		DBRowSet dbRowset = null;  
		List<CustomMnrStsHisVO> list = null;
			
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>(); 
		
		try{ 
			StatusHistoryINVO statusHistoryINVO = statusHistoryGRPVO.getStatusHistoryINVO();
			Map<String, String> mapVO = statusHistoryINVO.getColumnValues();
			  	
			param.putAll(mapVO);                      
			velParam.putAll(mapVO);          
			 		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatusHistoryMgtDBDAOsearchStatusHistoryDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrStsHisVO .class);
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
	  * [EES_MNR_0098]Total Loss Request의 정보를 조회 합니다. <br>
	  *
	  * @return String
	  * @exception DAOException
	  */
	 public String searchStatusHistoryRefNoData() throws DAOException {
		 DBRowSet dbRowset = null;
		 String mnrStsRefNo = "";
		 
		 try{
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatusHistoryMgtDBDAOsearchStatusHistoryRefNoDataRSQL(), null, null);
			 
			 if(dbRowset.next()){
				 mnrStsRefNo = dbRowset.getString(1); 
			 }
			 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return mnrStsRefNo;
	 }
	 
	 /**
	  * [EES_MNR_0098]Total Loss Request의 정보를 수정 합니다. <br>
	  *
	  * @param List<CustomMnrStsHisVO> customMnrStsHisVOs
	  * @exception DAOException
	  */
	public void modifyStatusHistoryData(List<CustomMnrStsHisVO> customMnrStsHisVOs) throws DAOException,Exception {
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customMnrStsHisVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new StatusHistoryMgtDBDAOmodifyStatusHistoryDataUSQL(), customMnrStsHisVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * @param List<CustomMnrStsHisVO> customMnrStsHisVOs
	 * @exception DAOException
	 */
	public void addStatusHistoryData(List<CustomMnrStsHisVO> customMnrStsHisVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			
			if(customMnrStsHisVOs.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new StatusHistoryMgtDBDAOaddStatusHistoryDataCSQL(), customMnrStsHisVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * [EES_MNR_0098]Total Loss Collection & Inquiry의 정보를 삭제 합니다. <br>
	 *
	 * @param CustomMnrStsHisVO customMnrStsHisVO
	 * @return int
	 * @exception DAOException
	 */   
	public int removeStatusHistoryALLData(CustomMnrStsHisVO customMnrStsHisVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try { 
			Map<String, String> mapVO = customMnrStsHisVO.getColumnValues();
			
			param.putAll(mapVO);   
			velParam.putAll(mapVO);     
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new StatusHistoryMgtDBDAOremoveStatusHistoryALLDataDSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)      
				throw new DAOException("Fail to Update removeStatusHistoryALLData"); 
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
	 * @param List<CustomMnrStsHisVO> customMnrStsHisVOs
	 * @exception DAOException
	 */
	public void removeStatusHistoryData(List<CustomMnrStsHisVO> customMnrStsHisVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customMnrStsHisVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new StatusHistoryMgtDBDAOremoveStatusHistoryDataDSQL(), customMnrStsHisVOs,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	
}
