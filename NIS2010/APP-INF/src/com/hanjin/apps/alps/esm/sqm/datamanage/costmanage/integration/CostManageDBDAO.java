/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : CostManageDBDAO.java
*@FileTitle      : CostManageDBDAO
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.31
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.31 SQM USER
* 1.0 Creation
* 2014.07.03 PEJ [CHM-201430932] RHQ Office Mapping에 Office 추가시 Sector Office 반영 요청
* 2016.02.12 CHM-201639850 CMCB 수정 데이터 Creation 버튼 생성 CSR
* 2016.08.11 Basic CMCB (CM Cost Per Box) 화면 Add Creation 버튼 추가
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.basic.CostManageBCImpl;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo.SearchAddedNewLaneListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo.SearchBasicCmcbListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo.SearchBasicCmcbMasPfmcListListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo.SearchBasicCmcbMasUcPfmcVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo.SearchNewLaneOfficeCmcbListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.costmanage.vo.SearchNewLaneSecCmcbListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.SqmQtaLaneOfcCostVO;
import com.hanjin.syscommon.common.table.SqmQtaLaneOfcVO;
import com.hanjin.syscommon.common.table.SqmQtaNewLaneOfcCostVO;
import com.hanjin.syscommon.common.table.SqmQtaNewLaneVO;

/**
 * ALPS CostManageDBDAO <br>
 * - ALPS-CostManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SQM USER
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CostManageDBDAOSearchAddedNewLaneListRSQL(), param, velParam);
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
	 * @param List<SqmQtaNewLaneVO> uptModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateAddedNewLane(List<SqmQtaNewLaneVO> uptModels) throws DAOException,Exception {
		int uptCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
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
	 * @param List<SqmQtaNewLaneVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createNewLaneOfficeCmcb(List<SqmQtaNewLaneVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CostManageDBDAOSearchNewLaneOfficeCmcbListRSQL(), param, velParam);
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
	 * @param List<SqmQtaNewLaneOfcCostVO> uptModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateNewLaneOfficeCmcb(List<SqmQtaNewLaneOfcCostVO> uptModels) throws DAOException,Exception {
		int uptCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
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
	 * @param List<SqmQtaLaneOfcVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createLaneOfficeForAddedOfc(List<SqmQtaLaneOfcVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
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
	 * @param List<SqmQtaLaneOfcVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createBasicCmcbForAddedOfc(List<SqmQtaLaneOfcVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
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
	 * @param List<SqmQtaLaneOfcVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createSectorLaneOfficeForAddedOfc(List<SqmQtaLaneOfcVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
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
	 * ESM_SQM_0011 : [이벤트]<br>
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CostManageDBDAOSearchBasicCmcbListRSQL(), param, velParam);
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
	 * ESM_SQM_0011 : [이벤트]<br>
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CostManageDBDAOSearchBasicCmcbListCntRSQL(), param, velParam);
			
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
	 * ESM_SQM_0011 : [이벤트]<br>
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
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
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
	 * ESM_SQM_0011 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]을 [수정] 합니다.<br><br>
	 * 
	 * @param List<SqmQtaLaneOfcCostVO> sqmQtaLaneOfcCostVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateBasicCmcb(List<SqmQtaLaneOfcCostVO> sqmQtaLaneOfcCostVOs) throws DAOException,Exception {
		int updCnt[] = null;
		int updCnt2[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(sqmQtaLaneOfcCostVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CostManageDBDAOUpdateBasicCmcbUSQL(), sqmQtaLaneOfcCostVOs, null);
				updCnt2 = sqlExe.executeBatch((ISQLTemplate)new CostManageDBDAOUpdateCmcbOfConfirmedDataUSQL(), sqmQtaLaneOfcCostVOs, null);
				
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
	 * ESM_SQM_0012 : [이벤트]<br>
	 * [Basic CMCB_New Lane Cost IF)]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SqmQtaLaneOfcCostVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SqmQtaLaneOfcCostVO> searchBasicCmcbNewLaneCostIfList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SqmQtaLaneOfcCostVO> list = null;
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CostManageDBDAOSearchBasicCmcbNewLaneCostIfListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SqmQtaLaneOfcCostVO .class);
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
	 * ESM_SQM_0012 : [이벤트]<br>
	 * [Basic CMCB_New Lane Cost IF)]을 [생성] 합니다.<br><br>
	 * 
	 * @param List<SqmQtaLaneOfcCostVO> sqmQtaLaneOfcCostVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createBasicCmcbNewLaneCostIf(List<SqmQtaLaneOfcCostVO> sqmQtaLaneOfcCostVOs) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(sqmQtaLaneOfcCostVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CostManageDBDAOCreateBasicCmcbNewLaneCostIfCSQL(), sqmQtaLaneOfcCostVOs, null);
				
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
	 * ESM_SQM_0012 : [이벤트]<br>
	 * [Basic CMCB_New Lane Cost IF)]의 [평균단가]를 [생성] 합니다.<br><br>
	 * 
	 * @param List<SqmQtaLaneOfcCostVO> sqmQtaLaneOfcCostVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createBasicCmcbNewLaneAvgCost(List<SqmQtaLaneOfcCostVO> sqmQtaLaneOfcCostVOs) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(sqmQtaLaneOfcCostVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new CostManageDBDAOCreateBasicCmcbNewLaneAvgCostCSQL(), sqmQtaLaneOfcCostVOs, null);
				
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
	 * ESM_SQM_0012 : [이벤트]<br>
	 * [Basic CMCB_New Lane Cost IF)]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicCmcbMasPfmcListListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchBasicCmcbMasPfmcListListVO> searchBasicCmcbMasPfmcList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchBasicCmcbMasPfmcListListVO> list = null;
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CostManageDBDAOSearchBasicCmcbCoaPfmcListListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBasicCmcbMasPfmcListListVO .class);
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
	 * @param SqmQtaLaneOfcVO sqmQtaLaneOfcVO
	 * @param String tableNm
	 * @return String[]
	 * @throws DAOException
	 */
	public String[] searchLaneOfficeForAddedOfcCnt(SqmQtaLaneOfcVO sqmQtaLaneOfcVO, String tableNm) throws DAOException {
		DBRowSet dbRowset = null;
		String[] dataCnt = new String[2];
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(sqmQtaLaneOfcVO != null){
				Map<String, String> mapVO = sqmQtaLaneOfcVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("tableNm", tableNm);
			}
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CostManageDBDAOSearchLaneOfficeForAddedOfcCntRSQL(), param, velParam);
			
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
	 * @param SqmQtaNewLaneVO sqmQtaNewLaneVO
	 * @return String 
	 * @throws DAOException
	 */
	public String searchNewLaneOfficeCmcbCnt(SqmQtaNewLaneVO sqmQtaNewLaneVO) throws DAOException {
		DBRowSet dbRowset = null;
		String dataCnt = "0";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(sqmQtaNewLaneVO != null){
				Map<String, String> mapVO = sqmQtaNewLaneVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CostManageDBDAOSearchNewLaneOfficeCmcbCntRSQL(), param, velParam);
			
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
	 * ESM_SQM_0209 : Retrieve1<br>
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CostManageDBDAOSearchNewLaneSecCmcbListRSQL(), param, velParam);
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
	 * ESM_SQM_0209 : Save1<br>
	 * [New Lane Sector CMCB List]을 [수정]합니다.<br>
	 * 
	 * @param List<SearchNewLaneSecCmcbListVO> uptModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateNewLaneSecCmcbNewLane(List<SearchNewLaneSecCmcbListVO> uptModels) throws DAOException,Exception {
		int uptCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
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
	 * ESM_SQM_0209 : Creation<br>
	 * [New Lane Sector CMCB Pair Cost]을 [생성]합니다.<br>
	 * 
	 * @param List<SearchNewLaneSecCmcbListVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createNewLaneSecCmcbPairCost(List<SearchNewLaneSecCmcbListVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
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
	 * ESM_SQM_0209 : Retrieve2<br>
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CostManageDBDAOSearchNewLaneSecCmcbPairCostRSQL(), param, velParam);
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
	 * ESM_SQM_0209 : Save2<br>
	 * [New Lane Sector CMCB Pair Cost]을 [수정]합니다.<br>
	 * 
	 * @param List<SearchNewLaneSecCmcbListVO> uptModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateNewLaneSecCmcbPairCost(List<SearchNewLaneSecCmcbListVO> uptModels) throws DAOException,Exception {
		int uptCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
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
	 * ESM_SQM_0210 : [Retrieve]<br>
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CostManageDBDAOSearchBasicCmcbForIasSectorListRSQL(), param, velParam);
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
	 * ESM_SQM_0210 : [Retrieve]<br>
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CostManageDBDAOSearchBasicCmcbForIasSectorListCntRSQL(), param, velParam);
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
	 * ESM_SQM_0210 : Save<br>
	 * [Basic CMCB for IAS Sector List]을 [수정]합니다.<br>
	 * 
	 * @param List<SearchNewLaneSecCmcbListVO> uptModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateBasicCmcbForIasSectorList(List<SearchNewLaneSecCmcbListVO> uptModels) throws DAOException,Exception {
		int uptCnt[] = null;
		int uptCnt2[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			if(uptModels.size() > 0){
				uptCnt = sqlExe.executeBatch((ISQLTemplate)new CostManageDBDAOUpdateBasicCmcbForIasSectorListUSQL(), uptModels,null);
				uptCnt2 = sqlExe.executeBatch((ISQLTemplate)new CostManageDBDAOUpdateConfirmedDataOfBasicCmcbForIasSectorUSQL(), uptModels,null);
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
	 * ESM_SQM_0210 : Creation<br>
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
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new CostManageDBDAOCreateBasicCmcbForIasSectorCSQL(), param, velParam);
			if(result == 0){							
				throw new EventException((String)new ErrorHandler("SQM00003", new String[]{}).getMessage());
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
	 * ESM_SQM_0211 : Retrieve<br>
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CostManageDBDAOSearchBasicCmcbForIasSecNewLaneIfRSQL(), param, velParam);
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
	 * ESM_SQM_0211 : New Lane Cost Apply<br>
	 * [Basic CMCB for IAS Sector_New Lane Cost IF]을 [Apply]합니다.<br>
	 * 
	 * @param List<SearchNewLaneSecCmcbListVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addBasicCmcbForIasSecNewLaneIf(List<SearchNewLaneSecCmcbListVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
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
	 * ESM_SQM_0212 : Retrieve<br>
	 * [Basic CMCB_MAS UC PFMC]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicCmcbMasUcPfmcVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchBasicCmcbMasUcPfmcVO> searchBasicCmcbMasUcPfmc(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchBasicCmcbMasUcPfmcVO> list = null;
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new CostManageDBDAOSearchBasicCmcbCoaUcPfmcRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBasicCmcbMasUcPfmcVO .class);
			
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
	 * ESM_SQM_0111 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateAddBasicCmcb(ConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");			
			int	insCnt = sqlExe.executeUpdate((ISQLTemplate)new CostManageDBDAOUpdateAddBasicCmcbUSQL(), param, velParam);
			
			if (insCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
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
	 * ESM_SQM_0111 : [이벤트]<br>
	 * [Basic CMCB (CM Cost Per Box)]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateAddCfmQta(ConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");			
			int	insCnt = sqlExe.executeUpdate((ISQLTemplate)new CostManageDBDAOUpdateAddCfmQtaUSQL(), param, velParam);
			
			if (insCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}