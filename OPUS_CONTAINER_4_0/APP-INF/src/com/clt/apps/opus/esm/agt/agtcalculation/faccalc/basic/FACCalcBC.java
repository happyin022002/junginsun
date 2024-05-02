/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : FACCalcBC.java
*@FileTitle : FAC Calculation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.agt.agtcalculation.faccalc.basic;

import java.util.HashMap;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-AGT Business Logic Command Interface<br>
 * - OPUS-AGT handling Business Logic Command Interface<br>
 *
 * @author 
 * @see ESM_AGT_035EventResponse 
 * @since J2EE 1.4
 */
public interface FACCalcBC  {

	/**
	 * FAC Commission Calculate event process<br>
	 * 
	 * @param String bkg_no
	 * @return Object batch result
	 * @exception EventResponse
	 */
	public Object createFACComm(String bkg_no) throws EventException;
	

	/**
	 * FAC Commission Calculate event process<br>
	 * 
	 * @param String bkg_no
	 * @return int
	 * @exception EventResponse
	 */
	public int createFACCommInv(String bkg_no) throws EventException;
	
	/**
	 * batch implement event process<br>
	 * FAC calculation <br>
	 * 
	 * @param HashMap bkgMap
	 * @return String
	 * @exception EventException
	 */
	public String createActualFACComm(HashMap bkgMap) throws EventException;

    /**
     * ESM_AGT_033 Recalculation AR Interface event process<br>
     * 
     * @param  Event e
     * @return Object
     * @throws EventException
     */
    public Object reCalcFACComm(Event e) throws EventException;

    /**
     * ESM_AGT_033 Recalculation AR Interface event process<br>
     * 
     * @param  String bkg_no
     * @param  SignOnUserAccount account
     * @return Object batch result
     * @throws EventException
     */
    public Object recalcFACComm(String bkg_no, SignOnUserAccount account) throws EventException;

    /**
	 * FAC Cancel event process<br>
	 * 
	 * @param String bkg_no
	 * @param String FLG0507
	 * @exception EventException
	 */
	public void processFacCancel(String bkg_no, String FLG0507) throws EventException;

	
	/**
	 * Booking QTY retrieve event process<br>
	 * 
	 * @param HashMap bkgMap
	 * @return HashMap
	 * @exception EventException
	 */
	public HashMap searchBKGQTYInfo(HashMap bkgMap) throws EventException;
	

}