/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : OndockRailChargeInvoiceManageBC.java
*@FileTitle : On-dock Rail Charge Invoice Confirm-Coincidence
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.basic;

import java.sql.SQLException;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.integration.DAOException;

/**
 * ESD Business Logic Command Interface<br>
 *
 * @author parkyeonjin
 * @see ESD_TES_064EventResponse
 * @since J2EE 1.4
 */
public interface OndockRailChargeInvoiceManageBC  {


	/**
	 * retrieve event process
	 * OndockRailChargeInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_064Event
	 * @return EventResponse ESD_TES_064EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOndockRailChargeBasicInfo (Event e) throws EventException;

	/**
	 * retrieve event process
	 * OndockRailChargeInvoiceManage Create Event Process<br>
	 *
	 * @param e ESD_TES_064Event
	 * @return EventResponse ESD_TES_064EventResponse
	 * @exception EventException
	 */
	public EventResponse createOndockRailChargeBasicInfo(Event e) throws EventException;

	/**
	 * Modify Event Process<br>
	 * OndockRailChargeInvoiceManage Modify Event Process<br>
	 *
	 * @param e ESD_TES_064Event
	 * @return EventResponse ESD_TES_064EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyOndockRailChargeBasicInfo(Event e) throws EventException;
	/**
	 * ContainerList Verify Event Process<br>
	 * OndockRailChargeInvoiceManage ContainerList Verify  Event Process<br>
	 *
	 * @param e ESD_TES_913Event
	 * @return EventResponse ESD_TES_913EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyOndockRailChargeContainerList(Event e) throws EventException;


	/**
	 * ContainerList Verify Event Process<br>
	 * OndockRailChargeInvoiceManage ContainerList Verify  Event Process<br>
	 *
	 * @param e ESD_TES_913Event
	 * @return EventResponse ESD_TES_913EventResponse
	 * @exception EventException
	 */
	public EventResponse createTES_FILE_IMP_TMP(Event e) throws EventException;

	/**
	 * ContainerList Verify Event Process<br>
	 * OndockRailChargeInvoiceManage ContainerList Verify  Event Process<br>
	 *
	 * @param e ESD_TES_913Event
	 * @return EventResponse ESD_TES_913EventResponse
	 * @exception EventException
	 */
	public EventResponse createOndockRailChargeContainerList(Event e) throws EventException;

//	/**
//	 * ContainerList Verify시 CNTRList Delete <br>
//	 * OndockRailChargeInvoiceManage ContainerList Verify  Event Process<br>
//	 *
//	 * @param e ESD_TES_913Event
//	 * @return EventResponse ESD_TES_913EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse deleteOndockRailChargeContainerList(Event e) throws EventException;
	
	/**
	 * ContainerList Verify Event Process<br>
	 * OndockRailChargeInvoiceManage ContainerList Verify  Event Process<br>
	 *
	 * @param e ESD_TES_913Event
	 * @return EventResponse ESD_TES_913EventResponse
	 * @exception EventException
	 */
	public EventResponse removeTES_FILE_IMP_TMP(Event e) throws EventException;


	/**
	 * OndockRailChargeContainerList Multi Event Process<br>
	 * OndockRailChargeContainerList event OndockRailChargeContainerList Multi Event Process<br>
	 *
	 * @param e ESD_TES_064Event
	 * @return EventResponse ESD_TES_064EventResponse
	 * @exception EventException
	 */
	public EventResponse multiOndockRailChargeContainerList(Event e) throws EventException;
	
	/** multiOnDockTerminalInvoiceDBVerify
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse multiOnDockTerminalInvoiceDBVerify(Event e) throws EventException;
	
	/**
	 * OndockRailChargeContainerList retrieve event process
	 * OndockRailChargeContainerList event OndockRailChargeContainerList retrieve event process
	 *
	 * @param e ESD_TES_064Event
	 * @return EventResponse ESD_TES_064EventResponse
	 * @exception EventException
	 */


	public EventResponse searchOndockRailChargeContainerList(Event e) throws EventException;


	/**
	 * InvoiceDetail Multi Event Process<br>
	 * ESD_TES_064 InvoiceDetail Multi Event Process<br>
	 *
	 * @param e ESD_TES_064Event
	 * @return EventResponse ESD_TES_064EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOndockRailChargeInvoiceCost(Event e) throws EventException;

	/** searchDBCheckOnDockTerminalInvoice
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDBCheckOnDockTerminalInvoice(Event e) throws EventException; 
	
	/**
	 * OndockRailChargeCostCalculationList retrieve event process
	 * OndockRailChargeInvoiceManage event OndockRailChargeCostCalcurationList retrieve event process
	 *
	 * @param e ESD_TES_064Event
	 * @return EventResponse ESD_TES_064EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOndockRailChargeCostCalculationList(Event e) throws EventException;
	/**
	 * CostCalcComboCodeList retrieve event process
	 * OndockRailChargeInvoiceManage CostCalcComboCodeList retrieve event process
	 *
	 * @param e ESD_TES_064Event
	 * @return response ESD_TES_064EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOnDockChargeInvoiceCostCalcComboCodeList(Event e) throws EventException;
	/**
	 * InvoiceDetail Multi Event Process<br>
	 * ESD_TES_064 InvoiceDetail Multi Event Process<br>
	 *
	 * @param e ESD_TES_064Event
	 * @return EventResponse ESD_TES_064EventResponse
	 * @exception EventException
	 */
	public EventResponse multiOndockRailChargeInvoiceDetail(Event e) throws EventException;
//	/**
//	 * TML_SO_RVIS_LIST retrieve event process
//	 * MarineTerminalInvoiceManage TML_SO_RVIS_LIST retrieve event process
//	 *
//	 * @param e ESD_TES_064Event
//	 * @return response ESD_TES_064EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse searchOndockRailChargeInvoiceRvisList(Event e) throws EventException;
//	/**
//	 * TerminalInvoiceN3rdPartyIF LIST retrieve event process
//	 * MarineTerminalInvoiceManage TerminalInvoiceN3rdPartyIF LIST retrieve event process
//	 *
//	 * @param e ESD_TES_064Event
//	 * @return response ESD_TES_064EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse searchOndockRailChargeInvoiceN3ptyList(Event e) throws EventException;
//

	/**
	 * Revised Vol List retrieve event process
	 * MarineTerminalInvoiceManage Revised Vol List retrieve event process
	 *
	 * @param e ESD_TES_903_1Event
	 * @return response ESD_TES_903_1EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAutoRevisedVolume(Event e) throws EventException;

	/**
	 * Add Event Process<br>
	 * MarineTerminalInvoiceManage Add Event Process<br>
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse updateOnDockContainerListRvisFlg(Event e) throws EventException ;

	/**
	 * Revised Vol List retrieve event process
	 * MarineTerminalInvoiceManage Revised Vol List retrieve event process
	 *
	 * @param e Event 
	 * @return response ESD_TES_903_1EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceRevisedVolume9031(Event e) throws EventException;

	/**
	 * Revised Vol List retrieve event process
	 * MarineTerminalInvoiceManage Revised Vol List retrieve event process
	 *
	 * @param e ESD_TES_903_1Event
	 * @return response ESD_TES_903_1EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceRevisedVolume(Event e) throws EventException;

	/**
	 * TerminalInvoiceN3ptyAutoCntrList retrieve event process
	 * MarineTerminalInvoiceManage TerminalInvoiceN3ptyAutoCntrList retrieve event process
	 *
	 * @param e ESD_TES_923_1Event
	 * @return response ESD_TES_923_1EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceN3ptyAutoCntrList(Event e) throws EventException;
	/**
	 * TerminalInvoiceN3ptyManualCntrList retrieve event process
	 * MarineTerminalInvoiceManage TerminalInvoiceN3ptyManualCntrList retrieve event process
	 *
	 * @param e ESD_TES_923_1Event
	 * @return response ESD_TES_923_1EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceN3ptyManualCntrList(Event e) throws EventException;


	/**
	 * 3rd Party retrieve event process
	 * MarineTerminalInvoiceManage3rd Party retrieve event process
	 *
	 * @param e ESD_TES_925_1Event
	 * @return response ESD_TES_925_1EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOnDockTrdPartyVolume(Event e) throws EventException;


	/**
	 * 3rd Party retrieve event process
	 * MarineTerminalInvoiceManage3rd Party retrieve event process
	 *
	 * @param e ESD_TES_9260Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse  searchOnDockTotalAmount(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * OndockRailCharge Container List retrieve Event Process<br>
	 * @param  Event e
	 * @return response EventResponse
	 * @throws EventException
	 */
	public EventResponse  searchOndockRailChargeBasicInfo2(Event e) throws EventException;

	/**
	 * retrieve event process
	 * OndockRailCharge Container List retrieve Container List(Coincidency/Discrepancy) retrieve event process
	 * 
	 * @param  Event e
	 * @return response EventResponse
	 * @throws EventException
	 */
	public EventResponse searchOndockRailChargeContainerList2(Event e) throws EventException;

	/** searchOndockRailChargeContainerList3
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchOndockRailChargeContainerList3(Event e) throws EventException ;
	
	/**
	 * InvoiceDetail Multi Event Process<br>
	 * ESD_TES_923_1 InvoiceDetail Multi Event Process<br>
	 *
	 * @param e ESD_TES_064Event
	 * @return EventResponse ESD_TES_064EventResponse
	 * @exception EventException
	 */
	public EventResponse multiTerminalInvoiceN3rdParyIF(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * 9130 Search CNTR TYPE CD List<br>
	 *
	 * @param e ESD_TES_9130Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchBkgCntrTPCDList(Event e) throws EventException;
}