/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RepairMgtBC.java
*@FileTitle : Repair History_Pop Up
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.AgreementGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrOrdTmpDtlVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrOrdTmpHdrVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.InterfaceGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomMnrOrdDtlVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.DocGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EDIInvoiceParkingLotDTLDataVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EDIInvoiceParkingLotGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EDIInvoiceParkingLotHDRDataVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EQWorkOrderHistoryListGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.ESTWOMainGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EstimateGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.GeneralWOGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.RepairCollectionGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.RepairResultGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.SparePartWOGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.WONoInquiryListGRPVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.view.signon.SignOnUserAccount;
 
/**
 * COM-General manage Business Logic Command Interface<br>
 * - COM-General manage interface of business logic<br>
 *
 * @author 
 * @see Ees_mnr_0003EventResponse
 * @since J2EE 1.4
 */	
     
public interface RepairMgtBC {
	/**
	 * [EES_MNR_0015] Retrieving unapproved estimate list before update<br>
	 *	
	 * @param AgreementGRPVO agreementGRPVO
	 * @return AgreementGRPVO
	 * @exception EventException
	 */				
	public AgreementGRPVO searchNotApprovalESTByAGMTBasic(AgreementGRPVO agreementGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0015] Retrieving estimate list for used agreement<br>
	 *
	 * @param AgreementGRPVO agreementGRPVO
	 * @return AgreementGRPVO
	 * @exception EventException
	 */				
	public AgreementGRPVO searchUsedEstimateByAGMTBasic(AgreementGRPVO agreementGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0192] Retrieving "EDI Estimate" data<br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @return EstimateGRPVO
	 * @exception EventException 
	 */
	public EstimateGRPVO searchEDIEstimateBasic(EstimateGRPVO estimateGRPVO) throws EventException;
		
	/**	
	 * [EES_MNR_0028] Retrieving "Repair Cancellation and Deletion" data<br>
	 *	
	 * @param RepairCollectionGRPVO repairCollectionGRPVO
	 * @param SignOnUserAccount 	account
	 * @return RepairCollectionGRPVO
	 * @exception EventException
	 */
	public RepairCollectionGRPVO searchRepairInquiryListBasic(RepairCollectionGRPVO repairCollectionGRPVO,SignOnUserAccount account) throws EventException;
	 
	/**
	 * [EES_MNR_0213] Retrieving "Warranty Alert_Pop-up" data<br>
	 *
	 * @param EQWorkOrderHistoryListGRPVO eQWorkOrderHistoryListGRPVO
	 * @return EQWorkOrderHistoryListGRPVO
	 * @exception EventException
	 */
	public EQWorkOrderHistoryListGRPVO searchEQWorkOrderHistoryListBasic(EQWorkOrderHistoryListGRPVO eQWorkOrderHistoryListGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0023] Retrieving "Repair Estimate Creation" data<br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO searchEstimateSMRListBasic(EstimateGRPVO estimateGRPVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0022] Retrieving "Repair Group Auditing" data<br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO searchESTGroupAuditListBasic(EstimateGRPVO estimateGRPVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0019] Deleting "Repair Estimate Creation" data<br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @return EstimateGRPVO
	 * @exception EventException 
	 */
	public EstimateGRPVO removeEstimateBasic(EstimateGRPVO estimateGRPVO) throws EventException;
		
	/**
	 * [EES_MNR_0019] Adding, modifying, deleting "Repair Estimate Creation" data<br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO manageEstimateBasic(EstimateGRPVO estimateGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0023] Adding, modifying, deleting "Repair Estimate Auditing" data<br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO	
	 * @exception EventException
	 */
	public EstimateGRPVO manageEstimateAuditItLaterBasic(EstimateGRPVO estimateGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0019] Modifying "Repair Estimate Creation" data<br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO requestEstimateBasic(EstimateGRPVO estimateGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0023] Modifying "Repair Estimate Auditing" data<br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */ 
	public EstimateGRPVO counterOfferEstimateBasic(EstimateGRPVO estimateGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0023] Modifying "Repair Estimate Auditing" data<br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO rejectEstimateBasic(EstimateGRPVO estimateGRPVO, SignOnUserAccount account) throws EventException;
		
	/**
	 * [EES_MNR_0022] Adding, modifying, deleting "Repair Group Auditing" data<br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */  
	public EstimateGRPVO manageESTGroupAuditListBasic(EstimateGRPVO estimateGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0027] Adding, modifying, deleting "Repair Cancellation and Deletion" data<br>
	 *
	 * @param RepairCollectionGRPVO repairCollectionGRPVO
	 * @param SignOnUserAccount account
	 * @return RepairCollectionGRPVO
	 * @exception EventException
	 */  
	public RepairCollectionGRPVO manageEstimateCancelBasic(RepairCollectionGRPVO repairCollectionGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0027] Adding, modifying, deleting "Repair Cancellation and Deletion" data<br>
	 *
	 * @param RepairCollectionGRPVO repairCollectionGRPVO
	 * @param SignOnUserAccount account
	 * @return RepairCollectionGRPVO
	 * @exception EventException
	 */  
	public RepairCollectionGRPVO manageRepairDeleteBasic(RepairCollectionGRPVO repairCollectionGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0023] Modify "Repair Estimate Creation" data<br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */	    
	public EstimateGRPVO approvalEstimateBasic(EstimateGRPVO estimateGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0192] Retrieving "Repair Estimate Creation" data<br>
	 *
	 * @param EstimateGRPVO estimateGRPVO
	 * @param SignOnUserAccount account
	 * @return EstimateGRPVO
	 * @exception EventException
	 */	
	public EstimateGRPVO searchEstimateBasic(EstimateGRPVO estimateGRPVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0211] Retrieving "Work Order" data<br>
	 *
	 * @param WONoInquiryListGRPVO wONoInquiryListGRPVO
	 * @return WONoInquiryListGRPVO
	 * @exception EventException
	 */ 
	public WONoInquiryListGRPVO searchWONoInquiryListBasic(WONoInquiryListGRPVO wONoInquiryListGRPVO)throws EventException;
	 
	/**
	 * [EES_MNR_0058] Retrieving "Extra Expense Work Order" data<br> 
	 * 
	 * @param GeneralWOGRPVO generalWOGRPVO
	 * @return GeneralWOGRPVO generalWOGRPVO
	 * @exception EventException
	 */ 	
	public GeneralWOGRPVO searchExtraWOBasic (GeneralWOGRPVO generalWOGRPVO)throws EventException;
	
	/**
	 * [EES_MNR_0032] Retrieving "Repair Result creation by W/O" data<br>
	 *
	 * @param RepairResultGRPVO repairResultGRPVO
	 * @return RepairResultGRPVO
	 * @exception EventException
	 */	
	public RepairResultGRPVO searchRepairResultListBasic (RepairResultGRPVO repairResultGRPVO)throws EventException;
     
	/**
	 * [EES_MNR_0032] Adding, modifying, deleting "Repair Result creation by W/O" data<br>
	 *
	 * @param RepairResultGRPVO repairResultGRPVO
	 * @param SignOnUserAccount account
	 * @return RepairResultGRPVO
	 * @exception EventException
	 */
	public RepairResultGRPVO manageRepairResultBasic(RepairResultGRPVO repairResultGRPVO, SignOnUserAccount account)throws EventException;
	 
	/**
	 * [EES_MNR_0058] Adding, modifying, deleting "Simple W/O Creation" data<br>
	 *
	 * @param GeneralWOGRPVO generalWOGRPVO
	 * @param SignOnUserAccount account
	 * @return GeneralWOGRPVO
	 * @exception EventException
	 */
	public GeneralWOGRPVO manageExtraWOBasic(GeneralWOGRPVO generalWOGRPVO, SignOnUserAccount account)throws EventException;
	
	/**
	 * [EES_MNR_0054] Adding, modifying, deleting "Vessel Reefer Spare Part Purchase W/O Creation" data<br>
	 *
	 * @param GeneralWOGRPVO generalWOGRPVO
	 * @param SignOnUserAccount account
	 * @return GeneralWOGRPVO
	 * @exception EventException
	 */
	public GeneralWOGRPVO manageRFSpareWOBasic(GeneralWOGRPVO generalWOGRPVO, SignOnUserAccount account)throws EventException;
	
	/**
	 * [EES_MNR_0058] Deleting "Vessel Reefer Spare Part Purchase W/O Creation" data<br>
	 *
	 * @param GeneralWOGRPVO generalWOGRPVO
	 * @param SignOnUserAccount account
	 * @return GeneralWOGRPVO
	 * @exception EventException
	 */ 
	public GeneralWOGRPVO removeWOBasic(GeneralWOGRPVO generalWOGRPVO, SignOnUserAccount account)throws EventException;
	
	/**
	 * [EES_MNR_0226] Getting "Simple W/O Inquiry Pop-up" data<br>
	 *
	 * @param GeneralWOGRPVO generalWOGRPVO
	 * @return GeneralWOGRPVO
	 * @exception EventException
	 */
	public GeneralWOGRPVO getBzcAmtBasic (GeneralWOGRPVO generalWOGRPVO)throws EventException;
	
	/**
	 * [EES_MNR_0023] Retrieving "Repair Estimate Creation" data<br>
	 * Retrieving the estimate data the last six months same disposed<br>
	 * @param EstimateGRPVO estimateGRPVO
	 * @return GeneralEventResponse
	 * @exception EventException
	 */ 
	public GeneralEventResponse searchLatestEstimateBasic(EstimateGRPVO estimateGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0036] Retrieving "M&R Document Transmission" data<br>
	 *
	 * @param DocGRPVO docGRPVO
	 * @return DocGRPVO
	 * @exception EventException
	 */
	public DocGRPVO searchDocSendBasic(DocGRPVO docGRPVO) throws EventException;

	/**
	 * [EES_MNR_0036] Adding, modifying, deleting "M&R Document Transmission" data<br>
	 *
	 * @param DocGRPVO docGRPVO
	 * @param SignOnUserAccount account
	 * @return DocGRPVO
	 * @exception EventException
	 */
	public DocGRPVO manageDocSendBasic(DocGRPVO docGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0030] Retrieving "W/O Creation" data<br>
	 *
	 * @param ESTWOMainGRPVO eSTWOMainGRPVO
	 * @param SignOnUserAccount account
	 * @return ESTWOMainGRPVO
	 * @exception EventException
	 */
	public ESTWOMainGRPVO searchESTWorkOrderListBasic(ESTWOMainGRPVO eSTWOMainGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0030] Retrieving "W/O Creation" data<br>
	 *
	 * @param ESTWOMainGRPVO eSTWOMainGRPVO
	 * @param SignOnUserAccount account
	 * @return ESTWOMainGRPVO
	 * @exception EventException
	 */
	public ESTWOMainGRPVO searchESTWorkOrderDetailListBasic(ESTWOMainGRPVO eSTWOMainGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0030] Adding "W/O Creation" data<br>
	 *
	 * @param ESTWOMainGRPVO eSTWOMainGRPVO
	 * @param SignOnUserAccount account
	 * @return ESTWOMainGRPVO
	 * @exception EventException
	 */ 
	public ESTWOMainGRPVO createESTWOCreationBasic(ESTWOMainGRPVO eSTWOMainGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Insert into table the data from EDI Received estimate<br>
	 * 	 	
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @exception EventException								  
	 */		
	public void ediEstimateCopyToEstimateBasic(InterfaceGRPVO interfaceGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0194] Retrieving "Reefer Spare Part Summary List" data<br>
	 *
	 * @param SparePartWOGRPVO sparePartWOGRPVO
	 * @return SparePartWOGRPVO
	 * @exception EventException
	 */
	public SparePartWOGRPVO searchWOInfoListBySparePartBasic(SparePartWOGRPVO sparePartWOGRPVO) throws EventException; 

	/**
	 * [EES_MNR_0041] Modifying "M&R Invoice Creation & Correction" data<br>
	 *
	 * @param GeneralWOGRPVO generalWOGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyWEBInvoiceLinkBasic(GeneralWOGRPVO generalWOGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0041] Modifying "M&R Invoice Creation & Correction" data<br>
	 *
	 * @param GeneralWOGRPVO generalWOGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyWEBInvoiceLinkClearBasic(GeneralWOGRPVO generalWOGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0019] Repair Estimate 의 정보를 조회 합니다. <br>
	 *
	 * @param EstimateGRPVO 	estimateGRPVO
	 * @return EstimateGRPVO
	 * @exception EventException
	 */
	public EstimateGRPVO searchESTNextVerNoListBasic(EstimateGRPVO estimateGRPVO) throws EventException;
	
	/**
	  * [EES_MNR_B001] Cost Shipment Update 대상을 조회한다<br> 
	  *
	  * @return List<CustomMnrOrdDtlVO>
	  * @exception EventException
	  */
	 public List<CustomMnrOrdDtlVO> searchEmptyCostShipmentData() throws EventException;
	 
	 /**
	  * [EES_MNR_B001]Cost Shipment Update <br>
	  * 
	  * @param CustomMnrOrdDtlVO customMnrOrdDtlVO
	  * @param String updUsrId
	  * @exception EventException
	  */
     public void modifyEmptyCostShipmentData(CustomMnrOrdDtlVO customMnrOrdDtlVO, String updUsrId) throws EventException;
     
     /**
 	 * [EES_MNR_0247]EDI Invoice Parking Lot Search Main Data<br>
 	 * 
 	 * @param EDIInvoiceParkingLotHDRDataVO eDIInvoiceParkingLotHDRDataVO
 	 * @return List<EDIInvoiceParkingLotHDRDataVO>
 	 * @exception EventException
 	 */
     public List<EDIInvoiceParkingLotHDRDataVO> searchEDIInvoiceParkingLotHDRData(EDIInvoiceParkingLotHDRDataVO eDIInvoiceParkingLotHDRDataVO) throws EventException;
 	
 	/**
 	 * [EES_MNR_0247]EDI Invoice Parking Lot Search Detail Data<br>
 	 * 
 	 * @param eDIInvoiceParkingLotDTLDataVO
 	 * @return EDIInvoiceParkingLotDTLDataVO
 	 * @exception EventException
 	 */
 	public List<EDIInvoiceParkingLotDTLDataVO> searchEDIInvoiceParkingLotDTLData(EDIInvoiceParkingLotDTLDataVO eDIInvoiceParkingLotDTLDataVO) throws EventException;
 	
 	/**
	 * manageEDIInvoiceParkingLotHDRData<br>
	 * 
	 * @param CustomMnrOrdTmpHdrVO[] customMnrOrdTmpHdrVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageEDIInvoiceParkingLotHDRData(CustomMnrOrdTmpHdrVO[] customMnrOrdTmpHdrVOs, SignOnUserAccount account) throws EventException;

	/**
	 * manageEDIInvoiceParkingLotDTLData<br>
	 * 
	 * @param CustomMnrOrdTmpDtlVO[] customMnrOrdTmpDtlVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageEDIInvoiceParkingLotDTLData(CustomMnrOrdTmpDtlVO[] customMnrOrdTmpDtlVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * manageEDIInvoiceParkingLotData<br>
	 * 
	 * @param EDIInvoiceParkingLotGRPVO eDIInvoiceParkingLotGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageEDIInvoiceParkingLotData(EDIInvoiceParkingLotGRPVO eDIInvoiceParkingLotGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * [EES_MNR_0247] Retrieving Back End Job <br>
	 *
	 * @return String
	 * @exception EventException
	 */ 
	public String searchBackEndJobCntBasic() throws EventException;
} 