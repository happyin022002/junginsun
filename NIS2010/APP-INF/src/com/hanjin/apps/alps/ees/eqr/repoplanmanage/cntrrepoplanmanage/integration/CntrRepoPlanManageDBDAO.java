/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoPlanManageDBDAO.java
*@FileTitle : 컨테이너 이송 계획 목록 조회
*Open Issues :
*Change history :
* No.	Ver.		Modifier           					modifier date    explanation
* 1		1.0		paksangyool					2006-10-24		1.0 최초 생성
* 2					chae chang ho				2008.05.09		CSRNO : R200803215556
* 																						CSR NAME : Split 02-Unit Cost 반영 및 분석 Report 검색 수정/개발 요청  
* 																						Add Plan Data 에 대한 반영
* 3      	1.0      	Lee Byoung Hun				2009.08.14		New Framework 적용 Renewal
*
*@LastModifyDate : 2009.08.14
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.08.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.common.Constants;
import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.basic.CntrRepoPlanManageBCImpl;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0045ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0048ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0051ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0052ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0053ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0054ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.EesEqr0129ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.GetRepoPlanListVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.SearchCntrOnHireApprovalVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.SearchCntrRepoInOutPlanLaneVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.SearchCntrRepoInOutPlanVVDVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo.SearchTSGuidelineVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.EqrAddPlnVO;
import com.hanjin.syscommon.common.table.EqrInlndTrspPlnQtyVO;
import com.hanjin.syscommon.common.table.EqrInlndTrspPlnVO;
import com.hanjin.syscommon.common.table.EqrOnfHirPlnQtyVO;
import com.hanjin.syscommon.common.table.EqrOnfHirPlnVO;
import com.hanjin.syscommon.common.table.EqrVslLodgDchgPlnQtyVO;
import com.hanjin.syscommon.common.table.EqrVslLodgDchgPlnVO;


/**
 * ALPS CntrRepoPlanManageDBDAO <br>
 * - ALPS-RepoPlanManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see CntrRepoPlanManageBCImpl 참조
 * @since J2EE 1.6
 */
public class CntrRepoPlanManageDBDAO extends DBDAOSupport {

	/**
	 * 컨테이너 이송 계획 목록 조회 조회 이벤트 처리<br>
	 * 
	 * @param EesEqr0045ConditionVO conditionVO
	 * @return List<GetRepoPlanListVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<GetRepoPlanListVO> searchRepoPlanList(EesEqr0045ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<GetRepoPlanListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = conditionVO .getColumnValues();
			String repoSYearWeek = conditionVO.getReposyear() + conditionVO.getReposweek();
			String repoEYearWeek = conditionVO.getRepoeyear() + conditionVO.getRepoeweek();
			String repo_pln_id = Constants.REPO_WORD + conditionVO.getRepoweek() + Constants.REPO_WEEK + conditionVO.getReposeq();
			String scnr_id     = Constants.SCNR_WORD + conditionVO.getScnrweek() + Constants.SCNR_WEEK + conditionVO.getScnrseq();
		
			param.putAll(mapVO);
			param.put("repoSYearWeek", repoSYearWeek);
			param.put("repoEYearWeek", repoEYearWeek);
			param.put("repo_pln_id", repo_pln_id);
			param.put("scnr_id", scnr_id);
			
			velParam.putAll(mapVO);
			velParam.put("repoSYearWeek", repoSYearWeek);
			velParam.put("repoEYearWeek", repoEYearWeek);
			velParam.put("repo_pln_id", repo_pln_id);
			velParam.put("scnr_id", scnr_id);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanManageDBDAOGetRepoPlanListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, GetRepoPlanListVO .class);
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
	  * 컨테이너 이송 계획 목록 조회 Copy 이벤트 처리<br>
	  * EQR_COPY_REPO_PLAN_PRC 프로시져 호출 
	  * 
	  * @param conditionVO
	  * @param usrId
	  * @exception DAOException
	  */
	@SuppressWarnings("unchecked")
	public void createNewRepoPlanID(EesEqr0045ConditionVO conditionVO, String usrId) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map resultMap = null;
		String resultNo = null;

		try{
			param.put("in_repo_plan_id", conditionVO.getRepoPlnId());
			param.put("in_user_id", usrId);
			param.put("out_result_no", "");
			resultMap = new SQLExecuter("").executeSP((ISQLTemplate)new CntrRepoPlanManageDBDAOCreateNewRepoPlanIDCSQL(), param, velParam);
			resultNo = (String) resultMap.get("out_result_no");
			
			if ("99".equals(resultNo)) {
				throw new DAOException("Fail to EQR_COPY_REPO_PLAN_PRC! Result No : "+ resultNo);
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
	 * 컨테이너 이송 계획 목록 조회 Delete 이벤트 처리<br>
	 * 
	 * @param conditionVO
	 * @exception DAOException
	 */
	public void removeRepoPlanID(EesEqr0045ConditionVO conditionVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = conditionVO .getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			new SQLExecuter("").executeUpdate((ISQLTemplate)new CntrRepoPlanManageDBDAODeleteRepoPlanListDSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 컨테이너 이송계획 관리 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO
	 * @return
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchForecastedLandInventory(EesEqr0051ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = conditionVO .getColumnValues();
			String repo_pln_Id = Constants.REPO_WORD + conditionVO.getYyyyww() + Constants.REPO_WEEK + conditionVO.getSeq();
			ArrayList arrCntrTpszCd = (ArrayList) Utils.replaceStrToList(conditionVO.getCntrtpszcd1());
			ArrayList arrEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getEcccd1());
			ArrayList arrItem = (ArrayList) Utils.replaceStrToList(conditionVO.getItem1());
			ArrayList arrIane = (ArrayList) Utils.replaceStrToList(conditionVO.getLane1());
			ArrayList arrVvd = (ArrayList) Utils.replaceStrToList(conditionVO.getVvd1());
			String isItemOffStr = "";
			String isItemOnStr = "";
			
			if (conditionVO.getItem1() != null && !"".equals(conditionVO.getItem1())) {
				if (conditionVO.getItem1().indexOf("F") != -1) {
					isItemOffStr = "Y";
				} else {
					isItemOffStr = "N";
				}
				if (conditionVO.getItem1().indexOf("O") != -1) {
					isItemOnStr = "Y";
				} else {
					isItemOnStr = "N";
				}
			}
		
			param.put("repo_pln_Id", repo_pln_Id);
			
			velParam.putAll(mapVO);
			velParam.put("arrCntrTpszCd", arrCntrTpszCd);
			velParam.put("arrEccCd", arrEccCd);
			velParam.put("arrItem", arrItem);
			velParam.put("arrIane", arrIane);
			velParam.put("arrVvd", arrVvd);
			velParam.put("isItemOffStr", isItemOffStr);
			velParam.put("isItemOnStr", isItemOnStr);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanManageDBDAOGetForecastedLandInventoryListRSQL(), param, velParam);
			rsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
	/**
	 * 컨테이너 이송계획 관리 저장 이벤트 처리<br>
	 * 
	 * @param updModels
	 * @exception DAOException,Exception
	 */
	public void modifyForecastedLandInventory(List<EqrAddPlnVO> updModels) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(updModels.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new CntrRepoPlanManageDBDAOModifyForecastLandInvCSQL(), updModels,null);
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
	 * 컨테이너 이송계획 관리 Distribution 가능여부 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO
	 * @return
	 * @exception DAOException
	 */
	public CommonRsVO searchDtrbForecastedLandInventory(EesEqr0051ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			String repoPlnIdLike = Constants.REPO_WORD + conditionVO.getYyyyww();
			
			velParam.put("repoPlnIdLike", repoPlnIdLike);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanManageDBDAOSearchDtrbForecastedLandInventoryRSQL(), param, velParam);
			rsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
	/**
	 * 컨테이너 이송계획 관리 Distribution 이벤트 처리 (EQR_EQ_REPO_PLN 테이블에 distribute = Y 로 수정)
	 * 
	 * @param conditionVO
	 * @param account
	 * @exception DAOException
	 */
	public void modifyForecastLandInvDistributeRepoPln(EesEqr0051ConditionVO conditionVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			param.put("updUsrId", account.getUsr_id());
			param.put("repoPlnId", Constants.REPO_WORD+conditionVO.getYyyyww()+Constants.REPO_WEEK+conditionVO.getSeq());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CntrRepoPlanManageDBDAOModifyForecastLandInvDistributeRepoPlnUSQL(), param, velParam);
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
	 * 컨테이너 이송계획 관리 Distribution 이벤트 처리 (EQR_SCNR_MST 테이블에 distribute = Y 로 수정)
	 * 
	 * @param conditionVO
	 * @param account
	 * @exception DAOException
	 */
	public void modifyForecastLandInvDistributeScnrMst(EesEqr0051ConditionVO conditionVO, SignOnUserAccount account) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			param.put("updUsrId", account.getUsr_id());
			param.put("repoPlnId", Constants.REPO_WORD+conditionVO.getYyyyww()+Constants.REPO_WEEK+conditionVO.getSeq());
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CntrRepoPlanManageDBDAOModifyForecastLandInvDistributeScnrMstUSQL(), param, velParam);
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
	 * 최적화된 REPO InOut 계획 수량 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO
	 * @return
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchCntrRepoInOutPlanDtInfo(EesEqr0052ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = conditionVO .getColumnValues();
			String repo_pln_Id = Constants.REPO_WORD + conditionVO.getYyyyww() + Constants.REPO_WEEK + conditionVO.getSeq();
			String fmFmPlnYrWk = "";
			String fmToPlnYrWk = "";
			String toFmPlnYrWk = "";
			String toToPlnYrWk = "";
			ArrayList arrCntrTpszCd = (ArrayList) Utils.replaceStrToList(conditionVO.getCntrtpszcd2());
			ArrayList arrFmEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getFmecccd2());
			ArrayList arrAtEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getAtecccd2());
			ArrayList arrToEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getToecccd2());
			ArrayList arrItem = (ArrayList) Utils.replaceStrToList(conditionVO.getItem2());
			ArrayList arrIane = (ArrayList) Utils.replaceStrToList(conditionVO.getLane2());
			ArrayList arrVvd = (ArrayList) Utils.replaceStrToList(conditionVO.getVvd2());
			
			if ("1".equals(conditionVO.getFmtoat2())) {
				fmFmPlnYrWk = conditionVO.getFmfmplnyr2() + conditionVO.getFmfmplnwk2();
				fmToPlnYrWk = conditionVO.getFmtoplnyr2() + conditionVO.getFmtoplnwk2();
				toFmPlnYrWk = conditionVO.getTofmplnyr2() + conditionVO.getTofmplnwk2();
				toToPlnYrWk = conditionVO.getTotoplnyr2() + conditionVO.getTotoplnwk2();
			} else {
				fmFmPlnYrWk = conditionVO.getAtfmplnyr2() + conditionVO.getAtfmplnwk2();
				fmToPlnYrWk = conditionVO.getAttoplnyr2() + conditionVO.getAttoplnwk2();
				toFmPlnYrWk = conditionVO.getAtfmplnyr2() + conditionVO.getAtfmplnwk2();
				toToPlnYrWk = conditionVO.getAttoplnyr2() + conditionVO.getAttoplnwk2();
			}
		
			param.put("repo_pln_Id", repo_pln_Id);
			param.put("fmFmPlnYrWk", fmFmPlnYrWk);
			param.put("fmToPlnYrWk", fmToPlnYrWk);
			param.put("toFmPlnYrWk", toFmPlnYrWk);
			param.put("toToPlnYrWk", toToPlnYrWk);
			
			velParam.putAll(mapVO);
			velParam.put("fmFmPlnYrWk", fmFmPlnYrWk);
			velParam.put("fmToPlnYrWk", fmToPlnYrWk);
			velParam.put("toFmPlnYrWk", toFmPlnYrWk);
			velParam.put("toToPlnYrWk", toToPlnYrWk);
			velParam.put("arrCntrTpszCd", arrCntrTpszCd);
			velParam.put("arrFmEccCd", arrFmEccCd);
			velParam.put("arrAtEccCd", arrAtEccCd);
			velParam.put("arrToEccCd", arrToEccCd);
			velParam.put("arrItem", arrItem);
			velParam.put("arrIane", arrIane);
			velParam.put("arrVvd", arrVvd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanManageDBDAOSearchCntrRepoInOutPlanDtRSQL(), param, velParam);
			rsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
	/**
	 * 최적화된 REPO InOut 계획 수량 VVD 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO
	 * @return
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCntrRepoInOutPlanLaneVO> searchCntrRepoInOutPlanLaneInfo(EesEqr0052ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCntrRepoInOutPlanLaneVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = conditionVO .getColumnValues();
		
			param.putAll(mapVO);
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanManageDBDAOSearchCntrRepoInOutPlanLaneRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCntrRepoInOutPlanLaneVO .class);
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
	 * 최적화된 REPO InOut 계획 수량 LOC 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO
	 * @return
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCntrRepoInOutPlanVVDVO> searchCntrRepoInOutPlanVvdInfo(EesEqr0052ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCntrRepoInOutPlanVVDVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		String yrwk1 = null;
		String yrwk2 = null;
		String yrwk3 = null;

		try{
			Map<String, String> mapVO = conditionVO .getColumnValues();
			
			if ("0".equals(conditionVO.getFmtoat2())) {
				yrwk1 = conditionVO.getFmfmplnyrwk2();
				yrwk2 = conditionVO.getFmfmplnyrwk2();
				yrwk3 = conditionVO.getTofmplnyrwk2();
			} else {
				yrwk1 = conditionVO.getAtfmplnyrwk2();
				yrwk2 = conditionVO.getAtfmplnyrwk2();
				yrwk3 = conditionVO.getAtfmplnyrwk2();
			}
		
			param.putAll(mapVO);
			param.put("yrwk1", yrwk1);
			param.put("yrwk2", yrwk2);
			param.put("yrwk3", yrwk3);
			velParam.putAll(mapVO);
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanManageDBDAOSearchCntrRepoInOutPlanVVDRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCntrRepoInOutPlanVVDVO .class);
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
	 * 최적화된 REPO InOut 계획 수량 수정 이벤트 처리<br>
	 * EQR_VSL_LODG_DCHG_PLN 테이블에 VOL, AMOUNT 정보 수정 혹은 입력
	 * 
	 * @param vo
	 * @return
	 * @exception DAOException,Exception
	 */
	public int mergeCntrRepoInOutPlanDtVessel(EqrVslLodgDchgPlnVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CntrRepoPlanManageDBDAOMergeCntrRepoInOutPlanDtVesselCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * 최적화된 REPO InOut 계획 수량 수정 이벤트 처리<br>
	 * EQR_VSL_LODG_DCHG_PLN_QTY 테이블에 VOL, AMOUNT 정보 수정 혹은 입력
	 * 
	 * @param vo
	 * @return
	 * @exception DAOException,Exception
	 */
	public int mergeCntrRepoInOutPlanDtVesselQty(EqrVslLodgDchgPlnQtyVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CntrRepoPlanManageDBDAOMergeCntrRepoInOutPlanDtVesselQtyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * 최적화된 REPO InOut 계획 수량 수정 이벤트 처리<br>
	 * EQR_INLND_TRSP_PLN 테이블에 VOL, AMOUNT 정보 수정 혹은 입력
	 * 
	 * @param vo
	 * @return
	 * @exception DAOException,Exception
	 */
	public int mergeCntrRepoInOutPlanDtInland(EqrInlndTrspPlnVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CntrRepoPlanManageDBDAOMergeCntrRepoInOutPlanDtInlandCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * 최적화된 REPO InOut 계획 수량 수정 이벤트 처리<br>
	 * EQR_INLND_TRSP_PLN_QTY 테이블에 VOL, AMOUNT 정보 수정 혹은 입력
	 * 
	 * @param vo
	 * @return
	 * @exception DAOException,Exception
	 */
	public int mergeCntrRepoInOutPlanDtInlandQty(EqrInlndTrspPlnQtyVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CntrRepoPlanManageDBDAOMergeCntrRepoInOutPlanDtInlandQtyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * EQR_VSL_LODG_DCHG_PLN 테이블 데이터 삭제<br>
	 * 
	 * @param vo
	 * @return
	 * @exception DAOException,Exception
	 */
	public int deleteVesselPlan(EqrVslLodgDchgPlnVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CntrRepoPlanManageDBDAODeleteVesselPlanDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * EQR_VSL_LODG_DCHG_PLN_QTY 테이블 데이터 삭제<br>
	 * 
	 * @param vo
	 * @return
	 * @exception DAOException,Exception
	 */
	public int deleteVesselPlanQty(EqrVslLodgDchgPlnQtyVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CntrRepoPlanManageDBDAODeleteVesselPlanQtyDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * EQR_INLND_TRSP_PLN 테이블에 데이터 삭제<br>
	 * 
	 * @param vo
	 * @return
	 * @exception DAOException,Exception
	 */
	public int deleteInlandPlan(EqrInlndTrspPlnVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CntrRepoPlanManageDBDAODeleteInlandPlanDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * EQR_INLND_TRSP_PLN_QTY 테이블에 데이터 삭제<br>
	 * 
	 * @param vo
	 * @return
	 * @exception DAOException,Exception
	 */
	public int deleteInlandPlanQty(EqrInlndTrspPlnQtyVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CntrRepoPlanManageDBDAODeleteInlandPlanQtyDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * EQR_ONF_HIR_PLN 삭제 테이블에 데이터 삭제<br>
	 * 
	 * @param vo
	 * @return
	 * @exception DAOException,Exception
	 */
	public int deleteOnOffPlan(EqrOnfHirPlnVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CntrRepoPlanManageDBDAODeleteOnOffPlanDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * EQR_ONF_HIR_PLN_QTY 테이블에 데이터 삭제<br>
	 * 
	 * @param vo
	 * @return
	 * @exception DAOException,Exception
	 */
	public int deleteOnOffPlanQty(EqrOnfHirPlnQtyVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CntrRepoPlanManageDBDAODeleteOnOffPlanQtyDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	 /** 
	  * ADDED BY SHIN YONGCHAN - 20080430
	  * UNIT COST 정보를 취득합니다.
	  * COD, REPO PLAN, EXE PLAN 3군데 화면에서 사용합니다. (소스는 각각의 DAO에 존재함)
	  *
	  * 1) EQR_ECC_ADD_PLN_COST 에 UNIT COST 존재하는지 확인
	  * 2) 존재하면       EQR_ECC_ADD_PLN_COST 에서 UNIT COST 취득
	  * 3) 존재하지 않으면 EQR_LCC_ADD_PLN_COST 에서 UNIT COST 획득  
	  * 
	  * @param division   : PLAN, EXEC, INTERNAL  구분( P, E, I)
	  * @param fm_ecc   : FROM ECC (OR FROM YARD)
	  * @param to_ecc   : TO ECC (OR TO YARD)
	  * @param trsp_mod_cd  : trsp_mod_cd 구분(V,R,T,W,)
	  * @param cntr_tpsz_cd  : cntr_tpsz_cd 구분
	  * @return String[] (FROM UNIT COST, TO UNIT COST, UNIT COST)
	  * @exception DAOException
	  */ 
	public CommonRsVO searchUnitCost(String division, String fm_ecc, String to_ecc, String trsp_mod_cd, String cntr_tpsz_cd) throws DAOException {
		DBRowSet rs_chk = null;
		DBRowSet rs_ecc = null;
		DBRowSet rs_lcc = null;
		String[] returnStr = new String[3];
		CommonRsVO returnVO = new CommonRsVO(); 
		int result = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("fm_ecc_cd", fm_ecc);
			param.put("to_ecc_cd", to_ecc);
			param.put("trsp_mod_cd", trsp_mod_cd);
			param.put("cntr_tpsz_cd", cntr_tpsz_cd);
			
			velParam.put("trsp_mod_cd", trsp_mod_cd);
			velParam.put("division", division);
				
			rs_chk = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanManageDBDAOSearchUnitCostChkRSQL(), param, velParam);
			while (rs_chk.next()){
				result = rs_chk.getInt(1);
				break;
			}
			
			//-------------- ECC에 데이터 존재 
			if( result > 0 ) {
				rs_ecc = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanManageDBDAOSearchUnitCostEccRSQL(), param, velParam);
				while(rs_ecc.next()) {
				     returnStr[0]= rs_ecc.getString("FM_COST");
				     returnStr[1]= rs_ecc.getString("TO_COST");
				     returnStr[2]= rs_ecc.getString("UC_COST");
				}
			} else {
				rs_lcc = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanManageDBDAOSearchUnitCostLccRSQL(), param, velParam);
				while(rs_lcc.next()) {
				     returnStr[0]= rs_lcc.getString("FM_COST");
				     returnStr[1]= rs_lcc.getString("TO_COST");
				     returnStr[2]= rs_lcc.getString("UC_COST");
				}
			}
			
			returnVO.setResultStrArray(returnStr);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return returnVO;
	}
	
	/**
	 * TS Guideline PopUp 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO
	 * @return
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchTSGuidelineVO> searchTSGuideline(EesEqr0129ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchTSGuidelineVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = conditionVO .getColumnValues();
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanManageDBDAOSearchTSGuidelineRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchTSGuidelineVO .class);
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
	 * 컨테이너 수급 예측실적 및 정확도 Sheet1 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO
	 * @return
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchCntrOnHireRepoPlanDtInfo(EesEqr0053ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = conditionVO .getColumnValues();
			ArrayList arrCntrTpszCd = (ArrayList) Utils.replaceStrToList(conditionVO.getCntrtpszcd3());
			ArrayList arrAtEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getEcccd3());
			
			String repo_pln_Id = Constants.REPO_WORD+conditionVO.getYyyyww()+Constants.REPO_WEEK+conditionVO.getSeq();
			
			param.putAll(mapVO);
			param.put("repo_pln_Id", repo_pln_Id);
			
			velParam.putAll(mapVO);
			velParam.put("arrCntrTpszCd", arrCntrTpszCd);
			velParam.put("arrAtEccCd", arrAtEccCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanManageDBDAOSearchCntrOnHireRepoPlanDtRSQL(), param, velParam);
			rsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
	/**
	 * 컨테이너 수급 예측실적 및 정확도 Sheet2 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO
	 * @return
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCntrOnHireApprovalVO> searchOnHireApproval(EesEqr0053ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCntrOnHireApprovalVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = conditionVO .getColumnValues();
			ArrayList arrCntrTpszCd = (ArrayList) Utils.replaceStrToList(conditionVO.getCntrtpszcd3());
		
			param.putAll(mapVO);
			
			velParam.putAll(mapVO);
			velParam.put("arrCntrTpszCd", arrCntrTpszCd);
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanManageDBDAOSearchCntrOnHireApprovalRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchCntrOnHireApprovalVO .class);
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
	 * 컨테이너 수급 예측실적 및 정확도 수정 이벤트 처리<br>
	 * EQR_ONF_HIR_PLN 테이블 volume 수정 혹은 신규 입력<br>
	 * 
	 * @param vo
	 * @return
	 * @exception DAOException,Exception
	 */
	public int mergeCntrOnHireRepoPlanDt(EqrOnfHirPlnVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CntrRepoPlanManageDBDAOMergeCntrOnHireRepoPlanDtCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * 컨테이너 수급 예측실적 및 정확도 수정 이벤트 처리<br>
	 * EQR_ONF_HIR_PLN_QTY 테이블 volume 수정 혹은 신규 입력<br>
	 * 
	 * @param vo
	 * @return
	 * @exception DAOException,Exception
	 */
	public int mergeCntrOnHireRepoPlanDtQty(EqrOnfHirPlnQtyVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CntrRepoPlanManageDBDAOMergeCntrOnHireRepoPlanDtQtyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * 컨테이너 수급 예측실적 및 정확도(Off-Hire) 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO
	 * @return
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchCntrOffHireRepoPlanDtInfo(EesEqr0054ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = conditionVO .getColumnValues();
			ArrayList arrCntrTpszCd = (ArrayList) Utils.replaceStrToList(conditionVO.getCntrtpszcd4());
			ArrayList arrAtEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getEcccd4());
			
			String repo_pln_Id = Constants.REPO_WORD+conditionVO.getYyyyww()+Constants.REPO_WEEK+conditionVO.getSeq();
			
			param.putAll(mapVO);
			param.put("repo_pln_Id", repo_pln_Id);
			
			velParam.putAll(mapVO);
			velParam.put("arrCntrTpszCd", arrCntrTpszCd);
			velParam.put("arrAtEccCd", arrAtEccCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanManageDBDAOSearchCntrOffHireRepoPlanDtRSQL(), param, velParam);
			rsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
	/**
	 * EQR_ONF_HIR_PLN 테이블 PLN_SEQ 취득<br>
	 * 
	 * @param repoPlnId
	 * @param plnYrwk
	 * @param onfHirDivCd
	 * @param eccCd
	 * @return
	 * @exception DAOException
	 */
	public CommonRsVO getOnfHirPlnSeq(EqrOnfHirPlnVO eqrOnfHirPlnVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] resultStrArray = null;
		int i = 0;

		try{
			Map<String, String> mapVO = eqrOnfHirPlnVO .getColumnValues();
			param.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanManageDBDAOGetOnfHirPlnSeqRSQL(), param, velParam);
			
			resultStrArray = new String[dbRowset.getRowCount()];
			while (dbRowset.next()) {
				resultStrArray[i] = dbRowset.getString("PLN_SEQ");
				i++;
			}
			
			rsVO.setResultStrArray(resultStrArray);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
	/**
	 * EQR_INLND_TRSP_PLN 테이블 PLN_SEQ 취득<br>
	 * 
	 * @param repoPlnId
	 * @param plnYrwk
	 * @param onfHirDivCd
	 * @param eccCd
	 * @return
	 * @exception DAOException
	 */
	public CommonRsVO getInLndPlnSeq(EqrInlndTrspPlnVO eqrInlndTrspPlnVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] resultStrArray = null;
		int i = 0;

		try{
			Map<String, String> mapVO = eqrInlndTrspPlnVO .getColumnValues();
			param.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanManageDBDAOGetInLndPlnSeqRSQL(), param, velParam);
			
			resultStrArray = new String[dbRowset.getRowCount()];
			while (dbRowset.next()) {
				resultStrArray[i] = dbRowset.getString("PLN_SEQ");
				i++;
			}
			
			rsVO.setResultStrArray(resultStrArray);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
	/**
	 * EQR_VSL_LODG_DCHG_PLN 테이블 PLN_SEQ 취득<br>
	 * 
	 * @param repoPlnId
	 * @param plnYrwk
	 * @param onfHirDivCd
	 * @param eccCd
	 * @return
	 * @exception DAOException
	 */
	public CommonRsVO getVslPlnSeq(EqrVslLodgDchgPlnVO eqrVslLodgDchgPlnVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		String[] resultStrArray = null;
		int i = 0;

		try{
			Map<String, String> mapVO = eqrVslLodgDchgPlnVO .getColumnValues();
			param.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanManageDBDAOGetVslPlnSeqRSQL(), param, velParam);
			
			resultStrArray = new String[dbRowset.getRowCount()];
			while (dbRowset.next()) {
				resultStrArray[i] = dbRowset.getString("PLN_SEQ");
				i++;
			}
			
			rsVO.setResultStrArray(resultStrArray);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
	/**
	 * 컨테이너 수급 예측실적 및 정확도(Off-Hire) 수정 이벤트 처리<br>
	 * EQR_ONF_HIR_PLN 테이블 volume 수정 혹은 신규 입력<br>
	 * 
	 * @param vo
	 * @return
	 * @exception DAOException,Exception
	 */
	public int mergeCntrOffHireRepoPlanDt(EqrOnfHirPlnVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CntrRepoPlanManageDBDAOMergeCntrOffHireRepoPlanDtCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * 컨테이너 수급 예측실적 및 정확도(Off-Hire) 수정 이벤트 처리<br>
	 * EQR_ONF_HIR_PLN_QTY 테이블 volume 수정 혹은 신규 입력<br>
	 * 
	 * @param vo
	 * @return
	 * @exception DAOException,Exception
	 */
	public int mergeCntrOffHireRepoPlanDtQty(EqrOnfHirPlnQtyVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CntrRepoPlanManageDBDAOMergeCntrOffHireRepoPlanDtQtyCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * 컨테이너 수급 예측실적 및 정확도 조회(RLA List) 조회 이벤트 처리<br>
	 * 
	 * @param conditionVO
	 * @return
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchRLARepoPlanDtList(EesEqr0048ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = conditionVO .getColumnValues();
			ArrayList arrCntrTpszCd = (ArrayList) Utils.replaceStrToList(conditionVO.getCntrtpszcd5());
			ArrayList arrFmEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getFmecccd5());
			ArrayList arrAtEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getAtecccd5());
			ArrayList arrToEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getToecccd5());
			ArrayList arrItem = (ArrayList) Utils.replaceStrToList(conditionVO.getItem5());
			ArrayList arrIane = (ArrayList) Utils.replaceStrToList(conditionVO.getLane5());
			ArrayList arrVvd = (ArrayList) Utils.replaceStrToList(conditionVO.getVvd5());
			
			String repo_pln_Id = Constants.REPO_WORD+conditionVO.getYyyyww()+Constants.REPO_WEEK+conditionVO.getSeq();
			String max_capa_4wk = search4wk(conditionVO.getYyyyww()).getResultString();
			//조회주차
			String fmFmPlnYrWk = "";
			String fmToPlnYrWk = "";
			String toFmPlnYrWk = "";
			String toToPlnYrWk = "";
			
			if("1".equals(conditionVO.getFmtoat5())) {
				fmFmPlnYrWk = conditionVO.getFmfmplnyr5()+conditionVO.getFmfmplnwk5();
				fmToPlnYrWk = conditionVO.getFmtoplnyr5()+conditionVO.getFmtoplnwk5();
				toFmPlnYrWk = conditionVO.getTofmplnyr5()+conditionVO.getTofmplnwk5();
				toToPlnYrWk = conditionVO.getTotoplnyr5()+conditionVO.getTotoplnwk5();
			}else{
				fmFmPlnYrWk = conditionVO.getAtfmplnyr5()+conditionVO.getAtfmplnwk5();
				fmToPlnYrWk = conditionVO.getAttoplnyr5()+conditionVO.getAttoplnwk5();
				toFmPlnYrWk = conditionVO.getAtfmplnyr5()+conditionVO.getAtfmplnwk5();
				toToPlnYrWk = conditionVO.getAttoplnyr5()+conditionVO.getAttoplnwk5();
			}
			
			param.putAll(mapVO);
			param.put("repo_pln_Id", repo_pln_Id);
			param.put("fmFmPlnYrWk", fmFmPlnYrWk);
			param.put("fmToPlnYrWk", fmToPlnYrWk);
			param.put("toFmPlnYrWk", toFmPlnYrWk);
			param.put("toToPlnYrWk", toToPlnYrWk);
			
			velParam.putAll(mapVO);
			velParam.put("fmFmPlnYrWk", fmFmPlnYrWk);
			velParam.put("toFmPlnYrWk", toFmPlnYrWk);
			velParam.put("max_capa_4wk", max_capa_4wk);
			velParam.put("arrCntrTpszCd", arrCntrTpszCd);
			velParam.put("arrFmEccCd", arrFmEccCd);
			velParam.put("arrAtEccCd", arrAtEccCd);
			velParam.put("arrToEccCd", arrToEccCd);
			velParam.put("arrItem", arrItem);
			velParam.put("arrIane", arrIane);
			velParam.put("arrVvd", arrVvd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanManageDBDAOSearchRLARepoDetailListRSQL(), param, velParam);
			rsVO.setDbRowset(dbRowset);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
	/**
	 * EES_EQR_0048 : max capa의 pln_wk 포함 4주차 가져오기
	 * pln_wk = 18 이면 18,19,20,21 주차조회. 
	 * 
	 * @param yyyyww
	 * @return
	 * @exception DAOException
	 */
	public CommonRsVO search4wk(String yyyyww) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int j = 0;
		
		try{
			param.put("yyyyww", yyyyww);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanManageDBDAOSearch4wkRSQL(), param, velParam);
			
			StringBuffer weekList = new StringBuffer();
			while (dbRowset.next()) {
				weekList.append(((j == 0) ? "" : ",") + "'"+dbRowset.getString ("PLN_YRWK")+"'");
				j++;
			}
			
			rsVO.setResultString(weekList.toString());
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsVO;
	}
	
	/**
	 * 컨테이너 수급 예측실적 및 정확도 조회(RLA List) 수정 이벤트 처리<br>
	 * EQR_VSL_LODG_DCHG_PLN_QTY
	 * 
	 * @param vo
	 * @return
	 * @exception DAOException,Exception
	 */
	public int modifyRLARepoPlanDtVesselQty(EqrVslLodgDchgPlnQtyVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CntrRepoPlanManageDBDAOModifyRLARepoPlanDtVesselQtyUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * 컨테이너 수급 예측실적 및 정확도 조회(RLA List) 수정 이벤트 처리<br>
	 * EQR_INLND_TRSP_PLN_QTY
	 * 
	 * @param vo
	 * @return
	 * @exception DAOException,Exception
	 */
	public int modifyRLARepoPlanDtInlandQty(EqrInlndTrspPlnQtyVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CntrRepoPlanManageDBDAOModifyRLARepoPlanDtInlandQtyUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * 컨테이너 수급 예측실적 및 정확도 조회(RLA List) 수정 이벤트 처리<br>
	 * EQR_ONF_HIR_PLN_QTY
	 * 
	 * @param vo
	 * @return
	 * @exception DAOException,Exception
	 */
	public int modifyRLARepoPlanDtOnOffQty(EqrOnfHirPlnQtyVO vo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		
		try {
			Map<String, String> mapVO = vo.getColumnValues();
			
			param.putAll(mapVO);
			
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new CntrRepoPlanManageDBDAOModifyRLARepoPlanDtOnOffQtyUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * EQR_VSL_LODG_DCHG_PLN 테이블에 Duplicate Data가 있는지 조회
	 * 
	 * @param vo EqrVslLodgDchgPlnVO
	 * @return resultCnt
	 * @throws DAOException
	 * @throws Exception
	 */
	public int isDupVslPlanData(EqrVslLodgDchgPlnVO vo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int resultCnt = 0;
		
		try{
			Map<String, String> mapVO = vo .getColumnValues();
			param.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanManageDBDAOSearchDupVslPlanDataRSQL(), param, velParam);
			
			while (dbRowset.next()) {
				resultCnt = dbRowset.getInt("CNT");
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultCnt;
	}
	
	/**
	 * EQR_INLND_TRSP_PLN 테이블에 Duplicate Data가 있는지 조회
	 * 
	 * @param vo EqrInlndTrspPlnVO
	 * @return resultCnt
	 * @throws DAOException
	 * @throws Exception
	 */
	public int isDupIndPlanData(EqrInlndTrspPlnVO vo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int resultCnt = 0;
		
		try{
			Map<String, String> mapVO = vo .getColumnValues();
			param.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanManageDBDAOSearchDupInlandPlnDataRSQL(), param, velParam);
			
			while (dbRowset.next()) {
				resultCnt = dbRowset.getInt("CNT");
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultCnt;
	}
	
	/**
	 * EQR_ONF_HIR_PLN 테이블에 On-Hire Duplicate Data가 있는지 조회
	 * 
	 * @param vo EqrOnfHirPlnVO
	 * @return resultCnt
	 * @throws DAOException
	 * @throws Exception
	 */
	public int isDupOnHirPlanData(EqrOnfHirPlnVO vo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int resultCnt = 0;
		
		try{
			Map<String, String> mapVO = vo .getColumnValues();
			param.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanManageDBDAOSearchDupOnHirePlnDataRSQL(), param, velParam);
			
			while (dbRowset.next()) {
				resultCnt = dbRowset.getInt("CNT");
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultCnt;
	}
	
	/**
	 * EQR_ONF_HIR_PLN 테이블에 Off-Hire Duplicate Data가 있는지 조회
	 * 
	 * @param vo EqrOnfHirPlnVO
	 * @return resultCnt
	 * @throws DAOException
	 * @throws Exception
	 */
	public int isDupOffHirPlanData(EqrOnfHirPlnVO vo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int resultCnt = 0;
		
		try{
			Map<String, String> mapVO = vo .getColumnValues();
			param.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoPlanManageDBDAOSearchDupOffHirePlnDataRSQL(), param, velParam);
			
			while (dbRowset.next()) {
				resultCnt = dbRowset.getInt("CNT");
			}
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return resultCnt;
	}
	 
}