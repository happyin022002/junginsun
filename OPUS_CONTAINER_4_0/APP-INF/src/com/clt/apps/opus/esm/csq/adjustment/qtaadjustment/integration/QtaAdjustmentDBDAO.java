/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName       : QtaAdjustmentDBDAO.java
*@FileTitle      : QtaAdjustment
*Open Issues     :
*Change history  :
*@LastModifyDate : 2013.12.27
*@LastModifier   : 이혜민
*@LastVersion    : 1.0
* 2013.05.30 CSQ USER
* 1.0 Creation
* 2013.10.21 PEJ [CHM-201327263] Figure Inquiry  조회 팝업 추가
*                        searchPotnFigureInquiryList 메소드 추가
* 2013.12.10 PEJ [CHM-201328059] QTA Edit_IAS Office Add 팝업 추가
* 2013.12.27 이혜민 선조치 CSQ 데이터 조회시 현재날짜와 조건날짜 비교하여 다른 테이블에서 조회되도록 수정
* 2014.01.16 박은주 [선조치] Allocation = QTA Adjustment 의 Apply 시 적용한 VVD 중 Allocation 정보가 반영되지 않은 Office 들에 대해서
*                                     Load = 0, Status = A 로 변경시켜 주는 로직 추가
* 2014.07.09 이혜민 [CHM-201430927] Office Add 추가 오류 확인 - overall 데이터 싱크를 위해 삭제 후 삽입시 삭제카운트가 0 이면 에러났던 것 수정
* 2014.09.25 이혜민 [CHM-201431935] Portion Adjustment 화면의 From, TO VVD 입력 시 Portion Connected <> 'I' 인 VVD alert.
* 2015.01.22 이혜민 [CHM-201533664] Allocation = QTA Apply시 Planned Load 기준 수정
=========================================================*/
package com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.basic.QtaAdjustmentBCImpl;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.ManageQtaAdjustmentVO;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.ManageQtaEditIasSectorVO;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.SearchLaneOfficeListVO;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.SearchPotnAdjustmentListVO;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.SearchPotnFigureInquiryListVO;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.SearchQtaAdjustmentForSectorListVO;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.SearchQtaAdjustmentListVO;
import com.clt.apps.opus.esm.csq.adjustment.qtaadjustment.vo.SearchQtaEditListVO;
import com.clt.apps.opus.esm.csq.common.vo.ConditionVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.CsqCfmQtaVO;
import com.clt.syscommon.common.table.CsqSctrCfmQtaVO;

/**
 * ALPS QtaAdjustmentDBDAO <br>
 * - ALPS-QtaAdjustment system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author CSQ USER
 * @see QtaAdjustmentBCImpl 참조
 * @since J2EE 1.6
 */
public class QtaAdjustmentDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ESM_CSQ_0050 : Retrieve 이벤트 처리<br>
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchQtaAdjustmentListCntRSQL(), param, velParam);
			
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
	 * ESM_CSQ_0050 : Retrieve 이벤트 처리<br>
	 * [QTA Adjustment by VVD]을 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String ofc_cd
	 * @return List<SearchQtaAdjustmentListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchQtaAdjustmentListVO> searchQtaAdjustmentList(ConditionVO conditionVO, String ofc_cd) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchQtaAdjustmentListRSQL(), param, velParam);
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
	 * ESM_CSQ_0050 : MULTI<br>
	 * [QTA Adjustment by VVD]을 [추가] 합니다.<br>
	 * 
	 * @param List<ManageQtaAdjustmentVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCfmTgtVvd(List<ManageQtaAdjustmentVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
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
	 * ESM_CSQ_0050 : MULTI<br>
	 * [QTA Adjustment by VVD]을 [복사] 합니다.<br>
	 * 
	 * @param List<ManageQtaAdjustmentVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void copyCfmTgtVvd(List<ManageQtaAdjustmentVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
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
	 * ESM_CSQ_0050 : MULTI<br>
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOCreatePotnAdjustmentCSQL(), insModels, velParam);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
					if (insCnt[i] == 0)
						throw new EventException(new ErrorHandler("CSQ00003").getMessage());
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
	 * ESM_CSQ_0050 : MULTI<br>
	 * [QTA Adjustment by VVD]을 [복사] 합니다.<br>
	 * 
	 * @param List<ManageQtaAdjustmentVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void copyCfmQta(List<ManageQtaAdjustmentVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new QtaAdjustmentDBDAOCopyCfmQtaCSQL(), insModels, null);
				
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
					if (insCnt[i] == 0)
						throw new EventException(new ErrorHandler("CSQ00003").getMessage());
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
	 * ESM_CSQ_0050 : MULTI<br>
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
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
	 * ESM_CSQ_0050 : MULTI<br>
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
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
	 * ESM_CSQ_0050 : MULTI<br>
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
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
	 * ESM_CSQ_0050 : MULTI<br>
	 * [QTA Adjustment by VVD]을 [추가] 합니다.<br>
	 * 
	 * @param List<ManageQtaAdjustmentVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCfmTgtVvdAdj(List<ManageQtaAdjustmentVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
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
	 * ESM_CSQ_0050 : MULTI<br>
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
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
	 * ESM_CSQ_0050 : MULTI<br>
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
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
	 * ESM_CSQ_0051 : [이벤트]<br>
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchPotnAdjustmentListRSQL(), param, velParam);
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
	 * ESM_CSQ_0051 : [이벤트]<br>
	 * [Portion Adjustment]을 [업데이트] 합니다.<br>
	 * @param List<SearchPotnAdjustmentListVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updatePotnAdjustment(List<SearchPotnAdjustmentListVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
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
	 * ESM_CSQ_0051 : [이벤트]<br>
	 * [Portion Adjustment]을 [추가] 합니다.<br>
	 * 
	 * @param List<SearchPotnAdjustmentListVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addPotnAdjustment(List<SearchPotnAdjustmentListVO> updModels) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
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
	 * ESM_CSQ_0051 : MULTI02 이벤트 처리<br>
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchRhqGroupRowAddRSQL(), param, velParam);
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
	 * ESM_CSQ_0051 : SEARCH01 이벤트 처리<br>
	 * [Portion Adjustment by Head Office]에서 vvd의 주차를 [조회] 합니다.
	 * 
	 * @param ConditionVO conditionVO
	 * @param String vvd
	 * @return String
	 * @throws DAOException
	 */
	public String searchApplyWeek(ConditionVO conditionVO, String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		String dataCnt = "0";
		
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchApplyWeekRSQL(), param, velParam);
			
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
	 * ESM_CSQ_0051 : SEARCH02 이벤트 처리<br>
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchVvdCngTpCdRSQL(), param, velParam);
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
	 * ESM_CSQ_0051,ESM_CSQ_0053 : MULTI01 이벤트 처리<br>
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
			SQLExecuter sqlExe = new SQLExecuter("");
			
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
	 * ESM_CSQ_0051,ESM_CSQ_0053 : MULTI01 이벤트 처리<br>
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

			SQLExecuter sqlExe = new SQLExecuter("");
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
	 * ESM_CSQ_0055 : Retrieve 이벤트 처리<br>
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchQtaEditListRSQL(), param, velParam);
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
	 * ESM_CSQ_0055 : Retrieve 이벤트 처리<br>
	 * [Qta Edit]을을 [저장] 합니다.
	 * 
	 * @param List<CsqCfmQtaVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateQtaEdit(List<CsqCfmQtaVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
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
	 * ESM_CSQ_0055 : MULTI01 이벤트 처리<br>
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new QtaAdjustmentDBDAOCreateCmcbAdjustUSQL(), param, velParam);
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
	 * ESM_CSQ_0055 : MULTI 이벤트 처리<br>
	 * [Qta Edit]의 change type을 [저장] 합니다.
	 * 
	 * @param List<CsqCfmQtaVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateCfmQtaStatus(List<CsqCfmQtaVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
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
	 * ESM_CSQ_0052 : Retrieve 이벤트 처리<br>
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchHOPotnFigureInquiryListRSQL(), param, velParam);
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
	 * ESM_CSQ_0054 : Retrieve 이벤트 처리<br>
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchRHQPotnFigureInquiryListRSQL(), param, velParam);
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
	 * ESM_CSQ_0056 : Retrieve 이벤트 처리<br>
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchLaneOfficeListRSQL(), param, velParam);
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
	 * ESM_CSQ_0056 : MULTI02 이벤트 처리<br>
	 *  [IAS QTA Office Add]을 [생성] 합니다.<br>
	 * 
	 * @param updModels List<SearchLaneOfficeListVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createQtaOfficeAdd(List<SearchLaneOfficeListVO> updModels) throws DAOException,Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
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
	 * ESM_CSQ_0056 : 이벤트 처리<br>
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt = sqlExe.executeUpdate((ISQLTemplate)new QtaAdjustmentDBDAOUpdateCfmQtaStatusLaneUSQL(), param, null);
			
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
	 * ESM_CSQ_0219 : Retrieve 이벤트 처리<br>
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchQtaAdjustmentForSectorListRSQL(), param, velParam);
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
	 * ESM_CSQ_0219 : MULTI01<br>
	 * [QTA Adjustment by VVD For Secter]을 [복사] 합니다.<br>
	 * 
	 * @param List<ManageQtaAdjustmentVO> insModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void copyCfmQtaForSector(List<ManageQtaAdjustmentVO> insModels) throws DAOException,Exception {
		int insCnt[] = null;
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
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
	 * ESM_CSQ_0219 : MULTI01<br>
	 * [QTA Adjustment by VVD For Sector] : [CSQ_CFM_QTA]의 데이터를 [수정] 합니다.<br>
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
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
	 * ESM_CSQ_0219 : MULTI01<br>
	 * [QTA Adjustment by VVD For Sector] : [CSQ_SCTR_CFM_QTA]의 데이터를 [삭제] 합니다.<br>
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
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
	 * ESM_CSQ_0219 : MULTI01<br>
	 * [QTA Adjustment by VVD For Sector] : [CSQ_SCTR_CFM_QTA]의 [LOAD=0]로 [수정] 합니다.<br>
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
			
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
	 * ESM_CSQ_0220 : Retrieve 이벤트 처리<br>
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchQtaEditIasSectorListRSQL(), param, velParam);
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
	 * ESM_CSQ_0220 : MULTI 이벤트 처리<br>
	 * [Qta Edit for IAS Sector]을 [저장] 합니다.
	 * 
	 * @param List<CsqSctrCfmQtaVO> updModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void updateQtaEditIasSector(List<CsqSctrCfmQtaVO> updModels) throws DAOException,Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
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
	 * ESM_CSQ_0220 : MULTI 이벤트 처리<br>
	 * [Qta Edit for IAS Sector]을 [저장] 합니다.
	 * CSQ_CFM_QTA Delete overall report에서 조회되도록
	 * 
	 * @param CsqSctrCfmQtaVO csqSctrCfmQtaVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void removeCfmQtaIasSector(CsqSctrCfmQtaVO csqSctrCfmQtaVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = csqSctrCfmQtaVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new QtaAdjustmentDBDAORemoveCfmQtaIasSectorDSQL(), param, velParam);
//			if(result == 0){							
//				throw new EventException((String)new ErrorHandler("CSQ00003", new String[]{}).getMessage());
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
	 * ESM_CSQ_0220 : MULTI 이벤트 처리<br>
	 * [Qta Edit for IAS Sector]을 [저장] 합니다.
	 * CSQ_CFM_QTA Insert (overall report에서 조회되도록)
	 * 
	 * @param CsqSctrCfmQtaVO csqSctrCfmQtaVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addCfmQtaIasSector(CsqSctrCfmQtaVO csqSctrCfmQtaVO) throws DAOException,Exception {	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = csqSctrCfmQtaVO.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new QtaAdjustmentDBDAOAddCfmQtaIasSectorCSQL(), param, velParam);
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
	 * ESM_CSQ_0220 : MULTI01 이벤트 처리<br>
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new QtaAdjustmentDBDAOCreateCmcbAdjustIasSectorUSQL(), param, velParam);
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
	 * ESM_CSQ_0220 : MULTI01 이벤트 처리<br>
	 * [CMCB adjust for IAS Sector]을 [생성] 합니다.
	 * CSQ_CFM_QTA Delete (overall report에서 조회되도록)
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new QtaAdjustmentDBDAORemoveCfmQtaIasSector2DSQL(), param, velParam);
//			if(result == 0){							
//				throw new EventException((String)new ErrorHandler("CSQ00003", new String[]{}).getMessage());
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
	 * ESM_CSQ_0220 : MULTI01 이벤트 처리<br>
	 * [CMCB adjust for IAS Sector]을 [생성] 합니다.
	 * CSQ_CFM_QTA Insert (overall report에서 조회되도록)
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
			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new QtaAdjustmentDBDAOAddCfmQtaIasSector2CSQL(), param, velParam);
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
	 * ESM_CSQ_0221 : Retrieve 이벤트 처리<br>
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchQtaEditPolPodPairAddIasSectorRSQL(), param, velParam);
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
	 * ESM_CSQ_0221 : CREATION<br>
	 * [Qta Edit POL-POD Pair Add for IAS Sector]을 [생성] 합니다.
	 * 
	 * @param List<ManageQtaEditIasSectorVO> istModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createQtaEditPolPodPairAddIasSector(List<ManageQtaEditIasSectorVO> istModels) throws DAOException,Exception {
//		int istCnt[] = null;
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
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
			SQLExecuter sqlExe = new SQLExecuter("");
			for(int i=0; i<istModels.size(); i++){
				Map<String, String> mapVO = istModels.get(i).getColumnValues();
				param.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new QtaAdjustmentDBDAOCreateQtaEditPolPodPairAddIasSectorCSQL(), param, null);
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
	 * ESM_CSQ_0222 : Retrieve 이벤트 처리<br>
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new QtaAdjustmentDBDAOSearchQtaEditOfficeAddIasSectorRSQL(), param, velParam);
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
	 * ESM_CSQ_0222 : CREATION<br>
	 * [Qta Edit Office Add for IAS Sector]을 [생성] 합니다.
	 * 
	 * @param List<ManageQtaEditIasSectorVO> istModels
	 * @throws DAOException
	 * @throws Exception
	 */
	public void createQtaEditOfficeAddIasSector(List<ManageQtaEditIasSectorVO> istModels) throws DAOException,Exception {
//		int istCnt[] = null;
//		try {
//			SQLExecuter sqlExe = new SQLExecuter("");
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
			SQLExecuter sqlExe = new SQLExecuter("");
			for(int i=0; i<istModels.size(); i++){
				Map<String, String> mapVO = istModels.get(i).getColumnValues();
				param.putAll(mapVO);
				int result = sqlExe.executeUpdate((ISQLTemplate)new QtaAdjustmentDBDAOCreateQtaEditOfficeAddIasSectorCSQL(), param, null);
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