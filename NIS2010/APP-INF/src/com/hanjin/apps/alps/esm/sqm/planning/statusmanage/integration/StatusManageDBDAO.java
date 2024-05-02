/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : StatusManageDBDAO.java
*@FileTitle      : StatusManageDBDAO
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.31
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.31 SQM USER
* 1.0 Creation
* 2015.05.15 이혜민 [CHM-201535608] Freezing전 RHQ별 Portion 존재하고, Office portion이 없는 List 조회.
* 2016.03.21 최성민 [CHM-201640188] 연간 QTA 수립 시 1Q Transfer 관련 로직 수정
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.planning.statusmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.planning.statusmanage.basic.StatusManageBCImpl;
import com.hanjin.apps.alps.esm.sqm.planning.statusmanage.vo.SearchQtaEstablishingStatusListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.SqmQtaStepVerVO;

/**
 * ALPS StatusManageDBDAO <br>
 * - ALPS-StatusManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SQM USER
 * @see StatusManageBCImpl 참조
 * @since J2EE 1.6
 */
public class StatusManageDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ESM_SQM_0028 : [이벤트]<br>
	 * [QTA Establishing Status]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaEstablishingStatusListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchQtaEstablishingStatusListVO> searchQtaEstablishingStatusList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchQtaEstablishingStatusListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new StatusManageDBDAOSearchQtaEstablishingStatusListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchQtaEstablishingStatusListVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * ESM_SQM_0028 : MULTI 이벤트 처리<br>
	 * [QTA Establishing Status]을 [Cancel Confirm] 합니다.<br>
	 * 
	 * @param List<SqmQtaStepVerVO> updModels
	 * @throws DAOException
	 */
	public void updateQtaStepVer(List<SqmQtaStepVerVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new StatusManageDBDAOUpdateQtaStepVerUSQL(), updModels, null);
				
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SQM_0028 : MULTI 이벤트 처리<br>
	 * [QTA Establishing Status]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @param String step
	 * @throws DAOException
	 */
	public void createQtaStepVer(ConditionVO conditionVO, String usrId, String step) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			param.put("f_qta_step_cd", step);
			param.put("f_usr_id", usrId);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateQtaStepVerCSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
     * ESM_SQM_0028 : MULTI 이벤트 처리<br>
     * [QTA Establishing Status]을 [제거] 합니다.<br>
     * 
     * @param ConditionVO conditionVO
     * @param String usrId
     * @param String step
     * @throws DAOException
     */
    public void removeQtaStepVer(ConditionVO conditionVO, String usrId, String step) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            Map<String, String> mapVO = conditionVO.getColumnValues();
            
            param.putAll(mapVO);
            param.put("f_qta_step_cd", step);
            param.put("f_usr_id", usrId);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
            
            int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAORemoveQtaStepVerDSQL(), param, velParam);
            
            if(result == Statement.EXECUTE_FAILED)
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
	 * ESM_SQM_0028 : MULTI01 이벤트 처리<br>
	 * [QTA Establishing Status]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @param String step
	 * @throws DAOException
	 */
	public void createQtaLodRev(ConditionVO conditionVO, String usrId, String step) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			param.put("f_qta_step_cd", step);
			param.put("f_usr_id", usrId);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateQtaLodRevCSQL(), param, velParam);
			
			if ( result == Statement.EXECUTE_FAILED )
				throw new DAOException("Fail to insert SQL");
			if ( result == 0 )
				throw new EventException(new ErrorHandler("SQM00003").getMessage());
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
     * ESM_SQM_0028 : MULTI01 이벤트 처리<br>
     * [QTA Establishing Status]을 [제거] 합니다.<br>
     * 
     * @param ConditionVO conditionVO
     * @param String usrId
     * @param String step
     * @throws DAOException
     */
    public void removeQtaLodRev(ConditionVO conditionVO, String usrId, String step) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            Map<String, String> mapVO = conditionVO.getColumnValues();
            
            param.putAll(mapVO);
            param.put("f_qta_step_cd", step);
            param.put("f_usr_id", usrId);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
            
            int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAORemoveQtaLodRevDSQL(), param, velParam);
            
            if ( result == Statement.EXECUTE_FAILED )
                throw new DAOException("Fail to insert SQL");
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
	
	/**
	 * ESM_SQM_0028 : MULTI02 이벤트 처리<br>
	 * [QTA Establishing Status]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @param String step
	 * @throws DAOException
	 */
	public void createQtaPotnMgmtHo(ConditionVO conditionVO, String usrId, String step) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			param.put("f_qta_step_cd", step);
			param.put("f_usr_id", usrId);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateQtaPotnMgmtHoCSQL(), param, velParam);
			
			if ( result == Statement.EXECUTE_FAILED )
				throw new DAOException("Fail to insert SQL");
			if ( result == 0 )
				throw new EventException(new ErrorHandler("SQM00003").getMessage());
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SQM_0028 : MULTI03 이벤트 처리<br>
	 * [QTA Establishing Status]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @param String step
	 * @throws DAOException
	 */
	public void createQtaPotnMgmtRhq(ConditionVO conditionVO, String usrId, String step) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			param.put("f_qta_step_cd", step);
			param.put("f_usr_id", usrId);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateQtaPotnMgmtRhqCSQL(), param, velParam);
			
			if ( result == Statement.EXECUTE_FAILED )
				throw new DAOException("Fail to insert SQL");
			if ( result == 0 )
				throw new EventException(new ErrorHandler("SQM00003").getMessage());
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
     * ESM_SQM_0028 : MULTI02~03 이벤트 처리<br>
     * [QTA Establishing Status]을 [제거] 합니다.<br>
     * 
     * @param ConditionVO conditionVO
     * @param String usrId
     * @param String step
     * @throws DAOException
     */
    public void removeQtaPotnMgmt(ConditionVO conditionVO, String usrId, String step) throws DAOException,Exception {
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        try {
            Map<String, String> mapVO = conditionVO.getColumnValues();
            
            param.putAll(mapVO);
            param.put("f_qta_step_cd", step);
            param.put("f_usr_id", usrId);
            velParam.putAll(mapVO);
            
            SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
            
            int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAORemoveQtaPotnMgmtDSQL(), param, velParam);
            
            if ( result == Statement.EXECUTE_FAILED )
                throw new DAOException("Fail to insert SQL");
        } catch(SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch(Exception ex) {
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage());
        }
    }
	
	/**
	 *  ESM_SQM_0028 : SEARCH 이벤트 처리<br>
	 * [QTA Establishing Status]을 [Step 별 Count 를 확인] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchQtaStepCnt(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		String cnt = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new StatusManageDBDAOSearchQtaStepCntRSQL(), param, velParam);
			
			if(dbRowset != null){
				if(dbRowset.next()){
					cnt =       dbRowset.getString("STEP_01_CNT")
					    + "|" + dbRowset.getString("STEP_02_CNT")
					    + "|" + dbRowset.getString("STEP_03_CNT")
					    + "|" + dbRowset.getString("CONFIRM_FLG")
					    + "|" + dbRowset.getString("RLSE_FLG")
					    + "|" + dbRowset.getString("TRANSFER");
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
	 * ESM_SQM_0028 : MULTI04 이벤트 처리<br>
	 * [QTA Establishing Status]을 [생성] 합니다.<br>
	 * RHQ에는 Portion을 부여했으나 해당 RHQ 산하의 Office에게 Portion을 부여하지 않은경우 체크
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<String> 
	 * @throws DAOException
	 */
	public List<String> searchOfcZeroPortion(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> OfcZeroPortion = new ArrayList<String>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new StatusManageDBDAOSearchOfcZeroPortionRSQL(), param, velParam);
			if(dbRowset != null){
				while(dbRowset.next()){
					OfcZeroPortion.add(dbRowset.getString(1));
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return OfcZeroPortion;
	}
	
	/**
	 * ESM_SQM_0028 : MULTI04 이벤트 처리<br>
	 * [QTA Establishing Status]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @throws DAOException
	 */
	public void createQtaRlseVer(ConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateQtaRlseVerCSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SQM_0028 : MULTI04 이벤트 처리<br>
	 * [QTA Establishing Status]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @throws DAOException
	 */
	public void createCfmTgtVvd(ConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateCfmTgtVvdCSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SQM_0028 : MULTI04 이벤트 처리<br>
	 * [QTA Establishing Status]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @throws DAOException
	 */
	public void createCfmQta(ConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateCfmQtaCSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SQM_0028 : MULTI04 이벤트 처리<br>
	 * [QTA Establishing Status]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @throws DAOException
	 */
	public void updateCfmQtaAqCd(ConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOUpdateCfmQtaAqCdUSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SQM_0028 : MULTI04 이벤트 처리<br>
	 * [QTA Establishing Status]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @throws DAOException
	 */
	public void createCfmQtaRbcco(ConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateCfmQtaRbccoCSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SQM_0028 : MULTI05 이벤트 처리<br>
	 * [QTA Establishing Status]을 [연간으로 1Q 생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @throws DAOException
	 */
	public void createTransferSqmDatRlt(ConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateTransferSqmDatRltCSQL(), param, velParam);
			
			if(result == 0)
				throw new EventException(new ErrorHandler("COM12213", new String[]{"Basic Data Relation Setting data"}).getMessage());

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("COM12213").getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SQM_0028 : MULTI05 이벤트 처리<br>
	 * [QTA Establishing Status]을 [연간으로 1Q 생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @throws DAOException
	 */
	public void createTransferSqmDirConv(ConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateTransferSqmDirConvCSQL(), param, velParam);

			if(result == 0)
				throw new EventException(new ErrorHandler("COM12213", new String[]{"Lane Direction Change"}).getMessage());

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("COM12213").getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SQM_0028 : MULTI05 이벤트 처리<br>
	 * [QTA Establishing Status]을 [연간으로 1Q 생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @throws DAOException
	 */
	public void createTransferSqmQtaTgtVvd(ConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateTransferSqmQtaTgtVvdCSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SQM_0028 : MULTI05 이벤트 처리<br>
	 * [QTA Establishing Status]을 [연간으로 1Q 생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @throws DAOException
	 */
	public void createTransferSqmQtaLaneOfc(ConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateTransferSqmQtaLaneOfcCSQL(), param, velParam);

			if(result == 0)
				throw new EventException(new ErrorHandler("COM12213", new String[]{"Lane Office Relation Setting"}).getMessage());

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("COM12213").getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SQM_0028 : MULTI05 이벤트 처리<br>
	 * [QTA Establishing Status]을 [연간으로 1Q 생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @throws DAOException
	 */
	public void createTransferSqmQtaRbc(ConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateTransferSqmQtaRbcCSQL(), param, velParam);
			
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SQM_0028 : MULTI05 이벤트 처리<br>
	 * [QTA Establishing Status]을 [연간으로 1Q 생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @throws DAOException
	 */
	public void createTransferSqmQtaLaneOfcCost(ConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateTransferSqmQtaLaneOfcCostCSQL(), param, velParam);

			if(result == 0)
				throw new EventException(new ErrorHandler("COM12213", new String[]{"Basic CMCB (CM Cost Per Box)"}).getMessage());

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("COM12213").getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SQM_0028 : MULTI05 이벤트 처리<br>
	 * [QTA Establishing Status]을 [연간으로 1Q 생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @throws DAOException
	 */
	public void createTransferSqmQtaStepVer(ConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateTransferSqmQtaStepVerCSQL(), param, velParam);

			if(result == 0)
				throw new EventException(new ErrorHandler("COM12213", new String[]{"QTA Establishing Status Management"}).getMessage());

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("COM12213").getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SQM_0028 : MULTI05 이벤트 처리<br>
	 * [QTA Establishing Status]을 [연간으로 1Q 생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @throws DAOException
	 */
	public void createTransferSqmQtaLodRev(ConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateTransferSqmQtaLodRevCSQL(), param, velParam);

			if(result == 0)
				throw new EventException(new ErrorHandler("COM12213", new String[]{"QTA Set up by Head Office QTA Set up by Head Office (L/F & G.RPB)"}).getMessage());

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("COM12213").getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_SQM_0028 : MULTI05 이벤트 처리<br>
	 * [QTA Establishing Status]을 [연간으로 1Q 생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @throws DAOException
	 */
	public void createTransferSqmQtaPotnMgmt(ConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateTransferSqmQtaPotnMgmtCSQL(), param, velParam);

			if(result == 0)
				throw new EventException(new ErrorHandler("COM12213", new String[]{"QTA Set up (by HO, by RHQ_OB Loading, by RHQ_NON OB Contract, by RHQ_OB Contract)"}).getMessage());

		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler("COM12213").getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
}