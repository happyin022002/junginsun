/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MarineTerminalStorageInvoiceManageBC.java
*@FileTitle : Marine Terminal Strorage Invoice Management
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD Business Logic Command Interface<br>
 *
 * @author byungheeyoo
 * @see ESD_TES_009EventResponse 
 * @since J2EE 1.4
 */
public interface MarineTerminalStorageInvoiceManageBC  {

	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchStorage3rdIFlistOnly(Event e) throws EventException;	
	
	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchStorage3rdIFlistByDay(Event e) throws EventException;	
	
	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse calStorageInvoiceCost(Event e) throws EventException;	

	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse createStorageInvoiceBasicInfo(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse createStorageInvoiceContainerList(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse createStorageInvoiceDetail(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse modifyStorageInvoice(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse modifyStorageInvoiceConfirm(Event e) throws EventException;	
	
	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse modifyStorageInvoiceReject(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeStorageInvoiceContainerList(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeStorageInvoiceDetailByDay(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeStorageInvoiceDetailByPool(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeStorageInvoiceDetailByEq(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeStorageInvoiceN3rd01(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeStorageInvoiceN3rd02(Event e) throws EventException;

	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeStorageInvoiceN3rd03(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeStorageAutoCalcByDay(Event e) throws EventException;

	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeStorageAutoCalcByPool(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchStorageContainerList(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchStorageInvoiceBasicInfo(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchStorageInvoiceDetail(Event e) throws EventException;

	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchStorageInvoiceAllSheets(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchStorageInvoiceRejectInfo(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	//public EventResponse searchStorageTotalAmount(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * OffdockCYInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_004Event
	 * @return EventResponse ESD_TES_004EventResponse
	 * @exception EventException
	 */	
	public EventResponse createTES_FILE_IMP_TMP(Event e) throws EventException;

	/**
	 * retrieve event process
	 * OffdockCYInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_004Event
	 * @return EventResponse ESD_TES_004EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeTES_FILE_IMP_TMP(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_914Event
	 * @return EventResponse ESD_TES_914EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCNTRNumber(Event e) throws EventException;

	/**
	 * Update Event Process<br>
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_914Event
	 * @return EventResponse ESD_TES_914EventResponse
	 * @exception EventException
	 */
	public EventResponse updateCNTRNumber(Event e) throws EventException;
	
	/**
	 * EDI CNTRList retrieve - eBilling
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchEDIStorageInvoiceContainerList(Event e) throws EventException;

	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_914Event
	 * @return EventResponse ESD_TES_914EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTES_FILE_IMP_TMP(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse verifyStorageInvoiceVolumne(Event e) throws EventException;	

	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */
	public int insertStorageInvoiceContainerList(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse updateStorageAccountCode(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
//	public EventResponse convertStorageManualRevenueVVD(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse cancelStorageInvoiceConfirm(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse cancelStorageInvoiceReject(Event e) throws EventException;
	
	/** multiStorageTerminalInvoiceDBVerify
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse multiStorageTerminalInvoiceDBVerify(Event e) throws EventException;
	
	/** searchDBCheckStorageTerminalInvoice
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDBCheckStorageTerminalInvoice(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	//public EventResponse searchStorage3rdIFlist(Event e) throws EventException;
	
	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	//public EventResponse searchStorage3rdIFlistByPool(Event e) throws EventException;

	/**
	 * retrieve event process
	 * MarineTerminalStorageInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse multiStorage3rdIFlist(Event e) throws EventException;	
	

	/**
	 * retrieve event process
	 * OffdockCYInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_004Event
	 * @return EventResponse ESD_TES_004EventResponse
	 * @exception EventException
	 */
	public EventResponse searchStorageInvoiceBasicInfo2(Event e) throws EventException;

	/**
	 * retrieve event process
	 * OffdockCYInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_004Event
	 * @return EventResponse ESD_TES_004EventResponse
	 * @exception EventException
	 */
	public EventResponse searchStorageContainerList2(Event e) throws EventException;

	/**
	 * retrieve event process
	 * OffdockCYInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_004Event
	 * @return EventResponse ESD_TES_004EventResponse
	 * @exception EventException
	 */
	//public EventResponse searchStorageInvoiceDetail2(Event e) throws EventException;
	
	
	/**
	 * retrieve event process
	 * 9142 Search CNTR TYPE CD List
	 *
	 * @param e ESD_TES_9142Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchBkgCntrTPCDList(Event e) throws EventException;
}
