/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : OffdockCYInvoiceManageBC.java
*@FileTitle : Off-dock CY Invoice Management
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.basic;

import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;

/**
 * ESD Business Logic Command Interface<br>
 *
 * @author byungheeyoo
 * @see ESD_TES_004EventResponse
 * @since J2EE 1.4
 */
public interface OffdockCYInvoiceManageBC  {

	/**
	 * Cost Calc. Calculated
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse calOffdockCYInvoiceCost(Event e) throws EventException;
	
	/** searchDBCheckOffDockTerminalInvoice
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse searchDBCheckOffDockTerminalInvoice(Event e) throws EventException;

	/**
	 * Off Dock CY Invoice Creation & Correction - insert TES_TML_SO_HDR
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse createOffdockCYInvoiceBasicInfo(Event e) throws EventException;

	/**
	 * Off Dock CY Invoice Creation & Correction - Container List Insert
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse createOffdockCYInvoiceContainerList(Event e) throws EventException;

	/**
	 * Off Dock CY Invoice Creation & Correction - Cost Calculation(Detail) List Insert
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse createOffdockCYInvoiceDetail(Event e) throws EventException;

	/**
	 * confirm Info Update
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse modifyOffdockCYInvoice(Event e) throws EventException;

	/**
	 * confirm Info Update
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse modifyOffdockCYInvoiceConfirm(Event e) throws EventException;

	/**
	 * Reject Invoice Info Update
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse modifyOffdockCYInvoiceReject(Event e) throws EventException;

	/**
	 * Revise Volume Calculated
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse multiReviseCalculatedVolume(Event e) throws EventException;
	
	/**
	 * Revise Volume Calculated
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse multiReviseCalculatedVolumeM(Event e) throws EventException;

	/**
	 * Revise Calculated Volume Separate
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse multiReviseCalculatedVolumeSeparate(Event e) throws EventException;
	
	/**
	 * Revise Calculated Volume Separate
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse multiReviseCalculatedVolumeSeparateM(Event e) throws EventException;
	
	/** multiReviseCalculatedVolumeSeparateMTPB
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse multiReviseCalculatedVolumeSeparateMTPB(Event e) throws EventException;

	/**
	 * Recalculated OffDock Invoice Cost 
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse recalculateOffdocCYInvoiceCostAmount(Event e) throws EventException;

	/**
	 * Recalculated OffDock Invoice Cost Amount Separate
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse recalculateOffdocCYInvoiceCostAmountSeparate(Event e) throws EventException;	

	/**
	 * Recalculated OffDock Invoice Revise Calculated Volume Count
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse recalculateReviseCalculatedVolumeCount(Event e) throws EventException;
	
	/**
	 * Recalculated OffDock Invoice Revise Calculated Volume Count
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse recalculateReviseCalculatedVolumeCountM(Event e) throws EventException;

	/**
	 * Recalculated OffDock Invoice Revise Calculated Volume Count Separate
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse recalculateReviseCalculatedVolumeCountSeparate(Event e) throws EventException;
	
	/**
	 * Recalculated OffDock Invoice Revise Calculated Volume Count Separate
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse recalculateReviseCalculatedVolumeCountSeparateM(Event e) throws EventException;

	/** recalculateReviseCalculatedVolumeCountSeparateMTPB
	 *  
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse recalculateReviseCalculatedVolumeCountSeparateMTPB(Event e) throws EventException;

	/**
	 * OffDock CY Invoice Container List Delete.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeOffdockCYInvoiceContainerList(Event e) throws EventException;

	/**
	 * OffDock CY Invoice Detail TMNL List Delete
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse removeOffdockCYInvoiceDetailTMNL(Event e) throws EventException;

	/**
	 * OffDock CY Invoice Detail By Day List Delete
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeOffdockCYInvoiceDetailByDay(Event e) throws EventException;

	/**
	 * OffDock CY Invoice Detail By Day List Delete
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeOffdockCYInvoiceDetailByPool(Event e) throws EventException;

	/**
	 * OffDock CY Invoice Detail By EQ List Delete
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeOffdockCYInvoiceDetailByEQ(Event e) throws EventException;

	/**
	 * OffDock CY Invoice Auto Calculation TMNL Delete
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeOffdockCYAutoCalcTMNL(Event e) throws EventException;

	/**
	 * OffDock CY Invoice Revise List Delete
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeOffdockCYInvoiceRvis(Event e) throws EventException;

	/**
	 * 3rd list(TMNL, FD) 삭제
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeOffdockCYInvoiceN3rd01(Event e) throws EventException;

	/**
	 * 3rd list(FP) 삭제
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeOffdockCYInvoiceN3rd02(Event e) throws EventException;
	
	/**
	 * 3rd list(EQ) 삭제
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeOffdockCYInvoiceN3rd03(Event e) throws EventException;
		
	/**
	 * OffDock CY Auto Calculation By Day List Delete
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeOffdockCYAutoCalcByDay(Event e) throws EventException;

	/**
	 * OffDock CY Auto Calculation By Pool List Delete
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeOffdockCYAutoCalcByPool(Event e) throws EventException;
	
	/**
	 * OffDock CY Container List Select.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYContainerList(Event e) throws EventException;

	/**
	 * OffDock CY Cost Calculation Status Select.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYCostCalcSts(Event e) throws EventException;	

	/**
	 * OffDock Invoice Header Info Search
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYInvoiceBasicInfo(Event e) throws EventException;

	/**
	 * OffDock Invoice Detail Info Search
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYInvoiceDetail(Event e) throws EventException;

	/**
	 * OffDock CY Invoice All Data Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYInvoiceAllSheets(Event e) throws EventException;

	/**
	 * OffDock CY Invoice All Data Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYInvoiceAllSheetsInquiry(Event e) throws EventException;
	
	/**
	 * OffDock CY Invoice Reject Info Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYInvoiceRejectInfo(Event e) throws EventException;

	/**
	 * OffDock CY Invoice Total Amount Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYTotalAmount(Event e) throws EventException;

	/**
	 * OffDock CY Invoice Revised Volume TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchRevisedVolume(Event e) throws EventException;

	/**
	 * OffDock CY Invoice Revised Volume Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchRevisedVolumeSeparate(Event e) throws EventException;

	/**
	 * OffDock CY Invoice Revised Volume TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchRevisedVolume2(Event e) throws EventException;

	/**
	 * OffDock CY Invoice Revised Volume Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchRevisedVolumeSeparate2(Event e) throws EventException;

	/**
	 * OffDock CY Invoice 수동시 revise mode TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYReviseMode(Event e) throws EventException;

	/**
	 * OffDock CY Invoice 수동시 revise mode Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYReviseModeSeparate(Event e) throws EventException;

	/**
	 * OffDock CY Invoice revise mode(N) container List TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
//	public EventResponse searchOffdockCYRvisCntrListCdN(Event e) throws EventException;

	/**
	 * OffDock CY Invoice revise mode(MT) container List TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYRvisCntrListCdMT(Event e) throws EventException;

	/**
	 * OffDock CY Invoice revise mode(DG) container List TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYRvisCntrListCdDG(Event e) throws EventException;

	/**
	 * OffDock CY Invoice revise mode(RF) container List TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYRvisCntrListCdRF(Event e) throws EventException;

	/**
	 * OffDock CY Invoice revise mode(AK) container List TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYRvisCntrListCdAK(Event e) throws EventException;

	/**
	 * OffDock CY Invoice revise mode(N) container List Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
//	public EventResponse searchOffdockCYRvisCntrListCdNSeparate(Event e) throws EventException;

	/**
	 * OffDock CY Invoice revise mode(MT) container List Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYRvisCntrListCdMTSeparate(Event e) throws EventException;

	/**
	 * OffDock CY Invoice revise mode(DG) container List Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYRvisCntrListCdDGSeparate(Event e) throws EventException;

	/**
	 * OffDock CY Invoice revise mode(RF) container List Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYRvisCntrListCdRFSeparate(Event e) throws EventException;

	/**
	 * OffDock CY Invoice revise mode(AK) container List Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYRvisCntrListCdAKSeparate(Event e) throws EventException;

	/**
	 * OffDock CY Invoice 3rd party List TMNL Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdock3rdIFlistOnly(Event e) throws EventException;
	
	/**
	 * OffDock CY Invoice 3rd party List TMNL Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdock3rdIFlist(Event e) throws EventException;


	/**
	 * OffDock CY Invoice 3rd party List ByDay Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdock3rdIFlistByDay(Event e) throws EventException;

	/**
	 * OffDock CY Invoice Container Number Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCNTRNumber(Event e) throws EventException;

	/**
	 * OffDock CY Invoice Container Number Update
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse updateCNTRNumber(Event e) throws EventException;
	
	/**
	 * OffDock CY Invoice Container List Import File Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTES_FILE_IMP_TMP(Event e) throws EventException;
	
	/**
	 * OffDock CY Invoice Container List Verify
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse verifyOffdockCYInvoiceVolume(Event e) throws EventException;

	/**
	 * OffDock CY Invoice Container List Verify Insert.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public int insertOffdockCYInvoiceContainerList(Event e) throws EventException;
	
	/**
	 * OffDock CY Invoice Container List Import File Insert.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse createTES_FILE_IMP_TMP(Event e) throws EventException;

	/**
	 * OffDock CY Invoice Container List Import File Delete.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeTES_FILE_IMP_TMP(Event e) throws EventException;
	
	/**
	 * OffDock CY Invoice Account Code Update.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse updateOffdockCYAccountCode(Event e) throws EventException;

	/**
	 * OffDock CY Invoice Account Code Update.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse cancelOffdockCYInvoiceConfirm(Event e) throws EventException;

	/**
	 * OffDock CY Invoice Reject Cancel.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse cancelOffdockCYInvoiceReject(Event e) throws EventException;

	/** multiOffDockTerminalInvoiceDBVerify
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	public EventResponse multiOffDockTerminalInvoiceDBVerify(Event e) throws EventException;
	
	/**
	 * OffDock CY Invoice Basic(Header) Info Select.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYInvoiceBasicInfoInquiry(Event e) throws EventException;

	
	/**
	 * OffDock CY Invoice 3rd Party Insert, Update.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiOffdock3rdIFlist(Event e) throws EventException;
		
	/**
	 * OffDock Search CNTR TYPE CD List 
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchBkgCntrTPCDList(Event e) throws EventException;
}