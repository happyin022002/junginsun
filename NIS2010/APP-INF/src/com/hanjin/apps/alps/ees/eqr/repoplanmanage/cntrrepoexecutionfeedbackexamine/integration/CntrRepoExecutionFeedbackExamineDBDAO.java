/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrRepoExecutionFeedbackExamineDBDAO.java
*@FileTitle : 컨테이너 이송실행 실적 및 Feedback 조회
*Open Issues :
*Change history :
*-----------------------------------------------------------------------------
*	No.		Ver.	Modifier		Modifier Date		Explanation
*-----------------------------------------------------------------------------
*			1.0		ChangHoChae		2006-10-24			1.0 최초 생성
*					Shin YongChan	2007-09-14			CSR No : N200709077010 - Analysis기능보완
*					ChangHoChae		2007-11-22			CSR No : R200711194478 - 화면에 표현 되는 타이틀 변경 요청 
*					ChangHoChae		2007-12-26			CSR No : N200712050007
*														Change name : Execution Perf & F/back Report 보완 
*														Plan Volume : Plan ID Week 39주에 Week 40 Plan Data/실행계획/WO 실적
*																	(Plan 수량중에서 실행 계획 수량이 있는 Volume만 Plan ID Week 40에 추가) 
*																	+ Plan ID Week 40주에 Week 40 Plan Data/실행계획/WO 실적(전체 수량을 합산).
*					ChangHoChae		2008-03-19			CSR No : N200803170032
*														Change name : Execution Performance & Feedback Report 보완
*																	현재 Plan Data에서는 Fixed 수량에(Plan-VD) 대해서는 Plan 수량에서 제외되나
*																	Performance 수량 산출시에는 포함 되는 것으로 확인 되었는바,
*																	실적 Data 산출시에도 Plan Data와 동일하게 제외 요함
*					Shin YongChan	2008-04-10			CSR No : N200803110018
*					ChangHoChae		2008-05-19			Project_name : 신규 장비(F5-40ft H/C Flat rack) 발주에 따른 NIS 상에 F5 등록
*					Shin YongChan	2008-06-02			CSR No : N200805150003 - Perf. Ratio(c/a) 추가
*					Haeng-Ji,Lee	2009-01-14			CSR No : R200901140004 - Tuning 결과를 바탕으로 Query 재작업
*			1.0		Lee Byoung Hun	2009-09-23			New Framework 적용 Renewal
*-----------------------------------------------------------------------------
*@LastModifyDate : 2009.09.23
*@LastModifier : Lee Byoung Hun
*@LastVersion : 1.0
* 2009.09.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.ees.eqr.common.Utils;
import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.basic.CntrRepoExecutionFeedbackExamineBCImpl;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoexecutionfeedbackexamine.vo.EesEqr0063ConditionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS CntrRepoExecutionFeedbackExamineDBDAO <br>
 * - ALPS-RepoPlanManage system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see CntrRepoExecutionFeedbackExamineBCImpl 참조
 * @since J2EE 1.6
 */
public class CntrRepoExecutionFeedbackExamineDBDAO extends DBDAOSupport {

	/**
	 * 컨테이너 이송실행 실적 및 Feedback 조회 이벤트 처리 (Sheet1)<br>
	 * 
	 * @param EesEqr0063ConditionVO conditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchCntrRepoExecutionFeedback(EesEqr0063ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = conditionVO .getColumnValues();
			String fmPlnSYrWk   = conditionVO.getFmplnsyr() + conditionVO.getFmplnswk();
			String fmPlnEYrWk   = conditionVO.getFmplneyr() + conditionVO.getFmplnewk();
			String toPlnSYrWk   = conditionVO.getToplnsyr() + conditionVO.getToplnswk();
			String toPlnEYrWk   = conditionVO.getToplneyr() + conditionVO.getToplnewk();
			ArrayList arrFmEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getFmecccd());
			ArrayList arrToEccCd = (ArrayList) Utils.replaceStrToList(conditionVO.getToecccd());
			ArrayList arrOddtpszCd = (ArrayList) Utils.replaceStrToList(conditionVO.getOddtpsz());
			ArrayList arrLane = (ArrayList) Utils.replaceStrToList(conditionVO.getLane());
		
			param.putAll(mapVO);
			param.put("fmPlnSYrWk", fmPlnSYrWk);
			param.put("fmPlnEYrWk", fmPlnEYrWk);
			param.put("toPlnSYrWk", toPlnSYrWk);
			param.put("toPlnEYrWk", toPlnEYrWk);
			
			velParam.putAll(mapVO);
			velParam.put("fmPlnSYrWk", fmPlnSYrWk);
			velParam.put("fmPlnEYrWk", fmPlnEYrWk);
			velParam.put("toPlnSYrWk", toPlnSYrWk);
			velParam.put("toPlnEYrWk", toPlnEYrWk);
			
			velParam.put("arrFmEccCd", arrFmEccCd);
			velParam.put("arrToEccCd", arrToEccCd);
			velParam.put("arrOddtpszCd", arrOddtpszCd);
			velParam.put("arrLane", arrLane);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionFeedbackExamineDBDAOSearchCntrRepoExecutionFeedbackRSQL(), param, velParam);
			
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
	 * 해당주차의 전주차를 가져오는 로직
	 * 
	 * @param yrwk
	 * @return
	 * @exception DAOException
	 */
	public CommonRsVO searchBeforePlnWk(String yrwk) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("yrwk", yrwk);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionFeedbackExamineDBDAOSearchBeforePlnWkRSQL(), param, velParam);
			
			if (dbRowset.next()) {
				rsVO.setResultString(dbRowset.getString("PLNWEEK"));
			}
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
	 * 컨테이너 이송실행 실적 및 Feedback 조회 이벤트 처리 (Sheet2)<br>
	 * 
	 * @param EesEqr0063ConditionVO conditionVO
	 * @return CommonRsVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonRsVO searchCntrRepoExecutionFeedbcakExamine(EesEqr0063ConditionVO conditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonRsVO rsVO = new CommonRsVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = conditionVO .getColumnValues();
			String plnYrWk = conditionVO.getPlnYrwk().substring(0,4) + conditionVO.getPlnYrwk().substring(5,7);
			String beforePlnSYrWk = searchBeforePlnWk(conditionVO.getFmsyrwk()).getResultString();
			ArrayList arrHeadTitle = (ArrayList) Utils.replaceStrToList(conditionVO.getHeadtitle());
			ArrayList arroddtpszCd = (ArrayList) Utils.replaceStrToList(conditionVO.getOddtpsz());
		
			param.putAll(mapVO);
			param.put("plnYrWk", plnYrWk);
			param.put("beforePlnSYrWk", beforePlnSYrWk);
			
			velParam.putAll(mapVO);
			velParam.put("arrHeadTitle", arrHeadTitle);
			velParam.put("arroddtpszCd", arroddtpszCd);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new CntrRepoExecutionFeedbackExamineDBDAOSearchCntrRepoExecutionFeedbackExamineRSQL(), param, velParam);
			
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
	
}