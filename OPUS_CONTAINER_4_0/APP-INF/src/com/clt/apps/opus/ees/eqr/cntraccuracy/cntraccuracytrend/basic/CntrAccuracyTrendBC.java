/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrAccuracyTrendBC.java
*@FileTitle : Accuracy Trend
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :  
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.basic;

import com.clt.apps.opus.ees.eqr.cntrcommon.eqrcommon.vo.CommonVO;
import com.clt.apps.opus.ees.eqr.cntrcommon.vo.CommonRsVO;

import com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1025ConditionVO;
import com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1026ConditionVO;
import com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1066ConditionVO;

import com.clt.framework.core.layer.event.EventException;
//import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 *
 * @author 
 * @see EES_EQR_1025EventResponse 
 * @since J2EE 1.6
 */
public interface CntrAccuracyTrendBC {
	/**
	 * [ EES_EQR_1025 :  Loading Trend By Lane List ]<br>
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
	 * Loaction Code LCC/ECC/SCC <br>
	 * @param EesEqr1025ConditionVO condVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckLocCd(EesEqr1025ConditionVO condVO) throws EventException;
	
	/**
	 * VVD CD<br>
	 * @param EesEqr1025ConditionVO condVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckVvdCd(EesEqr1025ConditionVO condVO) throws EventException;
	 
	/**
	 * [ EES_EQR_1066 :  Loading Trend By Port ]<br>
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