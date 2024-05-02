/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : TESCommonBC.java
 *@FileTitle : TES Common에 대한 비지니스 로직에 대한 인터페이스 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016-03-08 KHS
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.tescommon.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * TES Business Logic Command Interface<br>
 * - TES Common에 대한 비지니스 로직에 대한 인터페이스<br>
 * 
 * @author KHS
 * @see TESCommonHTMLAction, TESCommonBC
 * @since J2EE 1.4
 */
public interface TESCommonBC {

	/**
	 * Retrieve Currency Code List <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCurrencyCodeList(Event e) throws EventException;
	
	/**
	 * Retrieve Common Code List <br>
	 * CNTR_TPSZ_CD, MT_A_LGS_COST_CD, ON_A_LGS_COST_CD, OT_A_LGS_COST_CD, OS_A_LGS_COST_CD, ST_A_LGS_COST_CD, CARR_CD, EQ_TPSZ_CD <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCommonCodeList(Event e) throws EventException;
	
	/**
	 * Retrieve WHLD_TAX_AMT_MODE <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchWhldTaxAmtMode(Event e) throws EventException;
	
	/**
	 * Retrieve Manual Lgs Cost Cd <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchManualLgsCostCdList(Event e) throws EventException;
	
	/**
	 * Retrieve Service Provider Name <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchServiceProviderName(Event e) throws EventException;
	
	/**
	 * Retrieve Invoice Duplication YN <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvDuplicateYN(Event e) throws EventException;
	
	/**
	 * Retrieve Error Invoice Validation YN <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchErrInvValidYN(Event e) throws EventException;
	
	/**
	 * Retrieve Yard Code Validation & Cost Code List <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchYdCdCostCdList(Event e) throws EventException;
	
	/**
	 * Retrieve Office Code <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOfcCd(Event e) throws EventException;
	
	/**
	 * Retrieve Sub Trade Code List <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSubTrdCdList(Event e) throws EventException;
	
	/**
	 * Retrieve Agreement Cost Code List <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAgmtCostCdList(Event e) throws EventException;
	
	/**
	 * Retrieve Agreement Status Code <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAgmtStatusCd(Event e) throws EventException;
	
	/**
	 * Retrieve SLane Code <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSLanCd(Event e) throws EventException;
	
	/**
	 * Retrieve Cost Office Validation YN <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCostOfcValidYN(Event e) throws EventException;
	
	/**
	 * Retrieve Agreement Curr Cd <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAgmtCurrCd(Event e) throws EventException;
	
	/**
	 * Retrieve Equipment Type Size <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEquipTypeCd(Event e) throws EventException;
	
	/**
	 * Retrieve Authorization Office Code <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAuthOfcCd(Event e) throws EventException;
	
	/**
	 * Retrieve Yard Code Validation <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchYdCdValid(Event e) throws EventException;
	
	/**
	 * Retrieve Vendor Code Validation <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchVndrCdValid(Event e) throws EventException;
	
	/**
	 * Retrieve CURR_DATE (GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC) <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchDBDate(Event e) throws EventException;
	
	/**
	 * Retrieve Cost Office Validation Delete YN <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCostOfcValidDelYN(Event e) throws EventException;
	
	/**
	 * Retrieve Invoice Office Validation Delete YN <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvOfcValidDelYN(Event e) throws EventException;
	
	/**
	 * Retrieve Cost Code <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCostCode(Event e) throws EventException;
	
	/**
	 * Retrieve Node Code List <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchNodeCdList(Event e) throws EventException;
	
	/**
	 * Retrieve Container Type Size <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCntrTpSz(Event e) throws EventException;
}