/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MarineTerminalInvoiceManageBC.java
*@FileTitle : Marine Terminal Invoice 등록 및 Confirm화면-Coincidence
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-20
*@LastModifier : kimjinjoo
*@LastVersion : 1.0
* 2007-02-20 kimjinjoo
* 1.0 최초 생성
* 2014-06-19 : 유병희 [CHM-201429211][TES] TES: Double call시 Target yard에서 Get cntr 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.basic;

import java.util.List;

import com.hanjin.apps.alps.esd.tes.common.vo.TesCommonVO;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.SearchCostCodeDetailListVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.TesTmlSoCntrListVO;

/**
 * eNIS-ESD Business Logic Command Interface<br>
 * - eNIS-ESD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author parkyeonjin
 * @see EventResponse 참조
 * @since J2EE 1.4 
 */
public interface MarineTerminalInvoiceManageBC  {


	/**
	 * 추가 이벤트 처리<br>
	 * ESD_TES_001 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse multiTerminalInvoiceN3rdParyIF(Event e) throws EventException;
	
	/**
	 * 추가 이벤트 처리<br>
	 * ESD_TES_001 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse createTerminalInvoiceBasicInfo(Event e) throws EventException;

	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TES_001 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyTerminalInvoice(Event e) throws EventException;


	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TES_001 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyN3rdPartyAmount(Event e) throws EventException;


	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TES_001 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse rejectLiftTerminalInvoice(Event e) throws EventException;

	/**
	 * 수정 이벤트 처리<br>
	 * ESD_TES_0001 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse removeTerminalInvoice(Event e) throws EventException;


	/**
	 * EDI Invoice 삭제 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse ESD_TES_013EventResponse
	 * @exception EventException
	 */
	public EventResponse removeTerminalEDIInvoice(Event e) throws EventException;


	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TES_0001 화면에 대한 멀티 이벤트 처리<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse multiTerminalInvoiceDetail(Event e) throws EventException;

	/**
	 * 멀티 이벤트 처리<br>
	 * ESD_TES_0001 화면에 대한 멀티 체크<br>
	 *
	 * @param e Event
	 * @return EventResponse EsdTes0001EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMgsetCount(Event e) throws EventException;

	/**
	 * 추가 이벤트 처리<br>
	 * ESD_TES_0001 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e Event
	 * @exception EventException
	 */
	public void multiTerminalInvoiceVVD(Event e) throws EventException;


	/**
	 * 추가 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 추가 이벤트 처리<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiTerminalInvoiceContainerList(Event e) throws EventException;

	/**
	 * 추가 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 추가 이벤트 처리<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse removeTerminalInvoiceContainerList(Event e) throws EventException;

	/**
	 * 추가 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 추가 이벤트 처리<br>
	 * removeTerminalInvoiceContainerList와의 차이점 : VVD List는 삭제하지 않는다.
	 * @param  e Event  	
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse removeTerminalInvoiceContainerList2(Event e) throws EventException;



	/**
	 * 추가 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 추가 이벤트 처리<br>
	 * @param    e Event
	 * @return   EventResponse
	 * @exception EventException
	 */
	public EventResponse removeTerminalInvoiceCosts(Event e) throws EventException;


	/**
	 * 추가 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 추가 이벤트 처리<br>
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse updateContainerListRvisFlg(Event e) throws EventException ;

	/**
	 * Terminal invoice의 manual rvis.vol 수정 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse updateContainerListRvisFlgManual(Event e) throws EventException ;
	
	/**
	 * Revised Vol List 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 Revised Vol List조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchManualRevisedVolume(Event e) throws EventException;

	/**
	 * EDI manual cntr목록 조회
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchEDIInvoiceManualContainerList(Event e) throws EventException;
	
	
	/**
	 * Revised Vol List 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 Revised Vol List조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalManualRevisedVolume(Event e) throws EventException;



	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return  EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalCNTRList(Event e) throws EventException;




	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e EsdTes0001Event
	 * @return  EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceBasicInfo(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalInvoice(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalInvoiceCosts(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalInvoiceCNTRList(Event e) throws EventException;



	/**
	 * TerminalInvoiceCalculationList 조회 이벤트 처리<br>
	 * ESD_TES_001 에 대한  TerminalInvoiceCalculationList 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse calculateTerminalInvoiceCost(Event e) throws EventException;




	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse checkTerminalInvoiceContainerList(Event e) throws EventException;


	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse createTES_FILE_IMP_TMPforReverify(Event e) throws EventException;

	/**
	 * reVerifyTerminalInvoiceContainerList 이벤트 처리<br>
	 *
	 * @param e EsdTes0001Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse reVerifyTerminalInvoiceContainerList(Event e) throws EventException;

	/**
	 * 삭제 이벤트  처리<br>
	 * Re-Verify시 TES_FILE_IMP_TMP의 삭제<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse removeTES_FILE_IMP_TMP2(Event e) throws EventException;

	/**
	 * 저장 이벤트 처리<br>
	 * Re-Verify한 내역을 TES_TML_SO_CNTR_LIST에 저장한다.<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse createTerminalInvoiceContainerList2(Event e) throws EventException;


	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCNTRNumber(Event e) throws EventException;


	/**
	 * 추가 이벤트 처리<br>
	 * ESD_TES_9010 에 대한 추가 이벤트 처리<br>
	 *
	 * @param e Event
	 * @exception EventException
	 */
	public void createTerminalInvoiceVVD(Event e) throws EventException;

	/**
	 * 수정 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse ESD_TES_901EventResponse
	 * @exception EventException
	 */
	public EventResponse updateCNTRNumber(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_901Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchTES_FILE_IMP_TMP(Event e) throws EventException;


	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse removeTES_FILE_IMP_TMP(Event e) throws EventException;


	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse createTerminalInvoiceContainerList(Event e) throws EventException;
	
	/**
	 * CNTC 항차이고 NH인 경우 BKG No. 조회
	 *
	 * @param tesTmlSoCntrListVO TesTmlSoCntrListVO
	 * @return List<TesTmlSoCntrListVO> 
	 * @exception EventException
	 */
	public List<TesTmlSoCntrListVO> searchCntcBkgNoContainerList(TesTmlSoCntrListVO tesTmlSoCntrListVO) throws EventException;

	/**
	 * BKG No. UPDATE
	 *
	 * @param updVoList List<TesTmlSoCntrListVO>
	 * @exception EventException
	 */
	public void updateCntcBkgNoContainerList(List<TesTmlSoCntrListVO> updVoList) throws EventException;
	
//	/**
//	 * 조회 이벤트 처리<br>
//	 * MarineTerminalInvoiceManage화면에 대한 조회 이벤트 처리<br>
//	 *
//	 * @param e Event
//	 * @return EventResponse 
//	 * @exception EventException
//	 */
//	public EventResponse deleteTerminalInvoiceContainerList(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse createTES_FILE_IMP_TMP(Event e) throws EventException;

//	/**
//	 * VVD CHECK 이벤트 처리<br>
//	 * CotainerList PopUp화면에 대한 VVD Check 이벤트 처리<br>
//	 *
//	 * @return response ESD_TES_901EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse checkVVDType(Event e) throws EventException;

	/**
	 * FinalBayFlanSource HJSListOnly Search이벤트 처리<br>
	 * CotainerList PopUp화면에 대한 FinalBayFlanSource HJSListOnly Search이벤트 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchHJSListOnlyList(Event e) throws EventException;

	/**
	 *  EDI로 접수받은 Container List를 조회한다.<br>
	 *
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchEDIInvoiceContainerList(Event e) throws EventException;

	/**
	 *  WorkOrder를 입력하여 해당 Container List를 조회한다.<br>
	 *
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchContainerListByWorkOrder(Event e) throws EventException;

	/**
	 * VVD Validate 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 VVD 저장 여부 확인<br>
	 *
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse checkMissingVVD(Event e) throws EventException;

	/**
	 * Accumulate Vol 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 Accumulate Vol 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchAccumulatedVolume(Event e) throws EventException;

//	/**
//	 * Account Code조회 이벤트 처리<br>
//	 * MarineTerminalInvoiceManage화면에 대한 Account Code조회 이벤트 처리<br>
//	 *
//	 * @param e Event
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse searchOtherCarrierAccountCode(Event e) throws EventException;

	/**
	 * Accumulate Vol List 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 Accumulate Vol List조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchAccumulatedVolumeList(Event e) throws EventException;
	/**
	 * Revised Vol List 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 Revised Vol List조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchAutoRevisedVolume(Event e) throws EventException;

	/**
	 * Revised Vol List 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 Revised Vol List조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_907_2Event
	 * @return response ESD_TES_907_2EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalAutoRevisedVolume(Event e) throws EventException;

	/**
	 * 3rd Party 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 3rd Party Vol List조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_923_2Event
	 * @return response ESD_TES_923_2EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAutoTrdPartyVolume(Event e) throws EventException;

	/**
	 * 3rd Party 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 3rd Party Vol List조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_923_2Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchManualTrdPartyVolume(Event e) throws EventException;


	/**
	 * 3rd Party 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한3rd Party 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_925_2Event
	 * @return response ESD_TES_925_2EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalTrdPartyVolume(Event e) throws EventException;


	/**
	 * RehandlingVolume List 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 RehandlingVolume List조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRehandlingVolume(Event e) throws EventException;

	/**
	 * 2009-08-27 [PJM-200900072] : RH용 EDI전송 manual cntr목록 조회
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchEDIInvoiceRHManualContainerList(Event e) throws EventException;
	
	/**
	 * RehandlingVolume List 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 RehandlingVolume List조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalRehandlingVolume(Event e) throws EventException;

	/**
	 * RehandlingVolume List 저장 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 RehandlingVolume List조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiRehandlingVolume(Event e) throws EventException;
	
	/**
	 * Revised Container Division 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 Revised Container Division조회 이벤트 처리<br>
	 *
	 * @param e EsdTes0001Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchManualRvisDivision(Event e) throws EventException;

//	/**
//	 * CostCalcComboCodeList 조회 이벤트 처리<br>
//	 * MarineTerminalInvoiceManage화면에 대한 CostCalcComboCodeList 조회 이벤트 처리<br>
//	 *
//	 * @param e EsdTes0001Event
//	 * @return response EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse searchTerminalInvoiceCostCalcComboCodeList(Event e) throws EventException;

	/**
	 * ATB DATE 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 ATB DATE 조회 이벤트 처리<br>
	 *
	 * @param e EsdTes0001Event
	 * @return  EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceATBDt(Event e) throws EventException;


	/**
	 * verify 대상용 terminal 가져오기
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse getVrfyTmls(Event e) throws EventException;
	


	/*******************************************************************************************
	 * 								kimjinjoo 개발부분 시작
	 ******************************************************************************************/

	/**
	 * MarineTerminal Container List 조회
	 * Main_hidden 값에 대한 이벤트 처리
	 *
	 * @param e Event
	 * @return EventResponse ESD_TES_017EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceBasicInfo2(Event e) throws EventException;


	/**
	 * MarineTerminal Container List 조회
	 * Container_List_Hidden 값에 대한 이벤트 처리
	 *
	 * @param e ESD_TES_017Event
	 * @return EventResponse ESD_TES_017EventResponse
	 * @exception EventException
	 * @author kimjinjoo
	 */
	public EventResponse searchTerminalContainerList2(Event e) throws EventException;


	/**
	 * MarineTerminal Container List 조회
	 * Accumulated Vol 값에 대한 이벤트 처리
	 * @param e
	 * @return EventResponse ESD_TES_017EventResponse
	 * @throws EventException
	 * @author kimjinjoo
	 */
	public EventResponse searchAccumulatedVolume2(Event e) throws EventException;


	/**
	 * MarineTerminal Container List 조회
	 * Cost Calculation 값에 대한 이벤트 처리
	 * @param e
	 * @return EventResponse 
	 * @throws EventException
	 * @author kimjinjoo
	 */
//	public EventResponse searchTerminalInvoiceCalculationList2(Event e) throws EventException;


	/**
	 * 조회 이벤트 처리<br>
	 * marineterminalinvoicemanage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceSummary(Event e) throws EventException;


	/**
	 * 조회 이벤트 처리<br>
	 * Terminal Expense Inquiry화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchTerminalExpenseSummary(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * Office Hierarchy 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_930Event
	 * @return EventResponse ESD_TES_930EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOfficeHierarchy(Event e) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * searchTOR 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_9500Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchTOR(Event e) throws EventException;

	
	 /**
	 * 조회 이벤트 처리<br>
	 * Office Hierarchy 조회 이벤트 처리<br>
	 *
	 * @param e ESD_TES_930Event
	 * @return EventResponse ESD_TES_930EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSubOffice(Event e) throws EventException;


	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Terminal Expense Inquiry화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchTerminalExpenseVolumeSummary(Event e) throws EventException;


	/**
	 * Confirm Cancel 이벤트 처리<br>
	 * marineterminalinvoic summary Inquiry 화면에 대한 Confirm Cancel 이벤트 처리<br>
	 *
	 * @param e ESD_TES_013Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse modifyTerminalInvoiceConfirm(Event e) throws EventException;






	/*******************************************************************************************
	 * 								kimjinjoo 개발부분 끝
	 ******************************************************************************************/
	
	/**
	 * VVD Dual 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 VVD Dual 조회 이벤트 처리<br>
	 *
	 * @param e EsdTes0001Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceVVDDual(Event e) throws EventException;
	
	/**
	 * BOUND 조회 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 BOUND 조회 이벤트 처리<br>
	 *
	 * @param e EsdTes0001Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceAutoBoundList(Event e) throws EventException;
	
	/**
	 * BOUND 저장 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 BOUND 저장 이벤트 처리<br>
	 *
	 * @param e EsdTes0001Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiTerminalInvoiceAutoBoundList(Event e) throws EventException;
	
	/**
	 * BOUND CHECK 이벤트 처리<br>
	 * MarineTerminalInvoiceManage화면에 대한 BOUND CHECK 이벤트 처리<br>
	 *
	 * @param e EsdTes0001Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse checkDualVVD(Event e) throws EventException;

	/**
	 * Search MGSet List
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchMGSetFuelingChargeList(Event e) throws EventException;
	
	/**
	 * MGSet List	CUD
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse multiMGSetFuelingCharge(Event e) throws EventException;

	
	/**
	 * MR Invoice 입력시 FIO 조건 CNTR verification 결과 보완  by J PARK  2011-0725
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */	
	
	public EventResponse modifyContainerFromCoToDC(Event e) throws EventException;
	
	/**
	 * 9001 팝업화면 에서의 searchCostCodeList
	 * @param SearchCostCodeDetailListVO infoVO
	 * @param TesCommonVO cmnVO
	 * @param String cost_cd_inv_tp_cd
	 * @param SignOnUserAccount account
	 * @return List<SearchCostCodeDetailListVO>
	 * @throws EventException
	 */	
	public List<SearchCostCodeDetailListVO> searchCostCodeList(SearchCostCodeDetailListVO infoVO, TesCommonVO cmnVO, 
			String cost_cd_inv_tp_cd, SignOnUserAccount account) throws EventException;
	
	/**
	 * 9001 팝업화면 에서의 searchCostCodeDetailList
	 * @param SearchCostCodeDetailListVO infoVO
	 * @return List<SearchCostCodeDetailListVO>
	 * @throws EventException
	 */	
	public List<SearchCostCodeDetailListVO> searchCostCodeDetailList(SearchCostCodeDetailListVO infoVO) throws EventException;

	/**
	 * 조회 이벤트 처리<br>
	 * 9035 팝업화면 searchPortSkdDetailList<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @throws EventException
	 */	
	
	public EventResponse searchPortSkdDetailList(Event e) throws EventException;
	
	/**
	 * 조회 이벤트 처리<br>
	 * marineterminalinvoicemanage화면에 대한 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchTerminalGSTInvoiceSummary(Event e) throws EventException;
	
}