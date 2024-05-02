/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InterfaceMgtBC.java
*@FileTitle : common File Upload 
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.basic;

import java.util.List;

import com.clt.apps.opus.bcm.fin.fincommon.fincommon.vo.CheckInvoiceNoVO;
import com.clt.apps.opus.ees.mnr.accountmanage.incomemgt.vo.ReceivableInvoiceGRPVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.ratemgt.vo.CustomMnrAgmtRtVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrOrdTmpDtlVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.DocResultVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.FaErpListVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.InterfaceGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EstimateUploadGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EstimateUploadVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * COM-Operationmanage Business Logic Command Interface<br>
 *
 * @author 
 * @see reference for File Upload 
 * @since J2EE 1.4
 */

public interface InterfaceMgtBC {
	/**
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @return InterfaceGRPVO interfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO checkEDIEstimateBasic(InterfaceGRPVO interfaceGRPVO) throws EventException;

	/**
	 * only TPB Interface Method <br>
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createTPBIFBasic(InterfaceGRPVO interfaceGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * only Flagging external Interface Method <br>
	 * modifying MST CGM 
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageIFFlagBasic(InterfaceGRPVO interfaceGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * handling Receive MQ <br>
	 * Estimate
	 * @param interfaceGRPVO   InterfaceGRPVO
	 * @return InterfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO manageMQEstimateBasic(InterfaceGRPVO interfaceGRPVO) throws EventException;

	/**
	 * handling Receive MQ <br>
	 * Estimate
	 * @param interfaceGRPVO   InterfaceGRPVO
	 * @return InterfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO manageMQNewPortRepairInvoiceBasic(InterfaceGRPVO interfaceGRPVO) throws EventException;
	
	/**
	 * [Interface]<br>
	 *
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createFileUploadBasic(InterfaceGRPVO interfaceGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0216]deleting Total Loss Request. <br>
	 *
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeFileUploadBasic(InterfaceGRPVO interfaceGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0029]deleting FQA Result Creation. <br>
	 *
	 * @param String fileSeq
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeFileUploadAllBasic(String fileSeq, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0223] retrieving Total Loss Request. <br>
	 *
	 * @param String fileSeq
	 * @param SignOnUserAccount account
	 * @return InterfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO searchFileUploadBasic(String fileSeq, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0036] handling M&R Document Transmission. <br>
	 *
	 * @param DocResultVO docResultVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String docSendBasic(DocResultVO docResultVO, SignOnUserAccount account) throws EventException;
		
	/**
	 * [EES_MNR_0159]handling Disposal Request. <br>
	 *
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @return InterfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO sendGeneralMailBasic(InterfaceGRPVO interfaceGRPVO) throws EventException;

	/**
	 * [EES_MNR_0157]handling Html Template mailing. <br>
	 *
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @return InterfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO sendHtmlMailBasic(InterfaceGRPVO interfaceGRPVO) throws EventException;

	/**
	 * [EES_MNR_0161] retrieving Scrapping/Donation Creation. <br>
	 *
	 * @param String eqNo
	 * @return String
	 * @exception EventException
	 */
	public String searchFAEqNoBasic(String eqNo) throws EventException;

	/**
	 * [EES_MNR_0041]handling M&R Invoice Creation & Correction. <br>
	 *
	 * @param String mnrGrpTpCd
	 * @param String refNum
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createCSRIFBasic(String mnrGrpTpCd, String refNum, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0041]deleting M&R Invoice Creation & Correction. <br>
	 *
	 * @param String refNum
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeCSRIFBasic(String refNum, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0161]retrieving Invoice list. <br>
	 *
	 * @param ReceivableInvoiceGRPVO receivableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @return ReceivableInvoiceGRPVO
	 * @exception EventException
	 */
	public ReceivableInvoiceGRPVO searchInvArIfListBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_QEXE]handling EDI FLAG SS error  <br>
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @return InterfaceGRPVO interfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO reSendErrorEDIBasic(InterfaceGRPVO interfaceGRPVO) throws EventException;

	/**
	 * [EES_MNR_QEXE]retrieving error EDI resending list <br>
	 *
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @return InterfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO searchReSendErrorEDIListBasic(InterfaceGRPVO interfaceGRPVO) throws EventException;

	/**
	 * processing Estimate Upload. <br>
	 *
	 * @param EstimateUploadVO[] estimateUploadVOs
	 * @param SignOnUserAccount userAccount
	 * @param String reqUi
	 * @return EstimateUploadGRPVO
	 * @exception EventException
	 */
	public EstimateUploadGRPVO createEstimateUploadBasic(EstimateUploadVO[] estimateUploadVOs, SignOnUserAccount userAccount, String reqUi) throws EventException;

	/**
	 * retrieving Estimate Upload. <br>
	 *
	 * @param EstimateUploadGRPVO estimateUploadGRPVO
	 * @return List<EstimateUploadVO>
	 * @exception EventException
	 */ 
	public List<EstimateUploadVO> searchEstimateUploadResultBasic(EstimateUploadGRPVO estimateUploadGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0161]Scrapping/Donation Creation의 정보를 작업 합니다. <br>
	 *
	 * @param FaErpListVO[] arrayFaErpListVOs
	 * @param SignOnUserAccount account
	 * @param String sFlag
	 * @exception EventException
	 */
	public void faSendBasic(FaErpListVO[] arrayFaErpListVOs, SignOnUserAccount account, String sFlag) throws EventException;
	
	/**
	 * Checking The Invoice No.
	 * @param CheckInvoiceNoVO checkInvoiceNoVO
	 * @return List<CheckInvoiceNoVO>
	 * @exception EventException
	 */
	public List<CheckInvoiceNoVO> checkInvoiceNo(CheckInvoiceNoVO checkInvoiceNoVO) throws EventException;
	
	/**
	 * Verifying New Port Invoice
	 * @param interfaceGRPVO   InterfaceGRPVO
	 * @param SignOnUserAccount account
	 * @return InterfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO verifyNewPortTempDataBasic(InterfaceGRPVO interfaceGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Handling New Port Invoice
	 * @param interfaceGRPVO   InterfaceGRPVO
	 * @param SignOnUserAccount account
	 * @return InterfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO manageNewPortWOInvoiceDataBasic(InterfaceGRPVO interfaceGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Verifying New Port Invoice
	 * @param interfaceGRPVO   InterfaceGRPVO
	 * @param SignOnUserAccount account
	 * @return InterfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO verifySOLBasic(InterfaceGRPVO interfaceGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Handling New Port Invoice
	 * @param interfaceGRPVO   InterfaceGRPVO
	 * @param SignOnUserAccount account
	 * @return InterfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO manageSOLInvoiceDataBasic(InterfaceGRPVO interfaceGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Handling Invoice
	 * @param interfaceGRPVO   InterfaceGRPVO
	 * @param SignOnUserAccount account
	 * @return InterfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO manageWOInvoiceDataBasic(InterfaceGRPVO interfaceGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 *  New Port EDI BackEndJob<br>
	 *
	 * @param interfaceGRPVO InterfaceGRPVO
	 * @param SignOnUserAccount account
	 * @return String
	 */
	public String newPortEdiBackEndJobBasic(InterfaceGRPVO interfaceGRPVO, SignOnUserAccount account);
	
	/**
	 * only Damage Flagging external Interface Method <br>
	 * modifying CTM
	 * @param InterfaceGRPVO   interfaceGRPVO
	 * @param SignOnUserAccount account
	 * @return String[]
	 * @exception EventException
	 */
	public String[] manageCtmIfFlagBasic(InterfaceGRPVO interfaceGRPVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Search Agreement Rate <br>
	 * @param CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO
	 * @return List<CustomMnrAgmtRtVO>
	 * @exception EventException
	 */
	public List<CustomMnrAgmtRtVO> searchAgmtRateBasic(CustomMnrOrdTmpDtlVO customMnrOrdTmpDtlVO) throws EventException;
	
	/**
	 * [EES_MNR_0248]SOL Invoice Uploading Back End Job<br>
	 *
	 * @param  InterfaceGRPVO interfaceGRPVO
	 * @param  SignOnUserAccount userAccount
	 * @return String
	 * @throws EventException
	 */
	public String backEndManageSOLInvoiceBasic(InterfaceGRPVO interfaceGRPVO, SignOnUserAccount userAccount) throws EventException;
	
	/**
	 * Newport EDI Process Batch<br>
	 *
	 * @param  String ediMsg
	 * @throws EventException
	 */
	public void excuteNewportBatchBasic(String ediMsg) throws EventException;
	
	/**
	 * Find VVD Information<br>
	 *
	 * @param  String bkgNo
	 * @return String
	 * @throws EventException
	 */
	public String searchRevVvdInfoBasic(String bkgNo) throws EventException;
}