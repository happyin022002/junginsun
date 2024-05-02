/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrForecastPrecisionManageBC.java
*@FileTitle : CntrForecastPrecisionManageBC
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.10.07 
* 1.0 Creation
* =======================================================
* 2011.06.13 나상보 [CHM-201111518-01] [EQR]  MTY Rail Trans. 화면의 CNTR List 조회 기능 추가
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.eqr.common.vo.CommonRsVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.vo.EesEqr0037ConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.vo.MtyRailConditionVO;
import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrforecastprecisionmanage.vo.MtyRailDetailVO;
import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-CntrForecastPrecisionManage Business Logic Command Interface<br>
 * - ALPS-CntrForecastPrecisionManage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Haeng-ji,Lee
 * @see EventException 참조
 * @since J2EE 1.6
 */
public interface CntrForecastPrecisionManageBC { 

	/**
	 * [ EES_EQR_0141 : MTY Rail Arrival Inquiry ]<br>
	 * 
	 * @param MtyRailConditionVO mtyRailConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchMtyRailArrival(MtyRailConditionVO mtyRailConditionVO) throws EventException;
	/**
	 * [ EES_EQR_0142 : MTY Rail Trans Result ]<br>
	 * 
	 * @param MtyRailConditionVO mtyRailConditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchMtyRailResult(MtyRailConditionVO mtyRailConditionVO) throws EventException;
	
	/**
	 * 컨테이너 수급 예측실적 및 정확도 조회 이벤트 처리<br>
	 * 
	 * @param EesEqr0037ConditionVO	conditionVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchCntrForecastPerformance(EesEqr0037ConditionVO conditionVO) throws EventException;
	
	/**
	 * [ EES_EQR_0141 : MTY Rail Arrival Inquiry ]<br>
	 * 
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchMtyRailArrivalUSTime() throws EventException;
	
	/**
	 * [ EES_EQR_0141 : MTY Rail Arrival Inquiry ]<br>
	 * 
	 * @param MtyRailConditionVO mtyRailConditionVO
	 * @return List<MtyRailDetailVO>
	 * @exception EventException
	 */
	public List<MtyRailDetailVO> searchMtyRailArrivalDetail(MtyRailConditionVO mtyRailConditionVO) throws EventException;
	
	/**
	 * [ EES_EQR_0142 : MTY Rail Trans Result ]<br>
	 * 
	 * @param MtyRailConditionVO mtyRailConditionVO
	 * @return List<MtyRailDetailVO>
	 * @exception EventException
	 */
	public List<MtyRailDetailVO> searchMtyRailResultDetail(MtyRailConditionVO mtyRailConditionVO) throws EventException;
}