/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : basicdataDBDAO.java
*@FileTitle      : BasicData
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.05.03
*@LastModifier   : CSQ USER
*@LastVersion    : 1.0
* 2013.05.03 CSQ USER
* 1.0 Creation
* History
* 2014.06.20 이혜민 [CHM-201430168] IAS Sector Sales - Main, Sector 구분자 추가를 위한 화면 변경
* 2014.07.28 이혜민 [CHM-201431109] POL POD Pair for IAS Sector화면 내 Add-creation시 Pair Cost가 생성되어 있으면 Add-creation하는 Pair도 cost 생성.
* 2014.08.14 이혜민 [CHM-201431421] Target VVD Fix시 PF Skd Group MGMT에서 생성된 PF SKD VER과 다른것이 있는지 조회
=========================================================*/
package com.clt.apps.opus.esm.csq.datamanage.basicdata.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.basic.BasicDataBCImpl;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.vo.SearchAddPolPodPairForSectorVO;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.vo.SearchBasicDataCreationForSecterListVO;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.vo.SearchBasicDataCreationListVO;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.vo.SearchBasicDataRelationListVO;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.vo.SearchLaneBoundCheckListVO;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.vo.SearchLaneDirectionChangeListVO;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.vo.SearchPfSkdGrpForSectorListVO;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.vo.SearchPolPodPairSectorListVO;
import com.clt.apps.opus.esm.csq.datamanage.basicdata.vo.SearchTargerVvdFixListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.CsqDatRltVO;
import com.clt.syscommon.common.table.CsqDirConvVO;
import com.clt.syscommon.common.table.CsqQtaLaneMgmtVO;
import com.clt.syscommon.common.table.CsqQtaTgtVvdVO;
import com.clt.syscommon.common.table.CsqSctrPairMgmtVO;

/**
 * ALPS BasicDataDBDAO <br>
 * - ALPS-BasicData system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author CSQ USER
 * @see BasicDataBCImpl 참조
 * @since J2EE 1.6
 */
public class BasicDataDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ESM_CSQ_0001 : [이벤트]<br>
	 * [Basic Data Relation Setting]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicDataRelationVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchBasicDataRelationListVO> searchBasicDataRelationList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchBasicDataRelationListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOSearchBasicDataRelationListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBasicDataRelationListVO .class);
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
	 * ESM_CSQ_0001 : [이벤트]<br>
	 * [Basic Data Relation Setting]을 [저장] 합니다.<br><br>
	 * 
	 * @param List<CsqDatRltVO> csqDatRltVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addBasicDataRelation(List<CsqDatRltVO> csqDatRltVOs) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(csqDatRltVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BasicDataDBDAOAddBasicDataRelationCSQL(), csqDatRltVOs, null);
				
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
	 * ESM_CSQ_0001 : [이벤트]<br>
	 * [Basic Data Relation Setting]을 [삭제] 합니다.<br><br>
	 * 
	 * @param List<CsqDatRltVO> csqDatRltVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeBasicDataRelation(List<CsqDatRltVO> csqDatRltVOs) throws DAOException,Exception {
		int delCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(csqDatRltVOs.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new BasicDataDBDAORemoveBasicDataRelationDSQL(), csqDatRltVOs, null);
				
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * ESM_CSQ_0001 : [이벤트]<br>
	 * [Basic Data Relation Setting]의 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchBasicDataRelationListCnt(ConditionVO conditionVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOSearchBasicDataRelationListCntRSQL(), param, velParam);
			
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
	 * ESM_CSQ_0001 : [이벤트]<br>
	 * [Basic Data Relation Setting]을 [복사] 합니다.<br><br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void copyBasicDataRelation(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
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
				
				param.put("cre_usr_id", usrId);
				velParam.put("cre_usr_id", usrId);
			}
			
			int	insCnt = sqlExe.executeUpdate((ISQLTemplate)new BasicDataDBDAOCopyBasicDataRelationCSQL(), param, velParam);
			
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
	 * Reverse Sailing 노선들의 Direction 을 조회.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchLaneDirectionChangeListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchLaneDirectionChangeListVO> searchLaneDirectionChangeList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchLaneDirectionChangeListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOSearchLaneDirectionChangeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLaneDirectionChangeListVO .class);     
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
	 * Reverse Sailing 노선들의 변경된 Direction 을 추가
	 * 
	 * @param List<CsqDirConvVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addLaneDirectionChange(List<CsqDirConvVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BasicDataDBDAOAddLaneDirectionChangeCSQL(), insModels,null);
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
	 * Reverse Sailing 노선들의 변경된 Direction 을 삭제
	 * 
	 * @param List<CsqDirConvVO> delModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeLaneDirectionChange(List<CsqDirConvVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new BasicDataDBDAORemoveLaneDirectionChangeDSQL(), delModels,null);
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
	 * 최근 이전 분기의 데이터를 복사
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void copyLaneDirectionChange(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
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
			int result = sqlExe.executeUpdate((ISQLTemplate)new BasicDataDBDAOCopyLaneDirectionChangeCSQL(), param, velParam);
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
	 * Reverse Sailing 노선들의 Direction 조회 리스트를 count
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchLaneDirectionChangeListCnt(ConditionVO conditionVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOSearchLaneDirectionChangeListCntRSQL(), param, velParam);
			
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
	 * Target VVD List를 조회
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchTargerVvdFixListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchTargerVvdFixListVO> searchTargerVvdFixList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTargerVvdFixListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOSearchTargerVvdFixListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTargerVvdFixListVO .class);     
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
	 * ESM_CSQ_0010 : Target VVD Fix 화면 내 Creation시_COA에서 조회<br>
	 * Target VVD Fix시 PF Skd Group MGMT에서 생성된 PF SKD VER과 다른것이 있는지 조회합니다. <br>
	 * 
	 * @param ConditionVO conditionVO
	 * @throws DAOException
	 */
	public void searchDiffPfVerByCoa(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> diffPfVerList = new ArrayList<String>();
		StringBuffer msg = new StringBuffer();
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOSearchDiffPfVerByCoaRSQL(), param, velParam);
			if(dbRowset != null){
				while(dbRowset.next()){
					diffPfVerList.add(dbRowset.getString(1));
				}
				log.debug("===================diffPfVerList.size():"+diffPfVerList.size());
				if(diffPfVerList.size() > 0){
					for ( int i=0; i < diffPfVerList.size(); i++ ) {
						msg.append(diffPfVerList.get(i));
						msg.append("\n");
					}
					throw new EventException(new ErrorHandler("CSQ00011", new String[]{msg.toString()}).getMessage());
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
	 * COA 대상항차 + BSA 정보로 Target vvd data 생성
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createTargerVvdFixByCoa(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
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
			int result = sqlExe.executeUpdate((ISQLTemplate)new BasicDataDBDAOCreateTargerVvdFixByCoaCSQL(), param, velParam);
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
	 * Lane List를 조회
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchTargerVvdFixListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchTargerVvdFixListVO> searchLaneList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTargerVvdFixListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOSearchLaneListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTargerVvdFixListVO .class);     
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
	 * Target vvd list를 업데이트한다.
	 * 
	 * @param List<CsqQtaTgtVvdVO> uptModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateTargerVvdFix(List<CsqQtaTgtVvdVO> uptModels) throws DAOException,Exception {
		int uptCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(uptModels.size() > 0){
				uptCnt = sqlExe.executeBatch((ISQLTemplate)new BasicDataDBDAOUpdateTargerVvdFixUSQL(), uptModels,null);
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
	 * ESM_CSQ_0008 : [이벤트]<br>
	 * [Basic Data Creation]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicDataCreationListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchBasicDataCreationListVO> searchBasicDataCreationList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchBasicDataCreationListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOSearchBasicDataCreationListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBasicDataCreationListVO .class);
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
	 * ESM_CSQ_0010 : [이벤트]<br>
	 * [Target VVD]의 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchTargerVvdFixListCnt(ConditionVO conditionVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOSearchTargerVvdFixListCntRSQL(), param, velParam);
			
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
	 * ESM_CSQ_0008 : [이벤트]<br>
	 * [Basic Data Creation]의 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String periodFlg
	 * @return String
	 * @exception DAOException
	 */
	public String searchBasicDataCreationListCnt(ConditionVO conditionVO, String periodFlg) throws DAOException {
		DBRowSet dbRowset = null;
		String dataCnt = "0";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				
				velParam.put("flg", periodFlg);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOSearchBasicDataCreationListCntRSQL(), param, velParam);
			
			if(dbRowset != null){
				if(dbRowset.next()){
					dataCnt = dbRowset.getString("CNT");
					
					if ( periodFlg.equals("Y") ) {
						dataCnt = dataCnt
						        + "|" + dbRowset.getString("APLY_FM_YRWK")
						        + "|" + dbRowset.getString("APLY_TO_YRWK");
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
		return dataCnt;
	}
	
	/**
	 * ESM_CSQ_0002 : [이벤트]<br>
	 * [Lane Master]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<CsqQtaLaneMgmtVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CsqQtaLaneMgmtVO> searchLaneMasterList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CsqQtaLaneMgmtVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOSearchLaneMasterListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CsqQtaLaneMgmtVO .class);
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
	 * ESM_CSQ_0002 : [이벤트]<br>
	 * [Lane Master]을 [저장] 합니다.<br>
	 * 
	 * @param List<CsqQtaLaneMgmtVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addLaneMaster(List<CsqQtaLaneMgmtVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(insModels.size() > 0){
				
				insCnt = sqlExe.executeBatch((ISQLTemplate)new BasicDataDBDAOAddLaneMasterCSQL(), insModels,null);
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
	 * ESM_CSQ_0002 : [이벤트]<br>
	 * [Lane Master]을 [삭제] 합니다.<br>
	 * 
	 * @param List<CsqQtaLaneMgmtVO> delModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeLaneMaster(List<CsqQtaLaneMgmtVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new BasicDataDBDAORemoveLaneMasterDSQL(), delModels,null);
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
	 * ESM_CSQ_0002 : [이벤트]<br>
	 * [Lane Master]을 [업데이트] 합니다.<br>
	 * 
	 * @param List<CsqQtaLaneMgmtVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateLaneMaster(List<CsqQtaLaneMgmtVO> updModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(updModels.size() > 0){
				
				log.debug("111111111111111111111111updModels:"+updModels);
				
				delCnt = sqlExe.executeBatch((ISQLTemplate)new BasicDataDBDAOUpdateLaneMasterUSQL(), updModels,null);
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
	 * Target VVD List를 조회
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchTargerVvdFixListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchTargerVvdFixListVO> searchTargerVvdFixByCoa(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTargerVvdFixListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOSearchTargerVvdFixByCoaRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTargerVvdFixListVO .class);     
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
	 * ESM_CSQ_0009 : [이벤트]<br>
	 * CSQ_QTA_LANE_MGMT 와 CSQ_QTA_LANE_OFC 간의 Act Flg 체크.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchLaneBoundCheckListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchLaneBoundCheckListVO> searchLaneBoundCheckList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchLaneBoundCheckListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOSearchLaneBoundCheckListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLaneBoundCheckListVO .class);
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
	 * ESM_CSQ_0010 : [이벤트]<br>
	 * [Target VVD]의 접속 ofc를 확인 합니다.<br>
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchCreationUser(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String dataCnt = "";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			if(ofcCd != null){
				param.put("f_ofc_cd", ofcCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOSearchCreationUserRSQL(), param, null);
			
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
	 * ESM_CSQ_0201 : Retrieve<br>
	 * [P/F SKD Group Mgmt for IAS Sector List]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchPfSkdGrpForSectorListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchPfSkdGrpForSectorListVO> searchPfSkdGrpForSectorList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchPfSkdGrpForSectorListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOSearchPfSkdGrpForSectorListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPfSkdGrpForSectorListVO .class);
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
	 * ESM_CSQ_0201 : Retrieve<br>
	 * [P/F SKD Group Mgmt for IAS Sector List]을 [Data Count]합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchPfSkdGrpForSectorListCnt(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		String dataCnt = "0";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
//               if (!JSPUtil.getNull(conditionVO.getFRlaneCd()).equals("") && !JSPUtil.getNull(conditionVO.getFRlaneCd()).equals("All")) {
//            	   conditionVO.setFRlaneCd("'" + conditionVO.getFRlaneCd().replaceAll("," ,"','") +"'");
//				}
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOSearchPfSkdGrpForSectorListCntRSQL(), param, velParam);
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
	 * ESM_CSQ_0201 : Creation<br>
	 * [P/F SKD Group Mgmt for IAS Sector List]을 [생성]합니다_Quarter<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createPfSkdGrpForSectorQta(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
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
			int result = sqlExe.executeUpdate((ISQLTemplate)new BasicDataDBDAOCreatePfSkdGrpForSectorQtaCSQL(), param, velParam);
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
	 * ESM_CSQ_0201 : Creation<br>
	 * [P/F SKD Group Mgmt for IAS Sector List]을 [생성]합니다_Year<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createPfSkdGrpForSectorYr(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
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
			int result = sqlExe.executeUpdate((ISQLTemplate)new BasicDataDBDAOCreatePfSkdGrpForSectorYrCSQL(), param, velParam);
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
	 * ESM_CSQ_0201 : Add-Creation<br>
	 * [P/F SKD Group Mgmt for IAS Sector List]을 [추가생성]합니다_Quarter<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createAddPfSkdGrpForSectorQta(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
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
			int result = sqlExe.executeUpdate((ISQLTemplate)new BasicDataDBDAOCreateAddPfSkdGrpForSectorQtaCSQL(), param, velParam);
			if(result == 0){							
				throw new EventException((String)new ErrorHandler("CSQ00007", new String[]{}).getMessage());
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
	 * ESM_CSQ_0201 : Add-Creation<br>
	 * [P/F SKD Group Mgmt for IAS Sector List]을 [추가생성]합니다_Year<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createAddPfSkdGrpForSectorYr(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
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
			int result = sqlExe.executeUpdate((ISQLTemplate)new BasicDataDBDAOCreateAddPfSkdGrpForSectorYrCSQL(), param, velParam);
			if(result == 0){							
				throw new EventException((String)new ErrorHandler("CSQ00007", new String[]{}).getMessage());
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
	 * ESM_CSQ_0202 : Retrieve<br>
	 * [P/F SKD Group Mgmt for IAS Sector List]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchPolPodPairSectorListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchPolPodPairSectorListVO> searchPolPodPairSectorList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchPolPodPairSectorListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOSearchPolPodPairSectorListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPolPodPairSectorListVO .class);
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
	 * ESM_CSQ_0202 : Retrieve<br>
	 * [P/F SKD Group Mgmt for IAS Sector List]을 [Data Count]합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchPolPodPairSectorListCnt(ConditionVO conditionVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOSearchPolPodPairSectorListCntRSQL(), param, velParam);
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
	 * ESM_CSQ_0202 : Retrieve<br>
	 * [P/F SKD Group Mgmt for IAS Sector List Tab2]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchPolPodPairSectorListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchPolPodPairSectorListVO> searchPolPodPairSectorListT2(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchPolPodPairSectorListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOSearchPolPodPairSectorListT2RSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPolPodPairSectorListVO .class);
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
	 * ESM_CSQ_0202 : Creation 또는 Retrieve 후<br>
	 * [POL POD Pair for IAS Sector List 중 Main Flag가 하나도 없는 Lane, Bound]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<String>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<String> searchPolPodPairNMainFlgList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> nMainList = new ArrayList<String>();
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOSearchPolPodPairNMainFlgListRSQL(), param, velParam);
			if(dbRowset != null){
				while(dbRowset.next()){
					nMainList.add(dbRowset.getString(1));
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return nMainList;
	}
	
	/**
	 * ESM_CSQ_0202 : Creation<br>
	 * [POL POD Pair for IAS Sector List]을 [생성]합니다<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createPolPodPairForSector(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
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
			int result = sqlExe.executeUpdate((ISQLTemplate)new BasicDataDBDAOCreatePolPodPairForSectorCSQL(), param, velParam);
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
	 * ESM_CSQ_0202 : SAVE<br>
	 * [POL POD Pair for IAS Sector List]을 [수정]합니다.<br>
	 * 
	 * @param List<CsqSctrPairMgmtVO> uptModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updatePolPodPairForSector(List<CsqSctrPairMgmtVO> uptModels) throws DAOException,Exception {
		int uptCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(uptModels.size() > 0){
				uptCnt = sqlExe.executeBatch((ISQLTemplate)new BasicDataDBDAOUpdatePolPodPairForSectorUSQL(), uptModels,null);
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
	 * ESM_CSQ_0203 : Retrieve<br>
	 * [POL POD Pair for IAS Sector Add List]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchAddPolPodPairForSectorVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchAddPolPodPairForSectorVO> searchAddPolPodPairForSector(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchAddPolPodPairForSectorVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOSearchAddPolPodPairForSectorRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAddPolPodPairForSectorVO .class);
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
     * ESM_CSQ_0203 : CREATION<br>
	 * [POL POD Pair for IAS Sector Add List]의 New Lane Direction을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchPolPodPairNewLaneDir(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		String laneDirCd = "";
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOSearchPolPodPairNewLaneDirRSQL(), param, velParam);
			if(dbRowset != null){
				if(dbRowset.next()){
					laneDirCd = dbRowset.getString("LANE_DIR_CD");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return laneDirCd;
	}
	
	/**
     * ESM_CSQ_0203 : CREATION<br>
	 * [POL POD Pair for IAS Sector Add List]의 MDM Lane Direction을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<String>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<String> searchMdmVslSvcLaneDir(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> MdmVslSvcLaneDir = new ArrayList<String>();
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOSearchMdmVslSvcLaneDirRSQL(), param, velParam);
			if(dbRowset != null){
				while(dbRowset.next()){
					MdmVslSvcLaneDir.add(dbRowset.getString(1));
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return MdmVslSvcLaneDir;
	}
	
	
	/**
     * ESM_CSQ_0203 : CREATION<br>
	 * [Add Creation 하는 노선의 SCTR_PAIR_COST Data CNT]를 [조회]합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchAddCreateLanePairCostCnt(ConditionVO conditionVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOSearchAddCreateLanePairCostCntRSQL(), param, velParam);
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
	 * ESM_CSQ_0203 : CREATION<br>
	 * [POL POD Pair for IAS Sector Add List]을 [생성]합니다.<br>
	 * 신규 노선일때 CSQ_SCTR_NEW_LANE 테이블에 insert
	 * 
	 * @param List<SearchAddPolPodPairForSectorVO> newLaneVoList
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addPolPodPairNewLane(List<SearchAddPolPodPairForSectorVO> newLaneVoList) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			for(int i=0; i<newLaneVoList.size(); i++){
				Map<String, String> mapVO = newLaneVoList.get(i).getColumnValues();
				param.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new BasicDataDBDAOAddPolPodPairNewLaneCSQL(), param, null);
				if(result == Statement.EXECUTE_FAILED){							
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
	 * ESM_CSQ_0203 : CREATION<br>
	 * [Add Creation 하는 노선의 Pair에 대하여 Basic CMCB]을 생성합니다. CSQ_SCTR_PAIR_COST
	 * 
	 * @param List<SearchAddPolPodPairForSectorVO> pairCostVoList
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createAddBasicCmcbForIasSector(List<SearchAddPolPodPairForSectorVO> pairCostVoList) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			for(int i=0; i<pairCostVoList.size(); i++){
				Map<String, String> mapVO = pairCostVoList.get(i).getColumnValues();
				param.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new BasicDataDBDAOCreateAddBasicCmcbForIasSectorCSQL(), param, null);
				if(result == Statement.EXECUTE_FAILED){							
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
	 * ESM_CSQ_0203 : CREATION<br>
	 * [POL POD Pair for IAS Sector Add List]을 [생성]합니다._Quarter<br>
	 * 
	 * @param List<SearchAddPolPodPairForSectorVO> istModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createAddPolPodPairForSectorQta(List<SearchAddPolPodPairForSectorVO> istModels) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			for(int i=0; i<istModels.size(); i++){
				Map<String, String> mapVO = istModels.get(i).getColumnValues();
				param.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new BasicDataDBDAOCreateAddPolPodPairForSectorQtaCSQL(), param, null);
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
	 * ESM_CSQ_0203 : CREATION<br>
	 * [POL POD Pair for IAS Sector Add List]을 [생성]합니다._Year<br>
	 * 
	 * @param List<SearchAddPolPodPairForSectorVO> istModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createAddPolPodPairForSectorYr(List<SearchAddPolPodPairForSectorVO> istModels) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			for(int i=0; i<istModels.size(); i++){
				Map<String, String> mapVO = istModels.get(i).getColumnValues();
				param.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new BasicDataDBDAOCreateAddPolPodPairForSectorYrCSQL(), param, null);
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
	 * ESM_CSQ_0207 : [Retrieve]<br>
	 * [Basic Data Creation for IAS Sector]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchBasicDataCreationForSecterListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<SearchBasicDataCreationForSecterListVO> searchBasicDataCreationForSecterList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchBasicDataCreationForSecterListVO> list = null;
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOSearchBasicDataCreationForSecterListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchBasicDataCreationForSecterListVO .class);
			
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
	 * ESM_CSQ_0207 : [Retrieve]<br>
	 * [Basic Data Creation for IAS Sector]의 [COUNT] 를 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchBasicDataCreationForSecterListCnt(ConditionVO conditionVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BasicDataDBDAOSearchBasicDataCreationForSecterListCntRSQL(), param, velParam);
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
	 * ESM_CSQ_0002 : [이벤트]<br>
	 * [Lane Master]을 [복사] 합니다.<br><br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void copyLaneMaster(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
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
				
				param.put("cre_usr_id", usrId);
				velParam.put("cre_usr_id", usrId);
			}
			
			int	insCnt = sqlExe.executeUpdate((ISQLTemplate)new BasicDataDBDAOCopyLaneMasterCSQL(), param, velParam);
			
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
}