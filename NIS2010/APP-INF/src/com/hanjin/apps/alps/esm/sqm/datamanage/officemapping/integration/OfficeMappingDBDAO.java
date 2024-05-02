/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : OfficeMappingDBDAO.java
*@FileTitle      : OfficeMapping
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.03
*@LastModifier   : SQM USER
*@LastVersion    : 1.0
* 2013.05.03 SQM USER
* 1.0 Creation
* History 
* 2014.06.05 이혜민 [CHM-201430324] IAS Sector -프로젝트 안정화 및 3분기 판매목표 수립 지원
* 2014.07.28 이혜민 [CHM-201431117] qta set up화면에서 add-creation, add-freezing 로직 추가_creation시 SQM_QTA_LANE_OFC 에 Loading, Contract 모두 생성되었는지 확인
* 2015.05.12 김용습 [CHM-201535562] [SQM] Sector-Office Relation Setting for IAS Sector - 타임아웃 방지를 위해 데이터를 반으로 나누어 생성되게 함
* 2015.10.27 김용습 [CHM-201537712] [CSR 전환건] "Sector-Office Relation Setting for IAS Sector 화면 내 Creation"의 로직 변경
* 2015.12.02 김용습 [CHM-201539212] 연간/분기동안 확정 Data에 한번 들어간 Sector Pair는 active 해제할 수 없도록 로직 수정
* 2016.01.13 [CHM-201539389] Lane Office Inactive 불가하도록 비활성화 로직 변경
* 2016.07.04 최성민 [CHM-201642330] SQM 화면 버튼 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.basic.OfficeMappingBCImpl;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.vo.SearchAddSectorOfcRelSetVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.vo.SearchLaneOfficeRelationListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.vo.SearchLaneOfficeRelationNewLaneAddListVO;
import com.hanjin.apps.alps.esm.sqm.datamanage.officemapping.vo.SearchSectorOfcRelationSetListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.SqmQtaLaneOfcVO;
import com.hanjin.syscommon.common.table.SqmQtaNewLaneVO;
import com.hanjin.syscommon.common.table.SqmQtaOfcVO;
import com.hanjin.syscommon.common.table.SqmSctrLaneOfcVO;

/**
 * ALPS OfficeMappingDBDAO <br>
 * - ALPS-OfficeMapping system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SQM USER
 * @see OfficeMappingBCImpl 참조
 * @since J2EE 1.6
 */
public class OfficeMappingDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * RHQ별 산하의 판매목표 수립 대상인 모든 Office를 조회한다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SqmQtaOfcVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SqmQtaOfcVO> searchRhqOfcMappingList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SqmQtaOfcVO> list = null;
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchRhqOfcMappingListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SqmQtaOfcVO .class);     
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
	 * ESM_SQM_0008 : [이벤트]<br>
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchLaneOfficeRelationListRSQL(), param, velParam);
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
	 * ESM_SQM_0008 : [이벤트]<br>
	 * [Lane Office Relation Setting]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchLaneOfficeRelationListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchLaneOfficeRelationListVO> searchLoadingViewCheckList(ConditionVO conditionVO) throws DAOException {
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchLoadingViewCheckListRSQL(), param, velParam);
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
	 * ESM_SQM_0008 : [이벤트]<br>
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchLaneOfficeRelationListCntRSQL(), param, velParam);
			
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
	 * ESM_SQM_0008 : [이벤트]<br>
	 * [Lane Office Relation Setting]의 [Freezing 데이터] 가 존재하는지 체크합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchQtaReleaseVersion(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rlseVer = "0";
		
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchReleaseVersionRSQL(), param, velParam);
			
			if(dbRowset != null){
				if(dbRowset.next()){
					rlseVer = dbRowset.getString(1);
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rlseVer;
	}
	
	/**
	 * ESM_SQM_0008 : [이벤트]<br>
	 * [Lane Office Relation Setting]을 [수정] 합니다.<br><br>
	 * 
	 * @param List<SqmQtaLaneOfcVO> sqmQtaLaneOfcVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateLaneOfficeRelation(List<SqmQtaLaneOfcVO> sqmQtaLaneOfcVOs) throws DAOException,Exception {
		int updCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(sqmQtaLaneOfcVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OfficeMappingDBDAOUpdateLaneOfficeRelationUSQL(), sqmQtaLaneOfcVOs, null);
				
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
	 * ESM_SQM_0008 : [이벤트]<br>
	 * [Lane Office Relation Setting]을 [추가] 합니다.<br><br>
	 * 
	 * @param List<SqmQtaLaneOfcVO> sqmQtaLaneOfcVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addLaneOfficeRelation(List<SqmQtaLaneOfcVO> sqmQtaLaneOfcVOs) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(sqmQtaLaneOfcVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OfficeMappingDBDAOAddLaneOfficeRelationCSQL(), sqmQtaLaneOfcVOs, null);
				
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
	 * ESM_SQM_0008 : [이벤트]<br>
	 * [Lane Office Relation Setting]을 [추가] 합니다.<br><br>
	 * 
	 * @param List<SqmQtaNewLaneVO> sqmQtaNewLanes
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addNewLane(List<SqmQtaNewLaneVO> sqmQtaNewLanes) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(sqmQtaNewLanes.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new OfficeMappingDBDAOAddNewLaneCSQL(), sqmQtaNewLanes, null);
				
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
	 * ESM_SQM_0008 : [이벤트]<br>
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
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
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
	 * ESM_SQM_0009 : [이벤트]<br>
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchLaneOfficeRelationNewLaneAddListRSQL(), param, velParam);
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
	 * @param List<SqmQtaOfcVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addRhqOfcMapping(List<SqmQtaOfcVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
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
	 * @param List<SqmQtaOfcVO> delModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeRhqOfcMapping(List<SqmQtaOfcVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
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
	 * ESM_SQM_0204 : Retrieve<br>
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchSectorOfcRelationSetListRSQL(), param, velParam);
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
	 * ESM_SQM_0204<br>
	 * Active cell을 uncheck하려고 할 때 타는 로직(이미 해당 pair로 확정 데이터가 생성된 것이 있으면 uncheck될 수 없도록 함)
	 * 
	 * @param SqmSctrLaneOfcVO sqmSctrLaneOfcVO
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchConfirmedDataOfPair(SqmSctrLaneOfcVO sqmSctrLaneOfcVO, ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		String dataCnt = "0";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = sqmSctrLaneOfcVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchConfirmedDataOfPairRSQL(), param, velParam);
			if(dbRowset != null){
//				dbRowset.getRowCount();
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
	 * ESM_SQM_0008<br>
	 * Active cell을 uncheck하려고 할 때 타는 로직(이미 해당 pair로 확정 데이터가 생성된 것이 있으면 uncheck될 수 없도록 함)
	 * 
	 * @param SqmQtaLaneOfcVO sqmQtaLaneOfcVO
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchConfirmedDataOfLaneOffice(SqmQtaLaneOfcVO sqmQtaLaneOfcVO, ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		String dataCnt = "0";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = sqmQtaLaneOfcVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchConfirmedDataOfLaneOfficePairRSQL(), param, velParam);
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
	 * ESM_SQM_0204 : Retrieve<br>
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchSectorOfcRelationSetListCntRSQL(), param, velParam);
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
	 * ESM_SQM_0204 : Retrieve<br>
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchSectorOfcRelationSetListT2RSQL(), param, velParam);
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
	 * ESM_SQM_0204 : Creation<br>
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchSectorOfcRelationSetNActListRSQL(), param, velParam);
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
	 * ESM_SQM_0204 : SAVE<br>
	 * [Sector Office Relation Setting]을 [수정]합니다.<br>
	 * 
	 * @param List<SqmSctrLaneOfcVO> uptModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateSectorOfcRelationSet(List<SqmSctrLaneOfcVO> uptModels) throws DAOException,Exception {
		int uptCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
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
	 * ESM_SQM_0205 : Retrieve<br>
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchAddSectorOfcRelSetPfGrpRSQL(), param, velParam);
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
	 * ESM_SQM_0205 : Retrieve<br>
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchAddSectorOfcRelSetPfGrpActCntRSQL(), param, velParam);
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
	 * ESM_SQM_0205 : CREATION<br>
	 * [Sector Office Relation Set_Add Creation List]을 [생성]합니다.<br>
	 * 
	 * @param List<SearchAddSectorOfcRelSetVO> istModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createAddSectorOfcRelSetPfGrp(List<SearchAddSectorOfcRelSetVO> istModels) throws DAOException,Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			for(int i=0; i<istModels.size(); i++){
				Map<String, String> mapVO = istModels.get(i).getColumnValues();
				param.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new OfficeMappingDBDAOCreateAddSectorOfcRelSetPfGrpCSQL(), param, null);
				if(result == 0){							
					throw new EventException((String)new ErrorHandler("SQM00003", new String[]{}).getMessage());
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
	 * ESM_SQM_0206 : Retrieve<br>
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchAddSectorOfcRelSetPolPodRSQL(), param, velParam);
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
	 * ESM_SQM_0206 : CREATION<br>
	 * [Sector Office Relation Set_Add POL POD Pair List]을 [생성]합니다.<br>
	 * SQM_QTA_LANE_OFC 에 Loading, Contract 모두 생성되었는지 확인
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new OfficeMappingDBDAOSearchMissingOfficeViewRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					missOfcVw = dbRowset.getString(1);
					log.debug("=======================missOfcVw:"+missOfcVw);
					//Loading, Contract중 하나라도 생성되지 않았을경우. N은 둘다 생성된것을 의미
					if(!missOfcVw.equals("N")){
						throw new EventException(new ErrorHandler("SQM00009", new String[]{missOfcVw}).getMessage());
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
	 * ESM_SQM_0206 : CREATION<br>
	 * [Sector Office Relation Set_Add POL POD Pair List]을 [생성]합니다.<br>
	 * SQM_SCTR_PAIR_MGMT/SQM_ACT_FLG를 Y로 업데이트
	 * 
	 * @param List<SearchAddSectorOfcRelSetVO> uptModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateAddSectorOfcRelSetPolPodFlg(List<SearchAddSectorOfcRelSetVO> uptModels) throws DAOException,Exception {
		int uptCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
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
	 * ESM_SQM_0206 : CREATION<br>
	 * [Sector Office Relation Set_Add POL POD Pair List]을 [생성]합니다.<br>
	 * 
	 * @param List<SearchAddSectorOfcRelSetVO> istModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createAddSectorOfcRelSetPolPod(List<SearchAddSectorOfcRelSetVO> istModels) throws DAOException,Exception {
//		int istCnt[] = null;
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
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
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			for(int i=0; i<istModels.size(); i++){
				Map<String, String> mapVO = istModels.get(i).getColumnValues();
				param.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new OfficeMappingDBDAOCreateAddSectorOfcRelSetPolPodCSQL(), param, null);
				if(result == 0){							
					throw new EventException((String)new ErrorHandler("SQM00003", new String[]{}).getMessage());
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
	 * ESM_SQM_0204 : Creation<br>
	 * [Sector Office Relation Setting List]��[�앹꽦]�⑸땲��br>
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
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new OfficeMappingDBDAOCreateSectorOfcRelationSetCSQL(), param, velParam);
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
}