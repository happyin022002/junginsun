/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MarineTerminalStorageInvoiceManageBC.java
*@FileTitle : Marine Terminal Strorage Invoice관리
*Open Issues :
*Change history :
*@LastModifyDate : 2007-10-09
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-10-27 byungheeyoo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalstorageinvoicemanage.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;

/**
 * ENIS-ESD Business Logic Command Interface<br>
 * - ENIS-ESD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author byungheeyoo
 * @see ESD_TES_009EventResponse 참조
 * @since J2EE 1.4
 */
public interface MarineTerminalStorageInvoiceManageBC  {

	/** YOO - 시작 **/
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchStorage3rdIFlistOnly(Event e) throws EventException;	
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchStorage3rdIFlistByDay(Event e) throws EventException;	
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse calStorageInvoiceCost(Event e) throws EventException;	

	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse createStorageInvoiceBasicInfo(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse createStorageInvoiceContainerList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse createStorageInvoiceDetail(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse modifyStorageInvoice(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse modifyStorageInvoiceConfirm(Event e) throws EventException;	
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse modifyStorageInvoiceReject(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeStorageInvoiceContainerList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeStorageInvoiceDetailByDay(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeStorageInvoiceDetailByPool(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeStorageInvoiceN3rd01(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeStorageInvoiceN3rd02(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeStorageAutoCalcByDay(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeStorageAutoCalcByPool(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchStorageContainerList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchStorageInvoiceBasicInfo(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchStorageInvoiceDetail(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchStorageInvoiceAllSheets(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchStorageInvoiceRejectInfo(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	//public EventResponse searchStorageTotalAmount(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * OffdockCYInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_004Event
	 * @return EventResponse ESD_TES_004EventResponse
	 * @exception EventException
	 */	
	public EventResponse createTES_FILE_IMP_TMP(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * OffdockCYInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_004Event
	 * @return EventResponse ESD_TES_004EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeTES_FILE_IMP_TMP(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * OffdockCYInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_004Event
	 * @return EventResponse ESD_TES_004EventResponse
	 * @exception EventException
	 */	
	public EventResponse createTES_FILE_IMP_TMPByPool(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * OffdockCYInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_004Event
	 * @return EventResponse ESD_TES_004EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeTES_FILE_IMP_TMPByPool(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_914Event
	 * @return EventResponse ESD_TES_914EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCNTRNumber(Event e) throws EventException;

	/**
	 * 수정 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_914Event
	 * @return EventResponse ESD_TES_914EventResponse
	 * @exception EventException
	 */
	public EventResponse updateCNTRNumber(Event e) throws EventException;
	
	/**
	 * EDI로 받은 CNTR목록 조회 - eBilling
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchEDIStorageInvoiceContainerList(Event e) throws EventException;

	/**
	 * EDI로 받은 FreePool CNTR목록 조회 - eBilling
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchEDIStorageInvoiceContainerListFreePool(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_914Event
	 * @return EventResponse ESD_TES_914EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTES_FILE_IMP_TMP(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse verifyStorageInvoiceCostByPool(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse verifyStorageInvoiceVolumne(Event e) throws EventException;	

	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */
	public int insertStorageInvoiceContainerList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */
	public int insertStorageInvoiceDetail(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse updateStorageAccountCode(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
//	public EventResponse convertStorageManualRevenueVVD(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse cancelStorageInvoiceConfirm(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse cancelStorageInvoiceReject(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	//public EventResponse searchStorage3rdIFlist(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	//public EventResponse searchStorage3rdIFlistByPool(Event e) throws EventException;
	/** YOO - 끝 **/

	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalStorageInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_009Event
	 * @return EventResponse ESD_TES_009EventResponse
	 * @exception EventException
	 */	
	public EventResponse multiStorage3rdIFlist(Event e) throws EventException;	
	
	/** JINJOO - 시작 **/


	/**
	 * 조회 이벤트 처리<br>
	 * OffdockCYInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_004Event
	 * @return EventResponse ESD_TES_004EventResponse
	 * @exception EventException
	 */
	public EventResponse searchStorageInvoiceBasicInfo2(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * OffdockCYInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_004Event
	 * @return EventResponse ESD_TES_004EventResponse
	 * @exception EventException
	 */
	public EventResponse searchStorageContainerList2(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * OffdockCYInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_004Event
	 * @return EventResponse ESD_TES_004EventResponse
	 * @exception EventException
	 */
	//사용안함 - 이정혜
	//public EventResponse searchStorageInvoiceDetail2(Event e) throws EventException;
	/** JINJOO - 끝 **/
}
