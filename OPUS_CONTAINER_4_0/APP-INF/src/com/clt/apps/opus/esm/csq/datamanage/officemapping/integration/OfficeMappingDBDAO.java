/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : OfficeMappingDBDAO.java
*@FileTitle      : OfficeMapping
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.03
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.03 CSQ USER
* 1.0 Creation
* History 
* 2014.06.05 이혜민 [CHM-201430324] IAS Sector -프로젝트 안정화 및 3분기 판매목표 수립 지원
* 2014.07.28 이혜민 [CHM-201431117] qta set up화면에서 add-creation, add-freezing 로직 추가_creation시 CSQ_QTA_LANE_OFC 에 Loading, Contract 모두 생성되었는지 확인
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.officemapping.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.basic.OfficeMappingBCImpl;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.vo.SearchAddSectorOfcRelSetVO;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.vo.SearchLaneOfficeRelationListVO;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.vo.SearchLaneOfficeRelationNewLaneAddListVO;
import com.clt.apps.opus.esm.csq.datamanage.officemapping.vo.SearchSectorOfcRelationSetListVO;
import com.clt.apps.opus.esm.csq.planning.planning.integration.PlanningDBDAOSearchMissingBasicDataListRSQL;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.CsqQtaLaneOfcVO;
import com.clt.syscommon.common.table.CsqQtaNewLaneVO;
import com.clt.syscommon.common.table.CsqQtaOfcVO;
import com.clt.syscommon.common.table.CsqSctrLaneOfcVO;

/**
 * ALPS OfficeMappingDBDAO <br>
 * - ALPS-OfficeMapping system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author CSQ USER
 * @see OfficeMappingBCImpl 참조
 * @since J2EE 1.6
 */
public class OfficeMappingDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * RHQ별 산하의 판매목표 수립 대상인 모든 Office를 조회한다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<CsqQtaOfcVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CsqQtaOfcVO> searchRhqOfcMappingList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CsqQtaOfcVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchRhqOfcMappingListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CsqQtaOfcVO .class);     
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
	 * ESM_CSQ_0006 : [이벤트]<br>
	 * [Lane Office Relation Setting]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchLaneOfficeRelationListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchLaneOfficeRelationListVO> searchLaneOfficeRelationList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchLaneOfficeRelationListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchLaneOfficeRelationListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLaneOfficeRelationListVO .class);
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
	 * ESM_CSQ_0006 : [이벤트]<br>
	 * [Lane Office Relation Setting]의 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchLaneOfficeRelationListCnt(ConditionVO conditionVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchLaneOfficeRelationListCntRSQL(), param, velParam);
			
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
	 * ESM_CSQ_0006 : [이벤트]<br>
	 * [Lane Office Relation Setting]을 [수정] 합니다.<br><br>
	 * 
	 * @param List<CsqQtaLaneOfcVO> csqQtaLaneOfcVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateLaneOfficeRelation(List<CsqQtaLaneOfcVO> csqQtaLaneOfcVOs) throws DAOException,Exception {
		int updCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(csqQtaLaneOfcVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OfficeMappingDBDAOUpdateLaneOfficeRelationUSQL(), csqQtaLaneOfcVOs, null);
				
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
	 * ESM_CSQ_0006 : [이벤트]<br>
	 * [Lane Office Relation Setting]을 [추가] 합니다.<br><br>
	 * 
	 * @param List<CsqQtaLaneOfcVO> csqQtaLaneOfcVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addLaneOfficeRelation(List<CsqQtaLaneOfcVO> csqQtaLaneOfcVOs) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(csqQtaLaneOfcVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OfficeMappingDBDAOAddLaneOfficeRelationCSQL(), csqQtaLaneOfcVOs, null);
				
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
	 * ESM_CSQ_0006 : [이벤트]<br>
	 * [Lane Office Relation Setting]을 [추가] 합니다.<br><br>
	 * 
	 * @param List<CsqQtaNewLaneVO> csqQtaNewLanes
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addNewLane(List<CsqQtaNewLaneVO> csqQtaNewLanes) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(csqQtaNewLanes.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OfficeMappingDBDAOAddNewLaneCSQL(), csqQtaNewLanes, null);
				
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
	 * ESM_CSQ_0006 : [이벤트]<br>
	 * [Lane Office Relation]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createLaneOfficeRelation(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
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
			
			int	insCnt = sqlExe.executeUpdate((ISQLTemplate)new OfficeMappingDBDAOCreateLaneOfficeRelationCSQL(), param, velParam);
			
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
	 * ESM_CSQ_0007 : [이벤트]<br>
	 * [RHQ-Office Mapping Data]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchLaneOfficeRelationNewLaneAddListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchLaneOfficeRelationNewLaneAddListVO> searchLaneOfficeRelationNewLaneAddList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchLaneOfficeRelationNewLaneAddListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchLaneOfficeRelationNewLaneAddListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLaneOfficeRelationNewLaneAddListVO .class);
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
	 * RHQ별 산하의 판매목표 수립 대상인 Office 정보 추가
	 * 
	 * @param List<CsqQtaOfcVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addRhqOfcMapping(List<CsqQtaOfcVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OfficeMappingDBDAOAddRhqOfcMappingCSQL(), insModels,null);
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
	 * RHQ별 산하의 판매목표 수립 대상인 Office 정보 삭제
	 * 
	 * @param List<CsqQtaOfcVO> delModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeRhqOfcMapping(List<CsqQtaOfcVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new OfficeMappingDBDAOUpdateRhqOfcMappingUSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * delt_flg가 Y인 (RHQ별 산하의 판매목표 수립 대상인) Office 정보 되살리기(delt_flg를 N으로 변경)
	 * 
	 * @param List<CsqQtaOfcVO> delModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void reactivateRhqOfcMapping(List<CsqQtaOfcVO> reactivateModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(reactivateModels.size() > 0){
				
				log.debug("111111111111reactivateModels:"+reactivateModels);
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new OfficeMappingDBDAOUpdateRhqOfcMappingUSQL(), reactivateModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No"+ i + " SQL");
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
	 * ESM_CSQ_0204 : Retrieve<br>
	 * [Sector Office Relation Setting List]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSectorOfcRelationSetListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSectorOfcRelationSetListVO> searchSectorOfcRelationSetList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSectorOfcRelationSetListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchSectorOfcRelationSetListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSectorOfcRelationSetListVO .class);
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
	 * ESM_CSQ_0204 : Retrieve<br>
	 * [Sector Office Relation Setting List]을 [Data Count]합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchSectorOfcRelationSetListCnt(ConditionVO conditionVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchSectorOfcRelationSetListCntRSQL(), param, velParam);
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
	 * ESM_CSQ_0204 : Retrieve<br>
	 * [Sector Office Relation Setting List Tab2]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchSectorOfcRelationSetListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchSectorOfcRelationSetListVO> searchSectorOfcRelationSetListT2(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSectorOfcRelationSetListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchSectorOfcRelationSetListT2RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSectorOfcRelationSetListVO .class);
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
	 * ESM_CSQ_0204 : Creation<br>
	 * [Sector Office Relation Setting List]을 [생성]합니다<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createSectorOfcRelationSet(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
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
			int result = sqlExe.executeUpdate((ISQLTemplate)new OfficeMappingDBDAOCreateSectorOfcRelationSetCSQL(), param, velParam);
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
	 * ESM_CSQ_0204 : Creation<br>
	 * [Sector Office Relation Setting_Act_flag가 하나도 없는 Lane List]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<String>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<String> searchSectorOfcRelationSetNActList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> nActList = new ArrayList<String>();
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchSectorOfcRelationSetNActListRSQL(), param, velParam);
			if(dbRowset != null){
				while(dbRowset.next()){
					nActList.add(dbRowset.getString(1));
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return nActList;
	}
	
	/**
	 * ESM_CSQ_0204 : SAVE<br>
	 * [Sector Office Relation Setting]을 [수정]합니다.<br>
	 * 
	 * @param List<CsqSctrLaneOfcVO> uptModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateSectorOfcRelationSet(List<CsqSctrLaneOfcVO> uptModels) throws DAOException,Exception {
		int uptCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(uptModels.size() > 0){
				uptCnt = sqlExe.executeBatch((ISQLTemplate)new OfficeMappingDBDAOUpdateSectorOfcRelationSetUSQL(), uptModels,null);
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
	 * ESM_CSQ_0205 : Retrieve<br>
	 * [Sector Office Relation Set_Add Creation List]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchAddSectorOfcRelSetVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchAddSectorOfcRelSetVO> searchAddSectorOfcRelSetPfGrp(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchAddSectorOfcRelSetVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchAddSectorOfcRelSetPfGrpRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAddSectorOfcRelSetVO .class);
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
	 * ESM_CSQ_0205 : Retrieve<br>
	 * [Sector Office Relation Set_Add Creation List의 Act Cnt]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchAddSectorOfcRelSetPfGrpActCnt(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		String actCnt = "0";
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchAddSectorOfcRelSetPfGrpActCntRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					actCnt = dbRowset.getString(1);
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return actCnt;
	}
	
	/**
	 * ESM_CSQ_0205 : CREATION<br>
	 * [Sector Office Relation Set_Add Creation List]을 [생성]합니다.<br>
	 * 
	 * @param List<SearchAddSectorOfcRelSetVO> istModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createAddSectorOfcRelSetPfGrp(List<SearchAddSectorOfcRelSetVO> istModels) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			for(int i=0; i<istModels.size(); i++){
				Map<String, String> mapVO = istModels.get(i).getColumnValues();
				param.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new OfficeMappingDBDAOCreateAddSectorOfcRelSetPfGrpCSQL(), param, null);
				if(result == 0){							
					throw new EventException((String)new ErrorHandler("CSQ00003", new String[]{}).getMessage());
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
	 * ESM_CSQ_0206 : Retrieve<br>
	 * [Sector Office Relation Set_Add POL POD Pair List]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchAddSectorOfcRelSetVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchAddSectorOfcRelSetVO> searchAddSectorOfcRelSetPolPod(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchAddSectorOfcRelSetVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchAddSectorOfcRelSetPolPodRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAddSectorOfcRelSetVO .class);
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
	 * ESM_CSQ_0206 : CREATION<br>
	 * [Sector Office Relation Set_Add POL POD Pair List]을 [생성]합니다.<br>
	 * CSQ_QTA_LANE_OFC 에 Loading, Contract 모두 생성되었는지 확인
	 * 
	 * @param ConditionVO conditionVO
	 * @throws DAOException
	 */
	public void searchMissingOfficeView(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		String missOfcVw = "";
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchMissingOfficeViewRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					missOfcVw = dbRowset.getString(1);
					log.debug("=======================missOfcVw:"+missOfcVw);
					//Loading, Contract중 하나라도 생성되지 않았을경우. N은 둘다 생성된것을 의미
					if(!missOfcVw.equals("N")){
						throw new EventException(new ErrorHandler("CSQ00009", new String[]{missOfcVw}).getMessage());
					}
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
	 * ESM_CSQ_0206 : CREATION<br>
	 * [Sector Office Relation Set_Add POL POD Pair List]을 [생성]합니다.<br>
	 * CSQ_SCTR_PAIR_MGMT/CSQ_ACT_FLG를 Y로 업데이트
	 * 
	 * @param List<SearchAddSectorOfcRelSetVO> uptModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateAddSectorOfcRelSetPolPodFlg(List<SearchAddSectorOfcRelSetVO> uptModels) throws DAOException,Exception {
		int uptCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(uptModels.size() > 0){
				uptCnt = sqlExe.executeBatch((ISQLTemplate)new OfficeMappingDBDAOUpdateAddSectorOfcRelSetPolPodFlgUSQL(), uptModels,null);
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
	 * ESM_CSQ_0206 : CREATION<br>
	 * [Sector Office Relation Set_Add POL POD Pair List]을 [생성]합니다.<br>
	 * 
	 * @param List<SearchAddSectorOfcRelSetVO> istModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createAddSectorOfcRelSetPolPod(List<SearchAddSectorOfcRelSetVO> istModels) throws DAOException,Exception {
//		int istCnt[] = null;
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
//			if(istModels.size() > 0){
//				istCnt = sqlExe.executeBatch((ISQLTemplate)new OfficeMappingDBDAOCreateAddSectorOfcRelSetPolPodCSQL(), istModels, null);
//				for(int i = 0; i < istCnt.length; i++){
//					if(istCnt[i]== Statement.EXECUTE_FAILED)
//						throw new DAOException("Fail to insert No"+ i + " SQL");
//				}
//			}
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			for(int i=0; i<istModels.size(); i++){
				Map<String, String> mapVO = istModels.get(i).getColumnValues();
				param.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new OfficeMappingDBDAOCreateAddSectorOfcRelSetPolPodCSQL(), param, null);
				if(result == 0){							
					throw new EventException((String)new ErrorHandler("CSQ00003", new String[]{}).getMessage());
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
}