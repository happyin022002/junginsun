/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TimeCharterInOutAccountingSC.java
*@FileTitle : Contract
*Open Issues :
*Change history :
*@LastModifyDate : 2009.03.25
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.03.25 정윤태
* 1.0 Creation
* --------------------------------------------------------------
* History
* 2011.01.19 이준범 [CHM-201108373-01] Revenuse VVD Creation 관련
* 작업내용 : 1) ERP Target VVD 선정 I/F 시 FMS에 임의로 생성된 VVD 삭제
*          2) manageRevenueVvd() 파라미터 추가 String finalizingFlg
* 2011.02.14 이병훈 [CHM-201108730-01] FMS  Bunker 생성 및 수정 시에 계약 BOD/BOR 날짜 수정 보완
* 2011.05.18 Ticket ID : [CHM-201110910-01] 
* 개발자 : 이준범
* 제목 : Bunker Data Management 화면의 BUNKER 관련 Data가 계약에 변경되게 처리 요청
* 내용 : Live 에서만 오류 발생하여, 기존 유지보수[CHM-201108730-01] 시 변경된 파일 재 적용 ( 설계자 의견 )
=========================================================*/ 

package com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.basic.ExternalFinderBC;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.basic.ExternalFinderBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.arapproval.basic.ArApprovalBC;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.arapproval.basic.ArApprovalBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.basic.TCharterIOBasicRegisterBC;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.basic.TCharterIOBasicRegisterBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0003Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0004Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0005Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0006Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0037Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0038Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0068Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0069Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0070Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0076Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.event.EsmFms0085Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomAcctCateVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomAcctItmVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomOwnerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.CustomVvdVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.ReceiveRevenuePortVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchAccountItemListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchEmailAddressListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchFinalRevenueVvdListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchFinanVvdListByChaterSdmsVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchOwnerNameListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchRevenuePortListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchRevenueVvdInquiryListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchRevenueVvdListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchVendorCustomerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobasicregister.vo.SearchVvdCreationListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.basic.TCharterIOBunkerRegisterBC;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.basic.TCharterIOBunkerRegisterBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.event.EsmFms0027Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.event.EsmFms0050Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.event.EsmFms0051Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.ContractByBunkerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.CustomBunkerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchBunkerInterfaceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchBunkerListByPaymentSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchBunkerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchIdVslCdByBunkerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo.SearchVvdByBunkerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.basic.TCharterIOConsultationBC;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.basic.TCharterIOConsultationBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0021Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0032Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms00331Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0033Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms00401Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0040Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0041Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0042Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0043Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0044Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0045Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0052Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0053Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0086Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0088Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFms0093Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.event.EsmFmsFNS012R002Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomConsultationVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomInterfaceStatusVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamConsultationVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomPamCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchArSlipDetailListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchBrokerageListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchCustomerCodeVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchInterfaceStatusDetailListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchInterfaceStatusListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchInvoiceNoListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchManualSlipListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchPaymentSlipListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchReverseCsrForSubletListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchReverseCsrForSubletSaveListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipApprovalListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipCorrectionDetailListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipCorrectionListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSlipDetailListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSubletRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSubletRevenueSlipListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchSubletReveuneDetailListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchTaxDetailEvidenceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchTaxMasterEvidenceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.SearchVvdListByManualSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.basic.TCharterIOContractBC;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.basic.TCharterIOContractBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.event.EsmFms0001Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.event.EsmFms0002Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.event.EsmFms0023Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.ContractContainerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.FileCountVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchCharterPtyFileListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContracNoListByVesselVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractByCharterVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractByInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractByPrepaymentVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractListByPrepaymentHireNoVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractTypeCodeVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractTypeListByContractVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchContractVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchFileCertificationListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchHireListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchHireSysDateVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchIdVslListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchOtrExpnListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchOtrExpnSysDateListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchOwnerNameVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.SearchPayTermListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.TCharterIOContractVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.basic.TCharterIOEstimatedBC;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.basic.TCharterIOEstimatedBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.event.EsmFms0046Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.event.EsmFms0048Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.event.EsmFms0049Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.CustomEstmIfVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedHireResultListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedProRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioestimated.vo.SearchEstimatedRevenueListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.basic.TCharterIOInvoiceBC;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.basic.TCharterIOInvoiceBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0007Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0012Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0014Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0016Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0017Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0018Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0024Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0025Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0026Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0028Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0034Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0071Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0072Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0073Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0075Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0078Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0079Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0087Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0090Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0091Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0097Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0098Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFmsESM0660001Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFmsFNS0560001Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFmsVMS0010001Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFmsVMS0020001Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CondSearchOffhireInvoiceVmsVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomInvDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffInvDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomOffhExpnVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomPreInvDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomPreInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomSdmsSettlementVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.CustomSendEmailVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.InvoiceContainerVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchBunkerPriceInterfaceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalOffhireInvoiceListSumVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalOffhireInvoiceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalPrepaymentInvoiceListSumVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCalPrepaymentInvoiceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCharterInvoiceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCharterInvoiceSumVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchCharterListByPaymentSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchChaterInvoiceSdmsListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchInvoiceListByRevenueSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchManhourItemListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchManhourItemRegistrationListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchManhourListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireExpensesListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireInvoiceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireInvoiceVmsListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireListByPaymentSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOffhireSelectionListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchNewOwnerAccountListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOwnerInvoiceAutoMatchListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOwnerInvoiceListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchOwnerListByPaymentSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchPrepaymentHireNoListSumVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchPrepaymentHireNoListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchPrepaymentInvoiceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchPrepaymentListByPaymentSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchVesselCodeInvoiceInterfaceVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchVvdListByCharterVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.SearchVvdListByOffHireVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.FrgnExchangeTransactionVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.basic.TCharterIOSettlementBC;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.basic.TCharterIOSettlementBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.event.EsmFms0035Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.event.EsmFms0039Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.event.EsmFms0074Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.event.EsmFms0094Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.CondSearchPrepaymentSettleListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.CondSearchPrepaymentSettleVvdVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchInvoiceByOwnerAccountSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchInvoiceByPaymentSlipVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchMultiPrepaymentSettlementInquiryListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchOwnerAccountExpenseListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchPrepaymentSettleListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchPrepaymentSettleVvdAmountByAccountListVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchPrepaymentSettleVvdAmountVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriosettlement.vo.SearchPrepaymentSettleVvdListVO;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.basic.StevedoreDamageMgtBC;
import com.hanjin.apps.alps.vop.opf.stevedoredamagemgt.stevedoredamagemgt.basic.StevedoreDamageMgtBCImpl;
import com.hanjin.bizcommon.approval.vo.ApprovalCsrVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.IfCsrListInputVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComApCsrHisVO;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.code.CodeInfo;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.irep.vms.VMS0010001Document;
import com.hanjin.irep.vms.VMS0010001Document.VMS0010001;
import com.hanjin.irep.vms.VMS0020001Document;
import com.hanjin.irep.vms.VMS0020001Document.VMS0020001;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.event.EsmFms0099Event;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo.OwnerAccountByPaymentSlipVO;

/**
 * ALPS-TimeCharterInOutAccounting Business Logic ServiceCommand - ALPS-TimeCharterInOutAccounting 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Yoon-Tae, Jung
 * @see ITCharterIOContractDBDAO, TCharterIOBunkerRegisterDBDAO, TCharterIOBasicRegisterDBDAO
 * @since J2EE 1.5
 */

public class TimeCharterInOutAccountingSC extends ServiceCommandSupport {
	// Login User Information 
	private SignOnUserAccount account = null;

	/**
	 * TimeCharterInOutAccounting system 업무 시나리오 선행작업<br>
	 * Contract 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
		}
	}

	/**
	 * TimeCharterInOutAccounting system 업무 시나리오 마감작업<br>
	 * Contract 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("TimeCharterInOutAccountingSC 종료");
	}

	/**
	 * ALPS-TimeCharterInOutAccounting system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분(Event 단위로 구분함)
		if(e.getEventName().equalsIgnoreCase("EsmFms0001Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchContract(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchContractByPrepayment(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchContractByOffHire(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchOwnerName(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchStandardCodeListByContract();
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchContractByCharter(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchContractListByPrepaymentHireNo(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = createContract(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageContract(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageGW(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeContract(e);
			}
			
	
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0002Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAgreement(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0003Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAccountCateList();
			    
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = manageAccountCate (e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0004Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVendorCodeList();
			    
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = manageVendorCode(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0005Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustomerCodeList();
			    
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = manageCustomerCode(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0006Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOwnerList();
			    
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
			    eventResponse = searchOwnerTypeCodeList();
			
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
			    eventResponse = searchStandardCodeList(e);
			    
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = manageOwner(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0007Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchManhourList(e);
			    
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = manageManhourList(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0012Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCalPrepaymentInvoiceList(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPrepaymentInvoiceList(e);
			
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchHireNo(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = creatPrepaymentInvoice(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = managePrepaymentInvoice(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removePrepaymentInvoice(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0014Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCalOffhireInvoiceList(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOffhireInvoiceList(e);
			    
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchVvdListByOffHire(e);
			    
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageOffhireInvoice(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeOffhireInvoice(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0016Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCharterInvoiceList(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVvdListByCharter(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCharterInvoice(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0017Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChaterInvoiceSdmsList(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkSdmsInvoiceNo(e);
				
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0018Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchOwnerInvoiceList(e);
			    
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
			    eventResponse = searchOwnerInvoiceAutoMatchList(e);
			    
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = modifyOwnerInvoice(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0021Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchContracNoListByVessel(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkCenterCode(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkVvdCode(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePaymentSlip(e);
				
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0023Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchContracNoListByVessel(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchContractTypeListByContract(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0024Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPrepaymentListByPaymentSlip(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0025Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCharterListByPaymentSlip(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0026Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffhireListByPaymentSlip(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0027Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBunkerListByPaymentSlip(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0028Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOwnerListByPaymentSlip(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0032Event")) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSubletRevenueSlip(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCustomerCode(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0033Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchReverseCsrForSubletList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageReverseCsrForSublet(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms00331Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchInvoiceNoList(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0034Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPrepaymentListByRevenueSlip(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0035Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchInvoiceByPaymentSlip(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = managePrepaymentSettlement(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0094Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchPrepaymentSettleListAll(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
			    eventResponse = searchPrepaymentSettleVvdListMulti(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPrepaymentSettlementInquiryList(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0037Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchRevenueVvdList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
			    eventResponse = searchVvdCreationList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
			    eventResponse = searchFinalRevenueVvdList (e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
			    eventResponse = searchProcessRevenueVvdList (e);    
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = manageRevenueVvd(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0038Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchRevenueVvdInquiryList(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0039Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchOwnerAccountExpenseList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = manageOwnerAccountExpense(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
			    eventResponse = searchInvoiceByOwnerAccountSlip(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0040Event")) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageManualSlip(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms00401Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchBrokerageList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVvdListByManualSlip(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0041Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSlipInquiryList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCsrCancel(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0042Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSlipDetailList(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0043Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSlipCorrectionList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = modifySlipCorrection(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0044Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSlipCorrectionDetailList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = modifySlipDetailCorrection(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0045Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchSubletReveuneList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
			    eventResponse = searchSubletReveuneDetailList(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0046Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchEstimatedRevenueList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = createEstimatedRevenue(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0048Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchEstimatedProRevenueList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = createEstimatedProRevenue(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0049Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEstimatedHireResultList(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0050Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBunkerList(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchIdVslCdListByBunker(e);	
			
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchVvdListByBunker(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = checkLocCdByBunker(e);
			
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchContractTypeCode(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchStandardCodeListByBunker();
				
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBunker(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0051Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBunkerInterfaceList(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = sendBunkerData(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0052Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSlipSubmitToGWList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = manageSlipApproval(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0053Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchInterfaceStatusList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
			    eventResponse = searchInterfaceStatusDetailList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = manageInterfaceStatus(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0093Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSlipApprovalList(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0068Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRevenuePortList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = receiveRevenuePort(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRevenuePort(e);
			} else if(e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeAllRevenuePort(e);
			}
		
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0069Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAccountItemDetailList();
			    
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
			    eventResponse = checkAccountCode(e);
			    
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = manageAccountItemName(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0070Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVendorCustomerList(e);
			    
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchVendorCustomerName(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0071Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBunkerPriceInterfaceList(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0072Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchManhourItemRegistrationList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = manageManhourItemRegistration(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0073Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffhireInvoiceVmsList(e);
			    
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyOffhireInvoiceVms(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0074Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchPrepaymentSettleList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
			    eventResponse = searchPrepaymentSettleVvdList(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0075Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searhAttachFileKey(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0076Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAccountItemList(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkCurrencyCode(e);
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchFinanVvdListByChaterSdms(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0078Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffhireSelectionList(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0079Event")) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = sendEmail(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0081Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchManhourItemList();
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0083Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOwnerNameList();
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0084Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchEmailAddressList(e);
			} 
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0085Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchEmailAddressList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = manageEmailAddress(e);
			} 
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0086Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchTaxEvidence(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFmsVMS0010001Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselCodeHireInterface(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFmsVMS0020001Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVesselCodeInvoiceInterface(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFmsFNS012R002Event")) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				receiveSlipApprovalToAR(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFmsFNS0560001Event")) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    manageOwnerAccountInterface(e);
			}
			
		} else if(e.getEventName().equalsIgnoreCase("EsmFmsESM0660001Event")) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				manageOffHireExpenseInterface(e);
			}
		
			// add : 2012.06.21. Jean Sange Wha											 
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0087Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchGlInquiryOwnerInvoiceList(e);
			    
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
			    eventResponse = searchOwnerInvoiceAutoMatchList(e);
			    
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
			    eventResponse = modifyOwnerInvoice(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
			    eventResponse = modifySettleDate(e);
			}
		// AR-GW결재 2014.12 민정호	
		} else if (e.getEventName().equalsIgnoreCase("EsmFms0088Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI10)) {	//GW URL open
				eventResponse = manageApplication(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {  //GW Result
				eventResponse = manageGwStatus(e);	
			}			
		// Off-Hire Expenses 개선 2015.02.15
		} else if (e.getEventName().equalsIgnoreCase("EsmFms0090Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {	
				eventResponse = searchOffhireExpensesList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {	
				eventResponse = searchOffhireCompletedList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {		// 저장	
				eventResponse = manageOffhireExpenses(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {			// btn_ToNonConfirm1	
				eventResponse = modifyVnorItm(e,"N");
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {			// btn_Cnfm
				eventResponse = modifyVnorItm(e,"C");				
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {			// btn_Complete
				eventResponse = modifyVnorItm(e,"P");				
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {			// btn_ToNonConfirm3
				eventResponse = modifyVnorItm(e,"N");				
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {			// btn_ToConfirm
				eventResponse = modifyVnorItm(e,"C");				
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {
				eventResponse = modifyAuditComment(e);
			}
		// Off-Hire Expenses Detail 개선 2015.02.23	
		} else if (e.getEventName().equalsIgnoreCase("EsmFms0091Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCalOffhireInvoiceList2(e);				
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOffhireInvoiceList2(e);			    
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchVvdListByOffHire2(e);			    
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageOffhireInvoice2(e);				
			}else if(e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeOffhireInvoice2(e);				
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {	
				eventResponse = searchContracNoListByVessel2(e);
			}							
		} else if (e.getEventName().equalsIgnoreCase("EsmFms0097Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNewOwnerAccountList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageNewOwnerAccount(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = checkVvdInFmsCntrct(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmFms0098Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFrgmExchangeTransaction(e);				
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageFrgmExchangeTransaction(e);				
			}
		} else if(e.getEventName().equalsIgnoreCase("EsmFms0099Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOwnerAccountListByPaymentSlip(e);
			}			
	  }	
		return eventResponse;
	}
	
	/**
	 * 선급금 계약 조회<br>
	 * Prepayment 화면에서 CtrtNo에 해당하는 Contract Type/Owner Code/Owner Name/Duration/Hire Information/Other(s) Lump sum information 가져오기<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContractByPrepayment(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0001Event event = (EsmFms0001Event)e;
		
		TCharterIOContractBC command = new TCharterIOContractBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			ContractContainerVO contractContainerVO = command.searchContractByPrepayment(event.getFletCtrtNo());
			
			SearchContractByPrepaymentVO searchContractByPrepaymentVO = contractContainerVO.getSearchContractByPrepaymentVO();
			SearchHireSysDateVO searchHireSysDateVO = contractContainerVO.getSearchHireSysDateVO();
			List<SearchOtrExpnSysDateListVO> searchOtrExpnSysDateListVOs = contractContainerVO.getSearchOtrExpnSysDateListVOs();

			Map<String,String> etcData = new HashMap<String,String>();
			
			//********************** CONTRACT 테이블의 정보 가져오기(START) **********************//
			
			if(searchContractByPrepaymentVO != null) {
				eventResponse.setETCData("fletCtrtNo",searchContractByPrepaymentVO.getFletCtrtNo());
				eventResponse.setETCData("vslCd",searchContractByPrepaymentVO.getVslCd());
				eventResponse.setETCData("vslEngNm",searchContractByPrepaymentVO.getVslEngNm());
				eventResponse.setETCData("fletCtrtTpCd",searchContractByPrepaymentVO.getFletCtrtTpCd());
				eventResponse.setETCData("custCntCd",searchContractByPrepaymentVO.getCustCntCd());
				eventResponse.setETCData("custSeq",searchContractByPrepaymentVO.getCustSeq());
				eventResponse.setETCData("vndrLglEngNm",searchContractByPrepaymentVO.getVndrLglEngNm());
				eventResponse.setETCData("ownrNm",searchContractByPrepaymentVO.getOwnrNm());
				eventResponse.setETCData("effDt",searchContractByPrepaymentVO.getEffDt());
				eventResponse.setETCData("fromTime",searchContractByPrepaymentVO.getFromTime());
				eventResponse.setETCData("expDt",searchContractByPrepaymentVO.getExpDt());
				eventResponse.setETCData("toTime",searchContractByPrepaymentVO.getToTime());
				eventResponse.setETCData("invUsdDys",searchContractByPrepaymentVO.getInvUsdDys());
				eventResponse.setETCData("acmmRtAmt",searchContractByPrepaymentVO.getAcmmRtAmt());
				eventResponse.setETCData("fletBrogRtAmt",searchContractByPrepaymentVO.getFletBrogRtAmt());
				eventResponse.setETCData("acmmFlg",searchContractByPrepaymentVO.getAcmmFlg());
				eventResponse.setETCData("brogFlg",searchContractByPrepaymentVO.getBrogFlg());
				eventResponse.setETCData("invSeq",searchContractByPrepaymentVO.getInvSeq());
				eventResponse.setETCData("payHirNo",searchContractByPrepaymentVO.getPayHirNo());
			}

			//*********************** CONTRACT 테이블의 정보 가져오기(END) ************************//
			
			//************* Hire 테이블의 최신 정보 가져오기 [Hire Information] (START) ************//
			
			if(searchHireSysDateVO != null) {
				eventResponse.setETCData("hirEffDt",searchHireSysDateVO.getEffDt());
				eventResponse.setETCData("hirEffDtTime",searchHireSysDateVO.getEffDtTime()); 
				eventResponse.setETCData("hirExpDt",searchHireSysDateVO.getExpDt());
				eventResponse.setETCData("hirExpDtTime",searchHireSysDateVO.getExpDtTime()); 
				eventResponse.setETCData("hirHirCurrN1stCd",searchHireSysDateVO.getHirCurrN1stCd());
				eventResponse.setETCData("hirHirRtN1stAmt",searchHireSysDateVO.getHirRtN1stAmt());
				eventResponse.setETCData("hirHirCurrN2ndCd",searchHireSysDateVO.getHirCurrN2ndCd());
				eventResponse.setETCData("hirHirRtN2ndAmt",searchHireSysDateVO.getHirRtN2ndAmt());
			} else {
				eventResponse.setETCData("hirEffDt","");
				eventResponse.setETCData("hirEffDtTime",""); 
				eventResponse.setETCData("hirExpDt","");
				eventResponse.setETCData("hirExpDtTime",""); 
				eventResponse.setETCData("hirHirCurrN1stCd","");
				eventResponse.setETCData("hirHirRtN1stAmt","");
				eventResponse.setETCData("hirHirCurrN2ndCd","");
				eventResponse.setETCData("hirHirRtN2ndAmt","");
			}
			
			
			//************* Hire 테이블의 최신 정보 가져오기 [Hire Information] (END) **************//
			
			eventResponse.setETCData(etcData);

			eventResponse.setRsVoList(searchOtrExpnSysDateListVOs);
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Prepayment 화면에서 CtrtNo에 해당하는 Hire No/Contract Type 가져오기<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContractListByPrepaymentHireNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0001Event event = (EsmFms0001Event)e;
		
		TCharterIOContractBC command = new TCharterIOContractBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<SearchContractListByPrepaymentHireNoVO> searchContractListByPrepaymentHireNoVOs = command.searchContractListByPrepaymentHireNo(event.getFletCtrtNo());
			
			StringBuilder sb = new StringBuilder();
			
			String fletCtrtTpCd = "";
			
			if(searchContractListByPrepaymentHireNoVOs.size() > 0) {
				for(int i=0; i<searchContractListByPrepaymentHireNoVOs.size(); i++) {
					sb.append(searchContractListByPrepaymentHireNoVOs.get(i).getPpayHirNo()+"|");
				}
				
				fletCtrtTpCd = searchContractListByPrepaymentHireNoVOs.get(0).getFletCtrtTpCd();
			}
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("payHirNo",sb.toString());
			etcData.put("fletCtrtTpCd",fletCtrtTpCd);
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Off-Hire 계약조회<br>
	 * Off-Hire Expenses 화면에서 CtrtNo에 해당하는 Contract Type/Owner Code/Owner Name/Hire Information/Other(s) Lump sum information 가져오기<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContractByOffHire(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0001Event event = (EsmFms0001Event)e;
		
		TCharterIOContractBC command = new TCharterIOContractBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			ContractContainerVO contractContainerVO = command.searchContractByOffHire(event.getFletCtrtNo());
			
			SearchContractByInvoiceVO searchContractByInvoiceVO = contractContainerVO.getSearchContractByInvoiceVO();
			SearchHireSysDateVO searchHireSysDateVO = contractContainerVO.getSearchHireSysDateVO();
			List<SearchOtrExpnSysDateListVO> searchOtrExpnSysDateListVOs = contractContainerVO.getSearchOtrExpnSysDateListVOs();

			Map<String,String> etcData = new HashMap<String,String>();
			
			//********************** CONTRACT 테이블의 정보 가져오기(START) **********************//
			
			eventResponse.setETCData("fletCtrtNo",searchContractByInvoiceVO.getFletCtrtNo());
			eventResponse.setETCData("vslCd",searchContractByInvoiceVO.getVslCd());
			eventResponse.setETCData("vslEngNm",searchContractByInvoiceVO.getVslEngNm());
			eventResponse.setETCData("fletCtrtTpCd",searchContractByInvoiceVO.getFletCtrtTpCd());
			eventResponse.setETCData("custCntCd",searchContractByInvoiceVO.getCustCntCd());
			eventResponse.setETCData("custSeq",searchContractByInvoiceVO.getCustSeq());
			eventResponse.setETCData("vndrLglEngNm",searchContractByInvoiceVO.getVndrLglEngNm());
			eventResponse.setETCData("ownrNm",searchContractByInvoiceVO.getOwnrNm());
			eventResponse.setETCData("acmmRtAmt",searchContractByInvoiceVO.getAcmmRtAmt());
			eventResponse.setETCData("fletBrogRtAmt",searchContractByInvoiceVO.getFletBrogRtAmt());
			eventResponse.setETCData("acmmFlg",searchContractByInvoiceVO.getAcmmFlg());
			eventResponse.setETCData("brogFlg",searchContractByInvoiceVO.getBrogFlg());

			//*********************** CONTRACT 테이블의 정보 가져오기(END) ************************//
			
			//************* Hire 테이블의 최신 정보 가져오기 [Hire Information] (START) ************//
			
			if(searchHireSysDateVO != null) {
				eventResponse.setETCData("effDt",searchHireSysDateVO.getEffDt());
				eventResponse.setETCData("effDtTime",searchHireSysDateVO.getEffDtTime()); 
				eventResponse.setETCData("expDt",searchHireSysDateVO.getExpDt());
				eventResponse.setETCData("expDtTime",searchHireSysDateVO.getExpDtTime()); 
				eventResponse.setETCData("hirCurrN1stCd",searchHireSysDateVO.getHirCurrN1stCd());
				eventResponse.setETCData("hirRtN1stAmt",searchHireSysDateVO.getHirRtN1stAmt().trim());
				eventResponse.setETCData("hirCurrN2ndCd",searchHireSysDateVO.getHirCurrN2ndCd());
				eventResponse.setETCData("hirRtN2ndAmt",searchHireSysDateVO.getHirRtN2ndAmt().trim());
			} else {
				eventResponse.setETCData("effDt","");
				eventResponse.setETCData("effDtTime",""); 
				eventResponse.setETCData("expDt","");
				eventResponse.setETCData("expDtTime",""); 
				eventResponse.setETCData("hirCurrN1stCd","");
				eventResponse.setETCData("hirRtN1stAmt","");
				eventResponse.setETCData("hirCurrN2ndCd","");
				eventResponse.setETCData("hirRtN2ndAmt","");
			}
			
			//************* Hire 테이블의 최신 정보 가져오기 [Hire Information] (END) **************//
			
			eventResponse.setETCData(etcData);

			eventResponse.setRsVoList(searchOtrExpnSysDateListVOs);
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * 계약조회<br>
	 * Agreement Inquiry 화면에서 사선/용선/대선 계약정보 조회(SEARCH)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgreement(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0002Event event = (EsmFms0002Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TCharterIOContractBC command = new TCharterIOContractBCImpl();
		
		try{
			ContractContainerVO contractContainerVO = command.searchAgreement(event.getFletCtrtNo());
			
			SearchContractVO searchContractVO = contractContainerVO.getSearchContractVO();
			List<SearchHireListVO> searchHireListVOs= contractContainerVO.getSearchHireListVOs();
			List<SearchOtrExpnListVO> searchOtrExpnListVOs = contractContainerVO.getSearchOtrExpnListVOs();
			List<SearchPayTermListVO> searchPayTermListVOs = contractContainerVO.getSearchPayTermListVOs();
			List<SearchCharterPtyFileListVO> searchCharterPtyFileListVOs = contractContainerVO.getSearchCharterPtyFileListVOs();
			List<SearchFileCertificationListVO> searchFileCertificationListVOs = contractContainerVO.getSearchFileCertificationListVOs();
			List<SearchIdVslListVO> searchIdVslListVOs = contractContainerVO.getSearchIdVslListVOs();
			SearchHireSysDateVO searchHireSysDateVO = contractContainerVO.getSearchHireSysDateVO();
			List<SearchOtrExpnSysDateListVO> searchOtrExpnSysDateListVOs = contractContainerVO.getSearchOtrExpnSysDateListVOs();

			Map<String,String> etcData = new HashMap<String,String>();
			
			//********************** CONTRACT 테이블의 정보 가져오기(START) **********************//
			
			eventResponse.setETCData("fletCtrtNo",searchContractVO.getFletCtrtNo());
			eventResponse.setETCData("vslCd",searchContractVO.getVslCd());
			eventResponse.setETCData("vslEngNm",searchContractVO.getVslEngNm());
			eventResponse.setETCData("fletCtrtTpCd",searchContractVO.getFletCtrtTpCd());
			eventResponse.setETCData("fletCtrtFactCd",searchContractVO.getFletCtrtFactCd());
			eventResponse.setETCData("cpDt",searchContractVO.getCpDt());
			eventResponse.setETCData("oriEffDt",searchContractVO.getEffDt()); 
			eventResponse.setETCData("fromTime",searchContractVO.getFromTime());
			eventResponse.setETCData("oriExpDt",searchContractVO.getExpDt());
			eventResponse.setETCData("toTime",searchContractVO.getToTime());
			eventResponse.setETCData("declFlg",searchContractVO.getDeclFlg());
			eventResponse.setETCData("vndrSeq",searchContractVO.getVndrSeq());
			eventResponse.setETCData("custCntCd",searchContractVO.getCustCntCd());
			eventResponse.setETCData("custSeq",searchContractVO.getCustSeq());
			eventResponse.setETCData("vndrLglEngNm",searchContractVO.getVndrLglEngNm());
			eventResponse.setETCData("ownrNm",searchContractVO.getOwnrNm());
			eventResponse.setETCData("acmmRtAmt",searchContractVO.getAcmmRtAmt());
			eventResponse.setETCData("fletOlayCommRtAmt",searchContractVO.getFletOlayCommRtAmt());
			eventResponse.setETCData("vslCntCd",searchContractVO.getVslCntCd());
			eventResponse.setETCData("cntNm",searchContractVO.getCntNm());
			eventResponse.setETCData("fletBrogRtAmt",searchContractVO.getFletBrogRtAmt());
			eventResponse.setETCData("oaRsvCurrCd",searchContractVO.getOaRsvCurrCd());
			eventResponse.setETCData("oaRsvAmt",searchContractVO.getOaRsvAmt());
			eventResponse.setETCData("actFoilBodQty",searchContractVO.getActFoilBodQty());
			eventResponse.setETCData("actDoilBodQty",searchContractVO.getActDoilBodQty());
			eventResponse.setETCData("foilBodOutPrc",searchContractVO.getFoilBodOutPrc());
			eventResponse.setETCData("doilBodOutPrc",searchContractVO.getDoilBodOutPrc());
			eventResponse.setETCData("actFoilBorQty",searchContractVO.getActFoilBorQty());
			eventResponse.setETCData("actDoilBorQty",searchContractVO.getActDoilBorQty());
			eventResponse.setETCData("foilBorOutPrc",searchContractVO.getFoilBorOutPrc());
			eventResponse.setETCData("doilBorOutPrc",searchContractVO.getDoilBorOutPrc());
			eventResponse.setETCData("vslBldDt",searchContractVO.getVslBldDt());
			eventResponse.setETCData("shpSpdQty",searchContractVO.getShpSpdQty());
			eventResponse.setETCData("vslDzndCapa",searchContractVO.getVslDzndCapa());
			eventResponse.setETCData("bse14tonVslCapa",searchContractVO.getBse14tonVslCapa());
			eventResponse.setETCData("rfCntrPlgQty",searchContractVO.getRfCntrPlgQty());
			eventResponse.setETCData("ddwtCgoCapaQty",searchContractVO.getDdwtCgoCapaQty());
			eventResponse.setETCData("grsWgt",searchContractVO.getGrsWgt());
			eventResponse.setETCData("nrtWgt",searchContractVO.getNrtWgt());
			eventResponse.setETCData("grFlg",searchContractVO.getGrFlg());
			eventResponse.setETCData("fletGmtLmtCd",searchContractVO.getFletGmtLmtCd());
			eventResponse.setETCData("bodPortCd",searchContractVO.getBodPortCd());
			eventResponse.setETCData("borPortCd",searchContractVO.getBorPortCd());
			//Fuel type 다양화
			eventResponse.setETCData("actLowSulpFoilBodQty",searchContractVO.getActLowSulpFoilBodQty());
			eventResponse.setETCData("actLowSulpGasOilBodQty",searchContractVO.getActLowSulpGasOilBodQty());
			eventResponse.setETCData("actLowSulpFoilBorQty",searchContractVO.getActLowSulpFoilBorQty());
			eventResponse.setETCData("actLowSulpGasOilBorQty",searchContractVO.getActLowSulpGasOilBorQty());
			eventResponse.setETCData("lowSulpFoilBodOutPrc",searchContractVO.getLowSulpFoilBodOutPrc());
			eventResponse.setETCData("lowSulpGasOilBodOutPrc",searchContractVO.getLowSulpGasOilBodOutPrc());
			eventResponse.setETCData("lowSulpFoilBorOutPrc",searchContractVO.getLowSulpFoilBorOutPrc());
			eventResponse.setETCData("lowSulpGasOilBorOutPrc",searchContractVO.getLowSulpGasOilBorOutPrc());

			//*********************** CONTRACT 테이블의 정보 가져오기(END) ************************//
			
			//************* Hire 테이블의 최신 정보 가져오기 [Hire Information] (START) ************//
			
			if(searchHireSysDateVO != null) {
				eventResponse.setETCData("effDt",searchHireSysDateVO.getEffDt());
				eventResponse.setETCData("effDtTime",searchHireSysDateVO.getEffDtTime()); 
				eventResponse.setETCData("expDt",searchHireSysDateVO.getExpDt());
				eventResponse.setETCData("expDtTime",searchHireSysDateVO.getExpDtTime()); 
				eventResponse.setETCData("hirCurrN1stCd",searchHireSysDateVO.getHirCurrN1stCd());
				eventResponse.setETCData("hirRtN1stAmt",searchHireSysDateVO.getHirRtN1stAmt());
				eventResponse.setETCData("hirCurrN2ndCd",searchHireSysDateVO.getHirCurrN2ndCd());
				eventResponse.setETCData("hirRtN2ndAmt",searchHireSysDateVO.getHirRtN2ndAmt());
			} else {
				eventResponse.setETCData("effDt","");
				eventResponse.setETCData("effDtTime",""); 
				eventResponse.setETCData("expDt","");
				eventResponse.setETCData("expDtTime",""); 
				eventResponse.setETCData("hirCurrN1stCd","");
				eventResponse.setETCData("hirRtN1stAmt","");
				eventResponse.setETCData("hirCurrN2ndCd","");
				eventResponse.setETCData("hirRtN2ndAmt","");
			}
			
			//************* Hire 테이블의 최신 정보 가져오기 [Hire Information] (END) **************//
			
			eventResponse.setETCData(etcData);

			eventResponse.setRsVoList(searchHireListVOs);
			eventResponse.setRsVoList(searchOtrExpnListVOs);
			eventResponse.setRsVoList(searchPayTermListVOs);
			eventResponse.setRsVo(searchContractVO);
			eventResponse.setRsVoList(searchCharterPtyFileListVOs);
			eventResponse.setRsVoList(searchFileCertificationListVOs);
			eventResponse.setRsVoList(searchIdVslListVOs);
			eventResponse.setRsVoList(searchOtrExpnSysDateListVOs);
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	
	/**
	 * 계약조회<br>
	 * 사선/용선/대선 계약정보 조회(SEARCH)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContract(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0001Event event = (EsmFms0001Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TCharterIOContractBC command = new TCharterIOContractBCImpl();
		
		try{
			ContractContainerVO contractContainerVO = command.searchContract(event.getFletCtrtNo());
			
			SearchContractVO searchContractVO = contractContainerVO.getSearchContractVO();
			List<SearchHireListVO> searchHireListVOs= contractContainerVO.getSearchHireListVOs();
			List<SearchOtrExpnListVO> searchOtrExpnListVOs = contractContainerVO.getSearchOtrExpnListVOs();
			List<SearchPayTermListVO> searchPayTermListVOs = contractContainerVO.getSearchPayTermListVOs();
			List<SearchCharterPtyFileListVO> searchCharterPtyFileListVOs = contractContainerVO.getSearchCharterPtyFileListVOs();
			List<SearchFileCertificationListVO> searchFileCertificationListVOs = contractContainerVO.getSearchFileCertificationListVOs();
			List<SearchIdVslListVO> searchIdVslListVOs = contractContainerVO.getSearchIdVslListVOs();
			SearchHireSysDateVO searchHireSysDateVO = contractContainerVO.getSearchHireSysDateVO();
			List<SearchOtrExpnSysDateListVO> searchOtrExpnSysDateListVOs = contractContainerVO.getSearchOtrExpnSysDateListVOs();

			Map<String,String> etcData = new HashMap<String,String>();
			
			//********************** CONTRACT 테이블의 정보 가져오기(START) **********************//
			
			eventResponse.setETCData("fletCtrtNo",searchContractVO.getFletCtrtNo());
			eventResponse.setETCData("vslCd",searchContractVO.getVslCd());
			eventResponse.setETCData("vslEngNm",searchContractVO.getVslEngNm());
			eventResponse.setETCData("fletCtrtTpCd",searchContractVO.getFletCtrtTpCd());
			eventResponse.setETCData("fletCtrtFactCd",searchContractVO.getFletCtrtFactCd());
			eventResponse.setETCData("cpDt",searchContractVO.getCpDt());
			eventResponse.setETCData("oriEffDt",searchContractVO.getEffDt()); 
			eventResponse.setETCData("fromTime",searchContractVO.getFromTime());
			eventResponse.setETCData("oriExpDt",searchContractVO.getExpDt());
			eventResponse.setETCData("toTime",searchContractVO.getToTime());
			eventResponse.setETCData("declFlg",searchContractVO.getDeclFlg());
			eventResponse.setETCData("vndrSeq",searchContractVO.getVndrSeq());
			eventResponse.setETCData("custCntCd",searchContractVO.getCustCntCd());
			eventResponse.setETCData("custSeq",searchContractVO.getCustSeq());
			eventResponse.setETCData("vndrLglEngNm",searchContractVO.getVndrLglEngNm());
			eventResponse.setETCData("ownrNm",searchContractVO.getOwnrNm());
			eventResponse.setETCData("acmmRtAmt",searchContractVO.getAcmmRtAmt());
			eventResponse.setETCData("fletOlayCommRtAmt",searchContractVO.getFletOlayCommRtAmt());
			eventResponse.setETCData("vslCntCd",searchContractVO.getVslCntCd());
			eventResponse.setETCData("cntNm",searchContractVO.getCntNm());
			eventResponse.setETCData("fletBrogRtAmt",searchContractVO.getFletBrogRtAmt());
			eventResponse.setETCData("oaRsvCurrCd",searchContractVO.getOaRsvCurrCd());
			eventResponse.setETCData("oaRsvAmt",searchContractVO.getOaRsvAmt());
			eventResponse.setETCData("actFoilBodQty",searchContractVO.getActFoilBodQty());
			eventResponse.setETCData("actDoilBodQty",searchContractVO.getActDoilBodQty());
			eventResponse.setETCData("foilBodOutPrc",searchContractVO.getFoilBodOutPrc());
			eventResponse.setETCData("doilBodOutPrc",searchContractVO.getDoilBodOutPrc());
			eventResponse.setETCData("actFoilBorQty",searchContractVO.getActFoilBorQty());
			eventResponse.setETCData("actDoilBorQty",searchContractVO.getActDoilBorQty());
			eventResponse.setETCData("foilBorOutPrc",searchContractVO.getFoilBorOutPrc());
			eventResponse.setETCData("doilBorOutPrc",searchContractVO.getDoilBorOutPrc());
			eventResponse.setETCData("vslBldDt",searchContractVO.getVslBldDt());
			eventResponse.setETCData("shpSpdQty",searchContractVO.getShpSpdQty());
			eventResponse.setETCData("vslDzndCapa",searchContractVO.getVslDzndCapa());
			eventResponse.setETCData("bse14tonVslCapa",searchContractVO.getBse14tonVslCapa());
			eventResponse.setETCData("rfCntrPlgQty",searchContractVO.getRfCntrPlgQty());
			eventResponse.setETCData("ddwtCgoCapaQty",searchContractVO.getDdwtCgoCapaQty());
			eventResponse.setETCData("grsWgt",searchContractVO.getGrsWgt());
			eventResponse.setETCData("nrtWgt",searchContractVO.getNrtWgt());
			eventResponse.setETCData("grFlg",searchContractVO.getGrFlg());
			eventResponse.setETCData("fletGmtLmtCd",searchContractVO.getFletGmtLmtCd());
			eventResponse.setETCData("bodPortCd",searchContractVO.getBodPortCd());
			eventResponse.setETCData("borPortCd",searchContractVO.getBorPortCd());
			//[FMS] 10만불 비용지급 결재건 관련 3차 - G/W 계약문서 연계 개발
			eventResponse.setETCData("agmtDocNo",searchContractVO.getAgmtDocNo());
			eventResponse.setETCData("agmtDocDesc",searchContractVO.getAgmtDocDesc());		
			//Fuel type 다양화
			eventResponse.setETCData("actLowSulpFoilBodQty",searchContractVO.getActLowSulpFoilBodQty());
			eventResponse.setETCData("actLowSulpGasOilBodQty",searchContractVO.getActLowSulpGasOilBodQty());
			eventResponse.setETCData("actLowSulpFoilBorQty",searchContractVO.getActLowSulpFoilBorQty());
			eventResponse.setETCData("actLowSulpGasOilBorQty",searchContractVO.getActLowSulpGasOilBorQty());
			eventResponse.setETCData("lowSulpFoilBodOutPrc",searchContractVO.getLowSulpFoilBodOutPrc());
			eventResponse.setETCData("lowSulpGasOilBodOutPrc",searchContractVO.getLowSulpGasOilBodOutPrc());
			eventResponse.setETCData("lowSulpFoilBorOutPrc",searchContractVO.getLowSulpFoilBorOutPrc());
			eventResponse.setETCData("lowSulpGasOilBorOutPrc",searchContractVO.getLowSulpGasOilBorOutPrc());


			//*********************** CONTRACT 테이블의 정보 가져오기(END) ************************//
			
			//************* Hire 테이블의 최신 정보 가져오기 [Hire Information] (START) ************//
			
			if(searchHireSysDateVO != null) {
				eventResponse.setETCData("effDt",searchHireSysDateVO.getEffDt());
				eventResponse.setETCData("effDtTime",searchHireSysDateVO.getEffDtTime()); 
				eventResponse.setETCData("expDt",searchHireSysDateVO.getExpDt());
				eventResponse.setETCData("expDtTime",searchHireSysDateVO.getExpDtTime()); 
				eventResponse.setETCData("hirCurrN1stCd",searchHireSysDateVO.getHirCurrN1stCd());
				eventResponse.setETCData("hirRtN1stAmt",searchHireSysDateVO.getHirRtN1stAmt());
				eventResponse.setETCData("hirCurrN2ndCd",searchHireSysDateVO.getHirCurrN2ndCd());
				eventResponse.setETCData("hirRtN2ndAmt",searchHireSysDateVO.getHirRtN2ndAmt());
			} else {
				eventResponse.setETCData("effDt","");
				eventResponse.setETCData("effDtTime",""); 
				eventResponse.setETCData("expDt","");
				eventResponse.setETCData("expDtTime",""); 
				eventResponse.setETCData("hirCurrN1stCd","");
				eventResponse.setETCData("hirRtN1stAmt","");
				eventResponse.setETCData("hirCurrN2ndCd","");
				eventResponse.setETCData("hirRtN2ndAmt","");
			}
			
			//************* Hire 테이블의 최신 정보 가져오기 [Hire Information] (END) **************//
			
			eventResponse.setETCData(etcData);

			eventResponse.setRsVoList(searchHireListVOs);
			eventResponse.setRsVoList(searchOtrExpnListVOs);
			eventResponse.setRsVoList(searchPayTermListVOs);
			eventResponse.setRsVo(searchContractVO);
			eventResponse.setRsVoList(searchCharterPtyFileListVOs);
			eventResponse.setRsVoList(searchFileCertificationListVOs);
			eventResponse.setRsVoList(searchIdVslListVOs);
			eventResponse.setRsVoList(searchOtrExpnSysDateListVOs);
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * 신규계약 생성<br>
	 * 사선/용선/대선 정보 저장(CREATION)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse createContract(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TCharterIOContractBC command = new TCharterIOContractBCImpl();
		
		EsmFms0001Event event = (EsmFms0001Event)e;
		
		//Agreement Creation(Contract)관련 통합 VO
		TCharterIOContractVO tCharterIOContractVO = (TCharterIOContractVO)event.getVO("voContract");
		
		List<String> keys = event.getKeys();
		String cefFileCnt = event.getCefFileCnt();
		String cpfFileCnt = event.getCpfFileCnt();
		
		try{	
			begin();
			FileCountVO fileCountVO = new FileCountVO();
			fileCountVO.setCefFileCnt(cefFileCnt);
			fileCountVO.setCpfFileCnt(cpfFileCnt);
			
			String fletCtrtNo = command.createContract(tCharterIOContractVO, keys, fileCountVO, account.getUsr_id());
			
			//생성된 계약번호
			event.setFletCtrtNo(fletCtrtNo);
			eventResponse = (GeneralEventResponse)searchContract(event);
			
			eventResponse.setETCData("fletCtrtNo", fletCtrtNo);
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
		
	}
	
	/**
	 * 계약정보 입력/수정/삭제<br>
	 * 사선/용선/대선 정보 저장(SAVE)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageContract(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TCharterIOContractBC command = new TCharterIOContractBCImpl();
		
		EsmFms0001Event event = (EsmFms0001Event)e;
		
		TCharterIOContractVO tCharterIOContractVO = (TCharterIOContractVO)event.getVO("voContract");
		
		List<String> keys = event.getKeys();
		String fletCtrtNo = event.getFletCtrtNo();
		String cefFileCnt = event.getCefFileCnt();
		String cpfFileCnt = event.getCpfFileCnt();
		
		try{	
			begin();
			FileCountVO fileCountVO = new FileCountVO();
			fileCountVO.setCefFileCnt(cefFileCnt);
			fileCountVO.setCpfFileCnt(cpfFileCnt);
			
			command.manageContract(tCharterIOContractVO, keys, fileCountVO, account.getUsr_id());
			
			event.setFletCtrtNo(fletCtrtNo);
			eventResponse = (GeneralEventResponse)searchContract(event);
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
		
	}

	/**
	 * G/W 문서 삭제(SAVE)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGW(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TCharterIOContractBC command = new TCharterIOContractBCImpl();
		
		EsmFms0001Event event = (EsmFms0001Event)e;
		
		String fletCtrtNo = event.getFletCtrtNo();
//		String agmtDocNo = event.getAgmtDocNo();
//		String agmtDocDesc = event.getAgmtDocDesc();
		
		try{	
			begin();			
			command.manageGW(fletCtrtNo, account.getUsr_id());		
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());			
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
		
	}
	
	
	/**
	 * 계약정보 전체삭제<br>
	 * 사선/용선/대선 정보 삭제(DELETE)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */	
	private EventResponse removeContract(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TCharterIOContractBC command = new TCharterIOContractBCImpl();
		
		EsmFms0001Event event = (EsmFms0001Event)e;
		
		try{	
			begin();

			command.removeContract(event.getFletCtrtNo());
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 계약 정보 조회(POPUP)<br>
	 * 계약화면에서 POPUP을 띄워 Vessel 정보를 조회 후 선택한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContracNoListByVessel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0023Event event = (EsmFms0023Event)e;
		
		TCharterIOContractBC command = new TCharterIOContractBCImpl();

		try{
			List<SearchContracNoListByVesselVO> searchContracNoListByVesselVO = command.searchContracNoListByVessel(event.getVslCd(), event.getFletCtrtTpCd(), event.getCtrtFlag());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse.setRsVoList(searchContracNoListByVesselVO);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 계약정보 POPUP<br>
	 * Account Item List 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAccountItemList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0076Event event = (EsmFms0076Event)e;
		
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();

		try{			
			String acctItemNm = event.getSearchAccountItemListVO().getAcctItmNm();						
			List<SearchAccountItemListVO> searchAccountItemListVO = command.searchAccountItemList(event.getFletAcctCateCd(), acctItemNm);
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse.setRsVoList(searchAccountItemListVO);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Bunker 화면에서 데이타 조회<br>
	 * Target Month / Vessel Code / 계약번호 입력 후 해당 조건에 해당하는 Bunker Data를 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBunkerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0050Event event = (EsmFms0050Event)e;
		  
		TCharterIOBunkerRegisterBC command = new TCharterIOBunkerRegisterBCImpl();
		  
		try {
			List<SearchBunkerVO> searchBunkerVO = command.searchBunkerList(event.getSearchBunkerVO());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse = (GeneralEventResponse)searchIdVslCdListByBunker(e);
			
			eventResponse.setRsVoList(searchBunkerVO);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Bunker 화면에서 데이타 입력 / 수정 / 삭제<br>
	 * Bunker 화면에서 데이타 저장<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBunker(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0050Event event = (EsmFms0050Event)e;
		
		TCharterIOBunkerRegisterBC command = new TCharterIOBunkerRegisterBCImpl();
		
		TCharterIOContractBC ctrtCommand = new TCharterIOContractBCImpl();
		
		try {
			CustomBunkerVO[] customBunkerVOs = event.getCustomBunkerVOS();
			
			SearchBunkerVO searchbunkervo = event.getSearchBunkerVO();
			
			String fletCtrtNo = searchbunkervo.getFletCtrtNo(); 
			String bnkYrmon = searchbunkervo.getBnkYrmon();
			String usrId = account.getUsr_id();
			
			begin();
			command.manageBunker(customBunkerVOs, usrId);
			
			//계약 테이블에 업데이트 할 정보 가져오기
			List<ContractByBunkerVO> contractByBunkerVO = command.searchContractByBunker(fletCtrtNo, bnkYrmon);
			
			//계약 테이블 업데이트
			if(contractByBunkerVO.size() > 0) {
				ctrtCommand.modifyContractByBunker(contractByBunkerVO.get(0), account.getUsr_id());
			}
			
			eventResponse = (GeneralEventResponse)searchBunkerList(e);
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Bunker Data를 조회하기 위해 Vessel Code 조회 Popup<br>
	 * 계약번호에 해당하는 vslCd가져오기<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIdVslCdListByBunker(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0050Event event = (EsmFms0050Event)e;
		
		TCharterIOBunkerRegisterBC command = new TCharterIOBunkerRegisterBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<SearchIdVslCdByBunkerVO> searchIdVslCdByBunkerVO = command.searchIdVslCdListByBunker(event.getFletCtrtNo());
			
			StringBuilder sb = new StringBuilder();
			
			if(searchIdVslCdByBunkerVO.size() > 0) {
				for(int i=0; i<searchIdVslCdByBunkerVO.size(); i++) {
					sb.append(searchIdVslCdByBunkerVO.get(i).getVslCd()+"|");
				}
			}
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("vslCd",sb.toString());
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Bunker Data를 입력하기 위해 항차 정보조회<br>
	 * vslCd와 bnkDt에 해당하는 항차 가져오기<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVvdListByBunker(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0050Event event = (EsmFms0050Event)e;
		
		TCharterIOBunkerRegisterBC command = new TCharterIOBunkerRegisterBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<SearchVvdByBunkerVO> searchVvdByBunkerVO = command.searchVvdListByBunker(event.getCurrVslCd(), event.getBunkerDt());
			
			StringBuilder sb = new StringBuilder();
			
			if(searchVvdByBunkerVO.size() > 0) {
				for(int i=0; i<searchVvdByBunkerVO.size(); i++) {
					sb.append(searchVvdByBunkerVO.get(i).getVvd()+"|");
				}
			}
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("vvd",sb.toString());
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Bunker Data를 입력하기 위해 Location Code 조회<br>
	 * Location Code 가져오기<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLocCdByBunker(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0050Event event = (EsmFms0050Event)e;
		
		TCharterIOBunkerRegisterBC command = new TCharterIOBunkerRegisterBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			String locCd = "";
			locCd = command.checkLocCdByBunker(event.getCurrPortCd());
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("locCd",locCd);
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * 계약 Type 조회<br>
	 * CtrtNo에 해당하는 Contract Type 가져오기<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContractTypeCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0050Event event = (EsmFms0050Event)e;
		
		TCharterIOContractBC command = new TCharterIOContractBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<SearchContractTypeCodeVO> searchContractTypeCodeVO = command.searchContractTypeCode(event.getFletCtrtNo());
			
			String ctrtType = searchContractTypeCodeVO.get(0).getFletCtrtTpCd();
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("ctrtType",ctrtType);
			
			eventResponse.setETCData(etcData);
			
			if(ctrtType == null || ctrtType.equals("")) {
				eventResponse.setUserMessage((String) new ErrorHandler("FMS01022",new String[]{}).getUserMessage());
			}
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Bunker Data를 입력하기 위해 표준코드를 가져온다<br>
	 * Bunker 화면에서 표준코드(Type, Uom)를 가져온다<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStandardCodeListByBunker() throws EventException {
		
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			int[] sortKey = {0, 0};
			
			String[] cdId      = {"CD01743", "CD01749"};
			String[] etcCodeNm = {"bnkType", "uomCode"};
			String[] etcTextNm = {"", "uomText"};
			
			List<Collection<CodeInfo>> codeInfoList = new ArrayList<Collection<CodeInfo>>();
			
			codeInfoList = command.getStandardCommonCode(cdId, sortKey);
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData = getStandardCommonCodeList(codeInfoList, etcCodeNm, etcTextNm);
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;

		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} 
	}
	
	/**
	 * Agreement Creation 화면에서 표준코드(Contract Type, Contract Fact, Payment Term)를 가져온다<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStandardCodeListByContract() throws EventException {
		
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			int[] sortKey = {0, 0, 0};
			
			String[] cdId      = {"CD01513", "CD01746", "CD01516"};
			String[] etcCodeNm = {"fletCtrtTpCd", "fletCtrtFactCd", "ctrtPayTermCd"};
			String[] etcTextNm = {"fletCtrtTpNm", "fletCtrtFactNm", "ctrtPayTermNm"};
			
			List<Collection<CodeInfo>> codeInfoList = new ArrayList<Collection<CodeInfo>>();
			
			codeInfoList = command.getStandardCommonCode(cdId, sortKey);
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData = getStandardCommonCodeList(codeInfoList, etcCodeNm, etcTextNm);
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;

		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Bunker Interface 정보 조회<br>
	 * BOD, BOR Monthly Interface 화면에서 데이타 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBunkerInterfaceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0051Event event = (EsmFms0051Event)e;
		  
		TCharterIOBunkerRegisterBC command = new TCharterIOBunkerRegisterBCImpl();
		  
		try {
			List<SearchBunkerInterfaceVO> searchBunkerInterfaceVO = command.searchBunkerInterfaceList(event.getBnkYrmon());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse.setRsVoList(searchBunkerInterfaceVO);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * EAI Interface를 하기 위한 Bunker Data 조회<br>
	 * BOD, BOR Monthly Interface 화면에서 EAI 데이타 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse sendBunkerData(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0051Event event = (EsmFms0051Event)e;
		  
		TCharterIOBunkerRegisterBC command = new TCharterIOBunkerRegisterBCImpl();

		try {
			
			begin();
			
			command.sendBunkerData(event.getBnkYrmon(), account.getUsr_id());
			
			commit();
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			
			return eventResponse;
			
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Charter's Account 계약정보 조회<br>
	 * CtrtNo에 해당하는 Contract Type/Owner Code/Owner Name 가져오기<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContractByCharter(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0001Event event = (EsmFms0001Event)e;
		
		TCharterIOContractBC command = new TCharterIOContractBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<SearchContractByCharterVO> searchContractByCharterVO = command.searchContractByCharter(event.getFletCtrtNo());
			
			String fletCtrtNo   = searchContractByCharterVO.get(0).getFletCtrtNo();
			String vslCd		= searchContractByCharterVO.get(0).getVslCd();
			String vslEngNm		= searchContractByCharterVO.get(0).getVslEngNm();
			String fletCtrtTpCd = searchContractByCharterVO.get(0).getFletCtrtTpCd();
			String custCntCd    = searchContractByCharterVO.get(0).getCustCntCd();
			String custSeq      = searchContractByCharterVO.get(0).getCustSeq();
			String vndrLglEngNm = searchContractByCharterVO.get(0).getVndrLglEngNm();
			String ownrNm       = searchContractByCharterVO.get(0).getOwnrNm();
			String ibflag       = searchContractByCharterVO.get(0).getIbflag();
			
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("fletCtrtNo",fletCtrtNo);
			etcData.put("vslCd",vslCd);
			etcData.put("vslEngNm",vslEngNm);
			etcData.put("fletCtrtTpCd",fletCtrtTpCd);
			etcData.put("custCntCd",custCntCd);
			etcData.put("custSeq",custSeq);
			etcData.put("vndrLglEngNm",vndrLglEngNm);
			etcData.put("ownrNm",ownrNm);
			etcData.put("ibflag",ibflag);
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Currency Code 가져오기<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCurrencyCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0076Event event = (EsmFms0076Event)e;
		
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			String currCd = "";
			currCd = command.checkCurrencyCode(event.getCurrCd());
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("currCd",currCd);
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
   /**
	* Owner List 조회<br>
	* 
	* @return response EventResponse
	* @exception EventException
	*/
    private EventResponse searchOwnerList() throws EventException {
	    
    	TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
    	try {
    		List<CustomOwnerVO> customOwnerVO = command.searchOwnerList();

    		GeneralEventResponse eventResponse = new GeneralEventResponse();
	   
    		eventResponse.setRsVoList(customOwnerVO);
	   
    		return eventResponse;
	   
    	} catch(EventException ex) {
    		throw new EventException(new ErrorHandler(ex).getMessage(), ex);
    	} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }
	 
    /**
	 * OwnerType Code 조회<br>
	 * Bunker 화면에서 표준코드(Type, Uom)를 가져온다<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchOwnerTypeCodeList() throws EventException {
    	
    	TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	  
    	try{
    		int[] sortKey = {0};
			
			String[] cdId      = {"CD01750"};
			String[] etcCodeNm = {"comboCode"};
			String[] etcTextNm = {"comboText"};
			
			List<Collection<CodeInfo>> codeInfoList = new ArrayList<Collection<CodeInfo>>();
			
			codeInfoList = command.getStandardCommonCode(cdId, sortKey);
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData = getStandardCommonCodeList(codeInfoList, etcCodeNm, etcTextNm);
			
			eventResponse.setETCData(etcData);
	   
    		return eventResponse;

    	} catch(Exception ex) {
    		throw new EventException(new ErrorHandler(ex).getMessage(), ex);
    	}
	 }
	 
	/**
	 * Charterer's Account 화면에서 데이타 조회<br>
	 * 용선주 비용에 관련된 계정을 조회한다
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchCharterInvoiceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
    	EsmFms0016Event event = (EsmFms0016Event)e;
		  
    	TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		  
		try {
			List<SearchCharterInvoiceListVO> searchCharterInvoiceListVOs = command.searchCharterInvoiceList(event.getCondCharterInvoiceVO());
			
			List<SearchCharterInvoiceSumVO> searchCharterInvoiceSumVOs = command.searchCharterInvoiceSum(event.getCondCharterInvoiceVO());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse.setRsVoList(searchCharterInvoiceListVOs);
			eventResponse.setRsVoList(searchCharterInvoiceSumVOs);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
    
    /**
	 * Charter's Account 에 해당하는 항차조회<br>
	 * fletCtrtNo와 bnkYrmon에 해당하는 항차 가져오기<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVvdListByCharter(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0016Event event = (EsmFms0016Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<SearchVvdListByCharterVO> searchVvdListByCharterVO = command.searchVvdListByCharter(event.getFletCtrtNo(), event.getRevYrmon());
			
			StringBuilder sb = new StringBuilder();
			
			if(searchVvdListByCharterVO.size() > 0) {
				for(int i=0; i<searchVvdListByCharterVO.size(); i++) {
					sb.append(searchVvdListByCharterVO.get(i).getVvd()+"|");
				}
			}
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("vvd",sb.toString());
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Charterer's Account 화면에서 용선주 비용을 변경한다<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCharterInvoice(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0016Event event = (EsmFms0016Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		// SDMS Interface 관련 BC
		StevedoreDamageMgtBC opfCmd = new StevedoreDamageMgtBCImpl();
		
		try {
			// INVOICE MASTER VO
			CustomInvoiceVO customInvoiceVO = event.getCustomInvoiceVO();
			
			// INVOICE DETAIL VO
			CustomInvDtlVO[] customInvDtlVOs = event.getCustomInvDtlVOS();
			
			// SDMS INSERT 처리
			CustomSdmsSettlementVO[] customSdmsSettlementVOs = event.getCustomSdmsSettlementVOS();
			
			String usrId = account.getUsr_id();
			
			begin();
			
			/************ SDMS Interface 처리 START ************/ 
			
			// SDMS INSERT 처리 
			if(customSdmsSettlementVOs != null) {
				opfCmd.addSettlementFMS(customSdmsSettlementVOs);
			} 
			
			// SDMS DELETE 처리
			if(customInvDtlVOs != null) {
				opfCmd.removeSettlementFMS(customInvDtlVOs);
			}
			
			/************ SDMS Interface 처리 END ***************/ 
			command.manageCharterInvoice(customInvoiceVO, customInvDtlVOs, usrId);
			
			eventResponse = (GeneralEventResponse)searchCharterInvoiceList(e);
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			commit();

		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Payment 전표생성<br>
	 * Prepayment, 운항정지비용, 용선주 비용, Owner's Account 관련를 이용하여 전표를 생성한다<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse managePaymentSlip(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0021Event event = (EsmFms0021Event)e;
		
		ExternalFinderBC etfCmd = new ExternalFinderBCImpl();
		
		TCharterIOInvoiceBC invCmd = new TCharterIOInvoiceBCImpl();
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
		
		TCharterIOBunkerRegisterBC bnkCmd = new TCharterIOBunkerRegisterBCImpl();
		
//		boolean ownerFlg = false;
		try {
			// SLP Master VO
			CustomPamConsultationVO[] customPamConsultationVOs = event.getCustomPamConsultationVOS();
			
			// SLP Detail VO
			CustomPamCsulSlpVO[] customPamCsulSlpVOs = event.getCustomPamCsulSlpVOS();
			
			// 세금계산서 / 계산서 Master VO
			CustomTaxVO[] customTaxVOs = event.getCustomTaxVOS();
			
			// 세금계산서 / 계산서 Detail VO
			CustomTaxDtlVO[] customTaxDtlVOs = event.getCustomTaxDtlVOS();
			
			// SLP 일련 번호
			String slpSerNo = "";
			
			// CSR No.(전표 생성 번호)
			String csrNo = "";
			
			
			//항차레벨을 체크 및 신계약번호 구계약번호를 판단하여 신계약번호 대신 구계약번호를 VO에 재설정한다 
			for (int i=0; i<customPamCsulSlpVOs.length; i++) {
				//항차레벨을 체크
				if(   customPamCsulSlpVOs[i].getBunkerVvd() != null 
				   && !customPamCsulSlpVOs[i].getBunkerVvd().equals("")) {
					
					String level = etfCmd.checkAcctCdVvdLevel(customPamCsulSlpVOs[i].getAcctCd(), customPamCsulSlpVOs[i].getBunkerVvd());
					if (!level.equals("2")) {	
						throw new EventException(new ErrorHandler("FMS01478",new String[]{customPamCsulSlpVOs[i].getAcctCd(), customPamCsulSlpVOs[i].getBunkerVvd()}).getMessage());
					}
				}
				/*
				//Owner's Account 항목이 들어있는지 확인
				if("111071".equals(customPamCsulSlpVOs[i].getAcctCd())) {
					ownerFlg = true;
				}
				*/
			}
			
			begin();
			
			// 전표 생성
			slpSerNo = command.managePaymentSlip(customPamConsultationVOs, customPamCsulSlpVOs, customTaxVOs, customTaxDtlVOs, account);
			
			// Bunker 테이블 업데이트
			bnkCmd.modifyPaymentSlipBunkers(customPamConsultationVOs, customPamCsulSlpVOs, slpSerNo);
			
			// Invoice 테이블 업데이트
			invCmd.modifyPaymentSlipInvoices(customPamConsultationVOs, customPamCsulSlpVOs, slpSerNo);
			
			// Owner's Account 테이블 업데이트
			invCmd.modifyPaymentSlipOwnerAccounts(customPamConsultationVOs, customPamCsulSlpVOs, slpSerNo);
			
			//eventResponse = (GeneralEventResponse)searchCharterInvoiceList(e);
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			csrNo = "07"+customPamConsultationVOs[0].getSlpTp()+customPamConsultationVOs[0].getSlpOfcCd()+customPamConsultationVOs[0].getSlpIssDt().substring(2)+slpSerNo;
			
			// 전표 생성 데이타 조회
			List<SearchPaymentSlipListVO> searchPaymentSlipListVO = command.searchPaymentSlipList(csrNo);
			
			//------------------------------	
			// 10만불2차 민정호			
			/* 용선인 경우 전표가 승인되면 ERP A/P 로 전송된다
			 * 대선인 경우 전표가 승인되면 ERP A/R 로 전송된다*/
			 
			log.debug("customPamConsultationVOs[0].getFletCtrtTpCd() = "+customPamConsultationVOs[0].getFletCtrtTpCd());
			log.debug("customPamConsultationVOs[0].getFletCtrtNo() = "+customPamConsultationVOs[0].getFletCtrtNo());			
			log.debug("customPamConsultationVOs[0].getFletCtrtNo().substring(4,6) = "+customPamConsultationVOs[0].getFletCtrtNo().substring(4,6));			
			log.debug("customPamConsultationVOs[0].getEffDt() = "+customPamConsultationVOs[0].getEffDt());
			
			String aproFlgUpdateYn  = "N";
			 if (csrNo.substring(0,2).equals("07")) {	//AP
				  String fletCtrtTpCd = "";
				  //command.manageSlipApproval(fletCtrtTpCd, csrNo, "Y", "", account.getUsr_id() ,"","", aproFlgUpdateYn,account.getOfc_cd(), "N", "");
				  command.manageSlipApproval(fletCtrtTpCd, csrNo, "Y", "", account.getUsr_id() ,"","", aproFlgUpdateYn,account.getOfc_cd(), "", "");
			 }					  
			//------------------------------
			 
			/*
			CustomConsultationVO customConsultationVO = event.getCustomConsultationVO();
			log.debug("\rcustomConsultationVO.getArOlayRtAmt() : " + customConsultationVO.getArOlayRtAmt());
//			log.debug("\rownerFlg : " + ownerFlg);
			log.debug("customConsultationVO.getEffDt() = "+customConsultationVO.getEffDt());
			log.debug("customConsultationVO.getCsrDesc() = "+customConsultationVO.getCsrDesc());
			if(customConsultationVO.getArOlayRtAmt() != null || !"".equals(customConsultationVO.getArOlayRtAmt())) {
				if(ownerFlg) { // Owner's Account항목이 포함되어있고 outlay comm이 존재하면 
					// 20T 전표 생성
					log.debug("Create OUTLAY COMM : 20T Consultation");
					TCharterIOConsultationBC tCharterIOConsultationBC = new TCharterIOConsultationBCImpl();
					TCharterIOInvoiceBC tCharterIOInvoiceBC = new TCharterIOInvoiceBCImpl();
					TCharterIOBunkerRegisterBC tCharterIOBunkerRegisterBC = new TCharterIOBunkerRegisterBCImpl();
					
					// 과거 생성된 데이터들을 찾아보니 아래 2개 컬럼의 값은 Insert되지 않았던 것으로 확인하여 동일하게 값을 넣지 않도록 함.
					customConsultationVO.setRqstDt("");
					customConsultationVO.setVndrSeq("");
					slpSerNo = tCharterIOConsultationBC.manageSubletRevenueSlip(event.getCustomConsultationVO(), event.getCustomCsulSlpVOS(), account);
					
					event.getCustomCsulSlpSeqVO().setSlpSerNo(slpSerNo);
					
					//===========================================================================			
					// AR-GW결재(201412. 민정호)
					// AR_INV_HDR 저장						
					log.debug("customConsultationVO.getRqstDt() = "+customConsultationVO.getRqstDt());
					log.debug("customConsultationVO.getSlpTpCd() = "+customConsultationVO.getSlpTpCd());
					log.debug("customConsultationVO.getSlpFuncCd() = "+customConsultationVO.getSlpFuncCd() );
					log.debug("customConsultationVO.getSlpOfcCd() = "+customConsultationVO.getSlpOfcCd());
					log.debug("customConsultationVO.getSlpIssDt() = "+customConsultationVO.getSlpIssDt());
					log.debug("customConsultationVO.getSlpIssDt().substring(2) = "+customConsultationVO.getSlpIssDt().substring(2));
					log.debug("customConsultationVO.getSlpIssDt().substring(2,8) = "+customConsultationVO.getSlpIssDt().substring(2,8));		
					
					String tCsrNo =	customConsultationVO.getSlpTpCd() +
									customConsultationVO.getSlpFuncCd() +
									customConsultationVO.getSlpOfcCd() +
									customConsultationVO.getSlpIssDt().substring(2) +									
									slpSerNo;
					
					tCharterIOConsultationBC.manageArInvHdr(tCsrNo, account.getUsr_id());
					//===========================================================================
					
					// Invoice 테이블 업테이트
					tCharterIOInvoiceBC.modifySubletRevenueSlip(event.getCustomCsulSlpVOS());
					
					// Bunker 테이블 업테이트
					tCharterIOBunkerRegisterBC.modifySubletRevenueSlip(event.getCustomCsulSlpVOS());
					
//					List<SearchSubletRevenueSlipListVO> searchSubletRevenueSlipListVO = tCharterIOConsultationBC.searchSubletRevenueSlipList(event.getCustomCsulSlpSeqVO());		
//					eventResponse.setRsVoList(searchSubletRevenueSlipListVO);
//					eventResponse.setUserMessage(new ErrorHandler("FMS00001").getUserMessage());
					
				}// ownerFlg == true
				
			}// outlay comm > 0
			*/								 
			etcData.put("csrNo",csrNo); 
			
			eventResponse.setETCData(etcData);
			
			eventResponse.setRsVoList(searchPaymentSlipListVO);
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
   /**
	 * Owner Code에 해당하는 Name 정보 조회<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOwnerName(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0001Event event = (EsmFms0001Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    
		TCharterIOContractBC command = new TCharterIOContractBCImpl();
		
		try{
			List<SearchOwnerNameVO> searchOwnerNameVO = command.searchOwnerName(event.getFletCtrtTpCd(), event.getCustCntCd(), event.getVndrSeq(), event.getCustSeq());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("ownrNm",searchOwnerNameVO.get(0).getOwnrNm());
			etcData.put("lglEngNm",searchOwnerNameVO.get(0).getLglEngNm());
			
			eventResponse.setETCData(etcData);
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * VendorCode 조회<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVendorCodeList() throws EventException {
	    
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {
			List<SearchVendorCustomerVO> searchVendorCustomerVO = command.searchVendorCodeList();
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchVendorCustomerVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }
	 
	/**
	 * Owner 정보 입력 / 수정 / 삭제<br>
	 * Owner 화면에서 데이타 저장<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
    private EventResponse manageOwner(Event e) throws EventException {
	  
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
	  
    	EsmFms0006Event event = (EsmFms0006Event)e;
	  
    	TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	  
    	try {
    		CustomOwnerVO[] customOwnerVOs = event.getCustomOwnerVOS();
	   
    		String usrId = account.getUsr_id();
	   
    		begin();
    		command.manageOwner(customOwnerVOs, usrId);
    		
    		eventResponse = (GeneralEventResponse)searchOwnerList();
    		   
    		eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
    		
    		commit();
	   
    	} catch(EventException ex) {
    		rollback();
    		log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler(ex).getMessage(), ex);
    	} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	  
    	return eventResponse;
	 }

	/**
	 * Owner Data 입력 / 수정 / 삭제<br>
	 * Owner 화면에서 데이타 저장<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVendorCode(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	
		EsmFms0004Event event = (EsmFms0004Event)e;
	
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
		TCharterIOContractBC command2 = new TCharterIOContractBCImpl();
	
		try {
			SearchVendorCustomerVO[] searchVendorCustomerVOs = event.getSearchVendorCustomerVOS();
	
			String usrId = account.getUsr_id();
	
			begin();
			
			command.manageVendorCode(searchVendorCustomerVOs, usrId);
			command2.manageVendorCode(searchVendorCustomerVOs, usrId);
    		
    		eventResponse = (GeneralEventResponse)searchVendorCodeList();
    		
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());

    		commit();
	
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	 }

    /**
	 * Owner 화면에서 CustomerCode 정보를 저장한다(입력 / 수정 / 삭제)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCustomerCode(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	
		EsmFms0005Event event = (EsmFms0005Event)e;
	
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
		TCharterIOContractBC command2 = new TCharterIOContractBCImpl();
	
		try {
			SearchVendorCustomerVO[] searchVendorCustomerVOs = event.getSearchVendorCustomerVOS();
	
			String usrId = account.getUsr_id();
	
			begin();
			
			command.manageCustomerCode(searchVendorCustomerVOs, usrId);
			command2.manageCustomerCode(searchVendorCustomerVOs, usrId);
			
    		
    		eventResponse = (GeneralEventResponse)searchCustomerCodeList();
    		
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			
			commit();
	
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	 }

   /**
	* Bunker 화면에서 CustomerCode 정보를 조회한다<br>
	* 
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchCustomerCodeList() throws EventException {
	    
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {
			List<SearchVendorCustomerVO> searchVendorCustomerVO = command.searchCustomerCodeList();
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchVendorCustomerVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }

   /**
	* Bunker 화면에서 VendorCustomer 정보를 조회한다<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchVendorCustomerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0070Event event = (EsmFms0070Event)e;
	    
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {
			List<SearchVendorCustomerVO> searchVendorCustomerVO = command.searchVendorCustomerList(event.getAgmtFlag(), event.getCondFlag(), event.getVendorCustomerName());
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchVendorCustomerVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }

   /**
	* Bunker 화면에서 OwnerName 정보를 조회한다<br>
	* 
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchOwnerNameList() throws EventException {
	    
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {
			List<SearchOwnerNameListVO> searchOwnerNameListVO = command.searchOwnerNameList();
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchOwnerNameListVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }

   /**
	* Bunker 화면에서 VendorCustomerName 정보를 조회한다<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchVendorCustomerName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0070Event event = (EsmFms0070Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {
			List<SearchVendorCustomerVO> searchVendorCustomerVO = command.searchVendorCustomerName(event.getCondFlag(), event.getCdCnt(), event.getCdSeq());
	
			if(searchVendorCustomerVO.size() > 0) {
				Map<String,String> etcData = new HashMap<String,String>();
				
				etcData.put("cdCnt",searchVendorCustomerVO.get(0).getCdCnt());
				etcData.put("cdSeq",searchVendorCustomerVO.get(0).getCdSeq());
				etcData.put("cdName",searchVendorCustomerVO.get(0).getCdName());
				
				eventResponse.setETCData(etcData);
				
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("FMS01304",new String[]{}).getUserMessage());
			}
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;

	}
	
   /**
	* Item Detail Management 화면에서 AccountItemDetail 정보를 조회한다<br>
	* 
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchAccountItemDetailList() throws EventException {
	    
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {
			List<CustomAcctItmVO> customAcctItmVO = command.searchAccountItemDetailList();
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(customAcctItmVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }
	
    /**
	 * Account Item List 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse checkAccountCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0069Event event = (EsmFms0069Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	
		try{
			List<CustomAcctItmVO> customAcctItmVO = command.checkAccountCode(event.getAcctCd());
			
			if(customAcctItmVO.size() > 0) {
				Map<String,String> etcData = new HashMap<String,String>();
				
				etcData.put("cdName",customAcctItmVO.get(0).getAcctCd());
				
				eventResponse.setETCData(etcData);
				
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("FMS01316",new String[]{}).getUserMessage());
			}
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
    
    /**
	 * Account Code 화면에서 AccountCate 데이타를 저장한다(입력 / 수정 / 삭제)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAccountCate(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	
		EsmFms0003Event event = (EsmFms0003Event)e;
	
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	
		try {
			CustomAcctCateVO[] customAcctCateVOs = event.getCustomAcctCateVOS();
	
			String usrId = account.getUsr_id();
	
			begin();
			command.manageAccountCate(customAcctCateVOs, usrId);
			
			eventResponse = (GeneralEventResponse)searchAccountCateList();
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			
			commit();
	
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	 }

	/**
	* Account Code 화면에서 AccountCate 데이타를 조회한다<br>
	* 
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchAccountCateList() throws EventException {
	    
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {
			List<CustomAcctCateVO > customAcctCateVO  = command.searchAccountCateList();
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(customAcctCateVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }

	/**
	 * Item Detail Management 화면에서 AccountItemName 데이타를 저장한다(입력 / 수정 / 삭제)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAccountItemName(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	
		EsmFms0069Event event = (EsmFms0069Event)e;
	
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	
		try {
			CustomAcctItmVO[] customAcctItmVOs = event.getCustomAcctItmVOS();
	
			String usrId = account.getUsr_id();
	
			begin();
			command.manageAccountItemName(customAcctItmVOs, usrId);
			
			eventResponse = (GeneralEventResponse)searchAccountItemDetailList();
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			
			commit();
	
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	 }
	
	/**
     * 표준코드를 가져온다<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchStandardCodeList(Event e) throws EventException {
    	
    	EsmFms0006Event event = (EsmFms0006Event)e;
    	
    	TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
    	
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	
    	try{
    		
    		String[] cdId      = event.getComCdId().split(":");
    		String[] etcCodeNm = event.getComCode().split(":");
    		String[] etcTextNm = event.getComText().split(":");
    		
    		int comSize = cdId.length;
    		
    		int[] sortKey = new int[comSize];
    		
    		for (int i=0; i<comSize; i++) {
    			sortKey[i] = 0;
    		}
    		
    		List<Collection<CodeInfo>> codeInfoList = new ArrayList<Collection<CodeInfo>>();
			
			codeInfoList = command.getStandardCommonCode(cdId, sortKey);
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData = getStandardCommonCodeList(codeInfoList, etcCodeNm, etcTextNm);
			
			eventResponse.setETCData(etcData);
    		
    		return eventResponse;

    	} catch(Exception ex) {
    		throw new EventException(new ErrorHandler(ex).getMessage(), ex);
    	}
    }
    
    /**
	 * 계약정보 화면에서 메일을 발송한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse sendEmail(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0079Event event = (EsmFms0079Event)e;
		  
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		  
		try {
			CustomSendEmailVO customSendMailVO = event.getCustomSendEmailVO();
			
			String signature = "";
			String usrNm = account.getUsr_nm();
			String ofcNm = account.getOfc_eng_nm();
			String phnNo = account.getXtn_phn_no();
			String emailNo = account.getUsr_eml();
			
			//서명
			StringBuilder sb = new StringBuilder();
			
			sb.append("<P class=MsoNormal style='LAYOUT-GRID-MODE: char; mso-margin-top-alt: auto; mso-margin-bottom-alt: auto'><SPAN lang=EN-US style='FONT-SIZE: 10pt; COLOR: navy; FONT-FAMILY: Arial,serif'></SPAN>&nbsp;</P>");
/*			sb.append("<P class=MsoNormal style='LAYOUT-GRID-MODE: char; mso-margin-top-alt: auto; mso-margin-bottom-alt: auto'><SPAN lang=EN-US style='FONT-SIZE: 10pt; COLOR: navy; FONT-FAMILY: 바탕,serif'></SPAN>&nbsp;</P>");
			sb.append("<P class=MsoNormal style='LAYOUT-GRID-MODE: char; mso-margin-top-alt: auto; mso-margin-bottom-alt: auto'><SPAN lang=EN-US style='FONT-SIZE: 10pt; COLOR: navy; FONT-FAMILY: 바탕,serif'></SPAN>&nbsp;</P>");
			sb.append("<P class=MsoNormal style='LAYOUT-GRID-MODE: char; mso-margin-top-alt: auto; mso-margin-bottom-alt: auto'><SPAN lang=EN-US style='FONT-SIZE: 10pt; COLOR: navy; FONT-FAMILY: 바탕,serif'></SPAN>&nbsp;</P>");
			sb.append("<P class=MsoNormal style='LAYOUT-GRID-MODE: char; mso-margin-top-alt: auto; mso-margin-bottom-alt: auto'><SPAN lang=EN-US style='FONT-SIZE: 10pt; COLOR: navy; FONT-FAMILY: 바탕,serif'></SPAN>&nbsp;</P>");*/
			sb.append("<P class=MsoNormal style='LAYOUT-GRID-MODE: char; mso-margin-top-alt: auto; mso-margin-bottom-alt: auto'><SPAN lang=EN-US style='FONT-SIZE: 10pt; COLOR: navy; FONT-FAMILY: Arial,serif'>Best Regards.</SPAN></P>");
			sb.append("<P class=MsoNormal style='mso-margin-top-alt: auto; mso-margin-bottom-alt: auto'><SPAN lang=EN-US style='FONT-SIZE: 10pt; COLOR: #595959; FONT-FAMILY: Arial,serif'></SPAN>&nbsp;</P>");
			sb.append("<P class=MsoNormal style='LAYOUT-GRID-MODE: char; mso-margin-top-alt: auto; mso-margin-bottom-alt: auto'><SPAN lang=EN-US style='FONT-SIZE: 10pt; COLOR: red; FONT-FAMILY: Arial,serif'>________________________________________________________</SPAN></P>");
			sb.append("<P class=MsoNormal style='LAYOUT-GRID-MODE: char; LINE-HEIGHT: 150%; mso-margin-top-alt: auto; mso-margin-bottom-alt: auto'><SPAN lang=EN-US style='FONT-SIZE: 10pt; COLOR: navy; LINE-HEIGHT: 150%; FONT-FAMILY: Arial,serif'>"+usrNm+"</SPAN></P>");
			
			sb.append("<P class=MsoNormal style='mso-margin-top-alt: auto; mso-margin-bottom-alt: auto'><SPAN lang=EN-US style='FONT-SIZE: 10pt; COLOR: #595959; FONT-FAMILY: Arial,serif'></SPAN>&nbsp;</P>");
			sb.append("<P class=MsoNormal style='LAYOUT-GRID-MODE: char; LINE-HEIGHT: 150%; mso-margin-top-alt: auto; mso-margin-bottom-alt: auto'><SPAN lang=EN-US style='FONT-SIZE: 10pt; COLOR: navy; LINE-HEIGHT: 150%; FONT-FAMILY: Arial,serif'>"+ofcNm+", SM Line Corporation </SPAN></P>");
			sb.append("<P class=MsoNormal style='LAYOUT-GRID-MODE: char; mso-margin-top-alt: auto; mso-margin-bottom-alt: auto'><SPAN lang=EN-US style='FONT-SIZE: 10pt; COLOR: navy; FONT-FAMILY: Arial,serif'>6<sup>th</sup> Fl. SM R&D Center #78, Magokjungang 8-ro, Gangseo-gu, Seoul, Korea</SPAN></P>");
			sb.append("<P class=MsoNormal style='LAYOUT-GRID-MODE: char; mso-margin-top-alt: auto; mso-margin-bottom-alt: auto'><SPAN lang=EN-US style='FONT-SIZE: 10pt; COLOR: blue; FONT-FAMILY: Arial'>Tel : "+phnNo+", E-Mail : "+emailNo+"</SPAN></P>");
			
			signature = sb.toString();
			
			customSendMailVO.setSignature(signature);
			
			//UPLOAD KEY
			List<String> keys = event.getKeys();
			
			String csrNo = event.getCsrNo();
			//String csrNo = "";
			
			begin();
			
			String successMsg = command.sendEmail(customSendMailVO, keys, csrNo);
			
			commit();
			
			if(successMsg != null && !successMsg.equals("")) {
				eventResponse.setUserMessage((String) new ErrorHandler("FMS01186",new String[]{}).getUserMessage());
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("FMS01187",new String[]{}).getUserMessage());
			}
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
    
    /**
	 * OwnerInvoice 정보를 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchOwnerInvoiceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	
		EsmFms0018Event event = (EsmFms0018Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		try {
			event.getCondSearchOwnerInvoiceVO().setSheetNo("1");
			List<SearchOwnerInvoiceListVO> searchOwnerInvoiceListVO1 = command.searchOwnerInvoiceList(event.getCondSearchOwnerInvoiceVO());
			
			event.getCondSearchOwnerInvoiceVO().setSheetNo("2");
			List<SearchOwnerInvoiceListVO> searchOwnerInvoiceListVO2 = command.searchOwnerInvoiceList(event.getCondSearchOwnerInvoiceVO());

			eventResponse.setRsVoList(searchOwnerInvoiceListVO1);
			eventResponse.setRsVoList(searchOwnerInvoiceListVO2);
		
	    } catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	/**
	 * OwnerInvoice 정보를 저장한다(입력 / 수정 / 삭제)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse modifyOwnerInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0018Event event = (EsmFms0018Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		try{
			begin();
			if (event.getCustomOwnrAcctSlpVOS() != null) {
				command.modifyOwnerInvoice(event.getCustomOwnrAcctSlpVOS(),account.getUsr_id());
				
				if(event.getSearchType().equalsIgnoreCase("S")) {
					eventResponse = (GeneralEventResponse)searchOwnerInvoiceList(e);
				} else {
					eventResponse = (GeneralEventResponse)searchOwnerInvoiceAutoMatchList(e);
				}
				
				eventResponse.setUserMessage(new ErrorHandler("FMS00001").getUserMessage());
				commit();
			}
		} catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * OwnerInvoiceAutoMatch 정보를 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchOwnerInvoiceAutoMatchList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	
		EsmFms0018Event event = (EsmFms0018Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();

		try {
			event.getCondSearchOwnerInvoiceAutoMatchVO().setSheetNo("1");
			List<SearchOwnerInvoiceAutoMatchListVO> searchOwnerInvoiceAutoMatchListVO1 = 
												command.searchOwnerInvoiceAutoMatchList(event.getCondSearchOwnerInvoiceAutoMatchVO());
			
			event.getCondSearchOwnerInvoiceAutoMatchVO().setSheetNo("2");
			List<SearchOwnerInvoiceAutoMatchListVO> searchOwnerInvoiceAutoMatchListVO2 = 
												command.searchOwnerInvoiceAutoMatchList(event.getCondSearchOwnerInvoiceAutoMatchVO());
			
			eventResponse.setRsVoList(searchOwnerInvoiceAutoMatchListVO1);
			eventResponse.setRsVoList(searchOwnerInvoiceAutoMatchListVO2);

	    } catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	}
    
    /**
	 * Prepayments 화면에서 CalPrepaymentInvoice 데이타를 조회한다(Creation 선택시)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCalPrepaymentInvoiceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0012Event event = (EsmFms0012Event)e;
		  
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		  
		try {
			List<SearchCalPrepaymentInvoiceListVO> searchCalPrepaymentInvoiceListVOs = command.searchCalPrepaymentInvoiceList(event.getCondSearchCalPrepaymentInvoiceListVO());
			
			List<SearchCalPrepaymentInvoiceListSumVO> searchCalPrepaymentInvoiceListSumVOs = command.searchCalPrepaymentInvoiceListSum(event.getCondSearchCalPrepaymentInvoiceListVO());
			
			eventResponse.setRsVoList(searchCalPrepaymentInvoiceListVOs);
			eventResponse.setRsVoList(searchCalPrepaymentInvoiceListSumVOs);
			
			if(searchCalPrepaymentInvoiceListVOs.size() < 1) {
				eventResponse.setUserMessage((String) new ErrorHandler("FMS01167",new String[]{}).getUserMessage());
			}
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Prepayments 화면에서 데이타 조회(Inquiry 선택시)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPrepaymentInvoiceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0012Event event = (EsmFms0012Event)e;
		  
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		  
		try {
			InvoiceContainerVO invoiceContainerVO = command.searchPrepaymentInvoiceList(event.getFletCtrtNo(), event.getPpayHirNo(), event.getInvSeq());
			
			List<SearchContractListByPrepaymentHireNoVO> searchContractListByPrepaymentHireNoVOs = invoiceContainerVO.getSearchContractListByPrepaymentHireNoVOs();
			SearchPrepaymentInvoiceVO searchPrepaymentInvoiceVO = invoiceContainerVO.getSearchPrepaymentInvoiceVO();
			SearchHireSysDateVO searchHireSysDateVO = invoiceContainerVO.getSearchHireSysDateVO();
			List<SearchOtrExpnSysDateListVO> searchOtrExpnSysDateListVOs = invoiceContainerVO.getSearchOtrExpnSysDateListVOs();
			List<SearchPrepaymentHireNoListVO> searchPrepaymentHireNoListVOs= invoiceContainerVO.getSearchPrepaymentHireNoListVOs();
			List<SearchPrepaymentHireNoListSumVO> searchPrepaymentHireNoListSumVOs = invoiceContainerVO.getSearchPrepaymentHireNoListSumVOs();

			Map<String,String> etcData = new HashMap<String,String>();

			//********************** CONTRACT 테이블의 정보 가져오기(START) **********************//
			
			eventResponse.setETCData("fletCtrtNo",searchPrepaymentInvoiceVO.getFletCtrtNo());
			eventResponse.setETCData("vslCd",searchPrepaymentInvoiceVO.getVslCd());
			eventResponse.setETCData("vslEngNm",searchPrepaymentInvoiceVO.getVslEngNm());
			eventResponse.setETCData("fletCtrtTpCd",searchPrepaymentInvoiceVO.getFletCtrtTpCd());
			eventResponse.setETCData("custCntCd",searchPrepaymentInvoiceVO.getCustCntCd());
			eventResponse.setETCData("custSeq",searchPrepaymentInvoiceVO.getCustSeq());
			eventResponse.setETCData("vndrLglEngNm",searchPrepaymentInvoiceVO.getVndrLglEngNm());
			eventResponse.setETCData("ownrNm",searchPrepaymentInvoiceVO.getOwnrNm());
			eventResponse.setETCData("effDt",searchPrepaymentInvoiceVO.getEffDt());
			eventResponse.setETCData("fromTime",searchPrepaymentInvoiceVO.getFromTime());
			eventResponse.setETCData("expDt",searchPrepaymentInvoiceVO.getExpDt());
			eventResponse.setETCData("toTime",searchPrepaymentInvoiceVO.getToTime());
			eventResponse.setETCData("invUsdDys",searchPrepaymentInvoiceVO.getInvUsdDys());
			eventResponse.setETCData("acmmRtAmt",searchPrepaymentInvoiceVO.getAcmmRtAmt());
			eventResponse.setETCData("fletBrogRtAmt",searchPrepaymentInvoiceVO.getFletBrogRtAmt());
			eventResponse.setETCData("acmmFlg",searchPrepaymentInvoiceVO.getAcmmFlg());
			eventResponse.setETCData("brogFlg",searchPrepaymentInvoiceVO.getBrogFlg());
			eventResponse.setETCData("invSeq",searchPrepaymentInvoiceVO.getInvSeq());
			
			//*********************** CONTRACT 테이블의 정보 가져오기(END) ************************//
			
			//************* Hire 테이블의 최신 정보 가져오기 [Hire Information] (START) ************//
			
			if(searchHireSysDateVO != null) {
				eventResponse.setETCData("hirEffDt",searchHireSysDateVO.getEffDt());
				eventResponse.setETCData("hirEffDtTime",searchHireSysDateVO.getEffDtTime()); 
				eventResponse.setETCData("hirExpDt",searchHireSysDateVO.getExpDt());
				eventResponse.setETCData("hirExpDtTime",searchHireSysDateVO.getExpDtTime()); 
				eventResponse.setETCData("hirHirCurrN1stCd",searchHireSysDateVO.getHirCurrN1stCd());
				eventResponse.setETCData("hirHirRtN1stAmt",searchHireSysDateVO.getHirRtN1stAmt());
				eventResponse.setETCData("hirHirCurrN2ndCd",searchHireSysDateVO.getHirCurrN2ndCd());
				eventResponse.setETCData("hirHirRtN2ndAmt",searchHireSysDateVO.getHirRtN2ndAmt());
			} else {
				eventResponse.setETCData("hirEffDt","");
				eventResponse.setETCData("hirEffDtTime",""); 
				eventResponse.setETCData("hirExpDt","");
				eventResponse.setETCData("hirExpDtTime",""); 
				eventResponse.setETCData("hirHirCurrN1stCd","");
				eventResponse.setETCData("hirHirRtN1stAmt","");
				eventResponse.setETCData("hirHirCurrN2ndCd","");
				eventResponse.setETCData("hirHirRtN2ndAmt","");
			}
			
			//************* Hire 테이블의 최신 정보 가져오기 [Hire Information] (END) **************//
			
			//*************************** Hire No 가저오기 - 콤보용 (START) **********************//

			if(   searchContractListByPrepaymentHireNoVOs != null 
			   && searchContractListByPrepaymentHireNoVOs.size() > 0) {
				
				StringBuilder sb = new StringBuilder();
				//String payHirNo = "";
				//String fletCtrtTpCd = "";
				
				for(int i=0; i<searchContractListByPrepaymentHireNoVOs.size(); i++) {
					sb.append(searchContractListByPrepaymentHireNoVOs.get(i).getPpayHirNo()+"|");
				}
				
				etcData.put("payHirNo",sb.toString());
			}
			
			//*************************** Hire No 가저오기 - 콤보용 (END) ************************//
			
			eventResponse.setETCData(etcData);
			
			eventResponse.setRsVoList(searchOtrExpnSysDateListVOs);
			eventResponse.setRsVoList(searchPrepaymentHireNoListVOs);
			eventResponse.setRsVoList(searchPrepaymentHireNoListSumVOs);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Off-Hire Expenses 화면에서 CalOffhireInvoice 데이타를 조회한다(Creation 선택시)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCalOffhireInvoiceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0014Event event = (EsmFms0014Event)e;
		  
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		  
		try {

			
			List<SearchCalOffhireInvoiceListVO> searchCalOffhireInvoiceListVOs1 = command.searchCalOffhireInvoiceCheck(event.getCondCalOffhireInvoiceVO());
			
			if(searchCalOffhireInvoiceListVOs1.size() > 0) {	// 동일 기간 OFF-HIRE 입력 불가.
				eventResponse.setUserMessage("Your input offhire data is duplicated in data base.");

			}else{
				List<SearchCalOffhireInvoiceListVO> searchCalOffhireInvoiceListVOs = command.searchCalOffhireInvoiceList(event.getCondCalOffhireInvoiceVO());
				
				List<SearchCalOffhireInvoiceListSumVO> searchCalOffhireInvoiceListSumVOs = command.searchCalOffhireInvoiceListSum(event.getCondCalOffhireInvoiceVO());
				
				eventResponse.setRsVoList(searchCalOffhireInvoiceListVOs);
				eventResponse.setRsVoList(searchCalOffhireInvoiceListSumVOs);
				
				if(searchCalOffhireInvoiceListVOs.size() < 1) {
					eventResponse.setUserMessage((String) new ErrorHandler("FMS01167",new String[]{}).getUserMessage());
				}
				
			}
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * CtrtNo와 Duration에 해당하는 항차 가져오기<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVvdListByOffHire(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0014Event event = (EsmFms0014Event)e;
		  
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<SearchVvdListByOffHireVO> searchVvdListByOffHireVO = command.searchVvdListByOffHire(event.getFletCtrtNo(), event.getEffDt(), event.getExpDt(), event.getVslCd());
			
			StringBuilder sb = new StringBuilder();
			
			if(searchVvdListByOffHireVO.size() > 0) {
				for(int i=0; i<searchVvdListByOffHireVO.size(); i++) {
					sb.append(searchVvdListByOffHireVO.get(i).getVvd()+"|");
				}
			}
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("bunker_vvd",sb.toString());
			etcData.put("bunker_vvd_text",sb.toString());
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
    
    /**
	 * Off-Hire Expenses 화면에서 Offhire Expenses 정보를 등록 및 변경한다<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOffhireInvoice(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0014Event event = (EsmFms0014Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		try {
			CustomOffInvoiceVO customOffInvoiceVO = event.getCustomOffInvoiceVO();
			
			CustomOffInvDtlVO[] customOffInvDtlVOs = event.getCustomOffInvDtlVOS();
			
			String usrId = account.getUsr_id();

			begin();
			command.manageOffhireInvoice(customOffInvoiceVO, customOffInvDtlVOs, usrId);
			
			eventResponse = (GeneralEventResponse)searchOffhireInvoiceList(e);
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Bunker 화면에서 ManhourItem 데이타를 조회한다<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManhourItemList() throws EventException {
	    
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
	    
		try {
			List<SearchManhourItemListVO> searchManhourItemListVO = command.searchManhourItemList();
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchManhourItemListVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Off-Hire Expenses 화면에서 OffhireInvoice 데이타 조회(Inquery 선택시)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffhireInvoiceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0014Event event = (EsmFms0014Event)e;
		  
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		  
		try {
			List<SearchOffhireInvoiceListVO> searchOffhireInvoiceListVOs = command.searchOffhireInvoiceList(event.getFletCtrtNo(), event.getInvSeq());
			
			List<SearchCalOffhireInvoiceListSumVO> searchCalOffhireInvoiceListSumVOs = command.searchOffhireInvoiceListSum(event.getFletCtrtNo(), event.getInvSeq());
			
			//Map<String,String> sumData = new HashMap<String,String>();
			
			//sumData = getCalOffhireInvoiceListSum(searchCalOffhireInvoiceListSumVOs);
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("invSeq",searchOffhireInvoiceListVOs.get(0).getInvSeq());
			//etcData.put("totalAmount1",sumData.get("totalAmount1"));
			//etcData.put("totalAmount2",sumData.get("totalAmount2"));
			
			eventResponse.setRsVoList(searchOffhireInvoiceListVOs);
			eventResponse.setRsVoList(searchCalOffhireInvoiceListSumVOs);
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Prepayments 정보 삭제(DELETE)-전표가 생성되지 않은 경우에만 해당됨<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */	
	private EventResponse removePrepaymentInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0012Event event = (EsmFms0012Event)e;
		  
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{	
			begin();

			command.removePrepaymentInvoice(event.getFletCtrtNo(), event.getInvSeq());
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Manhour 정보를 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManhourList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0007Event event = (EsmFms0007Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		try {
			List<SearchManhourListVO> searchManhourListVO = command.searchManhourList(event.getCondSearchManhourListVO());
			eventResponse.setRsVoList(searchManhourListVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	}

	/**
	 * Manhour 정보를 저장한다(입력 / 수정 / 삭제)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManhourList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0007Event event = (EsmFms0007Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		try {
			begin();
			command.manageManhourList(event.getCustomManHrChgVOS(),account.getUsr_id());
			eventResponse = (GeneralEventResponse)searchManhourList(e);
			eventResponse.setUserMessage(new ErrorHandler("FMS00001").getUserMessage());
			commit();
		} catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
   /**
	* Offhire Selection 화면에서 OffhireSelection 정보를 조회한다<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchOffhireSelectionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0078Event event = (EsmFms0078Event)e;
	    
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    
		try {
			List<SearchOffhireSelectionListVO> searchOffhireSelectionListVO = command.searchOffhireSelectionList(event.getFletCtrtNo());
	
			eventResponse.setRsVoList(searchOffhireSelectionListVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
	
	/**
	 * 사선/용선/대선 정보 삭제(DELETE)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */	
	private EventResponse removeOffhireInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0014Event event = (EsmFms0014Event)e;
		  
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{	
			begin();

			command.removeOffhireInvoice(event.getFletCtrtNo(), event.getInvSeq());
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ManhourItemRegistration 정보를 가져온다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManhourItemRegistrationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		try {
			List<SearchManhourItemRegistrationListVO> searchManhourItemRegistrationListVO = command.searchManhourItemRegistrationList();
			eventResponse.setRsVoList(searchManhourItemRegistrationListVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	/**
	 * ManhourItemRegistration 정보를 저장한다(입력 / 수정 / 삭제)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManhourItemRegistration(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0072Event event = (EsmFms0072Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		try {
			begin();
			command.manageManhourItemRegistration(event.getCustomManHrListVOS(),account.getUsr_id());
			eventResponse = (GeneralEventResponse)searchManhourItemRegistrationList(e);
			eventResponse.setUserMessage(new ErrorHandler("FMS00001").getUserMessage());
			commit();
		} catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Offhire Expenses from VMS 화면에서 데이타 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffhireInvoiceVmsList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0073Event event = (EsmFms0073Event)e;
	    
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    
		try {
			CondSearchOffhireInvoiceVmsVO condSearchOffhireInvoiceVmsVO = event.getCondSearchOffhireInvoiceVmsVO();
			
			List<SearchOffhireInvoiceVmsListVO> searchOffhireInvoiceVmsListVO = command.searchOffhireInvoiceVmsList(condSearchOffhireInvoiceVmsVO);
	
			eventResponse.setRsVoList(searchOffhireInvoiceVmsListVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
	
	/**
	 * Offhire Expenses from VMS 화면에서 등록 정보를 변경한다<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyOffhireInvoiceVms(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0073Event event = (EsmFms0073Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		try {
			
			CustomOffhExpnVO[] customOffhExpnVOs = event.getCustomOffhExpnVOS();
			
			String usrId = account.getUsr_id();

			begin();
			command.modifyOffhireInvoiceVms(customOffhExpnVOs, usrId);
			
			//eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * E-Mail에 첨부할 파일 Key를 가져온다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searhAttachFileKey(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0075Event event = (EsmFms0075Event)e;

		try {
			eventResponse.setETCData("fileKey", event.getKeys().get(0));
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * Prepayments 화면에서 Invoice 정보를 등록한다<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse creatPrepaymentInvoice(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0012Event event = (EsmFms0012Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		try {
			CustomPreInvoiceVO customPreInvoiceVO = event.getCustomPreInvoiceVO();
			
			CustomPreInvDtlVO[] customPreInvDtlVOs = event.getCustomPreInvDtlVOS();
			
			String usrId = account.getUsr_id();

			begin();
			command.creatPrepaymentInvoice(customPreInvoiceVO, customPreInvDtlVOs, usrId);
			
			eventResponse = (GeneralEventResponse)searchPrepaymentInvoiceList(e);
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Prepayments 화면에서 Invoice 정보를 변경/삭제한다<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse managePrepaymentInvoice(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0012Event event = (EsmFms0012Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		try {
			CustomPreInvoiceVO customPreInvoiceVO = event.getCustomPreInvoiceVO();
			
			CustomPreInvDtlVO[] customPreInvDtlVOs = event.getCustomPreInvDtlVOS();
			
			String usrId = account.getUsr_id();

			begin();
			command.managePrepaymentInvoice(customPreInvoiceVO, customPreInvDtlVOs, usrId);
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * Owner's Account Expense 화면에서 OwnerAccountExpense 정보를 저장한다(입력 / 수정 / 삭제)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOwnerAccountExpense(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	
		EsmFms0039Event event = (EsmFms0039Event)e;
		
		//ExternalFinderBC etfCmd = new ExternalFinderBCImpl();
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
	
		try {
			CustomConsultationVO customConsultationVO = event.getCustomConsultationVO();
			CustomCsulSlpVO[] customCsulSlpVOs = event.getCustomCsulSlpVOS();
	
			String usrId = account.getUsr_id();
			
			/*
			//항차레벨을 체크한다
			for (int i=0; i<customCsulSlpVOs.length; i++) {
				if(   customCsulSlpVOs[i].getVvdCd() != null 
				   && !customCsulSlpVOs[i].getVvdCd().equals("")) {
					
					String level = etfCmd.checkAcctCdVvdLevel(customCsulSlpVOs[i].getAcctCd(), customCsulSlpVOs[i].getVvdCd());
					if (!level.equals("2")) {	
						throw new EventException(new ErrorHandler("FMS01478",new String[]{customCsulSlpVOs[i].getAcctCd(), customCsulSlpVOs[i].getVvdCd()}).getMessage());
					}
				}
			}
			*/
	
			begin();
			//Consultation 3개 테이블 저장
			String slpSerNo = command.creationOwnerAccountExpense(customConsultationVO, customCsulSlpVOs, usrId);
			
			//FMS_OWNR_ACCT_SLP 테이블 저장
			TCharterIOInvoiceBC invcommand = new TCharterIOInvoiceBCImpl();
			for(int i=0; i<customCsulSlpVOs.length; i++) {
				customCsulSlpVOs[i].setSlpTpCd(customConsultationVO.getSlpTpCd());
				customCsulSlpVOs[i].setSlpFuncCd(customConsultationVO.getSlpFuncCd());
				customCsulSlpVOs[i].setSlpOfcCd(customConsultationVO.getSlpOfcCd());
				customCsulSlpVOs[i].setSlpIssDt(customConsultationVO.getSlpIssDt());
				customCsulSlpVOs[i].setSlpSerNo(slpSerNo);
			}

			invcommand.modifyOwnerAccountExpense(customCsulSlpVOs, usrId);

			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			
			//Ser No. 
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("slp_ser_no",slpSerNo);
			
			//------------------------------
			// 10만불2차 민정호			
			/* 용선인 경우 전표가 승인되면 ERP A/P 로 전송된다
			 * 대선인 경우 전표가 승인되면 ERP A/R 로 전송된다*/					
			String csrNo = customConsultationVO.getSlpTpCd() + 
			          customConsultationVO.getSlpFuncCd() +
			          customConsultationVO.getSlpOfcCd() + 
			          customConsultationVO.getSlpIssDt().replace("-","").substring(2,8) + slpSerNo;
			
			String aproFlgUpdateYn  = "N";			
			if (customConsultationVO.getSlpTpCd().equals("07")) {	//AP
				  String fletCtrtTpCd = "";				
				  command.manageSlipApproval(fletCtrtTpCd, csrNo, "Y", "", account.getUsr_id() ,"","",aproFlgUpdateYn,account.getOfc_cd(), "N", "");
			}	  							  
			//------------------------------			
						
			eventResponse.setETCData(etcData);
			
			commit();
	
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	 }

	/**
	 * Account Code 화면에서 OwnerAccountExpense 정보를 가져온다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOwnerAccountExpenseList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0039Event event = (EsmFms0039Event)e;
	    
		TCharterIOSettlementBC command = new TCharterIOSettlementBCImpl();
	    
		try {
			List<SearchOwnerAccountExpenseListVO > searchOwnerAccountExpenseListVO  = command.searchOwnerAccountExpenseList(event.getCondOwnerAccountExpenseVO());
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchOwnerAccountExpenseListVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }

	/**
	 * Revenue VVD Creation 화면에서 RevenueVvd 정보를 저장한다(입력 / 수정 / 삭제)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRevenueVvd(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	
		EsmFms0037Event event = (EsmFms0037Event)e;
	
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	
		try {
			CustomVvdVO[] customVvdVOs = event.getCustomVvdVOS();
	
			String usrId = account.getUsr_id();
			
			// VVD CD Finalizing From ERP FLAG
			String finalizingFlg =  event.getFinalizingFlg();
	
			begin();
			
			command.manageRevenueVvd(customVvdVOs, usrId, finalizingFlg);
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
	
			commit();
	
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	 }

	/**
	* Revenue VVD Creation 화면에서 RevenueVvd 정보를 조회한다<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchRevenueVvdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0037Event event = (EsmFms0037Event)e;
	    
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {

			List<SearchRevenueVvdListVO> searchRevenueVvdListVO = command.searchRevenueVvdList(event.getRevYrmon(), event.getSlanCd(), event.getRlaneCd());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchRevenueVvdListVO);
			
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
	}

	/**
	* Revenue VVD Creation 화면에서 FinalRevenueVvd 정보를 조회한다<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchFinalRevenueVvdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0037Event event = (EsmFms0037Event)e;
	    
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {

			List<SearchFinalRevenueVvdListVO> searchFinalRevenueVvdListVO = command.searchFinalRevenueVvdList(event.getRevYrmon());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchFinalRevenueVvdListVO);
			
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
	}

	/**
	* Revenue VVD Creation 화면에서 ProcessRevenueVvd 정보를 조회한다<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchProcessRevenueVvdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0037Event event = (EsmFms0037Event)e;
	    
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {

			List<SearchFinalRevenueVvdListVO> searchFinalRevenueVvdListVO = command.searchProcessRevenueVvdList(event.getRevYrmon());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchFinalRevenueVvdListVO);
			
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
	}
	
	/**
	* Revenue VVD Creation 화면에서 VvdCreation 정보를 가져온다<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchVvdCreationList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0037Event event = (EsmFms0037Event)e;
	    
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {

			List<SearchVvdCreationListVO> searchVvdCreationListVO = command.searchVvdCreationList(event.getRevYrmon());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchVvdCreationListVO);
			
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
	}
	
	/**
	 * 계약조회 화면 OPEN시 발생하는 이벤트<br>
	 * Contract Type 정보를 가져온다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContractTypeListByContract(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0023Event event = (EsmFms0023Event)e;
		  
		TCharterIOContractBC command = new TCharterIOContractBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<SearchContractTypeListByContractVO> searchContractTypeListByContractVO = command.searchContractTypeListByContract(event.getTypeFlag());
			
			//fletCtrtTpCd
			StringBuilder sb1 = new StringBuilder();
			
			//fletCtrtTpNm
			StringBuilder sb2 = new StringBuilder();
			
			if(searchContractTypeListByContractVO.size() > 0) {
				for(int i=0; i<searchContractTypeListByContractVO.size(); i++) {
					sb1.append(searchContractTypeListByContractVO.get(i).getCode()+"|");
					sb2.append(searchContractTypeListByContractVO.get(i).getName()+"|");
				}
			}
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("flet_ctrt_tp_cd",sb1.toString());
			etcData.put("flet_ctrt_tp_nm",sb2.toString());
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	* Revenue VVD Inquiry 화면에서 RevenueVvdInquiry 정보를 조회한다<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchRevenueVvdInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0038Event event = (EsmFms0038Event)e;
	    
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {
	
			List<SearchRevenueVvdInquiryListVO> searchRevenueVvdInquiryListVO = command.searchRevenueVvdInquiryList(event.getRevYrmonFrom(), event.getRevYrmonTo(), event.getSlanCd(), event.getRlaneCd());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchRevenueVvdInquiryListVO);
			
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
	}

	/**
	 * Invoice By Owner Account Slip 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceByOwnerAccountSlip(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0039Event event = (EsmFms0039Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TCharterIOSettlementBC command = new TCharterIOSettlementBCImpl();
	
		try{
			List<SearchInvoiceByOwnerAccountSlipVO> searchInvoiceByOwnerAccountSlipVO = command.searchInvoiceByOwnerAccountSlip(event.getFletCtrtNo());
			
			if(searchInvoiceByOwnerAccountSlipVO.size() > 0) {
				Map<String,String> etcData = new HashMap<String,String>();
				
				etcData.put("fletCtrtTpCd",searchInvoiceByOwnerAccountSlipVO.get(0).getFletCtrtTpCd());
				
				eventResponse.setETCData(etcData);
				
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("FMS01316",new String[]{}).getUserMessage());
			}
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * OwnerAccountInterface 정보를 저장한다(입력 / 수정 / 삭제)<br>
	 * 
	 * @param e Event
	 * @exception EventException, Exception
	 */
	private void manageOwnerAccountInterface(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		try{
			begin();
			XmlObject xmlObject = ((EsmFmsFNS0560001Event)e).getXmlObject();
			command.manageOwnerAccountInterface(xmlObject);
			commit();
		} catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

   /**
	* Estimated I/F To ERP(RV) 화면에서 EstimatedRevenue 정보를 가져온다<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchEstimatedRevenueList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0046Event event = (EsmFms0046Event)e;
	    
		TCharterIOEstimatedBC command = new TCharterIOEstimatedBCImpl();
	    
		try {
			
			List<SearchEstimatedRevenueListVO> searchEstimatedRevenueListVO = command.searchEstimatedRevenueList(event.getEstRevMmFrom(), event.getEstRevMmTo(), event.getFletCtrtTpCd(), event.getSeachTpCd());
		
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchEstimatedRevenueListVO);
			
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
	}

	/**
	 * Estimated I/F To ERP(RV) 화면에서 EstimatedRevenue 정보를 생성한다<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse createEstimatedRevenue(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	
		EsmFms0046Event event = (EsmFms0046Event)e;
	
		TCharterIOEstimatedBC command = new TCharterIOEstimatedBCImpl();
	
		try {
			CustomEstmIfVO[] customEstmIfVOs = event.getCustomEstmIfVOS();
	
			String usrId = account.getUsr_id();
	
			begin();
			
			command.createEstimatedRevenue(customEstmIfVOs, account.getOfc_cd() ,usrId);
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
	
			commit();
	
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	 }
	
	/**
	 * Prepayment 정보를 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception
	 */
	private EventResponse searchPrepaymentListByRevenueSlip(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0034Event event = (EsmFms0034Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();

		try {
			List<SearchInvoiceListByRevenueSlipVO> searchInvoiceListByRevenueSlipVO = command.searchPrepaymentListByRevenueSlip(event.getFletCtrtNo(), event.getCurrCd(), account.getOfc_cd());
			eventResponse.setRsVoList(searchInvoiceListByRevenueSlipVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	}

	/**
	 * SubletRevenueSlip 정보를 저장한다(입력 / 수정 / 삭제)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSubletRevenueSlip(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0032Event event = (EsmFms0032Event)e;
		
		TCharterIOConsultationBC tCharterIOConsultationBC = new TCharterIOConsultationBCImpl();
		
		TCharterIOInvoiceBC tCharterIOInvoiceBC = new TCharterIOInvoiceBCImpl();
		
		TCharterIOBunkerRegisterBC tCharterIOBunkerRegisterBC = new TCharterIOBunkerRegisterBCImpl();
		
		try{
			
			begin();
			
			String slpSerNo = tCharterIOConsultationBC.manageSubletRevenueSlip(event.getCustomConsultationVO(), event.getCustomCsulSlpVOS(), account);
			
			event.getCustomCsulSlpSeqVO().setSlpSerNo(slpSerNo);
			
			//===========================================================================			
			// AR-GW결재(201412. 민정호)
			// AR_INV_HDR 저장						
			CustomConsultationVO customConsultationVO = event.getCustomConsultationVO();
			log.debug("customConsultationVO.getSlpTpCd() = "+customConsultationVO.getSlpTpCd());
			log.debug("customConsultationVO.getSlpFuncCd()  = "+customConsultationVO.getSlpFuncCd() );
			log.debug("customConsultationVO.getSlpOfcCd() = "+customConsultationVO.getSlpOfcCd());
			log.debug("customConsultationVO.getSlpIssDt() = "+customConsultationVO.getSlpIssDt());
			log.debug("customConsultationVO.getSlpIssDt().substring(2) = "+customConsultationVO.getSlpIssDt().substring(2));
			log.debug("customConsultationVO.getSlpIssDt().substring(2,8) = "+customConsultationVO.getSlpIssDt().substring(2,8));		
			
			String csrNo = 	customConsultationVO.getSlpTpCd() +
									customConsultationVO.getSlpFuncCd() +
									customConsultationVO.getSlpOfcCd() +
									customConsultationVO.getSlpIssDt().substring(2) +									
									slpSerNo;
			
			//CSR No.
			Map<String,String> etcData = new HashMap<String,String>();
			etcData.put("ar_csr_no", csrNo);			
			eventResponse.setETCData(etcData);
			
			tCharterIOConsultationBC.manageArInvHdr(csrNo, account.getUsr_id());
			//===========================================================================
			
			// Invoice 테이블 업테이트
			tCharterIOInvoiceBC.modifySubletRevenueSlip(event.getCustomCsulSlpVOS());
			
			// Bunker 테이블 업테이트
			tCharterIOBunkerRegisterBC.modifySubletRevenueSlip(event.getCustomCsulSlpVOS());
			
			List<SearchSubletRevenueSlipListVO> searchSubletRevenueSlipListVO = tCharterIOConsultationBC.searchSubletRevenueSlipList(event.getCustomCsulSlpSeqVO());
			
			eventResponse.setRsVoList(searchSubletRevenueSlipListVO);
			
			eventResponse.setUserMessage(new ErrorHandler("FMS00001").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Estimated I/F To ERP(PV) 화면에서 EstimatedProRevenue 정보를 생성한다<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse createEstimatedProRevenue(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	
		EsmFms0048Event event = (EsmFms0048Event)e;
	
		TCharterIOEstimatedBC command = new TCharterIOEstimatedBCImpl();
	
		try {
			CustomEstmIfVO[] customEstmIfVOs = event.getCustomEstmIfVOS();
	
			String usrId = account.getUsr_id();
	
			begin();
			
			command.createEstimatedProRevenue(customEstmIfVOs, account.getOfc_cd() ,usrId);
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
	
			commit();
	
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	 }

   /**
	* Estimated I/F To ERP(PV) 화면에서 EstimatedProRevenue 정보를 조회한다<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchEstimatedProRevenueList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0048Event event = (EsmFms0048Event)e;
	    
		TCharterIOEstimatedBC command = new TCharterIOEstimatedBCImpl();
	    
		try {
	
			List<SearchEstimatedProRevenueListVO> searchEstimatedProRevenueListVO = command.searchEstimatedProRevenueList(event.getEstRevMm());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchEstimatedProRevenueListVO);
			
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
	}

   /**
	* Estimated I/F To ERP(RV) 화면에서 EstimatedHireResult 정보를 조회한다<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchEstimatedHireResultList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0049Event event = (EsmFms0049Event)e;
	    
		TCharterIOEstimatedBC command = new TCharterIOEstimatedBCImpl();
	    
		try {
	
			List<SearchEstimatedHireResultListVO> searchEstimatedHireResultListVO = command.searchEstimatedHireResultList(event.getEstRevMmFrom(), event.getEstRevMmTo(), event.getFletCtrtTpCd());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchEstimatedHireResultListVO);
			
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
	}
	
	/**
	 * VMS에서 용선선박 용선료를 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselCodeHireInterface(Event e) throws EventException {
		// 반환 객체 생성
        GeneralEventResponse eventResponse = new GeneralEventResponse();
	
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		XmlObject xmlObject = ((EsmFmsVMS0010001Event)e).getXmlObject();
		
		Map<String,String> etcData = new HashMap<String,String>();

		try {
			// XML Parse
			VMS0010001Document doc = (VMS0010001Document)xmlObject;
			VMS0010001 sync = doc.getVMS0010001();
			VMS0010001Document.VMS0010001.DataArea data = sync.getDataArea();
			VMS0010001Document.VMS0010001.DataArea.RequestMessage reqMsg = data.getRequestMessage();
			
			String vslCd = reqMsg.getVSLCD();
			String effDt = reqMsg.getHIREDATE();
			String hireAmt = command.searchVesselCodeHireInterface(vslCd, effDt);

			etcData.put("hireAmt", hireAmt);
			eventResponse.setETCData(etcData);

		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * VMS에서 CDAM 정산 데이터를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselCodeInvoiceInterface(Event e) throws EventException {
		// 반환 객체 생성
        GeneralEventResponse eventResponse = new GeneralEventResponse();
	
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		XmlObject xmlObject = ((EsmFmsVMS0020001Event)e).getXmlObject();

		try {
			// XML Parse
			VMS0020001Document doc = (VMS0020001Document)xmlObject;
			VMS0020001 sync = doc.getVMS0020001();
			VMS0020001Document.VMS0020001.DataArea data = sync.getDataArea();
			VMS0020001Document.VMS0020001.DataArea.RequestMessage reqMsg = data.getRequestMessage();
			
			String vslCd = reqMsg.getVSLCD();
			String effDt = reqMsg.getINVSTDD();
			String expDt = reqMsg.getINVENDDD();

			List<SearchVesselCodeInvoiceInterfaceVO> searchVesselCodeInvoiceInterfaceVO = command.searchVesselCodeInvoiceInterface(vslCd, effDt, expDt);

			eventResponse.setRsVoList(searchVesselCodeInvoiceInterfaceVO);

		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * 용/대선 선박 관련 Created된 Revenue Port를 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRevenuePortList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0068Event event = (EsmFms0068Event)e;
		
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {
			List<SearchRevenuePortListVO> searchRevenuePortListVO = command.searchRevenuePortList(event.getSlanCd(), event.getRLaneCd());
			eventResponse.setRsVoList(searchRevenuePortListVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Revenue Port 자료를 ERP에서 가지고 온다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse receiveRevenuePort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {
			List<ReceiveRevenuePortVO> receiveRevenuePortVO = command.receiveRevenuePort();
			eventResponse.setRsVoList(receiveRevenuePortVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Revenue Port를 전체 삭제한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeAllRevenuePort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
	    
		try {
			begin();
			command.removeAllRevenuePort();
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Revenue Port를 변경한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRevenuePort(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0068Event event = (EsmFms0068Event)e;
		
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
		
		try {
			begin();
			if(event.getSearchType().equals("interface")) {
				command.removeAllRevenuePort();
			}
			command.manageRevenuePort(event.getCustomBsePortVOS(),account.getUsr_id());
			eventResponse = (GeneralEventResponse)searchRevenuePortList(e);
			eventResponse.setUserMessage(new ErrorHandler("FMS00001").getUserMessage());
			commit();
		} catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 자발적, 비자발적 오류 처리할 전표에 대한 취소 작업 진행한다<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageInterfaceStatus(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	
		EsmFms0053Event event = (EsmFms0053Event)e;
	
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
	
		try {
	
			CustomInterfaceStatusVO[] customInterfaceStatusVOs = event.getCustomInterfaceStatusVOS();
	
			String usrId = account.getUsr_id();
			String aproStep = event.getAproStep();
	
			begin();
			
			command.manageInterfaceStatus(customInterfaceStatusVOs, event.getStatusFlag(), account, aproStep);
			
			TCharterIOInvoiceBC invcommand = new TCharterIOInvoiceBCImpl();
			invcommand.modifyInterfaceStatusInvoice(customInterfaceStatusVOs[0], usrId);

			//용선 전표가 취소 되면 Owner's Account 에 전표번호가 Null 로 변경된다
			invcommand.modifySlipApprovalCancelOwnerAccount(event.getCsrNo(), usrId);

			TCharterIOBunkerRegisterBC bnkcommand = new TCharterIOBunkerRegisterBCImpl();
			//용선인 경우 전표가 취소되면 Bunker의 전표 정보도 Null 로 업데이트된다
			bnkcommand.modifySlipApprovalCancelBunker(event.getCsrNo(), usrId);

			eventResponse = (GeneralEventResponse)searchInterfaceStatusList(e);

			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
	
			commit();
	
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	 }

   /**
	* 자발적, 비자발적 오류 처리할 전표를 조회한다<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchInterfaceStatusList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0053Event event = (EsmFms0053Event)e;
	    
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
	    
		try {
	
			List<SearchInterfaceStatusListVO> searchInterfaceStatusListVO = command.searchInterfaceStatusList(event.getCondSearchInterfaceStatusVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchInterfaceStatusListVO);
			
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
	}

   /**
	* 자발적, 비자발적 오류 처리할 전표를 계정별 조회한다<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchInterfaceStatusDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0053Event event = (EsmFms0053Event)e;
	    
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
	    
		try {
	
			List<SearchInterfaceStatusDetailListVO> searchInterfaceStatusDetailListVO = command.searchInterfaceStatusDetailList(event.getCsrNo());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchInterfaceStatusDetailListVO);
			
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
	}

	/**
	 * Prepayments Settlement 화면에서 데이타 저장<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse managePrepaymentSettlement(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		ExternalFinderBC etfCmd = new ExternalFinderBCImpl();
	
		EsmFms0035Event event = (EsmFms0035Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
	
		try {
			CustomConsultationVO customConsultationVO = event.getCustomConsultationVO();
			CustomCsulSlpVO[] customCsulSlpVOs = event.getCustomCsulSlpVOS();
	
			begin();
			
			//항차레벨을 체크 및 신계약번호 구계약번호를 판단하여 신계약번호 대신 구계약번호를 VO에 재설정한다 
			for (int i=0; i<customCsulSlpVOs.length; i++) {
				//항차레벨을 체크

				if(   customCsulSlpVOs[i].getVvdCd() != null 
				   && !customCsulSlpVOs[i].getVvdCd().equals("")) {
					
					String level = etfCmd.checkAcctCdVvdLevel(customCsulSlpVOs[i].getAcctCd(), customCsulSlpVOs[i].getVvdCd());
					if (!level.equals("2")) {	
						throw new EventException(new ErrorHandler("FMS01478",new String[]{customCsulSlpVOs[i].getAcctCd(), customCsulSlpVOs[i].getVvdCd()}).getMessage());
					}
				}
			}
			   
			//Consultation 3개 테이블 저장
			String slpSerNo = command.managePrepaymentSettlement(customConsultationVO, customCsulSlpVOs, account);
	
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			
			//Ser No. 
			Map<String,String> etcData = new HashMap<String,String>();
	
			etcData.put("slp_ser_no",slpSerNo);
			
			//------------------------------
			// 10만불2차 민정호			
			/* 용선인 경우 전표가 승인되면 ERP A/P 로 전송된다
			 * 대선인 경우 전표가 승인되면 ERP A/R 로 전송된다*/
			
			String csrNo = customConsultationVO.getSlpTpCd() + 
						          customConsultationVO.getSlpFuncCd() +
						          customConsultationVO.getSlpOfcCd() + 
						          customConsultationVO.getSlpIssDt().replace("-","").substring(2,8) + slpSerNo; 			
			
			 String aproFlgUpdateYn = "N";			 
			  if (customConsultationVO.getSlpTpCd().equals("07")) {	//AP
				  String fletCtrtTpCd = "";				  
				  command.manageSlipApproval(fletCtrtTpCd, csrNo, "Y", "", account.getUsr_id() ,"","", aproFlgUpdateYn,account.getOfc_cd(), "", "");
			  }	
			//------------------------------				
			
			eventResponse.setETCData(etcData);
			
			commit();
	
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	 }

	/**
	 * Owner Account to Expense 화면에서  계약번호의 연관된 Contract Type, Vendor Code, Vendor Name 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceByPaymentSlip(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0035Event event = (EsmFms0035Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
	
		try{
			List<SearchInvoiceByPaymentSlipVO> searchInvoiceByPaymentSlipVO = command.searchInvoiceByPaymentSlip(event.getFletCtrtNo());
			List<SearchInvoiceByPaymentSlipVO> searchInvoiceByPaymentSlipVO2 = command.searchInvoiceByPaymentSlip2(event.getFletCtrtNo());
			if(searchInvoiceByPaymentSlipVO.size() > 0) {
				//Contract Code Search 팝업의 Contract Type값
				if (searchInvoiceByPaymentSlipVO.get(0).getFletCtrtTpCd().equals("T/C Out") && !searchInvoiceByPaymentSlipVO2.get(0).getVndrSeq().equals("")) {
					Map<String,String> etcData = new HashMap<String,String>();
					etcData.put("fletCtrtTpCd",searchInvoiceByPaymentSlipVO2.get(0).getFletCtrtTpCd());
					etcData.put("vndrSeq",searchInvoiceByPaymentSlipVO2.get(0).getVndrSeq());
					etcData.put("vndrNm",searchInvoiceByPaymentSlipVO2.get(0).getVndrLglEngNm());
					etcData.put("custCntCd",searchInvoiceByPaymentSlipVO2.get(0).getCustCntCd());
					etcData.put("custSeq",searchInvoiceByPaymentSlipVO2.get(0).getCustSeq());
					eventResponse.setETCData(etcData);
				} else {
					Map<String,String> etcData = new HashMap<String,String>();
					etcData.put("fletCtrtTpCd",searchInvoiceByPaymentSlipVO.get(0).getFletCtrtTpCd());
					etcData.put("vndrSeq",searchInvoiceByPaymentSlipVO.get(0).getVndrSeq());
					etcData.put("vndrNm",searchInvoiceByPaymentSlipVO.get(0).getVndrLglEngNm());
					etcData.put("custCntCd",searchInvoiceByPaymentSlipVO.get(0).getCustCntCd());
					etcData.put("custSeq",searchInvoiceByPaymentSlipVO.get(0).getCustSeq());
					eventResponse.setETCData(etcData);
				}
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("FMS01505",new String[]{}).getUserMessage());
			}
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}

   /**
	* 미 정리된 선급금 전표를 조회한다<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchPrepaymentSettleList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0074Event event = (EsmFms0074Event)e;
	    
		TCharterIOSettlementBC command = new TCharterIOSettlementBCImpl();
	    
		try {
			List<SearchPrepaymentSettleListVO > searchPrepaymentSettleListVO  = command.searchPrepaymentSettleList(event.getCondSearchPrepaymentSettleVO(), event.getSignOnUserAccount());
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchPrepaymentSettleListVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }

	/**
	* 조건에 해당하는 모든 미 정리된 선급금 전표를 조회한다<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchPrepaymentSettleListAll(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0094Event event = (EsmFms0094Event)e;
	    
		TCharterIOSettlementBC command = new TCharterIOSettlementBCImpl();
	    
		try {
			List<CondSearchPrepaymentSettleListVO> searchPrepaymentSettleListVO  = command.searchPrepaymentSettleListAll(event.getCondSearchPrepaymentSettleListVO(), event.getSignOnUserAccount());
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			eventResponse.setRsVoList(searchPrepaymentSettleListVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
		
   /**
	* 미 정리된 선급금 전표를 항차별로 분리한다<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchPrepaymentSettleVvdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0074Event event = (EsmFms0074Event)e;
	    
		TCharterIOSettlementBC command = new TCharterIOSettlementBCImpl();
	    
		try {
			List<SearchPrepaymentSettleVvdListVO > searchPrepaymentSettleVvdListVO  = command.searchPrepaymentSettleVvdList(event.getCondSearchPrepaymentSettleVvdVO());
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			if (searchPrepaymentSettleVvdListVO.size() > 0) {
				//항차가 존재하지 않음
				if (searchPrepaymentSettleVvdListVO.get(0).getVvdCd().equals("NOVVD")) {
					eventResponse.setUserMessage((String) new ErrorHandler("FMS01509",new String[]{}).getUserMessage());
				//불연속 항차
				} else if (searchPrepaymentSettleVvdListVO.get(0).getVvdCd().equals("DISVVD")) {
					eventResponse.setUserMessage((String) new ErrorHandler("FMS01510",new String[]{}).getUserMessage());
				} else {
					eventResponse.setRsVoList(searchPrepaymentSettleVvdListVO);
				}
			}
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }

   /**
	* 미 정리된 선급금 전표를 항차별로 분리한다<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchPrepaymentSettleVvdListMulti(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0094Event event = (EsmFms0094Event)e;
	    
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		// Search
		TCharterIOSettlementBC command = new TCharterIOSettlementBCImpl();
	    
		// Creation
		ExternalFinderBC etfCmd = new ExternalFinderBCImpl();
		TCharterIOConsultationBC command2 = new TCharterIOConsultationBCImpl();
		
		try {
			CustomConsultationVO customConsultationVO = null; // 전표 메인
			CustomCsulSlpVO[] customCsulSlpVOs = null; // 전표 상세
			
			List<SearchPrepaymentSettleVvdListVO> searchPrepaymentSettleVvdListVO = null; // 항차별로 분리한 전표목록
			
			List<CondSearchPrepaymentSettleListVO> rsList = new ArrayList<CondSearchPrepaymentSettleListVO>(); // Creation 하고 리턴받을 목록
			CondSearchPrepaymentSettleListVO rsVO = null;
			
			CondSearchPrepaymentSettleVvdVO[] condSearchPrepaymentSettleVvdVOs = event.getCondSearchPrepaymentSettleVvdVOS(); // 미 정리 선급금 전표조회를 위한 파라미터
			
			List<SearchPrepaymentSettleVvdAmountVO> amountVO = new ArrayList<SearchPrepaymentSettleVvdAmountVO>(); // 계정별 비용 합계 리턴 받을 목록(FMS_INS_DTL)
			List<SearchPrepaymentSettleVvdAmountByAccountListVO> amtByAcctVO = new ArrayList<SearchPrepaymentSettleVvdAmountByAccountListVO>(); // 항차별로 분리한 전표목록 중 계정별 csr_amt합계 
			
			Map<String, Integer> acctIdx = null;
			
			String aproStep = event.getAproStep();
			String slpIssDt = event.getSlpIssDt();
			String effDt = event.getEffDt();
			String pPayHirNo = "";
			String tmpCsrDesc = "";
			
			/* DR Amount */
			double drAmt = 0d;
			/* CR Amount */
			double crAmt = 0d;

			/* Temp Amount */
			double tmpAmt = 0d;
			
			for (int i = 0; i < condSearchPrepaymentSettleVvdVOs.length; i++) {
				condSearchPrepaymentSettleVvdVOs[i].setEffDt(effDt);
				searchPrepaymentSettleVvdListVO = command.searchPrepaymentSettleVvdList(condSearchPrepaymentSettleVvdVOs[i]);
				
				amountVO = command.searchPrepaymentSettleVvdAmount(condSearchPrepaymentSettleVvdVOs[i]);
				amtByAcctVO = command.searchPrepaymentSettleVvdAmountByAccount(condSearchPrepaymentSettleVvdVOs[i]);
				
				acctIdx = new HashMap<String, Integer>();
				
				customConsultationVO = new CustomConsultationVO();
				customCsulSlpVOs = new CustomCsulSlpVO[searchPrepaymentSettleVvdListVO.size()];
				
				rsVO = new CondSearchPrepaymentSettleListVO();
				
				//항차가 존재하지 않음
				if (searchPrepaymentSettleVvdListVO.get(0).getVvdCd().equals("NOVVD")) {
					rsVO.setOrgSlipNo(condSearchPrepaymentSettleVvdVOs[i].getOrgSlipNo());
					rsVO.setRsRemark((String) new ErrorHandler("FMS01509", new String[]{}).getUserMessage());
					rsList.add(rsVO);
					
				//불연속 항차
				} else if (searchPrepaymentSettleVvdListVO.get(0).getVvdCd().equals("DISVVD")) {
					rsVO.setOrgSlipNo(condSearchPrepaymentSettleVvdVOs[i].getOrgSlipNo());
					rsVO.setRsRemark((String) new ErrorHandler("FMS01510", new String[]{}).getUserMessage());
					rsList.add(rsVO);
					
				//항차별 조회전표
				} else {

					for(int j = 0; j < searchPrepaymentSettleVvdListVO.size(); j ++){
						SearchPrepaymentSettleVvdListVO settleVvdListVO = searchPrepaymentSettleVvdListVO.get(j);
						customCsulSlpVOs[j] = new CustomCsulSlpVO();
						if(j == 0){
							customConsultationVO.setAproStep(aproStep);
							customConsultationVO.setCsrCurrCd(condSearchPrepaymentSettleVvdVOs[i].getCsrCurrCd());
							customConsultationVO.setCsrDesc("Hire Settlement " + condSearchPrepaymentSettleVvdVOs[i].getVslCd() + " " + effDt.substring(0, 7));
							customConsultationVO.setEffDt(effDt);
							customConsultationVO.setFletCtrtNo(condSearchPrepaymentSettleVvdVOs[i].getFletCtrtNo());
							customConsultationVO.setPpayHirNo(condSearchPrepaymentSettleVvdVOs[i].getPpayHirNo());
							customConsultationVO.setSlpFuncCd("S");
							customConsultationVO.setSlpIssDt(slpIssDt);
							customConsultationVO.setSlpOfcCd(account.getOfc_cd());
							customConsultationVO.setSlpTpCd(settleVvdListVO.getOrgSlpTpCd());
							customConsultationVO.setVndrSeq(settleVvdListVO.getVndrSeq());
							
							customConsultationVO.setRqstAmt("");

							customCsulSlpVOs[j].setAcctCd(settleVvdListVO.getAcctCd());
							customCsulSlpVOs[j].setCsrAmt(settleVvdListVO.getCsrAmt());
							customCsulSlpVOs[j].setCsrDesc(settleVvdListVO.getCsrDesc());
							customCsulSlpVOs[j].setCtrCd(settleVvdListVO.getCtrCd());
							customCsulSlpVOs[j].setInvSeq(settleVvdListVO.getInvSeq());
							customCsulSlpVOs[j].setOrgSlpFuncCd(settleVvdListVO.getOrgSlpFuncCd());
							customCsulSlpVOs[j].setOrgSlpIssDt(settleVvdListVO.getOrgSlpIssDt());
							customCsulSlpVOs[j].setOrgSlpOfcCd(settleVvdListVO.getOrgSlpOfcCd());
							customCsulSlpVOs[j].setOrgSlpSeqNo(settleVvdListVO.getOrgSlpSeqNo());
							customCsulSlpVOs[j].setOrgSlpSerNo(settleVvdListVO.getOrgSlpSerNo());
							customCsulSlpVOs[j].setOrgSlpTpCd(settleVvdListVO.getOrgSlpTpCd());
							customCsulSlpVOs[j].setSlpKeyNo(settleVvdListVO.getSlpKeyNo());
							customCsulSlpVOs[j].setSlpLocCd(settleVvdListVO.getSlpLocCd());
							customCsulSlpVOs[j].setSlpSeqNo(settleVvdListVO.getOrgSlpSeqNo());
							customCsulSlpVOs[j].setTrnsAmt(settleVvdListVO.getTrnsAmt());
							customCsulSlpVOs[j].setVndrSeq(settleVvdListVO.getVndrSeq());
							customCsulSlpVOs[j].setVvdEffDt(settleVvdListVO.getStartDt());
							customCsulSlpVOs[j].setVvdExpDt(settleVvdListVO.getEndDt());
							
							crAmt = Double.parseDouble(customCsulSlpVOs[j].getCsrAmt());
							log.debug(">>" + settleVvdListVO.getAcctCd() + " >> " + j + " Amount : " + settleVvdListVO.getCsrAmt());
							
						}else{
							customCsulSlpVOs[j].setAcctCd(settleVvdListVO.getAcctCd());
							customCsulSlpVOs[j].setCsrAmt(settleVvdListVO.getCsrAmt());
							if(!"".equals(settleVvdListVO.getVvdCd())) {
								// 회차구분
								pPayHirNo = condSearchPrepaymentSettleVvdVOs[i].getPpayHirNo();
								if(pPayHirNo.length() != 2 && "1".equals(pPayHirNo.substring(pPayHirNo.length() - 1))){
									tmpCsrDesc = " " + settleVvdListVO.getVvdCd().substring(0, 4) + " " + pPayHirNo + "st (" + settleVvdListVO.getStartDt() + " ~ " + settleVvdListVO.getEndDt() + ")";
									
								}else if(pPayHirNo.length() != 2 && "2".equals(pPayHirNo.substring(pPayHirNo.length() - 1))){
									tmpCsrDesc = " " + settleVvdListVO.getVvdCd().substring(0, 4) + " " + pPayHirNo + "nd (" + settleVvdListVO.getStartDt() + " ~ " + settleVvdListVO.getEndDt() + ")";
									
								}else if(pPayHirNo.length() != 2 && "3".equals(pPayHirNo.substring(pPayHirNo.length() - 1))){
									tmpCsrDesc = " " + settleVvdListVO.getVvdCd().substring(0, 4) + " " + pPayHirNo + "rd (" + settleVvdListVO.getStartDt() + " ~ " + settleVvdListVO.getEndDt() + ")";
									
								}else {
									tmpCsrDesc = " " + settleVvdListVO.getVvdCd().substring(0, 4) + " " + pPayHirNo + "th (" + settleVvdListVO.getStartDt() + " ~ " + settleVvdListVO.getEndDt() + ")";
									
								}
								
							}else{
								tmpCsrDesc = "";
							}
							customCsulSlpVOs[j].setCsrDesc(settleVvdListVO.getCsrDesc() + tmpCsrDesc);
							customCsulSlpVOs[j].setCtrCd(settleVvdListVO.getCtrCd());
							customCsulSlpVOs[j].setInvSeq(settleVvdListVO.getInvSeq());
							customCsulSlpVOs[j].setLsgGrNo(settleVvdListVO.getSlpKeyNo());									
							customCsulSlpVOs[j].setSlpKeyNo(settleVvdListVO.getSlpKeyNo());
							customCsulSlpVOs[j].setSlpLocCd(settleVvdListVO.getSlpLocCd());
							customCsulSlpVOs[j].setSlpSeqNo(settleVvdListVO.getOrgSlpSeqNo());
							customCsulSlpVOs[j].setTrnsAmt(settleVvdListVO.getTrnsAmt());
							customCsulSlpVOs[j].setVndrSeq(settleVvdListVO.getVndrSeq());
							customCsulSlpVOs[j].setVvdCd(settleVvdListVO.getVvdCd());
							customCsulSlpVOs[j].setVvdEffDt(settleVvdListVO.getStartDt());
							customCsulSlpVOs[j].setVvdExpDt(settleVvdListVO.getEndDt());
							drAmt += Double.parseDouble(customCsulSlpVOs[j].getCsrAmt());
							log.debug(">>" + settleVvdListVO.getAcctCd() + " >> " + j + " Amount : " + settleVvdListVO.getCsrAmt());

							acctIdx.put(settleVvdListVO.getAcctCd(), j); // 계정별 마지막 인덱스를 저장한다.
						}
					}// for end
					log.debug("acctIdx.toString() >>> " + acctIdx.toString());
					log.debug("drAmt : " + drAmt + " | crAmt : " + (crAmt*-1) + " = " + Double.parseDouble(String.format("%.2f", ((crAmt*-1) - drAmt))) + " 이 차이남| 현재 searchPrepaymentSettleVvdListVO[" + i + "]");

					// DR and CR diff check 
					if((crAmt * -1) - drAmt < 1){
						// 계정별 diff check하고 보정
						for(int l = 0; l < amountVO.size(); l ++){
							tmpAmt = Double.parseDouble(amountVO.get(l).getInvAmt());
							
							for(int m = 0; m < amtByAcctVO.size(); m ++){
								if(amountVO.get(l).getAcctCd().equalsIgnoreCase(amtByAcctVO.get(m).getAcctCd())){
									tmpAmt = tmpAmt - Double.parseDouble(amtByAcctVO.get(m).getCsrAmt());
									if(tmpAmt != 0){
										log.debug(amtByAcctVO.get(m).getAcctCd() + " 계정 비용 합계와 차이 발생 : " + String.format("%.2f", tmpAmt) + " | last idx : " + acctIdx.get(amtByAcctVO.get(m).getAcctCd()) + " > " 
												+ Double.parseDouble(customCsulSlpVOs[acctIdx.get(amtByAcctVO.get(m).getAcctCd())].getCsrAmt()) + " + " + Double.parseDouble(String.format("%.2f", tmpAmt)) );
										
										tmpAmt = (Double.parseDouble(customCsulSlpVOs[acctIdx.get(amtByAcctVO.get(m).getAcctCd())].getCsrAmt()) + Double.parseDouble(String.format("%.2f", tmpAmt)));
										customCsulSlpVOs[acctIdx.get(amtByAcctVO.get(m).getAcctCd())].setCsrAmt(String.valueOf( tmpAmt ));
										
										log.debug(" = " + tmpAmt);
									}
								}
							}// for end
						}// for end
						
					}else if((crAmt * -1) - drAmt >= 1){
						log.debug("DR / CR Amount가 1이상 차이발생");
						rsVO.setOrgSlipNo(condSearchPrepaymentSettleVvdVOs[i].getOrgSlipNo());
						rsVO.setRsRemark("diff Amount Error");
						rsList.add(rsVO);
						continue;
					}
					drAmt = 0; //초기화
					crAmt = 0;
					// 전표 저장 시작
					begin();
					
					//항차레벨을 체크 및 신계약번호 구계약번호를 판단하여 신계약번호 대신 구계약번호를 VO에 재설정한다 
					for (int k = 0; k < customCsulSlpVOs.length; k ++) {
						//항차레벨을 체크
						if(customCsulSlpVOs[k].getVvdCd() != null && !customCsulSlpVOs[k].getVvdCd().equals("")) {
							String level = etfCmd.checkAcctCdVvdLevel(customCsulSlpVOs[k].getAcctCd(), customCsulSlpVOs[k].getVvdCd());
							
							if (!level.equals("2")) {	
								throw new EventException(new ErrorHandler("FMS01478",new String[]{customCsulSlpVOs[k].getAcctCd(), customCsulSlpVOs[k].getVvdCd()}).getMessage());
							}
						}
					}
					
					//Consultation 3개 테이블 저장
					String slpSerNo = command2.managePrepaymentSettlement(customConsultationVO, customCsulSlpVOs, account);
					
					eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
					
					//------------------------------
					// 10만불2차 민정호			
					/* 용선인 경우 전표가 승인되면 ERP A/P 로 전송된다
					 * 대선인 경우 전표가 승인되면 ERP A/R 로 전송된다*/
					String csrNo = customConsultationVO.getSlpTpCd() + 
							customConsultationVO.getSlpFuncCd() +
							customConsultationVO.getSlpOfcCd() + 
							customConsultationVO.getSlpIssDt().replace("-","").substring(2,8) + slpSerNo; 			
					
					String aproFlgUpdateYn = "N";			 
					if (customConsultationVO.getSlpTpCd().equals("07")) {	//AP
						String fletCtrtTpCd = "";				  
						command2.manageSlipApproval(fletCtrtTpCd, csrNo, "Y", "", account.getUsr_id() ,"","", aproFlgUpdateYn,account.getOfc_cd(), "", "");
					}	
					//------------------------------
					rsVO.setOrgSlipNo(condSearchPrepaymentSettleVvdVOs[i].getOrgSlipNo());
					rsVO.setNewCsrNo(csrNo);
					rsVO.setRsRemark("");
					
					rsList.add(rsVO);
					
					commit();

				}// if end
			}// for end
			
			eventResponse.setRsVoList(rsList);

			return eventResponse;
	
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	 }

	/**
	 * Multi Prepayment Settlement 에서 Inquiry 조건에 해당하는 전표 목록을 가져온다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception
	 */
	private EventResponse searchPrepaymentSettlementInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0094Event event = (EsmFms0094Event)e;
		
		TCharterIOSettlementBC command = new TCharterIOSettlementBCImpl();

		try {
			List<SearchMultiPrepaymentSettlementInquiryListVO> searchMultiPrepaymentSettlementInquiryListVO = command.searchPrepaymentSettlementInquiryList(event.getCondSearchPrepaymentSettleListVO(), account);
			eventResponse.setRsVoList(searchMultiPrepaymentSettlementInquiryListVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	/**
	 * 작성된 채권에 대한 채권 계상액 History 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubletReveuneList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0045Event event = (EsmFms0045Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
	    
		try {
			List<SearchSubletRevenueListVO> searchSubletRevenueListVO = command.searchSubletReveuneList(event.getCondSearchSebletRevenueVO());
			eventResponse.setRsVoList(searchSubletRevenueListVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 작성된 채권에 대한 채권 계상액 History 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubletReveuneDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0045Event event = (EsmFms0045Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
	    
		try {
			List<SearchSubletReveuneDetailListVO> searchSubletReveuneDetailListVO = command.searchSubletReveuneDetailList(event.getToInvNo());
			eventResponse.setRsVoList(searchSubletReveuneDetailListVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * OffHire Expense Interface정보를 저장한다(입력 / 수정 / 삭제)<br>
	 * 
	 * @param e Event
	 * @exception EventException, Exception
	 */
	private void manageOffHireExpenseInterface(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		try{
			begin();
			XmlObject xmlObject = ((EsmFmsESM0660001Event)e).getXmlObject();
			command.manageOffHireExpenseInterface(xmlObject);
			commit();
		} catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Slip Approval 정보를 가져온다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception
	 */
	private EventResponse searchSlipApprovalList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0093Event event = (EsmFms0093Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();

		try {
			List<SearchSlipApprovalListVO> searchSlipApprovalListVO = command.searchSlipApprovalList(event.getCondSearchSlipApprovalVO(), account.getUsr_id());
			eventResponse.setRsVoList(searchSlipApprovalListVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	/**
	 * Submit to GW 정보를 가져온다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception
	 */
	private EventResponse searchSlipSubmitToGWList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0052Event event = (EsmFms0052Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();

		try {
			List<SearchSlipApprovalListVO> searchSlipApprovalListVO = command.searchSlipSubmitToGWList(event.getCondSearchSlipApprovalVO());
			eventResponse.setRsVoList(searchSlipApprovalListVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	/**
	 * Slip Inquiry 정보를 가져온다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception
	 */
	private EventResponse searchSlipInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0041Event event = (EsmFms0041Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();

		try {
			List<SearchSlipApprovalListVO> searchSlipApprovalListVO = command.searchSlipInquiryList(event.getCondSearchSlipApprovalVO());
			eventResponse.setRsVoList(searchSlipApprovalListVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	/**
	 * 기 결제된 채권번호를 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceNoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms00331Event event = (EsmFms00331Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
	    
		try {
			List<SearchInvoiceNoListVO> searchInvoiceNoListVO = command.searchInvoiceNoList(event.getCondSearchInvoiceNoVO());
			eventResponse.setRsVoList(searchInvoiceNoListVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Slip Detail 정보를 가져온다 <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception
	 */
	private EventResponse searchSlipDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0042Event event = (EsmFms0042Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
		
		try {
			List<SearchSlipDetailListVO> searchSlipDetailListVO = command.searchSlipDetailList(event.getCsrNo());
			eventResponse.setRsVoList(searchSlipDetailListVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	/**
	 * SlipCorrection Master 정보를 가져온다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception
	 */
	private EventResponse searchSlipCorrectionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0043Event event = (EsmFms0043Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
		
		try {
			List<SearchSlipCorrectionListVO> searchSlipCorrectionListVO = command.searchSlipCorrectionList(event.getCondSearchSlipApprovalVO());
			eventResponse.setRsVoList(searchSlipCorrectionListVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	}
	
	/**
	 * Slip Correction 에서 Slip Master 의 Description 를 수정한다<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse modifySlipCorrection(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0043Event event = (EsmFms0043Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
		
		try {
			
			String usrId = account.getUsr_id();

			begin();
			command.modifySlipCorrection(event.getCsrNo(), event.getCsrDesc(), usrId);
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * SlipCorrectionDetail 정보를 가져온다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception
	 */
	private EventResponse searchSlipCorrectionDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0044Event event = (EsmFms0044Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
		
		try {
			List<SearchSlipCorrectionDetailListVO> searchSlipCorrectionDetailListVO = command.searchSlipCorrectionDetailList(event.getCsrNo());
			eventResponse.setRsVoList(searchSlipCorrectionDetailListVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	}

	/**
	 * ReverseCsrForSublet 정보를 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception
	 */
	private EventResponse searchReverseCsrForSubletList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0033Event event = (EsmFms0033Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();

		try {
			List<SearchReverseCsrForSubletListVO> searchReverseCsrForSubletListVO = command.searchReverseCsrForSubletList(event.getCondReverseCsrForSubletVO());
			eventResponse.setRsVoList(searchReverseCsrForSubletListVO);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * Slip Correction 에서 Slip Detail 의 Description 를 수정한다<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse modifySlipDetailCorrection(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0044Event event = (EsmFms0044Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
		
		try {
			
			CustomCsulSlpVO[] customCsulSlpVOs = event.getCustomCsulSlpVOS();
			
			String csrNo = event.getCsrNo();
			String usrId = account.getUsr_id();

			begin();
			command.modifySlipDetailCorrection(customCsulSlpVOs, csrNo, usrId);
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
   /**
	* Bunker Price 를 Interface 해 온다<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchBunkerPriceInterfaceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0071Event event = (EsmFms0071Event)e;
	    
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    
		try {
			
			List<SearchBunkerPriceInterfaceListVO> searchBunkerPriceInterfaceListVO = command.searchBunkerPriceInterfaceList(event.getLocCd(), event.getFromDt(), event.getToDt());
	
			eventResponse.setRsVoList(searchBunkerPriceInterfaceListVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
	
	/**
	 * Bunker Vvd 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse checkVvdCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0021Event event = (EsmFms0021Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
	
		try{
			String bunkerVvd = command.checkVvdCode(event.getBunkerVvd());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("bunkerVvd",bunkerVvd);
			
			eventResponse.setETCData(etcData);
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
    
    /**
	 * Center Code 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse checkCenterCode(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0021Event event = (EsmFms0021Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
	
		try{
			String slpLocCd = command.checkCenterCode(event.getCtrCd());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("slpLocCd",slpLocCd);
			
			eventResponse.setETCData(etcData);
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
    
   /**
	* 품의되지 않은 선급금 대상 자료를 조회한다<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchPrepaymentListByPaymentSlip(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0024Event event = (EsmFms0024Event)e;
	    
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    
		try {
			
			List<SearchPrepaymentListByPaymentSlipVO> searchPrepaymentListByPaymentSlipVO = command.searchPrepaymentListByPaymentSlip(event.getFletCtrtNo(), event.getOfcCd(), event.getCsrCurrCd());
	
			eventResponse.setRsVoList(searchPrepaymentListByPaymentSlipVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }

	/**
	 * ReverseCsrForSublet 정보를 저장한다(입력 / 수정 / 삭제)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageReverseCsrForSublet(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0033Event event = (EsmFms0033Event)e;
		
		TCharterIOConsultationBC tCharterIOConsultationBC = new TCharterIOConsultationBCImpl();
		
		try{
			
			begin();
			String slpSerNo = tCharterIOConsultationBC.manageReverseCsrForSublet(event.getCustomConsultationVO(), event.getCustomCsulSlpVOS(), account);
			
			event.getCustomCsulSlpSeqVO().setSlpSerNo(slpSerNo);
			
			//===========================================================================			
			// AR-GW결재(201412. 민정호)
			// AR_INV_HDR 저장				
			CustomConsultationVO customConsultationVO = event.getCustomConsultationVO();
			log.debug("customConsultationVO.getSlpTpCd() = "+customConsultationVO.getSlpTpCd());
			log.debug("customConsultationVO.getSlpFuncCd()  = "+customConsultationVO.getSlpFuncCd() );
			log.debug("customConsultationVO.getSlpOfcCd() = "+customConsultationVO.getSlpOfcCd());
			log.debug("customConsultationVO.getSlpIssDt() = "+customConsultationVO.getSlpIssDt());
			log.debug("customConsultationVO.getSlpIssDt().substring(2) = "+customConsultationVO.getSlpIssDt().substring(2));
			log.debug("customConsultationVO.getSlpIssDt().substring(2,8) = "+customConsultationVO.getSlpIssDt().substring(2,8));			
			log.debug("slpSerNo ="+slpSerNo);						
			String csrNo = 	customConsultationVO.getSlpTpCd() +
									customConsultationVO.getSlpFuncCd() +
									customConsultationVO.getSlpOfcCd() +
									customConsultationVO.getSlpIssDt().substring(2) +																		
									slpSerNo;
			
			tCharterIOConsultationBC.manageArInvHdr(csrNo, account.getUsr_id());
			//===========================================================================
						
			List<SearchReverseCsrForSubletSaveListVO> searchReverseCsrForSubletSaveListVO = tCharterIOConsultationBC.searchReverseCsrForSubletSaveList(event.getCustomCsulSlpSeqVO());
			
			eventResponse.setRsVoList(searchReverseCsrForSubletSaveListVO);
			
			eventResponse.setUserMessage(new ErrorHandler("FMS00001").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * 용선인 경우 전표가 승인되면 ERP A/P 로 전송된다
	 * 대선인 경우 전표가 승인되면 ERP A/R 로 전송된다<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSlipApproval(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	
		EsmFms0052Event event = (EsmFms0052Event)e;
	
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
	
		try {
	
			String usrId = account.getUsr_id();
	
			begin();
			
			/* 용선인 경우 전표가 승인되면 ERP A/P 로 전송된다
			 * 대선인 경우 전표가 승인되면 ERP A/R 로 전송된다*/
			String fletCtrtTpCd = event.getFletCtrtTpCd();
			if (event.getSlipType().equals("RV")) {
				fletCtrtTpCd = "RV";
			}
			else if (event.getSlipType().equals("AR")) {
				fletCtrtTpCd = "AR";
			}
			
			// 해당 전표의 Apro_flg = 'Y'로 업데이트 포함
			String aproFlgUpdateYn  = "Y";
			
			List<SearchArSlipDetailListVO> searchArSlipDetailListVO = command.manageSlipApproval(fletCtrtTpCd
																				, event.getCsrNo()
																				, event.getAproFlg()
																				, event.getCxlDesc()
																				, usrId 
																				,event.getInterCoCd()
																				,event.getArInterCoCd()
																				, aproFlgUpdateYn
																				,account.getOfc_cd()
																				,event.getSlipAproFlg()
																				,""
																				);

			TCharterIOInvoiceBC invcommand = new TCharterIOInvoiceBCImpl();

			if (event.getAproFlg().equals("Y")) {//Approval  
				if ((fletCtrtTpCd.equals("TO") && !event.getCsrNo().substring(0,2).equals("07"))) {//AR	
					   if( searchArSlipDetailListVO != null ) {
							invcommand.modifySlipApprovalInvoice(searchArSlipDetailListVO);
						}
				}
			} else {//Cancel
				//AP, AR 공통,  용선/대선 전표가 취소 되면 Invoice에 전표번호가 Null 로 변경된다
				invcommand.modifySlipApprovalCancelInvoice(event.getCsrNo(), usrId);
				
				//AP - TI이거나 값이 없는 경우일때만 실행
				if (event.getFletCtrtTpCd().equals("TI") || event.getFletCtrtTpCd().equals("")) {
					//용선 전표가 취소 되면 Owner's Account 에 전표번호가 Null 로 변경된다
					invcommand.modifySlipApprovalCancelOwnerAccount(event.getCsrNo(), usrId);

					TCharterIOBunkerRegisterBC bnkcommand = new TCharterIOBunkerRegisterBCImpl();
					//용선인 경우 전표가 취소되면 Bunker의 전표 정보도 Null 로 업데이트된다
					bnkcommand.modifySlipApprovalCancelBunker(event.getCsrNo(), usrId);
				
				// 대선인 경우 AP, AR 공통(Bunker처리) 
				} else if(event.getFletCtrtTpCd().equals("TO")) {
					TCharterIOBunkerRegisterBC bnkcommand = new TCharterIOBunkerRegisterBCImpl();
					//용선인 경우 전표가 취소되면 Bunker의 전표 정보도 Null 로 업데이트된다
					bnkcommand.modifyApArSlipApprovalCancelBunker(event.getCsrNo(), usrId);
				}
			}
	
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
	
			commit();
	
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	 }
	
    /**
	 * 품의되지 않은 Charterer's Account 대상 자료를 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchCharterListByPaymentSlip(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
    	EsmFms0025Event event = (EsmFms0025Event)e;
	    
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    
		try {
			
			List<SearchCharterListByPaymentSlipVO> searchCharterListByPaymentSlipVO = command.searchCharterListByPaymentSlip(event.getFletCtrtNo(), event.getOfcCd(), event.getCsrCurrCd());
	
			eventResponse.setRsVoList(searchCharterListByPaymentSlipVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * 기 작성된 Offhire Expenses / Window 중 지급 전표로 처리할 항목 선정 대상 자료를 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchOffhireListByPaymentSlip(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
    	EsmFms0026Event event = (EsmFms0026Event)e;
	    
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    
		try {
			
			List<SearchOffhireListByPaymentSlipVO> searchOffhireListByPaymentSlipVO = command.searchOffhireListByPaymentSlip(event.getFletCtrtNo(), event.getOfcCd(), event.getCsrCurrCd());
	
			eventResponse.setRsVoList(searchOffhireListByPaymentSlipVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * 기 작성된 Owner’s Account / Window 중 지급 전표로 처리할 항목 선정 대상 자료를 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchOwnerListByPaymentSlip(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
    	EsmFms0028Event event = (EsmFms0028Event)e;
	    
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    
		try {
			
			List<SearchOwnerListByPaymentSlipVO> searchOwnerListByPaymentSlipVO = command.searchOwnerListByPaymentSlip(event.getFletCtrtNo(), event.getOfcCd(), event.getCsrCurrCd());
	
			eventResponse.setRsVoList(searchOwnerListByPaymentSlipVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * 기 작성된 BOD / BOR Data / Window 중 지급 전표로 처리할 항목 선정 대상 자료를 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchBunkerListByPaymentSlip(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
    	EsmFms0027Event event = (EsmFms0027Event)e;
	    
    	TCharterIOBunkerRegisterBC command = new TCharterIOBunkerRegisterBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    
		try {
			
			List<SearchBunkerListByPaymentSlipVO> searchBunkerListByPaymentSlipVO = command.searchBunkerListByPaymentSlip(event.getFletCtrtNo(), event.getOfcCd(), event.getCsrCurrCd(), event.getAproFlg());
	
			eventResponse.setRsVoList(searchBunkerListByPaymentSlipVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * 생성된 Brokerage를 Manual 전표에서 처리하기 위해 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchBrokerageList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
    	EsmFms00401Event event = (EsmFms00401Event)e;
    	
    	TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
    	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    
		try {
			List<SearchBrokerageListVO> searchBrokerageListVO = command.searchBrokerageList(event.getCurrCd());
			eventResponse.setRsVoList(searchBrokerageListVO);
			return eventResponse;
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }

    /**
	 * Manual Slip전표를 저장한다(입력 / 수정 / 삭제)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageManualSlip(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0040Event event = (EsmFms0040Event)e;
		
		ExternalFinderBC externalFinderBC = new ExternalFinderBCImpl();
		
		TCharterIOConsultationBC tCharterIOConsultationBC = new TCharterIOConsultationBCImpl();
		
		TCharterIOInvoiceBC tCharterIOInvoiceBC = new TCharterIOInvoiceBCImpl();
		
		try{
			
			CustomCsulSlpVO[] customCsulSlpVOs = event.getCustomCsulSlpVOS();
			
			//항차레벨을 체크한다
			for (int i=0; i<customCsulSlpVOs.length; i++) {
				if(   customCsulSlpVOs[i].getVvdCd() != null 
				   && !customCsulSlpVOs[i].getVvdCd().equals("")) {
					
					String level = externalFinderBC.checkAcctCdVvdLevel(customCsulSlpVOs[i].getAcctCd(), customCsulSlpVOs[i].getVvdCd());
					if (!level.equals("2")) {	
						throw new EventException(new ErrorHandler("FMS01478",new String[]{customCsulSlpVOs[i].getAcctCd(), customCsulSlpVOs[i].getVvdCd()}).getMessage());
					}
				}
			}
			
			begin();
			
			String slpSerNo = tCharterIOConsultationBC.manageManualSlip(event.getCustomConsultationVO(), event.getCustomCsulSlpVOS(), event.getCustomTaxVOS(), event.getCustomTaxDtlVOS(), account.getUsr_id(), account);
			
			event.getCustomCsulSlpSeqVO().setSlpSerNo(slpSerNo);
			
			tCharterIOInvoiceBC.modifyManualSlip(event.getCustomCsulSlpVOS());
			
			List<SearchManualSlipListVO> searchManualSlipListVO = tCharterIOConsultationBC.searchManualSlipList(event.getCustomCsulSlpSeqVO());
			
			//------------------------------
			// 10만불2차 민정호			
			/* 용선인 경우 전표가 승인되면 ERP A/P 로 전송된다
			 * 대선인 경우 전표가 승인되면 ERP A/R 로 전송된다*/
			 String csrNo = searchManualSlipListVO.get(0).getCsrNo();									 
			 String aproFlgUpdateYn = "N";
			  if(csrNo.substring(0,2).equals("07")) {	//AP
					String fletCtrtTpCd = "";				  
				  	//tCharterIOConsultationBC.manageSlipApproval(fletCtrtTpCd, csrNo, "Y", "", account.getUsr_id() ,"","",aproFlgUpdateYn,account.getOfc_cd(), "N", "");
				  	tCharterIOConsultationBC.manageSlipApproval(fletCtrtTpCd, csrNo, "Y", "", account.getUsr_id() ,"","",aproFlgUpdateYn,account.getOfc_cd(), "", "");
			  }						  
			//------------------------------	
						  
			eventResponse.setRsVoList(searchManualSlipListVO);
			
			eventResponse.setUserMessage(new ErrorHandler("FMS00001").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
   /**
	* CSR No. 에 해당하는 Tax 데이타 조회<br>
	* 
	* @param
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchTaxEvidence(Event e) throws EventException {
	    
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0086Event event = (EsmFms0086Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
	    
		try {
			SearchTaxMasterEvidenceVO searchTaxMasterEvidenceVO = command.searchTaxMasterEvidence(event.getCsrNo());
			
			List<SearchTaxDetailEvidenceListVO> searchTaxDetailEvidenceListVO = command.searchTaxDetailEvidenceList(event.getCsrNo());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			if(searchTaxMasterEvidenceVO != null) {
				
				eventResponse.setETCData("taxInvYrmon",searchTaxMasterEvidenceVO.getTaxInvYrmon());
				eventResponse.setETCData("ofcCd",searchTaxMasterEvidenceVO.getOfcCd());
				eventResponse.setETCData("docEvidTpCd",searchTaxMasterEvidenceVO.getDocEvidTpCd());
				eventResponse.setETCData("taxVatTpCd",searchTaxMasterEvidenceVO.getTaxVatTpCd());
				eventResponse.setETCData("taxNaidFlg",searchTaxMasterEvidenceVO.getTaxNaidFlg());
				eventResponse.setETCData("taxDivCd",searchTaxMasterEvidenceVO.getTaxDivCd());
				eventResponse.setETCData("faFlg",searchTaxMasterEvidenceVO.getFaFlg());
				eventResponse.setETCData("taxPlCd",searchTaxMasterEvidenceVO.getTaxPlCd());
				eventResponse.setETCData("taxNslFlg",searchTaxMasterEvidenceVO.getTaxNslFlg());
				eventResponse.setETCData("splRgstNo",searchTaxMasterEvidenceVO.getSplRgstNo());
				eventResponse.setETCData("ownrNm",searchTaxMasterEvidenceVO.getOwnrNm());
				eventResponse.setETCData("coNm",searchTaxMasterEvidenceVO.getCoNm());
				eventResponse.setETCData("bzctNm",searchTaxMasterEvidenceVO.getBzctNm());
				eventResponse.setETCData("bztpNm",searchTaxMasterEvidenceVO.getBztpNm());
				eventResponse.setETCData("splAddr",searchTaxMasterEvidenceVO.getSplAddr());
				eventResponse.setETCData("issDt",searchTaxMasterEvidenceVO.getIssDt());
				eventResponse.setETCData("splAmt",searchTaxMasterEvidenceVO.getSplAmt());
				eventResponse.setETCData("taxAmt",searchTaxMasterEvidenceVO.getTaxAmt());
				eventResponse.setETCData("totalAmt",searchTaxMasterEvidenceVO.getTotalAmt());
			}
			
			eventResponse.setETCData(etcData);
			
			eventResponse.setRsVoList(searchTaxDetailEvidenceListVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }

	/**
	 * TCharterIOInvoice(EsmFmsFNS012R002Event)의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @exception EventException, Exception
	 */
	private void receiveSlipApprovalToAR(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();

		try{
			begin();
			XmlObject xmlObject = ((EsmFmsFNS012R002Event)e).getXmlObject();
			command.receiveSlipApprovalToAR(xmlObject);
			commit();
		} catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * 생성된 Brokerage를 Manual 전표에서 처리하기 위해 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchEmailAddressList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
    	TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
    	
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<SearchEmailAddressListVO> searchEmailAddressListVO = command.searchEmailAddressList();
			eventResponse.setRsVoList(searchEmailAddressListVO);
			return eventResponse;
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * SDMS정보를 가져온다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchChaterInvoiceSdmsList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	
		EsmFms0017Event event = (EsmFms0017Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		try {
			List<SearchChaterInvoiceSdmsListVO> searchChaterInvoiceSdmsListVO = command.searchChaterInvoiceSdmsList(event.getFletCtrtNo(), event.getFromPayDt(), event.getToPayDt(), event.getAppFlg());
			eventResponse.setRsVoList(searchChaterInvoiceSdmsListVO);
	    } catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

		return eventResponse;
	}
    
    /**
	 * INV No. 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse checkSdmsInvoiceNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0017Event event = (EsmFms0017Event)e;
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
	
		try{
			String invNo = command.checkSdmsInvoiceNo(event.getInvNo());
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			etcData.put("invNo",invNo);
			
			eventResponse.setETCData(etcData);
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
    
    /**
	 * E-mail 정보를 가져온다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEmailAddress(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0085Event event = (EsmFms0085Event)e;
		
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
		
		try {
			begin();
			command.manageEmailAddress(event.getCustomEmailAddressVOS(),account.getUsr_id());
			eventResponse = (GeneralEventResponse)searchEmailAddressList(e);
			eventResponse.setUserMessage(new ErrorHandler("FMS00001").getUserMessage());
			commit();
		} catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * SDMS FinanVvdList 가져오기<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFinanVvdListByChaterSdms(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0076Event event = (EsmFms0076Event)e;
		
		TCharterIOBasicRegisterBC command = new TCharterIOBasicRegisterBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<SearchFinanVvdListByChaterSdmsVO> searchFinanVvdListByChaterSdmsVO = command.searchFinanVvdListByChaterSdms(event.getVslCd(), event.getDirection(), event.getRevYrmon());
			
			StringBuilder sb = new StringBuilder();
			
			if(searchFinanVvdListByChaterSdmsVO.size() > 0) {
				for(int i=0; i<searchFinanVvdListByChaterSdmsVO.size(); i++) {
					sb.append(searchFinanVvdListByChaterSdmsVO.get(i).getVvd()+"|");
				}
			}
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("vvd",sb.toString());
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	* Cumstomer Code를 조회한다<br>
	* 
	* @param e Event
	* @return response EventResponse
	* @exception EventException
	*/
	private EventResponse searchCustomerCode(Event e) throws EventException {
	    
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0032Event event = (EsmFms0032Event)e;
		
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();

		try {
			List<SearchCustomerCodeVO> searchCustomerCodeVO = command.searchCustomerCode(event.getFletCtrtNo());
			eventResponse.setETCData("CustCntCd", searchCustomerCodeVO.get(0).getCustCntCd());
			eventResponse.setETCData("CustSeq", searchCustomerCodeVO.get(0).getCustSeq());
			eventResponse.setETCData("CustLglEngNm", searchCustomerCodeVO.get(0).getCustLglEngNm());
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
	
	/**
	 * Manual Slip에서 재무 항차 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchVvdListByManualSlip(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
    	EsmFms00401Event event = (EsmFms00401Event)e;
    	
    	TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
    	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    
		try {
			List<SearchVvdListByManualSlipVO> searchVvdListByManualSlipVO = command.searchVvdListByManualSlip(event.getFletCtrtNo(), event.getFmDt(), event.getToDt());

			StringBuilder sb = new StringBuilder();
			Map<String,String> etcData = new HashMap<String,String>();
			
			if(searchVvdListByManualSlipVO.size() > 0) {
				for(int i=0; i<searchVvdListByManualSlipVO.size(); i++) {
					sb.append(searchVvdListByManualSlipVO.get(i).getVvdCd() + "|");
				}
			}

			etcData.put("vvdCd", sb.toString());
			eventResponse.setETCData(etcData);

			return eventResponse;
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }
    
    /**
	 * 공통 코드 정보를 가져온다<br>
	 * 
	 * @param codeInfoList List<Collection<CodeInfo>>
	 * @param etcCodeNm String[]
	 * @param etcTextNm String[]
	 * @return Map<String, String>
	 * @exception EventException
	 */
    private Map<String, String> getStandardCommonCodeList(List<Collection<CodeInfo>> codeInfoList, String[] etcCodeNm, String[] etcTextNm) throws EventException{
		
	    try{
			if(codeInfoList == null) return null;
			
			// 공통 Code 값
			StringBuilder comboCode = new StringBuilder();
			
			// 공통 Name 값
			StringBuilder comboText = new StringBuilder();
			
			CodeInfo codeInfo = null;
			Iterator<CodeInfo> iterator = null;
			
			Map<String,String> etcData = new HashMap<String,String>();
			
			for(int i=0; i<codeInfoList.size(); i++) {

				iterator = codeInfoList.get(i).iterator();

				while(iterator.hasNext()) {
					codeInfo = iterator.next();
					
					comboCode.append(codeInfo.getCode()+"|");
					comboText.append(codeInfo.getName()+"|");
					
					etcData.put(etcCodeNm[i],comboCode.toString());
					etcData.put(etcTextNm[i],comboText.toString());
				}
				
				comboCode.setLength(0);
				comboText.setLength(0);
			}

			return etcData;
			
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Prepayments에서 Hire No가 있는지 체크한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHireNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0012Event event = (EsmFms0012Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			String hireNo = "";
			hireNo = command.searchHireNo(event.getFletCtrtNo(), event.getPpayHirNo());
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("hireNo",hireNo);
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	
	
	 /**
	 * GL Inquiry OwnerInvoice 정보를 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchGlInquiryOwnerInvoiceList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	
		EsmFms0087Event event = (EsmFms0087Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		try {
			event.getCondSearchOwnerInvoiceVO().setSheetNo("1");
			List<SearchOwnerInvoiceListVO> searchOwnerInvoiceListVO1 = command.searchGlInquiryOwnerInvoiceList(event.getCondSearchOwnerInvoiceVO());
					
			eventResponse.setRsVoList(searchOwnerInvoiceListVO1);
		
	    } catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	}

//############################################################################################################    
    
	/**
	 * approval request gwUrl open<br>
	 * @author young shin kim
	 * @category 
	 * @category manageApplication 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageApplication(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		EsmFms0088Event event = (EsmFms0088Event)e;
		// BC 객체 생성
		ArApprovalBC command = new ArApprovalBCImpl();	
		
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		IfCsrListInputVO vo = event.getIfCsrListInputVO();

		try {
			
			//그룹웨어 URL주소
			String gwUrl= "";
			
			//csr no 
			String csrNo = vo.getCsrNo();
			//inv_sub_sys_cd
			String invSubSysCd = vo.getInvSubSysCd();		
			
			gwUrl = command.sendGwApprovalRequestInfo(csrNo, invSubSysCd, account);
			
			if (gwUrl == null) {
				gwUrl = "";
			}
			
			eventResponse.setETCData("GW_URL", gwUrl);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch(Exception ex) {
			log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
		}
	
		return eventResponse;
	}
    
	/**
	 * Gw Status 정보 수정 EAI에서 수신<br>
	 * @author young shin kim
	 * @category COM006R001
	 * @category manageGwStatus 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGwStatus(Event e) throws EventException {

		// 반환 객체 생성
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		
		EsmFms0088Event event = (EsmFms0088Event)e;
		ComCsrInfoVO vo = event.getComCsrInfoVO();		
		ComApCsrHisVO hisVo = new ComApCsrHisVO();
		
		ApprovalCsrVO approvalCsrVO = new ApprovalCsrVO();
		ComAproRqstRoutVO rout = new ComAproRqstRoutVO();
		
		ArApprovalBC 						command 			= new ArApprovalBCImpl();	
		TCharterIOConsultationBC     	fmsCommand 	= new TCharterIOConsultationBCImpl();
		
		String beComplete = "";

		try {		
			begin();
			// ---------------------------------------------
			// GW 승인여부  : result
			// --------------------------------------------
			// C (CANCLE)    : 창닫기
			// N (REJECT)    : disapprove
			// Y (COMPLETE)  : 최종결재 완료.
			// P (PANDING)   : 기안완료
			// --------------------------------------------			
			String gwResult = JSPUtil.getNull(vo.getResult());
			String csrNo = JSPUtil.getNull(vo.getCsrNo());
			String aproUsrNm = JSPUtil.getNull(vo.getAproUsrNm());
			String aproUsrJbTitNm = JSPUtil.getNull(vo.getAproUsrJbTitNm());	
			String userId = JSPUtil.getNull(vo.getUserId());
			String requestId = JSPUtil.getNull(vo.getRequestId());
			String gwAgmtDocCfmCd = JSPUtil.getNull(vo.getGwAgmtDocCfmCd());
			String resultMsg = JSPUtil.getNull(vo.getResultMsg());
			
			String ofcCd = command.searchOfcCd(csrNo);
			//csrNo로 SubSysCd 값을 가져온다
			//FMS전용 
			String subSysCd = "FMS";			
						
			log.error("============================");
			log.error("gwResult : " + gwResult);
			log.error("csrNo : " + csrNo);
			log.error("userId : " + userId);
			log.error("aproUsrNm : " + aproUsrNm);
			log.error("aproUsrJbTitNm : " + aproUsrJbTitNm);
			log.error("ofcCd : " + ofcCd);
			log.error("subSysCd : " + subSysCd);
			log.error("gwAgmtDocCfmCd : " + gwAgmtDocCfmCd);
			log.error("resultMsg : " + resultMsg);
			log.error("============================");
			
			approvalCsrVO.setCsrNo(csrNo);
			approvalCsrVO.setInvSubSysCd(subSysCd);
			approvalCsrVO.setSubSysCd(subSysCd);
			approvalCsrVO.setUsrNm(aproUsrNm);
			
			rout.setAproUsrNm(aproUsrNm);
			rout.setAproUsrJbTitNm(aproUsrJbTitNm);
			
			vo.setCsrNo(csrNo);
			vo.setOfcCd(ofcCd);
			vo.setCsrAproTpCd("GW");
			vo.setResult(gwResult);
			vo.setGwAgmtDocCfmCd(gwAgmtDocCfmCd);
					
			// -------------------------------------
			// GW 연동 정보를  history 테이블에 저장한다.
			// -------------------------------------
			log.error("\n 3.START - ConsultationSlipRequestMgtSC.manageGwStatus : saveGWInfo (csr_no:"+JSPUtil.getNull(csrNo)+") \n");
	    	hisVo.setCsrNo(csrNo);
	    	hisVo.setCsrAproTpCd("GW");
	    	hisVo.setAutoMnlFlg("Y");
	    	hisVo.setIoBndCd("I");
	    	hisVo.setGwCsrRqstId(requestId);
	    	hisVo.setGwAproRsltCd(gwResult);
	    	hisVo.setCreUsrId(userId);					//생성자 ID(승인자 ID)
	    	hisVo.setUpdUsrId(userId);					//업데이트 ID(승인자 ID)
	    	hisVo.setAproUsrId(userId);					//승인자 ID
	    	hisVo.setAproUsrJbTitNm(aproUsrJbTitNm);	//승인자 직책
	    	hisVo.setAproUsrNm(aproUsrNm);				//승인자 이름
	    	hisVo.setAproRmk(resultMsg);				//승인 코멘트
	    	
	    	command.saveGWInfo(hisVo);
	    	log.error("\n 3.DONE - ConsultationSlipRequestMgtSC.manageGwStatus : saveGWInfo (csr_no:"+JSPUtil.getNull(csrNo)+") \n");	    
		    
	    	commit();	//EAI연동에 의해 에러가 발생해도 History table 에 저장되는 값은 rollback 되지 않도록 한다.
		    begin();
		    // ---------------------------------------------
		 	// 현재 결재 상태를 조회한다.
		 	// --------------------------------------------
		 	// X (Requesting) : CSR_NO만 생성된 상태
		    // P (PANDING)    : 기안완료
		    // N (REJECT)     : disapproved 상태
		 	// Y (COMPLETE)   : 최종결재 완료 상태	 	
		 	// --------------------------------------------			
	    	String  aproStepFlg = command.searchRqstAproStepFlg(csrNo);
		    
		    if ("P".equals(gwResult)) {		    			
				if(aproStepFlg.equals("X")) {
					//RESULT 값에 따라 DATE 컬럼, RQST_APRO_STEP_FLG = '' 업데이트
					command.updateAproGwDt(vo);					
					beComplete = "Success";
					
				} else if(aproStepFlg.equals("P")){ //기안이 완료된 건입니다.
					throw new EventException(new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage());
				} else if(aproStepFlg.equals("N")){ //disapproved 된 건입니다.
					throw new EventException(new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage());
				} else if(aproStepFlg.equals("Y")){ //approved 된 건입니다.
					throw new EventException(new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage());
				}
			} else if ("N".equals(gwResult)) {				
				if(aproStepFlg.equals("P")) { //기안이 완료된 건에 대해서만 disapproved
					if("FMS".equals(subSysCd)){
						fmsCommand.manageDisapproveFMS(userId, csrNo, ofcCd); 
					}
					
					//RESULT 값에 따라 DATE 컬럼 업데이트
					command.updateAproGwDt(vo);					
					beComplete = "Success";
					
				} else if(aproStepFlg.equals("X")){ //기안 완료가 되지 않은 건입니다.
					throw new EventException(new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage());
				} else if(aproStepFlg.equals("N")){ //disapproved 된 건입니다.
					throw new EventException(new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage());
				} else if(aproStepFlg.equals("Y")){ //approved 된 건입니다.
					throw new EventException(new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage());
				}
					
			} else if ("Y".equals(gwResult)) {		
				if(aproStepFlg.equals("P")) { //기안이 완료된 건에 대해서만 approved	
					
					//RESULT 값에 따라 DATE 컬럼, GW_AGMT_DOC_CFM_CD 업데이트
					command.updateAproGwDt(vo);	
							
					if ("FMS".equals(subSysCd)){
						fmsCommand.manageApproveFMS(userId, csrNo, ofcCd);    	   			
					}					
								
					beComplete = "Success";	
					
				} else if(aproStepFlg.equals("X")){ //기안 롼료가 되지 않은 건입니다.
					throw new EventException(new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage());
				} else if(aproStepFlg.equals("N")){ //disapproved 된 건입니다.
					throw new EventException(new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage());
				} else if(aproStepFlg.equals("Y")){ //approved 된 건입니다.
					throw new EventException(new ErrorHandler("CSR00002", new String[]{"GW RESULT"}).getMessage());
				}
			}

			commit(); 
			eventResponse.setUserMessage(beComplete);
			
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
	
		return eventResponse;
	}	
	
//###########################################################################################
//###########################################################################################	
//###########################################################################################	
	/**
	 * Off-Hire Expenses 화면의 전체탭 데이타를 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffhireExpensesList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0090Event event = (EsmFms0090Event)e;		 
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		  
		try {
		
			List<SearchOffhireExpensesListVO> searchOffhireExpensesListVO = command.searchOffhireCnfmList(event.getSearchOffhireExpensesListVO());				
			eventResponse.setRsVoList(searchOffhireExpensesListVO);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	

	/**
	 * Off-Hire Expenses 화면의 Completed 데이타를 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffhireCompletedList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0090Event event = (EsmFms0090Event)e;		 
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		  
		try {
		
			List<SearchOffhireExpensesListVO> searchOffhireExpensesListVO = command.searchOffhireCnfmList(event.getSearchOffhireExpensesListVO());
				
			eventResponse.setRsVoList(searchOffhireExpensesListVO);			
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}	
		
	/**
	 * 계약 정보 조회<br>
	 * Vessel 정보를 조회 후 선택한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContracNoListByVessel2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0091Event event = (EsmFms0091Event)e;
		
		TCharterIOContractBC command = new TCharterIOContractBCImpl();

		try{
			List<SearchContracNoListByVesselVO> searchContracNoListByVesselVO = command.searchContracNoListByVessel2(event.getVslCd(), event.getFletCtrtTpCd(), event.getCtrtFlag());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse.setRsVoList(searchContracNoListByVesselVO);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	

	/**
	 * Off-Hire Expenses 정보를 저장한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOffhireExpenses(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EsmFms0090Event event = (EsmFms0090Event)e;				
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();								
		try{	
			begin();
			SearchOffhireExpensesListVO[] searchOffhireExpensesListVOs = event.getSearchOffhireExpensesListVOs();			
			String usrId = account.getUsr_id();	
			
			command.manageOffhireExpenses(searchOffhireExpensesListVOs, usrId);			
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());			
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;

	}
	
	
	/**
	 * FMS VNOR ITEM을 수정한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyVnorItm(Event e, String vnorItmProcCd) throws EventException {		
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EsmFms0090Event event = (EsmFms0090Event)e;				
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();						
		try{
			begin();
			
			SearchOffhireExpensesListVO[] searchOffhireExpensesListVOs = event.getSearchOffhireExpensesListVOs();
			String usrId = account.getUsr_id();									
			command.modifyVnorItm(searchOffhireExpensesListVOs, usrId, vnorItmProcCd);			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());			
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
		return eventResponse;
	}	
		
	/**
	 * Off-Hire Expenses 화면에서 CalOffhireInvoice 데이타를 조회한다(Creation 선택시)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCalOffhireInvoiceList2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0091Event event = (EsmFms0091Event)e;
		  
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		  
		try {
//			List<SearchCalOffhireInvoiceListVO> searchCalOffhireInvoiceListVOs1 = command.searchCalOffhireInvoiceCheck(event.getCondCalOffhireInvoiceVO());
			
//			if(searchCalOffhireInvoiceListVOs1.size() > 0) {	// 동일 기간 OFF-HIRE 입력 불가.
//				eventResponse.setUserMessage("Your input offhire data is duplicated in data base.");
//
//			}else{
				List<SearchCalOffhireInvoiceListVO> searchCalOffhireInvoiceListVOs = command.searchCalOffhireInvoiceList(event.getCondCalOffhireInvoiceVO());
				
				List<SearchCalOffhireInvoiceListSumVO> searchCalOffhireInvoiceListSumVOs = command.searchCalOffhireInvoiceListSum(event.getCondCalOffhireInvoiceVO());
				
				eventResponse.setRsVoList(searchCalOffhireInvoiceListVOs);
				eventResponse.setRsVoList(searchCalOffhireInvoiceListSumVOs);
				
//				if(searchCalOffhireInvoiceListVOs.size() < 1) {
//					eventResponse.setUserMessage((String) new ErrorHandler("FMS01167",new String[]{}).getUserMessage());
//				}				
//			}			
			return eventResponse;			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	

	/**
	 * Off-Hire Expenses 화면에서 OffhireInvoice 데이타 조회(Inquery 선택시)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffhireInvoiceList2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0091Event event = (EsmFms0091Event)e;
		  
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		  
		try {
			List<SearchOffhireInvoiceListVO> searchOffhireInvoiceListVOs = command.searchOffhireInvoiceList(event.getFletCtrtNo(), event.getInvSeq());
			
			List<SearchCalOffhireInvoiceListSumVO> searchCalOffhireInvoiceListSumVOs = command.searchOffhireInvoiceListSum(event.getFletCtrtNo(), event.getInvSeq());
			
			//Map<String,String> sumData = new HashMap<String,String>();
			
			//sumData = getCalOffhireInvoiceListSum(searchCalOffhireInvoiceListSumVOs);
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("invSeq",searchOffhireInvoiceListVOs.get(0).getInvSeq());
			//etcData.put("totalAmount1",sumData.get("totalAmount1"));
			//etcData.put("totalAmount2",sumData.get("totalAmount2"));
			
			eventResponse.setRsVoList(searchOffhireInvoiceListVOs);
			eventResponse.setRsVoList(searchCalOffhireInvoiceListSumVOs);
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	

	/**
	 * CtrtNo와 Duration에 해당하는 항차 가져오기<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVvdListByOffHire2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0091Event event = (EsmFms0091Event)e;
		  
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<SearchVvdListByOffHireVO> searchVvdListByOffHireVO = command.searchVvdListByOffHire(event.getFletCtrtNo(), event.getEffDt(), event.getExpDt(), event.getVslCd());
			
			StringBuilder sb = new StringBuilder();
			
			if(searchVvdListByOffHireVO.size() > 0) {
				for(int i=0; i<searchVvdListByOffHireVO.size(); i++) {
					sb.append(searchVvdListByOffHireVO.get(i).getVvd()+"|");
				}
			}
			
			Map<String,String> etcData = new HashMap<String,String>();

			etcData.put("bunker_vvd",sb.toString());
			etcData.put("bunker_vvd_text",sb.toString());
			
			eventResponse.setETCData(etcData);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	

    /**
	 * Off-Hire Expenses 화면에서 Offhire Expenses 정보를 등록 및 변경한다<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOffhireInvoice2(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0091Event event = (EsmFms0091Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		try {
			CustomOffInvoiceVO customOffInvoiceVO = event.getCustomOffInvoiceVO();
			
			CustomOffInvDtlVO[] customOffInvDtlVOs = event.getCustomOffInvDtlVOS();
			
			String usrId = account.getUsr_id();

			begin();
			command.manageOffhireInvoice(customOffInvoiceVO, customOffInvDtlVOs, usrId);
			
			eventResponse = (GeneralEventResponse)searchOffhireInvoiceList2(e);
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	

	/**
	 * 사선/용선/대선 정보 삭제(DELETE)<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */	
	private EventResponse removeOffhireInvoice2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0091Event event = (EsmFms0091Event)e;
		  
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{	
			begin();

			command.removeOffhireInvoice(event.getFletCtrtNo(), event.getInvSeq());
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	//##########################################################################################
	//##########################################################################################
	//##########################################################################################
	
	/**
	 * Audit Comment를 수정한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyAuditComment(Event e) throws EventException {		
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		EsmFms0090Event event = (EsmFms0090Event)e;				
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();						
		try{
			begin();
			
			SearchOffhireExpensesListVO[] searchOffhireExpensesListVOs = event.getSearchOffhireExpensesListVOs();
			String usrId = account.getUsr_id();									
			command.modifyAuditComment(searchOffhireExpensesListVOs, usrId);			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());			
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * Retrieve 조회<br>
	 * [ESM_FMS_0097] (New) Owner’s Account<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNewOwnerAccountList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0097Event event = (EsmFms0097Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			List<SearchNewOwnerAccountListVO> searchNewOwnerAccountListVOs = command.searchNewOwnerAccountList(event.getCondSearchOwnerAccountVO());
			
			eventResponse.setRsVoList(searchNewOwnerAccountListVOs);
			
			return eventResponse;
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Save 저장<br>
	 * [ESM_FMS_0097] (New) Owner’s Account<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageNewOwnerAccount(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0097Event event = (EsmFms0097Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		try {
			SearchNewOwnerAccountListVO[] searchNewOwnerAccountListVOs = event.getSearchNewOwnerAccountListVOS();
			
			String usrId = account.getUsr_id();

			begin();
			command.manageNewOwnerAccount(searchNewOwnerAccountListVOs, usrId);
			
			eventResponse = (GeneralEventResponse) searchNewOwnerAccountList(e);
			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * VVD 체크<br>
	 * [ESM_FMS_0097] (New) Owner’s Account<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse checkVvdInFmsCntrct(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0097Event event = (EsmFms0097Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		try {

			boolean bExitVvd = command.checkVvdInFmsCntrct(event.getVvd());
			
			if(!bExitVvd) {
				eventResponse.setUserMessage((String) new ErrorHandler("FMS01144",new String[]{}).getUserMessage());
			}
			
			return eventResponse;
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * FRGN Exchange Transaction(O/A) 정보를 조회한다 <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFrgmExchangeTransaction(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0098Event event = (EsmFms0098Event)e;
		  
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		  
		try {
 		    	List<FrgnExchangeTransactionVO> searchFrgnExchangeTransactionVOs = command.searchFrgnExchangeTransactionList(event.getFrgnExchangeTransactionVO());
				
				
				eventResponse.setRsVoList(searchFrgnExchangeTransactionVOs);
//				eventResponse.setRsVoList(searchCalOffhireInvoiceListSumVOs);
				
//				if(searchCalOffhireInvoiceListVOs.size() < 1) {
//					eventResponse.setUserMessage((String) new ErrorHandler("FMS01167",new String[]{}).getUserMessage());
//				}				
//			}			
			return eventResponse;			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

    /**
    * Off-Hire Expenses 화면에서 Offhire Expenses 정보를 등록 및 변경한다<br>
    * 
    * @param e Event
    * @return eventResponse EventResponse
    * @exception EventException
    */
    private EventResponse manageFrgmExchangeTransaction(Event e) throws EventException {
			
		GeneralEventResponse eventResponse = new GeneralEventResponse();
			
		EsmFms0098Event event = (EsmFms0098Event)e;
			
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		String csr_no ="";
			
		try {
			begin();
			FrgnExchangeTransactionVO frgnExchangeTransactionVO = event.getFrgnExchangeTransactionVO();
			if(event.getFrgnExchangeVOS() != null){
			csr_no = command.manageFrgmExchangeTransaction(frgnExchangeTransactionVO , event.getFrgnExchangeVOS(), account);
			}
		//	eventResponse = (GeneralEventResponse)searchOffhireInvoiceList2(e);
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
			eventResponse.setETCData("new_csr_no" ,csr_no );
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		
		return eventResponse;
	}
    
    /**
	 * 기 작성된 Owner’s Account / Window 중 지급 전표로 처리할 항목 선정 대상 자료를 조회한다.(Prepayment, Standard)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse searchOwnerAccountListByPaymentSlip(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
    	EsmFms0099Event event = (EsmFms0099Event)e;
	    
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	    
		try {
			
			List<OwnerAccountByPaymentSlipVO> searchOwnerListByPaymentSlipVO = command.searchOwnerAccountListByPaymentSlip(event.getFletCtrtNo(), 
																																																	event.getOfcCd(), 
																																																	event.getCsrCurrCd(), 
																																																	event.getSlpTp());
	
			eventResponse.setRsVoList(searchOwnerListByPaymentSlipVO);
	
			return eventResponse;
	
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
    }    
    
    /**
	 * GL 대사이후 Settle Date 를 update 한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
    private EventResponse modifySettleDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0087Event event = (EsmFms0087Event)e;
		
		TCharterIOInvoiceBC command = new TCharterIOInvoiceBCImpl();
		
		try{
			begin();
			if (event.getSearchOwnerInvoiceListVOS() != null) {
				command.modifySettleDate(event.getSearchOwnerInvoiceListVOS());		
				eventResponse.setUserMessage(new ErrorHandler("FMS00001").getUserMessage());
				commit();
			}
		} catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
    
    /**
	 * CSR cancel 처리한다.<br>
	 * 
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCsrCancel(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	
		EsmFms0041Event event = (EsmFms0041Event)e;
	
		TCharterIOConsultationBC command = new TCharterIOConsultationBCImpl();
	
		try {
	
			String usrId = account.getUsr_id();
	
			begin();
			
			String fletCtrtTpCd = event.getFletCtrtTpCd();
			if (event.getSlipType().equals("RV")) {
				fletCtrtTpCd = "RV";
			}
			else if (event.getSlipType().equals("AR")) {
				fletCtrtTpCd = "AR";
			}
			
			command.manageCsrCancel(fletCtrtTpCd, event.getCsrNo(), "Cancel", usrId);

			TCharterIOInvoiceBC invcommand = new TCharterIOInvoiceBCImpl();

			//AP, AR 공통,  용선/대선 전표가 취소 되면 Invoice에 전표번호가 Null 로 변경된다
			invcommand.modifySlipApprovalCancelInvoice(event.getCsrNo(), usrId);
			
			//AP - TI이거나 값이 없는 경우일때만 실행
			if (event.getFletCtrtTpCd().equals("TI") || event.getFletCtrtTpCd().equals("")) {
				//용선 전표가 취소 되면 Owner's Account 에 전표번호가 Null 로 변경된다
				invcommand.modifySlipApprovalCancelOwnerAccount(event.getCsrNo(), usrId);

				TCharterIOBunkerRegisterBC bnkcommand = new TCharterIOBunkerRegisterBCImpl();
				//용선인 경우 전표가 취소되면 Bunker의 전표 정보도 Null 로 업데이트된다
				bnkcommand.modifySlipApprovalCancelBunker(event.getCsrNo(), usrId);
			
			// 대선인 경우 AP, AR 공통(Bunker처리) 
			} else if(event.getFletCtrtTpCd().equals("TO")) {
				TCharterIOBunkerRegisterBC bnkcommand = new TCharterIOBunkerRegisterBCImpl();
				//용선인 경우 전표가 취소되면 Bunker의 전표 정보도 Null 로 업데이트된다
				bnkcommand.modifyApArSlipApprovalCancelBunker(event.getCsrNo(), usrId);
			}
	
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001",new String[]{}).getUserMessage());
	
			commit();
	
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	
		return eventResponse;
	 }
}