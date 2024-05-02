/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MarineTerminalInvoiceManageBC.java
*@FileTitle : Marine Terminal Invoice 등록 및 Confirm화면-Coincidence
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.basic;

import java.util.List;

import com.clt.apps.opus.esd.tes.common.vo.TesCommonVO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.SearchCostCodeDetailListVO;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD Business Logic Command Interface<br>
 *
 * @author parkyeonjin
 * @see EventResponse
 * @since J2EE 1.4
 */
public interface MarineTerminalInvoiceManageBC  {


	/**
	 * Add Event Process<br>
	 * ESD_TES_001 Add Event Process<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse multiTerminalInvoiceN3rdParyIF(Event e) throws EventException;
	
	/**
	 * Add Event Process<br>
	 * ESD_TES_001 Add Event Process<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse createTerminalInvoiceBasicInfo(Event e) throws EventException;

	/**
	 * Update Event Process<br>
	 * ESD_TES_001 Add Event Process<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyTerminalInvoice(Event e) throws EventException;


	/**
	 * Update Event Process<br>
	 * ESD_TES_001 Add Event Process<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyN3rdPartyAmount(Event e) throws EventException;


	/**
	 * Update Event Process<br>
	 * ESD_TES_001 Add Event Process<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse rejectLiftTerminalInvoice(Event e) throws EventException;

	/**
	 * Update Event Process<br>
	 * ESD_TES_0001 Add Event Process<br>
	 *
	 * @param e Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse removeTerminalInvoice(Event e) throws EventException;

	/**
	 * Multi Event Process<br>
	 * ESD_TES_0001 Multi Event Process<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse multiTerminalInvoiceDetail(Event e) throws EventException;

	/** multiTerminalInvoiceDBVerify
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse multiTerminalInvoiceDBVerify(Event e) throws EventException;
	/**
	 * Multi Event Process<br>
	 * ESD_TES_0001 Multi Check<br>
	 *
	 * @param e Event
	 * @return EventResponse EsdTes0001EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMgsetCount(Event e) throws EventException;

	/**
	 * Add Event Process<br>
	 * ESD_TES_0001 Add Event Process<br>
	 *
	 * @param e Event
	 * @exception EventException
	 */
	public void multiTerminalInvoiceVVD(Event e) throws EventException;


	/**
	 * Add Event Process<br>
	 * MarineTerminalInvoiceManage Add Event Process<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiTerminalInvoiceContainerList(Event e) throws EventException;

	/**
	 * Add Event Process<br>
	 * MarineTerminalInvoiceManage Add Event Process<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse removeTerminalInvoiceContainerList(Event e) throws EventException;

	/**
	 * Add Event Process<br>
	 * MarineTerminalInvoiceManage Add Event Process<br>
	 * removeTerminalInvoiceContainerList difference : VVD List does not delete.
	 * @param  e Event  	
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse removeTerminalInvoiceContainerList2(Event e) throws EventException;



	/**
	 * Add Event Process<br>
	 * MarineTerminalInvoiceManage Add Event Process<br>
	 * @param    e Event
	 * @return   EventResponse
	 * @exception EventException
	 */
	public EventResponse removeTerminalInvoiceCosts(Event e) throws EventException;


	/**
	 * Add Event Process<br>
	 * MarineTerminalInvoiceManage Add Event Process<br>
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse updateContainerListRvisFlg(Event e) throws EventException ;

	/**
	 * Terminal invoice의 manual rvis.vol Update
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse updateContainerListRvisFlgManual(Event e) throws EventException ;
	
	/** updateContainerListRvisFlgManual2
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse updateContainerListRvisFlgManual2(Event e) throws EventException ;
	
	/**
	 * Revised Vol List retrieve event process
	 * MarineTerminalInvoiceManage Revised Vol List retrieve event process
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchManualRevisedVolume(Event e) throws EventException;

	/**
	 * Revised Vol List retrieve event process
	 * MarineTerminalInvoiceManage Revised Vol List retrieve event process
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalManualRevisedVolume(Event e) throws EventException;



	/**
	 * retrieve event process
	 * MarineTerminalInvoiceManage  retrieve event process
	 *
	 * @param e Event
	 * @return  EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalCNTRList(Event e) throws EventException;




	/**
	 * retrieve event process
	 * MarineTerminalInvoiceManage retrieve event process
	 *
	 * @param e EsdTes0001Event
	 * @return  EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceBasicInfo(Event e) throws EventException;

	/**
	 * retrieve event process
	 * MarineTerminalInvoiceManage List retrieve event process
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalInvoice(Event e) throws EventException;

	/**
	 * retrieve event process
	 * MarineTerminalInvoiceManage List retrieve event process
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalInvoiceCosts(Event e) throws EventException;

	/**
	 * retrieve event process
	 * MarineTerminalInvoiceManage List retrieve event process
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalInvoiceCNTRList(Event e) throws EventException;



	/**
	 * TerminalInvoiceCalculationList retrieve event process
	 * ESD_TES_001  TerminalInvoiceCalculationList retrieve event process
	 *
	 * @param e Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse calculateTerminalInvoiceCost(Event e) throws EventException;




	/**
	 * retrieve event process
	 * MarineTerminalInvoiceManage retrieve event process
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse checkTerminalInvoiceContainerList(Event e) throws EventException;


	/**
	 * retrieve event process
	 * MarineTerminalInvoiceManage retrieve event process
	 *
	 * @param e Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse createTES_FILE_IMP_TMPforReverify(Event e) throws EventException;

	/**
	 * reVerifyTerminalInvoiceContainerList Event Process<br>
	 *
	 * @param e EsdTes0001Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse reVerifyTerminalInvoiceContainerList(Event e) throws EventException;

	/**
	 * Delete Event Process<br>
	 * Re-Verify시 TES_FILE_IMP_TMP Delete<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse removeTES_FILE_IMP_TMP2(Event e) throws EventException;

	/**
	 * Save Event Process<br>
	 * Details Re-Verify TES_TML_SO_CNTR_LIST Save<br>
	 *
	 * @param e EsdTes0001Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse createTerminalInvoiceContainerList2(Event e) throws EventException;


	/**
	 * retrieve event process
	 * MarineTerminalInvoiceManage retrieve event process
	 *
	 * @param e Event
	 * @return EventResponse EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCNTRNumber(Event e) throws EventException;


	/**
	 * Add Event Process<br>
	 * ESD_TES_9010 Add Event Process<br>
	 *
	 * @param e Event
	 * @exception EventException
	 */
	public void createTerminalInvoiceVVD(Event e) throws EventException;

	/**
	 * Update Event Process<br>
	 * MarineTerminalInvoiceManage retrieve event process
	 *
	 * @param e Event
	 * @return EventResponse ESD_TES_901EventResponse
	 * @exception EventException
	 */
	public EventResponse updateCNTRNumber(Event e) throws EventException;

	/**
	 * retrieve event process
	 * MarineTerminalInvoiceManage retrieve event process
	 *
	 * @param e ESD_TES_901Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchTES_FILE_IMP_TMP(Event e) throws EventException;


	/**
	 * retrieve event process
	 * MarineTerminalInvoiceManage retrieve event process
	 *
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse removeTES_FILE_IMP_TMP(Event e) throws EventException;


	/**
	 * retrieve event process
	 * MarineTerminalInvoiceManage retrieve event process
	 *
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse createTerminalInvoiceContainerList(Event e) throws EventException;

//	/**
//	 * retrieve event process
//	 * MarineTerminalInvoiceManage retrieve event process
//	 *
//	 * @param e Event
//	 * @return EventResponse 
//	 * @exception EventException
//	 */
//	public EventResponse deleteTerminalInvoiceContainerList(Event e) throws EventException;

	/**
	 * retrieve event process
	 * MarineTerminalInvoiceManage retrieve event process
	 *
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse createTES_FILE_IMP_TMP(Event e) throws EventException;

//	/**
//	 * VVD CHECK Event Process<br>
//	 * CotainerList PopUp VVD Check Event Process<br>
//	 *
//	 * @return response ESD_TES_901EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse checkVVDType(Event e) throws EventException;

	/**
	 * FinalBayFlanSource COMListOnly SearchEvent Process<br>
	 * CotainerList PopUp FinalBayFlanSource COMListOnly SearchEvent Process<br>
	 *
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchCOMListOnlyList(Event e) throws EventException;

	/**
	 * Container List WorkOrder Input Inquiry<br>
	 *
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchContainerListByWorkOrder(Event e) throws EventException;

	/**
	 * VVD Validate Event Process<br>
	 * MarineTerminalInvoiceManage Check save VVD<br>
	 *
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse checkMissingVVD(Event e) throws EventException;

	/**
	 * Accumulate Vol retrieve event process
	 * MarineTerminalInvoiceManage Accumulate Vol retrieve event process
	 *
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchAccumulatedVolume(Event e) throws EventException;

//	/**
//	 * Account Code retrieve event process
//	 * MarineTerminalInvoiceManage Account Code retrieve event process
//	 *
//	 * @param e Event
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse searchOtherCarrierAccountCode(Event e) throws EventException;

	/**
	 * Accumulate Vol List retrieve event process
	 * MarineTerminalInvoiceManage Accumulate Vol List retrieve event process
	 *
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchAccumulatedVolumeList(Event e) throws EventException;
	/**
	 * Revised Vol List retrieve event process
	 * MarineTerminalInvoiceManage Revised Vol List retrieve event process
	 *
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchAutoRevisedVolume(Event e) throws EventException;

	/**
	 * Revised Vol List retrieve event process
	 * MarineTerminalInvoiceManage Revised Vol List retrieve event process
	 *
	 * @param e ESD_TES_907_2Event
	 * @return response ESD_TES_907_2EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalAutoRevisedVolume(Event e) throws EventException;

	/**
	 * 3rd Party retrieve event process
	 * MarineTerminalInvoiceManage 3rd Party Vol List retrieve event process
	 *
	 * @param e ESD_TES_923_2Event
	 * @return response ESD_TES_923_2EventResponse
	 * @exception EventException
	 */
	public EventResponse searchAutoTrdPartyVolume(Event e) throws EventException;

	/**
	 * 3rd Party retrieve event process
	 * MarineTerminalInvoiceManage 3rd Party Vol List retrieve event process
	 *
	 * @param e ESD_TES_923_2Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchManualTrdPartyVolume(Event e) throws EventException;


	/**
	 * 3rd Party retrieve event process
	 * MarineTerminalInvoiceManage3rd Party retrieve event process
	 *
	 * @param e ESD_TES_925_2Event
	 * @return response ESD_TES_925_2EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalTrdPartyVolume(Event e) throws EventException;


	/**
	 * RehandlingVolume List retrieve event process
	 * MarineTerminalInvoiceManage RehandlingVolume List retrieve event process
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchRehandlingVolume(Event e) throws EventException;

	/**
	 * RehandlingVolume List retrieve event process
	 * MarineTerminalInvoiceManage RehandlingVolume List retrieve event process
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMarineTerminalRehandlingVolume(Event e) throws EventException;

	/**
	 * RehandlingVolume List Save Event Process<br>
	 * MarineTerminalInvoiceManage RehandlingVolume List retrieve event process
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiRehandlingVolume(Event e) throws EventException;
	
	/**
	 * Revised Container Division retrieve event process
	 * MarineTerminalInvoiceManage Revised Container Division retrieve event process
	 *
	 * @param e EsdTes0001Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchManualRvisDivision(Event e) throws EventException;

//	/**
//	 * CostCalcComboCodeList retrieve event process
//	 * MarineTerminalInvoiceManage CostCalcComboCodeList retrieve event process
//	 *
//	 * @param e EsdTes0001Event
//	 * @return response EventResponse
//	 * @exception EventException
//	 */
//	public EventResponse searchTerminalInvoiceCostCalcComboCodeList(Event e) throws EventException;

	/**
	 * ATB DATE retrieve event process
	 * MarineTerminalInvoiceManage ATB DATE retrieve event process
	 *
	 * @param e EsdTes0001Event
	 * @return  EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceATBDt(Event e) throws EventException;



	/**
	 * MarineTerminal Container List Search
	 * Main_hidden Event Process
	 *
	 * @param e Event
	 * @return EventResponse ESD_TES_017EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceBasicInfo2(Event e) throws EventException;


	/**
	 * MarineTerminal Container List Search
	 * Container_List_Hidden Event Process
	 *
	 * @param e ESD_TES_017Event
	 * @return EventResponse ESD_TES_017EventResponse
	 * @exception EventException
	 * @author kimjinjoo
	 */
	public EventResponse searchTerminalContainerList2(Event e) throws EventException;


	/**
	 * MarineTerminal Container List Search
	 * Accumulated Vol Event Process
	 * @param e
	 * @return EventResponse ESD_TES_017EventResponse
	 * @throws EventException
	 * @author kimjinjoo
	 */
	public EventResponse searchAccumulatedVolume2(Event e) throws EventException;


	/**
	 * MarineTerminal Container List Search
	 * Cost Calculation Event Process
	 * @param e
	 * @return EventResponse 
	 * @throws EventException
	 * @author kimjinjoo
	 */
//	public EventResponse searchTerminalInvoiceCalculationList2(Event e) throws EventException;


	/**
	 * retrieve event process
	 * marineterminalinvoicemanage retrieve event process
	 *
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceSummary(Event e) throws EventException;


	/**
	 * retrieve event process
	 * Terminal Expense Inquiry retrieve event process
	 *
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchTerminalExpenseSummary(Event e) throws EventException;

	/**
	 * retrieve event process
	 * Office Hierarchy retrieve event process
	 *
	 * @param e ESD_TES_930Event
	 * @return EventResponse ESD_TES_930EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOfficeHierarchy(Event e) throws EventException;

	 /**
	 * retrieve event process
	 * Office Hierarchy retrieve event process
	 *
	 * @param e ESD_TES_930Event
	 * @return EventResponse ESD_TES_930EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSubOffice(Event e) throws EventException;


	
	
	/**
	 * retrieve event process
	 * Terminal Expense Inquiry retrieve event process
	 *
	 * @param e Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse searchTerminalExpenseVolumeSummary(Event e) throws EventException;


	/**
	 * Confirm Cancel Event Process<br>
	 * marineterminalinvoic summary Inquiry Confirm Cancel Event Process<br>
	 *
	 * @param e ESD_TES_013Event
	 * @return EventResponse 
	 * @exception EventException
	 */
	public EventResponse modifyTerminalInvoiceConfirm(Event e) throws EventException;

	/**
	 * VVD Dual retrieve event process
	 * MarineTerminalInvoiceManage VVD Dual retrieve event process
	 *
	 * @param e EsdTes0001Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceVVDDual(Event e) throws EventException;
	
	/** searchDBCheckTerminalInvoice
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDBCheckTerminalInvoice(Event e) throws EventException;
	
	/**
	 * BOUND retrieve event process
	 * MarineTerminalInvoiceManage BOUND retrieve event process
	 *
	 * @param e EsdTes0001Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTerminalInvoiceAutoBoundList(Event e) throws EventException;
	
	/**
	 * BOUND Save Event Process<br>
	 * MarineTerminalInvoiceManage BOUND Save Event Process<br>
	 *
	 * @param e EsdTes0001Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiTerminalInvoiceAutoBoundList(Event e) throws EventException;
	
	/**
	 * BOUND CHECK Event Process<br>
	 * MarineTerminalInvoiceManage BOUND CHECK Event Process<br>
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
	 * MGSet List CUD
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse multiMGSetFuelingCharge(Event e) throws EventException;
	
	/**
	 * 9001 팝업화면 에서의 searchCostCodeList
	 * @param SearchCostCodeDetailListVO paramVO
	 * @param TesCommonVO cmnVO
	 * @param String cost_cd_inv_tp_cd
	 * @param SignOnUserAccount account
	 * @return List<SearchCostCodeDetailListVO>
	 * @throws EventException
	 */	
	public List<SearchCostCodeDetailListVO> searchCostCodeList(SearchCostCodeDetailListVO paramVO, TesCommonVO cmnVO , String cost_cd_inv_tp_cd, SignOnUserAccount account) throws EventException;
	
	/**
	 * 9001 팝업화면 에서의 searchCostCodeDetailList
	 * @param SearchCostCodeDetailListVO paramVO
	 * @param TesCommonVO cmnVO
	 * @return List<SearchCostCodeDetailListVO>
	 * @throws EventException
	 */	
	public  List<SearchCostCodeDetailListVO> searchCostCodeDetailList(SearchCostCodeDetailListVO paramVO, TesCommonVO cmnVO) throws EventException;
	
	/**
	 * 9010  searchBkgCntrTPCDList
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public  EventResponse searchBkgCntrTPCDList(Event e) throws EventException;

}