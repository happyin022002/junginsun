/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : OffdockCYInvoiceManageBC.java
*@FileTitle : Off-dock CY Invoice 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2007-10-09
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-09-14 byungheeyoo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.offdockcyinvoicemanage.basic;

import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;

/**
 * ENIS-ESD Business Logic Command Interface<br>
 * - ENIS-ESD에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author byungheeyoo
 * @see ESD_TES_004EventResponse 참조
 * @since J2EE 1.4
 */
public interface OffdockCYInvoiceManageBC  {

	/**
	 * Cost Calc. 계산하기
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse calOffdockCYInvoiceCost(Event e) throws EventException;

	/**
	 * Off Dock CY Invoice Creation & Correction - insert TES_TML_SO_HDR
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse createOffdockCYInvoiceBasicInfo(Event e) throws EventException;

	/**
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public String startBackEndJob(Event e) throws EventException; 
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
	 * confirm 정보 수정
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse modifyOffdockCYInvoice(Event e) throws EventException;

	/**
	 * confirm 정보 수정
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse modifyOffdockCYInvoiceConfirm(Event e) throws EventException;

	/**
	 * Reject Invoice 정보 수정
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
	public EventResponse multiReviseCalculatedVolumeForTMRFMO(Event e) throws EventException;
	
	/**
	 * Revise Volume Calculated
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse multiReviseCalculatedVolumeM(Event e) throws EventException;

	/**
	 * Revise Volume Calculated
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse multiReviseCalculatedVolumeMForTMRFMO(Event e) throws EventException;
	
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

	/**
	 * Recalculated OffDock Invoice Cost 
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse recalculateOffdocCYInvoiceCostAmount(Event e) throws EventException;

	/**
	 * Recalculated OffDock Invoice Cost 
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse recalculateOffdocCYInvoiceCostAmountForTMRFMO(Event e) throws EventException;
	
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
	public EventResponse recalculateReviseCalculatedVolumeCountForTMRFMO(Event e) throws EventException;
	
	/**
	 * Recalculated OffDock Invoice Revise Calculated Volume Count
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse recalculateReviseCalculatedVolumeCountM(Event e) throws EventException;

	/**
	 * Recalculated OffDock Invoice Revise Calculated Volume Count
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse recalculateReviseCalculatedVolumeCountMForTMRFMO(Event e) throws EventException;
	
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
	 * 호출되는곳 안보임.(2010-02-08)
	 * OffDock CY Cost Calculation Status Select.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYCostCalcSts(Event e) throws EventException;	

	/**
	 * OffDock Invoice Header 정보 조회
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYInvoiceBasicInfo(Event e) throws EventException;

	/**
	 * OffDock Invoice Detail 정보 조회
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
	 * OffDock CY Invoice Revised Volume TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchRevisedVolumeForTMRFMO(Event e) throws EventException;
	
	/**
	 * OffDock CY Invoice Revised Volume Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchRevisedVolumeSeparate(Event e) throws EventException;

	/**
	 * OffDock CY Invoice Revised Volume Double Billing Check
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public String[] searchOffdockRevisedVolumeDoubleBillChk(Event e) throws EventException;

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
	 * OffDock CY Invoice 수동시 revise mode TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYReviseModeForTMRFMO(Event e) throws EventException;
	
	/**
	 * OffDock CY Invoice 수동시 revise mode Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYReviseModeSeparate(Event e) throws EventException;

	/**
	 * OffDock CY Invoice revise mode(N) container 목록 TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
//	public EventResponse searchOffdockCYRvisCntrListCdN(Event e) throws EventException;

	/**
	 * OffDock CY Invoice revise mode(MT) container 목록 TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYRvisCntrListCdMT(Event e) throws EventException;

	/**
	 * OffDock CY Invoice revise mode(MT) container 목록 TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYRvisCntrListCdMTForTMRFMO(Event e) throws EventException;
	
	/**
	 * OffDock CY Invoice revise mode(DG) container 목록 TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYRvisCntrListCdDG(Event e) throws EventException;

	/**
	 * OffDock CY Invoice revise mode(DG) container 목록 TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYRvisCntrListCdDGForTMRFMO(Event e) throws EventException;

	/**
	 * OffDock CY Invoice revise mode(RF) container 목록 TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYRvisCntrListCdRF(Event e) throws EventException;

	/**
	 * OffDock CY Invoice revise mode(RF) container 목록 TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYRvisCntrListCdRFForTMRFMO(Event e) throws EventException;

	/**
	 * OffDock CY Invoice revise mode(AK) container 목록 TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYRvisCntrListCdAK(Event e) throws EventException;

	/**
	 * OffDock CY Invoice revise mode(AK) container 목록 TP Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYRvisCntrListCdAKForTMRFMO(Event e) throws EventException;
	
	/**
	 * OffDock CY Invoice revise mode(N) container 목록 Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
//	public EventResponse searchOffdockCYRvisCntrListCdNSeparate(Event e) throws EventException;

	/**
	 * OffDock CY Invoice revise mode(MT) container 목록 Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYRvisCntrListCdMTSeparate(Event e) throws EventException;

	/**
	 * OffDock CY Invoice revise mode(DG) container 목록 Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYRvisCntrListCdDGSeparate(Event e) throws EventException;

	/**
	 * OffDock CY Invoice revise mode(RF) container 목록 Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYRvisCntrListCdRFSeparate(Event e) throws EventException;

	/**
	 * OffDock CY Invoice revise mode(AK) container 목록 Separate Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse searchOffdockCYRvisCntrListCdAKSeparate(Event e) throws EventException;

	/**
	 * OffDock CY Invoice 3rd party 목록 TMNL Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdock3rdIFlistOnly(Event e) throws EventException;
	
	/**
	 * OffDock CY Invoice 3rd party 목록 TMNL Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchOffdock3rdIFlist(Event e) throws EventException;


	/**
	 * OffDock CY Invoice 3rd party 목록 ByDay Select
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
	 * OffDock CY Invoice Container Number Update
	 *
	 * @param TesTmlSoHdrVO tesTmlSoHdrVO
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse updateCNTRNumber2(TesTmlSoHdrVO tesTmlSoHdrVO) throws EventException;
	
	/**
	 * OffDock CY Invoice Container List Import File Select
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTES_FILE_IMP_TMP(Event e) throws EventException;
	
	/**
	 * OffDock CY Invoice Container List Verify By Pool
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse verifyOffdockCYInvoiceCostByPool(Event e) throws EventException;

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
	 * OffDock CY Invoice Cost Calculation List Insert.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public int insertOffdockCYInvoiceDetail(Event e) throws EventException;
	
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
	 * OffDock CY Invoice Container List Import File By Pool Insert.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse createTES_FILE_IMP_TMPByPool(Event e) throws EventException;

	/**
	 * OffDock CY Invoice Container List Import File By Pool Delete.
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */	
	public EventResponse removeTES_FILE_IMP_TMPByPool(Event e) throws EventException;
	
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

	
	/******** Moon 시작 *****************************/

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
	/******** Moon 끝 *****************************/
}