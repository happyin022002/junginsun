/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : AdjustmentDBDAO.java
*@FileTitle      : Adjustment
*Open Issues     :
*Change history  :
*@LastModifyDate : 2014.01.02
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.07.16 이혜민
* 1.0 Creation
* 2014.01.02 이혜민 [CHM-201328060-01] SQM 데이터 조회시 현재날짜와 조건날짜 비교하여 다른 테이블에서 조회되도록 수정
* 2014.09.17 이혜민 [CHM-201431755-01] New Lane Add시 Bound 삽입
* 2014.12.12 이혜민 [CHM-201432763] RF SPCL TPSZ Master 화면 신규 생성
* 2015.08.06 김용습 [CHM-201537260] [CSR 전환 건] SQM내 Report에 과거 CM 체계 기준 판매목표 데이터 조회 기능 생성 (15년 2Q 이전 데이터 Freeze)
* 2015.11.24 김용습 [CHM-201538493] [CSR 전환건] Current KPI Report 화면 보완 (조회 조건 Week → Month 변경, Raw Data Export 버튼 추가)
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.ManageQtaAdjustmentVO;
import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.basic.AdjustmentBCImpl;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.vo.SearchCurrentKpiReportVO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.vo.SearchKpiCreationEditNewOfcHisVO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.vo.SearchKpiCreationEditVO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.vo.SearchQtaAdjustmentListVO;
import com.hanjin.apps.alps.esm.sqm.specialkpi.adjustment.vo.SearchReeferSpclTpSzMgmtVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.SqmSpclCfmQtaVO;
import com.hanjin.syscommon.common.table.SqmSpclNewLaneVO;
import com.hanjin.syscommon.common.table.SqmSpclNewOfcVO;

/**
 * ALPS AdjustmentDBDAO <br>
 * - ALPS-Adjustment system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 이혜민
 * @see AdjustmentBCImpl 참조
 * @since J2EE 1.6
 */
public class AdjustmentDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ESM_SQM_0504 : [SEARCH]<br>
	 * [KPI Creation & Edit]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchKpiCreationEditVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchKpiCreationEditVO> searchKpiCreationEdit(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchKpiCreationEditVO> list = null;
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new AdjustmentDBDAOSearchKpiCreationEditRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchKpiCreationEditVO .class);
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
	 * ESM_SQM_0504 : [SEARCH]<br>
	 * [KPI Creation & Edit]을 [Data Count] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchKpiCreationEditCnt(ConditionVO conditionVO) throws DAOException {
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new AdjustmentDBDAOSearchKpiCreationEditCntRSQL(), param, velParam);
			
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
	 * ESM_SQM_0504 : [SEARCH01]<br>
	 * [KPI Creation & Edit]화면에서 Creation 후 또는 이미 Yearly 데이터가 있을 경우 1Q 데이터가 있는지 없는지 [확인]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception DAOException
	 */
	public String search1QTransferDataCnt(ConditionVO conditionVO) throws DAOException {
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new AdjustmentDBDAOSearch1QTransferDataCntRSQL(), param, velParam);
			
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
	 * ESM_SQM_0504 : [MULTI]<br>
	 * [KPI Creation & Edit]를 [Update] 합니다.
	 * 
	 * @param List<SqmSpclCfmQtaVO> updateVoList
	 * @throws DAOException
	 */
	public void updateKpiCreationEdit(List<SqmSpclCfmQtaVO> updateVoList) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AdjustmentDBDAOUpdateKpiCreationEditUSQL(), updateVoList, null, null);
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
	 * ESM_SQM_0504 : [MULTI01]<br>
	 * [KPI Creation & Edit]을 [생성] 합니다.<br>
	 * SQM_QTA_TGT_VVD -> SQM_SPCL_TGT_VVD 
	 *
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @throws DAOException
	 */
	public String createSqmQtaTgtVvd(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		String istCnt = null;
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			param.put("usr_id", usrId);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AdjustmentDBDAOCreateSqmQtaTgtVvdCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			istCnt = Integer.toString(result);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return istCnt;
	}
	
	/**
	 * ESM_SQM_0504 : [MULTI01]<br>
	 * [KPI Creation & Edit]을 [생성] 합니다.<br>
	 * SQM_SPCL_TGT_VVD -> SQM_SPCL_CFM_QTA
	 *
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @throws DAOException
	 */
	public String createKpiCreationEdit(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		String istCnt = null;
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			param.put("usr_id", usrId);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AdjustmentDBDAOCreateKpiCreationEditCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			istCnt = Integer.toString(result);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return istCnt;
	}
	
	/**
	 * ESM_SQM_0504 : [MULTI02]<br>
	 * [1Q Data]을 [Transfer] 합니다.<br>
	 * SQM_QTA_TGT_VVD -> SQM_SPCL_TGT_VVD
	 *
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @throws DAOException
	 */
	public String createSqmQtaTgtVvdTrans(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		String istCnt = null;
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			param.put("usr_id", usrId);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AdjustmentDBDAOCreateSqmQtaTgtVvdTransCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			istCnt = Integer.toString(result);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return istCnt;
	}
	
	/**
	 * ESM_SQM_0504 : [MULTI02]<br>
	 * [1Q Data]을 [Transfer] 합니다.<br>
	 * SQM_SPCL_TGT_VVD -> SQM_SPCL_CFM_QTA
	 *
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @throws DAOException
	 */
	public String createKpiCreationEditTrans(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		String istCnt = null;
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			param.put("usr_id", usrId);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AdjustmentDBDAOCreateKpiCreationEditTransCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			istCnt = Integer.toString(result);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return istCnt;
	}
	
	/**
	 * ESM_SQM_0505 : [SEARCH]<br>
	 * [KPI Creation & Edit New Lane Add History]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SqmSpclNewLaneVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SqmSpclNewLaneVO> searchKpiCreationEditNewLaneHis(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SqmSpclNewLaneVO> list = null;
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new AdjustmentDBDAOSearchKpiCreationEditNewLaneHisRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SqmSpclNewLaneVO .class);
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
	 * ESM_SQM_0505 : [MULTI]<br>
	 * [KPI Creation & Edit New Lane Add]을 [생성] 합니다.<br>
	 * MAS_MON_VVD -> SQM_SPCL_TGT_VVD VVD Insert
	 *
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @throws DAOException
	 */
	public String createKpiCreationEditNewLaneTgtVvd(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		String istCnt = null;
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			param.put("usr_id", usrId);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AdjustmentDBDAOCreateKpiCreationEditNewLaneTgtVvdCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			istCnt = Integer.toString(result);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return istCnt;
	}
	
	/**
	 * ESM_SQM_0505 : [MULTI]<br>
	 * [KPI Creation & Edit New Lane Add]을 [생성] 합니다.<br>
	 * SQM_SPCL_CFM_QTA -> SQM_SPCL_NEW_LANE에 DATA 생성
	 *
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @throws DAOException
	 */
	public String createKpiCreationEditNewLaneSpclNewLane(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		String istCnt = null;
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			param.put("usr_id", usrId);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AdjustmentDBDAOCreateKpiCreationEditNewLaneSpclNewLaneCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			istCnt = Integer.toString(result);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return istCnt;
	}
	
	/**
	 * ESM_SQM_0505 : [MULTI]<br>
	 * [KPI Creation & Edit New Lane Add]을 [생성] 합니다.<br>
	 * SQM_SPCL_CFM_QTA에 SQM_SPCL_TGT_VVD와 SQM_SPCL_NEW_LANE조인하여 Insert			
	 *
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @return String
	 * @throws DAOException
	 */
	public String createKpiCreationEditNewLane(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		String istCnt = null;
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			param.put("usr_id", usrId);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			result = sqlExe.executeUpdate((ISQLTemplate)new AdjustmentDBDAOCreateKpiCreationEditNewLaneCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
			istCnt = Integer.toString(result);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return istCnt;
	}
	
	/**
	 * ESM_SQM_0505 : [SEARCH01]<br>
	 * [KPI Creation & Edit New Lane Add] 팝업 내 New Lane 입력시 Bound를 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchNewLaneAddBound(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		String tBound = "";
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new AdjustmentDBDAOSearchNewLaneAddBoundRSQL(), param, velParam);
			
			if(dbRowset != null){
				if(dbRowset.next()){
					tBound = dbRowset.getString(1);
				}
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return tBound;
	}
	
	/**
	 * ESM_SQM_0506 : [SEARCH]<br>
	 * [KPI Creation & Edit New Office Add History]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchKpiCreationEditNewOfcHisVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchKpiCreationEditNewOfcHisVO> searchKpiCreationEditNewOfcHis(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchKpiCreationEditNewOfcHisVO> list = null;
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new AdjustmentDBDAOSearchKpiCreationEditNewOfcHisRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchKpiCreationEditNewOfcHisVO .class);
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
	 * ESM_SQM_0506 : [MULTI]<br>
	 * [KPI Creation & Edit New Office]을 [생성] 합니다.<br>
	 * 
	 * @param List<SqmSpclNewOfcVO> insertVoList
	 * @throws DAOException
	 */
	public void insertKpiCreationEditNewOfc(List<SqmSpclNewOfcVO> insertVoList) throws DAOException,Exception {
		int istCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			if(insertVoList.size() > 0){
				istCnt = sqlExe.executeBatch((ISQLTemplate)new AdjustmentDBDAOAddKpiCreationEditNewOfcCSQL(), insertVoList, null, null);
				for(int i = 0; i < istCnt.length; i++){
					if(istCnt[i]== Statement.EXECUTE_FAILED)
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
	 * ESM_SQM_0506 : [MULTI]<br>
	 * [KPI Creation & Edit New Office]을 [Update] 합니다.<br>
	 * 
	 * @param List<SqmSpclNewOfcVO> updateVoList
	 * @throws DAOException
	 */
	public void updateKpiCreationEditNewOfc(List<SqmSpclNewOfcVO> updateVoList) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AdjustmentDBDAOUpdateKpiCreationEditNewOfcUSQL(), updateVoList, null, null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * ESM_SQM_0506 : [MULTI]<br>
	 * [KPI Creation & Edit New Office]을 [생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param List<SqmSpclNewOfcVO> insertVoList
	 * @throws DAOException
	 */
	public void insertKpiCreationEditNewOfcCfmQta(ConditionVO conditionVO, List<SqmSpclNewOfcVO> insertVoList) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int[] istCnt = null;
		try {
			Map<String, String> mapVO = conditionVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			if(insertVoList.size() > 0){
				istCnt = sqlExe.executeBatch((ISQLTemplate)new AdjustmentDBDAOAddKpiCreationEditNewOfcCfmQtaCSQL(), insertVoList, param, velParam);
				for(int i = 0; i < istCnt.length; i++){
					if(istCnt[i]== Statement.EXECUTE_FAILED)
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
	 * ESM_SQM_0508 : [SEARCH]<br>
	 * [Current KPI Report]을 [조회]합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchCurrentKpiReportVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCurrentKpiReportVO> searchCurrentKpiReport(ConditionVO conditionVO, String excelFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCurrentKpiReportVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				velParam.put("excel_flg", excelFlg);
			}			
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new AdjustmentDBDAOSearchCurrentKpiReportRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCurrentKpiReportVO .class);
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
	 * ESM_SQM_0508 : [SEARCH02]<br>
	 * [Current KPI Report]을 [조회]합니다. (PreviousVersion)<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchCurrentKpiReportVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCurrentKpiReportVO> searchCurrentKpiReportPreviousVersion(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCurrentKpiReportVO> list = null;
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new AdjustmentDBDAOSearchCurrentKpiReportPreviousVersionRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCurrentKpiReportVO .class);
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
	 * ESM_SQM_0507 : Retrieve 이벤트 처리
	 * [SKD Adjustment by VVD]의 [Data Count] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchQtaAdjustmentListCnt(ConditionVO conditionVO) throws DAOException {
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new AdjustmentDBDAOSearchQtaAdjustmentListCntRSQL(), param, velParam);
			
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
	 * ESM_SQM_0507 : Retrieve 이벤트 처리<br>
	 * [SKD Adjustment by VVD]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String ofc_cd
	 * @param String fCondTp
	 * @return List<SearchQtaAdjustmentListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchQtaAdjustmentListVO> searchQtaAdjustmentList(ConditionVO conditionVO, String ofc_cd, String fCondTp) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchQtaAdjustmentListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				
				param.putAll(mapVO);
				param.put("f_team_cd", ofc_cd);
				velParam.putAll(mapVO);
				velParam.put("f_cond_tp", fCondTp);
			}
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new AdjustmentDBDAOSearchQtaAdjustmentListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchQtaAdjustmentListVO .class);
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
	 * ESM_SQM_0507 : MULTI<br>
	 * [SKD Adjustment by VVD]을 [삭제] 합니다.<br>
	 * 
	 * @param List<ManageQtaAdjustmentVO> delModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeSpclCfmQta(List<ManageQtaAdjustmentVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = delModels.get(0).getColumnValues();
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AdjustmentDBDAORemoveSpclCfmQtaDSQL(), delModels, velParam);
				
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
	 * ESM_SQM_0507 : MULTI<br>
	 * [SKD Adjustment by VVD]을 [삭제] 합니다.<br>
	 * 
	 * @param List<ManageQtaAdjustmentVO> delModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeSpclTgtVvd(List<ManageQtaAdjustmentVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = delModels.get(0).getColumnValues();
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AdjustmentDBDAORemoveSpclTgtVvdDSQL(), delModels, velParam);
				
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
	 * ESM_SQM_0507 : MULTI<br>
	 * [SKD Adjustment by VVD]을 [추가] 합니다.<br>
	 * 
	 * @param List<ManageQtaAdjustmentVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addSpclTgtVvd(List<ManageQtaAdjustmentVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AdjustmentDBDAOAddSpclTgtVvdCSQL(), insModels, null);
				
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
	 * ESM_SQM_0507 : MULTI<br>
	 * [SKD Adjustment by VVD]을 [추가] 합니다.<br>
	 * 
	 * @param List<ManageQtaAdjustmentVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addSpclCfmQta(List<ManageQtaAdjustmentVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AdjustmentDBDAOAddSpclCfmQtaCSQL(), insModels, null);
				
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
	 * ESM_SQM_0507 : MULTI<br>
	 * [SKD Adjustment by VVD]을 [수정] 합니다.<br>
	 * 
	 * @param List<ManageQtaAdjustmentVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateSpclTgtVvd(List<ManageQtaAdjustmentVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = updModels.get(0) .getColumnValues();
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AdjustmentDBDAOUpdateSpclTgtVvdUSQL(), updModels, velParam);
				
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * ESM_SQM_0507 : [MULTI]<br>
	 * [SKD Adjustment by VVD] 에서 확정데이터를 '0' 으로 [수정] 합니다
	 * 
	 * @param List<ManageQtaAdjustmentVO> updateVoList
	 * @throws DAOException
	 */
	public void updateSpclQtaZero(List<ManageQtaAdjustmentVO> updateVoList) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			if(updateVoList.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AdjustmentDBDAOUpdateSpclQtaZeroUSQL(), updateVoList, null, null);
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
	 * ESM_SQM_0509 : [SEARCH]<br>
	 * [Reefer/Special Type/Size Master]을 [조회]합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchReeferSpclTpSzMgmtVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchReeferSpclTpSzMgmtVO> searchReeferSpclTpSzMgmt(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchReeferSpclTpSzMgmtVO> list = null;
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new AdjustmentDBDAOSearchReeferSpclTpSzMgmtRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchReeferSpclTpSzMgmtVO .class);
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
	 * ESM_SQM_0509 : [SAVE]<br>
	 * [Reefer/Special Type/Size Master]을 [저장]합니다.
	 * 
	 * @param List<SearchReeferSpclTpSzMgmtVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addReeferSpclTpSzMgmt(List<SearchReeferSpclTpSzMgmtVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AdjustmentDBDAOAddReeferSpclTpSzMgmtCSQL(), insModels,null);
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
	 * ESM_SQM_0509 : [SAVE]<br>
	 * [Reefer/Special Type/Size Master]을 [저장]합니다.
	 * 
	 * @param List<SearchReeferSpclTpSzMgmtVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateReeferSpclTpSzMgmt(List<SearchReeferSpclTpSzMgmtVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AdjustmentDBDAOUpdateReeferSpclTpSzMgmtUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to upadte No"+ i + " SQL");
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