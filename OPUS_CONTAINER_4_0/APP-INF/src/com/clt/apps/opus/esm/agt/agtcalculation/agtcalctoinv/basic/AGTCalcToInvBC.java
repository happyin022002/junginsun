/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AGTCalcToCoaBC.java
 *@FileTitle : Agent Monthly Calculation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.16
 *@LastModifier : 추경원
 *@LastVersion : 1.0
 * 2009.09.16 추경원
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.agt.agtcalculation.agtcalctoinv.basic;

import com.clt.framework.core.layer.event.EventException;

/**
 * OPUS-AGTCalculation Business Logic Basic Command<br>
 * - OPUS-AGTCalculation에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kyung-won Chu
 * @see AGTCalcToInvBC
 * @since J2EE 1.6
 */
public interface AGTCalcToInvBC {

	/**
	 * Agent Commission Calculate 대한 처리<br>
	 * 
	 * @param String bkg_no
	 * @return int ( 정상 : cost 테이블 update 갯수, 실패 : -1)
	 * @exception EventException
	 */
	public int createFACComm(String bkg_no) throws EventException;

}