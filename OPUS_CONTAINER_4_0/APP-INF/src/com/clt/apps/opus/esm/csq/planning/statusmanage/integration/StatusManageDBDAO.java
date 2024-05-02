/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : StatusManageDBDAO.java
*@FileTitle      : StatusManageDBDAO
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.31
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.31 CSQ USER
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.csq.planning.statusmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.apps.opus.esm.csq.planning.statusmanage.basic.StatusManageBCImpl;
import com.clt.apps.opus.esm.csq.planning.statusmanage.vo.SearchQtaEstablishingStatusListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.CsqQtaStepVerVO;

/**
 * ALPS StatusManageDBDAO <br>
 * - ALPS-StatusManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author CSQ USER
 * @see StatusManageBCImpl 참조
 * @since J2EE 1.6
 */
public class StatusManageDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ESM_CSQ_0036 : [이벤트]<br>
	 * [QTA Establishing Status]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaEstablishingStatusListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatusManageDBDAOSearchQtaEstablishingStatusListRSQL(), param, velParam);
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
	 * ESM_CSQ_0036 : MULTI 이벤트 처리<br>
	 * [QTA Establishing Status]을 [Cancel Confirm] 합니다.<br>
	 * 
	 * @param List<CsqQtaStepVerVO> updModels
	 * @throws DAOException
	 */
	public void updateQtaStepVer(List<CsqQtaStepVerVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
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
	 * ESM_CSQ_0036 : MULTI 이벤트 처리<br>
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
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
	 * ESM_CSQ_0036 : MULTI01 이벤트 처리<br>
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateQtaLodRevCSQL(), param, velParam);
			
			if ( result == Statement.EXECUTE_FAILED )
				throw new DAOException("Fail to insert SQL");
			if ( result == 0 )
				throw new EventException(new ErrorHandler("CSQ00003").getMessage());
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_CSQ_0036 : MULTI02 이벤트 처리<br>
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateQtaPotnMgmtHoCSQL(), param, velParam);
			
			if ( result == Statement.EXECUTE_FAILED )
				throw new DAOException("Fail to insert SQL");
			if ( result == 0 )
				throw new EventException(new ErrorHandler("CSQ00003").getMessage());
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ESM_CSQ_0036 : MULTI03 이벤트 처리<br>
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateQtaPotnMgmtRhqCSQL(), param, velParam);
			
			if ( result == Statement.EXECUTE_FAILED )
				throw new DAOException("Fail to insert SQL");
			if ( result == 0 )
				throw new EventException(new ErrorHandler("CSQ00003").getMessage());
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 *  ESM_CSQ_0036 : SEARCH 이벤트 처리<br>
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
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new StatusManageDBDAOSearchQtaStepCntRSQL(), param, velParam);
			
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
	 * ESM_CSQ_0036 : MULTI04 이벤트 처리<br>
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
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
	 * ESM_CSQ_0036 : MULTI04 이벤트 처리<br>
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
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
	 * ESM_CSQ_0036 : MULTI04 이벤트 처리<br>
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
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
	 * ESM_CSQ_0036 : MULTI04 이벤트 처리<br>
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
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
	 * ESM_CSQ_0036 : MULTI05 이벤트 처리<br>
	 * [QTA Establishing Status]을 [연간으로 1Q 생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @throws DAOException
	 */
	public void createTransferCsqDatRlt(ConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateTransferCsqDatRltCSQL(), param, velParam);
			
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
	 * ESM_CSQ_0036 : MULTI05 이벤트 처리<br>
	 * [QTA Establishing Status]을 [연간으로 1Q 생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @throws DAOException
	 */
	public void createTransferCsqDirConv(ConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateTransferCsqDirConvCSQL(), param, velParam);
			
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
	 * ESM_CSQ_0036 : MULTI05 이벤트 처리<br>
	 * [QTA Establishing Status]을 [연간으로 1Q 생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @throws DAOException
	 */
	public void createTransferCsqQtaTgtVvd(ConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateTransferCsqQtaTgtVvdCSQL(), param, velParam);
			
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
	 * ESM_CSQ_0036 : MULTI05 이벤트 처리<br>
	 * [QTA Establishing Status]을 [연간으로 1Q 생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @throws DAOException
	 */
	public void createTransferCsqQtaLaneOfc(ConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateTransferCsqQtaLaneOfcCSQL(), param, velParam);
			
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
	 * ESM_CSQ_0036 : MULTI05 이벤트 처리<br>
	 * [QTA Establishing Status]을 [연간으로 1Q 생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @throws DAOException
	 */
	public void createTransferCsqQtaLaneOfcCost(ConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateTransferCsqQtaLaneOfcCostCSQL(), param, velParam);
			
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
	 * ESM_CSQ_0036 : MULTI05 이벤트 처리<br>
	 * [QTA Establishing Status]을 [연간으로 1Q 생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @throws DAOException
	 */
	public void createTransferCsqQtaStepVer(ConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateTransferCsqQtaStepVerCSQL(), param, velParam);
			
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
	 * ESM_CSQ_0036 : MULTI05 이벤트 처리<br>
	 * [QTA Establishing Status]을 [연간으로 1Q 생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @throws DAOException
	 */
	public void createTransferCsqQtaLodRev(ConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateTransferCsqQtaLodRevCSQL(), param, velParam);
			
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
	 * ESM_CSQ_0036 : MULTI05 이벤트 처리<br>
	 * [QTA Establishing Status]을 [연간으로 1Q 생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @throws DAOException
	 */
	public void createTransferCsqQtaPotnMgmt(ConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new StatusManageDBDAOCreateTransferCsqQtaPotnMgmtCSQL(), param, velParam);
			
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
	
}