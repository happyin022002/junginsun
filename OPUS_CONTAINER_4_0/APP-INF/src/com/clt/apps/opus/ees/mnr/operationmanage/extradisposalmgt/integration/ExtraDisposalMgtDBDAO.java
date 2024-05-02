/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExtraDisposalMgtDBDAO.java
*@FileTitle : Scrapping/Donation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.09.07 김완규 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.extradisposalmgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.mnr.operationmanage.extradisposalmgt.basic.ExtraDisposalMgtBCImpl;
import com.clt.apps.opus.ees.mnr.operationmanage.extradisposalmgt.vo.CustomMnrXtraDispVO;
import com.clt.apps.opus.ees.mnr.operationmanage.extradisposalmgt.vo.ExtraDisposalMgtGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.extradisposalmgt.vo.ExtraDisposalMgtINVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/** 
 * ExtraDisposal관련 디비 처리를 합니다.
 * @author WanGyu Kim
 * @see ExtraDisposalMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class ExtraDisposalMgtDBDAO extends DBDAOSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * [EES_MNR_0093]Scrapping/Donation Creation의 정보를 조회 합니다. <br>
	 *
	 * @param ExtraDisposalMgtINVO extraDisposalMgtINVO
	 * @return List<CustomMnrXtraDispVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrXtraDispVO> searchExtraDisposalByEQData(ExtraDisposalMgtINVO extraDisposalMgtINVO) throws DAOException {
		DBRowSet dbRowset = null;  
		List<CustomMnrXtraDispVO> customMnrXtraDispVOS = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>(); 
		try{ 
			Map<String, String> mapVO = extraDisposalMgtINVO.getColumnValues();
			  	
			param.putAll(mapVO);                      
			velParam.putAll(mapVO);           
			 		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExtraDisposalMgtDBDAOsearchExtraDisposalByEQDataRSQL(), param, velParam);
			customMnrXtraDispVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrXtraDispVO .class);
		}catch(SQLException se){ 
			log.error(se.getMessage(),se);  
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}  
		return customMnrXtraDispVOS;
	 }	
		 
	 /**
	  * [EES_MNR_0093]Scrapping/Donation Creation의 정보를 체크 합니다. <br>
	  *
	  * @param ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO
	  * @return String
	  * @exception DAOException
	  */
	 public String checkExtraDisposalByEQData(ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 String cnt = "";
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 ExtraDisposalMgtINVO extraDisposalMgtINVO = extraDisposalMgtGRPVO.getExtraDisposalMgtINVO();
			 Map<String, String> mapVO = extraDisposalMgtINVO.getColumnValues();
			 
			 param.putAll(mapVO);  
			 velParam.putAll(mapVO);   

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExtraDisposalMgtDBDAOcheckExtraDisposalByEQDataRSQL(), param, velParam);
			 
			 if(dbRowset.next()){
				 cnt = dbRowset.getString(1); 
			 }
			 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return cnt;
	 }
	 
	 /**
	  * [EES_MNR_0093]Scrapping/Donation Creation의 정보를 작업 합니다. <br>
	  *
	  * @return String
	  * @exception DAOException
	  */
	 public String createExtraDisposalSequenceData() throws DAOException {
		 DBRowSet dbRowset = null;
		 String seq = "";
		 
		 try{
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExtraDisposalMgtDBDAOcreateExtraDisposalSequenceDataRSQL(), null, null);
			 
			 if(dbRowset.next()){
				 seq = dbRowset.getString(1); 
			 }
			 
		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return seq;
	 }

	 /**
	  * [EES_MNR_0093]Scrapping/Donation Creation의 정보를 추가 합니다. <br>
	  *
	  * @param List<CustomMnrXtraDispVO> customMnrXtraDispVOS
	  * @exception DAOException
	  */  
	 public void addExtraDisposalByEQData(List<CustomMnrXtraDispVO> customMnrXtraDispVOS) throws DAOException,Exception {
		try {  
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrXtraDispVOS.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ExtraDisposalMgtDBDAOaddExtraDisposalByEQDataCSQL(), customMnrXtraDispVOS,null);
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
	  * [EES_MNR_0093]Scrapping/Donation Creation의 정보를 수정 합니다. <br>
	  *
	  * @param List<CustomMnrXtraDispVO> customMnrXtraDispVOS
	  * @exception DAOException
	  */  
	public void modifyExtraDisposalByEQData(List<CustomMnrXtraDispVO> customMnrXtraDispVOS) throws DAOException,Exception {
		try {  
			SQLExecuter sqlExe = new SQLExecuter("");  
			int updCnt[] = null;  
			if(customMnrXtraDispVOS.size() > 0){        
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ExtraDisposalMgtDBDAOmodifyExtraDisposalByEQDataUSQL(), customMnrXtraDispVOS,null);
				    
				for(int i = 0; i < updCnt.length; i++){  
					if(updCnt[i]== Statement.EXECUTE_FAILED)     
						throw new DAOException("Fail to Update No"+ i + " SQL"); 
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
	 * [EES_MNR_0093]Scrapping/Donation Creation의 정보를 삭제 합니다. <br>
	 *
	 * @param List<CustomMnrXtraDispVO> customMnrXtraDispVOS
	 * @exception DAOException
	 */   
	public void removeExtraDisposalByEQData(List<CustomMnrXtraDispVO> customMnrXtraDispVOS) throws DAOException,Exception {
		try {  
			SQLExecuter sqlExe = new SQLExecuter("");  
			int delCnt[] = null;  
			if(customMnrXtraDispVOS.size() > 0){        
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ExtraDisposalMgtDBDAOremoveExtraDisposalByEQDataDSQL(), customMnrXtraDispVOS,null);
				
				for(int i = 0; i < delCnt.length; i++){  
					if(delCnt[i]== Statement.EXECUTE_FAILED)     
						throw new DAOException("Fail to Update No"+ i + " SQL"); 
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
	 * [EES_MNR_0094]Scrapping/Donation Inquiry의 정보를 조회 합니다. <br>
	 *
	 * @param ExtraDisposalMgtINVO extraDisposalMgtINVO
	 * @param SignOnUserAccount account
	 * @return List<CustomMnrXtraDispVO>
	 * @exception DAOException
	 */	
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrXtraDispVO> searchExtraDisposalListData(ExtraDisposalMgtINVO extraDisposalMgtINVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;  
		List<CustomMnrXtraDispVO> customMnrXtraDispVOS = null;
			
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>(); 
		try{ 
			Map<String, String> mapVO = extraDisposalMgtINVO.getColumnValues();
			  	
			param.putAll(mapVO);                      
			velParam.putAll(mapVO);
			param.put("user_ofc_cd", account.getOfc_cd());
			velParam.put("user_ofc_cd", account.getOfc_cd());
			 		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ExtraDisposalMgtDBDAOsearchExtraDisposalListDataRSQL(), param, velParam);
			customMnrXtraDispVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrXtraDispVO .class);
		}catch(SQLException se){ 
			log.error(se.getMessage(),se);  
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}  
		return customMnrXtraDispVOS; 
	}	

}
