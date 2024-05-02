/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AGTCalcToCoaBCImpl.java
 *@FileTitle : Agent Monthly Calculation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.09.16
 *@LastModifier : 추경원
 *@LastVersion : 1.0
 * 2009.09.16 추경원
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtcalculation.agtcalctoinv.basic;

import com.hanjin.apps.alps.esm.agt.agtcalculation.faccalc.basic.FACCalcBC;
import com.hanjin.apps.alps.esm.agt.agtcalculation.faccalc.basic.FACCalcBCImpl;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;

/**
 * ALPS-AGTCalculation Business Logic Basic Command implementation<br>
 * - ALPS-AGTCalculation에 대한 비지니스 로직을 처리한다.<br>
 * 
 * @author Kyung-won Chu
 * @see EsmAgt0019EventResponse,AGTClosingBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class AGTCalcToInvBCImpl extends BasicCommandSupport implements AGTCalcToInvBC {

	/**
	 * Agent Commission Calculation 처리<br>
	 */
	public AGTCalcToInvBCImpl() {
	}
	/**
	 * Agent Commission Calculate 대한 처리<br>
	 * 
	 * @param String bkg_no
	 * @return int ( 정상 : cost 테이블 update 갯수, 실패 : -1)
	 * @exception EventException
	 */
	public int createFACComm(String bkg_no) throws EventException
	{
		int cnt = -1;
	    try {
	    	FACCalcBC faccalcbc = new FACCalcBCImpl();

	        cnt = faccalcbc.createFACCommInv(bkg_no);
	    } catch (EventException de) {
	        log.error("err " + de.toString(), de);
	        throw new EventException(de.getMessage());
	    }

		return cnt;
	}


}