/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ForecastSummaryBC.java
*@FileTitle : Forecast Summary
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : JEONG MIN, PARK 
*@LastVersion : 1.0
* 
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.basic;

import java.util.List;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.vo.EQBalanceSheetListVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.vo.EQForecastSummaryINVO;
import com.hanjin.apps.alps.ees.eqr.cntrfcstsimul.forecastsummary.vo.EQForecastSummaryListVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * eNIS-BIZCOMMON Business Logic Command Interface<br>
 * - eNIS-BIZCOMMON에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Hyung Choon_Roh
 * @see ComEns0O1EventResponse 참조
 * @since J2EE 1.4
 */
public interface ForecastSummaryBC  {
	
	/**
	 * 조회 이벤트 처리<br>
	 * EQ Balance Sheet Set-up 화면에 대한 조회 이벤트 처리<br>
	 * @param eQForecastSummaryINVO
	 * @return List<EQBalanceSheetListVO>
	 * @exception EventException
	 */
	public List<EQBalanceSheetListVO> searchEQBalanceSheetList(EQForecastSummaryINVO eQForecastSummaryINVO) throws EventException;
	
	/**
	 * 입력, 수정이벤트 처리<br>
	 * EQ Forecast Summary Filter Save<br>
	 * @param eQBalanceSheetListVOs
	 * @param account
	 * @exception EventException
	 */
	public void manageEQForecastSummaryFilter(EQBalanceSheetListVO[] eQBalanceSheetListVOs, SignOnUserAccount account) throws EventException;

	/**
	 * EES_EQR_1101 : [이벤트]<br>
	 * RCC_CD, LOC_GRP_CD에 따른 LOCATION코드 조회 <br>
	 * GRID COMBO에 사용
	 * @param eQForecastSummaryINVO
	 * @return count
	 * @exception EventException
	 */
	public int checkLocationByGroupCode(EQForecastSummaryINVO eQForecastSummaryINVO) throws EventException;


	/**
	 * 조회 이벤트 처리<br>
	 * EQ Forecast Summary 화면에 대한 조회 이벤트 처리<br>
	 * @param eQForecastSummaryINVO
	 * @return List<EQForecastSummaryListVO>
	 * @exception EventException
	 */
	public List<EQForecastSummaryListVO> searchEQForecastSummaryList(EQForecastSummaryINVO eQForecastSummaryINVO) throws EventException;

	/**
	 * EQC Organization Chart 화면에 대한 저장 이벤트 처리<br>
	 * @param EQCOrgChartListVO[] eQCOrgChartListVOs
	 * @param SignOnUserAccount account
	 * @return int[]
	 * @exception EventException
	 */
//	public int[] multiEqrCtrlFcastLocBasic(EQCOrgChartListVO[] eQCOrgChartListVOs, SignOnUserAccount account) throws EventException;
}