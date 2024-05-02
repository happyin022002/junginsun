/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RateMgtDBDAO.java
*@FileTitle : M&R Agreement
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.05.12 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.basic.RateMgtBCImpl;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.AgreementComboListINVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.AgreementINVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.AgreementInfoListINVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.CustomAgreementInfoListDataVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.CustomAgreementMenuDataVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.CustomAplyOfcPartnerVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.CustomMnrAgmtAplyOfcVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.CustomMnrAgmtHdrVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.CustomMnrAgmtRtVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * COM RateMgtDBDAO <br>
 * - COM-MNRCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author park myoung sin
 * @see RateMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class RateMgtDBDAO extends DBDAOSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * [EES_MNR_0218]M&R Agreement의 정보를 조회 합니다. <br>
	 *
	 * @return List<CustomAgreementMenuDataVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomAgreementMenuDataVO> searchAgreementMenuData() throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomAgreementMenuDataVO> customAgreementMenuDataVOS = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{ 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RateMgtDBDAOsearchAgreementMenuDataRSQL(), param, velParam);
			customAgreementMenuDataVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomAgreementMenuDataVO .class);
		}catch(SQLException se){  
			log.error(se.getMessage(),se);   
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);  	
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}       
		return customAgreementMenuDataVOS;
	} 
	
	/**
	 * [EES_MNR_0015]M&R Agreement의 정보를 삭제 합니다. <br>
	 *
	 * @param AgreementINVO agreementINVO
	 * @exception DAOException
	 */
	 public void removeAGMTHDRGRPData(AgreementINVO agreementINVO) throws DAOException { 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try {
			 Map<String, String> mapVO = agreementINVO.getColumnValues();
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);
			 
			 SQLExecuter sqlExe = new SQLExecuter("");
			 int result = sqlExe.executeUpdate((ISQLTemplate)new RateMgtDBDAOremoveAGMTHDRGRPDataDSQL(), param, velParam);
			 if(result == Statement.EXECUTE_FAILED) 
				 throw new DAOException("Fail to RateMgtDBDAOremoveAGMTHDRGRPDataDSQL");     
		 } catch (SQLException se) {
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){ 
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
	 }
	 
	 /**
	  * [EES_MNR_0015]M&R Agreement의 정보를 삭제 합니다. <br>
	  *
	  * @param AgreementINVO agreementINVO
	  * @exception DAOException
	  */  
	 public void removeAGMTRateGRPData(AgreementINVO agreementINVO) throws DAOException { 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try {
			 Map<String, String> mapVO = agreementINVO.getColumnValues();
			 
			 param.putAll(mapVO);
			 velParam.putAll(mapVO); 
			 
			 SQLExecuter sqlExe = new SQLExecuter("");
			 int result = sqlExe.executeUpdate((ISQLTemplate)new RateMgtDBDAOremoveAGMTRateGRPDataDSQL(), param, velParam);
			 if(result == Statement.EXECUTE_FAILED)   
				 throw new DAOException("Fail to RateMgtDBDAOremoveAGMTRateGRPDataDSQL");
		 } catch (SQLException se) {   
			 log.error(se.getMessage(),se); 
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){    
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
	 }
	 
	 /**
	  * [EES_MNR_0015]M&R Agreement의 정보를 삭제 합니다. <br>
	  *
	  * @param AgreementINVO agreementINVO
	  * @exception DAOException
	  */
	 public void removeAGMTCTLOFCGRPData(AgreementINVO agreementINVO) throws DAOException { 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try {
			 Map<String, String> mapVO = agreementINVO.getColumnValues();
			  
			 param.putAll(mapVO);
			 velParam.putAll(mapVO); 
			  
			 SQLExecuter sqlExe = new SQLExecuter("");
			 int result = sqlExe.executeUpdate((ISQLTemplate)new RateMgtDBDAOremoveAGMTCTLOFCGRPDataDSQL(), param, velParam);
			 if(result == Statement.EXECUTE_FAILED)   
				 throw new DAOException("Fail to RateMgtDBDAOremoveAGMTCTLOFCGRPDataDSQL");
		 } catch (SQLException se) {   
			 log.error(se.getMessage(),se); 
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){    
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
	 }
	 /**
	  * [EES_MNR_0015]M&R Agreement의 정보를 삭제 합니다. <br>
	  *
	  * @param AgreementINVO agreementINVO
	  * @exception DAOException
	  */
	 public void removeAGMTCostDTLGRPData(AgreementINVO agreementINVO) throws DAOException { 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try { 
			 Map<String, String> mapVO = agreementINVO.getColumnValues();
			  
			 param.putAll(mapVO);
			 velParam.putAll(mapVO); 
			 
			 SQLExecuter sqlExe = new SQLExecuter("");
			 int result = sqlExe.executeUpdate((ISQLTemplate)new RateMgtDBDAOremoveAGMTCostDTLGRPDataDSQL(), param, velParam);
			 if(result == Statement.EXECUTE_FAILED)   
				 throw new DAOException("Fail to RateMgtDBDAOremoveAGMTCostDTLGRPDataDSQL");
		 } catch (SQLException se) {   
			 log.error(se.getMessage(),se); 
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){    
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
	 }  	
	 
	 /**
	  * [EES_MNR_0015]M&R Agreement의 정보를 수정 합니다. <br>
	  *
	  * @param AgreementINVO agreementINVO
	  * @param SignOnUserAccount account
	  * @exception DAOException
	  */
	 public void modifyAGMTLastVersionUnFlagData(AgreementINVO agreementINVO,SignOnUserAccount account) throws DAOException { 
		 agreementINVO.setUpdUsrId(account.getUsr_id());     
		 //query parameter 
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 try { 
			 Map<String, String> mapVO = agreementINVO.getColumnValues();
			 
			 param.putAll(mapVO); 
			 velParam.putAll(mapVO);  
			 
			 SQLExecuter sqlExe = new SQLExecuter("");  
			 int result = sqlExe.executeUpdate((ISQLTemplate)new RateMgtDBDAOmodifyAGMTLastVersionUnFlagDataRSQL(), param, velParam);
			 if(result == Statement.EXECUTE_FAILED)     
				 throw new DAOException("Fail to RateMgtDBDAOmodifyAGMTLastVersionUnFlagDataRSQL");
		 } catch (SQLException se) {   
			 log.error(se.getMessage(),se); 
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){    
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }  
	 }
	 
	 /**
	  * [EES_MNR_0015]M&R Agreement의 정보를 수정 합니다. <br>
	  *
	  * @param AgreementINVO agreementINVO
	  * @param SignOnUserAccount account
	  * @exception DAOException
	  */
	 public void modifyAGMTLastVersionFlagData(AgreementINVO agreementINVO,SignOnUserAccount account) throws DAOException { 
		agreementINVO.setUpdUsrId(account.getUsr_id());     
		 //query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = agreementINVO.getColumnValues();
			
			param.putAll(mapVO);   
			velParam.putAll(mapVO);      
			  
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new RateMgtDBDAOmodifyAGMTLastVersionFlagDataRSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) 
					throw new DAOException("Fail to RateMgtDBDAOmodifyAGMTLastVersionFlagDataRSQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){ 
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	 }
	 
	 /**
	  * [EES_MNR_0218]M&R Agreement의 정보를 조회 합니다. <br>
	  *
	  * @param AgreementINVO agreementINVO
	  * @return List<CustomAplyOfcPartnerVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomAplyOfcPartnerVO> searchAplyOfcPartnerData(AgreementINVO agreementINVO) throws DAOException {
		 DBRowSet dbRowset = null;  
		 List<CustomAplyOfcPartnerVO> customAplyOfcPartnerVOS = null;
		 //query parameter 
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 Map<String, String> mapVO = agreementINVO.getColumnValues();
		 	
		 param.putAll(mapVO);                      
		 velParam.putAll(mapVO);  
		 		
		 try{  	 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RateMgtDBDAOsearchAplyOfcPartnerDataRSQL(), param, velParam);
			 customAplyOfcPartnerVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomAplyOfcPartnerVO .class);
		 }catch(SQLException se){   
			 log.error(se.getMessage(),se);    
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);  	
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }       
		 return customAplyOfcPartnerVOS;
	 } 
	 
	 /**
	  * [EES_MNR_0218]M&R Agreement의 정보를 조회 합니다. <br>
	  *
	  * @param AgreementINVO agreementINVO
	  * @return CustomMnrAgmtHdrVO
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public CustomMnrAgmtHdrVO searchAGMTHDRData(AgreementINVO agreementINVO) throws DAOException {
		 DBRowSet dbRowset = null; 
		 List<CustomMnrAgmtHdrVO> customMnrAgmtHdrVOS = null;
		 CustomMnrAgmtHdrVO customMnrAgmtHdrVO = null;
		 //query parameter 
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter 
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 Map<String, String> mapVO = agreementINVO.getColumnValues();
	       
		 param.putAll(mapVO);                     
		 velParam.putAll(mapVO);     
		              
		 try{ 
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RateMgtDBDAOsearchAGMTHDRDataRSQL(), param, velParam);
			 customMnrAgmtHdrVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrAgmtHdrVO .class);
			    
			 if(customMnrAgmtHdrVOS.size() > 0){      
				 customMnrAgmtHdrVO = customMnrAgmtHdrVOS.get(0);	 
			 }        
		 }catch(SQLException se){    
			 log.error(se.getMessage(),se);    
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){   
			 log.error(ex.getMessage(),ex);   	
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }    
		 return customMnrAgmtHdrVO;    
	 }  
	  
	 /**
	  * [EES_MNR_0218]M&R Agreement의 정보를 조회 합니다. <br>
	  *
	  * @param AgreementINVO agreementINVO
	  * @return List<CustomMnrAgmtRtVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrAgmtRtVO> searchAGMTRateData(AgreementINVO agreementINVO) throws DAOException {
		 DBRowSet dbRowset = null; 
		 List<CustomMnrAgmtRtVO> customMnrAgmtRtVOS = null; 
		 //query parameter   
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter    
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 Map<String, String> mapVO = agreementINVO.getColumnValues();
		  
		 param.putAll(mapVO);	                                           
		 velParam.putAll(mapVO);             
		 	
		 try{    
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RateMgtDBDAOsearchAGMTRateDataRSQL(), param, velParam);
			 customMnrAgmtRtVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrAgmtRtVO .class);
		 }catch(SQLException se){      
			 log.error(se.getMessage(),se);   
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){	
			 log.error(ex.getMessage(),ex);  	
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }   
		 return customMnrAgmtRtVOS;          
	 } 
	 
	 /**
	  * [EES_MNR_0015]M&R Agreement의 정보를 추가 합니다. <br>
	  *
	  * @return String
	  * @exception DAOException
	  */  
	 public String addMnrAgmtSeqData() throws DAOException{
	 	DBRowSet dbRowset = null;    
	 	String returnVal = "";
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	//velocity parameter
	 	Map<String, Object> velParam = new HashMap<String, Object>();
	 	
	 	try{
	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RateMgtDBDAOaddMnrAgmtSeqDataRSQL(), param, velParam);
	 		if(dbRowset.next()){ 
	 			returnVal = dbRowset.getString("SEQ");
	 		}
	 	}catch(SQLException se){
	 		log.error(se.getMessage(),se); 
	 		throw new DAOException(new ErrorHandler(se).getMessage());
	 	}catch(Exception ex){
	 		log.error(ex.getMessage(),ex);  	
	 		throw new DAOException(new ErrorHandler(ex).getMessage());
	 	}    
	 	return returnVal;
	 }
	 
	 /**
	  * [EES_MNR_0015]M&R Agreement의 정보를 추가 합니다. <br>
	  *
	  * @param CustomMnrAgmtHdrVO customMnrAgmtHdrVO
	  * @exception DAOException
	  */  
	public void addAGMTHDRData(CustomMnrAgmtHdrVO customMnrAgmtHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter           
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = customMnrAgmtHdrVO.getColumnValues();
		     	    
			param.putAll(mapVO);     
			velParam.putAll(mapVO);  
			 
			SQLExecuter sqlExe = new SQLExecuter(""); 
			int result = sqlExe.executeUpdate((ISQLTemplate)new RateMgtDBDAOaddAGMTHDRDataCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED) 
					throw new DAOException("Fail to RateMgtDBDAOaddAGMTHDRDataCSQL insert SQL");
		} catch (SQLException se) { 
			log.error(se.getMessage(),se); 
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}   
	} 
	
	/**
	 * [EES_MNR_0015]M&R Agreement의 정보를 수정 합니다. <br>
	 *
	 * @param CustomMnrAgmtHdrVO customMnrAgmtHdrVO
	 * @exception DAOException
	 */  
	public void modifyAGMTHDRData(CustomMnrAgmtHdrVO customMnrAgmtHdrVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter           
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = customMnrAgmtHdrVO.getColumnValues();
			
			param.putAll(mapVO);     
			velParam.putAll(mapVO);   
			  
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new RateMgtDBDAOmodifyAGMTHDRDataUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail RateMgtDBDAOmodifyAGMTHDRDataUSQL modify SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_MNR_0015]M&R Agreement의 정보를 추가 합니다. <br>
	 *
	 * @param List<CustomMnrAgmtRtVO> customMnrAgmtRtVOs
	 * @exception DAOException
	 */
	public void addAGMTRateData(List<CustomMnrAgmtRtVO> customMnrAgmtRtVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
//			int insCnt[] = null;
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter           
			Map<String, Object> velParam = new HashMap<String, Object>();
			if(customMnrAgmtRtVOs.size() > 0){ 
//				insCnt = sqlExe.executeBatch((ISQLTemplate)new RateMgtDBDAOaddAGMTRateDataCSQL(), customMnrAgmtRtVOs,null);
//				for(int i = 0; i < insCnt.length; i++){
//					if(insCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to RateMgtDBDAOaddAGMTRateDataCSQL insert No"+ i + " SQL");
//				}    
				for(int i = 0; i < customMnrAgmtRtVOs.size(); i++){
					Map<String, String> mapVO = customMnrAgmtRtVOs.get(i).getColumnValues();
					
					param.putAll(mapVO);     
					velParam.putAll(mapVO);
					
					int result = sqlExe.executeUpdate((ISQLTemplate)new RateMgtDBDAOaddAGMTRateDataCSQL(), param, velParam);
					if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail RateMgtDBDAOmodifyAGMTHDRDataUSQL modify SQL");
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
	 * [EES_MNR_0015]M&R Agreement의 정보를 추가 합니다. <br>
	 *
	 * @param List<CustomMnrAgmtAplyOfcVO> customMnrAgmtAplyOfcVOs
	 * @exception DAOException
	 */
	public void addAGMTCTLOFCData(List<CustomMnrAgmtAplyOfcVO> customMnrAgmtAplyOfcVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrAgmtAplyOfcVOs.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RateMgtDBDAOaddAGMTCTLOFCDataCSQL(), customMnrAgmtAplyOfcVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to RateMgtDBDAOaddAGMTCTLOFCDataCSQL ins No"+ i + " SQL");
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
	 * [EES_MNR_0015]M&R Agreement의 정보를 추가 합니다. <br>
	 *
	 * @param AgreementINVO agreementINVO
	 * @exception DAOException
	 */
	public void addAGMTCostDTLData(AgreementINVO agreementINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = agreementINVO.getColumnValues();
			
			param.putAll(mapVO);   
			velParam.putAll(mapVO);       
			    
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new RateMgtDBDAOaddAGMTCostDTLDataCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)  
				throw new DAOException("Fail to RateMgtDBDAOaddAGMTCostDTLDataCSQL");    
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_MNR_0018]M&R Agreement List의 정보를 조회 합니다. <br>
	 *
	 * @param AgreementInfoListINVO agreementInfoListINVO
	 * @return List<CustomAgreementInfoListDataVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CustomAgreementInfoListDataVO> searchAgreementInfoListData(AgreementInfoListINVO agreementInfoListINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomAgreementInfoListDataVO> customAgreementInfoListDataVOs = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{ 
			
			Map<String, String> mapVO = agreementInfoListINVO.getColumnValues();
			
			param.putAll(mapVO);   
			velParam.putAll(mapVO);       
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RateMgtDBDAOsearchAgreementInfoListDataRSQL(), param, velParam);
			
			customAgreementInfoListDataVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomAgreementInfoListDataVO .class);
		}catch(SQLException se){  
			log.error(se.getMessage(),se);   
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);   	
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}       
		return customAgreementInfoListDataVOs;
	}
	 
	 /**
	  * [EES_MNR_0226]W/O Creation의 정보를 조회 합니다. <br>
	  *
	  * @param AgreementComboListINVO agreementComboListINVO
	  * @return List<CustomMnrAgmtHdrVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrAgmtHdrVO> searchAgreementComboListData(AgreementComboListINVO agreementComboListINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CustomMnrAgmtHdrVO> customMnrAgmtHdrVOS = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 		
		 try{ 
			 Map<String, String> mapVO = agreementComboListINVO.getColumnValues();
			 
			 param.putAll(mapVO);   
			 velParam.putAll(mapVO);       
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RateMgtDBDAOsearchAgreementComboListDataRSQL(), param, velParam);
			 
			 customMnrAgmtHdrVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrAgmtHdrVO .class);
		 }catch(SQLException se){  
			 log.error(se.getMessage(),se);   
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);  	
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }		       
		 return customMnrAgmtHdrVOS; 
	 }
	 
	 /**
	  * [EES_MNR_0015]M&R Agreement Duplication Check <br>
	  * 
	  * @param CustomMnrAgmtHdrVO customMnrAgmtHdrVO
	  * @return String
	  * @exception DAOException
	  */  
	 public String searchAgmtDupInfoData(CustomMnrAgmtHdrVO customMnrAgmtHdrVO) throws DAOException{
	 	DBRowSet dbRowset = null;    
	 	String returnVal = "";
	 	Map<String, Object> param = new HashMap<String, Object>();
	 	//velocity parameter
	 	Map<String, Object> velParam = new HashMap<String, Object>();
	 	
	 	try{
	 		Map<String, String> mapVO = customMnrAgmtHdrVO.getColumnValues();
			
			param.putAll(mapVO);     
			velParam.putAll(mapVO);
	 		
	 		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RateMgtDBDAOsearchAgmtInfoDupDataRSQL(), param, velParam);
	 		if(dbRowset.next()){ 
	 			returnVal = dbRowset.getString("AGMT_NO");
	 		}
	 	}catch(SQLException se){
	 		log.error(se.getMessage(),se); 
	 		throw new DAOException(new ErrorHandler(se).getMessage());
	 	}catch(Exception ex){
	 		log.error(ex.getMessage(),ex);  	
	 		throw new DAOException(new ErrorHandler(ex).getMessage());
	 	}    
	 	return returnVal;
	 }
}
