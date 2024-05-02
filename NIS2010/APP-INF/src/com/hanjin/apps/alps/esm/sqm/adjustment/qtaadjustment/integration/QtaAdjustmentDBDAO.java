/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : QtaAdjustmentDBDAO.java
*@FileTitle      : QtaAdjustment
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.12.27
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.05.30 SQM USER 
* 1.0 Creation
* 2013.10.21 PEJ [CHM-201327263] Figure Inquiry  조회 팝업 추가
*                        searchPotnFigureInquiryList 메소드 추가
* 2013.12.10 PEJ [CHM-201328059] QTA Edit_IAS Office Add 팝업 추가
* 2013.12.27 이혜민 선조치 SQM 데이터 조회시 현재날짜와 조건날짜 비교하여 다른 테이블에서 조회되도록 수정
* 2014.01.16 박은주 [선조치] Allocation = QTA Adjustment 의 Apply 시 적용한 VVD 중 Allocation 정보가 반영되지 않은 Office 들에 대해서
*                                     Load = 0, Status = A 로 변경시켜 주는 로직 추가
* 2014.07.09 이혜민 [CHM-201430927] Office Add 추가 오류 확인 - overall 데이터 싱크를 위해 삭제 후 삽입시 삭제카운트가 0 이면 에러났던 것 수정
* 2014.09.25 이혜민 [CHM-201431935] Portion Adjustment 화면의 From, TO VVD 입력 시 Portion Connected <> 'I' 인 VVD alert.
* 2015.01.22 이혜민 [CHM-201533664] Allocation = QTA Apply시 Planned Load 기준 수정
* 2015.02.23 이혜민 [CHM-201534159] Alloc = QTA 화면 내 Alloc Delete 기능 추가
* 2015.05.15 이혜민 [CHM-201535563] Portion Adjustment 화면 내 Figure Inquiry H/O와 RHQ로 분리
* 2015.05.15 이혜민 [CHM-201535608] Adjustment 화면 3개 Creation전 RHQ별 Portion 존재하고, 
									Office portion이 없는 List 조회.
* 2015.07.22 김용습 [CHM-201537172] [CSR 전환건] QTA Adjustment by VVD 화면 내 신규 기능 추가
* 2015.10.01 김용습 [CHM-201537934] [CSR 전환건] Allocation = QTA의 "SPC Alloc Apply" 로직 수정
* 2015.10.06 김용습 [CHM-201538196] Portion Adjustment by RHQ, Head Office 화면 내 해당 분기 값만 입력 가능토록 Validation 설정
* 2015.12.09 김용습 [CHM-201539254] VVD Adjustment, VVD Adjustment for IAS Sector에서 Currently Updated에서 BSA 매뉴얼로 수정가능하도록 로직 수정.
* 2016.01.15 CHM-201639770 VVD Adjustment의 Update Option 추가 CSR
* 2016.02.05 최성민 [CHM-201639787] SQM Planning 도중 & Planning 완료 후 노선, P/F Group, Sector 추가 로직 Process 변경
* 2016.03.23 CHM-201640708 Office별 포션 자동 입력 로직 수정
* 2016.04.22 CHM-201641278 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
* 2016.07.15 CHM-201642546 Allocation = QTA Adjustment 화면 Office Add 버튼 추가
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.basic.QtaAdjustmentBCImpl;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.ManageQtaAdjustmentVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.ManageQtaEditIasSectorVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchAllocQtaListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchLaneOfficeListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchPotnAdjustmentListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchPotnFigureInquiryListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchQtaAdjustmentForSectorListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchQtaAdjustmentListVO;
import com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.vo.SearchQtaEditListVO;
import com.hanjin.apps.alps.esm.sqm.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.sqm.planning.planning.integration.PlanningDBDAOUpdateQtaLoadRevForSectorAddBSAGroupUSQL;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.SqmAlocQtaVO;
import com.hanjin.syscommon.common.table.SqmCfmQtaVO;
import com.hanjin.syscommon.common.table.SqmSctrCfmQtaVO;

/**
 * ALPS QtaAdjustmentDBDAO <br>
 * - ALPS-QtaAdjustment system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author SQM USER
 * @see QtaAdjustmentBCImpl 참조
 * @since J2EE 1.6
 */
public class QtaAdjustmentDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ESM_SQM_0031 : Retrieve 이벤트 처리<br>
	 * [QTA Adjustment by VVD]의 [Data Count] 합니다.
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchQtaAdjustmentListCntRSQL(), param, velParam);
			
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
	 * ESM_SQM_0031 : Retrieve 이벤트 처리<br>
	 * [QTA Adjustment by VVD]을 [조회] 합니다.
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchQtaAdjustmentListRSQL(), param, velParam);
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
	 * ESM_SQM_0031 : SEARCH03 이벤트 처리<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param String ofc_cd
	 * @return List<SearchQtaAdjustmentListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchQtaAdjustmentListVO> findVvdFromOtherQuarter(ConditionVO conditionVO, String ofc_cd) throws DAOException {
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
			}
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOFindVvdFromOtherQuarterRSQL(), param, velParam);
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
	 * ESM_SQM_0031 : COMMAND02 이벤트 처리<br>
	 * [QTA Adjustment by VVD]와 [Portion adjustment by Head Office]와의 결과 비교
	 * 
	 * @param ConditionVO conditionVO
	 * @param String ofc_cd
	 * @param String fCondTp
	 * @return List<SearchQtaAdjustmentListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchQtaAdjustmentListVO> comparisonWithHo(ConditionVO conditionVO, String ofc_cd, String fCondTp) throws DAOException {
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
			
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOCompareWithHORSQL(), param, velParam);
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
	 * ESM_SQM_0031 : COMMAND03 이벤트 처리<br>
	 * [QTA Adjustment by VVD]와 [Portion adjustment by RHQ]와의 결과 비교
	 * 
	 * @param ConditionVO conditionVO
	 * @param String ofc_cd
	 * @param String fCondTp
	 * @return List<SearchQtaAdjustmentListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchQtaAdjustmentListVO> comparisonWithRhq(ConditionVO conditionVO, String ofc_cd, String fCondTp) throws DAOException {
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
			
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOCompareWithRHQRSQL(), param, velParam);
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
	 * ESM_SQM_0031 : MULTI<br>
	 * [QTA Adjustment by VVD]을 [추가] 합니다.<br>
	 * 
	 * @param List<ManageQtaAdjustmentVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCfmTgtVvd(List<ManageQtaAdjustmentVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOAddCfmTgtVvdCSQL(), insModels, null);
				
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
	 * ESM_SQM_0031 : MULTI<br>
	 * [QTA Adjustment by VVD]을 [복사] 합니다.<br>
	 * 
	 * @param List<ManageQtaAdjustmentVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void copyCfmTgtVvd(List<ManageQtaAdjustmentVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOCopyCfmTgtVvdCSQL(), insModels, null);
				
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
	 * ESM_SQM_0031 : MULTI<br>
	 * [QTA Adjustment by VVD]을 [추가] 합니다.<br>
	 * 
	 * @param List<ManageQtaAdjustmentVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCfmQta(List<ManageQtaAdjustmentVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			Map<String, String> mapVO = insModels.get(0) .getColumnValues();
			velParam.putAll(mapVO);
			
			velParam.put("f_gubun", "VVD"); 
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");		
			
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOCreatePotnAdjustmentCSQL(), insModels, velParam);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
					if (insCnt[i] == 0)
						throw new EventException(new ErrorHandler("SQM00003").getMessage());
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
	 * ESM_SQM_0031 : MULTI<br>
	 * [QTA Adjustment by VVD]을 [복사] 합니다.<br>
	 * 
	 * @param List<ManageQtaAdjustmentVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void copyCfmQta(List<ManageQtaAdjustmentVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOCopyCfmQtaCSQL(), insModels, null);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
					if (insCnt[i] == 0)
						throw new EventException(new ErrorHandler("SQM00003").getMessage());
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
	 * ESM_SQM_0031 : MULTI<br>
	 * [QTA Adjustment by VVD]을 [삭제] 합니다.<br>
	 * 
	 * @param List<ManageQtaAdjustmentVO> delModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeCfmQta(List<ManageQtaAdjustmentVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = delModels.get(0).getColumnValues();
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAORemovePotnAdjustmentDSQL(), delModels, velParam);
				
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
	 * QTA adjustment by VVD for IAS Sector에서 VVD 데이터 삭제할 때 20162Q까지만 작동하는 로직
	 * 
	 * @param List<ManageQtaAdjustmentVO> delModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeCfmQta2(List<ManageQtaAdjustmentVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = delModels.get(0).getColumnValues();
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAORemovePotnAdjustment2DSQL(), delModels, velParam);
				
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
	 * ESM_SQM_0031 : MULTI<br>
	 * [QTA Adjustment by VVD]을 [삭제] 합니다.<br>
	 * 
	 * @param List<ManageQtaAdjustmentVO> delModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeCfmTgtVvd(List<ManageQtaAdjustmentVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = delModels.get(0) .getColumnValues();
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAORemoveCfmTgtVvdDSQL(), delModels, velParam);
				
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
	 * ESM_SQM_0031 : MULTI<br>
	 * [QTA Adjustment by VVD]을 [수정] 합니다.<br>
	 * 
	 * @param List<ManageQtaAdjustmentVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateCfmTgtVvd(List<ManageQtaAdjustmentVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = updModels.get(0) .getColumnValues();
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOUpdateCfmTgtVvdUSQL(), updModels, velParam);
				
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
	 * ESM_SQM_0031 : MULTI<br>
	 * [QTA Adjustment by VVD]을 [추가] 합니다.<br>
	 * 
	 * @param List<ManageQtaAdjustmentVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCfmTgtVvdAdj(List<ManageQtaAdjustmentVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOAddCfmTgtVvdAdjCSQL(), insModels, null);
				
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
	 * ESM_SQM_0031 : MULTI<br>
	 * [QTA Adjustment by VVD]을 [수정] 합니다.<br>
	 * 
	 * @param List<ManageQtaAdjustmentVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateCfmQta(List<ManageQtaAdjustmentVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = updModels.get(0) .getColumnValues();
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOUpdateCfmQtaUSQL(), updModels, velParam);
				
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
	 * ESM_SQM_0031 : MULTI<br>
	 * [QTA Adjustment by VVD]을 [수정] 합니다.
	 * Supply Portion 적용하여 만든 CFM QTA 를 Smry 하여 TGT VVD 에 반영
	 * 
	 * @param List<ManageQtaAdjustmentVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateCfmTgtVvdSmry(List<ManageQtaAdjustmentVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = updModels.get(0) .getColumnValues();
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOUpdateCfmTgtVvdSmryUSQL(), updModels, velParam);
				
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
	 * ESM_SQM_0031: MULTI01, ESM_SQM_0219 :MULTI02<br>
	 * [QTA Adjustment by VVD, QTA Adjustment by VVD FOR SECTOR]을 [저장] 합니다.<br>
	 * 
	 * @param List<ManageQtaAdjustmentVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void saveSupply(List<ManageQtaAdjustmentVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = updModels.get(0) .getColumnValues();
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOUpdateCfmTgtVvdSupplyUSQL(), updModels, velParam);
				
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
	 * ESM_SQM_0031,0032,0033 : Creation 이벤트 처리<br>
	 * Adjustment화면에서 Creation 전 RHQ에는 Portion을 부여했으나 해당 RHQ 산하의 Office에게 Portion을 부여하지 않은 RHQ List를 조회합니다.
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
               if (!JSPUtil.getNull(conditionVO.getFRlaneCd()).equals("") && !JSPUtil.getNull(conditionVO.getFRlaneCd()).equals("All")) {
            	   conditionVO.setFRlaneCd("'" + conditionVO.getFRlaneCd().replaceAll("," ,"','") +"'");
				}
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchOfcZeroPortionRSQL(), param, velParam);
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
	 * ESM_SQM_0032 : [이벤트]<br>
	 * [Portion Adjustment]을 [조회] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchPotnAdjustmentListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchPotnAdjustmentListVO> searchPotnAdjustmentList(ConditionVO conditionVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchPotnAdjustmentListVO> list = null;
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
				param.put("ofc_cd", account.getOfc_cd()); 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchPotnAdjustmentListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPotnAdjustmentListVO .class);
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
	 * ESM_SQM_0032 : [이벤트]<br>
	 * [Portion Adjustment]을 [업데이트] 합니다.<br>
	 * @param List<SearchPotnAdjustmentListVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updatePotnAdjustment(List<SearchPotnAdjustmentListVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOUpdatemanagePotnAdjustmentUSQL(), updModels,null);
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
	 * ESM_SQM_0032 : [이벤트]<br>
	 * [Portion Adjustment]을 [추가] 합니다.<br>
	 * 
	 * @param List<SearchPotnAdjustmentListVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addPotnAdjustment(List<SearchPotnAdjustmentListVO> updModels) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(updModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOAddPotnAdjustmentCSQL(), updModels, null);
				
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
	 * ESM_SQM_0032 : MULTI02 이벤트 처리<br>
	 * [Portion Adjustment by Head Office]를 [생성] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchPotnAdjustmentListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchPotnAdjustmentListVO> searchRhqGroupRowAdd(ConditionVO conditionVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchPotnAdjustmentListVO> list = null;
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
				param.put("ofc_cd", account.getOfc_cd()); 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchRhqGroupRowAddRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPotnAdjustmentListVO .class);
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
	 * ESM_SQM_0032 : SEARCH01 이벤트 처리<br>
	 * [Portion Adjustment by Head Office]에서 vvd의 주차를 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String[] searchApplyWeek(ConditionVO conditionVO, String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		String[] dataCnt = new String[2];
		dataCnt[0] = "0";
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.put("vvd", vvd);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchApplyWeekRSQL(), param, velParam);
			
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
	 * ESM_SQM_0032 : SEARCH02 이벤트 처리<br>
	 * [Portion Adjustment by Head Office]에서 vvd 입력 시 해당 VVD가 Alloc 적용됐거나 QTA Edit에서 매뉴얼로 수정되었는지 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<String>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<String> searchVvdCngTpCd(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<String> vvdList = new ArrayList<String>();       
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchVvdCngTpCdRSQL(), param, velParam);
			if(dbRowset != null){
				while(dbRowset.next()){
					vvdList.add(dbRowset.getString(1));
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return vvdList;
	}
	
	/**
	 * ESM_SQM_0032,ESM_SQM_0033 : MULTI01 이벤트 처리<br>
	 * [Portion Adjustment]에서 확정데이터를 [재생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createPotnAdjustment(ConditionVO conditionVO, SignOnUserAccount account) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		Map<String, String> mapVO = null;		
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(conditionVO != null){
	               mapVO = conditionVO.getColumnValues();
	               param.putAll(mapVO);
	               velParam.putAll(mapVO);				
	               param.put("f_usr_id", account.getUsr_id());
	               param.put("ofc_cd", account.getOfc_cd());
			}
			
			int	insCnt = sqlExe.executeUpdate((ISQLTemplate)new QtaAdjustmentDBDAOCreatePotnAdjustmentCSQL(), param, velParam);
			
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
	 * ESM_SQM_0033 : MULTI01 이벤트 처리<br>
	 * [Portion Adjustment]에서 확정데이터를 [재생성] 합니다.<br>
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createPotnAdjustmentHo(ConditionVO conditionVO, SignOnUserAccount account) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		Map<String, String> mapVO = null;		
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(conditionVO != null){
	               mapVO = conditionVO.getColumnValues();
	               param.putAll(mapVO);
	               velParam.putAll(mapVO);				
	               param.put("f_usr_id", account.getUsr_id());
	               param.put("ofc_cd", "SELCSG"); // RHQ office에서 Portion Adjustment by RHQ에서 Creation할 때 HO레벨의 데이터까지 다시 제대로 생성되게 하기 위해서
	               
	               param.put("f_gubun", "HO"); //PORTION ADJUSTMENT BY RHQ에서 PORTION변경 후 PORTION ADJUSTMENY BY HO로직을 통해 데이터 재생성되어야만 데이터가 제대로 나오기 때문에 무조건 HO 생성로직을  
	               velParam.put("f_gubun", "HO");
			}
			
			int	insCnt = sqlExe.executeUpdate((ISQLTemplate)new QtaAdjustmentDBDAOCreatePotnAdjustmentCSQL(), param, velParam);
			
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
	 * ESM_SQM_0032,ESM_SQM_0033 : MULTI01 이벤트 처리<br>
	 * [Portion Adjustment]에서 확정데이터를 [삭제] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removePotnAdjustment(ConditionVO conditionVO, SignOnUserAccount account) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		Map<String, String> mapVO = null;
		
		try {
			if(conditionVO != null){
               if (!JSPUtil.getNull(conditionVO.getFRlaneCd()).equals("") && !JSPUtil.getNull(conditionVO.getFRlaneCd()).equals("All")) {
            	   conditionVO.setFRlaneCd("'" + conditionVO.getFRlaneCd().replaceAll("," ,"','") +"'");
				}
				mapVO = conditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("ofc_cd", account.getOfc_cd()); 
			}

			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new QtaAdjustmentDBDAORemovePotnAdjustmentDSQL(), param, velParam);

			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
		//	log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
		//	log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0032,ESM_SQM_0033 : MULTI01 이벤트 처리<br>
	 * [Portion Adjustment]에서 확정데이터를 [삭제] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removePotnAdjustmentAgain(ConditionVO conditionVO, SignOnUserAccount account) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		//parameter Setting
		Map<String, String> mapVO = null;
		
		try {
			if(conditionVO != null){
//               if (!JSPUtil.getNull(conditionVO.getFRlaneCd()).equals("") && !JSPUtil.getNull(conditionVO.getFRlaneCd()).equals("All")) {
//            	   conditionVO.setFRlaneCd("'" + conditionVO.getFRlaneCd().replaceAll("," ,"','") +"'");
//            	   conditionVO.setFRlaneCd(conditionVO.getFRlaneCd().replaceAll("," ,"','"));
//				}
				mapVO = conditionVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
//				param.put("ofc_cd", account.getOfc_cd()); 
				param.put("ofc_cd", "SELCSG"); 
				velParam.put("f_gubun", "HO"); 
				velParam.put("f_ob_div_cd", "All"); 
			}

			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new QtaAdjustmentDBDAORemovePotnAdjustmentDSQL(), param, velParam);

			if (delCnt == Statement.EXECUTE_FAILED) throw new DAOException(new ErrorHandler("COM12240").getMessage());
		} catch (SQLException se) {
		//	log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		} catch (Exception ex) {
		//	log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
	}
	
	/**
	 * ESM_SQM_0034 : Retrieve 이벤트 처리<br>
	 * [Qta Edit]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaEditListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchQtaEditListVO> searchQtaEditList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchQtaEditListVO> list = null;
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchQtaEditListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchQtaEditListVO .class);
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
	 * ESM_SQM_0034 : Retrieve 이벤트 처리<br>
	 * [Qta Edit]을을 [저장] 합니다.
	 * 
	 * @param List<SqmCfmQtaVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateQtaEdit(List<SqmCfmQtaVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOUpdateQtaEditUSQL(), updModels,null);
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
	 * ESM_SQM_0034 : MULTI01 이벤트 처리<br>
	 * [CMCB adjust]을을 [생성] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createCmcbAdjust(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
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
			int result = sqlExe.executeUpdate((ISQLTemplate)new QtaAdjustmentDBDAOCreateCmcbAdjustUSQL(), param, velParam);
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
	 * ESM_SQM_0035 : Retrieve 이벤트 처리<br>
	 * [Allocation = QTA Setting]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchAllocQtaListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchAllocQtaListVO> searchAllocQtaList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchAllocQtaListVO> list = null;
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchAllocQtaListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAllocQtaListVO .class);
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
	 * ESM_SQM_0035 : MULTI 이벤트 처리<br>
	 * [Allocation = QTA Setting]을 [업데이트] 합니다.
	 * 
	 * @param List<SqmAlocQtaVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateAllocQta(List<SqmAlocQtaVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOUpdateAllocQtaUSQL(), updModels,null);
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
	 * ESM_SQM_0035 : MULTI 이벤트 처리<br>
	 * [Allocation = QTA Setting]을 [추가] 합니다.
	 * 
	 * @param List<SqmAlocQtaVO> addModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addAllocQta(List<SqmAlocQtaVO> addModels) throws DAOException,Exception {
		int addCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			if(addModels.size() > 0){
				addCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOAddAllocQtaCSQL(), addModels,null);
				for(int i = 0; i < addCnt.length; i++){
					if(addCnt[i]== Statement.EXECUTE_FAILED)
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
	 * ESM_SQM_0035 : MULTI01 이벤트 처리
	 * Apply 당시 SQM_CFM_QTA 테이블의 LOD_QTY를 SQM_ALOC_QTA 테이블의 CFM_LOD_QTY 에 넣음
	 * @param List<SqmAlocQtaVO> updModels
	 * 
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateCfmQtaLodToAlocQta(List<SqmAlocQtaVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOUpdateCfmQtaLodToAlocQtaUSQL(), updModels,null);
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
	 * ESM_SQM_0035 : MULTI01 이벤트 처리
	 * Alloc=Qta Apply시 SQM_CFM_QTA의 Load를 변경한다.
	 * @param List<SqmAlocQtaVO> updModels
	 * 
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateQtaEditForAlloc(List<SqmAlocQtaVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOUpdateQtaEditForAllocUSQL(), updModels,null);
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
	 * ESM_SQM_0035 : MULTI03 이벤트 처리
	 * activate 실행시, 확정 데이터 생성
	 * @param List<SqmAlocQtaVO> updModels
	 * 
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createCfmData(List<SqmAlocQtaVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
				
			if(updModels.size() > 0){				
				updCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOCreateCfmDataCSQL(), updModels,null);
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
	 * [Allocation = QTA Setting]에서 MULTI03 실행시 Applied Flg를 Y로 변경
	 * @param List<SqmAlocQtaVO> updModels
	 * 
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateAppliedFlg(List<SqmAlocQtaVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOUpdateAplliedFlgUSQL(), updModels,null);
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
	 * [Allocation = QTA Setting]의 상태를  [업데이트] 합니다.
	 * @param List<SqmAlocQtaVO> updModels
	 * 
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateAllocForStaus(List<SqmAlocQtaVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOUpdateAllocForStausUSQL(), updModels,null);
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
		 * [Allocation = QTA Setting] 적용되지 않은 [확정쿼타]의 Load와 상태를  [업데이트] 합니다.
		 * @param List<SqmAlocQtaVO> updModels
		 * 
		 * @throws DAOException
		 * @throws Exception
		 */
		public void updateCfmQtaZeroStatus(List<SqmAlocQtaVO> updModels) throws DAOException,Exception {
			int updCnt[] = null;
			try {
				SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
				if(updModels.size() > 0){
					updCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOUpdateCfmQtaZeroStatusUSQL(), updModels,null);
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
	 * ESM_SQM_0034 : MULTI 이벤트 처리<br>
	 * [Qta Edit]의 change type을 [저장] 합니다.
	 * 
	 * @param List<SqmCfmQtaVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateCfmQtaStatus(List<SqmCfmQtaVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOUpdateCfmQtaStatusUSQL(), updModels,null);
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
	 * ESM_SQM_0035 : MULTI02 이벤트 처리<br>
	 * [Allocation = QTA Setting]을 [delete] 합니다.
	 * 
	 * @param List<SqmAlocQtaVO> delModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void deleteQtaEditForAlloc(List<SqmAlocQtaVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAODeleteQtaEditForAllocDSQL(), delModels,null);
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
	 * SPC ALOC 정보를 I/F.
	 * 
	 * @param String trd_cd
	 * @param String rlane_cd
	 * @param String vvd
	 * @param String usr_id
	 * @throws DAOException
	 * @throws Exception
	 */
	public void manageSpcAlocIf(String trd_cd, String rlane_cd, String vvd, String usr_id) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("trd_cd", trd_cd);
			param.put("rlane_cd", rlane_cd);
			param.put("vvd", vvd);
			param.put("usr_id", usr_id);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new QtaAdjustmentDBDAOManageSpcAlocIfCSQL(), param, param);
			
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
	 * ESM_SQM_0043 : Retrieve 이벤트 처리<br>
	 * [Figure Inquiry]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchPotnFigureInquiryListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchPotnFigureInquiryListVO> searchHOPotnFigureInquiryList(ConditionVO conditionVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchPotnFigureInquiryListVO> list = null;
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
				param.put("ofc_cd", account.getOfc_cd()); 
				velParam.put("ofc_cd", account.getOfc_cd()); 
			}
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchHOPotnFigureInquiryListRSQL(), param, velParam);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPotnFigureInquiryListVO .class);
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
	 * ESM_SQM_0044 : Retrieve 이벤트 처리<br>
	 * [Figure Inquiry]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchPotnFigureInquiryListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchPotnFigureInquiryListVO> searchRHQPotnFigureInquiryList(ConditionVO conditionVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchPotnFigureInquiryListVO> list = null;
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
				param.put("ofc_cd", account.getOfc_cd()); 
				velParam.put("ofc_cd", account.getOfc_cd()); 
			}
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchRHQPotnFigureInquiryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchPotnFigureInquiryListVO .class);
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
	 * ESM_SQM_0045 : Retrieve 이벤트 처리<br>
	 *  [IAS Lane Office List]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param SignOnUserAccount account
	 * @return List<SearchPotnFigureInquiryListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchLaneOfficeListVO> searchLaneOfficeList(ConditionVO conditionVO, SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchLaneOfficeListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("ofc_cd", account.getOfc_cd()); 
				velParam.put("ofc_cd", account.getOfc_cd()); 
			}
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchLaneOfficeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchLaneOfficeListVO .class);
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
	 * ESM_SQM_0045 : MULTI02 이벤트 처리<br>
	 *  [IAS QTA Office Add]을 [생성] 합니다.<br>
	 * 
	 * @param updModels List<SearchLaneOfficeListVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createQtaOfficeAdd(List<SearchLaneOfficeListVO> updModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			if(updModels.size() > 0){
					insCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOCreateQtaOfficeAddCSQL(), updModels, null);
					
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
	 * ESM_SQM_0045 : 이벤트 처리<br>
	 * [IAS Office Add Creation]의 [Creation] 후 확정 데이터의 상태를 변경한다.
	 * 
	 * @param conditionVO ConditionVO 
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateCfmQtaStatusLane(ConditionVO conditionVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
				
		try {
			if(conditionVO != null){
				Map<String, String> mapVO = conditionVO .getColumnValues();
				param.putAll(mapVO);
			}
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new QtaAdjustmentDBDAOUpdateCfmQtaStatusLaneUSQL(), param, null);
			
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
	 * ESM_SQM_0219 : Retrieve 이벤트 처리<br>
	 * [QTA Adjustment by VVD For Sector]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaAdjustmentForSectorListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchQtaAdjustmentForSectorListVO> searchQtaAdjustmentForSectorList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchQtaAdjustmentForSectorListVO> list = null;
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchQtaAdjustmentForSectorListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchQtaAdjustmentForSectorListVO .class);
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
	 * ESM_SQM_0219 : MULTI01<br>
	 * [QTA Adjustment by VVD For Secter]을 [복사] 합니다.<br>
	 * 
	 * @param List<ManageQtaAdjustmentVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void copyCfmQtaForSector(List<ManageQtaAdjustmentVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOCopyCfmQtaForSectorCSQL(), insModels, null);
				
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
	 * ESM_SQM_0219 : MULTI01<br>
	 * [QTA Adjustment by VVD For Secter]을 [복사] 합니다.<br>
	 * 
	 * @param List<ManageQtaAdjustmentVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void copyCfmQtaForSectorPFGroup(List<ManageQtaAdjustmentVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOCopyCfmQtaForSectorUSQL(), insModels, null);
				
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
	 * ESM_SQM_0219 : MULTI01<br>
	 * [QTA Adjustment by VVD For Sector] : [SQM_CFM_QTA]의 데이터를 [수정] 합니다.<br>
	 * 
	 * @param List<ManageQtaAdjustmentVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void insertCfmQtaSync(List<ManageQtaAdjustmentVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = updModels.get(0) .getColumnValues();
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOUpdateCfmQtaSyncUSQL(), updModels, velParam);
				
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
	 * ESM_SQM_0219 : MULTI01<br>
	 * [QTA Adjustment by VVD For Sector] : [SQM_SCTR_CFM_QTA]의 데이터를 [삭제] 합니다.<br>
	 * 
	 * @param List<ManageQtaAdjustmentVO> delModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeCfmQtaForSector(List<ManageQtaAdjustmentVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = delModels.get(0).getColumnValues();
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAORemoveCfmQtaForSectorDSQL(), delModels, velParam);
				
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
	 * OVERALL쪽에서 확정 데이터 지웠을 때 이에 연결되는 SECTOR쪽 확정 데이터도 지우는 쿼리 (20163Q 데이터 부터 적용됨)
	 * 
	 * @param List<ManageQtaAdjustmentVO> delModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeCfmQtaForSector2(List<ManageQtaAdjustmentVO> delModels) throws DAOException,Exception {
		int delCnt[] = null;
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = delModels.get(0).getColumnValues();
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAORemoveCfmQtaForSector2DSQL(), delModels, velParam);
				
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
	 * ESM_SQM_0219 : MULTI01<br>
	 * [QTA Adjustment by VVD For Sector] : [SQM_SCTR_CFM_QTA]의 [LOAD=0]로 [수정] 합니다.<br>
	 * 
	 * @param List<ManageQtaAdjustmentVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateCfmQtaForSectorZero(List<ManageQtaAdjustmentVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			Map<String, String> mapVO = updModels.get(0) .getColumnValues();
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOUpdateCfmQtaForSectorZeroUSQL(), updModels, velParam);
				
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
	 * ESM_SQM_0220 : Retrieve 이벤트 처리<br>
	 * [Qta Edit for IAS Sector]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaEditListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchQtaEditListVO> searchQtaEditIasSectorList(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchQtaEditListVO> list = null;
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchQtaEditIasSectorListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchQtaEditListVO .class);
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
	 * ESM_SQM_0220 : MULTI 이벤트 처리<br>
	 * [Qta Edit for IAS Sector]을 [저장] 합니다.
	 * 
	 * @param List<SqmSctrCfmQtaVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateQtaEditIasSector(List<SqmSctrCfmQtaVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOUpdateQtaEditIasSectorUSQL(), updModels,null);
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
	 * ESM_SQM_0220 : MULTI 이벤트 처리<br>
	 * [Qta Edit for IAS Sector]을 [저장] 합니다.
	 * SQM_CFM_QTA Delete overall report에서 조회되도록
	 * 
	 * @param SqmSctrCfmQtaVO sqmSctrCfmQtaVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeCfmQtaIasSector(SqmSctrCfmQtaVO sqmSctrCfmQtaVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = sqmSctrCfmQtaVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new QtaAdjustmentDBDAORemoveCfmQtaIasSectorDSQL(), param, velParam);
//			if(result == 0){							
//				throw new EventException((String)new ErrorHandler("SQM00003", new String[]{}).getMessage());
//			}
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
	 * ESM_SQM_0220 : MULTI 이벤트 처리<br>
	 * [Qta Edit for IAS Sector]을 [저장] 합니다.
	 * SQM_CFM_QTA Insert (overall report에서 조회되도록)
	 * 
	 * @param SqmSctrCfmQtaVO sqmSctrCfmQtaVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCfmQtaIasSector(SqmSctrCfmQtaVO sqmSctrCfmQtaVO) throws DAOException,Exception {	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = sqmSctrCfmQtaVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			int result = sqlExe.executeUpdate((ISQLTemplate)new QtaAdjustmentDBDAOAddCfmQtaIasSectorCSQL(), param, velParam);
//			if(result == 0){							
//				throw new EventException((String)new ErrorHandler("SQM00003", new String[]{}).getMessage());
//			}
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
	 * ESM_SQM_0220 : MULTI01 이벤트 처리<br>
	 * [CMCB adjust for IAS Sector]을 [생성] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createCmcbAdjustIasSector(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
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
			int result = sqlExe.executeUpdate((ISQLTemplate)new QtaAdjustmentDBDAOCreateCmcbAdjustIasSectorUSQL(), param, velParam);
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
	 * ESM_SQM_0220 : MULTI01 이벤트 처리<br>
	 * [CMCB adjust for IAS Sector]을 [생성] 합니다.
	 * SQM_CFM_QTA Delete (overall report에서 조회되도록)
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeCfmQtaIasSector2(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
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
			int result = sqlExe.executeUpdate((ISQLTemplate)new QtaAdjustmentDBDAORemoveCfmQtaIasSector2DSQL(), param, velParam);
//			if(result == 0){							
//				throw new EventException((String)new ErrorHandler("SQM00003", new String[]{}).getMessage());
//			}
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
	 * ESM_SQM_0220 : MULTI01 이벤트 처리<br>
	 * [CMCB adjust for IAS Sector]을 [생성] 합니다.
	 * SQM_CFM_QTA Insert (overall report에서 조회되도록)
	 * 
	 * @param ConditionVO conditionVO
	 * @param String usrId
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCfmQtaIasSector2(ConditionVO conditionVO, String usrId) throws DAOException,Exception {
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
			int result = sqlExe.executeUpdate((ISQLTemplate)new QtaAdjustmentDBDAOAddCfmQtaIasSector2CSQL(), param, velParam);
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
	 * ESM_SQM_0221 : Retrieve 이벤트 처리<br>
	 * [Qta Edit POL-POD Pair Add for IAS Sector]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaEditListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchQtaEditListVO> searchQtaEditPolPodPairAddIasSector(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchQtaEditListVO> list = null;
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchQtaEditPolPodPairAddIasSectorRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchQtaEditListVO .class);
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
	 * ESM_SQM_0221 : CREATION<br>
	 * [Qta Edit POL-POD Pair Add for IAS Sector]을 [생성] 합니다.
	 * 
	 * @param List<ManageQtaEditIasSectorVO> istModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createQtaEditPolPodPairAddIasSector(List<ManageQtaEditIasSectorVO> istModels) throws DAOException,Exception {
//		int istCnt[] = null;
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
//			if(istModels.size() > 0){
//				istCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOCreateQtaEditPolPodPairAddIasSectorCSQL(), istModels, null);
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
				int result = sqlExe.executeUpdate((ISQLTemplate)new QtaAdjustmentDBDAOCreateQtaEditPolPodPairAddIasSectorCSQL(), param, null);
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
	 * ESM_SQM_0222 : Retrieve 이벤트 처리<br>
	 * [Qta Edit Office Add for IAS Sector]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaEditListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchQtaEditListVO> searchQtaEditOfficeAddIasSector(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchQtaEditListVO> list = null;
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchQtaEditOfficeAddIasSectorRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchQtaEditListVO .class);
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
	 * ESM_SQM_0222 : CREATION<br>
	 * [Qta Edit Office Add for IAS Sector]을 [생성] 합니다.
	 * 
	 * @param List<ManageQtaEditIasSectorVO> istModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createQtaEditOfficeAddIasSector(List<ManageQtaEditIasSectorVO> istModels) throws DAOException,Exception {
//		int istCnt[] = null;
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
//			if(istModels.size() > 0){
//				istCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOCreateQtaEditOfficeAddIasSectorCSQL(), istModels, null);
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
				int result = sqlExe.executeUpdate((ISQLTemplate)new QtaAdjustmentDBDAOCreateQtaEditOfficeAddIasSectorCSQL(), param, null);
				if(result == Statement.EXECUTE_FAILED){							
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
	 * ESM_SQM_0222 : [Creation]<br>
	 * [Qta Edit Office Add for IAS Sector_Add Creatin] : [Target VVD]를  [생성] 합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @param List<ManageQtaEditIasSectorVO> addModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createQtaEditOfficeAddTargetVVD(ConditionVO conditionVO, List<ManageQtaEditIasSectorVO> addModels) throws DAOException,Exception {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			for(int i=0; i<addModels.size(); i++){
				Map<String, String> mapVO = addModels.get(i).getColumnValues();
				param.putAll(mapVO);
				param.put("f_fm_wk", conditionVO.getFFmWk());
				param.put("f_to_wk", conditionVO.getFToWk());
				int result = sqlExe.executeUpdate((ISQLTemplate)new QtaAdjustmentDBDAOAddTargetVVDCSQL(), param, null);
				if(result == Statement.EXECUTE_FAILED){							
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
	 * ESM_SQM_0222 : [Creation]<br>
	 * [Qta Edit Office Add for IAS Sector_Add Creatin] : [CFM Target VVD]를  [생성] 합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @param List<ManageQtaEditIasSectorVO> addModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createQtaEditOfficeAddSectorCfmTargetVVD(ConditionVO conditionVO, List<ManageQtaEditIasSectorVO> addModels) throws DAOException,Exception {

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			for(int i=0; i<addModels.size(); i++){
				Map<String, String> mapVO = addModels.get(i).getColumnValues();
				param.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new QtaAdjustmentDBDAOAddSectorCfmTargetVVDCSQL(), param, null);
				if(result == Statement.EXECUTE_FAILED){							
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
	 * ESM_SQM_0222 : [Creation]<br>
	 * [Qta Edit Office Add for IAS Sector_Add Creatin] : [BSA Group CAPA]를  [입력] 합니다.<br>
	 *
	 * @param ConditionVO conditionVO
	 * @param List<ManageQtaEditIasSectorVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateQtaEditOfficeTargetVVDBSAGroup(ConditionVO conditionVO, List<ManageQtaEditIasSectorVO> updModels) throws DAOException,Exception {
		int insCnt[] = null;
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			
			Map<String, String> mapVO = conditionVO.getColumnValues();
			velParam.putAll(mapVO);
			
			if(updModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new PlanningDBDAOUpdateQtaLoadRevForSectorAddBSAGroupUSQL(), updModels,velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
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
	 * ESM_SQM_0224 : Retrieve 이벤트 처리<br>
	 * [RBCCO PFMC = QTA Setting for IAS Sector]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @return List<SearchQtaEditListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchQtaEditListVO> searchRbccoPfmcQtaSetIasSector(ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchQtaEditListVO> list = null;
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
			dbRowset = new SQLExecuter("SQM_HJSBAT").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchRbccoPfmcQtaSetIasSectorRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchQtaEditListVO .class);
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
	 * ESM_SQM_0224 : Apply 이벤트 처리<br>
	 * [RBCCO PFMC = QTA Setting for IAS Sector]을 [Apply] 합니다.
	 * 
	 * @param List<SearchQtaEditListVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void manageRbccoPfmcQtaSetIasSector(List<SearchQtaEditListVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("SQM_HJSBAT");
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOUpdateRbccoPfmcQtaSetIasSectorUSQL(), updModels,null);
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
}