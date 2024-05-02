/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepairMgtBC.java
*@FileTitle : Repair History_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.27
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.04.27 박명신
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.10.28 김상수 [CHM-201114133-01] ALPS MNR->REPAIR Estimate 에서 EDI Upload 시 Man-Hour 계산로직 수정
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.basic;

import com.hanjin.apps.alps.ees.mnr.agreementmanage.ratemgt.vo.AgreementGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.InterfaceGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.AcepChkGrpVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.DocGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EQWorkOrderHistoryListGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.ESTWOMainGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.GeneralWOGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.RepairCollectionGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.RepairResultGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.SparePartWOGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.WONoInquiryListGRPVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
 
/**
 * alps-Generalmanage Business Logic Command Interface<br>
 * - alps-Generalmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author park myoung sin
 * @see Ees_mnr_0003EventResponse 참조
 * @since J2EE 1.4
 */	
     
public interface RepairMgtBC {  
	/**
	 * [EES_MNR_0015] 버젼업 하기전 미승인된 견적서 리스트를 조회합니다.. <br>
	 *	
	 * @param AgreementGRPVO agreementGRPVO
	 * @return AgreementGRPVO
	 * @exception EventException
	 */				
	public AgreementGRPVO searchNotApprovalESTByAGMTBasic(AgreementGRPVO agreementGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0015] 견적서에서 해당 Agreement를 사용하는 견적서 리스트를 조회합니다.. <br>
	 *
	 * @param AgreementGRPVO agreementGRPVO
	 * @return AgreementGRPVO
	 * @exception EventException
	 */				
	public AgreementGRPVO searchUsedEstimateByAGMTBasic(AgreementGRPVO agreementGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0192] EDI Estimate의 정보를 조회 합니다. <br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @return EstimateGRPVO
	 * @exception EventException 
	 */
	public EstimateGRPVO searchEDIEstimateBasic(EstimateGRPVO estimateGRPVO) throws EventException;
		
	/**	
	 * [EES_MNR_0028] Repair Cancellation and Deletion의 정보를 조회 합니다. <br>
	 * EES_MNR_S027, EES_MNR_0027, EES_MNR_S028 만사용
	 * 2015.03.03 Repair Inquiry, Repair Cancelation & Deletion에서 사용하던부분을
	 * Repair Inquiry(EES_MNR_0028) 는 별도 적용
	 * 
	 * @param RepairCollectionGRPVO repairCollectionGRPVO
	 * @param SignOnUserAccount 	account
	 * @return RepairCollectionGRPVO
	 * @exception EventException
	 */
	public RepairCollectionGRPVO searchRepairInquiryListBasic(RepairCollectionGRPVO repairCollectionGRPVO,SignOnUserAccount account) throws EventException;

	/**	
	 * [EES_MNR_0028] Repair Cancellation and Deletion의 정보를 조회 합니다. <br>
	 * EES_MNR_0028 만사용
	 * 2015.03.03 Repair Inquiry, Repair Cancelation & Deletion에서 사용하던부분을
	 * Repair Inquiry(EES_MNR_0028)만 별도 적용
	 *	
	 * @param RepairCollectionGRPVO repairCollectionGRPVO
	 * @param SignOnUserAccount 	account
	 * @return RepairCollectionGRPVO
	 * @exception EventException
	 */
	public RepairCollectionGRPVO searchRepairInquiryListForHJS(RepairCollectionGRPVO repairCollectionGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0213] Warranty Alert_Pop Up의 정보를 조회 합니다. <br>
	 *
	 * @param EQWorkOrderHistoryListGRPVO eQWorkOrderHistoryListGRPVO
	 * @return EQWorkOrderHistoryListGRPVO
	 * @exception EventException
	 */
	public EQWorkOrderHistoryListGRPVO searchEQWorkOrderHistoryListBasic(EQWorkOrderHistoryListGRPVO eQWorkOrderHistoryListGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0023] Repair Estimate Creation의 정보를 조회 합니다. <br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO searchEstimateSMRListBasic(EstimateGRPVO estimateGRPVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0022] Repair Group Auditing의 정보를 조회 합니다. <br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO searchESTGroupAuditListBasic(EstimateGRPVO estimateGRPVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0019] Repair Estimate Creation의 정보를 작업 합니다. <br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @return EstimateGRPVO
	 * @exception EventException 
	 */
	public EstimateGRPVO removeEstimateBasic(EstimateGRPVO estimateGRPVO) throws EventException;
		
	/**
	 * [EES_MNR_0019] Repair Estimate Creation의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO manageEstimateBasic(EstimateGRPVO estimateGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0023] Repair Estimate Auditing의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO	
	 * @exception EventException
	 */
	public EstimateGRPVO manageEstimateAuditItLaterBasic(EstimateGRPVO estimateGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0019] Repair Estimate Creation의 정보를 작업 합니다. <br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO requestEstimateBasic(EstimateGRPVO estimateGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0023] Repair Estimate Auditing의 정보를 작업 합니다. <br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */ 
	public EstimateGRPVO counterOfferEstimateBasic(EstimateGRPVO estimateGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0023] Repair Estimate Auditing의 정보를 작업 합니다. <br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO rejectEstimateBasic(EstimateGRPVO estimateGRPVO, SignOnUserAccount account) throws EventException;
		
	/**
	 * [EES_MNR_0022] Repair Group Auditing의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */  
	public EstimateGRPVO manageESTGroupAuditListBasic(EstimateGRPVO estimateGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0027] Repair Cancellation and Deletion의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param RepairCollectionGRPVO repairCollectionGRPVO
	 * @param SignOnUserAccount account
	 * @return RepairCollectionGRPVO
	 * @exception EventException
	 */  
	public RepairCollectionGRPVO manageEstimateCancelBasic(RepairCollectionGRPVO repairCollectionGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0027] Repair Cancellation and Deletion의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param RepairCollectionGRPVO repairCollectionGRPVO
	 * @param SignOnUserAccount account
	 * @return RepairCollectionGRPVO
	 * @exception EventException
	 */  
	public RepairCollectionGRPVO manageRepairDeleteBasic(RepairCollectionGRPVO repairCollectionGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0023] Repair Estimate Creation의 정보를 작업 합니다. <br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */	    
	public EstimateGRPVO approvalEstimateBasic(EstimateGRPVO estimateGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0192] Repair Estimate Creation의 정보를 조회 합니다. <br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */	
	public EstimateGRPVO searchEstimateBasic(EstimateGRPVO estimateGRPVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0211] Work Order의 정보를 조회 합니다. <br>
	 *
	 * @param WONoInquiryListGRPVO wONoInquiryListGRPVO
	 * @return WONoInquiryListGRPVO
	 * @exception EventException
	 */ 
	public WONoInquiryListGRPVO searchWONoInquiryListBasic(WONoInquiryListGRPVO wONoInquiryListGRPVO)throws EventException;
	 
	/**
	 * [EES_MNR_0058] Extra Expense Work Order을 조회합니다.<br> 
	 * 
	 * @param GeneralWOGRPVO generalWOGRPVO
	 * @return GeneralWOGRPVO generalWOGRPVO
	 * @exception EventException
	 */ 	
	public GeneralWOGRPVO searchExtraWOBasic (GeneralWOGRPVO generalWOGRPVO)throws EventException;
	
	/**
	 * [EES_MNR_0032] Repair Result creatioln by W/O의 정보를 조회 합니다. <br>
	 *
	 * @param RepairResultGRPVO repairResultGRPVO
	 * @return RepairResultGRPVO
	 * @exception EventException
	 */	
	public RepairResultGRPVO searchRepairResultListBasic (RepairResultGRPVO repairResultGRPVO)throws EventException;
     
	/**
	 * [EES_MNR_0032] Repair Result creatioln by W/O의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param RepairResultGRPVO repairResultGRPVO
	 * @param SignOnUserAccount account
	 * @return RepairResultGRPVO
	 * @exception EventException
	 */
	public RepairResultGRPVO manageRepairResultBasic(RepairResultGRPVO repairResultGRPVO, SignOnUserAccount account)throws EventException;
	 
	/**
	 * [EES_MNR_0058] Simple W/O Creation의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param GeneralWOGRPVO generalWOGRPVO
	 * @param SignOnUserAccount account
	 * @return GeneralWOGRPVO
	 * @exception EventException
	 */
	public GeneralWOGRPVO manageExtraWOBasic(GeneralWOGRPVO generalWOGRPVO, SignOnUserAccount account)throws EventException;
	
	/**
	 * [EES_MNR_0054] Vessel Reefer Spare Part Purchase W/O Creation의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param GeneralWOGRPVO generalWOGRPVO
	 * @param SignOnUserAccount account
	 * @return GeneralWOGRPVO
	 * @exception EventException
	 */
	public GeneralWOGRPVO manageRFSpareWOBasic(GeneralWOGRPVO generalWOGRPVO, SignOnUserAccount account)throws EventException;
	
	/**
	 * [EES_MNR_0058] Vessel Reefer Spare Part Purchase W/O Creation의 정보를 삭제 합니다. <br>
	 *
	 * @param GeneralWOGRPVO generalWOGRPVO
	 * @param SignOnUserAccount account
	 * @return GeneralWOGRPVO
	 * @exception EventException
	 */ 
	public GeneralWOGRPVO removeWOBasic(GeneralWOGRPVO generalWOGRPVO, SignOnUserAccount account)throws EventException;
	
	/**
	 * [EES_MNR_0226] Simple W/O Inquiry Pop Up의 정보를 작업 합니다. <br>
	 *
	 * @param GeneralWOGRPVO generalWOGRPVO
	 * @return GeneralWOGRPVO
	 * @exception EventException
	 */
	public GeneralWOGRPVO getBzcAmtBasic (GeneralWOGRPVO generalWOGRPVO)throws EventException;
	
	/**
	 * [EES_MNR_0023] Repair Estimate Creation의 정보를 조회 합니다. <br>
	 * 최근 6개월 같은건을 처리한 견적서를 조회 합니다.<br>
	 * @param EstimateGRPVO estimateGRPVO
	 * @return GeneralEventResponse
	 * @exception EventException
	 */ 
	public GeneralEventResponse searchLatestEstimateBasic(EstimateGRPVO estimateGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0036] M&R Document Transmission의 정보를 조회 합니다. <br>
	 *
	 * @param DocGRPVO docGRPVO
	 * @return DocGRPVO
	 * @exception EventException
	 */
	public DocGRPVO searchDocSendBasic(DocGRPVO docGRPVO) throws EventException;

	/**
	 * [EES_MNR_0036] M&R Document Transmission의 정보를 추가/수정/삭제 합니다. <br>
	 *
	 * @param DocGRPVO docGRPVO
	 * @param SignOnUserAccount account
	 * @return DocGRPVO
	 * @exception EventException
	 */
	public DocGRPVO manageDocSendBasic(DocGRPVO docGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0030] W/O Creation의 정보를 조회 합니다. <br>
	 *
	 * @param ESTWOMainGRPVO eSTWOMainGRPVO
	 * @param SignOnUserAccount account
	 * @return ESTWOMainGRPVO
	 * @exception EventException
	 */
	public ESTWOMainGRPVO searchESTWorkOrderListBasic(ESTWOMainGRPVO eSTWOMainGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0030] W/O Creation의 정보를 조회 합니다. <br>
	 *
	 * @param ESTWOMainGRPVO eSTWOMainGRPVO
	 * @param SignOnUserAccount account
	 * @return ESTWOMainGRPVO
	 * @exception EventException
	 */
	public ESTWOMainGRPVO searchESTWorkOrderDetailListBasic(ESTWOMainGRPVO eSTWOMainGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0030] W/O Creation의 정보를 작업 합니다. <br>
	 *
	 * @param ESTWOMainGRPVO eSTWOMainGRPVO
	 * @param SignOnUserAccount account
	 * @return ESTWOMainGRPVO
	 * @exception EventException
	 */ 
	public ESTWOMainGRPVO createESTWOCreationBasic(ESTWOMainGRPVO eSTWOMainGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [UDEVHJS_ALPSMNR_T_WESTIM] EDI Recieve 견적서를 견적서 테이블에 넣는다. <br>
	 * 	 	
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @exception EventException								  
	 */		
	public void ediEstimateCopyToEstimateBasic(InterfaceGRPVO interfaceGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0194] Reefer Spare Part Summary List의 정보를 조회 합니다. <br>
	 *
	 * @param SparePartWOGRPVO sparePartWOGRPVO
	 * @return SparePartWOGRPVO
	 * @exception EventException
	 */
	public SparePartWOGRPVO searchWOInfoListBySparePartBasic(SparePartWOGRPVO sparePartWOGRPVO) throws EventException; 

	/**
	 * [EES_MNR_0041]M&R Invoice Creation & Correction의 정보를 수정 합니다.  <br>
	 *
	 * @param GeneralWOGRPVO generalWOGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyWEBInvoiceLinkBasic(GeneralWOGRPVO generalWOGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0041]M&R Invoice Creation & Correction의 정보를 삭제 합니다.  <br>
	 *
	 * @param GeneralWOGRPVO generalWOGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyWEBInvoiceLinkClearBasic(GeneralWOGRPVO generalWOGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EDI Estimate Auditing]Repair Estimate Creation의 디테일정보만 정보를 조회 합니다. <br>
	 *
	 * @param EstimateGRPVO 	estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO searchEstimateDtl(EstimateGRPVO estimateGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [UDEVHJS_ALPSMNR_T_WESTIM] EDI Recieve 견적서를 견적서 테이블에 넣는다. <br>
	 * 	 	
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @return CustomMnrRprRqstHdrVO
	 * @exception EventException								  
	 */		
	public CustomMnrRprRqstHdrVO ediEstimateCopyToEstimateDetail(InterfaceGRPVO interfaceGRPVO) throws EventException;

	/**
	 * [UDEVHJS_ALPSMNR_T_WESTIM] TMP_DTL과 견적서DTL의 Labor Hour를 수정<br>
	 *
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @param EstimateGRPVO estimateGRPVO
	 * @exception EventException
	 */
	public void modifyEstimateDTLTmpDTLBasic(InterfaceGRPVO interfaceGRPVO, EstimateGRPVO estimateGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0019] Repair Estimate 의 정보를 조회 합니다. <br>
	 *
	 * @param EstimateGRPVO 	estimateGRPVO
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO searchESTNextVerNoListBasic(EstimateGRPVO estimateGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0023] Repair Estimate 의 정보를 조회 합니다. <br>
	 *
	 * @param EstimateGRPVO 	estimateGRPVO
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO searchESTApprovalNextVerNoListBasic(EstimateGRPVO estimateGRPVO) throws EventException;

	/**
	 * [EES_MNR_0023] Repair Estimate 의 썸네일 정보를 조회 합니다. <br>
	 *
	 * @param String fileSeq
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public String searchHtmlCodeForThumbnail(String fileSeq) throws EventException;
	
	/**
	 * [EES_MNR_0061] ACEP Check List 조회 <br>
	 *
	 * @param acepChkGrpVO
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public AcepChkGrpVO searchAcepChk(AcepChkGrpVO acepChkGrpVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0061] ACEP Check List Insert <br>
	 * @param acepChkGrpVO
	 * @param account
	 * @return
	 * @throws EventException
	 */
	public AcepChkGrpVO manageAcepChk(AcepChkGrpVO acepChkGrpVO,SignOnUserAccount account) throws EventException;
} 