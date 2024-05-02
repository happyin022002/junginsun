/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : OutboundBLMgtSC.java
 *@FileTitle : Container Information
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.23
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.04.23 김영출
 * 1.0 Creation 
---------------------------------------------------------------------------
 History
* 2010.12.06 전성진 [CHM-201007381] BKG/DOC Email 전송시 User Information에 Email이 누락된 경우 IAM 메일주소로 처리
* 2010.12.07 최도순 [CHM-201007310] BKG C/M 화면에 DG SEQ 선택 필드 (구주 24 HR)
* 2011.03.22 이일민 [CHM-201109424-01] B/L Issue and On-Board Date Update 기능 보완
* 2011.03.31 조원주 [CHM-201109864] Customer E-Mail Address 입력 column 추가
* 2011.05.02 최도순 [CHM-201108221-01][CSR] 전자선하증권 시범사업 Test 환경 구축
* 2011.05.12 이일민 [CHM-201110625] [BKG] BS code validation 조건 일부 변경 요청
* 2011.07.14 김진승 [CHM-201111820] Split 03-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
* 2011.07.19 김진승 [CHM-201111820] Split 03-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치; File 관련 FileUtils 사용으로 변경;
* 2011.10.18 김종호 [CHM-201113664] ALPS EAI 연동 개발- 홈페이지 OBL 출력 시 ALPS에 정보 I/F 기능 추가 (Web0040001)
* 2011.10.20 김종호 [CHM-201113688] ALPS EAI 연동 개발- 홈페이지 BL 발급요청 시 ALPS에 정보 I/F 기능 추가 (Web0050001)
* 2011.11.29 정선용 [CHM-201113753-01] Split 01-Korea CLL 전송 후 변동사항 발생 시 SMS 자동 발송 기능 개발 요청
* 2011.12.01 김종호 [CHM-201114841] [BKG] B/L 발급 신청 수정 요청
* 2011.12.06 김종호 [CHM-201114075] [Homepage Renewal] EAI-Webservice I/F 개발 (AES NO Input) (Web0060001)
* 2011.12.19 정선용 [CHM-201115046-01]	선적변경시 웹메일 & SMS 서비스 개발 건 보완요청(2차)
* 2012.07.05 전성진 []C/A mode에서 Container Move시에 COP 호출 로직 변경
* 2012.08.03 이재위 [CHM-201218218] Simple S/I Download 기능 강화를 위한 CUP, ALPS 변경 요청
* 2012.11.08 김보배 [CHM-201221406] [BKG] 이란 Sanction 관련 HS Code 삽입 로직 보완 요청
* 2012.11.20 이준근 [CHM-201221047-01] B/L Type의 예외적 처리를 위한 변경 요청
* 2012.11.16 김보배 [CHM-201221290] [BKG] B/L Issue 화면에 B/L HOLD 기능 추가 & B/L Status Report 기능 보완 (NSC #2 & #3)
* 2013.01.02 조정민 [CHM-201222086] BKG 화면의 BS code 지정 exception logic 수정
* 2013.02.27 조원주 [CHM-201322879] B/L Re-Issue FuncLog 추가
* 2013.04.16 김태경 [CHM-201323781] [E-BKG] 301 자동 전송 로직 보완 요청
* 2013.04.23 김보배 [CHM-201324188] [BKG] "Not updated container" Clear 버튼 생성
* 2013.04.29 김태경 [CHM-201323821] B/L ISSUE 에서 ROUTE 정보를  LOG에 관리 하도록 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt;
 
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import weblogic.wsee.util.StringUtil;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBC;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBCImpl;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBCImpl;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.basic.StatusInquiryBCImpl;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBStatusByBkgNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.BkgEtcHisVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryTableVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlckListMntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgRouteVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic.EBookingReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic.EBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.basic.GeneralBookingListSearchBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.basic.GeneralBookingListSearchBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg0616Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgClauseLockVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingCreationVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SmsRequirementResultVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Vender301ParamVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.CntrComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclCgoAproApplVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.basic.SpecialCargoRiderBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.basic.SpecialCargoRiderBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.BlRiderInVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.BlRiderOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.basic.BDRCorrectionBC;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.basic.BDRCorrectionBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgMdtItmVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgUserSmsListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.basic.UserSetupMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.basic.UserSetupMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BkgSrchSetVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.vo.BlckKwListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBC;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.basic.BrcsManifestDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrHsCdCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrHsCdDetailVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBC;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBCImpl;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OblRdemVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.ArrivalNoticeBC;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.ArrivalNoticeBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.SurchargeAutoRatingBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.SurchargeAutoRatingBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgModiOfcPrcVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgObsSurchargeRateVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.EmailPpdInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchChgRateByLBPVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg007904Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg007906Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg007907Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0170Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0178Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0360Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg036101Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0366Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0399Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0648Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0707Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0892Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg0901Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg1050Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg1051Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg1133Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg1134Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg1184Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg1187Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event.EsmBkg3004Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration.BLDocumentationBLDBDAO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgCustShpRqstVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgIfManageInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgIfManageListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgIfManagerEdiInputVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgIfManagerEdiVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgListForTmlVermasEdiInputVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BlCopyInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BlCopyOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmByCntrVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmCntrInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmCopyVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmGoodsDescVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmSelfMailVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrAdjVolVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCmBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCmDescInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCmEtcInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCopyVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrDetailInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrEtcInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrInfoOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrPkgWgtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrTpszQtyVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.DGCargoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.EdiNotUpdCntrVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblCntrVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblDtlInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblForMndVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblTmpltVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MndVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.NvoccFileNoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.RataBkgQtyVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XterVgmInfoValidationVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XterVgmRqstListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0059Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg007909Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0218Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0221Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0278Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0400Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0418Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0649Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0726Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg0927Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg1071Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg1074Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg1096Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg1116Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg1117Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg1118Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg1119Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg9460Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg9462Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg9463Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg9464Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg9466Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg9467Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkg9468Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkgWeb0040001Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.event.EsmBkgWeb0050001Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.AgentEmlVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.AuthCustVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgWebService004VO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgWebService005VO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlAtchVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlCertiRqstVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssRqstVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssueVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlStatusVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblEdiInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblEdiVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblCntVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DocRqstVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.EBLIssueVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlDtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlPrtOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.GrpBlPrtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.MultiNtcHisVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.N3ptyBlRqstVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.ReIssueInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.ReIssueVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.SearchReminderEmailVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.SrndVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.basic.EmptyReleaseOrderBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.basic.EmptyReleaseOrderBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.event.EsmBkg0252Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdDetailOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdSimpleOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.MtyRlseOrdUsaOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.SendMtyRlseOrdVO;
import com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.basic.RASCommonBC;
import com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.basic.RASCommonBCImpl;
import com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBC;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic.OwnDangerousCargoApprovalBC;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic.OwnDangerousCargoApprovalBCImpl;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionOutputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionPortVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionVesselOperatorVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.basic.PartnerLinesDangerousCargoApprovalBCImpl;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.io.FileUtils;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.table.ComBakEndJbVO;
import com.hanjin.syscommon.common.table.BkgBookingVO;
import com.hanjin.syscommon.common.table.BkgCntcPsonVO;
import com.hanjin.syscommon.common.table.BkgCntrMfDescVO;
import com.hanjin.syscommon.common.table.BkgCntrSealNoVO;
import com.hanjin.syscommon.common.table.BkgContainerVO;
import com.hanjin.syscommon.common.table.BkgCustBlPprMgmtHisVO;
import com.hanjin.syscommon.common.table.BkgCustBlPprMgmtVO;
import com.hanjin.syscommon.common.table.BkgDgCgoVO;
import com.hanjin.syscommon.common.table.BkgDocProcSkdVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.BkgNvoccProfCntrMfVO;
import com.hanjin.syscommon.common.table.BkgNvoccProfVO;
import com.hanjin.syscommon.common.table.BkgReferenceVO;
import com.hanjin.syscommon.common.table.BkgUsrDfltSetVO;
import com.hanjin.syscommon.common.table.BkgUsrTmpltVO;
import com.hanjin.syscommon.common.table.BkgVvdVO;
import com.hanjin.syscommon.common.table.ComUserVO;
import com.hanjin.syscommon.common.table.MasBkgComIfVO;
import com.hanjin.syscommon.common.table.MdmPckTpVO;
import com.hanjin.syscommon.common.table.MstContainerVO;
import com.hanjin.syscommon.common.table.ScgAproRqstVO;
import com.hanjin.syscommon.common.table.ScgVvdAproRqstVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;

/**
 * ALPS-OutboundBLMgt Business Logic ServiceCommand - NIS2010-OutboundBLMgt 대한
 * 비지니스 트랜잭션을 처리한다.
 * 
 * @author Kim Youngchul
 * @see BLDocumentationBLDBDAO
 * @since J2EE 1.4
 */
 
public class OutboundBLMgtSC extends ServiceCommandSupport { 
 
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * OutboundBLMgt system 업무 시나리오 선행작업<br>
	 * UI_BKG-0079-04업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("OutboundBLMgtSC 시작..");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
	}

	/**
	 * OutboundBLMgt system 업무 시나리오 마감작업<br>
	 * UI_BKG-0079-04 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("OutboundBLMgtSC 종료..");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-OutboundBLMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e
	 *            Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		log.debug("::CALL:: OutboundBLMgtSC =====> " + e.getEventName());

		/* ESM_BKG_0079_09Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg007909Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchBlIssInfoDefault(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlIssInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBlIssInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageBlIssue(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSurchargeRatingByLbp(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = checkCaProcessing(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = checkBkgHrdCdgCtnt0079(e);
			}
		} else
		/* ESM_BKG_0649Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0649Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlReIssue(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBlReIssue(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = confirmBlReIssue(e);
			}
		} else
		/* ESM_BKG_0400Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0400Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSurrenderInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifySurrenderInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = searchSurchargeRatingByObs(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeSurrenderInfo(e);
			}
		} else
		/* EsmBkg1074Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg1074Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCustInfo(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = manageBlIssue(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					eventResponse = sendAuthEmail(e);
				}			
		} else
		/* ESM_BKG_0059Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0059Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDocRqst(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyDocRqst(e);
			}
		} else
		/* EsmBkg0079Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0079Event")) {
			eventResponse = new GeneralEventResponse();
		} else
		/* EsmBkg007904Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg007904Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchCombo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchContainer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCntrDtlInfo(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchPartialConfirm(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = validateContainerWgt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)){
				eventResponse = validateCntrRsk(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageContainer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = cancelContainerConfirm(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = modifyCrdDt(e);
			}
		} else
		/* EsmBkg007906Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg007906Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchCombo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMnd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMnd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUserTmpltList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchDG(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchPckTp(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchFukushimaUsedCmdt(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchPoExist(e);
			}
		} else
		/* EsmBkg007907Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg007907Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCm(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCm(e);
			}  else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchHsCdList(e);
			}  else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = validateContainerWgt(e);
			}
		} else
		/* EsmBkg0170Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0170Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = new GeneralEventResponse();
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = copyContainer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = moveContainer(e);
			}
		} else
		/* EsmBkg0178Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0178Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCmByCntr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCmByCntr(e);
			}
		} else
		/* EsmBkg0252Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0252Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = new GeneralEventResponse();
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMtyRlseOrdForSimple(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMtyRlseOrdForDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMtyRlseOrdForUsa(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = sendMtyRlseOrdByFax(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = sendMtyRlseOrdByEmail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = sendMtyRlseOrdByEdi(e);
			}
		} else
		/* EsmBkg0278Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0278Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchCommonCdListVO(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBkgListForGrpBlPr(e);
			}
		} else
		/* EsmBkg0360Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0360Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHblForMnd(e);
			}
		} else
		/* EsmBkg036101Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg036101Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = new GeneralEventResponse();
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchExportImportNumber(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageExportImportNumber(e);
			}
			/* WebService EAI [WEB_006_0001] */
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageExportImportNumber(e);
			}
		} else
		/* EsmBkg0366Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0366Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHbl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageHbl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = asgnMfNo(e);
			}
		} else
		/* EsmBkg0399Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0399Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHblTmplt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageHblTmplt(e);
			}
		} else
		/* EsmBkg0697Event */
		//if (e.getEventName().equalsIgnoreCase("EsmBkg0697Event")) {
			// if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			// eventResponse = searchBkgListForGrpBlPr(e);
			// }
		//} else
		/* EsmBkg0707Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0707Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchGoodsDescByCm(e);
			}
		} else
		/* EsmBkg0726Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0726Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlListForGroupUpdate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyGroupBlUpdate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = releaseGroupBlUpdate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = updateBLComplete(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = validateGroupBlIssue(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = checkBkgHrdCdgCtnt0726(e);
			}
		} else
		/* UiBkg0892Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0892Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCntrListByVvd(e);
			}
		} else
		/* EsmBkg0901Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0901Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNotUpdCntr(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCtmMvmtIrrFlg(e);
			}
		} else
			/* EsmBkg0958Event */
			//if (e.getEventName().equalsIgnoreCase("EsmBkg0958Event")) {
				// if(e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				// eventResponse = searchNotUpdCntr(e);
				// }
		//} else
		/* EsmBkg0648Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0648Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchForCopyBl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = copyBl(e);
			}
		} else
		/* EsmBkg1051Event */
		if(e.getEventName().equalsIgnoreCase("EsmBkg1051Event")){
		    if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchBkgCntrVol(e);
            }
		} else
		/* EsmBkg1050Event */
        if(e.getEventName().equalsIgnoreCase("EsmBkg1050Event")){
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchCntrAdjVol(e);
            }
        } else
    		/* EsmBkg0218Event */
    		if (e.getEventName().equalsIgnoreCase("EsmBkg0218Event")) {
    			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
    				eventResponse = searchComCode0218(e);
    			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
    				eventResponse = searchBkgListForObDblWbl(e);
    			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
    				eventResponse = searchBkgListForIbDblWbl(e);
    			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {  //outbound-fax
    				eventResponse = sendDblWblByFax(e);
    			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {  //outbound-email
    				eventResponse = sendDblWblByEmail(e);
    			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {  //outbound-groupemail
    				eventResponse = sendDblWblByEmail(e);  //sendDblWblByGroupEmail(e);
    			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {  //outbound-email(S/R)
    				eventResponse = sendSrEmail(e);  
    			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {  //outbound-email(E/Q)
    				eventResponse = sendEqEmail(e);  
    			} else if (e.getFormCommand().isCommand(FormCommand.MULTI11)) {  //inbound-fax
    				eventResponse = sendDblWblByFax(e);
    			} else if (e.getFormCommand().isCommand(FormCommand.MULTI12)) {  //inbound-email
    				eventResponse = sendDblWblByEmail(e);
    			} else if (e.getFormCommand().isCommand(FormCommand.MULTI13)) {  //inbound-groupemail
    				eventResponse = sendDblWblByEmail(e);  //sendDblWblByGroupEmail(e);
    			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {  //assign email
    				eventResponse = searchBkgAgentEml(e);
    			}
    		} else
    		/* EsmBkg1071Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg1071Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMultiNtcHis(e);
			}
		} else
		/* EsmBkg0927Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0927Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlInfoForPreview(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				// Email
				eventResponse = sendDblWblByEmail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				// Fax
				eventResponse = sendDblWblByFax(e);
			}
		} else
		/* EsmBkg0418Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0418Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = validMfForPrtByBl(e);
			}
		} else
		/* EsmBkg0221Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg0221Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchBkgInfoForFaxEmail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = sendFaxEmailByBkgNoList(e);
			}
		} else
		/* EsmBkg1096Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg1096Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = setFile(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEmailEdit(e);
			}
    	} else
		
		/* EsmBkg1116Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg1116Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEBLIssueList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageEBLConfirm(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = manageDelConfirm(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = manageConfirm(e);
			}
    	}  else
    		
		/* EsmBkg1117Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg1117Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageEBLReject(e);
			}	
    	}  else
    		
    	/* EsmBkg1118Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg1118Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlInfoForEBLIssue(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageEBLIssue(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = manageEBLReIssue(e);
			}
		}  else
		
		/* EsmBkg1119Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg1119Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComCode1119(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { //retrieve
				eventResponse = searchBlIssRqstList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { //detail
				eventResponse = searchBlIssRqstInquiry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { //delete
				eventResponse = modifyBlIssRqstDeltFlg(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) { //approval
				eventResponse = modifyBlIssRqstApproval(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) { //reject
				eventResponse = modifyBlIssRqstReject(e);
			}
		} 	else
		
		/* EsmBkg1133Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg1133Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBkgCustShpRqstList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBkgCustShpRqst(e);
			} 
		}  else
			/* EsmBkg1134Event */
			if (e.getEventName().equalsIgnoreCase("EsmBkg1134Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchBkgCntrShpRqst(e);
			} 
		}  else
			
		/* WebService EAI [WEB_004_0001] */
		if (e.getEventName().equalsIgnoreCase("EsmBkgWeb0040001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = modifyWeb0040001ControlMgmt(e);				
			} 
		}  else
		
		/* WebService EAI [WEB_005_0001] */
		if (e.getEventName().equalsIgnoreCase("EsmBkgWeb0050001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = modifyWeb0050001ControlMgmt(e);
			} 
		} else 
			/* EsmBkg9460Event */
			if (e.getEventName().equalsIgnoreCase("EsmBkg9460Event")) {
				if (e.getFormCommand().isCommand(FormCommand.INIT)) {
					eventResponse = searchComCode9460(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { //retrieve
					eventResponse = searchN3ptyBlRqst(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { //create
					eventResponse = createN3ptyBlRqst(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { //Save
					eventResponse = modifyN3ptyBlRqst(e);
				}
			}else 
			/* EsmBkg9462Event */
			if (e.getEventName().equalsIgnoreCase("EsmBkg9462Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { //retrieve
					eventResponse = searchBlIssNote(e);
				}
			}else 
		    /* EsmBkg9463Event */
			if (e.getEventName().equalsIgnoreCase("EsmBkg9463Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchBlAtchList(e); 
				}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageBlAtch(e);
				}
			}else 
			    /* EsmBkg9464Event */
				if (e.getEventName().equalsIgnoreCase("EsmBkg9464Event")) {
					if (e.getFormCommand().isCommand(FormCommand.INIT)) {
						eventResponse = searchComCode9464(e);
					} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
						eventResponse = searchBlCertiRqst(e); 
					}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
						eventResponse = manageBlCertiSts(e);
					}
			}else 
			    /* EsmBkg9464Event */
				if (e.getEventName().equalsIgnoreCase("EsmBkg9466Event")) {
					if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
						eventResponse = searchBlRiderList(e);
					}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
						eventResponse = manageBlRider(e);
					}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
						eventResponse = manageBlCertiPrn(e);
					}
				}
				else if (e.getEventName().equalsIgnoreCase("EsmBkg9467Event")) {
					if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
						eventResponse = searchBlPprMgmt(e);
					} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
						eventResponse = searchComCode9467(e);
					} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
						eventResponse = checkBlPprMgmt(e);
					} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
						eventResponse = manageBlPprMgmt(e);
					}
				}else if (e.getEventName().equalsIgnoreCase("EsmBkg9468Event")) {
					if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
						eventResponse = searchBlPprMgmtHis(e);
					}
				}else if (e.getEventName().equalsIgnoreCase("EsmBkg1184Event")) {
					if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
						eventResponse = searchXterVgmList(e);
					}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
						eventResponse = uploadXterVgmInfo(e);
					}
				}else if (e.getEventName().equalsIgnoreCase("EsmBkg1187Event")) {
					if(e.getFormCommand().isCommand(FormCommand.DEFAULT)){
						eventResponse = searchComCode1187(e);
					}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
						eventResponse = searchBkgListForGeneralVermasEdi(e);
					}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
						eventResponse = sendTerminalVermasEdiMulti(e);
					}
				}
		/* EsmBkg3004Event */
		if (e.getEventName().equalsIgnoreCase("EsmBkg3004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchCombo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBkgIfList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBkgIfList01(e);				
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = manageBkgInterface01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
                eventResponse = manageBkgInterface02(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = manageBkgInterface03(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = manageBkgInterface04(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = manageBkgInterface04(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchBkgIfStatus(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchBkgSendList(e);	
			}
		}
		
		return eventResponse;
	}

	
	/**
	* EsmBkg1074Event 버튼 이벤트 처리(ESM_BKG_1074)<br>
	* Internet O.B/L Print Authorize[UC-BKG-009 B/L 발행 송부]<br>
	* B/L Issue 화면(UI_BKG-0079-09) 의 Internet Auth 버튼에 연결된 팝업<br>
	* 
	* @author LEE JIN SEO
	* @param e Event
	* @return EventResponse
	* @exception EventException
	*/
	private EventResponse searchCustInfo(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();
		List<AuthCustVO> authCustVOs = null;
		EsmBkg1074Event event = (EsmBkg1074Event) e;
		String bkg_no = event.getBkgNo();
		//String bl_no = event.getBlNo();

		try {
			log.debug("START: searchCustInfo() ====> [" + e.getEventName() + "]");
			// 1. CUSTOMER SHPR/FWDR 데이터 조회
			authCustVOs = command.searchCustInfo(bkg_no);
			log.debug("END: searchCustInfo() ====> [" + e.getEventName() + "]");
			eventResponse.setRsVoList(authCustVOs);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {			
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	* EsmBkg1074Event 버튼 이벤트 처리(ESM_BKG_1074)<br>
	* 이메일 발송 송부<br>
	* 
	* @author LEE JIN SEO
	* @param e Event
	* @return EventResponse
	* @exception EventException
	*/
	private EventResponse sendAuthEmail(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command 	= new BLIssuanceBCImpl();
		EsmBkg1074Event event 	= (EsmBkg1074Event) e;
    	BookingUtil util = null;

		String recipient		= event.getEmailTo();
		String subject 			= event.getEmailSubject();
		String cntent 			= event.getEmailContents();

		try {
			begin();
			log.debug("START: sendAuthEmail() ====> [" + recipient + "]");
			log.debug("START: sendAuthEmail() ====> [" + subject + "]");
			log.debug("START: sendAuthEmail() ====> [" + cntent + "]");
			// 수정  account.getUsr_Eml() -> getDfltEml()

			ComUserVO comUserVO = null;
			util = new BookingUtil();
			comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
//			String sUsrEml = new BookingUtil().searchComUserInfo(account.getUsr_id()).getDfltEml();
			
			String[] recipientArr    = recipient.split("\\;");
			int size = recipientArr.length;
			 for(int i=0;i<size;i++){
				 if(recipientArr[i].equals("")) continue;
				 	Mail amail = new Mail();	        	
		        	
		    		amail.setRecipient(recipientArr[i]);
//		    		amail.setFrom(account.getUsr_eml());
		    		amail.setFrom(sUsrEml);
		    		amail.setSubject(subject);
		    		amail.setHtmlContent(cntent);
		        	// CC, BCC미설정시 null이 들어가는 문제가 있어 set 2010.01.14 by cateshin
		        	//mailCustomVO.setCarbonCopy(cc);
		        	//mailCustomVO.setBlindCarbonCopy(cc);
		    		
					// 메일전송
					command.sendAuthEmail(amail);
					
			 }
			log.debug("END: sendAuthEmail() ====> [" + recipient + "]");
			commit(); 

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {			
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
    /**
     * Partial Container Volume 조정시 관련 같은 VVD에서 같은 Container를 사용하는 BKG No. 및 Vol을 조회한다.(ESM_BKG_1050)
     * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCntrAdjVol(Event e) throws EventException {
      
        EsmBkg1050Event event = (EsmBkg1050Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        BookingUtil utilCmd = new BookingUtil();
        BLDocumentationCMBC docCmd = new BLDocumentationCMBCImpl();

        log.debug("==========>" + event.getBkgNo());
        log.debug("==========>" + event.getCntrNo());

        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(event.getBkgNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());
        
        try {
            /* searchBkgBlNoVO */
            BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
            if(bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
                throw new EventException(new ErrorHandler("BKG01049", new String[]{event.getBkgNo()}).getMessage());
            }
            
            List<CntrAdjVolVO> cntrAdjVolVOs = docCmd.searchCntrAdjVol(event.getBkgNo(), event.getCntrNo());

            eventResponse.setRsVoList(cntrAdjVolVOs);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {			
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }
    

    /**
     * EQ Detail 과 Container의 입력현황을 비교하기 위해 EQ Detail 정보를 조회함 -- UI_BKG-1051 (BKG_QTY_DTL)(ESM_BKG_1051)
     * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchBkgCntrVol(Event e) throws EventException {
        log.debug("[START:: OutboundBLMgtSC.searchBkgCntrVol]");
        EsmBkg1051Event event = (EsmBkg1051Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        BookingUtil utilCmd = new BookingUtil();
        BLDocumentationCMBC docCmd = new BLDocumentationCMBCImpl();

        String bkgNo = event.getBkgNo();
        log.debug("==========>" + bkgNo);

        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(bkgNo);
		bkgBlNoIN.setCaUsrId(account.getUsr_id());
        
        try {
            /* searchBkgBlNoVO */
            BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
            if(bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
                throw new EventException(new ErrorHandler("BKG01049", new String[]{bkgNo}).getMessage());
            }
            
            List<RataBkgQtyVO> rageBkgQtyVOs = docCmd.searchBkgCntrVol(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getCaFlg());

            eventResponse.setRsVoList(rageBkgQtyVOs);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {			
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
        return eventResponse;
    }
    
	/**
	 * B/L Issue Default 조회.(ESM_BKG_0079_09)<br>
	 *
	 * @author LEE JIN SEO
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBlIssInfoDefault(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil bookingUtil = new BookingUtil();

		try{
			// 01. on_board_type 데이터 조회 
			List<BkgComboVO> on_board_type  = bookingUtil.searchCombo("CD01645");
			eventResponse.setRsVoList(on_board_type);
			// 02. bl_ready_type 데이터 조회 
			List<BkgComboVO> bl_ready_type  = bookingUtil.searchCombo("CD01647");
			eventResponse.setRsVoList(bl_ready_type);
			// 03. bl_ready_type 데이터 조회 
			List<BkgComboVO> confirm  = bookingUtil.searchCombo("CD02393");
			eventResponse.setRsVoList(confirm);
			// 04. bl_hld_rsn_cd 데이터 조회 
			List<BkgComboVO> bl_hld_rsn_cd  = bookingUtil.searchCombo("CD03122");
			eventResponse.setRsVoList(bl_hld_rsn_cd);
		}catch(EventException ex){
			log.debug("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.debug("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;	
	}
    /**
	 * EsmBkg007909Event 조회 이벤트 처리(ESM_BKG_0079_09)<br>
	 * B/L Issue 정보 조회<br>
	 * B/L Type, Freight 지불 여부 등의 B/L 발행 전 필요사항을 기입
	 * 
	 * @author LEE JIN SEO
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchBlIssInfo(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();
		BookingUtil util = new BookingUtil();

		EsmBkg007909Event event = (EsmBkg007909Event) e;
		String bkg_no 	= event.getBkg_no();
		String bl_no 	= event.getBl_no();

		try {
			
			log.debug("[조건추가] ========== searchBkgCgoTp [START] ==========> ");
        	//bkg_no번호가 없는경우 :  bl_no로 bkg_no가져오기 
			BookingUtil bookingUtil = new BookingUtil();
        	if(bl_no.length()>12) bl_no = bl_no.substring(0,12);
			if(bkg_no.length() == 0 && bl_no.length() != 0 ){ // 2011.07.15
				if(bl_no.length()>12) bl_no = bl_no.substring(0,12);
				bkg_no = bookingUtil.searchBkgNoByBlNo(bl_no);	
			}
        	
			// bkg_no 존재유무판단 
			BkgBlNoVO bkgBlNo = new BkgBlNoVO();
			bkgBlNo.setBkgNo(bkg_no);
			bkgBlNo.setBlNo(bl_no);	
			bkgBlNo.setCaUsrId(account.getUsr_id());
			
			BkgBlNoVO bkgBlNoVO = bookingUtil.searchBkgBlNoVO(bkgBlNo);
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
//				throw new Exception(new ErrorHandler("BKG01049", new String[] { bkg_no }).getMessage());
				throw new EventException(new ErrorHandler("BKG01049", new String[] { bkg_no }).getMessage());
			}
			// bkg_no가  P 일경우 return 처리 
        	String bkgStsCd = bookingUtil.searchBkgCgoTp(bkgBlNoVO);
        	if (bkgStsCd.equals("P")) {
        		throw new EventException(new ErrorHandler("BKG40030").getMessage());
        	}
        	
			log.debug(" ========== searchBkgCgoTp [END] ==========> ");
			bl_no=bkgBlNoVO.getBlNo();
			BlIssueVO blIssueVO = new BlIssueVO();
			blIssueVO.setAccount(account);
			blIssueVO.setBkg_no(bkg_no);
			blIssueVO.setBl_no(bl_no);

			// 1. OFT Note를 조회한다.
			BlIssueVO rBlIssueVO = command.searchBlIssInfo(blIssueVO);
			
			// 2. tpbStatus 조회한다.
			StatusInquiryBCImpl tpbIF = new StatusInquiryBCImpl(); //TPB BC 선언
			SearchTPBStatusByBkgNoVO searchTpbStatusByBkgNoVO = new SearchTPBStatusByBkgNoVO();
            searchTpbStatusByBkgNoVO.setSbkgno(bkg_no);
            String tpbStatus = tpbIF.searchTpbStatusByBkgNo(searchTpbStatusByBkgNoVO);
			
			//[요구사항추가] by 신자영 
            //1. Documentation Requirement를 조회해서, 버튼 색상여부판단 
			List<DocRqstVO> docRqstList = command.searchDocRqst(bkg_no, "");
			String docReqButton ="N";
			
			if(docRqstList.size()>0){
		    
				DocRqstVO dvo = docRqstList.get(0);
						
				int vOblTtlKnt = (dvo.getOblTtlKnt().trim().length() == 0 ? 0 : Integer.parseInt(dvo.getOblTtlKnt()));
				int vCpyTtlKnt = (dvo.getCpyTtlKnt().trim().length() == 0 ? 0 : Integer.parseInt(dvo.getCpyTtlKnt()));
				int totCount = vOblTtlKnt + vCpyTtlKnt;
			
				totCount = totCount 
							+dvo.getRqstIssDt().trim().length() 
							+dvo.getRqstIssPlcNm().trim().length()
							+dvo.getBlDeMzdCd().trim().length()
							+dvo.getBlDeToCd().trim().length()
							+dvo.getBlDocRqstRmk().trim().length()
							+dvo.getRqstBlTpCd().trim().length();
				
				if(totCount>0){ 
					docReqButton ="Y";
				}
			}
			//BL ISSUE NOTE버튼 색	
			List<BkgMdtItmVO> bkgMdtItmVOs= command.searchBlIssNote(bkg_no);
			String blNoteButton ="N";
			if(bkgMdtItmVOs.size()>0 && bkgMdtItmVOs != null){
				blNoteButton ="Y";
			}
			//BL Request버튼 색
			String output_text = util.n3rdPartyBlReqAvailable(bkg_no);
			eventResponse.setETCData("output_text", output_text);
			
			// 추가요구사항   by 신자영 
        	eventResponse.setETCData("corr_flg", bkgBlNoVO.getCaFlg());
            eventResponse.setETCData("ca_exist_flg", bkgBlNoVO.getCaExistFlg());
			// Caflag
			eventResponse.setETCData("caflag"    	, bkgBlNoVO.getCaFlg());
			// Bdrflag
            eventResponse.setETCData("bdrflag"    	, bookingUtil.searchBdrFlgByBkg(bkgBlNoVO));
            
			// 추가요구사항  색상변경 by 전성진 
			String vesselVoyageDirectionEqual = bookingUtil.vesselVoyageDirectionEqual(bkg_no);
			//docReqButton
	         eventResponse.setETCData("vesselVoyageDirectionEqual", vesselVoyageDirectionEqual);
			//docReqButton
	         eventResponse.setETCData("docReqButton", docReqButton);
            // tpbStatus
            eventResponse.setETCData("tpbStatus"    , tpbStatus);
			//BLIssuenoteqButton
	         eventResponse.setETCData("blNoteButton", blNoteButton);
            //bl_not_ready
            eventResponse.setETCData("blNoReady"    , rBlIssueVO.getBl_not_ready());
            //bkg_no
            eventResponse.setETCData("bkg_no"    	, bkgBlNoVO.getBkgNo());
			// biissinfo
			eventResponse.setRsVoList(rBlIssueVO.getBlIssInfoList());
			// precarriage
			eventResponse.setRsVoList(rBlIssueVO.getPreCarriageList());
			// vesselvoyage
			eventResponse.setRsVoList(rBlIssueVO.getVesselVoyagedList());
			//otsRcvInfoVO
			eventResponse.setRsVo(rBlIssueVO.getOtsRcvInfoVO());
			
		}catch (EventException ex) {
			throw ex;
		}catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EsmBkg007909Event 저장 이벤트 처리(ESM_BKG_0079_09)<br>
	 * bl issue 관련 정보를 관리한다.<br>
	 * 
	 * @author LEE JIN SEO
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageBlIssInfo(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();

		EsmBkg007909Event event = (EsmBkg007909Event) e;
		String uiId = "ESM_BKG_0079_09";
		String bkg_no = event.getBkg_no();
		String bl_no = event.getBl_no();
		BlIssInfoVO[] blIssInfoVOs = event.getBlIssInfoVOs();
		
		BlIssueVO blIssueVO = new BlIssueVO();
		blIssueVO.setAccount(account);
		blIssueVO.setBkg_no(bkg_no);
		blIssueVO.setBl_no(bl_no);
		
		BlIssInfoVO blIssInfoVO = blIssInfoVOs[0];
		blIssInfoVO.setUpdUsrId(account.getUsr_id());
		blIssueVO.setBlIssInfoVO(blIssInfoVO);
		
		HistoryTableVO historyTableVO = new HistoryTableVO ();
		String onBrdDt ="";
		String onBrdDtOld ="";
		
		try {
			begin();
			/* BKG_BL_DOC 변경 History 를 Log 테이블에 관리 한다. */
			BookingUtil utilCmd = new BookingUtil();
			utilCmd.addBkgLog("BKG_BLISSINFO", bkg_no, "usr id: "+account.getUsr_id());
			BlIssInfoVO blIssHisVO = new BlIssInfoVO();
			blIssHisVO = utilCmd.searchBlRouteInfo(bkg_no);
			if(null != blIssHisVO){
				utilCmd.addBkgLog("BKG_BLBF_ROUTE", bkg_no,  "usr id: "+account.getUsr_id() + " POR: "+blIssHisVO.getPorCode()
																							+ " PORNM: "+blIssHisVO.getPorName()
																							+ " POL: "+blIssHisVO.getPolCode()	
																							+ " POLNM: "+blIssHisVO.getPolName()	
																							+ " POD: "+blIssHisVO.getPodCode()	
																							+ " PODNM: "+blIssHisVO.getPodName()	
																							+ " DEL: "+blIssHisVO.getDelCode()
																							+ " DELNM: "+blIssHisVO.getDelName()
						);
			}
			/*
			//[기능추가]clt_ofc_cd  office cd를 체크한다.
			BookingUtil utilCmd = new BookingUtil();
        	String existThird  = utilCmd.existThirdCode(blIssInfoVO.getPpdRcvUserOffice());
        	if(existThird.equals("N")){
        		 throw new EventException(new ErrorHandler("BKG00905").getMessage());//Third Office is not available
        	}
			*/
			
			// 1.[] IBookingHistoryMgtBC::manageBkgHistory ( historyTableVO , uiId )
			/* Manage Booking History */

			//I BookingHistoryMgtBC::searchOldBkgForHistory ( uiId , bkgBlNoVo )
			BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
			
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(bkg_no);
//			bkgBlNoVO.setBlNo(bl_no);	
			bkgBlNoVO.setCaUsrId(account.getUsr_id());
			bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoVO);
			historyTableVO = bookingHistoryMgtBC.searchOldBkgForHistory(uiId, bkgBlNoVO);
			
			// 2.[] IBLIssuanceBC::manageBlIssInfo ( blIssueVO )
			// [] BLIssuanceDBDAO::manageBlIssInfo ( blIssueVO )
			// ≪≫ manageBlIssInfo ( [in] blIssueVO : BlIssueVO ) : void
			command.manageBlIssInfo(blIssInfoVO);
			
			// 3. [] IGeneralBookingReceiptBC::modifyBlType ( bkgNo , blTpCd )
			// [] GeneralBookingReceiptDBDAO::modifyBlType ( bkgNo , blTpCd )
			GeneralBookingReceiptBC generalBookingReceiptBC = new GeneralBookingReceiptBCImpl();
			String blTpCd = blIssInfoVO.getBlIssueblType();
			generalBookingReceiptBC.modifyBlType(bkg_no,blTpCd);

			// 4. [] IBLDocumentationBLBC::modifyBlIssInfoForBlDoc ( blIssueVO )
			// [] BLDocumentationBLDBDAO::modifyBlIssInfoForBlDoc ( blIssueVO )
			BLDocumentationBLBC bLDocumentationBLBC= new BLDocumentationBLBCImpl();
			bLDocumentationBLBC.modifyBlIssInfoForBlDoc(blIssInfoVO);  
	  	  
        	log.debug("\n======= Auto EDI Send ======\n");
        	List<BkgNtcHisVO> bkgNtcHisVOs = command.createDraftBlEdiAuto(bkgBlNoVO.getBkgNo(), "N",  account);

			if (bkgNtcHisVOs != null) {
				if (bkgNtcHisVOs.size() > 0) {
					
					//philips 계약인 BKG에 대해서 DBL전송
					String philips = command.searchPhilipsCheck(bkgBlNoVO.getBkgNo());
					
	    			//philips 계약인 BKG에 대해서 DBL전송
	    			if(null!=philips && !"".equals(philips)){
	    				List<BkgNtcHisVO> bkgHisVOs = null;
	    				StringBuilder sbParam = new StringBuilder();
	    				
	    				String draftRemark = command.searchDraftRemark(bkgBlNoVO.getBkgNo());

	                	
	            		sbParam.append("/rv");
	            		sbParam.append(" form_bkgNo[('").append(bkgBlNoVO.getBkgNo()).append("')]");
	            		sbParam.append(" form_type[").append("2").append("]");
	            		sbParam.append(" form_dataOnly[N]");
	            		sbParam.append(" form_manifest[N]");
	            		sbParam.append(" form_usrId[").append(account.getUsr_id()).append("]");
	            		sbParam.append(" form_hiddeData[N]");
	            		sbParam.append(" form_level[(").append(1).append(")]");
	            		sbParam.append(" form_remark[").append(draftRemark).append("]");
	            		sbParam.append(" form_Cntr[1]");
	            		sbParam.append(" form_mainOnly[N]");
	            		sbParam.append(" form_CorrNo[]");
	            		sbParam.append(" form_his_cntr[BKG_CONTAINER]");
	            		sbParam.append(" form_his_bkg[BKG_BOOKING]");
	            		sbParam.append(" form_his_mkd[BKG_BL_MK_DESC]"); 
	            		sbParam.append(" form_his_xpt[BKG_XPT_IMP_LIC]");
	            		sbParam.append(" form_his_bl[BKG_BL_DOC]");
	            		sbParam.append(" /rp []");
	            		sbParam.append(" /riprnmargin");
	            		
	    				
	    				DblWblVO[] dblWblVOs = new DblWblVO[1];
	    				dblWblVOs[0] = new DblWblVO();
	    				dblWblVOs[0].setBkgNo(bkgBlNoVO.getBkgNo());
	    				dblWblVOs[0].setBlNo(bkgBlNoVO.getBlNo());
	    				dblWblVOs[0].setSyscd("BKG");
	    				dblWblVOs[0].setTmplmrd("ESM_BKG_0109_DBL.mrd");
	    				dblWblVOs[0].setBatchflg("N");
	    				dblWblVOs[0].setTmplparam(sbParam.toString());
	    				dblWblVOs[0].setRcveml(philips);
	    				dblWblVOs[0].setTmplmrdpdf("SMLM"+bkgBlNoVO.getBkgNo()+".pdf");
	    				dblWblVOs[0].setItr("|$$|");
	    				dblWblVOs[0].setNtcKndCd("BL");
	    				dblWblVOs[0].setHiddOpt("N");
	    				dblWblVOs[0].setFrtAllFlg("Y");
	    				dblWblVOs[0].setFrtCltFlg("N");
	    				dblWblVOs[0].setFrtPpdFlg("N");
	    				dblWblVOs[0].setFrtChgFlg("N");
	                    dblWblVOs[0].setFrtArrFlg("N");
	                    
	                    //DPCS가 아니더라도 sender email주소 front office로
	                    dblWblVOs[0].setFntEmlFlg("Y");
	                    bkgHisVOs = command.sendDblWblByEmail(dblWblVOs, null, account);
	    				if(bkgHisVOs.size()>0){
	    					bookingHistoryMgtBC.createBkgNtcHis(bkgHisVOs,"ESM_BKG_0095");
	    				}

	    			}
					bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs,"ESM_BKG_0095");
				}
			}	
			
			bookingHistoryMgtBC.manageBookingHistory(uiId, historyTableVO, account);
			
			/* BKG_BL_DOC 변경 History 를 Log 테이블에 관리 한다. */
			blIssHisVO = utilCmd.searchBlRouteInfo(bkg_no);
			if(null != blIssHisVO){
				utilCmd.addBkgLog("BKG_BLAF_ROUTE", bkg_no,  "usr id: "+account.getUsr_id() + " POR: "+blIssHisVO.getPorCode()
																							+ " PORNM: "+blIssHisVO.getPorName()
																							+ " POL: "+blIssHisVO.getPolCode()	
																							+ " POLNM: "+blIssHisVO.getPolName()	
																							+ " POD: "+blIssHisVO.getPodCode()	
																							+ " PODNM: "+blIssHisVO.getPodName()	
																							+ " DEL: "+blIssHisVO.getDelCode()
																							+ " DELNM: "+blIssHisVO.getDelName()
						);
			}
			
			// MAS IF : On-board Date 바뀐 경우 I/F 
			onBrdDt = ("000000".equals(blIssInfoVO.getOnBoardDate()))?"":blIssInfoVO.getOnBoardDate(); 
			onBrdDtOld = (historyTableVO.getBkgBlDocVO().getBlObrdDt()).replaceAll("[^0-9]",""); 
			if(!onBrdDt.equals(onBrdDtOld)) { // MAS 호출 

				CostAssignBC masCmd  = new CostAssignBCImpl();
				MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO(); 
				masBkgComIfVo.setBkgNo(bkg_no); 
				masBkgComIfVo.setCostSrcSysCd("BKG"); 
				masBkgComIfVo.setIfRmk("Onboard Date"); 
				masBkgComIfVo.setCreUsrId(account.getUsr_id()); 
				masBkgComIfVo.setUpdUsrId(account.getUsr_id()); 
				masCmd.modifyMasCommonInterface(masBkgComIfVo); 
				}
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06014").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * EsmBkg007909Event 버튼 이벤트 처리(ESM_BKG_0079_09,ESM_BKG_1074)<br>
	 * B/L Issue  관련 정보를 관리한다<br>
	 * Issue/Internet AUTH/SWB Release/Cancel AUTH
	 * 
	 * @author LEE JIN SEO
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageBlIssue(Event e) throws EventException {
		
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		BLIssuanceBC 			command 	= new BLIssuanceBCImpl();
		BLDocumentationBLBC 	blBC 		= new BLDocumentationBLBCImpl();
		EsmBkg007909Event event 			= (EsmBkg007909Event) e;
		String bkg_no 						= event.getBkg_no();
		String bl_no 						= event.getBl_no();
		String buttonType 					= event.getButtonType();
		String setupfocoblflag 				= event.getSetupfocoblflag();
		
		BlIssInfoVO[] blIssInfoVOs 			= event.getBlIssInfoVOs();
		BlIssueVO blIssueVO 				= new BlIssueVO();
		blIssueVO.setAccount(account);
		blIssueVO.setBkg_no(bkg_no);
		blIssueVO.setBl_no(bl_no);
		
		BlIssInfoVO blIssInfoVO 			= blIssInfoVOs[0];
		blIssInfoVO.setUpdUsrId(account.getUsr_id());
		blIssInfoVO.setUpdOffice(account.getOfc_cd());
		blIssueVO.setBlIssInfoVO(blIssInfoVO);
		String uiId = "ESM_BKG_0079_09";
		HistoryTableVO historyTableVO = new HistoryTableVO ();
		BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		BookingUtil utilCmd = new BookingUtil();

		try {
			utilCmd.addBkgLog("BKG_BLISSU", bkg_no, "usr id: "+account.getUsr_id());
			/* BKG_BL_DOC 변경 History 를 Log 테이블에 관리 한다. */
			BlIssInfoVO blIssHisVO = new BlIssInfoVO();
			blIssHisVO = utilCmd.searchBlRouteInfo(bkg_no);
			if(null != blIssHisVO){
				utilCmd.addBkgLog("BKG_BLBF_ROUTE", bkg_no,  "usr id: "+account.getUsr_id() + " POR: "+blIssHisVO.getPorCode()
																							+ " PORNM: "+blIssHisVO.getPorName()
																							+ " POL: "+blIssHisVO.getPolCode()	
																							+ " POLNM: "+blIssHisVO.getPolName()	
																							+ " POD: "+blIssHisVO.getPodCode()	
																							+ " PODNM: "+blIssHisVO.getPodName()	
																							+ " DEL: "+blIssHisVO.getDelCode()
																							+ " DELNM: "+blIssHisVO.getDelName()
						);
			}
			//I BLIssuanceBC::validateBlIssue ( bkgNo , issueType )
			//	≪≫ validateBlIssue ( [in] bkgNo : String , [in] issueType : String ) : BlStatusVO
				//[] BLIssuanceDBDAO::searchBlStatus ( bkgNo )
				//≪≫ searchBlStatus ( [in] bkgNo : String ) : BlStatusVO
			BlStatusVO blStatusVO = command.validateBlIssue(blIssInfoVO);

			//Group & Multi B/L Rating화면을 통해  Rating된 BKG일 경우 Self check 필수
			if(buttonType.equals("btn_t11Issue")){
					if(blStatusVO.getAudFlg().equals("N")) {
						//Your booking must be audited before "B/L Issue" because it is auto-uploaded from Hanjin Shipping WEB.Please, perform the audit at "e-Booking & S/I Process"
						throw new EventException(new ErrorHandler("BKG95096", new String[]{}).getMessage());
					}
					if(blStatusVO.getRatChkFlg().equals("N")) {
						//Rate Data is not Ready !
						throw new EventException(new ErrorHandler("BKG95088", new String[]{}).getMessage());
					}
					if(blStatusVO.getVslChkFlg().equals("N")) {
						//Vessel information is not matched with booking main. please check and update it correctly.
						eventResponse.setUserMessage((String) new ErrorHandler("BKG95094",new String[]{}).getUserMessage());
					}
					
					// 2015.12.28 Export&Import 나이지리아 추가로 인한 Validation 삽입
					//T/S에 나이지리아가 있을 경우를 고려한 Validation
					//result 배열은 pol_cd, pod_cd, Exs, Ens, eff_dt(날짜판별) 총 5개의 데이터를 가지고 있음
					//pol_cd, pod_cd는 flg값 (나이지리아면 Y 아니면 N)
					//Exs, Ens는 데이터가 직접 들어있음
					//application date가 2016년 기준 이후로 해당 로직 적용
//					String []r1 = blBC.chkNgExsEnsNo(blIssInfoVO.getBkgNo());
					
//					//pol이 나이지리아인데 EXS데이터가 없는 경우 에러
//					if("Y".equalsIgnoreCase(r1[0])&& "Y".equalsIgnoreCase(r1[4]) && r1[2].length()<1)
//						throw new EventException(new ErrorHandler("BKG95097", new String[]{"NIGERIAN","EXS/ENS"}).getMessage());
//					//pod가 나이지리아인데 ENS데이터가 없는 경우 에러
//					if("Y".equalsIgnoreCase(r1[1])&& "Y".equalsIgnoreCase(r1[4])&& r1[3].length()<1)
//						throw new EventException(new ErrorHandler("BKG95097", new String[]{"NIGERIAN","EXS/ENS"}).getMessage());
//					// 나이지리아 Validation 끝

					//나이지리아와 같이 토고도 같은 로직 적용 
					//체크할 데이터는 ECTN
//					String []r2 = blBC.chkTgEctnNo(blIssInfoVO.getBkgNo());					
//					//pol이 토고인데 ECTN데이터가 없는 경우 에러
//					if("Y".equalsIgnoreCase(r2[0])&& "Y".equalsIgnoreCase(r2[4]) && r2[2].length()<1)
//						throw new EventException(new ErrorHandler("BKG95097", new String[]{"TOGO","ECTN"}).getMessage());
//					//pod가 토고인데 ECTN데이터가 없는 경우 에러
//					if("Y".equalsIgnoreCase(r2[1])&& "Y".equalsIgnoreCase(r2[4]) && r2[3].length()<1)
//						throw new EventException(new ErrorHandler("BKG95097", new String[]{"TOGO","ECTN"}).getMessage());
					// 토고 Validation 끝
					
					
					//issue시 특정조건에 맞으면 pdf파일 이메일로 전송 (samsung)
					if("Y".equalsIgnoreCase(command.checkAutoEmailWithBLForSamsung(bkg_no))){
				    	DblWblVO[] dblWblVOs = null;
				    	List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
				        StringBuilder sbParam = new StringBuilder();
				        BookingUtil util = new BookingUtil();
				        BkgEmlEdtVO bkgEmlEdtVO = new BkgEmlEdtVO();
				        
						String sType = null;
						String sLevel = null;
						String sMrd = null;
						String hiddenData = null;
			    		
			    		sType="2";
						sMrd="ESM_BKG_0109_DBL.mrd";
						sLevel="6";
						hiddenData = "Y";
						
						sbParam.append("/rv");
						sbParam.append(" form_bkgNo[('").append(bkg_no).append("')]");
						sbParam.append(" form_type[").append(sType).append("]");
						sbParam.append(" form_dataOnly[N]");
						sbParam.append(" form_manifest[N]");
						sbParam.append(" form_usrId[").append(account.getUsr_id()).append("]");
						sbParam.append(" form_hiddeData[").append(hiddenData).append("]");
						sbParam.append(" form_level[(").append(sLevel).append(")]");
						sbParam.append(" form_remark[").append("").append("]");
						sbParam.append(" form_Cntr[1]");
						sbParam.append(" form_mainOnly[N]");
						sbParam.append(" form_CorrNo[]");
						sbParam.append(" form_his_cntr[BKG_CONTAINER]");
						sbParam.append(" form_his_bkg[BKG_BOOKING]");
						sbParam.append(" form_his_mkd[BKG_BL_MK_DESC]");
						sbParam.append(" form_his_xpt[BKG_XPT_IMP_LIC]");
						sbParam.append(" form_his_bl[BKG_BL_DOC]");
						sbParam.append(" isEncode[Y]");
						sbParam.append(" /rp []");
						sbParam.append(" /riprnmargin");
						
						dblWblVOs = new DblWblVO[1];
						dblWblVOs[0] = new DblWblVO();
						dblWblVOs[0].setBkgNo(bkg_no);
						dblWblVOs[0].setBlNo(bl_no);
						dblWblVOs[0].setSyscd("BKG");
						dblWblVOs[0].setTmplmrd(sMrd);
						dblWblVOs[0].setBatchflg("N");
						dblWblVOs[0].setTmplparam(sbParam.toString());
						dblWblVOs[0].setTmplmrdpdf("MBL_SMLM"+bkg_no+".pdf");
						dblWblVOs[0].setItr("|$$|");
						dblWblVOs[0].setNtcKndCd("BL");
						dblWblVOs[0].setHiddOpt("N");
						dblWblVOs[0].setFrtAllFlg("Y");
						// Get Receive Email Address (Search Hard Coding Table)		
						BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
						bkgHrdCdgCtntListCondVO.setHrdCdgId("SAMSUNG");
						List<BkgHrdCdgCtntVO> bkgHrdCdgCtntVOs= util.searchHardCoding(bkgHrdCdgCtntListCondVO);
						if(bkgHrdCdgCtntVOs.size() > 0) {
							dblWblVOs[0].setRcveml(bkgHrdCdgCtntVOs.get(0).getAttrCtnt1());
						} else {
							return null;
						}
						begin();
						bkgNtcHisVOs = command.sendBLByEmailForSamsung(dblWblVOs,bkgEmlEdtVO,account);
						bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
						commit();		
					}
			}	
			if( 
				!( buttonType.equals("btn_t11CancelRelease"))
			){
				if(blStatusVO.getChgReady() == null || blStatusVO.getChgReady().equals("N")) {
					//Rate Data is not Ready !
					throw new EventException(new ErrorHandler("BKG08078", new String[]{}).getMessage());
				}
				if(blStatusVO.getMkReady() == null || blStatusVO.getMkReady().equals("N")) {
					//M&D data is not Ready
					throw new EventException(new ErrorHandler("BKG08077", new String[]{}).getMessage());
				}
			}			
			//2009.11.12 by 신자영  : issue 버튼눌렀을 경우 ppd paid여부는 체크하지 마세요.
			//2009.11.23 by 신자영  : btn_t11CancelRelease 버튼눌렀을 경우 ppd paid여부는 체크하지 마세요.
			if( 
				!( buttonType.equals("btn_t11Issue")||buttonType.equals("btn_t11CancelRelease"))
			){
				if(blStatusVO.getChgPpdInd() == null || blStatusVO.getChgPpdInd().equals("N")) {
					//PPD Data is not Ready !
	                throw new EventException(new ErrorHandler("BKG08079", new String[]{}).getMessage());
	            }	
				if(blStatusVO.getChgPpdThirdInd() == null || blStatusVO.getChgPpdThirdInd().equals("N")) {
					//PPD Data is not Ready !
	                throw new EventException(new ErrorHandler("BKG08079", new String[]{}).getMessage());
	            }
			}
			if(blStatusVO.getDoChkInd() == null || blStatusVO.getDoChkInd().equals("N")) {
                throw new EventException(new ErrorHandler("BKG00434", new String[]{}).getMessage());
                //D/O already issued
            }
			log.debug("[end][======== [BLIssuanceBC] :: validateBlIssue ]==========");
			
			
			log.debug("===============================================================");
			log.debug("[start][======== [BLIssuanceBC] :: searchOldBkgForHistory ]"+buttonType);
			log.debug("===============================================================");
			//I BookingHistoryMgtBC::searchOldBkgForHistory ( uiId , bkgBlNoVo )

			// History search
			bkgBlNoVO.setBkgNo(bkg_no);
			bkgBlNoVO.setCaUsrId(account.getUsr_id());			
			bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoVO);			
			historyTableVO = bookingHistoryMgtBC.searchOldBkgForHistory(uiId, bkgBlNoVO);
			
			/**
			 *  OBLISS	ORIGINAL B/L ISSUE
			 *  OBLRED	ORIGINAL B/L REDEMPTION
			 *  OBLRIS	ORIGINAL B/L REISSUE
			 *  OBLREL	ORIGINAL B/L RELEASE
			 *  OBLSRD	ORIGINAL B/L SURRENDER
			 *  BKGRAT	RATING
			 */
			String oRIGINAL_BL = "";
			if(buttonType.equals("btn_t11Issue")){
				oRIGINAL_BL="OBLISS";
			}else if(buttonType.equals("btn_t11SWBRelease")){
				oRIGINAL_BL="OBLREL";
			}else if(buttonType.equals("btn_t11OBLRelease")){
				oRIGINAL_BL="OBLREL";
			}else if(buttonType.equals("btn_t11InternetAUTH")){
				oRIGINAL_BL="OBLREL";
			}else if(buttonType.equals("btn_t11OBLSurrender")){
				oRIGINAL_BL="OBLSRD";
			}
			
			if(!oRIGINAL_BL.equals("")){
				log.debug("[method][======== [BLIssuanceBC] :: oRIGINAL_BL]=========="+oRIGINAL_BL);
				//등록되어있는것만 적용한다. 
				
	
				// < docPrcModyFlg='Y'인경우 >  by 2009.11.11 , 신자영 
				// 5. [] IBookingHistoryMgtBC::manageDocProcess ( docProcSkd )
	            BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
	            docProcSkdVO.setBkgNo(bkg_no);
	            docProcSkdVO.setBkgDocProcTpCd(oRIGINAL_BL);
	            
	            bookingHistoryMgtBC.manageDocProcess(docProcSkdVO, account);
			}

			//I GeneralBookingReceiptBC::modifyBlType ( bkgNo , blTpCd )
			GeneralBookingReceiptBC generalBookingReceiptBC = new GeneralBookingReceiptBCImpl();
			String blTpCd = blIssInfoVO.getBlIssueblType();
			generalBookingReceiptBC.modifyBlType(bkg_no,blTpCd);

			//IBLIssuanceBC::manageBlIssueFlg ( blIssInfoVO )
			blIssInfoVO.setButtontype(buttonType);
			command.manageBlIssueFlg(blIssInfoVO);

			//[2009.12.12 - 결함관리지침에 따른 수정]
			//BLDocumentationBLBC::manageBlIssueFlg ( blIssInfoVO )
			blBC.manageBlIssueFlg(blIssInfoVO);
			
			//[2011.12.22 - LBP 정보 CHG 테이블에 저장 by 조원주]
			if("Y".equals(event.getLbpFlg())){
		    
				SurchargeAutoRatingBC surAutoRaingBC = new SurchargeAutoRatingBCImpl();
				 
				SearchChgRateByLBPVO retSearchChgRateByLBPVO = surAutoRaingBC.manageLbpSurchargeRating(event.getSearchChgRateByLBPVO(), account);
				if(retSearchChgRateByLBPVO != null){
					
					// MAS 호출 
					CostAssignBC masCmd  = new CostAssignBCImpl();
					MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
					masBkgComIfVo.setBkgNo(bkg_no);
					masBkgComIfVo.setCostSrcSysCd("BKG");
					masBkgComIfVo.setIfRmk("Manage Rate");
					masBkgComIfVo.setCreUsrId(account.getUsr_id());
					masBkgComIfVo.setUpdUsrId(account.getUsr_id());
					masCmd.modifyMasCommonInterface(masBkgComIfVo); 
					                
					// Back End Job으로 호출 
					// IBookingARCreationBC::interfaceBKGARInvoiceToINV ( bkgIfVo )
					BookingARCreationBC bookingARCreationBC = new BookingARCreationBCImpl();
					ARBkgInterfaceCreationVO bkgIfVo = new ARBkgInterfaceCreationVO();
					bkgIfVo.setBkgNo(bkg_no);
					bkgIfVo.setManDivInd("B");
					bkgIfVo.setUserId(account.getUsr_id());
					bookingARCreationBC.interfaceBKGARInvoiceToINV(bkgIfVo);
	
					// Container 별 Rate 배주 처리
					BlRatingBC blRatingBC = new BlRatingBCImpl();
					bkgBlNoVO.setBkgNo(bkg_no);
					bkgBlNoVO.setBlNo(bl_no);  
					bkgBlNoVO.setCaUsrId(account.getUsr_id());
					blRatingBC.distributeCntrRate(bkgBlNoVO.getBkgNo(), account);

					//Perpaid 금액 변경시 e-mail 전송로직 시작
		            String chgPpdAmtFlg = blRatingBC.searchPpdChgAmtFlg(bkgBlNoVO.getBkgNo());
		            if(chgPpdAmtFlg.equals("Y")){
		            	// BL Release 담당자 email 조회
		            	String usrEml = blRatingBC.searchPpdChgRlsEmail(bkgBlNoVO.getBkgNo());
		            	
		            	if(!usrEml.equals("")){
		            		// Email에 보낼 Data 조회
		                	List<EmailPpdInfoVO> list = blRatingBC.searchPpdChgInfo(bkgBlNoVO.getBkgNo(), account.getUsr_id());
		            		if(list.size() > 0){
		            			//Send Email
		            			blRatingBC.sendEmailPpdAmount(list, usrEml, account.getUsr_eml(), account.getUsr_nm());
		            		}
		            	}	
		            }
		            
				}
			}
			
            bookingHistoryMgtBC.manageBookingHistory(uiId, historyTableVO, account);
			
            //by 신자영  issue 일때는 save 처리 
            if(buttonType.equals("btn_t11Issue")){
            	 this.manageBlIssInfo(e);
            }

            blIssHisVO = utilCmd.searchBlRouteInfo(bkg_no);
			if(null != blIssHisVO){
				utilCmd.addBkgLog("BKG_BLAF_ROUTE", bkg_no,  "usr id: "+account.getUsr_id() + " POR: "+blIssHisVO.getPorCode()
																							+ " PORNM: "+blIssHisVO.getPorName()
																							+ " POL: "+blIssHisVO.getPolCode()	
																							+ " POLNM: "+blIssHisVO.getPolName()	
																							+ " POD: "+blIssHisVO.getPodCode()	
																							+ " PODNM: "+blIssHisVO.getPodName()	
																							+ " DEL: "+blIssHisVO.getDelCode()
																							+ " DELNM: "+blIssHisVO.getDelName()
						);
			}
	
            if(buttonType.equals("btn_t11SWBRelease")){
            	List<BkgNtcHisVO> bkgNtcHisVOs = null;  
            	DblEdiInVO dblEdiInVO = null;
            	DblEdiVO dblEdiVO = null;
                List<CustTpIdVO> custTpIdVos = utilCmd.searchEdiCustTpId(bkgBlNoVO, "D", "N");
                bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
           
                StringBuilder sbParam = new StringBuilder();  
                BkgRouteVO bkgRouteVO = null;
                String sMrd = null;
                DblWblVO[] dblWblVOs = null;
                
                
                /* PANTOS 인 B/L 에 대하여 SWB Release 시 310 EDI 를 전송 한다. RCV ID : PKEXML */
                for(int i=0 ; i < custTpIdVos.size() ; i++) {
                	dblEdiInVO = new DblEdiInVO();
    	        	dblEdiInVO.setBkgNo(bkg_no);
    	        	dblEdiInVO.setEdiReceiveId(custTpIdVos.get(i).getRcvId());
    	        	dblEdiInVO.setGroupEdiId(custTpIdVos.get(i).getGroupId());
    	        	dblEdiInVO.setGroupEdiCust(custTpIdVos.get(i).getRefCode());
    	        	dblEdiInVO.setAutoManualFlg("M");
    	        	
    	        	if(custTpIdVos.get(i).getRcvId() != null && custTpIdVos.get(i).getRcvId() != "" && "PKEXML".equals(custTpIdVos.get(i).getRcvId())){
    		        	dblEdiVO = command.createDraftBlEdi(dblEdiInVO, account);
    	        		if(dblEdiVO != null){
    		        		String rcvId = custTpIdVos.get(i).getRcvId();
    						BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
    						bkgNtcHisVO.setBkgNo(bkg_no);
    						bkgNtcHisVO.setNtcViaCd("E");
    						bkgNtcHisVO.setNtcKndCd("BL");
    						bkgNtcHisVO.setEdiId(rcvId);
    						bkgNtcHisVO.setEsvcGrpCd(custTpIdVos.get(i).getGroupId());
    						bkgNtcHisVO.setBkgNtcSndRsltCd(dblEdiVO.getFlatFileAckVOs().get(0).getAckStsCd());
    						bkgNtcHisVO.setFltFileRefNo(dblEdiVO.getFlatFileAckVOs().get(0).getFltFileRefNo());
    						bkgNtcHisVO.setSndUsrId("SYSTEM");
    						bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
    						bkgNtcHisVO.setSndRqstDt(DateTime.getShortDateString());
    						bkgNtcHisVO.setCreUsrId(account.getUsr_id());
    						bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
    						bkgNtcHisVOs.add(bkgNtcHisVO);
    	        		}
    	        	}
                }
                
                if(bkgNtcHisVOs!=null){
					if(bkgNtcHisVOs.size()>0){
						bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
					}
                }
                
                
                //BL ISSUE탭에서 SWB Release버튼 클릭 시 doc requirement팝업의 rate/unrate 및 email주소 참조하여 메일전송          
                List<DocRqstVO> docRqstList = command.searchDocRqst(bkg_no, "");
                DocRqstVO vo = docRqstList.get(0);
                
                
                if(null!=vo.getWblRtTpCd() && !"".equals(vo.getWblRtTpCd()) && null != vo.getWblEml() && !"".equals(vo.getWblEml().trim())){
                    List<BkgNtcHisVO> bkgNtcHisVOs2 =new ArrayList<BkgNtcHisVO>();
                	

                	bkgRouteVO = utilCmd.searchBkgRoute(bkg_no);
    				if (0==bkgRouteVO.getPorCd().indexOf("US")) {
    					sMrd="ESM_BKG_0109_OBL_LETTER.mrd";
    				} else {
    					sMrd="ESM_BKG_0109_OBL_A4.mrd";
    				}
    				
    				sbParam.append("/rv");
    				sbParam.append(" form_bkgNo[('").append(bkg_no).append("')]");
    				sbParam.append(" form_type[5]");
    				sbParam.append(" form_dataOnly[N]");
    				sbParam.append(" form_manifest[N]");
    				sbParam.append(" form_usrId[").append(account.getUsr_id()).append("]");
    				sbParam.append(" form_hiddeData[N]");
    				sbParam.append(" form_remark[]");
    				sbParam.append(" form_Cntr[1]");
    				sbParam.append(" form_mainOnly[N]");
    				sbParam.append(" form_CorrNo[]");
    				sbParam.append(" form_his_cntr[BKG_CONTAINER]");
    				sbParam.append(" form_his_bkg[BKG_BOOKING]");
    				sbParam.append(" form_his_mkd[BKG_BL_MK_DESC]");
    				sbParam.append(" form_his_xpt[BKG_XPT_IMP_LIC]");
    				sbParam.append(" form_his_bl[BKG_BL_DOC]");
    				sbParam.append(" isEncode[Y]");
    				
    				String param = sbParam.toString();  

    				dblWblVOs = new DblWblVO[1];
    				dblWblVOs[0] = new DblWblVO();
    				dblWblVOs[0].setBkgNo(bkgBlNoVO.getBkgNo());
    				dblWblVOs[0].setBlNo(bkgBlNoVO.getBlNo());
    				dblWblVOs[0].setSyscd("BKG");
					dblWblVOs[0].setTmplmrd(sMrd);
					dblWblVOs[0].setTmplmrdpdf("Original.pdf");
    				dblWblVOs[0].setBatchflg("N");
    				dblWblVOs[0].setRcveml(vo.getWblEml());
    				dblWblVOs[0].setItr("|$$|");
    				dblWblVOs[0].setNtcKndCd("WB");
    				dblWblVOs[0].setHiddOpt("N");
    				dblWblVOs[0].setFrtCltFlg("N");
    				dblWblVOs[0].setFrtPpdFlg("N");
    				dblWblVOs[0].setFrtArrFlg("N");
    				
    				if("Y".equals(vo.getWblRtTpCd())){
    					dblWblVOs[0].setFrtAllFlg("Y");
    					dblWblVOs[0].setFrtChgFlg("N");
    					dblWblVOs[0].setTmplparam(new StringBuilder(param).append(" form_level[1]").append(" /rp []").append(" /riprnmargin").toString());
    				}else if("N".equals(vo.getWblRtTpCd())){
    					dblWblVOs[0].setFrtAllFlg("N");
    					dblWblVOs[0].setFrtChgFlg("Y");
    					dblWblVOs[0].setTmplparam(new StringBuilder(param).append(" form_level[6]").append(" /rp []").append(" /riprnmargin").toString());
    				}else{
    					//SWB Release버튼 클릭 시 rate/unrate모두 전송시에 파라미터 추가 
    					dblWblVOs[0].setFrtAllFlg("Y");
    					dblWblVOs[0].setFrtChgFlg("Y");
    					dblWblVOs[0].setTmplparam(new StringBuilder(param).append(" form_level[1]").append(" /rp []").append(" /riprnmargin").toString());
    					dblWblVOs[0].setTmplparam2(new StringBuilder(param).append(" form_level[6]").append(" /rp []").append(" /riprnmargin").toString());
    				}
    				
    				bkgNtcHisVOs2 = command.sendDblWblByEmail(dblWblVOs, null, account);
    				
    				
                    if(bkgNtcHisVOs2!=null){
    					if(bkgNtcHisVOs2.size()>0){
    						bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs2, "ESM_BKG_0095");
    					}
                    }
                }


            }
            
            //2014.11.24 SWB,OBL release혹은 cancel시 310자동전송 추가 
            if(buttonType.equals("btn_t11SWBRelease") || buttonType.equals("btn_t11OBLRelease")
            		 || buttonType.equals("btn_t11InternetAUTH") || buttonType.equals("btn_t11CancelRelease")){
            	begin();
            	List<BkgNtcHisVO> bkgNtcHisVOs = command.createDraftBlEdiAuto(bkgBlNoVO.getBkgNo(), "Y",  account);
    			if (bkgNtcHisVOs != null && bkgNtcHisVOs.size() > 0) {
    				
					//philips 계약인 BKG에 대해서 DBL전송
					String philips = command.searchPhilipsCheck(bkgBlNoVO.getBkgNo());
					
	    			//philips 계약인 BKG에 대해서 DBL전송
	    			if(null!=philips && !"".equals(philips)){
	    				List<BkgNtcHisVO> bkgHisVOs = null;
	    				StringBuilder sbParam = new StringBuilder();
	    				
	    				String draftRemark = command.searchDraftRemark(bkgBlNoVO.getBkgNo());

	                	
	            		sbParam.append("/rv");
	            		sbParam.append(" form_bkgNo[('").append(bkgBlNoVO.getBkgNo()).append("')]");
	            		sbParam.append(" form_type[").append("2").append("]");
	            		sbParam.append(" form_dataOnly[N]");
	            		sbParam.append(" form_manifest[N]");
	            		sbParam.append(" form_usrId[").append(account.getUsr_id()).append("]");
	            		sbParam.append(" form_hiddeData[N]");
	            		sbParam.append(" form_level[(").append(1).append(")]");
	            		sbParam.append(" form_remark[").append(draftRemark).append("]");
	            		sbParam.append(" form_Cntr[1]");
	            		sbParam.append(" form_mainOnly[N]");
	            		sbParam.append(" form_CorrNo[]");
	            		sbParam.append(" form_his_cntr[BKG_CONTAINER]");
	            		sbParam.append(" form_his_bkg[BKG_BOOKING]");
	            		sbParam.append(" form_his_mkd[BKG_BL_MK_DESC]"); 
	            		sbParam.append(" form_his_xpt[BKG_XPT_IMP_LIC]");
	            		sbParam.append(" form_his_bl[BKG_BL_DOC]");
	            		sbParam.append(" /rp []");
	            		sbParam.append(" /riprnmargin");
	            		
	    				
	    				DblWblVO[] dblWblVOs = new DblWblVO[1];
	    				dblWblVOs[0] = new DblWblVO();
	    				dblWblVOs[0].setBkgNo(bkgBlNoVO.getBkgNo());
	    				dblWblVOs[0].setBlNo(bkgBlNoVO.getBlNo());
	    				dblWblVOs[0].setSyscd("BKG");
	    				dblWblVOs[0].setTmplmrd("ESM_BKG_0109_DBL.mrd");
	    				dblWblVOs[0].setBatchflg("N");
	    				dblWblVOs[0].setTmplparam(sbParam.toString());
	    				dblWblVOs[0].setRcveml(philips);
	    				dblWblVOs[0].setTmplmrdpdf("SMLM"+bkgBlNoVO.getBkgNo()+".pdf");
	    				dblWblVOs[0].setItr("|$$|");
	    				dblWblVOs[0].setNtcKndCd("BL");
	    				dblWblVOs[0].setHiddOpt("N");
	    				dblWblVOs[0].setFrtAllFlg("Y");
	    				dblWblVOs[0].setFrtCltFlg("N");
	    				dblWblVOs[0].setFrtPpdFlg("N");
	    				dblWblVOs[0].setFrtChgFlg("N");
	                    dblWblVOs[0].setFrtArrFlg("N");
	                    
	                    //DPCS가 아니더라도 sender email주소 front office로
	                    dblWblVOs[0].setFntEmlFlg("Y");
	                    bkgHisVOs = command.sendDblWblByEmail(dblWblVOs, null, account);
	    				if(bkgHisVOs.size()>0){
	    					bookingHistoryMgtBC.createBkgNtcHis(bkgHisVOs,"ESM_BKG_0095");
	    				}

	    			}
	    			
    				bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs,"ESM_BKG_0095");
    			}	
    			
				commit();
            }
            
            
			//ICargoReleaseOrderBC::setupFocByObl ( OblRdemVO )
			if("Y".equals(setupfocoblflag) && "btn_t11SWBRelease".equals(buttonType)){ 
				log.debug("===============================================================");
				log.debug("[start][======== [CargoReleaseOrderBCImpl] :: setupFocByObl ]");
				log.debug("===============================================================");
				begin();
				//Inbound Cr관련 로그
				utilCmd.addBkgLog("BKG_SWB", bl_no, "Release: "+ blIssInfoVO.getReleased());
				
				CargoReleaseOrderBC cargoBC = new CargoReleaseOrderBCImpl();
				OblRdemVO oblRdem = new OblRdemVO();
				oblRdem.setBlNo(bl_no);
				oblRdem.setCgorTeamCd("S");
				oblRdem.setCgoEvntNm("SWB Release");
				oblRdem.setEvntDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
				oblRdem.setEvntOfcCd(account.getOfc_cd());
				oblRdem.setEvntUsrId(account.getUsr_id());
				oblRdem.setOblRdemFlg(blIssInfoVO.getReleased());

				try{
					cargoBC.setupFocByObl(oblRdem);
				}catch(Exception e1){
					log.debug("[end:: CargoReleaseOrderBC == manageBlIssue update ]==========");
					log.error(e1.getMessage());
				}
				commit();
			}
		} catch (EventException evtEx) {
			log.error("manageBlIssue evtErr " + evtEx.toString(), evtEx);
			throw evtEx;
		} catch (Exception ex) {
			log.error("manageBlIssue err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06014").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EsmBkg0649Event 조회 이벤트 처리<br>
	 * B/L Issue 정보 조회<br>
	 * 
	 * @author LEE JIN SEO
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchBlReIssue(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();

		EsmBkg0649Event event = (EsmBkg0649Event) e;
		String bl_no = event.getBl_no();
		String bkg_no = event.getBkg_no();
		try {

			// 1. bkg_no가 없을 경우 bl_no로  조회한다.
			 if(bkg_no == null || bkg_no.length() == 0){
                if(bl_no.length()>12) bl_no = bl_no.substring(0,12);
                BookingUtil bookingUtilBC = new BookingUtil();
                bkg_no = bookingUtilBC.searchBkgNoByBlNo(bl_no);  
             }

            // bkg_no 존재유무판단 
			BkgBlNoVO bkgBlNo = new BkgBlNoVO();
			bkgBlNo.setBkgNo(bkg_no);
			bkgBlNo.setBlNo(bl_no);	
			bkgBlNo.setCaUsrId(account.getUsr_id());
			BookingUtil bookingUtil = new BookingUtil();
			BkgBlNoVO bkgBlNoVO = bookingUtil.searchBkgBlNoVO(bkgBlNo);
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new Exception(new ErrorHandler("BKG03055", new String[] { bkg_no }).getMessage());
			}

			// 1. bl_no를 조회한다.
			ReIssueVO reIssueVO = command.searchBlReIssue(bkg_no);

			// 2. 결과값을 리턴한다.
			//2009.10.16 by 신자영  기본값은 보여준다.
			eventResponse.setRsVoList(reIssueVO.getReIssueInfoVO());
			
			/*
			3. Surrender 인 경우 메세지 [BKG00457] 표시 후 조회가 안되게 한다.
			4. Issue가 안되었으면  메세지 [BKG00478] 표시 후 조회가 안되게 한다.
			5. D/O가 발행 되었으면  메세지 [BKG00434] 표시 후 조회 안되게 한다."
			*/
			if(reIssueVO.getReIssueInfoVO().size() != 0){
				ReIssueInfoVO vo = (ReIssueInfoVO)reIssueVO.getReIssueInfoVO().get(0);
				if("Y".equals(vo.getOblSrndFlg())){
					throw new EventException(new ErrorHandler("BKG00457", new String[]{}).getMessage());
					
				}
				if("N".equals(vo.getOblIssFlg())){
					throw new EventException(new ErrorHandler("BKG00478", new String[]{}).getMessage());
					
				}
				if("Y".equals(vo.getDoYn())){
					throw new EventException(new ErrorHandler("BKG00434", new String[]{}).getMessage());
				
				}
			}

			eventResponse.setRsVoList(reIssueVO.getBkgDocIssHisVO());
			eventResponse.setRsVoList(reIssueVO.getBkgDocIssRdemVO());
		} catch (EventException evtEx) {
			throw evtEx;
		} catch (Exception ex) {			
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EsmBkg0649Event 저장 이벤트 처리<br>
	 * B/L Re-Issue 정보를 추가/수정한다.<br>
	 * 
	 * @author LEE JIN SEO
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageBlReIssue(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();

		EsmBkg0649Event event = (EsmBkg0649Event) e;
		ReIssueVO reIssueVO = new ReIssueVO();
		reIssueVO.setBkgDocIssHisVOs(event.getBkgDocIssHisVOs());
		reIssueVO.setBkgDocIssRdemVOs(event.getBkgDocIssRdemVOs());
		reIssueVO.setAccount(account);
		reIssueVO.setBkg_no(event.getBkg_no());
		reIssueVO.setHis_seq(event.getHis_seq());
		
		/* History Setup */
		HistoryTableVO historyTableVO = new HistoryTableVO ();
		BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
		BookingUtil utilCmd = new BookingUtil();
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		String uiId = "ESM_BKG_0649";

		
		try {

			begin();
			
			/* search old history */
			bkgBlNoVO.setBkgNo(reIssueVO.getBkg_no());
			bkgBlNoVO.setCaUsrId(account.getUsr_id());
			bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoVO);
			historyTableVO = bookingHistoryMgtBC.searchOldBkgForHistory(uiId, bkgBlNoVO);
			
			
			reIssueVO.setCommand_type("Save");
			command.manageBlReIssue(reIssueVO);
			
			/* create history */
			bookingHistoryMgtBC.manageBookingHistory(uiId, historyTableVO, account);
		
			commit();
			
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06014").getMessage(), ex);
		}
	
		return eventResponse;
	}

	/**
	 * EsmBkg0649Event 저장 이벤트 처리<br>
	 * B/L Re-Issue 정보를 추가/수정한다.<br>
	 * 
	 * @author LEE JIN SEO
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse confirmBlReIssue(Event e) throws EventException {
		
		GeneralEventResponse eventResponse	= new GeneralEventResponse();
		BLIssuanceBC bLIssuanceBC			= new BLIssuanceBCImpl();
		
		EsmBkg0649Event event 				= (EsmBkg0649Event) e;
		
		String bkg_no 						= event.getBkg_no();
		String released 					= event.getReleased();
		String issued 						= event.getIssued();
		String setupfocoblflag 				= event.getSetupfocoblflag();
		String bl_no 						= event.getBl_no();
		
		ReIssueVO reIssueVO = new ReIssueVO();
		reIssueVO.setBkgDocIssHisVOs(event.getBkgDocIssHisVOs());
		reIssueVO.setBkgDocIssRdemVOs(event.getBkgDocIssRdemVOs());
		reIssueVO.setAccount(account);
		reIssueVO.setBkg_no(bkg_no);
		reIssueVO.setHis_seq(event.getHis_seq());
		
		/* History Setup */
		HistoryTableVO historyTableVO = new HistoryTableVO ();
		BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
		BookingUtil utilCmd = new BookingUtil();
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		String uiId = "ESM_BKG_0649";
		
		log.debug("===============================================================");
		log.debug("[start][======== confirmBlReIssue " + setupfocoblflag);
		log.debug("===============================================================");
		
		try {
			/* search old history */
			bkgBlNoVO.setBkgNo(bkg_no);
			bkgBlNoVO.setCaUsrId(account.getUsr_id());
			bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoVO);
			
			/* searchBkgBlNo */
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new EventException(new ErrorHandler("BKG01049").getMessage());
			}
			utilCmd.addBkgLog("BKG_CFM_REISS", bkg_no, "usr id: "+account.getUsr_id() + ", focFlg : "+setupfocoblflag);

			begin();

			/* SearchOld Booking History */

			historyTableVO = bookingHistoryMgtBC.searchOldBkgForHistory(uiId, bkgBlNoVO);
			//2015.02.23 화면파라미터만을 참조하여 발생하는 SWB Rlse에러 수정
			if("Y".equals(historyTableVO.getBkgBlIssVO().getOblRlseFlg())){
				released = "Y";
				if("W".equals(bkgBlNoVO.getBlTpCd())){
					setupfocoblflag = "Y";
				}
			}
			/* Manage Booking BlReIssue */
			reIssueVO.setCommand_type("COMFIRM");
			bLIssuanceBC.manageBlReIssue(reIssueVO);
			

			/* [Cancel 됐을 경우 History] */
			BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
            docProcSkdVO.setBkgNo(bkg_no);
            
            if(released.equals("Y")){
            	
            	/* [Release Cancel 됐을 경우 OBLRLC로 호출 삭제하고 추가하기 ] */ 
    			docProcSkdVO.setBkgDocProcTpCd("OBLRLC");
    			bookingHistoryMgtBC.manageDocProcess(docProcSkdVO, account);
            }
            if(issued.equals("Y")){
            	
            	/* [Issue Cancel 됐을 경우 OBLISC 삭제하고 추가하기] */
	            docProcSkdVO.setBkgDocProcTpCd("OBLISC");
	            bookingHistoryMgtBC.manageDocProcess(docProcSkdVO, account);
            }
            
            /* manage Booking History */
            bookingHistoryMgtBC.manageBookingHistory(uiId, historyTableVO, account);

            
			//ICargoReleaseOrderBC::setupFocByObl ( OblRdemVO )
			if("Y".equals(setupfocoblflag)){
				log.debug("===============================================================");
				log.debug("[start][======== [CargoReleaseOrderBCImpl] :: setupFocByObl ]");
				log.debug("===============================================================");
				CargoReleaseOrderBC cargoBC = new CargoReleaseOrderBCImpl();
				OblRdemVO oblRdem = new OblRdemVO();
				oblRdem.setBlNo(bl_no);
				oblRdem.setCgorTeamCd("S");
				oblRdem.setCgoEvntNm("SWB Release cancel");
				oblRdem.setEvntDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
				oblRdem.setEvntOfcCd(account.getOfc_cd());
				oblRdem.setEvntUsrId(account.getUsr_id());
				oblRdem.setOblRdemFlg("N");

				try{
					cargoBC.setupFocByObl(oblRdem);
				}catch(Exception e1){
					log.debug("[end:: CargoReleaseOrderBC == confirmBlReIssue update ]==========");
					log.error(e1.getMessage());
				}
			}            
            
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06014").getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * EsmBkg0400Event 조회 이벤트 처리(ESM_BKG_0400)<br>
	 * O.B/L Surrender 데이터 조회<br>
	 * 
	 * @author LEE JIN SEO
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchSurrenderInfo(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();
		List<SrndVO> srndVOList = null;
		EsmBkg0400Event event = (EsmBkg0400Event) e;
		String bkg_no = event.getBkg_no();
		String bl_no = event.getBl_no();

		try {
			// bkg_no 존재유무판단 
   			BkgBlNoVO bkgBlNo = new BkgBlNoVO();
   			bkgBlNo.setBkgNo(bkg_no);
   			bkgBlNo.setBlNo(bl_no);	
   			bkgBlNo.setCaUsrId(account.getUsr_id());
   			BookingUtil bookingUtil = new BookingUtil();
   			BkgBlNoVO bkgBlNoVO = bookingUtil.searchBkgBlNoVO(bkgBlNo);
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new Exception(new ErrorHandler("BKG03055", new String[] { bkg_no }).getMessage());
			}
			 
			if(bl_no.length()>12) bl_no = bl_no.substring(0,12);
			// 1. O.B/L Surrender 데이터 조회
			srndVOList = command.searchSurrenderInfo(bkg_no, bl_no);

			eventResponse.setRsVoList(srndVOList);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {			
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * OBL을 surrender(포기) 처한다.(ESM_BKG_0400)
     * 특정화주가 OBL이 불필요하며 발행자체를 원치 않을 경우 사용한다.
     * surrender와 동시에 redemption(화수) 된 것으로 처리한다.
     * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse modifySurrenderInfo(Event e) throws EventException {
		log.debug("[START:: BLIssuanceBC == modifySurrenderInfo update ]==========");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();

		EsmBkg0400Event event = (EsmBkg0400Event) e;
		SrndVO[] srndVOs = event.getSrndVOs();
		srndVOs[0].setAccount(account);
		
		/* History Setup */
		HistoryTableVO historyTableVO = new HistoryTableVO ();
		BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
		BookingUtil utilCmd = new BookingUtil();
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		String uiId = "ESM_BKG_0400";
		String bkg_no = event.getBkg_no();
		String bl_no = event.getBl_no();
		String existObsFlg = event.getExistObsFlg();
		
		/*1) 설명
		-OBL을 surrender(포기) 처리한다.
		-특정화주가 OBL이 불필요하며 발행자체를 원치 않을 경우 사용한다.
		-surrender와 동시에 redemption(화수) 된 것으로 처리한다.-- UI_BKG-0400
		*/
		
		try {
			begin();
			//1. 해당 BKG No로 조회한다.
			//2. 예외조건을 검사한다. D/O status 포함
			//3. B/L 정보에서 Surrender 관련사항을 업데이트 한다.
			
			/* search old history */
			bkgBlNoVO.setBkgNo(srndVOs[0].getBkgNo());
			bkgBlNoVO.setCaUsrId(account.getUsr_id());
			bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoVO);
			historyTableVO = bookingHistoryMgtBC.searchOldBkgForHistory(uiId, bkgBlNoVO);
			
			command.modifySurrenderInfo(srndVOs[0]);		

			//2. -> [] IFullReleaseOrderBC::setupFOC ( blNo , blNoTp , blNoChk , focTp , focStatus , acount )
				//2-1. BKG_CGO_RLSE.OBL_RDEM_FLG를 'Y'로 설정 한다.
				//2-2. Inbound 관련 D/O를 호출한다. (type = 'O', stsFlag = 'Y')
			
			//3. -> [] IBookingHistoryMgtBC::createBkgHistoryLine ( bkgNo , eventDesc , issTpCd )
			
			 // O/BL Surrender 처리시 OBS Charge 정보가 존재할 경우에만 OBS Charge 항목을 추가한다.
			if("Y".equals(existObsFlg)){
				SurchargeAutoRatingBC surAutoRaingBC = new SurchargeAutoRatingBCImpl();
				BkgObsSurchargeRateVO bkgObsSurchargeRateVO = new BkgObsSurchargeRateVO();
				bkgObsSurchargeRateVO.setBkgNo(srndVOs[0].getBkgNo());
				
				BkgObsSurchargeRateVO retBkgObsSurchargeRateVO = surAutoRaingBC.manageObsSurchargeRating(bkgObsSurchargeRateVO, account);
				if(retBkgObsSurchargeRateVO != null){
					
					// MAS 호출 
					CostAssignBC masCmd  = new CostAssignBCImpl();
					MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
					masBkgComIfVo.setBkgNo(bkg_no);
					masBkgComIfVo.setCostSrcSysCd("BKG");
					masBkgComIfVo.setIfRmk("Manage Rate");
					masBkgComIfVo.setCreUsrId(account.getUsr_id());
					masBkgComIfVo.setUpdUsrId(account.getUsr_id());
					masCmd.modifyMasCommonInterface(masBkgComIfVo);  
					                
					// Back End Job으로 호출 
					// IBookingARCreationBC::interfaceBKGARInvoiceToINV ( bkgIfVo )
					BookingARCreationBC bookingARCreationBC = new BookingARCreationBCImpl();
					ARBkgInterfaceCreationVO bkgIfVo = new ARBkgInterfaceCreationVO();
					bkgIfVo.setBkgNo(bkg_no);
					bkgIfVo.setManDivInd("B");
					bkgIfVo.setUserId(account.getUsr_id());
					bookingARCreationBC.interfaceBKGARInvoiceToINV(bkgIfVo);
	
					// Container 별 Rate 배주 처리
					BlRatingBC blRatingBC = new BlRatingBCImpl();
					bkgBlNoVO.setBkgNo(bkg_no);
					bkgBlNoVO.setBlNo(bl_no);  
					bkgBlNoVO.setCaUsrId(account.getUsr_id());
					blRatingBC.distributeCntrRate(bkgBlNoVO.getBkgNo(), account);
					
				}
			}
			
			
			/**
			 *  OBLISS	ORIGINAL B/L ISSUE
			 *  OBLRED	ORIGINAL B/L REDEMPTION
			 *  OBLRIS	ORIGINAL B/L REISSUE
			 *  OBLREL	ORIGINAL B/L RELEASE
			 *  OBLSRD	ORIGINAL B/L SURRENDER
			 *  BKGRAT	RATING
			 */
	
			// < docPrcModyFlg='Y'인경우 >  by 2009.11.11 , 신자영 
		    // IBookingHistoryMgtBC::manageDocProcess ( docProcSkd )
			BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
	        docProcSkdVO.setBkgNo(bkg_no);
	        docProcSkdVO.setBkgDocProcTpCd("OBLSRD");
	        bookingHistoryMgtBC.manageDocProcess(docProcSkdVO, account);
	        
			/* create history */
			bookingHistoryMgtBC.manageBookingHistory(uiId, historyTableVO, account);
			
			//ICargoReleaseOrderBC::setupFocByObl ( OblRdemVO )
			
			log.debug("===============================================================");
			log.debug("[start][======== [CargoReleaseOrderBCImpl] :: setupFocByObl ]");
			log.debug("===============================================================");
				
			CargoReleaseOrderBC cargoBC = new CargoReleaseOrderBCImpl();
			OblRdemVO oblRdem = new OblRdemVO();
			oblRdem.setBlNo(bkgBlNoVO.getBlNo());
			oblRdem.setCgorTeamCd("S");
			oblRdem.setCgoEvntNm("Surrender");
			oblRdem.setEvntDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
			oblRdem.setEvntOfcCd(account.getOfc_cd());
			oblRdem.setEvntUsrId(account.getUsr_id());
			oblRdem.setOblRdemFlg("Y");

			try{
				cargoBC.setupFocByObl(oblRdem);
			}catch(Exception e1){
				log.debug("[end:: CargoReleaseOrderBC == manageBlIssInfo update ]==========");
				log.error(e1.getMessage()); 
			}			
			commit();
			
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06014").getMessage(), ex);
		}
		log.debug("[end:: BLIssuanceBC == manageBlIssInfo update ]==========");
		return eventResponse;
	}

	/**
	 * OBL을 surrender(포기) 처한다.(ESM_BKG_0400)
	 * O/BL Surrender 처리시 OBS Charge 정보가 존재하는지 체크한다.<br>
     * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchSurchargeRatingByObs(Event e) throws EventException {
		log.debug("[START:: SurchargeAutoRatingBC == searchSurchargeRatingByObs ]==========");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmBkg0400Event event = (EsmBkg0400Event) e;
		String bkgNo = event.getBkg_no();
		String existObsFlg = "N";
		
		 // O/BL Surrender 처리시 OBS Charge 정보가 존재할 경우 OBS Charge 항목을 추가한다.
		SurchargeAutoRatingBC surAutoRaingBC = new SurchargeAutoRatingBCImpl();
		BkgObsSurchargeRateVO bkgObsSurchargeRateVO = surAutoRaingBC.searchSurchargeRatingByObs(bkgNo, account); //2011.07.01 인자 추가(account));
		
		if(bkgObsSurchargeRateVO != null){
			existObsFlg = "Y";
 
			eventResponse.setETCData("existObsFlg", existObsFlg);
			eventResponse.setETCData("curr_cd", bkgObsSurchargeRateVO.getCurrCd());
			eventResponse.setETCData("scg_amt", bkgObsSurchargeRateVO.getScgAmt());
		}
		
		log.debug("[end:: SurchargeAutoRatingBC == searchSurchargeRatingByObs ]==========");
		return eventResponse;
	}
	
	
	/**
	 * EsmBkg0400Event 삭제 이벤트 처리(ESM_BKG_0400)<br>
	 * Surrender 정보를 초기화 한다.<br>
	 * 
	 * @author LEE JIN SEO
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse removeSurrenderInfo(Event e) throws EventException {
		log.debug("[START:: BLIssuanceBC == removeSurrenderInfo update ]==========");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC bLIssuanceBC 					= new BLIssuanceBCImpl();

		/* History Setup */
		HistoryTableVO historyTableVO = new HistoryTableVO ();
		BookingHistoryMgtBC bookingHistoryMgtBC 	= new BookingHistoryMgtBCImpl();
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		BookingUtil utilCmd = new BookingUtil();
		String uiId = "ESM_BKG_0400";
		
		EsmBkg0400Event event						= (EsmBkg0400Event) e;
		String bkg_no 								= event.getBkg_no();
		
		try {
			begin();

			/* search old history */
			bkgBlNoVO.setBkgNo(bkg_no);
			bkgBlNoVO.setCaUsrId(account.getUsr_id());
			bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoVO);
			historyTableVO = bookingHistoryMgtBC.searchOldBkgForHistory(uiId, bkgBlNoVO);
			
			//[] BLIssuanceDBDAO::removeSurrenderInfo ( bkgNo )
			//Surrender 정보를 초기화 한다.
			//≪≫ removeSurrenderInfo ( [in] bkgNo : String ) : void
			bLIssuanceBC.removeSurrenderInfo(bkg_no);
			
			// < docPrcModyFlg='Y'인경우 >  by 2009.11.11 , 신자영 
			// 5. [] IBookingHistoryMgtBC::manageDocProcess ( docProcSkd )
			BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
			docProcSkdVO.setBkgNo(bkg_no);
			docProcSkdVO.setBkgDocProcTpCd("OBLSRC");
			bookingHistoryMgtBC.manageDocProcess(docProcSkdVO, account);

			/* create history */
			bookingHistoryMgtBC.manageBookingHistory(uiId, historyTableVO, account);
			
			//ICargoReleaseOrderBC::setupFocByObl ( OblRdemVO )
			log.debug("===============================================================");
			log.debug("[start][======== [CargoReleaseOrderBCImpl] :: setupFocByObl ]");
			log.debug("===============================================================");
			
			CargoReleaseOrderBC cargoBC = new CargoReleaseOrderBCImpl();
			OblRdemVO oblRdem = new OblRdemVO();
			oblRdem.setBlNo(bkgBlNoVO.getBlNo());
			oblRdem.setCgorTeamCd("S");
			oblRdem.setCgoEvntNm("Surrender Cancel");
			oblRdem.setEvntDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
			oblRdem.setEvntOfcCd(account.getOfc_cd());
			oblRdem.setEvntUsrId(account.getUsr_id());
			oblRdem.setOblRdemFlg("N");

			try{
				cargoBC.setupFocByObl(oblRdem);
			}catch(Exception e1){
				log.debug("[end:: CargoReleaseOrderBC == removeSurrenderInfo update ]==========");
				log.error(e1.getMessage()); // 2011.07.15
			}
			
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06014").getMessage(), ex);
		}
		log.debug("[end:: BLIssuanceBC == removeSurrenderInfo update ]==========");
		return eventResponse;
	}

	/**
	 * EsmBkg00059Event 조회 이벤트 처리(ESM_BKG_0059)<br>
	 * Documentation Requirement(ESM_BKG-0079 의 B/L INFO의 POP-UP)<br>
	 * 화면번호 : Documentation Requirement 데이터를 조회 -- UI_BKG-0059 <br>
	 * 
	 * @author LEE JIN SEO
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchDocRqst(Event e) throws EventException {
		log.debug("[START:: BLIssuanceBC == searchDocRqst SEARCH ]==========");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();

		EsmBkg0059Event event = (EsmBkg0059Event) e;
		String bkg_no = event.getBkg_no();
		String ofc_cd = account.getOfc_cd();
		try {
			// 1. Documentation Requirement를 조회한다.
			List<DocRqstVO> docRqstList = command.searchDocRqst(bkg_no, ofc_cd);

			eventResponse.setRsVoList(docRqstList);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		log.debug("[end:: BLIssuanceBC == searchDocRqst SEARCH ]==========");
		return eventResponse;
	}

	/**
	 * Documentation Requirement 정보를 수정(ESM_BKG_0059)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse modifyDocRqst(Event e) throws EventException {
		log.debug("[START:: BLIssuanceBC == modifyDocRqst update ]==========");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();
		EsmBkg0059Event event = (EsmBkg0059Event) e;
		DocRqstVO[] docRqstVOs = event.getDocRqstVOs();
		docRqstVOs[0].setUserId(account.getUsr_id());
		try {
			begin();
			command.modifyDocRqst(docRqstVOs[0]);
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06014").getMessage(), ex);
		}
		log.debug("[end:: BLIssuanceBC == modifyDocRqst update ]==========");
		return eventResponse;
	}

	/**
	 * Package의 Description을 조회한다.(ESM_BKG_0079_06)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchPckTp(Event e) throws EventException {
		EsmBkg007906Event event = (EsmBkg007906Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BookingUtil utilCmd = new BookingUtil();

		try {
			MdmPckTpVO pckTpVO = utilCmd.searchPkgType(event.getPckTpCd());
			eventResponse.setETCData("pck_nm", (pckTpVO.getPckNm() == null ? "" : pckTpVO.getPckNm()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * b/l의 화주 정보에 대한 template 정보를 조회한다.(ESM_BKG_0079_06)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchUserTmpltList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		// EsmBkg007906Event event = (EsmBkg007906Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		UserSetupMgtBC command = new UserSetupMgtBCImpl();

		try {
			BkgUsrTmpltVO vo = new BkgUsrTmpltVO();
			vo.setUsrId(account.getUsr_id());

			List<BkgUsrTmpltVO> list = command.searchUserTmpltList(vo);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * dangerous cargo 정보를 조회(ESM_BKG_0079_06)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchDG(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg007906Event event = (EsmBkg007906Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLDocumentationBLBC command = new BLDocumentationBLBCImpl();

		String bkgNo = event.getBkgNo();
		log.debug("searchDG ================> " + bkgNo);

		try {
			/*
			 * EX) 40 DRUMS UN3082, CLASS 9 ENVIRONMENTALLY HAZARDOUS SUBSTANCE,
			 * LIQUID, N.O.S. (ZINCALKYLDITHIOPHOSPHATE) F.P. 100 [IMDG Class 3
			 * 으로 시작하는 경우 only] EMERGENCY CONTACT 1-703-527-3887
			 * 
			 * DG seq 별로 set을 만들어서 전체 하나의 텍스트로 처리"
			 */
			StringBuffer sbuf = new StringBuffer("");
			List<DGCargoVO> list = command.searchDG(bkgNo);
			DGCargoVO vo = null;
			Double pkg_qty = 0.0;
			int len = list == null ? 0 : list.size();
			for (int i = 0; i < len; i++) {
				vo = list.get(i);
				pkg_qty = (vo.getPckQty() == null || vo.getPckQty().length() == 0) ? 0 : Double.parseDouble(vo.getPckQty());
				sbuf.append(pkg_qty + " " + vo.getPckNm() + "\n");
				sbuf.append("UN" + vo.getImdgUnNo() + ", CLASS " + vo.getImdgClssCd() + "\n");
				sbuf.append(vo.getPrpShpNm() + "\n");
				// if(vo.getHzdDesc()!=null && vo.getHzdDesc().length()>0){
				sbuf.append("(" + (vo.getHzdDesc()==null ? "" : vo.getHzdDesc().trim()) + ")\n");
				// }
				if (vo.getImdgClssCd() != null && vo.getImdgClssCd().startsWith("3")) {
					sbuf.append("F.P. " + (vo.getFlshPntCdoTemp()==null ? "" : vo.getFlshPntCdoTemp().trim()) + "\n");
				}
				sbuf.append("EMERGENCY CONTACT " + (vo.getEmerCntcPhnNoCtnt()==null ? "" : vo.getEmerCntcPhnNoCtnt().trim()) + "\n");
			}
			log.debug("\n******************** COPY_FROM_DG ********************\n" + sbuf.toString());
			eventResponse.setETCData("copy_from_dg", sbuf.toString());

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * UI_BKG_0079_07 : Retrieve
	 * Container Manifest 정보를 조회한다.(ESM_BKG_0079_07)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchCm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg007907Event event = (EsmBkg007907Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BookingUtil utilCmd = new BookingUtil();
		BLDocumentationCMBC docCmd = new BLDocumentationCMBCImpl();

		BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
		bkgBlNoIN.setBkgNo(event.getBkgNo());
		bkgBlNoIN.setBlNo(event.getBlNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());
		List<BkgHrdCdgCtntVO> bkgHrdCdgCtntVOs = null;

		try {
			// searchBkgBlNo
			BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new EventException(new ErrorHandler("BKG01049", new String[]{event.getBkgNo()}).getMessage());
			}
			log.debug("=====> CA Flag    : " + bkgBlNoVO.getCaFlg());
            
			/* update on 2009.12.31 */
            String cgoTp = utilCmd.searchBkgCgoTp(bkgBlNoIN);
            if("P".equals(cgoTp)) {
                throw new EventException(new ErrorHandler("BKG00092", new String[]{event.getBkgNo()}).getMessage());
            }
            log.debug("=====> Cgargo Tpye : " + cgoTp);
            
            // Iran Sanction 관련 특정 HS 코드 조회
            bkgHrdCdgCtntVOs = utilCmd.searchSanctionHsCdList(bkgBlNoIN);

            
			CmVO cmVO = docCmd.searchCm(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getCaFlg());

			CmBkgInfoVO cmInfoVO = cmVO.getCmBkgInfoVO();
			List<CmCntrInfoVO> cmCntrInfoVOs = cmVO.getCmCntrInfoVOs();
			// List<BkgCntrSealNoVO> cntrSealNoVOs = cmVO.getCntrSealNoVOs();
			List<BkgCntrMfDescVO> cntrMfDescVOs = cmVO.getBkgCntrMfDescVOs();
			//2010-12-08
			List<BkgDgCgoVO> bkgDgCgoVOs = cmVO.getBkgDgCgoVOs();

			eventResponse.setRsVoList(cmCntrInfoVOs);
			eventResponse.setETCData(cmInfoVO.getColumnValues());
			eventResponse.setETCData("corr_flg", bkgBlNoVO.getCaFlg());
            eventResponse.setETCData("ca_exist_flg", bkgBlNoVO.getCaExistFlg());
			eventResponse.setETCData("obl_iss_flg", utilCmd.oblIssFlgCheck(bkgBlNoVO.getBkgNo(),bkgBlNoVO.getCaFlg()));
			// eventResponse.setRsVoList(cntrSealNoVOs);
			eventResponse.setRsVoList(cntrMfDescVOs);
			//2010-12-08
			eventResponse.setRsVoList(bkgDgCgoVOs);
            // Iran Sanction 관련 특정 HS 코드 조회
			eventResponse.setRsVoList(bkgHrdCdgCtntVOs);

			//wpm code list를 조회
			List<BkgComboVO> wpm_cd = utilCmd.searchCombo("CD03478");
			eventResponse.setRsVoList(wpm_cd);
			

			/*
			 * CmVO cmVO = docCmd.searchCM(bkgNo, blNo);
			 * 
			 * List<BkgCntrSealNoVO> cntrSealNoVOs = cmVO.getCntrSealNoVOs();
			 * 
			 * StringBuffer sbuf = new StringBuffer(); int len =
			 * (cntrSealNoVOs==null) ? 0 : cntrSealNoVOs.size(); for(int
			 * i=0;i<len;i++){
			 * sbuf.append(cntrSealNoVOs.get(i).getCntrSealNo()); if(i+1 != len)
			 * sbuf.append("|"); }
			 * 
			 * List<BkgCntrMfDescVO> cntrMfDescVOs = cmVO.getBkgCntrMfDescVOs();
			 * 
			 * eventResponse.setRsVoList(cntrMfDescVOs);
			 * eventResponse.setETCData("cntr_seal_no", sbuf.toString());
			 */
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0079_07, 0178 : manage 수행 후 실행<br>
	 * Block Stowage 정보를 업데이트 한다<br>
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private void modifyBsByCm(String bkgNo, String caFlag, String gdsDesc) throws EventException
	{
		GeneralBookingReceiptBC rcptCmd = new GeneralBookingReceiptBCImpl();
		BookingUtil utilCmd = new BookingUtil();
		BkgRouteVO bkgRouteVO = new BkgRouteVO();
		String podNodeCd = null;
		String blckStwgCd = null;
		BkgBookingVO bkgBookingVO = new BkgBookingVO();
		List<BkgBookingVO> bkgBookingVOs = null;
		
		try {
			bkgRouteVO = utilCmd.searchBkgRoute(bkgNo);
			bkgBookingVOs = utilCmd.searchBookingSplitNo(bkgNo);
			if(bkgBookingVOs.size()>0) {
				bkgBookingVO = bkgBookingVOs.get(0);
				blckStwgCd = bkgBookingVO.getBlckStwgCd();
			}
			
			podNodeCd = bkgRouteVO.getPodNodCd();
			
			//LB2, LB3일 경우만 업데이트 처리			
			if("LB3".equals(blckStwgCd)) {
				if (gdsDesc != null && 
		                (gdsDesc.indexOf("NOTE BOOK") >= 0 || 
		                	gdsDesc.indexOf("LCD-TFT") >= 0 || 
		                	gdsDesc.indexOf("MONITOR") >= 0 || 
		                	gdsDesc.indexOf("SHOE") >= 0 || 
		                	gdsDesc.indexOf("FOOTWEAR") >= 0) && 
		                	"USLGBPT".equals(podNodeCd)) {
		                    bkgBookingVO.setBkgNo(bkgNo);
		                    bkgBookingVO.setBlckStwgCd("LB1");
		                    rcptCmd.modifyBkgByCm(bkgBookingVO, caFlag);	                    
		                }
			}
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * container를 다른 booking으로 복사한다.(ESM_BKG_0079_07)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageCm(Event e) throws EventException {
		EsmBkg007907Event event = (EsmBkg007907Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLDocumentationCMBC docCmd = new BLDocumentationCMBCImpl();
		BLDocumentationBLBC blDoc = new BLDocumentationBLBCImpl();
		BookingUtil utilCmd = new BookingUtil();
        BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
        GeneralBookingReceiptBC bkgRct = new GeneralBookingReceiptBCImpl();
        UserSetupMgtBC userCmd = new UserSetupMgtBCImpl();
        //BDRCorrectionBC correctCmd = new BDRCorrectionBCImpl();

		CmVO cmVO = event.getCmVO();

		CmBkgInfoVO vo1 = cmVO.getCmBkgInfoVO();
		// List<CmCntrInfoVO> vo2 = cmVO.getCmCntrInfoVOs();
		List<BkgCntrMfDescVO> vo3 = cmVO.getBkgCntrMfDescVOs();
		log.debug("******** BkgNo : " + vo1.getBkgNo());

		BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
		bkgBlNoIN.setBkgNo(vo1.getBkgNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

		HistoryTableVO historyTableVO = null;

		String uiId = "ESM_BKG_0079_07";

		try {
			begin();
			/* searchBkgBlNo */
			BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new EventException(new ErrorHandler("BKG01049").getMessage());
			}
			log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());

			/* Validate Container */
			docCmd.validateCm(cmVO);
			log.debug("=====> validateCm    : OK!");
			
			//[CHM-201322261-01] Marble 운송사고 예방을 위한 Booking-Special Stowage (MUPG) 자동지정 프로그래밍 요청
			if( !"".equals(event.getCmVO().getCmBkgInfoVO().getStwgCd()) ){
				bkgRct.modifyCmFlgBySpcl(event.getCmVO().getCmBkgInfoVO().getBkgNo(), event.getCmVO().getCmBkgInfoVO().getStwgCd(), bkgBlNoVO.getCaFlg());
			}
            
			//Potential DG 화물 목록을 체크한다.
//    		BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
//    		bkgHrdCdgCtntListCondVO.setHrdCdgId("POTENTIAL_DG");			
//    		List<BkgHrdCdgCtntVO> keyWord = utilCmd.searchHardCoding(bkgHrdCdgCtntListCondVO);
//    		String flg = "N";
    		
			//Potential DG 화물 목록을 체크한다.
    		List<BlckKwListVO> keyWord = userCmd.searchBkgBlckKwList("POT");
    		String flg = "N";
    		
            /* BOOKING.BLOCK STOWAGE CODE 업데이트 : commodity가 NOTE BOOK, LCD-TFT,
             * COLOR MONITOR, MONITOR, SHOE인 경우 POD가 "USLAX"나 "USLGB" 면
             * BOOKING.BLOCK STOWAGE CODE를 LB4로 업데이트 한다. */
            if(vo3 != null && vo3.size() > 0){
                String gdsDesc = null;
                String gdsDescDg = null;
                for(int i=0;i<vo3.size();i++){
                	gdsDesc = vo3.get(i).getCntrMfGdsDesc();
                	gdsDescDg = vo3.get(i).getCntrMfGdsDesc().toUpperCase();
                    modifyBsByCm(vo1.getBkgNo(), bkgBlNoVO.getCaFlg(), gdsDesc);
                    
                  //Potential DG 화물 목록을 체크한다.
            		for(int j=0;j<keyWord.size();j++){
            			if(gdsDescDg != null && gdsDescDg.indexOf(keyWord.get(j).getBlckKwNm()) >= 0){
            				flg = "Y";
            				//컨테이너 중 1개라도 키워드에 걸리면 해당 데이터만 인터페이스
            				BkgBlckListMntrVO cntrMfGdsDesc = new BkgBlckListMntrVO();
            				cntrMfGdsDesc.setBkgNo(vo1.getBkgNo());
            				cntrMfGdsDesc.setBlckKwTpCd("POT");
            				cntrMfGdsDesc.setBlckKwNm(keyWord.get(j).getBlckKwNm());
            				cntrMfGdsDesc.setCntrMfGdsDescKwNm(keyWord.get(j).getBlckKwNm());
            				cntrMfGdsDesc.setCreUsrId(account.getUsr_id());
            				cntrMfGdsDesc.setUpdUsrId(account.getUsr_id());
            				utilCmd.addBkgBlckListMntr(cntrMfGdsDesc);
            				break;
            			}
            		}
//                    if (gds_desc != null && 
//                       (gds_desc.indexOf("NOTE BOOK") >= 0 || 
//                        gds_desc.indexOf("NOTEBOOK") >= 0 || 
//                        gds_desc.indexOf("LCD") >= 0 || 
//                        gds_desc.indexOf("TFT") >= 0 || 
//                        gds_desc.indexOf("MONITOR") >= 0 || 
//                        gds_desc.indexOf("SHOE") >= 0 || 
//                        gds_desc.indexOf("FOOTWEAR") >= 0 || 
//                        gds_desc.indexOf("FOOT WEAR") >= 0) && 
//                       ("USLAX".equals(vo1.getPodCd()) || "USLGB".equals(vo1.getPodCd()))) {
//                           BkgBookingVO bkgBookingVO = new BkgBookingVO();
//                           bkgBookingVO.setBkgNo(vo1.getBkgNo());
//                           bkgBookingVO.setBlckStwgCd("LB4");
//                           rcptCmd.modifyBkgByCm(bkgBookingVO, bkgBlNoVO.getCaFlg());
//                       }
                }
            }
            // WPM관련 자동문구를 조회한다.
            String oldDesc = docCmd.searchWpmDescForBl(bkgBlNoVO, "N");
            /* Search Booking History */
            historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoVO);
            
			/* modifyCngScreenFlag */
			//if ("Y".equals(bkgBlNoVO.getCaFlg())) {
				//correctCmd.modifyCngScreenFlag("", bkgBlNoVO);  //사용않함으로 변경됨.
			//}
			
            
			/* Manage CM */
			docCmd.manageCm(cmVO, account, bkgBlNoVO.getCaFlg());
			
            //wpm관련 자동문구 저장
            blDoc.modifyBlDescByWpm(bkgBlNoVO, oldDesc, account.getUsr_id());

            /* Manage Booking History */
            histCmd.manageBookingHistory(uiId, historyTableVO, account);
            
            //DG화물로 등록되어있지 않으면서 DG Keyword 포함하고 있는지 체크 . 최원정부장님 요청
			String dgKeyFlg2 = utilCmd.searchPotentialDgFlg2(bkgBlNoVO,"CM");
			String dgKeyRslArr[] = dgKeyFlg2.split(",");
			
			//
			if(!"N".equalsIgnoreCase(dgKeyFlg2)){
				BkgBlckListMntrVO vo = new BkgBlckListMntrVO();
				vo.setBkgNo(vo1.getBkgNo());
				vo.setBlckKwTpCd("MIS");
				vo.setCreUsrId(account.getUsr_id());
				vo.setUpdUsrId(account.getUsr_id());
				vo.setBlckKwNm(dgKeyRslArr[0]);
				vo.setCntrMfGdsDescKwNm(dgKeyRslArr[0]);
				
				utilCmd.addBkgBlckListMntr(vo);
			}
			
			
			
			eventResponse.setETCData("dg_key_flg", flg);
			eventResponse.setETCData("dg_key_flg2", dgKeyFlg2);
			
			/* Set Message */
			eventResponse.setUserMessage("");
			commit();
			
			//CA일 땐 CA confirm 로직에서 조건 판단 후 이메일 전송여부 결정
			if(!"Y".equalsIgnoreCase(bkgBlNoVO.getCaFlg())){
				/* US filer가 1이고 self일 때 auto notification(이메일) 전송 */
				String emlArr[] = new String[2];
				CmSelfMailVO cmSelfMailVO = new CmSelfMailVO();
				//조건에 맞으면, BKG와 SI Contact email 주소를 가져온다
				emlArr = blDoc.checkSelfFilingCM(vo1.getBkgNo(),"N");			
				StringBuffer emlAdd = new StringBuffer();
				
				//한 번 성공적으로 전송된 이력이 있으면 다시 보내지 않음.
				String chkCmSelfEmailFlg = blDoc.chkCsEmailHisoty(vo1.getBkgNo());
				
				if(emlArr!=null && emlArr.length>1 && ("N".equalsIgnoreCase(chkCmSelfEmailFlg))){
					if(!"".equalsIgnoreCase(emlArr[0])){
						for(int i=0; i<emlArr.length;i++){
							emlAdd = emlAdd.append(emlArr[i]);
							emlAdd = emlAdd.append(";");
						}
						
						begin();
						//이메일에 들어갈 데이터 search
						cmSelfMailVO = blDoc.searchContentsForSelfMail(vo1.getBkgNo(),"N");
						
						/* 1. Send Email */
						List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
						BkgNtcHisVO bkgNtcHisVO = blDoc.sendChkSelfCMByEmail(vo1.getBkgNo(),emlAdd.toString(),cmSelfMailVO);
						bkgNtcHisVOs.add(bkgNtcHisVO);
						/* 2. Register Notice History */
						histCmd.createBkgNtcHis(bkgNtcHisVOs, account.getUsr_id());
						commit();
						log.debug("=====> eml_address    : " + emlAdd);
					}
					
				}
			}
			
			
			
		} catch (EventException ex) {
			rollback();
			//eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0079_06 : 초기 화면 로딩(ESM_BKG_0079_04,ESM_BKG_0079_06)<br>
	 * BLDocumentationBL의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchCombo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		// EsmBkg007906Event event = (EsmBkg007906Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BookingUtil comboUtil = new BookingUtil();

		try {
			// freight term code, CD02080
			List<BkgComboVO> frt_terms = comboUtil.searchCombo("CD02080");
			int len = frt_terms == null ? 0 : frt_terms.size();
			for (int i = 0; i < len; i++) {
				BkgComboVO vo = frt_terms.get(i);
				vo.setName(vo.getVal() + "-" + vo.getName());
			}
			// weight unit, CD00775
			List<BkgComboVO> wgt_units = comboUtil.searchCombo("CD00775");
			// measure unit, CD01116
			List<BkgComboVO> meas_units = comboUtil.searchCombo("CD01116");

			eventResponse.setCustomData("frt_terms", frt_terms);
			eventResponse.setCustomData("wgt_units", wgt_units);
			eventResponse.setCustomData("meas_units", meas_units);

			// eventResponse.setRsVoList(frt_terms);
			// eventResponse.setRsVoList(wgt_units);
			// eventResponse.setRsVoList(meas_units);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
     * Container No로 Type Size, Status 등의 정보를 가져온다.(ESM_BKG_0079_04)
     * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCntrDtlInfo(Event e) throws EventException {
    	EsmBkg007904Event event = (EsmBkg007904Event) e;
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    
    	BLDocumentationCMBC command = new BLDocumentationCMBCImpl();
    
    	String bkgNo = event.getBkgNo();
    	String cntrNo = event.getCntrNo();
    
    	try {
    		CntrDetailInfoVO detailVo = command.searchCntrDtlInfo(cntrNo);
/*
    		if (detailVo == null) {
    			// BKG00173 : "failed to find CNTR("+cntrNo+")"
    			// throw new EventException(new
    			// ErrorHandler("BKG00173").getMessage());
    		} else {
    			detailVo.setBkgNo(bkgNo);
    			// detailVo.setBkgNoSplit(bkgNoSplit);
    			eventResponse.setETCData(detailVo.getColumnValues());
    		}
*/
    		if (null != detailVo) {
    			detailVo.setBkgNo(bkgNo);
    			eventResponse.setETCData(detailVo.getColumnValues());
    		}
    	} catch (EventException ex) {
    		throw ex;
    	} catch (Exception ex) {
    		throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
    	}
    	return eventResponse;
    }

    /**
	 * B/L의 Mark And Description 정보를 조회한다.(ESM_BKG_0079_06)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchMnd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg007906Event event = (EsmBkg007906Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BookingUtil utilCmd = new BookingUtil();
		BLDocumentationBLBC docCmd = new BLDocumentationBLBCImpl();
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();

		BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
		bkgBlNoIN.setBkgNo(event.getBkgNo());
		bkgBlNoIN.setBlNo(event.getBlNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

		try {
			// searchBkgBlNo
			BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new EventException(new ErrorHandler("BKG01049", new String[]{event.getBkgNo()}).getMessage());
			}
			log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());
            
            /* update on 2009.12.31 */
            String cgoTp = utilCmd.searchBkgCgoTp(bkgBlNoIN);
            if("P".equals(cgoTp)) {
                throw new EventException(new ErrorHandler("BKG00092", new String[]{event.getBkgNo()}).getMessage());
            }
            log.debug("=====> Cgargo Tpye : " + cgoTp);
            
            
			/* 
			 * User Default Set을 적용하기 위해 UserId가 필요. 
			 * modified on 2009-11-03 by KimYoungchul 
			 */ 
			bkgBlNoVO.setIbflag(account.getUsr_id());
			
			MndVO mndVO = docCmd.searchMnd(bkgBlNoVO);

			eventResponse.setETCData(mndVO.getColumnValues());
            eventResponse.setETCData("corr_flg", bkgBlNoVO.getCaFlg());
            eventResponse.setETCData("ca_exist_flg", bkgBlNoVO.getCaExistFlg());
			eventResponse.setETCData("obl_iss_flg", utilCmd.oblIssFlgCheck(bkgBlNoVO.getBkgNo(),bkgBlNoVO.getCaFlg()));

			if((mndVO.getPodCd() !=null && "JOAQJ".equals(mndVO.getPodCd()))){
				String custFlg = docCmd.searchRvisCntrCustTpCd(bkgBlNoVO.getBkgNo(),bkgBlNoVO.getCaFlg());
				eventResponse.setETCData("cust_flg", custFlg);
			}
			
			List<BkgClauseLockVO> bkgClauseLockVOs = receiptBC.searchBkgClauseLock(bkgBlNoVO.getBkgNo(),"D");
			eventResponse.setRsVoList(bkgClauseLockVOs);
			
			// HashMap<String, String> returnMap = mndVO.getColumnValues();
			// Iterator<String> iter = returnMap.keySet().iterator();
			// while(iter.hasNext()){
			// String key = iter.next();
			// String val = returnMap.get(key);
			// eventResponse.setETCData(key, (val==null ? "" : val));
			// }
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * B/L의 Mark And Description 정보를 추가/수정한다.(ESM_BKG_0079_06)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageMnd(Event e) throws EventException {

		EsmBkg007906Event event = (EsmBkg007906Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

        BookingUtil utilCmd = new BookingUtil();
		BLDocumentationBLBC docCmd = new BLDocumentationBLBCImpl();
		BlRatingBC rateCmd = new BlRatingBCImpl();
		BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
		BLIssuanceBC issCmd = new BLIssuanceBCImpl();
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		UserSetupMgtBC userCmd = new UserSetupMgtBCImpl();
		
        //BDRCorrectionBC correctCmd = new BDRCorrectionBCImpl();

		MndVO mndVO = event.getMndVO();

		BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
		bkgBlNoIN.setBkgNo(mndVO.getBkgNo());
		bkgBlNoIN.setBlNo(mndVO.getBlNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

		HistoryTableVO historyTableVO = null;

		String uiId = "ESM_BKG_0079_06";

		try {
			begin();
			/* searchBkgBlNoVO */
			BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new EventException(new ErrorHandler("BKG01049").getMessage());
			}
			log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());

			/* Validate MnD */
			docCmd.validateMnd(mndVO);

			/* Search Booking History */
			historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoVO);

			/* Change Screen Flag */
			//if ("Y".equals(bkgBlNoVO.getCaFlg())) {
				//correctCmd.modifyCngScreenFlag(uiId, bkgBlNoVO);  //사용않함으로 변경됨.
			//}
			
			//Potential DG 화물 목록을 체크한다.
//    		BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
//    		bkgHrdCdgCtntListCondVO.setHrdCdgId("POTENTIAL_DG");			
//    		List<BkgHrdCdgCtntVO> keyWord = utilCmd.searchHardCoding(bkgHrdCdgCtntListCondVO);
//    		String flg = "N";
    		
    		//Potential DG 화물 목록을 체크한다.
    		List<BlckKwListVO> keyWord = userCmd.searchBkgBlckKwList("POT");
    		String cstmsDesc = mndVO.getCstmsDesc().toUpperCase();
    		String cmdtDesc = mndVO.getDgCmdtDesc().toUpperCase();
    		String flg = "N";
    		
    		BkgBlckListMntrVO cstmsDescBkgBlckListMntrVO = new BkgBlckListMntrVO();
    		BkgBlckListMntrVO cmdtDescBkgBlckListMntrVO = new BkgBlckListMntrVO();
    		
    		//해당 키워드에 걸리면 mntr 테이블로 인터페이스
    		for(int i=0;i<keyWord.size();i++){
    			if(!"".equals(cstmsDesc) && cstmsDesc.indexOf(keyWord.get(i).getBlckKwNm()) >= 0){
    				flg = "Y";
    				cstmsDescBkgBlckListMntrVO.setBkgNo(bkgBlNoVO.getBkgNo());
    				cstmsDescBkgBlckListMntrVO.setBlckKwTpCd("POT");
    				cstmsDescBkgBlckListMntrVO.setBlckKwNm(keyWord.get(i).getBlckKwNm());
    				cstmsDescBkgBlckListMntrVO.setCstmsDescKwNm(keyWord.get(i).getBlckKwNm());
    				cstmsDescBkgBlckListMntrVO.setCreUsrId(account.getUsr_id());
    				cstmsDescBkgBlckListMntrVO.setUpdUsrId(account.getUsr_id());
    				utilCmd.addBkgBlckListMntr(cstmsDescBkgBlckListMntrVO);
    				break;
    			}
    			if(!"".equals(cmdtDesc) && cmdtDesc.indexOf(keyWord.get(i).getBlckKwNm()) >= 0){
    				flg = "Y";
    				cmdtDescBkgBlckListMntrVO.setBkgNo(bkgBlNoVO.getBkgNo());
    				cmdtDescBkgBlckListMntrVO.setBlckKwTpCd("POT");
    				cmdtDescBkgBlckListMntrVO.setBlckKwNm(keyWord.get(i).getBlckKwNm());
    				cmdtDescBkgBlckListMntrVO.setCmdtDescKwNm(keyWord.get(i).getBlckKwNm());
    				cmdtDescBkgBlckListMntrVO.setCreUsrId(account.getUsr_id());
    				cmdtDescBkgBlckListMntrVO.setUpdUsrId(account.getUsr_id());
    				utilCmd.addBkgBlckListMntr(cmdtDescBkgBlckListMntrVO);
    				break;
    			}
    		}
    		eventResponse.setETCData("dg_key_flg", flg);
    		
    		/* POD or DEL이 터키일 때 Consignee or Notify tax id 없으면 저장 불가 Validation 추가 */
	        if ((mndVO.getPodCd() != null && mndVO.getPodCd().length() >= 2 && "TR".equals(mndVO.getPodCd() .substring(0, 2))) || 
					(mndVO.getDelCd() != null && mndVO.getDelCd().length() >= 2 && "TR".equals(mndVO.getDelCd() .substring(0, 2)))) {
				String chkTrTax = docCmd.checkTurkeyTaxId(mndVO.getBkgNo(),bkgBlNoVO.getCaFlg());
				if(!"Y".equalsIgnoreCase(chkTrTax)){
					throw new EventException((String)new ErrorHandler("BKG95098").getMessage());
				}
					
			}
			/* Manage MnD */
			docCmd.manageMnd(mndVO, account, bkgBlNoVO.getCaFlg());
            
            /* Manage Rate*/
            rateCmd.manageFrtTerm(bkgBlNoVO.getBkgNo(), mndVO.getFrtTermCd(), mndVO.getFrtTermPrnFlg(), account, bkgBlNoVO.getCaFlg());
                      
            if (!"Y".equals(bkgBlNoVO.getCaFlg())) {
            	log.debug("\n======= Auto EDI Send ======\n");
            	List<BkgNtcHisVO> bkgNtcHisVOs = issCmd.createDraftBlEdiAuto(bkgBlNoVO.getBkgNo(), "N",  account);

				if (bkgNtcHisVOs != null) {
					if (bkgNtcHisVOs.size() > 0) {
						histCmd.createBkgNtcHis(bkgNtcHisVOs,"ESM_BKG_0095");
						
						//philips 계약인 BKG에 대해서 DBL전송
						String philips = issCmd.searchPhilipsCheck(bkgBlNoVO.getBkgNo());
						
		    			//philips 계약인 BKG에 대해서 DBL전송
		    			if(null!=philips && !"".equals(philips)){
		    				List<BkgNtcHisVO> bkgHisVOs = null;
		    				StringBuilder sbParam = new StringBuilder();
		    				
		    				String draftRemark = issCmd.searchDraftRemark(bkgBlNoVO.getBkgNo());

		                	
		            		sbParam.append("/rv");
		            		sbParam.append(" form_bkgNo[('").append(bkgBlNoVO.getBkgNo()).append("')]");
		            		sbParam.append(" form_type[").append("2").append("]");
		            		sbParam.append(" form_dataOnly[N]");
		            		sbParam.append(" form_manifest[N]");
		            		sbParam.append(" form_usrId[").append(account.getUsr_id()).append("]");
		            		sbParam.append(" form_hiddeData[N]");
		            		sbParam.append(" form_level[(").append(1).append(")]");
		            		sbParam.append(" form_remark[").append(draftRemark).append("]");
		            		sbParam.append(" form_Cntr[1]");
		            		sbParam.append(" form_mainOnly[N]");
		            		sbParam.append(" form_CorrNo[]");
		            		sbParam.append(" form_his_cntr[BKG_CONTAINER]");
		            		sbParam.append(" form_his_bkg[BKG_BOOKING]");
		            		sbParam.append(" form_his_mkd[BKG_BL_MK_DESC]"); 
		            		sbParam.append(" form_his_xpt[BKG_XPT_IMP_LIC]");
		            		sbParam.append(" form_his_bl[BKG_BL_DOC]");
		            		sbParam.append(" /rp []");
		            		sbParam.append(" /riprnmargin");
		            		
		    				
		    				DblWblVO[] dblWblVOs = new DblWblVO[1];
		    				dblWblVOs[0] = new DblWblVO();
		    				dblWblVOs[0].setBkgNo(bkgBlNoVO.getBkgNo());
		    				dblWblVOs[0].setBlNo(bkgBlNoVO.getBlNo());
		    				dblWblVOs[0].setSyscd("BKG");
		    				dblWblVOs[0].setTmplmrd("ESM_BKG_0109_DBL.mrd");
		    				dblWblVOs[0].setBatchflg("N");
		    				dblWblVOs[0].setTmplparam(sbParam.toString());
		    				dblWblVOs[0].setRcveml(philips);
		    				dblWblVOs[0].setTmplmrdpdf("SMLM"+bkgBlNoVO.getBkgNo()+".pdf");
		    				dblWblVOs[0].setItr("|$$|");
		    				dblWblVOs[0].setNtcKndCd("BL");
		    				dblWblVOs[0].setHiddOpt("N");
		    				dblWblVOs[0].setFrtAllFlg("Y");
		    				dblWblVOs[0].setFrtCltFlg("N");
		    				dblWblVOs[0].setFrtPpdFlg("N");
		    				dblWblVOs[0].setFrtChgFlg("N");
		                    dblWblVOs[0].setFrtArrFlg("N");
		                    
		                    //DPCS가 아니더라도 sender email주소 front office로
		                    dblWblVOs[0].setFntEmlFlg("Y");
		                    bkgHisVOs = issCmd.sendDblWblByEmail(dblWblVOs, null, account);
		    				if(bkgHisVOs.size()>0){
		    					histCmd.createBkgNtcHis(bkgHisVOs,"ESM_BKG_0095");
		    				}

		    			}
					}
				}	
			}
            
            //DG화물로 등록되어있지 않으면서 DG Keyword 포함하고 있는지 체크 . 최원정부장님 요청
			String dgKeyFlg2 = utilCmd.searchPotentialDgFlg2(bkgBlNoVO,"MND");
			String dgKeyRslArr[] = dgKeyFlg2.split(",");
			
			//해당 키워드에 걸리면 mntr로 인터페이스
			if(!"N".equalsIgnoreCase(dgKeyFlg2)){
				
				//M&D에서 customs description과 description of goods중 어디서 걸린 것인지 판별 
				BkgBlckListMntrVO vo = new BkgBlckListMntrVO();
				vo.setBkgNo(bkgBlNoVO.getBkgNo());
				vo.setBlckKwTpCd("MIS");
				vo.setCreUsrId(account.getUsr_id());
				vo.setUpdUsrId(account.getUsr_id());
				
				//Customs description 혹은 Description of goods에 걸린건지 구분
				//인터페이스는 키워드가 여러개가 걸려도 대표로 마지막에 걸린 키워드 1개만 해준다.(여러 키워드가 걸렸을 때, 컬럼 over length 가능성 때문)
				for(int i=0;i<dgKeyRslArr.length; i++){
					if(dgKeyRslArr[i].startsWith("MND_CSTMS_")){
						vo.setBlckKwNm(dgKeyRslArr[i].replaceAll("MND_CSTMS_", ""));
						vo.setCstmsDescKwNm(dgKeyRslArr[i].replaceAll("MND_CSTMS_", ""));
					}
					if(dgKeyRslArr[i].startsWith("MND_CMDT_")){
						vo.setBlckKwNm(dgKeyRslArr[i].replaceAll("MND_CMDT_", ""));
						vo.setCmdtDescKwNm(dgKeyRslArr[i].replaceAll("MND_CMDT_", ""));
					}
				}
				utilCmd.addBkgBlckListMntr(vo);
				
				TreeSet<String> rmvDup = new TreeSet<String>();
				StringBuffer rsltKeyword = new StringBuffer();
				for(int i=0;i<dgKeyRslArr.length; i++){
					if(dgKeyRslArr[i].startsWith("MND_CSTMS_")){
						dgKeyFlg2 = dgKeyRslArr[i].replaceAll("MND_CSTMS_", "")+",";
					}else{
						dgKeyFlg2 = dgKeyRslArr[i].replaceAll("MND_CMDT_", "")+",";
					}
					rmvDup.add(dgKeyFlg2);
				}
				
				//키워드 중복 제거
				Iterator<String> it = rmvDup.iterator();
				while(it.hasNext()){
					rsltKeyword = rsltKeyword.append(it.next());
				}
				
				eventResponse.setETCData("dg_key_flg2", rsltKeyword.substring(0, rsltKeyword.length()-1));
			}else
				eventResponse.setETCData("dg_key_flg2", dgKeyFlg2);
			
            if(event.getBkgClauseLockVOs()!=null){
				receiptBC.manageBkgClauseLock(event.getBkgClauseLockVOs(), account);
			}
            
            /* Manage Booking History */
            histCmd.manageBookingHistory(uiId, historyTableVO, account);
            
			/* Set Message */
            eventResponse.setUserMessage("");
            
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Not Updated Container 조회한다.(ESM_BKG_0901)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchNotUpdCntr(Event e) throws EventException {
		EsmBkg0901Event event = (EsmBkg0901Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLDocumentationCMBC command = new BLDocumentationCMBCImpl();

		String bkgNo = event.getBkgNo();

		try {
			List<EdiNotUpdCntrVO> list = command.searchNotUpdCntr(bkgNo);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
     * VVD를 통해 Container 리스트 조회(ESM_BKG_0892)<br>
	 *
	 * @author KimYoungchul
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchCntrListByVvd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0892Event event = (EsmBkg0892Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        BLDocumentationCMBC command = new BLDocumentationCMBCImpl();

		String vvd = event.getBkgVvd();
		String ofcCd = event.getBkgOfcCd();
		String pol = event.getBkgPol();
		String pod = event.getBkgPod();
		String cfmYn = event.getCfmFlg();

        try {
            List<CmCopyVO> list = command.searchCntrListByVvd(vvd, ofcCd, pol, pod, cfmYn);

            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }

		return eventResponse;
	}

	/*
	 * private List<BkgComboVO> convertComboList(List<BkgUsrTmpltVO> list){
	 * List<BkgComboVO> comboVOs = new ArrayList<BkgComboVO>(); BkgComboVO
	 * firstVO = new BkgComboVO(); firstVO.setComboCd("word_tmplts");
	 * firstVO.setVal("0"); firstVO.setName("Select Template");
	 * firstVO.setDesc("Select Template"); comboVOs.add(firstVO);
	 * 
	 * int len = list==null ? 0 : list.size(); for(int i=0;i<len;i++){
	 * BkgComboVO tgtVO = new BkgComboVO(); BkgUsrTmpltVO orgVO = list.get(i);
	 * tgtVO.setComboCd("word_tmplts"); tgtVO.setVal(orgVO.getTmpltHdrNm());
	 * tgtVO.setName(orgVO.getTmpltHdrNm());
	 * tgtVO.setDesc(orgVO.getTmpltHdrNm()); comboVOs.add(tgtVO); } return
	 * comboVOs; }
	 */

	/**
	 * 조회 이벤트 처리<br>
	 * 조회조건을 가져오기위한 MultiCombo조회 결과(ESM_BKG_0278)<br>
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchCommonCdListVO(Event e) throws EventException {
		EsmBkg0278Event event = (EsmBkg0278Event) e;
		BookingUtil comboUtil = new BookingUtil();
		BLIssuanceBC command = new BLIssuanceBCImpl();

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			// R/D Term - rcv_term_cd - CD00764
			List<BkgComboVO> rcv_term_cd = comboUtil.searchCombo("CD00764");
			eventResponse.setRsVoList(rcv_term_cd);

			// R/D Term - de_term_cd - CD00765
			List<BkgComboVO> de_term_cd = comboUtil.searchCombo("CD00765");
			eventResponse.setRsVoList(de_term_cd);

			// S.Route(From) - org_sconti_cd - getBkgcombovo
			List<BkgComboVO> org_sconti_cd = command.searchSRouteFromList(event.getBkgcombovo());
			eventResponse.setRsVoList(org_sconti_cd);

			// S.Route(To) - org_sconti_cd - getBkgcombovo
			List<BkgComboVO> desc_sconti_cd = command.searchSRouteFromList(event.getBkgcombovo());
			eventResponse.setRsVoList(desc_sconti_cd);

			// S.Mode(From) - org_svc_mod_cd - CD02149
			List<BkgComboVO> org_svc_mod_cd = comboUtil.searchCombo("CD02149");
			eventResponse.setRsVoList(org_svc_mod_cd);

			// S.Mode(To) - desc_inlnd_svc_mod_cd - CD02149
			List<BkgComboVO> desc_inlnd_svc_mod_cd = comboUtil.searchCombo("CD02149");
			eventResponse.setRsVoList(desc_inlnd_svc_mod_cd);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * O B/L을 group으로 출력하기 위한 대상 list를 조회한다.(ESM_BKG_0278)<br>
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchBkgListForGrpBlPr(Event e) throws EventException {
		EsmBkg0278Event event = null;
		BLIssuanceBC command = null;
		BookingUtil codeUtil = null;
		GrpBlPrtOutVO cVo = null;
		List<GrpBlPrtVO> grpBlPrt = null;
		List<BkgComboVO> codeList = null;
		String[] arrString = null;
		StringBuilder sbSortHeader = null;
		StringBuilder sbQuerySort = null;
		GeneralEventResponse eventResponse = null;
		try {
			event = (EsmBkg0278Event) e;
			command = new BLIssuanceBCImpl();
			codeUtil = new BookingUtil();
			cVo = new GrpBlPrtOutVO();
			eventResponse = new GeneralEventResponse();
			codeList = codeUtil.searchCombo("CD02347");
			arrString = event.getGrpBlPrtInVO().getQuerySort().split("\\|");
			sbSortHeader = new StringBuilder();
			sbQuerySort = new StringBuilder();
			for (String sort : arrString) {
				for (BkgComboVO code : codeList) {
					if (sort.equals(code.getVal())) {
						//sb.append(code.getName().replaceAll("\\p{Punct}|\\p{Space}", "_")).append("|");
						sbSortHeader.append("'").append(code.getName()).append(" : '||").append(getColumnMapping(code.getName())).append("||' / '||");
						sbQuerySort.append(getColumnMapping(code.getName())).append(",");
						break;
					}
				}
			}
			if (0<=sbSortHeader.indexOf("||' / '||")) {
				sbSortHeader.delete(sbSortHeader.length()-9, sbSortHeader.length());
			}
			if (0<=sbQuerySort.indexOf(",")) {
				sbQuerySort.delete(sbQuerySort.length()-1, sbQuerySort.length());
			}
			event.getGrpBlPrtInVO().setSortHeader(sbSortHeader.toString());  //orderby_title
			event.getGrpBlPrtInVO().setQuerySort(sbQuerySort.toString());  //order by
			cVo = command.searchBkgListForGrpBlPr(event.getGrpBlPrtInVO());
			grpBlPrt = cVo.getGrpBlPrts();
			eventResponse.setRsVoList(codeList);
			eventResponse.setRsVoList(grpBlPrt);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * CD02347의 코드로 정렬하기 위해 컬럼을 하드코딩
	 * CD02347의 INTG_CD_VAL_DP_DESC : 쿼리(BLIssuanceDBDAOsearchBkgListForGrpBlPrRSQL)에 사용되는 컬럼 알리아스명
	 * 
     * @param String code
     * @return String
     * @exception Exception
	 */
	private String getColumnMapping(String code) throws Exception {
		String columnName = "";
		List<String[]> listCodeMap = new ArrayList<String[]>(42);
		listCodeMap.add(new String[]{"DATE"             ,"BKG_CRE_DT"    });
		listCodeMap.add(new String[]{"B/OFC"            ,"BKG_OFC_CD"    });
		listCodeMap.add(new String[]{"S/OFC"            ,"OB_SLS_OFC_CD" });
		listCodeMap.add(new String[]{"B/STF"            ,"DOC_USR_ID"    });
		listCodeMap.add(new String[]{"S/REP"            ,"OB_SREP_CD"    });
		listCodeMap.add(new String[]{"B.STS"            ,"BKG_STS_CD"    });
		listCodeMap.add(new String[]{"SHPR"             ,"SHIPPER"       });
		listCodeMap.add(new String[]{"CNEE"             ,"CONSIGNEE"     });
		listCodeMap.add(new String[]{"NTFY"             ,"NTFY"          });
		listCodeMap.add(new String[]{"FFDR"             ,"FFDR"          });

		listCodeMap.add(new String[]{"CMDT"             ,"COMMODITY"     });
		listCodeMap.add(new String[]{"R/TRM"            ,"RCV_TERM_CD"   });
		listCodeMap.add(new String[]{"D/TRM"            ,"DE_TERM_CD"    });
		listCodeMap.add(new String[]{"O.S/M"            ,"ORG_SVC"       });
		listCodeMap.add(new String[]{"D.S/M"            ,"DST_SVC"       });
		listCodeMap.add(new String[]{"O.S/R"            ,"BKG_ORG_ROUTE" });
		listCodeMap.add(new String[]{"D.S/R"            ,"BKG_DST_ROUTE" });
		listCodeMap.add(new String[]{"POR"              ,"POR_CD"        });
		listCodeMap.add(new String[]{"POL"              ,"POL_CD"        });
		listCodeMap.add(new String[]{"POD"              ,"POD_CD"        });

		listCodeMap.add(new String[]{"DEL"              ,"DEL_CD"        });
		listCodeMap.add(new String[]{"P/POL"            ,"SORT_PRE_POL"  });
		listCodeMap.add(new String[]{"P/POD"            ,"SORT_PRE_POD"  });
		listCodeMap.add(new String[]{"S/POL"            ,"SORT_POST_POL" });
		listCodeMap.add(new String[]{"S/POD"            ,"SORT_POST_POD" });
		listCodeMap.add(new String[]{"T.VVD"            ,"TRUNK_VVD"     });
		listCodeMap.add(new String[]{"Pre_V"            ,"SORT_PRE_VVD"  });
		listCodeMap.add(new String[]{"Pst_V"            ,"SORT_POST_VVD" });
		listCodeMap.add(new String[]{"LANE"             ,"BKG_LANE"      });
		listCodeMap.add(new String[]{"T/POL"            ,"TRUNK_POL"     });

		listCodeMap.add(new String[]{"T/POD"            ,"TRUNK_POD"     });
		listCodeMap.add(new String[]{"BLSTF"            ,"OBL_ISS_USR_ID"});
		listCodeMap.add(new String[]{"BLOFC"            ,"OBL_ISS_OFC_CD"});
		listCodeMap.add(new String[]{"C.TP"             ,"BKG_CGO_TP"    });
		listCodeMap.add(new String[]{"B.AGT"            ,"CHINA_AGENT_CD"});
		listCodeMap.add(new String[]{"POR EQ OFC"       ,"POR_EQ_OFC"    });
		listCodeMap.add(new String[]{"DEL EQ OFC"       ,"DEL_EQ_OFC"    });
		listCodeMap.add(new String[]{"SC NO"            ,"SC_NO"         });
		listCodeMap.add(new String[]{"MF-MANIFEST READY","MANIFEST"      });
		listCodeMap.add(new String[]{"FC-RATING"        ,"RATE"          });

		listCodeMap.add(new String[]{"CNEE NAME(by 20c)","CNEE_NAME"     });
		listCodeMap.add(new String[]{"SHPR NAME(by 20c)","SHPR_NAME"     });
		listCodeMap.add(new String[]{"T&E, IE","ENTR_CLSS_TP_CD"     });
		for (String[] arr : listCodeMap) {
			if (code.equals(arr[0])) {
				columnName = arr[1];
				break;
			}
		}
		return columnName;
	}

	/**
     * VVD 및 Container No가 같은 Partial Container Booking중에 Container Confirm 상태가 된 BKG가 있는지 확인한다.(ESM_BKG_0079_04)
     * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchPartialConfirm(Event e) throws EventException {
        EsmBkg007904Event event = (EsmBkg007904Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        BLDocumentationCMBC command = new BLDocumentationCMBCImpl();

        String bkgNo = event.getBkgNo();
        String cntrNo = event.getCntrNo();
        log.debug(">>>>>>Bkg : " + bkgNo);
        log.debug(">>>>>>Cntr: " + cntrNo);
        try {
            String flag = command.searchPartialConfirm(bkgNo, cntrNo);
            
            eventResponse.setETCData("PTL_CFRM_FLG", flag);
            
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
	/**
	 * container 정보를 조회한다.(ESM_BKG_0079_04)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchContainer(Event e) throws EventException {
		EsmBkg007904Event event = (EsmBkg007904Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BookingUtil utilCmd = new BookingUtil();
		BLDocumentationCMBC docCmd = new BLDocumentationCMBCImpl();

		BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
		bkgBlNoIN.setBkgNo(event.getBkgNo());
		bkgBlNoIN.setBlNo(event.getBlNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

		try {
			// searchBkgBlNo
			BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new EventException(new ErrorHandler("BKG01049", new String[] { event.getBkgNo() }).getMessage());
			}
			log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());
            
            /* update on 2009.12.31 */
            String cgoTp = utilCmd.searchBkgCgoTp(bkgBlNoIN);
            if("P".equals(cgoTp)) {
                throw new EventException(new ErrorHandler("BKG00092", new String[]{event.getBkgNo()}).getMessage());
            }
            log.debug("=====> Cgargo Tpye : " + cgoTp);
            
            
			CntrInfoOutVO outVo = docCmd.searchContainer(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getCaFlg());
			// eventResponse.setRsVoList(list);
			CntrEtcInfoVO etcInfoVO = outVo.getCntrEtcInfo();
			List<CntrTpszQtyVO> tpszQtys = outVo.getCntrTpszQtys();
			CntrPkgWgtVO pkgWgts = outVo.getCntrPkgWgts();
			List<ContainerVO> containers = outVo.getCntrs();
			List<BkgCntrSealNoVO> cntrSealNos = outVo.getCntrSealNos();
			List<RataBkgQtyVO> rataBkgQtys = outVo.getRataBkgQtys();
			

			if (etcInfoVO != null && etcInfoVO.getBkgNo() != null) {
				eventResponse.setRsVoList(containers);
				eventResponse.setETCData(pkgWgts.getColumnValues());
                eventResponse.setETCData(etcInfoVO.getColumnValues());
				eventResponse.setETCData("corr_flg", bkgBlNoVO.getCaFlg());
	            eventResponse.setETCData("ca_exist_flg", bkgBlNoVO.getCaExistFlg());
				eventResponse.setETCData("obl_iss_flg", utilCmd.oblIssFlgCheck(bkgBlNoVO.getBkgNo(),bkgBlNoVO.getCaFlg()));
				eventResponse.setRsVoList(tpszQtys);
				eventResponse.setRsVoList(cntrSealNos);
				eventResponse.setRsVoList(rataBkgQtys);
			}
			//vgm code list를 조회
			List<BkgComboVO> vgm_cd = utilCmd.searchCombo("CD03491");
			eventResponse.setRsVoList(vgm_cd);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * container 정보를 관리한다.(ESM_BKG_0079_04)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageContainer(Event e) throws EventException {

		EsmBkg007904Event event = (EsmBkg007904Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLDocumentationCMBC docCmd = new BLDocumentationCMBCImpl();
		BookingUtil utilCmd = new BookingUtil();
		//BDRCorrectionBC correctCmd = new BDRCorrectionBCImpl();
		BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
		BlRatingBC rateCmd = new BlRatingBCImpl();
		ContainerMovementMgtBC ctmCmd = new ContainerMovementMgtBCImpl();
        BkgCopManageBC copCmd = new BkgCopManageBCImpl();
        BLIssuanceBC issuCmd = new BLIssuanceBCImpl();
		GeneralBookingReceiptBC receiptCmd = new GeneralBookingReceiptBCImpl();
		CostAssignBC masCmd  = new CostAssignBCImpl();
		EBookingReceiptBC eBookingReceiptBC = new EBookingReceiptBCImpl();

		// String bkgNo = event.getBkgNo();

		BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
		bkgBlNoIN.setBkgNo(event.getBkgNo());
		bkgBlNoIN.setBlNo(event.getBlNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

		CntrEtcInfoVO cntrEtcInfoVO = event.getBkgEtcInfoVO();
		ContainerVO[] containerVOs = event.getContainerVOs();
		BkgCntrSealNoVO[] bkgCntrSealNoVOs = event.getBkgCntrSealNoVOs();
		CntrAdjVolVO[] cntrAdjVolVOs = event.getCntrAdjVolVOs();
		HistoryTableVO historyTableVO = null;
		CmBkgInfoVO cmBkgInfoVO = event.getCmBkgInfoVO();
        //BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
		boolean usaCstmsDownload = false;
		// Container# 변경시 EDI301 을 전송한다.
		boolean edi301Snd = false;
		
		/* final confirm */
		//String evntDt = cntrEtcInfoVO.getEvntDt();
		String fnlCfmFlg = cntrEtcInfoVO.getFnlCfmFlg();
		String modifyFnlCfmFlg = cntrEtcInfoVO.getModifyFnlCfmFlg();
		String rcvTermCd = cntrEtcInfoVO.getRcvTermCd();

		String uiId = "ESM_BKG_0079_04";

        List<BkgCntrSealNoVO> updateSealVoList = null;
		List<BkgCntrSealNoVO> deleteSealVoList = null;
		List<ContainerVO> insertCntrList = null;
		List<ContainerVO> updateCntrList = null;
		List<ContainerVO> changeCntrList = null;
		List<ContainerVO> deleteCntrList = null;

		List<Map<String,Object>> copCallList = null;
		HistoryLineVO historyLineVO = null;
		ContainerVO containerVO = null;
		BkgDocProcSkdVO bkgDocProcSkdVO = null;
		String fnlCfmTp = null;

		try {
			begin();

			/* searchBkgBlNoVO */
			BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new EventException(new ErrorHandler("BKG01049", new String[]{event.getBkgNo()}).getMessage());
			}
			log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());

			/* Validate Container */
			copCallList = docCmd.validateContainer(cntrEtcInfoVO, containerVOs, fnlCfmFlg);
			if (null!=copCallList && 0<copCallList.size()) {
				for (Map<String,Object> map : copCallList) {
					containerVO = (ContainerVO)map.get("containerVO");
					historyLineVO = new HistoryLineVO();
					historyLineVO.setBkgNo((String)map.get("bkgNo"));
					historyLineVO.setCaFlg((String)map.get("caFlg"));
					historyLineVO.setCrntCtnt("Detach Container : "+(String)map.get("cntrNo"));
					historyLineVO.setHisCateNm("Container No.");
					historyLineVO.setLocalTime("");
					historyLineVO.setPreCtnt(" ");
					historyLineVO.setUiId(uiId);
					histCmd.createBkgHistoryLine(historyLineVO, account);

					bkgDocProcSkdVO = new BkgDocProcSkdVO();
					bkgDocProcSkdVO.setBkgNo((String)map.get("bkgNo"));
					bkgDocProcSkdVO.setBkgDocProcTpCd("CNTCFM");
					bkgDocProcSkdVO.setDocPerfDeltFlg("N");
					if (null!=utilCmd.searchDocProcSkd(bkgDocProcSkdVO,(String)map.get("caFlg"))) {
						this.cancelContainerConfirm((String)map.get("bkgNo"), null);
					}
					//cop호출
					copCmd.detachCntr((String)map.get("bkgNo"), (String)map.get("cntrNo"), (String)map.get("cntrPrtFlg"));
				}
			}

            /* Search Booking History */
            historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoVO);
            
			/* Change Screen Flag */
			//if ("Y".equals(bkgBlNoVO.getCaFlg())) {
				//correctCmd.modifyCngScreenFlag(uiId, bkgBlNoVO);  //사용않함으로 변경됨.
			//}
			
			/* SealNo */
			int sealLen = bkgCntrSealNoVOs == null ? 0 : bkgCntrSealNoVOs.length;
			int idx1=0, idx2=0, idx3=0, idx4=0;
			for (int i = 0; i < sealLen; i++) {
				if ("D".equals(bkgCntrSealNoVOs[i].getIbflag())) {
					idx1++;
				} else if ("I".equals(bkgCntrSealNoVOs[i].getIbflag()) || "U".equals(bkgCntrSealNoVOs[i].getIbflag())) {
					idx2++;
				}
			}
            updateSealVoList = new ArrayList<BkgCntrSealNoVO>(idx1);
			deleteSealVoList = new ArrayList<BkgCntrSealNoVO>(idx2);
			for (int i = 0; i < sealLen; i++) {
                log.debug("*** CntrSealNoVO - " + bkgCntrSealNoVOs[i].getIbflag() + " : " + bkgCntrSealNoVOs[i].getBkgNo() + " : " + bkgCntrSealNoVOs[i].getCntrNo());
				String ibflag = bkgCntrSealNoVOs[i].getIbflag();
				bkgCntrSealNoVOs[i].setCreUsrId(account.getUsr_id());
				bkgCntrSealNoVOs[i].setUpdUsrId(account.getUsr_id());
				if ("D".equals(ibflag)) {
					deleteSealVoList.add(bkgCntrSealNoVOs[i]);
				} else if ("I".equals(ibflag) || "U".equals(ibflag)) {
					updateSealVoList.add(bkgCntrSealNoVOs[i]);
				}
			}

			/* Container */
			int cntrLen = containerVOs == null ? 0 : containerVOs.length;
			for (int i = 0; i < cntrLen; i++) {
				if ("I".equals(containerVOs[i].getIbflag())) {
					idx1++;
				} else if ("U".equals(containerVOs[i].getIbflag())) {
					if (containerVOs[i].getCntrNoOld() == null || containerVOs[i].getCntrNoOld().equals("") || containerVOs[i].getCntrNoOld().equals(containerVOs[i].getCntrNo())) {
						idx2++;
					} else {
						idx3++;
					}
				} else if ("D".equals(containerVOs[i].getIbflag())) {
					idx4++;
				}
			}
			insertCntrList = new ArrayList<ContainerVO>(idx1);
			updateCntrList = new ArrayList<ContainerVO>(idx2);
			changeCntrList = new ArrayList<ContainerVO>(idx3);
			deleteCntrList = new ArrayList<ContainerVO>(idx4);
			for (int i = 0; i < cntrLen; i++) {
                log.debug("*** ContainerVO - " + containerVOs[i].getIbflag() + " : " + containerVOs[i].getCntrNo() + " : " + containerVOs[i].getCntrNoOld());
				// ContainerVO containerVO = containerVOs[i];
				String ibflag = containerVOs[i].getIbflag();
				containerVOs[i].setCreUsrId(account.getUsr_id());
				containerVOs[i].setUpdUsrId(account.getUsr_id());
				if ("I".equals(ibflag)) {
					insertCntrList.add(containerVOs[i]);
					edi301Snd = true;
				} else if ("U".equals(ibflag)) {
					if (containerVOs[i].getCntrNoOld() == null || containerVOs[i].getCntrNoOld().equals("") || containerVOs[i].getCntrNoOld().equals(containerVOs[i].getCntrNo())) {
						updateCntrList.add(containerVOs[i]);
					} else {
						changeCntrList.add(containerVOs[i]);
						edi301Snd = true;	
					}
				} else if ("D".equals(ibflag)) {
					deleteCntrList.add(containerVOs[i]);
					edi301Snd = true;
				}
			    /* COP 호출 문제로 BKG_FUNC_PROC_LOG_PRC 삽입 */
				if("DHA045".equals(account.getUsr_id())){
					utilCmd.addBkgLog("BKG_COP_ATTACH3", containerVOs[i].getBkgNo(),containerVOs[i].getCntrNo()+"-"+ containerVOs[i].getIbflag());
				}
			}
			
            /* Adjust Container Volumn */
			int adjLen = cntrAdjVolVOs == null ? 0 : cntrAdjVolVOs.length;
			for(int i=0;i<adjLen;i++){
			    log.debug("*** CntrAdjVolVO - " + cntrAdjVolVOs[i].getCntrNo() + " : " + cntrAdjVolVOs[i].getAdjVolQty());
                if("0".equals(cntrAdjVolVOs[i].getAdjVolQty())){
                    ContainerVO cntrVO = new ContainerVO();
                    cntrVO.setBkgNo(cntrAdjVolVOs[i].getBkgNo());
                    cntrVO.setCntrNo(cntrAdjVolVOs[i].getCntrNo());
                    //
                    deleteCntrList.add(cntrVO);
                }else {
                    //updateAdjVoList.add(cntrAdjVolVOs[i]);
                    BkgBlNoVO bkgNoVO = new BkgBlNoVO();
                    bkgNoVO.setBkgNo(cntrAdjVolVOs[i].getBkgNo());
                    
                    // Adjust Container Volumn
                    docCmd.modifyCntrVol(cntrAdjVolVOs[i], bkgBlNoVO.getCaFlg());
                    
                    //
                    BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
                    docProcSkdVO.setBkgDocProcTpCd("Y".equals(fnlCfmFlg) ? "CNTCFM" : "CNTRLS");
                    docProcSkdVO.setBkgNo(cntrAdjVolVOs[i].getBkgNo());
                    histCmd.manageDocProcess(docProcSkdVO, account);
                    
                    //histCmd.manageBookingHistory(uiId, oldHistoryTableVO, account);
                }
			}
            
			/* SealNo Delete */
			if (deleteSealVoList.size() > 0) {
				docCmd.removeCntrSealNo(deleteSealVoList, bkgBlNoVO.getCaFlg());
			}
			
			
			
			/* Container Delete */
			for (int i = 0; i < deleteCntrList.size(); i++) {
				containerVO = deleteCntrList.get(i);
				// 1. remove SealNo
				log.debug(">>>>>>removeCntrSealNo: " + containerVO.getBkgNo() + " - " + containerVO.getCntrNo());
				docCmd.removeCntrSealNo(containerVO.getBkgNo(), containerVO.getCntrNo(), "", bkgBlNoVO.getCaFlg());
				// 2. remove Rate
				log.debug(">>>>>>removeCntrRate: " + containerVO.getBkgNo() + " - " + containerVO.getCntrNo());
				rateCmd.removeCntrRateByCntr(containerVO.getBkgNo(), containerVO.getCntrNo(), "");
				// 3. remove Reference detail
				log.debug(">>>>>>removeReferenceDetailByCntr: " + containerVO.getBkgNo() + " - " + containerVO.getCntrNo());
				receiptCmd.removeReferenceDetailByCntr(containerVO.getBkgNo(), containerVO.getCntrNo(), bkgBlNoVO.getCaFlg());
				// 4. remove Reference
				log.debug(">>>>>>removeReferenceByCntr: " + containerVO.getBkgNo() + " - " + containerVO.getCntrNo());
				receiptCmd.removeReferenceByCntr(containerVO.getBkgNo(), containerVO.getCntrNo(), bkgBlNoVO.getCaFlg());
				// 5. remove Manifest
				log.debug(">>>>>>removeCntrMfDesc: " + containerVO.getBkgNo() + " - " + containerVO.getCntrNo());
				docCmd.removeCntrMfDesc(containerVO.getBkgNo(), containerVO.getCntrNo(), bkgBlNoVO.getCaFlg());
				// 6. remove Container
				log.debug(">>>>>>removeCntr: " + containerVO.getBkgNo() + " - " + containerVO.getCntrNo());
				docCmd.removeContainer(containerVO.getBkgNo(), containerVO.getCntrNo(), bkgBlNoVO.getCaFlg());

                // usaCstmsDownload
                if(!usaCstmsDownload){
                    usaCstmsDownload = utilCmd.searchUsaCstmsDownload(bkgBlNoVO);
                }
                				
			}
	         
            /* Container Insert */
            if(insertCntrList.size() > 0){
                docCmd.manageContainer(insertCntrList, bkgBlNoVO.getCaFlg());

                // usaCstmsDownload
                if(!usaCstmsDownload){
                    usaCstmsDownload = utilCmd.searchUsaCstmsDownload(bkgBlNoVO);
                }
             
            }
            
			/* Container Update */
			if(updateCntrList.size() > 0){
			    docCmd.manageContainer(updateCntrList, bkgBlNoVO.getCaFlg());
			}
			
			/* Update C/M by container wgt./meas. unit */
            String bkgWgtUtCd  = cntrEtcInfoVO.getBkgWgtUtCd();
            String bkgMeasUtCd = cntrEtcInfoVO.getBkgMeasUtCd();
            log.debug("$ bkgWgtUtCd  : " + bkgWgtUtCd);
            log.debug("$ bkgMeasUtCd : " + bkgMeasUtCd);
            docCmd.modiftyCmUnitByCntr(bkgBlNoVO.getBkgNo(), bkgWgtUtCd, bkgMeasUtCd, account, bkgBlNoVO.getCaFlg());
            
			
			/* FNL_CFM_FLG 가 'Y'이고, RVC_TERM_CD 가 'S'일 때 */
            log.debug(">>>>>>modifyBlByFinalCfm: fnlCfmFlg=" + fnlCfmFlg + ", rcvTermCd=" + rcvTermCd);
			if("Y".equals(fnlCfmFlg) && !"S".equals(rcvTermCd)) {
			    String blIssFlg = docCmd.searchBlIssFlg(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getCaFlg());
			    /* OBL_ISS_FLG 가 'Y'아닐 때 */
			    log.debug(">>>>>>modifyBlByFinalCfm: blIssFlg=" + blIssFlg);
			    if(!"Y".equals(blIssFlg)){
	                docCmd.modifyBlByFinalCfm(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getCaFlg());
			    }
            }
			
			/* Container No. Changed */
			for (int i = 0; i < changeCntrList.size(); i++) {
				containerVO = changeCntrList.get(i);
				String cntrNo = containerVO.getCntrNo();
				String cntrNoOld = containerVO.getCntrNoOld();
				// 1. insert Container
				log.debug(">>>>>>insertCntr: " + bkgBlNoVO.getBkgNo() + " - " + cntrNo);
				log.debug(">>>>>>" + containerVO.getUpdUsrId());
				docCmd.insertContainer(containerVO, bkgBlNoVO.getCaFlg());
				// 2. change Reference Detail
				log.debug(">>>>>>changeReferenceDetailByCntr: " + cntrNo + " - " + cntrNoOld);
				receiptCmd.changeReferenceDetailByCntr(bkgBlNoVO.getBkgNo(), cntrNo, cntrNoOld, bkgBlNoVO.getCaFlg());
				// 3. change Reference
				log.debug(">>>>>>changeReferenceByCntr: " + cntrNo + " - " + cntrNoOld);
				receiptCmd.changeReferenceByCntr(bkgBlNoVO.getBkgNo(), cntrNo, cntrNoOld, bkgBlNoVO.getCaFlg());
				// 4. change Manifest
				log.debug(">>>>>>changeCntrMfDesc: " + cntrNo + " - " + cntrNoOld);
				docCmd.changeCntrMfDesc(bkgBlNoVO.getBkgNo(), cntrNo, cntrNoOld, bkgBlNoVO.getCaFlg());
							
				log.debug(">>>>>>changeCntrSealNo: " + cntrNo + " - " + cntrNoOld);
				docCmd.changeCntrSealNo(bkgBlNoVO.getBkgNo(), cntrNo, cntrNoOld, bkgBlNoVO.getCaFlg());
			
				// 5. change Rate
				log.debug(">>>>>>changeCntrRate: " + cntrNo + " - " + cntrNoOld);
				rateCmd.changeCntrRate(bkgBlNoVO.getBkgNo(), cntrNo, cntrNoOld);
				// 6. delete Container(Old)
				log.debug(">>>>>>removeCntr: " + cntrNo + " - " + cntrNoOld);
				log.debug(">>>>>>" + containerVO.getUpdUsrId());
				docCmd.removeContainer(bkgBlNoVO.getBkgNo(), cntrNoOld, bkgBlNoVO.getCaFlg());				

                // usaCstmsDownload
                if(!usaCstmsDownload){
                    usaCstmsDownload = utilCmd.searchUsaCstmsDownload(bkgBlNoVO);
                }
                
			}
			
			/* SealNo Merge */
			if (updateSealVoList.size() > 0) {
				docCmd.manageCntrSealNo(updateSealVoList, bkgBlNoVO.getCaFlg());
			}
			
			/* validate confrim */
			docCmd.validateContainerConfirm(cntrEtcInfoVO, containerVOs, fnlCfmFlg);

			/* Manage Credit Date */
			rateCmd.manageCrdDt(bkgBlNoVO.getBkgNo(), cntrEtcInfoVO.getCgoRcvDt(), bkgBlNoVO.getCaFlg());

        	// Cntr Mvmt OC History - start
			CusCtmMovementVO cusCtmMovementVO = null;
			for (int i=0; i<cntrLen; i++) {
				if ("Y".equalsIgnoreCase(containerVOs[i].getCgoRcvDtFlg())) {
					cusCtmMovementVO = new CusCtmMovementVO();
					cusCtmMovementVO.setBkgNo(containerVOs[i].getBkgNo());
					cusCtmMovementVO.setCntrNo(containerVOs[i].getCntrNo());
					cusCtmMovementVO.setMvmtStsCd(containerVOs[i].getCnmvStsCd());
					cusCtmMovementVO.setCreUsrId(account.getUsr_id());
					cusCtmMovementVO.setUpdUsrId(account.getUsr_id());
					cusCtmMovementVO.setCnmvEvntDt(containerVOs[i].getCgoRcvDt());
					docCmd.addCntrMvmtOcHistory(cusCtmMovementVO, "M");
				}
			}
			// Cntr Mvmt OC History - end

			if ("N".equals(bkgBlNoVO.getCaFlg())) {
			    /* Interface TO SCE */
                log.debug("########## Cntr Detach ##########");
				for (int i = 0; i < deleteCntrList.size(); i++) {
				    // cop
                    //try{
				        String flgPartial = ("1".equals(deleteCntrList.get(i).getCntrPrtFlg())? "Y" : "N");   
                        copCmd.detachCntr(deleteCntrList.get(i).getBkgNo(), deleteCntrList.get(i).getCntrNo(), flgPartial);
                    //}catch(Exception ex){
                    //    log.error(ex.getMessage(), ex);
                    //}                        
				}
                log.debug("########## Cntr Attach ##########");
				for (int i = 0; i < insertCntrList.size(); i++) {
				    // ctm
				    ctmCmd.updateCtmMvmtIrrFromBkg(insertCntrList.get(i).getCntrNo(), insertCntrList.get(i).getBkgNo());
				    // cop
				    //try{
                        String flgPartial = ("1".equals(insertCntrList.get(i).getCntrPrtFlg())? "Y" : "N");				    
				        copCmd.attachCntr(insertCntrList.get(i).getBkgNo(), insertCntrList.get(i).getCntrNo(), flgPartial);
				    //}catch(Exception ex){
				    //    log.error(ex.getMessage(), ex);
				    //} 
				}
				log.debug("########## Cntr Change ##########");
				for (int i = 0; i < changeCntrList.size(); i++) {
                    // ctm
                    ctmCmd.updateCtmMvmtIrrFromBkg(changeCntrList.get(i).getCntrNo(), changeCntrList.get(i).getBkgNo());
                    // cop
                    //try{
                        String flgPartial = ("1".equals(changeCntrList.get(i).getCntrPrtFlg())? "Y" : "N");  
                        copCmd.attachCntr(changeCntrList.get(i).getBkgNo(), changeCntrList.get(i).getCntrNo(), flgPartial);
                        // cop
                        copCmd.detachCntr(changeCntrList.get(i).getBkgNo(), changeCntrList.get(i).getCntrNoOld(), flgPartial);
                    //}catch(Exception ex){
                    //    log.error(ex.getMessage(), ex);
                    //}               
				}
                
				/* MAS */
                MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
                masBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
                masBkgComIfVo.setCostSrcSysCd("BKG");
                masBkgComIfVo.setIfRmk("Cntr Attach");
                masBkgComIfVo.setCreUsrId(account.getUsr_id());
                masBkgComIfVo.setUpdUsrId(account.getUsr_id());
                masCmd.modifyMasCommonInterface(masBkgComIfVo);
                
                /* bkg_no별 container NO, Type 생성.
                 * - updated on 2010.01.18 */
                PerformanceReportBC formanceCmd = new PerformanceReportBCImpl();
                formanceCmd.manageQtyCntrCoposite(bkgBlNoVO.getBkgNo(), "CN"); 

                /* Manage Doc Process */
                if ("Y".equals(modifyFnlCfmFlg)){
                    
                    //createDraftBlEdi
                    log.debug("########## Create Draft B/L EDI ##########");
//                    try {
//                        //issuCmd.createDraftBlEdi(dblEdiInVOs, account);
//                      DblEdiInVO dblEdiInVO = new DblEdiInVO();
//                      dblEdiInVO.setBkgNo(bkgBlNoVO.getBkgNo());
//                      dblEdiInVO.setEdiReceiveId("KTNETPCS");
//                      
//                      DblEdiInVO[] dblEdiInVOs = new DblEdiInVO[1];
//                      dblEdiInVOs[0] = dblEdiInVO;
//
//                      BackEndJobManager backEndJobManager = new BackEndJobManager(); 
//                      BLIssuanceDraftBlEdiBEImpl command = new BLIssuanceDraftBlEdiBEImpl();
//                      command.setDblEdiInVOs(dblEdiInVOs);
//                      command.setAccount(account);
//                     
//                      backEndJobManager.execute(command, account.getUsr_id(), "Create Draft B/L via EDI"); 
//                      log.debug("-> backend_job_key : OK");
//                    } catch(Exception ex) {
//                        log.error("issuCmd.createDraftBlEdi(dblEdiInVOs, account)", ex);
//                    }                   
                    
//                    log.debug("\n\n\n\n\n"+cntrEtcInfoVO.getPolCd().substring(0, 2)+"\n\n\n\n\n\n"+cntrEtcInfoVO.getPolCd().startsWith("KR", 0));
                    if ("Y".equals(fnlCfmFlg) && "KR".equals(cntrEtcInfoVO.getPolCd().substring(0, 2))) {                    	
	                    DblEdiInVO dblEdiInVO = new DblEdiInVO();                   
//	                    BLIssuanceBC issueCmd = new BLIssuanceBCImpl();                    
	                    List<BkgNtcHisVO> bkgNtcHisVOs = null;
	
						dblEdiInVO.setBkgNo(bkgBlNoVO.getBkgNo());
						dblEdiInVO.setEdiReceiveId("KTNETPCS");
	//					dblEdiInVO.setGroupEdiId(custTpVO2.getGroupId());
						DblEdiVO dblEdiVo=issuCmd.createDraftBlEdi(dblEdiInVO, account);
						bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>(dblEdiVo.getFlatFileAckVOs().size());	
						
						// History
						for(int j=0;j<dblEdiVo.getFlatFileAckVOs().size();j++){
							BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
							bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
							bkgNtcHisVO.setHisSeq(String.valueOf(j+1).toString());
							bkgNtcHisVO.setNtcViaCd("E");
							bkgNtcHisVO.setNtcKndCd("BL");
							bkgNtcHisVO.setEdiId("KTNETPCS");
	//						bkgNtcHisVO.setEsvcGrpCd(custTpVO2.getGroupId());
							bkgNtcHisVO.setBkgNtcSndRsltCd(dblEdiVo.getFlatFileAckVOs().get(j).getAckStsCd());
							bkgNtcHisVO.setFltFileRefNo(dblEdiVo.getFlatFileAckVOs().get(j).getFltFileRefNo());
							bkgNtcHisVO.setSndUsrId(account.getUsr_id());
							bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
							bkgNtcHisVO.setSndRqstDt(DateTime.getShortDateString());
							bkgNtcHisVO.setCreUsrId(account.getUsr_id());
							bkgNtcHisVO.setUpdUsrId(account.getUsr_id());									
							bkgNtcHisVOs.add(bkgNtcHisVO);
						}
						
						if(bkgNtcHisVOs!=null){
							if(bkgNtcHisVOs.size()>0){
								histCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
							}
						}
                    }
                    
                    
                    //confirmCntr
                    log.debug("########## Confirm Container ##########");
//                    try {
                          copCmd.confirmCntr(bkgBlNoVO.getBkgNo());
//                    } catch(Exception ex) {
//                        log.error("copMgt.confirmCntr(bkgBlNoVO.getBkgNo())", ex);
//                    }
                } // IF : "Y".equals(modifyFnlCfmFlg)
				
			} // IF : "N".equals(bkgBlNoVO.getCaFlg())

			if ("Y".equals(modifyFnlCfmFlg)){
                
				// HistoryLine
				log.debug("########## History Line ##########");
				fnlCfmTp = "Y".equals(fnlCfmFlg) ? "Container Final Confirm" : "Cancel Container Final Confirm";

				historyLineVO = new HistoryLineVO();
//				historyLineVO.setBkgDocProcTpCd("Y".equals(fnlCfmFlg) ? "CNTCFM" : "CNTRLS");
				historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
				historyLineVO.setCaFlg(bkgBlNoVO.getCaFlg());
				historyLineVO.setCrntCtnt(account.getUsr_id() + "/" + fnlCfmTp);
				historyLineVO.setPreCtnt(" ");
				historyLineVO.setHisCateNm("F.CFM");
				historyLineVO.setLocalTime("");
				historyLineVO.setUiId(uiId);
				histCmd.createBkgHistoryLine(historyLineVO, account);

                // manageDocProcess
                log.debug("########## Manage Doc Process ##########");
                BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
                docProcSkdVO.setBkgDocProcTpCd("Y".equals(fnlCfmFlg) ? "CNTCFM" : "CNTRLS");
                docProcSkdVO.setBkgNo(bkgBlNoVO.getBkgNo());
                histCmd.manageDocProcess(docProcSkdVO, account);    
			}
	         
            /* Distribute Contaner Charge */
            if(!"X".equals(bkgBlNoVO.getBkgStsCd()) && !"Y".equals(bkgBlNoVO.getCaFlg())) {
                rateCmd.distributeCntrRate(bkgBlNoVO.getBkgNo(), account);         
            }
            
            // bkg bl doc 테이블에 업데이트
            if("N".equals(cmBkgInfoVO.getEurFlg())){
            	docCmd.modifyBlByCntrInfo(cmBkgInfoVO);
            }
            
            /* Manage Booking History */
            histCmd.manageBookingHistory(uiId, historyTableVO, account);
            
            
            //310자동전송
            if (!"Y".equals(bkgBlNoVO.getCaFlg())) {
            	log.debug("\n======= Auto EDI Send ======\n");
            	List<BkgNtcHisVO> bkgNtcHisVOs = issuCmd.createDraftBlEdiAuto(bkgBlNoVO.getBkgNo(), "N",  account);

				if (bkgNtcHisVOs != null) {
					if (bkgNtcHisVOs.size() > 0) {
						histCmd.createBkgNtcHis(bkgNtcHisVOs,"ESM_BKG_0095");
						
						//philips 계약인 BKG에 대해서 DBL전송
						String philips = issuCmd.searchPhilipsCheck(bkgBlNoVO.getBkgNo());
						
		    			//philips 계약인 BKG에 대해서 DBL전송
		    			if(null!=philips && !"".equals(philips)){
		    				List<BkgNtcHisVO> bkgHisVOs = null;
		    				StringBuilder sbParam = new StringBuilder();
		    				
		    				String draftRemark = issuCmd.searchDraftRemark(bkgBlNoVO.getBkgNo());

		                	
		            		sbParam.append("/rv");
		            		sbParam.append(" form_bkgNo[('").append(bkgBlNoVO.getBkgNo()).append("')]");
		            		sbParam.append(" form_type[").append("2").append("]");
		            		sbParam.append(" form_dataOnly[N]");
		            		sbParam.append(" form_manifest[N]");
		            		sbParam.append(" form_usrId[").append(account.getUsr_id()).append("]");
		            		sbParam.append(" form_hiddeData[N]");
		            		sbParam.append(" form_level[(").append(1).append(")]");
		            		sbParam.append(" form_remark[").append(draftRemark).append("]");
		            		sbParam.append(" form_Cntr[1]");
		            		sbParam.append(" form_mainOnly[N]");
		            		sbParam.append(" form_CorrNo[]");
		            		sbParam.append(" form_his_cntr[BKG_CONTAINER]");
		            		sbParam.append(" form_his_bkg[BKG_BOOKING]");
		            		sbParam.append(" form_his_mkd[BKG_BL_MK_DESC]"); 
		            		sbParam.append(" form_his_xpt[BKG_XPT_IMP_LIC]");
		            		sbParam.append(" form_his_bl[BKG_BL_DOC]");
		            		sbParam.append(" /rp []");
		            		sbParam.append(" /riprnmargin");
		            		
		    				
		    				DblWblVO[] dblWblVOs = new DblWblVO[1];
		    				dblWblVOs[0] = new DblWblVO();
		    				dblWblVOs[0].setBkgNo(bkgBlNoVO.getBkgNo());
		    				dblWblVOs[0].setBlNo(bkgBlNoVO.getBlNo());
		    				dblWblVOs[0].setSyscd("BKG");
		    				dblWblVOs[0].setTmplmrd("ESM_BKG_0109_DBL.mrd");
		    				dblWblVOs[0].setBatchflg("N");
		    				dblWblVOs[0].setTmplparam(sbParam.toString());
		    				dblWblVOs[0].setRcveml(philips);
		    				dblWblVOs[0].setTmplmrdpdf("SMLM"+bkgBlNoVO.getBkgNo()+".pdf");
		    				dblWblVOs[0].setItr("|$$|");
		    				dblWblVOs[0].setNtcKndCd("BL");
		    				dblWblVOs[0].setHiddOpt("N");
		    				dblWblVOs[0].setFrtAllFlg("Y");
		    				dblWblVOs[0].setFrtCltFlg("N");
		    				dblWblVOs[0].setFrtPpdFlg("N");
		    				dblWblVOs[0].setFrtChgFlg("N");
		                    dblWblVOs[0].setFrtArrFlg("N");
		                    
		                    //DPCS가 아니더라도 sender email주소 front office로
		                    dblWblVOs[0].setFntEmlFlg("Y");
		                    bkgHisVOs = issuCmd.sendDblWblByEmail(dblWblVOs, null, account);
		    				if(bkgHisVOs.size()>0){
		    					histCmd.createBkgNtcHis(bkgHisVOs,"ESM_BKG_0095");
		    				}

		    			}
					}
				}	
			}

         // sms 전송로직 추가 .jsy ,manageContainer --s---------
            GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
            BlRatingBC command 		= new BlRatingBCImpl();
            BkgBookingInfoVO bkgBookingInfoVO = command.searchBkgBookingInfo(bkgBlNoVO);
            GeneralBookingSearchBC  searchBC 	= new GeneralBookingSearchBCImpl();
            List<VslSkdVO> vslSkdVOs = receiptBC.searchVvdSkdForTsRoute(bkgBlNoVO);
			String newFirstVvd = "";
			String oldFirstVvd = "";
			String slancd = "";
			if(vslSkdVOs != null && vslSkdVOs.size()>0){
				newFirstVvd =  vslSkdVOs.get(0).getBkgVvdCd();
				oldFirstVvd = newFirstVvd;
				slancd =  vslSkdVOs.get(0).getSlanCd();
			}
//			if( historyTableVO != null  ) {
//				oldFirstVvd = historyTableVO.getBkgVvdVOs().get(0).getVslCd()
//				+historyTableVO.getBkgVvdVOs().get(0).getSkdVoyNo()
//				+historyTableVO.getBkgVvdVOs().get(0).getSkdDirCd();
//				slancd =  vslSkdVOs.get(0).getSlanCd();
//			}
			log.debug("\nsms call:SEL?" + bkgBlNoVO.getBkgNo().substring(0, 3)+"\n"+
//					     "new pod:"+bkgBookingInfoVO.getBkgPodCd() +"\n"+
//					     "old pod:"+ historyTableVO.getBkgBookingVO().getPodCd()+"\n"+
					     "cnt: "+receiptBC.chkSmsRequirementVvdChanged(bkgBookingInfoVO.getBkgNo(), oldFirstVvd, newFirstVvd, bkgBookingInfoVO.getBkgPolCd(), "" )
					    	);
			List<SmsRequirementResultVO> smsReqList = receiptBC.getSmsRequirementResult(bkgBookingInfoVO.getBkgNo(), oldFirstVvd, newFirstVvd, bkgBookingInfoVO.getBkgPolCd(), "");
			String bkgInfoPolYdCd ="";
			boolean bFinalCllPolYdChk = false;
			bkgInfoPolYdCd = bkgBookingInfoVO.getBkgPolYdCd()==null? "":bkgBookingInfoVO.getBkgPolYdCd();
			
			bkgInfoPolYdCd = bkgInfoPolYdCd.length() ==7 ? bkgInfoPolYdCd : bkgBookingInfoVO.getBkgPolCd()+bkgInfoPolYdCd;  
			
			for (int i = 0; i < smsReqList.size(); i++) {

				if( bkgInfoPolYdCd.equals(smsReqList.get(i).getPolYd() ) ) {
					bFinalCllPolYdChk = true;
				}
			}
			

			//SMS 전송 조건을 만족하면..
			if( "SEL".equals(bkgBlNoVO.getBkgNo().substring(0, 3) ) 
				&& receiptBC.chkSmsRequirementVvdChanged(bkgBookingInfoVO.getBkgNo(), oldFirstVvd, newFirstVvd, bkgBookingInfoVO.getBkgPolCd(), "" ) 
				&& bFinalCllPolYdChk
				&& !"Y".equals(bkgBlNoVO.getCaFlg())) {
				
				
				String vgmChgFlg = "N";
				String vgmChgCntrList = "";
				//VGM변경된 CNTR있는지 확인 및 list출력
				if(historyTableVO != null && historyTableVO.getBkgContainerVOs() != null &&  historyTableVO.getBkgContainerVOs().size() > 0){
					vgmChgCntrList = docCmd.searchVgmChgHis(historyTableVO.getBkgContainerVOs());
					if(vgmChgCntrList.length()>0){
						vgmChgFlg = "Y";
						vgmChgCntrList = vgmChgCntrList.substring(0, vgmChgCntrList.toString().lastIndexOf(","));
					}
				}
				
				//보낼 대상 조회.
				List<BkgUserSmsListVO> smsList = null;
				// sms 전송 
				String skdDirCd = newFirstVvd.substring(8,9);
				String bkgNo = bkgBookingInfoVO.getBkgNo();
				String sndMsg ="";
				String sndParam = "";
				String iCntr = "";
				StringBuilder iCntrStr = new StringBuilder();
				StringBuilder dCntrStr = new StringBuilder();
				String dCntr = "";				
//				ContainerVO cntrVo = null;
				int totLen = (insertCntrList == null ? 0 : insertCntrList.size()) + (deleteCntrList == null ? 0 : deleteCntrList.size())+(changeCntrList == null ? 0 : changeCntrList.size());
				if(totLen > 0 || "Y".equals(vgmChgFlg)){
					//insertCntrList,deleteCntrList cntr list를 추출
					int len = insertCntrList == null ? 0 : insertCntrList.size();
					if(len>0){
			            for (int i = 0; i < len; i++) {
//			            	iCntr = iCntr + "'" + insertCntrList.get(i).getCntrNo() + "',";
			            	iCntrStr.append("'").append(insertCntrList.get(i).getCntrNo()).append("',");
			            }
			            if(changeCntrList.size() ==0){
//			            	iCntr = iCntr.substring(0, iCntr.lastIndexOf(","));
			            	iCntr = iCntrStr.toString().substring(0, iCntrStr.toString().lastIndexOf(","));
			            }			            
			            log.debug(iCntr);
					}
					
		            len = deleteCntrList == null ? 0 : deleteCntrList.size();
					if(len>0){
			            for (int i = 0; i < len; i++) {
//			            	dCntr = dCntr + "'" + deleteCntrList.get(i).getCntrNo() + "',";
			            	dCntrStr.append("'").append(deleteCntrList.get(i).getCntrNo()).append("',");
			            }
			            if(changeCntrList.size() ==0){
//			            	dCntr = dCntr.substring(0, dCntr.lastIndexOf(","));
			            	dCntr = dCntrStr.toString().substring(0, dCntrStr.toString().lastIndexOf(","));
			            }
			            	
					}
					
					len = changeCntrList == null ? 0 : changeCntrList.size();
					if(len>0){
			            for (int i = 0; i < len; i++) {
//			            	iCntr = iCntr + "'" + changeCntrList.get(i).getCntrNo() + "',";
			            	iCntrStr.append("'").append(changeCntrList.get(i).getCntrNo()).append("',");
//			            	dCntr = dCntr + "'" + changeCntrList.get(i).getCntrNoOld() + "',";
			            	dCntrStr.append("'").append(changeCntrList.get(i).getCntrNoOld()).append("',");
			            }
//			            iCntr = iCntr.substring(0, iCntr.lastIndexOf(","));
//			            dCntr = dCntr.substring(0, dCntr.lastIndexOf(","));
			            iCntr = iCntrStr.toString().substring(0, iCntrStr.toString().lastIndexOf(","));
			            dCntr = dCntrStr.toString().substring(0, dCntrStr.toString().lastIndexOf(","));
					}
					
					//메일 보낼 대상 조회
	                smsList = receiptBC.getPhnId(slancd, bkgBookingInfoVO.getBkgOfcCd(), skdDirCd, bkgBookingInfoVO.getBkgPolCd(), bkgBookingInfoVO.getBkgNo());
	                //전송 메세지.
	                sndMsg = "\n\n" + newFirstVvd+" "+ bkgNo+ " ";
	                if("Y".equalsIgnoreCase(bkgBookingInfoVO.getDcgoFlg())){
	                	sndMsg = sndMsg +"(DG Cargo 선적) ";
	                }
	                
	                if("Y".equals(vgmChgFlg)){
	                	sndMsg = sndMsg +"(VGM 변경) ";
	                }	 
	                
	                sndMsg = sndMsg +" 선적 변경 발생 " ;
	                
					sndParam = "/rv gubun[CID] vvd["+newFirstVvd+"] old_vvd["+oldFirstVvd+"] pol_cd["+bkgBookingInfoVO.getBkgPolCd()+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i["+iCntr+"] cntr_d["+dCntr+"] cntr_set["+vgmChgCntrList+"]";
					log.debug("sndParam"+sndParam);
					List<BkgNtcHisVO> bkgNtcHisVOs = searchBC.sendMailSmsByPodChange(smsList, bkgNo, sndMsg, sndParam, account );
					histCmd.createBkgNtcHis(bkgNtcHisVOs, "");
				}
				
				/*//1.Cntr Attach
				int len = insertCntrList == null ? 0 : insertCntrList.size();
	            for (int i = 0; i < len; i++) {
	                cntrVo = insertCntrList.get(i);
	                log.debug("***** sms attach Container : " + cntrVo.getIbflag() + " - " + cntrVo.getCntrNo());
	                //메일 보낼 대상 조회
	                smsList = receiptBC.getPhnId(slancd, bkgBookingInfoVO.getBkgOfcCd(), skdDirCd);
	              //전송 메세지.
					sndMsg = "\n\n(" + slancd+"-" + skdDirCd+") " +" " + newFirstVvd+" "+ bkgNo+ " " +cntrVo.getCntrNo()+" 선적 추가 발생 " ; 
					List<BkgNtcHisVO> bkgNtcHisVOs = searchBC.sendMailSmsByPodChange(smsList, bkgNo, sndMsg, account );
					histCmd.createBkgNtcHis(bkgNtcHisVOs, "");
	                
	            }
	            
	            //2.Cntr Detach 
	            len = deleteCntrList == null ? 0 : deleteCntrList.size();
	            for (int i = 0; i < len; i++) {
	                cntrVo = deleteCntrList.get(i);
	                log.debug("***** sms detach Container : " + cntrVo.getIbflag() + " - " + cntrVo.getCntrNo());
	                //메일 보낼 대상 조회
	                smsList = receiptBC.getPhnId(slancd, bkgBookingInfoVO.getBkgOfcCd(), skdDirCd);
	              //전송 메세지.
					sndMsg = "\n\n(" + slancd+"-" + skdDirCd+") " +" " + newFirstVvd+" "+ bkgNo+ " " +cntrVo.getCntrNo()+" 선적 취소 발생 " ; 
					List<BkgNtcHisVO> bkgNtcHisVOs = searchBC.sendMailSmsByPodChange(smsList, bkgNo, sndMsg, account );
					histCmd.createBkgNtcHis(bkgNtcHisVOs, "");
	                
	            }
	          //3.Cntr No 변경 
	            len = changeCntrList == null ? 0 : changeCntrList.size();
	            for (int i = 0; i < len; i++) {
	                cntrVo = changeCntrList.get(i);
	                log.debug("***** sms change Container : " + cntrVo.getIbflag() + " - " + cntrVo.getCntrNo());
	                //메일 보낼 대상 조회
	                smsList = receiptBC.getPhnId(slancd, bkgBookingInfoVO.getBkgOfcCd(),skdDirCd);
	                //전송 메세지 1.
					sndMsg = "\n\n(" + slancd+"-" + skdDirCd+") " +" " + newFirstVvd+" "+ bkgNo+ " " +cntrVo.getCntrNo()+" 선적 추가 발생 " ; 
					List<BkgNtcHisVO> bkgNtcHisVOs = searchBC.sendMailSmsByPodChange(smsList, bkgNo, sndMsg, account );
					histCmd.createBkgNtcHis(bkgNtcHisVOs, "");
	                //전송 메세지 2.
					sndMsg = "\n\n(" + slancd+"-" + skdDirCd+") " +" " + newFirstVvd+" "+ bkgNo+ " " +cntrVo.getCntrNoOld()+" 선적 취소 발생 " ; 
					bkgNtcHisVOs = searchBC.sendMailSmsByPodChange(smsList, bkgNo, sndMsg, account );
					histCmd.createBkgNtcHis(bkgNtcHisVOs, "");
	                
	            }*/

			}
			
			//sms 전송로직 추가 .jsy --e---------
			
			// Container# 변경시 Customer301 전송
			if("N".equals(bkgBlNoVO.getCaFlg())) {        
				if(edi301Snd == true){
					List<BkgNtcHisVO> bkgNtcHisVOs = searchBC.createCustBkgReceiptEdi(bkgBlNoVO, null, "Y", account);
					
					if(bkgNtcHisVOs!=null){
						if(bkgNtcHisVOs.size()>0){
							histCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
						}
					}
				}
			}
			
			// 한국 지역에만 Container Confirm 시 Vender 301 전송
			if ("Y".equals(modifyFnlCfmFlg) 
				 && ("KR".equals(cntrEtcInfoVO.getPorCd().substring(0, 2)) 
					 || "KR".equals(cntrEtcInfoVO.getPolCd().substring(0, 2)))){
				Vender301ParamVO vender301ParamVO = new Vender301ParamVO(); 
				vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
				vender301ParamVO.setOldVvdVOs(null);
				vender301ParamVO.setOldQtyVOs(null);
				vender301ParamVO.setOldMtyPkupYdCd(null);
				vender301ParamVO.setBracCd("");
				vender301ParamVO.setEdiKind("BT");
				vender301ParamVO.setAutoManualFlg("N");
				
				List<BkgNtcHisVO> bkgNtcHisVOs = searchBC.createTmlBkgReceiptEdi(vender301ParamVO, account);

				if(bkgNtcHisVOs!=null){
					if(bkgNtcHisVOs.size()>0){
						histCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
					}
				}
			}
			
			//06.VERMAS EDI 발송
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("VGM_PROC_CTR");			
			List<BkgHrdCdgCtntVO> BkgHrdCdgCtntVOs = utilCmd.searchHardCoding(bkgHrdCdgCtntListCondVO);
			
			String vermasOb = "";
			String partialCntrVgm = "";
			if(BkgHrdCdgCtntVOs.size() > 0){
				vermasOb       = BkgHrdCdgCtntVOs.get(0).getAttrCtnt2();// VERMAS O/B EDI 발송
				partialCntrVgm = BkgHrdCdgCtntVOs.get(0).getAttrCtnt7();// Partial CNTR 의 VGM Update
			}
			
			if(!"OFF".equals(vermasOb)){
				List<BkgNtcHisVO> bkgNtcHisVOs = eBookingReceiptBC.createTerminalVERMASEdi(bkgBlNoVO,"");			
				if(bkgNtcHisVOs!=null){
					if(bkgNtcHisVOs.size()>0){
						histCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
					}
				}
			}
			
			/* Set Message */
            eventResponse.setETCData("USA_CSTMS_DOWNLOAD", String.valueOf(usaCstmsDownload));
			eventResponse.setUserMessage("");
			commit();
			
			
			//partial CNTR 도 찾아서 같은 걸로 update
			if(!"OFF".equals(partialCntrVgm)){
		        if(!"Y".equals(bkgBlNoVO.getCaFlg())){        
		        	if(insertCntrList.size() > 0){
			        	for(int j=0; j<insertCntrList.size(); j++){
			        		if("1".equals(insertCntrList.get(j).getCntrPrtFlg())){
				        		//partial bkg list 조회
					        	List<BkgContainerVO> ptlBkgList = docCmd.searchPtlCntrBkg(bkgBlNoVO.getBkgNo(), insertCntrList.get(j).getCntrNo());
					        	if(ptlBkgList!=null && ptlBkgList.size()>0){
					        		for(int i=0; i<ptlBkgList.size(); i++){
					        			begin();
					        			//target bkg history 조회
					        			BkgBlNoVO bkgBlNoVO1 = new BkgBlNoVO();
					        			bkgBlNoVO1.setBkgNo(ptlBkgList.get(i).getBkgNo());
					        			HistoryTableVO historyTableVO1 = histCmd.searchOldBkgForHistory("ESM_BKG_1184", bkgBlNoVO1);
					        			//vgm 복사
					        			docCmd.modifyPtlCntrVgmCopy(bkgBlNoVO.getBkgNo(), insertCntrList.get(j).getCntrNo(), ptlBkgList.get(i).getBkgNo(), account);
							        	//target bkg history update
					        			histCmd.manageBookingHistory(uiId, historyTableVO1, account);
					        			commit();
					        		}
					        	}
			        		}
			        	}
		        	}
		        	if(updateCntrList.size() > 0){
			        	for(int j=0; j<updateCntrList.size(); j++){
			        		if("1".equals(updateCntrList.get(j).getCntrPrtFlg())){
				        		//partial bkg list 조회
					        	List<BkgContainerVO> ptlBkgList = docCmd.searchPtlCntrBkg(bkgBlNoVO.getBkgNo(), updateCntrList.get(j).getCntrNo());
					        	if(ptlBkgList!=null && ptlBkgList.size()>0){
					        		for(int i=0; i<ptlBkgList.size(); i++){
					        			begin();
					        			//target bkg history 조회
					        			BkgBlNoVO bkgBlNoVO1 = new BkgBlNoVO();
					        			bkgBlNoVO1.setBkgNo(ptlBkgList.get(i).getBkgNo());
					        			HistoryTableVO historyTableVO1 = histCmd.searchOldBkgForHistory("ESM_BKG_1184", bkgBlNoVO1);
					        			//vgm 복사
					        			docCmd.modifyPtlCntrVgmCopy(bkgBlNoVO.getBkgNo(), updateCntrList.get(j).getCntrNo(), ptlBkgList.get(i).getBkgNo(), account);
							        	//target bkg history update
					        			histCmd.manageBookingHistory(uiId, historyTableVO1, account);
					        			commit();
					        		}
					        	}
			        		}
			        	}
		        	}
		        }
			}
			
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Container Confirm을 Cancel한다.(ESM_BKG_0079_04)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse cancelContainerConfirm(Event e) throws EventException {
		EsmBkg007904Event event = (EsmBkg007904Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			this.cancelContainerConfirm(event.getBkgNo(), event.getBlNo());
			eventResponse.setUserMessage("");
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * CNTR IRR(ESM_BKG_0079_04)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse modifyCrdDt(Event e) throws EventException {
		EsmBkg007904Event event = (EsmBkg007904Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
        BLDocumentationCMBC docCmd = null;
		try {
			begin();
	        docCmd = new BLDocumentationCMBCImpl();
			docCmd.modifyCrdDt(event.getContainerVOs(), event.getBkgEtcInfoVO().getCorrFlg(), account);
			eventResponse.setUserMessage("");
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Container Confirm을 Cancel한다.
	 * 
     * @param String bkgNo
	 * @param String blNo
     * @exception Exception
	 */
	private void cancelContainerConfirm(String bkgNo, String blNo) throws Exception {
		String uiId = "ESM_BKG_0079_04";
		BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
		bkgBlNoIN.setBkgNo(bkgNo);
		bkgBlNoIN.setBlNo(blNo);
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

//			HistoryTableVO historyTableVO = null;
		//BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
//			boolean usaCstmsDownload = false;

		BookingUtil utilCmd = new BookingUtil();
		BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
		BLDocumentationCMBC docCmd = new BLDocumentationCMBCImpl();

log.debug("+++++++++++++++++++=================>"+bkgNo);
		/* searchBkgBlNoVO */
		BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
		if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
			throw new EventException(new ErrorHandler("BKG01049", new String[]{bkgNo}).getMessage());
		}
		log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());

		/* Validate Container */
//			docCmd.validateContainer(cntrEtcInfoVO, containerVOs, fnlCfmFlg);

		/* Search Booking History */
//            historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoVO);
					
		/* Container */	
		docCmd.modifyCntrCfmFlg(bkgBlNoVO.getBkgNo(), "N", bkgBlNoVO.getCaFlg());

		log.debug("########## Manage Doc Process ##########");
		BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
		docProcSkdVO.setBkgDocProcTpCd("CNTRLS");
		docProcSkdVO.setBkgNo(bkgBlNoVO.getBkgNo());
		histCmd.manageDocProcess(docProcSkdVO, account);    
		
		// HistoryLine
		log.debug("########## History Line ##########");

		HistoryLineVO historyLineVO = new HistoryLineVO();
//			historyLineVO.setBkgDocProcTpCd("Y".equals(fnlCfmFlg) ? "CNTCFM" : "CNTRLS");
		historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
		historyLineVO.setCaFlg(bkgBlNoVO.getCaFlg());
		historyLineVO.setCrntCtnt(account.getUsr_id() + "/" + "Cancel Container Final Confirm");
		historyLineVO.setPreCtnt(" ");
		historyLineVO.setHisCateNm("F.CFM");
		historyLineVO.setLocalTime("");
		historyLineVO.setUiId(uiId);
		histCmd.createBkgHistoryLine(historyLineVO, account);
		            
		/* Manage Booking History */
//            histCmd.manageBookingHistory(uiId, historyTableVO, account);
		
		/* Set Message */
//            eventResponse.setETCData("USA_CSTMS_DOWNLOAD", String.valueOf(usaCstmsDownload));
		
		// 한국지역 Container Confirm 시 Vender 301 전송
		BkgRouteVO bkgRouteVO = new BkgRouteVO();
		bkgRouteVO = utilCmd.searchBkgRoute(bkgNo);
		
		if(null != bkgRouteVO 
		    && ("KR".equals(bkgRouteVO.getPorCd().substring(0,2)) 
		    	|| "KR".equals(bkgRouteVO.getPolCd().substring(0,2)))){
			
			GeneralBookingSearchBC  searchBC 	= new GeneralBookingSearchBCImpl();
			Vender301ParamVO vender301ParamVO = new Vender301ParamVO(); 
			vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
			vender301ParamVO.setOldVvdVOs(null);
			vender301ParamVO.setOldQtyVOs(null);
			vender301ParamVO.setOldMtyPkupYdCd(null);
			vender301ParamVO.setBracCd("");
			vender301ParamVO.setEdiKind("BT");
			vender301ParamVO.setAutoManualFlg("N");
			
			List<BkgNtcHisVO> bkgNtcHisVOs = searchBC.createTmlBkgReceiptEdi(vender301ParamVO, account);

			if(bkgNtcHisVOs!=null){
				if(bkgNtcHisVOs.size()>0){
					histCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
				}
			}

		}
	}

	/**
	 * container를 다른 booking으로 복사한다.(ESM_BKG_0170)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
    private EventResponse copyContainer(Event e) throws EventException {
        EsmBkg0170Event event = (EsmBkg0170Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        BookingUtil utilCmd = new BookingUtil();
        BLDocumentationCMBC docCmd = new BLDocumentationCMBCImpl();
        SpecialCargoReceiptBC spclCmd = new SpecialCargoReceiptBCImpl();
        GeneralBookingReceiptBC receiptCmd = new GeneralBookingReceiptBCImpl();
        BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
        BkgCopManageBC copCmd = new BkgCopManageBCImpl();
        CostAssignBC masCmd  = new CostAssignBCImpl();

        String orgBkgNo = event.getBkgNo();
//        String orgCntrNo = event.getCntrNo();
        String orgCntrVol = event.getCntrVol();
        CntrCopyVO[] cntrCopyVOs = event.getCntrCopyVOs();
        ContainerVO[] containerVOs = event.getContainerVOs();
        boolean usaCstmsDownload = false;
        
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(orgBkgNo);
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

        BkgBlNoVO bkgBlNoOut = null;
        CntrCopyVO orgCntrCopyVO = null;
        HistoryTableVO historyTableVO = null;
        HistoryLineVO historyLineVO = null;

        String uiId = "ESM_BKG_0170";

        try {
            begin();
            /* searchBkgBlNoVO */
            BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
            if(bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
                throw new EventException(new ErrorHandler("BKG01049", new String[]{orgBkgNo}).getMessage());
            }
            String stsCd = bkgBlNoVO.getBkgStsCd();
            String caFlg = bkgBlNoVO.getCaFlg();
            log.debug("##########> BKG_STATUS : " + orgBkgNo + " - " + stsCd);
            if(stsCd != null && stsCd.equals("X")) {
                throw new EventException(new ErrorHandler("BKG00113", new String[]{orgBkgNo}).getMessage());
            }

            int cnt = (cntrCopyVOs == null) ? 0 : cntrCopyVOs.length;
            log.debug("##########> Target Booking Count : " + cnt);
            for(int i = 0; i < cnt; i++) {
                if(cntrCopyVOs[i] == null || cntrCopyVOs[i].getTgtBkgNo() == null){
                    continue;
                }                
                cntrCopyVOs[i].setCreUsrId(account.getUsr_id());
                cntrCopyVOs[i].setUpdUsrId(account.getUsr_id());
                cntrCopyVOs[i].setSrcBkgNo(orgBkgNo);
                cntrCopyVOs[i].setSrcCntrVol(orgCntrVol);

                log.debug("##########> Origin Booking : " + cntrCopyVOs[i].getOriginFlg());
                //if("Y".equals(cntrCopyVOs[i].getOriginFlg())){
                //    cntrCopyVOs[i].setCaFlg(caFlg);
                //    orgCntrCopyVO = cntrCopyVOs[i];
                //}else{
                    cntrCopyVOs[i].setCaFlg("N");

                    /* Search Booking History */
                    bkgBlNoIN.setBkgNo(cntrCopyVOs[i].getTgtBkgNo());
            		bkgBlNoIN.setCaUsrId(account.getUsr_id());
                    bkgBlNoOut = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
                    historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoOut);

                    // copy Container
                    docCmd.copyContainer(cntrCopyVOs[i]);
                    // copy Special Cargo
                    spclCmd.copySpclCgoByCntr(cntrCopyVOs[i]);
                    // copy Reference
                    receiptCmd.copyBkgRefByCntr(cntrCopyVOs[i]);
                    reRequestSpclCgoApproval(bkgBlNoOut);
                    // change Booking Status
                    receiptCmd.changeBkgStatus("Y", bkgBlNoOut, false, account);



                    // usaCstmsDownload
                    if(!usaCstmsDownload){
                        usaCstmsDownload = utilCmd.searchUsaCstmsDownload(bkgBlNoOut);
                    }
                    
                    // cop
                    //try {
                        String flgPartial = ("1".equals(cntrCopyVOs[i].getTgtCntrVol())) ? "N" : "Y";
                        copCmd.attachCntr(cntrCopyVOs[i].getTgtBkgNo(), cntrCopyVOs[i].getCntrNo(), flgPartial);
                    //} catch(Exception ex) {
                    //    log.error(ex.getMessage(), ex);
                    //}

                    // mas
                    log.debug("##########> MAS - Copy Container : " + cntrCopyVOs[i].getTgtBkgNo());
                    MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
                    masBkgComIfVo.setBkgNo(cntrCopyVOs[i].getTgtBkgNo());
                    masBkgComIfVo.setCostSrcSysCd("BKG");
                    masBkgComIfVo.setIfRmk("Copy Container");
                    masBkgComIfVo.setCreUsrId(cntrCopyVOs[i].getCreUsrId());
                    masBkgComIfVo.setUpdUsrId(cntrCopyVOs[i].getUpdUsrId());
                    masCmd.modifyMasCommonInterface(masBkgComIfVo);
                    
                    /* Manage Booking History */
                    histCmd.manageBookingHistory(uiId, historyTableVO, account);
                                                  
                //}

                //
                String curr_cfm_flg = docCmd.searchDocProcessByCntr(cntrCopyVOs[i].getTgtBkgNo(), "N");
                log.debug("##########> curr_cfm_flg : " + curr_cfm_flg);
                if("Y".equals(curr_cfm_flg)){
                    /* Manage Booking History */
                    historyLineVO = new HistoryLineVO();
                    historyLineVO.setBkgDocProcTpCd("CNTRLS");
                    historyLineVO.setBkgNo(cntrCopyVOs[i].getTgtBkgNo());
                    historyLineVO.setCaFlg("N");
                    historyLineVO.setCrntCtnt(cntrCopyVOs[i].getCntrNo() + "/ copied from " + cntrCopyVOs[i].getSrcBkgNo());
                    historyLineVO.setHisCateNm("");
                    historyLineVO.setLocalTime("");
                    historyLineVO.setUiId(uiId);
                    histCmd.createBkgHistoryLine(historyLineVO, account);
                }

            }
            
            
            int cnt1 = (containerVOs == null) ? 0 : containerVOs.length;
            log.debug("##########> Sourch Booking Count : " + cnt1);
            for(int i = 0; i < cnt1; i++) {
                if(containerVOs[i] == null || containerVOs[i].getCntrNo() == null){
                    continue;
                }    
                
            // origine container
            //if(orgCntrCopyVO != null){
                
                orgCntrCopyVO = new CntrCopyVO();
                orgCntrCopyVO.setCntrNo(containerVOs[i].getCntrNo());
                orgCntrCopyVO.setSrcBkgNo(orgBkgNo);
                orgCntrCopyVO.setSrcCntrVol(containerVOs[i].getCntrVolQty());
                orgCntrCopyVO.setTgtCntrVol(containerVOs[i].getCntrVolQty());
                orgCntrCopyVO.setCaFlg(caFlg);
                orgCntrCopyVO.setCreUsrId(account.getUsr_id());
                orgCntrCopyVO.setUpdUsrId(account.getUsr_id());
                

                /* Search Booking History */
                bkgBlNoIN.setBkgNo(orgCntrCopyVO.getSrcBkgNo());
        		bkgBlNoIN.setCaUsrId(account.getUsr_id());
                bkgBlNoOut = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
                historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoOut);

                // modify Volumn
                docCmd.modifyCntrVol(orgCntrCopyVO);

                
                // mas
                log.debug("##########> MAS - Copy Container : " + orgCntrCopyVO.getSrcBkgNo());
                MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
                masBkgComIfVo.setBkgNo(orgCntrCopyVO.getSrcBkgNo());
                masBkgComIfVo.setCostSrcSysCd("BKG");
                masBkgComIfVo.setIfRmk("Copy Container");
                masBkgComIfVo.setCreUsrId(orgCntrCopyVO.getCreUsrId());
                masBkgComIfVo.setUpdUsrId(orgCntrCopyVO.getUpdUsrId());
                masCmd.modifyMasCommonInterface(masBkgComIfVo);
                
                /* Manage Booking History */
                histCmd.manageBookingHistory(uiId, historyTableVO, account);
            }
                                
            //}

            /* Set Message */
            eventResponse.setETCData("USA_CSTMS_DOWNLOAD", String.valueOf(usaCstmsDownload));
            eventResponse.setUserMessage("");
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

	/**
	 * container 정보를 다른 booking으로 옮긴다.(ESM_BKG_0170)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse moveContainer(Event e) throws EventException {
        EsmBkg0170Event event = (EsmBkg0170Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        BookingUtil utilCmd = new BookingUtil();
        BLDocumentationCMBC docCmd = new BLDocumentationCMBCImpl();
        SpecialCargoReceiptBC spclCmd = new SpecialCargoReceiptBCImpl();
        GeneralBookingReceiptBC receiptCmd = new GeneralBookingReceiptBCImpl();
        BlRatingBC rateCmd = new BlRatingBCImpl();
        BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
        BkgCopManageBC copCmd = new BkgCopManageBCImpl();
        CostAssignBC masCmd  = new CostAssignBCImpl();

        String orgBkgNo = event.getBkgNo();
//        String orgCntrNo = event.getCntrNo();
//        String orgCntrVol = event.getCntrVol();
        CntrCopyVO[] cntrCopyVOs = event.getCntrCopyVOs();
        boolean usaCstmsDownload = false;
        
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(orgBkgNo);
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

        BkgBlNoVO bkgBlNoOut = null;
        CntrCopyVO orgCntrCopyVO = null;
        HistoryTableVO historyTableVO = null;
        HistoryLineVO historyLineVO = null;

        String uiId = "ESM_BKG_0170";

        try {
            begin();
            /* searchBkgBlNoVO */
            BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
            if(bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
                throw new EventException(new ErrorHandler("BKG01049", new String[]{orgBkgNo}).getMessage());
            }
            String stsCd = bkgBlNoVO.getBkgStsCd();
            String caFlg = bkgBlNoVO.getCaFlg();
            log.debug("##########> BKG_STATUS : " + orgBkgNo + " - " + stsCd);
            if(stsCd != null && stsCd.equals("X")) {
                throw new EventException(new ErrorHandler("BKG00113", new String[]{orgBkgNo}).getMessage());
            }
            
            int cnt = (cntrCopyVOs == null) ? 0 : cntrCopyVOs.length;
            /* target booking */
            String[] targetBkg = new String[cnt];
            int targetBkgIdx = 0;
            
            log.debug("##########> Target Booking Count : " + cnt);
            for(int i = 0; i < cnt; i++) {
                if(cntrCopyVOs[i] == null || cntrCopyVOs[i].getTgtBkgNo() == null) {
                    continue;
                }
                cntrCopyVOs[i].setCreUsrId(account.getUsr_id());
                cntrCopyVOs[i].setUpdUsrId(account.getUsr_id());
                cntrCopyVOs[i].setSrcBkgNo(orgBkgNo);
//                cntrCopyVOs[i].setSrcCntrVol(orgCntrVol);

                log.debug("##########> Origin Booking : " + cntrCopyVOs[i].getOriginFlg());
                //if("Y".equals(cntrCopyVOs[i].getOriginFlg())){
                //    cntrCopyVOs[i].setCaFlg(caFlg);
                //    orgCntrCopyVO = cntrCopyVOs[i];
                //}else{
                    cntrCopyVOs[i].setCaFlg("N");

                    /* Search Booking History */
                    bkgBlNoIN.setBkgNo(cntrCopyVOs[i].getTgtBkgNo());
                    bkgBlNoOut = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
                    historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoOut);

                    // copy Container
                    docCmd.copyContainer(cntrCopyVOs[i]);
                    // copy Special Cargo
                    spclCmd.copySpclCgoByCntr(cntrCopyVOs[i]);
                    // copy Reference
                    receiptCmd.copyBkgRefByCntr(cntrCopyVOs[i]);
                    reRequestSpclCgoApproval(bkgBlNoOut);
                    // change Booking Status
                    receiptCmd.changeBkgStatus("Y", bkgBlNoOut, false, account);

                    // usaCstmsDownload
                    if(!usaCstmsDownload){
                        usaCstmsDownload = utilCmd.searchUsaCstmsDownload(bkgBlNoOut);
                    }
                    
                    // cop
                    targetBkg[targetBkgIdx++] = cntrCopyVOs[i].getTgtBkgNo();
                    //try {
//                        log.debug("##########> COP - attachCntr : " + cntrCopyVOs[i].getTgtBkgNo());
//                        String flgPartial = ("1".equals(cntrVol)) ? "N" : "Y";
//                        copCmd.attachCntr(cntrCopyVOs[i].getTgtBkgNo(), cntrCopyVOs[i].getCntrNo(), flgPartial);
                    //} catch(Exception ex) {
                    //    log.error(ex.getMessage(), ex);
                    //}
                 
//                    C/A인 경우 Target에 대한 Copy로 처리, Source는 C/A Complete에서 처리함.
                    if ("Y".equals(caFlg)) {
                    	String isPartial = Float.compare(Float.parseFloat(cntrCopyVOs[i].getTgtCntrVol()), 1.0f) < 0 ?"Y":"N";
                    	copCmd.attachCntr(cntrCopyVOs[i].getTgtBkgNo(), cntrCopyVOs[i].getCntrNo(), isPartial);
                    }

                    // mas
                    log.debug("##########> MAS - Move Container : " + cntrCopyVOs[i].getTgtBkgNo());
                    MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
                    masBkgComIfVo.setBkgNo(cntrCopyVOs[i].getTgtBkgNo());
                    masBkgComIfVo.setCostSrcSysCd("BKG");
                    masBkgComIfVo.setIfRmk("Move Container (Attach)");
                    masBkgComIfVo.setCreUsrId(cntrCopyVOs[i].getCreUsrId());
                    masBkgComIfVo.setUpdUsrId(cntrCopyVOs[i].getUpdUsrId());
                    masCmd.modifyMasCommonInterface(masBkgComIfVo);
                    
                    /* Manage Booking History */
                    histCmd.manageBookingHistory(uiId, historyTableVO, account);

                //}
                
                /* Manage Booking History */
                String curr_cfm_flg = docCmd.searchDocProcessByCntr(cntrCopyVOs[i].getTgtBkgNo(), "N");
                log.debug("##########> curr_cfm_flg : " + curr_cfm_flg);
                if("Y".equals(curr_cfm_flg)){
                    historyLineVO = new HistoryLineVO();
                    historyLineVO.setBkgDocProcTpCd("CNTRLS");
                    historyLineVO.setBkgNo(cntrCopyVOs[i].getTgtBkgNo());
                    historyLineVO.setCaFlg("N");
                    historyLineVO.setCrntCtnt(cntrCopyVOs[i].getCntrNo() + "/ copied from " + cntrCopyVOs[i].getSrcBkgNo());
                    historyLineVO.setHisCateNm("");
                    historyLineVO.setLocalTime("");
                    historyLineVO.setUiId(uiId);
                    histCmd.createBkgHistoryLine(historyLineVO, account);
                }
               
            }
            // remove origin container
            //if(orgCntrCopyVO != null){
            
            ContainerVO[] containerVOs = event.getContainerVOs();
            int cnt1 = (containerVOs == null) ? 0 : containerVOs.length;
            log.debug("##########> Sourch Booking Count : " + cnt1);
            for(int i = 0; i < cnt1; i++) {
                if(containerVOs[i] == null || containerVOs[i].getCntrNo() == null){
                    continue;
                }    
            
                orgCntrCopyVO = new CntrCopyVO();
                orgCntrCopyVO.setCntrNo(containerVOs[i].getCntrNo());
                orgCntrCopyVO.setSrcBkgNo(orgBkgNo);
                orgCntrCopyVO.setSrcCntrVol(containerVOs[i].getCntrVolQty());
                orgCntrCopyVO.setTgtCntrVol(containerVOs[i].getCntrVolQty());
                orgCntrCopyVO.setCaFlg(caFlg);
                orgCntrCopyVO.setCreUsrId(account.getUsr_id());
                orgCntrCopyVO.setUpdUsrId(account.getUsr_id());
                
                /* Search Booking History */
                bkgBlNoIN.setBkgNo(orgCntrCopyVO.getSrcBkgNo());
                bkgBlNoOut = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
                historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoOut);

                // remove special cargo
                spclCmd.removeSpclCgoByCntr(orgCntrCopyVO.getSrcBkgNo(), orgCntrCopyVO.getCntrNo(), "");
                // remove reference
                receiptCmd.removeBkgRefByCntr(orgCntrCopyVO.getSrcBkgNo(), orgCntrCopyVO.getCntrNo(), "N");
                // remove conatainer rate
                rateCmd.removeCntrRateByCntr(orgBkgNo, containerVOs[i].getCntrNo(), "");
                // remove container
                docCmd.moveContainer(orgCntrCopyVO.getSrcBkgNo(), orgCntrCopyVO.getCntrNo(), caFlg);
//                reRequestSpclCgoApproval(bkgBlNoOut);
                // change Booking Status
//                receiptCmd.changeBkgStatus("Y", bkgBlNoOut, false, account);

                
                // usaCstmsDownload
                if(!usaCstmsDownload){
                    usaCstmsDownload = utilCmd.searchUsaCstmsDownload(bkgBlNoOut);
                }
                
                // cop, C/A 일때는 Move 호출하지 않음. C/A Cancel시 Source가 detach 되는 현상 예방
                if (!"Y".equals(caFlg)) {
                	copCmd.moveCntr(orgCntrCopyVO.getSrcBkgNo(), targetBkg, orgCntrCopyVO.getCntrNo());
                }
                //try {
                    log.debug("##########> COP - detachCntr : " + orgCntrCopyVO.getSrcBkgNo());
//                    String flgPartial = ("1".equals(cntrVol)) ? "N" : "Y";
//                    copCmd.detachCntr(orgCntrCopyVO.getSrcBkgNo(), orgCntrCopyVO.getCntrNo(), flgPartial);
                //} catch(Exception ex) {
                //    log.error(ex.getMessage(), ex);
                //}

                // MAS
                log.debug("##########> MAS - Move Container : " + orgCntrCopyVO.getSrcBkgNo());
                MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
                masBkgComIfVo.setBkgNo(orgCntrCopyVO.getSrcBkgNo());
                masBkgComIfVo.setCostSrcSysCd("BKG");
                masBkgComIfVo.setIfRmk("Move Container (Detach)");
                masBkgComIfVo.setCreUsrId(orgCntrCopyVO.getCreUsrId());
                masBkgComIfVo.setUpdUsrId(orgCntrCopyVO.getUpdUsrId());
                masCmd.modifyMasCommonInterface(masBkgComIfVo);
            }

            //}

            /* Set Message */
            eventResponse.setETCData("USA_CSTMS_DOWNLOAD", String.valueOf(usaCstmsDownload));
            eventResponse.setUserMessage("");
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * ESM_BKG_0361_01~06 : 조회 처리<br>
	 * Export / Import Information의 국가별 리스트 조회 이벤트 처리(ESM_BKG_0361_01)<br>
	 * 
	 * @author Choi Do Soon
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchExportImportNumber(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg036101Event event = (EsmBkg036101Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLDocumentationBLBC command = new BLDocumentationBLBCImpl();
		BookingUtil utilCmd = new BookingUtil();
		BLIssuanceBC blIssuanceCmd = new BLIssuanceBCImpl();

		String bkgNo = event.getBkgNo();
		String ioBndCd = event.getIoBndCd();
		String cntCd = event.getCntCd();
		String popUpTpCd = event.getPopUpTpCd();
		String xterSndrId = event.getXterSndrId();
		String xterRqstNo = event.getXterRqstNo();
		String xterRqstSeq = event.getXterRqstSeq();

		BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
		bkgBlNoIN.setBkgNo(bkgNo);
		bkgBlNoIN.setCaUsrId(account.getUsr_id());
		BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
		//나이지리아, 토고 validation을 위해 b/l 탭의 issued flg 값을 가져옴
		String issFlg = blIssuanceCmd.searchOblIssFlg(bkgNo);
		
		eventResponse.setETCData("caFlg", bkgBlNoVO.getCaFlg());
		eventResponse.setETCData("bdrFlg", bkgBlNoVO.getBdrFlg());
		eventResponse.setETCData("issFlg", issFlg);
		
		XptImpLicInVO xptImpLicIn = new XptImpLicInVO();
		xptImpLicIn.setBkgNo(bkgNo);
		xptImpLicIn.setIoBndCd(ioBndCd);
		xptImpLicIn.setCntCd(cntCd);
		xptImpLicIn.setPopuptpcd(popUpTpCd);
		xptImpLicIn.setXterSndrId(xterSndrId);
		xptImpLicIn.setXterRqstNo(xterRqstNo);
		xptImpLicIn.setXterRqstSeq(xterRqstSeq);

		BookingUtil comboUtil = new BookingUtil();
		try {
			List<XptImpLicVO> list = command.searchExportImportNumber(xptImpLicIn, bkgBlNoVO.getCaFlg());
			eventResponse.setRsVoList(list);
			if ("US".equalsIgnoreCase(event.getCntCd())) {
				List<BkgComboVO> aes_expt_id = comboUtil.searchCombo("CD02570");
				eventResponse.setRsVoList(aes_expt_id);
			}
			//국가가 인도일 때, 컨테이너 콤보를 위해 컨테이너 번호를 가져온다
			if ("IN".equalsIgnoreCase(event.getCntCd())) {
				List<CntrComboVO> cntr_list = command.searchCntrList(bkgNo);
				eventResponse.setRsVoList(cntr_list);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0361_01~06 : 입력,수정,삭제<br>
	 * Export / Import Information 국가별 입력,수정,삭제 처리(ESM_BKG_0361_01)<br>
	 * 
	 * @author Choi Do Soon
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageExportImportNumber(Event e) throws EventException {

		EsmBkg036101Event event = (EsmBkg036101Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLDocumentationBLBC docCmd = new BLDocumentationBLBCImpl();
		BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
		BookingUtil utilCmd = new BookingUtil();
		//BDRCorrectionBC correctCmd = new BDRCorrectionBCImpl();
		
		XptImpLicVO[] xptImpLicVOs = event.getXptImpLicVOs();
				
		HistoryTableVO hisTblVO = new HistoryTableVO();
		BkgReferenceVO refVO = new BkgReferenceVO();
		hisTblVO.setBkgReferenceVO(refVO);
		HistoryTableVO historyTableVO = null;

		String bkgNo = event.getBkgNo();
		String cntCd = event.getCntCd();
		String pkgTpCd = event.getPkgTp();
		String uiId = "ESM_BKG_0361";
		
		BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
		bkgBlNoIN.setBkgNo(bkgNo);
		String webId = ""; // EAI I/F 시에 BKGWeb0060001WSProxy 파일에서 설정한 홈페이지ID 값을 세팅하기 위한 변수
		String porCd = ""; // date 값 계산을 위한 POR 값
		
		//EAI I/F의 경우 account 값이 없음.
		if (account != null && account.getUsr_id() != null){
			bkgBlNoIN.setCaUsrId(account.getUsr_id());
		}
		else { 
			bkgBlNoIN.setCaUsrId("WEB");
		}
		
		BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);

		XptImpLicVO xptImpLicVO = new XptImpLicVO();
		xptImpLicVO.setPckTpCd(pkgTpCd);
		List<XptImpLicVO> insertVoList = null;
		List<XptImpLicVO> updateVoList = null;
		List<XptImpLicVO> deleteVoList = null;

//		if (cntCd.equals("US")) {
//			uiId = "ESM_BKG_0361_01";
//		} else if (cntCd.equals("KR")) {
//			uiId = "ESM_BKG_0361_02";
//		} else if (cntCd.equals("BR")) {
//			uiId = "ESM_BKG_0361_03";
//		} else if (cntCd.equals("IN")) {
//			uiId = "ESM_BKG_0361_04";
//		} else if (cntCd.equals("ID")) {
//			uiId = "ESM_BKG_0361_05";
//		} else if (cntCd.equals("CA")) {
//			uiId = "ESM_BKG_0361_06";
//		} else if (cntCd.equals("MX")) {
//			uiId = "ESM_BKG_0361_07";
//		}

		try {
			begin();

			/* Search Booking History */
			if("US".equals(cntCd) || "CA".equals(cntCd) || "BR".equals(cntCd) || "TR".equals(cntCd) || "TG".equals(cntCd) || "NG".equals(cntCd)) {
				historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoVO);
			}
			
			/* Validate Package TypeCd */
			/*if (cntCd.equals("KR")) {
				docCmd.validateExportImportNumber(xptImpLicVOs);
			}*/

			/* searchBkgBlNoVO */
			//boolean caFlag = "".equals(utilCmd.searchBkgBlNoVO(bkgBlNoVO));
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new EventException(new ErrorHandler("BKG01049", new String[]{bkgNo}).getMessage());
			}

			/* Change Screen Flag */
			//if (caFlag) {
				//correctCmd.modifyCngScreenFlag(uiId, bkgBlNoVO);  //사용안함으로 변경됨.
			//}
			
log.debug("@@@@@@SC : int idx1=0, idx2=0, idx3=0");
			
			/* 입력,수정,삭제 분기 */
			int idx1=0, idx2=0, idx3=0;
			if (xptImpLicVOs != null) {
				for (int i = 0; i < xptImpLicVOs.length; i++) {

					if ("I".equals(xptImpLicVOs[i].getIbflag())) {
						idx1++;
					} else if ("U".equals(xptImpLicVOs[i].getIbflag())) {
						idx2++;
					} else if ("D".equals(xptImpLicVOs[i].getIbflag())) {
						idx3++;
					}
				
				}
log.debug("@@@@@@SC : int idx1="+idx1+", idx2="+idx2+", idx3="+idx3);
			}
			insertVoList = new ArrayList<XptImpLicVO>(idx1);
			updateVoList = new ArrayList<XptImpLicVO>(idx2);
			deleteVoList = new ArrayList<XptImpLicVO>(idx3);
			if (xptImpLicVOs != null) {
				int insCnt = 0;
				for (int i = 0; i < xptImpLicVOs.length; i++) {
					log.debug("<::" + xptImpLicVOs[i].getIbflag() + "::" + xptImpLicVOs[i].getBkgNo());
					
					if (e.getFormCommand().isCommand(FormCommand.MULTI01)){ //Homepage에서 I/F 받은 데이터의 경우
						webId = xptImpLicVOs[i].getUpdUsrId(); //BKGWeb0060001WSProxy 파일에서 WEB:한진해운아이디 로 세팅한 값 사용
						porCd = xptImpLicVOs[i].getPorCd(); //date 값 계산을 위한 POR 값 세팅
						
log.debug("@@@@@@@SC : updUsrId["+i+"] = "+webId);					
					} else {
					xptImpLicVOs[i].setCreUsrId(account.getUsr_id());
					xptImpLicVOs[i].setUpdUsrId(account.getUsr_id());
					}

					if ("I".equals(xptImpLicVOs[i].getIbflag())) {
						insCnt++;
						xptImpLicVOs[i].setSeq(Integer.toString(insCnt));
						insertVoList.add(xptImpLicVOs[i]);
					} else if ("U".equals(xptImpLicVOs[i].getIbflag())) {
						updateVoList.add(xptImpLicVOs[i]);
					} else if ("D".equals(xptImpLicVOs[i].getIbflag())) {
						deleteVoList.add(xptImpLicVOs[i]);
					}
				}
			}

			if (insertVoList.size() > 0) {
				docCmd.createExportImportNumber(insertVoList, cntCd, bkgBlNoVO.getCaFlg());
			}

			if (updateVoList.size() > 0) {
				docCmd.modifyExportImportNumber(updateVoList, cntCd, bkgBlNoVO.getCaFlg());
			}

			if (deleteVoList.size() > 0) {
				docCmd.removeExportImportNumber(deleteVoList, bkgBlNoVO.getCaFlg());
			}

            /* Manage Booking History */
			if("US".equals(cntCd) || "CA".equals(cntCd) || "BR".equals(cntCd) || "TR".equals(cntCd) || "TG".equals(cntCd) || "NG".equals(cntCd)) {
				if (account == null){
				// EAI I/F의 경우 
					histCmd.eaiManageBookingHistory(uiId, historyTableVO, webId, porCd);					
				}else{
					histCmd.manageBookingHistory(uiId, historyTableVO, account);
				}
			}
            
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getMessage());
			}//원래 메소드에서 주석 처리된 이유는 모르겠지만 EAI I/F 에 필요해서 WEB006의 경우 사용하도록 처리 
			
			/* Set Message */
			// eventResponse.setUserMessage(new ErrorHandler("BKG00166").getMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0252 : Simple 조회 처리<br>
	 * EmptyReleaseOrder의 event에 대한 특정 리스트 조회 이벤트 처리(ESM_BKG_0252)<br>
	 * 
	 * Empty Release Order를 내기 위해 booking list를 Simple type으로 조회한다. --UI_BKG-0252
	 * BKG EDI HISTORY, BKG NOTICE HISTORY(Fax, e-Mail)에서 전송 여부를 확인한다.
	 * 
	 * @author Choi Do Soon
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchMtyRlseOrdForSimple(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0252Event event = (EsmBkg0252Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EmptyReleaseOrderBC command = new EmptyReleaseOrderBCImpl();

		try {

			List<MtyRlseOrdSimpleOutVO> list = command.searchMtyRlseOrdForSimple(event.getMtyRlseOrdInVO());
			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0252 : Detail 조회 처리<br>
	 * EmptyReleaseOrder의 event에 대한 특정 리스트 조회 이벤트 처리(ESM_BKG_0252)<br>
	 * 
	 * Empty Release Order를 내기 위해 booking list를 Detail(s) type으로 조회한다. --UI_BKG-0252
	 * BKG EDI HISTORY, BKG NOTICE HISTORY(Fax, e-Mail)에서 전송 여부를 확인한다.
	 * 1. Fax와 Email의 Notice history가 각각의 행으로 존재하기 때문에 한행으로 변경하여 조회하여야 함
	 * 2. Remark의 경우 Fax와 Email 둘중 최근 것으로 조회함
	 * 
	 * @author Choi Do Soon
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchMtyRlseOrdForDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0252Event event = (EsmBkg0252Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EmptyReleaseOrderBC command = new EmptyReleaseOrderBCImpl();

		try {

			List<MtyRlseOrdDetailOutVO> list = command.searchMtyRlseOrdForDetail(event.getMtyRlseOrdInVO());
			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0252 : Detail(USA) 조회 처리<br>
	 * EmptyReleaseOrder의 event에 대한 특정 리스트 조회 이벤트 처리(ESM_BKG_0252)<br>
	 * 
	 * Empty Release Order를 내기 위해 booking list를 Detail(s) USA type으로 조회한다. --UI_BKG-0252
	 * BKG EDI HISTORY, BKG NOTICE HISTORY(Fax, e-Mail)에서 전송 여부를 확인한다.
	 * 1. Fax와 Email의 Notice history가 각각의 행으로 존재하기 때문에 한행으로 변경하여 조회하여야 함
	 * 2. Remark의 경우 Fax와 Email 둘중 최근 것으로 조회함
	 * 
	 * @author Choi Do Soon
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchMtyRlseOrdForUsa(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0252Event event = (EsmBkg0252Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EmptyReleaseOrderBC command = new EmptyReleaseOrderBCImpl();

		try {

			List<MtyRlseOrdUsaOutVO> list = command.searchMtyRlseOrdForUsa(event.getMtyRlseOrdInVO());
			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0252 : 팩스 보내기 이벤트 처리<br>
	 * EmptyReleaseOrder의 팩스 보내기 처리(ESM_BKG_0252)<br>
	 * 
	 * @author Choi Do Soon
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse sendMtyRlseOrdByFax(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EsmBkg0252Event event = (EsmBkg0252Event) e;

		EmptyReleaseOrderBC command = new EmptyReleaseOrderBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();
		BookingUtil utilBC = new BookingUtil();
		try {
			begin();
			// No Rate 일 경우 Empty Release Order 발송 Block
			for(int i=0; i<event.getSendMtyRlseOrdVOs().length; i++ ){
				if(event.getSendMtyRlseOrdVOs()[i].getBkgNo() != null){
					BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
					bkgBlNoVO.setBkgNo(event.getSendMtyRlseOrdVOs()[i].getBkgNo());
					if("Y".equals(utilBC.searchNoRateBlockFlg(bkgBlNoVO))){
						throw new EventException(new ErrorHandler("BKG08335",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
					}
					if("Y".equals(utilBC.searchStandbyBlockFlg(bkgBlNoVO))){
						throw new EventException(new ErrorHandler("BKG08336",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
					}
				}
			}
			/* 1. Send FAX */
			List<BkgNtcHisVO> bkgNtcHisVOs = command.sendMtyRlseOrdByFax(event.getSendMtyRlseOrdVOs(), account);
			/* 2. Register Notice History */
			bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("BKG00496").getUserMessage());

			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00265").getMessage(), ex);
		}

		return eventResponse;

	}

	/**
	 * ESM_BKG_0252 : 이메일 보내기 이벤트 처리<br>
	 * EmptyReleaseOrder의 이메일 보내기 처리(ESM_BKG_0252)<br>
	 * 
	 * @author Choi Do Soon
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse sendMtyRlseOrdByEmail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0252Event event = (EsmBkg0252Event) e;
		EmptyReleaseOrderBC command = new EmptyReleaseOrderBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();
		BookingUtil utilBC = new BookingUtil();
		try {
			begin();
			// No Rate 일 경우 Empty Release Order 발송 Block
			for(int i=0; i<event.getSendMtyRlseOrdVOs().length; i++ ){
				if(event.getSendMtyRlseOrdVOs()[i].getBkgNo() != null){
					BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
					bkgBlNoVO.setBkgNo(event.getSendMtyRlseOrdVOs()[i].getBkgNo());
					if("Y".equals(utilBC.searchNoRateBlockFlg(bkgBlNoVO))){
						throw new EventException(new ErrorHandler("BKG08335",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
					}
					if("Y".equals(utilBC.searchStandbyBlockFlg(bkgBlNoVO))){
						throw new EventException(new ErrorHandler("BKG08336",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
					}
				}
			}
			/* 1. Send Email */
			List<BkgNtcHisVO> bkgNtcHisVOs = command.sendMtyRlseOrdByEmail(event.getSendMtyRlseOrdVOs(), event.getBkgEmlEdtVO(), account);
			/* 2. Register Notice History */
			bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("BKG00497").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00265").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0252 : EDI 전송 이벤트 처리<br>
	 * EmptyReleaseOrder의 EDI 보내기 처리(ESM_BKG_0252)<br>
	 * 
	 * @author Choi Do Soon
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse sendMtyRlseOrdByEdi(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0252Event event = (EsmBkg0252Event)e;
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		BookingHistoryMgtBC command2 = new BookingHistoryMgtBCImpl();
		BkgBlNoVO bkgBlNoVO = null;
		SendMtyRlseOrdVO[] sendMtyRlseOrdVOs = null;
		List<BkgNtcHisVO> bkgNtcHisVOs = null;
		String ntcKndCd = null;
		try {
			begin();
			sendMtyRlseOrdVOs = event.getSendMtyRlseOrdVOs();
			if (null!=sendMtyRlseOrdVOs && 0<sendMtyRlseOrdVOs.length) {
				for (SendMtyRlseOrdVO vo : sendMtyRlseOrdVOs) {
					bkgBlNoVO = new BkgBlNoVO();
					bkgBlNoVO.setBkgNo(vo.getBkgNo());
					ntcKndCd = "F".equalsIgnoreCase(vo.getYardType()) ? "FC" :("T".equalsIgnoreCase(vo.getYardType()) ?  "BT":"CN");
					// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
					Vender301ParamVO vender301ParamVO = new Vender301ParamVO(); 
					vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
					vender301ParamVO.setOldVvdVOs(null);
					vender301ParamVO.setOldQtyVOs(null);
					vender301ParamVO.setOldMtyPkupYdCd(null);
					vender301ParamVO.setBracCd("U");
					vender301ParamVO.setEdiKind(ntcKndCd);
					vender301ParamVO.setAutoManualFlg("N");
					
					bkgNtcHisVOs = command.createTmlBkgReceiptEdi(vender301ParamVO, account);
					if (null!=bkgNtcHisVOs && 0<bkgNtcHisVOs.size()) {
						command2.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0252");
					}
				}
				eventResponse.setUserMessage(new ErrorHandler("BKG00101").getUserMessage());
			}
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00265").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * BKG CONTAINER MANIFEST DESCRIPTION 테이블에서 해당 container에 대해서 조회(ESM_BKG_0178)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchCmByCntr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0178Event event = (EsmBkg0178Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLDocumentationCMBC command = new BLDocumentationCMBCImpl();

		log.debug("==========>" + event.getCntrNo());
		log.debug("==========>" + event.getTVvd());

		try {

			CmByCntrVO cmVO = command.searchCmByCntr(event.getCntrNo(), event.getTVvd());
			CntrCmEtcInfoVO cntrCmEtcInfoVO = cmVO.getCntrCmEtcInfoVO();
			List<CntrCmBkgInfoVO> cntrCmBkgInfoVOs = cmVO.getCntrCmBkgInfoVOs();
			List<CntrCmDescInfoVO> cntrCmDescInfoVOs = cmVO.getCntrCmDescInfoVOs();

			eventResponse.setRsVoList(cntrCmBkgInfoVOs);
			eventResponse.setETCData(cntrCmEtcInfoVO.getColumnValues());
			eventResponse.setRsVoList(cntrCmDescInfoVOs);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 컨테이너별로 C/M을 입력/수정/삭제한다(ESM_BKG_0178)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageCmByCntr(Event e) throws EventException {
		EsmBkg0178Event event = (EsmBkg0178Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLDocumentationCMBC docCmd = new BLDocumentationCMBCImpl();
		BookingUtil utilCmd = new BookingUtil();
		BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
		
		CmByCntrVO cmVO = event.getCmByCntrVO();
		CntrCmEtcInfoVO cmEtcVO = cmVO.getCntrCmEtcInfoVO();
		
        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(cmEtcVO.getBkgNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());
        
        HistoryTableVO historyTableVO = null;

        String uiId = "ESM_BKG_0178";

		
		try {
			begin();
            /* searchBkgBlNo */
            BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
            if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
                throw new EventException(new ErrorHandler("BKG01049").getMessage());
            }
            log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());
            
            /* Search Booking History */
            historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoVO);

			/* manageCmByCntr */
			docCmd.manageCmByCntr(cmVO, account, "N");
			
			for(int i = 0; i<cmVO.getCntrCmDescInfoVOs().size(); i++) {
				CntrCmDescInfoVO cntrCmDescInfoVO= cmVO.getCntrCmDescInfoVOs().get(i);
				modifyBsByCm(cntrCmDescInfoVO.getBkgNo(), "N", cntrCmDescInfoVO.getCntrMfGdsDesc());
			}
			
            
            /* Manage Booking History */
            histCmd.manageBookingHistory(uiId, historyTableVO, account);
            			
			/* Set Message */
			eventResponse.setUserMessage("");
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * C/M을 통해 Goods Description 조회 메소드.(ESM_BKG_0707)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchGoodsDescByCm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0707Event event = (EsmBkg0707Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BookingUtil utilCmd = new BookingUtil();
		BLDocumentationBLBC blCmd = new BLDocumentationBLBCImpl();
		BLDocumentationCMBC cmCmd = new BLDocumentationCMBCImpl();

        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(event.getBkgNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

        try {
            // searchBkgBlNo
            BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
            if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
                throw new EventException(new ErrorHandler("BKG01049", new String[] { event.getBkgNo() }).getMessage());
            }
            log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());

			CmGoodsDescVO goodsDescVO = blCmd.searchGoodsDescByCm(bkgBlNoVO.getBkgNo());
			List<BkgCntrMfDescVO> list = cmCmd.searchCntrMfDesc(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getCaFlg());
			String cntrKnt = cmCmd.searchCntrKnt(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getCaFlg());

			eventResponse.setRsVoList(list);
			eventResponse.setETCData(goodsDescVO.getColumnValues());
			eventResponse.setETCData("cntr_knt", cntrKnt);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
		    throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * b/l을 group으로 수정하기 위해 대상 list를 조회한다.(ESM_BKG_0726)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchBlListForGroupUpdate(Event e) throws EventException {
		EsmBkg0726Event event = (EsmBkg0726Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLIssuanceBC issueCmd = new BLIssuanceBCImpl();

		GrpBlDtVO grpBlDtIN = event.getGrpBlDtVO();

		try {
			GrpBlDtVO grpBlDtOUT = issueCmd.searchBlListForGroupUpdate(grpBlDtIN.getGrpBlDtInVO());

			GrpBlDtInVO grpBlEtcVO = grpBlDtOUT.getGrpBlDtInVO();
			List<GrpBlDtListVO> grpBlDtListVOs = grpBlDtOUT.getGrpBlDtListVOs();

			eventResponse.setRsVoList(grpBlDtListVOs);
			eventResponse.setETCData(grpBlEtcVO.getColumnValues());

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * b/l들을 group으로 release한다.
     * onboard date나 issue date등을 수정할 수 있다.(ESM_BKG_0726)
     * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse releaseGroupBlUpdate(Event e) throws EventException {
	    EsmBkg0726Event event = (EsmBkg0726Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
				
		BLIssuanceBC command = new BLIssuanceBCImpl();
		GeneralBookingReceiptBC generalBookingReceiptBC = new GeneralBookingReceiptBCImpl();
		String uiId = "ESM_BKG_0726";
		HistoryTableVO historyTableVO = new HistoryTableVO ();
		BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();	
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		BookingUtil utilCmd = new BookingUtil();

		try  {
			begin();
			
			GrpBlDtListVO grpBlDtListVO = event.getGrpBlDtListVO();

			String blTpCd = grpBlDtListVO.getBlTpCd();
			String bkgNo = grpBlDtListVO.getBkgNo();
			String buttonType = "btn_t11SWBRelease";

			BlIssInfoVO blIssInfoVO= new BlIssInfoVO();
			blIssInfoVO.setUpdUsrId(account.getUsr_id());
			blIssInfoVO.setUpdOffice(account.getOfc_cd());
			blIssInfoVO.setBlIssueNo(grpBlDtListVO.getBlIssNo());
			blIssInfoVO.setOnBoardType(grpBlDtListVO.getBlObrdTpCd());
			blIssInfoVO.setBkgNo(bkgNo);
			blIssInfoVO.setBlNo(grpBlDtListVO.getBlNo());
			blIssInfoVO.setBlIssueAt(grpBlDtListVO.getOblIssOfcCd());
			
			// History search
			bkgBlNoVO.setBkgNo(bkgNo);
			bkgBlNoVO.setCaUsrId(account.getUsr_id());			
			bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoVO);			
			historyTableVO = bookingHistoryMgtBC.searchOldBkgForHistory(uiId, bkgBlNoVO);	
			
			
			//I GeneralBookingReceiptBC::modifyBlType  // update BL_TP_CD 
			generalBookingReceiptBC.modifyBlType(bkgNo,blTpCd);

			//IBLIssuanceBC::manageBlIssueFlg ( blIssInfoVO )   // update ISS table
			blIssInfoVO.setButtontype(buttonType);
			command.manageGrpBlIssueFlg(blIssInfoVO);
			
			/**
			 *  OBLREL	ORIGINAL B/L RELEASE
			 */
            BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
	        docProcSkdVO.setBkgNo(bkgNo);
	        docProcSkdVO.setBkgDocProcTpCd("OBLREL");
	        bookingHistoryMgtBC.manageDocProcess(docProcSkdVO, account);
			
	        if(buttonType.equals("btn_t11SWBRelease")){
	        	List<BkgNtcHisVO> bkgNtcHisVOs = null;  
	        	DblEdiInVO dblEdiInVO = null;
	        	DblEdiVO dblEdiVO = null;
                List<CustTpIdVO> custTpIdVos = utilCmd.searchEdiCustTpId(bkgBlNoVO, "D", "N");
                bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
                
                for(int i=0 ; i < custTpIdVos.size() ; i++) {
                	dblEdiInVO = new DblEdiInVO();
    	        	dblEdiInVO.setBkgNo(bkgNo);
    	        	dblEdiInVO.setEdiReceiveId(custTpIdVos.get(i).getRcvId());
    	        	dblEdiInVO.setGroupEdiId(custTpIdVos.get(i).getGroupId());
    	        	dblEdiInVO.setGroupEdiCust(custTpIdVos.get(i).getRefCode());
    	        	dblEdiInVO.setAutoManualFlg("M");
    	        	
    	        	if(custTpIdVos.get(i).getRcvId() != null && custTpIdVos.get(i).getRcvId() != "" && ("PKEXML".equals(custTpIdVos.get(i).getRcvId()) || "C1T0W".equals(custTpIdVos.get(i).getRcvId()))){
    		        	dblEdiVO = command.createDraftBlEdi(dblEdiInVO, account);
    	        		if(dblEdiVO != null){
    		        		String rcvId = custTpIdVos.get(i).getRcvId();
    						BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
    						bkgNtcHisVO.setBkgNo(bkgNo);
    						bkgNtcHisVO.setNtcViaCd("E");
    						bkgNtcHisVO.setNtcKndCd("BL");
    						bkgNtcHisVO.setEdiId(rcvId);
    						bkgNtcHisVO.setEsvcGrpCd(custTpIdVos.get(i).getGroupId());
    						bkgNtcHisVO.setBkgNtcSndRsltCd(dblEdiVO.getFlatFileAckVOs().get(0).getAckStsCd());
    						bkgNtcHisVO.setFltFileRefNo(dblEdiVO.getFlatFileAckVOs().get(0).getFltFileRefNo());
    						bkgNtcHisVO.setSndUsrId("SYSTEM");
    						bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
    						bkgNtcHisVO.setSndRqstDt(DateTime.getShortDateString());
    						bkgNtcHisVO.setCreUsrId(account.getUsr_id());
    						bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
    						bkgNtcHisVOs.add(bkgNtcHisVO);
    	        		}
    	        	}
                }
                if(bkgNtcHisVOs!=null){
					if(bkgNtcHisVOs.size()>0){
						bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
					}
                }
            }
	        
	        
	        
			commit();
			
			bookingHistoryMgtBC.manageBookingHistory(uiId, historyTableVO, account);
						
			begin();
			//Inbound Cr관련 로그
			utilCmd.addBkgLog("BKG_GRP_SWB", grpBlDtListVO.getBlNo() , "Release: "+ grpBlDtListVO.getOblRlseFlg());
			
			CargoReleaseOrderBC cargoBC = new CargoReleaseOrderBCImpl();
			OblRdemVO oblRdem = new OblRdemVO();
			oblRdem.setBlNo(grpBlDtListVO.getBlNo());
			oblRdem.setCgorTeamCd("S");
			oblRdem.setCgoEvntNm("SWB Release");
			oblRdem.setEvntDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
			oblRdem.setEvntOfcCd(account.getOfc_cd());
			oblRdem.setEvntUsrId(account.getUsr_id());
			oblRdem.setOblRdemFlg(grpBlDtListVO.getOblRlseFlg());

			try{
				cargoBC.setupFocByObl(oblRdem);
			}catch(Exception e1){
				log.debug("[end:: CargoReleaseOrderBC == manageBlIssInfo update ]==========");
				log.error(e1.getMessage()); 
			}	
			commit();
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}		
		return eventResponse;
	}
	
	
	
	/**
	 * b/l들을 group으로 수정한다.
	 * onboard date나 issue date등을 수정할 수 있다.(ESM_BKG_0726)
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyGroupBlUpdate(Event e) throws EventException {
	    EsmBkg0726Event event = (EsmBkg0726Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	
		BookingUtil utilCmd = new BookingUtil();
		BLIssuanceBC issueCmd = new BLIssuanceBCImpl();
		BLDocumentationBLBC docCmd = new BLDocumentationBLBCImpl();
		BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
	
		GrpBlDtVO grpBlDtIN = event.getGrpBlDtVO();
	
		GrpBlDtInVO grpBlDtInVO = grpBlDtIN.getGrpBlDtInVO();
		List<GrpBlDtListVO> grpBlDtListVOs = grpBlDtIN.getGrpBlDtListVOs();
	
	    BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
	    BkgBlNoVO bkgBlNoOUT = null;
		HistoryTableVO historyTableVO = null;
	    BlStatusVO blStatusVO = null;
	
	//	String vvd = grpBlDtInVO.getVvd();
	//	String vslCd = vvd.substring(0, 4);
	//	String voyNo = vvd.substring(4, 8);
	//	String dirCd = vvd.substring(8, 9);
	//	String portCd = grpBlDtInVO.getPolCd();
	//	String clptIndSeq = "";
		
		String bkgNo = null;
	
	    String chgReady = null;
	    String mkReady = null;
	    String doChkInd = null;
	    String stsFirm = null;
	    String audFlg = null;
	
		//not update bkg error message
		StringBuffer errBkg = new StringBuffer();
		StringBuffer chgErrBkg = new StringBuffer();
		StringBuffer mkErrBkg = new StringBuffer();
		StringBuffer doErrBkg = new StringBuffer();
		StringBuffer stsErrBkg = new StringBuffer();
		StringBuffer audErrBkg = new StringBuffer();
		
	
	    //history
	    String uiId = "ESM_BKG_0726";
	    
		try {
			int voCnt = grpBlDtListVOs == null ? 0 : grpBlDtListVOs.size();
			String onBrdDt ="";
			String onBrdDtOld ="";
			
			log.debug("########### grpBlDtListVOs : " + voCnt);
			for (int i = 0; i < voCnt; i++) {
	            // BKG No.
				BlIssInfoVO vo = new BlIssInfoVO();
	            bkgNo = grpBlDtListVOs.get(i).getBkgNo();
	            log.debug("## bkgNo      : " + bkgNo);
	            vo.setBkgNo(bkgNo);
	//            // Check ETA/ETD
	//			VskVslPortSkdVO vskVslPortSkdVO = utilCmd.searchEtbEtdEta(vslCd, voyNo, dirCd, portCd, clptIndSeq);
	//			String vslETA = vskVslPortSkdVO.getVpsEtaDt();
	//			String vslETD = vskVslPortSkdVO.getVpsEtdDt();
	//          String oblIssDtShould = grpBlDtListVOs.get(i).getOblIssDtSd();
	//			log.debug("## vslETA     : " + vslETA);
	//			log.debug("## vslETD     : " + vslETD);
	//          log.debug("## oblIssDtSd : " + oblIssDtShould);
	//			if(oblIssDtShould != null && oblIssDtShould.length() >= 10 &&
	//			   vslETA != null && vslETA.length() >= 10 &&
	//			   vslETD != null && vslETD.length() >= 10){
	//                int d1 = DateTime.daysBetween(vslETA.substring(0, 10).replaceAll("-", ""), oblIssDtShould.replaceAll("-", ""));
	//                int d2 = DateTime.daysBetween(oblIssDtShould.replaceAll("-", ""), vslETD.substring(0, 10).replaceAll("-", ""));
	//                log.debug("## d1     : " + d1);
	//                log.debug("## d2     : " + d2);
	//			    if(d1 > 3 || d2 > 3){
	//			        throw new EventException(new ErrorHandler("BKG00385").getMessage());
	//			    }
	//			}
	            // O.B/L Issued Flag
	            log.debug("## chkdIss  : " + grpBlDtInVO.getChkdIss());
	            grpBlDtListVOs.get(i).setUpdUsrId(account.getUsr_id());
	            grpBlDtListVOs.get(i).setCreUsrId(account.getUsr_id());
	            if("Y".equals(grpBlDtInVO.getChkdIss())){
	                blStatusVO = issueCmd.validateBlIssue(vo);
	                
	                chgReady = blStatusVO.getChgReady();
	                mkReady = blStatusVO.getMkReady();
	                doChkInd = blStatusVO.getDoChkInd();
	                stsFirm = blStatusVO.getBkgStsCd();
	                audFlg = blStatusVO.getAudFlg();
	
	                if("N".equals(chgReady)) {
	                    chgErrBkg.append(bkgNo);
	                    chgErrBkg.append(",");
	                } 
	                if ("N".equals(mkReady)) {
	                    mkErrBkg.append(bkgNo);
	                    mkErrBkg.append(",");
	                } 
	                if ("N".equals(doChkInd)){
	                    doErrBkg.append(bkgNo);
	                    doErrBkg.append(",");
	                } 
	                if ("N".equals(stsFirm)){
	                	stsErrBkg.append(bkgNo);
	                	stsErrBkg.append(",");
	                }
	                if ("N".equals(audFlg)){
	                	audErrBkg.append(bkgNo);
	                	audErrBkg.append(",");
	                } 
	                
	                
	                if (!"N".equals(chgReady) && !"N".equals(mkReady) && !"N".equals(doChkInd) && !"N".equals(stsFirm) && !"N".equals(audFlg)) {
	                	/* set O.B/L Issue Flag */
	                    grpBlDtListVOs.get(i).setOblIssFlg("Y");
	                    
	                    /* searchBkgBlNo */
	                    bkgBlNoIN.setBkgNo(bkgNo);
	            		bkgBlNoIN.setCaUsrId(account.getUsr_id());
	                    bkgBlNoOUT = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
	                    
	                    /* Search Booking History */
	                    begin();
	                    historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoOUT);
	                    docCmd.modifyBlObrdDt(grpBlDtListVOs.get(i));
	
	                    issueCmd.modifyGroupBlUpdate(grpBlDtListVOs.get(i), grpBlDtInVO);
	                    
	                    /**
	        			 *  OBLISS	ORIGINAL B/L ISSUE
	        			 */
	                    if(null != grpBlDtListVOs.get(i).getOblIssFlg() && "Y" == grpBlDtListVOs.get(i).getOblIssFlg()){
	                    	BkgDocProcSkdVO docProcSkdVO = new BkgDocProcSkdVO();
	        	            docProcSkdVO.setBkgNo(grpBlDtListVOs.get(i).getBkgNo());
	        	            docProcSkdVO.setBkgDocProcTpCd("OBLISS");
	        	            histCmd.manageDocProcess(docProcSkdVO, account);
	                    }
	                    
	                    /* Manage Booking History */
	                    histCmd.manageBookingHistory(uiId, historyTableVO, account);
	                    
	                    // MAS IF : On-board Date 바뀐 경우 I/F 
	                    onBrdDt = grpBlDtListVOs.get(i).getBlObrdDtSd().replaceAll("[^0-9]","")+"000000";  
	        			onBrdDtOld = (historyTableVO.getBkgBlDocVO().getBlObrdDt()).replaceAll("[^0-9]",""); 
	        			if(!onBrdDt.equals(onBrdDtOld)) { // MAS 호출 		

	        				CostAssignBC masCmd  = new CostAssignBCImpl();
	        				MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO(); 
	        				masBkgComIfVo.setBkgNo(grpBlDtListVOs.get(i).getBkgNo()); 
	        				masBkgComIfVo.setCostSrcSysCd("BKG"); 
	        				masBkgComIfVo.setIfRmk("Onboard Date"); 
	        				masBkgComIfVo.setCreUsrId(account.getUsr_id()); 
	        				masBkgComIfVo.setUpdUsrId(account.getUsr_id()); 
	        				masCmd.modifyMasCommonInterface(masBkgComIfVo); 
	        			}
	        			commit();
	        			
	        			//issue시 특정조건에 맞으면 pdf파일 이메일로 전송 (samsung)
	        			if("Y".equalsIgnoreCase(issueCmd.checkAutoEmailWithBLForSamsung(bkgNo))){
		        			begin();
					    	DblWblVO[] dblWblVOs = null;
					    	List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
					        StringBuilder sbParam = new StringBuilder();
					        BookingUtil util = new BookingUtil();
					        BkgEmlEdtVO bkgEmlEdtVO = new BkgEmlEdtVO();
					        
					        // Get Receive Email Address (Search Hard Coding Table)		
							BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
							bkgHrdCdgCtntListCondVO.setHrdCdgId("SAMSUNG");
							List<BkgHrdCdgCtntVO> bkgHrdCdgCtntVOs= util.searchHardCoding(bkgHrdCdgCtntListCondVO);
					        
							String sType = null;
							String sLevel = null;
							String sMrd = null;
							String hiddenData = null;
				    		
				    		sType="2";
							sMrd="ESM_BKG_0109_DBL.mrd";
							sLevel="6";
							hiddenData = "Y";
							
							sbParam.append("/rv");
							sbParam.append(" form_bkgNo[('").append(grpBlDtListVOs.get(i).getBkgNo()).append("')]");
							sbParam.append(" form_type[").append(sType).append("]");
							sbParam.append(" form_dataOnly[N]");
							sbParam.append(" form_manifest[N]");
							sbParam.append(" form_usrId[").append(account.getUsr_id()).append("]");
							sbParam.append(" form_hiddeData[").append(hiddenData).append("]");
							sbParam.append(" form_level[(").append(sLevel).append(")]");
							sbParam.append(" form_remark[").append("").append("]");
							sbParam.append(" form_Cntr[1]");
							sbParam.append(" form_mainOnly[N]");
							sbParam.append(" form_CorrNo[]");
							sbParam.append(" form_his_cntr[BKG_CONTAINER]");
							sbParam.append(" form_his_bkg[BKG_BOOKING]");
							sbParam.append(" form_his_mkd[BKG_BL_MK_DESC]");
							sbParam.append(" form_his_xpt[BKG_XPT_IMP_LIC]");
							sbParam.append(" form_his_bl[BKG_BL_DOC]");
							sbParam.append(" isEncode[Y]");
							sbParam.append(" /rp []");
							sbParam.append(" /riprnmargin");
							
							dblWblVOs = new DblWblVO[1];
							dblWblVOs[0] = new DblWblVO();
							dblWblVOs[0].setBkgNo(grpBlDtListVOs.get(i).getBkgNo());
							dblWblVOs[0].setBlNo(grpBlDtListVOs.get(i).getBlNo());
							dblWblVOs[0].setSyscd("BKG");
							dblWblVOs[0].setTmplmrd(sMrd);
							dblWblVOs[0].setBatchflg("N");
							dblWblVOs[0].setTmplparam(sbParam.toString());
							//dblWblVOs[0].setTmplmrdpdf("MBL_SMCU"+grpBlDtListVOs.get(i).getBkgNo()+".pdf");
							dblWblVOs[0].setTmplmrdpdf(grpBlDtListVOs.get(i).getBkgNo()+".pdf");
							dblWblVOs[0].setItr("|$$|");
							dblWblVOs[0].setNtcKndCd("BL");
							dblWblVOs[0].setHiddOpt("N");
							dblWblVOs[0].setFrtAllFlg("Y");
							
							if(bkgHrdCdgCtntVOs.size() > 0) {
								dblWblVOs[0].setRcveml(bkgHrdCdgCtntVOs.get(0).getAttrCtnt1());
							} else {
								return null;
							}
							
							bkgNtcHisVOs = issueCmd.sendBLByEmailForSamsung(dblWblVOs,bkgEmlEdtVO,account);
							histCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
							commit();  
	        			}
	                }
	            }else{
	            	begin();
	                /* searchBkgBlNo */
	                bkgBlNoIN.setBkgNo(bkgNo);
	        		bkgBlNoIN.setCaUsrId(account.getUsr_id());
	                bkgBlNoOUT = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
	                
	                /* Search Booking History */
	                historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoOUT);
	                log.debug("\n##################getBlObrdDt " +grpBlDtListVOs.get(i).getBlObrdDt());
	                docCmd.modifyBlObrdDt(grpBlDtListVOs.get(i));
	
	                log.debug("\n##################BKG_NO " +grpBlDtListVOs.get(i).getBkgNo());
	                log.debug("\n##################credit " +grpBlDtListVOs.get(i).getCreditChk());
	                issueCmd.modifyGroupBlUpdate(grpBlDtListVOs.get(i), grpBlDtInVO);
	
	                /* Manage Booking History */
	                histCmd.manageBookingHistory(uiId, historyTableVO, account);
	                
	                // MAS IF : On-board Date 바뀐 경우 I/F 
	    			onBrdDt = grpBlDtListVOs.get(i).getBlObrdDtSd().replaceAll("[^0-9]","")+"000000"; 
	    			onBrdDtOld = (historyTableVO.getBkgBlDocVO().getBlObrdDt()).replaceAll("[^0-9]",""); 
	    			if(!onBrdDt.equals(onBrdDtOld)) { // MAS 호출 
	    				
	    				CostAssignBC masCmd  = new CostAssignBCImpl();
	    				MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO(); 
	    				masBkgComIfVo.setBkgNo(grpBlDtListVOs.get(i).getBkgNo()); 
	    				masBkgComIfVo.setCostSrcSysCd("BKG"); 
	    				masBkgComIfVo.setIfRmk("Onboard Date"); 
	    				masBkgComIfVo.setCreUsrId(account.getUsr_id()); 
	    				masBkgComIfVo.setUpdUsrId(account.getUsr_id()); 
	    				masCmd.modifyMasCommonInterface(masBkgComIfVo); 
	    				
	    			}
	    			commit();
	            }
			}
	
	        /* Set Message */
	        eventResponse.setUserMessage("");
	
			/*
			 * 부분적으로 이슈가 된 Bkg는 저장 되어야 함.
			 */
	        // set message
	        if (chgErrBkg.length()>0) {
	            errBkg.append("Charge:" + chgErrBkg.substring(0, chgErrBkg.length()-1) + "\n");
	        }           
	        if (mkErrBkg.length()>0) {
	            errBkg.append("M&D:" + mkErrBkg.substring(0, mkErrBkg.length()-1) + "\n");                          
	        }
	        if (doErrBkg.length()>0) {
	            errBkg.append("DO:" + doErrBkg.substring(0, doErrBkg.length()-1) + "\n");              
	        }
	        if (audErrBkg.length()>0) {
	            errBkg.append("Audit:" + audErrBkg.substring(0, audErrBkg.length()-1) + "\n");              
	        }
	        
			if (errBkg.length() > 0) {
	            if (stsErrBkg.length()>0) {
	                errBkg.append("\nBKG status is not firmed yet!\n" + stsErrBkg.substring(0, stsErrBkg.length()-1));              
	            } 
				throw new EventException(new ErrorHandler("BKG08084", new String[]{"\n" + errBkg}).getMessage());
			}else{
				if(stsErrBkg.length()>0){
					throw new EventException(new ErrorHandler("BKG95071", new String[]{"\n" + stsErrBkg.substring(0, stsErrBkg.length()-1)}).getMessage());
				}
			}
			
	
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * house bl의 description 정보를 조회한다.
     * M&D에 HB/L의 정보를 추가하기 위해 사용한다.(ESM_BKG_0360)
     * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchHblForMnd(Event e) throws EventException {
		EsmBkg0360Event event = (EsmBkg0360Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLDocumentationBLBC docCmd = new BLDocumentationBLBCImpl();

		String bkgNo = event.getBkgNo();

		try {
			List<HblForMndVO> hblForMndVOs = docCmd.searchHblForMnd(bkgNo);

			eventResponse.setRsVoList(hblForMndVOs);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * house bl 정보를 조회한다.(ESM_BKG_0366)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchHbl(Event e) throws EventException {
		EsmBkg0366Event event = (EsmBkg0366Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BookingUtil utilCmd = new BookingUtil();
		UserSetupMgtBC userCmd = new UserSetupMgtBCImpl();
		BLDocumentationBLBC docCmd = new BLDocumentationBLBCImpl();

		BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
		bkgBlNoIN.setBkgNo(event.getBkgNo());
		bkgBlNoIN.setBlNo(event.getBlNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

		try {
			// searchBkgBlNo
            BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
            if(bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
                throw new EventException(new ErrorHandler("BKG01049", new String[]{event.getBkgNo()}).getMessage());
            }
			log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());
            
            /* update on 2009.12.31 */
            String cgoTp = utilCmd.searchBkgCgoTp(bkgBlNoIN);
            if("P".equals(cgoTp)) {
                throw new EventException(new ErrorHandler("BKG00092", new String[]{event.getBkgNo()}).getMessage());
            }
            log.debug("=====> Cgargo Tpye : " + cgoTp);
            
            
            /* 
             * User Default Set을 적용하기 위해 UserId가 필요. 
             * modified on 2009-11-20 by KimYoungchul 
             */ 
            bkgBlNoVO.setIbflag(account.getUsr_id());
            
			HblVO hblVO = docCmd.searchHbl(bkgBlNoVO);

			HblBkgInfoVO hblBkgInfoVO = hblVO.getHblBkgInfoVO();
			BkgUsrDfltSetVO usrDfltSetVO = userCmd.searchUserDefaultSetting(account.getUsr_id());
			List<HblDtlInfoVO> hblVOs = hblVO.getHblDtlInfoVOs();
			List<HblCntrVO> hblCntrVOs = hblVO.getHblCntrVOs();
			List<BkgCntrMfDescVO> cntrMfDescVO = hblVO.getBkgCntrMfDescVOs();

			eventResponse.setRsVoList(hblVOs);
			eventResponse.setETCData(hblBkgInfoVO.getColumnValues());
            eventResponse.setETCData("corr_flg", bkgBlNoVO.getCaFlg());
            eventResponse.setETCData("ca_exist_flg", bkgBlNoVO.getCaExistFlg());
			eventResponse.setETCData("obl_iss_flg", utilCmd.oblIssFlgCheck(bkgBlNoVO.getBkgNo(),bkgBlNoVO.getCaFlg()));
            eventResponse.setETCData("default_wgt_ut_cd", (usrDfltSetVO==null ? "" : usrDfltSetVO.getWgtUtCd()));
            eventResponse.setETCData("default_meas_ut_cd", (usrDfltSetVO==null ? "" : usrDfltSetVO.getMeasUtCd()));
            
			eventResponse.setRsVoList(hblCntrVOs);
			eventResponse.setRsVoList(cntrMfDescVO);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * House B/L 및 Customer 정보를 수정한다.(ESM_BKG_0366)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageHbl(Event e) throws EventException {

	    EsmBkg0366Event event = (EsmBkg0366Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        BookingUtil utilCmd = new BookingUtil();
        BLDocumentationBLBC blCmd = new BLDocumentationBLBCImpl();
        BLDocumentationCMBC cmCmd = new BLDocumentationCMBCImpl();
        BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
        //BDRCorrectionBC correctCmd = new BDRCorrectionBCImpl();

        HblVO hblVO = event.getHblVO();

        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(event.getBkgNo());
        bkgBlNoIN.setBlNo(event.getBlNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

        HistoryTableVO historyTableVO = null;

        String uiId = "ESM_BKG_0366";

        try {
            begin();
            /* searchBkgBlNo */
            BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
            if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
                throw new EventException(new ErrorHandler("BKG01049", new String[]{event.getBkgNo()}).getMessage());
            }
            log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());
            
            /* validate */
            blCmd.validateHbl(hblVO);
            log.debug("=====> validateHbl    : OK!");

            /* Search Booking History */
            historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoVO);

            /* modifyCngScreenFlag */
            //if ("Y".equals(bkgBlNoVO.getCaFlg())) {
                //correctCmd.modifyCngScreenFlag("", bkgBlNoVO);  //사용않함으로 변경됨.
            //}
            
            /* manage CM */
            cmCmd.manageCmByHbl(hblVO, account, bkgBlNoVO.getCaFlg());
            
            /* manage HBL */
            blCmd.manageHbl(hblVO, account, bkgBlNoVO.getCaFlg());
            
            /* Manage Booking History */
            histCmd.manageBookingHistory(uiId, historyTableVO, account);
            
            /* Set Message */
            eventResponse.setUserMessage("");
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * house b/l에 filer number를 지정한다.(ESM_BKG_0366)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse asgnMfNo(Event e) throws EventException {

        EsmBkg0366Event event = (EsmBkg0366Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        BookingUtil utilCmd = new BookingUtil();
        BLDocumentationBLBC docCmd = new BLDocumentationBLBCImpl();
        BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
        //BDRCorrectionBC correctCmd = new BDRCorrectionBCImpl();

        NvoccFileNoVO fileNoVO = event.getNvoccFileNoVO();
        log.debug("******** BkgNo : " + fileNoVO.getBkgNo());

        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(fileNoVO.getBkgNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

        HistoryTableVO historyTableVO = null;

        String bkgNo  = null;
        String blNo   = null;
        String hblSeq = null;
        String mfNo   = null;
        
        String uiId   = "ESM_BKG_0366";

        try {
            begin();
            /* searchBkgBlNo */
            BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
            if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
                throw new EventException(new ErrorHandler("BKG01049", new String[]{fileNoVO.getBkgNo()}).getMessage());
            }
            log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());

            bkgNo = bkgBlNoVO.getBkgNo();
            blNo = bkgBlNoVO.getBlNo();
            hblSeq = fileNoVO.getHblSeq();
            log.debug("=====> bkgNo=" + bkgNo + ", blNo=" + blNo + ", hblSeq=" + hblSeq);
            
            // assign Nvocc File Number
            docCmd.validateMfNo(bkgBlNoVO);
            log.debug("=====> validateMfNo : OK!");

            /* Search Booking History */
            historyTableVO = histCmd.searchOldBkgForHistory(uiId, bkgBlNoVO);

            /* modifyCngScreenFlag */
            //if ("Y".equals(bkgBlNoVO.getCaFlg())) {
                //correctCmd.modifyCngScreenFlag("", bkgBlNoVO);  //사용않함으로 변경됨.
            //}
            
            /* search maximum MfNo */
            mfNo = docCmd.searchMaxMfNo(bkgNo, blNo, bkgBlNoVO.getCaFlg());               
            log.debug("=====> mfNo    : " + mfNo);
            
            /* update MfNo */
            docCmd.modifyNvoccFileNo(bkgNo, hblSeq, mfNo, account, bkgBlNoVO.getCaFlg());
            
            /* Manage Booking History */
            histCmd.manageBookingHistory(uiId, historyTableVO, account);
            
            /* Set Message */
            eventResponse.setETCData("cntr_mf_no", mfNo);
            eventResponse.setUserMessage("");
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * house b/l의 화주 정보에 대한 template 정보를 조회한다.(ESM_BKG_0399)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchHblTmplt(Event e) throws EventException {
		EsmBkg0399Event event = (EsmBkg0399Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLDocumentationBLBC docCmd = new BLDocumentationBLBCImpl();

		String cneeNm = event.getCneeNm();
		String shprNm = event.getShprNm();
		String ofcCd = account.getOfc_cd();

		try {
			// BLDocumentationBLBC::searchHblTmplt ( ShprNm , cneeNm , ofcCd )
			HblTmpltVO hblTmpltVO = docCmd.searchHblTmplt(shprNm, cneeNm, ofcCd);

			List<BkgNvoccProfVO> custProfVOs = hblTmpltVO.getBkgNvoccProfVOs();
			List<BkgNvoccProfCntrMfVO> cmProfVOs = hblTmpltVO.getBkgNvoccProfCntrMfVOs();

			eventResponse.setRsVoList(custProfVOs);
			eventResponse.setRsVoList(cmProfVOs);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * house b/l의 화주 정보에 대한 template 정보를 관리한다.(ESM_BKG_0399)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageHblTmplt(Event e) throws EventException {
		EsmBkg0399Event event = (EsmBkg0399Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLDocumentationBLBC docCmd = new BLDocumentationBLBCImpl();

		HblTmpltVO hblTmpltVO = event.getHblTmpltVO();

		try {
			begin();
			// manageBkgHistory
			docCmd.manageHblTmplt(hblTmpltVO, account.getUsr_id());
			// set message
			eventResponse.setUserMessage("");
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0648 : Retrieve<br>
	 * B/L Copy 대상을 조회합니다.(ESM_BKG_0648)<br>
	 * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchForCopyBl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0648Event event = (EsmBkg0648Event)e;
		BLDocumentationBLBC command = new BLDocumentationBLBCImpl();
		try {
			BlCopyOutVO rsVo = command.searchForCopyBl(event.getBkgNo());
			eventResponse.setETCData(rsVo.getColumnValues());
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}	
		return eventResponse;
	}

	/**
	 * ESM_BKG_0648 : Copy B/L Copy(ESM_BKG_0648)<br>
	 * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse copyBl(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		EsmBkg0648Event event = null;
		try {
			event = (EsmBkg0648Event) e;
			if (null!=event.getBlCopyIns() && 0<event.getBlCopyIns().length) {
				begin();
				eventResponse = copyBlProc(event);
				//eventResponse.setUserMessage(new ErrorHandler("PRI00110").getMessage()); //Data copied successfully.
				commit();
			}
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06014").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * copyBl 로부터 호출됨<br>
	 * B/L Copy Process<br>
	 * 
     * @param EsmBkg0648Event event
     * @return GeneralEventResponse
     * @exception EventException
	 */
	private GeneralEventResponse copyBlProc(EsmBkg0648Event event) throws EventException {
		GeneralEventResponse eventResponse;
		BLDocumentationBLBC command;
		BookingHistoryMgtBC command2;
		GeneralBookingReceiptBC command3;
		ArrivalNoticeBC command4;
		BlRatingBC command5;
        BookingUtil utilCmd;
		BkgBlNoVO bkgBlNoIN;
		BkgBlNoVO bkgBlNoVo;
		HistoryTableVO historyTableVo;
		List<BlCopyInVO> list;
		String uiId;
		String copyBkgNo;
		eventResponse = new GeneralEventResponse();
		command = new BLDocumentationBLBCImpl();
		command2 = new BookingHistoryMgtBCImpl();
		command3 = new GeneralBookingReceiptBCImpl();
		command4 = new ArrivalNoticeBCImpl();
		command5 = new BlRatingBCImpl();
		utilCmd = new BookingUtil();
		list = new ArrayList<BlCopyInVO>(event.getBlCopyIns().length);
		uiId = "ESM_BKG_0648";
		//7.loop
		for (BlCopyInVO blCopyInVo : event.getBlCopyIns()) {
			copyBkgNo = blCopyInVo.getCopyBkgNo();
			bkgBlNoIN = new BkgBlNoVO();
			bkgBlNoIN.setBkgNo(blCopyInVo.getCopyBkgNo());
			bkgBlNoIN.setCaUsrId(account.getUsr_id());
			bkgBlNoVo = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
			blCopyInVo.setResultMsg("");
			//8. 히스토리 테이블 조회
			historyTableVo = command2.searchOldBkgForHistory(uiId, bkgBlNoVo);
			//9.bkgStatus,bdrFlg,shprCd 확인
			blCopyInVo = command.searchForCopyBl(blCopyInVo);
			if (!StringUtil.isEmpty(blCopyInVo.getResultMsg())) {
				blCopyInVo.setResultMsg("Fail ("+blCopyInVo.getResultMsg()+")");
				list.add(blCopyInVo);
				continue;
			}
			try {
				//15.if custFlg='Y'
				if ("Y".equalsIgnoreCase(blCopyInVo.getCustFlg())) {
					//16.copyCustByBlCopy
					command3.copyCustByBlCopy(blCopyInVo, account);
					command3.cancelCustCdVal(copyBkgNo);
					command4.cancelArrNtcCustCdVal(copyBkgNo);
					
					// PPD/Collect Customer, Office 변경
					command5.modifyRateCntCd(copyBkgNo, account, "N");
					
					BkgModiOfcPrcVO bkgModiOfcPrcVO = new BkgModiOfcPrcVO();
					bkgModiOfcPrcVO.setInBkgNo(copyBkgNo);
					bkgModiOfcPrcVO.setInCaFlg("N");
					bkgModiOfcPrcVO.setInPpdFlg("Y");
					bkgModiOfcPrcVO.setInCctFlg("Y");
					command5.callBkgModiChgOfcPrc(bkgModiOfcPrcVO);
					
					// MAS I/F 추가
					CostAssignBC masCmd  = new CostAssignBCImpl();
					MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
					masBkgComIfVo.setBkgNo(copyBkgNo);
					masBkgComIfVo.setCostSrcSysCd("BKG");
					masBkgComIfVo.setIfRmk("Customer Copy");
					masBkgComIfVo.setCreUsrId(account.getUsr_id());
					masBkgComIfVo.setUpdUsrId(account.getUsr_id());			
					masCmd.modifyMasDailyInterface(masBkgComIfVo);
					
					// INV I/F
					BookingARCreationBC invBc = new BookingARCreationBCImpl();		
					ARBkgInterfaceCreationVO bkgIfVo = new ARBkgInterfaceCreationVO();
					bkgIfVo.setBkgNo(copyBkgNo);
					bkgIfVo.setManDivInd("B");
					bkgIfVo.setUserId(account.getUsr_id());
					invBc.interfaceBKGARInvoiceToINV(bkgIfVo);
				}
				//20.copyDocByBlCopy
				blCopyInVo = command.copyDocByBlCopy(blCopyInVo, account);
				if (StringUtil.isEmpty(blCopyInVo.getResultMsg())) {  //실패하지않은경우만
					blCopyInVo.setResultMsg("Success");
				} else {
					blCopyInVo.setResultMsg("Fail ("+blCopyInVo.getResultMsg()+")");
				}
				//25.히스토리관련
				command2.manageBookingHistory(uiId, historyTableVo, account);
				list.add(blCopyInVo);
				continue;
			} catch(Exception ex2) {  //copy되지 않은 건은 fail을 리턴해 주기 위해서 throw 하지 않는다.
				blCopyInVo.setResultMsg("Fail");
				list.add(blCopyInVo);
				log.error(ex2.getMessage());
				//continue;
			}
		}
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

    /**
	 * 조회 이벤트 처리<br>
	 * 조회조건을 가져오기위한 MultiCombo조회 결과(ESM_BKG_0218)<br>
	 *
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchComCode0218(Event e) throws EventException {
		BookingUtil comboUtil = null;
		GeneralEventResponse eventResponse = null;
		List<BkgComboVO> bkg_sts_cd = null;
		List<BkgComboVO> bkg_cust_tp_cd = null;
		List<BkgComboVO> fax_sts_cd = null;
		List<BkgComboVO> eml_sts_cd = null;
		try {
			comboUtil = new BookingUtil();
			eventResponse = new GeneralEventResponse();
			bkg_sts_cd = comboUtil.searchCombo("CD00769");  // bkg_status
			bkg_cust_tp_cd = comboUtil.searchCombo("CD00880");  // bkg_cust_tp_cd
			fax_sts_cd = comboUtil.searchCombo("CD02396");  // fax_sts_cd(CD00959)
			eml_sts_cd = comboUtil.searchCombo("CD02396");  // eml_sts_cd(CD00960)
			bkg_sts_cd.remove(bkg_sts_cd.size()-1);
			bkg_sts_cd.remove(bkg_sts_cd.size()-1);
			eventResponse.setCustomData("bkg_sts_cd", bkg_sts_cd);
			eventResponse.setCustomData("bkg_cust_tp_cd", bkg_cust_tp_cd);
			eventResponse.setCustomData("fax_sts_cd", fax_sts_cd);
			eventResponse.setCustomData("eml_sts_cd", eml_sts_cd);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0218 : Retrieve<br>
	 * Draft BL 및 Waybill 전송을 위한 Outbound booking list를 조회한다.(ESM_BKG_0218)<br>
	 * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchBkgListForObDblWbl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0218Event event = (EsmBkg0218Event)e;
		BLIssuanceBC command = new BLIssuanceBCImpl();
		try {
			
	    	if ((!"".equals(event.getObDblWblInVO().getVslCd().trim()) && !"".equals(event.getObDblWblInVO().getPolCd().trim())) ||
		    		(!"".equals(event.getObDblWblInVO().getOblIssDtFrom().trim()) && !"".equals(event.getObDblWblInVO().getOblIssDtTo().trim()) && !"".equals(event.getObDblWblInVO().getPolCd().trim())) ||
		    		(!"".equals(event.getObDblWblInVO().getBlObrdDtFrom().trim()) && !"".equals(event.getObDblWblInVO().getBlObrdDtTo().trim()) && !"".equals(event.getObDblWblInVO().getPolCd().trim())) ||
		    		!"".equals(event.getObDblWblInVO().getBkgNo().trim()) || !"".equals(event.getObDblWblInVO().getBlNo().trim())) {
	    		
	    		if(!"".equals(event.getObDblWblInVO().getOblIssDtFrom().trim())){
	                if (DateTime.daysBetween(event.getObDblWblInVO().getOblIssDtFrom(), event.getObDblWblInVO().getOblIssDtTo()) > 31 ) {
	                    throw new EventException(new ErrorHandler("BKG00756", new String[]{"Duration","31Days"}).getMessage());
	                }
	    		}
	    		if(!"".equals(event.getObDblWblInVO().getBlObrdDtFrom().trim())){
	                if (DateTime.daysBetween(event.getObDblWblInVO().getBlObrdDtFrom(), event.getObDblWblInVO().getBlObrdDtTo()) > 31 ) {
	                    throw new EventException(new ErrorHandler("BKG00756", new String[]{"Duration","31Days"}).getMessage());
	                }
	    		}
 
		    } else {
		    		throw new EventException(new ErrorHandler("BKG95066", new String[]{}).getMessage());
		    }
	    	
			DblWblOutVO rsVo = command.searchBkgListForObDblWbl(event.getObDblWblInVO());
			if (null!=rsVo) {
				eventResponse.setRsVoList(rsVo.getDblWbls());
				if (null!=rsVo.getDblWblCnts() && 0<rsVo.getDblWblCnts().size()) {
					DblWblCntVO dblWblCntVO = rsVo.getDblWblCnts().get(0);
					eventResponse.setETCData("faxBlTotal1",dblWblCntVO.getFaxBlTotal());
					eventResponse.setETCData("faxTotal1"  ,dblWblCntVO.getFaxTotal());
					eventResponse.setETCData("faxSuccess1",dblWblCntVO.getFaxSuccess());
					eventResponse.setETCData("faxSending1",dblWblCntVO.getFaxSending());
					eventResponse.setETCData("faxUnSent1" ,String.valueOf(Integer.parseInt(dblWblCntVO.getFaxNoSend())+Integer.parseInt(dblWblCntVO.getFaxFailed()))
							                               +" (No Send : "+dblWblCntVO.getFaxNoSend()+" / Failed : "+dblWblCntVO.getFaxFailed()+")");
					eventResponse.setETCData("emlBlTotal1",dblWblCntVO.getEmlBlTotal());
					eventResponse.setETCData("emlTotal1"  ,dblWblCntVO.getEmlTotal());
					eventResponse.setETCData("emlSuccess1",dblWblCntVO.getEmlSuccess());
					eventResponse.setETCData("emlSending1",dblWblCntVO.getEmlSending());
					eventResponse.setETCData("emlUnSent1" ,String.valueOf(Integer.parseInt(dblWblCntVO.getEmlNoSend())+Integer.parseInt(dblWblCntVO.getEmlFailed()))
														   +" (No Send : "+dblWblCntVO.getEmlNoSend()+" / Failed : "+dblWblCntVO.getEmlFailed()+")");
				}
			} else {
				eventResponse.setETCData("faxBlTotal1","0");
				eventResponse.setETCData("faxTotal1"  ,"0");
				eventResponse.setETCData("faxSuccess1","0");
				eventResponse.setETCData("faxSending1","0");
				eventResponse.setETCData("faxUnSent1" ,"0 (No Send : 0 / Failed : 0)");
				eventResponse.setETCData("emlBlTotal1","0");
				eventResponse.setETCData("emlTotal1"  ,"0");
				eventResponse.setETCData("emlSuccess1","0");
				eventResponse.setETCData("emlSending1","0");
				eventResponse.setETCData("emlUnSent1" ,"0 (No Send : 0 / Failed : 0)");
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}	
		return eventResponse;
	}

	/**
	 * ESM_BKG_0218 : Retrieve<br>
	 * Draft BL 및 Waybill 전송을 위한 Inbound booking list를 조회한다.(ESM_BKG_0218)<br>
	 * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchBkgListForIbDblWbl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0218Event event = (EsmBkg0218Event)e;
		BLIssuanceBC command = new BLIssuanceBCImpl();
		try{
			DblWblOutVO rsVo = command.searchBkgListForIbDblWbl(event.getInDblWblInVO());
			if (null!=rsVo) {
				eventResponse.setRsVoList(rsVo.getDblWbls());
				if (null!=rsVo.getDblWblCnts() && 0<rsVo.getDblWblCnts().size()) {
					DblWblCntVO dblWblCntVO = rsVo.getDblWblCnts().get(0);
					eventResponse.setETCData("faxBlTotal2",dblWblCntVO.getFaxBlTotal());
					eventResponse.setETCData("faxTotal2"  ,dblWblCntVO.getFaxTotal());
					eventResponse.setETCData("faxSuccess2",dblWblCntVO.getFaxSuccess());
					eventResponse.setETCData("faxSending2",dblWblCntVO.getFaxSending());
					eventResponse.setETCData("faxUnSent2" ,String.valueOf(Integer.parseInt(dblWblCntVO.getFaxNoSend())+Integer.parseInt(dblWblCntVO.getFaxFailed()))
							                               +" (No Send : "+dblWblCntVO.getFaxNoSend()+" / Failed : "+dblWblCntVO.getFaxFailed()+")");
					eventResponse.setETCData("emlBlTotal2",dblWblCntVO.getEmlBlTotal());
					eventResponse.setETCData("emlTotal2"  ,dblWblCntVO.getEmlTotal());
					eventResponse.setETCData("emlSuccess2",dblWblCntVO.getEmlSuccess());
					eventResponse.setETCData("emlSending2",dblWblCntVO.getEmlSending());
					eventResponse.setETCData("emlUnSent2" ,String.valueOf(Integer.parseInt(dblWblCntVO.getEmlNoSend())+Integer.parseInt(dblWblCntVO.getEmlFailed()))
														   +" (No Send : "+dblWblCntVO.getEmlNoSend()+" / Failed : "+dblWblCntVO.getEmlFailed()+")");
				}
			} else {
				eventResponse.setETCData("faxBlTotal2","0");
				eventResponse.setETCData("faxTotal2"  ,"0");
				eventResponse.setETCData("faxSuccess2","0");
				eventResponse.setETCData("faxSending2","0");
				eventResponse.setETCData("faxUnSent2" ,"0 (No Send : 0 / Failed : 0)");
				eventResponse.setETCData("emlBlTotal2","0");
				eventResponse.setETCData("emlTotal2"  ,"0");
				eventResponse.setETCData("emlSuccess2","0");
				eventResponse.setETCData("emlSending2","0");
				eventResponse.setETCData("emlUnSent2" ,"0 (No Send : 0 / Failed : 0)");
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}	
		return eventResponse;
	}

	/**
	 * ESM_BKG_0218 : Assign BKG Agent E-mail<br>
	 * BKG에 해당하는 Draft B/L 전송시 Chinese Booking Agent Code에 있는 Email 주소 조회한다.(ESM_BKG_0218)<br>
	 * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchBkgAgentEml(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0218Event event = (EsmBkg0218Event)e;
		BLIssuanceBC command = new BLIssuanceBCImpl();
		List<AgentEmlVO> agentEmlVOs = null;
		try {
			agentEmlVOs = command.searchBkgAgentEml((List<String>)event.getAttribute("bkgNos"));
			eventResponse.setRsVoList(agentEmlVOs);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}	
		return eventResponse;
	}

	/**
	 * ESM_BKG_1071 : Retrieve<br>
     * Booking 별 Fax, Mail의 전송결과를 조회한다.(ESM_BKG_1071)<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchMultiNtcHis(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1071Event event = (EsmBkg1071Event)e;
		BLIssuanceBC command = new BLIssuanceBCImpl();
		List<MultiNtcHisVO> rsVo = null;
		try {
			rsVo = command.searchMultiNtcHis(event.getMultiNtcHisVO());
			if (null!=rsVo && 0<rsVo.size()) {
				eventResponse.setRsVoList(rsVo);
				eventResponse.setETCData("txt_bkg_no", rsVo.get(0).getBkgNo());
				eventResponse.setETCData("txt_bl_no", rsVo.get(0).getBlNo());
				eventResponse.setETCData("txt_ntc_knd_cd", rsVo.get(0).getNtcKndCd());
				eventResponse.setETCData("txt_ntc_via_cd", rsVo.get(0).getNtcViaCd());
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}	
		return eventResponse;
	}

	/**
	 * B/L Preview 화면 설정을 위한 Data를 조회한다.(ESM_BKG_0927)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchBlInfoForPreview(Event e) throws EventException {
		EsmBkg0927Event event = (EsmBkg0927Event) e;
		GeneralEventResponse eventResponse = null;

		BookingUtil utilCmd = null;
		BLIssuanceBC command = null;
		GeneralBookingReceiptBC receiptBC = null;

		BkgBlNoVO bkgBlNoIN = null;
		BookingCreationVO bookingCreationVO = null;

		String bkg_no = "";
		String bl_no = "";
		String bl_tp_cd = "";
		String hiddenData = "";
		String rate = "";
		String cntr = "";
		String rider_yn = "";
//		String houseBl_yn = "";
		String[] hbl = new String[2];
		String corr_no = "";
		String email = "";
		String fax_no = "";
		String obl_iss_flg = "";

		try {
			eventResponse = new GeneralEventResponse();
			utilCmd = new BookingUtil();
			command = new BLIssuanceBCImpl();
			receiptBC = new GeneralBookingReceiptBCImpl();

			// searchBkgBlNo
			bkgBlNoIN = new BkgBlNoVO();
			bkgBlNoIN.setBkgNo(event.getBkg_no());
			bkgBlNoIN.setBlNo(event.getBl_no());
			bkgBlNoIN.setCaUsrId(account.getUsr_id());
			BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
			
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new EventException(new ErrorHandler("BKG01049", new String[] { event.getBkg_no() }).getMessage());
			}
			bookingCreationVO = receiptBC.searchBooking(bkgBlNoVO);
			for (BkgCntcPsonVO vo : bookingCreationVO.getBkgCntcPson()) {
				if ("SI".equalsIgnoreCase(vo.getBkgCntcPsonTpCd())) {
					fax_no = vo.getCntcPsonFaxNo();
					email = vo.getCntcPsonEml();
					break;
				}
			}

			bkg_no = bkgBlNoVO.getBkgNo(); // bkg_no
			bl_no = bkgBlNoVO.getBlNo(); // bl_no
			//bl_tp_cd = (event.getBlTpCd() == null || event.getBlTpCd().equals("")) ? bkgBlNoVO.getBlTpCd() : event.getBlTpCd(); // bl_tp_cd
			bl_tp_cd = bkgBlNoVO.getBlTpCd(); // bl_tp_cd
			hiddenData = event.getHiddenData();
			
			rate = event.getFormLevel() == null || event.getFormLevel().equals("") ? "1" : event.getFormLevel();
			cntr = event.getForm_Cntr() == null || event.getForm_Cntr().equals("") ? "1" : event.getForm_Cntr();
			corr_no = event.getForm_corr_no();

			rider_yn = command.searchRiderYn(bkg_no, hiddenData, rate, cntr, corr_no);
			hbl = command.searchHouseBlYn(bkg_no);
			obl_iss_flg = command.searchOblIssFlg(bkg_no);

			/*
			log.debug("####################################################");
			log.debug("");
			log.debug("bkg_no : [" + bkg_no + "]");
			log.debug("bl_no" + bl_no + "]");
			log.debug("bl_tp_cd : [" + bl_tp_cd + "]");
			log.debug("hiddenData : [" + hiddenData + "]");
			log.debug("rate : [" + rate + "]");
			log.debug("cntr : [" + cntr + "]");
			log.debug("corr_no : [" + corr_no + "]");
			log.debug("rider_yn : [" + rider_yn + "]");
			log.debug("houseBl_yn : [" + houseBl_yn + "]");
			log.debug("");
			log.debug("####################################################");
			*/
			
			eventResponse.setETCData("bkg_no", bkg_no);
			eventResponse.setETCData("bl_no", bl_no);
			eventResponse.setETCData("bl_tp_cd", bl_tp_cd);
			eventResponse.setETCData("rider_yn", rider_yn);
			eventResponse.setETCData("houseBl_yn", hbl[0]);
			eventResponse.setETCData("hbl_tp", hbl[1]);
			eventResponse.setETCData("fax_no", fax_no);
			eventResponse.setETCData("email", email);
			eventResponse.setETCData("obl_iss_flg", obl_iss_flg);
			if (null!=bookingCreationVO && null!=bookingCreationVO.getBkgBookingInfoVO()) {
				eventResponse.setETCData("por_cd",bookingCreationVO.getBkgBookingInfoVO().getBkgPorCd());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * Email 전송 이벤트 처리<br>
     * Email 전송한다.(ESM_BKG_0218,ESM_BKG_0927)<br>
     *
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse sendDblWblByEmail(Event e) throws EventException {
        GeneralEventResponse eventResponse = null;
        EsmBkg0218Event event0218 = null;
        EsmBkg0927Event event0927 = null;        
        BLIssuanceBC command = null;
        BookingHistoryMgtBC hisBC = null;
    	String uiId = null;
    	BookingUtil utilBC = new BookingUtil();
    	List<BkgNtcHisVO> bkgNtcHisVOs = null;
        try {
        	begin();
            eventResponse = new GeneralEventResponse();
            command = new BLIssuanceBCImpl();
            hisBC = new BookingHistoryMgtBCImpl();

			if ("EsmBkg0218Event".equalsIgnoreCase(e.getEventName())) {
				uiId = "ESM_BKG_0218";
				event0218 = (EsmBkg0218Event)e;
				
				//Late SI notice
				if(event0218.getDblWblVOs()!=null && "DR".equals(event0218.getDblWblVOs()[0].getNtcKndCd())){
					bkgNtcHisVOs = command.sendRmdEmail(event0218.getDblWblVOs(), event0218.getBkgEmlEdtVO(), account);
				}else{
					
		            DblWblVO[] dblWblVOs = event0218.getDblWblVOs();
					if (dblWblVOs.length > 0) {
						for (int i=0; i<dblWblVOs.length; i++) {
							BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
							bkgBlNoVO.setBkgNo(dblWblVOs[i].getBkgNo());
							if("Y".equals(utilBC.searchNoRateBlockFlg(bkgBlNoVO))){
								throw new EventException(new ErrorHandler("BKG08334",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
							}
							if("Y".equals(utilBC.searchStandbyBlockFlg(bkgBlNoVO))){
								throw new EventException(new ErrorHandler("BKG08337",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
							}
						}
					}
					
					bkgNtcHisVOs = command.sendDblWblByEmail(event0218.getDblWblVOs(), event0218.getBkgEmlEdtVO(), account);
				}
	        	
			} else if ("EsmBkg0927Event".equalsIgnoreCase(e.getEventName())) {
            	uiId = "ESM_BKG_0927";
				event0927 = (EsmBkg0927Event)e;
				
	            DblWblVO[] dblWblVOs = event0927.getDblwblvos();
				if (dblWblVOs.length > 0) {
					for (int i=0; i<dblWblVOs.length; i++) {
						BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
						bkgBlNoVO.setBkgNo(dblWblVOs[i].getBkgNo());
						if("Y".equals(utilBC.searchNoRateBlockFlg(bkgBlNoVO))){
							throw new EventException(new ErrorHandler("BKG08334",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
						}
						if("Y".equals(utilBC.searchStandbyBlockFlg(bkgBlNoVO))){
							throw new EventException(new ErrorHandler("BKG08337",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
						}
					}
				}
				
	        	bkgNtcHisVOs = command.sendDblWblByEmail(event0927.getDblwblvos(), null, account);
			} 
        	hisBC.createBkgNtcHis(bkgNtcHisVOs, uiId);
            eventResponse.setUserMessage(new ErrorHandler("").getMessage());
            commit();
        } catch(EventException ex) {
        	rollback();
            throw ex;
		} catch (Exception ex) {
            rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * Fax 전송 이벤트 처리<br>
     * Fax 전송한다.(ESM_BKG_0218,ESM_BKG_0927)<br>
     *
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse sendDblWblByFax(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = null;
        EsmBkg0218Event event0218 = null;
        EsmBkg0927Event event0927 = null;
        
        BLIssuanceBC command = null;
        BookingUtil utilBC = new BookingUtil();
        BookingHistoryMgtBC hisBC = null;
    	String uiId = null;
    	List<BkgNtcHisVO> bkgNtcHisVOs = null;
        try {
        	begin();
            eventResponse = new GeneralEventResponse();
            command = new BLIssuanceBCImpl();
            hisBC = new BookingHistoryMgtBCImpl();
			if ("EsmBkg0218Event".equalsIgnoreCase(e.getEventName())) {
				uiId = "ESM_BKG_0218";
				event0218 = (EsmBkg0218Event)e;
				
	            DblWblVO[] dblWblVOs = event0218.getDblWblVOs();
				if (dblWblVOs.length > 0) {
					for (int i=0; i<dblWblVOs.length; i++) {
						BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
						bkgBlNoVO.setBkgNo(dblWblVOs[i].getBkgNo());
						if("Y".equals(utilBC.searchNoRateBlockFlg(bkgBlNoVO))){
							throw new EventException(new ErrorHandler("BKG08334",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
						}
						if("Y".equals(utilBC.searchStandbyBlockFlg(bkgBlNoVO))){
							throw new EventException(new ErrorHandler("BKG08337",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
						}
					}
				}
				
	        	bkgNtcHisVOs = command.sendDblWblByFax(event0218.getDblWblVOs(), account);
			} else if ("EsmBkg0927Event".equalsIgnoreCase(e.getEventName())) {
            	uiId = "ESM_BKG_0927";
				event0927 = (EsmBkg0927Event)e;
				
	            DblWblVO[] dblWblVOs = event0927.getDblwblvos();
				if (dblWblVOs.length > 0) {
					for (int i=0; i<dblWblVOs.length; i++) {
						BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
						bkgBlNoVO.setBkgNo(dblWblVOs[i].getBkgNo());
						if("Y".equals(utilBC.searchNoRateBlockFlg(bkgBlNoVO))){
							throw new EventException(new ErrorHandler("BKG08334",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
						}
						if("Y".equals(utilBC.searchStandbyBlockFlg(bkgBlNoVO))){
							throw new EventException(new ErrorHandler("BKG08337",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
						}
					}
				}
				
	        	bkgNtcHisVOs = command.sendDblWblByFax(event0927.getDblwblvos(), account);
    		} 
        	hisBC.createBkgNtcHis(bkgNtcHisVOs, uiId);
            eventResponse.setUserMessage(new ErrorHandler("").getMessage());
            commit();
        } catch(EventException ex) {
        	rollback();
            throw ex;
		} catch (Exception ex) {
            rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }
    
	/**
	 * B/L Preview 화면 설정을 위한 Data를 조회한다.(ESM_BKG_0418)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse validMfForPrtByBl(Event e) throws EventException {
		EsmBkg0418Event event = (EsmBkg0418Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BookingUtil utilCmd = new BookingUtil();
		BLIssuanceBC command = new BLIssuanceBCImpl();

		VskVslPortSkdVO vskVslPortSkd = new VskVslPortSkdVO();
		
		String mode = "";
		String vvd = "";
		String port = "";
		// --- Vessel Schedule ---
		String vsl_cd = "";
		String voy_no = "";
		String dir_cd = "";
		String clpt_ind_seq = "";
		// --- Vessel Schedule ---
		String[] bkgBlNos = null;
		
		// VESSEL SKD 오류
		boolean bVesselSkd = false;
		// VVD등록 오류
		boolean bVvd = false;
		// B/L no나 BKG no 오류
		boolean bBkgBlNo = false;
		String strBkgNo = "";

		try {
			
			mode = event.getMode();
			vvd = event.getVvd();
			port = event.getPort();
			vsl_cd = event.getVslCd();
			voy_no = event.getVoyNo();
			dir_cd = event.getDirCd();
			clpt_ind_seq = event.getClptIndSeq();
			
			bkgBlNos = event.getBkgBlNos();
			
			// Vessel Schedule 조회 - searchEtbEtdEta(vslCd, voyNo, dirCd, portCd, clptlndSeq)
			// VESSEL SKD이 등록이 안 된 항차 일 경우 에러처리 - CoBkg.js ===> BKG00100
			vskVslPortSkd = utilCmd.searchEtbEtdEta(vsl_cd, voy_no, dir_cd, port, clpt_ind_seq);
			
			if (vskVslPortSkd != null) {
				//
				bVesselSkd = true;
			}
			
			// Vessel(VVD)존재체크  - validateVvdLoc(vslCd, voyNo, dirCd, locCd)
			// VVD에 등록이 안된 Calling Port일 경우 에러처리 - CoBkg.js ===> BKG00007
			if (bVesselSkd) {
				//
				if (utilCmd.validateVvdLoc(vsl_cd, voy_no, dir_cd, port)) {
					bVvd = true;
				}
			}
			
			// B/L no나 BKG no 오류체크
			// B/L no나 BKG no 오류일 경우 - CoBkg.js ===> BKG00273
			if ( bVesselSkd == true && bVvd == true && bkgBlNos != null && bkgBlNos.length > 0) {
				//
				strBkgNo = command.validBkgBlNo(mode, vvd, port, bkgBlNos);
				
				if (!strBkgNo.equals("")) {
					bBkgBlNo = strBkgNo.indexOf("Error_") == 0 ? false : true;
				}
			}
			
			eventResponse.setETCData("bVesselSkd", bVesselSkd == false ? "BKG00100": "");
			eventResponse.setETCData("bVvd", bVvd == false ? "BKG00007": "");
			eventResponse.setETCData("bBkgBlNo", bBkgBlNo == false ? "BKG00273": "");
			eventResponse.setETCData("bkgNos", strBkgNo);
			
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * searchBkgInfoForFaxEmail(ESM_BKG_0221)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchBkgInfoForFaxEmail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
        EsmBkg0221Event event = (EsmBkg0221Event)e;
    	BookingUtil util = null;
    	BkgRouteVO bkgRouteVO = null; 
    	try {
    		util = new BookingUtil();
    		bkgRouteVO = util.searchBkgRoute(event.getBkg_no());
    		if (null!=bkgRouteVO) {
    			eventResponse.setETCData("por_cd",bkgRouteVO.getPorCd());
    		}
        } catch(EventException ex) {
            throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
	}

	/**
	 * sendFaxEmailByBkgNoList(ESM_BKG_0221)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse sendFaxEmailByBkgNoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();	

        EsmBkg0221Event event = null;
        BLIssuanceBC command = null;
        BookingHistoryMgtBC hisBC = null;
    	String uiId = null;
    	List<BkgNtcHisVO> bkgNtcHisVOs = null;
    	BookingUtil utilBC = new BookingUtil();
    	try {
        	begin();
            eventResponse = new GeneralEventResponse();
            command = new BLIssuanceBCImpl();
            hisBC = new BookingHistoryMgtBCImpl();
        	uiId = "ESM_BKG_0221";
        	event = (EsmBkg0221Event)e;
        	
        	log.debug("sendFaxEmailByBkgNoList==========121212121212");
        	
        	DblWblVO[] faxDblwblvos = new DblWblVO[1];
        	
        	DblWblVO[] emlDblwblvos = new DblWblVO[1];
        	
        	if(event.getBkg_no()!=null && !"".equals(event.getBkg_no())){
				BkgBlNoVO bkgBlNoChkVO = new BkgBlNoVO();
				bkgBlNoChkVO.setBkgNo(event.getBkg_no());
				if("Y".equals(utilBC.searchNoRateBlockFlg(bkgBlNoChkVO))){
					throw new EventException(new ErrorHandler("BKG08334",new String[]{bkgBlNoChkVO.getBkgNo()}).getMessage());
				}
				if("Y".equals(utilBC.searchStandbyBlockFlg(bkgBlNoChkVO))){
					throw new EventException(new ErrorHandler("BKG08337",new String[]{bkgBlNoChkVO.getBkgNo()}).getMessage());
				}
        	}
			
        	if (!event.getDblwblvos()[0].getRcvinfo().equalsIgnoreCase("")) {
        		faxDblwblvos[0] = event.getDblwblvos()[0];
        		
        		bkgNtcHisVOs = command.sendDblWblByFax(faxDblwblvos, account);
        		if (!"N".equals(event.getDblwblvos()[0].getHistoryGubun())) {
        			hisBC.createBkgNtcHis(bkgNtcHisVOs, uiId);
        		}
        	}
        	
        	if (!event.getDblwblvos()[1].getRcveml().equalsIgnoreCase("")) {
        		emlDblwblvos[0] = event.getDblwblvos()[1];
        		if (0>emlDblwblvos[0].getBkgNo().indexOf("|")) {
	        		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
	        		bkgBlNoVO.setBkgNo(emlDblwblvos[0].getBkgNo());
	        		bkgBlNoVO = utilBC.searchBkgBlNoVO(bkgBlNoVO);
	        		emlDblwblvos[0].setBlNo(bkgBlNoVO.getBlNo());
        		}
            	bkgNtcHisVOs = command.sendDblWblByEmail(emlDblwblvos, null, account);
           		if (!"N".equals(event.getDblwblvos()[1].getHistoryGubun())) {
            		hisBC.createBkgNtcHis(bkgNtcHisVOs, uiId);
        		}
        	}
        	
            eventResponse.setUserMessage(new ErrorHandler("").getMessage());
            commit();
        } catch(EventException ex) {
        	rollback();
            throw ex;
		} catch (Exception ex) {
            rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
	}

	/**
	 * searchEmailEdit(ESM_BKG_1096)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchEmailEdit(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
        EsmBkg1096Event event = (EsmBkg1096Event)e;
        BkgEmlEdtVO bkgEmlEdtVO = null;
        BkgBlNoVO bkgBlNoVO = null;
    	BookingUtil util = null;
    	BLIssuanceBCImpl blIssuBC = new BLIssuanceBCImpl();
		List<String> bkgNoList = null;
    	String ntcKndCd = null;
    	StringBuilder subjectSb = null;
        Hashtable<String,String> templateArgs = null;
    	String template = null;
 
        String outRead = null;
		ComUserVO comUserVO = null;
		String senderMailAddr = null;
    	try {
    		util = new BookingUtil();
			comUserVO = util.searchComUserInfo(account.getUsr_id());
			String sUsrEml = null;
			if (null!=comUserVO) {
				sUsrEml = (null==comUserVO.getDfltEml() || "".equals(comUserVO.getDfltEml())) ? comUserVO.getUsrEml() : comUserVO.getDfltEml();
			}
//			String sUsrEml = util.searchComUserInfo(account.getUsr_id()).getDfltEml();
    		bkgEmlEdtVO = event.getBkgEmlEdtVO();
    		if (null!=bkgEmlEdtVO.getEdtBkgNoList() && !"".equals(bkgEmlEdtVO.getEdtBkgNoList())) {
    			bkgNoList = Arrays.asList(bkgEmlEdtVO.getEdtBkgNoList().split("\\|"));
        		ntcKndCd = bkgEmlEdtVO.getEdtNtcKndCd();
    			if (null!=bkgNoList && 0<bkgNoList.size()) {
		    		bkgBlNoVO = new BkgBlNoVO();
		    		bkgBlNoVO.setBkgNo(bkgNoList.get(0));
		    		bkgBlNoVO.setCaUsrId(account.getUsr_id());
		    		bkgBlNoVO = util.searchBkgBlNoVO(bkgBlNoVO);
		    		subjectSb = new StringBuilder();
		    		templateArgs = new Hashtable<String,String>();
		    		if ("BK".equalsIgnoreCase(ntcKndCd)) {
			    		if (1<bkgNoList.size()) {
			    			subjectSb.append("SM Line Booking Receipt Notice (BKG No : ").append(bkgNoList.get(0)).append(" and ").append(bkgNoList.size()-1).append(" bookings)");  
							templateArgs.put("bkgNoTitle", "BKG No : "+bkgEmlEdtVO.getEdtBkgNoList().replaceAll("\\|", ", "));
							templateArgs.put("bkgNoBody", bkgEmlEdtVO.getEdtBkgNoList().replaceAll("\\|", ", "));
							templateArgs.put("vslNmBody", "");
			    		} else {
			    			subjectSb.append("SM Line Booking Receipt Notice (BKG No : ").append(bkgNoList.get(0)).append(")");
							templateArgs.put("bkgNoTitle", "BKG No : "+bkgNoList.get(0));
							templateArgs.put("bkgNoBody", bkgNoList.get(0));
							String vslNm = util.searchVesselNameByBkgNo(bkgNoList.get(0)); 
							templateArgs.put("vslNmBody","- Vessel : "+vslNm);
			    		} 
						template = "ESM_BKG_0098_01T.html";
					} else if ("CN".equalsIgnoreCase(ntcKndCd)) {
						subjectSb.append("SM Line Empty Release Order (BKG No : ").append(bkgNoList.get(0)).append(")"); 
						template= "ESM_BKG_0252_01T.html";
						templateArgs.put("bkgNoTitle", "BKG No : "+bkgNoList.get(0));
						templateArgs.put("bkgNoBody", bkgNoList.get(0));
					} else if ("BL".equalsIgnoreCase(ntcKndCd) || "WB".equalsIgnoreCase(ntcKndCd) || "NN".equalsIgnoreCase(ntcKndCd)) {
			    		subjectSb.append("SM Line ");
			    		if ("BL".equalsIgnoreCase(ntcKndCd)) {
			    			subjectSb.append("Draft B/L(s)");
							template = "ESM_BKG_0218_01T.html";
			    		} else if ("WB".equalsIgnoreCase(ntcKndCd)) {
			    			subjectSb.append("Sea Waybills");
							template = "ESM_BKG_0218_02T.html";
			    		} else if ("NN".equalsIgnoreCase(ntcKndCd)) {
			    			subjectSb.append("B/L Copy");
							template = "ESM_BKG_0218_03T.html";
			    		}
			    		if (1<bkgNoList.size()) {
			    			subjectSb.append(" (B/L No : ").append(bkgBlNoVO.getBlNo()).append(" and ").append(bkgNoList.size()-1).append(" B/Ls)");
							templateArgs.put("blNoTitle", "B/L No : "+bkgBlNoVO.getBlNo()+" and "+(bkgNoList.size()-1)+" B/Ls");
			    			StringBuilder sb = new StringBuilder();
			    			for (String bkgNo : bkgNoList) {
					    		bkgBlNoVO = new BkgBlNoVO();
					    		bkgBlNoVO.setBkgNo(bkgNo);
					    		bkgBlNoVO.setCaUsrId(account.getUsr_id());
					    		bkgBlNoVO = util.searchBkgBlNoVO(bkgBlNoVO);
					    		sb.append(bkgBlNoVO.getBlNo()).append(", ");
			    			}
	    					sb.delete(sb.lastIndexOf(","), sb.length());
							templateArgs.put("blNoBody", sb.toString());
			    		} else {
			    			subjectSb.append(" (B/L No : ").append(bkgBlNoVO.getBlNo()).append(")");
							templateArgs.put("blNoTitle", "B/L No : "+bkgBlNoVO.getBlNo());
							templateArgs.put("blNoBody", bkgBlNoVO.getBlNo());
			    		}
					} else if ("SN".equalsIgnoreCase(ntcKndCd) || "HI".equalsIgnoreCase(ntcKndCd) || "HO".equalsIgnoreCase(ntcKndCd)) {
						if ("SN".equalsIgnoreCase(ntcKndCd)) {
							subjectSb.append("SM Line O.B/L Surrender Notice [B/L No : "+bkgBlNoVO.getBlNo()+"]");
							template = "ESM_BKG_0095_01T.html";
							templateArgs.put("blNo",bkgBlNoVO.getBlNo());
						} else if ("HI".equalsIgnoreCase(ntcKndCd) || "HO".equalsIgnoreCase(ntcKndCd)) {
							subjectSb.append("SM Line TRO Notice [B/L No : "+bkgBlNoVO.getBlNo()+"]");
							template = "ESM_BKG_0095_02T.html";
							templateArgs.put("blNo",bkgBlNoVO.getBlNo());
						}
					} else if ("SS".equalsIgnoreCase(ntcKndCd)) {
						subjectSb.append("SM Line Simple S/I [B/L No : "+bkgBlNoVO.getBlNo()+"]");
						template = "ESM_BKG_0095_03T.html";
						templateArgs.put("blNo",bkgBlNoVO.getBlNo());
	    			} else if ("RR".equalsIgnoreCase(ntcKndCd)){
	    				String vslNm = blIssuBC.searchVesselNameByBkgNo(bkgBlNoVO.getBkgNo());
						subjectSb.append("Draft B/L - Revised Rate (T/VVD : ").append(vslNm).append(" / B/L No : ").append(bkgBlNoVO.getBlNo()).append(")");
						template = "ESM_BKG_0095_04T.html";
						//templateArgs.put("blNoTitle", "B/L No : "+bkgBlNoVO.getBlNo());
						templateArgs.put("blNoTitle", "T/VVD : "+vslNm+" / B/L No : "+bkgBlNoVO.getBkgNo());
						templateArgs.put("blNo",bkgBlNoVO.getBlNo());
	    			} else if ("UR".equalsIgnoreCase(ntcKndCd)||"DR".equalsIgnoreCase(ntcKndCd)){
			    		subjectSb.append("SM Line ");
			    		if ("UR".equalsIgnoreCase(ntcKndCd)) {
			    			subjectSb.append("AES/CAED Reminder(s)");
							template = "ESM_BKG_0095_10T.html";
			    		} else if ("DR".equalsIgnoreCase(ntcKndCd)) {
			    			subjectSb.append("Doc cut-off Reminder(s)");
							template = "ESM_BKG_0095_09T.html";
			    		}
			    		
			    		if (1<bkgNoList.size()) {
			    			subjectSb.append(" (B/L No : ").append(bkgBlNoVO.getBlNo()).append(" and ").append(bkgNoList.size()-1).append(" B/Ls)");
							templateArgs.put("blNoTitle", bkgBlNoVO.getBlNo()+" and "+(bkgNoList.size()-1)+" B/Ls");
			    			StringBuilder sb = new StringBuilder();
			    			for (String bkgNo : bkgNoList) {
					    		bkgBlNoVO = new BkgBlNoVO();
					    		bkgBlNoVO.setBkgNo(bkgNo);
					    		bkgBlNoVO.setCaUsrId(account.getUsr_id());
					    		bkgBlNoVO = util.searchBkgBlNoVO(bkgBlNoVO);
					    		sb.append(bkgBlNoVO.getBlNo()).append(", ");
			    			}
	    					sb.delete(sb.lastIndexOf(","), sb.length());
							templateArgs.put("blNoBody", sb.toString());
			    		} else { 
			    			subjectSb.append(" (B/L No : ").append(bkgBlNoVO.getBlNo()).append(")");
							templateArgs.put("blNoTitle", bkgBlNoVO.getBlNo());
							templateArgs.put("blNoBody", bkgBlNoVO.getBlNo());
			    		}

//	    				String vslNm = blIssuBC.searchVesselNameByBkgNo(bkgBlNoVO.getBkgNo());
	    				SearchReminderEmailVO emailvo = blIssuBC.searchReminderEmail(bkgBlNoVO.getBkgNo());
						templateArgs.put("vslNm",emailvo.getVslNm()); 
						templateArgs.put("etd",emailvo.getEtdDt());
						templateArgs.put("date",emailvo.getDocClzDt());
						templateArgs.put("time",emailvo.getDocClzTm());
						if("UR".equalsIgnoreCase(ntcKndCd)){
							if("US".equalsIgnoreCase(emailvo.getCntCd())){
								templateArgs.put("url","http://www.smlines.com/hanjin/CUP_HOM_3058.do?sessLocale=en");
							}else{
								templateArgs.put("url","http://www.smlines.com/hanjin/CUP_HOM_3252.do?sessLocale=en");
							}

						}
	    			}

		    		
					/* group mail 추가 */
					senderMailAddr = util.searchGroupEmailAddrRSQL(bkgBlNoVO.getBlNo(), account.getUsr_id(), "EM", "BL");

	                outRead = FileUtils.fileReader(SiteConfigFactory.getWhenNullThrowException("COM.HANJIN.JAF.MAIL.TEMPLATE.DIR"), template);  // 2011.07.19 changed using FileUtils
	                
	                bkgEmlEdtVO.setEdtCcEml(util.searchCcEmailAddrRSQL(ntcKndCd, account.getUsr_id()));
//	                bkgEmlEdtVO.setEdtFromEml(account.getUsr_eml());
	                sUsrEml = (null==senderMailAddr || "".equals(senderMailAddr)) ? sUsrEml : senderMailAddr;
	                bkgEmlEdtVO.setEdtFromEml(sUsrEml);
	                bkgEmlEdtVO.setEdtSubject(subjectSb.toString());
	                bkgEmlEdtVO.setEdtContents(parseTemplate(outRead.toString(),templateArgs));
	                bkgEmlEdtVO.setFntRcvEml(util.searchFntEmailAddrRSQL(bkgBlNoVO.getBkgNo()));
    			}
    		} else if ("AN".equalsIgnoreCase(bkgEmlEdtVO.getEdtNtcKndCd())) {
                subjectSb = new StringBuilder();
                templateArgs = new Hashtable<String,String>();

                      subjectSb.append("SM Line Simple Arrival Notice");
                      template = "ESM_BKG_0381_02T.html";

           outRead = FileUtils.fileReader(SiteConfigFactory.getWhenNullThrowException("COM.HANJIN.JAF.MAIL.TEMPLATE.DIR"), template);  
           bkgEmlEdtVO.setEdtSubject(subjectSb.toString());
           bkgEmlEdtVO.setEdtContents(parseTemplate(outRead.toString(),templateArgs));
           }
            eventResponse.setRsVo(bkgEmlEdtVO);
        } catch(EventException ex) {
            throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
	}

	/**
	 * parseTemplate(ESM_BKG_1096)
	 * template email 을 미리 읽어오기 위해 TemplateMail class에서 가져옴
	 * 
     * @param String s
     * @param Hashtable<String,String> args
     * @return String
     * @exception Exception
	 */
    private String parseTemplate(String s,Hashtable<String,String> args) throws Exception {
        StringBuffer content = new StringBuffer();
        String remainder;
        int markEndPos;
        for(; s.length() > 0; s = remainder.substring(markEndPos + 1)) {
            int position = s.indexOf("<@");
            if(position == -1) {
                content.append(s);
                break;
            }
            if(position != 0) {
                content.append(s.substring(0, position));
            }
            if (s.length() == position + 2) {
                break;
            }
            remainder = s.substring(position + 2);
            markEndPos = remainder.indexOf(">");
            if(markEndPos == -1) {
                break;
            }
            String argname = remainder.substring(0, markEndPos).trim();
            String value = null;
            value = (String)args.get(argname);
            if (value != null) {
                content.append(value);
            }
            if (remainder.length() == markEndPos + 1) {
                break;
            }
        }
        return content.toString();
    }
    
    /**
	 * ESM_BKG_1116 : 조회<br>
	 * e-B/L Issue 대상 조회<br>
	 * 
	 * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchEBLIssueList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg1116Event event = (EsmBkg1116Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLIssuanceBC command = new BLIssuanceBCImpl();

		try {												
			List<EBLIssueVO> list = command.searchEBLIssueList(event.getEBLIssueInputVO());
			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_1118 : Auth<br>
	 * e-B/L Issue 대상 Auth<br>
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageEBLIssue(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();
		EsmBkg1118Event event = (EsmBkg1118Event) e;
		String bkgNo = event.getBkg_no();
		String srStsCd = event.getSrStsCd();
		String hiddenData = "";
		String rate = "";
		
		try {
			hiddenData = event.getHiddenData();			
			rate = event.getFormLevel() == null || event.getFormLevel().equals("") ? "1" : event.getFormLevel();
			
			begin();
			command.manageEBLIssue( bkgNo, srStsCd, rate, hiddenData, account);
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06014").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_1118 : Auth<br>
	 * e-B/L Issue 대상 Auth<br>
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageEBLReIssue(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();
		EsmBkg1118Event event = (EsmBkg1118Event) e;
		String bkgNo = event.getBkg_no();
		String srStsCd = event.getSrStsCd();
		String hiddenData = "";
		String rate = "";
		
		try {
			hiddenData = event.getHiddenData();			
			rate = event.getFormLevel() == null || event.getFormLevel().equals("") ? "1" : event.getFormLevel();
			
			begin();
			command.manageEBLReIssue( bkgNo, srStsCd, rate, hiddenData, account);
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06014").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * B/L Preview 화면 설정을 위한 Data를 조회한다.(ESM_BKG_1118)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchBlInfoForEBLIssue(Event e) throws EventException {
		EsmBkg1118Event event = (EsmBkg1118Event) e;
		GeneralEventResponse eventResponse = null;

		BookingUtil utilCmd = null;
		BLIssuanceBC command = null;
		GeneralBookingReceiptBC receiptBC = null;

		BkgBlNoVO bkgBlNoIN = null;
		BookingCreationVO bookingCreationVO = null;

		String bkg_no = "";
		String bl_no = "";
		String bl_tp_cd = "";
		String hiddenData = "";
		String rate = "";
		String cntr = "";
		String rider_yn = "";
//		String houseBl_yn = "";
		String[] hbl = new String[2];
		String corr_no = "";
		String email = "";
		String fax_no = "";
		String obl_iss_flg = "";

		try {
			eventResponse = new GeneralEventResponse();
			utilCmd = new BookingUtil();
			command = new BLIssuanceBCImpl();
			receiptBC = new GeneralBookingReceiptBCImpl();

			// searchBkgBlNo
			bkgBlNoIN = new BkgBlNoVO();
			bkgBlNoIN.setBkgNo(event.getBkg_no());
			bkgBlNoIN.setBlNo(event.getBl_no());
			bkgBlNoIN.setCaUsrId(account.getUsr_id());
			BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
			
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new EventException(new ErrorHandler("BKG01049", new String[] { event.getBkg_no() }).getMessage());
			}
			bookingCreationVO = receiptBC.searchBooking(bkgBlNoVO);
			for (BkgCntcPsonVO vo : bookingCreationVO.getBkgCntcPson()) {
				if ("SI".equalsIgnoreCase(vo.getBkgCntcPsonTpCd())) {
					fax_no = vo.getCntcPsonFaxNo();
					email = vo.getCntcPsonEml();
					break;
				}
			}

			bkg_no = bkgBlNoVO.getBkgNo(); // bkg_no
			bl_no = bkgBlNoVO.getBlNo(); // bl_no
			bl_tp_cd = bkgBlNoVO.getBlTpCd(); // bl_tp_cd
			hiddenData = event.getHiddenData();
			
			rate = event.getFormLevel() == null || event.getFormLevel().equals("") ? "1" : event.getFormLevel();
			cntr = event.getForm_Cntr() == null || event.getForm_Cntr().equals("") ? "1" : event.getForm_Cntr();
			corr_no = event.getForm_corr_no();

			rider_yn = command.searchRiderYn(bkg_no, hiddenData, rate, cntr, corr_no);
			hbl = command.searchHouseBlYn(bkg_no);
			obl_iss_flg = command.searchOblIssFlg(bkg_no);

			eventResponse.setETCData("bkg_no", bkg_no);
			eventResponse.setETCData("bl_no", bl_no);
			eventResponse.setETCData("bl_tp_cd", bl_tp_cd);
			eventResponse.setETCData("rider_yn", rider_yn);
			eventResponse.setETCData("houseBl_yn", hbl[0]);
			eventResponse.setETCData("hbl_tp", hbl[1]);
			eventResponse.setETCData("fax_no", fax_no);
			eventResponse.setETCData("email", email);
			eventResponse.setETCData("obl_iss_flg", obl_iss_flg);
			if (null!=bookingCreationVO && null!=bookingCreationVO.getBkgBookingInfoVO()) {
				eventResponse.setETCData("por_cd",bookingCreationVO.getBkgBookingInfoVO().getBkgPorCd());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_1117 : Reject<br>
	 * e-B/L Issue 대상 Reject<br>
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageEBLReject(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();
		EsmBkg1117Event event = (EsmBkg1117Event) e;
		String bkgNo = event.getBkgNo();
		String srStsCd = event.getSrStsCd();
		String remark = event.getRemark();
		try {
			begin();
			command.manageEBLReject( bkgNo, srStsCd, remark, account);
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06014").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_1116 : Confirm<br>
	 * e-B/L Issue 대상 Confirm<br>
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageEBLConfirm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();
		EsmBkg1116Event event = (EsmBkg1116Event) e;
		try {			
			begin();
			command.manageEBLConfirm( event.getEBLIssueVOs()[0].getBkgNo(), account);
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06014").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_1116 : DELConfirm<br>
	 * e-B/L Issue 대상 DELConfirm<br>
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageDelConfirm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();
		EsmBkg1116Event event = (EsmBkg1116Event) e;
		try {			
			begin();
			command.manageDelConfirm( event.getEBLIssueVOs()[0].getBkgNo(), account);
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06014").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_BKG_1116 : Confirm<br>
	 * e-B/L Issue 대상 Confirm<br>
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageConfirm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();
		EsmBkg1116Event event = (EsmBkg1116Event) e;
		try {			
			begin();
			command.manageConfirm( event.getEBLIssueVOs()[0].getBkgNo(), account);
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06014").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_1133 : Bangladesh ODCY로부터의 파일을 일정 형식으로 Upload시키는 화면.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
    private EventResponse searchBkgCustShpRqstList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg1133Event event = (EsmBkg1133Event) e;
        
        BLDocumentationCMBC command = new BLDocumentationCMBCImpl();
        List<BkgCustShpRqstVO> list = command.searchBkgCustShpRqstList(event.getBkgCustShpRqstVO());
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        eventResponse.setRsVoList(list);

        return eventResponse;
    }
    /**
     * ESM_BKG_1133 : 화면 수정/저장/삭제 이벤트 발생시 처리 <br>
     * 방글라데시 ODCY로부터의 파일을 일정 형식으로 저장  (ESM_BKG_1133)<br>
     * 
     * @param e EsmBkg1133Event
     * @return response EventResponse
     * @exception EventException
     */

   private EventResponse manageBkgCustShpRqst(Event e) throws EventException {
    	
    	GeneralEventResponse eventResponse = new GeneralEventResponse();      
    	EsmBkg1133Event event = (EsmBkg1133Event) e;
    	BLDocumentationCMBC command = new BLDocumentationCMBCImpl();
    	                                 
       try {
            begin();
           
            BkgCustShpRqstVO[] bkgCustShpRqstVOs = event.getBkgCustShpRqstVOs();
            command.manageBkgCustShpRqst(bkgCustShpRqstVOs,account);                                            
            eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
            commit();
        } catch(EventException ex) {
 			rollback();
 			log.error("err " + ex.toString(), ex);
 			throw ex;
 		} catch(Exception ex) {
 			rollback();
 			log.error("err " + ex.toString(), ex);
 			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
 		}
        return eventResponse;
    }
   
   /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_1134 : Bangladesh ODCY 화면에서 Upload 한 파일을 CNTR별로 대조하여 데이터.<br>
	 * 인터페이스하는 화면
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
   private EventResponse searchBkgCntrShpRqst(Event e) throws EventException {
       
       EsmBkg1134Event event = (EsmBkg1134Event) e;
       
       BLDocumentationCMBC command = new BLDocumentationCMBCImpl();
       List<BkgCustShpRqstVO> list = command.searchBkgCntrShpRqst(event.getBkgCustShpRqstVO());
       GeneralEventResponse eventResponse = new GeneralEventResponse();
       eventResponse.setRsVoList(list);

       return eventResponse;
   }
   
	/**
	 * WEB_004_0001 : MULTI01<br>
	 * WebService EAI(WEB_004_0001)<br>
	 * 한진해운 홈페이지에서 OBL 출력시 ALPS에 출력정보 업데이트<br>
	 * @author Jong-ho Kim
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyWeb0040001ControlMgmt(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		EsmBkgWeb0040001Event event = null;
		BLIssuanceBC command = null;
		try{
			eventResponse = new GeneralEventResponse();
			event = (EsmBkgWeb0040001Event)e;
			command = new BLIssuanceBCImpl();
			begin();
			BkgWebService004VO webVO = event.getBkgWebService004VO();

			command.modifyWeb0040001Control(webVO);
			
			// 성공메시지세팅
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}

		return eventResponse;
	}
	

	/**
	 * WEB_005_0001 : MULTI01<br>
	 * WebService EAI(WEB_005_0001)<br>
	 * 한진해운 홈페이지에서 객장 B/L 발급 요청시 해당 정보를 ALPS 로 I/F<br>
	 * @author Jong-ho Kim
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyWeb0050001ControlMgmt(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		EsmBkgWeb0050001Event event = null;
		BLIssuanceBC command = null;
		try{
			eventResponse = new GeneralEventResponse();
			event = (EsmBkgWeb0050001Event)e;
			command = new BLIssuanceBCImpl();
			begin();
			BkgWebService005VO webVO = event.getBkgWebService005VO();
			
			command.modifyWeb0050001Control(webVO);
			
			// 성공메시지세팅
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}

		return eventResponse;
	}


	/**
	 * ESM_BKG_1119
	 * Retrieve버튼 클릭시 Data를 조회한다.
	 * @author Jong-ho Kim
     * @param Evente e
     * @return EventResponse
     * @exception Exception
	 */
    private EventResponse searchBlIssRqstList(Event e) throws EventException {
		EsmBkg1119Event event = (EsmBkg1119Event) e;
		GeneralEventResponse eventResponse = null;

		BLIssuanceBC command = null;
		BlIssRqstVO blIssRqstVO = null;

		try {
			blIssRqstVO = event.getBlIssRqstVO();
			eventResponse = new GeneralEventResponse();
			command = new BLIssuanceBCImpl();
			List<BlIssRqstVO> blIssRqstVOs= command.searchBlIssRqstList(blIssRqstVO);
			
			eventResponse.setRsVoList(blIssRqstVOs);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }
    
	/**
	 * ESM_BKG_1119_01
	 * B/L 발급 신청 명세 화면 설정을 위한 Data를 조회한다.
	 * @author Jong-ho Kim
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchBlIssRqstInquiry(Event e) throws EventException {
		EsmBkg1119Event event = (EsmBkg1119Event) e;
		GeneralEventResponse eventResponse = null;

		BLIssuanceBC command = null;
		//BlIssRqstVO blIssRqstVO = null;
		String xterRqstNo = "";
		String xterRqstSeq = "";

		try {
			eventResponse = new GeneralEventResponse();
			command = new BLIssuanceBCImpl();
			xterRqstNo = event.getBlIssRqstVO().getXterRqstNo();
			xterRqstSeq = event.getBlIssRqstVO().getXterRqstSeq();
			
			BlIssRqstVO blIssRqstVO = null;
			blIssRqstVO = command.searchBlIssRqstInquiry(xterRqstNo, xterRqstSeq);
			eventResponse.setRsVo(blIssRqstVO);
			eventResponse.setCustomData("blIssRqstVO", blIssRqstVO);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_1119
	 * B/L 발급 신청 리스트 화면에서 Delete버튼을 클릭했을 때 delt_flg값을 'Y'으로 Update한다.
	 * @author Jong-ho Kim
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse modifyBlIssRqstDeltFlg(Event e) throws EventException {
		EsmBkg1119Event event = (EsmBkg1119Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLIssuanceBC command = new BLIssuanceBCImpl();

		try {
			begin();
			command.modifyBlIssRqstDeltFlg(event.getBlIssRqstVOs(), account.getUsr_id());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_1119_01
	 * B/L 발급 신청 상세 화면에서 Approval 버튼을 클릭했을 때 remark를 Update한다.
	 * @author Jong-ho Kim
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse modifyBlIssRqstApproval(Event e) throws EventException {
		EsmBkg1119Event event = (EsmBkg1119Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();

		try {
			begin();
			log.debug("@@@@@@ OutboundBLMgtSC : modifyBlIssRqstApproval");
			// B/L 발급 승인 처리
			command.modifyBlIssRqstApproval(event.getBlIssRqstVO(), account.getUsr_id());

			log.debug("@@@@@@ OutboundBLMgtSC : sendBlIssRqstByMail");
			// B/L 발급 사실을 email로 발송 후 발송 내역을 history에 기록
			command.sendBlIssRqstByMail(event.getBkgBlIssRqstMailSndVO(), account);
			
			commit();
			
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_1119_01
	 * B/L 발급 신청 상세 화면에서 Reject버튼을 클릭했을 때 remark를 Update한다.
	 * @author Jong-ho Kim
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse modifyBlIssRqstReject(Event e) throws EventException {
		EsmBkg1119Event event = (EsmBkg1119Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();

		try {
			begin();
			command.modifyBlIssRqstReject(event.getBlIssRqstVO(), account.getUsr_id());
			commit(); 
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
		
	/**
	 * UI_BKG_1119조회화면의 COMBO 값 조회(공통 CODE 조회)<br>
	 * @author Jong-ho Kim
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode1119(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			BookingUtil comboUtil = new BookingUtil();

			// Handling Status의 값 리스트 얻기
			List<BkgComboVO> bl_iss_sts_cd = comboUtil.searchCombo("CD02807");
			// B/L TYPE의 값 리스트 얻기
			List<BkgComboVO> rqst_bl_tp_cd = comboUtil.searchCombo("CD02808");
			// B/L TYPE의 값 리스트 얻기
			List<BkgComboVO> bl_iss_rqst_cd = comboUtil.searchCombo("CD03278");
			//리스트에 "All"항목 추가하기
			BkgComboVO combovo = new BkgComboVO();
			combovo.setDesc("All");
			combovo.setVal("All");
			combovo.setName("All");
			bl_iss_sts_cd.add(0,combovo);
			rqst_bl_tp_cd.add(0,combovo);
			bl_iss_rqst_cd.add(0,combovo);

			eventResponse.setRsVoList(bl_iss_sts_cd);
			eventResponse.setRsVoList(rqst_bl_tp_cd);
			eventResponse.setRsVoList(bl_iss_rqst_cd);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	

	
	/**
	 * O/BL을 Release 한다.(ESM_BKG_0079_09)
	 * O/BL Release 처리시 LBP Charge 정보가 존재하는지 체크한다.<br>
    * 
    * @param e Event
    * @return EventResponse
    * @exception EventException
	 */
	private EventResponse searchSurchargeRatingByLbp(Event e) throws EventException {
		log.debug("[START:: SurchargeAutoRatingBC == searchSurchargeRatingByLbp ]==========");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmBkg007909Event event = (EsmBkg007909Event) e;
		String bkgNo = event.getBkg_no();
				
		 // O/BL Release 처리시 LBP Charge 정보가 존재할 경우 LBP Charge 항목을 추가한다. 추가 여부를 알기위한 flg 값 조회 
		SurchargeAutoRatingBC surAutoRaingBC = new SurchargeAutoRatingBCImpl();
		SearchChgRateByLBPVO searchChgRateByLBPVO = surAutoRaingBC.searchSurchargeRatingByLbp(bkgNo, account); 
		eventResponse.setRsVo(searchChgRateByLBPVO);
		eventResponse.setCustomData("searchChgRateByLBPVO", searchChgRateByLBPVO);
		
		if(searchChgRateByLBPVO != null){

			eventResponse.setETCData("curr_cd", searchChgRateByLBPVO.getCurrCd());
			eventResponse.setETCData("scg_amt", searchChgRateByLBPVO.getScgAmt());
		}
		
		log.debug("[end:: SurchargeAutoRatingBC == searchSurchargeRatingByLbp ]==========");
		return eventResponse;
	}
	
	/**
     * Email(S/R) 전송 이벤트 처리<br>
     * Email(S/R) 전송한다.(ESM_BKG_0218)<br>
     *
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse sendSrEmail(Event e) throws EventException {
        GeneralEventResponse eventResponse = null;
        EsmBkg0218Event event0218 = null;
        BLIssuanceBC command = null;
        BookingHistoryMgtBC hisBC = null;
    	String uiId = null;
    	List<BkgNtcHisVO> bkgNtcHisVOs = null;
        try {
        	begin();
            eventResponse = new GeneralEventResponse();
            command = new BLIssuanceBCImpl();
            hisBC = new BookingHistoryMgtBCImpl();
			if ("EsmBkg0218Event".equalsIgnoreCase(e.getEventName())) {
				uiId = "ESM_BKG_0218";
				event0218 = (EsmBkg0218Event)e;
	        	bkgNtcHisVOs = command.sendSrEmail(event0218.getDblWblVOs(), account);
			}  
        	hisBC.createBkgNtcHis(bkgNtcHisVOs, uiId);
            eventResponse.setUserMessage(new ErrorHandler("").getMessage());
            commit();
        } catch(EventException ex) {
        	rollback();
            throw ex;
		} catch (Exception ex) {
            rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }
	
	/**
     * Email(E/Q) 전송 이벤트 처리<br>
     * Email(E/Q) 전송한다.(ESM_BKG_0218)<br>
     *
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse sendEqEmail(Event e) throws EventException {
        GeneralEventResponse eventResponse = null;
        EsmBkg0218Event event0218 = null;
        BLIssuanceBC command = null;
        BookingHistoryMgtBC hisBC = null;
    	String uiId = null;
    	List<BkgNtcHisVO> bkgNtcHisVOs = null;
        try {
        	begin();
            eventResponse = new GeneralEventResponse();
            command = new BLIssuanceBCImpl();
            hisBC = new BookingHistoryMgtBCImpl();
			if ("EsmBkg0218Event".equalsIgnoreCase(e.getEventName())) {
				uiId = "ESM_BKG_0218";
				event0218 = (EsmBkg0218Event)e;
	        	bkgNtcHisVOs = command.sendEqEmail(event0218.getDblWblVOs(), account);
			}  
        	hisBC.createBkgNtcHis(bkgNtcHisVOs, uiId);
            eventResponse.setUserMessage(new ErrorHandler("").getMessage());
            commit();
        } catch(EventException ex) {
        	rollback();
            throw ex;
		} catch (Exception ex) {
            rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
    }
	
   	/**
	 * booking creation, split, c/a confirm시 실행된다<br>
	 * VVD 변경시 spcl Cargo 재 request 처리<br>
	 *
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param ScgVvdAproRqstVO[] inputScgVvdVOs
	 * @return 		String
	 * @exception 	EventException
	 */
	private String reRequestSpclCgoApproval(BkgBlNoVO bkgBlNoVO) throws EventException {
		try{
			String result = "Not Request";
			GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();			
			ScgAproRqstVO[] scgAproRqstVOs = searchBC.searchBkgForSpclRqst(bkgBlNoVO, null, account);
			ScgVvdAproRqstVO[] scgVvdVOs = null;
			// spcl cgo가 있을 때만 처리
	        if(scgAproRqstVOs.length>0){
				OwnDangerousCargoApprovalBC spclAproBC    = new OwnDangerousCargoApprovalBCImpl();
				SpecialCargoReceiptBC 	    spclReceiptBC = new SpecialCargoReceiptBCImpl();
				PartnerLinesDangerousCargoApprovalBCImpl spclRqstBC = new PartnerLinesDangerousCargoApprovalBCImpl();
				
				SpclCgoAproApplVO           spclCgoAproVO = new SpclCgoAproApplVO();
				try {
					scgVvdVOs = spclReceiptBC.searchBkgVvd(bkgBlNoVO.getBkgNo());
			        
			        boolean isDg = false;
					for(int i=0;i<scgAproRqstVOs.length;i++){
						if ("DG".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //DG
							isDg = true;
							break;
						}
					}
					
					//target lane일 경우 
					if(scgVvdVOs.length>0){						
						//danger가 있을 경우 
						if(isDg){
							for(int vvdIdx=0; vvdIdx<scgVvdVOs.length; vvdIdx++){
								/********************************************************************************************************************************************
								 * cf.) 
								 * PreRestrictionInputVO preRestrictionInputVO = new PreRestrictionInputVO();
								 * preRestrictionInputVO.setBkgNo("ATLX1210006");
								 * preRestrictionInputVO.setVslCd("HNBR");
								 * preRestrictionInputVO.setSkdVoyNo("0039");
								 * preRestrictionInputVO.setSkdDirCd("E");
								 * PreRestrictionOutputVO chkRslt = checkPreRestriction(preRestrictionInputVO, false, true, true);
								 * boolean segRslt = chkRslt.getSegChkRslt();														//Result of Segregation Validation
								 * boolean vslRslt = chkRslt.getVslChkRslt();														//Result of Vessel Operator’s Prohibition
								 * boolean prtRslt = chkRslt.getPrtChkRslt();														//Result of Port Prohibition En-route
								 * List<PreRestrictionSegregationVO>    segRsltDtl = chkRslt.getPreRestrictionSegregationVOs();		//Detail of Segregation Validation
								 * List<PreRestrictionVesselOperatorVO> vslRsltDtl = chkRslt.getPreRestrictionVesselOperatorVOs();	//Detail of Vessel Operator’s Prohibition
								 * List<PreRestrictionPortVO>           prtRsltDtl = chkRslt.getPreRestrictionPortVOs();			//Detail of Port Prohibition En-route
								 ********************************************************************************************************************************************/
								PreRestrictionInputVO preRestrictionInputVO = new PreRestrictionInputVO();
								preRestrictionInputVO.setBkgNo(bkgBlNoVO.getBkgNo());
								preRestrictionInputVO.setVslCd(scgVvdVOs[vvdIdx].getVslCd());
								preRestrictionInputVO.setSkdVoyNo(scgVvdVOs[vvdIdx].getSkdVoyNo());
								preRestrictionInputVO.setSkdDirCd(scgVvdVOs[vvdIdx].getSkdDirCd());
								preRestrictionInputVO.setInnerPreRestrictionInputVO(preRestrictionInputVO);
								PreRestrictionOutputVO chkRslt = spclRqstBC.checkPreRestriction(preRestrictionInputVO, false, true, true, true);
								
								boolean segRslt = chkRslt.getSegChkRslt();														//Result of Segregation Validation
								boolean vslRslt = chkRslt.getVslChkRslt();														//Result of Vessel Operator’s Prohibition
								boolean prtRslt = chkRslt.getPrtChkRslt();														//Result of Port Prohibition En-route
			//					List<PreRestrictionSegregationVO>    segRsltDtl = chkRslt.getPreRestrictionSegregationVOs();	//Detail of Segregation Validation
								List<PreRestrictionVesselOperatorVO> vslRsltDtl = chkRslt.getPreRestrictionVesselOperatorVOs();	//Detail of Vessel Operator’s Prohibition
								List<PreRestrictionPortVO>           prtRsltDtl = chkRslt.getPreRestrictionPortVOs();			//Detail of Port Prohibition En-route
								
			//					pre check에서 걸렸을 때 spcl request 상태로 변경한다.
								if(segRslt == true || vslRslt == true || prtRslt == true){
									result = "pre-checking";
									String spclRqstDesc = "After implementation pre-checking routines at T/S port, found some conflicts or prohibitions.\n" +
														  "Please check the conflicts or prohibitions.";
									if(vslRsltDtl.size()>0){
										for(int vslIdx=0; vslIdx<vslRsltDtl.size(); vslIdx++){
											spclReceiptBC.modifyDgSpclRqstByVvdChange(bkgBlNoVO, spclRqstDesc, vslRsltDtl.get(vslIdx).getSpclCgoSeq(), account);
										}
									}
									
									if(prtRsltDtl.size()>0){
										for(int prtIdx=0; prtIdx<prtRsltDtl.size(); prtIdx++){
											spclReceiptBC.modifyDgSpclRqstByVvdChange(bkgBlNoVO, spclRqstDesc, prtRsltDtl.get(prtIdx).getSpclCgoSeq(), account);
										}
									}
								}
							}
						}
						
			        	// bkg update, c/a confirm시 pre checking에 걸리면 전송 불필요 
						spclCgoAproVO.setBkgNo(bkgBlNoVO.getBkgNo());
						spclCgoAproVO.setAccount(account);
						spclCgoAproVO.setCreUsrId(account.getUsr_id());
						spclCgoAproVO.setUpdUsrId(account.getUsr_id());
						spclCgoAproVO.setSpclReqInVOs(searchBC.searchSpclReqInVO(bkgBlNoVO));
						
						for(int i=0;i<scgAproRqstVOs.length;i++){
							if ("DG".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //DG
								spclCgoAproVO.setSpclCgoTp("D");
								spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);	
							}else if ("RF".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //RF
								spclCgoAproVO.setSpclCgoTp("R");
								spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);
							}else if ("AK".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //AK
								spclCgoAproVO.setSpclCgoTp("A");
								spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);
							}else if ("BB".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //BB
								spclCgoAproVO.setSpclCgoTp("B");
								spclReceiptBC.manageSpclCgoApro(spclCgoAproVO);
							}	
						}		
		
						//SCG 모듈 호출		        
				        for(int i=0;i<scgAproRqstVOs.length;i++){
				        	ScgAproRqstVO[] scgAproRqstVO = new ScgAproRqstVO[1];
				        	scgAproRqstVO[0] = scgAproRqstVOs[i];
							if ("DG".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //DG
						        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
							}else if ("RF".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //RF
						        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
							}else if ("AK".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //AK
						        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
							}else if ("BB".equals(scgAproRqstVOs[i].getSpclCgoCateCd())){ //BB
						        spclAproBC.requestSpecialCargoApproval(scgAproRqstVO, scgVvdVOs, account);
							}	
				        }
		        	}
				} catch (Exception se){
			        log.error(se.toString(), se);					
				}
	        }
	        return result;
	    }catch(EventException ex){
	        log.error(ex.toString());
	    	throw ex;
	    }catch(Exception ex){
	        log.error(ex.toString());
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
	    }
	}
	
	/**
	 * 진행중인 C/A가 있는지 확인한다.<br>
	 * 
	 * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse checkCaProcessing(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EsmBkg007909Event event = (EsmBkg007909Event) e;
		String bkg_no = event.getBkg_no();
		
		// 진행중인 CA가 있는지 확인한다.
		BDRCorrectionBC 		bDRCorrectionBC = new BDRCorrectionBCImpl();
		BkgBlNoVO bkgBlNoVo = new BkgBlNoVO();
		bkgBlNoVo.setBkgNo(bkg_no);
		try {
			if(!bDRCorrectionBC.checkCaProcessing(bkgBlNoVo, account)) {
				Map<String,String> etcData = new HashMap<String,String>();
				etcData.put("CaProcessing", "BKG95053");
				eventResponse.setETCData(etcData); 
				return eventResponse;
			}
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Bkg Hard Coding 데이타 확인.<br>
	 * 
	 * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse checkBkgHrdCdgCtnt0079(Event e) throws EventException {
		
		GeneralEventResponse	eventResponse = new GeneralEventResponse();
		BookingUtil				command= new BookingUtil();
		EsmBkg007909Event event = (EsmBkg007909Event) e;
		
//		String bkg_no = event.getBkg_no();
		String hrdCdgId  = event.getHrdCdgId();
		String attrCtnt1 = event.getAttrCtnt1();
		String attrCtnt2 = event.getAttrCtnt2();
		String attrCtnt3 = event.getAttrCtnt3();
		
		// Bkg Hard Coding 데이타 확인.
		BkgHrdCdgCtntVO ctntVo = new BkgHrdCdgCtntVO();
		ctntVo.setHrdCdgId(hrdCdgId);
		ctntVo.setAttrCtnt1(attrCtnt1);
		ctntVo.setAttrCtnt2(attrCtnt2);
		ctntVo.setAttrCtnt3(attrCtnt3);
		
		try {
			if(!command.checkBkgHrdCdgCtnt(ctntVo, account)) {
				Map<String,String> etcData = new HashMap<String,String>();
				etcData.put("BkgHrdCdgCtnt", "Y");
				eventResponse.setETCData(etcData); 
				return eventResponse;
			}
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Bkg Hard Coding 데이타 확인.<br>
	 * 
	 * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse checkBkgHrdCdgCtnt0726(Event e) throws EventException {
		
		GeneralEventResponse	eventResponse = new GeneralEventResponse();
		BookingUtil				command= new BookingUtil();
		EsmBkg0726Event event = (EsmBkg0726Event) e;
		
//		String bkg_no = event.getBkg_no();
		String hrdCdgId  = event.getHrdCdgId();
		String attrCtnt1 = event.getAttrCtnt1();
		String attrCtnt2 = event.getAttrCtnt2();
		String attrCtnt3 = event.getAttrCtnt3();
		
		// Bkg Hard Coding 데이타 확인.
		BkgHrdCdgCtntVO ctntVo = new BkgHrdCdgCtntVO();
		ctntVo.setHrdCdgId(hrdCdgId);
		ctntVo.setAttrCtnt1(attrCtnt1);
		ctntVo.setAttrCtnt2(attrCtnt2);
		ctntVo.setAttrCtnt3(attrCtnt3);
		
		try {
			if(!command.checkBkgHrdCdgCtnt(ctntVo, account)) {
				Map<String,String> etcData = new HashMap<String,String>();
				etcData.put("BkgHrdCdgCtnt", "Y");
				eventResponse.setETCData(etcData); 
				return eventResponse;
			}
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * file을 업로드한다<br>
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse setFile(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
        EsmBkg1096Event event = (EsmBkg1096Event)e;

    	try {
    		eventResponse.setETCData("fileKey", event.getFileKey());
        } catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
        return eventResponse;
	}
	
	/** NCM No 정합성 체크
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchHsCdList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg007907Event event = (EsmBkg007907Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		ManifestListDownloadBC command = new BrcsManifestDownloadBCImpl();
		List<BrHsCdDetailVO> list = null;
		BrHsCdDetailVO brHsCdDetailVO = null;
		
		try {												
			BrHsCdCondVO brHsCdCondVO = new BrHsCdCondVO();
			brHsCdCondVO.setBrzCmdtCd(event.getBrzCmdtCd());
			brHsCdCondVO.setPageGubun("popup");
			list = command.searchHsCdList(brHsCdCondVO);
			
			if(list.size() > 0)
			{
				brHsCdDetailVO = list.get(0);
				eventResponse.setETCData("brz_cmdt_cd", brHsCdDetailVO.getBrzCmdtCd());
				eventResponse.setETCData("cmdt_desc", brHsCdDetailVO.getCmdtDesc());
			}
			else
			{
				eventResponse.setETCData("brz_cmdt_cd", "");
				eventResponse.setETCData("cmdt_desc", "");
			}
			

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * container weight 정보를 체크 .(ESM_BKG_0079_04)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse validateContainerWgt(Event e) throws EventException {

		GeneralEventResponse eventResponse = null;
		EsmBkg007904Event event7904 = null;
		EsmBkg007907Event event7907 = null;        
		BLDocumentationCMBC docCmd = null;

		try {
			
			eventResponse = new GeneralEventResponse();
			docCmd = new BLDocumentationCMBCImpl();
			if ("EsmBkg007904Event".equalsIgnoreCase(e.getEventName())) {
				
				event7904 = (EsmBkg007904Event)e;
			
			    String chkFlg = docCmd.validateContainerWgt(event7904.getContainerVOs());
			    eventResponse.setETCData("chkFlg", chkFlg);
			}else if ("EsmBkg007907Event".equalsIgnoreCase(e.getEventName())) {
				event7907 = (EsmBkg007907Event)e;
				CmVO cmVO = event7907.getCmVO();				
				ContainerVO vo = null;
				ContainerVO[] containerVOs = new ContainerVO[cmVO.getCmCntrInfoVOs().size()] ;
				
				for(int i=0; i < containerVOs.length ; i++ ){
					vo = new ContainerVO();

					vo.setBkgNo(cmVO.getCmBkgInfoVO().getBkgNo());
					vo.setCntrNo(cmVO.getCmCntrInfoVOs().get(i).getCntrNo());
					vo.setCntrTpszCd(cmVO.getCmCntrInfoVOs().get(i).getCntrTpszCd());
					vo.setCntrWgt(cmVO.getCmCntrInfoVOs().get(i).getCmCntrWgt());
					
					containerVOs[i] = vo;
				}
				String chkFlg = docCmd.validateContainerWgt(containerVOs);
				eventResponse.setETCData("chkFlg", chkFlg);
			}
			

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * container Risk 정보를 체크 .(ESM_BKG_0079_04)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse validateCntrRsk(Event e) throws EventException {

		GeneralEventResponse eventResponse = null;
		EsmBkg007904Event event7904 = null;
		BLDocumentationCMBC docCmd = null;
		
		try {
			eventResponse = new GeneralEventResponse();
			BookingUtil utilCmd = new BookingUtil();
			docCmd = new BLDocumentationCMBCImpl();
			BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
			
			if ("EsmBkg007904Event".equalsIgnoreCase(e.getEventName())) {
				
				event7904 = (EsmBkg007904Event)e;
				
				bkgBlNoIN.setBkgNo(event7904.getBkgNo());
				bkgBlNoIN.setBlNo(event7904.getBlNo());
				bkgBlNoIN.setCaUsrId(account.getUsr_id());
				BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
				
				if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
					throw new EventException(new ErrorHandler("BKG01049", new String[]{event7904.getBkgNo()}).getMessage());
				}
			
			    String rskFlg = docCmd.validateCntrRsk(event7904.getContainerVOs(),bkgBlNoVO.getCaFlg(),"N");
			    eventResponse.setETCData("rskFlg", rskFlg);
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	
	/**
	 * Not Updated Container 정보를 claer 한다.(ESM_BKG_0901)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	@SuppressWarnings("null")
	private EventResponse manageCtmMvmtIrrFlg(Event e) throws EventException {

		EsmBkg0901Event event = (EsmBkg0901Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		ContainerMovementMgtBC ctmCmd = new ContainerMovementMgtBCImpl();
		BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
		
//		List<EdiNotUpdCntrVO> EdiNotUpdCntrVO = new ArrayList<EdiNotUpdCntrVO>();
		EdiNotUpdCntrVO[] UpdCntrVOs = event.getEdiNotUpdCntrVOS();
		
		HistoryTableVO historyTableVO = new HistoryTableVO();
		String uiId = "ESM_BKG_0079_04";

		try {
			begin();
			
			List<BkgEtcHisVO> bkgEtcHisVOs = new ArrayList<BkgEtcHisVO>();
			BkgEtcHisVO bkgEtcHisMstVO = null;

			for (int i = 0; i < UpdCntrVOs.length; i++) {
				
				// CTM_MVMT_IRR 테이블의 CNMV_IRR_STL_FLG 를 Y 로 업데이트
				ctmCmd.updateCtmMvmtIrrFromBkg(UpdCntrVOs[i].getCntrNo(), UpdCntrVOs[i].getBkgNo());
				
				bkgEtcHisMstVO = new BkgEtcHisVO();
				
				// 히스토리 기록
				bkgEtcHisMstVO.setBkgNo(UpdCntrVOs[i].getBkgNo());
				bkgEtcHisMstVO.setBkgHisIssUiId(uiId);
				bkgEtcHisMstVO.setHisCateNm ("Container / Not updated");
				bkgEtcHisMstVO.setPreCtnt(UpdCntrVOs[i].getCntrNo());
				bkgEtcHisMstVO.setCrntCtnt("");
				bkgEtcHisMstVO.setCreUsrId(account.getUsr_id());
				bkgEtcHisMstVO.setUpdUsrId(account.getUsr_id());
				
				bkgEtcHisVOs.add(bkgEtcHisMstVO);
			}

			historyTableVO.setBkgEtcHisVOs(bkgEtcHisVOs);
			histCmd.manageCtmMvmtIrrFlg(uiId, historyTableVO, account);
			
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * POL:JPFUS-POD:KNPNH/KHSIH의 Used Commodity대상 Booking Block.(ESM_BKG_0079_06)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchFukushimaUsedCmdt(Event e) throws EventException {
		EsmBkg007906Event event = (EsmBkg007906Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil utilCmd = new BookingUtil();
		MndVO mndVO = event.getMndVO();
		
		BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
		bkgBlNoIN.setBkgNo(mndVO.getBkgNo());
		bkgBlNoIN.setBlNo(mndVO.getBlNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());
		
		try{
			BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN); 
			
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new EventException(new ErrorHandler("BKG01049").getMessage());
			}
			bkgBlNoIN.setCaFlg(bkgBlNoVO.getCaFlg());
			
			utilCmd.searchFukushimaUsedCmdt(bkgBlNoIN, mndVO.getCmdtCd(), mndVO.getCstmsDesc());
			 
			//eventResponse.setETCData("flg", bkgBlNoVO.getCaExistFlg());
		} catch (EventException ex) {
		rollback();
		//eventResponse.setUserMessage(ex.getMessage());
		throw ex;
	
		} catch (Exception ex) {
		rollback();
		throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	
		}
	
		return eventResponse;
	}
	/**
	 * BKG Interface Management 정보를 조회한다.(ESM_BKG_3004)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchBkgIfList(Event e) throws EventException {
		EsmBkg3004Event event = (EsmBkg3004Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLDocumentationBLBC command = new BLDocumentationBLBCImpl();
		BkgIfManageInVO bkgIfManageInVO = event.getBkgIfManageInVO();

		try {
				List<BkgIfManageListVO> bkgIfManageListVO = command.searchBkgIfList(bkgIfManageInVO);
			if (bkgIfManageListVO != null) {
//				eventResponse.setRsVo(bkgIfManageListVO);
//				List<BkgIfManageListVO> bkgIfManageListVOs = bkgIfManageListVO;
				eventResponse.setRsVoList(bkgIfManageListVO);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	 /**
     * EsmBkg3004Event 저장 이벤트 처리<br>
     * manageBkgInterface01 정보를 저장한다<br>
     * 
     * @author KIM TAE KYOUNG
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
	private EventResponse manageBkgInterface01(Event e) throws EventException {
        
        GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        EsmBkg3004Event event 			= (EsmBkg3004Event) e;
        BkgIfManageInVO[] bkgIfManageInVO = event.getBkgIfManageInVOs();
        try {
        	
        	for(int i=0; i<bkgIfManageInVO.length; i++){
	        	//IBookingARCreationBC::interfaceBKGARInvoiceToINV ( bkgIfVo )
	            BookingARCreationBC bookingARCreationBC = new BookingARCreationBCImpl();
	            ARBkgInterfaceCreationVO bkgIfVo = new ARBkgInterfaceCreationVO();
	            bkgIfVo.setBkgNo(bkgIfManageInVO[i].getBkgNo());
	            bkgIfVo.setManDivInd("B");
	            bkgIfVo.setUserId(account.getUsr_id());
	            bookingARCreationBC.interfaceBKGARInvoiceToINV(bkgIfVo);
        	}
        } catch(EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException((String)new ErrorHandler("BKG00391").getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
     * EsmBkg3004Event 저장 이벤트 처리<br>
     * manageBkgInterface02 정보를 저장한다<br>
     * 
     * @author KIM TAE KYOUNG
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
	private EventResponse manageBkgInterface02(Event e) throws EventException {
        
        GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        EsmBkg3004Event event 			= (EsmBkg3004Event) e;
        BkgIfManageInVO[] bkgIfManageInVO = event.getBkgIfManageInVOs();
        CostAssignBC masCmd  = new CostAssignBCImpl();
        try {
        	
        	for(int i=0; i<bkgIfManageInVO.length; i++){
        
	        	//IBookingARCreationBC::interfaceBKGARInvoiceToINV ( bkgIfVo )
        		MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
        		masBkgComIfVo.setBkgNo(bkgIfManageInVO[i].getBkgNo());
        		masBkgComIfVo.setCostSrcSysCd("BKG");
        		masBkgComIfVo.setIfRmk("Manage Rate");
        		masBkgComIfVo.setCreUsrId(account.getUsr_id());
        		masBkgComIfVo.setUpdUsrId(account.getUsr_id());
                masCmd.modifyMasCommonInterface(masBkgComIfVo);	
        	}
        } catch(EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException((String)new ErrorHandler("BKG00391").getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
     * EsmBkg3004Event 저장 이벤트 처리<br>
     * manageBkgInterface03 정보를 저장한다<br>
     * 
     * @author KIM TAE KYOUNG
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
	private EventResponse manageBkgInterface03(Event e) throws EventException {
        
        GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        EsmBkg3004Event event 			= (EsmBkg3004Event) e;
        BkgIfManageInVO[] bkgIfManageInVO = event.getBkgIfManageInVOs();
        try {
        	
        	for(int i=0; i<bkgIfManageInVO.length; i++){
        		BkgCopManageBC	copBC = new BkgCopManageBCImpl();
        		copBC.reviveCopsByBkgRqst(bkgIfManageInVO[i].getBkgNo());
        	}
        } catch(EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException((String)new ErrorHandler("BKG00391").getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_BKG_3004 에서 edi 전송 대상 리스트를 조회한다. <br>
	 * @author	Kim Tae Kyoung
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchBkgIfList01(Event e) throws EventException{	
		try{
			EsmBkg3004Event event = (EsmBkg3004Event)e;
			BLDocumentationBLBC command = new BLDocumentationBLBCImpl();	
			BkgIfManagerEdiInputVO bkgIfManagerEdiInputTmpVO = event.getBkgIfManagerEdiInputVO();
			BkgIfManagerEdiInputVO bkgIfManagerEdiInputVO = new BkgIfManagerEdiInputVO();
			bkgIfManagerEdiInputVO = bkgIfManagerEdiInputTmpVO;
			List<BkgIfManagerEdiVO> list = command.searchBkgIfList01(bkgIfManagerEdiInputVO, event.getTypeGbn());
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
	
			return eventResponse;
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
	}
	
	/**
	 * ESM_BKG_3004 : 310 EDI 전송 <br>
	 * Customer정보를 Flat File로 생성하여 EDI로 전송한다.<br>
	 * 
	 * @author	Kim tae kyoung
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse manageBkgInterface04(Event e) throws EventException{
		EsmBkg3004Event event = (EsmBkg3004Event)e;
		GeneralEventResponse eventResponse = null;
		BLDocumentationBLBC command = new BLDocumentationBLBCImpl();
		BkgBlNoVO[] bkgBlNoVO = null;
		String typeGbn = null;
		String jobID = null;
		CustTpIdVO[] custTpIdVO = null;
		try{
			begin();
			eventResponse = new GeneralEventResponse();
			custTpIdVO = event.getCustTpIdVOs();
			bkgBlNoVO = event.getBkgBlNoVOs();
//			EDI 310
			typeGbn = "D"; 
			jobID = command.bkgManagerEdiMulti(bkgBlNoVO,custTpIdVO,typeGbn,account);
			eventResponse.setETCData("jobID", jobID);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
	}		

	/**
	 * EDI 전송 BackEndJob 상태 확인<br>
	 * 
	 * @author	Kim tae kyoung
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchBkgIfStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
    	BackEndJobMetaDataSelector backEndJobMetaDataSelector = null;
    	List<ComBakEndJbVO> dbRowSetlist = null;
    	DBRowSet rowSet = null;
    	ComBakEndJbVO jobVo = null;
		String key = null;
    	try {    		
    		eventResponse = new GeneralEventResponse();
    		key = JSPUtil.getNullNoTrim((String)e.getAttribute("key"));
	    	if (null != key && !"".equals(key)) {
    			// Backend job 완료여부를 검사한다.
		    	backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(key);
		    	rowSet = backEndJobMetaDataSelector.getDbRowset();
		    	dbRowSetlist = (List)RowSetUtil.rowSetToVOs(rowSet, ComBakEndJbVO.class);
		    	if (0==dbRowSetlist.size()) {  // Background job framework가 정상적으로 동작하지 않을 경우 발생하는 오류를 회피하기 위함
		    		jobVo = new ComBakEndJbVO();
		    		jobVo.setJbStsFlg("0");
		    	} else {
		    		jobVo = (ComBakEndJbVO)dbRowSetlist.get(0);	
		    	}
		    	eventResponse.setETCData("jb_sts_flg", jobVo.getJbStsFlg());
	    	}
    	} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		}
    	return eventResponse;
    }

	/**
	 * EDI 전송 BackEndJob 결과 확인<br>
	 * 
	 * @author	Kim tae kyoung
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchBkgSendList(Event e) throws EventException{
		GeneralEventResponse eventResponse = null;
		BLDocumentationBLBC command = null;
		String result = null;
		try{
			eventResponse = new GeneralEventResponse();
			command = new BLDocumentationBLBCImpl();
			result = command.searchBkgSendList(JSPUtil.getNullNoTrim((String)e.getAttribute("key")));
			eventResponse.setETCData("result", result);
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
	}
	
	
	/**
	 * UI_BKG_9460조회화면의 COMBO 값 조회(공통 CODE 조회)<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode9460(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			BookingUtil comboUtil = new BookingUtil();

			// Handling Status의 값 리스트 얻기
			List<BkgComboVO> bl_tp_cd = comboUtil.searchCombo("CD02807");
			// B/L TYPE의 값 리스트 얻기
			List<BkgComboVO> n3pty_bl_sts_cd = comboUtil.searchCombo("CD03336");  
			//리스트에 "All"항목 추가하기
			BkgComboVO combovo = new BkgComboVO();
			combovo.setDesc("All");
			combovo.setVal("All");
			combovo.setName("All");
			bl_tp_cd.add(0,combovo);
			n3pty_bl_sts_cd.add(0,combovo);

			eventResponse.setRsVoList(bl_tp_cd);
			eventResponse.setRsVoList(n3pty_bl_sts_cd);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	
	/**
	 * UI_BKG_9460조회
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchN3ptyBlRqst(Event e) throws EventException {
		EsmBkg9460Event event = (EsmBkg9460Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLIssuanceBC command = new BLIssuanceBCImpl();
		N3ptyBlRqstVO n3ptyBlRqstVO = event.getN3ptyBlRqstVO();
 
		try {
			
			List<BkgSrchSetVO> searchSetList = null;
			StringBuffer qryWhere = new StringBuffer();

			if ("Y".equals(n3ptyBlRqstVO.getSetSlctFlg())) {
				searchSetList = command.searchSrchSetForList(account.getUsr_id());
				for (int i=0;i<searchSetList.size();i++) {
					BkgSrchSetVO bkgSrchSetVO = new BkgSrchSetVO();
					bkgSrchSetVO = searchSetList.get(i);
					qryWhere.append(bkgSrchSetVO.getSetQryWhere() + " \n");
				}
				n3ptyBlRqstVO.setSetQryWhere(qryWhere.toString());
				log.debug(">>> WHERE SQL:"+n3ptyBlRqstVO.getSetQryWhere());
			} else n3ptyBlRqstVO.setSetQryWhere("");
			
				List<N3ptyBlRqstVO> N3ptyBlRqstVOs = command.searchN3ptyBlRqst(n3ptyBlRqstVO,account);
			if (N3ptyBlRqstVOs != null) {
				eventResponse.setRsVoList(N3ptyBlRqstVOs);
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * UI_BKG_9460 수정
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse modifyN3ptyBlRqst(Event e) throws EventException {
		EsmBkg9460Event event = (EsmBkg9460Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();
		N3ptyBlRqstVO[] n3ptyBlRqstVOs = event.getN3ptyBlRqstVOs();

		try {
			begin();
			if(n3ptyBlRqstVOs!=null && n3ptyBlRqstVOs.length > 0 ){
				command.modifyN3ptyBlRqst(n3ptyBlRqstVOs, account);
				for (int i=0;i<n3ptyBlRqstVOs.length;i++) {
					if("Y".equals(n3ptyBlRqstVOs[i].getChgFlg()) 
							&& !"R".equals(n3ptyBlRqstVOs[i].getN3ptyBlStsCd())
							&& !"C".equals(n3ptyBlRqstVOs[i].getN3ptyBlStsCd())){
						command.sendN3ptyBlRqst(n3ptyBlRqstVOs[i],account);
					}
					
				}
			}
			commit();
	
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	
	/**
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createN3ptyBlRqst(Event e) throws EventException {
		log.debug("[START:: BLIssuanceBC == modifyDocRqst update ]==========");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();
		EsmBkg9460Event event = (EsmBkg9460Event) e; 

		try {
			begin();
			command.createN3ptyBlRqst(event.getBkgNo(),account);  
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06014").getMessage(), ex);
		}
		log.debug("[end:: BLIssuanceBC == modifyDocRqst update ]==========");
		return eventResponse;
	}
	
	/**
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
    private EventResponse searchBlIssNote(Event e) throws EventException {
		EsmBkg9462Event event = (EsmBkg9462Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLIssuanceBC command = new BLIssuanceBCImpl();


		try {
			List<BkgMdtItmVO> bkgMdtItmVOs= command.searchBlIssNote(event.getBkgNo());
			eventResponse.setRsVoList(bkgMdtItmVOs);

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }
    
	/**
	 * 3rd party request관련 생성된 request당 파일 목록을 관리한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */    
	private EventResponse searchBlAtchList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();

		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		EsmBkg9463Event event = (EsmBkg9463Event) e; 

		try{
			//2.로직 처리 실행
			List<BlAtchVO> list = command.searchBlAtchList(event.getBlAtchVO());

			//3.로직 처리후 결과처리
			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("[END::]==========");
		return eventResponse;
	}
	
	/**
	 * 3rd party request관련 생성된 request당 파일 목록을 저장한다
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */  	
	private EventResponse manageBlAtch(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();
		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		EsmBkg9463Event event = (EsmBkg9463Event)e;
		BlAtchVO[] blAtchVOs = event.getBlAtchVOs();

		try{
			//2.로직 처리 실행
			begin();
			command.manageBlAtch(blAtchVOs,account); 
			commit();

			//3.로직 처리후 결과처리
			eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());  //BKG00102 : 저장성공

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("[END::]==========");
		return eventResponse;
	}
	
	/**
	 * P/O & Other No.화면에 값들이 setup화면에 세팅되어있는대로 존재하는지 조회
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse searchPoExist(Event e) throws EventException {
		EsmBkg007906Event event = (EsmBkg007906Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLDocumentationBLBC docCmd = new BLDocumentationBLBCImpl();

		try {
			String poNm = docCmd.searchPoExist(event.getBkgNo());
			eventResponse.setETCData("po_nm", poNm); 
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * Bl Certi Requset 목록을 조회한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */    
	private EventResponse searchBlCertiRqst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();

		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		EsmBkg9464Event event = (EsmBkg9464Event) e; 

		try{
			//2.로직 처리 실행
			List<BlCertiRqstVO> list = command.searchBlCertiRqst(event.getBlCertiRqstVO());

			//3.로직 처리후 결과처리
			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("[END::]==========");
		return eventResponse;
	}
	
	
	
	/**
	 * UI_BKG_9464조회화면의 COMBO 값 조회(공통 CODE 조회)<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode9464(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			BookingUtil comboUtil = new BookingUtil();

			// Handling Status의 값 리스트 얻기
			List<BkgComboVO> bl_certi_sts_cd = comboUtil.searchCombo("CD03408");

			//리스트에 "All"항목 추가하기
			BkgComboVO combovo = new BkgComboVO();
			combovo.setDesc("All");
			combovo.setVal("All");
			combovo.setName("All");

			bl_certi_sts_cd.add(0,combovo);
			eventResponse.setRsVoList(bl_certi_sts_cd);


		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	
	/**
	 * BL certi Status 를 수정(ESM_BKG_9464)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageBlCertiSts(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();
		EsmBkg9464Event event = (EsmBkg9464Event) e;
		BlCertiRqstVO blCertiRqstVO = event.getBlCertiRqstVO();
		blCertiRqstVO.setUpdUsrId(account.getUsr_id());
		try {
			begin();
			command.manageBlCertiSts(blCertiRqstVO);
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06014").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * BL certi attachment를 조회(ESM_BKG_9466)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchBlRiderList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialCargoRiderBC command = new SpecialCargoRiderBCImpl();

		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		EsmBkg9466Event event = (EsmBkg9466Event)e;
		BlRiderInVO blRiderInVO = event.getBlRiderInVO();
		blRiderInVO.setAccount(account);

		try{
			//2.로직 처리 실행
			List<BlRiderOutVO> list = command.searchBlRiderList(event.getBlRiderInVO());

			//3.로직 처리후 결과처리
			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("[END::]==========");
		return eventResponse;
	}

	/**
	 * BL certi attachment를 저장(ESM_BKG_9466)
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBlRider(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialCargoRiderBC command = new SpecialCargoRiderBCImpl();
		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		EsmBkg9466Event event = (EsmBkg9466Event)e;
		BlRiderInVO blRiderInVO = event.getBlRiderInVO();
		blRiderInVO.setAccount(account);

		try{
			//2.로직 처리 실행
			begin();
			command.manageBlRider(blRiderInVO);
			commit();

			//3.로직 처리후 결과처리
			eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());  //BKG00102 : 저장성공

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("[END::]==========");
		return eventResponse;
	}
	
	/**
	 * BL certi Print flg 를 수정(ESM_BKG_9466)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageBlCertiPrn(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();
		EsmBkg9466Event event = (EsmBkg9466Event) e;
		BlCertiRqstVO[] blCertiRqstVOs = event.getBlCertiRqstVOs();

		try {
			begin();
			command.manageBlCertiPrn(blCertiRqstVOs,account);
			commit();

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06014").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 *  BL Data Complete update한다.<br>
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse updateBLComplete(Event e) throws EventException {

		EsmBkg0726Event event = (EsmBkg0726Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC issueCmd = new BLIssuanceBCImpl();
		
		GrpBlDtVO grpBlDtIN = event.getGrpBlDtVO();
		
		List<GrpBlDtListVO> grpBlDtListVOs = grpBlDtIN.getGrpBlDtListVOs();
		BlIssInfoVO[] blIssInfoVOs = new BlIssInfoVO[grpBlDtListVOs.size()];
		
		for(int i=0;i<grpBlDtListVOs.size();i++){
			blIssInfoVOs[i] = new BlIssInfoVO();
			blIssInfoVOs[i].setBkgNo(grpBlDtListVOs.get(i).getBkgNo());
			blIssInfoVOs[i].setBlReadyCheckbox("Y");
			blIssInfoVOs[i].setBlReadyOffice(this.account.getOfc_cd());
			blIssInfoVOs[i].setBlReadyBy(this.account.getUsr_id());
			blIssInfoVOs[i].setUpdUsrId(this.account.getUsr_id());
		}
		
		try {
			begin();
			issueCmd.updateBLComplete(blIssInfoVOs);
			commit();
			eventResponse.setETCData("isSuccess","Y");

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG06014").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	private EventResponse validateGroupBlIssue(Event e) throws EventException {
	    EsmBkg0726Event event = (EsmBkg0726Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC issueCmd = new BLIssuanceBCImpl();
	
		GrpBlDtVO grpBlDtIN = event.getGrpBlDtVO();
		List<GrpBlDtListVO> grpBlDtListVOs = grpBlDtIN.getGrpBlDtListVOs();

	    BlStatusVO blStatusVO = null;
	    String vslChk = null;
		StringBuffer errBkg = new StringBuffer();

		try {

			int voCnt = grpBlDtListVOs == null ? 0 : grpBlDtListVOs.size();
			for (int i = 0; i < voCnt; i++) {
	            // BKG No.
				BlIssInfoVO vo = new BlIssInfoVO();
	            vo.setBkgNo(grpBlDtListVOs.get(i).getBkgNo());

                blStatusVO = issueCmd.validateBlIssue(vo); 
                vslChk = blStatusVO.getVslChkFlg();

                if("N".equals(vslChk)) {
                	errBkg.append(grpBlDtListVOs.get(i).getBkgNo());
                	errBkg.append(",");
                } 
	            }


			if(errBkg.length()>0){
				eventResponse.setETCData("err_msg", errBkg.substring(0, errBkg.length()-1));
			}else{
				eventResponse.setETCData("err_msg","");
			}

		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * OBL 용지배부내역을 조회한다.(ESM_BKG_9467)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchBlPprMgmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC issueCmd = new BLIssuanceBCImpl();

		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		EsmBkg9467Event event = (EsmBkg9467Event)e;
		BkgCustBlPprMgmtVO blPprMgmtVO = event.getBkgCustBlPprMgmtVO();

		try{

			//2.로직 처리 실행
			List<BkgCustBlPprMgmtVO> list = issueCmd.searchBlPprMgmt(blPprMgmtVO);

			//3.로직 처리후 결과처리
			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("[END::]==========");
		return eventResponse;
	}
	
	
	
	/**
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchComCode9467(Event e) throws EventException {
		BookingUtil comboUtil = new BookingUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			
			List<BkgComboVO> list = comboUtil.searchYearCombo();
			eventResponse.setRsVoList(list);
			
			RASCommonBC rASCommand = new RASCommonBCImpl(); 
			List<RsltCdListVO> list2 = null;
			RsltCdListVO custVo = new RsltCdListVO();
	    	custVo.setEtc2("");
	    	list2 = rASCommand.searchRasOrganizationList(custVo);
	        eventResponse.setRsVoList(list2);
	        
			List<BkgComboVO> list3 = comboUtil.searchOfcCombo("All");
			eventResponse.setRsVoList(list3);
	        
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}
	
	

	/**
	 * OBL 용지배부내역을 관린한다.(ESM_BKG_9467)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse manageBlPprMgmt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC command = new BLIssuanceBCImpl();
		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		EsmBkg9467Event event = (EsmBkg9467Event)e;
		BkgCustBlPprMgmtVO[] blPprMgmtVOs = event.getBkgCustBlPprMgmtVOs();

		try{
			//2.로직 처리 실행
			begin();
			command.manageBlPprMgmt(blPprMgmtVOs,account); 
			commit();

			//3.로직 처리후 결과처리
			eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());  //BKG00102 : 저장성공

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("[END::]==========");
		return eventResponse;
	}
	
	
	/**
	 * 중복되는 키가있는지 체크한다.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */	
	private EventResponse checkBlPprMgmt(Event e) throws EventException {
		EsmBkg9467Event event = (EsmBkg9467Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BLIssuanceBC command = new BLIssuanceBCImpl();

		try {
			String chkFlg = command.checkBlPprMgmt(event.getBkgCustBlPprMgmtVO());
			eventResponse.setETCData("chk_flg", chkFlg); 
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}


	
	/**
	 * OBL 용지배부내역 히스토리을 조회한다.(ESM_BKG_9468)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchBlPprMgmtHis(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLIssuanceBC issueCmd = new BLIssuanceBCImpl();

		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		EsmBkg9468Event event = (EsmBkg9468Event)e;
		BkgCustBlPprMgmtHisVO blPprMgmtHisVO = event.getBkgCustBlPprMgmtHisVO();

		try{

			//2.로직 처리 실행
			List<BkgCustBlPprMgmtHisVO> list = issueCmd.searchBlPprMgmtHis(blPprMgmtHisVO);

			//3.로직 처리후 결과처리
			eventResponse.setRsVoList(list);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("[END::]==========");
		return eventResponse;
	}
	
	/**
	 * XTER VGM Request List 정보를 조회 한다.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterVgmList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1184Event event = (EsmBkg1184Event)e; 
		BLDocumentationBLBC command = new BLDocumentationBLBCImpl();
	    try{
	        eventResponse.setRsVoList(command.searchXterVgmList(event.getXterVgmRqstListInputVO()));
	    }catch(EventException ex){
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler(ex).getMessage());
	    }catch(Exception ex){
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler(ex).getMessage());
	    }   
	    return eventResponse;
    }
	
	/**
	 * XTER VGM Request를 BKG_CONTAINER로 Upload 한다.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadXterVgmInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1184Event event = (EsmBkg1184Event)e; 
		BLDocumentationBLBC     command0    = new BLDocumentationBLBCImpl();
		BLDocumentationCMBC     blCmBC      = new BLDocumentationCMBCImpl();
		BookingHistoryMgtBC 	historyBC 	= new BookingHistoryMgtBCImpl();
		EBookingReceiptBC eBookingReceiptBC = new EBookingReceiptBCImpl();
		GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
		BlRatingBC 				rateBC	 	= new BlRatingBCImpl();
		ContainerMovementMgtBC  ctmCmd      = new ContainerMovementMgtBCImpl();
        GeneralBookingSearchBC  searchBC 	= new GeneralBookingSearchBCImpl();
		BookingUtil 			util 		= new BookingUtil();
		CostAssignBC            masCmd      = new CostAssignBCImpl();
	    try{
	        
	    	if(account==null){
				account = new SignOnUserAccount("BATCH" ,"" ,"" ,""      ,""
		                ,""      ,"" ,"" ,"BATCH" ,""
		                ,"BATCH" ,"" ,"" ,""      ,""
		                ,""      ,"" ,"" ,""      ,""
		                ,""      ,""
							);
			}
	    	BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("VGM_PROC_CTR");			
			List<BkgHrdCdgCtntVO> BkgHrdCdgCtntVOs = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
			String vermasOb = "";
			String tml301 = "";
			String partialCntrVgm = "";
			String copCallEtc = "";
			String smsSend = "";
			if(BkgHrdCdgCtntVOs.size() > 0){
				vermasOb       = BkgHrdCdgCtntVOs.get(0).getAttrCtnt2();// VERMAS O/B EDI 발송
				tml301         = BkgHrdCdgCtntVOs.get(0).getAttrCtnt3();// TML 301 EDI 발송
				partialCntrVgm = BkgHrdCdgCtntVOs.get(0).getAttrCtnt7();// Partial CNTR 의 VGM Update
				copCallEtc     = BkgHrdCdgCtntVOs.get(0).getAttrCtnt8();// COP call and etc
				smsSend        = BkgHrdCdgCtntVOs.get(0).getAttrCtnt9();// SMS Send
			}
	    	
	    	XterVgmRqstListVO[] xterVgmRqstListVOs = event.getXterVgmRqstListVOs();
	    	String firmExists = "N";
	    	List<BkgContainerVO> vgnCntrs = new ArrayList<BkgContainerVO>();
	    	
	    	for(int j=0; j<xterVgmRqstListVOs.length; j++){
	    		
	    		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		    	bkgBlNoVO.setBkgNo(xterVgmRqstListVOs[j].getBkgNo());
		    	HistoryTableVO historyTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_1184", bkgBlNoVO);
		    	
		    	/* Search Booking History */
				if(null != historyTableVO.getBkgContainerVOs()){
					for(int k=0; k<historyTableVO.getBkgContainerVOs().size(); k++){
						if(xterVgmRqstListVOs[j].getCntrNo().equals(historyTableVO.getBkgContainerVOs().get(k).getCntrNo())){
							vgnCntrs.add(historyTableVO.getBkgContainerVOs().get(k));
						}
					}
				}

		    	begin();
	    		
	    		//01.VGM Validation 및 Container Attach 필요 확인
	    		String needCntrAtch = "N";
	    		XterVgmInfoValidationVO xterVgmInfoValidationVO = command0.searchXterVgmInfoValidation(xterVgmRqstListVOs[j]);
	    		if(xterVgmInfoValidationVO != null){
	    			if(xterVgmInfoValidationVO.getNeedAtchCntr()!=null && "Y".equals(xterVgmInfoValidationVO.getNeedAtchCntr()) ){
	    				// cntr attach
	    				needCntrAtch = "Y";
	    				xterVgmRqstListVOs[j].setRjctRsnRmk("");
	    			}else if(xterVgmInfoValidationVO.getRjctRsnRmk()!=null && !"".equals(xterVgmInfoValidationVO.getRjctRsnRmk())){
	    				xterVgmRqstListVOs[j].setRjctRsnRmk(xterVgmInfoValidationVO.getRjctRsnRmk());
	    				// RjctRsnRmk 있으면 Upload 안함
	    			}else{
	    				xterVgmRqstListVOs[j].setRjctRsnRmk("");
	    			}
	    		}else{
	    			xterVgmRqstListVOs[j].setRjctRsnRmk("VGM Validation error.");
	    		}
	    		
		    	//02. Container Attach
	    		if("Y".equals(needCntrAtch)){
	    		
	    			try{	
						EBookingReceiptBC 		command 	= new EBookingReceiptBCImpl();
						BookingHistoryMgtBC 	histCmd 	= new BookingHistoryMgtBCImpl();
				        BkgCopManageBC 			copCmd 		= new BkgCopManageBCImpl();
					
						String bkgNo = bkgBlNoVO.getBkgNo();			
						String caFlag = bkgBlNoVO.getCaFlg();
				
						CntrEtcInfoVO 		bkgEtcInfoVO 		= new CntrEtcInfoVO();
						bkgEtcInfoVO.setBkgNo(bkgNo);
						
						ContainerVO[] 		containerVOs 		= new ContainerVO[1];
						containerVOs[0] = new ContainerVO();
						containerVOs[0].setIbflag("I");
						containerVOs[0].setBkgNo(xterVgmRqstListVOs[j].getBkgNo());
						containerVOs[0].setCntrNo(xterVgmRqstListVOs[j].getCntrNo());
						containerVOs[0].setPckTpCd("");
						containerVOs[0].setOrgYdCd("");
						
						//Container Type Size Code 변수 정의
						List<MstContainerVO> list = null;
						String cntrTpszCd = null;
						CntrDetailInfoVO detailVo = null;
						
						/* final confirm */
						String fnlCfmFlg = (bkgEtcInfoVO.getFnlCfmFlg()==null)?"N":bkgEtcInfoVO.getFnlCfmFlg();
							
						/* Validate Container */
						CntrEtcInfoVO 		bkgEtcInfoVvdVO 		= null;
						bkgEtcInfoVvdVO = command.manageCntrEtcInfo(bkgBlNoVO);
						
						/* Validate Container - HJXX에 있는 Container 를  실제 사용하는 Booking 으로 옮김.*/
						List<Map<String,Object>> copCallList = null;
						HistoryLineVO historyLineVO = null;
						BkgDocProcSkdVO bkgDocProcSkdVO = null;
						String uiId = "ESM_BKG_1184";
						
						copCallList = blCmBC.validateContainer(bkgEtcInfoVvdVO, containerVOs, fnlCfmFlg);
						if (null!=copCallList && 0<copCallList.size()) {
							for (Map<String,Object> map : copCallList) {
								historyLineVO = new HistoryLineVO();
								historyLineVO.setBkgNo((String)map.get("bkgNo"));
								historyLineVO.setCaFlg((String)map.get("caFlg"));
								historyLineVO.setCrntCtnt("Detach Container : "+(String)map.get("cntrNo"));
								historyLineVO.setHisCateNm("Container No.");
								historyLineVO.setLocalTime("");
								historyLineVO.setPreCtnt(" ");
								historyLineVO.setUiId(uiId);
								histCmd.createBkgHistoryLine(historyLineVO, account);
		
								bkgDocProcSkdVO = new BkgDocProcSkdVO();
								bkgDocProcSkdVO.setBkgNo((String)map.get("bkgNo"));
								bkgDocProcSkdVO.setBkgDocProcTpCd("CNTCFM");
								bkgDocProcSkdVO.setDocPerfDeltFlg("N");
								if (null!=util.searchDocProcSkd(bkgDocProcSkdVO,(String)map.get("caFlg"))) {
									this.cancelContainerConfirm((String)map.get("bkgNo"), null);
								}
								//cop호출
								copCmd.detachCntr((String)map.get("bkgNo"), (String)map.get("cntrNo"), (String)map.get("cntrPrtFlg"));
							}
						}
		
						/* Container */
						List<ContainerVO> insertVoList = new ArrayList<ContainerVO>(); //jsy 
						List<ContainerVO> updateVoList = new ArrayList<ContainerVO>();
//						List<ContainerVO> deleteVoList = new ArrayList<ContainerVO>();
//						List<ContainerVO> changeVoList = new ArrayList<ContainerVO>();
						int cntrLen = containerVOs == null ? 0 : containerVOs.length;
						for (int i = 0; i < cntrLen; i++) {
							detailVo = null;
							String ibflag = containerVOs[i].getIbflag();
							containerVOs[i].setCreUsrId(account.getUsr_id());
							containerVOs[i].setUpdUsrId(account.getUsr_id());
							// Booking 화면의 R/D Term 데이타를 가져오도록 함.
							if(xterVgmInfoValidationVO.getRcvTermCd()!=null
								&& !"M".equals(xterVgmInfoValidationVO.getRcvTermCd())){
								containerVOs[i].setRcvTermCd(xterVgmInfoValidationVO.getRcvTermCd());
							}
							if(xterVgmInfoValidationVO.getDeTermCd()!=null
								&& !"M".equals(xterVgmInfoValidationVO.getDeTermCd())){
							containerVOs[i].setDeTermCd(xterVgmInfoValidationVO.getDeTermCd());
							}
							
							// Container Type Size Code를 구하는 부분
							list = util.searchTypeSizeByCntr(containerVOs[i].getCntrNo());
							if (list != null && list.size() > 0) {
								MstContainerVO mstContainerVO = (MstContainerVO) list.get(0);
								cntrTpszCd = mstContainerVO.getCntrTpszCd();
							}
							containerVOs[i].setCntrTpszCd(cntrTpszCd);
		
							if ("I".equals(ibflag)) {
								detailVo = blCmBC.searchCntrDtlInfo(containerVOs[i].getCntrNo());
								containerVOs[i].setSocFlg(detailVo.getSocFlg());
								if (containerVOs[i].getOrgYdCd().length() == 0) {
									containerVOs[i].setOrgYdCd(detailVo.getOrgYdCd());
								}
								if (containerVOs[i].getCntrVolQty() == null 
									|| "".equals(containerVOs[i].getCntrVolQty().trim()) 
									|| new Float (containerVOs[i].getCntrVolQty()).compareTo(new Float(0.0)) == 0) {
									containerVOs[i].setCntrVolQty("1");
									containerVOs[i].setBkgNo(bkgNo);
								}
								updateVoList.add(containerVOs[i]);
								insertVoList.add(containerVOs[i]); //jsy 
								
							}
						}
		
						if("ON".equals(copCallEtc)){
							blCmBC.manageContainer(updateVoList, caFlag);
							    // ctm
							ctmCmd.updateCtmMvmtIrrFromBkg(containerVOs[0].getCntrNo(), containerVOs[0].getBkgNo());
							    // cop
	//		                        String flgPartial = ("1".equals(insertCntrList.get(i).getCntrPrtFlg())? "Y" : "N");				    
							copCmd.attachCntr(containerVOs[0].getBkgNo(), containerVOs[0].getCntrNo(), "N");
							
							/* MAS */
			                MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
			                masBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
			                masBkgComIfVo.setCostSrcSysCd("BKG");
			                masBkgComIfVo.setIfRmk("Cntr Attach");
			                masBkgComIfVo.setCreUsrId(account.getUsr_id());
			                masBkgComIfVo.setUpdUsrId(account.getUsr_id());
			                masCmd.modifyMasCommonInterface(masBkgComIfVo);
						}else if(!"OFF".equals(copCallEtc)){
							/* Container Merge */
							BkgHrdCdgCtntVO bkgHrdCdgCtntVO = new BkgHrdCdgCtntVO();
							bkgHrdCdgCtntVO.setHrdCdgId("BKG_APL_FLG");
							bkgHrdCdgCtntVO.setAttrCtnt1("EBKG_CNTR");
							bkgHrdCdgCtntVO.setAttrCtnt2("Y");
							if(!util.checkBkgAplFlg(bkgHrdCdgCtntVO, account)){
								blCmBC.manageContainer(updateVoList, caFlag);
							}else{
								blCmBC.manageContainerByXter(updateVoList, caFlag);
							}
							
							// cop
							copCmd.attachCntr(containerVOs[0].getBkgNo(), containerVOs[0].getCntrNo(), "N");
						}else{
							/* Container Merge */
							BkgHrdCdgCtntVO bkgHrdCdgCtntVO = new BkgHrdCdgCtntVO();
							bkgHrdCdgCtntVO.setHrdCdgId("BKG_APL_FLG");
							bkgHrdCdgCtntVO.setAttrCtnt1("EBKG_CNTR");
							bkgHrdCdgCtntVO.setAttrCtnt2("Y");
							if(!util.checkBkgAplFlg(bkgHrdCdgCtntVO, account)){
								blCmBC.manageContainer(updateVoList, caFlag);
							}else{
								blCmBC.manageContainerByXter(updateVoList, caFlag);
							}
						}
		
			            PerformanceReportBC formanceCmd = new PerformanceReportBCImpl();
			            formanceCmd.manageQtyCntrCoposite(bkgBlNoVO.getBkgNo(), "CN"); 

						
	    			}catch(EventException ex){
						log.error("VGM CNTR Attach Error : "+xterVgmRqstListVOs[j].getBkgNo(), ex);
						xterVgmRqstListVOs[j].setRjctRsnRmk("Container Attach Error");
						rollback();
						begin();
					}
		    		
		    	}//02. Container Attach (End)
	    		
		        //03.VGM Data Update, Result Save
	    		try{
			        command0.uploadXterVgmInfo(xterVgmRqstListVOs[j], account);
		    	}catch(EventException ex){
					log.error("VGM Data Update Error : "+xterVgmRqstListVOs[j].getBkgNo(), ex);
					xterVgmRqstListVOs[j].setRjctRsnRmk("Signature Error.");
					rollback();
					begin();
					command0.uploadXterVgmInfo(xterVgmRqstListVOs[j], account);
				}
	    	
		        //04.BKG History
		        historyBC.manageBookingHistory("ESM_BKG_1184", historyTableVO, account);
		        commit();
		        
		        // 2018.01.16 iylee VGM Upload 결과 ACK EDI전송(결과 전송을 받을 업체에만 ACK 전송)
		        begin();
				bkgHrdCdgCtntListCondVO.setHrdCdgId("VGM_ACK_RECEIVER");
				BkgHrdCdgCtntVOs = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
				for(int i=0; i<BkgHrdCdgCtntVOs.size(); i++){
					if(BkgHrdCdgCtntVOs.get(i).getAttrCtnt1().equals(xterVgmRqstListVOs[j].getXterSndrId())){
				        eBookingReceiptBC.createVGMUploadAckEdi(xterVgmRqstListVOs[j],"");
					}
				}
				commit();
		        
		        
		        // Firm 인 경우
		        if(xterVgmRqstListVOs[j].getRjctRsnRmk()==null || "".equals(xterVgmRqstListVOs[j].getRjctRsnRmk())){
		        	firmExists = "Y"; 
		        	
		        	//partial CNTR 도 찾아서 같은 걸로 update
		        	if(!"OFF".equals(partialCntrVgm)){
			        	//partial bkg list 조회
			        	List<BkgContainerVO> ptlBkgList = blCmBC.searchPtlCntrBkg(xterVgmRqstListVOs[j].getBkgNo(), xterVgmRqstListVOs[j].getCntrNo());
			        	if(ptlBkgList!=null && ptlBkgList.size()>0){
			        		for(int i=0; i<ptlBkgList.size(); i++){
			        			begin();
			        			//target bkg history 조회
			        			BkgBlNoVO bkgBlNoVO1 = new BkgBlNoVO();
			        			bkgBlNoVO1.setBkgNo(ptlBkgList.get(i).getBkgNo());
			        			HistoryTableVO historyTableVO1 = historyBC.searchOldBkgForHistory("ESM_BKG_1184", bkgBlNoVO1);
			        			//vgm 복사
			        			blCmBC.modifyPtlCntrVgmCopy(xterVgmRqstListVOs[j].getBkgNo(), xterVgmRqstListVOs[j].getCntrNo(), ptlBkgList.get(i).getBkgNo(), account);
					        	//target bkg history update
			        			historyBC.manageBookingHistory("ESM_BKG_1184", historyTableVO1, account);
			        			commit();
			        		}
			        	}
		        	}
		        }
		        
		        // Booking no. 별로 한번만 EDI 전송, 간츤 booking no 중 마지막 cntr 일 때 
		        if(j+1==xterVgmRqstListVOs.length 
		        		|| ((j+1 < xterVgmRqstListVOs.length) && !xterVgmRqstListVOs[j].getBkgNo().equalsIgnoreCase(xterVgmRqstListVOs[j+1].getBkgNo())) ){
		        	
			        if("Y".equals(firmExists)){// Firm 인 CNTR이 하나라도 있었으면
						
						
						List<BkgNtcHisVO> bkgNtcHisVOs = null;
						
			        	//05.Vendor 301 EDI 발송
						if(!"OFF".equals(tml301)){
							begin();
					        Vender301ParamVO vender301ParamVO = new Vender301ParamVO(); 
							vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
							vender301ParamVO.setOldVvdVOs(null);
							vender301ParamVO.setOldQtyVOs(null);
							vender301ParamVO.setOldMtyPkupYdCd(null);
							vender301ParamVO.setBracCd("");
							vender301ParamVO.setEdiKind("BT");
							vender301ParamVO.setAutoManualFlg("Y");//Auto
							
							bkgNtcHisVOs = searchBC.createTmlBkgReceiptEdi(vender301ParamVO, account);
			
							if(bkgNtcHisVOs!=null){
								if(bkgNtcHisVOs.size()>0){
									historyBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
								}
							}
							commit();
						}
					   
						//06.VERMAS EDI 발송
						if(!"OFF".equals(vermasOb)){
							begin();
							bkgNtcHisVOs = eBookingReceiptBC.createTerminalVERMASEdi(bkgBlNoVO,"");			
							
							if(bkgNtcHisVOs!=null){
								if(bkgNtcHisVOs.size()>0){
									historyBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
								}
							}
							commit();
						}
						
						//07.SMS 전송로직
						if(!"OFF".equals(smsSend)){
					         // sms 전송로직 추가 .jsy ,manageContainer --s---------
				            BkgBookingInfoVO bkgBookingInfoVO = rateBC.searchBkgBookingInfo(bkgBlNoVO);
		
				            List<VslSkdVO> vslSkdVOs = null;
				            vslSkdVOs = receiptBC.searchVvdSkdForTsRoute(bkgBlNoVO);
							String newFirstVvd = "";
							String oldFirstVvd = "";
							String slancd = "";
							
							if(vslSkdVOs != null && vslSkdVOs.size()>0 ) {
								newFirstVvd = vslSkdVOs.get(0).getBkgVvdCd();
								oldFirstVvd = newFirstVvd;
								slancd =  vslSkdVOs.get(0).getSlanCd();
							}
							List<SmsRequirementResultVO> smsReqList = receiptBC.getSmsRequirementResult(bkgBookingInfoVO.getBkgNo(), oldFirstVvd, newFirstVvd, bkgBookingInfoVO.getBkgPolCd(), "");
							boolean bFinalCllPolYdChk = false;
							
							String bkgInfoPolYdCd ="";
							bkgInfoPolYdCd = bkgBookingInfoVO.getBkgPolYdCd()==null? "":bkgBookingInfoVO.getBkgPolYdCd();
							
							bkgInfoPolYdCd = bkgInfoPolYdCd.length() ==7 ? bkgInfoPolYdCd : bkgBookingInfoVO.getBkgPolCd()+bkgInfoPolYdCd;  
							
							for (int i = 0; i < smsReqList.size(); i++) {
		
								if( bkgInfoPolYdCd.equals(smsReqList.get(i).getPolYd() ) ) {
									bFinalCllPolYdChk = true;
								}
							}  
							
							log.debug("\nsms call:SEL?" + bkgBookingInfoVO.getBkgNo().substring(0, 3)+"\n"+
									"첫배 vvd 변경 조건: "+receiptBC.chkSmsRequirementVvdChanged(bkgBookingInfoVO.getBkgNo(), oldFirstVvd, newFirstVvd, bkgBookingInfoVO.getBkgPolCd(),"" )+"\n"+
									"newFirstVvd:"+newFirstVvd+"\n"+
									"oldFirstVvd:"+oldFirstVvd
							    	);	
							//SMS 전송 조건을 만족하면..
							if( "SEL".equals(bkgBlNoVO.getBkgNo().substring(0, 3) ) 
								&& receiptBC.chkSmsRequirementVvdChanged(bkgBookingInfoVO.getBkgNo(), oldFirstVvd, newFirstVvd,bkgBookingInfoVO.getBkgPolCd(), "" ) 
								&& bFinalCllPolYdChk) {
								
								String vgmChgFlg = "N";
								String vgmChgCntrList = "";
								//VGM변경된 CNTR있는지 확인 및 list출력
								if(vgnCntrs != null &&  vgnCntrs.size() > 0){
									
									vgmChgCntrList = blCmBC.searchVgmChgHis(vgnCntrs);
									if(vgmChgCntrList.length()>0){
										vgmChgFlg = "Y";
										vgmChgCntrList = vgmChgCntrList.substring(0, vgmChgCntrList.toString().lastIndexOf(","));
									}
								}
								
								//보낼 대상 조회.
								List<BkgUserSmsListVO> smsList = null;
								// sms 전송 
								String skdDirCd = newFirstVvd.substring(8,9);
								String sndMsg ="";
								String sndParam ="";
								String bkgNo = bkgBlNoVO.getBkgNo();
		
								if("Y".equals(vgmChgFlg)){
									//메일 보낼 대상 조회
					                smsList = receiptBC.getPhnId(slancd, bkgBookingInfoVO.getBkgOfcCd(), skdDirCd, bkgBookingInfoVO.getBkgPolCd(), bkgNo);
					                
					                //전송 메세지.
					                sndMsg = "\n\n" + newFirstVvd+" "+ bkgNo+ " ";
					                if("Y".equalsIgnoreCase(bkgBookingInfoVO.getDcgoFlg())){
					                	sndMsg = sndMsg +"(DG Cargo 선적) ";
					                }
					                
					                if("Y".equals(vgmChgFlg)){
					                	sndMsg = sndMsg +"(VGM 변경) ";
					                }	 
					                sndMsg = sndMsg +" 선적 변경 발생 " ;
									sndParam = //"/rv gubun[CID] vvd["+newFirstVvd+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
											   "/rv gubun[CID] vvd["+newFirstVvd+"] old_vvd["+oldFirstVvd+"]  pol_cd["+bkgBookingInfoVO.getBkgPolCd()+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[] cntr_set["+vgmChgCntrList+"]";
									begin();
									List<BkgNtcHisVO> bkgNtcHisVOs2 = searchBC.sendMailSmsByPodChange(smsList, bkgNo, sndMsg, sndParam, account );
									historyBC.createBkgNtcHis(bkgNtcHisVOs2, "");
									commit();
								}	
							}	
				        }
						
		    		}
			        firmExists = "N";
			        
			        vgnCntrs = new ArrayList<BkgContainerVO>();
		        }
	    	}
	    	
	    	eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
	    	
	    }catch(EventException ex){
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler(ex).getMessage());
	    }catch(Exception ex){
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler(ex).getMessage());
	    }   
	    return eventResponse;
    }
	
	/**
	 * ESM_BKG_1187 : open <br>
	 * 화면상의 drop down에 넣을 code를 조회한다.<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode1187(Event e) throws EventException {
		try{
			BookingUtil comboUtil = new BookingUtil();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			// bkg_sts_cd
			List<BkgComboVO> bkg_sts_cd = comboUtil.searchCombo("CD00769");

			eventResponse.setCustomData("bkg_sts_cd", bkg_sts_cd);
	
			return eventResponse;
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
	}
	
	/**
	 * ESM_BKG_1187 : retrieve <br>
	 * Terminal 에 VERMAS edi를 보내기 위한 Booking 리스트를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgListForGeneralVermasEdi(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1187Event event = (EsmBkg1187Event)e; 
		BLDocumentationCMBC command = new BLDocumentationCMBCImpl();
		
		// bkg_no가 넘어온 경우 bkg_no만 VO에 담고 나머지는 초기화 - bkg_no만 조회 시
		BkgListForTmlVermasEdiInputVO bkgListForTmlVermasEdiInputTmpVO = event.getBkgListForTmlVermasEdiInputVO();
		BkgListForTmlVermasEdiInputVO bkgListForTmlVermasEdiInputVO = new BkgListForTmlVermasEdiInputVO();
		if (event.getBkgListForTmlVermasEdiInputVO().getBkgNo()!=null 
				&& !"".equalsIgnoreCase(event.getBkgListForTmlVermasEdiInputVO().getBkgNo())) {
			bkgListForTmlVermasEdiInputVO.setBkgNo(bkgListForTmlVermasEdiInputTmpVO.getBkgNo());
        } else bkgListForTmlVermasEdiInputVO = bkgListForTmlVermasEdiInputTmpVO;
					
					
	    try{
	        eventResponse.setRsVoList(command.searchBkgListForGeneralTmlVermasEdi(bkgListForTmlVermasEdiInputVO));
	    }catch(EventException ex){
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler(ex).getMessage());
	    }catch(Exception ex){
	        log.error("err " + ex.toString(), ex);
	        throw new EventException(new ErrorHandler(ex).getMessage());
	    }   
	    return eventResponse;
    }
	
	/**
	 * Terminal에 VERMAS 를 Multi 로 전송한다. <br>
	 * 
	 * @param Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse sendTerminalVermasEdiMulti(Event e) throws EventException{
		EBookingReceiptBC eBookingReceiptBC = new EBookingReceiptBCImpl();
		BookingHistoryMgtBC histCmd = new BookingHistoryMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1187Event event = (EsmBkg1187Event)e;
		
		BkgBlNoVO[]  bkgBlNoVOs = null;
		CustTpIdVO[] custTpIdVOs = null;
		bkgBlNoVOs = event.getBkgBlNoVOs();
		custTpIdVOs = event.getCustTpIdVOs();
		
		try{
			begin();			
			if (bkgBlNoVOs.length > 0) {
				for(int i=0;i<bkgBlNoVOs.length;i++) {
					List<BkgNtcHisVO> bkgNtcHisVOs = eBookingReceiptBC.createTerminalVERMASEdi(bkgBlNoVOs[i],custTpIdVOs[i].getRcvId());
					if(bkgNtcHisVOs!=null){
						if(bkgNtcHisVOs.size()>0){
							histCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_1187");
						}
					}
				}
			}
			commit();
			eventResponse.setETCData("SuccessYn", "Y");
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
	}	
}
