/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCommCalculationBC.java
*@FileTitle : FFCommCalculationBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.16
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2012.05.16 박성진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.ffcommcalculation.basic;

import com.hanjin.framework.core.layer.event.EventException;

/**
 * ALPS-FFCalculation Business Logic Command Interface<br>
 * - ALPS-FFCalculation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author PARK, Sung-Jin
 * @see Esm_Acm_0027EventResponse 참조
 * @since J2EE 1.6
 */

public interface FFCommCalculationBC {

	/**
	 * [ESM_ACM_0027]
	 * FAC Audit Re Calculate 버튼 클릭 시 처리 한다.<br>
	 *
	 * @param String bkg_no
	 * @param String userId
	 * @exception EventException
	 */
	public void reCalculateFFComm(String bkg_no, String userId) throws EventException;

}