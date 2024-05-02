/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeCheckMgtDBDAODAO.java
*@FileTitle : ghost
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.05.12 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.integration;
  
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.vo.VerifyTariffFileListINVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.vo.CustomMnrDatVrfyVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.vo.GeneralCodeINVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.basic.GeneralCodeSearchMgtBCImpl;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMnrGeneralCodeVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.SoldEQFileListGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.VerifyEQFlagFileListINVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstDtlVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EstimateINVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.VerifyEQTypeSizeFlagFileListINVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.VerifyRPRCreateFileListINVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
       
/**
 * COM GeneralCodeSearchMgtDBDAO <br>
 * - COM-MNRCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author park myoung sin
 * @see GeneralCodeSearchMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class GeneralCodeCheckMgtDBDAO extends DBDAOSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * [EES_MNR_S139]Repair Creation File Import_Pop Up의 검증한 정보를 조회 합니다. <br>
	 * 
	 * @param String tmpSeq
	 * @param String vndrSeq
	 * @param String CostOfcCd
	 * @param String inpMsg3
	 * @return List<CustomMnrDatVrfyVO>
	 * @exception DAOException 
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrDatVrfyVO> searchRPRCreateFileListData(String tmpSeq,String vndrSeq,String CostOfcCd,String inpMsg3) throws DAOException {
		DBRowSet dbRowset = null; 
		List<CustomMnrDatVrfyVO> list = null;    
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{        
			param.put("tmp_seq", tmpSeq); 
			param.put("vndr_seq", vndrSeq);
			param.put("cost_ofc_cd", CostOfcCd);
			param.put("inp_msg3", inpMsg3);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOsearchRPRCreateFileListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrDatVrfyVO .class);      
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
	 * [EES_MNR_S139]Repair Creation File Import_Pop Up의 정보를 검증 합니다.<br>
	 * 
	 * @param VerifyRPRCreateFileListINVO verifyRPRCreateFileListINVO
	 * @return int
	 * @exception DAOException 
	 */  
	public int modifyRPRCreateFileListByWOData(VerifyRPRCreateFileListINVO verifyRPRCreateFileListINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
			
		try {   
			Map<String, String> mapVO = verifyRPRCreateFileListINVO.getColumnValues();
				
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			 
			SQLExecuter sqlExe = new SQLExecuter("");  
			  
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyRPRCreateFileListByWODataUSQL(), param, velParam);
				       
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyRPRCreateFileListByWOData"); 
				
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
	 * [EES_MNR_S139]Repair Creation File Import_Pop Up의 정보를 검증 합니다.<br>
	 * 
	 * @param VerifyRPRCreateFileListINVO verifyRPRCreateFileListINVO
	 * @return int
	 * @exception DAOException 	
	 */  
	public int modifyRPRCreateFileListByYDData(VerifyRPRCreateFileListINVO verifyRPRCreateFileListINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try {  
				Map<String, String> mapVO = verifyRPRCreateFileListINVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
				SQLExecuter sqlExe = new SQLExecuter("");  
				result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyRPRCreateFileListByYDDataUSQL(), param, velParam);
					       
				if(result == Statement.EXECUTE_FAILED)     
					throw new DAOException("Fail to Update modifyRPRCreateFileListByYDData"); 
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
	 * [EES_MNR_S139]Repair Creation File Import_Pop Up의 정보를 검증 합니다.<br>
	 * 
	 * @param VerifyRPRCreateFileListINVO verifyRPRCreateFileListINVO
	 * @return int
	 * @exception DAOException 	
	 */  
	public int modifyRPRCreateFileListByRPRData(VerifyRPRCreateFileListINVO verifyRPRCreateFileListINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		 	
		try { 
				Map<String, String> mapVO = verifyRPRCreateFileListINVO.getColumnValues();
				  
				param.putAll(mapVO);  
				velParam.putAll(mapVO);   
				   	     
				SQLExecuter sqlExe = new SQLExecuter("");  
				                 
				result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyRPRCreateFileListByRPRDataUSQL(), param, velParam);
																
				if(result == Statement.EXECUTE_FAILED)     
					throw new DAOException("Fail to Update modifyRPRCreateFileListByRPRData"); 
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
	 * [EES_MNR_0023]Repair Estimate Creation의 정보를 조회 합니다. <br>
	 *
	 * @param EstimateINVO estimateINVO
	 * @return List<CustomMnrRprRqstDtlVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<CustomMnrRprRqstDtlVO> searchVerifyToEstimateDtlData(EstimateINVO estimateINVO) throws DAOException {
		DBRowSet dbRowset = null; 
		List<CustomMnrRprRqstDtlVO> customMnrRprRqstDtlVOs = null;    
		//query parameter	 	     
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 	
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{        
			Map<String, String> mapVO = estimateINVO.getColumnValues();
			
			param.putAll(mapVO);							  
			velParam.putAll(mapVO); 	  				 
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOsearchVerifyToEstimateDtlDataRSQL(), param, velParam);
			customMnrRprRqstDtlVOs = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrRprRqstDtlVO .class);      
		}catch(SQLException se){      
			log.error(se.getMessage(),se);  
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){ 	
			log.error(ex.getMessage(),ex); 
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}          
		return customMnrRprRqstDtlVOs;   
	}
	
	/**
	 * [EES_MNR_0023]Repair Estimate Creation의 정보를 수정 합니다. <br>
	 *
	 * @param List<CustomMnrDatVrfyVO> customMnrDatVrfyVOs
	 * @exception DAOException
	 */
	public void modifyVerifyEstimateCalcData(List<CustomMnrDatVrfyVO> customMnrDatVrfyVOs) throws DAOException,Exception {
		try {				 
			SQLExecuter sqlExe = new SQLExecuter("");  
			int updCnt[] = null;	  	
			if(customMnrDatVrfyVOs.size() > 0){        
				updCnt = sqlExe.executeBatch((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyVerifyEstimateCalcDataUSQL(), customMnrDatVrfyVOs,null);
				
				for(int i = 0; i < updCnt.length; i++){  
					if(updCnt[i]== Statement.EXECUTE_FAILED)     
						throw new DAOException("Fail to modifyVerifyEstimateCalcData No"+ i + " SQL"); 
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
	 * [EES_MNR_0023]Repair Estimate Creation의 정보를 조회 합니다. <br>
	 *
	 * @param EstimateINVO estimateINVO
	 * @return List<CustomMnrRprRqstDtlVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<CustomMnrDatVrfyVO> searchVerifyEstimateCalcData(EstimateINVO estimateINVO) throws DAOException {
		DBRowSet dbRowset = null; 		 
		List<CustomMnrDatVrfyVO> customMnrDatVrfyVOS = null;    
		//query parameter	 	     
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 	
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{        
			Map<String, String> mapVO = estimateINVO.getColumnValues();
			
			param.putAll(mapVO);							  
			velParam.putAll(mapVO);   				 
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOsearchVerifyEstimateCalcDataRSQL(), param, velParam);
			customMnrDatVrfyVOS = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrDatVrfyVO .class);      
		}catch(SQLException se){      
			log.error(se.getMessage(),se);  
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		}catch(Exception ex){ 	
			log.error(ex.getMessage(),ex); 
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}          
		return customMnrDatVrfyVOS;   
	} 
	
	/**
	 * [EES_MNR_0023]Repair Estimate Creation의 정보를 수정 합니다. <br>
	 *
	 * @param EstimateINVO estimateINVO
	 * @return int
	 * @exception DAOException
	 */ 
	public int modifyCalculateEstimateResultData(EstimateINVO estimateINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try {	 
			Map<String, String> mapVO = estimateINVO.getColumnValues();
			
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyCalculateEstimateResultDataUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyCalculateEstimateResultData"); 
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
	 * [EES_MNR_0023]Repair Estimate Creation의 정보를 작업 합니다. <br>
	 *
	 * @param EstimateINVO estimateINVO
	 * @return int
	 * @exception DAOException
	 */
	public int calculateEstimateMaterialCostData(EstimateINVO estimateINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try { 
			Map<String, String> mapVO = estimateINVO.getColumnValues();
			
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			 
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOcalculateEstimateMaterialCostDataUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update calculateEstimateMaterialCostData"); 
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
	 * [EES_MNR_0023]Repair Estimate Creation의 정보를 작업 합니다. <br>
	 *
	 * @param EstimateINVO estimateINVO
	 * @return int
	 * @exception DAOException
	 */
	public int calculateEstimateLaborHourData(EstimateINVO estimateINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
			
		try { 
			Map<String, String> mapVO = estimateINVO.getColumnValues();
			
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOcalculateEstimateLaborHourDataUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update calculateEstimateLaborHourData"); 
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
	 * [EES_MNR_0023]Repair Estimate Creation의 정보를 작업 합니다. <br>
	 *
	 * @param EstimateINVO estimateINVO
	 * @return int
	 * @exception DAOException
	 */
	public int calculateEstimateLaborRateData(EstimateINVO estimateINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
			
		try { 
			Map<String, String> mapVO = estimateINVO.getColumnValues();
						
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
				
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOcalculateEstimateLaborRateDataUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update calculateEstimateLaborRateData"); 
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
	 * [EES_MNR_0023]Repair Estimate Creation의 정보를 수정 합니다. <br>
	 *
	 * @param EstimateINVO estimateINVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyVerifyEstimateFileListByVolumeTypeData(EstimateINVO estimateINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 	
			
		try {		 
			Map<String, String> mapVO = estimateINVO.getColumnValues();
				
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
				
			SQLExecuter sqlExe = new SQLExecuter("");  
				
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyVerifyEstimateFileListByVolumeTypeDataUSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyVerifyEstimateFileListByVolumeTypeData");  
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
	 * [EES_MNR_0023]Repair Estimate Creation의 정보를 수정 합니다. <br>
	 *
	 * @param EstimateINVO estimateINVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyVerifyEstimateFileListByDemageData(EstimateINVO estimateINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 	
		
		try { 
			Map<String, String> mapVO = estimateINVO.getColumnValues();
			
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
					
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyVerifyEstimateFileListByDemageDataUSQL(), param, velParam);
			 
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyVerifyEstimateFileListByDemage");  
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
	 * [EES_MNR_0023]Repair Estimate Creation의 정보를 수정 합니다. <br>
	 *
	 * @param EstimateINVO estimateINVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyVerifyEstimateFileListByRepairData(EstimateINVO estimateINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 	
			
		try { 
			Map<String, String> mapVO = estimateINVO.getColumnValues();
				
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
					
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyVerifyEstimateFileListByRepairDataUSQL(), param, velParam);
				
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyVerifyEstimateFileListByRepairData");  
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
	 * [EES_MNR_0023]Repair Estimate Creation의 정보를 수정 합니다. <br>
	 *
	 * @param EstimateINVO estimateINVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyVerifyEstimateFileListByComponentData(EstimateINVO estimateINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try { 
			Map<String, String> mapVO = estimateINVO.getColumnValues();
			
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyVerifyEstimateFileListByComponentDataUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyVerifyEstimateFileListByComponentData"); 
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
	 * [EES_MNR_0023]Repair Estimate Creation의 정보를 수정 합니다. <br>
	 *
	 * @param EstimateINVO estimateINVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyVerifyEstimateFileListByLocationData(EstimateINVO estimateINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
			
		try { 
			Map<String, String> mapVO = estimateINVO.getColumnValues();
						
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
				
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyVerifyEstimateFileListByLocationDataUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyVerifyEstimateFileListByLocationData"); 
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
	 * [EES_MNR_0220]Disposal Price File Import_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param String tmpSeq
	 * @return List<CustomMnrDatVrfyVO>
	 * @exception DAOException 
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrDatVrfyVO> searchEQFlagFileListData(String tmpSeq) throws DAOException {
		DBRowSet dbRowset = null; 
		List<CustomMnrDatVrfyVO> list = null;    
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{        
			param.put("tmp_seq", tmpSeq);                          
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOsearchEQFlagFileListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrDatVrfyVO .class);      
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
	 * [EES_MNR_0139]Damage Flagging/Unflagging Pop Up의 정보를 수정 합니다. <br>
	 *
	 * @param VerifyEQFlagFileListINVO verifyEQFlagFileListINVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyEQFlagFileListByFlagData(VerifyEQFlagFileListINVO verifyEQFlagFileListINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 

		try {   
			Map<String, String> mapVO = verifyEQFlagFileListINVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");  

			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyEQFlagFileListByFlagDataUSQL(), param, velParam);

			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyEQFlagFileListByEQData"); 
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
	 * [EES_MNR_0139]Damage Flagging/Unflagging Pop Up의 정보를 수정 합니다. <br>
	 *
	 * @param VerifyEQFlagFileListINVO verifyEQFlagFileListINVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyEQFlagFileListByYDData(VerifyEQFlagFileListINVO verifyEQFlagFileListINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 

		try {  
			Map<String, String> mapVO = verifyEQFlagFileListINVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");  

			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyEQFlagFileListByYDDataUSQL(), param, velParam);

			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyEQFlagFileListByYDData"); 
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
	 * [EES_MNR_0139]Damage Flagging/Unflagging Pop Up의 정보를 수정 합니다. <br>
	 *
	 * @param VerifyEQFlagFileListINVO verifyEQFlagFileListINVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyEQFlagFileListByEQData(VerifyEQFlagFileListINVO verifyEQFlagFileListINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		 
		try { 
			Map<String, String> mapVO = verifyEQFlagFileListINVO.getColumnValues();

			param.putAll(mapVO);  
			velParam.putAll(mapVO);   

			SQLExecuter sqlExe = new SQLExecuter("");  

			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyEQFlagFileListByEQDataUSQL(), param, velParam);

			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyEQFlagFileListByEQData"); 
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
	 * [EES_MNR_0221]Sold Creation File Import_Pop Up 의 정보를 추가 합니다. <br>
	 * 다건의 데이터를 일괄적으로 생성한다.<br>
	 * @param List<CustomMnrDatVrfyVO> customMnrDatVrfyVOS
	 * @exception DAOException
	 */
	public void addMnrTempData(List<CustomMnrDatVrfyVO> customMnrDatVrfyVOS) throws DAOException,Exception {
		try {     
			SQLExecuter sqlExe = new SQLExecuter(""); 
			int insCnt[] = null; 
			if(customMnrDatVrfyVOS.size() > 0){  
				insCnt = sqlExe.executeBatch((ISQLTemplate)new GeneralCodeCheckMgtDBDAOaddMnrTempDataCSQL(), customMnrDatVrfyVOS,null);
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
	 * [EES_MNR_0221]Sold Creation File Import_Pop Up 의 정보를 추가 합니다. <br>
	 * 시퀀스를 조회 생성한다.<br>
	 * @return String
	 * @exception DAOException
	 */
	public String addMnrTempSequenceData() throws DAOException{
		DBRowSet dbRowset = null; 
		String returnVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOaddMnrTempSequenceDataRSQL(), param, velParam);
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
	 * [EES_MNR_0226]Vessel Reefer Spare Part Purchase W/O Creation의 정보를 체크 합니다. <br>
	 * 공통 벨리데이션 체크용 오피스 정보를 불러온다 단건
	 * @param GeneralCodeINVO generalCodeINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> checkOfficeCodeData(GeneralCodeINVO generalCodeINVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomMnrGeneralCodeVO> list = null;        
		//query parameter           
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter       
		Map<String, Object> velParam = new HashMap<String, Object>();
		                 
		try{              
			String[] checkCase = generalCodeINVO.getCheckValue().split(","); 
			if(checkCase.length == 2){
				param.put("check_value", checkCase[0]);      
				velParam.put("check_value", checkCase[0]);
				String[] check_value = checkCase[0].split("\\|"); 
				if(check_value.length == 2)
				{
					param.put("check_value", check_value[0]);      
					velParam.put("check_value", check_value[0]); 
					param.put("ofc_knd_cd", check_value[1]);       
					velParam.put("ofc_knd_cd", check_value[1]); 
				}
				param.put("check_hq", checkCase[1]);                     
            	velParam.put("check_hq", checkCase[1]);        
			} else {
				Map<String, String> mapVO = generalCodeINVO.getColumnValues();
				param.putAll(mapVO);                
				velParam.putAll(mapVO);
				
				String[] check_value = generalCodeINVO.getCheckValue().split("\\|"); 
				if(check_value.length == 2)
				{		
		
					param.put("check_value", check_value[0]);      
					velParam.put("check_value", check_value[0]); 
					param.put("ofc_knd_cd", check_value[1]);       
					velParam.put("ofc_knd_cd", check_value[1]); 
				}
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOcheckOfficeCodeDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO .class);                  
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
	 * [EES_MNR_0226]Vessel Reefer Spare Part Purchase W/O Creation의 정보를 체크 합니다. <br>
	 * 공통 벨리데이션 체크용 EQ_NO 를 불러온다 단건
	 * @param GeneralCodeINVO generalCodeINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> checkEQNumberData(GeneralCodeINVO generalCodeINVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomMnrGeneralCodeVO> list = null;    
		//query parameter           
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter       
		Map<String, Object> velParam = new HashMap<String, Object>();
		                      
		try{  
			String[] checkCase = generalCodeINVO.getCheckValue().split(","); 
			if(checkCase.length == 2){
				param.put("check_value", checkCase[0]);                           
				param.put("check_eq_type", checkCase[1]); 
				
				velParam.put("check_value", checkCase[0]);               
				velParam.put("check_eq_type", checkCase[1]);          
			
			} else {
				param.put("check_value", generalCodeINVO.getCheckValue()); 
				velParam.put("check_value", generalCodeINVO.getCheckValue()); 
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOcheckEQNumberDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO .class);                  
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
	 * [MNR_COMMON] Estimate 용 EQNO 체크 <br>
	 * 공통 벨리데이션 체크용 EQ_NO 를 불러온다 단건
	 * @param GeneralCodeINVO generalCodeINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> checkESTEQNumberData(GeneralCodeINVO generalCodeINVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomMnrGeneralCodeVO> list = null;     
		//query parameter           
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter	       
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{  
			String[] checkCase = generalCodeINVO.getCheckValue().split(","); 
			if(checkCase.length == 2){
				param.put("check_value", checkCase[0]);                           
				param.put("check_eq_type", checkCase[1]); 
					
				velParam.put("check_value", checkCase[0]);               
				velParam.put("check_eq_type", checkCase[1]);          
					
			} else {	
				param.put("check_value", generalCodeINVO.getCheckValue()); 
				velParam.put("check_value", generalCodeINVO.getCheckValue()); 
			}		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOcheckESTEQNumberDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO .class);                  
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
	 * [MNR_COMMON] Disposal EQ Number 의 정보를 체크 합니다. <br>
	 * 공통 벨리데이션 체크용 Disposal EQ_NO 를 불러온다 단건
	 * @param GeneralCodeINVO generalCodeINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> checkDSPEQNumberData(GeneralCodeINVO generalCodeINVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomMnrGeneralCodeVO> list = null;    
		//query parameter           
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter       
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{   
			String[] checkCase = generalCodeINVO.getCheckValue().split(","); 
			
			if(checkCase.length == 4) {
		    	//GESU8050851,U,disp_no, typp_size      
				param.put("eq_no", checkCase[0]);                           
				param.put("eq_type", checkCase[1]); 
				param.put("disp_no", checkCase[2]); 
				param.put("eq_tpsz_cd", checkCase[3]); 
				
				velParam.put("eq_no", checkCase[0]);               
				velParam.put("eq_type", checkCase[1]);          
				velParam.put("disp_no", checkCase[2]); 
				velParam.put("eq_tpsz_cd", checkCase[3]); 
				
			} else if(checkCase.length == 3){
		    	//GESU8050851,U,disp_no      
				param.put("eq_no", checkCase[0]);                           
				param.put("eq_type", checkCase[1]); 
				param.put("disp_no", checkCase[2]); 
				
				velParam.put("eq_no", checkCase[0]);               
				velParam.put("eq_type", checkCase[1]);          
				velParam.put("disp_no", checkCase[2]); 
		    } else {
		    	param.put("eq_no", checkCase[0]);                           
				param.put("eq_type", checkCase[1]); 
				param.put("disp_no", "");  
				 
				velParam.put("eq_no", checkCase[0]);               
				velParam.put("eq_type", checkCase[1]);          
				velParam.put("disp_no", ""); 
		    }  
					
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOcheckDSPEQNumberDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO .class);                  
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
	 * [MNR_COMMON] MNR_ORD_DTL 테이블에 실제로 존재하는지 확인 <br>
	 * 공통 벨리데이션 체크용 Work Order를 불러온다.
	 * @param GeneralCodeINVO generalCodeINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> checkWorkOrderDtlData(GeneralCodeINVO generalCodeINVO) throws DAOException {
		DBRowSet dbRowset = null;    
		List<CustomMnrGeneralCodeVO> list = null;       
		//query parameter           
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter       
		Map<String, Object> velParam = new HashMap<String, Object>();
		  	 
		try{     
			String[] checkCase = generalCodeINVO.getCheckValue().split(","); 
			 	      
			if(checkCase.length == 2){   
				param.put("mnr_ord_ofc_cty_cd", checkCase[0]);                           
				param.put("mnr_ord_seq", checkCase[1]);  
				 	  
				velParam.put("mnr_ord_ofc_cty_cd", checkCase[0]);               
				velParam.put("mnr_ord_seq", checkCase[1]);           
			}	 	    
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOcheckWorkOrderDtlDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO .class);                  
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
	 * [EES_MNR_0226]Vessel Reefer Spare Part Purchase W/O Creation의 정보를 체크 합니다. <br>
	 * 벨리데이션 체크용 콤포넌트 코드를 불러온다 단건
	 * @param GeneralCodeINVO generalCodeINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> checkComponentCodeData(GeneralCodeINVO generalCodeINVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomMnrGeneralCodeVO> list = null;    
		//query parameter           
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter       
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{    
			param.put("check_value", generalCodeINVO.getCheckValue()); 
			velParam.put("check_value", generalCodeINVO.getCheckValue()); 
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOcheckComponentCodeDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO .class);                  
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
	 * [EES_MNR_0226]Vessel Reefer Spare Part Purchase W/O Creation의 정보를 체크 합니다. <br>
	 * 공통 벨리데이션 체크용 MDM_LOCATION 를 불러온다 단건
	 * @param GeneralCodeINVO generalCodeINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> checkMdmLocCodeData(GeneralCodeINVO generalCodeINVO) throws DAOException {
		DBRowSet dbRowset = null;    
		List<CustomMnrGeneralCodeVO> list = null;    
		//query parameter           
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter       
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{  
			String[] checkCase = generalCodeINVO.getCheckValue().split(","); 
			if(checkCase.length == 2){
				param.put("check_value", checkCase[0]);                       
				param.put("check_eq_type", checkCase[1]);                        
				velParam.put("check_value", checkCase[0]);               
				velParam.put("check_eq_type", checkCase[1]);         
			} else {
				param.put("check_value", generalCodeINVO.getCheckValue()); 
				velParam.put("check_value", generalCodeINVO.getCheckValue()); 
						
				velParam.put("check_value", "");                
				velParam.put("check_eq_type", "");   
			}		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOcheckMdmLocCodeDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO .class);                  
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
	 * [EES_MNR_0226]Vessel Reefer Spare Part Purchase W/O Creation의 정보를 체크 합니다. <br>
	 * 공통벨리데이션 체크용 YARD 정보를 불러온다 단건
	 * @param GeneralCodeINVO generalCodeINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> checkYardCodeData(GeneralCodeINVO generalCodeINVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomMnrGeneralCodeVO> list = null;    
		//query parameter           
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter       
		Map<String, Object> velParam = new HashMap<String, Object>();
		                  
		try{              
			Map<String, String> mapVO = generalCodeINVO.getColumnValues();
			       
			param.putAll(mapVO);               
			velParam.putAll(mapVO);               
			                          
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOcheckYardCodeDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO .class);                  
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
	 * [EES_MNR_0226]Vessel Reefer Spare Part Purchase W/O Creation의 정보를 체크 합니다. <br>
	 * 공통벨리데이션 체크용 LOCATION 정보를 불러온다 단건
	 * @param GeneralCodeINVO generalCodeINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> checkLocCodeData(GeneralCodeINVO generalCodeINVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomMnrGeneralCodeVO> list = null;    
		//query parameter           
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter	       
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{	              
			Map<String, String> mapVO = generalCodeINVO.getColumnValues();
				
			param.putAll(mapVO);               
			velParam.putAll(mapVO); 	              
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOcheckLocCodeDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO .class);                  
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
	 * [EES_MNR_0226]Vessel Reefer Spare Part Purchase W/O Creation의 정보를 체크 합니다. <br>
	 * 공통 벨리데이션 체크용 LOCATION 정보를 불러온다 단건
	 * @param GeneralCodeINVO generalCodeINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> checkLaneCodeData(GeneralCodeINVO generalCodeINVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomMnrGeneralCodeVO> list = null;    
		//query parameter           
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter	       
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try{	              
			Map<String, String> mapVO = generalCodeINVO.getColumnValues();
				
			param.putAll(mapVO);               
			velParam.putAll(mapVO); 	              
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOcheckLaneCodeDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO .class);                  
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
	 * [EES_MNR_0097]Total Loss EQ Add시 EQ No정보를 체크합니다. <br>
	 * 공통 벨리데이션 체크용 EQ No 체크
	 * @param GeneralCodeINVO generalCodeINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> checkTLLEQNumberData(GeneralCodeINVO generalCodeINVO) throws DAOException {
		DBRowSet dbRowset = null;    
		List<CustomMnrGeneralCodeVO> list = null;       
		//query parameter           
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter       
		Map<String, Object> velParam = new HashMap<String, Object>();
		  	 
		try{     
			String[] checkCase = generalCodeINVO.getCheckValue().split(","); 
			 	      
			if(checkCase.length == 4){   
				param.put("eq_no", checkCase[0]);                           
				param.put("eq_type", checkCase[1]);  
				param.put("eq_tpsz_cd", checkCase[2]);  
				param.put("ttl_no", checkCase[3]);  
				 	  
				velParam.put("eq_no", checkCase[0]);               
				velParam.put("eq_type", checkCase[1]);     
				velParam.put("eq_tpsz_cd", checkCase[2]); 
				velParam.put("ttl_no", checkCase[3]); 
			}	 	    
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOcheckTLLEQNumberDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO .class);                  
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
	 * [EES_MNR_0221]Vessel Sold Creation File Import_Pop Up의 정보를 체크 합니다. <br>
	 * 공통벨리데이션 체크용 YARD 정보를 불러온다 단건
	 * @param GeneralCodeINVO generalCodeINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> checkSldYardCodeData(GeneralCodeINVO generalCodeINVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomMnrGeneralCodeVO> list = null;    
		//query parameter           
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter       
		Map<String, Object> velParam = new HashMap<String, Object>();
		                  
		try{              
			Map<String, String> mapVO = generalCodeINVO.getColumnValues();
			       
			param.putAll(mapVO);               
			velParam.putAll(mapVO);               
			                          
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOcheckSldYardCodeDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO .class);                  
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
	 * [EES_MNR_S301] Bidding List 의 Country 정보를 체크 합니다. <br>
	 * 공통벨리데이션 체크용 COUNTRY 정보를 불러온다 단건
	 * @param GeneralCodeINVO generalCodeINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> checkCountryCodeData(GeneralCodeINVO generalCodeINVO) throws DAOException {
		DBRowSet dbRowset = null;   
		List<CustomMnrGeneralCodeVO> list = null;    
		//query parameter           
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter       
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{              
			Map<String, String> mapVO = generalCodeINVO.getColumnValues();
			
			param.putAll(mapVO);               
			velParam.putAll(mapVO);               
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOcheckCountryCodeDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO .class);                  
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
	  * [EES_MNR_0143]M&R Invoice Creation File Import Pop Up의 정보를 수정 합니다. <br>
	  *
	  * @param GeneralCodeINVO generalCodeINVO
	  * @return int
	  * @exception DAOException
	  */ 
		public int modifyPayableInvoiceFileListByOFCData(GeneralCodeINVO generalCodeINVO) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0; 
			 	
			try { 
					Map<String, String> mapVO = generalCodeINVO.getColumnValues();
					  
					param.putAll(mapVO);  
					velParam.putAll(mapVO);   
					   	     
					SQLExecuter sqlExe = new SQLExecuter("");  
					                 
					result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyPayableInvoiceFileListByOFCDataUSQL(), param, velParam);
					                         	       
					if(result == Statement.EXECUTE_FAILED)     
						throw new DAOException("Fail to Update modifyPayableInvoiceFileListByOFCData"); 
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
		 * [EES_MNR_0143]M&R Invoice Creation File Import Pop Up의 정보를 수정 합니다. <br>
		 *
		 * @param GeneralCodeINVO generalCodeINVO
		 * @return int
		 * @exception DAOException
		 */
		public int modifyPayableInvoiceFileListByVNDRData(GeneralCodeINVO generalCodeINVO) throws DAOException,Exception {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0; 
			 	
			try { 
					Map<String, String> mapVO = generalCodeINVO.getColumnValues();
					  
					param.putAll(mapVO);  
					velParam.putAll(mapVO);   
					   	     
					SQLExecuter sqlExe = new SQLExecuter("");  
					                 
					result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyPayableInvoiceFileListByVNDRDataUSQL(), param, velParam);
					                         	       
					if(result == Statement.EXECUTE_FAILED)     
						throw new DAOException("Fail to Update modifyPayableInvoiceFileListByVNDRData"); 
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
		 * [EES_MNR_0143]M&R Invoice Creation File Import Pop Up의 정보를 수정 합니다. <br>
		 *
		 * @param GeneralCodeINVO generalCodeINVO
		 * @return int
		 * @exception DAOException
		 */  
	public int modifyPayableInvoiceFileListByWOData(GeneralCodeINVO generalCodeINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		 	
		try { 
				Map<String, String> mapVO = generalCodeINVO.getColumnValues();
				  
				param.putAll(mapVO);  
				velParam.putAll(mapVO);   
				   	     
				SQLExecuter sqlExe = new SQLExecuter("");  
				                 
				result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyPayableInvoiceFileListByWODataUSQL(), param, velParam);
				                         	       
				if(result == Statement.EXECUTE_FAILED)     
					throw new DAOException("Fail to Update modifyPayableInvoiceFileListByWOData"); 
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
	 * [EES_MNR_0143]M&R Invoice Creation File Import Pop Up의 정보를 수정 합니다. <br>
	 *
	 * @param GeneralCodeINVO generalCodeINVO
	 * @return int
	 * @exception DAOException
	 */  
	public int modifyPayableInvoiceFileListByWOAmtData(GeneralCodeINVO generalCodeINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		 	
		try { 
				Map<String, String> mapVO = generalCodeINVO.getColumnValues();
				  
				param.putAll(mapVO);  
				velParam.putAll(mapVO);   
				   	     
				SQLExecuter sqlExe = new SQLExecuter("");  
				                 
				result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyPayableInvoiceFileListByWOAmtDataUSQL(), param, velParam);
				                         	       
				if(result == Statement.EXECUTE_FAILED)     
					throw new DAOException("Fail to Update modifyPayableInvoiceFileListByWOAmtData"); 
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
	 * [EES_MNR_0143]M&R Invoice Creation File Import Pop Up의 정보를 수정 합니다. <br>
	 *
	 * @param GeneralCodeINVO generalCodeINVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyPayableInvoiceFileListData(GeneralCodeINVO generalCodeINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		 	
		try { 
				Map<String, String> mapVO = generalCodeINVO.getColumnValues();
				  
				param.putAll(mapVO);  
				velParam.putAll(mapVO);   
				   	     
				SQLExecuter sqlExe = new SQLExecuter("");  
				                 
				result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyPayableInvoiceFileListDataUSQL(), param, velParam);
				                         	       
				if(result == Statement.EXECUTE_FAILED)     
					throw new DAOException("Fail to Update modifyPayableInvoiceFileListData"); 
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
	 * [EES_MNR_0143]M&R Invoice Creation File Import Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param String tmpSeq
	 * @return List<CustomMnrDatVrfyVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrDatVrfyVO> searchPayableInvoiceFileListData(String tmpSeq) throws DAOException {
		DBRowSet dbRowset = null; 
		List<CustomMnrDatVrfyVO> list = null;    
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
	    	               
		try{        
			param.put("tmp_seq", tmpSeq);                          
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOsearchPayableInvoiceFileListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrDatVrfyVO .class);      
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
	 * [EES_MNR_0219]M&R Simple WO File Import Pop_Up의 정보를 수정 합니다. <br>
	 *
	 * @param VerifyEQTypeSizeFlagFileListINVO verifyEQTypeSizeFlagFileListINVO
	 * @return int
	 * @exception DAOException
	 */ 
	public int modifyWOFileListByEQData(VerifyEQTypeSizeFlagFileListINVO verifyEQTypeSizeFlagFileListINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		 	
		try { 
				Map<String, String> mapVO = verifyEQTypeSizeFlagFileListINVO.getColumnValues();
				  
				param.putAll(mapVO);  
				velParam.putAll(mapVO);   
				   	     
				SQLExecuter sqlExe = new SQLExecuter("");  
				                 
				result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyWOFileListByEQDataUSQL(), param, velParam);
				                         	       
				if(result == Statement.EXECUTE_FAILED)     
					throw new DAOException("Fail to Update modifyEQFlagFileListByEQData"); 
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
	 * [EES_MNR_0219]M&R Simple WO File Import Pop_Up의 정보를 수정 합니다. <br>
	 *
	 * @param VerifyEQTypeSizeFlagFileListINVO verifyEQTypeSizeFlagFileListINVO
	 * @return int
	 * @exception DAOException
	 */  
	public int modifyWOFileListByYDData(VerifyEQTypeSizeFlagFileListINVO verifyEQTypeSizeFlagFileListINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try {  
				Map<String, String> mapVO = verifyEQTypeSizeFlagFileListINVO.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
				SQLExecuter sqlExe = new SQLExecuter("");  
				
				result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyWOFileListByYDDataUSQL(), param, velParam);
					       
				if(result == Statement.EXECUTE_FAILED)     
					throw new DAOException("Fail to Update modifyEQFlagFileListByYDData"); 
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
	 * [EES_MNR_0219]M&R Simple WO File Import Pop_Up의 정보를 수정 합니다. <br>
	 *
	 * @param VerifyEQTypeSizeFlagFileListINVO verifyEQTypeSizeFlagFileListINVO
	 * @return int
	 * @exception DAOException
	 */ 
	public int modifyWOFileListByFlagData(VerifyEQTypeSizeFlagFileListINVO verifyEQTypeSizeFlagFileListINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
			
		try {   
				Map<String, String> mapVO = verifyEQTypeSizeFlagFileListINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				 
				SQLExecuter sqlExe = new SQLExecuter("");  
				  
				result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyWOFileListByFlagDataUSQL(), param, velParam);
					       
				if(result == Statement.EXECUTE_FAILED)     
					throw new DAOException("Fail to Update modifyEQFlagFileListByEQData"); 
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
	 * [EES_MNR_0219]동일한 Service Provider에 이미 입력되었는데 아직 Invoice로 처리되지 않은 내역를 수정/검증 합니다. <br>
	 *
	 * @param VerifyEQTypeSizeFlagFileListINVO verifyEQTypeSizeFlagFileListINVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyWOFileListByIssueData(VerifyEQTypeSizeFlagFileListINVO verifyEQTypeSizeFlagFileListINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
			
		try {   
				Map<String, String> mapVO = verifyEQTypeSizeFlagFileListINVO.getColumnValues();
					
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				 
				SQLExecuter sqlExe = new SQLExecuter("");  
				  
				result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyWOFileListByIssueDataUSQL(), param, velParam);
					       
				if(result == Statement.EXECUTE_FAILED)     
					throw new DAOException("Fail to Update modifyWOFileListByIssueData"); 
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
	 * [EES_MNR_0219]M&R Simple WO File Import Pop_Up의 정보를 조회 합니다. <br>
	 *
	 * @param String tmpSeq
	 * @return List<CustomMnrDatVrfyVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrDatVrfyVO> searchWOFileListData(String tmpSeq) throws DAOException {
		DBRowSet dbRowset = null; 
		List<CustomMnrDatVrfyVO> list = null;    
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{        
			param.put("tmp_seq", tmpSeq);                          
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOsearchWOFileListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrDatVrfyVO .class);      
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
	 * [EES_MNR_0220]Disposal Price File Import_Pop Up의 정보를 수정 합니다. <br>
	 *
	 * @param List<CustomMnrDatVrfyVO> customMnrDatVrfyVOs
	 * @exception DAOException
	 */
	public void modifyDisposalPriceFileListData(List<CustomMnrDatVrfyVO> customMnrDatVrfyVOs) throws DAOException,Exception {
		try {	
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter 
			Map<String, Object> velParam = new HashMap<String, Object>(); 
			int insCnt[] = null;
			if(customMnrDatVrfyVOs.size() > 0){  
				insCnt = sqlExe.executeBatch((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyDisposalPriceFileListDataUSQL(), customMnrDatVrfyVOs, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " addDisposalBuyerDetailData");
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
	 * [EES_MNR_0220]Disposal Price File Import_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param String tmpSeq
	 * @return List<CustomMnrDatVrfyVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrDatVrfyVO> searchDisposalPriceFileListData(String tmpSeq) throws DAOException {
		DBRowSet dbRowset = null; 
		List<CustomMnrDatVrfyVO> list = null;    
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
				
		try{        
			param.put("tmp_seq", tmpSeq);                          
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOsearchDisposalPriceFileListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrDatVrfyVO .class);      
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
	 * [EES_MNR_0190]Local Tariff File Import_Pop Up의 정보를 수정 합니다. <br>
	 *
	 * @param VerifyTariffFileListINVO verifyTariffFileListINVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyVerifyTariffFileListByComponentData(VerifyTariffFileListINVO verifyTariffFileListINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		 	
		try { 
				Map<String, String> mapVO = verifyTariffFileListINVO.getColumnValues();
				  
				param.putAll(mapVO);  
				velParam.putAll(mapVO);   
				   	     
				SQLExecuter sqlExe = new SQLExecuter("");  
				                 
				result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyVerifyTariffFileListByComponentDataUSQL(), param, velParam);
				                         	       
				if(result == Statement.EXECUTE_FAILED)     
					throw new DAOException("Fail to Update modifyVerifyTariffFileListByComponentData"); 
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
	 * [EES_MNR_0190]Local Tariff File Import_Pop Up의 정보를 수정 합니다. <br>
	 *
	 * @param VerifyTariffFileListINVO verifyTariffFileListINVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyVerifyTariffFileListByRepairData(VerifyTariffFileListINVO verifyTariffFileListINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
			
		try { 
			Map<String, String> mapVO = verifyTariffFileListINVO.getColumnValues();
			
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyVerifyTariffFileListByRepairDataUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyVerifyTariffFileListByRepairData"); 
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
	 * [EES_MNR_0190]Local Tariff File Import_Pop Up의 정보를 수정 합니다. <br>
	 *
	 * @param VerifyTariffFileListINVO verifyTariffFileListINVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyVerifyTariffFileListByDivData(VerifyTariffFileListINVO verifyTariffFileListINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try { 
			Map<String, String> mapVO = verifyTariffFileListINVO.getColumnValues();
			
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyVerifyTariffFileListByDivDataUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyVerifyTariffFileListByDivData"); 
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
	 * [EES_MNR_0190]Local Tariff File Import_Pop Up의 정보를 수정 합니다. <br>
	 *
	 * @param VerifyTariffFileListINVO verifyTariffFileListINVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyVerifyTariffFileListByRangeTypeData(VerifyTariffFileListINVO verifyTariffFileListINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try { 
			Map<String, String> mapVO = verifyTariffFileListINVO.getColumnValues();
			
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyVerifyTariffFileListByRangeTypeDataUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyVerifyTariffFileListByRangeTypeData"); 
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
	 * [EES_MNR_0190]Local Tariff File Import_Pop Up의 정보를 수정 합니다. <br>
	 *
	 * @param VerifyTariffFileListINVO verifyTariffFileListINVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyVerifyTariffFileListByRangeTypeLData(VerifyTariffFileListINVO verifyTariffFileListINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try { 
			Map<String, String> mapVO = verifyTariffFileListINVO.getColumnValues();
			
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyVerifyTariffFileListByRangeTypeLDataUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyVerifyTariffFileListByRangeTypeLData"); 
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
	 * [EES_MNR_0190]Local Tariff File Import_Pop Up의 정보를 수정 합니다. <br>
	 *
	 * @param VerifyTariffFileListINVO verifyTariffFileListINVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyVerifyTariffFileListByVolumeTypeData(VerifyTariffFileListINVO verifyTariffFileListINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try { 
			Map<String, String> mapVO = verifyTariffFileListINVO.getColumnValues();
			
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyVerifyTariffFileListByVolumeTypeDataUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyVerifyTariffFileListByVolumeTypeData"); 
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
	 * [EES_MNR_0190]Local Tariff File Import_Pop Up의 정보를 수정 합니다. <br>
	 *
	 * @param VerifyTariffFileListINVO verifyTariffFileListINVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyVerifyTariffFileListBySizeSquareData(VerifyTariffFileListINVO verifyTariffFileListINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try { 
			Map<String, String> mapVO = verifyTariffFileListINVO.getColumnValues();
			
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyVerifyTariffFileListBySizeSquareDataUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyVerifyTariffFileListBySizeSquareData"); 
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
	 * [EES_MNR_0190]Local Tariff File Import_Pop Up의 정보를 수정 합니다. <br>
	 *
	 * @param VerifyTariffFileListINVO verifyTariffFileListINVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyVerifyTariffFileListByManHourData(VerifyTariffFileListINVO verifyTariffFileListINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try { 
			Map<String, String> mapVO = verifyTariffFileListINVO.getColumnValues();
			
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyVerifyTariffFileListByManHourDataUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyVerifyTariffFileListByManHourData"); 
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
	 * [EES_MNR_0190]Local Tariff File Import_Pop Up의 정보를 수정 합니다. <br>
	 *
	 * @param VerifyTariffFileListINVO verifyTariffFileListINVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyVerifyTariffFileListByCostGroupData(VerifyTariffFileListINVO verifyTariffFileListINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try { 
			Map<String, String> mapVO = verifyTariffFileListINVO.getColumnValues();
			
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyVerifyTariffFileListByCostGroupDataUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyVerifyTariffFileListByManHourData"); 
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
	 * [EES_MNR_0190]Local Tariff File Import_Pop Up의 정보를 수정 합니다. <br>
	 *
	 * @param VerifyTariffFileListINVO verifyTariffFileListINVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyVerifyLocalTariffFileListByCountData(VerifyTariffFileListINVO verifyTariffFileListINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try { 
			Map<String, String> mapVO = verifyTariffFileListINVO.getColumnValues();
			
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyVerifyLocalTariffFileListByCountDataUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyVerifyLocalTariffFileListByCountData"); 
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
	 * [EES_MNR_0190]Local Tariff File Import_Pop Up의 정보를 수정 합니다. <br>
	 *
	 * @param VerifyTariffFileListINVO verifyTariffFileListINVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyVerifyLocalTariffFileListByStandardTariffData(VerifyTariffFileListINVO verifyTariffFileListINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try { 
			Map<String, String> mapVO = verifyTariffFileListINVO.getColumnValues();
			
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyVerifyLocalTariffFileListByStandardTariffDataUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyVerifyLocalTariffFileListByStandardTariffData"); 
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
	 * [EES_MNR_0190]Standard Tariff File Import_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param String tmpSeq
	 * @return List<CustomMnrDatVrfyVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrDatVrfyVO> searchVerifyTariffFileListData(String tmpSeq) throws DAOException {
		DBRowSet dbRowset = null; 
		List<CustomMnrDatVrfyVO> list = null;    
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
	    	               
		try{        
			param.put("tmp_seq", tmpSeq);                          
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOsearchVerifyTariffFileListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrDatVrfyVO .class);      
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
	 * [EES_MNR_0190]Local Tariff File Import_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param String tmpSeq
	 * @param String stdTrfNo
	 * @return List<CustomMnrDatVrfyVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrDatVrfyVO> searchVerifyLocalTariffFileListData(String tmpSeq, String stdTrfNo) throws DAOException {
		DBRowSet dbRowset = null; 
		List<CustomMnrDatVrfyVO> list = null;    
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{        
			param.put("tmp_seq", tmpSeq);                          
			param.put("std_trf_no", stdTrfNo);                            
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOsearchVerifyLocalTariffFileListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrDatVrfyVO .class);      
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
	  * [EES_MNR_0221]Sold Creation File Import_Pop Up 의 정보를 수정 합니다. <br>
	  *
	  * @param SoldEQFileListGRPVO soldEQFileListGRPVO
	  * @return int
	  * @exception DAOException
	  */
	public int modifyVerifySoldEQFileListByEQNoData(SoldEQFileListGRPVO soldEQFileListGRPVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try { 
			Map<String, String> mapVO = soldEQFileListGRPVO.getSoldEQFileListINVO().getColumnValues();
			
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyVerifySoldEQFileListByEQNoDataUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyVerifySoldEQFileListByEQNo"); 
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
	 * [EES_MNR_0221]Sold Creation File Import_Pop Up 의 정보를 수정 합니다. <br>
	 *
	 * @param SoldEQFileListGRPVO soldEQFileListGRPVO
	 * @return int
	 * @exception DAOException
	 */
	public int modifyVerifySoldEQFileListByYardData(SoldEQFileListGRPVO soldEQFileListGRPVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0; 
		
		try { 
			Map<String, String> mapVO = soldEQFileListGRPVO.getSoldEQFileListINVO().getColumnValues();
			
			param.putAll(mapVO);  
			velParam.putAll(mapVO);   
			
			SQLExecuter sqlExe = new SQLExecuter("");  
			
			result = sqlExe.executeUpdate((ISQLTemplate)new GeneralCodeCheckMgtDBDAOmodifyVerifySoldEQFileListByYardDataUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update modifyVerifySoldEQFileListByYard"); 
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
	 * [EES_MNR_0221]Sold Creation File Import_Pop Up 의 정보를 조회 합니다. <br>
	 *
	 * @param String tmpSeq
	 * @return List<CustomMnrDatVrfyVO>
	 * @exception DAOException
	 */ 
	@SuppressWarnings("unchecked")
	public List<CustomMnrDatVrfyVO> searchVerifySoldEQFileListData(String tmpSeq) throws DAOException {
		DBRowSet dbRowset = null; 
		List<CustomMnrDatVrfyVO> list = null;    
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
	    	               
		try{        
			param.put("tmp_seq", tmpSeq);                          
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOsearchVerifySoldEQFileListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrDatVrfyVO .class);      
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
	 * [EES_MNR_0141]M&R Invoice 금액을 환율변경적용 합니다. <br>
	 *
	 * @param String tmpSeq
	 * @return List<CustomMnrDatVrfyVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrDatVrfyVO> searchPayableINVInquiryCalCurrRateData(String tmpSeq) throws DAOException {
		DBRowSet dbRowset = null; 
		List<CustomMnrDatVrfyVO> list = null;    
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
	    	               
		try{        
			param.put("tmp_seq", tmpSeq);                          
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOsearchPayableINVInquiryCalCurrRateDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrDatVrfyVO .class);      
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
	 * [common] Check Tariff Flag <br>
	 * @return String
	 * @exception DAOException
	 */
	public String searchTariffFlagData() throws DAOException{
		DBRowSet dbRowset = null; 
		String returnVal = "";
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeCheckMgtDBDAOcheckTariffFlagDataRSQL(), param, velParam);
			if(dbRowset.next()){ 
				returnVal = dbRowset.getString("CODE");
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
