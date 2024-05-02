/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : OndockRailChargeInvoiceManageBC.java
*@FileTitle : On-dock Rail Charge Invoice 등록 및 Confirm화면-Coincidence
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-28
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-28 parkyeonjin
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.basic;

import java.sql.SQLException;
import java.util.List;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.syscommon.common.table.TesTmlSoCntrListVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;

/**
 * eNIS-ESD Business Logic Command Interface<br>
 * - eNIS-ESD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author parkyeonjin
 * @see ESD_TES_064EventResponse 참조
 * @since J2EE 1.4
 */
public interface OndockRailChargeInvoiceManageBC  {


	/**
	 * 조회 이벤트 처리<br>
	 * OndockRailChargeInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_064Event
	 * @return EventResponse ESD_TES_064EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOndockRailChargeBasicInfo (Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * OndockRailChargeInvoiceManage화면에 대한 Create 이벤트 처리<br>
	 *
	 * @param e ESD_TES_064Event
	 * @return EventResponse ESD_TES_064EventResponse
	 * @exception EventException
	 */
	public EventResponse createOndockRailChargeBasicInfo(Event e) throws EventException;

	/**
	 * Modify 이벤트 처리<br>
	 * OndockRailChargeInvoiceManage화면에 대한 Modify 이벤트 처리<br>
	 *
	 * @param e ESD_TES_064Event
	 * @return EventResponse ESD_TES_064EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyOndockRailChargeBasicInfo(Event e) throws EventException;
	/**
	 * ContainerList Verify 이벤트 처리<br>
	 * OndockRailChargeInvoiceManage화면에 대한 ContainerList Verify  이벤트 처리<br>
	 *
	 * @param e ESD_TES_913Event
	 * @return EventResponse ESD_TES_913EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyOndockRailChargeContainerList(Event e) throws EventException;


	/**
	 * ContainerList Verify 이벤트 처리<br>
	 * OndockRailChargeInvoiceManage화면에 대한 ContainerList Verify  이벤트 처리<br>
	 *
	 * @param e ESD_TES_913Event
	 * @return EventResponse ESD_TES_913EventResponse
	 * @exception EventException
	 */
	public EventResponse createTES_FILE_IMP_TMP(Event e) throws EventException;

	/**
	 * ContainerList Verify 이벤트 처리<br>
	 * OndockRailChargeInvoiceManage화면에 대한 ContainerList Verify  이벤트 처리<br>
	 *
	 * @param e ESD_TES_913Event
	 * @return EventResponse ESD_TES_913EventResponse
	 * @exception EventException
	 */
	public EventResponse createOndockRailChargeContainerList(Event e) throws EventException;

//	/**
//	 * ContainerList Verify시 CNTR목록 삭제 <br>
//	 * OndockRailChargeInvoiceManage화면에 대한 ContainerList Verify  이벤트 처리<br>
//	 *
//	 * @param e ESD_TES_913Event
//	 * @return EventResponse ESD_TES_913EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse deleteOndockRailChargeContainerList(Event e) throws EventException;
	
	/**
	 * ContainerList Verify 이벤트 처리<br>
	 * OndockRailChargeInvoiceManage화면에 대한 ContainerList Verify  이벤트 처리<br>
	 *
	 * @param e ESD_TES_913Event
	 * @return EventResponse ESD_TES_913EventResponse
	 * @exception EventException
	 */
	public EventResponse removeTES_FILE_IMP_TMP(Event e) throws EventException;


	/**
	 * OndockRailChargeContainerList Multi 이벤트 처리<br>
	 * OndockRailChargeContainerList event에 대한 OndockRailChargeContainerList Multi 이벤트 처리<br>
	 *
	 * @param e ESD_TES_064Event
	 * @return EventResponse ESD_TES_064EventResponse
	 * @exception EventException
	 */
	public EventResponse multiOndockRailChargeContainerList(Event e) throws EventException;
	/**
	 * OndockRailChargeContainerList 조회 이벤트 처리<br>
	 * OndockRailChargeContainerList event에 대한 OndockRailChargeContainerList 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_064Event
	 * @return EventResponse ESD_TES_064EventResponse
	 * @exception EventException
	 */


	public EventResponse searchOndockRailChargeContainerList(Event e) throws EventException;


	/**
	 * InvoiceDetail 멀티 이벤트 처리<br>
	 * ESD_TES_064 화면에 대한 InvoiceDetail 멀티 이벤트 처리<br>
	 *
	 * @param e ESD_TES_064Event
	 * @return EventResponse ESD_TES_064EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOndockRailChargeInvoiceCost(Event e) throws EventException;

	/**
	 * OndockRailChargeCostCalculationList 조회 이벤트 처리<br>
	 * OndockRailChargeInvoiceManage event에 대한 OndockRailChargeCostCalcurationList 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_064Event
	 * @return EventResponse ESD_TES_064EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOndockRailChargeCostCalculationList(Event e) throws EventException;
	/**
	 * CostCalcComboCodeList 조회 이벤트 처리<br>
	 * OndockRailChargeInvoiceManage 대한 CostCalcComboCodeList 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_064Event
	 * @return response ESD_TES_064EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOnDockChargeInvoiceCostCalcComboCodeList(Event e) throws EventException;
	/**
	 * InvoiceDetail 멀티 이벤트 처리<br>
	 * ESD_TES_064 화면에 대한 InvoiceDetail 멀티 이벤트 처리<br>
	 *
	 * @param e ESD_TES_064Event
	 * @return EventResponse ESD_TES_064EventResponse
	 * @exception EventException
	 */
	public EventResponse multiOndockRailChargeInvoiceDetail(Event e) throws EventException;
//	/**
//	 * TML_SO_RVIS_LIST 조회 이벤트 처리<br>
//	 * MarineTerminalInvoiceManage화면에 대한 TML_SO_RVIS_LIST 조회 이벤트 처리<br>
//	 *
//	 * @param e ESD_TES_064Event
//	 * @return response ESD_TES_064EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse searchOndockRailChargeInvoiceRvisList(Event e) throws EventException;
//	/**
//	 * TerminalInvoiceN3rdPartyIF LIST 조회 이벤트 처리<br>
//	 * MarineTerminalInvoiceManage화면에 대한 TerminalInvoiceN3rdPartyIF LIST 조회 이벤트 처리<br>
//	 *
//	 * @param e ESD_TES_064Event
//	 * @return response ESD_TES_064EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse searchOndockRailChargeInvoiceN3ptyList(Event e) throws EventException;
//

	/**
	 * Revised Vol List 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 Revised Vol List조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_903_1Event
	 * @return response ESD_TES_903_1EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAutoRevisedVolume(Event e) throws EventException;

	/**
	 * 추가 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 추가 이벤트 처리<br>
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse updateOnDockContainerListRvisFlg(Event e) throws EventException ;

	/**
	 * Revised Vol List 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 Revised Vol List조회 이벤트 처리<br>
	 *
	 * @param e Event 
	 * @return response ESD_TES_903_1EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceRevisedVolume9031(Event e) throws EventException;

	/**
	 * Revised Vol List 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 Revised Vol List조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_903_1Event
	 * @return response ESD_TES_903_1EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceRevisedVolume(Event e) throws EventException;

	/**
	 * TerminalInvoiceN3ptyAutoCntrList 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 TerminalInvoiceN3ptyAutoCntrList 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_923_1Event
	 * @return response ESD_TES_923_1EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceN3ptyAutoCntrList(Event e) throws EventException;
	/**
	 * TerminalInvoiceN3ptyManualCntrList 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 TerminalInvoiceN3ptyManualCntrList 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_923_1Event
	 * @return response ESD_TES_923_1EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceN3ptyManualCntrList(Event e) throws EventException;


	/**
	 * 3rd Party 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한3rd Party 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_925_1Event
	 * @return response ESD_TES_925_1EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOnDockTrdPartyVolume(Event e) throws EventException;

	/**
	 * 3rd Party 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한3rd Party 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_9260Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse  searchOnDockTotalAmount(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * OndockRailCharge Container List 조회 화면에 대한 이벤트 처리<br>
	 * @param  Event e
	 * @return response EventResponse
	 * @throws EventException
	 */
	public EventResponse  searchOndockRailChargeBasicInfo2(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * OndockRailCharge Container List 조회 화면에 대한 Container List(Coincidency/Discrepancy)조회 이벤트 처리<br>
	 * 
	 * @param  Event e
	 * @return response EventResponse
	 * @throws EventException
	 */
	public EventResponse searchOndockRailChargeContainerList2(Event e) throws EventException;
	
	/**
	 * InvoiceDetail 멀티 이벤트 처리<br>
	 * ESD_TES_923_1 화면에 대한 InvoiceDetail 멀티 이벤트 처리<br>
	 *
	 * @param e ESD_TES_064Event
	 * @return EventResponse ESD_TES_064EventResponse
	 * @exception EventException
	 */
	public EventResponse multiTerminalInvoiceN3rdParyIF(Event e) throws EventException;
	
	/**
	 * TRS에서 찾은 BKG No.의 Status가 Cancelled인 경우에는 BKG 테이블에서 최신 BKG No. 찾기
	 * 
	 * @param TesTmlSoHdrVO tesTmlSoHdrVO
	 * @return List<TesTmlSoCntrListVO>
	 * @throws EventException
	 */
	public List<TesTmlSoCntrListVO> searchBkgNoContainerList(TesTmlSoHdrVO tesTmlSoHdrVO) throws EventException;
	
	
	/**
	 * Not Cancelled BKG No UPDATE
	 *
	 * @param updVoList List<TesTmlSoCntrListVO>
	 * @exception EventException
	 */
	public void updateBkgNoContainerList(List<TesTmlSoCntrListVO> updVoList) throws EventException;
}