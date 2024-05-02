/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ForecastReoprtBC.java
*@FileTitle : Forecast Report
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.eqr.cntrcommon.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.EesEqr1048ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.EesEqr1049ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.EesEqr1081ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.EesEqr1082ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.EesEqr1083ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.ForecastReportCommonListVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.ForecastReportListVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.ForecastReportOptionVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastreport.vo.PlannedRepoInVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * ALPS-MTYWeeklySimulation Business Logic Command Interface<br>
 * - ALPS-MTYWeeklySimulation 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author la sang bo
 * @see Ees_cim_5010EventResponse 참조
 * @since J2EE 1.6
 */

public interface ForecastReportBC {
	
	/**
	 *  지점별로 향후 -2~+7 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param ForecastReportOptionVO forecastReportOptionVO
	 * @param SignOnUserAccount account
	 * @return CommonRsVO
	 * @throws EventException
	 */
	public CommonRsVO searchForecastReportBasic(ForecastReportOptionVO forecastReportOptionVO, SignOnUserAccount account) throws EventException;
	
	/**
	 *  지점별로 향후 -1~+4 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param ForecastReportOptionVO forecastReportOptionVO
	 * @return List<MtyWeeklySimulationVO>
	 * @throws DAOException
	 */
//	public List<ForecastReportVO> searchMtyWeeklySimulation(ForecastReportOptionVO forecastReportOptionVO) throws EventException;
	 
	/**
	 * User의 Office level을 체크
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String checkMtyBalanceRepoOutYard(String ofcCd) throws EventException;
	 
	/**
	 * 해당 셀의 원래 값을 조회<br>
	 * 
	 * @param ForecastReportOptionVO forecastReportOptionVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchMtyWeeklySimulationOrigin(ForecastReportOptionVO forecastReportOptionVO) throws EventException;
	 
	 /**
	 * mty weekly data를 신규 입력/수정<br>
	 * 
	 * @param ForecastReportOptionVO[] forecastReportOptionVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMtyWeeklySimulation(ForecastReportOptionVO[] forecastReportOptionVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 *  지점별로 이전 수 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param ForecastReportOptionVO forecastReportOptionVO
	 * @return String
	 * @throws EventException
	 */
	public String searchMtyWeeklySimulationReportTitle(ForecastReportOptionVO forecastReportOptionVO) throws EventException; 

	/**
	 *  지점별로 이전 수 weeks의 예상 MTY 장비 Supply & Demand를 항목별로 입력된 MTY Balance Data를 조회한다.<br>
	 * 
	 * @param ForecastReportOptionVO forecastReportOptionVO
	 * @param String rptTtl
	 * @return CommonRsVO
	 * @throws EventException
	 */
	public CommonRsVO searchMtyWeeklySimulationReport(ForecastReportOptionVO forecastReportOptionVO, String rptTtl) throws EventException;

	/**
	 * 입력 받은 rcc/lcc/ecc가 해당 rcc에 속하는지 체크
	 * 
	 * @param ForecastReportOptionVO forecastReportOptionVO
	 * @return String
	 * @exception EventException
	 */
	public String checkSubLocCd(ForecastReportOptionVO forecastReportOptionVO) throws EventException;

// 1048
 	/**
	 * EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 조회한다.<br>
	 * 
	 * @param EesEqr1048ConditionVO eesEqr1048ConditionVO
	 * @return List<ForecastRepotListVO>
	 * @exception EventException
	 */
	public List<ForecastReportListVO> searchMtyRepoInDetailList(EesEqr1048ConditionVO eesEqr1048ConditionVO) throws EventException;
	
	/**
	 *  EQR의 Execution Plan에서 생성된 ECC별 MTY 선적 및 양하 계획을 조회한다<br>
	 * 
	 * @param EesEqr1048ConditionVO eesEqr1048ConditionVO
	 * @return List<ForecastReportListVO>
	 * @exception EventException
	 */
	public List<ForecastReportListVO> searchMtyBalanceDischargedList(EesEqr1048ConditionVO eesEqr1048ConditionVO) throws EventException;
	
	/**
	 *  VVD를 이용해 slan cd를 조회한다.<br>
	 * 
	 * @param ForecastReportListVO forecastReportListVO
	 * @return String
	 * @exception EventException
	 */
	public String searchMtyBalanceRepoOutSlanCd(ForecastReportListVO forecastReportListVO) throws EventException;
	
	/**
	 * 특정 주차내의 일자 목록을 조회한다<br>
	 * 
	 * @param String wk_st_dt
	 * @return List<ForecastReportCommonListVO>
	 * @exception EventException
	 */
	public List<ForecastReportCommonListVO> searchLocationDateList(String wk_st_dt) throws EventException;	
	
	/**
	 * LCC/ECC/SCC 에 속한 LOCATION<br>
	 * 
	 * @param String locGrpCd
	 * @param String locCd
	 * @return List<ForecastReportCommonListVO>
	 * @exception EventException
	 */
	public List<ForecastReportCommonListVO> searchLocationList(String locGrpCd, String locCd) throws EventException;

	/**
	 * REPO IN 데이터를 수기로 관리하는 기능 처리<br>
	 * 
	 * @param ForecastReportListVO[] forecastReportListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMtyRepoInDetailList(ForecastReportListVO[] forecastReportListVOs, SignOnUserAccount account) throws EventException;
	
	
	// 1048	
	
	// 1040
	/**
	 * PLANNED REPO IN 데이터를 조회한다.<br>
	 * 
	 * @param EesEqr1048ConditionVO eesEqr1048ConditionVO
	 * @return List<PlannedRepoInVO>
	 * @exception EventException
	 */
	public List<PlannedRepoInVO> searchPlannedRepoInBasic(EesEqr1048ConditionVO eesEqr1048ConditionVO) throws EventException;

	/**
	 * PLANNED REPO IN 데이터를 수기로 관리하는 기능 처리<br>
	 * 
	 * @param PlannedRepoInVO[] plannedRepoInVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void managePlannedRepoInBasic(PlannedRepoInVO[] plannedRepoInVOs, SignOnUserAccount account) throws EventException;

	/**
	 * 해당 셀의 원래 값을 조회<br>
	 * 
	 * @param PlannedRepoInVO plannedRepoInVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchPlannedRepoInOriginBasic(PlannedRepoInVO plannedRepoInVO) throws EventException;
	
	/**
	 * 해당 셀의 원래 값을 조회<br>
	 * 
	 * @param EesEqr1048ConditionVO eesEqr1048ConditionVO
	 * @return String
	 * @exception DAOException
	 */
	public String checkPlannedRepoInYardBasic(EesEqr1048ConditionVO eesEqr1048ConditionVO) throws EventException;
	
 	/**
	 * EQR의 Execution Plan에서 생성된 ECC별 MTY Load 데이터 조회한다.<br>
	 * 
	 * @param EesEqr1049ConditionVO eesEqr1049ConditionVO
	 * @return List<ForecastRepotListVO>
	 * @exception EventException
	 */
	public List<ForecastReportListVO> searchMtyRepoOutDetailList(EesEqr1049ConditionVO eesEqr1049ConditionVO) throws EventException;

	/**
	 * REPO OUT 데이터를 수기로 관리하는 기능 처리<br>
	 * 
	 * @param ForecastReportListVO[] forecastReportListVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageMtyRepoOutDetailList(ForecastReportListVO[] forecastReportListVOs, SignOnUserAccount account) throws EventException;
	
 	/**
	 * Reposition In Detail 과거실적 조회.<br>
	 * 
	 * @param EesEqr1081ConditionVO eesEqr1081ConditionVO
	 * @return List<ForecastRepotListVO>
	 * @exception EventException
	 */
	public List<ForecastReportListVO> searchMtyRepoInDetailPastList(EesEqr1081ConditionVO eesEqr1081ConditionVO) throws EventException;
		
 	/**
	 * Reposition Out Detail 과거실적 조회.<br>
	 * 
	 * @param EesEqr1082ConditionVO eesEqr1082ConditionVO
	 * @return List<ForecastRepotListVO>
	 * @exception EventException
	 */
	public List<ForecastReportListVO> searchMtyRepoOutDetailPastList(EesEqr1082ConditionVO eesEqr1082ConditionVO) throws EventException;

 	/**
	 * Reposition Other Detail 과거실적 조회.<br>
	 * 
	 * @param EesEqr1083ConditionVO eesEqr1083ConditionVO
	 * @return List<ForecastRepotListVO>
	 * @exception EventException
	 */
	public List<ForecastReportListVO> searchMtyRepoOtherDetailPastList(EesEqr1083ConditionVO eesEqr1083ConditionVO) throws EventException;
			
	// 1040(E)
}