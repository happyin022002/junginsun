/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RateMgtDBDAO.java
*@FileTitle : M&R Agreement
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.18
*@LastModifier : Chang Young Kim
*@LastVersion : 1.0
* 2009.05.12 박명신
* 1.0 Creation
* 2014-12-18 Chang Young Kim [CHM-201433304] CSR 승인 강화에 따른 ALPS MNR-AGMT에 GW Document Contract Link 관련 추가 요청 사항
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.basic.RateMgtBCImpl;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.AgmtAtchDataVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.AgreementComboListINVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.AgreementINVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.AgreementInfoListINVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.CustomAgreementInfoListDataVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.CustomAgreementMenuDataVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.CustomAplyOfcPartnerVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.CustomMnrAgmtAplyOfcVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.CustomMnrAgmtHdrVO;
import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.CustomMnrAgmtRtVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps RateMgtDBDAO <br>
 * - alps-MNRCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author park myoung sin
 * @see RateMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class RateMgtDBDAO extends DBDAOSupport {
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
			int insCnt[] = null;
			if(customMnrAgmtRtVOs.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new RateMgtDBDAOaddAGMTRateDataCSQL(), customMnrAgmtRtVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to RateMgtDBDAOaddAGMTRateDataCSQL insert No"+ i + " SQL");
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
	 * [EES_MNR_0017]M&R Agreement Attach의 정보를 조회 합니다. <br>
	 *
	 * @param AgmtAtchDataVO agmtAtchDataVO
	 * @return List<AgmtAtchDataVO> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AgmtAtchDataVO> searchAgreementAttachInfoListData(AgmtAtchDataVO agmtAtchDataVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgmtAtchDataVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{
			Map<String, String> mapVO = agmtAtchDataVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new RateMgtDBDAOsearchAgmtAtchDataRSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgmtAtchDataVO .class);
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
	 * [EES_MNR_0017] M&R Agreement Attach List의 정보를 삭제 합니다. <br>
	 * 
	 * @param AgmtAtchDataVO agmtAtchDataVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void removeAgreementAttachInfoListData(AgmtAtchDataVO agmtAtchDataVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int delCnt = 0;
		 
		try{
			if(agmtAtchDataVO != null){
				Map<String, String> mapVO = agmtAtchDataVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			delCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new RateMgtDBDAOremoveAgmtAtchDataDSQL(), param, velParam);
			
			if(delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_MNR_0017] M&R Agreement Attach List의 정보를 추가 합니다. <br>
	 * 
	 * @param List<AgmtAtchDataVO> agmtAtchDataVOs
	 * @return int insCnt
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public int addAgreementAttachInfoListData(List<AgmtAtchDataVO> agmtAtchDataVOs) throws DAOException {
		int insCnt[] = null;
		int cnt = 0;
		
		try{
//			log.debug("\n222222-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-="+agmtAtchDataVOs.toString());
			if(agmtAtchDataVOs.size() > 0){
				SQLExecuter sqlExe = new SQLExecuter("");

				insCnt = sqlExe.executeBatch((ISQLTemplate)new RateMgtDBDAOaddAgmtAtchDataCSQL(), agmtAtchDataVOs, null);

				for(int i=0; i<insCnt.length; i++){
					cnt++;
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to add No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}
	
	/**
	 * [EES_MNR_0017] M&R Agreement Attach List의 정보를 추가에 따라 MNR_AGMT_HDR.FILE_ATCH_FLG를 update 합니다. <br>
	 * 
	 * @param AgmtAtchDataVO agmtAtchDataVO
	 * @param String fileAtchFlg
	 * @exception DAOException
	 */
	
	public void modifyAgreementHdrInfoListData(AgmtAtchDataVO agmtAtchDataVO, String fileAtchFlg) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int updCnt = 0;
		 
		try{
			if(agmtAtchDataVO != null){
				Map<String, String> mapVO = agmtAtchDataVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("file_atch_flg", fileAtchFlg);
				velParam.put("file_atch_flg", fileAtchFlg);
			}
			
			updCnt = new SQLExecuter("").executeUpdate((ISQLTemplate)new RateMgtDBDAOmodifyAgmtHdrFileFlgDataUSQL(), param, velParam);
			
			if(updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to Modify RateMgtDBDAOmodifyAgmtHdrFileFlgDataUSQL SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}
