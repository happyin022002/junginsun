/*========================================================= 
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingConductSC.java
*@FileTitle : TRO(Transportation Request Order) for Inland Haulage
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 이남경
*@LastVersion : 1.0
* 2009.04.30 이남경
* 1.0 Creation 
* -----------------------------------------------------------
* History
* 2010.08.31 김영철 [CHM-201005377-01] PSA booking EDI - Booking Main에서 Save, Cancel 시에 PSA 전송
*                                    ( cancelBooking Call 할때 전송 )
*                                    PSA EDI 전송시에 Qty가 변경되면 Qty를 다시 생성하여 전송하도록 로직 보완.
* 2010.09.07 김영철 [CHM-201005693-01] Booking Fax/EDI - Yard Assign by CNTR 수정 요청 (PSA EDI 관련)
* 									 Booking Copy, Cancel 시에 자동전송되도록 수정요청.
* 2010.09.07 김영철 [CHM-201005690-01] Booking Combine 시 DG Application Status 유지 요청.
* 2010.10.12 김영철 [CHM-201006332-01] PSA AUTO EDI 수정 요청 (Special Cargo 정보 자동 전송 및 WARNING 메세지 추가)
* 2010.11.04 김영철 [] Booking Creation / Update / Cancel시, Vessel Operation 모듈의 Final CBF 생성 여부를 체크해서 경고 메시지
* 2010.11.05 김영철 [] Booking Cancel시, Vessel Operation 모듈의 Final CBF 생성 여부를 체크해서 경고 메시지가 나오지 않아 수정함.
* 2010.11.09 최도순 [CHM-201006977] Work with Bookings의 조회 옵션에 E/Q Type 추가
* 2010.11.11 이일민 [CHM-201005878-01] Split 01-Collection Office / Code자동 업데이트 관련 수정 요청 (Customer Code 변경 및 B/L Issue 화면 연동)
* 2010.11.15 이일민 [CHM-201006562-01] Booking Receipt Notice Fax & Email Service 수정 (DOC CCT 추가 및 EDI 기능)
* 2010.11.17 전성진 [CHM-201005932] PRD FlexHeight 및 TRO Split 처리관련 BKG 수정
* 2010.11.19 전성진 [CHM-201005932] TRO Split 처리관련 BKG 수정
* 2010.11.22 이일민 [CHM-201005878-01] Split 01-Collection Office / Code자동 업데이트 관련 수정 요청 (Customer Code 변경 및 B/L Issue 화면 연동) - 파라미터 추가
* 2010.11.30 김영철 [] R4J - 사용하지 않은 지역변수 삭제
* 2010.11.23 최도순 [CHM-201007206] Actual customer column 보완 및 M&D 화면에 자동 DISPLAY 요청
* 2011.01.13 이일민 [CHM-201006824] VVD 변경시 Loew's 에 customer 301 전송
* 2011.01.18 전성진 [] C/A Complete 시에 Transmod 공백처리하는 로직 주석처리 함
* 2011.02.23 이일민 [] EQR VL
* 2011.03.10 이일민 [] cop호출함수(modifyRailRcvCoffDt) 주석처리
* 2011.03.21 이일민 [CHM-201109384-01] Mis-Sales C/A 발생시 Sales Rep에 자동 경고 메세지 송부
* 2011.03.23 이일민 [CHM-201109384-01] Mis-Sales C/A 발생시 Sales Rep에 자동 경고 메세지 송부(메일 양식 수정)
//* 2011.04.01 김기종 [CHM-201109394-01] DPCS고도화일환으로 BPM호출
* 2011.04.06 이일민 [CHM-201109697] C/A 모드 상 Bkg Cancel History관리 보완
* 2011.05.11 이일민 [CHM-201110114] BKG Charge Screen 상 운임회수 점소 pre-paid office was auto-changed as booking office again
* 2011.05.27 이일민 [CHM-201110854-01] [ALPS] Drfat B/L (EDI) 전송 Time Out 수정
* 2011.05.31 이일민 [CHM-201110854-01] [ALPS] Drfat B/L (EDI) 전송 Time Out 수정
* 2011.05.31 채창호 [CHM-201110946-01] [ALPS] Hitchment BKG flag update 요청
* 2011.06.08 이일민 [CHM-201110982-01] e-SI & DPCS BKG Split & Combine 기능 구현 요청
* 2011.06.15 김영철 [CHM-201111434-01] 전체 VVD 및 Location, Yard 비교 (Pre/Trunk/Post 순서대로 점검)
* 2011.06.28 김영철 [] hitchment 인 경우에는 전체 VVD 및 Location, Yard 비교 제외
* 2011.07.14 김진승 [CHM-201111820] Split 03-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
* 2011.08.02 김봉균 [CHM-201112282-01] 중국 Solid Waste 관련 bkg commodity validation 추가
* 2011.10.14 정선용 [CHM-201113680-01] 남미 5개 국가(브라질, 에콰도르, 도미니카 공화국, 콜롬비아, 우루과이)  BDR이후 C/A issue 직전
* 2011.10.20 정선용 [CHM-201113441-01] BKG 화면의 C.OFC 및 C.REP SELECT POPUP 추가 요청
* 2011.10.27 윤태승 [CHM-201113981-01]ALPS > Booking Creation > TRO/O remarks 에 문구 삽입 요청드립니다.
* 2011.11.29 정선용 [CHM-201113753-01] Split 01-Korea CLL 전송 후 변동사항 발생 시 SMS 자동 발송 기능 개발 요청
* 2011.11.28 금병주 [CHM-201114706-01] [BKG_1139 :U/I제출] EUR TRO Notice 전송 Pop-up
* 2011.12.02 금병주 [CHM-201114805] [BKG] 구주 TRO M/H 상 CNTR 중복 confirm 에 대한 Validation 추가 요청
* 2011.12.19 정선용 [CHM-201115046-01]	선적변경시 웹메일 & SMS 서비스 개발 건 보완요청(2차)
* 2012.02.08 정선용 [CHM-201215883] 특수화물 승인란 Elapsed day란 오류 발생으로 로직 변경 요청
* 2012.03.05 전성진 [] SMS 전송 로직 일부 수정 - OLD VVD 변경시 Old yard 일치여부 확인으로 변경
* 2012.04.02 변종건 [CHM-201216424-01] ALPS Customer Advisory 기능 보완 검토 요청 (Template 문서 첨부 등)
* 2012.05.31 조정민 [CHM-201218064] [BKG]선적변경 건 SMS 수신 누락에 대한 시스템 보완요청(3차)
* 2012.06.21 조정민 [CHM-201218361] [BKG] [삼성전자] BOKCON 재전송 기능 검토 요청
* 2012.06.21 조정민 [CHM-201218492] [BKG] PRD Rail Receiving (Cut Off) Date 산출 Logic 변경 및 추가 요청 관련 타 모듈 수정 요청.
* 2012.06.25 전성진 [CHM-201217633] 구주 Hinterland Operation 개선 Project - T1&Revenue Guideline 적용
* 2012.06.27 전성진 [] PRD 호출 파라미터 표시 제거
* 2012.06.27 조정민 []주석 처리된 eq_tp_sz_cd 수정
* 2012.07.12 조정민 [CHM-201218715] [DG Cargo] Port "또는" Vssl operator - Prohibition/ restriction 존재시 재요청 처리
* 2012.08.03 이재위 [CHM-201218218] [BKG] Simple S/I Download 기능 강화를 위한 CUP, ALPS 변경 요청
* 2012.09.12 조정민 [CHM-201219535] [BKG] EUR TRO 화면 로직추가 (Optimum status 표기)
* 2012.09.18 조정민 [CHM-201219895] [BKG] Memo split 시 Manul/ Auto 관계없이 모든 charge copy 되지 않도록 logic 수정 요청
* 2012.09.17 김보배 [CHM-201220181] [BKG] ALPS Bkg/Doc Customer Advisory Send 기능 보완 요청 (30초룰 해제)
* 2012.09.25 조정민 [CHM-201219852] [BKG] MEMO BL Cancel건의 BKG Status변경 자동처리 (S->F Manual변경처리하는 현행 개선)
* 2012.10.04 조정민 [CHM-201220238] [BKG] [EUR TRO] ADD,Copy CNTR에 Optimum조회추가 & 금액읽어오는 로직 & 버튼색깔 보완
* 2012.10.17 조정민 [CHM-201220668] [BKG History 보완] Combine종류 - Hitchment Combine 명확하게 표기
* 2012.12.20 조정민 [CHM-201221841] Booking Confirmation F/File 발송 조건 추가
* 2013.02.19 김보배 [CHM-201322482] [BKG] 개발:Split 01-Customer Advisory 기능 추가 (BST Download)
* 2013.04.19 최문환 [CHM-201323915] Blacklisted Customer 사용 시 Alert 강화 요청
* 2014.01.01 문동선 [CHM-201328250] TRO/I 전송 시 Customer Information 수기입력 기능 추가
* 2014.01.14 문동선 [CHM-201328181] [BKG] Space allocation 연계 Waiting booking process 개발 Project
* 2014.04.15 문동선 [CHM-201429034] [하드코딩요청] POR & Full return CY 간 자동 매치 로직 제외 요청 (특정 조건에 한해)
* 2014.05.27 문동선 [CHM-201429314] 일본 세관 사전신고제를 위한 Simple/Console default 적용 로직 추가
* 2014.07.25 문동선 [CHM-201430707] FumigationHide liner 버튼 및 팝업창 구현, BST 조회 로직
* 2014.08.04 문동선 [CHM-201431223] Combine 에 의해 Booking Cancel 될 경우에도, Terminal EDI 전송 (Terminal 301) 로직 추가
* 2014.08.18 문동선 [CHM-201431490] Outbound B/L issue 화면에서 KR 화주 대상 DEM/DET OTS 보여주기 기능 요청
* 2014.08.29 문동선 [CHM-201431517] Pre-Caution 반영 Alert 메세지 생성 로직 삽입 요청
* 2014.09.29 문동선 [] OPF,SCG 수정 보완건
* 2014.10.30 문동선 [CHM-201431658] 한진해운 조기결산을 위한 개선 방안 중 BKG 관리 프로세스 단축(안) 개발 
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct;

import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBC;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.basic.ContainerMovementMgtBCImpl;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CrossItemVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CusCtmMovementVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBCImpl;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.basic.DropOffCreationBC;
import com.hanjin.apps.alps.ees.dod.doddropoff.dropoffcreation.basic.DropOffCreationBCImpl;
import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.basic.CntrMtyBkgCreateBC;
import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.basic.CntrMtyBkgCreateBCImpl;
import com.hanjin.apps.alps.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.vo.MtyBkgVO;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBC;
import com.hanjin.apps.alps.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBCImpl;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBC;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBCImpl;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBCImpl;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.UpdBkgForBkgCodVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.UpdBkgForVVDChgVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.event.EsmBkgUsaTmlEdiAckEvent;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryTableVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.TableListVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlckListMntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgCloseVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgRouteVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.MdmCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.OblIssVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdMainInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdParameterVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdQtyInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdTroInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.ProductCatalogPoupCheckVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic.EBookingReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic.EBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstMstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.basic.GeneralBookingListSearchBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.basic.GeneralBookingListSearchBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg0098Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg0102Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg0587Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg0614Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg0616Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg0702Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg1158Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.event.EsmBkg9425Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgCoffTmListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListFor301310EdiInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListFor301310EdiVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForBkgReceiptCntVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForBkgReceiptInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForBkgReceiptVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForCompFirmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForGeneralTmlEdiVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForTmlEdiInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForUsaTmlEdiVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForWorkWithBkgInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgListForWorkWithBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.BkgReceiptListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.EmptyBkgHangerListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo.EmptyBkgListInqVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg0077Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg0078Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg007901Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg007905Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg0079Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg0092Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg036701Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg0890Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg0957Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg1024Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.event.EsmBkg9424Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.AllocStsChgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.AllocStsVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgCmpbVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgForCopyVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgReactivateVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlDocCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingCopyVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingCreationVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingSaveValidationVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CargoDetailVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CargoDtlEtcVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CmdtVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CompleteCaVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CustEtcVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.N1stEtaDelEtaVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.OceanRouteVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.OldBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PartialBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PartialBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherMdtItmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PolPodVvdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.RefNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectCntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SelectSpclCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SmsRequirementResultVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitQtyVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VvdAssignVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0003Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0004Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0005Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0083Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0090Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0095Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0096Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0097Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0190Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0566Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0650Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0652Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0654Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0655Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0656Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0657Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0658Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0721Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0724Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0744Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0972Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg0998Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg1062Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg1069Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg1078Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg1132Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg1159Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg1182Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg1183Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg1507Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg9450Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg9454Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event.EsmBkg9455Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.AlocStandbyReasonVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgChgOfcVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcFileListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcRmkVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcSchVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcSndHisSchVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcSndHisVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgCustAvcNtcSndVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgInforForHistVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgReceiptSendVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ClzTmListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.CntrChkDigitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.CntrInfoForEmptyVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.CustomsHistVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.DocHistVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.EstimatedCMPBVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.HblCountVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.HistMainVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.HistUiNmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.LocationListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.MtyBkgTsRouteVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.NodeListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.NoticeHistVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.OfcRepListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.OftPrecheckVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.PrdConstraintVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.QtyInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoBkgForUpdateVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RfaCmdtListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RfaListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RollOvrInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RouteDtlInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RouteDtlVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RouteDtlVvdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ScCmdtListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ScListInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ScListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SearchActualCustomerVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SendBkgEdiVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SendBkgFaxEmailVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.SvcRouteModeVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TSRouteVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TaaCmdtListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.TaaListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.UsaCstmsFileListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Vender301ParamVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.basic.GeneralBookingSplitCombineBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.basic.GeneralBookingSplitCombineBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event.EsmBkg0076Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event.EsmBkg0099Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event.EsmBkg0709Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event.EsmBkg0710Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event.EsmBkg0715Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event.EsmBkg0716Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event.EsmBkg0732Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event.EsmBkg0974Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.event.EsmBkg1025Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.AkSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BbSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgBlForSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgForSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgListForCombineVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.BkgListForMstBkgSelectVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CntrListForCombineVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.DgSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.RfSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.TroSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.ValidateCombineVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.basic.TransferOrderIssueBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.basic.TransferOrderIssueBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg007902aEvent;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg007902bEvent;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg007902cEvent;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg0317Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg0703Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg0704Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg0905Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg0906Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg0907Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg0920Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg0921Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg1139Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration.TransferOrderIssueDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.AwkSeqVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgEurCntrListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgInfoForTroVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgTroActCustExtVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.BkgTroXterIfVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.CombineTroNewSeqVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.DgSeqVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurPayerVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroDtlVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroMstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.GlineRevOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.RfSeqVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroActCustDefaultVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroCfmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroDtlVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroListForCfmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMultiBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMultiCancelFrustVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgRfCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.RfCgoApplVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclCgoAproApplVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclReqInVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.basic.SpecialCargoRiderBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.basic.SpecialCargoRiderBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.BlRiderInVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.BlRiderOutVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.basic.BDRCorrectionBC;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.basic.BDRCorrectionBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.vo.CaRsnRmkVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.vo.CorrReplanVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.basic.CODCorrectionBC;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.basic.CODCorrectionBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.event.EsmBkg0997Event;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodEtcVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.event.EsmBkg2004Event;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCreCustInqVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgCreCustomerVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgHrdCdgDescVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgUserSmsListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBC;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DpcsWebBookingVO;
import com.hanjin.apps.alps.esm.bkg.common.Constants;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBC;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBCImpl;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FrtCltLstVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OblRdemVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.ArrivalNoticeBC;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.ArrivalNoticeBCImpl;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustCdValidationVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.RfaOftAutoRatingBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.RfaOftAutoRatingBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.ScOftAutoRatingBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.ScOftAutoRatingBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.SurchargeAutoRatingBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.SurchargeAutoRatingBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.TaaOftAutoRatingBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.TaaOftAutoRatingBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgChgRateVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgModiOfcPrcVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgRevCostVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgSurchargeRateVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.EmailPpdInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchFocByFreightListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchRfaOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchTaaOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ServiceScopeVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgBlActWgtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgCopyCntrCmByBkgVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmSelfMailVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CreateBkgBlDocBkgVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MndVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblEdiInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblEdiVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.basic.EmptyReleaseOrderBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.basic.EmptyReleaseOrderBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.SendMtyRlseOrdVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.basic.RevenueDebitNoteBC;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.basic.RevenueDebitNoteBCImpl;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.CstmBkgRevDrNoteVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.RevDrNoteVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.basic.UnmatchBLBC;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.basic.UnmatchBLBCImpl;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.UnmatchBLVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.basic.CLLCDLManifestBC;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.basic.CLLCDLManifestBCImpl;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CllCdlTransmitVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.cllcdlmanifest.vo.CntrListForImportDetailVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.basic.PSAManifestBC;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.basic.PSAManifestBCImpl;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgIfVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaBkgVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaYardCdVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfVslInfoVO;
import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBC;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.basic.WeeklyCMBC;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.basic.WeeklyCMBCImpl;
import com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo.SearchEMUPfmcListVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.basic.ConstraintMasterBC;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.basic.ConstraintMasterBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.basic.OwnContainerBookingForecastMgtBC;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.basic.OwnContainerBookingForecastMgtBCImpl;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic.OwnDangerousCargoApprovalBC;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic.OwnDangerousCargoApprovalBCImpl;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionInputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionOutputVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionPortVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo.PreRestrictionVesselOperatorVO;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.basic.PartnerLinesDangerousCargoApprovalBC;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.partnerlinesdangerouscargoapproval.basic.PartnerLinesDangerousCargoApprovalBCImpl;
import com.hanjin.framework.component.attachment.file.support.UpdateFileMetaInfo;
import com.hanjin.framework.component.attachment.file.upload.FileUpload;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.excel.ExcelParser;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.TemplateMail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.controller.util.WebKeys;
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
import com.hanjin.syscommon.common.table.BkgChnBkgNoGenVO;
import com.hanjin.syscommon.common.table.BkgClzTmVO;
import com.hanjin.syscommon.common.table.BkgCntcPsonVO;
import com.hanjin.syscommon.common.table.BkgContainerVO;
import com.hanjin.syscommon.common.table.BkgCorrectionVO;
import com.hanjin.syscommon.common.table.BkgCustomerVO;
import com.hanjin.syscommon.common.table.BkgDocProcSkdVO;
import com.hanjin.syscommon.common.table.BkgEurTroDgSeqVO;
import com.hanjin.syscommon.common.table.BkgEurTroVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.BkgQtyDtlVO;
import com.hanjin.syscommon.common.table.BkgQuantityVO;
import com.hanjin.syscommon.common.table.BkgReferenceVO;
import com.hanjin.syscommon.common.table.BkgRollOvrVO;
import com.hanjin.syscommon.common.table.BkgTroActCustVO;
import com.hanjin.syscommon.common.table.BkgTroActRepVO;
import com.hanjin.syscommon.common.table.BkgTroDtlVO;
import com.hanjin.syscommon.common.table.BkgTroSpclCgoSeqVO;
import com.hanjin.syscommon.common.table.BkgTroVO;
import com.hanjin.syscommon.common.table.BkgUsaCstmsFileNoVO;
import com.hanjin.syscommon.common.table.BkgUsrDfltSetVO;
import com.hanjin.syscommon.common.table.BkgVvdVO;
import com.hanjin.syscommon.common.table.MasBkgComIfVO;
import com.hanjin.syscommon.common.table.MdmCustomerVO;
import com.hanjin.syscommon.common.table.MdmSvcScpVO;
import com.hanjin.syscommon.common.table.MstContainerVO;
import com.hanjin.syscommon.common.table.ScgAproRqstVO;
import com.hanjin.syscommon.common.table.ScgVvdAproRqstVO;
import com.hanjin.syscommon.common.table.SpcSbBkgDtlVO;
import com.hanjin.syscommon.common.table.SpcSbBkgVO;

/**
 * ALPS-GeneralBookingConduct Business Logic ServiceCommand - ALPS-GeneralBookingConduct 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author Lee Nam Kyung
 * @see TransferOrderIssueDBDAO
 * @since J2EE 1.4 
 */
   
public class GeneralBookingConductSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
 
	/**
	 * GeneralBookingConduct system 업무 시나리오 선행작업<br>
	 * ESM_BKG_0079_02C업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();	
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * GeneralBookingConduct system 업무 시나리오 마감작업<br>
	 * ESM_BKG_0079_02C 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("GeneralBookingConductSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-GeneralBookingConduct system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException 
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
        if(e.getEventName().equalsIgnoreCase("EsmBkg0079Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBkgBlNoVO(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)
        			||e.getFormCommand().isCommand(FormCommand.DEFAULT)){
            	eventResponse = searchBkgCreTabByUser(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
            	eventResponse = completeCA(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)){
            	eventResponse = cancelCA(e);
            } else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)){
            	eventResponse = checkIbByCaIssue(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)){
            	eventResponse = searchBccSurcharge(e);
            } 
        } 
        else if (e.getEventName().equalsIgnoreCase("EsmBkg007902aEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTro(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageTro(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
                eventResponse = searchBkgSplitNo(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND09)) {
                eventResponse = searchSysDate(e);  //system date 조회용 
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = checkCopQty(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg007902bEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchKrTro(e);
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchTypeSizeByCntr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageKrTro(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = sendTroEdiToHJT(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
                eventResponse = searchBkgSplitNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = receiptHjtTroEdiAck(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND09)) {
                eventResponse = searchSysDate(e);  //system date 조회용 
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg007902cEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEurTro(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageEurTro(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
                eventResponse = sendTroNotice(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
                eventResponse = searchBkgSplitNo(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
                eventResponse = searchBkgCntrWgt(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0907Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEurTroCntrList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0905Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMdmCustForTro(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTroActCustByCust(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchActCustRep(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchTroActCustByEq(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchVndrName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchTroActCustDefault(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageTroActCust(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageTroActCust(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0704Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTroIfResultList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0703Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEurTroForCancelFrust(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = cancelFrustEurTro(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0921Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMultiBkg(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0920Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = copyTro(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0906Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEurTroListForCfm(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = confirmEurTro(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				EsmBkg0906Event event = (EsmBkg0906Event)e;
				event.getBkgBlNoVO().setCaFlg("N"); 
				interfaceToInv(event.getBkgBlNoVO(),account);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0566Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlHist(e);
				//eventResponse = searchHist(e);
			//} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				//eventResponse = searchBlHist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchNoticeHist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCustomsHist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchDocHist(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0650Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIbTsRoute(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0652Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBkgCreCustCntc(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = searchCustContact(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBkgCreCustCntc(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0972Event")) {
			//eventResponse = searchSvcRouteMode(e);
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSvcRouteMode(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0090Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchStowageCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = validateStwgCdbyCtrtNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkSCNoByStwgCd(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0998Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchConstraint(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0083Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNodeCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchLocationList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0097Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReferenceList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageReferenceNo(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg036701Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				//[SEARCH]  조회시 액션
				eventResponse = searchPoOtherNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				//[SEARCH02] Button: Copy from C/M  눌렀을때  액션 (DB에서 CM)
				eventResponse = searchCmForPo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				//[MULTI] Button: save  눌렀을때  액션
				eventResponse = managePoOtherNo(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0744Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNVOFileNumberList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageNVOFileNumber(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0587Event")) {
		    if(e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
	                eventResponse = searchClzStatus(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchBkgOfcListForBkgClz(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBkgCoffTm(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = closeBkgForBayPlan(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = reopenBkgForBayPlan(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchBkgCoffTmYd(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0102Event")) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchBkgListForCompFirm(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBkgListForCompFirm(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMdmCustName(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = compFirm(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = modifyAllocStatus(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0092Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTsRoute(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchLaneEtaEtd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = validateTsRoute(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg007901Event")) {
			//if (e.getFormCommand().isCommand(FormCommand.INIT)) {
			if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchUserBkgDefault(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchBooking(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
				eventResponse = validatePrecaution(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST14)){
				eventResponse = searchCustNm(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = createBkgWithoutRoute(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
				eventResponse = createBkgWithRoute(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI03)){
				eventResponse = modifyBkgWithoutRoute(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI04)){
				eventResponse = modifyBkgWithRoute(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
                eventResponse = searchBkgSplitNo (e);
			}else if(e.getFormCommand().isCommand(FormCommand.MODIFY04)) {
                eventResponse = changeBkgStatus (e);
			}else if(e.getFormCommand().isCommand(FormCommand.MODIFY05)) {
                eventResponse = changeBkgStatus (e);
			}else if(e.getFormCommand().isCommand(FormCommand.MODIFY06)) {
                eventResponse = cancelBooking (e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = checkIranBlackCustomer (e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND09)) {
				eventResponse = checkUsBlackCustomer (e);	
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = searchBkgChgOfc(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MODIFY07)) {
                eventResponse = modifyBkgChgOfc (e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND05)) { //2011.08.02 중국 Solid Waste 관련 bkg commodity validation 추가 
                eventResponse = validateChnWasteCmdt(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND06)) { //2011.08.17 VVD 변경시 사전신고 된 VVD가 변경된 경우 저장 Click시 warning 메시지 표시
				eventResponse = searchManifestTrans (e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND07)) { //2011.08.02 중국 Solid Waste 관련 bkg commodity validation 추가 
                eventResponse = validateUSVehicleCommodity(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND08)) { 
				eventResponse = searchPrntOfcCdBySRepCd (e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND10)) { 
				eventResponse = searchScAvailableCust(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND11)) { 
				eventResponse = createRevCost(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0658Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = validateLocation(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0721Event")) {
		    if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	            eventResponse = searchCargoClosingTime(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCargoClosingTime(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0709Event")) {
		    if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	            eventResponse = searchDgSplit (e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0710Event")) {
		    if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	            eventResponse = searchRfSplit (e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0715Event")) {
		    if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	            eventResponse = searchAkSplit (e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0716Event")) {
		    if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	            eventResponse = searchBbSplit (e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0099Event")) {
		    if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	            eventResponse = searchBkgForSplit (e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCbfFlag(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
	            eventResponse = searchBkgSplitNo (e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = splitBooking(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchSplitRoute(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
			    eventResponse = searchSplitTsRoute(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
                eventResponse = splitBookingLt(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
                eventResponse = splitBookingMulti(e);
            }
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg1025Event")) {
		    if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	            eventResponse = searchTroSplit (e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0190Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchActualCustomer(e);
			}	
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg9450Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEmptyCntrByBKG(e);
			}		
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0654Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchSvcScp(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchRfaList(e);
			}
		}		
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0655Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchScList(e);
			}		
		}		
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0656Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCmdtByRfa(e);
			}		
		}		
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0657Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCmdtBySc(e);
			}		
		}				
		else if (e.getEventName().equalsIgnoreCase("EsmBkg007905Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchBlDocCust(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
				eventResponse = searchMdmCustNm(e);			
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = modifyBlDocCust (e);	                
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = checkIranBlackCustomer (e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				eventResponse = checkEuBlackCustomer (e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND09)) {
				eventResponse = checkUsBlackCustomer (e);	
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = searchBkgChgOfc(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MODIFY07)) {
                eventResponse = modifyBkgChgOfc (e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchMdmPhnFaxEml(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchTSRoute(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchDocTp(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0957Event")) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createCustCodeRequestHistory(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0890Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchBkgQtyDtl(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = modifyBkgQtyDtl(e);			
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0732Event")) {
			if(e.getFormCommand().isCommand(FormCommand.DEFAULT) || e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchCntrListForCombine(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0974Event")) {
			if(e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = searchBkgListForMstBkgSelect(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0614Event")) {
			if(e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = searchComCode0614(e);
			}
//			else if(e.getFormCommand().isCommand(FormCommand.INIT)){
//				eventResponse = searchInitComCode0614(e);
//			}			
			else if(e.getFormCommand().isCommand(FormCommand.MODIFY01)){
				eventResponse = combineBooking(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchBkgListForWorkWithBkg(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0076Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchBkgListForCombine(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MODIFY01)){
				eventResponse = combineBooking(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MODIFY02)){
				eventResponse = cancelBookingMulti(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0997Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchCodSplit(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = splitCodBooking(e);
			}
			 
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg1024Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchPartialCntrBkg(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = modifyBkgRouteForPartialBkg(e);
			}			
		}		
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0077Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchBkgForCopy(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = copyBkgWithoutRoute(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
				eventResponse = copyBkgWithRoute(e);				
			}			
		}				
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0095Event")) {
			if(e.getFormCommand().isCommand(FormCommand.DEFAULT)||e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchBkgFaxEmailEdi(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = sendBkgFaxNotice(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
				eventResponse = sendBkgEmailNotice(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI03)){
				eventResponse = sendBkgEdi(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0098Event")) {
			if(e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = searchComCode0098(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchBkgListForBkgReceiptNtc(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = sendBkgReceiptByFax(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
				eventResponse = sendBkgReceiptByEmail(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI03)){
				eventResponse = sendBkgReceiptByGroupEmail(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0702Event")) {
			if(e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = searchComCode0702(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchBkgListFor301310Edi(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = sendBkgCustEdiMulti(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchSendBkgCustEdiMultiStatus(e);  //백엔드잡 상태 확인 조회
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = searchSendBkgCustEdiMulti(e);  //백엔드잡 결과 확인 조회
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = sendBkgTmlEdiMulti(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0616Event")) {
			if(e.getFormCommand().isCommand(FormCommand.DEFAULT)){
				eventResponse = searchComCode0616(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchBkgListForGeneralTmlEdi(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchBkgListForUsaTmlEdi(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageMyFwrdRefVvd(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = sendBkgTmlEdiMulti(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0724Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchRollOver(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageRollOver(e);
			}			
		}	
		else if (e.getEventName().equalsIgnoreCase("EsmBkg9424Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchEmptyBooking(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST11)){
				eventResponse = searchCntrChkDigit(e);
			}	
			else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST12)){
				eventResponse = searchMtyCntrList(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = modifyMtyRepoBkg(e);
			}
			else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
				eventResponse = cancelEmptyBkg(e);
				
			}						
		}	        
		else if (e.getEventName().equalsIgnoreCase("EsmBkg9454Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchEmptyBkgTsRoute(e);
			}
		}	 
		else if (e.getEventName().equalsIgnoreCase("EsmBkg9455Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchCntrByYard(e);
			}
		}	    
		else if (e.getEventName().equalsIgnoreCase("EsmBkg9425Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchEmptyBkgList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)){
				eventResponse = searchEmptyBkgHangerList(e);
			}
		}	 
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0096Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchYardAssign(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = validateYardAssign(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg1069Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRouteDetail(e);
			} 
		}else if (e.getEventName().equalsIgnoreCase("EsmBkgUsaTmlEdiAckEvent")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = receiptUsaTmlEdiAck(e);
			} 
		}        
		else if (e.getEventName().equalsIgnoreCase("EsmBkg1062Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchSvcScpByTaa(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchTaaList(e);
			}
		}		
		else if (e.getEventName().equalsIgnoreCase("EsmBkg1078Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCmdtByTaa(e);
			}		
		}		
		else if (e.getEventName().equalsIgnoreCase("EsmBkg1132Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCtrtRep(e);
			}		
		}	
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0003Event")) {
			if(e.getFormCommand().isCommand(FormCommand.INIT)) {				
				eventResponse = searchComCode0003(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustAdvisoryNoticeSendList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMdmCustNm(e); //cust name search
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCustAdvisoryNoticeList(e); // save
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = sendCustAdvisoryNoticeListByFax(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = sendCustAdvisoryNoticeListByMail(e); //email
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = createCustAdvisoryNoticeListByUpload(e); //upload 된 data 저장
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = backEndJobResult(e); //upload
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI05)) {
			    eventResponse = manageCustAdvisoryNoticeSendListForBST(e); //BST Download 된 data 저장
			} 
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0004Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) { //retrieve
				eventResponse = searchCustAdvisoryNoticeRemark(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){ //Office Code Validation
				eventResponse = searchExistOfcCd(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){ //File List
				eventResponse = searchCustAdvisoryFileList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){ //save
				eventResponse = manageCustAdvisoryNoticeRemark(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0005Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustAdvisoryNoticeSendHistory(e);
			}else	if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMdmCustNm(e); //cust name search
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg1139Event")){
			if(e.getFormCommand().isCommand(FormCommand.DEFAULT) || e.getFormCommand().isCommand(FormCommand.SEARCH) ){
				eventResponse = searchEurTroNotice(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0317Event")){
			if(e.getFormCommand().isCommand(FormCommand.SEARCH) ){
				eventResponse = searchGlineRev(e);
			}else	if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGlineRevChk(e); 
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg1158Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {// CodeValidation Result (UnMatch List)
                eventResponse = searchPreCheckForCodeAccuracyUnmatch(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {// CodeValidation Result (Match List)
                eventResponse = searchPreCheckForCodeAccuracyMatch(e);
            }
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg1159Event")) {
		    if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	            eventResponse = searchCustomerList (e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg1507Event")) {
		    if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	            eventResponse = searchAlocStandbyReason(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg1182Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBlRiderList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBlRider(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg1183Event")) {
			eventResponse = searchEstimatedCMPB(e);
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0078Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchBkgReactivate(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)){
				eventResponse = reactivateBooking(e);
			}
		}
		return eventResponse;
	}

	/**
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCtrtRep(Event e) throws EventException{
		try{
			EsmBkg1132Event event = (EsmBkg1132Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			List<OfcRepListVO> list = command.searchCtrtRep(event.getOfcRepInputVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("CtrtRepCnt",       list.size()+"" );
			if(list != null && list.size() == 1){
				eventResponse.setETCData("cust_sls_ofc_cd",    list.get(0).getCustSlsOfcCd() );
				eventResponse.setETCData("cust_srep_cd",       list.get(0).getCustSrepCd() );
				eventResponse.setETCData("srep_nm",            list.get(0).getSrepNm() );
				eventResponse.setETCData("compare_cd",         list.get(0).getCompareCd() );
			} 
			if(list != null && list.size() > 1){
				String compareCd = "N";
				for (int i = 0; i < list.size(); i++) {
					if( "Y".equals(list.get(i).getCompareCd()) ){
						compareCd = "Y";
					}
				}
				eventResponse.setETCData("compare_cd",        compareCd );
			}
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}

	/**
	 * 남미 5개 국가(브라질, 에콰도르, 도미니카 공화국, 콜롬비아, 우루과이)  BDR이후 C/A issue 직전체크
	 * 
	 * @param Event e
	 * @return GeneralEventResponse
	 * @throws EventException
	 */
	private EventResponse checkIbByCaIssue(Event e) throws EventException {
		EsmBkg0079Event event = (EsmBkg0079Event)e;
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String checkIbByCaIssueValue = "";
		try {
			event.getBkgBlNoVO().setCaUsrId(account.getUsr_id());
			checkIbByCaIssueValue = command.checkIbByCaIssue(event.getBkgBlNoVO());
			log.debug("\n INBOUNTNOTI:"+checkIbByCaIssueValue );
			eventResponse.setETCData("INBOUNTNOTI",       checkIbByCaIssueValue );
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}		
		return eventResponse;
	}

	/**
	 * ESM_BKG_0367_01 : Save
	 * Purchase Other Number 의 event에 대한 멀티 이벤트 처리<br>
	 * Purchase Other Number와 그외 number 정보를 입력/수정/삭제한다
	 * @author LEE JIN SEO
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePoOtherNo(Event e) throws EventException {
		log.debug("============================>[[ GeneralBookingConductSC  managePoOtherNo START ]]<============================");
		EsmBkg036701Event			event			= (EsmBkg036701Event)e;
		GeneralBookingReceiptBC		command			= new GeneralBookingReceiptBCImpl();
		GeneralEventResponse		eventResponse	= new GeneralEventResponse();
		PoOtherNoVO					poOtherNoVO 	= new PoOtherNoVO();
		BookingHistoryMgtBC 		historyBC 		= new BookingHistoryMgtBCImpl();
		BkgBlNoVO 					bkgBlNoVO 		= new BkgBlNoVO();
		
		/** 유효성 검사 // 필수키값 체크 : BKG_NO , BKG_NO_SPLIT */
		if (event.getPoOtherNoBkgVO() == null )return eventResponse;
//		String bkgNo      = event.getPoOtherNoBkgVO().getBkgNo();

		try{
			//1.저장전 파라미터를 입력하거나 선택된 값으로 설정해준다.
			poOtherNoVO.setIo_poOtherNoBkgVO(event.getPoOtherNoBkgVO());//condition
			poOtherNoVO.setI_poOtherNoBkgVOs(event.getPoOtherNoBkgVOs());//bkg
			poOtherNoVO.setI_poOtherShipVOs(event.getPoOtherShipVOs());// ship
			poOtherNoVO.setI_poOtherCntrVOs(event.getPoOtherCntrVOs());// cntr
			poOtherNoVO.setI_poOtherLoadingCntrVOs(event.getPoOtherLoadingCntrVOs());// loading cntr
			poOtherNoVO.setI_poOtherCmVOs(event.getPoOtherCmVOs()); // cm
			poOtherNoVO.setAccount(account);

			//2.저장조건으로 조회실행
			begin();
			bkgBlNoVO.setBkgNo(event.getPoOtherNoBkgVO().getBkgNo());
			HistoryTableVO historyTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0367", bkgBlNoVO);
			//MND 화면 -> P/O Other No pop-up일 때 C/A 적용 없음? 
			command.manageRefNo(poOtherNoVO, "N");
			command.manageRefDetail(poOtherNoVO, "N");
			historyBC.manageBookingHistory("ESM_BKG_0367", historyTableVO, account);
			commit();

			//3.저장후 결과처리
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());  //BKG00166 : 저장성공

		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		log.debug("============================>[[ GeneralBookingConductSC  managePoOtherNo END ]]<============================");
		return eventResponse;
	}

	/**
	 * ESM_BKG_0367_01 : Open
	 * searchPoOtherNo 의 event에 대한 멀티 이벤트 처리<br>
	 * Purchase Other Number와 그외 number 정보를 조회한다.
	 * @author LEE JIN SEO
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchPoOtherNo(Event e) throws EventException {
		log.debug("============================>[[ GeneralBookingConductSC  searchPoOtherNo START ]]<============================");
		EsmBkg036701Event			event			= (EsmBkg036701Event)e;
		GeneralBookingReceiptBC		command			= new GeneralBookingReceiptBCImpl();
//        BookingUtil 				command_combo 	= new BookingUtil();
		GeneralEventResponse		eventResponse	= new GeneralEventResponse();

		// 필수값 체크 : BKG_NO , BKG_NO_SPLIT
		if (event.getPoOtherNoBkgVO() == null )return eventResponse;
//		String bkgNo      = event.getPoOtherNoBkgVO().getBkgNo();

		try{
			 //BookingNo의 유효성 체크
			   BkgBlNoVO bkgVO = new BkgBlNoVO();
			   
			   bkgVO.setBkgNo(event.getPoOtherNoBkgVO().getBkgNo());
			   
			   BookingUtil utilCmd = new BookingUtil();
			   
			   BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgVO);
			   
			   if (bkgBlNoVO == null) {
			    throw new EventException(new ErrorHandler("BKG01049", new String[] { event.getPoOtherNoBkgVO().getBkgNo() }).getMessage());
			   } 

			//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
			PoOtherNoVO poOtherNoVO = new PoOtherNoVO();
			poOtherNoVO.setAccount(account);//로그인 정보 저장
			poOtherNoVO.setIo_poOtherNoBkgVO(event.getPoOtherNoBkgVO());//조회조건 VO저장
			poOtherNoVO.setFirst(event.isFirst());

			//2.조회조건으로 조회실행
			PoOtherNoVO rPoOtherNoVO = command.searchPoOtherNo(poOtherNoVO);

			//3.콤보박스 조회실행
			//List<BkgComboVO> list_wgt_ut_cd = command_combo.searchCombo("CD00775");//wgt_ut_cd
			//List<BkgComboVO> list_meas_ut_cd = command_combo.searchCombo("CD01116");//meas_ut_cd

			//4.조회후 결과처리
			List rlistCntrVOs 	= rPoOtherNoVO.getO_poOtherCntrVOs();
			List rlistCmVOs 	= rPoOtherNoVO.getO_poOtherCmVOs();
			List rlistShipVOs 	= rPoOtherNoVO.getO_poOtherShipVOs();
			List rlistNoBkgVOs 	= rPoOtherNoVO.getO_poOtherNoBkgVOs();
			List rlistLoadingCntrVOs 	= rPoOtherNoVO.getO_poOtherLoadingCntrVOs();
			PoOtherMdtItmVO rPoOtherMdtItmVO = rPoOtherNoVO.getO_PoOtherMdtItmVO();

			//4.XML생성 결과처리
			if(rlistCntrVOs != null )		{eventResponse.setRsVoList(rlistCntrVOs);}
			if(rlistCmVOs != null )			{eventResponse.setRsVoList(rlistCmVOs);}
			if(rlistShipVOs != null)		{eventResponse.setRsVoList(rlistShipVOs);}
			if(rlistLoadingCntrVOs != null ){eventResponse.setRsVoList(rlistLoadingCntrVOs);}
			if(rlistNoBkgVOs != null)		{eventResponse.setRsVoList(rlistNoBkgVOs);}
			if(rPoOtherMdtItmVO != null )	{eventResponse.setETCData("man_Item",rPoOtherMdtItmVO.getPathItem());}

			//eventResponse.setRsVoList(list_wgt_ut_cd);
			//eventResponse.setRsVoList(list_meas_ut_cd);

		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		log.debug("============================>[[ GeneralBookingConductSC  searchPoOtherNo END ]]<============================");
		//if (list.isEmpty())	eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
		return eventResponse;
	}

	/**
	 * ESM_BKG_0367_01 : Copy from C/M
	 * searchCmForPo의 event에 대한 멀티 이벤트 처리<br>
	 * PO & Other No에 CM정보를 Copy하기 위해 조회한다. (Description, Package Qty/Type, Weight Qty, Measure Qty )
	 * @author LEE JIN SEO
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchCmForPo(Event e) throws EventException {
		log.debug("============================>[[ GeneralBookingConductSC  searchCmForPo START ]]<============================");
		EsmBkg036701Event			event			= (EsmBkg036701Event)e;
		GeneralBookingReceiptBC		command			= new GeneralBookingReceiptBCImpl();
		GeneralEventResponse		eventResponse	= new GeneralEventResponse();

		// 필수값 체크 : BKG_NO , BKG_NO_SPLIT
		if (event.getPoOtherNoBkgVO() == null )return eventResponse;
//		String bkgNo      = event.getPoOtherNoBkgVO().getBkgNo();

		try{
			//1.조회전 파라미터를 입력하거나 선택된 값으로 설정해준다.
			PoOtherNoVO poOtherNoVO = new PoOtherNoVO();
			poOtherNoVO.setAccount(account);//로그인 정보 저장
			poOtherNoVO.setIo_poOtherNoBkgVO(event.getPoOtherNoBkgVO());//조회조건 VO저장

			//2.조회조건으로 조회실행
			PoOtherNoVO rpoOtherNoVO = command.searchCmForPo(poOtherNoVO);

			//3.조회후 결과처리
			List rlistCmVOs = rpoOtherNoVO.getO_poOtherCmVOs();
			eventResponse.setRsVoList(rlistCmVOs);

		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		log.debug("============================>[[ GeneralBookingConductSC  searchCmForPo END ]]<============================");
		return eventResponse;
	}

	/**
	 * ESM_BKG_0079_02A  : retrieve <br>
	 * General TRO 화면의 조회 <br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTro(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg007902aEvent event = (EsmBkg007902aEvent)e;
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try 
		{
			TroVO troVO = command.searchTro(event.getBkgBlNoVO(), event.getBoundCd(), event.getRtnTroFlg(), account);
			
			//==============================================
			//Etc-1) 상단 Booking 정보 출력용 : EtcData
			BkgInfoForTroVO bkgInfoForTroVO = troVO.getBkgInfoForTroVO();
	
			if (bkgInfoForTroVO == null || "".equals(JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgNo()))) 
			{
	    		eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
	    		eventResponse.setETCData("DataYn", "N");
			} else {
				eventResponse.setETCData("por_cd",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPorCd()));
				eventResponse.setETCData("conti_cd",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getContiCd()));
				eventResponse.setETCData("vsl_cd",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getVslCd()));
				eventResponse.setETCData("bkg_cgo_tp_cd",    JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgCgoTpCd()));
				eventResponse.setETCData("cust_nm",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCustNm()));
				eventResponse.setETCData("bkg_rep_cmdt_cd",  JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgRepCmdtCd()));
				eventResponse.setETCData("rd_cgo_flg",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getRdCgoFlg()));
				eventResponse.setETCData("bkg_rep_cmdt_nm",  JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgRepCmdtNm()));
				eventResponse.setETCData("dor_arr_dt",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getDorArrDt()));
				eventResponse.setETCData("bkg_sts_cd",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgStsCd()));
				eventResponse.setETCData("fd_grd_flg",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getFdGrdFlg()));
				eventResponse.setETCData("spcl_hide_flg",    JSPUtil.getNullNoTrim(bkgInfoForTroVO.getSpclHideFlg()));
				eventResponse.setETCData("bl_no",            JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBlNo()));
				eventResponse.setETCData("pol_code",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPolCd()));
				eventResponse.setETCData("cmdt_cd",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCmdtCd()));
				eventResponse.setETCData("bb_cgo_flg",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBbCgoFlg()));
				eventResponse.setETCData("wgt_ut_cd",        JSPUtil.getNullNoTrim(bkgInfoForTroVO.getWgtUtCd()));
				eventResponse.setETCData("dcgo_flg",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getDcgoFlg()));
				eventResponse.setETCData("etb_dt",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getEtbDt()));
				eventResponse.setETCData("cust_cnt_cd",      JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCustCntCd()));
				eventResponse.setETCData("hcdg",             JSPUtil.getNullNoTrim(bkgInfoForTroVO.getHcdg()));
				eventResponse.setETCData("por_nod_cd",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPorNodCd()));
				eventResponse.setETCData("awk_cgo_flg",      JSPUtil.getNullNoTrim(bkgInfoForTroVO.getAwkCgoFlg()));
				eventResponse.setETCData("del_cd",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getDelCd()));
				eventResponse.setETCData("pickup_cy",        JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPickupCy()));
				eventResponse.setETCData("skd_voy_no",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getSkdVoyNo()));
				eventResponse.setETCData("cust_seq",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCustSeq()));
				eventResponse.setETCData("cmdt_nm",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCmdtNm()));
				eventResponse.setETCData("skd_dir_cd",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getSkdDirCd()));
				eventResponse.setETCData("act_wgt",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getActWgt()));
				//eventResponse.setETCData("bl_tp_cd",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBlTpCd()));
				eventResponse.setETCData("pod_cd",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPodCd()));
				eventResponse.setETCData("bkg_no",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgNo()));
				eventResponse.setETCData("dor_arr_dt_hhmi",  JSPUtil.getNullNoTrim(bkgInfoForTroVO.getDorArrDtHhmi()));
				eventResponse.setETCData("term",             JSPUtil.getNullNoTrim(bkgInfoForTroVO.getTerm()));
				eventResponse.setETCData("rc_flg",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getRcFlg()));
				eventResponse.setETCData("return_cy",        JSPUtil.getNullNoTrim(bkgInfoForTroVO.getReturnCy()));					
				eventResponse.setETCData("rtn_dt",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getRtnDt()));
				eventResponse.setETCData("rtn_dt_hhmi",      JSPUtil.getNullNoTrim(bkgInfoForTroVO.getRtnDtHhmi()));
				eventResponse.setETCData("pkup_dt",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPkupDt()));
				eventResponse.setETCData("pkup_dt_hhmi",     JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPkupDtHhmi()));
				eventResponse.setETCData("aloc_sts_cd",      JSPUtil.getNullNoTrim(bkgInfoForTroVO.getAlocStsCd()));
				eventResponse.setETCData("non_rt_sts_cd",      JSPUtil.getNullNoTrim(bkgInfoForTroVO.getNonRtStsCd()));
				eventResponse.setETCData(troVO.getBkgBlNoVO().getColumnValues());	
				
				//==============================================
		        //Data-1) TRO Master 정보 출력용
				eventResponse.setRsVoList(troVO.getBkgTroVOs());
	
				//==============================================
		        //Data-2) TRO Detail 정보 출력용
				eventResponse.setRsVoList(troVO.getTroDtlVOs());
	
				//==============================================
		        //Data-3) TRO Master - Dg 정보 출력용
				//eventResponse.setRsVoList(troVO.getBkgTroDgSeqVOs());
				eventResponse.setRsVoList(troVO.getBkgTroSpclCgoSeqVOs());
	
				//==============================================
		        //Data-4) Booking별 - Dg 콤보목록 조회용
				eventResponse.setRsVoList(troVO.getDgSeqVOs());
				//==============================================
		        //Data-5) Booking별 - Rf 콤보목록 조회용
				eventResponse.setRsVoList(troVO.getRfSeqVOs());
				//==============================================
		        //Data-6) Booking별 - Awk 콤보목록 조회용
				eventResponse.setRsVoList(troVO.getAwkSeqVOs());
	
				//==============================================
		        //Data-7) TRO - Sum Qty 정보 출력용
				eventResponse.setRsVoList(troVO.getQtyInfoForTroVOs());
				eventResponse.setETCData("DataYn", "Y");
				bkgInfoForTroVO.getPolCd();
			}
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}	

		return eventResponse;
	}

	/**
	 * ESM_BKG_0079_02B : retrieve <br>
	 * 한국 TRO 화면의 조회 <br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKrTro(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg007902bEvent event = (EsmBkg007902bEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		TransferOrderIssueBC command   = new TransferOrderIssueBCImpl();		
		
		try 
		{
			TroVO troVO = command.searchTro(event.getBkgBlNoVO(), event.getBoundCd(), event.getRtnTroFlg(), account);
	
			//==============================================
			//Etc-1) 상단 Booking 정보 출력용 : EtcData
			BkgInfoForTroVO bkgInfoForTroVO = troVO.getBkgInfoForTroVO();
	
			if (bkgInfoForTroVO == null || "".equals(JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgNo()))) 
			{
	    		eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
	    		eventResponse.setETCData("DataYn", "N");
			} else {
				eventResponse.setETCData("por_cd",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPorCd()));
				eventResponse.setETCData("conti_cd",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getContiCd()));
				eventResponse.setETCData("vsl_cd",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getVslCd()));
				eventResponse.setETCData("bkg_cgo_tp_cd",    JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgCgoTpCd()));
				eventResponse.setETCData("cust_nm",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCustNm()));
				eventResponse.setETCData("bkg_rep_cmdt_cd",  JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgRepCmdtCd()));
				eventResponse.setETCData("rd_cgo_flg",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getRdCgoFlg()));
				eventResponse.setETCData("bkg_rep_cmdt_nm",  JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgRepCmdtNm()));
				eventResponse.setETCData("dor_arr_dt",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getDorArrDt()));
				eventResponse.setETCData("bkg_sts_cd",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgStsCd()));
				eventResponse.setETCData("fd_grd_flg",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getFdGrdFlg()));
				eventResponse.setETCData("spcl_hide_flg",    JSPUtil.getNullNoTrim(bkgInfoForTroVO.getSpclHideFlg()));
				eventResponse.setETCData("bl_no",            JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBlNo()));
				eventResponse.setETCData("pol_code",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPolCd()));
				eventResponse.setETCData("cmdt_cd",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCmdtCd()));
				eventResponse.setETCData("bb_cgo_flg",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBbCgoFlg()));
				eventResponse.setETCData("wgt_ut_cd",        JSPUtil.getNullNoTrim(bkgInfoForTroVO.getWgtUtCd()));
				eventResponse.setETCData("dcgo_flg",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getDcgoFlg()));
				eventResponse.setETCData("etb_dt",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getEtbDt()));
				eventResponse.setETCData("cust_cnt_cd",      JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCustCntCd()));
				eventResponse.setETCData("hcdg",             JSPUtil.getNullNoTrim(bkgInfoForTroVO.getHcdg()));
				eventResponse.setETCData("por_nod_cd",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPorNodCd()));
				eventResponse.setETCData("awk_cgo_flg",      JSPUtil.getNullNoTrim(bkgInfoForTroVO.getAwkCgoFlg()));
				eventResponse.setETCData("del_cd",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getDelCd()));
				eventResponse.setETCData("pickup_cy",        JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPickupCy()));
				eventResponse.setETCData("skd_voy_no",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getSkdVoyNo()));
				eventResponse.setETCData("cust_seq",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCustSeq()));
				eventResponse.setETCData("cmdt_nm",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCmdtNm()));
				eventResponse.setETCData("skd_dir_cd",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getSkdDirCd()));
				eventResponse.setETCData("act_wgt",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getActWgt()));
				//eventResponse.setETCData("bl_tp_cd",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBlTpCd()));
				eventResponse.setETCData("pod_cd",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPodCd()));
				eventResponse.setETCData("bkg_no",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgNo()));
				eventResponse.setETCData("dor_arr_dt_hhmi",  JSPUtil.getNullNoTrim(bkgInfoForTroVO.getDorArrDtHhmi()));
				eventResponse.setETCData("term",             JSPUtil.getNullNoTrim(bkgInfoForTroVO.getTerm()));
				eventResponse.setETCData("rc_flg",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getRcFlg()));
				eventResponse.setETCData("return_cy",        JSPUtil.getNullNoTrim(bkgInfoForTroVO.getReturnCy()));
				eventResponse.setETCData("rtn_dt",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getRtnDt()));
				eventResponse.setETCData("rtn_dt_hhmi",      JSPUtil.getNullNoTrim(bkgInfoForTroVO.getRtnDtHhmi()));
				eventResponse.setETCData("pkup_dt",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPkupDt()));
				eventResponse.setETCData("pkup_dt_hhmi",     JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPkupDtHhmi()));
				eventResponse.setETCData("non_rt_sts_cd",     JSPUtil.getNullNoTrim(bkgInfoForTroVO.getNonRtStsCd()));
				eventResponse.setETCData("aloc_sts_cd",      JSPUtil.getNullNoTrim(bkgInfoForTroVO.getAlocStsCd()));
				eventResponse.setETCData(troVO.getBkgBlNoVO().getColumnValues());
				
				//==============================================
		        //Data-1) TRO Master 정보 출력용
				eventResponse.setRsVoList(troVO.getBkgTroVOs());
			
				//==============================================
		        //Data-2) TRO Detail 정보 출력용
				eventResponse.setRsVoList(troVO.getTroDtlVOs());
	
				//==============================================
		        //Data-3) TRO Master - Dg 정보 출력용
				//eventResponse.setRsVoList(troVO.getBkgTroDgSeqVOs());
				eventResponse.setRsVoList(troVO.getBkgTroSpclCgoSeqVOs());
	
				//==============================================
		        //Data-4) Booking별 - Dg 콤보목록 조회용
				eventResponse.setRsVoList(troVO.getDgSeqVOs());
				//==============================================
		        //Data-5) Booking별 - Rf 콤보목록 조회용
				eventResponse.setRsVoList(troVO.getRfSeqVOs());
				//==============================================
		        //Data-6) Booking별 - Awk 콤보목록 조회용
				eventResponse.setRsVoList(troVO.getAwkSeqVOs());
	
				//==============================================
		        //Data-7) TRO - Sum Qty 정보 출력용
				eventResponse.setRsVoList(troVO.getQtyInfoForTroVOs());
				
				String strPorCd = "";
		        if (bkgInfoForTroVO != null) {
		        	strPorCd = JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPorCd());
		        }            
		        if ( strPorCd.length() >= 2 && "KR".equals(strPorCd.substring(0, 2)) ) 
				{
					//==============================================
			        //Data-8) [Rtn_cago]TRO Master 정보 출력용
					eventResponse.setRsVoList(troVO.getBkgTroVOsrtn());
			
					//==============================================
			        //Data-9) [Rtn_cago]TRO Detail 정보 출력용
					eventResponse.setRsVoList(troVO.getTroDtlVOsrtn());
	
					//==============================================
			        //추가) 공통코드 - Cntr 콤보목록 
					String[] arrCntr = troVO.getArrCntr();
		            ArrayList<BkgComboVO> combo1 = new ArrayList<BkgComboVO>(); 
	
					BkgComboVO bkgComboVO1 = new BkgComboVO();
					bkgComboVO1.setComboCd("CNTRLIST01");
					bkgComboVO1.setVal (" ");
					bkgComboVO1.setDesc(" ");
					bkgComboVO1.setName(" ");
					combo1.add(bkgComboVO1);
					
					for (int i=0; i<arrCntr.length; i++) {
						BkgComboVO bkgComboVO = new BkgComboVO();
						bkgComboVO.setComboCd("CNTRLIST01");
						bkgComboVO.setVal (arrCntr[i]);
						bkgComboVO.setDesc(arrCntr[i]);
						bkgComboVO.setName(arrCntr[i]);
						combo1.add(bkgComboVO);
					}
					eventResponse.setRsVoList(combo1);	
				}
		        eventResponse.setETCData("DataYn", "Y");
			}
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}	

		return eventResponse;
	}

	/**
	 * ESM_BKG_0079_02C : retrieve <br>
	 * europe TRO 화면의 조회 <br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEurTro(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg007902cEvent   event     = (EsmBkg007902cEvent)e;
		TransferOrderIssueBC command   = new TransferOrderIssueBCImpl();
		BookingUtil    comboUtil = new BookingUtil();
				
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		try 
		{
			EurTroVO eurTroVO = command.searchEurTro(event.getBkgBlNoVO(), event.getBoundCd(), account);  			
	
			//==============================================
			//Etc-1) 상단 Booking 정보 출력용 : EtcData 
			BkgInfoForTroVO bkgInfoForTroVO = eurTroVO.getBkgInfoForTroVO(); 
			
			if (bkgInfoForTroVO == null || "".equals(JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgNo()))) 
			{
	    		eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
	    		eventResponse.setETCData("DataYn", "N");
			} else {
				eventResponse.setETCData("por_cd",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPorCd()));
				eventResponse.setETCData("conti_cd",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getContiCd()));
				eventResponse.setETCData("vsl_cd",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getVslCd()));
				eventResponse.setETCData("bkg_cgo_tp_cd",    JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgCgoTpCd()));
				eventResponse.setETCData("cust_nm",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCustNm()));
				eventResponse.setETCData("bkg_rep_cmdt_cd",  JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgRepCmdtCd()));
				eventResponse.setETCData("rd_cgo_flg",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getRdCgoFlg()));
				eventResponse.setETCData("bkg_rep_cmdt_nm",  JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgRepCmdtNm()));
				eventResponse.setETCData("dor_arr_dt",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getDorArrDt()));
				eventResponse.setETCData("bkg_sts_cd",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgStsCd()));
				eventResponse.setETCData("fd_grd_flg",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getFdGrdFlg()));
				eventResponse.setETCData("spcl_hide_flg",    JSPUtil.getNullNoTrim(bkgInfoForTroVO.getSpclHideFlg()));
				eventResponse.setETCData("bl_no",            JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBlNo()));
				eventResponse.setETCData("pol_code",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPolCd()));
				eventResponse.setETCData("cmdt_cd",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCmdtCd()));
				eventResponse.setETCData("bb_cgo_flg",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBbCgoFlg()));
				eventResponse.setETCData("wgt_ut_cd",        JSPUtil.getNullNoTrim(bkgInfoForTroVO.getWgtUtCd()));
				eventResponse.setETCData("dcgo_flg",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getDcgoFlg()));
				eventResponse.setETCData("etb_dt",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getEtbDt()));
				eventResponse.setETCData("cust_cnt_cd",      JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCustCntCd()));
				eventResponse.setETCData("hcdg",             JSPUtil.getNullNoTrim(bkgInfoForTroVO.getHcdg()));
				eventResponse.setETCData("por_nod_cd",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPorNodCd()));
				eventResponse.setETCData("awk_cgo_flg",      JSPUtil.getNullNoTrim(bkgInfoForTroVO.getAwkCgoFlg()));
				eventResponse.setETCData("del_cd",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getDelCd()));
				eventResponse.setETCData("pickup_cy",        JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPickupCy()));
				eventResponse.setETCData("skd_voy_no",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getSkdVoyNo()));
				eventResponse.setETCData("cust_seq",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCustSeq()));
				eventResponse.setETCData("cmdt_nm",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getCmdtNm()));
				eventResponse.setETCData("skd_dir_cd",       JSPUtil.getNullNoTrim(bkgInfoForTroVO.getSkdDirCd()));
				eventResponse.setETCData("act_wgt",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getActWgt()));
				//eventResponse.setETCData("bl_tp_cd",         JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBlTpCd()));
				eventResponse.setETCData("pod_cd",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPodCd()));
				eventResponse.setETCData("bkg_no",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getBkgNo()));
				eventResponse.setETCData("dor_arr_dt_hhmi",  JSPUtil.getNullNoTrim(bkgInfoForTroVO.getDorArrDtHhmi()));
				eventResponse.setETCData("term",             JSPUtil.getNullNoTrim(bkgInfoForTroVO.getTerm()));
				eventResponse.setETCData("rc_flg",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getRcFlg()));
				eventResponse.setETCData("return_cy",        JSPUtil.getNullNoTrim(bkgInfoForTroVO.getReturnCy()));
				eventResponse.setETCData("rtn_dt",           JSPUtil.getNullNoTrim(bkgInfoForTroVO.getRtnDt()));
				eventResponse.setETCData("rtn_dt_hhmi",      JSPUtil.getNullNoTrim(bkgInfoForTroVO.getRtnDtHhmi()));
				eventResponse.setETCData("pkup_dt",          JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPkupDt()));
				eventResponse.setETCData("pkup_dt_hhmi",     JSPUtil.getNullNoTrim(bkgInfoForTroVO.getPkupDtHhmi()));
				eventResponse.setETCData("org_trns_mod_cd",  JSPUtil.getNullNoTrim(bkgInfoForTroVO.getOrgTrnsModCd()));
				eventResponse.setETCData("dest_trns_mod_cd", JSPUtil.getNullNoTrim(bkgInfoForTroVO.getDestTrnsModCd()));
				eventResponse.setETCData("non_rt_sts_cd",     JSPUtil.getNullNoTrim(bkgInfoForTroVO.getNonRtStsCd()));
				eventResponse.setETCData("aloc_sts_cd",     JSPUtil.getNullNoTrim(bkgInfoForTroVO.getAlocStsCd()));
				eventResponse.setETCData(eurTroVO.getBkgBlNoVO().getColumnValues());
	
				//==============================================
		        //Data-1) TRO Master 정보 출력용 
				eventResponse.setRsVoList(eurTroVO.getEurTroMstVOs());
	
				//==============================================
		        //Data-2) TRO Detail 정보 출력용 
				eventResponse.setRsVoList(eurTroVO.getEurTroDtlVOs());
	
				//==============================================
		        //Data-3) TRO Master - Dg 정보 출력용 
				eventResponse.setRsVoList(eurTroVO.getBkgEurTroDgSeqVOs());
	
				//==============================================
		        //Data-4) Booking별 - Dg 콤보목록 조회용 
				List<DgSeqVO> dgSeqVOs = eurTroVO.getDgSeqVOs();
				//2011.12.02 Dg 콤보에 "" 추가 kbj
				DgSeqVO dgSeqVO = new DgSeqVO();
				dgSeqVO.setDgSeq("");
				dgSeqVO.setDisplayNm("");
				dgSeqVO.setDgTroRmk("");
				dgSeqVOs.add(0, dgSeqVO);
				eventResponse.setRsVoList(eurTroVO.getDgSeqVOs());
				
				//==============================================
		        //Data-5) Booking별 - Rf 콤보목록 조회용 
				List<RfSeqVO> rfSeqVOs = eurTroVO.getRfSeqVOs();
				RfSeqVO rfSeqVO = new RfSeqVO();
				rfSeqVO.setRfSeq("");
				rfSeqVO.setDisplayNm("");
				rfSeqVO.setRfTroRmk("");
				rfSeqVOs.add(0, rfSeqVO);
				eventResponse.setRsVoList(rfSeqVOs);	
				//==============================================
		        //Data-6) Booking별 - Awk 콤보목록 조회용 
				List<AwkSeqVO> awkSeqVOs = eurTroVO.getAwkSeqVOs();
				AwkSeqVO awkSeqVO = new AwkSeqVO();
				awkSeqVO.setAwkSeq("");
				awkSeqVOs.add(0, awkSeqVO);
				eventResponse.setRsVoList(awkSeqVOs);	
	
				//==============================================
		        //Data-7) TRO - Sum Qty 정보 출력용 
				eventResponse.setRsVoList(eurTroVO.getQtyInfoForTroVOs());
				
				//==============================================
		        //Data-8) 공통코드 - bkg_trsp_mzd_cd 콤보목록 조회용 
				//List<BkgComboVO> combo1 = comboUtil.searchCombo("CD00277");
				List<BkgComboVO> combo1 = comboUtil.searchCombo("CD01720");
				BkgComboVO bkgComboVO = new BkgComboVO();
				//bkgComboVO.setComboCd("CD00277");
				bkgComboVO.setComboCd("CD01720");
				bkgComboVO.setVal("");
				bkgComboVO.setDesc("");
				bkgComboVO.setName("");
				combo1.add(0, bkgComboVO);
				eventResponse.setRsVoList(combo1);	
				
				//==============================================
				//Data-9) cntr 콤보목록 조회용 
                List<BkgComboVO> combo2 = eurTroVO.getBkgComboVOs();
                BkgComboVO bkgComboVO1 = new BkgComboVO();
                bkgComboVO1.setComboCd("CNTRLIST");
                bkgComboVO1.setVal("");
                bkgComboVO1.setDesc("");
                bkgComboVO1.setName("");
                combo2.add(0, bkgComboVO1);
                eventResponse.setRsVoList(combo2);    
                //==============================================
		        //Data-10) 콤보목록에서 사용될 Container List 조회 
				List<BkgEurCntrListVO> list = command.searchEurTroCntrList(event.getBkgBlNoVO(), event.getBoundCd());
				eventResponse.setRsVoList(list);
				
				eventResponse.setETCData("DataYn", "Y");
			}
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}		
	
		return eventResponse;
	}	
	
	/**
	 * ESM_BKG_0079_02B : Request <br>
	 * 한국 tro 화면의 Send Edi Request 처리 <br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse sendTroEdiToHJT(Event e) throws EventException {
		EsmBkg007902bEvent event = (EsmBkg007902bEvent)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		TransferOrderIssueBC    command  = new TransferOrderIssueBCImpl(); 
		GeneralBookingReceiptBC command2 = new GeneralBookingReceiptBCImpl();
		GeneralBookingSearchBC command3 = new GeneralBookingSearchBCImpl(); 

		try{
			//begin();
			//1) str_flatfile 생성
			//command.createTroEdi(event.getBkgBlNoVO(), event.getTroSeq(), event.getModCd(), event.getRtnTroFlg(),event.getOwnrTrkFlg(), account);
			
			//2) modifyKrPkupRtnCy 
			//command2.modifyKrPkupRtnCy(event.getBkgBlNoVO());
			
			//commit();
			
			//한국 tro request시 mty pkup/rtn cy가 바뀔 수 있으므로 terminal 301을 재전송함
			begin();
			// Vender301ParamVO에 EDI전송에 필요한 Parameter를 설정한다.
			Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
			vender301ParamVO.setBkgBlNoVO(event.getBkgBlNoVO());
			vender301ParamVO.setOldVvdVOs(null);
			vender301ParamVO.setOldQtyVOs(null);
			vender301ParamVO.setOldMtyPkupYdCd(null);
			vender301ParamVO.setBracCd("U");
			vender301ParamVO.setEdiKind("BT");
			vender301ParamVO.setAutoManualFlg("Y");
			command3.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);
			commit();
			
			//리턴메세지 : 정상
			//eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			eventResponse.setUserMessage(new ErrorHandler("BKG02043").getUserMessage());
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0079_02B : Receive MQ 연동 처리 <br>
	 * ALPSBKG_UBIZHJS_HJTBKG MQ를 통한 입력처리 <br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse receiptHjtTroEdiAck(Event e) throws EventException {
		EsmBkg007902bEvent event = (EsmBkg007902bEvent)e;
		TransferOrderIssueBC command       = new TransferOrderIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			begin();
			//1) flatFile receive
			String flatFile = event.getFlatFile();  
			command.receiptHjtTroEdiAck(flatFile, account);

			//리턴메세지 : 정상
			//eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());  //BKG00166 : 저장성공
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}

		return eventResponse;
	} 	
	
	/**
	 * ESM_BKG_0079_02A : save <br>
	 * general TRO 화면 저장 처리 <br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTro(Event e) throws EventException {		
		EsmBkg007902aEvent event = (EsmBkg007902aEvent)e;
		TransferOrderIssueBC    command    = new TransferOrderIssueBCImpl();
		BookingHistoryMgtBC     command2   = new BookingHistoryMgtBCImpl();
		GeneralBookingReceiptBC command3   = new GeneralBookingReceiptBCImpl();		
		BookingUtil             util       = new BookingUtil();
		ProductCatalogCreateBC  prdCtlBC   = new ProductCatalogCreateBCImpl(); 
		BkgCopManageBC          copBC      = new BkgCopManageBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String uiId = "ESM_BKG_0079_02A";
		boolean troCfm = false;
		try{
			begin();

			event.getBkgBlNoVO().setCaFlg("N"); 
			String bkgNo      = event.getBkgBlNoVO().getBkgNo();
			String boundCd    = event.getBoundCd();
			String rtnTroFlg  = event.getRtnTroFlg();
			String delFlg     = event.getDelFlg();
			String cxlFlg     = "";

			//1) general
			event.getTroVO().setEBkgFlg("N"); 
			event.getTroVO().setDelFlg (delFlg);
			
			TroMstVO[] arrTroMstVO = event.getTroVO().getArrTroMstVO();
			if (arrTroMstVO != null) {
				for (int i=0; i<arrTroMstVO.length; i++) {
					arrTroMstVO[i].setBkgNo    (bkgNo);
					arrTroMstVO[i].setIoBndCd  (boundCd);
					arrTroMstVO[i].setRtnTroFlg(rtnTroFlg);
				}
				event.getTroVO().setArrTroMstVO(arrTroMstVO);
			}

			TroDtlVO[] arrTroDtlVO = event.getTroVO().getArrTroDtlVO();
			if (arrTroDtlVO != null) {
				for (int i=0; i<arrTroDtlVO.length; i++) {
					arrTroDtlVO[i].setBkgNo(bkgNo);
					arrTroDtlVO[i].setIoBndCd(boundCd);
					arrTroDtlVO[i].setRtnTroFlg(rtnTroFlg);
				}
				event.getTroVO().setArrTroDtlVO(arrTroDtlVO);
				cxlFlg = arrTroDtlVO[0].getCxlFlg();
			}

			BkgTroSpclCgoSeqVO[] arrBkgTroSpclCgoSeqVO = event.getTroVO().getArrBkgTroSpclCgoSeqVO();
			if (arrBkgTroSpclCgoSeqVO != null) {
				for (int i=0; i<arrBkgTroSpclCgoSeqVO.length; i++) {
					arrBkgTroSpclCgoSeqVO[i].setBkgNo(bkgNo);
					arrBkgTroSpclCgoSeqVO[i].setIoBndCd(boundCd);
					arrBkgTroSpclCgoSeqVO[i].setRtnTroFlg(rtnTroFlg);
				}
				event.getTroVO().setArrBkgTroSpclCgoSeqVO(arrBkgTroSpclCgoSeqVO);
			}
			
			//01. history 저장전 처리			
			HistoryTableVO historyTableVO = command2.searchOldBkgForHistory(uiId, event.getBkgBlNoVO());

			//02. Tro 저장
			Map<String,Object> responseData = new HashMap<String,Object>();
			responseData = command.manageTro(event.getTroVO(), account);  //containVO

			//03. Qty 저장
			BkgQuantityVO[] arrBkgQuantityVO = (BkgQuantityVO[])responseData.get(WebKeys.ER_DBROWSETS);
			command3.modifyBkgQtyByTro(arrBkgQuantityVO, boundCd, account);
	
			// DETAIL만 변경시에도 세부 로직 모두 CALL하도록 변경
			if (arrTroMstVO != null) { 
				for (int i=0; i<arrTroMstVO.length; i++){	
					String strCfmFlg    = JSPUtil.getNullNoTrim(arrTroMstVO[i].getCfmFlg(),    "N");
					String strCfmFlgOld = JSPUtil.getNullNoTrim(arrTroMstVO[i].getCfmFlgOld(), "N");
					String strCxlFlg    = JSPUtil.getNullNoTrim(arrTroMstVO[i].getCxlFlg(),    "N");
					String strCxlFlgOld = JSPUtil.getNullNoTrim(arrTroMstVO[i].getCxlFlgOld(), "N");
					  
					//unconfirm->confirm  
					if ("N".equals(strCfmFlgOld) && "Y".equals(strCfmFlg) && "N".equals(cxlFlg)){	
						troCfm = true;
						String strTroSeq = arrTroMstVO[i].getTroSeq();
						
						command.validateInlaneRoute(event.getBkgBlNoVO(), "O", 
								arrTroMstVO[i].getReturnCyNo(),
								arrTroMstVO[i].getDorLocCd() +arrTroMstVO[i].getZnCd(), null);
						//---------------------------
						//04. searchPrdParmForInlandRoute 
						PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO();
						prdMainInfoVO.setFCmd  ("3");
						prdMainInfoVO.setPcMode("O");
						prdMainInfoVO.setBkgNo (bkgNo);
						
						BkgBlNoVO prdBkgBlNoVO = new BkgBlNoVO();
						prdBkgBlNoVO.setBkgNo(bkgNo);
						prdBkgBlNoVO.setCaFlg("N");
						String pctlNo = null;
						String seq = null;
						
						// DETAIL에서 적용가능한 SUBSEQ찾기 추가 2010.04.21
						BkgTroVO tVO = new BkgTroVO();
						tVO.setCxlFlg("TRO");
						tVO.setBkgNo(bkgNo);
						tVO.setTroSeq(strTroSeq);
						tVO.setRtnTroFlg(rtnTroFlg);
						
						if (arrTroDtlVO != null) {
							seq = arrTroDtlVO[0].getTroSubSeq();							
						} else {
							BkgTroVO bkgTroVO = util.searchPcNoforTro(tVO);
							seq = bkgTroVO.getPctlNo();
						}
						
						//05. createProdCtlRoute : ESD/PRD 모듈 call
						PrdTroInfoVO prdTroInfoVO = new PrdTroInfoVO(); 
						prdTroInfoVO.setTroSeq(strTroSeq);
						prdTroInfoVO.setTroSubSeq(seq);
						prdTroInfoVO.setAreaContiCd("X");
						prdTroInfoVO.setCntrNo   ("");
						prdTroInfoVO.setDorZone  (arrTroMstVO[i].getDorLocCd() +arrTroMstVO[i].getZnCd());
						
						prdTroInfoVO.setTroRtnCy (arrTroMstVO[i].getReturnCyNo()); 
						prdTroInfoVO.setHaulage  ("");   //02C 만 사용
						prdTroInfoVO.setTrMode   ("");   //02C(I/B) 만 사용						
						prdMainInfoVO.setMPu(arrTroMstVO[i].getPickupCyNo());
						
						PrdParameterVO prdParameterVO = new PrdParameterVO(); 
						prdParameterVO.setPrdMainInfoVO(prdMainInfoVO); 
						prdParameterVO.setBkgBlNoVO    (prdBkgBlNoVO); 
						prdParameterVO.setPrdTroInfoVO (prdTroInfoVO); 
						PrdParameterVO schPrdParameterVO = util.searchPrdParmForInlandRoute(prdParameterVO); 

						pctlNo = prdCtlBC.createPrdCtlgRout(schPrdParameterVO, account); 

						if(pctlNo == null ||pctlNo.length()==0){
							throw new EventException((String)new ErrorHandler("BKG02032").getMessage());
						}
						// pct CALL의 경우 NEW인 경우에만 하면 되므로 위치 변경
						// confirm -> confirm시에는 modifyTroPctlNo하지 않도록 함 2010.02.18 cateshin
						prdBkgBlNoVO.setPctlNo(pctlNo);
						command.modifyTroPctlNo(prdBkgBlNoVO, strTroSeq, account);
												
						if (arrTroDtlVO != null) {
							for (int k=0; k<arrTroDtlVO.length; k++){
								//해당  troSeq에 해당하는 dtl 이 아니면, 제외 처리 : dtl_grid의 경우는 all list 넘김
								if ( !strTroSeq.equals(arrTroDtlVO[k].getTroSeq()) ) {
							        continue;
								}
								
								// confirm이후 다시 confirm하는 경우 기존 cop를 delete하도록 unconfirm call 2010.02.19 cateshin
								//if ("Y".equals(strCfmFlgOld) && "Y".equals(strCfmFlg)){
								//	log.debug("\n unconfirmTro call #################################");
								//	copBC.unconfirmTro(bkgNo, strTroSeq, arrTroDtlVO[k].getTroSubSeq(), "O");
								//	log.debug("\n unconfirmTro end #################################");
								//}

								//06. confirmTro : SCE 모듈 call
								if("N".equals(arrTroDtlVO[k].getCxlFlg())){
									copBC.confirmTro(bkgNo, strTroSeq, arrTroDtlVO[k].getTroSubSeq(), "O", pctlNo, "X" ); 
								}
							}

							// 07. interfaceCoa : COA 모듈 call
							// 위치 변경 booking base call로 변경
							interfaceToMas(event.getBkgBlNoVO(), "TRO Confirm", account);
						}
					}
					// unconfirm -> confirm완료 : detail에 cancel case가 있으면 cancel된 sub seq는 해당 작업 하지 않도록 되어 있음
					
					//confirm->unconfirm or cancel
					else if ( ("Y".equals(strCfmFlgOld) && "N".equals(strCfmFlg)) 
							||("Y".equals(strCfmFlgOld) && "N".equals(strCxlFlgOld) && "Y".equals(strCxlFlg)) ) {
						String strTroSeq = arrTroMstVO[i].getTroSeq();					
						if (arrTroDtlVO != null) {
							for (int k=0; k<arrTroDtlVO.length; k++) {
								if ( !strTroSeq.equals(arrTroDtlVO[k].getTroSeq()) ) {
									continue;
								}
								// So No가 있는 경우 error로 빠지게 조치 함 2010.04.01 cateshin
								//int soNo = arrTroDtlVO[k].getTrspSoNo().length();
								//2010.06.17 frustrate case 제외를 위해 막음
								//if (soNo != 0){
								//	throw new EventException((String)new ErrorHandler("BKG08151").getMessage());
								//}
								
								//04. unconfirmTro : SCE 모듈 call
								copBC.unconfirmTro(bkgNo, strTroSeq, arrTroDtlVO[k].getTroSubSeq(), "O");
							}

							//07. interfaceCoa : COA 모듈 call
							interfaceToMas(event.getBkgBlNoVO(), "TRO Unconfirm", account);
						}
					}
				}
			}
			
			ArrayList<BkgTroVO> bkgTroVOs = new ArrayList<BkgTroVO>();
			for(int i = 0; i < historyTableVO.getBkgTroVOs().size(); i++){				
				if(arrTroMstVO[0].getTroSeq().equals(historyTableVO.getBkgTroVOs().get(i).getTroSeq())){
					bkgTroVOs.add(historyTableVO.getBkgTroVOs().get(i));
				}
			}
			historyTableVO.setOldBkgTroVOs(bkgTroVOs);
			
			ArrayList<BkgTroSpclCgoSeqVO> bkgTroSpclCgoSeqVOs = new ArrayList<BkgTroSpclCgoSeqVO>();
			for(int i = 0; i < historyTableVO.getBkgTroSpclCgoSeqVOs().size(); i++){				
				if(arrBkgTroSpclCgoSeqVO[0].getTroSeq().equals(historyTableVO.getBkgTroSpclCgoSeqVOs().get(i).getTroSeq())){
					bkgTroSpclCgoSeqVOs.add(historyTableVO.getBkgTroSpclCgoSeqVOs().get(i));
				}
			}
			historyTableVO.setOldBkgTroSpclCgoSeqVOs(bkgTroSpclCgoSeqVOs);
			
			ArrayList<BkgTroDtlVO> bkgTroDtlVOs = new ArrayList<BkgTroDtlVO>();
			for(int i = 0; i < historyTableVO.getBkgTroDtlVOs().size(); i++){				
				if(arrTroDtlVO[0].getTroSeq().equals(historyTableVO.getBkgTroDtlVOs().get(i).getTroSeq())
						&& arrTroDtlVO[0].getTroSubSeq().equals(historyTableVO.getBkgTroDtlVOs().get(i).getTroSubSeq())){
					bkgTroDtlVOs.add(historyTableVO.getBkgTroDtlVOs().get(i));
				}
			}
			historyTableVO.setOldBkgTroDtlVOs(bkgTroDtlVOs);
						
			//08. BkgHistory 저장 
			command2.manageBookingHistory(uiId, historyTableVO, account);			

			/*
			 * TRO Save 도 BKG Staff을 update 
			 */
		    GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
			receiptBC.modifyDocUserId(bkgNo, JSPUtil.getNull( event.getBkgBlNoVO().getCaFlg()), account.getUsr_id());

			if(troCfm){
				BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
				bkgDocProcSkdVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
				bkgDocProcSkdVO.setBkgDocProcTpCd("TROCFM");// TRO CONFIRM input for doc performance
				command2.manageDocProcess(bkgDocProcSkdVO, account);
				
				
				
				/*
				 * CHM-201432833 Split 01-WEB BKG ehancement 관련 후속 조치
				 * Booking Receipt Notice 전송 시점 조건 추가
                 * Auto creation된 BKG 중 Auto Notification이 체크된 경우에만 해당되며 Speical Request시, 한국을 제외한 TRO Confirm시 발송
				 */
		        GeneralBookingSearchBC bkgCommand = new GeneralBookingSearchBCImpl();
		        BookingHistoryMgtBC  hisCommand = new BookingHistoryMgtBCImpl();

		        String rcvrEml = null; 
		        rcvrEml = bkgCommand.searchEBkgUploadNoticeEml(event.getBkgBlNoVO().getBkgNo());
		                       
		        if(rcvrEml!=null && rcvrEml.length()>0){
		                       
		                BkgBlNoVO[] bkgBlNoVOs = {event.getBkgBlNoVO()};
		                String[]    eml        = {rcvrEml};     
		                String[]    cct        = {""};
		                String[]    docCct     = {""};
		                String[]    rmk        = {""};
		                String mrdNm = "ESM_BKG_5005G";
		                              
		                BkgReceiptSendVO bkgReceiptSendVO = new BkgReceiptSendVO();
		                bkgReceiptSendVO.setBkgBlNoVos(bkgBlNoVOs);
		                bkgReceiptSendVO.setEmlAddrs(eml);
		                bkgReceiptSendVO.setRemarks(rmk);
		                bkgReceiptSendVO.setMrdNm(mrdNm);
		                bkgReceiptSendVO.setCcts(cct);
		                bkgReceiptSendVO.setDocCcts(docCct);
		                List<BkgNtcHisVO> bkgNtcHisVOs = bkgCommand.sendBkgReceiptByEmail(bkgReceiptSendVO, "", account);
		                hisCommand.createBkgNtcHis(bkgNtcHisVOs, "SYSTEM");  
		        } 
		        /*-------------------------------------------------------------------------------------------------------*/

			}

			//*) 정상완료시, 리턴 메세지 처리
			String resultMsg = (String)responseData.get(WebKeys.ER_MESSAGE);
			resultMsg = ((resultMsg==null)? "": resultMsg);
			if ("".equals(resultMsg)) {
				if ("Y".equals(delFlg)) {
					eventResponse.setUserMessage("[SUCCESS] "+new ErrorHandler("GEM00010").getUserMessage());  //GEM00010 : del성공
				} else {
					eventResponse.setUserMessage("[SUCCESS] "+new ErrorHandler("BKG00166").getUserMessage());  //BKG00166 : 저장성공
				}
			} else {
				eventResponse.setUserMessage("[SUCCESS] "+resultMsg);
			}

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0079_02B : save <br>
	 * 한국 TRO 화면의 저장 처리 <br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageKrTro(Event e) throws EventException {

		EsmBkg007902bEvent event = (EsmBkg007902bEvent)e;
		TransferOrderIssueBC    command    = new TransferOrderIssueBCImpl();
		BookingHistoryMgtBC     command2   = new BookingHistoryMgtBCImpl();
		GeneralBookingReceiptBC command3   = new GeneralBookingReceiptBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		String uiId = "ESM_BKG_0079_02B";
		boolean troCfm = false;
		try{
			begin();

			//------------------------------------------->
			event.getBkgBlNoVO().setCaFlg("N"); 
			String bkgNo      = event.getBkgBlNoVO().getBkgNo();
			String boundCd    = event.getBoundCd();
			String rtnTroFlg  = event.getRtnTroFlg();
			String delFlg     = event.getDelFlg();  //event 구분 (delete:Y, request:R, save:N)

			//--------------
			//1) general
			event.getTroVO().setEBkgFlg("N"); 
			event.getTroVO().setDelFlg (delFlg);
			
			TroMstVO[] arrTroMstVO = event.getTroVO().getArrTroMstVO();
			if (arrTroMstVO != null) {
				for (int i=0; i<arrTroMstVO.length; i++) {
					arrTroMstVO[i].setBkgNo     (bkgNo);
					arrTroMstVO[i].setIoBndCd   (boundCd);
					arrTroMstVO[i].setRtnTroFlg (rtnTroFlg);
					if ("N".equals(arrTroMstVO[i].getCfmFlgOld()) && "Y".equals(arrTroMstVO[i].getCfmFlg())){
						troCfm = true;
					}
				}
				event.getTroVO().setArrTroMstVO(arrTroMstVO);
			}

			TroDtlVO[] arrTroDtlVO = event.getTroVO().getArrTroDtlVO();
			if (arrTroDtlVO != null) {
				for (int i=0; i<arrTroDtlVO.length; i++) {
					arrTroDtlVO[i].setBkgNo     (bkgNo);
					arrTroDtlVO[i].setIoBndCd   (boundCd);
					arrTroDtlVO[i].setRtnTroFlg (rtnTroFlg);
				}
				event.getTroVO().setArrTroDtlVO(arrTroDtlVO);
			}

			BkgTroSpclCgoSeqVO[] arrBkgTroSpclCgoSeqVO = event.getTroVO().getArrBkgTroSpclCgoSeqVO();
			if (arrBkgTroSpclCgoSeqVO != null) {
				for (int i=0; i<arrBkgTroSpclCgoSeqVO.length; i++) {
					arrBkgTroSpclCgoSeqVO[i].setBkgNo     (bkgNo);
					arrBkgTroSpclCgoSeqVO[i].setIoBndCd   (boundCd);
					arrBkgTroSpclCgoSeqVO[i].setRtnTroFlg (rtnTroFlg);
				}
				event.getTroVO().setArrBkgTroSpclCgoSeqVO(arrBkgTroSpclCgoSeqVO);
			}

			//----------------
			//2) rtn_cago
			TroMstVO[] arrTroMstVOrtn = event.getTroVO().getArrTroMstVOrtn();
			if (arrTroMstVOrtn != null) {
				for (int i=0; i<arrTroMstVOrtn.length; i++) {
					arrTroMstVOrtn[i].setBkgNo(bkgNo);
					arrTroMstVOrtn[i].setIoBndCd(boundCd);
					arrTroMstVOrtn[i].setRtnTroFlg("Y");
				}
				event.getTroVO().setArrTroMstVOrtn(arrTroMstVOrtn);
			}

			TroDtlVO[] arrTroDtlVOrtn = event.getTroVO().getArrTroDtlVOrtn();
			if (arrTroDtlVOrtn != null) {
				for (int i=0; i<arrTroDtlVOrtn.length; i++) {
					arrTroDtlVOrtn[i].setBkgNo(bkgNo);
					arrTroDtlVOrtn[i].setIoBndCd(boundCd);
					arrTroDtlVOrtn[i].setRtnTroFlg("Y");
				}
				event.getTroVO().setArrTroDtlVOrtn(arrTroDtlVOrtn);
			}
			//<-------------------------------------------

			//---------------------------
			//01. history 저장전 처리			
			HistoryTableVO historyTableVO = command2.searchOldBkgForHistory(uiId, event.getBkgBlNoVO());

			//---------------------------
			//02. Tro 저장
			Map<String,Object> responseData = new HashMap<String,Object>();
			responseData = command.manageKrTro(event.getTroVO(), account);  //containVO
			
			//03. TRO/O Tab 의 Remarks에 "위 BKG의 D2 장비에 대해 5년 이하의 신규 장비 공급 바랍니다." 삽입
			//Lane/BD : ALX W/B, BKG POL: KRPUS, BKG POD : BRSSZ / BRRIG / ARBUE, EQ Type/Size : D2 일 경우 
			command.modifyKrTroRmk(event.getTroVO(), account);

			/*
			 * TRO Save 도 BKG Staff을 update 
			 */
		    GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
			receiptBC.modifyDocUserId(bkgNo, JSPUtil.getNull( event.getBkgBlNoVO().getCaFlg()), account.getUsr_id());
			
			//---------------------------
			//04. Qty 저장
			BkgQuantityVO[] arrBkgQuantityVO = (BkgQuantityVO[])responseData.get(WebKeys.ER_DBROWSETS);
			command3.modifyBkgQtyByTro(arrBkgQuantityVO, boundCd, account);

			//---------------------------
			//05. BkgHistory 저장 
			command2.manageBookingHistory(uiId, historyTableVO, account); 

			if(troCfm){
				BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
				bkgDocProcSkdVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
				bkgDocProcSkdVO.setBkgDocProcTpCd("TROCFM");// TRO CONFIRM input for doc performance
				command2.manageDocProcess(bkgDocProcSkdVO, account);
			}
			
			eventResponse.setETCData("post_flg", delFlg); 
			
			//---------------------------
			//*) 정상완료시, 리턴 메세지 처리
			String resultMsg = (String)responseData.get(WebKeys.ER_MESSAGE);
			resultMsg = ((resultMsg==null)? "": resultMsg);
			
			if ("".equals(resultMsg)) {
				if ("Y".equals(delFlg)) {
					eventResponse.setUserMessage("[Success] "+new ErrorHandler("GEM00010").getUserMessage());  //GEM00010 : del성공
				} else if ("N".equals(delFlg) || "C".equals(delFlg)) {
					eventResponse.setUserMessage("[Success] "+new ErrorHandler("BKG00166").getUserMessage());  //BKG00166 : 저장성공
				} //"R" : 성공 message 반환않함 
			} else {
				eventResponse.setUserMessage("[Success] "+resultMsg);
			}

			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}

		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0079_02C : save <br>
	 * europe tro 화면의 저장 처리<br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEurTro(Event e) throws EventException {
		EsmBkg007902cEvent event = (EsmBkg007902cEvent)e;
		TransferOrderIssueBC    command       = new TransferOrderIssueBCImpl();
		BookingHistoryMgtBC     command2      = new BookingHistoryMgtBCImpl();
		GeneralBookingReceiptBC command3      = new GeneralBookingReceiptBCImpl();
		GeneralEventResponse    eventResponse = new GeneralEventResponse();
		
		String uiId = "ESM_BKG_0079_02C";	

		try{
			begin();

			//------------------------------------------->
			event.getBkgBlNoVO().setCaFlg("N"); 
			String bkgNo   = event.getBkgBlNoVO().getBkgNo();
			String boundCd = event.getBoundCd();
			String delFlg  = event.getDelFlg();   

			//----------------
			//1) general
			event.getEurTroVO().setEBkgFlg("N");
			event.getEurTroVO().setDelFlg (delFlg);
			
			EurTroMstVO[] arrEurTroMstVO = event.getEurTroVO().getArrEurTroMstVO();
			if (arrEurTroMstVO != null) {
				for (int i=0; i<arrEurTroMstVO.length; i++) {
					arrEurTroMstVO[i].setBkgNo(bkgNo);
					arrEurTroMstVO[i].setIoBndCd(boundCd);
				}
				event.getEurTroVO().setArrEurTroMstVO(arrEurTroMstVO);
			}

			EurTroDtlVO[] arrEurTroDtlVO = event.getEurTroVO().getArrEurTroDtlVO();
			if (arrEurTroDtlVO != null) {
				for (int i=0; i<arrEurTroDtlVO.length; i++) {
					arrEurTroDtlVO[i].setBkgNo(bkgNo);
					arrEurTroDtlVO[i].setIoBndCd(boundCd);
				}
				event.getEurTroVO().setArrEurTroDtlVO(arrEurTroDtlVO);
			}

			BkgEurTroDgSeqVO[] arrBkgEurTroDgSeqVO = event.getEurTroVO().getArrBkgEurTroDgSeqVO();
			if (arrBkgEurTroDgSeqVO != null) {
				for (int i=0; i<arrBkgEurTroDgSeqVO.length; i++) {
					arrBkgEurTroDgSeqVO[i].setBkgNo(bkgNo);
					arrBkgEurTroDgSeqVO[i].setIoBndCd(boundCd);
				}
				event.getEurTroVO().setArrBkgEurTroDgSeqVO(arrBkgEurTroDgSeqVO);
			}
			//<-------------------------------------------

			//---------------------------
			//01. history 저장전 처리			
			HistoryTableVO historyTableVO = command2.searchOldBkgForHistory(uiId, event.getBkgBlNoVO());

			//---------------------------
			//02. Tro 저장
			Map<String,Object> responseData = new HashMap<String,Object>();
			responseData = command.manageEurTro(event.getEurTroVO(), account);  //containVO

			//---------------------------
			//03. Qty 저장
			BkgQuantityVO[] arrBkgQuantityVO = (BkgQuantityVO[])responseData.get(WebKeys.ER_DBROWSETS);
			command3.modifyBkgQtyByTro(arrBkgQuantityVO, boundCd, account);

			/*
			 * TRO Save 도 BKG Staff을 update 
			 */
		    GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
			receiptBC.modifyDocUserId(bkgNo, JSPUtil.getNull( event.getBkgBlNoVO().getCaFlg()), account.getUsr_id());
			
			//---------------------------
			//04. BkgHistory 저장 
			command2.manageBookingHistory(uiId, historyTableVO, account); 
			
			eventResponse.setETCData("post_flg", delFlg); 
			//---------------------------
			//*) 정상완료시, 리턴 메세지 처리
			String resultMsg = (String)responseData.get(WebKeys.ER_MESSAGE);
			resultMsg = ((resultMsg==null)? "": resultMsg);
			if ("".equals(resultMsg)) {
				if ("Y".equals(delFlg)) {
					eventResponse.setUserMessage("[SUCCESS] "+new ErrorHandler("GEM00010").getUserMessage());  //GEM00010 : del성공
				} else if ("N".equals(delFlg) || "C".equals(delFlg)) {
					eventResponse.setUserMessage("[SUCCESS] "+new ErrorHandler("BKG00166").getUserMessage());  //BKG00166 : 저장성공
				} //"CF" : 성공 message 반환않함 	
			} else {
				eventResponse.setUserMessage("[SUCCESS] "+resultMsg);
			}

			commit();

		}catch(EventException ex){
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
	 * ESM_BKG_0079_02C : Cancel/Frust <br>
	 * europe tro 화면의 cancel/Frust Popup의 cancel/Frust 처리<br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelFrustEurTro(Event e) throws EventException {
		TransferOrderIssueBC command  = new TransferOrderIssueBCImpl();
		BookingHistoryMgtBC  command1 = new BookingHistoryMgtBCImpl();
//		BlRatingBC           command2 = new BlRatingBCImpl();
		BkgCopManageBC 		 copBC    = new BkgCopManageBCImpl();	
		DropOffCreationBC	 dodBC    = new DropOffCreationBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			begin();

			String uiId = "ESM_BKG_0079_02C";
			TroMultiCancelFrustVO[] arrTroMultiCancelFrustVO = null;
			EsmBkg0703Event event = (EsmBkg0703Event)e;
			arrTroMultiCancelFrustVO = event.getTroMultiCancelFrustVOs();
			
			//01. BkgHistory
			log.debug("bkg_no:"+ event.getBkgBlNoVO().getBkgNo());
			event.getBkgBlNoVO().setCaFlg("N"); 
			HistoryTableVO historyTableVO = command1.searchOldBkgForHistory(uiId, event.getBkgBlNoVO());

			//02. Cancel/Frust
			command.cancelFrustEurTro(arrTroMultiCancelFrustVO, account);
			
//			if ("I".equals(event.getIoBndCd())) {
//				//03. vat관련 처리
//				TroCfmVO troCfmVO = new TroCfmVO();
//				TroListForCfmVO[] arrTroListForCfmVO = new TroListForCfmVO[arrTroMultiCancelFrustVO.length];

//				for (int i=0; i<arrTroListForCfmVO.length; i++) {
//					arrTroListForCfmVO[i].setBkgNo     (event.getBkgBlNoVO().getBkgNo());
//					arrTroListForCfmVO[i].setHlgTpCd   (arrTroMultiCancelFrustVO[i].getHlgTpCd());
//					arrTroListForCfmVO[i].setCurrCd    (arrTroMultiCancelFrustVO[i].getCurrCd());
//					arrTroListForCfmVO[i].setTrnsRevAmt(arrTroMultiCancelFrustVO[i].getTrnsRevAmt());
//					arrTroListForCfmVO[i].setCntrNo    (arrTroMultiCancelFrustVO[i].getCntrNo());
//				}
//				troCfmVO.setArrTroListForCfmVO(arrTroListForCfmVO);
//				command2.createCHRevenue(troCfmVO, account);
				
				//04. CA History 생성
//				String strCaRsnCd    = ""; 
//				String strCaCorrRmk  = "";
//				String strRdnAcptFlg = "N";
				//addCaHistory(strCaRsnCd, strCaCorrRmk, event.getBkgBlNoVO());
//				addCaHistory(strCaRsnCd, strCaCorrRmk, event.getBkgBlNoVO(), strRdnAcptFlg);
//			}

			for(int i=0;i<arrTroMultiCancelFrustVO.length;i++){		
				log.debug("ibFlg:"      + arrTroMultiCancelFrustVO[i].getIbflag() + 
						", tro_seq:"    + arrTroMultiCancelFrustVO[i].getTroSeq() +
						", cxl_flg:"    + arrTroMultiCancelFrustVO[i].getCxlFlg() +
						", cxl_flg_chk:"+ arrTroMultiCancelFrustVO[i].getCxlFlgChk() +
						", frust:"      + arrTroMultiCancelFrustVO[i].getFrustrate() +
						", frustCheck:" + arrTroMultiCancelFrustVO[i].getFrustrateChk());
				//Frustrate인 경우에도 SCE call하도록 조건 추가 2010.06.04 by cate requested by In-Su Kim
				if( "U".equals(arrTroMultiCancelFrustVO[i].getIbflag())
				 && ( "Y".equals(arrTroMultiCancelFrustVO[i].getCxlFlgChk())||
						 "Y".equals(arrTroMultiCancelFrustVO[i].getFrustrateChk()))) 
				{
					if("Y".equals(arrTroMultiCancelFrustVO[i].getCxlFlgChk())
						&&"I".equals(arrTroMultiCancelFrustVO[i].getIoBndCd())
						&&"M".equals(arrTroMultiCancelFrustVO[i].getHlgTpCd())){ 
					String flg = command.checkInvChgIf(arrTroMultiCancelFrustVO[i].getBkgNo(),arrTroMultiCancelFrustVO[i].getCntrNo());
					if("Y".equals(flg)){
						dodBC.manageDodDrpOffChgByBookingTRO(arrTroMultiCancelFrustVO[i].getBkgNo(), arrTroMultiCancelFrustVO[i].getCntrNo(), account.getUsr_id());
					}
					}
					log.debug("\n (CANCEL/FRUST)confirmTro call####################################################");
					copBC.unconfirmTro(arrTroMultiCancelFrustVO[i].getBkgNo(), arrTroMultiCancelFrustVO[i].getTroSeq(), arrTroMultiCancelFrustVO[i].getTroSubSeq(), arrTroMultiCancelFrustVO[i].getIoBndCd());
				}
			} 
			//06. interfaceCoa : COA 모듈 call
			log.debug("\n (CANCEL/FRUST)interfaceToCoa call####################################################");
			interfaceToMas(event.getBkgBlNoVO(), "TRO Unconfirm", account);

			//05. BkgHistory
			command1.manageBookingHistory(uiId, historyTableVO, account); 
			
			commit();

			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());  //BKG00166 : 저장성공
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0906 : Confirm <br>
	 * europe tro Confirm Popup화면의 Confirm 처리<br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmEurTro(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0906Event event = (EsmBkg0906Event)e;
		TransferOrderIssueBC    command  = new TransferOrderIssueBCImpl();
		BlRatingBC              command1 = new BlRatingBCImpl();	
		BookingHistoryMgtBC     command3 = new BookingHistoryMgtBCImpl();
		GeneralBookingReceiptBC command4 = new GeneralBookingReceiptBCImpl(); 
		BookingUtil             util     = new BookingUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		String uiId = "ESM_BKG_0906";
		boolean eurTroCfm = false;
		try{
			begin();			
			event.getBkgBlNoVO().setCaFlg("N"); 

			//02. pre-BkgHistory
			HistoryTableVO historyTableVO = command3.searchOldBkgForHistory(uiId, event.getBkgBlNoVO());
			
			//01. confirmEurTro
			command.confirmEurTro(event.getTroCfmVO(), account);					
				
			//03. createCHRevenue
			String strMasterBkgNo = command1.createCHRevenue(event.getTroCfmVO(), account);
			event.setBkgNo(strMasterBkgNo); 
				
			if ("O".equals(event.getIoBndCd())) {
			//04. modifyKrPkupRtnCy 
			//KOR과 동일하게 함 -- 한국 tro시에 pickup정보 update, outbound만 있으므로 구주 TRO도 outbound일 때만 하도록
				command4.modifyEurPkupRtnCy(event.getBkgBlNoVO());
			}
			
			//05. BkgHistory
			command3.manageBookingHistory(uiId, historyTableVO, account); 

			
			TroListForCfmVO[] arrTroListForCfmVO = event.getTroCfmVO().getArrTroListForCfmVO(); 
			if (arrTroListForCfmVO != null) 
			{
				for (int i=0; i<arrTroListForCfmVO.length; i++)
				{
					if ("C".equals(arrTroListForCfmVO[i].getHlgTpCd())) 
					{
						ProductCatalogCreateBC  prdCtlBC = new ProductCatalogCreateBCImpl(); 
						BkgCopManageBC 			copBC    = new BkgCopManageBCImpl();	
						
						String strCfmFlg    = JSPUtil.getNullNoTrim(arrTroListForCfmVO[i].getCfmFlg(),    "No");
						String strCfmFlgOld = JSPUtil.getNullNoTrim(arrTroListForCfmVO[i].getCfmFlgOld(), "No");
						String pctlNo = null;
											
						//unconfirm->confirm : confirm시에
						if ("Yes".equals(strCfmFlg) && "No".equals(strCfmFlgOld)){
							eurTroCfm = true;
							
							if ("O".equals(event.getIoBndCd())) {
								command.validateInlaneRoute(event.getBkgBlNoVO(), "O", 
										arrTroListForCfmVO[i].getCntrRtnYdCd(), 
										arrTroListForCfmVO[i].getZnCd(), null);
							} else {
								command.validateInlaneRoute(event.getBkgBlNoVO(), "I", 
										arrTroListForCfmVO[i].getCntrPkupYdCd(), 
										arrTroListForCfmVO[i].getZnCd(), null);								
							}
							
							//if ("No".equals(strCfmFlgOld) && "Yes".equals(strCfmFlg)){
								log.debug("\n new PRD call####################################################");
								PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO();
								prdMainInfoVO.setFCmd  ("3");
								prdMainInfoVO.setPcMode(arrTroListForCfmVO[i].getIoBndCd());
								prdMainInfoVO.setBkgNo (arrTroListForCfmVO[i].getBkgNo());
							
								BkgBlNoVO prdBkgBlNoVO = new BkgBlNoVO();
								prdBkgBlNoVO.setBkgNo(arrTroListForCfmVO[i].getBkgNo());
								prdBkgBlNoVO.setCaFlg("N"); 
							
								PrdTroInfoVO prdTroInfoVO = new PrdTroInfoVO(); 
								prdTroInfoVO.setAreaContiCd("E");
								prdTroInfoVO.setTroSeq   (arrTroListForCfmVO[i].getTroSeq());
//								to do : change to minimum seq.
								prdTroInfoVO.setTroSubSeq(arrTroListForCfmVO[i].getTroSubSeq());
								prdTroInfoVO.setCntrNo   (arrTroListForCfmVO[i].getCntrNo()); 
								prdTroInfoVO.setDorZone  (arrTroListForCfmVO[i].getZnCd()); 
								prdTroInfoVO.setTroPkupCy(arrTroListForCfmVO[i].getCntrPkupYdCd()); 
								prdTroInfoVO.setTroRtnCy (arrTroListForCfmVO[i].getCntrRtnYdCd()); 
								prdTroInfoVO.setHaulage  (arrTroListForCfmVO[i].getHlgTpCd());        //02C 만 사용
								prdTroInfoVO.setTrMode   (changeTrspModeCd(arrTroListForCfmVO[i].getBkgTrspMzdCd()));   //02C 만 사용
							
								PrdParameterVO prdParameterVO = new PrdParameterVO(); 
								prdParameterVO.setPrdMainInfoVO(prdMainInfoVO); 
								prdParameterVO.setBkgBlNoVO    (prdBkgBlNoVO); 
								prdParameterVO.setPrdTroInfoVO (prdTroInfoVO); 
								PrdParameterVO schPrdParameterVO = util.searchPrdParmForInlandRoute(prdParameterVO); 
	
								//---------------------------
								//06. createProdCtlRoute : ESD/PRD 모듈 call
								pctlNo = prdCtlBC.createPrdCtlgRout(schPrdParameterVO, account);
							
								if(pctlNo == null ||pctlNo.length()==0){
									//throw new EventException((String)new ErrorHandler("BKG00658").getMessage());
									throw new EventException((String)new ErrorHandler("BKG02032").getMessage());
								}
								prdBkgBlNoVO.setPctlNo(pctlNo);
								log.debug("\n modifyEurTroPctlNo ##################" + pctlNo);
								command.modifyEurTroPctlNo(prdBkgBlNoVO, arrTroListForCfmVO[i].getIoBndCd(), arrTroListForCfmVO[i].getTroSeq(), account);
							//}else{
							//	log.debug("\n old PRD call####################################################");
								/** 
								 * =======================================
								 * searchPcNoforTro : pcNo 값을 얻는함수 
								 * =======================================
								 */
							//	BkgTroVO tVO = new BkgTroVO();
							//	tVO.setCxlFlg("EUR");
							//	tVO.setBkgNo(bkgNo);
							//	tVO.setTroSeq(arrTroListForCfmVO[i].getTroSeq());
							//	tVO.setRtnTroFlg("");
							//	BkgTroVO bkgTroVO = util.searchPcNoforTro(tVO);
							//	pctlNo = bkgTroVO.getPctlNo();
							//	log.debug("\n old PRD end####################################################");
							//}
							//if ("Yes".equals(strCfmFlg) && "Yes".equals(strCfmFlgOld)){
							//	log.debug("\n unconfirmTro call####################################################");
							//	copBC.unconfirmTro(arrTroListForCfmVO[i].getBkgNo(), arrTroListForCfmVO[i].getTroSeq(), "1", arrTroListForCfmVO[i].getIoBndCd());
							//	log.debug("\n unconfirmTro end####################################################");
							//}
							//---------------------------
							//07. confirmTro : SCE 모듈 call
							log.debug("\n confirmTro call###################################################");
							copBC.confirmTro(arrTroListForCfmVO[i].getBkgNo(), arrTroListForCfmVO[i].getTroSeq(), arrTroListForCfmVO[i].getTroSubSeq(), arrTroListForCfmVO[i].getIoBndCd(), pctlNo, "E");
							log.debug("\n confirmTro end####################################################");
							//---------------------------
							//08. interfaceCoa : COA 모듈 call
							log.debug("\n interfaceToCoa Confirm call###################################################");
							interfaceToMas(event.getBkgBlNoVO(), "TRO Confirm", account);
							log.debug("\n interfaceToCoa Confirm end####################################################");
						} 
						//confirm->unconfirm : cancel 시에
						else if ("No".equals(strCfmFlg) && "Yes".equals(strCfmFlgOld)) 
						{
							//---------------------------
							//07. unconfirmTro : SCE 모듈 call
							log.debug("\n unconfirmTro call###################################################");
							copBC.unconfirmTro(arrTroListForCfmVO[i].getBkgNo(), arrTroListForCfmVO[i].getTroSeq(), arrTroListForCfmVO[i].getTroSubSeq(), arrTroListForCfmVO[i].getIoBndCd());
							log.debug("\n unconfirmTro end####################################################");
							//---------------------------
							//08. interfaceCoa : COA 모듈 call
							log.debug("\n interfaceToCoa Unconfirm call###################################################");
							interfaceToMas(event.getBkgBlNoVO(), "TRO Unconfirm", account);
							log.debug("\n interfaceToCoa Unconfirm end####################################################");
						}
					}
				}
			}
			if(eurTroCfm){
				BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
				bkgDocProcSkdVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
				bkgDocProcSkdVO.setBkgDocProcTpCd("TROCFM");// TRO CONFIRM input for doc performance
				command3.manageDocProcess(bkgDocProcSkdVO, account);
			}		
			/*
			 * CHM-201432833 Split 01-WEB BKG ehancement 관련 후속 조치
			 * Booking Receipt Notice 전송 시점 조건 추가
             * Auto creation된 BKG 중 Auto Notification이 체크된 경우에만 해당되며 Speical Request시, 한국을 제외한 TRO Confirm시 발송
			 */
			GeneralBookingSearchBC bkgCommand = new GeneralBookingSearchBCImpl();
			BookingHistoryMgtBC  hisCommand = new BookingHistoryMgtBCImpl();

			String rcvrEml = null;	
			rcvrEml = bkgCommand.searchEBkgUploadNoticeEml(event.getBkgBlNoVO().getBkgNo());
			
//			CHM-201534882 WEB BKG AUTOMATION관련 로직 중 TRO CONFIRM 시 BKG RECEIPT NOTICE 발송 로직 보완 jsy
			if(rcvrEml!=null && rcvrEml.length()>0  && "O".equals(event.getIoBndCd()) ){
			
				BkgBlNoVO[] bkgBlNoVOs = {event.getBkgBlNoVO()};
				String[]    eml        = {rcvrEml};	
				String[]    cct        = {""};
				String[]    docCct     = {""};
				String[]    rmk        = {""};
				String mrdNm = "ESM_BKG_5005G";
				
				BkgReceiptSendVO bkgReceiptSendVO = new BkgReceiptSendVO();
				bkgReceiptSendVO.setBkgBlNoVos(bkgBlNoVOs);
				bkgReceiptSendVO.setEmlAddrs(eml);
				bkgReceiptSendVO.setRemarks(rmk);
				bkgReceiptSendVO.setMrdNm(mrdNm);
				bkgReceiptSendVO.setCcts(cct);
				bkgReceiptSendVO.setDocCcts(docCct);
				List<BkgNtcHisVO> bkgNtcHisVOs = bkgCommand.sendBkgReceiptByEmail(bkgReceiptSendVO, "", account);
				hisCommand.createBkgNtcHis(bkgNtcHisVOs, "SYSTEM");	
			}
			
            //Perpaid 금액 변경시 e-mail 전송로직 시작
            String chgPpdAmtFlg = command1.searchPpdChgAmtFlg(event.getBkgBlNoVO().getBkgNo());
            if(chgPpdAmtFlg.equals("Y")){
            	// BL Release 담당자 email 조회
            	String usrEml = command1.searchPpdChgRlsEmail(event.getBkgBlNoVO().getBkgNo());

            	if(!usrEml.equals("")){
            		// Email에 보낼 Data 조회
                	List<EmailPpdInfoVO> list = command1.searchPpdChgInfo(event.getBkgBlNoVO().getBkgNo(), account.getUsr_id());
            		if(list.size() > 0){
            			//Send Email
            			command1.sendEmailPpdAmount(list, usrEml, account.getUsr_eml(), account.getUsr_nm());
            		}
            	}	
            }
			
			/*-------------------------------------------------------------------------------------------------------*/
			
			commit();
			interfaceToInv(event.getBkgBlNoVO(), account);
			eventResponse.setETCData("isSuccess","Y");
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());  //BKG00166 : 저장성공
		}catch(EventException ex){
			rollback();
			throw ex;  			
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0920 : copy <br>
	 * Copy TRO 화면의 저장처리<br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse copyTro(Event e) throws EventException {
		EsmBkg0920Event event = (EsmBkg0920Event)e;
		TransferOrderIssueBC command  = new TransferOrderIssueBCImpl();
		BookingHistoryMgtBC  command3 = new BookingHistoryMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			begin();
			
			//1) TroCopy
			command.copyTro(event.getBkgBlNoVO(), event.getBoundCd(), event.getTroSeq(), event.getArrBkgBlNoVO(), account);
			
			//2) History 
			String hisCateNm      = "Tro Copy"; 
			String crntCtnt       = "Copy from Booking No:"+event.getBkgBlNoVO().getBkgNo(); 
			
			BkgBlNoVO[] arrBkgBlNoVO = event.getArrBkgBlNoVO();
			for(int i=0; i<arrBkgBlNoVO.length; i++) {
				HistoryLineVO historyLineVO = new HistoryLineVO();
				historyLineVO.setBkgNo         (arrBkgBlNoVO[i].getBkgNo());
				historyLineVO.setUiId          (event.getUiId());
				historyLineVO.setCrntCtnt      (crntCtnt);
				historyLineVO.setHisCateNm     (hisCateNm);
				command3.createBkgHistoryLine(historyLineVO, account);
			}
			
			commit();
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());  //BKG00166 : 저장성공
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0907 : open <br>
	 * TRO-Container Inquiry 화면의 Container 팝업(ESM_BKG_0907) 조회<br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEurTroCntrList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0907Event event = (EsmBkg0907Event)e;
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<BkgEurCntrListVO> list = command.searchEurTroCntrList(event.getBkgBlNoVO(), event.getIoBndCd());		
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		
		return eventResponse;
	}

	/**
	 * ESM_BKG_0704 : open <br>
	 * 한국 tro I/F Inquiry 팝업 화면의 조회<br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTroIfResultList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0704Event event = (EsmBkg0704Event)e;
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
				
		try {
			List<BkgTroXterIfVO> list = command.searchTroIfResultList(event.getBkgBlNoVO());		
			eventResponse.setRsVoList(list);
			if (list.isEmpty()) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			}
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0703 : open <br>
	 * europe tro Cancel/Frustrate 팝업(ESM_BKG_0703) 조회<br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEurTroForCancelFrust(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0703Event event = (EsmBkg0703Event)e;
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<TroMultiCancelFrustVO> list = command.searchEurTroForCancelFrust(event.getIoBndCd(), event.getBkgBlNoVO());		
			eventResponse.setRsVoList(list);
			if (list.isEmpty()) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			}
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0921 : open <br>
	 * TRO-Multi 팝업 화면의 조회 처리<br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMultiBkg(Event e) throws EventException {
		EsmBkg0921Event event = (EsmBkg0921Event)e;
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<TroMultiBkgVO> list = command.searchMultiBkg(event.getBkgBlNoVO(), event.getCntrNo(), event.getBoundCd());			
			eventResponse.setRsVoList(list);
			if (list.isEmpty()) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			}
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0566_01 : open <br>
	 * History 팝업 Header + commbolist + B/L Data 조회<br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBlHist(Event e) throws EventException {
		EsmBkg0566Event event = (EsmBkg0566Event)e;
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
				
        try {        	
			HistMainVO histMainVO = command.searchBlHist(event.getBkgBlNoVO());
			
			//==============================================
			//Etc-1) 상단 Booking 정보 출력용 : EtcData 
			BkgInforForHistVO bkgInforForHistVO = histMainVO.getBkgInforForHistVO(); 
			
			if (bkgInforForHistVO == null || bkgInforForHistVO == null ) 
			{
				// No data found.
				eventResponse.setETCData("bkg_no",           "");
				eventResponse.setETCData("bl_no",            "");
				eventResponse.setETCData("port_closing",     "");			
				eventResponse.setETCData("bdr_dt",           "");
				eventResponse.setETCData("n1st_vvd",         "");
				eventResponse.setETCData("n1st_pol",         "");
				eventResponse.setETCData("n1st_etb",         "");
				eventResponse.setETCData("n1st_etd",         "");
				eventResponse.setETCData("trnk_vvd",         "");
				eventResponse.setETCData("trnk_pol",         "");
				eventResponse.setETCData("trnk_etb",         "");
				eventResponse.setETCData("trnk_etd",         "");
				
				//eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());	//화면에서 처리 
				eventResponse.setETCData("DataYn", "N");
			} else {		
				eventResponse.setETCData("bkg_no",           JSPUtil.getNullNoTrim(bkgInforForHistVO.getBkgNo()));
				eventResponse.setETCData("bl_no",            JSPUtil.getNullNoTrim(bkgInforForHistVO.getBlNo()));
				eventResponse.setETCData("port_closing",     JSPUtil.getNullNoTrim(bkgInforForHistVO.getPortClosing()));
				eventResponse.setETCData("bdr_dt",           JSPUtil.getNullNoTrim(bkgInforForHistVO.getBdrDt()));
				eventResponse.setETCData("n1st_vvd",         JSPUtil.getNullNoTrim(bkgInforForHistVO.getN1stVvd()));
				eventResponse.setETCData("n1st_pol",         JSPUtil.getNullNoTrim(bkgInforForHistVO.getN1stPol()));
				eventResponse.setETCData("n1st_etb",         JSPUtil.getNullNoTrim(bkgInforForHistVO.getN1stEtb()));
				eventResponse.setETCData("n1st_etd",         JSPUtil.getNullNoTrim(bkgInforForHistVO.getN1stEtd()));
				eventResponse.setETCData("trnk_vvd",         JSPUtil.getNullNoTrim(bkgInforForHistVO.getTrnkVvd()));
				eventResponse.setETCData("trnk_pol",         JSPUtil.getNullNoTrim(bkgInforForHistVO.getTrnkPol()));
				eventResponse.setETCData("trnk_etb",         JSPUtil.getNullNoTrim(bkgInforForHistVO.getTrnkEtb()));
				eventResponse.setETCData("trnk_etd",         JSPUtil.getNullNoTrim(bkgInforForHistVO.getTrnkEtd()));
				
				//02. list
				//==============================================
		        //Data-1) Booking History Master 정보 출력용 
				eventResponse.setRsVoList(histMainVO.getBlHistVOs());
				eventResponse.setETCData("DataYn", "Y");
				
				//==============================================
		        //Data-2) Booking별 - Item 콤보목록 조회용 
				List<HistUiNmVO> histUiNmVOs = histMainVO.getHistUiNmVOs();
				HistUiNmVO histUiNmVO = new HistUiNmVO();
				histUiNmVO.setUdNm("All"); 
				histUiNmVO.setUiId("");	
				histUiNmVOs.add(0, histUiNmVO);
				eventResponse.setRsVoList(histUiNmVOs);	
			}
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}	

		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0566_02 : Fax/EDI tab click <br>
	 * History 팝업 화면의 FAX/EDI tab 조회 처리<br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNoticeHist(Event e) throws EventException {
		EsmBkg0566Event event = (EsmBkg0566Event)e;
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
	
		try {
			List<NoticeHistVO> noticeHistVOs = command.searchNoticeHist(event.getBkgBlNoVO());
			eventResponse.setRsVoList(noticeHistVOs);
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		
		return eventResponse;
	}

	/**
	 * ESM_BKG_0566_03 : Customs Tab click <br>
	 * History 팝업 화면의 Customs Tab 조회 처리<br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomsHist(Event e) throws EventException {
		EsmBkg0566Event event = (EsmBkg0566Event)e;
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<CustomsHistVO> customsHistVOs = command.searchCustomsHist(event.getBkgBlNoVO());
			eventResponse.setRsVoList(customsHistVOs);
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}

		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0566_04 : Document tab Click <br>
	 * History 팝업 화면의 Documnents tab 조회 처리<br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDocHist(Event e) throws EventException {
		EsmBkg0566Event event = (EsmBkg0566Event)e;
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<DocHistVO> docHistVOs = command.searchDocHist(event.getBkgBlNoVO());
			eventResponse.setRsVoList(docHistVOs);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0906 : open <br>
	 * europe tro confirm 팝업 화면의 조회 처리<br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEurTroListForCfm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0906Event event = (EsmBkg0906Event)e;
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();		
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			TroCfmVO troCfmVO = command.searchEurTroListForCfm(event.getBkgBlNoVO(), event.getIoBndCd());
			
			if ("I".equals(event.getIoBndCd())) {
				//1) EtcData : null변환 추가
				EurPayerVO eurPayerVO = troCfmVO.getEurPayerVO();
				Map<String,String>     etcData = new HashMap<String,String>();
				HashMap<String,String> hashVO  = eurPayerVO.getColumnValues();
				for (Iterator<String> iter = hashVO.keySet().iterator(); iter.hasNext(); )
		        {
		            String key = iter.next();
		            String val = hashVO.get(key);
		            etcData.put(key, JSPUtil.getNullNoTrim(val));
		        }
				eventResponse.setETCData(etcData);
			}

			//2) list
			List<TroListForCfmVO> list = troCfmVO.getTroListForCfmVOs();
			eventResponse.setRsVoList(list);

			if (list.isEmpty()) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}	

		return eventResponse;
	}

	/**
	 * ESM_BKG_0905 : save <br>
	 * Tro Actual Customer 화면의 Master/Dtl I/U/D 처리<br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTroActCust(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0905Event event = (EsmBkg0905Event)e;
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			String strErrCd = command.manageTroActCust(event.getTroActCustVO(),account);  
			if ("BKG00441".equals(strErrCd))
			{
				throw new EventException(new ErrorHandler(strErrCd).getMessage());
			}
			commit();

			eventResponse.setUserMessage(new ErrorHandler("").getUserMessage()); //그리드 여러개인 관계로, 화면에서 처리함
			//eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());  //BKG00166 : 저장성공
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0905 : retrieve <br>
	 * Tro Actual Customer 화면의 Customer탭 마스터 정보 조회<br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmCustForTro(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0905Event event = (EsmBkg0905Event)e;
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<MdmCustomerVO> list = command.searchMdmCustForTro(event.getCustCntCd(), event.getCustSeq(), event.getCustNm());		
			eventResponse.setRsVoList(list);
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
	 * ESM_BKG_0905 : master data row click <br>
	 * Tro Actual Customer 화면의 Customer탭 상세 조회<br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTroActCustByCust(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0905Event event = (EsmBkg0905Event)e;
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<BkgTroActCustVO> list = command.searchTroActCustByCust(event.getOfcCd(), event.getCntCd(), event.getCustSeq());		
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0905 : retrieve <br>
	 * Tro Actual Customer 화면의 Eq탭 Master 조회<br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActCustRep(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0905Event event = (EsmBkg0905Event)e;
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<BkgTroActRepVO> list = command.searchActCustRep(event.getDorLocCd(), event.getOfcCd(), event.getCustNm());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}		
		
		return eventResponse;
	}

	/**
	 * ESM_BKG_0905 : master data row click <br>
	 * Tro Actual Customer 화면의 Eq탭 상세 조회<br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTroActCustByEq(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0905Event event = (EsmBkg0905Event)e;
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<BkgTroActCustExtVO> list = command.searchTroActCustByEq(event.getDorLocCd(), event.getOfcCd(), event.getTroActRepSeq());		
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0905 : vendor code change <br>
	 * Tro Actual Customer 화면의 Vendor Name 조회<br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVndrName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0905Event event = (EsmBkg0905Event)e;
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			String vndrLglEngNm = command.searchVndrName(event.getCntCd(), event.getVndrSeq());

			Map<String,String> etcData = new HashMap<String,String>();
			etcData.put("vndr_lgl_eng_nm", JSPUtil.getNullNoTrim(vndrLglEngNm));
			eventResponse.setETCData(etcData);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0905 : open <br>
	 * Tro Actual Customer 화면의 Open시, Default값 초기화를 위한 정보 조회<br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTroActCustDefault(Event e) throws EventException {
		EsmBkg0905Event event = (EsmBkg0905Event)e;
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			TroActCustDefaultVO troActCustDefaultVO = command.searchTroActCustDefault(event.getDorLocCd(), event.getBkgBlNoVO());

			Map<String,String> etcData = new HashMap<String,String>();
			if (troActCustDefaultVO == null) {
				etcData.put("p_cust_cnt_cd",    "");
				etcData.put("p_cust_seq",       "");
				etcData.put("p_eq_ctrl_ofc_cd", "");
			} else {
				etcData.put("p_cust_cnt_cd",    JSPUtil.getNullNoTrim(troActCustDefaultVO.getCustCntCd()));
				etcData.put("p_cust_seq",       JSPUtil.getNullNoTrim(troActCustDefaultVO.getCustSeq()));
				etcData.put("p_eq_ctrl_ofc_cd", JSPUtil.getNullNoTrim(troActCustDefaultVO.getEqCtrlOfcCd()));
			}
			eventResponse.setETCData(etcData);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0650 : Open <br>
	 * Route정보 조회 처리 <br>
	 * 
	 * @author    KimByungKyu
	 * @param e Event
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIbTsRoute(Event e) throws EventException {
		try{
			EsmBkg0650Event event = (EsmBkg0650Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			List<TSRouteVO> list = command.searchIbTsRoute(event.getBkgBlNoVO(), event.getCodRqstSeq(), event.getOpCd());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}

//	/**
//	 * ESM_BKG_0652 : open/retrieve <br>
//	 * Customer 정보 조회 처리<br>
//	 * 
//	 * @author KimByungKyu
//	 * @param e Event
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	@SuppressWarnings("unchecked")
//	private EventResponse searchBkgCreCustCntc(Event e) throws EventException {
//		try{
//			EsmBkg0652Event event = (EsmBkg0652Event)e;
//			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
//
//			// ContainerVO로 조회결과를 받는다.
//			BkgCreCustInqVO bkgCreCustInqVO = command.searchBkgCreCustCntc(	event.getCustCntCd(),
//																			event.getCustSeq(),
//																			event.getCustNm(),
//																			event.getOfcCd());
//
//			GeneralEventResponse eventResponse = new GeneralEventResponse();
//			eventResponse.setRsVoList((List)bkgCreCustInqVO.getBkgCreCustomer());
////			eventResponse.setRsVoList((List)bkgCreCustInqVO.getCustSrep());
////			eventResponse.setRsVoList((List)bkgCreCustInqVO.getBkgCustCntcPson());
//
//			return eventResponse;			
//		}catch(EventException ex){
//			log.error("err"+ex.toString(),ex);
//			throw ex;
//		}catch(Exception ex){
//			log.error("err"+ex.toString(),ex);
//			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
//		}		
//	}
	
	/**
	 * ESM_BKG_0652 : open/retrieve <br>
	 * Customer 정보 조회 처리<br>
	 * 
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchBkgCreCustCntc(Event e) throws EventException {
		try{
			EsmBkg0652Event event = (EsmBkg0652Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();

			// ContainerVO로 조회결과를 받는다.
			BkgCreCustInqVO bkgCreCustInqVO = command.searchBkgCreCustCntc(event.getBkgCreCustInqCondVO());


			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList((List)bkgCreCustInqVO.getBkgCreCustomer());
//			eventResponse.setRsVoList((List)bkgCreCustInqVO.getCustSrep());
//			eventResponse.setRsVoList((List)bkgCreCustInqVO.getBkgCustCntcPson());

			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}

	/**
	 * ESM_BKG_0652 : retrieve <br>
	 * Customer contact 정보 조회 처리<br>
	 *
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchCustContact(Event e) throws EventException {
		try{
			EsmBkg0652Event event = (EsmBkg0652Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			BkgCreCustInqVO bkgCreCustInqVO = command.searchCustContact(	event.getDetailCustCntCd(),
																												event.getDetailCustSeq());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList((List)bkgCreCustInqVO.getCustSrep());
			eventResponse.setRsVoList((List)bkgCreCustInqVO.getBkgCustCntcPson());

			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0652 : save <br>
	 * Customer Inquiry 저장<br>
	 *
	 * @author KimByungKyu	
	 * @param e  Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBkgCreCustCntc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0652Event event = (EsmBkg0652Event) e;
		BookingUtil bookingUtil = new BookingUtil();
		BookingMasterMgtBC masterMgt = new BookingMasterMgtBCImpl();
		try {
			// 유효한 Customer정보인지 여부 확인
			MdmCustVO mdmCustVO = bookingUtil.searchMdmCust(event.getDetailCustCntCd(), event.getDetailCustSeq(), "Y");
			if(mdmCustVO != null){
				if("P".equals(mdmCustVO.getCustTpCd())){
					eventResponse.setUserMessage(new ErrorHandler("BKG00187").getUserMessage());
				}else{
					begin();
					masterMgt.manageCustContact(	event.getBkgCustCntcPsonVOS(),
																	account.getUsr_id() );
					commit();
				}
			}

		} catch (EventException ex) {
			rollback();
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);			
		}
		return eventResponse;
	}
	/**
	 * ESM_BKG_0972 : open <br>
	 * Service Mode & Route 조회<br>
	 *
	 * @author KimByungKyu		
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSvcRouteMode(Event e) throws EventException {
		try{
			EsmBkg0972Event event = (EsmBkg0972Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			BookingUtil util = new BookingUtil();
			
			SvcRouteModeVO bkgBookingVO = command.searchSvcRouteMode(event.getBkgBlNoVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if(bkgBookingVO != null){
				eventResponse.setETCData("org_sconti_cd",bkgBookingVO.getOrgScontiCd());
				eventResponse.setETCData("dest_sconti_cd",bkgBookingVO.getDestScontiCd());
				eventResponse.setETCData("org_trns_svc_mod_cd",bkgBookingVO.getOrgTrnsSvcModCd());
				eventResponse.setETCData("dest_trns_svc_mod_cd",bkgBookingVO.getDestTrnsSvcModCd());
				eventResponse.setETCData("blck_stwg_cd",bkgBookingVO.getBlckStwgCd());
				eventResponse.setETCData("estm_ib_mty_rtn_yd_cd",bkgBookingVO.getEstmIbMtyRtnYdCd());
				
				List<BkgComboVO> list = util.searchCombo("CD02149");
				if(list.size()>0){
					for(int i=0; i<list.size(); i++){
						if(list.get(i).getVal().equals(bkgBookingVO.getOrgTrnsSvcModCd())){
							eventResponse.setETCData("org_trns_svc_mod_nm",list.get(i).getDesc());
						}
						if(list.get(i).getVal().equals(bkgBookingVO.getDestTrnsSvcModCd())){
							eventResponse.setETCData("dest_trns_svc_mod_nm",list.get(i).getDesc());
						}
					}
				}
			}else{
				eventResponse.setETCData("org_sconti_cd","");
				eventResponse.setETCData("dest_sconti_cd","");
				eventResponse.setETCData("org_trns_svc_mod_cd","");
				eventResponse.setETCData("org_trns_svc_mod_cd","");
				eventResponse.setETCData("dest_trns_svc_mod_cd","");
				eventResponse.setETCData("dest_trns_svc_mod_cd","");
				eventResponse.setETCData("blck_stwg_cd","");
				eventResponse.setETCData("estm_ib_mty_rtn_yd_cd","");
				
			}
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}
	/**
	 * ESM_BKG_0090 : open <br>
	 * Stowage Code 조회<br>
	 *
	 * @author KimByungKyu		
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchStowageCode(Event e) throws EventException {
		try{
			EsmBkg0090Event event = (EsmBkg0090Event)e;
			SpecialCargoReceiptBC spclBC = new SpecialCargoReceiptBCImpl();		
			BookingUtil command = new BookingUtil();
			String loginOfcCd = account.getOfc_cd();
			String primeOfcFlg = "N";
			
			// 20090623 'CD02146'로 변경
			List<BkgComboVO> list = command.searchCombo("CD02146");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			
			// OLBP가 허용되는 OFFICE CODE
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("PRIME_SVC_OFC_CD");
			bkgHrdCdgCtntListCondVO.setAttrCtnt1("OFC_CD");
			List<BkgHrdCdgCtntVO> hrdCdgList = command.searchHardCoding(bkgHrdCdgCtntListCondVO);
			for(int h=0;h<hrdCdgList.size(); h++){
				BkgHrdCdgCtntVO tmpBkgHrdVO = (BkgHrdCdgCtntVO)hrdCdgList.get(h);
				if(loginOfcCd.equals(tmpBkgHrdVO.getAttrCtnt2())){
					primeOfcFlg = "Y";
					break;
				}
			}			

			String imdgStwgCateCd = spclBC.searchImdgUnNoStwgCateCd(event.getBkgBlNoVO());
			eventResponse.setETCData("imdg_stwg_cate_cd", imdgStwgCateCd);
			eventResponse.setETCData("prime_ofc_flg" , primeOfcFlg);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0998 : open <br>
	 * Constraint 조회<br>
	 *
	 * @author KimByungKyu		
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchConstraint(Event e) throws EventException {
		try{
			EsmBkg0998Event event = (EsmBkg0998Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			List<PrdConstraintVO> list = command.searchConstraint(event.getBkgBlNoVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0083 : RETRIEVE <br>
	 * Node Search 정보를 조회한다. <br>
	 *
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNodeCode(Event e) throws EventException {
		try{
			EsmBkg0083Event event = (EsmBkg0083Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			List<NodeListVO> list = command.searchNodeCode(event.getNodeListInputVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0083 : retrieve <br>
	 * Locaton 정보를 조회한다.<br>
	 *
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocationList(Event e) throws EventException {
		try{
			EsmBkg0083Event event = (EsmBkg0083Event)e;
			GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();
			List<LocationListVO> list = searchBC.searchLocationList(event.getLocationListInputVO());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}	
	
	/**
	 * ESM_BKG_0097 : Open <br>
	 * Reference 정보를 조회한다.<br>
	 *
	 * @author KimByungKyu		
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReferenceList(Event e) throws EventException {
		try{
			EsmBkg0097Event event = (EsmBkg0097Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			BookingUtil util = new BookingUtil();
			
			event.getBkgBlNoVO().setCaUsrId(account.getUsr_id());
			BkgBlNoVO bkgBlNoVO = util.searchBkgBlNoVO(event.getBkgBlNoVO());
			
			List<RefNoVO> list = command.searchBkgReference(bkgBlNoVO);

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			
			BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
			bkgDocProcSkdVO.setBkgNo(bkgBlNoVO.getBkgNo());
			bkgDocProcSkdVO.setBkgDocProcTpCd("SI_RDY");
			bkgDocProcSkdVO.setDocPerfDeltFlg("N");
			BkgDocProcSkdVO docProcSkdVO= util.searchDocProcSkd(bkgDocProcSkdVO, "N");
			if(docProcSkdVO != null && docProcSkdVO.getDocPerfDeltFlg().equals("N")){
				eventResponse.setETCData("si_rdy_flg","Y");
			}
			
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG-0097 : Save <br>
	 * Reference 정보를 저장한다.<br>
	 *
	 * @author KimByungKyu	
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageReferenceNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0097Event event = (EsmBkg0097Event) e;

		BookingHistoryMgtBC hisBC = new BookingHistoryMgtBCImpl();
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		BookingUtil util = new BookingUtil();
		try {
			begin();
			// 01. 이전 History 정보 조회
			HistoryTableVO historyTableVO = hisBC.searchOldBkgForHistory("ESM_BKG_0097", event.getBkgBlNoVO());

			// 03. Reference 정보를 관리한다.
			receiptBC.manageRefNo(event.getBkgReferenceVOs(), account, event.getBkgBlNoVO());
			
			String oldSiRdyFlg = "";
			BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
			bkgDocProcSkdVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
			bkgDocProcSkdVO.setBkgDocProcTpCd("SI_RDY");
			bkgDocProcSkdVO.setDocPerfDeltFlg("N");
			BkgDocProcSkdVO docProcSkdVO= util.searchDocProcSkd(bkgDocProcSkdVO, "N");
			if(docProcSkdVO != null && docProcSkdVO.getDocPerfDeltFlg().equals("N")){
				oldSiRdyFlg = "Y";
			} else {
				oldSiRdyFlg = "N";
			}
			if(event.getSiRdyFlg() == null) event.setSiRdyFlg("N");
			if(event.getBkgBlNoVO().getCaFlg().equals("N")){
				if(event.getSiRdyFlg() != null && !oldSiRdyFlg.equals(event.getSiRdyFlg())){
					if(event.getSiRdyFlg().equals("Y")){
						bkgDocProcSkdVO.setDocPerfDeltFlg("N");
					} else if(event.getSiRdyFlg().equals("N")){
						bkgDocProcSkdVO.setDocPerfDeltFlg("Y");
					}
					hisBC.manageDocProcFlag(bkgDocProcSkdVO, account);
				}
			}
			
			// 04. manageBkgHistory
			hisBC.manageBookingHistory("ESM_BKG_0097", historyTableVO, account);
			commit();
			eventResponse.setETCData("isSuccess","Y");
		} catch (EventException ex) {
			log.error("err"+ex.toString(),ex);			
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);			
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0744 : open/retrieve <br>
	 * Direct NVO-AMS File No를 조회한다.<br>
	 *
	 * @author KimByungKyu	
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNVOFileNumberList(Event e) throws EventException {
		try{
			EsmBkg0744Event event = (EsmBkg0744Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();

			UsaCstmsFileListVO usaCstmsFileListVO = command.searchNVOFileNumberList(event.getBkgBlNoVO());

			List<BkgUsaCstmsFileNoVO> bkgUsaCstmsFileNoVO = usaCstmsFileListVO.getBkgUsaCstmsFileNo();

			HblCountVO hblCountVO = usaCstmsFileListVO.getHblCountVO();
			String hblCount = "";
			if(hblCountVO != null){
				hblCount = hblCountVO.getHblTtlKnt();
			}
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(bkgUsaCstmsFileNoVO);
			eventResponse.setETCData("hbl_count",hblCount);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0744 : save <br>
	 * Direct NVO-AMS File No 정보를 관리한다.<br>
	 *
	 * @author KimByungKyu
	 * @param e  Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageNVOFileNumber(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0744Event event = (EsmBkg0744Event) e;

		BookingHistoryMgtBC hisBC = new BookingHistoryMgtBCImpl();
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		BLDocumentationBLBC blDocBC = new BLDocumentationBLBCImpl();

		try {
			begin();
			// 01. 이전 History 정보를 조회한다.
			HistoryTableVO historyTableVO = hisBC.searchOldBkgForHistory("ESM_BKG_0744", event.getBkgBlNoVO());

			// 02. Direct NVO-AMS File No를 관리한다.
			receiptBC.manageNVOFileNumber(event.getBkgUsaCstmsFileNoVOs(), account, event.getBkgBlNoVO());
			
			// 03. HBL Count를 수정한다.
			int hblCount = 0;
			if(event.getHblCountVO() != null && event.getHblCountVO().getHblTtlKnt() != null && !"".equals(event.getHblCountVO().getHblTtlKnt())){
				hblCount = Integer.parseInt(event.getHblCountVO().getHblTtlKnt());
			}
			blDocBC.modifyHblCount(hblCount, event.getBkgBlNoVO(), account);
			
			// 04. manageBkgHistory
			hisBC.manageBookingHistory("ESM_BKG_0744", historyTableVO, account);
			
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);			
		}
		return eventResponse;
	}
	/**
	 * ESM_BKG_0587 : pol_code_keyup<br>
	 * Booking Office 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgOfcListForBkgClz(Event e)throws EventException{
		try{
			EsmBkg0587Event event =(EsmBkg0587Event)e;
			GeneralBookingListSearchBC command = new GeneralBookingListSearchBCImpl();
			List<BkgComboVO> list = command.searchBkgOfcListForBkgClz(event.getPolCd(),event.getVslCd());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	/**
	 * Booking Close 화면에 Yard 및 drop down으로 보여질 calling seq 를 조회<br>
	 *
	 * @author	
	 * @param 	BkgCoffTmVO bkgCoffTmVO
	 * @return 	VslSkdVO
	 * @exception DAOException
	 */
	
	/**
	 * ESM_BKG_0587 : Booking Close 화면에 Yard 및 drop down으로 보여질 calling seq 를 조회 <br>
	 *
	 * @author 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgCoffTmYd(Event e) throws EventException {
		try{
			EsmBkg0587Event event = (EsmBkg0587Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			GeneralBookingListSearchBC command = new GeneralBookingListSearchBCImpl();

			if(event.getBkgCoffTmVOs().length > 0){
				VslSkdVO vslSkdVO = command.searchBkgCoffTmYd(event.getBkgCoffTmVOs()[0]);
				
				if(vslSkdVO != null){
					eventResponse.setETCData(vslSkdVO.getColumnValues());
				}
			}
			return eventResponse;			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}	
	}
	
	/**
	 * ESM_BKG_0587:btn_Retrieve<br>
	 * Booking Closing for Bayplan 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgCoffTm(Event e)throws EventException{
		try{
			EsmBkg0587Event event =(EsmBkg0587Event)e;
			GeneralBookingListSearchBC command = new GeneralBookingListSearchBCImpl();
			List<BkgCoffTmListVO> list = command.searchBkgCoffTm(event.getBkgListForBayPlanInputVO(),event.getSubChk());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			if (list.isEmpty())
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	/**
	 * ESM_BKG_0587:btn_Booking_Close<br>
	 * Booking Close for Bayplan 정보를 저장한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse closeBkgForBayPlan(Event e)throws EventException{
		
		try{
			EsmBkg0587Event event = (EsmBkg0587Event)e;
			BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
			BLDocumentationBLBC blBC = new BLDocumentationBLBCImpl();
			BookingUtil command2 = new BookingUtil();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			begin();
			if (command2.checkOfcAuth(event.getBkgCoffTmVOs(), account)==false){
				eventResponse.setUserMessage(new ErrorHandler("BKG00875").getUserMessage());
				return eventResponse;
			}
			command.closeBKGForBayPlan(event.getBkgCoffTmVOs(), account);
			blBC.modifyBkgClose(event.getBkgCoffTmVOs(), account);
			commit();

			eventResponse.setUserMessage(new ErrorHandler("").getUserMessage());
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		
	}
	/**
	 * ESM_BKG_0587:btn_Re_Open<br>
	 * Booking ReOpen for Bayplan 정보를 저장한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse reopenBkgForBayPlan(Event e)throws EventException{
		try{
			EsmBkg0587Event event = (EsmBkg0587Event)e;
			BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
			BLDocumentationBLBC blBC = new BLDocumentationBLBCImpl();
			BookingUtil command2 = new BookingUtil();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			begin();
			if (command2.checkOfcAuth(event.getBkgCoffTmVOs(), account)==false){
				eventResponse.setUserMessage(new ErrorHandler("BKG00875").getUserMessage());
				return eventResponse;
			}
			command.reopenBkgForBayPlan(event.getBkgCoffTmVOs(), account);
			blBC.modifyBkgClose(event.getBkgCoffTmVOs(), account);
			commit();

			eventResponse.setUserMessage(new ErrorHandler("").getUserMessage());
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		
	}
	/**
	 * ESM_BKG_0587:loadPage<br>
	 * Closing 현황 표시 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchClzStatus(Event e)throws EventException{
		try{
			BookingUtil comboUtil = new BookingUtil();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			 List<BkgComboVO> bkg_clz_sts_list  = comboUtil.searchCombo("CD02111");
	         eventResponse.setCustomData("bkg_clz_sts_list", bkg_clz_sts_list);
	         return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		
	}


	/**
	 * ESM_BKG_0102 : retrieve <br>
	 * Compulsory Firm 대상 목록을 조회한다.<br>
	 *
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgListForCompFirm(Event e) throws EventException {
		try{
			EsmBkg0102Event event = (EsmBkg0102Event)e;		 
			GeneralEventResponse eventResponse = new GeneralEventResponse();			
			
			if(event.getBkgListForCompFirmInputVO()!=null){
				GeneralBookingListSearchBC command = new GeneralBookingListSearchBCImpl();	
				List<BkgListForCompFirmVO> list = command.searchBkgListForCompFirm(event.getBkgListForCompFirmInputVO());
				eventResponse.setRsVoList(list);
			} else {
				BookingUtil comboUtil = new BookingUtil();
				List<BkgComboVO> bkg_sts_cd = comboUtil.searchCombo("CD00769");
				List<BkgComboVO> bkgStsCd = new ArrayList<BkgComboVO>();
				for(int i=0;i<bkg_sts_cd.size();i++){
					if("F".equals(bkg_sts_cd.get(i).getVal())||"W".equals(bkg_sts_cd.get(i).getVal())){
						bkgStsCd.add(bkg_sts_cd.get(i));
					}
				}
				eventResponse.setRsVoList(bkgStsCd);

				List<BkgComboVO> allocStsCd = comboUtil.searchCombo("CD03271");
				eventResponse.setRsVoList(allocStsCd);

				List<BkgComboVO> allocSvcCd = comboUtil.searchCombo("CD00005");
				BkgComboVO combovo = new BkgComboVO();
				combovo.setVal(" ");
				combovo.setName("All");
				allocSvcCd.add(0,combovo);
				eventResponse.setRsVoList(allocSvcCd);
			}
		
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}

	/**
	 * ESM_BKG_0102 : customer code change <br>
	 * Customer Name을 조회한다.<br>
	 *
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmCustName(Event e) throws EventException {
		try{
			EsmBkg0102Event event = (EsmBkg0102Event)e;
			BookingUtil bookingUtil = new BookingUtil();

			MdmCustVO mdmCustVO = bookingUtil.searchMdmCust(event.getCustCntCd(), event.getCustSeq(), "N");

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if(mdmCustVO != null){
				eventResponse.setETCData("cust_nm",mdmCustVO.getName());
			}else{
				eventResponse.setETCData("cust_nm","");
			}
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKg_0102 : compulsory firm <br>
	 * Compulsory Firm 을 수행한다.(Booking 상태 변경)<br>
	 *
	 * @author KimByungKyu
	 * @param e  Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse compFirm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0102Event event = (EsmBkg0102Event) e;

		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		
		try {
			if(event.getBkgBlNoVOs()!=null){
				for(int i = 0; i < event.getBkgBlNoVOs().length; i++) {
					begin();
					// 01. Booking 상태 변경
					String bdrVvd = receiptBC.compFirm(event.getBkgBlNoVOs()[i], account);
					if(bdrVvd != null && bdrVvd.length() == 9){
						BLDocumentationBLBC 	blBC 	= new BLDocumentationBLBCImpl();
						blBC.modifyBKGBDR(event.getBkgBlNoVOs()[i].getBkgNo(), "Y", "N", account.getUsr_id());
					}

					// 02. iterfaceCoa 호출(타모듈)
					interfaceToMas(event.getBkgBlNoVOs()[i], "Booking Firm", account);
		
					// 03. BookingHistoryMgtBC의 createBkgHistoryLine 호출
					BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
	
//					if(event.getBkgBlNoVOs()[i].getIbflag().equals("U")) {
						HistoryLineVO historyLineVO = new HistoryLineVO();
						historyLineVO.setBkgNo(event.getBkgBlNoVOs()[i].getBkgNo());
						historyLineVO.setCaFlg(event.getBkgBlNoVOs()[i].getCaFlg());
						historyLineVO.setBkgDocProcTpCd("BKGFRM");// booking firm for doc performance
						historyLineVO.setUiId("ESM_BKG_0102");
						historyLineVO.setCrntCtnt("Compulsory Firm.");
						historyLineVO.setHisCateNm("Compulsory Firm."); 
						
						historyBC.createBkgHistoryLine(historyLineVO, account);
//					}				
					commit();
					
					begin();
					interfaceToInv(event.getBkgBlNoVOs()[i], account);
					commit();
				}
			} 
			if(event.getBkgBlNoVO()!=null){
				begin();
				// 01. Booking 상태 변경
				String bdrVvd = receiptBC.compFirm(event.getBkgBlNoVO(), account);
				if(bdrVvd != null && bdrVvd.length() == 9){
					BLDocumentationBLBC 	blBC 	= new BLDocumentationBLBCImpl();
					blBC.modifyBKGBDR(event.getBkgBlNoVO().getBkgNo(), "Y", "N", account.getUsr_id());
				}

				// 02. iterfaceCoa 호출(타모듈)
				interfaceToMas(event.getBkgBlNoVO(), "Booking Firm", account);
	
				// 03. BookingHistoryMgtBC의 createBkgHistoryLine 호출
				BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();

//				if(event.getBkgBlNoVO().getIbflag().equals("U")) {
					HistoryLineVO historyLineVO = new HistoryLineVO();
					historyLineVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
					historyLineVO.setCaFlg(event.getBkgBlNoVO().getCaFlg());
					historyLineVO.setBkgDocProcTpCd("BKGFRM");// booking firm for doc performance
					historyLineVO.setUiId("ESM_BKG_0102");
					historyLineVO.setCrntCtnt("Compulsory Firm.");
					historyLineVO.setHisCateNm("Compulsory Firm."); 
					
					historyBC.createBkgHistoryLine(historyLineVO, account);
//				}				
				commit();
				
				begin();
				interfaceToInv(event.getBkgBlNoVO(), account);
				commit();
			}
		} catch (EventException ex) {
			rollback();
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);			
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0092 : open <br>
	 * Ocean Route 조회 처리.<br>
	 *
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTsRoute(Event e) throws EventException {
		try{
			EsmBkg0092Event event = (EsmBkg0092Event)e;
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
			BookingUtil bookingUtil = new BookingUtil();
			String dataYn = event.getDataYn();

			GeneralEventResponse eventResponse = new GeneralEventResponse();

			// 01. TransMode Combo
			List<BkgComboVO> bkgTransMode  = bookingUtil.searchCombo("CD01720");
			eventResponse.setRsVoList(bkgTransMode);

			if("Y".equals(dataYn)){
				OceanRouteVO oceanRouteVO = new OceanRouteVO();
				oceanRouteVO = receiptBC.searchTsRoute(event.getPolPodVvdVOs(), event.getBkgNo());
				List<VslSkdVO> vslSkds = oceanRouteVO.getVslSkd();
				
//				if(event.getBkgNo().length()<11){
					for(int i = 0; i<vslSkds.size();i++){
						if(0 != i){
							vslSkds.get(i).setPolYdCd("");
							vslSkds.get(i).setPolClptIndSeq("");						
						}
						if(vslSkds.size()-1 != i){
							vslSkds.get(i).setPodYdCd("");
							vslSkds.get(i).setPodClptIndSeq("");						
						}
					}
//				}
				// 02. Ocean Route 목록
				eventResponse.setRsVoList(vslSkds);
				// 03. ETA of 1st VVD, ETA of DEL 
				N1stEtaDelEtaVO n1stEtaDelEtaVO = oceanRouteVO.getN1stEtaDelEtaVO();
				if(n1stEtaDelEtaVO != null){
					eventResponse.setETCData("n1st_eta_day",n1stEtaDelEtaVO.getN1stEtaDay());
					eventResponse.setETCData("n1st_eta_time",n1stEtaDelEtaVO.getN1stEtaTime());
					eventResponse.setETCData("del_eta_day",n1stEtaDelEtaVO.getDelEtaDay());
					eventResponse.setETCData("del_eta_time",n1stEtaDelEtaVO.getDelEtaTime());
				}else{
					eventResponse.setETCData("n1st_eta_day","");
					eventResponse.setETCData("n1st_eta_time","");
					eventResponse.setETCData("del_eta_day","");
					eventResponse.setETCData("del_eta_time","");
				}

//				String trunkSeq = receiptBC.searchTrnkVvdByRlane(event.getPolPodVvdVOs());
//				eventResponse.setETCData("trunk_seq", trunkSeq);
			}
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_0092 : pol, pol yard, pol calling seq, pod, pod yard, pod calling seq, vvd change <br>
	 * Ocean Route Lane/POL ETD/POD ETA 조회.<br>
	 *
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLaneEtaEtd(Event e) throws EventException {
		try{
			EsmBkg0092Event event = (EsmBkg0092Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
//			for(int i = 0 ;i<event.getPolPodVvdVOs().length;i++){
//				log.debug(i+":"+event.getPolPodVvdVOs()[i].getPodCd());
//			}
			int editRow = Integer.parseInt(event.getEditRow()) - 1;
			VslSkdVO vslSkdVO = receiptBC.searchLaneEtaEtd(event.getPolPodVvdVOs()[editRow]);
			
			String trunkSeq = receiptBC.searchTrnkVvdByRlane(event.getPolPodVvdVOs());
			eventResponse.setETCData("trunk_seq", trunkSeq);
			
			if(vslSkdVO != null){
				eventResponse.setETCData(vslSkdVO.getColumnValues());
			}
			return eventResponse;			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}	
	}

	/**
	 * ESM_BKG_0092 : ok <br>
	 * Ocean Route 가용성 확인.<br>
	 *
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validateTsRoute(Event e) throws EventException {
		try{
			EsmBkg0092Event event = (EsmBkg0092Event)e;
			GeneralBookingReceiptBC receptBC = new GeneralBookingReceiptBCImpl();

			receptBC.validateTsRoute(event.getPolPodVvdVOs());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			return eventResponse;			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}

	/**
	 * ESM_BKG_0079_01 : open <br>
	 * BookingCreation Default 조회.<br>
	 *
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUserBkgDefault(Event e) throws EventException {
		try{
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();

			BookingUtil bookingUtil = new BookingUtil();

			GeneralEventResponse eventResponse = new GeneralEventResponse();

			// 01. Combo 데이터 조회 (RTerm)
			List<BkgComboVO> rTterm  = bookingUtil.searchCombo("CD00764");
			eventResponse.setRsVoList(rTterm);
			// 01. Combo 데이터 조회 (DTerm)
			List<BkgComboVO> dTerm  = bookingUtil.searchCombo("CD00765");
			eventResponse.setRsVoList(dTerm);
			// 02. Combo 데이터 조회 (Filer1)
			List<BkgComboVO> filer1  = bookingUtil.searchCombo("CD02098");
			eventResponse.setRsVoList(filer1);
			// 03. Combo 데이터 조회 (Filer2)
			List<BkgComboVO> filer2  = bookingUtil.searchCombo("CD01634");
			eventResponse.setRsVoList(filer2);
			// 04. Combo 데이터 조회 (Weight)
			List<BkgComboVO> wgt  = bookingUtil.searchCombo("CD01957");
			eventResponse.setRsVoList(wgt);
			// 05. Combo 데이터 조회 (RailBulk)
			List<BkgComboVO> railBulk  = bookingUtil.searchCombo("CD01566");
			eventResponse.setRsVoList(railBulk);
			// 06. Combo 데이터 조회 (ida_hlg_tp_cd)
			List<BkgComboVO> idaHlgTp  = bookingUtil.searchCombo("CD01625");
			eventResponse.setRsVoList(idaHlgTp);

			// 06. Default 셋팅
			BkgUsrDfltSetVO bkgUsrDfltSetVO = receiptBC.searchUserBkgDefault(account);

			if(bkgUsrDfltSetVO != null){
				eventResponse.setETCData(bkgUsrDfltSetVO.getColumnValues());
			}else{
				eventResponse.setETCData("rcv_term_cd", "");
				eventResponse.setETCData("de_term_cd", "");
				eventResponse.setETCData("mty_pkup_yd_cd", "");
				eventResponse.setETCData("cntr_tpsz_cd", "");
				eventResponse.setETCData("wgt_ut_cd", "");
				eventResponse.setETCData("meas_ut_cd", "");
				eventResponse.setETCData("auto_edi_hld_flg", "");
			}
			return eventResponse;			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_0658 : ok <br>
	 * Stop Off Cargo Order 저장시 Location 확인.<br>
	 *
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validateLocation(Event e) throws EventException {
		try{
			EsmBkg0658Event event = (EsmBkg0658Event)e;
			BookingUtil bookingUtil = new BookingUtil();

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if(!bookingUtil.validateLoc(event.getStopOffLocCd())){
				throw new EventException(new ErrorHandler("BKG00061",new String[]{event.getStopOffLocCd()}).getMessage());
			}
			return eventResponse;			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}

	/**
	 * ESM_BKG_0079_01 : commodify change <br>
	 * BookingCreation CmdtCd로 정보 조회.<br>
	 *
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validatePrecaution(Event e) throws EventException {
		try{
			EsmBkg007901Event event = (EsmBkg007901Event)e;
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();

			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CmdtVO cmdtVO = receiptBC.validatePrecaution(event.getCmdtCd());

			if(cmdtVO != null){
				eventResponse.setETCData(cmdtVO.getColumnValues());
			}else{
				eventResponse.setETCData("rep_cmdt_cd","");
				eventResponse.setETCData("cmdt_nm","");
				eventResponse.setETCData("rep_imdg_lvl_cd","");
				eventResponse.setUserMessage(new ErrorHandler("BKG00010").getUserMessage());
			}
			return eventResponse;			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}
	/**
	 * ESM_BKG_0721 : open <br>
	 * 해당 booking의 cut off time 정보 조회 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCargoClosingTime(Event e)throws EventException{
		try{
			EsmBkg0721Event event =(EsmBkg0721Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			ClzTmListVO  clzTmListVO = command.searchCargoClosingTime(event.getBkgBlNoVO(),account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(clzTmListVO.getClzTmVO());
	
			if(clzTmListVO.getBkgForCargoClosingVO().size()>0){
				eventResponse.setETCData("bkg_no",clzTmListVO.getBkgForCargoClosingVO().get(0).getBkgNo());
				eventResponse.setETCData("vvd",clzTmListVO.getBkgForCargoClosingVO().get(0).getVvd());
				eventResponse.setETCData("pol",clzTmListVO.getBkgForCargoClosingVO().get(0).getPolCd());
				eventResponse.setETCData("etb",clzTmListVO.getBkgForCargoClosingVO().get(0).getEtb());
				eventResponse.setETCData("etd",clzTmListVO.getBkgForCargoClosingVO().get(0).getEtd());
			}else{
				eventResponse.setETCData("vvd","");
				eventResponse.setETCData("pol","");
				eventResponse.setETCData("etb","");
				eventResponse.setETCData("etd","");
			}
			return eventResponse;
		} catch(EventException se) {
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}

	/**
	 * ESM_BKG_0721 : save <br>
	 * 해당 booking의 cut off time 정보 저장 처리 <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCargoClosingTime(Event e) throws EventException {
		try{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmBkg0721Event event = (EsmBkg0721Event)e;
			GeneralBookingReceiptBC command = new GeneralBookingReceiptBCImpl();
			BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
			begin();
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(event.getBkgClzTmVOs()[0].getBkgNo());
			bkgBlNoVO.setCaFlg("N");
			HistoryTableVO historyTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0721", bkgBlNoVO);
			command.manageCargoClosingTime(event.getBkgClzTmVOs(), account);
			historyBC.manageBookingHistory("ESM_BKG_0721", historyTableVO, account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
			return eventResponse;
		} catch(EventException se) {
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		
	}

	/**
	 * ESM_BKG_0709 : open <br>
	 * danger cargo split시 참고할 data를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDgSplit(Event e) throws EventException{
		try{
			EsmBkg0709Event event = (EsmBkg0709Event)e;
			GeneralBookingSplitCombineBC command = new GeneralBookingSplitCombineBCImpl();
			List<DgSplitVO>  dgSplitVO = command.searchDgSplit(event.getBkgBlNoVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(dgSplitVO);
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}

	/**
	 * ESM_BKG_0710 : open <br>
	 * reefer cargo split시 참고할 data를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRfSplit(Event e) throws EventException{
		try{
			EsmBkg0710Event event = (EsmBkg0710Event)e;
			GeneralBookingSplitCombineBC command = new GeneralBookingSplitCombineBCImpl();
			List<RfSplitVO>  rfSplitVO = command.searchRfSplit(event.getBkgBlNoVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(rfSplitVO);
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}

	/**
	 * ESM_BKG_0715 : open <br>
	 * awkward cargo split시 참고할 data를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAkSplit(Event e) throws EventException{
		try{
			EsmBkg0715Event event = (EsmBkg0715Event)e;
			GeneralBookingSplitCombineBC command = new GeneralBookingSplitCombineBCImpl();
			List<AkSplitVO>  akSplitVO = command.searchAkSplit(event.getBkgBlNoVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(akSplitVO);
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}

	/**
	 * ESM_BKG_0716 : open <br>
	 * break bulk cargo split시 참고할 data를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBbSplit(Event e) throws EventException{
		try{
			EsmBkg0716Event event = (EsmBkg0716Event)e;
			GeneralBookingSplitCombineBC command = new GeneralBookingSplitCombineBCImpl();
			List<BbSplitVO>  bbSplitVO = command.searchBbSplit(event.getBkgBlNoVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(bbSplitVO);
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_1025 : open <br>
	 * tro split시 참고할 data를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTroSplit(Event e) throws EventException{
		try{
			EsmBkg1025Event event = (EsmBkg1025Event)e;
			GeneralBookingSplitCombineBC command = new GeneralBookingSplitCombineBCImpl();
			List<TroSplitVO>  troSplitVO = command.searchTroSplit(event.getBkgBlNoVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(troSplitVO);
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	/**
	 * ESM_BKG_0079_01 : retrieve <br>
	 * BookingCreation 정보 조회 처리
	 * 최초 로딩시 Combo 정보를 가져와야 하기에 SC에서 Validation 처리.
	 * 
	 * @author KimByungKyu 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBooking(Event e) throws EventException {
		try{
			EsmBkg007901Event event = (EsmBkg007901Event)e;
			
			GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
			BookingUtil 			bookingUtil = new BookingUtil();	
			ProductCatalogCreateBC 	prdBC 		= new ProductCatalogCreateBCImpl();
			ChargeCalculationBCImpl dmtBC       = new ChargeCalculationBCImpl();
			GeneralBookingSearchBC  searchBC    = new GeneralBookingSearchBCImpl();
			WeeklyCMBC              masBC       = new WeeklyCMBCImpl();

			GeneralEventResponse eventResponse = new GeneralEventResponse();		
			
			// 01. Combo 데이터 조회 (RTerm)
			List<BkgComboVO> rTterm  = bookingUtil.searchCombo("CD00764");
			eventResponse.setRsVoList(rTterm);
			// 01. Combo 데이터 조회 (DTerm)
			List<BkgComboVO> dTerm  = bookingUtil.searchCombo("CD00765");		
			eventResponse.setRsVoList(dTerm);				
			// 02. Combo 데이터 조회 (Filer1)
			List<BkgComboVO> filer1  = bookingUtil.searchCombo("CD02098");
			eventResponse.setRsVoList(filer1);	
			// 03. Combo 데이터 조회 (Filer2)
			List<BkgComboVO> filer2  = bookingUtil.searchCombo("CD01634");
			eventResponse.setRsVoList(filer2);			
			// 04. Combo 데이터 조회 (Weight)
			List<BkgComboVO> wgt  = bookingUtil.searchCombo("CD01957");	
			eventResponse.setRsVoList(wgt);		
			// 05. Combo 데이터 조회 (RailBulk)
			List<BkgComboVO> railBulk  = bookingUtil.searchCombo("CD01566");
			eventResponse.setRsVoList(railBulk);		
			// 06. Combo 데이터 조회 (ida_hlg_tp_cd)
			List<BkgComboVO> idaHlgTp  = bookingUtil.searchCombo("CD01625");
			eventResponse.setRsVoList(idaHlgTp);

			// 06. Booking 정보 조회
			event.getBkgBlNoVO().setCaUsrId(account.getUsr_id());			
			BookingCreationVO bookingCreationVO = receiptBC.searchBooking(event.getBkgBlNoVO());
			
			if(bookingCreationVO != null){
				BkgBookingInfoVO bkgBookingInfoVO =  bookingCreationVO.getBkgBookingInfoVO();
				if(bkgBookingInfoVO != null){
					if("M".equals(bkgBookingInfoVO.getBkgCgoTpCd())){
						// You can not retrieve Empty Reposition BKG Data
						eventResponse.setUserMessage(new ErrorHandler("BKG00092").getUserMessage());
						eventResponse.setETCData("DataYn", "N");
					}else{
						if("Y".equals(bkgBookingInfoVO.getBdrFlg())){
							// 다른 usr가 c/a tmp를 만든지 30분지 지났을 경우
							String caUsrId = receiptBC.searchCaTmp(event.getBkgBlNoVO()); 
							if(caUsrId!=null && caUsrId.length()>1){
								if(!caUsrId.equals(account.getUsr_id())){
									BDRCorrectionBC         bDRCorrectionBC     = new BDRCorrectionBCImpl();
									BLDocumentationBLBC     bLDocumentationBLBC = new BLDocumentationBLBCImpl();
									SpecialCargoReceiptBC   spclCgoReceiptBC   	= new SpecialCargoReceiptBCImpl();
									BlRatingBC              blRatingBC          = new BlRatingBCImpl();
									BookingHistoryMgtBC     historyMgtBC    	= new BookingHistoryMgtBCImpl();
									BLIssuanceBC            bLIssuanceBC        = new BLIssuanceBCImpl();
									 		
									String copyTypeCd = "TEMP";
									spclCgoReceiptBC.removeCA  	(event.getBkgBlNoVO(), copyTypeCd);
									blRatingBC.removeCA         (event.getBkgBlNoVO(), copyTypeCd);
									bLDocumentationBLBC.removeCA(event.getBkgBlNoVO(), copyTypeCd);
									receiptBC.removeCA			(event.getBkgBlNoVO(), copyTypeCd);
									bLIssuanceBC.removeCA       (event.getBkgBlNoVO(), copyTypeCd);
									historyMgtBC.removeCA       (event.getBkgBlNoVO(), copyTypeCd);
									bDRCorrectionBC.removeCATemp(event.getBkgBlNoVO());
									historyMgtBC.removeTmpHistory(event.getBkgBlNoVO());
								}								
							}
						}
						// 원 BL 번호
						String orgBlNo = "";
						if(bookingCreationVO.getSplitMstBlNoVO() != null){
							orgBlNo = bookingCreationVO.getSplitMstBlNoVO().getBlNo();
						}
						eventResponse.setETCData("OrgBlNo",orgBlNo);	

//						if(!("US".equals(bkgBookingInfoVO.getBkgPolCd().substring(0, 2))||"CA".equals(bkgBookingInfoVO.getBkgPolCd().substring(0, 2)))){
//							bkgBookingInfoVO.setAlocStsCd("");
//						}
						eventResponse.setETCData(bookingCreationVO.getBkgBlNoVO().getColumnValues());	
						// Booking 정보
						eventResponse.setETCData(bkgBookingInfoVO.getColumnValues());	
						// Vsk 정보
						List<VslSkdVO> vslSkd = bookingCreationVO.getVslSkd();
						eventResponse.setRsVoList(vslSkd);	
						// Quantity 정보
						List<BkgQuantityVO> bkgQuantity = bookingCreationVO.getBkgQuantity();
						eventResponse.setRsVoList(bkgQuantity);	
						// QtyDtl 정보
						List<BkgQtyDtlVO> bkgQtyDtl = bookingCreationVO.getBkgQtyDtl();
						eventResponse.setRsVoList(bkgQtyDtl);	
						
						// Customer정보
						BlCustomerInfoVO blCustomerInfoVO = bookingCreationVO.getBlCustomerInfoVO();
						if(blCustomerInfoVO != null){
							eventResponse.setETCData(blCustomerInfoVO.getColumnValues());	
						}		
						// Contact 정보
						eventResponse.setETCData("bkg_cntc_pson_nm", "");
						eventResponse.setETCData("bkg_cntc_pson_phn_no", "");	
						eventResponse.setETCData("bkg_cntc_pson_eml", "");	
						eventResponse.setETCData("bkg_cntc_posn_mphn_no", "");	
						eventResponse.setETCData("bkg_cntc_pson_fax_no", "");	
						eventResponse.setETCData("si_cntc_pson_nm", "");
						eventResponse.setETCData("si_cntc_pson_phn_no", "");	
						eventResponse.setETCData("si_cntc_pson_eml", "");	
						eventResponse.setETCData("si_cntc_posn_mphn_no", "");	
						eventResponse.setETCData("si_cntc_pson_fax_no", "");						
						List<BkgCntcPsonVO> bkgCntcPson = bookingCreationVO.getBkgCntcPson();					
						if(bkgCntcPson != null){
							BkgCntcPsonVO bkgCntcPsonVO = null;
							for(int i = 0 ; i < bkgCntcPson.size() ; i++){
								bkgCntcPsonVO = bkgCntcPson.get(i);
								if("BK".equals(bkgCntcPsonVO.getBkgCntcPsonTpCd())){
									eventResponse.setETCData("bkg_cntc_pson_nm", bkgCntcPsonVO.getCntcPsonNm());
									eventResponse.setETCData("bkg_cntc_pson_phn_no", bkgCntcPsonVO.getCntcPsonPhnNo());	
									eventResponse.setETCData("bkg_cntc_pson_eml", bkgCntcPsonVO.getCntcPsonEml());	
									eventResponse.setETCData("bkg_cntc_pson_mphn_no", bkgCntcPsonVO.getCntcPsonMphnNo());	
									eventResponse.setETCData("bkg_cntc_pson_fax_no", bkgCntcPsonVO.getCntcPsonFaxNo());	
								}else if("SI".equals(bkgCntcPsonVO.getBkgCntcPsonTpCd())){
									eventResponse.setETCData("si_cntc_pson_nm", bkgCntcPsonVO.getCntcPsonNm());
									eventResponse.setETCData("si_cntc_pson_phn_no", bkgCntcPsonVO.getCntcPsonPhnNo());	
									eventResponse.setETCData("si_cntc_pson_eml", bkgCntcPsonVO.getCntcPsonEml());	
									eventResponse.setETCData("si_cntc_pson_mphn_no", bkgCntcPsonVO.getCntcPsonMphnNo());	
									eventResponse.setETCData("si_cntc_pson_fax_no", bkgCntcPsonVO.getCntcPsonFaxNo());					
								}
							}
						}
//						eventResponse.setETCData("filer_cd", bkgBookingInfoVO.getFilerCd());		
//						eventResponse.setETCData("vvd_flag", bkgBookingInfoVO.getVvdFlag());	
//						eventResponse.setETCData("rfa_available", bkgBookingInfoVO.getRfaAvailable());	
//						eventResponse.setETCData("sc_available", bkgBookingInfoVO.getScAvailable());	
//						eventResponse.setETCData("taa_available", bkgBookingInfoVO.getTaaAvailable());
						
						//[]S/C no. customer 안 맞으면 붉은색으로 표시 되도록
						ScListInputVO scListInputVO = new ScListInputVO();
						scListInputVO.setBkgNo(bookingCreationVO.getBkgBookingInfoVO().getBkgNo());//BkgNo
						scListInputVO.setBkgVvd(bookingCreationVO.getBkgBookingInfoVO().getBkgTrunkVvd());//TrunkVvd
						scListInputVO.setPorCd(bookingCreationVO.getBkgBookingInfoVO().getBkgPorCd());//POR
						scListInputVO.setDelCd(bookingCreationVO.getBkgBookingInfoVO().getBkgDelCd());//DEL
						scListInputVO.setSCustCntCd(bookingCreationVO.getBlCustomerInfoVO().getSCustCntCd());//SHPR CNT
						scListInputVO.setSCustSeq(bookingCreationVO.getBlCustomerInfoVO().getSCustSeq());//SHPR SEQ
						scListInputVO.setCCustCntCd(bookingCreationVO.getBlCustomerInfoVO().getCCustCntCd());//CNEE CNT
						scListInputVO.setCCustSeq(bookingCreationVO.getBlCustomerInfoVO().getCCustSeq());//CNEE SEQ
						scListInputVO.setScNo(bookingCreationVO.getBkgBookingInfoVO().getScNo());//ScNo
						String scAvilableCust = searchBC.searchScAvailableCust(scListInputVO);
						if("N".equals(scAvilableCust)){// SC no. 와 Customer 맞지 않으면 붉은색 표시
							eventResponse.setETCData("sc_available", "N");
						}
						
						// vl 여부
						if(!"Y".equals(bkgBookingInfoVO.getBdrFlg())){
							String mvmtStsCd[] = bookingUtil.searchMVMTStatus(event.getBkgBlNoVO(), null);
							for(int i = 0 ; i < mvmtStsCd.length ; i++){
								if("VL".equals(mvmtStsCd[i])){
									eventResponse.setETCData("is_vl_flg","Y"); 
									break;
								}
							}
						}
						if("Y".equals(bkgBookingInfoVO.getRejectFlag())){
							eventResponse.setUserMessage(new ErrorHandler("BKG01035").getUserMessage());
						}
						eventResponse.setETCData("constraint_flag", 
								prdBC.searchPrdConstraint(bookingCreationVO.getBkgBookingInfoVO().getPctlNo(),
															bookingCreationVO.getBkgBookingInfoVO().getBkgNo()));
						eventResponse.setETCData("DataYn", "Y");	
						
						if(!"".equals(bkgBookingInfoVO.getEurTroCfm())){
							eventResponse.setETCData("eur_tro", bkgBookingInfoVO.getEurTroCfm());
						}
						
						if(blCustomerInfoVO != null && blCustomerInfoVO.getSCustCntCd() != null && "KR".equals(blCustomerInfoVO.getSCustCntCd())){
							String obDmt = dmtBC.searchBookingChargeOB(event.getBkgBlNoVO().getBkgNo()); 
							if(obDmt != null && obDmt.length() > 0){
								eventResponse.setETCData("ob_dmt", obDmt);
							}else{
								eventResponse.setETCData("ob_dmt", "");
							}
						}else{
							eventResponse.setETCData("ob_dmt", "");
						}
						
						//Origin,Dest 장비 상황 표시
						List<SearchEMUPfmcListVO> searchEMUPfmcListVOs = null;
						SearchEMUPfmcListVO searchEMUPfmcListVO = new SearchEMUPfmcListVO();
						SearchConditionVO searchConditionVO = new SearchConditionVO();
						
						int bkgCreYr  = Integer.parseInt(bkgBookingInfoVO.getBkgCreDt().substring(0, 4));
						int bkgCreMon = Integer.parseInt(bkgBookingInfoVO.getBkgCreDt().substring(4, 6));
						String costYrMon = "";
						if(bkgCreMon > 11){
							costYrMon = Integer.toString(bkgCreYr).concat(Integer.toString(bkgCreMon-1));
						}else if(bkgCreMon > 1){
							costYrMon = Integer.toString(bkgCreYr).concat("0").concat(Integer.toString(bkgCreMon-1));
						}else{
							costYrMon = Integer.toString(bkgCreYr-1).concat("12");
						}
						
						// 우선순위 D>R>SPCL, D4>D5>D2
						String fCostTp = "";
						String fCostSz = "";
						String fCostTpsz = "";
						for(int i=0; i<bookingCreationVO.getBkgQuantity().size(); i++){
							String fCostTpszTmp = bookingCreationVO.getBkgQuantity().get(i).getCntrTpszCd();
							String fCostTpTmp = fCostTpszTmp.substring(0, 1);
							String fCostSzTmp = fCostTpszTmp.substring(1, 2);
							
							if("D".equals(fCostTpTmp)){
								if(   ( "4".equals(fCostSzTmp) ) 
									||( !"4".equals(fCostSz) && "2".equals(fCostSzTmp) )
									||( !"4".equals(fCostSz) && !"2".equals(fCostSz) && "5".equals(fCostSzTmp) )
									||( !"4".equals(fCostSz) && !"2".equals(fCostSz) && !"5".equals(fCostSz) ) ){
									fCostTpsz = fCostTpszTmp;
									fCostTp = fCostTpTmp;
									fCostSz = fCostSzTmp;
								}
							}else if(!"D".equals(fCostTp) && "R".equals(fCostTpTmp)){
								if(   ( "4".equals(fCostSzTmp) ) 
									||( !"4".equals(fCostSz) && "2".equals(fCostSzTmp) )
									||( !"4".equals(fCostSz) && !"2".equals(fCostSz) && "5".equals(fCostSzTmp) )
									||( !"4".equals(fCostSz) && !"2".equals(fCostSz) && !"5".equals(fCostSz) ) ){
									fCostTpsz = fCostTpszTmp;
									fCostTp = fCostTpTmp;
									fCostSz = fCostSzTmp;
								}
							}else if(!"D".equals(fCostTp) && !"R".equals(fCostTp)){
								fCostTpsz = fCostTpszTmp;
								fCostTp = fCostTpTmp;
								fCostSz = fCostSzTmp;
							}
						}
						
						String porCostSts = "";
						String delCostSts = "";
						if(bkgBookingInfoVO.getMtyPkupYdCd() != null && bkgBookingInfoVO.getMtyPkupYdCd().length() > 4){
							searchConditionVO.setFCostYrmon(costYrMon);//YYYYMM
							searchConditionVO.setFCntrTpszCd(fCostTpsz);//D4
							searchConditionVO.setFFromEccCd(bkgBookingInfoVO.getMtyPkupYdCd().substring(0, 5));//OP ECC
							searchConditionVO.setFPodEccCd(bkgBookingInfoVO.getBkgPodCd());//POD ECC
							searchConditionVO.setFToEccCd(bkgBookingInfoVO.getBkgDelCd());//MT RTN ECC
							
							searchEMUPfmcListVOs = masBC.searchEMUPfmcList(searchEMUPfmcListVO, searchConditionVO);
							if(searchEMUPfmcListVOs != null && searchEMUPfmcListVOs.size()>0){
								porCostSts = searchEMUPfmcListVOs.get(0).getPorSts();
								delCostSts = searchEMUPfmcListVOs.get(0).getDelSts();
							}
						}
						eventResponse.setETCData("por_cost_sts", porCostSts);
						eventResponse.setETCData("del_cost_sts", delCostSts);
						
						// 2017.11.17 iylee Awkward Wgt와 Container Wgt 차이가 20% 이상나는지 체크.
						String awkOverWgtFlg = searchBC.checkAkwardOverWgtFlg(bkgBookingInfoVO.getBkgNo());
						eventResponse.setETCData("awk_over_wgt_flg", awkOverWgtFlg);
					}					
				}
			}else{
				// No data found.
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
				eventResponse.setETCData("DataYn", "N");
			}
			return eventResponse;			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}

	/**
	 * ESM_BKG_0190 : Retrieve <BR>
	 * 0190 화면 Customer Code를 조회<br>
	 * 
	 * @param e EsmBkg0190Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActualCustomer(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0190Event event = (EsmBkg0190Event)e;
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try 
		{
			List<SearchActualCustomerVO> list = command.searchActualCustomer(event.getInfoVO());
	
			eventResponse.setRsVoList(list);
			if(list.size() > 0){
				eventResponse.setETCData("from_dt", list.get(0).getFromDt());
				eventResponse.setETCData("to_dt", list.get(0).getToDt());
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		
		return eventResponse;
	}

	/**
	 * ESM_BKG_0079_01 : save <br> 
	 * Route 변경시 Booking 저장 처리.<br>
	 * 
	 * @author KimByungKyu 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createBkgWithoutRoute(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg007901Event event = (EsmBkg007901Event)e;
		ProductCatalogCreateBC  proBC     = new ProductCatalogCreateBCImpl();
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		BookingUtil             util      = new BookingUtil();		

		String pctlNo = null;
		String mapSeq = null;
		
		begin();

		// Booking 모든 정보 담는 Container VO
		BookingCreationVO bookingCreationVO = new BookingCreationVO();
		// Validation 결과 담는 VO
		BookingSaveValidationVO bookingSaveValidationVO = event.getBookingSaveValidationVO();
		PrdParameterVO prdParameterVO = null;
				
		bookingCreationVO.setBkgBookingInfoVO(event.getBkgBookingInfoVO());
		bookingCreationVO.setVslSkdVOs(event.getVslSkdVOs());
		bookingCreationVO.setBkgBlNoVO(event.getBkgBlNoVO());
		bookingCreationVO.setBlCustomerInfoVO(event.getBlCustomerInfoVO());
		bookingCreationVO.setBkgQuantityVOs(event.getBkgQuantityVOs());
		bookingCreationVO.setBkgQtyDtlVOs(event.getBkgQtyDtlVOs());
		bookingCreationVO.setBookingSaveValidationVO(bookingSaveValidationVO);
		
		// 03. createProdCtlRout 
		String prdLog = "";
		try{
			/************* findFullRoute *******************/
			prdParameterVO = util.findFullRoute(bookingCreationVO);
			prdLog = util.prdParameterLog(prdParameterVO.getPrdMainInfoVO());
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
		
		try{
			String pctlNoMapSeqStr = proBC.createPrdCtlgRout(prdParameterVO, account);

			String [] pctlNoMapSeq = util.splitByToken(pctlNoMapSeqStr, "|");
			pctlNo = pctlNoMapSeq[0];
			mapSeq = pctlNoMapSeq[1];
		} catch (Exception pc_ex){
			eventResponse.setETCData("IsPctlNoPop", "YC");	
			rollback();	
			log.debug("Pctl Pop Up Call");
			if(pc_ex.getMessage().indexOf("PRD00058") < 0 			//Not Available M'ty Pick Up Date
					&& pc_ex.getMessage().indexOf("PRD00077") < 0){ //Created more than a single P/C
				log.error(pc_ex.getMessage() + prdLog);
			}
		}						
		
		if("YC".equals(eventResponse.getETCData("IsPctlNoPop"))){
			return eventResponse;
		}
		
		try{
			log.debug(" Pctl No : [" + pctlNo + "]");			
			// 화면에서 PctlNo가 넘어오면 다음단계로 넘어가고 없으면 findFullRoute 결과값을 확인하여 PctlNo가 없으면 ESD_PRD_018 화면을 띄우고 있으면 다음단계로 진행한다.
			if(pctlNo != null && pctlNo.length() > 0 && !"FAIL".equals(pctlNo)){
				bookingCreationVO.getBkgBlNoVO().setPctlNo(pctlNo);	
				bookingCreationVO.getBkgBlNoVO().setMapSeq(mapSeq);	
			}else{
				eventResponse.setETCData("IsPctlNoPop", "YC");
				
				log.debug("Pctl Pop Up Call");
				rollback();
				return eventResponse;				
			}
			commit();
				
			/********   createBkgWithRoute  ************/
			bookingCreationVO = createBkgInfo(bookingCreationVO);
			if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCloseBkgFlag())){
				rollback();
				eventResponse.setETCData("closeBkgFlag", "Y");
				eventResponse.setETCData("first_vvd", bookingCreationVO.getBookingSaveValidationVO().getChangeFirstVvd());
				eventResponse.setETCData("closeBkgMsg", bookingCreationVO.getBookingSaveValidationVO().getCloseBkgMsg());
			} else if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getTsCloseBkgFlag())){
				rollback();
				eventResponse.setETCData("tsCloseBkgFlag", "Y");
				eventResponse.setETCData("closedVvds", bookingCreationVO.getBookingSaveValidationVO().getClosedTsVvd());
			} else if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCbfBkgFlag())){
					rollback();
					eventResponse.setETCData("cbfBkgFlag", "Y");
					eventResponse.setETCData("first_vvd", bookingCreationVO.getBookingSaveValidationVO().getChangeFirstVvd());
					eventResponse.setETCData("closeBkgMsg", bookingCreationVO.getBookingSaveValidationVO().getCloseBkgMsg());
			} else {
				eventResponse.setETCData(bookingCreationVO.getBkgBookingInfoVO().getColumnValues());				
				eventResponse.setETCData("ResultMsg", bookingCreationVO.getBookingSaveValidationVO().getSaveMsg());
				eventResponse.setETCData("aloc_pop_flg", bookingCreationVO.getBookingSaveValidationVO().getAlocPopFlg());
				eventResponse.setETCData("firm_msg_flg", bookingCreationVO.getBookingSaveValidationVO().getFirmMsgFlg());
				
				String resultMsg = bookingCreationVO.getBookingSaveValidationVO().getSaveMsg();
				if(resultMsg != null && resultMsg.length() > 0 ){
					if(resultMsg.startsWith(",")){
						resultMsg = resultMsg.substring(1, resultMsg.length());
					}
					StringTokenizer st = new StringTokenizer(resultMsg, ",");
					while(st.hasMoreTokens()){
						eventResponse.setUserMessage(new ErrorHandler(st.nextToken()).getUserMessage());
					}
				}			
				eventResponse.setETCData("closeBkgFlag", "N");
				eventResponse.setETCData("tsCloseBkgFlag", "N");
				eventResponse.setETCData("cbfBkgFlag", "N");
				eventResponse.setETCData("SuccessYn", "Y");
				
				// PSA 전송시 오류 Code가 있는 경우에 보내주도록 함.
				eventResponse.setETCData("psaValCode", bookingCreationVO.getPsaValCode());
			}
			
			// Manual 로 full return CY 입력하는 베트남 케이스는 최초 생성 시 공란
			receiptBC.modifyFullRtnCy(bookingCreationVO.getBkgBlNoVO());
			
		}catch(EventException ex){ 
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0079_01 : save <br>
	 * Route 변경없을시 Booking 저장 처리 <br>
	 * 
	 * @author KimByungKyu 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createBkgWithRoute(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg007901Event event = (EsmBkg007901Event)e;
		try{
			// Booking 모든 정보 담는 Container VO
			BookingCreationVO bookingCreationVO = new BookingCreationVO();
			BookingUtil util = new BookingUtil();
			GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
			// Validation 결과 담는 VO
			BookingSaveValidationVO bookingSaveValidationVO = event.getBookingSaveValidationVO();
			
			bookingCreationVO.setBkgBookingInfoVO(event.getBkgBookingInfoVO());
			bookingCreationVO.setVslSkdVOs(event.getVslSkdVOs());
			bookingCreationVO.setBkgBlNoVO(event.getBkgBlNoVO());
			bookingCreationVO.setBlCustomerInfoVO(event.getBlCustomerInfoVO());
			bookingCreationVO.setBkgQuantityVOs(event.getBkgQuantityVOs());
			bookingCreationVO.setBkgQtyDtlVOs(event.getBkgQtyDtlVOs());
			bookingCreationVO.setBookingSaveValidationVO(bookingSaveValidationVO);
			//pctlNo set
			String [] pctlNoMapSeq = util.splitByToken(event.getPctlNo(), "|");
			bookingCreationVO.getBkgBlNoVO().setPctlNo(pctlNoMapSeq[0]);
			bookingCreationVO.getBkgBlNoVO().setMapSeq(pctlNoMapSeq[1]);
			
			bookingCreationVO = createBkgInfo(bookingCreationVO);

			if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCloseBkgFlag())){
				rollback();
				eventResponse.setETCData("closeBkgFlag", "Y");
				eventResponse.setETCData("first_vvd", bookingCreationVO.getBookingSaveValidationVO().getChangeFirstVvd());
				eventResponse.setETCData("closeBkgMsg", bookingCreationVO.getBookingSaveValidationVO().getCloseBkgMsg());
			} else if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getTsCloseBkgFlag())){
				rollback();
				eventResponse.setETCData("tsCloseBkgFlag", "Y");
				eventResponse.setETCData("closedVvds", bookingCreationVO.getBookingSaveValidationVO().getClosedTsVvd());
			} else if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCbfBkgFlag())){
				rollback();
				eventResponse.setETCData("cbfBkgFlag", "Y");
				eventResponse.setETCData("first_vvd", bookingCreationVO.getBookingSaveValidationVO().getChangeFirstVvd());
				eventResponse.setETCData("closeBkgMsg", bookingCreationVO.getBookingSaveValidationVO().getCloseBkgMsg());
			} else {
				eventResponse.setETCData(bookingCreationVO.getBkgBookingInfoVO().getColumnValues());				
				eventResponse.setETCData("ResultMsg", bookingCreationVO.getBookingSaveValidationVO().getSaveMsg());	
				eventResponse.setETCData("aloc_pop_flg", bookingCreationVO.getBookingSaveValidationVO().getAlocPopFlg());
				eventResponse.setETCData("firm_msg_flg", bookingCreationVO.getBookingSaveValidationVO().getFirmMsgFlg());
	
				String resultMsg = bookingCreationVO.getBookingSaveValidationVO().getSaveMsg();
				if(resultMsg != null && resultMsg.length() > 0 ){
					if(resultMsg.startsWith(",")){
						resultMsg = resultMsg.substring(1, resultMsg.length());
					}
					StringTokenizer st = new StringTokenizer(resultMsg, ",");
					while(st.hasMoreTokens()){
						eventResponse.setUserMessage(new ErrorHandler(st.nextToken()).getUserMessage());
					}
				}			
				eventResponse.setETCData("closeBkgFlag", "N");
				eventResponse.setETCData("tsCloseBkgFlag", "N");
				eventResponse.setETCData("cbfBkgFlag", "N");
				eventResponse.setETCData("SuccessYn", "Y");		
				
				// PSA 전송시 오류 Code가 있는 경우에 보내주도록 함.
				eventResponse.setETCData("psaValCode", bookingCreationVO.getPsaValCode());
			}
			
			// Manual 로 full return CY 입력하는 베트남 케이스는 최초 생성 시 공란
			receiptBC.modifyFullRtnCy(bookingCreationVO.getBkgBlNoVO());
						
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
		return eventResponse;
	}

	/**
	 * createBkgWithoutRoute(), createBkgWithRoute()에서 실행 <br>
	 * Booking을 생성한다.<br>
	 * 
	 * @author 	KimByungKyu
	 * @param 	BookingCreationVO bookingCreationVO
	 * @return 	BookingSaveValidationVO
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private BookingCreationVO createBkgInfo(BookingCreationVO bookingCreationVO) throws EventException {
		try{
			begin();
			GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
			GeneralBookingSearchBC	searchBC 	= new GeneralBookingSearchBCImpl();
			BLDocumentationCMBC 	blDocBC 	= new BLDocumentationCMBCImpl();
			BLDocumentationBLBC 	blDocBLBC 	= new BLDocumentationBLBCImpl();
			BookingMasterMgtBC 		masterBC 	= new BookingMasterMgtBCImpl();		
			BlRatingBC				rateBC		= new BlRatingBCImpl();
			BookingUtil 			util 		= new BookingUtil();		
			BookingHistoryMgtBC 	historyBC 	= new BookingHistoryMgtBCImpl();
			
			BkgCopManageBC 			copBc 		= new BkgCopManageBCImpl();
			
			// 01. validateBookingSave
			log.debug("createBkgInfo : pctl_no : " + bookingCreationVO.getBkgBlNoVO().getPctlNo());
			bookingCreationVO = receiptBC.validateBookingSave(bookingCreationVO, account);
			
			BookingSaveValidationVO bookingSaveValidationVO = bookingCreationVO.getBookingSaveValidationVO();
						
			// 20100204 Bkg Close 여부 확인
			if("Y".equals(bookingSaveValidationVO.getCloseBkgFlag())){
				return bookingCreationVO;
			}
			if("Y".equals(bookingSaveValidationVO.getTsCloseBkgFlag())){
				return bookingCreationVO;
			}
			if("Y".equals(bookingSaveValidationVO.getCbfBkgFlag())){
				return bookingCreationVO;
			}
			
			BkgBlNoVO 		 bkgBlNoVO 		  = bookingCreationVO.getBkgBlNoVO();
			BkgBookingInfoVO bkgBookingInfoVO = bookingCreationVO.getBkgBookingInfoVO();
			
			String bkgNo = null;
			// 02. Booking Number 생성(ManualBooking인 경우)
			if(!"Y".equals(bkgBookingInfoVO.getMnlBkgNoFlg())){
				BkgBlNoVO newBkgNoVO = util.manageBkgNumberGeneration("BKG", account.getOfc_cd(), account.getUsr_id());
				
				bkgNo = newBkgNoVO.getBkgNo()+"00";
				bkgBlNoVO.setBkgNo(bkgNo);
			} else {
				bkgNo = bkgBlNoVO.getBkgNo();
				// agent manual booking no 채번 table에 bkg이 생성되었음을 기록한다.(없어도 그냥 진행)
				List<BkgChnBkgNoGenVO> bkgChnBkgNoGenVO = new ArrayList<BkgChnBkgNoGenVO>();
				bkgChnBkgNoGenVO.add(new BkgChnBkgNoGenVO());
				bkgChnBkgNoGenVO.get(0).setBkgNo(bkgNo);
				masterBC.modifyChnBkgNoUseFlgOnList(bkgChnBkgNoGenVO, bkgBookingInfoVO.getBkgPorCd(), account);
			}
			
			bkgBlNoVO.setBlNo(bkgNo);
			bkgBookingInfoVO.setBkgNo(bkgNo);
			//임시로 기 배포된 11자리 manual bkg no는 bl no를 새로 채번
			if(bkgNo.length()==11 && "Y".equals(bkgBookingInfoVO.getMnlBkgNoFlg())){ 
				BkgBlNoVO newBkgNoVO = util.manageBkgNumberGeneration("BKG", account.getOfc_cd(), account.getUsr_id());
				bkgBookingInfoVO.setBlNo(newBkgNoVO.getBkgNo()+"00");
			} else {
				bkgBookingInfoVO.setBlNo(bkgNo);
			}
			bookingCreationVO.setBkgBlNoVO(bkgBlNoVO);
			bookingCreationVO.setBkgBookingInfoVO(bkgBookingInfoVO);

			// 03. createBooking
			receiptBC.createBooking(bookingCreationVO, account);
			
			// 04. createBkgBlDocByBKG
			CreateBkgBlDocBkgVO createBkgBlDocBkgVO = new CreateBkgBlDocBkgVO();
			createBkgBlDocBkgVO.setBkgNo(bkgBlNoVO.getBkgNo());    
			createBkgBlDocBkgVO.setBlMvTpNm(bookingSaveValidationVO.getBlMoveTpNm());
			createBkgBlDocBkgVO.setFnlDestNm("");
			createBkgBlDocBkgVO.setActWgt(bkgBookingInfoVO.getActWgt());			
			createBkgBlDocBkgVO.setWgtUtCd(bkgBookingInfoVO.getWgtUtCd());
			
//			blDocBC.createBkgBlDocByBKG(bkgBlNoVO.getBkgNo(), 
//										bookingSaveValidationVO.getBlMoveTpNm(),
//										"",
//										bkgBookingInfoVO.getActWgt(), 
//										bkgBookingInfoVO.getWgtUtCd(),  account);
			
			blDocBC.createBkgBlDocByBKG(createBkgBlDocBkgVO,  account);
			
			// VNSGN -> KNPNH 에 대해 BL Clause 자동 문구 삽입 요청
			List<VslSkdVO> routeDetails = receiptBC.searchVvdSkdForTsRoute(bkgBlNoVO);
			if(routeDetails.get(routeDetails.size() - 1).getPolCd().equals(Constants.BL_CLAUSE_POL)
					&& routeDetails.get(routeDetails.size() - 1).getPodCd().equals(Constants.BL_CLAUSE_POD)){
				BLDocumentationBLBC blBC = new BLDocumentationBLBCImpl();
				MndVO mndVO = new MndVO();
				mndVO.setBkgNo(bkgBlNoVO.getBkgNo());
				blBC.manageMndCmdtDescKHPNH(mndVO, account, "N");
			}
			
			receiptBC.modifyKrCstmsCustTpCd(bkgBlNoVO,"CRE");//[CHM-201429314] 2014.05.26 일본 세관 사전신고제를 위한 Simple/Console default 적용 로직 추가
			
			// Allocation Status 
			AllocStsChgVO allocStsChgVO = null;
			if("US".equals(bkgBookingInfoVO.getBkgPolCd().substring(0,2))
					|| "CA".equals(bkgBookingInfoVO.getBkgPolCd().substring(0,2))){
				if(!"Y".equals(bookingSaveValidationVO.getCaNewCreationFlag())){
					
					allocStsChgVO = receiptBC.manageAlocStatus(bkgBlNoVO, account, "");
					List<BkgNtcHisVO> bkgNtcHisVOs = allocStsChgVO.getBkgNtcHisVOs();
					if (null!=bkgNtcHisVOs) {
						historyBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0079_01");
					}
					bookingSaveValidationVO.setAlocPopFlg(allocStsChgVO.getAlocPopFlg());
					bookingSaveValidationVO.setFirmMsgFlg(allocStsChgVO.getFirmMsgFlg());
				}
			}// Allocation Status History 는 아래에

			if("Y".equals(bookingSaveValidationVO.getCaNewCreationFlag())){
				BLDocumentationBLBC 	blBC 	= new BLDocumentationBLBCImpl();
				blBC.modifyBKGBDR(bkgNo, "Y", "N", account.getUsr_id());
				add1stCaHist(bkgBlNoVO);

				BkgCorrectionVO bkgCorrectionVO = new BkgCorrectionVO();
				bkgCorrectionVO.setNewBkgCreFlg("Y");
				bkgCorrectionVO.setCaRsnCd   (bookingSaveValidationVO.getCaRsnCd());
				bkgCorrectionVO.setBkgCorrRmk(bookingSaveValidationVO.getCaRemark());
				
				BDRCorrectionBC bdrBC = new BDRCorrectionBCImpl();
				bdrBC.addAutoCaTemp(bkgBlNoVO, "CA_NEW", bkgCorrectionVO, account);

				BkgBlNoVO corrBkgBlNoVO = addCaHistory(bookingSaveValidationVO.getCaRsnCd(),
														bookingSaveValidationVO.getCaRemark(), bkgBlNoVO, "N", "Y");
				bkgBlNoVO.setCaNo(corrBkgBlNoVO.getCaNo());
				
				bdrBC.removeCATemp(bkgBlNoVO);	
				// 05. createBkgHistoryLine
				HistoryLineVO historyLineVO = new HistoryLineVO();
				historyLineVO.setBkgNo(bkgNo);
				historyLineVO.setCorrNo(corrBkgBlNoVO.getCaNo());				
				historyLineVO.setBkgDocProcTpCd("BKGCRE");
				historyLineVO.setUiId("ESM_BKG_0079_01");
				historyLineVO.setCrntCtnt("Booking Created. (Offline)");
				historyLineVO.setHisCateNm("Booking Creation"); 
				
				historyBC.createBkgHistoryLine(historyLineVO, account);
			} else {
				// 09. Booking Status 변경
				receiptBC.changeBkgStatus("Y", bkgBlNoVO, false, account);
				
				// 05. createBkgHistoryLine
				HistoryLineVO historyLineVO = new HistoryLineVO();
				historyLineVO.setBkgNo(bkgNo);
				historyLineVO.setCaFlg("N");
				historyLineVO.setBkgDocProcTpCd("BKGCRE");
				historyLineVO.setUiId("ESM_BKG_0079_01");
				historyLineVO.setCrntCtnt("Booking Created. (Offline)");
				historyLineVO.setHisCateNm("Booking Creation"); 
				
				historyBC.createBkgHistoryLine(historyLineVO, account);
			}
			
			// Allocation Status History 
			if(allocStsChgVO != null){
				HistoryLineVO historyLineVO = new HistoryLineVO();
				historyLineVO.setUiId("ESM_BKG_0079_01");			
				historyLineVO.setHisCateNm("Booking Status");
				historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
				historyLineVO.setCaFlg("N");
				if (allocStsChgVO == null || allocStsChgVO.getAlocStsCd() == null){
					log.debug("Null Check");
				} else if ((allocStsChgVO.getOriAlocStsCd() == null || "".equals(allocStsChgVO.getOriAlocStsCd())) && "S".equals(allocStsChgVO.getAlocStsCd())){
					historyLineVO.setCrntCtnt("Allocation Status change to S");
					historyBC.createBkgHistoryLine(historyLineVO, account);
				} else if ((allocStsChgVO.getOriAlocStsCd() == null || "".equals(allocStsChgVO.getOriAlocStsCd())) && "F".equals(allocStsChgVO.getAlocStsCd())){
					historyLineVO.setCrntCtnt("Allocation Status change to F");
					historyBC.createBkgHistoryLine(historyLineVO, account);	
				} else if ( "F".equals(allocStsChgVO.getOriAlocStsCd()) && "S".equals(allocStsChgVO.getAlocStsCd()) ){
					historyLineVO.setCrntCtnt("Allocation Status change F to S");
					historyBC.createBkgHistoryLine(historyLineVO, account);
				} else if ( "S".equals(allocStsChgVO.getOriAlocStsCd()) && "F".equals(allocStsChgVO.getAlocStsCd()) ){
					historyLineVO.setCrntCtnt("Allocation Status change S to F");
					historyBC.createBkgHistoryLine(historyLineVO, account);
				}
			}
			// Allocation Status History 끝
			
			//dummy가 아닌 sc나 rfa, taa가 입력되었을 때  
			if((bkgBookingInfoVO.getScNo().length()>0 &&!"DUM".equals(bkgBookingInfoVO.getScNo().substring(0, 3)))
					||(bkgBookingInfoVO.getRfaNo().length()>0 &&!"DUM".equals(bkgBookingInfoVO.getRfaNo().substring(0, 3)))
					||(bkgBookingInfoVO.getTaaNo().length()>0 &&!"DUM".equals(bkgBookingInfoVO.getTaaNo().substring(0, 3)))){		
				BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
				bkgDocProcSkdVO.setBkgNo(bkgNo);
				bkgDocProcSkdVO.setBkgDocProcTpCd("CTRTNO");// contract no input for doc performance
				historyBC.manageDocProcess(bkgDocProcSkdVO, account);

				if(bkgBookingInfoVO.getBkgPodCd().equals("JOAQJ")
						||bkgBookingInfoVO.getBkgDelCd().equals("JOAQJ")){					
					blDocBLBC.manageMndCmdtDescJOAQJ(bkgBlNoVO.getBkgNo(), account, bkgBlNoVO.getCaFlg());
				}
			}
			
			// 최초 생성시 cnee input
			if(!isNull(bookingCreationVO.getBlCustomerInfoVO().getCCustCntCd())
					&& !isNull(bookingCreationVO.getBlCustomerInfoVO().getCCustSeq())){
				BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
				bkgDocProcSkdVO.setBkgNo(bkgNo);
				bkgDocProcSkdVO.setBkgDocProcTpCd("CNEIPT");// consignee no input for doc performance				
				historyBC.manageDocProcess(bkgDocProcSkdVO, account);
			} 											

			if(bookingSaveValidationVO.getScpFromCtrt() != null && bookingSaveValidationVO.getScpFromCtrt().length() > 0){
				BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
				bkgDocProcSkdVO.setBkgNo(bkgBlNoVO.getBkgNo());
				bkgDocProcSkdVO.setBkgDocProcTpCd("SCPCTR");// select service scope from contract
				historyBC.manageDocProcess(bkgDocProcSkdVO, account);
			}
			
			rateBC.createRateForTro(bkgNo,"N", account);
			
			searchBC.searchXterBkg(bkgNo);
			
			PerformanceReportBC performReportBc = new PerformanceReportBCImpl();
			performReportBc.manageQtyCntrCoposite(bkgBlNoVO.getBkgNo(), "CQ");
			
			// 09. createBkg(타 모듈 호출)
			log.debug("TO COP bkg no : " + bkgNo + ", pctl_no : " + bkgBlNoVO.getPctlNo());
			copBc.createBkg(bkgNo, bkgBlNoVO.getPctlNo());
			
			// 10. interfaceCoa ,Standby 계산 뒤로 이동
//			interfaceToMas(bkgBlNoVO, "Booking Create", account);
			commit();
			
			// cut off time (cop 생성 이후에 처리)
			try{
				String fromDt = null;
				String toDt = null;
				
				if("US".equals(bkgBookingInfoVO.getBkgPorCd().substring(0, 2))
						|| "CA".equals(bkgBookingInfoVO.getBkgPorCd().substring(0, 2))){
					BkgQuantityVO[] bkgQuantityVOs = bookingCreationVO.getBkgQuantityVOs();
					PrdQtyInfoVO[] prdQtyInfo 	= new PrdQtyInfoVO[bkgQuantityVOs.length];
					
					for(int i = 0 ; i < bkgQuantityVOs.length ; i++){	
						prdQtyInfo[i] = new PrdQtyInfoVO();				
						prdQtyInfo[i].setCTpsz(bkgQuantityVOs[i].getCntrTpszCd());
						prdQtyInfo[i].setCQty(bkgQuantityVOs[i].getOpCntrQty());				
					}

					ProductCatalogCreateBC prdBC = new ProductCatalogCreateBCImpl();
					Map railTime = prdBC.getRailRecevingTime(bkgBlNoVO.getPctlNo(), prdQtyInfo, null, null,bkgBlNoVO.getBkgNo());

					fromDt= (String)railTime.get("RTN_TIME");
					toDt  = (String)railTime.get("CUT_OFF");					
				}
				begin(); //batch 서버 접속해야되서 Transaction을 분리함			
				receiptBC.createCargoClosingTime(bkgBlNoVO, fromDt, toDt, account);
				commit();			
			} catch(Exception prdEx){
				log.error("err rail time:"+prdEx.toString(),prdEx);
			}
			
			// 2014.09.24 [CHM-201431658] 한진해운 조기결산을 위한 개선 방안 중 BKG 관리 프로세스 단축(안) 개발(S)
			String oldNoRtStsCd = "";
			String newNoRtStsCd = "";
			String noRtNtc_snd_flg = "N";
			String noRtNtc_snd_cust_flg = "N";
			String sc_no = bookingCreationVO.getBkgBookingInfoVO().getScNo();
			String rfa_no = bookingCreationVO.getBkgBookingInfoVO().getRfaNo();
			String taa_no = bookingCreationVO.getBkgBookingInfoVO().getTaaNo();
			OftPrecheckVO oftPrecheckVO = new OftPrecheckVO();
			try{//기존 별도 트랜젝션으로 화면에서 호출 하던 부분	
				begin();
				if(rfa_no!=null && rfa_no.length() > 2 ){
					oftPrecheckVO = searchRfaOftPrecheckResult(bkgBlNoVO, rfa_no, account);
				}else if(sc_no!=null && sc_no.length() > 2 ){
					oftPrecheckVO = searchScOftPrecheckResult(bkgBlNoVO, sc_no, account);
				}else if(taa_no!=null && taa_no.length() > 2 ){
					oftPrecheckVO = searchTaaOftPrecheckResult(bkgBlNoVO, taa_no, account);
				}else{
					oftPrecheckVO.setNonRtStsCd("R");
					oftPrecheckVO.setChkOft("");
					oftPrecheckVO.setApplicationDt("");
					oftPrecheckVO.setFrtTermCd("");
					oftPrecheckVO.setSvcScpCd("");
				}
			}catch(EventException ex){
				log.error("No Rate Status check Error : "+bkgBlNoVO.getBkgNo(), ex);
				oftPrecheckVO.setNonRtStsCd("");
				oftPrecheckVO.setChkOft("");
				oftPrecheckVO.setApplicationDt("");
				oftPrecheckVO.setFrtTermCd("");
				oftPrecheckVO.setSvcScpCd("");
			}

			// CMPB 산출
			try{
				if("Y".equals(oftPrecheckVO.getChkOft()) ){
					BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
					bkgHrdCdgCtntListCondVO.setHrdCdgId("NO_RATE_PROC_CTR");			
					List<BkgHrdCdgCtntVO> BkgHrdCdgCtntVOs = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
					
					String createCmpb = "";
					if(BkgHrdCdgCtntVOs.size() > 0){
						createCmpb = BkgHrdCdgCtntVOs.get(0).getAttrCtnt3();// BKG create CMPB 생성
					}
					if(!"N".equals(createCmpb)){
						//createContributionMarginPerBox(bkgBlNoVO);
						// 2015.12.03 [CHM-201538812] MAS time out 방지위해 1,2 로 나눔
						BkgCmpbVO BkgCmpbVO = createContributionMarginPerBox1(bkgBlNoVO, oftPrecheckVO);
						commit();
						begin();
						createContributionMarginPerBox2(bkgBlNoVO,BkgCmpbVO);
					}
				}
				commit();
			}catch(EventException ex){
				log.error("create CMPB Error : "+bkgBlNoVO.getBkgNo(), ex);
				rollback();
			}
			
			// No Rate Status 업데이트
			if(oftPrecheckVO!=null && oftPrecheckVO.getNonRtStsCd()!=null && !oldNoRtStsCd.equals(oftPrecheckVO.getNonRtStsCd())){
				begin();
				newNoRtStsCd = oftPrecheckVO.getNonRtStsCd();
				//no_rt_sts_cd Update
				int updCnt = receiptBC.modifyNoRtStsCd(bkgBlNoVO, newNoRtStsCd, account);
				//Create엔 History 불필요 -> 유저 요청으로 생성시에도 History 남김
				if(updCnt > 0){
					HistoryLineVO historyLineVO = new HistoryLineVO();
					historyLineVO.setUiId("ESM_BKG_0079_01");			
					historyLineVO.setHisCateNm("No Rate Status");
					historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
					historyLineVO.setCaFlg(bkgBlNoVO.getCaFlg());
					historyLineVO.setPreCtnt(oldNoRtStsCd);
					historyLineVO.setCrntCtnt(newNoRtStsCd);
					historyBC.createBkgHistoryLine(historyLineVO, account);
					
					//Reciept Notice 는 Allocation Status 까지 확인 후 발송 (메일 발송은 commit 이후)
					//-> !R : Reciept Notice
					//->  R : No Rate Notice
					if("R".equals(oftPrecheckVO.getNonRtStsCd())){
						noRtNtc_snd_flg = "Y";// (메일 발송은 commit 이후)
					}
					String noRtNtcForCust = searchBC.searchNoRateNoticeToCustomerBlock(bkgBlNoVO);
					if("N".equals(noRtNtcForCust)){
						noRtNtc_snd_cust_flg = "Y";// NoRateNotice to Customer
					
						BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
						bkgDocProcSkdVO.setBkgNo(bkgBlNoVO.getBkgNo());
						bkgDocProcSkdVO.setBkgDocProcTpCd("NORTNC");//NoRateNoticeForCustomer
						historyBC.manageDocProcess(bkgDocProcSkdVO, account);	
					}
				}
				commit();
			}

			// SPC-BKG 연동 (NoRateStatus Firm 일 때만 SPC Aloc 체크)
			String alocPopFlg = "";
			if("F".equals(oldNoRtStsCd) || "F".equals(newNoRtStsCd)){
				ConstraintMasterBC		spcBC = new ConstraintMasterBCImpl();	
				List<SpcSbBkgDtlVO> spcSbBkgDtlVO = new ArrayList<SpcSbBkgDtlVO>();
				boolean spcErrFlg = false;
				try{
					begin();
					spcSbBkgDtlVO = spcBC.standbyCheck4Bkg(bkgBlNoVO.getBkgNo(), account);
					commit();
				} catch(Exception spcEx){
					rollback();
					log.error("SPC Allocation error : " + spcEx.toString(), spcEx);
					spcErrFlg = true;
				}
				begin();
				if(spcErrFlg){
					//Error
					AllocStsVO allocStsVO = new AllocStsVO();
					allocStsVO.setAlocStsCd("");
					AllocStsChgVO allocStsChgVO2 = receiptBC.modifyAllocStatusForBkg(bkgBlNoVO, allocStsVO, account);
					// history
					HistoryLineVO historyLineVO = new HistoryLineVO();
					historyLineVO.setUiId("ESM_BKG_0079_01");			
					historyLineVO.setHisCateNm("Allocation Status");
					historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
					historyLineVO.setCaFlg("N");
					historyLineVO.setCrntCtnt("Error");
					historyLineVO.setPreCtnt(allocStsChgVO2.getOriAlocStsCd());
					historyBC.createBkgHistoryLine(historyLineVO, account);
					
				}else if(spcSbBkgDtlVO == null || spcSbBkgDtlVO.size()==0){
					//F
					AllocStsVO allocStsVO = new AllocStsVO();
					allocStsVO.setAlocStsCd("F");
					AllocStsChgVO allocStsChgVO2 = receiptBC.modifyAllocStatusForBkg(bkgBlNoVO, allocStsVO, account);
					// history
					if(!allocStsChgVO2.getAlocStsCd().equals(allocStsChgVO2.getOriAlocStsCd())){
						HistoryLineVO historyLineVO = new HistoryLineVO();
						historyLineVO.setUiId("ESM_BKG_0079_01");			
						historyLineVO.setHisCateNm("Allocation Status");
						historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
						historyLineVO.setCaFlg("N");
						historyLineVO.setCrntCtnt("F");
						historyLineVO.setPreCtnt(allocStsChgVO2.getOriAlocStsCd());
						historyBC.createBkgHistoryLine(historyLineVO, account);
					}
					if(allocStsChgVO2.getBkgNtcHisVOs().size()>0){
						historyBC.createBkgNtcHis(allocStsChgVO2.getBkgNtcHisVOs(), "ESM_BKG_0079_01");
					}
				}else if(spcSbBkgDtlVO != null && spcSbBkgDtlVO.size()>0){
					AllocStsVO allocStsVO = new AllocStsVO();
					for(int i=0; i<spcSbBkgDtlVO.size(); i++){
 						if(spcSbBkgDtlVO.get(i).getAlocSvcCd()!=null && "M".equals(spcSbBkgDtlVO.get(i).getAlocSvcCd())){
 							alocPopFlg = "Y";
 							allocStsVO.setAlocSvcCd("M");
 						}
 					}
//					if(!"US".equals(bkgBookingInfoVO.getBkgPolCd().substring(0,2))
//							&& !"CA".equals(bkgBookingInfoVO.getBkgPolCd().substring(0,2))){
//						allocStsVO.setAlocStsCd("A");
//					}else{
						allocStsVO.setAlocStsCd("S");
//						if(!"Y".equals(alocPopFlg)){ 
//							allocStsVO.setStandbyNtcFlg("Y");
//						}
//					}
					AllocStsChgVO allocStsChgVO2 = receiptBC.modifyAllocStatusForBkg(bkgBlNoVO, allocStsVO, account);
					// history
					if(!allocStsChgVO2.getAlocStsCd().equals(allocStsChgVO2.getOriAlocStsCd())){
						StringBuffer tmpBuffer = new StringBuffer(allocStsVO.getAlocStsCd());
						for(int i=0; i<spcSbBkgDtlVO.size(); i++){
							tmpBuffer.append("\n");
							tmpBuffer.append((spcSbBkgDtlVO.get(i).getLstSbRsnTpCd()==null)?"":spcSbBkgDtlVO.get(i).getLstSbRsnTpCd()).append("/");
							tmpBuffer.append((spcSbBkgDtlVO.get(i).getLstSbSubRsnCd()==null)?"":spcSbBkgDtlVO.get(i).getLstSbSubRsnCd()).append("/");
							tmpBuffer.append((spcSbBkgDtlVO.get(i).getAlocSvcCd()==null)?"":spcSbBkgDtlVO.get(i).getAlocSvcCd()).append("/");
							tmpBuffer.append((spcSbBkgDtlVO.get(i).getLstSbRsn()==null)?"":spcSbBkgDtlVO.get(i).getLstSbRsn());
						}
						HistoryLineVO historyLineVO = new HistoryLineVO();
						historyLineVO.setUiId("ESM_BKG_0079_01");			
						historyLineVO.setHisCateNm("Allocation Status");
						historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
						historyLineVO.setCaFlg("N");
						historyLineVO.setCrntCtnt(tmpBuffer.toString());
						historyBC.createBkgHistoryLine(historyLineVO, account);
						
						bookingSaveValidationVO.setAlocPopFlg(alocPopFlg);
						bookingSaveValidationVO.setFirmMsgFlg(allocStsChgVO2.getFirmMsgFlg());
					}
					if(allocStsChgVO2.getBkgNtcHisVOs().size()>0){
						historyBC.createBkgNtcHis(allocStsChgVO2.getBkgNtcHisVOs(), "ESM_BKG_0079_01");
					}
				}
				commit();
			}
			// 10. interfaceCoa ,Standby 계산 뒤로 이동
			begin();
			interfaceToMas(bkgBlNoVO, "Booking Create", account);
			commit();
			
			// SPC-BKG 연동 (NoRateStatus Firm 일 때만 SPC Aloc 체크)(E)
			//(E)
			begin();
			// No Rate Notice 발송
			//  -> !R : Reciept Notice
			//  ->  R : No Rate Notice
			if("R".equals(oftPrecheckVO.getNonRtStsCd())){
				List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
				BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
				String sndId = null;
				Mail mail = null;
				String mailContents = null;
				
				String ssoTargetUrl = JSPUtil.getNull(SiteConfigFactory.get("COM.HANJIN.SSO.TARGET"));
				boolean isLive = false;     // Live 여부
				if (ssoTargetUrl.indexOf("alps.smlines.com") > 0) {
					// 2017.04.10 iylee No Rate 대상이여도 메일 발송 하지 않음.
					//isLive = true;
				}
				if(isLive){
					if("Y".equals(noRtNtc_snd_cust_flg)){
						// No Rate Notice 발송 화주 (S)
						if(bkgBookingInfoVO.getBkgCntcPsonEml()!=null && !"".equals(bkgBookingInfoVO.getBkgCntcPsonEml())){
							mailContents = getNoRateNoticeToCustomer(bkgBlNoVO.getBkgNo());
							mail = new Mail();
							mail.setFrom("noreply@smlines.com");// 보내는사람
							mail.setRecipient(bkgBookingInfoVO.getBkgCntcPsonEml());// 받는사람
							//mail.setRecipient("popcorn426@cyberlogitec.com");
							String reqNo = "";
							String custRefNoCtnt = receiptBC.searchCustRefNoCtnt(bkgBlNoVO, "EBRF");
							if(custRefNoCtnt != null && custRefNoCtnt.length()>0){
								reqNo = "(Request No. "+custRefNoCtnt+")";
							}else{//BKG Request no. 없으면 BKG no.
								reqNo = "(Booking No. "+bkgBlNoVO.getBkgNo()+")";
							}
							mail.setSubject("Customer Notice "+reqNo);// 제목
							mail.setHtmlContent(mailContents);
							sndId = mail.send();// 메일전송
							//발송 history 내용 생성
							bkgNtcHisVO = new BkgNtcHisVO();
							bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
							bkgNtcHisVO.setNtcViaCd("M");
							bkgNtcHisVO.setNtcKndCd("NR"); // No Rate Notice
							bkgNtcHisVO.setNtcEml(bkgBookingInfoVO.getBkgCntcPsonEml());
							bkgNtcHisVO.setSndId(sndId);
							bkgNtcHisVO.setSndOfcCd("SYSTEM");
							bkgNtcHisVO.setSndUsrId("SYSTEM");
							bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
							bkgNtcHisVO.setCreUsrId(account.getUsr_id());
							bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
							bkgNtcHisVOs.add(bkgNtcHisVO);
							// No Rate Notice 발송 화주 (E)
						}
					}
					if("Y".equals(noRtNtc_snd_flg)){
						String srepEml = searchBC.searchSrepEml(bkgBookingInfoVO.getObSrepCd());//S.Rep e-Mail 조회
						if(srepEml != null && srepEml.length() > 0){
							// No Rate Notice 발송 S.Rep (S)
							mailContents = getNoRateNoticeToSrep(bkgBlNoVO.getBkgNo());
							mail = new Mail();
							mail.setFrom("noreply@smlines.com");// 보내는사람
							mail.setRecipient(srepEml);// 받는사람
							mail.setSubject("No rate booking Notice (Booking No . "+bkgBlNoVO.getBkgNo()+" )");// 제목
							mail.setHtmlContent(mailContents);
							sndId = mail.send();// 메일전송
							//No Rate Notice 발송 End S.Rep
							//발송 history
							bkgNtcHisVO = new BkgNtcHisVO();
							bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
							bkgNtcHisVO.setNtcViaCd("M");
							bkgNtcHisVO.setNtcKndCd("NR"); // No Rate Notice
							bkgNtcHisVO.setNtcEml(srepEml);
							bkgNtcHisVO.setSndId(sndId);
							bkgNtcHisVO.setSndOfcCd("SYSTEM");
							bkgNtcHisVO.setSndUsrId("SYSTEM");
							bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
							bkgNtcHisVO.setCreUsrId(account.getUsr_id());
							bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
							bkgNtcHisVOs.add(bkgNtcHisVO);
							// No Rate Notice 발송 S.Rep (E)
						}
					}
					// BKG Notice History 생성
					historyBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0079_01");
				}
			}
			commit();
			if(!"Y".equals(bkgBookingInfoVO.getEdiHldFlg())){
				// 07. sendBkgCustEdi(전용진수석님 호출)
				searchBC.createCustBkgReceiptEdiBackEnd(bkgBlNoVO, null, "Y", account);

				// 08. sendBkgTmlEdi(전용진수석님 호출)
				
				// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
				Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
				vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
				vender301ParamVO.setOldVvdVOs(null);
				vender301ParamVO.setOldQtyVOs(new ArrayList<BkgQuantityVO>());
				vender301ParamVO.setOldMtyPkupYdCd(null);
				vender301ParamVO.setBracCd("N");
				vender301ParamVO.setEdiKind("BT");
				vender301ParamVO.setAutoManualFlg("Y");
				searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);
				
				// 0.9 psa I/f 대상 자동 전송부분 추가함. ( 전성진수석 요청 - 2010.08.20 - Ticket ID : CHM-201005191-01 )
				if("SGSIN".equals(bkgBookingInfoVO.getBkgPolCd())){
					bookingCreationVO.setPsaValCode(this.managePSABKGAuto(bkgBookingInfoVO.getBkgNo(), bookingSaveValidationVO.getQtyModifyFlag()));
				}
			}
		}catch(EventException e){
			throw e;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);			
		}
		return bookingCreationVO;
	}

	/**
	 * ESM_BKG_0079_01 : save <br>
	 * Route 변경시 Booking 수정 처리 <br>
	 * 
	 * @author KimByungKyu 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBkgWithoutRoute(Event e) throws EventException {
		ProductCatalogCreateBC prdBC = new ProductCatalogCreateBCImpl();
		BookingUtil            util  = new BookingUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg007901Event event = (EsmBkg007901Event)e;
		try{
			// Booking 모든 정보 담는 Container VO
			BookingCreationVO bookingCreationVO = new BookingCreationVO();
			// Validation 결과 담는 VO
			BookingSaveValidationVO bookingSaveValidationVO = event.getBookingSaveValidationVO();

			bookingCreationVO.setBkgBookingInfoVO(event.getBkgBookingInfoVO());
			bookingCreationVO.setBookingSaveValidationVO(bookingSaveValidationVO);
			bookingCreationVO.setVslSkdVOs(event.getVslSkdVOs());
			bookingCreationVO.setBkgBlNoVO(event.getBkgBlNoVO());
			bookingCreationVO.setBlCustomerInfoVO(event.getBlCustomerInfoVO());
			bookingCreationVO.setBkgQuantityVOs(event.getBkgQuantityVOs());
			bookingCreationVO.setBkgQtyDtlVOs(event.getBkgQtyDtlVOs());
			
			if("Y".equals(bookingCreationVO.getBkgBlNoVO().getCaFlg()) 
					&& bookingCreationVO.getVslSkdVOs() != null 
					&& bookingCreationVO.getVslSkdVOs().length>4){
				String oldPctlNo = "Over T/S";
				bookingCreationVO.getBkgBlNoVO().setPctlNo(oldPctlNo);
				bookingCreationVO.getBkgBookingInfoVO().setPctlNo(oldPctlNo);
				bookingCreationVO = modifyBkgInfo(bookingCreationVO);
			} else {
				begin();
				/************* findFullRoute *******************/
				PrdParameterVO prdParameterVO = util.findFullRoute(bookingCreationVO);	
				String prdLog = util.prdParameterLog(prdParameterVO.getPrdMainInfoVO());
				
				// 03. createProdCtlRout 
				String pctlNo = null;
				String mapSeq = null;
				try{
					String pctlNoMapSeqStr = prdBC.createPrdCtlgRout(prdParameterVO, account);
	
					String [] pctlNoMapSeq = util.splitByToken(pctlNoMapSeqStr, "|");
					pctlNo = pctlNoMapSeq[0];
					mapSeq = pctlNoMapSeq[1];
				} catch (Exception pc_ex){
					eventResponse.setETCData("IsPctlNoPop", "YM");
					log.debug("Pctl Pop Up Call");
					if(pc_ex.getMessage().indexOf("PRD00058") < 0 			//Not Available M'ty Pick Up Date
							&& pc_ex.getMessage().indexOf("PRD00077") < 0){ //Created more than a single P/C
						log.error(pc_ex.getMessage() + prdLog);
					}
					rollback();
					return eventResponse;
				}
				
				log.debug("Event Pctl No : " + pctlNo);			
				// 화면에서 PctlNo가 넘어오면 다음단계로 넘어가고 없으면 findFullRoute 결과값을 확인하여 PctlNo가 없으면 ESD_PRD_018 화면을 띄우고 있으면 다음단계로 진행한다.
				if(pctlNo != null && pctlNo.length() > 0 && !"FAIL".equals(pctlNo)){
					bookingCreationVO.getBkgBookingInfoVO().setPctlNo(pctlNo);
					bookingCreationVO.getBkgBlNoVO().setPctlNo(pctlNo);	
					bookingCreationVO.getBkgBlNoVO().setMapSeq(mapSeq);								
					
					log.debug("Event Pctl No Set Success");
				}else{
					eventResponse.setETCData("IsPctlNoPop", "YM");				
					log.debug("Pctl Pop Up Call");
					rollback();
					return eventResponse;
				}			
				commit();
				bookingCreationVO = modifyBkgInfo(bookingCreationVO);
			}
			
			if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCloseBkgFlag())){
				rollback();
				eventResponse.setETCData("closeBkgFlag", "Y");
				eventResponse.setETCData("first_vvd", bookingCreationVO.getBookingSaveValidationVO().getChangeFirstVvd());
				eventResponse.setETCData("closeBkgMsg", bookingCreationVO.getBookingSaveValidationVO().getCloseBkgMsg());
			} else if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getTsCloseBkgFlag())){
				rollback();
				eventResponse.setETCData("tsCloseBkgFlag", "Y");
				eventResponse.setETCData("closedVvds", bookingCreationVO.getBookingSaveValidationVO().getClosedTsVvd());
			} else if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCbfBkgFlag())){
				rollback();
				eventResponse.setETCData("cbfBkgFlag", "Y");
				eventResponse.setETCData("first_vvd", bookingCreationVO.getBookingSaveValidationVO().getChangeFirstVvd());
				eventResponse.setETCData("closeBkgMsg", bookingCreationVO.getBookingSaveValidationVO().getCloseBkgMsg());
			} else {
				eventResponse.setETCData("ResultMsg", bookingCreationVO.getBookingSaveValidationVO().getSaveMsg());
				eventResponse.setETCData("aloc_pop_flg", bookingCreationVO.getBookingSaveValidationVO().getAlocPopFlg());
				eventResponse.setETCData("firm_msg_flg", bookingCreationVO.getBookingSaveValidationVO().getFirmMsgFlg());
				eventResponse.setETCData("non_rate_msg_flg", bookingCreationVO.getBookingSaveValidationVO().getNonRateMsgFlg());
	
				String resultMsg = bookingCreationVO.getBookingSaveValidationVO().getSaveMsg();
				if(resultMsg != null && resultMsg.length() > 0 ){
					if(resultMsg.startsWith(",")){
						resultMsg = resultMsg.substring(1, resultMsg.length());
					}
					StringTokenizer st = new StringTokenizer(resultMsg, ",");
					while(st.hasMoreTokens()){
						eventResponse.setUserMessage(new ErrorHandler(st.nextToken()).getUserMessage());
					}
				}			
				eventResponse.setETCData("closeBkgFlag", "N");
				eventResponse.setETCData("tsCloseBkgFlag", "N");
				eventResponse.setETCData("cbfBkgFlag", "N");
				eventResponse.setETCData("SuccessYn", "Y");	
				if("Y".equals(bookingCreationVO.getBkgBlNoVO().getCaFlg())){
					eventResponse.setETCData("codFlg", "N");
				} else {
					eventResponse.setETCData("codFlg", bookingCreationVO.getBookingSaveValidationVO().getCodFlag());
				}
				eventResponse.setETCData("ofcChgFlag", bookingCreationVO.getBookingSaveValidationVO().getOfcChgFlag());	
				eventResponse.setETCData("pre_checking", bookingCreationVO.getBookingSaveValidationVO().getPrecheckingFlag());
				eventResponse.setETCData("change_first_vvd", bookingCreationVO.getBookingSaveValidationVO().getChangeFirstVvd());
				
				// PSA 전송시 오류 Code가 있는 경우에 보내주도록 함.
				eventResponse.setETCData("psaValCode", bookingCreationVO.getPsaValCode());
			}
			
            //DG화물로 등록되어있지 않으면서 DG Keyword 포함하고 있는지 체크 . 최원정부장님 요청
			String dgKeyFlg2 = util.searchPotentialDgFlg2(bookingCreationVO.getBkgBlNoVO(),"RMK");
			eventResponse.setETCData("dg_key_flg2", dgKeyFlg2);
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0079_01 : save <br>
	 * Route 변경없을시 Booking 저장 처리 <br>
	 * 
	 * @author KimByungKyu 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBkgWithRoute(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil util = new BookingUtil();
		EsmBkg007901Event event = (EsmBkg007901Event)e;
		try{
			// Booking 모든 정보 담는 Container VO
			BookingCreationVO bookingCreationVO = new BookingCreationVO();
			// Validation 결과 담는 VO
			BookingSaveValidationVO bookingSaveValidationVO = event.getBookingSaveValidationVO();

			bookingCreationVO.setBkgBookingInfoVO(event.getBkgBookingInfoVO());
			bookingCreationVO.setBookingSaveValidationVO(bookingSaveValidationVO);
			bookingCreationVO.setVslSkdVOs(event.getVslSkdVOs());
			bookingCreationVO.setBkgBlNoVO(event.getBkgBlNoVO());
			bookingCreationVO.setBlCustomerInfoVO(event.getBlCustomerInfoVO());
			bookingCreationVO.setBkgQuantityVOs(event.getBkgQuantityVOs());
			bookingCreationVO.setBkgQtyDtlVOs(event.getBkgQtyDtlVOs());

			//pctlNo set
			String [] pctlNoMapSeq = util.splitByToken(event.getPctlNo(), "|");
			bookingCreationVO.getBkgBlNoVO().setPctlNo(pctlNoMapSeq[0]);
			bookingCreationVO.getBkgBlNoVO().setMapSeq(pctlNoMapSeq[1]);

			ProductCatalogPoupCheckVO vo = new ProductCatalogPoupCheckVO();
			vo.setPctlNo(event.getPctlNo());
			vo.setRfaNo(event.getBkgBookingInfoVO().getRfaNo());
			vo.setScNo(event.getBkgBookingInfoVO().getScNo());
			vo.setSCustCntCd(event.getBlCustomerInfoVO().getSCustCntCd() + event.getBlCustomerInfoVO().getSCustSeq());
			vo.setCCustCntCd(event.getBlCustomerInfoVO().getCCustCntCd() + event.getBlCustomerInfoVO().getCCustSeq());
			
			if(util.searchProductCatalogPopUpCheck(vo).equals("X")){
				eventResponse.setETCData("IsPctlNoPop", "YM");
			}else{
				bookingCreationVO = modifyBkgInfo(bookingCreationVO);
	
				if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCloseBkgFlag())){
					rollback();
					eventResponse.setETCData("closeBkgFlag", "Y");
					eventResponse.setETCData("first_vvd", bookingCreationVO.getBookingSaveValidationVO().getChangeFirstVvd());
					eventResponse.setETCData("closeBkgMsg", bookingCreationVO.getBookingSaveValidationVO().getCloseBkgMsg());
				} else if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getTsCloseBkgFlag())){
					rollback();
					eventResponse.setETCData("tsCloseBkgFlag", "Y");
					eventResponse.setETCData("closedVvds", bookingCreationVO.getBookingSaveValidationVO().getClosedTsVvd());
				} else if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCbfBkgFlag())){
					rollback();
					eventResponse.setETCData("cbfBkgFlag", "Y");
					eventResponse.setETCData("first_vvd", bookingCreationVO.getBookingSaveValidationVO().getChangeFirstVvd());
					eventResponse.setETCData("closeBkgMsg", bookingCreationVO.getBookingSaveValidationVO().getCloseBkgMsg());
				} else {
					eventResponse.setETCData("ResultMsg", bookingCreationVO.getBookingSaveValidationVO().getSaveMsg());		
					eventResponse.setETCData("aloc_pop_flg", bookingCreationVO.getBookingSaveValidationVO().getAlocPopFlg());
					eventResponse.setETCData("firm_msg_flg", bookingCreationVO.getBookingSaveValidationVO().getFirmMsgFlg());
					eventResponse.setETCData("non_rate_msg_flg", bookingCreationVO.getBookingSaveValidationVO().getNonRateMsgFlg());
		
					String resultMsg = bookingCreationVO.getBookingSaveValidationVO().getSaveMsg();
					if(resultMsg != null && resultMsg.length() > 0 ){
						if(resultMsg.startsWith(",")){
							resultMsg = resultMsg.substring(1, resultMsg.length());
						}
						StringTokenizer st = new StringTokenizer(resultMsg, ",");
						while(st.hasMoreTokens()){
							eventResponse.setUserMessage(new ErrorHandler(st.nextToken()).getUserMessage());
						}
					}			
					eventResponse.setETCData("closeBkgFlag", "N");
					eventResponse.setETCData("tsCloseBkgFlag", "N");
					eventResponse.setETCData("cbfBkgFlag", "N");
					eventResponse.setETCData("SuccessYn", "Y");	
					eventResponse.setETCData("codFlg", bookingCreationVO.getBookingSaveValidationVO().getCodFlag());
					eventResponse.setETCData("ofcChgFlag", bookingCreationVO.getBookingSaveValidationVO().getOfcChgFlag());
					eventResponse.setETCData("pre_checking", bookingCreationVO.getBookingSaveValidationVO().getPrecheckingFlag());
					eventResponse.setETCData("change_first_vvd", bookingCreationVO.getBookingSaveValidationVO().getChangeFirstVvd());
					eventResponse.setETCData("aloc_stand_by_msg_flg", bookingCreationVO.getBookingSaveValidationVO().getAlocStandByMsgFlg());
					
					// PSA 전송시 오류 Code가 있는 경우에 보내주도록 함.
					eventResponse.setETCData("psaValCode", bookingCreationVO.getPsaValCode());
				}
			}
            //DG화물로 등록되어있지 않으면서 DG Keyword 포함하고 있는지 체크 . 최원정부장님 요청
			String dgKeyFlg2 = util.searchPotentialDgFlg2(bookingCreationVO.getBkgBlNoVO(),"RMK");
			eventResponse.setETCData("dg_key_flg2", dgKeyFlg2);
			
			
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
		return eventResponse;
	}

	/**
	 * modifyBkgWithoutRoute(), modifyBkgWithRoute()에서 실행 <br>
	 * Booking을 수정한다.<br>
	 * 
	 * @author KimByungKyu 
	 * @param 	BookingCreationVO bookingCreationVO
	 * @return 	BookingSaveValidationVO
	 * @exception EventException 
	 */
	@SuppressWarnings("unchecked")
	private BookingCreationVO modifyBkgInfo(BookingCreationVO bookingCreationVO) throws EventException {
		try{
			begin();
			GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
			GeneralBookingSearchBC  searchBC 	= new GeneralBookingSearchBCImpl();
			BLDocumentationCMBC 	blDocCmBC 	= new BLDocumentationCMBCImpl();
			BLDocumentationBLBC     blDocBLBC    = new BLDocumentationBLBCImpl ();
			BookingHistoryMgtBC 	historyBC 	= new BookingHistoryMgtBCImpl();
			BlRatingBC				ratingBC	= new BlRatingBCImpl();
			BookingUtil				util		= new BookingUtil();
			
			BkgCopManageBC 			copBC       = null;
			
			BkgBlNoVO        bkgBlNoVO        = bookingCreationVO.getBkgBlNoVO();
			BkgBookingInfoVO bkgBookingInfoVO = bookingCreationVO.getBkgBookingInfoVO();
			
			// 01. validateBookingSave
			bookingCreationVO = receiptBC.validateBookingSave(bookingCreationVO, account);
			BookingSaveValidationVO bookingSaveValidationVO = bookingCreationVO.getBookingSaveValidationVO();

			// Auto COD
			if(!"Y".equals(bkgBlNoVO.getCaFlg())
					&& bookingSaveValidationVO.getCodFlag().equals("Y")){
				CODCorrectionBC codBC = new CODCorrectionBCImpl();
				codBC.manageAutoCod(bkgBlNoVO, account, "BK");
				
				HistoryLineVO historyLineVO = new HistoryLineVO();
				historyLineVO.setUiId("ESM_BKG_0079_01");			
				historyLineVO.setHisCateNm("COD");
				historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
				historyLineVO.setCaFlg("N");
				historyLineVO.setCrntCtnt("COD Request Created");				
				historyBC.createBkgHistoryLine(historyLineVO, account);
				
				//POD,DEL 국가 변경시 COP 호출
				CodEtcVO codEtcVO = codBC.searchCopForBkgCodParam(bkgBlNoVO);
				if(codEtcVO!=null){
					copBC = new BkgCopManageBCImpl();	
					UpdBkgForBkgCodVO updBkgForBkgCodVO = new UpdBkgForBkgCodVO();
					updBkgForBkgCodVO.setBkgNo(bkgBlNoVO.getBkgNo());
					updBkgForBkgCodVO.setOldPodYdCd(codEtcVO.getOldPodNodCd());
					updBkgForBkgCodVO.setOldDelYdCd(codEtcVO.getOldDelNodCd());
					updBkgForBkgCodVO.setNewPodYdCd(codEtcVO.getNewPodNodCd());
					updBkgForBkgCodVO.setNewDelYdCd(codEtcVO.getNewDelNodCd());
					copBC.updateBkgForBkgCod(updBkgForBkgCodVO);
				}
			} else {
				bookingSaveValidationVO.setCodFlag("N");
			}
			
			BlCustomerInfoVO custInfoVO = null;

			// 20100204 Bkg Close 여부 확인
			if("Y".equals(bookingSaveValidationVO.getCloseBkgFlag())){
				return bookingCreationVO;
			} else if("Y".equals(bookingSaveValidationVO.getTsCloseBkgFlag())){
				return bookingCreationVO;
			} else if("Y".equals(bookingSaveValidationVO.getCbfBkgFlag())){
				return bookingCreationVO;
			} else {
				bookingSaveValidationVO.setCloseBkgFlag("N");
				bookingSaveValidationVO.setCbfBkgFlag("N");
			}
			
			// 04. searchOldBkgInfo
			HistoryTableVO historyTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0079_01", bkgBlNoVO);

			OldBkgInfoVO oldBkgInfoVO = new OldBkgInfoVO();
			oldBkgInfoVO.setFirstVvd(historyTableVO.getBkgVvdVOs().get(0).getVslCd()
					+historyTableVO.getBkgVvdVOs().get(0).getSkdVoyNo()
					+historyTableVO.getBkgVvdVOs().get(0).getSkdDirCd());
			bookingCreationVO.setOldBkgInfoVO(oldBkgInfoVO);
				
			// 변경되지 않은 정보는 history 비교도 하지 않음
			List<TableListVO> newTableListVOs = new ArrayList<TableListVO>();
			for(int i=0;i<historyTableVO.getTableListVOs().size();i++){
				if("BKG_CUSTOMER".equals(historyTableVO.getTableListVOs().get(i).getTableNm())&&
					"N".equals(bookingSaveValidationVO.getCustomerModifyFlag())) continue;
				if("BKG_CNTC_PSON".equals(historyTableVO.getTableListVOs().get(i).getTableNm())&&
					"N".equals(bookingSaveValidationVO.getContactModifyFlag()))  continue;
				if("BKG_VVD".equals(historyTableVO.getTableListVOs().get(i).getTableNm())&&
					"N".equals(bookingSaveValidationVO.getRouteModifyFlag()))    continue;
				if("BKG_QUANTITY".equals(historyTableVO.getTableListVOs().get(i).getTableNm())&&
					"N".equals(bookingSaveValidationVO.getQtyModifyFlag())) 	 continue;
				newTableListVOs.add(historyTableVO.getTableListVOs().get(i));				
			}
			historyTableVO.setTableListVOs(newTableListVOs);
			
			String replanFlg = null;
			if(isNull(historyTableVO.getBkgBookingVO().getPctlNo())&&!isNull(bkgBlNoVO.getPctlNo())){
				replanFlg = "Y";
			} else if(historyTableVO.getBkgBookingVO().getPctlNo().equals((bkgBlNoVO.getPctlNo()))){
				replanFlg = "N";
			} else {
				replanFlg = "Y";
			}
			// 05. modifyBooking
			bookingSaveValidationVO = receiptBC.modifyBooking(bookingCreationVO, account);
			bookingCreationVO.setBookingSaveValidationVO(bookingSaveValidationVO);
			// HOMEPAGE로 자동 생성된 BKG인 경우 최초 Update한 사용자를 Doc User 로 변경
			receiptBC.modifyDocUserId(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getCaFlg(), account.getUsr_id());

			
			// VVD가 변경되었을때 VVD에 BDR이 걸렸는지 확인하여  해당 BKG No의 BDR정보변경
			if("Y".equals(bkgBlNoVO.getCaFlg()) && "Y".equals(bookingSaveValidationVO.getChangeVvd())){       	
	        	String flg = blDocCmBC.searchBdrFlgForNewRoute(bkgBlNoVO.getBkgNo());
	        	if(!"Y".equals(flg)){
	        		blDocBLBC.modifyBKGBDR(bkgBlNoVO.getBkgNo(), "D", "Y",  account.getUpd_usr_id());
				}
	        	else{
	        		blDocBLBC.modifyBKGBDR(bkgBlNoVO.getBkgNo(), "Y", "Y",  account.getUpd_usr_id());
				}        		
			}
			
			// 추가: 20090706 BkgBlDoc에 ActWgt,WgtUtCd Update
			BkgBlActWgtVO bkgBlActWgtVO = new BkgBlActWgtVO();
			bkgBlActWgtVO.setActWgt(bkgBookingInfoVO.getActWgt());
			bkgBlActWgtVO.setWgtUtCd(bkgBookingInfoVO.getWgtUtCd());
			bkgBlActWgtVO.setOldPodNodCd(historyTableVO.getBkgBookingVO().getPodNodCd());
			bkgBlActWgtVO.setOldDelNodCd(historyTableVO.getBkgBookingVO().getDelNodCd());
			blDocCmBC.modifyBlActWgt(bkgBlNoVO, bkgBlActWgtVO, account);
						
			// VNSGN -> KNPNH 에 대해 BL Clause 자동 문구 삽입 요청
			List<VslSkdVO> routeDetails = receiptBC.searchVvdSkdForTsRoute(bkgBlNoVO);
			if(routeDetails.get(routeDetails.size() - 1).getPolCd().equals(Constants.BL_CLAUSE_POL)
					&& routeDetails.get(routeDetails.size() - 1).getPodCd().equals(Constants.BL_CLAUSE_POD)){
				BLDocumentationBLBC blBC = new BLDocumentationBLBCImpl();
				MndVO mndVO = new MndVO();
				mndVO.setBkgNo(bkgBlNoVO.getBkgNo());
				blBC.manageMndCmdtDescKHPNH(mndVO, account, bkgBlNoVO.getCaFlg());
			}
			
			// 06. modifyCntrRDTerm(Rcv term이나 Del Term이 'M'이 아닌 값으로 변경된 경우)
			String oldRcvTermCd = historyTableVO.getBkgBookingVO().getRcvTermCd();
			String oldDeTermCd  = historyTableVO.getBkgBookingVO().getDeTermCd();
			String rcvTermCd    = bkgBookingInfoVO.getRcvTermCd();
			String deTermCd     = bkgBookingInfoVO.getDeTermCd();
			
			if(!oldRcvTermCd.equals(rcvTermCd) || !oldDeTermCd.equals(deTermCd)){
				if(!"M".equals(rcvTermCd) || !"M".equals(deTermCd)){
					BLDocumentationCMBC blCmBC = new BLDocumentationCMBCImpl();
					BkgContainerVO bkgContainerVO = new BkgContainerVO();
					bkgContainerVO.setBkgNo(bkgBlNoVO.getBkgNo());
					bkgContainerVO.setRcvTermCd(rcvTermCd);
					bkgContainerVO.setDeTermCd(deTermCd);
					bkgContainerVO.setUpdUsrId(account.getUsr_id());

					blCmBC.modifyCntrRDTerm(bkgContainerVO, bkgBlNoVO);
					
					// modifySpclRDTerm 추가(091110 류대영수석님 요청)
					if("Y".equals(bookingCreationVO.getBkgBookingInfoVO().getAwkCgoFlg())||"Y".equals(bookingCreationVO.getBkgBookingInfoVO().getBbCgoFlg())){
						SpecialCargoReceiptBC spclReceiptBC = new SpecialCargoReceiptBCImpl();
						spclReceiptBC.modifySpclRDTerm(bkgBlNoVO, rcvTermCd, deTermCd, account);
					}
				}
			}

			// 20140306 SI History 추가 
			String oldSiFlg  = historyTableVO.getBkgBookingVO().getSiFlg();
			if(oldSiFlg!=null && "".equals(oldSiFlg)){
				oldSiFlg = "N";
			}
			String siFlg     = bkgBookingInfoVO.getSiFlg();
			if(siFlg!=null && "".equals(siFlg)){
				siFlg = "N";
			}
			if(oldSiFlg!=null && siFlg!=null && !oldSiFlg.equals(siFlg)){
				HistoryLineVO historyLineVO = new HistoryLineVO();
				historyLineVO.setUiId("ESM_BKG_0079_01");			
				historyLineVO.setHisCateNm("S/I");
				historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
				historyLineVO.setCaFlg(bkgBlNoVO.getCaFlg());
				if("Y".equals(siFlg)){
					historyLineVO.setCrntCtnt("S/I Check"); // 변경시 HardCoding 검토 필요함				
					historyBC.createBkgHistoryLine(historyLineVO, account);
				}else if("N".equals(siFlg)){
					historyLineVO.setCrntCtnt("S/I Uncheck"); 				
					historyBC.createBkgHistoryLine(historyLineVO, account);
				}
			}
			
			// CA 여부 판단
			if(!"Y".equals(bkgBlNoVO.getCaFlg())){
				// spclCgoFlg = 'Y' and vvd변경일 경우
				if("Y".equals(bookingSaveValidationVO.getSpclCgoFlg()) && "Y".equals(bookingSaveValidationVO.getChangeVvd())){
					// 07.Special Cargo Approval 자동 request
					String spclRqstResult = reRequestSpclCgoApproval(bkgBlNoVO, "UPDATE", null);
					if("pre-checking".equals(spclRqstResult)){
						bookingSaveValidationVO.setPrecheckingFlag("Y");
					}
					else if("alert".equals(spclRqstResult)){
						bookingSaveValidationVO.setPrecheckingFlag("A");						
					} 
					else {
						bookingSaveValidationVO.setPrecheckingFlag("N");						
					}
				}

				// 09. Booking Status 변경
				receiptBC.changeBkgStatus("Y", bkgBlNoVO, false, account);
				
				// advance bkg에서 일반 bkg으로 변경시 cntr rate배분 실행
				if("A".equals(historyTableVO.getBkgBookingVO().getBkgStsCd())){
					if("F".equals(util.searchBkgStatusByBkg(bkgBlNoVO))){
						ratingBC.distributeCntrRate(bkgBlNoVO.getBkgNo(), account);
					}
				}
				
				if("KR".equals(bkgBookingInfoVO.getBkgPolCd().substring(0,2))){
					TransferOrderIssueBC 	troBC = new TransferOrderIssueBCImpl();
					troBC.modifyKrTroReturnCy(bkgBookingInfoVO.getBkgNo(), account);
				}
				
				if("Y".equals(bookingSaveValidationVO.getTroCfrmFlg())){
					TransferOrderIssueBC 	troBC = new TransferOrderIssueBCImpl();
					if(!"E".equals(bkgBookingInfoVO.getOrgScontiCd().substring(0, 1))){
						// 14. porScontiCd <> 'E' 이면 unconfirmTro
						troBC.unconfirmTro(bkgBlNoVO, account);
					} else {
					    // 15. porScontiCd = 'E' 이면 unconfirmEurTro
						troBC.unconfirmEurTro(bkgBlNoVO,  "O", account);
					}
					copBC = new BkgCopManageBCImpl();	
					copBC.unconfirmTro(bkgBlNoVO.getBkgNo(), "O");
					bookingSaveValidationVO.setSaveMsg(bookingSaveValidationVO.getSaveMsg() + ",BKG00088");
				}
			}			
			
			// prepaid, collect payer를 변경한다
			if("Y".equals(bookingSaveValidationVO.getCustomerModifyFlag())) {
				ratingBC.modifyRateCntCd(bkgBlNoVO.getBkgNo(), account, bkgBlNoVO.getCaFlg());
			}
			
			// por_cd, del_cd 값이 Old와 New가 서로 틀린 경우에 prepaid, collect payer를 변경하도록 수정함. ( 2010-07-14, 류대영수석요청 )
			String ctrtTpCd = "X";
			if(bkgBookingInfoVO.getScNo().length()>0){
				ctrtTpCd = "S";
			}
			if(bkgBookingInfoVO.getRfaNo().length()>0){
				ctrtTpCd = "R";
			}
			if(bkgBookingInfoVO.getTaaNo().length()>0){
				ctrtTpCd = "T";
			}
			ratingBC.modifyCtrtTpCd(bkgBlNoVO.getBkgNo(), ctrtTpCd, account, bkgBlNoVO.getCaFlg());
			
			// PPD, CCT Office 변경 여부 결정, History와 현재값 비교
			// POR, DEL, Shipper, Consignee, Forwarder, Loading Office 변경될 때 처리됨
			String ofcChgFlag = "N";
			BkgBookingVO bkgBookingVO = historyTableVO.getBkgBookingVO();
			String bkgPorCdOld = bkgBookingVO.getPorCd();
			String bkgDelCdOld = bkgBookingVO.getDelCd();
			String ldgOfcOld = bkgBookingVO.getObSlsOfcCd();
			
			custInfoVO = bookingCreationVO.getBlCustomerInfoVO();
			String shCustCntCdOld = custInfoVO.getSCustCntCdOld();
			String shCustSeqOld   = custInfoVO.getSCustSeqOld();
			String cnCustCntCdOld = custInfoVO.getCCustCntCdOld();
			String cnCustSeqOld   = custInfoVO.getCCustSeqOld();
			String fwCustCntCdOld = custInfoVO.getFCustCntCdOld();
			String fwCustSeqOld   = custInfoVO.getFCustSeqOld();	
			
			String bkgPorCd = bkgBookingInfoVO.getBkgPorCd();
			String bkgDelCd = bkgBookingInfoVO.getBkgDelCd();
			String ldgOfc   = bkgBookingInfoVO.getObSlsOfcCd();
			String shCustCntCd = custInfoVO.getSCustCntCd();
			String shCustSeq   = custInfoVO.getSCustSeq();
			String cnCustCntCd = custInfoVO.getCCustCntCd();
			String cnCustSeq   = custInfoVO.getCCustSeq();
			String fwCustCntCd = custInfoVO.getFCustCntCd();
			String fwCustSeq   = custInfoVO.getFCustSeq();			

			if(!bkgPorCd.equals(bkgPorCdOld) || !bkgDelCd.equals(bkgDelCdOld) || !ldgOfc.equals(ldgOfcOld)
					|| !shCustCntCd.equals(shCustCntCdOld) || !shCustSeq.equals(shCustSeqOld)
					|| !cnCustCntCd.equals(cnCustCntCdOld) || !cnCustSeq.equals(cnCustSeqOld)
					|| !fwCustCntCd.equals(fwCustCntCdOld) || !fwCustSeq.equals(fwCustSeqOld)) {
				ofcChgFlag = "Y";
			}
			log.debug ("ofcChgFlag:"+ofcChgFlag);
			bookingSaveValidationVO.setOfcChgFlag(ofcChgFlag);
			
			receiptBC.modifyKrCstmsCustTpCd(bkgBlNoVO,"");//[CHM-201429314] 2014.05.26 일본 세관 사전신고제를 위한 Simple/Console default 적용 로직 추가

			historyBC.manageBookingHistory("ESM_BKG_0079_01", historyTableVO, account);

			//c/a가 아닐 경우
			if(!"Y".equals(bkgBlNoVO.getCaFlg())){
				//기존에 sc, rfa, taa가 없거나 있는데 dummy였을 경우
				if((isNull(bkgBookingInfoVO.getScNoOld()) ||(!isNull(bkgBookingInfoVO.getScNoOld()) &&"DUM".equals(bkgBookingInfoVO.getScNoOld().substring(0,3))))||
				   (isNull(bkgBookingInfoVO.getRfaNoOld())||(!isNull(bkgBookingInfoVO.getRfaNoOld())&&"DUM".equals(bkgBookingInfoVO.getRfaNoOld().substring(0,3))))||
				   (isNull(bkgBookingInfoVO.getTaaNoOld())||(!isNull(bkgBookingInfoVO.getTaaNoOld())&&"DUM".equals(bkgBookingInfoVO.getTaaNoOld().substring(0,3))))){
					//새로 가용한 계약을 입력한 경우
					if((bkgBookingInfoVO.getScNo().length() >0 &&!"DUM".equals(bkgBookingInfoVO.getScNo().substring(0, 3)))
					 ||(bkgBookingInfoVO.getRfaNo().length()>0 &&!"DUM".equals(bkgBookingInfoVO.getRfaNo().substring(0, 3)))
					 ||(bkgBookingInfoVO.getTaaNo().length()>0 &&!"DUM".equals(bkgBookingInfoVO.getTaaNo().substring(0, 3)))){
						//기존 계약과 다른 경우
						if(!bkgBookingInfoVO.getScNo().equals(bkgBookingInfoVO.getScNoOld())
								|| !bkgBookingInfoVO.getRfaNo().equals(bkgBookingInfoVO.getRfaNoOld())
								|| !bkgBookingInfoVO.getTaaNo().equals(bkgBookingInfoVO.getTaaNoOld())){
							BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
							bkgDocProcSkdVO.setBkgNo(bkgBlNoVO.getBkgNo());
							bkgDocProcSkdVO.setBkgDocProcTpCd("CTRTNO");// contract no input for doc performance
							historyBC.manageDocProcess(bkgDocProcSkdVO, account);
						}	
					}
				}
										//기존 계약과 다른 경우
				if(bkgBookingInfoVO.getBkgPodCd().equals("JOAQJ")
						||bkgBookingInfoVO.getBkgDelCd().equals("JOAQJ")){
					if(!bkgBookingInfoVO.getScNoOld().equals(bkgBookingInfoVO.getScNo())
							|| !bkgBookingInfoVO.getRfaNoOld().equals(bkgBookingInfoVO.getRfaNo())
							|| !bkgBookingInfoVO.getTaaNoOld().equals(bkgBookingInfoVO.getTaaNo())
							|| !shCustCntCd.equals(shCustCntCdOld) 
							|| !shCustSeq.equals(shCustSeqOld)){
						blDocBLBC.manageMndCmdtDescJOAQJ(bkgBlNoVO.getBkgNo(), account, bkgBlNoVO.getCaFlg());
					}	
				}
				// customer code가 바뀐 경우
				if("Y".equals(bookingSaveValidationVO.getCustomerModifyFlag())){
					// update시 cnee input(최초 입력시 경우)
					if(isNull(custInfoVO.getCCustCntCdOld())&&isNull(custInfoVO.getCCustSeqOld())
						&&!isNull(custInfoVO.getCCustCntCd())&&!isNull(custInfoVO.getCCustSeq())){
						BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
						bkgDocProcSkdVO.setBkgNo(bkgBlNoVO.getBkgNo());
						bkgDocProcSkdVO.setBkgDocProcTpCd("CNEIPT");// consignee input for doc performance
						historyBC.manageDocProcess(bkgDocProcSkdVO, account);
					}
					// i/b code validation 초기화
					if(!isNull(custInfoVO.getCCustCntCdOld())&&!isNull(custInfoVO.getCCustSeqOld())
						&&!isNull(custInfoVO.getCCustCntCd())&&!isNull(custInfoVO.getCCustSeq())
						&&(!custInfoVO.getCCustCntCdOld().equals(custInfoVO.getCCustCntCd())||!custInfoVO.getCCustSeqOld().equals(custInfoVO.getCCustSeq()))){

						receiptBC.cancelCustCdVal(bkgBlNoVO.getBkgNo());					
						ArrivalNoticeBC anBC = new ArrivalNoticeBCImpl();
						anBC.cancelArrNtcCustCdVal(bkgBlNoVO.getBkgNo());
					}
				}				
				
				if(bookingSaveValidationVO.getScpFromCtrt() != null && bookingSaveValidationVO.getScpFromCtrt().length() > 0){
					BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
					bkgDocProcSkdVO.setBkgNo(bkgBlNoVO.getBkgNo());
					bkgDocProcSkdVO.setBkgDocProcTpCd("SCPCTR");// select service scope from contract
					historyBC.manageDocProcess(bkgDocProcSkdVO, account);
				}
				
				//c/a가 아니면서 volume이 바뀐 경우 for report performance
				if("Y".equals(bookingSaveValidationVO.getQtyModifyFlag())){
					PerformanceReportBC performReportBc = new PerformanceReportBCImpl();
					performReportBc.manageQtyCntrCoposite(bkgBlNoVO.getBkgNo(), "CQ");	
				}

				AllocStsChgVO allocStsChgVO = new AllocStsChgVO();

				if("Y".equals(bookingSaveValidationVO.getAlocChkFlg())){
					if("US".equals(bkgBookingInfoVO.getBkgPolCd().substring(0,2))
							|| "CA".equals(bkgBookingInfoVO.getBkgPolCd().substring(0,2))){
						
						allocStsChgVO = receiptBC.manageAlocStatus(bkgBlNoVO, account, "");
						List<BkgNtcHisVO> bkgNtcHisVOs = allocStsChgVO.getBkgNtcHisVOs();
						if (null!=bkgNtcHisVOs) {
							historyBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0079_01");
						}
						bookingSaveValidationVO.setAlocPopFlg(allocStsChgVO.getAlocPopFlg());
						bookingSaveValidationVO.setFirmMsgFlg(allocStsChgVO.getFirmMsgFlg());
						
						// Allocation Status S->F 이면 Reciept Notice 발송 
						// Allocation Status S->F 경우만 RcvrEml 에 값이 있음
						// 삭제예정 
						if(allocStsChgVO.getRcvrEml() != null && allocStsChgVO.getRcvrEml().length() > 0){
							if("Y".equals(util.searchNoRateBlockFlg(bkgBlNoVO))){
								throw new EventException(new ErrorHandler("BKG08333",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
							}
							if("Y".equals(util.searchStandbyBlockFlg(bkgBlNoVO))){
								throw new EventException(new ErrorHandler("BKG08284",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
							}
							String mrdNm = "ESM_BKG_5005G";
							
							BkgBlNoVO[] bkgBlNoVOs = {bkgBlNoVO};
							String[]    eml        = {allocStsChgVO.getRcvrEml()};
							String[]    cct        = {""};
							String[]    docCct     = {""};
							String[]    rmk        = {""};
							
							BkgReceiptSendVO bkgReceiptSendVO = new BkgReceiptSendVO();
							bkgReceiptSendVO.setBkgBlNoVos(bkgBlNoVOs);
							bkgReceiptSendVO.setEmlAddrs(eml);
							bkgReceiptSendVO.setRemarks(rmk);
							bkgReceiptSendVO.setMrdNm(mrdNm);
							bkgReceiptSendVO.setCcts(cct);
							bkgReceiptSendVO.setDocCcts(docCct);
							GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
							List<BkgNtcHisVO> bkgNtcHisVOs2 = command.sendBkgReceiptByEmail(bkgReceiptSendVO, "", account);
							historyBC.createBkgNtcHis(bkgNtcHisVOs2, "ESM_BKG_0079_01");	
						}
						
						// Allocation Status History 
						if(allocStsChgVO != null){
							HistoryLineVO historyLineVO = new HistoryLineVO();
							historyLineVO.setUiId("ESM_BKG_0079_01");			
							historyLineVO.setHisCateNm("Booking Status");
							historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
							historyLineVO.setCaFlg("N");
							if (allocStsChgVO == null || allocStsChgVO.getAlocStsCd() == null){
								log.debug("Null Check");
							} else if ((allocStsChgVO.getOriAlocStsCd() == null || "".equals(allocStsChgVO.getOriAlocStsCd())) && "S".equals(allocStsChgVO.getAlocStsCd())){
								historyLineVO.setCrntCtnt("Allocation Status change to S");
								historyBC.createBkgHistoryLine(historyLineVO, account);
							} else if ((allocStsChgVO.getOriAlocStsCd() == null || "".equals(allocStsChgVO.getOriAlocStsCd())) && "F".equals(allocStsChgVO.getAlocStsCd())){
								historyLineVO.setCrntCtnt("Allocation Status change to F");
								historyBC.createBkgHistoryLine(historyLineVO, account);	
							} else if ( "F".equals(allocStsChgVO.getOriAlocStsCd()) && "S".equals(allocStsChgVO.getAlocStsCd()) ){
								historyLineVO.setCrntCtnt("Allocation Status change F to S");
								historyBC.createBkgHistoryLine(historyLineVO, account);
							} else if ( "S".equals(allocStsChgVO.getOriAlocStsCd()) && "F".equals(allocStsChgVO.getAlocStsCd()) ){
								historyLineVO.setCrntCtnt("Allocation Status change S to F");
								historyBC.createBkgHistoryLine(historyLineVO, account);
							}
						}
						// Allocation Status History 끝
					}
				}
				
				// 19. coa interface, Standby 계산 뒤로 이동 
//				interfaceToMas(bkgBlNoVO, "Booking Update", account);
				//route or volumne이 바뀐 경우	
				if("Y".equals(replanFlg)){
					copBC = new BkgCopManageBCImpl();		
					// 18. updateBkg(타 모듈 호출)				
					//copBC.updateBkg(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getMapSeq());
					callCopUpdateBkg(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getMapSeq());
					
					commit();
					try{
						// cut off time (cop 생성 이후에 처리)
						String fromDt = null;
						String toDt   = null;
						
						if("US".equals(bkgBookingInfoVO.getBkgPorCd().substring(0, 2))
								|| ("CA".equals(bkgBookingInfoVO.getBkgPorCd().substring(0, 2))
										&& "Y".equals(bookingSaveValidationVO.getChangeVvd())
									)){
							ProductCatalogCreateBC prdBC   = new ProductCatalogCreateBCImpl();
							BkgQuantityVO[] bkgQuantityVOs = bookingCreationVO.getBkgQuantityVOs();
							PrdQtyInfoVO[]  prdQtyInfo 	   = new PrdQtyInfoVO[bkgQuantityVOs.length];
							
							for(int i = 0 ; i < bkgQuantityVOs.length ; i++){	
								prdQtyInfo[i] = new PrdQtyInfoVO();				
								prdQtyInfo[i].setCTpsz(bkgQuantityVOs[i].getCntrTpszCd());
								prdQtyInfo[i].setCQty(bkgQuantityVOs[i].getOpCntrQty());				
							}
							 
							Map railTime = prdBC.getRailRecevingTime(bkgBlNoVO.getPctlNo(), prdQtyInfo, null, null, bkgBlNoVO.getBkgNo()); 
							
							fromDt= (String)railTime.get("RTN_TIME");
							toDt  = (String)railTime.get("CUT_OFF");
						}
						
						HistoryTableVO clzTmHistVO = historyBC.searchOldBkgForHistory("ESM_BKG_0721", bkgBlNoVO);
						
						begin(); //batch 서버 접속해야되서 Transaction을 분리함
						receiptBC.createCargoClosingTime(bkgBlNoVO, fromDt, toDt, account);
						historyBC.manageBookingHistory("ESM_BKG_0721", clzTmHistVO, account);
						commit();
					} catch(Exception prdEx){
						rollback();
						log.error("err rail time:"+prdEx.toString(),prdEx);
					}		
				} else {		
					//route or volumne이 바뀌지 않은 경우
					commit();
				}
				
				// VVD 변경되면 SCE(COP)호출
				try{
					if("Y".equals(bookingSaveValidationVO.getChangeVvd())){
						UpdBkgForVVDChgVO updBkgForVVDChgVO = new UpdBkgForVVDChgVO();
						
						List<BkgVvdVO> oldBkgVvdVOs = historyTableVO.getBkgVvdVOs();
						List<VslSkdVO> newVslSkdVOs =  routeDetails;
						// 추가된 vvd의 pol (추가된 vvd가 여러건일때는 추가 vvd중 첫번째 vvd의 pol, 추가건이 없을 경우는 bkg의 pol)
						String eventYdCd = "";
						if(newVslSkdVOs!=null){
							for(int i=0; i<newVslSkdVOs.size(); i++ ){
								boolean existVvd = false;
								for(int j=0; j<oldBkgVvdVOs.size(); j++){
									String oldVvd = oldBkgVvdVOs.get(j).getVslCd()+oldBkgVvdVOs.get(j).getSkdVoyNo()+oldBkgVvdVOs.get(j).getSkdDirCd();
									if(newVslSkdVOs.get(i).getBkgVvdCd().equalsIgnoreCase(oldVvd)){
										existVvd = true;
									}
								}
								if(!existVvd && eventYdCd.equals("") && newVslSkdVOs.get(i).getPolYdCd()!=null){
									eventYdCd = newVslSkdVOs.get(i).getPolYdCd();
								}
							}
						}
						if(eventYdCd.equals("")){
							eventYdCd = bkgBookingInfoVO.getBkgPolYdCd();
						}
						updBkgForVVDChgVO.setBkgNo(bookingCreationVO.getBkgBookingInfoVO().getBkgNo());
						updBkgForVVDChgVO.setEventYdCd(eventYdCd);
						updBkgForVVDChgVO.setCreUsrId(account.getUsr_id());
						if(updBkgForVVDChgVO!=null){
							copBC.updateBkgForVVDChange(updBkgForVVDChgVO);
						}
					}
				}catch(EventException ex){
					log.error("BKG SCE updateBkgForVVDChange calling errer", ex);
				}
				// VVD 변경되면 SCE(COP)호출 끝
				
				// 2014.09.24 [CHM-201431658] 한진해운 조기결산을 위한 개선 방안 중 BKG 관리 프로세스 단축(안) 개발(S)
				String oldNoRtStsCd = "";
				if(historyTableVO.getBkgBookingVO().getNonRtStsCd()!=null){
					oldNoRtStsCd = historyTableVO.getBkgBookingVO().getNonRtStsCd();
				}
				String newNoRtStsCd = "";
				String noRtNtc_snd_flg = "N";
				String noRtNtc_snd_cust_flg = "N";
				String sc_no = bookingCreationVO.getBkgBookingInfoVO().getScNo();
				String rfa_no = bookingCreationVO.getBkgBookingInfoVO().getRfaNo();
				String taa_no = bookingCreationVO.getBkgBookingInfoVO().getTaaNo();
				OftPrecheckVO oftPrecheckVO = new OftPrecheckVO();
				try{//기존 별도 트랜젝션으로 화면에서 호출 하던 부분	
					begin();
					if(rfa_no!=null && rfa_no.length() > 2 ){
						oftPrecheckVO = searchRfaOftPrecheckResult(bkgBlNoVO, rfa_no, account);
					}else if(sc_no!=null && sc_no.length() > 2 ){
						oftPrecheckVO = searchScOftPrecheckResult(bkgBlNoVO, sc_no, account);
					}else if(taa_no!=null && taa_no.length() > 2 ){
						oftPrecheckVO = searchTaaOftPrecheckResult(bkgBlNoVO, taa_no, account);
					}else{
						oftPrecheckVO.setNonRtStsCd("R");
						oftPrecheckVO.setChkOft("");
						oftPrecheckVO.setApplicationDt("");
						oftPrecheckVO.setFrtTermCd("");
						oftPrecheckVO.setSvcScpCd("");
					}
				}catch(EventException ex){
					log.error("No Rate Status check Error : "+bkgBlNoVO.getBkgNo(), ex);
					oftPrecheckVO.setNonRtStsCd("");
					oftPrecheckVO.setChkOft("");
					oftPrecheckVO.setApplicationDt("");
					oftPrecheckVO.setFrtTermCd("");
					oftPrecheckVO.setSvcScpCd("");
				}
				
				// CMPB 산출
				try{
					if("Y".equals(oftPrecheckVO.getChkOft()) ){
						BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
						bkgHrdCdgCtntListCondVO.setHrdCdgId("NO_RATE_PROC_CTR");			
						List<BkgHrdCdgCtntVO> BkgHrdCdgCtntVOs = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
						
						String createCmpb = "";
						if(BkgHrdCdgCtntVOs.size() > 0){
							createCmpb = BkgHrdCdgCtntVOs.get(0).getAttrCtnt4();// BKG modify CMPB 생성
						}
						if(!"N".equals(createCmpb)){
							//createContributionMarginPerBox(bkgBlNoVO);
							// 2015.12.03 [CHM-201538812] MAS time out 방지위해 1,2 로 나눔
							BkgCmpbVO BkgCmpbVO = createContributionMarginPerBox1(bkgBlNoVO, oftPrecheckVO);
							commit();
							begin();
							createContributionMarginPerBox2(bkgBlNoVO,BkgCmpbVO);
						}
					}
					commit();
				}catch(EventException ex){
					log.error("create CMPB Error : "+bkgBlNoVO.getBkgNo(), ex);
					rollback();
				}
				
				// No Rate Status 한번 F(Firm) 되면 바꾸지 않음
				if(oftPrecheckVO!=null && oftPrecheckVO.getNonRtStsCd()!=null && !oldNoRtStsCd.equals("F")){
					begin();
					if(!oldNoRtStsCd.equals(oftPrecheckVO.getNonRtStsCd())){//No Rate Status 가 바뀐 경우 
						newNoRtStsCd = oftPrecheckVO.getNonRtStsCd();
						//no_rt_sts_cd Update
						int updCnt = receiptBC.modifyNoRtStsCd(bkgBlNoVO, newNoRtStsCd, account);
						// History 
						if(updCnt > 0){
							HistoryLineVO historyLineVO = new HistoryLineVO();
							historyLineVO.setUiId("ESM_BKG_0079_01");			
							historyLineVO.setHisCateNm("No Rate Status");
							historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
							historyLineVO.setCaFlg(bkgBlNoVO.getCaFlg());
							historyLineVO.setPreCtnt(oldNoRtStsCd);
							historyLineVO.setCrntCtnt(newNoRtStsCd);
							historyBC.createBkgHistoryLine(historyLineVO, account);
							
							//Reciept Notice 는 Allocation Status 까지 확인 후 발송 (메일 발송은 commit 이후에)
							//  R -> F : Reciept Notice
							// !R -> R : No Rate Notice
							if("R".equals(oftPrecheckVO.getNonRtStsCd())){
								noRtNtc_snd_flg = "Y";// (메일 발송은 commit 이후)
							}
							// 메시지
							if("F".equals(oftPrecheckVO.getNonRtStsCd()) && "R".equals(oldNoRtStsCd)){
								bookingSaveValidationVO.setNonRateMsgFlg("Y");
							}
						}
					}
					
					if("R".equals(oftPrecheckVO.getNonRtStsCd())){
						// No Rate Status 가 바뀌지 않았어도 NoRateNotice to Customer 는 다시 체크	
						String noRtNtcForCust = searchBC.searchNoRateNoticeToCustomerBlock(bkgBlNoVO);
						if("N".equals(noRtNtcForCust)){
							noRtNtc_snd_cust_flg = "Y";// NoRateNotice to Customer
							
							BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
							bkgDocProcSkdVO.setBkgNo(bkgBlNoVO.getBkgNo());
							bkgDocProcSkdVO.setBkgDocProcTpCd("NORTNC");//NoRateNoticeForCustomer
							historyBC.manageDocProcess(bkgDocProcSkdVO, account);	
						}
					}
					commit();
				}
				
				//[CHM-201640340] 미주발(US/CA) 은 VVD 변경 때에만 재계산
				//SPC-BKG 연동 (NoRateStatus Firm 일 때만 SPC Aloc 체크)
				String alocPopFlg = "";
				if("F".equals(oldNoRtStsCd) || "F".equals(newNoRtStsCd)){ 
					if((!"F".equalsIgnoreCase(historyTableVO.getBkgBookingVO().getAlocStsCd())) ||( ("US".equals(bkgBookingInfoVO.getBkgPolCd().substring(0,2)) || "CA".equals(bkgBookingInfoVO.getBkgPolCd().substring(0,2)))
							&& "Y".equals(bookingSaveValidationVO.getChangeVvd())
						  )
						  
						  /** 박준훈 과장님 요청으로 해당 조건 주석 처리 */
//						||( (!"US".equals(bkgBookingInfoVO.getBkgPolCd().substring(0,2))
//								&& !"CA".equals(bkgBookingInfoVO.getBkgPolCd().substring(0,2)))
//						  &&(!"TPW".equals(bookingCreationVO.getBkgBookingInfoVO().getSvcScpCd())
//							 &&!"AEE".equals(bookingCreationVO.getBkgBookingInfoVO().getSvcScpCd())
//							 &&!"SAW".equals(bookingCreationVO.getBkgBookingInfoVO().getSvcScpCd())
//							 &&!"BRE".equals(bookingCreationVO.getBkgBookingInfoVO().getSvcScpCd())
//							 &&!"MXW".equals(bookingCreationVO.getBkgBookingInfoVO().getSvcScpCd())
//						     ) 
//						   &&("Y".equals(bookingSaveValidationVO.getAlocChkFlg())
//							  ||"Y".equals(bookingSaveValidationVO.getRouteModifyFlag())
//						     )
//						   )  
						  
						  /** POD = (US,CA) 면서 STOWAGE 변경 되면 Aloc 체크 */
						  || (!bkgBookingInfoVO.getStwgCd().equals(historyTableVO.getBkgBookingVO().getStwgCd()) && ("US".equals(bkgBookingInfoVO.getBkgPodCd().substring(0,2)) || "CA".equals(bkgBookingInfoVO.getBkgPodCd().substring(0,2))))
						){
							
						ConstraintMasterBC		spcBC = new ConstraintMasterBCImpl();	
						List<SpcSbBkgDtlVO> spcSbBkgDtlVO = new ArrayList<SpcSbBkgDtlVO>();
						boolean spcErrFlg = false;
	
						try{
							begin();
							spcSbBkgDtlVO = spcBC.standbyCheck4Bkg(bkgBlNoVO.getBkgNo(), account);
							commit();
						} catch(Exception spcEx){
							rollback();
							log.error("SPC Allocation error : " + spcEx.toString(), spcEx);
							spcErrFlg = true;
						}
						begin();
						if(spcErrFlg){
							//Error
							AllocStsVO allocStsVO = new AllocStsVO();
							allocStsVO.setAlocStsCd("");
							AllocStsChgVO allocStsChgVO2 = receiptBC.modifyAllocStatusForBkg(bkgBlNoVO, allocStsVO, account);
							// history
							HistoryLineVO historyLineVO = new HistoryLineVO();
							historyLineVO.setUiId("ESM_BKG_0079_01");			
							historyLineVO.setHisCateNm("Allocation Status");
							historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
							historyLineVO.setCaFlg("N");
							historyLineVO.setCrntCtnt("Error");
							historyLineVO.setPreCtnt(allocStsChgVO2.getOriAlocStsCd());
							historyBC.createBkgHistoryLine(historyLineVO, account);
							
						}else if(spcSbBkgDtlVO == null || spcSbBkgDtlVO.size()==0){
							//F
							AllocStsVO allocStsVO = new AllocStsVO();
							allocStsVO.setAlocStsCd("F");
							AllocStsChgVO allocStsChgVO2 = receiptBC.modifyAllocStatusForBkg(bkgBlNoVO, allocStsVO, account);
							// history
							if(!allocStsChgVO2.getAlocStsCd().equals(allocStsChgVO2.getOriAlocStsCd())){
								HistoryLineVO historyLineVO = new HistoryLineVO();
								historyLineVO.setUiId("ESM_BKG_0079_01");			
								historyLineVO.setHisCateNm("Allocation Status");
								historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
								historyLineVO.setCaFlg("N");
								historyLineVO.setCrntCtnt("F");
								historyLineVO.setPreCtnt(allocStsChgVO2.getOriAlocStsCd());
								historyBC.createBkgHistoryLine(historyLineVO, account);
							}
							if(allocStsChgVO2.getBkgNtcHisVOs().size()>0){
								historyBC.createBkgNtcHis(allocStsChgVO2.getBkgNtcHisVOs(), "ESM_BKG_0079_01");
							}
						}else if(spcSbBkgDtlVO != null && spcSbBkgDtlVO.size()>0){
							if(allocStsChgVO==null || allocStsChgVO.getAlocStsCd()==null || !"S".equals(allocStsChgVO.getAlocStsCd())){
								AllocStsVO allocStsVO = new AllocStsVO();
								allocStsVO.setChangeVvd(bookingSaveValidationVO.getChangeVvd());
								for(int i=0; i<spcSbBkgDtlVO.size(); i++){
			 						if(spcSbBkgDtlVO.get(i).getAlocSvcCd()!=null && "M".equals(spcSbBkgDtlVO.get(i).getAlocSvcCd())){
			 							alocPopFlg = "Y";
			 							allocStsVO.setAlocSvcCd("M");
			 						}
			 					}
	//							if(!"US".equals(bkgBookingInfoVO.getBkgPolCd().substring(0,2))
	//									&& !"CA".equals(bkgBookingInfoVO.getBkgPolCd().substring(0,2))){
	//								allocStsVO.setAlocStsCd("A");
	//							}else{
									allocStsVO.setAlocStsCd("S");
	//								if(!"Y".equals(alocPopFlg)){ 
	//									allocStsVO.setStandbyNtcFlg("Y");
	//								}
	//							}
								AllocStsChgVO allocStsChgVO2 = receiptBC.modifyAllocStatusForBkg(bkgBlNoVO, allocStsVO, account);
								// history
								if(!allocStsChgVO2.getAlocStsCd().equals(allocStsChgVO2.getOriAlocStsCd())){
									StringBuffer tmpBuffer = new StringBuffer(allocStsVO.getAlocStsCd());
									for(int i=0; i<spcSbBkgDtlVO.size(); i++){
										tmpBuffer.append("\n");
										tmpBuffer.append((spcSbBkgDtlVO.get(i).getLstSbRsnTpCd()==null)?"":spcSbBkgDtlVO.get(i).getLstSbRsnTpCd()).append("/");
										tmpBuffer.append((spcSbBkgDtlVO.get(i).getLstSbSubRsnCd()==null)?"":spcSbBkgDtlVO.get(i).getLstSbSubRsnCd()).append("/");
										tmpBuffer.append((spcSbBkgDtlVO.get(i).getAlocSvcCd()==null)?"":spcSbBkgDtlVO.get(i).getAlocSvcCd()).append("/");
										tmpBuffer.append((spcSbBkgDtlVO.get(i).getLstSbRsn()==null)?"":spcSbBkgDtlVO.get(i).getLstSbRsn());
									}
									HistoryLineVO historyLineVO = new HistoryLineVO();
									historyLineVO.setUiId("ESM_BKG_0079_01");			
									historyLineVO.setHisCateNm("Allocation Status");
									historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
									historyLineVO.setCaFlg("N");
									historyLineVO.setCrntCtnt(tmpBuffer.toString());
									historyBC.createBkgHistoryLine(historyLineVO, account);
									
									bookingSaveValidationVO.setAlocPopFlg(alocPopFlg);
									bookingSaveValidationVO.setFirmMsgFlg(allocStsChgVO2.getFirmMsgFlg());
								}
								if(allocStsChgVO2.getBkgNtcHisVOs().size()>0){
									historyBC.createBkgNtcHis(allocStsChgVO2.getBkgNtcHisVOs(), "ESM_BKG_0079_01");
								}
								
								/** OLBP 일때 F -> S 변경 시 사용자 알림 메세지 */
								if(bkgBookingInfoVO.getStwgCd().equals("OLBP"))
									bookingSaveValidationVO.setAlocStandByMsgFlg("Y");
							}
						}
						commit();
					}
				}	
				
				// SPC-BKG 연동 (NoRateStatus Firm 일 때만 SPC Aloc 체크)(E)
				//(E)
				
				// 19. coa interface, Standby 계산 뒤로 이동 
				begin();
				interfaceToMas(bkgBlNoVO, "Booking Update", account);
				commit();
				
				// No Rate Notice 발송
				//  -> !R : Reciept Notice
				//  ->  R : No Rate Notice
				if(oftPrecheckVO.getNonRtStsCd()!=null && "R".equals(oftPrecheckVO.getNonRtStsCd())){
					List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
					BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
					String sndId = null;
					Mail mail = null;
					String mailContents = null;
					
					String ssoTargetUrl = JSPUtil.getNull(SiteConfigFactory.get("COM.HANJIN.SSO.TARGET"));
					boolean isLive = false;     // Live 여부
					if (ssoTargetUrl.indexOf("alps.smlines.com") > 0) {
						// 2017.04.10 iylee No Rate 대상이여도 메일 발송 하지 않음.
						//isLive = true;
					}
					begin();
					if(isLive){
						if("Y".equals(noRtNtc_snd_cust_flg)){
							// No Rate Notice 발송 화주 (S)
							if(bkgBookingInfoVO.getBkgCntcPsonEml()!=null && !"".equals(bkgBookingInfoVO.getBkgCntcPsonEml())){
								mailContents = getNoRateNoticeToCustomer(bkgBlNoVO.getBkgNo());
								mail = new Mail();
								mail.setFrom("noreply@smlines.com");// 보내는사람
								mail.setRecipient(bkgBookingInfoVO.getBkgCntcPsonEml());// 받는사람
								//mail.setRecipient("popcorn426@cyberlogitec.com");
								String reqNo = "";
								String custRefNoCtnt = receiptBC.searchCustRefNoCtnt(bkgBlNoVO, "EBRF");
								if(custRefNoCtnt != null && custRefNoCtnt.length()>0){
									reqNo = "(Request No. "+custRefNoCtnt+")";
								}else{//BKG Request no. 없으면 BKG no.
									reqNo = "(Booking No. "+bkgBlNoVO.getBkgNo()+")";
								}
								mail.setSubject("Customer Notice "+reqNo);// 제목
								mail.setHtmlContent(mailContents);
								sndId = mail.send();// 메일전송
								//발송 history 내용 생성
								bkgNtcHisVO = new BkgNtcHisVO();
								bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
								bkgNtcHisVO.setNtcViaCd("M");
								bkgNtcHisVO.setNtcKndCd("NR"); // No Rate Notice
								bkgNtcHisVO.setNtcEml(bkgBookingInfoVO.getBkgCntcPsonEml());
								bkgNtcHisVO.setSndId(sndId);
								bkgNtcHisVO.setSndOfcCd("SYSTEM");
								bkgNtcHisVO.setSndUsrId("SYSTEM");
								bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
								bkgNtcHisVO.setCreUsrId(account.getUsr_id());
								bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
								bkgNtcHisVOs.add(bkgNtcHisVO);
								// No Rate Notice 발송 화주 (E)
							}
						}
						if("Y".equals(noRtNtc_snd_flg)){
							String srepEml = searchBC.searchSrepEml(bkgBookingInfoVO.getObSrepCd());//S.Rep e-Mail 조회
							if(srepEml != null && srepEml.length() > 0){
								// No Rate Notice 발송 S.Rep (S)
								mailContents = getNoRateNoticeToSrep(bkgBlNoVO.getBkgNo());
								mail = new Mail();
								mail.setFrom("noreply@smlines.com");// 보내는사람
								mail.setRecipient(srepEml);// 받는사람
								mail.setSubject("No rate booking Notice (Booking No . "+bkgBlNoVO.getBkgNo()+" )");// 제목
								mail.setHtmlContent(mailContents);
								sndId = mail.send();// 메일전송
								//No Rate Notice 발송 End S.Rep
								//발송 history
								bkgNtcHisVO = new BkgNtcHisVO();
								bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
								bkgNtcHisVO.setNtcViaCd("M");
								bkgNtcHisVO.setNtcKndCd("NR"); // No Rate Notice
								bkgNtcHisVO.setNtcEml(srepEml);
								bkgNtcHisVO.setSndId(sndId);
								bkgNtcHisVO.setSndOfcCd("SYSTEM");
								bkgNtcHisVO.setSndUsrId("SYSTEM");
								bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
								bkgNtcHisVO.setCreUsrId(account.getUsr_id());
								bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
								bkgNtcHisVOs.add(bkgNtcHisVO);
								// No Rate Notice 발송 S.Rep (E)
							}
						}
						// BKG Notice History 생성
						historyBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0079_01");
					}
					commit();
				}
				
				String rcvEml = "";
				rcvEml = receiptBC.searchConfirmBookingNotice(bkgBlNoVO.getBkgNo());
				if(rcvEml != null && rcvEml.length() > 0){
					begin();
					String mrdNm = "ESM_BKG_5005G";
					
					BkgBlNoVO[] bkgBlNoVOs = {bkgBlNoVO};
					String[]    eml        = {rcvEml};
					String[]    cct        = {""};
					String[]    docCct     = {""};
					String[]    rmk        = {""};
					
					BkgReceiptSendVO bkgReceiptSendVO = new BkgReceiptSendVO();
					bkgReceiptSendVO.setBkgBlNoVos(bkgBlNoVOs);
					bkgReceiptSendVO.setEmlAddrs(eml);
					bkgReceiptSendVO.setRemarks(rmk);
					bkgReceiptSendVO.setMrdNm(mrdNm);
					bkgReceiptSendVO.setCcts(cct);
					bkgReceiptSendVO.setDocCcts(docCct);
					GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
					List<BkgNtcHisVO> bkgNtcHisVOs2 = command.sendBkgReceiptByEmail(bkgReceiptSendVO, "", account);
					historyBC.createBkgNtcHis(bkgNtcHisVOs2, "ESM_BKG_0079_01");
					
					commit();
				}

				//backEndJop 전에 commit되어야함
				// 17. interfaceBKGARInvoiceToINV
				interfaceToInv(bkgBlNoVO, account);

				if (!"Y".equals(bkgBookingInfoVO.getEdiHldFlg())) {			
					// 12. sendBkgCustEdi
					searchBC.createCustBkgReceiptEdiBackEnd(bkgBlNoVO, null, "Y", account);

					//////////////////////////////////////////////////////////////////////////
					// customer301 전송 시작 - 2011.01.10
					// * VVD가 변경 되었고, cnee가 (CA:004510, US:001260)인 경우 전송
					// * 전송내용 : GroupID : COM01760, RCV ID : 6135830007
					if ("Y".equals(bookingSaveValidationVO.getChangeVvd()) ) { 

						CustTpIdVO custTpIdVo = util.searchCustTpIdInfo(bkgBookingInfoVO.getBkgNo());
						if( null != custTpIdVo ){
							List<BkgNtcHisVO> bkgNtcHisVOs = searchBC.createCustBkgReceiptEdi(bkgBlNoVO, custTpIdVo, "N", account);
							if (null!=bkgNtcHisVOs) {
								for (int i=0; i<bkgNtcHisVOs.size(); i++) {
									bkgNtcHisVOs.get(i).setSndId("SYSTEM");
									bkgNtcHisVOs.get(i).setSndUsrId("SYSTEM");
									bkgNtcHisVOs.get(i).setSndOfcCd("SYSTEM");
									bkgNtcHisVOs.get(i).setCreUsrId(account.getUsr_id());
									bkgNtcHisVOs.get(i).setUpdUsrId(account.getUsr_id());
								}
								historyBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0079_01");
							}
						}
					}

					// customer301 전송 끝 - 2011.01.10
					//////////////////////////////////////////////////////////////////////////
					// 13. sendBkgTmlEdi
					String brac = "X";
					brac = "Y".equals(bookingSaveValidationVO.getChangeVvd())?"B":"U";
					if(!"X".equals(brac)){
						
						if("B".equals(brac)){
							// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
							Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
							vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
							vender301ParamVO.setOldVvdVOs(historyTableVO.getBkgVvdVOs());
							vender301ParamVO.setOldQtyVOs(historyTableVO.getBkgQuantityVOs());
							vender301ParamVO.setOldMtyPkupYdCd(historyTableVO.getBkgBookingVO().getMtyPkupYdCd());
							vender301ParamVO.setBracCd(brac);
							vender301ParamVO.setEdiKind("BT");
							vender301ParamVO.setAutoManualFlg("Y");
							
							searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);
						} else {
							// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
							Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
							vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
							vender301ParamVO.setOldVvdVOs(null);
							vender301ParamVO.setOldQtyVOs(historyTableVO.getBkgQuantityVOs());
							vender301ParamVO.setOldMtyPkupYdCd(historyTableVO.getBkgBookingVO().getMtyPkupYdCd());
							vender301ParamVO.setBracCd(brac);
							vender301ParamVO.setEdiKind("BT");
							vender301ParamVO.setAutoManualFlg("Y");
							
							searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);
						}
					}

					if("SGSIN".equals(bkgBookingInfoVO.getBkgPolCd())){	
						String psaAuto = "N";
						if ( "Y".equals(bookingCreationVO.getBookingSaveValidationVO().getQtyModifyFlag())){
							psaAuto = "Y";
						} else {
							// Mty Pkup YD CD 값을 조회하여 변경되었을때에는 PSA를 새로 만들어 전송하도록 함. ( 2010.09.06 )
							List<BkgBookingVO> bkgBookingVOs = util.searchBookingSplitNo(bkgBlNoVO.getBkgNo());
							if ( !bkgBookingVOs.get(0).getMtyPkupYdCd().equals(historyTableVO.getBkgBookingVO().getMtyPkupYdCd())){
								psaAuto = "Y";
							}
						}
						bookingCreationVO.setPsaValCode(this.managePSABKGAuto(bkgBookingInfoVO.getBkgNo(), psaAuto));
					}
				}
				
				if( "SEL".equals(bkgBookingInfoVO.getBkgNo().substring(0, 3))){ 
					//sms 전송
					sendPolVvdSms(bkgBlNoVO, historyTableVO, bkgBookingInfoVO, oldBkgInfoVO);
				}
				
				//for t/s booking close
				if(bookingSaveValidationVO.getClosedTsVvd() != null
						&& bookingSaveValidationVO.getClosedTsVvd().length() > 0){
					receiptBC.sendTsCloseNotice(bkgBlNoVO, bookingSaveValidationVO.getClosedTsVvd(), account);
				}
				
				//for notice to customer
				if(bookingSaveValidationVO.getCustNtcFlg().equals("Y")){
                    begin();
					List<BkgBlNoVO> bkgBlNoVOs = new ArrayList<BkgBlNoVO>();
					bkgBlNoVOs.add(bkgBlNoVO);
					List<BkgNtcHisVO> bkgNtcHisVOs = searchBC.sendBkgVslReviseNotice(bkgBlNoVOs, bookingSaveValidationVO.getVslCngRsn(), account);
					if (null!=bkgNtcHisVOs) {
						for (int i=0; i<bkgNtcHisVOs.size(); i++) {
							bkgNtcHisVOs.get(i).setCreUsrId(account.getUsr_id());
							bkgNtcHisVOs.get(i).setUpdUsrId(account.getUsr_id());
						}
						historyBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0079_01");
					}
					commit();
				}
				
				//CM탭에 Self가 찍혀 있으면서 US filer가 01인 경우 이메일 발송(이메일이 한 번도 나가지 않은 경우만)
				String usFiler = bkgBookingInfoVO.getUsaCstmsFileCd();
				String selfFlg = blDocBLBC.chkSelfFlgCM(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getCaFlg());
				
				//us filer가 1이고 CM에 self가 있을 때 이메일 전송
				if("1".equalsIgnoreCase(usFiler) && "Y".equalsIgnoreCase(selfFlg)){
					String emlArr[] = new String[2];
					CmSelfMailVO cmSelfMailVO = new CmSelfMailVO();
					//조건에 맞으면, BKG와 SI Contact email 주소를 가져온다
					emlArr = blDocBLBC.checkSelfFilingCM(bkgBlNoVO.getBkgNo(),bkgBlNoVO.getCaFlg());
					
					StringBuffer emlAdd = new StringBuffer();
					
					//한 번 성공적으로 전송된 이력이 있으면 다시 보내지 않음.
					String chkCmSelfEmailFlg = blDocBLBC.chkCsEmailHisoty(bkgBlNoVO.getBkgNo());
					
					if(emlArr!=null && emlArr.length>1 &&("N".equalsIgnoreCase(chkCmSelfEmailFlg))){
						if(!"".equalsIgnoreCase(emlArr[0])){
							for(int i=0; i<emlArr.length;i++){
								emlAdd = emlAdd.append(emlArr[i]);
								emlAdd = emlAdd.append(";");
							}
							
							begin();
							//이메일에 들어갈 데이터 search
							cmSelfMailVO = blDocBLBC.searchContentsForSelfMail(bkgBlNoVO.getBkgNo(),bkgBlNoVO.getCaFlg());
							
							/* 1. Send Email */
							List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
							BkgNtcHisVO bkgNtcHisVO = blDocBLBC.sendChkSelfCMByEmail(bkgBlNoVO.getBkgNo(),emlAdd.toString(),cmSelfMailVO);
							bkgNtcHisVOs.add(bkgNtcHisVO);
							/* 2. Register Notice History */
							historyBC.createBkgNtcHis(bkgNtcHisVOs, account.getUsr_id());
							commit();
						}
						log.debug("=====> eml_address    : " + emlAdd);
					}
						
				}
			} else {
				//c/a 진행 중 일 경우
				commit();
				if("Y".equals(bookingSaveValidationVO.getChangeVvd())){
					try{
						// cut off time (cop 생성 이후에 처리)
						String fromDt = null;
						String toDt   = null;
						
						if("US".equals(bkgBookingInfoVO.getBkgPorCd().substring(0, 2))
								|| "CA".equals(bkgBookingInfoVO.getBkgPorCd().substring(0, 2))){
							ProductCatalogCreateBC prdBC   = new ProductCatalogCreateBCImpl();
							BkgQuantityVO[] bkgQuantityVOs = bookingCreationVO.getBkgQuantityVOs();
							PrdQtyInfoVO[]  prdQtyInfo 	   = new PrdQtyInfoVO[bkgQuantityVOs.length];
							
							for(int i = 0 ; i < bkgQuantityVOs.length ; i++){	
								prdQtyInfo[i] = new PrdQtyInfoVO();				
								prdQtyInfo[i].setCTpsz(bkgQuantityVOs[i].getCntrTpszCd());
								prdQtyInfo[i].setCQty(bkgQuantityVOs[i].getOpCntrQty());				
							}
							 
							Map railTime = prdBC.getRailRecevingTime(bkgBlNoVO.getPctlNo(), prdQtyInfo, null, null, bkgBlNoVO.getBkgNo()); 
							
							fromDt= (String)railTime.get("RTN_TIME");
							toDt  = (String)railTime.get("CUT_OFF");
						}
						
						HistoryTableVO clzTmHistVO = historyBC.searchOldBkgForHistory("ESM_BKG_0721", bkgBlNoVO);
						
						begin(); //batch 서버 접속해야되서 Transaction을 분리함
						receiptBC.createCargoClosingTime(bkgBlNoVO, fromDt, toDt, account);
						historyBC.manageBookingHistory("ESM_BKG_0721", clzTmHistVO, account);
						commit();	
						
						
						
					} catch(Exception prdEx){
						rollback();
						log.error("err rail time:"+prdEx.toString(),prdEx);
					}
				}
			}
			
			bookingCreationVO.setBookingSaveValidationVO(bookingSaveValidationVO);
		}catch(EventException e){			
			throw e;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);			
		}
		return bookingCreationVO;
	}
	
   	/**
	 * 한국 BKG의 경우 첫 VVD, POL 변경 시<br>
	 * 지정된 번호로 SMS를 보냄<br>
	 *
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param HistoryTableVO historyTableVO
	 * @param BkgBookingInfoVO bkgBookingInfoVO
	 * @param OldBkgInfoVO oldBkgInfoVO
	 * @exception 	EventException
	 */
	private void sendPolVvdSms(BkgBlNoVO bkgBlNoVO, HistoryTableVO historyTableVO,
			BkgBookingInfoVO bkgBookingInfoVO, OldBkgInfoVO oldBkgInfoVO) throws EventException{
		GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
		GeneralBookingSearchBC  searchBC 	= new GeneralBookingSearchBCImpl();
		BookingHistoryMgtBC 	historyBC 	= new BookingHistoryMgtBCImpl();
		BookingUtil util = new BookingUtil();
		try {
			// sms 전송로직 추가 .jsy ,modifyBkgInfo 
			List<VslSkdVO> vslSkdVOs = receiptBC.searchVvdSkdForTsRoute(bkgBlNoVO);
			List<BkgUserSmsListVO> smsList = null;
			List<BkgNtcHisVO> bkgNtcHisVOs = null;
			String sndMsg ="";
			String skdDirCd = "";
			String svcLaneCd = "";
	
			String newFirstVvd = "";
			String oldFirstVvd = "";
			String oldSlanCd = "";
			String bkgPolCdOld = "";
			String newFirstVvdPod = "";
			String oldFirstVvdPod = "";
			String sndParam = "";
			
			if(vslSkdVOs != null && vslSkdVOs.size()>0){
				newFirstVvd =  vslSkdVOs.get(0).getBkgVvdCd();
				newFirstVvdPod = vslSkdVOs.get(0).getPodCd();
			}
			if(historyTableVO != null && historyTableVO.getBkgBookingVO() != null){
				bkgPolCdOld =  historyTableVO.getBkgBookingVO().getPolCd();
			}
			if(historyTableVO != null && historyTableVO.getBkgVvdVOs() != null){
				oldFirstVvdPod  = historyTableVO.getBkgVvdVOs().get(0).getPodCd();
			}
			oldFirstVvd = oldBkgInfoVO.getFirstVvd();
			oldSlanCd = util.searchSvcLaneByVvd(oldFirstVvd);
			
//			log.debug("\nsms call:SEL?" + bkgBookingInfoVO.getBkgNo().substring(0, 3)+"\n"+
//					"첫배 vvd 변경 조건: "+receiptBC.chkSmsRequirementVvdChanged(bkgBookingInfoVO.getBkgNo(), oldFirstVvd, newFirstVvd,bkgBookingInfoVO.getBkgPolCd(),bkgPolCdOld  )+"\n"+
//					"newFirstVvd:"+newFirstVvd+"\n"+
//					"oldFirstVvd:"+oldFirstVvd+"\n"+
//					"polyd:"+bkgBookingInfoVO.getBkgPolYdCd()
//			    	);	
			List<SmsRequirementResultVO> smsReqList = null;
			String bkgInfoPolYdCd ="";
			boolean bOldVvd = false; 
			boolean bNewVvd = false; 
			boolean bOldSlanCd = false; 
			boolean bNewSlanCd = false; 
			boolean bCntrCntChk = false;  //컨테이너 없이 부킹번호만 추가 및 취소 되는 경우는 메세지 발송 대상에서 제외
			boolean bPolYdChk = false;    //POL Yard를 파라미터에 추가하여 BKG_CSTMS_TML_KR_CLL 의 POL_YD_CD와 비교하여 일치하는 경우만 전송
			boolean bDoubleCallingChk = false; //POL Yard 변경시 VSK_VSL_PORT_SKD 상에서 double calling 인 경우 메시지 전송
			boolean bFinalCllPolYdChk = false;    	//NEW POL Yard를 파라미터에 추가하여 BKG_CSTMS_TML_KR_CLL 의 POL_YD_CD와 비교하여 일치하는 경우만 전송
			boolean bFinalCllOldPolYdChk = false;	//OLD POL Yard를 파라미터에 추가하여 BKG_CSTMS_TML_KR_CLL 의 POL_YD_CD와 비교하여 일치하는 경우만 전송
			String sCllVvd ="";
			smsReqList = receiptBC.getSmsRequirementResult(bkgBookingInfoVO.getBkgNo(), oldFirstVvd, newFirstVvd, bkgBookingInfoVO.getBkgPolCd(),bkgPolCdOld);
			//CLL edi 전송여부 확인 
			for (int i = 0; i < smsReqList.size(); i++) {
				String cllVvd = smsReqList.get(i).getVvd();
				String cllSlanCd = smsReqList.get(i).getSlanCd();
				if( newFirstVvd.equals(cllVvd)) {
					bNewVvd = true;
					sCllVvd = cllVvd;
				}
				if( oldFirstVvd.equals(cllVvd)) {
					bOldVvd = true;
					sCllVvd = cllVvd;
				}
				if( vslSkdVOs.get(0).getSlanCd().equals(cllSlanCd)) {
					bNewSlanCd = true;
				}
				if( oldSlanCd.equals(cllSlanCd)) {
					bOldSlanCd = true;
				}
				log.debug("\nsmsReqList.get(i).getCntrCnt():"+smsReqList.get(i).getCntrCnt()+"\n"
						);
				if( Integer.parseInt(smsReqList.get(i).getCntrCnt())>0 ) {
					bCntrCntChk = true;
				}
				bkgInfoPolYdCd = bkgBookingInfoVO.getBkgPolYdCd()==null? "":bkgBookingInfoVO.getBkgPolYdCd();
				
				bkgInfoPolYdCd = bkgInfoPolYdCd.length() ==7 ? bkgInfoPolYdCd : bkgBookingInfoVO.getBkgPolCd()+bkgInfoPolYdCd;  
				if( bkgInfoPolYdCd.equals(historyTableVO.getBkgBookingVO().getPolNodCd())) {
					bPolYdChk = true;
				}
				if( "Y".equals(smsReqList.get(i).getDcFlg() ) ) {
					bDoubleCallingChk = true;
				}
				if(bkgInfoPolYdCd.equals(smsReqList.get(i).getPolYd()) && newFirstVvd.equals(cllVvd)) {
					bFinalCllPolYdChk = true;
				}
				if(historyTableVO.getBkgBookingVO().getPolNodCd().equals(smsReqList.get(i).getPolYd()) && oldFirstVvd.equals(cllVvd)) {
					bFinalCllOldPolYdChk = true;
				}
				log.debug("\nbNewVvd:"+bNewVvd+"\n"+
						"OldVvd:"+bOldVvd+"\n"+
						"NewSlanCd:"+bNewSlanCd+"\n"+
						"OldSlanCd:"+bOldSlanCd+"\n"+
						"bCntrCntChk:"+bCntrCntChk+"\n"+
						"bPolYdChk:"+bPolYdChk+"\n"+
						"bDoubleCallingChk:"+bDoubleCallingChk+"\n"
						);
			}
			//1. 첫배 vvd 변경 (pod변경이 없어도) 
			if( "SEL".equals(bkgBookingInfoVO.getBkgNo().substring(0, 3) ) 
					&& !newFirstVvd.equals(oldFirstVvd)
					&& receiptBC.chkSmsRequirementVvdChanged(bkgBookingInfoVO.getBkgNo(), oldFirstVvd, newFirstVvd, bkgBookingInfoVO.getBkgPolCd(),bkgPolCdOld ) 
					&& bCntrCntChk) {
				//vvd 변경  -메세지 전송
				begin();
				if( bNewVvd && bFinalCllPolYdChk){						
					skdDirCd = newFirstVvd.substring(8,9);
					svcLaneCd= util.searchSvcLaneByVvd(newFirstVvd);
					smsList = receiptBC.getPhnId(svcLaneCd, bkgBookingInfoVO.getBkgOfcCd(), skdDirCd, bkgBookingInfoVO.getBkgPolCd(), bkgBookingInfoVO.getBkgNo());
					log.debug("\n 첫배vvd변경  , sms 전송 리스트 size:"+smsList.size());
//					sndMsg = "\n\n(" + svcLaneCd+"-" + skdDirCd+") " +" " + newFirstVvd+" "+ bkgBookingInfoVO.getBkgNo()+" 선적 추가 발생 " ;
					if("Y".equalsIgnoreCase(bkgBookingInfoVO.getDcgoFlg())){
						sndMsg = "\n\n(" + svcLaneCd+"-" + skdDirCd+") " +" " + newFirstVvd+" "+ bkgBookingInfoVO.getBkgNo()+" (DG Cargo 선적) "+" 선적 추가 발생 " ;
					}else{
						sndMsg = "\n\n(" + svcLaneCd+"-" + skdDirCd+") " +" " + newFirstVvd+" "+ bkgBookingInfoVO.getBkgNo()+" 선적 추가 발생 " ;
					}
					//sendMailByPodChange(smsList, bkgBookingInfoVO.getBkgNo(), sndMsg );
					sndParam = //"/rv gubun[CI] vvd["+newFirstVvd+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
					           "/rv gubun[CI] vvd["+newFirstVvd+"] old_vvd["+oldFirstVvd+"]  pol_cd["+bkgPolCdOld+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
					bkgNtcHisVOs = searchBC.sendMailSmsByPodChange(smsList,  bkgBookingInfoVO.getBkgNo(), sndMsg, sndParam, account );
					historyBC.createBkgNtcHis(bkgNtcHisVOs, "");
				}
				if( bOldVvd && bFinalCllOldPolYdChk){
					skdDirCd = oldFirstVvd.substring(8,9);
					svcLaneCd= util.searchSvcLaneByVvd(oldFirstVvd);
					smsList = receiptBC.getPhnId(svcLaneCd, bkgBookingInfoVO.getBkgOfcCd(), skdDirCd, bkgBookingInfoVO.getBkgPolCd(), bkgBookingInfoVO.getBkgNo());
					log.debug("\n 첫배vvd변경  , sms 전송 리스트 size:::"+smsList.size());
//					sndMsg = "\n\n(" + svcLaneCd+"-" + skdDirCd+") " +" " + oldFirstVvd+" "+ bkgBookingInfoVO.getBkgNo()+" 선적 취소 발생 " ;
					if("Y".equalsIgnoreCase(bkgBookingInfoVO.getDcgoFlg())){
						sndMsg = "\n\n(" + svcLaneCd+"-" + skdDirCd+") " +" " + oldFirstVvd+" "+ bkgBookingInfoVO.getBkgNo()+" (DG Cargo 선적) "+" 선적 취소 발생 " ;
					}else{
						sndMsg = "\n\n(" + svcLaneCd+"-" + skdDirCd+") " +" " + oldFirstVvd+" "+ bkgBookingInfoVO.getBkgNo()+" 선적 취소 발생 " ;
					}
					//sendMailByPodChange(smsList, bkgBookingInfoVO.getBkgNo(), sndMsg );
					sndParam = //"/rv gubun[CD] vvd["+oldFirstVvd+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
							   "/rv gubun[CD] vvd["+oldFirstVvd+"] old_vvd["+oldFirstVvd+"]  pol_cd["+bkgPolCdOld+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
					bkgNtcHisVOs = searchBC.sendMailSmsByPodChange(smsList,  bkgBookingInfoVO.getBkgNo(), sndMsg, sndParam, account );
					historyBC.createBkgNtcHis(bkgNtcHisVOs, "");						
				}
				commit();					
			} else {
				//2.POD 변경 조건 
				if( "SEL".equals(bkgBookingInfoVO.getBkgNo().substring(0, 3) ) 
						&& !newFirstVvdPod.equals(oldFirstVvdPod)
		//				&& receiptBC.chkSmsRequirement(bkgBookingInfoVO.getBkgNo()) ) {
						&& receiptBC.chkSmsRequirementVvdChanged(bkgBookingInfoVO.getBkgNo(), oldFirstVvd, newFirstVvd, bkgBookingInfoVO.getBkgPolCd(),bkgPolCdOld) 
						&& bCntrCntChk 
						&& (bFinalCllPolYdChk || bFinalCllOldPolYdChk)) {					
					skdDirCd = newFirstVvd.substring(8,9);
					
					//보낼 대상 조회.
					// sms 전송 					
					if( vslSkdVOs.get(0).getSlanCd().equals(oldSlanCd) && bNewSlanCd ) {
						//lane 변경 없음 -단건 전송
						smsList = receiptBC.getPhnId(vslSkdVOs.get(0).getSlanCd(), bkgBookingInfoVO.getBkgOfcCd(), skdDirCd, bkgBookingInfoVO.getBkgPolCd(), bkgBookingInfoVO.getBkgNo()); 
						log.debug("\npod변경 lane변경업음 , sms 전송 리스트 size:"+smsList.size());
						//전송 메세지.
//						sndMsg = "\n\n(" + vslSkdVOs.get(0).getSlanCd()+"-" + skdDirCd+") " +" " + newFirstVvd+" "+ bkgBookingInfoVO.getBkgNo()+" POD 변경 발생 " ;
						if("Y".equalsIgnoreCase(bkgBookingInfoVO.getDcgoFlg())){
							sndMsg = "\n\n(" + vslSkdVOs.get(0).getSlanCd()+"-" + skdDirCd+") " +" " + newFirstVvd+" "+ bkgBookingInfoVO.getBkgNo()+" (DG Cargo 선적) "+" POD 변경 발생 " ;
						}else{
							sndMsg = "\n\n(" + vslSkdVOs.get(0).getSlanCd()+"-" + skdDirCd+") " +" " + newFirstVvd+" "+ bkgBookingInfoVO.getBkgNo()+" POD 변경 발생 " ;
						}
						begin();
						//sendMailByPodChange(smsList, bkgBookingInfoVO.getBkgNo(), sndMsg );

						sndParam = //"/rv gubun[POD] vvd["+newFirstVvd+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
						           "/rv gubun[POD] vvd["+newFirstVvd+"] old_vvd["+oldFirstVvd+"]  pol_cd["+bkgPolCdOld+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
						bkgNtcHisVOs = searchBC.sendMailSmsByPodChange(smsList, bkgBookingInfoVO.getBkgNo(), sndMsg, sndParam, account );
						historyBC.createBkgNtcHis(bkgNtcHisVOs, "");						
						commit();						
					} else {
						begin();						
						if( bOldSlanCd ){							
							//lane 변경  -최대 메세지 2건 전송
							//변경전 lane에 발송
//							log.debug("\nsms call:SEL?" + bkgBookingInfoVO.getBkgNo().substring(0, 3)+"\n"+
//									"첫배 vvd 변경 조건: "+receiptBC.chkSmsRequirementVvdChanged(bkgBookingInfoVO.getBkgNo(), oldFirstVvd, newFirstVvd, bkgBookingInfoVO.getBkgPolCd(),bkgPolCdOld )+"\n"+
//									"newFirstVvd:"+newFirstVvd+"\n"+
//									"oldFirstVvd:"+oldFirstVvd+"\n"+
//									"newlane:"+vslSkdVOs.get(0).getSlanCd()+"\n"+
//									"oldLane:"+oldSlanCd
//							);	
							smsList = receiptBC.getPhnId(oldSlanCd, historyTableVO.getBkgBookingVO().getBkgOfcCd(), skdDirCd, bkgBookingInfoVO.getBkgPolCd(), bkgBookingInfoVO.getBkgNo());
							log.debug("\npod변경 lane변경 (변경전 lane) , sms 전송 리스트 size:"+smsList.size());
		//				    String tVvd = historyTableVO.getBkgBookingVO().getVslCd()
		//							+historyTableVO.getBkgBookingVO().getSkdVoyNo()
		//				            +historyTableVO.getBkgBookingVO().getSkdDirCd();
							
							//lane 변경전 전송 메세지.
//							sndMsg = "\n\n(" + oldSlanCd+"-" + skdDirCd+") " +" " + oldFirstVvd +" "+ historyTableVO.getBkgBookingVO().getBkgNo()+" POD 변경 발생 " ;
							if("Y".equalsIgnoreCase(bkgBookingInfoVO.getDcgoFlg())){
								sndMsg = "\n\n(" + oldSlanCd+"-" + skdDirCd+") " +" " + oldFirstVvd +" "+ historyTableVO.getBkgBookingVO().getBkgNo()+" (DG Cargo 선적) "+" POD 변경 발생 " ;
							}else{
								sndMsg = "\n\n(" + oldSlanCd+"-" + skdDirCd+") " +" " + oldFirstVvd +" "+ historyTableVO.getBkgBookingVO().getBkgNo()+" POD 변경 발생 " ;
							}
							//sendMailByPodChange(smsList, historyTableVO.getBkgBookingVO().getBkgNo(), sndMsg );
							sndParam = //"/rv gubun[POD] vvd["+oldFirstVvd+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
							           "/rv gubun[POD] vvd["+newFirstVvd+"] old_vvd["+oldFirstVvd+"]  pol_cd["+bkgPolCdOld+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
							bkgNtcHisVOs = searchBC.sendMailSmsByPodChange(smsList, historyTableVO.getBkgBookingVO().getBkgNo(), sndMsg, sndParam, account );
							historyBC.createBkgNtcHis(bkgNtcHisVOs, "");
						}
						
						if( bNewSlanCd){							
							//변경된 lane에 발송 
							smsList = receiptBC.getPhnId(vslSkdVOs.get(0).getSlanCd(), bkgBookingInfoVO.getBkgOfcCd(), skdDirCd, bkgBookingInfoVO.getBkgPolCd(), bkgBookingInfoVO.getBkgNo());
							log.debug("\npod변경 lane변경 (변경후 lane) , sms 전송 리스트 size:"+smsList.size());
//							sndMsg = "\n\n(" + vslSkdVOs.get(0).getSlanCd()+"-" + skdDirCd+") " +" " + newFirstVvd+" "+ bkgBookingInfoVO.getBkgNo()+" POD변경, 선적 추가 발생 " ;
							if("Y".equalsIgnoreCase(bkgBookingInfoVO.getDcgoFlg())){
								sndMsg = "\n\n(" + vslSkdVOs.get(0).getSlanCd()+"-" + skdDirCd+") " +" " + newFirstVvd+" "+ bkgBookingInfoVO.getBkgNo()+" (DG Cargo 선적) "+" POD변경, 선적 추가 발생 " ;
							}else{
								sndMsg = "\n\n(" + vslSkdVOs.get(0).getSlanCd()+"-" + skdDirCd+") " +" " + newFirstVvd+" "+ bkgBookingInfoVO.getBkgNo()+" POD변경, 선적 추가 발생 " ;
							}
							//sendMailByPodChange(smsList, bkgBookingInfoVO.getBkgNo(), sndMsg );
							sndParam = //"/rv gubun[POD] vvd["+newFirstVvd+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
							           "/rv gubun[POD] vvd["+newFirstVvd+"] old_vvd["+oldFirstVvd+"]  pol_cd["+bkgPolCdOld+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
							bkgNtcHisVOs = searchBC.sendMailSmsByPodChange(smsList,  bkgBookingInfoVO.getBkgNo(), sndMsg, sndParam, account );
							historyBC.createBkgNtcHis(bkgNtcHisVOs, "");
						}
						commit();
					}					
				} else 
					if( bDoubleCallingChk && !bPolYdChk && bCntrCntChk && (bFinalCllPolYdChk ||bFinalCllOldPolYdChk)){ // double calling 이고 pol yd가 다르면 
						svcLaneCd = bNewSlanCd ? vslSkdVOs.get(0).getSlanCd(): oldSlanCd;
					skdDirCd = sCllVvd.substring(8,9);
					//메세지 " HJGI0025E  SEL1C7341600 YARD CODE 변경"
					smsList = receiptBC.getPhnId(svcLaneCd, bkgBookingInfoVO.getBkgOfcCd(), skdDirCd, bkgBookingInfoVO.getBkgPolCd(), bkgBookingInfoVO.getBkgNo()); 
					log.debug("\npod변경 double calling , sms 전송 리스트 size:"+smsList.size());
					//전송 메세지.
//					sndMsg = "\n\n(" + svcLaneCd+"-" + skdDirCd+") " + sCllVvd+" "+ bkgBookingInfoVO.getBkgNo()+" YARD CODE 변경 발생 " ;
					if("Y".equalsIgnoreCase(bkgBookingInfoVO.getDcgoFlg())){
						sndMsg = "\n\n(" + svcLaneCd+"-" + skdDirCd+") " + sCllVvd+" "+ bkgBookingInfoVO.getBkgNo()+" (DG Cargo 선적) "+" YARD CODE 변경 발생 " ;
					}else{
						sndMsg = "\n\n(" + svcLaneCd+"-" + skdDirCd+") " + sCllVvd+" "+ bkgBookingInfoVO.getBkgNo()+" YARD CODE 변경 발생 " ;
					}
					log.debug("\n  sndMsgsndMsg:"+sndMsg);
				
					begin();
					//sendMailByPodChange(smsList, bkgBookingInfoVO.getBkgNo(), sndMsg );
					sndParam = //"/rv gubun[YARD] vvd["+sCllVvd+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
						       "/rv gubun[YARD] vvd["+sCllVvd+"] old_vvd["+sCllVvd+"]  pol_cd["+bkgPolCdOld+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";

					bkgNtcHisVOs = searchBC.sendMailSmsByPodChange(smsList, bkgBookingInfoVO.getBkgNo(), sndMsg, sndParam, account );
					historyBC.createBkgNtcHis(bkgNtcHisVOs, "");					
					commit();
				} else if ("SEL".equals(bkgBookingInfoVO.getBkgNo().substring(0, 3) ) 
						&& ((bOldVvd && bFinalCllOldPolYdChk) || (bNewVvd && bFinalCllPolYdChk)) 
						&& !bkgBookingInfoVO.getBkgPolCd().equals(historyTableVO.getBkgBookingVO().getPolCd())
						&& bCntrCntChk) {
					svcLaneCd = oldSlanCd;
					skdDirCd = sCllVvd.substring(8,9);
					//메세지 " HJGI0025E  SEL1C7341600 YARD CODE 변경"
					smsList = receiptBC.getPhnId(svcLaneCd, bkgBookingInfoVO.getBkgOfcCd(), skdDirCd, bkgBookingInfoVO.getBkgPolCd(), bkgBookingInfoVO.getBkgNo()); 
					log.debug("\npol변경 , sms 전송 리스트 size:"+smsList.size());
					//전송 메세지.
//					sndMsg = "\n\n(" + svcLaneCd+"-" + skdDirCd+") " + sCllVvd+" "+ bkgBookingInfoVO.getBkgNo()+" POL CODE 변경 발생 " ;
					if("Y".equalsIgnoreCase(bkgBookingInfoVO.getDcgoFlg())){
						sndMsg = "\n\n(" + svcLaneCd+"-" + skdDirCd+") " + sCllVvd+" "+ bkgBookingInfoVO.getBkgNo()+" (DG Cargo 선적) "+" POL CODE 변경 발생 " ;
					}else{
						sndMsg = "\n\n(" + svcLaneCd+"-" + skdDirCd+") " + sCllVvd+" "+ bkgBookingInfoVO.getBkgNo()+" POL CODE 변경 발생 " ;
					}
					log.debug("\n  sndMsgsndMsg:"+sndMsg);
				
					begin();
					//sendMailByPodChange(smsList, bkgBookingInfoVO.getBkgNo(), sndMsg );
					sndParam = //"/rv gubun[CID] vvd["+sCllVvd+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
					           "/rv gubun[CID] vvd["+sCllVvd+"] old_vvd["+oldFirstVvd+"]  pol_cd["+bkgPolCdOld+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
					bkgNtcHisVOs = searchBC.sendMailSmsByPodChange(smsList, bkgBookingInfoVO.getBkgNo(), sndMsg, sndParam, account );
					historyBC.createBkgNtcHis(bkgNtcHisVOs, "");				
					commit();
				}
			}
		}catch(EventException e){			
			throw e;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);			
		}
	}

	/**
	 * ESM_BKG_0099 : retrieve <br>  
	 * booking split 화면에서 split시 참고할 data를 조회한다. <br>
	 *  
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgForSplit(Event e) throws EventException{
		try{
			EsmBkg0099Event event = (EsmBkg0099Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			GeneralBookingSplitCombineBC command = new GeneralBookingSplitCombineBCImpl();
			BookingUtil util = new BookingUtil();
			
			BkgForSplitVO bkgForSplitVO = new BkgForSplitVO();
			bkgForSplitVO = command.searchBkgForSplit (event.getBkgBlNoVO(),account);
			
			List<BkgBlForSplitVO> splitVOs = bkgForSplitVO.getBkgBlForSplitVO();
			
			eventResponse.setETCData("bkg_no",			(splitVOs.size()>0)? splitVOs.get(0).getBkgNo():"");
			eventResponse.setETCData("bl_no",			(splitVOs.size()>0)? splitVOs.get(0).getBlNo():"");
			eventResponse.setETCData("tvvd",			(splitVOs.size()>0)? splitVOs.get(0).getTvvd():"");
			eventResponse.setETCData("por_cd",			(splitVOs.size()>0)? splitVOs.get(0).getPorCd():"");
			eventResponse.setETCData("pol_cd",			(splitVOs.size()>0)? splitVOs.get(0).getPolCd():"");
			eventResponse.setETCData("pod_cd",			(splitVOs.size()>0)? splitVOs.get(0).getPodCd():"");
			eventResponse.setETCData("del_cd",			(splitVOs.size()>0)? splitVOs.get(0).getDelCd():"");
			eventResponse.setETCData("stwg_cd",			(splitVOs.size()>0)? splitVOs.get(0).getStwgCd():"");
			eventResponse.setETCData("rail_blk_cd",		(splitVOs.size()>0)? splitVOs.get(0).getRailBlkCd():"");
			eventResponse.setETCData("fd_grd_flg",		(splitVOs.size()>0)? splitVOs.get(0).getFdGrdFlg():"");
			eventResponse.setETCData("hngr_flg",		(splitVOs.size()>0)? splitVOs.get(0).getHngrFlg():"");
			eventResponse.setETCData("prct_flg",		(splitVOs.size()>0)? splitVOs.get(0).getPrctFlg():"");
			eventResponse.setETCData("stop_off_loc_cd",	(splitVOs.size()>0)? splitVOs.get(0).getStopOffLocCd():"");
			eventResponse.setETCData("spcl_hide_flg",	(splitVOs.size()>0)? splitVOs.get(0).getSpclHideFlg():"");
			eventResponse.setETCData("remark",			(splitVOs.size()>0)? splitVOs.get(0).getRemark():"");
			eventResponse.setETCData("dg",				(splitVOs.size()>0)? splitVOs.get(0).getDg():"");
			eventResponse.setETCData("rf",				(splitVOs.size()>0)? splitVOs.get(0).getRf():"");
			eventResponse.setETCData("ak",				(splitVOs.size()>0)? splitVOs.get(0).getAk():"");
			eventResponse.setETCData("bb",				(splitVOs.size()>0)? splitVOs.get(0).getBb():"");
			eventResponse.setETCData("pctl_no",			(splitVOs.size()>0)? splitVOs.get(0).getPctlNo():"");
			eventResponse.setETCData("bdr_flag",		(splitVOs.size()>0)? splitVOs.get(0).getBdrFlg():"");
			eventResponse.setETCData("tro_flg",			(splitVOs.size()>0)? splitVOs.get(0).getTroFlg():"");
			eventResponse.setETCData("splitFlg",		(splitVOs.size()>0)? JSPUtil.getNull(splitVOs.get(0).getSplitFlg()):"");
			eventResponse.setETCData("bkgStsCd",		(splitVOs.size()>0)? JSPUtil.getNull(splitVOs.get(0).getBkgStsCd()):"");
			eventResponse.setETCData("troTp",			(splitVOs.size()>0)? JSPUtil.getNull(splitVOs.get(0).getTroTp()):"");
			eventResponse.setETCData("bkg_close_flg",	(splitVOs.size()>0)? JSPUtil.getNull(splitVOs.get(0).getBkgClose()):"");
			eventResponse.setETCData("obl_iss_flg",		(splitVOs.size()>0)? JSPUtil.getNull(splitVOs.get(0).getOblIssFlg()):"");
			eventResponse.setETCData("edi_hld_flg",		(splitVOs.size()>0)? splitVOs.get(0).getEdiHldFlg():"N");
			eventResponse.setETCData("lt_flg",			(splitVOs.size()>0)? splitVOs.get(0).getLtFlg():"N");
			eventResponse.setETCData("fumg_loc_cd",		(splitVOs.size()>0)? splitVOs.get(0).getStopOffLocCd():"");
			eventResponse.setETCData("spcl_hide_lnr_flg",(splitVOs.size()>0)? splitVOs.get(0).getSpclHideFlg():"");
			eventResponse.setETCData("veh_cmdt_flg",    (splitVOs.size()>0)? splitVOs.get(0).getVehCmdtFlg():"");
			
			eventResponse.setETCData("custSplitNo",		(bkgForSplitVO.getLastSplitNoVO().size()>0)? bkgForSplitVO.getLastSplitNoVO().get(0).getCustsplitno():"");
			eventResponse.setETCData("memoSplitNo",		(bkgForSplitVO.getLastSplitNoVO().size()>0)? bkgForSplitVO.getLastSplitNoVO().get(0).getMemosplitno():"");
			eventResponse.setETCData("bkgsplitno",		(bkgForSplitVO.getLastSplitNoVO().size()>0)? JSPUtil.getNull(bkgForSplitVO.getLastSplitNoVO().get(0).getBkgsplitno()):"");
			
			
			eventResponse.setRsVoList(bkgForSplitVO.getBkgBlForSplitVO());
			eventResponse.setRsVoList(bkgForSplitVO.getBkgQuantityVO());
			eventResponse.setRsVoList(bkgForSplitVO.getCntrSpclTroSelectVO());
			eventResponse.setRsVoList(bkgForSplitVO.getSpclSeqForSplitVO());
			
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("MULTI_SPLIT");			
			List<BkgHrdCdgCtntVO> multiSplit = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
			
			String multiSplitFlg = "";
			if(multiSplit.size() > 0){
				multiSplitFlg = multiSplit.get(0).getAttrCtnt1();
			}
			
			eventResponse.setETCData("multiSplitFlg", multiSplitFlg);
			
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0079_02C : cntr_no change <br>
	 * CntrNO별 Cago weight를 조회 <br>
	 * @author Lee NamKyung
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgCntrWgt(Event e) throws EventException{
		try{
			EsmBkg007902cEvent   event = (EsmBkg007902cEvent)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			TransferOrderIssueBC command = new TransferOrderIssueBCImpl();			
			BookingUtil          util    = new BookingUtil();
			
			//01. cgo_wgt 조회 
			String strCgoWgt = command.searchBkgCntrWgt(event.getBkgBlNoVO().getBkgNo(), event.getCntrNo());	
			strCgoWgt = JSPUtil.getNullNoTrim(strCgoWgt);
			//if ("".equals(strCgoWgt)) {
				//eventResponse.setUserMessage(new ErrorHandler("BKG00379").getUserMessage()); //화면에서 처리 
			//}
			eventResponse.setETCData("cgo_wgt", strCgoWgt);
			
			//02. tpsz 조회 
        	String cntrTpszCd = "";
            List<MstContainerVO> list = util.searchTypeSizeByCntr(event.getCntrNo()); 
    		if(list.size() > 0){
    			cntrTpszCd = JSPUtil.getNullNoTrim(list.get(0).getCntrTpszCd());
    		}
			eventResponse.setETCData("cntr_tpsz_cd", cntrTpszCd);
			
			return eventResponse; 
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * EsmBkg0317Event : Search Guideline Revenue <br>
	 * @author Jeon Sungjin
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGlineRev(Event e) throws EventException{
		try{
			EsmBkg0317Event   event = (EsmBkg0317Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			TransferOrderIssueBC command = new TransferOrderIssueBCImpl();	
			
			GlineRevOutVO glineRevOutVO = command.searchGlineRev(event.getGlineRevInVO());	
			List<GlineRevOutVO> arbitraryRevOutVOs = command.searchArbitraryRev(event.getGlineRevInVO());	
			if(glineRevOutVO != null){
				eventResponse.setETCData("optm_sts_cd", glineRevOutVO.getOptmStsCd());
				eventResponse.setETCData("trsp_mod_cd", glineRevOutVO.getTrspModCd());
				eventResponse.setETCData("gline_rev_amt", glineRevOutVO.getGlineRevAmt());
				eventResponse.setETCData("gline_curr_cd", glineRevOutVO.getGlineCurrCd());	
				eventResponse.setETCData("manifest_flag", glineRevOutVO.getManifestFlag());	
				eventResponse.setETCData("all_in_rt_cd", glineRevOutVO.getAllInRtCd());	
				eventResponse.setETCData("dih_amt", glineRevOutVO.getDihAmt());	
				eventResponse.setETCData("agmt_wgt", glineRevOutVO.getAgmtWgt());	
				eventResponse.setETCData("ihc_trf_no", glineRevOutVO.getIhcTrfNo());	
				eventResponse.setETCData("org_dest_tp_cd", glineRevOutVO.getOrgDestTpCd());	
				eventResponse.setETCData("svc_scp_cd", glineRevOutVO.getSvcScpCd());	 
				
			}else {
				eventResponse.setETCData("optm_sts_cd", "N/A");
			}			
			if(event.getMultiRev().equals("Y")){
				eventResponse.setRsVoList(arbitraryRevOutVOs);
			} else {
				if(arbitraryRevOutVOs != null && arbitraryRevOutVOs.size() > 0){
					List<GlineRevOutVO> tmpArbitraryRevOutVOs = new ArrayList<GlineRevOutVO>();
					tmpArbitraryRevOutVOs.add(arbitraryRevOutVOs.get(0));
					eventResponse.setRsVoList(tmpArbitraryRevOutVOs);
				}
			}
//			if(arbitraryRevOutVO != null){
//				eventResponse.setETCData("arb_curr_cd", arbitraryRevOutVO.getGlineCurrCd());
//				eventResponse.setETCData("arb_rev_amt", arbitraryRevOutVO.getGlineRevAmt());
//			} else {
//				eventResponse.setETCData("arb_curr_cd", "");
//				eventResponse.setETCData("arb_rev_amt", "");				
//			}
			return eventResponse; 
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * EsmBkg0317Event : Search Guideline Revenue check<br>
	 * @author Jeon Sungjin
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGlineRevChk(Event e) throws EventException{
		try{
			EsmBkg0317Event   event = (EsmBkg0317Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			TransferOrderIssueBC command = new TransferOrderIssueBCImpl();	
			
			List<GlineRevOutVO> arbitraryRevOutVOs = command.searchArbitraryRevChk(event.getGlineRevInVO());	
			
			if(event.getMultiRev().equals("Y") && arbitraryRevOutVOs != null){
				eventResponse.setETCData("gline_rev_amt", arbitraryRevOutVOs.get(0).getGlineRevAmt());
			} else {
				if(arbitraryRevOutVOs != null && arbitraryRevOutVOs.size() > 0){
					eventResponse.setETCData("gline_rev_amt", arbitraryRevOutVOs.get(0).getGlineRevAmt());
				}
			}
			return eventResponse; 
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_0079_02A, ESM_BKG_0079_02B : confirm check <br>
	 * system Date 를 조회 <br>
	 * 
	 * @author Lee NamKyung 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSysDate(Event e) throws EventException{
		try {   
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			BookingUtil command = new BookingUtil();
			
			String sSysdate = command.searchTimeLocalOfcFnc(account.getOfc_cd());   //로그인한 사용자의 ofc_cd
			sSysdate = sSysdate.substring(0, 16);
			eventResponse.setETCData("cfm_sys_date", sSysdate);
			
			return eventResponse;
		} catch(EventException se) {
			throw se;
		} catch(Exception ex) { 
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0099, ESM_BKG_0079_01, ESM_BKG_0079_02A, ESM_BKG_0079_02B, ESM_BKG_0079_02C : btn_bkg_split <br>
	 * Booking Split No List를 조회 <br>
	 *  
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgSplitNo(Event e) throws EventException{
		try{
			String bkgNo = null;
			if (e.getEventName().equalsIgnoreCase("EsmBkg0099Event")) {
				EsmBkg0099Event event = (EsmBkg0099Event)e;
				bkgNo = event.getBkgBlNoVO().getBkgNo();
			} else if(e.getEventName().equalsIgnoreCase("EsmBkg007901Event")) {
				EsmBkg007901Event event = (EsmBkg007901Event)e;
				bkgNo = event.getBkgBlNoVO().getBkgNo();
			} else if(e.getEventName().equalsIgnoreCase("EsmBkg007902aEvent")) {
				EsmBkg007902aEvent event = (EsmBkg007902aEvent)e;
				bkgNo = event.getBkgBlNoVO().getBkgNo();
			} else if(e.getEventName().equalsIgnoreCase("EsmBkg007902bEvent")) {
				EsmBkg007902bEvent event = (EsmBkg007902bEvent)e;
				bkgNo = event.getBkgBlNoVO().getBkgNo();
			} else if(e.getEventName().equalsIgnoreCase("EsmBkg007902cEvent")) {
				EsmBkg007902cEvent event = (EsmBkg007902cEvent)e;
				bkgNo = event.getBkgBlNoVO().getBkgNo();
			}
			BookingUtil command = new BookingUtil();
			String sBkgSplitNo = command.searchBkgSplitNoByOptional(bkgNo,"");
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("bkg_split_no_list",sBkgSplitNo);
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0079_01 : waiting, firm click <br>
	 * Wating->Firm,Firm->Waiting시 처리. <br>
	 * 
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse changeBkgStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg007901Event event = (EsmBkg007901Event)e;
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		try{
			begin();
			// 01. Change Booking Status
			receiptBC.changeBkgStatus(event.getNewStsCd(), event.getBkgBlNoVO(), true, account);

			// 02. BookingHistoryMgtBC의 createBkgHistoryLine 호출	
			BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
			
			HistoryLineVO historyLineVO = new HistoryLineVO();
			historyLineVO.setUiId("ESM_BKG_0079_01");			
			historyLineVO.setHisCateNm("Booking Status");
			historyLineVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
			historyLineVO.setCaFlg(event.getBkgBlNoVO().getCaFlg());
			if ("P".equals(event.getNewStsCd())){
				historyLineVO.setBkgDocProcTpCd("BKGWAI");// booking wait for doc performance
				historyLineVO.setCrntCtnt("Status change F to W");
			} else {
				historyLineVO.setBkgDocProcTpCd("BKGFRM");// booking firm for doc performance
				historyLineVO.setCrntCtnt("Status change W to F");
			}
			
			historyBC.createBkgHistoryLine(historyLineVO, account);
			
			// 03. interfaceCoa
			interfaceToMas(event.getBkgBlNoVO(), "Booking Status Change", account);

			commit();
			
			begin();
			// 04. interfaceBkgARInvoiceToINV 
			interfaceToInv(event.getBkgBlNoVO(), account);	
			commit();
			
			eventResponse.setETCData("isSuccess","Y");
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0079_01 : cancel click <br>
	 * Booking Cancel시 처리.<br>
	 * 
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelBooking(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg007901Event event = (EsmBkg007901Event)e;
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();
		BLDocumentationCMBC blDocCmBC = new BLDocumentationCMBCImpl();
		BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
		BkgCopManageBC copBC = new BkgCopManageBCImpl();
		BookingUtil util = new BookingUtil();
		PerformanceReportBC reportBC = new PerformanceReportBCImpl();
		OwnContainerBookingForecastMgtBC owncontainer = new OwnContainerBookingForecastMgtBCImpl();
		EBookingReceiptBC eBookingBC = new EBookingReceiptBCImpl();
		
		try{
			begin();

			if(account==null){
				account = new SignOnUserAccount("BATCH" ,"" ,"" ,""      ,""
		                ,""      ,"" ,"" ,"BATCH" ,""
		                ,"BATCH" ,"" ,"" ,""      ,""
		                ,""      ,"" ,"" ,""      ,""
		                ,""      ,""
							);
			}
			// 20100205 Booking Close 로직 추가
			String closeBkgMsg = "";
			String closeVvd = "";
			boolean isCloseMail = false;
			boolean isCbfMail = false;
			BkgCloseVO bkgCloseVO = null;
			if(!"Y".equals(event.getBkgBlNoVO().getCaFlg())){
				if(!"Y".equals(event.getBookingSaveValidationVO().getCloseBkgFlag())){
					bkgCloseVO = util.searchBkgClose(event.getBkgBlNoVO(), account.getOfc_cd());
					if(bkgCloseVO != null){
						String[] strParam = new String[11];
						strParam[0] = event.getBkgBlNoVO().getBkgNo();
	//					strParam[1] = bkgCloseVO.getPreVvd();
	//					strParam[2] = bkgCloseVO.getPrePolCd();
	//					strParam[3] = bkgCloseVO.getPrePodCd();
	//					strParam[4] = bkgCloseVO.getOldQtyVol();
						strParam[5] = bkgCloseVO.getCntrList();
						strParam[6] = bkgCloseVO.getPreVvd();
						strParam[7] = bkgCloseVO.getPorCd() + " / " + bkgCloseVO.getNewPolCd() + " / " + bkgCloseVO.getPodCd() + " / " + bkgCloseVO.getDelCd();
	//					strParam[8] = bkgCloseVO.getPrePodCd();
	//					strParam[9] = bkgCloseVO.getOldQtyVol();;
						strParam[10] = bkgCloseVO.getCntrList();					
						
						closeBkgMsg = util.makeBkgCloseMsg(strParam, "B");
						closeVvd = bkgCloseVO.getCloseVvd();
						isCloseMail = true;
					}
				}
				if(!"Y".equals(event.getBookingSaveValidationVO().getCbfBkgFlag()) && bkgCloseVO == null){

					boolean isCbfFinal = false;
					bkgCloseVO = util.searchBkgCbf(event.getBkgBlNoVO());
					if(bkgCloseVO != null && bkgCloseVO.getPreVvd() != null && !bkgCloseVO.getPreVvd().trim().equals("")){
						String[] arrCBF  = owncontainer.searchCBFBS(bkgCloseVO.getPreVvd().substring(0, 4), bkgCloseVO.getPreVvd().substring(4, 8), bkgCloseVO.getPreVvd().substring(8, 9), bkgCloseVO.getPreYdCdSeq());
						for (int i=0;i<arrCBF.length;i++){
							if(i%4 == 0){
								if("Final".equals(arrCBF[i])){
									isCbfFinal = true;
									break;
								}
							}
						}
						if(arrCBF != null && isCbfFinal == true ){
							String[] strParam = new String[11];
							strParam[0] = event.getBkgBlNoVO().getBkgNo();
							strParam[5] = bkgCloseVO.getCntrList();
							strParam[6] = bkgCloseVO.getPreVvd();
							strParam[7] = bkgCloseVO.getPorCd() + " / " + bkgCloseVO.getNewPolCd() + " / " + bkgCloseVO.getPodCd() + " / " + bkgCloseVO.getDelCd();
							strParam[10] = bkgCloseVO.getCntrList();					
							
							closeBkgMsg = util.makeBkgCloseMsg(strParam, "B");
							closeVvd = bkgCloseVO.getCloseVvd();
							isCbfMail = true;
						}
					}
				}
			}
			if(isCloseMail){
				rollback();
				eventResponse.setETCData("closeBkgFlag", "Y");
				eventResponse.setETCData("first_vvd", closeVvd);
				eventResponse.setETCData("closeBkgMsg", closeBkgMsg);		
			} else if(isCbfMail){
				rollback();
				eventResponse.setETCData("cbfBkgFlag", "Y");
				eventResponse.setETCData("first_vvd", closeVvd);
				eventResponse.setETCData("closeBkgMsg", closeBkgMsg);	
			}else{
				// Reefer Cancel
				if(!"Y".equals(event.getBkgBlNoVO().getCaFlg())){
					cancelRfCgoApro(event.getBkgBlNoVO());
				}
				
				// 01. Cancel Booking
				receiptBC.cancelBooking(event.getBkgBlNoVO(), account);
				
				// 02. Cancel Container
				blDocCmBC.cancelBkgCntr(event.getBkgBlNoVO(), account);

				// 03. BookingHistoryMgtBC의 createBkgHistoryLine 호출
				HistoryLineVO historyLineVO = new HistoryLineVO();
				historyLineVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
				historyLineVO.setCaFlg(event.getBkgBlNoVO().getCaFlg());
				historyLineVO.setCorrNo(event.getBkgBlNoVO().getCaNo());
				historyLineVO.setBkgDocProcTpCd("BKGCAN");//booking cancel for doc performance
				historyLineVO.setUiId("ESM_BKG_0079_01");
				historyLineVO.setCrntCtnt("Booking Canceled.");
				historyLineVO.setHisCateNm("Booking Cancel."); 
				
				historyBC.createBkgHistoryLine(historyLineVO, account);
				if(!"Y".equals(event.getBkgBlNoVO().getCaFlg())){
					reportBC.modifyQueueByBkg(event.getBkgBlNoVO().getBkgNo(), "XX", "X");
					copBC.cancelBkg(event.getBkgBlNoVO().getBkgNo());
					changeMemoSplitBkgStatus(event.getBkgBlNoVO().getBkgNo());
					
					// 04. interfaceCoa
					interfaceToMas(event.getBkgBlNoVO(), "Booking Cancel", account);

					commit();
					
					// 05. interfaceBkgARInvoiceToINV
					interfaceToInv(event.getBkgBlNoVO(), account);				
	
					// 07. sendBkgCustEdi(전용진수석님 호출)
					searchBC.createCustBkgReceiptEdiBackEnd(event.getBkgBlNoVO(), null, "Y", account);
	
					// 08. sendBkgTmlEdi(전용진수석님 호출)
					
					// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
					Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
					vender301ParamVO.setBkgBlNoVO(event.getBkgBlNoVO());
					vender301ParamVO.setOldVvdVOs(null);
					vender301ParamVO.setOldQtyVOs(null);
					vender301ParamVO.setOldMtyPkupYdCd(null);
					vender301ParamVO.setBracCd("R");
					vender301ParamVO.setEdiKind("BT");
					vender301ParamVO.setAutoManualFlg("Y");
					
					searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);	
					
					// 09. EDI 수신된 SI가 있을경우 Reject APERAK 전송 
					XterRqstNoVO xterRqstNoVO = util.searchAperakXterRqstNo(event.getBkgBlNoVO().getBkgNo());
					if (xterRqstNoVO != null){
						eBookingBC.createXterRqstRejectEdi("Booking Cancel", "9", xterRqstNoVO, account);
					}
					
//					if("SGSIN".equals(event.getBkgBlNoVO().getPolCd())){
						this.managePSABKGAuto(event.getBkgBlNoVO().getBkgNo(), "N");
//					}
				} else {
					commit();
				}

				// sms 전송로직 추가 bkg cancel  .jsy 
				
				List<BkgUserSmsListVO> smsList = null;
				String sndMsg ="";
				String skdDirCd = "";

				String newFirstVvd = "";
				String newPolCd = "";
				String newPolYdCd = "";
				
				String sndParam ="";
				//cancel 일때는 vvd정보를 찾아온다.
				BkgBlNoVO schBkgBlNoVO = null;
				List<VslSkdVO> vslSkdVOs = null;
				schBkgBlNoVO = util.searchBkgBlNoVO(event.getBkgBlNoVO());
				vslSkdVOs = receiptBC.searchVvdSkdForTsRoute(schBkgBlNoVO);
				if(vslSkdVOs != null && vslSkdVOs.size()>0 ) {
					newFirstVvd = vslSkdVOs.get(0).getBkgVvdCd();
					newPolCd	= vslSkdVOs.get(0).getPolCd();
					newPolYdCd  = vslSkdVOs.get(0).getPolCd() + vslSkdVOs.get(0).getPolYdCd();
				}
				boolean bCntrCntChk = false;
				boolean bYardChk = false;
				
				List<SmsRequirementResultVO> smsReqList = receiptBC.getSmsRequirementResult(event.getBkgBlNoVO().getBkgNo(), newFirstVvd, newFirstVvd, newPolCd, "");
				
				for(int i = 0; i<smsReqList.size(); i++){				
					if( Integer.parseInt(smsReqList.get(i).getCntrCnt())>0 ) {
						bCntrCntChk = true;
					}			
					if( null != newPolYdCd && newPolYdCd.equals(smsReqList.get(i).getPolYd()) ) {
						bYardChk = true;
					}
				}
				//1.변경 조건 
				if( "SEL".equals(event.getBkgBlNoVO().getBkgNo().substring(0, 3) ) 
					&& receiptBC.chkSmsRequirementVvdChanged(event.getBkgBlNoVO().getBkgNo(), newFirstVvd, newFirstVvd, newPolCd, "" ) 
					&& bCntrCntChk
					&& bYardChk
					&& !"Y".equals(event.getBkgBlNoVO().getCaFlg())) {
					
					//보낼 대상 조회.
					// sms 전송 
					skdDirCd = newFirstVvd.substring(8,9);

					//lane 변경 없음 -단건 전송
					smsList = receiptBC.getPhnId(vslSkdVOs.get(0).getSlanCd(), util.searchBkgOfcByBkg(schBkgBlNoVO), skdDirCd, newPolCd, event.getBkgBlNoVO().getBkgNo()); 
					//전송 메세지.
//					sndMsg = "\n\n(" + vslSkdVOs.get(0).getSlanCd()+"-" + skdDirCd+") " +" " + newFirstVvd+" "+ event.getBkgBlNoVO().getBkgNo()+" 선적 취소 발생 " ;
					BlRatingBC command 		= new BlRatingBCImpl();
					BkgBookingInfoVO bkgBookingInfoVO = command.searchBkgBookingInfo(schBkgBlNoVO);
					if("Y".equalsIgnoreCase(bkgBookingInfoVO.getDcgoFlg())){
						sndMsg = "\n\n(" + vslSkdVOs.get(0).getSlanCd()+"-" + skdDirCd+") " +" " + newFirstVvd+" "+ event.getBkgBlNoVO().getBkgNo()+" (DG Cargo 선적) "+" 선적 취소 발생 " ;
					}else{
						sndMsg = "\n\n(" + vslSkdVOs.get(0).getSlanCd()+"-" + skdDirCd+") " +" " + newFirstVvd+" "+ event.getBkgBlNoVO().getBkgNo()+" 선적 취소 발생 " ;
					}
					begin();
					//sendMailByPodChange(smsList, bkgBookingInfoVO.getBkgNo(), sndMsg );
					sndParam = //"/rv gubun[CD] vvd["+newFirstVvd+"] bkg_no["+event.getBkgBlNoVO().getBkgNo()+"] cntr_i[] cntr_d[]";
							   "/rv gubun[CD] vvd["+newFirstVvd+"] old_vvd["+newFirstVvd+"]  pol_cd["+newPolCd+"] bkg_no["+event.getBkgBlNoVO().getBkgNo()+"] cntr_i[] cntr_d[]";
					List<BkgNtcHisVO> bkgNtcHisVOs = searchBC.sendMailSmsByPodChange(smsList, event.getBkgBlNoVO().getBkgNo(), sndMsg, sndParam, account );
					historyBC.createBkgNtcHis(bkgNtcHisVOs, "");
					
					commit();
						
				}
				
				eventResponse.setETCData("closeBkgFlag", "N");
				eventResponse.setETCData("cbfBkgFlag", "N");
			}

		}catch(EventException ex){
			rollback();
//			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0099 : split click <br>
	 * Booking Split 처리 <br>
	 *  
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse splitBooking(Event e) throws EventException{		
		try{
			EsmBkg0099Event 				event 			= (EsmBkg0099Event)e;
			GeneralEventResponse 			eventResponse 	= new GeneralEventResponse();			
			GeneralBookingSplitCombineBC 	command 		= new GeneralBookingSplitCombineBCImpl();
			
			//Bkg data 반영
			GeneralBookingReceiptBC receiptBC   = new GeneralBookingReceiptBCImpl();
			GeneralBookingSearchBC  searchBC 	= new GeneralBookingSearchBCImpl();
			BLDocumentationBLBC 	blDocBlBC 	= new BLDocumentationBLBCImpl();
			BLDocumentationCMBC 	blDocCmBC 	= new BLDocumentationCMBCImpl();
			BlRatingBC 				blRatingBC 	= new BlRatingBCImpl();
			BookingHistoryMgtBC 	historyBC 	= new BookingHistoryMgtBCImpl();
			BDRCorrectionBC         bdrBC       = new BDRCorrectionBCImpl();
			PerformanceReportBC 	reportBC	= new PerformanceReportBCImpl();
			EBookingReceiptBC       ebookingBC  = new EBookingReceiptBCImpl();
			BookingUtil             util        = new BookingUtil();
			
			// 타모듈 연동
			//BkgCopManageBC 			copBC 		= new BkgCopManageBCImpl();
        	ProductCatalogCreateBC 	prdBC 		= new ProductCatalogCreateBCImpl();
        	TransferOrderIssueBC	troBC		= new TransferOrderIssueBCImpl();
			
			//orgin bkg
			BkgBlNoVO sourceBkg = event.getSourceBkg();
			
			// split처리 용
			SplitBkgVO 				splitBkgVO 		  = event.getSplitBkgVO();
			List<SelectCntrVO> 		selectCntrVO	  = splitBkgVO.getSelectCntrVO();
			List<SplitQtyVO>   		selectQtyVO 	  = splitBkgVO.getSplitQtyVO();
			List<SelectSpclCgoVO>	selectSpclCgoVO   = splitBkgVO.getSelectSpclCgoVO();
			List<SplitBlInfoVO>     splitBlInfoVOList = splitBkgVO.getSplitBlInfoVO();
			//2010.11.30 김영철 [] R4J - 사용하지 않은 지역변수 삭제
//			List<SelectTroVO>		selectTroVO		= splitBkgVO.getSelectTroVO();					
			
			//for History
			String      splitToBkgNoStr = "";
			String []   cntrHistStr 	= new String[event.getTargetBkg().length];
			String 	    preCntrHistStr	= "";
			String      orgTvvd 		= splitBkgVO.getCopySplitBkgEtcVO().get(0).getTvvd();
			String 		polCd			= splitBkgVO.getCopySplitBkgEtcVO().get(0).getPolCd();			
			String		splitRsnCd 		= splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason();
			HistoryTableVO histTableVO  = null;
			
			//for auto c/a
			String bdrFlag = "N";
			BkgCorrectionVO bkgCorrectionVO = new BkgCorrectionVO();
			if(splitBkgVO.getCopySplitBkgEtcVO().get(0).getBdrFlag().equals("Y")){
				bdrFlag = "Y";
			}			
			
			// prd 호출
			ArrayList<String> cntrNoList  = null;
			String [][] 	  pctlMapSeq  = new String[event.getTargetBkg().length][2];	
			
			// prd에 넘겨줄 bkg list
			ArrayList<String> bkgNoList = new ArrayList<String>();
			for (int i=0;i<event.getTargetBkg().length;i++){
				event.getTargetBkg()[i].setPctlNo(sourceBkg.getPctlNo());
				bkgNoList.add(event.getTargetBkg()[i].getBkgNo());				
				// for history
				if(i==0){
					splitToBkgNoStr = event.getTargetBkg()[i].getBkgNo();
				} else {
//					splitToBkgNoStr = splitToBkgNoStr + ", " + event.getTargetBkg()[i].getBkgNo();
					StringBuffer tmpBuffer = new StringBuffer(splitToBkgNoStr).append(", ").append(event.getTargetBkg()[i].getBkgNo());
					splitToBkgNoStr = tmpBuffer.toString();
					if(i%3==0){
//						splitToBkgNoStr = splitToBkgNoStr + "\n";
						StringBuffer tmpBuffer2 = new StringBuffer(splitToBkgNoStr).append("\n");
						splitToBkgNoStr = tmpBuffer2.toString();
					}
				}
			}
			
			begin();
			
//			//같은 office인지 확인  -> 제외 (20100406 임종한 과장님 요청)
//			if(!"Y".equals(bdrFlag)){
//				util.searchOfcVsBkgOfc(sourceBkg, account);
//			}
			
			
			// split bkg 별로 prd에 call
			for (int i=0;i<event.getTargetBkg().length;i++){
				//memo split일 경우 P/C 추가 call
				if(0==i && splitRsnCd.equals("M")){
	                PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO(); 
	                prdMainInfoVO.setPcMode("S");
	                prdMainInfoVO.setFCmd("3");
	                prdMainInfoVO.setBkgNo(sourceBkg.getBkgNo());
	                prdMainInfoVO.setParentBkgNo(sourceBkg.getBkgNo());
	                prdMainInfoVO.setBkgOfc(account.getOfc_cd());
	                
	                PrdParameterVO prdParameterVO = new PrdParameterVO();
	                prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
	                
	                //for qty
	                ArrayList<PrdQtyInfoVO> prdQtyList = new ArrayList<PrdQtyInfoVO>();
	                PrdQtyInfoVO[] 			prdQtyInfos = receiptBC.searchBkgQtyForRailTime(sourceBkg);
	                PrdQtyInfoVO 			prdQtyInfo = null;
	                for(int icnt=0;icnt<prdQtyInfos.length; icnt++) {
                		prdQtyInfo = new PrdQtyInfoVO();
                		prdQtyInfo.setCQty (prdQtyInfos[icnt].getCQty());
                		prdQtyInfo.setCTpsz(prdQtyInfos[icnt].getCTpsz());
                		prdQtyList.add(prdQtyInfo); 
	                }
	                
	                prdParameterVO.setPrdQtyInfo(prdQtyList);

	                //for cntr
	                cntrNoList = new ArrayList<String>();
	                String [] cntrNos = util.searchCntrListByBkg(sourceBkg);
	                for(int icnt=0;icnt<cntrNos.length; icnt++) {
	                    cntrNoList.add(cntrNos[icnt]);
	                }
	                String pctlNoMapSeqStr = prdBC.createPrdCtlgRoutSplit(prdParameterVO, account, cntrNoList, i, bkgNoList);
	                String [] memoPctlMapSeq = util.splitByToken(pctlNoMapSeqStr, "|"); 
	            	sourceBkg.setPctlNo(memoPctlMapSeq[0]); 
	            	sourceBkg.setMapSeq(memoPctlMapSeq[1]);
				}
				
				BkgBlNoVO targetBkg = event.getTargetBkg()[i];
				log.debug("\nprocessing bkg no:"+targetBkg.getBkgNo());
                
                PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO(); 
                prdMainInfoVO.setPcMode("S");
                prdMainInfoVO.setFCmd("3");
                prdMainInfoVO.setBkgNo(targetBkg.getBkgNo());
                prdMainInfoVO.setParentBkgNo(sourceBkg.getBkgNo());
                prdMainInfoVO.setBkgOfc(account.getOfc_cd());
                
                PrdParameterVO prdParameterVO = new PrdParameterVO();
                prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
                
                //for qty
                ArrayList<PrdQtyInfoVO> prdQtyList = new ArrayList<PrdQtyInfoVO>();
                PrdQtyInfoVO 			prdQtyInfo = null;                       

                for(int icnt=0;icnt<selectQtyVO.size(); icnt++) {
                	int targetBkgSeq = icnt%splitBlInfoVOList.size();
                	selectQtyVO.get(icnt).setSplitNo(splitBlInfoVOList.get(targetBkgSeq).getBkgNo());
                	double iQty =(selectQtyVO.get(icnt).getOpCntrQty()==null)? 0:Double.parseDouble(selectQtyVO.get(icnt).getOpCntrQty());

                	if (targetBkg.getBkgNo().equals(splitBlInfoVOList.get(targetBkgSeq).getBkgNo())
       					&& iQty>0.0){
                		prdQtyInfo = new PrdQtyInfoVO();
                		prdQtyInfo.setCQty (selectQtyVO.get(icnt).getOpCntrQty());
                		prdQtyInfo.setCTpsz(selectQtyVO.get(icnt).getCntrTpszCd());
                		prdQtyList.add(prdQtyInfo); 
                	}
                }
                prdParameterVO.setPrdQtyInfo(prdQtyList);

                //for cntr
                cntrNoList = new ArrayList<String>();
                cntrHistStr[i] = "";
                for(int icnt=0;icnt<selectCntrVO.size(); icnt++) {
                    if (selectCntrVO.get(icnt).getBkg_no().equals(targetBkg.getBkgNo())
                        && selectCntrVO.get(icnt).getSplitNo().length()>1){
                    	cntrNoList.add(selectCntrVO.get(icnt).getCntr_no());
                    	//for history
                    	if(cntrNoList.size() == 1){
                    		cntrHistStr[i] = selectCntrVO.get(icnt).getCntr_no();
                    	} else {
                    		if(cntrNoList.size()%3==1){
//                    			cntrHistStr[i] = cntrHistStr[i] + ",\n" + selectCntrVO.get(icnt).getCntr_no();
                    			StringBuffer tmpBuffer = new StringBuffer(cntrHistStr[i]).append(",\n").append(selectCntrVO.get(icnt).getCntr_no());
                    			cntrHistStr[i] = tmpBuffer.toString();
                    		} else {
//                    			cntrHistStr[i] = cntrHistStr[i] + ", " + selectCntrVO.get(icnt).getCntr_no();
                    			StringBuffer tmpBuffer = new StringBuffer(cntrHistStr[i]).append(", ").append(selectCntrVO.get(icnt).getCntr_no());
                    			cntrHistStr[i] = tmpBuffer.toString();
                    		}
                    	}
                    }
                }
                String pctlNoMapSeqStr = prdBC.createPrdCtlgRoutSplit(prdParameterVO, account, cntrNoList, i, bkgNoList);
            	pctlMapSeq[i] = util.splitByToken(pctlNoMapSeqStr, "|");
			}// prd 호출 끝			
			commit();
			
			// for quantity history
			List<BkgQuantityVO> oldBkgQtys = receiptBC.searchBkgQuantity(sourceBkg);
			String oldMtyPkupYdCd = ((OldBkgInfoVO)receiptBC.searchOldBkgInfo(sourceBkg)).getMtyPkupYdCd();
			
			//for cntr history
			if(selectCntrVO.size()>0){
				String [] cntrList = util.searchCntrListByBkg(sourceBkg);
				for(int i=0;i<cntrList.length;i++){
                	if(i == 0){
                		preCntrHistStr = cntrList[i];
                	} else {
                		if((i+1)%3==1){
//                			preCntrHistStr = preCntrHistStr + ",\n" + cntrList[i];
                			StringBuffer tmpBuffer = new StringBuffer(preCntrHistStr).append(",\n").append(cntrList[i]);
                			preCntrHistStr = tmpBuffer.toString();
                		} else {
//                			preCntrHistStr = preCntrHistStr + ", " + cntrList[i];
                			StringBuffer tmpBuffer = new StringBuffer(preCntrHistStr).append(", ").append(cntrList[i]);
                			preCntrHistStr = tmpBuffer.toString();
                		}
                	}
				}				
			}
			
			if (command.validateSplit(splitBkgVO, sourceBkg).equals("Y")){
				begin();
				if(bdrFlag.equals("Y")){
					// add1stCaHist : sourcebkg의 최초 c/a hist을 넣는다(corr_no : 0000000001)
					add1stCaHist(event.getSourceBkg());
				}

				// Copy여부에 따라 Information Alert을 표시할지를 판단하기 위한 Flag를 셋팅.
				String splitFlg = receiptBC.copyBookingForSplit   (sourceBkg, event.getTargetBkg(), splitBkgVO,   account);
				eventResponse.setETCData("split_flag", splitFlg);

				blDocBlBC.copyBlDocByBkg		(sourceBkg, event.getTargetBkg(), splitBkgVO, account );
				if(selectCntrVO.size()>0){
					BkgCopyCntrCmByBkgVO bkgCopyCntrCmByBkgVO = new BkgCopyCntrCmByBkgVO();
					bkgCopyCntrCmByBkgVO.setCopyModeCd("S");
					bkgCopyCntrCmByBkgVO.setHitchmentYn("");
					//public void copyCntrCmByBkg(BkgBlNoVO sourceBkg, BkgBlNoVO[] targetBkg, List<SelectCntrVO>selectCntrVO, BkgCopyCntrCmByBkgVO bkgCopyCntrCmByBkgVO ,SignOnUserAccount account)
					blDocCmBC.copyCntrCmByBkg   (sourceBkg, event.getTargetBkg(), selectCntrVO, bkgCopyCntrCmByBkgVO ,account);
				}
				blDocBlBC.copyHblByBkg      ("S", sourceBkg, event.getTargetBkg(), selectCntrVO, account);
				if(selectSpclCgoVO.size()>0){
					SpecialCargoReceiptBC spclCgoBC = new SpecialCargoReceiptBCImpl();
					spclCgoBC.copySpclCgoByBkg  ("S", sourceBkg, event.getTargetBkg(), selectSpclCgoVO, account);
				}
				blRatingBC.copyManualChgByBkg   (sourceBkg, event.getTargetBkg(), account, splitRsnCd);
//				if(selectTroVO.size()>0){
//					if("EUR".equals(event.getTroTp())){
//						troBC.unconfirmEurTro(sourceBkg, "O", account);
//					} else {
//						troBC.unconfirmTro(sourceBkg, account);
//					}
//					copBC.unconfirmTro(sourceBkg.getBkgNo(), "O");
//					troBC.copyTroByBkg("S", sourceBkg, event.getTargetBkg(),selectTroVO, event.getTroTp(),  account);
//				} 
				//임시 주석 처리
				if(selectSpclCgoVO.size()>0){
					//bkg의 spcl flag 재 계산
					receiptBC.modifySpclFlag(event.getTargetBkg(), account);
					if(selectCntrVO.size()>0){
						//container의 spcl flag 재계산
						blDocCmBC.modifyCntrSpclFlag(event.getTargetBkg(), account);
					}
				}
				
				//cop에 1차로 split을 반영
				String [] targetBkgNoList = new String[event.getTargetBkg().length + (splitRsnCd.equals("M")?1:0)];
				String [] copMapSeq       = new String[event.getTargetBkg().length + (splitRsnCd.equals("M")?1:0)];
				for(int i=0;i<event.getTargetBkg().length;i++){
					targetBkgNoList[i] = event.getTargetBkg()[i].getBkgNo();	
					copMapSeq[i]       = pctlMapSeq[i][1]; 
				}				
				if(splitRsnCd.equals("M")){
					targetBkgNoList[targetBkgNoList.length-1] = sourceBkg.getBkgNo();	
					copMapSeq      [targetBkgNoList.length-1] = sourceBkg.getMapSeq(); 
				}
				//copBC.splitBkg(sourceBkg.getBkgNo(), targetBkgNoList, copMapSeq);
				callCopSplitBkg(sourceBkg.getBkgNo(), targetBkgNoList, copMapSeq);
				
				// S 2010.08.31 KMJ TRO Split 추가
				// 81. copyTroBySplit
				troBC.copyTroBySplit(sourceBkg.getBkgNo(), targetBkgNoList, account);
				// 82. cancelTroBySplit
				troBC.cancelTroBySplit(sourceBkg.getBkgNo(), targetBkgNoList, account);
				// 2010.08.31 KMJ TRO Split 추가
				
				// 20140306 SI History 추가
				String sourceSiFlg = receiptBC.searchSiFlg(sourceBkg);
				
				for (int i=0;i<event.getTargetBkg().length;i++){
					BkgBlNoVO targetBkg = event.getTargetBkg()[i];
					
					//for performance report
					reportBC.manageQtyCntrCoposite(targetBkg.getBkgNo(), "CQ");	
					reportBC.manageQtyCntrCoposite(targetBkg.getBkgNo(), "CN");			
				
					// bdr 이전이면 해당 Booking의 status를 재계산한다.
					if(bdrFlag.equals("Y")){
						// bdr 이후일 경우 
						bkgCorrectionVO.setBkgNo(targetBkg.getBkgNo());
						//split new Bkg에 대해 BDR이후일 경우 first c/a(dummy)
						if (!event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
							add1stCaHist(targetBkg);
						}
					}
					
					//vvd가 변경되었을 경우
					log.debug("\nbkg:"+targetBkg.getBkgNo()+",tVvd:"+splitBlInfoVOList.get(i).getTvvd()
							+ "\nroute String:"+splitBlInfoVOList.get(i).getRtnRoute());	
					if(splitBlInfoVOList.get(i).getRtnRoute()!=null 
						&& splitBlInfoVOList.get(i).getRtnRoute().length()>10
						&& !orgTvvd.equals(splitBlInfoVOList.get(i).getTvvd())){
						
						//PrdMainInfoVO Set
						PrdMainInfoVO prdMainInfoVO  = new PrdMainInfoVO();
						prdMainInfoVO.setFCmd("3");
						prdMainInfoVO.setPcMode("R");
						prdMainInfoVO.setTVvd (splitBlInfoVOList.get(i).getTvvd());
						prdMainInfoVO.setBkgNo(targetBkg.getBkgNo());
						
						PrdParameterVO prdParameterVO = new PrdParameterVO();
						prdParameterVO.setBkgBlNoVO(targetBkg);
						prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
						prdParameterVO=util.searchPrdParmForFullRoute (prdParameterVO);
						
						PrdMainInfoVO rtnPrdMainInfoVO = prdParameterVO.getPrdMainInfoVO();
						util.resetNthRoute(rtnPrdMainInfoVO, 1);
						util.resetNthRoute(rtnPrdMainInfoVO, 2);
						util.resetNthRoute(rtnPrdMainInfoVO, 3);
						util.resetNthRoute(rtnPrdMainInfoVO, 4);
						rtnPrdMainInfoVO.setOrgTrnsMode("");
						rtnPrdMainInfoVO.setDestTrnsMode("");
						
						String rtnRoute = splitBlInfoVOList.get(i).getRtnRoute();
						String [] rtnRouteVvds = util.splitByToken(rtnRoute, ",");
						for(int j=0;j<rtnRouteVvds.length;j++){
							if(rtnRouteVvds[j].length()==0) break;
							String [] rtnRouteInfo = util.splitByToken(rtnRouteVvds[j], "|");
							log.debug("\npol:"+rtnRouteInfo[0]+"/polYd:"+rtnRouteInfo[1]+"/pol_clpt:"+rtnRouteInfo[6]+
									   "/pod:"+rtnRouteInfo[2]+"/podYd:"+rtnRouteInfo[3]+"/pod_clpt:"+rtnRouteInfo[7] +
									   "/vvd:"+rtnRouteInfo[4]+"/lane:"+rtnRouteInfo[5]);
							if(j==0){
								rtnPrdMainInfoVO.setPol1 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol1N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol1C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod1 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod1N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod1C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd1 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane1(rtnRouteInfo[5]);
							} else if(j==1){
								rtnPrdMainInfoVO.setPol2 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol2N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol2C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod2 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod2N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod2C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd2 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane2(rtnRouteInfo[5]);
							} else if(j==2){
								rtnPrdMainInfoVO.setPol3 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol3N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol3C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod3 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod3N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod3C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd3 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane3(rtnRouteInfo[5]);
							} else if(j==3){
								rtnPrdMainInfoVO.setPol4 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol4N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol4C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod4 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod4N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod4C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd4 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane4(rtnRouteInfo[5]);
							}
						}
						
						prdParameterVO.setPrdMainInfoVO(rtnPrdMainInfoVO);
//						util.prdParameterLog(prdParameterVO.getPrdMainInfoVO());

						// 12. createProdCtlRoute
						String pctlNoMapSeqStr = prdBC.createPrdCtlgRout(prdParameterVO, account);
						String [] pctlNoMapSeq = util.splitByToken(pctlNoMapSeqStr, "|");
						
						targetBkg.setPctlNo(pctlNoMapSeq[0]);
						targetBkg.setMapSeq(pctlNoMapSeq[1]);						

						//	vvd변경에 대한 old vvd조회(org bkg에 대해서만 vvd 변경 이력을 남긴다)
						histTableVO = new HistoryTableVO();
						if(targetBkg.getBkgNo().equals(sourceBkg.getBkgNo())){
							histTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0099", targetBkg);
						}
						
						// 실제 vvd 변경
						VvdAssignVO vvdAssignVO = new VvdAssignVO();
						vvdAssignVO.setBkgBlNoVO(targetBkg);
//						BdrSpclVO bdrSpclVO = receiptBC.modifyOceanRoute(vvdAssignVO, account);
						receiptBC.modifyOceanRoute(vvdAssignVO, account);
												
						//cop에 2차로 replan 반영
						//copBC.updateBkg(targetBkg.getBkgNo(), targetBkg.getMapSeq());
						callCopUpdateBkg(targetBkg.getBkgNo(), targetBkg.getMapSeq());
					}//vvd가 변경되었을 경우 끝
										
					if(selectSpclCgoVO.size()>0){
						reRequestSpclCgoApproval(targetBkg, "SPLIT", null);
					}
					
					// bdr 이전이면 해당 Booking의 status를 재계산한다.
					if(bdrFlag.equals("N")){
						receiptBC.changeBkgStatus("Y",targetBkg, false, account);
					}

					// auto c/a 처리
					if(bdrFlag.equals("Y")){						
						// vvd 변경됐을 경우
						if(splitBlInfoVOList.get(i).getRtnRoute()!=null){
							bkgCorrectionVO.setRoutCorrFlg("Y");
							bkgCorrectionVO.setTrnkVslCorrFlg("Y");
						}
						
						if (event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
							bdrBC.addAutoCaTemp(sourceBkg, "SPLIT_MASTER", bkgCorrectionVO, account);
						} else {
							bdrBC.addAutoCaTemp(targetBkg, "SPLIT_NEW", bkgCorrectionVO, account);
						}
						
						BkgBlNoVO corrBkgBlNoVO = addCaHistory(event.getCaRsnCd(), event.getCaRemark(), targetBkg, "N", "Y");
						targetBkg.setCaNo(corrBkgBlNoVO.getCaNo());
						event.getTargetBkg()[i].setCaNo(corrBkgBlNoVO.getCaNo());
						
						bdrBC.removeCATemp(targetBkg);
						
						blRatingBC.distributeCntrRate(targetBkg.getBkgNo(), account);
						
			            //추가2. 
						OblIssVO oblIssVO = util.searchOblIssue(targetBkg); 
						
						//추가2. 
						RevDrNoteVO        revDrNoteVO    = new RevDrNoteVO(); 
						CstmBkgRevDrNoteVO bkgRevDrNoteVO = new CstmBkgRevDrNoteVO();
						bkgRevDrNoteVO.setBkgNo      (targetBkg.getBkgNo());  
						bkgRevDrNoteVO.setBkgCorrNo  (targetBkg.getCaNo()); 
						bkgRevDrNoteVO.setRdnNo      (oblIssVO.getRdnNo()); 
						bkgRevDrNoteVO.setRvisSeq    (oblIssVO.getRvisSeq()); 
						bkgRevDrNoteVO.setReceiverRmk("");
						revDrNoteVO.setBkgRevDrNoteVO(bkgRevDrNoteVO);

						RevenueDebitNoteBC revenueDebitNoteBC = new RevenueDebitNoteBCImpl();
						revenueDebitNoteBC.acceptRDNbyReceiptOffice(revDrNoteVO, account);  
						
						//추가2. 
						OblRdemVO oblRdem = new OblRdemVO();
						oblRdem.setBlNo      (oblIssVO.getBlNo());  
						oblRdem.setCgorTeamCd("C");
						oblRdem.setCgoEvntNm ("B/L Correct");
						oblRdem.setEvntDt    (new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
						oblRdem.setEvntOfcCd (account.getOfc_cd());
						oblRdem.setEvntUsrId (account.getUsr_id());
						oblRdem.setOblRdemFlg(oblIssVO.getOblRlseFlg()); 

						CargoReleaseOrderBC cargoReleaseOrderBC = new CargoReleaseOrderBCImpl();
						try{
							cargoReleaseOrderBC.setupFocByObl(oblRdem);
						} catch(Exception crEx){
							log.error("err " + crEx.toString(), crEx);
						}	
					} else {
						targetBkg.setCaNo("");
					}// auto c/a 처리 끝

					// history 처리
					HistoryLineVO historyLineVO = new HistoryLineVO();
					
					historyLineVO.setBkgNo (targetBkg.getBkgNo());
					historyLineVO.setCorrNo(targetBkg.getCaNo());
					historyLineVO.setUiId("ESM_BKG_0099");
					if (event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
						historyLineVO.setCrntCtnt("Split into :"+splitToBkgNoStr);		
						historyLineVO.setBkgDocProcTpCd("BKGSPT");				
					} else {
						historyLineVO.setCrntCtnt("Split from BKG No :"+sourceBkg.getBkgNo()); //new -> Splited from BKG No : %, old -> Splited.			
						historyLineVO.setBkgDocProcTpCd("SPTCRE");
					}
					historyLineVO.setHisCateNm("SPLIT");		
					historyBC.createBkgHistoryLine (historyLineVO,account);
					
					//	vvd변경에 대한 history
					if(targetBkg.getBkgNo().equals(sourceBkg.getBkgNo())){
						if(splitBlInfoVOList.get(i).getRtnRoute()!=null 
								&& splitBlInfoVOList.get(i).getRtnRoute().length()>10
								&& !orgTvvd.equals(splitBlInfoVOList.get(i).getTvvd())){
							if(histTableVO!=null && histTableVO.getBkgBlNoVO()!=null){
								histTableVO.getBkgBlNoVO().setCaNo(targetBkg.getCaNo());
							}
							historyBC.manageBookingHistory("ESM_BKG_0099", histTableVO, account);
						}
					}
					if(cntrHistStr[i].length()>0){
						//	cntr에 대한 histiry
						historyLineVO.setCrntCtnt(cntrHistStr[i]); 
						if(targetBkg.getBkgNo().equals(sourceBkg.getBkgNo())){
							historyLineVO.setPreCtnt(preCntrHistStr);
						} 
						historyLineVO.setHisCateNm("Container No.");						
						historyBC.createBkgHistoryLine (historyLineVO,account);					
						historyBC.releaseCntrFinalConfirm(targetBkg, account);
						// history 처리 끝
					}		
					
					// 20140306 SI History 추가 mds 
					if(!targetBkg.getBkgNo().equals(sourceBkg.getBkgNo())){
						if(sourceSiFlg!=null && "Y".equals(sourceSiFlg)){
							HistoryLineVO historyLineVO2 = new HistoryLineVO();
							historyLineVO2.setUiId("ESM_BKG_0099");			
							historyLineVO2.setHisCateNm("S/I");
							historyLineVO2.setBkgNo(targetBkg.getBkgNo());
							historyLineVO2.setCaFlg(targetBkg.getCaFlg());
							historyLineVO2.setCrntCtnt("S/I Check"); // 변경시 HardCoding 검토 필요함				
							historyBC.createBkgHistoryLine(historyLineVO2, account);
						}
					}
					
					// Allocation Status 
					AllocStsChgVO allocStsChgVO = receiptBC.manageAlocStatus(targetBkg, account, "");
					List<BkgNtcHisVO> bkgNtcHisVOs = allocStsChgVO.getBkgNtcHisVOs();
					if (null!=bkgNtcHisVOs) {
						historyBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0099");
					}
					// Allocation Status History 
					if(allocStsChgVO != null){
						HistoryLineVO historyLineVO2 = new HistoryLineVO();
						historyLineVO2.setUiId("ESM_BKG_0099");			
						historyLineVO2.setHisCateNm("Booking Status");
						historyLineVO2.setBkgNo(targetBkg.getBkgNo());
						historyLineVO2.setCaFlg("N");
						if (allocStsChgVO == null || allocStsChgVO.getAlocStsCd() == null){
							log.debug("Null Check");
						} else if ((allocStsChgVO.getOriAlocStsCd() == null || "".equals(allocStsChgVO.getOriAlocStsCd())) && "S".equals(allocStsChgVO.getAlocStsCd())){
							historyLineVO2.setCrntCtnt("Allocation Status change to S");
							historyBC.createBkgHistoryLine(historyLineVO2, account);
						} else if ((allocStsChgVO.getOriAlocStsCd() == null || "".equals(allocStsChgVO.getOriAlocStsCd())) && "F".equals(allocStsChgVO.getAlocStsCd())){
							historyLineVO2.setCrntCtnt("Allocation Status change to F");
							historyBC.createBkgHistoryLine(historyLineVO2, account);	
						} else if ( "F".equals(allocStsChgVO.getOriAlocStsCd()) && "S".equals(allocStsChgVO.getAlocStsCd()) ){
							historyLineVO2.setCrntCtnt("Allocation Status change F to S");
							historyBC.createBkgHistoryLine(historyLineVO2, account);
						} else if ( "S".equals(allocStsChgVO.getOriAlocStsCd()) && "F".equals(allocStsChgVO.getAlocStsCd()) ){
							historyLineVO2.setCrntCtnt("Allocation Status change S to F");
							historyBC.createBkgHistoryLine(historyLineVO2, account);
						}
					}
					// Allocation Status History 끝
				}				

				//memo split일 경우 master bkg의 history
				if (splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason().equals("M")){
					interfaceToMas(sourceBkg, "Booking Split", account);	
					
					HistoryLineVO historyLineVO = new HistoryLineVO();
				
					historyLineVO.setBkgNo (sourceBkg.getBkgNo());
					historyLineVO.setCorrNo(sourceBkg.getCaNo());
					historyLineVO.setUiId("ESM_BKG_0099");
					historyLineVO.setCrntCtnt("Memo Split into :"+splitToBkgNoStr);		
					historyLineVO.setBkgDocProcTpCd("BKGSPT");
					historyLineVO.setHisCateNm("SPLIT");		
					historyBC.createBkgHistoryLine (historyLineVO,account);
				}
			
				//interface inv, coa
				for (int i=0;i<event.getTargetBkg().length;i++){	
					BkgBlNoVO targetBkg = event.getTargetBkg()[i]; 	

					// 87: interfaceCoa
					interfaceToMas(targetBkg, "Booking Split", account);	
					
					//org bkg
					if (event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
						// memo split master에는 하지 않음
						if (splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason().equals("C")){
							
							// CNHKG만 제외
							if(!splitBkgVO.getCopySplitBkgEtcVO().get(0).getPolCd().equals("CNHKG")){

								String bracCd = "U";
								if(splitBlInfoVOList.get(i).getRtnRoute()!=null 
										&& splitBlInfoVOList.get(i).getRtnRoute().length()>10
										&& !orgTvvd.equals(splitBlInfoVOList.get(i).getTvvd())){
									bracCd = "B";
								}
								// 20091127 BackEndJob으로 변경
								// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
								Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
								vender301ParamVO.setBkgBlNoVO(targetBkg);
								vender301ParamVO.setOldVvdVOs(null);
								vender301ParamVO.setOldQtyVOs(oldBkgQtys);
								vender301ParamVO.setOldMtyPkupYdCd(oldMtyPkupYdCd);
								vender301ParamVO.setBracCd(bracCd);
								vender301ParamVO.setEdiKind("BT");
								vender301ParamVO.setAutoManualFlg("Y");
								
								searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);
								searchBC.createCustBkgReceiptEdiBackEnd(targetBkg, null, "Y", account);
							}						
						}					
					} else {							
						// CNHKG만 제외
						if(!splitBkgVO.getCopySplitBkgEtcVO().get(0).getPolCd().equals("CNHKG")){							
							// 20091127 BackEndJob으로 변경
							// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
							Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
							vender301ParamVO.setBkgBlNoVO(targetBkg);
							vender301ParamVO.setOldVvdVOs(null);
							vender301ParamVO.setOldQtyVOs(new ArrayList<BkgQuantityVO>());
							vender301ParamVO.setOldMtyPkupYdCd(oldMtyPkupYdCd);
							vender301ParamVO.setBracCd("N");
							vender301ParamVO.setEdiKind("BT");
							vender301ParamVO.setAutoManualFlg("Y");
							
							searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);
							searchBC.createCustBkgReceiptEdiBackEnd(targetBkg, null, "Y", account);
						}
					}
				}
				commit();

				/*
				   3.1 해당 Key BKG_XTER_RQST_MST에 
				         3.1.1 BKG_NO - split 된 BKG_NO 로 업데이트
				         3.1.2 SPLIT_STS_CD = 'F' 로 업데이트
				   3.2 Booking EDI 접수때와 마찬가지로 addBkgSrRequest 호출해주세요.
			        EBookingConductSC.java 의 receiptXterRqst 참고하시면 됩니다.
			    */
				if (null!=splitBlInfoVOList && 0<splitBlInfoVOList.size()) {
					begin();
					for (SplitBlInfoVO vo : splitBlInfoVOList) {
						if (!"".equals(vo.getXterSndrId()) && !"".equals(vo.getXterRqstNo()) && !"".equals(vo.getXterRqstSeq())) {
							vo.setOldBkgNo(splitBkgVO.getCopySplitBkgEtcVO().get(0).getOldBkgNo());
							ebookingBC.modifyXterBkgNoBySplit(vo, account);
							DpcsWebBookingVO dpcsWebBookingVO = new DpcsWebBookingVO();
							dpcsWebBookingVO.setXterSndrId(vo.getXterSndrId());
							dpcsWebBookingVO.setXterRqstNo(vo.getXterRqstNo());
							dpcsWebBookingVO.setXterRqstSeq(vo.getXterRqstSeq());
							reportBC.addBkgSrRequest(dpcsWebBookingVO);	
						}
					}
					commit();
				}

				begin();
				for (int i=0;i<event.getTargetBkg().length;i++){
					// invoice interface
					interfaceToInv(event.getTargetBkg()[i], account);
				}				
				commit();
				
				try{		
					for (int i=0;i<event.getTargetBkg().length;i++){	
						BkgBlNoVO targetBkg = event.getTargetBkg()[i]; 
						// cut off time (cop 생성 이후에 처리)
						String fromDt = null;
						String toDt = null;
						if("US".equals(polCd.substring(0,2)) || "CA".equals(polCd.substring(0,2))){	
							
							if(bdrFlag.equals("N")){
								PrdQtyInfoVO[] prdQtyInfo 	= receiptBC.searchBkgQtyForRailTime(targetBkg);
														
								Map railTime = prdBC.getRailRecevingTime(targetBkg.getPctlNo(), prdQtyInfo, null, null, targetBkg.getBkgNo());
	
								fromDt= (String)railTime.get("RTN_TIME"); 
								toDt  = (String)railTime.get("CUT_OFF");
							}
						}
						begin(); //batch 서버 접속해야되서 Transaction을 분리함
						receiptBC.createCargoClosingTime(targetBkg, fromDt, toDt, account);
						commit();
					} 
				} catch (Exception prdEx){
					rollback();
					log.error("err " + prdEx.toString(), prdEx);					
				}
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());	
			}else{
				eventResponse.setUserMessage(new ErrorHandler("BKG00167").getUserMessage());
			}
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		
	}
	
	/**
	 * ESM_BKG_0099 : split click <br>
	 * Booking Split 처리 <br>
	 *  
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse splitBookingLt(Event e) throws EventException{		
		try{
			EsmBkg0099Event 				event 			= (EsmBkg0099Event)e;
			GeneralEventResponse 			eventResponse 	= new GeneralEventResponse();			
			GeneralBookingSplitCombineBC 	command 		= new GeneralBookingSplitCombineBCImpl();
			
			//Bkg data 반영
			GeneralBookingReceiptBC receiptBC   = new GeneralBookingReceiptBCImpl();
			GeneralBookingSearchBC  searchBC 	= new GeneralBookingSearchBCImpl();
			BLDocumentationBLBC 	blDocBlBC 	= new BLDocumentationBLBCImpl();
			BLDocumentationCMBC 	blDocCmBC 	= new BLDocumentationCMBCImpl();
			BlRatingBC 				blRatingBC 	= new BlRatingBCImpl();
			BookingHistoryMgtBC 	historyBC 	= new BookingHistoryMgtBCImpl();
			BDRCorrectionBC         bdrBC       = new BDRCorrectionBCImpl();
			PerformanceReportBC 	reportBC	= new PerformanceReportBCImpl();
			EBookingReceiptBC       ebookingBC  = new EBookingReceiptBCImpl();
			BookingUtil             util        = new BookingUtil();
			
			// 타모듈 연동
			//BkgCopManageBC 			copBC 		= new BkgCopManageBCImpl();
        	ProductCatalogCreateBC 	prdBC 		= new ProductCatalogCreateBCImpl();
        	TransferOrderIssueBC	troBC		= new TransferOrderIssueBCImpl();
			
			//orgin bkg
			BkgBlNoVO sourceBkg = event.getSourceBkg();		
			
			// split처리 용
			SplitBkgVO 				splitBkgVO 		  = event.getSplitBkgVO();
			List<SelectCntrVO> 		selectCntrVO	  = splitBkgVO.getSelectCntrVO();
			List<SplitQtyVO>   		selectQtyVO 	  = splitBkgVO.getSplitQtyVO();
			List<SelectSpclCgoVO>	selectSpclCgoVO   = splitBkgVO.getSelectSpclCgoVO();
			List<SplitBlInfoVO>     splitBlInfoVOList = splitBkgVO.getSplitBlInfoVO();
			//2010.11.30 김영철 [] R4J - 사용하지 않은 지역변수 삭제
//			List<SelectTroVO>		selectTroVO		= splitBkgVO.getSelectTroVO();					
			
			//for History
			String      splitToBkgNoStr = "";
			String []   cntrHistStr 	= new String[event.getTargetBkg().length];
			String 	    preCntrHistStr	= "";
			String      orgTvvd 		= splitBkgVO.getCopySplitBkgEtcVO().get(0).getTvvd();
			String 		polCd			= splitBkgVO.getCopySplitBkgEtcVO().get(0).getPolCd();			
			String		splitRsnCd 		= splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason();
			HistoryTableVO histTableVO  = null;
			
			//for auto c/a
			String bdrFlag = "N";
			BkgCorrectionVO bkgCorrectionVO = new BkgCorrectionVO();
			if(splitBkgVO.getCopySplitBkgEtcVO().get(0).getBdrFlag().equals("Y")){
				bdrFlag = "Y";
			}			
			
			// prd 호출
			ArrayList<String> cntrNoList  = null;
			String [][] 	  pctlMapSeq  = new String[event.getTargetBkg().length][2];	
			
			// prd에 넘겨줄 bkg list
			ArrayList<String> bkgNoList = new ArrayList<String>();
			for (int i=0;i<event.getTargetBkg().length;i++){
				event.getTargetBkg()[i].setPctlNo(sourceBkg.getPctlNo());
				bkgNoList.add(event.getTargetBkg()[i].getBkgNo());				
				// for history
				if(i==0){
					splitToBkgNoStr = event.getTargetBkg()[i].getBkgNo(); 
				} else {
//					splitToBkgNoStr = splitToBkgNoStr + ", " + event.getTargetBkg()[i].getBkgNo();
					StringBuffer tmpBuffer = new StringBuffer(splitToBkgNoStr).append(", ").append(event.getTargetBkg()[i].getBkgNo());
					splitToBkgNoStr = tmpBuffer.toString();
					if(i%3==0){
//						splitToBkgNoStr = splitToBkgNoStr + "\n";
						StringBuffer tmpBuffer2 = new StringBuffer(splitToBkgNoStr).append("\n");
						splitToBkgNoStr = tmpBuffer2.toString();
					}
				}
			}
			
			begin();
			
//			//같은 office인지 확인  -> 제외 (20100406 임종한 과장님 요청)
//			if(!"Y".equals(bdrFlag)){
//				util.searchOfcVsBkgOfc(sourceBkg, account);
//			}
			
			
			// split bkg 별로 prd에 call
			for (int i=0;i<event.getTargetBkg().length;i++){
				//memo split일 경우 P/C 추가 call
				if(0==i && splitRsnCd.equals("M")){
	                PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO(); 
	                prdMainInfoVO.setPcMode("S");
	                prdMainInfoVO.setFCmd("3");
	                prdMainInfoVO.setBkgNo(sourceBkg.getBkgNo());
	                prdMainInfoVO.setParentBkgNo(sourceBkg.getBkgNo());
	                prdMainInfoVO.setBkgOfc(account.getOfc_cd());
	                
	                PrdParameterVO prdParameterVO = new PrdParameterVO();
	                prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
	                
	                //for qty
	                ArrayList<PrdQtyInfoVO> prdQtyList = new ArrayList<PrdQtyInfoVO>();
	                PrdQtyInfoVO[] 			prdQtyInfos = receiptBC.searchBkgQtyForRailTime(sourceBkg);
	                PrdQtyInfoVO 			prdQtyInfo = null;
	                for(int icnt=0;icnt<prdQtyInfos.length; icnt++) {
                		prdQtyInfo = new PrdQtyInfoVO();
                		prdQtyInfo.setCQty (prdQtyInfos[icnt].getCQty());
                		prdQtyInfo.setCTpsz(prdQtyInfos[icnt].getCTpsz());
                		prdQtyList.add(prdQtyInfo); 
	                }
	                
	                prdParameterVO.setPrdQtyInfo(prdQtyList);

	                //for cntr
	                cntrNoList = new ArrayList<String>();
	                String [] cntrNos = util.searchCntrListByBkg(sourceBkg);
	                for(int icnt=0;icnt<cntrNos.length; icnt++) {
	                    cntrNoList.add(cntrNos[icnt]);
	                }
	                String pctlNoMapSeqStr = prdBC.createPrdCtlgRoutSplit(prdParameterVO, account, cntrNoList, i, bkgNoList);
	                String [] memoPctlMapSeq = util.splitByToken(pctlNoMapSeqStr, "|"); 
	            	sourceBkg.setPctlNo(memoPctlMapSeq[0]); 
	            	sourceBkg.setMapSeq(memoPctlMapSeq[1]);
				}
				
				BkgBlNoVO targetBkg = event.getTargetBkg()[i];
				log.debug("\nprocessing bkg no:"+targetBkg.getBkgNo());
                
                PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO(); 
                prdMainInfoVO.setPcMode("S");
                prdMainInfoVO.setFCmd("3");
                prdMainInfoVO.setBkgNo(targetBkg.getBkgNo());
                prdMainInfoVO.setParentBkgNo(sourceBkg.getBkgNo());
                prdMainInfoVO.setBkgOfc(account.getOfc_cd());
                
                PrdParameterVO prdParameterVO = new PrdParameterVO();
                prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
                
                //for qty
                ArrayList<PrdQtyInfoVO> prdQtyList = new ArrayList<PrdQtyInfoVO>();
                PrdQtyInfoVO 			prdQtyInfo = null;                       

                for(int icnt=0;icnt<selectQtyVO.size(); icnt++) {
                	int targetBkgSeq = icnt%splitBlInfoVOList.size();
                	selectQtyVO.get(icnt).setSplitNo(splitBlInfoVOList.get(targetBkgSeq).getBkgNo());
                	double iQty =(selectQtyVO.get(icnt).getOpCntrQty()==null)? 0:Double.parseDouble(selectQtyVO.get(icnt).getOpCntrQty());

                	if (targetBkg.getBkgNo().equals(splitBlInfoVOList.get(targetBkgSeq).getBkgNo())
       					&& iQty>0.0){
                		prdQtyInfo = new PrdQtyInfoVO();
                		prdQtyInfo.setCQty (selectQtyVO.get(icnt).getOpCntrQty());
                		prdQtyInfo.setCTpsz(selectQtyVO.get(icnt).getCntrTpszCd());
                		prdQtyList.add(prdQtyInfo); 
                	}
                }
                prdParameterVO.setPrdQtyInfo(prdQtyList);

                //for cntr
                cntrNoList = new ArrayList<String>();
                cntrHistStr[i] = "";
                for(int icnt=0;icnt<selectCntrVO.size(); icnt++) {
                    if (selectCntrVO.get(icnt).getBkg_no().equals(targetBkg.getBkgNo())
                        && selectCntrVO.get(icnt).getSplitNo().length()>1){
                    	cntrNoList.add(selectCntrVO.get(icnt).getCntr_no());
                    	//for history
                    	if(cntrNoList.size() == 1){
                    		cntrHistStr[i] = selectCntrVO.get(icnt).getCntr_no();
                    	} else {
                    		if(cntrNoList.size()%3==1){
//                    			cntrHistStr[i] = cntrHistStr[i] + ",\n" + selectCntrVO.get(icnt).getCntr_no();
                    			StringBuffer tmpBuffer = new StringBuffer(cntrHistStr[i]).append(",\n").append(selectCntrVO.get(icnt).getCntr_no());
                    			cntrHistStr[i] = tmpBuffer.toString();
                    		} else {
//                    			cntrHistStr[i] = cntrHistStr[i] + ", " + selectCntrVO.get(icnt).getCntr_no();
                    			StringBuffer tmpBuffer = new StringBuffer(cntrHistStr[i]).append(", ").append(selectCntrVO.get(icnt).getCntr_no());
                    			cntrHistStr[i] = tmpBuffer.toString();
                    		}
                    	}
                    }
                }
                String pctlNoMapSeqStr = prdBC.createPrdCtlgRoutSplit(prdParameterVO, account, cntrNoList, i, bkgNoList);
            	pctlMapSeq[i] = util.splitByToken(pctlNoMapSeqStr, "|");
			}// prd 호출 끝			
			commit();
			
			// for quantity history
			List<BkgQuantityVO> oldBkgQtys = receiptBC.searchBkgQuantity(sourceBkg);
			String oldMtyPkupYdCd = ((OldBkgInfoVO)receiptBC.searchOldBkgInfo(sourceBkg)).getMtyPkupYdCd();
			
			//for cntr history
			if(selectCntrVO.size()>0){
				String [] cntrList = util.searchCntrListByBkg(sourceBkg);
				for(int i=0;i<cntrList.length;i++){
                	if(i == 0){
                		preCntrHistStr = cntrList[i];
                	} else {
                		if((i+1)%3==1){
//                			preCntrHistStr = preCntrHistStr + ",\n" + cntrList[i];
                			StringBuffer tmpBuffer = new StringBuffer(preCntrHistStr).append(",\n").append(cntrList[i]);
                			preCntrHistStr = tmpBuffer.toString();
                		} else {
//                			preCntrHistStr = preCntrHistStr + ", " + cntrList[i];
                			StringBuffer tmpBuffer = new StringBuffer(preCntrHistStr).append(", ").append(cntrList[i]);
                			preCntrHistStr = tmpBuffer.toString();
                		}
                	}
				}				
			}
			
			if (command.validateSplit(event.getSplitBkgVO(), sourceBkg).equals("Y")){
				begin();
				if(bdrFlag.equals("Y")){
					// add1stCaHist : sourcebkg의 최초 c/a hist을 넣는다(corr_no : 0000000001)
					add1stCaHist(event.getSourceBkg());
				}

				// Copy여부에 따라 Information Alert을 표시할지를 판단하기 위한 Flag를 셋팅.
				String splitFlg = receiptBC.copyBookingForSplit   (sourceBkg, event.getTargetBkg(), splitBkgVO,   account);
				eventResponse.setETCData("split_flag", splitFlg);

				blDocBlBC.copyBlDocByBkg		(sourceBkg, event.getTargetBkg(), splitBkgVO, account );
				if(selectCntrVO.size()>0){
					BkgCopyCntrCmByBkgVO bkgCopyCntrCmByBkgVO = new BkgCopyCntrCmByBkgVO();
					bkgCopyCntrCmByBkgVO.setCopyModeCd("S");
					bkgCopyCntrCmByBkgVO.setHitchmentYn("");
//					bkgBlActWgtVO.setOldPodNodCd(oldBkgInfoVO.getPodNodCd());
//					bkgBlActWgtVO.setOldDelNodCd(oldBkgInfoVO.getDelNodCd());
					
					//blDocCmBC.copyCntrCmByBkg   ("S", sourceBkg, event.getTargetBkg(), selectCntrVO, account, "");
					blDocCmBC.copyCntrCmByBkg   (sourceBkg, event.getTargetBkg(), selectCntrVO, bkgCopyCntrCmByBkgVO ,account);
				}
				blDocBlBC.copyHblByBkg      ("S", sourceBkg, event.getTargetBkg(), selectCntrVO, account);
				if(selectSpclCgoVO.size()>0){
					SpecialCargoReceiptBC spclCgoBC = new SpecialCargoReceiptBCImpl();
					spclCgoBC.copySpclCgoByBkg  ("S", sourceBkg, event.getTargetBkg(), selectSpclCgoVO, account);
				}
				blRatingBC.copyManualChgByBkg   (sourceBkg, event.getTargetBkg(), account, splitRsnCd);
//				if(selectTroVO.size()>0){
//					if("EUR".equals(event.getTroTp())){
//						troBC.unconfirmEurTro(sourceBkg, "O", account);
//					} else {
//						troBC.unconfirmTro(sourceBkg, account);
//					}
//					copBC.unconfirmTro(sourceBkg.getBkgNo(), "O");
//					troBC.copyTroByBkg("S", sourceBkg, event.getTargetBkg(),selectTroVO, event.getTroTp(),  account);
//				} 
				//임시 주석 처리
				if(selectSpclCgoVO.size()>0){
					//bkg의 spcl flag 재 계산
					receiptBC.modifySpclFlag(event.getTargetBkg(), account);
					if(selectCntrVO.size()>0){
						//container의 spcl flag 재계산
						blDocCmBC.modifyCntrSpclFlag(event.getTargetBkg(), account);
					}
				}
				
				//cop에 1차로 split을 반영
				String [] targetBkgNoList = new String[event.getTargetBkg().length + (splitRsnCd.equals("M")?1:0)];
				String [] copMapSeq       = new String[event.getTargetBkg().length + (splitRsnCd.equals("M")?1:0)];
				for(int i=0;i<event.getTargetBkg().length;i++){
					targetBkgNoList[i] = event.getTargetBkg()[i].getBkgNo();	
					copMapSeq[i]       = pctlMapSeq[i][1]; 
				}				
				if(splitRsnCd.equals("M")){
					targetBkgNoList[targetBkgNoList.length-1] = sourceBkg.getBkgNo();	
					copMapSeq      [targetBkgNoList.length-1] = sourceBkg.getMapSeq(); 
				}
				//copBC.splitBkg(sourceBkg.getBkgNo(), targetBkgNoList, copMapSeq);
				callCopSplitBkg(sourceBkg.getBkgNo(), targetBkgNoList, copMapSeq);
				
				// S 2010.08.31 KMJ TRO Split 추가
				// 81. copyTroBySplit
				troBC.copyTroBySplit(sourceBkg.getBkgNo(), targetBkgNoList, account);
				// 82. cancelTroBySplit
				troBC.cancelTroBySplit(sourceBkg.getBkgNo(), targetBkgNoList, account);
				// 2010.08.31 KMJ TRO Split 추가
				
				// 20140306 SI History 추가
				String sourceSiFlg = receiptBC.searchSiFlg(sourceBkg);
				
				for (int i=0;i<event.getTargetBkg().length;i++){
					BkgBlNoVO targetBkg = event.getTargetBkg()[i];
					
					//for performance report
					reportBC.manageQtyCntrCoposite(targetBkg.getBkgNo(), "CQ");	
					reportBC.manageQtyCntrCoposite(targetBkg.getBkgNo(), "CN");			
				
					// bdr 이전이면 해당 Booking의 status를 재계산한다.
					if(bdrFlag.equals("Y")){
						// bdr 이후일 경우 
						bkgCorrectionVO.setBkgNo(targetBkg.getBkgNo());
						//split new Bkg에 대해 BDR이후일 경우 first c/a(dummy)
						if (!event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
							add1stCaHist(targetBkg);
						}
					}
					
					//vvd가 변경되었을 경우
					log.debug("\nbkg:"+targetBkg.getBkgNo()+",tVvd:"+splitBlInfoVOList.get(i).getTvvd()
							+ "\nroute String:"+splitBlInfoVOList.get(i).getRtnRoute());	
					if(splitBlInfoVOList.get(i).getRtnRoute()!=null 
						&& splitBlInfoVOList.get(i).getRtnRoute().length()>10
						&& !orgTvvd.equals(splitBlInfoVOList.get(i).getTvvd())){
						
						//PrdMainInfoVO Set
						PrdMainInfoVO prdMainInfoVO  = new PrdMainInfoVO();
						prdMainInfoVO.setFCmd("3");
						prdMainInfoVO.setPcMode("R");
						prdMainInfoVO.setTVvd (splitBlInfoVOList.get(i).getTvvd());
						prdMainInfoVO.setBkgNo(targetBkg.getBkgNo());
						
						PrdParameterVO prdParameterVO = new PrdParameterVO();
						prdParameterVO.setBkgBlNoVO(targetBkg);
						prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
						prdParameterVO=util.searchPrdParmForFullRoute (prdParameterVO);
						
						PrdMainInfoVO rtnPrdMainInfoVO = prdParameterVO.getPrdMainInfoVO();
						util.resetNthRoute(rtnPrdMainInfoVO, 1);
						util.resetNthRoute(rtnPrdMainInfoVO, 2);
						util.resetNthRoute(rtnPrdMainInfoVO, 3);
						util.resetNthRoute(rtnPrdMainInfoVO, 4);
						rtnPrdMainInfoVO.setOrgTrnsMode("");
						rtnPrdMainInfoVO.setDestTrnsMode("");
						
						String rtnRoute = splitBlInfoVOList.get(i).getRtnRoute();
						String [] rtnRouteVvds = util.splitByToken(rtnRoute, ",");
						for(int j=0;j<rtnRouteVvds.length;j++){
							if(rtnRouteVvds[j].length()==0) break;
							String [] rtnRouteInfo = util.splitByToken(rtnRouteVvds[j], "|");
							log.debug("\npol:"+rtnRouteInfo[0]+"/polYd:"+rtnRouteInfo[1]+"/pol_clpt:"+rtnRouteInfo[6]+
									   "/pod:"+rtnRouteInfo[2]+"/podYd:"+rtnRouteInfo[3]+"/pod_clpt:"+rtnRouteInfo[7] +
									   "/vvd:"+rtnRouteInfo[4]+"/lane:"+rtnRouteInfo[5]);
							if(j==0){
								rtnPrdMainInfoVO.setPol1 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol1N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol1C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod1 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod1N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod1C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd1 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane1(rtnRouteInfo[5]);
							} else if(j==1){
								rtnPrdMainInfoVO.setPol2 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol2N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol2C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod2 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod2N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod2C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd2 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane2(rtnRouteInfo[5]);
							} else if(j==2){
								rtnPrdMainInfoVO.setPol3 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol3N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol3C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod3 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod3N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod3C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd3 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane3(rtnRouteInfo[5]);
							} else if(j==3){
								rtnPrdMainInfoVO.setPol4 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol4N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol4C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod4 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod4N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod4C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd4 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane4(rtnRouteInfo[5]);
							}
						}
						
						prdParameterVO.setPrdMainInfoVO(rtnPrdMainInfoVO);
//						util.prdParameterLog(prdParameterVO.getPrdMainInfoVO());

						// 12. createProdCtlRoute
						String pctlNoMapSeqStr = prdBC.createPrdCtlgRout(prdParameterVO, account);
						String [] pctlNoMapSeq = util.splitByToken(pctlNoMapSeqStr, "|");
						
						targetBkg.setPctlNo(pctlNoMapSeq[0]);
						targetBkg.setMapSeq(pctlNoMapSeq[1]);						

						//	vvd변경에 대한 old vvd조회(org bkg에 대해서만 vvd 변경 이력을 남긴다)
						histTableVO = new HistoryTableVO();
						if(targetBkg.getBkgNo().equals(sourceBkg.getBkgNo())){
							histTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0099", targetBkg);
						}
						
						// 실제 vvd 변경
						VvdAssignVO vvdAssignVO = new VvdAssignVO();
						vvdAssignVO.setBkgBlNoVO(targetBkg);
//						BdrSpclVO bdrSpclVO = receiptBC.modifyOceanRoute(vvdAssignVO, account);
						receiptBC.modifyOceanRoute(vvdAssignVO, account);
												
						//cop에 2차로 replan 반영
						//copBC.updateBkg(targetBkg.getBkgNo(), targetBkg.getMapSeq());
						callCopUpdateBkg(targetBkg.getBkgNo(), targetBkg.getMapSeq());
					}//vvd가 변경되었을 경우 끝
					
					if(selectSpclCgoVO.size()>0){
						reRequestSpclCgoApproval(targetBkg, "SPLIT", null);
					}
					
					// bdr 이전이면 해당 Booking의 status를 재계산한다.
					if(bdrFlag.equals("N")){
						receiptBC.changeBkgStatus("Y",targetBkg, false, account);
					}

					// auto c/a 처리
					if(bdrFlag.equals("Y")){						
						// vvd 변경됐을 경우
						if(splitBlInfoVOList.get(i).getRtnRoute()!=null){
							bkgCorrectionVO.setRoutCorrFlg("Y");
							bkgCorrectionVO.setTrnkVslCorrFlg("Y");
						}
						
						if (event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
							bdrBC.addAutoCaTemp(sourceBkg, "SPLIT_MASTER", bkgCorrectionVO, account);
						} else {
							bdrBC.addAutoCaTemp(targetBkg, "SPLIT_NEW", bkgCorrectionVO, account);
						}
						
						BkgBlNoVO corrBkgBlNoVO = addCaHistory(event.getCaRsnCd(), event.getCaRemark(), targetBkg, "N", "Y");
						targetBkg.setCaNo(corrBkgBlNoVO.getCaNo());
						event.getTargetBkg()[i].setCaNo(corrBkgBlNoVO.getCaNo());
						
						bdrBC.removeCATemp(targetBkg);
						
						blRatingBC.distributeCntrRate(targetBkg.getBkgNo(), account);
						
			            //추가2. 
						OblIssVO oblIssVO = util.searchOblIssue(targetBkg); 
						
						//추가2. 
						RevDrNoteVO        revDrNoteVO    = new RevDrNoteVO(); 
						CstmBkgRevDrNoteVO bkgRevDrNoteVO = new CstmBkgRevDrNoteVO();
						bkgRevDrNoteVO.setBkgNo      (targetBkg.getBkgNo());  
						bkgRevDrNoteVO.setBkgCorrNo  (targetBkg.getCaNo()); 
						bkgRevDrNoteVO.setRdnNo      (oblIssVO.getRdnNo()); 
						bkgRevDrNoteVO.setRvisSeq    (oblIssVO.getRvisSeq()); 
						bkgRevDrNoteVO.setReceiverRmk("");
						revDrNoteVO.setBkgRevDrNoteVO(bkgRevDrNoteVO);

						RevenueDebitNoteBC revenueDebitNoteBC = new RevenueDebitNoteBCImpl();
						revenueDebitNoteBC.acceptRDNbyReceiptOffice(revDrNoteVO, account);  
						
						//추가2. 
						OblRdemVO oblRdem = new OblRdemVO();
						oblRdem.setBlNo      (oblIssVO.getBlNo());  
						oblRdem.setCgorTeamCd("C");
						oblRdem.setCgoEvntNm ("B/L Correct");
						oblRdem.setEvntDt    (new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
						oblRdem.setEvntOfcCd (account.getOfc_cd());
						oblRdem.setEvntUsrId (account.getUsr_id());
						oblRdem.setOblRdemFlg(oblIssVO.getOblRlseFlg()); 

						CargoReleaseOrderBC cargoReleaseOrderBC = new CargoReleaseOrderBCImpl();
						try{
							cargoReleaseOrderBC.setupFocByObl(oblRdem);
						} catch(Exception crEx){
							log.error("err " + crEx.toString(), crEx);
						}	
					} else {
						targetBkg.setCaNo("");
					}// auto c/a 처리 끝

					// history 처리
					HistoryLineVO historyLineVO = new HistoryLineVO();
					
					historyLineVO.setBkgNo (targetBkg.getBkgNo());
					historyLineVO.setCorrNo(targetBkg.getCaNo());
					historyLineVO.setUiId("ESM_BKG_0099");
					if (event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
						historyLineVO.setCrntCtnt("Split into :"+splitToBkgNoStr);		
						historyLineVO.setBkgDocProcTpCd("BKGSPT");				
					} else {
						historyLineVO.setCrntCtnt("Split from BKG No :"+sourceBkg.getBkgNo()); //new -> Splited from BKG No : %, old -> Splited.			
						historyLineVO.setBkgDocProcTpCd("SPTCRE");
					}
					historyLineVO.setHisCateNm("SPLIT");		
					historyBC.createBkgHistoryLine (historyLineVO,account);
					
					//	vvd변경에 대한 history
					if(targetBkg.getBkgNo().equals(sourceBkg.getBkgNo())){
						if(splitBlInfoVOList.get(i).getRtnRoute()!=null 
								&& splitBlInfoVOList.get(i).getRtnRoute().length()>10
								&& !orgTvvd.equals(splitBlInfoVOList.get(i).getTvvd())){
							if(histTableVO!=null && histTableVO.getBkgBlNoVO()!=null){
								histTableVO.getBkgBlNoVO().setCaNo(targetBkg.getCaNo());
							}
							historyBC.manageBookingHistory("ESM_BKG_0099", histTableVO, account);
						}
					}
					if(cntrHistStr[i].length()>0){
						//	cntr에 대한 histiry
						historyLineVO.setCrntCtnt(cntrHistStr[i]); 
						if(targetBkg.getBkgNo().equals(sourceBkg.getBkgNo())){
							historyLineVO.setPreCtnt(preCntrHistStr);
						} 
						historyLineVO.setHisCateNm("Container No.");						
						historyBC.createBkgHistoryLine (historyLineVO,account);					
						historyBC.releaseCntrFinalConfirm(targetBkg, account);
						// history 처리 끝
					}
					
					// 20140306 SI History 추가 mds 
					if(!targetBkg.getBkgNo().equals(sourceBkg.getBkgNo())){
						if(sourceSiFlg!=null && "Y".equals(sourceSiFlg)){
							HistoryLineVO historyLineVO2 = new HistoryLineVO();
							historyLineVO2.setUiId("ESM_BKG_0099");			
							historyLineVO2.setHisCateNm("S/I");
							historyLineVO2.setBkgNo(targetBkg.getBkgNo());
							historyLineVO2.setCaFlg(targetBkg.getCaFlg());
							historyLineVO2.setCrntCtnt("S/I Check"); // 변경시 HardCoding 검토 필요함				
							historyBC.createBkgHistoryLine(historyLineVO2, account);
						}
					}
				}

				//memo split일 경우 master bkg의 history
				if (splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason().equals("M")){
					interfaceToMas(sourceBkg, "Booking Split", account);	
					
					HistoryLineVO historyLineVO = new HistoryLineVO();
				
					historyLineVO.setBkgNo (sourceBkg.getBkgNo());
					historyLineVO.setCorrNo(sourceBkg.getCaNo());
					historyLineVO.setUiId("ESM_BKG_0099");
					historyLineVO.setCrntCtnt("Memo Split into :"+splitToBkgNoStr);		
					historyLineVO.setBkgDocProcTpCd("BKGSPT");
					historyLineVO.setHisCateNm("SPLIT");		
					historyBC.createBkgHistoryLine (historyLineVO,account);
				}
			
				//interface inv, coa
				for (int i=0;i<event.getTargetBkg().length;i++){	
					BkgBlNoVO targetBkg = event.getTargetBkg()[i]; 	

					// 87: interfaceCoa
					interfaceToMas(targetBkg, "Booking Split", account);	
					
					//org bkg
					if (event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
						// memo split master에는 하지 않음
						if (splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason().equals("C")){
							
							// CNHKG만 제외
							if(!splitBkgVO.getCopySplitBkgEtcVO().get(0).getPolCd().equals("CNHKG")){

								String bracCd = "U";
								if(splitBlInfoVOList.get(i).getRtnRoute()!=null 
										&& splitBlInfoVOList.get(i).getRtnRoute().length()>10
										&& !orgTvvd.equals(splitBlInfoVOList.get(i).getTvvd())){
									bracCd = "B";
								}
								// 20091127 BackEndJob으로 변경
								// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
								Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
								vender301ParamVO.setBkgBlNoVO(targetBkg);
								vender301ParamVO.setOldVvdVOs(null);
								vender301ParamVO.setOldQtyVOs(oldBkgQtys);
								vender301ParamVO.setOldMtyPkupYdCd(oldMtyPkupYdCd);
								vender301ParamVO.setBracCd(bracCd);
								vender301ParamVO.setEdiKind("BT");
								vender301ParamVO.setAutoManualFlg("Y");
								
								searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);
								searchBC.createCustBkgReceiptEdiBackEnd(targetBkg, null, "Y", account);
							}						
						}					
					} else {							
						// CNHKG만 제외
						if(!splitBkgVO.getCopySplitBkgEtcVO().get(0).getPolCd().equals("CNHKG")){							
							// 20091127 BackEndJob으로 변경
							// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
							Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
							vender301ParamVO.setBkgBlNoVO(targetBkg);
							vender301ParamVO.setOldVvdVOs(null);
							vender301ParamVO.setOldQtyVOs(new ArrayList<BkgQuantityVO>());
							vender301ParamVO.setOldMtyPkupYdCd(oldMtyPkupYdCd);
							vender301ParamVO.setBracCd("N");
							vender301ParamVO.setEdiKind("BT");
							vender301ParamVO.setAutoManualFlg("Y");
							
							searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);
							searchBC.createCustBkgReceiptEdiBackEnd(targetBkg, null, "Y", account);
						}
					}
				}
				commit();

				/*
				   3.1 해당 Key BKG_XTER_RQST_MST에 
				         3.1.1 BKG_NO - split 된 BKG_NO 로 업데이트
				         3.1.2 SPLIT_STS_CD = 'F' 로 업데이트
				   3.2 Booking EDI 접수때와 마찬가지로 addBkgSrRequest 호출해주세요.
			        EBookingConductSC.java 의 receiptXterRqst 참고하시면 됩니다.
			    */
				if (null!=splitBlInfoVOList && 0<splitBlInfoVOList.size()) {
					begin();
					for (SplitBlInfoVO vo : splitBlInfoVOList) {
						if (!"".equals(vo.getXterSndrId()) && !"".equals(vo.getXterRqstNo()) && !"".equals(vo.getXterRqstSeq())) {
							vo.setOldBkgNo(splitBkgVO.getCopySplitBkgEtcVO().get(0).getOldBkgNo());
							ebookingBC.modifyXterBkgNoBySplit(vo, account);
							DpcsWebBookingVO dpcsWebBookingVO = new DpcsWebBookingVO();
							dpcsWebBookingVO.setXterSndrId(vo.getXterSndrId());
							dpcsWebBookingVO.setXterRqstNo(vo.getXterRqstNo());
							dpcsWebBookingVO.setXterRqstSeq(vo.getXterRqstSeq());
							reportBC.addBkgSrRequest(dpcsWebBookingVO);	
						}
					}
					commit();
				}

				begin();
				for (int i=0;i<event.getTargetBkg().length;i++){
					// invoice interface
					interfaceToInv(event.getTargetBkg()[i], account);
				}				
				commit();
				
				try{		
					for (int i=0;i<event.getTargetBkg().length;i++){	
						BkgBlNoVO targetBkg = event.getTargetBkg()[i]; 
						// cut off time (cop 생성 이후에 처리)
						String fromDt = null;
						String toDt = null;
						if("US".equals(polCd.substring(0,2)) || "CA".equals(polCd.substring(0,2))){	
							
							if(bdrFlag.equals("N")){
								PrdQtyInfoVO[] prdQtyInfo 	= receiptBC.searchBkgQtyForRailTime(targetBkg);
														
								Map railTime = prdBC.getRailRecevingTime(targetBkg.getPctlNo(), prdQtyInfo, null, null, targetBkg.getBkgNo());
	
								fromDt= (String)railTime.get("RTN_TIME");
								toDt  = (String)railTime.get("CUT_OFF");
							}
							
						}
						begin(); //batch 서버 접속해야되서 Transaction을 분리함
						receiptBC.createCargoClosingTime(targetBkg, fromDt, toDt, account);
						commit();
					} 
				} catch (Exception prdEx){
					rollback();
					log.error("err " + prdEx.toString(), prdEx);					
				}
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());	
			}else{
				eventResponse.setUserMessage(new ErrorHandler("BKG00167").getUserMessage());
			}
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		
	}
	/**
	 * ESM_BKG_0099 : split click <br>
	 * Booking Split 처리 <br>
	 *  
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse splitBookingMulti(Event e) throws EventException{		
		try{
			EsmBkg0099Event 				event 			= (EsmBkg0099Event)e;
			GeneralEventResponse 			eventResponse 	= new GeneralEventResponse();			
			GeneralBookingSplitCombineBC 	command 		= new GeneralBookingSplitCombineBCImpl();
			
			//Bkg data 반영
			GeneralBookingReceiptBC receiptBC   = new GeneralBookingReceiptBCImpl();
			GeneralBookingSearchBC  searchBC 	= new GeneralBookingSearchBCImpl();
			BLDocumentationBLBC 	blDocBlBC 	= new BLDocumentationBLBCImpl();
			BLDocumentationCMBC 	blDocCmBC 	= new BLDocumentationCMBCImpl();
			BlRatingBC 				blRatingBC 	= new BlRatingBCImpl();
			SpecialCargoReceiptBC 	spclCgoBC 	= new SpecialCargoReceiptBCImpl();
			BookingHistoryMgtBC 	historyBC 	= new BookingHistoryMgtBCImpl();
			BDRCorrectionBC         bdrBC       = new BDRCorrectionBCImpl();
			PerformanceReportBC 	reportBC	= new PerformanceReportBCImpl();
			EBookingReceiptBC       ebookingBC  = new EBookingReceiptBCImpl();
			BLIssuanceBC            blIssBC		= new BLIssuanceBCImpl();
			BookingUtil             util        = new BookingUtil();
			
			// 타모듈 연동
			//BkgCopManageBC 			copBC 		= new BkgCopManageBCImpl();
        	ProductCatalogCreateBC 	prdBC 		= new ProductCatalogCreateBCImpl();
        	TransferOrderIssueBC	troBC		= new TransferOrderIssueBCImpl();
			
			//orgin bkg
			BkgBlNoVO sourceBkg = event.getSourceBkg();
			String currSplitBkg = event.getCurrSplitBkg();
			
			// 중복 Request에 대해서 성공으로 return. 
			BkgBlNoVO dupChkBkgVO = new BkgBlNoVO();
			dupChkBkgVO.setBkgNo(currSplitBkg);
			if(util.searchBkgStatusByBkg(dupChkBkgVO) != null){
				return eventResponse;				
			}
			
			// split처리 용
			SplitBkgVO 				splitBkgVO 		  = event.getSplitBkgVO();
			List<SelectCntrVO> 		selectCntrVO	  = splitBkgVO.getSelectCntrVO();
			List<SplitQtyVO>   		selectQtyVO 	  = splitBkgVO.getSplitQtyVO();
			List<SelectSpclCgoVO>	selectSpclCgoVO   = splitBkgVO.getSelectSpclCgoVO();
			List<SplitBlInfoVO>     splitBlInfoVOList = splitBkgVO.getSplitBlInfoVO();
			
			//2010.11.30 김영철 [] R4J - 사용하지 않은 지역변수 삭제
//			List<SelectTroVO>		selectTroVO		= splitBkgVO.getSelectTroVO();					
			
			//for History
			String      splitToBkgNoStr = "";
			String []   cntrHistStr 	= new String[event.getTargetBkg().length];
			String 	    preCntrHistStr	= "";
			String      orgTvvd 		= splitBkgVO.getCopySplitBkgEtcVO().get(0).getTvvd();
			String 		polCd			= splitBkgVO.getCopySplitBkgEtcVO().get(0).getPolCd();			
			String		splitRsnCd 		= splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason();
			HistoryTableVO histTableVO  = null;
			
			//for auto c/a
			String bdrFlag = "N";
			String lstCorrNo = "";			
			BkgCorrectionVO bkgCorrectionVO = new BkgCorrectionVO();
			if(splitBkgVO.getCopySplitBkgEtcVO().get(0).getBdrFlag().equals("Y")){
				bdrFlag = "Y";
			}			
			
			// split을 한번에 하나씩만 하도록 변경함 (20120719 류대영)
			int currSeq = 0;			
			int orgSplitSize = splitBlInfoVOList.size();
			int currSplitBkgSeq = 0;
			for (int i=0;i<event.getTargetBkg().length;i++){
				event.getTargetBkg()[i].setPctlNo(sourceBkg.getPctlNo());
				if(currSplitBkg.equals(event.getTargetBkg()[i].getBkgNo())){
					currSplitBkgSeq = i;
				}
			}
			BkgBlNoVO[] tempTargetBkg = new BkgBlNoVO[2];
			List<SplitBlInfoVO> tempSplitblInfoVOList = new ArrayList<SplitBlInfoVO>();
			for (int i=0;i<event.getTargetBkg().length;i++){
				if(event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
					tempTargetBkg[0] = event.getTargetBkg()[i];
					tempSplitblInfoVOList.add(splitBlInfoVOList.get(i));
				}
				if(event.getTargetBkg()[i].getBkgNo().equals(currSplitBkg)){
					tempTargetBkg[1] = event.getTargetBkg()[i];
					tempSplitblInfoVOList.add(splitBlInfoVOList.get(i));
					currSeq = i;
				}
				// 원본 bkg에 대해서 split되는 bkg의 wgt,meas,pck만큼만 빠지도록 함
				// 화면에서 나눠져 있는 상태이므로 split되는 bkg 이후의 wgt,meas,pck를 다시 더해줌
				if(currSeq > 0 && currSeq < i){
					tempSplitblInfoVOList.get(0).setActWgt("" +
						(Float.parseFloat(tempSplitblInfoVOList.get(0).getActWgt())
							+ Float.parseFloat(splitBlInfoVOList.get(i).getActWgt())
						));;
					tempSplitblInfoVOList.get(0).setMeasQty("" +
						(Float.parseFloat(tempSplitblInfoVOList.get(0).getMeasQty())
							+ Float.parseFloat(splitBlInfoVOList.get(i).getMeasQty())
						));;
					tempSplitblInfoVOList.get(0).setPckQty("" +
						(Float.parseFloat(tempSplitblInfoVOList.get(0).getPckQty())
							+ Float.parseFloat(splitBlInfoVOList.get(i).getPckQty())
						));;
				}
			}			
			event.setTargetBkg(tempTargetBkg);
			splitBlInfoVOList = tempSplitblInfoVOList;
			splitBkgVO.setSplitBlInfoVO(splitBlInfoVOList);
			
			String tempCntrNo = "";
			Boolean deleteCntrFlag = false;
			int deleteCntrSeq = 0;
			List<SelectCntrVO> orgSelectCntrVO = selectCntrVO;
			for(int i=0;i<selectCntrVO.size();i++){
				if(selectCntrVO.get(i).getBkg_no().equals(sourceBkg.getBkgNo())){
					tempCntrNo = selectCntrVO.get(i).getCntr_no();
					deleteCntrFlag = true;
					deleteCntrSeq = i;
					currSeq = 0;
				}
				if(selectCntrVO.get(i).getBkg_no().equals(currSplitBkg)){
					currSeq = i;
				}
				if(currSeq > 0 && currSeq < i){
					if(tempCntrNo.equals(selectCntrVO.get(i).getCntr_no())
							&& selectCntrVO.get(i).getSplitNo().length() > 1){
						deleteCntrFlag = false;
					}
				}
				if(orgSplitSize-1 == i%orgSplitSize){
					//원본 bkg에 Check가 되지 않은 경우
					if(selectCntrVO.get(deleteCntrSeq).getSplitNo().length()<1){
						if(deleteCntrFlag){
							selectCntrVO.get(deleteCntrSeq).setSplitNo("");
						} else {
							//이후 split bkg에 넘겨줘야하는 경우 강제로 남겨둠
							selectCntrVO.get(deleteCntrSeq).setSplitNo(sourceBkg.getBkgNo().substring(10, 12));
						}
					}
				}
			}

			// 이번 split에 관련된 container만 남기고 삭제
			List<SelectCntrVO> tempSelectCntrVO = new ArrayList<SelectCntrVO>();
			for(int i=0;i<selectCntrVO.size();i++){
				if(selectCntrVO.get(i).getBkg_no().equals(sourceBkg.getBkgNo())){
					tempSelectCntrVO.add(selectCntrVO.get(i));
				}
				if(selectCntrVO.get(i).getBkg_no().equals(currSplitBkg)){
					tempSelectCntrVO.add(selectCntrVO.get(i));
				}
			}
			
			selectCntrVO = tempSelectCntrVO;
			splitBkgVO.setSelectCntrVO(selectCntrVO);
									
			for(int i=0;i<selectQtyVO.size();i++){
				// 원본 bkg에 대해서 split되는 bkg의 quantityk만큼만 빠지도록 함
				// 화면에서 나눠져 있는 상태이므로 split되는 bkg 이후의 quantity를 다시 더해줌
				if(0==i%orgSplitSize){
					currSeq = 0;
					for(int j=i;j<i+orgSplitSize;j++){
						if(selectQtyVO.get(j).getSplitNo().equals(currSplitBkg.substring(10, 12))){
							currSeq = j;							
						}			
						if(currSeq > 0 && currSeq < j){
							selectQtyVO.get(i).setOpCntrQty(""+
									(Float.parseFloat(selectQtyVO.get(i).getOpCntrQty())
											+ Float.parseFloat(selectQtyVO.get(j).getOpCntrQty())
									));			
						}
					}
				}
			}
			
			// 이번 split에 관련된 Quantity만 남기고 삭제
			List<SplitQtyVO> tempSelectQtyVO = new ArrayList<SplitQtyVO>();
			for(int i=0;i<selectQtyVO.size();i++){
				if(selectQtyVO.get(i).getSplitNo().equals(selectQtyVO.get(0).getSplitNo())){
					tempSelectQtyVO.add(selectQtyVO.get(i));
				}
				if(selectQtyVO.get(i).getSplitNo().equals(currSplitBkg.substring(10, 12))){
					tempSelectQtyVO.add(selectQtyVO.get(i));
				}		
			}
			selectQtyVO = tempSelectQtyVO;
			splitBkgVO.setSplitQtyVO(selectQtyVO);
			
			String tempSpclCntrNo = "";
			Boolean deleteSpclCntrFlag = false;
			int deleteSpclCntrSeq = 0;
			for(int i=0;i<selectSpclCgoVO.size();i++){
				if(selectSpclCgoVO.get(i).getBkg_no().equals(sourceBkg.getBkgNo())){
					tempSpclCntrNo = selectSpclCgoVO.get(i).getCntrNo();
					deleteSpclCntrFlag = true;
					deleteSpclCntrSeq = i;
					currSeq = 0;
				}
				if(selectSpclCgoVO.get(i).getBkg_no().equals(currSplitBkg)){
					currSeq = i;
				}
				if(currSeq > 0 && currSeq < i){
					if(tempSpclCntrNo.equals(selectSpclCgoVO.get(i).getCntrNo())
							&& selectSpclCgoVO.get(i).getSplitNo().length() > 1){
						deleteSpclCntrFlag = false;
					}
				}
				if(orgSplitSize-1 == i%orgSplitSize){
					//원본 bkg에 Check가 되지 않은 경우
					if(selectSpclCgoVO.get(deleteSpclCntrSeq).getSplitNo().length()<1){
						if(deleteSpclCntrFlag){
							selectSpclCgoVO.get(deleteSpclCntrSeq).setSplitNo("");
						} else {
							//이후 split bkg에 넘겨줘야하는 경우 강제로 남겨둠
							selectSpclCgoVO.get(deleteSpclCntrSeq).setSplitNo(sourceBkg.getBkgNo().substring(10, 12));
						}
					}
				}
			}

			// 이번 split에 관련된 Special Cargo 남기고 삭제
			List<SelectSpclCgoVO> tempSelectSpclCgoVO = new ArrayList<SelectSpclCgoVO>();
			for(int i=0;i<selectSpclCgoVO.size();i++){
				if(selectSpclCgoVO.get(i).getBkg_no().equals(sourceBkg.getBkgNo())){
					tempSelectSpclCgoVO.add(selectSpclCgoVO.get(i));
				}
				if(selectSpclCgoVO.get(i).getBkg_no().equals(currSplitBkg)){
					tempSelectSpclCgoVO.add(selectSpclCgoVO.get(i));
				}				
			}
			selectSpclCgoVO = tempSelectSpclCgoVO;
			splitBkgVO.setSelectSpclCgoVO(selectSpclCgoVO);
			
			// prd 호출
			ArrayList<String> cntrNoList  = null;
			String [][] 	  pctlMapSeq  = new String[event.getTargetBkg().length][2];	
			
			// prd에 넘겨줄 bkg list
			ArrayList<String> bkgNoList = new ArrayList<String>();
			for (int i=0;i<event.getTargetBkg().length;i++){
				bkgNoList.add(event.getTargetBkg()[i].getBkgNo());				
				// for history
				if(i==0){
					splitToBkgNoStr = event.getTargetBkg()[i].getBkgNo();
				} else {
//					splitToBkgNoStr = splitToBkgNoStr + ", " + event.getTargetBkg()[i].getBkgNo();
					StringBuffer tmpBuffer = new StringBuffer(splitToBkgNoStr).append(", ").append(event.getTargetBkg()[i].getBkgNo());
					splitToBkgNoStr = tmpBuffer.toString();
					if(i%3==0){
//						splitToBkgNoStr = splitToBkgNoStr + "\n";
						StringBuffer tmpBuffer2 = new StringBuffer(splitToBkgNoStr).append("\n");
						splitToBkgNoStr = tmpBuffer2.toString();
					}
				}
			}
			
			begin();
			
//			//같은 office인지 확인  -> 제외 (20100406 임종한 과장님 요청)
//			if(!"Y".equals(bdrFlag)){
//				util.searchOfcVsBkgOfc(sourceBkg, account);
//			}			
			
			// split bkg 별로 prd에 call
			for (int i=0;i<event.getTargetBkg().length;i++){
				//memo split일 경우 P/C 추가 call
				if(0==i && splitRsnCd.equals("M")){
	                PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO(); 
	                prdMainInfoVO.setPcMode("S");
	                prdMainInfoVO.setFCmd("3");
	                prdMainInfoVO.setBkgNo(sourceBkg.getBkgNo());
	                prdMainInfoVO.setParentBkgNo(sourceBkg.getBkgNo());
	                prdMainInfoVO.setBkgOfc(account.getOfc_cd());
	                
	                PrdParameterVO prdParameterVO = new PrdParameterVO();
	                prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
	                
	                //for qty
	                ArrayList<PrdQtyInfoVO> prdQtyList = new ArrayList<PrdQtyInfoVO>();
	                PrdQtyInfoVO[] 			prdQtyInfos = receiptBC.searchBkgQtyForRailTime(sourceBkg);
	                PrdQtyInfoVO 			prdQtyInfo = null;
	                for(int icnt=0;icnt<prdQtyInfos.length; icnt++) {
                		prdQtyInfo = new PrdQtyInfoVO();
                		prdQtyInfo.setCQty (prdQtyInfos[icnt].getCQty());
                		prdQtyInfo.setCTpsz(prdQtyInfos[icnt].getCTpsz());
                		prdQtyList.add(prdQtyInfo); 
	                }
	                
	                prdParameterVO.setPrdQtyInfo(prdQtyList);

	                //for cntr
	                cntrNoList = new ArrayList<String>();
	                String [] cntrNos = util.searchCntrListByBkg(sourceBkg);
	                for(int icnt=0;icnt<cntrNos.length; icnt++) {
	                    cntrNoList.add(cntrNos[icnt]);
	                }
	                String pctlNoMapSeqStr = prdBC.createPrdCtlgRoutSplit(prdParameterVO, account, cntrNoList, i, bkgNoList);
	                String [] memoPctlMapSeq = util.splitByToken(pctlNoMapSeqStr, "|"); 
	            	sourceBkg.setPctlNo(memoPctlMapSeq[0]); 
	            	sourceBkg.setMapSeq(memoPctlMapSeq[1]);
				}
				
				BkgBlNoVO targetBkg = event.getTargetBkg()[i];
				log.debug("\nprocessing bkg no:"+targetBkg.getBkgNo());
                
                PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO(); 
                prdMainInfoVO.setPcMode("S");
                prdMainInfoVO.setFCmd("3");
                prdMainInfoVO.setBkgNo(targetBkg.getBkgNo());
                prdMainInfoVO.setParentBkgNo(sourceBkg.getBkgNo());
                prdMainInfoVO.setBkgOfc(account.getOfc_cd());
                
                PrdParameterVO prdParameterVO = new PrdParameterVO();
                prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
                
                //for qty
                ArrayList<PrdQtyInfoVO> prdQtyList = new ArrayList<PrdQtyInfoVO>();
                PrdQtyInfoVO 			prdQtyInfo = null;                       

                for(int icnt=0;icnt<selectQtyVO.size(); icnt++) {
                	int targetBkgSeq = icnt%splitBlInfoVOList.size();
                	selectQtyVO.get(icnt).setSplitNo(splitBlInfoVOList.get(targetBkgSeq).getBkgNo());
                	double iQty =(selectQtyVO.get(icnt).getOpCntrQty()==null)? 0:Double.parseDouble(selectQtyVO.get(icnt).getOpCntrQty());

                	if (targetBkg.getBkgNo().equals(splitBlInfoVOList.get(targetBkgSeq).getBkgNo())
       					&& iQty>0.0){
                		prdQtyInfo = new PrdQtyInfoVO();
                		prdQtyInfo.setCQty (selectQtyVO.get(icnt).getOpCntrQty());
                		prdQtyInfo.setCTpsz(selectQtyVO.get(icnt).getCntrTpszCd());
                		prdQtyList.add(prdQtyInfo); 
                	}
                }
                prdParameterVO.setPrdQtyInfo(prdQtyList);

                //for cntr
                cntrNoList = new ArrayList<String>();
                cntrHistStr[i] = "";
                for(int icnt=0;icnt<selectCntrVO.size(); icnt++) {
                    if (selectCntrVO.get(icnt).getBkg_no().equals(targetBkg.getBkgNo())
                        && selectCntrVO.get(icnt).getSplitNo().length()>1){
                    	cntrNoList.add(selectCntrVO.get(icnt).getCntr_no());
                    	//for history
                    	if(cntrNoList.size() == 1){
                    		cntrHistStr[i] = selectCntrVO.get(icnt).getCntr_no();
                    	} else {
                    		if(cntrNoList.size()%3==1){
//                    			cntrHistStr[i] = cntrHistStr[i] + ",\n" + selectCntrVO.get(icnt).getCntr_no();
                    			StringBuffer tmpBuffer = new StringBuffer(cntrHistStr[i]).append(",\n").append(selectCntrVO.get(icnt).getCntr_no());
                    			cntrHistStr[i] = tmpBuffer.toString();
                    		} else {
//                    			cntrHistStr[i] = cntrHistStr[i] + ", " + selectCntrVO.get(icnt).getCntr_no();
                    			StringBuffer tmpBuffer = new StringBuffer(cntrHistStr[i]).append(", ").append(selectCntrVO.get(icnt).getCntr_no());
                    			cntrHistStr[i] = tmpBuffer.toString();
                    		}
                    	}
                    }
                }
                String pctlNoMapSeqStr = prdBC.createPrdCtlgRoutSplit(prdParameterVO, account, cntrNoList, i, bkgNoList);
            	pctlMapSeq[i] = util.splitByToken(pctlNoMapSeqStr, "|");
			}// prd 호출 끝			
			commit();
			   
			// for quantity history
			List<BkgQuantityVO> oldBkgQtys = receiptBC.searchBkgQuantity(sourceBkg);
			String oldMtyPkupYdCd = ((OldBkgInfoVO)receiptBC.searchOldBkgInfo(sourceBkg)).getMtyPkupYdCd();
			
			//for cntr history
			if(selectCntrVO.size()>0){
				String [] cntrList = util.searchCntrListByBkg(sourceBkg);
				for(int i=0;i<cntrList.length;i++){
                	if(i == 0){
                		preCntrHistStr = cntrList[i];
                	} else {
                		if((i+1)%3==1){
//                			preCntrHistStr = preCntrHistStr + ",\n" + cntrList[i];
                			StringBuffer tmpBuffer = new StringBuffer(preCntrHistStr).append(",\n").append(cntrList[i]);
                			preCntrHistStr = tmpBuffer.toString();
                		} else {
//                			preCntrHistStr = preCntrHistStr + ", " + cntrList[i];
                			StringBuffer tmpBuffer = new StringBuffer(preCntrHistStr).append(", ").append(cntrList[i]);
                			preCntrHistStr = tmpBuffer.toString();
                		}
                	}
				}				
			}
			
			if (command.validateSplit(event.getSplitBkgVO(), sourceBkg).equals("Y")){
				begin();
				if(bdrFlag.equals("Y")){
					// add1stCaHist : sourcebkg의 최초 c/a hist을 넣는다(corr_no : 0000000001)
					add1stCaHist(event.getSourceBkg());
				}

				// Copy여부에 따라 Information Alert을 표시할지를 판단하기 위한 Flag를 셋팅.
				String splitFlg = receiptBC.copyBookingForSplit   (sourceBkg, event.getTargetBkg(), splitBkgVO,   account);
				eventResponse.setETCData("split_flag", splitFlg);

				blDocBlBC.copyBlDocByBkg		(sourceBkg, event.getTargetBkg(), splitBkgVO, account );
				if(selectCntrVO.size()>0){
//					blDocCmBC.copyCntrCmByBkg   (sourceBkg, event.getTargetBkg(), selectCntrVO, bkgCopyCntrCmByBkgVO ,account);
					blDocCmBC.copyCntrCmByBkgMulti(sourceBkg, event.getTargetBkg(), orgSelectCntrVO, selectCntrVO, account);
				}
				blDocBlBC.copyHblByBkg      ("S", sourceBkg, event.getTargetBkg(), selectCntrVO, account);
				if(selectSpclCgoVO.size()>0){
					spclCgoBC.copySpclCgoByBkg  ("S", sourceBkg, event.getTargetBkg(), selectSpclCgoVO, account);
				}
				blRatingBC.copyManualChgByBkg   (sourceBkg, event.getTargetBkg(), account, splitRsnCd);
//				if(selectTroVO.size()>0){
//					if("EUR".equals(event.getTroTp())){
//						troBC.unconfirmEurTro(sourceBkg, "O", account);
//					} else {
//						troBC.unconfirmTro(sourceBkg, account);
//					}
//					copBC.unconfirmTro(sourceBkg.getBkgNo(), "O");
//					troBC.copyTroByBkg("S", sourceBkg, event.getTargetBkg(),selectTroVO, event.getTroTp(),  account);
//				} 
				//임시 주석 처리
				if(selectSpclCgoVO.size()>0){
					//bkg의 spcl flag 재 계산
					receiptBC.modifySpclFlag(event.getTargetBkg(), account);
					if(selectCntrVO.size()>0){
						//container의 spcl flag 재계산
						blDocCmBC.modifyCntrSpclFlag(event.getTargetBkg(), account);
					}
				}
				
				//cop에 1차로 split을 반영
				String [] targetBkgNoList = new String[event.getTargetBkg().length + (splitRsnCd.equals("M")?1:0)];
				String [] copMapSeq       = new String[event.getTargetBkg().length + (splitRsnCd.equals("M")?1:0)];
				for(int i=0;i<event.getTargetBkg().length;i++){
					targetBkgNoList[i] = event.getTargetBkg()[i].getBkgNo();	
					copMapSeq[i]       = pctlMapSeq[i][1]; 
				}				
				if(splitRsnCd.equals("M")){
					targetBkgNoList[targetBkgNoList.length-1] = sourceBkg.getBkgNo();	
					copMapSeq      [targetBkgNoList.length-1] = sourceBkg.getMapSeq(); 
				}
				//copBC.splitBkg(sourceBkg.getBkgNo(), targetBkgNoList, copMapSeq);
				callCopSplitBkg(sourceBkg.getBkgNo(), targetBkgNoList, copMapSeq);
				
				// S 2010.08.31 KMJ TRO Split 추가
				// 81. copyTroBySplit
				troBC.copyTroBySplit(sourceBkg.getBkgNo(), targetBkgNoList, account);
				// 82. cancelTroBySplit
				troBC.cancelTroBySplit(sourceBkg.getBkgNo(), targetBkgNoList, account);
				// 2010.08.31 KMJ TRO Split 추가
				
				// 20140306 SI History 추가
				String sourceSiFlg = receiptBC.searchSiFlg(sourceBkg);
				
				for (int i=0;i<event.getTargetBkg().length;i++){
					BkgBlNoVO targetBkg = event.getTargetBkg()[i];
					
					//for performance report
					reportBC.manageQtyCntrCoposite(targetBkg.getBkgNo(), "CQ");	
					reportBC.manageQtyCntrCoposite(targetBkg.getBkgNo(), "CN");			
				
					// bdr 이전이면 해당 Booking의 status를 재계산한다.
					if(bdrFlag.equals("Y")){
						// bdr 이후일 경우 
						bkgCorrectionVO.setBkgNo(targetBkg.getBkgNo());
						//split new Bkg에 대해 BDR이후일 경우 first c/a(dummy)
						if (!event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
							add1stCaHist(targetBkg);
						}
					}
					
					//vvd가 변경되었을 경우
					log.debug("\nbkg:"+targetBkg.getBkgNo()+",tVvd:"+splitBlInfoVOList.get(i).getTvvd()
							+ "\nroute String:"+splitBlInfoVOList.get(i).getRtnRoute());	
					if(splitBlInfoVOList.get(i).getRtnRoute()!=null 
						&& splitBlInfoVOList.get(i).getRtnRoute().length()>10
						&& !orgTvvd.equals(splitBlInfoVOList.get(i).getTvvd())){
						
						//PrdMainInfoVO Set
						PrdMainInfoVO prdMainInfoVO  = new PrdMainInfoVO();
						prdMainInfoVO.setFCmd("3");
						prdMainInfoVO.setPcMode("R");
						prdMainInfoVO.setTVvd (splitBlInfoVOList.get(i).getTvvd());
						prdMainInfoVO.setBkgNo(targetBkg.getBkgNo());
						
						PrdParameterVO prdParameterVO = new PrdParameterVO();
						prdParameterVO.setBkgBlNoVO(targetBkg);
						prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
						prdParameterVO=util.searchPrdParmForFullRoute (prdParameterVO);
						
						PrdMainInfoVO rtnPrdMainInfoVO = prdParameterVO.getPrdMainInfoVO();
						util.resetNthRoute(rtnPrdMainInfoVO, 1);
						util.resetNthRoute(rtnPrdMainInfoVO, 2);
						util.resetNthRoute(rtnPrdMainInfoVO, 3);
						util.resetNthRoute(rtnPrdMainInfoVO, 4);
						rtnPrdMainInfoVO.setOrgTrnsMode("");
						rtnPrdMainInfoVO.setDestTrnsMode("");
						
						String rtnRoute = splitBlInfoVOList.get(i).getRtnRoute();
						String [] rtnRouteVvds = util.splitByToken(rtnRoute, ",");
						for(int j=0;j<rtnRouteVvds.length;j++){
							if(rtnRouteVvds[j].length()==0) break;
							String [] rtnRouteInfo = util.splitByToken(rtnRouteVvds[j], "|");
							log.debug("\npol:"+rtnRouteInfo[0]+"/polYd:"+rtnRouteInfo[1]+"/pol_clpt:"+rtnRouteInfo[6]+
									   "/pod:"+rtnRouteInfo[2]+"/podYd:"+rtnRouteInfo[3]+"/pod_clpt:"+rtnRouteInfo[7] +
									   "/vvd:"+rtnRouteInfo[4]+"/lane:"+rtnRouteInfo[5]);
							if(j==0){
								rtnPrdMainInfoVO.setPol1 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol1N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol1C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod1 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod1N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod1C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd1 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane1(rtnRouteInfo[5]);
							} else if(j==1){
								rtnPrdMainInfoVO.setPol2 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol2N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol2C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod2 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod2N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod2C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd2 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane2(rtnRouteInfo[5]);
							} else if(j==2){
								rtnPrdMainInfoVO.setPol3 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol3N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol3C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod3 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod3N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod3C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd3 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane3(rtnRouteInfo[5]);
							} else if(j==3){
								rtnPrdMainInfoVO.setPol4 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol4N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol4C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod4 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod4N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod4C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd4 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane4(rtnRouteInfo[5]);
							}
						}
						
						prdParameterVO.setPrdMainInfoVO(rtnPrdMainInfoVO);
//						util.prdParameterLog(prdParameterVO.getPrdMainInfoVO());

						// 12. createProdCtlRoute
						String pctlNoMapSeqStr = prdBC.createPrdCtlgRout(prdParameterVO, account);
						String [] pctlNoMapSeq = util.splitByToken(pctlNoMapSeqStr, "|");
						
						targetBkg.setPctlNo(pctlNoMapSeq[0]);
						targetBkg.setMapSeq(pctlNoMapSeq[1]);						

						//	vvd변경에 대한 old vvd조회(org bkg에 대해서만 vvd 변경 이력을 남긴다)
						histTableVO = new HistoryTableVO();
						if(targetBkg.getBkgNo().equals(sourceBkg.getBkgNo())){
							histTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0099", targetBkg);
						}
						
						// 실제 vvd 변경
						VvdAssignVO vvdAssignVO = new VvdAssignVO();
						vvdAssignVO.setBkgBlNoVO(targetBkg);
//						BdrSpclVO bdrSpclVO = receiptBC.modifyOceanRoute(vvdAssignVO, account);
						receiptBC.modifyOceanRoute(vvdAssignVO, account);
						
						//cop에 2차로 replan 반영
						//copBC.updateBkg(targetBkg.getBkgNo(), targetBkg.getMapSeq());
						callCopUpdateBkg(targetBkg.getBkgNo(), targetBkg.getMapSeq());
					}//vvd가 변경되었을 경우 끝
					
					if(selectSpclCgoVO.size()>0){
						reRequestSpclCgoApproval(targetBkg, "SPLIT", null);
					}
					
					// bdr 이전이면 해당 Booking의 status를 재계산한다.
					if(bdrFlag.equals("N")){
						receiptBC.changeBkgStatus("Y",targetBkg, false, account);
					}
					
					// auto c/a 처리
					if(bdrFlag.equals("Y")){						
						// vvd 변경됐을 경우
						if(splitBlInfoVOList.get(i).getRtnRoute()!=null){
							bkgCorrectionVO.setRoutCorrFlg("Y");
							bkgCorrectionVO.setTrnkVslCorrFlg("Y");
						}
						bkgCorrectionVO.setCaRsnCd(event.getCaRsnCd());
						bkgCorrectionVO.setBkgCorrRmk(event.getCaRemark());
						
						if (event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
							bdrBC.addAutoCaTemp(sourceBkg, "SPLIT_MASTER", bkgCorrectionVO, account);

							if(currSplitBkgSeq > 1){
								//이전 bkg에서 했던 C/A History를 지운다
								BkgBlNoVO splitSourceBkg = bdrBC.searchLstCorrNo(sourceBkg);
								lstCorrNo = splitSourceBkg.getCaNo();
								
								String copyTypeCd = "SPLIT_MASTER";
								spclCgoBC.removeCA(splitSourceBkg, copyTypeCd);
								blRatingBC.removeCA(splitSourceBkg, copyTypeCd);
								blDocBlBC.removeCA(splitSourceBkg, copyTypeCd);
								receiptBC.removeCA(splitSourceBkg, copyTypeCd);
								blIssBC.removeCA(splitSourceBkg, copyTypeCd);
								historyBC.removeCA(splitSourceBkg, copyTypeCd);
							}
						} else {
							bdrBC.addAutoCaTemp(targetBkg, "SPLIT_NEW", bkgCorrectionVO, account);				
						}						
						BkgBlNoVO corrBkgBlNoVO = addCaHistory(event.getCaRsnCd(), event.getCaRemark(), targetBkg, "N", "Y");
						targetBkg.setCaNo(corrBkgBlNoVO.getCaNo());
						event.getTargetBkg()[i].setCaNo(corrBkgBlNoVO.getCaNo());
						if(event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
							sourceBkg.setCaNo(corrBkgBlNoVO.getCaNo());
						}
						bdrBC.removeCATemp(corrBkgBlNoVO);
						if(currSplitBkgSeq > 1){
							BkgBlNoVO splitSourceBkg = sourceBkg;
							splitSourceBkg.setCaNo(lstCorrNo);
							bdrBC.removeCA(splitSourceBkg);
						}
						blRatingBC.distributeCntrRate(targetBkg.getBkgNo(), account);
						
			            //추가2. 
						OblIssVO oblIssVO = util.searchOblIssue(targetBkg); 
						
						//추가2. 
						RevDrNoteVO        revDrNoteVO    = new RevDrNoteVO(); 
						CstmBkgRevDrNoteVO bkgRevDrNoteVO = new CstmBkgRevDrNoteVO();
						bkgRevDrNoteVO.setBkgNo      (targetBkg.getBkgNo());  
						bkgRevDrNoteVO.setBkgCorrNo  (targetBkg.getCaNo()); 
						bkgRevDrNoteVO.setRdnNo      (oblIssVO.getRdnNo()); 
						bkgRevDrNoteVO.setRvisSeq    (oblIssVO.getRvisSeq()); 
						bkgRevDrNoteVO.setReceiverRmk("");
						revDrNoteVO.setBkgRevDrNoteVO(bkgRevDrNoteVO);

						RevenueDebitNoteBC revenueDebitNoteBC = new RevenueDebitNoteBCImpl();
						revenueDebitNoteBC.acceptRDNbyReceiptOffice(revDrNoteVO, account);  
						
						//추가2. 
						OblRdemVO oblRdem = new OblRdemVO();
						oblRdem.setBlNo      (oblIssVO.getBlNo());  
						oblRdem.setCgorTeamCd("C");
						oblRdem.setCgoEvntNm ("B/L Correct");
						oblRdem.setEvntDt    (new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
						oblRdem.setEvntOfcCd (account.getOfc_cd());
						oblRdem.setEvntUsrId (account.getUsr_id());
						oblRdem.setOblRdemFlg(oblIssVO.getOblRlseFlg()); 

						CargoReleaseOrderBC cargoReleaseOrderBC = new CargoReleaseOrderBCImpl();
						try{
							cargoReleaseOrderBC.setupFocByObl(oblRdem);
						} catch(Exception crEx){
							log.error("err " + crEx.toString(), crEx);
						}	
					} else {
						targetBkg.setCaNo("");
					}// auto c/a 처리 끝

					// history 처리
					HistoryLineVO historyLineVO = new HistoryLineVO();
					
					historyLineVO.setBkgNo (targetBkg.getBkgNo());
					historyLineVO.setCorrNo(targetBkg.getCaNo());
					historyLineVO.setUiId("ESM_BKG_0099");
					if (event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
						historyLineVO.setCrntCtnt("Split into :"+splitToBkgNoStr);		
						historyLineVO.setBkgDocProcTpCd("BKGSPT");			
						if(currSplitBkgSeq > 1){	
							historyBC.modifyCorrNo(targetBkg, lstCorrNo);
						}
					} else {
						historyLineVO.setCrntCtnt("Split from BKG No :"+sourceBkg.getBkgNo()); //new -> Splited from BKG No : %, old -> Splited.			
						historyLineVO.setBkgDocProcTpCd("SPTCRE");
					}
					historyLineVO.setHisCateNm("SPLIT");		
					historyBC.createBkgHistoryLine (historyLineVO,account);
					
					//	vvd변경에 대한 history
					if(targetBkg.getBkgNo().equals(sourceBkg.getBkgNo())){
						if(splitBlInfoVOList.get(i).getRtnRoute()!=null 
								&& splitBlInfoVOList.get(i).getRtnRoute().length()>10
								&& !orgTvvd.equals(splitBlInfoVOList.get(i).getTvvd())){
							histTableVO.getBkgBlNoVO().setCaNo(targetBkg.getCaNo());
							historyBC.manageBookingHistory("ESM_BKG_0099", histTableVO, account);
						}
					}
					if(cntrHistStr[i].length()>0){
						//	cntr에 대한 histiry
						historyLineVO.setCrntCtnt(cntrHistStr[i]); 
						if(targetBkg.getBkgNo().equals(sourceBkg.getBkgNo())){
							historyLineVO.setPreCtnt(preCntrHistStr);
						} 
						historyLineVO.setHisCateNm("Container No.");						
						historyBC.createBkgHistoryLine (historyLineVO,account);					
						historyBC.releaseCntrFinalConfirm(targetBkg, account);
						// history 처리 끝
					}
					
					// 20140306 SI History 추가 mds 
					if(!targetBkg.getBkgNo().equals(sourceBkg.getBkgNo())){
						if(sourceSiFlg!=null && "Y".equals(sourceSiFlg)){
							HistoryLineVO historyLineVO2 = new HistoryLineVO();
							historyLineVO2.setUiId("ESM_BKG_0099");			
							historyLineVO2.setHisCateNm("S/I");
							historyLineVO2.setBkgNo(targetBkg.getBkgNo());
							historyLineVO2.setCaFlg(targetBkg.getCaFlg());
							historyLineVO2.setCrntCtnt("S/I Check"); // 변경시 HardCoding 검토 필요함				
							historyBC.createBkgHistoryLine(historyLineVO2, account);
						}
					}
					
					// Allocation Status 
					AllocStsChgVO allocStsChgVO = receiptBC.manageAlocStatus(targetBkg, account, "");
					List<BkgNtcHisVO> bkgNtcHisVOs = allocStsChgVO.getBkgNtcHisVOs();
					if (null!=bkgNtcHisVOs) {
						historyBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0099");
					}
					// Allocation Status History 
					if(allocStsChgVO != null){
						HistoryLineVO historyLineVO2 = new HistoryLineVO();
						historyLineVO2.setUiId("ESM_BKG_0099");			
						historyLineVO2.setHisCateNm("Booking Status");
						historyLineVO2.setBkgNo(targetBkg.getBkgNo());
						historyLineVO2.setCaFlg("N");
						if (allocStsChgVO == null || allocStsChgVO.getAlocStsCd() == null){
							log.debug("Null Check");
						} else if ((allocStsChgVO.getOriAlocStsCd() == null || "".equals(allocStsChgVO.getOriAlocStsCd())) && "S".equals(allocStsChgVO.getAlocStsCd())){
							historyLineVO2.setCrntCtnt("Allocation Status change to S");
							historyBC.createBkgHistoryLine(historyLineVO2, account);
						} else if ((allocStsChgVO.getOriAlocStsCd() == null || "".equals(allocStsChgVO.getOriAlocStsCd())) && "F".equals(allocStsChgVO.getAlocStsCd())){
							historyLineVO2.setCrntCtnt("Allocation Status change to F");
							historyBC.createBkgHistoryLine(historyLineVO2, account);	
						} else if ( "F".equals(allocStsChgVO.getOriAlocStsCd()) && "S".equals(allocStsChgVO.getAlocStsCd()) ){
							historyLineVO2.setCrntCtnt("Allocation Status change F to S");
							historyBC.createBkgHistoryLine(historyLineVO2, account);
						} else if ( "S".equals(allocStsChgVO.getOriAlocStsCd()) && "F".equals(allocStsChgVO.getAlocStsCd()) ){
							historyLineVO2.setCrntCtnt("Allocation Status change S to F");
							historyBC.createBkgHistoryLine(historyLineVO2, account);
						}
					}
					// Allocation Status History 끝
				}

				//memo split일 경우 master bkg의 history
				if (splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason().equals("M")){
					interfaceToMas(sourceBkg, "Booking Split", account);	
					
					HistoryLineVO historyLineVO = new HistoryLineVO();
				
					historyLineVO.setBkgNo (sourceBkg.getBkgNo());
					historyLineVO.setCorrNo(sourceBkg.getCaNo());
					historyLineVO.setUiId("ESM_BKG_0099");
					historyLineVO.setCrntCtnt("Memo Split into :"+splitToBkgNoStr);		
					historyLineVO.setBkgDocProcTpCd("BKGSPT");
					historyLineVO.setHisCateNm("SPLIT");		
					if(currSplitBkgSeq > 1){	
						historyBC.modifyCorrNo(sourceBkg, lstCorrNo);
					}
					historyBC.createBkgHistoryLine (historyLineVO,account);
				}
			
				//interface inv, coa
				for (int i=0;i<event.getTargetBkg().length;i++){	
					BkgBlNoVO targetBkg = event.getTargetBkg()[i]; 	

					// 87: interfaceCoa
					interfaceToMas(targetBkg, "Booking Split", account);	
					
					//org bkg
					if (event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
						// memo split master에는 하지 않음
						if (splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason().equals("C")){
							
							// CNHKG만 제외
							if(!splitBkgVO.getCopySplitBkgEtcVO().get(0).getPolCd().equals("CNHKG")){

								String bracCd = "U";
								if(splitBlInfoVOList.get(i).getRtnRoute()!=null 
										&& splitBlInfoVOList.get(i).getRtnRoute().length()>10
										&& !orgTvvd.equals(splitBlInfoVOList.get(i).getTvvd())){
									bracCd = "B";
								}
								// 20091127 BackEndJob으로 변경
								// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
								Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
								vender301ParamVO.setBkgBlNoVO(targetBkg);
								vender301ParamVO.setOldVvdVOs(null);
								vender301ParamVO.setOldQtyVOs(oldBkgQtys);
								vender301ParamVO.setOldMtyPkupYdCd(oldMtyPkupYdCd);
								vender301ParamVO.setBracCd(bracCd);
								vender301ParamVO.setEdiKind("BT");
								vender301ParamVO.setAutoManualFlg("Y");
								
								searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);
								searchBC.createCustBkgReceiptEdiBackEnd(targetBkg, null, "Y", account);
							}						
						}					
					} else {							
						// CNHKG만 제외
						if(!splitBkgVO.getCopySplitBkgEtcVO().get(0).getPolCd().equals("CNHKG")){							
							// 20091127 BackEndJob으로 변경
							// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
							Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
							vender301ParamVO.setBkgBlNoVO(targetBkg);
							vender301ParamVO.setOldVvdVOs(null);
							vender301ParamVO.setOldQtyVOs(new ArrayList<BkgQuantityVO>());
							vender301ParamVO.setOldMtyPkupYdCd(oldMtyPkupYdCd);
							vender301ParamVO.setBracCd("N");
							vender301ParamVO.setEdiKind("BT");
							vender301ParamVO.setAutoManualFlg("Y");
							
							searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);
							searchBC.createCustBkgReceiptEdiBackEnd(targetBkg, null, "Y", account);
						}
					}
				}
				commit();

				/*
				   3.1 해당 Key BKG_XTER_RQST_MST에 
				         3.1.1 BKG_NO - split 된 BKG_NO 로 업데이트
				         3.1.2 SPLIT_STS_CD = 'F' 로 업데이트
				   3.2 Booking EDI 접수때와 마찬가지로 addBkgSrRequest 호출해주세요.
			        EBookingConductSC.java 의 receiptXterRqst 참고하시면 됩니다.
			    */
				if (null!=splitBlInfoVOList && 0<splitBlInfoVOList.size()) {
					begin();
					for (SplitBlInfoVO vo : splitBlInfoVOList) {
						if (!"".equals(vo.getXterSndrId()) && !"".equals(vo.getXterRqstNo()) && !"".equals(vo.getXterRqstSeq())) {
							vo.setOldBkgNo(splitBkgVO.getCopySplitBkgEtcVO().get(0).getOldBkgNo());
							ebookingBC.modifyXterBkgNoBySplit(vo, account);
							DpcsWebBookingVO dpcsWebBookingVO = new DpcsWebBookingVO();
							dpcsWebBookingVO.setXterSndrId(vo.getXterSndrId());
							dpcsWebBookingVO.setXterRqstNo(vo.getXterRqstNo());
							dpcsWebBookingVO.setXterRqstSeq(vo.getXterRqstSeq());
							reportBC.addBkgSrRequest(dpcsWebBookingVO);	
						}
					}
					commit();
				}

				begin();
				for (int i=0;i<event.getTargetBkg().length;i++){
					// invoice interface
					interfaceToInv(event.getTargetBkg()[i], account);
				}				
				commit();
				
				try{		
					for (int i=0;i<event.getTargetBkg().length;i++){	
						BkgBlNoVO targetBkg = event.getTargetBkg()[i]; 
						// cut off time (cop 생성 이후에 처리)
						String fromDt = null;
						String toDt = null;
						if("US".equals(polCd.substring(0,2)) || "CA".equals(polCd.substring(0,2))){	
							
							if(bdrFlag.equals("N")){
								PrdQtyInfoVO[] prdQtyInfo 	= receiptBC.searchBkgQtyForRailTime(targetBkg);
														
								Map railTime = prdBC.getRailRecevingTime(targetBkg.getPctlNo(), prdQtyInfo, null, null, targetBkg.getBkgNo());
	
								fromDt= (String)railTime.get("RTN_TIME");
								toDt  = (String)railTime.get("CUT_OFF");
							}
							
						}
						begin(); //batch 서버 접속해야되서 Transaction을 분리함
						receiptBC.createCargoClosingTime(targetBkg, fromDt, toDt, account);
						commit();
					} 
				} catch (Exception prdEx){
					rollback();
					log.error("err " + prdEx.toString(), prdEx);					
				}
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());	
			}else{
				eventResponse.setUserMessage(new ErrorHandler("BKG00167").getUserMessage());
			}
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		
	}
	
	/**
	 * ESM_BKG_0997 : open <br>
	 * cod관련 Split <br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCodSplit(Event e) throws EventException{
		try{
			EsmBkg0997Event event = (EsmBkg0997Event)e;
			GeneralBookingSplitCombineBC command = new GeneralBookingSplitCombineBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CodSplitVO codSplit = command.searchCodSplit(event.getBkgBlNoVO(), event.getCodRqstSeq(), account);
			event.getBkgBlNoVO().setPctlNo(codSplit.getBkgBlForSplitVO().get(0).getPctlNo());
			String codRoute = command.searchNewTsRoute(event.getBkgBlNoVO()); 
			
			eventResponse.setETCData("bkg_no",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getBkgNo():"");
			eventResponse.setETCData("bl_no",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getBlNo():"");
			eventResponse.setETCData("tvvd",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getTvvd():"");
			eventResponse.setETCData("por_cd",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getPorCd():"");
			eventResponse.setETCData("pol_cd",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getPolCd():"");
			eventResponse.setETCData("pod_cd",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getPodCd():"");
			eventResponse.setETCData("del_cd",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getDelCd():"");
			eventResponse.setETCData("stwg_cd",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getStwgCd():"");
			eventResponse.setETCData("rail_blk_cd",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getRailBlkCd():"");
			eventResponse.setETCData("fd_grd_flg",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getFdGrdFlg():"");
			eventResponse.setETCData("hngr_flg",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getHngrFlg():"");
			eventResponse.setETCData("prct_flg",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getPrctFlg():"");
			eventResponse.setETCData("stop_off_loc_cd",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getStopOffLocCd():"");
			eventResponse.setETCData("spcl_hide_flg",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getSpclHideFlg():"");
			eventResponse.setETCData("remark",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getRemark():"");
			eventResponse.setETCData("dg",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getDg():"");
			eventResponse.setETCData("rf",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getRf():"");
			eventResponse.setETCData("ak",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getAk():"");
			eventResponse.setETCData("bb",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getBb():"");
			eventResponse.setETCData("pctl_no",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getPctlNo():"");
			eventResponse.setETCData("bdr_flag",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getBdrFlg():"");
			eventResponse.setETCData("tro_flg",(codSplit.getBkgBlForSplitVO().size()>0)? codSplit.getBkgBlForSplitVO().get(0).getTroFlg():"");
			eventResponse.setETCData("splitFlg",(codSplit.getBkgBlForSplitVO().size()>0)? JSPUtil.getNull(codSplit.getBkgBlForSplitVO().get(0).getSplitFlg()):"");
			eventResponse.setETCData("bkgStsCd",(codSplit.getBkgBlForSplitVO().size()>0)? JSPUtil.getNull(codSplit.getBkgBlForSplitVO().get(0).getBkgStsCd()):"");
			
			eventResponse.setETCData("custSplitNo",(codSplit.getLastSplitNoVO().size()>0)? codSplit.getLastSplitNoVO().get(0).getCustsplitno():"");
			eventResponse.setETCData("memoSplitNo",(codSplit.getLastSplitNoVO().size()>0)? codSplit.getLastSplitNoVO().get(0).getMemosplitno():"");
			eventResponse.setETCData("bkgsplitno",(codSplit.getLastSplitNoVO().size()>0)? JSPUtil.getNull(codSplit.getLastSplitNoVO().get(0).getBkgsplitno()):"");
			eventResponse.setETCData("rtn_route", codRoute);
			
			eventResponse.setRsVoList(codSplit.getBkgBlForSplitVO());
			eventResponse.setRsVoList(codSplit.getBkgQuantityVO());
			eventResponse.setRsVoList(codSplit.getCntrSpclTroSelectVO());
			eventResponse.setRsVoList(codSplit.getSpclSeqForSplitVO());
			eventResponse.setRsVoList(event.getBkgCodVvdVO()); 
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
		
	
	/**
	 *  ESM_BKG_0997 : ok click <br>
	 *  Cod에서 Booking Split 처리<br>
	 *  
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse splitCodBooking(Event e) throws EventException{
		try{
			EsmBkg0997Event 				event		    = (EsmBkg0997Event)e;
			GeneralEventResponse 			eventResponse 	= new GeneralEventResponse();			
			GeneralBookingSplitCombineBC 	command 		= new GeneralBookingSplitCombineBCImpl();
			GeneralBookingSearchBC  searchBC 	= new GeneralBookingSearchBCImpl();
			
			//Bkg data 반영
			GeneralBookingReceiptBC receiptBC   = new GeneralBookingReceiptBCImpl();
			BLDocumentationBLBC 	blDocBlBC 	= new BLDocumentationBLBCImpl();
			BLDocumentationCMBC 	blDocCmBC 	= new BLDocumentationCMBCImpl();
			BookingHistoryMgtBC 	historyBC 	= new BookingHistoryMgtBCImpl();
			BlRatingBC 				blRatingBC 	= new BlRatingBCImpl();
			BDRCorrectionBC         bdrBC       = new BDRCorrectionBCImpl();
			CODCorrectionBC         codBC       = new CODCorrectionBCImpl();
			PerformanceReportBC 	reportBC 	= new PerformanceReportBCImpl();
			BookingUtil             util        = new BookingUtil();
			
			// 타모듈 연동s
			//BkgCopManageBC 			copBC 		= new BkgCopManageBCImpl();
        	ProductCatalogCreateBC 	prdBC 		= new ProductCatalogCreateBCImpl();
			
			//orgin bkg
			BkgBlNoVO sourceBkg = event.getSourceBkg();
			
			// split처리 용
			SplitBkgVO 				splitBkgVO 		= event.getSplitBkgVO();
			List<SelectCntrVO> 		selectCntrVO	= splitBkgVO.getSelectCntrVO();
			List<SplitQtyVO>   		selectQtyVO 	= splitBkgVO.getSplitQtyVO();
			List<SelectSpclCgoVO>	selectSpclCgoVO = splitBkgVO.getSelectSpclCgoVO();			
			
			//for History
			String      splitToBkgNoStr = "";
			String []   cntrHistStr 	= new String[event.getTargetBkg().length];
			String 	    preCntrHistStr	= "";
			String      orgTvvd 		= splitBkgVO.getCopySplitBkgEtcVO().get(0).getTvvd();
//			String 		polCd			= splitBkgVO.getCopySplitBkgEtcVO().get(0).getPolCd();	
			String      codRqstSeq      = event.getCodRqstSeq();
			String		splitRsnCd 		= splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason();
			
			HistoryTableVO histTableVO  = null;
			
			//for auto c/a
			String bdrFlag = "N";
			BkgCorrectionVO bkgCorrectionVO = new BkgCorrectionVO();
			if(splitBkgVO.getCopySplitBkgEtcVO().get(0).getBdrFlag().equals("Y")){
				bdrFlag = "Y";
			}			
			
			// prd 호출
			ArrayList<String> cntrNoList  = null;
			String [][] 	  pctlMapSeq  = new String[event.getTargetBkg().length][2];	
			
			// prd에 넘겨줄 bkg list
			ArrayList<String> bkgNoList = new ArrayList<String>();
			for (int i=0;i<event.getTargetBkg().length;i++){
				bkgNoList.add(event.getTargetBkg()[i].getBkgNo());				
				// for history
				if(i==0){
					splitToBkgNoStr = event.getTargetBkg()[i].getBkgNo();
				} else {
//					splitToBkgNoStr = splitToBkgNoStr + ", " + event.getTargetBkg()[i].getBkgNo();
					StringBuffer tmpBuffer = new StringBuffer(splitToBkgNoStr).append(", ").append(event.getTargetBkg()[i].getBkgNo());
					splitToBkgNoStr = tmpBuffer.toString();
					if(i%3==0){
//						splitToBkgNoStr = splitToBkgNoStr + "\n";
						StringBuffer tmpBuffer2 = new StringBuffer(splitToBkgNoStr).append("\n");
						splitToBkgNoStr = tmpBuffer2.toString();
					}
				}
			}
			
			begin();			
			
			// split bkg 별로 prd에 call
			for (int i=0;i<event.getTargetBkg().length;i++){
				//memo split일 경우 P/C 추가 call
				if(0==i && splitRsnCd.equals("M")){
	                PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO(); 
	                prdMainInfoVO.setPcMode("S");
	                prdMainInfoVO.setFCmd("3");
	                prdMainInfoVO.setBkgNo(sourceBkg.getBkgNo());
	                prdMainInfoVO.setParentBkgNo(sourceBkg.getBkgNo());
	                prdMainInfoVO.setBkgOfc(account.getOfc_cd());
	                
	                PrdParameterVO prdParameterVO = new PrdParameterVO();
	                prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
	                
	                //for qty
	                ArrayList<PrdQtyInfoVO> prdQtyList = new ArrayList<PrdQtyInfoVO>();
	                PrdQtyInfoVO[] 			prdQtyInfos = receiptBC.searchBkgQtyForRailTime(sourceBkg);
	                PrdQtyInfoVO 			prdQtyInfo = null;
	                for(int icnt=0;icnt<prdQtyInfos.length; icnt++) {
                		prdQtyInfo = new PrdQtyInfoVO();
                		prdQtyInfo.setCQty (prdQtyInfos[icnt].getCQty());
                		prdQtyInfo.setCTpsz(prdQtyInfos[icnt].getCTpsz());
                		prdQtyList.add(prdQtyInfo); 
	                }
	                
	                prdParameterVO.setPrdQtyInfo(prdQtyList);

	                //for cntr
	                cntrNoList = new ArrayList<String>();
	                String [] cntrNos = util.searchCntrListByBkg(sourceBkg);
	                for(int icnt=0;icnt<cntrNos.length; icnt++) {
	                    cntrNoList.add(cntrNos[icnt]);
	                }
	                String pctlNoMapSeqStr = prdBC.createPrdCtlgRoutSplit(prdParameterVO, account, cntrNoList, i, bkgNoList);
	                String [] memoPctlMapSeq = util.splitByToken(pctlNoMapSeqStr, "|"); 
	            	sourceBkg.setPctlNo(memoPctlMapSeq[0]); 
	            	sourceBkg.setMapSeq(memoPctlMapSeq[1]);
				}
				BkgBlNoVO targetBkg = event.getTargetBkg()[i];
				log.debug("\nprocessing bkg no:"+targetBkg.getBkgNo());
                
                PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO(); 
                prdMainInfoVO.setPcMode("S");
                prdMainInfoVO.setFCmd("3");
                prdMainInfoVO.setBkgNo(targetBkg.getBkgNo());
                prdMainInfoVO.setParentBkgNo(sourceBkg.getBkgNo());
                prdMainInfoVO.setBkgOfc(account.getOfc_cd());
                
                PrdParameterVO prdParameterVO = new PrdParameterVO();
                prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
                
                //for qty
                ArrayList<PrdQtyInfoVO> prdQtyList = new ArrayList<PrdQtyInfoVO>();
                PrdQtyInfoVO 			prdQtyInfo = null;                       

                for(int icnt=0;icnt<selectQtyVO.size(); icnt++) {
                	int targetBkgSeq = icnt%splitBkgVO.getSplitBlInfoVO().size();
                	selectQtyVO.get(icnt).setSplitNo(splitBkgVO.getSplitBlInfoVO().get(targetBkgSeq).getBkgNo());
                	double iQty =(selectQtyVO.get(icnt).getOpCntrQty()==null)? 0:Double.parseDouble(selectQtyVO.get(icnt).getOpCntrQty());

                	if (targetBkg.getBkgNo().equals(splitBkgVO.getSplitBlInfoVO().get(targetBkgSeq).getBkgNo())
       					&& iQty>0.0){
                		prdQtyInfo = new PrdQtyInfoVO();
                		prdQtyInfo.setCQty (selectQtyVO.get(icnt).getOpCntrQty());
                		prdQtyInfo.setCTpsz(selectQtyVO.get(icnt).getCntrTpszCd());
                		prdQtyList.add(prdQtyInfo); 
                	}
                }
                prdParameterVO.setPrdQtyInfo(prdQtyList);

                //for cntr
                cntrNoList = new ArrayList<String>();
                cntrHistStr[i] = "";
                for(int icnt=0;icnt<selectCntrVO.size(); icnt++) {
                    if (selectCntrVO.get(icnt).getBkg_no().equals(targetBkg.getBkgNo())
                        && selectCntrVO.get(icnt).getSplitNo().length()>1){
                    	cntrNoList.add(selectCntrVO.get(icnt).getCntr_no());
                    	//for history
                    	if(cntrNoList.size() == 1){
                    		cntrHistStr[i] = selectCntrVO.get(icnt).getCntr_no();
                    	} else {
                    		if(cntrNoList.size()%3==1){
//                    			cntrHistStr[i] = cntrHistStr[i] + ",\n" + selectCntrVO.get(icnt).getCntr_no();
                    			StringBuffer tmpBuffer = new StringBuffer(cntrHistStr[i]).append(",\n").append(selectCntrVO.get(icnt).getCntr_no());
                    			cntrHistStr[i] = tmpBuffer.toString();
                    		} else {
//                    			cntrHistStr[i] = cntrHistStr[i] + ", " + selectCntrVO.get(icnt).getCntr_no();
                    			StringBuffer tmpBuffer = new StringBuffer(cntrHistStr[i]).append(", ").append(selectCntrVO.get(icnt).getCntr_no());
                    			cntrHistStr[i] = tmpBuffer.toString();
                    		}
                    	}
                    }
                }
                String pctlNoMapSeqStr = prdBC.createPrdCtlgRoutSplit(prdParameterVO, account, cntrNoList, i, bkgNoList);
            	pctlMapSeq[i] = util.splitByToken(pctlNoMapSeqStr, "|");
			}// prd 호출 끝			
			commit();
			
			//for cntr history
			if(selectCntrVO.size()>0){
				String [] cntrList = util.searchCntrListByBkg(sourceBkg);
				for(int i=0;i<cntrList.length;i++){
                	if(i == 0){
                		preCntrHistStr = cntrList[i];
                	} else {
                		if((i+1)%3==1){
//                			preCntrHistStr = preCntrHistStr + ",\n" + cntrList[i];
                			StringBuffer tmpBuffer = new StringBuffer(preCntrHistStr).append(",\n").append(cntrList[i]);
                			preCntrHistStr = tmpBuffer.toString();
                		} else {
//                			preCntrHistStr = preCntrHistStr + ", " + cntrList[i];
                			StringBuffer tmpBuffer = new StringBuffer(preCntrHistStr).append(", ").append(cntrList[i]);
                			preCntrHistStr = tmpBuffer.toString();
                		}
                	}
				}				
			}
			
			if (command.validateSplit(event.getSplitBkgVO(), sourceBkg).equals("Y")){
				begin();
				if(bdrFlag.equals("Y")){
					// add1stCaHist : sourcebkg의 최초 c/a hist을 넣는다(corr_no : 0000000001)
					add1stCaHist(event.getSourceBkg());
				}			
				BkgCopyCntrCmByBkgVO bkgCopyCntrCmByBkgVO = new BkgCopyCntrCmByBkgVO();
				bkgCopyCntrCmByBkgVO.setCopyModeCd("S");
				bkgCopyCntrCmByBkgVO.setHitchmentYn("");
				
				receiptBC.copyBookingForSplit   (sourceBkg, event.getTargetBkg(), splitBkgVO,   account);
				blDocBlBC.copyBlDocByBkg		(sourceBkg, event.getTargetBkg(), splitBkgVO,   account );
				//blDocCmBC.copyCntrCmByBkg  ("S", sourceBkg, event.getTargetBkg(), selectCntrVO, account, "");
				blDocCmBC.copyCntrCmByBkg  (sourceBkg, event.getTargetBkg(), selectCntrVO, bkgCopyCntrCmByBkgVO ,account);
				blDocBlBC.copyHblByBkg     ("S", sourceBkg, event.getTargetBkg(), selectCntrVO, account);
				if(selectSpclCgoVO.size()>0){
					SpecialCargoReceiptBC spclCgoBC = new SpecialCargoReceiptBCImpl();
					spclCgoBC.copySpclCgoByBkg  ("S", sourceBkg, event.getTargetBkg(),selectSpclCgoVO, account);
				}

				// 임시 주석 처리
//				if(selectSpclCgoVO.size()>0){
//					//bkg의 spcl flag 재 계산
//					receiptBC.modifySpclFlag(event.getTargetBkg(), account);
//					if(selectCntrVO.size()>0){
//						//container의 spcl flag 재계산
//						blDocCmBC.modifyCntrSpclFlag(event.getTargetBkg(), account);
//					}
//				}
				
				//cop에 1차로 split을 반영
				String [] targetBkgNoList = new String[event.getTargetBkg().length];
				String [] copMapSeq       = new String[event.getTargetBkg().length];
				for(int i=0;i<event.getTargetBkg().length;i++){
					targetBkgNoList[i] = event.getTargetBkg()[i].getBkgNo();	
					copMapSeq[i]       = pctlMapSeq[i][1]; 
				}				
				//copBC.splitBkg(sourceBkg.getBkgNo(), targetBkgNoList, copMapSeq);
				callCopSplitBkg(sourceBkg.getBkgNo(), targetBkgNoList, copMapSeq);
				
				for (int i=0;i<event.getTargetBkg().length;i++){
					BkgBlNoVO targetBkg = event.getTargetBkg()[i];
					
					//for performance report
					reportBC.manageQtyCntrCoposite(targetBkg.getBkgNo(), "CQ");		
					reportBC.manageQtyCntrCoposite(targetBkg.getBkgNo(), "CN");				
					
					// bdr 이전이면 해당 Booking의 status를 재계산한다.
					if(bdrFlag.equals("Y")){
						// bdr 이후일 경우 
						bkgCorrectionVO.setBkgNo(targetBkg.getBkgNo());
						//split new Bkg에 대해 BDR이후일 경우 first c/a(dummy)
						if (!event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
							add1stCaHist(targetBkg);
						}
					}
					
					//vvd가 변경되었을 경우
					log.debug("\nbkg:"+targetBkg.getBkgNo()+",tVvd:"+splitBkgVO.getSplitBlInfoVO().get(i).getTvvd()
							+ "\nroute String:"+splitBkgVO.getSplitBlInfoVO().get(i).getRtnRoute());	
					if(splitBkgVO.getSplitBlInfoVO().get(i).getRtnRoute()!=null 
						&& splitBkgVO.getSplitBlInfoVO().get(i).getRtnRoute().length()>10){
						
						//PrdMainInfoVO Set
						PrdMainInfoVO prdMainInfoVO  = new PrdMainInfoVO();
						prdMainInfoVO.setFCmd("3");
						prdMainInfoVO.setPcMode("R");
						prdMainInfoVO.setTVvd (splitBkgVO.getSplitBlInfoVO().get(i).getTvvd());
						prdMainInfoVO.setBkgNo(targetBkg.getBkgNo());
						
						PrdParameterVO prdParameterVO = new PrdParameterVO();
						prdParameterVO.setBkgBlNoVO(targetBkg);
						prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
						prdParameterVO=util.searchPrdParmForFullRoute (prdParameterVO);
						
						PrdMainInfoVO rtnPrdMainInfoVO = prdParameterVO.getPrdMainInfoVO();
						util.resetNthRoute(rtnPrdMainInfoVO, 1);
						util.resetNthRoute(rtnPrdMainInfoVO, 2);
						util.resetNthRoute(rtnPrdMainInfoVO, 3);
						util.resetNthRoute(rtnPrdMainInfoVO, 4);
						rtnPrdMainInfoVO.setOrgTrnsMode("");
						rtnPrdMainInfoVO.setDestTrnsMode("");
						
						String rtnRoute = splitBkgVO.getSplitBlInfoVO().get(i).getRtnRoute();
						String [] rtnRouteVvds = util.splitByToken(rtnRoute, ",");
						for(int j=0;j<rtnRouteVvds.length;j++){
							if(rtnRouteVvds[j].length()==0) break;
							String [] rtnRouteInfo = util.splitByToken(rtnRouteVvds[j], "|");
							log.debug("\npol:"+rtnRouteInfo[0]+"/polYd:"+rtnRouteInfo[1]+"/pol_clpt:"+rtnRouteInfo[6]+
									   "/pod:"+rtnRouteInfo[2]+"/podYd:"+rtnRouteInfo[3]+"/pod_clpt:"+rtnRouteInfo[7] +
									   "/vvd:"+rtnRouteInfo[4]+"/lane:"+rtnRouteInfo[5]);
							if(j==0){
								rtnPrdMainInfoVO.setPol1 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol1N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol1C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod1 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod1N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod1C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd1 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane1(rtnRouteInfo[5]);
							} else if(j==1){
								rtnPrdMainInfoVO.setPol2 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol2N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol2C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod2 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod2N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod2C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd2 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane2(rtnRouteInfo[5]);
							} else if(j==2){
								rtnPrdMainInfoVO.setPol3 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol3N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol3C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod3 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod3N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod3C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd3 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane3(rtnRouteInfo[5]);
							} else if(j==3){
								rtnPrdMainInfoVO.setPol4 (rtnRouteInfo[0]);
								rtnPrdMainInfoVO.setPol4N(rtnRouteInfo[1]);
								rtnPrdMainInfoVO.setPol4C(rtnRouteInfo[6]);
								rtnPrdMainInfoVO.setPod4 (rtnRouteInfo[2]);
								rtnPrdMainInfoVO.setPod4N(rtnRouteInfo[3]);
								rtnPrdMainInfoVO.setPod4C(rtnRouteInfo[7]);
								rtnPrdMainInfoVO.setVvd4 (rtnRouteInfo[4]);
								rtnPrdMainInfoVO.setLane4(rtnRouteInfo[5]);
							}
						}
						CodEtcVO codEtcVO = codBC.searchCodSplitRoute(sourceBkg, codRqstSeq);
						rtnPrdMainInfoVO.setPod (codEtcVO.getNewPodCd());
						rtnPrdMainInfoVO.setPodN(codEtcVO.getNewPodCd() + codEtcVO.getNewPodNodCd());
						rtnPrdMainInfoVO.setDel (codEtcVO.getNewDelCd());
						rtnPrdMainInfoVO.setDelN(codEtcVO.getNewDelCd() + codEtcVO.getNewDelNodCd());
						rtnPrdMainInfoVO.setDelT(codEtcVO.getNewDeTermCd());
						rtnPrdMainInfoVO.setDestTrnsMode("");
						prdParameterVO.setPrdMainInfoVO(rtnPrdMainInfoVO);
//						util.prdParameterLog(prdParameterVO.getPrdMainInfoVO());

						// 12. createProdCtlRoute
						String pctlNoMapSeqStr = prdBC.createPrdCtlgRout(prdParameterVO, account);
						String [] pctlNoMapSeq = util.splitByToken(pctlNoMapSeqStr, "|");
						
						targetBkg.setPctlNo(pctlNoMapSeq[0]);
						targetBkg.setMapSeq(pctlNoMapSeq[1]);						

						//	vvd변경에 대한 old vvd조회(org bkg에 대해서만 vvd 변경 이력을 남긴다)
						histTableVO = new HistoryTableVO();
						if(targetBkg.getBkgNo().equals(sourceBkg.getBkgNo())){
							histTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0997", targetBkg);
						}
						
						// 실제 vvd 변경
						receiptBC.modifyBookingFromCod(targetBkg, sourceBkg, event.getCodRqstSeq(), account);
												
						//cop에 2차로 replan 반영
						//copBC.updateBkg(targetBkg.getBkgNo(), targetBkg.getMapSeq());
						callCopUpdateBkg(targetBkg.getBkgNo(), targetBkg.getMapSeq());
					}//vvd가 변경되었을 경우 끝

					// bdr 이전이면 해당 Booking의 status를 재계산한다.
					if(bdrFlag.equals("N")){
						receiptBC.changeBkgStatus("Y",targetBkg, false, account);
					}

					// auto c/a 처리
					if(bdrFlag.equals("Y")){						
						// vvd 변경됐을 경우
						if(splitBkgVO.getSplitBlInfoVO().get(i).getRtnRoute()!=null){
							bkgCorrectionVO.setRoutCorrFlg("Y");
							bkgCorrectionVO.setTrnkVslCorrFlg("Y");
						}
						
						if (event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
							bdrBC.addAutoCaTemp(sourceBkg, "SPLIT_MASTER", bkgCorrectionVO, account);
						} else {
							bdrBC.addAutoCaTemp(targetBkg, "SPLIT_NEW", bkgCorrectionVO, account);
						}
						
						BkgBlNoVO corrBkgBlNoVO = addCaHistory(event.getCaRsnCd(), event.getCaRemark(), targetBkg, "N", "Y");
						targetBkg.setCaNo(corrBkgBlNoVO.getCaNo());
						event.getTargetBkg()[i].setCaNo(corrBkgBlNoVO.getCaNo());
						
						bdrBC.removeCATemp(targetBkg);

						blRatingBC.distributeCntrRate(targetBkg.getBkgNo(), account);
			            //추가2. 
						OblIssVO oblIssVO = util.searchOblIssue(targetBkg); 
						
						//추가2. 
						RevDrNoteVO        revDrNoteVO    = new RevDrNoteVO(); 
						CstmBkgRevDrNoteVO bkgRevDrNoteVO = new CstmBkgRevDrNoteVO();
						bkgRevDrNoteVO.setBkgNo      (targetBkg.getBkgNo());  
						bkgRevDrNoteVO.setBkgCorrNo  (targetBkg.getCaNo()); 
						bkgRevDrNoteVO.setRdnNo      (oblIssVO.getRdnNo()); 
						bkgRevDrNoteVO.setRvisSeq    (oblIssVO.getRvisSeq()); 
						bkgRevDrNoteVO.setReceiverRmk("");
						revDrNoteVO.setBkgRevDrNoteVO(bkgRevDrNoteVO);

						RevenueDebitNoteBC revenueDebitNoteBC = new RevenueDebitNoteBCImpl();
						revenueDebitNoteBC.acceptRDNbyReceiptOffice(revDrNoteVO, account);  
						
						//추가2. 
						OblRdemVO oblRdem = new OblRdemVO();
						oblRdem.setBlNo      (oblIssVO.getBlNo());  
						oblRdem.setCgorTeamCd("C");
						oblRdem.setCgoEvntNm ("B/L Correct");
						oblRdem.setEvntDt    (new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
						oblRdem.setEvntOfcCd (account.getOfc_cd());
						oblRdem.setEvntUsrId (account.getUsr_id());
						oblRdem.setOblRdemFlg(oblIssVO.getOblRlseFlg()); 

						CargoReleaseOrderBC cargoReleaseOrderBC = new CargoReleaseOrderBCImpl();
						try{
							cargoReleaseOrderBC.setupFocByObl(oblRdem);
						} catch(Exception crEx){
							log.error("err " + crEx.toString(), crEx);
						}
					} else {
						targetBkg.setCaNo("");
					}// auto c/a 처리 끝

					// history 처리
					HistoryLineVO historyLineVO = new HistoryLineVO();
					
					historyLineVO.setBkgNo (targetBkg.getBkgNo());
					historyLineVO.setCorrNo(targetBkg.getCaNo());
					historyLineVO.setUiId("ESM_BKG_0997");
					if (event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
						historyLineVO.setCrntCtnt("Cod split into :"+splitToBkgNoStr);		
						historyLineVO.setBkgDocProcTpCd("BKGSPT");
					} else {
						historyLineVO.setCrntCtnt("Cod split from BKG No :"+sourceBkg.getBkgNo()); //new -> Splited from BKG No : %, old -> Splited.
					}
					historyLineVO.setHisCateNm("COD SPLIT");			
					historyBC.createBkgHistoryLine (historyLineVO,account);
					
					//	vvd변경에 대한 history
					if(targetBkg.getBkgNo().equals(sourceBkg.getBkgNo())){
						if(splitBkgVO.getSplitBlInfoVO().get(i).getRtnRoute()!=null 
								&& splitBkgVO.getSplitBlInfoVO().get(i).getRtnRoute().length()>10
								&& !orgTvvd.equals(splitBkgVO.getSplitBlInfoVO().get(i).getTvvd())){
							if(histTableVO!=null && histTableVO.getBkgBlNoVO()!=null){
								histTableVO.getBkgBlNoVO().setCaNo(targetBkg.getCaNo());
							}
							historyBC.manageBookingHistory("ESM_BKG_0997", histTableVO, account);
						}
					}
					if(cntrHistStr[i].length()>0){
						//	cntr에 대한 histiry
						historyLineVO.setCrntCtnt(cntrHistStr[i]); 
						if(targetBkg.getBkgNo().equals(sourceBkg.getBkgNo())){
							historyLineVO.setPreCtnt(preCntrHistStr);
						} 
						historyLineVO.setHisCateNm("Container No.");						
						historyBC.createBkgHistoryLine (historyLineVO,account);					
						historyBC.releaseCntrFinalConfirm(targetBkg, account);
						// history 처리 끝
					}
					
					// CNHKG만 제외
					if(!splitBkgVO.getCopySplitBkgEtcVO().get(0).getPolCd().equals("CNHKG") && !event.getTargetBkg()[i].getBkgNo().equals(sourceBkg.getBkgNo())){
						searchBC.createCustBkgReceiptEdiBackEnd(targetBkg, null, "Y", account);
					}
				}

				//memo split일 경우 master bkg의 history
				if (splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason().equals("M")){
					HistoryLineVO historyLineVO = new HistoryLineVO();
				
					historyLineVO.setBkgNo (sourceBkg.getBkgNo());
					historyLineVO.setCorrNo(sourceBkg.getCaNo());
					historyLineVO.setUiId("ESM_BKG_0997");
					historyLineVO.setCrntCtnt("Memo Split into :"+splitToBkgNoStr);		
					historyLineVO.setBkgDocProcTpCd("BKGSPT");
					historyLineVO.setHisCateNm("SPLIT");		
					historyBC.createBkgHistoryLine (historyLineVO,account);
				}

				//interface coa
				for (int i=0;i<event.getTargetBkg().length;i++){
					interfaceToMas(event.getTargetBkg()[i], "Booking Cod Split", account);
				}
				//0156에서 다시 실행함
//				codBC.modifyCodStatus(sourceBkg, codRqstSeq, "F", "", account);
				commit();
				
				begin();
				for (int i=0;i<event.getTargetBkg().length;i++){	
					// invoice interface
					interfaceToInv(event.getTargetBkg()[i], account);					
				}		
				commit();
				eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());	
			}else{
				eventResponse.setUserMessage(new ErrorHandler("BKG00167").getUserMessage());
			}
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		
	}
	
	/**
	 * ESM_BKG_9450 : retrieve <br>
	 * Empty Repo Bkg에 속해 있는 Container No List를 조회한다.<br>
	 *  
	 * @author	KimByungKyu
	 * @param 	Event e
	 * @return		EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchEmptyCntrByBKG(Event e) throws EventException{
		try{
			EsmBkg9450Event event = (EsmBkg9450Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			List<CntrInfoForEmptyVO> list =  command.searchEmptyCntrByBKG(event.getBkgBlNoVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}	

	/**
	 * ESM_BKG_0654 : open <br>
	 * 모든 Service Scope의 Code와 Name을 조회한다. <br>
	 * 최초 넘겨받은 값으로 Rfa List를 조회한다. <br>
	 *  
	 * @author	KimByungKyu
	 * @param 	Event e
	 * @return		EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchSvcScp(Event e) throws EventException{
		try{
			EsmBkg0654Event event = (EsmBkg0654Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			List<MdmSvcScpVO> svcScpList =  command.searchSvcScp();
			List<RfaListVO> rfaList =  command.searchRfaList(event.getRfaListInputVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(svcScpList);		
			eventResponse.setRsVoList(rfaList);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}

	/**
	 * ESM_BKG_0654 : retrieve <br>
	 * 화주 계약서상의 RFA를 조회한다. <br>
	 *  
	 * @author	KimByungKyu
	 * @param 	Event e
	 * @return		EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchRfaList(Event e) throws EventException{
		try{
			EsmBkg0654Event event = (EsmBkg0654Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			List<RfaListVO> list =  command.searchRfaList(event.getRfaListInputVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}	

	/**
	 * ESM_BKG_0654 : retrieve <br>
	 * 화주 계약서상의 S/C를 조회한다.<br>
	 *  
	 * @author	KimByungKyu
	 * @param 	Event e
	 * @return		EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchScList(Event e) throws EventException{
		try{
			EsmBkg0655Event event = (EsmBkg0655Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			List<ScListVO> list =  command.searchScList(event.getScListInputVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}		

	/**
	 * ESM_BKG_0656 : retrieve <br>
	 * RFA 계약 상의 Commodity를 조회한다. <br>
	 *  
	 * @author	KimByungKyu
	 * @param 	Event e
	 * @return		EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchCmdtByRfa(Event e) throws EventException{
		try{
			EsmBkg0656Event event = (EsmBkg0656Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			List<RfaCmdtListVO> list = command.searchCmdtByRfa(event.getRfaListInputVO(), event.getCmdtNm(), event.getCmdtCd());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}		

	/**
	 * ESM_BKG_0657 : retreive <br>
	 * S/C 계약 상의 Commodity를 조회한다. <br>
	 *  
	 * @author	KimByungKyu
	 * @param 	Event e
	 * @return		EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchCmdtBySc(Event e) throws EventException{
		try{
			EsmBkg0657Event event = (EsmBkg0657Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			BookingUtil utilCmd = new BookingUtil();
			
			if(!"".equals(event.getScListInputVO().getBkgNo())){
				BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
				bkgBlNoIN.setBkgNo(event.getScListInputVO().getBkgNo());
				bkgBlNoIN.setCaUsrId(account.getUsr_id());
				
				BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoIN);
				if(null!=bkgBlNoVO && !"".equals(bkgBlNoVO.getCaFlg())){
					event.getScListInputVO().setCaFlg(bkgBlNoVO.getCaFlg());
				}
				
			}
			List<ScCmdtListVO> list = command.searchCmdtBySc(event.getScListInputVO(), event.getCmdtNm(), event.getCmdtCd(), event.getSvcScpCd());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}	
	
	/**
	 * ESM_BKG_0079_02B : cntr_no change <br>
	 * 입력한 컨테이너의 type/size를 조회한다.<br>
	 * @author	Lee NamKyung
	 * @param 	e Event
	 * @return  eventResponse EventResponse
	 * @exception 	EventException
	 */
    private EventResponse searchTypeSizeByCntr(Event e) throws EventException {
    	EsmBkg007902bEvent event = (EsmBkg007902bEvent) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();        
        BookingUtil command = new BookingUtil();
        
        try {
        	String cntrNo     = event.getCntrNo();
        	String cntrTpszCd = "";
            List<MstContainerVO> list = command.searchTypeSizeByCntr(cntrNo); 
    		if(list.size() > 0){
    			cntrTpszCd = JSPUtil.getNullNoTrim(list.get(0).getCntrTpszCd());
    		}
			eventResponse.setETCData("cntr_tpsz_cd", cntrTpszCd);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;
    }

	/**
	 * ESM_BKG_0079_05 : retrieve <br>
	 * Customer Information 정보 조회.<br>
	 * 
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBlDocCust(Event e) throws EventException {
		try{
			EsmBkg007905Event event = (EsmBkg007905Event)e;
			
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
			BookingUtil bookingUtil = new BookingUtil();	

			GeneralEventResponse eventResponse = new GeneralEventResponse();		
			
			// 01. Combo 데이터 조회 (Shipper FF)
			List<BkgComboVO> ffShiper  = bookingUtil.searchCombo("CD02125");			
			eventResponse.setRsVoList(ffShiper);
			
			event.getBkgBlNoVO().setCaUsrId(account.getUsr_id());
			
			// 02. Customer Information 정보 조회
			BlCustomerVO blCustomerVO = receiptBC.searchBlDocCust(event.getBkgBlNoVO());
			if(blCustomerVO != null){
				BlDocCustVO blDocCustVO = blCustomerVO.getBlDocCustVO();
				CustEtcVO custEtcVO = blCustomerVO.getCustEtcVO();
				BkgBlNoVO bkgBlNoVO = blCustomerVO.getBkgBlNoVO();
				if(bkgBlNoVO != null){
					eventResponse.setETCData(bkgBlNoVO.getColumnValues());
				}			
				if(blDocCustVO != null){
					eventResponse.setETCData(blDocCustVO.getColumnValues());
				}	
				if(custEtcVO != null){
					eventResponse.setETCData(custEtcVO.getColumnValues());
				}

				// 원 BL 번호
				String orgBlNo = "";
				if(blCustomerVO.getSplitMstBlNoVO() != null){
					orgBlNo = blCustomerVO.getSplitMstBlNoVO().getBlNo();
				}
				eventResponse.setETCData("OrgBlNo",orgBlNo);		
				
				// 다른 usr가 c/a 진행중이라면 일반 mode로 조회
				if(bkgBlNoVO!=null && bkgBlNoVO.getCaUsrId()!=null && !bkgBlNoVO.getCaUsrId().equals(account.getUsr_id())){
					eventResponse.setETCData("ca_flg", "N");
				}
			}else{
				// No data found.
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
				eventResponse.setETCData("DataYn", "N");
			}		
			
			return eventResponse;			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}    
	/**
	 * ESM_BKG_0079_05 : cust_cnt_cd, cust_seq change <br>
	 * ESM_BKG_0003 : cust_cnt_cd, cust_seq change <br>
	 * ESM_BKG_0005 : cust_cnt_cd, cust_seq change <br>
	 * CustCntCd와 CustSeq로 Mdm Customer의 CustName을 조회한다.<br>
	 * 
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmCustNm(Event e) throws EventException {
		try{
			MdmCustVO mdmCustVO = null;
			BookingUtil bookingUtil = new BookingUtil();
				
			if(e.getEventName().equalsIgnoreCase("EsmBkg007905Event")){
				EsmBkg007905Event event = (EsmBkg007905Event)e;
				mdmCustVO = bookingUtil.searchMdmCust(event.getCustCntCd(), event.getCustSeq(), "N");
			} else if(e.getEventName().equalsIgnoreCase("EsmBkg0003Event")){
				EsmBkg0003Event event = (EsmBkg0003Event)e;
				mdmCustVO = bookingUtil.searchMdmCust(event.getCustCntCd(), event.getCustSeq(), "N");
			} else if(e.getEventName().equalsIgnoreCase("EsmBkg0005Event")){
				EsmBkg0005Event event = (EsmBkg0005Event)e;
				mdmCustVO = bookingUtil.searchMdmCust(event.getCustCntCd(), event.getCustSeq(), "N");
			}

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if(mdmCustVO != null){
				eventResponse.setETCData("cust_nm",mdmCustVO.getName());
				eventResponse.setETCData("cust_addr",mdmCustVO.getAddress());
				eventResponse.setETCData("frt_fwrd_fmc_no",mdmCustVO.getFrtFwrdFmcNo());
				eventResponse.setETCData("cust_tp",mdmCustVO.getCustTpCd());
				eventResponse.setETCData("rvis_cntr_cust_tp_cd",mdmCustVO.getRvisCntrCustTpCd());
				eventResponse.setETCData("blk_lst_flg",mdmCustVO.getBklstFlg());
				eventResponse.setETCData("rlse_ctrl_rsn",mdmCustVO.getRlseCtrlRsn());
				eventResponse.setETCData("ar_ofc",mdmCustVO.getArOfc());
				eventResponse.setETCData("srep_nm",mdmCustVO.getSrepNm());
				eventResponse.setETCData("ida_gst_rgst_no",mdmCustVO.getIdaGstRgstNo());
				eventResponse.setETCData("co_chn_no",mdmCustVO.getCoChnNo());
			}else{
				eventResponse.setETCData("cust_nm","");
				eventResponse.setETCData("cust_addr","");
				eventResponse.setETCData("frt_fwrd_fmc_no","");
				eventResponse.setETCData("cust_tp","");
			}
		
			return eventResponse;			
		}catch(EventException ex){
//			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}	

	/**
	 * ESM_BKG_0079_05 : save <br>
	 * Customer Information 정보 수정.<br>
	 * 
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBlDocCust(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg007905Event event = (EsmBkg007905Event)e;
		try{
//			begin();		
			
			GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
			GeneralBookingSearchBC 	searchBC 	= new GeneralBookingSearchBCImpl();
			BLDocumentationBLBC 	blDocBC 	= new BLDocumentationBLBCImpl();
			BlRatingBC				ratingBC	= new BlRatingBCImpl();
			BookingHistoryMgtBC 	historyBC 	= new BookingHistoryMgtBCImpl();
			BDRCorrectionBC			bdrBC		= new BDRCorrectionBCImpl();
			BookingUtil 			util 		= new BookingUtil();		

			BkgBlNoVO bkgBlNoVO       = event.getBkgBlNoVO();
			BlCustomerVO blCustomerVO = new BlCustomerVO();
			blCustomerVO.setBkgBlNoVO  (bkgBlNoVO);
			blCustomerVO.setBlDocCustVO(event.getBlDocCustVO());
			blCustomerVO.setCustEtcVO  (event.getCustEtcVO());			
			boolean ibCustCdVal = false;
			String bkgNo = bkgBlNoVO.getBkgNo();
			
			if(bkgBlNoVO.getCaFlg().equals("Y")){
				CaRsnRmkVO caRsnRmkVO = bdrBC.searchCaRsnRmk(bkgBlNoVO, account);
				if(caRsnRmkVO == null || caRsnRmkVO.getCaRsnCd() == null || caRsnRmkVO.getCaRsnCd().length() < 1){
					throw new EventException((String)new ErrorHandler("BKG08076").getMessage());
				}
			}
			
			// 10. validationBlDocCust 수행
			String[] alertMsg = receiptBC.validateBlDocCust(blCustomerVO);
			
			// cust validation 추가
			//[CHM-201536074] black list 화주 blocking
			//[CHM-201537002] 중국 Black list shippr list 중에서 CNEE/ Notify / Also Notify 에 적용되는  blocking  로직 해지 요청 
			ArrayList <String> custNms = new ArrayList<String>();
			BlDocCustVO blDocCustVO = blCustomerVO.getBlDocCustVO();
			custNms.add(blDocCustVO.getShCustNm());
			//custNms.add(blDocCustVO.getCnCustNm());
			//custNms.add(blDocCustVO.getNfCustNm());
			custNms.add(blDocCustVO.getFfCustNm());
			//custNms.add(blDocCustVO.getAnCustNm());
			custNms.add(blDocCustVO.getExCustNm());
			for(int i=0; i<custNms.size(); i++){
				String custNm = (String)custNms.get(i);
				if(custNm != null && !"".equals(custNm)){
					// enter 제거, 특수문자->공란, 공란여러개->공란1개
					custNm = custNm.replace("\r\n", " ").replace("\r", " ").replace("\n", " ");
					custNm = custNm.replace("~", " ").replace("!", " ").replace("@", " ").replace("#", " ").replace("$", " ").replace("%", " ");
					custNm = custNm.replace("^", " ").replace("&", " ").replace("*", " ").replace("(", " ").replace(")", " ").replace("_", " ");
					custNm = custNm.replace("+", " ").replace("`", " ").replace("-", " ").replace("=", " ").replace("{", " ").replace("}", " ");
					custNm = custNm.replace("|", " ").replace("[", " ").replace("]", " ").replace("\\", " ").replace(":", " ").replace(";", " ");
					custNm = custNm.replace("\"", " ").replace("'", " ").replace("/", " ").replace("<", " ").replace(">", " ").replace("?", " ");
					custNm = custNm.replace(",", " ").replace(".", " ");
					custNm = custNm.replace("  ", " ").replace("  ", " ").replace("  ", " "); 
					
					String blockCustName = receiptBC.checkBlockCustName(custNm);
					
					if(blockCustName != null && !"".equals(blockCustName)){
						begin();
						BkgBlckListMntrVO vo = new BkgBlckListMntrVO();
						vo.setBkgNo(bkgBlNoVO.getBkgNo());
						vo.setBlckKwNm(blockCustName);
						vo.setCustDescKwNm(blockCustName);
						vo.setBlckKwTpCd("BLA");
						vo.setCreUsrId(account.getUsr_id());
						vo.setUpdUsrId(account.getUsr_id());
						util.addBkgBlckListMntr(vo);
						commit();
						throw new EventException((String)new ErrorHandler("BKG95087", new String[]{blockCustName}).getMessage());	
					}
				}
			}
			begin();
			
			// 18. searchOldBkgForHistory 수행
			HistoryTableVO historyTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0079_05", bkgBlNoVO);

//			OfcChgProcVO ofcChgProcVO = new OfcChgProcVO();
//			ofcChgProcVO.setType("C");  //customer
//			ofcChgProcVO.setCaFlg(bkgBlNoVO.getCaFlg());
//			ofcChgProcVO.setBkgNo(bkgNo);
//			ofcChgProcVO.setCustToOrdFlg(event.getCustEtcVO().getCustToOrdFlg());
//			ofcChgProcVO.setShCustCntCd(event.getBlDocCustVO().getShCustCntCd());
//			ofcChgProcVO.setShCustSeq(event.getBlDocCustVO().getShCustSeq());
//			ofcChgProcVO.setCnCustCntCd(event.getBlDocCustVO().getCnCustCntCd());
//			ofcChgProcVO.setCnCustSeq(event.getBlDocCustVO().getCnCustSeq());
//			ofcChgProcVO.setNfCustCntCd(event.getBlDocCustVO().getNfCustCntCd());
//			ofcChgProcVO.setNfCustSeq(event.getBlDocCustVO().getNfCustSeq());
//			ofcChgProcVO = (new BookingUtil()).searchOfcChgProc(ofcChgProcVO);

			// 20. modifyBlDocCust 수행
			receiptBC.modifyBlDocCust(blCustomerVO, "M", account);
			
			// 23. modifyBlDocExpCust 수행 2011.09.16 추가
			receiptBC.modifyBlDocExpCust(bkgBlNoVO, event.getCustEtcVO().getOrgCntNm(), account, event.getOldActCustCd(), event.getNewActCustCd());
						
			log.debug("oldcustCd = "+ event.getOldActCustCd());
			log.debug("newcustCd = "+ event.getNewActCustCd());
			blDocBC.modifyBkgBlDocByCust(bkgBlNoVO, event.getCustEtcVO().getOrgCntNm(), account, event.getOldActCustCd(), event.getNewActCustCd());
			
			// customer 화면에서 cnee 최초 입력
			for(int i=0;i<historyTableVO.getBkgCustomerVOs().size();i++){
				List<BkgCustomerVO> oldCustVOs = historyTableVO.getBkgCustomerVOs();
				if("C".equals(oldCustVOs.get(i).getBkgCustTpCd())){ //cnee
					if(isNull(oldCustVOs.get(i).getCustCntCd())&&isNull(oldCustVOs.get(i).getCustSeq())// old에 없었고
							&&!isNull(blCustomerVO.getBlDocCustVO().getCnCustCntCd())
							&&!isNull(blCustomerVO.getBlDocCustVO().getCnCustSeq())){// new에 있으면 consignee 새로 입력을 판단
						BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
						bkgDocProcSkdVO.setBkgNo(bkgNo);
						bkgDocProcSkdVO.setBkgDocProcTpCd("CNEIPT");// consignee input for doc performance		
						historyBC.manageDocProcess(bkgDocProcSkdVO, account);
					}					
					if(!isNull(oldCustVOs.get(i).getCustCntCd())&&!isNull(oldCustVOs.get(i).getCustSeq())// old에 있었고
							&&!isNull(blCustomerVO.getBlDocCustVO().getCnCustCntCd())
							&&!isNull(blCustomerVO.getBlDocCustVO().getCnCustSeq())// new에 있으면서
						//서로 다르면
						&&(!oldCustVOs.get(i).getCustCntCd().equals(blCustomerVO.getBlDocCustVO().getCnCustCntCd())
							||!oldCustVOs.get(i).getCustSeq().equals(blCustomerVO.getBlDocCustVO().getCnCustSeq()))){
						ibCustCdVal = true;
					}					
				}
				if(false==ibCustCdVal&&"N".equals(oldCustVOs.get(i).getBkgCustTpCd())){ //cnee
					if(!isNull(oldCustVOs.get(i).getCustCntCd())&&!isNull(oldCustVOs.get(i).getCustSeq())// old에 있었고
							&&!isNull(blCustomerVO.getBlDocCustVO().getNfCustCntCd())
							&&!isNull(blCustomerVO.getBlDocCustVO().getNfCustSeq())// new에 있으면서
						//서로 다르면
						&&(!oldCustVOs.get(i).getCustCntCd().equals(blCustomerVO.getBlDocCustVO().getNfCustCntCd())
							||!oldCustVOs.get(i).getCustSeq().equals(blCustomerVO.getBlDocCustVO().getNfCustSeq()))){
						ibCustCdVal = true;
					}	
				}
			}

			// prepaid collect payer를 수정함
			ratingBC.modifyRateCntCd(bkgBlNoVO.getBkgNo(), account, bkgBlNoVO.getCaFlg());

			// PPD, CCT Office 변경 여부 결정, History와 현재값 비교
			// Shipper, Forwarder, Consignee, Notify, To Order 변경될 때 처리됨
			String ofcChgFlag = "N";
			BkgBookingVO bkgBookingVO = historyTableVO.getBkgBookingVO();
			String toOrdFlagOld = bkgBookingVO.getCustToOrdFlg();
			String shCustCntCdOld = null;
			String shCustSeqOld = null;
			String cnCustCntCdOld = null;
			String cnCustSeqOld = null;
			String fwCustCntCdOld = null;
			String fwCustSeqOld = null;	
			String nfCustCntCdOld = null;
			String nfCustSeqOld = null;	

			List<BkgCustomerVO> bkgCustomerVOs = historyTableVO.getBkgCustomerVOs();
			for (BkgCustomerVO vo : bkgCustomerVOs) {
				if("S".equals(vo.getBkgCustTpCd())) {
					shCustCntCdOld = vo.getCustCntCd();
					shCustSeqOld = vo.getCustSeq();
				} else if("C".equals(vo.getBkgCustTpCd())) {
					cnCustCntCdOld = vo.getCustCntCd();
					cnCustSeqOld = vo.getCustSeq();
				} else if("F".equals(vo.getBkgCustTpCd())) {
					fwCustCntCdOld = vo.getCustCntCd();
					fwCustSeqOld = vo.getCustSeq();
				} else if("N".equals(vo.getBkgCustTpCd())) {
					nfCustCntCdOld = vo.getCustCntCd();
					nfCustSeqOld = vo.getCustSeq();
				}
			}			
			
			String toOrdFlag = event.getCustEtcVO().getCustToOrdFlg();
			String shCustCntCd =blCustomerVO.getBlDocCustVO().getShCustCntCd();
			String shCustSeq = blCustomerVO.getBlDocCustVO().getShCustSeq().replaceAll("^[0]*", "");
			String cnCustCntCd = blCustomerVO.getBlDocCustVO().getCnCustCntCd();
			String cnCustSeq = blCustomerVO.getBlDocCustVO().getCnCustSeq().replaceAll("^[0]*", "");
			String fwCustCntCd = blCustomerVO.getBlDocCustVO().getFfCustCntCd();
			String fwCustSeq = blCustomerVO.getBlDocCustVO().getFfCustSeq().replaceAll("^[0]*", "");
			String nfCustCntCd = blCustomerVO.getBlDocCustVO().getNfCustCntCd();
			String nfCustSeq = blCustomerVO.getBlDocCustVO().getNfCustSeq().replaceAll("^[0]*", "");

			if(!shCustCntCd.equals(shCustCntCdOld) || !shCustSeq.equals(shCustSeqOld)
					|| !cnCustCntCd.equals(cnCustCntCdOld) || !cnCustSeq.equals(cnCustSeqOld)
					|| !fwCustCntCd.equals(fwCustCntCdOld) || !fwCustSeq.equals(fwCustSeqOld)
					|| !nfCustCntCd.equals(nfCustCntCdOld) || !nfCustSeq.equals(nfCustSeqOld)
					|| !toOrdFlag.equals(toOrdFlagOld) ) {
				ofcChgFlag = "Y";
			}
			log.debug ("ofcChgFlag:"+ofcChgFlag);
			
			historyBC.manageBookingHistory("ESM_BKG_0079_05", historyTableVO, account);
			
			String alocPopFlg = "N";
			String firmMsgFlg = "N";
			AllocStsChgVO allocStsChgVO = new AllocStsChgVO();
			if(!shCustCntCd.equals(shCustCntCdOld) || !shCustSeq.equals(shCustSeqOld)){
				allocStsChgVO = receiptBC.manageAlocStatus(bkgBlNoVO, account, "");
				List<BkgNtcHisVO> bkgNtcHisVOs = allocStsChgVO.getBkgNtcHisVOs();
				if (null!=bkgNtcHisVOs) {
					historyBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0079_05");
				}
				alocPopFlg = allocStsChgVO.getAlocPopFlg();
				if(allocStsChgVO.getFirmMsgFlg() != null){
					firmMsgFlg = allocStsChgVO.getFirmMsgFlg();
				}
				// Allocation Status S->F 이면 Reciept Notice 발송
				// Allocation Status S->F 경우만 RcvrEml 에 값이 있음 
				// 삭제 예정
				if(allocStsChgVO.getRcvrEml() != null && allocStsChgVO.getRcvrEml().length() > 0){
					String mrdNm = "ESM_BKG_5005G";
					
					BkgBlNoVO[] bkgBlNoVOs = {bkgBlNoVO};
					String[]    eml        = {allocStsChgVO.getRcvrEml()};
					String[]    cct        = {""};
					String[]    docCct     = {""};
					String[]    rmk        = {""};
					
					BkgReceiptSendVO bkgReceiptSendVO = new BkgReceiptSendVO();
					bkgReceiptSendVO.setBkgBlNoVos(bkgBlNoVOs);
					bkgReceiptSendVO.setEmlAddrs(eml);
					bkgReceiptSendVO.setRemarks(rmk);
					bkgReceiptSendVO.setMrdNm(mrdNm);
					bkgReceiptSendVO.setCcts(cct);
					bkgReceiptSendVO.setDocCcts(docCct);
					GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
					List<BkgNtcHisVO> bkgNtcHisVOs2 = command.sendBkgReceiptByEmail(bkgReceiptSendVO, "", account);
					historyBC.createBkgNtcHis(bkgNtcHisVOs2, "ESM_BKG_0079_05");	
				}
				// Allocation Status History 
				if(allocStsChgVO != null){
					HistoryLineVO historyLineVO = new HistoryLineVO();
					historyLineVO.setUiId("ESM_BKG_0079_05");			
					historyLineVO.setHisCateNm("Booking Status");
					historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
					historyLineVO.setCaFlg(bkgBlNoVO.getCaFlg());
					if (allocStsChgVO == null || allocStsChgVO.getAlocStsCd() == null){
						log.debug("Null Check");
					} else if ((allocStsChgVO.getOriAlocStsCd() == null || "".equals(allocStsChgVO.getOriAlocStsCd())) && "S".equals(allocStsChgVO.getAlocStsCd())){
						historyLineVO.setCrntCtnt("Allocation Status change to S");
						historyBC.createBkgHistoryLine(historyLineVO, account);
					} else if ((allocStsChgVO.getOriAlocStsCd() == null || "".equals(allocStsChgVO.getOriAlocStsCd())) && "F".equals(allocStsChgVO.getAlocStsCd())){
						historyLineVO.setCrntCtnt("Allocation Status change to F");
						historyBC.createBkgHistoryLine(historyLineVO, account);	
					} else if ( "F".equals(allocStsChgVO.getOriAlocStsCd()) && "S".equals(allocStsChgVO.getAlocStsCd()) ){
						historyLineVO.setCrntCtnt("Allocation Status change F to S");
						historyBC.createBkgHistoryLine(historyLineVO, account);
					} else if ( "S".equals(allocStsChgVO.getOriAlocStsCd()) && "F".equals(allocStsChgVO.getAlocStsCd()) ){
						historyLineVO.setCrntCtnt("Allocation Status change S to F");
						historyBC.createBkgHistoryLine(historyLineVO, account);
					}
				}
				// Allocation Status History 끝
			}
			
			// c/a 진행중에는 i/b arrival notice 관련 값을 update하지 않음 
			if(!"Y".equals(bkgBlNoVO.getCaFlg())){
				// i/b code validation 초기화
				if(ibCustCdVal){
					receiptBC.cancelCustCdVal(bkgNo);					
					ArrivalNoticeBC anBC = new ArrivalNoticeBCImpl();
					anBC.cancelArrNtcCustCdVal(bkgNo);
				}
			}
//			if ("Y".equalsIgnoreCase(ofcChgProcVO.getOfcChgPpdProc()) || "Y".equalsIgnoreCase(ofcChgProcVO.getOfcChgCctProc())) {
//				BkgModiOfcPrcVO bkgModiOfcPrcVO = new BkgModiOfcPrcVO();
//				bkgModiOfcPrcVO.setInBkgNo(bkgNo);
//				bkgModiOfcPrcVO.setInCaFlg(bkgBlNoVO.getCaFlg());
//				bkgModiOfcPrcVO.setInPpdFlg(ofcChgProcVO.getOfcChgPpdProc());
//				bkgModiOfcPrcVO.setInCctFlg(ofcChgProcVO.getOfcChgCctProc());
//				(new BlRatingBCImpl()).callBkgModiChgOfcPrc(bkgModiOfcPrcVO);
//			}

			commit();

			// 2014.11.03 [CHM-201431658] 한진해운 조기결산을 위한 개선 방안 중 BKG 관리 프로세스 단축(안) 개발(S)
			String oldNoRtStsCd = "";
			if(historyTableVO.getBkgBookingVO().getNonRtStsCd()!=null){
				oldNoRtStsCd = historyTableVO.getBkgBookingVO().getNonRtStsCd();
			}
			String newNoRtStsCd = "";
			//String noRtNtc_snd_flg = "N";
			String sc_no  = historyTableVO.getBkgBookingVO().getScNo();
			String rfa_no = historyTableVO.getBkgBookingVO().getRfaNo();
			String taa_no = historyTableVO.getBkgBookingVO().getTaaNo();
			OftPrecheckVO oftPrecheckVO = new OftPrecheckVO();
			try{//기존 별도 트랜젝션으로 화면에서 호출 하던 부분	
				begin();
				if(rfa_no!=null && rfa_no.length() > 2 ){
					oftPrecheckVO = searchRfaOftPrecheckResult(bkgBlNoVO, rfa_no, account);
				}else if(sc_no!=null && sc_no.length() > 2 ){
					oftPrecheckVO = searchScOftPrecheckResult(bkgBlNoVO, sc_no, account);
				}else if(taa_no!=null && taa_no.length() > 2 ){
					oftPrecheckVO = searchTaaOftPrecheckResult(bkgBlNoVO, taa_no, account);
				}else{
					oftPrecheckVO.setNonRtStsCd("R");
					oftPrecheckVO.setChkOft("");
					oftPrecheckVO.setApplicationDt("");
					oftPrecheckVO.setFrtTermCd("");
					oftPrecheckVO.setSvcScpCd("");
				}
			}catch(EventException ex){
				log.error("No Rate Status check Error : "+bkgBlNoVO.getBkgNo(), ex);
				oftPrecheckVO.setNonRtStsCd("");
				oftPrecheckVO.setChkOft("");
				oftPrecheckVO.setApplicationDt("");
				oftPrecheckVO.setFrtTermCd("");
				oftPrecheckVO.setSvcScpCd("");
			}

			// CMPB 산출
			try{
				if("Y".equals(oftPrecheckVO.getChkOft()) ){
					BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
					bkgHrdCdgCtntListCondVO.setHrdCdgId("NO_RATE_PROC_CTR");			
					List<BkgHrdCdgCtntVO> BkgHrdCdgCtntVOs = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
					
					String createCmpb = "";
					if(BkgHrdCdgCtntVOs.size() > 0){
						createCmpb = BkgHrdCdgCtntVOs.get(0).getAttrCtnt4();// BKG modify CMPB 생성
					}
					if(!"N".equals(createCmpb)){
						//createContributionMarginPerBox(bkgBlNoVO);
						// 2015.12.03 [CHM-201538812] MAS time out 방지위해 1,2 로 나눔
						BkgCmpbVO BkgCmpbVO = createContributionMarginPerBox1(bkgBlNoVO, oftPrecheckVO);
						commit();
						begin();
						createContributionMarginPerBox2(bkgBlNoVO,BkgCmpbVO);
					}
				}
				commit();
			}catch(EventException ex){
				log.error("create CMPB Error : "+bkgBlNoVO.getBkgNo(), ex);
				rollback();
			}			
			
			// No Rate Status 한번 F(Firm) 되면 바꾸지 않음
			String noRateEdiFlg = "N";
			if(oftPrecheckVO!=null && oftPrecheckVO.getNonRtStsCd()!=null && !oldNoRtStsCd.equals("F") && !oldNoRtStsCd.equals(oftPrecheckVO.getNonRtStsCd())){
				begin();
				newNoRtStsCd = oftPrecheckVO.getNonRtStsCd();
				//no_rt_sts_cd Update
				int updCnt = receiptBC.modifyNoRtStsCd(bkgBlNoVO, newNoRtStsCd, account);
				// History 
				if(updCnt > 0){
					HistoryLineVO historyLineVO = new HistoryLineVO();
					historyLineVO.setUiId("ESM_BKG_0079_05");			
					historyLineVO.setHisCateNm("No Rate Status");
					historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
					historyLineVO.setCaFlg(bkgBlNoVO.getCaFlg());
					historyLineVO.setPreCtnt(oldNoRtStsCd);
					historyLineVO.setCrntCtnt(newNoRtStsCd);
					historyBC.createBkgHistoryLine(historyLineVO, account);
					
					// Customer Information 에선 !R -> R : No Rate Notice 발송 케이스 없음
					// 하지만!! EDI 는 있음 마치 메인에서 보낸 것 처럼
					// 메시지
					if("F".equals(oftPrecheckVO.getNonRtStsCd()) && "R".equals(oldNoRtStsCd)){
						eventResponse.setETCData("non_rate_msg_flg", "Y");
						noRateEdiFlg = "Y";
					}
				}
				commit();
			}
			
			// [CHM-201640340] 미주발(US/CA) 은 VVD 변경 때에만 재계산
			// SPC-BKG 연동 (NoRateStatus Firm 일 때만 SPC Aloc 체크)
			if("F".equals(oldNoRtStsCd) || "F".equals(newNoRtStsCd)){
				if((!"F".equalsIgnoreCase(historyTableVO.getBkgBookingVO().getAlocStsCd())) 
					||(  (!"US".equals(historyTableVO.getBkgBookingVO().getPolCd().substring(0,2))
						   && !"CA".equals(historyTableVO.getBkgBookingVO().getPolCd().substring(0,2))
						  )
						&&  (!"TPW".equals(historyTableVO.getBkgBookingVO().getSvcScpCd())
							&&!"AEE".equals(historyTableVO.getBkgBookingVO().getSvcScpCd())
							&&!"SAW".equals(historyTableVO.getBkgBookingVO().getSvcScpCd())
							&&!"BRE".equals(historyTableVO.getBkgBookingVO().getSvcScpCd())
							&&!"MXW".equals(historyTableVO.getBkgBookingVO().getSvcScpCd())
						    )
						   &&((!shCustCntCd.equals(shCustCntCdOld) || !shCustSeq.equals(shCustSeqOld))
							  ||(!cnCustCntCd.equals(cnCustCntCdOld) || !cnCustSeq.equals(cnCustSeqOld))
							  ||(!event.getOldActCustCd().equals(event.getNewActCustCd()))
							  )
					  )
				){
					ConstraintMasterBC		spcBC = new ConstraintMasterBCImpl();	
					List<SpcSbBkgDtlVO> spcSbBkgDtlVO = new ArrayList<SpcSbBkgDtlVO>();
					boolean spcErrFlg = false;
					try{
						begin();
						spcSbBkgDtlVO = spcBC.standbyCheck4Bkg(bkgBlNoVO.getBkgNo(), account);
						commit();
					} catch(Exception spcEx){
						rollback();
						log.error("SPC Allocation error : " + spcEx.toString(), spcEx);
						spcErrFlg = true;
					}
					begin();
					if(spcErrFlg){
						//Error
						AllocStsVO allocStsVO = new AllocStsVO();
						allocStsVO.setAlocStsCd("");
						AllocStsChgVO allocStsChgVO2 = receiptBC.modifyAllocStatusForBkg(bkgBlNoVO, allocStsVO, account);
						// history
						HistoryLineVO historyLineVO = new HistoryLineVO();
						historyLineVO.setUiId("ESM_BKG_0079_05");			
						historyLineVO.setHisCateNm("Allocation Status");
						historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
						historyLineVO.setCaFlg("N");
						historyLineVO.setCrntCtnt("Error");
						historyLineVO.setPreCtnt(allocStsChgVO2.getOriAlocStsCd());
						historyBC.createBkgHistoryLine(historyLineVO, account);
						
					}else if(spcSbBkgDtlVO == null || spcSbBkgDtlVO.size()==0){
						//F
						AllocStsVO allocStsVO = new AllocStsVO();
						allocStsVO.setAlocStsCd("F");
						AllocStsChgVO allocStsChgVO2 = receiptBC.modifyAllocStatusForBkg(bkgBlNoVO, allocStsVO, account);
						// history
						if(!allocStsChgVO2.getAlocStsCd().equals(allocStsChgVO2.getOriAlocStsCd())){
							HistoryLineVO historyLineVO = new HistoryLineVO();
							historyLineVO.setUiId("ESM_BKG_0079_05");			
							historyLineVO.setHisCateNm("Allocation Status");
							historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
							historyLineVO.setCaFlg("N");
							historyLineVO.setCrntCtnt("F");
							historyLineVO.setPreCtnt(allocStsChgVO2.getOriAlocStsCd());
							historyBC.createBkgHistoryLine(historyLineVO, account);
						}
						if(allocStsChgVO2.getBkgNtcHisVOs().size()>0){
							historyBC.createBkgNtcHis(allocStsChgVO2.getBkgNtcHisVOs(), "ESM_BKG_0079_05");
						}
					}else if(spcSbBkgDtlVO != null && spcSbBkgDtlVO.size()>0){
						//A ,기존 Allocation 로직이 우선, 기존 로직으로 Standby 걸리지 않을 때만 SPC 로직 적용
						if(allocStsChgVO==null || allocStsChgVO.getAlocStsCd()==null || !"S".equals(allocStsChgVO.getAlocStsCd())){
							AllocStsVO allocStsVO = new AllocStsVO();
							for(int i=0; i<spcSbBkgDtlVO.size(); i++){
		 						if(spcSbBkgDtlVO.get(i).getAlocSvcCd()!=null && "M".equals(spcSbBkgDtlVO.get(i).getAlocSvcCd())){
		 							alocPopFlg = "Y";
		 							allocStsVO.setAlocSvcCd("M");
		 						}
		 					}
	//						if(!"US".equals(historyTableVO.getBkgBookingVO().getPolCd().substring(0,2))
	//								&& !"CA".equals(historyTableVO.getBkgBookingVO().getPolCd().substring(0,2))){
	//							allocStsVO.setAlocStsCd("A");
	//						}else{
								allocStsVO.setAlocStsCd("S");
	//							if(!"Y".equals(alocPopFlg)){ 
	//								allocStsVO.setStandbyNtcFlg("Y");
	//							}
	//						}
							AllocStsChgVO allocStsChgVO2 = receiptBC.modifyAllocStatusForBkg(bkgBlNoVO, allocStsVO, account);
							// history
							if(!allocStsChgVO2.getAlocStsCd().equals(allocStsChgVO2.getOriAlocStsCd())){
								StringBuffer tmpBuffer = new StringBuffer(allocStsVO.getAlocStsCd());
								for(int i=0; i<spcSbBkgDtlVO.size(); i++){
									tmpBuffer.append("\n");
									tmpBuffer.append((spcSbBkgDtlVO.get(i).getLstSbRsnTpCd()==null)?"":spcSbBkgDtlVO.get(i).getLstSbRsnTpCd()).append("/");
									tmpBuffer.append((spcSbBkgDtlVO.get(i).getLstSbSubRsnCd()==null)?"":spcSbBkgDtlVO.get(i).getLstSbSubRsnCd()).append("/");
									tmpBuffer.append((spcSbBkgDtlVO.get(i).getAlocSvcCd()==null)?"":spcSbBkgDtlVO.get(i).getAlocSvcCd()).append("/");
									tmpBuffer.append((spcSbBkgDtlVO.get(i).getLstSbRsn()==null)?"":spcSbBkgDtlVO.get(i).getLstSbRsn());
								}
								HistoryLineVO historyLineVO = new HistoryLineVO();
								historyLineVO.setUiId("ESM_BKG_0079_05");			
								historyLineVO.setHisCateNm("Allocation Status");
								historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
								historyLineVO.setCaFlg("N");
								historyLineVO.setCrntCtnt(tmpBuffer.toString());
								historyBC.createBkgHistoryLine(historyLineVO, account);
								
								firmMsgFlg = allocStsChgVO2.getFirmMsgFlg();
							}
							if(allocStsChgVO2.getBkgNtcHisVOs().size()>0){
								historyBC.createBkgNtcHis(allocStsChgVO2.getBkgNtcHisVOs(), "ESM_BKG_0079_01");
							}
							
						}
					}
					commit();
				}
			}
			// SPC-BKG 연동 (NoRateStatus Firm 일 때만 SPC Aloc 체크)(E)
			//(E)
			
			// c/a 진행중에는 edi 전송과 inv i/f를 처리하지 않음 
			if(!"Y".equals(bkgBlNoVO.getCaFlg())){	
				begin();
				
				if( "Y".equals(noRateEdiFlg) &&	!"Y".equals(historyTableVO.getBkgBookingVO().getEdiHldFlg())){
				// noRateEdiFlg 가 Y 면 EDI 최초 전송임
					// 07. sendBkgCustEdi(전용진수석님 호출)
					searchBC.createCustBkgReceiptEdiBackEnd(bkgBlNoVO, null, "Y", account);

					// 08. sendBkgTmlEdi(전용진수석님 호출)
					// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
					Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
					vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
					vender301ParamVO.setOldVvdVOs(null);
					vender301ParamVO.setOldQtyVOs(new ArrayList<BkgQuantityVO>());
					vender301ParamVO.setOldMtyPkupYdCd(null);
					vender301ParamVO.setBracCd("N");
					vender301ParamVO.setEdiKind("BT");
					vender301ParamVO.setAutoManualFlg("Y");
					searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);
					commit();
					
					// 0.9 psa I/f 대상 자동 전송부분 추가함. ( 전성진수석 요청 - 2010.08.20 - Ticket ID : CHM-201005191-01 )
					if("SGSIN".equals(historyTableVO.getBkgBookingVO().getPolCd())){
						this.managePSABKGAuto(bkgBlNoVO.getBkgNo(), "N");/// 비긴 커밋 밖으로 빼야 함
					}
					
					begin();
				}else if(!"CNHKG".equals(event.getCustEtcVO().getPolCd())){ // CNHKG만 제외
//					if(bkgNo.length() > 12 || (bkgNo.length() == 12 && !"00".equals(bkgNo.substring(11)))){
						// 13. sendBkgTmlEdi(전용진수석님 호출)
						// 20091127 BackEndJob으로 변경
						// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
						Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
						vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
						vender301ParamVO.setOldVvdVOs(null);
						vender301ParamVO.setOldQtyVOs(null);
						vender301ParamVO.setOldMtyPkupYdCd(null);
						vender301ParamVO.setBracCd("U");
						vender301ParamVO.setEdiKind("BT");
						vender301ParamVO.setAutoManualFlg("Y");
					
						searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);					
//					}
				}
				
				// MAS I/F 추가
				CostAssignBC masBc = new CostAssignBCImpl();
				MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
				masBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
				masBkgComIfVo.setCostSrcSysCd("BKG");
				masBkgComIfVo.setIfRmk("Customer Update");
				masBkgComIfVo.setCreUsrId(account.getUsr_id());
				masBkgComIfVo.setUpdUsrId(account.getUsr_id());			
				masBc.modifyMasDailyInterface(masBkgComIfVo);
				
				// interfaceBkgARInvoiceToINV 호출
				interfaceToInv(bkgBlNoVO, account);
								
				commit();
			}
			
			if(alertMsg != null && alertMsg.length > 0){
				for(int i = 0 ; i < alertMsg.length ; i++){
					eventResponse.setUserMessage(new ErrorHandler(alertMsg[i]).getUserMessage());		
				}
			}
			
			eventResponse.setETCData("aloc_pop_flg", alocPopFlg);
			eventResponse.setETCData("firm_msg_flg", firmMsgFlg);
			eventResponse.setETCData("ofcChgFlag", ofcChgFlag);
			eventResponse.setETCData("SuccessYn", "Y");
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
	
		return eventResponse;
	}   

	/**
	 * ESM_BKG_0890 : open <br>
	 * Cargo Detail Information 조회 <br>)
	 * 
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgQtyDtl(Event e) throws EventException{
		try{
			EsmBkg0890Event event = (EsmBkg0890Event)e;
			
			BookingUtil utilBC = new BookingUtil();
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();

			GeneralEventResponse eventResponse = new GeneralEventResponse();		
			
			// 01. Combo 데이터 조회 (RTerm)
			List<BkgComboVO> rTterm  = utilBC.searchCombo("CD02192");
			eventResponse.setRsVoList(rTterm);
			// 02. Combo 데이터 조회 (DTerm)
			List<BkgComboVO> dTerm  = utilBC.searchCombo("CD02191");		
			eventResponse.setRsVoList(dTerm);				
			
			// 03. Cargo Detail Information 조회
			CargoDetailVO cargeDetailVO = receiptBC.searchCargoDetail(event.getBkgBlNoVO());
			
			List<BkgQuantityVO> bkgQuantity = cargeDetailVO.getBkgQuantity();
			List<BkgQtyDtlVO> bkgQtyDtl = cargeDetailVO.getBkgQtyDtl();
			CargoDtlEtcVO cargoDtlEtcVO = cargeDetailVO.getCargoDtlEtcVO();
			
			eventResponse.setRsVoList(bkgQtyDtl);
			
			if(!"B".equals(event.getCallTp())){
				eventResponse.setRsVoList(bkgQuantity);

				if(cargoDtlEtcVO != null){
					eventResponse.setETCData(cargoDtlEtcVO.getColumnValues());	
				}					
			}

			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}		

	/**
	 * ESM_BKG_0890 : save <br>
	 * Cargo Detail Information 정보 저장 <br>
	 * 
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBkgQtyDtl(Event e) throws EventException{
		EsmBkg0890Event event = (EsmBkg0890Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		try{
			begin();			
			
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
			BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
			// 9. searchOldBkgForHistory
			HistoryTableVO historyTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0890", event.getBkgBlNoVO());
			
			// 10. manageBkgQtyDtl
			receiptBC.manageBkgQtyDtl(event.getBkgQtyDtlVOs(), event.getBkgBlNoVO(), account);
			
			// 13. manageBookingHistory
			historyBC.manageBookingHistory("ESM_BKG_0890", historyTableVO, account);

			commit();
			eventResponse.setETCData("SuccessYn", "Y");
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
	}	

	/**
	 * ESM_BKG_0732 : open <br>
	 * BKG의 컨테이너 목록을 조회한다.<br>
	 * 
	 * @author	Jun Yong Jin
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchCntrListForCombine(Event e) throws EventException{
		EsmBkg0732Event event = (EsmBkg0732Event)e;
		GeneralBookingSplitCombineBC command = new GeneralBookingSplitCombineBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<CntrListForCombineVO> list =  command.searchCntrListForCombine(event.getBkgBlNoVO());			
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}		
		
		return eventResponse;
	}		

	/**
	 * ESM_BKG_0974 : retrieve <br>
	 * Combine할 Booking List를 조회한다.<br>
	 * 
	 * @author	Jun Yong Jin
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchBkgListForMstBkgSelect(Event e) throws EventException{
		try{
			EsmBkg0974Event event = (EsmBkg0974Event)e;
			GeneralBookingSplitCombineBC command = new GeneralBookingSplitCombineBCImpl();
			List<BkgListForMstBkgSelectVO> list =  command.searchBkgListForMstBkgSelect(event.getBkgBlNoVOs());
	
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
	 * ESM_BKG_0614 : RETRIEVE <br>
	 * Booking 리스트를 조회한다.(ESM_BKG_0614)<br>
	 *  
	 * @author	Jun Yong Jin
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchBkgListForWorkWithBkg(Event e) throws EventException{
		try{
			EsmBkg0614Event event = (EsmBkg0614Event)e;
			GeneralBookingListSearchBC command = new GeneralBookingListSearchBCImpl();
			// bkg_no가 넘어온 경우 bkg_no만 VO에 담고 나머지는 초기화 - bkg_no만 조회 시
			BkgListForWorkWithBkgInputVO bkgListForWorkWithBkgInputTmpVO = event.getBkgListForWorkWithBkgInputVO();
			BkgListForWorkWithBkgInputVO bkgListForWorkWithBkgInputVO = new BkgListForWorkWithBkgInputVO();
			if ( !isNull(event.getBkgListForWorkWithBkgInputVO().getBkgNo()) ) {
	        	bkgListForWorkWithBkgInputVO.setBkgNo(bkgListForWorkWithBkgInputTmpVO.getBkgNo());
	        } else bkgListForWorkWithBkgInputVO = bkgListForWorkWithBkgInputTmpVO;
	
			List<BkgListForWorkWithBkgVO> list = command.searchBkgListForWorkWithBkg(bkgListForWorkWithBkgInputVO);
	
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
	 * ESM_BKG_0098 : retrieve <br>
	 * booking receipt 전송 대상 Booking 리스트를 조회한다.<br>
	 * 
	 * @author	Jun Yong Jin
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchBkgListForBkgReceiptNtc(Event e) throws EventException{		
		try{
			EsmBkg0098Event event = (EsmBkg0098Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			GeneralBookingListSearchBC command = new GeneralBookingListSearchBCImpl();
			
			// bkg_no가 넘어온 경우 bkg_no만 VO에 담고 나머지는 초기화 - bkg_no만 조회 시
			BkgListForBkgReceiptInputVO bkgListForBkgReceiptInputTmpVO = event.getBkgListForBkgReceiptInputVO();
			BkgListForBkgReceiptInputVO bkgListForWorkWithBkgInputVO = new BkgListForBkgReceiptInputVO();
			if ( !isNull(event.getBkgListForBkgReceiptInputVO().getBkgNo()) ) {
				bkgListForWorkWithBkgInputVO.setBkgNo(bkgListForBkgReceiptInputTmpVO.getBkgNo());
	        } else bkgListForWorkWithBkgInputVO = bkgListForBkgReceiptInputTmpVO;
	
			BkgReceiptListVO bkgReceiptListVO = command.searchBkgListForBkgReceiptNtc(bkgListForWorkWithBkgInputVO);
			List<BkgListForBkgReceiptVO> list = bkgReceiptListVO.getBkgListForBkgReceiptVOs();
			List<BkgListForBkgReceiptCntVO> cnt = bkgReceiptListVO.getBkgListForBkgReceiptCntVOs();
			
			eventResponse.setRsVoList(list);
	
			// 통계성 정보 취합 - ETC Data로 넘김
			if (null!=cnt && 0<cnt.size()) {
				BkgListForBkgReceiptCntVO cntVO = cnt.get(0);
				eventResponse.setETCData("faxBkgTotal",cntVO.getFaxBkgTotal());
				eventResponse.setETCData("faxTotal"   ,cntVO.getFaxTotal());
				eventResponse.setETCData("faxSuccess" ,cntVO.getFaxSuccess());
				eventResponse.setETCData("faxSending" ,cntVO.getFaxSending());
				eventResponse.setETCData("faxUnSent"  ,String.valueOf(Integer.parseInt(cntVO.getFaxNoSend())+Integer.parseInt(cntVO.getFaxFailed()))
						                              +" (No Send : "+cntVO.getFaxNoSend()+" / Failed : "+cntVO.getFaxFailed()+")");
				eventResponse.setETCData("emlBkgTotal",cntVO.getEmlBkgTotal());
				eventResponse.setETCData("emlTotal"   ,cntVO.getEmlTotal());
				eventResponse.setETCData("emlSuccess" ,cntVO.getEmlSuccess());
				eventResponse.setETCData("emlSending" ,cntVO.getEmlSending());
				eventResponse.setETCData("emlUnSent"  ,String.valueOf(Integer.parseInt(cntVO.getEmlNoSend())+Integer.parseInt(cntVO.getEmlFailed()))
													  +" (No Send : "+cntVO.getEmlNoSend()+" / Failed : "+cntVO.getEmlFailed()+")");
			} else {
				eventResponse.setETCData("faxBkgTotal","0");
				eventResponse.setETCData("faxTotal"   ,"0");
				eventResponse.setETCData("faxSuccess" ,"0");
				eventResponse.setETCData("faxSending" ,"0");
				eventResponse.setETCData("faxUnSent"  ,"0 (No Send : 0 / Failed : 0)");
				eventResponse.setETCData("emlBlTotal" ,"0");
				eventResponse.setETCData("emlTotal"   ,"0");
				eventResponse.setETCData("emlSuccess" ,"0");
				eventResponse.setETCData("emlSending" ,"0");
				eventResponse.setETCData("emlUnSent"  ,"0 (No Send : 0 / Failed : 0)");
			}
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

	private boolean isNull(String str) {
        return (str==null || str.trim().length()==0 || "null".equals(str));
    }

	/**
	 * ESM_BKG_0098 : fax <br>
	 * Booking 리스트에서 5005RD를 FAX로 발송한다.<br>
	 * 
	 * @author	Jun Yong Jin
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse sendBkgReceiptByFax(Event e) throws EventException {
		EsmBkg0098Event event = (EsmBkg0098Event)e;
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralBookingReceiptBC command2 = new GeneralBookingReceiptBCImpl();
		BookingUtil utilBC = new BookingUtil();
		BkgClzTmVO bkgClzTmVO = null;
		BkgClzTmVO[] bkgClzTmVOs = null;
		HistoryTableVO historyTableVO = null;
		try{
			begin();
			BkgBlNoVO[] bkgBlNoVOs = event.getBkgBlNoVOs();
			if (bkgBlNoVOs.length > 0) {
				for (int i=0; i<bkgBlNoVOs.length; i++) {
					if("Y".equals(utilBC.searchNoRateBlockFlg(bkgBlNoVOs[i]))){
						throw new EventException(new ErrorHandler("BKG08333",new String[]{bkgBlNoVOs[i].getBkgNo()}).getMessage());
					}
					if("Y".equals(utilBC.searchStandbyBlockFlg(bkgBlNoVOs[i]))){
						throw new EventException(new ErrorHandler("BKG08284",new String[]{bkgBlNoVOs[i].getBkgNo()}).getMessage());
					}
				}
			}
			if (bkgBlNoVOs.length > 0) {
				for (int i=0; i<bkgBlNoVOs.length; i++) {
					bkgBlNoVOs[i].setCaFlg("N");

					bkgClzTmVOs = new BkgClzTmVO[2];
					bkgClzTmVO = new BkgClzTmVO();
					bkgClzTmVO.setBkgNo(bkgBlNoVOs[i].getBkgNo());
					bkgClzTmVO.setClzTpCd("T");
					bkgClzTmVO.setMnlSetDt(event.getCct()[i].replaceAll("-","").replaceAll(":","").replaceAll(" ",""));
					bkgClzTmVO.setNtcFlg("Y");
					bkgClzTmVO.setUpdUsrId(account.getUsr_id());
					bkgClzTmVOs[0] = bkgClzTmVO;

					bkgClzTmVO = new BkgClzTmVO();
					bkgClzTmVO.setBkgNo(bkgBlNoVOs[i].getBkgNo());
					bkgClzTmVO.setClzTpCd("D");
					bkgClzTmVO.setMnlSetDt(event.getDocCct()[i].replaceAll("-","").replaceAll(":","").replaceAll(" ",""));
					bkgClzTmVO.setNtcFlg("Y");
					bkgClzTmVO.setUpdUsrId(account.getUsr_id());
					bkgClzTmVOs[1] = bkgClzTmVO;

					historyTableVO = bkgHisCmd.searchOldBkgForHistory("ESM_BKG_0721", bkgBlNoVOs[i]);
					command2.manageCargoClosingTime(bkgClzTmVOs, account);
					
					// [CHM-201640257] booking receipt notice(fax/edi)에 Edit Rail Cut-off 기능 추가
					// Rail Cut-Off 는 manula 값이 있을 때만 update\
					// Vgm Cut-Off 는 manual 값이 있을 때만 update  					
					List<BkgClzTmVO> bkgClzTmList = new ArrayList<BkgClzTmVO>();
					if(event.getMnlRailFromCct()[i].length() > 0){
						bkgClzTmVO = new BkgClzTmVO();
						bkgClzTmVO.setBkgNo(bkgBlNoVOs[i].getBkgNo());
						bkgClzTmVO.setClzTpCd("F");
						bkgClzTmVO.setMnlSetDt(event.getMnlRailFromCct()[i].replaceAll("-","").replaceAll(":","").replaceAll(" ",""));
						bkgClzTmVO.setNtcFlg("Y");
						bkgClzTmVO.setUpdUsrId(account.getUsr_id());
						bkgClzTmList.add(bkgClzTmVO);
					}
						if(event.getMnlRailToCct()[i].length() > 0){
						bkgClzTmVO = new BkgClzTmVO();
						bkgClzTmVO.setBkgNo(bkgBlNoVOs[i].getBkgNo());
						bkgClzTmVO.setClzTpCd("O");
						bkgClzTmVO.setMnlSetDt(event.getMnlRailToCct()[i].replaceAll("-","").replaceAll(":","").replaceAll(" ",""));
						bkgClzTmVO.setNtcFlg("Y");
						bkgClzTmVO.setUpdUsrId(account.getUsr_id());
						bkgClzTmList.add(bkgClzTmVO);
					}
						if(event.getMnlVgmCct()[i].length() > 0){
						bkgClzTmVO = new BkgClzTmVO();
						bkgClzTmVO.setBkgNo(bkgBlNoVOs[i].getBkgNo());
						bkgClzTmVO.setClzTpCd("V");
						bkgClzTmVO.setMnlSetDt(event.getMnlVgmCct()[i].replaceAll("-","").replaceAll(":","").replaceAll(" ",""));
						bkgClzTmVO.setNtcFlg("Y");
						bkgClzTmVO.setUpdUsrId(account.getUsr_id());
						bkgClzTmList.add(bkgClzTmVO);
				    }		
						
					if(bkgClzTmList.size() > 0){
						BkgClzTmVO[] bkgClzTmVOs2 =  new BkgClzTmVO[bkgClzTmList.size()];
						for(int j=0 ; j<bkgClzTmList.size(); j++){
							bkgClzTmVOs2[j] = bkgClzTmList.get(j);
						}
						command2.manageCargoClosingTime(bkgClzTmVOs2, account);
					}
										
					bkgHisCmd.manageBookingHistory("ESM_BKG_0721", historyTableVO, account);
				}
				BkgReceiptSendVO bkgReceiptSendVO = new BkgReceiptSendVO();
				bkgReceiptSendVO.setBkgBlNoVos(bkgBlNoVOs);
				bkgReceiptSendVO.setFaxNos(event.getFax());
				bkgReceiptSendVO.setRemarks(event.getRemark());
				bkgReceiptSendVO.setMrdNm(event.getMrdNm());
				bkgReceiptSendVO.setCcts(event.getCct());
				bkgReceiptSendVO.setDocCcts(event.getDocCct());
				List<BkgNtcHisVO> bkgNtcHisVOs = command.sendBkgReceiptByFax(bkgReceiptSendVO, account);
				bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0098");
			}
			commit();
			eventResponse.setETCData("SuccessYn", "Y");
		} catch(EventException ex) {
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
	 * ESM_BKG_0098 : email <br>
	 * Booking 리스트에서 5005RD를 Mail로 발송한다.<br>
	 * 
	 * @author	Jun Yong Jin
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse sendBkgReceiptByEmail(Event e) throws EventException {
		EsmBkg0098Event event = (EsmBkg0098Event)e;
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralBookingReceiptBC command2 = new GeneralBookingReceiptBCImpl();
		BookingUtil utilBC = new BookingUtil();
		BkgClzTmVO bkgClzTmVO = null;
		BkgClzTmVO[] bkgClzTmVOs = null;
		BkgBlNoVO[] bkgBlNoVOs = null;
		HistoryTableVO historyTableVO = null;
		try{
			begin();
			bkgBlNoVOs = event.getBkgBlNoVOs();
			if (bkgBlNoVOs.length > 0) {
				for (int i=0; i<bkgBlNoVOs.length; i++) {
					if("Y".equals(utilBC.searchNoRateBlockFlg(bkgBlNoVOs[i]))){
						throw new EventException(new ErrorHandler("BKG08333",new String[]{bkgBlNoVOs[i].getBkgNo()}).getMessage());
					}
					if("Y".equals(utilBC.searchStandbyBlockFlg(bkgBlNoVOs[i]))){
						throw new EventException(new ErrorHandler("BKG08284",new String[]{bkgBlNoVOs[i].getBkgNo()}).getMessage());
					}
				}
			}
			if (bkgBlNoVOs.length > 0) {
				for (int i=0; i<bkgBlNoVOs.length; i++) {					
					bkgBlNoVOs[i].setCaFlg("N");

					bkgClzTmVOs = new BkgClzTmVO[2];
					bkgClzTmVO = new BkgClzTmVO();
					bkgClzTmVO.setBkgNo(bkgBlNoVOs[i].getBkgNo());
					bkgClzTmVO.setClzTpCd("T");
					bkgClzTmVO.setMnlSetDt(event.getCct()[i].replaceAll("-","").replaceAll(":","").replaceAll(" ",""));
					bkgClzTmVO.setNtcFlg("Y");
					bkgClzTmVO.setUpdUsrId(account.getUsr_id());
					bkgClzTmVOs[0] = bkgClzTmVO;

					bkgClzTmVO = new BkgClzTmVO();
					bkgClzTmVO.setBkgNo(bkgBlNoVOs[i].getBkgNo());
					bkgClzTmVO.setClzTpCd("D");
					bkgClzTmVO.setMnlSetDt(event.getDocCct()[i].replaceAll("-","").replaceAll(":","").replaceAll(" ",""));
					bkgClzTmVO.setNtcFlg("Y");
					bkgClzTmVO.setUpdUsrId(account.getUsr_id());
					bkgClzTmVOs[1] = bkgClzTmVO;

					historyTableVO = bkgHisCmd.searchOldBkgForHistory("ESM_BKG_0721", bkgBlNoVOs[i]);
					command2.manageCargoClosingTime(bkgClzTmVOs, account);
					
					
					// [CHM-201640257] booking receipt notice(fax/edi)에 Edit Rail Cut-off 기능 추가
					// Rail Cut-Off 는 manula 값이 있을 때만 update
					// Vgm Cut-Off 는 manual 값이 있을 때만 update  
					List<BkgClzTmVO> bkgClzTmList = new ArrayList<BkgClzTmVO>();
					if(event.getMnlRailFromCct()[i].length() > 0){
						bkgClzTmVO = new BkgClzTmVO();
						bkgClzTmVO.setBkgNo(bkgBlNoVOs[i].getBkgNo());
						bkgClzTmVO.setClzTpCd("F");
						bkgClzTmVO.setMnlSetDt(event.getMnlRailFromCct()[i].replaceAll("-","").replaceAll(":","").replaceAll(" ",""));
						bkgClzTmVO.setNtcFlg("Y");
						bkgClzTmVO.setUpdUsrId(account.getUsr_id());
						bkgClzTmList.add(bkgClzTmVO);
					}
						if(event.getMnlRailToCct()[i].length() > 0){
						bkgClzTmVO = new BkgClzTmVO();
						bkgClzTmVO.setBkgNo(bkgBlNoVOs[i].getBkgNo());
						bkgClzTmVO.setClzTpCd("O");
						bkgClzTmVO.setMnlSetDt(event.getMnlRailToCct()[i].replaceAll("-","").replaceAll(":","").replaceAll(" ",""));
						bkgClzTmVO.setNtcFlg("Y");
						bkgClzTmVO.setUpdUsrId(account.getUsr_id());
						bkgClzTmList.add(bkgClzTmVO);
					}
						if(event.getMnlVgmCct()[i].length() > 0){
						bkgClzTmVO = new BkgClzTmVO();
						bkgClzTmVO.setBkgNo(bkgBlNoVOs[i].getBkgNo());
						bkgClzTmVO.setClzTpCd("V");
						bkgClzTmVO.setMnlSetDt(event.getMnlVgmCct()[i].replaceAll("-","").replaceAll(":","").replaceAll(" ",""));
						bkgClzTmVO.setNtcFlg("Y");
						bkgClzTmVO.setUpdUsrId(account.getUsr_id());
						bkgClzTmList.add(bkgClzTmVO);
					}
					if(bkgClzTmList.size() > 0){
						BkgClzTmVO[] bkgClzTmVOs2 =  new BkgClzTmVO[bkgClzTmList.size()];
						for(int j=0 ; j<bkgClzTmList.size(); j++){
							bkgClzTmVOs2[j] = bkgClzTmList.get(j);
						}
						command2.manageCargoClosingTime(bkgClzTmVOs2, account);
					}
										
					bkgHisCmd.manageBookingHistory("ESM_BKG_0721", historyTableVO, account);
				}
				BkgReceiptSendVO bkgReceiptSendVO = new BkgReceiptSendVO();
				bkgReceiptSendVO.setBkgBlNoVos(bkgBlNoVOs);
				bkgReceiptSendVO.setEmlAddrs(event.getEml());
				bkgReceiptSendVO.setRemarks(event.getRemark());
				bkgReceiptSendVO.setMrdNm(event.getMrdNm());
				bkgReceiptSendVO.setCcts(event.getCct());
				bkgReceiptSendVO.setDocCcts(event.getDocCct());
				List<BkgNtcHisVO> bkgNtcHisVOs = command.sendBkgReceiptByEmail(bkgReceiptSendVO,"", account);
				if (null!=bkgNtcHisVOs && 0<bkgNtcHisVOs.size()) {
					bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0098");
				}
			}
			commit();
			eventResponse.setETCData("SuccessYn", "Y");
		} catch(EventException ex) {
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
	 * ESM_BKG_0098 : group email <br>
	 * Booking 리스트에서 5005RD를 Group Mail로 발송한다.<br>
	 * 
	 * @author	Jun Yong Jin
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse sendBkgReceiptByGroupEmail(Event e) throws EventException {
		EsmBkg0098Event event = (EsmBkg0098Event)e;
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralBookingReceiptBC command2 = new GeneralBookingReceiptBCImpl();
		BookingUtil utilBC = new BookingUtil();
		BkgClzTmVO bkgClzTmVO = null;
		BkgClzTmVO[] bkgClzTmVOs = null;
		HistoryTableVO historyTableVO = null;
		try{
			begin();
			BkgBlNoVO[] bkgBlNoVOs = event.getBkgBlNoVOs();			
			if (bkgBlNoVOs.length > 0) {
				for (int i=0; i<bkgBlNoVOs.length; i++) {
					if("Y".equals(utilBC.searchNoRateBlockFlg(bkgBlNoVOs[i]))){
						throw new EventException(new ErrorHandler("BKG08333",new String[]{bkgBlNoVOs[i].getBkgNo()}).getMessage());
					}
					if("Y".equals(utilBC.searchStandbyBlockFlg(bkgBlNoVOs[i]))){
						throw new EventException(new ErrorHandler("BKG08284",new String[]{bkgBlNoVOs[i].getBkgNo()}).getMessage());
					}
				}
			}
			if (bkgBlNoVOs.length > 0) {
				for (int i=0; i<bkgBlNoVOs.length; i++) {
					bkgBlNoVOs[i].setCaFlg("N");

					bkgClzTmVOs = new BkgClzTmVO[2];
					bkgClzTmVO = new BkgClzTmVO();
					bkgClzTmVO.setBkgNo(bkgBlNoVOs[i].getBkgNo());
					bkgClzTmVO.setClzTpCd("T");
					bkgClzTmVO.setMnlSetDt(event.getCct()[i].replaceAll("-","").replaceAll(":","").replaceAll(" ",""));
					bkgClzTmVO.setNtcFlg("Y");
					bkgClzTmVO.setUpdUsrId(account.getUsr_id());
					bkgClzTmVOs[0] = bkgClzTmVO;

					bkgClzTmVO = new BkgClzTmVO();
					bkgClzTmVO.setBkgNo(bkgBlNoVOs[i].getBkgNo());
					bkgClzTmVO.setClzTpCd("D");
					bkgClzTmVO.setMnlSetDt(event.getDocCct()[i].replaceAll("-","").replaceAll(":","").replaceAll(" ",""));
					bkgClzTmVO.setNtcFlg("Y");
					bkgClzTmVO.setUpdUsrId(account.getUsr_id());
					bkgClzTmVOs[1] = bkgClzTmVO;

					historyTableVO = bkgHisCmd.searchOldBkgForHistory("ESM_BKG_0721", bkgBlNoVOs[i]);
					command2.manageCargoClosingTime(bkgClzTmVOs, account);
					
					// [CHM-201640257] booking receipt notice(fax/edi)에 Edit Rail Cut-off 기능 추가
					// Rail Cut-Off 는 manula 값이 있을 때만 update
					// Vgm Cut-Off 는 manual 값이 있을 때만 update  
					List<BkgClzTmVO> bkgClzTmList = new ArrayList<BkgClzTmVO>();
					if(event.getMnlRailFromCct()[i].length() > 0){
						bkgClzTmVO = new BkgClzTmVO();
						bkgClzTmVO.setBkgNo(bkgBlNoVOs[i].getBkgNo());
						bkgClzTmVO.setClzTpCd("F");
						bkgClzTmVO.setMnlSetDt(event.getMnlRailFromCct()[i].replaceAll("-","").replaceAll(":","").replaceAll(" ",""));
						bkgClzTmVO.setNtcFlg("Y");
						bkgClzTmVO.setUpdUsrId(account.getUsr_id());
						bkgClzTmList.add(bkgClzTmVO);
					}
						if(event.getMnlRailToCct()[i].length() > 0){
						bkgClzTmVO = new BkgClzTmVO();
						bkgClzTmVO.setBkgNo(bkgBlNoVOs[i].getBkgNo());
						bkgClzTmVO.setClzTpCd("O");
						bkgClzTmVO.setMnlSetDt(event.getMnlRailToCct()[i].replaceAll("-","").replaceAll(":","").replaceAll(" ",""));
						bkgClzTmVO.setNtcFlg("Y");
						bkgClzTmVO.setUpdUsrId(account.getUsr_id());
						bkgClzTmList.add(bkgClzTmVO);
					}
						if(event.getMnlVgmCct()[i].length() > 0){
						bkgClzTmVO = new BkgClzTmVO();
						bkgClzTmVO.setBkgNo(bkgBlNoVOs[i].getBkgNo());
						bkgClzTmVO.setClzTpCd("V");
						bkgClzTmVO.setMnlSetDt(event.getMnlVgmCct()[i].replaceAll("-","").replaceAll(":","").replaceAll(" ",""));
						bkgClzTmVO.setNtcFlg("Y");
						bkgClzTmVO.setUpdUsrId(account.getUsr_id());
						bkgClzTmList.add(bkgClzTmVO);
					}
					if(bkgClzTmList.size() > 0){
						BkgClzTmVO[] bkgClzTmVOs2 =  new BkgClzTmVO[bkgClzTmList.size()];
						for(int j=0 ; j<bkgClzTmList.size(); j++){
							bkgClzTmVOs2[j] = bkgClzTmList.get(j);
						}
						command2.manageCargoClosingTime(bkgClzTmVOs2, account);
					}
										
					bkgHisCmd.manageBookingHistory("ESM_BKG_0721", historyTableVO, account);
				}
				BkgReceiptSendVO bkgReceiptSendVO = new BkgReceiptSendVO();
				bkgReceiptSendVO.setBkgBlNoVos(bkgBlNoVOs);
				bkgReceiptSendVO.setEmlAddrs(event.getEml());
				bkgReceiptSendVO.setRemarks(event.getRemark());
				bkgReceiptSendVO.setMrdNm(event.getMrdNm());
				bkgReceiptSendVO.setCcts(event.getCct());
				bkgReceiptSendVO.setDocCcts(event.getDocCct());
				bkgReceiptSendVO.setBkgEmlEdtVo(event.getBkgEmlEdtVO());
				List<BkgNtcHisVO> bkgNtcHisVOs = command.sendBkgReceiptByGroupEmail(bkgReceiptSendVO,event.getFileKey(), account);
				bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0098");
			}
			commit();
			eventResponse.setETCData("SuccessYn", "Y");
		} catch(EventException ex) {
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
	 * ESM_BKG_0702 : retrieve <br>
	 * 301/310 edi 전송 대상 Booking 리스트를 조회한다.<br>
	 * @author	Jun Yong Jin
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchBkgListFor301310Edi(Event e) throws EventException{	
		try{
			EsmBkg0702Event event = (EsmBkg0702Event)e;
			GeneralBookingListSearchBC command = new GeneralBookingListSearchBCImpl();	
			// bkg_no가 넘어온 경우 bkg_no만 VO에 담고 나머지는 초기화 - bkg_no만 조회 시
			BkgListFor301310EdiInputVO bkgListFor301310EdiInputTmpVO = event.getBkgListFor301310EdiInputVO();
			BkgListFor301310EdiInputVO bkgListFor301310EdiInputVO = new BkgListFor301310EdiInputVO();
//			if ( !isNull(event.getBkgListFor301310EdiInputVO().getBkgNo()) ) {
//				bkgListFor301310EdiInputVO.setBkgNo(bkgListFor301310EdiInputTmpVO.getBkgNo());
//			} else if(!isNull(event.getBkgListFor301310EdiInputVO().getBlNo())){
//				bkgListFor301310EdiInputVO.setBkgNo(bkgListFor301310EdiInputTmpVO.getBlNo()); 
//	        } else bkgListFor301310EdiInputVO = bkgListFor301310EdiInputTmpVO;
			bkgListFor301310EdiInputVO = bkgListFor301310EdiInputTmpVO;
			List<BkgListFor301310EdiVO> list = command.searchBkgListFor301310Edi(bkgListFor301310EdiInputVO, event.getTypeGbn());
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
	
			// 통계성 정보 취합 - ETC Data로 넘김
			int total = 0;
			int success = 0;
			int sending = 0;
			int noSend = 0;
			int fail = 0;
			if (null!=list && 0<list.size()) {
				for (int i=0;i<list.size();i++) {
					BkgListFor301310EdiVO listVO = (BkgListFor301310EdiVO)list.get(i);
					if ( !isNull(listVO.getSentStatus()) ) total++;
                    if ( "S".equals(listVO.getSentStatus()) ) success++;
                    if ( "F".equals(listVO.getSentStatus()) ) fail++;
					if ( isNull(listVO.getSentDt()) ) noSend++;
				}
			}
			eventResponse.setETCData("total",String.valueOf(total));
			eventResponse.setETCData("success",String.valueOf(success));
			eventResponse.setETCData("sending",String.valueOf(sending));
			eventResponse.setETCData("unSent",String.valueOf(noSend + fail));
			eventResponse.setETCData("noSend",String.valueOf(noSend));
			eventResponse.setETCData("fail",String.valueOf(fail));
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
	 * ESM_BKG_0614 : Open <br>
	 * 화면의 MultiCombo 조회 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode0614(Event e) throws EventException {
		try{
			BookingUtil comboUtil = new BookingUtil();
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			// bkg_sts
			List<BkgComboVO> bkg_sts_cd = comboUtil.searchCombo("CD00769");
			// bkg_cust_tp_cd
			List<BkgComboVO> bkg_cust_tp_cd = comboUtil.searchCombo("CD00880");
			// cust_ref_no
			List<BkgComboVO> cust_ref_no = comboUtil.searchCombo("CD02289");
			// Delivery - conti_cd
			List<BkgComboVO> conti_cd = command.searchComboMdmConti();
			// bkg_via
			List<BkgComboVO> bkg_via_cd = comboUtil.searchCombo("CD01622");
			// si_via
			List<BkgComboVO> si_via_cd = comboUtil.searchCombo("CD01619");
			// eq_tp_sz_cd
			List<BkgComboVO> eq_tp_sz_cd = comboUtil.searchMdmCntrTpSz();
			// rtro_knd_cd
			List<BkgComboVO> rtro_knd_cd = comboUtil.searchCombo("CD03367");

			BkgComboVO bkg_via_cd2 = new BkgComboVO();
			bkg_via_cd2.setVal("OFF");
			bkg_via_cd2.setName("OFF-OFF");
			List<BkgComboVO> bkg_via_cd3 = new ArrayList<BkgComboVO>();
			bkg_via_cd3.add(bkg_via_cd2);
			bkg_via_cd3.addAll(bkg_via_cd);
			bkg_via_cd = bkg_via_cd3;
			
			for(int i=0;i<bkg_via_cd.size();i++){
				if("NIS".equals(bkg_via_cd.get(i).getVal())||"APS".equals(bkg_via_cd.get(i).getVal())){
					bkg_via_cd.get(i).setVal("OFF");
					bkg_via_cd.get(i).setName("OFF");
				}
			}
			for(int i=0;i<si_via_cd.size();i++){
				if("NIS".equals(si_via_cd.get(i).getVal())||"APS".equals(si_via_cd.get(i).getVal())){
					si_via_cd.get(i).setVal("OFF");
					si_via_cd.get(i).setName("OFF");
				}
			}
			eventResponse.setRsVoList(bkg_via_cd);
			eventResponse.setRsVoList(si_via_cd);	
			eventResponse.setCustomData("bkg_sts_cd", bkg_sts_cd);
			eventResponse.setCustomData("bkg_cust_tp_cd", bkg_cust_tp_cd);
			eventResponse.setCustomData("cust_ref_no", cust_ref_no);
			eventResponse.setCustomData("conti_cd", conti_cd);
			eventResponse.setRsVoList(eq_tp_sz_cd);
			//eventResponse.setCustomData("rtro_knd_cd", rtro_knd_cd); 
			eventResponse.setRsVoList(rtro_knd_cd);	

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

//	/**
//	 * 조회 이벤트 처리 (ESM_BKG_0614)<br>
//	 * 조회조건을 가져오기위한 MultiCombo조회 결과<br>
//	 *
//	 * @param Event e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse searchInitComCode0614(Event e) throws EventException {
//		try{
//			BookingUtil comboUtil = new BookingUtil();
//			GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//			// bkg_via
//			List<BkgComboVO> bkg_via_cd = comboUtil.searchCombo("CD01619");
//			// si_via
//			List<BkgComboVO> si_via_cd = comboUtil.searchCombo("CD01619");
//	
//			eventResponse.setRsVoList(bkg_via_cd);
//			eventResponse.setRsVoList(si_via_cd);
//	
//			return eventResponse;
//		}catch(EventException ex){
//			rollback();
//			throw ex;
//		} catch(Exception ex) {
//			rollback();
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
//		}
//	}	
	
    /**
	 * ESM_BKG_0098 : open <br>
	 * 화면의 MultiCombo 조회 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode0098(Event e) throws EventException {
		try{
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			BookingUtil comboUtil = new BookingUtil();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			String rtnOfcCd = command.searchBkgReceiptType(account.getUsr_id());
			eventResponse.setCustomData("rtn_ofc_cd", rtnOfcCd);
	
			// bkg_status
			List<BkgComboVO> bkg_sts_cd = comboUtil.searchCombo("CD00769");
			bkg_sts_cd.remove(bkg_sts_cd.size()-1);
			bkg_sts_cd.remove(bkg_sts_cd.size()-1);
			// bkg_kind
			List<BkgComboVO> bkg_kind = comboUtil.searchCombo("CD01619");
			// bkg_cust_tp_cd
			List<BkgComboVO> bkg_cust_tp_cd = comboUtil.searchCombo("CD00880");
			// fax_sts_cd
			List<BkgComboVO> fax_sts_cd = comboUtil.searchCombo("CD02396");  //CD00959
			// eml_sts_cd
			List<BkgComboVO> eml_sts_cd = comboUtil.searchCombo("CD02396");  //CD02045
	
			eventResponse.setCustomData("bkg_sts_cd", bkg_sts_cd);
			eventResponse.setCustomData("bkg_kind", bkg_kind);
			eventResponse.setCustomData("bkg_cust_tp_cd", bkg_cust_tp_cd);
			eventResponse.setCustomData("fax_sts_cd", fax_sts_cd);
			eventResponse.setCustomData("eml_sts_cd", eml_sts_cd);
	
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
	 * ESM_BKG_0702 : open <br>
	 * 화면의 MultiCombo 조회 처리<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode0702(Event e) throws EventException {
		try{
			BookingUtil comboUtil = new BookingUtil();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			// bkg_cust_tp_cd
			List<BkgComboVO> bkg_cust_tp_cd = comboUtil.searchCombo("CD00880");
	
			eventResponse.setCustomData("bkg_cust_tp_cd", bkg_cust_tp_cd);

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
	 * ESM_BKG_0616 : open <br>
	 * 화면상의 drop down에 넣을 code를 조회한다.<br>
	 * 로그인 사용자의 Id로 Location Code를 조회한다.<br>
	 *
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode0616(Event e) throws EventException {
		try{
			BookingUtil comboUtil = new BookingUtil();
			GeneralBookingListSearchBC command = new GeneralBookingListSearchBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	
			// User Location Code
			String cntCd = command.searchUsrCntCd(account);
			// bkg_sts_cd
			List<BkgComboVO> bkg_sts_cd = comboUtil.searchCombo("CD00769");
			// ack_cd
			List<BkgComboVO> ack_cd = comboUtil.searchCombo("CD02160");
			// edi_msg
			List<BkgComboVO> edi_msg = comboUtil.searchCombo("CD02359");
	
			eventResponse.setCustomData("cnt_cd", cntCd);
			eventResponse.setCustomData("bkg_sts_cd", bkg_sts_cd);
			eventResponse.setCustomData("ack_cd", ack_cd);
			eventResponse.setCustomData("edi_msg", edi_msg);
	
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
	 * ESM_BKG_0076 : retrieve <br>
	 * Combine할 Booking 리스트를 조회한다.<br>
	 * 
	 * @author	Jun Yong Jin
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchBkgListForCombine(Event e) throws EventException{
		try{
			EsmBkg0076Event event = (EsmBkg0076Event)e;
			GeneralBookingSplitCombineBC command = new GeneralBookingSplitCombineBCImpl();
			List<BkgListForCombineVO> list = null;
	
			if ( "B".equals(event.getCombineCommonInputVO().getSearchGbn()) ) {
				list = command.searchBkgListForCombineByBkg(event.getCombineCommonInputVO(), event.getCombineByBkgInputVOs());
			} else {
				list = command.searchBkgListForCombineByRoute(event.getCombineCommonInputVO(), event.getCombineByRouteInputVO());
			}
	
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
	 * UI_BKG-0614 : COMBINE 버튼 클릭<br>
	 * ESM_BKG_0076 : COMBINE 버튼 클릭<br>
	 * 선택된 bkg들을 combine한다 <br>
	 * 
	 * @author	Jun Yong Jin
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse combineBooking(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String mstBkgNo 			= null;
		String hitchmentYn 			= null;
		String[] porCd 				= null;
		BkgBlNoVO[] targetBkgBlNoVOs= null;
		String prechecking			= "N";
		String hisCateNm            = null;
		
		BkgCorrectionVO bkgCorrectionVO = new BkgCorrectionVO();
		
		if (e.getEventName().equalsIgnoreCase("EsmBkg0076Event")) {
			EsmBkg0076Event event = (EsmBkg0076Event)e;
			mstBkgNo 			  = event.getMstBkgNo();
			hitchmentYn 		  = event.getHitchmentYn();
			targetBkgBlNoVOs 	  = event.getBkgBlNoVOs();
			porCd 				  = new String[event.getBkgListForCombineVOs().length];
			for(int i=0;i<event.getBkgListForCombineVOs().length;i++){
				porCd[i] = event.getBkgListForCombineVOs()[i].getPorCd();
			}
			bkgCorrectionVO.setCaRsnCd(event.getCaRsnCd());
			bkgCorrectionVO.setBkgCorrRmk(event.getCaRmk());
		} else {
			EsmBkg0614Event event = (EsmBkg0614Event)e;
			mstBkgNo 			  = event.getMstBkgNo();
			hitchmentYn 		  = event.getHitchmentYn();
			targetBkgBlNoVOs 	  = event.getBkgBlNoVOs();
			porCd = new String[event.getBkgListForWorkWithBkgVOs().length];
			for(int i=0;i<event.getBkgListForWorkWithBkgVOs().length;i++){
				porCd[i] = event.getBkgListForWorkWithBkgVOs()[i].getPor();
				targetBkgBlNoVOs[i].setBdrFlg(event.getBkgListForWorkWithBkgVOs()[i].getBdr().equals("YES")||event.getBkgListForWorkWithBkgVOs()[i].getBdr().equals("Y")?"Y":"N");				
			}
			bkgCorrectionVO.setCaRsnCd(event.getCaRsnCd());
			bkgCorrectionVO.setBkgCorrRmk(event.getCaRmk());
		}
		
		GeneralBookingSplitCombineBC command 	= new GeneralBookingSplitCombineBCImpl();
		GeneralBookingReceiptBC 	 receiptBC 	= new GeneralBookingReceiptBCImpl();
		GeneralBookingSearchBC 		 searchBC 	= new GeneralBookingSearchBCImpl();
		BLDocumentationBLBC 		 blDocBlBC 	= new BLDocumentationBLBCImpl();
		BLDocumentationCMBC 		 cmDocBlBC 	= new BLDocumentationCMBCImpl();
		TransferOrderIssueBC 		 troBC 		= new TransferOrderIssueBCImpl();
		SpecialCargoReceiptBC 		 spclCgoBC 	= new SpecialCargoReceiptBCImpl();
		SpecialCargoRiderBC 		 spclRdrBC 	= new SpecialCargoRiderBCImpl();
		BlRatingBC 					 blRatingBC = new BlRatingBCImpl();
		BDRCorrectionBC				 bdrBC		= new BDRCorrectionBCImpl();
		BookingHistoryMgtBC 	     historyBC 	= new BookingHistoryMgtBCImpl();
		BookingUtil             	 util       = new BookingUtil(); 
		EBookingReceiptBC 			 eBookingBC = new EBookingReceiptBCImpl();

		CargoReleaseOrderBC     	 cargoReleaseOrderBC     = new CargoReleaseOrderBCImpl();

//		BkgCopManageBC 				 copBC 					 = new BkgCopManageBCImpl();	
		RevenueDebitNoteBC      	 revenueDebitNoteBC      = new RevenueDebitNoteBCImpl();
				
		try{
			begin();
			
			int seq = 0;
			BkgBlNoVO targetBkg = new BkgBlNoVO();
			BkgBlNoVO[] sourceBkg = new BkgBlNoVO[targetBkgBlNoVOs.length-1];
			for (int i=0;i<targetBkgBlNoVOs.length;i++) {				
				//같은 office인지 확인 -> 확인하지 않음 
//				if(!"Y".equals(targetBkgBlNoVOs[i].getBdrFlg())){
//					util.searchOfcVsBkgOfc(targetBkgBlNoVOs[i], account);
//				}
				if ( mstBkgNo.equals(targetBkgBlNoVOs[i].getBkgNo()) ) {
					targetBkg = targetBkgBlNoVOs[i];
				} else {
					sourceBkg[seq] = targetBkgBlNoVOs[i];
					seq++;
				}
			}
			
			// add1stCaHist : 각  bkg의 최초 c/a hist을 넣는다(corr_no : 0000000001)
			if ( targetBkg != null ) {
				if("Y".equals(targetBkg.getBdrFlg())){
					add1stCaHist(targetBkg);
				}
			}
			if ( sourceBkg != null ) {
				for (int k=0;k<sourceBkg.length;k++) {
					if("Y".equals(sourceBkg[k].getBdrFlg())){
						add1stCaHist(sourceBkg[k]);
					}						
				}
			}
			
			// 01. Validate Mster Booking Customer
			ValidateCombineVO validateCombineVO = command.validateCombine(sourceBkg, targetBkg, hitchmentYn);
			eventResponse.setETCData("custAlertMsg",validateCombineVO.getAlertMsg());
			
			// Combine전 targetBkg의 BKG_QUANTITY CNTR_TPSZ_CD,OP_CNTR_QTY  조회
			HistoryTableVO targetHistoryTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0076", targetBkg);

			// 02. Combine Qty, b/l
			receiptBC.combineQty        (sourceBkg, targetBkg, hitchmentYn, account);
			blDocBlBC.combineBlDoc      (sourceBkg, targetBkg, account);

			// 04. Combine Cm, spcl, tro
			BkgCopyCntrCmByBkgVO bkgCopyCntrCmByBkgVO = new BkgCopyCntrCmByBkgVO();
			bkgCopyCntrCmByBkgVO.setCopyModeCd("M");
			bkgCopyCntrCmByBkgVO.setHitchmentYn(hitchmentYn);
			//cmDocBlBC.copyCntrCmByBkg   ("M", targetBkg, sourceBkg, null, account, hitchmentYn);
			cmDocBlBC.copyCntrCmByBkg   (targetBkg, sourceBkg, null, bkgCopyCntrCmByBkgVO ,account);
			spclCgoBC.copySpclCgoByBkg	("M", targetBkg, sourceBkg, null, account);
			spclRdrBC.copySpclRiderAfterCombine	(targetBkg, sourceBkg, account);
			spclRdrBC.removeSpclRiderAfterCombine (sourceBkg);
			
			List<CombineTroNewSeqVO> combineTroNewSeqVOs = troBC.copyTroByBkg("M", targetBkg, sourceBkg, null, "", account);
			
			// combine rate
			blRatingBC.copyChgRateByBkg (sourceBkg, targetBkg, account);
			
			// combine 이후 spcl cgo 정보로 bkg_booking에 spcl flg를 update한다.
			BkgBlNoVO[] bkgBlNoVO = new BkgBlNoVO[1];
			bkgBlNoVO[0] = targetBkg;
			receiptBC.modifySpclFlag(bkgBlNoVO, account);

			hisCateNm = "Y".equals(hitchmentYn)?"Hitchment":"COMBINE";
			// 07. toBkg에 대해서
			if ( targetBkg != null ) {
				String corrNo = null;
								
				//for performance report
				PerformanceReportBC performReportBc = new PerformanceReportBCImpl();
				performReportBc.manageQtyCntrCoposite(targetBkg.getBkgNo(), "CQ");
				performReportBc.manageQtyCntrCoposite(targetBkg.getBkgNo(), "CN");
				
				//07-1. Master Bkg에 대해 BDR이후일 경우
				if("Y".equals(targetBkg.getBdrFlg())){
					bdrBC.addAutoCaTemp(targetBkg, "COMBINE_MASTER", bkgCorrectionVO, account);
					
					BkgBlNoVO corrBkgBlNoVO = addCaHistory(bkgCorrectionVO.getCaRsnCd(), bkgCorrectionVO.getBkgCorrRmk(), targetBkg, "N", "Y");
					corrNo = corrBkgBlNoVO.getCaNo();
					
					bdrBC.removeCATemp(targetBkg);
					
					blRatingBC.distributeCntrRate(targetBkg.getBkgNo(), account);
					
		            //추가2. 
					OblIssVO oblIssVO = util.searchOblIssue(corrBkgBlNoVO); 
					
					//추가2. 
					RevDrNoteVO revDrNoteVO 		  = new RevDrNoteVO(); 
					CstmBkgRevDrNoteVO bkgRevDrNoteVO = new CstmBkgRevDrNoteVO();
					bkgRevDrNoteVO.setBkgNo      (corrBkgBlNoVO.getBkgNo());  
					bkgRevDrNoteVO.setBkgCorrNo  (corrBkgBlNoVO.getCaNo()); 
					bkgRevDrNoteVO.setRdnNo      (oblIssVO.getRdnNo()); 
					bkgRevDrNoteVO.setRvisSeq    (oblIssVO.getRvisSeq()); 
					bkgRevDrNoteVO.setReceiverRmk("");
					revDrNoteVO.setBkgRevDrNoteVO(bkgRevDrNoteVO);
					
					revenueDebitNoteBC.acceptRDNbyReceiptOffice(revDrNoteVO, account);  
					
					//추가2. 
					OblRdemVO oblRdem = new OblRdemVO();
					oblRdem.setBlNo      (oblIssVO.getBlNo());  
					oblRdem.setCgorTeamCd("C");
					oblRdem.setCgoEvntNm ("B/L Correct");
					oblRdem.setEvntDt    (new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
					oblRdem.setEvntOfcCd (account.getOfc_cd());
					oblRdem.setEvntUsrId (account.getUsr_id());
					oblRdem.setOblRdemFlg(oblIssVO.getOblRlseFlg()); 

					try{
						cargoReleaseOrderBC.setupFocByObl(oblRdem);
					} catch(Exception crEx){
						log.error("err " + crEx.toString(), crEx);
					}	
				}
				// 2010.09.06 김영철 [CHM-201005690-01] Booking Combine 시 DG Application Status 유지 요청
				String spclRqstResult = reRequestSpclCgoApproval(targetBkg, "COMBINE", null);
				if("pre-checking".equals(spclRqstResult)){
					prechecking = "Y";
				} else {
					prechecking = "N";						
				}
				
				if(!"Y".equals(targetBkg.getBdrFlg())){
					receiptBC.changeBkgStatus("Y", targetBkg, false, account);
				}
				
				//07-4. createBkgHistoryLine 호출
				String sourceBkgList = "";
				for (int j=0;j<sourceBkg.length;j++) {
//					sourceBkgList = sourceBkgList + ((j>0)?", ":"")+sourceBkg[j].getBkgNo();
					StringBuffer tmpBuffer = new StringBuffer(sourceBkgList).append(((j>0)?", ":"")).append(sourceBkg[j].getBkgNo());
					sourceBkgList = tmpBuffer.toString();
				}
				HistoryLineVO targetBkghistoryLineVO = new HistoryLineVO();
				targetBkghistoryLineVO.setBkgNo         (targetBkg.getBkgNo());
				targetBkghistoryLineVO.setCorrNo		(corrNo);
				targetBkghistoryLineVO.setUiId          ("ESM_BKG_0076");
				targetBkghistoryLineVO.setHisCateNm     (hisCateNm);
				targetBkghistoryLineVO.setCrntCtnt      ("Combined from source:"+sourceBkgList);
				historyBC.createBkgHistoryLine(targetBkghistoryLineVO, account);
			
				//07-2. interfaceCoa
				interfaceToMas(targetBkg, "Booking Combine", account);
			}

			// 08. sourceBkg에 대해서
			if ( sourceBkg != null ) {
				for (int k=0;k<sourceBkg.length;k++) {
					String corrNo = null;
					
					//08-1. Source Bkg에 대해 BDR이후일 경우
					if("Y".equals(sourceBkg[k].getBdrFlg())){
						bdrBC.addAutoCaTemp(sourceBkg[k], "COMBINE_SOURCE", bkgCorrectionVO, account);
						
						BkgBlNoVO corrBkgBlNoVO = addCaHistory(bkgCorrectionVO.getCaRsnCd(), bkgCorrectionVO.getBkgCorrRmk(), sourceBkg[k], "N", "Y");
						corrNo = corrBkgBlNoVO.getCaNo();
						
						bdrBC.removeCATemp(sourceBkg[k]);
						
			            //추가2. 
						OblIssVO oblIssVO = util.searchOblIssue(corrBkgBlNoVO); 
						
						//추가2. 
						RevDrNoteVO revDrNoteVO 		  = new RevDrNoteVO(); 
						CstmBkgRevDrNoteVO bkgRevDrNoteVO = new CstmBkgRevDrNoteVO();
						bkgRevDrNoteVO.setBkgNo      (corrBkgBlNoVO.getBkgNo());  
						bkgRevDrNoteVO.setBkgCorrNo  (corrBkgBlNoVO.getCaNo()); 
						bkgRevDrNoteVO.setRdnNo      (oblIssVO.getRdnNo()); 
						bkgRevDrNoteVO.setRvisSeq    (oblIssVO.getRvisSeq()); 
						bkgRevDrNoteVO.setReceiverRmk("");
						revDrNoteVO.setBkgRevDrNoteVO(bkgRevDrNoteVO);
						
						revenueDebitNoteBC.acceptRDNbyReceiptOffice(revDrNoteVO, account);  
						
						//추가2. 
						OblRdemVO oblRdem = new OblRdemVO();
						oblRdem.setBlNo      (oblIssVO.getBlNo());  
						oblRdem.setCgorTeamCd("C");
						oblRdem.setCgoEvntNm ("B/L Correct");
						oblRdem.setEvntDt    (new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
						oblRdem.setEvntOfcCd (account.getOfc_cd());
						oblRdem.setEvntUsrId (account.getUsr_id());
						oblRdem.setOblRdemFlg(oblIssVO.getOblRlseFlg()); 

						try{
							cargoReleaseOrderBC.setupFocByObl(oblRdem);
						} catch(Exception crEx){
							log.error("err " + crEx.toString(), crEx);
						}	
					}

					//08-4. createBkgHistoryLine 호출
					HistoryLineVO sourceBkghistoryLineVO = new HistoryLineVO();
					sourceBkghistoryLineVO.setBkgNo         (sourceBkg[k].getBkgNo());
					sourceBkghistoryLineVO.setCorrNo		(corrNo);
					sourceBkghistoryLineVO.setUiId          ("ESM_BKG_0076");
					sourceBkghistoryLineVO.setHisCateNm     (hisCateNm);
					sourceBkghistoryLineVO.setCrntCtnt      ("Combined to target bkg no:"+targetBkg.getBkgNo());
					historyBC.createBkgHistoryLine(sourceBkghistoryLineVO, account);

					//08-2. interfaceCoa
					interfaceToMas(sourceBkg[k], "Booking Cancel", account);
					
					List<BkgNtcHisVO> bkgNtcHisVOs = searchBC.createCustBkgReceiptEdi(sourceBkg[k], null, "Y", account);
					if (null!=bkgNtcHisVOs) {
						for (int i=0; i<bkgNtcHisVOs.size(); i++) {
							bkgNtcHisVOs.get(i).setSndId("SYSTEM");
							bkgNtcHisVOs.get(i).setSndUsrId("SYSTEM");
							bkgNtcHisVOs.get(i).setSndOfcCd("SYSTEM");
							bkgNtcHisVOs.get(i).setCreUsrId(account.getUsr_id());
							bkgNtcHisVOs.get(i).setUpdUsrId(account.getUsr_id());
						}
						historyBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0076");
					}
					
					// sendBkgTmlEdi  2014.08.04 [CHM-201431223]
					// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
					Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
					vender301ParamVO.setBkgBlNoVO(sourceBkg[k]);
					vender301ParamVO.setOldVvdVOs(null);
					vender301ParamVO.setOldQtyVOs(null);
					vender301ParamVO.setOldMtyPkupYdCd(null);
					vender301ParamVO.setBracCd("R");
					vender301ParamVO.setEdiKind("BT");
					vender301ParamVO.setAutoManualFlg("Y");
					searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);	
					
					// 09. EDI 수신된 SI가 있을경우 Reject APERAK 전송 
					XterRqstNoVO xterRqstNoVO = util.searchAperakXterRqstNo(sourceBkg[k].getBkgNo());
					if (xterRqstNoVO != null){
						eBookingBC.createXterRqstRejectEdi("Booking Cancel", "9", xterRqstNoVO, account);
					}
				}
			}
			
			// 09. 타모듈의 Combine메소드 호출	
			String[] combinedBkgNo = new String[targetBkgBlNoVOs.length];
			for(int i=0;i<targetBkgBlNoVOs.length;i++){
				combinedBkgNo[i] = targetBkgBlNoVOs[i].getBkgNo();
			}
			if(targetBkg!=null && targetBkg.getBkgNo()!=null){
				//copBC.combineBkg(combinedBkgNo, targetBkg.getBkgNo(), combineTroNewSeqVOs);
				callCopCombineBkg(combinedBkgNo, targetBkg.getBkgNo(), combineTroNewSeqVOs);
//			copBC.combineBkg(combinedBkgNo, targetBkg.getBkgNo());
			}
			
			// S 2010.08.31 KMJ TRO Split 추가
			// 81. copyTroBySplit
			String[] arrTargetBkgNo = new String[1];
			if(targetBkg!=null && targetBkg.getBkgNo()!=null){
				arrTargetBkgNo[0] = targetBkg.getBkgNo();
			}else{
				arrTargetBkgNo[0] = "";
			}
			
			for(int i=0;i<targetBkgBlNoVOs.length;i++){
//				troBC.copyTroBySplit(combinedBkgNo[i], arrTargetBkgNo, account);
//				// 82. cancelTroBySplit
				troBC.cancelTroBySplit(combinedBkgNo[i], arrTargetBkgNo, account);
				// 2010.08.31 KMJ TRO Split 추가
			}
			commit();
			
			// sendBkgTmlEdi  2014.08.04 [CHM-201431223]
			// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
			Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
			vender301ParamVO.setBkgBlNoVO(targetBkg);
			vender301ParamVO.setOldVvdVOs(null);
			vender301ParamVO.setOldQtyVOs(targetHistoryTableVO.getBkgQuantityVOs());
			vender301ParamVO.setOldMtyPkupYdCd(null);
			vender301ParamVO.setBracCd("U");
			vender301ParamVO.setEdiKind("BT");
			vender301ParamVO.setAutoManualFlg("Y");
			searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);
			historyBC.releaseCntrFinalConfirm(targetBkg, account); // commit 후에 해야 CNTR 수량이 맞음
			
			//commit()이후에 inv i/f
			//07-5. bookingARCreationBC.interfaceBKGARInvoiceToINV(BkgIfVo);
			interfaceToInv(targetBkg, account);	
			// 08. sourceBkg에 대해서
			if ( sourceBkg != null ) {
				for (int k=0;k<sourceBkg.length;k++) {
					//08-5:bookingARCreationBC.interfaceBKGARInvoiceToINV(BkgIfVo);
					interfaceToInv(sourceBkg[k], account);	
				}
			}
			
			eventResponse.setETCData("pre_checking", prechecking);
			eventResponse.setETCData("isSuccess","Y");
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
	 * ESM_BKG_0076 : cancel <br>
	 * Combine화면에서 다건의 Booking Cancel 처리 <br>
	 * 
	 * @author	Jun Yong Jin
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelBookingMulti(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0076Event event = (EsmBkg0076Event)e;
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		BLDocumentationCMBC blDocCmBC = new BLDocumentationCMBCImpl();
		BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
		BkgCopManageBC bkgCopManageBC = new BkgCopManageBCImpl();
		
		try{
			begin();
			if(event.getBkgBlNoVOs() != null){
				for(int i=0;i<event.getBkgBlNoVOs().length;i++) {
					BkgBlNoVO bkgBlNoVO = event.getBkgBlNoVOs()[i];

					// 01. Cancel Booking
					receiptBC.cancelBooking(bkgBlNoVO, account);
					// 하위 BKG가 모두 Cancel 된 경우 해당 Master BKG의 상태를 S에서 F(W,A)로 변경
					changeMemoSplitBkgStatus(bkgBlNoVO.getBkgNo());
	
					// 02. Cancel Container
					blDocCmBC.cancelBkgCntr(bkgBlNoVO, account);

					// 03. BookingHistoryMgtBC의 createBkgHistoryLine 호출					
					HistoryLineVO historyLineVO = new HistoryLineVO();
					historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
					historyLineVO.setCaFlg(bkgBlNoVO.getCaFlg());
					historyLineVO.setBkgDocProcTpCd("BKGCAN");//booking cancel for doc performance
					historyLineVO.setUiId("ESM_BKG_0079_01");
					historyLineVO.setCrntCtnt("Booking Canceled.");
					historyLineVO.setHisCateNm("Booking Cancel."); 
					
					historyBC.createBkgHistoryLine(historyLineVO, account);

					bkgCopManageBC.cancelBkg(bkgBlNoVO.getBkgNo());
					
					// 04. interfaceCoa
					interfaceToMas(bkgBlNoVO, "Booking cancel", account);

				}
			}

			commit();

			if(event.getBkgBlNoVOs() != null){
				for(int i=0;i<event.getBkgBlNoVOs().length;i++) {
					BkgBlNoVO bkgBlNoVO = event.getBkgBlNoVOs()[i];
					// 05. BookingARCreationBC의 interfaceBkgARInvoiceToINV 호출
					interfaceToInv(bkgBlNoVO, account);	
				}
			}
			
			eventResponse.setETCData("isSuccess","Y");
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
	 * ESM_BKG_0099 : P/C click <br>
	 * booking split 화면에서 새로 입력할 Ocean Route를 조회한다. <br>
	 * 
	 * @param  Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSplitRoute(Event e) throws EventException{
		try{
			EsmBkg0099Event 	 event 		   = (EsmBkg0099Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			ProductCatalogCreateBC 	proBC = new ProductCatalogCreateBCImpl();
			BookingUtil 			util  = new BookingUtil();

			BkgBlNoVO  sourceBkg  = event.getSourceBkg();			
			SplitBkgVO splitBkgVO = event.getSplitBkgVO();
			List<SplitQtyVO> selectQtyVO = splitBkgVO.getSplitQtyVO();

			BkgBlNoVO targetBkg = new BkgBlNoVO();
			targetBkg.setBkgNo(splitBkgVO.getSplitBlInfoVO().get(0).getBkgNo());

			//PrdMainInfoVO Set
			PrdMainInfoVO prdMainInfoVO  = new PrdMainInfoVO();
			prdMainInfoVO.setFCmd("3");
			if(sourceBkg.getBkgNo().equals(targetBkg.getBkgNo())){
				prdMainInfoVO.setPcMode("R");
			} else {
				prdMainInfoVO.setPcMode("B");
			}
			prdMainInfoVO.setTVvd (splitBkgVO.getSplitBlInfoVO().get(0).getTvvd());
			prdMainInfoVO.setWgt  (splitBkgVO.getSplitBlInfoVO().get(0).getActWgt());
			prdMainInfoVO.setBkgNo(sourceBkg.getBkgNo());
			
			PrdParameterVO prdParameterVO = new PrdParameterVO();
			prdParameterVO.setBkgBlNoVO(sourceBkg);
			prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
			prdParameterVO=util.searchPrdParmForFullRoute (prdParameterVO);
			
			// T/S port는 유지하고 vvd는 제외함
			prdParameterVO.getPrdMainInfoVO().setVvd1("");
			prdParameterVO.getPrdMainInfoVO().setPol1C("");
			prdParameterVO.getPrdMainInfoVO().setPod1C("");
			prdParameterVO.getPrdMainInfoVO().setLane1("");
			
			prdParameterVO.getPrdMainInfoVO().setVvd2("");
			prdParameterVO.getPrdMainInfoVO().setPol2C("");
			prdParameterVO.getPrdMainInfoVO().setPod2C("");
			prdParameterVO.getPrdMainInfoVO().setLane2("");
			
			prdParameterVO.getPrdMainInfoVO().setVvd2("");
			prdParameterVO.getPrdMainInfoVO().setPol2C("");
			prdParameterVO.getPrdMainInfoVO().setPod2C("");
			prdParameterVO.getPrdMainInfoVO().setLane2("");
			
			prdParameterVO.getPrdMainInfoVO().setVvd2("");
			prdParameterVO.getPrdMainInfoVO().setPol2C("");
			prdParameterVO.getPrdMainInfoVO().setPod2C("");
			prdParameterVO.getPrdMainInfoVO().setLane2("");
			
			if(sourceBkg.getBkgNo().equals(targetBkg.getBkgNo())){
				prdParameterVO.getPrdMainInfoVO().setMtPkupDt("");
			}
			
			List<PrdQtyInfoVO> prdQtyInfoList = new ArrayList<PrdQtyInfoVO>();
			log.debug("cnt:"+selectQtyVO.size());
            for(int icnt=0;icnt<selectQtyVO.size(); icnt++) {        	
            	int targetBkgSeq = icnt%Integer.parseInt(splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitcount());
            	
            	if((event.getPcIdx())==targetBkgSeq){
            		PrdQtyInfoVO prdQtyInfoVO = new PrdQtyInfoVO();
            		prdQtyInfoVO = new PrdQtyInfoVO();
            		prdQtyInfoVO.setCQty (selectQtyVO.get(icnt).getOpCntrQty());
            		prdQtyInfoVO.setCTpsz(selectQtyVO.get(icnt).getCntrTpszCd());
            		
            		prdQtyInfoList.add(prdQtyInfoVO); 
            	}
            }
            
			prdParameterVO.setPrdQtyInfo(prdQtyInfoList);
			prdParameterVO.getBkgBlNoVO().setBkgNo(targetBkg.getBkgNo());
			prdParameterVO.getPrdMainInfoVO().setBkgNo(targetBkg.getBkgNo());
			prdParameterVO.getPrdMainInfoVO().setOrgTrnsMode("");
			prdParameterVO.getPrdMainInfoVO().setDestTrnsMode("");
			String pctlNo="";
			String mapSeq="";

			String prdLog = util.prdParameterLog(prdParameterVO.getPrdMainInfoVO());
	    	
			//P/C 연동 
			try{
				String pctlNoMapSeqStr = proBC.createPrdCtlgRout(prdParameterVO, account);
				log.debug("pctl_no:"+pctlNoMapSeqStr);
				String [] pctlNoMapSeq = util.splitByToken(pctlNoMapSeqStr, "|");
				pctlNo = pctlNoMapSeq[0];
				mapSeq = pctlNoMapSeq[1];
			} catch (Exception pc_ex){
				eventResponse.setETCData("IsPctlNoPop", "Y");
				eventResponse.setETCData(prdParameterVO.getPrdMainInfoVO().getColumnValues());	
				eventResponse.setRsVoList(prdParameterVO.getPrdQtyInfo());	
				
				log.debug("Pctl Pop Up Call");
				log.error(pc_ex.getMessage() + prdLog); // 2011.07.15
				rollback();
				return eventResponse;
			}
			log.debug(" Pctl No : [" + pctlNo + "]");
			// 화면에서 PctlNo가 넘어오면 다음단계로 넘어가고 없으면 findFullRoute 결과값을 확인하여 PctlNo가 없으면 ESD_PRD_018 화면을 띄우고 있으면 다음단계로 진행한다.
			if(pctlNo != null && pctlNo.length() > 0 && !"FAIL".equals(pctlNo)){
				targetBkg.setPctlNo(pctlNo);
				targetBkg.setMapSeq(mapSeq);
				
			}else{
				eventResponse.setETCData("IsPctlNoPop", "Y");
				eventResponse.setETCData(prdParameterVO.getPrdMainInfoVO().getColumnValues());	
				eventResponse.setRsVoList(prdParameterVO.getPrdQtyInfo());	
				
				log.debug("Pctl Pop Up Call");
				rollback();
				return eventResponse;
			}
			
			GeneralBookingSplitCombineBC command = new GeneralBookingSplitCombineBCImpl();
			String rtnRoute = command.searchNewTsRoute(targetBkg);
			eventResponse.setETCData("rtn_route", rtnRoute);
			eventResponse.setETCData("pctl_no",   pctlNo);
			
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
		}		
	}

	/**
	 * ESM_BKG_1024 : open <br>
	 * Partial Container를 공유하는 bkg 정보를 조회한다.<br>
	 *  
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPartialCntrBkg(Event e) throws EventException{
		try{
			EsmBkg1024Event event = (EsmBkg1024Event)e;
			
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
			
			PartialBkgVO partialBkgVO = receiptBC.searchPartialCntrBkg(event.getBkgBlNoVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRs(partialBkgVO.getPartialBkgCntrRS());
			eventResponse.setRsVoList(partialBkgVO.getPartialBkgInfo());
			
			// 가변열의 Title을 조합한다.
			List<String> cntrNoList = partialBkgVO.getCntrNoList();
			String saveName = "";
			
			for(int i = 0 ; i < cntrNoList.size() ; i++){
				if(i == 0){
					saveName = cntrNoList.get(i).toLowerCase();
				}else{
//					saveName = saveName + "|" + cntrNoList.get(i).toLowerCase();	
					StringBuffer tmpBuffer = new StringBuffer(saveName).append("|").append(cntrNoList.get(i).toLowerCase());
					saveName = tmpBuffer.toString();
				}
			}
			eventResponse.setETCData("SaveName", saveName);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}	
	
	/**
	 * ESM_BKG_1024 : save <br>
	 * Partial Booking의 Route정보를 일괄 저장한다.<br>
	 *  
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse modifyBkgRouteForPartialBkg(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
		EsmBkg1024Event 	 	event 			= (EsmBkg1024Event)e;
		GeneralBookingReceiptBC receiptBC 		= new GeneralBookingReceiptBCImpl();
		GeneralBookingSearchBC  searchBC 		= new GeneralBookingSearchBCImpl();
		BookingHistoryMgtBC  	historyBC 		= new BookingHistoryMgtBCImpl();
		BookingUtil 			util 			= new BookingUtil();

		ProductCatalogCreateBC 	prdBC 			= new ProductCatalogCreateBCImpl();
		//BkgCopManageBC 			copBC 			= new BkgCopManageBCImpl();

		try{			
			PartialBkgInfoVO[] partialBkgInfoVOs = event.getPartialBkgInfoVOs();
			VslSkdVO[] vslSkdVOs = event.getVslSkdVOs();
			for(int i = 1 ; i < partialBkgInfoVOs.length ; i++){
				begin();
				// 11. searchPrdParmForFullRoute
				PrdParameterVO prdParameterVO = new PrdParameterVO();
				PrdMainInfoVO  prdMainInfoVO  = new PrdMainInfoVO();
				prdMainInfoVO.setFCmd  ("3");
				prdMainInfoVO.setPcMode("R");		
				prdMainInfoVO.setBkgNo(partialBkgInfoVOs[i].getBkgNo());
				prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
				
				BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
				bkgBlNoVO.setBkgNo(partialBkgInfoVOs[i].getBkgNo());
				prdParameterVO.setBkgBlNoVO(bkgBlNoVO);
				
				// 01. searchPrdParameter
				PrdParameterVO schPrdParameterVO = util.searchPrdParmForFullRoute(prdParameterVO);
				
				prdMainInfoVO = schPrdParameterVO.getPrdMainInfoVO();
				
				boolean vslChange = false;
				for(int vslIdx=0;vslIdx<vslSkdVOs.length;vslIdx++){
					if(0==vslIdx){
						if(!prdMainInfoVO.getVvd1().equals(vslSkdVOs[0].getBkgVvdCd())) vslChange = true;
					} else if(1==vslIdx){
						if(!prdMainInfoVO.getVvd2().equals(vslSkdVOs[1].getBkgVvdCd())) vslChange = true;
					} else if(2==vslIdx){
						if(!prdMainInfoVO.getVvd3().equals(vslSkdVOs[2].getBkgVvdCd())) vslChange = true;
					} else if(3==vslIdx){
						if(!prdMainInfoVO.getVvd4().equals(vslSkdVOs[3].getBkgVvdCd())) vslChange = true;
					}
				}
				if("Y".equals(partialBkgInfoVOs[i].getOrg())){
					prdMainInfoVO.setPor(partialBkgInfoVOs[i].getPorCd());
					if(partialBkgInfoVOs[i].getPorNodCd() != null && partialBkgInfoVOs[i].getPorNodCd().length() > 0){
						prdMainInfoVO.setPorN(partialBkgInfoVOs[i].getPorCd()+partialBkgInfoVOs[i].getPorNodCd());
					}else{
						prdMainInfoVO.setPorN(null);
					}
					
					prdMainInfoVO.setPol(partialBkgInfoVOs[i].getPolCd());
					if(partialBkgInfoVOs[i].getPolNodCd() != null && partialBkgInfoVOs[i].getPolNodCd().length() > 0){
						prdMainInfoVO.setPolN(partialBkgInfoVOs[i].getPolCd()+partialBkgInfoVOs[i].getPolNodCd());
					}else{
						prdMainInfoVO.setPolN(null);
					}		
					prdMainInfoVO.setRcvT(partialBkgInfoVOs[i].getRcvTermCd());
				}
				if("Y".equals(partialBkgInfoVOs[i].getDest())){
					prdMainInfoVO.setPod(partialBkgInfoVOs[i].getPodCd());
					if(partialBkgInfoVOs[i].getPodNodCd() != null && partialBkgInfoVOs[i].getPodNodCd().length() > 0){
						prdMainInfoVO.setPodN(partialBkgInfoVOs[i].getPodCd()+partialBkgInfoVOs[i].getPodNodCd());
					}else{
						prdMainInfoVO.setPodN(null);
					}						
					prdMainInfoVO.setDel(partialBkgInfoVOs[i].getDelCd());
					if(partialBkgInfoVOs[i].getDelNodCd() != null && partialBkgInfoVOs[i].getDelNodCd().length() > 0){
						prdMainInfoVO.setDelN(partialBkgInfoVOs[i].getDelCd()+partialBkgInfoVOs[i].getDelNodCd());
					}else{
						prdMainInfoVO.setDelN(null);
					}		
					prdMainInfoVO.setDelT(partialBkgInfoVOs[i].getDeTermCd());
				}
				prdMainInfoVO.setTVvd(partialBkgInfoVOs[i].getBkgTrunkVvd());

				if(vslSkdVOs!=null&&vslSkdVOs.length > 0){
					prdMainInfoVO.setPod1(vslSkdVOs[0].getPodCd());
					if(vslSkdVOs[0].getPodYdCd() != null && vslSkdVOs[0].getPodYdCd().length() > 0){
						prdMainInfoVO.setPod1N(vslSkdVOs[0].getPodCd()+vslSkdVOs[0].getPodYdCd());
					}else{
						prdMainInfoVO.setPod1N(null);
					}						
					prdMainInfoVO.setPod1C(vslSkdVOs[0].getPodClptIndSeq());
					prdMainInfoVO.setPol1(vslSkdVOs[0].getPolCd());
					if(vslSkdVOs[0].getPolYdCd() != null && vslSkdVOs[0].getPolYdCd().length() > 0){
						prdMainInfoVO.setPol1N(vslSkdVOs[0].getPolCd()+vslSkdVOs[0].getPolYdCd());
					}else{
						prdMainInfoVO.setPol1N(null);
					}
					prdMainInfoVO.setPol1C(vslSkdVOs[0].getPolClptIndSeq());
					prdMainInfoVO.setVvd1(vslSkdVOs[0].getBkgVvdCd());	
					prdMainInfoVO.setLane1(util.searchSvcLaneByVvd(vslSkdVOs[0].getBkgVvdCd()));							
				}else{
					prdMainInfoVO = util.resetNthRoute(prdMainInfoVO, 1);
				}
				if(vslSkdVOs!=null&&vslSkdVOs.length > 1){
					prdMainInfoVO.setPod2(vslSkdVOs[1].getPodCd());
					if(vslSkdVOs[1].getPodYdCd() != null && vslSkdVOs[1].getPodYdCd().length() > 0){
						prdMainInfoVO.setPod2N(vslSkdVOs[1].getPodCd()+vslSkdVOs[1].getPodYdCd());
					}else{
						prdMainInfoVO.setPod2N(null);
					}					
					prdMainInfoVO.setPod2C(vslSkdVOs[1].getPodClptIndSeq());
					prdMainInfoVO.setPol2(vslSkdVOs[1].getPolCd());
					if(vslSkdVOs[1].getPolYdCd() != null && vslSkdVOs[1].getPolYdCd().length() > 0){
						prdMainInfoVO.setPol2N(vslSkdVOs[1].getPolCd()+vslSkdVOs[1].getPolYdCd());
					}else{
						prdMainInfoVO.setPol2N(util.searchSvcLaneByVvd(vslSkdVOs[1].getBkgVvdCd()));
					}					
					prdMainInfoVO.setPol2C(vslSkdVOs[1].getPolClptIndSeq());
					prdMainInfoVO.setVvd2(vslSkdVOs[1].getBkgVvdCd());
					prdMainInfoVO.setLane2(null);	
				}else{
					prdMainInfoVO = util.resetNthRoute(prdMainInfoVO, 2);
				}
				if(vslSkdVOs!=null&&vslSkdVOs.length > 2){
					prdMainInfoVO.setPod3(vslSkdVOs[2].getPodCd());
					if(vslSkdVOs[2].getPodYdCd() != null && vslSkdVOs[2].getPodYdCd().length() > 0){
						prdMainInfoVO.setPod3N(vslSkdVOs[2].getPodCd()+vslSkdVOs[2].getPodYdCd());
					}else{
						prdMainInfoVO.setPod3N(null);
					}					
					prdMainInfoVO.setPod3C(vslSkdVOs[2].getPodClptIndSeq());
					prdMainInfoVO.setPol3(vslSkdVOs[2].getPolCd());
					if(vslSkdVOs[2].getPolYdCd() != null && vslSkdVOs[2].getPolYdCd().length() > 0){
						prdMainInfoVO.setPol3N(vslSkdVOs[2].getPolCd()+vslSkdVOs[2].getPolYdCd());
					}else{
						prdMainInfoVO.setPol3N(null);
					}					
					prdMainInfoVO.setPol3C(vslSkdVOs[2].getPolClptIndSeq());
					prdMainInfoVO.setVvd3(vslSkdVOs[2].getBkgVvdCd());
					prdMainInfoVO.setLane3(util.searchSvcLaneByVvd(vslSkdVOs[2].getBkgVvdCd()));
				}else{
					prdMainInfoVO = util.resetNthRoute(prdMainInfoVO, 3);			
				}
				if(vslSkdVOs!=null&&vslSkdVOs.length > 3){
					prdMainInfoVO.setPod4(vslSkdVOs[3].getPodCd());
					if(vslSkdVOs[3].getPodYdCd() != null && vslSkdVOs[3].getPodYdCd().length() > 0){
						prdMainInfoVO.setPod4N(vslSkdVOs[3].getPodCd()+vslSkdVOs[3].getPodYdCd());
					}else{
						prdMainInfoVO.setPod4N(null);
					}					
					prdMainInfoVO.setPod4C(vslSkdVOs[3].getPodClptIndSeq());
					prdMainInfoVO.setPol4(vslSkdVOs[3].getPolCd());
					if(vslSkdVOs[3].getPolYdCd() != null && vslSkdVOs[3].getPolYdCd().length() > 0){
						prdMainInfoVO.setPol4N(vslSkdVOs[3].getPolCd()+vslSkdVOs[3].getPolYdCd());
					}else{
						prdMainInfoVO.setPol4N(null);
					}				
					prdMainInfoVO.setPol4C(vslSkdVOs[3].getPolClptIndSeq());
					prdMainInfoVO.setVvd4(vslSkdVOs[3].getBkgVvdCd());
					prdMainInfoVO.setLane4(util.searchSvcLaneByVvd(vslSkdVOs[3].getBkgVvdCd()));	
				}else{
					prdMainInfoVO = util.resetNthRoute(prdMainInfoVO, 4);			
				}		

				if("Y".equals(partialBkgInfoVOs[i].getOrg())){				
					if(partialBkgInfoVOs[i].getLodgDueDt() != null){
						prdMainInfoVO.setLdDt(partialBkgInfoVOs[i].getLodgDueDt().replaceAll("-", ""));
					}else{
						prdMainInfoVO.setLdDt(null);	
					}
					if(partialBkgInfoVOs[i].getMtyDorArrDt() != null){
						prdMainInfoVO.setDrDt(partialBkgInfoVOs[i].getMtyDorArrDt().replaceAll("-", ""));
					}else{
						prdMainInfoVO.setDrDt(null);
					}
					prdMainInfoVO.setMPu(partialBkgInfoVOs[i].getMtyPkupYdCd());
					prdMainInfoVO.setFRt(partialBkgInfoVOs[i].getFullRtnYdCd());
				}
				prdMainInfoVO.setOrgTrnsMode("");
				prdMainInfoVO.setDestTrnsMode("");
				
				schPrdParameterVO.setPrdMainInfoVO(prdMainInfoVO);				
//				util.prdParameterLog(prdMainInfoVO);
				
				//pseudo일 때 ocean route check 제외 
//				String trunkVslCd = prdMainInfoVO.getTVvd().substring(0, 4);
//				if(!trunkVslCd.equals("HJXX") && !trunkVslCd.equals("HJYY") && !trunkVslCd.equals("HJZZ")){
					receiptBC.validateOceanRoute(prdMainInfoVO);
//				}
				
				// 12. createProdCtlRoute
				String pctlNoMapSeqStr = prdBC.createPrdCtlgRout(schPrdParameterVO, account);
				
				String [] pctlNoMapSeq = util.splitByToken(pctlNoMapSeqStr, "|");
				
				// 13. modifyBkgRouteForParialBkg
				BkgBlNoVO partialBkg = new BkgBlNoVO();
				partialBkg.setPctlNo(pctlNoMapSeq[0]);
				partialBkg.setCaFlg("N");
				partialBkg.setBkgNo(partialBkgInfoVOs[i].getBkgNo());
				
				HistoryTableVO historyTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_1024", partialBkg);

				receiptBC.modifyBkgRouteForPartialBkg(partialBkgInfoVOs[i], event.getVslSkdVOs(), partialBkg, account);
				
				//vvd 변경 건인 경우 spcl 자동 re-request
				reRequestSpclCgoApproval(bkgBlNoVO, "PARTIAL", null);
					
				//copBC.updateBkg(partialBkg.getBkgNo(), pctlNoMapSeq[1]);
				callCopUpdateBkg(partialBkg.getBkgNo(), pctlNoMapSeq[1]);
				
				historyBC.manageBookingHistory("ESM_BKG_1024", historyTableVO, account);

				String brac = "X";
				brac = (vslChange)?"B":"U";
				if(!"X".equals(brac)){
					
					// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
					Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
					vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
					vender301ParamVO.setOldVvdVOs(historyTableVO.getBkgVvdVOs());
					vender301ParamVO.setOldQtyVOs(historyTableVO.getBkgQuantityVOs());
					vender301ParamVO.setOldMtyPkupYdCd(historyTableVO.getBkgBookingVO().getMtyPkupYdCd());
					vender301ParamVO.setBracCd(brac);
					vender301ParamVO.setEdiKind("BT");
					vender301ParamVO.setAutoManualFlg("Y");
					
					searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);
				}
				// 22. updateBkg(bkgNo)
				interfaceToMas(partialBkg, "Booking Update", account);
				
				commit();
						
				try{	
					// cut off time (cop 생성 이후에 처리)
					String fromDt = null;
					String toDt = null;
					
					if("US".equals(partialBkgInfoVOs[i].getPorCd()) || "CA".equals(partialBkgInfoVOs[i].getPorCd())){					
						PrdQtyInfoVO[] prdQtyInfo 	= receiptBC.searchBkgQtyForRailTime(bkgBlNoVO);
											
						Map railTime = prdBC.getRailRecevingTime(bkgBlNoVO.getPctlNo(), prdQtyInfo, null, null, bkgBlNoVO.getBkgNo());

						fromDt= (String)railTime.get("RTN_TIME");
						toDt  = (String)railTime.get("CUT_OFF");
					}
					begin(); //batch 서버 접속해야되서 Transaction을 분리함
					receiptBC.createCargoClosingTime(bkgBlNoVO, fromDt, toDt, account);
					commit();
				} catch(Exception prdEx){
					rollback();
					log.error("err " + prdEx.toString(), prdEx);					
				}		

				// 24. BookingARCreationBC의 interfaceBkgARInvoiceToINV
				interfaceToInv(partialBkg, account);
			}
			eventResponse.setETCData("isSuccess","Y");
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_BKG_0077 : open <br>
	 * booking Copy를 하기 위해 원본이되는 booking의 data를 조회한다<br>
	 *  
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgForCopy(Event e) throws EventException{
		try{
			EsmBkg0077Event event = (EsmBkg0077Event)e;
			
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
			
			BookingCopyVO bookingCopyVO = receiptBC.searchBkgForCopy(event.getBkgBlNoVO());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			List<VslSkdVO> vslSkd = bookingCopyVO.getVslSkd();
			BkgForCopyVO bkgForCopyVO = bookingCopyVO.getBkgForCopyVO();
			BlCustomerInfoVO blCustomerInfoVO = bookingCopyVO.getBlCustomerInfoVO();
			
			if(bkgForCopyVO != null){
				eventResponse.setETCData(bkgForCopyVO.getColumnValues());	
				if(blCustomerInfoVO != null){
					eventResponse.setETCData(blCustomerInfoVO.getColumnValues());	
				}				
				eventResponse.setRsVoList(vslSkd);	
				
				eventResponse.setETCData("DataYn", "Y");
			}else{
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
				eventResponse.setETCData("DataYn", "N");
			}
//			searchTrnkVvdByRlane(PolPodVvdVO[] polPodVvdVOs
			PolPodVvdVO[] polPodVvdVOs = new PolPodVvdVO[vslSkd.size()];
			for(int i=0;i<polPodVvdVOs.length;i++){
				PolPodVvdVO polPodVvdVO = new PolPodVvdVO();
				polPodVvdVO.setBkgVvdCd(vslSkd.get(i).getBkgVvdCd());
				polPodVvdVO.setPolCd(vslSkd.get(i).getPolCd());
				polPodVvdVO.setPodCd(vslSkd.get(i).getPodCd());
				polPodVvdVOs[i] = polPodVvdVO;
			}
			String trunkSeq = receiptBC.searchTrnkVvdByRlane(polPodVvdVOs);
			eventResponse.setETCData("trunk_seq", trunkSeq);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}	
	
	/**
	 * ESM_BKG_0077 : copy <br>
	 * Route변경시 Booking Copy한다.<br>
	 *  
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse copyBkgWithoutRoute(Event e) throws EventException {
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		EsmBkg0077Event 	 event 		   	= (EsmBkg0077Event)e;
		GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
		BookingUtil 			util 		= new BookingUtil();
		try{
			PrdParameterVO prdParameterVO = new PrdParameterVO();
			
			String vvdModifyFlg = event.getVvdModifyFlg();
			log.debug("Event vvdModifyFlg : " + vvdModifyFlg);
			BookingCopyVO bookingCopyVO = new BookingCopyVO();
			
			bookingCopyVO.setBkgForCopyVO(event.getBkgForCopyVO());
			bookingCopyVO.setVslSkdVOs(event.getVslSkdVOs());
			bookingCopyVO.setBkgBlNoVO(event.getBkgBlNoVO());
			
			receiptBC.validateBkgCopy(bookingCopyVO, account);
			
			BkgForCopyVO bkgForCopyVO = event.getBkgForCopyVO();
			String pctlNo = event.getPctlNo();
			
			// 화면에서 PctlNo가 넘어오면 다음단계로 넘어가고 없으면 findFullRoute 결과값을 확인하여 PctlNo가 없으면 ESD_PRD_018 화면을 띄우고 있으면 다음단계로 진행한다.
			if(pctlNo != null && pctlNo.length() > 0 && !"FAIL".equals(pctlNo.length())){				
				bkgForCopyVO.setPctlNo(pctlNo);
			}else{
				if("Y".equals(vvdModifyFlg)){
					// With Route 시
					VslSkdVO[] vslSkdVOs = event.getVslSkdVOs();
					PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO();

					prdMainInfoVO.setTVvd(bkgForCopyVO.getBkgTrunkVvd());
					if(vslSkdVOs.length > 0){
						prdMainInfoVO.setPod1(vslSkdVOs[0].getPodCd());
						if(vslSkdVOs[0].getPodYdCd() != null && vslSkdVOs[0].getPodYdCd().length() > 0){
							prdMainInfoVO.setPod1N(vslSkdVOs[0].getPodCd()+vslSkdVOs[0].getPodYdCd());
						}else{
							prdMainInfoVO.setPod1N(null);
						}						
						prdMainInfoVO.setPod1C(vslSkdVOs[0].getPodClptIndSeq());
						prdMainInfoVO.setPol1(vslSkdVOs[0].getPolCd());
						if(vslSkdVOs[0].getPolYdCd() != null && vslSkdVOs[0].getPolYdCd().length() > 0){
							prdMainInfoVO.setPol1N(vslSkdVOs[0].getPolCd()+vslSkdVOs[0].getPolYdCd());
						}else{
							prdMainInfoVO.setPol1N(null);
						}
						prdMainInfoVO.setPol1C(vslSkdVOs[0].getPolClptIndSeq());
						prdMainInfoVO.setVvd1(vslSkdVOs[0].getBkgVvdCd());
						
						prdMainInfoVO.setLane1(null);				
					}else{
						prdMainInfoVO = util.resetNthRoute(prdMainInfoVO, 1);
					}
					if(vslSkdVOs.length > 1){
						prdMainInfoVO.setPod2(vslSkdVOs[1].getPodCd());
						if(vslSkdVOs[1].getPodYdCd() != null && vslSkdVOs[1].getPodYdCd().length() > 0){
							prdMainInfoVO.setPod2N(vslSkdVOs[1].getPodCd()+vslSkdVOs[1].getPodYdCd());
						}else{
							prdMainInfoVO.setPod2N(null);
						}					
						prdMainInfoVO.setPod2C(vslSkdVOs[1].getPodClptIndSeq());
						prdMainInfoVO.setPol2(vslSkdVOs[1].getPolCd());
						if(vslSkdVOs[1].getPolYdCd() != null && vslSkdVOs[1].getPolYdCd().length() > 0){
							prdMainInfoVO.setPol2N(vslSkdVOs[1].getPolCd()+vslSkdVOs[1].getPolYdCd());
						}else{
							prdMainInfoVO.setPol2N(null);
						}					
						prdMainInfoVO.setPol2C(vslSkdVOs[1].getPolClptIndSeq());
						prdMainInfoVO.setVvd2(vslSkdVOs[1].getBkgVvdCd());
						prdMainInfoVO.setLane2(null);				
					}else{
						prdMainInfoVO = util.resetNthRoute(prdMainInfoVO, 2);			
					}
					if(vslSkdVOs.length > 2){
						prdMainInfoVO.setPod3(vslSkdVOs[2].getPodCd());
						if(vslSkdVOs[2].getPodYdCd() != null && vslSkdVOs[2].getPodYdCd().length() > 0){
							prdMainInfoVO.setPod3N(vslSkdVOs[2].getPodCd()+vslSkdVOs[2].getPodYdCd());
						}else{
							prdMainInfoVO.setPod3N(null);
						}					
						prdMainInfoVO.setPod3C(vslSkdVOs[2].getPodClptIndSeq());
						prdMainInfoVO.setPol3(vslSkdVOs[2].getPolCd());
						if(vslSkdVOs[2].getPolYdCd() != null && vslSkdVOs[2].getPolYdCd().length() > 0){
							prdMainInfoVO.setPol3N(vslSkdVOs[2].getPolCd()+vslSkdVOs[2].getPolYdCd());
						}else{
							prdMainInfoVO.setPol3N(null);
						}					
						prdMainInfoVO.setPol3C(vslSkdVOs[2].getPolClptIndSeq());
						prdMainInfoVO.setVvd3(vslSkdVOs[2].getBkgVvdCd());
						prdMainInfoVO.setLane3(null);				
					}else{
						prdMainInfoVO = util.resetNthRoute(prdMainInfoVO, 3);			
					}
					if(vslSkdVOs.length > 3){
						prdMainInfoVO.setPod4(vslSkdVOs[3].getPodCd());
						if(vslSkdVOs[3].getPodYdCd() != null && vslSkdVOs[3].getPodYdCd().length() > 0){
							prdMainInfoVO.setPod4N(vslSkdVOs[3].getPodCd()+vslSkdVOs[3].getPodYdCd());
						}else{
							prdMainInfoVO.setPod4N(null);
						}					
						prdMainInfoVO.setPod4C(vslSkdVOs[3].getPodClptIndSeq());
						prdMainInfoVO.setPol4(vslSkdVOs[3].getPolCd());
						if(vslSkdVOs[3].getPolYdCd() != null && vslSkdVOs[3].getPolYdCd().length() > 0){
							prdMainInfoVO.setPol4N(vslSkdVOs[3].getPolCd()+vslSkdVOs[3].getPolYdCd());
						}else{
							prdMainInfoVO.setPol4N(null);
						}				
						prdMainInfoVO.setPol4C(vslSkdVOs[3].getPolClptIndSeq());
						prdMainInfoVO.setVvd4(vslSkdVOs[3].getBkgVvdCd());
						prdMainInfoVO.setLane4(null);				
					}else{
						prdMainInfoVO = util.resetNthRoute(prdMainInfoVO, 4);			
					}			
					prdMainInfoVO.setPmF("N");	
					prdMainInfoVO.setDgF((bkgForCopyVO.getDcgoFlg()  != null)?bkgForCopyVO.getDcgoFlg():"N");			
					prdMainInfoVO.setRfF((bkgForCopyVO.getRcFlg()    != null)?bkgForCopyVO.getRcFlg():"N");					
					prdMainInfoVO.setAkF((bkgForCopyVO.getAwkCgoFlg()!= null)?bkgForCopyVO.getAwkCgoFlg():"N");				
					prdMainInfoVO.setBbF((bkgForCopyVO.getBbCgoFlg() != null)?bkgForCopyVO.getBbCgoFlg():"N");				
					prdMainInfoVO.setHgF((bkgForCopyVO.getHngrFlg()  != null)?bkgForCopyVO.getHngrFlg():"N");	

					prdMainInfoVO.setRfa(bkgForCopyVO.getRfaNo());
					prdMainInfoVO.setSc(bkgForCopyVO.getScNo());
					prdMainInfoVO.setBkgNo(bkgForCopyVO.getBkgNo());	
					
					// BkgBlNoVO 생성
					BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
					bkgBlNoVO.setBkgNo(bkgForCopyVO.getBkgNo());
								
					prdParameterVO.setBkgBlNoVO(bkgBlNoVO);
					prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
					
					String tmpVvd1 = prdParameterVO.getPrdMainInfoVO().getVvd1();
					String tmpVvd2 = prdParameterVO.getPrdMainInfoVO().getVvd2();
					String tmpVvd3 = prdParameterVO.getPrdMainInfoVO().getVvd3();
					String tmpVvd4 = prdParameterVO.getPrdMainInfoVO().getVvd4();
					
					prdParameterVO = util.searchPrdParmForFullRoute(prdParameterVO);
					
					// VVD null 이면 다시 파라미터 null 로 해줌 (node, seq 도) // mds
					if(vslSkdVOs.length > 0 && (tmpVvd1 == null || tmpVvd1.equals(""))){
						prdParameterVO.getPrdMainInfoVO().setVvd1("");
						prdParameterVO.getPrdMainInfoVO().setPol1N("");
						prdParameterVO.getPrdMainInfoVO().setPol1C("");
						prdParameterVO.getPrdMainInfoVO().setPod1N("");
						prdParameterVO.getPrdMainInfoVO().setPod1C("");
						prdParameterVO.getPrdMainInfoVO().setLane1("");
					}
					if(vslSkdVOs.length > 1 && (tmpVvd2 == null || tmpVvd2.equals(""))){
						prdParameterVO.getPrdMainInfoVO().setVvd2("");
						prdParameterVO.getPrdMainInfoVO().setPol2N("");
						prdParameterVO.getPrdMainInfoVO().setPol2C("");
						prdParameterVO.getPrdMainInfoVO().setPod2N("");
						prdParameterVO.getPrdMainInfoVO().setPod2C("");
						prdParameterVO.getPrdMainInfoVO().setLane2("");
					}
					if(vslSkdVOs.length > 2 && (tmpVvd3 == null || tmpVvd3.equals(""))){
						prdParameterVO.getPrdMainInfoVO().setVvd3("");
						prdParameterVO.getPrdMainInfoVO().setPol3N("");
						prdParameterVO.getPrdMainInfoVO().setPol3C("");
						prdParameterVO.getPrdMainInfoVO().setPod3N("");
						prdParameterVO.getPrdMainInfoVO().setPod3C("");
						prdParameterVO.getPrdMainInfoVO().setLane3("");
					}
					if(vslSkdVOs.length > 3 && (tmpVvd4 == null || tmpVvd4.equals(""))){
						prdParameterVO.getPrdMainInfoVO().setVvd4("");
						prdParameterVO.getPrdMainInfoVO().setPol4N("");
						prdParameterVO.getPrdMainInfoVO().setPol4C("");
						prdParameterVO.getPrdMainInfoVO().setPod4N("");
						prdParameterVO.getPrdMainInfoVO().setPod4C("");
						prdParameterVO.getPrdMainInfoVO().setLane4("");
					}
					
					String prdLog = util.prdParameterLog(prdParameterVO.getPrdMainInfoVO());
					
					//ocean route check 
					if(!"HJXX".equals(prdParameterVO.getPrdMainInfoVO().getTVvd().substring(0,4))
							&&!"HJYY".equals(prdParameterVO.getPrdMainInfoVO().getTVvd().substring(0,4))
							&&!"HJZZ".equals(prdParameterVO.getPrdMainInfoVO().getTVvd().substring(0,4))){
						receiptBC.validateOceanRoute(prdParameterVO.getPrdMainInfoVO());
					}
					
					prdParameterVO.getPrdMainInfoVO().setFCmd("3");
					prdParameterVO.getPrdMainInfoVO().setPcMode("B");
					// Create시 Booking번호를 빼고 보낸다.
					prdParameterVO.getPrdMainInfoVO().setBkgNo("");
					prdParameterVO.getBkgBlNoVO().setBkgNo("");
					
					// 03. createProdCtlRout	
					ProductCatalogCreateBC proBC = new ProductCatalogCreateBCImpl();
					try{
						pctlNo= proBC.createPrdCtlgRout(prdParameterVO, account);
					} catch (Exception pc_ex){
						eventResponse.setETCData("IsPctlNoPop", "YC");
						
						eventResponse.setETCData(prdParameterVO.getPrdMainInfoVO().getColumnValues());	
						eventResponse.setRsVoList(prdParameterVO.getPrdQtyInfo());	
						
						log.debug("Pctl Pop Up Call");
						if(pc_ex.getMessage().indexOf("PRD00058") < 0 			//Not Available M'ty Pick Up Date
								&& pc_ex.getMessage().indexOf("PRD00077") < 0){ //Created more than a single P/C
							log.error(pc_ex.getMessage() + prdLog);
						}
						rollback();
						return eventResponse;
					}
					if(pctlNo.trim() == null || pctlNo.trim().length() < 1 || "FAIL".equals(pctlNo)){
						eventResponse.setETCData("IsPctlNoPop", "YC");
						
						eventResponse.setETCData(prdParameterVO.getPrdMainInfoVO().getColumnValues());	
						eventResponse.setRsVoList(prdParameterVO.getPrdQtyInfo());	
						
						log.debug("Pctl Pop Up Call");
						rollback();
						return eventResponse;
					}
				}
			}					
			eventResponse = copyBkgInfo(e, pctlNo);
			eventResponse.setETCData("isSuccess","Y");
		}catch(EventException ex){
			rollback();
//			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		return eventResponse;
	}		
	
	/**
	 * ESM_BKG_0077 : copy <br>
	 * Route 미변경시 Booking Copy한다.<br>
	 * 
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse copyBkgWithRoute(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			eventResponse = copyBkgInfo(e, "");
			eventResponse.setETCData("isSuccess","Y");
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
		return eventResponse;
	}
	
	/**
	 * copyBkgWithoutRoute(), copyBkgWithRoute()에 실행한다 <br>
	 * Booking Copy처리<br>
	 * 
	 * @author KimByungKyu
	 * @param Event e, String pctlNo
	 * @return GeneralEventResponse
	 * @exception EventException
	 */	
	@SuppressWarnings("unchecked")
	private GeneralEventResponse copyBkgInfo(Event e, String pctlNo) throws EventException{
		try{
			EsmBkg0077Event 		event 			= (EsmBkg0077Event)e;
			GeneralEventResponse 	eventResponse 	= new GeneralEventResponse();
			GeneralBookingReceiptBC receiptBC 		= new GeneralBookingReceiptBCImpl();
			GeneralBookingSearchBC 	searchBC 		= new GeneralBookingSearchBCImpl();
			BLDocumentationCMBC 	blDocCmBC 		= new BLDocumentationCMBCImpl();
//			BLDocumentationBLBC 	blDocBlBC 		= new BLDocumentationBLBCImpl();
			BlRatingBC 				blRatingBC 		= new BlRatingBCImpl();
			BookingHistoryMgtBC  	historyBC 		= new BookingHistoryMgtBCImpl();
			BookingUtil 		    util 			= new BookingUtil();

			SpecialCargoReceiptBC 	spclCgoReceiptBC= new SpecialCargoReceiptBCImpl();
			ProductCatalogCreateBC 	prdBC 			= new ProductCatalogCreateBCImpl();
			BkgCopManageBC 			copBC 			= new BkgCopManageBCImpl();
			

			OwnContainerBookingForecastMgtBC owncontainer = new OwnContainerBookingForecastMgtBCImpl();

			int copyCnt = Integer.parseInt(event.getCopyCnt());
			String vvdModifyFlg = event.getVvdModifyFlg();
			
			BookingCopyVO bookingCopyVO = new BookingCopyVO();
			bookingCopyVO.setBkgForCopyVO(event.getBkgForCopyVO());
			bookingCopyVO.setVslSkdVOs(event.getVslSkdVOs());
			
			String routePctlNo = "";
			String bkgNoForPctlNo = "";
			
			if("Y".equals(vvdModifyFlg)){
				bkgNoForPctlNo = event.getBkgForCopyVO().getBkgNo();
			}
//			String trnkVslCd = event.getBkgForCopyVO().getBkgTrunkVvd().substring(0,4);
//			String preVslCd = "";
//			if(!"T".equals(event.getVslSkdVOs()[0].getVslPrePstCd())){
//				preVslCd = event.getVslSkdVOs()[0].getBkgVvdCd().substring(0,4);
//			}
						
			String newBkgNum = "";
			String copyToHistStr = "";
			
			// 원본 BKG 현재 정보 조회
			HistoryTableVO historyTableVO1 = historyBC.searchOldBkgForHistory("ESM_BKG_0079_01", event.getBkgBlNoVO());
			String custEml = "";
			for(int j = 0; j < historyTableVO1.getBkgCntcPsonVOs().size(); j++){
				if(historyTableVO1.getBkgCntcPsonVOs().get(j).getBkgCntcPsonTpCd().equals("BK")){
					custEml = historyTableVO1.getBkgCntcPsonVOs().get(j).getCntcPsonEml();
				}
			}	
			String obSrepCd = historyTableVO1.getBkgBookingVO().getObSrepCd();
			String srepEml = searchBC.searchSrepEml(obSrepCd);//S.Rep e-Mail 조회
			
			for(int i = 0 ; i < copyCnt ; i++){
				begin();
				// 22. createProdCtlRout 수행 - VVD 변경시 2번째 Copy Booking부터, 미변경시 첫번째 VVD부터
				if("Y".equals(vvdModifyFlg)){
					if(i > 0){
						routePctlNo = searchPctlNoForCopy(event.getBkgForCopyVO(), event.getVslSkdVOs(), "N", bkgNoForPctlNo);		
					} else {
						// PRD POP-UP이 띄워져서 받아온 PCTL NO
						routePctlNo = pctlNo;
					}
				}else{
					routePctlNo = searchPctlNoForCopy(event.getBkgForCopyVO(), event.getVslSkdVOs(), "N", bkgNoForPctlNo);
				}
				log.debug("bkgNoForPctlNo:["+bkgNoForPctlNo+"],"+routePctlNo+":["+routePctlNo+ "]");
				
				bookingCopyVO.getBkgForCopyVO().setPctlNo(routePctlNo);
				// 23. Booking번호 생성
				BkgBlNoVO newBkgNoVO = util.manageBkgNumberGeneration("BKG", account.getOfc_cd(), account.getUsr_id());

				bkgNoForPctlNo = newBkgNoVO.getBkgNo()+"00";
				newBkgNoVO.setBlNo(bkgNoForPctlNo);
				newBkgNoVO.setBkgNo(bkgNoForPctlNo);
				
				String [] pctlNoMapSeq = util.splitByToken(routePctlNo, "|");
				newBkgNoVO.setPctlNo(pctlNoMapSeq[0]);
				
//----------------------------------------------------------------------------------------------------------------
				BkgCloseVO bkgCloseVO = null;
				BkgBlNoVO closeBkgBlNoVO = new BkgBlNoVO();
				closeBkgBlNoVO.setBkgNo(newBkgNoVO.getBkgNo());
				closeBkgBlNoVO.setPctlNo(routePctlNo);
				String closeVvd = "";
				String closeBkgMsg = "";
				
				if(!"Y".equals(event.getCloseBkgFlag())){
					
					bkgCloseVO = util.searchBkgClose(closeBkgBlNoVO, account.getOfc_cd());		
					if(bkgCloseVO != null){
								
						String[] strParam = new String[11];
						strParam[0] = newBkgNum.replace("||", ",");
						strParam[1] = "";
						strParam[2] = "";
						strParam[3] = "";
						strParam[4] = "";
						strParam[5] = "";
						strParam[6] = bkgCloseVO.getNewVvd();
						strParam[7] = bkgCloseVO.getPorCd() + " / " + bkgCloseVO.getNewPolCd() + " / " + bkgCloseVO.getPodCd() + " / " + bkgCloseVO.getDelCd();
						strParam[10] = bkgCloseVO.getNewCntrList();				
						
						closeBkgMsg = util.makeBkgCloseMsg(strParam, "B");
						closeVvd = bkgCloseVO.getCloseVvd();
						
						eventResponse.setETCData("closeBkgFlag", "Y");
						
						eventResponse.setETCData("closeBkgResult", "Y");
						eventResponse.setETCData("first_vvd", closeVvd);
						eventResponse.setETCData("closeBkgMsg", closeBkgMsg);		
						
						return eventResponse;
					} 
				}
				if(!"Y".equals(event.getCbfBkgFlag())){
					boolean isCbfFinal = false;
					bkgCloseVO = util.searchBkgCbf(newBkgNoVO);
					if ( bkgCloseVO != null && bkgCloseVO.getNewVvd() != null && !bkgCloseVO.getNewVvd().trim().equals("")){
						String[] arrCBF  = owncontainer.searchCBFBS(bkgCloseVO.getNewVvd().substring(0, 4), bkgCloseVO.getNewVvd().substring(4, 8), bkgCloseVO.getNewVvd().substring(8, 9), bkgCloseVO.getNewYdCdSeq());
						for (int j=0;j<arrCBF.length;j++){
							if(j%4 == 0){
								if("Final".equals(arrCBF[j])){
									isCbfFinal = true;
									break;
								}
							}
						}	
						if(arrCBF != null && isCbfFinal == true){
							String[] strParam = new String[11];
							strParam[0] = newBkgNum.replace("||", ",");
							strParam[1] = "";
							strParam[2] = "";
							strParam[3] = "";
							strParam[4] = "";
							strParam[5] = "";
							strParam[6] = bkgCloseVO.getNewVvd();
							strParam[7] = bkgCloseVO.getPorCd() + " / " + bkgCloseVO.getNewPolCd() + " / " + bkgCloseVO.getPodCd() + " / " + bkgCloseVO.getDelCd();
							strParam[10] = bkgCloseVO.getNewCntrList();				
							
							closeBkgMsg = util.makeBkgCloseMsg(strParam, "B");
							closeVvd = bkgCloseVO.getCloseVvd();	
							
							eventResponse.setETCData("cbfBkgFlag", "Y");
							
							eventResponse.setETCData("closeBkgResult", "Y");
							eventResponse.setETCData("first_vvd", closeVvd);
							eventResponse.setETCData("closeBkgMsg", closeBkgMsg);		
							
							return eventResponse;
						}
					}
				}
				
//----------------------------------------------------------------------------------------------------------------
				
				//copy후 화면에 보여줄 목록
				if(i < 1){
					newBkgNum = newBkgNoVO.getBkgNo();
					copyToHistStr = newBkgNoVO.getBkgNo();
				}else{
//					newBkgNum = newBkgNum + "||" + newBkgNoVO.getBkgNo();
					StringBuffer tmpBuffer = new StringBuffer(newBkgNum).append("||").append(newBkgNoVO.getBkgNo());
					newBkgNum = tmpBuffer.toString();
//					copyToHistStr = copyToHistStr+", "+newBkgNoVO.getBkgNo();
					StringBuffer tmpBuffer2 = new StringBuffer(copyToHistStr).append(", ").append(newBkgNoVO.getBkgNo());
					copyToHistStr = tmpBuffer2.toString();
				}
				
				// 24. Copy Booking
				receiptBC.copyBooking(bookingCopyVO, event.getBkgBlNoVO(), newBkgNoVO, account);
				
				// 37. Copy BkgBlDoc
//				blDocCmBC.copyBkgBlDoc(trnkVslCd, preVslCd, event.getBkgBlNoVO(), newBkgNoVO, account);
				blDocCmBC.copyBkgBlDoc("", "", event.getBkgBlNoVO(), newBkgNoVO, account);
				
				// VNSGN -> KNPNH 에 대해 BL Clause 자동 문구 삽입 요청
				List<VslSkdVO> routeDetails = receiptBC.searchVvdSkdForTsRoute(newBkgNoVO);
				if(routeDetails.get(routeDetails.size() - 1).getPolCd().equals(Constants.BL_CLAUSE_POL)
						&& routeDetails.get(routeDetails.size() - 1).getPodCd().equals(Constants.BL_CLAUSE_POD)){
					BLDocumentationBLBC blBC = new BLDocumentationBLBCImpl();
					MndVO mndVO = new MndVO();
					mndVO.setBkgNo(newBkgNoVO.getBkgNo());
					blBC.manageMndCmdtDescKHPNH(mndVO, account, "N");
				}
				
				PerformanceReportBC performReportBc = new PerformanceReportBCImpl();
				performReportBc.manageQtyCntrCoposite(newBkgNoVO.getBkgNo(), "CQ");
				BkgForCopyVO bkgForCopyVO = bookingCopyVO.getBkgForCopyVO();
				
				// Allocation Status 
				AllocStsChgVO allocStsChgVO = receiptBC.manageAlocStatus(newBkgNoVO, account, "");
				List<BkgNtcHisVO> bkgNtcHisVOs = allocStsChgVO.getBkgNtcHisVOs();
				if (null!=bkgNtcHisVOs) {
					historyBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0077");
				}// Allocation Status History 는 아래에
				
				//dummy가 아닌 sc나 rfa, taa가 입력되었을 때  
				if((bkgForCopyVO.getScNo().length()>0 &&!"DUM".equals(bkgForCopyVO.getScNo().substring(0, 3)))
						||(bkgForCopyVO.getRfaNo().length()>0 &&!"DUM".equals(bkgForCopyVO.getRfaNo().substring(0, 3)))
						||(bkgForCopyVO.getTaaNo().length()>0 &&!"DUM".equals(bkgForCopyVO.getTaaNo().substring(0, 3)))){		
					BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
					bkgDocProcSkdVO.setBkgNo(newBkgNoVO.getBkgNo());
					bkgDocProcSkdVO.setBkgDocProcTpCd("CTRTNO");// contract no input for doc performance
					historyBC.manageDocProcess(bkgDocProcSkdVO, account);
				}
				
				// 39. copySpclCgoByBkg
				List<SelectSpclCgoVO> selectSpclCgo = new ArrayList<SelectSpclCgoVO>();
				if("Y".equals(event.getBkgForCopyVO().getDcgoFlg())){
					SelectSpclCgoVO selectSpclCgoVO = new SelectSpclCgoVO();
					selectSpclCgoVO.setSpclCagoFlag("D");
					
					selectSpclCgo.add(selectSpclCgoVO);
				}
				if("Y".equals(event.getBkgForCopyVO().getRcFlg())){
					SelectSpclCgoVO selectSpclCgoVO = new SelectSpclCgoVO();
					selectSpclCgoVO.setSpclCagoFlag("R");
					
					selectSpclCgo.add(selectSpclCgoVO);
				}
				if("Y".equals(event.getBkgForCopyVO().getAwkCgoFlg())){
					SelectSpclCgoVO selectSpclCgoVO = new SelectSpclCgoVO();
					selectSpclCgoVO.setSpclCagoFlag("A");
					
					selectSpclCgo.add(selectSpclCgoVO);
				}
				if("Y".equals(event.getBkgForCopyVO().getBbCgoFlg())){
					SelectSpclCgoVO selectSpclCgoVO = new SelectSpclCgoVO();
					selectSpclCgoVO.setSpclCagoFlag("B");
					
					selectSpclCgo.add(selectSpclCgoVO);
				}			
				BkgBlNoVO[] bkgBlNoVOs = new BkgBlNoVO[1];
				bkgBlNoVOs[0] = newBkgNoVO;
				spclCgoReceiptBC.copySpclCgoByBkg("C", event.getBkgBlNoVO(), bkgBlNoVOs, selectSpclCgo, account);
				
				receiptBC.changeBkgStatus("Y", newBkgNoVO, false, account);
				
				blRatingBC.createRateForTro(newBkgNoVO.getBkgNo(),"N", account);
				// 44. createBkg(타 모듈 호출)
				copBC.createBkg(newBkgNoVO.getBkgNo(), newBkgNoVO.getPctlNo());
								
				// 45. interfaceCoa(타 모듈 호출), Standby 계산 뒤로 이동 
//				interfaceToMas(newBkgNoVO, "Booking Create", account);
				
				// 46. createBkgHistoryLine
				// History 정보
				String hisCateNm      = "Booking Copy"; 
				String crntCtnt       = "Copied From "+event.getBkgBlNoVO().getBkgNo();
				HistoryLineVO historyLineVO = new HistoryLineVO();
				historyLineVO.setBkgNo(newBkgNoVO.getBkgNo());
				historyLineVO.setCaFlg("N");
				historyLineVO.setUiId("ESM_BKG_0077");
				historyLineVO.setCrntCtnt(crntCtnt);
				historyLineVO.setHisCateNm(hisCateNm);
				historyLineVO.setBkgDocProcTpCd("CPYCRE");
				historyBC.createBkgHistoryLine(historyLineVO, account);	
				
				// Allocation Status History 
				if(allocStsChgVO != null){
					HistoryLineVO historyLineVO2 = new HistoryLineVO();
					historyLineVO2.setUiId("ESM_BKG_0077");			
					historyLineVO2.setHisCateNm("Booking Status");
					historyLineVO2.setBkgNo(newBkgNoVO.getBkgNo());
					historyLineVO2.setCaFlg("N");
					if (allocStsChgVO == null || allocStsChgVO.getAlocStsCd() == null){
						log.debug("Null Check");
					} else if ((allocStsChgVO.getOriAlocStsCd() == null || "".equals(allocStsChgVO.getOriAlocStsCd())) && "S".equals(allocStsChgVO.getAlocStsCd())){
						historyLineVO2.setCrntCtnt("Allocation Status change to S");
						historyBC.createBkgHistoryLine(historyLineVO2, account);
					} else if ((allocStsChgVO.getOriAlocStsCd() == null || "".equals(allocStsChgVO.getOriAlocStsCd())) && "F".equals(allocStsChgVO.getAlocStsCd())){
						historyLineVO2.setCrntCtnt("Allocation Status change to F");
						historyBC.createBkgHistoryLine(historyLineVO2, account);	
					} else if ( "F".equals(allocStsChgVO.getOriAlocStsCd()) && "S".equals(allocStsChgVO.getAlocStsCd()) ){
						historyLineVO2.setCrntCtnt("Allocation Status change F to S");
						historyBC.createBkgHistoryLine(historyLineVO2, account);
					} else if ( "S".equals(allocStsChgVO.getOriAlocStsCd()) && "F".equals(allocStsChgVO.getAlocStsCd()) ){
						historyLineVO2.setCrntCtnt("Allocation Status change S to F");
						historyBC.createBkgHistoryLine(historyLineVO2, account);
					}
				}
				// Allocation Status History 끝

				commit();
				
				try{
					String fromDt = null;
					String toDt = null;
					
					if("US".equals(event.getVslSkdVOs()[0].getPolCd().substring(0, 2))
							|| "CA".equals(event.getVslSkdVOs()[0].getPolCd().substring(0, 2))){
						// cut off time (cop 생성 이후에 처리)
						PrdQtyInfoVO[] prdQtyInfo 	= receiptBC.searchBkgQtyForRailTime(newBkgNoVO);
											
						Map railTime = prdBC.getRailRecevingTime(newBkgNoVO.getPctlNo(), prdQtyInfo, null, null, newBkgNoVO.getBkgNo());

						fromDt= (String)railTime.get("RTN_TIME");
						toDt  = (String)railTime.get("CUT_OFF");
					}
					begin(); //batch 서버 접속해야되서 Transaction을 분리함
					receiptBC.createCargoClosingTime(newBkgNoVO, fromDt, toDt, account);	
					commit();
				} catch(Exception prdEx){
					rollback();
					log.error("err " + prdEx.toString(), prdEx);					
				}
				
				// 2014.09.24 [CHM-201431658] 한진해운 조기결산을 위한 개선 방안 중 BKG 관리 프로세스 단축(안) 개발(S)
				begin();
				String oldNoRtStsCd = "";
				String newNoRtStsCd = "";
				String noRtNtc_snd_flg = "N";
				String noRtNtc_snd_cust_flg = "N";
				String sc_no = bkgForCopyVO.getScNo();
				String rfa_no = bkgForCopyVO.getRfaNo();
				String taa_no = bkgForCopyVO.getTaaNo();
				OftPrecheckVO oftPrecheckVO = new OftPrecheckVO();
				try{//기존 별도 트랜젝션으로 화면에서 호출 하던 부분	
					if(rfa_no!=null && rfa_no.length() > 2 ){
						oftPrecheckVO = searchRfaOftPrecheckResult(newBkgNoVO, rfa_no, account);
					}else if(sc_no!=null && sc_no.length() > 2 ){
						oftPrecheckVO = searchScOftPrecheckResult(newBkgNoVO, sc_no, account);
					}else if(taa_no!=null && taa_no.length() > 2 ){
						oftPrecheckVO = searchTaaOftPrecheckResult(newBkgNoVO, taa_no, account);
					}else{
						oftPrecheckVO.setNonRtStsCd("R");
						oftPrecheckVO.setChkOft("");
						oftPrecheckVO.setApplicationDt("");
						oftPrecheckVO.setFrtTermCd("");
						oftPrecheckVO.setSvcScpCd("");
					}
				}catch(EventException ex){
					log.error("No Rate Status check Error : "+newBkgNoVO.getBkgNo(), ex);
					oftPrecheckVO.setNonRtStsCd("");
					oftPrecheckVO.setChkOft("");
					oftPrecheckVO.setApplicationDt("");
					oftPrecheckVO.setFrtTermCd("");
					oftPrecheckVO.setSvcScpCd("");
				}
				
				// CMPB 산출
				try{
					if("Y".equals(oftPrecheckVO.getChkOft()) ){
						BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
						bkgHrdCdgCtntListCondVO.setHrdCdgId("NO_RATE_PROC_CTR");			
						List<BkgHrdCdgCtntVO> BkgHrdCdgCtntVOs = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
						
						String createCmpb = "";
						if(BkgHrdCdgCtntVOs.size() > 0){
							createCmpb = BkgHrdCdgCtntVOs.get(0).getAttrCtnt4();// BKG modify CMPB 생성
						}
						if(!"N".equals(createCmpb)){
							//createContributionMarginPerBox(newBkgNoVO);
							// 2015.12.03 [CHM-201538812] MAS time out 방지위해 1,2 로 나눔
							BkgCmpbVO BkgCmpbVO = createContributionMarginPerBox1(newBkgNoVO, oftPrecheckVO);
							commit();
							begin();
							createContributionMarginPerBox2(newBkgNoVO,BkgCmpbVO);
						}
					}
					commit();
				}catch(EventException ex){
					log.error("create CMPB Error : "+newBkgNoVO.getBkgNo(), ex);
					rollback();
				}				
				
				begin();
				if(oftPrecheckVO!=null && oftPrecheckVO.getNonRtStsCd()!=null && !oldNoRtStsCd.equals(oftPrecheckVO.getNonRtStsCd())){
					newNoRtStsCd = oftPrecheckVO.getNonRtStsCd();
					//no_rt_sts_cd Update
					
					int updCnt = receiptBC.modifyNoRtStsCd(newBkgNoVO, newNoRtStsCd, account);
					//Create엔 History 불필요 -> 유저 요청으로 생성시에도 History 남김
					if(updCnt > 0){
						HistoryLineVO historyLineVO2 = new HistoryLineVO();
						historyLineVO2.setUiId("ESM_BKG_0079_01");			
						historyLineVO2.setHisCateNm("No Rate Status");
						historyLineVO2.setBkgNo(newBkgNoVO.getBkgNo());
						historyLineVO2.setCaFlg(newBkgNoVO.getCaFlg());
						historyLineVO2.setPreCtnt(oldNoRtStsCd);
						historyLineVO2.setCrntCtnt(newNoRtStsCd);
						historyBC.createBkgHistoryLine(historyLineVO2, account);
						
						//Reciept Notice 는 Allocation Status 까지 확인 후 발송 (메일 발송은 commit 이후)
						//-> !R : Reciept Notice
						//->  R : No Rate Notice
						if("R".equals(oftPrecheckVO.getNonRtStsCd())){
							noRtNtc_snd_flg = "Y";// (메일 발송은 commit 이후)
						}
						String noRtNtcForCust = searchBC.searchNoRateNoticeToCustomerBlock(newBkgNoVO);
						if("N".equals(noRtNtcForCust)){
							noRtNtc_snd_cust_flg = "Y";// NoRateNotice to Customer
							
							BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
							bkgDocProcSkdVO.setBkgNo(newBkgNoVO.getBkgNo());
							bkgDocProcSkdVO.setBkgDocProcTpCd("NORTNC");//NoRateNoticeForCustomer
							historyBC.manageDocProcess(bkgDocProcSkdVO, account);	
						}
					}
				}
				commit();
				//(E)
				
				// SPC-BKG 연동 (NoRateStatus Firm 일 때만 SPC Aloc 체크)
				if("F".equals(oldNoRtStsCd) || "F".equals(newNoRtStsCd)){
					ConstraintMasterBC		spcBC = new ConstraintMasterBCImpl();	
					List<SpcSbBkgDtlVO> spcSbBkgDtlVO = new ArrayList<SpcSbBkgDtlVO>();
					boolean spcErrFlg = false;
					try{
						begin();
						spcSbBkgDtlVO = spcBC.standbyCheck4Bkg(newBkgNoVO.getBkgNo(), account);
						commit();
					} catch(Exception spcEx){
						rollback();
						log.error("SPC Allocation error : " + spcEx.toString(), spcEx);
						spcErrFlg = true;
					}
					begin();
					String alocPopFlg = "";
					if(spcErrFlg){
						//Error
						AllocStsVO allocStsVO = new AllocStsVO();
						allocStsVO.setAlocStsCd("");
						AllocStsChgVO allocStsChgVO2 = receiptBC.modifyAllocStatusForBkg(newBkgNoVO, allocStsVO, account);
						// history
						HistoryLineVO historyLineVO2 = new HistoryLineVO();
						historyLineVO2.setUiId("ESM_BKG_0079_01");			
						historyLineVO2.setHisCateNm("Allocation Status");
						historyLineVO2.setBkgNo(newBkgNoVO.getBkgNo());
						historyLineVO2.setCaFlg("N");
						historyLineVO2.setCrntCtnt("Error");
						historyLineVO2.setPreCtnt(allocStsChgVO2.getOriAlocStsCd());
						historyBC.createBkgHistoryLine(historyLineVO2, account);
						
					}else if(spcSbBkgDtlVO == null || spcSbBkgDtlVO.size()==0){
						//F
						AllocStsVO allocStsVO = new AllocStsVO();
						allocStsVO.setAlocStsCd("F");
						AllocStsChgVO allocStsChgVO2 = receiptBC.modifyAllocStatusForBkg(newBkgNoVO, allocStsVO, account);
						// history
						if(!allocStsChgVO2.getAlocStsCd().equals(allocStsChgVO2.getOriAlocStsCd())){
							HistoryLineVO historyLineVO2 = new HistoryLineVO();
							historyLineVO2.setUiId("ESM_BKG_0079_01");			
							historyLineVO2.setHisCateNm("Allocation Status");
							historyLineVO2.setBkgNo(newBkgNoVO.getBkgNo());
							historyLineVO2.setCaFlg("N");
							historyLineVO2.setCrntCtnt("F");
							historyLineVO2.setPreCtnt(allocStsChgVO2.getOriAlocStsCd());
							historyBC.createBkgHistoryLine(historyLineVO2, account);
						}
					}else if(spcSbBkgDtlVO != null && spcSbBkgDtlVO.size()>0){
						//A ,기존 Allocation 로직이 우선, 기존 로직으로 Standby 걸리지 않을 때만 SPC 로직 적용
						if(allocStsChgVO==null || allocStsChgVO.getAlocStsCd()==null || !"S".equals(allocStsChgVO.getAlocStsCd())){
							AllocStsVO allocStsVO = new AllocStsVO();
							for(int j=0; j<spcSbBkgDtlVO.size(); j++){
		 						if(spcSbBkgDtlVO.get(j).getAlocSvcCd()!=null && "M".equals(spcSbBkgDtlVO.get(j).getAlocSvcCd())){
		 							alocPopFlg = "Y";
		 							allocStsVO.setAlocSvcCd("M");
		 						}
		 					}
//							if(!"US".equals(event.getVslSkdVOs()[0].getPolCd().substring(0, 2))
//									&& !"CA".equals(event.getVslSkdVOs()[0].getPolCd().substring(0, 2))){
//								allocStsVO.setAlocStsCd("A");
//							}else{
								allocStsVO.setAlocStsCd("S");
//								if(!"Y".equals(alocPopFlg)){ 
//									allocStsVO.setStandbyNtcFlg("Y");
//								}
//							}
							AllocStsChgVO allocStsChgVO2 = receiptBC.modifyAllocStatusForBkg(newBkgNoVO, allocStsVO, account);
							// history
							if(!allocStsChgVO2.getAlocStsCd().equals(allocStsChgVO2.getOriAlocStsCd())){
								StringBuffer tmpBuffer = new StringBuffer(allocStsVO.getAlocStsCd());
								for(int j=0; j<spcSbBkgDtlVO.size(); j++){
									tmpBuffer.append("\n");
									tmpBuffer.append((spcSbBkgDtlVO.get(j).getLstSbRsnTpCd()==null)?"":spcSbBkgDtlVO.get(j).getLstSbRsnTpCd()).append("/");
									tmpBuffer.append((spcSbBkgDtlVO.get(j).getLstSbSubRsnCd()==null)?"":spcSbBkgDtlVO.get(j).getLstSbSubRsnCd()).append("/");
									tmpBuffer.append((spcSbBkgDtlVO.get(j).getAlocSvcCd()==null)?"":spcSbBkgDtlVO.get(j).getAlocSvcCd()).append("/");
									tmpBuffer.append((spcSbBkgDtlVO.get(j).getLstSbRsn()==null)?"":spcSbBkgDtlVO.get(j).getLstSbRsn());
								}
								HistoryLineVO historyLineVO2 = new HistoryLineVO();
								historyLineVO2.setUiId("ESM_BKG_0079_01");			
								historyLineVO2.setHisCateNm("Allocation Status");
								historyLineVO2.setBkgNo(newBkgNoVO.getBkgNo());
								historyLineVO2.setCaFlg("N");
								historyLineVO2.setCrntCtnt(tmpBuffer.toString());
								historyBC.createBkgHistoryLine(historyLineVO2, account);
							}
							if(allocStsChgVO2.getBkgNtcHisVOs().size()>0){
								historyBC.createBkgNtcHis(allocStsChgVO2.getBkgNtcHisVOs(), "ESM_BKG_0079_01");
							}
						}
					}
					commit();
				}
				// SPC-BKG 연동 (NoRateStatus Firm 일 때만 SPC Aloc 체크)(E)				
				
				// 45. interfaceCoa(타 모듈 호출), Standby 계산 뒤로 이동 
				begin();
				interfaceToMas(newBkgNoVO, "Booking Create", account);
				commit();
				
				// No Rate Notice 발송
				//  -> !R : Reciept Notice
				//  ->  R : No Rate Notice
				if("R".equals(oftPrecheckVO.getNonRtStsCd())){
					List<BkgNtcHisVO> bkgNtcHisVOs2 = new ArrayList<BkgNtcHisVO>();
					BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
					String sndId = null;
					Mail mail = null;
					String mailContents = null;
					
					String ssoTargetUrl = JSPUtil.getNull(SiteConfigFactory.get("COM.HANJIN.SSO.TARGET"));
					boolean isLive = false;     // Live 여부
					if (ssoTargetUrl.indexOf("alps.smlines.com") > 0) {
					    // 2017.04.10 iylee No Rate 대상이여도 메일 발송 하지 않음.
						//isLive = true;
					}
					if(isLive){
						if("Y".equals(noRtNtc_snd_cust_flg)){
							// No Rate Notice 발송 화주 (S)
							if(custEml!=null && !"".equals(custEml)){
								mailContents = getNoRateNoticeToCustomer(newBkgNoVO.getBkgNo());
								mail = new Mail();
								mail.setFrom("noreply@smlines.com");// 보내는사람
								mail.setRecipient(custEml);// 받는사람
								//mail.setRecipient("popcorn426@cyberlogitec.com");
								String reqNo = "";
								String custRefNoCtnt = receiptBC.searchCustRefNoCtnt(newBkgNoVO, "EBRF");
								if(custRefNoCtnt != null && custRefNoCtnt.length()>0){
									reqNo = "(Request No. "+custRefNoCtnt+")";
								}else{//BKG Request no. 없으면 BKG no.
									reqNo = "(Booking No. "+newBkgNoVO.getBkgNo()+")";
								}
								mail.setSubject("Customer Notice "+reqNo);// 제목
								mail.setHtmlContent(mailContents);
								sndId = mail.send();// 메일전송
								//발송 history 내용 생성
								bkgNtcHisVO = new BkgNtcHisVO();
								bkgNtcHisVO.setBkgNo(newBkgNoVO.getBkgNo());
								bkgNtcHisVO.setNtcViaCd("M");
								bkgNtcHisVO.setNtcKndCd("NR"); // No Rate Notice
								bkgNtcHisVO.setNtcEml(custEml);
								bkgNtcHisVO.setSndId(sndId);
								bkgNtcHisVO.setSndOfcCd("SYSTEM");
								bkgNtcHisVO.setSndUsrId("SYSTEM");
								bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
								bkgNtcHisVO.setCreUsrId(account.getUsr_id());
								bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
								bkgNtcHisVOs2.add(bkgNtcHisVO);
								// No Rate Notice 발송 화주 (E)
							}
						}
						if("Y".equals(noRtNtc_snd_flg) && isLive){
							//String srepEml = searchBC.searchSrepEml(bkgBookingInfoVO.getObSrepCd());//S.Rep e-Mail 조회
							if(srepEml != null && srepEml.length() > 0){
								// No Rate Notice 발송 S.Rep (S)
								mailContents = getNoRateNoticeToSrep(newBkgNoVO.getBkgNo());
								mail = new Mail();
								mail.setFrom("noreply@smlines.com");// 보내는사람
								mail.setRecipient(srepEml);// 받는사람
								mail.setSubject("No rate booking Notice (Booking No . "+newBkgNoVO.getBkgNo()+" )");// 제목
								mail.setHtmlContent(mailContents);
								sndId = mail.send();// 메일전송
								//No Rate Notice 발송 End S.Rep
								//발송 history
								bkgNtcHisVO = new BkgNtcHisVO();
								bkgNtcHisVO.setBkgNo(newBkgNoVO.getBkgNo());
								bkgNtcHisVO.setNtcViaCd("M");
								bkgNtcHisVO.setNtcKndCd("NR"); // No Rate Notice
								bkgNtcHisVO.setNtcEml(srepEml);
								bkgNtcHisVO.setSndId(sndId);
								bkgNtcHisVO.setSndOfcCd("SYSTEM");
								bkgNtcHisVO.setSndUsrId("SYSTEM");
								bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
								bkgNtcHisVO.setCreUsrId(account.getUsr_id());
								bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
								bkgNtcHisVOs2.add(bkgNtcHisVO);
								// No Rate Notice 발송 S.Rep (E)
							}
						}
						// BKG Notice History 생성
						historyBC.createBkgNtcHis(bkgNtcHisVOs2, "ESM_BKG_0077");
					}
				}
				
				// 07. sendBkgCustEdi
				searchBC.createCustBkgReceiptEdiBackEnd(newBkgNoVO, null, "Y", account);

				// 08. sendBkgTmlEdi
				// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
				Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
				vender301ParamVO.setBkgBlNoVO(newBkgNoVO);
				vender301ParamVO.setOldVvdVOs(null);
				vender301ParamVO.setOldQtyVOs(new ArrayList<BkgQuantityVO>());
				vender301ParamVO.setOldMtyPkupYdCd(null);
				vender301ParamVO.setBracCd("N");
				vender301ParamVO.setEdiKind("BT");
				vender301ParamVO.setAutoManualFlg("Y");
				
				searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);				

				// 09. psa I/f 대상 자동 전송부분 추가함. ( 전성진수석 요청 - 2010.09.07 - Ticket ID :  )
				this.managePSABKGAuto(newBkgNoVO.getBkgNo(), "N");
			}			
			
			eventResponse.setETCData("closeBkgFlag", "N");
			eventResponse.setETCData("cbfBkgFlag", "N");
			eventResponse.setETCData("closeBkgResult", "N");
			
			begin();
			
			// 46. createBkgHistoryLine
			// History 정보
			String hisCateNm      = "Booking Copy"; 
			String crntCtnt       = "Copied to "+copyToHistStr;
			HistoryLineVO historyLineVO = new HistoryLineVO();
			historyLineVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
			historyLineVO.setCaFlg("N");
			historyLineVO.setUiId("ESM_BKG_0077");
			historyLineVO.setCrntCtnt(crntCtnt);
			historyLineVO.setHisCateNm(hisCateNm);
			historyLineVO.setBkgDocProcTpCd("BKGCRE");
			historyBC.createBkgHistoryLine(historyLineVO, account);
			
			eventResponse.setETCData("new_booking_num", newBkgNum);
			
//			if("Y".equals(event.getMailOpenFlag())){
//				String closeVvd = "";
//				String closeBkgMsg = "";
//				BkgBlNoVO closeBkgBlNoVO = new BkgBlNoVO();
//				closeBkgBlNoVO.setBkgNo(event.getBkgForCopyVO().getBkgNo());
//				closeBkgBlNoVO.setPctlNo(routePctlNo);
//				
//				BkgCloseVO bkgCloseVO = util.searchBkgClose(closeBkgBlNoVO, account.getOfc_cd());		
//				if(bkgCloseVO != null){
//					
//					// Current Qty정보 조회
////					PrdQtyInfoVO[] prdQtyInfoVOs = receiptBC.searchBkgQtyForRailTime(closeBkgBlNoVO);
////					String newQtyVol = "";
////					for(int i = 0 ; i < prdQtyInfoVOs.length ; i++){
////						if(i > 0){
////							newQtyVol = newQtyVol + "," + prdQtyInfoVOs[i].getCTpsz() + " X " + prdQtyInfoVOs[i].getCQty();
////						}else{
////							newQtyVol = newQtyVol + prdQtyInfoVOs[i].getCTpsz() + " X " + prdQtyInfoVOs[i].getCQty();
////						}
////					}								
//					String[] strParam = new String[11];
//					strParam[0] = newBkgNum.replace("||", ",");
//					strParam[1] = "";
//					strParam[2] = "";
//					strParam[3] = "";
//					strParam[4] = "";
//					strParam[5] = "";
//					strParam[6] = bkgCloseVO.getNewVvd();
//					strParam[7] = bkgCloseVO.getPorCd() + " / " + bkgCloseVO.getNewPolCd() + " / " + bkgCloseVO.getPodCd() + " / " + bkgCloseVO.getDelCd();
////					strParam[8] = bkgCloseVO.getNewPodCd();
////					strParam[9] = newQtyVol;
//					strParam[10] = bkgCloseVO.getNewCntrList();				
//					
//					closeBkgMsg = util.makeBkgCloseMsg(strParam, "B");
//					closeVvd = bkgCloseVO.getCloseVvd();					
//				} 
//				
//				boolean isCbfFinal = false;
//				bkgCloseVO = util.searchBkgCbf(event.getBkgBlNoVO());
//				if ( bkgCloseVO != null ){
//					String[] arrCBF  = owncontainer.searchCBFBS(bkgCloseVO.getNewVvd().substring(0, 4), bkgCloseVO.getNewVvd().substring(4, 8), bkgCloseVO.getNewVvd().substring(8, 9), bkgCloseVO.getNewYdCdSeq());
//					for (int i=0;i<arrCBF.length;i++){
//						if(i%4 == 0){
//							if("Final".equals(arrCBF[i])){
//								isCbfFinal = true;
//								break;
//							}
//						}
//					}	
//					if(arrCBF != null && isCbfFinal == true){		
//						String[] strParam = new String[11];
//						strParam[0] = newBkgNum.replace("||", ",");
//						strParam[1] = "";
//						strParam[2] = "";
//						strParam[3] = "";
//						strParam[4] = "";
//						strParam[5] = "";
//						strParam[6] = bkgCloseVO.getNewVvd();
//						strParam[7] = bkgCloseVO.getPorCd() + " / " + bkgCloseVO.getNewPolCd() + " / " + bkgCloseVO.getPodCd() + " / " + bkgCloseVO.getDelCd();
//						strParam[10] = bkgCloseVO.getNewCntrList();				
//						
//						closeBkgMsg = util.makeBkgCloseMsg(strParam, "B");
//						closeVvd = bkgCloseVO.getCloseVvd();	
//					}
//				}
//				
//				eventResponse.setETCData("closeBkgFlag", "N");
//				eventResponse.setETCData("cbfBkgFlag", "N");
//				eventResponse.setETCData("closeBkgResult", "Y");
//				eventResponse.setETCData("first_vvd", closeVvd);
//				eventResponse.setETCData("closeBkgMsg", closeBkgMsg);						
//			}else{
//				eventResponse.setETCData("closeBkgResult", "N");
//			}
			
			commit();
			return eventResponse;			
			
		}catch(EventException ex){
//			log.error("err"+ex.toString(),ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  					
		}		
	
	}
	
	
	/**
	 * copyBkgInfo()에서 실행한다 <br>
	 * Route 변경시 Route정보를 조회한다. <br>
	 * 
	 * @param 	BkgForCopyVO bkgForCopyVO, VslSkdVO[] vslSkdVOs, String withoutRoute, String bkgNo
	 * @return 	String
	 * @exception EventException
	 */
	private String searchPctlNoForCopy(BkgForCopyVO bkgForCopyVO, VslSkdVO[] vslSkdVOs, String withoutRoute, String bkgNo) throws EventException {
		String pctlNo = "";
		try{
			BookingUtil utilBC = new BookingUtil();
			
			// PrdMainInfoVO Set
			PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO();
			if("Y".equals(withoutRoute)){
				prdMainInfoVO.setTVvd(bkgForCopyVO.getBkgTrunkVvd());
				if(vslSkdVOs.length > 0){
					prdMainInfoVO.setPod1(vslSkdVOs[0].getPodCd());
					if(vslSkdVOs[0].getPodYdCd() != null && vslSkdVOs[0].getPodYdCd().length() > 0){
						prdMainInfoVO.setPod1N(vslSkdVOs[0].getPodCd()+vslSkdVOs[0].getPodYdCd());
					}else{
						prdMainInfoVO.setPod1N(null);
					}						
					prdMainInfoVO.setPod1C(vslSkdVOs[0].getPodClptIndSeq());
					prdMainInfoVO.setPol1(vslSkdVOs[0].getPolCd());
					if(vslSkdVOs[0].getPolYdCd() != null && vslSkdVOs[0].getPolYdCd().length() > 0){
						prdMainInfoVO.setPol1N(vslSkdVOs[0].getPolCd()+vslSkdVOs[0].getPolYdCd());
					}else{
						prdMainInfoVO.setPol1N(null);
					}
					prdMainInfoVO.setPol1C(vslSkdVOs[0].getPolClptIndSeq());
					prdMainInfoVO.setVvd1(vslSkdVOs[0].getBkgVvdCd());
					
					prdMainInfoVO.setLane1(null);				
				}else{
					prdMainInfoVO.setPod1(null);
					prdMainInfoVO.setPod1N(null);
					prdMainInfoVO.setPod1C(null);
					prdMainInfoVO.setPol1(null);
					prdMainInfoVO.setPol1N(null);
					prdMainInfoVO.setPol1C(null);
					prdMainInfoVO.setVvd1(null);
					prdMainInfoVO.setLane1(null);					
				}
				if(vslSkdVOs.length > 1){
					prdMainInfoVO.setPod2(vslSkdVOs[1].getPodCd());
					if(vslSkdVOs[1].getPodYdCd() != null && vslSkdVOs[1].getPodYdCd().length() > 0){
						prdMainInfoVO.setPod2N(vslSkdVOs[1].getPodCd()+vslSkdVOs[1].getPodYdCd());
					}else{
						prdMainInfoVO.setPod2N(null);
					}					
					prdMainInfoVO.setPod2C(vslSkdVOs[1].getPodClptIndSeq());
					prdMainInfoVO.setPol2(vslSkdVOs[1].getPolCd());
					if(vslSkdVOs[1].getPolYdCd() != null && vslSkdVOs[1].getPolYdCd().length() > 0){
						prdMainInfoVO.setPol2N(vslSkdVOs[1].getPolCd()+vslSkdVOs[1].getPolYdCd());
					}else{
						prdMainInfoVO.setPol2N(null);
					}					
					prdMainInfoVO.setPol2C(vslSkdVOs[1].getPolClptIndSeq());
					prdMainInfoVO.setVvd2(vslSkdVOs[1].getBkgVvdCd());
					prdMainInfoVO.setLane2(null);				
				}else{
					prdMainInfoVO.setPod2(null);
					prdMainInfoVO.setPod2N(null);
					prdMainInfoVO.setPod2C(null);
					prdMainInfoVO.setPol2(null);
					prdMainInfoVO.setPol2N(null);
					prdMainInfoVO.setPol2C(null);
					prdMainInfoVO.setVvd2(null);
					prdMainInfoVO.setLane2(null);					
				}
				if(vslSkdVOs.length > 2){
					prdMainInfoVO.setPod3(vslSkdVOs[2].getPodCd());
					if(vslSkdVOs[2].getPodYdCd() != null && vslSkdVOs[2].getPodYdCd().length() > 0){
						prdMainInfoVO.setPod3N(vslSkdVOs[2].getPodCd()+vslSkdVOs[2].getPodYdCd());
					}else{
						prdMainInfoVO.setPod3N(null);
					}					
					prdMainInfoVO.setPod3C(vslSkdVOs[2].getPodClptIndSeq());
					prdMainInfoVO.setPol3(vslSkdVOs[2].getPolCd());
					if(vslSkdVOs[2].getPolYdCd() != null && vslSkdVOs[2].getPolYdCd().length() > 0){
						prdMainInfoVO.setPol3N(vslSkdVOs[2].getPolCd()+vslSkdVOs[2].getPolYdCd());
					}else{
						prdMainInfoVO.setPol3N(null);
					}					
					prdMainInfoVO.setPol3C(vslSkdVOs[2].getPolClptIndSeq());
					prdMainInfoVO.setVvd3(vslSkdVOs[2].getBkgVvdCd());
					prdMainInfoVO.setLane3(null);				
				}else{
					prdMainInfoVO.setPod3(null);
					prdMainInfoVO.setPod3N(null);
					prdMainInfoVO.setPod3C(null);
					prdMainInfoVO.setPol3(null);
					prdMainInfoVO.setPol3N(null);
					prdMainInfoVO.setPol3C(null);
					prdMainInfoVO.setVvd3(null);
					prdMainInfoVO.setLane3(null);					
				}
				if(vslSkdVOs.length > 3){
					prdMainInfoVO.setPod4(vslSkdVOs[3].getPodCd());
					if(vslSkdVOs[3].getPodYdCd() != null && vslSkdVOs[3].getPodYdCd().length() > 0){
						prdMainInfoVO.setPod4N(vslSkdVOs[3].getPodCd()+vslSkdVOs[3].getPodYdCd());
					}else{
						prdMainInfoVO.setPod4N(null);
					}					
					prdMainInfoVO.setPod4C(vslSkdVOs[3].getPodClptIndSeq());
					prdMainInfoVO.setPol4(vslSkdVOs[3].getPolCd());
					if(vslSkdVOs[3].getPolYdCd() != null && vslSkdVOs[3].getPolYdCd().length() > 0){
						prdMainInfoVO.setPol4N(vslSkdVOs[3].getPolCd()+vslSkdVOs[3].getPolYdCd());
					}else{
						prdMainInfoVO.setPol4N(null);
					}				
					prdMainInfoVO.setPol4C(vslSkdVOs[3].getPolClptIndSeq());
					prdMainInfoVO.setVvd4(vslSkdVOs[3].getBkgVvdCd());
					prdMainInfoVO.setLane4(null);				
				}else{
					prdMainInfoVO.setPod4(null);
					prdMainInfoVO.setPod4N(null);
					prdMainInfoVO.setPod4C(null);
					prdMainInfoVO.setPol4(null);
					prdMainInfoVO.setPol4N(null);
					prdMainInfoVO.setPol4C(null);
					prdMainInfoVO.setVvd4(null);
					prdMainInfoVO.setLane4(null);					
				}			
				
				prdMainInfoVO.setPmF("N");
				if(bkgForCopyVO.getDcgoFlg() != null){
					prdMainInfoVO.setDgF(bkgForCopyVO.getDcgoFlg());
				}else{
					prdMainInfoVO.setDgF("N");
				}					
				if(bkgForCopyVO.getRcFlg() != null){
					prdMainInfoVO.setRfF(bkgForCopyVO.getRcFlg());
				}else{
					prdMainInfoVO.setRfF("N");
				}					
				if(bkgForCopyVO.getAwkCgoFlg() != null){
					prdMainInfoVO.setAkF(bkgForCopyVO.getAwkCgoFlg());
				}else{
					prdMainInfoVO.setAkF("N");
				}					
				if(bkgForCopyVO.getBbCgoFlg() != null){
					prdMainInfoVO.setBbF(bkgForCopyVO.getBbCgoFlg());
				}else{
					prdMainInfoVO.setBbF("N");
				}	
				if(bkgForCopyVO.getHngrFlg() != null){
					prdMainInfoVO.setHgF(bkgForCopyVO.getHngrFlg());
				}else{
					prdMainInfoVO.setHgF("N");
				}					
			}else{
				prdMainInfoVO.setCopyCnt("1");	
			}

			prdMainInfoVO.setRfa(bkgForCopyVO.getRfaNo());
			prdMainInfoVO.setSc(bkgForCopyVO.getScNo());			
			prdMainInfoVO.setBkgNo(bkgNo);				
			
			
			// BkgBlNoVO 생성
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(bkgNo);
			
			PrdParameterVO prdParameterVO = new PrdParameterVO();			
			prdParameterVO.setBkgBlNoVO(bkgBlNoVO);
			prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
			if("Y".equals(withoutRoute)){
				// 01. searchPrdParameter
				prdParameterVO = utilBC.searchPrdParmForFullRoute(prdParameterVO);
			}
			
			// f_cmd,pc_mode Set
			prdParameterVO.getPrdMainInfoVO().setFCmd("3");
			if("Y".equals(withoutRoute)){
				prdParameterVO.getPrdMainInfoVO().setPcMode("B");
				// Create시 Booking번호를 빼고 보낸다.
				prdParameterVO.getPrdMainInfoVO().setBkgNo("");
				prdParameterVO.getBkgBlNoVO().setBkgNo("");				
			}else{
				prdParameterVO.getPrdMainInfoVO().setPcMode("Y");
				prdParameterVO.getPrdMainInfoVO().setBkgNo(bkgNo);
				prdParameterVO.getBkgBlNoVO().setBkgNo(bkgNo);
			}
			// 03. createProdCtlRout
			ProductCatalogCreateBC proBC = new ProductCatalogCreateBCImpl();
			
			pctlNo = proBC.createPrdCtlgRout(prdParameterVO, account);			
		}catch(EventException e){
			log.error("err"+e.toString(),e);
			throw e;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);			
		}
		return pctlNo;
	}	
	
	/**
	 * ESM_BKG_0724 : open<br>
	 * 해당 booking의 roll over 정보를 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRollOver(Event e) throws EventException{
		try{
			EsmBkg0724Event event = (EsmBkg0724Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			RollOvrInfoVO rollOvrInfoVO =  command.searchRollOvr(event.getBkgBlNoVO());
			eventResponse.setETCData("bkg_no",(rollOvrInfoVO.getBkgInforForHistVO().getBkgNo()!=null)? rollOvrInfoVO.getBkgInforForHistVO().getBkgNo():"");
			eventResponse.setETCData("bl_no",(rollOvrInfoVO.getBkgInforForHistVO().getBlNo()!=null)? rollOvrInfoVO.getBkgInforForHistVO().getBlNo():"");
			if (rollOvrInfoVO.getBkgInforForHistVO().getN1stVvd()!=null && rollOvrInfoVO.getBkgInforForHistVO().getN1stVvd().length()>1){
				eventResponse.setETCData("vvd",rollOvrInfoVO.getBkgInforForHistVO().getN1stVvd());
			}else{
				eventResponse.setETCData("vvd",(rollOvrInfoVO.getBkgInforForHistVO().getTrnkVvd()!=null)? rollOvrInfoVO.getBkgInforForHistVO().getTrnkVvd():"");
			}
			if (rollOvrInfoVO.getBkgInforForHistVO().getN1stPol()!=null && rollOvrInfoVO.getBkgInforForHistVO().getN1stPol().length()>1){
				eventResponse.setETCData("pol",rollOvrInfoVO.getBkgInforForHistVO().getN1stPol());
			}else{
				eventResponse.setETCData("pol",(rollOvrInfoVO.getBkgInforForHistVO().getTrnkPol()!=null)? rollOvrInfoVO.getBkgInforForHistVO().getTrnkPol():"");
			}
			if (rollOvrInfoVO.getBkgInforForHistVO().getN1stEtb()!=null && rollOvrInfoVO.getBkgInforForHistVO().getN1stEtb().length()>1){
				eventResponse.setETCData("etb",rollOvrInfoVO.getBkgInforForHistVO().getN1stEtb());
			}else{
				eventResponse.setETCData("etb",(rollOvrInfoVO.getBkgInforForHistVO().getTrnkEtb()!=null)? rollOvrInfoVO.getBkgInforForHistVO().getTrnkEtb():"");
			}
			if(rollOvrInfoVO.getBkgInforForHistVO().getN1stEtd()!=null && rollOvrInfoVO.getBkgInforForHistVO().getN1stEtd().length()>1){
				eventResponse.setETCData("etd",rollOvrInfoVO.getBkgInforForHistVO().getN1stEtd());
			}else{
				eventResponse.setETCData("etd",(rollOvrInfoVO.getBkgInforForHistVO().getTrnkEtd()!=null)? rollOvrInfoVO.getBkgInforForHistVO().getTrnkEtd():"");
			}
			
			eventResponse.setRsVoList(rollOvrInfoVO.getRollOvrVO());
			return eventResponse;
		} catch(EventException se) {
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0724 : save <br>
	 * roll over 정보를 update 한다<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRollOver(Event e) throws EventException {
		
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmBkg0724Event event = (EsmBkg0724Event) e;

			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
			begin();
			BkgRollOvrVO[] bkgRollOvrVOs=new BkgRollOvrVO[event.getRollOvrVOs().length];
			
			for(int i=0;i<event.getRollOvrVOs().length;i++){
				BkgRollOvrVO bkgRollOvrVO = new BkgRollOvrVO();
				bkgRollOvrVO.setIbflag(event.getRollOvrVOs()[i].getIbflag());
				bkgRollOvrVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
				bkgRollOvrVO.setRollOvrRsnCd(event.getRollOvrVOs()[i].getRollOvrRsnCd());
				bkgRollOvrVO.setDiffRmk(event.getRollOvrVOs()[i].getDiffRmk());
				bkgRollOvrVO.setEvntDt(event.getRollOvrVOs()[i].getEvntDt());
				bkgRollOvrVO.setUpdUsrId(account.getUsr_id());
				bkgRollOvrVO.setRollOvrSeq(event.getRollOvrVOs()[i].getRollOvrSeq());
				bkgRollOvrVOs[i]=bkgRollOvrVO;
			}
			receiptBC.manageBkgRollOver(bkgRollOvrVOs);
			commit();
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}

	/**
	 * ESM_BKG_0079 : open <br>
	 * 버튼 visible, enable 처리를 위해 BkgBlNoVO 를 조회한다.<br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgBlNoVO(Event e) throws EventException {
		EsmBkg0079Event event = (EsmBkg0079Event)e;
		BookingUtil command = new BookingUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			event.getBkgBlNoVO().setCaUsrId(account.getUsr_id());
			BkgBlNoVO bkgBlNoVO = command.searchBkgBlNoVO(event.getBkgBlNoVO());
			
			if (bkgBlNoVO == null) {
				eventResponse.setETCData("bkg_no",       "");
				eventResponse.setETCData("ca_no",        "");
				eventResponse.setETCData("ca_flg",       "");
				eventResponse.setETCData("bdr_flg",      "");		
				eventResponse.setETCData("ca_exist_flg", "");
			} else {
				eventResponse.setETCData("bkg_no",       JSPUtil.getNullNoTrim(bkgBlNoVO.getBkgNo()));
				eventResponse.setETCData("ca_no",        JSPUtil.getNullNoTrim(bkgBlNoVO.getCaNo()));
				eventResponse.setETCData("ca_flg",       JSPUtil.getNullNoTrim(bkgBlNoVO.getCaFlg()));
				eventResponse.setETCData("bdr_flg",      JSPUtil.getNullNoTrim(bkgBlNoVO.getBdrFlg()));		
				eventResponse.setETCData("ca_exist_flg", JSPUtil.getNullNoTrim(bkgBlNoVO.getCaExistFlg()));
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}		

		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0079 : c/a confirm <br>
	 * C/A를 완료하고 종료처리한다.<br>
	 * 
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse completeCA(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0079Event event = (EsmBkg0079Event)e;
				 
		try {
			begin();	
//			BookingUtil util = new BookingUtil();
			BlRatingBC blRatingBC = new BlRatingBCImpl();
			BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
			BookingUtil utilCmd = new BookingUtil(); 
			
			BkgBlNoVO bkgBlNoVO = event.getBkgBlNoVO();
			CompleteCaVO completeCaVO = completeCA(bkgBlNoVO);
			
//			String [] arrCaRtn = util.splitByToken(caRtnStr, "|");
			String corrNo = completeCaVO.getBkgBlNoVO().getCaNo();
			String preChecking = completeCaVO.getPreChecking();
			String caRsnCd = completeCaVO.getCaRsnRmkVO().getCaRsnCd();
			String codFlg = completeCaVO.getCodFlg();
			
			eventResponse.setETCData("ca_no", corrNo);
			eventResponse.setETCData("pre_checking", preChecking);
			eventResponse.setETCData("codFlg", codFlg);
			
			if(caRsnCd.equals("M") && event.getBccExistFlg().equals("Y")){
				HistoryTableVO historyTableVO = new HistoryTableVO ();
				historyTableVO = bookingHistoryMgtBC.searchOldBkgForHistory("ESM_BKG_CA_BCC", bkgBlNoVO);
				
				SurchargeAutoRatingBC surchargeAutoRatingBC = new SurchargeAutoRatingBCImpl();
				BkgSurchargeRateVO bkgSurchargeRateVO = surchargeAutoRatingBC.searchSurchargeRatingByBcc(bkgBlNoVO.getBkgNo(), "N", account);
				surchargeAutoRatingBC.manageBccSurchargeRating(bkgSurchargeRateVO, account);
				
				historyTableVO.getBkgBlNoVO().setCaFlg("N");
				bookingHistoryMgtBC.manageBookingHistory("ESM_BKG_CA_BCC", historyTableVO, account);

				CostAssignBC masBc = new CostAssignBCImpl();
				MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
				masBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
				masBkgComIfVo.setCostSrcSysCd("BKG");
				masBkgComIfVo.setIfRmk("Manage Rate");
				masBkgComIfVo.setCreUsrId(account.getUsr_id());
				masBkgComIfVo.setUpdUsrId(account.getUsr_id());
				masBc.modifyMasCommonInterface(masBkgComIfVo);    
				
	            BookingARCreationBC bookingARCreationBC = new BookingARCreationBCImpl();
	            ARBkgInterfaceCreationVO bkgIfVo = new ARBkgInterfaceCreationVO();
	            bkgIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
	            bkgIfVo.setManDivInd("B");
	            bkgIfVo.setUserId(account.getUsr_id());
	            bookingARCreationBC.interfaceBKGARInvoiceToINV(bkgIfVo);

//	            BlRatingBC blRatingBC = new BlRatingBCImpl();
                bkgBlNoVO.setCaUsrId(account.getUsr_id());
                blRatingBC.distributeCntrRate(bkgBlNoVO.getBkgNo(), account);     
			}
			
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
            
            String rtHisYn = bookingHistoryMgtBC.searchBkgHistory(bkgBlNoVO,"ESM_BKG_0079_08");
            if("Y".equals(rtHisYn)){
            	   
	            List<SearchFocByFreightListVO>  searchFocByFreightListVO = null;
	                
	            searchFocByFreightListVO = blRatingBC.searchFocByFreightList(bkgBlNoVO.getBkgNo(),"N");
	        	/* 에러 메시지 표시 */
				if(searchFocByFreightListVO == null){
					throw new EventException((String)new ErrorHandler("BKG08058").getMessage());
				}
	
				//Inbound Cr관련 로그
				utilCmd.addBkgLog("BKG_US_CGO_SWB", bkgBlNoVO.getBkgNo(), "11.Rate CHARGE START colAmt:"+searchFocByFreightListVO.get(0).getcolAmt()+", cctAmt:" + searchFocByFreightListVO.get(0).getcctAmt());			
				if(searchFocByFreightListVO.get(0).getcolAmt().equals("0") && searchFocByFreightListVO.get(0).getcctAmt().equals("0")){
	 
				log.debug("===============================================================");
				log.debug("[start][======== [CargoReleaseOrderBCImpl] :: setupFocByFreight ]");
				log.debug("===============================================================");
				
				CargoReleaseOrderBC cargoBC = new CargoReleaseOrderBCImpl();
				FrtCltLstVO frtCltLst = new FrtCltLstVO();
				/* BL No 는 12 자리 까지만 넘김 */
				frtCltLst.setBlNo(bkgBlNoVO.getBlNo().substring(0,12));
				frtCltLst.setFrtCltFlg("Y");
				frtCltLst.setEvntOfcCd(account.getOfc_cd());
				frtCltLst.setEvntUsrId(account.getUsr_id());
				frtCltLst.setEvntDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
				frtCltLst.setCgorTeamCd("F");
				frtCltLst.setCgoEvntNm("CHARGE");
				
					try{
						utilCmd.addBkgLog("BKG_US_CGO_SWB", bkgBlNoVO.getBkgNo(), "12.Go");					
						cargoBC.setupFocByFreight(frtCltLst);
					}catch(Exception e1){
						log.debug("[end:: CargoReleaseOrderBC == manageRate update ]==========");
						log.error(e1.getMessage()); // 2011.07.15
					}
				} 
				utilCmd.addBkgLog("BKG_US_CGO_SWB", bkgBlNoVO.getBkgNo(), "Rate CHARGE END");
			
	        
            }
			
			commit();
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());  //BKG00166 : 저장성공
			
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		
		return eventResponse;
	}	
	
	/**
	 * completeCA()에서 실행한다. <br> 
	 * C/A를 완료하고 종료처리한다. <br>
	 * 
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @return    CompleteCaVO
	 * @exception EventException
	 */
	private CompleteCaVO completeCA(BkgBlNoVO bkgBlNoVO) throws EventException {
		
		BDRCorrectionBC         bdrCorrectionBC         = new BDRCorrectionBCImpl();
		BLDocumentationBLBC     blDocumentationBLBC     = new BLDocumentationBLBCImpl();
		GeneralBookingReceiptBC generalBookingReceiptBC = new GeneralBookingReceiptBCImpl();
		SpecialCargoReceiptBC   specialCargoReceiptBC   = new SpecialCargoReceiptBCImpl();
		BlRatingBC              blRatingBC              = new BlRatingBCImpl();
		BLIssuanceBC            blIssuanceBC            = new BLIssuanceBCImpl();
		BookingHistoryMgtBC     bookingHistoryMgtBC     = new BookingHistoryMgtBCImpl();
		RevenueDebitNoteBC      revenueDebitNoteBC      = new RevenueDebitNoteBCImpl();
		BookingUtil             bookingUtil             = new BookingUtil(); 
		CargoReleaseOrderBC     cargoReleaseOrderBC     = new CargoReleaseOrderBCImpl();
		ProductCatalogCreateBC  prdBC			     	= new ProductCatalogCreateBCImpl(); 
		BkgCopManageBC          copBC    			    = new BkgCopManageBCImpl();	
		GeneralBookingSearchBC  generalBookingSearchBC  = new GeneralBookingSearchBCImpl();
		PerformanceReportBC     performReportBc 		= new PerformanceReportBCImpl();
		try {			
			//Replan 대상 항목이 변경되었는지 조회한다.
			List<CorrReplanVO> corrReplanVOs = bdrCorrectionBC.searchCorrReplan(bkgBlNoVO);

			String spclVvdChange = "";
			Boolean changeVvdFlag = false;
			String preChecking = "N/A";
			for(int i=0;i<corrReplanVOs.size();i++){
				if("SPCL_VVD_CHANGE".equals(corrReplanVOs.get(i).getOperation())){
					spclVvdChange = "SPCL_VVD_CHANGE";
				}
				if("VVD_CHANGE".equals(corrReplanVOs.get(i).getOperation())){
					changeVvdFlag = true;
				}
			}
			ScgVvdAproRqstVO[] caScgVvdVOs = null;
			if(spclVvdChange.equals("SPCL_VVD_CHANGE")){
				caScgVvdVOs = specialCargoReceiptBC.searchBkgVvdCa(bkgBlNoVO.getBkgNo());
			}

			CaRsnRmkVO caRsnRmkVO = bdrCorrectionBC.searchCaRsnRmk(bkgBlNoVO,account);  //correction 저장 전에 조회 되어야 함
			OldBkgInfoVO oldBkgInfoVO = new OldBkgInfoVO();
			for(int i=0;i<corrReplanVOs.size();i++){
				if("REPLAN".equals(corrReplanVOs.get(i).getOperation())){
					List<String> tsClosedVvds = bookingUtil.searchTsBkgClose(bkgBlNoVO);
					if(tsClosedVvds.size() > 0){
						String closedVvds = "";
						for(int j = 0; j < tsClosedVvds.size(); j++){
							if(closedVvds.length() == 0){
								closedVvds = tsClosedVvds.get(j);
							} else {
//								closedVvds = closedVvds + "," + tsClosedVvds.get(j);
								StringBuffer tmpBuffer = new StringBuffer(closedVvds).append(",").append(tsClosedVvds.get(j));
								closedVvds = tmpBuffer.toString();
							}
						}	
						generalBookingReceiptBC.sendTsCloseNotice(bkgBlNoVO, closedVvds, account);
					}
					
					oldBkgInfoVO = generalBookingReceiptBC.searchOldBkgInfo(bkgBlNoVO);
					if(oldBkgInfoVO.getCodFlg().equals("Y")){
						BkgBlNoVO codBkgBlNoVO = bkgBlNoVO;
						codBkgBlNoVO.setPctlNo(oldBkgInfoVO.getPctlNo());
						CODCorrectionBC codBC = new CODCorrectionBCImpl();
						
						codBC.manageAutoCod(codBkgBlNoVO, account, "CA");
						BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
						HistoryLineVO historyLineVO = new HistoryLineVO();
						historyLineVO.setUiId("ESM_BKG_0079_01");			
						historyLineVO.setHisCateNm("COD");
						historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
						historyLineVO.setCaFlg("Y");
						historyLineVO.setCrntCtnt("COD Request Created");				
						historyBC.createBkgHistoryLine(historyLineVO, account);
						
						//POD,DEL 국가 변경시 COP 호출
						CodEtcVO codEtcVO = codBC.searchCopForBkgCodParam(codBkgBlNoVO);
						if(codEtcVO!=null){
							UpdBkgForBkgCodVO updBkgForBkgCodVO = new UpdBkgForBkgCodVO();
							updBkgForBkgCodVO.setBkgNo(codBkgBlNoVO.getBkgNo());
							updBkgForBkgCodVO.setOldPodYdCd(codEtcVO.getOldPodNodCd());
							updBkgForBkgCodVO.setOldDelYdCd(codEtcVO.getOldDelNodCd());
							updBkgForBkgCodVO.setNewPodYdCd(codEtcVO.getNewPodNodCd());
							updBkgForBkgCodVO.setNewDelYdCd(codEtcVO.getNewDelNodCd());
							copBC.updateBkgForBkgCod(updBkgForBkgCodVO);
						}
					}
				}
			}
			// 첫 VVD 바뀌는지 CHECK
			String firstVvdChg = generalBookingReceiptBC.checkFirstVvdChgByCa(bkgBlNoVO);
			// CHARGE 정보가 바뀌는지 CHECK
            BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("YDH");			
			List<BkgHrdCdgCtntVO> BkgHrdCdgCtntVOs = bookingUtil.searchHardCoding(bkgHrdCdgCtntListCondVO);
			String caHomeDepot = "";
			if(BkgHrdCdgCtntVOs.size() > 0){
				caHomeDepot = BkgHrdCdgCtntVOs.get(0).getAttrCtnt2();// CTM으로 부터 VGM 데이터 IF
			}
			String chargChg = "";
			if("ON".equalsIgnoreCase(caHomeDepot))
				chargChg = blIssuanceBC.checkDiffChargeData(bkgBlNoVO.getBkgNo());
			
			//------------------------
			// CA Complete 처리
			//------------------------
			String copyTypeCd = "BKG";
			
			//추가. 위치변경
			add1stCaHist(bkgBlNoVO);
			
			//01. 
			bdrCorrectionBC.modifyCngItemFlag      (bkgBlNoVO, account);
			//02. 
			blDocumentationBLBC.modifyCaComplete   (bkgBlNoVO);			
			
			//03. 
			generalBookingReceiptBC.createBookingCA(bkgBlNoVO, copyTypeCd);
			//04. 
			blDocumentationBLBC.createBlCA         (bkgBlNoVO, copyTypeCd);
			//05. 
			blRatingBC.createRateCA                (bkgBlNoVO, copyTypeCd);
			//06. 
			specialCargoReceiptBC.createSpclCA     (bkgBlNoVO, copyTypeCd);
			//추가 : createIssCA 
			blIssuanceBC.createIssCA               (bkgBlNoVO, copyTypeCd); 	
			//07. 
			bookingHistoryMgtBC.createHisCA        (bkgBlNoVO, copyTypeCd);  

			//------------------------
			// CA History 생성
			//------------------------
			//07. addCaHistory(e) call 
			//temp에 저장한 ca reason과 remark를 승계하므로 여기서는 비워서 보냄
			String strCaRsnCd    = ""; 
			String strCaCorrRmk  = "";
			String strRdnAcptFlg = "N";
			addCaHistory(strCaRsnCd, strCaCorrRmk, bkgBlNoVO, strRdnAcptFlg, "N");			

			//------------------------
			// CA History Temp 삭제
			//------------------------
			copyTypeCd = "TEMP";
			
			//08. 
			specialCargoReceiptBC.removeCA  (bkgBlNoVO, copyTypeCd);
			//09. 
			blRatingBC.removeCA             (bkgBlNoVO, copyTypeCd);
			//10. 
			blDocumentationBLBC.removeCA    (bkgBlNoVO, copyTypeCd);
			//11. 
			generalBookingReceiptBC.removeCA(bkgBlNoVO, copyTypeCd);
			//추가. 
			blIssuanceBC.removeCA           (bkgBlNoVO, copyTypeCd);
			
			bookingHistoryMgtBC.removeCA    (bkgBlNoVO, copyTypeCd);

			//12. 
			bdrCorrectionBC.removeCATemp    (bkgBlNoVO);

			//추가. 
			bookingHistoryMgtBC.modifyCaCorrNoForHistory(bkgBlNoVO);
			
			blRatingBC.distributeCntrRate(bkgBlNoVO.getBkgNo(), account);
			
//			for(int i=0;i<corrReplanVOs.size();i++){
//				log.debug("operation:"+corrReplanVOs.get(i).getOperation());
//			}

			performReportBc.manageQtyCntrCoposite(bkgBlNoVO.getBkgNo(), "CQ");	
			
			if ("X".equalsIgnoreCase(bookingUtil.searchBkgStatusByBkg(bkgBlNoVO))) {
				copBC.cancelBkg(bkgBlNoVO.getBkgNo());
				changeMemoSplitBkgStatus(bkgBlNoVO.getBkgNo());
				
				HistoryLineVO historyLineVO = new HistoryLineVO();
				historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
				historyLineVO.setCaFlg("N");
				historyLineVO.setCorrNo(bkgBlNoVO.getCaNo());
				historyLineVO.setBkgDocProcTpCd("BKGCAN");//booking cancel for doc performance
				historyLineVO.setUiId("ESM_BKG_0079_01");
				historyLineVO.setCrntCtnt("Booking Canceled.");
				historyLineVO.setHisCateNm("Booking Cancel."); 
				bookingHistoryMgtBC.createBkgHistoryLine(historyLineVO, account);
				
				// Reefer Cancel
				cancelRfCgoApro(bkgBlNoVO);
				
			} else {
				if(corrReplanVOs.size()>0){
					for(int i=0;i<corrReplanVOs.size();i++){
						if("CNTR_ATTACH".equals(corrReplanVOs.get(i).getOperation())){	
							copBC.attachCntr(bkgBlNoVO.getBkgNo(), corrReplanVOs.get(i).getCntrNo(), corrReplanVOs.get(i).getCntrPrtFlg());
						}
						if("CNTR_DETACH".equals(corrReplanVOs.get(i).getOperation())){	
							copBC.detachCntr(bkgBlNoVO.getBkgNo(), corrReplanVOs.get(i).getCntrNo(), corrReplanVOs.get(i).getCntrPrtFlg());
						}
						if("CNTR_CONFIRM".equals(corrReplanVOs.get(i).getOperation())){
							copBC.confirmCntr(bkgBlNoVO.getBkgNo());
						}
					}
					for(int i=0;i<corrReplanVOs.size();i++){
						if("REPLAN".equals(corrReplanVOs.get(i).getOperation())){				
							PrdParameterVO prdParameterVO = new PrdParameterVO();
							PrdMainInfoVO  prdMainInfoVO = new PrdMainInfoVO();
							BkgBlNoVO      caBkgBlNoVO = bkgBlNoVO;
										
							caBkgBlNoVO.setCaFlg("N");
							prdMainInfoVO.setFCmd("3");
							prdMainInfoVO.setBkgNo(caBkgBlNoVO.getBkgNo());
							prdMainInfoVO.setPcMode("R");
							prdParameterVO.setBkgBlNoVO(caBkgBlNoVO);
							prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
							prdParameterVO = bookingUtil.searchPrdParmForFullRoute(prdParameterVO);
	//						prdParameterVO.getPrdMainInfoVO().setOrgTrnsMode("");
	//						prdParameterVO.getPrdMainInfoVO().setDestTrnsMode("");
	
							log.debug("operation:"+corrReplanVOs.get(i).getOcnSeq());
							
							prdParameterVO.getPrdMainInfoVO().setOcnSeq(corrReplanVOs.get(i).getOcnSeq());
													
//							bookingUtil.prdParameterLog(prdParameterVO.getPrdMainInfoVO());
							// 03. createProdCtlRout 
							String pctlNoMapStr = prdBC.createPrdCtlgRout(prdParameterVO, account);
							String [] pctlNoMapSeq = bookingUtil.splitByToken(pctlNoMapStr,"|");
							//copBC.updateBkg(caBkgBlNoVO.getBkgNo(), pctlNoMapSeq[1]);
							callCopUpdateBkg(caBkgBlNoVO.getBkgNo(), pctlNoMapSeq[1]);
							
							String pctDt = generalBookingReceiptBC.searchPct(bkgBlNoVO.getBkgNo(), "N");
							generalBookingReceiptBC.modifyPct(caBkgBlNoVO, pctDt);
						}
					}
					
					// 첫 VVD 변경되면 BKG_ROLL_OVR 생성
					if("Y".equals(firstVvdChg)){
						generalBookingReceiptBC.modifyBkgRollOvrForCa(bkgBlNoVO, account);
					}
					
					// VVD 변경되면 SCE(COP)호출
					try{
//						List<BkgVvdVO> oldBkgVvdVOs = oldBkgInfoVO.getBkgVvdVOs();
//						List<VslSkdVO> newVslSkdVOs = bkgCreVO.getVslSkd();
						if(changeVvdFlag){
							UpdBkgForVVDChgVO updBkgForVVDChgVO = new UpdBkgForVVDChgVO();
							// 추가된 vvd의 pol (추가된 vvd가 여러건일때는 추가 vvd중 첫번째 vvd의 pol, 추가건이 없을 경우는 bkg의 pol)
							String eventYdCd = "";
//							for(int i=0; i<newVslSkdVOs.size(); i++ ){
//								boolean existVvd = false;
//								for(int j=0; j<oldBkgVvdVOs.size(); j++){
//									String oldVvd2 = oldBkgVvdVOs.get(j).getVslCd().concat(oldBkgVvdVOs.get(j).getSkdVoyNo()).concat(oldBkgVvdVOs.get(j).getSkdDirCd());
//									String newVvd2 = newVslSkdVOs.get(i).getBkgVvdCd();
//									if(newVvd2.equalsIgnoreCase(oldVvd2)){
//										existVvd = true;
//									}
//								}
//								if(!existVvd && eventYdCd.equals("")){
//									eventYdCd = newVslSkdVOs.get(i).getPolYdCd();
//								}
//							}
//							if(eventYdCd.equals("")){
//								eventYdCd = bkgCreVO.getBkgBookingInfoVO().getBkgPolYdCd();
//							}
							updBkgForVVDChgVO.setBkgNo(bkgBlNoVO.getBkgNo());
							updBkgForVVDChgVO.setEventYdCd(eventYdCd);
							updBkgForVVDChgVO.setCreUsrId(account.getUsr_id());
							copBC.updateBkgForVVDChange(updBkgForVVDChgVO);
						}
					}catch(EventException ex){
						log.error("BKG SCE updateBkgForVVDChange calling errer", ex);
					}
					// VVD 변경되면 SCE(COP)호출 끝
				}
			}
			
			//14. interfaceCoa call
			interfaceToMas(bkgBlNoVO, "Booking Update", account);	

			//13. interfaceToInv call
			interfaceToInv(bkgBlNoVO, account);  
			
			//vvd변경 건인 경우 spcl cgo 자동 re-request
			if(spclVvdChange.equals("SPCL_VVD_CHANGE")){
				preChecking = reRequestSpclCgoApproval(bkgBlNoVO, "C/A VVD CHANGE", caScgVvdVOs);

				if("pre-checking".equals(preChecking)){
					preChecking = "Y";
				} else {
					preChecking = "N";						
				}
			}
			
            //추가2. 
			OblIssVO oblIssVO = bookingUtil.searchOblIssue(bkgBlNoVO); 
			
			if("Y".equals(oblIssVO.getRdnAcptFlg())){
				//추가2. 
				RevDrNoteVO revDrNoteVO = new RevDrNoteVO(); 
				CstmBkgRevDrNoteVO bkgRevDrNoteVO = new CstmBkgRevDrNoteVO();
				bkgRevDrNoteVO.setBkgNo      (bkgBlNoVO.getBkgNo());  
				bkgRevDrNoteVO.setBkgCorrNo  (bkgBlNoVO.getCaNo()); 
				bkgRevDrNoteVO.setRdnNo      (oblIssVO.getRdnNo()); 
				bkgRevDrNoteVO.setRvisSeq    (oblIssVO.getRvisSeq()); 
				bkgRevDrNoteVO.setReceiverRmk("");
				bkgRevDrNoteVO.setUmchTpCd   (caRsnRmkVO.getUmchTpCd());
				bkgRevDrNoteVO.setUmchSubTpCd(caRsnRmkVO.getUmchSubTpCd()); 
				revDrNoteVO.setBkgRevDrNoteVO(bkgRevDrNoteVO);
				
				revenueDebitNoteBC.acceptRDNbyReceiptOffice(revDrNoteVO, account);  
			}			
			//추가2. 
			OblRdemVO oblRdem = new OblRdemVO();
			oblRdem.setBlNo      (oblIssVO.getBlNo());  
			oblRdem.setCgorTeamCd("C");
			oblRdem.setCgoEvntNm ("B/L Correct");
			oblRdem.setEvntDt    (new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
			oblRdem.setEvntOfcCd (account.getOfc_cd());
			oblRdem.setEvntUsrId (account.getUsr_id());
			oblRdem.setOblRdemFlg(oblIssVO.getOblRlseFlg()); 

			try{
//				if("US".equals(oblIssVO.getDelCd().substring(0,2))) {
					cargoReleaseOrderBC.setupFocByObl(oblRdem);
//				}
			} catch(Exception crEx){
				log.error("err " + crEx.toString(), crEx);
			}

			generalBookingSearchBC.createCustBkgReceiptEdiBackEnd(bkgBlNoVO, null, "Y", account);
			
			/////////////////////////////////////////////
			if ("G".equalsIgnoreCase(caRsnRmkVO.getCaRsnCd())) {
				BkgBookingInfoVO bkgVo = null;
				TemplateMail template = null;
				String toEml = null;
				String sndId = null;
				BkgNtcHisVO bkgNtcHisVO = null;
				List<BkgNtcHisVO> bkgNtcHisVOs = null;
				toEml = generalBookingSearchBC.searchSlsRepUsrEmlByBkgNo(bkgBlNoVO.getBkgNo());
				bkgVo = generalBookingReceiptBC.searchBooking(bkgBlNoVO).getBkgBookingInfoVO();
				template = new TemplateMail();
				template.setBatFlg("N");
				template.setFrom(account.getUsr_eml(),account.getUsr_nm());
				template.setRecipient(toEml);
				template.setSubject("[ATTENTION] Notice for Mis-Sales C/A");
				template.setHtmlTemplate("ESM_BKG_0079.html");
				template.setArg("bkgNo",bkgBlNoVO.getBkgNo());
				template.setArg("caNo",bkgBlNoVO.getCaNo());
				template.setArg("contractNo",!"".equalsIgnoreCase(bkgVo.getScNo()) ? bkgVo.getScNo() :
					                         !"".equalsIgnoreCase(bkgVo.getRfaNo()) ? bkgVo.getRfaNo() : bkgVo.getTaaNo());
				template.setArg("vvd",bkgVo.getBkgTrunkVvd());
				template.setArg("por",bkgVo.getBkgPorCd());
				template.setArg("pol",bkgVo.getBkgPolCd());
				template.setArg("pod",bkgVo.getBkgPodCd());
				template.setArg("del",bkgVo.getBkgDelCd());
				sndId = template.send();
				bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
				bkgNtcHisVO.setNtcViaCd("M");
				bkgNtcHisVO.setNtcKndCd("MS");
				bkgNtcHisVO.setNtcSeq("0");
				bkgNtcHisVO.setCustCntcTpCd(null);
				bkgNtcHisVO.setNtcEml(toEml);
				bkgNtcHisVO.setSndId(sndId);
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
				bkgNtcHisVO.setDiffRmk("");
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
				bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
				bkgNtcHisVOs.add(bkgNtcHisVO);
				bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0079");
			}
			
			/* US filer가 1이고 self일 때 auto notification(이메일) 전송 */
			String emlArr[] = new String[2];
			CmSelfMailVO cmSelfMailVO = new CmSelfMailVO();
			//조건에 맞으면, BKG와 SI Contact email 주소를 가져온다
			emlArr = blDocumentationBLBC.checkSelfFilingCM(bkgBlNoVO.getBkgNo(),bkgBlNoVO.getCaFlg());			
			StringBuffer emlAdd = new StringBuffer();
			
			//한 번 성공적으로 전송된 이력이 있으면 다시 보내지 않음.
			String chkCmSelfEmailFlg = blDocumentationBLBC.chkCsEmailHisoty(bkgBlNoVO.getBkgNo());
			
			if(emlArr!=null && emlArr.length>1 && ("N".equalsIgnoreCase(chkCmSelfEmailFlg))){
				if(!"".equalsIgnoreCase(emlArr[0])){
					for(int i=0; i<emlArr.length;i++){
						emlAdd = emlAdd.append(emlArr[i]);
						emlAdd = emlAdd.append(";");
					}
					
					//이메일에 들어갈 데이터 search
					cmSelfMailVO = blDocumentationBLBC.searchContentsForSelfMail(bkgBlNoVO.getBkgNo(),bkgBlNoVO.getCaFlg());
					
					/* 1. Send Email */
					List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
					BkgNtcHisVO bkgNtcHisVO = blDocumentationBLBC.sendChkSelfCMByEmail(bkgBlNoVO.getBkgNo(),emlAdd.toString(),cmSelfMailVO);
					bkgNtcHisVOs.add(bkgNtcHisVO);
					/* 2. Register Notice History */
					bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, account.getUsr_id());
					log.debug("=====> eml_address    : " + emlAdd);
				}
				
			}
			
			if("Y".equalsIgnoreCase(chargChg) && "ON".equalsIgnoreCase(caHomeDepot)){
				//HOME DEPOT일 때만 보냄
				List<SendBkgEdiVO> list =  generalBookingSearchBC.searchEdiForNotice(bkgBlNoVO);
				List<SendBkgEdiVO> hdpList = new ArrayList<SendBkgEdiVO>();
				
				if(list!=null && list.size()>0){
					for(int i=0;i<list.size();i++){
						if("HOME DEPOT".equalsIgnoreCase(list.get(i).getGroupNm()) && "BL".equalsIgnoreCase(list.get(i).getNtcKndCd())){
							hdpList.add(list.get(i));
						}
					}
				}
				if(list!=null && hdpList.size()>0){
					for(int i=0;i<hdpList.size();i++){
						log.debug("\n======= Auto EDI Send ======\n");
						DblEdiInVO dblEdiInVO = new DblEdiInVO();
						dblEdiInVO.setBkgNo(bkgBlNoVO.getBkgNo());
						dblEdiInVO.setEdiReceiveId(hdpList.get(i).getEdiReceiveId());  //ediReceiveId	
						dblEdiInVO.setGroupEdiId(hdpList.get(i).getGroupEdiId()); //groupEdiId	
						dblEdiInVO.setFuncCode("");
						DblEdiVO dblEdiVo=blIssuanceBC.createDraftBlEdi(dblEdiInVO, account);
						ArrayList<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();	
						
						for(int j=0;j<dblEdiVo.getFlatFileAckVOs().size();j++){
							BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
							bkgNtcHisVO.setBkgNo(bkgBlNoVO.getBkgNo());
							bkgNtcHisVO.setNtcViaCd("E");
							bkgNtcHisVO.setNtcKndCd("BL");
							bkgNtcHisVO.setEdiId(hdpList.get(i).getEdiReceiveId());
							bkgNtcHisVO.setEsvcGrpCd(hdpList.get(i).getGroupEdiId());
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
								bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
							}
						}
						if (Constants.SAMF_LIST.contains(list.get(i).getEdiReceiveId())) {
							
							BkgBlNoVO bkgBlNoIn = new BkgBlNoVO();
					        bkgBlNoIn.setBkgNo(bkgBlNoVO.getBkgNo());
							bkgBlNoIn.setCaUsrId(account.getUsr_id());
							
							BkgBlNoVO bkgBlNoOut = bookingUtil.searchBkgBlNoVO(bkgBlNoIn);
							
							BkgReferenceVO[] bkgReferenceVOs = new BkgReferenceVO[1];
							BkgReferenceVO bkgReferenceVO = new BkgReferenceVO();
							bkgReferenceVO.setBkgNo(bkgBlNoVO.getBkgNo());
							bkgReferenceVO.setBkgRefTpCd("SAMF");						
							bkgReferenceVO.setCustRefNoCtnt(dblEdiVo.getDblEdiSamf());
							bkgReferenceVOs[0] = bkgReferenceVO;
	
							generalBookingReceiptBC.manageRefNo(bkgReferenceVOs, account, bkgBlNoOut);
						}
					}
				}
			}
			
			
			
			
			CompleteCaVO completeCaVO = new CompleteCaVO();
			completeCaVO.setBkgBlNoVO(bkgBlNoVO);
			completeCaVO.setCaRsnRmkVO(caRsnRmkVO);
			completeCaVO.setPreChecking(preChecking);
			completeCaVO.setCodFlg(oldBkgInfoVO.getCodFlg());
			return completeCaVO;	
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
	}
	
	/**
	 * C/A confirm, auto c/a 처리시 실행된다.<br>
	 * C/A 이력 존재여부를 조회하고 없을 경우 dummy c/a 정보를 생성한다.<br>
	 * 
	 * @author    Lee NamKyung
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @return    String
	 * @exception EventException
	 */
	private String add1stCaHist(BkgBlNoVO bkgBlNoVO) throws EventException {
		
		BDRCorrectionBC         bDRCorrectionBC         = new BDRCorrectionBCImpl();
		BLDocumentationBLBC     bLDocumentationBLBC     = new BLDocumentationBLBCImpl();
		GeneralBookingReceiptBC generalBookingReceiptBC = new GeneralBookingReceiptBCImpl();
		SpecialCargoReceiptBC   specialCargoReceiptBC   = new SpecialCargoReceiptBCImpl();
		BlRatingBC              blRatingBC              = new BlRatingBCImpl();
		BLIssuanceBC            bLIssuanceBC            = new BLIssuanceBCImpl();
		BookingHistoryMgtBC     historyBC               = new BookingHistoryMgtBCImpl();

		String strReturn = "N";
		
		try {
			String copyTypeCd = "HIST000"; 
			
			//01. 
			strReturn = bDRCorrectionBC.add1stCaHist(bkgBlNoVO, account);
						
			if ("N".equals(strReturn)) {
				//02. 
				bkgBlNoVO.setCaNo("0000000001"); 
				generalBookingReceiptBC.createBookingCA(bkgBlNoVO, copyTypeCd); 
				
				//03. 
				bLDocumentationBLBC.createBlCA         (bkgBlNoVO, copyTypeCd); 
				
				//04. 
				specialCargoReceiptBC.createSpclCA     (bkgBlNoVO, copyTypeCd); 
				
				//05. 
				blRatingBC.createRateCA                (bkgBlNoVO, copyTypeCd); 
				
				//06. 
				bLIssuanceBC.createIssCA               (bkgBlNoVO, copyTypeCd); 
				
				//07. 
				historyBC.createHisCA                   (bkgBlNoVO, copyTypeCd);  
			}
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}		
		
		return strReturn; 
	}	
	
	/**
	 * C/A 를 시작하고, History data를 생성한다.(ESM_BKG_0079)<br>
	 * : completeCA 에서 call : 단독 transaction 가지지 않음<br>
	 * : completeCod 에서 call 되는 모듈은 따로 있음 -> BookingCorrectionSC <br>
	 * 
	 * @author    Lee NamKyung
	 * @param     String caRsnCd
	 * @param     String caCorrRmk
	 * @param     BkgBlNoVO bkgBlNoVO
	 * @param     String rdnAcptFlg
	 * @param     String autoCaFlg
	 * @return    BkgBlNoVO
	 * @exception EventException
	 */
	private BkgBlNoVO addCaHistory(String caRsnCd, String caCorrRmk, BkgBlNoVO bkgBlNoVO, String rdnAcptFlg, String autoCaFlg) throws EventException {
		
		BDRCorrectionBC         bDRCorrectionBC         = new BDRCorrectionBCImpl();
		BLDocumentationBLBC     bLDocumentationBLBC     = new BLDocumentationBLBCImpl();
		GeneralBookingReceiptBC generalBookingReceiptBC = new GeneralBookingReceiptBCImpl();
		SpecialCargoReceiptBC   specialCargoReceiptBC   = new SpecialCargoReceiptBCImpl();
		BlRatingBC              blRatingBC              = new BlRatingBCImpl();
		BLIssuanceBC            bLIssuanceBC            = new BLIssuanceBCImpl();
		BookingHistoryMgtBC     historyBC               = new BookingHistoryMgtBCImpl();
		 
		BkgBlNoVO schBkgBlNoVO = new BkgBlNoVO();
		
		try {
			String tempHistCd = "H";
			String copyTypeCd = "HIST";

			//01. createTempHist
			//schBkgBlNoVO = bDRCorrectionBC.createTempHist(bkgBlNoVO, tempHistCd, caRsnCd, caCorrRmk, account);
			BkgCorrectionVO bkgCorrectionVO = new BkgCorrectionVO();
			bkgCorrectionVO.setCaRsnCd   (caRsnCd);
			bkgCorrectionVO.setBkgCorrRmk(caCorrRmk);
			bkgCorrectionVO.setRdnAcptFlg(rdnAcptFlg);
			schBkgBlNoVO = bDRCorrectionBC.createTempHist(bkgBlNoVO, tempHistCd, bkgCorrectionVO, account);

			//02. createBookingCA
			generalBookingReceiptBC.createBookingCA(schBkgBlNoVO, copyTypeCd);
			
			//03. createBlCA 
			bLDocumentationBLBC.createBlCA         (schBkgBlNoVO, copyTypeCd);
			
			//04. createSpclCA
			specialCargoReceiptBC.createSpclCA     (schBkgBlNoVO, copyTypeCd);
			
			//05. createRateCA
			blRatingBC.createRateCA                (schBkgBlNoVO, copyTypeCd);
			
			//06. createIssCA -> 추가됨 
			bLIssuanceBC.createIssCA               (schBkgBlNoVO, copyTypeCd);
			
			//07. 
			historyBC.createHisCA                  (schBkgBlNoVO, copyTypeCd);  
			
			// auto c/a가 아닐 때만 실행함 
			// - 일반 completeCA 일경우에는 두번을 Call 하기 때문에 필어없음.
			// - Auto C/A에서는 사용하지 않고 직접 입력함.
//			if("N".equals(autoCaFlg)){
//				//07. modifyCngItemFlag
//				bDRCorrectionBC.modifyCngItemFlag      (schBkgBlNoVO, account);
//			}
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}		
		
		return schBkgBlNoVO; 
	}	
	
	/**
	 * ESM_BKG_0079 : c/a cancel <br>
	 * user가 진행중인 c/a를 취소 처리한다.<br>
	 * 
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelCA(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0079Event event = (EsmBkg0079Event)e;
		BDRCorrectionBC         bDRCorrectionBC         = new BDRCorrectionBCImpl();
		BLDocumentationBLBC     bLDocumentationBLBC     = new BLDocumentationBLBCImpl();
		GeneralBookingReceiptBC generalBookingReceiptBC = new GeneralBookingReceiptBCImpl();
		SpecialCargoReceiptBC   specialCargoReceiptBC   = new SpecialCargoReceiptBCImpl();
		BlRatingBC              blRatingBC              = new BlRatingBCImpl();
		BookingHistoryMgtBC     bookingHistoryMgtBC     = new BookingHistoryMgtBCImpl();
		BLIssuanceBC            bLIssuanceBC            = new BLIssuanceBCImpl();
		 
		try {
			begin();			
			String copyTypeCd = "TEMP";

			//01. cancelCA
			bDRCorrectionBC.cancelCA(event.getBkgBlNoVO(), account);
						
			//02. 
			specialCargoReceiptBC.removeCA  (event.getBkgBlNoVO(), copyTypeCd);
			//03. 
			blRatingBC.removeCA             (event.getBkgBlNoVO(), copyTypeCd);
			//04. 
			bLDocumentationBLBC.removeCA    (event.getBkgBlNoVO(), copyTypeCd);
			//05. 
			generalBookingReceiptBC.removeCA(event.getBkgBlNoVO(), copyTypeCd);
			//추가. 
			bLIssuanceBC.removeCA           (event.getBkgBlNoVO(), copyTypeCd);
			
			bookingHistoryMgtBC.removeCA    (event.getBkgBlNoVO(), copyTypeCd);
			
			//06. 
			bDRCorrectionBC.removeCATemp    (event.getBkgBlNoVO());
			//07. 
			bookingHistoryMgtBC.removeTmpHistory(event.getBkgBlNoVO());
			
			
			
			commit();			
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());  //BKG00166 : 저장성공
			
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_9424 : retrieve <br>
	 * mty bkg update화면에서 bkg data와 cntr data, VL container List 를 조회한다.<br>
	 * 
	 * @author KimByungKyu
	 * @param Event e
	 * @return	 EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEmptyBooking(Event e) throws EventException{
		try{
			EsmBkg9424Event event = (EsmBkg9424Event)e;
			
			GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();
			
			RepoBkgForUpdateVO repoBkgForUpdateVO = searchBC.searchEmptyBooking(event.getBkgBlNoVO(), event.getBkgMvmtCd());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			eventResponse.setETCData(repoBkgForUpdateVO.getRepoBkgVO().getColumnValues());
			eventResponse.setRsVoList(repoBkgForUpdateVO.getRepoCntr());	
			eventResponse.setRsVoList(repoBkgForUpdateVO.getVlCntr());				
			eventResponse.setRsVoList(repoBkgForUpdateVO.getCntrTpSz());		
			if(repoBkgForUpdateVO.getBkgQuantity() != null){
				eventResponse.setRsVoList(repoBkgForUpdateVO.getBkgQuantity());		
			}
			eventResponse.setETCData("SuccessYn", "Y");		
			
			return eventResponse;			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}	
	
	/**
	 * ESM_BKG_9424 : cntr_no change <br>
	 * Container번호로 Digit,T/S,STS를 조회한다.<br>
	 * 
	 * @author KimByungKyu
	 * @param Event e
	 * @return	 EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrChkDigit(Event e) throws EventException{
		try{
			EsmBkg9424Event event = (EsmBkg9424Event)e;
			
			GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();
			
			CntrChkDigitVO cntrChkDigitVO = searchBC.searchCntrChkDigit(event.getCntrNo());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			if(cntrChkDigitVO != null){
				eventResponse.setETCData(cntrChkDigitVO.getColumnValues());
			}			
			
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}		
	
	
	/**
	 * ESM_BKG_9424 : stowage check <br>
	 * Stowage Plan 조회 <br>
	 * 
	 * @author KimByungKyu
	 * @param Event e
	 * @return	 EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtyCntrList(Event e) throws EventException{
		try{
			EsmBkg9424Event event = (EsmBkg9424Event)e;
			
			GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse.setRsVoList(searchBC.searchMtyCntrList(event.getMvmtOption(), event.getRepoBkgVO().getBkgTrunkVvd(), event.getRepoBkgVO().getOrgYdCd()));	
			
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}				

	/**
	 * ESM_BKG_9424 : cancel <br>
	 * Empty Booking Cancel 처리.<br>
	 * 
	 * @author KimByungKyu
	 * @param Event e
	 * @return	 EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelEmptyBkg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg9424Event event = (EsmBkg9424Event)e;

		BLDocumentationCMBC     blDocCMBC     = new BLDocumentationCMBCImpl();
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		GeneralBookingSearchBC  searchBC   = new GeneralBookingSearchBCImpl();
//		CntrRepoExecutionPlanEstablishBC cntrRepoBC = new CntrRepoExecutionPlanEstablishBCImpl();
		CntrMtyBkgCreateBC      cntrRepoBC = new CntrMtyBkgCreateBCImpl();
		 
		try {
			begin();			
			
			// 58. cancelContainer
			blDocCMBC.cancelBkgCntr(event.getBkgBlNoVO(), account);
			// 60. cancelEmptyBkg
			receiptBC.cancelMtyBkg(event.getBkgBlNoVO(), account);
			
			// 62. modifyMtyCancel -EQR
			MtyBkgVO mtyBkgVO = new MtyBkgVO();
			mtyBkgVO.setMtyBkgNo(event.getBkgBlNoVO().getBkgNo());
			
			if(event.getBkgBlNoVO().getBkgNo().length()==11 
					||(event.getBkgBlNoVO().getBkgNo().length()==12&&"00".equals(event.getBkgBlNoVO().getBkgNo().substring(10)))){
				mtyBkgVO.setSplitFlg("N");				
			} else {
				mtyBkgVO.setSplitFlg("Y");	
			}
			log.debug("splitFlag:"+mtyBkgVO.getSplitFlg());
			mtyBkgVO.setUsrId(account.getUsr_id());
			
			// cancel시 vol change 처리하지 않음(20091202 신용찬 수석 요청)
//			cntrRepoBC.modifyMtyBkgVolChange(mtyBkgVO);			
			cntrRepoBC.modifyMtyBkgCancel(mtyBkgVO);
			
//			cntrRepoBC.createMtyBkgHistory("BX", mtyBkgVO.getMtyBkgNo(), account.getUsr_id(), null);
			
			//empty booking cancel EDI 전송 추가 : POL 조건 추가 필요
			/*BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(mtyBkgVO.getMtyBkgNo());

			Vender301ParamVO vender301ParamVO = new Vender301ParamVO();

			vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
			vender301ParamVO.setBracCd("R");  // Booking cancel --> 'R'
			vender301ParamVO.setEdiKind("BT");
			vender301ParamVO.setAutoManualFlg("Y");
								
			searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);*/
			
			commit();		
			eventResponse.setETCData("SuccessYn", "Y");
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		
		return eventResponse;
	}	


	/**
	 * ESM_BKG_9424 : save <br>
	 * Empty Booking 저장<br>
	 * 
	 * @author KimByungKyu
	 * @param Event e
	 * @return	 EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyMtyRepoBkg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg9424Event event = (EsmBkg9424Event)e;

		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		BLDocumentationBLBC     blDocBLBC = new BLDocumentationBLBCImpl();
		PerformanceReportBC 	performReportBc = new PerformanceReportBCImpl();
		BookingUtil           	utilBC    = new BookingUtil();
		ContainerMovementMgtBC  ctmCmd    = new ContainerMovementMgtBCImpl();
//		CntrRepoExecutionPlanEstablishBC cntrRepoBC = new CntrRepoExecutionPlanEstablishBCImpl();
		CntrMtyBkgCreateBC      cntrRepoBC= new CntrMtyBkgCreateBCImpl();
		BLDocumentationCMBC 	cmBlBC 	  = new BLDocumentationCMBCImpl();
		ContainerOnOffhireBC 	cntrOffBC = new ContainerOnOffhireBCImpl();
		GeneralBookingSearchBC  searchBC   = new GeneralBookingSearchBCImpl();
		MstContainerVO mstContainerVO = null;
		CusCtmMovementVO custCtmVO = null;
		CrossItemVO crossItemVO = null;

		try {
			begin();			
			RepoBkgForUpdateVO repoBkgForUpdateVO = new RepoBkgForUpdateVO();
			repoBkgForUpdateVO.setBkgBlNoVO(event.getBkgBlNoVO());
			repoBkgForUpdateVO.setRepoBkgVO(event.getRepoBkgVO());
			repoBkgForUpdateVO.setRepoCntrVOs(event.getRepoCntrVOs());
			String trunkVvd = event.getTrunkVvd();
			String bkgNo = event.getBkgBlNoVO().getBkgNo();
			
			// 15. modifyRepoBkg 
			receiptBC.modifyMtyRepoBkg(repoBkgForUpdateVO, account);
			
			// 26. manageEmptyCntr
			List<CusCtmMovementVO> ctmMovementVO = blDocBLBC.manageEmptyCntr(repoBkgForUpdateVO, trunkVvd, account);
			
			// 42. completeModifyMtyRepoBkg
			List<BkgQuantityVO> bkgQtyVO = receiptBC.completeModifyMtyRepoBkg(repoBkgForUpdateVO, account);

			// MTY BKG ROUTE 에 FORBIDDEN 에 해당하면 EXCEPTION 발생 (CSR : CHM-201642370, 신용찬, 2016-07-18)
			cntrRepoBC.checkNotPerimtTypeSize(repoBkgForUpdateVO);
			
			if(repoBkgForUpdateVO.getRepoCntrVOs() != null && repoBkgForUpdateVO.getRepoCntrVOs().length > 0){
				for(int i = 0; i < repoBkgForUpdateVO.getRepoCntrVOs().length; i++){
					if(repoBkgForUpdateVO.getRepoCntrVOs()[i].getIbflag().equals("I")){
						cntrRepoBC.createMtyBkgHistory("CA", bkgNo, account.getUsr_id(), repoBkgForUpdateVO.getRepoCntrVOs()[i].getFullCntrNo());
					} else if(repoBkgForUpdateVO.getRepoCntrVOs()[i].getIbflag().equals("D")){
						cntrRepoBC.createMtyBkgHistory("CD", bkgNo, account.getUsr_id(), repoBkgForUpdateVO.getRepoCntrVOs()[i].getFullCntrNo());
					}
				}
			}
			// 64. 
			log.debug("to ctm ["+ctmMovementVO.size()+"] VL container");

			for (CusCtmMovementVO vo : ctmMovementVO) {
				if (!"VL".equals(vo.getMvmtStsCd())) continue;
//				log.error("==> [EQR VL] bkgNo : "+bkgNo);
				break;
			}
			for (CusCtmMovementVO vo : ctmMovementVO) {
				// VL 일 때만 CTM으로 update
				if (!"VL".equals(vo.getMvmtStsCd())) continue;
				log.debug("cntr_no:"+vo.getCntrNo());
				log.debug("cnmv_yr:"+vo.getCnmvYr());
				log.debug("cnmv_id_no:"+vo.getCnmvIdNo());
				log.debug("trnk_vsl_cd:"+vo.getTrnkVslCd());
				log.debug("crnt_vsl_cd:"+vo.getCrntVslCd());				
				ctmCmd.modifyMovementFromBkgForPreVL(vo);
				// 65. MST CONTAINER에 PRE_STS_FLG,BKG_NO,VVD 정보를 UPDATE한다.
				mstContainerVO = cmBlBC.searchMstCntrForMst(vo.getCntrNo());
				if (mstContainerVO != null && "Y".equals(mstContainerVO.getPreStsFlg())) {
					custCtmVO = new CusCtmMovementVO();
					crossItemVO = new CrossItemVO();
					custCtmVO.setCntrSvrId(mstContainerVO.getSysAreaGrpId());
					custCtmVO.setCnmvYr(mstContainerVO.getCnmvYr());
					custCtmVO.setCnmvIdNo(mstContainerVO.getCnmvIdNo());
					custCtmVO.setCnmvSeq(mstContainerVO.getCnmvSeq());
					custCtmVO.setCnmvSplitNo(mstContainerVO.getCnmvSplitNo());
					custCtmVO.setCnmvCycNo(mstContainerVO.getCnmvCycNo());
					custCtmVO.setCnmvEvntDt(mstContainerVO.getCnmvDt());
					custCtmVO.setPreStsFlg("N");
					custCtmVO.setBkgNo(bkgNo);
					custCtmVO.setBkgKnt(mstContainerVO.getBkgKnt());
					custCtmVO.setFcntrFlg("N");
					custCtmVO.setOrgYdCd(mstContainerVO.getCrntYdCd());
					custCtmVO.setDestYdCd(mstContainerVO.getDestYdCd());
					custCtmVO.setCntrId(trunkVvd);
					custCtmVO.setMvmtStsCd(mstContainerVO.getCnmvStsCd());
					custCtmVO.setAciacDivCd(mstContainerVO.getAciacDivCd());
					custCtmVO.setUpdUsrId(account.getUsr_id());
					custCtmVO.setCntrNo(vo.getCntrNo());
					crossItemVO.setUpdateMaster(true);
					crossItemVO.setCusCtmMovementVO(custCtmVO);
					cntrOffBC.updateCntrMasterByMvmtBasic(crossItemVO);
				}
			}

			MtyBkgVO mtyBkgVO = new MtyBkgVO();
			mtyBkgVO.setMtyBkgNo(bkgNo);
			mtyBkgVO.setUsrId(account.getUsr_id());
			
			if(bkgNo.length()==11 
					||(bkgNo.length()==12&&"00".equals(bkgNo.substring(10)))){
				mtyBkgVO.setSplitFlg("N");				
			} else {
				mtyBkgVO.setSplitFlg("Y");	
			}

			performReportBc.manageQtyCntrCoposite(bkgNo, "CQ");
			
			if("Y".equals(mtyBkgVO.getSplitFlg())){
//				1. Split변경시 
//				   1) volumeChange Call
//				     (컨테이너가 다 떼어진 경우는 Cancel Call)
//				cntrRepoBC.modifyMtyBkgVolChange(mtyBkgVO);
				if(bkgQtyVO.size()==0){
					cntrRepoBC.modifyMtyBkgCancel(mtyBkgVO);
				} 

//				   2) Original BKG volumeChange Call
				MtyBkgVO mstMtyBkgVO = new MtyBkgVO();
				mstMtyBkgVO.setMtyBkgNo(utilBC.searchSplitMstBkgNo(bkgNo));
				mstMtyBkgVO.setUsrId(account.getUsr_id());
				mstMtyBkgVO.setSplitFlg("N");	
//				cntrRepoBC.modifyMtyBkgVolChange(mstMtyBkgVO);
				performReportBc.manageQtyCntrCoposite(mstMtyBkgVO.getMtyBkgNo(), "CQ");
//			} else {
//				2. Original 변경시
//				   1) volumeChange Call
//				     (컨테이너가 다 떼어진 경우는volumeChange Call 없이 Cancel Call)
//				     ==> ORIGIN VOLUME 컨테이너가 다 떼어진 경우  volume change call 하고 cancel call 안함.
//				     20100106 신용찬 수석님 메일
//				if(bkgQtyVO.size()==0){
//					cntrRepoBC.modifyMtyBkgCancel(mtyBkgVO);
//					cntrRepoBC.modifyMtyBkgVolChange(mtyBkgVO);
//				} else {
//					cntrRepoBC.modifyMtyBkgVolChange(mtyBkgVO);
//				} 
			}
			
			//empty booking cancel EDI 전송 추가 : POL 조건 추가 필요
			/*BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(mtyBkgVO.getMtyBkgNo());

			Vender301ParamVO vender301ParamVO = new Vender301ParamVO();

			vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
			vender301ParamVO.setBracCd("U");  // Booking cancel --> 'R'
			vender301ParamVO.setEdiKind("BT");
			vender301ParamVO.setAutoManualFlg("Y");
								
			searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);*/
			
			commit();		
			eventResponse.setETCData("SuccessYn", "Y");
		}catch(EventException ex){
			rollback();
//			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
		
		return eventResponse;
	}	

	/**
	 * sendBkgTmlEdiMulti()에서 실행한다. <br>
	 * Terminal정보를 Flat File로 생성하여 EDI로 전송한다.<br>
	 * 
	 * @author	Jun Yong Jin
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param   List<BkgVvdVO> oldVvdVOs
	 * @param   String rcvId
	 * @param   String bracCd
	 * @param   String ediKind
	 * @param   String autoManualFlg
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse sendBkgTmlEdi(BkgBlNoVO bkgBlNoVO, List<BkgVvdVO> oldVvdVOs, String rcvId, String bracCd, String ediKind, String autoManualFlg) throws EventException{
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{			
			if (bkgBlNoVO != null) {
				// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
				Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
				vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
				vender301ParamVO.setOldVvdVOs(oldVvdVOs);
				vender301ParamVO.setOldQtyVOs(null);
				vender301ParamVO.setOldMtyPkupYdCd(null);
				vender301ParamVO.setBracCd(bracCd);
				vender301ParamVO.setEdiKind(ediKind);
				vender301ParamVO.setAutoManualFlg(autoManualFlg);
				vender301ParamVO.setRcvId(rcvId);
				
				List<BkgNtcHisVO> bkgNtcHisVOs = command.createTmlBkgReceiptEdi(vender301ParamVO, account);
				bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, "");
			}

			eventResponse.setETCData("SuccessYn", "Y");
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}		
		return eventResponse;
	}	

	/**
	 * ESM_BKG_0702 : edi transmit <br>
	 * Terminal정보를 Flat File로 생성하여 EDI로 전송한다.<br>
	 *  
	 * @author	Jun Yong Jin
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse sendBkgTmlEdiMulti(Event e) throws EventException{
		BkgBlNoVO[] bkgBlNoVO = null;
		CustTpIdVO[] custTpIdVO = null;
		String bracCd = null;
		String ediKind = null;
		String autoManualFlg = null;

		if (e.getEventName().equalsIgnoreCase("EsmBkg0702Event")) {
			EsmBkg0702Event event = (EsmBkg0702Event)e;
			bkgBlNoVO = event.getBkgBlNoVOs();
			custTpIdVO = event.getCustTpIdVOs();
			bracCd = "M";
			ediKind = "BM";
			autoManualFlg = "N";

		} else {
			EsmBkg0616Event event = (EsmBkg0616Event)e;
			bkgBlNoVO = event.getBkgBlNoVOs();
			custTpIdVO = event.getCustTpIdVOs();
			bracCd = event.getBracCd();
			ediKind = "BM";//BM이면 화면에서 선택한 BRAC CD를 그대로 넣음
			/*	CD	DESC		BRAC
		 		A	Add			A
				B	Original	N
				C	Change		G
				R	Replace		U
				X	Cancel		R*/
			if(bracCd.equals("B")){
				bracCd = "N";
			} else if(bracCd.equals("C")){
				bracCd = "G";
			} else if(bracCd.equals("R")){
				bracCd = "U";
			} else if(bracCd.equals("X")){
				bracCd = "R";
			} else {
				bracCd = "U";
			}
			autoManualFlg = "N";
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();			

			if (bkgBlNoVO.length > 0) {
				for(int i=0;i<bkgBlNoVO.length;i++) {
					sendBkgTmlEdi(bkgBlNoVO[i],null,custTpIdVO[i].getRcvId(), bracCd, ediKind, autoManualFlg);
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

	/**
	 * ESM_BKG_0702 : customer click <br>
	 * Customer정보를 Flat File로 생성하여 EDI로 전송한다.<br>
	 * 
	 * @author	Jun Yong Jin
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse sendBkgCustEdiMulti(Event e) throws EventException{
		EsmBkg0702Event event = (EsmBkg0702Event)e;
		GeneralEventResponse eventResponse = null;
		GeneralBookingReceiptBC command = null;
		BkgBlNoVO[] bkgBlNoVO = null;
		CustTpIdVO[] custTpIdVO = null;
		String typeGbn = null;
		String jobID = null;
		try{
			begin();
			eventResponse = new GeneralEventResponse();
			command = new GeneralBookingReceiptBCImpl();
			bkgBlNoVO = event.getBkgBlNoVOs();
			custTpIdVO = event.getCustTpIdVOs();
			typeGbn = event.getTypeGbn();
			jobID = command.sendBkgCustEdiMulti(bkgBlNoVO,custTpIdVO,typeGbn,account);
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
	 * Customer EDI로 전송 BackEndJob 상태 확인<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchSendBkgCustEdiMultiStatus(Event e) throws EventException {
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
	 * Customer EDI로 전송 BackEndJob 결과 확인<br>
	 * 
	 * @author	Jun Yong Jin
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchSendBkgCustEdiMulti(Event e) throws EventException{
		GeneralEventResponse eventResponse = null;
		GeneralBookingReceiptBC command = null;
		String result = null;
		try{
			eventResponse = new GeneralEventResponse();
			command = new GeneralBookingReceiptBCImpl();
			result = command.searchSendBkgCustEdiMulti(JSPUtil.getNullNoTrim((String)e.getAttribute("key")));
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
	 * ESM_BKG_9454 : open <br>
	 * Empty booking의 Transhipment Route 조회 <br>
	 * 
	 * @author KimByungKyu
	 * @param Event e
	 * @return	 EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEmptyBkgTsRoute(Event e) throws EventException{
		try{
			EsmBkg9454Event event = (EsmBkg9454Event)e;
			
			GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();
			
			List<MtyBkgTsRouteVO> mtyBkgTsRoute = searchBC.searchEmptyBkgTsRoute(event.getBkgBlNoVO());
			
			List<MtyBkgTsRouteVO> preVvd = new ArrayList<MtyBkgTsRouteVO>();
			List<MtyBkgTsRouteVO> trunkVvd = new ArrayList<MtyBkgTsRouteVO>();
			List<MtyBkgTsRouteVO> postVvd = new ArrayList<MtyBkgTsRouteVO>();
			
			if(mtyBkgTsRoute != null){
				for(int i = 0 ; i < mtyBkgTsRoute.size() ; i++){
					if("S".equals(mtyBkgTsRoute.get(i).getVslPrePstCd())){
						preVvd.add(mtyBkgTsRoute.get(i));
					}else if("T".equals(mtyBkgTsRoute.get(i).getVslPrePstCd())){
						trunkVvd.add(mtyBkgTsRoute.get(i));
					}else{
						postVvd.add(mtyBkgTsRoute.get(i));
					}
				}
			}
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse.setRsVoList(preVvd);
			eventResponse.setRsVoList(trunkVvd);	
			eventResponse.setRsVoList(postVvd);	
			
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}		
	

	/**
	 * ESM_BKG_9455 : open <br>
	 * Yard에 Empty Status로 존재하는 Container List를 조회한다.<br>
	 * 
	 * @author KimByungKyu
	 * @param Event e
	 * @return	 EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrByYard(Event e) throws EventException{
		try{
			EsmBkg9455Event event = (EsmBkg9455Event)e;
			
			GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();		

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse.setRsVoList(searchBC.searchCntrByYard(event.getVvd(), event.getYdCd(), event.getCntrTpsz()));

			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}		

	/**
	 * ESM_BKG_9425 : open <br>
	 * empty booking list를 조회한다.<br>
	 * 
	 * @author KimByungKyu
	 * @param Event e
	 * @return	 EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEmptyBkgList(Event e) throws EventException{
		try{
			EsmBkg9425Event event = (EsmBkg9425Event)e;
			
			GeneralBookingListSearchBC listSearchBC = new GeneralBookingListSearchBCImpl();		
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			EmptyBkgListInqVO emptyBkgListInqVO = listSearchBC.searchEmptyBkgList(event.getEmptyBkgListInputVO());
			
			if(emptyBkgListInqVO.getEmptyBkgList() != null && emptyBkgListInqVO.getEmptyBkgList().size() > 0){
				eventResponse.setRsVoList(emptyBkgListInqVO.getEmptyBkgList());
				eventResponse.setETCData(emptyBkgListInqVO.getEmptyCntrSumVO().getColumnValues());			
			}else{
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			}
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}	
	
	/**
	 * ESM_BKG_9425 : COMMAND01 <br>
	 * empty booking Hanger list를 조회한다.<br>
	 * 
	 * @author DYRYU
	 * @param Event e
	 * @return	 EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEmptyBkgHangerList(Event e) throws EventException{
		try{
			EsmBkg9425Event event = (EsmBkg9425Event)e;
			
			GeneralBookingListSearchBC listSearchBC = new GeneralBookingListSearchBCImpl();		
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			List<EmptyBkgHangerListVO> EmptyBkgHangerListVOs = listSearchBC.searchEmptyBkgHangerList(event.getEmptyBkgListInputVO());
			
			if(EmptyBkgHangerListVOs != null && EmptyBkgHangerListVOs.size() > 0){
				eventResponse.setRsVoList(EmptyBkgHangerListVOs);			
			}else{
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			}
			return eventResponse;			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}	

	/**
	 * ESM_BKG_0616 : retrieve <br>
	 * 미국외 지역에 terminal edi를 보내기 위한 Booking 리스트를 조회한다.<br>
	 * 
	 * @author	Jun Yong Jin
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchBkgListForGeneralTmlEdi(Event e) throws EventException{
		try{
			EsmBkg0616Event event = (EsmBkg0616Event)e;
			GeneralBookingListSearchBC command = new GeneralBookingListSearchBCImpl();
			ArrayList<String> bkgNoTmp = new ArrayList();
			ArrayList<String> bkgNoCnt = new ArrayList();
	
			// bkg_no가 넘어온 경우 bkg_no만 VO에 담고 나머지는 초기화 - bkg_no만 조회 시
			BkgListForTmlEdiInputVO bkgListForTmlEdiInputTmpVO = event.getBkgListForTmlEdiInputVO();
			BkgListForTmlEdiInputVO bkgListForTmlEdiInputVO = new BkgListForTmlEdiInputVO();
			if ( !isNull(event.getBkgListForTmlEdiInputVO().getBkgNo()) ) {
				bkgListForTmlEdiInputVO.setBkgNo(bkgListForTmlEdiInputTmpVO.getBkgNo());
	        } else bkgListForTmlEdiInputVO = bkgListForTmlEdiInputTmpVO;
	
			List<BkgListForGeneralTmlEdiVO> list = command.searchBkgListForGeneralTmlEdi(bkgListForTmlEdiInputVO);
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
	
			int crnTotal = 0;
			int ediSent = 0;
			int ediUnSent = 0;
	
			// 통계성 데이터 취합
			for (int i=0;i<list.size();i++) {
				BkgListForGeneralTmlEdiVO listVO = (BkgListForGeneralTmlEdiVO)list.get(i);
				bkgNoTmp.add(listVO.getBkgNo());
				if ( !isNull(listVO.getCrn()) ) crnTotal++;
				if ( !isNull(listVO.getSendDate()) ) ediSent++;
				if ( isNull(listVO.getSendDate()) ) ediUnSent++;
			}
	
			// bkg_no list를 distinct로 만들어 unique한 bkg_no만 남도록
			HashSet<String> hs = new HashSet<String>(bkgNoTmp);
			Iterator it = hs.iterator();
			while(it.hasNext()){
				bkgNoCnt.add(it.next().toString());
			}
	
			eventResponse.setETCData("bkgTotal",String.valueOf(bkgNoCnt.size()));
			eventResponse.setETCData("crnTotal",String.valueOf(crnTotal));
			eventResponse.setETCData("ediSent",String.valueOf(ediSent));
			eventResponse.setETCData("ediUnSent",String.valueOf(ediUnSent));
			eventResponse.setETCData("ackRcv","");
			eventResponse.setETCData("tmlErr","");

			return eventResponse;			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  
		}
	}		

	/**
	 * ESM_BKG_0616 : retrieve <br>
	 * 미주 지역에서 terminal edi에 대한 송수신 이력과 전송대상 Booking 리스트를 조회한다.<br>
	 * 
	 * @author	Jun Yong Jin
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchBkgListForUsaTmlEdi(Event e) throws EventException{
		try{
			EsmBkg0616Event event = (EsmBkg0616Event)e;
			GeneralBookingListSearchBC command = new GeneralBookingListSearchBCImpl();
			ArrayList<String> bkgNoTmp = new ArrayList();
			ArrayList<String> bkgNoCnt = new ArrayList();
	
			// bkg_no가 넘어온 경우 bkg_no만 VO에 담고 나머지는 초기화 - bkg_no만 조회 시
			BkgListForTmlEdiInputVO bkgListForTmlEdiInputTmpVO = event.getBkgListForTmlEdiInputVO();
			BkgListForTmlEdiInputVO bkgListForTmlEdiInputVO = new BkgListForTmlEdiInputVO();
			if ( !isNull(event.getBkgListForTmlEdiInputVO().getBkgNo()) ) {
				bkgListForTmlEdiInputVO.setBkgNo(bkgListForTmlEdiInputTmpVO.getBkgNo());
	        } else bkgListForTmlEdiInputVO = bkgListForTmlEdiInputTmpVO;
	
			List<BkgListForUsaTmlEdiVO> list = command.searchBkgListForUsaTmlEdi(bkgListForTmlEdiInputVO);
	
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
	
			int ediSent = 0;
			int ediUnSent = 0;
			int ackRcv = 0;
			int tmlErr = 0;
	
			// 통계성 데이터 취합
			for (int i=0;i<list.size();i++) {
				BkgListForUsaTmlEdiVO listVO = (BkgListForUsaTmlEdiVO)list.get(i);
				bkgNoTmp.add(listVO.getBkgNo());
				if ( !isNull(listVO.getSendDate()) ) ediSent++;
				if ( isNull(listVO.getSendDate()) ) ediUnSent++;
				if ( !isNull(listVO.getAck()) ) ackRcv++;
				if ( !isNull(listVO.getTmlErrMsg()) ) tmlErr++;
			}
			log.debug("ackRcv:"+ackRcv);
	
			// bkg_no list를 distinct로 만들어 unique한 bkg_no만 남도록
			HashSet<String> hs = new HashSet<String>(bkgNoTmp);
			Iterator it = hs.iterator();
			while(it.hasNext()){
				bkgNoCnt.add(it.next().toString());
			}
	
			eventResponse.setETCData("bkgTotal",String.valueOf(bkgNoCnt.size()));
			eventResponse.setETCData("crnTotal","");
			eventResponse.setETCData("ediSent",String.valueOf(ediSent));
			eventResponse.setETCData("ediUnSent",String.valueOf(ediUnSent));
			eventResponse.setETCData("ackRcv",String.valueOf(ackRcv));
			eventResponse.setETCData("tmlErr",String.valueOf(tmlErr));

			return eventResponse;			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  
		}
	}

	/**
	 * ESM_BKG_0616 : save <br> 
	 * 말레이지아 지역에서 Booking별로 forwarder code와 vsl reference 정보를 수정한다.<br>
	 * 
	 * @author Jun Yong Jin
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMyFwrdRefVvd(Event e) throws EventException{
		EsmBkg0616Event event = (EsmBkg0616Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		try{
			begin();			

			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
			receiptBC.manageMyFwrdRefVvd(event.getFwrdRefVvdVOs(), account);

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

	/**
	 * ESM_BKG_0095 : Open <br>
	 * Fax/Email/EDI 발송 리스트를 조회한다.<br>
	 * 
	 * @author	Jun Yong Jin
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchBkgFaxEmailEdi(Event e) throws EventException{
		try{
			EsmBkg0095Event event = (EsmBkg0095Event)e;
			event.getBkgBlNoVO().setPolCd(event.getPolCd());
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			List<SendBkgFaxEmailVO> list1 =  command.searchFaxEmailForNotice(event.getBkgBlNoVO(), account);
			List<SendBkgEdiVO> list2 =  command.searchEdiForNotice(event.getBkgBlNoVO());
			String receiptType = command.searchBkgReceiptType(account.getUsr_id());			
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
			eventResponse.setCustomData("receipt_type", receiptType);

			return eventResponse;			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  
		}
	}		

	/**
	 * ESM_BKG_0095 : FAX 버튼 클릭 <br>
	 * Booking 리스트에서 RD를 FAX로 발송한다.<br>
	 * 
	 * @author	Jun Yong Jin
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse sendBkgFaxNotice(Event e) throws EventException{
		EsmBkg0095Event event = (EsmBkg0095Event)e;
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		EmptyReleaseOrderBC emptyRlsBC = new EmptyReleaseOrderBCImpl();
		BLIssuanceBC bLIssuanceBC = new BLIssuanceBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil utilBC = new BookingUtil();
		List<BkgNtcHisVO> bkgNtcHisVOs = null;
		BkgBlNoVO bkgBlNoVO = null;
		BkgBlNoVO [] bkgBlNoVOs = null;
		String [] ntcKndCd = null;
		String [] faxNo = null;
		String [] rmk = null;
		String mrdNm = null;
		String param = null;
		String sType = null;
		String sLevel = null;
		String sMrd = null;
		try{
			begin();
			bkgNtcHisVOs = null;
			bkgBlNoVO = event.getBkgBlNoVO();
			bkgBlNoVOs = event.getBkgBlNoVOs();
			ntcKndCd = event.getNtcKndCd();
			faxNo = event.getFaxNo();
			rmk = event.getRemark();
			mrdNm = null;
			param = null;
			sType = "";
			sLevel = "";
			sMrd = "";
//			boolean isDraftBL = false; 
			for(int i=0;i<bkgBlNoVOs.length;i++) {
				log.debug("Notice Kind : " + ntcKndCd[i]);
				bkgBlNoVOs[i].setBkgNo(bkgBlNoVO.getBkgNo());
				
				if ("BK".equals(ntcKndCd[i])) {
					if("Y".equals(utilBC.searchNoRateBlockFlg(bkgBlNoVO))){
						throw new EventException(new ErrorHandler("BKG08333",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
					}
					if("Y".equals(utilBC.searchStandbyBlockFlg(bkgBlNoVO))){
						throw new EventException(new ErrorHandler("BKG08284",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
					}
					log.debug("receiveType:"+ event.getReceiveType());
					mrdNm = "Normal".equals(event.getReceiveType())?"ESM_BKG_5005G":"ESM_BKG_5005C";
					String [] cct = new String[event.getFaxNo().length];
					String [] docCct = new String[event.getFaxNo().length];
					for(int j=0;j<cct.length;j++){
						cct[j]="";
						docCct[j]="";
					}
					log.debug("mrd:"+mrdNm+", fax:" + faxNo[i]);
					BkgReceiptSendVO bkgReceiptSendVO = new BkgReceiptSendVO();
					bkgReceiptSendVO.setBkgBlNoVos(bkgBlNoVOs);
					bkgReceiptSendVO.setFaxNos(faxNo);
					bkgReceiptSendVO.setRemarks(rmk);
					bkgReceiptSendVO.setMrdNm(mrdNm);
					bkgReceiptSendVO.setCcts(cct);
					bkgReceiptSendVO.setDocCcts(docCct);
					bkgNtcHisVOs = command.sendBkgReceiptByFax(bkgReceiptSendVO, account);
				} else if ("CN".equals(ntcKndCd[i])) {
					if("Y".equals(utilBC.searchNoRateBlockFlg(bkgBlNoVO))){
						throw new EventException(new ErrorHandler("BKG08335",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
					}
					if("Y".equals(utilBC.searchStandbyBlockFlg(bkgBlNoVO))){
						throw new EventException(new ErrorHandler("BKG08336",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
					}
					param = "/rv bkg_no[('"+bkgBlNoVOs[i].getBkgNo()+"')] "
										+ " remark[" +rmk[i]+"@@ ] "
										+ " usr_id[" +account.getUsr_id()+"] "
										+ " type[detail] "
										+ " isEncode[Y] ";
					log.debug("param:"+param);
					SendMtyRlseOrdVO [] sendMtyRlseOrdVO = new SendMtyRlseOrdVO[1];
					sendMtyRlseOrdVO[0] = new SendMtyRlseOrdVO();
					sendMtyRlseOrdVO[0].setDiffRmk("");
					sendMtyRlseOrdVO[0].setBkgNo(bkgBlNoVOs[i].getBkgNo());
					sendMtyRlseOrdVO[0].setNtcFaxNo(faxNo[i]);					
					sendMtyRlseOrdVO[0].setTmplParam(param);
					
					bkgNtcHisVOs = emptyRlsBC.sendMtyRlseOrdByFax(sendMtyRlseOrdVO, account);
				
				} else if ("BL".equals(ntcKndCd[i]) || "WB".equals(ntcKndCd[i]) || "NN".equalsIgnoreCase(ntcKndCd[i])) {
					if ("BL".equalsIgnoreCase(ntcKndCd[i])) {
						if("Y".equals(utilBC.searchNoRateBlockFlg(bkgBlNoVO))){
							throw new EventException(new ErrorHandler("BKG08333",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
						}
						if("Y".equals(utilBC.searchStandbyBlockFlg(bkgBlNoVO))){
							throw new EventException(new ErrorHandler("BKG08284",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
						}
						sType="2";
						sMrd="ESM_BKG_0109_DBL.mrd";
//						isDraftBL = true;
					} else if ("WB".equalsIgnoreCase(ntcKndCd[i])) {
						sType="5";
						sMrd="ESM_BKG_0109_OBL_A4.mrd";
					} else if ("NN".equalsIgnoreCase(ntcKndCd[i])) {
						sType="2";
						sMrd="ESM_BKG_0109_OBL_A4.mrd";
					}
					if ("ALL".equalsIgnoreCase(event.getFrtTerm()[i])) {
						sLevel="1";
					} else if ("C".equalsIgnoreCase(event.getFrtTerm()[i])) {
						sLevel="5";
					} else if ("P".equalsIgnoreCase(event.getFrtTerm()[i])) {
						sLevel="4";
					} else if ("N".equalsIgnoreCase(event.getFrtTerm()[i])) {
						sLevel="6";
					} else if ("A".equalsIgnoreCase(event.getFrtTerm()[i])) {
						sLevel="3";
					} else {
						sLevel="1";
					}
					String hiddenData = "N";
					if("1".equals(event.getFrtCltFlg()[i])){
						hiddenData = "Y";
					}
					param="/rv form_bkgNo[( '" + bkgBlNoVOs[i].getBkgNo() + "') ]"
						  + "  form_type["+sType+"]"
					      + " form_dataOnly[N]"
					      + " form_manifest[N]"
					      + " form_usrId[" +account.getUsr_id()+"] "
					      + " form_hiddeData["+hiddenData+"]"
					      + " form_level[("+sLevel+")]"
						  + " form_remark[" +rmk[i]+"]"
						  + " form_Cntr[1]"
						  + " form_mainOnly[N]"
						  + " form_CorrNo[]"
						  + " form_his_cntr[BKG_CONTAINER]"
						  + " form_his_bkg[BKG_BOOKING]"
						  + " form_his_mkd[BKG_BL_MK_DESC]"
						  + " form_his_xpt[BKG_XPT_IMP_LIC]"
						  + " form_his_bl[BKG_BL_DOC]"
						  + " isEncode[Y]"
						  + " /rp []"
						  + " /riprnmargin";
						  
					DblWblVO dblWblVO = new DblWblVO();
					DblWblVO[] dblWblVOs = new DblWblVO[1];
					dblWblVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
					dblWblVO.setSyscd("BKG");
					dblWblVO.setTmplmrd(sMrd);
					dblWblVO.setBatchflg("N");
					dblWblVO.setTmplparam(param);
					dblWblVO.setRcvinfo(event.getFaxNo()[i]);
					dblWblVO.setTmplmrdpdf("Original.pdf");
					dblWblVO.setItr("|$$|");
					dblWblVO.setNtcKndCd(event.getNtcKndCd()[i]);
					dblWblVOs[0]=dblWblVO;
					bkgNtcHisVOs = bLIssuanceBC.sendDblWblByFax(dblWblVOs, account);
				
				} else if ("SN".equals(ntcKndCd[i]) || "HI".equals(ntcKndCd[i]) || "HO".equals(ntcKndCd[i])) {
					if ( "SN".equals(ntcKndCd[i])) {
						mrdNm = "ESM_BKG_0866";
						param = "/rp ["+bkgBlNoVO.getBkgNo()+"] [Y]";						
					} else if ( "HI".equals(ntcKndCd[i]) ) {
						mrdNm = "ESM_BKG_5021";
						param = "/rv BKG_NO['"+bkgBlNoVO.getBkgNo()+"'] IO_BND_CD['I'] CMDT[''] RECEIVER[''] OTHER[''] CUST_NTC_IS[N] CUST_NTC[] SLCT_CNTR['']";						
					} else if ( "HO".equals(ntcKndCd[i]) ) {
						mrdNm = "ESM_BKG_5021";		
						param = "/rv BKG_NO['"+bkgBlNoVO.getBkgNo()+"'] IO_BND_CD['O'] CMDT[''] RECEIVER[''] OTHER[''] CUST_NTC_IS[N] CUST_NTC[] SLCT_CNTR['']";	
					}
					bkgNtcHisVOs = command.sendBkgNoticeByFax(mrdNm, ntcKndCd[i], faxNo[i], param, bkgBlNoVOs[i], account);
				}
			}		
			bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
			commit();
			
			/**
		    * BPM 연동 처리 부분 ( BPM POC 이후 삭제 필요 )
		    */
//			if (isDraftBL == true && event.getDpcsSrKndCd().equalsIgnoreCase("F") &&  !event.getDpcsSrNo().equals("")){
//				BookingInterfaceMgtBC bpmBc = new BookingInterfaceMgtBCImpl();
//				String eventKey = event.getBkgBlNoVO().getBkgNo() + "_" +event.getDpcsSrNo();
//				bpmBc.bpmExecCall("BL",eventKey,account.getUsr_id());
//			}
			
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
	
	/**
	 * ESM_BKG_0095 : Email 버튼 클릭 <br>
	 * Booking 리스트에서 RD를 EMAIL로 발송한다.<br>
	 * 
	 * @author	Jun Yong Jin
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse sendBkgEmailNotice(Event e) throws EventException {
		final String[] arrName = {
				"IBM_MARK",						//0. M&D시트 추가로 인하여
				"I_BKG_CNTR.CNTR_NO",			//1. 컨테이너 셀위치 반환을 위한값
				"HBL.I_CM_MARK_DESC.CNTR_NO"	//2. HBL컨테이너 셀위치 반환을 위한값
			};
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0095Event event = (EsmBkg0095Event)e;
		GeneralBookingSearchBC command  = new GeneralBookingSearchBCImpl();
		EmptyReleaseOrderBC emptyRlsBC = new EmptyReleaseOrderBCImpl();
		BLIssuanceBC bLIssuanceBC = null;
		BookingUtil utilBC = null;
		BookingHistoryMgtBC bkgHisCmd = null;
//		PerformanceReportBC pfmcRptBC = null;
		List<BkgNtcHisVO> bkgNtcHisVOs = null;
		List<BkgHrdCdgCtntVO> simSiList = null;
		List<BkgHrdCdgCtntVO> simSiCntrList = null;
		List<BkgHrdCdgCtntVO> ssHblCntrList = null;
		StringBuilder sbParam = null;
		String mrdNm = null;
		String fileKey = null;
		String sType = null;
		String sLevel = null;
		String sMrd = null;
		SendMtyRlseOrdVO[] sendMtyRlseOrdVOs = null;
		DblWblVO[] dblWblVOs = null;
		BkgBlNoVO bkgBlNoVO = null;
		BkgBlNoVO[] bkgBlNoVOs = null;
		String[] ntcKndCd = null;
		String[] eml= null;
		String[] rmk = null;
		String[] splitStr = null;
		BkgRouteVO bkgRouteVO = null;
		BkgEmlEdtVO bkgEmlEdtVO = null;
		BkgHrdCdgCtntVO paramVO = null;
		ExcelParser ep = null;
		Workbook wb = null;
		Sheet sheet1 = null;
		Sheet sheet2 = null;
		Sheet sheet3 = null;
		Sheet sheet4 = null;
		Cell cell = null;
		List<Cell> cells = null;
		ByteArrayOutputStream excelContent = null;
		int idx=0,x=0,y=0,add=0;
		boolean isRight = false;
		
		try {
			begin();
			command  = new GeneralBookingSearchBCImpl();
			emptyRlsBC = new EmptyReleaseOrderBCImpl();
			bLIssuanceBC = new BLIssuanceBCImpl();
			bkgHisCmd = new BookingHistoryMgtBCImpl();
			paramVO = new BkgHrdCdgCtntVO();
			utilBC = new BookingUtil();
			event.getBkgBlNoVO().setCaUsrId(account.getUsr_id());
			bkgBlNoVO = utilBC.searchBkgBlNoVO(event.getBkgBlNoVO());
			bkgBlNoVOs = event.getBkgBlNoVOs();
			ntcKndCd = event.getNtcKndCd();
			bkgEmlEdtVO = event.getBkgEmlEdtVO();
			bkgEmlEdtVO.setFileKey(event.getFileKey());
			eml= event.getEml();
			rmk = event.getRemark();
			sType = sLevel = sMrd = "";
			for (int i=0; i<bkgBlNoVOs.length; i++) {
				bkgBlNoVOs[i].setBkgNo(bkgBlNoVO.getBkgNo());
				bkgBlNoVOs[i].setBlNo(bkgBlNoVO.getBlNo());
				sbParam = new StringBuilder();
				/*
				BK : Booking Receipt
				CN : Empty Release Order
				BL : Draft B/L
				WB : Waybill
				SN : 
				HI : 
				HO : 
				SS : Simple S/I
				RR : Revised Rate
				SB : Standby Notice
				*/
				if ("BK".equalsIgnoreCase(ntcKndCd[i])) {
					if("Y".equals(utilBC.searchNoRateBlockFlg(bkgBlNoVO))){
						throw new EventException(new ErrorHandler("BKG08333",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
					}
					if("Y".equals(utilBC.searchStandbyBlockFlg(bkgBlNoVO))){
						throw new EventException(new ErrorHandler("BKG08284",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
					}
					mrdNm = "Normal".equalsIgnoreCase(event.getReceiveType())?"ESM_BKG_5005G":"ESM_BKG_5005C";
					String [] cct = new String[event.getEml().length];
					String [] docCct = new String[event.getEml().length];
					for(int j=0;j<cct.length;j++){
						cct[j]="";
						docCct[j]="";
					}
					BkgReceiptSendVO bkgReceiptSendVO = new BkgReceiptSendVO();
					bkgReceiptSendVO.setBkgBlNoVos(bkgBlNoVOs);
					bkgReceiptSendVO.setEmlAddrs(eml);
					bkgReceiptSendVO.setRemarks(rmk);
					bkgReceiptSendVO.setMrdNm(mrdNm);
					bkgReceiptSendVO.setCcts(cct);
					bkgReceiptSendVO.setDocCcts(docCct);
					if (null!=bkgEmlEdtVO && !"".equals(bkgEmlEdtVO.getEdtToEml())) {
						bkgReceiptSendVO.setBkgEmlEdtVo(bkgEmlEdtVO);
						bkgNtcHisVOs = command.sendBkgReceiptByGroupEmail(bkgReceiptSendVO,event.getFileKey(), account);
					} else {
						bkgNtcHisVOs = command.sendBkgReceiptByEmail(bkgReceiptSendVO,event.getFileKey(), account);
					}
				} else if ("CN".equalsIgnoreCase(ntcKndCd[i])) { 
					if("Y".equals(utilBC.searchNoRateBlockFlg(bkgBlNoVO))){
						throw new EventException(new ErrorHandler("BKG08335",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
					}
					if("Y".equals(utilBC.searchStandbyBlockFlg(bkgBlNoVO))){
						throw new EventException(new ErrorHandler("BKG08336",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
					}
					sbParam.append("/rv");
					sbParam.append(" bkg_no[('").append(bkgBlNoVOs[i].getBkgNo()).append("')]");
					sbParam.append(" remark[").append(rmk[i]).append("@@ ]");
					sbParam.append(" usr_id[").append(account.getUsr_id()).append("]");
					sbParam.append(" type[detail]");
					sbParam.append(" isEncode[Y]");
					sendMtyRlseOrdVOs = new SendMtyRlseOrdVO[1];
					sendMtyRlseOrdVOs[0] = new SendMtyRlseOrdVO();
					sendMtyRlseOrdVOs[0].setDiffRmk("");
					sendMtyRlseOrdVOs[0].setBkgNo(bkgBlNoVOs[i].getBkgNo());
					sendMtyRlseOrdVOs[0].setNtcEml(eml[i]);
					sendMtyRlseOrdVOs[0].setTmplParam(sbParam.toString());
					bkgNtcHisVOs = emptyRlsBC.sendMtyRlseOrdByEmail(sendMtyRlseOrdVOs, bkgEmlEdtVO, account);
				} else if ("BL".equalsIgnoreCase(ntcKndCd[i]) || "WB".equalsIgnoreCase(ntcKndCd[i]) || "NN".equalsIgnoreCase(ntcKndCd[i])) {
					bkgRouteVO = utilBC.searchBkgRoute(bkgBlNoVOs[i].getBkgNo());
					if ("BL".equalsIgnoreCase(ntcKndCd[i])) {
						if("Y".equals(utilBC.searchNoRateBlockFlg(bkgBlNoVO))){ 
							throw new EventException(new ErrorHandler("BKG08334",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
						}
						if("Y".equals(utilBC.searchStandbyBlockFlg(bkgBlNoVO))){ 
							throw new EventException(new ErrorHandler("BKG08337",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
						}
						sType="2";
						sMrd="ESM_BKG_0109_DBL.mrd";
//						isDraftBL = true;
					} else if ("WB".equalsIgnoreCase(ntcKndCd[i])) {
						sType="5";
						if (0==bkgRouteVO.getPorCd().indexOf("US")) {
							sMrd="ESM_BKG_0109_OBL_LETTER.mrd";
						} else {
							sMrd="ESM_BKG_0109_OBL_A4.mrd";
						}
					} else if ("NN".equalsIgnoreCase(ntcKndCd[i])) {
						sType="2";
						if (0==bkgRouteVO.getPorCd().indexOf("US")) {
							sMrd="ESM_BKG_0109_OBL_LETTER.mrd";
						} else {
							sMrd="ESM_BKG_0109_OBL_A4.mrd";
						}
					}
					if ("ALL".equalsIgnoreCase(event.getFrtTerm()[i])) {
						sLevel="1";
					} else if ("C".equalsIgnoreCase(event.getFrtTerm()[i])) {
						sLevel="5";
					} else if ("P".equalsIgnoreCase(event.getFrtTerm()[i])) {
						sLevel="4";
					} else if ("N".equalsIgnoreCase(event.getFrtTerm()[i])) {
						sLevel="6";
					} else if ("A".equalsIgnoreCase(event.getFrtTerm()[i])) {
						sLevel="3";
					} else {
						sLevel="1";
					}
					String hiddenData = "N";
					if("1".equals(event.getFrtCltFlg()[i])){
						hiddenData = "Y";
					}
					sbParam.append("/rv");
					sbParam.append(" form_bkgNo[('").append(bkgBlNoVOs[i].getBkgNo()).append("')]");
					sbParam.append(" form_type[").append(sType).append("]");
					sbParam.append(" form_dataOnly[N]");
					sbParam.append(" form_manifest[N]");
					sbParam.append(" form_usrId[").append(account.getUsr_id()).append("]");
					sbParam.append(" form_hiddeData[").append(hiddenData).append("]");
					sbParam.append(" form_level[(").append(sLevel).append(")]");
					sbParam.append(" form_remark[").append(rmk[i]).append("]");
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
					dblWblVOs[0].setBkgNo(bkgBlNoVO.getBkgNo());
					dblWblVOs[0].setBlNo(bkgBlNoVO.getBlNo());
					dblWblVOs[0].setSyscd("BKG");
					dblWblVOs[0].setTmplmrd(sMrd);
					dblWblVOs[0].setBatchflg("N");
					dblWblVOs[0].setTmplparam(sbParam.toString());
					dblWblVOs[0].setRcveml(event.getEml()[i]);
					dblWblVOs[0].setTmplmrdpdf("Original.pdf");
					dblWblVOs[0].setItr("|$$|");
					dblWblVOs[0].setNtcKndCd(event.getNtcKndCd()[i]);
					dblWblVOs[0].setHiddOpt("1".equalsIgnoreCase(event.getFrtCltFlg()[i])?"Y":"N");
					dblWblVOs[0].setFrtAllFlg("1".equalsIgnoreCase(sLevel)?"Y":"N");
					dblWblVOs[0].setFrtCltFlg("5".equalsIgnoreCase(sLevel)?"Y":"N");
					dblWblVOs[0].setFrtPpdFlg("4".equalsIgnoreCase(sLevel)?"Y":"N");
					dblWblVOs[0].setFrtChgFlg("6".equalsIgnoreCase(sLevel)?"Y":"N");
					dblWblVOs[0].setFrtArrFlg("3".equalsIgnoreCase(sLevel)?"Y":"N");
					bkgNtcHisVOs = bLIssuanceBC.sendDblWblByEmail(dblWblVOs, bkgEmlEdtVO, account);
				} else if ("SN".equalsIgnoreCase(ntcKndCd[i]) || "HI".equalsIgnoreCase(ntcKndCd[i]) || "HO".equalsIgnoreCase(ntcKndCd[i])) {
					if ("SN".equalsIgnoreCase(ntcKndCd[i])) {
						mrdNm = "ESM_BKG_0866";		
						sbParam.append("/rp [").append(bkgBlNoVO.getBkgNo()).append("] [Y]");
					} else if ("HI".equalsIgnoreCase(ntcKndCd[i])) {
						mrdNm = "ESM_BKG_5021";		
						sbParam.append("/rv BKG_NO['").append(bkgBlNoVO.getBkgNo()).append("'] IO_BND_CD['I'] CMDT[''] RECEIVER[''] OTHER[''] CUST_NTC_IS[N] CUST_NTC[] SLCT_CNTR['']");	
					} else if ("HO".equalsIgnoreCase(ntcKndCd[i])) {
						mrdNm = "ESM_BKG_5021";		
						sbParam.append("/rv BKG_NO['").append(bkgBlNoVO.getBkgNo()).append("'] IO_BND_CD['O'] CMDT[''] RECEIVER[''] OTHER[''] CUST_NTC_IS[N] CUST_NTC[] SLCT_CNTR['']");	
					}
					bkgNtcHisVOs = command.sendBkgNoticeByEmail(mrdNm, ntcKndCd[i], eml[i], sbParam.toString(), bkgBlNoVOs[i], bkgEmlEdtVO, account);
				// Simple SI 추가 개발 - 2012.07 jay
				} else if ("SS".equalsIgnoreCase(ntcKndCd[i])) {
					// 템플릿 엑셀파일 읽어오기
					ep = new ExcelParser("HJS_Simple_SI_Format.xls","xls");
					wb = ep.getTempData(2003);
					sheet1 = wb.getSheetAt(0);  //EDI_MAIN
					sheet2 = wb.getSheetAt(1);  //Description(additional)
					sheet3 = wb.getSheetAt(2);  //HBL
					sheet4 = wb.getSheetAt(3);  //code(hidden)
					if (null!=wb) {
						wb.setMissingCellPolicy(Row.CREATE_NULL_AS_BLANK);//RETURN_NULL_AND_BLANK);//.RETURN_BLANK_AS_NULL);//.CREATE_NULL_AS_BLANK);
//						rqstNoVo = new XterRqstNoVO();
						paramVO.setAttrCtnt10("EDI_MAIN");
						simSiList = command.searchSimpleSiBkgInfoList(bkgBlNoVO.getBkgNo());
						simSiCntrList = command.searchSimpleSiCntrInfoList(bkgBlNoVO.getBkgNo());
						ssHblCntrList = command.searchSimpleSiHblCntrInfoList(bkgBlNoVO.getBkgNo());
						
						for (BkgHrdCdgCtntVO vo : simSiList) {
							cells = findCellsByName(wb,vo.getAttrCtnt1());
							log.debug("\n vo.getAttrCtnt1():"+vo.getAttrCtnt1());
							
							idx = 0;
							
							if (null!=cells) {
								if(1<cells.size()){
									splitStr = vo.getAttrCtnt2().split("\\|");
									for (Cell temp : cells) {
										LOOP_LONG_STRING:
											if (splitStr.length!=idx){
												temp.setCellValue(splitStr[idx]);
												idx+=1;
											} else {
												break LOOP_LONG_STRING;
											}
									}
									if(splitStr.length>16){
										for(int j=0;j<splitStr.length-16;j++){
											cell = sheet2.getRow(j+1).getCell(arrName[0].equalsIgnoreCase(vo.getAttrCtnt1().substring(11)) ? 0:1);
											cell.setCellValue(splitStr[idx]);
											idx+=1;
										}
									}
								} else {
									cell = cells.get(0);
									cell.setCellValue(vo.getAttrCtnt2());
								} 
							}
							
						}
						
						// Booking Main Container Info.
						if(null!=simSiCntrList && simSiCntrList.size()>0){
							cells = findCellsByName(wb,arrName[1]);
							cell = cells.get(0);
							x = cell.getRowIndex();
							y = cell.getColumnIndex();
							
							for (BkgHrdCdgCtntVO cntrVo : simSiCntrList) {
								add = isRight ? 4 : 3;
								splitStr = cntrVo.getAttrCtnt2().split("\\|");
								sheet1.getRow(x).getCell(y).setCellValue(splitStr[0]);
								sheet1.getRow(x+1).getCell(y).setCellValue(splitStr[1]);
								sheet1.getRow(x+2).getCell(y).setCellValue(splitStr[2]);
								sheet1.getRow(x+3).getCell(y).setCellValue(splitStr[3]);
								sheet1.getRow(x+4).getCell(y).setCellValue(splitStr[4]);
								sheet1.getRow(x+4).getCell(y+add).setCellValue(splitStr[5]);
								sheet1.getRow(x+5).getCell(y).setCellValue(splitStr[6]);
								sheet1.getRow(x+5).getCell(y+add).setCellValue(splitStr[7]);
								sheet1.getRow(x+6).getCell(y).setCellValue(splitStr[8]);
								sheet1.getRow(x+6).getCell(y+add).setCellValue(splitStr[9]);
								
								//다음좌표설정
								x = isRight ? (x+7) : x;
								y = isRight ? (y-6) : (y+6);
								isRight = !isRight;
							}
						}
						// House BL Container Info.
						if(null!=ssHblCntrList && ssHblCntrList.size()>0){
							cells = findCellsByName(wb,arrName[2]);
							cell = cells.get(0);
							x = cell.getRowIndex();
							y = cell.getColumnIndex();
							isRight = false;
							
							for (BkgHrdCdgCtntVO hcntrVo : ssHblCntrList) {
								splitStr = hcntrVo.getAttrCtnt2().split("\\|");
								sheet3.getRow(x).getCell(y).setCellValue(splitStr[0]);
								sheet3.getRow(x+1).getCell(y).setCellValue(splitStr[1]);
								sheet3.getRow(x+2).getCell(y).setCellValue(splitStr[2]);
								sheet3.getRow(x+3).getCell(y).setCellValue(splitStr[3]);
								sheet3.getRow(x+4).getCell(y).setCellValue(splitStr[4]);
								sheet3.getRow(x+4).getCell(y+1).setCellValue(splitStr[5]);
								sheet3.getRow(x+5).getCell(y).setCellValue(splitStr[6]);
								sheet3.getRow(x+5).getCell(y+1).setCellValue(splitStr[7]);
								sheet3.getRow(x+6).getCell(y).setCellValue(splitStr[8]);
								sheet3.getRow(x+6).getCell(y+1).setCellValue(splitStr[9]);
								
								//다음좌표설정
								x = isRight ? (x+7) : x;
								y = isRight ? (y-4) : (y+4);
								isRight = !isRight;
							}
						}
						// Excel Formula Re-calculation
						FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
						for(Row r : sheet4) {
							for(Cell c : r) {
								if(c.getCellType() == Cell.CELL_TYPE_FORMULA) {
									evaluator.evaluateFormulaCell(c);
								}
							}
						}
						// 첨부파일 업로드 및 파일키 생성
						excelContent = new ByteArrayOutputStream();	
						wb.write(excelContent);
						excelContent.close();
						byte[] bytes = excelContent.toByteArray();
						if(bytes != null) {
							FileUpload fileUpload = new FileUpload();
							fileKey = fileUpload.doUpload(bytes, "SMLM"+bkgBlNoVO.getBlNo()+".xls", "EML");
						}
						
					}	
					
					bkgNtcHisVOs = command.sendBkgSimpleSiByEmail(fileKey, ntcKndCd[i], eml[i], bkgBlNoVOs[i], bkgEmlEdtVO, account);
					UpdateFileMetaInfo.deleteFile(fileKey);
				} else if ("RR".equalsIgnoreCase(ntcKndCd[i])) { // Revised Rate 추가 개발 - 2013.01 wonjoo
					sType="2";
					mrdNm="ESM_BKG_0109_DBL";
					
					
					
					if ("ALL".equalsIgnoreCase(event.getFrtTerm()[i])) {
						sLevel="1";
					} else if ("C".equalsIgnoreCase(event.getFrtTerm()[i])) {
						sLevel="5";
					} else if ("P".equalsIgnoreCase(event.getFrtTerm()[i])) {
						sLevel="4";
					} else if ("N".equalsIgnoreCase(event.getFrtTerm()[i])) {
						sLevel="6";
					} else if ("A".equalsIgnoreCase(event.getFrtTerm()[i])) {
						sLevel="3";
					} else {
						sLevel="1";
					}
					String hiddenData = "N";
					if("1".equals(event.getFrtCltFlg()[i])){
						hiddenData = "Y";
					}
					sbParam.append("/rv");
					sbParam.append(" form_bkgNo[('").append(bkgBlNoVOs[i].getBkgNo()).append("')]");
					sbParam.append(" form_type[").append(sType).append("]");
					sbParam.append(" form_dataOnly[N]");
					sbParam.append(" form_manifest[N]");
					sbParam.append(" form_usrId[").append(account.getUsr_id()).append("]");
					sbParam.append(" form_hiddeData[").append(hiddenData).append("]");
					sbParam.append(" form_level[(").append(sLevel).append(")]");
					sbParam.append(" form_remark[").append(rmk[i]).append("]");
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
					dblWblVOs[0].setBkgNo(bkgBlNoVO.getBkgNo());
					dblWblVOs[0].setBlNo(bkgBlNoVO.getBlNo());
					dblWblVOs[0].setSyscd("BKG");
					dblWblVOs[0].setTmplmrd(mrdNm);
					dblWblVOs[0].setBatchflg("N");
					dblWblVOs[0].setTmplparam(sbParam.toString());
					dblWblVOs[0].setRcveml(event.getEml()[i]);
					dblWblVOs[0].setTmplmrdpdf("Original.pdf");
					dblWblVOs[0].setItr("|$$|");
					dblWblVOs[0].setNtcKndCd(event.getNtcKndCd()[i]);
					dblWblVOs[0].setHiddOpt("1".equalsIgnoreCase(event.getFrtCltFlg()[i])?"Y":"N");
					dblWblVOs[0].setFrtAllFlg("1".equalsIgnoreCase(sLevel)?"Y":"N");
					dblWblVOs[0].setFrtCltFlg("5".equalsIgnoreCase(sLevel)?"Y":"N");
					dblWblVOs[0].setFrtPpdFlg("4".equalsIgnoreCase(sLevel)?"Y":"N");
					dblWblVOs[0].setFrtChgFlg("6".equalsIgnoreCase(sLevel)?"Y":"N");
					dblWblVOs[0].setFrtArrFlg("3".equalsIgnoreCase(sLevel)?"Y":"N");
					
					
					//     bkgNtcHisVOs = bLIssuanceBC.sendDblWblByEmail(dblWblVOs, bkgEmlEdtVO, account);

					
					bkgNtcHisVOs = command.sendBkgRevisedRateByEmail(mrdNm, ntcKndCd[i], eml[i], sbParam.toString(), bkgBlNoVOs[i], bkgEmlEdtVO, account);
				} else if ("UR".equalsIgnoreCase(ntcKndCd[i]) || "DR".equalsIgnoreCase(ntcKndCd[i])) {
					dblWblVOs = new DblWblVO[1];
					dblWblVOs[0] = new DblWblVO();
					dblWblVOs[0].setBkgNo(bkgBlNoVO.getBkgNo());
					dblWblVOs[0].setBlNo(bkgBlNoVO.getBlNo());
					dblWblVOs[0].setSyscd("BKG");
					dblWblVOs[0].setBatchflg("N");
					dblWblVOs[0].setRcveml(event.getEml()[i]);
					dblWblVOs[0].setNtcKndCd(event.getNtcKndCd()[i]);
					bkgNtcHisVOs = bLIssuanceBC.sendRmdEmail(dblWblVOs, bkgEmlEdtVO, account); 
				}
			}
			bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
			commit();
			
			/**
		    * BPM 연동 처리 부분 ( BPM POC 이후 삭제 필요 )
		    */
//			if (isDraftBL == true &&event.getDpcsSrKndCd().equalsIgnoreCase("F") &&  !event.getDpcsSrNo().equals("")){
//				BookingInterfaceMgtBC bpmBc = new BookingInterfaceMgtBCImpl();
//				String eventKey = bkgBlNoVO.getBkgNo() + "_" +event.getDpcsSrNo();
//				bpmBc.bpmExecCall("BL",eventKey,account.getUsr_id());
//			}
			eventResponse.setETCData("SuccessYn", "Y");
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
	 * findCellsByName : 엑셀에서 이름으로 셀객체를 찾는다.
	 * 
	 * @param Workbook wb
	 * @param String name
	 * @return List<Cell>
	 * @throws Exception
	 */
	private List<Cell> findCellsByName(Workbook wb,String name) throws Exception {
		Name oname = null;
		List<Cell> cells = null;
		CellReference[] crs = null;
		AreaReference ar = null;
		try {
			oname = wb.getName(name);
			//엑셀 내용 볼때 ---------------------------------
//			ExcelExtractor excelExtractor = new ExcelExtractor((HSSFWorkbook) wb);
//			excelExtractor.setFormulasNotResults(true);
//			excelExtractor.setIncludeSheetNames(false);
//			log.debug("\n\n name: "+excelExtractor.getText());
			//---------------------------------
			if (null!=oname && null!=oname.getRefersToFormula() && 0>"REF!".indexOf(oname.getRefersToFormula())) {
				if (!oname.isDeleted()) {
					ar = new AreaReference(oname.getRefersToFormula());
					if (null!=ar) {
						crs = ar.getAllReferencedCells();
						if (null!=crs && 0<crs.length) {
							cells = new ArrayList<Cell>(crs.length);
							for (CellReference cr : crs) {
								cells.add(wb.getSheet(cr.getSheetName()).getRow(cr.getRow()).getCell(cr.getCol()));
							}
						}
					}
				}
			}
		} catch (FormulaParseException fpe) {
			throw new Exception(fpe);
		} catch (Exception e) {
			throw e;
		}
		return cells;
	}
	
 	/**
 	 * ESM_BKG_0079_02 : notice <br>
	 * Tro RD를 Fax전송하거나 EMAIL로 발송한다<br>
	 *
	 * @author  Lee NamKyung
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception EventException
	 */
	private EventResponse sendTroNotice(Event e) throws EventException {
		try {
			begin();
			
			EsmBkg007902cEvent event = (EsmBkg007902cEvent)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			GeneralBookingSearchBC command   = new GeneralBookingSearchBCImpl();
			BookingHistoryMgtBC    bkgHisCmd = new BookingHistoryMgtBCImpl();
			
			BkgBlNoVO bkgBlNoVO = event.getBkgBlNoVO();
			String    boundCd   = JSPUtil.getNullNoTrim(event.getBoundCd());
			String    faxNo     = JSPUtil.getNullNoTrim(event.getFaxNo());
			String    eml       = JSPUtil.getNullNoTrim(event.getEml());
			String    cmdt      = JSPUtil.getNullNoTrim(event.getCmdt());
			String    receiver  = JSPUtil.getNullNoTrim(event.getReceiver());
			String    other     = JSPUtil.getNullNoTrim(event.getOther());
			String    cust_ntc  = JSPUtil.getNullNoTrim(event.getCustNtc());
			String    slct_cntr = JSPUtil.getNullNoTrim(event.getSlctCntr());
			if(cust_ntc != null && !cust_ntc.equals("")){
				cust_ntc = cust_ntc.replace("[", "").replace("]", "");
			}else{
				cust_ntc = "";
			}
			
			String strEml   = "N";
			String strFax   = "N";
			String param    = "";
//			String param    = "/rv BKG_NO['"+bkgBlNoVO.getBkgNo()+"'] IO_BND_CD['"+boundCd+"']";
			StringBuffer paramBuffer = new StringBuffer("/rv BKG_NO['").append(bkgBlNoVO.getBkgNo()).append("'] IO_BND_CD['").append(boundCd).append("']");
			if("I".equals(boundCd)){
//				param = param + " CMDT['"     + cmdt     + "']"
//							  + " RECEIVER['" + receiver + "']"
//							  + " OTHER['"    + other    + "']"
//							  + " CUST_NTC["  + cust_ntc + "]"
//							  + " CUST_NTC_IS[Y]"
//							  + " SLCT_CNTR[" + slct_cntr+ "]";
				paramBuffer.append(" CMDT['").append(cmdt).append("']");
				paramBuffer.append(" RECEIVER['").append(receiver).append("']");
				paramBuffer.append(" OTHER['").append(other).append("']");
				paramBuffer.append(" CUST_NTC[").append(cust_ntc).append("]");
				paramBuffer.append(" CUST_NTC_IS[Y]");
				paramBuffer.append(" SLCT_CNTR[").append(slct_cntr).append("]");
			} else {
//				param = param + " CMDT['']"
//							  + " RECEIVER['']"
//							  + " OTHER['']"
//							  + " CUST_NTC[]"
//							  + " CUST_NTC_IS[N]"
//							  + " SLCT_CNTR[]";			
				paramBuffer.append(" CMDT['']");
				paramBuffer.append(" RECEIVER['']");
				paramBuffer.append(" OTHER['']");
				paramBuffer.append(" CUST_NTC[]");
				paramBuffer.append(" CUST_NTC_IS[N]");
				paramBuffer.append(" SLCT_CNTR[]");
			}
			param = paramBuffer.toString();
			String mrdNm    = "ESM_BKG_5021";
			String ntcKndCd = "H"+boundCd;
log.error("\nTRO Notice param:"+param);

			if (!"".equals(eml)) {
				List<BkgNtcHisVO> bkgNtcHisVOs = command.sendBkgNoticeByEmail(mrdNm, ntcKndCd, eml, param, bkgBlNoVO, null, account);
				bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0079_02C");
				eventResponse.setETCData("SuccessYn", "YM");
				strEml = "Y";
			}
			if (!"".equals(faxNo)) {
				List<BkgNtcHisVO> bkgNtcHisVOs = command.sendBkgNoticeByFax(mrdNm, ntcKndCd, faxNo, param, bkgBlNoVO, account);
				bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0079_02C");
				eventResponse.setETCData("SuccessYn", "YF");
				strFax = "Y";
			}
			
			commit();			
			if ("Y".equals(strEml) && "Y".equals(strFax)) {
				eventResponse.setETCData("SuccessYn", "Y");
			}
			
			return eventResponse;
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
 	/**
	 * MQ 연동 처리<br>
	 * UBIZHJS_ALPSBKG_USTMNL_ACK IBM MQ를 통한 입력처리<br>
	 *
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception EventException
	 */
	private EventResponse receiptUsaTmlEdiAck(Event e) throws EventException {
		try {
			begin();
			EsmBkgUsaTmlEdiAckEvent event = (EsmBkgUsaTmlEdiAckEvent)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			BookingHistoryMgtBC command = new BookingHistoryMgtBCImpl();

			command.receiptUsaTmlEdiAck(event.getRcvMsg());
			commit();
			return eventResponse;
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}

	/**
	 * booking creation, booking update, split, combine, customer update시 실행됨<br>
	 * COA에 재계산을 해야함을 update함<br>
	 *
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param       String remark
	 * @param       SignOnUserAccount account
	 * @return 		void
	 * @exception 	EventException
	 */
	private void interfaceToMas(BkgBlNoVO bkgBlNoVO, String remark, SignOnUserAccount account)throws EventException{
		com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBC masBc  = new com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBCImpl();
		try {
			MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
			masBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
			masBkgComIfVo.setCostSrcSysCd("BKG");
			masBkgComIfVo.setIfRmk(remark);
			masBkgComIfVo.setCreUsrId(account.getUsr_id());
			masBkgComIfVo.setUpdUsrId(account.getUsr_id());
			
			masBc.modifyMasCommonInterface(masBkgComIfVo);
		} catch(EventException ex) {
			log.error("TO COA error bkg no : " + bkgBlNoVO.getBkgNo());
			throw ex;
		} catch(Exception ex) { 
			log.error("TO COA error bkg no : " + bkgBlNoVO.getBkgNo());
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
   
   /**
    * booking creation, booking update, split, combine, customer update시 실행됨<br>
	* INV에 booking data를 interface한다<br>
	*
	* @param 		BkgBlNoVO bkgBlNoVO, SignOnUserAccount account
	* @return 		void
	* @exception 	EventException
	*/
	private void interfaceToInv(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account)throws EventException{
		BookingARCreationBC invBc = new BookingARCreationBCImpl();		
		try{
			ARBkgInterfaceCreationVO bkgIfVo = new ARBkgInterfaceCreationVO();
			bkgIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
			bkgIfVo.setBkgCorrNo(bkgBlNoVO.getCaNo());
			bkgIfVo.setUserId(account.getUsr_id());
			bkgIfVo.setManDivInd("B");
				
			invBc.interfaceBKGARInvoiceToINV(bkgIfVo);
		} catch(EventException ex) {
			log.error("TO INV error bkg no : " + bkgBlNoVO.getBkgNo());
			throw ex;
		} catch(Exception ex) {
			log.error("TO INV error bkg no : " + bkgBlNoVO.getBkgNo()); 
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}

	/**
	 * ESM_BKG_0096 : Open <br>
	 * edi 전송시 type/size별 yard 구분을 위해 기초 정보를 조회함<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchYardAssign(Event e) throws EventException{
		try{
			EsmBkg0096Event event = (EsmBkg0096Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			PSAManifestBC psaBC = new PSAManifestBCImpl();
						
			PsaBkgIfVO psaBkgIfVO = new PsaBkgIfVO();
			psaBkgIfVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
			psaBkgIfVO.setUsrId(account.getUsr_id());
			PsaBkgIfVO[] rtnPsaBkgIfVOs = psaBC.searchPSAIFInfo(psaBkgIfVO);
			
			if (rtnPsaBkgIfVOs!=null && rtnPsaBkgIfVOs.length > 0) {
				eventResponse.setETCData("bkg_no",	JSPUtil.getNull(rtnPsaBkgIfVOs[0].getBkgNo())	  );
				eventResponse.setETCData("bkg_qty",	JSPUtil.getNull(rtnPsaBkgIfVOs[0].getMainBkgQty()));
				eventResponse.setETCData("yd_cd",	JSPUtil.getNull(rtnPsaBkgIfVOs[0].getYdCd())	  );
				if (rtnPsaBkgIfVOs[0].getBkgSeq()!=null && rtnPsaBkgIfVOs[0].getBkgSeq().length() > 0) 
					eventResponse.setRsVoList(Arrays.asList(rtnPsaBkgIfVOs));
			}else {
				throw new EventException(new ErrorHandler("BKG00095").getMessage());
			}
			
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
   
   /**
	* ESM_BKG_0096 : SAVE 버튼 클릭<br>
    * 입력한 yard가 mdm_yard에 있는지 확인한다.<br>
    * 
    * @param Event e
	* @return EventResponse
    * @exception EventException
    */
   private EventResponse validateYardAssign(Event e) throws EventException{
	   try{
		   EsmBkg0096Event event = (EsmBkg0096Event)e;
		   GeneralEventResponse eventResponse = new GeneralEventResponse();
		   
		   GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		   
		   command.validateYardAssign(event.getYardAssignVO().getQtyInfoVOs());
		   
		   // 변경 데이터 처리
		   if (event.getYardAssignVO().getQtyInfoVOs()!=null) {
			   
			   begin();
			   // PSA BC 선언
			   PSAManifestBC command2 = new PSAManifestBCImpl();
			   
			   // 화면에서 넘어온 데이터
			   QtyInfoVO[] qtyInfoVOs = event.getYardAssignVO().getQtyInfoVOs();
			   
			   PsaYardCdVO[] psaYardCdVOs = new PsaYardCdVO[qtyInfoVOs.length];
			   // PSA 쪽에 전달하기 위해 재구성
			   for(int i=0; i < psaYardCdVOs.length; i++) {
				   psaYardCdVOs[i] = new PsaYardCdVO();				   
				   ObjectCloner.build(qtyInfoVOs[i], psaYardCdVOs[i]);
				   psaYardCdVOs[i].setUsrId(account.getUsr_id());
			   }
			   
			   // BC 에 작업 요청
			   command2.managePsaYardCode(psaYardCdVOs);
			   
			   // psa I/f 대상 자동 전송부분 추가함. ( 하동일수석과 협의후 작업 - YardAssign 저장시 EDI 전송 오류에 오류 메세지 나타나도록 함. )
			   // 2010.09.06
				BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
				List<BkgNtcHisVO> bkgNtcHisVOs = null;
				
				PSAManifestBC psaBC = new PSAManifestBCImpl();
				PsaBkgVO[] psaBkgVOs = new PsaBkgVO[1];
				psaBkgVOs[0] = new PsaBkgVO();
				psaBkgVOs[0].setBkgNo(psaYardCdVOs[0].getBkgNo());
				psaBkgVOs[0].setSndUsrId(account.getUsr_id());
				psaBkgVOs[0].setQtyModifyFlag("N");
				psaBC.managePSABKG(psaBkgVOs);

				bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();	
				BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
				bkgNtcHisVO.setBkgNo(psaYardCdVOs[0].getBkgNo());
				bkgNtcHisVO.setNtcViaCd("E");
				bkgNtcHisVO.setNtcKndCd("PS");
				bkgNtcHisVO.setEdiId("PSACBI");
				bkgNtcHisVO.setEsvcGrpCd("");
				bkgNtcHisVO.setBkgNtcSndRsltCd("A");
				bkgNtcHisVO.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO.setUpdUsrId(account.getUsr_id());									
				bkgNtcHisVOs.add(bkgNtcHisVO);
				
				//2015.11.18 [CHM-201538758] PSA 로 Booking EDI (CBINFO)가 전송될 시, SGSINAO, SGSINAC 에서의 MT Release 를 위해 동일 Booking 정보를 SGSINAO, SGSINAC 로 추가 전송 함.
				String bkgMtyPkupYdCd = psaBC.searchBkgMtyPkupYdCdForPsa(psaYardCdVOs[0].getBkgNo());
				if (bkgMtyPkupYdCd != null && bkgMtyPkupYdCd.length()>0){
					BkgNtcHisVO bkgNtcHisVO2 = new BkgNtcHisVO();
					bkgNtcHisVO2.setBkgNo(psaYardCdVOs[0].getBkgNo());
					bkgNtcHisVO2.setNtcViaCd("E");
					bkgNtcHisVO2.setNtcKndCd("PS");
					bkgNtcHisVO2.setEdiId(bkgMtyPkupYdCd);
					bkgNtcHisVO2.setEsvcGrpCd("");
					bkgNtcHisVO2.setBkgNtcSndRsltCd("A");
					bkgNtcHisVO2.setSndUsrId(account.getUsr_id());
					bkgNtcHisVO2.setSndOfcCd(account.getOfc_cd());
					bkgNtcHisVO2.setCreUsrId(account.getUsr_id());
					bkgNtcHisVO2.setUpdUsrId(account.getUsr_id());									
					bkgNtcHisVOs.add(bkgNtcHisVO2);
				}
				
				if(bkgNtcHisVOs!=null){
					if(bkgNtcHisVOs.size()>0){
						bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0079");
					}
				}

			   commit();
			   
//			   this.managePSABKGAuto(psaYardCdVOs[0].getBkgNo(), "N");
		   }
		   
		   // 성공 메시지 셋팅
		   eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
		   
		   return eventResponse;
	   } catch(EventException se) {
		    rollback();
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	   
   }
   
   /**
	 * ESM_BKG_1069 : open <br>
	 * Route Detail 정보를 조회 <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRouteDetail(Event e) throws EventException {
       GeneralEventResponse eventResponse = new GeneralEventResponse();
       EsmBkg1069Event event = (EsmBkg1069Event) e;   
       
       GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
              
       try{      	       	
    	   RouteDtlVO routeDtlVo = command.searchRouteDetail(event.getBkgNo());

	   	   RouteDtlInfoVO routeDtlInfo = routeDtlVo.getRouteDtlInfo();       	
	       List<RouteDtlVvdVO> routeDtlVvd = routeDtlVo.getRouteDtlVvd();                           
	      
	       eventResponse.setETCData(routeDtlInfo.getColumnValues());   
	       eventResponse.setRsVoList(routeDtlVvd);                
          
       }catch(EventException ex){
           throw ex;
       }catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  
       }
       return eventResponse;
    }

	/**
	 * ESM_BKG_0079 : open <br>
	 * Booking Creation tab중 어떤 Tab을 보여줘야 하는지 조회한다.<br>
	 * 
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgCreTabByUser(Event e) throws EventException {
		//EsmBkg0079Event event = (EsmBkg0079Event)e;
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			String strTroTab = command.searchBkgCreTabByUser(account); 
			eventResponse.setETCData("tro_tab", JSPUtil.getNullNoTrim(strTroTab));
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}			

		return eventResponse;
	}

	/**
	 * ESM_BKG_00985 : EDI Transmit 버튼 클릭<br>
	 * booking의 각종 edi를 전송한다<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendBkgEdi(Event e) throws EventException{
		try{
			EsmBkg0095Event event = (EsmBkg0095Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
//			CLLCDLManifestBC cLLCDLManifestBC = new CLLCDLManifestBCImpl();
			BLIssuanceBC bLIssuanceBC = new BLIssuanceBCImpl();
			CLLCDLManifestBC cLLCDLManifestBC = new CLLCDLManifestBCImpl();
			BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
			GeneralBookingReceiptBC rcpCmd = new GeneralBookingReceiptBCImpl();
			EBookingReceiptBC eBookingReceiptBC = new EBookingReceiptBCImpl();
			BookingUtil utilBC = new BookingUtil();
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			begin();
			boolean isSend = false;
//			boolean isDraftBL = false;
			for(int i=0;i<event.getCustTpIdVOs().length;i++){
				log.debug("ntc knd cd:[" + event.getNtcKndCd()[i] + "], rcv_id :["+event.getCustTpIdVOs()[i].getRcvId()+"]");
				List<BkgNtcHisVO> bkgNtcHisVOs = null;
				if (event.getNtcKndCd()[i].equals("BK")){
					bkgNtcHisVOs=command.createCustBkgReceiptEdi(event.getBkgBlNoVO(), event.getCustTpIdVOs()[i], "N", account);
					if(bkgNtcHisVOs!=null){
						if(bkgNtcHisVOs.size()>0){
							bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
							isSend = true;
						}
					}
				}
				
				if(event.getNtcKndCd()[i].equals("PS")){ // psa I/f 대상
					PSAManifestBC psaBC = new PSAManifestBCImpl();
					PsaBkgVO[] psaBkgVOs = new PsaBkgVO[1];
					psaBkgVOs[0] = new PsaBkgVO();
					psaBkgVOs[0].setBkgNo(event.getBkgBlNoVO().getBkgNo());
					psaBkgVOs[0].setSndUsrId(account.getUsr_id());
					psaBC.managePSABKG(psaBkgVOs);

					bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();	
					BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
					bkgNtcHisVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
					bkgNtcHisVO.setNtcViaCd("E");
					bkgNtcHisVO.setNtcKndCd("PS");
					bkgNtcHisVO.setEdiId(event.getCustTpIdVOs()[i].getRcvId());
					bkgNtcHisVO.setEsvcGrpCd(event.getCustTpIdVOs()[i].getGroupId());
					bkgNtcHisVO.setBkgNtcSndRsltCd("A");
					bkgNtcHisVO.setSndUsrId(account.getUsr_id());
					bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
					bkgNtcHisVO.setCreUsrId(account.getUsr_id());
					bkgNtcHisVO.setUpdUsrId(account.getUsr_id());									
					bkgNtcHisVOs.add(bkgNtcHisVO);
					
					//2015.11.18 [CHM-201538758] PSA 로 Booking EDI (CBINFO)가 전송될 시, SGSINAO, SGSINAC 에서의 MT Release 를 위해 동일 Booking 정보를 SGSINAO, SGSINAC 로 추가 전송 함.
					String bkgMtyPkupYdCd = psaBC.searchBkgMtyPkupYdCdForPsa(event.getBkgBlNoVO().getBkgNo());
					if (bkgMtyPkupYdCd != null && bkgMtyPkupYdCd.length()>0){
						BkgNtcHisVO bkgNtcHisVO2 = new BkgNtcHisVO();
						bkgNtcHisVO2.setBkgNo(event.getBkgBlNoVO().getBkgNo());
						bkgNtcHisVO2.setNtcViaCd("E");
						bkgNtcHisVO2.setNtcKndCd("PS");
						bkgNtcHisVO2.setEdiId(bkgMtyPkupYdCd);
						bkgNtcHisVO2.setEsvcGrpCd("");
						bkgNtcHisVO2.setBkgNtcSndRsltCd("A");
						bkgNtcHisVO2.setSndUsrId(account.getUsr_id());
						bkgNtcHisVO2.setSndOfcCd(account.getOfc_cd());
						bkgNtcHisVO2.setCreUsrId(account.getUsr_id());
						bkgNtcHisVO2.setUpdUsrId(account.getUsr_id());									
						bkgNtcHisVOs.add(bkgNtcHisVO2);
					}
					
					if(bkgNtcHisVOs!=null){
						if(bkgNtcHisVOs.size()>0){
							bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
							isSend = true;
						}
					}
				}				
				if (event.getNtcKndCd()[i].equals("BT")||event.getNtcKndCd()[i].equals("CN")
					||event.getNtcKndCd()[i].equals("FC")){
					if(event.getCustTpIdVOs()[i].getRcvId()!=null&&event.getCustTpIdVOs()[i].getRcvId().length()>0){
						// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
						Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
						vender301ParamVO.setBkgBlNoVO(event.getBkgBlNoVO());
						vender301ParamVO.setOldVvdVOs(null);
						vender301ParamVO.setOldQtyVOs(null);
						vender301ParamVO.setOldMtyPkupYdCd(null);
						vender301ParamVO.setBracCd("U");
						vender301ParamVO.setEdiKind(event.getNtcKndCd()[i]);
						vender301ParamVO.setAutoManualFlg("N");
						vender301ParamVO.setRcvId(event.getCustTpIdVOs()[i].getRcvId());
						
						bkgNtcHisVOs=command.createTmlBkgReceiptEdi(vender301ParamVO, account);
						if(bkgNtcHisVOs!=null){
							if(bkgNtcHisVOs.size()>0){
								bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
								isSend = true;
							}
						}
					}
				}
				
				
				if (event.getNtcKndCd()[i].equals("VM")){
					if(event.getCustTpIdVOs()[i].getRcvId()!=null&&event.getCustTpIdVOs()[i].getRcvId().length()>0){
						bkgNtcHisVOs = eBookingReceiptBC.createTerminalVERMASEdi(event.getBkgBlNoVO(),event.getCustTpIdVOs()[i].getRcvId());
						if(bkgNtcHisVOs!=null){
							if(bkgNtcHisVOs.size()>0){
								bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
								isSend = true;
							}
						}
					}
				}
				
				if (event.getNtcKndCd()[i].equals("IM")){

					List<CntrListForImportDetailVO> cntrListForImportDetailVOs = cLLCDLManifestBC.searchCntrListForImport(event.getBkgBlNoVO().getBkgNo());
				
					CllCdlTransmitVO[] cllCdlTransmitVOs = new CllCdlTransmitVO[cntrListForImportDetailVOs.size()];
						
					for ( int j=0 ; j<cntrListForImportDetailVOs.size() ; j++ )
					{
						CntrListForImportDetailVO cntrListForImportDetailVO = cntrListForImportDetailVOs.get(j);
						CllCdlTransmitVO cllCdlTransmitVO = new CllCdlTransmitVO();
						cllCdlTransmitVO.setInListType("D");
						cllCdlTransmitVO.setInListType("D");
						cllCdlTransmitVO.setBkgNo(cntrListForImportDetailVO.getBkgNo());
						cllCdlTransmitVO.setCntrNo(cntrListForImportDetailVO.getCntrNo());
						cllCdlTransmitVO.setInEdiMsgFunc("ORIGINAL");
						cllCdlTransmitVO.setInPodCd(cntrListForImportDetailVO.getPodCd());
						cllCdlTransmitVO.setInVvdCd(cntrListForImportDetailVO.getVvdCd());
						cllCdlTransmitVO.setInRcvId(event.getCustTpIdVOs()[i].getRcvId());
						cllCdlTransmitVO.setInAreaId(cntrListForImportDetailVO.getAreaId());
						cllCdlTransmitVO.setInYdCd(event.getCustTpIdVOs()[i].getRefCode());
						cllCdlTransmitVO.setInSndId("");
						cllCdlTransmitVO.setInWhereGubun("BKG");
						
						cllCdlTransmitVOs[j] = cllCdlTransmitVO;
					}
					if ( cllCdlTransmitVOs.length > 0 )
					{
						cLLCDLManifestBC.transmitCllCdl(cllCdlTransmitVOs, account);
						isSend = true;
					}
				}
			
				if (event.getNtcKndCd()[i].equals("BO")){					
					bkgNtcHisVOs = eBookingReceiptBC.createBOKCONEdi(event.getBkgBlNoVO(), account);
					if(bkgNtcHisVOs!=null){
						if(bkgNtcHisVOs.size()>0){
							bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
							isSend = true;
						}
					}
					
//					eBookingReceiptBC.createBOKCONEdi(event.getBkgBlNoVO(), account);;
//
//					bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();	
//					BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
//					bkgNtcHisVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
//					bkgNtcHisVO.setNtcViaCd("E");
//					bkgNtcHisVO.setNtcKndCd("BO");
//					bkgNtcHisVO.setEdiId(event.getCustTpIdVOs()[i].getRcvId());
//					bkgNtcHisVO.setEsvcGrpCd(event.getCustTpIdVOs()[i].getGroupId());
//					bkgNtcHisVO.setBkgNtcSndRsltCd("A");
//					bkgNtcHisVO.setSndId("SYSTEM");
//					bkgNtcHisVO.setSndUsrId(account.getUsr_id());
//					bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
//					bkgNtcHisVO.setCreUsrId(account.getUsr_id());
//					bkgNtcHisVO.setUpdUsrId(account.getUsr_id());									
//					bkgNtcHisVOs.add(bkgNtcHisVO);
//					
//					if(bkgNtcHisVOs!=null){
//						if(bkgNtcHisVOs.size()>0){
//							bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
//							isSend = true;
//						}
//					}
				}
				
				if (event.getNtcKndCd()[i].equals("BL")){
					
					//No Rate 이면 DBL 발송 block // mds
					BkgBlNoVO bkgBlNoVO2 = new BkgBlNoVO(); 
					bkgBlNoVO2.setBkgNo(event.getBkgBlNoVO().getBkgNo());
					if("Y".equals(utilBC.searchNoRateBlockFlg(bkgBlNoVO2))){
						throw new EventException(new ErrorHandler("BKG08334",new String[]{bkgBlNoVO2.getBkgNo()}).getMessage());
					}
					
//					isDraftBL = true;
					CustTpIdVO custTpVO2 = event.getCustTpIdVOs()[i];
					
					DblEdiInVO dblEdiInVO = new DblEdiInVO();
					dblEdiInVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
					dblEdiInVO.setEdiReceiveId(custTpVO2.getRcvId());
					dblEdiInVO.setGroupEdiId(custTpVO2.getGroupId());
					dblEdiInVO.setFuncCode(custTpVO2.getFuncCode());
					DblEdiVO dblEdiVo=bLIssuanceBC.createDraftBlEdi(dblEdiInVO, account);
					bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();						
					
					// History
					for(int j=0;j<dblEdiVo.getFlatFileAckVOs().size();j++){
						BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
						bkgNtcHisVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
						bkgNtcHisVO.setNtcViaCd("E");
						bkgNtcHisVO.setNtcKndCd("BL");
						bkgNtcHisVO.setEdiId(custTpVO2.getRcvId());
						bkgNtcHisVO.setEsvcGrpCd(custTpVO2.getGroupId());
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
							bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
							isSend = true;
						}
					}
	    			if (Constants.SAMF_LIST.contains(custTpVO2.getRcvId())) {
						BkgReferenceVO[] bkgReferenceVOs = new BkgReferenceVO[1];
						BkgReferenceVO bkgReferenceVO = new BkgReferenceVO();
						bkgReferenceVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
						bkgReferenceVO.setBkgRefTpCd("SAMF");						
						bkgReferenceVO.setCustRefNoCtnt(dblEdiVo.getDblEdiSamf());
						bkgReferenceVOs[0] = bkgReferenceVO;

						rcpCmd.manageRefNo(bkgReferenceVOs, account, event.getBkgBlNoVO());
					}
	    			
	    			//Auto Email Send
	    			BkgBlNoVO bkgBlNoVO = utilBC.searchBkgBlNoVO(event.getBkgBlNoVO());
	    			
	    			DblWblVO dblWblVO = new DblWblVO();
	    			dblWblVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
	    			dblWblVO.setTitle("BLUPLOAD:SMLINE");
	    			dblWblVO.setContents(" ");
	    			dblWblVO.setBlNo(bkgBlNoVO.getBlNo());
//	    			dblWblVO.setNtcKndCd("BL");
	                dblWblVO.setHiddOpt("N");
	                dblWblVO.setFrtAllFlg("N");
	                dblWblVO.setFrtCltFlg("N");
	                dblWblVO.setFrtPpdFlg("N");
	                dblWblVO.setFrtChgFlg("Y");
	                dblWblVO.setFrtArrFlg("N");
	                
	    			List<BkgNtcHisVO> mailBkgNtcHisVOs = bLIssuanceBC.sendDblAutoEmail(dblWblVO, event.getCustTpIdVOs()[i].getRcvId(), account);
	    			// History
	    			if(mailBkgNtcHisVOs!=null){
						if(mailBkgNtcHisVOs.size()>0){
							bookingHistoryMgtBC.createBkgNtcHis(mailBkgNtcHisVOs, "ESM_BKG_0095");
							isSend = true;
						}
					}			
				}				
			}
			if(isSend==false){
				throw new EventException(new ErrorHandler("BKG00205",new String[]{}).getMessage());
			}
			commit();
			
			/**
		    * BPM 연동 처리 부분 ( BPM POC 이후 삭제 필요 )
		    */
//			if (isDraftBL == true && event.getDpcsSrKndCd().equalsIgnoreCase("F") &&  !event.getDpcsSrNo().equals("")){
//				BookingInterfaceMgtBC bpmBc = new BookingInterfaceMgtBCImpl();
//				String eventKey = event.getBkgBlNoVO().getBkgNo() + "_" +event.getDpcsSrNo();
//				bpmBc.bpmExecCall("BL",eventKey,account.getUsr_id());
//			}
			
			eventResponse.setETCData("SuccessYn", "Y");
			return eventResponse;
		} catch(EventException se) {
			rollback();
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	

	/**
	 * ESM_BKG_1069 : customer change <br>
	 * 입력한 customer code에 대한 customer 정보를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustNm(Event e) throws EventException {
       
       GeneralEventResponse eventResponse = new GeneralEventResponse();
       EsmBkg007901Event event = (EsmBkg007901Event) e;

       GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();
       try{      	
    	   BkgCreCustomerVO bkgCreCustomerVO = searchBC.searchCustNm(event.getCustCntCd(), event.getCustSeq());
	      
    	   if(bkgCreCustomerVO != null && bkgCreCustomerVO.getCustLglEngNm() != null){
    		   eventResponse.setETCData("cust_nm", bkgCreCustomerVO.getCustLglEngNm()); 
    		   eventResponse.setETCData("cust_rlse_ctrl_rmk", bkgCreCustomerVO.getCustRlseCtrlRmk()); 
    		   eventResponse.setETCData("ar_ofc", bkgCreCustomerVO.getArOfc()); 
    		   eventResponse.setETCData("pb", bkgCreCustomerVO.getPb());
    		   eventResponse.setETCData("srep_nm", bkgCreCustomerVO.getSrepNm()); 
    		   
    	   }else{
    		   eventResponse.setETCData("cust_nm", "");
    	   }          
       }catch(EventException ex){
           throw ex;
       }catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
       }
       return eventResponse;
    }	
		
	/** 
	 * transmode 변환 PRI -> PRD
	 * 
	 * @param String code
	 * @return String
	 */
	private String changeTrspModeCd(String code) {
		String rtnStr = null;
		if("B".equals(code)){
			rtnStr = "WD";
		} else if("R".equals(code)){
			rtnStr = "RD";
		} else if("T".equals(code)){
			rtnStr = "TD";
		} else if("A".equals(code)){
			rtnStr = "TR";
		} else if("U".equals(code)){
			rtnStr = "TW";			
		} else {
			rtnStr = "AL";
		}
		return rtnStr;
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
	private String reRequestSpclCgoApproval(BkgBlNoVO bkgBlNoVO, String rqstType, ScgVvdAproRqstVO[] inputScgVvdVOs) throws EventException {
		try{
			String result = "Not Request";
			GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();			
			ScgAproRqstVO[] scgAproRqstVOs = searchBC.searchBkgForSpclRqst(bkgBlNoVO, rqstType, account);
			ScgVvdAproRqstVO[] scgVvdVOs = null;
			// spcl cgo가 있을 때만 처리
	        if(scgAproRqstVOs.length>0){
				OwnDangerousCargoApprovalBC spclAproBC    = new OwnDangerousCargoApprovalBCImpl();
				SpecialCargoReceiptBC 	    spclReceiptBC = new SpecialCargoReceiptBCImpl();
				PartnerLinesDangerousCargoApprovalBC spclRqstBC = new PartnerLinesDangerousCargoApprovalBCImpl();
				
				SpclCgoAproApplVO           spclCgoAproVO = new SpclCgoAproApplVO();
				try {
					if(inputScgVvdVOs != null){
						scgVvdVOs = inputScgVvdVOs;
					} else { 
						scgVvdVOs = spclReceiptBC.searchBkgVvd(bkgBlNoVO.getBkgNo());
					}
			        
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
//								PreRestrictionOutputVO chkRslt = spclAproBC.checkPreRestriction(preRestrictionInputVO, false, true, true);
								PreRestrictionOutputVO chkRslt = spclRqstBC.checkPreRestriction(preRestrictionInputVO, false, true, true, true);
								
								boolean segRslt = chkRslt.getSegChkRslt();														//Result of Segregation Validation
								boolean vslRslt = chkRslt.getVslChkRslt();														//Result of Vessel Operator’s Prohibition
								boolean prtRslt = chkRslt.getPrtChkRslt();														//Result of Port Prohibition En-route
			//					List<PreRestrictionSegregationVO>    segRsltDtl = chkRslt.getPreRestrictionSegregationVOs();	//Detail of Segregation Validation
								List<PreRestrictionVesselOperatorVO> vslRsltDtl = chkRslt.getPreRestrictionVesselOperatorVOs();	//Detail of Vessel Operator’s Prohibition
								List<PreRestrictionPortVO>           prtRsltDtl = chkRslt.getPreRestrictionPortVOs();			//Detail of Port Prohibition En-route
								
								if("UPDATE".equals(rqstType)){
									if(vslRslt == true || prtRslt == true){
										result = "alert";
									}
								} else {
				//					pre check에서 걸렸을 때 spcl request 상태로 변경한다.
									if(segRslt == true || vslRslt == true || prtRslt == true){
										result = "pre-checking";
										String spclRqstDesc = "After implementation pre-checking routines at T/S port, found some conflicts or prohibitions.\n" +
															  "Please check the conflicts or prohibitions.";
										if(vslRsltDtl != null && vslRsltDtl.size()>0){
											for(int vslIdx=0; vslIdx<vslRsltDtl.size(); vslIdx++){
												spclReceiptBC.modifyDgSpclRqstByVvdChange(bkgBlNoVO, spclRqstDesc, vslRsltDtl.get(vslIdx).getSpclCgoSeq(), account);
											}
										}
										
										if(prtRsltDtl != null && prtRsltDtl.size()>0){
											for(int prtIdx=0; prtIdx<prtRsltDtl.size(); prtIdx++){
												spclReceiptBC.modifyDgSpclRqstByVvdChange(bkgBlNoVO, spclRqstDesc, prtRsltDtl.get(prtIdx).getSpclCgoSeq(), account);
											}
										}
									}
								}
							}
						}
						
			        	// bkg update, c/a confirm시 pre checking에 걸리면 전송 불필요 
			        	if("pre-checking".equals(result) 
			        		&& ("COMBINE".equals(rqstType) || "C/A VVD CHANGE".equals(rqstType))){
			        		log.debug("pre-checking -> not auto re-request case");
			        	} 
//			        	else if(!"alert".equals(result)){ //그 외의 경우 re-request
			        	else {
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
	 * ESM_BKG_0099 : P/C pop-up call back <br>
	 * split 화면에서 vvd 변경시 p/c pop-up후 해당하는 new route 정보를 조회한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSplitTsRoute(Event e) throws EventException {
       try{
	       GeneralEventResponse eventResponse = new GeneralEventResponse();
	       EsmBkg0099Event      event         = (EsmBkg0099Event) e;
	       GeneralBookingSplitCombineBC command = new GeneralBookingSplitCombineBCImpl();	       

	       BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
	       bkgBlNoVO.setBkgNo (event.getSplitBkgVO().getSplitBlInfoVO().get(0).getBkgNo());
	       bkgBlNoVO.setPctlNo(event.getSplitBkgVO().getSplitBlInfoVO().get(0).getPctlNo());
	       log.debug("bkg_no:"+bkgBlNoVO.getBkgNo());
	       log.debug("pctl_no:"+bkgBlNoVO.getPctlNo());
	       String rtnRoute = command.searchNewTsRoute(bkgBlNoVO);
	       eventResponse.setETCData("rtn_route", rtnRoute);
	       eventResponse.setETCData("pctl_no",   bkgBlNoVO.getPctlNo());
	       return eventResponse;     
       }catch(EventException ex){
           throw ex;
       }catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
       }
    }	


	/**
	 * ESM_BKG_1062 : open <br>
	 * 모든 Service Scope의 Code와 Name을 조회한다.<br>
	 * 최초 넘겨받은 값으로 Taa List를 조회한다.<br>
	 *  
	 * @author	KimByungKyu
	 * @param 	Event e
	 * @return		EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchSvcScpByTaa(Event e) throws EventException{
		try{
			EsmBkg1062Event event = (EsmBkg1062Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			List<MdmSvcScpVO> svcScpList =  command.searchSvcScp();
			List<TaaListVO> taaList =  command.searchTaaList(event.getTaaListInputVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(svcScpList);		
			eventResponse.setRsVoList(taaList);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}

	/**
	 * ESM_BKG_1062 : retrieve <br>
	 * 화주 계약서상의 TAA를 조회한다.<br>
	 *  
	 * @author	KimByungKyu
	 * @param 	Event e
	 * @return		EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchTaaList(Event e) throws EventException{
		try{
			EsmBkg1062Event event = (EsmBkg1062Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			List<TaaListVO> list =  command.searchTaaList(event.getTaaListInputVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}		


	/**
	 * ESM_BKG_1078 : retrieve <br>
	 * TAA 계약 상의 Commodity를 조회한다.<br>
	 *  
	 * @author	KimByungKyu
	 * @param 	Event e
	 * @return		EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchCmdtByTaa(Event e) throws EventException{
		try{
			EsmBkg1078Event event = (EsmBkg1078Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			List<TaaCmdtListVO> list = command.searchCmdtByTaa(event.getTaaListInputVO(), event.getCmdtNm(), event.getCmdtCd());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}

	/**
	 * Auto PSA EDI 전송
	 * cop에 전달할 Rail Receiving Date를 결정한다(mnl_set_dt 우선)
	 *  
	 * @author		YoungCheal Kim
	 * @param 		String bkgNo
	 * @param 		String qtyModifyFlag
	 * @return		String
	 */
	private String managePSABKGAuto(String bkgNo, String qtyModifyFlag) {
		String returnVal = "";
		try{
			begin();
			// psa I/f 대상 자동 전송부분 추가함. ( 전성진수석 요청 - 2010.08.20 - Ticket ID : CHM-201005191-01 )
			//BookingHistoryMgtBC의 createBkgHistoryLine 호출	
			BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
			List<BkgNtcHisVO> bkgNtcHisVOs = null;
			
			PSAManifestBC psaBC = new PSAManifestBCImpl();
			PsaBkgVO[] psaBkgVOs = new PsaBkgVO[1];
			psaBkgVOs[0] = new PsaBkgVO();
			psaBkgVOs[0].setBkgNo(bkgNo);
			psaBkgVOs[0].setSndUsrId(account.getUsr_id());
			psaBkgVOs[0].setQtyModifyFlag(qtyModifyFlag);
			
			psaBC.managePSABKG(psaBkgVOs);

			bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();	
			BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
			bkgNtcHisVO.setBkgNo(bkgNo);
			bkgNtcHisVO.setNtcViaCd("E");
			bkgNtcHisVO.setNtcKndCd("PS");
			bkgNtcHisVO.setEdiId("PSACBI");
			bkgNtcHisVO.setEsvcGrpCd("");
			bkgNtcHisVO.setBkgNtcSndRsltCd("A");
			bkgNtcHisVO.setSndUsrId(account.getUsr_id());
			bkgNtcHisVO.setSndOfcCd(account.getOfc_cd());
			bkgNtcHisVO.setCreUsrId(account.getUsr_id());
			bkgNtcHisVO.setUpdUsrId(account.getUsr_id());									
			bkgNtcHisVOs.add(bkgNtcHisVO);
			
			//2015.11.18 [CHM-201538758] PSA 로 Booking EDI (CBINFO)가 전송될 시, SGSINAO, SGSINAC 에서의 MT Release 를 위해 동일 Booking 정보를 SGSINAO, SGSINAC 로 추가 전송 함.
			String bkgMtyPkupYdCd = psaBC.searchBkgMtyPkupYdCdForPsa(bkgNo);
			if (bkgMtyPkupYdCd != null && bkgMtyPkupYdCd.length()>0){
				BkgNtcHisVO bkgNtcHisVO2 = new BkgNtcHisVO();
				bkgNtcHisVO2.setBkgNo(bkgNo);
				bkgNtcHisVO2.setNtcViaCd("E");
				bkgNtcHisVO2.setNtcKndCd("PS");
				bkgNtcHisVO2.setEdiId(bkgMtyPkupYdCd);
				bkgNtcHisVO2.setEsvcGrpCd("");
				bkgNtcHisVO2.setBkgNtcSndRsltCd("A");
				bkgNtcHisVO2.setSndUsrId(account.getUsr_id());
				bkgNtcHisVO2.setSndOfcCd(account.getOfc_cd());
				bkgNtcHisVO2.setCreUsrId(account.getUsr_id());
				bkgNtcHisVO2.setUpdUsrId(account.getUsr_id());									
				bkgNtcHisVOs.add(bkgNtcHisVO2);
			}
			
			if(bkgNtcHisVOs!=null){
				if(bkgNtcHisVOs.size()>0){
					bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0079");
				}
			}
			commit();
			returnVal = "Y";
		} catch(Exception ex){
			rollback();
			log.error(ex.getMessage());  // 2011.07.14
			returnVal = ex.getMessage();
			//			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return  returnVal;
	}	
	
	/**
	 * ESM_BKG_0099 : CBF 조회 <br>  
	 * booking split 화면에서 split시 CBF를 조회한다. <br>
	 *  
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchCbfFlag(Event e) throws EventException{
		try{
			EsmBkg0099Event event = (EsmBkg0099Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();	
			
			String		cbfFlag = "N"; 
			
			for (int i=0;i<event.getTargetBkg().length;i++){
				BkgBlNoVO bkgBlNoVO = null;
				bkgBlNoVO = event.getTargetBkg()[i];		
				
				cbfFlag = "N";

				cbfFlag = receiptBC.searchCbfFlag (bkgBlNoVO,account);
				
				if ( "Y".equals(cbfFlag)) {
					break;
				}
				
			}
			
			eventResponse.setETCData("cbf_flag",   cbfFlag);
	
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0079_01 <br>  
	 * ESM_BKG_0079_05<br>
	 * 해당 Customer가 Iran Black Customer 인지 체크한다. <br>
	 *  
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse checkIranBlackCustomer(Event e) throws EventException{
		try{

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			BookingUtil util = new BookingUtil();
			ArrayList <String> custNms = new ArrayList<String>();
			String fullSchFlg = "N";
			
			// ESM_BKG_0079_01
			if(e.getEventName().equalsIgnoreCase("EsmBkg007901Event")){
				EsmBkg007901Event event = (EsmBkg007901Event)e;
				BlCustomerInfoVO blCustomerInfoVO = event.getBlCustomerInfoVO();
				custNms.add(blCustomerInfoVO.getSCustNm());
				custNms.add(blCustomerInfoVO.getFCustNm());
				custNms.add(blCustomerInfoVO.getCCustNm());
				fullSchFlg = "Y";
				
			// ESM_BKG_0079_05
			} else if(e.getEventName().equalsIgnoreCase("EsmBkg007905Event")){
				EsmBkg007905Event event = (EsmBkg007905Event)e;
				BlDocCustVO blDocCustVO = event.getBlDocCustVO();
				custNms.add(blDocCustVO.getShCustNm());
				custNms.add(blDocCustVO.getCnCustNm());
				custNms.add(blDocCustVO.getNfCustNm());
				custNms.add(blDocCustVO.getFfCustNm());
				custNms.add(blDocCustVO.getAnCustNm());
				custNms.add(blDocCustVO.getExCustNm());
			}

			int blackCustFlagCnt = 0; 
			String blackCustName = "";
			String blackCustList = "";
			String blackCustFlag = "";
			StringBuffer blackCustListBuf = new StringBuffer();
			
			for(int i=0; i<custNms.size(); i++){
				
				String custNm = (String)custNms.get(i);
				if(custNm != null && !"".equals(custNm)){
					
					blackCustName = util.checkIranBlackCustomer(custNm, fullSchFlg);
					
					if(blackCustName != null && !"".equals(blackCustName)){
						blackCustListBuf.append(blackCustName);
						blackCustListBuf.append(", ");
						
						blackCustFlagCnt++;
					}
				}
			} // end for
			
			blackCustList = blackCustListBuf.toString();
			if(blackCustList.lastIndexOf(",") > -1){
				blackCustList = blackCustList.substring(0, blackCustList.lastIndexOf(","));
			}
			
			if(blackCustFlagCnt > 0){
				blackCustFlag = "Y";
			}
			
			eventResponse.setETCData("black_cust_flag",   blackCustFlag);
			eventResponse.setETCData("black_cust_list", blackCustList);
			
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0079_05<br>
	 * 해당 Customer가 Eu Black Customer 인지 체크한다. <br>
	 *  
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse checkEuBlackCustomer(Event e) throws EventException{
		try{

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			BookingUtil util = new BookingUtil();
			ArrayList <String> custNms = new ArrayList<String>();
			
			// ESM_BKG_0079_05
			if(e.getEventName().equalsIgnoreCase("EsmBkg007905Event")){
				EsmBkg007905Event event = (EsmBkg007905Event)e;
				BlDocCustVO blDocCustVO = event.getBlDocCustVO();
				custNms.add(blDocCustVO.getShCustNm());
				custNms.add(blDocCustVO.getCnCustNm());
				custNms.add(blDocCustVO.getNfCustNm());
				custNms.add(blDocCustVO.getFfCustNm());
				custNms.add(blDocCustVO.getAnCustNm());
				custNms.add(blDocCustVO.getExCustNm());
			}

			int blackCustFlagCnt = 0; 
			String blackCustName = "";
			String blackCustList = "";
			String blackCustFlag = "N";
			StringBuffer blackCustListBuf = new StringBuffer();
			
			for(int i=0; i<custNms.size(); i++){
				
				String custNm = (String)custNms.get(i);
				if(custNm != null && !"".equals(custNm)){
					
					// enter를 제외
					custNm = custNm.replace("\r\n", "");
					blackCustName = util.checkEuBlackCustomer(custNm);
					
					if(blackCustName != null && !"".equals(blackCustName)){
						blackCustListBuf.append(custNm);
						blackCustListBuf.append(", ");
						
						blackCustFlagCnt++;
					}
				}
			} // end for
			
			blackCustList = blackCustListBuf.toString();
			if(blackCustList.lastIndexOf(",") > -1){
				blackCustList = blackCustList.substring(0, blackCustList.lastIndexOf(","));
				blackCustFlag = "Y";
			}

			eventResponse.setETCData("black_cust_flag",   blackCustFlag);
			
			// Error 발생
			if(blackCustFlagCnt > 0){
				throw new EventException(new ErrorHandler("BKG02078", new String[]{blackCustList}).getMessage()); 
			}
			
			return eventResponse;
		} catch(EventException se) {
            if(se.getMessage().indexOf("BKG02078") > -1){
              throw new EventException(se.getMessage());
            } else {
				log.error("err " + se.toString(), se);
				throw se;
            }
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}	

	/**
	 * ESM_BKG_0079_05<br>
	 * 해당 Customer가 US Black Customer 인지 체크한다. <br>
	 *  
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	
	private EventResponse checkUsBlackCustomer(Event e) throws EventException{
		try{

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			BookingUtil util = new BookingUtil();
			ArrayList <String> custNms = new ArrayList<String>();
			ArrayList <String> rmkList = new ArrayList<String>();
			String fullSchFlg = "N";
			
			// ESM_BKG_0079_01
			if(e.getEventName().equalsIgnoreCase("EsmBkg007901Event")){
				EsmBkg007901Event event = (EsmBkg007901Event)e;
				BlCustomerInfoVO blCustomerInfoVO = event.getBlCustomerInfoVO();
				BkgBookingInfoVO bkgBookingInfoVO = event.getBkgBookingInfoVO();	
				
				custNms.add(blCustomerInfoVO.getSCustNm());
				custNms.add(blCustomerInfoVO.getFCustNm());
				custNms.add(blCustomerInfoVO.getCCustNm());
				
				rmkList.add(bkgBookingInfoVO.getInterRmk());
				rmkList.add(bkgBookingInfoVO.getXterRmk());
				
				fullSchFlg = "Y";
				
			// ESM_BKG_0079_05
			} else if(e.getEventName().equalsIgnoreCase("EsmBkg007905Event")){
				EsmBkg007905Event event = (EsmBkg007905Event)e;
				BlDocCustVO blDocCustVO = event.getBlDocCustVO();
				custNms.add(blDocCustVO.getShCustNm());
				custNms.add(blDocCustVO.getCnCustNm());
				custNms.add(blDocCustVO.getNfCustNm());
				custNms.add(blDocCustVO.getFfCustNm());
				custNms.add(blDocCustVO.getAnCustNm());
				custNms.add(blDocCustVO.getExCustNm());
				
				custNms.add(blDocCustVO.getShCustLglEngNm());
				custNms.add(blDocCustVO.getCnCustLglEngNm());
				custNms.add(blDocCustVO.getNfCustLglEngNm());
				custNms.add(blDocCustVO.getFfCustLglEngNm());
				custNms.add(blDocCustVO.getAnCustLglEngNm());
			}

			int blackCustFlagCnt = 0; 
			String blackCustName = "";
			String blackCustList = "";
			String blackCustFlag = "";
			StringBuffer blackCustListBuf = new StringBuffer();
			
			for(int i=0; i<custNms.size(); i++){
				
				String custNm = (String)custNms.get(i);
				if(custNm != null && !"".equals(custNm)){
					// enter 제거, 특수문자->공란, 공란여러개->공란1개
					custNm = custNm.replace("\r\n", "");
					custNm = custNm.replace("~", " ").replace("!", " ").replace("@", " ").replace("#", " ").replace("$", " ").replace("%", " ");
					custNm = custNm.replace("^", " ").replace("&", " ").replace("*", " ").replace("(", " ").replace(")", " ").replace("_", " ");
					custNm = custNm.replace("+", " ").replace("`", " ").replace("-", " ").replace("=", " ").replace("{", " ").replace("}", " ");
					custNm = custNm.replace("|", " ").replace("[", " ").replace("]", " ").replace("\\", " ").replace(":", " ").replace(";", " ");
					custNm = custNm.replace("\"", " ").replace("'", " ").replace("/", " ").replace("<", " ").replace(">", " ").replace("?", " ");
					custNm = custNm.replace(",", " ").replace(".", " ");
					custNm = custNm.replace("  ", " ").replace("  ", " ").replace("  ", " "); 
					
					blackCustName = util.checkUsBlackCustomer(custNm, fullSchFlg);
					
					if(blackCustName != null && !"".equals(blackCustName)){
						blackCustListBuf.append(blackCustName);
						blackCustListBuf.append(", ");
						
						blackCustFlagCnt++;
					}
				}
			} // end for
			
			blackCustList = blackCustListBuf.toString();
			if(blackCustList.lastIndexOf(",") > -1){
				blackCustList = blackCustList.substring(0, blackCustList.lastIndexOf(","));
			}
			
			if(blackCustFlagCnt > 0){
				blackCustFlag = "Y";
			}
			
			//Ext,Int remark에 문구 들어가 있는지 검사
			//이 경우는 fullSchFlg의 조건 값이 N
			int blackRmkFlagCnt = 0; 
			String blackRmkName = "";
			String blackRmkList = "";
			String blackRmkFlag = "";
			StringBuffer blackRmkListBuf = new StringBuffer();
			
			for(int i=0; i<rmkList.size(); i++){
				
				String rmk = (String)rmkList.get(i);
				if(rmk != null && !"".equals(rmk)){
					// enter 제거, 특수문자->공란, 공란여러개->공란1개
					rmk = rmk.replace("\r\n", " ");
					rmk = rmk.replace("~", " ").replace("!", " ").replace("@", " ").replace("#", " ").replace("$", " ").replace("%", " ");
					rmk = rmk.replace("^", " ").replace("&", " ").replace("*", " ").replace("(", " ").replace(")", " ").replace("_", " ");
					rmk = rmk.replace("+", " ").replace("`", " ").replace("-", " ").replace("=", " ").replace("{", " ").replace("}", " ");
					rmk = rmk.replace("|", " ").replace("[", " ").replace("]", " ").replace("\\", " ").replace(":", " ").replace(";", " ");
					rmk = rmk.replace("\"", " ").replace("'", " ").replace("/", " ").replace("<", " ").replace(">", " ").replace("?", " ");
					rmk = rmk.replace(",", " ").replace(".", " ");
					rmk = rmk.replace("  ", " ").replace("  ", " ").replace("  ", " "); 
					
					blackRmkName = util.checkUsBlackCustomer(rmk, "N");
					
					if(blackRmkName != null && !"".equals(blackRmkName)){
						blackRmkListBuf.append(blackRmkName);
						blackRmkListBuf.append(", ");
						
						blackRmkFlagCnt++;
					}
				}
			} // end for
			
			blackRmkList = blackRmkListBuf.toString();
			if(blackRmkList.lastIndexOf(",") > -1){
				blackRmkList = blackRmkList.substring(0, blackRmkList.lastIndexOf(","));
			}
			
			if(blackRmkFlagCnt > 0){
				blackRmkFlag = "Y";
			}
			
			eventResponse.setETCData("black_cust_flag",   blackCustFlag);
			eventResponse.setETCData("black_cust_list", blackCustList);
			
			eventResponse.setETCData("black_rmk_flag",   blackRmkFlag);
			eventResponse.setETCData("black_rmk_list", blackRmkList);
			
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}		
	
	/**
	 * ESM_BKG_0079_01,ESM_BKG_0079_05 : searchBkgChgOfc <br>
	 * searchBkgChgOfc 정보를 저장한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgChgOfc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg007901Event event01 = null;
		EsmBkg007905Event event05 = null;
		GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();
		BookingUtil util = new BookingUtil();
		BkgBlNoVO bkgBlNoVO = null;
		List<BkgChgOfcVO> list = null;
		try {
			if (0<e.getEventName().indexOf("01")) {
				event01 = (EsmBkg007901Event) e;
				bkgBlNoVO = event01.getBkgBlNoVO();
			} else {
				event05 = (EsmBkg007905Event) e;
				bkgBlNoVO = event05.getBkgBlNoVO();
			}
			bkgBlNoVO.setCaUsrId(account.getUsr_id());
			list = searchBC.searchBkgChgOfc(util.searchBkgBlNoVO(bkgBlNoVO));
			eventResponse.setRsVoList(list);
       } catch(EventException ex) {
           throw ex;
       } catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
       }
       return eventResponse;
    }	

	/**
	 * ESM_BKG_0079_01,ESM_BKG_0079_05 : modifyBkgChgOfc <br>
	 * modifyBkgChgOfc 정보를 저장한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBkgChgOfc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg007901Event event01 = null;
		EsmBkg007905Event event05 = null;
		BlRatingBC rateBC = new BlRatingBCImpl();
		BookingUtil util = new BookingUtil();
		BkgBlNoVO bkgBlNoVO = null;
		BkgModiOfcPrcVO bkgModiOfcPrcVO = null;
		try {
			if (0<e.getEventName().indexOf("01")) {
				event01 = (EsmBkg007901Event) e;
				bkgBlNoVO = event01.getBkgBlNoVO();
			} else {
				event05 = (EsmBkg007905Event) e;
				bkgBlNoVO = event05.getBkgBlNoVO();
			}
			bkgBlNoVO.setCaUsrId(account.getUsr_id());
			bkgBlNoVO = util.searchBkgBlNoVO(bkgBlNoVO);
			bkgModiOfcPrcVO = new BkgModiOfcPrcVO();
			bkgModiOfcPrcVO.setInBkgNo(bkgBlNoVO.getBkgNo());
			bkgModiOfcPrcVO.setInCaFlg(bkgBlNoVO.getCaFlg());
			bkgModiOfcPrcVO.setInPpdFlg("Y");
			bkgModiOfcPrcVO.setInCctFlg("Y");
			rateBC.callBkgModiChgOfcPrc(bkgModiOfcPrcVO);
			if(!"Y".equals(bkgBlNoVO.getCaFlg())) {
				interfaceToInv(bkgBlNoVO, account);
				interfaceToMas(bkgBlNoVO, "Booking Update", account);
			}
       } catch(EventException ex) {
           throw ex;
       } catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
       }
       return eventResponse;
    }
	
	/**
	 * ESM_BKG_0079_05 : cust_cnt_cd, cust_seq change <br>
	 * CustCntCd와 CustSeq로 mdm_cust_cntc_pnt의 phn_no, fax_no, cust_eml을 조회한다.<br>
	 * 
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmPhnFaxEml(Event e) throws EventException {
		try{
			MdmCustVO mdmCustVO = null;
			BookingUtil bookingUtil = new BookingUtil();
				
			EsmBkg007905Event event = (EsmBkg007905Event)e;
			mdmCustVO = bookingUtil.searchMdmPhnFaxEml(event.getCustCntCd(), event.getCustSeq());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if(mdmCustVO != null){
				eventResponse.setETCData("phn_no", mdmCustVO.getPhnNo());
				eventResponse.setETCData("fax_no", mdmCustVO.getFaxNo());
				eventResponse.setETCData("cust_eml", mdmCustVO.getCustEml());
			}
		
			return eventResponse;			
		}catch(EventException ex){
//			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_0079_01,ESM_BKG_0079_05 : searchBkgChgOfc <br>
	 * searchBkgChgOfc 정보를 저장한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTSRoute(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil bookingUtil = new BookingUtil();
		EsmBkg007905Event event = (EsmBkg007905Event) e;
		BkgBlNoVO bkgBlNoVO = null;
		List<BkgBookingVO> list = null;
		
		try {
			bkgBlNoVO = event.getBkgBlNoVO();
			list = bookingUtil.searchTSRoute(bkgBlNoVO);
			
			if (list.size() > 0) {
				eventResponse.setETCData("isCNTsRoute", "Y");	// 중국 경유 인도 외 향
			} else {
				eventResponse.setETCData("isCNTsRoute", "N");	// 중국 경유 인도향
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0079_01,ESM_BKG_0079_05 : searchBkgChgOfc <br>
	 * searchBkgChgOfc 정보를 저장한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDocTp(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil bookingUtil = new BookingUtil();
		EsmBkg007905Event event = (EsmBkg007905Event) e;
		BkgBlNoVO bkgBlNoVO = null;
		List<BkgBookingVO> list = null;
		
		try {
			bkgBlNoVO = event.getBkgBlNoVO();
			list = bookingUtil.searchDocTp(bkgBlNoVO);
			
			for (int i = 0; i < list.size(); i++) {
				if ("S".equals(list.get(i).getDocTpCd())) {
					eventResponse.setETCData("isSISubmit", "Y");
				} else {
					eventResponse.setETCData("isSISubmit", "N");
				}
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		
		return eventResponse;
	}

	/**
	 * ESM_BKG_0079_01 <br>  
	 * cmdt_cd를 이용해 중국 Solid Waste 관련 bkg commodity validation 대상인지 체크한다. <br>
	 *  
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validateChnWasteCmdt(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg007901Event event = (EsmBkg007901Event)e;
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		String chnWasteFlag = null;
		try{
			chnWasteFlag = receiptBC.validateChnWasteCmdt(event.getCmdtCd());
			eventResponse.setETCData("chn_waste_flag", chnWasteFlag);
			
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}

	/**
	 * ESM_BKG_0079_01 <br>  
	 * 미주OB에 대해서 특정 cmdt code를 입력하면 Vehicle에 자동 체크 <br>
	 *  
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validateUSVehicleCommodity(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg007901Event event = (EsmBkg007901Event)e;
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		String vehicleFlag = null;
		try{
			vehicleFlag = receiptBC.validateUSVehicleCommodity(event.getCmdtCd());
			eventResponse.setETCData("vehicle_flag", vehicleFlag);
			
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0079_01 <br>  
	 * VVD 변경시 사전신고 된 VVD가 변경된 경우 저장 Click시 warning 메시지 표시. <br>
	 *  
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchManifestTrans(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg007901Event event = (EsmBkg007901Event)e;
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		String vvdChange = "";
		VslSkdVO[] vslSkdVOs = null;
		int vslSkdVOsSize = 0;
		try{
			vslSkdVOs = event.getVslSkdVOs();
			List<String> paramVvds = new ArrayList<String>();
			
			if (null != vslSkdVOs){
				vslSkdVOsSize = vslSkdVOs.length;
				for(int i=0; i < vslSkdVOsSize; i++) {
					paramVvds.add(vslSkdVOs[i].getBkgVvdCd());
				}
				
				vvdChange = receiptBC.searchManifestTrans(event.getBkgBlNoVO(), paramVvds);
			}
			
			eventResponse.setETCData("vvd_change", vvdChange);
			
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0003 : retrieve <br>
	 * Customer Advisory 정보를 조회한다.<br>
	 *  
	 * @param 	Event e
	 * @return		EventResponse
	 * @exception 	EventException
	 */
	private EventResponse searchCustAdvisoryNoticeSendList(Event e) throws EventException{
		try{
			EsmBkg0003Event event = (EsmBkg0003Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			
			BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO = event.getBkgCustAvcNtcSchVO();
			StringBuffer dirStsCdbf = new StringBuffer("'").append(bkgCustAvcNtcSchVO.getEDirCd()).append("','").append(bkgCustAvcNtcSchVO.getWDirCd()).append("','").append(bkgCustAvcNtcSchVO.getSDirCd()).append("','").append(bkgCustAvcNtcSchVO.getNDirCd()).append("'");
			StringBuffer searchClssTypebf = new StringBuffer("'").append(bkgCustAvcNtcSchVO.getKeyAcctFlg()).append("','").append(bkgCustAvcNtcSchVO.getGloAcctFlg()).append("','").append(bkgCustAvcNtcSchVO.getRgnAcctFlg()).append("','").append(bkgCustAvcNtcSchVO.getLclAcctFlg()).append("'");
			bkgCustAvcNtcSchVO.setDirStsCd(dirStsCdbf.toString());
			bkgCustAvcNtcSchVO.setSearchClssType(searchClssTypebf.toString()); 
			
			List<BkgCustAvcNtcSndVO> list = command.searchCustAdvisoryNoticeSendList(bkgCustAvcNtcSchVO);
			String cntrCnt = command.searchCustAdvisoryNoticeCntrCnt(bkgCustAvcNtcSchVO);
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			eventResponse.setETCData("cntr_cnt", cntrCnt);
			if(list != null && list.size() >0 && list.get(0) != null){
				eventResponse.setETCData("sel_seq", list.get(0).getSelSeq());
			}
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_0003: upload<br> 
	 * Emergemcy Case 가 발생 한 대상 Container를 기준으로 B/L정보를 저장한다.
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createCustAdvisoryNoticeListByUpload(Event e) throws EventException{
		try{
			begin();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmBkg0003Event event = (EsmBkg0003Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();

			/*-------------------------------------------------------------------------------------------------------------
			command.createCustAdvisoryNoticeListByUpload(event.getBkgCustAvcNtcSchVO(), event.getBkgCustAvcNtcUploadVOs(), account);
			------------------------------------------------------------------------------------------------------------- */
			
			// BackEnd
			String key = command.startBackEndJob(account, event.getBkgCustAvcNtcSchVO(), event.getBkgCustAvcNtcUploadVOs(), "ESM_BKG_0003");
			eventResponse.setETCData("KEY", key);

			commit();
			return eventResponse;			
		}catch(EventException ex){
			rollback();
			log.error("err"+ex.toString(),ex);
			// Excel Upload 의 Cntr No 중복 일때 BKG06132 에러 발생
			if(ex.getMessage().equals(new ErrorHandler("BKG06132").getMessage())){
				throw new EventException(new ErrorHandler("BKG06132").getMessage());
			}else{
					throw ex;
			}
		}catch(Exception ex){
			rollback();
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_0003: save<br>
	 * Customer Advisory 정보를 변경한다.
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageCustAdvisoryNoticeList(Event e) throws EventException{
		try{
			begin();
			EsmBkg0003Event event = (EsmBkg0003Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			command.manageCustAdvisoryNoticeList(event.getBkgCustAvcNtcSndVOs(), account);
			
			commit();
			
			//저장후 결과처리
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());  //BKG00166 : 저장성공
			return eventResponse;
			
		}catch(EventException ex){
			rollback();
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_0003: fax<br>
	 * 해당 Customer에게  Advisory Notice 에 대한 Fax을 발송한다.
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse sendCustAdvisoryNoticeListByFax(Event e) throws EventException{
		try{
			begin();
			EsmBkg0003Event event = (EsmBkg0003Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			
			for( int idx = 0; idx < event.getBkgCustAvcNtcSndVOs().length; idx++ ){
				event.getBkgCustAvcNtcSndVOs()[idx].setOfcCd(event.getOfcCd());
			}
			command.sendCustAdvisoryNoticeListByFax(event.getBkgCustAvcNtcSndVOs(), account);
			
			commit();
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setUserMessage(new ErrorHandler("BKG00496").getUserMessage());  //BKG00496 : 송신성공
			
			return eventResponse;
			
		}catch(EventException ex){
			rollback();
			log.error("err"+ex.toString(),ex);
			// html 본문 rmk 내용이 없을 경우 BKG40119 에러 발생
			if(ex.getMessage().equals(new ErrorHandler("BKG40119").getMessage())){
				throw new EventException(new ErrorHandler("BKG40119").getMessage());
			}else{
					throw ex;
			}
		}catch(Exception ex){
			rollback();
			log.error("err"+ex.toString(),ex);
        	String[] msg = new String[]{"Customer Advisory"};
        	throw new EventException(new ErrorHandler("BKG40035",msg).getMessage());
		}
	}
	
	/**
	 * ESM_BKG_0003: email<br>
	 * 해당 Customer에게  Advisory Notice 에 대한 EMail을 발송한다.
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse sendCustAdvisoryNoticeListByMail(Event e) throws EventException{
		try{
			begin();
			EsmBkg0003Event event = (EsmBkg0003Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			
			for( int idx = 0; idx < event.getBkgCustAvcNtcSndVOs().length; idx++ ){
				event.getBkgCustAvcNtcSndVOs()[idx].setOfcCd(event.getOfcCd());
			}
			command.sendCustAdvisoryNoticeListByMail(event.getBkgCustAvcNtcSndVOs(), event.getUrlPath(), account);
			
			commit();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setUserMessage(new ErrorHandler("BKG00497").getUserMessage());  //BKG00497 : 송신성공
			return eventResponse;
			
		}catch(EventException ex){
			rollback();
			log.error("err"+ex.toString(),ex);
			// html 본문 rmk 내용이 없을 경우 BKG40119 에러 발생
			if(ex.getMessage().equals(new ErrorHandler("BKG40119").getMessage())){
				throw new EventException(new ErrorHandler("BKG40119").getMessage());
			}else{
					throw ex;
			}
		}catch(Exception ex){
			rollback();
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_0004: search<br>
	 * Customer Advisory Notice Remark 정보를 조회한다.
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCustAdvisoryNoticeRemark(Event e) throws EventException{
		try{
			EsmBkg0004Event event 				= (EsmBkg0004Event)e;
			GeneralBookingSearchBC command 		= new GeneralBookingSearchBCImpl();
			GeneralEventResponse eventResponse	= new GeneralEventResponse();

			event.getBkgCustAvcNtcRmkVO().setVvd(event.getBkgCustAvcNtcRmkVO().getVvd() + event.getDirCd());
			List<BkgCustAvcNtcRmkVO> list = command.searchCustAdvisoryNoticeRemark(event.getBkgCustAvcNtcRmkVO());
			// RMK 정보가 없는 경우
			if(list == null || list.size() ==0){
				BkgCustAvcNtcRmkVO bkgCustAvcNtcRmkVO = new BkgCustAvcNtcRmkVO();
				bkgCustAvcNtcRmkVO.setVvd(event.getVvd());
				
				list = new ArrayList<BkgCustAvcNtcRmkVO>();
				list.add(bkgCustAvcNtcRmkVO);
			}

			eventResponse.setRsVoList(list);
			
			return eventResponse;
			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_0004: search01<br>
	 * Customer Advisory Notice Office Code Validation
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchExistOfcCd(Event e) throws EventException{
		try{
			EsmBkg0004Event event 				= (EsmBkg0004Event)e;
			BookingUtil bookingUtil 	   		= new BookingUtil();
			GeneralEventResponse eventResponse	= new GeneralEventResponse();
			
			if( "Y".equals(bookingUtil.existThirdCode(event.getBkgCustAvcNtcRmkVO().getOfcCd())) ){
				eventResponse.setETCData("existOfcCdFlg", "Y");
			} else{
				eventResponse.setETCData("existOfcCdFlg", "N");
			}
			
			return eventResponse;
			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}
	
	/**
	 * searchCustAdvisoryFileList
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchCustAdvisoryFileList(Event e) throws EventException{
		try{
			EsmBkg0004Event event = (EsmBkg0004Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			List<BkgCustAvcFileListVO> list = command.searchCustAdvisoryFileList(event.getBkgCustAvcNtcRmkVO());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_0004: save<br>
	 * Customer Advisory Notice Remark 정보를 수정한다.
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse manageCustAdvisoryNoticeRemark(Event e) throws EventException{
		try{
			begin();
			EsmBkg0004Event event = (EsmBkg0004Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			String vvd = event.getVvd() + event.getDirCd();
			BkgCustAvcNtcRmkVO bkgCustAvcNtcRmkVO = event.getBkgCustAvcNtcRmkVO();
			bkgCustAvcNtcRmkVO.setVvd(vvd);
			command.manageCustAdvisoryNoticeRemark(bkgCustAvcNtcRmkVO, account);
			
			commit();
			
			// 저장 후 결과처리
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());  //BKG00166 : 저장성공
			return eventResponse;
			
		}catch(EventException ex){
			rollback();
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}
	
		
	/**
	 * ESM_BKG_0005: search<br>
	 * Customer Advisory History 정보를 조회한다.
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCustAdvisoryNoticeSendHistory(Event e) throws EventException{
		try{
			EsmBkg0005Event event = (EsmBkg0005Event)e;
			GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
			
			BkgCustAvcNtcSndHisSchVO bkgCustAvcNtcSndHisSchVO = event.getBkgCustAvcNtcSndHisSchVO();
			
			List<BkgCustAvcNtcSndHisVO> list = command.searchCustAdvisoryNoticeSendHistory(bkgCustAvcNtcSndHisSchVO);
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKg_1139 : search<br>
	 * TRO Fax/Email 발송 History를 조회한다.
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchEurTroNotice(Event e) throws EventException {
		try{
			EsmBkg1139Event event = (EsmBkg1139Event)e;
			GeneralBookingSearchBC command  = new GeneralBookingSearchBCImpl();
			TransferOrderIssueBC   command2 = new TransferOrderIssueBCImpl();
			List<SendBkgFaxEmailVO> list1 =  command.searchEurTroNotice(event.getBkgBlNoVO(), event.getIoBndCd());
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list1);
			
			if(event.getIoBndCd()!=null && event.getIoBndCd().equals("I")){
				List<BkgEurTroVO> list2 =  command2.searchTroCntrListByBkg(event.getBkgBlNoVO());
				eventResponse.setRsVoList(list2);
			}
			return eventResponse;
			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}
	
	/**
	 * 하위 BKG가 모두 Cancel 된 경우 해당 Master BKG의 상태를 S에서 F(W,A)로 변경
	 * @param bkgNo
	 * @throws EventException
	 */
	private void changeMemoSplitBkgStatus(String bkgNo) throws EventException{
		try{
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
			BLDocumentationCMBC blDocCmBC = new BLDocumentationCMBCImpl();
			BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
			BkgCopManageBC copBC		= new BkgCopManageBCImpl();
			BkgBlNoVO blNoVO= new BkgBlNoVO();
			MasBkgComIfVO masBkgComIfVo 		= new MasBkgComIfVO();
			CostAssignBC masBc 					= new CostAssignBCImpl();
			ARBkgInterfaceCreationVO bkgIfVo 	= new ARBkgInterfaceCreationVO();
			BookingARCreationBC invBc 			= new BookingARCreationBCImpl();
			
			// 하위 BKG가 모두 Cancel 된 경우 해당 Master BKG의 상태를 S에서 F(W,A)로 변경
			List<String> cxlBkgNo = receiptBC.searchMemoSplitFromBkgNo(bkgNo);	

			if(cxlBkgNo != null && cxlBkgNo.size() > 0){
				for (int i = 0; i < cxlBkgNo.size(); i++) {
					if(cxlBkgNo.get(i) != null){
						
						blNoVO.setBkgNo(cxlBkgNo.get(i));
						blNoVO.setCaFlg("N");
						//Activate Container 
						blDocCmBC.activateBkgCntr(blNoVO, account);
			    		//COP replan
			    		copBC.reviveCopsByBkgRqst(blNoVO.getBkgNo());
						receiptBC.modifyMemoSplitBkgStatus(blNoVO, account);
						receiptBC.changeBkgStatus("F", blNoVO, false, account);
						
						//MAS I/F
						masBkgComIfVo.setBkgNo(blNoVO.getBkgNo());
						masBkgComIfVo.setCostSrcSysCd("BKG");
						masBkgComIfVo.setIfRmk("reactivate");
						masBkgComIfVo.setCreUsrId(account.getUsr_id());
						masBkgComIfVo.setUpdUsrId(account.getUsr_id());			
						masBc.modifyMasCommonInterface(masBkgComIfVo);
						
						//INV I/F
						bkgIfVo.setBkgNo(blNoVO.getBkgNo());
						bkgIfVo.setBkgCorrNo(blNoVO.getCaNo());
						bkgIfVo.setUserId(account.getUsr_id());
						bkgIfVo.setManDivInd("B");
						invBc.interfaceBKGARInvoiceToINV(bkgIfVo);
						//History 추가			
						HistoryLineVO historyVO = new HistoryLineVO();
						historyVO.setBkgNo(blNoVO.getBkgNo());
						historyVO.setCaFlg(blNoVO.getCaFlg());
						historyVO.setBkgDocProcTpCd("BREACT");// booking firm for doc performance
						historyVO.setUiId("ESM_BKG_0079_01");
						historyVO.setCrntCtnt("Reactivate.");
						historyVO.setHisCateNm("Reactivate."); 
						historyBC.createBkgHistoryLine(historyVO, account);
					}
				}
			}
						
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	
	/*
	 * BackEndJob 실행 후 결과코드 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse backEndJobResult(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String sKey = "";
		if(e.getEventName().equalsIgnoreCase("EsmBkg0003Event"))
		{
			EsmBkg0003Event event =(EsmBkg0003Event) e;
			sKey = event.getKey();
		}
		String strResult = "";
		try
		{
			BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(sKey);
			DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
			while(rowSet.next()){
				if("2".equals(rowSet.getString("JB_STS_FLG")))
				{
					// BackEndJob 처리중
					strResult = "PROCESSING";
				}
				else if("3".equals(rowSet.getString("JB_STS_FLG")))
				{
					strResult = "SUCCESS";
				}
				else if("4".equals(rowSet.getString("JB_STS_FLG")))
				{ 
					strResult = "FAIL";
				}
			}
			eventResponse.setETCData("jb_sts_flg", strResult);
		}
		catch(Exception ex)
		{
			rollback();
			throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	  * ESM_BKG_0003 : BST Download <br>
	  * BST Customer Advisory 정보를 저장한다<br>
	  *  
	  * @param  Event e
	  * @return  EventResponse
	  * @exception  EventException
	  */
	 private EventResponse manageCustAdvisoryNoticeSendListForBST(Event e) throws EventException{
	  try{
	   EsmBkg0003Event event = (EsmBkg0003Event)e;
	   GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
	   
	   BkgCustAvcNtcSchVO bkgCustAvcNtcSchVO = event.getBkgCustAvcNtcSchVO();
	   StringBuffer dirStsCdbf = new StringBuffer("'").append(bkgCustAvcNtcSchVO.getEDirCd()).append("','").append(bkgCustAvcNtcSchVO.getWDirCd()).append("','").append(bkgCustAvcNtcSchVO.getSDirCd()).append("','").append(bkgCustAvcNtcSchVO.getNDirCd()).append("'");
	   bkgCustAvcNtcSchVO.setDirStsCd(dirStsCdbf.toString());
	   
	   GeneralEventResponse eventResponse = new GeneralEventResponse();
//	   String cntrCnt = command.searchCustAdvisoryNoticeCntrCnt(bkgCustAvcNtcSchVO);
//	   if (cntrCnt != null && cntrCnt.equals("0")) {
	    
	    // BST Upload대상을 체크한다.
	    int cnt =  command.searchCustAdvisoryNoticeCntByBSTUpload(bkgCustAvcNtcSchVO);
	     
	    if (cnt > 0) {
	   
	     begin();
	     
	     // BackEnd
	     String key = command.startBackEndJob(account, event.getBkgCustAvcNtcSchVO(), event.getBkgCustAvcNtcUploadVOs(), "BST_DOWNLOAD");
	     eventResponse.setETCData("KEY", key);
	     
	     commit();
	     return eventResponse; 
	     
	    } else {
	     eventResponse.setETCData("err", "cntIsZero");
	    }
	    
//	   } else {
//	    eventResponse.setETCData("err", "err");
//	   }
	   
	   return eventResponse;   
	   
	  }catch(EventException ex){
	   log.error("err"+ex.toString(),ex);
	   throw ex;
	  }catch(Exception ex){
	   log.error("err"+ex.toString(),ex);
	   throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
	  }
	 }

	/**
	 * ESM_BKG_0003 : INIT <br>
	 * 코드별 콤보 데이터 조회<br>
	 * 
	 * @param String comCode
	 * @return GeneralEventResponse
	 * @exception EventException
	 */
	private GeneralEventResponse searchComCode0003(Event e) throws EventException{
		GeneralEventResponse response = new GeneralEventResponse();
		List<BkgComboVO> list = new ArrayList<BkgComboVO>();
		try
		{
			BookingUtil bkgUtil = new BookingUtil();
			list = bkgUtil.searchCombo("CD03141");
			response.setRsVoList(list);
		}
		catch(Exception ex)
		{
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}
		return response;
	}

	/**
	 * ESM_BKG_1158 : Retrieve <br>
	 * Consignee, Notify Code의 정확도를 조회한다<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPreCheckForCodeAccuracyMatch(Event e) throws EventException{
		try{
			EsmBkg1158Event event = (EsmBkg1158Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();	
			GeneralBookingListSearchBC command = new GeneralBookingListSearchBCImpl();

            ArrNtcSearchVO arrNtcSearchVO = event.getArrNtcSearchVO();
            List<CustCdValidationVO> unmatchList = null;
            
            unmatchList = command.searchPreCheckForCodeAccuracyMatch(arrNtcSearchVO, account);
			eventResponse.setRsVoList(unmatchList);
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_1158 : Retrieve <br>
	 * Consignee, Notify Code의 정확도를 조회한다<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPreCheckForCodeAccuracyUnmatch(Event e) throws EventException{
		try{
			EsmBkg1158Event event = (EsmBkg1158Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			GeneralBookingListSearchBC command = new GeneralBookingListSearchBCImpl();
			
            ArrNtcSearchVO arrNtcSearchVO = event.getArrNtcSearchVO();
            List<CustCdValidationVO> unmatchList = null;
            
            unmatchList = command.searchPreCheckForCodeAccuracyUnmatch(arrNtcSearchVO, account);
			eventResponse.setRsVoList(unmatchList);
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * ESM_BKG_0079 : Retrieve <br>
	 * Consignee, Notify Code의 정확도를 조회한다<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBccSurcharge(Event e) throws EventException{
		try{
			EsmBkg0079Event event = (EsmBkg0079Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			BDRCorrectionBC bDRCorrectionBCImpl = new BDRCorrectionBCImpl();
			SurchargeAutoRatingBC surchargeAutoRatingBC = new SurchargeAutoRatingBCImpl();

			//미리 C/A kind를 알기 위해 추가
			add1stCaHist(event.getBkgBlNoVO());
			
			BkgCorrectionVO bkgCorrectionVO = bDRCorrectionBCImpl.searchBkgCorrection(event.getBkgBlNoVO());
			if(bkgCorrectionVO.getCaRsnCd().equals("M")){
				// c/a kind가 A,B인 경우에는 BCC Auto-interface를 하지 않는다
				if(!((bkgCorrectionVO.getRtCorrFlg().equals("Y")
						|| bkgCorrectionVO.getChgTermCorrFlg().equals("Y")
						|| bkgCorrectionVO.getCaOtrRsnCorrFlg().equals("Y"))
			    		&& bkgCorrectionVO.getRcvdeTermCorrFlg().equals("N")
			    		&& bkgCorrectionVO.getRoutCorrFlg().equals("N")
			    		&& bkgCorrectionVO.getCustCorrFlg().equals("N")
			    		&& bkgCorrectionVO.getQtyCorrFlg().equals("N")
			    		&& bkgCorrectionVO.getMeasQtyCorrFlg().equals("N")
			    		&& bkgCorrectionVO.getCmdtCorrFlg().equals("N")
			    		&& bkgCorrectionVO.getTrnkVslCorrFlg().equals("N")
			    		&& bkgCorrectionVO.getPrpstVslCorrFlg().equals("N"))){
					BkgSurchargeRateVO bkgSurchargeRateVO = surchargeAutoRatingBC.searchSurchargeRatingByBcc(event.getBkgBlNoVO().getBkgNo(), "Y", account);
					if(bkgSurchargeRateVO!=null){
						eventResponse.setETCData("curr_cd", bkgSurchargeRateVO.getCurrCd());
						eventResponse.setETCData("scg_amt", bkgSurchargeRateVO.getScgAmt());				
					}
				}
			}
			return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	
    /**
     * 조회 이벤트 처리<br>
     * ServiceProvider 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     * @author wonjoo, cho
     * @date 2013.05.21
     */
    private EventResponse searchCustomerList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1159Event event = (EsmBkg1159Event)e;
        try {
        	GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();

        	// custCd, custNm, ofcCd, iPage, include, cust
            eventResponse.setRsVoList(command.searchCustomerList(event.getSearchCustomerInqryCondVO(),event.getIPage(),event.getCustCd(),event.getCust()));
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;    
	}
    
    /**
     * Booking Customer 화면에서 Customer Code Request를 한 History를 생성한다<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     * @author DYRYU
     * @date 2013.11.19
     */
    private EventResponse createCustCodeRequestHistory(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0957Event event = (EsmBkg0957Event)e;
        try {
    		BookingHistoryMgtBC  command = new BookingHistoryMgtBCImpl();
        	HistoryLineVO historyLineVO = new HistoryLineVO();
			historyLineVO.setBkgNo         (event.getBkgNo());
			historyLineVO.setUiId          ("ESM_BKG_0079_05");
			if(event.getCustTpCd().equals("S")){
				historyLineVO.setCrntCtnt  ("Shipper Code Requested");
			} else if(event.getCustTpCd().equals("C")){
				historyLineVO.setCrntCtnt  ("Consignee Code Requested");
			} else if(event.getCustTpCd().equals("N")){	
				historyLineVO.setCrntCtnt  ("Notify Code Requested");
			}
			historyLineVO.setHisCateNm     ("Customer Code");
			command.createBkgHistoryLine(historyLineVO, account);
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
        
    /**
	 * ESM_BKG_0102 : Stand by, Firm click <br>
	 * Stand by->Firm,Firm->Stand by 처리. <br>
	 * 
	 * @author DYRYU
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyAllocStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0102Event event = (EsmBkg0102Event)e;
		GeneralBookingReceiptBC receiptBC  = new GeneralBookingReceiptBCImpl();
		GeneralBookingSearchBC  searchBC   = new GeneralBookingSearchBCImpl();
		EBookingReceiptBC       eBookingBC = new EBookingReceiptBCImpl();
		ConstraintMasterBC      spcBC      = new ConstraintMasterBCImpl();
		
		String firmMsgFlg = "N";
		try{
			begin();
			AllocStsVO allocStsVO = event.getAllocStsVO();
			BkgBlNoVO bkgBlNoVO = event.getBkgBlNoVO();
			
			// 01. Change Booking Status
			AllocStsChgVO allocStsChgVO = receiptBC.modifyAllocStatus(allocStsVO, bkgBlNoVO, account);
			List<BkgNtcHisVO> bkgNtcHisVOs1 = allocStsChgVO.getBkgNtcHisVOs();

			// 02. BookingHistoryMgtBC의 createBkgHistoryLine 호출	
			BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
			
			if (null!=bkgNtcHisVOs1) {
				historyBC.createBkgNtcHis(bkgNtcHisVOs1, "ESM_BKG_0079_01");
			}
			
			HistoryLineVO historyLineVO = new HistoryLineVO();
			historyLineVO.setUiId("ESM_BKG_0102");			
			historyLineVO.setHisCateNm("Booking Status");
			historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
			historyLineVO.setCaFlg(bkgBlNoVO.getCaFlg());
			
			// Allocation Status History
			if (allocStsChgVO == null || allocStsChgVO.getAlocStsCd() == null){
				log.debug("Null Check");
			} else if ((allocStsChgVO.getOriAlocStsCd() == null || "".equals(allocStsChgVO.getOriAlocStsCd())) && "S".equals(allocStsChgVO.getAlocStsCd())){
				historyLineVO.setCrntCtnt("Allocation Status change to S");
				historyBC.createBkgHistoryLine(historyLineVO, account);
			} else if ((allocStsChgVO.getOriAlocStsCd() == null || "".equals(allocStsChgVO.getOriAlocStsCd())) && "F".equals(allocStsChgVO.getAlocStsCd())){
				historyLineVO.setCrntCtnt("Allocation Status change to F");
				historyBC.createBkgHistoryLine(historyLineVO, account);	
			} else if ( "F".equals(allocStsChgVO.getOriAlocStsCd()) && "S".equals(allocStsChgVO.getAlocStsCd()) ){
				historyLineVO.setCrntCtnt("Allocation Status change F to S");
				historyBC.createBkgHistoryLine(historyLineVO, account);
			} else if ( "S".equals(allocStsChgVO.getOriAlocStsCd()) && "F".equals(allocStsChgVO.getAlocStsCd()) ){
				historyLineVO.setCrntCtnt("Allocation Status change S to F");
				historyBC.createBkgHistoryLine(historyLineVO, account);
			}	
			// Allocation Status History 끝
			commit();
			
			if(allocStsChgVO != null && allocStsChgVO.getFirmMsgFlg()!=null){
				firmMsgFlg = allocStsChgVO.getFirmMsgFlg();
			}
			
			// [CHM-201539585] Firm 이든 Standby 든 SPC Allocation 관련 메서드 호출
			// ALOC_STS_CD Firm 일 때 SPC Allocation 관련 메서드 호출
			//if (allocStsChgVO!=null && allocStsChgVO.getAlocStsCd()!=null && "F".equals(allocStsChgVO.getAlocStsCd())){
				SpcSbBkgVO spcSbBkgVO = new SpcSbBkgVO();
				spcSbBkgVO.setBkgNo(bkgBlNoVO.getBkgNo());
				spcSbBkgVO.setCfmUsrId(account.getUsr_id());
				spcBC.multiSpcSbBk(spcSbBkgVO);
			//}
			
			if (!"S".equals(allocStsVO.getAlocStsCd())){
				// Allocation Status S->F 이면 Reciept Notice 발송, 이 땐 RcvrEml 에 값 있음
				if(allocStsChgVO!=null && allocStsChgVO.getRcvrEml() != null && allocStsChgVO.getRcvrEml().length() > 0){
					begin();
					String mrdNm = "ESM_BKG_5005G";
					
					BkgBlNoVO[] bkgBlNoVOs = {bkgBlNoVO};
					String[]    eml        = {allocStsChgVO.getRcvrEml()};
					String[]    cct        = {""};
					String[]    docCct     = {""};
					String[]    rmk        = {""};
					
					BkgReceiptSendVO bkgReceiptSendVO = new BkgReceiptSendVO();
					bkgReceiptSendVO.setBkgBlNoVos(bkgBlNoVOs);
					bkgReceiptSendVO.setEmlAddrs(eml);
					bkgReceiptSendVO.setRemarks(rmk);
					bkgReceiptSendVO.setMrdNm(mrdNm);
					bkgReceiptSendVO.setCcts(cct);
					bkgReceiptSendVO.setDocCcts(docCct);
					GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
					List<BkgNtcHisVO> bkgNtcHisVOs2 = command.sendBkgReceiptByEmail(bkgReceiptSendVO, "", account);
					historyBC.createBkgNtcHis(bkgNtcHisVOs2, "ESM_BKG_0102");	
					commit();
				}
				// e-BKG Notice
				if( (allocStsChgVO!=null && allocStsChgVO.getNtcKndCd()!=null && "BK".equals(allocStsChgVO.getNtcKndCd())) // S->F, 이렇게 update 된 경우엔 BK 임
					&&(allocStsVO.getDocTpCd()!=null && ("B".equals(allocStsVO.getDocTpCd())||"S".equals(allocStsVO.getDocTpCd())||"U".equals(allocStsVO.getDocTpCd()))) //0229_01 에서 호출한 경우
					&&(allocStsVO.getAutoNotification()!=null && "Y".equals(allocStsVO.getAutoNotification())) // AutoNotification 설정됨, e-BKG 에서 줌 
								){
					eBookingBC.sendXterRqstAllocationNotice(allocStsVO, bkgBlNoVO, account);
					firmMsgFlg = "N";
				}
				
				if (allocStsChgVO!=null && allocStsChgVO.getEdiHldFlg()!=null && !"Y".equals(allocStsChgVO.getEdiHldFlg())) {		
					if ((allocStsChgVO!=null && allocStsChgVO.getNtcKndCd() != null && allocStsChgVO.getNtcKndCd().equals("BK"))){
						// EDI 가 이중으로 나갈 우려가 있어, 위 조건 일 때만 발송 함
						
						begin();
						// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
						Vender301ParamVO vender301ParamVO = new Vender301ParamVO(); 
						vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
						vender301ParamVO.setOldVvdVOs(null);
						vender301ParamVO.setOldQtyVOs(null);
						vender301ParamVO.setOldMtyPkupYdCd(null);
						vender301ParamVO.setBracCd("U");
						vender301ParamVO.setEdiKind("BT"); 
						vender301ParamVO.setAutoManualFlg("Y");
						searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);	
						
						commit();
						// backEnd 전에 commit 해야 함
						// customer301 전송 
						searchBC.createCustBkgReceiptEdiBackEnd(bkgBlNoVO, null, "Y", account);						
					}
				}
			}
			
			eventResponse.setETCData("isSuccess","Y");
			eventResponse.setETCData("firm_msg_flg",firmMsgFlg);
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
		return eventResponse;
	}
    
	/**
	 * ESM_BKG_1507 : open <br>
	 * Allocation Stand by Reason 조회 <br>
	 * 
	 * @author Dongsun Moon
	 * @param Event e
	 * @return	 EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAlocStandbyReason(Event e) throws EventException{
		try{
			EsmBkg1507Event event = (EsmBkg1507Event)e;
			GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			String bkg_no = JSPUtil.getNullNoTrim(event.getBkgNo());
			
			AlocStandbyReasonVO stsVO = searchBC.searchAlocStsCdByBkgNo(bkg_no);
			if(stsVO == null){
				eventResponse.setETCData("ALOC_STS_CD",    "");
				eventResponse.setETCData("ALOC_SVC_CD",    "");
				eventResponse.setETCData("BKG_ALOC_TP_CD", "");
			} else {
				eventResponse.setETCData("ALOC_STS_CD",    JSPUtil.getNullNoTrim(stsVO.getAlocStsCd()));
				eventResponse.setETCData("ALOC_SVC_CD",    JSPUtil.getNullNoTrim(stsVO.getAlocSvcCd()));
				eventResponse.setETCData("BKG_ALOC_TP_CD", JSPUtil.getNullNoTrim(stsVO.getBkgAlocTpCd()));
			}
			
			List<AlocStandbyReasonVO> truckList = searchBC.searchAlocStandbyReasonTruck(bkg_no);
			List<AlocStandbyReasonVO> tsList    = searchBC.searchAlocStandbyReasonTs(bkg_no);
			List<AlocStandbyReasonVO> eqList    = searchBC.searchAlocStandbyReasonEq(bkg_no);
			List<AlocStandbyReasonVO> custList  = searchBC.searchAlocStandbyReasonCust(bkg_no);
			
			eventResponse.setRsVoList(truckList);
			eventResponse.setRsVoList(tsList);
			eventResponse.setRsVoList(eqList);
			eventResponse.setRsVoList(custList);
			
			return eventResponse;			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex); 
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
	}
	
	/**
	 * SLS_REP_CD 로 OFC_CD 정보를 조회한다.(ESM_BKG_0079_01)<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPrntOfcCdBySRepCd(Event e) throws EventException {
		GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg007901Event event = (EsmBkg007901Event) e;
		BkgBookingInfoVO bkgBookingInfoVO = null;
		try {
			bkgBookingInfoVO = event.getBkgBookingInfoVO();
			String obSrepCd = bkgBookingInfoVO.getObSrepCd();
			String prntOfcCd = searchBC.searchPrntOfcCdBySRepCd(obSrepCd);
			eventResponse.setETCData("prnt_ofc_cd",prntOfcCd);
       } catch(EventException ex) {
           throw ex;
       } catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
       }
       return eventResponse;
    }	
	
	/**
	 * ESM_BKG_0269 : : Retrieve<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String sc_no
	 * @param SignOnUserAccount account
	 * @return OftPrecheckVO
	 * @throws EventException
	 */
	public OftPrecheckVO searchScOftPrecheckResult(BkgBlNoVO bkgBlNoVO, String sc_no, SignOnUserAccount account) throws EventException{
		if(account==null){
			account = new SignOnUserAccount("BATCH" ,"" ,"" ,""      ,""
	                ,""      ,"" ,"" ,"BATCH" ,""
	                ,"BATCH" ,"" ,"" ,""      ,""
	                ,""      ,"" ,"" ,""      ,""
	                ,""      ,""
						);
		}
		try{
			OftPrecheckVO oftPrecheckVO = new OftPrecheckVO();
			//EsmBkg0269Event   event = (EsmBkg0269Event)e;
			//GeneralEventResponse eventResponse = new GeneralEventResponse();
			ScOftAutoRatingBC autoratingBC = new ScOftAutoRatingBCImpl();
			BlRatingBC blRatingBC = new BlRatingBCImpl();
			UnmatchBLBC unmatchBC = new UnmatchBLBCImpl();
			UnmatchBLVO unmatchBLVO = new UnmatchBLVO();
			List<ServiceScopeVO> scope = null;
			List<SearchScOftAutoratingListVO> list = null;
			String applicationDt = "";
	        String bkg_no = "";
	        String caflag = "";
	        String scpcd  = "";
	        String scNo = "";
			String chkOft = "N";
			String noRtStsCd = "";
			String frtTermCd = "";
			
			if(bkgBlNoVO.getCaFlg()==null || bkgBlNoVO.getCaFlg().equals("")){
				bkgBlNoVO.setCaFlg("N");
			}
			
//	        begin();
//			//B/L No 로 BkgNo, ctrtTpCD 를 조회 // 쿼리엔 bl_no 로 param 값 되어 있지만 bkg_no 를 줘야 함
	        unmatchBLVO= unmatchBC.searchBkgCaFlg(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getCaFlg());
	        
			//Rate Application Date 조회
			if(unmatchBLVO != null){
		        bkg_no = unmatchBLVO.getBkgNo();
		        caflag = unmatchBLVO.getCaFlg();	
		        scpcd  = unmatchBLVO.getSvcScpCd();
		        frtTermCd = unmatchBLVO.getFrtTermCd();
		        //scNo = event.getscNo();
		        scNo = sc_no;
			}         
			
			applicationDt = autoratingBC.searchPreCheckRtAplyDt(bkg_no, caflag);
	        String rtaplydt = applicationDt;
	        scope = blRatingBC.searchServiceScopeList(bkg_no, caflag);   // 복수 Scope 조회


        	for(int i =0; i< scope.size(); i++){
        		if("N".equals(chkOft)){
        			scpcd = scope.get(i).getSvcScpCd();
        			
		        	/* (1) TPE, TJE, MXE, ACE => TPE => TPS
					 * (2) TPW,      MXW, ACW => TPW => TPS
					 * (3) TAE, ASE, SAS => TAE  (2012.6.13 부로 MME 삭제됨)
					 * (4) TAW, ASW, SAN    => TAW
					 * (5) OTHER        => ETC
		        	 */

		        	if("TPE".equals(scpcd)|"TPW".equals(scpcd)|"TJE".equals(scpcd)|"MXE".equals(scpcd)|"ACE".equals(scpcd)|"MXW".equals(scpcd)|"ACW".equals(scpcd)){
		        		 list = autoratingBC.searchScTPSOftAutoratingList(bkg_no,caflag,scNo,rtaplydt,scpcd,"","");			        	
		        	}else if("TAE".equals(scpcd)|"ASE".equals(scpcd)|"SAS".equals(scpcd)){		
		        		list = autoratingBC.searchScTAEOftAutoratingList(bkg_no,caflag,scNo,rtaplydt,scpcd,"","");			        	
		        	}else if("TAW".equals(scpcd)|"ASW".equals(scpcd)|"SAN".equals(scpcd)){		        		
		       		 	list = autoratingBC.searchScTAWOftAutoratingList(bkg_no,caflag,scNo,rtaplydt,scpcd,"","");			        	
		        	}else{		        		
		       		 	list = autoratingBC.searchScETCOftAutoratingList(bkg_no,caflag,scNo,rtaplydt,scpcd,"","");
		        	}
		        	// 결과값 셋팅 
		
		        	//SC charge 생성
		        	unmatchBC.createScSurchargeInput(bkg_no, caflag, list, account);
		        	//SC OFT계산결과를 체크
		        	if(autoratingBC.checkOftRateMatch(bkg_no, caflag)!=null)
		        		chkOft = "Y";
        		}
        	}	


        	if("Y".equals(chkOft)){
        		blRatingBC.moidfyOftPrecheckResult(bkg_no, caflag, "N", account);
        		noRtStsCd = "F";
        	}else{
        		blRatingBC.sendRateCheckNotice(bkg_no, account);
        		blRatingBC.moidfyOftPrecheckResult(bkg_no, caflag, "Y", account);
        		noRtStsCd = "R";
        	}

        	//commit();
        	
//        	eventResponse.setETCData("chk_oft", chkOft);
//        	eventResponse.setETCData("application_dt", applicationDt);
//        	eventResponse.setETCData("frt_term_cd", unmatchBLVO.getFrtTermCd());
//        	eventResponse.setETCData("svc_scp_cd", unmatchBLVO.getSvcScpCd());
//        	
//			return eventResponse;
        	
        	oftPrecheckVO.setNonRtStsCd(noRtStsCd);
			oftPrecheckVO.setChkOft(chkOft);
			oftPrecheckVO.setApplicationDt(applicationDt);
			oftPrecheckVO.setFrtTermCd(frtTermCd);
			oftPrecheckVO.setSvcScpCd(scpcd);
        	
        	return oftPrecheckVO;
			
		}catch(EventException ex){
			//rollback();
			throw ex;
		}catch(Exception ex){
			//rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_0739 : : Retrieve<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String rfa_no 
	 * @param SignOnUserAccount account
	 * @return OftPrecheckVO
	 * @throws EventException
	 */
	public OftPrecheckVO searchRfaOftPrecheckResult(BkgBlNoVO bkgBlNoVO, String rfa_no, SignOnUserAccount account) throws EventException{
		if(account==null){
			account = new SignOnUserAccount("BATCH" ,"" ,"" ,""      ,""
	                ,""      ,"" ,"" ,"BATCH" ,""
	                ,"BATCH" ,"" ,"" ,""      ,""
	                ,""      ,"" ,"" ,""      ,""
	                ,""      ,""
						);
		}
		try{
			OftPrecheckVO oftPrecheckVO = new OftPrecheckVO();
			//EsmBkg0739Event   event = (EsmBkg0739Event)e;
			//GeneralEventResponse eventResponse = new GeneralEventResponse();
			RfaOftAutoRatingBC command = new RfaOftAutoRatingBCImpl();
			//ScOftAutoRatingBC surBC = new ScOftAutoRatingBCImpl();
			BlRatingBC blRatingBC = new BlRatingBCImpl();
			UnmatchBLBC unmatchBC = new UnmatchBLBCImpl();
			UnmatchBLVO unmatchBLVO = new UnmatchBLVO();
			List<SearchRfaOftAutoratingListVO> list = null;
			List<ServiceScopeVO> scope = null;
			String applicationDt = "";
	        String bkg_no = "";
	        String caflag = "";
	        String scpcd  = "";
	        String rfaNo = "";
			String chkOft = "N";
			String cmdtCd = "";
			String noRtStsCd = "";
			String frtTermCd = "";
			
			if(bkgBlNoVO.getCaFlg()==null || bkgBlNoVO.getCaFlg().equals("")){
				bkgBlNoVO.setCaFlg("N");
			}
			
	        //begin();
			//B/L No 로 BkgNo, ctrtTpCD 를 조회 
	        unmatchBLVO= unmatchBC.searchBkgCaFlg(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getCaFlg());
			
			//Rate Application Date 조회
			if(unmatchBLVO != null){
		        bkg_no = unmatchBLVO.getBkgNo();
		        caflag = unmatchBLVO.getCaFlg();	
		        scpcd  = unmatchBLVO.getSvcScpCd();
		        frtTermCd = unmatchBLVO.getFrtTermCd();
		        //rfaNo = event.getrfaNo();
		        //cmdtCd = event.getCmdtcd(); // 기존도 화면에서 호출 시 cmdt_cd 를 보내지 않았음
		        rfaNo = rfa_no;
			}
            
			applicationDt = command.searchPreCheckRtAplyDt(bkg_no, caflag);
			String hinterFlg = command.searchHinterlandApplyFlag(applicationDt, bkg_no, caflag);
	        String rtaplydt = applicationDt;
	        scope = blRatingBC.searchServiceScopeList(bkg_no, caflag);   // 복수 Scope 조회
	        
	        for(int i =0; i< scope.size(); i++){
        		if("N".equals(chkOft)){
        			scpcd = scope.get(i).getSvcScpCd();

			        if ("FIC".equals(hinterFlg)) {
						list = command.searchRfaFICOftAutoratingList(bkg_no, caflag, rfaNo, rtaplydt, scpcd, cmdtCd);
					} else if ("AEE".equals(scpcd) && "Y".equals(hinterFlg)) {
						list = command.searchRfaAEEOftAutoratingList(bkg_no, caflag, rfaNo, rtaplydt, scpcd, cmdtCd);
					} else if ("AEW".equals(scpcd) && "Y".equals(hinterFlg)) {
						list = command.searchRfaAEWOftAutoratingList(bkg_no, caflag, rfaNo, rtaplydt, scpcd, cmdtCd);
					} else {
						list = command.searchRfaOftAutoratingList(bkg_no, caflag, rfaNo, rtaplydt, scpcd, cmdtCd);
					}
		        	// 결과값 셋팅 
		
		        	//SC charge 생성
		        	unmatchBC.createRfaSurchargeInput(bkg_no, list, account);
		        	//SC OFT계산결과를 체크
		        	if(command.checkOftRateMatch(bkg_no, caflag)!=null)
		        		chkOft = "Y";
		        	
        		}
	        }
	        

        	if("Y".equals(chkOft)){
        		blRatingBC.moidfyOftPrecheckResult(bkg_no, caflag, "N", account);
        		noRtStsCd = "F";
        	}else{
       			blRatingBC.sendRateCheckNotice(bkg_no, account);
        		blRatingBC.moidfyOftPrecheckResult(bkg_no, caflag, "Y", account);
        		noRtStsCd = "R";
        	}

        	//commit();
        	
//        	eventResponse.setETCData("chk_oft", chkOft);
//        	eventResponse.setETCData("application_dt", applicationDt);
//        	eventResponse.setETCData("frt_term_cd", unmatchBLVO.getFrtTermCd());
//        	eventResponse.setETCData("svc_scp_cd", unmatchBLVO.getSvcScpCd());
//        	
//			return eventResponse;
        	
        	oftPrecheckVO.setNonRtStsCd(noRtStsCd);
			oftPrecheckVO.setChkOft(chkOft);
			oftPrecheckVO.setApplicationDt(applicationDt);
			oftPrecheckVO.setFrtTermCd(frtTermCd);
			oftPrecheckVO.setSvcScpCd(scpcd);
        	
        	return oftPrecheckVO;

		}catch(EventException ex){
			//rollback();
			throw ex;
		}catch(Exception ex){
			//rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	
	/**
	 * ESM_BKG_1076 : : Retrieve<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String taa_no
	 * @param SignOnUserAccount account
	 * @return OftPrecheckVO
	 * @throws EventException
	 */
	public OftPrecheckVO searchTaaOftPrecheckResult(BkgBlNoVO bkgBlNoVO, String taa_no, SignOnUserAccount account) throws EventException{
		if(account==null){
			account = new SignOnUserAccount("BATCH" ,"" ,"" ,""      ,""
	                ,""      ,"" ,"" ,"BATCH" ,""
	                ,"BATCH" ,"" ,"" ,""      ,""
	                ,""      ,"" ,"" ,""      ,""
	                ,""      ,""
						);
		}
		try{
			OftPrecheckVO oftPrecheckVO = new OftPrecheckVO();
			//EsmBkg1076Event   event = (EsmBkg1076Event)e;
			//GeneralEventResponse eventResponse = new GeneralEventResponse();
			TaaOftAutoRatingBC command = new TaaOftAutoRatingBCImpl();
			BlRatingBC blRatingBC = new BlRatingBCImpl();
			UnmatchBLBC unmatchBC = new UnmatchBLBCImpl();
			UnmatchBLVO unmatchBLVO = new UnmatchBLVO();
			List<SearchTaaOftAutoratingListVO> list = null;
			List<ServiceScopeVO> scope = null;
			String applicationDt = "";
	        String bkg_no = "";
	        String caflag = "";
	        String scpcd  = "";
	        String taaNo = "";
			String chkOft = "N";
			String cmdtCd = "";
			String noRtStsCd = "";
			String frtTermCd = "";
			
			if(bkgBlNoVO.getCaFlg()==null || bkgBlNoVO.getCaFlg().equals("")){
				bkgBlNoVO.setCaFlg("N");
			}
			
	        //begin();
			//B/L No 로 BkgNo, ctrtTpCD 를 조회
	        unmatchBLVO= unmatchBC.searchBkgCaFlg(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getCaFlg());
	        
			//Rate Application Date 조회
			if(unmatchBLVO != null){
		        bkg_no = unmatchBLVO.getBkgNo();
		        caflag = unmatchBLVO.getCaFlg();	
		        scpcd  = unmatchBLVO.getSvcScpCd();
		        frtTermCd = unmatchBLVO.getFrtTermCd();
		        //taaNo = event.gettaaNo();
		        //cmdtCd = event.getCmdtcd(); // 기존도 화면에서 호출 시 cmdt_cd 를 보내지 않았음
		        taaNo = taa_no;
			}

			applicationDt = command.searchPreCheckRtAplyDt(bkg_no, caflag);
	        String rtaplydt = applicationDt;
	        scope = blRatingBC.searchServiceScopeList(bkg_no, caflag);   // 복수 Scope 조회
            
	        for(int i =0; i< scope.size(); i++){
        		if("N".equals(chkOft)){
        			scpcd = scope.get(i).getSvcScpCd();
	
			        list = command.searchTaaOftAutoratingList(bkg_no,caflag,taaNo,rtaplydt,scpcd,cmdtCd);
		
		        	//Taa charge 생성
		        	unmatchBC.createTaaSurchargeInput(bkg_no, list, account);
		        	//SC OFT계산결과를 체크
		        	if(command.checkOftRateMatch(bkg_no, caflag)!=null)
		        		chkOft = "Y";
	    		}
	        }
	        
        	if("Y".equals(chkOft)){
        		blRatingBC.moidfyOftPrecheckResult(bkg_no, caflag, "N", account);
        		noRtStsCd = "F";
        	}else{
        		blRatingBC.sendRateCheckNotice(bkg_no, account);
        		blRatingBC.moidfyOftPrecheckResult(bkg_no, caflag, "Y", account);
        		noRtStsCd = "R";
        	}

        	//commit();
        	
//        	eventResponse.setETCData("chk_oft", chkOft);
//        	eventResponse.setETCData("application_dt", applicationDt);
//        	eventResponse.setETCData("frt_term_cd", unmatchBLVO.getFrtTermCd());
//        	eventResponse.setETCData("svc_scp_cd", unmatchBLVO.getSvcScpCd());
//        	
//			return eventResponse;
			
			oftPrecheckVO.setNonRtStsCd(noRtStsCd);
			oftPrecheckVO.setChkOft(chkOft);
			oftPrecheckVO.setApplicationDt(applicationDt);
			oftPrecheckVO.setFrtTermCd(frtTermCd);
			oftPrecheckVO.setSvcScpCd(scpcd);
        	
        	return oftPrecheckVO;

		}catch(EventException ex){
			//rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}	

	/**
	 * CMPB 산출<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param OftPrecheckVO oftPrecheckVO
	 * @throws EventException
	 */
	public void createContributionMarginPerBox(BkgBlNoVO bkgBlNoVO, OftPrecheckVO oftPrecheckVO) throws EventException{
		if(account==null){
			account = new SignOnUserAccount("BATCH" ,"" ,"" ,""      ,""
	                ,""      ,"" ,"" ,"BATCH" ,""
	                ,"BATCH" ,"" ,"" ,""      ,""
	                ,""      ,"" ,"" ,""      ,""
	                ,""      ,""
						);
		}
		try{
			
			ScOftAutoRatingBC scBC = new ScOftAutoRatingBCImpl();
			RfaOftAutoRatingBC rfaBC = new RfaOftAutoRatingBCImpl();
			TaaOftAutoRatingBC taaBC = new TaaOftAutoRatingBCImpl();
			BlRatingBC blRatingBC = new BlRatingBCImpl();
			UnmatchBLBC unmatchBC = new UnmatchBLBCImpl();
			UnmatchBLVO unmatchBLVO = new UnmatchBLVO();
			BkgRevCostVO revCostVO = new BkgRevCostVO();
			List<BkgChgRateVO> revDtlVOs = new ArrayList<BkgChgRateVO>();
			com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBC masBC  = new com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBCImpl();
			String rtAplyDt = "";
	        String bkgNo = "";
	        String caFlg = "";
	        String ctrtTp = "";
	        String sglRevFlg = "Y";
			
	        
	        
			if(bkgBlNoVO.getCaFlg()==null || bkgBlNoVO.getCaFlg().equals("")){
				bkgBlNoVO.setCaFlg("N");
			}
			
	        //begin();
			//B/L No 로 BkgNo, ctrtTpCD 를 조회 
	        unmatchBLVO= unmatchBC.searchBkgCaFlg(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getCaFlg());
			
			//Rate Application Date 조회
			if(unmatchBLVO != null){
		        bkgNo = unmatchBLVO.getBkgNo();
		        caFlg = unmatchBLVO.getCaFlg();	
		        ctrtTp = unmatchBLVO.getCtrtTpCd();
			}
			
			if("S".equals(ctrtTp)){
				rtAplyDt = scBC.searchPreCheckRtAplyDt(bkgNo, caFlg);
			}else if("R".equals(ctrtTp)){
				rtAplyDt = rfaBC.searchPreCheckRtAplyDt(bkgNo, caFlg);
			}else {
				rtAplyDt = taaBC.searchPreCheckRtAplyDt(bkgNo, caFlg);
			}
			
			// No Rate Check시 OFT Rating결과를 TEMP 테이블에 INSERT한 상태이기 때문에 OFT Rating은 하지 않음 

			// CMPB대상 Revenue 삭제 전 Singel/Multi 운임 여부 확인
			if("M".equals(blRatingBC.searchGroupRatingStatus(bkgNo))){
				sglRevFlg = "N";  //Multi 운임인 경우 N
			}
			
        	// 1.Qty DTL 기준, Type Size&Cargo Type 별 최소 Revenue만 Temp에 남겨둠
        	blRatingBC.modifyChargeRateTempForCMPB(bkgNo);
        	//unmatchBC.createRevenueAuditOft();  // RFA RevenueAuditOft를 생성 : BKG_AUTO_RT_OCN_FRT_TMP => BKG_REV_AUD_CHG_TMP 입력
			//Temp DB에 OFT Insert
        	unmatchBC.createRevenueAuditOftForMultiRating(); 
        	
			// 2.Surcharge 계산
			ScOftAutoratingListVO surCmdVo = new ScOftAutoratingListVO();
			List<SearchScOftAutoratingListVO> surList = null;
			surCmdVo.setBkgNo(bkgNo);
			surCmdVo.setCaFlg(caFlg);
			surCmdVo.setRtAplyDt(rtAplyDt);
			surCmdVo.setsvcScpCd(oftPrecheckVO.getSvcScpCd());
			surCmdVo.setCtrtTpCd(ctrtTp);
			surCmdVo.setRtAudTpCd(""); // A로 넘겨야 Not Include 운임만 나옴
    		surList = scBC.searchSurchargeAutoratingList(surCmdVo);  // surchargeautorating 등록
    		unmatchBC.createRevenueAuditSurcharge(surList, account);  // BKG_REV_AUD_CHG_TMP 생성
    		
    		// 3.TEMP에 저장된 운임을 Application Date 기준  경리환률로  USD 환산하여 기존 REV와 비교 (Include 제외)
        	// if (이전에 산출한 Revenue가 현재 Revenue와 다르면 CMPB INSERT)
    		revCostVO.setBkgNo(bkgNo);
    		revCostVO.setRtAplyDt(rtAplyDt);
    		revCostVO.setCreUsrId(account.getUsr_id());
    		revCostVO.setUpdUsrId(account.getUsr_id());
    		revCostVO.setSglRevFlg(sglRevFlg);
    		
    		BkgRevCostVO revCostVO2 = blRatingBC.searchRevenueAmount(revCostVO);  // COA 호출 후 TEMP 테이블 값이 사라져서 조회 처리
    		if(revCostVO2!=null && revCostVO2.getRevAmt()!=null && revCostVO2.getOftAmt()!=null){
	    		revCostVO.setRevAmt(revCostVO2.getRevAmt());
	    		revCostVO.setOftAmt(revCostVO2.getOftAmt());
    		}
    		revDtlVOs = blRatingBC.searchRevenueAmountDetail(account);
    		
    		String diff = blRatingBC.checkRevenueAmountDifference(revCostVO);

    		log.debug("\n\n Revenue Amount ::: "+ (revCostVO.getRevAmt()!=null?revCostVO.getRevAmt():""));
    		
    		if("Y".equals(diff)){		
    			// 4.Cost 계산(COA 호출)
    			masBC.createCostAssignBkg(bkgBlNoVO.getPctlNo(), bkgBlNoVO.getPctlNo(), account.getUsr_id());
    			
	    		// 5.CMPB Insert   
	    		blRatingBC.createRevenueAmount(revCostVO);
	    		// 6.Revenue Detail Insert
	    		blRatingBC.createRevenueAmountDetail(revDtlVOs);
    		}
    		    		
    		// CMPB 산출을 위한 Rating 종료
        	
        	
		}catch(EventException ex){
			//rollback();
			throw ex;
		}catch(Exception ex){
			//rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}	
	
	/**
	 * CMPB 산출<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param OftPrecheckVO oftPrecheckVO
	 * @return BkgCmpbVO 
	 * @throws EventException
	 */
	public BkgCmpbVO createContributionMarginPerBox1(BkgBlNoVO bkgBlNoVO, OftPrecheckVO oftPrecheckVO) throws EventException{
		if(account==null){
			account = new SignOnUserAccount("BATCH" ,"" ,"" ,""      ,""
	                ,""      ,"" ,"" ,"BATCH" ,""
	                ,"BATCH" ,"" ,"" ,""      ,""
	                ,""      ,"" ,"" ,""      ,""
	                ,""      ,""
						);
		}
		try{
			
			ScOftAutoRatingBC scBC = new ScOftAutoRatingBCImpl();
			RfaOftAutoRatingBC rfaBC = new RfaOftAutoRatingBCImpl();
			TaaOftAutoRatingBC taaBC = new TaaOftAutoRatingBCImpl();
			BlRatingBC blRatingBC = new BlRatingBCImpl();
			UnmatchBLBC unmatchBC = new UnmatchBLBCImpl();
			BkgCmpbVO bkgCmpbVO = new BkgCmpbVO();
			UnmatchBLVO unmatchBLVO = new UnmatchBLVO();
			BkgRevCostVO revCostVO = new BkgRevCostVO();
			List<BkgChgRateVO> revDtlVOs = new ArrayList<BkgChgRateVO>();
			String rtAplyDt = "";
	        String bkgNo = "";
	        String caFlg = "";
	        String ctrtTp = "";
	        String sglRevFlg = "Y";
	        
			if(bkgBlNoVO.getCaFlg()==null || bkgBlNoVO.getCaFlg().equals("")){
				bkgBlNoVO.setCaFlg("N");
			}
			
	        //begin();
			//B/L No 로 BkgNo, ctrtTpCD 를 조회 
	        unmatchBLVO= unmatchBC.searchBkgCaFlg(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getCaFlg());
			
			//Rate Application Date 조회
			if(unmatchBLVO != null){
		        bkgNo = unmatchBLVO.getBkgNo();
		        caFlg = unmatchBLVO.getCaFlg();	
		        ctrtTp = unmatchBLVO.getCtrtTpCd();
			}
			
			if("S".equals(ctrtTp)){
				rtAplyDt = scBC.searchPreCheckRtAplyDt(bkgNo, caFlg);
			}else if("R".equals(ctrtTp)){
				rtAplyDt = rfaBC.searchPreCheckRtAplyDt(bkgNo, caFlg);
			}else {
				rtAplyDt = taaBC.searchPreCheckRtAplyDt(bkgNo, caFlg);
			}
			
			// No Rate Check시 OFT Rating결과를 TEMP 테이블에 INSERT한 상태이기 때문에 OFT Rating은 하지 않음 

			// CMPB대상 Revenue 삭제 전 Singel/Multi 운임 여부 확인
			if("M".equals(blRatingBC.searchGroupRatingStatus(bkgNo))){
				sglRevFlg = "N";  //Multi 운임인 경우 N
			}
			
        	// 1.Qty DTL 기준, Type Size&Cargo Type 별 최소 Revenue만 Temp에 남겨둠
        	blRatingBC.modifyChargeRateTempForCMPB(bkgNo);
        	//unmatchBC.createRevenueAuditOft();  // RFA RevenueAuditOft를 생성 : BKG_AUTO_RT_OCN_FRT_TMP => BKG_REV_AUD_CHG_TMP 입력
			//Temp DB에 OFT Insert
        	unmatchBC.createRevenueAuditOftForMultiRating(); 
        	
			// 2.Surcharge 계산
			ScOftAutoratingListVO surCmdVo = new ScOftAutoratingListVO();
			List<SearchScOftAutoratingListVO> surList = null;
			surCmdVo.setBkgNo(bkgNo);
			surCmdVo.setCaFlg(caFlg);
			surCmdVo.setRtAplyDt(rtAplyDt);
			surCmdVo.setsvcScpCd(oftPrecheckVO.getSvcScpCd());
			surCmdVo.setCtrtTpCd(ctrtTp);
			surCmdVo.setRtAudTpCd(""); // A로 넘겨야 Not Include 운임만 나옴
    		surList = scBC.searchSurchargeAutoratingList(surCmdVo);  // surchargeautorating 등록
    		unmatchBC.createRevenueAuditSurcharge(surList, account);  // BKG_REV_AUD_CHG_TMP 생성
    		
    		// 3.TEMP에 저장된 운임을 Application Date 기준  경리환률로  USD 환산하여 기존 REV와 비교 (Include 제외)
        	// if (이전에 산출한 Revenue가 현재 Revenue와 다르면 CMPB INSERT)
    		revCostVO.setBkgNo(bkgNo);
    		revCostVO.setRtAplyDt(rtAplyDt);
    		revCostVO.setCreUsrId(account.getUsr_id());
    		revCostVO.setUpdUsrId(account.getUsr_id());
    		revCostVO.setSglRevFlg(sglRevFlg);
    		
    		BkgRevCostVO revCostVO2 = blRatingBC.searchRevenueAmount(revCostVO);  // COA 호출 후 TEMP 테이블 값이 사라져서 조회 처리
    		if(revCostVO2!=null && revCostVO2.getRevAmt()!=null && revCostVO2.getOftAmt()!=null){
	    		revCostVO.setRevAmt(revCostVO2.getRevAmt());
	    		revCostVO.setOftAmt(revCostVO2.getOftAmt());
    		}
    		revDtlVOs = blRatingBC.searchRevenueAmountDetail(account);
    		
    		String diff = blRatingBC.checkRevenueAmountDifference(revCostVO);

    		log.debug("\n\n Revenue Amount ::: "+ (revCostVO.getRevAmt()!=null?revCostVO.getRevAmt():""));
    		
    		bkgCmpbVO.setDiffFlg(diff);
    		bkgCmpbVO.setBkgRevCostVO(revCostVO);
    		bkgCmpbVO.setBkgChgRateVOs(revDtlVOs);
  
//          // 2015.12.03 [CHM-201538812] MAS time out 방지위해 createContributionMarginPerBox2 로 분리해서 수행     		
//    		if("Y".equals(diff)){		
//    			// 4.Cost 계산(COA 호출)
//    			masBC.createCostAssignBkg(bkgBlNoVO.getPctlNo(), bkgBlNoVO.getPctlNo(), account.getUsr_id());
//    			
//	    		// 5.CMPB Insert   
//	    		blRatingBC.createRevenueAmount(revCostVO);
//	    		// 6.Revenue Detail Insert
//	    		blRatingBC.createRevenueAmountDetail(revDtlVOs);
//    		}
    		    		
    		// CMPB 산출을 위한 Rating 종료
        	
    		return bkgCmpbVO;
		}catch(EventException ex){
			//rollback();
			throw ex;
		}catch(Exception ex){
			//rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * CMPB 산출<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param BkgCmpbVO bkgCmpbVO
	 * @throws EventException
	 */
	public void createContributionMarginPerBox2(BkgBlNoVO bkgBlNoVO, BkgCmpbVO bkgCmpbVO) throws EventException{
		if(account==null){
			account = new SignOnUserAccount("BATCH" ,"" ,"" ,""      ,""
	                ,""      ,"" ,"" ,"BATCH" ,""
	                ,"BATCH" ,"" ,"" ,""      ,""
	                ,""      ,"" ,"" ,""      ,""
	                ,""      ,""
						);
		}
		try{
			BlRatingBC blRatingBC = new BlRatingBCImpl();
			com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBC masBC  = new com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBCImpl();
			
			String diff = bkgCmpbVO.getDiffFlg();
			BkgRevCostVO revCostVO = bkgCmpbVO.getBkgRevCostVO();//new BkgRevCostVO();
			List<BkgChgRateVO> revDtlVOs = bkgCmpbVO.getBkgChgRateVOs();//new ArrayList<BkgChgRateVO>();
    		
    		if("Y".equals(diff)){		
    			// 4.Cost 계산(COA 호출)
    			//masBC.createCostAssignBkg(bkgBlNoVO.getPctlNo(), bkgBlNoVO.getPctlNo(), account.getUsr_id());
    			masBC.createCostAssignBkg2(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getPctlNo(), bkgBlNoVO.getPctlNo(), account.getUsr_id());
    			
	    		// 5.CMPB Insert   
	    		blRatingBC.createRevenueAmount(revCostVO);
	    		// 6.Revenue Detail Insert
	    		blRatingBC.createRevenueAmountDetail(revDtlVOs);
    		}
    		// CMPB 산출을 위한 Rating 종료
        	
		}catch(EventException ex){
			//rollback();
			throw ex;
		}catch(Exception ex){
			//rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * 화주에게 전송하는 No Rate Notic 메일 내용을 반환한다. <br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String getNoRateNoticeToCustomer(String bkgNo) throws Exception {
		GeneralBookingReceiptBC receiptBC   = new GeneralBookingReceiptBCImpl();
		StringBuffer contentSb = new StringBuffer();
				
		try {
			String reqNo = "";
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(bkgNo);
			String custRefNoCtnt = receiptBC.searchCustRefNoCtnt(bkgBlNoVO, "EBRF");
			if(custRefNoCtnt != null && custRefNoCtnt.length()>0){
				reqNo = "(Request No. "+custRefNoCtnt+")";
			}else{//BKG Request no. 없으면 BKG no.
				reqNo = "(Booking No. "+bkgNo+")";
			}
			
			contentSb.append("<b>Customer Notice ").append(reqNo).append("</b>");
			
			contentSb.append("<br><br>Dear Customer, ");
			
			contentSb.append("<br><br>Please be informed that your booking(s) below are received but, ");
			contentSb.append("<br>requires further review. ");
			contentSb.append("<br>- ").append(reqNo);
			
			contentSb.append("<br><br>Please contact your local sales representative for assistance.  ");
			
			contentSb.append("<br><br><br>SM Line Corporation");

			
		} catch (Exception e) {
			log.error(e.toString());
		}
		return contentSb.toString();
	}
	
	/**
	 * S.rep에게 전송하는 No Rate Notice 메일 내용을 반환한다. <br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String getNoRateNoticeToSrep(String bkgNo) throws Exception {
		GeneralBookingReceiptBC receiptBC   = new GeneralBookingReceiptBCImpl();
		StringBuffer contentSb = new StringBuffer();
				
		try {
			String reqNo = "";
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(bkgNo);
			String custRefNoCtnt = receiptBC.searchCustRefNoCtnt(bkgBlNoVO, "EBRF");
			if(custRefNoCtnt != null && custRefNoCtnt.length()>0){
				reqNo = " (Request No. "+custRefNoCtnt+")";
			}
			
			contentSb.append("<b>SM Line No rate booking Notice (Booking No. ").append(bkgNo).append(")</b>");
			
			contentSb.append("<br><br>Please be informed booking request has been submitted by customer, but due to no available rate,");
			contentSb.append("<br>Booking No. ").append(bkgNo).append(reqNo).append(" is under 'No Rate' status.");

			contentSb.append("<br><br>No Rate bookings are subject to the following:");
			
			contentSb.append("<br><br>1. Empty Container(s) can not be released.");
			contentSb.append("<br>2. Door Dispatch can not be released.");
			contentSb.append("<br>3. If applicable rate is not provided 2 calendar days prior to ETB at POL, booking will be auto-cancelled.");
			
			contentSb.append("<br><br>Please urgently confirm with customer and have applicable rate under Service Contract to prevent above restrictions.");
			
			contentSb.append("<br><br><br>SM Line Corporation");			
			
		} catch (Exception e) {
			log.error(e.toString());
		}
		return contentSb.toString();
	}
	
	/**
	 * Customer 를 고려하여 Sc NO 유효성 검사
	 * 
	 * @param e
	 *            Event
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchScAvailableCust(Event e) throws EventException {
		EsmBkg007901Event event = (EsmBkg007901Event) e;
		BookingUtil command = new BookingUtil();
		GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			BkgBlNoVO        bkgBlNoVO        = event.getBkgBlNoVO();
			BkgBookingInfoVO bkgBookingInfoVO = event.getBkgBookingInfoVO();
			BlCustomerInfoVO blCustomerInfoVO = event.getBlCustomerInfoVO();
			
			String scNo = bkgBookingInfoVO.getScNo();
			
			String scAvailable = "Y";
			if (!command.searchScAvailable(scNo, bkgBlNoVO)) {//기간체크
				scAvailable = "N";
			}
			if(scAvailable.equals("Y")){
				ScListInputVO scListInputVO = new ScListInputVO();
				if("ESM_BKG_0079_08".equals(bkgBlNoVO.getPageType())){
					scListInputVO = searchBC.searchScListInput(event.getBkgBlNoVO());
					scListInputVO.setScNo(bkgBookingInfoVO.getScNo()); 
				}else{
					scListInputVO.setBkgNo(bkgBlNoVO.getBkgNo());                 //BkgNo
					scListInputVO.setBkgVvd(bkgBookingInfoVO.getBkgTrunkVvd());   //TrunkVvd
					scListInputVO.setPorCd(bkgBookingInfoVO.getBkgPorCd());       //POR
					scListInputVO.setDelCd(bkgBookingInfoVO.getBkgDelCd());       //DEL
					scListInputVO.setSCustCntCd(blCustomerInfoVO.getSCustCntCd());//SHPR CNT
					scListInputVO.setSCustSeq(blCustomerInfoVO.getSCustSeq());    //SHPR SEQ
					scListInputVO.setCCustCntCd(blCustomerInfoVO.getCCustCntCd());//CNEE CNT
					scListInputVO.setCCustSeq(blCustomerInfoVO.getCCustSeq());    //CNEE SEQ
					scListInputVO.setScNo(bkgBookingInfoVO.getScNo());            //ScNo
				}
				if(scListInputVO.getSCustSeq()==null || "".equals(scListInputVO.getSCustSeq())){
					scListInputVO.setSCustCntCd("");
				}
				if(scListInputVO.getCCustSeq()==null || "".equals(scListInputVO.getCCustSeq())){
					scListInputVO.setCCustCntCd("");
				}
				scAvailable = searchBC.searchScAvailableCust(scListInputVO);//customer 체크
			}
			eventResponse.setETCData("sc_available", scAvailable);
			return eventResponse;

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_1182 조회 이벤트 처리 (ESM_BKG_0369 와 유사)<br>
	 * Booking Attachment 정보 list를 조회 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * @author 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBlRiderList(Event e) throws EventException {
		log.debug("[START:: GeneralBookingConductSC == searchBlRiderList SEARCH ]==========");
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialCargoRiderBC command = new SpecialCargoRiderBCImpl();

		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		EsmBkg1182Event event = (EsmBkg1182Event)e;
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
	 * ESM_BKG_1182 저장 이벤트 처리 (ESM_BKG_0369 와 유사)<br>
	 * Booking Attachment 정보를 생성 처리<br>
	 * @author LEE JIN SEO
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBlRider(Event e) throws EventException {
		log.debug("[START:: GeneralBookingConductSC == manageBlRider SEARCH ]==========");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialCargoRiderBC command = new SpecialCargoRiderBCImpl();
		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		EsmBkg1182Event event = (EsmBkg1182Event)e;
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
	 * ESM_BKG_1183 Estimated CMPT 팝업창 띄우기를 위한 메소드<br>
	 * Estimated CMPB 팝업창 생성<br>
	 * @author DONG HUN YANG
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchEstimatedCMPB(Event e) throws EventException{
		log.debug("[START:: GeneralBookingConductSC == searchEstimatedCMPB SEARCH ]==========");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		EsmBkg1183Event event = (EsmBkg1183Event)e;
		List<EstimatedCMPBVO> list =command.searchEstimatedCMPB(event.getBkgNo());
		eventResponse.setRsVoList(list);
		return eventResponse;
		
	}
	
	/**
	 * CMPT 계산<br>
	 * <br>
	 * @author 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse createRevCost(Event e) throws EventException{
		log.debug("[START:: GeneralBookingConductSC == createRevCost ]==========");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil util = new BookingUtil();
//		List<EstimatedCMPBVO> list =command.searchEstimatedCMPB(event.getBkgNo());
		
		BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
		bkgHrdCdgCtntListCondVO.setHrdCdgId("MAKE_BKG_REV_COST");			
		List<BkgHrdCdgCtntVO> BkgHrdCdgCtntVOs = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
		
		int cnt = 0;
		for(int i =0; i<BkgHrdCdgCtntVOs.size() ; i++){
			
			String bkg_no = BkgHrdCdgCtntVOs.get(i).getAttrCtnt1(); // BKG_NO
			String sc_no  = BkgHrdCdgCtntVOs.get(i).getAttrCtnt2(); // SC_NO
			String rfa_no = BkgHrdCdgCtntVOs.get(i).getAttrCtnt3(); // RFA_NO
			String taa_no = BkgHrdCdgCtntVOs.get(i).getAttrCtnt4(); // TAA_NO
			String pctl_no = BkgHrdCdgCtntVOs.get(i).getAttrCtnt5(); // PCTL_NO
			String delt_flg = BkgHrdCdgCtntVOs.get(i).getAttrCtnt10(); // DELT_FLG
			
			if(!"Y".equals(delt_flg)){
				BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
				bkgBlNoVO.setBkgNo(bkg_no); 
				bkgBlNoVO.setPctlNo(pctl_no); 
				bkgBlNoVO.setCaFlg("N"); 
				
				try{//기존 별도 트랜젝션으로 화면에서 호출 하던 부분	
					begin();
					OftPrecheckVO oftPrecheckVO = new OftPrecheckVO();
					if(rfa_no!=null && rfa_no.length() > 2 ){
						oftPrecheckVO = searchRfaOftPrecheckResult(bkgBlNoVO, rfa_no, account);
					}else if(sc_no!=null && sc_no.length() > 2 ){
						oftPrecheckVO = searchScOftPrecheckResult(bkgBlNoVO, sc_no, account);
					}else if(taa_no!=null && taa_no.length() > 2 ){
						oftPrecheckVO = searchTaaOftPrecheckResult(bkgBlNoVO, taa_no, account);
					}else{
						oftPrecheckVO.setNonRtStsCd("R");
						oftPrecheckVO.setChkOft("");
						oftPrecheckVO.setApplicationDt("");
						oftPrecheckVO.setFrtTermCd("");
						oftPrecheckVO.setSvcScpCd("");
					}

					// CMPB 산출 대상인 경우 실행하도록 변경 필요
					if("Y".equals(oftPrecheckVO.getChkOft()) ){
						// MAS time out 방지위해 1,2 로 나눔
						BkgCmpbVO BkgCmpbVO = createContributionMarginPerBox1(bkgBlNoVO, oftPrecheckVO);
						commit();
						begin();
						createContributionMarginPerBox2(bkgBlNoVO,BkgCmpbVO);
						commit();
						cnt = cnt+1;
					}else{
						commit();
					}
					
				}catch(EventException ex){
					log.error("No Rate Status check Error : Manual", ex);
					rollback();
				}
			}
//			if(cnt>1000){
//				break;
//			}
		}
		eventResponse.setETCData("count", Integer.toString(cnt));
		return eventResponse;
	}
	
	/**
	 * BKG Cancel 전 Reefer Request Cancel <br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @throws EventException
	 */
	public void cancelRfCgoApro(BkgBlNoVO bkgBlNoVO) throws EventException{
		try{
	        SpecialCargoReceiptBC command = new SpecialCargoReceiptBCImpl();
	        OwnDangerousCargoApprovalBC ownCmd = new OwnDangerousCargoApprovalBCImpl();  
	        
	        String spclCgoTp = "R";
	        String scgFlg = "RF";
	        //String strSpclCgo = "";
	        SpclCgoAproApplVO spclCgoAproApplVO = new SpclCgoAproApplVO();
	
	        spclCgoAproApplVO.setBkgNo(bkgBlNoVO.getBkgNo());
	        spclCgoAproApplVO.setSpclCgoTp(spclCgoTp);
	        spclCgoAproApplVO.setAccount(account);
	        
	        RfCgoApplVO applVo = new RfCgoApplVO();
	        applVo = command.searchRfCargo(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getBlNo(), "");
	        List<BkgRfCgoVO> rfBkgInfoVOs = new ArrayList<BkgRfCgoVO>();
	        
	        if(applVo!=null && applVo.getBkgRfCgoVO()!=null){
		        for(int i=0; i<applVo.getBkgRfCgoVO().size();i++){
		        	if(applVo.getBkgRfCgoVO().get(i).getSpclCgoAproCd()!=null
		        	&& ("Y".equals(applVo.getBkgRfCgoVO().get(i).getSpclCgoAproCd())
		        		||"R".equals(applVo.getBkgRfCgoVO().get(i).getSpclCgoAproCd())	) ){
		        		rfBkgInfoVOs.add(applVo.getBkgRfCgoVO().get(i));
		        	}
		        }
	        }
	        
	        SpclReqInVO[] spclReqInVOs = new SpclReqInVO[rfBkgInfoVOs.size()];
	        for(int i=0;i<rfBkgInfoVOs.size();i++){
	        	spclReqInVOs[i] = new SpclReqInVO();
	        	spclReqInVOs[i].setBkgNo(bkgBlNoVO.getBkgNo());
	        	spclReqInVOs[i].setCargoSeq("");
	        	spclReqInVOs[i].setAproCd("C");
	        	spclReqInVOs[i].setRcSeq(rfBkgInfoVOs.get(i).getRcSeq());
	        }
	        spclCgoAproApplVO.setSpclReqInVOs(spclReqInVOs);
	        	
        	//strSpclCgo = command.manageSpclCgoApro(spclCgoAproApplVO);
        	command.manageSpclCgoApro(spclCgoAproApplVO);
//        	if (strSpclCgo.equals("1")) {
//        		throw new EventException(new ErrorHandler("BKG00003", new String[] {}).getMessage());
//        	}
        	for (SpclReqInVO vo : spclCgoAproApplVO.getSpclReqInVOs()) {
    			ownCmd.cancelSpecialCargoRequest(scgFlg, vo.getBkgNo(), new String[]{vo.getRcSeq()}, new String[]{"C"}, account);	
        	}
        	
		}catch(EventException ex){
			//rollback();
			throw ex;
		}catch(Exception ex){
			//rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	
	/**
	 * cop상의 qty와 tro qty일치하는지 check
	 * @author 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse checkCopQty(Event e) throws EventException {
		EsmBkg007902aEvent event = (EsmBkg007902aEvent)e;
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
				
        try {        	
			String cfmBlockFlg = command.checkCopQty(event.getTroDtlVO());
			eventResponse.setETCData("cfm_block_flg",cfmBlockFlg);

		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}	

		return eventResponse;
	}
	
	/**
	 * cop의 updateBkg 메서드를 호출한다.
	 * @author 
	 * @param String bkgNo
	 * @param String mapSeq
	 * @exception EventException
	 */	
	private void callCopUpdateBkg(String bkgNo, String mapSeq) throws EventException{
		try{
			BkgCopManageBC          copBC     = new BkgCopManageBCImpl();	
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
			BookingUtil             util      = new BookingUtil();
			
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("COP_BACK_END_LIST");
			List<BkgHrdCdgCtntVO> BkgHrdCdgCtntVOs = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
			
			String backEndFlg = "N";
			String hrdCdnBkgNo = "";
			if(BkgHrdCdgCtntVOs.size() > 0){
				for(int i=0;i<BkgHrdCdgCtntVOs.size();i++){
					hrdCdnBkgNo = BkgHrdCdgCtntVOs.get(i).getAttrCtnt1();
					if(hrdCdnBkgNo.equals(bkgNo)){
						backEndFlg = "Y";
					}
				}
			}
			// 18. updateBkg(타 모듈 호출)
			if("Y".equals(backEndFlg)){// BackEnd
				receiptBC.callCopUpdateBkgBackEnd(bkgNo, mapSeq, account);
			}else{
				copBC.updateBkg(bkgNo, mapSeq);
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * cop의 splitBkg 메서드를 호출한다.
	 * @author 
	 * @param String bkgNo
	 * @param String[] newBkgNoArr
	 * @param String[] copMapSeqArr
	 * @exception EventException
	 */	
	private void callCopSplitBkg(String bkgNo, String[] newBkgNoArr, String[] copMapSeqArr) throws EventException{
		try{
			BkgCopManageBC          copBC     = new BkgCopManageBCImpl();	
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
			BookingUtil             util      = new BookingUtil();
			
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("COP_BACK_END_LIST");
			List<BkgHrdCdgCtntVO> BkgHrdCdgCtntVOs = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
			
			String backEndFlg = "N";
			String hrdCdnBkgNo = "";
			if(BkgHrdCdgCtntVOs.size() > 0){
				for(int i=0;i<BkgHrdCdgCtntVOs.size();i++){
					hrdCdnBkgNo = BkgHrdCdgCtntVOs.get(i).getAttrCtnt1();
					if(hrdCdnBkgNo.equals(bkgNo)){
						backEndFlg = "Y";
					}
				}
			}
			if("Y".equals(backEndFlg)){// BackEnd
				receiptBC.callCopSplitBkgBackEnd(bkgNo, newBkgNoArr, copMapSeqArr, account);
			}else{
				copBC.splitBkg(bkgNo, newBkgNoArr, copMapSeqArr);
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * cop의 combineBkg 메서드를 호출한다.
	 * @author 
	 * @param String[] combinedBkgNo
	 * @param String targetBkg
	 * @param List<CombineTroNewSeqVO> combineTroNewSeqVOs
	 * @exception EventException
	 */	
	private void callCopCombineBkg(String[] combinedBkgNo, String targetBkg, List<CombineTroNewSeqVO> combineTroNewSeqVOs) throws EventException{
		try{
			BkgCopManageBC          copBC     = new BkgCopManageBCImpl();	
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
			BookingUtil             util      = new BookingUtil();
			
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("COP_BACK_END_LIST");
			List<BkgHrdCdgCtntVO> BkgHrdCdgCtntVOs = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
			
			String backEndFlg = "N";
			String hrdCdnBkgNo = "";
			if(BkgHrdCdgCtntVOs.size() > 0){
				for(int i=0;i<BkgHrdCdgCtntVOs.size();i++){
					hrdCdnBkgNo = BkgHrdCdgCtntVOs.get(i).getAttrCtnt1();
					if(hrdCdnBkgNo.equals(targetBkg)){
						backEndFlg = "Y";
					}
				}
			}
			if("Y".equals(backEndFlg)){// BackEnd
				receiptBC.callCopCombineBkgBackEnd(combinedBkgNo, targetBkg, combineTroNewSeqVOs, account);
			}else{
				copBC.combineBkg(combinedBkgNo, targetBkg, combineTroNewSeqVOs);
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_0078 BKG Reactive 화면 조회<br>
	 * @author DONG HUN YANG
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchBkgReactivate(Event e) throws EventException{
		log.debug("[START:: GeneralBookingConductSC == BkgReactivate SEARCH ]==========");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralBookingReceiptBC command = new GeneralBookingReceiptBCImpl();
		EsmBkg0078Event event = (EsmBkg0078Event)e;
		
		String bkgNo = event.getBkgNo();
		String tVvd = event.getTrunkVVD();
		String polCd = event.getPolCd();
		String podCd = event.getPodCd();
		String sts = event.getSts();
		String cxlRsn = event.getCxlRsn();
		
		List<BkgReactivateVO> list =command.searchBkgReactivate(bkgNo, tVvd, polCd, podCd, sts, cxlRsn);
		eventResponse.setRsVoList(list);
		return eventResponse;
		
	}
	/**
     * Cancel BKG를 reactivate 한다. No rate status까지 처리한다.
     * @param e Event 
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse reactivateBooking (Event e) throws EventException {
    	try {
    		EsmBkg0078Event event 			= (EsmBkg0078Event) e;
			GeneralEventResponse eventResponse 	= new GeneralEventResponse();
    		GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
    		BLDocumentationCMBC blDocCmBC 		= new BLDocumentationCMBCImpl();
    		BkgCopManageBC 			copBC		= new BkgCopManageBCImpl();
    		CostAssignBC masBc 					= new CostAssignBCImpl();	
    		BookingARCreationBC invBc 			= new BookingARCreationBCImpl();
			BookingHistoryMgtBC historyBC 		= new BookingHistoryMgtBCImpl();	
    		BookingUtil command 				= new BookingUtil();
    		BkgBlNoVO bkgBlNoVO 				= new BkgBlNoVO();
			MasBkgComIfVO masBkgComIfVo 		= new MasBkgComIfVO();
			ARBkgInterfaceCreationVO bkgIfVo 	= new ARBkgInterfaceCreationVO();
			
			begin();
			String bkgNo = event.getBkgReactivateVO().getBkgNo();
			log.debug("reactivateBooking:"+bkgNo);    		
    		bkgBlNoVO.setBkgNo(bkgNo);
    		bkgBlNoVO = command.searchBkgBlNoVO(bkgBlNoVO);

    		//Activate Container 
    		blDocCmBC.activateBkgCntr(bkgBlNoVO, account);
//    		//COP replan
    		receiptBC.reactBkgStatus(bkgNo);
//    		receiptBC.compFirm(bkgBlNoVO, account);
    		receiptBC.changeBkgStatus("F", bkgBlNoVO, false, account);
    		//No rate sts처리
    		receiptBC.modifyNoRtStsCd(bkgBlNoVO, "F", account);
    		//COP replan
    		copBC.reviveCopsByBkgRqst(bkgNo);
			//COA I/F
			masBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
			masBkgComIfVo.setCostSrcSysCd("BKG");
			masBkgComIfVo.setIfRmk("reactivate");
			masBkgComIfVo.setCreUsrId(account.getUsr_id());
			masBkgComIfVo.setUpdUsrId(account.getUsr_id());			
			masBc.modifyMasCommonInterface(masBkgComIfVo);
			//INV I/F
			bkgIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
			bkgIfVo.setBkgCorrNo(bkgBlNoVO.getCaNo());
			bkgIfVo.setUserId(account.getUsr_id());
			bkgIfVo.setManDivInd("B");
			invBc.interfaceBKGARInvoiceToINV(bkgIfVo);
			//History 추가			
			HistoryLineVO historyLineVO = new HistoryLineVO();
			historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
			historyLineVO.setCaFlg(bkgBlNoVO.getCaFlg());
			historyLineVO.setBkgDocProcTpCd("BREACT");// booking firm for doc performance
			historyLineVO.setUiId("ESM_BKG_0079_01");
			historyLineVO.setCrntCtnt("Reactivate.");
			historyLineVO.setHisCateNm("Reactivate."); 
			historyBC.createBkgHistoryLine(historyLineVO, account);
			//No rate 히스토리 추가
			historyLineVO.setCrntCtnt("F");
			historyLineVO.setHisCateNm("No Rate Status"); 
			historyBC.createBkgHistoryLine(historyLineVO, account);
			commit();
			
			
			
			
			//SPC-BKG 연동 (NoRateStatus Firm 일 때만 SPC Aloc 체크)
			//이미 위에서 NorateStatus가 Firm처리 났기 때문에 로직을 무조건 태움
//			String alocPopFlg = "";
			ConstraintMasterBC		spcBC = new ConstraintMasterBCImpl();	
			List<SpcSbBkgDtlVO> spcSbBkgDtlVO = new ArrayList<SpcSbBkgDtlVO>();
			boolean spcErrFlg = false;
			try{
				begin();
				spcSbBkgDtlVO = spcBC.standbyCheck4Bkg(bkgBlNoVO.getBkgNo(), account);
				commit();
			} catch(Exception spcEx){
				rollback();
				log.error("SPC Allocation error : " + spcEx.toString(), spcEx);
				spcErrFlg = true;
			}
			begin();
			if(spcErrFlg){
				//Error
				AllocStsVO allocStsVO = new AllocStsVO();
				allocStsVO.setAlocStsCd("");
				AllocStsChgVO allocStsChgVO2 = receiptBC.modifyAllocStatusForBkg(bkgBlNoVO, allocStsVO, account);
				// history
				historyLineVO = new HistoryLineVO();
				historyLineVO.setUiId("ESM_BKG_0079_01");			
				historyLineVO.setHisCateNm("Allocation Status");
				historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
				historyLineVO.setCaFlg("N");
				historyLineVO.setCrntCtnt("Error");
				historyLineVO.setPreCtnt(allocStsChgVO2.getOriAlocStsCd());
				historyBC.createBkgHistoryLine(historyLineVO, account);
				
			}else if(spcSbBkgDtlVO == null || spcSbBkgDtlVO.size()==0){
				//F
				AllocStsVO allocStsVO = new AllocStsVO();
				allocStsVO.setAlocStsCd("F");
				AllocStsChgVO allocStsChgVO2 = receiptBC.modifyAllocStatusForBkg(bkgBlNoVO, allocStsVO, account);
				// history
				if(!allocStsChgVO2.getAlocStsCd().equals(allocStsChgVO2.getOriAlocStsCd())){
					historyLineVO = new HistoryLineVO();
					historyLineVO.setUiId("ESM_BKG_0079_01");			
					historyLineVO.setHisCateNm("Allocation Status");
					historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
					historyLineVO.setCaFlg("N");
					historyLineVO.setCrntCtnt("F");
					historyLineVO.setPreCtnt(allocStsChgVO2.getOriAlocStsCd());
					historyBC.createBkgHistoryLine(historyLineVO, account);
				}
				if(allocStsChgVO2.getBkgNtcHisVOs().size()>0){
					historyBC.createBkgNtcHis(allocStsChgVO2.getBkgNtcHisVOs(), "ESM_BKG_0079_01");
				}
			}else if(spcSbBkgDtlVO != null && spcSbBkgDtlVO.size()>0){
				AllocStsVO allocStsVO = new AllocStsVO();
				allocStsVO.setChangeVvd("N");
				for(int i=0; i<spcSbBkgDtlVO.size(); i++){
					if(spcSbBkgDtlVO.get(i).getAlocSvcCd()!=null && "M".equals(spcSbBkgDtlVO.get(i).getAlocSvcCd())){
//						alocPopFlg = "Y";
						allocStsVO.setAlocSvcCd("M");
					}
				}
				allocStsVO.setAlocStsCd("S");
				AllocStsChgVO allocStsChgVO2 = receiptBC.modifyAllocStatusForBkg(bkgBlNoVO, allocStsVO, account);
				// history
				if(!allocStsChgVO2.getAlocStsCd().equals(allocStsChgVO2.getOriAlocStsCd())){
					StringBuffer tmpBuffer = new StringBuffer(allocStsVO.getAlocStsCd());
					for(int i=0; i<spcSbBkgDtlVO.size(); i++){
						tmpBuffer.append("\n");
						tmpBuffer.append((spcSbBkgDtlVO.get(i).getLstSbRsnTpCd()==null)?"":spcSbBkgDtlVO.get(i).getLstSbRsnTpCd()).append("/");
						tmpBuffer.append((spcSbBkgDtlVO.get(i).getLstSbSubRsnCd()==null)?"":spcSbBkgDtlVO.get(i).getLstSbSubRsnCd()).append("/");
						tmpBuffer.append((spcSbBkgDtlVO.get(i).getAlocSvcCd()==null)?"":spcSbBkgDtlVO.get(i).getAlocSvcCd()).append("/");
						tmpBuffer.append((spcSbBkgDtlVO.get(i).getLstSbRsn()==null)?"":spcSbBkgDtlVO.get(i).getLstSbRsn());
					}
					historyLineVO = new HistoryLineVO();
					historyLineVO.setUiId("ESM_BKG_0079_01");			
					historyLineVO.setHisCateNm("Allocation Status");
					historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
					historyLineVO.setCaFlg("N");
					historyLineVO.setCrntCtnt(tmpBuffer.toString());
					historyBC.createBkgHistoryLine(historyLineVO, account);
					
//						bookingSaveValidationVO.setAlocPopFlg(alocPopFlg);
//						bookingSaveValidationVO.setFirmMsgFlg(allocStsChgVO2.getFirmMsgFlg());
				}
				if(allocStsChgVO2.getBkgNtcHisVOs().size()>0){
					historyBC.createBkgNtcHis(allocStsChgVO2.getBkgNtcHisVOs(), "ESM_BKG_0079_01");
				}
			}	
			commit();
			// SPC-BKG 연동 (NoRateStatus Firm 일 때만 SPC Aloc 체크)(E)
			//(E)
			eventResponse.setETCData("isSuccess","Y");
			return eventResponse;
			
    	} catch(EventException ex) {
			throw new EventException(ex.getMessage(), ex);
		}
    }
    
	/**
	 * ESM_BKG_0090 <br>
	 * 지정된 Contract No에 맞는 Stowage Code인지 여부를 체크<br>
	 *
	 * @author iylee
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse validateStwgCdbyCtrtNo(Event e) throws EventException {
		try{
			EsmBkg0090Event event = (EsmBkg0090Event)e;
			GeneralBookingReceiptBC receptBC = new GeneralBookingReceiptBCImpl();

			String checkFlg = receptBC.validateStwgCdbyCtrtNo(event.getStwgCd(), event.getCtrtNo());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("checkFlg",checkFlg);
			
			return eventResponse;			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}		
	}
	
	/**
	 * ESM_BKG_0090 <br>
	 * OLBS에 해당되는 SC인지 여부를 체크<br>
	 *
	 * @author iylee
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkSCNoByStwgCd(Event e) throws EventException {
		EsmBkg0090Event event = (EsmBkg0090Event)e;
        BookingUtil utilCmd = new BookingUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
        String existStwg = "0";
        
       try {
			List<BkgHrdCdgCtntVO> bkgHrdCdgCntnVOs = utilCmd.searchHardCoding(event.getBkgHrdCdgCtntListCondVO());
			if (bkgHrdCdgCntnVOs.size() > 0) {
				existStwg = "1";
			}
            
			eventResponse.setETCData("existStwg",existStwg);
			
        } catch(EventException ex) {
           throw ex;
        } catch(Exception ex) {
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;		
	}
}

