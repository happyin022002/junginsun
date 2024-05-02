/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScenarioDefaultManageDBDAO.java
*@FileTitle : ScenarioDefaultManage 
*Open Issues :
* No.   Ver.    Modifier         modifier date    explanation
* 1      1.0    jungran yang     2006-09-05       1.0 최초 생성
* 2      1.108  Jeonghwa Kwon    2008-02-25       CSR No : N200801250015 - Direction 방식이 FM -> TO pair 개념으로 변경
* 3      1.109  chae chang ho    2008-03-24       CSR No : N200802260006 - Lane/POD별 Discharging Bound 관리 기능 개발 건
* 4      1.110  Jeonghwa Kwon    2008-03-26       CSR No : N200803040009 - Constraint 화면  Rule 관련 Fm/To/Mode에 'All' 조건 추가
* 5      1.111  chae chang ho    2008-05-16       project_name : 신규 장비(F5-40ft H/C Flat rack) 발주에 따른  F5 등록
* 6      1.115  chae chang ho    2008-10-22       CSR No : N200810210009 - ECC 관련 Table자동 Delete 시 화면 로직 변경 요청
* 7      1.118  Haeng-ji, Lee    2009-04-03       CSR No : R200903240002 - Cntr Tpsz 자동화
* 8      1.119  Haeng-ji, Lee    2009-05-18       CSR No : R200905150001 - - Sheet에서 S/L변경했을 때의 에러사항 수정 - 쿼리 수정 
* 9      1.0    Lee Byoung Hun	 2009.06.30		  New Framework 적용 Renewal

*@LastModifyDate : 2009.06.30
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.06.30 이행지
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.eqr.common.Utils;
import com.clt.apps.opus.ees.eqr.common.vo.CommonRsVO;
import com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.event.EesEqr0116Event;
import com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0116ConditionVO;
import com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchEccMasterVO;
import com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchEccTsTmlVO;
import com.clt.apps.opus.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchSafetyStockVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.DateTime;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.EqrAutoRunFcastParaVO;
import com.clt.syscommon.common.table.EqrDmstPlnVO;
import com.clt.syscommon.common.table.EqrEccLnkVO;
import com.clt.syscommon.common.table.EqrEccMstVO;
import com.clt.syscommon.common.table.EqrEccSftStkVO;
import com.clt.syscommon.common.table.EqrEccTurnTmVO;
import com.clt.syscommon.common.table.EqrLongTermOffhCondVO;
import com.clt.syscommon.common.table.EqrPortDchgCnstVO;
import com.clt.syscommon.common.table.EqrRepoCnstVO;
import com.clt.syscommon.common.table.EqrShrtTermOffhCondVO;
import com.clt.syscommon.common.table.EqrShrtTermOnhCondVO;
import com.clt.syscommon.common.table.EqrSubleaseVO;
import com.clt.syscommon.common.table.EqrTsTmlVO;
import com.clt.syscommon.common.table.EqrWkPrdVO;



/**
 *  ScenarioDefaultManageDBDAO <br>
 * - -DefaultManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Chae Change Ho
 * @see scenariodefaultmanageBCImpl 참조
 * @since J2EE 1.6
 */
public class ScenarioDefaultManageDBDAO extends DBDAOSupport {


	
	
	/**
	 * EES_EQR_042Event ScenarioDefaultManage의 수정 된 데이타 모델을 DB에 반영한다.
	 * Grid 2
	 * @param List insModels
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void multiDefaultHolidayEffectDetailInfo(List insModels) throws DAOException {
          
        int insCnt[] = null;
        
        try {
        	SQLExecuter sqlExe = new SQLExecuter("");
			
			insCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOMergeEqrHolidayEffectDetailCSQL(), insModels,null);
			for(int i = 0; i < insCnt.length; i++){
				if(insCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No"+ i + " SQL");
			}

        } catch (SQLException se) {
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage());
        } catch (DAOException de) {
            log.error(de.getMessage(),de);
            throw de;
        } catch (Exception e) {
            log.error(e.getMessage(),e);
            throw new DAOException(e.getMessage());
        }
	}	
	
  
    /**
     * DefaultManage의 Link Info 조회(EES_EQR_116) 정보 조회
     * 
     * @param condiVo EesEqr0116ConditionVO : 조건 VO
     * @param fromEccAL ArrayList :  fromLocation 배열
     * @param toEccAL  ArrayList :  toLocation 배열
     * @return  List<EqrEccLnkVO>
     * @see EesEqr0116Event
     * @exception DAOException
    */
	@SuppressWarnings("unchecked")
	public List<EqrEccLnkVO> searchDefaultECCLinkInfo(EesEqr0116ConditionVO condiVo, ArrayList fromEccAL , ArrayList toEccAL) throws DAOException {
		
		List<EqrEccLnkVO> list = null;		
		// 조건값 셋팅 
		String fromStatus   = condiVo.getFromStatus();
    	String toStatus     = condiVo.getToStatus();
    	//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		velParam.put("fromStatus",condiVo.getFromStatus());
		velParam.put("toStatus",condiVo.getToStatus());
		param.put("transitTime",condiVo.getTransitTime()); 
		param.put("mode",condiVo.getMode());  
		velParam.put("transitTime",condiVo.getTransitTime()); 
		velParam.put("mode",condiVo.getMode());             
		
    	// from loc 검색조건
    	if(!fromStatus.equals("")) {
    		
    		velParam.put("fromEccArr",fromEccAL);
    	}
    	   
    	// to loc 검색조건
    	if(!toStatus.equals("")) {
    		velParam.put("toEccArr",toEccAL);
    	}
    	DBRowSet dRs 		= null; // 데이터 전송을 위해 DB ResultSet을 구현한 객체
		
		try {
			dRs = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchEccLinkInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dRs, EqrEccLnkVO .class);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return list;
	}	    

	/**
     * DefaultManage의Link Info  Sheet1 수정내용을 DB에 반영한다.(수정)<br>
     * 
     * @param List insModels
     * @see EesEqr0116Event
     * @exception DAOException
    */
	@SuppressWarnings("unchecked")
	public void manageDefaultECCLinkInfo(List insModels) throws DAOException {
	   	
		int insCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
		
			insCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOModifyEccLinkInfoUSQL(), insModels,null);
			for(int i = 0; i < insCnt.length; i++){
				if(insCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert No"+ i + " SQL");
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
    }  

	/**
     * DefaultManage의Link Info  Sheet1 수정내용을 DB에 반영한다.(수정)<br>
     * 
     * @param List delModels
     * @see EesEqr0116Event
     * @exception DAOException
    */
	@SuppressWarnings("unchecked")
	public void deleteDefaultECCLinkInfo(List delModels) throws DAOException {
	   	
		int delCnt[] = null;
		try{
			SQLExecuter sqlExe = new SQLExecuter("");
			
			//DELETE 시 ROW delete 하지 않고 필드만 update 하여 이력관리함 - 2007.08.30 (by.JH Kwon)
	        //modified : R200711074347 : 이미 기 삭제된 ECC_LINK를 새로 저장 할 경우 DELT_FLG값을 다시 원복하게 변경
			delCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOModifyEccLinkInfoDSQL(), delModels,null);
			for(int i = 0; i < delCnt.length; i++){
				if(delCnt[i]== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to delete No"+ i + " SQL");
			}
		}catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
    }  
	/**
	 * ScenarioDefaultManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param status String
	 * @param location String
	 * @return DBRowSet
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchEccMasterVO> searchDefaultECCInfo(String status, String location) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEccMasterVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			ArrayList arrLocation = (ArrayList) Utils.replaceStrToList(location);
		
			velParam.put("status", status);
			velParam.put("arrlocation", arrLocation);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchEccMasterRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEccMasterVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 * ScenarioDefaultManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param eccCd String
	 * @return List<SearchEccTsTmlVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchEccTsTmlVO> searchDefaultTSTMLInfo(String eccCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchEccTsTmlVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("eccCd", eccCd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchEccTsTmlRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchEccTsTmlVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
		 
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param updModels List<EqrEccMstVO>
	 * @exception DAOException
	 */
	public void modifyDefaultECCInfo(List<EqrEccMstVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOModifyEccMasterUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param updModels List<EqrTsTmlVO>
	 * @exception DAOException
	 */
	public void modifyDefaultTSTMLInfo(List<EqrTsTmlVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOModifyEccTsTmlUSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	 
		
	
	/**
	 * ScenarioDefaultManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param eccWhereCondition String
	 * @param tpsztype String 
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public CommonRsVO searchDefaultLTOffHireInfo(String eccWhereCondition, String tpsztype) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			ArrayList arrLocation = (ArrayList) Utils.replaceStrToList(eccWhereCondition);
			ArrayList arrTpszcd = (ArrayList) Utils.replaceStrToList(tpsztype);
		
			velParam.put("arrlocation", arrLocation);
			velParam.put("arrtpszcd", arrTpszcd);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchLongTermOffHireInfoRSQL(), param, velParam);
			rsVO.setDbRowset(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		return rsVO;
	}
		 
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param updModels List<EqrLongTermOffhCondVO>
	 * @exception DAOException
	 */
	public void modifyDefaultLTOffHireInfo(List<EqrLongTermOffhCondVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOMergeLongTermOffHireInfoCSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param delModels List<EqrLongTermOffhCondVO> 
	 * @exception DAOException
	 */
	public void deleteDefaultLTOffHireInfo(List<EqrLongTermOffhCondVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(delModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAODeleteLongTermOffHireInfoDSQL(), delModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param updModels List<EqrSubleaseVO>
	 * @exception DAOException
	 */
	public void modifyDefaultYearSubleasePlan(List<EqrSubleaseVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOMergeYearSubleasePlanCSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	
	/**
	 * [EES_EQR_0119 : S/T Off Hire 수정]<br>
	 * 
	 * @param updModels List<EqrShrtTermOffhCondVO>
	 * @exception DAOException
	 */
	public void modifyDefaultSTOffHireInfo(List<EqrShrtTermOffhCondVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOMergeShortTermOffHireInfoCSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_EQR_0119 : S/T Off Hire 삭제]<br>
	 * 
	 * @param delModels List<EqrShrtTermOffhCondVO> 
	 * @exception DAOException
	 */
	public void deleteDefaultSTOffHireInfo(List<EqrShrtTermOffhCondVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAODeleteShortTermOffHireInfoDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_EQR_0124 : Cabotage &  Rule 조회]<br>
	 * 
	 * @param cnsttype String
	 * @param tpsztype String
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchDefaultEmptyRepoConstraintInfo(String cnsttype, String tpsztype) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		CommonRsVO commonRsVO = new CommonRsVO();
		try{
			ArrayList arrtpsz = (ArrayList) Utils.replaceStrToList(tpsztype);
				
			velParam.put("cnsttype", cnsttype);
			velParam.put("arrtpsz", arrtpsz);
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchEmptyRepoConstraintInfoRSQL(), param, velParam);
			commonRsVO.setDbRowset(dbRowset);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return commonRsVO;
	}
	
	/**
	 * [EES_EQR_0124 : Cabotage &  Rule - Insert시 필요한 Cnst Rule Id 구하기.]<br>
	 * 
	 * @param nationCode String
	 * @param cnstTypeCode String
	 * @return int
	 * @exception DAOException
	 */
	public int createCnstRuleId(String nationCode, String cnstTypeCode) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int cnstRuleId = 0;

		try{
			param.put("nationcode", nationCode);
			param.put("cnsttypecode", cnstTypeCode);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOCreateCnstRuleIDRSQL(), param, velParam);
			if( dbRowset != null){
				while ( dbRowset.next())
					cnstRuleId = dbRowset.getInt("cnst_rule_id");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnstRuleId;
	}
	
	/**
	 * [EES_EQR_0124 : Cabotage &  Rule - Insert시 필요한 Cnst Sequence 구하기.]<br>
	 * 
	 * @return int
	 * @exception DAOException
	 */
	public int createCnstSeq() throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int cnst_seq = 0;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOCreateCnstSeqRSQL(), param, velParam);
			if( dbRowset != null){
				while ( dbRowset.next())
					cnst_seq = dbRowset.getInt("repo_cnst_seq");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnst_seq;
	}
	
	/**
	 * [EES_EQR_0124 : Cabotage &  Rule 수정]<br>
	 * 
	 * @param updModels List<EqrRepoCnstVO> 
	 * @exception DAOException
	 */
	public void modifyDefaultEmptyRepoConstraintInfo(List<EqrRepoCnstVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOInsertEmptyRepoConstraintCSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_EQR_0124 : Cabotage &  Rule 삭제]<br>
	 * 
	 * @param delModels List<EqrRepoCnstVO>
	 * @exception DAOException
	 */
	public void deleteDefaultEmptyRepoConstraintInfo(List<EqrRepoCnstVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAODeleteEmptyRepoConstraintDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	
	/**
	 * [EES_EQR_0137 : Constraint by Lane/POD 수정.]<br>
	 * 
	 * @param updModels List<EqrPortDchgCnstVO>
	 * @exception DAOException
	 */
	public void modifyDefaultConstraintLandPod(List<EqrPortDchgCnstVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOMergeConstLandPodCSQL(), updModels,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [EES_EQR_0137 : Constraint by Lane/POD 삭제.]<br>
	 * 
	 * @param delModels List<EqrPortDchgCnstVO>
	 * @exception DAOException
	 */
	public void deleteDefaultConstraintLandPod(List<EqrPortDchgCnstVO> delModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAODeleteConstLandPodDSQL(), delModels,null);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ScenarioDefaultManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public String  selectEffStYrwk() throws DAOException {
		DBRowSet dbRowset = null;
		List<EqrWkPrdVO> list = null;
		EqrWkPrdVO eqrWkPrdVO = null;
		
		String curDate = DateTime.getShortDateString();
		int curYear = DateTime.getYear();
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
		
			Map<String, String> mapVO = new HashMap();
		
			mapVO.put("wk_st_dt", curDate);
			mapVO.put("wk_end_dt", curDate);
			
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSelectEffStYrwkRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqrWkPrdVO .class);
			
			if (list.size() == 1) {
				eqrWkPrdVO = list.get(0);
				return curYear + eqrWkPrdVO.getPlnWk();
			}else {
				return null;
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}
	
	/**
	 * ScenarioDefaultManageDBDAO의 데이타 모델에 데이터를 insert를 한다.<br>
	 * 
	 * @param model 데이타 모델
	 * @return DBRowSet
	 * @exception DAOException
	 */
	
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param updModels List<EqrAutoRunFcastParaVO>
	 * @param effCurYrwk String
	 * @param effNextYrwk String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void multiAutoRunParameterInsert(List<EqrAutoRunFcastParaVO> updModels ,String effCurYrwk , String effNextYrwk) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			Map<String, String> mapVO = new HashMap();
			
			mapVO.put("effNextYrwk", effNextYrwk);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOMultiAutoRunParameterCSQL(), updModels, param, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("insert to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ScenarioDefaultManageDBDAO의 데이타 모델에 데이터를 insert를 한다.<br>
	 * 
	 * @param model 데이타 모델
	 * @return DBRowSet
	 * @exception DAOException
	 */
	
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 
	 * @param List<EqrAutoRunFcastParaVO> updModels
	 * @param String effCurYrwk
	 * @param String effNextYrwk
	 * @param boolean flag
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void multiAutoRunParameterUpdate(List<EqrAutoRunFcastParaVO> updModels, String effCurYrwk, String effNextYrwk, boolean flag) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			String updateState = null;
			
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO = new HashMap();
			
			if(flag){
			  updateState = "1";	
			}else{
			  updateState = "2";
			}
			
			mapVO.put("effCurYrwk", effCurYrwk);
			mapVO.put("flag", updateState);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOMultiAutoRunParameterUSQL(), updModels, param, velParam);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * ScenarioDefaultManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param SearchSafetyStockVO searchSafetyStock
	 * @param String loc
	 * @param String loctype
	 * @param String tpze
	 * @param String tpsztype
	 * @param String tpsztypes
	 * @param String lvlcd
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CommonRsVO searchDefaultCntrSafetyStock(SearchSafetyStockVO searchSafetyStock ,String loc ,String loctype , String tpze ,String tpsztype ,String tpsztypes ,String lvlcd) throws DAOException {
		DBRowSet dbRowset = null;
		//List<SearchSafetyStockVO> list = null;
		//EesEqr0117Event event =  new EesEqr0117Event();
		CommonRsVO returnVO = new CommonRsVO();
		String arrtpszcd = Utils.convertStr(tpsztype);
		String arrloccd = Utils.convertStr(loctype);
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
  
 		try{
			if(searchSafetyStock != null){
				Map<String, String> mapVO = searchSafetyStock .getColumnValues();
			    
				velParam.put("loc", loc);
				velParam.put("loctype", arrloccd);
				velParam.put("tpsztype", tpsztype);
				velParam.put("tpszcd", arrtpszcd);
				velParam.put("lvlcd",lvlcd);
				velParam.put("perfix", (ArrayList)Utils.replaceStrToList(tpsztype));
				param.put("lvlcd", lvlcd);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchSafetyStockRSQL(), param, velParam);
			returnVO.setDbRowset(dbRowset);
		//	list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchSafetyStockVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
	 
		 
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 0117화면의 insert 문 
	 * @param insModels List<EqrEccSftStkVO> 
	 * @param lvl_cd String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void multiDefaultCntrSafetyStockInsert(List<EqrEccSftStkVO> insModels ,String lvl_cd) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			//String insertState = null;
			
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO = new HashMap();
			
			
			//param.put("lvl_cd", lvl_cd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(insModels.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOInsertSafetyStockCSQL(), insModels, param, velParam);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 0117화면의 Update 문 
	 * @param upsModels List<EqrEccSftStkVO>
	 * @param lvl_cd String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void multiDefaultCntrSafetyStockUpdate(List<EqrEccSftStkVO> upsModels ,String lvl_cd) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int upsCnt[] = null;
			//String updateState = null;
			
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO = new HashMap();
			
			
			param.put("lvl_cd", lvl_cd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(upsModels.size() > 0){
				upsCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAOUpdateSafetyStockUSQL(), upsModels, param, velParam);
				for(int i = 0; i < upsCnt.length; i++){
					if(upsCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 다건의 데이터를 일괄적으로 갱신한다.<br>
	 * 0117화면의 delete 문 
	 * @param delModels List<EqrEccSftStkVO>
	 * @param lvl_cd String
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public void multiDefaultCntrSafetyStockDelete(List<EqrEccSftStkVO> delModels ,String lvl_cd) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			//String deleteState = null;
			
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			Map<String, String> mapVO = new HashMap();
			
			
			param.put("lvl_cd", lvl_cd);
		    velParam.put("lvl_cd" , lvl_cd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			if(delModels.size() > 0){
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ScenarioDefaultManageDBDAODeleteSafetyStockDSQL(), delModels, param, velParam);
				for(int i = 0; i < delCnt.length; i++){
					if(delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
 		
	}
	
	/**
	 * ScenarioDefaultManageDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param ecc_cd String
	 * @param cntp_sz_cd String
	 * @return boolean
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public boolean  searchCntrSafetyStockIsExist(String ecc_cd ,String cntp_sz_cd) throws DAOException {
		DBRowSet dbRowset = null;
		List<EqrEccSftStkVO> list = null;
	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
		
			Map<String, String> mapVO = new HashMap();
		
			mapVO.put("ecc_cd", ecc_cd);
			mapVO.put("cntr_tpsz_cd", cntp_sz_cd);
			
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ScenarioDefaultManageDBDAOSearchSafetyStockExistRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EqrEccSftStkVO .class);
			
			if (list.size() == 1) {
				return true;
			}else {
				return false;
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}		
	}	

}
