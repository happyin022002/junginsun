/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : CostManageDBDAO.java
*@FileTitle      : CostManageDBDAO
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.31
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.31 CSQ USER
* 1.0 Creation
* 2014.07.03 PEJ [CHM-201430932] RHQ Office Mapping에 Office 추가시 Sector Office 반영 요청
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.costmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.basic.CostManageBCImpl;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.vo.SearchAddedNewLaneListVO;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.vo.SearchBasicCmcbCoaPfmcListListVO;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.vo.SearchBasicCmcbCoaUcPfmcVO;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.vo.SearchBasicCmcbListVO;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.vo.SearchNewLaneOfficeCmcbListVO;
import com.clt.apps.opus.esm.csq.datamanage.costmanage.vo.SearchNewLaneSecCmcbListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.CsqQtaLaneOfcCostVO;
import com.clt.syscommon.common.table.CsqQtaLaneOfcVO;
import com.clt.syscommon.common.table.CsqQtaNewLaneOfcCostVO;
import com.clt.syscommon.common.table.CsqQtaNewLaneVO;

/**
 * ALPS CostManageDBDAO <br>
 * - ALPS-CostManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author CSQ USER
 * @see CostManageBCImpl 참조
 * @since J2EE 1.6
 */
public class CostManageDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 추가된 Lane list를 조회한다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchAddedNewLaneListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchAddedNewLaneListVO> searchAddedNewLaneList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchAddedNewLaneListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostManageDBDAOSearchAddedNewLaneListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAddedNewLaneListVO .class);     
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
	 * 추가된 Lane list에 CMCB정보를 카피할 대상 rlane정보를 저장한다.
	 * 
	 * @param List<CsqQtaNewLaneVO> uptModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateAddedNewLane(List<CsqQtaNewLaneVO> uptModels) throws DAOException,Exception {
		int uptCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(uptModels.size() > 0){
				uptCnt = sqlExe.executeBatch((ISQLTemplate)new CostManageDBDAOUpdateAddedNewLaneUSQL(), uptModels,null);
				for(int i = 0; i < uptCnt.length; i++){
					if(uptCnt[i]== Statement.EXECUTE_FAILED)
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
	 * NewLane Offce에 CMCB정보를 생성한다.
	 * 
	 * @param List<CsqQtaNewLaneVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createNewLaneOfficeCmcb(List<CsqQtaNewLaneVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CostManageDBDAOCreateNewLaneOfficeCmcbCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * New Lane - Office의 Cmcb를 조회한다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchNewLaneOfficeCmcbListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchNewLaneOfficeCmcbListVO> searchNewLaneOfficeCmcbList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchNewLaneOfficeCmcbListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostManageDBDAOSearchNewLaneOfficeCmcbListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchNewLaneOfficeCmcbListVO .class);     
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
	 * New Lane - Office의 Cmcb를 업데이트한다.
	 * 
	 * @param List<CsqQtaNewLaneOfcCostVO> uptModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateNewLaneOfficeCmcb(List<CsqQtaNewLaneOfcCostVO> uptModels) throws DAOException,Exception {
		int uptCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(uptModels.size() > 0){
				uptCnt = sqlExe.executeBatch((ISQLTemplate)new CostManageDBDAOUpdateNewLaneOfficeCmcbUSQL(), uptModels,null);
				for(int i = 0; i < uptCnt.length; i++){
					if(uptCnt[i]== Statement.EXECUTE_FAILED)
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
	 * 추가된 Office에 대해서 Lane-Office정보를 생성한다.
	 * 
	 * @param List<CsqQtaLaneOfcVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createLaneOfficeForAddedOfc(List<CsqQtaLaneOfcVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CostManageDBDAOCreateLaneOfficeForAddedOfcCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * 추가된 Office에 대해서 CMCB정보를 생성한다.
	 * 
	 * @param List<CsqQtaLaneOfcVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createBasicCmcbForAddedOfc(List<CsqQtaLaneOfcVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CostManageDBDAOCreateBasicCmcbForAddedOfcCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * 추가된 Office에 대해서 Sector-Office정보를 생성한다.
	 * 
	 * @param List<CsqQtaLaneOfcVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createSectorLaneOfficeForAddedOfc(List<CsqQtaLaneOfcVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CostManageDBDAOCreationSectorLaneOfficeForAddedOfcCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * ESM_CSQ_0005 : MULTI 이벤트 처리
	 * 추가된 Office에 대해서 Portion MGMT정보를 생성한다.
	 * 
	 * @param List<CsqQtaLaneOfcVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createPotnMgmtForAddedOfc(List<CsqQtaLaneOfcVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CostManageDBDAOCreationPotnMgmtForAddedOfcCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * ESM_CSQ_0005 : MULTI 이벤트 처리
	 * 추가된 Office에 대해서 LOD REV 정보를 생성한다.
	 * 
	 * @param List<CsqQtaLaneOfcVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createLodRevForAddedOfc(List<CsqQtaLaneOfcVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CostManageDBDAOCreationLodRevForAddedOfcCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * ESM_CSQ_0013 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicCmcbListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchBasicCmcbListVO> searchBasicCmcbList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchBasicCmcbListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostManageDBDAOSearchBasicCmcbListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBasicCmcbListVO .class);
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
	 * ESM_CSQ_0013 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]의 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchBasicCmcbListCnt(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		String dataCnt = "0";
		
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostManageDBDAOSearchBasicCmcbListCntRSQL(), param, velParam);
			
			if(dbRowset != null){
				if(dbRowset.next()){
					dataCnt = dbRowset.getString(1);
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dataCnt;
	}
	
	/**
	 * ESM_CSQ_0013 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createBasicCmcb(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				param.put("f_usr_id", usrId);
			}
			
			int	insCnt = sqlExe.executeUpdate((ISQLTemplate)new CostManageDBDAOCreateBasicCmcbCSQL(), param, velParam);
			
			if (insCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			if (insCnt == 0)
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
	 * ESM_CSQ_0013 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]을 [수정] 합니다.<br><br>
	 * 
	 * @param List<CsqQtaLaneOfcCostVO> csqQtaLaneOfcCostVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateBasicCmcb(List<CsqQtaLaneOfcCostVO> csqQtaLaneOfcCostVOs) throws DAOException,Exception {
		int updCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(csqQtaLaneOfcCostVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CostManageDBDAOUpdateBasicCmcbUSQL(), csqQtaLaneOfcCostVOs, null);
				
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
	 * ESM_CSQ_0014 : [이벤트]<br>
	 * [Basic CMCB_New Lane Cost IF)]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<CsqQtaLaneOfcCostVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CsqQtaLaneOfcCostVO> searchBasicCmcbNewLaneCostIfList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CsqQtaLaneOfcCostVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostManageDBDAOSearchBasicCmcbNewLaneCostIfListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CsqQtaLaneOfcCostVO .class);
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
	 * ESM_CSQ_0014 : [이벤트]<br>
	 * [Basic CMCB_New Lane Cost IF)]을 [생성] 합니다.<br><br>
	 * 
	 * @param List<CsqQtaLaneOfcCostVO> csqQtaLaneOfcCostVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createBasicCmcbNewLaneCostIf(List<CsqQtaLaneOfcCostVO> csqQtaLaneOfcCostVOs) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(csqQtaLaneOfcCostVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CostManageDBDAOCreateBasicCmcbNewLaneCostIfCSQL(), csqQtaLaneOfcCostVOs, null);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * ESM_CSQ_0014 : [이벤트]<br>
	 * [Basic CMCB_New Lane Cost IF)]의 [평균단가]를 [생성] 합니다.<br><br>
	 * 
	 * @param List<CsqQtaLaneOfcCostVO> csqQtaLaneOfcCostVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createBasicCmcbNewLaneAvgCost(List<CsqQtaLaneOfcCostVO> csqQtaLaneOfcCostVOs) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(csqQtaLaneOfcCostVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CostManageDBDAOCreateBasicCmcbNewLaneAvgCostCSQL(), csqQtaLaneOfcCostVOs, null);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * ESM_CSQ_0014 : [이벤트]<br>
	 * [Basic CMCB_New Lane Cost IF)]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicCmcbCoaPfmcListListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchBasicCmcbCoaPfmcListListVO> searchBasicCmcbCoaPfmcList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchBasicCmcbCoaPfmcListListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostManageDBDAOSearchBasicCmcbCoaUcPfmcRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBasicCmcbCoaPfmcListListVO .class);
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
	 * Lane Office에 사전데이터가 있는지 확인.
	 * 
	 * @param CsqQtaLaneOfcVO csqQtaLaneOfcVO
	 * @param String tableNm
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchLaneOfficeForAddedOfcCnt(CsqQtaLaneOfcVO csqQtaLaneOfcVO, String tableNm) throws DAOException {
		DBRowSet dbRowset = null;
		String[] dataCnt = new String[2];
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(csqQtaLaneOfcVO != null){
				Map<String, String> mapVO = csqQtaLaneOfcVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("tableNm", tableNm);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostManageDBDAOSearchLaneOfficeForAddedOfcCntRSQL(), param, velParam);
			
			if(dbRowset != null){
				if(dbRowset.next()){
					dataCnt[0] = dbRowset.getString(1);
					dataCnt[1] = dbRowset.getString(2);
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dataCnt;
	}
	
	/**
	 * @param CsqQtaNewLaneVO csqQtaNewLaneVO
	 * @return String 
	 * @throws DAOException
	 */
	public String searchNewLaneOfficeCmcbCnt(CsqQtaNewLaneVO csqQtaNewLaneVO) throws DAOException {
		DBRowSet dbRowset = null;
		String dataCnt = "0";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(csqQtaNewLaneVO != null){
				Map<String, String> mapVO = csqQtaNewLaneVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostManageDBDAOSearchNewLaneOfficeCmcbCntRSQL(), param, velParam);
			
			if(dbRowset != null){
				if(dbRowset.next()){
					dataCnt = dbRowset.getString(1);
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dataCnt;
	}
	
	/**
	 *  ESM_CSQ_0005 : MULTI 이벤트 처리<br>
	 * Freezing 되기 전이면서 Portion 데이터는 존재하는지 확인
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @throws DAOException
	 */
	public String[] searchPotnMgmtForAddedOfcCnt(CsqQtaLaneOfcVO csqQtaLaneOfcVO) throws DAOException {
		DBRowSet dbRowset = null;
		String[] dataCnt = new String[2];
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(csqQtaLaneOfcVO != null){
				Map<String, String> mapVO = csqQtaLaneOfcVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostManageDBDAOSearchPotnMgmtForAddedOfcCntRSQL(), param, velParam);
			
			if(dbRowset != null){
				if(dbRowset.next()){
					dataCnt[0] = dbRowset.getString(1);
					dataCnt[1] = dbRowset.getString(2);
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dataCnt;
	}
	
	/**
	 *  ESM_CSQ_0005 : MULTI 이벤트 처리<br>
	 * Sector쪽 Planning 데이터는 존재하면서 Freezing 하기 전인지 확인
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @throws DAOException
	 */
	public String[] searchLodRevForAddedOfcCnt(CsqQtaLaneOfcVO csqQtaLaneOfcVO) throws DAOException {
		DBRowSet dbRowset = null;
		String[] dataCnt = new String[2];
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(csqQtaLaneOfcVO != null){
				Map<String, String> mapVO = csqQtaLaneOfcVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostManageDBDAOSearchLodRevForAddedOfcCntRSQL(), param, velParam);
			
			if(dbRowset != null){
				if(dbRowset.next()){
					dataCnt[0] = dbRowset.getString(1);
					dataCnt[1] = dbRowset.getString(2);
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dataCnt;
	}
	
	/**
	 * ESM_CSQ_0209 : Retrieve1<br>
	 * [New Lane Sector CMCB List]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchNewLaneSecCmcbListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchNewLaneSecCmcbListVO> searchNewLaneSecCmcbList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchNewLaneSecCmcbListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostManageDBDAOSearchNewLaneSecCmcbListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchNewLaneSecCmcbListVO .class);
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
	 * ESM_CSQ_0209 : Save1<br>
	 * [New Lane Sector CMCB List]을 [수정]합니다.<br>
	 * 
	 * @param List<SearchNewLaneSecCmcbListVO> uptModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateNewLaneSecCmcbNewLane(List<SearchNewLaneSecCmcbListVO> uptModels) throws DAOException,Exception {
		int uptCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(uptModels.size() > 0){
				uptCnt = sqlExe.executeBatch((ISQLTemplate)new CostManageDBDAOUpdateNewLaneSecCmcbNewLaneUSQL(), uptModels,null);
				for(int i = 0; i < uptCnt.length; i++){
					if(uptCnt[i]== Statement.EXECUTE_FAILED)
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
	 * ESM_CSQ_0209 : Creation<br>
	 * [New Lane Sector CMCB Pair Cost]을 [생성]합니다.<br>
	 * 
	 * @param List<SearchNewLaneSecCmcbListVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createNewLaneSecCmcbPairCost(List<SearchNewLaneSecCmcbListVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CostManageDBDAOCreateNewLaneSecCmcbPairCostCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * ESM_CSQ_0209 : Retrieve2<br>
	 * [New Lane Sector CMCB Pair Cost]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchNewLaneSecCmcbListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchNewLaneSecCmcbListVO> searchNewLaneSecCmcbPairCost(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchNewLaneSecCmcbListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostManageDBDAOSearchNewLaneSecCmcbPairCostRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchNewLaneSecCmcbListVO .class);
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
	 * ESM_CSQ_0209 : Save2<br>
	 * [New Lane Sector CMCB Pair Cost]을 [수정]합니다.<br>
	 * 
	 * @param List<SearchNewLaneSecCmcbListVO> uptModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateNewLaneSecCmcbPairCost(List<SearchNewLaneSecCmcbListVO> uptModels) throws DAOException,Exception {
		int uptCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(uptModels.size() > 0){
				uptCnt = sqlExe.executeBatch((ISQLTemplate)new CostManageDBDAOUpdateNewLaneSecCmcbPairCostUSQL(), uptModels,null);
				for(int i = 0; i < uptCnt.length; i++){
					if(uptCnt[i]== Statement.EXECUTE_FAILED)
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
	 * ESM_CSQ_0210 : [Retrieve]<br>
	 * [Basic CMCB for IAS Sector List]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchNewLaneSecCmcbListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchNewLaneSecCmcbListVO> searchBasicCmcbForIasSectorList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchNewLaneSecCmcbListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
               if (!JSPUtil.getNull(conditionVO.getFRlaneCd()).equals("") && !JSPUtil.getNull(conditionVO.getFRlaneCd()).equals("All")) {
            	   conditionVO.setFRlaneCd("'" + conditionVO.getFRlaneCd().replaceAll("," ,"','") +"'");
				}
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostManageDBDAOSearchBasicCmcbForIasSectorListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchNewLaneSecCmcbListVO .class);
			
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
	 * ESM_CSQ_0210 : [Retrieve]<br>
	 * [Basic CMCB for IAS Sector List]의 [COUNT] 를 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchBasicCmcbForIasSectorListCnt(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		String dataCnt = "0";
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostManageDBDAOSearchBasicCmcbForIasSectorListCntRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					dataCnt = dbRowset.getString("CNT");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dataCnt;
	}
	
	/**
	 * ESM_CSQ_0210 : Save<br>
	 * [Basic CMCB for IAS Sector List]을 [수정]합니다.<br>
	 * 
	 * @param List<SearchNewLaneSecCmcbListVO> uptModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateBasicCmcbForIasSectorList(List<SearchNewLaneSecCmcbListVO> uptModels) throws DAOException,Exception {
		int uptCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(uptModels.size() > 0){
				uptCnt = sqlExe.executeBatch((ISQLTemplate)new CostManageDBDAOUpdateBasicCmcbForIasSectorListUSQL(), uptModels,null);
				for(int i = 0; i < uptCnt.length; i++){
					if(uptCnt[i]== Statement.EXECUTE_FAILED)
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
	 * ESM_CSQ_0210 : Creation<br>
	 * [Basic CMCB for IAS Sector List]을 [생성]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createBasicCmcbForIasSector(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			param.put("usr_id", usrId);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CostManageDBDAOCreateBasicCmcbForIasSectorCSQL(), param, velParam);
			if(result == 0){							
				throw new EventException((String)new ErrorHandler("CSQ00003", new String[]{}).getMessage());
			}
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
	 * ESM_CSQ_0211 : Retrieve<br>
	 * [Basic CMCB for IAS Sector_New Lane Cost IF]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchNewLaneSecCmcbListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchNewLaneSecCmcbListVO> searchBasicCmcbForIasSecNewLaneIf(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchNewLaneSecCmcbListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostManageDBDAOSearchBasicCmcbForIasSecNewLaneIfRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchNewLaneSecCmcbListVO .class);
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
	 * ESM_CSQ_0211 : New Lane Cost Apply<br>
	 * [Basic CMCB for IAS Sector_New Lane Cost IF]을 [Apply]합니다.<br>
	 * 
	 * @param List<SearchNewLaneSecCmcbListVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addBasicCmcbForIasSecNewLaneIf(List<SearchNewLaneSecCmcbListVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CostManageDBDAOAddBasicCmcbForIasSecNewLaneIfCSQL(), insModels,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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
	 * ESM_CSQ_0212 : Retrieve<br>
	 * [Basic CMCB for IAS Sector_COA UC PFMC]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicCmcbCoaUcPfmcVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchBasicCmcbCoaUcPfmcVO> searchBasicCmcbCoaUcPfmc(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchBasicCmcbCoaUcPfmcVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CostManageDBDAOSearchBasicCmcbCoaUcPfmcSectorRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBasicCmcbCoaUcPfmcVO .class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}