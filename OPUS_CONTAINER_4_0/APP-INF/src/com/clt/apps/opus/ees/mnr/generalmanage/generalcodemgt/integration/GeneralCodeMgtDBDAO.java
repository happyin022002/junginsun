/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralCodeMgtDBDAO.java
*@FileTitle : EQ Component
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.04.27 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.generalmanage.generalcodemgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.mnr.generalmanage.generalcodemgt.basic.GeneralCodeMgtBCImpl;
import com.clt.apps.opus.ees.mnr.generalmanage.generalcodemgt.vo.CustomMnrGenCdVO;
import com.clt.apps.opus.ees.mnr.generalmanage.generalcodemgt.vo.GeneralCodeMgtINVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration.EQFlagMgtDBDAOsearchEqStsRmkDataRSQL;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrFlgHisVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
   
/** 
 * COM GeneralCodeMgtDBDAO <br>
 * - COM-GeneralManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author pms
 * @see GeneralCodeMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class GeneralCodeMgtDBDAO extends DBDAOSupport {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * [EES_MNR_0009]M&R Other Code의 정보를 조회 합니다. <br>
	 *
	 * @param GeneralCodeMgtINVO generalCodeMgtINVO
	 * @return List<CustomMnrGenCdVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<CustomMnrGenCdVO> searchGeneralCodeListData(GeneralCodeMgtINVO generalCodeMgtINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGenCdVO> list = null;

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(generalCodeMgtINVO != null){
				if (generalCodeMgtINVO.getMnrCdGrpNo() != null && generalCodeMgtINVO.getMnrCdGrpNo().trim().length() > 0) {
				     param.put("mnr_cd_grp_no", generalCodeMgtINVO.getMnrCdGrpNo());    
				     velParam.put("mnr_cd_grp_no", generalCodeMgtINVO.getMnrCdGrpNo());
				     param.put("mnr_cd_id", generalCodeMgtINVO.getMnrCdId());    
				     velParam.put("mnr_cd_id", generalCodeMgtINVO.getMnrCdId());
				} 
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeMgtDBDAOsearchGeneralCodeListDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGenCdVO .class);
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
	 * [EES_MNR_0009]M&R Other Code의 정보를 조회 합니다. <br>
	 *
	 * @param GeneralCodeMgtINVO generalCodeMgtINVO
	 * @return List<CustomMnrGenCdVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGenCdVO> searchGeneralCodeData(GeneralCodeMgtINVO generalCodeMgtINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGenCdVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (generalCodeMgtINVO != null) {
				if (generalCodeMgtINVO.getMnrCdGrpNo() != null&& generalCodeMgtINVO.getMnrCdGrpNo().trim().length() > 0) {
					param.put("mnr_cd_grp_no",generalCodeMgtINVO.getMnrCdGrpNo());
					velParam.put("mnr_cd_grp_no",generalCodeMgtINVO.getMnrCdGrpNo());
					param.put("mnr_cd_id", generalCodeMgtINVO.getMnrCdId());
					velParam.put("mnr_cd_id", generalCodeMgtINVO.getMnrCdId());
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeMgtDBDAOsearchGeneralCodeDataRSQL(),param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGenCdVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

 /**
  * [EES_MNR_0009]M&R Other Code의 정보를 추가 합니다. <br>
  *
  * @param List<CustomMnrGenCdVO> customMnrGenCdVOs
  * @exception DAOException
  */
	public void addGeneralCodeData(List<CustomMnrGenCdVO> customMnrGenCdVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(customMnrGenCdVOs.size() > 0){ 
				insCnt = sqlExe.executeBatch((ISQLTemplate)new GeneralCodeMgtDBDAOaddGeneralCodeDataCSQL(), customMnrGenCdVOs,null);
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
	 * [EES_MNR_0009]M&R Other Code의 정보를 수정 합니다. <br>
	 *
	 * @param List<CustomMnrGenCdVO> customMnrGenCdVOs
	 * @exception DAOException
	 */
	public void modifyGeneralCodeData(List<CustomMnrGenCdVO> customMnrGenCdVOs) throws DAOException,Exception {
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(customMnrGenCdVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new GeneralCodeMgtDBDAOmodifyGeneralCodeDataUSQL(), customMnrGenCdVOs,null);
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
	 * [EES_MNR_0009]M&R Other Code의 정보를 삭제 합니다. <br>
	 *
	 * @param List<CustomMnrGenCdVO> customMnrGenCdVOs
	 * @exception DAOException
	 */
	public void removeGeneralCodeData(List<CustomMnrGenCdVO> customMnrGenCdVOs) throws DAOException,Exception {
		
		try {
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customMnrGenCdVOs.size() > 0){
				velParam.put("mnr_cd_grp_no", customMnrGenCdVOs.get(0).getMnrCdGrpNo());
				delCnt = sqlExe.executeBatch((ISQLTemplate)new GeneralCodeMgtDBDAOremoveGeneralCodeDataDSQL(), customMnrGenCdVOs,velParam);
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
	 * [EES_MNR_0009]M&R General Code의 정보를 수정 합니다. <br>
	 *
	 * @param List<CustomMnrGenCdVO> customMnrGenCdVOs
	 * @exception DAOException
	 */
	public void modifyIntgCdToMnrCdData(List<CustomMnrGenCdVO> customMnrGenCdVOs) throws DAOException,Exception {
		try {
			
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, Object> velParam = new HashMap<String, Object>();
			int updCnt[] = null;
			velParam.put("mnr_cd_grp_no", customMnrGenCdVOs.get(0).getMnrCdGrpNo());
			if(customMnrGenCdVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new GeneralCodeMgtDBDAOmodifyMnrCdDataUSQL(), customMnrGenCdVOs,velParam);
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
	 * [EES_MNR_0009]M&R General Code의 정보를 삭제 합니다. <br>
	 *
	 * @param List<CustomMnrGenCdVO> customMnrGenCdVOs
	 * @exception DAOException
	 */
	public void removeIntgCdToMnrCdData(List<CustomMnrGenCdVO> customMnrGenCdVOs) throws DAOException,Exception {
		
		try {
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(customMnrGenCdVOs.size() > 0){
				velParam.put("mnr_cd_grp_no", customMnrGenCdVOs.get(0).getMnrCdGrpNo());
				delCnt = sqlExe.executeBatch((ISQLTemplate)new GeneralCodeMgtDBDAOremoveIntgCdToMnrDataDSQL(), customMnrGenCdVOs,velParam);
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
	 * MNR_CD_DP_SEQ 검색 <br>
	 *
	 * @param String prntCdId
	 * @return String 
	 * @exception DAOException 
	 */
	 public String searchMnrCdSeqData(String prntCdId) throws DAOException {
		DBRowSet dbRowset = null;   
		String result = ""; 	
		//query parameter	
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter 
		Map<String, Object> velParam = new HashMap<String, Object>(); 
		try{ 	
			param.put("prnt_cd_id", prntCdId);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeMgtDBDAOsearchMnrCdSeqDataRSQL(), param, velParam);
			if (dbRowset.next()) {
				result = dbRowset.getString("MNR_CD_DP_SEQ");
			}
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
	 * Module 검색 <br>
	 *
	 * @param String intgCdId
	 * @return String
	 * @exception DAOException
	 */
	public String searchIntgCdModuleData(String intgCdId) throws DAOException {
		DBRowSet dbRowset = null;
		String result = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("intg_cd_id", intgCdId);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeMgtDBDAOsearchIntgDtlCdModuleDataRSQL(), param, velParam);
			if (dbRowset.next()) {
				result = dbRowset.getString("OWNR_SUB_SYS_CD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	 
	/**
	 * MNR_CODE 검색 <br>
	 *
	 * @param String intgCdId
	 * @return String
	 * @exception DAOException
	 */
	public String searchMnrCdData(String intgCdId) throws DAOException {
		DBRowSet dbRowset = null;
		String result = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("intg_cd_id", intgCdId);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeMgtDBDAOsearchMnrCdIdFmIntgCdDataRSQL(), param, velParam);
			if (dbRowset.next()) {
				result = dbRowset.getString("MNR_CD_ID");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
}
