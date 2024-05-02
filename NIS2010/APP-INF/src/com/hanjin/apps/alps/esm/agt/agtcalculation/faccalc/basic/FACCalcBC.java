/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : FACCalcBC.java
*@FileTitle : FAC Calculation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-01-15
*@LastModifier : Hwang GyeongNam
*@LastVersion : 1.0
* 2006-01-15 Hwang GyeongNam
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.agt.agtcalculation.faccalc.basic;

import java.util.HashMap;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * eNIS-AGT Business Logic Command Interface<br>
 * - eNIS-AGT에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author Hwang GyeongNam
 * @see ESM_AGT_035EventResponse 참조
 * @since J2EE 1.4
 */
public interface FACCalcBC  {

	/**
	 * FAC Commission Calculate 대한 처리<br>
	 * 
	 * @param String bkg_no
	 * @return Object 배치처리 결과
	 * @exception EventResponse
	 */
	public Object createFACComm(String bkg_no) throws EventException;
	

	/**
	 * FAC Commission Calculate 대한 처리<br>
	 * 
	 * @param String bkg_no
	 * @return int
	 * @exception EventResponse
	 */
	public int createFACCommInv(String bkg_no) throws EventException;
	
	/**
	 * 배치 처리<br>
	 * FAC비 계산 <br>
	 * 
	 * @param HashMap bkgMap
	 * @return String
	 * @exception EventException
	 */
	public String createActualFACComm(HashMap bkgMap) throws EventException;

    /**
     * ESM_AGT_033 화면에서 Recalculation 시 AR Interface 처리<br>
     * 
     * @param  Event e
     * @return Object
     * @throws EventException
     */
    public Object reCalcFACComm(Event e) throws EventException;

    /**
     * ESM_AGT_033 화면에서 Recalculation 시 AR Interface 처리<br>
     * 
     * @param  String bkg_no
     * @param  SignOnUserAccount account
     * @return Object 배치처리 결과
     * @throws EventException
     */
    public Object recalcFACComm(String bkg_no, SignOnUserAccount account) throws EventException;

    /**
	 * FAC Cancel 처리한다.<br>
	 * 
	 * @param String bkg_no
	 * @param String FLG0507
	 * @exception EventException
	 */
	public void processFacCancel(String bkg_no, String FLG0507) throws EventException;

	
	/**
	 * Booking QTY물량을 구한다.<br>
	 * 
	 * @param HashMap bkgMap
	 * @return HashMap
	 * @exception EventException
	 */
	public HashMap searchBKGQTYInfo(HashMap bkgMap) throws EventException;
	

}