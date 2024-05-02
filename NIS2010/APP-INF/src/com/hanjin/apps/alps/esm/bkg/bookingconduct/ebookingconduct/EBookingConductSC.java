/*=========================================================
 *@FileName : EBookingConductSC.java
 *@FileTitle : e-Booking n SI Process
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.21
 *@LastModifier : 전용진
 *@LastVersion : 1.0
 * 2009.05.21 전용진
 * 1.0 Creation
 * ------------------------------------------------------
 * HISTORY
 * 2010.11.04 김영철 [CHM-201005975-01] SEANACCS ACL 변경 요청 (E-BKG&SI & DPCS 관련) - EDI로 들어온 Data가 처리되었는지 Validation 추가 요청
 * 2010.11.04 김영철 [] Booking Creation / Update / Cancel시, Vessel Operation 모듈의 Final CBF 생성 여부를 체크해서 경고 메시지
 * 2010.11.10 전성진 [] Container 저장시에 Update 시에도 COP 호출 - Container 화면에서 삭제된 경우 update도 insert 됨
 * 2010.11.11 이일민 [CHM-201005878-01] Split 01-Collection Office / Code자동 업데이트 관련 수정 요청 (Customer Code 변경 및 B/L Issue 화면 연동)
 * 2010.11.22 이일민 [CHM-201005878-01] Split 01-Collection Office / Code자동 업데이트 관련 수정 요청 (Customer Code 변경 및 B/L Issue 화면 연동)
 * 2010.11.26 이일민 [CHM-201005878-01] Split 01-Collection Office / Code자동 업데이트 관련 수정 요청 (Customer Code 변경 및 B/L Issue 화면 연동)
 * 2010.11.23 최도순 [CHM-201007206] Actual customer column 보완 및 M&D 화면에 자동 DISPLAY 요청
 * 2010.12.30 이일민 [CHM-201007165-01] Split 01-Simple EDI 개발 요청
 * 2011.01.04 김영철 [CHM-201007416-01] E-BKG & SI CM Tab 수정 요청 (구주 24HR Rule 관련)
 * 2011.01.05 이일민 [CHM-201007165-01] Split 01-Simple EDI 개발 요청 (cntr에 value에 콤마 제거)
 * 2011.01.07 이일민 [CHM-201006824] VVD 변경시 Loew's 에 customer 301 전송
 * 2011.01.10 이일민 [CHM-201007165-01] Split 01-Simple EDI 개발 요청(수정사항 반영을위해 customer 301 전송 관련 주석처리 함)
 * 2011.01.13 이일민 [CHM-201006824] VVD 변경시 Loew's 에 customer 301 전송(주석제거)
 * 2011.01.31 이일민 [CHM-201006824] VVD 변경시 Loew's 에 customer 301 전송(EDI조건추가)
 * 2011.02.01 이일민 [CHM-201007165-01] Split 01-Simple EDI 개발 요청(IB_BKG_IND 항목 추가)
 * 2011.02.10 이일민 [CHM-201108897] [Simple EDI] DPCS 연동 요청
 * 2011.02.21 이일민 [CHM-201108898] [Simple EDI] 컨테이너 누락 & S/I 접수방식 공란 확인 요청
 * 2011.03.02 김영철 [] DB/L 전송시 Charge 부분을 보내지 않도록 함.
 * 2011.03.07 이일민 [CHM-201109107-01] [Simple EDI] Total PKG/WGT/Measure 추가
 * 2011.03.10 이일민 [] cop호출함수(modifyRailRcvCoffDt) 주석처리
 * 2011.03.21 이일민 [CHM-201109305-01] [Simple EDI] 시트보호, M&D탭 추가 및 개체 편집
 * 2011.03.24 이일민 [] Simple EDI 버그 수정(Total PKG/WGT/Measure comma replace)
 * 2011.03.29 이일민 [] seanaccs처럼 samsung추가 (4185 라인 sendXterRqstRejectEmail 임시 주석)
 * 2011.03.31 이일민 [CHM-201109868-01] e-Booking & SI Request pop-up 기능 변경
 * 2011.05.11 이일민 [CHM-201110114] BKG Charge Screen 상 운임회수 점소 pre-paid office was auto-changed as booking office again
 * 2011.05.16 이일민 Simple EDI 오류메일 전송(sendErrLogMailBySimpleEDI 검색)
 * 2011.05.16 이일민 [CHM-201110332] ALPS Transshipment 메뉴 오류 수정요청
 * 2011.05.17 이일민 Simple EDI 오류메일 전송(sendErrLogMailBySimpleEDI 검색) - 원복
 * 2011.05.18 이일민 소스품질 결함 조치
 * 2011.06.08 이일민 [CHM-201110982-01] e-SI & DPCS BKG Split & Combine 기능 구현 요청
 * 2011.06.21 이일민 [] Simple EDI 엑셀 시트명 변경 가능하도록 수정
 * 2011.06.24 손은주 [CHM-201111279-01] s-si Process 개선 사항 요청
 * 2011.06.24 이일민 Simple EDI 오류메일 전송 적용
 * 2011.07.05 이일민 Simple EDI 오류메일 전송 라이브 적용
 * 2011.07.14 김진승 [CHM-201111820] Split 03-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
 * 2011.07.18 김봉균 [CHM-201112282-01] 중국 Solid Waste 관련 bkg commodity validation 추가
 * 2011.08.10 정선용 [CHM-201112747-01] Doc requirement상 Issue place 오류 관련 수정 요청
 * 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축
 * 2011.10.19 정선용 [CHM-201113772-01] [삼성SDS] 신규 TP ID 셋업 요청
 * 2011.10.27 윤태승 [CHM-201113981-01]ALPS > Booking Creation > TRO/O remarks 에 문구 삽입 요청드립니다.
 * 2011.11.28  정선용 [CHM-201114552-01]	[Simple S/I] 파일 보완 작업 요청
 * 2011.11.29 정선용 [CHM-201113753-01] Split 01-Korea CLL 전송 후 변동사항 발생 시 SMS 자동 발송 기능 개발 요청
 * 2011.12.06 정선용 [CHM-201114657-01] [ALPS] E-BKG/SI Freight Term Drop Down Box 삭제 요청 
 * 2011.12.13 정선용 [CHM-201114913-01] e-Booking & SI Process 메뉴 추가 및 조회 조건 변경
 * 2011.12.14 정선용 소스품질 결함 조치
 * 2011.12.19 정선용 [CHM-201115046-01]	선적변경시 웹메일 & SMS 서비스 개발 건 보완요청(2차)
 * 2012.02.28 정선용 [CHM-201215444-01] [웹 리뉴얼] Rider 및 D/G Rider 항목 보완 (E-bkg/E-SI)
 * 2012.05.31 조정민 [CHM-201218064] [BKG]선적변경 건 SMS 수신 누락에 대한 시스템 보완요청(3차)
 * 2012.06.21 조정민 [CHM-201218492] [BKG] PRD Rail Receiving (Cut Off) Date 산출 Logic 변경 및 추가 요청 관련 타 모듈 수정 요청.
 * 2012.06.27 전성진 [] PRD 호출 파라미터 표시 제거
 * 2012.08.24 이재위 [CHM-201219778] [BKG] S/I Upload notification 문구 수정 요청
 * 2012.09.25 조정민 [CHM-201219852] [BKG] MEMO BL Cancel건의 BKG Status변경 자동처리 (S->F Manual변경처리하는 현행 개선)
 * 2012.10.30 이재위 [CHM-201220674] [ALPS BKG] Split 01-Container Loading List 화면상 Seal KindCode 추가 요청
 * 2012.11.05 김현화 [CHM-201220974][Simple S/I] 반송메일 BKG NO 내용 추가
 * 2012.11.09 김진주 [             ] 자체 개선사항. e-BKG/SI 수신오류 원인 분석 메세지  제공
 * 2012.11.14 김진주 [] 장시간 수행 리퀘스트 모니터링을 위한 로그 삭제
 * 2012.11.15 김현화 [CHM-201220707]e-booking & e-si upload 화면에 P.O.NO. 입력 필수 validation 및 경고 문구 추가 요청
 * 2012.11.29 이재위 [CHM-201220433] [eBKG] Simple BKG 개발 요청
 * 2012.12.18 이재위 [CHM-201221960] Simple Booking 수정 요청
 * 2012.12.20 조정민 [CHM-201221841] Booking Confirmation F/File 발송 조건 추가
 * 2013.02.06 이재위 [CHM-201322717-01] IKEA Booking Upload시 Key Data Check 로직 추가요청
 * 2014.08.22 최도순[CHM-201431653] e-BKG cancel request 업로드 시에도 remark란 입력 및 저장 기능 활성화
 * 2014.09.23 최도순[CHM-201431993] 미주지역 SIMPLE BKG 템플릿 변경 요청
 * 2014.10.08 최도순[CHM-201431728] Split 02-SM LINE 조기결산을 위한 개선 방안 중 BKG 관리 프로세스 단축(안) 개발
 * 2014.10.20 김도현[CHM-201431786] 테스트_온라인(WEB) Booking 개선 (1차)
 * 2014.01.13 최도순 [CHM-201433292] e-BKg & SI Upload화면 > M&D tap > Ship ID항목 추가
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.formula.FormulaParseException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;

import com.hanjin.apps.alps.esd.prd.common.prdcreate.basic.PrdCreateManageBC;
import com.hanjin.apps.alps.esd.prd.common.prdcreate.basic.PrdCreateManageBCImpl;
import com.hanjin.apps.alps.esd.prd.common.prdcreate.vo.PrdPcCreateVO;
import com.hanjin.apps.alps.esd.prd.common.productcatalogcreateverify.basic.ProductCatalogCreateVerifyBCImpl;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBC;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBCImpl;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.event.EsdPrd0080Event;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.integration.ProductCatalogCreateDBDAO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdPatternVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBC;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.basic.BkgCopManageBCImpl;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.UpdBkgForBkgCodVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryTableVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlckListMntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgCloseVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.OblIssVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdMainInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdParameterVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdQtyInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SearchLocationCodeVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic.EBookingReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.basic.EBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg0225Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg0228Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022901Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022902Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022903Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022904Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022905Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022906Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022907Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022908Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022909Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022910Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022911Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg022912Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg0229Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg0241Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg0250Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg0451Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg0902Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkg1100Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkgEBkgReceiptEvent;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkgWeb0090001Event;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration.EBookingReceiptDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsCntrTpszVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsXptImpLicListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgWebServiceVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterChgRtVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterVrfdWgtPtyVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BkgXterVrfdWgtRqstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BlRiderVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.EBookingControlMgmtVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstAkVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstBbVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstCmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstCntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstDgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstHbl1VO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstHbl2VO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstListInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstMndVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstRfVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.ExternalRqstTroVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.SIWebServiceVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.SearchXterPoMdtItmParmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterCustChkPntVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterDgRiderVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterEtcInterfaceVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterInnerPackageVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterMndVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstValidationVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.AllocStsChgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.AllocStsVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgClauseLockVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgCmpbVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlDocCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingCreationVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingSaveValidationVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.OldBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherCmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherCntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherNoBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherShipVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.RefNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SmsRequirementResultVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgChgOfcVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgInforForHistVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.CustomsHistVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.DocHistVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.HistMainVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.HistUiNmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.NoticeHistVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.OftPrecheckVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Vender301ParamVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.basic.TransferOrderIssueBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.basic.TransferOrderIssueBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroDtlVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroMstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroDtlVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.AwkCgoApplVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BbCgoApplVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgAwkCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgBbCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgRfCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCgoApplVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCgoListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.RfCgoApplVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.ScgImdgUnNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.SpclCgoAproApplVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.basic.SpecialCargoRiderBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.basic.SpecialCargoRiderBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.SpclRiderInVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.basic.BDRCorrectionBC;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.basic.BDRCorrectionBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.vo.CaRsnRmkVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.vo.CorrReplanVO;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.basic.CODCorrectionBC;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.basic.CODCorrectionBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.vo.CodEtcVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.basic.BookingMasterMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgHandlingOfficeSetupVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgUserSmsListVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.VskVslPortSkdConditionVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBC;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.basic.PerformanceReportBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.DpcsWebBookingVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.ModifySiValAutoVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchBkgSrProcHisListVO;
import com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo.SearchSREmlReceivingListVO;
import com.hanjin.apps.alps.esm.bkg.common.Constants;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBC;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBCImpl;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FrtCltLstVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OblRdemVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.ArrivalNoticeBC;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.ArrivalNoticeBCImpl;
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
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BlKrWhfExptVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateMainInfoVO;
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
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrDetailInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrEtcInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrInfoOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CreateBkgBlDocBkgVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblDtlInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MndVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DocRqstVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.basic.RevenueDebitNoteBC;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.basic.RevenueDebitNoteBCImpl;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.CstmBkgRevDrNoteVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.revenuedebitnote.vo.RevDrNoteVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.basic.UnmatchBLBC;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.basic.UnmatchBLBCImpl;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.UnmatchBLVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlExptInfoVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBC;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.basic.ConstraintMasterBC;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.basic.ConstraintMasterBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.basic.OwnContainerBookingForecastMgtBC;
import com.hanjin.apps.alps.vop.opf.cargoloadingplanmgt.owncontainerbookingforecastmgt.basic.OwnContainerBookingForecastMgtBCImpl;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic.OwnDangerousCargoApprovalBC;
import com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.basic.OwnDangerousCargoApprovalBCImpl;
import com.hanjin.framework.component.javamail.Mail;
import com.hanjin.framework.component.javamail.TemplateMail;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgBookingVO;
import com.hanjin.syscommon.common.table.BkgChnBkgNoGenVO;
import com.hanjin.syscommon.common.table.BkgCntcPsonVO;
import com.hanjin.syscommon.common.table.BkgCntrMfDescVO;
import com.hanjin.syscommon.common.table.BkgCntrSealNoVO;
import com.hanjin.syscommon.common.table.BkgContainerVO;
import com.hanjin.syscommon.common.table.BkgCorrectionVO;
import com.hanjin.syscommon.common.table.BkgCustomerVO;
import com.hanjin.syscommon.common.table.BkgDocProcSkdVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgImgStoVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.BkgQtyDtlVO;
import com.hanjin.syscommon.common.table.BkgQuantityVO;
import com.hanjin.syscommon.common.table.BkgRefDtlVO;
import com.hanjin.syscommon.common.table.BkgReferenceVO;
import com.hanjin.syscommon.common.table.BkgTroSpclCgoSeqVO;
import com.hanjin.syscommon.common.table.BkgUsrDfltSetVO;
import com.hanjin.syscommon.common.table.BkgXterSrchSetVO;
import com.hanjin.syscommon.common.table.MasBkgComIfVO;
import com.hanjin.syscommon.common.table.MdmPckTpVO;
import com.hanjin.syscommon.common.table.MdmStateVO;
import com.hanjin.syscommon.common.table.MstContainerVO;
import com.hanjin.syscommon.common.table.ScgAproRqstVO;
import com.hanjin.syscommon.common.table.ScgVvdAproRqstVO;
import com.hanjin.syscommon.common.table.SpcSbBkgDtlVO;

 
/**
 * ALPS-EBookingConduct Business Logic ServiceCommand - ALPS-EBookingConduct 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author Jun Yong Jin
 * @see EBookingReceiptDBDAO
 * @since J2EE 1.4
 */ 

public class EBookingConductSC extends ServiceCommandSupport {
	// Login User Information 
	private SignOnUserAccount account = null;

	/**
	 * EBookingConduct system 업무 시나리오 마감작업<br>
	 * ESM_BKG_0228 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("EBookingConductSC 종료");
	}

	/**
	 * EBookingConduct system 업무 시나리오 선행작업<br>
	 * ESM_BKG_0228업무 시나리오 호출시 관련 내부객체 생성<br>
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
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-EBookingConduct system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
			if (e.getEventName().equalsIgnoreCase("EsmBkg0228Event")) {
				if(e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchComCode0228(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchXterRqstList(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					eventResponse = searchXterRqstValidation(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
					eventResponse = deleteXterRqst(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
					eventResponse = pendingXterRqst(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) {
					eventResponse = bkgNoXterRqst(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) {
					eventResponse = uploadDummyXterRqst(e);
				}
			    else if (e.getFormCommand().isCommand(FormCommand.MODIFY05)) {
					eventResponse = holdXterRqst(e);
				}
			    else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
					eventResponse = receiptXterRqstEdiMsg(e);
				}
//				else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
//					eventResponse = searchComCode0228(e);
//				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0229Event")) {
				if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
					eventResponse = uploadXterRqst(e);
				} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
					eventResponse = cancelBkgByXter(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					eventResponse = searchBkgChgOfc(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MODIFY07)) {
					eventResponse = modifyBkgChgOfc(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = manageWebSiAudit(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					eventResponse = manageBccSurchargeRating(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
					eventResponse = createTerminalVERMASEdi(e);
				} else if (e.getFormCommand().isCommand(FormCommand.TRANS)) {
					eventResponse =  xterRqstDatasetInterfaceTest(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg022901Event")) {
				if (e.getFormCommand().isCommand(FormCommand.DEFAULT)
						|| e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchXterBkg(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchMdmCmdtDesc(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					eventResponse = searchVslNm(e);
//				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
//					eventResponse = searchAlpsBkg(e);// 미사용
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = createBkgWithoutRouteByXterTx(e);//for Test
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					eventResponse = createBkgWithRouteByXterTx(e);//for Test
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
					eventResponse = modifyBkgWithoutRouteByXterTx(e);//for Test
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
					eventResponse = modifyBkgWithRouteByXterTx(e);//for Test
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
					eventResponse = createPctlNo(e);//for Test
				} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
					eventResponse = pendingXterRqst(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
					eventResponse = reinstateXterRqst(e);				
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
					eventResponse = searchBkgBlNo(e);
				} else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)){
					eventResponse = checkIranBlackCustomer(e);
				} else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)){ //2011.07.18 추가(중국 Solid Waste 관련 bkg commodity validation 추가)
					eventResponse = validateChnWasteCmdt(e);
				} else if (e.getFormCommand().isCommand(FormCommand.COMMAND06)){
					eventResponse = searchUsWest(e);
				} else if (e.getFormCommand().isCommand(FormCommand.COMMAND09)){
					eventResponse = checkUsBlackCustomer(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg022902Event")) {
				if(e.getFormCommand().isCommand(FormCommand.DEFAULT) || e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchXterCust(e);
				}
				else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = modifyBlDocCustTx(e);//for Test
				}
				else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)){
					eventResponse = checkIranBlackCustomer(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)){
					eventResponse = checkEuBlackCustomer(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.COMMAND06)){
					eventResponse = validateEdiIkeaCust(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.COMMAND07)){
					eventResponse = searchActualCustomerName(e);
				} 
				else if (e.getFormCommand().isCommand(FormCommand.COMMAND08)){
					eventResponse = checkPortalCustomerCd(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.COMMAND09)){
					eventResponse = checkUsBlackCustomer(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg022903Event")) {
				if(e.getFormCommand().isCommand(FormCommand.DEFAULT) || e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchXterCntr(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchTypeSizeByCntr(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageContainerTx(e);//for Test
				}
				else if(e.getFormCommand().isCommand(FormCommand.COMMAND04)){
					eventResponse = checkIranBlackCustomer(e);
				}
				else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
					eventResponse = validateCntrRsk(e);
				}
				else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
					eventResponse = validateCntrVgmWgt(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg022904Event")) {
				if(e.getFormCommand().isCommand(FormCommand.DEFAULT) || e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchXterMnd(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageMndTx(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchXterPoMdtItm(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg022905Event")) {
				if(e.getFormCommand().isCommand(FormCommand.DEFAULT) || e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchXterCm(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageCmTx(e);//for Test
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg022906Event")) {
				if(e.getFormCommand().isCommand(FormCommand.DEFAULT) || e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchXterTro(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageTroTx(e);//for Test
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg022907Event")) {
				if(e.getFormCommand().isCommand(FormCommand.DEFAULT) || e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchXterRf(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchMdmCmdtDesc(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					eventResponse = searchCntrTpSz(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageRfTx(e);//for Test
				}
				else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
					eventResponse = validateRfRsk(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg022908Event")) {
				if(e.getFormCommand().isCommand(FormCommand.DEFAULT) || e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchXterDg(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageDgTx(e);//for Test
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg022909Event")) {
				if(e.getFormCommand().isCommand(FormCommand.DEFAULT) || e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchXterAk(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageAwkTx(e);//for Test
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg022910Event")) {
				if(e.getFormCommand().isCommand(FormCommand.DEFAULT) || e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchXterHbl1(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageHblTx(e);//for Test
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg022911Event")) {
				if(e.getFormCommand().isCommand(FormCommand.DEFAULT) || e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchXterHbl2(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageHbl2Tx(e);//for Test
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg022912Event")) { // (Tab) Break Bulk
				if(e.getFormCommand().isCommand(FormCommand.DEFAULT) || e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchXterBb(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageBbTx(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0902Event")) {
				if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchComCode0902(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
					eventResponse = sendXterRqstRejectEdi(e);
				} 
				else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
					eventResponse = sendXterRqstPendingNotice(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkgEBkgReceiptEvent")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					receiptXterRqst(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					receiptXterRqstByXls(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					receiptXterVGMRqst(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg1100Event")) {
				if(e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchComCode1100(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchEBookingControlForVslMgmt(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
					eventResponse = modifyEBookingControlMgmt(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
					eventResponse = modifyEBookingControlMgmt(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) {
					eventResponse = modifyEBookingControlMgmt(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) {
					eventResponse = modifyEBookingControlMgmt(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0225Event")) {
				if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
		    		eventResponse = searchCombo0225(e);
	//			}else if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)) {
	//	    		eventResponse = searchSRReceivingList(e);
				}else 
				if(e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
		    		eventResponse = searchSREmlReceivingList(e);	
		    	}
				if(e.getFormCommand().isCommand(FormCommand.MULTI03)) {
		    		eventResponse = modifyReceivingList(e);	
		    	}				
				else if( e.getFormCommand().isCommand(FormCommand.MULTI02)) {
		    		eventResponse = manageSRReceiving(e);
		    	}
//				else if(e.getFormCommand().isCommand(FormCommand.MODIFY)) {
	//	    		eventResponse = modifyQueueRemark(e);
	//	    	}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0451Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchBkgSrProcHisList(e);	
				}
			} else if (e.getEventName().equalsIgnoreCase("EsmBkgWeb0090001Event")) {
				eventResponse = xterRqstDatasetInterface(e);
			} else if (e.getEventName().equalsIgnoreCase("EsmBkg0241Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchXterSIChgRt(e);	
				}
			}
			
			else if (e.getEventName().equalsIgnoreCase("EsmBkg0250Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchBlHist(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					eventResponse = searchNoticeHist(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
					eventResponse = searchCustomsHist(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
					eventResponse = searchDocHist(e);
				}
			}
		}
		catch (EventException ex) {
			throw ex;
		}
		catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * 수정 이벤트 처리<br>
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSRReceiving(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0225Event event = (EsmBkg0225Event)e;
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
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchBkgSrProcHisList(Event e) throws EventException {
        EsmBkg0451Event event = (EsmBkg0451Event) e;
       
        PerformanceReportBC command = new PerformanceReportBCImpl();
        //String fromDt, String toDt, String srMtchStsCd, String rcvOfcCd,String srNo
        List<SearchBkgSrProcHisListVO> list = command.searchBkgSrProcHisList(event.getSearchBkgSrProcHisListVO());
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        eventResponse.setRsVoList(list);

        return eventResponse;
	}

	/**
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse modifyReceivingList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0225Event event = (EsmBkg0225Event)e;
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
     * @return GeneralEventResponse
     * @throws EventException
     */
    private EventResponse searchCombo0225(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
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
//		eventResponse.setETCData("searchDpcsIp", searchDpcsIp);
        
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
	 * 조회 이벤트 처리<br>
	 * ESM_BKG_0225 : SR Receiving List 결과를 조회한다.<br>
	 * 
	 * @param     Event e
	 * @return    EventResponse
	 * @exception EventException
	 */
    private EventResponse searchSREmlReceivingList(Event e) throws EventException {
        EsmBkg0225Event event = (EsmBkg0225Event) e;
       
        PerformanceReportBC command = new PerformanceReportBCImpl();
        //String fromDt, String toDt, String srMtchStsCd, String rcvOfcCd,String srNo
        List<SearchSREmlReceivingListVO> list = command.searchSiAutoSREmlReceivingList(event.getSearchSREmlReceivingListVO());
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        eventResponse.setRsVoList(list);

        return eventResponse;
    }		
		    
	/**
	 * Booking을 생성한다.(ESM_BKG_0079_01)<br>
	 * 
	 * @author 	KimByungKyu
	 * @param 	BookingCreationVO bookingCreationVO
	 * @return 	BookingSaveValidationVO
	 * @exception EventException
	 */
	private BookingCreationVO createBkgInfo(BookingCreationVO bookingCreationVO) throws EventException {
		try{
			GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
			BLDocumentationBLBC 	blBC 		= new BLDocumentationBLBCImpl();
			BLDocumentationCMBC 	blDocBC 	= new BLDocumentationCMBCImpl();
			BookingMasterMgtBC 		masterBC 	= new BookingMasterMgtBCImpl();	
			BookingUtil 			bookingUtil = new BookingUtil();
			
			BookingHistoryMgtBC 	historyBC 	= new BookingHistoryMgtBCImpl();	
			
			BkgCopManageBC 			copBc 		= new BkgCopManageBCImpl();
			
			// 01. validateBookingSave
			log.debug("createBkgInfo : pctl_no : " + bookingCreationVO.getBkgBlNoVO().getPctlNo());
			bookingCreationVO = receiptBC.validateBookingSave(bookingCreationVO, account);
			BookingSaveValidationVO bookingSaveValidationVO = bookingCreationVO.getBookingSaveValidationVO();

			if("Y".equals(bookingSaveValidationVO.getCloseBkgFlag())){
				return bookingCreationVO;
			} else if("Y".equals(bookingSaveValidationVO.getTsCloseBkgFlag())){
				return bookingCreationVO;
			} else if("Y".equals(bookingSaveValidationVO.getCbfBkgFlag())){
				return bookingCreationVO;
			}
			
			BkgBlNoVO 		 bkgBlNoVO 		  = bookingCreationVO.getBkgBlNoVO();
			BkgBookingInfoVO bkgBookingInfoVO = bookingCreationVO.getBkgBookingInfoVO();
			
			String bkgNo = null;
			String blNo = null;
			// 02. Booking Number 생성
			if(!"Y".equals(bkgBookingInfoVO.getMnlBkgNoFlg())){
				//입력된 bkg no가 agent bkg no list에 있으면 mnl bkg no로 처리한다.
				if(bkgBlNoVO.getBkgNo()!=null && 12==bkgBlNoVO.getBkgNo().length()){
					String mnlBkgNoFlg = masterBC.searchIsChnMnlBkgNo(bkgBlNoVO.getBkgNo());
					if("Y".equals(mnlBkgNoFlg)){
						bkgBookingInfoVO.setMnlBkgNoFlg("Y");
					}
				}
			}
			if(!"Y".equals(bkgBookingInfoVO.getMnlBkgNoFlg())){
				// bkg no가 입력된 경우
				if(bkgBlNoVO.getBkgNo()!=null&&bkgBlNoVO.getBkgNo().length()>10){
					// booking status code
					String bkgStsCd = null;
                    bkgStsCd = bookingUtil.searchBkgStatusByBkg(bkgBlNoVO);  

                    if(isNull(bkgStsCd)){
                    	if(bkgBlNoVO.getBkgNo().length()==12){       	
	                    	bkgNo = bkgBlNoVO.getBkgNo();
	                    	blNo = bkgNo;                    		
                    	} else {
	                        // bkg_booking에 없는 BKG이면 b/l no만 새로 채번                    	
	                    	BkgBlNoVO newBkgNoVO = bookingUtil.manageBkgNumberGeneration("BKG", account.getOfc_cd(), account.getUsr_id()); 
	                    	bkgNo = bkgBlNoVO.getBkgNo();
	                    	blNo = newBkgNoVO.getBkgNo() + "00";
                    	}	                    	
					} else {
						// 실제로는 없어야 하는 case
						throw new EventException((String)new ErrorHandler("BKG00034",new String[]{bkgBlNoVO.getBkgNo()}).getMessage());
//						bkgNo = bkgBlNoVO.getBkgNo();
//						blNo  = bkgBlNoVO.getBlNo();
					}
				} else { // bkg no가 없이 저장된 경우
					BkgBlNoVO newBkgNoVO = bookingUtil.manageBkgNumberGeneration("BKG", account.getOfc_cd(), account.getUsr_id());
					bkgNo = newBkgNoVO.getBkgNo() + "00";
					blNo  = bkgNo;
				}
			} else {
				bkgNo = bkgBlNoVO.getBkgNo();
				blNo  = bkgNo;
				// agent manual booking no 채번 table에 bkg이 생성되었음을 기록한다.
				List<BkgChnBkgNoGenVO> bkgChnBkgNoGenVO = new ArrayList<BkgChnBkgNoGenVO>();
				bkgChnBkgNoGenVO.add(new BkgChnBkgNoGenVO());				
				bkgChnBkgNoGenVO.get(0).setBkgNo(bkgNo);
				masterBC.modifyChnBkgNoUseFlgOnList(bkgChnBkgNoGenVO, bkgBookingInfoVO.getBkgPorCd() , account);
			}
			bkgBlNoVO.setBkgNo(bkgNo);
			bkgBlNoVO.setBlNo(blNo);
			bkgBookingInfoVO.setBkgNo(bkgNo);
			bkgBookingInfoVO.setBlNo(blNo);
			
			bookingCreationVO.setBkgBlNoVO(bkgBlNoVO);
			bookingCreationVO.setBkgBookingInfoVO(bkgBookingInfoVO);
			
			// CHM-201642190 일본 e-Bkg upload 시, ALPS S/I Contact Column Update
			String[] jpnOfc = new String[]{"TYOSC","OSASO","NGOSO","SMZSO"};
			if(StringUtils.isEmpty(bkgBookingInfoVO.getSiCntcPsonNm()) && Arrays.asList(jpnOfc).contains(bkgBookingInfoVO.getBkgOfcCd())){
				bkgBookingInfoVO.setSiCntcPsonNm(bkgBookingInfoVO.getBkgCntcPsonNm());
				bkgBookingInfoVO.setSiCntcPsonEml(bkgBookingInfoVO.getBkgCntcPsonEml());
				bkgBookingInfoVO.setSiCntcPsonFaxNo(bkgBookingInfoVO.getBkgCntcPsonFaxNo());
				bkgBookingInfoVO.setSiCntcPsonMphnNo(bkgBookingInfoVO.getBkgCntcPsonMphnNo());
				bkgBookingInfoVO.setSiCntcPsonPhnNo(bkgBookingInfoVO.getBkgCntcPsonPhnNo());			
			}
			
			// 03. createBooking
			receiptBC.createBooking(bookingCreationVO, account);

			// 04. createBkgBlDocByBKG
			CreateBkgBlDocBkgVO createBkgBlDocBkgVO = new CreateBkgBlDocBkgVO();
			createBkgBlDocBkgVO.setBkgNo(bkgNo);    
			createBkgBlDocBkgVO.setBlMvTpNm(bookingSaveValidationVO.getBlMoveTpNm());
			createBkgBlDocBkgVO.setFnlDestNm(bkgBookingInfoVO.getFnlDestNm());
			createBkgBlDocBkgVO.setActWgt(bkgBookingInfoVO.getActWgt());			
			createBkgBlDocBkgVO.setWgtUtCd(bkgBookingInfoVO.getWgtUtCd());  

//			blDocBC.createBkgBlDocByBKG(bkgNo, bookingCreationVO.getBookingSaveValidationVO().getBlMoveTpNm(),
//											   bkgBookingInfoVO.getFnlDestNm(),
//											   bkgBookingInfoVO.getActWgt(), 
//											   bkgBookingInfoVO.getWgtUtCd(),  
//											   account);
			blDocBC.createBkgBlDocByBKG(createBkgBlDocBkgVO, account);

			// VNSGN -> KNPNH 에 대해 BL Clause 자동 문구 삽입 요청
			List<VslSkdVO> routeDetails = receiptBC.searchVvdSkdForTsRoute(bkgBlNoVO);
			if(routeDetails.get(routeDetails.size() - 1).getPolCd().equals(Constants.BL_CLAUSE_POL)
					&& routeDetails.get(routeDetails.size() - 1).getPodCd().equals(Constants.BL_CLAUSE_POD)){
				MndVO mndVO = new MndVO();
				mndVO.setBkgNo(bkgBlNoVO.getBkgNo());
				blBC.manageMndCmdtDescKHPNH(mndVO, account, "N");
			}
			
			// 09. Booking Status 변경
			receiptBC.changeBkgStatus("Y", bkgBlNoVO, false, account);
			
			// 05. createBkgHistoryLine(이남경수석님 호출)
			HistoryLineVO historyLineVO = new HistoryLineVO();
			historyLineVO.setBkgNo(bkgNo);
			historyLineVO.setCaFlg("N");
			historyLineVO.setBkgDocProcTpCd("BKGCRE");
			if("Y".equals(bkgBookingInfoVO.getWebSvcFlg())){
				historyLineVO.setUiId("IF_ESM_BKG_0009");
			}else{
				historyLineVO.setUiId("ESM_BKG_0229");
			}
			
			historyLineVO.setCrntCtnt("Booking Created.");
			historyLineVO.setHisCateNm("Booking Creation"); 

			historyBC.createBkgHistoryLine(historyLineVO, account);

			//dummy가 아닌 sc나 rfa가 입력되었을 때  
			if((bkgBookingInfoVO.getScNo().length()>0 &&!"DUM".equals(bkgBookingInfoVO.getScNo().substring(0, 3)))
				||(bkgBookingInfoVO.getRfaNo().length()>0 &&!"DUM".equals(bkgBookingInfoVO.getRfaNo().substring(0, 3)))
				||(bkgBookingInfoVO.getTaaNo().length()>0 &&!"DUM".equals(bkgBookingInfoVO.getTaaNo().substring(0, 3)))){
				BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
				bkgDocProcSkdVO.setBkgNo(bkgBlNoVO.getBkgNo());
				bkgDocProcSkdVO.setBkgDocProcTpCd("CTRTNO");// contract no input for doc performance
				historyBC.manageDocProcess(bkgDocProcSkdVO, account);

				if(bkgBookingInfoVO.getBkgPodCd().equals("JOAQJ")
						||bkgBookingInfoVO.getBkgDelCd().equals("JOAQJ")){
					blBC.manageMndCmdtDescJOAQJ(bkgBlNoVO.getBkgNo(), account, bkgBlNoVO.getCaFlg());
				}
			}
			
			// 최초 생성시 cnee input
			if(!isNull(bookingCreationVO.getBlCustomerInfoVO().getCCustCntCd())&&!isNull(bookingCreationVO.getBlCustomerInfoVO().getCCustSeq())){
				BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
				bkgDocProcSkdVO.setBkgNo(bkgBlNoVO.getBkgNo());
				bkgDocProcSkdVO.setBkgDocProcTpCd("CNEIPT");// consignee no input for doc performance				
				historyBC.manageDocProcess(bkgDocProcSkdVO, account);
			} 				
			
			if(bookingSaveValidationVO.getScpFromCtrt() != null && bookingSaveValidationVO.getScpFromCtrt().length() > 0){
				BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
				bkgDocProcSkdVO.setBkgNo(bkgBlNoVO.getBkgNo());
				bkgDocProcSkdVO.setBkgDocProcTpCd("SCPCTR");// select service scope from contract
				historyBC.manageDocProcess(bkgDocProcSkdVO, account);
			}	
			
			// 09. createBkg(타 모듈 호출)
			copBc.createBkg(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getPctlNo());	
		}catch(EventException e){
			throw e;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);			
		}
		return bookingCreationVO;		
	}

	/**
	 * Route 변경시 Booking 저장.(ESM_BKG_0079_01)<br>
	 * 
	 * @author KimByungKyu 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createBkgWithoutRoute(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg022901Event event = (EsmBkg022901Event)e;
		try{
//			EBookingReceiptBC eBkgBC = new EBookingReceiptBCImpl();
			ProductCatalogCreateBC proBC = new ProductCatalogCreateBCImpl();
			BookingUtil            util  = new BookingUtil();
						
			// Booking 모든 정보 담는 Container VO
			BookingCreationVO bookingCreationVO = new BookingCreationVO();
			// Validation 결과 담는 VO
			BookingSaveValidationVO bookingSaveValidationVO = event.getBookingSaveValidationVO();
			
			bookingCreationVO.setBkgBookingInfoVO(event.getBkgBookingInfoVO());
			bookingCreationVO.setVslSkdVOs(event.getVslSkdVOs());
			bookingCreationVO.setBkgBlNoVO(event.getBkgBlNoVO());
			bookingCreationVO.setBlCustomerInfoVO(event.getBlCustomerInfoVO());
			bookingCreationVO.setBkgQuantityVOs(event.getBkgQuantityVOs());
			bookingCreationVO.setBkgQtyDtlVOs(event.getBkgQtyDtlVOs());

			// ebkg에서는 한방 update //차후에 세분화 고려
			bookingSaveValidationVO.setRouteModifyFlag("Y");
			bookingSaveValidationVO.setCustomerModifyFlag("Y");
			bookingSaveValidationVO.setContactModifyFlag("Y");
			bookingSaveValidationVO.setQtyModifyFlag("Y");
			bookingCreationVO.setBookingSaveValidationVO(bookingSaveValidationVO);

			/************* findFullRoute *******************/
			PrdParameterVO prdParameterVO = util.findFullRoute(bookingCreationVO);
			String prdLog = util.prdParameterLog(prdParameterVO.getPrdMainInfoVO());
			
			// 03. createProdCtlRout 
			String pctlNo = null;
			String mapSeq = null;
			try{
				String pctlNoMapSeqStr = proBC.createPrdCtlgRout(prdParameterVO, account);

				String [] pctlNoMapSeq = util.splitByToken(pctlNoMapSeqStr, "|");
				pctlNo = pctlNoMapSeq[0];
				mapSeq = pctlNoMapSeq[1];
			} catch (Exception pc_ex){
				eventResponse.setETCData("IsPctlNoPop", "YC");				
				log.debug("Pctl Pop Up Call");
				if(pc_ex.getMessage().indexOf("PRD00058") < 0 			//Not Available M'ty Pick Up Date
						&& pc_ex.getMessage().indexOf("PRD00077") < 0){ //Created more than a single P/C
					log.error(pc_ex.getMessage() + prdLog);
				}
				rollback();
				return eventResponse;	
			}									

			log.debug(" Pctl No : [" + pctlNo + "]");			
			// 화면에서 PctlNo가 넘어오면 다음단계로 넘어가고 없으면 findFullRoute 결과값을 확인하여 PctlNo가 없으면 ESD_PRD_018 화면을 띄우고 있으면 다음단계로 진행한다.
			if(pctlNo != null && pctlNo.length() > 0 && !"FAIL".equals(pctlNo)){
				bookingCreationVO.getBkgBlNoVO().setPctlNo(pctlNo);
				if ( mapSeq!=null){  // 2011.07.14
					bookingCreationVO.getBkgBlNoVO().setMapSeq(mapSeq);
				}
			}else{
				eventResponse.setETCData("IsPctlNoPop", "YC");
				
				log.debug("Pctl Pop Up Call");
				rollback();
				return eventResponse;				
			}
				
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
				eventResponse.setETCData("cbfBkgFlag", "N");
				eventResponse.setETCData("SuccessYn", "Y");
				eventResponse.setETCData("change_vvd", "Y");
			}
			eventResponse.setETCData("bkg_no", bookingCreationVO.getBkgBlNoVO().getBkgNo());
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
	 * Route 변경시 Booking 저장.(ESM_BKG_0079_01)<br>
	 * 
	 * @author KimByungKyu 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createBkgWithoutRouteByXter(Event e) throws EventException {
		try {
			return createBkgWithoutRoute(e);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Route 변경시 Booking 저장.(ESM_BKG_0079_01)<br>
	 * 
	 * @author KimByungKyu 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createBkgWithoutRouteByXterTx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse = (GeneralEventResponse) createBkgWithoutRouteByXter(e);
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
	 * Route 변경없을시 Booking 저장.(ESM_BKG_0079_01)<br>
	 * 
	 * @author KimByungKyu 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createBkgWithRoute(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg022901Event event = (EsmBkg022901Event)e;
		try{
			BookingUtil util = new BookingUtil();

			// Booking 모든 정보 담는 Container VO
			BookingCreationVO bookingCreationVO = new BookingCreationVO();
			// Validation 결과 담는 VO
			BookingSaveValidationVO bookingSaveValidationVO = event.getBookingSaveValidationVO();

			bookingCreationVO.setBkgBookingInfoVO(event.getBkgBookingInfoVO());
			bookingCreationVO.setVslSkdVOs(event.getVslSkdVOs());
			bookingCreationVO.setBkgBlNoVO(event.getBkgBlNoVO());
			bookingCreationVO.setBlCustomerInfoVO(event.getBlCustomerInfoVO());
			bookingCreationVO.setBkgQuantityVOs(event.getBkgQuantityVOs());
			bookingCreationVO.setBkgQtyDtlVOs(event.getBkgQtyDtlVOs());
			
			bookingSaveValidationVO.setRouteModifyFlag("Y");
			bookingSaveValidationVO.setCustomerModifyFlag("Y");
			bookingSaveValidationVO.setContactModifyFlag("Y");
			bookingSaveValidationVO.setQtyModifyFlag("Y");			
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
				eventResponse.setETCData("cbfBkgFlag", "N");
				eventResponse.setETCData("SuccessYn", "Y");		
				eventResponse.setETCData("change_vvd", "Y");
			}
			eventResponse.setETCData("bkg_no", bookingCreationVO.getBkgBlNoVO().getBkgNo());
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
	 * Route 변경시 Booking 저장.(ESM_BKG_0229)<br>
	 * 
	 * @author KimByungKyu 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createBkgWithRouteByXter(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			eventResponse = (GeneralEventResponse) createBkgWithRoute(e);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Route 변경시 Booking 저장.(ESM_BKG_0229)<br>
	 * Transaction 포함
	 * 
	 * @author KimByungKyu 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createBkgWithRouteByXterTx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			eventResponse = (GeneralEventResponse) createBkgWithRouteByXter(e);
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
	 * Product Control No 를 구함<br>
	 * 
	 * @author KimByungKyu 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createPctlNo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg022901Event event = (EsmBkg022901Event)e;
		try{
			BookingUtil util = new BookingUtil();

			//begin();

			// Booking 모든 정보 담는 Container VO
			BookingCreationVO bookingCreationVO = new BookingCreationVO();
			// Validation 결과 담는 VO
			BookingSaveValidationVO bookingSaveValidationVO = new BookingSaveValidationVO();

			bookingCreationVO.setBkgBookingInfoVO(event.getBkgBookingInfoVO());
			bookingCreationVO.setVslSkdVOs(event.getVslSkdVOs());
			bookingCreationVO.setBkgBlNoVO(event.getBkgBlNoVO());
			bookingCreationVO.setBlCustomerInfoVO(event.getBlCustomerInfoVO());
			bookingCreationVO.setBkgQuantityVOs(event.getBkgQuantityVOs());
			bookingCreationVO.setBkgQtyDtlVOs(event.getBkgQtyDtlVOs());
			bookingCreationVO.setBookingSaveValidationVO(bookingSaveValidationVO);

			/************* findFullRoute *******************/
			PrdParameterVO prdParameterVO = util.findFullRoute(bookingCreationVO);
//			util.prdParameterLog(prdParameterVO.getPrdMainInfoVO());

			// 03. createProdCtlRout (***** 추가해야함)
			ProductCatalogCreateBC proBC = new ProductCatalogCreateBCImpl();
			String pctlNo = null;

			// test 중이므로 P/C 생성 실패해도 그대로 진행함
			// 이제는 exception을 받음 2009-12-22 djmin
			//			try {
			pctlNo = proBC.createPrdCtlgRout(prdParameterVO, account);				
			//			} catch(EventException ex) {
			//				log.debug("test 중이므로 P/C 생성 실패해도 그대로 진행함");
			//			}	

			log.debug(" Pctl No : [" + pctlNo + "]");

			// 화면에서 PctlNo가 넘어오면 다음단계로 넘어가고 없으면 findFullRoute 결과값을 확인하여 PctlNo가 없으면 ESD_PRD_018 화면을 띄우고 있으면 다음단계로 진행한다.
			// 임시로 무조건 pop-up 뜨도록 수정 (조용인 수석님 요청, 20091028)
			//			pctlNo = null;
			if(pctlNo != null && pctlNo.length() > 0 && !"FAIL".equals(pctlNo)){
				//pctlNo set
				bookingCreationVO.getBkgBlNoVO().setPctlNo(pctlNo);			
				eventResponse.setETCData("pctl_no", pctlNo);	
			}else{
				eventResponse.setETCData("IsPctlNoPop", "YC");
				log.debug("Pctl Pop Up Call");
				rollback();
				return eventResponse;				
			}
		} catch(EventException ex){
			//			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			//			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0228 : DELETE 클릭
	 * 해당 rqst를 delete 상태로 변경한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteXterRqst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0228Event event = (EsmBkg0228Event)e;
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		try{
			begin();
			command.changeXterRqstStatus(event.getXterRqstNoVOs(), "D", "" ,account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0228 : HOLD 클릭
	 * 해당 rqst를 hold 상태로 변경한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse holdXterRqst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0228Event event = (EsmBkg0228Event)e;
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		try{
			begin();
			command.changeXterRqstStatus(event.getXterRqstNoVOs(), "H", "" ,account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * COA에 재계산을 해야함을 update함<br>
	 *
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param       String remark
	 * @param       SignOnUserAccount account
	 * @return 		void
	 * @exception 	EventException
	 */
/*	private void interfaceToCoa(BkgBlNoVO bkgBlNoVO, String remark, SignOnUserAccount account)throws EventException{
		CostAssignBC coaBc = new CostAssignBCImpl();
		try {
			CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
			coaBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
			coaBkgComIfVo.setCostSrcSysCd("BKG");
			coaBkgComIfVo.setIfRmk(remark);
			coaBkgComIfVo.setCreUsrId(account.getUsr_id());
			coaBkgComIfVo.setUpdUsrId(account.getUsr_id());
			coaBc.modifyCoaCommonInterface(coaBkgComIfVo);
		} catch(EventException ex) {
			log.error("TO COA error bkg no : " + bkgBlNoVO.getBkgNo());
			throw ex;
		} catch(Exception ex) { 
			log.error("TO COA error bkg no : " + bkgBlNoVO.getBkgNo());
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}*/
	


	/**
	 * Mas에 재계산을 해야함을 update함<br>
	 *
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param       String remark
	 * @param       SignOnUserAccount account
	 * @return 		void
	 * @exception 	EventException
	 */
	private void interfaceToMas(BkgBlNoVO bkgBlNoVO, String remark, SignOnUserAccount account)throws EventException{
		CostAssignBC masCmd  = new CostAssignBCImpl();
		try {
			MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
			masBkgComIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
			masBkgComIfVo.setCostSrcSysCd("BKG");
			masBkgComIfVo.setIfRmk(remark);
			masBkgComIfVo.setCreUsrId(account.getUsr_id());
			masBkgComIfVo.setUpdUsrId(account.getUsr_id());
			masCmd.modifyMasCommonInterface(masBkgComIfVo);
		} catch(EventException ex) {
			log.error("TO COA error bkg no : " + bkgBlNoVO.getBkgNo());
			throw ex;
		} catch(Exception ex) { 
			log.error("TO COA error bkg no : " + bkgBlNoVO.getBkgNo());
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
	
	/**
	 * INV에 booking data를 interface한다<br>
	 *
	 * @param 		BkgBlNoVO bkgBlNoVO, SignOnUserAccount account
	 * @return 		void
	 * @exception 	EventException
	 */
	private void interfaceToInv(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account)throws EventException{
		BookingARCreationBC invBc = new BookingARCreationBCImpl();
		ARBkgInterfaceCreationVO bkgIfVo = new ARBkgInterfaceCreationVO();

		bkgIfVo.setBkgNo(bkgBlNoVO.getBkgNo());
		bkgIfVo.setUserId(account.getUsr_id());
		bkgIfVo.setManDivInd("B");

		try {
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
	 * Null 체크<br>
	 *
	 * @param String str
	 * @return boolean
	 */
	private boolean isNull(String str) {
		return (str==null || str.trim().length()==0 || "null".equals(str));
	}
	
	/**
	 * ESM_BKG_0229_09 : Awkward 저장
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAwk(Event e) throws EventException {
		EsmBkg022909Event event = (EsmBkg022909Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialCargoReceiptBC specialCargoReceiptBC = new SpecialCargoReceiptBCImpl();
		BkgBlNoVO bkgBlNoVO = event.getBkgBlNoVO();  
		try {
			AwkCgoApplVO awkCgoApplVO = new AwkCgoApplVO();
			awkCgoApplVO.setBkgAwkCgoVOs(event.getBkgAwkCgoVOs());
			awkCgoApplVO.setAccount(account);
			awkCgoApplVO.setBkgNo(bkgBlNoVO.getBkgNo());
//			awkCgoApplVO.setIbflag("ESM_BKG_0229");
			awkCgoApplVO.setUiId("ESM_BKG_0229");
			specialCargoReceiptBC.manageAwkCargo(awkCgoApplVO, bkgBlNoVO.getCaFlg());
			
			
			// a/k rider 처리
			SpecialCargoRiderBC specialCargoRiderBC = new SpecialCargoRiderBCImpl();
			SpclRiderInVO spclRiderInVO = event.getSpclRiderInVO();
			spclRiderInVO.setAccount(account); 
			BkgImgStoVO[] bkgImgStoVO = spclRiderInVO.getBkgImgStoVOs();
			if( null != bkgImgStoVO ){
				specialCargoRiderBC.manageSpclRider(spclRiderInVO);
			}
						
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00167").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0229_09 : Awkward 저장 (Transaction 포함)
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAwkTx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			eventResponse = (GeneralEventResponse) manageAwk(e);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00167").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0229_12 : Break Bulk 저장
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBb(Event e) throws EventException {

		EsmBkg022912Event event = (EsmBkg022912Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialCargoReceiptBC specialCargoReceiptBC = new SpecialCargoReceiptBCImpl();
		BkgBlNoVO bkgBlNoVO = event.getBkgBlNoVO();  
		try {
			BbCgoApplVO bbCgoApplVO = new BbCgoApplVO();
			bbCgoApplVO.setBkgBbCgoVOs(event.getBkgBbCgoVOs());
			bbCgoApplVO.setAccount(account);
			bbCgoApplVO.setBkgNo(bkgBlNoVO.getBkgNo());
			bbCgoApplVO.setUiId("ESM_BKG_0229");
			specialCargoReceiptBC.manageBbCargo(bbCgoApplVO, bkgBlNoVO.getCaFlg());
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00167").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0229_12 : Break Bulk 저장 (Transaction 포함)
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBbTx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			eventResponse = (GeneralEventResponse) manageBb(e);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00167").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0229_05 : 저장 처리<br>
	 * CM 내용 검증 및 저장 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCm(Event e) throws EventException {
		EsmBkg022905Event event = (EsmBkg022905Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		BLDocumentationCMBC blCmBC = new BLDocumentationCMBCImpl();		
		BLDocumentationBLBC blDoc = new BLDocumentationBLBCImpl();	

		BookingUtil utilCmd = new BookingUtil();
		List<BkgBookingVO> bkgBookingVOs = null;
		BkgBookingVO bkgBookingVO = new BkgBookingVO();
		String blckStwgCd = null;

		BkgBlNoVO bkgBlNoVO = null;
		if(event.getBkgBlNoVO()==null){
			bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(event.getBkgNo());
			bkgBlNoVO.setCaFlg("N");
		} else {
			bkgBlNoVO = event.getBkgBlNoVO();
		}
		String bkgNo = bkgBlNoVO.getBkgNo();
		String caFlg = bkgBlNoVO.getCaFlg();
		 
		//cntr tab의 cntr
		ContainerVO[] containerVOs = event.getContainerVOs();
		CmVO cmVO = event.getCmVO();
		cmVO.getCmBkgInfoVO().setBkgNo(bkgNo);

		List<BkgCntrMfDescVO> cntrMfDescVO = cmVO.getBkgCntrMfDescVOs();
		List<BkgCntrMfDescVO> bkgCntrMfDescVOs = new ArrayList<BkgCntrMfDescVO>();
		try {
			
			if( !"".equals(cntrMfDescVO.get(0).getStwgCd()) ){
            	receiptBC.modifyCmFlgBySpcl(bkgNo, cntrMfDescVO.get(0).getStwgCd(), caFlg);
            }
			
            int len_cntr = containerVOs == null ? 0 : containerVOs.length;
            int len_cm = cntrMfDescVO == null ? 0 : cntrMfDescVO.size();
            int len_cm_cntr = 0;
            
            if ( len_cntr != 0 ) {
	            for(int i = 0; i < len_cm; i++) {
	            	len_cm_cntr = 0;
	                for(int j = 0; j < len_cntr; j++) {
	                	//cntrNo가 없는 것은 제외
	                	if ( cntrMfDescVO.get(i).getCntrNo().equals(containerVOs[j].getCntrNo()) ){
	                		//cntr가 삭제되면 cm도 삭제
	                		if ("D".equals(containerVOs[j].getIbflag())) {
	                			cntrMfDescVO.get(i).setIbflag("D");
	                		}
	                		len_cm_cntr++;
	                	} 
	                }
	                if ( len_cm_cntr > 0 )
	                	bkgCntrMfDescVOs.add(cntrMfDescVO.get(i));
	            }
	
	            cmVO.setCntrMfDescVOs(bkgCntrMfDescVOs);
	            
				/* Validate Container */
	            blCmBC.validateCm(cmVO);
				
	            // WPM관련 자동문구를 조회한다.
	            String oldDesc = blCmBC.searchWpmDescForBl(bkgBlNoVO, "N");
	            
				/* Manage CM */
	            blCmBC.manageCmByXter(cmVO, account, caFlg);
	            
	            //wpm관련 자동문구 저장
	            blDoc.modifyBlDescByWpm(bkgBlNoVO, oldDesc, account.getUsr_id()); 
	            
				/*
				 * BOOKING.BLOCK STOWAGE CODE 업데이트 : commodity가 NOTE BOOK, LCD-TFT, COLOR MONITOR, MONITOR, SHOE인 경우 POD가
				 * "USLAX"나 "USLGB" 면 BOOKING.BLOCK STOWAGE CODE를 LB4로 업데이트 한다.
				 */

				bkgBookingVOs = utilCmd.searchBookingSplitNo(bkgNo);
				if(bkgBookingVOs.size()>0) {
					bkgBookingVO = bkgBookingVOs.get(0);
					blckStwgCd = bkgBookingVO.getBlckStwgCd();
				}
	            if(bkgCntrMfDescVOs != null && bkgCntrMfDescVOs.size() > 0){
//	                String gds_desc = null;
//	                for(int i=0;i<bkgCntrMfDescVOs.size();i++){
//	                    gds_desc = bkgCntrMfDescVOs.get(i).getCntrMfGdsDesc();
//						if(gds_desc != null 
//							&& (gds_desc.indexOf("NOTE BOOK") 	 >= 0 || 
//								gds_desc.indexOf("LCD-TFT")   	 >= 0 || 
//								gds_desc.indexOf("COLOR MONITOR")>= 0 || 
//								gds_desc.indexOf("MONITOR")      >= 0 || 
//								gds_desc.indexOf("SHOE") >= 0)
//							&& ("USLAX".equals(cmBkgInfoVO.getPodCd()) || "USLGB".equals(cmBkgInfoVO.getPodCd()))) {
//							BkgBookingVO bkgBookingVO = new BkgBookingVO();
//							bkgBookingVO.setBkgNo(bkgNo);
//							bkgBookingVO.setBlckStwgCd("LB4");
//							receiptBC.modifyBkgByCm(bkgBookingVO, caFlg);
//							break;
//						}
						// LB3일 경우만 업데이트 처리                  
                        if("LB3".equals(blckStwgCd)) {
	                         for(int i=0;i<bkgCntrMfDescVOs.size();i++){
	                             String gdsDesc = bkgCntrMfDescVOs.get(i).getCntrMfGdsDesc();
	             				if (gdsDesc != null && 
	            		                (gdsDesc.indexOf("NOTE BOOK") >= 0 || 
	            		                	gdsDesc.indexOf("LCD-TFT") >= 0 || 
	            		                	gdsDesc.indexOf("MONITOR") >= 0 || 
	            		                	gdsDesc.indexOf("SHOE") >= 0 || 
	            		                	gdsDesc.indexOf("FOOTWEAR") >= 0) && 
	            		                	"USLGBPT".equals(bkgBookingVO.getPodNodCd())) {
	            		                    bkgBookingVO.setBkgNo(bkgNo);
	            		                    bkgBookingVO.setBlckStwgCd("LB1");
	            		                    receiptBC.modifyBkgByCm(bkgBookingVO, caFlg);	                    
	            		                }
	                         }
                        }

//	                }
	            }
            }
            
			/* Set Message */
			eventResponse.setUserMessage("");
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0229_05 : 저장 처리<br>
	 * CM 내용 검증 및 저장 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCmTx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			eventResponse = (GeneralEventResponse)manageCm(e);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Container 탭(ESM_BKG_0229_03) 저장 처리<br>
	 * (Transaction 처리 (begin, commit, rollback) 없음)<br> 
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageContainer(Event e) throws EventException {
		EsmBkg022903Event event = (EsmBkg022903Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EBookingReceiptBC 		command 	= new EBookingReceiptBCImpl();
			BLDocumentationCMBC 	blCmBC 		= new BLDocumentationCMBCImpl();
			BookingUtil 			util 		= new BookingUtil();
			BlRatingBC 				rateBC	 	= new BlRatingBCImpl();
			GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
			BookingHistoryMgtBC 	histCmd 	= new BookingHistoryMgtBCImpl();
	        BkgCopManageBC 			copCmd 		= new BkgCopManageBCImpl();
		
			BkgBlNoVO bkgBlNoVO = null;
			if(event.getBkgBlNoVO()==null){
				bkgBlNoVO = new BkgBlNoVO();
				bkgBlNoVO.setBkgNo(event.getBkgNo());
			} else {
				bkgBlNoVO = event.getBkgBlNoVO();
			}
			String bkgNo = bkgBlNoVO.getBkgNo();			
			String caFlag = bkgBlNoVO.getCaFlg();
	
			CntrEtcInfoVO 		bkgEtcInfoVO 		= event.getBkgEtcInfoVO();
			ContainerVO[] 		containerVOs 		= event.getContainerVOs();
			BkgCntrSealNoVO[] 	bkgCntrSealNoVOs 	= event.getBkgCntrSealNoVOs();
						
			//Container Type Size Code 변수 정의
			List<MstContainerVO> list = null;
			String cntrTpszCd = null;
			CntrDetailInfoVO detailVo = null;
			
			/* final confirm */
			String fnlCfmFlg = (bkgEtcInfoVO.getFnlCfmFlg()==null)?"N":bkgEtcInfoVO.getFnlCfmFlg();
				
			/* Validate Container */
			CntrEtcInfoVO 		bkgEtcInfoVvdVO 		= null;
			bkgEtcInfoVvdVO = command.manageCntrEtcInfo(bkgBlNoVO);
			
			HistoryTableVO historyTableVO = histCmd.searchOldBkgForHistory("ESM_BKG_1184", bkgBlNoVO);
//			bkgEtcInfoVO.setBkgNo(bkgNo);
//			bkgEtcInfoVO.setTVvd(bkgEtcInfoVvdVO.getTVvd());
//			bkgEtcInfoVO.setBkgCgoTpCd(bkgEtcInfoVvdVO.getBkgCgoTpCd());
//			blCmBC.validateContainer(bkgEtcInfoVO, containerVOs, fnlCfmFlg);
//			blCmBC.validateContainer(bkgEtcInfoVvdVO, containerVOs, fnlCfmFlg);
			/* Validate Container - HJXX에 있는 Container 를  실제 사용하는 Booking 으로 옮김.*/
			List<Map<String,Object>> copCallList = null;
			HistoryLineVO historyLineVO = null;
			BkgDocProcSkdVO bkgDocProcSkdVO = null;
			String uiId = "ESM_BKG_0229_03";
			
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

			/* SealNo */
			List<BkgCntrSealNoVO> updateSealVoList = new ArrayList<BkgCntrSealNoVO>();
			List<BkgCntrSealNoVO> deleteSealVoList = new ArrayList<BkgCntrSealNoVO>();
			int sealLen = (bkgCntrSealNoVOs == null) ? 0 : bkgCntrSealNoVOs.length;
			for (int i = 0; i < sealLen; i++) {
				if ("D".equals(bkgCntrSealNoVOs[i].getIbflag())) {
					deleteSealVoList.add(bkgCntrSealNoVOs[i]);
				} else {
					BkgCntrSealNoVO sealNoVO = bkgCntrSealNoVOs[i];
					if ( sealNoVO.getCntrSealNo().trim().length() > 0 
							&& sealNoVO.getCntrSealNo().trim() != null
							&& sealNoVO.getCntrSealNo().trim() != "") {
						bkgCntrSealNoVOs[i].setCreUsrId(account.getUsr_id());
						bkgCntrSealNoVOs[i].setUpdUsrId(account.getUsr_id());
						bkgCntrSealNoVOs[i].setBkgNo(bkgNo);
						bkgCntrSealNoVOs[i].setPrnFlg("1");
						if ("I".equals(bkgCntrSealNoVOs[i].getIbflag()) && "Y".equals(bkgEtcInfoVvdVO.getCnFlg())) {
							bkgCntrSealNoVOs[i].setSealKndCd("M");
						}
						updateSealVoList.add(bkgCntrSealNoVOs[i]);
					}
				}
			}

			/* Container */
			List<ContainerVO> insertVoList = new ArrayList<ContainerVO>(); //jsy 
			List<ContainerVO> updateVoList = new ArrayList<ContainerVO>();
			List<ContainerVO> deleteVoList = new ArrayList<ContainerVO>();
			List<ContainerVO> changeVoList = new ArrayList<ContainerVO>();
			int cntrLen = containerVOs == null ? 0 : containerVOs.length;
			for (int i = 0; i < cntrLen; i++) {
				detailVo = null;
				String ibflag = containerVOs[i].getIbflag();
				containerVOs[i].setCreUsrId(account.getUsr_id());
				containerVOs[i].setUpdUsrId(account.getUsr_id());
				// Booking 화면의 R/D Term 데이타를 가져오도록 함.
//				containerVOs[i].setRcvTermCd(bkgBookingInfoVO.getRcvTermCd());
//				containerVOs[i].setDeTermCd(bkgBookingInfoVO.getDeTermCd());
				
				// Container Type Size Code를 구하는 부분
				list = util.searchTypeSizeByCntr(containerVOs[i].getCntrNo());
				if (list != null && list.size() > 0) {
					MstContainerVO mstContainerVO = (MstContainerVO) list.get(0);
					cntrTpszCd = mstContainerVO.getCntrTpszCd();
				}
				containerVOs[i].setCntrTpszCd(cntrTpszCd);

				//R type Container 가 입력된 경우 rdCgoFlg를 ‘Y’로 Default Setting.
				if (null!=cntrTpszCd && 0==cntrTpszCd.indexOf("R")) {
					containerVOs[i].setRdCgoFlg("Y");
				}

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
					
				} else if ("U".equals(ibflag)) {
					if (containerVOs[i].getCntrNo().equals(containerVOs[i].getCntrNoOld())) {
						updateVoList.add(containerVOs[i]);
					} else {
						detailVo = blCmBC.searchCntrDtlInfo(containerVOs[i].getCntrNo());
						containerVOs[i].setSocFlg(detailVo.getSocFlg());
						if (containerVOs[i].getCntrVolQty() == null 
							|| "".equals(containerVOs[i].getCntrVolQty().trim()) 
							|| new Float (containerVOs[i].getCntrVolQty()).compareTo(new Float(0.0)) == 0) {
							containerVOs[i].setCntrVolQty("1");
						}
						changeVoList.add(containerVOs[i]);
					}
				} else if ("D".equals(ibflag)) {
					deleteVoList.add(containerVOs[i]);
				}
			}

			/* SealNo Delete */
			if (deleteSealVoList.size() > 0) {
				blCmBC.removeCntrSealNo(deleteSealVoList, caFlag);
			}
			/* Container Delete */
			for (int i = 0; i < deleteVoList.size(); i++) {
				String cntrNo = deleteVoList.get(i).getCntrNo();
				// 1. remove SealNo
				blCmBC.removeCntrSealNo(bkgNo, cntrNo, "", caFlag);
				// 2. remove Rate
				rateBC.removeCntrRateByCntr(bkgNo, cntrNo, "");
				// 3. remove Reference detail
				receiptBC.removeReferenceByCntr(bkgNo, cntrNo, caFlag);
				// 4. remove Reference
				receiptBC.removeReferenceDetailByCntr(bkgNo, cntrNo, caFlag);
				// 5. remove Manifest
				blCmBC.removeCntrMfDesc(bkgNo, cntrNo, caFlag);
				// 6. remove Container
				blCmBC.removeContainer(bkgNo, cntrNo, caFlag);
//				// 7. remove Po No
//				blCmBC.removePoNo(bkgNo, cntrNo, caFlag);
			}

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
			
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("VGM_PROC_CTR");			
			List<BkgHrdCdgCtntVO> BkgHrdCdgCtntVOs = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
			String partialCntrVgm = "";
			if(BkgHrdCdgCtntVOs.size() > 0){
				partialCntrVgm = BkgHrdCdgCtntVOs.get(0).getAttrCtnt7();// Partial CNTR 의 VGM Update
			}
			//partial CNTR 도 찾아서 같은 걸로 update
			//partial CNTR 도 찾아서 같은 걸로 update
			if(!"OFF".equals(partialCntrVgm)){
		        if(!"Y".equals(bkgBlNoVO.getCaFlg())){        
		        	if(updateVoList.size() > 0){
			        	for(int j=0; j<updateVoList.size(); j++){
			        		if("1".equals(updateVoList.get(j).getCntrPrtFlg())){
				        		//partial bkg list 조회
					        	List<BkgContainerVO> ptlBkgList = blCmBC.searchPtlCntrBkg(bkgBlNoVO.getBkgNo(), updateVoList.get(j).getCntrNo());
					        	if(ptlBkgList!=null && ptlBkgList.size()>0){
					        		for(int i=0; i<ptlBkgList.size(); i++){
					        			//target bkg history 조회
					        			BkgBlNoVO bkgBlNoVO1 = new BkgBlNoVO();
					        			bkgBlNoVO1.setBkgNo(ptlBkgList.get(i).getBkgNo());
					        			HistoryTableVO historyTableVO1 = histCmd.searchOldBkgForHistory("ESM_BKG_0229_03", bkgBlNoVO1);
					        			//vgm 복사
					        			blCmBC.modifyPtlCntrVgmCopy(bkgBlNoVO.getBkgNo(), updateVoList.get(j).getCntrNo(), ptlBkgList.get(i).getBkgNo(), account);
							        	//target bkg history update
					        			histCmd.manageBookingHistory(uiId, historyTableVO1, account);
					        		}
					        	}
			        		}
			        	}
		        	}
		        }
			}
			
			// MND Tab에서 처리함
			/* Manage Po No Date */
//			for (int i = 0; i < updateVoList.size(); i++) {
//				BkgReferenceVO   bkgReferenceVO  = null;
//				BkgReferenceVO[] bkgReferenceVOs = new BkgReferenceVO[1];
//				PoOtherNoVO    poOtherNoVO    = new PoOtherNoVO();
//				PoOtherNoBkgVO poOtherNoBkgVO = new PoOtherNoBkgVO();
//				
//				bkgReferenceVO = command.searchAlpsPoNo(bkgNo,updateVoList.get(i).getCntrNo() );
//				if (bkgReferenceVO != null){
//					bkgReferenceVO.setCustRefNoCtnt(updateVoList.get(i).getPoNo());
//					bkgReferenceVO.setIbflag(updateVoList.get(i).getIbflag());
//					
//					poOtherNoBkgVO.setBkgNo(bkgNo);
//					poOtherNoBkgVO.setCntrNo(updateVoList.get(i).getCntrNo());				
//					
//					bkgReferenceVOs[0]= bkgReferenceVO;
//					poOtherNoVO.setI_poOtherCntrVOs(bkgReferenceVOs);
//				}
//				poOtherNoVO.setIo_poOtherNoBkgVO(poOtherNoBkgVO);
//				poOtherNoVO.setAccount(account);
//			
//				receiptBC.manageRefNo(poOtherNoVO, caFlag);
//			}
			/* Container Change */
			for (int i = 0; i < changeVoList.size(); i++) {
				String cntrNo = changeVoList.get(i).getCntrNo();
				String cntrNoOld = changeVoList.get(i).getCntrNoOld();
				// 1. insert Container
				// 4. change Manifest
				blCmBC.changeCntrMfDesc(bkgNo, cntrNo, cntrNoOld, caFlag);
				// 5. change Rate
				rateBC.changeCntrRate(bkgNo, cntrNo, cntrNoOld);
				// 6. delete Container(Old)
				blCmBC.removeContainer(bkgNo, cntrNoOld, caFlag);
			}
			/* SealNo Merge */
			if (updateSealVoList.size() > 0) {
				blCmBC.manageCntrSealNo(updateSealVoList, caFlag);
			}

			/* Manage Credit Date */
			rateBC.manageCrdDt(bkgNo, bkgEtcInfoVO.getEvntDt(), caFlag);

            PerformanceReportBC formanceCmd = new PerformanceReportBCImpl();
            formanceCmd.manageQtyCntrCoposite(bkgBlNoVO.getBkgNo(), "CN"); 
			
	         // sms 전송로직 추가 .jsy ,manageContainer --s---------
            BkgBookingInfoVO bkgBookingInfoVO = rateBC.searchBkgBookingInfo(bkgBlNoVO);
            GeneralBookingSearchBC  searchBC 	= new GeneralBookingSearchBCImpl();
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
				&& bFinalCllPolYdChk
				&& "N".equals(caFlag)) {
				String vgmChgFlg = "N";
				String vgmChgCntrList = "";
				
				if(historyTableVO != null && historyTableVO.getBkgContainerVOs() != null &&  historyTableVO.getBkgContainerVOs().size() > 0){
					vgmChgCntrList = blCmBC.searchVgmChgHis(historyTableVO.getBkgContainerVOs());
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
					List<BkgNtcHisVO> bkgNtcHisVOs = searchBC.sendMailSmsByPodChange(smsList, bkgNo, sndMsg, sndParam, account );
					histCmd.createBkgNtcHis(bkgNtcHisVOs, "");
				}
				
				/*//1.Cntr Attach
				int len = insertVoList == null ? 0 : insertVoList.size();
	            for (int i = 0; i < len; i++) {
	                cntrVo = insertVoList.get(i);
	                log.debug("***** sms attach Container : " + cntrVo.getIbflag() + " - " + cntrVo.getCntrNo());
	                //메일 보낼 대상 조회
	                smsList = receiptBC.getPhnId(slancd, bkgBookingInfoVO.getBkgOfcCd(), skdDirCd);
	                //전송 메세지.
					sndMsg = "\n\n(" + slancd +"-" + skdDirCd+") " +" " + newFirstVvd+" "+ bkgNo+ " " +cntrVo.getCntrNo()+" 선적 추가 발생 " ; 
					List<BkgNtcHisVO> bkgNtcHisVOs = searchBC.sendMailSmsByPodChange(smsList, bkgNo, sndMsg, account );
					histCmd.createBkgNtcHis(bkgNtcHisVOs, "");
	                
	            }
	            
	            //2.Cntr Detach 
	            len = deleteVoList == null ? 0 : deleteVoList.size();
	            for (int i = 0; i < len; i++) {
	                cntrVo = deleteVoList.get(i);
	                log.debug("***** sms detach Container : " + cntrVo.getIbflag() + " - " + cntrVo.getCntrNo());
	                //메일 보낼 대상 조회
	                smsList = receiptBC.getPhnId(slancd, bkgBookingInfoVO.getBkgOfcCd(), skdDirCd);
	              //전송 메세지.
					sndMsg = "\n\n(" + slancd+"-" + skdDirCd+") " +" " + newFirstVvd+" "+ bkgNo+ " " +cntrVo.getCntrNo()+" 선적 취소 발생 " ; 
					List<BkgNtcHisVO> bkgNtcHisVOs = searchBC.sendMailSmsByPodChange(smsList, bkgNo, sndMsg, account );
					histCmd.createBkgNtcHis(bkgNtcHisVOs, "");
	                
	            }
	          //3.Cntr No 변경 
	            len = changeVoList == null ? 0 : changeVoList.size();
	            for (int i = 0; i < len; i++) {
	                cntrVo = changeVoList.get(i);
	                log.debug("***** sms change Container : " + cntrVo.getIbflag() + " - " + cntrVo.getCntrNo());
	                //메일 보낼 대상 조회
	                smsList = receiptBC.getPhnId(slancd, bkgBookingInfoVO.getBkgOfcCd(),skdDirCd);
	                //전송 메세지 1.
					sndMsg = "\n\n(" + slancd +"-" + skdDirCd+") " +" " + newFirstVvd+" "+ bkgNo+ " " +cntrVo.getCntrNo()+" 선적 추가 발생 " ; 
					List<BkgNtcHisVO> bkgNtcHisVOs = searchBC.sendMailSmsByPodChange(smsList, bkgNo, sndMsg, account );
					histCmd.createBkgNtcHis(bkgNtcHisVOs, "");
	                //전송 메세지 2.
					sndMsg = "\n\n(" + slancd+"-" + skdDirCd+") " +" " + newFirstVvd+" "+ bkgNo+ " " +cntrVo.getCntrNoOld()+" 선적 취소 발생 " ; 
					bkgNtcHisVOs = searchBC.sendMailSmsByPodChange(smsList, bkgNo, sndMsg, account );
					histCmd.createBkgNtcHis(bkgNtcHisVOs, "");
	                
	            }*/

			}
			
			//sms 전송로직 추가 .jsy --e---------

			
			/* Manage Doc Process */
			//eBKG에서 final confirm 없음
//			if (!"".equals(modifyFnlCfmFlg) && "N".equals(caFlag)) {
//				String uiId = "ESM_BKG_0229_03";
//				HistoryLineVO historyLineVO = new HistoryLineVO();			
//				historyLineVO.setBkgDocProcTpCd("Y".equals(fnlCfmFlg) ? "CNTCFM" : "CNTRLS");
//				historyLineVO.setBkgNo(bkgNo);
//				historyLineVO.setCaFlg(caFlag);
//				historyLineVO.setCrntCtnt("");
//				historyLineVO.setHisCateNm("");
//				historyLineVO.setLocalTime("");
//				historyLineVO.setUiId(uiId);
//				historyBC.createBkgHistoryLine(historyLineVO, account);
//			}
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0229_03 : 저장 처리<br>
	 * Container 내용 검증 및 저장 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageContainerTx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			manageContainer(e);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0229_08 : Danger 저장
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDg(Event e) throws EventException {
		EsmBkg022908Event event = (EsmBkg022908Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialCargoReceiptBC specialCargoReceiptBC = new SpecialCargoReceiptBCImpl();
		BkgBlNoVO bkgBlNoVO = event.getBkgBlNoVO();  
		try {
			DgCgoApplVO dgCgoApplVO = new DgCgoApplVO();
			dgCgoApplVO.setDgCgoListVOs(event.getDgCgoListVOs());
			dgCgoApplVO.setAccount(account);
			dgCgoApplVO.setBkgNo(bkgBlNoVO.getBkgNo());
//			dgCgoApplVO.setIbflag("ESM_BKG_0229");
			dgCgoApplVO.setUiId("ESM_BKG_0229");
			// 누락된 DG 정보 넣어 주기, 만약 앞으로, EDI or WEB 을 통해 해당 값들이 들어온다면 아래 로직은 삭제해도 될 듯.
			if(dgCgoApplVO.getDgCgoListVOs() != null && dgCgoApplVO.getDgCgoListVOs().length > 0){
				for (DgCgoListVO dgcgo : dgCgoApplVO.getDgCgoListVOs()){
					if(StringUtils.isEmpty(dgcgo.getPsaNo())){
						DgCgoApplVO vo = specialCargoReceiptBC.searchDgUnNumber(dgcgo.getBkgNo(), dgcgo.getImdgUnNo() + "@@" + dgcgo.getImdgUnNoSeq(), dgcgo.getImdgClssCd(), null );
						if(vo != null){
							for(ScgImdgUnNoVO un : vo.getScgImdgUnNo()){
								dgcgo.setPsaNo(un.getPsaNo() == null ? "" : un.getPsaNo());
								break;
							}
						}
					}
					
				}
			}
			specialCargoReceiptBC.manageDgCargo(dgCgoApplVO, bkgBlNoVO.getCaFlg());
			
			// d/g rider 처리
			SpecialCargoRiderBC specialCargoRiderBC = new SpecialCargoRiderBCImpl();
			SpclRiderInVO spclRiderInVO = event.getSpclRiderInVO();
			spclRiderInVO.setAccount(account); 
			BkgImgStoVO[] bkgImgStoVO = spclRiderInVO.getBkgImgStoVOs();
			if( null != bkgImgStoVO ){
				specialCargoRiderBC.manageSpclRider(spclRiderInVO);
			}
			
			
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00167").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0229_08 : Danger 저장<br>
	 * Transaction 처리 있음
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDgTx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			eventResponse = (GeneralEventResponse)manageDg(e);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00167").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0229_10 : 저장 처리<br>
	 * HBL 내용 검증 및 저장 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageHbl(Event e) throws EventException {
		EsmBkg022910Event event = (EsmBkg022910Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BLDocumentationBLBC docCmd = new BLDocumentationBLBCImpl();
		
		HblVO hblVO = event.getHblVO();
		XterRqstNoVO rqstNoVO = event.getXterRqstNoVO();		
		BkgBlNoVO bkgBlNoVO = null;	
		
		List<HblDtlInfoVO> hblDtlVO = hblVO.getHblDtlInfoVOs();
        String mfNo   = null;	
        String hblSeq = null;
        
		
		if(event.getBkgBlNoVO()==null){
			bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(event.getBkgNo());
		} else {
			bkgBlNoVO = event.getBkgBlNoVO();
		}
		
		try {
			// validate
			docCmd.validateHbl(hblVO);
			// manage house b/l
			docCmd.manageHblByXter(hblVO, rqstNoVO, account, bkgBlNoVO.getCaFlg());
			
			for(int i = 0; i < hblDtlVO.size(); i++) {
				if("I".equals(hblDtlVO.get(i).getIbflag())) {
		            hblSeq = hblDtlVO.get(i).getHblSeq();
		            /* search maximum MfNo */
		            mfNo = docCmd.searchMaxMfNo(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getBlNo(), bkgBlNoVO.getCaFlg());               
		            log.debug("=====> mfNo    : " + mfNo);
		            
		            /* update MfNo */
		            docCmd.modifyNvoccFileNo(bkgBlNoVO.getBkgNo(), hblSeq, mfNo, account, bkgBlNoVO.getCaFlg());
				}
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0229_11 : 저장 처리<br>
	 * HBL2 내용 검증 및 저장 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageHbl2(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg022911Event event = (EsmBkg022911Event) e;
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();

		try {
			// 01. Direct NVO-AMS File No를 관리한다.
			receiptBC.manageNVOFileNumber(event.getBkgUsaCstmsFileNoVOs(), account, event.getBkgBlNoVO());
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex); 
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0229_11 : 저장 처리<br>
	 * HBL2 내용 검증 및 저장 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageHbl2Tx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			eventResponse = (GeneralEventResponse)manageHbl2(e);
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
	 * ESM_BKG_0229_10 : 저장 처리<br>
	 * HBL 내용 검증 및 저장 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageHblTx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			eventResponse = (GeneralEventResponse)manageHbl(e);
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
	 * M&D TAB(ESM_BKG_0229_04) 내용 검증 및 저장 처리<br>
	 * (Transaction begin, commit, rollback 없음)<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	/**
	 * M&D TAB(ESM_BKG_0229_04) 내용 검증 및 저장 처리<br>
	 * (Transaction begin, commit, rollback 없음)<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMnd(Event e) throws EventException {
		EsmBkg022904Event event = (EsmBkg022904Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			BLDocumentationBLBC blDocBC = new BLDocumentationBLBCImpl();
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
			BlRatingBC rateCmd = new BlRatingBCImpl();
			
			BkgBlNoVO bkgBlNoVO = null;
			if(event.getBkgBlNoVO()==null){
				bkgBlNoVO = new BkgBlNoVO();
				bkgBlNoVO.setBkgNo(event.getBkgNo());
				bkgBlNoVO.setCaFlg("N");
			} else {
				bkgBlNoVO = event.getBkgBlNoVO();
			}
			
			/* Validate MnD */
			event.getMndVO().setBkgNo(bkgBlNoVO.getBkgNo());
			event.getMndVO().setBdrFlg(bkgBlNoVO.getBdrFlg());
			blDocBC.validateMnd( event.getMndVO());
			
			event.getMndVO().setMkDesc(event.getMndVO().getMkDesc());
			event.getMndVO().setDgCmdtDesc(event.getMndVO().getDgCmdtDesc());
			
			/* Manage MnD */
			blDocBC.manageMnd( event.getMndVO(), account, bkgBlNoVO.getCaFlg());
			
			/* Manage Rate*/
			event.getMndVO().setFrtTermPrnFlg("Y");
			rateCmd.manageFrtTerm(bkgBlNoVO.getBkgNo(), event.getMndVO().getFrtTermCd(), event.getMndVO().getFrtTermPrnFlg(), account, bkgBlNoVO.getCaFlg());
			
			/* Export License Number */
//			if(event.getAlpsXptImpLicListVOs() != null && event.getAlpsXptImpLicListVOs().length>0){
				blDocBC.manageXptLicByXter(bkgBlNoVO, event.getAlpsXptImpLicListVOs(), account);
//			}
			
			/* P/O & Other No */
			PoOtherNoVO poOtherNoVO = new PoOtherNoVO();
			PoOtherNoBkgVO poOtherNoBkgVO = new PoOtherNoBkgVO();
			poOtherNoBkgVO.setBkgNo(bkgBlNoVO.getBkgNo());
						
			poOtherNoVO.setIo_poOtherNoBkgVO(poOtherNoBkgVO);//condition
			poOtherNoVO.setI_poOtherNoBkgVOs(event.getPoOtherNoBkgVOs());//bkg
			poOtherNoVO.setI_poOtherShipVOs(event.getPoOtherShipVOs());// ship 
			poOtherNoVO.setI_poOtherCntrVOs(event.getPoOtherCntrVOs());// cntr
			poOtherNoVO.setAccount(account);

			receiptBC.manageRefNo(poOtherNoVO, bkgBlNoVO.getCaFlg());
			if(event.getPoOtherCmVOs()!=null && event.getPoOtherCmVOs().length>0){
				BkgRefDtlVO[] cmPoVOs = event.getPoOtherCmVOs();
				
				for(int i=0;i<cmPoVOs.length;i++){
					BkgRefDtlVO[] cmPoVO = new BkgRefDtlVO[1];
					cmPoVO[0] = cmPoVOs[i];
					poOtherNoVO.setI_poOtherCmVOs(cmPoVO); // cm
					poOtherNoVO.getIo_poOtherNoBkgVO().setCntrNo(cmPoVO[0].getCntrNo());
					receiptBC.manageRefDetail(poOtherNoVO, bkgBlNoVO.getCaFlg());
				}
			}
			
			if(event.getPoOtherShipVOs()!=null && event.getPoOtherShipVOs().length>0){
				receiptBC.manageRefDetail(poOtherNoVO, bkgBlNoVO.getCaFlg());
			}
			
			//B/L rider  
			if(event.getBlRiderVOs()!=null && event.getBlRiderVOs().length>0){				
				blDocBC.manageBlrider(event.getBlRiderVOs(), account,bkgBlNoVO.getBkgNo());
			}
			
			// Wharfage
			BlRatingBC blRatingBC = new BlRatingBCImpl();
			if (event.getKrWhfBlExptInfoVOs() != null){
				BlKrWhfExptVO blKrWhfExptVO = new BlKrWhfExptVO();
				KrWhfBlExptInfoVO[] arrKrWhfBlExptInfoVOs = event.getKrWhfBlExptInfoVOs();  
				for(int i=0;i<arrKrWhfBlExptInfoVOs.length;i++){
					if ("Y".equals(arrKrWhfBlExptInfoVOs[i].getKrWhfExptApplFlg())){
						blKrWhfExptVO.setBkgNo(bkgBlNoVO.getBkgNo());
						blKrWhfExptVO.setKrWhfExptCd(arrKrWhfBlExptInfoVOs[i].getKrWhfExptCd());
						blRatingBC.modifyBlKrWhfExpt(blKrWhfExptVO, account);
					}
				}
			}			

			if (event.getIdXptImpLicVOs() != null){
				XptImpLicVO[] idXptImpLicVOs = event.getIdXptImpLicVOs();
				List<XptImpLicVO> insertVoList = null;
//				List<XptImpLicVO> updateVoList = null;
				List<XptImpLicVO> deleteVoList = null;
				
				int idx1=0;
//				int idx2=0;
				int idx3=0;
				if (idXptImpLicVOs != null) {
					for (int i = 0; i < idXptImpLicVOs.length; i++) {	
						if ("I".equals(idXptImpLicVOs[i].getIbflag())) {
							idx1++;
//						} else if ("U".equals(idXptImpLicVOs[i].getIbflag())) {
//							idx2++;
						} else if ("D".equals(idXptImpLicVOs[i].getIbflag())) {
							idx3++;
						}
					
					}
				}
				insertVoList = new ArrayList<XptImpLicVO>(idx1);
//				updateVoList = new ArrayList<XptImpLicVO>(idx2);
				XptImpLicVO deleteVO = new XptImpLicVO();
				deleteVoList = new ArrayList<XptImpLicVO>(idx3);
				deleteVO.setBkgNo(bkgBlNoVO.getBkgNo());
				deleteVO.setIoBndCd("O");
				deleteVO.setCntCd("ID");
				deleteVoList.add(deleteVO);
				blDocBC.removeExportImportNumber(deleteVoList, bkgBlNoVO.getCaFlg());
				if (idXptImpLicVOs != null) {
					int insCnt = 0;
					for (int i = 0; i < idXptImpLicVOs.length; i++) {						
						idXptImpLicVOs[i].setCreUsrId(account.getUsr_id());
						idXptImpLicVOs[i].setUpdUsrId(account.getUsr_id());	
						if ("I".equals(idXptImpLicVOs[i].getIbflag())) {
							insCnt++;
							idXptImpLicVOs[i].setSeq(Integer.toString(insCnt));
							insertVoList.add(idXptImpLicVOs[i]);
						}
//						if ("U".equals(idXptImpLicVOs[i].getIbflag())) {
//							updateVoList.add(idXptImpLicVOs[i]);
//						}
//						if ("D".equals(idXptImpLicVOs[i].getIbflag())) {
//							deleteVoList.add(idXptImpLicVOs[i]);
//						}
					}
				}
	
				if (insertVoList.size() > 0) blDocBC.createExportImportNumber(insertVoList, "ID", bkgBlNoVO.getCaFlg());
//				if (updateVoList.size() > 0) blDocBC.modifyExportImportNumber(updateVoList, "ID", bkgBlNoVO.getCaFlg());	
//				if (deleteVoList.size() > 0) blDocBC.removeExportImportNumber(deleteVoList, bkgBlNoVO.getCaFlg());
			}
			
			if(event.getBkgClauseLockVOs()!=null){
				receiptBC.manageBkgClauseLock(event.getBkgClauseLockVOs(), account);
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex); 
		}
		return eventResponse;
	}
	
	/**
	 * M&D TAB(ESM_BKG_0229_04) 내용 검증 및 저장 처리<br>
	 * (Transaction begin, commit, rollback 있음)<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMndTx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			eventResponse = (GeneralEventResponse)manageMnd(e);
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex); 
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0229_07 : Reefer 저장
	 * (Transaction begin, commit, rollback 없음)
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRf(Event e) throws EventException {
		EsmBkg022907Event event = (EsmBkg022907Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		SpecialCargoReceiptBC specialCargoReceiptBC = new SpecialCargoReceiptBCImpl();
		BLDocumentationCMBC bldocumentationCMBC = new BLDocumentationCMBCImpl();
		BkgBlNoVO bkgBlNoVO = event.getBkgBlNoVO();
		try {
			RfCgoApplVO rfCgoApplVO = new RfCgoApplVO();				        
			rfCgoApplVO.setBkgRfCgoVOs(event.getBkgRfCgoVOs());
			rfCgoApplVO.setAccount(account);
			rfCgoApplVO.setBkgNo(bkgBlNoVO.getBkgNo());
			rfCgoApplVO.setUiId("ESM_BKG_0229");
			specialCargoReceiptBC.manageRfCargo(rfCgoApplVO, bkgBlNoVO.getCaFlg());
			bldocumentationCMBC.modifyCntrFlgByRfCgo(rfCgoApplVO, bkgBlNoVO.getCaFlg());
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00167").getMessage(), ex);
		}
		return eventResponse;
	}	

	/**
	 * ESM_BKG_0229_07 : Reefer 저장
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRfTx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			eventResponse = (GeneralEventResponse)manageRf(e);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00167").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0229_06 화면의 Tro 관련 저장(eBooking 전용)<br>
	 * @author    Lee NamKyung
	 * @param     e Event
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTro(Event e) throws EventException {
		EsmBkg022906Event event = (EsmBkg022906Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		TransferOrderIssueBC command = new TransferOrderIssueBCImpl();
		try{
			String isEurFlg   = JSPUtil.getNullNoTrim(event.getIsEurFlg());  //eBooking의 경우, Eur 여부
			
			EurTroVO      eurTroVO       = null; 
			EurTroMstVO[] arrEurTroMstVO = null;  
			EurTroDtlVO[] arrEurTroDtlVO = null;  
			TroMstVO[]    arrTroMstVO    = event.getTroVO().getArrTroMstVO();
			TroDtlVO[]    arrTroDtlVO    = null;
			String bkgNo      = event.getBkgBlNoVO().getBkgNo();
			String boundCd    = event.getBoundCd();
			String rtnTroFlg  = event.getRtnTroFlg();

			if ("Y".equals(isEurFlg)) {
				eurTroVO = new EurTroVO();
				arrEurTroMstVO = new EurTroMstVO[arrTroMstVO.length];  //eBooking Eur 의  경우, mst/dtl 입력값이 1:1 매핑되도록 정의하여 조회함. 
				arrEurTroDtlVO = new EurTroDtlVO[arrTroMstVO.length];
				if (arrTroMstVO != null) {
					for (int i=0; i<arrTroMstVO.length; i++) {
						//01. mst
						EurTroMstVO eurTroMstVO = new EurTroMstVO();						
						eurTroMstVO.setBkgNo       (bkgNo);
						eurTroMstVO.setIoBndCd     (boundCd);
						eurTroMstVO.setIbflag      (arrTroMstVO[i].getIbflag());
						eurTroMstVO.setCxlFlg      (arrTroMstVO[i].getCxlFlg());
						eurTroMstVO.setTroSeq      (arrTroMstVO[i].getTroSeq());
						eurTroMstVO.setSpclInstrRmk(arrTroMstVO[i].getDiffRmk());
						eurTroMstVO.setCreOfcCd(account.getOfc_cd());
						arrEurTroMstVO[i] = eurTroMstVO;

						//02. dtl
						EurTroDtlVO eurTroDtlVO = new EurTroDtlVO();		
						eurTroDtlVO.setDorPstNo    (arrTroMstVO[i].getDorPstNo());
						eurTroDtlVO.setDorAddr1    (arrTroMstVO[i].getActShprNm());
						if(arrTroMstVO[i].getActShprAddr().length() > 50){
							eurTroDtlVO.setDorAddr2    (arrTroMstVO[i].getActShprAddr().substring(0, 50));
							
							if(arrTroMstVO[i].getActShprAddr().length() > 100){
								eurTroDtlVO.setDorAddr3    (arrTroMstVO[i].getActShprAddr().substring(50, 100));
								eurTroDtlVO.setDorAddr4    (arrTroMstVO[i].getActShprAddr().substring(100));
							} else{
								eurTroDtlVO.setDorAddr3    (arrTroMstVO[i].getActShprAddr().substring(50));
							}
							
						} else {
							eurTroDtlVO.setDorAddr2    (arrTroMstVO[i].getActShprAddr());
						}
						
						eurTroDtlVO.setCntcPsonNm  (arrTroMstVO[i].getCntcPsonNm());
						eurTroDtlVO.setCntcPhnNo   (arrTroMstVO[i].getCntcPhnNo());	
						eurTroDtlVO.setDorAddrTpCd("D");
						arrEurTroDtlVO[i] = eurTroDtlVO;
					}
				}
				arrTroDtlVO    = event.getTroVO().getArrTroDtlVO();

				if (arrTroDtlVO != null) {
					// NOT NULL column에 대한 보정 작업
					for (int i = 0; i < arrTroDtlVO.length; i++) {
						if (arrTroDtlVO[i].getCxlFlg() == null || !"Y".equals(arrTroDtlVO[i].getCxlFlg())){
							arrTroDtlVO[i].setCxlFlg("N");
						}
						//01. dtl
						arrEurTroDtlVO[i].setBkgNo       (bkgNo);
						arrEurTroDtlVO[i].setIoBndCd     (boundCd);
						arrEurTroDtlVO[i].setIbflag      (arrTroDtlVO[i].getIbflag());						
						arrEurTroDtlVO[i].setTroSeq      (arrTroDtlVO[i].getTroSeq());
						arrEurTroDtlVO[i].setTroSubSeq   (arrTroDtlVO[i].getTroSubSeq());	
						arrEurTroDtlVO[i].setArrDt       (arrTroDtlVO[i].getDorArrDt());
						arrEurTroDtlVO[i].setDorAddrTpCd (arrTroDtlVO[i].getDorAddrTpCd());
						//02. mst
						arrEurTroMstVO[i].setCntrTpszCd  (arrTroDtlVO[i].getCntrTpszCd());
						String strCntrPkupYdCd = "";
						if(!"".equals(arrTroDtlVO[i].getPkupYdCd())) {
							strCntrPkupYdCd = arrTroDtlVO[i].getPkupLocCd() + arrTroDtlVO[i].getPkupYdCd();
						}
						arrEurTroMstVO[i].setCntrPkupYdCd(strCntrPkupYdCd); 

						String strCntrRtnYdCd = "";
						if(!"".equals(arrTroDtlVO[i].getRtnYdCd())) {
							strCntrRtnYdCd = arrTroDtlVO[i].getRtnLocCd() + arrTroDtlVO[i].getRtnYdCd();
						}
						arrEurTroMstVO[i].setCntrRtnYdCd(strCntrRtnYdCd);
						arrEurTroMstVO[i].setCntrRtnDt(arrTroDtlVO[i].getRtnDt());
						arrEurTroMstVO[i].setBkgTrspMzdCd(arrTroDtlVO[i].getBkgTrspModCd());
						
					}
				}
				eurTroVO.setBkgNo  (bkgNo);
				eurTroVO.setIoBndCd(boundCd);
				eurTroVO.setArrEurTroMstVO(arrEurTroMstVO);
				eurTroVO.setArrEurTroDtlVO(arrEurTroDtlVO);
			} else {	
				if (arrTroMstVO != null) {
					for (int i=0; i<arrTroMstVO.length; i++) {
						arrTroMstVO[i].setBkgNo    (bkgNo);
						arrTroMstVO[i].setIoBndCd  (boundCd);
						arrTroMstVO[i].setRtnTroFlg(rtnTroFlg);
					}
				}
				arrTroDtlVO = event.getTroVO().getArrTroDtlVO();	
				if (arrTroDtlVO != null) {
					// NOT NULL column에 대한 보정 작업
					for (int i = 0; i < arrTroDtlVO.length; i++) {
						if (arrTroDtlVO[i].getCxlFlg() == null || !"Y".equals(arrTroDtlVO[i].getCxlFlg())){
							arrTroDtlVO[i].setCxlFlg("N");
						}
						arrTroDtlVO[i].setBkgNo    (bkgNo);
						arrTroDtlVO[i].setIoBndCd  (boundCd);
						arrTroDtlVO[i].setRtnTroFlg(rtnTroFlg);
					}
				}
				event.getTroVO().setArrTroMstVO(arrTroMstVO);
				event.getTroVO().setArrTroDtlVO(arrTroDtlVO);
			}

			//02. Tro 저장
			command.manageTroByXter(event.getTroVO(), eurTroVO, event.getIsEurFlg(), account);  //containVO

			//---------------------------
			//03. Qty 저장
			//BkgQuantityVO[] arrBkgQuantityVO = (BkgQuantityVO[])responseData.get(WebKeys.ER_DBROWSETS);
			//command3.modifyBkgQtyByTro(arrBkgQuantityVO, boundCd, account);
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0229_06 화면의 Tro 관련 저장(eBooking 전용)<br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTroTx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			eventResponse = (GeneralEventResponse)manageTro(e);
			commit();
		} catch (EventException ex){
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  
		}
		return eventResponse;
	}

	/**
	 * Booking을 수정한다.(ESM_BKG_0079_01)<br>
	 * 
	 * @author KimByungKyu 
	 * @param 	bookingCreationVO BookingCreationVO
	 * @return 	BookingSaveValidationVO
	 * @exception EventException 
	 */
	private BookingCreationVO modifyBkgInfo(BookingCreationVO bookingCreationVO) throws EventException {
		try{
			GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
			BLDocumentationCMBC 	blDocCmBC 	= new BLDocumentationCMBCImpl();
			BLDocumentationBLBC 	blDocBlBC 	= new BLDocumentationBLBCImpl();
			BookingHistoryMgtBC 	historyBC 	= new BookingHistoryMgtBCImpl();
			GeneralBookingSearchBC  searchBC 	= new GeneralBookingSearchBCImpl();
			BkgCopManageBC 			copBC       = null;
			
			BkgBlNoVO        bkgBlNoVO        = bookingCreationVO.getBkgBlNoVO();
			BkgBookingInfoVO bkgBookingInfoVO = bookingCreationVO.getBkgBookingInfoVO();

			// 01. validateBookingSave
			bookingCreationVO = receiptBC.validateBookingSave(bookingCreationVO, account);
			BookingSaveValidationVO bookingSaveValidationVO = bookingCreationVO.getBookingSaveValidationVO();
			bkgBlNoVO.setUiId("ESM_BKG_0229");
			
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
			
			if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCloseBkgFlag())){
				return bookingCreationVO;
			} else if("Y".equals(bookingSaveValidationVO.getTsCloseBkgFlag())){
				return bookingCreationVO;
			} else if("Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCbfBkgFlag())){
				return bookingCreationVO;
			} else {
				bookingCreationVO.getBookingSaveValidationVO().setCloseBkgFlag("N");
				bookingCreationVO.getBookingSaveValidationVO().setCbfBkgFlag("N");
			}
			
			// 04. searchOldBkgInfo
			OldBkgInfoVO oldBkgInfoVO = receiptBC.searchOldBkgInfo(bkgBlNoVO);

			bookingCreationVO.setOldBkgInfoVO(oldBkgInfoVO);
			
			// CHM-201642190 일본 e-Bkg upload 시, ALPS S/I Contact Column Update
			String[] jpnOfc = new String[]{"TYOSC","OSASO","NGOSO","SMZSO"};
			if(StringUtils.isEmpty(bkgBookingInfoVO.getSiCntcPsonNm()) && Arrays.asList(jpnOfc).contains(bkgBookingInfoVO.getBkgOfcCd())){
				bkgBookingInfoVO.setSiCntcPsonNm(bkgBookingInfoVO.getBkgCntcPsonNm());
				bkgBookingInfoVO.setSiCntcPsonEml(bkgBookingInfoVO.getBkgCntcPsonEml());
				bkgBookingInfoVO.setSiCntcPsonFaxNo(bkgBookingInfoVO.getBkgCntcPsonFaxNo());
				bkgBookingInfoVO.setSiCntcPsonMphnNo(bkgBookingInfoVO.getBkgCntcPsonMphnNo());
				bkgBookingInfoVO.setSiCntcPsonPhnNo(bkgBookingInfoVO.getBkgCntcPsonPhnNo());			
			}
			// 05. modifyBooking
			bookingCreationVO.setBkgBlNoVO(bkgBlNoVO);
			bookingSaveValidationVO = receiptBC.modifyBooking(bookingCreationVO, account);
			bookingCreationVO.setBookingSaveValidationVO(bookingSaveValidationVO);

			bookingCreationVO.getBookingSaveValidationVO().setCloseBkgFlag("N");
			bookingCreationVO.getBookingSaveValidationVO().setCbfBkgFlag("N");
			
			// 추가: 20090706 BkgBlDoc에 ActWgt,WgtUtCd Update
			BkgBlActWgtVO bkgBlActWgtVO = new BkgBlActWgtVO();
			bkgBlActWgtVO.setActWgt(bkgBookingInfoVO.getActWgt());
			bkgBlActWgtVO.setWgtUtCd(bkgBookingInfoVO.getWgtUtCd());
			bkgBlActWgtVO.setOldPodNodCd(oldBkgInfoVO.getPodNodCd());
			bkgBlActWgtVO.setOldDelNodCd(oldBkgInfoVO.getDelNodCd());
			
			//blDocCmBC.modifyBlActWgt(bkgBlNoVO, bkgBookingInfoVO.getActWgt(), bkgBookingInfoVO.getWgtUtCd(), oldBkgInfoVO.getPodNodCd(), oldBkgInfoVO.getDelNodCd(), account);
			blDocCmBC.modifyBlActWgt(bkgBlNoVO, bkgBlActWgtVO, account);
			blDocCmBC.modifyBkgRouteNm(bkgBlNoVO, bkgBookingInfoVO, account);
			
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
			String oldRcvTermCd = oldBkgInfoVO.getRcvTermCd();
			String oldDeTermCd = oldBkgInfoVO.getDeTermCd();
			String rcvTermCd = bkgBookingInfoVO.getRcvTermCd();
			String deTermCd = bkgBookingInfoVO.getDeTermCd();

			if(!oldRcvTermCd.equals(rcvTermCd) || oldDeTermCd.equals(deTermCd)){
				if(!"M".equals(rcvTermCd) || !"M".equals(deTermCd)){
					BLDocumentationCMBC blCmBC = new BLDocumentationCMBCImpl();
					BkgContainerVO bkgContainerVO = new BkgContainerVO();
					bkgContainerVO.setBkgNo(bkgBlNoVO.getBkgNo());
					bkgContainerVO.setRcvTermCd(rcvTermCd);
					bkgContainerVO.setDeTermCd(deTermCd);
					bkgContainerVO.setUpdUsrId(account.getUsr_id());

					blCmBC.modifyCntrRDTerm(bkgContainerVO, bkgBlNoVO);

					// modifySpclRDTerm 추가(091110 류대영수석님 요청)
					if("Y".equals(bookingCreationVO.getBkgBookingInfoVO().getAwkFlg())||"Y".equals(bookingCreationVO.getBkgBookingInfoVO().getBbFlg())){
						SpecialCargoReceiptBC spclReceiptBC = new SpecialCargoReceiptBCImpl();
						spclReceiptBC.modifySpclRDTerm(bkgBlNoVO, rcvTermCd, deTermCd, account);
					}
				}
			}

			// 09. Booking Status 변경
			receiptBC.changeBkgStatus("Y", bkgBlNoVO, false, account);
			
			if("Y".equals(bookingSaveValidationVO.getRouteModifyFlag())){
				String porCd      = bkgBookingInfoVO.getBkgPorCd();
				String polCd      = bkgBookingInfoVO.getBkgPolCd();
				String oldPorCd   = oldBkgInfoVO.getPorCd();
				String oldPolCd   = oldBkgInfoVO.getPolCd();

				// TroCfmFlag = 'Y' 여부 판단.
				if(!bkgBlNoVO.getBdrFlg().equals("Y")){
					if((!oldPorCd.equals(porCd) || !oldPolCd.equals(polCd) || !oldRcvTermCd.equals(rcvTermCd)) && "Y".equals(bookingSaveValidationVO.getTroCfrmFlg())){
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
			}
			//기존에 sc가 없거나 있는데 dummy였을 경우
			if((isNull(bkgBookingInfoVO.getScNoOld()) ||(!isNull(bkgBookingInfoVO.getScNoOld()) &&"DUM".equals(bkgBookingInfoVO.getScNoOld().substring(0,3))))||
				//기존에 rfa가 없거나 있는데 dummy였을 경우
			   (isNull(bkgBookingInfoVO.getRfaNoOld())||(!isNull(bkgBookingInfoVO.getRfaNoOld())&&"DUM".equals(bkgBookingInfoVO.getRfaNoOld().substring(0,3))))||
				//기존에 rfa가 없거나 있는데 dummy였을 경우
			   (isNull(bkgBookingInfoVO.getTaaNoOld())||(!isNull(bkgBookingInfoVO.getTaaNoOld())&&"DUM".equals(bkgBookingInfoVO.getTaaNoOld().substring(0,3))))){
				//새로 가용한 계약을 입력한 경우
				if((bkgBookingInfoVO.getScNo().length() >0 &&!"DUM".equals(bkgBookingInfoVO.getScNo().substring(0, 3)))
				 ||(bkgBookingInfoVO.getRfaNo().length()>0 &&!"DUM".equals(bkgBookingInfoVO.getRfaNo().substring(0, 3)))
				 ||(bkgBookingInfoVO.getTaaNo().length()>0 &&!"DUM".equals(bkgBookingInfoVO.getTaaNo().substring(0, 3)))){
					//기존 계약과 다른 경우
					if(!bkgBookingInfoVO.getScNoOld().equals(bkgBookingInfoVO.getScNo())
							&& !bkgBookingInfoVO.getRfaNoOld().equals(bkgBookingInfoVO.getRfaNo())
							&& !bkgBookingInfoVO.getTaaNoOld().equals(bkgBookingInfoVO.getTaaNo())){
						BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
						bkgDocProcSkdVO.setBkgNo(bkgBlNoVO.getBkgNo());
						bkgDocProcSkdVO.setBkgDocProcTpCd("CTRTNO");// contract no input for doc performance
						historyBC.manageDocProcess(bkgDocProcSkdVO, account);					
					}
				}
			}
			
			BlCustomerInfoVO custInfoVO = bookingCreationVO.getBlCustomerInfoVO();
			String shCustCntCdOld = custInfoVO.getSCustCntCdOld();
			String shCustSeqOld   = custInfoVO.getSCustSeqOld();
			String shCustCntCd = custInfoVO.getSCustCntCd();
			String shCustSeq   = custInfoVO.getSCustSeq();
			if(bkgBookingInfoVO.getBkgPodCd().equals("JOAQJ")
					||bkgBookingInfoVO.getBkgDelCd().equals("JOAQJ")){
				if(!bkgBookingInfoVO.getScNoOld().equals(bkgBookingInfoVO.getScNo())
						|| !bkgBookingInfoVO.getRfaNoOld().equals(bkgBookingInfoVO.getRfaNo())
						|| !bkgBookingInfoVO.getTaaNoOld().equals(bkgBookingInfoVO.getTaaNo())
						|| !shCustCntCd.equals(shCustCntCdOld) 
						|| !shCustSeq.equals(shCustSeqOld)){
					blDocBlBC.manageMndCmdtDescJOAQJ(bkgBlNoVO.getBkgNo(), account, bkgBlNoVO.getCaFlg());
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
			
			// 18. updateBkg
//			if("Y".equals(bookingSaveValidationVO.getRouteModifyFlag())||"Y".equals(bookingSaveValidationVO.getQtyModifyFlag())){
			if(!oldBkgInfoVO.getPctlNo().equals(bkgBlNoVO.getPctlNo())){
				copBC = new BkgCopManageBCImpl();
				copBC.updateBkg(bkgBlNoVO.getBkgNo(),bkgBlNoVO.getMapSeq());
			}
			
			// sms 전송로직 추가 .jsy ,modifyBkgInfo			
//			VslSkdVO[] vslSkdVOs = bookingCreationVO.getVslSkdVOs();
			List<VslSkdVO> vslSkdVOs = receiptBC.searchVvdSkdForTsRoute(bkgBlNoVO);
			BookingUtil	util	 = new BookingUtil();
			List<BkgUserSmsListVO> smsList = null;
			List<BkgNtcHisVO> bkgNtcHisVOs = null;
			String sndMsg ="";
			String skdDirCd = "";
			String svcLaneCd = "";

			String newFirstVvd = "";
			String oldFirstVvd = "";
			String oldSlanCd = "";
			String newFirstVvdPod = "";
			String oldFirstVvdPod = "";
			
			String sndParam ="";
			if(vslSkdVOs != null && vslSkdVOs.size()>0){
				newFirstVvd =  vslSkdVOs.get(0).getBkgVvdCd();
				newFirstVvdPod = vslSkdVOs.get(0).getPodCd();
			}
			if(oldBkgInfoVO != null && oldBkgInfoVO.getFirstPod() != null){
				oldFirstVvdPod  = oldBkgInfoVO.getFirstPod();
			}

			if(vslSkdVOs != null && vslSkdVOs.size() > 0){
				newFirstVvd =  vslSkdVOs.get(0).getBkgVvdCd();
			}
			oldFirstVvd = oldBkgInfoVO.getFirstVvd();
			oldSlanCd = util.searchSvcLaneByVvd(oldFirstVvd);
			log.debug("\nsms call:SEL?" + bkgBookingInfoVO.getBkgNo().substring(0, 3)+"\n"+
					"첫배 vvd 변경 조건: "+receiptBC.chkSmsRequirementVvdChanged(bkgBookingInfoVO.getBkgNo(), oldFirstVvd, newFirstVvd,bkgBookingInfoVO.getBkgPolCd(), oldBkgInfoVO.getPolCd() )+"\n"+
					"newFirstVvd:"+newFirstVvd+"\n"+
					"oldFirstVvd:"+oldFirstVvd+"\n"+
					"polyd:"+bkgBookingInfoVO.getBkgPolCd()
			    	);	
			List<SmsRequirementResultVO> smsReqList = null;
			String bkgInfoPolYdCd ="";
			boolean bOldVvd = false; 
			boolean bNewVvd = false; 
			boolean bOldSlanCd = false; 
			boolean bNewSlanCd = false; 
			boolean bCntrCntChk = false;  //컨테이너 없이 부킹번호만 추가 및 취소 되는 경우는 메세지 발송 대상에서 제외
			boolean bPolYdChk = false;    //POL Yard를 파라미터에 추가하여 BKG_CSTMS_TML_KR_CLL 의 POL_YD_CD와 비교하여 일치하는 경우만 전송
			boolean bDoubleCallingChk = false; //POL Yard 변경시 VSK_VSL_PORT_SKD 상에서 double calling 인 경우 메시지 전송
			boolean bFinalCllPolYdChk = false; 
			boolean bFinalCllOldPolYdChk = false;	//OLD POL Yard를 파라미터에 추가하여 BKG_CSTMS_TML_KR_CLL 의 POL_YD_CD와 비교하여 일치하는 경우만 전송
			String sCllVvd ="";
			smsReqList = receiptBC.getSmsRequirementResult(bkgBookingInfoVO.getBkgNo(), oldFirstVvd, newFirstVvd,bkgBookingInfoVO.getBkgPolCd(), oldBkgInfoVO.getPolCd() );
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
				
				if( bkgInfoPolYdCd.equals(oldBkgInfoVO.getPolNodCd()) ) {
					bPolYdChk = true;
				}
				if( "Y".equals(smsReqList.get(i).getDcFlg() ) ) {
					bDoubleCallingChk = true;
				}
				if(oldBkgInfoVO.getPolCd().equals(smsReqList.get(i).getPolYd()) && oldFirstVvd.equals(cllVvd)) {
					bFinalCllOldPolYdChk = true;
				}
				if( (bkgInfoPolYdCd.equals(smsReqList.get(i).getPolYd()) && newFirstVvd.equals(cllVvd)) || 
					(oldBkgInfoVO.getPolNodCd().equals(smsReqList.get(i).getPolYd()) && oldFirstVvd.equals(cllVvd) )) {
					bFinalCllPolYdChk = true;
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
					&& receiptBC.chkSmsRequirementVvdChanged(bkgBookingInfoVO.getBkgNo(), oldFirstVvd, newFirstVvd ,bkgBookingInfoVO.getBkgPolCd(), oldBkgInfoVO.getPolCd()) 
					&& bCntrCntChk && bFinalCllPolYdChk) {
				//vvd 변경  -메세지 전송
				
//				begin();
				if( bNewVvd){
					skdDirCd = newFirstVvd.substring(8,9);
					svcLaneCd= util.searchSvcLaneByVvd(newFirstVvd);
					smsList = receiptBC.getPhnId(svcLaneCd, bkgBookingInfoVO.getBkgOfcCd(),skdDirCd, bkgBookingInfoVO.getBkgPolCd(), bkgBookingInfoVO.getBkgNo());
//					sndMsg = "\n\n(" + svcLaneCd+"-" + skdDirCd+") " +" " + newFirstVvd+" "+ bkgBookingInfoVO.getBkgNo()+" 선적 추가 발생 " ;
					if("Y".equalsIgnoreCase(bkgBookingInfoVO.getDcgoFlg())){
						sndMsg = "\n\n(" + svcLaneCd+"-" + skdDirCd+") " +" " + newFirstVvd+" "+ bkgBookingInfoVO.getBkgNo()+" (DG Cargo 선적) "+" 선적 추가 발생 " ;
	                }else{
	                	sndMsg = "\n\n(" + svcLaneCd+"-" + skdDirCd+") " +" " + newFirstVvd+" "+ bkgBookingInfoVO.getBkgNo()+" 선적 추가 발생 " ;
	                }
					//sendMailByPodChange(smsList, bkgBookingInfoVO.getBkgNo(), sndMsg );
					sndParam = //"/rv gubun[CID] vvd["+newFirstVvd+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
							   "/rv gubun[CI] vvd["+newFirstVvd+"] old_vvd["+oldFirstVvd+"]  pol_cd["+oldBkgInfoVO.getPolCd()+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
					bkgNtcHisVOs = searchBC.sendMailSmsByPodChange(smsList,  bkgBookingInfoVO.getBkgNo(), sndMsg, sndParam, account );
					historyBC.createBkgNtcHis(bkgNtcHisVOs, "");
				}
				if( bOldVvd){
					skdDirCd = oldFirstVvd.substring(8,9);
					svcLaneCd= util.searchSvcLaneByVvd(oldFirstVvd);
					smsList = receiptBC.getPhnId(svcLaneCd, bkgBookingInfoVO.getBkgOfcCd(),skdDirCd, bkgBookingInfoVO.getBkgPolCd(), bkgBookingInfoVO.getBkgNo());
//					sndMsg = "\n\n(" + svcLaneCd+"-" + skdDirCd+") " +" " + oldFirstVvd+" "+ bkgBookingInfoVO.getBkgNo()+" 선적 취소 발생 " ;
					if("Y".equalsIgnoreCase(bkgBookingInfoVO.getDcgoFlg())){
						sndMsg = "\n\n(" + svcLaneCd+"-" + skdDirCd+") " +" " + oldFirstVvd+" "+ bkgBookingInfoVO.getBkgNo()+" (DG Cargo 선적) "+" 선적 취소 발생 " ;
					}else{
						sndMsg = "\n\n(" + svcLaneCd+"-" + skdDirCd+") " +" " + oldFirstVvd+" "+ bkgBookingInfoVO.getBkgNo()+" 선적 취소 발생 " ;
					}
					//sendMailByPodChange(smsList, bkgBookingInfoVO.getBkgNo(), sndMsg );
					sndParam = //"/rv gubun[CD] vvd["+oldFirstVvd+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
							   "/rv gubun[CI] vvd["+oldFirstVvd+"] old_vvd["+oldFirstVvd+"]  pol_cd["+oldBkgInfoVO.getPolCd()+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
					bkgNtcHisVOs = searchBC.sendMailSmsByPodChange(smsList,  bkgBookingInfoVO.getBkgNo(), sndMsg, sndParam,account );
					historyBC.createBkgNtcHis(bkgNtcHisVOs, "");
				}				
//				commit();					
			} else //2.POD변경 
			if( "SEL".equals(bkgBookingInfoVO.getBkgNo().substring(0, 3) ) 
				&& !newFirstVvdPod.equals(oldFirstVvdPod)
				&& receiptBC.chkSmsRequirementVvdChanged(bkgBookingInfoVO.getBkgNo(), oldFirstVvd, newFirstVvd, bkgBookingInfoVO.getBkgPolCd(), oldBkgInfoVO.getPolCd() ) 
				&& bCntrCntChk && bFinalCllPolYdChk) {
				
				// sms 전송 
//				skdDirCd = bkgBookingInfoVO.getBkgTrunkVvd().substring(8,9);
				skdDirCd = newFirstVvd.substring(8,9);
					
					if( vslSkdVOs.get(0).getSlanCd().equals( oldSlanCd  ) && bNewSlanCd) { //( historyTableVO.getBkgBookingVO().getSlanCd() )) {
						//lane 변경 없음 -단건 전송
						smsList = receiptBC.getPhnId(vslSkdVOs.get(0).getSlanCd(), bkgBookingInfoVO.getBkgOfcCd(),skdDirCd, bkgBookingInfoVO.getBkgPolCd(), bkgBookingInfoVO.getBkgNo()); 
						//전송 메세지.
//						sndMsg = "(" + vslSkdVOs.get(0).getSlanCd()+"-" + skdDirCd+") " +" " + newFirstVvd+" "+ bkgBookingInfoVO.getBkgNo()+" POD 변경 발생 " ;
						if("Y".equalsIgnoreCase(bkgBookingInfoVO.getDcgoFlg())){
							sndMsg = "(" + vslSkdVOs.get(0).getSlanCd()+"-" + skdDirCd+") " +" " + newFirstVvd+" "+ bkgBookingInfoVO.getBkgNo()+" (DG Cargo 선적) "+" POD 변경 발생 " ;
						}else{
							sndMsg = "(" + vslSkdVOs.get(0).getSlanCd()+"-" + skdDirCd+") " +" " + newFirstVvd+" "+ bkgBookingInfoVO.getBkgNo()+" POD 변경 발생 " ;
						}
						sndParam = //"/rv gubun[POD] vvd["+newFirstVvd+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
						           "/rv gubun[POD] vvd["+newFirstVvd+"] old_vvd["+oldFirstVvd+"]  pol_cd["+oldBkgInfoVO.getPolCd()+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
						bkgNtcHisVOs = searchBC.sendMailSmsByPodChange(smsList, bkgBookingInfoVO.getBkgNo(), sndMsg, sndParam, account );
						historyBC.createBkgNtcHis(bkgNtcHisVOs, "");
						
					} else {
						if( bOldSlanCd ){
							//lane 변경  -메세지 2건 전송
							//변경전 lane에 발송
							smsList = receiptBC.getPhnId( oldSlanCd, oldBkgInfoVO.getBkgOfcCd(),skdDirCd, bkgBookingInfoVO.getBkgPolCd(), bkgBookingInfoVO.getBkgNo() );
							
							
							//lane 변경전 전송 메세지.
//							sndMsg = "(" + oldSlanCd+"-" + skdDirCd+") " +" " + oldFirstVvd +" "+ bkgBookingInfoVO.getBkgNo()+" POD 변경 발생 " ;
							if("Y".equalsIgnoreCase(bkgBookingInfoVO.getDcgoFlg())){
								sndMsg = "(" + oldSlanCd+"-" + skdDirCd+") " +" " + oldFirstVvd +" "+ bkgBookingInfoVO.getBkgNo()+" (DG Cargo 선적) "+" POD 변경 발생 " ;
							}else{
								sndMsg = "(" + oldSlanCd+"-" + skdDirCd+") " +" " + oldFirstVvd +" "+ bkgBookingInfoVO.getBkgNo()+" POD 변경 발생 " ;
							}
							sndParam = //"/rv gubun[POD] vvd["+oldFirstVvd+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
							           "/rv gubun[POD] vvd["+newFirstVvd+"] old_vvd["+oldFirstVvd+"]  pol_cd["+oldBkgInfoVO.getPolCd()+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
							bkgNtcHisVOs = searchBC.sendMailSmsByPodChange(smsList, bkgBookingInfoVO.getBkgNo(), sndMsg, sndParam, account );
							historyBC.createBkgNtcHis(bkgNtcHisVOs, "");						
						}
						
						if( bNewSlanCd){
							//변경된 lane에 발송 
							smsList = receiptBC.getPhnId(vslSkdVOs.get(0).getSlanCd(), bkgBookingInfoVO.getBkgOfcCd(), skdDirCd, bkgBookingInfoVO.getBkgPolCd(), bkgBookingInfoVO.getBkgNo());
//							sndMsg = "(" + vslSkdVOs.get(0).getSlanCd()+"-" + skdDirCd+") " +" " + newFirstVvd+" "+ bkgBookingInfoVO.getBkgNo()+" POD 변경, 선적 추가 발생 " ;
							if("Y".equalsIgnoreCase(bkgBookingInfoVO.getDcgoFlg())){
								sndMsg = "(" + vslSkdVOs.get(0).getSlanCd()+"-" + skdDirCd+") " +" " + newFirstVvd+" "+ bkgBookingInfoVO.getBkgNo()+" (DG Cargo 선적) "+" POD 변경, 선적 추가 발생 " ;
							}else{
								sndMsg = "(" + vslSkdVOs.get(0).getSlanCd()+"-" + skdDirCd+") " +" " + newFirstVvd+" "+ bkgBookingInfoVO.getBkgNo()+" POD 변경, 선적 추가 발생 " ;
							}
							sndParam = //"/rv gubun[POD] vvd["+newFirstVvd+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
									   "/rv gubun[POD] vvd["+newFirstVvd+"] old_vvd["+oldFirstVvd+"]  pol_cd["+oldBkgInfoVO.getPolCd()+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
							bkgNtcHisVOs = searchBC.sendMailSmsByPodChange(smsList,  bkgBookingInfoVO.getBkgNo(), sndMsg, sndParam, account );
							historyBC.createBkgNtcHis(bkgNtcHisVOs, "");
						}
						
					}

			}  else if( bDoubleCallingChk && !bPolYdChk && bCntrCntChk && bFinalCllPolYdChk ){ // double calling 이고 pol yd가 다르면 
				svcLaneCd = bNewSlanCd ? vslSkdVOs.get(0).getSlanCd(): oldSlanCd;
				skdDirCd = sCllVvd.substring(8,9);
				//메세지 " HJGI0025E  SEL1C7341600 YARD CODE 변경"
				smsList = receiptBC.getPhnId(svcLaneCd, bkgBookingInfoVO.getBkgOfcCd(), skdDirCd, bkgBookingInfoVO.getBkgPolCd(), bkgBookingInfoVO.getBkgNo()); 
				log.debug("\npod변경 double calling , sms 전송 리스트 size:"+smsList.size());
				//전송 메세지.
//				sndMsg = "(" + svcLaneCd+"-" + skdDirCd+") " + sCllVvd+" "+ bkgBookingInfoVO.getBkgNo()+" YARD CODE 변경 발생 " ;
				if("Y".equalsIgnoreCase(bkgBookingInfoVO.getDcgoFlg())){
					sndMsg = "(" + svcLaneCd+"-" + skdDirCd+") " + sCllVvd+" "+ bkgBookingInfoVO.getBkgNo()+" (DG Cargo 선적) "+" YARD CODE 변경 발생 " ;
				}else{
					sndMsg = "(" + svcLaneCd+"-" + skdDirCd+") " + sCllVvd+" "+ bkgBookingInfoVO.getBkgNo()+" YARD CODE 변경 발생 " ;
				}
//				begin();
				//sendMailByPodChange(smsList, bkgBookingInfoVO.getBkgNo(), sndMsg );
				sndParam = //"/rv gubun[YARD] vvd["+sCllVvd+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
  				           "/rv gubun[YARD] vvd["+sCllVvd+"] old_vvd["+oldFirstVvd+"]  pol_cd["+oldBkgInfoVO.getPolCd()+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
				bkgNtcHisVOs = searchBC.sendMailSmsByPodChange(smsList, bkgBookingInfoVO.getBkgNo(), sndMsg, sndParam, account );
				historyBC.createBkgNtcHis(bkgNtcHisVOs, "");
				
//				commit();
			}else if ("SEL".equals(bkgBookingInfoVO.getBkgNo().substring(0, 3) ) 
					&& ((bOldVvd && bFinalCllOldPolYdChk) || (bNewVvd && bFinalCllPolYdChk)) 
					&& !bkgBookingInfoVO.getBkgPolCd().equals(oldBkgInfoVO.getPolCd())
					&& bCntrCntChk) {
				svcLaneCd = oldSlanCd;
				skdDirCd = sCllVvd.substring(8,9);
				//메세지 " HJGI0025E  SEL1C7341600 YARD CODE 변경"
				smsList = receiptBC.getPhnId(svcLaneCd, bkgBookingInfoVO.getBkgOfcCd(), skdDirCd, bkgBookingInfoVO.getBkgPolCd(), bkgBookingInfoVO.getBkgNo()); 
				log.debug("\npol변경 , sms 전송 리스트 size:"+smsList.size());
				//전송 메세지.
//				sndMsg = "\n\n(" + svcLaneCd+"-" + skdDirCd+") " + sCllVvd+" "+ bkgBookingInfoVO.getBkgNo()+" POL CODE 변경 발생 " ;
				if("Y".equalsIgnoreCase(bkgBookingInfoVO.getDcgoFlg())){
					sndMsg = "\n\n(" + svcLaneCd+"-" + skdDirCd+") " + sCllVvd+" "+ bkgBookingInfoVO.getBkgNo()+" (DG Cargo 선적) "+" POL CODE 변경 발생 " ;
				}else{
					sndMsg = "\n\n(" + svcLaneCd+"-" + skdDirCd+") " + sCllVvd+" "+ bkgBookingInfoVO.getBkgNo()+" POL CODE 변경 발생 " ;
				}
				log.debug("\n  sndMsgsndMsg:"+sndMsg);
			
//				begin();
				//sendMailByPodChange(smsList, bkgBookingInfoVO.getBkgNo(), sndMsg );
				sndParam = //"/rv gubun[POD] vvd["+sCllVvd+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
				           "/rv gubun[YARD] vvd["+sCllVvd+"] old_vvd["+oldFirstVvd+"]  pol_cd["+oldBkgInfoVO.getPolCd()+"] bkg_no["+bkgBookingInfoVO.getBkgNo()+"] cntr_i[] cntr_d[]";
				bkgNtcHisVOs = searchBC.sendMailSmsByPodChange(smsList, bkgBookingInfoVO.getBkgNo(), sndMsg, sndParam, account );
				historyBC.createBkgNtcHis(bkgNtcHisVOs, "");
			
//				commit();
			}
						
			// sms -----
			return bookingCreationVO;
		}catch(EventException e){
			throw e;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);			
		}
	}

	/**
	 * Route 변경시 Booking 수정.(ESM_BKG_0079_01)<br>
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
		EsmBkg022901Event event = (EsmBkg022901Event)e;
		try{
			// Booking 모든 정보 담는 Container VO
			BookingCreationVO bookingCreationVO = new BookingCreationVO();
			// Validation 결과 담는 VO
			BookingSaveValidationVO bookingSaveValidationVO = event.getBookingSaveValidationVO();

			bookingCreationVO.setBkgBookingInfoVO	(event.getBkgBookingInfoVO());
			bookingCreationVO.setVslSkdVOs			(event.getVslSkdVOs());
			bookingCreationVO.setBkgBlNoVO			(event.getBkgBlNoVO());
			bookingCreationVO.setBlCustomerInfoVO	(event.getBlCustomerInfoVO());
			bookingCreationVO.setBkgQuantityVOs		(event.getBkgQuantityVOs());
			bookingCreationVO.setBkgQtyDtlVOs		(event.getBkgQtyDtlVOs());
			
			bookingSaveValidationVO.setRouteModifyFlag("Y");
			bookingSaveValidationVO.setCustomerModifyFlag("Y");
			bookingSaveValidationVO.setContactModifyFlag("Y");
			bookingSaveValidationVO.setQtyModifyFlag("Y");			
			bookingCreationVO.setBookingSaveValidationVO(bookingSaveValidationVO);

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

			/********   modifyBkgWithRoute  ************/
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
				eventResponse.setETCData("cbfBkgFlag", "N");
				eventResponse.setETCData("SuccessYn", "Y");	
				eventResponse.setETCData("codFlg", bookingCreationVO.getBookingSaveValidationVO().getCodFlag());
				eventResponse.setETCData("change_vvd", bookingCreationVO.getBookingSaveValidationVO().getChangeVvd());
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
	 * Route 변경시 Booking 수정.(ESM_BKG_0079_01)<br>
	 * 
	 * @author KimByungKyu 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBkgWithoutRouteByXter(Event e) throws EventException {
		return modifyBkgWithoutRoute(e);
	}

	/**
	 * Route 변경시 Booking 수정.(ESM_BKG_0079_01)<br>
	 * Transaction 포함
	 * 
	 * @author KimByungKyu 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBkgWithoutRouteByXterTx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse =  (GeneralEventResponse)modifyBkgWithoutRouteByXter(e);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Route 변경없을시 Booking 저장.(ESM_BKG_0079_01)<br>
	 * 
	 * @author KimByungKyu 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBkgWithRoute(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg022901Event event = (EsmBkg022901Event)e;
		try{
			BookingUtil util = new BookingUtil();
			
			// Booking 모든 정보 담는 Container VO
			BookingCreationVO bookingCreationVO = new BookingCreationVO();
			// Validation 결과 담는 VO
			BookingSaveValidationVO bookingSaveValidationVO = event.getBookingSaveValidationVO();

			bookingCreationVO.setBkgBookingInfoVO(event.getBkgBookingInfoVO());
			bookingCreationVO.setVslSkdVOs(event.getVslSkdVOs());
			bookingCreationVO.setBkgBlNoVO(event.getBkgBlNoVO());
			bookingCreationVO.setBlCustomerInfoVO(event.getBlCustomerInfoVO());
			bookingCreationVO.setBkgQuantityVOs(event.getBkgQuantityVOs());
			bookingCreationVO.setBkgQtyDtlVOs(event.getBkgQtyDtlVOs());
			
//			bookingSaveValidationVO.setRouteModifyFlag("Y");
			bookingSaveValidationVO.setCustomerModifyFlag("Y");
			bookingSaveValidationVO.setContactModifyFlag("Y");
			bookingSaveValidationVO.setQtyModifyFlag("Y");			
			bookingCreationVO.setBookingSaveValidationVO(bookingSaveValidationVO);

			//pctlNo set
			String [] pctlNoMapSeq = util.splitByToken(event.getPctlNo(), "|");
			bookingCreationVO.getBkgBlNoVO().setPctlNo(pctlNoMapSeq[0]);	
			bookingCreationVO.getBkgBlNoVO().setMapSeq(pctlNoMapSeq[1]);	

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
				eventResponse.setETCData("cbfBkgFlag", "N");
				eventResponse.setETCData("SuccessYn", "Y");	
				eventResponse.setETCData("codFlg", bookingCreationVO.getBookingSaveValidationVO().getCodFlag());
				eventResponse.setETCData("change_vvd", bookingCreationVO.getBookingSaveValidationVO().getChangeVvd());	
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
	 * Route 변경시 Booking 수정.(ESM_BKG_0079_01)<br>
	 * 
	 * @author KimByungKyu 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBkgWithRouteByXter(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse = (GeneralEventResponse) modifyBkgWithRoute(e);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  
		}
		return eventResponse;
	}

	/**
	 * Route 변경시 Booking 수정.(ESM_BKG_0079_01)<br>
	 * 
	 * @author KimByungKyu 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBkgWithRouteByXterTx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse = (GeneralEventResponse) modifyBkgWithRoute(e);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  
		}
		return eventResponse;
	}

	/**
	 * Customer Information 정보 수정.(ESM_BKG_0079_05)<br>
	 * 
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBlDocCust(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg022902Event event = (EsmBkg022902Event)e;
		try{
			GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
			//CNHKG CASE 확인 필요
//			GeneralBookingSearchBC 	searchBC 	= new GeneralBookingSearchBCImpl();
			BLDocumentationBLBC 	blDocBC 	= new BLDocumentationBLBCImpl();
			//EBookingReceiptBC 		eBkgBC 		= new EBookingReceiptBCImpl();
			BookingHistoryMgtBC 	historyBC 	= new BookingHistoryMgtBCImpl();
			BookingUtil 			util 		= new BookingUtil();	

//			XterRqstNoVO rqstNoVO = event.getXterRqstNoVO();
			BkgBlNoVO bkgBlNoVO = event.getBkgBlNoVO();
			
			BlCustomerVO blCustomerVO = new BlCustomerVO();
			blCustomerVO.setBkgBlNoVO  (bkgBlNoVO);

//			blCustomerVO.setBlDocCustVO(event.getBlDocCustVOs()[0]);
			blCustomerVO.setBlDocCustVO(event.getBlDocCustVO());

//			blCustomerVO.setCustEtcVO(event.getCustEtcVOs()[0]);
			blCustomerVO.setCustEtcVO(event.getCustEtcVO());		
			boolean ibCustCdVal = false;
			String bkgNo = bkgBlNoVO.getBkgNo();

			// 31. validationBlDocCust 수행
			receiptBC.validateBlDocCust(blCustomerVO);
			
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
						//begin();
						BkgBlckListMntrVO vo = new BkgBlckListMntrVO();
						vo.setBkgNo(bkgBlNoVO.getBkgNo());
						vo.setBlckKwNm(blockCustName);
						vo.setCustDescKwNm(blockCustName);
						vo.setBlckKwTpCd("BLA");
						vo.setCreUsrId(account.getUsr_id());
						vo.setUpdUsrId(account.getUsr_id());
						util.addBkgBlckListMntr(vo);
						//commit();
						throw new EventException((String)new ErrorHandler("BKG95087", new String[]{blockCustName}).getMessage());	
					}
				}
			}
			
			
			
			

			// 18. searchOldBkgForHistory 수행
			HistoryTableVO historyTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0229", bkgBlNoVO);

			// 23. modifyBkgBlDocByCust 수행
			blDocBC.modifyBkgBlDocByCust(bkgBlNoVO, event.getCustEtcVO().getOrgCntNm(), account, "", "");
			
			// 32. modifyBlDocCust 수행
			receiptBC.modifyBlDocCust(blCustomerVO, "E", account);
			
			// customer 화면에서 cnee 최초 입력
			for(int i=0;i<historyTableVO.getBkgCustomerVOs().size();i++){
				List<BkgCustomerVO> oldCustVOs = historyTableVO.getBkgCustomerVOs();
				if("C".equals(oldCustVOs.get(i).getBkgCustTpCd())){ //cnee
					if(isNull(oldCustVOs.get(i).getCustCntCd())&&isNull(oldCustVOs.get(i).getCustSeq())// old에 없었고
							&&!isNull(blCustomerVO.getBlDocCustVO().getCnCustCntCd())
							&&!isNull(blCustomerVO.getBlDocCustVO().getCnCustSeq())){// new에 있으면 consignee 새로 입력을 판단
						BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
						bkgDocProcSkdVO.setBkgNo(bkgBlNoVO.getBkgNo());
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
//			if ("Y".equalsIgnoreCase(event.getOfcChgProcVO().getOfcChgPpdProc()) || "Y".equalsIgnoreCase(event.getOfcChgProcVO().getOfcChgCctProc())) {
//				BkgModiOfcPrcVO bkgModiOfcPrcVO = new BkgModiOfcPrcVO();
//				bkgModiOfcPrcVO.setInBkgNo(bkgNo);
//				bkgModiOfcPrcVO.setInCaFlg(bkgBlNoVO.getCaFlg());
//				bkgModiOfcPrcVO.setInPpdFlg(event.getOfcChgProcVO().getOfcChgPpdProc());
//				bkgModiOfcPrcVO.setInCctFlg(event.getOfcChgProcVO().getOfcChgCctProc());
//				(new BlRatingBCImpl()).callBkgModiChgOfcPrc(bkgModiOfcPrcVO);
//			}
			// c/a 진행중에는 i/b arrival notice 관련 값을 update하지 않음 
			if(ibCustCdVal){
				receiptBC.cancelCustCdVal(bkgNo);					
				ArrivalNoticeBC anBC = new ArrivalNoticeBCImpl();
				anBC.cancelArrNtcCustCdVal(bkgNo);
			}

			// SenderID가 WEB 이외의 경우, BKG 쪽 Customer Code를 eBKG쪽으로 업데이트
			//if(!"WEB".equals(rqstNoVO.getSenderId())){
				// 2012.08.08 301 Flat File Customer Code 항목 수정으로 인한 주석화
				//eBkgBC.modifyXterCustCustCd(rqstNoVO, account);
			//}			
		}catch(EventException ex){
//			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
		return eventResponse;
	}

	/**
	 * Customer Information 정보 수정.(ESM_BKG_0079_05)<br>
	 * Transaction 포함
	 * 
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBlDocCustTx(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			eventResponse = (GeneralEventResponse)modifyBlDocCust(e);
			commit();
		} catch (EventException ex){
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);  			
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0228, ESM_BKG_0229 : PENDING 클릭
	 * EBookingReceipt의 상태를 PENDING으로 변경한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse pendingXterRqst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		try{
			begin();
			if (e.getEventName().equalsIgnoreCase("EsmBkg0228Event")) {
				EsmBkg0228Event event = (EsmBkg0228Event)e;
				command.changeXterRqstStatus(event.getXterRqstNoVOs(), "P", "" ,account);
			} else {
				EsmBkg022901Event event = (EsmBkg022901Event)e;
				command.changeXterRqstStatus(event.getXterRqstNoVOs(), "P", "" ,account);
				eventResponse.setETCData("SuccessYn", "Y");
			}							
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

	private EventResponse cancelBkgByXter(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0229Event event = (EsmBkg0229Event)e;
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		BLDocumentationCMBC blDocCmBC = new BLDocumentationCMBCImpl();
		BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
		BkgCopManageBC copBC = new BkgCopManageBCImpl();
		EBookingReceiptBC eBkgBC = new EBookingReceiptBCImpl();
		BookingUtil util = new BookingUtil();

		BLIssuanceBC bLIssuanceBC = new BLIssuanceBCImpl();
		GeneralBookingSearchBC  searchBC	= new GeneralBookingSearchBCImpl();
		OwnContainerBookingForecastMgtBC owncontainer = new OwnContainerBookingForecastMgtBCImpl();
		
		String mrdNm = null;
		String sType = null;
		String sLevel = null;
		String sMrd = null;
		StringBuilder sbParam = null;
		sbParam = new StringBuilder();
		
		DblWblVO[] dblWblVOs = null;
		
		List<BkgNtcHisVO> bkgNtcHisVOs = null;
		List<BkgNtcHisVO> bkgNtcHisSysVOs = new ArrayList<BkgNtcHisVO>();
		
		try{
			begin();

			String bkgStsCd = null; 
			bkgStsCd = util.searchBkgStatusByBkg(event.getBkgBlNoVO());  

            if(isNull(bkgStsCd)){
				throw new EventException((String)new ErrorHandler("BKG00183",new String[]{event.getBkgBlNoVO().getBkgNo()}).getMessage());
            }
            
			// 20100205 Booking Close 로직 추가
			String closeBkgMsg = "";
			String closeVvd = "";
			boolean isCloseMail = false;
			boolean isCbfMail = false;
			if("N".equals(event.getBkgBlNoVO().getCaFlg())){
				if(!"Y".equals(event.getCloseBkgFlag())){
					BkgCloseVO bkgCloseVO = util.searchBkgClose(event.getBkgBlNoVO(), account.getOfc_cd());
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
				if(!"Y".equals(event.getCbfBkgFlag())){
	
					boolean isCbfFinal = false;
					BkgCloseVO bkgCloseVO = util.searchBkgCbf(event.getBkgBlNoVO());
					if(bkgCloseVO != null && bkgCloseVO.getNewVvd() != null && !bkgCloseVO.getNewVvd().trim().equals("")){
						String[] arrCBF  = owncontainer.searchCBFBS(bkgCloseVO.getNewVvd().substring(0, 4), bkgCloseVO.getNewVvd().substring(4, 8), bkgCloseVO.getNewVvd().substring(8, 9), bkgCloseVO.getNewYdCdSeq());
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
				// 01. Cancel Booking
				receiptBC.cancelBooking(event.getBkgBlNoVO(), account); 
				
				// 02. Cancel Container
				blDocCmBC.cancelBkgCntr(event.getBkgBlNoVO(), account);
	
				// 03. BookingHistoryMgtBC의 createBkgHistoryLine 호출
				HistoryLineVO historyLineVO = new HistoryLineVO();
				historyLineVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
				historyLineVO.setCaFlg(event.getBkgBlNoVO().getCaFlg());
				historyLineVO.setBkgDocProcTpCd("BKGCAN");//booking cancel for doc performance
				historyLineVO.setUiId("ESM_BKG_0229");
				historyLineVO.setCrntCtnt("Booking Canceled.");
				historyLineVO.setHisCateNm("Booking Cancel."); 
				
				historyBC.createBkgHistoryLine(historyLineVO, account);
				
				copBC.cancelBkg(event.getBkgBlNoVO().getBkgNo());
				
				// 하위 BKG가 모두 Cancel 된 경우 해당 Master BKG의 상태를 S에서 F(W,A)로 변경
				changeMemoSplitBkgStatus(event.getBkgBlNoVO().getBkgNo());
				
				// eBooking Booking Tab에 있는 Auto Notification Check시에 메일 전송함.	
				if(event.getEsmBkg022901Event() != null && "Y".equals(event.getEsmBkg022901Event().getAutoNotification()) && event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgCntcPsonEml().trim().length() > 0
				   && !StringUtils.containsNone(event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgCntcPsonEml().trim(), "@")) {
					BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
					String [] eml = new String[event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgCntcPsonEml().length()];
					eml[0] = event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgCntcPsonEml();
					String [] rmk = new String[1];
					rmk[0] = "";
					if ("B".equals(event.getEsmBkg022901Event().getDocTpCd())){
						StringBuilder titleSb = new StringBuilder("SM Line Web Booking Notification");
						titleSb.append(" ( ").append(event.getBkgBlNoVO().getBkgNo()).append(" :  Canceled )");
						StringBuilder contentSb = new StringBuilder("Dear Customer");
						contentSb.append("<br><br>Thank you for using our website");
						contentSb.append("<br>Your booking '").append(event.getBkgBlNoVO().getBkgNo()).append("' request is successfully processed in our booking & documentation system.");
						contentSb.append("<br>For your cargo information, refer to the attached file");
						contentSb.append("<br><br><br>If you have any question, please contact our booking & documentation");
						contentSb.append("<br>").append(account.getUsr_id());
						contentSb.append("<br><br><br>We would like to listen to how you think of our service, If you have any suggestions or comments");
						contentSb.append("<br>please visit our website and leave your comments into the section of Voice of Customer");
						BkgBlNoVO[] bkgBlNoVOs = new BkgBlNoVO[] {new BkgBlNoVO() };
						
						mrdNm = "ESM_BKG_5005G";
						String [] cct = new String[event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgCntcPsonEml().length()];
						for(int j=0;j<cct.length;j++){
							cct[j]="";
						}
						String vslNm = bLIssuanceBC.searchVesselNameByBkgNo(event.getBkgBlNoVO().getBkgNo());
						bkgBlNoVOs[0].setBkgNo(event.getBkgBlNoVO().getBkgNo());
						bkgNtcHisVOs = searchBC.sendXterReceiptByEmail(bkgBlNoVOs, eml, rmk, mrdNm, cct, account, titleSb.toString(), contentSb.toString(), vslNm  );
					} else if ("S".equals(event.getEsmBkg022901Event().getDocTpCd())){
						sbParam = new StringBuilder();
						StringBuilder titleSb = new StringBuilder("SM Line Web B/L Instruction Notification ");
						titleSb.append(" ( ").append(event.getBkgBlNoVO().getBkgNo()).append(" :  Canceled )");
						StringBuilder contentSb = new StringBuilder("Dear Customer");
						contentSb.append("<br><br>Thank you for using our website");
						contentSb.append("<br>Your B/L instruction request for '").append(event.getBkgBlNoVO().getBkgNo()).append("'  request is successfully processed in our booking & documentation system.");
						contentSb.append("<br>For your cargo information, refer to the attached file");
						contentSb.append("<br><br><br>If you have any question, please contact our booking & documentation");
						contentSb.append("<br>").append(account.getUsr_id());
						contentSb.append("<br><br><br>We would like to listen to how you think of our service, If you have any suggestions or comments");
						contentSb.append("<br>please visit our website and leave your comments into the section of Voice of Customer");
						
						sType="2";
						sMrd="ESM_BKG_0109_DBL.mrd";					
						sLevel="1";
						
						sbParam.append("/rv");
						sbParam.append(" form_bkgNo[('").append(event.getBkgBlNoVO().getBkgNo()).append("')]");
						sbParam.append(" form_type[").append(sType).append("]");
						sbParam.append(" form_dataOnly[N]");
						sbParam.append(" form_manifest[N]");
						sbParam.append(" form_usrId[").append(account.getUsr_id()).append("]");
						sbParam.append(" form_hiddeData[N]");
						sbParam.append(" form_level[(").append(sLevel).append(")]");
						sbParam.append(" form_remark[").append(rmk[0]).append(")]");
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
						dblWblVOs = new DblWblVO[1];
						dblWblVOs[0] = new DblWblVO();
						dblWblVOs[0].setBkgNo(event.getBkgBlNoVO().getBkgNo());
						dblWblVOs[0].setBlNo(event.getBkgBlNoVO().getBlNo());
						dblWblVOs[0].setSyscd("BKG");
						dblWblVOs[0].setTmplmrd(sMrd);
						dblWblVOs[0].setBatchflg("N");
						dblWblVOs[0].setTmplparam(sbParam.toString());
						dblWblVOs[0].setRcveml(eml[0]);
						dblWblVOs[0].setTmplmrdpdf("Original.pdf");
						dblWblVOs[0].setItr("|$$|");
//						dblWblVOs[0].setNtcKndCd("");
//						dblWblVOs[0].setHiddOpt("N");
						dblWblVOs[0].setFrtAllFlg("1".equalsIgnoreCase(sLevel)?"Y":"N");
						dblWblVOs[0].setFrtCltFlg("5".equalsIgnoreCase(sLevel)?"Y":"N");
						dblWblVOs[0].setFrtPpdFlg("4".equalsIgnoreCase(sLevel)?"Y":"N");
						dblWblVOs[0].setFrtChgFlg("6".equalsIgnoreCase(sLevel)?"Y":"N");
						dblWblVOs[0].setFrtArrFlg("3".equalsIgnoreCase(sLevel)?"Y":"N");
						dblWblVOs[0].setTitle(titleSb.toString()); /* 제목 */
						dblWblVOs[0].setContents(contentSb.toString()); /* 내용 */
						bkgNtcHisVOs = bLIssuanceBC.sendDblWblByEmail(dblWblVOs, null, account);
					}
					if(bkgNtcHisVOs != null){
						bkgNtcHisVO = bkgNtcHisVOs.get(0);
	                    bkgNtcHisVO.setSndUsrId("SYSTEM");
	                    bkgNtcHisSysVOs.add(bkgNtcHisVO);
					}
					historyBC.createBkgNtcHis(bkgNtcHisSysVOs, "ESM_BKG_0229");
				}
				
				// 04. interfaceCoa
				//interfaceToCoa(event.getBkgBlNoVO(), "Booking Cancel", account);
				interfaceToMas(event.getBkgBlNoVO(), "Booking Cancel", account);
	
				// 05. interfaceBkgARInvoiceToINV
				interfaceToInv(event.getBkgBlNoVO(), account);	
				
				// 06. Complete Upload
				eBkgBC.completeUpload(event.getXterRqstNoVO(), account);

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
				
				// BKG cancel후 BOKCON발송 기능 추가
				event.getXterRqstNoVO().setBkgNo(event.getBkgBlNoVO().getBkgNo());
				eBkgBC.sendBOKCON(event.getXterRqstNoVO());
				
				// [CHM-201431653] e-BKG cancel request 업로드 시에도 remark란 입력 및 저장 기능 활성화			
				
				log.debug("=================bkgNo="+event.getBkgBlNoVO().getBkgNo());
				log.debug("=================interRmk="+event.getInterRmk());
				log.debug("=================xterRmk="+event.getXterRmk());
				
				eBkgBC.modifyBkgRmk(event.getBkgBlNoVO().getBkgNo(), event.getInterRmk(), event.getXterRmk(), account);
				
				commit();
				eventResponse.setETCData("SuccessYn", "Y");
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
	 * MQ 연동 처리<br>
	 * UBIZHJS_ALPSBKG_VGM IBM MQ를 통한 VGM outbound 메시지 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createTerminalVERMASEdi(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0229Event event = (EsmBkg0229Event)e;

		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		
		try {
			begin();			
			command.createTerminalVERMASEdi(event.getBkgBlNoVO(), "");
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * MQ 연동 처리<br>
	 * UBIZHJS_ALPSBKG_VGM IBM MQ를 통한 VGM 수신 메시지 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse receiptXterVGMRqst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkgEBkgReceiptEvent event = (EsmBkgEBkgReceiptEvent)e;

		log.debug(event.getRcvMsg());
		String flatFileStr = event.getRcvMsg();
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		//XterRqstNoVO rqstNoVo = new XterRqstNoVO();

		try {
			begin();
			command.receiptXterVGMRqst(flatFileStr);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * MQ 연동 처리<br>
	 * UBIZHJS_ALPSBKG_IB IBM MQ를 통한 eBKG, eSI 수신 메시지 처리<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse receiptXterRqst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkgEBkgReceiptEvent event = (EsmBkgEBkgReceiptEvent)e;

		log.debug(event.getRcvMsg());
		String flatFileStr = event.getRcvMsg();
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		XterRqstNoVO rqstNoVo = new XterRqstNoVO();

		try{
			begin();			//2011.08.23 history 추가  (FMQRCV	:MQ 수신,Received MQ)   history
            command.addBkgSrProcHisPrc(flatFileStr,"FMQRCV" );

			rqstNoVo = command.receiptXterRqst(flatFileStr);			//2011.08.23 history 추가  (EBKRCV	:e-BKG 접수,Received e-BKG)   history

			command.addBkgSrProcHisPrc(flatFileStr,"EBKRCV" );
			
			commit();		
		}catch(EventException ex){
			rollback();
			sendErrLogMail(flatFileStr, ex);
			//COS 이성배 부장님 요청으로 메일링 서비스 중단 2012.12.13
//			sendSiTransErrMail(flatFileStr); //2011.09.01 
//			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			sendErrLogMail(flatFileStr, ex);
			//COS 이성배 부장님 요청으로 메일링 서비스 중단 2012.12.13
//			sendSiTransErrMail(flatFileStr); //2011.09.01 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		// eBKG 접수와  edi 전송과는 별도로 진행
		if(rqstNoVo!=null){
			try{
				begin();
	//			if(rqstNoVo != null){
					command.assignBkgNoToXterRqst(rqstNoVo);
				commit();
				
				//2012.01.12 begin(), commit() 분리. 아래 addBkgSrRequest() 호출시 exception 발생시에도 bkg_no 를 유지하기 위해. 
				begin();
					//E-Booking 데이타가 들어온 경우 DPCS 에 데이타 입력함.
					PerformanceReportBC command2 = new PerformanceReportBCImpl();
					DpcsWebBookingVO dpcsWebBookingVO = new DpcsWebBookingVO();
					dpcsWebBookingVO.setXterSndrId(rqstNoVo.getSenderId());
					dpcsWebBookingVO.setXterRqstNo(rqstNoVo.getRqstNo());
					dpcsWebBookingVO.setXterRqstSeq(rqstNoVo.getRqstSeq());
					if ( !"E".equals(rqstNoVo.getDocTpCd()) && !"H".equals(rqstNoVo.getXterBlTpCd())) {
						command2.addBkgSrRequest(dpcsWebBookingVO);	
					}
	//			}
				commit();
			}catch(EventException ex){
				rollback();
//				log.error("err " + ex.toString(), ex);
				sendErrLogMail(flatFileStr, ex);
				throw ex;
			}catch(Exception ex){
				rollback();
				log.error("err " + ex.toString(), ex);
				sendErrLogMail(flatFileStr, ex);
				throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
			}
		}
		return eventResponse;
	}

//	/**
//	 * @param String flatFileStr
//	 */
//	private void sendSiTransErrMail(String flatFileStr) {
//		EBookingReceiptBC command = new EBookingReceiptBCImpl();
//		try{
//			begin();
//			command.sendSiTransErrMail(flatFileStr);
//			command.addBkgSrProcHisPrc(flatFileStr,"EXPTMA" );
//			commit();
//		} catch(Exception ec){
//			rollback();
//			log.error(ec.getMessage()); //  
//		}
//	}

	/**
	 * MQ 연동 처리(xls)<br>
	 * UBIZHJS_ALPSBKG_IB IBM MQ를 통한 eBKG, eSI 수신 메시지 처리(xls)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse receiptXterRqstByXls(Event e) throws EventException {
		final String colon = ":";
		final String[] arrValue = {
			"X",					//0. I_BOOKING 에 추가(IB_IE_IND:X)
			"EXCEL",				//1. I_BOOKING 에 추가(IB_EDI_ID:EXCEL)
			"P",					//2. I_BOOKING 에 추가(IB_FRT_TERM:P) - 엑셀 셀의 바탕색이나 볼드체로 판별함
			"C",					//3. I_BOOKING 에 추가(IB_FRT_TERM:C) - 엑셀 셀의 바탕색이나 볼드체로 판별함
			"W",					//4. I_BOOKING 에 추가(IB_TP:W) - 엑셀 셀의 바탕색이나 볼드체로 판별함
			"H",					//5. 1.I_BOOKING에 추가(IB_TP:H), 2.HBL 시트의 reference no 에 H를 추가
			"S",					//6. doc_tp_cd, S/I
			"Y",					//7. BKG_XTER_AES.EXPT_FLG
			"B",					//8. doc_tp_cd, Booking Request
			"D2",					//9. Container QTY Type Size Code : D2
			"D4",					//10. Container QTY Type Size Code : D4
			"D5",					//11. Container QTY Type Size Code : D5
			"D7"					//12. Container QTY Type Size Code : D7
		};
		final String[] arrName = {
			"I_BKG_CNTR",			//0. 컨테이너는 루프를 돌려야함
			"CNTR_NO",				//1. 컨테이너는 루프를 돌려야함
			"IB_BKG_NO",			//2. 입력받지 않는값(IB_IE_IND,IB_EDI_ID) 를 함께 추가함
			"IB_IE_IND",			//3. 입력받지 않는 값 추가
			"IB_EDI_ID",			//4. 입력받지 않는 값 추가
			"IB_NO",				//5. refNo 변수에 값을 보관
			"IB_FRT_TERM",			//6. 엑셀 셀의 바탕색이나 볼드체로 판별하여 추가 -> 콤보로 변경
			"IB_TP",				//7. 엑셀 셀의 바탕색이나 볼드체로 판별하여 추가 -> 콤보로 변경
			"IB_PRE_VSL_NM",		//8.
			"IB_SKD_VOYAGE_NO",		//9. 입력받지 않는 값 추가
			"IB_SKD_DIR_CD",		//10. 입력받지 않는 값 추가
			"HBL.I_CM_MARK_DESC",	//11. HBL : 컨테이너는 루프를 돌려야함
			"IB_ORG_NM",			//12. HBL : 입력받지 않는 값(IB_NO,IB_BKG_NO,IB_IE_IND,IB_EDI_ID,IB_TP)를 함께 추가함
			"IB_SKD_VOYAGE_NO",		//13. 입력받지 않는 값(IB_SKD_DIR_CD)를 substring하여 함께 추가함
			"IB_SKD_DIR_CD",		//14. 입력받지 않는 값 추가
			"IB_MSG_FLAG",			//15. doc_tp_cd
			"IBCS_STATE",			//16. mdm_state
			"IB_BKG_IND",			//17. Simple EDI로 접수되는 문서에 대해 Request 하위 항목 "ST" 표기 요청 - 현재: 공란 - 수정: C, U 표기
			"IB_PKG_CD",			//18. Total Package Type
			"HBL.I_BOOKING.IB_BL_NO",	//19. HBL 저장여부 결정1
			"HBL.I_BKG_CUST.S.IBCS_NM",	//20. HBL 저장여부 결정2
			"IB_EXP_IND",			//21. AES NUMBER - EXCEPTION(콤보)
			"IB_EXMPT",				//22. AES NUMBER - MANUAL INPUT
			"IBM_MARK",				//23. M&D시트 추가로 인하여
			"IBD_DESC",				//24. M&D시트 추가로 인하여
			"IB_PKG_QTY",			//25. total number comma replace
			"IB_WGT_QTY",			//26. total number comma replace
			"IB_MEA_QTY",			//27. total number comma replace
			"IB_ISS_LOC",           //28. B/L ISSUE PLACE , 2011.11.23 add jsy 
			"IB_ORI_CNT",           //29. NO. OF B/L ISSUE - RATED
			"IB_BL_UNRATE_CNT",     //30. NO. OF B/L ISSUE - UNRATED
			"IB_C_EMAIL",     		//31. SI Contact Info 발신메일 항목 추가 
			"IB_BKG_OFC",     		//32. Booking Office Code
			"IB_RCV_TERM",     		//33. Booking Receive Term 
			"IB_DLV_TERM",     		//34. Booking Delivery Term
			"IB_TRO_OWN_TRK",     	//35. Shipper Own Truck Flag
			"CNTRTS_CD",     		//36. Container Type Size 
			"{I_BKG_QTY",     		//37. Container Type Size 
			"IBQTY_QTY",     		//38. Container Type Size 
			"}I_BKG_QTY",     		//39. Container Type Size 
			"IB_C_NAME",     		//40. Contact Person Name 
			"IB_C_TEL_NUM",     	//41. Contact Telephone Number
			"IB_C_FAX_NUM",     	//42. Contact Fax Number
			"IB_SHIP_DT",     		//43. Departure Date
			"IB_AMS_FILER",     	//44. AMS FILING TYPE
			"IBM_BL_FF_FILER",     	//45. ACI FILING TYPE
			"IB_SC_NO",    			//46. CONTRACT NUMBER
			"IDG_UNNO",				//47. UN No.
			"IDG_IMO_CLASS",		//48. IMDG Class
			"IDG_PACK_GP1",			//49. Packing Group
			"IRF_MIN_TEMP",			//50. Packing Group
			"IRF_NATURE_TYPE",		//51. Nature Type
			"IRF_VENTI_UNIT",		//52. Ventilation Unit
			"IRF_GENSET",			//53. Genset 사용여부
			"IB_POL_NM",			//54. POLCD-POLNM
			"IB_POL_CD"				//55. POLCD
		};
		final String[] arrTemp = {
			"I_BOOKING.",          //0
			"PREPAID",			   //1
			"SEAWAYBILL",		   //2
			"OB/L(SURRENDER)",	   //3
			"ORIGINAL",	           //4
			"CUSTOMER HAULAGE"	   //5
		};
		
		GeneralEventResponse eventResponse = null;
		EBookingReceiptBC command = null;
		PerformanceReportBC command2 = null;
		GeneralBookingReceiptBC command3 = null;
		BookingMasterMgtBC bkgMaster = null;
		BookingUtil util = null;
		BkgHrdCdgCtntVO paramVO = null;
		MdmStateVO steVO = null;
		ExternalRqstListInputVO inputVO = null;
		XterRqstNoVO rqstNoVo = null;
		DpcsWebBookingVO dpcsWebBookingVO = null;
		BkgBlNoVO bkgBlNoVO = null;
		List<BkgHrdCdgCtntVO> grpList = null;
		List<BkgHrdCdgCtntVO> mapList = null;
		Workbook wb = null;
		Sheet sheet1 = null;
		Sheet sheet2 = null;
		Sheet sheet3 = null;
		Cell cell = null;
		List<Cell> cells = null;
		StringBuilder flatFile = null;
		String bkgNo = null;
		String rqstBkgNo = null;
		String xterRqstNo = null;
		String bkgOfcCd = null;
		String docTpCd = null;
		String refNo = null;
		String lineSep = "";
		String val = null;
		String ibExpInd = null;
		String shprOwnTrkFlg = "N";
		String sheet1Nm = null;
		String xterBkgRqstStsCd = null;
		String sysLnSep = "";
		int idx=0,x=0,y=0,icmdSeq=0; //,mx=0,my=0
		boolean isEndCntr = false;
		MdmPckTpVO pckVO = null;
		try {
			eventResponse = new GeneralEventResponse();
			command = new EBookingReceiptBCImpl();
			command2 = new PerformanceReportBCImpl();
			command3 = new GeneralBookingReceiptBCImpl();
			paramVO = new BkgHrdCdgCtntVO();
			dpcsWebBookingVO = new DpcsWebBookingVO();
			wb = WorkbookFactory.create(((EsmBkgEBkgReceiptEvent)e).getRcvXls());
			for (int i=0; i < wb.getNumberOfSheets(); i++){
				switch(i) {
					case 0:
						sheet1 = wb.getSheetAt(0);  //EDI_MAIN or Main_BL
						if(sheet1 != null){
							sheet1Nm = sheet1.getSheetName();
						}
						break;
					case 1:
						sheet2 = wb.getSheetAt(1);  //Description(additional)
						break;
					case 2:
						sheet3 = wb.getSheetAt(2);  //HBL
						break;
				}
			}			
			sysLnSep = System.getProperty("line.separator");
			if(sysLnSep != null){
				lineSep = sysLnSep;
			}

			begin();  //임시 jsy
			
			//simple booking 추가 - 2012.10.31
			if("Main_BL".equalsIgnoreCase(sheet1Nm)){
				docTpCd = "B";
				if (null!=wb) {
					flatFile = new StringBuilder();
					wb.setMissingCellPolicy(Row.CREATE_NULL_AS_BLANK);//RETURN_NULL_AND_BLANK);//.RETURN_BLANK_AS_NULL);//.CREATE_NULL_AS_BLANK);
					
					if (null!=sheet1) {
						idx = 0;
//							flatFile = new StringBuilder();
						util = new BookingUtil();
						rqstNoVo = new XterRqstNoVO();
						paramVO.setAttrCtnt10(sheet1Nm);
						grpList = command.searchMqXlsBkgGroupList(paramVO);  //XTER_BKG_RCT_ORD_BKG
						mapList = command.searchMqXlsBkgMappingList(paramVO);  //XTER_BKG_RCT_XLS_BKG
						for (BkgHrdCdgCtntVO vo : mapList) {
							//open group///////////////////////////////////////
							if (0>flatFile.indexOf(vo.getAttrCtnt4())) {
								LOOP_FLAT_FILE_GROUP_OPEN:
									for (BkgHrdCdgCtntVO group : grpList) {
										if (group.getAttrCtnt1().equalsIgnoreCase(vo.getAttrCtnt1())) {
											flatFile.append(group.getAttrCtnt4()).append(lineSep);
											break LOOP_FLAT_FILE_GROUP_OPEN;
										}
									}
							}
							cells = findCellsByName(wb,vo.getAttrCtnt2());
							log.debug("\n vo.getAttrCtnt2():"+vo.getAttrCtnt2());
							if (null == cells && arrName[31].equalsIgnoreCase(vo.getAttrCtnt3()) ) {
								flatFile.append(vo.getAttrCtnt3()).append(colon).append( (String)e.getAttribute("emailAddr") ).append(lineSep);
							}
							
							idx+=1;
							if (null!=cells) {
								if (1<cells.size()) {
									for (Cell temp : cells) {
										if (null!=temp) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(getExcelCellValue(temp).toUpperCase()).append(lineSep);
										}
									}
									if (arrName[23].equalsIgnoreCase(vo.getAttrCtnt3()) || arrName[24].equalsIgnoreCase(vo.getAttrCtnt3())) {
										flatFile.append(this.getMndSheetData(sheet2,arrName[23].equalsIgnoreCase(vo.getAttrCtnt3()) ? 0:1,vo.getAttrCtnt3()).toUpperCase());
									}
								} else {
									cell = cells.get(0);
									x = cell.getRowIndex();
									y = cell.getColumnIndex();
									val = getExcelCellValue(cell);
									log.debug("\n getExcelCellValue(cell):"+val);
									//contents///////////////////////////////////////
									//IB_BKG_NO
									if (arrName[2].equalsIgnoreCase(vo.getAttrCtnt3())) {
										bkgNo = val.trim();
										if("".equalsIgnoreCase(bkgNo)){
											bkgOfcCd = getExcelCellValue(findCellsByName(wb,arrTemp[0]+arrName[32]).get(0)).substring(0,5);
											bkgBlNoVO = util.manageBkgNumberGeneration("BKG", bkgOfcCd, "SYSTEM");
											bkgNo = bkgBlNoVO.getBkgNo() + "00";
											xterBkgRqstStsCd = "C";
										} else {
											if(bkgNo.equalsIgnoreCase(util.searchBkgNoByRqstNo(bkgNo))){
												xterBkgRqstStsCd = "U";
											} else {
												bkgBlNoVO = new BkgBlNoVO();
												bkgBlNoVO.setBkgNo(bkgNo);
												String bkgNoUseFlg = command3.searchChnBkgNoExist(bkgBlNoVO);
												
												if(bkgNoUseFlg!=null){
													if("N".equals(bkgNoUseFlg)){
														xterBkgRqstStsCd = "C";
													} else {
														bkgNo = "";
													}
												} else {
													bkgNo = "";
												}												
												
											}
										}
										
										if(xterBkgRqstStsCd != null){
											xterBkgRqstStsCd = xterBkgRqstStsCd.toUpperCase();
										}
										
										flatFile.append(vo.getAttrCtnt3()).append(colon).append(bkgNo.toUpperCase()).append(lineSep);
										flatFile.append(arrName[3]).append(colon).append(arrValue[0].toUpperCase()).append(lineSep);
										flatFile.append(arrName[4]).append(colon).append(arrValue[1].toUpperCase()).append(lineSep);
										flatFile.append(arrName[15]).append(colon).append(arrValue[8].toUpperCase()).append(lineSep);
										flatFile.append(arrName[17]).append(colon).append(xterBkgRqstStsCd).append(lineSep);
										flatFile.append(arrName[5]).append(colon).append(bkgNo.toUpperCase()).append(lineSep); //ref no 는 bkg no 로 대체함
										//IB_FRT_TERM
									} else if (arrName[6].equalsIgnoreCase(vo.getAttrCtnt3())) {
//										flatFile.append(vo.getAttrCtnt3()).append(colon).append(arrTemp[1].equals(val.toUpperCase() ) ? arrValue[2]:arrValue[3]).append(lineSep);
										flatFile.append(vo.getAttrCtnt3().toUpperCase()).append(colon);
										if(!"".equals(val) ) {
											flatFile.append( arrTemp[1].equals(val.toUpperCase() ) ? arrValue[2].toUpperCase():arrValue[3].toUpperCase()).append(lineSep);
										} else{
											flatFile.append(lineSep);
										}
										//IB_TP	
									} else if (arrName[7].equalsIgnoreCase(vo.getAttrCtnt3())) {
										flatFile.append(vo.getAttrCtnt3()).append(colon); //.append(arrTemp[2].equals(val.toUpperCase()) ? arrValue[4]:"").append(lineSep);
										if(arrTemp[2].equals(val.toUpperCase())){
											flatFile.append(arrValue[4].toUpperCase());
										} else if(arrTemp[3].equals(val.toUpperCase())){
											flatFile.append("S");
										}else if(arrTemp[4].equals(val.toUpperCase())){
											flatFile.append("O");
										}
										flatFile.append(lineSep);
										//IB_PRE_VSL_NM
									} else if (arrName[8].equalsIgnoreCase(vo.getAttrCtnt3())) {
										flatFile.append(vo.getAttrCtnt3()).append(colon).append(val+getExcelCellValue(sheet1.getRow(x).getCell(3+y)).toUpperCase()).append(lineSep);
										//IB_SKD_VOYAGE_NO
									} else if (arrName[13].equalsIgnoreCase(vo.getAttrCtnt3())) {
										if (!"".equals(val) && 4<=val.length()) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.substring(0,4).toUpperCase()).append(lineSep);
											if (5<=val.length()) {
												flatFile.append(arrName[14]).append(colon).append(val.substring(4,5).toUpperCase()).append(lineSep);
											}
										}
										//IB_PKG_CD
									} else if (arrName[18].equalsIgnoreCase(vo.getAttrCtnt3())) {
										pckVO = util.searchPkgTypeByName(getExcelCellValue(cell).toUpperCase());
										flatFile.append(vo.getAttrCtnt3()).append(colon).append(null!=pckVO ? pckVO.getPckCd().toUpperCase():"").append(lineSep);
										//IB_PKG_QTY / IB_WGT_QTY / IB_MEA_QTY
									} else if (arrName[25].equalsIgnoreCase(vo.getAttrCtnt3()) ||
											arrName[26].equalsIgnoreCase(vo.getAttrCtnt3()) ||
											arrName[27].equalsIgnoreCase(vo.getAttrCtnt3())) {
										if (!"".equals(val)) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.replaceAll(",","").toUpperCase()).append(lineSep);
										}
										//IB_ISS_LOC
									} else if (arrName[28].equalsIgnoreCase(vo.getAttrCtnt3()) ) {
										if (!"".equals(val)) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.replaceAll(",","").toUpperCase()).append(lineSep);
										}
										//IB_ORI_CNT
									} else if (arrName[29].equalsIgnoreCase(vo.getAttrCtnt3()) ) {
										if (!"".equals(val)) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.replaceAll(",","").toUpperCase()).append(lineSep);
										}	
										//IB_BL_UNRATE_CNT
									} else if (arrName[30].equalsIgnoreCase(vo.getAttrCtnt3()) ) {
										if (!"".equals(val)) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.replaceAll(",","").toUpperCase()).append(lineSep);
										}
										//IB_C_NAME
									} else if (arrName[40].equalsIgnoreCase(vo.getAttrCtnt3()) ) {
										if ("".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(y))) 
												&& "".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(1+x).getCell(y))) 
												&& "".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(2+x).getCell(y))) 
												&& "".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(3+x).getCell(y))) 
										) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(getExcelCellValue(sheet1.getRow(x).getCell(8+y)).toUpperCase()).append(lineSep);
											flatFile.append(arrName[41]).append(colon).append(getExcelCellValue(sheet1.getRow(1+x).getCell(8+y)).toUpperCase()).append(lineSep);
											flatFile.append(arrName[42]).append(colon).append(getExcelCellValue(sheet1.getRow(2+x).getCell(8+y)).toUpperCase()).append(lineSep);
											flatFile.append(arrName[31]).append(colon).append("".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(3+x).getCell(8+y))) ? (String)e.getAttribute("emailAddr") : getExcelCellValue(sheet1.getRow(3+x).getCell(8+y)).toUpperCase()).append(lineSep);
										} else {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(getExcelCellValue(sheet1.getRow(x).getCell(y)).toUpperCase()).append(lineSep);
											flatFile.append(arrName[41]).append(colon).append(getExcelCellValue(sheet1.getRow(1+x).getCell(y)).toUpperCase()).append(lineSep);
											flatFile.append(arrName[42]).append(colon).append(getExcelCellValue(sheet1.getRow(2+x).getCell(y)).toUpperCase()).append(lineSep);
											flatFile.append(arrName[31]).append(colon).append("".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(3+x).getCell(y))) ? (String)e.getAttribute("emailAddr") : getExcelCellValue(sheet1.getRow(3+x).getCell(y)).toUpperCase()).append(lineSep);
										}
										//IB_BKG_OFC
									} else if (arrName[32].equalsIgnoreCase(vo.getAttrCtnt3()) ) {
										flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.substring(0,5).toUpperCase()).append(lineSep);
										//IB_RCV_TERM or IB_DLV_TERM
									} else if (arrName[33].equalsIgnoreCase(vo.getAttrCtnt3()) || arrName[34].equalsIgnoreCase(vo.getAttrCtnt3())) {
										if (!"".equals(val)) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(util.searchDeTypeByName(val).toUpperCase()).append(lineSep);										
										}	
										//IB_TRO_OWN_TRK
									} else if (arrName[35].equalsIgnoreCase(vo.getAttrCtnt3()) ) {
										if (arrTemp[5].equalsIgnoreCase(val)) {
											shprOwnTrkFlg = "Y";
										} 
										flatFile.append(vo.getAttrCtnt3()).append(colon).append(shprOwnTrkFlg.toUpperCase()).append(lineSep);
										//CNTRTS_CD
									} else if (arrName[36].equalsIgnoreCase(vo.getAttrCtnt3()) ) {
										if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(y))) 
												|| !"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(3+y))) 
												|| !"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(6+y))) 
												|| !"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(9+y))) 
										) {
											//D2
											if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(y)))) {
												flatFile.append(arrName[38]).append(colon).append(getExcelCellValue(sheet1.getRow(x).getCell(y)).toUpperCase()).append(lineSep);
												flatFile.append(arrName[36]).append(colon).append(arrValue[9].toUpperCase()).append(lineSep);
												if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(3+y)))
														|| !"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(6+y)))
														|| !"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(9+y)))) {
													flatFile.append(arrName[39].toUpperCase()).append(lineSep);
												}
											} 
											//D4
											if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(3+y)))) {
												if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(y)))) {
													flatFile.append(arrName[37].toUpperCase()).append(lineSep);
												}
												flatFile.append(arrName[38]).append(colon).append(getExcelCellValue(sheet1.getRow(x).getCell(3+y)).toUpperCase()).append(lineSep);
												flatFile.append(arrName[36]).append(colon).append(arrValue[10].toUpperCase()).append(lineSep);
												if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(6+y)))
														|| !"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(9+y)))) {
													flatFile.append(arrName[39].toUpperCase()).append(lineSep);
												}
											} 
											//D5
											if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(6+y)))) {
												if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(y)))
														|| !"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(3+y)))) {
													flatFile.append(arrName[37]).append(lineSep);
												}
												flatFile.append(arrName[38]).append(colon).append(getExcelCellValue(sheet1.getRow(x).getCell(6+y)).toUpperCase()).append(lineSep);
												flatFile.append(arrName[36]).append(colon).append(arrValue[11].toUpperCase()).append(lineSep);
												if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(9+y)))) {
													flatFile.append(arrName[39].toUpperCase()).append(lineSep);
												}
											} 
											//D7
											if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(9+y)))) {
												if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(y)))
														|| !"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(3+y)))
														|| !"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(6+y)))) {
													flatFile.append(arrName[37].toUpperCase()).append(lineSep);
												}
												flatFile.append(arrName[38]).append(colon).append(getExcelCellValue(sheet1.getRow(x).getCell(9+y)).toUpperCase()).append(lineSep);
												flatFile.append(arrName[36]).append(colon).append(arrValue[12].toUpperCase()).append(lineSep);
											} 
										}
										//IB_SHIP_DT
									} else if (arrName[43].equalsIgnoreCase(vo.getAttrCtnt3()) ) {
										if (!"".equals(val)) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.replaceAll("\\p{Space}","").replaceAll("[-/]","").replaceAll("\\.","").substring(0,8).toUpperCase()).append(lineSep);
										}
										//IB_AMS_FILER
									} else if (arrName[44].equalsIgnoreCase(vo.getAttrCtnt3()) ) {
										if (!"".equals(val)) {
											val = val.substring(0,1);
											if ("1".equalsIgnoreCase(val)||"2".equalsIgnoreCase(val)||"3".equalsIgnoreCase(val)) {
												flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.toUpperCase()).append(lineSep);
											}
										}
										//IBM_BL_FF_FILER
									} else if (arrName[45].equalsIgnoreCase(vo.getAttrCtnt3()) ) {
										if (!"".equals(val)) {
											val = val.substring(0,1);
											if ("1".equalsIgnoreCase(val)||"2".equalsIgnoreCase(val)||"3".equalsIgnoreCase(val)) {
												flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.toUpperCase()).append(lineSep);
											}
										}
										//IB_SC_NO
									} else if (arrName[46].equalsIgnoreCase(vo.getAttrCtnt3()) ) {
										if (!"".equals(val)) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.replaceAll(",","").toUpperCase()).append(lineSep);
										} else {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(getExcelCellValue(sheet1.getRow(x-1).getCell(y)).toUpperCase()).append(lineSep);
										}
									} else {
										if (!"".equals(val)) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.toUpperCase()).append(lineSep);
										}
									}
								}
							}
							//close group///////////////////////////////////////
							if (!arrName[0].equalsIgnoreCase(vo.getAttrCtnt1())) {
								if (idx < mapList.size()) {
									if (!vo.getAttrCtnt1().equalsIgnoreCase(mapList.get(idx).getAttrCtnt1())) {
										LOOP_FLAT_FILE_GROUP_CLOSE:
											for (BkgHrdCdgCtntVO group : grpList) {
												if (group.getAttrCtnt1().equalsIgnoreCase(vo.getAttrCtnt1())) {
													flatFile.append(group.getAttrCtnt5()).append(lineSep);
													break LOOP_FLAT_FILE_GROUP_CLOSE;
												}
											}
									}
								} else {
									flatFile.append(vo.getAttrCtnt5().toUpperCase()).append(lineSep);
								}
							}
						}
						log.info("\n\n\n\n\n\n\n\n\n\n\n\n"
								+"\n==Main_BL==========\n"
								+flatFile
								+"\n====================\n"
								+"\n\n\n\n\n\n\n\n\n\n\n\n");
						rqstNoVo = command.receiptXterRqst(flatFile.toString());
					}
				}
			} else if("BKG".equalsIgnoreCase(sheet1Nm)){
				docTpCd = "B";
				if (null!=wb) {
					flatFile = new StringBuilder();
					wb.setMissingCellPolicy(Row.CREATE_NULL_AS_BLANK);//RETURN_NULL_AND_BLANK);//.RETURN_BLANK_AS_NULL);//.CREATE_NULL_AS_BLANK);
					
					if (null!=sheet1) {
						idx = 0;
//							flatFile = new StringBuilder();
						util = new BookingUtil();
						bkgMaster = new BookingMasterMgtBCImpl();
						
						rqstNoVo = new XterRqstNoVO();
						paramVO.setAttrCtnt10(sheet1Nm);
						grpList = command.searchMqXlsBkgGroupList(paramVO);  //XTER_BKG_RCT_ORD_BKG
						mapList = command.searchMqXlsBkgMappingList(paramVO);  //XTER_BKG_RCT_XLS_BKG
						for (BkgHrdCdgCtntVO vo : mapList) {
							//open group///////////////////////////////////////
							if (0>flatFile.indexOf(vo.getAttrCtnt4())) {
								LOOP_FLAT_FILE_GROUP_OPEN:
									for (BkgHrdCdgCtntVO group : grpList) {
										if (group.getAttrCtnt1().equalsIgnoreCase(vo.getAttrCtnt1())) {
											flatFile.append(group.getAttrCtnt4()).append(lineSep);
											break LOOP_FLAT_FILE_GROUP_OPEN;
										}
									}
							}
							cells = findCellsByName(wb,vo.getAttrCtnt2());
							log.debug("\n vo.getAttrCtnt2():"+vo.getAttrCtnt2());
							if (null == cells && arrName[31].equalsIgnoreCase(vo.getAttrCtnt3()) ) {
								flatFile.append(vo.getAttrCtnt3()).append(colon).append( (String)e.getAttribute("emailAddr") ).append(lineSep);
							}
							
							idx+=1;
							if (null!=cells) {
								if (1<cells.size()) {
									for (Cell temp : cells) {
										if (null!=temp) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(getExcelCellValue(temp).toUpperCase()).append(lineSep);
										}
									}
									if (arrName[23].equalsIgnoreCase(vo.getAttrCtnt3()) || arrName[24].equalsIgnoreCase(vo.getAttrCtnt3())) {
										flatFile.append(this.getMndSheetData(sheet2,arrName[23].equalsIgnoreCase(vo.getAttrCtnt3()) ? 0:1,vo.getAttrCtnt3()).toUpperCase());
									}
								} else {
									cell = cells.get(0);
									x = cell.getRowIndex();
									y = cell.getColumnIndex();
									val = getExcelCellValue(cell);
									log.debug("\n getExcelCellValue(cell):"+val);
									//contents///////////////////////////////////////
									//IB_BKG_NO
									if (arrName[2].equalsIgnoreCase(vo.getAttrCtnt3())) {
										bkgNo = val.trim();
										
										//bkgOfcCd = getExcelCellValue(findCellsByName(wb,arrTemp[0]+arrName[32]).get(0)).substring(0,5);										
										if(!"".equals(getExcelCellValue(findCellsByName(wb,arrTemp[0]+arrName[32]).get(0)))){
											bkgOfcCd = getExcelCellValue(findCellsByName(wb,arrTemp[0]+arrName[32]).get(0)).substring(0,5);
										} else {
											// [CHM-201431993] 미주지역 SIMPLE BKG 템플릿 변경 요청
											
											BkgHandlingOfficeSetupVO bkgHandlingOfficeSetupVO = new BkgHandlingOfficeSetupVO();
											bkgHandlingOfficeSetupVO.setPolCd(getExcelCellValue(findCellsByName(wb,arrTemp[0]+arrName[54]).get(0)).substring(0,5));
											
											List<BkgHandlingOfficeSetupVO> bkgHandlingOfficeSetupVOs = bkgMaster.searchHandlingOffice(bkgHandlingOfficeSetupVO); 
											
											if(bkgHandlingOfficeSetupVOs.size() > 0){
												bkgOfcCd = bkgHandlingOfficeSetupVOs.get(0).getHndlOfcCd()==null?"":bkgHandlingOfficeSetupVOs.get(0).getHndlOfcCd();
											}
											
											if("".equals(bkgOfcCd)||bkgOfcCd==null){
												SearchLocationCodeVO searchLocationCodeVO = util.searchLocationCode(getExcelCellValue(findCellsByName(wb,arrTemp[0]+arrName[54]).get(0)).substring(0,5));
												bkgOfcCd = searchLocationCodeVO.getSlsOfcCd();
											}
										}
										
										bkgBlNoVO = util.manageBkgNumberGeneration("BKG", bkgOfcCd, "SYSTEM");
										xterRqstNo = bkgBlNoVO.getBkgNo() + "00";
										if("".equalsIgnoreCase(bkgNo)){
											bkgNo = xterRqstNo;
											xterBkgRqstStsCd = "C";
										} else {
											rqstBkgNo = util.searchBkgNoByRqstNo(bkgNo);
											if(null!=rqstBkgNo && bkgNo.equalsIgnoreCase(rqstBkgNo)){
												xterBkgRqstStsCd = "U";
											} else {
												xterBkgRqstStsCd = "C";
											}
										}
										
										if(xterBkgRqstStsCd != null){
											xterBkgRqstStsCd = xterBkgRqstStsCd.toUpperCase();
										}
										
										flatFile.append(vo.getAttrCtnt3()).append(colon).append(bkgNo.toUpperCase()).append(lineSep);
										flatFile.append(arrName[3]).append(colon).append(arrValue[0].toUpperCase()).append(lineSep);
										flatFile.append(arrName[4]).append(colon).append(arrValue[1].toUpperCase()).append(lineSep);
										flatFile.append(arrName[15]).append(colon).append(arrValue[8].toUpperCase()).append(lineSep);
										flatFile.append(arrName[17]).append(colon).append(xterBkgRqstStsCd).append(lineSep);
										flatFile.append(arrName[5]).append(colon).append(xterRqstNo.toUpperCase()).append(lineSep); //ref no 는 bkg no 로 대체함
										//IB_FRT_TERM
									} else if (arrName[6].equalsIgnoreCase(vo.getAttrCtnt3())) {
										flatFile.append(vo.getAttrCtnt3().toUpperCase()).append(colon);
										if(!"".equals(val) ) {
											flatFile.append( arrTemp[1].equals(val.toUpperCase() ) ? arrValue[2].toUpperCase():arrValue[3].toUpperCase()).append(lineSep);
										} else{
											flatFile.append(lineSep);
										}
										//IB_PKG_CD
									} else if (arrName[18].equalsIgnoreCase(vo.getAttrCtnt3())) {
										pckVO = util.searchPkgTypeByName(getExcelCellValue(cell).toUpperCase());
										flatFile.append(vo.getAttrCtnt3()).append(colon).append(null!=pckVO ? pckVO.getPckCd().toUpperCase():"").append(lineSep);
										//IB_PKG_QTY / IB_WGT_QTY / IB_MEA_QTY
									} else if (arrName[25].equalsIgnoreCase(vo.getAttrCtnt3()) ||
											arrName[26].equalsIgnoreCase(vo.getAttrCtnt3()) ||
											arrName[27].equalsIgnoreCase(vo.getAttrCtnt3())) {
										if (!"".equals(val)) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.replaceAll(",","").toUpperCase()).append(lineSep);
										} 
										//IB_BKG_OFC
									} else if (arrName[32].equalsIgnoreCase(vo.getAttrCtnt3()) ) {
										//flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.substring(0,5).toUpperCase()).append(lineSep);
										if(!"".equals(val) ) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.substring(0,5).toUpperCase()).append(lineSep);
										}
										//IB_RCV_TERM or IB_DLV_TERM
									} else if (arrName[33].equalsIgnoreCase(vo.getAttrCtnt3()) || arrName[34].equalsIgnoreCase(vo.getAttrCtnt3())) {
										if (!"".equals(val)) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(util.searchDeTypeByName(val).toUpperCase()).append(lineSep);										
										}	
										//IB_TRO_OWN_TRK
									} else if (arrName[35].equalsIgnoreCase(vo.getAttrCtnt3()) ) {
										if (arrTemp[5].equalsIgnoreCase(val)) {
											shprOwnTrkFlg = "Y";
										} 
										flatFile.append(vo.getAttrCtnt3()).append(colon).append(shprOwnTrkFlg.toUpperCase()).append(lineSep);
										//CNTRTS_CD [CHM-201431993] 미주지역 SIMPLE BKG 템플릿 변경 요청
									} /*else if (arrName[36].equalsIgnoreCase(vo.getAttrCtnt3()) ) {
										if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(y))) 
												|| !"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(3+y))) 
												|| !"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(6+y))) 
												|| !"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(9+y))) 
										) {
											//D2
											if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(y)))) {
												flatFile.append(arrName[38]).append(colon).append(getExcelCellValue(sheet1.getRow(x).getCell(y)).toUpperCase()).append(lineSep);
												flatFile.append(arrName[36]).append(colon).append(arrValue[9].toUpperCase()).append(lineSep);
												if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(3+y)))
														|| !"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(6+y)))
														|| !"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(9+y)))) {
													flatFile.append(arrName[39].toUpperCase()).append(lineSep);
												}
											} 
											//D4
											if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(3+y)))) {
												if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(y)))) {
													flatFile.append(arrName[37].toUpperCase()).append(lineSep);
												}
												flatFile.append(arrName[38]).append(colon).append(getExcelCellValue(sheet1.getRow(x).getCell(3+y)).toUpperCase()).append(lineSep);
												flatFile.append(arrName[36]).append(colon).append(arrValue[10].toUpperCase()).append(lineSep);
												if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(6+y)))
														|| !"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(9+y)))) {
													flatFile.append(arrName[39].toUpperCase()).append(lineSep);
												}
											} 
											//D5
											if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(6+y)))) {
												if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(y)))
														|| !"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(3+y)))) {
													flatFile.append(arrName[37]).append(lineSep);
												}
												flatFile.append(arrName[38]).append(colon).append(getExcelCellValue(sheet1.getRow(x).getCell(6+y)).toUpperCase()).append(lineSep);
												flatFile.append(arrName[36]).append(colon).append(arrValue[11].toUpperCase()).append(lineSep);
												if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(9+y)))) {
													flatFile.append(arrName[39].toUpperCase()).append(lineSep);
												}
											} 
											//D7
											if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(9+y)))) {
												if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(y)))
														|| !"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(3+y)))
														|| !"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(6+y)))) {
													flatFile.append(arrName[37].toUpperCase()).append(lineSep);
												}
												flatFile.append(arrName[38]).append(colon).append(getExcelCellValue(sheet1.getRow(x).getCell(9+y)).toUpperCase()).append(lineSep);
												flatFile.append(arrName[36]).append(colon).append(arrValue[12].toUpperCase()).append(lineSep);
											} 
										}										
									} */else if (arrName[36].equalsIgnoreCase(vo.getAttrCtnt3()) ) {
										//Qty1
										if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(y)))) {
											flatFile.append(arrName[38]).append(colon).append(getExcelCellValue(sheet1.getRow(x).getCell(2+y)).toUpperCase()).append(lineSep);
											flatFile.append(arrName[36]).append(colon).append(getExcelCellValue(sheet1.getRow(x).getCell(y)).substring(0,2)).append(lineSep);
											if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(y)))
													|| !"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x+1).getCell(y)))
													|| !"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x+2).getCell(y)))) {
												flatFile.append(arrName[39].toUpperCase()).append(lineSep);
											}
										} 
										//Qty2
										if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x+1).getCell(y)))) {
											if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(y)))) {
												flatFile.append(arrName[37].toUpperCase()).append(lineSep);
											}
											flatFile.append(arrName[38]).append(colon).append(getExcelCellValue(sheet1.getRow(x+1).getCell(2+y)).toUpperCase()).append(lineSep);
											flatFile.append(arrName[36]).append(colon).append(getExcelCellValue(sheet1.getRow(x+1).getCell(y)).substring(0,2)).append(lineSep);
											if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x+2).getCell(y)))) {
												flatFile.append(arrName[39].toUpperCase()).append(lineSep);
											}
										} 
										//Qty3
										if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x+2).getCell(y)))) {
											if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(y)))
													|| !"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x+1).getCell(y)))
													|| !"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x+2).getCell(y)))) {
												flatFile.append(arrName[37]).append(lineSep);
											}
											flatFile.append(arrName[38]).append(colon).append(getExcelCellValue(sheet1.getRow(x+2).getCell(2+y)).toUpperCase()).append(lineSep);
											flatFile.append(arrName[36]).append(colon).append(getExcelCellValue(sheet1.getRow(x+2).getCell(y)).substring(0,2)).append(lineSep);
										} 
										
										//IB_SC_NO
									} else if (arrName[46].equalsIgnoreCase(vo.getAttrCtnt3()) ) {
										if (!"".equals(val)) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.replaceAll(",","").toUpperCase()).append(lineSep);
										} else if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x+1).getCell(y)))){
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(getExcelCellValue(sheet1.getRow(x+1).getCell(y)).toUpperCase()).append(lineSep);
										} else {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(getExcelCellValue(sheet1.getRow(x+2).getCell(y)).toUpperCase()).append(lineSep);
										}
										//IDG_UNNO, IDG_IMO_CLASS, IDG_PACK_GP1
									} else if (arrName[47].equalsIgnoreCase(vo.getAttrCtnt3()) ||
											arrName[48].equalsIgnoreCase(vo.getAttrCtnt3()) ||
											arrName[49].equalsIgnoreCase(vo.getAttrCtnt3())) {
										if (!"".equals(val)) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.replaceAll(".0","").toUpperCase()).append(lineSep);
										} 
										//IRF_MIN_TEMP
									} else if (arrName[50].equalsIgnoreCase(vo.getAttrCtnt3()) ) {
										if (!"".equals(val)) {
											log.debug("\n\n getExcelCellValue(sheet1.getRow(x).getCell(y-1))) : "+ getExcelCellValue(sheet1.getRow(x).getCell(y-1)));
											log.debug("\n\n getExcelCellValue(sheet1.getRow(x).getCell(y+1))) : "+ getExcelCellValue(sheet1.getRow(x).getCell(y+1)));
											if("-".equals(getExcelCellValue(sheet1.getRow(x).getCell(y-1)))){
												flatFile.append(vo.getAttrCtnt3()).append(colon).append("-").append(val.toUpperCase()).append(lineSep);
												
											}else{
												flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.toUpperCase()).append(lineSep);
											}
										}
										//IRF_NATURE_TYPE
									} else if (arrName[51].equalsIgnoreCase(vo.getAttrCtnt3()) ) {
										if (!"".equals(val)) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(util.searchCoolingTypeByName(val).toUpperCase()).append(lineSep);										
										}	
										//IRF_VENTI_UNIT
									} else if (arrName[52].equalsIgnoreCase(vo.getAttrCtnt3()) ) {
										if (!"".equals(val)) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(util.searchVentilationTypeByName(val).toUpperCase()).append(lineSep);										
										}	
										// IRF_GENSET
									} else if (arrName[53].equalsIgnoreCase(vo.getAttrCtnt3()) ) {
										if (!"".equals(val)) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.substring(0,1).toUpperCase()).append(lineSep);
										}
										// POLCD_POLNM [CHM-201431993] 미주지역 SIMPLE BKG 템플릿 변경 요청
									} else if (arrName[54].equalsIgnoreCase(vo.getAttrCtnt3()) ) {									

										if (!"".equals(val)) {
											
											String polCd = getExcelCellValue(findCellsByName(wb,arrTemp[0]+arrName[54]).get(0)).substring(0,5);
											String polNm = getExcelCellValue(findCellsByName(wb,arrTemp[0]+arrName[54]).get(0)).substring(6);
											
											log.debug("\n\n polCd: "+ polCd);
											log.debug("\n\n polNm : "+ polNm);
											
											flatFile.append(arrName[55]).append(colon).append(polCd.toUpperCase()).append(lineSep);
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(polNm.toUpperCase()).append(lineSep);
										}
										
									} else {
										if (!"".equals(val)) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.toUpperCase()).append(lineSep);
										}
									}
								}
							}
							//close group///////////////////////////////////////
							if (!arrName[0].equalsIgnoreCase(vo.getAttrCtnt1())) {
								if (idx < mapList.size()) {
									if (!vo.getAttrCtnt1().equalsIgnoreCase(mapList.get(idx).getAttrCtnt1())) {
										LOOP_FLAT_FILE_GROUP_CLOSE:
											for (BkgHrdCdgCtntVO group : grpList) {
												if (group.getAttrCtnt1().equalsIgnoreCase(vo.getAttrCtnt1())) {
													flatFile.append(group.getAttrCtnt5()).append(lineSep);
													break LOOP_FLAT_FILE_GROUP_CLOSE;
												}
											}
									}
								} else {
									flatFile.append(vo.getAttrCtnt5().toUpperCase()).append(lineSep);
								}
							}
						}
						log.debug("\n\n\n\n\n\n\n\n\n\n\n\n"
								+"\n==Main_BL==========\n"
								+flatFile
								+"\n====================\n"
								+"\n\n\n\n\n\n\n\n\n\n\n\n");
						rqstNoVo = command.receiptXterRqst(flatFile.toString());
					}
				}
			
			} else if("VGM".equalsIgnoreCase(sheet1Nm)){
				docTpCd = "B";
				if ( null != wb ){
					if (null!=sheet1) {
						
						//	command.receiptXterVGMRqst(flatFile.toString());
						
						FormulaEvaluator objFormulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();// new XSSFFormulaEvaluator((XSSFWorkbook) wb);
			       		DataFormatter objDefaultFormat = new DataFormatter();
			       		//Get iterator to all the rows in current sheet
			       		Iterator<Row> rowIterator2 = sheet1.iterator();
			       		
			       		String[] header = new String[]{
			       				  "Booking No"
			       				, "CONTAINER"
			       				, "WEIGHT"
			       				, "WEIGHT UNIT"
			       				, "METHOD"
			       				, "SIGNATURE"
			       				};
			       		List<BkgXterVrfdWgtRqstVO> rqstList = new ArrayList<BkgXterVrfdWgtRqstVO>();
						List<BkgXterVrfdWgtPtyVO> ptyList = new ArrayList<BkgXterVrfdWgtPtyVO>();
						boolean isNull = true;
						int cnt = -1;
			       		while(rowIterator2.hasNext()) {		
			       			cnt++;			       			
			       	        Row row = rowIterator2.next();
			       	        if(cnt == 0 || cnt == 1){
			       				continue;
			       			}
			       	        BkgXterVrfdWgtRqstVO rqstVo = new BkgXterVrfdWgtRqstVO();
							BkgXterVrfdWgtPtyVO ptyVo = new BkgXterVrfdWgtPtyVO();							
			   	    		for(int i=0; i< header.length;i++){	   	    			
			   	    			Cell cellValue = row.getCell(i);	
			   	    			String cellStr = "";			   	    			
			   	    			if(cellValue != null && cellValue.getCellType() != Cell.CELL_TYPE_BLANK){	   	    				
			   	    				objFormulaEvaluator.evaluate(cellValue);
			   	    				cellStr = objDefaultFormat.formatCellValue(cellValue,objFormulaEvaluator);
			   	    			}
			   	    		    switch (i) {
			   	    		    	case 0    :  //Booking No
			   	    		    		cellStr = cellStr.trim();
			   	    		    		if(!StringUtils.isEmpty(cellStr)){
			   	    		    			isNull = false;
			   	    		    		}			   	    		    		
			   	    		    		rqstVo.setXterSndrId("EXCEL");
			   	    		    		rqstVo.setBkgNo(cellStr);
			   	    		    		rqstVo.setXterVgmRqstNo(cellStr);
			   	    		    		rqstVo.setXterRqstViaCd("SIM");
			   	    		    		rqstVo.setSmtCntcDesc(e.getAttribute("emailSubject").toString());
			   	    		    		String today = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
			   	    		    		rqstVo.setSmtDt(today);
			   	    		    		rqstVo.setSmtEml(e.getAttribute("emailAddr").toString());
			   	    		    		ptyVo.setXterSndrId("EXCEL");
			   	    		    		ptyVo.setXterVgmRqstNo(cellStr);
			   	    		    		ptyVo.setVgmPtyTpCd("SPC");
			   	    		    		break;
			   	    		    	case 1   :   //CONTAINER
			   	    		    		cellStr = cellStr.replaceAll("[^A-Za-z0-9]", "");
			   	    		    		rqstVo.setCntrNo(cellStr);
			   	    		    		ptyVo.setCntrNo(cellStr);
			   	    		    		break;
			   	    		    	case 2    :  //WEIGHT
			   	    		    		rqstVo.setVgmWgt(cellStr.replaceAll(",", ""));
			   	    		    		break;
			   	    		    	case 3    :  //WEIGHT UNIT
			   	    		    		rqstVo.setVgmWgtUtCd(cellStr);
			   	    		    		break;
			   	    		    	case 4    :  //METHOD
			   	    		    		String method = "SM1";
			   	    		    		if(cellStr != null && cellStr.indexOf("2") > -1){
			   	    		    			method = "SM2";
			   	    		    		}
			   	    		    		rqstVo.setVgmMzdTpCd(method);
			   	    		    		break;
			   	    		    	case 5    :  //SIGNATURE
			   	    		    		ptyVo.setAuthPsonNm(cellStr);
			   	    		    		break;			   	    		    	
			   	    		    }
			   	    		}
			       			if(!isNull){
			       				rqstList.add(rqstVo);
			       				ptyList.add(ptyVo);
			       				isNull = true;
			       			} 	   	    		
			       		}
			       		
			       		command.receiptXterVGMRqstXls(rqstList, ptyList);
					}
				}
			} else {
				docTpCd = "S";
				if (null!=wb) {
					wb.setMissingCellPolicy(Row.CREATE_NULL_AS_BLANK);//RETURN_NULL_AND_BLANK);//.RETURN_BLANK_AS_NULL);//.CREATE_NULL_AS_BLANK);
					if (null!=sheet1) {
						boolean isNewForm = false;
						isNewForm = sheet1Nm.indexOf("v2") > -1 ? true : false;
						int cntrRowCount = isNewForm ? 11 : 7;
						idx = 0;
						flatFile = new StringBuilder();
						util = new BookingUtil();
						rqstNoVo = new XterRqstNoVO();
						paramVO.setAttrCtnt10("EDI_MAIN");
						grpList = command.searchMqXlsGroupList(paramVO);  //XTER_BKG_RECEIPT_ORD
						mapList = command.searchMqXlsMappingList(paramVO);  //XTER_BKG_RECEIPT_XLS
						for (BkgHrdCdgCtntVO vo : mapList) {
							//open group///////////////////////////////////////
							if (0>flatFile.indexOf(vo.getAttrCtnt4()) && !arrName[0].equalsIgnoreCase(vo.getAttrCtnt1())) {
								LOOP_FLAT_FILE_GROUP_OPEN:
									for (BkgHrdCdgCtntVO group : grpList) {
										if (group.getAttrCtnt1().equalsIgnoreCase(vo.getAttrCtnt1())) {
											flatFile.append(group.getAttrCtnt4()).append(lineSep);
											break LOOP_FLAT_FILE_GROUP_OPEN;
										}
									}
							}
							cells = findCellsByName(wb,vo.getAttrCtnt2());
							log.debug("\n vo.getAttrCtnt2():"+vo.getAttrCtnt2());
							if (null == cells && arrName[31].equalsIgnoreCase(vo.getAttrCtnt3()) ) {
								flatFile.append(vo.getAttrCtnt3()).append(colon).append( (String)e.getAttribute("emailAddr") ).append(lineSep);
							}
							
							idx+=1;
							if (null!=cells) {
								if (1<cells.size()) {
									for (Cell temp : cells) {
										if (null!=temp) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(getExcelCellValue(temp).toUpperCase()).append(lineSep);
										}
									}
									if (arrName[23].equalsIgnoreCase(vo.getAttrCtnt3()) || arrName[24].equalsIgnoreCase(vo.getAttrCtnt3())) {
										flatFile.append(this.getMndSheetData(sheet2,arrName[23].equalsIgnoreCase(vo.getAttrCtnt3()) ? 0:1,vo.getAttrCtnt3()).toUpperCase());
									}
								} else {
									cell = cells.get(0);
									x = cell.getRowIndex();
//								mx = cell.getRowIndex();
									y = cell.getColumnIndex();
//								my = cell.getColumnIndex();
									val = getExcelCellValue(cell);
									log.debug("\n getExcelCellValue(cell):"+val);
									//contents///////////////////////////////////////
									//1.container
									if (!isEndCntr && arrName[1].equalsIgnoreCase(vo.getAttrCtnt3())) {
										LOOP_CNTR:
											while (null!=sheet1 && null!=sheet1.getRow(x) && null!=sheet1.getRow(x).getCell(y)) {
												if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(y)))) {
													flatFile.append(this.getCntrEdiFlatFile(0, sheet1, x, y, true, isNewForm).toUpperCase());
													//jsy getCntrEdiFlatFile 의 첫번째 인자인 1은  i_cm_mark_desc를 위한 구분자
													// 5번째 인자는 true면 cntr좌측꺼, false면 우측꺼를 위한 구분자.. (엑셀의 셀간격이 3,4 인 차이를 구분하기 위해)
//											flatFile.append(this.getCntrEdiFlatFile(1, sheet1, x, y, true));  
												}
												if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x).getCell(6+y)))) {
													flatFile.append(this.getCntrEdiFlatFile(0, sheet1, x, 6+y, false, isNewForm).toUpperCase());
												}
												if ("".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x+7).getCell(y))) &&
														"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(x+7).getCell(6+y)))) {
													isEndCntr = true;
													break LOOP_CNTR;
												}
												x+=cntrRowCount;// hts/hs/nvm code라인 추가 +1
											}
//									LOOP_CM_MARK:
//									while (null!=sheet1 && null!=sheet1.getRow(mx) && null!=sheet1.getRow(mx).getCell(my)) {
//										if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(mx).getCell(my)))) {
//											//jsy getCntrEdiFlatFile 의 첫번째 인자인 1은  i_cm_mark_desc를 위한 구분자
//											// 5번째 인자는 true면 cntr좌측꺼, false면 우측꺼를 위한 구분자.. (엑셀의 셀간격이 3,4 인 차이를 구분하기 위해)
//											flatFile.append(this.getCntrEdiFlatFile(1, sheet1, mx, my, true));  
//										}
//										if (!"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(mx).getCell(6+my)))) {
//											flatFile.append(this.getCntrEdiFlatFile(1, sheet1, mx, 6+my, false));
//										}
//										if ("".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(mx+8).getCell(my))) &&
//											"".equalsIgnoreCase(getExcelCellValue(sheet1.getRow(mx+8).getCell(6+my)))) {
//											isEndCntr = true;
//											break LOOP_CM_MARK;
//										}
//										mx+=8;// hts/hs/nvm code라인 추가 +1
//									}								
									//2.container외
									} else if (arrName[2].equalsIgnoreCase(vo.getAttrCtnt3())) {
										bkgNo = val.trim();
										flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.toUpperCase()).append(lineSep);
										flatFile.append(arrName[3]).append(colon).append(arrValue[0].toUpperCase()).append(lineSep);
										flatFile.append(arrName[4]).append(colon).append(arrValue[1].toUpperCase()).append(lineSep);
										flatFile.append(arrName[15]).append(colon).append(arrValue[6].toUpperCase()).append(lineSep);
										inputVO = new ExternalRqstListInputVO();
										if(bkgNo != null && bkgNo.length() > 0){
											inputVO.setBkgNo(bkgNo);
											inputVO.setDocTpCd(arrValue[6]);
											flatFile.append(arrName[17]).append(colon).append(0<command.searchXterRqstList(inputVO).size()?"U":"C").append(lineSep);
										}
									} else if (arrName[5].equalsIgnoreCase(vo.getAttrCtnt3())) {
										refNo = !"".equals(val) ? val : getExcelCellValue(findCellsByName(wb,arrTemp[0]+arrName[2]).get(0));  //ref no 없는경우에 bkg no 로 대체함
										refNo = refNo.trim();
										flatFile.append(vo.getAttrCtnt3()).append(colon).append(refNo.toUpperCase()).append(lineSep);
									} else if (arrName[6].equalsIgnoreCase(vo.getAttrCtnt3())) {
//									flatFile.append(vo.getAttrCtnt3()).append(colon).append(arrTemp[1].equals(val.toUpperCase() ) ? arrValue[2]:arrValue[3]).append(lineSep);
										flatFile.append(vo.getAttrCtnt3().toUpperCase()).append(colon);
										if(!"".equals(val) ) {
											flatFile.append( arrTemp[1].equals(val.toUpperCase() ) ? arrValue[2].toUpperCase():arrValue[3].toUpperCase()).append(lineSep);
										} else{
											flatFile.append(lineSep);
										}
									} else if (arrName[7].equalsIgnoreCase(vo.getAttrCtnt3())) {
										flatFile.append(vo.getAttrCtnt3()).append(colon); //.append(arrTemp[2].equals(val.toUpperCase()) ? arrValue[4]:"").append(lineSep);
										if(arrTemp[2].equals(val.toUpperCase())){
											flatFile.append(arrValue[4].toUpperCase());
										} else if(arrTemp[3].equals(val.toUpperCase())){
											flatFile.append("S");
										}else if(arrTemp[4].equals(val.toUpperCase())){
											flatFile.append("O");
										}
										flatFile.append(lineSep);
										
									} else if (arrName[8].equalsIgnoreCase(vo.getAttrCtnt3())) {
										flatFile.append(vo.getAttrCtnt3()).append(colon).append(val+getExcelCellValue(sheet1.getRow(x).getCell(3+y)).toUpperCase()).append(lineSep);
									} else if (arrName[13].equalsIgnoreCase(vo.getAttrCtnt3())) {
										if (!"".equals(val) && 4<=val.length()) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.substring(0,4).toUpperCase()).append(lineSep);
											if (5<=val.length()) {
												flatFile.append(arrName[14]).append(colon).append(val.substring(4,5).toUpperCase()).append(lineSep);
											}
										}
									} else if (arrName[16].equalsIgnoreCase(vo.getAttrCtnt3()) && !"".equals(val)) {
										steVO = util.searchSteCodeByName(val);
										if (null!=steVO) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(steVO.getSteCd().toUpperCase()).append(lineSep);
										}
									} else if (arrName[18].equalsIgnoreCase(vo.getAttrCtnt3())) {
										pckVO = util.searchPkgTypeByName(getExcelCellValue(cell).toUpperCase());
										flatFile.append(vo.getAttrCtnt3()).append(colon).append(null!=pckVO ? pckVO.getPckCd():"").append(lineSep);
									} else if (arrName[21].equalsIgnoreCase(vo.getAttrCtnt3())) {
										if (!"".equals(val)) {
											ibExpInd = val;
											flatFile.append(arrName[21]).append(colon).append(arrValue[7].toUpperCase()).append(lineSep);
											flatFile.append(arrName[22]).append(colon).append(val.toUpperCase()).append(lineSep);
										}
									} else if (arrName[22].equalsIgnoreCase(vo.getAttrCtnt3())) {
										if (!"".equals(val) && "".equals(ibExpInd)) {
											flatFile.append(arrName[21]).append(colon).append(arrValue[7].toUpperCase()).append(lineSep);
											flatFile.append(arrName[22]).append(colon).append(val.toUpperCase()).append(lineSep);
										}
									} else if (arrName[25].equalsIgnoreCase(vo.getAttrCtnt3()) ||
											arrName[26].equalsIgnoreCase(vo.getAttrCtnt3()) ||
											arrName[27].equalsIgnoreCase(vo.getAttrCtnt3())) {
										if (!"".equals(val)) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.replaceAll(",","").toUpperCase()).append(lineSep);
										}
									} else if (arrName[28].equalsIgnoreCase(vo.getAttrCtnt3()) ) {
										if (!"".equals(val)) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.replaceAll(",","").toUpperCase()).append(lineSep);
										}
									} else if (arrName[29].equalsIgnoreCase(vo.getAttrCtnt3()) ) {
										if (!"".equals(val)) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.replaceAll(",","").toUpperCase()).append(lineSep);
										}	
									} else if (arrName[30].equalsIgnoreCase(vo.getAttrCtnt3()) ) {
										if (!"".equals(val)) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.replaceAll(",","").toUpperCase()).append(lineSep);
										}
									} else if (arrName[31].equalsIgnoreCase(vo.getAttrCtnt3()) ) {
										flatFile.append(vo.getAttrCtnt3()).append(colon).append( (String)e.getAttribute("emailAddr") ).append(lineSep);
									} else {
										if (!"".equals(val)) {
											flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.toUpperCase()).append(lineSep);
										}
									}
								}
							}
							//close group///////////////////////////////////////
							if (!arrName[0].equalsIgnoreCase(vo.getAttrCtnt1())) {
								if (idx < mapList.size()) {
									if (!vo.getAttrCtnt1().equalsIgnoreCase(mapList.get(idx).getAttrCtnt1())) {
										LOOP_FLAT_FILE_GROUP_CLOSE:
											for (BkgHrdCdgCtntVO group : grpList) {
												if (group.getAttrCtnt1().equalsIgnoreCase(vo.getAttrCtnt1())) {
													flatFile.append(group.getAttrCtnt5()).append(lineSep);
													break LOOP_FLAT_FILE_GROUP_CLOSE;
												}
											}
									}
								} else {
									flatFile.append(vo.getAttrCtnt5()).append(lineSep);
								}
							}
						}
						log.info("\n\n\n\n\n\n\n\n\n\n\n\n"
								+"\n==Main_BL==========\n"
								+flatFile
								+"\n====================\n"
								+"\n\n\n\n\n\n\n\n\n\n\n\n");
						rqstNoVo = command.receiptXterRqst(flatFile.toString());
					}
					if (null!=sheet3) {
						//1. HOUSE B/L NO 나 2. ACTUAL NAME 에 값이 있는 경우에만 HBL 수행
						if (!"".equals(getExcelCellValue(this.findCellsByName(wb,arrName[19]).get(0))) ||
								!"".equals(getExcelCellValue(this.findCellsByName(wb,arrName[20]).get(0)))) {
							isEndCntr = false;
							idx = 0;
							flatFile = new StringBuilder();
							paramVO.setAttrCtnt10("HBL");
							grpList = command.searchMqXlsGroupList(paramVO);  //XTER_BKG_RECEIPT_ORD
							mapList = command.searchMqXlsMappingList(paramVO);  //XTER_BKG_RECEIPT_XLS
							for (BkgHrdCdgCtntVO vo : mapList) {
								//open group///////////////////////////////////////
								if (0>flatFile.indexOf(vo.getAttrCtnt4()) && !arrName[11].equalsIgnoreCase(vo.getAttrCtnt1())) {
									LOOP_FLAT_FILE_GROUP_OPEN:
										for (BkgHrdCdgCtntVO group : grpList) {
											if (group.getAttrCtnt1().equalsIgnoreCase(vo.getAttrCtnt1())) {
												flatFile.append(group.getAttrCtnt4()).append(lineSep);
												break LOOP_FLAT_FILE_GROUP_OPEN;
											}
										}
								}
								cells = findCellsByName(wb,vo.getAttrCtnt2());
								idx+=1;
								if (null!=cells) {
									if (1<cells.size()) {
										for (Cell temp : cells) {
											if (null!=temp) {
												flatFile.append(vo.getAttrCtnt3()).append(colon).append(getExcelCellValue(temp).toUpperCase()).append(lineSep);
											}
										}
									} else {
										cell = cells.get(0);
										x = cell.getRowIndex();
										y = cell.getColumnIndex();
										val = getExcelCellValue(cell);
										//contents///////////////////////////////////////
										//1.container
										if (!isEndCntr && arrName[1].equalsIgnoreCase(vo.getAttrCtnt3())) {
											LOOP_CNTR:
												while (null!=sheet3 && null!=sheet3.getRow(x) && null!=sheet3.getRow(x).getCell(y)) {
													if (!"".equalsIgnoreCase(getExcelCellValue(sheet3.getRow(x).getCell(y)))) {
														flatFile.append(this.getCntrEdiFlatFile(2, sheet3, x, y, true, ++icmdSeq, false).toUpperCase());
													}
													if (!"".equalsIgnoreCase(getExcelCellValue(sheet3.getRow(x).getCell(4+y)))) {
														flatFile.append(this.getCntrEdiFlatFile(2, sheet3, x, 4+y, false, ++icmdSeq, false).toUpperCase());
													}
													if ("".equalsIgnoreCase(getExcelCellValue(sheet3.getRow(x+7).getCell(y))) &&
															"".equalsIgnoreCase(getExcelCellValue(sheet3.getRow(x+7).getCell(4+y)))) {
														isEndCntr = true;
														break LOOP_CNTR;
													}
													x+=7;
												}
										//2.container외
										} else {
											if (arrName[12].equalsIgnoreCase(vo.getAttrCtnt3())) {
												flatFile.append(arrName[5]).append(colon).append(refNo.toUpperCase()).append(arrValue[5]).append(lineSep);
												flatFile.append(arrName[2]).append(colon).append(bkgNo.toUpperCase()).append(lineSep);
												flatFile.append(arrName[3]).append(colon).append(arrValue[0].toUpperCase()).append(lineSep);
												flatFile.append(arrName[4]).append(colon).append(arrValue[1].toUpperCase()).append(lineSep);
												flatFile.append(arrName[7]).append(colon).append(arrValue[5].toUpperCase()).append(lineSep);
												flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.toUpperCase()).append(lineSep);
											} else {
												flatFile.append(vo.getAttrCtnt3()).append(colon).append(val.toUpperCase()).append(lineSep);
											}
										}
									}
								}
								//close group///////////////////////////////////////
								if (!arrName[11].equalsIgnoreCase(vo.getAttrCtnt1())) {
									if (idx < mapList.size()) {
										if (!vo.getAttrCtnt1().equalsIgnoreCase(mapList.get(idx).getAttrCtnt1())) {
											LOOP_FLAT_FILE_GROUP_CLOSE:
												for (BkgHrdCdgCtntVO group : grpList) {
													if (group.getAttrCtnt1().equalsIgnoreCase(vo.getAttrCtnt1())) {
														flatFile.append(group.getAttrCtnt5()).append(lineSep);
														break LOOP_FLAT_FILE_GROUP_CLOSE;
													}
												}
										}
									} else {
										flatFile.append(vo.getAttrCtnt5().toUpperCase()).append(lineSep);
									}
								}
							}
							log.info("\n\n\n\n\n\n\n\n\n\n\n\n"
									+"\n==HBL===============\n"
									+flatFile
									+"\n====================\n"
									+"\n\n\n\n\n\n\n\n\n\n\n\n");
							command.receiptXterRqst(flatFile.toString());
						}
					}
				}
				
			}
			
			commit();  //임시 jsy
			
			//[CHM-201323701] Simple BKG이 당 사 시스템에 정상 처리된 경우 자동을 안내 메일을 발송 2013.04.04
			if ("B".equals(docTpCd) && "Main_BL".equalsIgnoreCase(sheet1Nm)) {
				sendSuccessMailBySimpleEDI((String)e.getAttribute("emailAddr"), bkgNo, docTpCd );
			}
		} catch(IllegalArgumentException ix){
			rollback();
			log.error("this is not excel file");
			if (flatFile !=null){
				sendErrLogMail(flatFile.toString(), ix);
			}
			//[CHM-201432429] SIMPLE BKG FAILURE MESSAGE 수정 요청 2014.10.22
			sendErrLogMailBySimpleEDI((String)e.getAttribute("emailAddr"), bkgNo, docTpCd, (String)e.getAttribute("emailSubject") );
			throw ix;
		} catch(EventException ex) {
			rollback();
//			log.error("err " + ex.toString(), ex);
			if (flatFile !=null){
				sendErrLogMail(flatFile.toString(), ex);
			}
			//[CHM-201432429] SIMPLE BKG FAILURE MESSAGE 수정 요청 2014.10.22
			sendErrLogMailBySimpleEDI((String)e.getAttribute("emailAddr"), bkgNo, docTpCd, (String)e.getAttribute("emailSubject") );
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			if (flatFile !=null){
				sendErrLogMail(flatFile.toString(), ex);
			}
			//[CHM-201432429] SIMPLE BKG FAILURE MESSAGE 수정 요청 2014.10.22
			sendErrLogMailBySimpleEDI((String)e.getAttribute("emailAddr"), bkgNo, docTpCd, (String)e.getAttribute("emailSubject") );
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		//E-Booking 데이타가 들어온 경우 DPCS 에 데이타 입력함.
		if (null!=rqstNoVo) {
			try {
				begin();
				dpcsWebBookingVO.setXterSndrId(rqstNoVo.getSenderId());
				dpcsWebBookingVO.setXterRqstNo(rqstNoVo.getRqstNo());
				dpcsWebBookingVO.setXterRqstSeq(rqstNoVo.getRqstSeq());
				if (!"E".equals(rqstNoVo.getDocTpCd()) && !"H".equals(rqstNoVo.getXterBlTpCd())) {
					command2.addBkgSrRequest(dpcsWebBookingVO);	
				}
				commit();
			} catch(EventException ex) {
				rollback();
//				log.error("err " + ex.toString(), ex);
				if (flatFile !=null){
					sendErrLogMail(flatFile.toString(), ex);
				}
				throw ex;
			} catch(Exception ex) {
				rollback();
				log.error("err " + ex.toString(), ex);
				if (flatFile !=null){
					sendErrLogMail(flatFile.toString(), ex);
				}
				throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
			}
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0229 : REINSTATE 클릭
	 * EBookingReceipt의 요청건의 상태를 원복시킨다.<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse reinstateXterRqst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg022901Event event = (EsmBkg022901Event)e;
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		try{
			begin();
			command.changeXterRqstStatus(event.getXterRqstNoVOs(), "N", "" ,account);
			eventResponse.setETCData("SuccessYn", "Y");
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

//	/**
//	 * Find Booking 버튼 Click 시 ALPS Booking 정보만 조회<br>
//	 * 
//	 * @param Event e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse searchAlpsBkg(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//
//		try {
////			EsmBkg022901Event event = (EsmBkg022901Event)e;
//
////			EBookingReceiptBC command = new EBookingReceiptBCImpl();
////			ExternalRqstBkgVO externalRqstBkgVO = command.searchAlpsBkg(event.getXterRqstNoVO());
//
////			eventResponse.setETCData(externalRqstBkgVO.getAlpsBkgVO().getColumnValues());
////			eventResponse.setRsVoList(externalRqstBkgVO.getAlpsQtyVO());
////			eventResponse.setRsVoList(externalRqstBkgVO.getVslSkdVO());
////			eventResponse.setRsVoList(externalRqstBkgVO.getAlpsQtyDtlVO());
////		} catch (EventException ex) {
////			throw ex;
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
//		}
//		return eventResponse;
//	}

	/**
	 * BKG No가 존재하는지 유효성 검사<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgBlNo(Event e) throws EventException {
		EsmBkg022901Event event = (EsmBkg022901Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			BookingUtil utilCmd = new BookingUtil();
			BkgBlNoVO bkgBlNoVO = utilCmd.searchBkgBlNoVO(event.getBkgBlNoVO());
			if (bkgBlNoVO == null) {
				throw new EventException(new ErrorHandler("BKG01049", new String[] { event.getBkgBlNoVO().getBkgNo() }).getMessage());
			}
		} catch (EventException ex) {
//			log.error("err " + ex.toString(), ex);
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch (Exception ex) {			
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * UI_BKG_0228조회화면의 COMBO 값 조회(공통 CODE 조회)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode0228(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			BookingUtil comboUtil = new BookingUtil();
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			
			BkgComboVO combovo = new BkgComboVO();
			combovo.setDesc("All");
			combovo.setVal("All");

			// Request Status - xter_bkg_rqst_sts_cd
			List<BkgComboVO> xter_bkg_rqst_sts_cd = comboUtil.searchCombo("CD01620");
			// STS Code에서 'T'를 뺀다.
			List<BkgComboVO> list_xter_bkg_rqst_sts_cd = new ArrayList<BkgComboVO>();

			for(int i=0;i<xter_bkg_rqst_sts_cd.size();i++){
	            BkgComboVO vo = xter_bkg_rqst_sts_cd.get(i);
	            if ( !vo.getVal().equals("T") ){
					BkgComboVO comboVo = new BkgComboVO();
					comboVo.setComboCd(vo.getComboCd());
					comboVo.setVal(vo.getVal());
					comboVo.setName(vo.getVal());
					comboVo.setDesc(vo.getDesc());
					list_xter_bkg_rqst_sts_cd.add(comboVo);
	            }
	        }

			// Upload Status - bkg_upld_sts_cd
			List<BkgComboVO> bkg_upld_sts_cd = comboUtil.searchCombo("CD01630");

			// Via - xter_rqst_via_cd
			List<BkgComboVO> xter_rqst_via_cd = comboUtil.searchCombo("CD01622");

//			for(int i=0;i<xter_rqst_via_cd.size();i++){
//				if("NIS".equals(xter_rqst_via_cd.get(i).getVal())||"APS".equals(xter_rqst_via_cd.get(i).getVal())){
//					xter_rqst_via_cd.get(i).setVal("OFF");
//					xter_rqst_via_cd.get(i).setName("OFF");
//				}
//			}
			// DOCType - doc_tp_cd
			List<BkgComboVO> doc_tp_cd = comboUtil.searchCombo("CD02090");

			// Delivery - conti_cd
			List<BkgComboVO> delivery = command.searchComboMdmConti();

			eventResponse.setRsVoList(list_xter_bkg_rqst_sts_cd);
			eventResponse.setRsVoList(bkg_upld_sts_cd);
			eventResponse.setRsVoList(xter_rqst_via_cd);
			eventResponse.setRsVoList(doc_tp_cd);
			eventResponse.setRsVoList(delivery);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * UI_BKG_0902 조회화면의 COMBO 값 조회(공통 CODE 조회)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode0902(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EsmBkg0902Event event = (EsmBkg0902Event)e;
			BookingUtil comboUtil = new BookingUtil();

			// Reject Reason Code - reject_reason_cd
			List<BkgComboVO> reject_reason_cd  = comboUtil.searchCombo("CD02193");

			eventResponse.setCustomData("reject_reason_cd", reject_reason_cd);
			eventResponse.setCustomData("xterRqstNoVO", event.getXterRqstNoVO());
			eventResponse.setCustomData("cntc_eml", event.getCntcEml());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EBooking의 commodity description 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmCmdtDesc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EsmBkg022907Event event = (EsmBkg022907Event)e;
			BookingUtil bUtil = new BookingUtil();
			String cmdtDesc = null;
			
			cmdtDesc = bUtil.searchMdmCmdtDesc(event.getCmdtCd());
			eventResponse.setETCData("cmdt_desc", cmdtDesc);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EBooking의 CONTAINER TAB의 container별 type/size 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTypeSizeByCntr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EsmBkg022903Event event = (EsmBkg022903Event)e;
			BookingUtil bUtil = new BookingUtil();
			List<MstContainerVO> list = null;
			String cntrTpszCd = null;
			String cntrNo = null;
			
			list = bUtil.searchTypeSizeByCntr(event.getCntrNo());
			if (list != null && list.size() > 0) {
				MstContainerVO mstContainerVO = (MstContainerVO) list.get(0);
				cntrTpszCd = mstContainerVO.getCntrTpszCd();
				cntrNo = mstContainerVO.getCntrNo();				
			}
			eventResponse.setETCData("cntr_tpsz_cd", cntrTpszCd);
			eventResponse.setETCData("cntr_no", cntrNo);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0229 : VVD CHANGE
	 * EBookingReceipt의 BOOKING TAB에서 VESSEL 입력시 VESSEL NAME 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVslNm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EsmBkg022901Event event = (EsmBkg022901Event)e;
			BookingUtil bUtil = new BookingUtil();
			BookingMasterMgtBC command = new BookingMasterMgtBCImpl();
			String vslNm = null;
			String etdDt = null;

			vslNm = bUtil.searchVslNm(event.getBkgTrunkVvd());
			eventResponse.setETCData("vsl_nm", vslNm);
			
			VskVslPortSkdConditionVO vskVslPortSkdConditionVO = new VskVslPortSkdConditionVO();
			vskVslPortSkdConditionVO.setVslCd(event.getBkgTrunkVvd());;
			
			if(event.getBkgTrunkVvd().length()>8){
				List<VskVslPortSkdConditionVO> list = command.searchEtbEtdEta(vskVslPortSkdConditionVO);
				etdDt = list!=null&&list.size()>0?list.get(0).getEtdDt():"";
			}
			eventResponse.setETCData("etd_dt", etdDt);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0229_09 : OPEN
	 * EBookingReceipt의 AWKWARD CARGO 정보 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterAk(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EsmBkg022909Event event = (EsmBkg022909Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			
			ExternalRqstAkVO externalRqstAkVO = command.searchXterAk(event.getXterRqstNoVO());

			BookingUtil comboUtil = new BookingUtil();
			List<BkgComboVO> wgt_cd = comboUtil.searchCombo("CD00775");

			List<AlpsCntrTpszVO> cntrTpsz = externalRqstAkVO.getAlpsCntrTpszVO();
			eventResponse.setCustomData("cntr_tpsz", cntrTpsz);
			eventResponse.setCustomData("wgt_cd", wgt_cd);

			eventResponse.setCustomData("externalRqstAkVO", externalRqstAkVO);
			eventResponse.setRsVoList(externalRqstAkVO.getNisAkVO());
			
			//A/K Rider 조회
			// Alps ak rider 
			List<XterDgRiderVO> alpsAkRiderVOs = command.searchAlpsAkRiderList(event.getXterRqstNoVO());
			eventResponse.setRsVoList(alpsAkRiderVOs);
			
			// e-svc dg rider
			List<XterDgRiderVO> xterAkRiderVOs = command.searchXterAkRiderList(event.getXterRqstNoVO());
			eventResponse.setRsVoList(xterAkRiderVOs);
			
        	// Awkawrd Criteria 조회
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("AWK_CRITERIA");
			List<BkgHrdCdgCtntVO> hrdCdgList = comboUtil.searchHardCoding(bkgHrdCdgCtntListCondVO);
			eventResponse.setRsVoList(hrdCdgList);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0229_12 : OPEN
	 * EBookingReceipt의 Break Bulk CARGO 정보 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterBb(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EsmBkg022912Event event = (EsmBkg022912Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			
			ExternalRqstBbVO externalRqstBbVO = command.searchXterBb(event.getXterRqstNoVO());

			BookingUtil comboUtil = new BookingUtil();
			List<BkgComboVO> wgt_cd = comboUtil.searchCombo("CD00775");

			List<AlpsCntrTpszVO> cntrTpsz = externalRqstBbVO.getAlpsCntrTpszVO();
			eventResponse.setCustomData("cntr_tpsz", cntrTpsz);
			eventResponse.setCustomData("wgt_cd", wgt_cd);

			eventResponse.setCustomData("externalRqstBbVO", externalRqstBbVO);
			eventResponse.setRsVoList(externalRqstBbVO.getAlpsBbVO());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	

	/**
	 * ESM_BKG_0229 : OPEN
	 * eSVC(EDI, WEB 등)으로 받은 Booking 정보와 ALPS에 저장된 Booking 정보 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterBkg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg022901Event event	= (EsmBkg022901Event)e;
		try {
			EBookingReceiptBC 		command 	= new EBookingReceiptBCImpl();
			GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
			BookingUtil				util 		= new BookingUtil();
			BLIssuanceBC 			blIssBC 	= new BLIssuanceBCImpl();
			
			List<BkgComboVO> rcv_term 			= util.searchCombo("CD00764");
			List<BkgComboVO> dlv_term  			= util.searchCombo("CD00765");
//			List<BkgComboVO> frt_term_cd  		= util.searchCombo("CD02080");
			List<BkgComboVO> usa_cstms_file_cd  = util.searchCombo("CD02098");
			List<BkgComboVO> cnd_cstms_file_cd  = util.searchCombo("CD01634");
			List<BkgComboVO> wgt_ut_cd  		= util.searchCombo("CD00775");
			// 05. Combo 데이터 조회 (RailBulk)
			List<BkgComboVO> railBulk           = util.searchCombo("CD01566");
			List<BkgComboVO> idaCM           = util.searchCombo("CD01625");

			eventResponse.setRsVoList(rcv_term);			//arrXml[0]
			eventResponse.setRsVoList(dlv_term);			//arrXml[1]
//			eventResponse.setRsVoList(frt_term_cd);			//arrXml[2]
			eventResponse.setRsVoList(usa_cstms_file_cd);	//arrXml[2]2
			eventResponse.setRsVoList(cnd_cstms_file_cd);	//arrXml[3]3
			eventResponse.setRsVoList(wgt_ut_cd);			//arrXml[4]4
			eventResponse.setRsVoList(railBulk);	        //arrXml[5]
			eventResponse.setRsVoList(idaCM);	        //arrXml[6]
			

			ExternalRqstBkgVO externalRqstBkgVO = command.searchXterBkg(event.getXterRqstNoVO(), account);
			eventResponse.setCustomData("externalRqstBkgVO", externalRqstBkgVO);
			eventResponse.setRsVoList(externalRqstBkgVO.getBkgXterQtyVO());//arrXml[6]
			
			 XterCustChkPntVO xterCustChkPntVO = command.searchXterCustChkPnt(event.getXterRqstNoVO());
			 eventResponse.setCustomData("xterCustChkPntVO", xterCustChkPntVO);
//			if(event.getBkgBlNoVO().getBkgNo().length()<11&&externalRqstBkgVO.getXterRqstMstVO().getBkgNo().length()>10){
//				event.getBkgBlNoVO().setBkgNo(externalRqstBkgVO.getXterRqstMstVO().getBkgNo());
//			}
			
			BookingCreationVO bookingCreationVO = null;
			if(event.getBkgBlNoVO().getBkgNo()!=null){
				bookingCreationVO = receiptBC.searchBooking(event.getBkgBlNoVO());
				
				// searchReference No.  
				GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();
				List<RefNoVO> refNoVOs = null; 
				BkgBlNoVO schBkgBlNoVO = new BkgBlNoVO();
				schBkgBlNoVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
				schBkgBlNoVO.setCaFlg("N");
				refNoVOs = searchBC.searchBkgReference(schBkgBlNoVO);				
				if (refNoVOs.size() > 0) {
					for (RefNoVO refNoVO : refNoVOs) {
						String bkgRefTpCd = refNoVO.getBkgRefTpCd();
						String custRefNoCtnt = refNoVO.getCustRefNoCtnt();
						if ("FINV".equals(bkgRefTpCd)) {
							eventResponse.setETCData("inv_ref_no",custRefNoCtnt);
						} else if ("EBRF".equals(bkgRefTpCd)) {
							eventResponse.setETCData("bkg_ref_no",custRefNoCtnt);
						} else if ("EBSH".equals(bkgRefTpCd)) {
							eventResponse.setETCData("bkg_sh_ref_no",custRefNoCtnt);
						} else if ("EBFF".equals(bkgRefTpCd)) {
							eventResponse.setETCData("bkg_ff_ref_no",custRefNoCtnt);
						} else if ("ESRF".equals(bkgRefTpCd)) {
							eventResponse.setETCData("si_ref_no",custRefNoCtnt);
						} else if ("ESSH".equals(bkgRefTpCd)) {
							eventResponse.setETCData("si_sh_ref_no",custRefNoCtnt);
						} else if ("ESFF".equals(bkgRefTpCd)) {
							eventResponse.setETCData("si_ff_ref_no",custRefNoCtnt);
						} else if ("RGBK".equals(bkgRefTpCd)) {
							eventResponse.setETCData("reg_bkg_no",custRefNoCtnt);
						} else if ("XMRN".equals(bkgRefTpCd)) {
							eventResponse.setETCData("ext_mrn_no",custRefNoCtnt);
						}
					}
				}
				
				// Documentation Requirement를 조회한다.
				List<DocRqstVO> docRqstList = blIssBC.searchDocRqst(event.getBkgBlNoVO().getBkgNo(), account.getOfc_cd());
				if(docRqstList.size() > 0) {
					eventResponse.setCustomData("DocRqst", docRqstList.get(0));
				}
			}
			
			// 결과적으로 해당 bkg의 data가 없는 경우
			if(bookingCreationVO == null){
				// 06. Default 셋팅
				BkgUsrDfltSetVO dfltVO = receiptBC.searchUserBkgDefault(account);

				eventResponse.setETCData("frt_term_cd",       "");
				eventResponse.setETCData("usa_cstms_file_cd", "");
				eventResponse.setETCData("cnd_cstms_file_cd", "");
				
				if(dfltVO != null){
					eventResponse.setETCData("rcv_term", 		dfltVO.getRcvTermCd());
					eventResponse.setETCData("de_term", 		dfltVO.getDeTermCd());
					eventResponse.setETCData("cntr_tpsz_cd", 	dfltVO.getCntrTpszCd());
					eventResponse.setETCData("wgt_ut_cd", 		dfltVO.getWgtUtCd());
					eventResponse.setETCData("auto_edi_hld_flg",dfltVO.getAutoEdiHldFlg());
				}else{
					eventResponse.setETCData("rcv_term", 		"");
					eventResponse.setETCData("dlv_term", 		"");
					eventResponse.setETCData("wgt_ut_cd", 		"");
					eventResponse.setETCData("cntr_tpsz_cd", 	"");
					eventResponse.setETCData("auto_edi_hld_flg","");
				}
				eventResponse.setETCData("DataYn", "N");
			} else {
				BkgBookingInfoVO bkgBookingInfoVO =  bookingCreationVO.getBkgBookingInfoVO();
				// 원 BL 번호
				String orgBlNo = "";
				if(bookingCreationVO.getSplitMstBlNoVO() != null){
					orgBlNo = bookingCreationVO.getSplitMstBlNoVO().getBlNo();
				}
				eventResponse.setETCData("OrgBlNo",orgBlNo);	
				
				eventResponse.setETCData(bookingCreationVO.getBkgBlNoVO().getColumnValues());	
				// Booking 정보
				eventResponse.setETCData(bkgBookingInfoVO.getColumnValues());	
				// Vsk 정보
				List<VslSkdVO> vslSkd = bookingCreationVO.getVslSkd();
				eventResponse.setRsVoList(vslSkd);//arrXml[7]	
				// Quantity 정보
				List<BkgQuantityVO> bkgQuantity = bookingCreationVO.getBkgQuantity();
				eventResponse.setRsVoList(bkgQuantity);//arrXml[8]
				// QtyDtl 정보
				List<BkgQtyDtlVO> bkgQtyDtl = bookingCreationVO.getBkgQtyDtl();
				eventResponse.setRsVoList(bkgQtyDtl);////arrXml[9]	
				
				// Customer정보
				BlCustomerInfoVO blCustomerInfoVO = bookingCreationVO.getBlCustomerInfoVO();
				if(blCustomerInfoVO != null){
					eventResponse.setETCData(blCustomerInfoVO.getColumnValues());	
				}		
				// Contact 정보
				eventResponse.setETCData("bkg_cntc_pson_nm", "");
				eventResponse.setETCData("bkg_cntc_pson_phn_no", "");	
				eventResponse.setETCData("bkg_cntc_pson_eml", "");	
				eventResponse.setETCData("bkg_cntc_pson_mphn_no", "");	
				eventResponse.setETCData("bkg_cntc_pson_fax_no", "");	
				eventResponse.setETCData("si_cntc_pson_nm", "");
				eventResponse.setETCData("si_cntc_pson_phn_no", "");	
				eventResponse.setETCData("si_cntc_pson_eml", "");	
				eventResponse.setETCData("si_cntc_pson_mphn_no", "");	
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
//				eventResponse.setETCData("filer_cd", bkgBookingInfoVO.getFilerCd());		
//				eventResponse.setETCData("vvd_flag", bkgBookingInfoVO.getVvdFlag());	
//				eventResponse.setETCData("rfa_available", bkgBookingInfoVO.getRfaAvailable());	
//				eventResponse.setETCData("sc_available", bkgBookingInfoVO.getScAvailable());	
//				eventResponse.setETCData("taa_available", bkgBookingInfoVO.getTaaAvailable());	
				
				// vl 여부
				if(!"Y".equals(bkgBookingInfoVO.getBdrFlg())){
					String mvmtStsCd[] = util.searchMVMTStatus(event.getBkgBlNoVO(), null);
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
				
//				ProductCatalogCreateBC prdBC   = new ProductCatalogCreateBCImpl();
//				EventResponse prdCnst = prdBC.searchPrdConstraint(bookingCreationVO.getBkgBookingInfoVO().getPctlNo());
//				 
//				if(prdCnst != null && prdCnst.getRsList().size() > 0){
//					eventResponse.setETCData("constraint_flag", "Y");
//				}else{
//					eventResponse.setETCData("constraint_flag", "N");
//				}
				
				//eBKG 쪽만 추가 조회하는 data -> bkgBookinfInfo에 포함으로 바뀜
//				String locNmStr = util.searchMdmLocName(bkgBookingInfoVO.getBkgPorCd()+"|"+bkgBookingInfoVO.getBkgPolCd()+"|"+bkgBookingInfoVO.getBkgPodCd()+"|"+bkgBookingInfoVO.getBkgDelCd());
//				String [] locNmArr = util.splitByToken(locNmStr, "|");
//
//				eventResponse.setETCData("por_nm", (locNmArr[0]==null)?"":locNmArr[0]);
//				eventResponse.setETCData("pol_nm", (locNmArr[1]==null)?"":locNmArr[1]);
//				eventResponse.setETCData("pod_nm", (locNmArr[2]==null)?"":locNmArr[2]);
//				eventResponse.setETCData("del_nm", (locNmArr[3]==null)?"":locNmArr[3]);
//				
				String vslNm = util.searchVslNm(bkgBookingInfoVO.getBkgTrunkVvd());
				eventResponse.setETCData("vsl_nm", (vslNm==null)?"":vslNm);
				
				String frtTermCd = util.searchFrtTerm(bkgBookingInfoVO.getBkgNo());
				eventResponse.setETCData("frt_term_cd",       frtTermCd);
				
				eventResponse.setETCData("DataYn", "Y");						
			}
			SIWebServiceVO sIWebServiceVO = new SIWebServiceVO();
			sIWebServiceVO.setXterSndrId(event.getXterRqstNoVO().getSenderId());
			sIWebServiceVO.setXterRqstNo(event.getXterRqstNoVO().getRqstNo());
			sIWebServiceVO.setXterRqstSeq(event.getXterRqstNoVO().getRqstSeq());
			sIWebServiceVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());			
			
			String chgModFlg = command.searchXterSIChgModFlg(sIWebServiceVO);
			
			if(chgModFlg!=null){
				if("Y".equals(chgModFlg)){
					eventResponse.setETCData("xterRateYn", "Y");	
				}
			}
			eventResponse.setETCData("DataYn", "Y");	
			
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0229_05 : OPEN
	 * EBookingReceipt의 CONTAINER MANIFEST 정보 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterCm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			BookingUtil utilCmd = new BookingUtil();
			
			EsmBkg022905Event event = (EsmBkg022905Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			ExternalRqstCmVO externalRqstCmVO = command.searchXterCm(event.getXterRqstNoVO());

			eventResponse.setRsVoList(externalRqstCmVO.getAlpsCmVO());
			eventResponse.setRsVoList(externalRqstCmVO.getBkgXterCntrMkDescVO());
			eventResponse.setRsVoList(externalRqstCmVO.getBkgDgCgoVOs());
			
			//wpm code list를 조회
			List<BkgComboVO> wpmCd = utilCmd.searchCombo("CD03478");
			eventResponse.setRsVoList(wpmCd);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0229_03 : OPEN
	 * EBookingReceipt의 CONTAINER TAB 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterCntr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EsmBkg022903Event event = (EsmBkg022903Event)e;
			EBookingReceiptBC eBkgBC = new EBookingReceiptBCImpl();

			BookingUtil comboUtil = new BookingUtil();
			List<BkgComboVO> seal_knd_cd  		= comboUtil.searchCombo("CD02184");
			List<BkgComboVO> seal_pty_tp_cd  	= comboUtil.searchCombo("CD02183");
			List<BkgComboVO> wgt_cd  			= comboUtil.searchCombo("CD00775");
			List<BkgComboVO> meas_cd  			= comboUtil.searchCombo("CD01116");
			List<BkgComboVO> rcv_term 			= comboUtil.searchCombo("CD00764");
			List<BkgComboVO> dlv_term  			= comboUtil.searchCombo("CD00765");
			//vgm code list를 조회
			List<BkgComboVO> vgm_mtd_cd 		= comboUtil.searchCombo("CD03491");
			
			List<BkgComboVO> list_rcv = new ArrayList<BkgComboVO>();
			List<BkgComboVO> list_de = new ArrayList<BkgComboVO>();
			
			for(int i=0;i<rcv_term.size();i++){
	            BkgComboVO vo = rcv_term.get(i);
	            if ( !vo.getVal().equals("M") ){
					BkgComboVO voRcv = new BkgComboVO();
					voRcv.setComboCd(vo.getComboCd());
					voRcv.setVal(vo.getVal());
					voRcv.setName(vo.getVal());
					voRcv.setDesc(vo.getDesc());
					list_rcv.add(voRcv);
	            }
	        }
			
			for(int i=0;i<dlv_term.size();i++){
	            BkgComboVO vo = dlv_term.get(i);
	            if ( !vo.getVal().equals("M") ){
					BkgComboVO voRcv = new BkgComboVO();
					voRcv.setComboCd(vo.getComboCd());
					voRcv.setVal(vo.getVal());
					voRcv.setName(vo.getVal());
					voRcv.setDesc(vo.getDesc());
					list_de.add(voRcv);
	            }
	        }
			eventResponse.setCustomData("seal_knd_cd", seal_knd_cd);
			eventResponse.setCustomData("seal_pty_tp_cd", seal_pty_tp_cd);
			eventResponse.setCustomData("wgt_cd", wgt_cd);
			eventResponse.setCustomData("meas_cd", meas_cd);
			eventResponse.setCustomData("vgm_mtd_cd", vgm_mtd_cd);
			
			eventResponse.setCustomData("rcv_term_cd", list_rcv);
			eventResponse.setCustomData("de_term_cd", list_de);
//			eventResponse.setRsVoList(rcv_term);
//			eventResponse.setRsVoList(dlv_term);
			
			ExternalRqstCntrVO xterRqstCnrtVO = eBkgBC.searchXterCntr(event.getXterRqstNoVO());
			eventResponse.setCustomData("externalRqstCntrVO", xterRqstCnrtVO);

			String bkgNo = null;
			if(event.getBkgBlNoVO()==null){
				bkgNo = event.getXterRqstNoVO().getBkgNo();
			} else {
				bkgNo = event.getBkgBlNoVO().getBkgNo();
			}
			
			if(bkgNo!=null){
				BLDocumentationCMBC blCmBC = new BLDocumentationCMBCImpl();
				CntrInfoOutVO bkgCntrVO = blCmBC.searchContainer(bkgNo, "N");
				if(bkgCntrVO!=null){
					//to form
					eventResponse.setCustomData("bkgCntrVO", bkgCntrVO);
					//to grid
					eventResponse.setRsVoList(bkgCntrVO.getCntrs());
					eventResponse.setRsVoList(bkgCntrVO.getCntrSealNos());
					eventResponse.setETCData("fnl_cfm_flg", bkgCntrVO.getCntrEtcInfo().getFnlCfmFlg());
					eventResponse.setETCData("evnt_usr_id", bkgCntrVO.getCntrEtcInfo().getEvntUsrId());
					eventResponse.setETCData("evnt_dt", bkgCntrVO.getCntrEtcInfo().getEvntDt());
//					eventResponse.setRsVoList(externalRqstCnrtVO.getAlpsCntrVO());
//					eventResponse.setRsVoList(externalRqstCnrtVO.getBkgCntrSealNoVO());
				}
//				eventResponse.setRsVoList(bkgCntrVO.getCntrs());
//				eventResponse.setRsVoList(bkgCntrVO.getCntrSealNos());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0229_02 : OPEN
	 * EBookingReceipt의 CUSTOMER TAB 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterCust(Event e) throws EventException {
		EsmBkg022902Event event = (EsmBkg022902Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {			
			EBookingReceiptBC 		command 	= new EBookingReceiptBCImpl();			
			BookingUtil 			comboUtil 	= new BookingUtil();

			// KOREA CUSTOMS CUSTOMER TYPE CODE
			List<BkgComboVO> tp_cd  = comboUtil.searchCombo("CD02125");	
			eventResponse.setRsVoList(tp_cd);
			//eBKG
			ExternalRqstCustVO externalRqstCustVO = command.searchXterCust(event.getXterRqstNoVO());			
			eventResponse.setCustomData("externalRqstCustVO", externalRqstCustVO);

			//BKG
//			event.getBkgBlNoVO().setBkgNo(event.getXterRqstNoVO().getBkgNo());
			BkgBlNoVO bkgBlNoVO = null;
			if(event.getBkgBlNoVO()==null){
				bkgBlNoVO = new BkgBlNoVO();
				bkgBlNoVO.setBkgNo(event.getXterRqstNoVO().getBkgNo());
			} else {
				bkgBlNoVO = event.getBkgBlNoVO();
			}			
			
			if(bkgBlNoVO!=null){
				GeneralBookingReceiptBC receiptBC 	= new GeneralBookingReceiptBCImpl();
				
				BlCustomerVO blCustomerVO = null;
				blCustomerVO = receiptBC.searchBlDocCust(bkgBlNoVO);
				
				if(blCustomerVO!=null){				
					if(blCustomerVO.getBlDocCustVO() != null)
						eventResponse.setETCData(blCustomerVO.getBlDocCustVO().getColumnValues());
					if(blCustomerVO.getCustEtcVO() != null)
						eventResponse.setETCData(blCustomerVO.getCustEtcVO().getColumnValues());
				}
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0229_08 : OPEN
	 * EBookingReceipt의 DANGER CARGO 정보 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterDg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EsmBkg022908Event event = (EsmBkg022908Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			BookingUtil util = new BookingUtil();
			
			ExternalRqstDgVO externalRqstDgVO = command.searchXterDg(event.getXterRqstNoVO());

			List<AlpsCntrTpszVO> cntrTpsz  = externalRqstDgVO.getAlpsCntrTpszVO();
			eventResponse.setCustomData("cntr_tpsz", cntrTpsz);

			eventResponse.setCustomData("externalRqstDgVO", externalRqstDgVO);
			eventResponse.setRsVoList(externalRqstDgVO.getNisDgVO());
			eventResponse.setRsVoList(externalRqstDgVO.getBkgXterDgCgoVO());
			
			//D/G Rider 조회
			// Alps dg rider 
			List<XterDgRiderVO> alpsDgRiderVOs = command.searchAlpsDgRiderList(event.getXterRqstNoVO());
			eventResponse.setRsVoList(alpsDgRiderVOs);
			String alpsCheckBoxString = command.searchAlpsDgRiderCntrList(event.getXterRqstNoVO());
			eventResponse.setETCData("alpsCheckBoxString", alpsCheckBoxString);
			
			// e-svc dg rider
			List<XterDgRiderVO> xterBlRiderVOs = command.searchXterDgRiderList(event.getXterRqstNoVO());
			eventResponse.setRsVoList(xterBlRiderVOs);
			String checkBoxString = command.searchXterDgRiderCntrList(event.getXterRqstNoVO());
			eventResponse.setETCData("xterCheckBoxString", checkBoxString);
			
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("EBKG_DG_SEQ");			
			List<BkgHrdCdgCtntVO> dgSeq = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
			
			if(dgSeq != null && dgSeq.get(0).getAttrCtnt1().equals("ON")){
				eventResponse.setETCData("EBKG_DG_SEQ", "ON");	
			} else {
				eventResponse.setETCData("EBKG_DG_SEQ", "OFF");
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0229_10 : OPEN
	 * EBookingReceipt의 HOUSE B/L 정보 조회br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterHbl1(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EsmBkg022910Event event = (EsmBkg022910Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			BookingUtil util = new BookingUtil();

			List<BkgComboVO> wgt_cd  = util.searchCombo("CD00775");
			List<BkgComboVO> meas_cd  = util.searchCombo("CD01116");
			eventResponse.setRsVoList(wgt_cd);			//arrXml[0]
			eventResponse.setRsVoList(meas_cd);			//arrXml[1]			
			
			ExternalRqstHbl1VO externalRqstHbl1VO = command.searchXterHbl1(event.getXterRqstNoVO());

			eventResponse.setRsVoList(externalRqstHbl1VO.getNisHbl1VO());
			eventResponse.setRsVoList(externalRqstHbl1VO.getXterHbl1VO());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0229_11 : OPEN
	 * EBookingReceipt의 HOUSE B/L의 NVOCC NO 정보 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterHbl2(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EsmBkg022911Event event = (EsmBkg022911Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			ExternalRqstHbl2VO externalRqstHbl2VO = command.searchXterHbl2(event.getXterRqstNoVO());

			eventResponse.setRsVoList(externalRqstHbl2VO.getBkgUsaCstmsFileNoVO());
			eventResponse.setRsVoList(externalRqstHbl2VO.getXterUsaCstmsFileNoVO());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_BKG_0229_04 : OPEN
	 * EBookingReceipt의MARK & DESCRIPTION TAB 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterMnd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			EsmBkg022904Event event = (EsmBkg022904Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			BLDocumentationBLBC blBC = new BLDocumentationBLBCImpl();
			BLDocumentationCMBC docCmd = new BLDocumentationCMBCImpl();
			GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
			BookingUtil comboUtil = new BookingUtil();
			
			List<BkgComboVO> wgt_cd  = comboUtil.searchCombo("CD00775");
			List<BkgComboVO> meas_cd  = comboUtil.searchCombo("CD01116");
			List<BkgComboVO> aes_exception  = comboUtil.searchCombo("CD02570");
			eventResponse.setCustomData("wgt_cd", wgt_cd);
			eventResponse.setCustomData("meas_cd", meas_cd);
			
			ExternalRqstMndVO externalRqstMndVO = command.searchXterMnd(event.getXterRqstNoVO(), account.getOfc_cd());
			
			//E-SVC EXPORT LICENSE NUMBER
			eventResponse.setRsVoList(externalRqstMndVO.getKrXptLicNoVOs());
			
			//E-SVC P/O NO
			eventResponse.setRsVoList(externalRqstMndVO.getXterCntrPoNoVOs());
			eventResponse.setCustomData("xterCntrPoNoVOsCnt", externalRqstMndVO.getXterCntrPoNoVOs().size());
			eventResponse.setRsVoList(externalRqstMndVO.getXterPoDtlVOs());
			eventResponse.setCustomData("xterPoDtlVOsCnt", externalRqstMndVO.getXterPoDtlVOs().size());
			
			//CHM-201433292 e-BKg & SI Upload화면 > M&D tap > Ship ID항목 추가	
			eventResponse.setRsVoList(externalRqstMndVO.getXterRefDtlVOs());
			eventResponse.setCustomData("xterRefDtlVOsCnt", externalRqstMndVO.getXterRefDtlVOs().size());
			
			List<XterInnerPackageVO> xterInnerPackageVOs = command.searchXterInnerPackage(event.getXterRqstNoVO());
//			eventResponse.setCustomData("innerPackage", xterInnerPackageVOs);			
			eventResponse.setRsVoList(xterInnerPackageVOs);
			eventResponse.setCustomData("xterInnerPackageVOsCnt", xterInnerPackageVOs.size());
			BkgBlNoVO bkgBlNoVO = null;
			if(event.getBkgBlNoVO()==null){
				bkgBlNoVO = new BkgBlNoVO();
				bkgBlNoVO.setBkgNo(event.getXterRqstNoVO().getBkgNo());
			} else {
				bkgBlNoVO = event.getBkgBlNoVO();
			}
			
			if(bkgBlNoVO.getBkgNo()!=null){
				MndVO mndVO = blBC.searchMnd(bkgBlNoVO);
				
				
				BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
				bkgHrdCdgCtntListCondVO.setHrdCdgId("BKG_VALIDATION");	
				bkgHrdCdgCtntListCondVO.setAttrCtnt1("AUTO_CLAUSE_CHK");
				List<BkgHrdCdgCtntVO> BkgHrdCdgCtntVOs = comboUtil.searchHardCoding(bkgHrdCdgCtntListCondVO);
				
				
				if("ON".equals(BkgHrdCdgCtntVOs.get(0).getAttrCtnt2())){
		            String porCd = mndVO.getPorCd();
		            String polCd = mndVO.getPolCd();
		            String podCd = mndVO.getPodCd();
		            String delCd = mndVO.getDelCd();
		            String bkgNo = mndVO.getBkgNo();
		            String caFlg = bkgBlNoVO.getCaFlg();
		            
		            String cmdtDesc = externalRqstMndVO.getXterMndVO().get(0).getCmdtDesc();
		            XterMndVO xterMndVO = externalRqstMndVO.getXterMndVO().get(0);
		           
		            
		            //2012.10.25  Booking 의 DEL이 BR 인 경우 B/L 자동 문구 추가
		            if(delCd !=null && delCd.length()> 2 && "BR".equals(delCd.substring(0, 2))){
		            	cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_BR_WEB, "");
		            }
		            
		            if((polCd !=null && polCd.length()> 2 && "BR".equals(polCd.substring(0, 2))) ||
		                    (podCd !=null && podCd.length()> 2 && "BR".equals(podCd.substring(0, 2)))){

		            		String desc = docCmd.searchWpmDescForBl(bkgBlNoVO, "N");
		            		cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace(desc, "");
		            }
		            //2012.10.25  Booking 의 POD이 UY,AR 인 경우 B/L 자동 문구 추가
		            if(podCd !=null && podCd.length()> 2 && ("UY".equals(podCd.substring(0, 2)) || "AR".equals(podCd.substring(0, 2)))){
		            	cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_UY, "");
		            }
		            if((porCd !=null && porCd.length()> 2 && "MX".equals(porCd.substring(0, 2))) ||
		               (polCd !=null && polCd.length()> 2 && "MX".equals(polCd.substring(0, 2))) ||
		               (podCd !=null && podCd.length()> 2 && "MX".equals(podCd.substring(0, 2))) ||
		               (delCd !=null && delCd.length()> 2 && "MX".equals(delCd.substring(0, 2)))){
		            	cmdtDesc  = (cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_MX, "");
		            }
		            if((delCd !=null && !"GTPRQ".equals(delCd.substring(0, 2))) &&
		               (porCd !=null && porCd.length()> 2 && "GT".equals(porCd.substring(0, 2))) ||
		               (polCd !=null && polCd.length()> 2 && "GT".equals(polCd.substring(0, 2))) ||
		               (podCd !=null && podCd.length()> 2 && "GT".equals(podCd.substring(0, 2))) ||
		               (delCd !=null && delCd.length()> 2 && "GT".equals(delCd.substring(0, 2)))){
		            	cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_GT, "");
		            }
		            if((podCd !=null && podCd.length()> 2 && "GR".equals(podCd.substring(0,2))) ||
		               (delCd !=null && delCd.length()> 2 && "GR".equals(delCd.substring(0,2)))){
		            	cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_GR_WEB, "");
	
		            }
		            if((podCd !=null && podCd.length()> 2 && "EG".equals(podCd.substring(0,2))) ||
		               (delCd !=null && delCd.length()> 2 && "EG".equals(delCd.substring(0,2)))){
		            	cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_EG_WEB, "");
	
		            		
		            }
		            if((podCd !=null && podCd.length()> 2 && "SA".equals(podCd.substring(0,2))) ||
		                    (delCd !=null && delCd.length()> 2 && "SA".equals(delCd.substring(0,2)))){
		            	cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_SA, "");
	
		            }
		            
		            if((podCd !=null && podCd.length()> 2 && "IRBND".equals(podCd)) ||
		                    (delCd !=null && delCd.length()> 2 && "IRBND".equals(delCd))){
		            	cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_IRBND, "").replace(Constants.CMDT_DESC_IRBND_WEB, "");
					}
		            
		            /* POD 가 JOAQJ 일 경우  Tariff 항목 추가 Reefer cargo free time 은 6일 로 변경 */
		            if((podCd !=null && "JOAQJ".equals(podCd))){
		            	cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_JOAQJ_CONSOL_CARGO_WEB, "").replace(Constants.CMDT_DESC_ATTD_JOAQJ, "");
	
		            }
		            
		            /* POD 가 KHPNH 일 경우(Last POL:VNSGN (Y2) -> Last POD:KNPNH(Y4))  Tariff 항목 추가 */
		            List<VslSkdVO> routeDetails = blBC.searchVvdSkdForTsRouteKNPNH(bkgNo, caFlg);
		            if(routeDetails != null && routeDetails.size() > 0){
						if(routeDetails.get(routeDetails.size() - 1).getPolCd().equals(Constants.BL_CLAUSE_POL)
								&& routeDetails.get(routeDetails.size() - 1).getPodCd().equals(Constants.BL_CLAUSE_POD)){	            
							cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_KHPNH, "");
			            }
		            }
		            
		            String syFlg = blBC.searchMndTsSyFlg(mndVO.getBkgNo());
		            /* POD , DEL 의 국가코드가 SY 일 경우  Tariff 항목 추가 */
		            if ((podCd !=null && podCd.length() >= 2 && "SY".equals(podCd.substring(0,2)))||
		                    (delCd !=null && delCd.length() >= 2 && "SY".equals(delCd.substring(0,2)))||
		                    (podCd !=null && podCd.length() >= 2 &&  "Y".equals(syFlg))){
		            	cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_SY, "");
		                 }
		            
		            // POD 또는 DEL의 국가코드가 DZ 일 경우 Tariff 강제 적용, POR, POL의 국가 코드가 US 일 경우는 에외
		            //2015.03.18 US일 경우 auto-clause추가
		            if((podCd !=null && podCd.length()> 2 && "DZ".equals(podCd.substring(0,2))) ||
		                    (delCd !=null && delCd.length()> 2 && "DZ".equals(delCd.substring(0,2)))){
		            	if((porCd !=null && porCd.length()> 2 && "US".equals(porCd.substring(0,2))) ||
		                        (polCd !=null && polCd.length()> 2 && "US".equals(polCd.substring(0,2)))){	
		            		cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_US_DZ, "");  
		            	}else{
		            		cmdtDesc = (cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_DZ_DRY, "").replace(Constants.CMDT_DESC_ATTD_DZ_SPCL, "").replace(Constants.CMDT_DESC_ATTD_DZ, "");
		            	}
		            }
		            xterMndVO.setCmdtDesc(cmdtDesc);
		            externalRqstMndVO.getXterMndVO().set(0, xterMndVO);
				}
				eventResponse.setCustomData("MndVO", mndVO);
				//ALPS EXPORT LICENSE NUMBER
				eventResponse.setRsVoList(externalRqstMndVO.getAlpsXptImpLicListVOs());

				//e-SVC P/O NO
				PoOtherNoVO rPoOtherNoVO = receiptBC.searchPoOtherNoByXter(bkgBlNoVO);
				
				List<PoOtherNoBkgVO> rlistNoBkgVOs = rPoOtherNoVO.getO_poOtherNoBkgVOs();
				List<PoOtherCntrVO> rlistCntrVOs = rPoOtherNoVO.getO_poOtherCntrVOs();
				List<PoOtherCmVO> rlistCmVOs = rPoOtherNoVO.getO_poOtherCmVOs();
				//CHM-201433292 e-BKg & SI Upload화면 > M&D tap > Ship ID항목 추가	
				List<PoOtherShipVO> rlistShipVos = rPoOtherNoVO.getO_poOtherShipVOs();
				
				eventResponse.setRsVoList(rlistNoBkgVOs);
				eventResponse.setRsVoList(rlistCntrVOs);
				eventResponse.setRsVoList(rlistCmVOs);
				eventResponse.setRsVoList(rlistShipVos);
			}

			eventResponse.setCustomData("externalRqstMndVO", externalRqstMndVO);
			eventResponse.setRsVoList(aes_exception);
			
			//2012.2.13 B/L Rider 
			List<BlRiderVO> bkgBlRiderVOs = command.searchBkgImgSto(bkgBlNoVO);
			eventResponse.setRsVoList(bkgBlRiderVOs);
			
			List<BlRiderVO> blRiderVOs = command.searchXterImgSto(event.getXterRqstNoVO());
			eventResponse.setRsVoList(blRiderVOs);
			eventResponse.setCustomData("xterRqstNoVOsCnt", blRiderVOs.size());
			
			//2013.5.16 ALPS Surcharge
			List<KrWhfBlExptInfoVO> krWhfBlExptInfoVOs = command.searchKrWhfBlExptInfo(bkgBlNoVO);
			eventResponse.setRsVoList(krWhfBlExptInfoVOs);
			//2013.5.16 e-svc Surcharge
			List<KrWhfBlExptInfoVO> xterKrWhfBlExptInfoVOs = command.searchXterKrWhfBlExptInfo(event.getXterRqstNoVO());
			eventResponse.setRsVoList(xterKrWhfBlExptInfoVOs);
			eventResponse.setCustomData("xterKrWhfBlExptInfoVOsCnt", xterKrWhfBlExptInfoVOs.size());

			//alps Indonesia peb no
			XptImpLicInVO xptImpLicInVO = new XptImpLicInVO();
			xptImpLicInVO.setBkgNo(event.getXterRqstNoVO().getBkgNo());
			xptImpLicInVO.setIoBndCd("O");
			xptImpLicInVO.setCntCd("ID");
			eventResponse.setRsVoList(blBC.searchExportImportNumber(xptImpLicInVO, "ID"));
			
			//e-svc Indonesia peb no
			eventResponse.setRsVoList(externalRqstMndVO.getIdXptLicNoVOs());
			
			List<BkgClauseLockVO> bkgClauseLockVOs = receiptBC.searchBkgClauseLock(bkgBlNoVO.getBkgNo(),"D");
			eventResponse.setRsVoList(bkgClauseLockVOs);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0229_07 : OPEN
	 * EBookingReceipt의 REEFER CARGO 정보 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterRf(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EsmBkg022907Event event = (EsmBkg022907Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			ExternalRqstRfVO externalRqstRfVO = command.searchXterRf(event.getXterRqstNoVO());

			List<AlpsCntrTpszVO> cntrTpsz  = externalRqstRfVO.getAlpsCntrTpszVO();
			eventResponse.setCustomData("cntr_tpsz", cntrTpsz);

			eventResponse.setCustomData("externalRqstRfVO", externalRqstRfVO);
			eventResponse.setRsVoList(externalRqstRfVO.getNisRfVO());
			eventResponse.setRsVoList(externalRqstRfVO.getBkgXterRfCgoVO());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0228 : RETREVE 클릭
	 * EBKG/SI 요청 LIST 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterRqstList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg0228Event event = (EsmBkg0228Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			List<BkgXterSrchSetVO> searchSetList = null;
			StringBuffer qryWhere = new StringBuffer();

			if ("Y".equals(event.getXterRqstListInputVO().getSetSlctFlg())) {
				searchSetList = command.searchXterSrchSetForList(account.getUsr_id());
				for (int i=0;i<searchSetList.size();i++) {
					BkgXterSrchSetVO bkgXterSrchSetVO = new BkgXterSrchSetVO();
					bkgXterSrchSetVO = searchSetList.get(i);
					qryWhere.append(bkgXterSrchSetVO.getCustNm() + " \n");
				}
				event.getXterRqstListInputVO().setSetQryWhere(qryWhere.toString());
				log.debug(">>> WHERE SQL:"+event.getXterRqstListInputVO().getSetQryWhere());
			} else event.getXterRqstListInputVO().setSetQryWhere("");

			ExternalRqstListInputVO externalRqstListInputTmpVO = event.getXterRqstListInputVO();
			ExternalRqstListInputVO externalRqstListInputVO = new ExternalRqstListInputVO();
			if ( !isNull(externalRqstListInputTmpVO.getXterRqstNo()) || !isNull(externalRqstListInputTmpVO.getBkgNo()) ) {
				externalRqstListInputVO.setXterRqstNo(externalRqstListInputTmpVO.getXterRqstNo());
				externalRqstListInputVO.setBkgNo(externalRqstListInputTmpVO.getBkgNo());
				externalRqstListInputVO.setInttraRtv(externalRqstListInputTmpVO.getInttraRtv());
			} else externalRqstListInputVO = externalRqstListInputTmpVO;

			List<ExternalRqstListVO> list = command.searchXterRqstList(externalRqstListInputVO);

			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0229_06 : OPEN
	 * EBookingReceipt의 TRO 정보 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterTro(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EsmBkg022906Event event = (EsmBkg022906Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			ExternalRqstTroVO externalRqstTroVO = command.searchXterTro(event.getXterRqstNoVO());

			eventResponse.setRsVoList(externalRqstTroVO.getNisTroDtlVO());
			eventResponse.setRsVoList(externalRqstTroVO.getBkgXterTroDtlVO());
			eventResponse.setRsVoList(externalRqstTroVO.getNisTroMstVO());
			eventResponse.setRsVoList(externalRqstTroVO.getBkgXterTroVO());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
		
	/**
	 * eBKG , eSI 수신 후 Upload 시 에러 발생 시 에러 발생한 경우 에러 정보 발송<br>
	 *
	 * @param String flatFileStr
	 * @param Exception ex
	 * @exception EventException
	 */
	private void sendErrLogMail(String flatFileStr, Exception ex) {
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		try{
			begin();
			command.sendErrLogMail(ex.getCause().toString(), flatFileStr);
			commit();
		} catch(Exception ec){
			rollback();
			log.error(ec.getMessage()); // 2011.07.14
		}
	}

	/**
	 * ESM_BKG_0902 : OK CLICK
	 * EBkg을 reject 했을 때 EDI를 전송한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendXterRqstRejectEdi(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0902Event event = (EsmBkg0902Event)e;
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		try{
			begin();
			log.debug("getEmlSndYn:"+event.getEmlSndYn());
			if ( "Y".equals(event.getEmlSndYn()) ) {
				command.sendXterRqstRejectEmail(event.getXterRqstNoVO().getBkgNo(), event.getUsrEml(), event.getCntcEml(), event.getRjctRsnRmk(), account);
			}
			command.createXterRqstRejectEdi(event.getRjctRsnRmk(), event.getXterRjctRsnCd(), event.getXterRqstNoVO(), account);
			eventResponse.setETCData("SuccessYn", "Y");
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0902 : OK CLICK
	 * EBkg을 pending 했을 때 EDI를 전송한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendXterRqstPendingNotice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0902Event event = (EsmBkg0902Event)e;
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
		
		try{
			command.sendXterRqstPendingNotice(event.getXterRqstNoVO(), event.getEmlSndYn(), 
					event.getUsrEml(), event.getCntcEml(), event.getXterRjctRsnCd(), event.getRjctRsnRmk(), account);

			BookingUtil util = new BookingUtil();
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(event.getXterRqstNoVO().getBkgNo());
			bkgBlNoVO = util.searchBkgBlNoVO(bkgBlNoVO);
			if(bkgBlNoVO != null){
				// 03. BookingHistoryMgtBC의 createBkgHistoryLine 호출
				HistoryLineVO historyLineVO = new HistoryLineVO();
				historyLineVO.setBkgNo(event.getXterRqstNoVO().getBkgNo());
				historyLineVO.setCaFlg("N");
				historyLineVO.setBkgDocProcTpCd("");
				historyLineVO.setUiId("ESM_BKG_0228");
				if(event.getXterRqstNoVO().getDocTpCd().equals("B")){
					historyLineVO.setCrntCtnt("e-BKG Pending.");
					historyLineVO.setHisCateNm("e-BKG Pending.");
				} else {
					historyLineVO.setCrntCtnt("e-SI Pending.");
					historyLineVO.setHisCateNm("e-SI Pending.");
				}				
				historyBC.createBkgHistoryLine(historyLineVO, account);	
			}
			
			eventResponse.setETCData("SuccessYn", "Y");
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0229 : UPLOAD 클릭
	 * BKG_XTER_RQST_MST 정보를 ALPS로 업로드 (전체 TAB Upload)<br>
	 * Route 정보가 있는 경우<br>
	 * EBookingReceipt의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse uploadXterRqst(Event e) throws EventException {		
		GeneralEventResponse eventResponse 	= new GeneralEventResponse();
		EsmBkg0229Event 	 event 			= (EsmBkg0229Event)e;
				
		try{
			String uiId = "ESM_BKG_0229";
        	GeneralBookingReceiptBC receiptBC  	= new GeneralBookingReceiptBCImpl();
			EBookingReceiptBC 		eBkgBC 		= new EBookingReceiptBCImpl();
			GeneralBookingSearchBC  searchBC	= new GeneralBookingSearchBCImpl();
			BlRatingBC				rateBC		= new BlRatingBCImpl();
			BookingHistoryMgtBC 	historyBC	= new BookingHistoryMgtBCImpl();
			PerformanceReportBC     reportBC    = new PerformanceReportBCImpl();
        	BookingUtil             util      	= new BookingUtil();
        	TransferOrderIssueBC    troBC    = new TransferOrderIssueBCImpl();
        	
			BkgCopManageBC 			copBC 		= new BkgCopManageBCImpl();
			
			BLIssuanceBC            blIssBC    	= new BLIssuanceBCImpl();
						
			BkgBlNoVO bkgBlNoVO = event.getBkgBlNoVO();
			XterRqstNoVO rqstVO = event.getXterRqstNoVO();
			String bkgNo = "";
			String blNo = "";
			String saveModeCd = "";
			HistoryTableVO historyTableVO = null;
			BlIssInfoVO blIssInfoVO = null;
			
			String replanFlg = "Y";
			String changeVvdFlag = "N";	
			String codFlg = "N";
			String ofcChgFlag = "N"; // PPD & CCT office 에 영향있는 값이 변경되었는지 여부 
			String mrdNm = null;
			String sType = null;
			String sLevel = null;
			String sMrd = null;
			StringBuilder sbParam = null;
			String alocEmailStsFlg = "N";
			String dgKeyFlg = "N";
			String dgKeyFlg2 = "N";
			String siContactUsrNm = null;
			String siContactEmail = null;
			//String oldAlocStsCd = event.getEsmBkg022901Event().getBkgBookingInfoVO().getAlocStsCd();
			
			sbParam = new StringBuilder();
			
			DblWblVO[] dblWblVOs = null;
			BLIssuanceBC bLIssuanceBC = new BLIssuanceBCImpl();
			
			List<BkgNtcHisVO> bkgNtcHisVOs = null;
			List<BkgNtcHisVO> bkgNtcHisSysVOs = new ArrayList<BkgNtcHisVO>();
			List<HistoryLineVO> historyLineVOs = null;
//			OfcChgProcVO ofcChgProcVO = null;
			
			begin();
			
			// BKG Black List 체크
			
			String blackList = eBkgBC.checkBkgBlackList(event.getXterRqstNoVO());
			
			if(blackList != null && !"".equals(blackList)){
				commit();
				return eventResponse;
			}
						
						
			String xterBkgSts;
			xterBkgSts = eBkgBC.searchXterBkgSts(event.getXterRqstNoVO());
			if(!"N".equals(xterBkgSts) && !"P".equals(xterBkgSts) && !"H".equals(xterBkgSts) && !"U".equals(xterBkgSts)){				
				eventResponse.setETCData("xterBkgSts", "Y");
				return eventResponse;
			}
			
			if (event.getEsmBkg022901Event() == null) {
				//절대 있어서는 안되는 case임
				throw new EventException(new ErrorHandler("BKG00391").getMessage()); 				
			} else {
				if (event.getEsmBkg022901Event().getFormCommand().isCommand(FormCommand.MULTI01)
						||event.getEsmBkg022901Event().getFormCommand().isCommand(FormCommand.MULTI02)) {
					saveModeCd = "C";
				} else if (event.getEsmBkg022901Event().getFormCommand().isCommand(FormCommand.MULTI03)
						||event.getEsmBkg022901Event().getFormCommand().isCommand(FormCommand.MULTI04)) {
					saveModeCd = "U";
				}
				if("Y".equals(event.getEsmBkg022901Event().getBkgBookingInfoVO().getWebSvcFlg())){
					uiId = "IF_ESM_BKG_0009";
				}
			}
			
			//create booking
			if("C".equals(saveModeCd)){
				
				//2014.11.03 최도순[CHM-201432379] 미주 E-BKG HANDLING OFFICE 지정로직 Prefix 로 BKG NO 채번
				String polCd = event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgPolCd();
				String cmdtNm = event.getEsmBkg022901Event().getBkgBookingInfoVO().getCmdtDesc();
				String bkgOfcCd = null;
				
				if(bkgBlNoVO.getBkgNo()==null || bkgBlNoVO.getBkgNo().length() < 11){
					if(polCd != null){
						if("US".equals(polCd.substring(0,2))||"CA".equals(polCd.substring(0,2))){
							
							bkgOfcCd = eBkgBC.searchUsHandlingOfc(polCd, cmdtNm);
							
							log.debug("bkgOfcCd=================================================================================="+bkgOfcCd);
							
							if(bkgOfcCd!=null&&!"".equals(bkgOfcCd)){
								BkgBlNoVO bkgBlNoVO2 = util.manageBkgNumberGeneration("BKG", bkgOfcCd, "SYSTEM");
								bkgNo = bkgBlNoVO2.getBkgNo() + "00";
								
								event.getEsmBkg022901Event().getBkgBlNoVO().setBkgNo(bkgNo);	
							}
						}
					}
				}
				
				log.debug("bkgNo=================================================================================="+bkgNo);
				
				
				if (event.getEsmBkg022901Event().getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = (GeneralEventResponse)createBkgWithoutRouteByXter(event.getEsmBkg022901Event());
				} else if (event.getEsmBkg022901Event().getFormCommand().isCommand(FormCommand.MULTI02)) {
					eventResponse = (GeneralEventResponse)createBkgWithRouteByXter(event.getEsmBkg022901Event());
				}		
				bkgNo = eventResponse.getETCData("bkg_no");
				blNo = eventResponse.getETCData("bl_no");
				bkgBlNoVO.setBkgNo(bkgNo);
				bkgBlNoVO.setBlNo(blNo);	
				//eBkg을 통해 Bkg No가 생성된 경우 그 정보를 BKG_XTER_RQST_MST에 업데이트함
				rqstVO.setBkgNo(bkgNo);
//				eBkgBC.modifyXterBkgNo(rqstVO, account);	
				//022902에 필요한 flag 를 customer update 전에 구한다.
//				if (event.getEsmBkg022902Event() != null) {
//					ofcChgProcVO = new OfcChgProcVO();
//					ofcChgProcVO.setType("C");  //customer
//					ofcChgProcVO.setCaFlg(bkgBlNoVO.getCaFlg());
//					ofcChgProcVO.setBkgNo(bkgNo);
//					ofcChgProcVO.setCustToOrdFlg(event.getEsmBkg022902Event().getCustEtcVO().getCustToOrdFlg());
//					ofcChgProcVO.setShCustCntCd(event.getEsmBkg022902Event().getBlDocCustVO().getShCustCntCd());
//					ofcChgProcVO.setShCustSeq(event.getEsmBkg022902Event().getBlDocCustVO().getShCustSeq());
//					ofcChgProcVO.setCnCustCntCd(event.getEsmBkg022902Event().getBlDocCustVO().getCnCustCntCd());
//					ofcChgProcVO.setCnCustSeq(event.getEsmBkg022902Event().getBlDocCustVO().getCnCustSeq());
//					ofcChgProcVO.setNfCustCntCd(event.getEsmBkg022902Event().getBlDocCustVO().getNfCustCntCd());
//					ofcChgProcVO.setNfCustSeq(event.getEsmBkg022902Event().getBlDocCustVO().getNfCustSeq());
//					ofcChgProcVO = util.searchOfcChgProc(ofcChgProcVO);
//				}
				changeVvdFlag = "Y";
				event.getEsmBkg022901Event().getBookingSaveValidationVO().setChangeVvd("Y");
			} else { // update booking
				bkgNo = bkgBlNoVO.getBkgNo();
				EsmBkg022901Event esmBkg022901Event = event.getEsmBkg022901Event();
				BkgBookingInfoVO bkgBookingInfoVO = event.getEsmBkg022901Event().getBkgBookingInfoVO();
				bkgBlNoVO.setBdrFlg(event.getEsmBkg022901Event().getBdrFlg());
				if("Y".equals(bkgBlNoVO.getBdrFlg())){
					bkgBlNoVO.setCaFlg("Y");
					bkgBookingInfoVO.setCaFlg("Y");
				} else {
					bkgBlNoVO.setCaFlg("N");
					bkgBookingInfoVO.setCaFlg("N");
				}

				//022902에 필요한 flag 를 customer update 전에 구한다.
//				if (event.getEsmBkg022902Event() != null) {
//					ofcChgProcVO = new OfcChgProcVO();
//					ofcChgProcVO.setType("C");  //customer
//					ofcChgProcVO.setCaFlg(bkgBlNoVO.getCaFlg());
//					ofcChgProcVO.setBkgNo(bkgNo);
//					ofcChgProcVO.setCustToOrdFlg(event.getEsmBkg022902Event().getCustEtcVO().getCustToOrdFlg());
//					ofcChgProcVO.setShCustCntCd(event.getEsmBkg022902Event().getBlDocCustVO().getShCustCntCd());
//					ofcChgProcVO.setShCustSeq(event.getEsmBkg022902Event().getBlDocCustVO().getShCustSeq());
//					ofcChgProcVO.setCnCustCntCd(event.getEsmBkg022902Event().getBlDocCustVO().getCnCustCntCd());
//					ofcChgProcVO.setCnCustSeq(event.getEsmBkg022902Event().getBlDocCustVO().getCnCustSeq());
//					ofcChgProcVO.setNfCustCntCd(event.getEsmBkg022902Event().getBlDocCustVO().getNfCustCntCd());
//					ofcChgProcVO.setNfCustSeq(event.getEsmBkg022902Event().getBlDocCustVO().getNfCustSeq());
//					ofcChgProcVO = util.searchOfcChgProc(ofcChgProcVO);
//				}

				// b/l issue 됐으면 [BKG02019]를 보여주고 중지한다.
				eBkgBC.searchBlIss(rqstVO, account);
				
				historyTableVO = historyBC.searchOldBkgForHistory(uiId, bkgBlNoVO);
				esmBkg022901Event.setBkgBookingInfoVO(bkgBookingInfoVO);
				event.setEsmBkg022901Event(esmBkg022901Event);
				if (event.getEsmBkg022901Event().getFormCommand().isCommand(FormCommand.MULTI03)) {
					eventResponse = (GeneralEventResponse)modifyBkgWithoutRouteByXter(event.getEsmBkg022901Event());
					//replanFlg = "Y";
				} else if (event.getEsmBkg022901Event().getFormCommand().isCommand(FormCommand.MULTI04)) {
					eventResponse = (GeneralEventResponse)modifyBkgWithRouteByXter(event.getEsmBkg022901Event());
					//replanFlg = "N";
				}
				changeVvdFlag = eventResponse.getETCData("change_vvd");
				codFlg = eventResponse.getETCData("codFlg");
				
				// PPD, CCT Office 변경 여부 결정, History와 현재값 비교
				// Shipper, Forwarder, Consignee, Notify, To Order 변경될 때 처리됨				
				String bkgPorCdOld = historyTableVO.getBkgBookingVO().getPorCd();
				String bkgDelCdOld = historyTableVO.getBkgBookingVO().getDelCd();
				String ldgOfcOld = historyTableVO.getBkgBookingVO().getObSlsOfcCd();
				String toOrdFlagOld = historyTableVO.getBkgBookingVO().getCustToOrdFlg();

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

				if (event.getEsmBkg022902Event() != null) {
					String bkgPorCd = event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgPorCd();
					String bkgDelCd = event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgDelCd();
					String toOrdFlag = event.getEsmBkg022902Event().getCustEtcVO().getCustToOrdFlg();
					String ldgOfc = event.getEsmBkg022901Event().getBkgBookingInfoVO().getObSlsOfcCd();
					String shCustCntCd = event.getEsmBkg022902Event().getBlDocCustVO().getShCustCntCd();
					String shCustSeq = event.getEsmBkg022902Event().getBlDocCustVO().getShCustSeq().replaceAll("^[0]*", "");;
					String cnCustCntCd = event.getEsmBkg022902Event().getBlDocCustVO().getCnCustCntCd();
					String cnCustSeq = event.getEsmBkg022902Event().getBlDocCustVO().getCnCustSeq().replaceAll("^[0]*", "");;
					String fwCustCntCd = event.getEsmBkg022902Event().getBlDocCustVO().getFfCustCntCd();
					String fwCustSeq = event.getEsmBkg022902Event().getBlDocCustVO().getFfCustSeq().replaceAll("^[0]*", "");;
					String nfCustCntCd = event.getEsmBkg022902Event().getBlDocCustVO().getNfCustCntCd();
					String nfCustSeq = event.getEsmBkg022902Event().getBlDocCustVO().getNfCustSeq().replaceAll("^[0]*", "");;
					
					if(!bkgPorCd.equals(bkgPorCdOld) || !bkgDelCd.equals(bkgDelCdOld) || !ldgOfc.equals(ldgOfcOld)
							|| !cnCustCntCd.equals(cnCustCntCdOld) || !cnCustSeq.equals(cnCustSeqOld)
							|| !fwCustCntCd.equals(fwCustCntCdOld) || !fwCustSeq.equals(fwCustSeqOld)
							|| !nfCustCntCd.equals(nfCustCntCdOld) || !nfCustSeq.equals(nfCustSeqOld)
							|| !shCustCntCd.equals(shCustCntCdOld) || !shCustSeq.equals(shCustSeqOld)
							|| !toOrdFlag.equals(toOrdFlagOld)) {
						ofcChgFlag = "Y";
					}
					log.debug ("ofcChgFlag:"+ofcChgFlag);
				}
			}
			
			// prd 내부 생성 실패 or close BKG
			if("YC".equals(eventResponse.getETCData("IsPctlNoPop"))||"YM".equals(eventResponse.getETCData("IsPctlNoPop"))
					||"Y".equals(eventResponse.getETCData("closeBkgFlag"))
					||"Y".equals(eventResponse.getETCData("tsCloseBkgFlag"))
					||"Y".equals(eventResponse.getETCData("cbfBkgFlag"))){
				return eventResponse;
			}

			if ( !"Y".equals(bkgBlNoVO.getCaFlg())) {
				// Doc Requirement 부분 저장함.
				DocRqstVO docRqstVO = event.getEsmBkg022901Event().getDocRqstVO();
				if ( docRqstVO != null ) {
					docRqstVO.setUserId(account.getUsr_id());
					docRqstVO.setBkgNo(bkgNo) ;
					
					bLIssuanceBC.modifyDocRqst(docRqstVO);

				}
			}
			
			BkgReferenceVO[] bkgReferenceVOs =event.getEsmBkg022901Event().getBkgReferenceVOs(); 
			if (bkgReferenceVOs != null && bkgReferenceVOs.length >0) {
				receiptBC.manageBkgByXter(bkgNo, bkgReferenceVOs, account);
			}
			
			//각 tab의 저장에 bkg tab의 bkg no를 넘겨줌(creation, update 동일)
			// Customer 
			if (event.getEsmBkg022902Event() != null) {
				event.getEsmBkg022902Event().getCustEtcVO().setObSlsOfcCd(event.getEsmBkg022901Event().getBkgBookingInfoVO().getObSlsOfcCd());
				event.getEsmBkg022902Event().getCustEtcVO().setObSrepCd(event.getEsmBkg022901Event().getBkgBookingInfoVO().getObSrepCd());
				event.getEsmBkg022902Event().setBkgBlNoVO(bkgBlNoVO);
//				event.getEsmBkg022902Event().setOfcChgProcVO(ofcChgProcVO);
				event.getEsmBkg022902Event().getCustEtcVO().setDocTpCd(event.getEsmBkg022901Event().getDocTpCd());
				eventResponse = (GeneralEventResponse)modifyBlDocCust(event.getEsmBkg022902Event());
			}

			// 2017.08.22 iylee SI이고 POL이 CN이면서 RFA인 경우,
			if("S".equals(event.getEsmBkg022901Event().getDocTpCd()) 
					&& "CN".equals(event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgPolCd().substring(0,2)) 
					&& event.getEsmBkg022901Event().getBkgBookingInfoVO().getRfaNo().length()>0){

				// RFA Holder Name이 shpr / cnee / freight forwarder 셋 중 어딘가에 있는지 체크.
				List<String> rfaChkList = receiptBC.searchRFAHolderNameByShprCneeFF(bkgNo, "N");
				if(rfaChkList != null && rfaChkList.size() > 0){
					String rfaHolderNm = rfaChkList.get(0);
					String existsRfaFlg = rfaChkList.get(1);
					
					//어디에도 없으면 Export Ref.란에 RFA Holder Name을 자동 Copy
					if("N".equals(existsRfaFlg)){
						receiptBC.modifyExportRefNmByRfaHolderNm(bkgNo, rfaHolderNm);
					}
				}
			}
			
			//prepaid/collect payer를 넣음
			if (!"C".equals(saveModeCd)) {	
				
				/* MDM_CR_CUST 테이블 MDM 정보 빠져 있으면 BKG_RATE 테이블에 DATA 생성이 안됨 - Firm 상태가 되지 않음 강제적으로 기본DATA Insert 해줌 (CSR 등록 시 주석 해제)*/
				//rateBC.manageFrtTerm(bkgNo, "P", "N", account, bkgBlNoVO.getCaFlg());
				
				rateBC.modifyRateCntCd(bkgNo, account, bkgBlNoVO.getCaFlg());
				
				// por_cd, del_cd 값이 Old와 New가 서로 틀린 경우에 prepaid, collect payer를 변경하도록 수정함. ( 2010-07-14, 류대영수석요청 )
//				String oldPorCd  = historyTableVO.getBkgBookingVO().getPorCd();
//				String oldDelCd  = historyTableVO.getBkgBookingVO().getDelCd();
//				String bkgPorCd  = event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgPorCd();
//				String bkgDelCd  = event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgDelCd();
//				if("Y".equals(event.getEsmBkg022901Event().getBookingSaveValidationVO().getRouteModifyFlag()) && ( !oldPorCd.equals(bkgPorCd) || !oldDelCd.equals(bkgDelCd) )){
//					rateBC.createRateForTro(bkgBlNoVO.getBkgNo(),bkgBlNoVO.getCaFlg(), account);
//				}
				
				String ctrtTpCd = "X";
				if(event.getEsmBkg022901Event().getBkgBookingInfoVO().getScNo().length()>0){
					ctrtTpCd = "S";
				}
				if(event.getEsmBkg022901Event().getBkgBookingInfoVO().getRfaNo().length()>0){
					ctrtTpCd = "R";
				}
				if(event.getEsmBkg022901Event().getBkgBookingInfoVO().getTaaNo().length()>0){
					ctrtTpCd = "T"; 
				}
				
				rateBC.modifyCtrtTpCd(bkgBlNoVO.getBkgNo(), ctrtTpCd, account, bkgBlNoVO.getCaFlg());				
			} else {
				// 생성일 경우는 무조건 PPD,CCT Office 설정함
				rateBC.createRateForTro(bkgBlNoVO.getBkgNo(),bkgBlNoVO.getCaFlg(), account);
			}

			// Container
			if (event.getEsmBkg022903Event() != null) {
				event.getEsmBkg022903Event().setBkgBlNoVO(bkgBlNoVO);
				eventResponse = (GeneralEventResponse)manageContainer(event.getEsmBkg022903Event());
			}
			// M&D
			if (event.getEsmBkg022904Event() != null) {
				event.getEsmBkg022904Event().setBkgBlNoVO(bkgBlNoVO);
				eventResponse = (GeneralEventResponse)manageMnd(event.getEsmBkg022904Event());
			}

			// TRO/O
			boolean needTroRequest = false;
			if (event.getEsmBkg022906Event() != null) {
				event.getEsmBkg022906Event().setBkgBlNoVO(bkgBlNoVO);
				eventResponse = (GeneralEventResponse)manageTro(event.getEsmBkg022906Event());
				needTroRequest = true;
			}
			
			if("C".equals(saveModeCd) && needTroRequest == false 
					                  && "KR".equals(event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgPolCd().substring(0, 2)) 
					                  && "S".equals(event.getEsmBkg022901Event().getBkgBookingInfoVO().getRcvTermCd()) ){
				troBC.manageTroKrCfs(bkgBlNoVO.getBkgNo(), account);
				
				
				TroMstVO TroMstVO = new TroMstVO();
				TroMstVO.setBkgNo(bkgBlNoVO.getBkgNo());
				TroMstVO.setRtnTroFlg("N");
				TroMstVO.setTroSeq("1");
				TroMstVO[] arrTroMstVO = new TroMstVO[]{TroMstVO};
				
				TroVO troVO = new TroVO();
				troVO.setArrTroMstVO(arrTroMstVO);
				
				EsmBkg022906Event event022906 = new EsmBkg022906Event();
				event022906.setTroVO(troVO);
				
				event.setEsmBkg022906Event(event022906);
				needTroRequest = true;
			}
			
			// Reefer
			if (event.getEsmBkg022907Event() != null ) {
				event.getEsmBkg022907Event().setBkgBlNoVO(bkgBlNoVO);
				eventResponse = (GeneralEventResponse)manageRf(event.getEsmBkg022907Event());
			}
			// Danger
			if (event.getEsmBkg022908Event() != null ) {
				event.getEsmBkg022908Event().setBkgBlNoVO(bkgBlNoVO);
				eventResponse = (GeneralEventResponse)manageDg(event.getEsmBkg022908Event());
			}
			// Awkward
			if (event.getEsmBkg022909Event() != null ) {
				event.getEsmBkg022909Event().setBkgBlNoVO(bkgBlNoVO);
				eventResponse = (GeneralEventResponse)manageAwk(event.getEsmBkg022909Event());
			}
			// Break Bulk
			if (event.getEsmBkg022912Event() != null ) {
				event.getEsmBkg022912Event().setBkgBlNoVO(bkgBlNoVO);
				eventResponse = (GeneralEventResponse)manageBb(event.getEsmBkg022912Event());
			}
			// House B/L 1
			if (event.getEsmBkg022910Event() != null ) {
				event.getEsmBkg022910Event().setBkgBlNoVO(bkgBlNoVO);
				eventResponse = (GeneralEventResponse)manageHbl(event.getEsmBkg022910Event());
			}
			
			// House B/L 2
			if (event.getEsmBkg022911Event() != null ) {
				event.getEsmBkg022911Event().setBkgBlNoVO(bkgBlNoVO);					
				eventResponse = (GeneralEventResponse)manageHbl2(event.getEsmBkg022911Event());
			}
			
			// C/M
			if (event.getEsmBkg022905Event() != null) {
				event.getEsmBkg022905Event().setBkgBlNoVO(bkgBlNoVO);
				eventResponse = (GeneralEventResponse)manageCm(event.getEsmBkg022905Event());
				
				//BKG POL이 유럽이 아닌 경우 VVD의 POD에 독일이 있을 경우 아래 로직 실행  
				String[] validatetRs  = eBkgBC.searchXterCMvalidationEuDeHjsCD(bkgBlNoVO.getBkgNo());
				String nonEuFlg = validatetRs[0];
				int deFlg = Integer.parseInt(validatetRs[1]);
				
				if(nonEuFlg.equals("Y")){
					if(deFlg > 0){
						if("S".equals(event.getEsmBkg022901Event().getDocTpCd()) || "U".equals(event.getEsmBkg022901Event().getDocTpCd())){
							throw new EventException(new ErrorHandler("BKG02211", new String[] {"Germany (Inbound, T/S)"}).getMessage());
						}
					}
				}				
			}			
			
			// Complete Upload
			event.getXterRqstNoVO().setBkgNo(bkgNo);
			
			receiptBC.modifyBkgByXter(event.getEsmBkg022901Event().getXterRqstViaCd(), saveModeCd, event.getEsmBkg022901Event().getAutoNotification(), rqstVO, account);
			receiptBC.modifyKrCstmsCustTpCd(bkgBlNoVO, "");
			if("B".equals(event.getEsmBkg022901Event().getDocTpCd())){
				receiptBC.modifyDocUserId(bkgNo, bkgBlNoVO.getCaFlg(), account.getUsr_id());
			}
			
			AllocStsChgVO allocStsChgVO = new AllocStsChgVO();
			// manage allocation status
			if("Y".equals(event.getEsmBkg022901Event().getBookingSaveValidationVO().getAlocChkFlg())
					&& !"Y".equals(bkgBlNoVO.getBdrFlg())){
				if("US".equals(event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgPolCd().substring(0,2))
						|| "CA".equals(event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgPolCd().substring(0,2))){
					//String alocPopFlg = receiptBC.manageAlocStatus(bkgBlNoVO, account);
					allocStsChgVO = receiptBC.manageAlocStatus(bkgBlNoVO, account, event.getEsmBkg022901Event().getDocTpCd());
					List<BkgNtcHisVO> bkgNtcHisVOs2 = allocStsChgVO.getBkgNtcHisVOs();
					if (null!=bkgNtcHisVOs2) {
						historyBC.createBkgNtcHis(bkgNtcHisVOs2, uiId);
					}
					String alocPopFlg = allocStsChgVO.getAlocPopFlg();
					String firmMsgFlg = allocStsChgVO.getFirmMsgFlg();
					eventResponse.setETCData("alocPopFlg", alocPopFlg);
					eventResponse.setETCData("firmMsgFlg", firmMsgFlg);
				}
			}
			//alocEmailStsFlg = (String)util.searchStandbyBlockFlg(bkgBlNoVO);
			
			//Potential DG 화물 목록을 체크한다
			dgKeyFlg = (String)util.searchPotentialDgFlg(bkgBlNoVO);
			eventResponse.setETCData("dgKeyFlg", dgKeyFlg);
			
			dgKeyFlg2 = util.searchPotentialDgFlg2(bkgBlNoVO,"All");
			eventResponse.setETCData("dgKeyFlg2", dgKeyFlg2);
			
			// Allocation Status History                                                                                                                      
			if(allocStsChgVO != null){                                                                                                                        
				HistoryLineVO historyLineVO = new HistoryLineVO();                                                                                              
				historyLineVO.setUiId(uiId);			                                                                                                  
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
			
			historyLineVOs = eBkgBC.searchBlIssComplete(bkgNo);
			if (null!=historyLineVOs && historyLineVOs.size()>0) {
				historyBC.cancelBkgDocProcSkd(historyLineVOs.get(0).getBkgDocProcTpCd(), historyLineVOs.get(0).getBkgNo(), account);
				blIssInfoVO = new BlIssInfoVO();
				blIssInfoVO.setBkgNo(bkgNo);
				blIssInfoVO.setBlReadyOffice(account.getOfc_cd());
				blIssInfoVO.setUpdUsrId(account.getUsr_id());
				blIssBC.modifyBlRdyInfo(blIssInfoVO);
			}
			
			eBkgBC.completeUpload(rqstVO, account);
			
			//container attach detach에 대한 cop 처리
			if (event.getEsmBkg022903Event() != null && !"Y".equals(bkgBlNoVO.getBdrFlg())) {
				if("C".equals(saveModeCd)){
					if (event.getEsmBkg022903Event().getContainerVOs()!=null) {
						ContainerVO [] containerVOs = event.getEsmBkg022903Event().getContainerVOs();
						for(int i=0;i<containerVOs.length;i++){							
							copBC.attachCntr(bkgBlNoVO.getBkgNo(), containerVOs[i].getCntrNo(), containerVOs[i].getCntrPrtFlg());							
						}
					}
				}  else {
					if (event.getEsmBkg022903Event().getContainerVOs()!=null) {
						ContainerVO [] containerVOs = event.getEsmBkg022903Event().getContainerVOs();
						for(int i=0;i<containerVOs.length;i++){
							if("I".equals(containerVOs[i].getIbflag()) || "U".equals(containerVOs[i].getIbflag())){								
								copBC.attachCntr(bkgBlNoVO.getBkgNo(), containerVOs[i].getCntrNo(), containerVOs[i].getCntrPrtFlg());
							} else if("D".equals(containerVOs[i].getIbflag())){								
								copBC.detachCntr(bkgBlNoVO.getBkgNo(), containerVOs[i].getCntrNo(), containerVOs[i].getCntrPrtFlg());
							}
						}		
					}
				}				
			}

			reportBC.manageQtyCntrCoposite(bkgBlNoVO.getBkgNo(), "CQ");
			
//			// 19. coa interface 
//			if("C".equals(saveModeCd)){
//				//interfaceToCoa(bkgBlNoVO, "E-Booking Create", account);
//				interfaceToMas(bkgBlNoVO, "E-Booking Create", account);
//			} else {
//				//interfaceToCoa(bkgBlNoVO, "E-Booking Update", account);
//				interfaceToMas(bkgBlNoVO, "E-Booking Create", account);
//			}
			
			if("U".equals(saveModeCd)&&"Y".equals(bkgBlNoVO.getBdrFlg())){				
				
				
				//auto c/a를 위한 BC, 해당 될때만 load한다.
	    		BLDocumentationBLBC     blDocBlBC  		= new BLDocumentationBLBCImpl();
	    		SpecialCargoReceiptBC   spclCgoBC  		= new SpecialCargoReceiptBCImpl();
	    		BlRatingBC              blRatingBC		= new BlRatingBCImpl();
		    	BDRCorrectionBC         bdrBC      		= new BDRCorrectionBCImpl();
				RevenueDebitNoteBC      rdnBC      		= new RevenueDebitNoteBCImpl();
				CargoReleaseOrderBC     cgoRelBC   		= new CargoReleaseOrderBCImpl();
				    			
				// 1st C/A History
            	String strReturn  = "N";    		
    			String copyTypeCd = "HIST000";
    			    			
    			strReturn = bdrBC.add1stCaHist(bkgBlNoVO, account);
    			
    			BDRCorrectionBC bDRCorrectionBCImpl = new BDRCorrectionBCImpl();
				SurchargeAutoRatingBC surchargeAutoRatingBC = new SurchargeAutoRatingBCImpl();
				
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
						BkgSurchargeRateVO bkgSurchargeRateVO = surchargeAutoRatingBC.searchSurchargeRatingByBcc(event.getBkgBlNoVO().getBkgNo(),"Y", account);
						if(bkgSurchargeRateVO!=null){
							eventResponse.setETCData("curr_cd", bkgSurchargeRateVO.getCurrCd());
							eventResponse.setETCData("scg_amt", bkgSurchargeRateVO.getScgAmt());				
						}
					}
				}
				
    			if ("N".equals(strReturn)) {
    				bkgBlNoVO.setCaNo("0000000001");     				
        			receiptBC.createBookingCA(bkgBlNoVO, copyTypeCd);
        			blDocBlBC.createBlCA     (bkgBlNoVO, copyTypeCd);
        			spclCgoBC.createSpclCA   (bkgBlNoVO, copyTypeCd);
        			blRatingBC.createRateCA  (bkgBlNoVO, copyTypeCd);
        			blIssBC.createIssCA      (bkgBlNoVO, copyTypeCd);
        			historyBC.createHisCA    (bkgBlNoVO, copyTypeCd);  
    			}	    			

				//Replan 대상 항목이 변경되었는지 조회한다.
    			
    			List<CorrReplanVO> corrReplanVOs = bdrBC.searchCorrReplan(bkgBlNoVO);
    			
    			CaRsnRmkVO caRsnRmkVO = bdrBC.searchCaRsnRmk(bkgBlNoVO,account); 
				
				// C/A Complete 처리 (temp -> BKG)
				copyTypeCd = "BKG";
				
    			bdrBC.modifyCngItemFlag     (bkgBlNoVO, account);
    			blDocBlBC.modifyCaComplete  (bkgBlNoVO);
    			receiptBC.createBookingCA	(bkgBlNoVO, copyTypeCd);
    			blDocBlBC.createBlCA        (bkgBlNoVO, copyTypeCd);			
    			blRatingBC.createRateCA     (bkgBlNoVO, copyTypeCd);    			
    			spclCgoBC.createSpclCA     	(bkgBlNoVO, copyTypeCd);				
    			blIssBC.createIssCA         (bkgBlNoVO, copyTypeCd);    
    			historyBC.createHisCA       (bkgBlNoVO, copyTypeCd);  
				
				// C/A History 생성 createTempHist (bkg -> hist)
				copyTypeCd = "HIST";				
    			bkgBlNoVO = bdrBC.createTempHist(bkgBlNoVO, "H", null, account);//corr no 채번됨    	
    			String strCaNo = bkgBlNoVO.getCaNo();
    			    			
    			receiptBC.createBookingCA	(bkgBlNoVO, copyTypeCd);    			
    			blDocBlBC.createBlCA        (bkgBlNoVO, copyTypeCd);
    			spclCgoBC.createSpclCA     	(bkgBlNoVO, copyTypeCd);    							
    			blRatingBC.createRateCA     (bkgBlNoVO, copyTypeCd);    							
    			blIssBC.createIssCA         (bkgBlNoVO, copyTypeCd);
    			historyBC.createHisCA       (bkgBlNoVO, copyTypeCd); 
    			
    			
				// c/a일 경우 History: 맨처음 조회한 Previous 이미지와 변경된 tmp data와 비교하여 History를 만듬
    			historyBC.manageBookingHistory(uiId, historyTableVO, account);   
    			bkgBlNoVO.setCaNo(strCaNo);
    			historyBC.modifyCaCorrNoForHistory(bkgBlNoVO);
    			
    			eventResponse.setETCData("ca_no", strCaNo);
    			
				// C/A History Temp 삭제
				copyTypeCd = "TEMP";
				
    			spclCgoBC.removeCA  		(bkgBlNoVO, copyTypeCd);
				blRatingBC.removeCA         (bkgBlNoVO, copyTypeCd);
				blIssBC.removeCA           	(bkgBlNoVO, copyTypeCd);
				historyBC.removeCA          (bkgBlNoVO, copyTypeCd);
				blDocBlBC.removeCA    		(bkgBlNoVO, copyTypeCd);
				receiptBC.removeCA			(bkgBlNoVO, copyTypeCd);
				bdrBC.removeCATemp    		(bkgBlNoVO);				
				blRatingBC.distributeCntrRate(bkgBlNoVO.getBkgNo(), account);				
				
				for(int i=0;i<corrReplanVOs.size();i++){
					log.debug("operation:"+corrReplanVOs.get(i).getOperation());
				}

				if(corrReplanVOs.size()>0){
					for(int i=0;i<corrReplanVOs.size();i++){
						if("CNTR_ATTACH".equals(corrReplanVOs.get(i).getOperation())){								
							copBC.attachCntr(bkgBlNoVO.getBkgNo(), corrReplanVOs.get(i).getCntrNo(), corrReplanVOs.get(i).getCntrPrtFlg());
						}
						if("CNTR_DETACH".equals(corrReplanVOs.get(i).getOperation())){								
							copBC.detachCntr(bkgBlNoVO.getBkgNo(), corrReplanVOs.get(i).getCntrNo(), corrReplanVOs.get(i).getCntrPrtFlg());					
						}
					}
					for(int i=0;i<corrReplanVOs.size();i++){
						if("REPLAN".equals(corrReplanVOs.get(i).getOperation())){	
							ProductCatalogCreateBC prdBC = new ProductCatalogCreateBCImpl();			
							PrdParameterVO prdParameterVO = new PrdParameterVO();
							PrdMainInfoVO  prdMainInfoVO = new PrdMainInfoVO();
							BkgBlNoVO      caBkgBlNoVO = bkgBlNoVO;
										
							caBkgBlNoVO.setCaFlg("N");
							prdMainInfoVO.setFCmd("3");
							prdMainInfoVO.setBkgNo(caBkgBlNoVO.getBkgNo());
							prdMainInfoVO.setPcMode("R");
							prdParameterVO.setBkgBlNoVO(caBkgBlNoVO);
							prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
							prdParameterVO = util.searchPrdParmForFullRoute(prdParameterVO);
							prdParameterVO.getPrdMainInfoVO().setOrgTrnsMode("");
							prdParameterVO.getPrdMainInfoVO().setDestTrnsMode("");
//							util.prdParameterLog(prdParameterVO.getPrdMainInfoVO());
							// 03. createProdCtlRout 
							String pctlNoMapStr = prdBC.createPrdCtlgRout(prdParameterVO, account);
							String [] pctlNoMapSeq = util.splitByToken(pctlNoMapStr,"|");							
							
							copBC.updateBkg(caBkgBlNoVO.getBkgNo(), pctlNoMapSeq[1]);									
						}
					}
				}			
				
				
				//RDN								
				OblIssVO oblIssVO = util.searchOblIssue(bkgBlNoVO); 
				
				RevDrNoteVO revDrNoteVO 		  = new RevDrNoteVO(); 
				CstmBkgRevDrNoteVO bkgRevDrNoteVO = new CstmBkgRevDrNoteVO();
				bkgRevDrNoteVO.setBkgNo      (bkgBlNoVO.getBkgNo());  
				bkgRevDrNoteVO.setBkgCorrNo  (bkgBlNoVO.getCaNo()); 
				bkgRevDrNoteVO.setRdnNo      (oblIssVO.getRdnNo()); 
				bkgRevDrNoteVO.setRvisSeq    (oblIssVO.getRvisSeq()); 
				bkgRevDrNoteVO.setUmchTpCd   (caRsnRmkVO.getUmchTpCd()); 
				bkgRevDrNoteVO.setUmchSubTpCd(caRsnRmkVO.getUmchSubTpCd()); 
				bkgRevDrNoteVO.setReceiverRmk("");
				revDrNoteVO.setBkgRevDrNoteVO(bkgRevDrNoteVO);	
				
				rdnBC.acceptRDNbyReceiptOffice(revDrNoteVO, account);
				
				//cargo release
				OblRdemVO oblRdem = new OblRdemVO();
				oblRdem.setBlNo      (oblIssVO.getBlNo());  
				oblRdem.setCgorTeamCd("C");
				oblRdem.setCgoEvntNm ("B/L Correct");
				oblRdem.setEvntDt    (new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
				oblRdem.setEvntOfcCd (account.getOfc_cd());
				oblRdem.setEvntUsrId (account.getUsr_id());
				oblRdem.setOblRdemFlg(oblIssVO.getOblRlseFlg()); 				

				try{					
					cgoRelBC.setupFocByObl(oblRdem);					
				} catch(Exception crEx){
					log.error("err " + crEx.toString(), crEx);
				}	
			}
			
			if("U".equals(saveModeCd)&&!"Y".equals(bkgBlNoVO.getBdrFlg())){
				if("Y".equals(changeVvdFlag)){
					//c/a가 아닐 경우 spcl cgo 자동 request
					
					ScgAproRqstVO[] scgAproRqstVOs = searchBC.searchBkgForSpclRqst(bkgBlNoVO, "EBKG", account);
					
					// spcl cgo가 있을 때만 처리
			        if(scgAproRqstVOs.length>0){
						OwnDangerousCargoApprovalBC spclAproBC    = new OwnDangerousCargoApprovalBCImpl();
						SpecialCargoReceiptBC 	    spclReceiptBC = new SpecialCargoReceiptBCImpl();
						
						try{							
							ScgVvdAproRqstVO[] scgVvdVOs = spclReceiptBC.searchBkgVvd(bkgBlNoVO.getBkgNo());
							
					        if(scgVvdVOs.length>0){							
								SpclCgoAproApplVO           spclCgoAproVO = new SpclCgoAproApplVO();
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
						} catch(Exception spclEx){
							log.error(spclEx);
						}
			        }
				}
				// c/a가 아닐 경우 History
				historyBC.manageBookingHistory(uiId, historyTableVO, account);				
			}
			
			//route or volume이 바뀐 경우	
			if(!"Y".equals(bkgBlNoVO.getBdrFlg())&&"Y".equals(replanFlg)){							
				commit();
				try{// cut off time (cop 생성 이후에 처리)					
					String fromDt = null;
					String toDt   = null;					
					if("US".equals(event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgPorCd().substring(0, 2))
							|| ("CA".equals(event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgPorCd().substring(0, 2))
									&& "Y".equals(event.getEsmBkg022901Event().getBookingSaveValidationVO().getChangeVvd())
							)){
						
						ProductCatalogCreateBC prdBC   = new ProductCatalogCreateBCImpl();
//						BkgQuantityVO[] bkgQuantityVOs = event.getEsmBkg022901Event().getBookingCreationVO().getBkgQuantityVOs();
						BkgQuantityVO[] bkgQuantityVOs = event.getEsmBkg022901Event().getBkgQuantityVOs();
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
					HistoryTableVO clzTmHistVO = null;
					
					if("U".equals(saveModeCd)) clzTmHistVO = historyBC.searchOldBkgForHistory("ESM_BKG_0721", bkgBlNoVO);
				
					begin(); //batch 서버 접속해야되서 Transaction을 분리함
					receiptBC.createCargoClosingTime(bkgBlNoVO, fromDt, toDt, account);	
					if("U".equals(saveModeCd)) historyBC.manageBookingHistory("ESM_BKG_0721", clzTmHistVO, account);
										
					commit();				
				} catch(Exception prdEx){
					rollback();
					log.error("err"+prdEx.toString(),prdEx);
				}		
			} else {
				//route or volumne이 바뀌지 않은 경우	
				commit();
			}		
			if(!"Y".equals(bkgBlNoVO.getBdrFlg())){
				//eBkgBC.createTerminalVERMASEdi(bkgBlNoVO, "");
				//06.VERMAS EDI 발송
				BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
				bkgHrdCdgCtntListCondVO.setHrdCdgId("VGM_PROC_CTR");			
				List<BkgHrdCdgCtntVO> BkgHrdCdgCtntVOs = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
				
				String vermasOb = "";
				if(BkgHrdCdgCtntVOs.size() > 0){
					vermasOb = BkgHrdCdgCtntVOs.get(0).getAttrCtnt2();// VERMAS O/B EDI 발송
				}
				
				if(!"OFF".equals(vermasOb)){
					begin();
					bkgNtcHisVOs = eBkgBC.createTerminalVERMASEdi(bkgBlNoVO,"");			
					
					if(bkgNtcHisVOs!=null){
						if(bkgNtcHisVOs.size()>0){
							historyBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0095");
						}
					}
					commit();
				}
//				
			}
			begin();			
			//2014.10.08 최도순[CHM-201431728] Split 02-SM LINE 조기결산을 위한 개선 방안 중 BKG 관리 프로세스 단축(안) 개발 START
			String oldNoRtStsCd = event.getEsmBkg022901Event().getBkgBookingInfoVO().getNonRtStsCd()==null?"":event.getEsmBkg022901Event().getBkgBookingInfoVO().getNonRtStsCd();
			
			log.debug("oldNoRtStsCd==========="+oldNoRtStsCd);
			
			String newNoRtStsCd = "";
			String noRtNtc_snd_flg = "N";
			String noRtNtc_snd_cust_flg = "N";
			String sc_no = event.getEsmBkg022901Event().getBkgBookingInfoVO().getScNo();
			String rfa_no = event.getEsmBkg022901Event().getBkgBookingInfoVO().getRfaNo();
			String taa_no = event.getEsmBkg022901Event().getBkgBookingInfoVO().getTaaNo();
			OftPrecheckVO oftPrecheckVO = new OftPrecheckVO();
			try{
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
			
			// CMPB 산출 대상인 경우 실행하도록 변경 필요
			try{
				if("Y".equals(oftPrecheckVO.getChkOft())){
					BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
					bkgHrdCdgCtntListCondVO.setHrdCdgId("NO_RATE_PROC_CTR");			
					List<BkgHrdCdgCtntVO> BkgHrdCdgCtntVOs = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
					String createCmpb = "";
					String modifyCmpb = "";
					if(BkgHrdCdgCtntVOs.size() > 0){
						createCmpb = BkgHrdCdgCtntVOs.get(0).getAttrCtnt5();// e-BKG create CMPB 생성
						modifyCmpb = BkgHrdCdgCtntVOs.get(0).getAttrCtnt6();// e-BKG modify CMPB 생성
					}
					if(("C".equals(saveModeCd) && !"N".equals(createCmpb))
						||(!"C".equals(saveModeCd) && !"N".equals(modifyCmpb))
						){
						//createContributionMarginPerBox(bkgBlNoVO, oftPrecheckVO);
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
					//History
					if(updCnt > 0){
						HistoryLineVO historyLineVO = new HistoryLineVO();
						historyLineVO.setUiId("ESM_BKG_0229");			
						historyLineVO.setHisCateNm("No Rate Status");
						historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
						historyLineVO.setCaFlg("N");
						historyLineVO.setPreCtnt(oldNoRtStsCd);
						historyLineVO.setCrntCtnt(newNoRtStsCd);
						historyBC.createBkgHistoryLine(historyLineVO, account);
						
						//Reciept Notice 는 Allocation Status 까지 확인 후 발송 (메일 발송은 commit 이후)
						//-> !R : Reciept Notice
						//->  R : No Rate Notice
						if("R".equals(oftPrecheckVO.getNonRtStsCd())&&!"R".equals(oldNoRtStsCd)){
							noRtNtc_snd_flg = "Y";// (메일 발송은 commit 이후)
						}
					}
				}
                  
                if("R".equals(oftPrecheckVO.getNonRtStsCd())){
                      // No Rate Status 가 바뀌지 않았어도 NoRateNotice to Customer 는 다시 체크  
                      String noRtNtcForCust = searchBC.searchNoRateNoticeToCustomerBlock(bkgBlNoVO);
                      if("N".equals(noRtNtcForCust)){
                            noRtNtc_snd_cust_flg = "Y";// NoRateNotice to Customer                             
                      }
                }
                commit();
			}
			//2014.10.08 최도순[CHM-201431728] Split 02-SM LINE 조기결산을 위한 개선 방안 중 BKG 관리 프로세스 단축(안) 개발 END	
			
			// SPC-BKG 연동 (NoRateStatus Firm 일 때만 SPC Aloc 체크)
 			if("F".equals(oldNoRtStsCd) || "F".equals(newNoRtStsCd)){
				if (historyTableVO == null
						|| historyTableVO.getBkgBookingVO() == null
						|| historyTableVO.getBkgBookingVO().getAlocStsCd() == null
						|| !"F".equalsIgnoreCase(historyTableVO.getBkgBookingVO().getAlocStsCd())
						|| (("US".equals(event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgPolCd().substring(0, 2)) 
								|| "CA".equals(event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgPolCd().substring(0, 2)))
								&& "Y".equals(event.getEsmBkg022901Event().getBookingSaveValidationVO().getChangeVvd()) 
								&& !"Y".equals(bkgBlNoVO.getBdrFlg()))
						|| (("Y".equals(event.getEsmBkg022901Event().getBookingSaveValidationVO().getAlocChkFlg()) 
								|| "Y".equals(event.getEsmBkg022901Event().getBookingSaveValidationVO().getRouteModifyFlag()))
								&& (!"US".equals(historyTableVO.getBkgBookingVO().getPolCd().substring(0, 2)) 
										&& !"CA".equals(historyTableVO.getBkgBookingVO().getPolCd().substring(0, 2)))
								&& !"Y".equals(bkgBlNoVO.getBdrFlg())
								&& historyTableVO.getBkgBookingVO().getSvcScpCd() != null
								&& !"TPW".equals(historyTableVO.getBkgBookingVO().getSvcScpCd())
								&& !"AEE".equals(historyTableVO.getBkgBookingVO().getSvcScpCd())
								&& !"SAW".equals(historyTableVO.getBkgBookingVO().getSvcScpCd())
								&& !"BRE".equals(historyTableVO.getBkgBookingVO().getSvcScpCd()) 
								&& !"MXW".equals(historyTableVO.getBkgBookingVO().getSvcScpCd()))
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
	 					historyLineVO.setUiId("ESM_BKG_0229");			
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
	 						historyLineVO.setUiId("ESM_BKG_0229");			
	 						historyLineVO.setHisCateNm("Allocation Status");
	 						historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
	 						historyLineVO.setCaFlg("N");
	 						historyLineVO.setCrntCtnt("F");
	 						historyLineVO.setPreCtnt(allocStsChgVO2.getOriAlocStsCd());
	 						historyBC.createBkgHistoryLine(historyLineVO, account);
	 					}
	 					
	 				}else if("PKGSA".equals(account.getOfc_cd())){//미주 경우, PKGSA User 가 SI 한 때에는 Standby BKG Process 적용 안 함
	 					if("US".equals(event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgPolCd().substring(0, 2))
	 							|| "CA".equals(event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgPolCd().substring(0, 2)) ){
	 						//F
		 					AllocStsVO allocStsVO = new AllocStsVO();
		 					allocStsVO.setAlocStsCd("F");
		 					AllocStsChgVO allocStsChgVO2 = receiptBC.modifyAllocStatusForBkg(bkgBlNoVO, allocStsVO, account);
		 					// history
		 					if(!allocStsChgVO2.getAlocStsCd().equals(allocStsChgVO2.getOriAlocStsCd())){
		 						HistoryLineVO historyLineVO = new HistoryLineVO();
		 						historyLineVO.setUiId("ESM_BKG_0229");			
		 						historyLineVO.setHisCateNm("Allocation Status");
		 						historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
		 						historyLineVO.setCaFlg("N");
		 						historyLineVO.setCrntCtnt("F");
		 						historyLineVO.setPreCtnt(allocStsChgVO2.getOriAlocStsCd());
		 						historyBC.createBkgHistoryLine(historyLineVO, account);
		 					}
	 					}
		 				
	 				}else if(spcSbBkgDtlVO != null && spcSbBkgDtlVO.size()>0){
	 					String alocPopFlg = "";
	 					String firmMsgFlg = "";
	 					AllocStsVO allocStsVO = new AllocStsVO();
	 					for(int i=0; i<spcSbBkgDtlVO.size(); i++){
	 						if(spcSbBkgDtlVO.get(i).getAlocSvcCd()!=null && "M".equals(spcSbBkgDtlVO.get(i).getAlocSvcCd())){
	 							alocPopFlg = "Y";
	 							allocStsVO.setAlocSvcCd("M");
	 						}
	 					}
	//					if("US".equals(event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgPolCd().substring(0, 2))
	//						|| "CA".equals(event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgPolCd().substring(0, 2))){
							allocStsVO.setAlocStsCd("S");
	//						if(!"Y".equals(alocPopFlg)){ 
	//							allocStsVO.setStandbyNtcFlg("Y");
	//						}
	//					}else{
	//						allocStsVO.setAlocStsCd("A");
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
							historyLineVO.setUiId("ESM_BKG_0229");			
							historyLineVO.setHisCateNm("Allocation Status");
							historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
							historyLineVO.setCaFlg("N");
							historyLineVO.setCrntCtnt(tmpBuffer.toString());
							historyBC.createBkgHistoryLine(historyLineVO, account);
							
							firmMsgFlg = allocStsChgVO2.getFirmMsgFlg();
							eventResponse.setETCData("alocPopFlg", alocPopFlg);
							eventResponse.setETCData("firmMsgFlg", firmMsgFlg);
						}
						if(allocStsChgVO2.getBkgNtcHisVOs().size()>0){
							historyBC.createBkgNtcHis(allocStsChgVO2.getBkgNtcHisVOs(), "ESM_BKG_0229");
						}
					}
	 				commit();
 				}
 			}	
 			// SPC-BKG 연동 (NoRateStatus Firm 일 때만 SPC Aloc 체크)(E)
            
			begin();
			
			// 19. coa interface 
			if("C".equals(saveModeCd)){
				//interfaceToCoa(bkgBlNoVO, "E-Booking Create", account);
				interfaceToMas(bkgBlNoVO, "E-Booking Create", account);
			} else {
				//interfaceToCoa(bkgBlNoVO, "E-Booking Update", account);
				interfaceToMas(bkgBlNoVO, "E-Booking Update", account);
			}
			
			//2014.10.08 최도순[CHM-201431728] Split 02-SM LINE 조기결산을 위한 개선 방안 중 BKG 관리 프로세스 단축(안) 개발 START
			// No Rate Notice 발송
			//if("Y".equals(noRtNtc_snd_flg)){
				//  -> !R : Reciept Notice
				//  ->  R : No Rate Notice
			
			String ssoTargetUrl = JSPUtil.getNull(SiteConfigFactory.get("COM.HANJIN.SSO.TARGET"));
			 
			 boolean isLive = false;     // Live 여부
			 if (ssoTargetUrl.indexOf("alps.smlines.com") > 0) {
			   // 2017.04.10 iylee No Rate 대상이여도 메일 발송 하지 않음. 
               //isLive = true;
			 } 
				
				BkgBookingInfoVO bkgBookingInfoVO = event.getEsmBkg022901Event().getBkgBookingInfoVO();
				 
				if(isLive&&"R".equals(oftPrecheckVO.getNonRtStsCd())){
					bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
					BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
					String sndId = null;
					Mail mail = null;
					String mailContents = null;
					// No Rate Notice 발송 화주 (S)
					
					if ("Y".equals(noRtNtc_snd_cust_flg)){
						if(bkgBookingInfoVO.getBkgCntcPsonEml()!=null && !"".equals(bkgBookingInfoVO.getBkgCntcPsonEml())){
							mailContents = getNoRateNoticeToCustomer(bkgBlNoVO.getBkgNo(), rqstVO.getRqstNo());
							mail = new Mail();
							mail.setFrom("noreply@smlines.com");// 보내는사람
							mail.setRecipient(bkgBookingInfoVO.getBkgCntcPsonEml());// 받는사람
							mail.setSubject("Customer Notice (Request No. "+rqstVO.getRqstNo()+" )");// 제목
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
							
							 
                            BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
                            bkgDocProcSkdVO.setBkgNo(bkgBlNoVO.getBkgNo());
                            bkgDocProcSkdVO.setBkgDocProcTpCd("NORTNC");//NoRateNoticeForCustomer
                            historyBC.manageDocProcess(bkgDocProcSkdVO, account);  
						}
					}
					
					if("Y".equals(noRtNtc_snd_flg)){						
						String srepEml = searchBC.searchSrepEml(bkgBookingInfoVO.getObSrepCd());//S.Rep e-Mail 조회
						if(srepEml != null && srepEml.length() > 0){
							// No Rate Notice 발송 S.Rep (S)
							mailContents = getNoRateNoticeToSrep(bkgBlNoVO.getBkgNo(), rqstVO.getRqstNo());
							mail = new Mail();
							mail.setFrom("noreply@smlines.com");// 보내는사람
							mail.setRecipient(srepEml);// 받는사람
							mail.setSubject("No rate booking Notice (BKG No. "+bkgBlNoVO.getBkgNo()+" )");// 제목
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
			//}
			//2014.10.08 최도순[CHM-201431728] Split 02-SM LINE 조기결산을 위한 개선 방안 중 BKG 관리 프로세스 단축(안) 개발 END

			eBkgBC.createXterBkgAckEdi(event.getEsmBkg022901Event().getDocTpCd(), rqstVO);

			//for t/s booking close
			BookingSaveValidationVO bookingSaveValidationVO = event.getEsmBkg022901Event().getBookingSaveValidationVO();
			if(bookingSaveValidationVO.getClosedTsVvd() != null
					&& bookingSaveValidationVO.getClosedTsVvd().length() > 0){
				receiptBC.sendTsCloseNotice(bkgBlNoVO, bookingSaveValidationVO.getClosedTsVvd(), account);
			}
			
			// eBooking Booking Tab에 있는 Auto Notification Check시에 메일 전송함.
			// Standby Status 'S' 일 때 전송 제외 (alocEmailStsFlg)
			alocEmailStsFlg       = (String)util.searchStandbyBlockFlg(bkgBlNoVO);
			String noRateBlockFlg = (String)util.searchNoRateBlockFlg(bkgBlNoVO);
			
			 // 2017.04.20 정인선 No Rate 메일과 상관없이 발송을 해야되서 추가. 
			if (ssoTargetUrl.indexOf("alps.smlines.com") > 0) {
	           isLive = true;
			} 
			
//			if( isLive && "Y".equals(event.getEsmBkg022901Event().getAutoNotification()) && event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgCntcPsonEml().trim().length() > 0
			if("Y".equals(event.getEsmBkg022901Event().getAutoNotification()) && event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgCntcPsonEml().trim().length() > 0
			&& !StringUtils.containsNone(event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgCntcPsonEml().trim(), "@")
			&& !"Y".equals(alocEmailStsFlg) && !"Y".equals(noRateBlockFlg)
			&& !"Y".equals(noRtNtc_snd_flg)) { 
				BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
				String [] eml = new String[event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgCntcPsonEml().length()];
//				eml[0] = event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgCntcPsonEml();
				String [] rmk = new String[1];
				rmk[0] = "";
				if ("B".equals(event.getEsmBkg022901Event().getDocTpCd())){
					// WEB Auto Booking이 아닌경우 Notice 발송
					// WEB Auto Booking인 경우 Special Cargo가 포함되거나 TRO(한국제외)가 포함된 경우 Notice 발송하지 않음.
//					if(!"Y".equals(event.getEsmBkg022901Event().getBkgBookingInfoVO().getWebSvcFlg())
//							||(   event.getEsmBkg022907Event() == null && event.getEsmBkg022908Event() == null
//							   && event.getEsmBkg022909Event() == null && event.getEsmBkg022912Event() == null
							   //&& 
				    if("KR".equals(event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgPolCd().substring(0, 2))
									   || event.getEsmBkg022906Event() == null )
					{

						eml[0] = event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgCntcPsonEml();
						StringBuilder titleSb = new StringBuilder("SM Line Web Booking Notification");
						titleSb.append(" ( ").append(bkgBlNoVO.getBkgNo()).append(" :  Uploaded )");
						StringBuilder contentSb = new StringBuilder("Dear Customer");
						contentSb.append("<br><br>Thank you for using our website");
						contentSb.append("<br>Your booking '").append(bkgBlNoVO.getBkgNo()).append("' request is successfully processed in our booking & documentation system.");
						contentSb.append("<br>For your cargo information, refer to the attached file");
						contentSb.append("<br><br><br>If you have any question, please contact our booking & documentation");
						contentSb.append("<br>").append(account.getUsr_id());
						contentSb.append("<br><br><br>We would like to listen to how you think of our service, If you have any suggestions or comments");
						contentSb.append("<br>please visit our website and leave your comments into the section of Voice of Customer");
						BkgBlNoVO[] bkgBlNoVOs = new BkgBlNoVO[] {new BkgBlNoVO() };
						
						mrdNm = "ESM_BKG_5005G";
						String [] cct = new String[event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgCntcPsonEml().length()];
						for(int j=0;j<cct.length;j++){
							cct[j]="";
						}
						
						String vslNm = blIssBC.searchVesselNameByBkgNo(bkgBlNoVO.getBkgNo());					
						bkgBlNoVOs[0].setBkgNo(bkgBlNoVO.getBkgNo());
						
						bkgNtcHisVOs = searchBC.sendXterReceiptByEmail(bkgBlNoVOs, eml, rmk, mrdNm, cct, account, titleSb.toString(), contentSb.toString(), vslNm );
					}
				    
				} else if (("S".equals(event.getEsmBkg022901Event().getDocTpCd()) || "U".equals(event.getEsmBkg022901Event().getDocTpCd()))&& !"Y".equals(event.getEsmBkg022901Event().getBkgBookingInfoVO().getWebSvcFlg())){
					eml[0] = event.getEsmBkg022901Event().getBkgBookingInfoVO().getSiCntcPsonEml();
					sbParam = new StringBuilder();
					
					if ("PKGSA".equals(account.getOfc_cd())){
						String[] bkgContact  = eBkgBC.searchBkgContactInfo(bkgBlNoVO.getBkgNo());
						siContactUsrNm = bkgContact[0];
						siContactEmail = bkgContact[1];
						if (siContactUsrNm == null || "".equals(siContactUsrNm)) {
							siContactUsrNm = account.getUsr_nm();
							siContactEmail = account.getUsr_eml();
						}
					} else if("US".equals(event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgPolCd().substring(0,2))
							|| "CA".equals(event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgPolCd().substring(0,2))){
						siContactUsrNm = "Outbound Documentation";
						siContactEmail = "phxobdoc@us.smlines.com";
					}else {
						siContactUsrNm = account.getUsr_nm();
						siContactEmail = account.getUsr_eml();
					}
					
					StringBuilder titleSb = new StringBuilder("SM Line Web B/L Instruction Notification ");
					titleSb.append(" ( ").append(bkgBlNoVO.getBkgNo()).append(" :  Uploaded )");
					StringBuilder contentSb = new StringBuilder("Dear Customer");
					contentSb.append("\n\nThank you for using SM Line Website.");
					contentSb.append("\nThis is an automated message to inform you that your B/L instruction request for \"").append(bkgBlNoVO.getBkgNo()).append("\"  is received for processing.");
					contentSb.append("\nPlease note that the attachment is not the final draft B/L, but a preview form of the final draft B/L.");
					contentSb.append("\n\nIf you have any question on the submitted B/L instruction or booking, please contact: ").append(siContactUsrNm).append(" (").append(siContactEmail).append(").");
					contentSb.append("\n\nIf you have any suggestions or comments, do not hesitate to share us your valuable comments in our \"Voice of Customer\" menu.");
					
					sType="2";
					sMrd="ESM_BKG_0109_DBL.mrd";					
					sLevel="1";
					
					// 2017.10.31 iylee 특정 화주(DBL_NO_CHG_CUST_LIST)일 경우, Draft B/L에 No Charge 로 설정.
					String shCustCntCd = event.getEsmBkg022902Event().getBlDocCustVO().getShCustCntCd();
					String shCustSeq = event.getEsmBkg022902Event().getBlDocCustVO().getShCustSeq().replaceAll("^[0]*", "");

					boolean dblNoChgFlag = false;
					BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
					bkgHrdCdgCtntListCondVO.setHrdCdgId("DBL_NO_CHG_CUST_LIST");
					List<BkgHrdCdgCtntVO> hrdCdgList = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
					for(int h=0;h<hrdCdgList.size(); h++){
						BkgHrdCdgCtntVO tmpBkgHrdVO = (BkgHrdCdgCtntVO)hrdCdgList.get(h);
						if(shCustCntCd.equals(tmpBkgHrdVO.getAttrCtnt1()) && shCustSeq.equals(tmpBkgHrdVO.getAttrCtnt2())){
							dblNoChgFlag = true;
							break;
						}
					}
					if(dblNoChgFlag){
						sLevel="6";
					}
					
                    sbParam.append("/rv");
                    sbParam.append(" form_bkgNo[('").append(bkgBlNoVO.getBkgNo()).append("')]");
                    sbParam.append(" form_type[").append(sType).append("]");
                    sbParam.append(" form_dataOnly[N]");
                    sbParam.append(" form_manifest[N]");
                    sbParam.append(" form_usrId[").append(account.getUsr_id()).append("]");
                    sbParam.append(" form_hiddeData[N]");
                    sbParam.append(" form_mainOnly[N]");
                    sbParam.append(" form_level[(").append(sLevel).append(")]");
                    sbParam.append(" form_remark[").append(rmk[0]).append("]");
                    sbParam.append(" form_Cntr[1]");
                    sbParam.append(" form_cntcDtl [Y]");
                    sbParam.append(" form_CorrNo[]");
                    sbParam.append(" form_his_cntr[BKG_CONTAINER]");
                    sbParam.append(" form_his_bkg[BKG_BOOKING]");
                    sbParam.append(" form_his_mkd[BKG_BL_MK_DESC]");
                    sbParam.append(" form_his_xpt[BKG_XPT_IMP_LIC]");
                    sbParam.append(" form_his_bl[BKG_BL_DOC]");
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
					dblWblVOs[0].setRcveml(eml[0]);
					dblWblVOs[0].setTmplmrdpdf("Original.pdf");
					dblWblVOs[0].setItr("|$$|");
//					dblWblVOs[0].setNtcKndCd("");
//					dblWblVOs[0].setHiddOpt("N");
					dblWblVOs[0].setFrtAllFlg("1".equalsIgnoreCase(sLevel)?"Y":"N");
					dblWblVOs[0].setFrtCltFlg("5".equalsIgnoreCase(sLevel)?"Y":"N");
					dblWblVOs[0].setFrtPpdFlg("4".equalsIgnoreCase(sLevel)?"Y":"N");
					dblWblVOs[0].setFrtChgFlg("6".equalsIgnoreCase(sLevel)?"Y":"N");
					dblWblVOs[0].setFrtArrFlg("3".equalsIgnoreCase(sLevel)?"Y":"N");
					dblWblVOs[0].setTitle(titleSb.toString()); /* 제목 */
					dblWblVOs[0].setContents(contentSb.toString()); /* 내용 */
					
					bkgNtcHisVOs = bLIssuanceBC.sendDblWblByEmail(dblWblVOs, null, account);					
				}
				
				if(null != bkgNtcHisVOs && bkgNtcHisVOs.size() > 0 ){
					bkgNtcHisVO = bkgNtcHisVOs.get(0);
					bkgNtcHisVO.setSndUsrId("SYSTEM");
					bkgNtcHisSysVOs.add(bkgNtcHisVO);
					historyBC.createBkgNtcHis(bkgNtcHisSysVOs, "ESM_BKG_0229");
				}		
			}			
			
			//2014.10.08 최도순[CHM-201431728] Split 02-SM LINE 조기결산을 위한 개선 방안 중 BKG 관리 프로세스 단축(안) 개발 
			if(!"Y".equals(noRtNtc_snd_flg)){
			//for notice to customer
			if(isLive&&!"Y".equals(bkgBlNoVO.getBdrFlg()) && bookingSaveValidationVO.getCustNtcFlg().equals("Y")){
                begin();
				List<BkgBlNoVO> bkgBlNoVOs = new ArrayList<BkgBlNoVO>();
				bkgBlNoVOs.add(bkgBlNoVO);
				bkgNtcHisVOs = searchBC.sendBkgVslReviseNotice(bkgBlNoVOs, bookingSaveValidationVO.getVslCngRsn(), account);
				if (null!=bkgNtcHisVOs) {
					for (int i=0; i<bkgNtcHisVOs.size(); i++) {
						bkgNtcHisVOs.get(i).setCreUsrId(account.getUsr_id());
						bkgNtcHisVOs.get(i).setUpdUsrId(account.getUsr_id());
					}
					historyBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0079_01");
				}
				commit();
			}
			
			if(!"Y".equals(bkgBlNoVO.getBdrFlg())||!"Y".equals(event.getEsmBkg022901Event().getBkgBookingInfoVO().getEdiHldFlg())){
				searchBC.createCustBkgReceiptEdiBackEnd(bkgBlNoVO, null, "Y", account);				
				
					if("C".equals(saveModeCd)){
						// 08. sendBkgTmlEdi(전용진수석님 호출)
						// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
						Vender301ParamVO vender301ParamVO = new Vender301ParamVO(); 
						vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
						vender301ParamVO.setOldVvdVOs(null);
						vender301ParamVO.setOldQtyVOs(null);
						vender301ParamVO.setOldMtyPkupYdCd(null);
						vender301ParamVO.setBracCd("N");
						vender301ParamVO.setEdiKind("BT");
						vender301ParamVO.setAutoManualFlg("Y");
						
						searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);					
					} else {
						String brac = "X";
						brac = "Y".equals(changeVvdFlag)?"B":"U";
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
								vender301ParamVO.setOldVvdVOs(historyTableVO.getBkgVvdVOs());
								vender301ParamVO.setOldQtyVOs(historyTableVO.getBkgQuantityVOs());
								vender301ParamVO.setOldMtyPkupYdCd(historyTableVO.getBkgBookingVO().getMtyPkupYdCd());
								vender301ParamVO.setBracCd(brac);
								vender301ParamVO.setEdiKind("BT");
								vender301ParamVO.setAutoManualFlg("Y");
								
								searchBC.createTmlBkgReceiptEdiBackEnd(vender301ParamVO, account);							
							}
						}
					}
				if ("B".equals(event.getEsmBkg022901Event().getDocTpCd())){
					rqstVO.setBkgNo(bkgNo);					
					eBkgBC.sendBOKCON(rqstVO); // 신규 추가된 TP에 대해 BKG 신규 생성 후 BOKCON 발송기능 추가 jsy					
				}
				//////////////////////////////////////////////////////////////////////////
				// customer301 전송 시작 - 2011.01.10
				// Standby Status 'S' -> 'F' 변경시 Customer 301 전송
				if ("Y".equals(changeVvdFlag) ) {
					CustTpIdVO custTpIdVo = util.searchCustTpIdInfo(bkgBlNoVO.getBkgNo());
					if( null != custTpIdVo ){
						bkgNtcHisVOs = searchBC.createCustBkgReceiptEdi(bkgBlNoVO, custTpIdVo, "N", account);							
						
						if (null!=bkgNtcHisVOs) {
							for (int i=0; i<bkgNtcHisVOs.size(); i++) {
								bkgNtcHisVOs.get(i).setSndId("SYSTEM");
								bkgNtcHisVOs.get(i).setSndUsrId("SYSTEM");
								bkgNtcHisVOs.get(i).setSndOfcCd("SYSTEM");
								bkgNtcHisVOs.get(i).setCreUsrId(account.getUsr_id());
								bkgNtcHisVOs.get(i).setUpdUsrId(account.getUsr_id());
							}							
							historyBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0229");							
						}
					}					
				}
				// customer301 전송 끝 - 2011.01.10
				//////////////////////////////////////////////////////////////////////////
			}
			} //
			
			if("U".equals(saveModeCd)){				
				interfaceToInv(bkgBlNoVO, account);			
			}
			
			// 2016-04-07 Upload 시 TRO Request
			if(needTroRequest){
				//한국 일때는 bkg의 pkup, rtn cy 변경
				if("KR".equals(event.getEsmBkg022901Event().getBkgBookingInfoVO().getBkgPolCd().substring(0, 2))){					
					//receiptBC.modifyKrPkupRtnCy(event.getBkgBlNoVO());
					troBC.modifyKrTroReturnCy(bkgBookingInfoVO.getBkgNo(), account);

					//TRO/O Tab 의 Remarks에 "위 BKG의 D2 장비에 대해 5년 이하의 신규 장비 공급 바랍니다." 삽입
					//Lane/BD : ALX W/B, BKG POL: KRPUS, BKG POD : BRSSZ / BRRIG / ARBUE, EQ Type/Size : D2 일 경우
					
					troBC.modifyKrTroRmk(event.getEsmBkg022906Event().getTroVO(), account);
					
					/*********************************************************************/
					// #.Request
					/*********************************************************************/					
					// 한국 TRO 화면의 저장 처리 셋팅
					// Request Method Call : TRO 정보가 셋팅된 경우 호출 
                	if("N".equals(util.searchNoRateBlockFlg(bkgBlNoVO)) && "N".equals(util.searchStandbyBlockFlg(bkgBlNoVO))){
                		//02. Tro 저장
                		BkgWebServiceVO bkgWebServiceVO = new BkgWebServiceVO(); 
                		bkgWebServiceVO.setXterRqstNo(rqstVO.getRqstNo());
                		bkgWebServiceVO.setXterRqstSeq(rqstVO.getRqstSeq());
                		bkgWebServiceVO.setXterSndrId(rqstVO.getSenderId());
                		
                    	TroVO spclTroVO = new TroVO(); 
                    	BkgTroSpclCgoSeqVO[] arrBkgTroSpclCgoSeqVO = eBkgBC.searchXterBkgTroSpclCgoSeqInterface(bkgWebServiceVO);
                    	
                    	if(arrBkgTroSpclCgoSeqVO.length > 0){
                    		spclTroVO.setArrBkgTroSpclCgoSeqVO(arrBkgTroSpclCgoSeqVO);
                    		troBC.manageKrTro(spclTroVO, account);
                    	}
                    	//04. Qty 저장
                    	BkgQuantityVO[] arrBkgQuantityVO = eBkgBC.searchBkgQuantityVOInterface(bkgBlNoVO);
                    	receiptBC.modifyBkgQtyByTro(arrBkgQuantityVO, "O", account);	//GeneralBookingReceiptBC
                      	
                    	//1) str_flatfile 생성 - sendTroEdiToHJT에 있던거..
                      	TroMstVO[] arrTroMstVO = event.getEsmBkg022906Event().getTroVO().getArrTroMstVO();
                      	//troBC.createTroEdi(bkgBlNoVO, arrTroMstVO[0].getTroSeq(), "", arrTroMstVO[0].getRtnTroFlg(),arrTroMstVO[0].getOwnrTrkFlg(), account);
                	} 					
				}
			}
			// 2011.08.30 EML 에 대한 bkg_sr_fax의 SR_PROC_TP_CD 에 대한 업데이트
			//EBKULD e-BKG upload
			if("EML".equals(JSPUtil.getNull(event.getSenderId())) && !"".equals(JSPUtil.getNull(event.getRqstNo()) )  && !"".equals(JSPUtil.getNull(event.getFaxLogRefNo()) )){				
				eBkgBC.addBkgSrProcHisPrcSql(event.getRqstNo(), event.getFaxLogRefNo(), "EBKULD", account.getUsr_id());							
			}

			eventResponse.setETCData("codFlg", codFlg);
			eventResponse.setETCData("ofcChgFlag", ofcChgFlag);
			eventResponse.setETCData("bkg_no", bkgNo);
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
	 * UI_BKG_1100조회화면의 COMBO 값 조회(공통 CODE 조회)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComCode1100(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		BookingUtil comboUtil = null;
		EBookingReceiptBC command = null;
		BkgComboVO combovo = null;
		List<BkgComboVO> delivery = null;
		List<BkgComboVO> bkg_upld_sts_cd = null;
		List<BkgComboVO> doc_tp_cd = null;
		List<BkgComboVO> xter_bkg_rqst_sts_cd = null;
		try {
			eventResponse = new GeneralEventResponse();
			comboUtil = new BookingUtil();
			command = new EBookingReceiptBCImpl();
			combovo = new BkgComboVO();
			combovo.setDesc("All");
			combovo.setVal("All");
			delivery = command.searchComboMdmConti();  // Delivery - conti_cd
			bkg_upld_sts_cd = comboUtil.searchCombo("CD01630");  //Upload Status - bkg_upld_sts_cd
			doc_tp_cd = comboUtil.searchCombo("CD02090");  // DOCType - doc_tp_cd
			xter_bkg_rqst_sts_cd = comboUtil.searchCombo("CD01620");  // Request Status - xter_bkg_rqst_sts_cd
			eventResponse.setRsVoList(delivery);
			eventResponse.setRsVoList(bkg_upld_sts_cd);
			eventResponse.setRsVoList(doc_tp_cd);
			eventResponse.setRsVoList(xter_bkg_rqst_sts_cd);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0902 : Retieve
	 * e-Booking Control for Vessel Slot Management 조회(ESM_BKG_1100)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEBookingControlForVslMgmt(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		EsmBkg1100Event event = null;
		EBookingReceiptBC command = null;
		List<EBookingControlMgmtVO> list = null;
		try {
			eventResponse = new GeneralEventResponse();
			event = (EsmBkg1100Event)e;
			command = new EBookingReceiptBCImpl();
			list = command.searchEBookingControlForVslMgmt(event.getEBookingControlMgmtVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * e-Booking Control Management 수정(ESM_BKG_1100)<br>
	 * 
	 * @author KimByungKyu
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyEBookingControlMgmt(Event e) throws EventException {
		GeneralEventResponse eventResponse = null;
		EsmBkg1100Event event = null;
		EBookingReceiptBC command = null;
		try{
			eventResponse = new GeneralEventResponse();
			event = (EsmBkg1100Event)e;
			command = new EBookingReceiptBCImpl();
			begin();
			if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {  //confirm
				command.modifyEBookingControlMgmt(Arrays.asList(event.getEBookingControlMgmtVOs()),"C",account);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {  //reject
				command.modifyEBookingControlMgmt(Arrays.asList(event.getEBookingControlMgmtVOs()),"R",account);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) {  //undo
				command.modifyEBookingControlMgmt(Arrays.asList(event.getEBookingControlMgmtVOs()),"",account);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) {  //save remark
				command.modifyEBookingControlMgmt(Arrays.asList(event.getEBookingControlMgmtVOs()),"RMK",account);
			}
            eventResponse.setUserMessage(new ErrorHandler("BKG06071").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0228 : BKG NO SAVE 클릭
	 * EBookingReceipt의 Booking No를 변경한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse bkgNoXterRqst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		try{
			begin();
			EsmBkg0228Event event = (EsmBkg0228Event)e;
			command.changeXterRqstBkgNo(event.getXterRqstNoVOs());

			for ( int i=0; i<event.getXterRqstNoVOs().length; i++ ) {
				if ( event.getXterRqstNoVOs()[i].getIbflag().equals("U")){
					//E-Booking 데이타가 들어온 경우 DPCS 에 데이타 입력함.
					PerformanceReportBC command2 = new PerformanceReportBCImpl();
					DpcsWebBookingVO dpcsWebBookingVO = new DpcsWebBookingVO();
					dpcsWebBookingVO.setXterSndrId(event.getXterRqstNoVOs()[i].getSenderId());
					dpcsWebBookingVO.setXterRqstNo(event.getXterRqstNoVOs()[i].getRqstNo());
					dpcsWebBookingVO.setXterRqstSeq(event.getXterRqstNoVOs()[i].getRqstSeq());
					//seanaccs => Y, samsung => N
					dpcsWebBookingVO.setXterRqstChgFlg("SEANACCS".equalsIgnoreCase(event.getXterRqstNoVOs()[i].getSenderId()) ? "Y":"N");
					command2.addBkgSrRequest(dpcsWebBookingVO);
				}
			}
				
			eventResponse.setETCData("SuccessYn", "Y");
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
	 * Container Confirm을 Cancel한다.
	 * 
     * @param String bkgNo
	 * @param String blNo
     * @exception Exception
	 */
	private void cancelContainerConfirm(String bkgNo, String blNo) throws Exception {
		String uiId = "ESM_BKG_0229_03";
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
	}

	/**
	 * ESM_BKG_0228 : 0228에서 Detail 부분 Open시에 Validation 부분
	 * EBookingReceipt의 Seanaccs Validation 정보 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterRqstValidation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		XterRqstValidationVO xterRqstValidationVO = null;
		
		try {
			EsmBkg0228Event event = (EsmBkg0228Event)e;

			EBookingReceiptBC command = new EBookingReceiptBCImpl();

			ExternalRqstListInputVO externalRqstListInputVO = event.getXterRqstListInputVO();

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

	/**
	 * ESM_BKG_0229_01 <br>  
	 * ESM_BKG_0229_02<br>
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

			// ESM_BKG_0229_01
			if(e.getEventName().equalsIgnoreCase("EsmBkg022901Event")){
				EsmBkg022901Event event = (EsmBkg022901Event)e;
				BlCustomerInfoVO blCustomerInfoVO = event.getBlCustomerInfoVO();
				custNms.add(blCustomerInfoVO.getSCustNm());
				custNms.add(blCustomerInfoVO.getFCustNm());
				fullSchFlg = "Y";
			// ESM_BKG_0229_02
			} else if(e.getEventName().equalsIgnoreCase("EsmBkg022902Event")){
				EsmBkg022902Event event = (EsmBkg022902Event)e;
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
	 * ESM_BKG_0229_02<br>
	 * 해당 Customer가 EU Black Customer 인지 체크한다. <br>
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

			// ESM_BKG_0229_02
			if(e.getEventName().equalsIgnoreCase("EsmBkg022902Event")){
				EsmBkg022902Event event = (EsmBkg022902Event)e;
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
	 * ESM_BKG_0229_01 <br>  
	 * ESM_BKG_0229_02<br>
	 * 해당 Customer가 Portal 에 등록 된 Customer 인지 체크한다. <br>
	 *  
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkPortalCustomerCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		try {
			EsmBkg022902Event event = (EsmBkg022902Event) e;
			BlDocCustVO blDocCustVO = event.getBlDocCustVO();
			String[] sndrIds = {"INTTRA", "INTTRANG2", "CARGOSMART", "GTNEXUS"};
			if(Arrays.asList(sndrIds).contains(event.getXterRqstNoVO().getSenderId())){
				Map<String, String> customers = new HashMap<String, String>();
				customers.put("S", blDocCustVO.getShCustCntCd() + blDocCustVO.getShCustSeq());
				customers.put("F", blDocCustVO.getFfCustCntCd() + blDocCustVO.getFfCustSeq());
				customers.put("C", blDocCustVO.getCnCustCntCd() + blDocCustVO.getCnCustSeq());
				customers.put("N", blDocCustVO.getNfCustCntCd() + blDocCustVO.getNfCustSeq());
				int ctrctCnt = 0;
				for (Entry<String, String> entry : customers.entrySet()) {				
		            if (StringUtils.isNotBlank(entry.getValue())) {	            	
		            	String rtnValue = command.checkPortalCustomerCd(event.getXterRqstNoVO().getSenderId(), entry.getKey(), entry.getValue());
		            	if(!"N".equals(rtnValue)){
		            		ctrctCnt++;
		            	} else {
		            		StringBuffer str = new StringBuffer();
		            		str.append(event.getXterRqstNoVO().getBkgNo());
		            		str.append(",");
		            		str.append(event.getXterRqstNoVO().getRqstNo());
		            		str.append(",");
		            		str.append(event.getXterRqstNoVO().getRqstSeq());
		            		str.append(",");
		            		str.append(event.getXterRqstNoVO().getSenderId());
		            		str.append(",");
		            		str.append(entry.getKey());
		            		str.append(",");
		            		str.append(entry.getValue());
		            		str.append(",");
		            		command.createBkgExecEnisLog(str.toString(), event.getXterRqstNoVO().getRqstNo(), "ESM_BKG_0229_02,"+account.getUsr_id());
		            	}
		            }
		        }						
				eventResponse.setETCData("edi_cust_flag",   ctrctCnt > 0 ? "Y" : "N");
			}			
			return eventResponse;
		} catch (EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	/**
	 * ESM_BKG_0229_01 <br>  
	 * ESM_BKG_0229_02<br>
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

			// ESM_BKG_0229_01
			if(e.getEventName().equalsIgnoreCase("EsmBkg022901Event")){
				EsmBkg022901Event event = (EsmBkg022901Event)e;
				BlCustomerInfoVO blCustomerInfoVO = event.getBlCustomerInfoVO();
				BkgBookingInfoVO bkgBookingInfoVO = event.getBkgBookingInfoVO();
				custNms.add(blCustomerInfoVO.getSCustNm());
				custNms.add(blCustomerInfoVO.getFCustNm());
				rmkList.add(bkgBookingInfoVO.getInterRmk());
				rmkList.add(bkgBookingInfoVO.getXterRmk());
				fullSchFlg = "Y";
			// ESM_BKG_0229_02
			} else if(e.getEventName().equalsIgnoreCase("EsmBkg022902Event")){
				EsmBkg022902Event event = (EsmBkg022902Event)e;
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
	 * ESM_BKG_0229_02<br>
	 * 해당 Customer가 IKEA Customer 인지 체크한다. <br>
	 *  
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse validateEdiIkeaCust(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		String ediCustChkFlg = "N";
		try{
			EsmBkg022902Event event = (EsmBkg022902Event)e;

			SearchXterPoMdtItmParmVO searchXterPoMdtItmParmVO = event.getSearchXterPoMdtItmParmVO();
			
			if(command.validateEdiIkeaCust(searchXterPoMdtItmParmVO)){
				ediCustChkFlg = "Y";
			}
			eventResponse.setETCData("edi_cust_flag",   ediCustChkFlg);
			
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
	 * getCntrEdiFlatFile : 엑셀에서 컨테이너 관련된 EDI 전송 Flat File 을 가져온다. 
	 * 
	 * @param int sheetIndex
	 * @param Sheet sheet
	 * @param int x
	 * @param int y
	 * @param boolean isFirst
	 * @return String
	 */
	private String getCntrEdiFlatFile(int sheetIndex, Sheet sheet, int x, int y, boolean isFirst, boolean isNewForm) throws Exception {
		return this.getCntrEdiFlatFile(sheetIndex, sheet, x, y, isFirst, 0, isNewForm);
	}

	/**
	 * getCntrEdiFlatFile : 엑셀에서 컨테이너 관련된 EDI 전송 Flat File 을 가져온다. 
	 * 
	 * @param int sheetIndex
	 * @param Sheet sheet
	 * @param int x
	 * @param int y
	 * @param boolean isFirst  //앞열,뒷열 구분
	 * @param int icmdSeq
	 * @param boolean isNewForm
	 * @return String
	 */
	private String getCntrEdiFlatFile(int sheetIndex, Sheet sheet, int x, int y, boolean isFirst, int icmdSeq, boolean isNewForm) throws Exception {
		final String[] arrName = {
			"EDI_MAIN",			//0
			"{I_BKG_CNTR",		//1
			"CNTR_NO:",			//2
			"IBCNTR_SEAL_NO:",	//3
			"IBCNTR_SEAL_NO2:",	//4
			"IBCNTR_SEAL_NO3:",	//5
			"IBCNTR_PKG_QTY:",	//6
			"IBCNTR_PKG_CD:",	//7
			"IBCNTR_WGT_QTY:",	//8
			"IBCNTR_WGT_TP:",	//9
			"IBCNTR_MEA_QTY:",	//10
			"IBCNTR_MEA_TP:",	//11
			"}I_BKG_CNTR",		//12
			"HBL",				//13
			"{I_CM_MARK_DESC",	//14
			"ICMD_SEQ:",		//15
			"ICMD_PKG_QTY:",	//16
			"ICMD_PKG_CD:",		//17
			"ICMD_WGT_QTY:",	//18
			"ICMD_WGT_TP:",		//19
			"ICMD_MEA_QTY:",	//20
			"ICMD_MEA_TP:",		//21
			"}I_CM_MARK_DESC",	//22
			
			"ICMD_HTS_CD:",		//23  I_BKG_CNTR에 추가되는 내용
			"ICMD_HS_CD:",		//24
			"ICMD_NCM_CD:",      //25			
			"IBCNTR_VGM_METHOD:", // 26 VGM 관련 추가
			"IBCNTR_VGM_WGTQTY:", // 27 VGM 관련 추가
			"IBCNTR_VGM_WGTCD:", // 28 VGM 관련 추가
			"IBCNTR_VGM_VERIDT:", // 29 VGM 관련 추가
		};
		BookingUtil util = null;
		MdmPckTpVO pckVO = null;
		StringBuilder sb = null;
		String lineSeparator = null;
		int add = 0;
		try {
			util = new BookingUtil();
			sb = new StringBuilder();
			lineSeparator = System.getProperty("line.separator");
			if ("".equals(getExcelCellValue(sheet.getRow(x).getCell(y)))) return "";
			if (0==sheetIndex) {
				add = isFirst ? 3 : 4;
				if (!"".equals(getExcelCellValue(sheet.getRow(4+x).getCell(add+y)))) {
					pckVO = util.searchPkgTypeByName(getExcelCellValue(sheet.getRow(4+x).getCell(add+y)).toUpperCase());
				}
				sb.append(arrName[1]).append(lineSeparator);
				sb.append(arrName[2]).append(getExcelCellValue(sheet.getRow(x).getCell(y))).append(lineSeparator);
				sb.append(arrName[3]).append(getExcelCellValue(sheet.getRow(1+x).getCell(y))).append(lineSeparator);
				sb.append(arrName[4]).append(getExcelCellValue(sheet.getRow(2+x).getCell(y))).append(lineSeparator);
				sb.append(arrName[5]).append(getExcelCellValue(sheet.getRow(3+x).getCell(y))).append(lineSeparator);
				sb.append(arrName[6]).append(getExcelCellValue(sheet.getRow(4+x).getCell(y)).replaceAll(",","")).append(lineSeparator);
				sb.append(arrName[7]).append(null!=pckVO ? pckVO.getPckCd():"").append(lineSeparator);
				if(isNewForm){
					sb.append(arrName[8]).append(getExcelCellValue(sheet.getRow(9+x).getCell(y)).replaceAll(",","")).append(lineSeparator);
					sb.append(arrName[9]).append(getExcelCellValue(sheet.getRow(9+x).getCell(add+y)).toUpperCase()).append(lineSeparator);
					sb.append(arrName[10]).append(getExcelCellValue(sheet.getRow(10+x).getCell(y)).replaceAll(",","")).append(lineSeparator);
					sb.append(arrName[11]).append(getExcelCellValue(sheet.getRow(10+x).getCell(add+y)).toUpperCase()).append(lineSeparator);
					String method = "SM1";
					if(getExcelCellValue(sheet.getRow(7+x).getCell(y)).indexOf("2") > -1){
						method = "SM2";
					}
					sb.append(arrName[26]).append(method);
					sb.append("@VGM@").append(getExcelCellValue(sheet.getRow(6+x).getCell(y))).append("@VGM@").append(lineSeparator);
					sb.append(arrName[27]).append(getExcelCellValue(sheet.getRow(5+x).getCell(y)).replaceAll(",","")).append(lineSeparator);
					sb.append(arrName[28]).append(getExcelCellValue(sheet.getRow(5+x).getCell(add+y)).replaceAll(",","")).append(lineSeparator);
					sb.append(arrName[29]).append(getExcelCellValue(sheet.getRow(8+x).getCell(y)).replaceAll("-","")).append(lineSeparator);
					
				} else {
					sb.append(arrName[8]).append(getExcelCellValue(sheet.getRow(5+x).getCell(y)).replaceAll(",","")).append(lineSeparator);
					sb.append(arrName[9]).append(getExcelCellValue(sheet.getRow(5+x).getCell(add+y)).toUpperCase()).append(lineSeparator);
					sb.append(arrName[10]).append(getExcelCellValue(sheet.getRow(6+x).getCell(y)).replaceAll(",","")).append(lineSeparator);
					sb.append(arrName[11]).append(getExcelCellValue(sheet.getRow(6+x).getCell(add+y)).toUpperCase()).append(lineSeparator);
				
				}
				sb.append(arrName[12]).append(lineSeparator);
			} else if (1==sheetIndex) { //add jsy 
				add = isFirst ? 3 : 4;
				if(!"".equals(getExcelCellValue(sheet.getRow(4+x).getCell(add+y))) ) {
					pckVO = util.searchPkgTypeByName(getExcelCellValue(sheet.getRow(4+x).getCell(add+y)).toUpperCase());
				} 
				if(!"".equals(getExcelCellValue(sheet.getRow(7+x).getCell(y))) ||
				   !"".equals(getExcelCellValue(sheet.getRow(7+x).getCell(2+y))) ||
				   !"".equals(getExcelCellValue(sheet.getRow(7+x).getCell(add+y))) ) {
					
					sb.append(arrName[14]).append(lineSeparator);
					sb.append(arrName[2]).append(getExcelCellValue(sheet.getRow(x).getCell(y))).append(lineSeparator);
					sb.append(arrName[15]).append(icmdSeq).append(lineSeparator);
					sb.append(arrName[16]).append(getExcelCellValue(sheet.getRow(4+x).getCell(y)).replaceAll(",","")).append(lineSeparator);
					sb.append(arrName[17]).append(null!=pckVO ? pckVO.getPckCd():"").append(lineSeparator);
					sb.append(arrName[18]).append(getExcelCellValue(sheet.getRow(5+x).getCell(y)).replaceAll(",","")).append(lineSeparator);
					// weight unit
					sb.append(arrName[19]).append(getExcelCellValue(sheet.getRow(5+x).getCell(add+y)).toUpperCase()).append(lineSeparator);
					
					sb.append(arrName[20]).append(getExcelCellValue(sheet.getRow(6+x).getCell(y)).replaceAll(",","")).append(lineSeparator);
					//measure unit
					sb.append(arrName[21]).append(getExcelCellValue(sheet.getRow(6+x).getCell(add+y)).toUpperCase()).append(lineSeparator);
					
					sb.append(arrName[23]).append(getExcelCellValue(sheet.getRow(7+x).getCell(y))).append(lineSeparator);
					sb.append(arrName[24]).append(getExcelCellValue(sheet.getRow(7+x).getCell(2+y))).append(lineSeparator);
					sb.append(arrName[25]).append(getExcelCellValue(sheet.getRow(7+x).getCell(add+y))).append(lineSeparator);
					
					sb.append(arrName[22]).append(lineSeparator);
				}
			} else if (2==sheetIndex) {
				if (!"".equals(getExcelCellValue(sheet.getRow(4+x).getCell(1+y)))) {
					pckVO = util.searchPkgTypeByName(getExcelCellValue(sheet.getRow(4+x).getCell(1+y)).toUpperCase());
				}
				sb.append(arrName[14]).append(lineSeparator);
				sb.append(arrName[2]).append(getExcelCellValue(sheet.getRow(x).getCell(y))).append(lineSeparator);
				sb.append(arrName[15]).append(icmdSeq).append(lineSeparator);
				sb.append(arrName[16]).append(getExcelCellValue(sheet.getRow(4+x).getCell(y)).replaceAll(",","")).append(lineSeparator);
				sb.append(arrName[17]).append(null!=pckVO ? pckVO.getPckCd():"").append(lineSeparator);
				sb.append(arrName[18]).append(getExcelCellValue(sheet.getRow(5+x).getCell(y)).replaceAll(",","")).append(lineSeparator);
				sb.append(arrName[19]).append(getExcelCellValue(sheet.getRow(5+x).getCell(1+y)).toUpperCase()).append(lineSeparator);
				sb.append(arrName[20]).append(getExcelCellValue(sheet.getRow(6+x).getCell(y)).replaceAll(",","")).append(lineSeparator);
				sb.append(arrName[21]).append(getExcelCellValue(sheet.getRow(6+x).getCell(1+y)).toUpperCase()).append(lineSeparator);
				sb.append(arrName[22]).append(lineSeparator);
			}
		} catch(Exception e) {
			throw e;
		}
		return sb.toString();
	}

	/**
	 * getMndSheetData : mark & desc 정보의 추가 시트에서 데이타를 읽어온다. 
	 *
	 * @param Sheet sheet
	 * @param int colIdx
	 * @param String mnd
	 * @return String
	 */
	@SuppressWarnings("unused")
	private String getMndSheetData(Sheet sheet,int colIdx,String mnd) throws Exception {
		StringBuilder sb = null;
		Row row = null;
		boolean flag = true;
		int lastRow = 0;
		List<String> list = null;
		String lineSep ="";		
		
		try {
			
			String sysLnSep = System.getProperty("line.separator");
			if(sysLnSep != null){
				lineSep = sysLnSep;
			}
			
			sb = new StringBuilder();
			lastRow = sheet.getLastRowNum();
			list = new ArrayList<String>();
			for (int i=1; i<=lastRow; i++) {
				if (flag = false) continue;
				row = sheet.getRow(i);
				if (null!=row) {
					if (i==row.getCell(colIdx).getRowIndex()) {
						list.add(this.getExcelCellValue(row.getCell(colIdx)));
					} else {
						continue;
					}
				} else {
					list.add("");
				}
			}
			for (int i=list.size()-1; 0<i; i--) {
				if ("".equals(list.get(i))) {
					list.remove(i);
				} else {
					break;
				}
			}
			for (int i=0; i<list.size(); i++) {
				sb.append(mnd).append(":").append(list.get(i));
				sb.append(lineSep);
			}
		} catch(Exception e) {
			throw e;
		}
		return sb.toString();
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
	 * getExcelCellValue
	 * 
	 * @param Cell cell
	 * @return String
	 * @exception Exception
	 */
	private String getExcelCellValue(Cell cell) throws Exception {
		String val = "";
		if (null!=cell) {
			switch(cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
			    	val = cell.getRichStringCellValue().getString();
			    	if("(SELECT)".equalsIgnoreCase(val)){
			    		val="";
			    	}
			        break;
				case Cell.CELL_TYPE_NUMERIC:
			        if(DateUtil.isCellDateFormatted(cell)) {
			        	val = (new SimpleDateFormat("yyyyMMdd")).format(cell.getDateCellValue());
			        } else {
			        	val = String.valueOf(cell.getNumericCellValue());
			        }
			        break;
			    case Cell.CELL_TYPE_BOOLEAN:
			    	val = String.valueOf(cell.getBooleanCellValue());
			        break;
			    case Cell.CELL_TYPE_FORMULA:
			    	val = cell.getStringCellValue();
			        break;
			    default:
			    	val = "";
			}
		}
		return val.trim();
	}

	/**
	 * ESM_BKG_0229 : searchBkgChgOfc <br>
	 * searchBkgChgOfc 정보를 저장한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgChgOfc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0229Event event = null;
		GeneralBookingSearchBC searchBC = new GeneralBookingSearchBCImpl();
		BookingUtil util = new BookingUtil();
		BkgBlNoVO bkgBlNoVO = null;
		List<BkgChgOfcVO> list = null;
		try {
			event = (EsmBkg0229Event) e;
			bkgBlNoVO = event.getBkgBlNoVO();
			bkgBlNoVO.setCaUsrId(account.getUsr_id());
			list = searchBC.searchBkgChgOfc(util.searchBkgBlNoVO(bkgBlNoVO));
			if (null!=list && 1==list.size()) {
				for (BkgChgOfcVO bkgChgOfcVO : list) {
					eventResponse.setETCData("bfCltOfcCd", bkgChgOfcVO.getBfCltOfcCd());
					eventResponse.setETCData("cltOfcCd", bkgChgOfcVO.getCltOfcCd());
					eventResponse.setETCData("bfPpdRcvOfcCd", bkgChgOfcVO.getBfPpdRcvOfcCd());
					eventResponse.setETCData("ppdRcvOfcCd", bkgChgOfcVO.getPpdRcvOfcCd());
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
	 * ESM_BKG_0229 : modifyBkgChgOfc <br>
	 * modifyBkgChgOfc 정보를 저장한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyBkgChgOfc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0229Event event = null;
		BlRatingBC rateBC = new BlRatingBCImpl();
		BookingUtil util = new BookingUtil();
		BkgBlNoVO bkgBlNoVO = null;
		BkgModiOfcPrcVO bkgModiOfcPrcVO = null;
		try {
			event = (EsmBkg0229Event) e;
			bkgBlNoVO = event.getBkgBlNoVO();
			bkgBlNoVO.setCaUsrId(account.getUsr_id());
			bkgBlNoVO = util.searchBkgBlNoVO(bkgBlNoVO);
			bkgModiOfcPrcVO = new BkgModiOfcPrcVO();
			bkgModiOfcPrcVO.setInBkgNo(bkgBlNoVO.getBkgNo());
			bkgModiOfcPrcVO.setInCaFlg(bkgBlNoVO.getCaFlg());
			bkgModiOfcPrcVO.setInPpdFlg("Y");
			bkgModiOfcPrcVO.setInCctFlg("Y");
			rateBC.callBkgModiChgOfcPrc(bkgModiOfcPrcVO);
			interfaceToInv(bkgBlNoVO, account);
			//interfaceToCoa(bkgBlNoVO, "E-Booking Update", account);
			interfaceToMas(bkgBlNoVO, "E-Booking Update", account);
       } catch(EventException ex) {
           throw ex;
       } catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
       }
       return eventResponse;
    }	

	/**
	 * sendErrLogMailBySimpleEDI<br>
	 * 
	 * @param String emailAddr
	 * @param String bkgNo
	 * @param String docTpCd
	 * @param String emailSubject
	 * @return String
	 * @exception Exception
	 */
	private String sendErrLogMailBySimpleEDI(String emailAddr, String bkgNo, String docTpCd, String emailSubject) {
		TemplateMail template = null;
		String sndId = null;
		try {
			begin();
			template = new TemplateMail();
			template.setBatFlg("N");
			template.setFrom("e-biz@smlines.com");
			template.setRecipient(emailAddr);
			if("B".equalsIgnoreCase(docTpCd)){
				template.setSubject("[SM Line] Simple Booking Failure Notice");
				template.setHtmlTemplate("ESM_BKG_ErrSimBKG.html");
				//[CHM-201432429] SIMPLE BKG FAILURE MESSAGE 수정 요청 2014.10.22
				template.setArg("emailSubject",emailSubject);
			} else {
				template.setSubject("[SM Line] Simple S/I Failure Notice");
				template.setHtmlTemplate("ESM_BKG_ErrSimEDI.html");
				template.setArg("bkgNo",bkgNo);
			}
			sndId = template.send();
			commit();
		} catch(Exception e) {
			rollback();
			log.error(e.getMessage()); // 2011.07.14
		}
		return sndId;
	}
	
	/**
	 * sendSuccessMailBySimpleEDI<br>
	 * 
	 * @param String emailAddr
	 * @param String bkgNo
	 * @param String docTpCd
	 * @return String
	 * @exception Exception
	 */
	private String sendSuccessMailBySimpleEDI(String emailAddr, String bkgNo, String docTpCd) {
		TemplateMail template = null;
		String sndId = null;
		try {
			begin();
			template = new TemplateMail();
			template.setBatFlg("N");
			template.setFrom("e-biz@smlines.com");
			template.setRecipient(emailAddr);
			template.setSubject("【??海?】 ?易??系?自?回?通知");
			template.setHtmlTemplate("ESM_BKG_SusSimBKG.html");
			sndId = template.send();
			commit();
		} catch(Exception e) {
			rollback();
			log.error(e.getMessage()); // 2011.07.14
		}
		return sndId;
	}
	
	/**
	 * ESM_BKG_0228 : Upload 클릭
	 * BOOKING S/I KIND에 따른 VALUE 자동 세팅.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadDummyXterRqst(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PerformanceReportBC command = new PerformanceReportBCImpl();
		EsmBkg0228Event event = (EsmBkg0228Event)e;
		
		try{
			begin();
			ModifySiValAutoVO modifySiValAutoVO = event.getModifySiValAutoVO();
			modifySiValAutoVO.setUsrId(account.getUsr_id());
			modifySiValAutoVO = command.modifySiValAuto(modifySiValAutoVO, modifySiValAutoVO.getCallPgmType()) ;
			
			if( !"".equals(modifySiValAutoVO.getOErrMsg())){
	
				throw new EventException(modifySiValAutoVO.getOErrMsg()); 
			}else{
				XterRqstNoVO xterRqstNoVO = new XterRqstNoVO();
				xterRqstNoVO.setBkgNo(modifySiValAutoVO.getBkgNo());
				xterRqstNoVO.setSenderId(modifySiValAutoVO.getXterSndrId());
				xterRqstNoVO.setRqstNo(modifySiValAutoVO.getXterRqstNo());
				xterRqstNoVO.setRqstSeq(modifySiValAutoVO.getXterRqstSeq());
				EBookingReceiptBC command2 = new EBookingReceiptBCImpl();
				command2.completeUpload(xterRqstNoVO, account); 
			}
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.toString(),ex); 
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0229_01 <br>  2011.07.18 추가(중국 Solid Waste 관련 bkg commodity validation 추가)
	 * BookingCreation CmdtCd로 정보 조회 <br>
	 *  
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */	
	private EventResponse validateChnWasteCmdt(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg022901Event event = (EsmBkg022901Event)e;
		GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
		String chnWasteFlag = "N";
		try{
			chnWasteFlag = receiptBC.validateChnWasteCmdt(event.getCmdtCd());
			eventResponse.setETCData("chn_waste_flag",chnWasteFlag);
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
			//CoaBkgComIfVO coaBkgComIfVo 		= new CoaBkgComIfVO();
			MasBkgComIfVO masBkgComIfVo 		= new MasBkgComIfVO();
			//CostAssignBC coaBc 					= new CostAssignBCImpl();
			ARBkgInterfaceCreationVO bkgIfVo 	= new ARBkgInterfaceCreationVO();
			BookingARCreationBC invBc 			= new BookingARCreationBCImpl();
			CostAssignBC masBc  = new CostAssignBCImpl();
			
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
						
						//COA I/F
					/*	coaBkgComIfVo.setBkgNo(blNoVO.getBkgNo());
						coaBkgComIfVo.setCostSrcSysCd("BKG");
						coaBkgComIfVo.setIfRmk("reactivate");
						coaBkgComIfVo.setCreUsrId(account.getUsr_id());
						coaBkgComIfVo.setUpdUsrId(account.getUsr_id());			
						coaBc.modifyCoaCommonInterface(coaBkgComIfVo);*/

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
	
	/**
	 * ESM_BKG_0229_04 : searchXterPoMdtItm
	 * PO NO check 를 위한  Path item 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchXterPoMdtItm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg022904Event event = (EsmBkg022904Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			String pathItem = null;

			pathItem = command.searchXterPoMdtItm(event.getSearchXterPoMdtItmParmVO());
			eventResponse.setETCData("path_item", pathItem);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0229_07 : searchCntrTpSz
	 * Reefer Tab CNTR Type Size 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrTpSz(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg022907Event event = (EsmBkg022907Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			String cntrTpSz;

			cntrTpSz = command.searchCntrTpSz(event.getCntrTpSz());
			eventResponse.setETCData("cntrTpSzChk", cntrTpSz);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * container vgm 정보를 체크 .(ESM_BKG_0229_03)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	@SuppressWarnings("null")
	private EventResponse validateCntrVgmWgt(Event e) throws EventException {

		GeneralEventResponse eventResponse = null;
		EsmBkg022903Event event22903 = null;
		EBookingReceiptBC command = null;
		
		try {
			eventResponse = new GeneralEventResponse();
			command = new EBookingReceiptBCImpl();
			
			if ("EsmBkg022903Event".equalsIgnoreCase(e.getEventName())) {	
				event22903 = (EsmBkg022903Event)e;
				ContainerVO cntr = command.searchBkgCntrVgmWgt(event22903.getBkgNo(), event22903.getContainerVOs());
			    eventResponse.setETCData("cntrNo", cntr.getCntrNo());
			    eventResponse.setETCData("vgmWgt", cntr.getVgmWgt());
			}

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * container Risk 정보를 체크 .(ESM_BKG_0229_03)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	@SuppressWarnings("null")
	private EventResponse validateCntrRsk(Event e) throws EventException {

		GeneralEventResponse eventResponse = null;
		EsmBkg022903Event event22903 = null;
		BLDocumentationCMBC docCmd = null;
		
		try {
			eventResponse = new GeneralEventResponse();
			docCmd = new BLDocumentationCMBCImpl();
			
			if ("EsmBkg022903Event".equalsIgnoreCase(e.getEventName())) {	
				event22903 = (EsmBkg022903Event)e;
			    String rskFlg = docCmd.validateCntrRsk(event22903.getContainerVOs(),"N","N");
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
	 * RF Risk 정보를 체크 .(ESM_BKG_0229_07)
	 * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	@SuppressWarnings("null")
	private EventResponse validateRfRsk(Event e) throws EventException { 

		GeneralEventResponse eventResponse = null;
		EsmBkg022907Event event22907 = null;
		BLDocumentationCMBC docCmd = null;
		ContainerVO[] containerVOs = null;
		
		try {
			eventResponse = new GeneralEventResponse();
			docCmd = new BLDocumentationCMBCImpl();
			
			if ("EsmBkg022907Event".equalsIgnoreCase(e.getEventName())) {			
				event22907 = (EsmBkg022907Event)e;
				containerVOs = new ContainerVO[event22907.getBkgRfCgoVOs().length];  
				if ( event22907.getBkgRfCgoVOs() != null) {
					for (int i=0; i<event22907.getBkgRfCgoVOs().length; i++) {
						//01. mst
						ContainerVO containerVO = new ContainerVO();						
						containerVO.setBkgNo    (event22907.getBkgRfCgoVOs()[i].getBkgNo());
						containerVO.setCntrNo	(event22907.getBkgRfCgoVOs()[i].getCntrNo());
						containerVOs[i] = containerVO;
					}
				}
			    String rskFlg = docCmd.validateCntrRsk(containerVOs,"N","Y");
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
	 * ESM_BKG_0229_02 : searchActualCustomerName
	 * Actual Customer Name 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActualCustomerName(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EsmBkg022902Event event = (EsmBkg022902Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();

			String[] actualCustomer  = command.searchActualCustomerName(event.getCustEtcVO().getAgmtActCntCd(),event.getCustEtcVO().getAgmtActCustSeq(),event.getBlDocCustVO().getExCustNm());
			String agmtCustFlag = actualCustomer[0];
			String agmtCustNm = actualCustomer[1];
			
			eventResponse.setETCData("agmt_cust_flag", agmtCustFlag);
			eventResponse.setETCData("agmt_cust_nm", agmtCustNm);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Web Interface Date Setting and Upload<br>
	 *
	 * @param Event e
	 * @return EsmBkg0229Event
	 * @exception EventException
	 */
	private EventResponse xterRqstDatasetInterface(Event e) throws EventException {
		EventResponse eventResponse = new GeneralEventResponse();
		
		EsmBkgWeb0090001Event 	eventWeb	= (EsmBkgWeb0090001Event)e;
		EsmBkg0229Event 		event0229 	= new EsmBkg0229Event();
		account = eventWeb.getSignOnUserAccount();
		
		EBookingReceiptBC 		command 	= new EBookingReceiptBCImpl();			
		BookingUtil 					util 			= new BookingUtil();
		
		EsmBkg022901Event 		event022901 = new EsmBkg022901Event();	// Booking ESM_BKG_0229
		EsmBkg022902Event 		event022902 = new EsmBkg022902Event();	// Customer ESM_BKG_0229_02
		EsmBkg022906Event 		event022906 = new EsmBkg022906Event();	// TRO ESM_BKG_0229_06
		EsmBkg022907Event 		event022907 = new EsmBkg022907Event();	// RF ESM_BKG_0229_07
		EsmBkg022908Event 		event022908 = new EsmBkg022908Event();	// DG ESM_BKG_0229_08
		EsmBkg022909Event 		event022909 = new EsmBkg022909Event();	// AK ESM_BKG_0229_09
		EsmBkg022912Event 		event022912 = new EsmBkg022912Event();	// BB ESM_BKG_0229_12
		
		BkgWebServiceVO bkgWebServiceVO = eventWeb.getBkgWebServiceVO();
		
		bkgWebServiceVO.setPctlExptFlg("N");
		bkgWebServiceVO.setBkgUpldStsCd("N");
		bkgWebServiceVO.setSysUpldFlg("N");
		bkgWebServiceVO.setBkgBlckFlg("N");
		
		XterRqstNoVO xterRqstNoRstVO = command.searchXterRqstNoInterface(bkgWebServiceVO);
		//String betaIdYn = "N"; 
		
		/*BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
		bkgHrdCdgCtntListCondVO.setHrdCdgId("WEB_AUTO_SI_CUST");			
		List<BkgHrdCdgCtntVO> custIdList = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
		if(custIdList!=null){
			for(int i=0 ; i < custIdList.size(); i++){
				if(custIdList.get(i).getAttrCtnt1().equals(xterRqstNoRstVO.getCustId())){
					betaIdYn ="Y";
				}
			}
		}
		*/
		/*BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
		bkgHrdCdgCtntListCondVO.setHrdCdgId("WEB_AUTO_SI_ON");			
		List<BkgHrdCdgCtntVO> siAutoOn = util.searchHardCoding(bkgHrdCdgCtntListCondVO);	*/	
		
		if("S".equals(xterRqstNoRstVO.getDocTpCd())||"U".equals(xterRqstNoRstVO.getDocTpCd())){
			xterSIRqstDatasetInterface(e);
			return eventResponse;		
		}
			
		try{
			begin();
						
			// BKG Black List 체크
			
			String blackList = command.checkBkgBlackList(xterRqstNoRstVO);
			
			if(blackList != null && !"".equals(blackList)){
				commit();
				return eventResponse;
			}
			
			// Interface로 Upload된 정보 PreviousStatus Update
			command.modifyPreviousBookingRequestStatus(bkgWebServiceVO, account);
			commit();
		}catch(EventException ex){
			rollback();
			modifyAutoUploadStatus(bkgWebServiceVO);
			throw ex;
		} catch(Exception ex) {
			rollback();
			modifyAutoUploadStatus(bkgWebServiceVO);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		
		try{
			BkgWebServiceVO bkgWebServiceVOStatus = command.searchWebServiceProcessType(bkgWebServiceVO);
			String lodgDueDt = "";
			if("Y".equals(bkgWebServiceVOStatus.getBkgBlckFlg())){
				// BKG Block FLAG값이 Y이면  webSvcVO에 해당값 세팅해주세요.
				bkgWebServiceVO.setBkgBlckFlg(bkgWebServiceVOStatus.getBkgBlckFlg());
			}
			
			//BookingUtil             util      	= new BookingUtil();
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("EBKG_BLOCK_AUTO_UPLD");			
			List<BkgHrdCdgCtntVO> hdcList = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
			boolean blockAutoUpload = false;
			String message = "";
			if(hdcList != null && hdcList.size() > 0){
				 for(BkgHrdCdgCtntVO vo : hdcList){
					 /* Auto upload 사용 여부 N 이면 사용 */
					 if("Y".equals(vo.getAttrCtnt1())){
						 blockAutoUpload = true;
					 }
					 
					 if(blockAutoUpload) break;
					 
					 /* VVD 동일하면 메뉴얼 */
					 if(xterRqstNoRstVO.getVvd() != null && !vo.getAttrCtnt2().equals("") && xterRqstNoRstVO.getVvd().equals(vo.getAttrCtnt2())){
						 blockAutoUpload = true;
						 message = "VVD 동일합니다. : " + xterRqstNoRstVO.getVvd();
					 }
					 
					 /* POL 동일하면 메뉴얼 */
					 if(xterRqstNoRstVO.getPolCd() != null && !vo.getAttrCtnt3().equals("") && xterRqstNoRstVO.getPolCd().equals(vo.getAttrCtnt3())){
						 blockAutoUpload = true;
						 message = "POL 동일합니다. : " + xterRqstNoRstVO.getPolCd();
					 }
				 }
			}
			
			if(!blockAutoUpload && !"Y".equals(bkgWebServiceVOStatus.getManualFlg()) && !"U".equals(bkgWebServiceVOStatus.getJobTp())){
				/*********************************************************************/
				//#.XterRqstNoVO
				/*********************************************************************/
				//XterRqstNoVO xterRqstNoRstVO = command.searchXterRqstNoInterface(bkgWebServiceVO);
				event0229.setXterRqstNoVO(xterRqstNoRstVO);
				/*********************************************************************/
				//#.BkgBlNoVO
				/*********************************************************************/
				BkgBlNoVO bkgBlNoVO = command.searchBkgBlNoInterface(bkgWebServiceVO);
				event0229.setBkgBlNoVO(bkgBlNoVO);
	
				/*********************************************************************/
				//#.xterEtcInterfaceVO
				/*********************************************************************/
				XterEtcInterfaceVO xterEtcInterfaceVO = command.searchXterEtcInterface(bkgWebServiceVO);
				event0229.setRqstNo(xterEtcInterfaceVO.getAutoNotification());
				event0229.setFaxLogRefNo(xterEtcInterfaceVO.getFaxLogRefNo());
				event0229.setSenderId(xterEtcInterfaceVO.getSenderId());
				
				event0229.setSaveBkgFlag (xterEtcInterfaceVO.getSaveBkgFlag());
				event0229.setSaveCustFlag(xterEtcInterfaceVO.getSaveCustFlag());
				event0229.setSaveCntrFlag(xterEtcInterfaceVO.getSaveCntrFlag());
				event0229.setSaveMndFlag (xterEtcInterfaceVO.getSaveMndFlag());
				event0229.setSaveCmFlag  (xterEtcInterfaceVO.getSaveCmFlag());
				event0229.setSaveTroFlag (xterEtcInterfaceVO.getSaveTroFlag());
				event0229.setSaveRfFlag  (xterEtcInterfaceVO.getSaveRfFlag());
				event0229.setSaveDgFlag  (xterEtcInterfaceVO.getSaveDgFlag());
				event0229.setSaveAkFlag  (xterEtcInterfaceVO.getSaveAkFlag());
				event0229.setSaveBbFlag  (xterEtcInterfaceVO.getSaveBbFlag());
				event0229.setSaveHblFlag (xterEtcInterfaceVO.getSaveHblFlag());
				event0229.setSaveHbl2Flag(xterEtcInterfaceVO.getSaveHbl2Flag());
				
				/* AK Data 가 존재하면 Auto BKG를 하지 않는다. 박유숙 부장님 요청 */
				if(xterEtcInterfaceVO.getSaveAkFlag().equals("Y")){
					util.addBkgLog("BKG Auto Upload", xterRqstNoRstVO.getRqstNo(), "Auto BKG AWK Data 존재하여 Manual Booking으로 진행");
					/* 업로딩 상태를 N 로 변경한다 */
					modifyAutoUploadStatus(bkgWebServiceVO);
					return eventResponse;
				}
				
				/*********************************************************************/
				// #.searchXterBkgInterface [Booking] - event022901	
				/*********************************************************************/
				if("Y".equals(event0229.getSaveBkgFlag())){
					FormCommand f = new FormCommand();
					f.setCommand(FormCommand.MULTI02);
					event022901.setFormCommand(f);
					event022901.setXterRqstNoVO(xterRqstNoRstVO);
					event022901.setBkgBlNoVO(bkgBlNoVO);
					
					event022901.setXterRqstViaCd(xterEtcInterfaceVO.getXterRqstViaCd());
					event022901.setMstBkgNo(xterEtcInterfaceVO.getMstBkgNo());
					event022901.setXerRqstSeq(xterEtcInterfaceVO.getRqstSeq());
					event022901.setDocTpCd(xterEtcInterfaceVO.getDocTpCd());
					event022901.setPctlNo(xterEtcInterfaceVO.getPctlNo());
					event022901.setCaRsnCd(xterEtcInterfaceVO.getCaRsnCd());
					event022901.setBkgCorrRmk(xterEtcInterfaceVO.getBkgCorrRmk());
					event022901.setBdrFlg(xterEtcInterfaceVO.getBdrFlg());
					event022901.setAutoNotification(xterEtcInterfaceVO.getAutoNotification());
					
					VslSkdVO[] vslSkdVO = command.searchVslSkdInterface(bkgWebServiceVO);
					event022901.setVslSkdVOs(vslSkdVO);
					DocRqstVO docRqstVO = command.searchDocRqstInterface(bkgWebServiceVO);
					event022901.setDocRqstVO(docRqstVO);
					BkgBookingInfoVO bkgBookingInfoVO = command.searchXterBkgInterface(bkgWebServiceVO);
					lodgDueDt = bkgBookingInfoVO.getLodgDueDt();
					event022901.setBkgBookingInfoVO(bkgBookingInfoVO);
					BookingSaveValidationVO bookingSaveValidationVO = command.searchBookingSaveValidationInterface(bkgWebServiceVO);
					event022901.setBookingSaveValidationVO(bookingSaveValidationVO);
					BkgQuantityVO[] bkgQuantityVO = command.searchBkgQuantityInterface(bkgWebServiceVO);
					event022901.setBkgQuantityVOs(bkgQuantityVO);
					BkgQtyDtlVO[] bkgQtyDtlVO = command.searchBkgQtyDtlInterface(bkgWebServiceVO);
					event022901.setBkgQtyDtlVOs(bkgQtyDtlVO);
					BlCustomerInfoVO blCustomerInfoVOSet = command.searchBlCustomerInfoInterface(bkgWebServiceVO);
					event022901.setBlCustomerInfoVO(blCustomerInfoVOSet);
					BkgReferenceVO[] bkgReferenceVO = command.searchBkgReferenceInterface(bkgWebServiceVO);
					event022901.setBkgReferenceVOs(bkgReferenceVO);
					
					account.setOfc_cd(bkgBookingInfoVO.getBkgOfcCd());
					event0229.setEsmBkg022901Event(event022901);
				}
				/*********************************************************************/
				// #.searchXterCustInterface [Customer] - event022902
				/*********************************************************************/
				if("Y".equals(event0229.getSaveCustFlag())){
					event022902.setXterRqstNoVO(xterRqstNoRstVO);
					BlCustomerVO blCustomerVO = command.searchXterCustInterface(bkgWebServiceVO);
					event022902.setBlDocCustVO(blCustomerVO.getBlDocCustVO());
					event022902.setCustEtcVO(blCustomerVO.getCustEtcVO());
					
					event0229.setEsmBkg022902Event(event022902);
				}
	
				/*********************************************************************/
				// #.searchXterTroInterface [TRO] - event022906
				/*********************************************************************/
				if("Y".equals(event0229.getSaveTroFlag())){
					event022906.setXterRqstNoVO(xterRqstNoRstVO);
					event022906.setBkgBlNoVO(bkgBlNoVO);
					TroVO troVO = command.searchXterTroInterface(bkgWebServiceVO);
					troVO.setBkgNo    (bkgBlNoVO.getBkgNo());
					troVO.setIoBndCd("O");
					troVO.setRtnTroFlg("N");
					event022906.setTroVO(troVO);			 
					event022906.setBoundCd  ("O");
					event022906.setRtnTroFlg("N");
					TroMstVO[] arrTroMstVOEur = event022906.getTroVO().getArrTroMstVO();
					event022906.setIsEurFlg(arrTroMstVOEur[0].getIsEur());
					
					event0229.setEsmBkg022906Event(event022906);
				}	
				
				/*********************************************************************/
				// #.searchXterRfInterface [RF] - event022907
				/*********************************************************************/
				if("Y".equals(event0229.getSaveRfFlag())){
					event022907.setXterRqstNoVO(xterRqstNoRstVO);
					event022907.setBkgBlNoVO(bkgBlNoVO);
					BkgRfCgoVO[] bkgRfCgoVO = command.searchXterRfInterface(bkgWebServiceVO);
					event022907.setBkgRfCgoVOs(bkgRfCgoVO);
					
					event0229.setEsmBkg022907Event(event022907);
				}
				
				/*********************************************************************/
				// #.searchXterDgInterface [DG] - event022908
				/*********************************************************************/
				if("Y".equals(event0229.getSaveDgFlag())){
					event022908.setXterRqstNoVO(xterRqstNoRstVO);
					event022908.setBkgBlNoVO(bkgBlNoVO);
					DgCgoListVO[] dgCgoListVOs = command.searchXterDgInterface(bkgWebServiceVO);
					event022908.setDgCgoListVOs(dgCgoListVOs);

					SpclRiderInVO spclRiderInVO 	= new SpclRiderInVO();
					BkgImgStoVO[] bkgImgStoVOs = command.searchXterDgRiderListInterface(bkgWebServiceVO);
					spclRiderInVO.setBkgNo(bkgBlNoVO.getBkgNo());
					spclRiderInVO.setRidrTpCd("D");	// jsp 소스에 하드코딩 되어 있음	// ridr_tp_cd
					spclRiderInVO.setBkgImgStoVOs(bkgImgStoVOs);
					event022908.setSpclRiderInVO(spclRiderInVO);
					
					event0229.setEsmBkg022908Event(event022908);
				}
				
				/*********************************************************************/
				// #.searchXterAkInterface [AK] - event022909
				/*********************************************************************/
				if("Y".equals(event0229.getSaveAkFlag())){
					event022909.setXterRqstNoVO(xterRqstNoRstVO);
					event022909.setBkgBlNoVO(bkgBlNoVO);
					BkgAwkCgoVO[] bkgAwkCgoVO = command.searchXterAkInterface(bkgWebServiceVO);
					event022909.setBkgAwkCgoVOs(bkgAwkCgoVO);
					
					SpclRiderInVO spclRiderInVO 	= new SpclRiderInVO();
					BkgImgStoVO[] bkgImgStoVOs = command.searchXterAkRiderListInterface(bkgWebServiceVO);
					spclRiderInVO.setBkgNo(bkgBlNoVO.getBkgNo());
					spclRiderInVO.setRidrTpCd("A");	// jsp 소스에 하드코딩 되어 있음	// ridr_tp_cd
					spclRiderInVO.setBkgImgStoVOs(bkgImgStoVOs);
					event022909.setSpclRiderInVO(spclRiderInVO);
					
					event0229.setEsmBkg022909Event(event022909);
				}
				/*********************************************************************/
				// #.searchXterBbInterface [BB] - event022912
				/*********************************************************************/
				if("Y".equals(event0229.getSaveBbFlag())){
					event022912.setXterRqstNoVO(xterRqstNoRstVO);
					event022912.setBkgBlNoVO(bkgBlNoVO);
					BkgBbCgoVO[] bkgBbCgoVO = command.searchXterBbInterface(bkgWebServiceVO);
					event022912.setBkgBbCgoVOs(bkgBbCgoVO);
					
					event0229.setEsmBkg022912Event(event022912); 
				}
				
				/*********************************************************************/
				// #.PC
				/*********************************************************************/
		    	//BookingUtil            util  = new BookingUtil();
		    	BookingCreationVO bookingCreationVO = new BookingCreationVO();
				bookingCreationVO.setBkgBookingInfoVO(event022901.getBkgBookingInfoVO());
				bookingCreationVO.setVslSkdVOs(event022901.getVslSkdVOs());
				bookingCreationVO.setBkgBlNoVO(event022901.getBkgBlNoVO());
				bookingCreationVO.setBlCustomerInfoVO(event022901.getBlCustomerInfoVO());
				bookingCreationVO.setBkgQuantityVOs(event022901.getBkgQuantityVOs());
				bookingCreationVO.setBkgQtyDtlVOs(event022901.getBkgQtyDtlVOs());
				
		    	PrdParameterVO prdParameterVO = util.findFullRoute(bookingCreationVO);
				prdParameterVO.setBkgBlNoVO(bkgBlNoVO);
				prdParameterVO.getPrdMainInfoVO().setPcMode("W");
	
				// pc no 생성 
				PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
				ProductCatalogCreateBC productCatalogCreateBC = new ProductCatalogCreateBCImpl();
				//bkg에서 받은 parameter를 prd param vo 로 변경.
				EsdPrd0080Event event = (EsdPrd0080Event)prdCreateManageBc.setPrdCreateParam(prdParameterVO);
		    	event.setAttribute("prdParameterVO", prdParameterVO);
		    	
				eventResponse = createPrdCtlgFullRoutWeb(event);
				
				long diffDays = 1;
				if(event.getPrdCreateParamVO().getPor() != null && !"".equals(event.getPrdCreateParamVO().getPor())){
					if (event.getPrdCreateParamVO().getPor().substring(0, 2).equals("US") || event.getPrdCreateParamVO().getPor().substring(0, 2).equals("CA") ){				
						if(eventResponse.getETCData().get("PCTL_NO") !=null && !"".equals(eventResponse.getETCData().get("PCTL_NO") )){
							DBRowSet rowset = null;
							rowset = new ProductCatalogCreateDBDAO().searchPortCct(eventResponse.getETCData().get("PCTL_NO"));
							String cct = "";
							String lrd = "";
							while( rowset.next()){
								cct = rowset.getString("cct");
							}
							
							Map map = productCatalogCreateBC.getRailRecevingTime(eventResponse.getETCData().get("PCTL_NO"), null, event.getPrdCreateParamVO().getSumBkgQty(), event.getPrdCreateParamVO().getSumCTpSz(), event.getPrdCreateParamVO().getBkgNo());	
							lrd =   map.get("CUT_OFF") == null ? "" : (String)map.get("CUT_OFF");
							
							if(cct !=null && !"".equals(cct)){
								SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
								SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
								Date cctDt = formatter.parse(cct.replace("CCT", "").substring(0,10));
								if(lrd !=null && !"".equals(lrd)){
									cctDt = formatter2.parse(lrd.substring(0,8));
								}
								
								Date today = formatter.parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
								
								long diff = cctDt.getTime() - today.getTime();
						        diffDays = diff / (24 * 60 * 60 * 1000);
							}
						}
					}
				}
				
				// 2016-04-12 CHM-201641039 web bkg auto upload 로직 변경 
				long diffDueDays = 1;
				if(!"".equals(lodgDueDt) && eventResponse.getETCData().get("N1ST_VSL_LODG_DUE_DT") !=null && !"".equals(eventResponse.getETCData().get("N1ST_VSL_LODG_DUE_DT") )){
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					Date dueDt = formatter.parse(eventResponse.getETCData().get("N1ST_VSL_LODG_DUE_DT"));
					
					Date rqstDepDt = formatter.parse(lodgDueDt);
					
					long diff = dueDt.getTime() - rqstDepDt.getTime();
			        diffDueDays = diff / (24 * 60 * 60 * 1000);
			        
			        log.debug("===============================================================");
			        log.debug("[diffDueDays] : " + eventResponse.getETCData().get("N1ST_VSL_LODG_DUE_DT"));
					log.debug("[diffDueDays] : " + diffDueDays);
					log.debug("===============================================================");
				}
				
				event022901.setPctlNo(eventResponse.getETCData().get("PCTL_NO")); 
				event0229.setEsmBkg022901Event(event022901);

				if("".equals(event0229.getEsmBkg022901Event().getPctlNo()) || event0229.getEsmBkg022901Event().getPctlNo() == null || diffDays < 1 || diffDueDays > 10){
					if("".equals(event0229.getEsmBkg022901Event().getPctlNo()) || event0229.getEsmBkg022901Event().getPctlNo() == null){
						bkgWebServiceVO.setPctlExptFlg("Y");
					}
				}else{
					/*********************************************************************/
					// #.UPLOAD
					/*********************************************************************/
					eventResponse = uploadXterRqst(event0229);
					
					//MND 중 Booking Request시 접수되는 Import&Export Licence No만 별도 처리 
					AlpsXptImpLicListVO[] alpsXptImpLicListVO = command.searchAlpsXptImpLicListInterface(bkgWebServiceVO);
					BLDocumentationBLBC blDocBC = new BLDocumentationBLBCImpl();
					blDocBC.manageXptLicByXter(bkgBlNoVO, alpsXptImpLicListVO , account); 
					
					BkgBlNoVO bkgVO = util.searchBkgBlNoVO(bkgBlNoVO);
					
					if(null != bkgVO && !"".equals(bkgVO.getBkgNo()) && null != bkgVO.getBkgNo()) {
						bkgWebServiceVO.setBkgUpldStsCd("F");
						bkgWebServiceVO.setSysUpldFlg("Y");
					}

//					/*********************************************************************/
//					// #.Request
//					/*********************************************************************/					
//					// 한국 TRO 화면의 저장 처리 셋팅
//					// Request Method Call : TRO 정보가 셋팅된 경우 호출 
//                    if("Y".equals(event0229.getSaveTroFlag()) && "KR".equals(event022901.getBkgBookingInfoVO().getBkgPolCd().substring(0, 2))){
//                    	
//                    	if("N".equals(util.searchNoRateBlockFlg(bkgBlNoVO)) && "N".equals(util.searchStandbyBlockFlg(bkgBlNoVO))){
//	                    	//02. Tro 저장
//	                    	TroVO spclTroVO = new TroVO(); 
//	                		TransferOrderIssueBC    command1  = new TransferOrderIssueBCImpl(); 
//	                		GeneralBookingReceiptBC command2   = new GeneralBookingReceiptBCImpl(); 
//	                    	BkgTroSpclCgoSeqVO[] arrBkgTroSpclCgoSeqVO = command.searchXterBkgTroSpclCgoSeqInterface(bkgWebServiceVO);
//	                    	if(arrBkgTroSpclCgoSeqVO.length > 0){
//	                    		spclTroVO.setArrBkgTroSpclCgoSeqVO(arrBkgTroSpclCgoSeqVO);
//	                    		command1.manageKrTro(spclTroVO, account);
//	                    	}
//	
//	                    	//04. Qty 저장
//	                    	BkgQuantityVO[] arrBkgQuantityVO = command.searchBkgQuantityVOInterface(bkgBlNoVO);
//	                    	command2.modifyBkgQtyByTro(arrBkgQuantityVO, "O", account);	//GeneralBookingReceiptBC
//	                      	
//	                    	//1) str_flatfile 생성 - sendTroEdiToHJT에 있던거..
//	                      	TroMstVO[] arrTroMstVO = event022906.getTroVO().getArrTroMstVO();
//							command1.createTroEdi(bkgBlNoVO, arrTroMstVO[0].getTroSeq(), "", arrTroMstVO[0].getRtnTroFlg(),arrTroMstVO[0].getOwnrTrkFlg(), account);
//                    	}          
//                    }
				}
			}
			/* block Auto Upload 원인을 메일로 보낸다. */
			else{
				util.addBkgLog("BKG Auto Upload", xterRqstNoRstVO.getRqstNo(), message);
			}
			
			modifyAutoUploadStatus(bkgWebServiceVO);
			
		} catch (EventException ex) {
			modifyAutoUploadStatus(bkgWebServiceVO);
			throw ex;
		} catch (Exception ex) {
			modifyAutoUploadStatus(bkgWebServiceVO);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * Web Interface Date Setting and Upload<br>
	 *
	 * @param Event e
	 * @return EsmBkg0229Event
	 * @exception EventException
	 */
	private EventResponse xterSIRqstDatasetInterface(Event e) throws EventException {
		EventResponse eventResponse = new GeneralEventResponse();
		
		EsmBkgWeb0090001Event 	eventWeb	= (EsmBkgWeb0090001Event)e;
		EsmBkg0229Event 		event0229 	= new EsmBkg0229Event();
		account = eventWeb.getSignOnUserAccount();
		
		EBookingReceiptBC 		command 	= new EBookingReceiptBCImpl();	
		PerformanceReportBC repCmd = new PerformanceReportBCImpl();
		
		EsmBkg022901Event 		event022901 = new EsmBkg022901Event();	// Booking ESM_BKG_0229
		EsmBkg022902Event 		event022902 = new EsmBkg022902Event();	// Customer ESM_BKG_0229_02
		EsmBkg022903Event 		event022903 = new EsmBkg022903Event();	// Container ESM_BKG_0229_03
		EsmBkg022904Event 		event022904 = new EsmBkg022904Event();	// M&D ESM_BKG_0229_04
		EsmBkg022905Event 		event022905 = new EsmBkg022905Event();	// C/M ESM_BKG_0229_05
		EsmBkg022910Event 		event022910 = new EsmBkg022910Event(); // H B/L 1
		EsmBkg022911Event 		event022911 = new EsmBkg022911Event(); // H B/L 2
		
		BkgWebServiceVO bkgWebServiceVO = eventWeb.getBkgWebServiceVO();
		SIWebServiceVO sIWebServiceVO = new SIWebServiceVO();
		
		XterRqstNoVO xterRqstNoRstVO = command.searchXterRqstNoInterface(bkgWebServiceVO);
		
		bkgWebServiceVO.setBkgNo(xterRqstNoRstVO.getBkgNo());
		sIWebServiceVO.setXterSndrId(bkgWebServiceVO.getXterSndrId());
		sIWebServiceVO.setXterRqstNo(bkgWebServiceVO.getXterRqstNo());
		sIWebServiceVO.setXterRqstSeq(bkgWebServiceVO.getXterRqstSeq());
		sIWebServiceVO.setBkgNo(xterRqstNoRstVO.getBkgNo());
		sIWebServiceVO.setBkgUpldStsCd("N");
		sIWebServiceVO.setSysUpldFlg("N");
		
		try{
			begin();
			
			// BKG Black List 체크			
			String blackList = command.checkBkgBlackList(xterRqstNoRstVO);
			
			if(blackList != null && !"".equals(blackList)){
				commit();
				return eventResponse;
			}
			if(xterRqstNoRstVO != null){
				if(!"S".equals(xterRqstNoRstVO.getDocTpCd())&&!"U".equals(xterRqstNoRstVO.getDocTpCd())){
					sIWebServiceVO.setMnlUpldRsn("This request is not S/I");
					modifySIAutoUploadStatus(sIWebServiceVO);
					return eventResponse;
				}
			} 
			
			// Interface로 Upload된 정보 PreviousStatus Update PRE_SEQ_DELT_FLG ='Y' 일 때 이전 S/I 전부 Delete, 아니면 WEB 이전 Seq. Delete
			command.modifyPreviousSIRequestStatus(xterRqstNoRstVO, account);
			commit();
		}catch(EventException ex){
			rollback();
			sIWebServiceVO.setMnlUpldRsn(ex.getMessage());
			modifySIAutoUploadStatus(sIWebServiceVO);
			throw ex;
		} catch(Exception ex) {
			rollback();
			sIWebServiceVO.setMnlUpldRsn(ex.getMessage());
			modifySIAutoUploadStatus(sIWebServiceVO);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
		
		try{
			sIWebServiceVO = command.searchWebServiceSIProcessType(xterRqstNoRstVO);
			
			if(sIWebServiceVO!=null){
				BookingUtil             util      	= new BookingUtil();
				BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
				bkgHrdCdgCtntListCondVO.setHrdCdgId("EBKG_FORCE_AUTO_UPLD");			
				List<BkgHrdCdgCtntVO> hdcList = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
				boolean forceAutoUpload = false;
				if(hdcList != null && hdcList.size() > 0){
					 for(BkgHrdCdgCtntVO vo : hdcList){
						 if("ON".equals(vo.getAttrCtnt1())){
							 forceAutoUpload = true;
						 }
					 }
				}
			if(!"Y".equals(sIWebServiceVO.getMnlFlg()) || forceAutoUpload){
				/*********************************************************************/
				//#.XterRqstNoVO
				/*********************************************************************/
				//XterRqstNoVO xterRqstNoRstVO = command.searchXterRqstNoInterface(bkgWebServiceVO);
				event0229.setXterRqstNoVO(xterRqstNoRstVO);
				/*********************************************************************/
				//#.BkgBlNoVO
				/*********************************************************************/
				BkgBlNoVO bkgBlNoVO = command.searchBkgBlNoInterface(bkgWebServiceVO);
				event0229.setBkgBlNoVO(bkgBlNoVO);
	
				/*********************************************************************/
				//#.xterEtcInterfaceVO
				/*********************************************************************/
				XterEtcInterfaceVO xterEtcInterfaceVO = command.searchXterEtcInterface(bkgWebServiceVO);
				event0229.setRqstNo(xterEtcInterfaceVO.getAutoNotification());
				event0229.setFaxLogRefNo(xterEtcInterfaceVO.getFaxLogRefNo());
				event0229.setSenderId(xterEtcInterfaceVO.getSenderId());
				
				event0229.setSaveBkgFlag (xterEtcInterfaceVO.getSaveBkgFlag());
				event0229.setSaveCustFlag(xterEtcInterfaceVO.getSaveCustFlag());
				event0229.setSaveCntrFlag(xterEtcInterfaceVO.getSaveCntrFlag());
				event0229.setSaveMndFlag (xterEtcInterfaceVO.getSaveMndFlag());
				event0229.setSaveCmFlag  (xterEtcInterfaceVO.getSaveCmFlag());
				event0229.setSaveTroFlag (xterEtcInterfaceVO.getSaveTroFlag());
				event0229.setSaveRfFlag  (xterEtcInterfaceVO.getSaveRfFlag());
				event0229.setSaveDgFlag  (xterEtcInterfaceVO.getSaveDgFlag());
				event0229.setSaveAkFlag  (xterEtcInterfaceVO.getSaveAkFlag());
				event0229.setSaveBbFlag  (xterEtcInterfaceVO.getSaveBbFlag());
				event0229.setSaveHblFlag (xterEtcInterfaceVO.getSaveHblFlag());
				event0229.setSaveHbl2Flag(xterEtcInterfaceVO.getSaveHbl2Flag());
				
				ContainerVO[] containerVOs = null;
				String actWgt ="";
				String wgtUtCd = "";
				String pckQty = "";
				String pckTpCd = "";
				String podCd = "";
				
				/*********************************************************************/
				// #.searchXterBkgInterface [Booking] - event022901	
				/*********************************************************************/
				if("Y".equals(event0229.getSaveBkgFlag())){
					FormCommand f = new FormCommand();
					f.setCommand(FormCommand.MULTI04);
					event022901.setFormCommand(f);
					event022901.setXterRqstNoVO(xterRqstNoRstVO);
					event022901.setBkgBlNoVO(bkgBlNoVO);
					
					event022901.setXterRqstViaCd(xterEtcInterfaceVO.getXterRqstViaCd());
					event022901.setMstBkgNo(xterEtcInterfaceVO.getMstBkgNo());
					event022901.setXerRqstSeq(xterEtcInterfaceVO.getRqstSeq());
					event022901.setDocTpCd(xterEtcInterfaceVO.getDocTpCd());
					event022901.setPctlNo(xterEtcInterfaceVO.getPctlNo());
					if("Y".equals(xterEtcInterfaceVO.getBdrFlg())){
						event022901.setCaRsnCd("M");
						event022901.setBkgCorrRmk("Web S/I Auto");
					}
					event022901.setBdrFlg(xterEtcInterfaceVO.getBdrFlg());
					event022901.setAutoNotification(xterEtcInterfaceVO.getAutoNotification());
					
					//생성된 BKG_VVD에서 가져옴
					VslSkdVO[] vslSkdVO = command.searchVslSkdInterface(bkgWebServiceVO);
					event022901.setVslSkdVOs(vslSkdVO);
					//생성된 BKG_BL_ISS 에서 가져옴
					DocRqstVO docRqstVO = command.searchDocRqstInterface(bkgWebServiceVO);
					event022901.setDocRqstVO(docRqstVO);
					
					BkgBookingInfoVO bkgBookingInfoVO = command.searchXterSIInterface(sIWebServiceVO);
					event022901.setBkgBookingInfoVO(bkgBookingInfoVO);
					podCd = bkgBookingInfoVO.getBkgPodCd();
					
					BookingSaveValidationVO bookingSaveValidationVO = command.searchSISaveValidationInterface(sIWebServiceVO);					
					event022901.setBookingSaveValidationVO(bookingSaveValidationVO);
					
					BkgQuantityVO[] bkgQuantityVO = command.searchSIBkgQuantityInterface(sIWebServiceVO);
					event022901.setBkgQuantityVOs(bkgQuantityVO);
					
					BkgQtyDtlVO[] bkgQtyDtlVO = command.searchSIBkgQtyDtlInterface(sIWebServiceVO);
					event022901.setBkgQtyDtlVOs(bkgQtyDtlVO);
					
					BlCustomerInfoVO blCustomerInfoVOSet = command.searchBlCustomerInfoInterface(bkgWebServiceVO);
					event022901.setBlCustomerInfoVO(blCustomerInfoVOSet);
					BkgReferenceVO[] bkgReferenceVO = command.searchBkgReferenceInterface(bkgWebServiceVO);
					event022901.setBkgReferenceVOs(bkgReferenceVO);
					
					account.setOfc_cd(bkgBookingInfoVO.getBkgOfcCd());
					event0229.setEsmBkg022901Event(event022901);
				}
				/*********************************************************************/
				// #.searchXterCustInterface [Customer] - event022902
				/*********************************************************************/
				if("Y".equals(event0229.getSaveCustFlag())){
					event022902.setXterRqstNoVO(xterRqstNoRstVO);
					BlCustomerVO blCustomerVO = command.searchXterCustInterface(bkgWebServiceVO);
					event022902.setBlDocCustVO(blCustomerVO.getBlDocCustVO());
					event022902.setCustEtcVO(blCustomerVO.getCustEtcVO());
					
					event0229.setEsmBkg022902Event(event022902);
				}				
				
				
				/*********************************************************************/
				// #.searchXterCntrInterface [Container] - event022903
				/*********************************************************************/
				if("Y".equals(event0229.getSaveCntrFlag())){
					
					CntrEtcInfoVO bkgEtcInfoVO = command.searchXterSIEtcInfoForCntr(sIWebServiceVO);					
					containerVOs =  command.searchXterSIContainer(sIWebServiceVO) ;
					 BkgCntrSealNoVO[] bkgCntrSealNoVOs = command.searchXterSISealNo(sIWebServiceVO);
					
					event022903.setBkgEtcInfoVO(bkgEtcInfoVO);
					event022903.setContainerVOs(containerVOs);
					event022903.setBkgCntrSealNoVOs(bkgCntrSealNoVOs);
			        
			        event0229.setEsmBkg022903Event(event022903);
				}
				
				/*********************************************************************/
				// #.searchXterMndInterface [M&D] - event022904
				/*********************************************************************/
				if("Y".equals(event0229.getSaveMndFlag())){
					
					MndVO mndVO = command.searchXterSIMnd(sIWebServiceVO);
					{						
						BLDocumentationBLBC blBC = new BLDocumentationBLBCImpl();
						String porCd = mndVO.getPorCd();
			            String polCd = mndVO.getPolCd();
			            //String podCd = mndVO.getPodCd();
			            String delCd = mndVO.getDelCd();
			            String cmdtDesc = mndVO.getDgCmdtDesc();
			            String bkgNo = mndVO.getBkgNo();
			            String caFlg = bkgBlNoVO.getCaFlg();
			            
			            //2012.10.25  Booking 의 DEL이 BR 인 경우 B/L 자동 문구 추가
			            if(delCd !=null && delCd.length()> 2 && "BR".equals(delCd.substring(0, 2))){
			                mndVO.setDgCmdtDesc((cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_BR, "").replace(Constants.CMDT_DESC_ATTD_BR_OLD, ""));
			            }
			            //2012.10.25  Booking 의 POD이 UY,AR 인 경우 B/L 자동 문구 추가
			            if(podCd !=null && podCd.length()> 2 && ("UY".equals(podCd.substring(0, 2)) || "AR".equals(podCd.substring(0, 2)))){
			                mndVO.setDgCmdtDesc((cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_UY, ""));
			            }
			            if((porCd !=null && porCd.length()> 2 && "MX".equals(porCd.substring(0, 2))) ||
			               (polCd !=null && polCd.length()> 2 && "MX".equals(polCd.substring(0, 2))) ||
			               (podCd !=null && podCd.length()> 2 && "MX".equals(podCd.substring(0, 2))) ||
			               (delCd !=null && delCd.length()> 2 && "MX".equals(delCd.substring(0, 2)))){
			            	mndVO.setDgCmdtDesc((cmdtDesc == null) ? "" :cmdtDesc.indexOf("\r") == -1 ? cmdtDesc.replace(Constants.CMDT_DESC_ATTD_MX.replace("\r", ""), "") : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_MX, ""));
			            }
			            if((delCd !=null && !"GTPRQ".equals(delCd.substring(0, 2))) &&
			               (porCd !=null && porCd.length()> 2 && "GT".equals(porCd.substring(0, 2))) ||
			               (polCd !=null && polCd.length()> 2 && "GT".equals(polCd.substring(0, 2))) ||
			               (podCd !=null && podCd.length()> 2 && "GT".equals(podCd.substring(0, 2))) ||
			               (delCd !=null && delCd.length()> 2 && "GT".equals(delCd.substring(0, 2)))){
			                mndVO.setDgCmdtDesc((cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_GT, ""));
			            }
			            if((podCd !=null && podCd.length()> 2 && "GR".equals(podCd.substring(0,2))) ||
			               (delCd !=null && delCd.length()> 2 && "GR".equals(delCd.substring(0,2)))){			            	
			            	   mndVO.setDgCmdtDesc((cmdtDesc == null) ? "" : cmdtDesc.indexOf("\r") == -1 ? cmdtDesc.replace(Constants.CMDT_DESC_ATTD_GR_WEB.replace("\r", ""), "") : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_GR_WEB, ""));			            	
			            }
			            if((podCd !=null && podCd.length()> 2 && "EG".equals(podCd.substring(0,2))) ||
			               (delCd !=null && delCd.length()> 2 && "EG".equals(delCd.substring(0,2)))){			            	
			            	   mndVO.setDgCmdtDesc((cmdtDesc == null) ? "" : cmdtDesc.indexOf("\r") == -1 ? cmdtDesc.replace(Constants.CMDT_DESC_ATTD_EG_WEB.replace("\r", ""), "") : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_EG_WEB, ""));
			            }
			            if((podCd !=null && podCd.length()> 2 && "SA".equals(podCd.substring(0,2))) ||
			                    (delCd !=null && delCd.length()> 2 && "SA".equals(delCd.substring(0,2)))){
			            	mndVO.setDgCmdtDesc((cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_SA, ""));
			            }
			            
			            if((podCd !=null && podCd.length()> 2 && "IRBND".equals(podCd)) ||
			                    (delCd !=null && delCd.length()> 2 && "IRBND".equals(delCd))){
							mndVO.setDgCmdtDesc((cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_IRBND_WEB, ""));
						}
			            
			            /* POD 가 JOAQJ 일 경우  Tariff 항목 추가 Reefer cargo free time 은 6일 로 변경 */
			            if((podCd !=null && "JOAQJ".equals(podCd))){
			            	//BlAppWordVO blAppWordVo = dbDao.searchBlAppWord(bkgBlNoVO.getBkgNo());
			            	mndVO.setDgCmdtDesc((cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_JOAQJ_CONSOL_CARGO_WEB, "").replace(Constants.CMDT_DESC_ATTD_JOAQJ, ""));//			            	
			            }
			            
			            /* POD 가 KHPNH 일 경우(Last POL:VNSGN (Y2) -> Last POD:KNPNH(Y4))  Tariff 항목 추가 */
			            List<VslSkdVO> routeDetails = blBC.searchVvdSkdForTsRouteKNPNH(bkgNo, caFlg);
			            if(routeDetails != null && routeDetails.size() > 0){
							if(routeDetails.get(routeDetails.size() - 1).getPolCd().equals(Constants.BL_CLAUSE_POL)
									&& routeDetails.get(routeDetails.size() - 1).getPodCd().equals(Constants.BL_CLAUSE_POD)){	            
				            	mndVO.setDgCmdtDesc((cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_KHPNH, ""));
				            }
			            }
			            
			            String syFlg = blBC.searchMndTsSyFlg(mndVO.getBkgNo());
			            /* POD , DEL 의 국가코드가 SY 일 경우  Tariff 항목 추가 */
			            if ((podCd !=null && podCd.length() >= 2 && "SY".equals(podCd.substring(0,2)))||
			                    (delCd !=null && delCd.length() >= 2 && "SY".equals(delCd.substring(0,2)))||
			                    (podCd !=null && podCd.length() >= 2 &&  "Y".equals(syFlg))){
			                 	   mndVO.setDgCmdtDesc((cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_SY, ""));
			                 }
			            
			            // POD 또는 DEL의 국가코드가 DZ 일 경우 Tariff 강제 적용, POR, POL의 국가 코드가 US 일 경우는 에외
			            //2015.03.18 US일 경우 auto-clause추가
			            if((podCd !=null && podCd.length()> 2 && "DZ".equals(podCd.substring(0,2))) ||
			                    (delCd !=null && delCd.length()> 2 && "DZ".equals(delCd.substring(0,2)))){
			            	if((porCd !=null && porCd.length()> 2 && "US".equals(porCd.substring(0,2))) ||
			                        (polCd !=null && polCd.length()> 2 && "US".equals(polCd.substring(0,2)))){	
			            		mndVO.setDgCmdtDesc((cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_US_DZ, ""));  
			            	}else{
			            		mndVO.setDgCmdtDesc((cmdtDesc == null) ? "" : cmdtDesc.replace(Constants.CMDT_DESC_ATTD_DZ_DRY, "").replace(Constants.CMDT_DESC_ATTD_DZ_SPCL, "").replace(Constants.CMDT_DESC_ATTD_DZ, ""));
			            	}
			            }
			            
					}
					event022904.setMndVO(mndVO);
			        
					actWgt = mndVO.getActWgt();
					wgtUtCd = mndVO.getWgtUtCd();
					pckQty = mndVO.getPckQty();
					pckTpCd = mndVO.getPckTpCd();

					BkgReferenceVO[] poOtherBkgRefVOs 	=  command.searchXterSIPoOtherNoBkg(sIWebServiceVO);				
					BkgReferenceVO[] poOtherCntrVOs 	= command.searchXterSIPoOtherCntr(sIWebServiceVO);
					BkgRefDtlVO[] 	 poOtherCmVOs 		=command.searchXterSIPoOtherCm(sIWebServiceVO);
					//BkgRefDtlVO[]  poOtherShipVOs 	= (BkgRefDtlVO[])getVOs(request, BkgRefDtlVO.class,"t4_sheet9_");
					BlRiderVO[] 	 blRiderVOs 		= command.searchXterSIBlRider(sIWebServiceVO);  //B/L rider
					//KrWhfBlExptInfoVO[] krWhfBlExptInfoVOs = (KrWhfBlExptInfoVO[])getVOs(request, KrWhfBlExptInfoVO.class,"t4_sheet6_");  
					AlpsXptImpLicListVO[] alpsXptImpLicListVOs = command.searchXterSIXptImpLicList(sIWebServiceVO);
					XptImpLicVO[] idXptImpLicVOs =  command.searchXterSIIdXptImpLicList(sIWebServiceVO);
					
					event022904.setPoOtherNoBkgVOs(poOtherBkgRefVOs);
					event022904.setPoOtherCntrVOs(poOtherCntrVOs);
					event022904.setPoOtherCmVOs(poOtherCmVOs);
					//event022904.setPoOtherShipVOs(poOtherShipVOs);
					event022904.setBlRiderVOs(blRiderVOs);
					//event022904.setKrWhfBlExptInfoVOs(krWhfBlExptInfoVOs);
					event022904.setAlpsXptImpLicListVOs(alpsXptImpLicListVOs);
					event022904.setIdXptImpLicVOs(idXptImpLicVOs);
					event0229.setEsmBkg022904Event(event022904);
					
					begin();
					command.modifySIOldMkDesc(sIWebServiceVO);
					commit();
				}			
		    	
				/*********************************************************************/
				// #.searchXterCmInterface [C/M] - event022905
				/*********************************************************************/
				if("Y".equals(event0229.getSaveCmFlag())){
					event022905.setContainerVOs(containerVOs);
			        
					CmBkgInfoVO cmBkgInfoVO = new CmBkgInfoVO();
			        
		            // M&D에서 PCK, WGT 값을 가지고 오기 위해서
					cmBkgInfoVO.setBkgNo(bkgBlNoVO.getBkgNo());
					cmBkgInfoVO.setBkgWgtQty(actWgt);
					cmBkgInfoVO.setBkgWgtUnit(wgtUtCd);
					cmBkgInfoVO.setBkgPckQty(pckQty);
					cmBkgInfoVO.setBkgPckUnit(pckTpCd);
					cmBkgInfoVO.setPodCd(podCd);
		            
		            CmVO cmVO = new CmVO();
		            cmVO.setCmBkgInfoVO(cmBkgInfoVO);

		            List<BkgCntrMfDescVO> bkgCntrMfDescVoList = command.searchXterSICntrMfDesc(sIWebServiceVO);
		            
		            cmVO.setCntrMfDescVOs(bkgCntrMfDescVoList);
		            event022905.setCmVO(cmVO);	            
			        
			        event0229.setEsmBkg022905Event(event022905);
				}			
				
				/*********************************************************************/
				// #.House B/L - event022910
				/*********************************************************************/
				if("Y".equals(event0229.getSaveHblFlag())){
			        
					// EBookingConduct에 manageHbl 에서 사용할 parameter를 HblVO Container VO에 담기 시작한다
					event022910.setXterRqstNoVO(xterRqstNoRstVO);
					event022910.setBkgBlNoVO(bkgBlNoVO);
					
		            List<HblDtlInfoVO> hblDtlInfoVOs = command.searchXterSIHbl1(sIWebServiceVO);
		            
		            HblVO hblVO = new HblVO();
		            hblVO.setHblDtlInfoVOs(hblDtlInfoVOs);
		            event022910.setHblVO(hblVO);	            
		            event0229.setEsmBkg022910Event(event022910);
				}			
				
				/*********************************************************************/
				// #.House B/L2 - event022911
				/*********************************************************************/
				if("Y".equals(event0229.getSaveHbl2Flag())){
					// EBookingConduct에 manageHbl 에서 사용할 parameter를 HblVO Container VO에 담기 시작한다
					event022911.setXterRqstNoVO(xterRqstNoRstVO);
					event022911.setBkgBlNoVO(bkgBlNoVO);
					
					event022911.setBkgUsaCstmsFileNoVOs( command.searchXterSIHbl2(sIWebServiceVO));				
					event0229.setEsmBkg022911Event(event022911);
				}			
				
				
				/*********************************************************************/
				// #.UPLOAD
				/*********************************************************************/
				eventResponse = uploadXterRqst(event0229);				
				
				// 업로드 확인 후 상태 업데이트
				String xterBkgSts;
				xterBkgSts = command.searchXterBkgSts(xterRqstNoRstVO);
				if("F".equals(xterBkgSts) ){				
					sIWebServiceVO.setBkgUpldStsCd("F");
					sIWebServiceVO.setSysUpldFlg("Y");
					sIWebServiceVO.setSiAudFlg("N");
					sIWebServiceVO.setMnlUpldRsn("");
					
					
					/*********************************************************************/
					// #.CMPB Rate I/F
					/*********************************************************************/
					
					if("Y".equals(sIWebServiceVO.getCmpbRtFlg())){
						
						try{
						
							RfaOftAutoRatingBC rfaCmd = new RfaOftAutoRatingBCImpl();
							ScOftAutoRatingBC scCmd= new ScOftAutoRatingBCImpl();
							TaaOftAutoRatingBC taaCmd = new TaaOftAutoRatingBCImpl();
							BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
							BlRatingBC ratingCmd = new BlRatingBCImpl();
							BookingUtil utilCmd = new BookingUtil();  
							
							HistoryTableVO historyTableVO = historyBC.searchOldBkgForHistory("IF_ESM_BKG_RATE", bkgBlNoVO);
//							List<BkgXterChgRtVO> bkgCmpbRtVOs= command.searchXterSIChgRt(sIWebServiceVO);
							List<BkgXterChgRtVO> bkgCmpbRtVOs= command.searchCmpbChgRt(sIWebServiceVO);
							
							RateMainInfoVO rateMainInfoVO = new RateMainInfoVO();
							ScOftAutoratingListVO surVo = new ScOftAutoratingListVO();
							List<SearchScOftAutoratingListVO> trfSurList = null;		
							
							String sc_no = event022901.getBkgBookingInfoVO().getScNo();
							String rfa_no = event022901.getBkgBookingInfoVO().getRfaNo();
							String taa_no = event022901.getBkgBookingInfoVO().getTaaNo();
							String applicationDt = "";
							String ctrtTpCd ="";
							String ctrtNo = "";
							String cmdtCd = event022901.getBkgBookingInfoVO().getCmdtCd();
							String svcScpCd = event022901.getBkgBookingInfoVO().getSvcScpCd();
							String frtTermCd = event022904.getMndVO().getFrtTermCd();
							
							if(rfa_no!=null && rfa_no.length() > 2 ){
								applicationDt = rfaCmd.searchPreCheckRtAplyDt(bkgBlNoVO.getBkgNo(), "N");
								ctrtTpCd ="R";
								ctrtNo = rfa_no;
							}else if(sc_no!=null && sc_no.length() > 2 ){
								applicationDt = scCmd.searchPreCheckRtAplyDt(bkgBlNoVO.getBkgNo(), "N");
								ctrtTpCd ="S";
								ctrtNo = sc_no;
							}else if(taa_no!=null && taa_no.length() > 2 ){
								applicationDt = taaCmd.searchPreCheckRtAplyDt(bkgBlNoVO.getBkgNo(), "N");
								ctrtTpCd="T";
								ctrtNo = taa_no;
							}
							
							rateMainInfoVO.setBkgNo(bkgBlNoVO.getBkgNo());
							rateMainInfoVO.setFrtTermCd(frtTermCd); 
							rateMainInfoVO.setRtAplyDt(applicationDt);
							rateMainInfoVO.setCalcCtrtTpCd(ctrtTpCd);
							rateMainInfoVO.setUserId(account.getUsr_id());	
							if(bkgCmpbRtVOs != null && bkgCmpbRtVOs.size()>0){
								rateMainInfoVO.setPrcGenSpclRtTpCd(bkgCmpbRtVOs.get(0).getGenSpclRtTpCd());
								rateMainInfoVO.setPrcCmdtHdrSeq(bkgCmpbRtVOs.get(0).getCmdtHdrSeq());
								rateMainInfoVO.setPrcRoutSeq(bkgCmpbRtVOs.get(0).getRoutSeq());

								if(null != bkgCmpbRtVOs.get(0).getMstRfaRoutId() 
										&& !"".equals(bkgCmpbRtVOs.get(0).getMstRfaRoutId())){
									rateMainInfoVO.setMstRfaRoutId(bkgCmpbRtVOs.get(0).getMstRfaRoutId());
								}
								
								if("".equals(svcScpCd)){
									svcScpCd = bkgCmpbRtVOs.get(0).getSvcScpCd();
								}
							}
							ratingCmd.manageGroupRating(rateMainInfoVO, account);        
							
							command.addSiBkgChgRate(sIWebServiceVO, account);		
							
							// OFT tmp테이블 생성
							ratingCmd.createOcnFrtTmpByChgRt(bkgBlNoVO.getBkgNo());
							
							//Tariff Rating 실행
					        surVo.setBkgNo(bkgBlNoVO.getBkgNo());
					        surVo.setCaFlg("N");
					        surVo.setCmdtCd(cmdtCd);
					        surVo.setsvcScpCd(svcScpCd);
					        surVo.setCtrtTpCd(ctrtTpCd);
					        surVo.setRtAplyDt(applicationDt);
					        surVo.setRtAudTpCd("");
					        surVo.setCtrtNo(ctrtNo);
					        surVo.setFrtTermCd(frtTermCd);
					        
					        trfSurList = scCmd.searchTariffSurchargeAutoratingList(surVo);
					        ratingCmd.addTariffSurchargeRate(trfSurList, "N", account);
							
							interfaceToInv(bkgBlNoVO, account);
							interfaceToMas(bkgBlNoVO, "E-Booking Create", account);
							
							List<SearchFocByFreightListVO>  searchFocByFreightListVO = null;
			                
				            searchFocByFreightListVO = ratingCmd.searchFocByFreightList(bkgBlNoVO.getBkgNo(),"N");
				            
				            if(searchFocByFreightListVO != null && searchFocByFreightListVO.size() > 0 ){
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
										utilCmd.addBkgLog("BKG_US_CGO_SWB", bkgBlNoVO.getBlNo(), "12.Go");					
										cargoBC.setupFocByFreight(frtCltLst);
									}catch(Exception e1){
										log.debug("[end:: CargoReleaseOrderBC == manageRate update ]==========");
										log.error(e1.getMessage()); // 2011.07.15
									}
								} 
				            }
							utilCmd.addBkgLog("BKG_US_CGO_SWB", bkgBlNoVO.getBlNo(), "Rate CHARGE END");
							
							try{
								historyBC.manageBookingHistory("IF_ESM_BKG_RATE", historyTableVO, account);
							}catch(Exception e2){
								log.error(e2.getMessage()); // 2011.07.15
							}
							
							UnmatchBLBC unmatchCmd = new UnmatchBLBCImpl();
							unmatchCmd.searchSelfAuditListBackEndJob(sIWebServiceVO.getBlNo(), "N", account);
						
						} catch(Exception rtEx){
							log.error("err " + rtEx.toString(), rtEx);
						}	
					}
					/*********************************************************************/
					// #. DPCS Queue Status 변경
					/*********************************************************************/
					
					repCmd.modifyQueueByAutoUpload(bkgWebServiceVO);
					
				}
				
				modifySIAutoUploadStatus(sIWebServiceVO);
				
						
				
			} else {			
				
				//Rate discrepancy Notice			
				if("Y".equals(sIWebServiceVO.getChgMod())){
					
					String ssoTargetUrl = JSPUtil.getNull(SiteConfigFactory.get("COM.HANJIN.SSO.TARGET"));
					List<BkgNtcHisVO> bkgNtcHisVOs = null;
					 boolean isLive = false;     // Live 여부
					 if (ssoTargetUrl.indexOf("alps.smlines.com") > 0) {
		               isLive = true;
					 } 
					 
					if(isLive){
						BookingHistoryMgtBC 	historyBC	= new BookingHistoryMgtBCImpl();
						bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
						BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
						String sndId = null;
						Mail mail = null;
						String mailContents = null;				
						String srepEml = command.searchXterSISrepEml(sIWebServiceVO);
						
						if(srepEml != null && srepEml.length() > 0){
							List<BkgXterChgRtVO> bkgXterChgRtVOs= command.searchXterSIChgRt(sIWebServiceVO);						
							
							StringBuffer contentSb = new StringBuffer();
							
							contentSb.append("<b>Rate discrepancy Notice (Booking No. "+sIWebServiceVO.getBkgNo()+" )</b>");						
							contentSb.append("<br><br>Dear Staff, ");						
							contentSb.append("<br><br>You have your customer's amendment request on freight & charges after rating, probably due to incorrect rate filing, misrating, incorrect commodidty classification and so on.");
							contentSb.append("<br>Your origin documentation staff will rely on autorating, so wouldn't accept the request.");
							contentSb.append("<br>It would be better for you to figure out the right one to charge in order to avoid any further rate dispute.");						
							contentSb.append("<br><br>Hereunder, you can see the difference.<br><br> ");
							
							contentSb.append("<table border='0' cellspacing='0' cellpadding='0' width='740' style='width:554.85pt;margin-left:-1.15pt;border-collapse:collapse'>");
							contentSb.append("	<tr>");
							contentSb.append("		<td width='80' nowrap='' valign='bottom' style='width:189.35pt;border:solid windowtext 1.0pt;background:#B6DDE8;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
							contentSb.append("			<p><b><span lang='EN-US' style='font-size:8.0pt;color:#1F497D'>Charge</span></b></p>");
							contentSb.append("		</td>");
							contentSb.append("		<td width='100' nowrap='' valign='bottom' style='width:77.8pt;border:solid windowtext 1.0pt;border-left:none;background:#B6DDE8;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
							contentSb.append("			<p><b><span lang='EN-US' style='font-size:8.0pt;color:#1F497D'>Contract #</span></b></p>");
							contentSb.append("		</td>");
							contentSb.append("		<td width='80' nowrap='' valign='bottom' style='width:52.9pt;border:solid windowtext 1.0pt;border-left:none;background:#B6DDE8;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
							contentSb.append("			<p><b><span lang='EN-US' style='font-size:8.0pt;color:#1F497D'>Currency</span></b></p>");
							contentSb.append("		</td>");
							contentSb.append("		<td width='80' nowrap='' valign='bottom' style='width:62.75pt;border:solid windowtext 1.0pt;border-left:none;background:#B6DDE8;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
							contentSb.append("			<p><b><span lang='EN-US' style='font-size:8.0pt;color:#1F497D'>Rate</span></b></p>");
							contentSb.append("		</td>");
							contentSb.append("		<td width='80' nowrap='' valign='bottom' style='width:57.35pt;border:solid windowtext 1.0pt;border-left:none;background:#B6DDE8;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
							contentSb.append("			<p><b><span lang='EN-US' style='font-size:8.0pt;color:#1F497D'>Rate as</span></b></p>");
							contentSb.append("		</td>");
							contentSb.append("		<td width='80' nowrap='' valign='bottom' style='width:114.7pt;border:solid windowtext 1.0pt;border-left:none;background:#B6DDE8;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
							contentSb.append("			<p><b><span lang='EN-US' style='font-size:8.0pt;color:#1F497D'>Per</span></b></p>");
							contentSb.append("		</td>");
							contentSb.append("		<td width='100' nowrap='' valign='bottom' style='width:114.7pt;border:solid windowtext 1.0pt;border-left:none;background:#B6DDE8;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
							contentSb.append("			<p><b><span lang='EN-US' style='font-size:8.0pt;color:#1F497D'>Amount</span></b></p>");
							contentSb.append("		</td>");
							contentSb.append("		<td width='100' nowrap='' valign='bottom' style='width:114.7pt;border:solid windowtext 1.0pt;border-left:none;background:#B6DDE8;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
							contentSb.append("			<p><b><span lang='EN-US' style='font-size:8.0pt;color:#1F497D'>Freight Term</span></b></p>");
							contentSb.append("		</td>");
							contentSb.append("	</tr>");
							
							for (int i=0 ; i<bkgXterChgRtVOs.size();i++){
								contentSb.append("	<tr>");
								contentSb.append("		<td width='80' nowrap='' valign='bottom' style='width:189.35pt;border:solid windowtext 1.0pt;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
								contentSb.append("			<span lang='EN-US' style='font-size:8.0pt;'>"+ bkgXterChgRtVOs.get(i).getChgCd() +"</span>");
								contentSb.append("		</td>");
								contentSb.append("		<td width='100' nowrap='' valign='bottom' style='width:77.8pt;border:solid windowtext 1.0pt;border-left:none;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
								contentSb.append("			<span lang='EN-US' style='font-size:8.0pt;'>"+ bkgXterChgRtVOs.get(i).getTrfItmNo() +"</span>");
								contentSb.append("		</td>");
								contentSb.append("		<td width='80' nowrap='' valign='bottom' style='width:52.9pt;border:solid windowtext 1.0pt;border-left:none;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
								contentSb.append("			<span lang='EN-US' style='font-size:8.0pt;'>"+ bkgXterChgRtVOs.get(i).getCurrCd()+"</span>");
								contentSb.append("		</td>");
								contentSb.append("		<td width='80' nowrap='' valign='bottom' style='width:62.75pt;border:solid windowtext 1.0pt;border-left:none;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
								contentSb.append("			<span lang='EN-US' style='font-size:8.0pt;'>"+ bkgXterChgRtVOs.get(i).getRatUtCd() +"</span>");
								contentSb.append("		</td>");
								contentSb.append("		<td width='80' nowrap='' valign='bottom' style='width:57.35pt;border:solid windowtext 1.0pt;border-left:none;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
								contentSb.append("			<span lang='EN-US' style='font-size:8.0pt;'>"+ bkgXterChgRtVOs.get(i).getRatAsQty() +"</span>");
								contentSb.append("		</td>");
								contentSb.append("		<td width='80' nowrap='' valign='bottom' style='width:57.35pt;border:solid windowtext 1.0pt;border-left:none;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
								contentSb.append("			<span lang='EN-US' style='font-size:8.0pt;'>"+ bkgXterChgRtVOs.get(i).getChgUtAmt()+"</span>");
								contentSb.append("		</td>");
								contentSb.append("		<td width='100' nowrap='' valign='bottom' style='width:57.35pt;border:solid windowtext 1.0pt;border-left:none;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
								contentSb.append("			<span lang='EN-US' style='font-size:8.0pt;'>"+ bkgXterChgRtVOs.get(i).getChgAmt()+"</span>");
								contentSb.append("		</td>");
								contentSb.append("		<td width='100' nowrap='' valign='bottom' style='width:57.35pt;border:solid windowtext 1.0pt;border-left:none;padding:0cm 5.4pt 0cm 5.4pt;height:15.0pt'>");
								contentSb.append("			<span lang='EN-US' style='font-size:8.0pt;'>"+ bkgXterChgRtVOs.get(i).getFrtTermCd() +"</span>");
								contentSb.append("		</td>");
								contentSb.append("	</tr>");
							}
							contentSb.append("</table>");						
							
							contentSb.append("<br><br><br>This is a system-generated mail and you are not to reply.");
							contentSb.append("<br>Thank you very much");							
							contentSb.append("<br><br><br>Best regards,");						
								
							mailContents = contentSb.toString();
							
							mail = new Mail();
							mail.setFrom("noreply@smlines.com");// 보내는사람
							mail.setRecipient(srepEml);// 받는사람
							mail.setSubject("Rate discrepancy Notice (Booking No. "+sIWebServiceVO.getBkgNo()+" )");// 제목
							mail.setHtmlContent(mailContents);
							sndId = mail.send();// 메일전송
							//발송 history 내용 생성
							bkgNtcHisVO = new BkgNtcHisVO();
							bkgNtcHisVO.setBkgNo(sIWebServiceVO.getBkgNo());
							bkgNtcHisVO.setNtcViaCd("M");
							bkgNtcHisVO.setNtcKndCd("RD"); // Rate discrepancy Notice
							bkgNtcHisVO.setNtcEml(srepEml);
							bkgNtcHisVO.setSndId(sndId);
							bkgNtcHisVO.setSndOfcCd("SYSTEM");
							bkgNtcHisVO.setSndUsrId("SYSTEM");
							bkgNtcHisVO.setSndRqstDt((new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date()));
							bkgNtcHisVO.setCreUsrId(account.getUsr_id());
							bkgNtcHisVO.setUpdUsrId(account.getUsr_id());
							bkgNtcHisVOs.add(bkgNtcHisVO);
							
							historyBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0079_01");
						}
					}	
				}
				
				modifySIAutoUploadStatus(sIWebServiceVO);
			}
			} else{
				sIWebServiceVO = new SIWebServiceVO();
				sIWebServiceVO.setXterSndrId(bkgWebServiceVO.getXterSndrId());
				sIWebServiceVO.setXterRqstNo(bkgWebServiceVO.getXterRqstNo());
				sIWebServiceVO.setXterRqstSeq(bkgWebServiceVO.getXterRqstSeq());
				if(xterRqstNoRstVO != null){
					sIWebServiceVO.setBkgNo(xterRqstNoRstVO.getBkgNo());
				}
				sIWebServiceVO.setBkgUpldStsCd("N");
				sIWebServiceVO.setSysUpldFlg("N");
				
				modifySIAutoUploadStatus(sIWebServiceVO);
			}
			
		} catch (EventException ex) {
			sIWebServiceVO.setMnlUpldRsn(ex.getMessage());
			modifySIAutoUploadStatus(sIWebServiceVO);
			throw ex;
		} catch (Exception ex) {
			sIWebServiceVO.setMnlUpldRsn(ex.getMessage());
			modifySIAutoUploadStatus(sIWebServiceVO);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * web bkg 에서 호풀
	 * 이 메소드는 bkg에서 pc를 돌려 1개이상일때 호출되는거므로 
	 * pc생성후 1개인지 아닌지를 체크할 필요없음.
	 * mixed term change 처리 된 event가 옴.
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse createPrdCtlgFullRoutWeb(Event e) throws EventException {
		EsdPrd0080Event event = (EsdPrd0080Event)e;
		ProductCatalogCreateBC productCatalogCreateBc = new ProductCatalogCreateBCImpl();
		
		PrdParameterVO prdParameterVO  = (PrdParameterVO) event.getAttribute("prdParameterVO");
		
		PrdCreateManageBC prdCreateManageBc = new PrdCreateManageBCImpl();
		event = (EsdPrd0080Event)prdCreateManageBc.setPrdCreateParam(prdParameterVO);
		
		PrdPcCreateVO prdPcCreateVO = null;
		event.setAttribute("account", account);
		EventResponse eventResponse = new GeneralEventResponse();
		try{
			/*
			 * SC 의 createPrdCtlgFullRout 는 선택화면을 위한 메소드
			 * PC를 생성하고, 선택화면에 필요한 데이터를 위해 조회를 한다.
			 */
			begin();
			/*
			 * prd mst,dtl 생성
			 * qty 생성
			 * data 정리
			 * activity group dtl 생성
			 */
			//-------------★★★pc 생성 (mst,dtl,qty,act)★★★------------
			productCatalogCreateBc.createPrdCtlgFullRoutWeb(event);
			
			prdPcCreateVO = event.getPrdPcCreateVO();

			// pc선택화면의 cost를 위해 pc의 첫번째 것만 cost를 구하고,
			// 선택화면의 변경시 pc 생성때 보여주기 위한 cost를 그때 그때 구한다.(속도 개선)
			// ★ coa call --------------------------------------------------------------------------------------------------------
			createCostAssignPrd(prdPcCreateVO.getMinPctlNo(), prdPcCreateVO.getMaxPctlNo(), account.getUsr_id());
			// coa call-------------------------------------------------------------------------------------------------------------
			
			// Web 용 pctl No를 하나 선택하여 넘겨준다.
			DBRowSet rowset = null;
			rowset = new ProductCatalogCreateDBDAO().searchProductCatalogInternalMst_1(event.getPrdPcCreateVO().getHdPctlNo());
			String returnPctlNo = "";
			String cnsfFlg = "";
			while( rowset.next()){
				eventResponse.setETCData("N1ST_VSL_LODG_DUE_DT", rowset.getString("N1ST_VSL_LODG_DUE_DT"));
				returnPctlNo = rowset.getString("PCTL_NO");
				cnsfFlg = rowset.getString("REMARK");
				if( !"X".equals(cnsfFlg)) {
					eventResponse.setETCData("PCTL_NO",returnPctlNo);
					break;
				}
			}
			
			commit();
		}catch(EventException ex){
			rollback();
			log.error("\n EventException err " + ex.toString(), ex);
			if(ex.getMessage().contains( (new ErrorHandler("PRD00074")).getMessage() )){
				log.debug("\n\n pc 생성 실패 (PRD00074: Failed to create PC.)");
				eventResponse = new GeneralEventResponse();
				event.setAttribute("prdPatternVO", event.getAttribute("prdPatternVO"));
				String verifyMessage = new ProductCatalogCreateVerifyBCImpl().getPcVerify(event.getPrdCreateParamVO(), event.getPrdPcCreateVO(), (PrdPatternVO)event.getAttribute("prdPatternVO"));
				eventResponse.setUserMessage(verifyMessage);
				return eventResponse;
			}else  if(ex.getMessage().contains("PSEUDO VVD")){
				eventResponse.setUserMessage(ex.getMessage());
				return eventResponse;
				
			} //-- 통합 로그 메세지시 time out등의 예기치 않은 에러시 시스템 에러를 보이지 않게 함 2013-11-01 
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("\n Exception err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
		return eventResponse;
	}

	/**
	 * @param minPctlNo
	 * @param maxPctlNo
	 * @param usr_id
	 * @throws EventException
	 */
	private void createCostAssignPrd(String minPctlNo, String maxPctlNo,
			String usr_id) throws EventException {
		int result = 0;
		CostAssignBC costCommand = new CostAssignBCImpl();
		try {
			result = costCommand.createCostAssignPrd(minPctlNo, maxPctlNo, usr_id);
		} catch (EventException ex) {
			// TODO Auto-generated catch block
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * Interface로 Upload된 정보 Status Update<br>
	 * 
	 * @param     BkgWebServiceVO bkgWebServiceVO
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private void modifyAutoUploadStatus(BkgWebServiceVO bkgWebServiceVO) throws EventException {
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		
		try{
			begin();
			command.modifyAutoUploadStatus(bkgWebServiceVO, account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
	}
	
	/**
	 * Interface로 Upload된 정보 Status Update<br>
	 * 
	 * @param     SIWebServiceVO sIWebServiceVO
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private void modifySIAutoUploadStatus( SIWebServiceVO sIWebServiceVO) throws EventException {
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		
		try{
			begin();
			command.modifySIAutoUploadStatus(sIWebServiceVO, account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}
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
			
//	        //begin();
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
	 * 화주에게 전송하는 No Rate Notic 메일 내용을 반환한다. <br>
	 * 
	 * @param String bkgNo
	 * @param String rqstNo
	 * @return String
	 * @exception EventException
	 */
	public String getNoRateNoticeToCustomer(String bkgNo, String rqstNo) throws Exception {
		
		StringBuffer contentSb = new StringBuffer();
				
		try {			
			contentSb.append("<b>Customer Notice (Request No. ").append(rqstNo).append(")");

			contentSb.append("<br><br>Dear Customer, ");

			contentSb.append("<br><br>Please be informed that your booking(s) below are received but,");
			contentSb.append("<br>requires further review.");
			contentSb.append("<br>-  (Request No. ").append(rqstNo).append(")");

			contentSb.append("<br><br>Please contact your local sales representative for assistance. ");

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
	public String getNoRateNoticeToSrep(String bkgNo, String rqstNo) throws Exception {
		
		StringBuffer contentSb = new StringBuffer();
				
		try {
			
			contentSb.append("<b>SM Line No rate booking Notice (Booking No. ").append(bkgNo).append(")</b>");
			
			contentSb.append("<br><br>Dear Sales representative,");

			contentSb.append("<br><br>Please be informed booking request has been submitted by customer, but due to no available rate,");
			contentSb.append("<br>Booking No.  ").append(bkgNo).append (" (Request No." ).append(rqstNo).append (") is under 'No Rate' status.");

			contentSb.append("<br><br>No Rate bookings are subject to the following");

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
			//CostAssignBC coaBc = new CostAssignBCImpl();
			UnmatchBLVO unmatchBLVO = new UnmatchBLVO();
			BkgRevCostVO revCostVO = new BkgRevCostVO();
			List<BkgChgRateVO> revDtlVOs = new ArrayList<BkgChgRateVO>();
			CostAssignBC masBC  = new CostAssignBCImpl();
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
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchUsWest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg022901Event event = (EsmBkg022901Event)e;
		EBookingReceiptBC command = new EBookingReceiptBCImpl();

		try{
			String usWestFlag = command.searchUsWest(event.getLocCd());
			eventResponse.setETCData("us_west_flag", usWestFlag);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * WEB S/I Audit<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageWebSiAudit(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0229Event event =  (EsmBkg0229Event)e;
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		BLIssuanceBC bLIssuanceBC = new BLIssuanceBCImpl();
		BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();	
		PerformanceReportBC repCmd = new PerformanceReportBCImpl();
		try{
			begin();
			
			int updCnt = command.modifySIAuditFlag(event.getSIWebServiceVO(), account);
			
			if( updCnt > 0 ){
				HistoryLineVO historyLineVO = new HistoryLineVO();
				historyLineVO.setUiId("ESM_BKG_0229");			
				historyLineVO.setHisCateNm("WEB S/I Audit");
				historyLineVO.setBkgNo(event.getSIWebServiceVO().getBkgNo());
				historyLineVO.setCaFlg("N");
				historyLineVO.setPreCtnt("");
				historyLineVO.setCrntCtnt("Complete");
				historyBC.createBkgHistoryLine(historyLineVO, account);
			}
			
			int insCnt = repCmd.modifyQueueByWebSiAudit(event.getSIWebServiceVO(), account);
			
			if(insCnt > 0){
				ModifySiValAutoVO modifySiValAutoVO = new ModifySiValAutoVO();
				modifySiValAutoVO.setBkgNo(event.getSIWebServiceVO().getBkgNo());
				modifySiValAutoVO.setXterSndrId(event.getSIWebServiceVO().getXterSndrId());
				modifySiValAutoVO.setXterRqstNo(event.getSIWebServiceVO().getXterRqstNo());
				modifySiValAutoVO.setXterRqstSeq(event.getSIWebServiceVO().getXterRqstSeq());
				modifySiValAutoVO.setCallPgmType("QA");
				modifySiValAutoVO.setUsrId(account.getUsr_id());			
				
				modifySiValAutoVO = repCmd.modifySiValAuto(modifySiValAutoVO,"QA");
			}
			
			String [] eml = new String[2];
			eml[0] = event.getSiCntcPsonEml();
			String sType = null;
			String sLevel = null;
			String sMrd = null;
			StringBuilder sbParam = null;
			sbParam = new StringBuilder();
			
			DblWblVO[] dblWblVOs = null;
			
			String siContactUsrNm = null;;
			String siContactEmail =null;
			
			List<BkgNtcHisVO> bkgNtcHisVOs = null;
			List<BkgNtcHisVO> bkgNtcHisSysVOs = new ArrayList<BkgNtcHisVO>();
			BkgNtcHisVO bkgNtcHisVO = new BkgNtcHisVO();
			
			String [] rmk = new String[1];
			rmk[0] = "";
			
			String ssoTargetUrl = JSPUtil.getNull(SiteConfigFactory.get("COM.HANJIN.SSO.TARGET"));
			boolean isLive = false;     // Live 여부
			if (ssoTargetUrl.indexOf("alps.smlines.com") > 0) {
              isLive = true;
			} 
			
			if(isLive){
				if ("PKGSA".equals(account.getOfc_cd())){
					String[] bkgContact  = command.searchBkgContactInfo(event.getSIWebServiceVO().getBkgNo());
					siContactUsrNm = bkgContact[0];
					siContactEmail = bkgContact[1];
					if (siContactUsrNm == null || "".equals(siContactUsrNm)) {
						siContactUsrNm = account.getUsr_nm();
						siContactEmail = account.getUsr_eml();
					}
				} else {
					siContactUsrNm = account.getUsr_nm();
					siContactEmail = account.getUsr_eml();
				}
				
				StringBuilder titleSb = new StringBuilder("SM Line Web B/L Instruction Notification ");
				titleSb.append(" ( ").append(event.getSIWebServiceVO().getBkgNo()).append(" :  Uploaded )");
				StringBuilder contentSb = new StringBuilder("Dear Customer");
				contentSb.append("\n\nThank you for using SM Line Website.");
				contentSb.append("\nThis is an automated message to inform you that your B/L instruction request for \"").append(event.getSIWebServiceVO().getBkgNo()).append("\"  is received for processing.");
				contentSb.append("\nPlease note that the attachment is not the final draft B/L, but a preview form of the final draft B/L.");
				contentSb.append("\n\nIf you have any question on the submitted B/L instruction or booking, please contact: ").append(siContactUsrNm).append(" (").append(siContactEmail).append(").");
				contentSb.append("\n\nIf you have any suggestions or comments, do not hesitate to share us your valuable comments in our \"Voice of Customer\" menu.");
				
				sType="2";
				sMrd="ESM_BKG_0109_DBL.mrd";					
				sLevel="6";
				
				sbParam.append("/rv");
				sbParam.append(" form_bkgNo[('").append(event.getSIWebServiceVO().getBkgNo()).append("')]");
				sbParam.append(" form_type[").append(sType).append("]");
				sbParam.append(" form_dataOnly[N]");
				sbParam.append(" form_manifest[N]");
				sbParam.append(" form_usrId[").append(account.getUsr_id()).append("]");
				sbParam.append(" form_hiddeData[N]");
				sbParam.append(" form_level[(").append(sLevel).append(")]");
				sbParam.append(" form_remark[").append(rmk[0]).append(")]");
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
				dblWblVOs = new DblWblVO[1];
				dblWblVOs[0] = new DblWblVO();
				dblWblVOs[0].setBkgNo(event.getSIWebServiceVO().getBkgNo());
				dblWblVOs[0].setBlNo(event.getSIWebServiceVO().getBlNo());
				dblWblVOs[0].setSyscd("BKG");
				dblWblVOs[0].setTmplmrd(sMrd);
				dblWblVOs[0].setBatchflg("N");
				dblWblVOs[0].setTmplparam(sbParam.toString());
				dblWblVOs[0].setRcveml(eml[0]);
				dblWblVOs[0].setTmplmrdpdf("Original.pdf");
				dblWblVOs[0].setItr("|$$|");
	//			dblWblVOs[0].setNtcKndCd("");
	//			dblWblVOs[0].setHiddOpt("N");
				dblWblVOs[0].setFrtAllFlg("1".equalsIgnoreCase(sLevel)?"Y":"N");
				dblWblVOs[0].setFrtCltFlg("5".equalsIgnoreCase(sLevel)?"Y":"N");
				dblWblVOs[0].setFrtPpdFlg("4".equalsIgnoreCase(sLevel)?"Y":"N");
				dblWblVOs[0].setFrtChgFlg("6".equalsIgnoreCase(sLevel)?"Y":"N");
				dblWblVOs[0].setFrtArrFlg("3".equalsIgnoreCase(sLevel)?"Y":"N");
				dblWblVOs[0].setTitle(titleSb.toString()); /* 제목 */
				dblWblVOs[0].setContents(contentSb.toString()); /* 내용 */
				
				bkgNtcHisVOs = bLIssuanceBC.sendDblWblByEmail(dblWblVOs, null, account);		
				
				if(null != bkgNtcHisVOs && bkgNtcHisVOs.size() > 0){
					bkgNtcHisVO = bkgNtcHisVOs.get(0);
					bkgNtcHisVO.setSndUsrId("SYSTEM");
					bkgNtcHisSysVOs.add(bkgNtcHisVO);
					historyBC.createBkgNtcHis(bkgNtcHisSysVOs, "ESM_BKG_0229");
				}		
			}
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	private EventResponse searchXterSIChgRt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EsmBkg0241Event event = (EsmBkg0241Event)e;
			EBookingReceiptBC command = new EBookingReceiptBCImpl();
			if("Y".equals(event.getSIWebServiceVO().getCmpbRtFlg())){
				List<BkgXterChgRtVO> bkgCmpbRtVOs= command.searchXterSIChgRt(event.getSIWebServiceVO());				
				eventResponse.setRsVoList(bkgCmpbRtVOs);				
			} else if ("Y".equals(event.getBkgRtFlg())){
				List<BkgXterChgRtVO> xterChgRtVOs= command.searchXterChgRt(event.getSIWebServiceVO());				
				eventResponse.setRsVoList(xterChgRtVOs);		
			}else{
				List<BkgXterChgRtVO> bkgXterChgRtVOs= command.searchXterSIChgRt(event.getSIWebServiceVO());
				List<BkgChgRateVO> bkgChgRateVOs = command.searchBkgChgRt(event.getSIWebServiceVO().getBkgNo());
				
				eventResponse.setRsVoList(bkgXterChgRtVOs);
				eventResponse.setRsVoList(bkgChgRateVOs);
			}
			
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0250_01 : open <br>
	 * History 팝업 Header + commbolist + B/L Data 조회<br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBlHist(Event e) throws EventException {
		EsmBkg0250Event event = (EsmBkg0250Event)e;
		GeneralBookingSearchBC command = new GeneralBookingSearchBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
				
        try {        	
			HistMainVO histMainVO = command.searchBlHist(event.getBkgBlNoVO(),event.getSIWebServiceVO());
			
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
	 * ESM_BKG_0250_02 : Fax/EDI tab click <br>
	 * History 팝업 화면의 FAX/EDI tab 조회 처리<br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNoticeHist(Event e) throws EventException {
		EsmBkg0250Event event = (EsmBkg0250Event)e;
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
	 * ESM_BKG_0250_03 : Customs Tab click <br>
	 * History 팝업 화면의 Customs Tab 조회 처리<br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomsHist(Event e) throws EventException {
		EsmBkg0250Event event = (EsmBkg0250Event)e;
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
	 * ESM_BKG_0250_04 : Document tab Click <br>
	 * History 팝업 화면의 Documnents tab 조회 처리<br>
	 * @author    Lee NamKyung
	 * @param     Event e
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDocHist(Event e) throws EventException {
		EsmBkg0250Event event = (EsmBkg0250Event)e;
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
	 * ESM_BKG_0229 : UPLOAD 클릭
	 * BKG_XTER_RQST_MST 정보를 ALPS로 업로드 (전체 TAB Upload)<br>
	 * Route 정보가 있는 경우<br>
	 * EBookingReceipt의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBccSurchargeRating(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0229Event event = (EsmBkg0229Event)e;
		
		try {
			begin();	
			
			BlRatingBC blRatingBC = new BlRatingBCImpl();			
			BkgBlNoVO bkgBlNoVO = event.getBkgBlNoVO();
			
			BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
			HistoryTableVO historyTableVO = new HistoryTableVO ();
			historyTableVO = bookingHistoryMgtBC.searchOldBkgForHistory("ESM_BKG_CA_BCC", bkgBlNoVO);
			
			SurchargeAutoRatingBC surchargeAutoRatingBC = new SurchargeAutoRatingBCImpl();
			BkgSurchargeRateVO bkgSurchargeRateVO = surchargeAutoRatingBC.searchSurchargeRatingByBcc(bkgBlNoVO.getBkgNo(), "N",account);
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
	
	        //BlRatingBC blRatingBC = new BlRatingBCImpl();
	        bkgBlNoVO.setCaUsrId(account.getUsr_id());
	        blRatingBC.distributeCntrRate(bkgBlNoVO.getBkgNo(), account);   
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
	 * 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse xterRqstDatasetInterfaceTest(Event e) throws EventException {
		EventResponse eventResponse = new GeneralEventResponse();
		
		EsmBkg0229Event 		event0229 	= (EsmBkg0229Event)e;
		
		EBookingReceiptBC 		command 	= new EBookingReceiptBCImpl();			
		BookingUtil 					util 			= new BookingUtil();
		SIWebServiceVO sIWebServiceVO = event0229.getSIWebServiceVO();
		BkgWebServiceVO bkgWebServiceVO = new BkgWebServiceVO();
		
		bkgWebServiceVO.setPctlExptFlg("N");
		bkgWebServiceVO.setBkgUpldStsCd("N");
		bkgWebServiceVO.setSysUpldFlg("N");
		bkgWebServiceVO.setBkgBlckFlg("N");
		bkgWebServiceVO.setXterSndrId(sIWebServiceVO.getXterSndrId());
		bkgWebServiceVO.setXterRqstNo(sIWebServiceVO.getXterRqstNo());
		bkgWebServiceVO.setXterRqstSeq(sIWebServiceVO.getXterRqstSeq());
		
		XterRqstNoVO xterRqstNoRstVO = command.searchXterRqstNoInterface(bkgWebServiceVO);
		
		try{
			BkgWebServiceVO bkgWebServiceVOStatus = command.searchWebServiceProcessType(bkgWebServiceVO);
			if("Y".equals(bkgWebServiceVOStatus.getBkgBlckFlg())){
				// BKG Block FLAG값이 Y이면  webSvcVO에 해당값 세팅해주세요.
				bkgWebServiceVO.setBkgBlckFlg(bkgWebServiceVOStatus.getBkgBlckFlg());
			}
			
			//BookingUtil             util      	= new BookingUtil();
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("EBKG_BLOCK_AUTO_UPLD");			
			List<BkgHrdCdgCtntVO> hdcList = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
			boolean blockAutoUpload = false;
			String message = "";
			if(hdcList != null && hdcList.size() > 0){
				 for(BkgHrdCdgCtntVO vo : hdcList){
					 /* Auto upload 사용 여부 N 이면 사용 */
					 if("Y".equals(vo.getAttrCtnt1())){
						 blockAutoUpload = true;
					 }
					 
					 if(blockAutoUpload) break;
					 
					 /* VVD 동일하면 메뉴얼 */
					 if(xterRqstNoRstVO.getVvd() != null && !vo.getAttrCtnt2().equals("") && xterRqstNoRstVO.getVvd().equals(vo.getAttrCtnt2())){
						 blockAutoUpload = true;
						 message = "VVD가 동일합니다. : " + xterRqstNoRstVO.getVvd();
					 }
					 
					 /* POL 동일하면 메뉴얼 */
					 if(xterRqstNoRstVO.getPolCd() != null && !vo.getAttrCtnt3().equals("") && xterRqstNoRstVO.getPolCd().equals(vo.getAttrCtnt3())){
						 blockAutoUpload = true;
						 message = "POL가 동일합니다. : " + xterRqstNoRstVO.getPolCd();
					 }
				 }
			}
//			if(!blockAutoUpload){
			if(!blockAutoUpload && !"Y".equals(bkgWebServiceVOStatus.getManualFlg()) && !"U".equals(bkgWebServiceVOStatus.getJobTp())){
				/*********************************************************************/
				//#.XterRqstNoVO
				/*********************************************************************/
				//XterRqstNoVO xterRqstNoRstVO = command.searchXterRqstNoInterface(bkgWebServiceVO);
				event0229.setXterRqstNoVO(xterRqstNoRstVO);
				/*********************************************************************/
				//#.BkgBlNoVO
				/*********************************************************************/
				BkgBlNoVO bkgBlNoVO = command.searchBkgBlNoInterface(bkgWebServiceVO);
				event0229.setBkgBlNoVO(bkgBlNoVO);
	
				/*********************************************************************/
				//#.xterEtcInterfaceVO
				/*********************************************************************/
				XterEtcInterfaceVO xterEtcInterfaceVO = command.searchXterEtcInterface(bkgWebServiceVO);
				
				/* AK Data 가 존재하면 Auto BKG를 하지 않는다. 박유숙 부장님 요청 */
				if(xterEtcInterfaceVO.getSaveAkFlag().equals("Y")){
					log.error("Auto BKG AWK : " + xterRqstNoRstVO.getBkgNo());
					/* 업로딩 상태를 N 로 변경한다 */
					modifyAutoUploadStatus(bkgWebServiceVO);
					return eventResponse;
				}
				
				System.out.println("============== Auto Booking Upload ==================");
			}
			else{
				System.out.println("============== " + message + " ======================");
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	private EventResponse receiptXterRqstEdiMsg(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0228Event event = (EsmBkg0228Event)e;
		EBookingReceiptBC command = new EBookingReceiptBCImpl();
		String flatFileStr = event.getMsg();
		XterRqstNoVO rqstNoVo = null;
		try {
			begin();
			String[] headers = command.getReceiptXterRqstEdiMsgType(flatFileStr.split("\n")[0]);
			if(headers != null && headers[2].equalsIgnoreCase("VERMAS")){
				command.receiptXterVGMRqst(flatFileStr);
			}else{
				command.addBkgSrProcHisPrc(flatFileStr,"FMQRCV" );
				rqstNoVo = command.receiptXterRqst(flatFileStr);
				command.addBkgSrProcHisPrc(flatFileStr,"EBKRCV" );
				
				if(rqstNoVo!=null){
					command.assignBkgNoToXterRqst(rqstNoVo);
					PerformanceReportBC command2 = new PerformanceReportBCImpl();
					DpcsWebBookingVO dpcsWebBookingVO = new DpcsWebBookingVO();
					dpcsWebBookingVO.setXterSndrId(rqstNoVo.getSenderId());
					dpcsWebBookingVO.setXterRqstNo(rqstNoVo.getRqstNo());
					dpcsWebBookingVO.setXterRqstSeq(rqstNoVo.getRqstSeq());
					if ( !"E".equals(rqstNoVo.getDocTpCd()) && !"H".equals(rqstNoVo.getXterBlTpCd())) {
						command2.addBkgSrRequest(dpcsWebBookingVO);	
					}
				}
			}
			
			if(event.getCommit() != null && event.getCommit().equalsIgnoreCase("ON")){
				commit();
			}else{
				rollback();
			}
		} catch (EventException ex) {
			rollback();
			throw new EventException(ex.getCause().getCause().getLocalizedMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getCause().getCause().getLocalizedMessage(), ex);
		}
		return eventResponse;
	}
}