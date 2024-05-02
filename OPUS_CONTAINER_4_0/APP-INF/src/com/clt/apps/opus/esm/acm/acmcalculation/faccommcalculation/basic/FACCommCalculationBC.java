/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACCommCalculationBC.java
*@FileTitle : FACCommCalculationBC
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.16
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2012.05.16 박성진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.basic;

import com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.vo.SearchAgnBookingInfoVO;
import com.clt.framework.core.layer.event.EventException;

/**
 * OPUS-FACCalculation Business Logic Command Interface<br>
 * - OPUS-FACCalculation에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author PARK, Sung-Jin
 * @see Esm_Acm_0028EventResponse 참조
 * @since J2EE 1.6
 */

public interface FACCommCalculationBC {

	/**
	 * [ESM_ACM_0028]
	 * FAC Audit Re Calculate 버튼 클릭 시 처리 한다.<br>
	 *
	 * @param String bkgNo
	 * @param String userId
	 * @exception EventException
	 */
	public void reCalculateFACComm(String bkgNo, String userId) throws EventException;

	/**
	 * [INV]
	 * FAC Re Calculate<br>
	 *
	 * @param String bkgNo
	 * @return int
	 * @exception EventException
	 */
	public int createFACCommInv(String bkgNo) throws EventException;

	/**
	 * FAC Master 조회한다.<br>
	 *
	 * @param String bkgNo
	 * @return SearchAgnBookingInfoVO
	 * @exception EventException
	 */
	public SearchAgnBookingInfoVO searchFACMaster(String bkgNo) throws EventException;
	/**
	 * FAC Cancel 처리한다.<br>
	 *
	 * @param String bkg_no
	 * @exception EventException
	 */
	public void addFACMasterHistory(String bkg_no) throws EventException;

}