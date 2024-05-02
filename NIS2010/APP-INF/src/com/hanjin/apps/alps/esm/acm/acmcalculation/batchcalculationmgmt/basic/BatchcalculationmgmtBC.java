/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACCommCalculationBC.java
*@FileTitle : FACCommCalculationBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.05
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.07.05 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcalculation.batchcalculationmgmt.basic;

import com.hanjin.framework.core.layer.event.EventException;


/**
 * ALPS-FACCalculation Business Logic Command Interface<br>
 * - ALPS-FACCalculation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Kim Young-Oh
 * @see Esm_Acm_0012EventResponse 참조
 * @since J2EE 1.6
 */

public interface BatchcalculationmgmtBC {
	/**
	 * ACM_COMM_UT_COST_PRC 프로시져 호출한다.<br>
	 * 
	 * @param String bkg_no
	 * @param String usr_id
	 * @exception EventException
	 */
	public void manageCalculationBatchList(String bkg_no, String usr_id) throws EventException;

}