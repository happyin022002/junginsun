/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InterfaceMgtBC.java
*@FileTitle : File Upload 관련 공틍
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 이주현
*@LastVersion : 1.0
* 2009.06.10 이주현
* 1.0 Creation
--------------------------------------------------------
* History
* 2011.12.12 김상수 [CHM-201115107-01] MNR Repair SPP Upload 기능 Verify Result 기능 강화
*                                      - Excel Upload 직후 MST에서 EQ No 존재유무 확인 로직 추가
*                                      - Error 발생시 사용자 메세지 팝업창 수정
*                                      - Confirm시 Fail일때, 원인내용 표기
* 2012.06.15 신혜정 [CHM-201218436] [Calculation] 버튼 기능 추가    
* 2012.07.31 신혜정	[CHM-201219139]	FA Interface 로그 보완 작업	                            
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.basic;

import java.util.List;

import com.hanjin.apps.alps.ees.mnr.accountmanage.incomemgt.vo.ReceivableInvoiceGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.FaErpListVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.InterfaceGRPVO;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo.DocResultVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateUploadGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateUploadVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstHdrVO;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-Operationmanage Business Logic Command Interface<br>
 * - alps-Operationmanage에 대한 비지니스 로직에 대한 인터페이스<br>
 *
 * @author lee ju hyun
 * @see File Upload관련 참조
 * @since J2EE 1.4
 */

public interface InterfaceMgtBC {
	/**
	 * [UDEVHJS_ALPSMNR_T_WESTIM] EDI를 통해 들어온 견적서가 본테이블로 이동가능한지 검증. <br>
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @return InterfaceGRPVO interfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO checkEDIEstimateBasic(InterfaceGRPVO interfaceGRPVO) throws EventException;

	/**
	 * TPB 전용 Interface Method <br>
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createTPBIFBasic(InterfaceGRPVO interfaceGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * Flagging 전용 외부 Interface Method <br>
	 * MST CGM 에 정보를 업데이트 합니다.
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageIFFlagBasic(InterfaceGRPVO interfaceGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * Receive MQ 연동 처리<br>
	 * Estimate
	 * @param interfaceGRPVO   InterfaceGRPVO
	 * @return InterfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO manageMQEstimateBasic(InterfaceGRPVO interfaceGRPVO) throws EventException;

	/**
	 * [Interface ] 의 정보를 작업 합니다. <br>
	 *
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createFileUploadBasic(InterfaceGRPVO interfaceGRPVO,SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0216]Total Loss Request의 정보를 삭제 합니다. <br>
	 *
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeFileUploadBasic(InterfaceGRPVO interfaceGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0029]FQA Result Creation의 정보를 삭제 합니다. <br>
	 *
	 * @param String fileSeq
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeFileUploadAllBasic(String fileSeq, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0223]Total Loss Request의 정보를 조회 합니다. <br>
	 *
	 * @param String fileSeq
	 * @param SignOnUserAccount account
	 * @return InterfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO searchFileUploadBasic(String fileSeq, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0036]M&R Document Transmission의 정보를 작업 합니다. <br>
	 *
	 * @param DocResultVO docResultVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String docSendBasic(DocResultVO docResultVO, SignOnUserAccount account) throws EventException;

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
	 * [EES_MNR_0159]Disposal Request의 정보를 작업 합니다. <br>
	 *
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @return InterfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO sendGeneralMailBasic(InterfaceGRPVO interfaceGRPVO) throws EventException;

	/**
	 * [EES_MNR_0157]Html Template 메일 전송 작업 작업 합니다. <br>
	 *
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @return InterfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO sendHtmlMailBasic(InterfaceGRPVO interfaceGRPVO) throws EventException;

	/**
	 * [EES_MNR_0161]Scrapping/Donation Creation의 정보를 조회 합니다. <br>
	 *
	 * @param String eqNo
	 * @return String
	 * @exception EventException
	 */
	public String searchFAEqNoBasic(String eqNo) throws EventException;

	/**
	 * [EES_MNR_0041]M&R Invoice Creation & Correction의 정보를 작업 합니다. <br>
	 *
	 * @param String mnrGrpTpCd
	 * @param String refNum
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String createCSRIFBasic(String mnrGrpTpCd, String refNum, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0041]M&R Invoice Creation & Correction의 정보를 삭제 합니다. <br>
	 *
	 * @param String refNum
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeCSRIFBasic(String refNum, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_0161]Invoice 목록을 조회합니다. <br>
	 *
	 * @param ReceivableInvoiceGRPVO receivableInvoiceGRPVO
	 * @param SignOnUserAccount account
	 * @return ReceivableInvoiceGRPVO
	 * @exception EventException
	 */
	public ReceivableInvoiceGRPVO searchInvArIfListBasic(ReceivableInvoiceGRPVO receivableInvoiceGRPVO, SignOnUserAccount account) throws EventException;

	/**
	 * [EES_MNR_QEXE] 에러난 EDI FLAG SS처리  <br>
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @return InterfaceGRPVO interfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO reSendErrorEDIBasic(InterfaceGRPVO interfaceGRPVO) throws EventException;

	/**
	 * [EES_MNR_QEXE] 에러난 EDI 재전송할 목록 조회 <br>
	 *
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @return InterfaceGRPVO
	 * @exception EventException
	 */
	public InterfaceGRPVO searchReSendErrorEDIListBasic(InterfaceGRPVO interfaceGRPVO) throws EventException;

	/**
	 * [EES_MNR_0243] Estimate Upload 자료에서 EQ_NO를 검증 <br>
	 *
	 * @param EstimateUploadVO[] estimateUploadVOs
	 * @return List<EstimateUploadVO>
	 * @exception EventException
	 */
	public List<EstimateUploadVO> searchEqTypeByEqNoBasic(EstimateUploadVO[] estimateUploadVOs) throws EventException;

	/**
	 * Estimate Upload 자료를 가공합니다. <br>
	 *
	 * @param EstimateUploadVO[] estimateUploadVOs
	 * @param SignOnUserAccount userAccount
	 * @param String reqUi
	 * @return EstimateUploadGRPVO
	 * @exception EventException
	 */
	public EstimateUploadGRPVO createEstimateUploadBasic(EstimateUploadVO[] estimateUploadVOs, SignOnUserAccount userAccount, String reqUi) throws EventException;

	/**
	 * Estimate Upload 처리된 결과를 조회합니다. <br>
	 *
	 * @param EstimateUploadGRPVO estimateUploadGRPVO
	 * @return List<EstimateUploadVO>
	 * @exception EventException
	 */
	public List<EstimateUploadVO> searchEstimateUploadResultBasic(EstimateUploadGRPVO estimateUploadGRPVO) throws EventException;
	
	/**
	 * [EES_MNR_0243] Estimate Upload 자료에서 Calculation 처리를 위한 eq type, tpsz 조회 <br>
	 *
	 * @param CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO
	 * @return CustomMnrRprRqstHdrVO
	 * @exception EventException
	 */
	public CustomMnrRprRqstHdrVO searchEqTypeNTpSzByEqNoBasic(CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO) throws EventException;	
	
	/**
	 * [EES_MNR_0243] Estimate Upload 자료에서 Calculation 처리를 위한 AGMT 정보 조회 <br>
	 *
	 * @param CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO
	 * @return CustomMnrRprRqstHdrVO
	 * @exception EventException
	 */	
	public CustomMnrRprRqstHdrVO searchTempEstimateAGMTBasic(CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO) throws EventException;
	
	/**
	 * [EES_MNR_0019]zip 파일 및 개별 image 파일들의 Thumbnail 이미지 정보를 저장합니다. <br>
	 *
	 * @param String seqValue
	 * @param String[] filePathNm
	 * @param InterfaceGRPVO interfaceGRPVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createFileUploadThumbnail(String seqValue, String[] filePathNm, InterfaceGRPVO interfaceGRPVO, SignOnUserAccount account) throws EventException;
	
}