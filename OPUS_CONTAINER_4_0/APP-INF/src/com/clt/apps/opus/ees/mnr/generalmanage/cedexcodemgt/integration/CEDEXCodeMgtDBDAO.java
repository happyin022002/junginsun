/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CEDEXCodeMgtDAO.java
*@FileTitle : EQ Component
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.04.27 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.basic.CEDEXCodeMgtBCImpl;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.CedexOtherCodeListINVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.CodeRelationINVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.ComponentCodeListINVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.CustomMnrCdRltByDmgVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.CustomMnrCdRltByLocVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.CustomMnrCdRltByRprVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.CustomMnrCdRltVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.CustomMnrCedexOtrCdVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.CustomMnrEqCmpoCdVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.CustomMnrEqLocCdVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.CustomTariffCodeFindDataVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.DamageLocationCodeListINVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.DivisionCodeGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.DivisionCodeINVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.RepairCodeFindListGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.cedexcodemgt.vo.RepairCodeFindListINVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
   
/** 
 * COM CEDEXCodeMgtDAO <br>
 * - COM-GeneralManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author pms
 * @see CEDEXCodeMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class CEDEXCodeMgtDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;
			
	/**
	 * [EES_MNR_0225]Division Code Creation의 정보를 추가 합니다. <br>
	 *
	 * @param CustomMnrCdRltVO customMnrCdRltVO
	 * @return int
	 * @exception DAOException
	 */
	 public int addDivisionCodeData(CustomMnrCdRltVO customMnrCdRltVO) throws DAOException {
		//query parameter  
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;				 	
		
		try {   
			Map<String, String> mapVO = customMnrCdRltVO.getColumnValues();
				
			param.putAll(mapVO);       
			velParam.putAll(mapVO);     
			
			SQLExecuter sqlExe = new SQLExecuter("");  
				
			result = sqlExe.executeUpdate((ISQLTemplate)new CEDEXCodeMgtDBDAOaddDivisionCodeDataCSQL(), param, velParam);
		     		
			if(result == Statement.EXECUTE_FAILED)     
				throw new DAOException("Fail to Update addDivisionCodeData");  
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
	  * [EES_MNR_0225]Division Code Creation의 정보를 삭제 합니다. <br>
	  *
	  * @param CustomMnrCdRltVO customMnrCdRltVO
	  * @return int
	  * @exception DAOException
	  */
	 public int removeDivisionCodeData(CustomMnrCdRltVO customMnrCdRltVO) throws DAOException {
		 //query parameter  
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 int result = 0;		 	
		 
		 try {  
			 Map<String, String> mapVO = customMnrCdRltVO.getColumnValues();
			 
			 param.putAll(mapVO);      
			 velParam.putAll(mapVO);     
			 
			 SQLExecuter sqlExe = new SQLExecuter("");  
			 
			 result = sqlExe.executeUpdate((ISQLTemplate)new CEDEXCodeMgtDBDAOremoveDivisionCodeDataDSQL(), param, velParam);
			 
			 if(result == Statement.EXECUTE_FAILED)     
				 throw new DAOException("Fail to Update removeDivisionCodeData"); 
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
	  * [EES_MNR_0225]Division Code Creation의 정보를 삭제 합니다. <br>
	  *
	  * @param List<CustomMnrCdRltVO> customMnrCdRltVOS
	  * @exception DAOException
	  */
	public void removeAllDivisionCodeData(List<CustomMnrCdRltVO> customMnrCdRltVOS) throws DAOException,Exception {
		try {	  
			SQLExecuter sqlExe = new SQLExecuter(""); 
			int insCnt[] = null;
			if(customMnrCdRltVOS.size() > 0){  
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CEDEXCodeMgtDBDAOremoveAllDivisionCodeDataDSQL(), customMnrCdRltVOS,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to removeAllDivisionCodeData No"+ i + " SQL");
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
	 * [EES_MNR_0225]Division Code Creation의 정보를 조회 합니다. <br>
	 *
	 * @param DivisionCodeGRPVO divisionCodeGRPVO
	 * @return List<CustomMnrCdRltVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrCdRltVO> searchDivisionCodeListData(DivisionCodeGRPVO divisionCodeGRPVO) throws DAOException {
		DBRowSet dbRowset = null; 
		List<CustomMnrCdRltVO> list = null;  
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter  
		Map<String, Object> velParam = new HashMap<String, Object>();
		DivisionCodeINVO divisionCodeINVO  = divisionCodeGRPVO.getDivisionCodeINVO();
		try{         
			Map<String, String> mapVO = divisionCodeINVO.getColumnValues();
			
			param.putAll(mapVO);  	                     
			velParam.putAll(mapVO);   
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CEDEXCodeMgtDBDAOsearchDivisionCodeListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrCdRltVO .class);
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
	 * [EES_MNR_0142]Pop Up_Tariff Code Finding의 정보를 조회 합니다. <br>
	 *
	 * @param RepairCodeFindListGRPVO repairCodeFindListGRPVO
	 * @return List<CustomTariffCodeFindDataVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomTariffCodeFindDataVO> searchTariffCodeFindListData(RepairCodeFindListGRPVO repairCodeFindListGRPVO) throws DAOException {
		DBRowSet dbRowset = null; 
		List<CustomTariffCodeFindDataVO> list = null;  
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
		RepairCodeFindListINVO repairCodeFindListINVO  = repairCodeFindListGRPVO.getRepairCodeFindListINVO();
		
		try{        
			if(repairCodeFindListINVO != null){  
				Map<String, String> mapVO = repairCodeFindListINVO.getColumnValues();
				param.putAll(mapVO);
				param.put("typ", repairCodeFindListINVO.getTariffcodetype());
				velParam.putAll(mapVO);
				velParam.put("typ", repairCodeFindListINVO.getTariffcodetype());
			}                               
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CEDEXCodeMgtDBDAOsearchTariffCodeFindListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomTariffCodeFindDataVO .class);
			
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
	 * [EES_MNR_0193]Location Code Inquiry_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param DamageLocationCodeListINVO damageLocationCodeListINVO
	 * @return List<CustomMnrEqLocCdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrEqLocCdVO> searchDamageLocationCodeListListData(DamageLocationCodeListINVO damageLocationCodeListINVO) throws DAOException {
		DBRowSet dbRowset = null; 
		List<CustomMnrEqLocCdVO> list = null;  
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
		try{     
			  
			Map<String, String> mapVO = damageLocationCodeListINVO.getColumnValues();
			
			param.putAll(mapVO);                       
			velParam.putAll(mapVO);  
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CEDEXCodeMgtDBDAOsearchDamageLocationCodeListListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrEqLocCdVO .class);
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
	 * [EES_MNR_0003]Damage Location의 정보를 추가 합니다. <br>
	 *
	 * @param List<CustomMnrEqLocCdVO> customMnrEqLocCdVOs
	 * @exception DAOException
	 */
	public void addDamageLocationCodeData(List<CustomMnrEqLocCdVO> customMnrEqLocCdVOs) throws DAOException,Exception {
		try {	  
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrEqLocCdVOs.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CEDEXCodeMgtDBDAOaddDamageLocationCodeDataCSQL(), customMnrEqLocCdVOs,null);
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
	 * [EES_MNR_0003]Damage Location의 정보를 삭제 합니다. <br>
	 *
	 * @param List<CustomMnrEqLocCdVO> customMnrEqLocCdVOs
	 * @exception DAOException
	 */
	public void removeDamageLocationCodeData(List<CustomMnrEqLocCdVO> customMnrEqLocCdVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customMnrEqLocCdVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CEDEXCodeMgtDBDAOremoveDamageLocationCodeDataDSQL(), customMnrEqLocCdVOs,null);
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
	
	/**
	 * [EES_MNR_0003]Damage Location의 정보를 수정 합니다. <br>
	 *
	 * @param List<CustomMnrEqLocCdVO> customMnrEqLocCdVOs
	 * @exception DAOException
	 */
	public void modifyDamageLocationCodeData(List<CustomMnrEqLocCdVO> customMnrEqLocCdVOs) throws DAOException,Exception {
		try { 
			SQLExecuter sqlExe = new SQLExecuter("");  
			int updCnt[] = null;  
			if(customMnrEqLocCdVOs.size() > 0){        
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CEDEXCodeMgtDBDAOmodifyDamageLocationCodeDataUSQL(), customMnrEqLocCdVOs,null);
				    
				for(int i = 0; i < updCnt.length; i++){  
					if(updCnt[i]== Statement.EXECUTE_FAILED)     
						throw new DAOException("Fail to insert No"+ i + " SQL"); 
				}         
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage()); 
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_MNR_0002]EQ Component의 정보를 조회 합니다. <br>
	 *
	 * @param ComponentCodeListINVO componentCodeListINVO
	 * @return List<CustomMnrEqCmpoCdVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrEqCmpoCdVO> searchComponentCodeListData(ComponentCodeListINVO componentCodeListINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrEqCmpoCdVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(componentCodeListINVO != null){
				if (componentCodeListINVO.getFType() != null && componentCodeListINVO.getFType().trim().length() > 0) {
				     param.put("eq_cmpo_grp_tp_cd", componentCodeListINVO.getEqCmpoGrpTpCd());    
				     velParam.put("eq_cmpo_grp_tp_cd", componentCodeListINVO.getEqCmpoGrpTpCd());
				     param.put("key_value", componentCodeListINVO.getKeyValue());    
				     velParam.put("key_value", componentCodeListINVO.getKeyValue());
				} 
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CEDEXCodeMgtDBDAOsearchComponentCodeListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrEqCmpoCdVO .class);
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
	  * [EES_MNR_0002]EQ Component의 정보를 추가 합니다. <br>
	  *
	  * @param List<CustomMnrEqCmpoCdVO> customMnrEqCmpoCdVOs
	  * @exception DAOException
	  */
	public void addComponentCodeData(List<CustomMnrEqCmpoCdVO> customMnrEqCmpoCdVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrEqCmpoCdVOs.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CEDEXCodeMgtDBDAOaddComponentCodeDataCSQL(), customMnrEqCmpoCdVOs,null);
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
	 * [EES_MNR_0002]EQ Component의 정보를 수정 합니다. <br>
	 *
	 * @param List<CustomMnrEqCmpoCdVO> customMnrEqCmpoCdVOs
	 * @exception DAOException
	 */
	public void modifyComponentCodeData(List<CustomMnrEqCmpoCdVO> customMnrEqCmpoCdVOs) throws DAOException,Exception {
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customMnrEqCmpoCdVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CEDEXCodeMgtDBDAOmodifyComponentCodeDataUSQL(), customMnrEqCmpoCdVOs,null);
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
	 * [EES_MNR_0002]EQ Component의 정보를 삭제 합니다. <br>
	 *
	 * @param List<CustomMnrEqCmpoCdVO> customMnrEqCmpoCdVOs
	 * @exception DAOException
	 */
	public void removeComponentCodeData(List<CustomMnrEqCmpoCdVO> customMnrEqCmpoCdVOs) throws DAOException,Exception {
		
		try {
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customMnrEqCmpoCdVOs.size() > 0){
				velParam.put("eq_cmpo_grp_tp_cd", customMnrEqCmpoCdVOs.get(0).getEqCmpoGrpTpCd());
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CEDEXCodeMgtDBDAOremoveComponentCodeDataDSQL(), customMnrEqCmpoCdVOs,velParam);
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
	
	/**
	 * [EES_MNR_0004]Damage Type의 정보를 조회 합니다. <br>
	 *
	 * @param CedexOtherCodeListINVO cedexOtherCodeListINVO
	 * @return List<CustomMnrCedexOtrCdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrCedexOtrCdVO> searchCedexOtherCodeListData(CedexOtherCodeListINVO cedexOtherCodeListINVO) throws DAOException {
		DBRowSet dbRowset = null; 
		List<CustomMnrCedexOtrCdVO> list = null;  
		//query parameter      
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{        
			if(cedexOtherCodeListINVO != null){    
				if (cedexOtherCodeListINVO.getEqCedexOtrTpCd() != null && cedexOtherCodeListINVO.getEqCedexOtrCd().trim().length() > 0) {
					param.put("eq_cedex_otr_tp_cd", cedexOtherCodeListINVO.getEqCedexOtrTpCd());                     
					param.put("eq_cedex_otr_cd", cedexOtherCodeListINVO.getEqCedexOtrCd());                       
					velParam.put("eq_cedex_otr_tp_cd", cedexOtherCodeListINVO.getEqCedexOtrTpCd());        
					velParam.put("eq_cedex_otr_cd", cedexOtherCodeListINVO.getEqCedexOtrCd());           
				}                                
			}                 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CEDEXCodeMgtDBDAOsearchCedexOtherCodeListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrCedexOtrCdVO .class);
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
	 * [EES_MNR_0004]Damage Type의 정보를 추가 합니다. <br>
	 *
	 * @param List<CustomMnrCedexOtrCdVO> customMnrCedexOtrCdVOs
	 * @exception DAOException
	 */
	public void addCedexOtherCodeListData(List<CustomMnrCedexOtrCdVO> customMnrCedexOtrCdVOs) throws DAOException,Exception {
		try {  
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrCedexOtrCdVOs.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CEDEXCodeMgtDBDAOaddCedexOtherCodeListDataCSQL(), customMnrCedexOtrCdVOs,null);
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
	 * [EES_MNR_0004]Damage Type의 정보를 삭제 합니다. <br>
	 *
	 * @param List<CustomMnrCedexOtrCdVO> customMnrCedexOtrCdVOs
	 * @exception DAOException
	 */
	public void removeCedexOtherCodeListData(List<CustomMnrCedexOtrCdVO> customMnrCedexOtrCdVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customMnrCedexOtrCdVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new CEDEXCodeMgtDBDAOremoveCedexOtherCodeListDataDSQL(), customMnrCedexOtrCdVOs,null);
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
        
	/**
	 * [EES_MNR_0004]Damage Type의 정보를 수정 합니다. <br>
	 *
	 * @param List<CustomMnrCedexOtrCdVO> customMnrCedexOtrCdVOs
	 * @exception DAOException
	 */ 
	public void modifyCedexOtherCodeListData(List<CustomMnrCedexOtrCdVO> customMnrCedexOtrCdVOs) throws DAOException,Exception {
		try {  
			SQLExecuter sqlExe = new SQLExecuter("");  
			int updCnt[] = null;  
			if(customMnrCedexOtrCdVOs.size() > 0){        
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CEDEXCodeMgtDBDAOmodifyCedexOtherCodeListDataUSQL(), customMnrCedexOtrCdVOs,null);
				    
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
	 * [EES_MNR_0145]EQ Component Grouping by Location & Damage Type의 정보를 조회 합니다. <br>
	 *
	 * @param CodeRelationINVO codeRelationINVO
	 * @return List<CustomMnrCdRltByLocVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrCdRltByLocVO> searchCodeRelationByLocationData(CodeRelationINVO codeRelationINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrCdRltByLocVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(codeRelationINVO != null){
			     param.put("eq_cmpo_cd", codeRelationINVO.getEqCmpoCd());    
			     velParam.put("eq_cmpo_cd", codeRelationINVO.getEqCmpoCd());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CEDEXCodeMgtDBDAOsearchCodeRelationByLocationDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrCdRltByLocVO .class);
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
	  * [EES_MNR_0145]EQ Component Grouping by Location & Damage Type의 정보를 조회 합니다. <br>
	  *
	  * @param CodeRelationINVO codeRelationINVO
	  * @return List<CustomMnrCdRltByDmgVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrCdRltByDmgVO> searchCodeRelationByDamageData(CodeRelationINVO codeRelationINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrCdRltByDmgVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(codeRelationINVO != null){
			     param.put("eq_cmpo_cd", codeRelationINVO.getEqCmpoCd());    
			     velParam.put("eq_cmpo_cd", codeRelationINVO.getEqCmpoCd());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CEDEXCodeMgtDBDAOsearchCodeRelationByDamageDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrCdRltByDmgVO .class);
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
	  * [EES_MNR_0145]EQ Component Grouping by Repair Type의 정보를 조회 합니다. <br>
	  *
	  * @param CodeRelationINVO codeRelationINVO
	  * @return List<CustomMnrCdRltByDmgVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrCdRltByRprVO> searchCodeRelationByReapirData(CodeRelationINVO codeRelationINVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<CustomMnrCdRltByRprVO> list = null;
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 //
		 try{
			 if(codeRelationINVO != null){
				 param.put("eq_cmpo_cd", codeRelationINVO.getEqCmpoCd());    
				 velParam.put("eq_cmpo_cd", codeRelationINVO.getEqCmpoCd());
			 }			
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CEDEXCodeMgtDBDAOsearchCodeRelationByReapirDataRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrCdRltByDmgVO .class);
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
	  * [EES_MNR_0145]EQ Component Grouping by Location & Damage Type의 정보를 삭제 합니다. <br>
	  *
	  * @param List<CustomMnrCdRltByLocVO> customMnrCdRltByLocVOs
	  * @exception DAOException
	  */
		public void removeCodeRelationData(List<CustomMnrCdRltByLocVO> customMnrCdRltByLocVOs) throws DAOException,Exception {
			
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int delCnt[] = null;
				if(customMnrCdRltByLocVOs.size() > 0){
					delCnt = sqlExe.executeBatch((ISQLTemplate)new CEDEXCodeMgtDBDAOremoveCodeRelationDataDSQL(), customMnrCdRltByLocVOs, null);
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

		/**
		 * [EES_MNR_0145]EQ Component Grouping by Location & Damage Type의 정보를 추가 합니다. <br>
		 *
		 * @param List<CustomMnrCdRltByLocVO> customMnrCdRltByLocVOs
		 * @exception DAOException
		 */
		public void addCodeRelationData(List<CustomMnrCdRltByLocVO> customMnrCdRltByLocVOs) throws DAOException,Exception {
			try {
				SQLExecuter sqlExe = new SQLExecuter("");
				int insCnt[] = null;
				if(customMnrCdRltByLocVOs.size() > 0){ 
					insCnt = sqlExe.executeBatch((ISQLTemplate)new CEDEXCodeMgtDBDAOaddCodeRelationDataCSQL(), customMnrCdRltByLocVOs,null);
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
}
