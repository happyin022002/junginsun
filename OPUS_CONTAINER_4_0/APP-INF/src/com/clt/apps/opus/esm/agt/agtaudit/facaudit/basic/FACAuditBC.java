/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : FACAuditBC.java
*@FileTitle : FAC Commission Maintenance Management
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit.facaudit.basic;

import java.util.List;

import com.clt.apps.opus.esm.agt.agtaudit.facaudit.vo.AGTFACRateInfoVO;
import com.clt.apps.opus.esm.agt.agtaudit.facaudit.vo.FACCommDetailBasicbyBLVO;
import com.clt.apps.opus.esm.agt.agtaudit.facaudit.vo.FACCommDetailChargebyBLVO;
import com.clt.apps.opus.esm.agt.agtaudit.facaudit.vo.FACCommDetailHistorybyBLVO;
import com.clt.apps.opus.esm.agt.agtaudit.facaudit.vo.FACCommVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-AGT Business Logic Command Interface<br>
 * - OPUS-AGT handling Business Logic Command Interface<br>
 *
 * @author 
 * @see AGTAuditSC 
 * @since J2EE 1.4
 */
public interface FACAuditBC  {

	/**
	 * ESM_AGT_033 Agreement Commission recalculate<br>
	 * 
	 * @param e ESM_AGT_033Event
	 * @return EventResponse ESM_AGT_033EventResponse
	 * @exception EventException
	 */
	public EventResponse reCalcFACComm(Event e) throws EventException;


	/**
	 * ESM_AGT_033 Agreement Commission recalculate event process<br>
	 * 
	 * @param String bkg_no
	 * @param SignOnUserAccount account
	 * @return EventResponse ESM_AGT_033EventResponse
	 * @exception EventException
	 */
	public EventResponse recalcFACComm(String bkg_no, SignOnUserAccount account) throws EventException;

	/**
	 * retrieve event process<br>
	 * ESM_AGT_033 retrieve event process<br>
	 * 
	 * @param FACCommVO facCommVO
	 * @return List<FACCommVO>
	 * @exception EventException
	 */
	public List<FACCommVO> searchFACCommList(FACCommVO facCommVO) throws EventException;

    /**
     * (ESM_AGT_015) FAC Commission Basic retrieve event process
     * @param FACCommDetailBasicbyBLVO facCommDetailBasicbyBLVO
     * @return List<FACCommDetailBasicbyBLVO>
     * @throws EventException
     */
	public List<FACCommDetailBasicbyBLVO> searchFACCommDetailBasicbyBL(FACCommDetailBasicbyBLVO facCommDetailBasicbyBLVO) throws EventException;
	/**
	 * (ESM_AGT_015) Charge Detail retrieve event process
	 * @param FACCommDetailChargebyBLVO facCommDetailChargebyBLVO
	 * @return List<FACCommDetailChargebyBLVO> 
	 * @throws EventException
	 */
	public List<FACCommDetailChargebyBLVO> searchFACCommDetailChargebyBL(FACCommDetailChargebyBLVO facCommDetailChargebyBLVO) throws EventException;
	/**
	 * (ESM_AGT_015) FAC Commission History Detail retrieve event process
	 * @param FACCommDetailHistorybyBLVO facCommDetailHistorybyBLVO
	 * @return List<FACCommDetailHistorybyBLVO>
	 * @throws EventException
	 */
	public List<FACCommDetailHistorybyBLVO> searchFACCommDetailHistorybyBL(FACCommDetailHistorybyBLVO facCommDetailHistorybyBLVO) throws EventException;
	/**
	 * (ESM_AGT_015) actually calculated Commission FAC Agreement rate retrieve event process
	 * @param AGTFACRateInfoVO agtFacRateInfoVO
	 * @return List<AGTFACRateInfoVO>
	 * @throws EventException
	 */
	public List<AGTFACRateInfoVO> searchAGTFACRateInfo(AGTFACRateInfoVO agtFacRateInfoVO) throws EventException;
	
	
	/**
	 * ESM_AGT_034 retrieve event process<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 *
	public EventResponse searchAPActualInterfaceMasterForFAC(Event e) throws EventException;

	/**
	 * ESM_AGT_034 retrieve event process<br>
	 * 
	 * @param e ESM_AGT_034Event
	 * @return EventResponse ESM_AGT_034EventResponse
	 * @exception EventException
	 *
	public EventResponse searchAPActualInterfaceDetailForFAC(Event e) throws EventException;

	**
     * ESM_AGT_034  AP Interface event process : AP IF implement<br>
     * 
     * @param  Event e
     * @return EventResponse 
     * @throws EventException
     *
    public EventResponse createFACActualINFtoAP(Event e) throws EventException;
    **
	 * print event process<br>
	 * ESM_AGT_034 print event process<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 *
	public EventResponse searchFACInfoForPrint(Event e) throws EventException;
    **
     * ESM_AGT_034 AP Interface event process : AP CANCEL IF event process<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @throws EventException
     *
    public EventResponse createCancelFACActualINFtoAP(Event e) throws EventException;
    */
    /**
     * ESM_AGT_033 Recalculation AR Interface event process<br>
     * 
     * @param  String[][] array
     * @throws EventException
     */
    public void reCalcEAINISFACCommInfo(String[][] array) throws EventException;
    
	
}