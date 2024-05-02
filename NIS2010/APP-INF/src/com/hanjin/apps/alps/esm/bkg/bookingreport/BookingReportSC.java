/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BookingReportSC.java
 *@FileTitle : BookingReport
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.28
 *@LastModifier : 강동윤
 *@LastVersion : 1.0
 * 2009.05.28 강동윤
 * 1.0 Creation
 * --------------------------------------------------------
 * History 
 * 2010.09.27 이재위 [CHM-201005253-01] [BKG/DOC] EIR Exchange & Customs Release Check Report 신규개발(ESM_BKG_1110)[SZPBB]
 * 2010.12.27 김태경 [CHM-201006690] [BKG/DOC] Tax ID 남미 3개국 신규 추가
 * 2011.04.01 김기종 [CHM-201109394-01] DPCS고도화일환으로 DPCS화면 변경 및 추가
 * 2011.05.11 김상수 [CHM-201109394-01] DPCS 고도화 요청 - B/L Turn Time Report (ESM_BKG_0067) 화면, 쿼리, VO및 java Method들의 전면수정
 * 2011.05.16 김상수 [CHM-201109394-01] DPCS 고도화 요청 : B/L Turn Time Report (ESM_BKG_0067) Summary Sheet추가 및 로직 변경
 * 2011.07.25 채창호 CHM-201111754-01:[UI_BKG_1123]TRO Status Report (EUR) 화면 개발
 * 2011.08.01 민정호 [CHM-201111541] Split 06-R9 CNTR의 BKG UPDATE 요청
 * 2011.08.24 김기종 [CHM-201112495-01] Split Candidate 후보 flag변경(취소)기능 개발요청
 * 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축
 * 2011.10.18 조원주 [CHM-201113594] DPCS-SI Turn Time레포트 및 Draft B/L전송후 Amendment S/I PIC변경관련 개발요구사항 송부
 * 2011.11.07 정선용 [CHM-201114286-01] DPCS- Queue List 기능 보완
 * 2011.11.22 정선용 [CHM-201114286-01] DPCS-SI Turn Time레포트 및 Draft B/L전송후 Amendment S/I PIC변경관련 개발요구사항 송부
 * 2011.11.30 정선용 [CHM-201114554-01] DPCS-Correction 기능 보완 요청
 * 2011.12.02  금병주 [CHM-201114555-01] DPCS Correction 기능 보완 -2	
 * 2012.04.02 변종건 [CHM-201217103-01] O/B CNTR MVMT Status > Summary by yard/ type /size 탭에도 trade/ sub trade/ lane 옵션 추가
 * 2012.06.25 김기택 [CHM-201218292-01] C/M 화면 다운로드 데이터 양식 수정(B/L No, TP/SZ, Seal No 컬럼 분리)
 * 2012.12.11 조정민 [CHM-201221860] S/I TURN TIME REPORT 내 S/I 종류 세분화(추가) 요청
 * 2012.01.07 조정민 [CHM-201221961] Email 접수 Draft B/L Correction 분류 시스템 개발
 * 2013.01.10 조정민 [CHM-201222115][BL Issue&Print기능] (1) BL Status Report-GSO추가 (2) BL Issue&Onboard Date Update-FWDR정보 추가
 * 2013.04.08 김진주 [CHM-201323806] BOOKING STATUS REPORT 판매팀 코드로 산출 기능 추가
 * 2013.04.08 김진주 [CHM-201323813] 미반입 관리 관련 sms 전송 기능 개발 요청
 * 2013.09.25 김진주 [CHM-201325838] [남중국 DPCS] SZPBB DPCS 시스템 개발
 * 2013.11.06 김진주 [CHM-201327291][SZP DPCS] 라이브 적용일자 및 시스템 개선사항 요청
 * 2013.11.18 김보배 [CHM-201327122] [RFS Lane] Double calling logic 적용 요청 (1) Print by VVD /Port
 * 2014.06.13 조인영 [CHM-201430236] 미주 서비스 센터 통합 관련 시스템 개발 4차 - TRO Report 신규 생성 (USA)
 * 2014.06.18 조인영 [CHM-201430731] BKG Status Report에 POL 이나 BKG OFFICE가 US/CA Country에 속하는 경우 1달동아 조회토록 로직 보완
 *=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgReferenceNoGenerationVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SearchSrepCdListVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.StaffListByOfcCdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic.EBookingReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic.EBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.basic.BDRCorrectionBC;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.basic.BDRCorrectionBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.basic.UserSetupMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.usersetupmgt.basic.UserSetupMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.basic.DashboardBC;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.basic.DashboardBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.event.EsmBkg1201Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.event.EsmBkg1211Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.event.EsmBkg1212Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.vo.DashboardReportColumnVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.dashboard.vo.DashboardReportFormVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBC;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0066Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0067Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0072Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0110Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0174Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0214Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0226Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0227Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0235Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0236Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0274Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0409Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0410Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0412Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0415Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0417Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0421Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0422Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0423Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0424Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0425Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0432Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0435Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0436Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0437Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0438Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0445Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0446Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0447Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0449Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0463Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0464Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0488Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0489Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0568Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0570Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0595Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0620Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0621Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0631Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0632Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0651Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0746Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0753Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0767Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0914Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0940Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0984Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0985Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg0988Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg1057Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg1073Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg1081Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg1082Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg1083Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg1123Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkg1140Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.event.EsmBkgChnEdiReceiveEvent;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.AutoratingReportVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BDRBookingStatusListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BkgCorrCngDpcsUsrVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BkgDpcsDocWeightVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BkgEmlAcctStupVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BkgRptDfltVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BlCaDetailListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BlCargoManifestInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BlCargoManifestOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.BlCntrCargoManifestOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.CaInquiryReportVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.CaIssueDateOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.CaPerformanceReportOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.CaSummaryReportOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.CheckBkgNoVsSrNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocPFMCBLListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocPFMCOfcListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocPerformanceReportInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocPerformanceSummaryVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueBkgHistListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueDetailListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueDetailReturnInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueListOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueReportByPolListOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueSummaryAgingVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueSummaryJITCompletenceVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueSummaryReturnFeedbackVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueSummarySRKindVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueSummaryStatusVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueSummaryUrgencyVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocQueueVvdListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DocTurnTimeOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DpcsAmendReasonBkgListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DpcsSiSplitBkgCntrCompareResultVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DpcsSiSplitBkgCntrHisVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DpcsSiSplitCandidateVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.EBkgSiPfmcInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.EBkgSiTurnTimeOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.EBkgSiUploadStsReportInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.FreightChargeSummaryReportInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.InBoundReportOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.ModifySiValAutoVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.ModifySrTransferVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.PortCLSReportVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.PortCloseBLlistVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.PortCloseOfficeListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.ProductionRatioDetailVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.ProductionRatioVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.QueueStatusDetailVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.QueueStatusVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.RbcvesselVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SaelsPerformanceReportOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchBookingTrendReportVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchDPCSPfmcErrorListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchDpcsPerfByVolListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchEDIGrpIDVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchFCLListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchPerfVolByRegionGroupDtlListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchPerfVolByRegionGroupListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchQueueDetailReturnReasonCdListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchReportByInputterUserGroupListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchReportByRaterUserGroupListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchSREmlAtchFileListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchSREmlCtntVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchSREmlReceivingListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchSRReceivingListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchUserGroupIdVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SiTurnTimeDetailVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SiTurnTimeSummaryVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.TroEurStatusListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.TroStatusListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.TroUsaStatusListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.VesselUtilizationStatusReportInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.VesselUtilizationStatusReportOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.VesselVVDListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.basic.SpecialReportBC;
import com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.basic.SpecialReportBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.event.EsmBkg0104Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.event.EsmBkg0485Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.event.EsmBkg0588Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.event.EsmBkg0896Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.integration.SpecialReportDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.vo.BkgRptSetVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.vo.ReportTemplateListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.vo.SpecialCargoManifestInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.vo.SpecialCargoSummaryReportVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.basic.StatusReportBC;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.basic.StatusReportBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0068Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0071Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0103Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg1186Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0111Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0112Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0116Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0162Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0618Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0619Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0622Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0625Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0647Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0727Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0772Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0775Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0814Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0900Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg0953Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg1004Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg1006Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg1007Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg1110Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg1143Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg1156Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg1170Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkg1175Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.event.EsmBkgS007Event;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BdrBookingNoListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCMCroChkListByBLVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCMCroChkListByExportBLVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCMPrintListoutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgClearanceCrossCheckListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BkgCroChkListByBLVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.BlStsReportOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.CntrStowageintVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.CustVipReportOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.DocsAmendReasonCDVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.DocsQueueDetailVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.DocsUserGroupCdVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.LoadingConfirmationinVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdEirMovementStatusListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdMovementStsListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdMovementStsTPSZSumListOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdMovementStsYardSumListOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdMvntStsNtcListInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.OutBdMvntStsNtcListSumVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.SearchBDRBookingStatusListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.SearchRollOverInformationVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.SearchTradeListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.StatusReportInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.StatusReportOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.StatusReportSpecialCargoOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.StatusReportSummaryOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.SurchageSummaryInVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.TsLoadingRptByLocListOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.VgmStatusReportVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo.WarningReportOutVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.basic.CustomsTransmissionBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.basic.CndCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsManifestAmendmentVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.basic.UsaCustomsTransmissionBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.usa.vo.UsaTmlBlByVvdVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.vo.BlInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.basic.ManifestListDownloadBC;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.basic.CndManifestListDownloadBackEndJob;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.integration.CndManifestListDownloadDBDAO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.canada.vo.CndManifestModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.basic.UsaManifestListDownloadBCImpl;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaManifestSearchDetailVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListDetailVO;
import com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.basic.RASCommonBC;
import com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.basic.RASCommonBCImpl;
import com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.bkg.revenueauditcommon.rascommon.rascommon.vo.RsltContiListVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.basic.CLLCDLManifestBC;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.basic.CLLCDLManifestBCImpl;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlTransmitVO;
import com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo.ComboListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.CheckUtils;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgDpcsUsrGrpVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.MdmCntrTpSzVO;
import com.hanjin.syscommon.common.table.MdmOrganizationVO;
import com.hanjin.syscommon.common.table.MdmSlsRepVO;
import com.hanjin.syscommon.common.table.MdmVslSvcLaneVO;

 
/**
 * NIS2010-BookingReport Business Logic ServiceCommand - NIS2010-BookingReport 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author kang dong yun 
 * @param <UseManifestSearchDetailVO>
 * @param <ManifestTransmitVO>
 * @param <UsaCustomsTransmissionBC>
 * @see SpecialReportDBDAO
 * @since J2EE 1.6
 */
 
public class BookingReportSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	// report file separator
	
	private final String SP = "|&&|";
	private final String EOR = "//EOR//";
	
	/**
	 * BookingReport system 업무 시나리오 선행작업<br>
	 * ESM_BKG-0896업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("BookingReportSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * BookingReport system 업무 시나리오 마감작업<br>
	 * ESM_BKG-0896 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("BookingReportSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * NIS2010-BookingReport system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmBkg0896Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReportTemplateId(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = copyReportTemplate(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUserInfo(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0753Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVVDList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = checkVVDList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkVVD(e);
			} 			
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0767Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReportTemplateList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = addReportTemplate(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = removeReportTemplate(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0071Event")) {
	    	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchBDRBookingStatusList(e);
	    	}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	            eventResponse = searchCombo(e);
	    	}
	    	
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkgS007Event")) {
	    	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchRollOverInformationList(e);
	    	}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	            eventResponse = searchComCodeS007(e);
	    	} 
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0072Event")) {
	    	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchBDRBookingPfmcStatusList(e);
	    	}
	    }
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0488Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    		eventResponse = searchCombo0488(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
	    		eventResponse = searchSRReceivingList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
	    		eventResponse = searchSREmlReceivingList(e);	
	    	}else if(e.getFormCommand().isCommand(FormCommand.MULTI)
	    			|| e.getFormCommand().isCommand(FormCommand.MULTI02)) {
	    		eventResponse = manageSRReceiving(e);
	    	}else if(e.getFormCommand().isCommand(FormCommand.MODIFY)) {
	    		eventResponse = modifyQueueRemark(e);
	    	} else if(e.getFormCommand().isCommand(FormCommand.MULTI03)) {
	    		eventResponse = modifyReceivingList(e);	
	    	}
		}	
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0435Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCombo0435(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSiTurnTimeSummary(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchSiTurnTimeDetail(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchSiTurnTimeDetailSs(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0447Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSREmlCtnt(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
	    		eventResponse = sendEmlConversionRequest(e);	
	    	}
		    
    	}	
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0463Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCombo0463(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchQueueStatusByRegion(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchQueueStatusByOffice(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchQueueStatusDetail(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0464Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCombo0463(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchProductionRatioByRegion(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchProductionRatioByOffice(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchProductionRatioDetail(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0489Event")) {
	    	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {	    		
	    		eventResponse = searchAmendReasonBkgList(e);
	    	}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    		eventResponse = searchAmendReasonBkgList(e);
	    	}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
	    		eventResponse = checkBkgNoVsSrNo(e);
	    	}else if(e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
	    		eventResponse = modifyBkgNoMatch(e);
	    	}else if(e.getFormCommand().isCommand(FormCommand.REMOVE)) {
	    		eventResponse = removeQueueBkgNo(e);
	    	/*}else if(e.getFormCommand().isCommand(FormCommand.ADD)) {	
	    		eventResponse = manageBkgQueueList(e);*/
	    	/*}else if(e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
	    		eventResponse = manageBkgQueueList(e);*/
	    	}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
	    		eventResponse = manageBkgQueueList(e);	
	    	}else if(e.getFormCommand().isCommand(FormCommand.MODIFY04)) {	//Close ==> W
	    		eventResponse = modifyBkgNoMatch(e);	
	    	}else if(e.getFormCommand().isCommand(FormCommand.MODIFY05)) { //transfer
	    		eventResponse = modifyBkgNoMatch(e);	
	    	}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {  //si_trans
	    		eventResponse = sendMailDcube(e);	

	    	}
	    }
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0988Event")) {
	    	if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
	    		eventResponse = addQueueRemark(e);
	    	}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0067Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = search0067InitData(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDPCSTurnTimeSummary(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)){
				eventResponse = searchDPCSTurnTimeList(e);
			}

	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0068Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = bkgClearanceCrossCheckList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCombo0068(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = bkgClearanceCrossCheckListForRD(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0772Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
	    		eventResponse = bkgClearanceCrossCheckListForRD(e);
	    	}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0417Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPCTCLSReport(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	
				eventResponse = searchPCTCLSReport(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchComCode0417(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = excelDownload_0417(e);
			}
			
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0162Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchContainerStowageList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchComCode0162(e);
			}
			
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0595Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFrtSumList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchComCode0595(e);
			}
			
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0618Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBookingListForLoadingConfirmation(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchComCode0618(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = sendLoadingConfirmation(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = sendLoadingConfirmation(e);
			}
			
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0619Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOutBdMovementStsList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchComCode0619(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = report0814(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = report0815(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg1110Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchOutBdEirMovementStatusList(e);
	    	}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
	    		eventResponse = searchComCode0619(e);
	    	}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
	    		eventResponse = report0814(e);
	    	}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
	    		eventResponse = report0815(e);
	    	}

	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0814Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = report0814(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = report0815(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0409Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDPCSPfmcErrorList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchComCode0409(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0620Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTroStatusList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComCode0620(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchStaffList0620(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0226Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEBkgSiUploadStsList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComCode0226(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0104Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReportTemplateBstVipList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCombo0103_0104_01(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchStaffListByOfcCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCombo0625_0104_02(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchSalesTeamList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchLocCdByOfcCd2(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageReportTemplateBstVipList(e);
			} 			
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0103Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchBLStatusList(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
	    		eventResponse = searchBLStatusListSpecialCargo(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
	    		eventResponse = searchBLStatusListSummary(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
	    		eventResponse = searchBLStatusList2(e);	    		
	    	} /*else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
	    	} 	*/		
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0775Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
	    		eventResponse = report0775(e);
	    	} 			
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0625Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchCustVipReport(e);
	    	} /*else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
	    	} 	*/		
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0421Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchQueueList(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    		eventResponse = searchQueueListInitData(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
	    		eventResponse = modifyBkgSrWrkStsCd(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.REMOVELIST)) {
	    		eventResponse = removeDpcsQueList(e);		
	    	} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
	    		eventResponse = modifyBkgSrFntPending(e);	
	    	} 
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0422Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {// Queue History 조회
	    		e.setAttribute("s_gubun","HIST");
	    		eventResponse = searchQueueDetailList(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {//User Group Id Search
	    		eventResponse = searchUserGroupId(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {// 상위 메타정보 조회
	    		e.setAttribute("s_gubun","META");
	    		eventResponse = searchQueueDetailList(e);
	    	} else if(e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = manageQueueDetailList(e);
	    	} else if(e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
	    		eventResponse = manageQueueDetailList2(e);
	    	} else if(e.getFormCommand().isCommand(FormCommand.MODIFY03)) {
	    		eventResponse = manageQueueDetailList2(e);	
	    	} else if(e.getFormCommand().isCommand(FormCommand.MODIFY04)) {
	    		eventResponse = modifySiValAuto(e);			
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
	    		eventResponse = searchQueueDetailList4(e);
			/*
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchXterRqstValidation(e);
			*/
			}  else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
	 	    		eventResponse = searchFrontOfficeFlag(e);	
			}

	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0437Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchSZPBBQueueList(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    		eventResponse = searchSZPBBQueueListInitData(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
	    		eventResponse = modifySZPBBSrWrkStsCd(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.REMOVELIST)) {
	    		eventResponse = removeSZPBBQueueList(e);		
	    	} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
	    		eventResponse = modifySZPBBPicUserId(e);	
	    	} 
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0438Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {// Queue History 조회
	    		e.setAttribute("s_gubun","HIST");
	    		eventResponse = searchSZPBBQueueDetailList(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {//User Group Id Search
	    		eventResponse = searchUserGroupId(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {// 상위 메타정보 조회
	    		e.setAttribute("s_gubun","META");
	    		eventResponse = searchSZPBBQueueDetailList(e);
	    	} else if(e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = manageSZPBBQueueDetailList(e);
	    	} else if(e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
	    		eventResponse = manageSZPBBQueueDetailPending(e);
	    	} else if(e.getFormCommand().isCommand(FormCommand.MODIFY03)) {
	    		eventResponse = manageSZPBBQueueDetailPending(e);	
	    	} else if(e.getFormCommand().isCommand(FormCommand.MODIFY04)) {
	    		eventResponse = modifySZPBBSiValAuto(e);			
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
	    		eventResponse = searchSZPBBQueueDetailList4(e);
			/*
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchXterRqstValidation(e);
			*/
			}  else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
	 	    		eventResponse = searchSZPBBFrontOfficeFlag(e);	
			}

	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0424Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchQueueReportByPol(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    		eventResponse = search0424ListByQueue(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
	    		eventResponse = searchQueueVvdList(e);
	    	} 
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0066Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchBlTurnTimeReport(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    		eventResponse = search0066InitData(e);
	    	} 
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0940Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchInBoundPfmcReport(e);
	    	} /*else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    	} */
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0274Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchBLCargoManifestList(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    		eventResponse = searchBLCntrCargoManifestList(e);
	    	} 
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0410Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchDPCSVolList(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    		eventResponse = search0410InitData(e);
	    	} 
		    // 
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0412Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
	    		eventResponse = searchComCode0412(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchDPCSPointList(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
	    		eventResponse = modifyDpcsWeightValue(e);
	    	} 
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0432Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchBlPerfVolByRegionGroupList(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    		eventResponse = searchBlPerfVolByRegionGroupDtlList(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
	    		eventResponse = search0432InitData(e);
	    	}   		    	
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0415Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
	    		eventResponse = searchReportByInputterUserGroupList(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
	    		eventResponse = searchReportByRaterUserGroupList(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03)) {
		    		eventResponse = searchReportByQaUserGroupList(e);	
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    		eventResponse = searchReportByInputterUserGroupDtlList(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
	    		eventResponse = searchComCode0415(e);	
	    	}
	    		    	
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0236Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.INIT)) {
	    		eventResponse = searchComCode0236(e);	
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    		eventResponse = searchEBkgSiTurnTimeSummary(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
	    		eventResponse = searchEBkgSiUploadTimeSummary(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
	    		eventResponse = searchEBkgSiTurnTimeDetail(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
	    		eventResponse = searchEBkgSiUploadTimeDetail(e);
	    	}
	    		    	
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0953Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchTsLoadingReportByLocation(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    		eventResponse = search0953SortList(e);
	    	} 
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0984Event")) {
	    	if(e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
	    		eventResponse = manageQueueRtnToRtn(e);
	    	}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0985Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchQueueDetailReturn(e);
	    	}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
	    		eventResponse = manageQueueDetailReturn(e);
	    	} 
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg1004Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchDPSCUserGroup(e);
	    	}else if(e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
	    		eventResponse = modifyDocsUserGroupCd(e);
	    	} 
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg1006Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {// Queue Detail Amend Reason 조회
	    		eventResponse = searchAmendDetail(e);
	    	} 
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg1007Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {// Queue Detail Return Reason 조회
	    		eventResponse = searchQueueDetail(e);
	    	} 
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0647Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchBLStsReportList(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    		eventResponse = searchCombo0647(e);
	    	}			
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0227Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEBkgSiPfmcList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComCode0227(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0588Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSpecialCargoSummaryReport(e);
			}else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComCode0588(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0727Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBDRBookingNoList(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0914Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)
					|| e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPortCloseReport(e);
			}else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComCode0914(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0111Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCMCrossCheckList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCMCode(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0112Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCMCrossExportCheckList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchExportCMCode(e);
			}						
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0116Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCMPrintList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComCode0116(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0651Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBLCaDetailList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBLCaDetailHisList(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0214Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDOCPerformanceReport(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	
				eventResponse = searchDOCPerformanceReport(e);
			}else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComCode0214(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0110Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCAPerformanceReport(e);
			}else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComCode0110(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0174Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchReportTemplateListMain(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCaSummaryReport(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchCaSummaryReportBLList(e);
			}
	    } else if(e.getEventName().equalsIgnoreCase("EsmBkg0631Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
	    		eventResponse = searchRBCVesselList(e);
	    	}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0632Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchSalesPerformanceReport(e);
			}else if (e.getFormCommand().isCommand(FormCommand.INIT)) {				
				eventResponse = searchComCode0632(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {				
				eventResponse = searchVVDByLane(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0568Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchCaIssueDateList (e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {				
				eventResponse = modifyCaIssueRemark(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCaIssueDateHisList (e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = manageManifestFlatFile (e);
			}
	    } else if(e.getEventName().equalsIgnoreCase("EsmBkg0570Event")) {
	    	 if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
		    		eventResponse = searchCaByBLno(e);
		    }
		} else if(e.getEventName().equalsIgnoreCase("EsmBkg1057Event")) {
	    	 if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
	    		eventResponse = searchFCLList(e);
	    	 }
		} else if(e.getEventName().equalsIgnoreCase("EsmBkg0952Event")) {
	    	 if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
	    		eventResponse = searchCaSummaryReport(e);
	    	 }
	    } else if(e.getEventName().equalsIgnoreCase("EsmBkg0746Event")) {
	    	 if (e.getFormCommand().isCommand(FormCommand.INIT)){
		    		eventResponse = searchVesselUtilizationTrade(e);
	    	 }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
		    		eventResponse = searchVesselUtilizationSubTrade(e);
	    	 }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)){
		    		eventResponse = searchVesselUtilizationBound(e);
	    	 }else if (e.getFormCommand().isCommand(FormCommand.SEARCH)){
		    		eventResponse = searchVesselUtilizationStatusReport(e);
	    	 }
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg1073Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchEDIGrpId(e);
	    	}
	    } else if(e.getEventName().equalsIgnoreCase("EsmBkg1081Event")) {
	    	 if (e.getFormCommand().isCommand(FormCommand.INIT)){
		    		eventResponse = searchComCode1081(e);
	    	 }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
		    		eventResponse = searchAutoratingReport (e);
	    	 }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)){
		    		eventResponse = searchNonAutoratingReport (e);
	    	 }	
		}  else if(e.getEventName().equalsIgnoreCase("EsmBkg1082Event")) {	    	 
			 if (e.getFormCommand().isCommand(FormCommand.SEARCH)){	
				 	eventResponse = searchBookingTrendReport(e);
	    	 }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {				
					eventResponse = searchVVDByLane2(e);
	    	 }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
	    		 eventResponse = searchBookingTrendReportDetail(e);
			 }
		} else if(e.getEventName().equalsIgnoreCase("EsmBkg1083Event")) {	    	 
			 if (e.getFormCommand().isCommand(FormCommand.SEARCH)){	
				 eventResponse = searchBookingTrendReportBLDetail(e);
	    	 }
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg0485Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSpecialCargoManifestInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkSpecialCargoManifestRd(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmBkgChnEdiReceiveEvent")) {
			eventResponse = loadRcvMsg(e);
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg0425Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)){
	    		eventResponse = searchComCode0425(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBkgEmlAcctStupList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBkgEmlAcctStup(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchComCode0425(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0446Event")) {
         	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
          		eventResponse = searchQueueListSearchSet(e);
          	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageQueueListSearchSet(e);
            }
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0445Event")) {
         	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
          		eventResponse = searchDpcsSiSplitCandidate(e);
          	}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = modifyXterBkgNoBySplitStsCd (e);
            } 
        }else if (e.getEventName().equalsIgnoreCase("EsmBkg0449Event")) {
         	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
          		eventResponse = searchDpcsSiSplitBkgCntrCompareResult(e);
          	}	
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0423Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchQueueSummary(e);
	    	} 
        }else if (e.getEventName().equalsIgnoreCase("EsmBkg1123Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
    			eventResponse = searchEurTroStatusList(e);
            	}else if (e.getFormCommand().isCommand(FormCommand.INIT)) {
    			eventResponse = searchComCode1123(e);
    			}
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg1140Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	    		eventResponse = searchDPSCCngUserGroup(e);
	    	}else if(e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
	    		eventResponse = modifyDocsCngUserGroupCd(e);
	    	}
         } else if (e.getEventName().equalsIgnoreCase("EsmBkg1143Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCrossCheckList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCMCode(e);
			}
         } else if (e.getEventName().equalsIgnoreCase("EsmBkg0436Event")) {
        	 if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchDPCSUser(e);
        	 } else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
            	 eventResponse = searchComCode0436(e);
             }	
         } else if (e.getEventName().equalsIgnoreCase("EsmBkg0235Event")) {
        	 if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		 eventResponse = searchEBkgSiPfmcListByEmail(e, false);
        	 } else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
            	 eventResponse = searchEBkgSiPfmcListByEmail(e, true);
        	 } else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
        		 eventResponse = searchEBkgSiPfmcListByEmailForExcelDown(e);
             }	
         } else if (e.getEventName().equalsIgnoreCase("EsmBkg1156Event")) {
         	 if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
         		 eventResponse = searchGsoOfcList(e);
         	 } 
          } else if (e.getEventName().equalsIgnoreCase("EsmBkg0622Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {  
				eventResponse = searchCombo0622(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {	    		
	    		eventResponse = searchOutBdMovementStsNtcList(e);
	    	} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {				
				eventResponse = sendCntrListByEmail(e);
			}
	    } else if (e.getEventName().equalsIgnoreCase("EsmBkg1201Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchDashboardRptByBkgOfc(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchDashboardRptByCust(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchBatchStartDate(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchDashboardStaffList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
                eventResponse = searchDashboardSrepList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
                eventResponse = searchDetailForGeneral(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
                eventResponse = searchDashboardTemplateItem(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
                eventResponse = searchDetailForTPB(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
                eventResponse = searchDetailForNotUpdateCntr(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
                eventResponse = searchDetailForRDN(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
                eventResponse = searchDetailForUshold(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
                eventResponse = searchDetailForDemDet(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
                eventResponse = searchDetailForSpclAppr(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
                eventResponse = searchDashboardItemList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
                eventResponse = searchDetailForAllBkgList(e);
            }
        }else if (e.getEventName().equalsIgnoreCase("EsmBkg1212Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {  
				eventResponse = searchDashboardReportForm(e);
			} else	if (e.getFormCommand().isCommand(FormCommand.MULTI)) {  
				eventResponse = manageDashboardReportForm(e);
			} else	if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {  
				eventResponse = searchDashboardReportColumn(e);
			} else	if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {  
				eventResponse = manageDashboardReportColumn(e);
			} else	if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {  
				eventResponse = searchBeforeApply(e);
			} 
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg1213Event")) { 
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {  
				eventResponse = searchDashboardReportColumn(e);
			} 	    
		}  else if (e.getEventName().equalsIgnoreCase("EsmBkg1170Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSurchageSummary(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchComCode1170(e);
			}
	      } else if(e.getEventName().equalsIgnoreCase("EsmBkg1175Event")) {	    	 
				 if (e.getFormCommand().isCommand(FormCommand.SEARCH)){	
					 eventResponse = searchSurchageDetail(e);
		    	 }
		  }else if (e.getEventName().equalsIgnoreCase("EsmBkg1211Event")) { 
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {  
					eventResponse = searchDashboardReportSetting(e);
				}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {  
					eventResponse = manageDashboardReportSetting(e);
				}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {  
                    eventResponse = removeDashboardReportSetting(e);
                } 
		  }else if (e.getEventName().equalsIgnoreCase("EsmBkg0621Event")) { 
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {  
					eventResponse = searchUsaTroStatusList(e);
				}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {  
					eventResponse = searchCombo0621(e);
				}
		  }else if (e.getEventName().equalsIgnoreCase("EsmBkg0900Event")) { 
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {  
					eventResponse = searchWarningReportList(e);
				}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {  
					eventResponse = searchCombo0900(e);
				} 
		  }else if (e.getEventName().equalsIgnoreCase("EsmBkg1186Event")) {
		    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
		    		eventResponse = searchVgmCrossCheckList(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchCombo1186(e);		
		    	}
		  }

        return eventResponse;
    }
	
	/**
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCombo0900(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		/* Dir */
		searchDirection(e,eventResponse);
		

         
        return eventResponse;
	}

	/**
	 * Warning Report 조회
     * ESM_BKG_0900 : Warning Report 조회<br>
     * @param  Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchWarningReportList(Event e)throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0900Event event = (EsmBkg0900Event)e;
		StatusReportBC command = new StatusReportBCImpl();

		try{
			List<WarningReportOutVO> list = command.searchWarningReportList(event.getWarningReportInVO());
			
			eventResponse.setRsVoList(list);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}		

		return eventResponse;
	}

	/**
     * 저장 이벤트 처리<br>
     * ESM_BKG_1212 : Report form 의 Item 조회<br>
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchBeforeApply(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1212Event event = (EsmBkg1212Event)e;
        DashboardBC command = new DashboardBCImpl();
        List<DashboardReportFormVO> list = command.searchBeforeApply(event, account.getUsr_id());
        eventResponse.setRsVoList(list);
        return eventResponse;
	}

	/**
     * 저장 이벤트 처리<br>
     * ESM_BKG_1211 : Report setting 의 Item 저장<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse manageDashboardReportSetting(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1211Event event = (EsmBkg1211Event)e;
		DashboardBC command = new DashboardBCImpl();
			
		try{
			begin();
			command.manageDashboardReportSetting(event.getReportSettingVOs(), account.getUsr_id());
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
     * 저장 이벤트 처리<br>
     * ESM_BKG_1211 : Report setting 의 Item 저장<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse removeDashboardReportSetting(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1211Event event = (EsmBkg1211Event)e;
        DashboardBC command = new DashboardBCImpl();
            
        try{
            begin();
            command.removeDashboardReportSetting(event.getReportSettingVOs(), account.getUsr_id());
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
     * ESM_BKG_1211 : Report setting 의 Item 조회<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchDashboardReportSetting(Event e)  throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1211Event event = (EsmBkg1211Event)e;
        DashboardBC command = new DashboardBCImpl();
        DBRowSet rsSet = command.searchDashboardRptFormByCust(event);
        eventResponse.setRs(rsSet);
        return eventResponse;
	}

	/**
     * 저장 이벤트 처리<br>
     * ESM_BKG_1212 : Template Report column 의 Item 저장<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse manageDashboardReportColumn(Event e) throws EventException {
    	// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1212Event event = (EsmBkg1212Event)e;
		DashboardBC command = new DashboardBCImpl();
		String report_num = "";
		
		try{
			
			begin();
			String ibflag = (String)event.getAttribute("checkIbflag");
			if(ibflag.equals("I")||ibflag.equals("U")){
				
				DashboardReportFormVO[] arr =  new DashboardReportFormVO[1];
				arr[0] = new DashboardReportFormVO();
				arr[0].setIbflag(ibflag);
				arr[0].setRptFomNo((String)event.getAttribute("f_rptFomNo"));
				arr[0].setRptFomNm((String)event.getAttribute("f_rptFomNm"));
				arr[0].setRptFomDesc((String)event.getAttribute("f_rptFomDesc"));
				
				report_num=command.manageDashboardReportForm(arr, account.getUsr_id());
				command.manageDashboardReportColumn(event.getReportColumnVOs(), account.getUsr_id(), report_num);
			}else{
				command.manageDashboardReportColumn(event.getReportColumnVOs(), account.getUsr_id(), (String) event.getAttribute("f_rptFomNo"));
			}
//    				eventResponse = (GeneralEventResponse) searchSREmlReceivingList(e);
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
     * 저장 이벤트 처리<br>
     * ESM_BKG_1212 : Template Report 의 Item 저장<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageDashboardReportForm(Event e) throws EventException {
    	// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1212Event event = (EsmBkg1212Event)e;
		DashboardBC command = new DashboardBCImpl();
			
		try{
			
			begin();
			
			command.manageDashboardReportForm(event.getReportFormVOs(), account.getUsr_id());
//    				eventResponse = (GeneralEventResponse) searchSREmlReceivingList(e);
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
     * ESM_BKG_1201 : Template Report 의 Item 조회<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchDetailForAllBkgList(Event e) throws EventException {

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1201Event event = (EsmBkg1201Event)e;
        DashboardBC command = new DashboardBCImpl();
        
        String bkg_ofc_cd = (String) event.getAttribute("f_bkg_ofc_cd");
        String sub_bkg_ofc_cd = (String) event.getAttribute("f_sub_bkg_ofc_cd");

        //sub office가 check되어 있을 경우 sub office를 조회한다.
        if("on".equals(sub_bkg_ofc_cd) &&  !"".equals(bkg_ofc_cd)){
            event.putValue("f_sub_bkg_ofc_list", command.searchBkgSubOffice(event));
        }
        
        eventResponse.setRs(command.searchDetailForAllBkgList(event));
        return eventResponse;
    }
    
	/**
     * 조회 이벤트 처리<br>
     * ESM_BKG_1201 : Template Report 의 Item 조회<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchDetailForGeneral(Event e) throws EventException {

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1201Event event = (EsmBkg1201Event)e;
        DashboardBC command = new DashboardBCImpl();
        
        String bkg_ofc_cd = (String) event.getAttribute("f_bkg_ofc_cd");
        String sub_bkg_ofc_cd = (String) event.getAttribute("f_sub_bkg_ofc_cd");

        //sub office가 check되어 있을 경우 sub office를 조회한다.
        if("on".equals(sub_bkg_ofc_cd) &&  !"".equals(bkg_ofc_cd)){
            event.putValue("f_sub_bkg_ofc_list", command.searchBkgSubOffice(event));
        }
        
        eventResponse.setRs(command.searchDetailForGeneral(event));
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * ESM_BKG_1201 : Template Report 의 Item 조회<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchDetailForTPB(Event e) throws EventException {

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1201Event event = (EsmBkg1201Event)e;
        DashboardBC command = new DashboardBCImpl();
        
        String bkg_ofc_cd = (String) event.getAttribute("f_bkg_ofc_cd");
        String sub_bkg_ofc_cd = (String) event.getAttribute("f_sub_bkg_ofc_cd");

        //sub office가 check되어 있을 경우 sub office를 조회한다.
        if("on".equals(sub_bkg_ofc_cd) &&  !"".equals(bkg_ofc_cd)){
            event.putValue("f_sub_bkg_ofc_list", command.searchBkgSubOffice(event));
        }
        
        eventResponse.setRs(command.searchDetailForTPB(event));
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * ESM_BKG_1201 : Template Report 의 Item 조회<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchDetailForNotUpdateCntr(Event e) throws EventException {

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1201Event event = (EsmBkg1201Event)e;
        DashboardBC command = new DashboardBCImpl();
        
        String bkg_ofc_cd = (String) event.getAttribute("f_bkg_ofc_cd");
        String sub_bkg_ofc_cd = (String) event.getAttribute("f_sub_bkg_ofc_cd");

        //sub office가 check되어 있을 경우 sub office를 조회한다.
        if("on".equals(sub_bkg_ofc_cd) &&  !"".equals(bkg_ofc_cd)){
            event.putValue("f_sub_bkg_ofc_list", command.searchBkgSubOffice(event));
        }
        
        eventResponse.setRs(command.searchDetailForNotUpdateCntr(event));
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * ESM_BKG_1201 : Template Report 의 Item 조회<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchDetailForUshold(Event e) throws EventException {

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1201Event event = (EsmBkg1201Event)e;
        DashboardBC command = new DashboardBCImpl();
        
        String bkg_ofc_cd = (String) event.getAttribute("f_bkg_ofc_cd");
        String sub_bkg_ofc_cd = (String) event.getAttribute("f_sub_bkg_ofc_cd");

        //sub office가 check되어 있을 경우 sub office를 조회한다.
        if("on".equals(sub_bkg_ofc_cd) &&  !"".equals(bkg_ofc_cd)){
            event.putValue("f_sub_bkg_ofc_list", command.searchBkgSubOffice(event));
        }
        
        eventResponse.setRs(command.searchDetailForUshold(event));
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * ESM_BKG_1201 : Template Report 의 Item 조회<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchDetailForDemDet(Event e) throws EventException {

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1201Event event = (EsmBkg1201Event)e;
        DashboardBC command = new DashboardBCImpl();
        
        String bkg_ofc_cd = (String) event.getAttribute("f_bkg_ofc_cd");
        String sub_bkg_ofc_cd = (String) event.getAttribute("f_sub_bkg_ofc_cd");

        //sub office가 check되어 있을 경우 sub office를 조회한다.
        if("on".equals(sub_bkg_ofc_cd) &&  !"".equals(bkg_ofc_cd)){
            event.putValue("f_sub_bkg_ofc_list", command.searchBkgSubOffice(event));
        }
        
        eventResponse.setRs(command.searchDetailForDemDet(event));
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * ESM_BKG_1201 : Template Report 의 Item 조회<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchDetailForSpclAppr(Event e) throws EventException {

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1201Event event = (EsmBkg1201Event)e;
        DashboardBC command = new DashboardBCImpl();
        
        String bkg_ofc_cd = (String) event.getAttribute("f_bkg_ofc_cd");
        String sub_bkg_ofc_cd = (String) event.getAttribute("f_sub_bkg_ofc_cd");

        //sub office가 check되어 있을 경우 sub office를 조회한다.
        if("on".equals(sub_bkg_ofc_cd) &&  !"".equals(bkg_ofc_cd)){
            event.putValue("f_sub_bkg_ofc_list", command.searchBkgSubOffice(event));
        }
        
        eventResponse.setRs(command.searchDetailForSpclAppr(event));
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * ESM_BKG_1201 : Template Report 의 Item 조회<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchDetailForRDN(Event e) throws EventException {

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1201Event event = (EsmBkg1201Event)e;
        DashboardBC command = new DashboardBCImpl();
        
        String bkg_ofc_cd = (String) event.getAttribute("f_bkg_ofc_cd");
        String sub_bkg_ofc_cd = (String) event.getAttribute("f_sub_bkg_ofc_cd");

        //sub office가 check되어 있을 경우 sub office를 조회한다.
        if("on".equals(sub_bkg_ofc_cd) &&  !"".equals(bkg_ofc_cd)){
            event.putValue("f_sub_bkg_ofc_list", command.searchBkgSubOffice(event));
        }
        
        eventResponse.setRs(command.searchDetailForRDN(event));
        return eventResponse;
    }
	
    /**
     * 조회 이벤트 처리<br>
     * ESM_BKG_1201 : Template Report 의 Item 조회<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchDashboardTemplateItem(Event e) throws EventException {

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1201Event event = (EsmBkg1201Event)e;
        DashboardBC command = new DashboardBCImpl();
        
        eventResponse.setRs(command.searchDashboardTemplateItem(event));
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * ESM_BKG_1201 : Item List조회<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchDashboardItemList(Event e) throws EventException {

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1201Event event = (EsmBkg1201Event)e;
        DashboardBC command = new DashboardBCImpl();
        
        eventResponse.setRs(command.searchDashboardItemList(event));
        return eventResponse;
    }
	
	/**
     * 조회 이벤트 처리<br>
     * ESM_BKG_1201 : Office로 Sales Rep List를 조회<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchDashboardSrepList(Event e) throws EventException {

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1201Event event = (EsmBkg1201Event)e;
        BookingUtil command = new BookingUtil();
        List<SearchSrepCdListVO> list = command.searchSrepCdList((String) event.getAttribute("f_bkg_ofc_cd"));
        eventResponse.setRsVoList(list);
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * ESM_BKG_1201 : Office로 Staff List를 조회<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchDashboardStaffList(Event e) throws EventException {

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1201Event event = (EsmBkg1201Event)e;
        BookingUtil command = new BookingUtil();
        
        List<StaffListByOfcCdVO> list = command.searchStaffListByOfcCd((String) event.getAttribute("f_bkg_ofc_cd"));
        eventResponse.setRsVoList(list);
        return eventResponse;
    }
    
	/**
     * 조회 이벤트 처리<br>
     * ESM_BKG_1212 : dachboard report form 조회<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchDashboardReportForm(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			String usr_id 		= "";
			DashboardBC command = new DashboardBCImpl();
			EsmBkg1212Event event = (EsmBkg1212Event) e;
			try{
				usr_id = (String) event.getAttribute("usr_id"); 
				List<DashboardReportFormVO> list = command.searchDashboardReportForm(usr_id);
				eventResponse.setRsVoList(list);
			}catch(EventException ex){
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}		
			return eventResponse;
	}

	/**
     * ESM_BKG_1201 :  조회 이벤트 처리<br>
     *
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchDashboardRptByBkgOfc(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1201Event event = (EsmBkg1201Event) e;
        DashboardBC command = new DashboardBCImpl();
        DBRowSet dbRowset = null;
        String batStDt = null;
        String dbdCreDt = null;
        String dbdCreSeq = null;
 
        try{
            dbRowset = command.searchBatchStartDate(event);

            if(dbRowset.next()){
                batStDt = dbRowset.getString("BAT_ST_DT");
                dbdCreDt = dbRowset.getString("DBD_CRE_DT");
                dbdCreSeq = dbRowset.getString("DBD_CRE_SEQ");
            }
            
            eventResponse.setETCData("bat_st_dt",batStDt);
            eventResponse.setETCData("dbd_cre_dt",dbdCreDt);
            eventResponse.setETCData("dbd_cre_seq",dbdCreSeq);
            
            String bkg_ofc_cd = (String) event.getAttribute("f_bkg_ofc_cd");
            String sub_bkg_ofc_cd = (String) event.getAttribute("f_sub_bkg_ofc_cd");

            //sub office가 check되어 있을 경우 sub office를 조회한다.
            if("on".equals(sub_bkg_ofc_cd) &&  !"".equals(bkg_ofc_cd)){
                event.putValue("f_sub_bkg_ofc_list", command.searchBkgSubOffice(event));
            }
            
            eventResponse.setRs(command.searchDashboardRptByBkgOfc(event));
        } catch(EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage(), ex);
        }
        return eventResponse;
    }

/**
 * ESM_BKG_1202 :  조회 이벤트 처리<br>
 * 
  * @param Event e
  * @return EventResponse
  * @throws EventException
  */
     private EventResponse searchDashboardRptByCust(Event e) throws EventException {
         // PDTO(Data Transfer Object including Parameters)
         
         GeneralEventResponse eventResponse = new GeneralEventResponse();
         EsmBkg1201Event event = (EsmBkg1201Event) e;
         DashboardBC command = new DashboardBCImpl();
         DBRowSet dbRowset = null;
         String batStDt = null;
         String dbdCreDt = null;
         String dbdCreSeq = null;
    
         try{
             dbRowset = command.searchBatchStartDate(event);

             if(dbRowset.next()){
                 batStDt = dbRowset.getString("BAT_ST_DT");
                 dbdCreDt = dbRowset.getString("DBD_CRE_DT");
                 dbdCreSeq = dbRowset.getString("DBD_CRE_SEQ");
             }
             
             eventResponse.setETCData("bat_st_dt",batStDt);
             eventResponse.setETCData("dbd_cre_dt",dbdCreDt);
             eventResponse.setETCData("dbd_cre_seq",dbdCreSeq);
             eventResponse.setRs(command.searchDashboardRptByCust(event));
         } catch(EventException ex) {
             log.error("err " + ex.toString(), ex);
             throw new EventException(new ErrorHandler(ex).getMessage(), ex);
         } catch(Exception ex) {
             log.error("err " + ex.toString(), ex);
             throw new EventException(new ErrorHandler(ex).getMessage(), ex);
         }
         return eventResponse;
     }    
    
 /**
  * ESM_BKG_1201 :  조회 이벤트 처리<br>
  *
  * @param Event e
  * @return EventResponse
  * @throws EventException
  */
     private EventResponse searchBatchStartDate(Event e) throws EventException {
         // PDTO(Data Transfer Object including Parameters)
         GeneralEventResponse eventResponse = new GeneralEventResponse();
         EsmBkg1201Event event = (EsmBkg1201Event) e;
         DashboardBC command = new DashboardBCImpl();
         DBRowSet dbRowset = null;
         String batStDt = null;
         String dbdCreDt = null;
         String dbdCreSeq = null;
         try{
             dbRowset = command.searchBatchStartDate(event);

             if(dbRowset.next()){
                 batStDt = dbRowset.getString("BAT_ST_DT");
                 dbdCreDt = dbRowset.getString("DBD_CRE_DT");
                 dbdCreSeq = dbRowset.getString("DBD_CRE_SEQ");
             }
             
             eventResponse.setETCData("bat_st_dt",batStDt);
         } catch(EventException ex) {
             log.error("err " + ex.toString(), ex);
             throw new EventException(new ErrorHandler(ex).getMessage(), ex);
         } catch(Exception ex) {
             log.error("err " + ex.toString(), ex);
             throw new EventException(new ErrorHandler(ex).getMessage(), ex);
         }
         return eventResponse;
     }
     
     /**
 	 * ESM_BKG_1213 : 조회 이벤트 처리<br>
 	 * @param Event e
 	 * @return EventResponse
 	 * @exception EventException
 	 */
 	private EventResponse searchDashboardReportColumn(Event e) throws EventException {
 				GeneralEventResponse eventResponse = new GeneralEventResponse();
 				EsmBkg1212Event event = (EsmBkg1212Event)e;
 				DashboardBC command = new DashboardBCImpl();

 				try{
 					List<DashboardReportColumnVO> list = command.searchDashboardReportColumn();
 					List<DashboardReportColumnVO> list2 = command.searchStoredDashboardReportColumn(event, account.getUsr_id());
 		        	
 		    		eventResponse.setRsVoList(list);
 		        	eventResponse.setRsVoList(list2); 
 				}catch(EventException ex){
 					throw ex;
 				}catch(Exception ex){
 					throw new EventException(ex.getMessage(), ex);
 				}		
 				return eventResponse;
 	}


 
	/**
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse modifyReceivingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0488Event event = (EsmBkg0488Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		try{
			
			begin();
			
			command.modifyReceivingList(event.getSearchSREmlReceivingListVOs(), account.getUsr_id() );
//			eventResponse = (GeneralEventResponse) searchSREmlReceivingList(e);
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
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse sendMailDcube(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0489Event event = (EsmBkg0489Event)e;
		
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		DocQueueBkgHistListVO vo = event.getDocQueueBkgHistListVO();
		DocQueueBkgHistListVO[] vos = event.getDocQueueBkgHistListVOS();
		vo.setUpdUsrId(account.getUsr_id());
		try{	
			begin();
			command.sendMailDcube(vo, vos, account);
			eventResponse.setUserMessage((String) new ErrorHandler("BKG08120",new String[]{}).getUserMessage());
			commit();

		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0896 : Report Share List 에 ID 를 조회한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReportTemplateId(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0896Event event = (EsmBkg0896Event)e;
		
		String usrId 		= "";
        String rptId 		= event.getRptId();
        String bkgRptKndCd 	= event.getBkgRptKndCd();
		
		SpecialReportBC command = new SpecialReportBCImpl();

		try{
			List<BkgRptSetVO> list = command.searchReportTemplateId(usrId, rptId, bkgRptKndCd);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0896 : Report Share List 에 User 정보를 조회한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUserInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0896Event event = (EsmBkg0896Event)e;
		
		String usrId 		= event.getUsrId();
		String rptId 		= event.getRptId();
        String bkgRptKndCd 	= event.getBkgRptKndCd();
        
		String usrNm		= "";
		String ofcCd		= "";
		String check		= "N";

		SpecialReportBC command = new SpecialReportBCImpl();

		try{
			List<BkgRptSetVO> list = command.searchUserInfo(usrId);
			
			if (list.size() > 0){
				
				List<BkgRptSetVO> list2 = command.searchReportTemplateId(usrId, rptId, bkgRptKndCd);
				
				if (list2.size() > 0){
				
					check = "Y:N";
				}else{
					
					check = "Y:Y";
				}
				
				BkgRptSetVO vo = (BkgRptSetVO)list.get(0);
				log.debug("usrNm = " + vo.getUsrNm());
				log.debug("ofcCd = " + vo.getOfcCd());
				usrNm = vo.getUsrNm();
				ofcCd = vo.getOfcCd();
			}
			
			eventResponse.setETCData("check",check);
			eventResponse.setETCData("usrNm",usrNm);
			eventResponse.setETCData("ofcCd",ofcCd);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0896 : Report Share List 에 Report 입력/수정한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse copyReportTemplate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0896Event event = (EsmBkg0896Event)e;
		SpecialReportBC command = new SpecialReportBCImpl();
		
		try{
			begin();
			
			command.copyReportTemplate(event.getReportTemplateListVOS(),account);
			
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0753 : VVD Selection Inquiry 결과를 조회한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
    private EventResponse searchVVDList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0753Event event = (EsmBkg0753Event) e;
        
        PerformanceReportBC command = new PerformanceReportBCImpl();
        List<VesselVVDListVO> list = command.searchVVDList(event.getVesselVVDListVO());
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        eventResponse.setRsVoList(list);

        return eventResponse;
    }
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0753 : VVD Selection Inquiry 에 VVD를 체크한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
    private EventResponse checkVVD(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0753Event event = (EsmBkg0753Event) e;
        
        String check = "";
        String lane	 = "";
        
        PerformanceReportBC command = new PerformanceReportBCImpl();
        List<VesselVVDListVO> list = command.searchVVDList(event.getVesselVVDListVO());
        
        if (list.size() > 0){
        	
        	check = "Y";
        	
        	VesselVVDListVO vo = (VesselVVDListVO)list.get(0);
        	
        	lane  = vo.getSlanCd();
        }else{
        	
        	check = "N";
        }
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        eventResponse.setETCData("check", check);
        eventResponse.setETCData("lane", lane);
        
        return eventResponse;
    }
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0753 : VVD Selection Inquiry 에 VVD 리스트를 체크한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse checkVVDList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0753Event event = (EsmBkg0753Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		try{
			
			command.checkVVDList(event.getVesselVVDListVOS());
			
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0767 : C/A Summary Template 결과를 조회한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReportTemplateList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0767Event event = (EsmBkg0767Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		BkgRptDfltVO returnVo = null;
		
		try{
			EBookingReceiptBC command2 = new EBookingReceiptBCImpl();
			// Delivery - conti_cd
			List<BkgComboVO> conti_cd = command2.searchComboMdmConti();
			BkgComboVO combovo = new BkgComboVO();
			combovo.setVal(" ");
			combovo.setName("All");
			conti_cd.add(0,combovo);

			BkgRptDfltVO vo = event.getBkgRptDfltVO();
			
			vo.setOwnrUsrId(account.getUsr_id());

	        List<BkgRptDfltVO> list = command.searchReportTemplateList(vo);
	        
	        eventResponse.setRsVoList(list);
	        
	        String listSize			= Integer.toString(list.size());
	        
	        if (list.size() > 0){
	        	
	        	for (int i = 0 ; i < list.size() ; i++){
	
	        		returnVo = (BkgRptDfltVO)list.get(i);
	        		
	        		eventResponse.setETCData("rptNm_" + Integer.toString(i), returnVo.getRptNm());
	        		eventResponse.setETCData("rptId_" + Integer.toString(i), returnVo.getRptId());
	        		eventResponse.setETCData("kndCd_" + Integer.toString(i), returnVo.getBkgRptKndCd());
	        		eventResponse.setETCData("seq_" + Integer.toString(i), returnVo.getBzcCondSqlCtnt());
	        		eventResponse.setETCData("ord_" + Integer.toString(i), returnVo.getBzcOrdCtnt());
	        	}
	        }
	        
	        eventResponse.setETCData("listSize",listSize);
	        eventResponse.setRsVoList(conti_cd);
	        
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0767 : C/A Summary Template 에 정보를 입력한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse addReportTemplate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0767Event event = (EsmBkg0767Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		BookingUtil command2 = new BookingUtil();
		BkgReferenceNoGenerationVO vo = new BkgReferenceNoGenerationVO();
		
		BkgRptDfltVO[] bkgRptDfltVOS = event.getBkgRptDfltVOS();
		
		try{
			
			for ( int i=0 ; i < bkgRptDfltVOS.length ; i++) {
				
				if ( bkgRptDfltVOS[i].getIbflag().equals("I")){
					
					vo = command2.manageBkgReferenceNumberGeneration("RPT", account.getOfc_cd(), account.getUsr_id());		
					
					bkgRptDfltVOS[i].setRptId(vo.getRptNo());
				}
				
				bkgRptDfltVOS[i].setUpdUsrId(account.getUsr_id());
			}	
			
			begin();
			
			command.addReportTemplate(bkgRptDfltVOS);
			
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
	 * ESM_BKG_0767 : C/A Summary Template 정보를 삭제한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse removeReportTemplate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0767Event event = (EsmBkg0767Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		BkgRptDfltVO[] bkgRptDfltVOS = event.getBkgRptDfltVOS();
		
		try{
			
			for ( int i=0 ; i < bkgRptDfltVOS.length ; i++) {
				
				bkgRptDfltVOS[i].setUpdUsrId(account.getUsr_id());
			}	
			
			begin();
			
			command.addReportTemplate(bkgRptDfltVOS);
			
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
	 * performancereport의 event 에 대한 특정 리스트 조회 이벤트 처리<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBDRBookingPfmcStatusList(Event e) throws EventException {
	
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0072Event event = (EsmBkg0072Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<BDRBookingStatusListVO> list = command.searchBDRBookingPfmcStatusList(event.getInfoVO());
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	
	}	
	/**
	 * 조회 이벤트 처리<br>
	 * BDR Status Inquiry 정보를 조회합니다.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchBDRBookingStatusList(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0071Event event = (EsmBkg0071Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<SearchBDRBookingStatusListVO> list = command.searchBDRBookingStatusList(event.getInfoVO());
		
		eventResponse.setRsVoList(list);
		
		list = command.getRuntime();
		if(list.size() > 0){
			SearchBDRBookingStatusListVO vo =  list.get(0);
			eventResponse.setETCData("runtime", vo.getRuntime());
		}
		
		return eventResponse;
		
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * BDR Status Inquiry 정보를 조회합니다.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchRollOverInformationList(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkgS007Event event = (EsmBkgS007Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<SearchRollOverInformationVO> list = command.searchRollOverInformationList(event.getInfoVO());
		
		eventResponse.setRsVoList(list);
	
		return eventResponse;
		
	}
	/**
	 * 조회 이벤트 처리<br>
	 * Lane,Direction 콤보 이벤트 처리<br>
	 * 0071화면에 대한 콤보리스트 조회.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		searchSvcLaneByLoc(e,eventResponse);
		searchDirection(e,eventResponse);
		return eventResponse;
		
	}
	
	/**
	 * ESM_BKG_0071 :  화면에 대한 콤보리스트 조회.<br>
	 * Service Lane의 콤보 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @param GeneralEventResponse eventResponse
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSvcLaneByLoc(Event e,GeneralEventResponse eventResponse) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		BookingUtil command = new BookingUtil();
		List<MdmVslSvcLaneVO> list = command.searchSvcLaneCd();
		list.add(0,new MdmVslSvcLaneVO());
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
		
	}
	
	/**
	 * ESM_BKG_0071 :  화면에 대한 콤보리스트 조회.<br>
	 * 
	 * @param Event e
	 * @param GeneralEventResponse eventResponse
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDirection(Event e,GeneralEventResponse eventResponse) throws EventException {
		
		 
		// PDTO(Data Transfer Object including Parameters)
		BookingUtil command = new BookingUtil();
		
		
		//Service Lane의 Direction 콤보 이벤트 처리
		List<BkgComboVO> list = command.searchCombo("CD00714");
	
		eventResponse.setRsVoList(list);
		
		return eventResponse;
		
	}	
	/**
	 * ESM_BKG_0068 : 화면에 대한 콤보리스트 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo0068(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		
       
		// PDTO(Data Transfer Object including Parameters)
		BookingUtil command = new BookingUtil();
		RASCommonBC command1 = new RASCommonBCImpl();
		RsltContiListVO contiVo = null;
		List<RsltContiListVO> contiData = null;
		
		
		BkgComboVO combovo = new BkgComboVO();
		combovo.setDesc("All");
		combovo.setName("All");
		
		
		/*EQ TYPE - CONTAINER TYPE SIZE*/
		List<MdmCntrTpSzVO> eqlist = command.searchTypeSize(null);
		MdmCntrTpSzVO eqvo = new MdmCntrTpSzVO();
		eqvo.setCntrTpszDesc("All");
		eqvo.setCntrTpszRmk("All");
		eqvo.setCntrTpszPsaCd("All");
		eqlist.add(0,eqvo);
		eventResponse.setRsVoList(eqlist);
		

		
		/*R/D R- OUTBOUND RECEIVED*/
		List<BkgComboVO> list = command.searchCombo("CD00764");
		list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		
		/*R/D D- INBOUND DELIVERY*/
		list = command.searchCombo("CD00765");
		list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/*BOOKING STATUS*/
		list = command.searchCombo("CD00769");
		list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/*CARGO STATUS*/
//		list = command.searchCombo("CD00767");
		list = command.searchCombo("CD02716");
//		list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/*CUSTOMER TYPE*/
		list = command.searchCombo("CD00880");
		list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/*DEL CONTINENT*/
//		list = command.searchCombo("CD02169");
//	    list.add(0,combovo);
//		eventResponse.setRsVoList(list);
		
        contiVo = new RsltContiListVO();
        contiData = command1.seacrhRasContiList(contiVo);
        eventResponse.setRsVoList(contiData);
        //eventResponse.setCustomData("contiCd", contiData);
        
		/*Block Stowage Code */
		list = command.searchCombo("CD02678");
		eventResponse.setRsVoList(list);

		
		return eventResponse;
		
	}	

	/**
	 * ESM_BKG_0068 : 화면에 대한 콤보리스트 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo0488(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		searchUserDpcsInfo(e,eventResponse);

		BookingUtil command = new BookingUtil();
    	//S/R KIND
        List<BkgComboVO> list = command.searchCombo("CD01577");
        eventResponse.setRsVoList(list);
        
        //I/F Status
        
        List<BkgComboVO>list2 = command.searchCombo("CD02898");
        BkgComboVO combovo = new BkgComboVO();
        combovo.setVal(" ");
		combovo.setDesc("All");
		combovo.setName("All");
		list2.add(0,combovo);        
        eventResponse.setRsVoList(list2);
        
        //Urgeny
        List<BkgComboVO>list3 = command.searchCombo("CD01987");
        list3.add(0,combovo);     
        eventResponse.setRsVoList(list3);

        //valid Bkg
        List<BkgComboVO>list4 = command.searchCombo("CD02803");
        list4.add(0,combovo);     
        eventResponse.setRsVoList(list4);
        
        PerformanceReportBC prCommand = new PerformanceReportBCImpl();
		
//		String searchDpcsIp	= prCommand.searchDpcsIp(account.getOfc_cd());
//        eventResponse.setETCData("searchDpcsIp", searchDpcsIp);
        
		String[] usrGrpInfo 	= prCommand.searchUserPartCd (account.getUsr_id());
        if (usrGrpInfo != null){
        	eventResponse.setETCData("usrGrpCd", usrGrpInfo[0]);
        	eventResponse.setETCData("usrPrpCd", usrGrpInfo[1]);
        	eventResponse.setETCData("usrSvrCd", usrGrpInfo[2]);
        }else{
        	eventResponse.setETCData("usrGrpCd", "");
        	eventResponse.setETCData("usrPrpCd", "");
        	eventResponse.setETCData("usrSvrCd", "");
        }
		return eventResponse;
	}	
	/**
	 * ESM_BKG_0068 : 화면에 대한 콤보리스트 조회.<br>
	 * 
	 * @param Event e
	 * @param GeneralEventResponse eventResponse
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUserDpcsInfo(Event e,GeneralEventResponse eventResponse) throws EventException {
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		String searchDpcsIp	= command.searchDpcsIp(account.getOfc_cd());
        eventResponse.setETCData("searchDpcsIp", searchDpcsIp);
        
		String[] usrGrpInfo 	= command.searchUserPartCd (account.getUsr_id());
        if (usrGrpInfo != null){
        	eventResponse.setETCData("usrGrpCd", usrGrpInfo[0]);
        	eventResponse.setETCData("usrPrpCd", usrGrpInfo[1]);
        	eventResponse.setETCData("usrSvrCd", usrGrpInfo[2]);
        }else{
        	eventResponse.setETCData("usrGrpCd", "");
        	eventResponse.setETCData("usrPrpCd", "");
        	eventResponse.setETCData("usrSvrCd", "");
        }
        return eventResponse;
	}
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0488 : SR Receiving List 결과를 조회한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
    private EventResponse searchSRReceivingList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0488Event event = (EsmBkg0488Event) e;
        
        /*String srMtchStsCd 	= event.getSrMtchStsCd();
        String fromDt		= event.getFromDt();
        String toDt			= event.getToDt();
        String rcvOfcCd		= event.getRcvOfcCd();*/
        
        PerformanceReportBC command = new PerformanceReportBCImpl();
        //String fromDt, String toDt, String srMtchStsCd, String rcvOfcCd,String srNo
        List<SearchSRReceivingListVO> list = command.searchSRReceivingList(event.getSearchSRReceivingListVO());
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        eventResponse.setRsVoList(list);
        
        event.getSearchSREmlReceivingListVO().setChkEmlRcvFailFlg("Y");
        if (command.chkSREmlFailReceivingList(event.getSearchSREmlReceivingListVO()) == true){
        	eventResponse.setETCData("IS_EML_RCV_FAIL_FLG", "Y");
        }else{
        	eventResponse.setETCData("IS_EML_RCV_FAIL_FLG", "N");
        }
        return eventResponse;
    }
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0488 : SR Receiving List 결과를 조회한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
    private EventResponse searchSREmlReceivingList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0488Event event = (EsmBkg0488Event) e;
       
        PerformanceReportBC command = new PerformanceReportBCImpl();
        //String fromDt, String toDt, String srMtchStsCd, String rcvOfcCd,String srNo
        List<SearchSREmlReceivingListVO> list = command.searchSREmlReceivingList(event.getSearchSREmlReceivingListVO());
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        eventResponse.setRsVoList(list);

        return eventResponse;
    }
    
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0447 : SR Receiving Contents결과를 조회한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
    private EventResponse searchSREmlCtnt(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0447Event event = (EsmBkg0447Event) e;
       
        PerformanceReportBC command = new PerformanceReportBCImpl();
        List<SearchSREmlCtntVO> list = command.searchSREmlCtnt(event.getSearchSREmlCtntVO());
        List<SearchSREmlAtchFileListVO> list2 = command.searchSREmlAtchFileList(event.getSearchSREmlAtchFileListVO());
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        if (list != null && list.size() >0 ){
        	eventResponse.setETCData(list.get(0).getColumnValues());
        }
        eventResponse.setRsVoList(list2);

        return eventResponse;
    }
    
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0447 : 가로/세로가 혼용된 첨부 문서의 재변환을 위해 D-Cube로 변환 요청 메일을 발송한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
    private EventResponse sendEmlConversionRequest(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0447Event event = (EsmBkg0447Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();       
        PerformanceReportBC command = new PerformanceReportBCImpl();

		try {
			begin();
	        List<SearchSREmlCtntVO> list = command.searchSREmlCtnt(event.getSearchSREmlCtntVO());
	        if (list != null && list.size() >0 ){
	        	command.sendEmlConversionRequest(list.get(0), account);
	        }        
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
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0488 : SR Receiving List 에 Remark 를 수정한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
    private EventResponse modifyQueueRemark(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0488Event event = (EsmBkg0488Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		

		String srKndCd 	= event.getSrKndCd();
        String srNo		= event.getSrNo();
        String rcvRmk	= event.getRcvRmk();
		
		try{
			
			begin();
			
			command.addQueueRemark(srNo, account.getUsr_id(), srKndCd, rcvRmk);
			
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
	 * ESM_BKG_0988 : SR Receiving List 에 Remark 를 입력한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
    private EventResponse addQueueRemark(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0988Event event = (EsmBkg0988Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		String srKndCd 	= event.getSrKndCd();
        String srNo		= event.getSrNo();
        String rcvRmk	= event.getRcvRmk();
		
		try{
			begin();
			command.addQueueRemark(srNo, account.getUsr_id(), srKndCd, rcvRmk);
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
	 * ESM_BKG_0488 : SR Receiving List 정보 입력/수정/삭제한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSRReceiving(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0488Event event = (EsmBkg0488Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		try{	
			begin();
			command.manageSRReceiving(event.getBkgSrFaxVOS(),account);
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
	 * ESM_BKG_0489 : SR Receiving List BKG Match & Transfer 에 bkgNo를 체크한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
    private EventResponse checkBkgNoVsSrNo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0489Event event = (EsmBkg0489Event) e;
        
        String bkgNo 	= event.getBkgNo();
        String srNo		= event.getSrNo();
        
        PerformanceReportBC command = new PerformanceReportBCImpl();
        CheckBkgNoVsSrNoVO checkBkgNoVsSrNoVO = command.checkBkgNoVsSrNo(bkgNo, srNo);
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        eventResponse.setETCData("check", checkBkgNoVsSrNoVO.getChkVal());
        eventResponse.setETCData("vvd", checkBkgNoVsSrNoVO.getVvd());
        eventResponse.setETCData("pol_cd", checkBkgNoVsSrNoVO.getPolCd());
        eventResponse.setETCData("pod_cd", checkBkgNoVsSrNoVO.getPodCd());

        return eventResponse;
    }
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0489 : SR Receiving List BKG Match & Transfer 에 IP를 조회한다.<br>
	 * 
	 * @param     EsmBkg0489Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
    /*
    private EventResponse searchDpcsIp(Event e) throws EventException {

        PerformanceReportBC command = new PerformanceReportBCImpl();
        String searchDpcsIp = command.searchDpcsIp(account.getOfc_cd());     
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        eventResponse.setETCData("searchDpcsIp", searchDpcsIp);

        return eventResponse;
    }
    */
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0489 : SR Receiving List BKG Match & Transfer 에 UserPartCd 조회한다.<br>
	 * 
	 * @param     EsmBkg0489Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
    /*
    private EventResponse searchUserPartCd(Event e) throws EventException {
       
        PerformanceReportBC command = new PerformanceReportBCImpl();
                
        String[] usrGrpInfo 	= command.searchUserPartCd (account.getUsr_id());     
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        if (usrGrpInfo != null){
        
        	eventResponse.setETCData("usrGrpCd", usrGrpInfo[0]);
        	eventResponse.setETCData("usrPrpCd", usrGrpInfo[1]);
        	eventResponse.setETCData("usrSvrCd", usrGrpInfo[2]);
        }else{
        	
        	eventResponse.setETCData("usrGrpCd", "");
        	eventResponse.setETCData("usrPrpCd", "");
        	eventResponse.setETCData("usrSvrCd", "");
        }

        return eventResponse;
    }
    */
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0489 : SR Receiving List BKG Match & Transfer 에 UserPartCd 조회한다.<br>
	 * 
	 * @return    String[]
	 * @exception EventException
	 */
    private  String[] searchUserPartCd() throws EventException {
       
        PerformanceReportBC command = new PerformanceReportBCImpl();
                
        String[] usrGrpInfo 	= command.searchUserPartCd (account.getUsr_id());     
        
        return usrGrpInfo;
    }
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0489 : SR Receiving List BKG Match & Transfer 에 AmendReason 리스트를 조회한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
    private EventResponse searchAmendReasonBkgList (Event e) throws EventException {
 
        EsmBkg0489Event event = (EsmBkg0489Event) e;               
        
        String srNo 		= event.getSrNo();
        String faxLogRefNo 	= event.getFaxLogRefNo();
    	String bkgSrKndCd	= event.getBkgSrKndCd();
        GeneralEventResponse eventResponse = new GeneralEventResponse(); 
        PerformanceReportBC command = new PerformanceReportBCImpl();
        if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {	 
            
	        try{	
				begin(); 
				command.modifySrStartTime(srNo,faxLogRefNo,bkgSrKndCd,account);
				commit();
			}catch(EventException ex){
				rollback();
				throw ex;
			}catch(Exception ex){
				throw new EventException(ex.getMessage(), ex);
			}
	        
	        List<DpcsAmendReasonBkgListVO> list = command.searchAmendReasonBkgList(srNo,bkgSrKndCd,account.getUsr_id());
	        
	        /*-----------------------------------------------------------*/
			/*File file = new File(event.getDownloadLocation());
			if ( file.isFile() == false){
				eventResponse.setETCData("isFilePath", "F");
			}else{
				eventResponse.setETCData("isFilePath", "T");
			}*/
			/*-----------------------------------------------------------*/
	        eventResponse.setRsVoList(list);
	        
	        SearchSRReceivingListVO searchSRReceivingListVO = new SearchSRReceivingListVO();
			searchSRReceivingListVO.setSrNo(srNo);
			searchSRReceivingListVO.setFaxLogRefNo(faxLogRefNo);
			
	        List<SearchSRReceivingListVO> list2 = command.searchSRReceivingList(searchSRReceivingListVO);
			eventResponse.setETCData(list2.get(0).getColumnValues());
			
	        /*searchDpcsIp,usrGrpCd,usrPrpCd,	usrSvrCd*/
        	searchUserDpcsInfo(e,eventResponse);
        	
        	BookingUtil util = new BookingUtil();
        	List<BkgComboVO> comboList = util.searchCombo("CD01577");
    		eventResponse.setRsVoList(comboList);
        	
			
        }else{
        	List<DpcsAmendReasonBkgListVO> list = command.searchAmendReasonBkgList(srNo,bkgSrKndCd,account.getUsr_id());
        	eventResponse.setRsVoList(list);
        }
        return eventResponse;
    }
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0489 : SR Receiving List BKG Match & Transfer 에 Match 정보를 수정한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
    private EventResponse modifyBkgNoMatch(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0489Event event = (EsmBkg0489Event)e;
		
		String srNo 		= event.getSrNo();
		String faxLogRefNo 	= event.getFaxLogRefNo();
    	String bkgSrKndCd	= event.getBkgSrKndCd();
		String strBkgNo 	= event.getBkgNo();

		PerformanceReportBC command = new PerformanceReportBCImpl();
				
		try{	
			begin();
			
			DocQueueBkgHistListVO docQueueBkgHistListVO = event.getDocQueueBkgHistListVO();
			docQueueBkgHistListVO.setUpdUsrId(account.getUsr_id());
			if(e.getFormCommand().isCommand(FormCommand.MODIFY01)) {	//Matching Complete
				command.modifyBkgNoMatch(docQueueBkgHistListVO,"T");
				eventResponse.setUserMessage((String) new ErrorHandler("BKG08021",new String[]{}).getUserMessage());
			}else if(e.getFormCommand().isCommand(FormCommand.MODIFY04)) {	//Close ==> W
				command.modifyBkgNoMatch(docQueueBkgHistListVO,"W");
			}else if(e.getFormCommand().isCommand(FormCommand.MODIFY05) ) {	//TRANSFER
				ModifySrTransferVO modifySrTransferVO = new ModifySrTransferVO();
				modifySrTransferVO.setSrNo(srNo);
				modifySrTransferVO.setSrKndCd(bkgSrKndCd);
				modifySrTransferVO.setBkgNo(strBkgNo);
				modifySrTransferVO.setUsrId(account.getUsr_id());
				modifySrTransferVO.setSrMtchStsCd("T");
				modifySrTransferVO.setOfcCd(account.getOfc_cd());
				
				command.modifySrTransfer(modifySrTransferVO);
				/*BKG BOOKING에  SI FLAG Mark */
				GeneralBookingReceiptBC generalBookingReceiptBC = new GeneralBookingReceiptBCImpl();
				generalBookingReceiptBC.modifySiFlag(strBkgNo,"F");
				
				eventResponse.setUserMessage((String) new ErrorHandler("BKG00218",new String[]{}).getUserMessage());
			}
			commit();
			
			SearchSRReceivingListVO searchSRReceivingListVO = new SearchSRReceivingListVO();
			searchSRReceivingListVO.setSrNo(srNo);
			searchSRReceivingListVO.setFaxLogRefNo(faxLogRefNo);
	        
			List<SearchSRReceivingListVO> list = command.searchSRReceivingList(searchSRReceivingListVO);
			eventResponse.setETCData(list.get(0).getColumnValues());
			
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
	 * ESM_BKG_0489 : SR Receiving List BKG Match & Transfer 에 Queue 정보를 삭제한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
    private EventResponse removeQueueBkgNo(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0489Event event = (EsmBkg0489Event)e;
		
		PerformanceReportBC command = new PerformanceReportBCImpl();
		event.getDocQueueBkgHistListVO().setUpdUsrId(account.getUsr_id())	;
		try{	
			
			List<DocQueueBkgHistListVO> docList = command.checkBkgNoOrSrNo(event.getDocQueueBkgHistListVO());
			if (docList !=null && docList.size() > 0) {
				DocQueueBkgHistListVO docQueueBkgHistListVO = docList.get(0);
				
				if (!docQueueBkgHistListVO.getSrWrkStsDt().equals("") 
						&& (!docQueueBkgHistListVO.getSrWrkStsCd().equals("T")
								&& !docQueueBkgHistListVO.getSrWrkStsCd().equals("X"))){
					throw new EventException ((String) new ErrorHandler("BKG08119",new String[]{}).getMessage());
				}
				
				begin();
				command.removeQueueBkgNo(event.getDocQueueBkgHistListVO());
				eventResponse.setUserMessage((String) new ErrorHandler("BKG06010",new String[]{}).getUserMessage());
				commit();
			}
			
			SearchSRReceivingListVO searchSRReceivingListVO = new SearchSRReceivingListVO();
			searchSRReceivingListVO.setSrNo(event.getSrNo());
			searchSRReceivingListVO.setFaxLogRefNo(event.getFaxLogRefNo());
			
			List<SearchSRReceivingListVO> list = command.searchSRReceivingList(searchSRReceivingListVO);
			eventResponse.setETCData(list.get(0).getColumnValues());
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
			//throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0489 : SR Receiving List BKG Match & Transfer 에 Queue정보를 입력/수정/삭제한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBkgQueueList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0489Event event = (EsmBkg0489Event)e;
		
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		DocQueueBkgHistListVO vo = event.getDocQueueBkgHistListVO();
		DocQueueBkgHistListVO[] vos = event.getDocQueueBkgHistListVOS();
		vo.setUpdUsrId(account.getUsr_id());
		try{	
			begin();
			command.manageBkgQueueList(vos,vo,account);
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			commit();
			/**
		    * BPM 연동 처리 부분 ( BPM POC 이후 삭제 필요 )
		    */
			/*if (vo.getSrKndCd().equalsIgnoreCase("F") &&  !vo.getSrNo().equals("")){
				String eventKey = vo.getBkgNo() + "_" +vo.getSrNo();
				BookingInterfaceMgtBC bpmBc = new BookingInterfaceMgtBCImpl();
				bpmBc.bpmExecCall("SI",eventKey,account.getUsr_id());
			}*/
			SearchSRReceivingListVO searchSRReceivingListVO = new SearchSRReceivingListVO();
			searchSRReceivingListVO.setSrNo(vo.getSrNo());
			searchSRReceivingListVO.setFaxLogRefNo(vo.getFaxLogRefNo());
			
			List<SearchSRReceivingListVO> list = command.searchSRReceivingList(searchSRReceivingListVO);
			eventResponse.setETCData(list.get(0).getColumnValues());

		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0067 : 화면에 대한 초기데이타 조회합니다.<br>
	 *      
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse search0067InitData(Event e) throws EventException {
		BookingUtil command = new BookingUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//Doc Part
		List<BkgComboVO> list = command.searchCombo("CD02405");
		eventResponse.setRsVoList(list);
		//Doc Part
		list = command.searchCombo("CD03248");
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * ESM_BKG_0067 : SR Data의 처리 Office 별 B/L Turn Time 집계 현황을 조회한다. (Summary List)
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDPCSTurnTimeSummary(Event e) throws EventException {

		EsmBkg0067Event event = (EsmBkg0067Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<DocPerformanceSummaryVO> list = command.searchDPCSTurnTimeSummary(event.getDocPerformanceSummaryVO());

		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * ESM_BKG_0067 : SR Data의 처리 Office 별 B/L Turn Time 상세실적 현황을 조회한다. (Detail List)
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDPCSTurnTimeList(Event e) throws EventException {

		EsmBkg0067Event event = (EsmBkg0067Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<DocPerformanceReportInVO> list = command.searchDPCSTurnTimeList(event.getDocPerformanceReportInVO());

		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * ESM_BKG_0068 : B/L Data  입력 완료 확인 리포트 기능.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse bkgClearanceCrossCheckList(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0068Event event = (EsmBkg0068Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		List<BkgClearanceCrossCheckListInVO> list = command.bkgClearanceCrossCheckList(event.getInfoVO());
		
		if(list.size() > 0){
			list.get(0).setMaxRows(Integer.parseInt(list.get(0).getTotalCnt()));
			BkgClearanceCrossCheckListInVO vo =  list.get(0);
			eventResponse.setETCData("total_bkg",      vo.getTotalBkg());
			eventResponse.setETCData("total_bl",       vo.getTotalBl());
			eventResponse.setETCData("total_bkg_f",    vo.getTotalBkgF());
			eventResponse.setETCData("total_bkg_t",    vo.getTotalBkgT());
			eventResponse.setETCData("total_ctrl_f",   vo.getTotalCtrlF());
			eventResponse.setETCData("total_ctrl_t",   vo.getTotalCtrlT());
			eventResponse.setETCData("total_cfm",      vo.getTotalCfm());
			eventResponse.setETCData("total_vl",       vo.getTotalVl());
			eventResponse.setETCData("total_cm",       vo.getTotalCm());
			eventResponse.setETCData("total_md",       vo.getTotalMd());
			eventResponse.setETCData("total_charge",   vo.getTotalCharge());
			eventResponse.setETCData("total_apprval",  vo.getTotalApprval());
			eventResponse.setETCData("total_issue",    vo.getTotalIssue());
			eventResponse.setETCData("total_receiving", vo.getTotalReceiving());
			eventResponse.setETCData("aes_yn", vo.getAesYn());
			
			eventResponse.setETCData("dpcs_ttl",      vo.getDpcsTtl());
			eventResponse.setETCData("dpcs_input",       vo.getDpcsInput());
			eventResponse.setETCData("dpcs_rate",       vo.getDpcsRate());
			eventResponse.setETCData("dpcs_qa",       vo.getDpcsQa());
			eventResponse.setETCData("dpcs_bl_proof",   vo.getDpcsBlProof());
			eventResponse.setETCData("status_complete",  vo.getStatusComplete());
			eventResponse.setETCData("status_pending",    vo.getStatusPending());
			eventResponse.setETCData("status_open", vo.getStatusOpen());
			eventResponse.setETCData("total_vgm_cnt", vo.getTotalVgmCnt());
			eventResponse.setETCData("total_cntr_cnt", vo.getTotalCntrCnt());
			eventResponse.setETCData("total_no_vgm_cnt", vo.getTotalNoVgmCnt());
			
		}
		eventResponse.setRsVoList(list);

		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0068 : B/L Data  입력 완료 확인 리포트 기능 - RD 프린트.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse bkgClearanceCrossCheckListForRD(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0772Event event = (EsmBkg0772Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<BkgClearanceCrossCheckListInVO> list = command.bkgClearanceCrossCheckList(event.getInfoVO());
		StringWriter sw = new StringWriter();
	    PrintWriter pw = new PrintWriter(sw);
	    
	    Map<String, String> colValues = null;
		//메인 페이지 
		for (int i = 0; i < list.size(); i++) {			
			colValues = list.get(i).getColumnValues();		
			
			    
			pw.print(colValues.get("bkg_no") +SP);	         //bkg_no          
			pw.print(colValues.get("bl_no") +SP);	         //bl_no           
			pw.print(colValues.get("bkg_sts_cd") +SP);	     //bkg_sts_cd      
			pw.print(colValues.get("bkg_cgo_tp_cd") +SP);	 //bkg_cgo_tp_cd   
			pw.print(colValues.get("qty_bkg") +SP);	         //qty_bkg         
			pw.print(colValues.get("qty_cntr") +SP);	     //qty_cntr        
			pw.print(colValues.get("cntr_cfm_flg") +SP);	 //cntr_cfm_flg    
			pw.print(colValues.get("cntr_no") +SP);	         //cntr_no         
			pw.print(colValues.get("sz") +SP);	             //sz              
			pw.print(colValues.get("vol") +SP);	             //vol             
			pw.print(colValues.get("firm") +SP);	         //firm            
			pw.print(colValues.get("st") +SP);	             //st              
			pw.print(colValues.get("cm") +SP);	             //cm              
			pw.print(colValues.get("shipper") +SP);	         //shipper         
			pw.print(colValues.get("ff") +SP);	             //ff              
			pw.print(colValues.get("md") +SP);	             //md              
			pw.print(colValues.get("aes") +SP);	             //aes
			pw.print(colValues.get("tax_id") +SP);	         //tax_id   
			pw.print(colValues.get("pod_cd") +SP);	         //pod_cd          
			pw.print(colValues.get("del_cd") +SP);	         //del_cd          
			pw.print(colValues.get("rcv_term_cd") +SP);	     //rcv_term_cd     
			pw.print(colValues.get("de_term_cd") +SP);	     //de_term_cd      
			pw.print(colValues.get("charge") +SP);	         //charge          
			pw.print(colValues.get("apprval") +SP);	         //apprval         
			pw.print(colValues.get("issue") +SP);	         //issue           
			pw.print(colValues.get("receiving") +SP);	     //receiving       
			pw.print(colValues.get("total_bkg") +SP);	     //total_bkg       
			pw.print(colValues.get("total_bl") +SP);	     //total_bl        
			pw.print(colValues.get("total_bkg_f") +SP);	     //total_bkg_f     
			pw.print(colValues.get("total_bkg_t") +SP);	     //total_bkg_t     
			pw.print(colValues.get("total_ctrl_f") +SP);	 //total_ctrl_f    
			pw.print(colValues.get("total_ctrl_t") +SP);	 //total_ctrl_t    
			pw.print(colValues.get("total_cfm") +SP);	     //total_cfm       
			pw.print(colValues.get("total_vl") +SP);	     //total_vl        
			pw.print(colValues.get("total_cm") +SP);	     //total_cm        
			pw.print(colValues.get("total_md") +SP);	     //total_md        
			pw.print(colValues.get("total_charge") +SP);	 //total_charge    
			pw.print(colValues.get("total_apprval") +SP);	 //total_apprval   
			pw.print(colValues.get("total_issue") +SP);	     //total_issue     
			pw.print(colValues.get("total_receiving") +SP);	 //total_receiving 		     	                     
			pw.print(colValues.get("dense_rank2") +SP);	     //dense_rank2 																				     	                     
			pw.print("\r\n");
				
		}
		pw.println(EOR);
		
		//log.debug("#####################################"+sw.toString());
		eventResponse.setCustomData("RD", sw.toString());
		
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0417 : 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPCTCLSReport(Event e) throws EventException {
	
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0417Event event = (EsmBkg0417Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<PortCLSReportVO> list = null;
		if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.SEARCH01)){ 
			list = command.searchPCTCLSReport(event.getPortCLSReportVO());
		}
		
		
		if (e.getFormCommand().isCommand(FormCommand.SEARCH02) ){
			event.getPortCLSReportVO().setReportType("SUM");
			event.getPortCLSReportVO().setRowsPerPage("9999999");
			event.getPortCLSReportVO().setCurrPage("1");
			
			List<PortCLSReportVO> list2 = command.searchPCTCLSReport(event.getPortCLSReportVO());
			if(list2.size() > 0 && list2 != null){
				
				PortCLSReportVO vo = list2.get(0);
				eventResponse.setETCData(vo.getColumnValues());
			}
		}
		eventResponse.setETCData("curr_page", event.getPortCLSReportVO().getCurrPage());
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	
	}	
	/**
	 * ESM_BKG_0417 : 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse excelDownload_0417(Event e) throws EventException {
		EsmBkg0417Event event = (EsmBkg0417Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<PortCLSReportVO> list = command.searchPCTCLSReport(event.getPortCLSReportVO());
		
		if(list.size() > 0 && list != null){
			String headTitle = "No.￠Booking No.￠B/L No.￠BKG STS￠Rating STS￠VVD￠Lane￠REV￠Contranct No.￠CNTR Confirm￠ATD￠ETD￠CN/NF Code￠CNEE/NTFY￠SH Code.￠Shipper￠POL￠S/R￠Booking Office￠Booking Staff";
			String title[] = headTitle.split("￠");
			
			String column_names = "rnum￠bkg_no￠bl_no￠bkg_sts_cd￠brh_cfm_ind_nm￠vvd_cd￠bkg_lane￠lane_ind￠ctrt_no￠cntr_cfm_flg￠atd￠etd￠cnee_cd￠cnee_nm￠shpr_cd￠shpr_nm￠pol_cd￠si_flg￠bkg_ofc_cd￠bkg_stf";
			String columns[] = column_names.split("￠");
			
			eventResponse.setCustomData("vos", list);
			eventResponse.setCustomData("title", title);
			eventResponse.setCustomData("columns", columns);
			eventResponse.setCustomData("fileName", "PortClosingStatusReport.xls");
			eventResponse.setCustomData("isZip", false);
			
		}
		
		return eventResponse;
	}
	
		
	/**
     * ESM_BKG_0417 : 화면에 대한 콤보리스트 조회.<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchComCode0417(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        EBookingReceiptBC command2 = new EBookingReceiptBCImpl();
        List<BkgComboVO> list = command.searchCombo("CD00769");
        
        BkgComboVO combovo = new BkgComboVO();
        combovo.setVal(" ");
		combovo.setDesc("All");
		combovo.setName("All");
		list.add(0,combovo);
        
        eventResponse.setRsVoList(list);
        
        List<BkgComboVO> list2 = command.searchCombo("CD01656");
        eventResponse.setRsVoList(list2);

        //RHQ
        //Region
        List<BkgComboVO> list3 = command.searchRgnOfficeCd();
        //list3.add(0,combovo);
        eventResponse.setRsVoList(list3);
        
        //DEL Conti
        List<BkgComboVO> list4 = command2.searchComboMdmConti();
        eventResponse.setRsVoList(list4);

        //Lane
        List<MdmVslSvcLaneVO> laneList = command.searchSvcLaneCd();
        eventResponse.setRsVoList(laneList);
        
        //rtro_knd_cd
        eventResponse.setRsVoList(command.searchCombo("CD03367"));
        
    	// Officed Type 
        eventResponse.setRsVoList(command.searchCombo("CD02002"));
        
        return eventResponse;
    }
	
	/**
     * ESM_BKG_S007 : 화면에 대한 콤보리스트 조회.<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchComCodeS007(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
        BkgComboVO combovo = new BkgComboVO();
		combovo.setDesc("");
		combovo.setName("");
        
      //RHQ
        //Region
        List<BkgComboVO> list = command.searchRgnOfficeCd();
        list.add(0,combovo);
        eventResponse.setRsVoList(list);
        
      //Reasong of roll over
        List<BkgComboVO> list1 = command.searchCombo("CD01571");
        list1.add(0,combovo);
        eventResponse.setRsVoList(list1);
        
      //Contract Type
        List<BkgComboVO> list2 = command.searchCombo("CD01716");
        list2.add(0,combovo);
        eventResponse.setRsVoList(list2);
        
        return eventResponse;
    }
    /**
	 * ESM_BKG_0162 : 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerStowageList(Event e) throws EventException {
	
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0162Event event = (EsmBkg0162Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<CntrStowageintVO> list = command.searchContainerStowageList(event.getCntrStowageintVO());
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	
	}	
	
	/**
     * ESM_BKG_0162 : 화면에 대한 콤보리스트 조회.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchComCode0162(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
        BkgComboVO combovo = new BkgComboVO();
        combovo.setVal("ALL");
		combovo.setDesc("All");
		combovo.setName("All");

        List<BkgComboVO> list = command.searchCombo("CD00592");
        eventResponse.setRsVoList(list);
        
        List<BkgComboVO> list2 = command.searchCombo("CD02136");
        eventResponse.setRsVoList(list2);
        

        List<BkgComboVO> list3 = command.searchCombo("CD02135");
        eventResponse.setRsVoList(list3);
        

        List<BkgComboVO> list4 = command.searchCombo("CD01053");
        eventResponse.setRsVoList(list4);
        

        List<BkgComboVO> list5 = command.searchCombo("CD00136");
        list5.add(0,combovo);
        eventResponse.setRsVoList(list5);
        
        return eventResponse;
    }
    /**
	 *ESM_BKG_0595 : 조회 이벤트 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFrtSumList(Event e) throws EventException {
	
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0595Event event = (EsmBkg0595Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<FreightChargeSummaryReportInVO> list = command.searchFrtSumList(event.getFreightChargeSummaryReportInVO());
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	
	}	
	/**
     * ESM_BKG_0595 : 화면에 대한 콤보리스트 조회.<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchComCode0595(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
    	//E/Q Type/Size
    	List<MdmCntrTpSzVO> list = command.searchTypeSize(null);
        eventResponse.setRsVoList(list);
        
        //Freight & Charge Type
        List<BkgComboVO> list2 = command.searchCombo("CD00630");
        eventResponse.setRsVoList(list2);
        
        //Revenue Class
        List<BkgComboVO> list3 = command.searchCombo("CD00628");
        eventResponse.setRsVoList(list3);
          
        return eventResponse;
    }
    
    /**
	 * ESM_BKG_0618 :  조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBookingListForLoadingConfirmation(Event e) throws EventException {
	
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0618Event event = (EsmBkg0618Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<LoadingConfirmationinVO> list = command.searchBookingListForLoadingConfirmation(event.getLoadingConfirmationinVO());
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	
	}	
	/**
     * ESM_BKG_0618 : 화면에 대한 콤보리스트 조회.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchComCode0618(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
        //Customer Type
        List<BkgComboVO> list1 = command.searchCombo("CD00880");
        eventResponse.setRsVoList(list1);
            
        return eventResponse;
    }
    
    /**
     * ESM_BKG_0618 :  0618화면에서 MAIL,  FAX 전송.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse sendLoadingConfirmation(Event e) throws EventException {
    	
    	// PDTO(Data Transfer Object including Parameters)
		EsmBkg0618Event event = (EsmBkg0618Event)e;
		StatusReportBC statusBc = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<BkgNtcHisVO> bkgNtcHisVOs = null;
		//String msg_cd="";	
		try{	
			begin();
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				//msg_cd = "BKG00243";
				/*MAIL 전송*/
				bkgNtcHisVOs =statusBc.sendEmailByBkgNoList(event.getLoadingConfirmationinVO(),event.getLoadingConfirmationinVOS(),account);
				
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				//msg_cd = "BKG00242";
				/*FAX 전송*/
				bkgNtcHisVOs =statusBc.sendFaxByBkgNoList(event.getLoadingConfirmationinVO(),event.getLoadingConfirmationinVOS(),account);
			}
			
			/*msgs['BKG00242'] = "Failed to transmit to the fax server. Contact the server admin";
			msgs['BKG00243'] = "Failed to transmit to the email server. Contact the server admin";
			*/ 
			BookingHistoryMgtBC hisBc = new BookingHistoryMgtBCImpl();
			//HisBc.createBookingNoticeHistory(bkgNtcHisVOs);
			hisBc.createBkgNtcHis(bkgNtcHisVOs,"ESM_BKG_0618");
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
	 * ESM_BKG_0619 :  조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOutBdMovementStsList(Event e) throws EventException {
	
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0619Event event = (EsmBkg0619Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		/*1.Outbound Container Movement Status*/
		List<OutBdMovementStsListInVO> list = command.searchOutBdMovementStsList(event.getOutBdMovementStsListInVO());
		eventResponse.setRsVoList(list);
		/*2.Outbound Container Movement Status by Yard Report*/
		List<OutBdMovementStsYardSumListOutVO> list2 = command.searchOutBdMovementByYardSum(event.getOutBdMovementStsListInVO());
		eventResponse.setRsVoList(list2);
		/*3.Outbound Container Movement Status by Type/Size Report*/
		List<OutBdMovementStsTPSZSumListOutVO> list3 = command.searchOutBdMovementByTPSZSum(event.getOutBdMovementStsListInVO());
		eventResponse.setRsVoList(list3);
		
		return eventResponse;
	
	}	
	
	/**
	 * ESM_BKG_1110 :  조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOutBdEirMovementStatusList(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg1110Event event = (EsmBkg1110Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<OutBdEirMovementStatusListVO> list = command.searchOutBdEirMovementStatusList(event.getOutBdEirMovementStatusListVO());
		eventResponse.setRsVoList(list);
		
		return eventResponse;
		
	}	
	
	 /**
     * ESM_BKG_0814 : Outbound Container Movement Status by Yard 인쇄 화면.<br>
     * 호출 화면: ESM_BKG_0619 
     * 
     * @category ESM_BKG_0814
     * @category report0814
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse report0814(Event e) throws EventException {

		// BC 객체 생성|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|100|&&|0|&&|0|&&| MYPKGTM|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|12|&&|1|&&|0|&&|0|&&| SGSINKA|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|1|&&|0|&&|0|&&|0|&&| VNSGNY6|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|18|&&|0|&&|0|&&| USLGBPT|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|1|&&|0|&&|0|&&| IDJKTY7|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|2|&&|25|&&|0|&&|0|&&| KRPUSYG|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|60|&&|12|&&|0|&&|72|&&|65|&&|103|&&|0|&&|64|&&| USOAKM1|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|27|&&|0|&&|27|&&|0|&&|0|&&|0|&&|0|&&| AUSYDCT|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|3|&&|1|&&|0|&&|0|&&| THBKKY6|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|1|&&|0|&&|0|&&| JPTOYY1|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|6|&&|0|&&|0|&&| //EOR// 
		StatusReportBC command = new StatusReportBCImpl();
		
		// 반환 객체 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		// 이벤트 생성
		EsmBkg0814Event event = (EsmBkg0814Event)e;
		
		OutBdMovementStsListInVO outBdMovementStsListInVO = new OutBdMovementStsListInVO();
		List<OutBdMovementStsYardSumListOutVO> list1 = null;
		List<OutBdMovementStsYardSumListOutVO> list = new ArrayList<OutBdMovementStsYardSumListOutVO>();
		
		String[] vvdCd = null;
		
		vvdCd = event.getOutBdMovementStsListInVO().getVvdCd().split(",");
		
		for(int i=0;i<vvdCd.length;i++){
			outBdMovementStsListInVO = event.getOutBdMovementStsListInVO();
			outBdMovementStsListInVO.setVvdCd(vvdCd[i]);
			list1 = command.searchOutBdMovementByYardSum(outBdMovementStsListInVO);
			if ( list1 != null && list1.size() > 0 ){
				list.addAll(list1);
//				for(int j=0;j<list1.size();j++){
//					list.add(list1.get(j));
//				}
			}
		}
	    
		StringWriter sw = new StringWriter();
	    PrintWriter pw = new PrintWriter(sw);
	    
		//메인 페이지 
		for (int i = 0; i < list.size(); i++) {			
			OutBdMovementStsYardSumListOutVO vo = list.get(i);		
			
			pw.print(vo.getVvdCd()+SP); 
			pw.print(vo.getTrdCd()+SP); 
			pw.print(vo.getSubTrdCd()+SP); 
			pw.print(vo.getRlaneCd()+SP); 
			pw.print(vo.getSubStr()+SP); 
			pw.print(vo.getOrgYdCd()+SP);
			
			pw.print(vo.getOpDr2()+SP); 
			pw.print(vo.getOpDr4()+SP);
			pw.print(vo.getOpRf2()+SP);
			pw.print(vo.getOpRf4()+SP);
			
			pw.print(vo.getOcDr2()+SP); 
			pw.print(vo.getOcDr4()+SP);
			pw.print(vo.getOcRf2()+SP);
			pw.print(vo.getOcRf4()+SP);
			
			pw.print(vo.getEtnDr2()+SP); 
			pw.print(vo.getEtnDr4()+SP);
			pw.print(vo.getEtnRf2()+SP);
			pw.print(vo.getEtnRf4()+SP);
			
			pw.print(vo.getMtDr2()+SP); 
			pw.print(vo.getMtDr4()+SP);
			pw.print(vo.getMtRf2()+SP);
			pw.print(vo.getMtRf4()+SP);
			
			pw.print(vo.getOtDr2()+SP); 
			pw.print(vo.getOtDr4()+SP);
			pw.print(vo.getOtRf2()+SP);
			pw.print(vo.getOtRf4()+SP);
			pw.print("\r\n");
			
		}
		pw.println(EOR);
		
		//log.debug(sw.toString());
		eventResponse.setCustomData("RD", sw.toString());
		
		return eventResponse;
	}			
	
	/**
     * ESM_BKG_0815 : Outbound Container Movement Status by Type/Size  인쇄 화면.<br>
     * 호출 화면: ESM_BKG_0619 
     * 
     * @category ESM_BKG_0815
     * @category report0815
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse report0815(Event e) throws EventException {

		// BC 객체 생성 
		StatusReportBC command = new StatusReportBCImpl();
		
		// 반환 객체 
		GeneralEventResponse eventResponse = new GeneralEventResponse();		

		OutBdMovementStsListInVO outBdMovementStsListInVO = new OutBdMovementStsListInVO();
		List<OutBdMovementStsTPSZSumListOutVO> list1 = null;
		List<OutBdMovementStsTPSZSumListOutVO> list =  new ArrayList<OutBdMovementStsTPSZSumListOutVO>();
		
		
		// 이벤트 생성
		EsmBkg0814Event event = (EsmBkg0814Event)e;
		

		String[] vvdCd = null;
		
		vvdCd = event.getOutBdMovementStsListInVO().getVvdCd().split(",");
		
		for(int i=0;i<vvdCd.length;i++){
			outBdMovementStsListInVO = event.getOutBdMovementStsListInVO();
			outBdMovementStsListInVO.setVvdCd(vvdCd[i]);
			list1 = command.searchOutBdMovementByTPSZSum(outBdMovementStsListInVO);
			if ( list1 != null && list1.size() > 0 ){
				list.addAll(list1);
//				for(int j=0;j<list1.size();j++){
//					list.add(list1.get(j));
//				}
			}
		}
	    
//		List<OutBdMovementStsTPSZSumListOutVO> list1 = command.searchOutBdMovementByTPSZSum(event.getOutBdMovementStsListInVO());
	    
		StringWriter sw = new StringWriter();
	    PrintWriter pw = new PrintWriter(sw);
	    
		//메인 페이지 
		for (int i = 0; i < list.size(); i++) {			
			OutBdMovementStsTPSZSumListOutVO vo = list.get(i);		

			pw.print(vo.getVvdCd()+SP); 
			pw.print(vo.getTrdCd()+SP); 
			pw.print(vo.getSubTrdCd()+SP); 
			pw.print(vo.getRlaneCd()+SP); 
			pw.print(vo.getSubStr()+SP); 
			pw.print(vo.getCntrTpszCdMv()+SP); 
			
			pw.print(vo.getBkgQty()+SP); 
			pw.print(vo.getOp()+SP);
			pw.print(vo.getOc()+SP);
			pw.print(vo.getEtn()+SP);
			
			pw.print(vo.getCy()+SP); 
			pw.print(vo.getVl()+SP);
			pw.print(vo.getMt()+SP);
			pw.print(vo.getOt()+SP);
			
			pw.print(vo.getTtl()+SP); 
			pw.print(vo.getDiffQty()+SP);
			pw.print("\r\n");
				
		}
		pw.println(EOR);
		
		//System.out.println(sw.toString());
		eventResponse.setCustomData("RD", sw.toString());
		
		return eventResponse;
	}	
	
	/**
     * ESM_BKG_0619 : 화면에 대한 로딩시 콤보리스트 조회.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchComCode0619(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
		EsmBkg0619Event event = (EsmBkg0619Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        StatusReportBCImpl command2 = new StatusReportBCImpl();
        
        BkgComboVO combovo = new BkgComboVO();
        combovo.setVal(" ");
		combovo.setDesc("All");
		combovo.setName("All");
		
    	//RCV_TERM_CD 
        List<BkgComboVO> list = command.searchCombo("CD00765");
        list.remove(0);
        list.add(0,combovo);
        eventResponse.setRsVoList(list);
        
        //DE_TERM_CD
        List<BkgComboVO> list2 = command.searchCombo("CD00764");
        list2.remove(0);
        list2.add(0,combovo);
        eventResponse.setRsVoList(list2);
        
        //BKG Status
        List<BkgComboVO> list3 = command.searchCombo("CD00769");
        list3.remove(0);
        list3.add(0,combovo);
        eventResponse.setRsVoList(list3);
        
        //BKG Kind
        List<BkgComboVO> list4 = command.searchCombo("CD01619");
        list4.remove(0);
        list4.add(0,combovo);
        eventResponse.setRsVoList(list4);
        
        //Service Mode
       /* List<BkgComboVO> list5 = command.searchCombo("CD01052");
        eventResponse.setRsVoList(list5);*/
        
        //Cargo Type
        List<BkgComboVO> list6 = command.searchCombo("CD00767");
        list6.remove(0);
        list6.add(0,combovo);
        eventResponse.setRsVoList(list6);
        
        //Customer Type
        List<BkgComboVO> list7 = command.searchCombo("CD00880");
        /*list7.remove(0);
        list7.add(0,combovo);*/
        eventResponse.setRsVoList(list7);
        
		//Trade List
		List<SearchTradeListVO> list8 = command2.searchTradeList("tradeSearch",event.getOutBdMovementStsListInVO());
		eventResponse.setRsVoList(list8);
		
		//Sub Trade List
		event.getOutBdMovementStsListInVO().setTrdCd("");
		List<SearchTradeListVO> list9 = command2.searchTradeList("subTradeSearch",event.getOutBdMovementStsListInVO());
		eventResponse.setRsVoList(list9);
		
		//Lane List
		event.getOutBdMovementStsListInVO().setTrdCd("");
		event.getOutBdMovementStsListInVO().setSubTrdCd("");
		List<SearchTradeListVO> list10 = command2.searchTradeList("revLaneSearch",event.getOutBdMovementStsListInVO());
		eventResponse.setRsVoList(list10);
        
        return eventResponse;
    }

    /**
	 * ESM_BKG_0409 :  리스트 조회 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDPCSPfmcErrorList(Event e) throws EventException {
	
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0409Event event = (EsmBkg0409Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<SearchDPCSPfmcErrorListVO> list = command.searchDPCSPfmcErrorList(event.getSearchDPCSPfmcErrorListVO());
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	
	}	
	
	/**
     * ESM_BKG_0409 : 화면에 대한 콤보리스트 조회.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchComCode0409(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
    	//Performance by Queue
        List<BkgComboVO> list = command.searchCombo("CD02159");
        eventResponse.setRsVoList(list);
          
        BkgComboVO combovo = new BkgComboVO();
        combovo.setVal(" ");
		combovo.setDesc("All");
		combovo.setName("All");
        //Amend Reason
        List<BkgComboVO> list2 = command.searchCombo("CD01575");
        list2.remove(0);
        list2.add(0,combovo);
        eventResponse.setRsVoList(list2);
        
        //Doc Part
        List<BkgComboVO> list3 = command.searchCombo("CD02405");
        eventResponse.setRsVoList(list3);
      
        return eventResponse;
    }
    
    /**
	 * ESM_BKG_0620 : 화면 콤보 로딩시 TRO STATUS LIST조회<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTroStatusList(Event e) throws EventException {
	
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0620Event event = (EsmBkg0620Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<TroStatusListInVO> list = command.searchTroStatusList(event.getTroStatusListInVO());
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	
	}	
	
	/**
     * ESM_BKG_0620 : 화면에 대한 콤보리스트 조회.<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchComCode0620(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
    	//BKG Status
        List<BkgComboVO> list = command.searchCombo("CD00769");
        eventResponse.setRsVoList(list);
        
        //Zone
        List<BkgComboVO> list2 = command.searchCombo("CD00206");
        eventResponse.setRsVoList(list2);
        
        return eventResponse;
    }
    
    /**
     * ESM_BKG_0620 : 화면에 대한 Staff리스트 조회.<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchStaffList0620(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        EsmBkg0620Event event = (EsmBkg0620Event)e;
    	String ofc_cd = event.getTroStatusListInVO().getBkgOfcCd();
    	//StaffList
        List<StaffListByOfcCdVO> list = command.searchStaffListByOfcCd(ofc_cd);
        eventResponse.setRsVoList(list);
            
        
        return eventResponse;
    }

    
    
    
    /**
	 * ESM_BKG_0226 : 조회 이벤트 처리<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEBkgSiUploadStsList(Event e) throws EventException {
	
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0226Event event = (EsmBkg0226Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<EBkgSiUploadStsReportInVO> list = null;
		String reportType =JSPUtil.getNull(event.getEBkgSiUploadStsReportInVO().getReportType());
		
		/*서버 ID*/
		event.getEBkgSiUploadStsReportInVO().setServerId(account.getCnt_cd());
		/*1.Pending Report*/
		if (reportType.equals("P")){
			list = command.searchEBkgSiUploadStsListByPending(event.getEBkgSiUploadStsReportInVO());
		/*2.Delay Report*/
		}else if (reportType.equals("D")){
			list = command.searchEBkgSiUploadStsListByDealy(event.getEBkgSiUploadStsReportInVO());
		/*3.Detail Report	*/
		}else if (reportType.equals("T")){		
			list = command.searchEBkgSiUploadStsListByDetail(event.getEBkgSiUploadStsReportInVO());
		}
		//List<EBkgSiUploadStsReportInVO> list = command.searchEBkgSiUploadStsListByPending(event.getEBkgSiUploadStsReportInVO());
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	
	}	
    
    /**
     * ESM_BKG_0226 : 화면에 대한 콤보리스트 조회.<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchComCode0226(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
    	//Report Type
        List<BkgComboVO> list = command.searchCombo("CD02179");
        eventResponse.setRsVoList(list);
        
        //Region
        List<BkgComboVO> list2 = command.searchRgnOfficeCd();
        eventResponse.setRsVoList(list2);
        
        //Upload Status - bkg_upld_sts_cd
        List<BkgComboVO> list3 = command.searchCombo("CD01630");
        eventResponse.setRsVoList(list3);
            
        
        return eventResponse;
    }
    


    
    /**
	 * ESM_BKG_0104 : 0104 Report template(Default, Detail, User Set) 을 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReportTemplateBstVipList(Event e) throws EventException {
	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0104Event event = (EsmBkg0104Event)e;
		SpecialReportBC command = new SpecialReportBCImpl();
		event.getInfoVO().setUpdUsrId(account.getUsr_id());
		List<ReportTemplateListVO> list = command.searchReportTemplateBstVipList(event.getInfoVO());
		
		eventResponse.setRsVoList(list);
		return eventResponse;
	}  
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0104_01 : Office로 Staff List를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStaffListByOfcCd(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0104Event event = (EsmBkg0104Event)e;
		BookingUtil command = new BookingUtil();
		
		if(event.getOfcGubun().equals("LO")){
			List<SearchSrepCdListVO> list = command.searchSrepCdList(event.getOfcCd());
			eventResponse.setRsVoList(list);
		}else {
			List<StaffListByOfcCdVO> list = command.searchStaffListByOfcCd(event.getOfcCd());
			eventResponse.setRsVoList(list);
		}
		
		return eventResponse;
	}
	/**
	 * ESM_BKG_0104 : 0104 Report template(Default, Detail, User Set) 을 트랜잭션 처리합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageReportTemplateBstVipList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0104Event event = (EsmBkg0104Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		BookingUtil command2 = new BookingUtil();
		
		try{
			ReportTemplateListVO[] reportTemplateListVO = event.getInfoVOs();
			BkgReferenceNoGenerationVO vo = null;
			for ( int i=0; reportTemplateListVO != null && i<reportTemplateListVO.length; i++ ) {
				if ( reportTemplateListVO[i].getIbflag().equals("I")){
					vo = command2.manageBkgReferenceNumberGeneration("RPT", account.getOfc_cd(), account.getUsr_id());		
					reportTemplateListVO[i].setRptId(vo.getRptNo());					
				}
			}
			begin();
			command.manageReportTemplateBstVipList(reportTemplateListVO,account);
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
	 * ESM_BKG_0104_01 : Office로 Sales Team List를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSalesTeamList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0104Event event = (EsmBkg0104Event)e;
		BookingUtil command = new BookingUtil();
		
		List<MdmSlsRepVO> list = command.searchSalesTeamList(event.getOfcCd());
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Direction,R/D Term....등 콤보 이벤트 처리<br>
	 * 0103,0104_01화면에 대한 콤보리스트 조회.<br>
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo0103_0104_01(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BookingUtil command = new BookingUtil();
		SpecialReportBC command2 = new SpecialReportBCImpl();
        RsltCdListVO custVo = null;
        
		/* Dir */
		searchDirection(e,eventResponse);
		
		BkgComboVO combovo = new BkgComboVO();
		combovo.setDesc("");
		combovo.setName("All");
		
		/* R/D Term R- OUTBOUND RECEIVED */
		List<BkgComboVO> list = command.searchCombo("CD00764");
		//list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/* R/D Term D- INBOUND DELIVERY */
		list = command.searchCombo("CD00765");
		//list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/* DELIVERY Mode */
//		list = command.searchCombo("CD01661");
		
		list = command.searchCombo("CD02455");
		list.add(0,combovo);

		//list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/* Booking Kind */
		list = command.searchCombo("CD01619");
		//list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/*EQ TYPE - CONTAINER TYPE SIZE */
		List<MdmCntrTpSzVO> eqlist = command.searchTypeSize(null);
		MdmCntrTpSzVO eqvo = new MdmCntrTpSzVO();
		eqvo.setCntrTpszDesc("All");
		eqvo.setCntrTpszRmk("All");
		eqvo.setCntrTpszPsaCd("All");
		//eqlist.add(0,eqvo);
		eventResponse.setRsVoList(eqlist);
		
		/* S Mode */
		list = command.searchCombo("CD02149");
		//list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/* S Route */
		list = command2.searchScontiCd();
		//list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/*CUSTOMER TYPE */
		list = command.searchCombo("CD00704");
		//list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/* Report Type List */
		EsmBkg0104Event event = (EsmBkg0104Event)e;
		event.getInfoVO().setUpdUsrId(account.getUsr_id());
		List<ReportTemplateListVO> rlist = command2.searchReportTemplateBstVipList(event.getInfoVO());
		eventResponse.setRsVoList(rlist);
		
		/* RHQ List */		
		RASCommonBC rASCommand = new RASCommonBCImpl();
		List<RsltCdListVO> customData = null;
    	custVo = new RsltCdListVO();
    	custVo.setEtc2("");
        customData = rASCommand.searchRasOrganizationList(custVo);
        eventResponse.setRsVoList(customData);

        //CTRT_CNG_TP_CD.
        list = command.searchCombo("CD03355");
        eventResponse.setRsVoList(list);
        
        //RTRO_KND_CD.  
        list = command.searchCombo("CD03367");
        eventResponse.setRsVoList(list);
         
        // Block Stowage Code
		list = command.searchCombo("CD02678");
		eventResponse.setRsVoList(list);
        
        return eventResponse;
			
	}
	/**
	 * 조회 이벤트 처리<br>
	 * Direction,R/D Term....등 콤보 이벤트 처리<br>
	 * 0625,0104_02화면에 대한 콤보리스트 조회.<br>
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo0625_0104_02(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		BookingUtil command = new BookingUtil();
		SpecialReportBC command2 = new SpecialReportBCImpl();
		
//		BkgComboVO combovo = new BkgComboVO();
//		combovo.setDesc("");
//		combovo.setName("All");
		
		/* Customer Type CD */
		List<BkgComboVO> list = command.searchCombo("CD00880");
		//list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		
		/* Report Type List */
		EsmBkg0104Event event = (EsmBkg0104Event)e;
		event.getInfoVO().setUpdUsrId(account.getUsr_id());
		List<ReportTemplateListVO> rlist = command2.searchReportTemplateBstVipList(event.getInfoVO());
		eventResponse.setRsVoList(rlist);
		
		
		return eventResponse;
		
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * 0103 Booking Status Report를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBLStatusList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0103Event event = (EsmBkg0103Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		
		
		//******************************************************************************************************************************************************************
		//Out of Memory Error 발생 : Validation Check
		//2015.01.15 js Validation 로직 추가
		//******************************************************************************************************************************************************************
		StatusReportInVO statusReportInVO = event.getInfoVO();
		BookingUtil utilCmd = new BookingUtil();
		String strValidation = ""; // Y:true면 종료
		String strMessage = ""; //Message 있으면 종료
        String strVvdCd = "";
		
        strVvdCd = statusReportInVO.getVvdCd().replaceAll("\t", ""); //tab 처리
		if ( !CheckUtils.isNullAndNullString(strVvdCd)) {
			strValidation = "Y";
			strMessage = "OK";
		
		} else if ("".equals(strMessage) &&
				   CheckUtils.isNullAndNullString(strVvdCd) &&
				   (CheckUtils.isNullAndNullString(statusReportInVO.getBoardFromDt()) || CheckUtils.isNullAndNullString(statusReportInVO.getBoardToDt())) && 
				   (CheckUtils.isNullAndNullString(statusReportInVO.getBkgFromDt())   || CheckUtils.isNullAndNullString(statusReportInVO.getBkgToDt()))   && 
				   (CheckUtils.isNullAndNullString(statusReportInVO.getEtaFromDt())   || CheckUtils.isNullAndNullString(statusReportInVO.getEtaToDt())))  {
			strMessage = "VVD or On Board Date or Booking Date(1)";
		
		//날짜조건이 들어온 경우에는 pol,pod 중 하나가 필수 Trunk체크 추가(2010.4.13)	
		} else if ( "".equals(strMessage) && 
			   ((!CheckUtils.isNullAndNullString(statusReportInVO.getBoardFromDt()) && !CheckUtils.isNullAndNullString(statusReportInVO.getBoardToDt())) || 
			    (!CheckUtils.isNullAndNullString(statusReportInVO.getBkgFromDt())   && !CheckUtils.isNullAndNullString(statusReportInVO.getBkgToDt())) || 
			    (!CheckUtils.isNullAndNullString(statusReportInVO.getEtaFromDt())   && !CheckUtils.isNullAndNullString(statusReportInVO.getEtaToDt())))
			    && CheckUtils.isNullAndNullString(statusReportInVO.getPolCd()) && CheckUtils.isNullAndNullString(statusReportInVO.getPodCd()) && (CheckUtils.isNullAndNullString(statusReportInVO.getTrunkFlag()))) {
			strMessage = "specify additional mandatory item: with POL (or POD) at least 2 letter country or \n define Trunk vessel only with tick on Trunk-V.\n Otherwise,all data is regarded as Trunk VVD base booking(2)";
			
		// special 이 하나라도 check 되어 있으면 validation skip (2010.03.08)
		} else if ( "".equals(strMessage) &&  
 				!CheckUtils.isNullAndNullString(statusReportInVO.getSpCargoDg()) ||
				!(CheckUtils.isNullAndNullString(statusReportInVO.getSpCargoRf())) ||
				!(CheckUtils.isNullAndNullString(statusReportInVO.getSpCargoAk())) ||
				!(CheckUtils.isNullAndNullString(statusReportInVO.getSpCargoBb())) ||
				!(CheckUtils.isNullAndNullString(statusReportInVO.getSpCargoHg())) ||
				!(CheckUtils.isNullAndNullString(statusReportInVO.getSpCargoSoc())) ||
				!(CheckUtils.isNullAndNullString(statusReportInVO.getSpCargoEq())) ||
				!(CheckUtils.isNullAndNullString(statusReportInVO.getSpCargoRd())) ||
				!(CheckUtils.isNullAndNullString(statusReportInVO.getSpCargoPc())) ||
				!(CheckUtils.isNullAndNullString(statusReportInVO.getSpCargoFg())) ||
				!(CheckUtils.isNullAndNullString(statusReportInVO.getSpCargoHd())) ||
				!(CheckUtils.isNullAndNullString(statusReportInVO.getSpCargoFu())) ||
				!(CheckUtils.isNullAndNullString(statusReportInVO.getSpCargoLi())) ||			 
				!(CheckUtils.isNullAndNullString(statusReportInVO.getSpCargoRb()))) {
			strValidation = "Y";
			strMessage = "OK";
		
		} else if ("".equals(strMessage) &&
				   CheckUtils.isNullAndNullString(statusReportInVO.getPolCd()) && CheckUtils.isNullAndNullString(statusReportInVO.getPodCd()) &&  CheckUtils.isNullAndNullString(statusReportInVO.getPorCd()) &&  CheckUtils.isNullAndNullString(statusReportInVO.getDelCd()) &&
				   CheckUtils.isNullAndNullString(statusReportInVO.getBOfcCd()) && CheckUtils.isNullAndNullString(statusReportInVO.getLOfcCd()) && CheckUtils.isNullAndNullString(statusReportInVO.getCOfcCd()) &&
			       CheckUtils.isNullAndNullString(statusReportInVO.getCRepId()) && CheckUtils.isNullAndNullString(statusReportInVO.getLRepId()) && CheckUtils.isNullAndNullString(statusReportInVO.getBStaffId()) &&
				   CheckUtils.isNullAndNullString(statusReportInVO.getCtrRfaNo()) && CheckUtils.isNullAndNullString(statusReportInVO.getRctRhqCd())) {
			strMessage = "POL or POD or POR or DEL or BKG Staff or BKG Office or L/Office or C/Office or L/Rep or C/Rep or S/C or RFA or RHQ(3)";
		}
				
		//VVD 없을 경우        
		if ( "".equals(strMessage) && CheckUtils.isNullAndNullString(strVvdCd)) {
			
			//날짜기간
			int dayBoard = 0;
			int dayBkg = 0;
			int dayEta = 0;
	        try {
	        	if (!CheckUtils.isNullAndNullString(statusReportInVO.getBoardFromDt()) && !CheckUtils.isNullAndNullString(statusReportInVO.getBoardToDt()) )
	        		dayBoard = DateTime.daysBetween(statusReportInVO.getBoardFromDt().replace("-",""),statusReportInVO.getBoardToDt().replace("-",""));
	        	if (!CheckUtils.isNullAndNullString(statusReportInVO.getBkgFromDt()) && !CheckUtils.isNullAndNullString(statusReportInVO.getBkgToDt()) )
	        		dayBkg = DateTime.daysBetween(statusReportInVO.getBkgFromDt().replace("-",""),statusReportInVO.getBkgToDt().replace("-",""));
	        	if (!CheckUtils.isNullAndNullString(statusReportInVO.getEtaFromDt()) && !CheckUtils.isNullAndNullString(statusReportInVO.getEtaToDt()) )
	    			dayEta = DateTime.daysBetween(statusReportInVO.getEtaFromDt().replace("-",""),statusReportInVO.getEtaToDt().replace("-",""));
	        } catch (Exception ex) {
				throw new EventException(ex.getMessage(),ex);
			}	
	        
			//RHQ 7일조회 [김보영과장요청]
			//1st VVD ETD			
			if ( "".equals(strMessage) && !CheckUtils.isNullAndNullString(statusReportInVO.getRctRhqCd()) &&  dayBoard+1 > 7) {
				strMessage = "On Board Date exceeds maximum duration 7Days(4)";
			}
			//Booking Date			
			if ( "".equals(strMessage) && !CheckUtils.isNullAndNullString(statusReportInVO.getRctRhqCd()) &&  dayBkg+1 > 7) {
				strMessage = "On Booking Date exceeds maximum duration 7Days(5)";
			}
			//Last VVD ETA			
			if ( "".equals(strMessage) && !CheckUtils.isNullAndNullString(statusReportInVO.getRctRhqCd()) &&  dayEta+1 > 7) {
				strMessage = "ETA Date exceeds maximum duration 7Days(6)";
			}
			
			/*   POL 이나 BKG OFC 가 US/CA Country 에 속하는 경우 1달 조회가능 (2014.06.18 조인영)
			 *   중국지역은 21일 제한 로직은 그대로, Contract 입력후 조회시만 30일 가능 (2014.07.10 신선희 김미선부장님요청)
			 */			
		    //중국지역 , OFFCIE 적용 제외
			if ( "".equals(strMessage) && !CheckUtils.isNullAndNullString(statusReportInVO.getPolCd()) && "CN".equals(statusReportInVO.getPolCd().substring(0,2))) {
 
					//1st VVD ETD				
					if ( "".equals(strMessage) && CheckUtils.isNullAndNullString(statusReportInVO.getCtrRfaNo())  &&  dayBoard+1 > 21 ) {
						strMessage = "On Board Date exceeds maximum duration 21Days(7)";
					} else if ( !CheckUtils.isNullAndNullString(statusReportInVO.getCtrRfaNo())  &&  dayBoard+1 > 31 ) {
						strMessage = "On Board Date exceeds maximum duration 31Days(8)";				
					}
					//Booking Date				
					if ( "".equals(strMessage) && CheckUtils.isNullAndNullString(statusReportInVO.getCtrRfaNo())  &&  dayBkg+1 > 21 ) {
						strMessage = "On Booking Date exceeds maximum duration 21Days(9)";
					} else if ( !CheckUtils.isNullAndNullString(statusReportInVO.getCtrRfaNo())  &&  dayBkg+1 > 31 ) {
						strMessage = "On Booking Date exceeds maximum duration 31Days(10)";
					}
					//Last VVD ETA				
					if ( "".equals(strMessage) && CheckUtils.isNullAndNullString(statusReportInVO.getCtrRfaNo())  &&  dayEta+1 > 21 ) {
						strMessage = "ETA Date exceeds maximum duration 21Days(11)";
					} else if ( !CheckUtils.isNullAndNullString(statusReportInVO.getCtrRfaNo())  &&  dayEta+1 > 31 ) {
						strMessage = "ETA Date exceeds maximum duration 31Days(12)";
					}				
				
			//중국외 기타지역				
			} else {
				
				//1st VVD ETD				
				if ( "".equals(strMessage) && dayBoard+1 > 31 ) {
					strMessage = "On Board Date exceeds maximum duration 31Days(13)";
				}
				//Booking Date				
				if ( "".equals(strMessage) && dayBkg+1 > 31 ) {
					strMessage = "On Booking Date exceeds maximum duration 31Days(14)";
				}
				//Last VVD ETA				
				if (  "".equals(strMessage) && dayEta+1 > 31 ) {
					strMessage = "ETA Date exceeds maximum duration 31Days(15)";
				}				
				
			}//중국,중국외 기타지역 End
			
		}//VVD 없을 경우
			
		//Validation False
		if ( !"Y".equals(strValidation) && !"".equals(strMessage)) {
			utilCmd.addBkgLog("BKG_BST_ERR","USER ID: "+account.getUsr_id() +" / USER NM:"+account.getUsr_nm() + " / OFC CD:"+account.getOfc_cd(), strMessage);
			throw new EventException(new ErrorHandler("BKG00627",new String[]{strMessage}).getMessage());
		}
		//******************************************************************************************************************************************************************
		
		StatusReportInVO inVO = event.getInfoVO();
		inVO.setUsrOfcCd(account.getOfc_cd());
		List<StatusReportOutVO> list = command.searchBLStatusList(inVO);
		if(list.size() > 0){
			list.get(0).setMaxRows(Integer.parseInt(list.get(0).getTotalCnt()));
		}
		
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 0103 Booking Status Report 정보를 위한 BKG OFC SUB정보를조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBLStatusList2(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0103Event event = (EsmBkg0103Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		String sub_ofc_cds = command.searchBLStatusList2(event.getInfoVO());
		
		/* 사용하지 않는 Local Variable 주석 처리 */
//		BookingUtil command2 = new BookingUtil();
//		
//        List<BkgComboVO> list1 = command2.searchCombo("CD00912");
        //eventResponse.setRsVoList(list1);
        eventResponse.setETCData("sub_ofc_cds",sub_ofc_cds);

		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 0103 Booking Status Special Cargo Report를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBLStatusListSpecialCargo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0103Event event = (EsmBkg0103Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		List<StatusReportSpecialCargoOutVO> list = command.searchBLStatusListSpecialCargo(event.getInfoVO());
		if(list.size() > 0){
			list.get(0).setMaxRows(Integer.parseInt(list.get(0).getTotalCnt()));
		}
		
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	/**
	 * 조회 이벤트 처리<br>
	 * 0103 Booking Status Summary Report를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBLStatusListSummary(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0103Event event = (EsmBkg0103Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		List<StatusReportSummaryOutVO> list = command.searchBLStatusListSummary(event.getInfoVO());
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	
	
	 /**
     * ESM_BKG_0814 : Outbound Container Movement Status by Yard 인쇄 화면.<br>
     * 호출 화면: ESM_BKG_0619 
     * 
     * @category ESM_BKG_0814
     * @category report0814
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse report0775(Event e) throws EventException {

		// BC 객체 생성|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|100|&&|0|&&|0|&&| MYPKGTM|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|12|&&|1|&&|0|&&|0|&&| SGSINKA|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|1|&&|0|&&|0|&&|0|&&| VNSGNY6|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|18|&&|0|&&|0|&&| USLGBPT|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|1|&&|0|&&|0|&&| IDJKTY7|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|2|&&|25|&&|0|&&|0|&&| KRPUSYG|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|60|&&|12|&&|0|&&|72|&&|65|&&|103|&&|0|&&|64|&&| USOAKM1|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|27|&&|0|&&|27|&&|0|&&|0|&&|0|&&|0|&&| AUSYDCT|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|3|&&|1|&&|0|&&|0|&&| THBKKY6|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|1|&&|0|&&|0|&&| JPTOYY1|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|0|&&|6|&&|0|&&|0|&&| //EOR// 
		StatusReportBC command = new StatusReportBCImpl();
		
		// 반환 객체 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmBkg0775Event event = (EsmBkg0775Event)e;
		
		if(event.getInfoVO() != null ) event.getInfoVO().setRdYn("Y");
		String rp_type = event.getInfoVO().getPReportType();
		List<StatusReportOutVO> list = null;
		List<StatusReportSpecialCargoOutVO> listSC = null; //Special Cargo
		
		if(rp_type.equals("ak") || rp_type.equals("bb") || rp_type.equals("dg") || rp_type.equals("rf") || rp_type.equals("cntr")  )
			listSC = command.searchBLStatusListSpecialCargo((event.getInfoVO()));
		else 
			list =command.searchBLStatusList((event.getInfoVO()));
			
	    
		StringWriter sw = new StringWriter();
	    PrintWriter pw = new PrintWriter(sw);
	    
	    Map<String, String> colValues = null;
		//메인 페이지 
	    String orderByTemp ="";
	    String orderByTitle ="";
	    if(rp_type.equals("ak") || rp_type.equals("bb") || rp_type.equals("dg") || rp_type.equals("rf") || rp_type.equals("cntr")  ){
	    	for (int i = 0; i < listSC.size() ; i++) {
				colValues = listSC.get(i).getColumnValues();	
				orderByTemp =colValues.get("orderby_title");
				pw.print(colValues.get("orderby_title")    +SP);		//1
				
				pw.print(colValues.get("bst_flg")    +SP);			
				pw.print(colValues.get("bdr_flg")    +SP);

				pw.print(colValues.get("bkg_no")    +SP);
				pw.print(colValues.get("bl_no")    +SP);

				pw.print(colValues.get("cntr_no")    +SP);
				if(rp_type.equals("bb") ){
					pw.print(""  +SP);
				}else{
					if(colValues.get("cntr_tpsz_cd").equals("") && colValues.get("cntr_vol_qty").equals("")){
						pw.print(""  +SP);
					}else{
						pw.print(colValues.get("cntr_tpsz_cd") + " - " + colValues.get("cntr_vol_qty")   +SP);
					}
				}

				pw.print(colValues.get("cgo_seq")    +SP);

				if(rp_type.equals("ak") ){
					pw.print(colValues.get("grs_wgt")    +SP);

					pw.print(colValues.get("pkg")    +SP);
					if(colValues.get("rcv_term_cd").equals("") && colValues.get("de_term_cd").equals("")){
						pw.print(""  +SP);
					}else{
						pw.print(colValues.get("rcv_term_cd") +" / "+ colValues.get("de_term_cd")    +SP);
					}

					pw.print(colValues.get("ovr_fwrd_len")    +SP);
					pw.print(colValues.get("ovr_bkwd_len")    +SP);
					pw.print(colValues.get("ovr_hgt")    +SP);

					pw.print(colValues.get("ovr_lf_len")    +SP);
					pw.print(colValues.get("ovr_rt_len")    +SP);

					pw.print(colValues.get("ovr_void_slt_qty")    +SP);

					pw.print(colValues.get("hot_de_flg")    +SP);
					pw.print(colValues.get("dcgo_flg")    +SP);

					pw.print(colValues.get("rd_cgo_flg")    +SP);
					pw.print(colValues.get("bb_cgo_flg")    +SP);

					pw.print(colValues.get("bkg_ofc_cd")    +SP);
					pw.print(colValues.get("ob_sls_ofc_cd")    +SP);

					pw.print(colValues.get("bkg_stf")    +SP);
					pw.print(colValues.get("ob_srep_cd")    +SP);

					pw.print(colValues.get("spcl_cgo_auth_knt")    +SP);
					pw.print(colValues.get("spcl_cgo_apro_cd")    +SP);

					if(!colValues.get("akrep_cmdt").equals("")){
						pw.print("Commdity: "+colValues.get("akrep_cmdt")    +SP);	
					}else{
						pw.print(""    +SP);	
					}
					pw.print(colValues.get("meas_qty")    +SP);

				}else if(rp_type.equals("bb")){
					pw.print(colValues.get("grs_wgt")    +SP);
					
					pw.print(colValues.get("pkg")    +SP);
					if(colValues.get("rcv_term_cd").equals("") && colValues.get("de_term_cd").equals("")){
						pw.print(""  +SP);
					}else{
						pw.print(colValues.get("rcv_term_cd") +" / "+ colValues.get("de_term_cd")    +SP);
					}
					
					pw.print(colValues.get("dim_len")    +SP);
					pw.print(colValues.get("dim_wdt")    +SP);
					pw.print(colValues.get("dim_hgt")    +SP);
					
					pw.print(colValues.get("ovr_void_slt_qty")    +SP);
					
					pw.print(colValues.get("hot_de_flg")    +SP);
					pw.print(colValues.get("dcgo_flg")    +SP);
					pw.print(colValues.get("rd_cgo_flg")    +SP);
					pw.print(colValues.get("awk_cgo_flg")    +SP);
					
					pw.print(colValues.get("bkg_ofc_cd")    +SP);
					pw.print(colValues.get("ob_sls_ofc_cd")    +SP);
					
					pw.print(colValues.get("bkg_stf")    +SP);
					pw.print(colValues.get("ob_srep_cd")    +SP);
					pw.print(colValues.get("spcl_cgo_auth_knt")    +SP);
					pw.print(colValues.get("spcl_cgo_apro_cd")    +SP);
					if(!colValues.get("bb_cmdt").equals("")){
						pw.print("Commdity: "+colValues.get("bb_cmdt")    +SP);	
					}else{
						pw.print(""    +SP);	
					}
					pw.print(colValues.get("meas_qty")    +SP);
					
				}else if(rp_type.equals("dg")){
					pw.print(colValues.get("imdg_un_no")    +SP);
					pw.print(colValues.get("imdg_clss_cd")    +SP);
					
					pw.print(colValues.get("flsh_pnt_cdo_temp")    +SP);
					pw.print(colValues.get("imdg_pck_grp_cd")    +SP);
					
					pw.print(colValues.get("net_wgt")    +SP);
					pw.print(colValues.get("grs_wgt")    +SP);
					
					pw.print(colValues.get("meas_qty")    +SP);
					
					pw.print(colValues.get("pkg")    +SP);
					if(colValues.get("rcv_term_cd").equals("") && colValues.get("de_term_cd").equals("")){
						pw.print(""  +SP);
					}else{
						pw.print(colValues.get("rcv_term_cd") +" / "+ colValues.get("de_term_cd")    +SP);
					}
					
					pw.print(colValues.get("hot_de_flg")    +SP);
					pw.print(colValues.get("awk_cgo_flg")    +SP);
					pw.print(colValues.get("rd_cgo_flg")    +SP);
					pw.print(colValues.get("bb_cgo_flg")    +SP);
					
					pw.print(colValues.get("bkg_ofc_cd")    +SP);
					pw.print(colValues.get("ob_sls_ofc_cd")    +SP);
					
					pw.print(colValues.get("bkg_stf")    +SP);
					pw.print(colValues.get("ob_srep_cd")    +SP);
					pw.print(colValues.get("spcl_cgo_auth_knt")    +SP);
					pw.print(colValues.get("spcl_cgo_apro_cd")    +SP);
					
					if(!colValues.get("emer_cntc_phn_no_ctnt").equals("")){
						pw.print("Contact: " + colValues.get("emer_cntc_phn_no_ctnt")    +SP);
					}else{
						pw.print(""    +SP);	
					}
					
					if(!colValues.get("prp_shp_nm").equals("")){
						pw.print("Substance: " + colValues.get("prp_shp_nm")    +SP);
					}else{
						pw.print(""    +SP);	
					}

				}else if(rp_type.equals("rf")){
					pw.print(colValues.get("grs_wgt")    +SP);
					
					pw.print(colValues.get("pkg")    +SP);
					if(colValues.get("rcv_term_cd").equals("") && colValues.get("de_term_cd").equals("")){
						pw.print(""  +SP);
					}else{
						pw.print(colValues.get("rcv_term_cd") +" / "+ colValues.get("de_term_cd")    +SP);
					}
					
					pw.print(colValues.get("cdo_temp")    +SP);
					pw.print(colValues.get("fdo_temp")    +SP);
					
					pw.print(colValues.get("humid_no")    +SP);
					pw.print(colValues.get("vltg_no")    +SP);
					
					pw.print(colValues.get("cntr_vent_tp_cd")    +SP);
					pw.print(colValues.get("pwr_spl_cbl_flg")    +SP);
					
					pw.print(colValues.get("ctrl_atms_flg")    +SP);
					pw.print(colValues.get("modi_atms_flg")    +SP);
					pw.print(colValues.get("humid_ctrl_flg")    +SP);
					pw.print(colValues.get("atfc_atms_flg")    +SP);
					
					pw.print(colValues.get("hot_de_flg")    +SP);
					pw.print(colValues.get("awk_cgo_flg")    +SP);
					pw.print(colValues.get("dcgo_flg")    +SP);
					pw.print(colValues.get("bb_cgo_flg")    +SP);
					
					pw.print(colValues.get("bkg_ofc_cd")    +SP);
					pw.print(colValues.get("ob_sls_ofc_cd")    +SP);
					pw.print(colValues.get("bkg_stf")    +SP);
					pw.print(colValues.get("ob_srep_cd")    +SP);
					pw.print(colValues.get("spcl_cgo_auth_knt")    +SP);
					pw.print(colValues.get("spcl_cgo_apro_cd")    +SP);
					
					pw.print(colValues.get("rf_cmdt")    +SP);
					pw.print(colValues.get("meas_qty")    +SP);
					
				}else if(rp_type.equals("cntr")){
					pw.print(colValues.get("grs_wgt")    +SP);
					
					pw.print(colValues.get("pkg")    +SP);
					if(colValues.get("rcv_term_cd").equals("") && colValues.get("de_term_cd").equals("")){
						pw.print(""  +SP);
					}else{
						pw.print(colValues.get("rcv_term_cd") +" / "+ colValues.get("de_term_cd")    +SP);
					}
					
					pw.print(colValues.get("cdo_temp")    +SP);
					pw.print(colValues.get("fdo_temp")    +SP);
					
					pw.print(colValues.get("humid_no")    +SP);
					pw.print(colValues.get("vltg_no")    +SP);
					
					pw.print(colValues.get("cntr_vent_tp_cd")    +SP);
					pw.print(colValues.get("pwr_spl_cbl_flg")    +SP);
					
					pw.print(colValues.get("ctrl_atms_flg")    +SP);
					pw.print(colValues.get("modi_atms_flg")    +SP);
					pw.print(colValues.get("humid_ctrl_flg")    +SP);
					pw.print(colValues.get("atfc_atms_flg")    +SP);
					
					pw.print(colValues.get("hot_de_flg")    +SP);
					pw.print(colValues.get("awk_cgo_flg")    +SP);
					pw.print(colValues.get("dcgo_flg")    +SP);
					pw.print(colValues.get("bb_cgo_flg")    +SP);
					
					pw.print(colValues.get("bkg_ofc_cd")    +SP);
					pw.print(colValues.get("ob_sls_ofc_cd")    +SP);
					pw.print(colValues.get("bkg_stf")    +SP);
					pw.print(colValues.get("ob_srep_cd")    +SP);
					pw.print(colValues.get("spcl_cgo_auth_knt")    +SP);
					pw.print(colValues.get("spcl_cgo_apro_cd")    +SP);
					
					pw.print(colValues.get("rf_cmdt")    +SP);
					pw.print(colValues.get("meas_qty")    +SP);				
				}
												
				
				if(!colValues.get("remark_detail").equals("")){
					pw.print("Remarks: " +JSPUtil.replace(colValues.get("remark_detail"),"\r\n"," ") +SP);	 //remarks
				}else{
					pw.print(""    +SP);	
				}
				
				pw.print(""    +SP); //stowage	reefer는 해당사항 없음
				
				
				
				if(orderByTitle.equals(orderByTemp)){
					pw.print("0"    +SP);
					pw.print("0"    +SP);
				}else{
					//System.out.println("colValues.get(row_seq):"+colValues.get("no")+" " +colValues.get("bkg_no")+" "+colValues.get("bkg_cnt") );
					pw.print(colValues.get("bkg_cnt")    +SP);
					pw.print(colValues.get("bl_cnt")    +SP);
				}
				pw.print(colValues.get("d2")    +SP);
				pw.print(colValues.get("q4")    +SP);
				pw.print(colValues.get("d4")    +SP);
				pw.print(colValues.get("r2")    +SP);
				pw.print(colValues.get("d5")    +SP);
				pw.print(colValues.get("r4")    +SP);
				pw.print(colValues.get("d7")    +SP);
				pw.print(colValues.get("r5")    +SP);
				pw.print(colValues.get("f2")    +SP);
				pw.print(colValues.get("t2")    +SP);
				pw.print(colValues.get("f4")    +SP);
				pw.print(colValues.get("t4")    +SP);
				pw.print(colValues.get("f5")    +SP);
				pw.print(colValues.get("p2")    +SP);
				pw.print(colValues.get("o2")    +SP);
				pw.print(colValues.get("p4")    +SP);
				pw.print(colValues.get("o4")    +SP);
				pw.print(colValues.get("z4")    +SP);
				pw.print(colValues.get("o5")    +SP);
				pw.print(colValues.get("z2")    +SP);
				pw.print(colValues.get("q2")    +SP);			
				pw.print(colValues.get("d9")    +SP);
				pw.print(colValues.get("d3")    +SP);				
				pw.print(colValues.get("r9")    +SP);
				pw.print(colValues.get("dx")    +SP);
				
				pw.print(colValues.get("teu")    +SP);
				pw.print(colValues.get("feu")    +SP);		
				
				pw.print(colValues.get("o7")    +SP);
																								     	                     
				pw.print("\r\n");	    
				if(!orderByTitle.equals(orderByTemp)){
					orderByTitle = orderByTemp; 
				}
	    	}
	    }else{
	    	
				for (int i = 0; i < list.size() ; i++) {
					colValues = list.get(i).getColumnValues();		
					pw.print(colValues.get("orderby_title") +SP);  //ORDER BY TITLE
					
					pw.print(colValues.get("bkg_sts_cd")    +SP);  //BST               
					pw.print(colValues.get("bdr_flg")       +SP);  //bdr
					
					pw.print(colValues.get("si_flg")        +SP);	 //SR                
																									     	                     
					pw.print(colValues.get("bkg_no")        +SP);	 //Booking No        
					pw.print(colValues.get("bl_no")         +SP);	 //B/L No            
																									     	                     
					pw.print(colValues.get("shpr_name")     +SP);	 //Shipper           
					pw.print(colValues.get("cnee_name")     +SP);	 //Consignee         
																									     	                     
					pw.print(colValues.get("por_cd")        +SP);	 //POR               
					pw.print(colValues.get("del_cd")        +SP);	 //DEL               
																									     	                     
					pw.print(colValues.get("teu")           +SP);	 //TEU - booking Q'ty
					pw.print(colValues.get("feu")           +SP);	 //FEU - booking Q'ty
																									     	                     
					pw.print(colValues.get("rep")           +SP);	 //Rep. CMDT               
					
					pw.print(colValues.get("bkg_mea_qty")   +SP);	 //MEA(CBM)               
					pw.print(colValues.get("bkg_actwgt_qty")+SP);	 //WGT(KGS)          
																									     	                     
					pw.print(colValues.get("pck_qty")       +SP);	 //pkg_qty             
					pw.print(colValues.get("pck_tp_cd")     +SP);	 //pkg_qty_type_cd           
					pw.print(colValues.get("rcv_term_cd")   +SP);	 //R                 
					pw.print(colValues.get("de_term_cd")    +SP);	 //D                 
																									     	                     
					pw.print(colValues.get("dcgo_flg")      +SP);	 //DG                
					pw.print(colValues.get("awk_cgo_flg")   +SP);	 //AK                
																									     	                     
					pw.print(colValues.get("rc_flg")        +SP);	 //RF                
					pw.print(colValues.get("bb_cgo_flg")    +SP);	 //BB                
																									     	                     
					pw.print(colValues.get("fd_grd_flg")    +SP);	 //FG                
					pw.print(colValues.get("pc")            +SP);	 //PC                
																									     	                     
					pw.print(colValues.get("itn_flg")       +SP);	 //ITN               
					pw.print(colValues.get("itn_type")      +SP);	 //ITN Type
					
					pw.print(colValues.get("caed_flg")       +SP);	 //CAED               
					pw.print(colValues.get("caed_type")      +SP);	 //CAED Type
					
					pw.print(colValues.get("bkg_ofc_cd")    +SP);	 //B.OFC             
					pw.print(colValues.get("ob_sls_ofc_cd") +SP);	 //L.OFC             
																									     	                     
					pw.print(colValues.get("doc_usr_id")    +SP);	 //BKG STF
					pw.print(colValues.get("ob_srep_cd")    +SP);	 //L.SREP
					
					pw.print(colValues.get("cntr_no")       +SP);	 //cntr_no
					pw.print(colValues.get("cntr_tpsz_cd")  +SP);	 //cntr_tpsz_cd
					
					pw.print(JSPUtil.replace(colValues.get("remark_detail"),"\r\n"," ") +SP);	 //remarks
					
					pw.print(colValues.get("contact") +SP);	 //Contact
					pw.print(colValues.get("tel") +SP);	 //Tel
					
					pw.print(colValues.get("rd_total_d2") +SP);	 //rd_total_d2
					pw.print(colValues.get("rd_total_q4") +SP);	 //rd_total_q4
		
					pw.print(colValues.get("rd_total_d4") +SP);	 //rd_total_d4
					pw.print(colValues.get("rd_total_r2") +SP);	 //rd_total_r2
		
					pw.print(colValues.get("rd_total_d5") +SP);	 //rd_total_d5
					pw.print(colValues.get("rd_total_r4") +SP);	 //rd_total_r4
		
					pw.print(colValues.get("rd_total_d7") +SP);	 //rd_total_d7
					pw.print(colValues.get("rd_total_r5") +SP);	 //rd_total_r5
		
					pw.print(colValues.get("rd_total_f2") +SP);	 //rd_total_f2
					pw.print(colValues.get("rd_total_t2") +SP);	 //rd_total_t2
		
					pw.print(colValues.get("rd_total_f4") +SP);	 //rd_total_f4
					pw.print(colValues.get("rd_total_t4") +SP);	 //rd_total_t4
		
					pw.print(colValues.get("rd_total_f5") +SP);	 //rd_total_f5
					pw.print(colValues.get("rd_total_p2") +SP);	 //rd_total_p2
		
					pw.print(colValues.get("rd_total_o2") +SP);	 //rd_total_o2
					pw.print(colValues.get("rd_total_p4") +SP);	 //rd_total_p4
		
					pw.print(colValues.get("rd_total_o4") +SP);	 //rd_total_o4
					pw.print(colValues.get("rd_total_z4") +SP);	 //rd_total_z4
					
					
					pw.print(colValues.get("rd_total_o5") +SP);	 //rd_total_o5
					pw.print(colValues.get("rd_total_z2") +SP);	 //rd_total_z2			
					
					pw.print(colValues.get("rd_total_q2") +SP);	 //rd_total_q2
					pw.print(colValues.get("rd_total_d9") +SP);	 //rd_total_d9		
					
					pw.print(colValues.get("rd_total_d3") +SP);	 //rd_total_d3
					pw.print(colValues.get("rd_total_r9") +SP);	 //rd_total_r9	
					
					pw.print(colValues.get("rd_total_dx") +SP);	 //rd_total_dx
					pw.print(colValues.get("rd_total_o7") +SP);	 //rd_total_o7
                     
					pw.print("\r\n");
						
				}
	    }
		pw.println(EOR);
		
//		log.debug("#####################################"+sw.toString());
		eventResponse.setCustomData("RD", sw.toString());
		
		return eventResponse;
	}			
		
	/**
	 * 조회 이벤트 처리<br>
	 * 0625 Report template(Default, Detail, User Set) 을 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustVipReport(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0625Event event = (EsmBkg0625Event)e;
		StatusReportBC command = new StatusReportBCImpl();

		try{
			List<CustVipReportOutVO> list = command.searchCustVipReport(event.getInfoVO());
			if(list.size() > 0){
				list.get(0).setMaxRows(Integer.parseInt(list.get(0).getTotalCnt()));
			}
			
			eventResponse.setRsVoList(list);
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}		

		return eventResponse;
		
	}
	/**
	 * 조회 이벤트 처리<br>
	 * 0647 B/L Status Report 을 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBLStsReportList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0647Event event = (EsmBkg0647Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		
		try{
			List<BlStsReportOutVO> list = command.searchBLStsReportList(event.getInfoVO());
			if(list.size() > 0){
				list.get(0).setMaxRows(Integer.parseInt(list.get(0).getTotalCnt()));
			}
			
			eventResponse.setRsVoList(list);
			
		}catch(EventException ex){
			log.error("err" + ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err" + ex.toString(),ex);
			throw new EventException(ex.getMessage(), ex);
		}		
		
		return eventResponse;
		
	}
	
	/**
	 * ESM_BKG_0647 : Search <br>
	 * Customer Type을 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo0647(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		BookingUtil command = new BookingUtil();
		SpecialReportBC command2 = new SpecialReportBCImpl();
		EsmBkg0647Event event = (EsmBkg0647Event)e;
		
		try{
			/* Customer Type CD */
			List<BkgComboVO> list = command.searchCombo("CD00880");
			eventResponse.setRsVoList(list);
			
			List<BkgComboVO> list1 = command.searchCombo("CD03320");
	        BkgComboVO combovo = new BkgComboVO();
	        combovo.setVal("");
			combovo.setDesc("");
			combovo.setName("");
			list1.add(0,combovo);
			eventResponse.setRsVoList(list1);
			
			List<BkgComboVO> list2 = command.searchCombo("CD03471");
			eventResponse.setRsVoList(list2);

			event.getInfo2VO().setUpdUsrId(account.getUsr_id());
			List<ReportTemplateListVO> rlist = command2.searchReportTemplateBstVipList(event.getInfo2VO());
			eventResponse.setRsVoList(rlist);
		}catch(EventException ex){
			log.error("err" + ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err" + ex.toString(),ex);
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}	
	
    /**
	 * ESM_BKG_0227 : Search <br>
	 * e-Booking & S/I 실적 조회 기능<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEBkgSiPfmcList(Event e) throws EventException {
	
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0227Event event = (EsmBkg0227Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<EBkgSiPfmcInVO> list = null;
		String reportType =JSPUtil.getNull(event.getEBkgSiPfmcInVO().getReportType());
		
		/*서버 ID*/
		event.getEBkgSiPfmcInVO().setSvrId(account.getCnt_cd());
		/*1.BookingOffice Report*/
		if (reportType.equals("BR")){
			list = command.searchEBkgSiPfmcListByBkgOfc(event.getEBkgSiPfmcInVO());
		/*2.SalesOffice Report*/
		}else if (reportType.equals("SR")){
			list = command.searchEBkgSiPfmcListBySalOfc(event.getEBkgSiPfmcInVO());
		/*3.Shipper Report	*/
		}else if (reportType.equals("CR")){		
			list = command.searchEBkgSiPfmcListByShipper(event.getEBkgSiPfmcInVO());
		/*4.Detail Report		*/
		}else if (reportType.equals("DR")){		
			list = command.searchEBkgSiPfmcListByDetail(event.getEBkgSiPfmcInVO());
		/*5.Summary by ID - Detail Report		*/
		}else if (reportType.equals("DS")){		
			list = command.searchEBkgSiPfmcListByDetail(event.getEBkgSiPfmcInVO());
		}
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	
	}	
    
    /**
     * ESM_BKG_0227 : Combo Search <br>
     * 0227화면에 대한 콤보리스트 조회.<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchComCode0227(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
    	//Report Type
        List<BkgComboVO> list = command.searchCombo("CD02179");
        eventResponse.setRsVoList(list);
        
        //Region
        List<BkgComboVO> list2 = command.searchRgnOfficeCd();
        eventResponse.setRsVoList(list2);
        
        //Customer Type
        List<BkgComboVO> list3 = command.searchCombo("CD00880");
        eventResponse.setRsVoList(list3);
        
       
        return eventResponse;
    }
    
    /**
	 * ESM_BKG_0588 : 조회 이벤트 처리<br>
	 * Special cargo summary information<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpecialCargoSummaryReport(Event e) throws EventException {
	
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0588Event event = (EsmBkg0588Event)e;
		SpecialReportBC command = new SpecialReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<SpecialCargoSummaryReportVO> list = null;
		
		list = command.searchSpecialCargoSummaryReport(event.getSpecialCargoSummaryReportVO());
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	
	}	
    
    /**
     * ESM_BKG_0588 : 화면에 대한 콤보리스트 조회.<br>
     * Special cargo summary information<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchComCode0588(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
        //Zone
        List<BkgComboVO> list2 = command.searchCombo("CD00206");
        BkgComboVO combovo = new BkgComboVO();
        combovo.setVal(" ");
		combovo.setDesc("All");
		combovo.setName("All");
		list2.add(0,combovo);
        eventResponse.setRsVoList(list2);
        
        //BKG Status
        List<BkgComboVO> list = command.searchCombo("CD00769");
        list.add(0,combovo);
        eventResponse.setRsVoList(list);
        
        return eventResponse;
    }
    
    /**
	 * ESM_BKG_0727 : 조회 이벤트 처리<br>
	 * BDR Booking No Status - Inquiry<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBDRBookingNoList(Event e) throws EventException {
	
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0727Event event = (EsmBkg0727Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<BdrBookingNoListVO> list = null;
		
		list = command.searchBDRBookingNoList(event.getBdrBookingNoListVO());
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	
	}
	/**
	 * ESM_BKG_0914 : 조회 이벤트 처리<br>
	 * Port Closing Inquiry<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortCloseReport(Event e) throws EventException {
	
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0914Event event = (EsmBkg0914Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<PortCloseOfficeListVO> list = null;
		if (e.getFormCommand().isCommand(FormCommand.SEARCH)){ 
			
			list = command.searchPctlOfficeList(event.getPctlOfficeListVO());
			eventResponse.setRsVoList(list);
			
			List<PortCloseOfficeListVO> list2 = null;
			list2 = command.searchPctlOfficeSummary(event.getPctlOfficeListVO());
			eventResponse.setRsVoList(list2);
			
			if (list.size() >0){
				PortCloseOfficeListVO vo = list.get(0);
				event.getPortCloseBLlistVO().setSelBkgOfcCd(vo.getBOfc());
			}
		}
		
		
		if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
			
			List<PortCloseBLlistVO> list3 = null;
			list3 = command.searchPctlBLList(event.getPortCloseBLlistVO());
			eventResponse.setRsVoList(list3);
			
		}
		return eventResponse;
	
	}
	/**
     * ESM_BKG_0914 : 화면에 대한 콤보리스트 조회.<br>
     * Port Closing Inquiry<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchComCode0914(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
        BkgComboVO combovo = new BkgComboVO();
        combovo.setVal(" ");
		combovo.setDesc("All");
		combovo.setName("All");
		
        //RHQ
        //Region
        List<BkgComboVO> list1 = command.searchRgnOfficeCd();
        //list1.add(0,combovo);
        eventResponse.setRsVoList(list1);
        
        
        //BKG Status
        List<BkgComboVO> list2 = command.searchCombo("CD00769");
        list2.add(0,combovo);
        eventResponse.setRsVoList(list2);
        
        
        //Rating Status
        List<BkgComboVO> list3 = command.searchCombo("CD01656");
        eventResponse.setRsVoList(list3);
        
        
        //Lane
        List<MdmVslSvcLaneVO> laneList = command.searchSvcLaneCd();
        eventResponse.setRsVoList(laneList);
        
        
        MdmOrganizationVO ofcVO = command.searchMdmOrzByOfcCd(account.getOfc_cd());
        if (ofcVO != null) {
        	eventResponse.setETCData("USER_RHQ", ofcVO.getArHdQtrOfcCd());
        } else {
        	eventResponse.setETCData("USER_RHQ", "");
        }
        
        //REV
        return eventResponse;
    }

    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0111 : C/M Data Cross-Check List (Master BL/Houser BL)를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCMCrossCheckList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0111Event event = (EsmBkg0111Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		List<BkgCMCroChkListByBLVO> list = command.searchCMCrossCheckList(event.getBkgCMCroChkListinVO());
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	}  
	

    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0112 : C/M Data Cross-Check List (Export Master BL/Houser BL)를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCMCrossExportCheckList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0112Event event = (EsmBkg0112Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		
		List<BkgCMCroChkListByExportBLVO> list = command.searchCMCrossExportCheckList(event.getBkgCMCroChkListinVO());
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0111,ESM_BKG_1143 : C/M Code를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCMCode(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
        BkgComboVO bkgComboVO = new BkgComboVO();
    	//Report Type
        List<BkgComboVO> list = command.searchCombo("CD01634");
        
        /*StringBuffer code	= new StringBuffer();
        StringBuffer name	= new StringBuffer();
        
        code.append(" ");
        name.append("All");
        */
       
        bkgComboVO.setVal(" ");
        bkgComboVO.setDesc(" ");
        bkgComboVO.setName(" ");
		
        list.add(0,bkgComboVO);
        /*if (list.size() > 0){
        	
        	for (int i = 0 ; i < list.size() ; i++){
        		
        		bkgComboVO = list.get(i);
        		
        		code.append("|" + bkgComboVO.getVal());
        		name.append("|" + bkgComboVO.getName());
        	}
		}
        
        eventResponse.setETCData("code",code.toString());
        eventResponse.setETCData("name",name.toString());
		*/
        eventResponse.setRsVoList(list);
        
		return eventResponse;
	}  
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0112 : C/M Code를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExportCMCode(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
    	//US Customs Type nException
        List<BkgComboVO> list = command.searchCombo("CD02853");

        eventResponse.setRsVoList(list);
		return eventResponse;
	}  

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0116 : C/M Print by VVD (CM)를 조회합니다.<br>
	 * @param dest 
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCMPrintList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0116Event event = (EsmBkg0116Event)e;
		
		List<BkgCMPrintListoutVO> list = null;
		List<BkgCMPrintListoutVO> list2 = null;
		List<BkgCMPrintListoutVO> list3 = null;
		
		StatusReportBC command = new StatusReportBCImpl();
		
//		List<BkgCMPrintListoutVO> list2 = new ArrayList<BkgCMPrintListoutVO>(list);
//		List<BkgCMPrintListoutVO> list3 = new ArrayList<BkgCMPrintListoutVO>(list);
		
		
		// Tab의 종류에 따라서 List 호출 제어
		// C/M : 0,  Fax: 1
		String TabIdx = event.getTapTp();
		
		
		if (TabIdx.equals("0")) {
			list = command.searchCMPrintList(event.getBkgCMPrintListinVO());
			list2 = command.searchCMPrintList(event.getBkgCMPrintListinVO());
			
			//Screen
			for(int i=0;list!=null && i<list.size();i++){list.get(i).setSplFlg("S");}

			//File
			for(int i=0;list2!=null && i<list2.size();i++) {list2.get(i).setSplFlg("F");}

		} else {
			list3 = command.searchCMPrintList(event.getBkgCMPrintListinVO());
		}

		if (TabIdx.equals("0")) {
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(list2);

		} else {
			eventResponse.setRsVoList(list3);
		}

		return eventResponse;
	}  
	
	/**
     * ESM_BKG_0116 : 화면에 대한 콤보리스트 조회.<br>
     * C/M Print by VVD<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchComCode0116(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
        // 01. Combo 데이터 조회 (RTerm)
		List<BkgComboVO> rTerm  = command.searchCombo("CD00764");		
		// 01. Combo 데이터 조회 (DTerm)
		List<BkgComboVO> dTerm  = command.searchCombo("CD00765");
		
		eventResponse.setRsVoList(rTerm);
		eventResponse.setRsVoList(dTerm);
        
        return eventResponse;
    }
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0651 : C/A Detail(s) Pop-up를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBLCaDetailList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0651Event event = (EsmBkg0651Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		String blNo 	= event.getBlNo();
		String bkgNo	= event.getBkgNo();
		String caNo		= event.getCaNo();
		
		List<BlCaDetailListVO> list = command.searchBLCaDetailList(blNo, bkgNo, caNo);
		
		eventResponse.setRsVoList(list);
		return eventResponse;
	}  
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0651 : C/A Detail(s) Pop-up 에 History List 를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException 
	 */
	private EventResponse searchBLCaDetailHisList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0651Event event = (EsmBkg0651Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		String bkgNo	= event.getBkgNo();
		String corrNo   = event.getCaNo();

		log.debug("bkg_no" + bkgNo);

		List<BlCaDetailListVO> list = command.searchBLCaDetailHisList(bkgNo, corrNo);
		
		eventResponse.setRsVoList(list);
		return eventResponse;
	}  	

	/**
	 * ESM_BKG_0214 : 조회 이벤트 처리<br>
	 * Doc Performance Report<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDOCPerformanceReport(Event e) throws EventException {
	
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0214Event event = (EsmBkg0214Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<DocPFMCOfcListVO > list = null;
		List<DocPFMCBLListVO> list2 = null;
		
		/*1.Office List*/
		if (e.getFormCommand().isCommand(FormCommand.SEARCH)){ 
			
			list = command.searchDocPFMCOfcList(event.getDocPFMCOfcListVO());
			eventResponse.setRsVoList(list);
			if (list.size() >0){
				DocPFMCOfcListVO vo = list.get(0);
				event.getDocPFMCBLListVO().setSelBkgOfcCd(vo.getBkgOfcCd());
			}
		}
		/*2.B/L List*/ 
//		if (e.getFormCommand().isCommand(FormCommand.SEARCH01) || (list != null && list.size() > 0)){
		if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
			list2 = command.searchDocPFMCBLList(event.getDocPFMCBLListVO());
			eventResponse.setRsVoList(list2);
		}
		return eventResponse;
	
	}
	/**
     * ESM_BKG_0214 : 화면에 대한 콤보리스트 조회.<br>
     * Doc Performance Report<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchComCode0214(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        BookingUtil command = new BookingUtil();
        PerformanceReportBC command = new PerformanceReportBCImpl();
        
        BkgComboVO combovo = new BkgComboVO();
        combovo.setVal(" ");
//		combovo.setDesc("All");
//		combovo.setName("All");
		
        //Region
//        List<BkgComboVO> list1 = command.searchRgnOfficeCd();
		List<BkgComboVO> list1 = command.searchRgnOfficeCdForPFMC();
        //list1.add(0,combovo);
        eventResponse.setRsVoList(list1);
        
        return eventResponse;
    }
    
    /**
     * ESM_BKG_0110 : 화면에 대한 콤보리스트 조회.<br>
     * C/A Performance Report<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchComCode0110(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
        //Correction Kind
        List<BkgComboVO> list = command.searchCombo("CD02272");
        eventResponse.setRsVoList(list);
        
        return eventResponse;
    }
	
    /**
	 * 조회 이벤트 처리<br>
	 * 0421 Queue List / 0423 Queue Summary 초기 정보를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchQueueListInitData(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<SearchUserGroupIdVO> list = searchUserGroupId();
		/* Current Queue 권한*/
		boolean isPicBtn = false;
		if (0 < list.size()) {
			for (SearchUserGroupIdVO vo : list) {
				//if ("U".equalsIgnoreCase(vo.getDpcsWrkGrpCd2())) {
				if ("U".equalsIgnoreCase(vo.getDpcsWrkGrpCd())) {
					isPicBtn = true;
					break;
				}
			}
		}
		eventResponse.setETCData("isPicBtn",isPicBtn ? "Y":"N");
		
		List<SearchUserGroupIdVO> list2 = searchUserGroupId();
		 /* Current Queue 권한*/
		if(list2.size() > 0){
			eventResponse.setETCData("grp_cd",   list2.get(0).getDpcsWrkGrpCd());
		}else{
			eventResponse.setETCData("grp_cd",   "");
		}
		
		BookingUtil command = new BookingUtil();
		
        List<BkgComboVO> list1 = null;
		BkgComboVO combovo = new BkgComboVO();
        combovo.setVal(" ");
		combovo.setDesc("All");
		combovo.setName("All");

		//Yes/No/All
        list1 = command.searchCombo("CD00912");
        list1.add(0,combovo);
        eventResponse.setRsVoList(list1);
        //Region
        list1 = command.searchCombo("CD02405");
        eventResponse.setRsVoList(list1);
        //STS
        list1 = command.searchCombo("CD02454");
        eventResponse.setRsVoList(list1);

        //SOURCE
        list1 = command.searchCombo("CD02810");
        list1.add(0,combovo);
        eventResponse.setRsVoList(list1);
        
        //S/R KIND
        list1 = command.searchCombo("CD01577");
        eventResponse.setRsVoList(list1);
        
        //Lane
        List<MdmVslSvcLaneVO> laneList = command.searchSvcLaneCd();
        eventResponse.setRsVoList(laneList);
        
        //Customer Type
        list1 = command.searchCombo("CD02140");
        eventResponse.setRsVoList(list1);
        
        //Doc Office
        list1 = command.searchCombo("CD03248");
        eventResponse.setRsVoList(list1);
        
        return eventResponse;
	}
	
    /**
	 * 조회 이벤트 처리<br>
	 * 0437 Queue List 초기 정보를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchSZPBBQueueListInitData(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<SearchUserGroupIdVO> list = searchUserGroupId();
		/* Current Queue 권한*/
		boolean isPicBtn = false;
		if (0 < list.size()) {
			for (SearchUserGroupIdVO vo : list) {
				//if ("U".equalsIgnoreCase(vo.getDpcsWrkGrpCd2())) {
				if ("U".equalsIgnoreCase(vo.getDpcsWrkGrpCd())) {
					isPicBtn = true;
					break;
				}
			}
		}
		eventResponse.setETCData("isPicBtn",isPicBtn ? "Y":"N");
		
		List<SearchUserGroupIdVO> list2 = searchUserGroupId();
		 /* Current Queue 권한*/
		if(list2.size() > 0){
			eventResponse.setETCData("grp_cd",   list2.get(0).getDpcsWrkGrpCd());
		}else{
			eventResponse.setETCData("grp_cd",   "");
		}
		
		BookingUtil command = new BookingUtil();
		PerformanceReportBC dpcsBC = new PerformanceReportBCImpl();
		
        List<BkgComboVO> list1 = null;
		BkgComboVO combovo = new BkgComboVO();
        combovo.setVal(" ");
		combovo.setDesc("All");
		combovo.setName("All");

		//Yes/No/All
        list1 = command.searchCombo("CD00912");
        list1.add(0,combovo);
        eventResponse.setRsVoList(list1);
        //Region
        list1 = command.searchCombo("CD03250");
        eventResponse.setRsVoList(list1);
        //STS
        list1 = command.searchCombo("CD03253");
        eventResponse.setRsVoList(list1);

        //SOURCE
        list1 = command.searchCombo("CD03254");
        list1.add(0,combovo);
        eventResponse.setRsVoList(list1);
        
        //S/R KIND
        list1 = command.searchCombo("CD01577");
        eventResponse.setRsVoList(list1);
        
        //Lane
        List<MdmVslSvcLaneVO> laneList = command.searchSvcLaneCd();
        eventResponse.setRsVoList(laneList);
        
        //Customer Type
        list1 = command.searchCombo("CD02140");
        eventResponse.setRsVoList(list1);
        
        //Doc Office
        list1 = command.searchCombo("CD03248");
        eventResponse.setRsVoList(list1);
        
        //Contract Type
        list1 = command.searchCombo("CD01716");
        eventResponse.setRsVoList(list1);

        //Input PIC
        list1 = dpcsBC.searchSZPBBPicCombo("I");
        eventResponse.setRsVoList(list1);
        
        //Rate PIC
        list1 = dpcsBC.searchSZPBBPicCombo("R");
        eventResponse.setRsVoList(list1);
        
        return eventResponse;
	}
	
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0421 : Que List 에 SR_WRK_STS_CD 정보를 수정한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
    private EventResponse modifyBkgSrWrkStsCd(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0421Event event = (EsmBkg0421Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		try{	
			begin();
			DocQueueDetailListVO[] vos = event.getDocQueueDetailListVOs();
			if (vos != null && vos.length > 0){
				for (int i = 0; i < vos.length; i++) {
					if (vos[i].getSel().equals("1") && !vos[i].getSrWrkStsCd().equals("D") ) {
						vos[i].setComFlg("end");
						vos[i].setUsrId(account.getUsr_id());
						command.manageQueueDetailList(vos[i],account);
					}
				}
				commit();
			}
			
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
	 * ESM_BKG_0437 : Que List 에 SR_WRK_STS_CD 정보를 수정한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
    private EventResponse modifySZPBBSrWrkStsCd(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0437Event event = (EsmBkg0437Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		try{	
			begin();
			DocQueueDetailListVO[] vos = event.getDocQueueDetailListVOs();
			if (vos != null && vos.length > 0){
				for (int i = 0; i < vos.length; i++) {
					if (vos[i].getSel().equals("1") && !vos[i].getSrWrkStsCd().equals("D") ) {
						vos[i].setComFlg("end");
						vos[i].setUsrId(account.getUsr_id());
						command.manageQueueDetailList(vos[i],account);
					}
				}
				commit();
			}
			
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
	 * ESM_BKG_0437 : Queue List 에 Input/Rate PIC 정보를 수정한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
    private EventResponse modifySZPBBPicUserId(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0437Event event = (EsmBkg0437Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
        BookingUtil util = new BookingUtil();
		try{	
			begin();
			DocQueueListOutVO[] vos = event.getDocQueueListOutVOs();
			if (vos != null && vos.length > 0){
				for (int i = 0; i < vos.length; i++) {
					if(!"".equals(vos[i].getInpPicUsrId()) && "".equals(util.searchUserName(vos[i].getInpPicUsrId()))){
						throw new EventException((String)new ErrorHandler("BKG01176", new String[]{vos[i].getInpPicUsrId()}).getMessage());
					}
					if(!"".equals(vos[i].getRtPicUsrId()) && "".equals(util.searchUserName(vos[i].getRtPicUsrId()))){
						throw new EventException((String)new ErrorHandler("BKG01176", new String[]{vos[i].getRtPicUsrId()}).getMessage());
					}
					
					command.modifySZPBBPicUserId(vos[i],account);
				}
				commit();
			}
			
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
	 * ESM_BKG_0421 : DPCS Queue List 에 SR를 정보를 삭제한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
    private EventResponse removeDpcsQueList(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0421Event event = (EsmBkg0421Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		try{	
			begin();
			DocQueueDetailListVO[] vos = event.getDocQueueDetailListVOs();
			command.removeDpcsQueList(vos,account);
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
	 * ESM_BKG_0371 : DPCS Queue List 에 SR를 정보를 삭제한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
    private EventResponse removeSZPBBQueueList(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0437Event event = (EsmBkg0437Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		try{	
			begin();
			DocQueueDetailListVO[] vos = event.getDocQueueDetailListVOs();
			command.removeDpcsQueList(vos,account);
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
	 * ESM_BKG_0421 : Que List 에 SR_WRK_STS_CD 정보를 수정한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
    private EventResponse modifyBkgSrFntPending(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0421Event event = (EsmBkg0421Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		try{	
			begin();
			DocQueueDetailListVO[] vos = event.getDocQueueDetailListVOs();
			if (vos != null && vos.length > 0){
				for (int i = 0; i < vos.length; i++) {
					if (vos[i].getSel().equals("1") ) {
						vos[i].setUsrId(account.getUsr_id());
						vos[i].setSrKind(vos[i].getSrAmdTpCd());
						if (vos[i].getPndFlg().equals("Y")) continue;
						vos[i].setSrWrkStsCd("F");
						vos[i].setSrStsCd("FP");
						command.manageQueueDetailList2(vos[i],account);
					}
				}
				commit();
			}
			
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
	 * 0421 Queue List 초기 정보를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchUserGroupId(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		 List<SearchUserGroupIdVO> list = searchUserGroupId();
		 /* Current Queue 권한*/
		if(list.size() > 0){
			eventResponse.setETCData("grp_cd",   list.get(0).getDpcsWrkGrpCd());
		}else{
			eventResponse.setETCData("grp_cd",   "");
		}
		eventResponse.setRsVoList(list);
		return eventResponse;
		
	}		
	
	/**
	 * 조회 이벤트 처리<br>
	 * User Group Id 정보를 조회합니다.<br>
	 * 
	 * @return List<SearchUserGroupIdVO>
	 * @exception EventException
	 */
	
    private List<SearchUserGroupIdVO> searchUserGroupId() throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		PerformanceReportBC command = new PerformanceReportBCImpl();
		List<SearchUserGroupIdVO> list = command.searchUserGroupId(account.getUsr_id());
		return list;
	}
	/**
	 * 조회 이벤트 처리<br>
	 * 0421 Queue List 정보를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchQueueList(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0421Event event = (EsmBkg0421Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		event.getInfoVO().setUsrId(account.getUsr_id());
		event.getInfoVO().setOfcCd(account.getOfc_cd().substring(0, 3));
		event.getInfoVO().setInput(event.getInfoVO().getInput().trim());
		event.getInfoVO().setRate(event.getInfoVO().getRate().trim());
		event.getInfoVO().setQa(event.getInfoVO().getQa().trim());
		event.getInfoVO().setFax(event.getInfoVO().getFax().trim());
		event.getInfoVO().setRegion(event.getInfoVO().getRegion().trim());
		event.getInfoVO().setSts(event.getInfoVO().getSts().trim());
		
		String set_qry_where = "";
		if ("Y".equals(event.getInfoVO().getSetSlctFlg())) {
        	set_qry_where = command.searchQueueListSearchSetWhere(account.getUsr_id());
			event.getInfoVO().setSetQryWhere(set_qry_where);
        }
		
		List<DocQueueListOutVO> list = command.searchQueueList(event.getInfoVO());
		
		if(list.size() > 0){
			list.get(0).setMaxRows(Integer.parseInt(list.get(0).getTotalCnt()));
			eventResponse.setETCData("total_bkg"      ,list.get(0).getTotalBkg      ());
			eventResponse.setETCData("total_sr"       ,list.get(0).getTotalSr       ());
			eventResponse.setETCData("total_input"    ,list.get(0).getTotalInput    ());
			eventResponse.setETCData("total_rate"     ,list.get(0).getTotalRate     ());
			eventResponse.setETCData("total_qa"       ,list.get(0).getTotalQa       ());
			eventResponse.setETCData("total_fax"      ,list.get(0).getTotalFax      ());
			eventResponse.setETCData("total_pending"  ,list.get(0).getTotalPending  ());
			eventResponse.setETCData("total_working"  ,list.get(0).getTotalWorking  ());
			eventResponse.setETCData("total_canceled" ,list.get(0).getTotalCanceled ());
			eventResponse.setETCData("total_completed",list.get(0).getTotalCompleted());
			eventResponse.setETCData("total_na"       ,list.get(0).getTotalNa       ());
			eventResponse.setETCData("total_bdr"      ,list.get(0).getTotalBdr      ());
			eventResponse.setETCData("total_pct"      ,list.get(0).getTotalPct      ());
			eventResponse.setETCData("total_urgent"   ,list.get(0).getTotalUrgent   ());
			eventResponse.setETCData("total_vip"      ,list.get(0).getTotalVip      ());
			eventResponse.setETCData("total_normal"   ,list.get(0).getTotalNormal   ());
			eventResponse.setETCData("total_cnt"      ,list.get(0).getTotalCnt      ());
			eventResponse.setETCData("total_rtn"      ,list.get(0).getTotalRtn      ());
			eventResponse.setETCData("total_cutoff"   ,list.get(0).getTotalCutoff   ());
			eventResponse.setETCData("total_rtn_cust" ,list.get(0).getTotalRtnCust  ());
			eventResponse.setETCData("total_rtn_fo"   ,list.get(0).getTotalRtnFo    ());
		}
		eventResponse.setRsVoList(list);

		return eventResponse;
		
	}	  
	/**
	 * 조회 이벤트 처리<br>
	 * 0437 Queue List 정보를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSZPBBQueueList(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0437Event event = (EsmBkg0437Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		event.getInfoVO().setUsrId(account.getUsr_id());
		event.getInfoVO().setOfcCd(account.getOfc_cd().substring(0, 3));
		event.getInfoVO().setInput(event.getInfoVO().getInput().trim());
		event.getInfoVO().setRate(event.getInfoVO().getRate().trim());
		event.getInfoVO().setQa(event.getInfoVO().getQa().trim());
		event.getInfoVO().setFax(event.getInfoVO().getFax().trim());
		event.getInfoVO().setRegion(event.getInfoVO().getRegion().trim());
		event.getInfoVO().setSts(event.getInfoVO().getSts().trim());
		
		String set_qry_where = "";
		if ("Y".equals(event.getInfoVO().getSetSlctFlg())) {
        	set_qry_where = command.searchQueueListSearchSetWhere(account.getUsr_id());
			event.getInfoVO().setSetQryWhere(set_qry_where);
        }
		
		List<DocQueueListOutVO> list = command.searchSZPBBQueueList(event.getInfoVO());
		
		if(list.size() > 0){
			list.get(0).setMaxRows(Integer.parseInt(list.get(0).getTotalCnt()));
			eventResponse.setETCData("total_bkg"      ,list.get(0).getTotalBkg      ());
			eventResponse.setETCData("total_sr"       ,list.get(0).getTotalSr       ());
			eventResponse.setETCData("total_input"    ,list.get(0).getTotalInput    ());
			eventResponse.setETCData("total_rate"     ,list.get(0).getTotalRate     ());
			eventResponse.setETCData("total_qa"       ,list.get(0).getTotalQa       ());
			eventResponse.setETCData("total_fax"      ,list.get(0).getTotalFax      ());
			eventResponse.setETCData("total_pending"  ,list.get(0).getTotalPending  ());
			eventResponse.setETCData("total_working"  ,list.get(0).getTotalWorking  ());
			eventResponse.setETCData("total_canceled" ,list.get(0).getTotalCanceled ());
			eventResponse.setETCData("total_completed",list.get(0).getTotalCompleted());
			eventResponse.setETCData("total_na"       ,list.get(0).getTotalNa       ());
			eventResponse.setETCData("total_bdr"      ,list.get(0).getTotalBdr      ());
			eventResponse.setETCData("total_pct"      ,list.get(0).getTotalPct      ());
			eventResponse.setETCData("total_urgent"   ,list.get(0).getTotalUrgent   ());
			eventResponse.setETCData("total_vip"      ,list.get(0).getTotalVip      ());
			eventResponse.setETCData("total_normal"   ,list.get(0).getTotalNormal   ());
			eventResponse.setETCData("total_cnt"      ,list.get(0).getTotalCnt      ());
			eventResponse.setETCData("total_rtn"      ,list.get(0).getTotalRtn      ());
			eventResponse.setETCData("total_cutoff"   ,list.get(0).getTotalCutoff   ());
			eventResponse.setETCData("total_rtn_cust" ,list.get(0).getTotalRtnCust  ());
			eventResponse.setETCData("total_rtn_fo"   ,list.get(0).getTotalRtnFo    ());
		}
		eventResponse.setRsVoList(list);

		return eventResponse;
		
	}	  
	/**
	 * 조회 이벤트 처리<br>
	 * 0422 Queue List 정보를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchQueueDetailList(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0422Event event = (EsmBkg0422Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<DocQueueDetailListVO> list = null ;
				
		String rqstInfo = "";
		
		if(e.getAttribute("s_gubun") == "META"){
			list = command.searchQueueDetailList(event.getUserPartCd(),  event.getBkgNo(), event.getSrNo(),  account.getUsr_id(),  event.getSrKind(), event.getSrKndCd());
			if(list.size() > 0){
				eventResponse.setETCData(list.get(0).getColumnValues());				
			}
		}else{
			list = command.searchQueueDetailList(event.getInfoVO());
			//sr_knd_cd 가 E(EDI),S(SEA-NACCS)일 때 Go To BKG에 필요한 e-booking 정보를 가져온다.
			if (event.getInfoVO().getSrcCd().equals("E") || event.getInfoVO().getSrcCd().equals("S")
					||(event.getInfoVO().getSrcCd().equals("M") &&  event.getInfoVO().getXterSndrId().equals("EML")    ) 
					||(event.getInfoVO().getSrcCd().equals("U") &&  event.getInfoVO().getXterSndrId().equals("ULD")    ) 
			   ){
				rqstInfo = command.searchRqstInfo(event.getInfoVO().getBkgNo());
			}
		}					
				
		eventResponse.setRsVoList(list);
		eventResponse.setETCData("rqstInfo",rqstInfo);
		return eventResponse;
		
	}
	/**
	 * 조회 이벤트 처리<br>
	 * 0437 Queue List 정보를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSZPBBQueueDetailList(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0438Event event = (EsmBkg0438Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<DocQueueDetailListVO> list = null ;
				
		String rqstInfo = "";
		
		if(e.getAttribute("s_gubun") == "META"){
			list = command.searchQueueDetailList(event.getUserPartCd(),  event.getBkgNo(), event.getSrNo(),  account.getUsr_id(),  event.getSrKind(), event.getSrKndCd());
			if(list.size() > 0){
				eventResponse.setETCData(list.get(0).getColumnValues());				
			}
		}else{
			list = command.searchQueueDetailList(event.getInfoVO());
			//sr_knd_cd 가 E(EDI),S(SEA-NACCS)일 때 Go To BKG에 필요한 e-booking 정보를 가져온다.
			if (event.getInfoVO().getSrcCd().equals("E") || event.getInfoVO().getSrcCd().equals("S")
					||(event.getInfoVO().getSrcCd().equals("M") &&  event.getInfoVO().getXterSndrId().equals("EML")    ) 
					||(event.getInfoVO().getSrcCd().equals("U") &&  event.getInfoVO().getXterSndrId().equals("ULD")    ) 
			   ){
				rqstInfo = command.searchRqstInfo(event.getInfoVO().getBkgNo());
			}
		}					
				
		eventResponse.setRsVoList(list);
		eventResponse.setETCData("rqstInfo",rqstInfo);
		return eventResponse;
		
	}	    
    
	/**
	 * 조회 이벤트 처리<br>
	 * 0422 Queue List 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchQueueDetailList4(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0422Event event = (EsmBkg0422Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		String[] completeFlg = null;
		
		completeFlg = command.searchQueueDetailList4(event.getBkgNo()).split(",");

		eventResponse.setETCData("input_flg",completeFlg[0]);
		eventResponse.setETCData("rate_flg",completeFlg[1]);
		return eventResponse;
		
	}  
    
	/**
	 * 조회 이벤트 처리<br>
	 * 0438 Queue List 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSZPBBQueueDetailList4(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0438Event event = (EsmBkg0438Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		String[] completeFlg = null;
		
		completeFlg = command.searchSZPBBQueueDetailList4(event.getBkgNo()).split(",");

		eventResponse.setETCData("input_flg",completeFlg[0]);
		eventResponse.setETCData("rate_flg",completeFlg[1]);
		return eventResponse;
		
	}
	
	/**
     * 0422 Completed 버튼 클릭시 Queue Detail 관련 테이블을 트랜잭션 처리합니다.<br>	
     * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageQueueDetailList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0422Event event = (EsmBkg0422Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		try{
			DocQueueDetailListVO docQueueDetailListVO = event.getInfoVO();
			begin();
			command.manageQueueDetailList(docQueueDetailListVO,account);
			commit();
			
			if (docQueueDetailListVO.getComFlg().equals("qa") 
					&& event.getCallPgmType().equals("QA")){
				eventResponse = (GeneralEventResponse) modifySiValAuto(event);
			}else if (docQueueDetailListVO.getComFlg().equals("inp") ){
				/*BKG BOOKING에  SI FLAG Mark */
				GeneralBookingReceiptBC generalBookingReceiptBC = new GeneralBookingReceiptBCImpl();
				generalBookingReceiptBC.modifySiFlag(docQueueDetailListVO.getBkgNo(),"Y");
			}	
			
			
			eventResponse.setETCData("success_yn"      ,  "Y");
		}catch(EventException ex){
			eventResponse.setETCData("success_yn"      ,  "N");
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}    
	
	/**
     * 0438 Completed 버튼 클릭시 Queue Detail 관련 테이블을 트랜잭션 처리합니다.<br>	
     * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSZPBBQueueDetailList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0438Event event = (EsmBkg0438Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		try{
			DocQueueDetailListVO docQueueDetailListVO = event.getInfoVO();
			begin();
			command.manageQueueDetailList(docQueueDetailListVO,account);
			commit();
			
			if (docQueueDetailListVO.getComFlg().equals("qa") 
					&& event.getCallPgmType().equals("QA")){
				eventResponse = (GeneralEventResponse) modifySZPBBSiValAuto(event);
			}else if (docQueueDetailListVO.getComFlg().equals("inp") ){
				/*BKG BOOKING에  SI FLAG Mark */
				GeneralBookingReceiptBC generalBookingReceiptBC = new GeneralBookingReceiptBCImpl();
				generalBookingReceiptBC.modifySiFlag(docQueueDetailListVO.getBkgNo(),"Y");
			}	
			
			
			eventResponse.setETCData("success_yn"      ,  "Y");
		}catch(EventException ex){
			eventResponse.setETCData("success_yn"      ,  "N");
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	/**
	 * 0422 BOOKING S/I KIND에 따른 VALUE 자동 세팅.<b	
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifySiValAuto(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0422Event event = (EsmBkg0422Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		try{
			DocQueueDetailListVO docQueueDetailListVO = event.getInfoVO();
			ModifySiValAutoVO modifySiValAutoVO = new ModifySiValAutoVO();
			/*
			 * 
			F,B	BL Confim ==>BKG_XTER_RQST_MST.DOC_TP_CD
			E	AES
			C	CAED
			I	IE
			*/ 
			modifySiValAutoVO.setBkgNo(docQueueDetailListVO.getBkgNo());
			modifySiValAutoVO.setXterSndrId(docQueueDetailListVO.getXterSndrId());
			modifySiValAutoVO.setXterRqstNo(docQueueDetailListVO.getXterRqstNo());
			modifySiValAutoVO.setXterRqstSeq(docQueueDetailListVO.getXterRqstSeq());
			modifySiValAutoVO.setCallPgmType(event.getCallPgmType());
			modifySiValAutoVO.setUsrId(account.getUsr_id());
			
			begin();
			modifySiValAutoVO = command.modifySiValAuto(modifySiValAutoVO,event.getCallPgmType());
			commit();
			eventResponse.setETCData(modifySiValAutoVO.getColumnValues());
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	/**
	 * 0438 BOOKING S/I KIND에 따른 VALUE 자동 세팅.<b	
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifySZPBBSiValAuto(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0438Event event = (EsmBkg0438Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		try{
			DocQueueDetailListVO docQueueDetailListVO = event.getInfoVO();
			ModifySiValAutoVO modifySiValAutoVO = new ModifySiValAutoVO();
			/*
			 * 
			F,B	BL Confim ==>BKG_XTER_RQST_MST.DOC_TP_CD
			E	AES
			C	CAED
			I	IE
			*/ 
			modifySiValAutoVO.setBkgNo(docQueueDetailListVO.getBkgNo());
			modifySiValAutoVO.setXterSndrId(docQueueDetailListVO.getXterSndrId());
			modifySiValAutoVO.setXterRqstNo(docQueueDetailListVO.getXterRqstNo());
			modifySiValAutoVO.setXterRqstSeq(docQueueDetailListVO.getXterRqstSeq());
			modifySiValAutoVO.setCallPgmType(event.getCallPgmType());
			modifySiValAutoVO.setUsrId(account.getUsr_id());
			
			begin();
			modifySiValAutoVO = command.modifySiValAuto(modifySiValAutoVO,event.getCallPgmType());
			commit();
			eventResponse.setETCData(modifySiValAutoVO.getColumnValues());
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	/**
	 * 0422 Pending 버튼 클릭시 BKG_SR_CRNT_RQST 관련 테이블을 트랜잭션 처리합니다.<b	
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageQueueDetailList2(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0422Event event = (EsmBkg0422Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		try{
			DocQueueDetailListVO docQueueDetailListVO = event.getInfoVO();
			begin();
			if (docQueueDetailListVO.getSrWrkStsCd().equals("P") 
					|| docQueueDetailListVO.getPndFlg().equals("Y")){
				docQueueDetailListVO.setComFlg("pnx");
				command.manageQueueDetailList(docQueueDetailListVO,account);
			}else{
				if (docQueueDetailListVO.getGrpCd().equals("F")){
					docQueueDetailListVO.setSrWrkStsCd("F");
					docQueueDetailListVO.setSrStsCd("FP");
				}else{
					docQueueDetailListVO.setSrWrkStsCd("P");
					docQueueDetailListVO.setSrStsCd("PN");
				}
				command.manageQueueDetailList2(docQueueDetailListVO,account);
			}
			commit();
			eventResponse.setETCData("success_yn"      ,  "Y");
		}catch(EventException ex){
			eventResponse.setETCData("success_yn"      ,  "N");
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	/**
	 * 0438 Pending 버튼 클릭시 BKG_SR_CRNT_RQST 관련 테이블을 트랜잭션 처리합니다.<b	
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSZPBBQueueDetailPending(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0438Event event = (EsmBkg0438Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		try{
			DocQueueDetailListVO docQueueDetailListVO = event.getInfoVO();
			begin();
			if (docQueueDetailListVO.getSrWrkStsCd().equals("P") 
					|| docQueueDetailListVO.getPndFlg().equals("Y")){
				docQueueDetailListVO.setComFlg("pnx");
				command.manageQueueDetailList(docQueueDetailListVO,account);
			}else{
				if (docQueueDetailListVO.getGrpCd().equals("F")){
					docQueueDetailListVO.setSrWrkStsCd("F");
					docQueueDetailListVO.setSrStsCd("FP");
				}else{
					docQueueDetailListVO.setSrWrkStsCd("P");
					docQueueDetailListVO.setSrStsCd("PN");
				}
				command.manageQueueDetailList2(docQueueDetailListVO,account);
			}
			commit();
			eventResponse.setETCData("success_yn"      ,  "Y");
		}catch(EventException ex){
			eventResponse.setETCData("success_yn"      ,  "N");
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
		
	/**
	 * 0984 Return to Return  버튼 클릭시 관련 데이블 데이타를 생성/수정합니다.<br>	
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageQueueRtnToRtn(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0984Event event = (EsmBkg0984Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		try{
			DocQueueDetailReturnInVO docQueueDetailReturnInVO = event.getInfoVO();
			begin();
			command.manageQueueRtnToRtn(docQueueDetailReturnInVO,account);
			commit();
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			eventResponse.setETCData("success_yn"      ,  "Y");
		}catch(EventException ex){
			eventResponse.setETCData("success_yn"      ,  "N");
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	/**
     * 0985 Return  버튼 클릭시 Return 관련 데이블 데이타을 수정/생성 합니다.<br>	
     * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageQueueDetailReturn(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0985Event event = (EsmBkg0985Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		try{
			DocQueueDetailReturnInVO docQueueDetailReturnInVO = event.getInfoVO();
			SearchQueueDetailReturnReasonCdListVO[] searchQueueDetailReturnReasonCdListVOs = event.getSearchQueueDetailReturnReasonCdListVOs();
			begin();
			command.manageQueueDetailReturn(docQueueDetailReturnInVO,searchQueueDetailReturnReasonCdListVOs,account);
			if ( "Y".equals(docQueueDetailReturnInVO.getEmlCpyToCustFlg()) ) {
				// 메일발송
				command.sendDpcsRejectEmail(docQueueDetailReturnInVO,account);
			}
			commit();
			/**
		    * BPM 연동 처리 부분 ( BPM POC 이후 삭제 필요 )
		    */
			/*if (docQueueDetailReturnInVO.getSrcCd().equalsIgnoreCase("F") &&  !docQueueDetailReturnInVO.getSrcCd().equals("")){
				String eventKey = docQueueDetailReturnInVO.getBkgNo() + "_" +docQueueDetailReturnInVO.getSrNo();
				BookingInterfaceMgtBC bpmBc = new BookingInterfaceMgtBCImpl();
				bpmBc.bpmExecCall("RJ",eventKey,account.getUsr_id());
			}*/
			
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			eventResponse.setETCData("success_yn"      ,  "Y");
		}catch(EventException ex){
			eventResponse.setETCData("success_yn"      ,  "N");
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
	
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0110 : C/A Performance Report 를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCAPerformanceReport(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0110Event event = (EsmBkg0110Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		List<CaPerformanceReportOutVO> list = command.searchCAPerformanceReport(event.getCaPerformanceReportInVO());
		
		eventResponse.setRsVoList(list);
		return eventResponse;
	}  
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0174 : C/A Summary By VVD & Office 를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReportTemplateListMain(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0174Event event = (EsmBkg0174Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
        BookingUtil util = new BookingUtil();
		
		BkgRptDfltVO returnVo = null;		
		
		try{			
			EBookingReceiptBC command2 = new EBookingReceiptBCImpl();
			// Delivery - conti_cd
			List<BkgComboVO> conti_cd = command2.searchComboMdmConti();
			BkgComboVO combovo = new BkgComboVO();
			combovo.setVal(" ");
			combovo.setName("All");
			conti_cd.add(0,combovo);	
			
	        //RHQ
	        //Region
	        List<BkgComboVO> rgnOfcList = util.searchRgnOfficeCd();
			
			BkgRptDfltVO vo = event.getBkgRptDfltVO();			
			vo.setOwnrUsrId(account.getUsr_id());
						
	        List<BkgRptDfltVO> list = command.searchReportTemplateList(vo);	        
	        eventResponse.setRsVoList(list);
	        
	        String listSize	= Integer.toString(list.size());	        
	        if (list.size() > 0){	        	
	        	for (int i = 0 ; i < list.size() ; i++){	
	        		returnVo = (BkgRptDfltVO)list.get(i);	        		
	        		eventResponse.setETCData("rptNm_" + Integer.toString(i+1), returnVo.getRptNm());
	        		eventResponse.setETCData("rptId_" + Integer.toString(i+1), returnVo.getRptId());
	        		eventResponse.setETCData("kndCd_" + Integer.toString(i+1), returnVo.getBkgRptKndCd());
	        		eventResponse.setETCData("seq_" + Integer.toString(i+1), returnVo.getBzcCondSqlCtnt());
	        		eventResponse.setETCData("ord_" + Integer.toString(i+1), returnVo.getBzcOrdCtnt());
	        	}
	        }
	        
	        eventResponse.setETCData("listSize",listSize);
	        eventResponse.setRsVoList(conti_cd);	
	        eventResponse.setRsVoList(rgnOfcList);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	} 
    /**
	 * ESM_BKG_0631 : 조회 이벤트 처리<br>
	 * Revenue Base VVD 조회
     * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
     */
    private EventResponse searchRBCVesselList(Event e) throws EventException {
    	// PDTO(Data Transfer Object including Parameters)
    	EsmBkg0631Event event = (EsmBkg0631Event) e;
    	
    	String fromDt	= event.getFromDt();
    	String toDt		= event.getToDt();
    	log.debug("fromDt >>>>>> "+ fromDt);
    	log.debug("toDt >>>>>>>> "+ toDt);
    	
    	PerformanceReportBC command = new PerformanceReportBCImpl();
    	List<RbcvesselVO> list = command.searchRBCVesselList(fromDt, toDt);
    	
    	GeneralEventResponse eventResponse = new GeneralEventResponse();    	
    	eventResponse.setRsVoList(list);
    	
    	return eventResponse;
    }
    
    /**
     * ESM_BKG_0632 : 화면에 대한 콤보리스트 조회.<br>
     * Sales Performance Report<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchComCode0632(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        SpecialReportBC command2 = new SpecialReportBCImpl();
        
        //Booking Cargo Type Code
        List<BkgComboVO> list = command.searchCombo("CD00767");
        eventResponse.setRsVoList(list);
        
        //Sales Performance Report Kind Code
        List<BkgComboVO> list2 = command.searchCombo("CD02287");
        eventResponse.setRsVoList(list2);
        
        //Sales Performance Group By Code
        List<BkgComboVO> list3 = command.searchCombo("CD02288");
        eventResponse.setRsVoList(list3);
        
        //Service Mode Code
        List<BkgComboVO> list4 = command.searchCombo("CD02149");
        eventResponse.setRsVoList(list4);
        
        BkgComboVO combovo = new BkgComboVO();
		combovo.setDesc("ALL CONTINENT");
		combovo.setVal("");
        
        //Service Route 
		list = command2.searchScontiCd();
		list.add(0,combovo);
		eventResponse.setRsVoList(list);
        
        return eventResponse;
    }
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0632 : Sales Performance Report 를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
    private EventResponse searchSalesPerformanceReport(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0632Event event = (EsmBkg0632Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		List<SaelsPerformanceReportOutVO> list = command.searchSalesPerformanceReport(event.getSaelsPerformanceReportInVO());
		
		eventResponse.setRsVoList(list);
		return eventResponse;
	}  
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0632 : (Sales Performance Report) VVD에 해당하는 Lane 를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
    private EventResponse searchVVDByLane(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0632Event event = (EsmBkg0632Event)e;
		BookingUtil command = new BookingUtil();
		
		String lane = "none";
		String vvd  = event.getSaelsPerformanceReportInVO().getVvdSig();
		
		if (command.validateVvd(vvd.substring(0, 4), vvd.substring(4, 8), vvd.substring(8))){
			
			lane = command.searchSvcLaneByVvd(vvd);
		}
		
		eventResponse.setETCData("lane", lane);
		return eventResponse;
	}  
    
    
    /**
	 * 조회 이벤트 처리<br>
	 * 1004 Super User Authority Change를 위한 해당 그룹 USER 정보를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchDPSCUserGroup(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
    	EsmBkg1004Event event = (EsmBkg1004Event)e;
    	BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<SearchUserGroupIdVO> list2 = searchUserGroupId();
			 /* Current Queue 권한*/
			if(list2.size() > 0){
				event.getBkgDpcsUsrGrpVO().setDpcsWrkGrpCd(list2.get(0).getDpcsWrkGrpCd());
			}
			List<BkgDpcsUsrGrpVO> list = command.searchDPSCUserGroup(null,null,event.getBkgDpcsUsrGrpVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	    
    
	
	/**
	 * 1004 Super User Authority Change - PIC CHANGE(0421화면) 버튼 클릭시 관련 데이블 데이타를 수정합니다.<br>	
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse modifyDocsUserGroupCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1004Event event = (EsmBkg1004Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		try{
			DocsUserGroupCdVO docsUserGroupCdVO = event.getInfoVO();
			begin();
			command.modifyDocsUserGroupCd(docsUserGroupCdVO,account);
			commit();
			eventResponse.setETCData("success_yn"      ,  "Y");
		}catch(EventException ex){
			eventResponse.setETCData("success_yn"      ,  "N");
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
    
    /**
	 * 조회 이벤트 처리<br>
	 * 1006 Queue Detail Amend Reason Detail을 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    
    private EventResponse searchAmendDetail(Event e) throws EventException {
		

		EsmBkg1006Event event = (EsmBkg1006Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<DocsAmendReasonCDVO> list = command.searchAmendDetail(event.getBkgNo(), event.getSrNo());
		if(list.size() > 0){
			eventResponse.setETCData("mis_typ"       ,  list.get(0).getMisTyp());    
			eventResponse.setETCData("mis_rat_sc"    , 	list.get(0).getMisRatSc());  
			eventResponse.setETCData("mis_rat_rfa"   , 	list.get(0).getMisRatRfa()); 
			eventResponse.setETCData("wro_dat_inp"   , 	list.get(0).getWroDatInp()); 
			eventResponse.setETCData("sal"           , 	list.get(0).getSal());       
			eventResponse.setETCData("fo_err"        , 	list.get(0).getFoErr());     
																									                             
			eventResponse.setETCData("dat_mis"       , 	list.get(0).getDatMis());    
			eventResponse.setETCData("unc_fax"       , 	list.get(0).getUncFax());    
			eventResponse.setETCData("bl_dat_cha"    , 	list.get(0).getBlDatCha());  
			eventResponse.setETCData("cod"           , 	list.get(0).getCod());       
			eventResponse.setETCData("spl"           , 	list.get(0).getSpl());       
		}
		
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
		
	}	     
	/**
	 * 조회 이벤트 처리<br>
	 * 1007 Queue Detail Return Reason을 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
    private EventResponse searchQueueDetail(Event e) throws EventException {
		

		EsmBkg1007Event event = (EsmBkg1007Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<DocsQueueDetailVO> list = command.searchQueueDetail(event.getSrKndCd(),event.getBkgNo(), event.getSrNo());
		if(list.size() > 0){
			eventResponse.setETCData("bkg_main"              , list.get(0).getBkgMain());             
			eventResponse.setETCData("customer_info"         , list.get(0).getCustomerInfo());        
			eventResponse.setETCData("frt_charge"            , list.get(0).getFrtCharge());           
			eventResponse.setETCData("container"             , list.get(0).getContainer());           
			eventResponse.setETCData("container_manifest"    , list.get(0).getContainerManifest());   
			eventResponse.setETCData("danger"                , list.get(0).getDanger());              
			eventResponse.setETCData("awkward"               , list.get(0).getAwkward());             
			eventResponse.setETCData("reefer"                , list.get(0).getReefer());              
			eventResponse.setETCData("b_bulk"                , list.get(0).getBBulk());               
			eventResponse.setETCData("rly_vvd_port"          , list.get(0).getRlyVvdPort());          
			eventResponse.setETCData("new_bkg"               , list.get(0).getNewBkg());              
			eventResponse.setETCData("bkg_split"             , list.get(0).getBkgSplit());            
			eventResponse.setETCData("bl_inform"             , list.get(0).getBlInform());            
			eventResponse.setETCData("nvo_house_bl"          , list.get(0).getNvoHouseBl());          
			eventResponse.setETCData("customer_verification" , list.get(0).getCustomerVerification());    
		}
		
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
		
	}	
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * 0424 Open 시 Queue VVD List 정보를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchQueueVvdList(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0424Event event = (EsmBkg0424Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<DocQueueVvdListVO> list = command.searchQueueVvdList(event.getInfoVO());
		eventResponse.setRsVoList(list);
		
		return eventResponse;		
	}
	/**
	 * 조회 이벤트 처리<br>
	 * 0424  Total VVD List 정보를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse search0424ListByQueue(Event e) throws EventException {
		
		
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
		/* R/D Term R- OUTBOUND RECEIVED */
		//List<BkgComboVO> list = command.searchCombo("CD01579");
		List<BkgComboVO> list = command.searchCombo("CD02360"); 
		//list.add(0,combovo);
		eventResponse.setRsVoList(list);
		 //Doc Part
        list = command.searchCombo("CD02405");
        eventResponse.setRsVoList(list);
		return eventResponse;		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 0424 Open 시 Queue VVD List 정보를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchQueueReportByPol(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0424Event event = (EsmBkg0424Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<DocQueueReportByPolListOutVO> list = command.searchQueueReportByPol(event.getInfoVO2());
		if(list.size() > 0){
			list.get(0).setMaxRows(Integer.parseInt(list.get(0).getTotalCnt()));
			eventResponse.setETCData("ttl_bkg"            ,	list.get(0).getTtlBkg());       
			eventResponse.setETCData("inputter_queue"     ,	list.get(0).getInputterQueue());
			eventResponse.setETCData("sr_transferred"     ,	list.get(0).getSrTransferred());
			eventResponse.setETCData("inputting"          ,	list.get(0).getInputting());    
			                                               	                                
			eventResponse.setETCData("sr_y"               ,	list.get(0).getSrY());          
			eventResponse.setETCData("rater_queue"        ,	list.get(0).getRaterQueue());   
			eventResponse.setETCData("inputted"           ,	list.get(0).getInputted());     
			eventResponse.setETCData("rating"             ,	list.get(0).getRating());       
			                                               	                                
			eventResponse.setETCData("sr_n"               ,	list.get(0).getSrN());          
			eventResponse.setETCData("auditor_queue"      ,	list.get(0).getAuditorQueue()); 
			eventResponse.setETCData("rated"              ,	list.get(0).getRated());        
			eventResponse.setETCData("auditing"           ,	list.get(0).getAuditing());     
			eventResponse.setETCData("audited"            ,	list.get(0).getAudited());      
			                                               	                                
			eventResponse.setETCData("stopped_queue"      ,	list.get(0).getStoppedQueue()); 
			eventResponse.setETCData("fofc_returned"      ,	list.get(0).getFofcReturned()); 
			                                               	                                
			eventResponse.setETCData("queue_total"        ,	list.get(0).getQueueTotal());   
			                                               	                                
			eventResponse.setETCData("bst_matched_q"      ,	list.get(0).getBstMatchedQ());  
			eventResponse.setETCData("bst_unmatched_q"    ,	list.get(0).getBstUnmatchedQ());    
		}
		eventResponse.setRsVoList(list);
		
		return eventResponse;
		
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0568 : C/A Report  를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchCaIssueDateList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0568Event event = (EsmBkg0568Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		List<CaIssueDateOutVO> list = command.searchCaIssueDateList(event.getCaIssueDateInVO());
		
		eventResponse.setRsVoList(list);
		return eventResponse;
	} 
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0568 : C/A Report 에 History List 를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchCaIssueDateHisList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0568Event event = (EsmBkg0568Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		String bkgNo = event.getCaIssueDateInVO().getBkgNo();
		String corrNo = event.getCaIssueDateInVO().getCorrNo();
		log.debug("bkg_no" + bkgNo);
		log.debug("corr_no"+ corrNo);
		List<BlCaDetailListVO> list = command.searchBLCaDetailHisList(bkgNo,corrNo);
		
		
		eventResponse.setRsVoList(list);
		return eventResponse;
	} 
    
    /**
	 * 멀티 이벤트 처리<br>
	 * ESM_BKG_0568 : C/A Repor 에 Remark를 수정합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse modifyCaIssueRemark(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0568Event event = (EsmBkg0568Event)e;
		BDRCorrectionBC command = new BDRCorrectionBCImpl();
				
		
		try{
			
			begin();
			
			command.modifyCaIssueRemark(event.getCaIssueDateInVOS(),account);
			
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			
			commit();
			eventResponse.setETCData("success_yn"      ,  "Y");

		} catch(EventException ex) {
			rollback();
			eventResponse.setETCData("success_yn"      ,  "N");
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			eventResponse.setETCData("success_yn"      ,  "N");
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_BKG_0568 : C/A Repor 에 Remark를 수정후 Mainfest에 Flat File 등록합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse manageManifestFlatFile(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0568Event event = (EsmBkg0568Event)e;
		
		ManifestListDownloadBC command2 = new UsaManifestListDownloadBCImpl();
//		CndManifestListDownloadBCImpl command3 = new CndManifestListDownloadBCImpl();
		CndManifestListDownloadBackEndJob command3 = new CndManifestListDownloadBackEndJob();
		ManifestListDetailVO[] vos = new ManifestListDetailVO[1];		
		UsaManifestListDetailVO usVo = new UsaManifestListDetailVO();
		CndManifestModificationVO caVo = new CndManifestModificationVO();
		
		//########################################################## 2010.04.20 추가
		
		ManifestListDownloadBC manifestListDownloadBC = new UsaManifestListDownloadBCImpl();
		CustomsTransmissionBC usaCommand = new UsaCustomsTransmissionBCImpl();
		CLLCDLManifestBC cLLCDLManifestBC = new CLLCDLManifestBCImpl();
		
		CustomsTransmissionBC cndCommand = new CndCustomsTransmissionBCImpl();
		
		//########################################################## 2010.04.20 추가 끝
		try{

			begin();
			log.debug(" vos size >>>>>>>>>>>>>>>>>>> " + event.getCaIssueDateInVOS().length);
			//세관에 신고할 Manifest 데이터를 조회하여 FlatFile을 생성하고 Send Log를 저장한다 >>> 11/23수정
			for (int i = 0 ; i < event.getCaIssueDateInVOS().length ; i++){
				
				log.debug("vvd >>>>>>>>>>> " + event.getCaIssueDateInVOS()[i].getVvd());
				log.debug("vslCd >>>>>>>>> " + event.getCaIssueDateInVOS()[i].getVvd().substring(0, 4));
				log.debug("SkdVoyNo >>>>>>>>> " + event.getCaIssueDateInVOS()[i].getVvd().substring(4, 8));
				log.debug("skdDirCd >>>>>>>>> " + event.getCaIssueDateInVOS()[i].getVvd().substring(8));
				log.debug("blNo >>>>>>>>> " + event.getCaIssueDateInVOS()[i].getBlNo());
				log.debug("bkgNo >>>>>>>>> " + event.getCaIssueDateInVOS()[i].getBkgNo());
				log.debug("caNo >>>>>>>>> " + event.getCaIssueDateInVOS()[i].getCorrNo());
				log.debug("caDt >>>>>>>>> " + event.getCaIssueDateInVOS()[i].getCorrDt().replaceAll("-", "").replaceAll(":", "").replaceAll(" ", ""));							
				
				log.debug("pod >>> " + event.getCaIssueDateInVOS()[i].getPodCd().substring(0, 2));
				
//				if (event.getCaIssueDateInVOS()[i].getCntCd().equals("US")){
				if (event.getCaIssueDateInVOS()[i].getPodCd().substring(0, 2).equals("US")){
		
					usVo.setPgmNo("ESM_BKG_0568");
					
					usVo.setVslCd(event.getCaIssueDateInVOS()[i].getVvd().substring(0, 4));
					usVo.setSkdVoyNo(event.getCaIssueDateInVOS()[i].getVvd().substring(4, 8));
					usVo.setSkdDirCd(event.getCaIssueDateInVOS()[i].getVvd().substring(8));
					usVo.setBkgNo(event.getCaIssueDateInVOS()[i].getBkgNo());
					usVo.setBlNos(event.getCaIssueDateInVOS()[i].getBlNo());
					usVo.setBlType("M");
					usVo.setPodCd(event.getCaIssueDateInVOS()[i].getPodCd());
					
					usVo.setCaNo(event.getCaIssueDateInVOS()[i].getCorrNo());
					usVo.setCaIssDt(event.getCaIssueDateInVOS()[i].getCorrDt().replaceAll("-", "").replaceAll(":", ""));
					usVo.setCaFlg("Y");
					
					vos[0] = usVo;
					
					command2.manageManifest(vos, account);
					
					
					//########################################################## 2010.04.20 추가
					
					// 미세관 update
					UsaManifestListDetailVO[] usaDetailVOs = new UsaManifestListDetailVO[1];
					usaDetailVOs[0] = new UsaManifestListDetailVO();
					usaDetailVOs[0].setBlNo(event.getCaIssueDateInVOS()[i].getBlNo());
					usaDetailVOs[0].setCstmsMfTpCd("AI");
					usaDetailVOs[0].setCstmsTrsmStsCd("04");
					usaDetailVOs[0].setPgmNo("ESM_BKG_0028");
					manifestListDownloadBC.manageManifest(usaDetailVOs, account);

					// 미세관 AI 전송
					UsaManifestSearchDetailVO[] usaDetailVO2s = new UsaManifestSearchDetailVO[1];
					usaDetailVO2s[0] = new UsaManifestSearchDetailVO();
					usaDetailVO2s[0].setBlNo(event.getCaIssueDateInVOS()[i].getBlNo());
					usaDetailVO2s[0].setVvd(event.getCaIssueDateInVOS()[i].getVvd()); //bkg_vvd
					usaDetailVO2s[0].setPol(event.getCaIssueDateInVOS()[i].getPolCd()); //bkg_vvd
					usaDetailVO2s[0].setPod(event.getCaIssueDateInVOS()[i].getPodCd()); //bkg_vvd 
					usaDetailVO2s[0].setTransmitCd("AI");
					usaDetailVO2s[0].setUsrId(account.getUsr_id());
					usaDetailVO2s[0].setOfcCd(account.getOfc_cd());
					usaCommand.transmitManifest(usaDetailVO2s);

					// CDL 자동전송
					BlInfoCondVO blInfoCondVO = new BlInfoCondVO();
					blInfoCondVO.setBlNo(event.getCaIssueDateInVOS()[i].getBlNo());
					List<BlInfoVO> blInfos = usaCommand.searchTmlBlByVvd(blInfoCondVO);
					if (blInfos.size() > 0)
					{
						CllCdlTransmitVO[] cllCdlTransmitVOs = new CllCdlTransmitVO[blInfos.size()];
						for (int j = 0; j < blInfos.size(); j++)
						{
							UsaTmlBlByVvdVO usaTmlBlByVvdVO = (UsaTmlBlByVvdVO) blInfos.get(j);
							cllCdlTransmitVOs[j] = new CllCdlTransmitVO();
							cllCdlTransmitVOs[j].setBkgNo(usaTmlBlByVvdVO.getBkgNo());
							cllCdlTransmitVOs[j].setBlNo(usaTmlBlByVvdVO.getBlNo());
							cllCdlTransmitVOs[j].setCntrNo(usaTmlBlByVvdVO.getCntrNo());
							cllCdlTransmitVOs[j].setBkgCgoTpCd(usaTmlBlByVvdVO.getBkgCgoTpCd());
							cllCdlTransmitVOs[j].setInListType("D");
							cllCdlTransmitVOs[j].setInVvdCd(usaTmlBlByVvdVO.getVslCd() + usaTmlBlByVvdVO.getSkdVoyNo()
									+ usaTmlBlByVvdVO.getSkdDirCd());
							cllCdlTransmitVOs[j].setInPolCd(usaTmlBlByVvdVO.getCstmsPolCd());
							cllCdlTransmitVOs[j].setInPodCd(usaTmlBlByVvdVO.getCstmsPodCd());
							cllCdlTransmitVOs[j].setInSndId(usaTmlBlByVvdVO.getSndId());
							cllCdlTransmitVOs[j].setInRcvId(usaTmlBlByVvdVO.getRcvId());
							cllCdlTransmitVOs[j].setInYdCd(usaTmlBlByVvdVO.getYdCd());
							cllCdlTransmitVOs[j].setInAreaId("USA");
							cllCdlTransmitVOs[j].setInDestSvrCd("USA");
							cllCdlTransmitVOs[j].setInWhereGubun("DL");
						}
						
						cLLCDLManifestBC.transmitCllCdl(cllCdlTransmitVOs, account);
					}
					//########################################################## 2010.04.20 추가 끝
				}else{
				
					caVo.setVslCd(event.getCaIssueDateInVOS()[i].getVvd().substring(0, 4));
					caVo.setSkdVoyNo(event.getCaIssueDateInVOS()[i].getVvd().substring(4, 8));
					caVo.setSkdDirCd(event.getCaIssueDateInVOS()[i].getVvd().substring(8));
					caVo.setBkgNo(event.getCaIssueDateInVOS()[i].getBkgNo());
					caVo.setBlNos(event.getCaIssueDateInVOS()[i].getBlNo());
					caVo.setBlType("M");
					caVo.setIfFlg("Y");
					caVo.setPodCd(event.getCaIssueDateInVOS()[i].getPodCd());
					
					caVo.setCaNo(event.getCaIssueDateInVOS()[i].getCorrNo());
					caVo.setCaIssDt(event.getCaIssueDateInVOS()[i].getCorrDt().replaceAll("-", "").replaceAll(":", ""));
					
					vos[0] = caVo;
					
					command3.setManifestListDetailVO(vos, account, new CndManifestListDownloadDBDAO());
					command3.doStart();
					
					if (event.getCaIssueDateInVOS()[i].getPodCd().substring(0, 2).equals("CA")){
					
						//########################################################## 2010.04.20 추가
						CndCstmsManifestAmendmentVO cndCstmsManifestAmendmentVO = new CndCstmsManifestAmendmentVO();
						cndCstmsManifestAmendmentVO.setBlNo(event.getCaIssueDateInVOS()[i].getBlNo());
						cndCstmsManifestAmendmentVO.setMh(""); //master : M, house : H
						cndCstmsManifestAmendmentVO.setFullMtyCd(""); //Full : F, empty : M
	
						CndManifestModificationVO[] cndManifestModificationVOs = new CndManifestModificationVO[1];
						cndManifestModificationVOs[0] = new CndManifestModificationVO();
						cndManifestModificationVOs[0].setBlNo(event.getCaIssueDateInVOS()[i].getBlNo());
						cndManifestModificationVOs[0].setCstmsTrsmStsCd("04");
						if ("M".equals(cndCstmsManifestAmendmentVO.getMh())) {
							cndManifestModificationVOs[0].setCstmsMfTpCd("A6A");
							if ("M".equals(cndCstmsManifestAmendmentVO.getFullMtyCd())) {
								cndManifestModificationVOs[0].setCstmsMfTpCd("E10");
							}
						} else {
							cndManifestModificationVOs[0].setCstmsMfTpCd("S10");
						}
						manifestListDownloadBC.manageManifest(cndManifestModificationVOs, account);
	
						// 전송
						cndCstmsManifestAmendmentVO.setMiSndDt(cndManifestModificationVOs[0].getEdiSndDt());
						cndCommand.transAmendManifest(cndCstmsManifestAmendmentVO, account);
						//########################################################## 2010.04.20 추가 끝  
					}
					
				}

			}
	
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			
			commit();
			eventResponse.setETCData("success_yn"      ,  "Y");
		} catch(EventException ex) {
			rollback();
			eventResponse.setETCData("success_yn"      ,  "N");
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			eventResponse.setETCData("success_yn"      ,  "N");
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0570 : C/A Report_B/L Inquiry 를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
    private EventResponse searchCaByBLno(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0570Event event = (EsmBkg0570Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		String corrNo = "";
		log.debug("bl no = " + event.getBlNo());
		List<CaInquiryReportVO> list1 = command.searchCaByBLno(event.getBlNo());
		
		if (list1.size() > 0)
			corrNo = list1.get(0).getCorrNo();
		
		List<CaInquiryReportVO> list2 = command.searchCaByCustomerInfo(event.getBlNo(), corrNo);
		List<CaInquiryReportVO> list3 = command.searchCaByMarkDescInfo(event.getBlNo(), corrNo);
		List<CaInquiryReportVO> list4 = command.searchCaByContainerInfo(event.getBlNo(), corrNo);
		
		if (list2.size() == 0){
			
			list2 = command.searchCaByCustomerInfo(event.getBlNo(), "");
		}
		
		if (list3.size() == 0){
			
			list3 = command.searchCaByMarkDescInfo(event.getBlNo(), "");
		}

		if (list4.size() == 0){
			
			list4 = command.searchCaByContainerInfo(event.getBlNo(), "");
		}
		
		eventResponse.setRsVoList(list1);
		eventResponse.setRsVoList(list2);
		eventResponse.setRsVoList(list3);
		eventResponse.setRsVoList(list4);
		return eventResponse;
	} 
	 /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_1057 : Freight & Charge List by VVD 를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchFCLList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1057Event event = (EsmBkg1057Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		List<SearchFCLListVO> list = command.searchFCLList(event.getSearchFCLListVO());
		//List<SearchFCLListVO> list2 = command.searchFCLList(event.getSearchFCLListVO());
		
		/*for (int i = 0; i <list2.size(); i++)
		{
			list2.get(i).setSplFlg("F");
		}*/
		
		eventResponse.setRsVoList(list);
		//eventResponse.setRsVoList(list2);
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 0066 B/L Processing Report 정보를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBlTurnTimeReport(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0066Event event = (EsmBkg0066Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		event.getInfoVO().setUsrId(account.getUsr_id());
		
		List<DocTurnTimeOutVO> list = command.searchBlTurnTimeReport(event.getInfoVO());
		eventResponse.setRsVoList(list);
		
		return eventResponse;		
	}	
	
    /**
     * ESM_BKG_0066 : 화면에 대한 초기데이타 조회합니다.<br>
     * 0066 B/L Processing Report<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse search0066InitData(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
        //Performance by Queue
        List<BkgComboVO> list = command.searchCombo("CD02100");
        eventResponse.setRsVoList(list);
        
        //S/R KIND
        list = command.searchCombo("CD01577");
        eventResponse.setRsVoList(list);
        
        //Doc Part
        list = command.searchCombo("CD02405");
        eventResponse.setRsVoList(list);
        
        
        String[] usrGrpInfo 	= searchUserPartCd ();     
        
        if (usrGrpInfo != null){
        
        	eventResponse.setETCData("usrGrpCd", usrGrpInfo[0]);
        	eventResponse.setETCData("usrPrpCd", usrGrpInfo[1]);
        	eventResponse.setETCData("usrSvrCd", usrGrpInfo[2]);
        }else{
        	
        	eventResponse.setETCData("usrGrpCd", "");
        	eventResponse.setETCData("usrPrpCd", "");
        	eventResponse.setETCData("usrSvrCd", "");
        }
        
        return eventResponse;
    }
    
    /**
	 * 조회 이벤트 처리<br>
	 * 0940 I/B DOC Performance Report 정보를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInBoundPfmcReport(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0940Event event = (EsmBkg0940Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<InBoundReportOutVO> list = command.searchInBoundPfmcReport(event.getInfoVO());
		eventResponse.setRsVoList(list);
		
		return eventResponse;		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 0953 O/B & T/S Loading Report by Location 정보를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTsLoadingReportByLocation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0953Event event = (EsmBkg0953Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<TsLoadingRptByLocListOutVO> list = command.searchTsLoadingReportByLocation(event.getInfoVO());
		if(list.size() > 0){
			eventResponse.setETCData("total_40t", list.get(0).getTotal40t());
			eventResponse.setETCData("total_20t", list.get(0).getTotal20t());
		}
		eventResponse.setRsVoList(list);
		
		return eventResponse;		
	}    
	/**
	 * 조회 이벤트 처리<br>
	 * 0274 General Cargo Manifest by VVD/PORT 정보를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBLCargoManifestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0274Event event = (EsmBkg0274Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<BlCargoManifestOutVO> list = command.searchBLCargoManifestList(event.getInfoVO());
		
		BlCargoManifestInVO blCargoManifestInVO = new BlCargoManifestInVO();
		blCargoManifestInVO = event.getInfoVO();
		
		if(list.size() > 0){
			
			BlCargoManifestOutVO ovo = (BlCargoManifestOutVO) list.get(0);
			
			// Outbound 이고 RFS Lane 인 경우 POL YD 값이 없으면 경고 메시지
			if("O".equals(blCargoManifestInVO.getModeType()) && "RFS".equals(ovo.getSlanCd()) && "".equals(blCargoManifestInVO.getPolYdCd())){
				throw new EventException((String)new ErrorHandler("BKG06148", new String[]{"for RFS"}).getMessage());
			}
			
			// Inbound 이고 RFS Lane 인 경우 POD YD 값이 없으면 경고 메시지
			if("I".equals(blCargoManifestInVO.getModeType()) && "RFS".equals(ovo.getSlanCd()) && "".equals(blCargoManifestInVO.getPodYdCd())){
				throw new EventException((String)new ErrorHandler("BKG06148", new String[]{"for RFS"}).getMessage());
			}
			
			eventResponse.setETCData("hd_vvd_cd", list.get(0).getHdVvdCd());
			eventResponse.setETCData("hd_pol_pod", list.get(0).getHdPolPod()  );
			eventResponse.setETCData("hd_pol_pod_cd", list.get(0).getHdPolPodCd());
			eventResponse.setETCData("hd_eta_etd", list.get(0).getHdEtaEtd()  );
			eventResponse.setETCData("hd_eta_etd_cd", list.get(0).getHdEtaEtdCd());
			eventResponse.setETCData("hd_mode_type", list.get(0).getHdModeType());
		}
		eventResponse.setRsVoList(list);
		
		return eventResponse;		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 0274 General Cargo Manifest by VVD/PORT 정보를 Container단위로 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBLCntrCargoManifestList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0274Event event = (EsmBkg0274Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<BlCntrCargoManifestOutVO> list = command.searchBLCntrCargoManifestList(event.getInfoVO());
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;		
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * 0410 Performance Report by Volume 정보를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDPCSVolList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0410Event event = (EsmBkg0410Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
//		List<SearchDPCSVolListOutVO> list = command.searchDPCSVolList(event.getInfoVO());
		List<SearchDpcsPerfByVolListVO> list = command.searchDPCSVolList(event.getInfoVO());
		if(list.size() > 0){
			eventResponse.setETCData("tot_staffs",            list.get(0).getTotStaffs());         
			eventResponse.setETCData("tot_sr_vol",            list.get(0).getTotSrVol());          
			eventResponse.setETCData("tot_sr_kind",           list.get(0).getTotSrKind());         
			eventResponse.setETCData("tot_bkg_vol",           list.get(0).getTotBkgVol());         
																																													   
			eventResponse.setETCData("tot_staffs_inputter",   list.get(0).getTotStaffsInputter()); 
			eventResponse.setETCData("tot_sr_vol_inputter",   list.get(0).getTotSrVolInputter());  
			eventResponse.setETCData("tot_sr_kind_new",       list.get(0).getTotSrKindNew());      
																																													   
			eventResponse.setETCData("tot_staffs_rater",      list.get(0).getTotStaffsRater());    
			eventResponse.setETCData("tot_sr_vol_rater",      list.get(0).getTotSrVolRater());     
			eventResponse.setETCData("tot_sr_kind_amend",     list.get(0).getTotSrKindAmend());    
																																													   
			eventResponse.setETCData("tot_staffs_auditor",    list.get(0).getTotStaffsAuditor());  
			eventResponse.setETCData("tot_sr_vol_auditor",    list.get(0).getTotSrVolAuditor());   
			eventResponse.setETCData("tot_sr_kind_bl_cnfm",   list.get(0).getTotSrKindBlCnfm());   
																																													   
			eventResponse.setETCData("tot_staffs_fofc",       list.get(0).getTotStaffsFofc());     
			eventResponse.setETCData("tot_sr_vol_fofc",       list.get(0).getTotSrVolFofc());      
			eventResponse.setETCData("tot_sr_kind_addition",  list.get(0).getTotSrKindAddition()); 
		}
		eventResponse.setRsVoList(list);
		
		return eventResponse;		
	}    
	
	/**
	 * 조회 이벤트 처리<br>
	 * 0410  정보를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse search0410InitData(Event e) throws EventException {
	       // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
        //doc Part 
        List<BkgComboVO> list = command.searchCombo("CD02405");
        eventResponse.setRsVoList(list);

        //S/R KIND
        list = command.searchCombo("CD01577");
        eventResponse.setRsVoList(list);
        //Performance by Queue
        list = command.searchCombo("CD02100");
        eventResponse.setRsVoList(list);
        
        list = command.searchCombo("CD03248");
        eventResponse.setRsVoList(list);
        
        return eventResponse;
	}
		

	/**
	 * 조회 이벤트 처리<br>
	 * 0953  Sort List 정보를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse search0953SortList(Event e) throws EventException {
		
		
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
		/* Sort */
		List<BkgComboVO> list = command.searchCombo("CD02370");
		eventResponse.setRsVoList(list);
		return eventResponse;		
	}

	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0174 : C/A Summary Report Result 를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCaSummaryReport(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0174Event event = (EsmBkg0174Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		List<CaSummaryReportOutVO> list = command.searchCaSummaryReport(event.getCaSummaryReportInVO()); 

		eventResponse.setRsVoList(list);
		
		return eventResponse;
	} 	
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0174 : C/A Summary Report BL List 를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCaSummaryReportBLList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0174Event event = (EsmBkg0174Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		List<CaSummaryReportOutVO> list = command.searchCaSummaryReportBLList(event.getCaSummaryReportInVO()); 

		eventResponse.setRsVoList(list);
		
		return eventResponse;
	} 		
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0746 : Vessel Utilization Status vs. Bsa by Lane 에 Trade Code 를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselUtilizationTrade(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0746Event event = (EsmBkg0746Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		List<VesselUtilizationStatusReportInVO> list = command.searchVesselUtilizationTrade(event.getVesselUtilizationStatusReportInVO()); 

		eventResponse.setRsVoList(list);
		
		return eventResponse;
	} 	
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0746 : Vessel Utilization Status vs. Bsa by Lane 에 Sub Trade Code 를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselUtilizationSubTrade(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0746Event event = (EsmBkg0746Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		List<VesselUtilizationStatusReportInVO> list = command.searchVesselUtilizationSubTrade(event.getVesselUtilizationStatusReportInVO()); 

		eventResponse.setRsVoList(list);
		
		return eventResponse;
	} 		
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0746 : Vessel Utilization Status vs. Bsa by Lane 에 Bound Code 를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselUtilizationBound(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0746Event event = (EsmBkg0746Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		List<VesselUtilizationStatusReportInVO> list = command.searchVesselUtilizationBound(event.getVesselUtilizationStatusReportInVO()); 

		eventResponse.setRsVoList(list);
		
		return eventResponse;
	} 		
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0746 : Vessel Utilization Status vs. Bsa by Lane 에 BSA by Lane 리스트를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVesselUtilizationStatusReport(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0746Event event = (EsmBkg0746Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		List<VesselUtilizationStatusReportOutVO> list = command.searchVesselUtilizationStatusReport(event.getVesselUtilizationStatusReportInVO()); 

		eventResponse.setRsVoList(list);
		
		String max_port_seq = null;
		
		if (list.size() > 0) max_port_seq = list.get(0).getMaxPortSeq();
		
		eventResponse.setETCData("max_port_seq",max_port_seq);
		
		return eventResponse;
	} 		

    /**
	 * 0985 Queue Detail Return 정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchQueueDetailReturn(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0985Event event = (EsmBkg0985Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//Performance by Queue
		
		//Select Reason List
		SearchQueueDetailReturnReasonCdListVO searchQueueDetailReturnReasonCdListVO = event.getSearchQueueDetailReturnReasonCdListVO();
		searchQueueDetailReturnReasonCdListVO.setReasonType("M");
		List<SearchQueueDetailReturnReasonCdListVO>  mCodelist = command.searchQueueDetailReturnReasonCdList(searchQueueDetailReturnReasonCdListVO);
        eventResponse.setRsVoList(mCodelist);
        searchQueueDetailReturnReasonCdListVO.setReasonType("D");
        List<SearchQueueDetailReturnReasonCdListVO>  dCodelist = command.searchQueueDetailReturnReasonCdList(searchQueueDetailReturnReasonCdListVO);
        eventResponse.setRsVoList(dCodelist);
        
		List<DocQueueDetailReturnInVO> list = command.searchQueueDetailReturn(event.getInfoVO());
		if(list.size() > 0){
			eventResponse.setETCData("ui_grp_cd",           list.get(0).getUiGrpCd());
			if(JSPUtil.getNull(list.get(0).getSrStsCd()).equals("RR") || JSPUtil.getNull(list.get(0).getSrProcStsCd()).equals("R")  ){
				eventResponse.setETCData("return_yn",           "Y");        
			}else{
				eventResponse.setETCData("return_yn",           "N");        
			}
			eventResponse.setETCData("message",				list.get(0).getMessage()); 
			eventResponse.setETCData("rtn_to_usr_eml",		list.get(0).getRtnToUsrEml());        
			eventResponse.setETCData("fnt_ofc_eml",		list.get(0).getFntOfcEml());
			eventResponse.setETCData("inputer_eml",		list.get(0).getInputerEml());
			eventResponse.setETCData("rater_eml",		list.get(0).getRaterEml());
			eventResponse.setETCData("cust_eml",		list.get(0).getCustEml());
			
			eventResponse.setETCData("eml_cpy_to_cust_flg",		list.get(0).getEmlCpyToCustFlg());
			eventResponse.setETCData("eml_subj_ctnt",		list.get(0).getEmlSubjCtnt());
			eventResponse.setETCData("st_dt",				list.get(0).getStDt());
			
			eventResponse.setETCData("rsn_bkg_mn_flg",		list.get(0).getRsnBkgMnFlg());    
			eventResponse.setETCData("rsn_cust_info_flg",	list.get(0).getRsnCustInfoFlg()); 
			eventResponse.setETCData("rsn_frt_chg_flg",		list.get(0).getRsnFrtChgFlg());   
			eventResponse.setETCData("rsn_cntr_flg",		list.get(0).getRsnCntrFlg());     
			eventResponse.setETCData("rsn_cntr_mf_flg",		list.get(0).getRsnCntrMfFlg());   
																										                                  
			eventResponse.setETCData("rsn_dcgo_flg",		list.get(0).getRsnDcgoFlg());     
			eventResponse.setETCData("rsn_awk_cgo_flg",		list.get(0).getRsnAwkCgoFlg());   
			eventResponse.setETCData("rsn_rc_flg",			list.get(0).getRsnRcFlg());       
			eventResponse.setETCData("rsn_bb_cgo_flg",		list.get(0).getRsnBbCgoFlg());    
			eventResponse.setETCData("rsn_rly_port_flg",	list.get(0).getRsnRlyPortFlg());  
																										                                  
			eventResponse.setETCData("rsn_new_bkg_flg",		list.get(0).getRsnNewBkgFlg());   
			eventResponse.setETCData("rsn_split_flg",		list.get(0).getRsnSplitFlg());    
			eventResponse.setETCData("rsn_bl_info_flg",		list.get(0).getRsnBlInfoFlg());   
			eventResponse.setETCData("rsn_hbl_flg",			list.get(0).getRsnHblFlg());
			eventResponse.setETCData("cust_verif_flg",		list.get(0).getCustVerifFlg());  
			
			eventResponse.setETCData("fo_rcv_eml",		list.get(0).getFoRcvEml());   
			eventResponse.setETCData("srep_eml",		list.get(0).getSrepEml());
		}else{
			eventResponse.setETCData("eml_cpy_to_cust_flg", "N");
			eventResponse.setETCData("eml_subj_ctnt", 	"");
			eventResponse.setETCData("fnt_ofc_eml",		"");
			eventResponse.setETCData("inputer_eml",		"");
			eventResponse.setETCData("rater_eml",		"");
			eventResponse.setETCData("cust_eml",		"");
			eventResponse.setETCData("srep_eml",		"");
			eventResponse.setETCData("st_dt","");
		}
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
		
	}	
	
	/**
	 * 1073 Customer EDI ID Inquiry정보를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchEDIGrpId(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg1073Event event = (EsmBkg1073Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<SearchEDIGrpIDVO> list = command.searchEDIGrpId(event.getInfoVO());
		eventResponse.setRsVoList(list);
		
		return eventResponse;
		
	}	
    
    /**
     * ESM_BKG_1081 : 화면에 대한 콤보리스트 조회.<br>
     * Autorating Accuracy monitoring Report 조회(ESM_BKG_1081)<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchComCode1081(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        BkgComboVO combovo = new BkgComboVO();
        combovo.setVal(" ");
		combovo.setDesc("All");
		combovo.setName("All");
		
        //Region
        List<BkgComboVO> list1 = command.searchRgnOfficeCd();
        list1.add(0,combovo);
        eventResponse.setRsVoList(list1);
        
        //CTRT CODE - CD02565
        List<BkgComboVO> list2 = command.searchCombo("CD02565");
        list2.add(0,combovo);
        eventResponse.setRsVoList(list2);
        return eventResponse;
    }
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_1081 : Autorating Accuracy monitoring Report 조회.<br>
	 * 1.Autorating Accuracy Ration<br>
	 * 
	 * @param  Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAutoratingReport(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1081Event event = (EsmBkg1081Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		List<AutoratingReportVO> list = command.searchAutoratingReport(event.getAutoratingReportVO()); 
		eventResponse.setRsVoList(list);
		
//		if (list.size() > 0) {
//			eventResponse.setETCData(list.get(0).getColumnValues());
//			event.getAutoratingReportVO().setSelScpCd(list.get(0).getSvcScpCd());
//			event.getAutoratingReportVO().setSelOfcCd(list.get(0).getBkgOfcCd());
//			
//			event.getAutoratingReportVO().setSvcScpCd(list.get(0).getSvcScpCd());
//			event.getAutoratingReportVO().setBkgOfcCd(list.get(0).getBkgOfcCd());
//			List<AutoratingReportVO> list2 = command.searchNonAutoratingReport(event.getAutoratingReportVO()); 
//			eventResponse.setRsVoList(list2);
//		}
		return eventResponse;
	} 
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_1081 : Autorating Accuracy monitoring Report 조회.<br>
	 * 2.Non Autorating B/L List<br>
	 * 
	 * @param  Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNonAutoratingReport(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1081Event event = (EsmBkg1081Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();

		event.getAutoratingReportVO().setSvcScpCd(event.getAutoratingReportVO().getSelScpCd());
		event.getAutoratingReportVO().setBkgOfcCd(event.getAutoratingReportVO().getSelOfcCd());
		
		List<AutoratingReportVO> list = command.searchNonAutoratingReport(event.getAutoratingReportVO()); 
		eventResponse.setRsVoList(list);
		return eventResponse;
	} 
	
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_1082 : 1 weeks Daily Booking Trend by Customer 조회.<br>
	 * 
	 * @param  Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBookingTrendReport(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1082Event event = (EsmBkg1082Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		List<SearchBookingTrendReportVO> list = command.searchBookingTrendReport(event.getSearchBookingTrendReportVO()); 
		eventResponse.setRsVoList(list);
		return eventResponse;
	} 
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_1082 : 3 weeks Daily Booking Trend by Customer 엑셀 조회.<br>
	 * 
	 * @param  Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBookingTrendReportDetail(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1082Event event = (EsmBkg1082Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		List<SearchBookingTrendReportVO> list = command.searchBookingTrendReportDeail(event.getSearchBookingTrendReportVO()); 
		eventResponse.setRsVoList(list);
		return eventResponse;
	} 
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_1082 : (2 weeks Daily Booking Trend by Customer) VVD에 해당하는 Lane 를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	
    private EventResponse searchVVDByLane2(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1082Event event = (EsmBkg1082Event)e;
		BookingUtil command = new BookingUtil();
		
		String lane = "none";
		String vvd  = event.getSearchBookingTrendReportVO().getVvdSig();
		
		if (command.validateVvd(vvd.substring(0, 4), vvd.substring(4, 8), vvd.substring(8))){
			
			lane = command.searchSvcLaneByVvd(vvd);
		}
		
		eventResponse.setETCData("lane", lane);
		return eventResponse;
	}  
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_1083 : 2 weeks Daily Booking Trend by Customer >>> B/L Detail조회.<br>
	 * 
	 * @param  Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBookingTrendReportBLDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1083Event event = null;
		PerformanceReportBC command = null;
		List<SearchBookingTrendReportVO> list = null; 
		try {
			event = (EsmBkg1083Event)e;
			command = new PerformanceReportBCImpl();
			list = command.searchBookingTrendReportBLDetail(event.getSearchBookingTrendReportVO()); 
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	} 
	
	/**
	 * 조회 이벤트 처리 (ESM_BKG_0174)<br>
	 * 조회조건을 가져오기위한 MultiCombo조회 결과<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
/*
	private EventResponse searchComCode0174(Event e) throws EventException {
		try{
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// Delivery - conti_cd
			List<BkgComboVO> conti_cd = command.searchComboMdmConti();

			eventResponse.setCustomData("conti_cd", conti_cd);

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
*/
    /**
	 * ESM_BKG_0485 : 조회 이벤트 처리<br>
	 * Special Cargo Manifest information<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpecialCargoManifestInfo(Event e) throws EventException {
		EsmBkg0485Event event = (EsmBkg0485Event)e;
		SpecialReportBC command = new SpecialReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<SpecialCargoManifestInfoVO> list = null;
		list = command.searchSpecialCargoManifestInfo(event.getSpecialCargoManifestInfoVO());
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0485 : 조회 이벤트 처리<br>
	 * Check Special Cargo Manifest RD<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkSpecialCargoManifestRd(Event e) throws EventException {
		EsmBkg0485Event event = (EsmBkg0485Event)e;
		String dg = "";
		String awk = "";
		String bb = "";
		String rf = "";
		String stwg = "";
		
		SpecialReportBC command = new SpecialReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<SpecialCargoManifestInfoVO> list = null;
		list = command.checkSpecialCargoManifestRd(event.getSpecialCargoManifestInfoVO());
		SpecialCargoManifestInfoVO vo = (SpecialCargoManifestInfoVO)list.get(0);
		dg = vo.getDg();
		awk = vo.getAwk();
		bb = vo.getBb();
		rf = vo.getRf();
		stwg = vo.getStwg();
		
		eventResponse.setETCData("dg", dg);
		eventResponse.setETCData("awk", awk);
		eventResponse.setETCData("bb", bb);
		eventResponse.setETCData("rf", rf);
		eventResponse.setETCData("stwg", stwg);
		eventResponse.setRsVoList(list);
		return eventResponse;
	}


	/**
	 * EsmBkgChnEdiReceiveEvent :  <br>
	 * EDI 수신 메시지에 대한 처리.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse loadRcvMsg(Event e) throws EventException {
		
		log.info("SC [loadRcvMsg] Start---------------------");
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PerformanceReportBC command = new PerformanceReportBCImpl();
		EsmBkgChnEdiReceiveEvent event = (EsmBkgChnEdiReceiveEvent)e;
		try
		{
			begin();
			command.loadRcvMsg(event.getRcvMsg());
			commit();
		}
		catch (EventException ex)
		{
			log.error("EventException : " + ex.getMessage());
			rollback();
			throw ex;
		}
		catch (Exception ex)
		{
			log.error("Exception : " + ex.getMessage());
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		
		log.info("SC [loadRcvMsg] End---------------------");
		return eventResponse;
	}	

	/**
     * ESM_BKG_0425 : 화면에 대한 콤보리스트 조회.<br>
     * Email Account Set-up for Front Office<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchComCode0425(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{	
	        if (e.getFormCommand().isCommand(FormCommand.COMMAND01)){
		        EsmBkg0425Event event = (EsmBkg0425Event)e;
				String message = checkCode0425(event.getBkgEmlAcctStupVO());
				if (!JSPUtil.getNull(message).equals("")){
					eventResponse.setETCData("CHECK_RESULT_KEY", "F");
					eventResponse.setUserMessage(message);
					return eventResponse;
				}else{
					return eventResponse;
				}
	        }
	        BookingUtil command = new BookingUtil();
	        
	        // 01. DPCS EMAIL SERVICE KIND CODE(BL,IV)
			List<BkgComboVO> list1  = command.searchCombo("CD02801");		
			// 02. DPCS EMAIL STANDARD GROUP TYPE CODE (L  Lane  ,R  Route  ,S  S/C No  ,O  Office  )
			List<BkgComboVO> list2  = command.searchCombo("CD02802");
			// 02. DPCS EMAIL LOCATION GROUP TYPE CODE (CO  Conti.  ,SC  Sub-Conti ....)
			List<BkgComboVO> list3  = command.searchCombo("CD02800");
			List<BkgComboVO> list4  = command.searchCombo("CD02405");
			
			BkgComboVO combovo = new BkgComboVO();
	        combovo.setVal(" ");
			combovo.setDesc("All");
			combovo.setName("*");
			list3.add(0,combovo);
			
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
			eventResponse.setRsVoList(list3);
			eventResponse.setRsVoList(list4);
	        
	        return eventResponse;
        } catch(EventException ex) {
        	throw ex;
			//throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}    
    }
	/**
	 * ESM_BKG_0425 : 조회 이벤트 처리<br>
	 * Email Account Set-up for Front Office<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgEmlAcctStupList(Event e) throws EventException {
		EsmBkg0425Event event = (EsmBkg0425Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<BkgEmlAcctStupVO> list = null;
		list = command.searchBkgEmlAcctStupList(event.getBkgEmlAcctStupVO());
		eventResponse.setRsVoList(list);
		return eventResponse;
	}	

	/**
	 * 입력/수정/삭제 이벤트 처리<br>
	 * ESM_BKG_0425 : Email Account Set-up for Front Office정보를 입력/수정/삭제한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBkgEmlAcctStup(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0425Event event = (EsmBkg0425Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		BkgEmlAcctStupVO[] bkgEmlAcctStups = event.getBkgEmlAcctStupVOS();
		
		try{	
			begin();
			for (int i = 0; i < bkgEmlAcctStups.length; i++) {
				String message = checkCode0425(bkgEmlAcctStups[i]) ;
				if (!JSPUtil.getNull(message).equals("")){
					eventResponse.setUserMessage(message);
					eventResponse.setETCData("CHECK_RESULT_KEY", "F");
					return eventResponse;
				}
			}	
			command.manageBkgEmlAcctStup(bkgEmlAcctStups,account);
			eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * VALUE CHECK 이벤트 처리<br>
	 * ESM_BKG_0425 : BKG Office,SVC Kind,Location 체크한다.<br>
	 * 
	 * @param     BkgEmlAcctStupVO vo
	 * @return    String
	 * @exception EventException
	 */
	public String checkCode0425(BkgEmlAcctStupVO vo) throws EventException {
		BookingUtil command = new BookingUtil();
		String message = "";
		try{
			if (vo.getIbflag().equals("I") || vo.getIbflag().equals("U") || vo.getIbflag().equals("")) {
				String dpcsEmlStndGrpTpCd = JSPUtil.getNull(vo.getDpcsEmlStndGrpTpCd());
				String polDpcsEmlLocGrpTpCd = JSPUtil.getNull(vo.getPolDpcsEmlLocGrpTpCd());
				String delDpcsEmlLocGrpTpCd = JSPUtil.getNull(vo.getDelDpcsEmlLocGrpTpCd());
				
				//Office Cd 체크
				String ofcCd = JSPUtil.getNull(vo.getBkgOfcCd());
				if (ofcCd.equals("") && !vo.getIbflag().equals("")){
					message = (String) new ErrorHandler("BKG01107",new String[]{ofcCd}).getUserMessage() +"(" + ofcCd +")";
					return message;
				}else  if (!ofcCd.equals("")){
					MdmOrganizationVO  mdmOrzVO = command.searchMdmOrzByOfcCd(ofcCd);
					if (mdmOrzVO == null || mdmOrzVO.getArOfcCd().equals("")){
						message = (String) new ErrorHandler("BKG01107",new String[]{ofcCd}).getUserMessage() +"(" + ofcCd +")";
						return message;
					}
				}
				
				//Criteria가 Lane일 경우
				/*if (dpcsEmlStndGrpTpCd.equals("L")){
					//Lane 체크
					String sLaneCd = vo.getVbsCtnt();
					if(sLaneCd != null && sLaneCd.length() > 0){
						if(JSPUtil.getNull(command.searchMdmVslSvcLane(sLaneCd)).equals("")){
							message = (String) new ErrorHandler("BKG00330",new String[]{sLaneCd}).getUserMessage() +"["+sLaneCd+"]";
							return message;
						}	
					}else{
						message = (String) new ErrorHandler("BKG00330",new String[]{sLaneCd}).getUserMessage() +"["+sLaneCd+"]";
						return message;
					}
					//Criteria가 S/C No일 경우		
				}else if (dpcsEmlStndGrpTpCd.equals("S")){
					// S/C No 체크
					String scNo = vo.getVbsCtnt();
					if(scNo != null && scNo.length() > 0){
						if(JSPUtil.getNull(command.searchScNoValidationCheck(scNo)).equals("")){
							message = "S/C NO" +(String) new ErrorHandler("BKG06012",new String[]{scNo}).getUserMessage();
							return message;
						}	
					}else{
						message = "S/C NO" +(String) new ErrorHandler("BKG06012",new String[]{scNo}).getUserMessage();
						return message;
					}
				//Criteria가 Route일 경우	
				}else*/ if (dpcsEmlStndGrpTpCd.equals("R")){
					String polCd = vo.getPolCd();
					//POL BY 가 Location일 경우
					if (polDpcsEmlLocGrpTpCd.equals("LO")){
						//Location 체크
						if(polCd != null && polCd.length() > 0){
							if(command.searchLocationCode(polCd) == null){
								message =(String) new ErrorHandler("BKG00065",new String[]{polCd}).getUserMessage();
								return message;
							}	
						}else{
							message =(String) new ErrorHandler("BKG00065").getUserMessage();
							return message;
						}
					}else if (polDpcsEmlLocGrpTpCd.equals("CN")){
						//Country 체크
						if(polCd != null && polCd.length() > 0){
							if(JSPUtil.getNull(command.searchCountryName(polCd),"N").equals("N")){
								message =(String) new ErrorHandler("BKG00464",new String[]{polCd}).getUserMessage();
								return message;
							}
						}else{
							message =(String) new ErrorHandler("BKG00464").getUserMessage();
							return message;
						}
					}else if (polDpcsEmlLocGrpTpCd.equals("CO")){
						//Continent 체크
						if(polCd != null && polCd.length() > 0){
							if(command.searchContinentCode(polCd) == null){
								message =(String) new ErrorHandler("BKG00065",new String[]{polCd}).getUserMessage();
								return message;
							}
						}else{
							message =(String) new ErrorHandler("BKG00065").getUserMessage();
							return message;
						}
					}	
					
					String delCd = vo.getDelCd();
					//POL BY 가 Location일 경우
					if (delDpcsEmlLocGrpTpCd.equals("LO")){
						//Location 체크
						if(delCd != null && delCd.length() > 0){
							if(command.searchLocationCode(delCd) == null){
								message =(String) new ErrorHandler("BKG00066",new String[]{delCd}).getUserMessage();
								return message;
							}	
						}else{
							message =(String) new ErrorHandler("BKG00066").getUserMessage();
							return message;
						}
					}else if (delDpcsEmlLocGrpTpCd.equals("CN")){
						//Country 체크
						if(delCd != null && delCd.length() > 0){
							if(command.searchCountryName(delCd).equals("N")){
								message =(String) new ErrorHandler("BKG00464",new String[]{delCd}).getUserMessage();
								return message;
							}
						}else{
							message =(String) new ErrorHandler("BKG00464").getUserMessage();
							return message;
						}
					}else if (delDpcsEmlLocGrpTpCd.equals("CO")){
						//Continent 체크
						if(delCd != null && delCd.length() > 0){
							if(command.searchContinentCode(delCd) == null){
								message =(String) new ErrorHandler("BKG00065",new String[]{delCd}).getUserMessage();
								return message;
							}
						}else{
							message =(String) new ErrorHandler("BKG00065").getUserMessage();
							return message;
						}
					}	
				}
			}
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return message;
	}
	
	/**
     * 조회 이벤트 처리<br>
     * ESM_BKG_0446 : Queue List Set Serarch정보를 조회한다.<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchQueueListSearchSet(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
	        PerformanceReportBC command = new PerformanceReportBCImpl();
	        BookingUtil comboUtil = new BookingUtil();
	        
	        EBookingReceiptBC comboMdmUtil = new EBookingReceiptBCImpl();
			// DOCType - bkg_cust_tp_cd - CD02140
			List<BkgComboVO> bkg_cust_tp_cd  = comboUtil.searchCombo("CD02140");
			eventResponse.setRsVoList(bkg_cust_tp_cd);
	
			// Delivery - conti_cd - CD00191
			List<BkgComboVO> conti_cd  = comboMdmUtil.searchComboMdmConti();
			eventResponse.setRsVoList(conti_cd);
	
			eventResponse.setRsVoList(command.searchQueueListSearchSetList(account.getUsr_id()));
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
     * 입력/수정/삭제 이벤트 처리<br>
	 * ESM_BKG_0446 : Queue List Set Serarch정보를 입력/수정/삭제한다.<br>
     * 
     * @param e Event
     * @return response EventResponse 
     * @exception EventException
     */
    private EventResponse manageQueueListSearchSet(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        UserSetupMgtBC command = new UserSetupMgtBCImpl();
        EsmBkg0446Event event = (EsmBkg0446Event) e;
        try {
            begin();
            command.manageUserXterSearchSet(event.getBkgXterSrchSetVOS(), account);
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
     * ESM_BKG_0445 : DPCS SPLIT List 정보를 조회한다.<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchDpcsSiSplitCandidate(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0445Event event = (EsmBkg0445Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		List<DpcsSiSplitBkgCntrHisVO> list = null;
		List<DpcsSiSplitCandidateVO> list2 = null;
        try {        	
        	event.getDpcsSiSplitCandidateVO().setSearchType("ORIGIN");
    		list = command.searchDpcsSiSplitCntrHis(event.getDpcsSiSplitBkgCntrHisVO());
    		
    		event.getDpcsSiSplitCandidateVO().setSearchType("SPLIT");
//    		event.getDpcsSiSplitCandidateVO().setSplitStsCd(list.get(0).getSplitStsCd());
    		list2 = command.searchDpcsSiSplitCandidate(event.getDpcsSiSplitCandidateVO());
    		eventResponse.setRsVoList(list);
    		eventResponse.setRsVoList(list2);
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
     * 입력/수정/삭제 이벤트 처리<br>
	 * ESM_BKG_0445 : Cancel Split Candidate.<br>
     * 
     * @param e Event
     * @return response EventResponse 
     * @exception EventException
     */
    private EventResponse modifyXterBkgNoBySplitStsCd(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EBookingReceiptBC command = new EBookingReceiptBCImpl();
        EsmBkg0445Event event = (EsmBkg0445Event) e;
        
        DpcsSiSplitCandidateVO[] vos = event.getDpcsSiSplitCandidateVOS();
        SplitBlInfoVO splitBlInfoVO = new SplitBlInfoVO();
        try {
            begin();
            int size = vos.length;
            for (int i = 0; i < size; i++) {
				if (vos[i].getIbflag().equals("U")
						&& (vos[i].getSplitStsCd().equals("S") || vos[i].getSplitStsCd().equals("F"))
						) {
					splitBlInfoVO.setXterSndrId(vos[i].getXterSndrId());
					splitBlInfoVO.setXterRqstNo(vos[i].getXterRqstNo());
					splitBlInfoVO.setXterRqstSeq(vos[i].getXterRqstSeq());
					
					command.modifyXterBkgNoBySplitStsCd(splitBlInfoVO, account);
				}
			}
            
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
     * ESM_BKG_0449 : DPCS SPLIT Container Compare Result List 정보를 조회한다.<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchDpcsSiSplitBkgCntrCompareResult(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0449Event event = (EsmBkg0449Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		List<DpcsSiSplitBkgCntrCompareResultVO> list = null;
		List<DpcsSiSplitBkgCntrCompareResultVO> list2 = null;
        try {
        	DpcsSiSplitBkgCntrCompareResultVO[] vos = event.getDpcsSiSplitBkgCntrCompareResultVOS();
        	String cntrList = "";
        	for (int i = 0; i < vos.length; i++) {
				if (vos[i].getIbflag().equals("U")) {
					cntrList =  cntrList + vos[i].getOrigin() +"￠"+ vos[i].getBkgNo() +"￠"+ vos[i].getXterSndrId()+"￠"+ vos[i].getXterRqstNo()+"￠"+ vos[i].getXterRqstSeq();
					cntrList =  cntrList +"￠"+ vos[i].getCntrDesc()+SP;
				}
			}
        	event.getDpcsSiSplitBkgCntrCompareResultVO().setSearchType("LIST");
        	event.getDpcsSiSplitBkgCntrCompareResultVO().setCntrList(cntrList);
    		list = command.searchDpcsSiSplitBkgCntrCompareResult(event.getDpcsSiSplitBkgCntrCompareResultVO());
    		event.getDpcsSiSplitBkgCntrCompareResultVO().setSearchType("SUM");
    		list2 = command.searchDpcsSiSplitBkgCntrCompareResult(event.getDpcsSiSplitBkgCntrCompareResultVO());
    		
    		eventResponse.setRsVoList(list);
    		eventResponse.setRsVoList(list2);
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
	 * ESM_BKG_0422 : 0422에서 Detail 부분 Open시에 Validation 부분
	 * Seanaccs Validation 정보 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	/*
	private EventResponse searchXterRqstValidation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		XterRqstValidationVO xterRqstValidationVO = null;
		
		try {
			EsmBkg0422Event event = (EsmBkg0422Event)e;

			EBookingReceiptBC command = new EBookingReceiptBCImpl();

			ExternalRqstListInputVO externalRqstListInputVO = new ExternalRqstListInputVO();
			
			externalRqstListInputVO.setXterRqstNo(event.getInfoVO().getXterRqstNo());
			externalRqstListInputVO.setXterRqstSeq(event.getInfoVO().getXterRqstSeq());
			externalRqstListInputVO.setXterSndrId(event.getInfoVO().getXterSndrId());

			xterRqstValidationVO = command.searchXterRqstValidation(externalRqstListInputVO);

			if("Y".equals(xterRqstValidationVO.getXterCreFlag())){
				eventResponse.setETCData("xterCreFlag", "Y");
			} else {
				eventResponse.setETCData("xterCreFlag", "N");
			}
			if("Y".equals(xterRqstValidationVO.getXterSrFlag())){
				eventResponse.setETCData("xterSrFlag", "Y");
			} else {
				eventResponse.setETCData("xterSrFlag", "N");
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	*/

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0423 : Queue Summary 정보를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchQueueSummary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0423Event event = (EsmBkg0423Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		// Queue Summary - Status by S/I Event
		List<DocQueueSummaryStatusVO> list1 = command.searchQueueSummaryStatus(event.getSearchQueueSummaryInVO());
		eventResponse.setRsVoList(list1);
		// Queue Summary - By SR Kind
		List<DocQueueSummarySRKindVO> list2 = command.searchQueueSummarySRKind(event.getSearchQueueSummaryInVO());
		eventResponse.setRsVoList(list2);
		// Queue Summary - Just in Time(JIT) Completence
		List<DocQueueSummaryJITCompletenceVO> list3 = command.searchQueueSummaryJITCompletence(event.getSearchQueueSummaryInVO());
		eventResponse.setRsVoList(list3);
		// Queue Summary - By Urgency
		List<DocQueueSummaryUrgencyVO> list4 = command.searchQueueSummaryUrgency(event.getSearchQueueSummaryInVO());
		eventResponse.setRsVoList(list4);
		// Queue Summary - By Return Feedback Status
		List<DocQueueSummaryReturnFeedbackVO> list5 = command.searchQueueSummaryReturnFeedback(event.getSearchQueueSummaryInVO());
		eventResponse.setRsVoList(list5);
		// Queue Summary - Aging Status(P.F)
		List<DocQueueSummaryAgingVO> list6 = command.searchQueueSummaryAging(event.getSearchQueueSummaryInVO());
		eventResponse.setRsVoList(list6);

		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0415 : Report By Inputter User Group List를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchReportByInputterUserGroupList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0415Event event = (EsmBkg0415Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		List<SearchReportByInputterUserGroupListVO> list = command.searchReportByInputterUserGroupList(event.getSearchPerfVolByRegionGroupInVO());
		 
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0415 : Report By Inputter User Group Detail List를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchReportByInputterUserGroupDtlList(Event e) throws EventException {
		EsmBkg0415Event event = (EsmBkg0415Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
//		List<SearchDPCSVolListOutVO> list = command.searchDPCSVolList(event.getInfoVO());
		List<SearchPerfVolByRegionGroupDtlListVO> list = command.searchReportByInputterUserGroupDtlList(event.getSearchPerfVolByRegionGroupInVO());
		 
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	
	/**
     * ESM_BKG_0415 : 화면에 대한 콤보리스트 조회.<br>
     *  B/L Perf. by Volume-II (by User ID)e<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchComCode0415(Event e) throws EventException {
		BookingUtil util = new BookingUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		//Region
		List<BkgComboVO> list =  util.searchCombo("CD02405");
	    eventResponse.setRsVoList(list);
	    
	    list =  util.searchCombo("CD03248");
	    eventResponse.setRsVoList(list);
	     
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0415 : Report By Rater User Group List를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchReportByRaterUserGroupList(Event e) throws EventException {
		EsmBkg0415Event event = (EsmBkg0415Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<SearchReportByRaterUserGroupListVO> list = command.searchReportByRaterUserGroupList(event.getSearchPerfVolByRegionGroupInVO());
		 
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0415 : Report By Qa User Group List를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchReportByQaUserGroupList(Event e) throws EventException {
		EsmBkg0415Event event = (EsmBkg0415Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		List<SearchReportByInputterUserGroupListVO> list = command.searchReportByInputterUserGroupList(event.getSearchPerfVolByRegionGroupInVO());
		 
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0432 : B/L Perform Volume By Region Group List를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBlPerfVolByRegionGroupList(Event e) throws EventException {
		EsmBkg0432Event event = (EsmBkg0432Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
//		List<SearchDPCSVolListOutVO> list = command.searchDPCSVolList(event.getInfoVO());
		List<SearchPerfVolByRegionGroupListVO> list = command.searchBlPerfVolByRegionGroupList(event.getSearchPerfVolByRegionGroupInVO());
		 
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0432 : B/L Perform Volume By Region Group Detail List를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBlPerfVolByRegionGroupDtlList(Event e) throws EventException {
		EsmBkg0432Event event = (EsmBkg0432Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
//		List<SearchDPCSVolListOutVO> list = command.searchDPCSVolList(event.getInfoVO());
		List<SearchPerfVolByRegionGroupDtlListVO> list = command.searchBlPerfVolByRegionGroupDtlList(event.getSearchPerfVolByRegionGroupInVO());
		 
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * ESM_BKG_0412 : DPCS Weight Value를 수정합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse modifyDpcsWeightValue(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0412Event event = (EsmBkg0412Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		try{
			begin();
			command.modifyDpcsWeightValue(event.getBkgDpcsDocWeightVOs(), account.getUsr_id());
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
	 * ESM_BKG_0415 : DPCS Point List를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchDPCSPointList(Event e) throws EventException {
		EsmBkg0412Event event = (EsmBkg0412Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
//		List<SearchDPCSVolListOutVO> list = command.searchDPCSVolList(event.getInfoVO());
		List<BkgDpcsDocWeightVO> list = command.searchDPCSPointList(event.getBkgDpcsDocWeightVO());
		
		eventResponse.setRsVoList(list);
		return eventResponse;		
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0415 : Combo에 쓰일 공통코드를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchComCode0412(Event e) throws EventException {
		try{
//			PerformanceReportBCImpl command = new PerformanceReportBCImpl();
			BookingUtil comboUtil = new BookingUtil();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
//			String rtnOfcCd = command.searchBkgReceiptType(account.getUsr_id());
//			eventResponse.setCustomData("rtn_ofc_cd", rtnOfcCd);
	
			// bkg_status
			List<BkgComboVO> doc_group = comboUtil.searchCombo("CD02100");
			doc_group.remove(doc_group.size()-1);
			doc_group.remove(0);
//			bkg_sts_cd.remove(bkg_sts_cd.size()-1);

			List<BkgComboVO> srKind = comboUtil.searchCombo("CD01581");
			List<BkgComboVO> sr_kind = new ArrayList<BkgComboVO>();
			for(int i=0;i<srKind.size();i++){
				if("F".equals(srKind.get(i).getVal())||"E".equals(srKind.get(i).getVal())||"M".equals(srKind.get(i).getVal())){
					sr_kind.add(srKind.get(i));
				}
			}			
			List<BkgComboVO> src   = comboUtil.searchCombo("CD01577");

			eventResponse.setCustomData("doc_group", doc_group);
			eventResponse.setCustomData("sr_kind", sr_kind);
			eventResponse.setCustomData("src", src);
	
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
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0432 : 화면 Loading시 setting되는 초기 데이터를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse search0432InitData(Event e) throws EventException {
	    GeneralEventResponse eventResponse = new GeneralEventResponse();
	    BookingUtil command = new BookingUtil();
     
	    //Region
	    List<BkgComboVO> list = command.searchCombo("CD02405");
	    eventResponse.setRsVoList(list);
	    //doc office
	    list = command.searchCombo("CD03248");
	    eventResponse.setRsVoList(list);     
//     
//      //S/R KIND
//      list = command.searchCombo("CD01577");
//      eventResponse.setRsVoList(list);
//      //Performance by Queue
//      list = command.searchCombo("CD02100");
//      eventResponse.setRsVoList(list);

	    return eventResponse;
	}

    /**
	 * ESM_BKG_1123 : 화면 콤보 로딩시 TRO STATUS LIST조회<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEurTroStatusList(Event e) throws EventException {	
		EsmBkg1123Event event = (EsmBkg1123Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<TroEurStatusListInVO> list = command.searchEurTroStatusList(event.getTroEurStatusListInVO());		
		eventResponse.setRsVoList(list);
		
		return eventResponse;	
	}	
	
	/**
     * ESM_BKG_1123 : 화면에 대한 콤보리스트 조회.<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchComCode1123(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
    	//BKG Status
        List<BkgComboVO> list = command.searchCombo("CD00769");
        eventResponse.setRsVoList(list);
        
        //Zone
        List<BkgComboVO> list2 = command.searchCombo("CD00206");
        eventResponse.setRsVoList(list2);
        
        return eventResponse;
    }
	
	/**
	 * 조회 이벤트 처리<br>
	 * 1140 Correction Change를 위한 해당 그룹 USER 정보를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchDPSCCngUserGroup(Event e) throws EventException {
    	EsmBkg1140Event event = (EsmBkg1140Event)e;
    	PerformanceReportBC command = new PerformanceReportBCImpl();
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<BkgCorrCngDpcsUsrVO> list = command.searchDPSCCngUserGroup(event.getBkgCorrCngDpcsUsrVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
    
	/**
	 * 1140 Correction Change - PIC CHANGE(0421화면) 버튼 클릭시 관련 데이블 데이타를 수정합니다.<br>	
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse modifyDocsCngUserGroupCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1140Event event = (EsmBkg1140Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		try{
			BkgCorrCngDpcsUsrVO bkgCorrCngDpcsUsrVO = event.getInfoVO();
			DocQueueDetailListVO docQueueDetailListVO = event.getDocQueueDetailListVO();
			begin();
			command.modifyDocsUserCngGroupCd(bkgCorrCngDpcsUsrVO, docQueueDetailListVO, account);
			commit();
			eventResponse.setETCData("success_yn"      ,  "Y");
		}catch(EventException ex){
			eventResponse.setETCData("success_yn"      ,  "N");
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}    
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0435 : SI Turn Time Report - Summary 결과를 조회한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
    private EventResponse searchSiTurnTimeSummary(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0435Event event = (EsmBkg0435Event) e;
        
        /*String srMtchStsCd 	= event.getSrMtchStsCd();
        String fromDt		= event.getFromDt();
        String toDt			= event.getToDt();
        String rcvOfcCd		= event.getRcvOfcCd();*/
        
        PerformanceReportBC command = new PerformanceReportBCImpl();
        //String fromDt, String toDt, String srMtchStsCd, String rcvOfcCd,String srNo
        List<SiTurnTimeSummaryVO> list = command.searchSiTurnTimeSummary(event.getSiTurnTimeVO());
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        eventResponse.setRsVoList(list);
        
        return eventResponse;
    }   
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0435 : SI Turn Time Report - Detail 결과를 조회한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
    private EventResponse searchSiTurnTimeDetail(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0435Event event = (EsmBkg0435Event) e;
        
        /*String srMtchStsCd 	= event.getSrMtchStsCd();
        String fromDt		= event.getFromDt();
        String toDt			= event.getToDt();
        String rcvOfcCd		= event.getRcvOfcCd();*/
        
        PerformanceReportBC command = new PerformanceReportBCImpl();
        //String fromDt, String toDt, String srMtchStsCd, String rcvOfcCd,String srNo
        List<SiTurnTimeDetailVO> list = command.searchSiTurnTimeDetail(event.getSiTurnTimeVO());
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        eventResponse.setRsVoList(list);
        
        return eventResponse;
    }
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0435 : SI Turn Time Report - Detail SS 결과를 조회한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
    private EventResponse searchSiTurnTimeDetailSs(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0435Event event = (EsmBkg0435Event) e;
        
        /*String srMtchStsCd 	= event.getSrMtchStsCd();
        String fromDt		= event.getFromDt();
        String toDt			= event.getToDt();
        String rcvOfcCd		= event.getRcvOfcCd();*/
        
        PerformanceReportBC command = new PerformanceReportBCImpl();
        //String fromDt, String toDt, String srMtchStsCd, String rcvOfcCd,String srNo
        List<SiTurnTimeDetailVO> list = command.searchSiTurnTimeDetailSs(event.getSiTurnTimeVO());
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        eventResponse.setRsVoList(list);
        
        return eventResponse;
    }

	/**
	 * ESM_BKG_0068 : 화면에 대한 콤보리스트 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo0435(Event e) throws EventException {
		BookingUtil command = new BookingUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//Doc Part
		List<BkgComboVO> list = command.searchCombo("CD02405");
		eventResponse.setRsVoList(list);
		//SI Type
		list = command.searchCombo("CD01577");
		eventResponse.setRsVoList(list);
		//Doc Office
		list = command.searchCombo("CD03248");
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * ESM_BKG_0463 : 화면에 대한 콤보리스트 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo0463(Event e) throws EventException {
		BookingUtil command = new BookingUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//Doc Part
		List<BkgComboVO> list = command.searchCombo("CD02405");
		eventResponse.setRsVoList(list);
		//SI Type
		list = command.searchCombo("CD01577");
		eventResponse.setRsVoList(list);

		BkgComboVO combovo = new BkgComboVO();
        combovo.setVal(" ");
		combovo.setDesc("All");
		combovo.setName("All");
		
		//Yes/No/All
		list = command.searchCombo("CD00912");
		list.add(0,combovo);
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0463 : Queue Status Report - Region별 결과를 조회한다.<br>
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchQueueStatusByRegion(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0463Event event = (EsmBkg0463Event) e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		try{
			List<QueueStatusVO> list = command.searchQueueStatusByRegion(event.getQueueStatusVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0463 : Queue Status Report - Office별 결과를 조회한다.<br>
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchQueueStatusByOffice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0463Event event = (EsmBkg0463Event) e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		try{
			List<QueueStatusVO> list = command.searchQueueStatusByOffice(event.getQueueStatusVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0463 : Queue Status Report - 상세목록을 조회한다.<br>
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchQueueStatusDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0463Event event = (EsmBkg0463Event) e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		try{
			List<QueueStatusDetailVO> list = command.searchQueueStatusDetail(event.getQueueStatusVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0464 : Production Ratio - RHQ별 결과를 조회한다.<br>
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchProductionRatioByRegion(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0464Event event = (EsmBkg0464Event) e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		try{
			List<ProductionRatioVO> list = command.searchProductionRatioByRegion(event.getProductionRatioVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0464 : Production Ratio - Office별 결과를 조회한다.<br>
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchProductionRatioByOffice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0464Event event = (EsmBkg0464Event) e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		try{
			List<ProductionRatioVO> list = command.searchProductionRatioByOffice(event.getProductionRatioVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0464 : Production Ratio - 상세목록을 조회한다.<br>
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchProductionRatioDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0464Event event = (EsmBkg0464Event) e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		
		try{
			List<ProductionRatioDetailVO> list = command.searchProductionRatioDetail(event.getProductionRatioVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0436 : Doc. user 를 조회한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDPCSUser(Event e)  throws EventException  {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0436Event event = (EsmBkg0436Event)e;
    	PerformanceReportBC command = null;
    	String usrId = null;
    	String dpcsWrkGrpCd = null;
    	String rgnOfcCd = null;
		List<BkgDpcsUsrGrpVO> list = null;
		try {
	    	command = new PerformanceReportBCImpl();
	    	usrId = event.getUsrId();
	    	dpcsWrkGrpCd = event.getDpcsWrkGrpCd(); 
	    	rgnOfcCd = event.getRgnOfcCd();
			list = command.searchDPCSUser(usrId,dpcsWrkGrpCd,rgnOfcCd, event.getBkgDpcsUsrGrpVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
     * 조회 이벤트 처리<br> 
     * 0436화면에 대한 콤보리스트 조회.<br>
     * 
     * @param 		Event e 
     * @return		EventResponse
     * @exception 	EventException
     */
    private EventResponse searchComCode0436(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        List<BkgComboVO> list = null;
        List<BkgComboVO> list2 = null;
        List<BkgComboVO> list3 = null;
        List<BkgComboVO> list4 = null;
        try {
            command = new BookingUtil();
            list = command.searchCombo("CD01602");
            eventResponse.setRsVoList(list);
            list2 = command.searchCombo("CD01603");
            eventResponse.setRsVoList(list2);
            list3 = command.searchCombo("CD02569");
            eventResponse.setRsVoList(list3);
            list4 = command.searchCombo("CD02405");
            eventResponse.setRsVoList(list4);
        } catch(EventException ex) {
            throw ex;
	    } catch (Exception ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_1143 : C/M Data Cross-Check List (Master BL/Houser BL)를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCrossCheckList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1143Event event = (EsmBkg1143Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		List<BkgCroChkListByBLVO> list = command.searchCrossCheckList(event.getBkgCroChkListinVO());
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	}  
	
	
    /**
	 * ESM_BKG_0235 : Search <br>
	 * e-Booking & S/I by Email 실적 조회 기능<br>
	 * 
	 * @param  Event e
	 * @param  boolean detail
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEBkgSiPfmcListByEmail(Event e, boolean detail) throws EventException {	
		EsmBkg0235Event event = (EsmBkg0235Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<EBkgSiPfmcInVO> list = null;

		/*서버 ID*/
		if (!detail) {
			event.getEBkgSiPfmcInVO().setSvrId(account.getCnt_cd());
		}	
		
		/*1.BookingOffice Report*/
		list = command.searchEBkgSiPfmcListByEmail(event.getEBkgSiPfmcInVO(),detail);		
		eventResponse.setRsVoList(list);
		
		return eventResponse;	
	}	

    /**
	 * ESM_BKG_0235 : Search <br>
	 * e-Booking & S/I by Email 실적 엑셀 다운로드 기능<br>
	 * 
	 * @param  Event e
	 * @param  boolean detail
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEBkgSiPfmcListByEmailForExcelDown(Event e) throws EventException {	
		EsmBkg0235Event event = (EsmBkg0235Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			/*1.BookingOffice Report*/
			eventResponse.setRs(command.searchEBkgSiPfmcListByEmailForExcelDown(event.getEBkgSiPfmcInVO()));
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;	
	}
	
    /**
     * 해당 BKG이 Front Office Type으로 접수된 적이 있는지 조회한다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchFrontOfficeFlag(Event e) throws EventException {		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0422Event event = (EsmBkg0422Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		String foFlg = "";
		
		foFlg = command.searchFrontOfficeFlag(event.getBkgNo());
		if( null != foFlg){
			eventResponse.setETCData("fo_flg",foFlg);
		}

		return eventResponse;		
	}
	
    /**
     * 해당 BKG이 Front Office Type으로 접수된 적이 있는지 조회한다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchSZPBBFrontOfficeFlag(Event e) throws EventException {		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0438Event event = (EsmBkg0438Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		String foFlg = "";
		
		foFlg = command.searchFrontOfficeFlag(event.getBkgNo());
		if( null != foFlg){
			eventResponse.setETCData("fo_flg",foFlg);
		}

		return eventResponse;		
	}
	
	/**
	 * GSO에 속한 Sub Office 를 조회
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchGsoOfcList(Event e) throws EventException {		
		EsmBkg1156Event event = (EsmBkg1156Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<BlStsReportOutVO> list = null;
		
		list = command.searchGsoOfcList(event.getGso());		
		eventResponse.setRsVoList(list);
		
		return eventResponse;	
	}	
	
	
	/**
	 * ESM_BKG_0622 :  search<br>
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchOutBdMovementStsNtcList(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0622Event event = (EsmBkg0622Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		/*1.Outbound Container Movement Status*/
		List<OutBdMvntStsNtcListInVO> list = command.searchOutBdMovementStsNtcList(event.getOutBdMvntStsNtcListInVO());
		eventResponse.setRsVoList(list);
		/*2.Outbound Container Movement Status Summary*/
		List<OutBdMvntStsNtcListSumVO> list2 = command.searchOutBdMovementStsNtcListSum(event.getOutBdMvntStsNtcListSumVO());
		eventResponse.setRsVoList(list2);

		
		return eventResponse;
	
	}
	
	/**
	 * ESM_BKG_0622 : Search <br>
	 * combobox정보들을 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo0622(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		BookingUtil command = new BookingUtil();
        BkgComboVO combovo = new BkgComboVO();
        combovo.setVal("");
		combovo.setDesc("All");
		combovo.setName("All");
		
		try{
			
			// 01. Combo 데이터 조회 (RTerm)
			List<BkgComboVO> rTerm  = command.searchCombo("CD00764");
			rTerm.add(0,combovo);
			eventResponse.setRsVoList(rTerm);
			// 02. Combo 데이터 조회 (DTerm)
			List<BkgComboVO> dTerm  = command.searchCombo("CD00765");
			dTerm.add(0,combovo);
			eventResponse.setRsVoList(dTerm);
			// 03. Combo 데이터 조회 (cgoTp)
			List<BkgComboVO> cgoTp = command.searchCombo("CD00748");
			eventResponse.setRsVoList(cgoTp);
			
		}catch(EventException ex){
			log.error("err" + ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err" + ex.toString(),ex);
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0622 : multi <br>
	 * 미반입 안내메일, SMS send
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse sendCntrListByEmail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0622Event event = (EsmBkg0622Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		List<BkgNtcHisVO> emlNtcHisVOs = new ArrayList<BkgNtcHisVO>();
		List<BkgNtcHisVO> smsShprNtcHisVOs = new ArrayList<BkgNtcHisVO>();
		List<BkgNtcHisVO> smsNtcHisVOs = new ArrayList<BkgNtcHisVO>();
		BkgNtcHisVO bkgNtcHisVO = null;
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();
		String oldBkgNo = ""; 
		try{
			OutBdMvntStsNtcListInVO[] outBdMvntStsNtcListIn1VOs = event.getOutBdMvntStsNtcListInVOS();		
			List<OutBdMvntStsNtcListInVO> outBdMvntStsNtcListInVOs = new ArrayList<OutBdMvntStsNtcListInVO>();
			
			begin();
			
				
			
			for(int j = 0; j < outBdMvntStsNtcListIn1VOs.length; j++){
				
				if(!outBdMvntStsNtcListIn1VOs[j].getDelFlg().equals("Y")){
					outBdMvntStsNtcListInVOs.add(outBdMvntStsNtcListIn1VOs[j]);	
				}
				
				for(int k = j; k < outBdMvntStsNtcListIn1VOs.length; k++){
					if(outBdMvntStsNtcListIn1VOs[j].getBkgNo().equals(outBdMvntStsNtcListIn1VOs[k].getBkgNo()) && j != k && !outBdMvntStsNtcListIn1VOs[k].getDelFlg().equals("Y")){
						outBdMvntStsNtcListInVOs.add(outBdMvntStsNtcListIn1VOs[k]);
						outBdMvntStsNtcListIn1VOs[k].setDelFlg("Y");
					}
				}
			}
			
			
			//SMS header 전송, 화주에게만 한 건만 전송
			for(int i=0; i<outBdMvntStsNtcListInVOs.size(); i++ ) {	
				
				if(outBdMvntStsNtcListInVOs.get(i).getShprNtcFlg().equals("Y") && !outBdMvntStsNtcListInVOs.get(i).getShprSmsSndFlg().equals("Y")){
					bkgNtcHisVO = command.sendShprCntrListBySms(outBdMvntStsNtcListInVOs.get(i), account);
					if(null != bkgNtcHisVO){
						smsShprNtcHisVOs.add(bkgNtcHisVO);
					}
					for(int j=0; j<outBdMvntStsNtcListInVOs.size(); j++){
						if(outBdMvntStsNtcListInVOs.get(i).getShprMphnNo().equals(outBdMvntStsNtcListInVOs.get(j).getShprMphnNo())){
							outBdMvntStsNtcListInVOs.get(j).setShprSmsSndFlg("Y");
						}
					}
					
				}
				
//				if(!oldBkgNo.equals(outBdMvntStsNtcListInVOs.get(i).getBkgNo())){
//					bkgNtcHisVO = command.sendCntrListByEmail(outBdMvntStsNtcListInVOs.get(i), account);
//					emlNtcHisVOs.add(bkgNtcHisVO);
//					bkgNtcHisVO = command.sendCntrListBySms(outBdMvntStsNtcListInVOs.get(i), account);
//					if(null != bkgNtcHisVO){
//						smsNtcHisVOs.add(bkgNtcHisVO);
//					}
//				}
//				oldBkgNo = outBdMvntStsNtcListInVOs.get(i).getBkgNo();
			}
			
			
			for(int i=0; i<outBdMvntStsNtcListInVOs.size(); i++ ) {	
				if(!oldBkgNo.equals(outBdMvntStsNtcListInVOs.get(i).getBkgNo())){
					bkgNtcHisVO = command.sendCntrListByEmail(outBdMvntStsNtcListInVOs.get(i), account);
					emlNtcHisVOs.add(bkgNtcHisVO);
					bkgNtcHisVO = command.sendCntrListBySms(outBdMvntStsNtcListInVOs.get(i), account);
					if(null != bkgNtcHisVO){
						smsNtcHisVOs.add(bkgNtcHisVO);
					}
				}
				oldBkgNo = outBdMvntStsNtcListInVOs.get(i).getBkgNo();
			}
			
//			for(int i=0; i<outBdMvntStsNtcListInVOs.length; i++ ) {	
//				if(!oldBkgNo.equals(outBdMvntStsNtcListInVOs[i].getBkgNo())){
//					bkgNtcHisVO = command.sendCntrListByEmail(outBdMvntStsNtcListInVOs[i], account);
//					emlNtcHisVOs.add(bkgNtcHisVO);
//					bkgNtcHisVO = command.sendCntrListBySms(outBdMvntStsNtcListInVOs[i], account);
//					if(null != bkgNtcHisVO){
//						smsNtcHisVOs.add(bkgNtcHisVO);
//					}
//				}
//				oldBkgNo = outBdMvntStsNtcListInVOs[i].getBkgNo();
//			}
			
			if (null!= smsShprNtcHisVOs && smsShprNtcHisVOs.size() > 0) {
				bkgHisCmd.createBkgNtcHis(smsShprNtcHisVOs, "ESM_BKG_0622");
			}
			if (null!= emlNtcHisVOs && emlNtcHisVOs.size() > 0) {
				bkgHisCmd.createBkgNtcHis(emlNtcHisVOs, "ESM_BKG_0622");
			}
			if (null!= smsNtcHisVOs && smsNtcHisVOs.size() > 0) {
				bkgHisCmd.createBkgNtcHis(smsNtcHisVOs, "ESM_BKG_0622");
			}
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
     * ESM_BKG_1081 : 화면에 대한 콤보리스트 조회.<br>
     * Autorating Accuracy monitoring Report 조회(ESM_BKG_1081)<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchComCode0236(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        BkgComboVO combovo = new BkgComboVO();
        combovo.setVal(" ");
		combovo.setDesc(" ");
		combovo.setName(" ");
		
        //Region
        List<BkgComboVO> list1 = command.searchRgnOfficeCd();
        list1.add(0,combovo);
        eventResponse.setRsVoList(list1);
        
        
        //CTRT CODE - CD02565
        List<BkgComboVO> list2 = command.searchCombo("CD02565");
        list2.add(0,combovo);
        eventResponse.setRsVoList(list2);
        
        
        //Customer - CD00880
        List<BkgComboVO> list3 = command.searchCombo("CD00880");
        list3.add(0,combovo);
        eventResponse.setRsVoList(list3);        
        
        //Customer - CD00880
        List<BkgComboVO> list4 = command.searchCombo("CD00880");
		combovo.setName("All");
        list4.add(0,combovo);
        eventResponse.setRsVoList(list4);    
        
        return eventResponse;
    }

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0236 : e-BKG & SI Turn Time Summary를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchEBkgSiTurnTimeSummary(Event e) throws EventException {
		EsmBkg0236Event event = (EsmBkg0236Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<EBkgSiTurnTimeOutVO> list = command.searchEBkgSiTurnTimeSummary(event.getEBkgSiTurnTimeInVO());
		 
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0236 : e-BKG & SI Turn Time Detail을 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchEBkgSiTurnTimeDetail(Event e) throws EventException {
		EsmBkg0236Event event = (EsmBkg0236Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<EBkgSiTurnTimeOutVO> list = command.searchEBkgSiTurnTimeDetail(event.getEBkgSiTurnTimeInVO(), event.getEBkgSiTurnTimeInVOs());
		 
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0236 : e-BKG & SI Upload Time Summary를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchEBkgSiUploadTimeSummary(Event e) throws EventException {
		EsmBkg0236Event event = (EsmBkg0236Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<EBkgSiTurnTimeOutVO> list = command.searchEBkgSiUploadTimeSummary(event.getEBkgSiTurnTimeInVO());
		 
		eventResponse.setRsVoList(list);
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0236 : e-BKG & SI Upload Time Detail을 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchEBkgSiUploadTimeDetail(Event e) throws EventException {
		EsmBkg0236Event event = (EsmBkg0236Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<EBkgSiTurnTimeOutVO> list = command.searchEBkgSiUploadTimeDetail(event.getEBkgSiTurnTimeInVO(), event.getEBkgSiTurnTimeInVOs());
		 
		eventResponse.setRsVoList(list);
		return eventResponse;
	}
	

    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_1170 : Surcharge Summary Report를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSurchageSummary(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1170Event event = (EsmBkg1170Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		List<SurchageSummaryInVO> list = command.searchSurchageSummary(event.getSurchageSummaryInVO());
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	}  	
	
    /**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_1175 : Surcharge Detail Report를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSurchageDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1175Event event = (EsmBkg1175Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		List<SurchageSummaryInVO> list = command.searchSurchageDetail(event.getSurchageSummaryInVO());
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	}  	
	
	/**
     * ESM_BKG_1170 : 화면에 대한 콤보리스트 조회.<br>
     * Surcharge Summary Report<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchComCode1170(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
        BkgComboVO combovo = new BkgComboVO();
        combovo.setVal(" ");
		combovo.setDesc("All");
		combovo.setName("All");
		
        //RHQ
        //Region
        List<BkgComboVO> list1 = command.searchRgnOfficeCd();
        //list1.add(0,combovo);
        eventResponse.setRsVoList(list1);

        return eventResponse;
    }
	
    /**
	 * ESM_BKG_0621 : 화면 콤보 로딩시 TRO STATUS LIST조회<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUsaTroStatusList(Event e) throws EventException {
	
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0621Event event = (EsmBkg0621Event)e;
		PerformanceReportBC command = new PerformanceReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		List<TroUsaStatusListInVO> list = command.searchTroUsaStatusList(event.getTroUsaStatusListInVO());
		
		eventResponse.setRsVoList(list);
		
		return eventResponse;
	
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0104 : Office로 Location Code를 조회합니다.<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocCdByOfcCd2(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0104Event event = (EsmBkg0104Event)e;
		BookingUtil command = new BookingUtil();
		DBRowSet dbRowset	= null;
		
		dbRowset = command.searchLocCdByOfcCd2(event.getOfcCd());
		eventResponse.setRsVo(dbRowset);
		
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0068 : 화면에 대한 콤보리스트 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo0621(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
       
		// PDTO(Data Transfer Object including Parameters)
		BookingUtil command = new BookingUtil();

		BkgComboVO combovo = new BkgComboVO();
		combovo.setDesc("All");
		combovo.setName("All");
				
		/*R/D R- OUTBOUND RECEIVED*/
		List<BkgComboVO> list = command.searchCombo("CD00764");
		list.add(0,combovo);
		eventResponse.setRsVoList(list);
		
		/*R/D D- INBOUND DELIVERY*/
		list = command.searchCombo("CD00765");
		list.add(0,combovo);
		eventResponse.setRsVoList(list);

		return eventResponse;
		
	}	
	
	/**
	 * ESM_BKG_1168 : VGM Closing Status Report<br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVgmCrossCheckList(Event e) throws EventException {
		
		EsmBkg1186Event event = (EsmBkg1186Event)e;
		StatusReportBC command = new StatusReportBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		List<VgmStatusReportVO> list = command.searchVgmCrossCheckList(event.getInfoVO());

		if(list.size() > 0){
			VgmStatusReportVO vo =  list.get(0);
			eventResponse.setETCData("total_bkg",      vo.getTotalBkg());
			eventResponse.setETCData("total_vgm_cnt", vo.getTotalVgmCnt());
			eventResponse.setETCData("total_cntr_cnt", vo.getTotalCntrCnt());
			eventResponse.setETCData("total_no_vgm_cnt", vo.getTotalNoVgmCnt());
			
		}
		eventResponse.setRsVoList(list);

		return eventResponse;				
	}	
	
	/**
	 * ESM_BKG_1186 : 화면에 대한 콤보리스트 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCombo1186(Event e) throws EventException {
		
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        
        BkgComboVO combovo = new BkgComboVO();
        combovo.setVal(" ");
		combovo.setDesc("");
		combovo.setName("");
		
        //RHQ
        //Region
        List<BkgComboVO> list1 = command.searchRgnOfficeCd();
        list1.add(0,combovo);
        eventResponse.setRsVoList(list1);

        return eventResponse;
		
	}	
}
