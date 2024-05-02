/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName 		: CntrAccuracyTrendBC.java
*@FileTitle 	: Accuracy Trend
*Open Issues 	:
*Change history :
* No.	Ver.		Modifier			modifier date    explanation
* 1     1.0      	SHIN DONG IL		2013.07.11		 Creation
*
*@LastModifyDate : 2013.07.11
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2013.07.11 SHIN DONG IL
* 1.0 Creation 
=========================================================*/

package com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.basic;

import com.hanjin.apps.alps.ees.eqr.cntrcommon.eqrcommon.vo.CommonVO;
import com.hanjin.apps.alps.ees.eqr.cntrcommon.vo.CommonRsVO;

import com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1025ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1026ConditionVO;
import com.hanjin.apps.alps.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1066ConditionVO;

import com.hanjin.framework.core.layer.event.EventException;
//import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 *
 * @author SHIN DONG IL
 * @see EES_EQR_1025EventResponse 참조
 * @since J2EE 1.6
 */
public interface CntrAccuracyTrendBC {
	/**
	 * [ EES_EQR_1025 :  Loading Trend By Lane List ]<br>
	 * 화면 로딩시 기본 설정 데이터
	 * @param EesEqr1025ConditionVO condVO
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO searchLoadingTrendByLaneDefault(EesEqr1025ConditionVO condVO) throws EventException;
	
	/**
	 * [ EES_EQR_1025 : Loading Trend By Lane Search]<br>
	 * @param EesEqr1025ConditionVO condVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchLoadingTrendByLaneList(EesEqr1025ConditionVO condVO) throws EventException;
	
	/**
	 * 입력 받은 Loaction Code가 LCC/ECC/SCC에 해당하는지 체크<br>
	 * @param EesEqr1025ConditionVO condVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckLocCd(EesEqr1025ConditionVO condVO) throws EventException;
	
	/**
	 * 입력 받은 VVD CD 유효성 체크<br>
	 * @param EesEqr1025ConditionVO condVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckVvdCd(EesEqr1025ConditionVO condVO) throws EventException;
	 
	/**
	 * [ EES_EQR_1066 :  Loading Trend By Port ]<br>
	 * 화면 로딩시 기본 설정 데이터
	 * @param EesEqr1066ConditionVO condVO
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO searchLoadingTrendByPortDefault(EesEqr1066ConditionVO condVO) throws EventException;	 
	
	/**
	 * [ EES_EQR_1066 : Loading Trend By Port Search]<br>
	 * @param EesEqr1066ConditionVO condVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchLoadingTrendByPortList(EesEqr1066ConditionVO condVO) throws EventException;
	
	/**
	 * [ EES_EQR_1026 : Discharge Result Default ]<br>
	 * 화면 로딩시 기본 설정 데이터
	 * @param EesEqr1026ConditionVO condVO
	 * @return CommonVO
	 * @exception EventException
	 */
	public CommonVO searchDischargeResultDefault(EesEqr1026ConditionVO condVO) throws EventException;

	/**
	 * [ EES_EQR_1026 : Discharge Result Search]<br>
	 * @param EesEqr1026ConditionVO condVO
	 * @return CommonRsVO
	 * @exception EventException
	 */
	public CommonRsVO searchDischargeResultList(EesEqr1026ConditionVO condVO) throws EventException;	 	
	
	
}