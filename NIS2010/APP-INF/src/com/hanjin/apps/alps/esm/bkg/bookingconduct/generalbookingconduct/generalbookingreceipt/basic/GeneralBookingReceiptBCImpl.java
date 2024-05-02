/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingReceiptBCImpl.java
*@FileTitle : BKG Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.14
*@LastModifier : KimByungKyu
*@LastVersion : 1.0
* 2009.05.14 KimByungKyu
* 1.0 Creation
* --------------------------------------------------------
* HISTORY
* 2010.11.03 전성진 [CHM-201006336] Filer type validation 변경
* 2010.11.04 김영철 [] Booking Creation / Update / Cancel시, Vessel Operation 모듈의 Final CBF 생성 여부를 체크해서 경고 메시지
* 2010.11.10 김영철 [] Booking Main 화면에서 Close VVD를 확인후에 CBF 를 확인중에 잘못된 팝업이 생성되는 것을 수정함.
* 2010.11.15 이일민 [CHM-201006562-01] Booking Receipt Notice Fax & Email Service 수정 (DOC CCT 추가 및 EDI 기능)
* 2010.12.27 전성진 [] Empty Booking Status 원복 로직 수정. 원본에 한개라도 CNTR이 있으면 F로 변경
* 2011.01.11 이일민 [] 1월 6일자 R4J 관련 수정
* 2011.01.17 전성진 [CHM-201007922] US filer type과 S/C customer type validation 변경(DEL->Filer 있을 경우)
* 2011.01.21 이일민 [] COD Confirm 시 validation 추가(VVD 저장 후 VVD 확인)
* 2011.01.26 전성진 [] US filer type과 S/C customer type validation 변경(DEL 조건 재추가)
* 2011.01.26 이일민 [CHM-201108129] BKG Creation 및 e-BKG 업로드 시에 co_biz 사용 여부 확인
* 2011.02.08 이일민 [CHM-201108129] BKG Creation 및 e-BKG 업로드 시에 co_biz 사용 여부 확인 - 파라미터 오류 수정
* 2011.03.03 정선용 [CHM-201109007-01] Route 정보가 다른경우 저장 불가 후 메시지 표시 확인
* 2011.03.31 이일민 [CHM-201109372] COD Application 진행시 Warning 메세지 수정 요청(modifyBookingFromCod 에 EventException 추가)
* 2011.04.18 이일민 [CHM-201109371] PKGSC 업무이관관련 DPCS와 SI Mark 연계로직
* 2011.04.19 이일민 [CHM-201110187] BKG 조회 및 변경시 ROUTE 정보 비교 로직 보완
* 2011.05.19 이일민 [CHM-201110187] BKG 조회 및 변경시 ROUTE 정보 비교 로직 보완 - old pctl no 추가
* 2011.05.27 이일민 [CHM-201110854-01] [ALPS] Drfat B/L (EDI) 전송 Time Out 수정
* 2011.05.31 이일민 [CHM-201110854-01] [ALPS] Drfat B/L (EDI) 전송 Time Out 수정
* 2011.05.31 채창호 [CHM-201110946-01] [ALPS] Hitchment BKG flag update 요청
* 2011.06.08 이일민 [CHM-201110982-01] e-SI & DPCS BKG Split & Combine 기능 구현 요청
* 2011.07.14 김진승 [CHM-201111820] Split 03-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
* 2011.07.18 김봉균 [CHM-201112282-01] 중국 Solid Waste 관련 bkg commodity validation 추가
* 2011.10.20 정선용 [CHM-201113441-01] BKG 화면의 C.OFC 및 C.REP SELECT POPUP 추가 요청
* 2011.11.02 윤태승 [CHM-201114180-01] ALPS> Booking Creation > External Remarks에 자동 문구 삽입 요청 드립니다.
* 2011.11.03 정선용 [CHM-201114137-01] [ALPS] E-BKG/SI Process 화면 EDI REF 추가
* 2011.11.11 금병주 [CHM-201114389-01] bkg 화면에 multi c.ofc/rep에 대한 로직 보완
* 2011.11.17 금병주 [CHM-201114584-01] ALPS> Booking Creation > External Remarks & Booking External Remarks 에 자동 문구 위치 변경 요청 합니다.
* 2011.11.29 정선용 [CHM-201113753-01] Split 01-Korea CLL 전송 후 변동사항 발생 시 SMS 자동 발송 기능 개발 요청 
* 2011.12.02 전성진 [CHM-201114389-01] bkg 화면에 multi c.ofc/rep에 대한 로직 보완 추가 - customer 부분 기존 로직 주석
* 2011.12.06 정선용 [CHM-201114803-01] 중국발 터키향 DG화물 validation 추가
* 2011.12.19 정선용 [CHM-201115046-01]	선적변경시 웹메일 & SMS 서비스 개발 건 보완요청(2차)
* 2012.01.09 금병주 [CHM-201115389-01] bkg 화면에 Port skip일 경우 표기 요청
* 2012.01.31 정선용 [SRM-201223492] [BKG생성금지] 말레이시아발(향)-유럽향(발) BKG Blocking
* 2012.02.27 정선용 [CHM-201215886-01] Split 기능 보완(eq tp,qty 추가)
* 2012.02.24 금병주 [CHM-201216172-01] Doc. Performance Report ETD 및 PCT 갱신
* 2012.03.29 전성진 [CHM-201217014] 악성 화주 선택시 Warning Message 변경 요청
* 2012.05.31 조정민 [CHM-201218075] BKG Split 시 Auto-rating 오류
* 2012.06.18 조정민 [CHM-201217472] [BKG] BKG/DOC Validation Rule 정리 요청
* 2012.07.02 조정민 [CHM-201218333] BKG Charge 화면에 S/C No 입력및 저장시 Validation 추가
* 2012.07.04 조정민 [CHM-201218816] BKG> Cut Off Time 화면상 Rail Receiving Date 공백처리 요청
* 2012.07.24 조정민 [CHM-201219066] [BKG] US rail cut off time 관련 로직 정정요청
* 2012.09.25 조정민 [CHM-201219852] [BKG] MEMO BL Cancel건의 BKG Status변경 자동처리 (S->F Manual변경처리하는 현행 개선)
* 2012.09.26 조정민 [CHM-201220436] 특정RFA Term Validation예외 (RFA:BUD12A0115)
* 2013.04.04 류대영 [CHM-201323757] T/S 화물에 대한  CLL 마감 이후 CLOSING 기능 로직 변경
* 2013.04.29 최문환 [CHM-201323560] [BKG & e-booking & si process 화면] 저장시 L.REP validation 요청
* 2013.12.04 최문환 [CHM-201327702] SINBB O/B 대상 Booking Confirmation 및 ALPS > BKG MTY pick up date 수정 요청
* 2014.03.31 문동선 [CHM-201429346] 이스라엘 세관 신고 관련 Consignee 정보 Logic 변경 요청
* 2014.05.27 문동선 [CHM-201429314] 일본 세관 사전신고제를 위한 Simple/Console default 적용 로직 추가
* 2014.05.29 문동선 [CHM-201430407] Split 01-PPD/CCT office 지정 관련 Rating  전 후 로직 정정 관련
* 2014.06.18 문동선 [CHM-201430438] Customer 탭에 A/Customer 오른쪽에 Status 정보 추가 요청
* 2014.08.08 문동선 [CHM-201431477] GSDM CODE관련 BKG 저장 제한 및 AUTORATING 로직 보완 요청 - FAK와 동일
* 2014.09.15 문동선 [CHM-201431717] BKG vs TRO qty Validation 추가 요청
* 2014.10.15 문동선 [CHM-201432116] SPOT GUIDE RFA, BKG 적용 관련 요청
* 2014.10.16 문동선 [CHM-201431903] BKG creation validation 철회 요청
* 2014.10.16 문동선 [CHM-201431658] 한진해운 조기결산을 위한 개선 방안 중 BKG 관리 프로세스 단축(안) 개발
* 2014.12.10 문동선 [CHM-201432810] [더블콜링] VSK 정보 업데이트에 따른 부킹 변경 건에 대한 보강 조치
=========================================================*/ 
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgCloseVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.MdmCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdMainInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.PrdQtyInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.SplitMstBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration.GeneralBookingReceiptDBDAO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration.GeneralBookingReceiptEAIDAO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.AllocStsChgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.AllocStsVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BdrSpclVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgClauseLockVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgForCopyVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgForDstSvcRouteVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgReactivateVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlDocCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingCopyVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingCreationVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingSaveValidationVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CargoDetailVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CmdtVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CopySplitBkgEtcVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CustEtcVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.FwrdRefVvdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingCreateVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingSplitVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyBookingVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyQtyVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.MtyVvdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.OceanRouteVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.OldBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PartialBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PartialBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherCmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherCntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherLoadingCntrVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherMdtItmVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherNoBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PoOtherShipVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PolPodVvdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.PrdRouteVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.RollOverNoticeParamVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SmsRequirementResultVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SpclQtyVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SpclVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBkgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.SplitBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.TsBkgCloseNoticeVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.ValidateOceanRouteVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VskYardCngBkgListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdCngDoubleCallEtcVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdCngUpdateVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdEtaCngNoticeVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdYardCngNoticeVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VvdAssignVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.basic.GeneralBookingSearchBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.BkgReceiptSendVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.RepoBkgForUpdateVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.ScListInputVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.vo.Vender301ParamVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.basic.TransferOrderIssueBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.basic.TransferOrderIssueBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.CombineTroNewSeqVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgPreCheckingStatusVO;
import com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgUserSmsListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustCodeErrListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustCdEvaluationVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateMainInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BlCopyInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCopyVO;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.basic.BasicCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgBlMkDescVO;
import com.hanjin.syscommon.common.table.BkgBookingVO;
import com.hanjin.syscommon.common.table.BkgClzTmVO;
import com.hanjin.syscommon.common.table.BkgCntcPsonVO;
import com.hanjin.syscommon.common.table.BkgCustomerVO;
import com.hanjin.syscommon.common.table.BkgDocProcSkdVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.BkgQtyDtlVO;
import com.hanjin.syscommon.common.table.BkgQuantityVO;
import com.hanjin.syscommon.common.table.BkgRefDtlVO;
import com.hanjin.syscommon.common.table.BkgReferenceVO;
import com.hanjin.syscommon.common.table.BkgRollOvrVO;
import com.hanjin.syscommon.common.table.BkgUsaCstmsFileNoVO;
import com.hanjin.syscommon.common.table.BkgUsrDfltSetVO;
import com.hanjin.syscommon.common.table.BkgVvdVO;
import com.hanjin.syscommon.common.table.MdmCountryVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;
/**
 * ALPS-GeneralBookingConduct Business Logic Basic Command implementation<br>
 * - ALPS-GeneralBookingConduct에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author KimByungKyu
 * @see ESM_BKG_0079_01EventResponse,GeneralBookingReceiptBC 각 DAO 클래스 참조
 * @since J2EE 1.4
 */

public class GeneralBookingReceiptBCImpl extends BasicCommandSupport implements GeneralBookingReceiptBC {

	// Database Access Object
	private transient GeneralBookingReceiptDBDAO dbDao = null;
	private transient GeneralBookingReceiptEAIDAO eaiDao = null;

	/**
	 * GeneralBookingReceiptBCImpl 객체 생성<br>
	 * GeneralBookingReceiptDBDAO를 생성한다.<br>
	 * GeneralBookingReceiptEAIDAO를 생성한다.<br>
	 */
	public GeneralBookingReceiptBCImpl() {
		dbDao = new GeneralBookingReceiptDBDAO();
		eaiDao = new GeneralBookingReceiptEAIDAO(); 
	}
	/**
	 * BKG_CHG_RT에서 BkgBooking Data에 해당하는 정보를 수정한다.<br>
	 * //[결함관리지침에 따른 이동]
	 * @author LEE JIN SEO
	 * @param RateMainInfoVO rateMainInfoVO
	 * @param String caflag
	 * @param String ctrtOfcCd 
	 * @param String ctrtSrepCd
	 * @exception EventException
	 */
	public void modifyChgRateBkgBooking(RateMainInfoVO rateMainInfoVO, String caflag, String ctrtOfcCd, String ctrtSrepCd)throws EventException{  
		try {
			// F.A.K 여부 확인 (FAK, Cargo, NOS, GDSM)
			if(rateMainInfoVO.getCmdtCd()!="" && ( Integer.parseInt(rateMainInfoVO.getCmdtCd()) < 27 || "98".equals(rateMainInfoVO.getCmdtCd().substring(0, 2))|| "99".equals(rateMainInfoVO.getCmdtCd().substring(0, 2))) ){
				if(dbDao.searchCmdtFak(rateMainInfoVO.getCmdtCd(), rateMainInfoVO.getPorCd(), rateMainInfoVO.getDelCd(), rateMainInfoVO.getBkgNo(), caflag, rateMainInfoVO.getScNo1())){
					throw new EventException((String)new ErrorHandler("BKG00307").getMessage());
				}
			}
			
			dbDao.modifyChgRateBkgBooking(rateMainInfoVO,caflag);

			// 계약 관련 정보를 update한다
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(rateMainInfoVO.getBkgNo());
			bkgBlNoVO.setCaFlg(caflag);
			dbDao.modifyCtrtInfo(bkgBlNoVO);
		    	 
			log.debug("\n *********************" +
					"\n ctrtOfcCd:"+ctrtOfcCd +
					"\n ctrtSrepCd:"+ctrtSrepCd);
		    	 
			String porCd = rateMainInfoVO.getPorCd();
			String polCd = rateMainInfoVO.getPolCd();
			porCd = porCd == null ? "" : porCd.substring(0,2);
			polCd = polCd == null ? "" : polCd.substring(0,2);
			if( polCd.equals("US") || polCd.equals("CA") || porCd.equals("US") || porCd.equals("CA")){
				if( ctrtOfcCd != null && ctrtSrepCd != null && ctrtOfcCd.length() >0 && ctrtSrepCd.length()>0 ) {
					dbDao.modifyChangedCtrtInfo(bkgBlNoVO, ctrtOfcCd, ctrtSrepCd, "");  //2011.10.14 jsy
				} 
    	 	}

			ScListInputVO scListInputVO = new ScListInputVO();
			scListInputVO.setBkgNo(bkgBlNoVO.getBkgNo());
			if(dbDao.validateScCtrtPtyTp(scListInputVO, caflag) > 0){
				throw new EventException((String)new ErrorHandler("BKG08267").getMessage());
			}

			if(dbDao.validateScCustTp(scListInputVO, bkgBlNoVO.getCaFlg(),"S") > 0){
				throw new EventException((String)new ErrorHandler("BKG08275", new String[]{rateMainInfoVO.getCmdtCd()}).getMessage());
			}
			if(dbDao.validateScCustTp(scListInputVO, bkgBlNoVO.getCaFlg(),"R") > 0){
				throw new EventException((String)new ErrorHandler("BKG08276", new String[]{rateMainInfoVO.getCmdtCd()}).getMessage());
			}
		} catch (EventException ex) {
			throw ex;			
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * BL TYPE 수정 처리<br>
	 * 해당 booking 의 BL TYPE  정보을 저장한다<br>
	 * @author LEE JIN SEO
	 * @param String bkgNo
	 * @param String blTpCd
	 * @exception EventException
	 */
	public void modifyBlType(String bkgNo ,String blTpCd) throws EventException{   
	    try {	    	
	    	dbDao.modifyBlType(bkgNo,blTpCd);	    	 
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}

	/**
	 * 조회 이벤트 처리<br>
	 * Purchase Other Number와 그외 number 정보를 조회한다..<br>
	 * @author LEE JIN SEO
	 * @param PoOtherNoVO rPoOtherNoVO
	 * @return PoOtherNoVO
	 * @exception EventException
	 */
	public PoOtherNoVO searchPoOtherNo(PoOtherNoVO rPoOtherNoVO) throws EventException {
		log.debug("============================>[[ GeneralBookingReceiptBCImpl  searchPoOtherNo START ]]<============================");

		PoOtherNoBkgVO poOtherNoBkgVO = rPoOtherNoVO.getIo_poOtherNoBkgVO();

		try {
			// 초기 조회시만 조회한다.
			if(rPoOtherNoVO.isFirst()){

				// 1. Search byCntr
				String bkgRefTpCd = "CTPO";
				List<PoOtherCntrVO> rPoOtherCntrVOs = dbDao.searchPoNoByCntr(poOtherNoBkgVO, bkgRefTpCd);
				rPoOtherNoVO.setO_poOtherCntrVOs(rPoOtherCntrVOs);

				// container에 할당된 sub값 가져오기.[DB에서 구한 첫번째 CONTAIN_NO 값을 셋팅하기]
				if(rPoOtherCntrVOs.size()>0)
					poOtherNoBkgVO.setCntrNo(rPoOtherCntrVOs.get(0).getCCntrNo());
				
				bkgRefTpCd = "MSLD";
				List<PoOtherLoadingCntrVO> rPoOtherLoadingCntrVO = dbDao.searchPoNoByLoadingCntr(poOtherNoBkgVO, bkgRefTpCd);
				rPoOtherNoVO.setO_poOtherLoadingCntrVOs(rPoOtherLoadingCntrVO);
				
			}
			// 2. Search byBKG
			List<PoOtherNoBkgVO> rPoOtherNoBkgVOs = dbDao.searchPoNoByBkg(poOtherNoBkgVO);
			rPoOtherNoVO.setO_poOtherNoBkgVOs(rPoOtherNoBkgVOs);
			//3.Search byCM
			List<PoOtherCmVO> rPoOtherCmVOs = dbDao.searchPoNoByCm(poOtherNoBkgVO);
			rPoOtherNoVO.setO_poOtherCmVOs(rPoOtherCmVOs);
			//4.Search byShip
			List<PoOtherShipVO> rPoOtherShipVOs = dbDao.searchPoNoByShip(poOtherNoBkgVO);
			rPoOtherNoVO.setO_poOtherShipVOs(rPoOtherShipVOs);
			//5.PO No.의 Mandatory Item
			PoOtherMdtItmVO rPoOtherMdtItm = dbDao.searchPoMdtItm(poOtherNoBkgVO);
			rPoOtherNoVO.setO_PoOtherMdtItmVO(rPoOtherMdtItm);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		}
		log.debug("============================>[[ GeneralBookingReceiptBCImpl  searchPoOtherNo END ]]<============================");

		return rPoOtherNoVO;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * PO & Other No에 CM정보를 Copy하기 위해 조회한다.<br>
	 * 1. CM data에서 Description, Package Qty/Type, Weight Qty, Measure Qty 정보를 단순 조회한다..<br>
	 * @author LEE JIN SEO
	 * @param PoOtherNoVO rPoOtherNoVO
	 * @return PoOtherNoVO
	 * @exception EventException
	 */
	public PoOtherNoVO searchCmForPo(PoOtherNoVO rPoOtherNoVO) throws EventException {
		log.debug("============================>[[ GeneralBookingReceiptBCImpl  searchCmForPo START ]]<============================");

		PoOtherNoBkgVO poOtherNoBkgVO = rPoOtherNoVO.getIo_poOtherNoBkgVO();

		try {

			List<PoOtherCmVO> rPoOtherCmVOs = dbDao.searchCmForPo(poOtherNoBkgVO);
			rPoOtherNoVO.setO_poOtherCmVOs(rPoOtherCmVOs);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		}
		log.debug("============================>[[ GeneralBookingReceiptBCImpl  searchPoOtherNo END ]]<============================");

		return rPoOtherNoVO;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * 해당 booking 의 reference no을 저장한다.<br>
	 * 전달받은 VO에서 값이 있는 Row만 생성/수정한다..<br>
	 * 아래 유형의 REFERENCE NUMBER만 생성/수정한다..<br>
	 * '-. 화주로 부터 제공받은 참조번호 유형.<br>
	 *  . EBRF : BKG Ref # (ext bkg rqst).<br>
	 *  . EBSH : BKG SH Ref # (ext bkg rqst).<br>
	 *  . EBFF : BKG FF Ref # (ext bkg rqst).<br>
	 *  . RGBK : Regional BKG No..<br>
	 *  . ESRF : S/I Ref # (ext rqst).<br>
	 *  . ESSH : S/I SH Ref # (ext rqst).<br>
	 *  . ESFF : S/I FF Ref # (ext rqst).<br>
	 *  . FINV : INV Ref # 수출업자와 수입업자의 관계<br>
	 *  .<br>
	 * @author LEE JIN SEO
	 * @param PoOtherNoVO   poOtherNoVO
	 * @param String caFlg
	 * @exception EventException
	 */
	public void manageRefNo(PoOtherNoVO poOtherNoVO, String caFlg) throws EventException {
		log.debug(">>>[[ GeneralBookingReceiptBCImpl  manageRefNo START ]]<============================");

		try {

			// 01. validation을 수행한다.
			BkgReferenceVO[] poOtherNoBkgVOs 	= poOtherNoVO.getI_poOtherNoBkgVOs();
			BkgReferenceVO[]  poOtherCntrVOs 	= poOtherNoVO.getI_poOtherCntrVOs();
			BkgReferenceVO[]  poOtherLoadingCntrVOs 	= poOtherNoVO.getI_poOtherLoadingCntrVOs();
			PoOtherNoBkgVO poOtherNoBkgVO 		= poOtherNoVO.getIo_poOtherNoBkgVO();
			SignOnUserAccount account 			= poOtherNoVO.getAccount();

			String bkgNo      	= poOtherNoBkgVO.getBkgNo();
			String cntrNo		= poOtherNoBkgVO.getCntrNo();

			if( poOtherNoBkgVOs != null ){

				int cnt = poOtherNoBkgVOs.length;

				// 02. 비즈니스 로직 수행
				List<BkgReferenceVO> insertVoList = new ArrayList<BkgReferenceVO>();
				List<BkgReferenceVO> updateVoList = new ArrayList<BkgReferenceVO>();
				List<BkgReferenceVO> deleteVoList = new ArrayList<BkgReferenceVO>();

				for(int i = 0; i < cnt; i++) {
					if(poOtherNoBkgVOs[i].getIbflag().equals("I")) {
						if(poOtherNoBkgVOs[i].getCustRefNoCtnt().length()<1||poOtherNoBkgVOs[i].getCustRefNoCtnt()==null){
							continue;
						}
						poOtherNoBkgVOs[i].setBkgNo(bkgNo);
						poOtherNoBkgVOs[i].setCntrNo(cntrNo);
						poOtherNoBkgVOs[i].setCreUsrId(account.getUsr_id());
						poOtherNoBkgVOs[i].setUpdUsrId(account.getUsr_id());
					    insertVoList.add(poOtherNoBkgVOs[i]);
					} else if(poOtherNoBkgVOs[i].getIbflag().equals("U")) {
						poOtherNoBkgVOs[i].setUpdUsrId(account.getUsr_id());
					    updateVoList.add(poOtherNoBkgVOs[i]);
					} else if(poOtherNoBkgVOs[i].getIbflag().equals("D")) {
					    deleteVoList.add(poOtherNoBkgVOs[i]);
					}
				 }
			    if(insertVoList.size() > 0) {
				dbDao.addBkgReference(insertVoList, caFlg);
			    }
			    if(updateVoList.size() > 0) {
				dbDao.modifyBkgReference(updateVoList, caFlg);
			    }
			    if(deleteVoList.size() > 0) {
				dbDao.removeBkgReference(deleteVoList, caFlg);
			    }
			}

			if( poOtherCntrVOs != null ){
				//int cnt = poOtherCntrVOs.length;

				// 02. 비즈니스 로직 수행
				List<BkgReferenceVO> insertVoList = new ArrayList<BkgReferenceVO>();
				List<BkgReferenceVO> updateVoList = new ArrayList<BkgReferenceVO>();
				List<BkgReferenceVO> deleteVoList = new ArrayList<BkgReferenceVO>();

				for(int i = 0; i < poOtherCntrVOs.length; i++) {
					if(poOtherCntrVOs[i].getRefSeq().equals("")) {
						poOtherCntrVOs[i].setBkgNo(bkgNo);
						poOtherCntrVOs[i].setBkgRefTpCd("CTPO");// 최초값  BKG_REF_TP_CD='CTPO'

						poOtherCntrVOs[i].setCreUsrId(account.getUsr_id());
						poOtherCntrVOs[i].setUpdUsrId(account.getUsr_id());

					    insertVoList.add(poOtherCntrVOs[i]);
					} else if(!poOtherCntrVOs[i].getRefSeq().equals("")) {

						poOtherCntrVOs[i].setUpdUsrId(account.getUsr_id());

					    updateVoList.add(poOtherCntrVOs[i]);
					} else if(poOtherCntrVOs[i].getIbflag().equals("D")) {

					    deleteVoList.add(poOtherCntrVOs[i]);
					}
				 }
				
			    if(insertVoList.size() > 0) {
				dbDao.addBkgReference(insertVoList, caFlg);
			    }
			    if(updateVoList.size() > 0) {
				dbDao.modifyBkgReference(updateVoList, caFlg);
			    }
			    if(deleteVoList.size() > 0) {
				dbDao.removeBkgReference(deleteVoList, caFlg);
			    }
			}
			//Loading tab
			if( poOtherLoadingCntrVOs != null ){

				// 02. 비즈니스 로직 수행
				List<BkgReferenceVO> insertVoList = new ArrayList<BkgReferenceVO>();
				List<BkgReferenceVO> updateVoList = new ArrayList<BkgReferenceVO>();
				List<BkgReferenceVO> deleteVoList = new ArrayList<BkgReferenceVO>();

				for(int i = 0; i < poOtherLoadingCntrVOs.length; i++) {
					if(poOtherLoadingCntrVOs[i].getRefSeq().equals("")) {
						poOtherLoadingCntrVOs[i].setBkgNo(bkgNo);
						poOtherLoadingCntrVOs[i].setBkgRefTpCd("MSLD");// 최초값  BKG_REF_TP_CD='MSLD'

						poOtherLoadingCntrVOs[i].setCreUsrId(account.getUsr_id());
						poOtherLoadingCntrVOs[i].setUpdUsrId(account.getUsr_id());

					    insertVoList.add(poOtherLoadingCntrVOs[i]);
					} else if(!poOtherLoadingCntrVOs[i].getRefSeq().equals("")) {

						poOtherLoadingCntrVOs[i].setUpdUsrId(account.getUsr_id());

					    updateVoList.add(poOtherLoadingCntrVOs[i]);
					} else if(poOtherLoadingCntrVOs[i].getIbflag().equals("D")) {

					    deleteVoList.add(poOtherLoadingCntrVOs[i]);
					}
				 }
				
			    if(insertVoList.size() > 0) {
				dbDao.addBkgReference(insertVoList, caFlg);
			    }
			    if(updateVoList.size() > 0) {
				dbDao.modifyBkgReference(updateVoList, caFlg);
			    }
			    if(deleteVoList.size() > 0) {
				dbDao.removeBkgReference(deleteVoList, caFlg);
			    }
			}
			
		} catch(DAOException de) {
		    log.error("err " + de.toString(), de);
		    throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception de) {
		    log.error("err " + de.toString(), de);
		    throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		log.debug("============================>[[ GeneralBookingReceiptBCImpl  manageRefNo END ]]<============================");
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * 해당 booking 의 reference detail (HP, COSTCO )정보을 저장한다<br>
	 * 전달받은 VO에서 값이 있는 Row만 생성/수정한다..<br>
	 * @author LEE JIN SEO
	 * @param PoOtherNoVO poOtherNoVO
	 * @param String caFlg
	 * @exception EventException
	 */
	public void manageRefDetail(PoOtherNoVO poOtherNoVO, String caFlg) throws EventException {
		log.debug("============================>[[ GeneralBookingReceiptBCImpl  manageRefDetail START ]]<============================");

		try {
			// 01. validation을 수행한다.
			BkgRefDtlVO[] poOtherCmVO 		= poOtherNoVO.getI_poOtherCmVOs();
			BkgRefDtlVO[] poOtherShipVO 	= poOtherNoVO.getI_poOtherShipVOs();
			PoOtherNoBkgVO poOtherNoBkgVO 	= poOtherNoVO.getIo_poOtherNoBkgVO();
			SignOnUserAccount account 		= poOtherNoVO.getAccount();

			String bkgNo      	= poOtherNoBkgVO.getBkgNo();
			String bkgNoSplit 	= poOtherNoBkgVO.getBkgNoSplit();
			String cntrNo		= poOtherNoBkgVO.getCntrNo();
			// 02. 비즈니스 로직 수행
			if( poOtherCmVO != null ){
				List<BkgRefDtlVO> poOtherCmVOinsertVoList = new ArrayList<BkgRefDtlVO>();
				List<BkgRefDtlVO> poOtherCmVOupdateVoList = new ArrayList<BkgRefDtlVO>();
				List<BkgRefDtlVO> poOtherCmVOdeleteVoList = new ArrayList<BkgRefDtlVO>();
				int poOtherCmCnt = poOtherCmVO.length;
				for(int i = 0; i < poOtherCmCnt; i++) {
					if(poOtherCmVO[i].getRefSeq().equals("")) {
						log.debug("======>>> PO & Other No에 CM정보를 Copy하기 위해   ADD:: "+bkgNo+bkgNoSplit);
						poOtherCmVO[i].setIbflag("I");
					}
					if(poOtherCmVO[i].getIbflag().equals("I")) {
						log.debug("======>>> BC	manageRefDetail poOtherCmVO ADD:: "+bkgNo+bkgNoSplit);
						poOtherCmVO[i].setBkgNo(bkgNo);
						poOtherCmVO[i].setBkgNoSplit(bkgNoSplit);
						poOtherCmVO[i].setCntrNo(cntrNo);

						poOtherCmVO[i].setCreUsrId(account.getUsr_id());
						poOtherCmVO[i].setUpdUsrId(account.getUsr_id());

					    poOtherCmVOinsertVoList.add(poOtherCmVO[i]);
					} else if(poOtherCmVO[i].getIbflag().equals("U")) {
						log.debug("======>>> BC	manageRefDetail poOtherCmVO UPDATE:: "+bkgNo+bkgNoSplit);
						poOtherCmVO[i].setBkgNo(bkgNo);
						poOtherCmVO[i].setBkgNoSplit(bkgNoSplit);
						//poOtherCmVO[i].setRefSeq(refSeq);
						poOtherCmVO[i].setUpdUsrId(account.getUsr_id());

					    poOtherCmVOupdateVoList.add(poOtherCmVO[i]);
					} else if(poOtherCmVO[i].getIbflag().equals("D")) {
						log.debug("======>>> BC	manageRefDetail poOtherCmVO DELETE:: "+bkgNo+bkgNoSplit);
						poOtherCmVO[i].setBkgNo(bkgNo);
						poOtherCmVO[i].setBkgNoSplit(bkgNoSplit);

					    poOtherCmVOdeleteVoList.add(poOtherCmVO[i]);
					}
				}
			    if(poOtherCmVOdeleteVoList.size() > 0) {
			    	dbDao.removeBkgRefDtl(poOtherCmVOdeleteVoList, caFlg);
			    }
			    if(poOtherCmVOupdateVoList.size() > 0) {
			    	dbDao.modifyBkgRefDtl(poOtherCmVOupdateVoList, caFlg);
			    }
		    	if(poOtherCmVOinsertVoList.size() > 0) {
		    		dbDao.addBkgRefDtl(poOtherCmVOinsertVoList, caFlg);
			    }
			}

			if( poOtherShipVO != null){
				List<BkgRefDtlVO> poOtherShipVOinsertVoList = new ArrayList<BkgRefDtlVO>();
				List<BkgRefDtlVO> poOtherShipVOupdateVoList = new ArrayList<BkgRefDtlVO>();
				List<BkgRefDtlVO> poOtherShipVOdeleteVoList = new ArrayList<BkgRefDtlVO>();
				int poOtherShipCnt = poOtherShipVO.length;
				for(int i = 0; i < poOtherShipCnt; i++) {
					if(poOtherShipVO[i].getIbflag().equals("I")) {
						log.debug("======>>> BC	manageRefDetail poOtherShipVO ADD:: "+bkgNo+bkgNoSplit);
						poOtherShipVO[i].setBkgNo(bkgNo);
						poOtherShipVO[i].setBkgNoSplit(bkgNoSplit);
						poOtherShipVO[i].setCntrNo(cntrNo);
						poOtherShipVO[i].setCreUsrId(account.getUsr_id());
						poOtherShipVO[i].setUpdUsrId(account.getUsr_id());
					    poOtherShipVOinsertVoList.add(poOtherShipVO[i]);
					} else if(poOtherShipVO[i].getIbflag().equals("U")) {
						log.debug("======>>> BC	manageRefDetail poOtherShipVOpoOtherShipVO UPDATE:: "+bkgNo+bkgNoSplit);
						poOtherShipVO[i].setBkgNo(bkgNo);
						poOtherShipVO[i].setBkgNoSplit(bkgNoSplit);
						poOtherShipVO[i].setUpdUsrId(account.getUsr_id());
					    poOtherShipVOupdateVoList.add(poOtherShipVO[i]);
					} else if(poOtherShipVO[i].getIbflag().equals("D")) {
						log.debug("======>>> BC	manageRefDetail poOtherShipVO DELETE:: "+bkgNo+bkgNoSplit);
						poOtherShipVO[i].setBkgNo(bkgNo);
						poOtherShipVO[i].setBkgNoSplit(bkgNoSplit);
					    poOtherShipVOdeleteVoList.add(poOtherShipVO[i]);
					}
				}
			    if(poOtherShipVOdeleteVoList.size() > 0) { 
			    	dbDao.removeBkgRefDtl(poOtherShipVOdeleteVoList, caFlg);
			    }
			    if(poOtherShipVOupdateVoList.size() > 0) {
			    	dbDao.modifyBkgRefDtl(poOtherShipVOupdateVoList, caFlg);
			    }
		    	if(poOtherShipVOinsertVoList.size() > 0) {
		    		dbDao.addBkgRefDtl(poOtherShipVOinsertVoList, caFlg);
			    }
			} 
		} catch(DAOException de) {
		    log.error("err " + de.toString(), de);
		    throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch(Exception de) {
		    log.error("err " + de.toString(), de);
		    throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		log.debug("============================>[[ GeneralBookingReceiptBCImpl  manageRefDetail END ]]<============================");
	}



	/**
	 * Reference 정보를 관리한다.<br>
	 *
	 * @param BkgReferenceVO[] bkgReferenceVOs
	 * @param SignOnUserAccount account
	 * @param BkgBlNoVO bkgBlNoVO
	 * @exception EventException
	 */
	public void manageRefNo(BkgReferenceVO[] bkgReferenceVOs, SignOnUserAccount account, BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			for ( int i=0; i<bkgReferenceVOs.length; i++ ) {
				if ( bkgReferenceVOs[i].getRefSeq() != null && !"".equals(bkgReferenceVOs[i].getRefSeq())){
					// ref_seq 가 존재하면 Update
					bkgReferenceVOs[i].setUpdUsrId(account.getUsr_id());
					bkgReferenceVOs[i].setUpdUsrId(account.getUsr_id());
					if("1".equals(bkgReferenceVOs[i].getCpyDescFlg())){
						bkgReferenceVOs[i].setCpyDescFlg("Y");
					}else{
						bkgReferenceVOs[i].setCpyDescFlg("N");
					}
					dbDao.modifyBkgReference(bkgReferenceVOs[i],bkgBlNoVO);
				}else{
					// ref_seq 가 존재하지 않으면 Insert
					if(bkgReferenceVOs[i].getCustRefNoCtnt()!=null){
						bkgReferenceVOs[i].setCreUsrId(account.getUsr_id());
						bkgReferenceVOs[i].setUpdUsrId(account.getUsr_id());
						if("1".equals(bkgReferenceVOs[i].getCpyDescFlg())){
							bkgReferenceVOs[i].setCpyDescFlg("Y");
						}else{
							bkgReferenceVOs[i].setCpyDescFlg("N");
						}
						
						if(!"SAMF".equals(bkgReferenceVOs[i].getBkgRefTpCd()) && dbDao.checkRefTpCd(bkgBlNoVO.getBkgNo(), bkgReferenceVOs[i].getBkgRefTpCd())) {
							throw new EventException((String)new ErrorHandler("BKG02110").getMessage());
						}
							
						dbDao.addBkgReference(bkgReferenceVOs[i],bkgBlNoVO);
					}
				}
			}

		} catch (EventException ex) {
			throw ex;			
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 *  House B/L에 해당하는 SCAC No 관리한다.<br>
	 *
	 * @author	KimByungKyu
	 * @param 	BkgUsaCstmsFileNoVO[] bkgUsaCstmsFileNoVOs
	 * @param 	SignOnUserAccount account
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @exception EventException
	 */
    public void manageNVOFileNumber(BkgUsaCstmsFileNoVO[] bkgUsaCstmsFileNoVOs, SignOnUserAccount account, BkgBlNoVO bkgBlNoVO) throws EventException {
        try {
            List<BkgUsaCstmsFileNoVO> insertVoList = new ArrayList<BkgUsaCstmsFileNoVO>();
            List<BkgUsaCstmsFileNoVO> updateVoList = new ArrayList<BkgUsaCstmsFileNoVO>();
            List<BkgUsaCstmsFileNoVO> deleteVoList = new ArrayList<BkgUsaCstmsFileNoVO>();
            if(bkgUsaCstmsFileNoVOs != null){
                for(int i = 0; i < bkgUsaCstmsFileNoVOs.length; i++) {
                    if(bkgUsaCstmsFileNoVOs[i].getIbflag().equals("I")) {

                    	bkgUsaCstmsFileNoVOs[i].setBkgNo(bkgBlNoVO.getBkgNo());
                    	bkgUsaCstmsFileNoVOs[i].setCreUsrId(account.getUsr_id());
                    	bkgUsaCstmsFileNoVOs[i].setUpdUsrId(account.getUsr_id());

                        insertVoList.add(bkgUsaCstmsFileNoVOs[i]);

                    } else if(bkgUsaCstmsFileNoVOs[i].getIbflag().equals("U")) {
                    	bkgUsaCstmsFileNoVOs[i].setBkgNo(bkgBlNoVO.getBkgNo());
                    	bkgUsaCstmsFileNoVOs[i].setUpdUsrId(account.getUsr_id());

                        updateVoList.add(bkgUsaCstmsFileNoVOs[i]);
                    } else if(bkgUsaCstmsFileNoVOs[i].getIbflag().equals("D")) {
                    	bkgUsaCstmsFileNoVOs[i].setBkgNo(bkgBlNoVO.getBkgNo());

                        deleteVoList.add(bkgUsaCstmsFileNoVOs[i]);
                    }
                }
                if(insertVoList.size() > 0) {
                	for(int i = 0; i < insertVoList.size(); i++){
	                	if(dbDao.modifyNVOFileNo(insertVoList.get(i), bkgBlNoVO) == 0){
	                		dbDao.addNVOFileNo(insertVoList.get(i), bkgBlNoVO);
	                	}
                	}
                }

                if(updateVoList.size() > 0) {
                    dbDao.modifyNVOFileNo(updateVoList, bkgBlNoVO);
                }

                if(deleteVoList.size() > 0) {
                    dbDao.removeNVOFileNo(deleteVoList, bkgBlNoVO);
                }            	
            }
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        }
    }

	/**
	 * Ocean Route 조회.(ESM_BKG_0092)<br>
	 *
	 * @author	KimByungKyu
	 * @param 	PolPodVvdVO[] polPodVvdVOs
	 * @param   String bkgNo
	 * @return 	OceanRouteVO
	 * @exception EventException
	 */
	public OceanRouteVO searchTsRoute(PolPodVvdVO[] polPodVvdVOs, String bkgNo) throws EventException {
		try {
			OceanRouteVO oceanRouteVO = new OceanRouteVO();
			VslSkdVO vslSkdVO = null;
			List<VslSkdVO> vslSkdVOs = new ArrayList<VslSkdVO>();
			if(polPodVvdVOs != null && polPodVvdVOs.length > 0){
				// 01. ETA of 1st VVD 조회
				oceanRouteVO.setN1stEtaDelEtaVO(dbDao.search1stVvdEta(polPodVvdVOs[0], bkgNo));

				// 02. Ocean Route 목록 조회
				for(int i = 0 ; i < polPodVvdVOs.length ; i++){
					// 새로 조회된 정보를 VslSkdVO 에 담는다.
					vslSkdVO = null;
					if(polPodVvdVOs[i].getBkgVvdCd().length()==9){
						vslSkdVO = dbDao.searchLaneEtdEta(polPodVvdVOs[i]);

						// 화면에 내용을 VslSkdVO에 추가한다.
						if(vslSkdVO == null){
							vslSkdVO = new VslSkdVO();
							vslSkdVO.setSlanCd("");
							vslSkdVO.setPolYdCd("");
							vslSkdVO.setPodYdCd("");
							vslSkdVO.setPolClptIndSeq("");
							vslSkdVO.setPolClptIndSeqList("");
							vslSkdVO.setPodClptIndSeq("");
							vslSkdVO.setPodClptIndSeqList("");
							vslSkdVO.setEta("");
							vslSkdVO.setEtaDay("");
							vslSkdVO.setEtaTime("");
							vslSkdVO.setEtd("");
							vslSkdVO.setEtdDay("");
							vslSkdVO.setEtdTime("");
							
							if(polPodVvdVOs[i].getPolYdCd()!=null && polPodVvdVOs[i].getPolYdCd().length()==2
									&& polPodVvdVOs[i].getPodYdCd()!=null && polPodVvdVOs[i].getPodYdCd().length()==2){
									
								polPodVvdVOs[i].setPolClptIndSeq("");
								polPodVvdVOs[i].setPodClptIndSeq("");
								
								VslSkdVO vslSkdVO2 = dbDao.searchLaneEtdEta(polPodVvdVOs[i]);
								if(vslSkdVO2 != null){
									vslSkdVO.setSlanCd(vslSkdVO2.getSlanCd());
									vslSkdVO.setPolYdCd(vslSkdVO2.getPolYdCd());
									vslSkdVO.setPodYdCd(vslSkdVO2.getPodYdCd());
									vslSkdVO.setPolClptIndSeqList(vslSkdVO2.getPolClptIndSeqList());
									vslSkdVO.setPodClptIndSeqList(vslSkdVO2.getPodClptIndSeqList());
								}
							}
						}
					}
					if(vslSkdVO == null){
						vslSkdVO = new VslSkdVO();
						vslSkdVO.setSlanCd("");

						if(polPodVvdVOs[i].getPolYdCd()!=null && polPodVvdVOs[i].getPolYdCd().length()==2){
							vslSkdVO.setPolYdCd(polPodVvdVOs[i].getPolYdCd());							
						} else {
							vslSkdVO.setPolYdCd("");
						}
						if(polPodVvdVOs[i].getPodYdCd()!=null && polPodVvdVOs[i].getPodYdCd().length()==2){
							vslSkdVO.setPodYdCd(polPodVvdVOs[i].getPodYdCd());							
						} else {
							vslSkdVO.setPodYdCd("");
						}
						vslSkdVO.setPolClptIndSeq("");
						vslSkdVO.setPolClptIndSeqList("");
						vslSkdVO.setPodClptIndSeq("");
						vslSkdVO.setPodClptIndSeqList("");
						vslSkdVO.setEta("");
						vslSkdVO.setEtaDay("");
						vslSkdVO.setEtaTime("");
						vslSkdVO.setEtd("");
						vslSkdVO.setEtdDay("");
						vslSkdVO.setEtdTime("");
					}
					
					vslSkdVO.setPolCd   (polPodVvdVOs[i].getPolCd());
					vslSkdVO.setPodCd   (polPodVvdVOs[i].getPodCd());
					vslSkdVO.setBkgVvdCd(polPodVvdVOs[i].getBkgVvdCd());
					
					vslSkdVOs.add(vslSkdVO); 					
				}
				if(vslSkdVOs.size()==0){
					for(int i = 0 ; i < polPodVvdVOs.length ; i++){
						vslSkdVO = new VslSkdVO();
						vslSkdVO.setPolCd   (polPodVvdVOs[i].getPolCd());
						vslSkdVO.setPolYdCd (polPodVvdVOs[i].getPolYdCd());
						vslSkdVO.setPodCd   (polPodVvdVOs[i].getPodCd());
						vslSkdVO.setPodYdCd (polPodVvdVOs[i].getPodYdCd());
						vslSkdVO.setBkgVvdCd(polPodVvdVOs[i].getBkgVvdCd());
						vslSkdVOs.add(vslSkdVO);
					}
				}
				oceanRouteVO.setVslSkd(vslSkdVOs);
			}else{
				oceanRouteVO.setVslSkdVO(vslSkdVO);
				oceanRouteVO.setVslSkd(vslSkdVOs);
			}

			return oceanRouteVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		}
	}

	/**
	 * Ocean Route Lane/POL ETD/POD ETA 조회.(ESM_BKG_0092)<br>
	 *
	 * @author	KimByungKyu
	 * @param 	PolPodVvdVO polPodVvdVO
	 * @return 	VslSkdVO
	 * @exception EventException
	 */
	public VslSkdVO searchLaneEtaEtd(PolPodVvdVO polPodVvdVO) throws EventException {
		try {
			VslSkdVO vslSkdVO = new VslSkdVO();
			vslSkdVO = dbDao.searchLaneEtdEta(polPodVvdVO);
			
			if(vslSkdVO == null){
				vslSkdVO = new VslSkdVO();
				vslSkdVO.setSlanCd("");
				vslSkdVO.setPolYdCd("");
				vslSkdVO.setPodYdCd("");
				vslSkdVO.setPolClptIndSeq("");
				vslSkdVO.setPolClptIndSeqList("");
				vslSkdVO.setPodClptIndSeq("");
				vslSkdVO.setPodClptIndSeqList("");
				vslSkdVO.setEta("");
				vslSkdVO.setEtaDay("");
				vslSkdVO.setEtaTime("");
				vslSkdVO.setEtd("");
				vslSkdVO.setEtdDay("");
				vslSkdVO.setEtdTime("");
				
				if(polPodVvdVO.getPolYdCd()!=null && polPodVvdVO.getPolYdCd().length()==2
						&& polPodVvdVO.getPodYdCd()!=null && polPodVvdVO.getPodYdCd().length()==2){
						
					polPodVvdVO.setPolClptIndSeq("");
					polPodVvdVO.setPodClptIndSeq("");
					
					VslSkdVO vslSkdVO2 = dbDao.searchLaneEtdEta(polPodVvdVO);
					if(vslSkdVO2 != null){
						vslSkdVO.setSlanCd(vslSkdVO2.getSlanCd());
						vslSkdVO.setPolYdCd(vslSkdVO2.getPolYdCd());
						vslSkdVO.setPodYdCd(vslSkdVO2.getPodYdCd());
						vslSkdVO.setPolClptIndSeqList(vslSkdVO2.getPolClptIndSeqList());
						vslSkdVO.setPodClptIndSeqList(vslSkdVO2.getPodClptIndSeqList());
					}
				}
			}

			vslSkdVO.setPolCd   (polPodVvdVO.getPolCd());
			vslSkdVO.setPodCd   (polPodVvdVO.getPodCd());
			vslSkdVO.setBkgVvdCd(polPodVvdVO.getBkgVvdCd());
			
			return vslSkdVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		}
	}
	
	/**
	 * Ocean Route Lane/POL ETD/POD ETA 조회.(ESM_BKG_0092)<br>
	 *
	 * @author	KimByungKyu
	 * @param 	PolPodVvdVO[] polPodVvdVOs
	 * @exception EventException
	 */
	public void validateTsRoute(PolPodVvdVO[] polPodVvdVOs) throws EventException {
		try {
			BookingUtil util = new BookingUtil();

			if(polPodVvdVOs != null && polPodVvdVOs.length > 0){
				String vslCd = "";
				String voyNo = "";
				String dirCd = "";
				//String bkgVvdCd = "";
				PolPodVvdVO polPodVvdVO = null;
//				SearchLocationCodeVO searchLocationCodeVO = 	null;
				VskVslPortSkdVO vskVslPortSkdVO = new VskVslPortSkdVO();

				String curPodCd = "";
				String befPodCd = "";
				String befBkgVvdCd = "";
				String curBkgVvdCd = "";
				String curPolCd = "";
				String podClptIndSeq = "";
				String polClptIndSeq = "";
				String etdDt = "";
				String etaDt = "";
//				String befEtaDt = "";
				String befEtdDt = "";
				
				PrdMainInfoVO prdMainInfoVO = new PrdMainInfoVO();
				
				for(int i = 0 ; i < polPodVvdVOs.length ; i++){
					polPodVvdVO = polPodVvdVOs[i];

					curPodCd = polPodVvdVO.getPodCd();
					curPolCd = polPodVvdVO.getPolCd();
					podClptIndSeq = polPodVvdVO.getPodClptIndSeq();
					polClptIndSeq = polPodVvdVO.getPolClptIndSeq();
					curBkgVvdCd = polPodVvdVO.getBkgVvdCd();
					
					if(curPolCd.length()<1) continue;
					
					// 01. searchTsRouteForEqualPort를 수행한다.
					if(i > 0 && i < polPodVvdVOs.length){
						// PodCd,PolCd 값 존재여부 확인.
						if(!curPolCd.equals(befPodCd)){
							if(!dbDao.searchTSRouteForEqualPort(curPolCd, befPodCd)){
								throw new EventException((String)new ErrorHandler("BKG01038").getMessage());
							}
						}
					}
					
					// 생략, searchEtbEtdEta()과 중복 기능임
//					// 02. searchLocationCode를 수행한다.
//					// 02-1. PolCd 체크
//					searchLocationCodeVO = utilBC.searchLocationCode(curPolCd);
//					if(searchLocationCodeVO == null || "N".equals(searchLocationCodeVO.getPortInlndCd())){
//						throw new EventException((String)new ErrorHandler("BKG00138").getMessage());
//					}
//					// 02-2. Pod 체크
//					searchLocationCodeVO = utilBC.searchLocationCode(curPodCd);
//					if(searchLocationCodeVO == null || "N".equals(searchLocationCodeVO.getPortInlndCd())){
//						throw new EventException((String)new ErrorHandler("BKG00138").getMessage());
//					}

					//bkgVvdCd = polPodVvdVO.getBkgVvdCd();
					if(isCheckVvdCd(curBkgVvdCd) && curBkgVvdCd.length()==9){
						vslCd = curBkgVvdCd.substring(0,4);
						voyNo = curBkgVvdCd.substring(4,8);
						dirCd = curBkgVvdCd.substring(8,9);

						// 생략, searchEtbEtdEta()과 중복 기능임
						// 03. validateVvd를 수행한다.
//						if(!utilBC.validateVvd(vslCd, voyNo, dirCd)){
//							throw new EventException((String)new ErrorHandler("BKG00144").getMessage());
//						}
//
//
//						// 04. searchSvcLaneByLoc를 수행한다.(BKG00140)
//						if(!utilBC.searchSvcLaneByLoc(polPodVvdVO.getSlanCd(), curPodCd)){
//							throw new EventException((String)new ErrorHandler("BKG00140",new String[]{polPodVvdVO.getSlanCd()}).getMessage());
//						}
//
//
//						// 05. validateVvdLoc를 수행한다.
//						if(!utilBC.validateVvdLoc(vslCd, voyNo, dirCd, curPodCd)){
//							throw new EventException((String)new ErrorHandler("BKG00720", new String[]{curBkgVvdCd, curPolCd, curPodCd}).getMessage());
//						}

						// 06. searchEtbEtdEta를 수행한다.
						// 06-01. PolCd 체크(이전데이터의 ClptIndSeq)
						vskVslPortSkdVO = util.searchEtbEtdEta(vslCd, voyNo, dirCd, curPolCd, polClptIndSeq);
						if(vskVslPortSkdVO != null){
							etdDt = vskVslPortSkdVO.getVpsEtdDt();
						} else {
							throw new EventException((String)new ErrorHandler("BKG00720", new String[]{curBkgVvdCd, curPolCd, curPodCd}).getMessage());
						}
						
						// 06-02. PodCd 체크(현재데이터의 ClptIndSeq)
						vskVslPortSkdVO = util.searchEtbEtdEta(vslCd, voyNo, dirCd, curPodCd, podClptIndSeq);
						if(vskVslPortSkdVO != null){
							etaDt = vskVslPortSkdVO.getVpsEtaDt();
						} else {
							throw new EventException((String)new ErrorHandler("BKG00720", new String[]{curBkgVvdCd, curPolCd, curPodCd}).getMessage());
							
						}
						
						if(!"".equals(befBkgVvdCd) &&  isCheckVvdCd(befBkgVvdCd)){
							log.debug("### BefEtd : " + befEtdDt + "/" + "CurEta : " + etaDt);
							if(i > 0){
								if(befEtdDt != null && befEtdDt.length() > 0 && etaDt != null && etaDt.length() > 0){
									if(daysBetweens(befEtdDt, etaDt) >= 0){
										throw new EventException((String)new ErrorHandler("BKG01037").getMessage());
									}
								}else{
									throw new EventException((String)new ErrorHandler("BKG01037").getMessage());
								}							
							}							
						}
					} else {
						vskVslPortSkdVO.setSlanCd("");
					}
					befPodCd = curPodCd;
					befBkgVvdCd = curBkgVvdCd;
//					befEtaDt = etaDt;
					befEtdDt = etdDt;

					if(i==0){
						prdMainInfoVO.setPol(curPolCd);
						prdMainInfoVO.setPol1(curPolCd);
						prdMainInfoVO.setPod1(curPodCd);
						prdMainInfoVO.setPod(curPodCd);		
						if(vskVslPortSkdVO!=null){
							prdMainInfoVO.setLane1(vskVslPortSkdVO.getSlanCd());
						}
					} else if (i==1){
						prdMainInfoVO.setPol2(curPolCd);
						prdMainInfoVO.setPod2(curPodCd);
						prdMainInfoVO.setPod(curPodCd);		
						if(vskVslPortSkdVO!=null){		
							prdMainInfoVO.setLane2(vskVslPortSkdVO.getSlanCd());
						}
					} else if (i==2){
						prdMainInfoVO.setPol3(curPolCd);
						prdMainInfoVO.setPod3(curPodCd);
						prdMainInfoVO.setPod(curPodCd);		
						if(vskVslPortSkdVO!=null){	
							prdMainInfoVO.setLane3(vskVslPortSkdVO.getSlanCd());	
						}
					} else if (i==3){
						prdMainInfoVO.setPol4(curPolCd);
						prdMainInfoVO.setPod4(curPodCd);
						prdMainInfoVO.setPod(curPodCd);		
						if(vskVslPortSkdVO!=null){
							prdMainInfoVO.setLane4(vskVslPortSkdVO.getSlanCd());	
						}
					}
				}
				if(polPodVvdVOs.length<5){
					// ocean route 연결 validation
					ValidateOceanRouteVO validateOceanRouteVO = dbDao.validateOceanRoute(prdMainInfoVO);
					int routeCount = Integer.parseInt(validateOceanRouteVO.getRoute());
					
					if(routeCount == 0){
						String strErrMsg = prdMainInfoVO.getPol1()+"-"+prdMainInfoVO.getPod1()+"("+prdMainInfoVO.getLane1()+")";
						if(prdMainInfoVO.getPol2()!=null&&prdMainInfoVO.getPol2().length()>0){
							strErrMsg = strErrMsg + ", " + prdMainInfoVO.getPol2()+"-"+prdMainInfoVO.getPod2()+"("+prdMainInfoVO.getLane2()+")";
						}
						if(prdMainInfoVO.getPol3()!=null&&prdMainInfoVO.getPol3().length()>0){
							strErrMsg = strErrMsg + ", " + prdMainInfoVO.getPol3()+"-"+prdMainInfoVO.getPod3()+"("+prdMainInfoVO.getLane3()+")";
						}
	
						if(prdMainInfoVO.getPol4()!=null&&prdMainInfoVO.getPol4().length()>0){
							strErrMsg = strErrMsg + ", " + prdMainInfoVO.getPol4()+"-"+prdMainInfoVO.getPod4()+"("+prdMainInfoVO.getLane4()+")";
						}
						log.debug(strErrMsg);
						throw new EventException((String)new ErrorHandler("BKG02030", new String[]{strErrMsg}).getMessage());
					}
				}
			}else{
				throw new EventException((String)new ErrorHandler("BKG00380").getMessage());
			}
		} catch (EventException ex) {
			throw ex;			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		}
	}
	/**
	 * 두 날짜의 차이.(ESM_BKG_0092)<br>
	 *
	 * @author	KimByungKyu
	 * @param 	String date1
	 * @param 	String date2
	 * @return		long
	 * @exception Exception
	 */
	private long daysBetweens(String date1, String date2)
	{

		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
        try
        {
			c1.setTime(sf.parse(date1));
			c2.setTime(sf.parse(date2));

			long result = (long)(c1.getTime().getTime() - c2.getTime().getTime());
			log.debug("result : " + result);
			return result;

		} catch (Exception e) {
			log.error(e.toString()); // 2011.07.14
			return 0;
		}
	}

	/**
	 * Tro quantity 를 변경한다.(ESM_BKG_0079_02A)<br>
	 * 
	 * @author Lee NamKyung
	 * @param  BkgQuantityVO[] arrBkgQuantityVO
	 * @param  String boundCd
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyBkgQtyByTro(BkgQuantityVO[] arrBkgQuantityVO, String boundCd, SignOnUserAccount account) throws EventException {
		try {
			for(int i=0; i<arrBkgQuantityVO.length; i++) {
				if(arrBkgQuantityVO[i].getIbflag().equals("U")) {
					dbDao.modifyBkgQtyByTro(arrBkgQuantityVO[i], boundCd, account);
				}
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * 한국 tro request시 booking 정보에 update한다.(ESM_BKG_0079_02B)<br>
	 * 
	 * @author Lee NamKyung
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @exception EventException
	 */
	public void modifyKrPkupRtnCy(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			dbDao.modifyKrPkupRtnCy(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * 구주 tro confirm시 booking 정보에 update한다.(ESM_BKG_0079_02C)<br>
	 * 
	 * @author Shin Jayoung
	 * @param  BkgBlNoVO bkgBlNoVO
	 * @exception EventException
	 */
	public void modifyEurPkupRtnCy(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			dbDao.modifyEurPkupRtnCy(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * BookingCreation 사용자 Default 정보 조회.(ESM_BKG_0079_01 김병규)<br>
	 *
	 * @author	KimByungKyu
	 * @param 	SignOnUserAccount account
	 * @return 	BkgUsrDfltSetVO
	 * @exception 	EventException
	 */
	public BkgUsrDfltSetVO searchUserBkgDefault(SignOnUserAccount account) throws EventException {
		try {
			return dbDao.searchUserBkgDefault(account.getUsr_id());
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		}
	}

	/**
	 * BookingCreation CmdtCd로 정보 조회.(ESM_BKG_0079_01 김병규)<br>
	 *
	 * @author	KimByungKyu
	 * @param 	String cmdtCd
	 * @return 	CmdtVO
	 * @exception EventException
	 */
	public CmdtVO validatePrecaution(String cmdtCd) throws EventException {
		try {
			return dbDao.searchPrecaution(cmdtCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);			
		}
	}

	/**
	 * BookingCreation CmdtCd로 정보 조회.(ESM_BKG_0079_01)<br>
	 *
	 * @param 	String cmdtCd
	 * @return 	String
	 * @exception EventException
	 */
	public String validateChnWasteCmdt(String cmdtCd) throws EventException {
		try {
			return dbDao.validateChnWasteCmdt(cmdtCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);			
		}
	}

	/**
	 * 미주OB에 대해서 특정 cmdt code를 입력하면 Vehicle에 자동 체크 (ESM_BKG_0079_01)<br>
	 *
	 * @param 	String cmdtCd
	 * @return 	String
	 * @exception EventException
	 */
	public String validateUSVehicleCommodity(String cmdtCd) throws EventException {
		try {
			return dbDao.validateUSVehicleCommodity(cmdtCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);			
		}
	}

	/**
	 * BookingCreation VVD, BKG_NO로 정보 조회.(ESM_BKG_0079_01)<br>
	 *
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param   List<String> paramVvds
	 * @return 	String
	 * @exception EventException
	 */
	public String searchManifestTrans(BkgBlNoVO bkgBlNoVO, List<String> paramVvds) throws EventException {
		try {
			return dbDao.searchManifestTrans(bkgBlNoVO, paramVvds);			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);			
		}
	}
	
	/**
	 * cct 정보를 저장<br>
	 * 
	 * @param  BkgClzTmVO[] bkgClzTmVOs
	 * @param  SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageCargoClosingTime(BkgClzTmVO[] bkgClzTmVOs,SignOnUserAccount account) throws EventException {
		try {
			//cargo closing time이
			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
			bkgBlNoVO.setBkgNo(bkgClzTmVOs[0].getBkgNo());

			dbDao.addCargoClosingTime(bkgBlNoVO, account);
//			manual 변경하는 경우 rail date 그대로 유지하게 처리
			dbDao.modifyCargoClosingTimeByReplan(bkgBlNoVO, "N", "N", account);
			
			for ( int i=0; i<bkgClzTmVOs.length; i++ ) {
				if(bkgClzTmVOs[i].getNtcFlg().equals("0")){ //unchecked
					bkgClzTmVOs[i].setNtcFlg("N");
				}else if(bkgClzTmVOs[i].getNtcFlg().equals("1")){
					bkgClzTmVOs[i].setNtcFlg("Y");
				}
//				if(bkgClzTmVOs[i].getMnlSetDt() != null 
//						&& bkgClzTmVOs[i].getMnlSetDt().length() != 14){
//					throw new EventException((String)new ErrorHandler("BKG06012", new String[]{bkgClzTmVOs[i].getMnlSetDt()}).getMessage());					
//				}
				bkgClzTmVOs[i].setUpdUsrId(account.getUsr_id());
				dbDao.modifyCargoClosingTime(bkgClzTmVOs[i]);
			}
		} catch (EventException ex) {
			throw ex;				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * BookingCreation 정보 조회.(ESM_BKG_0079_01 김병규)<br>
	 *
	 * @author	KimByungKyu
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @return 	BookingCreationVO
	 * @exception EventException
	 */
	public BookingCreationVO searchBooking(BkgBlNoVO bkgBlNoVO) throws EventException {
		BookingCreationVO bookingCreationVO = null;
		try {
			BkgBlNoVO schBkgBlNoVO = null;
			BkgBookingInfoVO bkgBookingInfoVO = null;
			List<VslSkdVO> vslSkd = null;
			List<BkgQuantityVO> bkgQuantity = null;
			List<BkgQtyDtlVO> bkgQtyDtl = null;
			BlCustomerInfoVO blCustomerInfoVO = null;
			List<BkgCntcPsonVO> bkgCntcPson = null;
			String filerCd = null;
			String vvdFlag = null;
			String rfaAvailable = "Y";
			String scAvailable = "Y";
			String taaAvailable = "Y";
			String rejectFlag = "N";
			String eurTroCfm = null;
			SplitMstBlNoVO splitMstBlNo = null;

			BookingUtil utilBC = new BookingUtil();			

			// 01. searchBkgBlNoVO
			schBkgBlNoVO = utilBC.searchBkgBlNoVO(bkgBlNoVO);

			if(schBkgBlNoVO != null){
				// 02. searchBkgBookingInfo(Booking 정보)
				bkgBookingInfoVO = dbDao.searchBkgBookingInfo(schBkgBlNoVO);

				if(bkgBookingInfoVO != null){
					bookingCreationVO = new BookingCreationVO();

					if("P".equals(bkgBookingInfoVO.getBkgCgoTpCd())){
						// You can not retrieve Empty Reposition BKG Data
						throw new EventException((String)new ErrorHandler("BKG00092").getMessage());
//						bookingCreationVO.setBkgBookingInfoVO(bkgBookingInfoVO);
					}else{

						// 03. searchVvdSkdForTsRoute.
						vslSkd = dbDao.searchVvdSkdForTsRoute(schBkgBlNoVO);
						// 04. searchBkgQuantity
						bkgQuantity = dbDao.searchBkgQuantity(schBkgBlNoVO);
						// 05. searchBkgQtyDtl
						bkgQtyDtl = dbDao.searchBkgQtyDtl(schBkgBlNoVO);
						// 06. searchBkgCustomer
						blCustomerInfoVO = dbDao.searchBkgCustomer("B", schBkgBlNoVO);
						// 07. searchBkgCntcPson
						bkgCntcPson = dbDao.searchBkgCntcPson(schBkgBlNoVO);
						// 08. searchVslSkdAvailable
						if(dbDao.searchVslSkdAvailable(schBkgBlNoVO)){
							vvdFlag = "Y";
						}else{
							vvdFlag = "N";
						}
						// 09. searchFrob
						filerCd = utilBC.searchFrob(schBkgBlNoVO.getBkgNo(), bkgBookingInfoVO.getBkgTrunkVvd(), bkgBookingInfoVO.getBkgPolCd(), bkgBookingInfoVO.getBkgPodCd());

						String rfaNo = bkgBookingInfoVO.getRfaNo();
						if(rfaNo != null && rfaNo.length()>0 && !rfaNo.startsWith("DUM")){
							// 10. searchRfaAvailable
							if(!utilBC.searchRfaAvailable(rfaNo, schBkgBlNoVO)){
								rfaAvailable = "N";
							}
						}
						String scNo = bkgBookingInfoVO.getScNo();
						if(scNo != null && scNo.length()>0 && !scNo.startsWith("DUM")){
							// 11. searchScAvailable
							if(!utilBC.searchScAvailable(scNo, schBkgBlNoVO)){
								scAvailable = "N";
							}
						}
						
						String taaNo = bkgBookingInfoVO.getTaaNo();
						if(taaNo != null && taaNo.length()>0 && !taaNo.startsWith("DUM")){
							// 11. searchScAvailable
							if(!utilBC.searchTaaAvailable(taaNo, schBkgBlNoVO)){
								taaAvailable = "N";
							}
						}

						// 12. searchSpclNotApprove
						rejectFlag = dbDao.searchSpclNotApprove(schBkgBlNoVO);

						// 13. searchEurTroCfm
						eurTroCfm = dbDao.searchEurTroCfm(schBkgBlNoVO.getBkgNo());
						//log.debug("eurTroConf : "+eurTroConf);
						// 14. searchSplitMstBlNo
						if(!"Y".equals(schBkgBlNoVO.getCaFlg())){
							splitMstBlNo = utilBC.searchSplitMstBlNo(schBkgBlNoVO.getBkgNo());
						}

						// 2010-07-30 KMJ ADD
						boolean isRatedFlg = dbDao.searchIsRated(bkgBlNoVO);
						String sRatedFlg = "N";
						if (isRatedFlg == true) sRatedFlg = "Y";
						bkgBookingInfoVO.setIsRatedFlg(sRatedFlg);
						
						bkgBookingInfoVO.setVvdFlag(vvdFlag);
						bkgBookingInfoVO.setFilerCd(filerCd);
						bkgBookingInfoVO.setRfaAvailable(rfaAvailable);
						bkgBookingInfoVO.setScAvailable(scAvailable);
						bkgBookingInfoVO.setTaaAvailable(taaAvailable);
						bkgBookingInfoVO.setRejectFlag(rejectFlag);
						bkgBookingInfoVO.setEurTroCfm(eurTroCfm);
						
						boolean actCustListExistFlg = dbDao.checkActualCustomerListExist(bkgBlNoVO);
						String sActCustListExistFlg = "N";
						if (actCustListExistFlg == true) sActCustListExistFlg = "Y";
						bkgBookingInfoVO.setActCustListExistFlg(sActCustListExistFlg);

						bookingCreationVO.setBkgBookingInfoVO(bkgBookingInfoVO);
						bookingCreationVO.setVslSkd(vslSkd);
						bookingCreationVO.setBkgQuantity(bkgQuantity);
						bookingCreationVO.setBkgQtyDtl(bkgQtyDtl);
						bookingCreationVO.setBlCustomerInfoVO(blCustomerInfoVO);
						bookingCreationVO.setBkgCntcPson(bkgCntcPson);
						bookingCreationVO.setSplitMstBlNoVO(splitMstBlNo);
						bookingCreationVO.setBkgBlNoVO(schBkgBlNoVO);
					}
				}else{
					// No data found.
					//throw new EventException((String)new ErrorHandler("BKG00095").getMessage());
				}
			}
		} catch (EventException ex) {
			throw ex;					
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return bookingCreationVO;
	}

	/**
	 * VVD를 Check해야하는지 여부<br>
	 *
	 * @author	KimByungKyu
	 * @param 	String vvd
	 * @return  	boolean
	 * @exception Exception
	 */
	private boolean isCheckVvdCd(String vvd){
		boolean isOk = false;
		try{
			if(vvd != null && vvd.length() > 0){
				if(!vvd.startsWith("HJXX") && !vvd.startsWith("HJYY") && !vvd.startsWith("HJZZ")){
					isOk = true;
				}
			}			
		}catch(Exception e){
			log.error(e.toString()); // 2011.07.14
			isOk = false;
		}
		return isOk;
	}
	
	/**
	 * Booking 생성/수정시 입력값이 적합한지 확인한다.(ESM_BKG_0079_01 김병규)<br>
	 *
	 * @author	KimByungKyu
	 * @param 	BookingCreationVO bookingCreationVO
	 * @param 	SignOnUserAccount account 
	 * @return 	BookingCreationVO
	 * @exception 	EventException
	 */
	public BookingCreationVO validateBookingSave(BookingCreationVO bookingCreationVO, SignOnUserAccount account) throws EventException {
		String bkgNo = "";
		try {
			BkgBookingInfoVO bkgBookingInfoVO = bookingCreationVO.getBkgBookingInfoVO();

			String infoMsg = "";
			if(bkgBookingInfoVO != null){
				bkgNo = bkgBookingInfoVO.getBkgNo();	
				BkgBlNoVO 				bkgBlNoVO 		= bookingCreationVO.getBkgBlNoVO();
				BlCustomerInfoVO 		blCustomerInfoVO= bookingCreationVO.getBlCustomerInfoVO();
				BkgQuantityVO[] 		bkgQuantityVOs 	= bookingCreationVO.getBkgQuantityVOs();
				//VslSkdVO[] 				vslSkdVOs 		= bookingCreationVO.getVslSkdVOs();
				BookingSaveValidationVO saveValidationVO= bookingCreationVO.getBookingSaveValidationVO();
				BookingUtil util = new BookingUtil();

				log.debug("bkgNo : [" + bkgBlNoVO.getBkgNo() + "], blNo : ["+bkgBlNoVO.getBlNo() + "], " + 
						  "CaFlg : [" + bkgBlNoVO.getCaFlg() + "], pctl : ["+bkgBlNoVO.getPctlNo()+"]");

				// BKG Creation 및 e-BKG 업로드 시에 co_biz 사용 여부 확인
				BlDocCustVO blDocCustVO = null;
				blDocCustVO = new BlDocCustVO();
				blDocCustVO.setBkgNo(bkgBlNoVO.getBkgNo());
				blDocCustVO.setCnCustCntCd(blCustomerInfoVO.getCCustCntCd());
				blDocCustVO.setCnCustSeq(blCustomerInfoVO.getCCustSeq());
				if ("Y".equalsIgnoreCase(dbDao.searchRepCustFlag(blDocCustVO, bkgBlNoVO.getCaFlg()))) {
					// BKG Creation 및 e-BKG 업로드 시에 아래에서 'Y'가 리턴 될 경우 저장 불가
					// Rep. customer code of HJS office is not valid. please update customer code only.
					throw new EventException((String)new ErrorHandler("BKG02073").getMessage());
				}

				// t.vvd나 pod가 없을 때는 반드시 pctl no가 있어야한다.
				if((bkgBookingInfoVO.getBkgTrunkVvd()== null || bkgBookingInfoVO.getBkgPodCd() == null)
					&& (bkgBlNoVO.getPctlNo()== null ||bkgBlNoVO.getPctlNo().length()<20)){
					throw new EventException((String)new ErrorHandler("BKG00658").getMessage());
				}
// 안정화이후 까지 주석 처리				
//				//c/a이면서 vvd 5개 이상이면 route 변경 처리 하지 않음
//				if("Y".equals(bkgBlNoVO.getCaFlg()) && VslSkdVOs.length>4){
//					saveValidationVO.setRouteModifyFlag("N");
//				}
				
				if(!"Over T/S".equals(bkgBlNoVO.getPctlNo()) && "Y".equals(saveValidationVO.getRouteModifyFlag())){// 변경된 route 정보
					PrdRouteVO prdRoute = dbDao.searchBkgRouteFromPrd(bkgBlNoVO);
					bkgBookingInfoVO.setBkgPorCd   (prdRoute.getPorCd());
					bkgBookingInfoVO.setBkgPorYdCd (prdRoute.getPorNodCd());
					bkgBookingInfoVO.setBkgPolCd   (prdRoute.getPolCd());
					bkgBookingInfoVO.setBkgPolYdCd (prdRoute.getPolNodCd());
					bkgBookingInfoVO.setBkgPodCd   (prdRoute.getPodCd());
					bkgBookingInfoVO.setBkgPodYdCd (prdRoute.getPodNodCd());
					bkgBookingInfoVO.setBkgDelCd   (prdRoute.getDelCd());	
					bkgBookingInfoVO.setBkgDelYdCd (prdRoute.getDelNodCd());
					bkgBookingInfoVO.setSlanCd     (prdRoute.getTrnkSlanCd());					
					bkgBookingInfoVO.setBkgTrunkVvd    (prdRoute.getVslCd()+prdRoute.getSkdVoyNo()+prdRoute.getSkdDirCd());
					saveValidationVO.setTrunkVvd(prdRoute.getVslCd()+prdRoute.getSkdVoyNo()+prdRoute.getSkdDirCd());
					if(bookingCreationVO.getOldBkgInfoVO() == null){
						saveValidationVO.setChangeFirstVvd(prdRoute.getFirstVvd());
					} else if(!bookingCreationVO.getOldBkgInfoVO().getFirstVvd().equals(prdRoute.getFirstVvd())){
						saveValidationVO.setChangeFirstVvd(prdRoute.getFirstVvd());
					} else {
						saveValidationVO.setChangeFirstVvd("N");
					}
				} else {
					bkgBookingInfoVO.setSlanCd(util.searchSvcLaneByVvd(bkgBookingInfoVO.getBkgTrunkVvd()));
				}
							
				String oldBkgNo = bkgBookingInfoVO.getOldBkgNo();
				String porCd    = bkgBookingInfoVO.getBkgPorCd();
				String porNodCd = (bkgBookingInfoVO.getBkgPorYdCd().length()==2)?(porCd+bkgBookingInfoVO.getBkgPorYdCd()):bkgBookingInfoVO.getBkgPorYdCd();
				String polCd    = bkgBookingInfoVO.getBkgPolCd();
				String podCd    = bkgBookingInfoVO.getBkgPodCd();
				String delCd    = bkgBookingInfoVO.getBkgDelCd();
				String trunkVvd = bkgBookingInfoVO.getBkgTrunkVvd();
				String laneCd   = bkgBookingInfoVO.getSlanCd();		
				
				String newSpclCgoFlag = "N";
				if(oldBkgNo != null && oldBkgNo.length() > 0){
					if("X".equals(util.searchBkgStatusByBkg(bkgBlNoVO))){
						throw new EventException((String)new ErrorHandler("BKG00433").getMessage());
					}
					
					String dgCgoFlg = (bkgBookingInfoVO.getDcgoFlg().length()<1)?"N":bkgBookingInfoVO.getDcgoFlg();
					String rfCgoFlg = (bkgBookingInfoVO.getRcFlg().length()<1)?"N":bkgBookingInfoVO.getRcFlg();
					String akCgoFlg = (bkgBookingInfoVO.getAwkCgoFlg().length()<1)?"N":bkgBookingInfoVO.getAwkCgoFlg();
					String bbCgoFlg = (bkgBookingInfoVO.getBbCgoFlg().length()<1)?"N":bkgBookingInfoVO.getBbCgoFlg();
					if(!bkgBookingInfoVO.getDcgoFlgOld().equals(dgCgoFlg)||
						!bkgBookingInfoVO.getRcFlgOld().equals(rfCgoFlg)||
						!bkgBookingInfoVO.getAwkCgoFlgOld().equals(akCgoFlg)||
						!bkgBookingInfoVO.getBbCgoFlgOld().equals(bbCgoFlg)){
						newSpclCgoFlag = "Y";						
					}		
				}
				
				// 20100204 Booking Close 관련 로직 추가
				// VVD 변경 여부 확인/Qty증감여부 확인/SpclCgoFlg 변경 여부 확인				
				log.debug("QtyModifyFlag : " + saveValidationVO.getQtyModifyFlag());
				log.debug("RouteModifyFlag : " + saveValidationVO.getRouteModifyFlag());
				log.debug("NewSpclCgoFlag : " + newSpclCgoFlag);
				log.debug("CloseBkgFlag : " + saveValidationVO.getCloseBkgFlag());
				log.debug("CbfBkgFlag : " + saveValidationVO.getCbfBkgFlag());
				
				if("Y".equals(saveValidationVO.getQtyModifyFlag()) //qty가 바뀌었거나
					|| "Y".equals(saveValidationVO.getRouteModifyFlag()) //route가 바뀌었거나
					|| "Y".equals(newSpclCgoFlag)){//spclCgoFlg가 바뀐 경우
					if(!"Y".equals(bkgBlNoVO.getCaFlg())
							&&!"Y".equals(saveValidationVO.getCaNewCreationFlag())//ca new creation시 제외
							&&!"Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCloseBkgFlag())){
						// 11. First Vessel 변경시 Or Qty 변경시 SendBkgClose
						BkgCloseVO bkgCloseVO = util.searchBkgClose(bkgBlNoVO, account.getOfc_cd());
						if(bkgCloseVO != null){
							boolean openMail = false;
							String newVvd = (bkgCloseVO.getNewVvd()  != null)?bkgCloseVO.getNewVvd():"";
							String oldVvd = (bkgCloseVO.getPreVvd()  != null)?bkgCloseVO.getPreVvd():"";
							String newPol = (bkgCloseVO.getNewPolCd()!= null)?bkgCloseVO.getNewPolCd():"";
							String oldPol = (bkgCloseVO.getPrePolCd()!= null)?bkgCloseVO.getPrePolCd():"";
							
							if(newVvd.equals(oldVvd)&&newPol.equals(oldPol)){
								if(bkgBlNoVO.getBkgNo() != null){
									// Qty 증가여부를 판단하기 위해서 변경전 Quantity를 조회한다.
									// Cntr갯수가 많으면 "Y", Old에 없는 Cntr가 입력되면 "Y", 같은 Cntr의 Qty가 증감되면 "Y".(20090720 류대영수석)
									List<BkgQuantityVO> oldBkgQuantity = dbDao.searchBkgQuantity(bkgBlNoVO);
									if("Y".equals(newSpclCgoFlag)){
										openMail = true;
									} else {
										openMail = util.isChangeQty(oldBkgQuantity, bkgQuantityVOs);
									}
								}
							}else{
								openMail = true;
							}
							if(openMail){
								bookingCreationVO.getBookingSaveValidationVO().setCloseBkgFlag("Y");
								String[] strParam = new String[11];
								strParam[0] = bkgBlNoVO.getBkgNo();
//								strParam[1] = bkgCloseVO.getPreVvd();
//								strParam[2] = bkgCloseVO.getPrePolCd();
//								strParam[3] = bkgCloseVO.getPrePodCd();
//								strParam[4] = bkgCloseVO.getOldQtyVol();
								strParam[5] = bkgCloseVO.getCntrList();
								strParam[6] = bkgCloseVO.getNewVvd();
								strParam[7] = bkgCloseVO.getPorCd() + " / " + bkgCloseVO.getNewPolCd() + " / " + bkgCloseVO.getPodCd() + " / " + bkgCloseVO.getDelCd(); 
								strParam[8] = bkgCloseVO.getNewPodCd();
								String newQtyVol = "";
								for(int i = 0 ; i < bkgQuantityVOs.length ; i++){
									if(i > 0){
										newQtyVol = newQtyVol + "," + bkgQuantityVOs[i].getCntrTpszCd() + " X " + bkgQuantityVOs[i].getOpCntrQty();
									}else{
										newQtyVol = newQtyVol + bkgQuantityVOs[i].getCntrTpszCd() + " X " + bkgQuantityVOs[i].getOpCntrQty();
									}
								}								
								strParam[9] = newQtyVol;
								strParam[10] = bkgCloseVO.getNewCntrList();
								
								bookingCreationVO.getBookingSaveValidationVO().setCloseBkgMsg(util.makeBkgCloseMsg(strParam, "B"));
								bookingCreationVO.getBookingSaveValidationVO().setChangeFirstVvd(bkgCloseVO.getCloseVvd());
								return bookingCreationVO;							
							}
						}
					}
				}

//              // 적용 철회
//				if("Y".equals(saveValidationVO.getQtyModifyFlag())){
//					//[CHM-201431717] BKG vs TRO qty Validation 추가 요청
//					// TRO_QTY 보다 BKG_QTY 가 작게 입력 되었는지 체크
//					List<BkgQuantityVO> maxTroQtys = dbDao.searchMaxTroQty(bkgBlNoVO);
//					if(maxTroQtys != null && maxTroQtys.size()>0){
//						for(int i=0; i<maxTroQtys.size(); i++){
//							boolean overMaxTroQty = true;
//							for(int j=0; j<bkgQuantityVOs.length; j++){
//								if(maxTroQtys.get(i).getCntrTpszCd().equals(bkgQuantityVOs[j].getCntrTpszCd())){
//									if( Float.parseFloat(maxTroQtys.get(i).getObTroQty()) <= Float.parseFloat(bkgQuantityVOs[j].getOpCntrQty())){
//										overMaxTroQty = false;
//									}
//								}
//							}
//							if(overMaxTroQty){
//								throw new EventException((String)new ErrorHandler("BKG95068").getMessage());
//							}
//						}
//					}
//				}
				
				// for t/s close bkg by bayplan
				if("Y".equals(saveValidationVO.getCheckTsCloseFlag())){ //route가 바뀌었거나
					if(!"Y".equals(bookingCreationVO.getBookingSaveValidationVO().getTsCloseBkgFlag())){
						List<String> tsClosedVvds = util.searchTsBkgClose(bkgBlNoVO);
						if(tsClosedVvds.size() > 0){
							saveValidationVO.setTsCloseBkgFlag("Y");
							if(bookingCreationVO.getBookingSaveValidationVO().getCloseBkgFlag()!=null
								&&	"Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCloseBkgFlag())){
								saveValidationVO.setCloseBkgFlag("F");
							}
							String closedVvds = "";
							for(int i = 0; i < tsClosedVvds.size(); i++){
								if(closedVvds.length() == 0){
									closedVvds = tsClosedVvds.get(i);
								} else {
									closedVvds = closedVvds + "," + tsClosedVvds.get(i);
								}
							}
							bookingCreationVO.getBookingSaveValidationVO().setClosedTsVvd(closedVvds);
							return bookingCreationVO;							
						}
					}
				}
				
				//CBF Validation 추가 요청				
				if("Y".equals(saveValidationVO.getQtyModifyFlag()) //qty가 바뀌었거나
					|| "Y".equals(saveValidationVO.getRouteModifyFlag()) //route가 바뀌었거나
					|| "Y".equals(newSpclCgoFlag)){//spclCgoFlg가 바뀐 경우
					if(!"Y".equals(bkgBlNoVO.getCaFlg())
							&&!"Y".equals(saveValidationVO.getCaNewCreationFlag())//ca new creation시 제외
							&&!"Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCbfBkgFlag())){
						// 11. First Vessel 변경시 Or Qty 변경시 SendBkgClose

						boolean isCbfFinal = false;
						BkgCloseVO bkgCloseVO = util.searchBkgCbf(bkgBlNoVO);
						if(bkgCloseVO != null && bkgCloseVO.getNewVvd() != null && !bkgCloseVO.getNewVvd().trim().equals("")){
							String[] arrCBF  = dbDao.searchCBFBS(bkgCloseVO.getNewVvd().substring(0, 4), bkgCloseVO.getNewVvd().substring(4, 8), bkgCloseVO.getNewVvd().substring(8, 9), bkgCloseVO.getNewYdCdSeq());
							for (int i=0;i<arrCBF.length;i++){
								if("Final".equals(arrCBF[i])){
									isCbfFinal = true;
									break;
								}
							}
						
							if(arrCBF != null && isCbfFinal == true){
								boolean openMail = false;
								String newVvd = (bkgCloseVO.getNewVvd()  != null)?bkgCloseVO.getNewVvd():"";
								String oldVvd = (bkgCloseVO.getPreVvd()  != null)?bkgCloseVO.getPreVvd():"";
								String newPol = (bkgCloseVO.getNewPolCd()!= null)?bkgCloseVO.getNewPolCd():"";
								String oldPol = (bkgCloseVO.getPrePolCd()!= null)?bkgCloseVO.getPrePolCd():"";
								
								if(newVvd.equals(oldVvd)&&newPol.equals(oldPol)){
									if(bkgBlNoVO.getBkgNo() != null){
										// Qty 증가여부를 판단하기 위해서 변경전 Quantity를 조회한다.
										// Cntr갯수가 많으면 "Y", Old에 없는 Cntr가 입력되면 "Y", 같은 Cntr의 Qty가 증감되면 "Y".(20090720 류대영수석)
										List<BkgQuantityVO> oldBkgQuantity = dbDao.searchBkgQuantity(bkgBlNoVO);
										if("Y".equals(newSpclCgoFlag)){
											openMail = true;
										} else {
											openMail = util.isChangeQty(oldBkgQuantity, bkgQuantityVOs);
										}
									}
								}else{
									openMail = true;
								}
								if(openMail){
									bookingCreationVO.getBookingSaveValidationVO().setCbfBkgFlag("Y");
									if(bookingCreationVO.getBookingSaveValidationVO().getCloseBkgFlag()!=null
										&&	"Y".equals(bookingCreationVO.getBookingSaveValidationVO().getCloseBkgFlag())) {
										saveValidationVO.setCloseBkgFlag("F");
									}
									if(bookingCreationVO.getBookingSaveValidationVO().getTsCloseBkgFlag()!=null
										&&	"Y".equals(bookingCreationVO.getBookingSaveValidationVO().getTsCloseBkgFlag())){
										saveValidationVO.setTsCloseBkgFlag("F");
									}
									String[] strParam = new String[11];
									strParam[0] = bkgBlNoVO.getBkgNo();
	//								strParam[1] = bkgCloseVO.getPreVvd();
	//								strParam[2] = bkgCloseVO.getPrePolCd();
	//								strParam[3] = bkgCloseVO.getPrePodCd();
	//								strParam[4] = bkgCloseVO.getOldQtyVol();
									strParam[5] = bkgCloseVO.getCntrList();
									strParam[6] = bkgCloseVO.getNewVvd();
									strParam[7] = bkgCloseVO.getPorCd() + " / " + bkgCloseVO.getNewPolCd() + " / " + bkgCloseVO.getPodCd() + " / " + bkgCloseVO.getDelCd(); 
									strParam[8] = bkgCloseVO.getNewPodCd();
									String newQtyVol = "";
									for(int i = 0 ; i < bkgQuantityVOs.length ; i++){
										if(i > 0){
											newQtyVol = newQtyVol + "," + bkgQuantityVOs[i].getCntrTpszCd() + " X " + bkgQuantityVOs[i].getOpCntrQty();
										}else{
											newQtyVol = newQtyVol + bkgQuantityVOs[i].getCntrTpszCd() + " X " + bkgQuantityVOs[i].getOpCntrQty();
										}
									}								
									strParam[9] = newQtyVol;
									strParam[10] = bkgCloseVO.getNewCntrList();
									
									bookingCreationVO.getBookingSaveValidationVO().setCloseBkgMsg(util.makeBkgCloseMsg(strParam, "B"));
									bookingCreationVO.getBookingSaveValidationVO().setChangeFirstVvd(bkgCloseVO.getCloseVvd());
									return bookingCreationVO;							
								}
							}
						}
					}					
				}
				saveValidationVO.setCloseBkgFlag("N");
				saveValidationVO.setTsCloseBkgFlag("N");
				saveValidationVO.setCbfBkgFlag("N");
				
				saveValidationVO.setTrnkLaneCd(laneCd);
				String scNo  = bkgBookingInfoVO.getScNo();
				String rfaNo = bkgBookingInfoVO.getRfaNo();
//				String taaNo = bkgBookingInfoVO.getTaaNo();
				
				// trunk vvd가 없는 bkg은 잡을 수 없다.
				if(trunkVvd == null||trunkVvd.length()!=9){					
					throw new EventException((String)new ErrorHandler("BKG00833").getMessage());
				}

				// Trunk VVD의 Lane은 반드시 있어야한다.
				if(isCheckVvdCd(trunkVvd)){
					if(laneCd == null || laneCd.length() < 1){
						throw new EventException((String)new ErrorHandler("BKG01004").getMessage());
					}
				}					
				
				if(bkgBookingInfoVO.getWgtUtCd() == null || bkgBookingInfoVO.getWgtUtCd().length()==0){
					throw new EventException((String)new ErrorHandler("BKG00766").getMessage());					
				}

				if(bkgBookingInfoVO.getActWgt() == null || bkgBookingInfoVO.getActWgt().length()==0){
					throw new EventException((String)new ErrorHandler("BKG00014").getMessage());
				}
				
				if(!"Y".equals(bkgBlNoVO.getCaFlg())){
					// 34. 다른 대륙의 Booking을 생성/변경할 수 없음 -> 생성만 불가   
					if(oldBkgNo == null || oldBkgNo.length() == 0){
						if(dbDao.searchOfcVsPorConti(porCd, account)){
							throw new EventException((String)new ErrorHandler("BKG00025", new String[]{porCd}).getMessage());
						}
					}
				}
				
				//------------------------customer
				if(blCustomerInfoVO.getSCustCntCd()==null || blCustomerInfoVO.getSCustCntCd().trim().length()<1 
						|| blCustomerInfoVO.getSCustSeq()==null || blCustomerInfoVO.getSCustSeq().trim().length()<1){					
					throw new EventException((String)new ErrorHandler("BKG00008").getMessage());
				}
				
				if("Y".equals(saveValidationVO.getCustomerModifyFlag())){
					// 03. Customer Code 유효성 검사
					String sCustCntCd = blCustomerInfoVO.getSCustCntCd();
					String sCustSeq = blCustomerInfoVO.getSCustSeq();
										
					MdmCustVO mdmCustVO = null;
					if(sCustCntCd != null && sCustCntCd.length() > 0){
						mdmCustVO = util.searchMdmCust(sCustCntCd, sCustSeq, "N");
						if("Y".equals(mdmCustVO.getNmdCustFlg())){
							throw new EventException((String)new ErrorHandler("BKG00458").getMessage());
						}
						if(mdmCustVO == null || "Y".equals(mdmCustVO.getDeltFlg())){
							throw new EventException((String)new ErrorHandler("BKG00076",new String[]{sCustCntCd+sCustSeq}).getMessage());
						}
						if(mdmCustVO == null || "Y".equals(mdmCustVO.getExcdCrFlg())){
							throw new EventException((String)new ErrorHandler("BKG08350",new String[]{sCustCntCd+sCustSeq,mdmCustVO.getArOfc(),mdmCustVO.getSrepNm()}).getMessage());
						}
						if(mdmCustVO == null || "Y".equals(mdmCustVO.getNoUseFlg())){
							throw new EventException((String)new ErrorHandler("BKG02004",new String[]{sCustCntCd+sCustSeq,mdmCustVO.getNoUseRsn()}).getMessage());
						}
					}
					String fCustCntCd = blCustomerInfoVO.getFCustCntCd();
					String fCustSeq = blCustomerInfoVO.getFCustSeq();
					if(fCustCntCd != null && fCustCntCd.length() > 0){
						mdmCustVO = util.searchMdmCust(fCustCntCd, fCustSeq, "N");
						if("Y".equals(mdmCustVO.getNmdCustFlg())){
							throw new EventException((String)new ErrorHandler("BKG00458").getMessage());
						}
						if(mdmCustVO == null || "Y".equals(mdmCustVO.getDeltFlg())){
							throw new EventException((String)new ErrorHandler("BKG00076",new String[]{fCustCntCd+fCustSeq}).getMessage());
						}
						if(mdmCustVO == null || "Y".equals(mdmCustVO.getExcdCrFlg())){
							throw new EventException((String)new ErrorHandler("BKG08350",new String[]{fCustCntCd+fCustSeq,mdmCustVO.getArOfc(),mdmCustVO.getSrepNm()}).getMessage());
						}
						if(mdmCustVO == null || "Y".equals(mdmCustVO.getNoUseFlg())){
							throw new EventException((String)new ErrorHandler("BKG02004",new String[]{fCustCntCd+fCustSeq,mdmCustVO.getNoUseRsn()}).getMessage());
						}
					}
					String cCustCntCd = blCustomerInfoVO.getCCustCntCd();
					String cCustSeq = blCustomerInfoVO.getCCustSeq();
					if(cCustCntCd != null && cCustCntCd.length() > 0 && cCustSeq.length() > 0){
						mdmCustVO = util.searchMdmCust(cCustCntCd, cCustSeq, "N");
						if("Y".equals(mdmCustVO.getNmdCustFlg())){
							throw new EventException((String)new ErrorHandler("BKG00458").getMessage());
						}
						if(mdmCustVO == null || "Y".equals(mdmCustVO.getDeltFlg())){					
							throw new EventException((String)new ErrorHandler("BKG00076",new String[]{cCustCntCd+cCustSeq}).getMessage());
						}
						if(mdmCustVO == null || "Y".equals(mdmCustVO.getExcdCrFlg())){
							throw new EventException((String)new ErrorHandler("BKG08350",new String[]{cCustCntCd+cCustSeq,mdmCustVO.getArOfc(),mdmCustVO.getSrepNm()}).getMessage());
						}
						if(mdmCustVO == null || "Y".equals(mdmCustVO.getNoUseFlg())){
							throw new EventException((String)new ErrorHandler("BKG02004",new String[]{cCustCntCd+cCustSeq,mdmCustVO.getNoUseRsn()}).getMessage());
						}
					}
				}else if(oldBkgNo == null || oldBkgNo.length() == 0){ // 생성 시 
					// Exceeding Credit Limit
					String sCustCntCd = blCustomerInfoVO.getSCustCntCd();
					String sCustSeq = blCustomerInfoVO.getSCustSeq();
										
					MdmCustVO mdmCustVO = null;
					if(sCustCntCd != null && sCustCntCd.length() > 0){
						mdmCustVO = util.searchMdmCust(sCustCntCd, sCustSeq, "N");
						if(mdmCustVO == null || "Y".equals(mdmCustVO.getExcdCrFlg())){
							throw new EventException((String)new ErrorHandler("BKG08350",new String[]{sCustCntCd+sCustSeq,mdmCustVO.getArOfc(),mdmCustVO.getSrepNm()}).getMessage());
						}
					}
					String fCustCntCd = blCustomerInfoVO.getFCustCntCd();
					String fCustSeq = blCustomerInfoVO.getFCustSeq();
					if(fCustCntCd != null && fCustCntCd.length() > 0){
						mdmCustVO = util.searchMdmCust(fCustCntCd, fCustSeq, "N");
						if(mdmCustVO == null || "Y".equals(mdmCustVO.getExcdCrFlg())){
							throw new EventException((String)new ErrorHandler("BKG08350",new String[]{fCustCntCd+fCustSeq,mdmCustVO.getArOfc(),mdmCustVO.getSrepNm()}).getMessage());
						}
					}
					String cCustCntCd = blCustomerInfoVO.getCCustCntCd();
					String cCustSeq = blCustomerInfoVO.getCCustSeq();
					if(cCustCntCd != null && cCustCntCd.length() > 0 && cCustSeq.length() > 0){
						mdmCustVO = util.searchMdmCust(cCustCntCd, cCustSeq, "N");
						if(mdmCustVO == null || "Y".equals(mdmCustVO.getExcdCrFlg())){
							throw new EventException((String)new ErrorHandler("BKG08350",new String[]{cCustCntCd+cCustSeq,mdmCustVO.getArOfc(),mdmCustVO.getSrepNm()}).getMessage());
						}
					}
					// 03-2. Actual Customer Code 유효성 검사
					String agmtActCntCd   = bkgBookingInfoVO.getAgmtActCntCd();
					String agmtActCustSeq = bkgBookingInfoVO.getAgmtActCustSeq();
					if(agmtActCntCd != null && agmtActCustSeq != null && agmtActCntCd.length() > 0 && agmtActCustSeq.length() > 0){
						mdmCustVO = util.searchMdmCust(agmtActCntCd, agmtActCustSeq, "N");
						if(mdmCustVO == null || "Y".equals(mdmCustVO.getExcdCrFlg())){
							throw new EventException((String)new ErrorHandler("BKG08350",new String[]{agmtActCntCd+agmtActCustSeq,mdmCustVO.getArOfc(),mdmCustVO.getSrepNm()}).getMessage());
						}
					}
				}
				// [CHM-201536932] 중국발 Booking - 신규 화주 검증 로직 삽입 요청
				// 북중국, 신규 및 6개월 이상 미사용 화주, Sales Approval 체크 했는 지 validation 
				if(!"Y".equals(bkgBlNoVO.getCaFlg())){
					BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
					bkgHrdCdgCtntListCondVO.setHrdCdgId("BKG_VALIDATION");			
					List<BkgHrdCdgCtntVO> alocStatusSwitch = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
					
					String cnnNewCustApro = "Y";
					if(alocStatusSwitch.size() > 0){
						for(int i = 0; i < alocStatusSwitch.size(); i++){
							if("CNN_NEW_CUST_APRO".equals(alocStatusSwitch.get(i).getAttrCtnt1())
									&& "OFF".equals(alocStatusSwitch.get(i).getAttrCtnt2())){
								cnnNewCustApro = "N";
							}
						}
					}
					if("Y".equals(cnnNewCustApro)){
						if(bkgBookingInfoVO.getNewCustAproFlg()==null 
							|| !"Y".equals(bkgBookingInfoVO.getNewCustAproFlg())
							|| bkgBookingInfoVO.getNewCustAproCmdtNm()==null
							|| bkgBookingInfoVO.getNewCustAproCmdtNm().length()==0 ){
							if(dbDao.checkNewChinaCustomer(blCustomerInfoVO, bkgBookingInfoVO.getObSrepCd())){
								throw new EventException((String)new ErrorHandler("BKG08351").getMessage());
							}
						}
					}
				}
				
				// 20130429 (2013508최문환) 추가 - SHPR와 FWRD의 정보를 조회하여 LREP이 coverage team과 일치하는지 validation함.
				if(!dbDao.checkCustSrep(blCustomerInfoVO, bkgBookingInfoVO.getObSrepCd())){
					String obSrepCd = bkgBookingInfoVO.getObSrepCd();
					String fCustCntCd = blCustomerInfoVO.getFCustCntCd();
					if(!"US".equals(fCustCntCd)){
						throw new EventException((String)new ErrorHandler("BKG08260", new String[]{obSrepCd,"shipper code or forwarder code"}).getMessage());
					}else{
						throw new EventException((String)new ErrorHandler("BKG08260", new String[]{obSrepCd,"shipper code"}).getMessage());	
					}
				}
				// ,new String(bkgBookingInfoVO.getObSrepCd())
				
				//------------------------quantity
				if("Y".equals(saveValidationVO.getQtyModifyFlag())){
					// 05. Container Type/Size 유효성 검사.
					String cntrTpSz = "";
					String eqSubCntrTpSz = "";	
					for(int i = 0 ; i < bkgQuantityVOs.length ; i++){
						cntrTpSz = bkgQuantityVOs[i].getCntrTpszCd();
						if(!"Q2".equals(cntrTpSz) && !"Q4".equals(cntrTpSz)){
							if(!dbDao.searchCntrTpSz(cntrTpSz)){
								throw new EventException((String)new ErrorHandler("BKG00062",new String[]{cntrTpSz}).getMessage());
							}
						}
						// 20080821 추가 - 류대영수석 요청
						eqSubCntrTpSz = bkgQuantityVOs[i].getEqSubstCntrTpszCd();
						if(eqSubCntrTpSz != null && !"".equals(eqSubCntrTpSz) && !"Q2".equals(eqSubCntrTpSz) && !"Q4".equals(eqSubCntrTpSz)){
							if(!dbDao.searchCntrTpSz(eqSubCntrTpSz)){
								throw new EventException((String)new ErrorHandler("BKG00062",new String[]{eqSubCntrTpSz}).getMessage());
							}
						}					
					}
				}
				
				// 06. FROB 유효성 검사.
				String filerCd  = "";
				String filerLoc = "";
				String usaFilerCd = bkgBookingInfoVO.getUsaCstmsFileCd();
				String canadaFilerCd = bkgBookingInfoVO.getCndCstmsFileCd();
				if(isCheckVvdCd(trunkVvd)){
					if(podCd == null || podCd.length()==0){
						filerLoc = delCd;
					} else {
						filerLoc = podCd;
					}
					filerCd = util.searchFrob(bkgNo, trunkVvd, polCd, filerLoc);

					// 06-01. 미국 FROB일 경우 US FILER가 입력되지 않았으면 [BKG00283]을 보여주고 중지한다
					// 10-27. POD가 미주인 경우 US Filer가 없을 경우 [BKG00283]을 보여주고 중지한다
					// 10-27. DEL이 미주인 경우 S/C No에 따라 NVOCC인 경우 1 또는 2, Individual일 경우 3이 아니면 [BKG00308]을 보여주고 중지한다
					if("AL".equals(filerCd)||"US".equals(filerCd)){
						if(usaFilerCd == null || usaFilerCd.trim().length() < 1){
							throw new EventException((String)new ErrorHandler("BKG00283").getMessage());
						}
					} 
					if((null != podCd && podCd.startsWith("US")) || "US".equals(delCd.substring(0,2))){
						if(usaFilerCd == null || usaFilerCd.trim().length() < 1){
							throw new EventException((String)new ErrorHandler("BKG00283").getMessage());
						}
					}
					if("US".equals(delCd.substring(0,2))){
						if(usaFilerCd != null && !"".equals(usaFilerCd)){
							if(scNo != null && scNo.length() > 0 && !scNo.startsWith("DUM")){
								// 04. Sc Type 조회
								String scType = dbDao.searchScType(scNo, bkgBlNoVO);
								// S/C Type이 I이면서 US Filer가 1 or 2라면 [BKG00308]을 보여주고 중지한다
								if("I".equals(scType) && ("1".equals(usaFilerCd) || "2".equals(usaFilerCd))){
									throw new EventException((String)new ErrorHandler("BKG00308").getMessage());
								}
								// S/C Type이 N이면서 US Filer가 3라면 [BKG00308]을 보여주고 중지한다
								if("N".equals(scType) && "3".equals(usaFilerCd)){
									throw new EventException((String)new ErrorHandler("BKG00308").getMessage());
								}
							}
						}
					}
					// 06-02. Canada FROB일 경우 CA Filer가 입력되지 않았으면 [BKG00284]을 보여주고 중지한다
					// 06-03. Canada FROB일 경우 CA Filer가 입력되었는데 '03'이 아닐 경우 [BKG00285]을 보여주고 중지한다
					if("AL".equals(filerCd)||"CA".equals(filerCd)){
						if(canadaFilerCd == null || canadaFilerCd.trim().length() < 1){
							throw new EventException((String)new ErrorHandler("BKG00284").getMessage());
						}else{
							if(!"3".equals(canadaFilerCd)){
								infoMsg = infoMsg + ",BKG00285";
//								throw new EventException((String)new ErrorHandler("BKG00285").getMessage());
							}
						}
					} 
					if((null != podCd && podCd.startsWith("CA")) || "CA".equals(delCd.substring(0,2))){
						if(canadaFilerCd == null || canadaFilerCd.trim().length() < 1){
							throw new EventException((String)new ErrorHandler("BKG00284").getMessage());
						}
					}
				}
				
				// 07. searchVvdBdr(BDR 인 경우 메시지 출력)
				if(!"Y".equals(bkgBlNoVO.getCaFlg())&&"Y".equals(saveValidationVO.getRouteModifyFlag())){// 변경된 route 정보
				    String bdrVvd = dbDao.searchBdrLog(bkgBlNoVO.getPctlNo());
				    if("Y".equals(saveValidationVO.getCaNewCreationFlag())){
				    	if(bdrVvd==null || bdrVvd.length()<9){
				    		throw new EventException((String)new ErrorHandler("BKG00071", new String[]{bdrVvd, "not Released"}).getMessage());
				    	}
				    } else {
						if(bdrVvd!=null && bdrVvd.length()>0){
							throw new EventException((String)new ErrorHandler("BKG00071", new String[]{bdrVvd, "already Released"}).getMessage());
						}
				    }
				}
				// 09. F.A.K 여부 확인 (FAK, Cargo, NOS, GDSM)
				if(bkgBookingInfoVO.getCmdtCd()!="" && ( Integer.parseInt(bkgBookingInfoVO.getCmdtCd()) < 27 || "98".equals(bkgBookingInfoVO.getCmdtCd().substring(0, 2)) || "99".equals(bkgBookingInfoVO.getCmdtCd().substring(0, 2))) ){
					if(dbDao.searchCmdtFak(bkgBookingInfoVO.getCmdtCd(), porCd, delCd, bkgNo, bkgBookingInfoVO.getCaFlg(), scNo)){
						throw new EventException((String)new ErrorHandler("BKG00307").getMessage());
					}
				}
				
				// 생성시에만 확인함
				if(oldBkgNo == null || oldBkgNo.length() == 0){
					// 10. Manual Booking 여부 확인
					if("Y".equals(bkgBookingInfoVO.getMnlBkgNoFlg())){
						if(bkgNo.length()==10){
							bkgNo = bkgNo + "00";
							bkgBookingInfoVO.setBkgNo(bkgNo);
							bookingCreationVO.getBkgBlNoVO().setBkgNo(bkgNo);
						}
						/*
						 * 1. 북중국인지 확인
						 * 2. 북중국이면 앞 2자리, 아니면 앞 3자리가 ofc prefix와 같아야함
						 * 3. 년도 이후 자리에는 I,O가 들어와서는 안됨
						 * 4. 미리 채번된 bkg no가 아니라면 chk digit가 반드시 'M'이어야함
						 */				
						String bkgNoPrefix = "";
						// 북중국 지역인가?
						if("China".equals(util.searchChnAgtUse(account.getUsr_id()))){
							bkgNoPrefix = bkgBookingInfoVO.getBkgNo().substring(0, 2);

							// 미리 채번된 bkg no가 아니라면 chk digit 이후가 반드시 'M00'이어야함
							if(bkgNo.length()==11){
								// 10. Agent Code 유효성 여부 확인.
								if(!dbDao.searchChnAgent(bkgBookingInfoVO.getBkgNo())){
									throw new EventException((String)new ErrorHandler("BKG00074", new String[]{bkgBookingInfoVO.getBkgNo()}).getMessage());
								}								
							} else {
								String bkgNoUseFlg = dbDao.searchChnBkgNoExist(bkgBlNoVO);
								if(bkgNoUseFlg==null||bkgNoUseFlg.length()==0){
									if(!bkgNo.substring(9, 12).equals("M00")){
										throw new EventException((String)new ErrorHandler("BKG00255").getMessage());
									}
								} else if(bkgNoUseFlg.equals("Y")){
									throw new EventException((String)new ErrorHandler("BKG00034",new String[]{bkgNo}).getMessage());								
								}
							}
						} else {
							//일반 bkg no는 10자리에 M이면 안됌
							if(!bkgNo.substring(9, 12).equals("M00")){
								throw new EventException((String)new ErrorHandler("BKG00255").getMessage());
							}
							bkgNoPrefix = bkgBookingInfoVO.getBkgNo().substring(0, 3);						
						}
						// 앞자리가 ofc prefix와 일치						
						if(!bkgNoPrefix.equals(account.getOfc_cd().substring(0, bkgNoPrefix.length()))){
							// NBOSC의 경우 NJ로 prefix를 사용하기 때문에 예외처리
							if(!"NBOSC".equals(account.getOfc_cd()) || !"NJ".equals(bkgNoPrefix)) {
								throw new EventException((String)new ErrorHandler("BKG00255").getMessage());
							}
						}
						// I,O가 들어와서는 안됨
						if(bkgNo.substring(bkgNoPrefix.length()+1, bkgNo.length()).indexOf("I")>0 
							|| bkgNo.substring(bkgNoPrefix.length()+1, bkgNo.length()).indexOf("O")>0){
							throw new EventException((String)new ErrorHandler("BKG00255").getMessage());
						}
					}
				}

				// 11. OCP를 입력했는데 US지역이 아닌 경우 / 등록되지 않은 location code인 경우(BKG00042)
				if(bkgBookingInfoVO.getOcpCd() != null && bkgBookingInfoVO.getOcpCd().length() > 0){
					String blMoveTpNm = dbDao.searchOcp(bkgBookingInfoVO.getOcpCd());
					if(blMoveTpNm != null && blMoveTpNm.length() > 0){
						saveValidationVO.setBlMoveTpNm(blMoveTpNm);
					}else{
						throw new EventException((String)new ErrorHandler("BKG00042").getMessage());
					}
				}
				
				//prd가 정상으로 따졌으면 할 필요 없음(20091207 류대영)
//				if("M".equals(bkgBookingInfoVO.getRcvTermCd()) == false){ // mix term시에 는 제외
//					if("D".equals(bkgBookingInfoVO.getRcvTermCd())){
//						// 13. RCV TERM이 DOOR인데 POR에 속한 ZONE이 없을 경우
//						if(!dbDao.searchZone(porCd, porYdCd)){
//							throw new EventException((String)new ErrorHandler("BKG00268", new String[]{porYdCd}).getMessage());
//						}
//					}else{
//						// 12. RCV TERM이 YARD인데 POR에 속한 YARD가 없을 경우
//						if(!dbDao.searchYard(porCd, porYdCd)){
//							throw new EventException((String)new ErrorHandler("BKG00269", new String[]{porYdCd}).getMessage());
//						}
//					}
//				}
//				if("M".equals(bkgBookingInfoVO.getDeTermCd()) == false){ // mix term시에 는 제외
//					if("D".equals(bkgBookingInfoVO.getDeTermCd())){
//						// 15. DLV TERM이 DOOR인데 DEL에 속한 ZONE이 없을 경우
//						if(!dbDao.searchZone(delCd, delYdCd)){
//							throw new EventException((String)new ErrorHandler("BKG00268", new String[]{delYdCd}).getMessage());
//						}
//					}else{
//						// 14. DLV TERM이 YARD인데 DEL에 속한 ZONE이 없을 경우
//						if(!dbDao.searchYard(delCd, delYdCd)){
//							throw new EventException((String)new ErrorHandler("BKG00269", new String[]{delYdCd}).getMessage());
//						}
//					}
//				}
				
				// 16. M’ty Pick up CY를 입력하였는데 mdm_yard 에 등록되어 있지 않은 경우
				String mtyPkupYdCd = bkgBookingInfoVO.getMtyPkupYdCd();
				if(mtyPkupYdCd != null && mtyPkupYdCd.length() > 5){
					if(!dbDao.searchYard(mtyPkupYdCd.substring(0,5), mtyPkupYdCd)){
						throw new EventException((String)new ErrorHandler("BKG00037").getMessage());
					}
				}
				// 17. Full Return CY를 입력하였는데 mdm_yard에 등록안된 CY일 경우
				String fullRtnYdCd = bkgBookingInfoVO.getFullRtnYdCd();
				if(fullRtnYdCd != null && fullRtnYdCd.length() > 5){
					if(!dbDao.searchYard(fullRtnYdCd.substring(0,5), fullRtnYdCd)){
						throw new EventException((String)new ErrorHandler("BKG00075").getMessage());
					}
				}

				if("Y".equals(saveValidationVO.getRouteModifyFlag())){
					// 생성시, pod, del, delivery term 변경시에만 실행
					if(oldBkgNo == null || oldBkgNo.length() < 11 
							||!bkgBookingInfoVO.getBkgPodCd().equals(podCd)
							||!bkgBookingInfoVO.getBkgDelCd().equals(delCd)){
						// 19. DEL이 EGALY, EGPSD인데 DLV TERM이 O가 아닐 경우
						if(dbDao.searchLocVsTerm(delCd, bkgBookingInfoVO.getDeTermCd(),rfaNo)){
							throw new EventException((String)new ErrorHandler("BKG00020").getMessage());
						}
					}
				}
				
				// Booking Update 인 경우
				if(oldBkgNo != null && oldBkgNo.length() > 0){
					boolean isBKG00087Msg = false;
					// 20. 미 세관신고로 download 이후 VVD, POD, DEL을 변경한 경우
					if(dbDao.searchUsaCstmsDownload(bkgBlNoVO)){
						if(!trunkVvd.equals(bkgBookingInfoVO.getBkgTrunkVvdOld()) 
								||!podCd.equals(bkgBookingInfoVO.getPodCdOld()) 
								||!delCd.equals(bkgBookingInfoVO.getDelCdOld())){
							infoMsg = infoMsg + ",BKG00087";
							isBKG00087Msg = true;
						}
					}
					isBKG00087Msg=true;
					// 21. 미주향 BOOKING인데 download되고 USA FILER CODE or CANADA FILER CODE가 1일 경우 HOUSE B/L 정보가 입력되어 있어야함
					if(isBKG00087Msg && dbDao.searchHblForCarrierFiling(bkgBlNoVO, usaFilerCd, canadaFilerCd, delCd)){
						infoMsg = infoMsg + ",BKG01006";
					}

					// 22. RATING 이후에 route, TYPE/SIZE, Vol을 수정할 경우(S/C, RFA 변경여부 확인)
					if(dbDao.searchIsRated(bkgBlNoVO)){
						String oldRfaNo = bkgBookingInfoVO.getRfaNoOld();
						String oldScNo  = bkgBookingInfoVO.getScNoOld();
						if(oldRfaNo == null) oldRfaNo = "";
						if(rfaNo    == null) rfaNo    = "";
						if(oldScNo  == null) oldScNo  = "";
						if(scNo     == null) scNo     = "";
						if(!rfaNo.equals(oldRfaNo) || !scNo.equals(oldScNo)){
							throw new EventException((String)new ErrorHandler("BKG00082").getMessage());
						}
						/*
						 * Rating 이후 BKG volumn 변경시 Alert 메세지 요청(CHM-201004965)
						 */
						if("Y".equals(saveValidationVO.getQtyModifyFlag())){
							infoMsg = infoMsg + ",BKG02065";
						}
					}
					//ob s/o가 있을 경우 por, pol, r term 변경 불가
					if(!"Y".equals(bkgBlNoVO.getBdrFlg())){
						if(!bkgBookingInfoVO.getPorCdOld().equals(porCd)
								||!bkgBookingInfoVO.getPolCdOld().equals(polCd)
								||!(bkgBookingInfoVO.getPorCdOld()+bkgBookingInfoVO.getPorYdCdOld()).equals(porNodCd)
								||!bkgBookingInfoVO.getRcvTermCdOld().equals(bkgBookingInfoVO.getRcvTermCd())){					
							if("Y".equals(util.searchSoStatus("", "", bkgBlNoVO, "O"))){
								throw new EventException((String)new ErrorHandler("BKG02079").getMessage());								
							}
							
							// 적용하지 않음
//							if("Y".equals(util.searchCtmSoStatus(bkgBlNoVO))){
//								throw new EventException((String)new ErrorHandler("BKG00094").getMessage());								
//							}
						}
					}
					// bdr 이후에는 check 않음
					saveValidationVO.setTroCfrmFlg("N");
					if(!"Y".equals(bkgBlNoVO.getBdrFlg())){
						if(!bkgBookingInfoVO.getPorCdOld().equals(porCd)
								||!(bkgBookingInfoVO.getPorCdOld()+bkgBookingInfoVO.getPorYdCdOld()).equals(porNodCd)
								||!bkgBookingInfoVO.getRcvTermCdOld().equals(bkgBookingInfoVO.getRcvTermCd())){
							// 23. POR, POL, R TERM이 변경되어 TRO가 UNCONFIRM되는 경우
							// 20091001 - Tro Unconfirm 메시지는 SC에서 처리한다. 여기서는 Confirm 여부만 판단한다.
							if(dbDao.searchTroCfm(bkgBlNoVO)){// confirm된 tro가 있을 경우
								saveValidationVO.setTroCfrmFlg("Y");
							}
						}
					} 
					
//					// 24. VVD 변경후 Save시, 승인 요청된 special cargo application이 있는 경우
//					// 필요 없을 수 있음 -> 필요 없는 것으로 확인함
//					if("Y".equals(saveValidationVO.getRouteModifyFlag()) && util.searchSpclApplForChange(bkgBlNoVO)){
//						autoSpclReConfirm = "Y";
//					}

					if("Y".equals(saveValidationVO.getRouteModifyFlag())||"Y".equals(saveValidationVO.getCustomerModifyFlag())){
						// 08. DEL 이 미국인 경우PO Length 검사.
						if(delCd.startsWith("US")){
							// SHPR
							String sCustCntCd = blCustomerInfoVO.getSCustCntCd();
							String sCustSeq = blCustomerInfoVO.getSCustSeq();
							if(sCustCntCd != null && sCustCntCd.length() > 0){
								if(util.searchPoNoLengthByDtl(sCustCntCd, sCustSeq, scNo, bkgBlNoVO)){
									throw new EventException((String)new ErrorHandler("BKG00081").getMessage());
								}
							}
							String fCustCntCd = blCustomerInfoVO.getFCustCntCd();
							String fCustSeq = blCustomerInfoVO.getFCustSeq();
							// FWDR
							if(fCustCntCd != null && fCustCntCd.length() > 0){
								if(util.searchPoNoLengthByDtl(fCustCntCd, fCustSeq, scNo, bkgBlNoVO)){
									throw new EventException((String)new ErrorHandler("BKG00081").getMessage());
								}
							}
							String cCustCntCd = blCustomerInfoVO.getCCustCntCd();
							String cCustSeq = blCustomerInfoVO.getCCustSeq();
							// CNEE
							if(cCustCntCd != null && cCustCntCd.length() > 0){
								if(util.searchPoNoLengthByDtl(cCustCntCd, cCustSeq, scNo, bkgBlNoVO)){
									throw new EventException((String)new ErrorHandler("BKG00081").getMessage());
								}
							}
						}
					}
					
					if("Y".equals(saveValidationVO.getRouteModifyFlag())){
						OldBkgInfoVO oldBkgInfoVO = dbDao.searchOldBkgInfo(bkgBlNoVO);
						saveValidationVO.setCodFlag(oldBkgInfoVO.getCodFlg());	
					}
				}
				 
				if("Y".equals(bkgBookingInfoVO.getDcgoFlg()) || "Y".equals(bkgBookingInfoVO.getRcFlg()) 
					|| "Y".equals(bkgBookingInfoVO.getAwkCgoFlg()) || "Y".equals(bkgBookingInfoVO.getBbCgoFlg())){
					saveValidationVO.setSpclCgoFlg("Y");
				}
				saveValidationVO.setSaveMsg(infoMsg);
				
				bookingCreationVO.setBkgBookingInfoVO(bkgBookingInfoVO);
				bookingCreationVO.setBookingSaveValidationVO(saveValidationVO);
				
				//하나의 BKG를 2명이 동시 작업하는 경우에 대한 에러 처리를 위해 
				if(saveValidationVO.getRouteModifyFlag().equals("N")) {
					String pctlNo = dbDao.compareBkgInfo(bkgBookingInfoVO.getBkgNo());
					if(null!=pctlNo && !"".equals(bkgBookingInfoVO.getPctlNoOld()) && !pctlNo.equals(bkgBookingInfoVO.getPctlNoOld())) {
						throw new EventException((String)new ErrorHandler("BKG02076").getMessage());
					}
				}
				//중국발 터키향 DG화물 validation 추가
				String rtnCode  = dbDao.searchDgProhibition(bkgBookingInfoVO);
				if(null!= rtnCode && !"".equals(rtnCode)){
					throw new EventException((String)new ErrorHandler(rtnCode).getMessage());
				}

				//Blocking BKG: East Malaysia - European Territory  2012.01.30
				//Blocking BKG: East Malaysia - European Territory  제거  2012.03.13
							
//				String[] arrRtn = dbDao.searchBlockBkgMalaysiaToEu(bkgBlNoVO);
//				
//				if(arrRtn != null &&  "Y".equals(arrRtn[1])){
//					if("TO".equals(arrRtn[3])) {
//						throw new EventException((String)new ErrorHandler("BKG01175", new String[]{arrRtn[2], "Europe"}).getMessage());
//					} else {
//						throw new EventException((String)new ErrorHandler("BKG01175", new String[]{"Europe",arrRtn[2]}).getMessage());
//					}
//				}
				//Delivery Term이 "D"에서 "Y"로 변경되는 시점에 TRO/I컨펌이 있는 경우
				if("D".equals(bkgBookingInfoVO.getDeTermCdOld()) && "Y".equals(bkgBookingInfoVO.getDeTermCd())){
					if(dbDao.searchEurTroCfmCnt(bkgBookingInfoVO.getBkgNo(), "I")) {
						throw new EventException((String)new ErrorHandler("BKG02112").getMessage());
					}
				}
				
				// email형식 validation
				if (bkgBookingInfoVO.getBkgCntcPsonEml() != null && bkgBookingInfoVO.getBkgCntcPsonEml().length() > 0) {
					if (!util.checkStringFormat("email", bkgBookingInfoVO.getBkgCntcPsonEml())) {
						throw new EventException((String) new ErrorHandler("BKG00651",new String[] { "Booking Contact Email: "+ bkgBookingInfoVO.getBkgCntcPsonEml()}).getMessage());
					}
				}
				
				if (bkgBookingInfoVO.getSiCntcPsonEml() != null && bkgBookingInfoVO.getSiCntcPsonEml().length() > 0) {
					if (!util.checkStringFormat("email", bkgBookingInfoVO.getSiCntcPsonEml())) {
						throw new EventException((String) new ErrorHandler("BKG00651",new String[] {"S/I Contact Email: "+ bkgBookingInfoVO.getSiCntcPsonEml()}).getMessage());
					}
				}
								
				// STOP_OFF_CNTC_PHN_NO(STOP_OFF_CNTC_PHN_NO)는 'ZZZ-ZZZ-ZZZZ'패턴 validation -> 보류
//				if (bkgBookingInfoVO.getStopOffCntcPhnNo() != null && bkgBookingInfoVO.getStopOffCntcPhnNo().length() > 0) {
//					if (!util.checkStringFormat("NNN-NNN-NNNN",bkgBookingInfoVO.getStopOffCntcPhnNo())) {
//						throw new EventException((String) new ErrorHandler("BKG00651", new String[] {"Phone No: "+ bkgBookingInfoVO.getStopOffCntcPhnNo()}).getMessage());
//					}
//				}			
				
				return bookingCreationVO;
			}else{
				// 데이터 저장 실패
				throw new EventException((String)new ErrorHandler("BKG00391").getMessage());
			}
		} catch (EventException ex) {
			throw ex;								
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			log.error("\nBKG NO : " + bkgNo + "\nerr"+de.toString(),de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * Booking을 생성한다.(ESM_BKG_0079_01 김병규)<br>
	 *
	 * @author	KimByungKyu
	 * @param 	BookingCreationVO bookingCreationVO
	 * @param 	SignOnUserAccount account 
	 * @exception EventException
	 */
	public void createBooking(BookingCreationVO bookingCreationVO, SignOnUserAccount account) throws EventException {
		try {
			BkgBlNoVO 				bkgBlNoVO			= bookingCreationVO.getBkgBlNoVO();
			BookingSaveValidationVO saveValidationVO	= bookingCreationVO.getBookingSaveValidationVO();
			BkgBookingInfoVO 		bkgBookingInfoVO 	= bookingCreationVO.getBkgBookingInfoVO();
			BlCustomerInfoVO 		blCustomerInfoVO 	= bookingCreationVO.getBlCustomerInfoVO();
			VslSkdVO[] 				vslSkdVOs			= bookingCreationVO.getVslSkdVOs();
			BkgQuantityVO[] 		bkgQuantityVOs		= bookingCreationVO.getBkgQuantityVOs();
			BkgQtyDtlVO[] 			bkgQtyDtlVOs		= bookingCreationVO.getBkgQtyDtlVOs();			
			BookingUtil				util				= new BookingUtil(); 
			
			if(bkgBookingInfoVO != null){
				// 사용자 ID(Auditing용)
				String userId = account.getUsr_id();

				// 01. 이미 있는 BOOKING NO로 BOOKING을 저장하려고 하는 경우
				if(dbDao.searchBkgBlNoDup(bkgBlNoVO)){
					throw new EventException((String)new ErrorHandler("BKG00034",new String[]{bkgBlNoVO.getBlNo()}).getMessage());
				}

				//임시로 기 배포된 11자리 manual bkg no는 bl no를 새로 채번
				if( bkgBlNoVO!=null && bkgBlNoVO.getBkgNo()!=null && bkgBlNoVO.getBkgNo().length()==11){ // 2011.07.14
					String isExist = util.searchBkgStatusByBkg(bkgBlNoVO);
					if(isExist != null && isExist.length() != 0){ // 2011.07.19
						throw new EventException((String)new ErrorHandler("BKG00034",new String[]{bkgBlNoVO.getBlNo()}).getMessage());						
					}
				}

				// 02. BL NO DUP 테이블에 저장
				dbDao.addBkgBlNoDup(bkgBlNoVO, account.getUsr_id());
				String porCd        = bkgBookingInfoVO.getBkgPorCd();
				String polCd        = bkgBookingInfoVO.getBkgPolCd();
				String podCd 		= bkgBookingInfoVO.getBkgPodCd();
				String delCd 		= bkgBookingInfoVO.getBkgDelCd();
				String preRlyPortCd = bkgBookingInfoVO.getPreRlyPortCd();
				String pstRlyPortCd = bkgBookingInfoVO.getPstRlyPortCd();
				String skdDirCd     = bkgBookingInfoVO.getBkgTrunkVvd().substring(8,9);
				String trnkLaneCd   = saveValidationVO.getTrnkLaneCd();
				
				bkgBookingInfoVO.setBkgTrunkVvd(saveValidationVO.getTrunkVvd());
				bkgBookingInfoVO.setSlanCd(trnkLaneCd);
				bkgBookingInfoVO.setPctlNo(bkgBlNoVO.getPctlNo());

				// 03. ORG_TRNS_SVC_MOD_CD 조회
				String orgTrnsSvcModCd = dbDao.searchOrgSvcRoute(trnkLaneCd, skdDirCd, porCd, polCd, preRlyPortCd);
				bkgBookingInfoVO.setOrgTrnsSvcModCd(orgTrnsSvcModCd);

				// 04. DEST_TRNS_SVC_MOD_CD 조회
				String ocpCd = bkgBookingInfoVO.getOcpCd();
				
				String destTrnsSvcModCd = dbDao.searchDstSvcRoute(trnkLaneCd, skdDirCd, podCd, delCd, pstRlyPortCd, ocpCd);
				bkgBookingInfoVO.setDestTrnsSvcModCd(destTrnsSvcModCd);

				// 05. SVC Scope를 조회한다.
				String svcScpCd = "";
				if(saveValidationVO.getScpFromCtrt() != null && saveValidationVO.getScpFromCtrt().length() > 0){
					svcScpCd = saveValidationVO.getScpFromCtrt();
					// bkg route와 match되지 않으면
					if(dbDao.checkSvcScopeRoute(trnkLaneCd, porCd, delCd, svcScpCd) == 0){
						// 기존값 유지
						saveValidationVO.setScpFromCtrt(null);
						svcScpCd = dbDao.searchSvcScope(trnkLaneCd, porCd, delCd);
					}
				} else {
					svcScpCd = dbDao.searchSvcScope(trnkLaneCd, porCd, delCd);
				}
				bkgBookingInfoVO.setSvcScpCd(svcScpCd);

				// 06. Financial Direction을 찾는다.
				String revDirCd = dbDao.searchFinDir(trnkLaneCd, skdDirCd, polCd);
				bkgBookingInfoVO.setRevDirCd(revDirCd);
				
				// CREATION의 경우 : REV_DIR_CD 는 'C'패턴 이어야 한다
				if (bkgBookingInfoVO.getRevDirCd() != null && bkgBookingInfoVO.getRevDirCd().length() > 0) {
					if (!util.checkStringFormat("C", bkgBookingInfoVO.getRevDirCd())) {
						throw new EventException((String) new ErrorHandler("BKG00651", new String[] { "Revenue Direction:"+ bkgBookingInfoVO.getRevDirCd()}).getMessage());
					}
				}

				// 06-#1. Block Stowage 조회(20090721 추가)
				String bsCode = dbDao.searchBlockStowage(bkgBookingInfoVO, blCustomerInfoVO);
				bkgBookingInfoVO.setBlckStwgCd(bsCode);				
				
				bkgBookingInfoVO.setBkgOfcCd(account.getOfc_cd());
				bkgBookingInfoVO.setCreUsrId(userId);
				bkgBookingInfoVO.setUpdUsrId(userId);
				
				// POL_ETD_DT, POD_ETA_DT 조회용
				if(vslSkdVOs != null && vslSkdVOs.length > 0){
					bkgBookingInfoVO.setFirstPolCd(vslSkdVOs[0].getPolCd());
					bkgBookingInfoVO.setFirstPolClptIndSeq(vslSkdVOs[0].getPolClptIndSeq());
					bkgBookingInfoVO.setFirstVvdCd(vslSkdVOs[0].getBkgVvdCd());
					bkgBookingInfoVO.setLastPodCd(vslSkdVOs[vslSkdVOs.length-1].getPodCd());
					bkgBookingInfoVO.setLastPodClptIndSeq(vslSkdVOs[vslSkdVOs.length-1].getPodClptIndSeq());
					bkgBookingInfoVO.setLastVvdCd(vslSkdVOs[vslSkdVOs.length-1].getBkgVvdCd());
				}
				
				bkgBookingInfoVO = modifyExtRmk(bookingCreationVO);
				
				// 08. Booking 정보를 저장한다.
				dbDao.addBkgBooking(bkgBookingInfoVO);	
				if(bkgBlNoVO.getPctlNo() != null && bkgBlNoVO.getPctlNo().length() > 0 
						&& !"FAIL".equals(bkgBlNoVO.getPctlNo().substring(0, 4))){
					dbDao.modifyBkgRouteFromPrd(bkgBlNoVO, "C");					
				}
				
				String bkgNo = bkgBookingInfoVO.getBkgNo();
				// 09. Booking Customer정보를 저장한다.
				BkgCustomerVO bkgCustomerVO = new BkgCustomerVO();
				bkgCustomerVO.setBkgNo(bkgNo);
				bkgCustomerVO.setCreUsrId(userId);
				bkgCustomerVO.setUpdUsrId(userId);

				// 09-01. SHIPPER 입력
				bkgCustomerVO.setBkgCustTpCd("S");
				bkgCustomerVO.setCustCntCd(blCustomerInfoVO.getSCustCntCd());
				bkgCustomerVO.setCustSeq(blCustomerInfoVO.getSCustSeq());
				bkgCustomerVO.setCustNm(blCustomerInfoVO.getSCustNm());
				dbDao.addBkgCustomer(bkgCustomerVO, bkgBlNoVO);
				// 09-02. FORWARDER 입력
				bkgCustomerVO.setBkgCustTpCd("F");
				bkgCustomerVO.setCustCntCd(blCustomerInfoVO.getFCustCntCd());
				bkgCustomerVO.setCustSeq(blCustomerInfoVO.getFCustSeq());
				bkgCustomerVO.setCustNm(blCustomerInfoVO.getFCustNm());
				dbDao.addBkgCustomer(bkgCustomerVO, bkgBlNoVO);
				// 09-03. CONSIGNEE 입력
				bkgCustomerVO.setBkgCustTpCd("C");
				bkgCustomerVO.setCustCntCd(blCustomerInfoVO.getCCustCntCd());
				bkgCustomerVO.setCustSeq(blCustomerInfoVO.getCCustSeq());
				bkgCustomerVO.setCustNm(blCustomerInfoVO.getCCustNm());
				dbDao.addBkgCustomer(bkgCustomerVO, bkgBlNoVO);
				// 09-04. NOTIFY 입력
				bkgCustomerVO.setBkgCustTpCd("N");
				bkgCustomerVO.setCustCntCd("");
				bkgCustomerVO.setCustSeq("");
				bkgCustomerVO.setCustNm("");
				dbDao.addBkgCustomer(bkgCustomerVO, bkgBlNoVO);
				// 09-05. ALSO NOTIFY  입력
				bkgCustomerVO.setBkgCustTpCd("A");
				bkgCustomerVO.setCustCntCd("");
				bkgCustomerVO.setCustSeq("");
				bkgCustomerVO.setCustNm("");
				dbDao.addBkgCustomer(bkgCustomerVO, bkgBlNoVO);
				// 09-06. EXPORT 입력
				bkgCustomerVO.setBkgCustTpCd("E");
				bkgCustomerVO.setCustCntCd("");
				bkgCustomerVO.setCustSeq("");
				bkgCustomerVO.setCustNm("");
				dbDao.addBkgCustomer(bkgCustomerVO, bkgBlNoVO);

				// 계약 관련 정보를 update한다
				dbDao.modifyCtrtInfo(bkgBlNoVO);
		    	String porCdChk = porCd == null ? "" : porCd.substring(0,2);
		    	String polCdChk = polCd == null ? "" : polCd.substring(0,2);
		    	if( polCdChk.equals("US") || polCdChk.equals("CA") || porCdChk.equals("US") || porCdChk.equals("CA")){
					String ctrtOfcCd = bkgBookingInfoVO.getCtrtOfcCd();
					String ctrtSrepCd = bkgBookingInfoVO.getCtrtSrepCd();
					String orgBkgNo = bkgBookingInfoVO.getBkgNo();
					log.debug("\n *********************" +
							"\n ctrtOfcCd:"+ctrtOfcCd +
							"\n ctrtSrepCd:"+ctrtSrepCd);
					if( ctrtOfcCd != null && ctrtSrepCd != null && ctrtOfcCd.length() >0 && ctrtSrepCd.length()>0 ) {
						
						dbDao.modifyChangedCtrtInfo(bkgBlNoVO, ctrtOfcCd, ctrtSrepCd, orgBkgNo);  //2011.10.14 jsy
					}
		    	}
				
				// 10. Booking Quantity 정보를 저장한다.
				for(int i = 0 ; i < bkgQuantityVOs.length ; i++){					
					BkgQuantityVO bkgQuantityVO = bkgQuantityVOs[i];
					if(0.0 == Float.parseFloat(bkgQuantityVO.getOpCntrQty())){
						continue;
					}
					bkgQuantityVO.setBkgNo(bkgNo);
					bkgQuantityVO.setFlexHgtFlg(bkgBookingInfoVO.getFlexHgtFlg());
					bkgQuantityVO.setCreUsrId(userId);
					bkgQuantityVO.setUpdUsrId(userId);
					dbDao.addBkgQuantity(bkgQuantityVO, bkgBlNoVO);
				}

				// BkgQtyDtl 을 저장한다.(20090820 추가)
				if(bkgQtyDtlVOs != null){
					for(int i = 0 ; i < bkgQtyDtlVOs.length ; i++){
						BkgQtyDtlVO bkgQtyDtlVO = bkgQtyDtlVOs[i];
						if(0.0 == Float.parseFloat(bkgQtyDtlVO.getOpCntrQty())){
							continue;
						}
						if("Y".equals(bkgQtyDtlVO.getAwkCgoFlg()) || "1".equals(bkgQtyDtlVO.getAwkCgoFlg())){
							bkgQtyDtlVO.setAwkCgoFlg("Y");
						}else{
							bkgQtyDtlVO.setAwkCgoFlg("N");
						}
						if("Y".equals(bkgQtyDtlVO.getDcgoFlg()) || "1".equals(bkgQtyDtlVO.getDcgoFlg())){
							bkgQtyDtlVO.setDcgoFlg("Y");
						}else{
							bkgQtyDtlVO.setDcgoFlg("N");
						}									
						if("Y".equals(bkgQtyDtlVO.getRcFlg()) || "1".equals(bkgQtyDtlVO.getRcFlg())){
							bkgQtyDtlVO.setRcFlg("Y");
						}else{
							bkgQtyDtlVO.setRcFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getBbCgoFlg()) || "1".equals(bkgQtyDtlVO.getBbCgoFlg())){
							bkgQtyDtlVO.setBbCgoFlg("Y");
						}else{
							bkgQtyDtlVO.setBbCgoFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getSocFlg()) || "1".equals(bkgQtyDtlVO.getSocFlg())){
							bkgQtyDtlVO.setSocFlg("Y");
						}else{
							bkgQtyDtlVO.setSocFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getCrrHngrSglBarUseFlg()) || "1".equals(bkgQtyDtlVO.getCrrHngrSglBarUseFlg())){
							bkgQtyDtlVO.setCrrHngrSglBarUseFlg("Y");
						}else{
							bkgQtyDtlVO.setCrrHngrSglBarUseFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getCrrHngrDblBarUseFlg()) || "1".equals(bkgQtyDtlVO.getCrrHngrDblBarUseFlg())){
							bkgQtyDtlVO.setCrrHngrDblBarUseFlg("Y");
						}else{
							bkgQtyDtlVO.setCrrHngrDblBarUseFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getCrrHngrTplBarUseFlg()) || "1".equals(bkgQtyDtlVO.getCrrHngrTplBarUseFlg())){
							bkgQtyDtlVO.setCrrHngrTplBarUseFlg("Y");
						}else{
							bkgQtyDtlVO.setCrrHngrTplBarUseFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getDryCgoFlg()) || "1".equals(bkgQtyDtlVO.getDryCgoFlg())){
							bkgQtyDtlVO.setDryCgoFlg("Y");
						}else{
							bkgQtyDtlVO.setDryCgoFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getMerHngrFlg()) || "1".equals(bkgQtyDtlVO.getMerHngrFlg())){
							bkgQtyDtlVO.setMerHngrFlg("Y");
						}else{
							bkgQtyDtlVO.setMerHngrFlg("N");
						}								
						bkgQtyDtlVO.setBkgNo(bkgNo);
						bkgQtyDtlVO.setCreUsrId(userId);
						bkgQtyDtlVO.setUpdUsrId(userId);
						
						dbDao.addBkgQtyDtl(bkgQtyDtlVO, bkgBlNoVO);
					}
				}				
				
				// 11. Booking VVD 정보를 저장한다.
				if(bkgBlNoVO.getPctlNo() != null && bkgBlNoVO.getPctlNo().length() > 0 
						&& !"FAIL".equals(bkgBlNoVO.getPctlNo().substring(0, 4))){
					dbDao.addBkgVvdFromPrd(bkgBlNoVO, bkgBookingInfoVO.getBkgTrunkVvd(), account);
				} else {
					for(int i = 0 ; i < vslSkdVOs.length ; i++){
						VslSkdVO vslSkdVO =  vslSkdVOs[i];
						BkgVvdVO bkgVvdVO = new BkgVvdVO();
						bkgVvdVO.setBkgNo(bkgNo);
						bkgVvdVO.setVslPrePstCd(vslSkdVO.getVslPrePstCd());
						bkgVvdVO.setVslSeq(vslSkdVO.getVslSeq());
						if(vslSkdVO.getBkgVvdCd() != null && vslSkdVO.getBkgVvdCd().length() == 9){
							bkgVvdVO.setVslCd(vslSkdVO.getBkgVvdCd().substring(0,4));
							bkgVvdVO.setSkdVoyNo(vslSkdVO.getBkgVvdCd().substring(4,8));
							bkgVvdVO.setSkdDirCd(vslSkdVO.getBkgVvdCd().substring(8,9));
						}
						bkgVvdVO.setPolClptIndSeq(vslSkdVO.getPolClptIndSeq());
						bkgVvdVO.setPodClptIndSeq(vslSkdVO.getPodClptIndSeq());
						bkgVvdVO.setPolCd(vslSkdVO.getPolCd());
						if(vslSkdVO.getPolYdCd() != null && vslSkdVO.getPolYdCd().length() > 0){
							bkgVvdVO.setPolYdCd(vslSkdVO.getPolCd()+vslSkdVO.getPolYdCd());	
						}					
						bkgVvdVO.setPodCd(vslSkdVO.getPodCd());
						if(vslSkdVO.getPodYdCd() != null && vslSkdVO.getPodYdCd().length() > 0){
							bkgVvdVO.setPodYdCd(vslSkdVO.getPodCd()+vslSkdVO.getPodYdCd());	
						}									
						bkgVvdVO.setCreUsrId(userId);
						bkgVvdVO.setUpdUsrId(userId);
	
						dbDao.addBkgVvd(bkgVvdVO, bkgBlNoVO);
					}
				}
				//POL이 SININ이면 POL ETA에서 6일을 뺀다.
				if(bkgBookingInfoVO.getBkgPolCd().equals("SGSIN")){
					dbDao.modifyMtyPkupDt(bkgBookingInfoVO.getBkgNo(), "-6", bkgBookingInfoVO.getBkgPolCd());					
				}

				//------------------------contract
				String scNo  = bkgBookingInfoVO.getScNo();
				String rfaNo = bkgBookingInfoVO.getRfaNo();
				String taaNo = bkgBookingInfoVO.getTaaNo();
				
				// 00. contract check
				if((scNo == null || scNo.trim().length() == 0)
						&&(rfaNo == null || rfaNo.trim().length() == 0)
						&&(taaNo == null || taaNo.trim().length() == 0)){
					//You must input either S/C No or RFA No or TAA No.
					throw new EventException((String)new ErrorHandler("BKG00016").getMessage());
				}
				
				// 01. searchScAvailable
				ScListInputVO scListInputVO = new ScListInputVO();
				scListInputVO.setBkgNo(bkgNo);
				if(scNo != null && scNo.trim().length() > 0 && !scNo.startsWith("DUM")){
					if(!util.searchScAvailable(scNo, bkgBlNoVO)){
						throw new EventException((String)new ErrorHandler("BKG00281",new String[]{"S/C","S/C"}).getMessage());
					}
					if(dbDao.validateScCtrtPtyTp(scListInputVO, bkgBlNoVO.getCaFlg()) > 0){
						throw new EventException((String)new ErrorHandler("BKG08267").getMessage());
					}
				}
				if(dbDao.validateScCustTp(scListInputVO, bkgBlNoVO.getCaFlg(),"S") > 0){
					throw new EventException((String)new ErrorHandler("BKG08275").getMessage());
				}
				if(dbDao.validateScCustTp(scListInputVO, bkgBlNoVO.getCaFlg(),"R") > 0){
					throw new EventException((String)new ErrorHandler("BKG08276").getMessage());
				}
				
				// 02. searchRfaAvailable
				if(rfaNo != null && rfaNo.trim().length() > 0	 && !rfaNo.startsWith("DUM")){
					// Spot Guide 경우 Proposal OFC 와 L.OFC 가 같아야 한다.
					if(rfaNo!=null && rfaNo.trim().length() > 6  && "G".equals(rfaNo.substring(5,6))){
						String ofcSame = util.rfaSpotPricingAvailableForBkgCre(bkgBlNoVO, rfaNo, bkgBookingInfoVO.getObSrepCd());
						if("N".equals(ofcSame)){
							throw new EventException((String)new ErrorHandler("BKG08329").getMessage());
						}
					}
					
					if(!util.searchRfaAvailable(rfaNo, bkgBlNoVO)){
						throw new EventException((String)new ErrorHandler("BKG00281",new String[]{"RFA"}).getMessage());
					}
				}
				// 02. searchTaaAvailable
				if(taaNo != null && taaNo.trim().length() > 0	 && !taaNo.startsWith("DUM")){
					if(!util.searchTaaAvailable(taaNo, bkgBlNoVO)){
						throw new EventException((String)new ErrorHandler("BKG00281",new String[]{"TAA"}).getMessage());
					}
				}

				// 후쿠시마에서 used commodity가 특정 POD로 가는지 확인함
				util.searchFukushimaUsedCmdt(bkgBlNoVO, bkgBookingInfoVO.getCmdtCd(), "");
				
				// IRAN이 POR, POL, POD, DEL일 경우 Order B/L인 상태로 저장할 수 없다
//				util.searchIranToOrdBl(bkgBlNoVO);
				
				// 12. Booking Contact Person 정보를 저장한다.
				BkgCntcPsonVO bkgCntcPsonVO = new BkgCntcPsonVO();
				bkgCntcPsonVO.setBkgNo(bkgNo);
				bkgCntcPsonVO.setCreUsrId(userId);
				bkgCntcPsonVO.setUpdUsrId(userId);
				// 12-01. BK
				bkgCntcPsonVO.setBkgCntcPsonTpCd("BK");
				bkgCntcPsonVO.setCntcPsonNm(bkgBookingInfoVO.getBkgCntcPsonNm());
				bkgCntcPsonVO.setCntcPsonEml(bkgBookingInfoVO.getBkgCntcPsonEml());
				bkgCntcPsonVO.setCntcPsonFaxNo(bkgBookingInfoVO.getBkgCntcPsonFaxNo());
				bkgCntcPsonVO.setCntcPsonMphnNo(bkgBookingInfoVO.getBkgCntcPsonMphnNo());
				bkgCntcPsonVO.setCntcPsonPhnNo(bkgBookingInfoVO.getBkgCntcPsonPhnNo());
				dbDao.addBkgCntcPson(bkgCntcPsonVO, bkgBlNoVO);
				// 12-02. SI
				bkgCntcPsonVO.setBkgCntcPsonTpCd("SI");
				bkgCntcPsonVO.setCntcPsonNm(bkgBookingInfoVO.getSiCntcPsonNm());
				bkgCntcPsonVO.setCntcPsonEml(bkgBookingInfoVO.getSiCntcPsonEml());
				bkgCntcPsonVO.setCntcPsonFaxNo(bkgBookingInfoVO.getSiCntcPsonFaxNo());
				bkgCntcPsonVO.setCntcPsonMphnNo(bkgBookingInfoVO.getSiCntcPsonMphnNo());
				bkgCntcPsonVO.setCntcPsonPhnNo(bkgBookingInfoVO.getSiCntcPsonPhnNo());
				dbDao.addBkgCntcPson(bkgCntcPsonVO, bkgBlNoVO);

				// 13. Manual Booking 인 경우 modifyCntcEmailFromAgent 수행
				if("Y".equals(bkgBookingInfoVO.getMnlBkgNoFlg())){
					dbDao.modifyCntcEmailFromAgent(bkgNo);
				}

				// 14. BKG ROLL OVER 저장.
				dbDao.addBkgRollOvr(bkgBlNoVO, account);
				if(bkgBookingInfoVO.getFmcNo()!=null && bkgBookingInfoVO.getFmcNo().length()>1){
					BkgReferenceVO bkgReferenceVO = new BkgReferenceVO();
					bkgReferenceVO.setBkgNo(bkgNo);
					bkgReferenceVO.setBkgRefTpCd("FMCN");
					bkgReferenceVO.setCpyDescFlg("N");
					bkgReferenceVO.setCustRefNoCtnt(bkgBookingInfoVO.getFmcNo());
					bkgReferenceVO.setUpdUsrId(account.getUsr_id());
					bkgReferenceVO.setCreUsrId(account.getUsr_id());
					
					List<BkgReferenceVO> bkgReferenceVOs = new ArrayList<BkgReferenceVO>();
					bkgReferenceVOs.add(bkgReferenceVO);
					dbDao.addBkgReference(bkgReferenceVOs, bkgBlNoVO.getCaFlg());
				}
				
				// pct 조회 	2012.02.24 kbj
				String pct = dbDao.searchPct(bkgBlNoVO.getBkgNo(), "N");
				
				//pct update 2012.02.24 kbj
				dbDao.modifyPct(bkgBlNoVO, pct);
				
				String destTrnsModCd = dbDao.searchDestTrnsModCdRSQL(bkgBlNoVO.getBkgNo());
				// Stowage Code Update : 삼성전자 MEXICO OBSS자동선택
				boolean obssModifyFlag = false;
				BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
				bkgHrdCdgCtntListCondVO.setHrdCdgId("STWG_OBSS");
				bkgHrdCdgCtntListCondVO.setAttrCtnt1("SC_NO");
				List<BkgHrdCdgCtntVO> hrdCdgList = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
				for(int h=0;h<hrdCdgList.size(); h++){
					BkgHrdCdgCtntVO tmpBkgHrdVO = (BkgHrdCdgCtntVO)hrdCdgList.get(h);
					if(bkgBookingInfoVO.getScNo().equals(tmpBkgHrdVO.getAttrCtnt2())){
						obssModifyFlag = true;
						break;
					}
				}
		        
				// 미주향
				if(obssModifyFlag == true && !"A".equals(destTrnsModCd)){
					dbDao.modifyStowageForSamsungMexico(bkgBlNoVO);
				// 캐나다 향
				} else	if(obssModifyFlag == true && "A".equals(destTrnsModCd)){
					dbDao.modifyStowageForSamsungMexicoToCanada(bkgBlNoVO);	
				}
				
				// 2017.04.17 iylee Stowage Code Update : Prime Service OLBP 자동선택
				boolean olbpModifyFlag = false;
				bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
				bkgHrdCdgCtntListCondVO.setHrdCdgId("STWG_OLBP");
				bkgHrdCdgCtntListCondVO.setAttrCtnt1("SC_NO");
				hrdCdgList = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
				for(int h=0;h<hrdCdgList.size(); h++){
					BkgHrdCdgCtntVO tmpBkgHrdVO = (BkgHrdCdgCtntVO)hrdCdgList.get(h);
					if(bkgBookingInfoVO.getScNo().equals(tmpBkgHrdVO.getAttrCtnt2())){
						olbpModifyFlag = true;
						break;
					}
				}
				
				if(olbpModifyFlag == true && !"R".equals(destTrnsModCd)){
					dbDao.modifyStowageForLG(bkgBlNoVO);
				}
				
				/* Prime Service : OLBP일 경우, Container에 LBP Flag를 'Y'로 체크.
				 * 
				 * POD 가 US이면, Rail이 아닐 경우 LBP를 'Y'로 설정.
				 * POD 가 CA이면, Rail일 경우 LBP를 'Y'로 설정.
				 *  
				 * */
				dbDao.modifyLbpFlgForContainer(bkgBlNoVO);
				
				// 2017.05.24 iylee Stowage Code Update : OLBS자동선택
				boolean olbsModifyFlag = false;
				bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
				bkgHrdCdgCtntListCondVO.setHrdCdgId("STWG_OLBS");
				bkgHrdCdgCtntListCondVO.setAttrCtnt1("SC_NO");
				hrdCdgList = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
				for(int h=0;h<hrdCdgList.size(); h++){
					BkgHrdCdgCtntVO tmpBkgHrdVO = (BkgHrdCdgCtntVO)hrdCdgList.get(h);
					if(bkgBookingInfoVO.getScNo().equals(tmpBkgHrdVO.getAttrCtnt2())){
						olbsModifyFlag = true;
						break;
					}
				}
				
				if(olbsModifyFlag == true && !"R".equals(destTrnsModCd)){
					dbDao.modifyStowageForOLBS(bkgBlNoVO);
				}
				
				// 2017.07.04 iylee Stowage Code Update : OLBL자동선택
				boolean olblModifyFlag = false;
				bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
				bkgHrdCdgCtntListCondVO.setHrdCdgId("STWG_OLBL");
				bkgHrdCdgCtntListCondVO.setAttrCtnt1("SC_NO");
				hrdCdgList = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
				for(int h=0;h<hrdCdgList.size(); h++){
					BkgHrdCdgCtntVO tmpBkgHrdVO = (BkgHrdCdgCtntVO)hrdCdgList.get(h);
					if(bkgBookingInfoVO.getScNo().equals(tmpBkgHrdVO.getAttrCtnt2())){
						olblModifyFlag = true;
						break;
					}
				}
				
				if(olblModifyFlag == true && !"R".equals(destTrnsModCd)){
					dbDao.modifyStowageForOLBL(bkgBlNoVO);
				}
				
				// 2017.09.29 iylee Stowage Code Update : OD자동선택
				boolean odModifyFlag = false;
				bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
				bkgHrdCdgCtntListCondVO.setHrdCdgId("STWG_OD");
				bkgHrdCdgCtntListCondVO.setAttrCtnt1("RFA_NO");
				hrdCdgList = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
				for(int h=0;h<hrdCdgList.size(); h++){
					BkgHrdCdgCtntVO tmpBkgHrdVO = (BkgHrdCdgCtntVO)hrdCdgList.get(h);
					if(bkgBookingInfoVO.getRfaNo().equals(tmpBkgHrdVO.getAttrCtnt2())){
						odModifyFlag = true;
						break;
					}
				}
				
				if(odModifyFlag == true){
					dbDao.modifyStowageForOD(bkgBlNoVO);
				}
				
				// 2018.05.24 iylee Stowage Code Update : TS자동선택
				boolean tsModifyFlag = false;
				bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
				bkgHrdCdgCtntListCondVO.setHrdCdgId("STWG_TS");
				bkgHrdCdgCtntListCondVO.setAttrCtnt1("RFA_NO");
				hrdCdgList = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
				for(int h=0;h<hrdCdgList.size(); h++){
					BkgHrdCdgCtntVO tmpBkgHrdVO = (BkgHrdCdgCtntVO)hrdCdgList.get(h);
					if(bkgBookingInfoVO.getRfaNo().equals(tmpBkgHrdVO.getAttrCtnt2())){
						tsModifyFlag = true;
						break;
					}
				}
				
				if(tsModifyFlag == true){
					dbDao.modifyStowageForTS(bkgBlNoVO);
				}
				
				
				// 북중국 지역 Non DG Chemical 자동 표시
				dbDao.modifyNonDgChemForChina(bkgBlNoVO);
				
				// [SRM-201551910] 계약 No 와 Acustomer 코드 조건이 만날때 하단 EDI Ref.가 자동으로 입력되어 Cargo tracking EDI 전송 요청
				dbDao.modifyExCustByActCust(bkgBlNoVO);
				// Philips 계약조건이 맞는경우 EDI Ref.가 존재하지 않을 때 특정 Customer code로 지정
				dbDao.modifyExCustByCtrt(bkgBlNoVO,"PHILIPS_CONTRACT");
				
				String missingMsg = dbDao.searchMissingData(bkgBookingInfoVO, saveValidationVO);
				if(!"".equals(missingMsg) || missingMsg.length()>0){
					if("TRO volume".equals(missingMsg)){
						throw new EventException((String)new ErrorHandler("BKG02057").getMessage());
					} else {
						throw new EventException((String)new ErrorHandler("BKG06014", new String[]{missingMsg}).getMessage());
					} 
				}
			}else{
				// 데이터 저장 실패
				throw new EventException((String)new ErrorHandler("BKG00391").getMessage());
			}
		} catch (EventException ex) {
			throw ex;							
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * 수정전 Booking 정보를 조회한다.(ESM_BKG_0079_01)<br>
	 *
	 * @author	KimByungKyu
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @return 	OldBkgInfoVO
	 * @exception 	EventException
	 */
    public OldBkgInfoVO searchOldBkgInfo(BkgBlNoVO bkgBlNoVO) throws EventException {
        try {
            return dbDao.searchOldBkgInfo(bkgBlNoVO);
        } catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

	/**
	 * Booking을 수정한다..(ESM_BKG_0079_01 김병규)<br>
	 * 
	 * @author	KimByungKyu
	 * @param 	BookingCreationVO bookingCreationVO
	 * @param 	SignOnUserAccount account 
	 * @return		BookingSaveValidationVO
	 * @exception 	EventException
	 */
	public BookingSaveValidationVO modifyBooking(BookingCreationVO bookingCreationVO, SignOnUserAccount account) throws EventException {
		try {
		BkgBlNoVO 		 		bkgBlNoVO 		  	= bookingCreationVO.getBkgBlNoVO();
			BookingSaveValidationVO	saveValidationVO 	= bookingCreationVO.getBookingSaveValidationVO();
			BkgBookingInfoVO 		bkgBookingInfoVO 	= bookingCreationVO.getBkgBookingInfoVO();
			VslSkdVO[] 				vslSkdVOs 			= bookingCreationVO.getVslSkdVOs();
			BlCustomerInfoVO 		blCustomerInfoVO 	= bookingCreationVO.getBlCustomerInfoVO();
			BkgQuantityVO[] 		bkgQuantityVOs 		= bookingCreationVO.getBkgQuantityVOs();
			BkgQtyDtlVO[] 			bkgQtyDtlVOs 		= bookingCreationVO.getBkgQtyDtlVOs();
			OldBkgInfoVO 			oldBkgInfoVO 		= bookingCreationVO.getOldBkgInfoVO();
			BookingUtil				util				= new BookingUtil();
			BookingHistoryMgtBC 	historyBC	        = new BookingHistoryMgtBCImpl();
			
			if(bkgBookingInfoVO != null){				
				String userId = account.getUsr_id();
				String bkgNo = bkgBookingInfoVO.getBkgNo();
				bkgBookingInfoVO.setCreUsrId(userId);
				bkgBookingInfoVO.setUpdUsrId(userId);

				OldBkgInfoVO oldBkgInfoForPctlNo = dbDao.searchOldBkgInfo(bkgBlNoVO);
				// 01. BIS에 있는 BOOKING NO로 BOOKING을 저장하려고 하는 경우 (20090723 삭제 by 류대영수석님)
//				if(dbDao.searchBkgBlNoDup(bkgBlNoVO)){
//					throw new EventException((String)new ErrorHandler("BKG00034",new String[]{bkgBlNoVO.getBlNo()}).getMessage());
//				}
//
				String porCd = bkgBookingInfoVO.getBkgPorCd();
				String polCd = bkgBookingInfoVO.getBkgPolCd();
				String podCd = bkgBookingInfoVO.getBkgPodCd();
				String delCd = bkgBookingInfoVO.getBkgDelCd();
				String preRlyPortCd = bkgBookingInfoVO.getPreRlyPortCd();
				String pstRlyPortCd = bkgBookingInfoVO.getPstRlyPortCd();
				String trnkLaneCd = saveValidationVO.getTrnkLaneCd();
				String skdDirCd = bkgBookingInfoVO.getBkgTrunkVvd().substring(8,9);
				
				if(bkgBookingInfoVO.getBkgTrunkVvd().length()!=9){
					throw new EventException((String)new ErrorHandler("BKG00658").getMessage());
				}				
				
				saveValidationVO.setTrunkVvd(bkgBookingInfoVO.getBkgTrunkVvd());				
				bkgBookingInfoVO.setSlanCd(trnkLaneCd);
				bkgBookingInfoVO.setPctlNo(bkgBlNoVO.getPctlNo());
				
				// 02. ORG_TRNS_SVC_MOD_CD 조회
				bkgBookingInfoVO.setOrgTrnsSvcModCd(dbDao.searchOrgSvcRoute(trnkLaneCd, skdDirCd, porCd, polCd, preRlyPortCd));

				// 03. DEST_TRNS_SVC_MOD_CD 조회
				bkgBookingInfoVO.setDestTrnsSvcModCd(dbDao.searchDstSvcRoute(trnkLaneCd, skdDirCd, podCd, delCd, pstRlyPortCd, bkgBookingInfoVO.getOcpCd()));

				// 04. SVC Scope를 조회한다. (Rating이면 Skip한다.)
				String svcScpCd = bkgBookingInfoVO.getSvcScpCd();
				if(!"Y".equals(saveValidationVO.getIsRated())){
//					1. commodity pop-up에서 선택해서 저장할 경우
//						1.1. 선택한 scope이 route에 맞을 경우 -> 선택한 scope를 저장
//						1.2. 선택한 scope이 route에 안 맞을 경우 -> 기존 scope을 유지
//					2. commodity pop-up에서 선택하지 않고 저장할 경우
//						2.1. por, del, lane이 바뀌지 않았으면 -> 기존 scope를 유지
//						2.2. 기존에 commodity pop-up에서 scope를 선택한 적이 있는 경우 -> 기존 scope유지
//						2.3. 기존에 commodity pop-up에서 scope를 선택한 적이 없는 경우 -> por, del, lane으로 scope 재계산
					if(saveValidationVO.getScpFromCtrt() != null && saveValidationVO.getScpFromCtrt().length() > 0){
						svcScpCd = saveValidationVO.getScpFromCtrt();
						// bkg route와 match되지 않으면
						if(dbDao.checkSvcScopeRoute(trnkLaneCd, porCd, delCd, svcScpCd) == 0){
							// 기존값 유지
							saveValidationVO.setScpFromCtrt(null);
							svcScpCd = bkgBookingInfoVO.getSvcScpCd();
						}					
					} else {
						// por, del이 바뀌지 않았고, VVD가 바뀌지 않았으면 scope를 유지함
						if(bkgBookingInfoVO.getBkgPorCd().equals(bkgBookingInfoVO.getPorCdOld())
							&& bkgBookingInfoVO.getBkgDelCd().equals(bkgBookingInfoVO.getDelCdOld())
							&& oldBkgInfoForPctlNo.getSlanCd().equals(trnkLaneCd)){
							svcScpCd = bkgBookingInfoVO.getSvcScpCd();							
						} else {
							// commodity pop-up에서 scope를 선택한 적이 있는지 확인
							BkgDocProcSkdVO bkgDocProcSkdVO = new BkgDocProcSkdVO();
							bkgDocProcSkdVO.setBkgNo(bkgBlNoVO.getBkgNo());
							bkgDocProcSkdVO.setBkgDocProcTpCd("SCPCTR");
							bkgDocProcSkdVO.setDocPerfDeltFlg("N");
							bkgDocProcSkdVO = util.searchDocProcSkd(bkgDocProcSkdVO, bkgBlNoVO.getCaFlg());
							if(bkgDocProcSkdVO != null){
								// 기존값 유지
								svcScpCd = bkgBookingInfoVO.getSvcScpCd();
							} else {
								String routeSvcScpCd = dbDao.searchSvcScope(trnkLaneCd, porCd, delCd);
								if(routeSvcScpCd != null && routeSvcScpCd.length() > 0){
									svcScpCd = routeSvcScpCd;							
								}
							}
						}
					}
				} else {
					svcScpCd = bkgBookingInfoVO.getSvcScpCd();
				}
				if(svcScpCd == null || svcScpCd.length() < 1){
					svcScpCd = dbDao.searchSvcScope(trnkLaneCd, porCd, delCd);
				}
				bkgBookingInfoVO.setSvcScpCd(svcScpCd);
				
				// 05. Financial Direction을 찾는다.
				bkgBookingInfoVO.setRevDirCd(dbDao.searchFinDir(trnkLaneCd, skdDirCd, polCd));
				
				// UPDATE의 경우 : REV_DIR_CD 는 'C'패턴 이어야 한다
				if (bkgBookingInfoVO.getRevDirCd() != null && bkgBookingInfoVO.getRevDirCd().length() > 0) {
					if (!util.checkStringFormat("C", bkgBookingInfoVO.getRevDirCd())){
						throw new EventException((String) new ErrorHandler("BKG00651", new String[] { "Revenue Direction:"+ bkgBookingInfoVO.getRevDirCd()}).getMessage());
					}
				}
				// 06. Block Stowage 조회
				bkgBookingInfoVO.setBlckStwgCd(dbDao.searchBlockStowage(bkgBookingInfoVO, blCustomerInfoVO));

				if(vslSkdVOs != null && vslSkdVOs.length>0){
					bkgBookingInfoVO.setFirstPolCd(vslSkdVOs[0].getPolCd());
					bkgBookingInfoVO.setFirstPolClptIndSeq(vslSkdVOs[0].getPolClptIndSeq());
					bkgBookingInfoVO.setFirstVvdCd(vslSkdVOs[0].getBkgVvdCd());
					bkgBookingInfoVO.setLastPodCd(vslSkdVOs[vslSkdVOs.length-1].getPodCd());
					bkgBookingInfoVO.setLastPodClptIndSeq(vslSkdVOs[vslSkdVOs.length-1].getPodClptIndSeq());
					bkgBookingInfoVO.setLastVvdCd(vslSkdVOs[vslSkdVOs.length-1].getBkgVvdCd());
				}
				
				// 08. Booking 정보 수정
// 안정화이후 까지 주석 처리	
//				//c/a이면서 vvd 5개 이상이면 route 변경 처리 하지 않음
//				if("Y".equals(bkgBlNoVO.getCaFlg()) && vslSkdVOs.length>4){
//					
//				}

				saveValidationVO.setCodFlag(oldBkgInfoForPctlNo.getCodFlg());
				
				bkgBookingInfoVO = modifyExtRmk(bookingCreationVO);
				
				dbDao.modifyBkgBooking(bkgBookingInfoVO, bkgBlNoVO);

				// 2017.10.26 iylee Prime Service일 경우, Container에 LBP Flag를 'Y'로 체크.
				dbDao.modifyLbpFlgForContainer(bkgBlNoVO);

				if("Y".equals(saveValidationVO.getRouteModifyFlag())||"Y".equals(saveValidationVO.getQtyModifyFlag())){
					if(bkgBlNoVO.getPctlNo() != null && bkgBlNoVO.getPctlNo().length() > 0 
							&& !"FAIL".equals(bkgBlNoVO.getPctlNo().substring(0, 4))
							&& !"Over T/S".equals(bkgBlNoVO.getPctlNo())){
						dbDao.modifyBkgRouteFromPrd(bkgBlNoVO, "U");						
					}
				}
					
				if("Y".equals(saveValidationVO.getCustomerModifyFlag())){
					// 09. Customer정보 수정(20090810 modifyBkgCustomer -> modifyBkgCustCode)
					BkgCustomerVO bkgCustomerVO = new BkgCustomerVO();
					bkgCustomerVO.setBkgNo(bkgNo);
					bkgCustomerVO.setCreUsrId(userId);
					bkgCustomerVO.setUpdUsrId(userId);
					
					BlCustomerInfoVO oldBlCustomerInfoVO = dbDao.searchBkgCustomer("B", bkgBlNoVO);				
					// 09-01. SHIPPER 수정
					boolean shFlag = true;
					String sCustCd = blCustomerInfoVO.getSCustCntCd() + blCustomerInfoVO.getSCustSeq();
					String sCustCdOld = oldBlCustomerInfoVO.getSCustCntCd() + oldBlCustomerInfoVO.getSCustSeq();
					
					if(sCustCd != null && sCustCd.length() > 0){
						if(sCustCd.equals(sCustCdOld)) shFlag = false;
					} else {
						if(sCustCdOld == null || sCustCdOld.length() < 1) shFlag = false;
					}
										
					if(shFlag){
						bkgCustomerVO.setBkgCustTpCd("S");
						bkgCustomerVO.setCustCntCd(blCustomerInfoVO.getSCustCntCd());
						bkgCustomerVO.setCustSeq(blCustomerInfoVO.getSCustSeq());
						bkgCustomerVO.setCustNm(blCustomerInfoVO.getSCustNm());
						dbDao.modifyBkgCustCode(bkgCustomerVO, bkgBlNoVO, blCustomerInfoVO.getSCustSubstFlg());					
					}
	
					// 09-02. FORWARDER 수정
					boolean fwFlag = true;
					String fCustCd = blCustomerInfoVO.getFCustCntCd() + blCustomerInfoVO.getFCustSeq();
					String fCustCdOld = oldBlCustomerInfoVO.getFCustCntCd() + oldBlCustomerInfoVO.getFCustSeq();
					
					if(fCustCd != null && fCustCd.length() > 0){
						if(fCustCd.equals(fCustCdOld)) fwFlag = false;
					}else{
						if(fCustCdOld == null || fCustCdOld.length() < 1) fwFlag = false;
					}
	
					if(fwFlag){
						bkgCustomerVO.setBkgCustTpCd("F");
						bkgCustomerVO.setCustCntCd(blCustomerInfoVO.getFCustCntCd());
						bkgCustomerVO.setCustSeq(blCustomerInfoVO.getFCustSeq());
						bkgCustomerVO.setCustNm(blCustomerInfoVO.getFCustNm());
						dbDao.modifyBkgCustCode(bkgCustomerVO, bkgBlNoVO, blCustomerInfoVO.getFCustSubstFlg());				
					}							
	
					// 09-03. CONSIGNEE 수정
					boolean cnFlag = true;
					String cCustCd = blCustomerInfoVO.getCCustCntCd() + blCustomerInfoVO.getCCustSeq();
					String cCustCdOld = oldBlCustomerInfoVO.getCCustCntCd() + oldBlCustomerInfoVO.getCCustSeq();
					
					if(cCustCd != null && cCustCd.length() > 0){
						if(cCustCd.equals(cCustCdOld)) cnFlag = false;
					}else{
						if(cCustCdOld == null || cCustCdOld.length() < 1) cnFlag = false;
					}
					if(cnFlag){
						bkgCustomerVO.setBkgCustTpCd("C");
						bkgCustomerVO.setCustCntCd(blCustomerInfoVO.getCCustCntCd());
						bkgCustomerVO.setCustSeq(blCustomerInfoVO.getCCustSeq());
						bkgCustomerVO.setCustNm(blCustomerInfoVO.getCCustNm());
						dbDao.modifyBkgCustCode(bkgCustomerVO, bkgBlNoVO, blCustomerInfoVO.getCCustSubstFlg());				
					}							
				}
				
				if("Y".equals(saveValidationVO.getContactModifyFlag())){
					// 10. Contact Person 정보 수정
					BkgCntcPsonVO bkgCntcPsonVO = new BkgCntcPsonVO();
					bkgCntcPsonVO.setBkgNo(bkgNo);
					bkgCntcPsonVO.setCreUsrId(userId);
					bkgCntcPsonVO.setUpdUsrId(userId);
					// 12-01. BK
					bkgCntcPsonVO.setBkgCntcPsonTpCd("BK");
					bkgCntcPsonVO.setCntcPsonNm(bkgBookingInfoVO.getBkgCntcPsonNm());
					bkgCntcPsonVO.setCntcPsonEml(bkgBookingInfoVO.getBkgCntcPsonEml());
					bkgCntcPsonVO.setCntcPsonFaxNo(bkgBookingInfoVO.getBkgCntcPsonFaxNo());
					bkgCntcPsonVO.setCntcPsonMphnNo(bkgBookingInfoVO.getBkgCntcPsonMphnNo());
					bkgCntcPsonVO.setCntcPsonPhnNo(bkgBookingInfoVO.getBkgCntcPsonPhnNo());
					if(dbDao.modifyBkgCntcPson(bkgCntcPsonVO, bkgBlNoVO) < 1){
						dbDao.addBkgCntcPson(bkgCntcPsonVO, bkgBlNoVO);
					}
					// 12-02. SI
					bkgCntcPsonVO.setBkgCntcPsonTpCd("SI");
					bkgCntcPsonVO.setCntcPsonNm(bkgBookingInfoVO.getSiCntcPsonNm());
					bkgCntcPsonVO.setCntcPsonEml(bkgBookingInfoVO.getSiCntcPsonEml());
					bkgCntcPsonVO.setCntcPsonFaxNo(bkgBookingInfoVO.getSiCntcPsonFaxNo());
					bkgCntcPsonVO.setCntcPsonMphnNo(bkgBookingInfoVO.getSiCntcPsonMphnNo());
					bkgCntcPsonVO.setCntcPsonPhnNo(bkgBookingInfoVO.getSiCntcPsonPhnNo());
					if(dbDao.modifyBkgCntcPson(bkgCntcPsonVO, bkgBlNoVO) < 1){
						dbDao.addBkgCntcPson(bkgCntcPsonVO, bkgBlNoVO);
					}					
				}

				if("Y".equals(saveValidationVO.getRouteModifyFlag())||"Y".equals(saveValidationVO.getQtyModifyFlag())){
					if("Y".equals(saveValidationVO.getRouteModifyFlag())){
						// VVD 변경여부 판단을 위해 이전 VVD 조회.
						List<VslSkdVO> oldVslSkdVOs = dbDao.searchVvdSkdForTsRoute(bkgBlNoVO);//<-historyTableVO로 전환 고려
						if(vslSkdVOs!=null){
							if(oldVslSkdVOs.size() != vslSkdVOs.length){
								// Row 수가 다르면 변경.
								saveValidationVO.setChangeVvd("Y");
							}else{
								for(int i = 0 ; i < oldVslSkdVOs.size() ; i++){
									// VVD가 다르면 변경
									if(!oldVslSkdVOs.get(i).getBkgVvdCd().equals(vslSkdVOs[i].getBkgVvdCd())){
										saveValidationVO.setChangeVvd("Y");
										break;
									}
								}
							}
						} else {
							saveValidationVO.setChangeVvd("Y");
						}
					}						
	
					// 12. VVD 저장
					if(bkgBlNoVO.getPctlNo() != null && bkgBlNoVO.getPctlNo().length() > 0 
							&& !"FAIL".equals(bkgBlNoVO.getPctlNo().substring(0, 4))
							&& !"Over T/S".equals(bkgBlNoVO.getPctlNo())){
						if(!oldBkgInfoForPctlNo.getPctlNo().equals(bkgBlNoVO.getPctlNo())){
							dbDao.removeBkgVvd(bkgBlNoVO);
							dbDao.addBkgVvdFromPrd(bkgBlNoVO, bkgBookingInfoVO.getBkgTrunkVvd(), account);
							//POL이 SGSIN이면 지정한 값만큼 일자를 수정한다.
							if(bkgBookingInfoVO.getBkgPolCd().equals("SGSIN")){
								if(!bkgBookingInfoVO.getBkgTrunkVvdOld().equals(bkgBookingInfoVO.getBkgTrunkVvd())){
									dbDao.modifyMtyPkupDt(bkgBookingInfoVO.getBkgNo(), "-6", bkgBookingInfoVO.getBkgPolCd());
								}								
							}
						}
					} else {				
						dbDao.removeBkgVvd(bkgBlNoVO);
						if(vslSkdVOs != null){
							for(int i = 0 ; i < vslSkdVOs.length ; i++){	
								BkgVvdVO bkgVvdVO = new BkgVvdVO();
								bkgVvdVO.setBkgNo(bkgNo);
								bkgVvdVO.setVslPrePstCd(vslSkdVOs[i].getVslPrePstCd());
								bkgVvdVO.setVslSeq(vslSkdVOs[i].getVslSeq());
								if(vslSkdVOs[i].getBkgVvdCd() != null && vslSkdVOs[i].getBkgVvdCd().length() == 9){
									bkgVvdVO.setVslCd(vslSkdVOs[i].getBkgVvdCd().substring(0,4));
									bkgVvdVO.setSkdVoyNo(vslSkdVOs[i].getBkgVvdCd().substring(4,8));
									bkgVvdVO.setSkdDirCd(vslSkdVOs[i].getBkgVvdCd().substring(8,9));
								}
								bkgVvdVO.setPolClptIndSeq(vslSkdVOs[i].getPolClptIndSeq());
								bkgVvdVO.setPodClptIndSeq(vslSkdVOs[i].getPodClptIndSeq());
								bkgVvdVO.setPolCd(vslSkdVOs[i].getPolCd());
								if(vslSkdVOs[i].getPolYdCd() != null && vslSkdVOs[i].getPolYdCd().length() > 0){
									bkgVvdVO.setPolYdCd(vslSkdVOs[i].getPolCd()+vslSkdVOs[i].getPolYdCd());	
								}	
								bkgVvdVO.setPodCd(vslSkdVOs[i].getPodCd());
								if(vslSkdVOs[i].getPodYdCd() != null &&vslSkdVOs[i].getPodYdCd().length() > 0){
									bkgVvdVO.setPodYdCd(vslSkdVOs[i].getPodCd()+vslSkdVOs[i].getPodYdCd());	
								}		
								bkgVvdVO.setCreUsrId(userId);
								bkgVvdVO.setUpdUsrId(userId);
								
								dbDao.addBkgVvd(bkgVvdVO, bkgBlNoVO);
							}
						}
					}
				} else {
					saveValidationVO.setChangeVvd("N");
				}

				// 후쿠시마에서 used commodity가 특정 POD로 가는지 확인함
				util.searchFukushimaUsedCmdt(bkgBlNoVO, bkgBookingInfoVO.getCmdtCd(), "");
				
				// IRAN이 POR, POL, POD, DEL일 경우 Order B/L인 상태로 저장할 수 없다
//				util.searchIranToOrdBl(bkgBlNoVO);
				
				// 계약 관련 정보를 update한다
				dbDao.modifyCtrtInfo(bkgBlNoVO);
//				String porCdChk = porCd == null ? "" : porCd.substring(0,2);
//		    	String polCdChk = polCd == null ? "" : polCd.substring(0,2);
//		    	if( polCdChk.equals("US") || polCdChk.equals("CA") || porCdChk.equals("US") || porCdChk.equals("CA")){
//					String ctrtOfcCd = bkgBookingInfoVO.getCtrtOfcCd();
//					String ctrtSrepCd = bkgBookingInfoVO.getCtrtSrepCd();
//					String orgBkgNo = bkgBookingInfoVO.getBkgNo();
//					log.debug("\n *********************" +
//							"\n ctrtOfcCd:"+ctrtOfcCd +
//							"\n ctrtSrepCd:"+ctrtSrepCd);
//					if( ctrtOfcCd != null && ctrtSrepCd != null && ctrtOfcCd.length() >0 && ctrtSrepCd.length()>0 ) {						
//						dbDao.modifyChangedCtrtInfo(bkgBlNoVO, ctrtOfcCd, ctrtSrepCd, orgBkgNo);  //2011.10.14 jsy
//					}
//		    	}
				
				//------------------------contract
				String scNo  = bkgBookingInfoVO.getScNo();
				String rfaNo = bkgBookingInfoVO.getRfaNo();
				String taaNo = bkgBookingInfoVO.getTaaNo();

				// 00. contract check
				if((scNo == null || scNo.trim().length() == 0)
						&&(rfaNo == null || rfaNo.trim().length() == 0)
						&&(taaNo == null || taaNo.trim().length() == 0)){
					//You must input either S/C No or RFA No or TAA No.
					throw new EventException((String)new ErrorHandler("BKG00016").getMessage());
				}
				
				// 01. searchScAvailable
				ScListInputVO scListInputVO = new ScListInputVO();
				scListInputVO.setBkgNo(bkgNo);
				if(scNo != null && scNo.trim().length() > 0 && !scNo.startsWith("DUM")){
					if(!util.searchScAvailable(scNo, bkgBlNoVO)){
						throw new EventException((String)new ErrorHandler("BKG00281",new String[]{"S/C"}).getMessage());
					}					
					if(dbDao.validateScCtrtPtyTp(scListInputVO, bkgBlNoVO.getCaFlg()) > 0){
						throw new EventException((String)new ErrorHandler("BKG08267").getMessage());
					}
				}
				if(dbDao.validateScCustTp(scListInputVO, bkgBlNoVO.getCaFlg(),"S") > 0){
					throw new EventException((String)new ErrorHandler("BKG08275", new String[]{bkgBookingInfoVO.getCmdtCd()}).getMessage());
				}
				if(dbDao.validateScCustTp(scListInputVO, bkgBlNoVO.getCaFlg(),"R") > 0){
					throw new EventException((String)new ErrorHandler("BKG08276", new String[]{bkgBookingInfoVO.getCmdtCd()}).getMessage());
				}
				
				// 02. searchRfaAvailable
				if(rfaNo != null && rfaNo.trim().length() > 0	 && !rfaNo.startsWith("DUM")){
					// Spot Guide 경우 Proposal OFC 와 L.OFC 가 같아야 한다.
					if(rfaNo!=null && rfaNo.trim().length() > 6  && "G".equals(rfaNo.substring(5,6))){
						String ofcSame = util.rfaSpotPricingAvailableForBkgCre(bkgBlNoVO, rfaNo, bkgBookingInfoVO.getObSrepCd());
						if("N".equals(ofcSame)){
							throw new EventException((String)new ErrorHandler("BKG08329").getMessage());
						}
					}
					
					if(!util.searchRfaAvailable(rfaNo, bkgBlNoVO)){
						throw new EventException((String)new ErrorHandler("BKG00281",new String[]{"RFA"}).getMessage());
					}
				}
				// 02. searchTaaAvailable
				if(taaNo != null && taaNo.trim().length() > 0	 && !taaNo.startsWith("DUM")){
					if(!util.searchTaaAvailable(taaNo, bkgBlNoVO)){
						throw new EventException((String)new ErrorHandler("BKG00281",new String[]{"TAA"}).getMessage());
					}
				}
				
				// qty_dtl용 별도 flag 추가 검토
				// Quantity 처리전에 QtyDtl을 삭제한다.(20090820 추가)
				dbDao.removeBkgQtyDtl(bkgBlNoVO, null);				
				if("Y".equals(saveValidationVO.getQtyModifyFlag())){	
					// 13. Booking Quantity 삭제(현재 Sheet에 존재하는 데이터를 제외하고 삭제한다.)
					ArrayList<String> cntrTpSzList = new ArrayList<String>();
					for(int i = 0 ; i < bkgQuantityVOs.length ; i++){
						cntrTpSzList.add(bkgQuantityVOs[i].getCntrTpszCd());
					}
					dbDao.removeBkgQuantity(cntrTpSzList, bkgBlNoVO, "BKG");				
					
					// 14. Booking Quantity 수정,저장(수정 후 수정건수 없으면 신규 저장)
					for(int i = 0 ; i < bkgQuantityVOs.length ; i++){
						BkgQuantityVO bkgQuantityVO = bkgQuantityVOs[i];
						if(0.0 == Float.parseFloat(bkgQuantityVO.getOpCntrQty())){
							continue;
						}
						bkgQuantityVO.setBkgNo(bkgNo);
						bkgQuantityVO.setFlexHgtFlg(bkgBookingInfoVO.getFlexHgtFlg());
						bkgQuantityVO.setCreUsrId(userId);
						bkgQuantityVO.setUpdUsrId(userId);
						if(dbDao.modifyBkgQuantity(bkgQuantityVO, bkgBlNoVO) == 0){
							dbDao.addBkgQuantity(bkgQuantityVO, bkgBlNoVO);
						}
					}
				}
				// BkgQtyDtl 을 저장한다.(20090820 추가)
				if(bkgQtyDtlVOs != null){
					for(int i = 0 ; i < bkgQtyDtlVOs.length ; i++){
						BkgQtyDtlVO bkgQtyDtlVO = bkgQtyDtlVOs[i];
						if(0.0 == Float.parseFloat(bkgQtyDtlVO.getOpCntrQty())){
							continue;
						}
						if("Y".equals(bkgQtyDtlVO.getAwkCgoFlg()) || "1".equals(bkgQtyDtlVO.getAwkCgoFlg())){
							bkgQtyDtlVO.setAwkCgoFlg("Y");
						}else{
							bkgQtyDtlVO.setAwkCgoFlg("N");
						}
						if("Y".equals(bkgQtyDtlVO.getDcgoFlg()) || "1".equals(bkgQtyDtlVO.getDcgoFlg())){
							bkgQtyDtlVO.setDcgoFlg("Y");
						}else{
							bkgQtyDtlVO.setDcgoFlg("N");
						}			
						
						if("Y".equals(bkgQtyDtlVO.getRcFlg()) || "1".equals(bkgQtyDtlVO.getRcFlg())){
							bkgQtyDtlVO.setRcFlg("Y");
						}else{
							bkgQtyDtlVO.setRcFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getBbCgoFlg()) || "1".equals(bkgQtyDtlVO.getBbCgoFlg())){
							bkgQtyDtlVO.setBbCgoFlg("Y");
						}else{
							bkgQtyDtlVO.setBbCgoFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getSocFlg()) || "1".equals(bkgQtyDtlVO.getSocFlg())){
							bkgQtyDtlVO.setSocFlg("Y");
						}else{
							bkgQtyDtlVO.setSocFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getCrrHngrSglBarUseFlg()) || "1".equals(bkgQtyDtlVO.getCrrHngrSglBarUseFlg())){
							bkgQtyDtlVO.setCrrHngrSglBarUseFlg("Y");
						}else{
							bkgQtyDtlVO.setCrrHngrSglBarUseFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getCrrHngrDblBarUseFlg()) || "1".equals(bkgQtyDtlVO.getCrrHngrDblBarUseFlg())){
							bkgQtyDtlVO.setCrrHngrDblBarUseFlg("Y");
						}else{
							bkgQtyDtlVO.setCrrHngrDblBarUseFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getCrrHngrTplBarUseFlg()) || "1".equals(bkgQtyDtlVO.getCrrHngrTplBarUseFlg())){
							bkgQtyDtlVO.setCrrHngrTplBarUseFlg("Y");
						}else{
							bkgQtyDtlVO.setCrrHngrTplBarUseFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getDryCgoFlg()) || "1".equals(bkgQtyDtlVO.getDryCgoFlg())){
							bkgQtyDtlVO.setDryCgoFlg("Y");
						}else{
							bkgQtyDtlVO.setDryCgoFlg("N");
						}		
						if("Y".equals(bkgQtyDtlVO.getMerHngrFlg()) || "1".equals(bkgQtyDtlVO.getMerHngrFlg())){
							bkgQtyDtlVO.setMerHngrFlg("Y");
						}else{
							bkgQtyDtlVO.setMerHngrFlg("N");
						}		
						bkgQtyDtlVO.setBkgNo(bkgNo);
						bkgQtyDtlVO.setCreUsrId(userId);
						bkgQtyDtlVO.setUpdUsrId(userId);
						
						dbDao.addBkgQtyDtl(bkgQtyDtlVO, bkgBlNoVO);
					}
				} 
				
				if("Y".equals(saveValidationVO.getRouteModifyFlag())){
					// First Vessel 변경여부 확인
					String befFirstVvd = oldBkgInfoVO.getFirstVvd();
					String newFirstVvd = saveValidationVO.getChangeFirstVvd();
					if(befFirstVvd!=null && newFirstVvd!=null && befFirstVvd.length() ==9 && newFirstVvd.length() == 9){
						if(!befFirstVvd.equals(newFirstVvd)){
							if(!"Y".equals(bkgBlNoVO.getCaFlg())){
								// 15. Roll Over 정보 수정
								dbDao.modifyBkgRollOvr(bkgBlNoVO, account);
			
								// 16. Roll Over 정보 저장
								dbDao.addBkgRollOvr(bkgBlNoVO, account);
								
								// 17. Roll Over Notice 전송
								RollOverNoticeParamVO rollOverNoticeParamdVO = dbDao.searchRollOverNoticeParam(bkgBlNoVO);
								if(rollOverNoticeParamdVO != null){
									List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
									bkgNtcHisVOs = eaiDao.sendRollOverNotice(bkgBlNoVO, rollOverNoticeParamdVO, account);
									historyBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0724");
								}
							}
							saveValidationVO.setChangeFirstVvd("Y");
						}
					}
				}
				if(bkgBookingInfoVO.getFmcNo()!=null && bkgBookingInfoVO.getFmcNo().length()>1){
					BkgReferenceVO bkgReferenceVO = new BkgReferenceVO();
					bkgReferenceVO.setBkgNo(bkgNo);
					bkgReferenceVO.setBkgRefTpCd("FMCN");
					bkgReferenceVO.setCpyDescFlg("N");
					bkgReferenceVO.setCustRefNoCtnt(bkgBookingInfoVO.getFmcNo());
					bkgReferenceVO.setUpdUsrId(account.getUsr_id());
					bkgReferenceVO.setCreUsrId(account.getUsr_id());
					
					List<BkgReferenceVO> bkgReferenceVOs = new ArrayList<BkgReferenceVO>();
					bkgReferenceVOs.add(bkgReferenceVO);
					dbDao.addBkgReference(bkgReferenceVOs, bkgBlNoVO.getCaFlg());
				}
				
				String missingMsg = dbDao.searchMissingData(bkgBookingInfoVO, saveValidationVO);
				
				// pct 조회 	2012.02.24 kbj
				String pct = dbDao.searchPct(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getCaFlg());
				
				//pct update 2012.02.24 kbj
				dbDao.modifyPct(bkgBlNoVO, pct);
				
				//pct 이후 Contract No 변경 여부를 기록
				dbDao.modifyRetroactiveKind(bkgBookingInfoVO, bkgBlNoVO);
				
				String destTrnsModCd = dbDao.searchDestTrnsModCdRSQL(bkgBlNoVO.getBkgNo());

				// Stowage Code Update : 삼성전자 MEXICO [OBSS]자동선택
				boolean obssModifyFlag = false;
				BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
				bkgHrdCdgCtntListCondVO.setHrdCdgId("STWG_OBSS");
				bkgHrdCdgCtntListCondVO.setAttrCtnt1("SC_NO");
				List<BkgHrdCdgCtntVO> hrdCdgList = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
				for(int h=0;h<hrdCdgList.size(); h++){
					BkgHrdCdgCtntVO tmpBkgHrdVO = (BkgHrdCdgCtntVO)hrdCdgList.get(h);
					if(bkgBookingInfoVO.getScNo().equals(tmpBkgHrdVO.getAttrCtnt2())){
						obssModifyFlag = true;
						break;
					}
				}
		        
				boolean obssNullFlg = false;
				// 미주향
				if(obssModifyFlag == true && !"A".equals(destTrnsModCd)){
					int updCnt = dbDao.modifyStowageForSamsungMexico(bkgBlNoVO);
					if(updCnt==0){
						obssNullFlg = true;
					}
				// 캐나다향
				} else if(obssModifyFlag == true && "A".equals(destTrnsModCd)){
					int updCnt = dbDao.modifyStowageForSamsungMexicoToCanada(bkgBlNoVO);
					if(updCnt==0){
						obssNullFlg = true;
					}
				}
				
				// 자동 조건이면서, 조건에 해당되지 않을 경우, Stowage Code 와 Block Stowage Code를 NULL 처리한다.
				if(obssNullFlg){
					// Block Stowage 재조회
					bkgBookingInfoVO.setStwgCd("");
					bkgBookingInfoVO.setBlckStwgCd(dbDao.searchBlockStowage(bkgBookingInfoVO, blCustomerInfoVO));
					dbDao.modifyStowageNull(bkgBookingInfoVO);					
				}
				
				// Stowage Code Update : Prime Service [OLBP] 자동선택
				boolean olbpModifyFlag = false;
				bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
				bkgHrdCdgCtntListCondVO.setHrdCdgId("STWG_OLBP");
				bkgHrdCdgCtntListCondVO.setAttrCtnt1("SC_NO");
				hrdCdgList = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
				for(int h=0;h<hrdCdgList.size(); h++){
					BkgHrdCdgCtntVO tmpBkgHrdVO = (BkgHrdCdgCtntVO)hrdCdgList.get(h);
					if(bkgBookingInfoVO.getScNo().equals(tmpBkgHrdVO.getAttrCtnt2())){
						olbpModifyFlag = true;
						break;
					}
				}
				
				boolean olbpNullFlg = false;
				if(olbpModifyFlag == true && !"R".equals(destTrnsModCd)){
					int updCnt = dbDao.modifyStowageForLG(bkgBlNoVO);
					
					if(updCnt==0){
						olbpNullFlg = true;
					}
				} else if(olbpModifyFlag == true && "R".equals(destTrnsModCd)){
					olbpNullFlg = true;
				}
				
				// 자동 조건이면서, 조건에 해당되지 않을 경우, Stowage Code 와 Block Stowage Code를 NULL 처리한다.
				if(olbpNullFlg){
					// Block Stowage 재조회
					bkgBookingInfoVO.setStwgCd("");
					bkgBookingInfoVO.setBlckStwgCd(dbDao.searchBlockStowage(bkgBookingInfoVO, blCustomerInfoVO));
					dbDao.modifyStowageNull(bkgBookingInfoVO);
				}
				
				/* Prime Service : OLBP일 경우, Container에 LBP Flag를 'Y'로 체크.
				 * 
				 * POD 가 US이면, Rail이 아닐 경우 LBP를 'Y'로 설정.
				 * POD 가 CA이면, Rail일 경우 LBP를 'Y'로 설정.
				 *  
				 * */
				dbDao.modifyLbpFlgForContainer(bkgBlNoVO);

				
				// Stowage Code Update : [OLBS]자동선택
				boolean olbsModifyFlag = false;
				bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
				bkgHrdCdgCtntListCondVO.setHrdCdgId("STWG_OLBS");
				bkgHrdCdgCtntListCondVO.setAttrCtnt1("SC_NO");
				hrdCdgList = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
				for(int h=0;h<hrdCdgList.size(); h++){
					BkgHrdCdgCtntVO tmpBkgHrdVO = (BkgHrdCdgCtntVO)hrdCdgList.get(h);
					if(bkgBookingInfoVO.getScNo().equals(tmpBkgHrdVO.getAttrCtnt2())){
						olbsModifyFlag = true;
						break;
					}
				}
				
				boolean olbsNullFlg = false;
				if(olbsModifyFlag == true && !"R".equals(destTrnsModCd)){
					
					// 2018.02.06 iylee OLBS가 아닌 경우임에도 다음의 조건이면 Stowage Code를 Update 가능하게 한다.
					String stwgCd = bkgBookingInfoVO.getStwgCd();
					if(!"OD".equals(stwgCd) && !"OT".equals(stwgCd) && !"OLBP".equals(stwgCd)){
						
						int updCnt = dbDao.modifyStowageForOLBS(bkgBlNoVO);
						// 조건에 해당되지 않을 경우, Stowage Code 와 Block Stowage Code를 NULL 처리한다.
						if(updCnt==0){
							olbsNullFlg = true;
						}
					}
					
				} else if(olbsModifyFlag == true && "R".equals(destTrnsModCd)){
					olbsNullFlg = true;
				}
				
				if(olbsNullFlg){
					// Block Stowage 재조회
					bkgBookingInfoVO.setStwgCd("");
					bkgBookingInfoVO.setBlckStwgCd(dbDao.searchBlockStowage(bkgBookingInfoVO, blCustomerInfoVO));
					dbDao.modifyStowageNull(bkgBookingInfoVO);					
				}
				
				
				// Stowage Code Update : [OLBL]자동선택
				boolean olblModifyFlag = false;
				bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
				bkgHrdCdgCtntListCondVO.setHrdCdgId("STWG_OLBL");
				bkgHrdCdgCtntListCondVO.setAttrCtnt1("SC_NO");
				hrdCdgList = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
				for(int h=0;h<hrdCdgList.size(); h++){
					BkgHrdCdgCtntVO tmpBkgHrdVO = (BkgHrdCdgCtntVO)hrdCdgList.get(h);
					if(bkgBookingInfoVO.getScNo().equals(tmpBkgHrdVO.getAttrCtnt2())){
						olblModifyFlag = true;
						break;
					}
				}
				
				boolean olblNullFlg = false;
				if(olblModifyFlag == true && !"R".equals(destTrnsModCd)){
					int updCnt = dbDao.modifyStowageForOLBL(bkgBlNoVO);
					// 조건에 해당되지 않을 경우, Stowage Code 와 Block Stowage Code를 NULL 처리한다.
					if(updCnt==0){
						olblNullFlg = true;
					}
				} else if(olblModifyFlag == true && "R".equals(destTrnsModCd)){
					olblNullFlg = true;
				}
				if(olblNullFlg){
					// Block Stowage 재조회
					bkgBookingInfoVO.setStwgCd("");
					bkgBookingInfoVO.setBlckStwgCd(dbDao.searchBlockStowage(bkgBookingInfoVO, blCustomerInfoVO));
					dbDao.modifyStowageNull(bkgBookingInfoVO);
				}
				
				// 2017.09.29 iylee Stowage Code Update : OD자동선택
				boolean odModifyFlag = false;
				bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
				bkgHrdCdgCtntListCondVO.setHrdCdgId("STWG_OD");
				bkgHrdCdgCtntListCondVO.setAttrCtnt1("RFA_NO");
				hrdCdgList = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
				for(int h=0;h<hrdCdgList.size(); h++){
					BkgHrdCdgCtntVO tmpBkgHrdVO = (BkgHrdCdgCtntVO)hrdCdgList.get(h);
					if(bkgBookingInfoVO.getRfaNo().equals(tmpBkgHrdVO.getAttrCtnt2())){
						odModifyFlag = true;
						break;
					}
				}
				
				if(odModifyFlag == true){
					dbDao.modifyStowageForOD(bkgBlNoVO);
				}
				
				// 2018.05.24 iylee Stowage Code Update : TS자동선택
				boolean tsModifyFlag = false;
				bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
				bkgHrdCdgCtntListCondVO.setHrdCdgId("STWG_TS");
				bkgHrdCdgCtntListCondVO.setAttrCtnt1("RFA_NO");
				hrdCdgList = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
				for(int h=0;h<hrdCdgList.size(); h++){
					BkgHrdCdgCtntVO tmpBkgHrdVO = (BkgHrdCdgCtntVO)hrdCdgList.get(h);
					if(bkgBookingInfoVO.getRfaNo().equals(tmpBkgHrdVO.getAttrCtnt2())){
						tsModifyFlag = true;
						break;
					}
				}
				
				if(tsModifyFlag == true){
					dbDao.modifyStowageForTS(bkgBlNoVO);
				}
				
				// 북중국 지역 Non DG Chemical 자동 표시
				dbDao.modifyNonDgChemForChina(bkgBlNoVO);
				
				// [SRM-201551910] 계약 No 와 Acustomer 코드 조건이 만날때 하단 EDI Ref.가 자동으로 입력되어 Cargo tracking EDI 전송 요청
				dbDao.modifyExCustByActCust(bkgBlNoVO);
				// Philips 계약조건이 맞는경우 EDI Ref.가 존재하지 않을 때 특정 Customer code로 지정
				dbDao.modifyExCustByCtrt(bkgBlNoVO,"PHILIPS_CONTRACT");
				
				if(!"".equals(missingMsg) || missingMsg.length()>0){
					if("TRO volume".equals(missingMsg)){
						throw new EventException((String)new ErrorHandler("BKG02057").getMessage());
					} else {
						throw new EventException((String)new ErrorHandler("BKG06014", new String[]{missingMsg}).getMessage());
					}
				}
				if("N".equals(saveValidationVO.getAlocChkFlg())){
					OldBkgInfoVO oldBkgInfoForAlloc = dbDao.searchOldBkgInfo(bkgBlNoVO);
					if(!oldBkgInfoForAlloc.getCtrtCustCntCd().equals(oldBkgInfoForPctlNo.getCtrtCustCntCd())
							|| !oldBkgInfoForAlloc.getCtrtCustSeq().equals(oldBkgInfoForPctlNo.getCtrtCustSeq())
							|| !oldBkgInfoForAlloc.getBkgOfcCd().equals(oldBkgInfoForPctlNo.getBkgOfcCd())){
						saveValidationVO.setAlocChkFlg("Y");
					}
				}
			}else{
				// 데이터 저장 실패
				throw new EventException((String)new ErrorHandler("BKG00391").getMessage());
			}
			return saveValidationVO;
		} catch (EventException ex) {
			throw ex;						
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

    /**
     * Booking을 수정한다.(ESM_BKG_007901)<br>
     *
     * @author 		KimByungKyu
     * @param 		BkgBookingVO bkgBookingVO
     * @param 		String caFlg
     * @exception 	EventException
     */
    public void modifyBkgByCm(BkgBookingVO bkgBookingVO, String caFlg) throws EventException {
        try {
            dbDao.modifyBkgByCm(bkgBookingVO, caFlg);
        } catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

	/**
	 * Booking Stauts을 수정한다.(ESM_BKG_007901)<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		String newStsCd
	 * @param 	  	BkgBlNoVO bkgBlNoVO
	 * @param 		boolean validation	  
	 * @param 		SignOnUserAccount account
	 * @return		boolean
	 * @exception 	EventException
	 */
	public boolean changeBkgStatus(String newStsCd, BkgBlNoVO bkgBlNoVO, boolean validation, SignOnUserAccount account) throws EventException {
		try {
			BookingUtil utilBC = new BookingUtil();
			// 01. 기존 Booking Status 확인.(searchBkgStatusByBkg)
			String oldBkgStsCd = utilBC.searchBkgStatusByBkg(bkgBlNoVO);
			
			if("S".equals(oldBkgStsCd)||"X".equals(oldBkgStsCd)){
				return false;
			}
			
			if("F".equals(oldBkgStsCd) && "Y".equals(utilBC.searchBdrFlgByBkg(bkgBlNoVO))){
				return false;
			}
			
			// memo split을 cancel하려고 하는 경우
			if("X".equals(newStsCd) && "S".equals(oldBkgStsCd)){
				return false;
			}
			
			boolean isContinue = true;
			// new Status 와 old Status 가 동일하면 Pass -> 전부 재계산
//			if(newStsCd.equals(oldBkgStsCd)){
//				isContinue = false;
//			}

			boolean isVl = false;
			// 02. searchMVMTStatus
			if(isContinue){
				String[] mvmtStsCd = utilBC.searchMVMTStatus(bkgBlNoVO, null);
				for(int i = 0 ; i < mvmtStsCd.length ; i++){
					if("VL".equals(mvmtStsCd[i])){
						if(validation){
							throw new EventException((String)new ErrorHandler("BKG00317").getMessage());
						}
						isVl = true;
						break;
					}
				}
			}

			// VL(vessel loading) 이후 waiting 상태로 되돌리지 않는다
			if("F".equals(oldBkgStsCd) && isVl){
				isContinue = false;
			}
			
			String spclFlag = "N";
			String pendingFlag = "N";
			if(isContinue){
				// searchSpclWaitRsn()를 실행하여 결과가 Y(승인되지 않은게 있음)이면 spclFlag ='Y'이고 아니면 'N'이다.				
				spclFlag = dbDao.searchSpclWaitRsn(bkgBlNoVO);
				if(!"Y".equals(spclFlag)){//spcl이 없음
					spclFlag = "N";
				} else {
					//spcl이 있어도 wait와 pending 추가능 가능함
					if(validation && "F".equals(newStsCd)){
						throw new EventException((String)new ErrorHandler("BKG02064").getMessage());
					}
				}

				// newStsCd = 'P'이거나 searchUserHold()의 결과가 true이면 pendingFlag = 'Y'이고 아니면 'N'이다.
				if("R".equals(newStsCd)){//<-pending release
					pendingFlag = "N";
				}else{
					if("P".equals(newStsCd) || (!"F".equals(newStsCd) && "Y".equals(dbDao.searchUserHold(bkgBlNoVO)))){
						pendingFlag = "Y";
					}					
				}
//				log.debug("\nold pending flag : " + dbDao.searchUserHold(bkgBlNoVO));

				// spclFlag = 'N' and PendingFlag = 'N'이면 newStsCd = 'F'이고 그외엔 'W'이다.
				if("N".equals(spclFlag) && "N".equals(pendingFlag)){
					newStsCd = "F";
				}else{
					newStsCd = "W";
				}
				
				// vvd 앞 4자리가 HJXX, HJYY, HJZZ 셋중에 하나면 bkg_sts_cd 를 'A' (20091119)
				if(!isCheckVvdCd(dbDao.searchTrunkVvdByBkg(bkgBlNoVO))){
					newStsCd = "A";
				}
				
				if("X".equals(oldBkgStsCd)){
					newStsCd = "X";
				}
				
				// Booking 상태코드 변경(modifyBookingStatus)
				dbDao.modifyBookingStatus(pendingFlag, spclFlag, newStsCd, bkgBlNoVO, account);
				return true;
			} else {
				return false;
			}
		} catch (EventException ex) {
			throw ex;				
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * 변경된 Reference No 정보를 update한다.<br>
	 * 
	 * @param 		String bkgNo
	 * @param 	  	String cntrNo
	 * @param 		String cntrNoOld
	 * @param 		String caFlg
	 * @exception 	EventException
	 */
    public void changeReferenceByCntr(String bkgNo, String cntrNo, String cntrNoOld, String caFlg) throws EventException {
        try {
            dbDao.changeReferenceByCntr(bkgNo, cntrNo, cntrNoOld, caFlg);
        } catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

	/**
	 * 변경된 Reference Detail 정보를 update한다.<br>
	 * 
	 * @param 		String bkgNo
	 * @param 	  	String cntrNo
	 * @param 		String cntrNoOld
	 * @param 		String caFlg
	 * @exception 	EventException
	 */
    public void changeReferenceDetailByCntr(String bkgNo, String cntrNo, String cntrNoOld, String caFlg) throws EventException {
        try {
            dbDao.changeReferenceDetailByCntr(bkgNo, cntrNo, cntrNoOld, caFlg);
        } catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

	/**
	 *  BKG_CLZ_TM 삭제.(ESM_BKG_0079_01)<br>
	 *  
	 * @author 	KimByungKyu
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param 	String modeCd
     * @exception EventException
     */
    public void removeBkgClzTm(BkgBlNoVO bkgBlNoVO, String modeCd) throws EventException {
        try {
        	dbDao.removeBkgClzTm(bkgBlNoVO, modeCd);
        } catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
	}
    
    /**
     * Booking관련 정보를 sourceBkg에서 targetBkg으로 복사한다. split과 cod에서 사용한다 (ESM_BKG_0099)<br>
     * @param BkgBlNoVO sourceBkg
     * @param BkgBlNoVO[] targetBkg
     * @param SplitBkgVO splitBkgVO
     * @param SignOnUserAccount account
     * @return String
     * @exception EventException
     */
    public String copyBookingForSplit (BkgBlNoVO sourceBkg, BkgBlNoVO[] targetBkg, SplitBkgVO splitBkgVO, SignOnUserAccount account)throws EventException{
		String splitFlg = "N";
		
    	try {
    		List<BkgVvdVO> bkgVvdVOList = new ArrayList<BkgVvdVO>();
    		BkgBookingVO bkgBookingVO = new BkgBookingVO();
    		int orginBkgSeq = 0;

			sourceBkg.setCaFlg("N");
    		for(int i=0;i<targetBkg.length;i++){	
				targetBkg[i].setCaFlg("N");
    		}

			// IRAN이 POR, POL, POD, DEL일 경우 Order B/L인 상태로 저장할 수 없다
//			BookingUtil util = new BookingUtil();
//			util.searchIranToOrdBl(sourceBkg);
			
    		bkgVvdVOList=dbDao.searchBkgVvd(sourceBkg);
        	
    		//split시 저장을 위해 bkg_booking 테이블을 조회한다.
			bkgBookingVO = dbDao.searchBkgBookingForSplit((CopySplitBkgEtcVO)splitBkgVO.getCopySplitBkgEtcVO().get(0), sourceBkg ,  account );

			// cod memo split 때문에 실행되지 않게 함
//			if (codRqstNo!=null){
//				List<PodDelForCodVO>podDelForCodVO = new ArrayList<PodDelForCodVO>();
//				podDelForCodVO = dbDao.searchPodDelForCodSplit(codRqstNo, sourceBkg);
//				
//				if (podDelForCodVO.size()>0&&1==0){
//					bkgBookingVO.setPodCd   (podDelForCodVO.get(0).getPodCd());
//					bkgBookingVO.setPodNodCd(podDelForCodVO.get(0).getPodYdCd());
//					bkgBookingVO.setDelCd   (podDelForCodVO.get(0).getDelCd());
//					bkgBookingVO.setDelNodCd(podDelForCodVO.get(0).getDelYdCd());
//					bkgBookingVO.setDeTermCd(podDelForCodVO.get(0).getDeTermCd());
//				}
//			}
			
    		for(int i=0;i<targetBkg.length;i++){	//New Bkg Split 처리    			
    			//BL/NO 채번 
    			if (!sourceBkg.getBkgNo().equals(targetBkg[i].getBkgNo())){
    				// 01. 이미 있는 BOOKING NO로 BOOKING을 저장하려고 하는 경우
    				if(dbDao.searchBkgBlNoDup(targetBkg[i])){
    					throw new EventException((String)new ErrorHandler("BKG00034",new String[]{targetBkg[i].getBlNo()}).getMessage());
    				}
    				dbDao.addBkgBlNoDup(targetBkg[i], account.getUsr_id());
    			}
    			bkgBookingVO.setBkgNo(targetBkg[i].getBkgNo());
    			bkgBookingVO.setBlNo(targetBkg[i].getBkgNo());
    			bkgBookingVO.setVslCd(splitBkgVO.getSplitBlInfoVO().get(i).getTvvd().substring(0,4));
    			bkgBookingVO.setSkdVoyNo(splitBkgVO.getSplitBlInfoVO().get(i).getTvvd().substring(4,8));
    			bkgBookingVO.setSkdDirCd(splitBkgVO.getSplitBlInfoVO().get(i).getTvvd().substring(8,9));
    			//jsy eq tp qty 추가 
    			bkgBookingVO.setRdCgoFlg(splitBkgVO.getSplitBlInfoVO().get(i).getRdCgoFlg());
    			
    			if (sourceBkg.getBkgNo().equals(splitBkgVO.getSplitBlInfoVO().get(i).getBkgNo())){ //원본 Bkg의 seq를 찾는다
    				orginBkgSeq = i;
    			}
    			//원본하고 다른 경우 처리
    			if (!sourceBkg.getBkgNo().equals(splitBkgVO.getSplitBlInfoVO().get(i).getBkgNo())){
    		    	if(splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason().equals("M")){ // "memo"
    		    		bkgBookingVO.setBlNoTp("9");
    		    		bkgBookingVO.setAdvShtgCd(splitBkgVO.getSplitBlInfoVO().get(i).getAdvshtgcd());
    		    	}
    				// BKG_BOOKING 정보 저장
    				dbDao.addBkgBookingForCopySplit(bkgBookingVO);
    				
    				//sourceBkg의 bkg_customer를 targetBkg로 복사한다.    				
        			dbDao.copyBkgCustomerByBkg(sourceBkg, targetBkg[i], account);

    				//BKG_VVD 정보 저장
	    			for(int idx = 0; idx < bkgVvdVOList.size() ; idx++){
	    				BkgVvdVO bkgVvdVO =  (BkgVvdVO)bkgVvdVOList.get(idx);
						bkgVvdVO.setBkgNo(targetBkg[i].getBkgNo());
						dbDao.addBkgVvd(bkgVvdVO, targetBkg[i]);						
					}

    				// 계약 관련 정보를 update한다
    				dbDao.modifyCtrtInfo(targetBkg[i]);
    				
    				dbDao.modifyChangedCtrtInfo(targetBkg[i], "", "", sourceBkg.getBkgNo());  //2011.10.14 jsy
    				
        			//sourceBkg의 bkg_cntc_pson를 targetBkg로 복사한다.
	    			dbDao.copyBkgCntcPsonByBkg(sourceBkg, targetBkg[i], account);
	    			dbDao.copyNVOFileNoByBkg(sourceBkg, targetBkg[i], account);
	    			
					//sourceBkg의 bkg_reference를 targetBkg로 복사한다	 
    				dbDao.copySplitCopyRefByBkg(sourceBkg, targetBkg[i], account);
    				
	    			//assign된 cntr 개수 만큼 반복
	    			for(int icnt=0;icnt<splitBkgVO.getSelectCntrVO().size();icnt++){
	    				if (splitBkgVO.getSelectCntrVO().get(icnt).getSplitNo().length()>0
	    				    && splitBkgVO.getSelectCntrVO().get(icnt).getCntr_no().length()>1
	    					&& !sourceBkg.getBkgNo().equals(splitBkgVO.getSelectCntrVO().get(icnt).getBkg_no())){

		    				//sourceBkg의 bkg_ref_dtl을 targetBkg로 복사한다
		    				dbDao.copyBkgRefDtlByBkg(splitBkgVO.getSelectCntrVO().get(icnt).getCntr_no(), sourceBkg, targetBkg[i], account);
	    				}
	    			}
	    			dbDao.addBkgRollOvr(targetBkg[i], account);
    			}
    		}

			if(splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason().equals("C")){ // "Customer"
				int i = orginBkgSeq; //orgin Bkg Split 처리
				
    			//customer Split의 경우, 원본 Bkg에 대해서 처리루틴
				if (sourceBkg.getBkgNo().equals(splitBkgVO.getSplitBlInfoVO().get(i).getBkgNo())){ //원본 Bkg에 대해서 한번 처리루틴
					//Booking split이후 bkg_booking에 update할 항목을 처리한다.
					SplitBlInfoVO splitBlInfoVO=(SplitBlInfoVO)splitBkgVO.getSplitBlInfoVO().get(i);
					CopySplitBkgEtcVO copySplitBkgEtcVO=(CopySplitBkgEtcVO)splitBkgVO.getCopySplitBkgEtcVO().get(0);
					dbDao.modifyBkgbookingAfterSplit(splitBlInfoVO,copySplitBkgEtcVO, sourceBkg,account );					

	    			for(int icnt=0;icnt<splitBkgVO.getSelectCntrVO().size();icnt++){
	    				 //원본 contr이 변경시에만 삭제처리	
	    				if (splitBkgVO.getSelectCntrVO().get(icnt).getSplitNo().length()<1 && splitBkgVO.getSelectCntrVO().get(icnt).getBkg_no().equals(sourceBkg.getBkgNo())){ 
			    			//bkg_reference에서 전달받은 cntrNo에 해당하는 row를 삭제한다
		    				dbDao.removeBkgRefAfterSplit(splitBkgVO.getSelectCntrVO().get(icnt).getCntr_no(), sourceBkg);
	
		    				//bkg_ref_dtl에서 전달받은 cntrNo에 해당하는 row를 삭제한다.
		    				dbDao.removeBkgRefDtlAfterSplit(splitBkgVO.getSelectCntrVO().get(icnt).getCntr_no(), sourceBkg);
	    				}
	    			}
				}
    		}
			
			// 해당 Booking이 DRY Cargo 인지 아닌지를 체크한다.
			splitFlg = dbDao.checkBkgQtyDtlSplit(sourceBkg.getBkgNo());

			for(int i=0;i<splitBkgVO.getSplitQtyVO().size();i++){
				int targetBkgSeq = i%splitBkgVO.getSplitBlInfoVO().size();
    			splitBkgVO.getSplitQtyVO().get(i).setSplitNo(splitBkgVO.getSplitBlInfoVO().get(targetBkgSeq).getBkgNo());
    			splitBkgVO.getSplitQtyVO().get(i).setSplitNo(splitBkgVO.getSplitBlInfoVO().get(targetBkgSeq).getBkgNo());
    			double iQty =(splitBkgVO.getSplitQtyVO().get(i).getOpCntrQty()==null)? 0:Double.parseDouble(splitBkgVO.getSplitQtyVO().get(i).getOpCntrQty());
				if (!sourceBkg.getBkgNo().equals(splitBkgVO.getSplitBlInfoVO().get(targetBkgSeq).getBkgNo())
					&& iQty>0){ 
					//New Bkg Split 처리
					BkgQuantityVO bkgQuantityVO = new BkgQuantityVO();
					bkgQuantityVO.setBkgNo(splitBkgVO.getSplitBlInfoVO().get(targetBkgSeq).getBkgNo());
					bkgQuantityVO.setCntrTpszCd(splitBkgVO.getSplitQtyVO().get(i).getCntrTpszCd());
					bkgQuantityVO.setOpCntrQty(splitBkgVO.getSplitQtyVO().get(i).getOpCntrQty());
					bkgQuantityVO.setCreUsrId(account.getUsr_id());
					bkgQuantityVO.setUpdUsrId(account.getUsr_id()); 
					bkgQuantityVO.setActCntrQty("0");
					bkgQuantityVO.setDcgoQty("0");
					bkgQuantityVO.setAwkCgoQty("0");
					bkgQuantityVO.setRcQty("0");
					bkgQuantityVO.setBbCgoQty("0");
					bkgQuantityVO.setSocQty("0");
//					bkgQuantityVO.setEqSubstCgoQty("0");
					bkgQuantityVO.setEqSubstCgoQty(splitBkgVO.getSplitQtyVO().get(i).getEqSubstCgoQty());
					bkgQuantityVO.setEqSubstCntrTpszCd(splitBkgVO.getSplitQtyVO().get(i).getEqSubstCntrTpszCd());
					
					bkgQuantityVO.setMerHngrQty("0");
					bkgQuantityVO.setCrrHngrQty("0");
					bkgQuantityVO.setCrrHngrSglBarQty("0");
					bkgQuantityVO.setCrrHngrDblBarQty("0");
					bkgQuantityVO.setCrrHngrTplBarQty("0");
					bkgQuantityVO.setOrgCntrQty("0");
					bkgQuantityVO.setDestCntrQty("0");
					bkgQuantityVO.setObTroQty("0");
					bkgQuantityVO.setIbTroQty("0");
					bkgQuantityVO.setFlexHgtFlg("N");
					
					dbDao.addBkgQuantity(bkgQuantityVO, targetBkg[targetBkgSeq]);
					
					if("Y".equals(splitFlg)){
						dbDao.copyBkgQtyDtlForSplit(sourceBkg, targetBkg[targetBkgSeq], splitBkgVO.getSplitQtyVO().get(i).getCntrTpszCd(), account);
						dbDao.modifyBkgQtyDtl(bkgQuantityVO, targetBkg[targetBkgSeq]);
					}
					
					log.debug("new qty insert 완");
//					제외 (임종한 대리님 요청 2009.10.12)
//					dbDao.copyBkgQtyDtlForSplit(sourceBkg, targetBkg[i], splitBkgVO.getSplitQtyVO().get(i).getCntrTpszCd(), account);
					
				} else {    		
		    		if(splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason().equals("C")){ // "Customer"
		    			//orgin Bkg Split 처리
		    			int orgBkg = orginBkgSeq;     			
						//BKG_QUANTITY에 INSERT한다
						BkgQuantityVO bkgQuantityVO = new BkgQuantityVO();
						bkgQuantityVO.setBkgNo(targetBkg[orgBkg].getBkgNo());
						bkgQuantityVO.setCntrTpszCd(splitBkgVO.getSplitQtyVO().get(i).getCntrTpszCd());
						bkgQuantityVO.setOpCntrQty(splitBkgVO.getSplitQtyVO().get(i).getOpCntrQty());
						bkgQuantityVO.setCreUsrId(account.getUsr_id());
						bkgQuantityVO.setUpdUsrId(account.getUsr_id()); 
						//eq tp qty추가 jsy
						bkgQuantityVO.setEqSubstCntrTpszCd(splitBkgVO.getSplitQtyVO().get(i).getEqSubstCntrTpszCd()); 
						bkgQuantityVO.setEqSubstCgoQty(splitBkgVO.getSplitQtyVO().get(i).getEqSubstCgoQty()); 
						
						
						if (sourceBkg.getBkgNo().equals(splitBkgVO.getSplitBlInfoVO().get(targetBkgSeq).getBkgNo())){ 
							//원본 Bkg에 대해서 한번 처리루틴
							ArrayList<String> cntrTpSzList=new ArrayList<String>();
							cntrTpSzList.add(splitBkgVO.getSplitQtyVO().get(i).getCntrTpszCd());

							dbDao.modifyBkgQuantity(bkgQuantityVO, sourceBkg);
							
//							if("Y".equals(splitFlg)){
								dbDao.modifyBkgQtyDtl(bkgQuantityVO, sourceBkg);
//							}
							
						}
		    		}
				}
			}
			
		         //delete quantity in case of OP_CNTR_QTY = 0
            dbDao.removeBkgQtyDtlZero(sourceBkg.getBkgNo());
            dbDao.removeBkgQtyZero(sourceBkg.getBkgNo());

	    	if(splitBkgVO.getCopySplitBkgEtcVO().get(0).getSplitreason().equals("M")){ // "memo"
				dbDao.modifyMemoSplit(sourceBkg, account);
	    	}
		} catch (EventException ex) {
			throw ex;		
        } catch (DAOException de) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch (Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        
        return splitFlg;
    }
    
    
     

	/**
	 * Booking을 Cancel한다.(ESM_BKG_007901)<br>
	 * 
	 * @author 	KimByungKyu
	 * @param 	BkgBlNoVO bkgBlNoVO
	 * @param 	SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelBooking(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {
		try {
			BookingUtil util = new BookingUtil();

			// S/O issue 후에는 cancel할 수 없으며 [PRD00014] 메세지를 보여준다
			//throw new EventException((String)new ErrorHandler("PRD00014").getMessage());

//			// bkg ofc와 login ofc가 다르면 [BKG00875]를 보여주고 중지한다.
//			if(!account.getOfc_cd().equals(util.searchBkgOfcByBkg(bkgBlNoVO))){
//				throw new EventException((String)new ErrorHandler("BKG00875").getMessage());
//			}				

			// b/l issue 됐으면 [BKG02019]를 보여주고 중지한다.
			if("Y".equals(dbDao.searchBlIss(bkgBlNoVO))){
				throw new EventException((String)new ErrorHandler("BKG02019").getMessage());
			}
			// s/o가 있으면 cancel 불가
			if("Y".equals(util.searchSoStatus("", "", bkgBlNoVO, null))){
				throw new EventException((String)new ErrorHandler("BKG00094").getMessage());								
			}
			
			if(!"Y".equals(bkgBlNoVO.getCaFlg())){
				// 02. searchMVMTStatus
				String[] mvmtStsCd = util.searchMVMTStatus(bkgBlNoVO, null);
				for(int i = 0 ; i < mvmtStsCd.length ; i++){
					if("VL".equals(mvmtStsCd[i])){
						throw new EventException((String)new ErrorHandler("BKG00317").getMessage());
					}
				}

				// special cargo 승인 진행 중이라면 [BKG00316]을 보여주고 중지한다
				if("Y".equals(dbDao.searchSpclApprove(bkgBlNoVO))){
					throw new EventException((String)new ErrorHandler("BKG00316").getMessage());
				}

				// 다른사용자가 Hold중이면 [BKG00318]을 보여주고 중지한다 -> 제외 (20100406 임종한 과장)
//				if("Y".equals(dbDao.searchUserHold(bkgBlNoVO))){
//					throw new EventException((String)new ErrorHandler("BKG00318").getMessage());
//				}
			}
			
			// Booking 상태코드 변경(modifyBookingStatus)
			dbDao.modifyBookingStatus("N", "N", "X", bkgBlNoVO, account);
			// US Rail Cut Off Time 공백 처리
			dbDao.modifyCargoClosingTimeByReplan(bkgBlNoVO, "", "", account);
		} catch (EventException ex) {
			throw ex;		
		} catch (DAOException ex) { 
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * special cgo qty를 변경한다.(ESM_BKG_0055)<br>
	 * 
	 * @param SpclQtyVO spclQtyVO
	 * @param String caFlg 
	 * @exception EventException
	 */	
	public void modifyAwkQty(SpclQtyVO spclQtyVO, String caFlg) throws EventException {
		try {				
			dbDao.modifyAwkQty(spclQtyVO, caFlg);
						
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}  
	/**
	 * special cgo qty를 변경한다.(ESM_BKG_0055)<br>
	 * 
	 * @param SpclVO spclVO
	 * @param String caFlg 
	 * @exception EventException
	 */		
	public void modifyBkgBySpcl(SpclVO spclVO, String caFlg) throws EventException {
		try {				
			dbDao.modifyBkgSpclFlg(spclVO.getBkgNo(), spclVO.getSpclTp(), caFlg);
			dbDao.modifySpclQty(spclVO.getBkgNo(), spclVO.getCntrTpszCd(), spclVO.getSpclTp(), spclVO.getCntrVolQty(), caFlg);
						
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}  

	/**
	 * Booking정보를 수정한다.(ESM_BKG_0029)<br>
	 * 
     * @author		Jun Yong Jin (modified by KimByungKyu)
	 * @param 		String xterRqstViaCd
	 * @param       String saveModeCd
	 * @param 		String autoNotification
	 * @param       XterRqstNoVO xterRqstNoVO
	 * @param       SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyBkgByXter(String xterRqstViaCd, String saveModeCd, String autoNotification, XterRqstNoVO xterRqstNoVO, SignOnUserAccount account) throws EventException {
		try {
			// 26. BKG_XTER_RQST_MST 정보 수정
			dbDao.modifyXterRqstInfo (xterRqstNoVO , saveModeCd , autoNotification, xterRqstViaCd, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * Empty Repo Booking에 대해서 Booking 정보를 생성/update한다<br>
	 * 
     * @author		KimByungKyu
	 * @param 		MtyBookingCreateVO mtyBookingCreateVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void createMtyRepoBooking(MtyBookingCreateVO mtyBookingCreateVO, SignOnUserAccount account) throws EventException {
		try {		
			BookingUtil utilBC = new BookingUtil();
			if(mtyBookingCreateVO != null){
				MtyBookingVO mtyBookingVO = mtyBookingCreateVO.getMtyBookingVO();
				BkgBlNoVO bkgBlNoVO = mtyBookingCreateVO.getBkgBlNoVO();
				MtyVvdVO[] mtyVvdVOs = mtyBookingCreateVO.getMtyVvdVOs();
				MtyQtyVO[] mtyQtyVOs = mtyBookingCreateVO.getMtyQtyVOs();
				
				// 데이터 존재여부 확인
				if(mtyBookingVO == null){
					// 데이터 저장 실패(MtyBooking 정보 없음)				
					throw new EventException((String)new ErrorHandler("BKG00391").getMessage());						
				}
				if(bkgBlNoVO == null){
					// 데이터 저장 실패(BkgBlNoVO 정보 없음)				
					throw new EventException((String)new ErrorHandler("BKG00391").getMessage());						
				}				
				if(mtyVvdVOs == null || mtyVvdVOs.length < 1){
					// 데이터 저장 실패(MtyVvdVO 정보 없음)				
					throw new EventException((String)new ErrorHandler("BKG00391").getMessage());						
				}	
				if(mtyQtyVOs == null || mtyQtyVOs.length < 1){
					// 데이터 저장 실패(MtyQtyVO 정보 없음)				
					throw new EventException((String)new ErrorHandler("BKG00391").getMessage());						
				}					
				for(int i = 0 ; i < mtyVvdVOs.length ; i++){
					if("XXXXX".equals(mtyVvdVOs[i].getPolYdCd().substring(0,5))){
						mtyBookingVO.setPodCd("XXXXX");
						mtyBookingVO.setPodYdCd("XXXXXXX");
						break;
					}
				}
				String bkgNo = bkgBlNoVO.getBkgNo();
				// 010. addMtyBkgBooking()을 실행하여 bkg_booking에 insert한다.
				dbDao.addMtyBkgBooking(bkgNo, mtyBookingVO, account);
				// 020. Bkg Customer 정보 저장
				dbDao.addMtyBkgCust(bkgNo, account);
				// 030. Bkg Quantity 정보 저장
				for(int i = 0 ; i < mtyQtyVOs.length ; i++){
					dbDao.addMtyBkgQty(mtyQtyVOs[i], bkgNo, account);
				}
				for(int i = 0 ; i < mtyVvdVOs.length ; i++){
					// EQR에서 yard code 7자리만 주기 때문에 앞 5자리를 location으로 mapping한다. 
					mtyVvdVOs[i].setPolCd(mtyVvdVOs[i].getPolYdCd().substring(0, 5));
					mtyVvdVOs[i].setPodCd(mtyVvdVOs[i].getPodYdCd().substring(0, 5));
					
					// 040. validateVVD()의 결과가 없다면 [BKG00944]를 보여주고 중지한다.
					if(!utilBC.validateVvd(mtyVvdVOs[i].getVslCd(), mtyVvdVOs[i].getSkdVoyNo(), mtyVvdVOs[i].getSkdDirCd())){
						throw new EventException((String)new ErrorHandler("BKG00944").getMessage());
					}
					// 050. searchEtbEtdEta()의 결과가 없다면 POL이었을 경우 [BKG00078], POD 였을 경우 [BKG00945]를 보여주고 중지한다.
					if(utilBC.searchEtbEtdEta(mtyVvdVOs[i].getVslCd(), mtyVvdVOs[i].getSkdVoyNo(), mtyVvdVOs[i].getSkdDirCd(), mtyVvdVOs[i].getPolCd(), mtyVvdVOs[i].getPolClptIndSeq()) == null){
						throw new EventException((String)new ErrorHandler("BKG00078",new String[]{mtyVvdVOs[i].getPolCd()}).getMessage());	
					}
					// POD 미지정(multi bkg)인 경우 POD schedule은 확인하지 않음
					if(mtyVvdVOs[i].getPodCd().equals("XXXXXXX")){
						if(utilBC.searchEtbEtdEta(mtyVvdVOs[i].getVslCd(), mtyVvdVOs[i].getSkdVoyNo(), mtyVvdVOs[i].getSkdDirCd(), mtyVvdVOs[i].getPodCd(), mtyVvdVOs[i].getPodClptIndSeq()) == null){
							throw new EventException((String)new ErrorHandler("BKG00945",new String[]{mtyVvdVOs[i].getPodCd()}).getMessage());	
						}
					}
					// 060. trunk vvd일 경우 bkg_booking에도 update하기 위해 modifyTrunkVvd()를 실행한다.
					if("T".equals(mtyVvdVOs[i].getVslPrePstCd())){
						dbDao.modifyTrunkVvd(mtyVvdVOs[i].getVslCd()+mtyVvdVOs[i].getSkdVoyNo()+mtyVvdVOs[i].getSkdDirCd(), bkgBlNoVO, account);
					}
					// 070. 전달값과 조회값으로 bkg_vvd에 insert하기 위해 addBkgVvd()를 실행한다.
					BkgVvdVO bkgVvdVO = new BkgVvdVO();
					bkgVvdVO.setBkgNo(bkgNo);
					bkgVvdVO.setVslPrePstCd(mtyVvdVOs[i].getVslPrePstCd());
					bkgVvdVO.setVslSeq(mtyVvdVOs[i].getVslSeq());
					bkgVvdVO.setVslCd(mtyVvdVOs[i].getVslCd());
					bkgVvdVO.setSkdVoyNo(mtyVvdVOs[i].getSkdVoyNo());
					bkgVvdVO.setSkdDirCd(mtyVvdVOs[i].getSkdDirCd());
					bkgVvdVO.setPolClptIndSeq(mtyVvdVOs[i].getPolClptIndSeq());
					bkgVvdVO.setPodClptIndSeq(mtyVvdVOs[i].getPodClptIndSeq());
					bkgVvdVO.setPolCd(mtyVvdVOs[i].getPolYdCd().substring(0, 5));
					bkgVvdVO.setPolYdCd(mtyVvdVOs[i].getPolYdCd());
					bkgVvdVO.setPodCd(mtyVvdVOs[i].getPodYdCd().substring(0, 5));
					bkgVvdVO.setPodYdCd(mtyVvdVOs[i].getPodYdCd());
					bkgVvdVO.setCreUsrId(account.getUsr_id());
					bkgVvdVO.setUpdUsrId(account.getUsr_id());

					dbDao.addBkgVvd(bkgVvdVO, bkgBlNoVO);					
				}				

			}else{
				// 데이터 저장 실패(MtyBookingCreate 정보 없음)				
				throw new EventException((String)new ErrorHandler("BKG00391").getMessage());
			}
		} catch (EventException ex) {
			throw ex;					
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}


	/**
	 * Booking Creation시 Customer Information 정보 조회.(ESM_BKG_007905)<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return			BlDocCustVO
	 * @exception 	EventException
	 */
	public BlCustomerVO searchBlDocCust(BkgBlNoVO bkgBlNoVO) throws EventException {
		BlCustomerVO blCustomerVO = null;
		try {
			BookingUtil utilBC = new BookingUtil();
			
			// 01. Booking No로 C/A 정보등을 조회한다.
			BkgBlNoVO schBkgBlNoVO = utilBC.searchBkgBlNoVO(bkgBlNoVO);
			
			if(schBkgBlNoVO != null){
				blCustomerVO = new BlCustomerVO();
				
				// 02. Bkg Customer 정보를 조회한다.
				BlDocCustVO blDocCustVO = dbDao.searchBlDocCust(schBkgBlNoVO);
				
				// 03. Bkg Customer 이외의 정보를 조회한다.
				CustEtcVO custEtcVO = dbDao.searchBkgCustEtc(schBkgBlNoVO);
				// 04. Original BL NO 조회
				if(!"Y".equals(schBkgBlNoVO.getCaFlg())){
					SplitMstBlNoVO splitMstBlNoVO = utilBC.searchSplitMstBlNo(schBkgBlNoVO.getBkgNo());
					
					blCustomerVO.setSplitMstBlNoVO(splitMstBlNoVO);
				}			
				blDocCustVO.getShCustCntCd();//.getShCntSeq();
				// CANADA 경유 여부 확인
				String frobCode = utilBC.searchFrob(schBkgBlNoVO.getBkgNo(), custEtcVO.getBkgVvd(), custEtcVO.getPolCd(), custEtcVO.getPodCd());
				String frobFlag = "N";
				if("CA".equals(frobCode) || "AL".equals(frobCode)){
					frobFlag = "Y";
				}
				custEtcVO.setFrobFlag(frobFlag);
				custEtcVO.setNlFlag(utilBC.searchNlFlagByBkg(schBkgBlNoVO));
				
				// 2014.05.29 [CHM-201430407] 
				boolean isRatedFlg = dbDao.searchIsRated(bkgBlNoVO);
				String sRatedFlg = "N";
				if (isRatedFlg == true) sRatedFlg = "Y";
				blDocCustVO.setIsRatedFlg(sRatedFlg);
				
				// 2014.06.18 [CHM-201430438]
				boolean actCustListExistFlg = dbDao.checkActualCustomerListExist(bkgBlNoVO);
				String sActCustListExistFlg = "N";
				if (actCustListExistFlg == true) sActCustListExistFlg = "Y";
				blDocCustVO.setActCustListExistFlg(sActCustListExistFlg);
				
				blCustomerVO.setBlDocCustVO(blDocCustVO);
				blCustomerVO.setCustEtcVO(custEtcVO);
				blCustomerVO.setBkgBlNoVO(schBkgBlNoVO);
			}
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return blCustomerVO;
	}
	

	/**
	 * Customer Information 생성시 Validation 체크.(ESM_BKG_007905)<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BlCustomerVO blCustomerVO
	 * @return			String[]
	 * @exception 	EventException
	 */
	public String[] validateBlDocCust(BlCustomerVO blCustomerVO) throws EventException {
		String[] rtnArr = null;
		try {
			List<String> alertList = new ArrayList<String>();		
			BookingUtil utilBC = new BookingUtil();			
			
			BkgBlNoVO bkgBlNoVO = blCustomerVO.getBkgBlNoVO();
			BlDocCustVO blDocCustVO = blCustomerVO.getBlDocCustVO();
			CustEtcVO custEtcVO = blCustomerVO.getCustEtcVO();			

			if(bkgBlNoVO.getBlNo().length() > 12){
				String oblSrndFlg = bkgBlNoVO.getBlNo().subSequence(12, 13) + "";
				if(oblSrndFlg != null && oblSrndFlg.equals("S")){
					if(custEtcVO.getCustToOrdFlg().equals("Y")){
						throw new EventException((String)new ErrorHandler("BKG08266").getMessage());
					}
				}
			}			
			
			if(blDocCustVO.getShCustCntCd()==null || blDocCustVO.getShCustCntCd().length()<1
					||blDocCustVO.getShCustSeq()==null || blDocCustVO.getShCustSeq().length()<1){					
				throw new EventException((String)new ErrorHandler("BKG00008").getMessage());
			}
			int laneSteStreetPo = 0;
			if(custEtcVO.getDocTpCd() == null || custEtcVO.getDocTpCd().length() == 0 || custEtcVO.getDocTpCd().equals("S")){
				laneSteStreetPo = dbDao.searchLaneSteStreetPo(bkgBlNoVO);
			}			
			
			String alertMsg = "";
			MdmCustVO mdmCustVO = null;
			// 12. Mdm Customer 에 존재여부 확인 및 14. BlackList Customer 확인 및 Alert Cust 조회 ($$$$$BlackList 처리 로직 추가필요 - 20090807)
			String shCustCntCd = blDocCustVO.getShCustCntCd();
			String shCustSeq = blDocCustVO.getShCustSeq();					
			if(shCustCntCd != null && shCustCntCd.length() > 0 && shCustSeq != null && shCustSeq.length() > 0){
				mdmCustVO = utilBC.searchMdmCust(shCustCntCd, shCustSeq, "N");
				if("Y".equals(mdmCustVO.getNmdCustFlg())){
					throw new EventException((String)new ErrorHandler("BKG00458").getMessage());
				}
				if("Y".equals(mdmCustVO.getDeltFlg())){
					throw new EventException((String)new ErrorHandler("BKG00353", new String[]{shCustCntCd, shCustSeq}).getMessage());
				}		
				if("Y".equals(mdmCustVO.getBlockFlag())){
					throw new EventException((String)new ErrorHandler("BKG00354", new String[]{shCustCntCd, shCustSeq}).getMessage());
				}
				if(mdmCustVO == null || "Y".equals(mdmCustVO.getExcdCrFlg())){
					throw new EventException((String)new ErrorHandler("BKG08350",new String[]{shCustCntCd+shCustSeq,mdmCustVO.getArOfc(),mdmCustVO.getSrepNm()}).getMessage());
				}
				if(mdmCustVO == null || "Y".equals(mdmCustVO.getNoUseFlg())){
					throw new EventException((String)new ErrorHandler("BKG02004",new String[]{shCustCntCd+shCustSeq,mdmCustVO.getNoUseRsn()}).getMessage());
				}
				alertMsg = utilBC.searchAlertCust(shCustCntCd, shCustSeq);
				if(alertMsg != null && alertMsg.length() > 0){
					alertList.add(alertMsg);
				}
				if(laneSteStreetPo > 0){
					if(blDocCustVO.getShEurCstmsStNm() == null || blDocCustVO.getShEurCstmsStNm().length() < 1){	
						throw new EventException((String)new ErrorHandler("BKG03050", new String[]{"Shipper's Street / P.O.Box", "Shipper's Street / P.O.Box"}).getMessage());
					}
				}
			}

			if(blDocCustVO.getShCstmsDeclCntCd().length()==2){
				MdmCountryVO countryVO = utilBC.searchCountryCode(blDocCustVO.getShCstmsDeclCntCd());
				if(countryVO == null){
					throw new EventException((String)new ErrorHandler("BKG00464", new String[]{"Shipper", blDocCustVO.getShCstmsDeclCntCd()}).getMessage());
				}
			} else if(blDocCustVO.getShCstmsDeclCntCd().length() != 0){
				throw new EventException((String)new ErrorHandler("BKG00464", new String[]{"Shipper", blDocCustVO.getShCstmsDeclCntCd()}).getMessage());				
			}
			
			String cnCustCntCd = blDocCustVO.getCnCustCntCd();
			String cnCustSeq = blDocCustVO.getCnCustSeq();
			if(cnCustCntCd != null && cnCustCntCd.length() > 0 && cnCustSeq != null && cnCustSeq.length() > 0){
				mdmCustVO = utilBC.searchMdmCust(cnCustCntCd, cnCustSeq, "N");
				if("Y".equals(mdmCustVO.getNmdCustFlg())){
					throw new EventException((String)new ErrorHandler("BKG00458").getMessage());
				}
				if("Y".equals(mdmCustVO.getDeltFlg())){
					throw new EventException((String)new ErrorHandler("BKG00353", new String[]{cnCustCntCd, cnCustSeq}).getMessage());
				}		
				if("Y".equals(mdmCustVO.getBlockFlag())){
					throw new EventException((String)new ErrorHandler("BKG00354", new String[]{cnCustCntCd, cnCustSeq}).getMessage());
				}	
				if(mdmCustVO == null || "Y".equals(mdmCustVO.getExcdCrFlg())){
					throw new EventException((String)new ErrorHandler("BKG08350",new String[]{cnCustCntCd+cnCustSeq,mdmCustVO.getArOfc(),mdmCustVO.getSrepNm()}).getMessage());
				}
				if(mdmCustVO == null || "Y".equals(mdmCustVO.getNoUseFlg())){
					throw new EventException((String)new ErrorHandler("BKG02004",new String[]{cnCustCntCd+cnCustSeq,mdmCustVO.getNoUseRsn()}).getMessage());
				}
				alertMsg = utilBC.searchAlertCust(cnCustCntCd, cnCustSeq);
				if(alertMsg != null && alertMsg.length() > 0){
					alertList.add(alertMsg);
				}				
				if(laneSteStreetPo > 0){ //[CHM-201429346] TO ORDER 일 경우는 Consignee 말고 Notify's Street / P.O.Box 가 Mandatory 
					if(custEtcVO==null || custEtcVO.getCustToOrdFlg()==null || !"Y".equals(custEtcVO.getCustToOrdFlg())){
						if(blDocCustVO.getCnEurCstmsStNm() == null || blDocCustVO.getCnEurCstmsStNm().length() < 1){	
							throw new EventException((String)new ErrorHandler("BKG03050", new String[]{"Consignee's Street / P.O.Box", "Consignee's Street / P.O.Box"}).getMessage());
						}
					}
				}
			}			
			
			if(blDocCustVO.getCnCstmsDeclCntCd().length()==2){
				MdmCountryVO countryVO = utilBC.searchCountryCode(blDocCustVO.getCnCstmsDeclCntCd());
				if(countryVO == null){
					throw new EventException((String)new ErrorHandler("BKG00464", new String[]{"Consignee", blDocCustVO.getCnCstmsDeclCntCd()}).getMessage());
				}
			} else if(blDocCustVO.getCnCstmsDeclCntCd().length() != 0){
				throw new EventException((String)new ErrorHandler("BKG00464", new String[]{"Shipper", blDocCustVO.getCnCstmsDeclCntCd()}).getMessage());
			}
			
			String nfCustCntCd = blDocCustVO.getNfCustCntCd();
			String nfCustSeq = blDocCustVO.getNfCustSeq();
			if(nfCustCntCd != null && nfCustCntCd.length() > 0 && nfCustSeq != null && nfCustSeq.length() > 0){
				mdmCustVO = utilBC.searchMdmCust(nfCustCntCd, nfCustSeq, "N");
				if("Y".equals(mdmCustVO.getNmdCustFlg())){
					throw new EventException((String)new ErrorHandler("BKG00458").getMessage());
				}
				if("Y".equals(mdmCustVO.getDeltFlg())){
					throw new EventException((String)new ErrorHandler("BKG00353", new String[]{nfCustCntCd, nfCustSeq}).getMessage());
				}		
				if("Y".equals(mdmCustVO.getBlockFlag())){
					throw new EventException((String)new ErrorHandler("BKG00354", new String[]{nfCustCntCd, nfCustSeq}).getMessage());
				}	
				if(mdmCustVO == null || "Y".equals(mdmCustVO.getExcdCrFlg())){
					throw new EventException((String)new ErrorHandler("BKG08350",new String[]{nfCustCntCd+nfCustSeq,mdmCustVO.getArOfc(),mdmCustVO.getSrepNm()}).getMessage());
				}
				if(mdmCustVO == null || "Y".equals(mdmCustVO.getNoUseFlg())){
					throw new EventException((String)new ErrorHandler("BKG02004",new String[]{nfCustCntCd+nfCustSeq,mdmCustVO.getNoUseRsn()}).getMessage());
				}
				alertMsg = utilBC.searchAlertCust(nfCustCntCd, nfCustSeq);
				if(alertMsg != null && alertMsg.length() > 0){
					alertList.add(alertMsg);
				}
				if(laneSteStreetPo > 0){ //[CHM-201429346] TO ORDER 일 경우는 Consignee 말고 Notify's Street / P.O.Box 가 Mandatory 
					if(custEtcVO!=null && custEtcVO.getCustToOrdFlg()!=null && "Y".equals(custEtcVO.getCustToOrdFlg())){
						if(blDocCustVO.getNfEurCstmsStNm() == null || blDocCustVO.getNfEurCstmsStNm().length() < 1){	
							throw new EventException((String)new ErrorHandler("BKG03050", new String[]{"Notify's Street / P.O.Box", "Consignee's Street / P.O.Box"}).getMessage());
						}
					}
				}
			}				
			
			if(blDocCustVO.getNfCstmsDeclCntCd().length()==2){
				MdmCountryVO countryVO = utilBC.searchCountryCode(blDocCustVO.getNfCstmsDeclCntCd());
				if(countryVO == null){
					throw new EventException((String)new ErrorHandler("BKG00464", new String[]{"Notify", blDocCustVO.getNfCstmsDeclCntCd()}).getMessage());
				}
			} else if(blDocCustVO.getNfCstmsDeclCntCd().length() != 0){
				throw new EventException((String)new ErrorHandler("BKG00464", new String[]{"Shipper", blDocCustVO.getNfCstmsDeclCntCd()}).getMessage());
			}
			if(blDocCustVO.getCnCustFaxNo() != null && blDocCustVO.getCnCustFaxNo().length() > 20){
				throw new EventException((String)new ErrorHandler("BKG40020", new String[]{blDocCustVO.getCnCustFaxNo()}).getMessage());
			}
			String ffCustCntCd = blDocCustVO.getFfCustCntCd();
			String ffCustSeq = blDocCustVO.getFfCustSeq();
			if(ffCustCntCd != null && ffCustCntCd.length() > 0 && ffCustSeq != null && ffCustSeq.length() > 0){
				mdmCustVO = utilBC.searchMdmCust(ffCustCntCd, ffCustSeq, "N");
				if("Y".equals(mdmCustVO.getNmdCustFlg())){
					throw new EventException((String)new ErrorHandler("BKG00458").getMessage());
				}
				if("Y".equals(mdmCustVO.getDeltFlg())){
					throw new EventException((String)new ErrorHandler("BKG00353", new String[]{ffCustCntCd, ffCustSeq}).getMessage());
				}		
				if("Y".equals(mdmCustVO.getBlockFlag())){
					throw new EventException((String)new ErrorHandler("BKG00354", new String[]{ffCustCntCd, ffCustSeq}).getMessage());
				}	
				if(mdmCustVO == null || "Y".equals(mdmCustVO.getExcdCrFlg())){
					throw new EventException((String)new ErrorHandler("BKG08350",new String[]{ffCustCntCd+ffCustSeq,mdmCustVO.getArOfc(),mdmCustVO.getSrepNm()}).getMessage());
				}
				if(mdmCustVO == null || "Y".equals(mdmCustVO.getNoUseFlg())){
					throw new EventException((String)new ErrorHandler("BKG02004",new String[]{ffCustCntCd+ffCustSeq,mdmCustVO.getNoUseRsn()}).getMessage());
				}
				alertMsg = utilBC.searchAlertCust(ffCustCntCd, ffCustSeq);
				if(alertMsg != null && alertMsg.length() > 0){
					alertList.add(alertMsg);
				}						
			}		
			if(blDocCustVO.getCnCustFaxNo() != null && blDocCustVO.getCnCustFaxNo().length() > 20){
				throw new EventException((String)new ErrorHandler("BKG40020", new String[]{blDocCustVO.getCnCustFaxNo()}).getMessage());
			}			
			
			String anCustCntCd = blDocCustVO.getAnCustCntCd();
			String anCustSeq = blDocCustVO.getAnCustSeq();
			if(anCustCntCd != null && anCustCntCd.length() > 0 && anCustSeq != null && anCustSeq.length() > 0){
				mdmCustVO = utilBC.searchMdmCust(anCustCntCd, anCustSeq, "N");
				if("Y".equals(mdmCustVO.getNmdCustFlg())){
					throw new EventException((String)new ErrorHandler("BKG00458").getMessage());
				}
				if("Y".equals(mdmCustVO.getDeltFlg())){
					throw new EventException((String)new ErrorHandler("BKG00353", new String[]{anCustCntCd, anCustSeq}).getMessage());
				}		
				if("Y".equals(mdmCustVO.getBlockFlag())){
					throw new EventException((String)new ErrorHandler("BKG00354", new String[]{anCustCntCd, anCustSeq}).getMessage());
				}
				if(mdmCustVO == null || "Y".equals(mdmCustVO.getExcdCrFlg())){
					throw new EventException((String)new ErrorHandler("BKG08350",new String[]{anCustCntCd+anCustSeq,mdmCustVO.getArOfc(),mdmCustVO.getSrepNm()}).getMessage());
				}
				if(mdmCustVO == null || "Y".equals(mdmCustVO.getNoUseFlg())){
					throw new EventException((String)new ErrorHandler("BKG02004",new String[]{anCustCntCd+anCustSeq,mdmCustVO.getNoUseRsn()}).getMessage());
				}
				alertMsg = utilBC.searchAlertCust(anCustCntCd, anCustSeq);
				if(alertMsg != null && alertMsg.length() > 0){
					alertList.add(alertMsg);
				}						
			}				
			
			String exCustCntCd = blDocCustVO.getExCustCntCd();
			String exCustSeq = blDocCustVO.getExCustSeq();
			if(exCustCntCd != null && exCustCntCd.length() > 0 && exCustSeq != null && exCustSeq.length() > 0){
				mdmCustVO = utilBC.searchMdmCust(exCustCntCd, exCustSeq, "N");
				if("Y".equals(mdmCustVO.getNmdCustFlg())){
					throw new EventException((String)new ErrorHandler("BKG00458").getMessage());
				}
				if("Y".equals(mdmCustVO.getDeltFlg())){
					throw new EventException((String)new ErrorHandler("BKG00353", new String[]{exCustCntCd, exCustSeq}).getMessage());
				}		
				if("Y".equals(mdmCustVO.getBlockFlag())){
					throw new EventException((String)new ErrorHandler("BKG00354", new String[]{exCustCntCd, exCustSeq}).getMessage());
				}
				if(mdmCustVO == null || "Y".equals(mdmCustVO.getExcdCrFlg())){
					throw new EventException((String)new ErrorHandler("BKG08350",new String[]{exCustCntCd+exCustSeq,mdmCustVO.getArOfc(),mdmCustVO.getSrepNm()}).getMessage());
				}
				if(mdmCustVO == null || "Y".equals(mdmCustVO.getNoUseFlg())){
					throw new EventException((String)new ErrorHandler("BKG02004",new String[]{exCustCntCd+exCustSeq,mdmCustVO.getNoUseRsn()}).getMessage());
				}		
				alertMsg = utilBC.searchAlertCust(exCustCntCd, exCustSeq);
				if(alertMsg != null && alertMsg.length() > 0){
					alertList.add(alertMsg);
				}					
			}					
			
			// 13. State가 입력되었을경우 country와 state를 맞게 입력했는지 확인
			String shSteCd = blDocCustVO.getShCustSteCd();
			String shCstmsDeclCntCd = blDocCustVO.getShCstmsDeclCntCd();
			if(shCstmsDeclCntCd != null && shCstmsDeclCntCd.length() > 0 && shSteCd != null && shSteCd.length() > 0){
				if(!dbDao.searchCntVsState(shCstmsDeclCntCd, shSteCd)){
					throw new EventException((String)new ErrorHandler("BKG00355", new String[]{shSteCd, shCstmsDeclCntCd}).getMessage());
				}
			}
			String cnSteCd = blDocCustVO.getCnCustSteCd();
			String cnCstmsDeclCntCd = blDocCustVO.getCnCstmsDeclCntCd();
			if(cnCstmsDeclCntCd != null && cnCstmsDeclCntCd.length() > 0 && cnSteCd != null && cnSteCd.length() > 0){
				if(!dbDao.searchCntVsState(cnCstmsDeclCntCd, cnSteCd)){
					throw new EventException((String)new ErrorHandler("BKG00355", new String[]{cnSteCd, cnCstmsDeclCntCd}).getMessage());
				}
			}	
			String nfSteCd = blDocCustVO.getNfCustSteCd();
			String nfCstmsDeclCntCd = blDocCustVO.getNfCstmsDeclCntCd();
			if(nfCstmsDeclCntCd != null && nfCstmsDeclCntCd.length() > 0 && nfSteCd != null && nfSteCd.length() > 0){
				if(!dbDao.searchCntVsState(nfCstmsDeclCntCd, nfSteCd)){
					throw new EventException((String)new ErrorHandler("BKG00355", new String[]{nfSteCd, nfCstmsDeclCntCd}).getMessage());
				}
			}				
			
			// 15. POD가 'US'인지 확인			
			if(custEtcVO.getPodCd().startsWith("US")){
				// 16. 화주별 입력되야할 P/O No 길이를 조회
				if(shCustCntCd != null && shCustCntCd.length() > 0 && shCustSeq != null && shCustSeq.length() > 0){
					if(utilBC.searchPoNoLengthByDtl(shCustCntCd, shCustSeq, custEtcVO.getScNo(), bkgBlNoVO)){
						throw new EventException((String)new ErrorHandler("BKG00081").getMessage());
					}
				}
				if(cnCustCntCd != null && cnCustCntCd.length() > 0 && cnCustSeq != null && cnCustSeq.length() > 0){
					if(utilBC.searchPoNoLengthByDtl(cnCustCntCd, cnCustSeq, custEtcVO.getScNo(), bkgBlNoVO)){
						throw new EventException((String)new ErrorHandler("BKG00081").getMessage());
					}
				}
				if(nfCustCntCd != null && nfCustCntCd.length() > 0 && nfCustSeq != null && nfCustSeq.length() > 0){
					if(utilBC.searchPoNoLengthByDtl(nfCustCntCd, nfCustSeq, custEtcVO.getScNo(), bkgBlNoVO)){
						throw new EventException((String)new ErrorHandler("BKG00081").getMessage());
					}
				}
				if(ffCustCntCd != null && ffCustCntCd.length() > 0 && ffCustSeq != null && ffCustSeq.length() > 0){
					if(utilBC.searchPoNoLengthByDtl(ffCustCntCd, ffCustSeq, custEtcVO.getScNo(), bkgBlNoVO)){
						throw new EventException((String)new ErrorHandler("BKG00081").getMessage());
					}
				}
				if(anCustCntCd != null && anCustCntCd.length() > 0 && anCustSeq != null && anCustSeq.length() > 0){
					if(utilBC.searchPoNoLengthByDtl(anCustCntCd, anCustSeq, custEtcVO.getScNo(), bkgBlNoVO)){
						throw new EventException((String)new ErrorHandler("BKG00081").getMessage());
					}
				}
				if(exCustCntCd != null && exCustCntCd.length() > 0 && exCustSeq != null && exCustSeq.length() > 0){
					if(utilBC.searchPoNoLengthByDtl(exCustCntCd, exCustSeq, custEtcVO.getScNo(), bkgBlNoVO)){
						throw new EventException((String)new ErrorHandler("BKG00081").getMessage());
					}
				}				
			}
			/*if (blDocCustVO.getCnCustFaxNo() != null && blDocCustVO.getCnCustFaxNo() .length() > 0) {
				if (!utilBC.checkStringFormat("NOT_C", blDocCustVO.getCnCustFaxNo())){
					throw new EventException((String) new ErrorHandler("BKG00651", new String[] { "Consignee Fax No: "+ blDocCustVO.getCnCustFaxNo() }).getMessage());
				}
			}*/
			if (blDocCustVO.getNfCustFaxNo() != null && blDocCustVO.getNfCustFaxNo() .length() > 0) {
				if (!utilBC.checkStringFormat("NOT_C", blDocCustVO.getNfCustFaxNo())){
					throw new EventException((String) new ErrorHandler("BKG00651", new String[] { "Notify Fax No: "+ blDocCustVO.getNfCustFaxNo() }).getMessage());
				}
			}
			if (blDocCustVO.getAnCustFaxNo() != null && blDocCustVO.getAnCustFaxNo() .length() > 0) {
				if (!utilBC.checkStringFormat("NOT_C", blDocCustVO.getAnCustFaxNo())){
					throw new EventException((String) new ErrorHandler("BKG00651", new String[] { "Also Notify Fax No: "+ blDocCustVO.getAnCustFaxNo() }).getMessage());
				}
			}

			// for roterdam
			// T/S Port or Pod, Del이 NL 지역일 때 street, p.o.box, eori# mandatory 추가 			
//			if("Y".equals(utilBC.searchNlFlagByBkg(bkgBlNoVO))){
//				if(blDocCustVO.getShEoriNo()==null || blDocCustVO.getShEoriNo().length()==0){
//					if((blDocCustVO.getShCustCtyNm()==null || blDocCustVO.getShCustCtyNm().length()==0)
//						|| (blDocCustVO.getShCustZipId()==null || blDocCustVO.getShCustZipId().length()==0)
//						|| (blDocCustVO.getShCstmsDeclCntCd()==null || blDocCustVO.getShCstmsDeclCntCd().length()==0)
//						|| (blDocCustVO.getShEurCstmsStNm()==null || blDocCustVO.getShEurCstmsStNm().length()==0)){
//						throw new EventException((String)new ErrorHandler("BKG02063", new String[]{"Shipper"}).getMessage());
//					}
//				}
//
//				if(!"Y".equals(custEtcVO.getCustToOrdFlg())){
//					if(blDocCustVO.getCnEoriNo()==null || blDocCustVO.getCnEoriNo().length()==0){
//						if((blDocCustVO.getCnCustCtyNm()==null || blDocCustVO.getCnCustCtyNm().length()==0)
//							|| (blDocCustVO.getCnCustZipId()==null || blDocCustVO.getCnCustZipId().length()==0)
//							|| (blDocCustVO.getCnCstmsDeclCntCd()==null || blDocCustVO.getCnCstmsDeclCntCd().length()==0)
//							|| (blDocCustVO.getCnEurCstmsStNm()==null || blDocCustVO.getCnEurCstmsStNm().length()==0)){
//							throw new EventException((String)new ErrorHandler("BKG02063", new String[]{"Consignee"}).getMessage());
//						}
//					}
//				} else {
//					if(blDocCustVO.getNfEoriNo()==null || blDocCustVO.getNfEoriNo().length()==0){
//						if((blDocCustVO.getNfCustCtyNm()==null || blDocCustVO.getNfCustCtyNm().length()==0)
//							|| (blDocCustVO.getNfCustZipId()==null || blDocCustVO.getNfCustZipId().length()==0)
//							|| (blDocCustVO.getNfCstmsDeclCntCd()==null || blDocCustVO.getNfCstmsDeclCntCd().length()==0)
//							|| (blDocCustVO.getNfEurCstmsStNm()==null || blDocCustVO.getNfEurCstmsStNm().length()==0)){
//							throw new EventException((String)new ErrorHandler("BKG02063", new String[]{"Notify"}).getMessage());
//						}
//					}
//				}
//			}
			
			// BKG Creation 및 e-BKG 업로드 시에 co_biz 사용 여부 확인
			if ("Y".equalsIgnoreCase(dbDao.searchRepCustFlag(blDocCustVO, bkgBlNoVO.getCaFlg()))) {
				// BKG Creation 및 e-BKG 업로드 시에 아래에서 'Y'가 리턴 될 경우 저장 불가
				// Rep. customer code of HJS office is not valid. please update customer code only.
				throw new EventException((String)new ErrorHandler("BKG02073").getMessage());
			}
			
			// 20130429 (2013508최문환) 추가 - SHPR와 FWRD의 정보를 조회하여 LREP이 coverage team과 일치하는지 validation함.
			BlCustomerInfoVO blCustomerInfoVO = new BlCustomerInfoVO();
			blCustomerInfoVO.setSCustCntCd(blDocCustVO.getShCustCntCd());
			blCustomerInfoVO.setSCustSeq(blDocCustVO.getShCustSeq());
			blCustomerInfoVO.setFCustCntCd(blDocCustVO.getFfCustCntCd());
			blCustomerInfoVO.setFCustSeq(blDocCustVO.getFfCustSeq());
			if(!dbDao.checkCustSrep(blCustomerInfoVO, custEtcVO.getObSrepCd())){
				String obSrepCd = custEtcVO.getObSrepCd();
				String fCustCntCd = blDocCustVO.getFfCustCntCd();
				if(!"US".equals(fCustCntCd)){
					throw new EventException((String)new ErrorHandler("BKG08260", new String[]{obSrepCd,"shipper code or forwarder code"}).getMessage());
				}else{
					throw new EventException((String)new ErrorHandler("BKG08260", new String[]{obSrepCd,"shipper code"}).getMessage());	
				}
			}
			
			
//			//SC로 로직 이동
//			//[CHM-201536074] black list 화주 blocking
//			//[CHM-201537002] 중국 Black list shippr list 중에서 CNEE/ Notify / Also Notify 에 적용되는  blocking  로직 해지 요청 
//			ArrayList <String> custNms = new ArrayList<String>();
//			custNms.add(blDocCustVO.getShCustNm());
//			//custNms.add(blDocCustVO.getCnCustNm());
//			//custNms.add(blDocCustVO.getNfCustNm());
//			custNms.add(blDocCustVO.getFfCustNm());
//			//custNms.add(blDocCustVO.getAnCustNm());
//			custNms.add(blDocCustVO.getExCustNm());
//			for(int i=0; i<custNms.size(); i++){
//				String custNm = (String)custNms.get(i);
//				if(custNm != null && !"".equals(custNm)){
//					// enter 제거, 특수문자->공란, 공란여러개->공란1개
//					custNm = custNm.replace("\r\n", " ").replace("\r", " ").replace("\n", " ");
//					custNm = custNm.replace("~", " ").replace("!", " ").replace("@", " ").replace("#", " ").replace("$", " ").replace("%", " ");
//					custNm = custNm.replace("^", " ").replace("&", " ").replace("*", " ").replace("(", " ").replace(")", " ").replace("_", " ");
//					custNm = custNm.replace("+", " ").replace("`", " ").replace("-", " ").replace("=", " ").replace("{", " ").replace("}", " ");
//					custNm = custNm.replace("|", " ").replace("[", " ").replace("]", " ").replace("\\", " ").replace(":", " ").replace(";", " ");
//					custNm = custNm.replace("\"", " ").replace("'", " ").replace("/", " ").replace("<", " ").replace(">", " ").replace("?", " ");
//					custNm = custNm.replace(",", " ").replace(".", " ");
//					custNm = custNm.replace("  ", " ").replace("  ", " ").replace("  ", " "); 
//					
//					String blockCustName = dbDao.checkBlockCustName(custNm);
//					
//					if(blockCustName != null && !"".equals(blockCustName)){
//						BkgBlckListMntrVO vo = new BkgBlckListMntrVO();
//						vo.setBkgNo(bkgBlNoVO.getBkgNo());
//						vo.setBlckKwNm(blockCustName);
//						vo.setCustDescKwNm(blockCustName);
//						vo.setBlckKwTpCd("BLA");
//						vo.setCreUsrId(account.getUsr_id());
//						vo.setUpdUsrId(account.getUsr_id());
//						utilBC.addBkgBlckListMntr(vo);
//						throw new EventException((String)new ErrorHandler("BKG95087", new String[]{blockCustName}).getMessage());	
//					}
//				}
//			}
			
			if(alertList != null && alertList.size() > 0){
				rtnArr = new String[alertList.size()];
				for(int i = 0 ; i < alertList.size() ; i++){
					rtnArr[i] = (String)alertList.get(i);
				}
			}
		} catch (EventException ex) {
			throw ex;					
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return rtnArr;
	}	

	/**
	 * 화주 정보를 수정한다.(ESM_BKG_007905)<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BlCustomerVO blCustomerVO
	 * @param 		String bkgFlg
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyBlDocCust(BlCustomerVO blCustomerVO, String bkgFlg, SignOnUserAccount account) throws EventException {
		try {			
			BkgBlNoVO bkgBlNoVO = blCustomerVO.getBkgBlNoVO();
			BlDocCustVO blDocCustVO = blCustomerVO.getBlDocCustVO();
			CustEtcVO custEtcVO = blCustomerVO.getCustEtcVO();		
			
			String bkgNo = bkgBlNoVO.getBkgNo();

			BkgCustomerVO bkgCustomerVO = new BkgCustomerVO();
			bkgCustomerVO.setBkgNo(bkgNo);
			bkgCustomerVO.setCreUsrId(account.getUsr_id());
			bkgCustomerVO.setUpdUsrId(account.getUsr_id());	
					
			// Shipper 등록
			bkgCustomerVO.setBkgCustTpCd("S");
			bkgCustomerVO.setCustCntCd(blDocCustVO.getShCustCntCd());
			bkgCustomerVO.setCustSeq(blDocCustVO.getShCustSeq());
			bkgCustomerVO.setCustNm(blDocCustVO.getShCustNm());
			bkgCustomerVO.setCustAddr(blDocCustVO.getShCustAddr());
			bkgCustomerVO.setCustCtyNm(blDocCustVO.getShCustCtyNm());
			bkgCustomerVO.setCustSteCd(blDocCustVO.getShCustSteCd());
			bkgCustomerVO.setCstmsDeclCntCd(blDocCustVO.getShCstmsDeclCntCd());
			bkgCustomerVO.setCustZipId(blDocCustVO.getShCustZipId());
			bkgCustomerVO.setCustFaxNo(blDocCustVO.getShCustFaxNo());
			bkgCustomerVO.setCustEml(blDocCustVO.getShCustEml());
			bkgCustomerVO.setCustPhnNo(blDocCustVO.getShCustPhnNo());
			bkgCustomerVO.setCustTpCd(blDocCustVO.getShCustTp());
			bkgCustomerVO.setAddrPrnFlg(blDocCustVO.getShAddrPrnFlg());
			bkgCustomerVO.setEurCstmsStNm(blDocCustVO.getShEurCstmsStNm());
			bkgCustomerVO.setEoriNo(blDocCustVO.getShEoriNo());	
			bkgCustomerVO.setEndUsrNm(blDocCustVO.getEndUsrNm());
			dbDao.modifyBkgCustomer(bkgCustomerVO, bkgBlNoVO);	
			
			// Consignee 등록
			bkgCustomerVO.setBkgCustTpCd("C");
			bkgCustomerVO.setCustCntCd(blDocCustVO.getCnCustCntCd());
			bkgCustomerVO.setCustSeq(blDocCustVO.getCnCustSeq());
			bkgCustomerVO.setCustNm(blDocCustVO.getCnCustNm());
			bkgCustomerVO.setCustAddr(blDocCustVO.getCnCustAddr());
			bkgCustomerVO.setCustCtyNm(blDocCustVO.getCnCustCtyNm());
			bkgCustomerVO.setCustSteCd(blDocCustVO.getCnCustSteCd());
			bkgCustomerVO.setCstmsDeclCntCd(blDocCustVO.getCnCstmsDeclCntCd());
			bkgCustomerVO.setCustZipId(blDocCustVO.getCnCustZipId());
			bkgCustomerVO.setCustFaxNo(blDocCustVO.getCnCustFaxNo());
			bkgCustomerVO.setCustEml(blDocCustVO.getCnCustEml());
			bkgCustomerVO.setCustPhnNo(blDocCustVO.getCnCustPhnNo());
			bkgCustomerVO.setCustTpCd(blDocCustVO.getCnCustTp());
			bkgCustomerVO.setAddrPrnFlg(blDocCustVO.getCnAddrPrnFlg());	
			bkgCustomerVO.setEurCstmsStNm(blDocCustVO.getCnEurCstmsStNm());
			bkgCustomerVO.setEoriNo(blDocCustVO.getCnEoriNo());		
			bkgCustomerVO.setEndUsrNm("");
			if (blDocCustVO.getCnEoriNo() != null && !"".equals(blDocCustVO.getCnEoriNo())) {
				bkgCustomerVO.setCoChnTpCd(blDocCustVO.getCnCoChnTpCd());
			} else {
				bkgCustomerVO.setCoChnTpCd("");
			}
			dbDao.modifyBkgCustomer(bkgCustomerVO, bkgBlNoVO);
			
			// Notify 등록
			bkgCustomerVO.setBkgCustTpCd("N");
			bkgCustomerVO.setCustCntCd(blDocCustVO.getNfCustCntCd());
			bkgCustomerVO.setCustSeq(blDocCustVO.getNfCustSeq());
			bkgCustomerVO.setCustNm(blDocCustVO.getNfCustNm());
			bkgCustomerVO.setCustAddr(blDocCustVO.getNfCustAddr());
			bkgCustomerVO.setCustCtyNm(blDocCustVO.getNfCustCtyNm());
			bkgCustomerVO.setCustSteCd(blDocCustVO.getNfCustSteCd());
			bkgCustomerVO.setCstmsDeclCntCd(blDocCustVO.getNfCstmsDeclCntCd());
			bkgCustomerVO.setCustZipId(blDocCustVO.getNfCustZipId());
			bkgCustomerVO.setCustFaxNo(blDocCustVO.getNfCustFaxNo());
			bkgCustomerVO.setCustEml(blDocCustVO.getNfCustEml());
			bkgCustomerVO.setCustPhnNo(blDocCustVO.getNfCustPhnNo());
			bkgCustomerVO.setCustTpCd(blDocCustVO.getNfCustTp());
			bkgCustomerVO.setAddrPrnFlg(blDocCustVO.getNfAddrPrnFlg());	
			bkgCustomerVO.setEurCstmsStNm(blDocCustVO.getNfEurCstmsStNm());
			bkgCustomerVO.setEoriNo(blDocCustVO.getNfEoriNo());		
			bkgCustomerVO.setEndUsrNm("");
			if (blDocCustVO.getNfEoriNo() != null && !"".equals(blDocCustVO.getNfEoriNo())) {
				bkgCustomerVO.setCoChnTpCd(blDocCustVO.getNfCoChnTpCd());
			} else {
				bkgCustomerVO.setCoChnTpCd("");
			}
			if(dbDao.modifyBkgCustomer(bkgCustomerVO, bkgBlNoVO) < 1){
				dbDao.addBkgCustomer(bkgCustomerVO, bkgBlNoVO);
			}
			
			bkgCustomerVO.setCustPhnNo("");
			
			// Forward 등록
			bkgCustomerVO.setBkgCustTpCd("F");
			bkgCustomerVO.setCustCntCd(blDocCustVO.getFfCustCntCd());
			bkgCustomerVO.setCustSeq(blDocCustVO.getFfCustSeq());
			bkgCustomerVO.setCustNm(blDocCustVO.getFfCustNm());
			bkgCustomerVO.setCustAddr("");
			bkgCustomerVO.setCustCtyNm("");
			bkgCustomerVO.setCustSteCd("");
			bkgCustomerVO.setCstmsDeclCntCd("");
			bkgCustomerVO.setCustZipId("");
			bkgCustomerVO.setCustFaxNo("");
			bkgCustomerVO.setCustEml("");
			bkgCustomerVO.setCustTpCd("");
			bkgCustomerVO.setEurCstmsStNm("");
			bkgCustomerVO.setEoriNo("");
			bkgCustomerVO.setAddrPrnFlg(blDocCustVO.getFfAddrPrnFlg());	
			bkgCustomerVO.setEndUsrNm("");
			bkgCustomerVO.setCoChnTpCd("");
			if(dbDao.modifyBkgCustomer(bkgCustomerVO, bkgBlNoVO) < 1){
				dbDao.addBkgCustomer(bkgCustomerVO, bkgBlNoVO);
			}	
			
			// A/Notify 등록
			bkgCustomerVO.setBkgCustTpCd("A");
			bkgCustomerVO.setCustCntCd(blDocCustVO.getAnCustCntCd());
			bkgCustomerVO.setCustSeq(blDocCustVO.getAnCustSeq());
			bkgCustomerVO.setCustNm(blDocCustVO.getAnCustNm());
			bkgCustomerVO.setCustAddr("");
			bkgCustomerVO.setCustCtyNm("");
			bkgCustomerVO.setCustSteCd("");
			bkgCustomerVO.setCstmsDeclCntCd("");
			bkgCustomerVO.setCustZipId("");
			bkgCustomerVO.setCustFaxNo(blDocCustVO.getAnCustFaxNo());
			bkgCustomerVO.setCustEml(blDocCustVO.getAnCustEml());
			bkgCustomerVO.setCustTpCd(blDocCustVO.getAnCustTp());
			bkgCustomerVO.setEurCstmsStNm("");
			bkgCustomerVO.setEoriNo("");
			bkgCustomerVO.setAddrPrnFlg(blDocCustVO.getAnAddrPrnFlg());	
			bkgCustomerVO.setEndUsrNm("");
			bkgCustomerVO.setCoChnTpCd("");
			if(dbDao.modifyBkgCustomer(bkgCustomerVO, bkgBlNoVO) < 1){
				dbDao.addBkgCustomer(bkgCustomerVO, bkgBlNoVO);
			}	
			
			// Export 등록
			bkgCustomerVO.setBkgCustTpCd("E");
			bkgCustomerVO.setCustCntCd(blDocCustVO.getExCustCntCd());
			bkgCustomerVO.setCustSeq(blDocCustVO.getExCustSeq());
			bkgCustomerVO.setCustNm(blDocCustVO.getExCustNm());
			bkgCustomerVO.setCustAddr("");
			bkgCustomerVO.setCustCtyNm("");
			bkgCustomerVO.setCustSteCd("");
			bkgCustomerVO.setCstmsDeclCntCd("");
			bkgCustomerVO.setCustZipId("");
			bkgCustomerVO.setCustFaxNo("");
			bkgCustomerVO.setCustEml("");
			bkgCustomerVO.setCustTpCd("");
			bkgCustomerVO.setEurCstmsStNm("");
			bkgCustomerVO.setEoriNo("");
			bkgCustomerVO.setAddrPrnFlg(blDocCustVO.getExAddrPrnFlg());	
			bkgCustomerVO.setEndUsrNm("");
			bkgCustomerVO.setCoChnTpCd("");
			if(dbDao.modifyBkgCustomer(bkgCustomerVO, bkgBlNoVO) < 1){
				dbDao.addBkgCustomer(bkgCustomerVO, bkgBlNoVO);
			}			
			
			// [SRM-201551910] 계약 No 와 Acustomer 코드 조건이 만날때 하단 EDI Ref.가 자동으로 입력되어 Cargo tracking EDI 전송 요청
			dbDao.modifyExCustByActCust(bkgBlNoVO);
			// Philips 계약조건이 맞는경우 EDI Ref.가 존재하지 않을 때 특정 Customer code로 지정
			dbDao.modifyExCustByCtrt(bkgBlNoVO,"PHILIPS_CONTRACT");
			 
			// BKG Reference 저장
			BkgReferenceVO bkgReferenceVO = new BkgReferenceVO();
			bkgReferenceVO.setBkgNo(bkgBlNoVO.getBkgNo());
			bkgReferenceVO.setCreUsrId(account.getUsr_id());
			bkgReferenceVO.setUpdUsrId(account.getUsr_id());
			
			if("E".equals(bkgFlg)){
				// E-Booking에서 호출한 경우
				bkgCustomerVO.setBkgCustTpCd("B");
//				if(blDocCustVO.getExCustCntCd() != null){
//					if(blDocCustVO.getExCustCntCd().length() > 2){
//						bkgCustomerVO.setCustCntCd(blDocCustVO.getBrCustCntCd().substring(0,2));
//						bkgCustomerVO.setCustSeq(blDocCustVO.getBrCustCntCd().substring(2));
//					}
//				}
				bkgCustomerVO.setCustNm(blDocCustVO.getBrCustNm());
				bkgCustomerVO.setCustAddr(blDocCustVO.getBrCustAddr());
				//add jsy 2011.11.03
				bkgCustomerVO.setCustCntCd("");
				bkgCustomerVO.setCustSeq("");
								
				bkgCustomerVO.setCustCtyNm("");
				bkgCustomerVO.setCustSteCd("");
				bkgCustomerVO.setCstmsDeclCntCd("");
				bkgCustomerVO.setCustZipId("");
				bkgCustomerVO.setCustFaxNo("");
				bkgCustomerVO.setCustEml("");
				bkgCustomerVO.setCustTpCd("");
				bkgCustomerVO.setAddrPrnFlg("");						
				if(dbDao.modifyBkgCustomer(bkgCustomerVO, bkgBlNoVO) < 1){
					dbDao.addBkgCustomer(bkgCustomerVO, bkgBlNoVO);
				}			
					// Pan Code 등록함.	
				if(blDocCustVO.getBrCustCntCd()!= null ||blDocCustVO.getBrCustCntCd().length() > 0){
					bkgReferenceVO.setBkgRefTpCd("BRKN");
					bkgReferenceVO.setCustRefNoCtnt(blDocCustVO.getBrCustCntCd());					
					if(dbDao.modifyBkgReference(bkgReferenceVO, bkgBlNoVO) < 1){
						dbDao.addBkgReference(bkgReferenceVO, bkgBlNoVO);
					}
				}
			}			
			
			// bkg_booking에 저장되는 부분을 처리한다.
			custEtcVO.setBkgNo(bkgNo);
			dbDao.modifyBkgBookingByCust(custEtcVO, bkgBlNoVO, account);
			
			// IRAN이 POR, POL, POD, DEL일 경우 Order B/L인 상태로 저장할 수 없다
//			BookingUtil util = new BookingUtil();
//			util.searchIranToOrdBl(bkgBlNoVO);
			
			// 계약 관련 정보를 update한다
//			dbDao.modifyCtrtInfo(bkgBlNoVO);
//			String ctrtOfcCd = bkgBookingInfoVO.getCtrtOfcCd();
//			String ctrtSrepCd = bkgBookingInfoVO.getCtrtSrepCd();
//			String orgBkgNo = bkgBookingInfoVO.getBkgNo();
//			log.debug("\n *********************" +
//					"\n ctrtOfcCd:"+ctrtOfcCd +
//					"\n ctrtSrepCd:"+ctrtSrepCd);
//			if( ctrtOfcCd != null && ctrtSrepCd != null && ctrtOfcCd.length() >0 && ctrtSrepCd.length()>0 ) {				
				dbDao.modifyChangedCtrtInfo(bkgBlNoVO, "", "", bkgNo);  //2011.10.14 jsy
//			}
						
			// FF_REF_NO 등록			
			bkgReferenceVO.setBkgRefTpCd("FFNO");
			bkgReferenceVO.setCustRefNoCtnt(custEtcVO.getFfRefNo());			
			if(dbDao.modifyBkgReference(bkgReferenceVO, bkgBlNoVO) < 1){
				dbDao.addBkgReference(bkgReferenceVO, bkgBlNoVO);
			}
			
			// FMC_cD 등록
			bkgReferenceVO.setBkgRefTpCd("FMCN");
			bkgReferenceVO.setCustRefNoCtnt(custEtcVO.getFmcCd());			
			if(dbDao.modifyBkgReference(bkgReferenceVO, bkgBlNoVO) < 1){
				dbDao.addBkgReference(bkgReferenceVO, bkgBlNoVO);
			}				

			ScListInputVO scListInputVO = new ScListInputVO();
			scListInputVO.setBkgNo(bkgBlNoVO.getBkgNo());
			if(dbDao.validateScCtrtPtyTp(scListInputVO, bkgBlNoVO.getCaFlg()) > 0){
				throw new EventException((String)new ErrorHandler("BKG08267").getMessage());
			}
			
		} catch (EventException ex) {
			throw ex;					
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	
	
	/**
	 * ANCS, ROCS에서 저장된 Inbound Notify 정보를 수정한다.(ESM_BKG_0045, 0442)<br>
	 * 
	 * @author 		Jang Jiyoung
	 * @param 		String bkgNo
	 * @param 		String notifyNm
	 * @param 		String notifyAddr
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyIbCustNmAddr(String bkgNo, String notifyNm, String notifyAddr, SignOnUserAccount account) throws EventException {
		try {
			
			//BkgBlNoVO bkgBlNoVO = blCustomerVO.getBkgBlNoVO();
			//BlDocCustVO blDocCustVO = blCustomerVO.getBlDocCustVO();	

			BkgCustomerVO bkgCustomerVO = new BkgCustomerVO();
			bkgCustomerVO.setBkgNo(bkgNo);
			bkgCustomerVO.setCreUsrId(account.getUsr_id());
			bkgCustomerVO.setUpdUsrId(account.getUsr_id());	

			bkgCustomerVO.setCustNm(notifyNm);
			bkgCustomerVO.setCustAddr(notifyAddr);
			
			dbDao.modifyIbCustNmAddr(bkgCustomerVO);

		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * Cargo Detail Information 조회.<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return			CargoDetailVO
	 * @exception 	EventException
	 */
	public CargoDetailVO searchCargoDetail(BkgBlNoVO bkgBlNoVO) throws EventException {
		CargoDetailVO cargoDetailVO = new CargoDetailVO();
		try {
			cargoDetailVO.setBkgQtyDtl(dbDao.searchBkgQtyDtl(bkgBlNoVO));
			cargoDetailVO.setBkgQuantity(dbDao.searchBkgQuantity(bkgBlNoVO));
			cargoDetailVO.setCargoDtlEtcVO(dbDao.searchCargoDtlEtc(bkgBlNoVO));			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return cargoDetailVO;
	}	


	/**
	 * BkgQtyDtl 정보를 저장한다.<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BkgQtyDtlVO[] bkgQtyDtlVOs
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void manageBkgQtyDtl(BkgQtyDtlVO[] bkgQtyDtlVOs, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {
		try {
			// 01. BkgQtyDtl 를 전체 삭제한다.
			dbDao.removeBkgQtyDtl(bkgBlNoVO, null);
			
			// 02. 화면에 입력된 정보를 저장한다.
			if(bkgQtyDtlVOs != null){
				for(int i = 0 ; i < bkgQtyDtlVOs.length ; i++){
					BkgQtyDtlVO bkgQtyDtlVO = bkgQtyDtlVOs[i];
					if("Y".equals(bkgQtyDtlVO.getAwkCgoFlg()) || "1".equals(bkgQtyDtlVO.getAwkCgoFlg())){
						bkgQtyDtlVO.setAwkCgoFlg("Y");
					}else{
						bkgQtyDtlVO.setAwkCgoFlg("N");
					}
					if("Y".equals(bkgQtyDtlVO.getDcgoFlg()) || "1".equals(bkgQtyDtlVO.getDcgoFlg())){
						bkgQtyDtlVO.setDcgoFlg("Y");
					}else{
						bkgQtyDtlVO.setDcgoFlg("N");
					}			
					
					if("Y".equals(bkgQtyDtlVO.getRcFlg()) || "1".equals(bkgQtyDtlVO.getRcFlg())){
						bkgQtyDtlVO.setRcFlg("Y");
					}else{
						bkgQtyDtlVO.setRcFlg("N");
					}		
					if("Y".equals(bkgQtyDtlVO.getBbCgoFlg()) || "1".equals(bkgQtyDtlVO.getBbCgoFlg())){
						bkgQtyDtlVO.setBbCgoFlg("Y");
					}else{
						bkgQtyDtlVO.setBbCgoFlg("N");
					}		
					if("Y".equals(bkgQtyDtlVO.getSocFlg()) || "1".equals(bkgQtyDtlVO.getSocFlg())){
						bkgQtyDtlVO.setSocFlg("Y");
					}else{
						bkgQtyDtlVO.setSocFlg("N");
					}		
					if("Y".equals(bkgQtyDtlVO.getCrrHngrSglBarUseFlg()) || "1".equals(bkgQtyDtlVO.getCrrHngrSglBarUseFlg())){
						bkgQtyDtlVO.setCrrHngrSglBarUseFlg("Y");
					}else{
						bkgQtyDtlVO.setCrrHngrSglBarUseFlg("N");
					}		
					if("Y".equals(bkgQtyDtlVO.getCrrHngrDblBarUseFlg()) || "1".equals(bkgQtyDtlVO.getCrrHngrDblBarUseFlg())){
						bkgQtyDtlVO.setCrrHngrDblBarUseFlg("Y");
					}else{
						bkgQtyDtlVO.setCrrHngrDblBarUseFlg("N");
					}		
					if("Y".equals(bkgQtyDtlVO.getCrrHngrTplBarUseFlg()) || "1".equals(bkgQtyDtlVO.getCrrHngrTplBarUseFlg())){
						bkgQtyDtlVO.setCrrHngrTplBarUseFlg("Y");
					}else{
						bkgQtyDtlVO.setCrrHngrTplBarUseFlg("N");
					}		
					if("Y".equals(bkgQtyDtlVO.getDryCgoFlg()) || "1".equals(bkgQtyDtlVO.getDryCgoFlg())){
						bkgQtyDtlVO.setDryCgoFlg("Y");
					}else{
						bkgQtyDtlVO.setDryCgoFlg("N");
					}		
					if("Y".equals(bkgQtyDtlVO.getMerHngrFlg()) || "1".equals(bkgQtyDtlVO.getMerHngrFlg())){
						bkgQtyDtlVO.setMerHngrFlg("Y");
					}else{
						bkgQtyDtlVO.setMerHngrFlg("N");
					}								
					bkgQtyDtlVO.setBkgNo(bkgBlNoVO.getBkgNo());
					bkgQtyDtlVO.setCreUsrId(account.getUsr_id());
					bkgQtyDtlVO.setUpdUsrId(account.getUsr_id());
					
					dbDao.addBkgQtyDtl(bkgQtyDtlVO, bkgBlNoVO);
				}
			}		
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	
	
	/**
	 * bkg_cod에서 bkg_booking으로 t/vvd, pod, pod_node, del, del_node를 update한다.<br>
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param BkgBlNoVO codBkg 
	 * @param String codRqstSeq
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyBookingFromCod (BkgBlNoVO bkgBlNoVO, BkgBlNoVO codBkg, String codRqstSeq, SignOnUserAccount account ) throws EventException{
		try {
			if(bkgBlNoVO.getPctlNo()==null){
				dbDao.removeBkgVvd(bkgBlNoVO);
				dbDao.modifyBkgVvdFromCod(codRqstSeq, bkgBlNoVO, account);
				dbDao.modifyBkgBookingFromCod(codRqstSeq, bkgBlNoVO, account);
			} else {
				log.debug("bkg_no:"+bkgBlNoVO.getBkgNo()+",pctl_no:"+bkgBlNoVO.getPctlNo());
				dbDao.modifyBkgRouteFromPrd(bkgBlNoVO, "U");			
				dbDao.removeBkgVvd(bkgBlNoVO);
				dbDao.addBkgVvdFromPrd(bkgBlNoVO, dbDao.searchTrunkVvdByBkg(bkgBlNoVO), account);
				// pct 조회 	2012.02.24 kbj
				String pct = dbDao.searchPct(bkgBlNoVO.getBkgNo(), "N");
				//pct update 2012.02.24 kbj
				dbDao.modifyPct(bkgBlNoVO, pct);
			}
			if (0==dbDao.searchBkgVvd(bkgBlNoVO).size()) {
				throw new EventException(new ErrorHandler("BKG02072").getMessage());
			}
			BkgForDstSvcRouteVO bkgForDstSvcRouteVO =dbDao.searchBkgForDstSvcRoute(bkgBlNoVO);
			String dstSvcRouteCd=dbDao.searchDstSvcRoute( bkgForDstSvcRouteVO.getPodCd(), bkgForDstSvcRouteVO.getDelCd(),bkgForDstSvcRouteVO.getPreRlyPortCd(),
			                   bkgForDstSvcRouteVO.getSkdDirCd(), bkgForDstSvcRouteVO.getSlanCd() , bkgForDstSvcRouteVO.getOcpCd());
			dbDao.modifyDstSvcRoute(dstSvcRouteCd, bkgBlNoVO, codBkg, codRqstSeq);
			
			
			
		} catch (EventException ee) {
			throw ee;
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * 1. Combine에서 Qty와 Qty Dtl 내용을 Master Bkg로 합한다.<br>
	 * 2. bkg_reference의 내용을 Master Bkg로 합한다.<br>
	 * 3. Master Bkg 이외의 상태Flag를 X로 변경한다.<br>
	 * 
	 * @author Jun Yong Jin
	 * @param BkgBlNoVO[] sourceBkg
	 * @param BkgBlNoVO targetBkg
	 * @param String hitchmentYn
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void combineQty(BkgBlNoVO[] sourceBkg , BkgBlNoVO targetBkg, String hitchmentYn ,SignOnUserAccount account) throws EventException{
		try {
			List<BkgQuantityVO> bkgQuantityVOs = null;
			List<BkgQtyDtlVO> bkgQtyDtlVOs = null;

			if ( sourceBkg != null ) {
				// 01. Master Bkg에 Bkg Quantity, Dtl 데이터 조회
				bkgQuantityVOs = dbDao.combineBkgQty(sourceBkg, targetBkg);
				bkgQtyDtlVOs = dbDao.combineBkgQtyDtl(sourceBkg, targetBkg);

				// 02. Master Bkg의 Bkg Quantity, Dtl 데이터 삭제
				dbDao.removeBkgQtyDtl(targetBkg, null);
				dbDao.removeBkgQuantity(null, targetBkg, "BKG");

				// 03. Master Bkg에 Bkg Quantity 입력
				if ( bkgQuantityVOs != null ) {
					for(int i = 0 ; i < bkgQuantityVOs.size() ; i++){
						BkgQuantityVO bkgQuantityVO = bkgQuantityVOs.get(i);
						bkgQuantityVO.setCreUsrId(account.getUsr_id());
						bkgQuantityVO.setUpdUsrId(account.getUsr_id());
						dbDao.addBkgQuantity(bkgQuantityVO, targetBkg);
					}
				}

				// 04. Master Bkg에 Bkg Qty Dtl 입력
				if( bkgQtyDtlVOs != null ){
					for(int j = 0 ; j < bkgQtyDtlVOs.size() ; j++){
						BkgQtyDtlVO bkgQtyDtlVO = bkgQtyDtlVOs.get(j);
						bkgQtyDtlVO.setCreUsrId(account.getUsr_id());
						bkgQtyDtlVO.setUpdUsrId(account.getUsr_id());

						dbDao.addBkgQtyDtl(bkgQtyDtlVO, targetBkg);
					}
				}				

				// 05. Master Bkg에 Bkg_reference 입력
				copyBkgRefByBkg("M", sourceBkg, targetBkg , null, account);

				// 06. Master Bkg 이외의 Bkg 상태값 변경
				//logic 변경 r/d term, wait reason도 재계산함
				dbDao.modifyBkgBookingAfterCombine(targetBkg, sourceBkg, account);
				
				for (int i=0;i<sourceBkg.length;i++) {
					dbDao.modifyBookingStatus("N","N", "X", sourceBkg[i], account);
					dbDao.modifyToBkgNo(targetBkg, sourceBkg[i], hitchmentYn, account);
				}
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * 1. Source Bkg의 bkg_referenece를 Target Bkg로 복사한다.<br>
	 * 
	 * @author Jun Yong Jin
	 * @param String copyModeCd
	 * @param BkgBlNoVO[] sourceBkg
	 * @param BkgBlNoVO targetBkg
	 * @param String[] cntrNo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyBkgRefByBkg(String copyModeCd, BkgBlNoVO[] sourceBkg, BkgBlNoVO targetBkg , String[] cntrNo, SignOnUserAccount account) throws EventException{
		try {
			BookingUtil utilBC = new BookingUtil();

			if ( sourceBkg != null ) {
				for (int i=0;i<sourceBkg.length;i++) {
					if ( "M".equals(copyModeCd) ) {
						cntrNo = utilBC.searchCntrListByBkg(sourceBkg[i]);
					}
					for (int j=0;j<cntrNo.length;j++) {
						dbDao.copyBkgRefByBkg(cntrNo[j], sourceBkg[i], targetBkg, account);
	    				dbDao.copyBkgRefDtlByBkg(cntrNo[j], sourceBkg[i], targetBkg, account);
					}
					dbDao.copyNVOFileNoByBkg(sourceBkg[i], targetBkg, account);
				}
			}
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

    /**
     * Bkg의 bkg_referenece를 Target Bkg로 복사한다.<br>
     * 
	 * @author 		Ryu Daeyoung
     * @param 		cntrCopyVO
	 * @exception 	EventException
     */
    public void copyBkgRefByCntr(CntrCopyVO cntrCopyVO) throws EventException {
        try {
            dbDao.copyBkgRefByCntr(cntrCopyVO);
            dbDao.copyBkgRefDtlByCntr(cntrCopyVO);
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
    
    /**
     * Bkg의 bkg_referenece, bkg_ref_dtl을 cntr별로 삭제한다.<br>
     * 
	 * @author 		Ryu Daeyoung
     * @param 		String bkgNo
     * @param 		String cntrNo
     * @param 		String seq
	 * @exception 	EventException
     */
    public void removeBkgRefByCntr(String bkgNo, String cntrNo, String seq) throws EventException{
        try {
            dbDao.removeBkgRefByCntr(bkgNo, cntrNo, seq);
            dbDao.removeBkgRefDtlByCntr(bkgNo, cntrNo, seq);
        } catch(DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Bkg의 bkg_referenece을 cntr별로 삭제한다.<br>
     * 
	 * @author 		Ryu Daeyoung
     * @param 		String bkgNo
     * @param 		String cntrNo
     * @param 		String caFlg
	 * @exception 	EventException
     */
    public void removeReferenceByCntr(String bkgNo, String cntrNo, String caFlg) throws EventException {
        try {
            dbDao.removeBkgRefByCntr(bkgNo, cntrNo, caFlg);
        } catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

    /**
     * Bkg의 bkg_ref_dtl을 cntr별로 삭제한다.<br>
     * 
	 * @author 		Ryu Daeyoung
     * @param 		String bkgNo
     * @param 		String cntrNo
     * @param 		String caFlg
	 * @exception 	EventException
     */
    public void removeReferenceDetailByCntr(String bkgNo, String cntrNo, String caFlg) throws EventException {
        try {
            dbDao.removeBkgRefDtlByCntr(bkgNo, cntrNo, caFlg);
        } catch (DAOException ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }

	/**
	 * customer 정보를 원본 bkg 로부터 복사한다.<br>
	 * @param BlCopyInVO blCopyInVo
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void copyCustByBlCopy(BlCopyInVO blCopyInVo, SignOnUserAccount account) throws EventException {
		try {
			  dbDao.copyCustByBlCopy(blCopyInVo, account);
			  dbDao.copyBkgByBlCopy(blCopyInVo, account);
			  dbDao.copyRefByBlCopy(blCopyInVo, account);
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * Partial container를 사용하는 Booking들의 route를 한번에 변경하기위해 참고 data를 조회한다..<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return		PartialBkgVO
	 * @exception 	EventException
	 */
	public PartialBkgVO searchPartialCntrBkg(BkgBlNoVO bkgBlNoVO) throws EventException {
		PartialBkgVO partialBkgVO = new PartialBkgVO();
		try {
			List<String> bkgNoList = dbDao.searchPartialCntrBkgList(bkgBlNoVO.getBkgNo());
			List<String> cntrNoList = dbDao.searchPartialCntrListByBkgList(bkgNoList);
			DBRowSet partialBkgCntrRS = dbDao.searchPartialRelatedBkgCntr(bkgNoList, cntrNoList);
			
			List<PartialBkgInfoVO> partialBkgInfo = new ArrayList<PartialBkgInfoVO>(); 
			if(bkgNoList != null && bkgNoList.size() > 0){
				for(int i = 0 ; i < bkgNoList.size() ; i++){
					if(!bkgNoList.get(i).equals(bkgBlNoVO.getBkgNo())){
						partialBkgInfo.add(dbDao.searchPartialCntrBkgInfo(bkgNoList.get(i)));	
					}					
				}
			}
			partialBkgVO.setCntrNoList(cntrNoList);
			partialBkgVO.setPartialBkgCntrRS(partialBkgCntrRS);
			partialBkgVO.setPartialBkgInfo(partialBkgInfo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return partialBkgVO;
	}	

	/**
	 * Booking의 orgin, dest route를 update한다.<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		PartialBkgInfoVO partialBkgInfoVO
	 * @param 		VslSkdVO[] vslSkdVOs
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyBkgRouteForPartialBkg(PartialBkgInfoVO partialBkgInfoVO, VslSkdVO[] vslSkdVOs, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {
		try {
			BookingUtil utilBC = new BookingUtil();

			String trnkLaneCd = utilBC.searchSvcLaneByVvd(partialBkgInfoVO.getBkgTrunkVvd());
			
			if(bkgBlNoVO.getPctlNo()!= null){
				dbDao.modifyBkgRouteFromPrd(bkgBlNoVO, "U");
				dbDao.removeBkgVvd(bkgBlNoVO);
				dbDao.addBkgVvdFromPrd(bkgBlNoVO, null, account);
				
				// pct 조회 	2012.02.24 kbj
				String pct = dbDao.searchPct(bkgBlNoVO.getBkgNo(), "N");
				
				//pct update 2012.02.24 kbj
				dbDao.modifyPct(bkgBlNoVO, pct);
				
			} else {				
				// 16. removeBkgVvd
				dbDao.removeBkgVvd(bkgBlNoVO);		

				// 15. modifyTrnkVvdLane
				dbDao.modifyTrnkVvdLane(partialBkgInfoVO.getBkgTrunkVvd(), trnkLaneCd, partialBkgInfoVO.getPreRlyPortCd(), partialBkgInfoVO.getPstRlyPortCd(), bkgBlNoVO, account);
				
				// 17. addBkgVvd
				for(int i = 0 ; i < vslSkdVOs.length ; i++){
					BkgVvdVO bkgVvdVO = new BkgVvdVO();
					bkgVvdVO.setBkgNo(bkgBlNoVO.getBkgNo());
					bkgVvdVO.setVslPrePstCd(vslSkdVOs[i].getVslPrePstCd());
					bkgVvdVO.setVslSeq(vslSkdVOs[i].getVslSeq());
					if(vslSkdVOs[i].getBkgVvdCd() != null && vslSkdVOs[i].getBkgVvdCd().length() == 9){
						bkgVvdVO.setVslCd(vslSkdVOs[i].getBkgVvdCd().substring(0,4));
						bkgVvdVO.setSkdVoyNo(vslSkdVOs[i].getBkgVvdCd().substring(4,8));
						bkgVvdVO.setSkdDirCd(vslSkdVOs[i].getBkgVvdCd().substring(8,9));
					}
					bkgVvdVO.setPolClptIndSeq(vslSkdVOs[i].getPolClptIndSeq());
					bkgVvdVO.setPodClptIndSeq(vslSkdVOs[i].getPodClptIndSeq());
					bkgVvdVO.setPolCd(vslSkdVOs[i].getPolCd());
					if(vslSkdVOs[i].getPolYdCd() != null && vslSkdVOs[i].getPolYdCd().length() > 0){
						bkgVvdVO.setPolYdCd(vslSkdVOs[i].getPolCd()+vslSkdVOs[i].getPolYdCd());	
					}	
					bkgVvdVO.setPodCd(vslSkdVOs[i].getPodCd());
					if(vslSkdVOs[i].getPodYdCd() != null &&vslSkdVOs[i].getPodYdCd().length() > 0){
						bkgVvdVO.setPodYdCd(vslSkdVOs[i].getPodCd()+vslSkdVOs[i].getPodYdCd());	
					}		
					bkgVvdVO.setCreUsrId(account.getUsr_id());
					bkgVvdVO.setUpdUsrId(account.getUsr_id());
					
					dbDao.addBkgVvd(bkgVvdVO, bkgBlNoVO);										
				}
			}			
			
			log.debug(" ***** BC : " + partialBkgInfoVO.getBkgNo() + "/" +  partialBkgInfoVO.getRcvTermCd() + "/" + partialBkgInfoVO.getOrg());
			if("Y".equals(partialBkgInfoVO.getOrg())){
				String orgSvcMode =  dbDao.searchOrgSvcRoute(trnkLaneCd, partialBkgInfoVO.getBkgTrunkVvd().substring(8,9), partialBkgInfoVO.getPorCd(), partialBkgInfoVO.getPolCd(), partialBkgInfoVO.getPreRlyPortCd());
				partialBkgInfoVO.setOrgTrnsSvcModCd(orgSvcMode);
				
				dbDao.modifyOrgRouteForPartialBkg(partialBkgInfoVO, account);
			}
			
			if("Y".equals(partialBkgInfoVO.getDest())){
				String destSvcMode = dbDao.searchDstSvcRoute(trnkLaneCd, partialBkgInfoVO.getBkgTrunkVvd().substring(8,9), partialBkgInfoVO.getPodCd(), partialBkgInfoVO.getDelCd(), partialBkgInfoVO.getPstRlyPortCd(), partialBkgInfoVO.getOcpCd());
				partialBkgInfoVO.setDestTrnsSvcModCd(destSvcMode);
				
				dbDao.modifyDestRouteForPartialBkg(partialBkgInfoVO, account);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	

	/**
	 * C/A를 위해 booking 관련 table을 복사한다.<br>
	 * @author 		Lee NamKyung
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String copyTypeCd
	 * @exception 	EventException
	 */
	public void createBookingCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException {
		try {
			if ("BKG".equals(copyTypeCd)) {
				//01. 
				dbDao.modifyBkgCA     (bkgBlNoVO, copyTypeCd);
				//02. 
				dbDao.removeCustCA    (bkgBlNoVO, copyTypeCd);
				//03. 
				dbDao.removeQtyDtlCA  (bkgBlNoVO, copyTypeCd);
				//04.  
				dbDao.removeQtyCA     (bkgBlNoVO, copyTypeCd);
				//05. 
				dbDao.removeRefCA     (bkgBlNoVO, copyTypeCd);
				//06. 
				dbDao.removeRefDtlCA  (bkgBlNoVO, copyTypeCd);
				//07. 
				dbDao.removeVvdCA     (bkgBlNoVO, copyTypeCd);
				//08. 
				dbDao.removeCntcPsonCA(bkgBlNoVO, copyTypeCd);
				//09. 
				dbDao.removeNVOFilerCA(bkgBlNoVO, copyTypeCd);
			} else {
				//01. 
				dbDao.createBkgCA(bkgBlNoVO, copyTypeCd);
			}

			//02. 
			dbDao.createCustCA     (bkgBlNoVO, copyTypeCd);		
			//03. 
			dbDao.createQtyCA      (bkgBlNoVO, copyTypeCd);
			//04. 
			dbDao.createQtyDtlCA   (bkgBlNoVO, copyTypeCd);
			//05. 
			dbDao.createRefCA      (bkgBlNoVO, copyTypeCd);
			//06. 
			dbDao.createRefDtlCA   (bkgBlNoVO, copyTypeCd);
			//07. 
			dbDao.createVvdCA      (bkgBlNoVO, copyTypeCd);
			//08. 
			dbDao.createCntcPsonCA (bkgBlNoVO, copyTypeCd);
			//09. 
			dbDao.createNVOFileNoCA(bkgBlNoVO, copyTypeCd);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * C/A를 위해 booking 관련 table을 삭제한다.<br>
	 * @author 		Lee NamKyung
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		String copyTypeCd
	 * @exception 	EventException
	 */
	public void removeCA(BkgBlNoVO bkgBlNoVO, String copyTypeCd) throws EventException {
		try {
			//01. 
			dbDao.removeCntcPsonCA(bkgBlNoVO, copyTypeCd);				
			//02. 
			dbDao.removeCustCA    (bkgBlNoVO, copyTypeCd);
			//03. 
			dbDao.removeRefDtlCA  (bkgBlNoVO, copyTypeCd);				
			//04.  
			dbDao.removeRefCA     (bkgBlNoVO, copyTypeCd);				
			//05. 
			dbDao.removeQtyDtlCA  (bkgBlNoVO, copyTypeCd);
			//06. 
			dbDao.removeQtyCA     (bkgBlNoVO, copyTypeCd);
			//07. 
			dbDao.removeVvdCA     (bkgBlNoVO, copyTypeCd);
			//08. 
			dbDao.removeNVOFilerCA(bkgBlNoVO, copyTypeCd);
			//09. 
			dbDao.removeBkgCA     (bkgBlNoVO, copyTypeCd);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * booking Copy를 하기 위해 원본이되는 booking의 data를 조회한다.<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return			BookingCopyVO
	 * @exception 	EventException
	 */
	public BookingCopyVO searchBkgForCopy(BkgBlNoVO bkgBlNoVO) throws EventException {
		BookingCopyVO bookingCopyVO = new BookingCopyVO();
		try {
			BkgForCopyVO bkgForCopyVO = dbDao.searchBkgForCopy(bkgBlNoVO);
			BlCustomerInfoVO blCustomerInfoVO = dbDao.searchBkgCustomer("B", bkgBlNoVO);
			List<VslSkdVO> vslSkdVOs = dbDao.searchVvdSkdForTsRoute(bkgBlNoVO);
			
			List<VslSkdVO> rtnVslSkdVOs = new ArrayList<VslSkdVO>();
			for(int i = 0 ; i < vslSkdVOs.size() ; i++){
				PolPodVvdVO polPodVvdVO = new PolPodVvdVO();
				polPodVvdVO.setPolCd		(vslSkdVOs.get(i).getPolCd());
				polPodVvdVO.setPolYdCd		(vslSkdVOs.get(i).getPolYdCd());
				polPodVvdVO.setPolClptIndSeq(vslSkdVOs.get(i).getPolClptIndSeq());
				polPodVvdVO.setPodCd		(vslSkdVOs.get(i).getPodCd());
				polPodVvdVO.setPodYdCd		(vslSkdVOs.get(i).getPodYdCd());
				polPodVvdVO.setPodClptIndSeq(vslSkdVOs.get(i).getPodClptIndSeq());
				polPodVvdVO.setBkgVvdCd(vslSkdVOs.get(i).getBkgVvdCd());
				
				// 새로 조회된 정보를 VslSkdVO 에 담는다.
				VslSkdVO vslSkdVO = dbDao.searchLaneEtdEta(polPodVvdVO);

				// 화면에 내용을 VslSkdVO에 추가한다.
//				if(vslSkdVO == null){
//					vslSkd.get(i).setEtd(vslSkdVO.getEtd());
//					vslSkd.get(i).setEtdDay(vslSkdVO.getEtdDay());
//					vslSkd.get(i).setEtdTime(vslSkdVO.getEtdTime());					
//					vslSkd.get(i).setEta(vslSkdVO.getEta());
//					vslSkd.get(i).setEtaDay(vslSkdVO.getEtaDay());
//					vslSkd.get(i).setEtaTime(vslSkdVO.getEtaTime());
//				}

				// 화면에 내용을 VslSkdVO에 추가한다.
				if(vslSkdVO == null){
					vslSkdVO = new VslSkdVO();
				}
				vslSkdVO.setPodCd(polPodVvdVO.getPodCd());
				vslSkdVO.setPolCd(polPodVvdVO.getPolCd());
				vslSkdVO.setBkgVvdCd(polPodVvdVO.getBkgVvdCd());
//				vslSkdVO.setVslPrePstCd(polPodVvdVOs[i].getVslPrePstCd());

				rtnVslSkdVOs.add(vslSkdVO);
			}			
			
			bookingCopyVO.setBkgForCopyVO(bkgForCopyVO);
			bookingCopyVO.setBlCustomerInfoVO(blCustomerInfoVO);
			bookingCopyVO.setVslSkd(rtnVslSkdVOs);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return bookingCopyVO;
	}	
	
	/**
	 * 원본 Booking의 data를 검사하고 조합하여 new booking의 data를 생성함.<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BookingCopyVO bookingCopyVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void validateBkgCopy(BookingCopyVO bookingCopyVO, SignOnUserAccount account) throws EventException {
		try {
			BookingUtil utilBC = new BookingUtil();
			// 11. Ofc이 같은 지역인지 확인(searchOfcVsBkgOfc) -> 제외 (20100406 임종한 과장님 요청)
//			if(dbDao.searchOfcVsBkgOfc(bookingCopyVO.getBkgBlNoVO(), account)){
//				throw new EventException((String)new ErrorHandler("BKG02009").getMessage());
//			}
			
			// 13. Bdr이 걸린 VVD, POL에 새 bkg을 생성하는지 확인
			VslSkdVO[] vslSkdVOs = bookingCopyVO.getVslSkdVOs();
			for(int i = 0 ; i < vslSkdVOs.length ; i++){
				BkgVvdVO bkgVvdVO = new BkgVvdVO();
				
				if(vslSkdVOs[i].getBkgVvdCd() != null && vslSkdVOs[i].getBkgVvdCd().length() == 9){
					bkgVvdVO.setVslCd(vslSkdVOs[i].getBkgVvdCd().substring(0,4));
					bkgVvdVO.setSkdVoyNo(vslSkdVOs[i].getBkgVvdCd().substring(4,8));
					bkgVvdVO.setSkdDirCd(vslSkdVOs[i].getBkgVvdCd().substring(8,9));
				}
				bkgVvdVO.setPolCd(vslSkdVOs[i].getPolCd());
				bkgVvdVO.setPodCd(vslSkdVOs[i].getPodCd());

				// bdr이면 false로 return
				if(utilBC.searchVvdBdr(bkgVvdVO)){
					throw new EventException((String)new ErrorHandler("BKG00071", new String[]{vslSkdVOs[i].getBkgVvdCd()}).getMessage());
				}				
			}
		} catch (EventException ex) {
			throw ex;					
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
 
	
	/**
	 * Booking을 Copy한다.<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BookingCopyVO bookingCopyVO
	 * @param 		BkgBlNoVO sourceBkg
	 * @param 		BkgBlNoVO targetBkg
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void copyBooking(BookingCopyVO bookingCopyVO, BkgBlNoVO sourceBkg, BkgBlNoVO targetBkg, SignOnUserAccount account) throws EventException {
		try {
			BookingUtil util = new BookingUtil();
			
			BookingCreationVO bookingCreationVO = new BookingCreationVO();
			BkgBookingInfoVO bkgBookingInfoVO = new BkgBookingInfoVO();
			BkgForCopyVO bkgForCopyVO = bookingCopyVO.getBkgForCopyVO();
			
			// 25. 중복 BL번호 체크
			if(dbDao.searchBkgBlNoDup(targetBkg)){
				throw new EventException((String)new ErrorHandler("BKG00034",new String[]{targetBkg.getBlNo()}).getMessage());
			}			
			
			// 26. Booking 테이블에 저장할 정보를 조회한다.
			BkgBookingVO bkgBookingVO = dbDao.searchBkgBookingForCopy(bkgForCopyVO, account);
			
			// 2017.11.09 iylee Copy 시 Stowage Code는 Copy 안하도록 막음.
			bkgBookingVO.setStwgCd("");
			
			// 조회된 정보에 BkgNo,BlNo등을 저장한다.
			bkgBookingVO.setBkgNo(targetBkg.getBkgNo());
			bkgBookingVO.setBlNo(targetBkg.getBkgNo());
			bkgBookingVO.setScNo(bkgForCopyVO.getScNo());
			bkgBookingVO.setRfaNo(bkgForCopyVO.getRfaNo());
			bkgBookingVO.setTaaNo(bkgForCopyVO.getTaaNo());			 
			bkgBookingVO.setPctlNo(targetBkg.getPctlNo());
			
		    String bdrVvd = dbDao.searchBdrLog(targetBkg.getPctlNo());
	    	if(bdrVvd!=null && bdrVvd.length()>0){
				throw new EventException((String)new ErrorHandler("BKG00071", new String[]{bdrVvd, "already Released"}).getMessage());
			}
	    	
			// 27. Booking 정보를 저장한다.
	    	// [CHM-201114180-01] ALPS> Booking Creation > External Remarks에 자동 문구 삽입 요청 드립니다.
	    	bkgBookingInfoVO.setBkgPolCd(bkgBookingVO.getPolCd());
	    	bkgBookingInfoVO.setBkgPodCd(bkgBookingVO.getPodCd());
	    	bkgBookingInfoVO.setBkgTrunkVvd(bkgBookingVO.getVslCd() + bkgBookingVO.getSkdVoyNo() + bkgBookingVO.getSkdDirCd());
	    	bkgBookingInfoVO.setSlanCd(bkgBookingVO.getSlanCd());
	    	bkgBookingInfoVO.setXterRmk(bkgBookingVO.getXterRmk());	    	
			bookingCreationVO.setBkgBookingInfoVO(bkgBookingInfoVO);
			
			List<BkgQuantityVO> bkgQuantity = dbDao.searchBkgQuantityForCopy(bkgForCopyVO);
			BkgQuantityVO[] arrBkgQuantity = new BkgQuantityVO[bkgQuantity.size()];
			bookingCreationVO.setBkgQuantityVOs(bkgQuantity.toArray(arrBkgQuantity));
	    	bkgBookingVO.setXterRmk(modifyExtRmk(bookingCreationVO).getXterRmk());
	    	
			dbDao.addBkgBookingForCopySplit(bkgBookingVO);
			if(targetBkg.getPctlNo() != null && targetBkg.getPctlNo().length() > 0 
					&& !"FAIL".equals(targetBkg.getPctlNo().substring(0, 4))){
				dbDao.modifyBkgRouteFromPrd(targetBkg, "C");							
			}
			
//			// 28. sourceBkg의 bkg_customer를 targetBkg로 복사한다.
//			dbDao.copyBkgCustomerByBkg(sourceBkg, targetBkg, account);
			// 이전 bkg의 shipper, ffwd code만 사용함
			BkgCustomerVO bkgCustomerVO = new BkgCustomerVO();
			BlCustomerInfoVO schCustVO = dbDao.searchBkgCustomer("", sourceBkg);
			bkgCustomerVO.setBkgNo(targetBkg.getBkgNo());
			bkgCustomerVO.setUpdUsrId(account.getUsr_id());
			bkgCustomerVO.setCreUsrId(account.getUsr_id());
			// 09-01. SHIPPER 입력
			bkgCustomerVO.setBkgCustTpCd("S");
			bkgCustomerVO.setCustCntCd(schCustVO.getSCustCntCd());
			bkgCustomerVO.setCustSeq(schCustVO.getSCustSeq());
			bkgCustomerVO.setCustNm("");
			dbDao.addBkgCustomer(bkgCustomerVO, targetBkg);
			// 09-02. FORWARDER 입력
			bkgCustomerVO.setBkgCustTpCd("F");
			bkgCustomerVO.setCustCntCd(schCustVO.getFCustCntCd());
			bkgCustomerVO.setCustSeq(schCustVO.getFCustSeq());
			bkgCustomerVO.setCustNm("");
			dbDao.addBkgCustomer(bkgCustomerVO, targetBkg);
			// 09-03. CONSIGNEE 입력
			bkgCustomerVO.setBkgCustTpCd("C");
			bkgCustomerVO.setCustCntCd("");
			bkgCustomerVO.setCustSeq("");
			bkgCustomerVO.setCustNm("");
			dbDao.addBkgCustomer(bkgCustomerVO, targetBkg);
			// 09-04. NOTIFY 입력
			bkgCustomerVO.setBkgCustTpCd("N");
			bkgCustomerVO.setCustCntCd("");
			bkgCustomerVO.setCustSeq("");
			bkgCustomerVO.setCustNm("");
			dbDao.addBkgCustomer(bkgCustomerVO, targetBkg);
			// 09-05. ALSO NOTIFY  입력
			bkgCustomerVO.setBkgCustTpCd("A");
			bkgCustomerVO.setCustCntCd("");
			bkgCustomerVO.setCustSeq("");
			bkgCustomerVO.setCustNm("");
			dbDao.addBkgCustomer(bkgCustomerVO, targetBkg);
			// 09-06. EXPORT 입력
			bkgCustomerVO.setBkgCustTpCd("E");
			bkgCustomerVO.setCustCntCd("");
			bkgCustomerVO.setCustSeq("");
			bkgCustomerVO.setCustNm("");
			dbDao.addBkgCustomer(bkgCustomerVO, targetBkg);

			// 계약 관련 정보를 update한다
			dbDao.modifyCtrtInfo(targetBkg);
			dbDao.modifyChangedCtrtInfo(targetBkg, "", "", sourceBkg.getBkgNo());  //2011.10.14 jsy
			
			/****************************************************************
			 * 2010-07-13 [CHM-201004614-01] Booking copy - VVD 인식 오류<br>
			 * Booking Copy시 Trunk VVD를 변경하면서 Copy하는 경우 <br>
			 * New BKG의 Trunk VVD를 가져오지 않고 Origin BKG의  Trunk VVD를 가져오고 있음<br>
			 ***************************************************************/
			String targetTVvd = dbDao.searchTrunkVvdByBkg(targetBkg);

			// 29. Booking VVD 정보를 저장한다.
			// 12. VVD 저장
			if(targetBkg.getPctlNo() != null && targetBkg.getPctlNo().length() > 0 
					&& !"FAIL".equals(targetBkg.getPctlNo().substring(0, 4))){
//				dbDao.addBkgVvdFromPrd(targetBkg, bkgBookingVO.getVslCd() + bkgBookingVO.getSkdVoyNo() + bkgBookingVO.getSkdDirCd(), account);
				dbDao.addBkgVvdFromPrd(targetBkg, targetTVvd, account);	
				//VVD 저장 후 POL이 SGSIN인 경우에 POL ETA에서 6일을 빼도록 한다. 
				if(bkgBookingInfoVO.getBkgPolCd().equals("SGSIN")){
					dbDao.modifyMtyPkupDt(bkgBookingVO.getBkgNo(), "-6", bkgBookingInfoVO.getBkgPolCd());					
				}
			} else {							
				VslSkdVO[] vslSkdVOs = bookingCopyVO.getVslSkdVOs();
				for(int i = 0 ; i < vslSkdVOs.length ; i++){
					BkgVvdVO bkgVvdVO = new BkgVvdVO();
					bkgVvdVO.setBkgNo(targetBkg.getBkgNo());
					bkgVvdVO.setVslPrePstCd(vslSkdVOs[i].getVslPrePstCd());
					bkgVvdVO.setVslSeq(vslSkdVOs[i].getVslSeq());
					if(vslSkdVOs[i].getBkgVvdCd() != null && vslSkdVOs[i].getBkgVvdCd().length() == 9){
						bkgVvdVO.setVslCd(vslSkdVOs[i].getBkgVvdCd().substring(0,4));
						bkgVvdVO.setSkdVoyNo(vslSkdVOs[i].getBkgVvdCd().substring(4,8));
						bkgVvdVO.setSkdDirCd(vslSkdVOs[i].getBkgVvdCd().substring(8,9));
					}
					bkgVvdVO.setPolClptIndSeq(vslSkdVOs[i].getPolClptIndSeq());
					bkgVvdVO.setPodClptIndSeq(vslSkdVOs[i].getPodClptIndSeq());
					bkgVvdVO.setPolCd(vslSkdVOs[i].getPolCd());
					if(vslSkdVOs[i].getPolYdCd() != null && vslSkdVOs[i].getPolYdCd().length() > 0){
						bkgVvdVO.setPolYdCd(vslSkdVOs[i].getPolCd()+vslSkdVOs[i].getPolYdCd());	
					}	
					bkgVvdVO.setPodCd(vslSkdVOs[i].getPodCd());
					if(vslSkdVOs[i].getPodYdCd() != null &&vslSkdVOs[i].getPodYdCd().length() > 0){
						bkgVvdVO.setPodYdCd(vslSkdVOs[i].getPodCd()+vslSkdVOs[i].getPodYdCd());	
					}		
					bkgVvdVO.setCreUsrId(account.getUsr_id());
					bkgVvdVO.setUpdUsrId(account.getUsr_id());
					
					dbDao.addBkgVvd(bkgVvdVO, targetBkg);
				}			
			}
			// 30. bkg_quantity 테이블에서 cntr_tpsz_cd, op_cntr_qty를 복사를 위해 조회한다
			for(int i = 0 ; i < bkgQuantity.size() ; i++){
				BkgQuantityVO bkgQuantityVO = bkgQuantity.get(i);
				bkgQuantityVO.setBkgNo(targetBkg.getBkgNo());
				bkgQuantityVO.setCreUsrId(account.getUsr_id());
				bkgQuantityVO.setUpdUsrId(account.getUsr_id());
				
				// 32. Quantity 정보를 저장한다.
				dbDao.addBkgQuantity(bkgQuantityVO, targetBkg);
			}			

			// 후쿠시마에서 used commodity가 특정 POD로 가는지 확인함
			util.searchFukushimaUsedCmdt(targetBkg, bkgBookingVO.getCmdtCd(), "");
			
			// IRAN이 POR, POL, POD, DEL일 경우 Order B/L인 상태로 저장할 수 없다
//			util.searchIranToOrdBl(targetBkg);
			
			// 33. bkg_qty_dtl 테이블에서 cntr_tpsz_cd, op_cntr_qty, rcv_term, de_term를 복사를 위해 조회한다
			List<BkgQtyDtlVO> bkgQtyDtl = dbDao.searchBkgQtyDtlForCopy(bkgForCopyVO);
			for(int i = 0 ; i < bkgQtyDtl.size() ; i++){
				BkgQtyDtlVO bkgQtyDtlVO = bkgQtyDtl.get(i);
				bkgQtyDtlVO.setBkgNo(targetBkg.getBkgNo());
				bkgQtyDtlVO.setCreUsrId(account.getUsr_id());
				bkgQtyDtlVO.setUpdUsrId(account.getUsr_id());
				
				// 35. QtyDtl 정보를 저장한다.
				dbDao.addBkgQtyDtl(bkgQtyDtlVO, targetBkg);
			}	
			
			// 36. sourceBkg의 bkg_cntc_pson를 targetBkg로 복사한다.
			dbDao.copyBkgCntcPsonByBkg(sourceBkg, targetBkg, account);
			
			// 14. BKG ROLL OVER 저장.
			dbDao.addBkgRollOvr(targetBkg, account);
			
			// pct 조회 	2012.02.24 kbj
			String pct = dbDao.searchPct(targetBkg.getBkgNo(), "N");
			
			//pct update 2012.02.24 kbj
			dbDao.modifyPct(targetBkg, pct);

			BookingSaveValidationVO saveValidationVO = new BookingSaveValidationVO();
	    	bkgBookingInfoVO.setBkgNo(bkgBookingVO.getBkgNo());
	    	bkgBookingInfoVO.setCaFlg("N");
			String missingMsg = dbDao.searchMissingData(bkgBookingInfoVO, saveValidationVO);
			if(!"".equals(missingMsg) || missingMsg.length()>0){
				if("TRO volume".equals(missingMsg)){
					throw new EventException((String)new ErrorHandler("BKG02057").getMessage());
				} else {
					throw new EventException((String)new ErrorHandler("BKG06014", new String[]{missingMsg}).getMessage());
				} 
			}

			ScListInputVO scListInputVO = new ScListInputVO();
			scListInputVO.setBkgNo(targetBkg.getBkgNo());
			if(dbDao.validateScCtrtPtyTp(scListInputVO, "N") > 0){
				throw new EventException((String)new ErrorHandler("BKG08267").getMessage());
			}

			if(dbDao.validateScCustTp(scListInputVO, "N", "S") > 0){
				throw new EventException((String)new ErrorHandler("BKG08275").getMessage());
			}
			if(dbDao.validateScCustTp(scListInputVO, "N", "R") > 0){
				throw new EventException((String)new ErrorHandler("BKG08276").getMessage());
			}
		} catch (EventException ex) {
			throw ex;					
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	
	
	/**
	 * roll over 정보를 update<br>
	 * 
	 * @author 		
	 * @param 	  BkgRollOvrVO[] bkgRollOvrVOs
	 * @exception EventException
	 */
	public void manageBkgRollOver(BkgRollOvrVO[] bkgRollOvrVOs)throws EventException{
		try {
			  for(int i=0;i<bkgRollOvrVOs.length;i++){
				  if (bkgRollOvrVOs[i].getIbflag().equals("U")){
//					  log.error(bkgRollOvrVOs[i]);
					  dbDao.modifyBkgRollOvrRsn(bkgRollOvrVOs[i]);
				  }
			  }
			  
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	
	/**
	 * empty repo Booking을 split한다.<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		MtyBookingSplitVO mtyBookingSplitVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void splitMtyRepoBooking(MtyBookingSplitVO mtyBookingSplitVO, SignOnUserAccount account) throws EventException {
		try {
			BookingUtil utilBC = new BookingUtil();			
			
			// 4. mtySplitAvalCd를 조회
			String mtySplitAvalCd = dbDao.searchMtyRepoBkgSts(mtyBookingSplitVO.getBkgBlNoVO());
			//  전달받은 mtySplitAvalCd <> 'S'이면서 searchMtyRepoBkgSts()의 결과가 C, Z, W 중에 하나라면 [BKG01000]을 보여주고 중지한다.
			if(!"S".equals(mtyBookingSplitVO.getMtyBookingVO().getMtySplitAvalCd()) && ("C".equals(mtySplitAvalCd) || "Z".equals(mtySplitAvalCd) || "W".equals(mtySplitAvalCd))){
				throw new EventException((String)new ErrorHandler("BKG01000", new String[]{mtyBookingSplitVO.getBkgBlNoVO().getBkgNo()}).getMessage());
			}
			
			// 전달받은 mtySplitAvalCd = 'S'라면 searchMtyRepoBkgSts()의 결과를 새로운 mtySplitAvalCd로 지정한다.
			if("S".equals(mtyBookingSplitVO.getMtyBookingVO().getMtySplitAvalCd())){
				mtyBookingSplitVO.getMtyBookingVO().setMtySplitAvalCd(mtySplitAvalCd);
			}
			BkgBlNoVO newBkgBlNoVO = new BkgBlNoVO();
			newBkgBlNoVO.setBkgNo(mtyBookingSplitVO.getNewBkgSplitVO().getNewBkgNo());
			newBkgBlNoVO.setBlNo(mtyBookingSplitVO.getNewBkgSplitVO().getNewBlNo());

			if(dbDao.searchBkgBlNoDup(newBkgBlNoVO)){
				throw new EventException((String)new ErrorHandler("BKG00034",new String[]{newBkgBlNoVO.getBlNo()}).getMessage());
			}			
			
			// 5. bkg/bl no dup을 check하기 위해 addBkgBlNoDup (searchBkgBlNoDup을 안하는 이유는?)
			dbDao.addBkgBlNoDup(newBkgBlNoVO, account.getUsr_id());
			
			// 6. Empty Split Booking 정보를 저장한다.
			dbDao.addNewSplitMtyRepoBkg(mtyBookingSplitVO.getBkgBlNoVO(), mtyBookingSplitVO.getMtyBookingVO(), mtyBookingSplitVO.getNewBkgSplitVO().getNewBkgNo(), account);

			// 7. Booking Customer 정보를 Copy한다.
			dbDao.copyBkgCustomerByBkg(mtyBookingSplitVO.getBkgBlNoVO(), newBkgBlNoVO, account);
			
			// 8. 원본 Booking Split Flag 저장.
			dbDao.modifyMtyRepoMstBkg(mtyBookingSplitVO.getBkgBlNoVO().getBkgNo(), account);

			MtyVvdVO[] mtyVvdVOs = mtyBookingSplitVO.getMtyVvdVOs();
			
			for(int i = 0 ; i < mtyVvdVOs.length ; i++){
				// EQR에서 yard code 7자리만 주기 때문에 앞 5자리를 location으로 mapping한다. 
				mtyVvdVOs[i].setPolCd(mtyVvdVOs[i].getPolYdCd().substring(0, 5));
				mtyVvdVOs[i].setPodCd(mtyVvdVOs[i].getPodYdCd().substring(0, 5));
				
				// 10. validateVVD()의 결과가 없다면 [BKG00944]를 보여주고 중지한다.
				if(!utilBC.validateVvd(mtyVvdVOs[i].getVslCd(), mtyVvdVOs[i].getSkdVoyNo(), mtyVvdVOs[i].getSkdDirCd())){
					throw new EventException((String)new ErrorHandler("BKG00944").getMessage());
				}
				// 11. searchEtbEtdEta()의 결과가 없다면 POL이었을 경우 [BKG00078], POD 였을 경우 [BKG00945]를 보여주고 중지한다.
				if(utilBC.searchEtbEtdEta(mtyVvdVOs[i].getVslCd(), mtyVvdVOs[i].getSkdVoyNo(), mtyVvdVOs[i].getSkdDirCd(), mtyVvdVOs[i].getPolCd(), mtyVvdVOs[i].getPolClptIndSeq()) == null){
					throw new EventException((String)new ErrorHandler("BKG00078",new String[]{mtyVvdVOs[i].getPolCd()}).getMessage());	
				}
				// 12. POD 미지정(multi bkg)인 경우 POD schedule은 확인하지 않음
				if(mtyVvdVOs[i].getPodCd().equals("XXXXXXX")){
					if(utilBC.searchEtbEtdEta(mtyVvdVOs[i].getVslCd(), mtyVvdVOs[i].getSkdVoyNo(), mtyVvdVOs[i].getSkdDirCd(), mtyVvdVOs[i].getPodCd(), mtyVvdVOs[i].getPodClptIndSeq()) == null){
						throw new EventException((String)new ErrorHandler("BKG00945",new String[]{mtyVvdVOs[i].getPodCd()}).getMessage());	
					}
				}
				// 13. trunk vvd일 경우 bkg_booking에도 update하기 위해 modifyTrunkVvd()를 실행한다.
				if("T".equals(mtyVvdVOs[i].getVslPrePstCd())){
					dbDao.modifyTrunkVvd(mtyVvdVOs[i].getVslCd()+mtyVvdVOs[i].getSkdVoyNo()+mtyVvdVOs[i].getSkdDirCd(), newBkgBlNoVO, account);
				}
				// 14. 전달값과 조회값으로 bkg_vvd에 insert하기 위해 addBkgVvd()를 실행한다.
				BkgVvdVO bkgVvdVO = new BkgVvdVO();
				bkgVvdVO.setBkgNo(mtyBookingSplitVO.getNewBkgSplitVO().getNewBkgNo());
				bkgVvdVO.setVslPrePstCd(mtyVvdVOs[i].getVslPrePstCd());
				bkgVvdVO.setVslSeq(mtyVvdVOs[i].getVslSeq());
				bkgVvdVO.setVslCd(mtyVvdVOs[i].getVslCd());
				bkgVvdVO.setSkdVoyNo(mtyVvdVOs[i].getSkdVoyNo());
				bkgVvdVO.setSkdDirCd(mtyVvdVOs[i].getSkdDirCd());
				bkgVvdVO.setPolClptIndSeq(mtyVvdVOs[i].getPolClptIndSeq());
				bkgVvdVO.setPodClptIndSeq(mtyVvdVOs[i].getPodClptIndSeq());
				bkgVvdVO.setPolCd(mtyVvdVOs[i].getPolYdCd().substring(0, 5));
				bkgVvdVO.setPolYdCd(mtyVvdVOs[i].getPolYdCd());
				bkgVvdVO.setPodCd(mtyVvdVOs[i].getPodYdCd().substring(0, 5));
				bkgVvdVO.setPodYdCd(mtyVvdVOs[i].getPodYdCd());
				bkgVvdVO.setCreUsrId(account.getUsr_id());
				bkgVvdVO.setUpdUsrId(account.getUsr_id());

				dbDao.addBkgVvd(bkgVvdVO, newBkgBlNoVO);					
			}					
		} catch (EventException ex) {
			throw ex;				
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	
	
	/**
	 * empty repo booking의 split을 마무리한다.<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		MtyBookingSplitVO mtyBookingSplitVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void completeMtyRepoBkgSplit(MtyBookingSplitVO mtyBookingSplitVO, SignOnUserAccount account) throws EventException {
		try {
			BookingUtil utilBC = new BookingUtil();			
			
			// 32. searchCntrListBkg()을 실행
			String[] cntrArr = utilBC.searchCntrListByBkg(mtyBookingSplitVO.getBkgBlNoVO());
			boolean haveCntr = false;
			if(cntrArr.length>0){
				for(int i=0;i<cntrArr.length;i++){
					if(cntrArr[i]!=null && cntrArr[i].length()>9) haveCntr = true;
				}
			}
			if(haveCntr){
				// container가 있으면 firm
				dbDao.modifyBookingStatus("N", "N", "F", mtyBookingSplitVO.getBkgBlNoVO(), account);
			} else {
				// 33. Container가 없으면 Cancel 한다.
				dbDao.cancelMtyBkg(mtyBookingSplitVO.getBkgBlNoVO(), account);
			}
			dbDao.removeBkgQtyDtl(mtyBookingSplitVO.getBkgBlNoVO(), "");
			// 34. BkgQuantity 삭제
			dbDao.removeBkgQuantity(null, mtyBookingSplitVO.getBkgBlNoVO(), "BKG");
			
			// 35. Bkg Quantity 저장
			dbDao.addMtyBkgQtyFromCntr(mtyBookingSplitVO.getBkgBlNoVO(), account);

			// 38. New Booking Quantity 저장.
			BkgBlNoVO newBkgBlNoVO = new BkgBlNoVO();
			newBkgBlNoVO.setBkgNo(mtyBookingSplitVO.getNewBkgSplitVO().getNewBkgNo());
			newBkgBlNoVO.setBlNo(mtyBookingSplitVO.getNewBkgSplitVO().getNewBlNo());			

			dbDao.addMtyBkgQtyFromCntr(newBkgBlNoVO, account);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * Empty Booking을 Cancel한다.<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void cancelMtyBkg(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {
		try {
			dbDao.removeBkgQtyDtl(bkgBlNoVO, "");
			dbDao.removeBkgQuantity(null, bkgBlNoVO, "BKG");
			dbDao.cancelMtyBkg(bkgBlNoVO, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * vsk_vsl_port_skd 쪽 수정 사항을 bkg_vvd에 update함<br>
	 * 
	 * @author 		Ryu Dae Young
	 * @param 		List<VslSkdCngUpdateVO> vslSkdCngUpdateVOs
	 * @param 		SignOnUserAccount account
	 * @throws 		EventException
	 */
	public void modifyBkgVvdForVslSkdCng(List<VslSkdCngUpdateVO> vslSkdCngUpdateVOs, SignOnUserAccount account)throws EventException{
		try {
			// Yard 변경 시 EDI 발송 2014.03.21
			// EDI 전송 Process Flag 체크 (임시) 
			BookingUtil util = new BookingUtil();
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("BKG_VALIDATION");			
			List<BkgHrdCdgCtntVO> alocStatusSwitch = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
			
			String vskYardChgEdiFlag = "Y";
			if(alocStatusSwitch.size() > 0){
				for(int i = 0; i < alocStatusSwitch.size(); i++){
					if("VSK_YARD_CHG_EDI".equals(alocStatusSwitch.get(i).getAttrCtnt1())
							&& "OFF".equals(alocStatusSwitch.get(i).getAttrCtnt2())){
						vskYardChgEdiFlag = "N";
					}
				}
			}
			
			for(int icnt=0;icnt<vslSkdCngUpdateVOs.size();icnt++){
				VslSkdCngUpdateVO vslSkdCngUpdateVO = vslSkdCngUpdateVOs.get(icnt);
				// vvd가 없으면 안됨
				if(vslSkdCngUpdateVO.getVvd() == null || vslSkdCngUpdateVO.getVvd().length() != 9){
					throw new EventException((String)new ErrorHandler("BKG00007").getMessage());
				}			
				
				// port가 없으면 안됨
				if(vslSkdCngUpdateVO.getPortCd() == null || vslSkdCngUpdateVO.getPortCd().length() != 5){
					throw new EventException((String)new ErrorHandler("BKG00424").getMessage());
				}			
				// clpt끼리, yard끼리  둘다  없으면 안됨
				if(vslSkdCngUpdateVO.getNewClptIndSeq() == null || vslSkdCngUpdateVO.getOldClptIndSeq() == null){
					if(vslSkdCngUpdateVO.getNewYdCd() == null || vslSkdCngUpdateVO.getOldYdCd() == null){
						throw new EventException((String)new ErrorHandler("BKG00841").getMessage());
					}
				}
				
				//List<BkgBlNoVO> bkgBlNoVOs = null;// Yard 변경 시 update 대상 BKGs
				List<VskYardCngBkgListVO> vskYardCngBkgListVOs = null;
				if(!vslSkdCngUpdateVO.getOldYdCd().equals(vslSkdCngUpdateVO.getNewYdCd())){
					vskYardCngBkgListVOs = dbDao.searchVskYardCngBkgList(vslSkdCngUpdateVO);
				}
				
				dbDao.modifyBkgRouteForVslSkdCng(vslSkdCngUpdateVO, account);
	            dbDao.modifyPolForVslSkdCng(vslSkdCngUpdateVO, account);
				dbDao.modifyPodForVslSkdCng(vslSkdCngUpdateVO, account);
				
				// mds
				// Yard 변경 시 EDI 발송 2014.03.21
				// 2014.12.10 [CHM-201432810] [더블콜링] VSK 정보 업데이트에 따른 부킹 변경 건에 대한 보강 조치
				if(vskYardCngBkgListVOs != null && "Y".equals(vskYardChgEdiFlag)){
					
					CreateVskYardCngTmlBkgReceiptEdiBackEndJob createVskYardCngTmlBkgReceiptEdiBackEndJob = new CreateVskYardCngTmlBkgReceiptEdiBackEndJob();
					BackEndJobManager backEndJobManager = new BackEndJobManager();

					Vender301ParamVO vender301ParamVO = new Vender301ParamVO();
					//vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
					vender301ParamVO.setOldVvdVOs(null);
					vender301ParamVO.setOldQtyVOs(null);
					vender301ParamVO.setOldMtyPkupYdCd(null);
					vender301ParamVO.setBracCd("U");
					vender301ParamVO.setEdiKind("BT");
					vender301ParamVO.setAutoManualFlg("Y");
					
					//createVskYardCngTmlBkgReceiptEdiBackEndJob.setBbkgBlNoVOs(bkgBlNoVOs);
					createVskYardCngTmlBkgReceiptEdiBackEndJob.setVender301ParamVO(vender301ParamVO);
					createVskYardCngTmlBkgReceiptEdiBackEndJob.setSignOnUserAccount(account);
					createVskYardCngTmlBkgReceiptEdiBackEndJob.setVslSkdCngUpdateVO(vslSkdCngUpdateVO);
					createVskYardCngTmlBkgReceiptEdiBackEndJob.setVskYardCngBkgListVOs(vskYardCngBkgListVOs);

					// 1. History 추가
					String oldCtnt = vslSkdCngUpdateVO.getOldYdCd().concat("(").concat(vslSkdCngUpdateVO.getOldClptIndSeq()).concat(")");
					String newCtnt = vslSkdCngUpdateVO.getNewYdCd().concat("(").concat(vslSkdCngUpdateVO.getNewClptIndSeq()).concat(")");
					HistoryLineVO historyLineVO = new HistoryLineVO();
					historyLineVO.setUiId("VOP_VSK");			
					historyLineVO.setHisCateNm("Yard/Seq");
					//historyLineVO.setBkgNo(bkgBlNoVOs.get(i).getBkgNo());
					historyLineVO.setCaFlg("N");
					historyLineVO.setPreCtnt(oldCtnt);
					historyLineVO.setCrntCtnt(newCtnt);
					createVskYardCngTmlBkgReceiptEdiBackEndJob.setHistoryLineVO(historyLineVO);
					//historyBC.createBkgHistoryLine(historyLineVO, account);

					// 2. Double Calling 이면 eml notice
					Boolean doubleCallFlag = dbDao.searchVslSkdCngDoubleCall(vslSkdCngUpdateVO);
					if(doubleCallFlag){
						List<VslSkdCngDoubleCallEtcVO> vslSkdCngDoubleCallEtcVOs = dbDao.searchVslSkdCngDoubleCallEtc(vslSkdCngUpdateVO);
						createVskYardCngTmlBkgReceiptEdiBackEndJob.setVslSkdCngDoubleCallEtcVOs(vslSkdCngDoubleCallEtcVOs);
					}
					createVskYardCngTmlBkgReceiptEdiBackEndJob.setDoubleCallFlag(doubleCallFlag);
					
					backEndJobManager.execute(createVskYardCngTmlBkgReceiptEdiBackEndJob, account.getUsr_id(), "createVskYardCngTmlBkgReceiptEdiBackEndJob");
				}
				// Yard 변경 시 EDI 발송 2014.03.21 끝
			}

		} catch (EventException ex) {
			throw ex;				
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	
	
	/**
	 * vsk_vsl_port_skd ETA 변경시 Notice를 전송함<br>
	 * 
	 * @author 		RyuDaeYoung
	 * @param 		List<VslSkdCngUpdateVO> vslSkdCngUpdateVOs
	 * @param       SignOnUserAccount account
	 * @throws 		EventException
	 */
	public void sendVslSkdCngNotice(List<VslSkdCngUpdateVO> vslSkdCngUpdateVOs, SignOnUserAccount account)throws EventException {
		try {
			for(int icnt=0;icnt<vslSkdCngUpdateVOs.size();icnt++){
				List<VslSkdEtaCngNoticeVO> list = dbDao.searchVslSkdCngNotice(vslSkdCngUpdateVOs.get(icnt));
				for(int j = 0; j < list.size();j++){
					eaiDao.sendVskSkdCngNotice(list.get(j), account);
				}
			}
		} catch (EventException ex) {
			throw ex;				
		} catch (DAOException de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}	
	}
	
	/**
	 * Empty Repo Booking에 대해서 Booking 정보를 생성/update한다..<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		RepoBkgForUpdateVO repoBkgForUpdateVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifyMtyRepoBkg(RepoBkgForUpdateVO repoBkgForUpdateVO, SignOnUserAccount account) throws EventException {
		try {
			BookingUtil utilBC = new BookingUtil();	
			// CntrVO의 개수가 800개가 넘는지 확인한다.
//			RepoCntrVO[] repoCntrVOs = repoBkgForUpdateVO.getRepoCntrVOs();
//			if(repoCntrVOs.length > 800){
//				throw new EventException((String)new ErrorHandler("BKG00947").getMessage());
//			}
			// update의 경우 full booking인지 확인하기 위해 searchBkgCgoTp()실행한다.
			BkgBlNoVO bkgBlNoVO = repoBkgForUpdateVO.getBkgBlNoVO();
			if(!"P".equals(utilBC.searchBkgCgoTp(bkgBlNoVO))){
				throw new EventException((String)new ErrorHandler("BKG00946").getMessage());
			}
			
			// modifyMtyBkgBooking()을 실행하여 bkg_booking에 update한다.
			dbDao.modifyMtyBkgBooking(repoBkgForUpdateVO.getRepoBkgVO(), account);		

		} catch (EventException ex) {
			throw ex;			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}		
	
	/**
	 * empty repo booking의 Container정보 저장을 마무리한다.<br>
	 * 
	 * @author 		KimByungKyu
	 * @param 		RepoBkgForUpdateVO repoBkgForUpdateVO
	 * @param 		SignOnUserAccount account
	 * @return		List<BkgQuantityVO>
	 * @exception 	EventException
	 */
	public List<BkgQuantityVO> completeModifyMtyRepoBkg(RepoBkgForUpdateVO repoBkgForUpdateVO, SignOnUserAccount account) throws EventException {
		try {
			BookingUtil utilBC = new BookingUtil();
			List<BkgQuantityVO> bkgQtyVO = null;
		
			String bkgNo = repoBkgForUpdateVO.getBkgBlNoVO().getBkgNo();
			String masterBkgNo = "";
			BkgBlNoVO masterBkgBlNoVO = new BkgBlNoVO();
			boolean isMasterBkgNo = false;
			if(bkgNo.length() == 11){
				isMasterBkgNo = true;
			}else if(bkgNo.length() == 13){
				masterBkgNo = bkgNo.substring(0,11);
				masterBkgBlNoVO.setBkgNo(masterBkgNo);
			}else{
				// 진행되는 BKG의 master BKG을 조회하기 위해 searchMtyMasterBkg()를 실행한다				
				masterBkgNo = utilBC.searchSplitMstBkgNo(bkgNo);
				if(masterBkgNo == null || masterBkgNo.length() < 1){
					isMasterBkgNo = true;
				}else{
					masterBkgBlNoVO.setBkgNo(masterBkgNo);
				}
			}			

			String[] cntrArr = utilBC.searchCntrListByBkg(repoBkgForUpdateVO.getBkgBlNoVO());
			//Master BKG에 Container가 있는지 조회
			String[] mstCntrArr = utilBC.searchCntrListByBkg(masterBkgBlNoVO);

			//기존 BKG Quantity 정리
			if(cntrArr.length> 0 || mstCntrArr.length>0){
				// Bkg Quantity 삭제
				dbDao.removeBkgQtyDtl(repoBkgForUpdateVO.getBkgBlNoVO(), null);
				dbDao.removeBkgQuantity(null, repoBkgForUpdateVO.getBkgBlNoVO(), "BKG");
				
				// Bkg Quantity 저장
				dbDao.addMtyBkgQtyFromCntr(repoBkgForUpdateVO.getBkgBlNoVO(), account);
			}
			
			bkgQtyVO = dbDao.searchBkgQuantity(repoBkgForUpdateVO.getBkgBlNoVO());
			if(!isMasterBkgNo){ 
				//origin bkg을 찾은 경우(update한 bkg이 split으로 생성된 bkg인 경우)
				//Master BKG Quantity 정리
				dbDao.removeBkgQtyDtl(masterBkgBlNoVO, null);
				dbDao.removeBkgQuantity(null, masterBkgBlNoVO, "BKG");				
				dbDao.addMtyBkgQtyFromCntr(masterBkgBlNoVO, account);
				
				boolean haveCntr = false;
				if(mstCntrArr.length>0){
					for(int i=0;i<mstCntrArr.length;i++){
						if(mstCntrArr[i]!=null && mstCntrArr[i].length()>9) haveCntr = true;
					}
				}
				if(haveCntr){
					// 결과가 1건 이상이라면 원본 Booking Firm.
					dbDao.modifyBookingStatus("N", "N", "F", masterBkgBlNoVO, account);	
				} else {
					// 결과가 0건 이라면 원본 Booking Cancel.
					dbDao.cancelMtyBkg(masterBkgBlNoVO, account);	
				}
				
				// update한  bkg이 split으로 생성된 bkg인 경우
				String[] cntrNoArr =  utilBC.searchCntrListByBkg(repoBkgForUpdateVO.getBkgBlNoVO());
				
				haveCntr = false;
				if(cntrNoArr.length>0){
					for(int i=0;i<cntrNoArr.length;i++){
						if(cntrNoArr[i]!=null && cntrNoArr[i].length()>9) haveCntr = true;
					}
				}
				if(haveCntr == false){
					dbDao.cancelMtyBkg(repoBkgForUpdateVO.getBkgBlNoVO(), account);
				}				
			} else {


			}
			
			return bkgQtyVO;		
		} catch (EventException ex) {
			throw ex;					
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * 말레이지아 지역에서 Booking별로 forwarder code와 vsl reference 정보를 수정한다.(ESM_BKG_0616)
	 * 
	 * @param FwrdRefVvdVO[] fwrdRefVvdVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */	
	public void manageMyFwrdRefVvd(FwrdRefVvdVO[] fwrdRefVvdVO, SignOnUserAccount account) throws EventException {
		try {
			if (fwrdRefVvdVO != null) {
				for (int i=0;i<fwrdRefVvdVO.length;i++) {
					if(!"Y".equals(dbDao.searchMyFwrdRefCd(fwrdRefVvdVO[i]))){
						throw new EventException(new ErrorHandler("BKG00651", new String[]{fwrdRefVvdVO[i].getMyFwrdRefCd()}).getMessage());
					}
					dbDao.modifyMyFwrdRefVvd(fwrdRefVvdVO[i], account);
				}
			}
		} catch (EventException ex) {
			throw ex;				
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}  

	/**
	 * split, combine 후 변경된 data로 bkg_booking의 spcl flag를 수정함<br>
	 * @author		Ryu Dae Young
	 * @param 		BkgBlNoVO[] bkgBlNoVO
	 * @param 		SignOnUserAccount account
	 * @exception 	EventException
	 */
	public void modifySpclFlag(BkgBlNoVO[] bkgBlNoVO, SignOnUserAccount account) throws EventException {
		try{
			for(int i=0;i<bkgBlNoVO.length;i++){
				dbDao.modifySpclFlag(bkgBlNoVO[i], account);	
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Booking의 Ocean Route만 수정한다.<br>
	 * 
	 * @param VvdAssignVO vvdAssignVO
	 * @param SignOnUserAccount account
	 * @return BdrSpclVO
	 * @exception EventException
	 */
	public BdrSpclVO modifyOceanRoute(VvdAssignVO vvdAssignVO, SignOnUserAccount account) throws EventException {
		try{
			BookingUtil utilBC = new BookingUtil();
			BdrSpclVO bdrSpclVO = new BdrSpclVO();
			BkgBlNoVO bkgBlNoVO = vvdAssignVO.getBkgBlNoVO();
			
			// Group VVD/Port Assign 0898 화면에서 call한 경우
			if(vvdAssignVO.getVvdPortAssinVOs()!=null){
				if(bkgBlNoVO.getPctlNo() == null ||"FAIL".equals(bkgBlNoVO.getPctlNo().substring(0, 4))){
					throw new EventException((String)new ErrorHandler("BKG00309").getMessage());
				}				
			}
			//2012.01.09 port_skp_flg update 로직 추가 kbj
			if(vvdAssignVO.getPortSkpFlg() != null){
				dbDao.modifyBkgFromTs(bkgBlNoVO,vvdAssignVO.getPortSkpFlg());
			}
			
			if (bkgBlNoVO.getPctlNo().equals("")){
				dbDao.modifyBkgVvdForAssign(bkgBlNoVO,vvdAssignVO.getOldNewVvdVO().getOldvvd(),vvdAssignVO.getOldNewVvdVO().getNewvvd(),account);
			}else{				
				dbDao.modifyBkgRouteFromPrd(bkgBlNoVO, "U");
				dbDao.removeBkgVvd(bkgBlNoVO);
				dbDao.addBkgVvdFromPrd(bkgBlNoVO, null, account);
				// pct 조회 	2012.02.24 kbj
				String pct = dbDao.searchPct(bkgBlNoVO.getBkgNo(), "N");
				//pct update 2012.02.24 kbj
				dbDao.modifyPct(bkgBlNoVO, pct);
				// 2017.10.17 iylee BKG_BL_DOC에 변경된 VSL NAME Update
				dbDao.modifyVslNmBkgBlDoc(bkgBlNoVO.getBkgNo());
			}

			if(vvdAssignVO.getOldNewVvdVO()!=null){
				dbDao.modifyNewVvdOopCd(bkgBlNoVO, vvdAssignVO.getOldNewVvdVO(), account);
			}

			if(vvdAssignVO.getOldNewVvdVO()!=null || vvdAssignVO.getClosedVvds() != null){
				//for t/s booking close
				if(vvdAssignVO.getClosedVvds() != null && vvdAssignVO.getClosedVvds().length() > 0){
					List<TsBkgCloseNoticeVO> tsBkgCloseNoticeVOs = dbDao.searchTsCloseNotice(bkgBlNoVO, vvdAssignVO.getClosedVvds().split(","));
					if(tsBkgCloseNoticeVOs.size() > 0){
						eaiDao.sendTsCloseNotice(tsBkgCloseNoticeVOs, account);
					}
				}
			}

			if (dbDao.searchHasSpcl(bkgBlNoVO)){
				bdrSpclVO.setSpclcgoflag("Y");
			}else{
				bdrSpclVO.setSpclcgoflag("N");
			}
			
			String sBdrFlg = utilBC.searchBdrFlgByBkg(bkgBlNoVO);
			bdrSpclVO.setBdrflag(sBdrFlg);
			
			return bdrSpclVO;
		} catch (EventException ex) {
			throw ex;				
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Booking의 status를 강제로 수정한다.<br>
	 * 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String compFirm(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account)throws EventException {
		try {
			BookingUtil util = new BookingUtil();
			bkgBlNoVO =  util.searchBkgBlNoVO(bkgBlNoVO);
			dbDao.modifyBookingStatus("N", "N", "F", bkgBlNoVO, account);
			
		    return dbDao.searchBdrLog(bkgBlNoVO.getPctlNo());
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

    /**
     * C/A 진행건에 COD에서 입력한 정보를 저장한다.<br>
     * @param BkgBlNoVO bkgBlNoVO
     * @param String codRqstSeq
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyTempHistForCOD (BkgBlNoVO bkgBlNoVO, String codRqstSeq, SignOnUserAccount account) throws EventException{
    	try {
    		bkgBlNoVO.setCaNo("TMP0000001");
    		dbDao.removeBkgVvdHis(bkgBlNoVO);
    		dbDao.addBkgVvdHisFromCod(bkgBlNoVO, codRqstSeq, account);
    		dbDao.modifyBkgBkgHisFromCod(bkgBlNoVO, codRqstSeq, account);
    	} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
    	}
    }
    
    /**
     * Group VVD/Port Assign에서 입력한 정보를 저장한다.<br>
     * @param BkgBlNoVO bkgBlNoVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void modifyBkgRollOvr (BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException{
    	try {
    		BookingHistoryMgtBC 	historyBC	        = new BookingHistoryMgtBCImpl();
    		// 15. Roll Over 정보 수정
    		dbDao.modifyBkgRollOvr(bkgBlNoVO, account);

			// 16. Roll Over 정보 저장
			dbDao.addBkgRollOvr(bkgBlNoVO, account);
			
			// 17. Roll Over Notice 전송
			RollOverNoticeParamVO rollOverNoticeParamdVO = dbDao.searchRollOverNoticeParam(bkgBlNoVO);
			if(rollOverNoticeParamdVO != null){
				List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
				bkgNtcHisVOs = eaiDao.sendRollOverNotice(bkgBlNoVO, rollOverNoticeParamdVO, account);
				historyBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0898");
			}
    	} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
    	}
    }
    
    /**
     * SpecialCargo에 입력한 VoidQty를 저장한다.<br>
     * @param String bkgNo
     * @param String ovrVoidSltQty
     * @param  String caFlg
     * @exception EventException
     */
    public void modifyBbVoidQty (String bkgNo, String ovrVoidSltQty, String caFlg) throws EventException{
    	try {
    		
    		dbDao.modifyBbVoidQty(bkgNo,  ovrVoidSltQty, caFlg);
    	} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
    	}
    }
    
	/**
     * UI-BKG-1054 Customer Code Validation<br>
     * Customer Code Validation한  Unmatch 정보를 update 한다.<br>
     * @author Park Mangeon
	 * @param CustCdEvaluationVO[] custCdVal
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
    public void modifyCustCdValInfo(CustCdEvaluationVO[] custCdVal, SignOnUserAccount account) throws EventException {
		try {
			
			List<CustCdEvaluationVO> custCdEvaluations = new ArrayList<CustCdEvaluationVO>();
			for (int i= 0; i < custCdVal.length; i ++) {
				custCdVal[i].setUsrId(account.getUsr_id());  // val_usr_id
				custCdVal[i].setOfcCd(account.getOfc_cd());  // val_office_cd
				custCdEvaluations.add(custCdVal[i]);
			}

			// booking customer를 수정한다. move from inbound
			dbDao.modifyCustCdValInfo(custCdEvaluations);			
        }catch (DAOException de) {
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
    }
    /**
     * Arrival Notice 기록수정
     * @param ArrNtcCustListVO[] arrNtcCustListVOS
     * @throws EventException
     */
    public void modifyArrNtcCustChgFlg ( ArrNtcCustListVO[] arrNtcCustListVOS)throws EventException {
    	try {
    		for (int i = 0; i < arrNtcCustListVOS.length; i++) {
				ArrNtcCustListVO arrNtcCustListVO = arrNtcCustListVOS[i];
				//BkgArrNtcDtlVO bkgArrNtcDtlVO = new BkgArrNtcDtlVO(); 
				dbDao.modifyArrNtcChgDpFlg(arrNtcCustListVO);
    		}

						
        }catch (DAOException de) {
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
    }
	/**
     * UI_BKG-1054 Customer Code Validation<br>
     * Customer Code Validation작업으로 Match된 정보를 Unmatch로 변경한다.<br>
     * @author Park Mangeon
	 * @param String bkgNo
	 * @param String bkgCustTpCd
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeCustCdValInfo(String bkgNo, String bkgCustTpCd, SignOnUserAccount account) throws EventException {
		try {
			
			// booking customer를 수정한다. move to outbound
			dbDao.removeCustCdValInfo(bkgNo, bkgCustTpCd, account.getUsr_id());

        }catch (DAOException de) {
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * UI-BKG-1054 Customer Code Validation<br>
	 * Booking Customer와 MDM정보를 비교하여 일치하는 정보에 대하여 match되었다고 수정한다.<br>
	 * @param ArrNtcSearchVO arrNtcSearch 검색조회 조건
	 * @throws EventException
	 * @author Park Mangeon
	 */
	public void modifyBkgCustValInfo(ArrNtcSearchVO arrNtcSearch ) throws EventException {
		try {
			
			// booking customer를 수정한다. move to outbound
			dbDao.modifyBkgCustValInfo(arrNtcSearch);

        }catch (DAOException de) {
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
	}
	
	/**
	 * Inbound - Remove Customer Code Validation<br>
	 * Booking단위로 Customer Code Validation을 제거한다.<br>
	 * @param String bkgNo 부킹번호
	 * @throws EventException
	 * @author Park Mangeon
	 */
	public void cancelCustCdVal(String bkgNo) throws EventException {
		try {
			// booking customer를 수정한다. move to outbound
			dbDao.cancelCustCdVal(bkgNo);

        }catch (DAOException de) {
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
	}

    
	/**
	 * Inbound - UI-BKG-0941 - Customer Code Error Report Confirm<br>
	 * Code Validation결과를 재평가 한다.<br>
	 * @param ArrNtcCustCodeErrListVO[] custCodeErrLists
	 * @throws EventException
	 * @author Park Mangeon
	 */
	public void confirmCustCdErrReport(ArrNtcCustCodeErrListVO[] custCodeErrLists ) throws EventException {
		try {
			
//			List<ArrNtcCustCodeErrListVO> arrNtcCustCodeErrList = new ArrayList<ArrNtcCustCodeErrListVO>();
//			for (int i= 0; i < custCodeErrLists.length; i ++) {
//				arrNtcCustCodeErrList.add(custCodeErrLists[i]);
//			}
//
			// booking customer를 수정한다. move to outbound
			dbDao.confirmCustCdErrReport(custCodeErrLists);

        }catch (DAOException de) {
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), de);
        }catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110",new String[]{}).getMessage(), ex);
        }
	}

	/**
     * ocean route Validation<br>
     * 변경하려는 route가 ocean route로 등록되어 있는지 확인한다.<br>
     * @author 		Ryu Daeyoung
	 * @param 		PrdMainInfoVO prdMainInfoVO
	 * @exception 	EventException
	 */
	public void validateOceanRoute(PrdMainInfoVO prdMainInfoVO) throws EventException{
		try {
			ValidateOceanRouteVO validateOceanRouteVO = dbDao.validateOceanRoute(prdMainInfoVO);
			int copCount   = Integer.parseInt(validateOceanRouteVO.getCopCount());
			int routeCount = Integer.parseInt(validateOceanRouteVO.getRoute());
			
			if(routeCount == 0 || routeCount > 1){
				String strErrMsg = prdMainInfoVO.getPor()+"-"+prdMainInfoVO.getPol1()+"-("+prdMainInfoVO.getLane1()+")-"+prdMainInfoVO.getPod1();
				if(prdMainInfoVO.getPol2()!=null&&prdMainInfoVO.getPol2().length()>0){
					strErrMsg = strErrMsg + ", " + prdMainInfoVO.getPol2()+"-("+prdMainInfoVO.getLane2()+")"+prdMainInfoVO.getPod2();
				}
				if(prdMainInfoVO.getPol3()!=null&&prdMainInfoVO.getPol3().length()>0){
					strErrMsg = strErrMsg + ", " + prdMainInfoVO.getPol3()+"-("+prdMainInfoVO.getLane3()+")-"+prdMainInfoVO.getPod3();
				}

				if(prdMainInfoVO.getPol4()!=null&&prdMainInfoVO.getPol4().length()>0){
					strErrMsg = strErrMsg + ", " + prdMainInfoVO.getPol4()+"-("+prdMainInfoVO.getLane4()+")-"+prdMainInfoVO.getPod4();
				}
				strErrMsg = strErrMsg + "-" + prdMainInfoVO.getDel();
				log.debug(strErrMsg);
				throw new EventException((String)new ErrorHandler("BKG02030", new String[]{strErrMsg}).getMessage());
			}
			
			if(copCount == 0){
				throw new EventException((String)new ErrorHandler("BKG02031", new String[]{prdMainInfoVO.getBkgNo()}).getMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	/**
     * cargo Closing Time을 생성한다.<br>
     * @author Ryu Daeyoung
     * @param BkgBlNoVO bkgBlNoVO
     * @param String fromDt
     * @param String toDt
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void createCargoClosingTime(BkgBlNoVO bkgBlNoVO, String fromDt, String toDt, SignOnUserAccount account) throws EventException{
		try{
			dbDao.addCargoClosingTime(bkgBlNoVO, account);
			if(fromDt == null || fromDt.length() < 1) fromDt = "N";
			if(toDt == null || toDt.length() < 1) toDt = "N";
			dbDao.modifyCargoClosingTimeByReplan(bkgBlNoVO, fromDt, toDt, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
     * rail receiving time 계산을 위해 bkg_quantity를 조회한다..<br>
     * @author Ryu Daeyoung
     * @param BkgBlNoVO bkgBlNoVO
     * @return PrdQtyInfoVO[]
	 * @exception EventException
	 */
	public PrdQtyInfoVO[] searchBkgQtyForRailTime(BkgBlNoVO bkgBlNoVO) throws EventException{
		try{
			List<BkgQuantityVO> bkgQuantityVOs = dbDao.searchBkgQuantity(bkgBlNoVO);
			PrdQtyInfoVO[] prdQtyInfo 	= new PrdQtyInfoVO[bkgQuantityVOs.size()];
			
			for(int i = 0 ; i < bkgQuantityVOs.size() ; i++){	
				prdQtyInfo[i] = new PrdQtyInfoVO();				
				prdQtyInfo[i].setCTpsz(bkgQuantityVOs.get(i).getCntrTpszCd());
				prdQtyInfo[i].setCQty(bkgQuantityVOs.get(i).getOpCntrQty());				
			}
			return prdQtyInfo;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		
	}
	//GeneralBookingSearchBC의 것과 중복임
//	/**
//     * Service Scope를 조회 한다.<br>
//     * eBKG Customer Tab에서 사용
//     * @author Ryu Daeyoung
//     * @param String trnkLaneCd
//     * @param String porCd
//     * @param String delCd
//     * @return String
//	 * @exception EventException
//	 */
//	public String searchSvcScope(String trnkLaneCd, String porCd, String delCd) throws EventException{
//		String svcScpCd = "";
//		// 05. SVC Scope를 조회한다. (Rating이면 Skip한다.)
//		try {
//			svcScpCd = dbDao.searchSvcScope(trnkLaneCd, porCd, delCd);
//		} catch (DAOException ex) {
//			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
//		} catch (Exception ex) {
//			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
//		}
//		return svcScpCd;
//	}
	/**
     * 입력한 vvd중 trunk vvd를 coa 항차 기준으로 계산한다.<br>
     * @author Ryu Daeyoung
     * @param PolPodVvdVO[] polPodVvdVOs
     * @return String
	 * @exception EventException
	 */
	public String searchTrnkVvdByRlane(PolPodVvdVO[] polPodVvdVOs) throws EventException{
		try{
			return dbDao.searchTrnkVvdByRlane(polPodVvdVOs);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	/**
     * c/a tmp를 지워야하는 지 조회
     * @param BkgBlNoVO bkgBlNoVO
     * @return String
     * @throws EventException
     */
	public String searchCaTmp(BkgBlNoVO bkgBlNoVO)throws EventException{
		try{
			return dbDao.searchCaTmp(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
     * eBkg에서 P/O no 조회
     * @param BkgBlNoVO bkgBlNoVO
     * @return PoOtherNoVO
     * @throws EventException
     */
	public PoOtherNoVO searchPoOtherNoByXter(BkgBlNoVO bkgBlNoVO) throws EventException{
		PoOtherNoVO rPoOtherNoVO = new PoOtherNoVO(); 
		try {
			PoOtherNoBkgVO poOtherNoBkgVO = new PoOtherNoBkgVO();
			poOtherNoBkgVO.setBkgNo(bkgBlNoVO.getBkgNo());
			
			// 1. Search byCntr
			String bkgRefTpCd = "CTPO";
			rPoOtherNoVO.setO_poOtherCntrVOs(dbDao.searchPoNoByCntr(poOtherNoBkgVO, bkgRefTpCd));

			// container에 할당된 sub값 가져오기.[DB에서 구한 첫번째 CONTAIN_NO 값을 셋팅하기]
			if(rPoOtherNoVO.getO_poOtherCntrVOs().size()>0){
				poOtherNoBkgVO.setCntrNo(rPoOtherNoVO.getO_poOtherCntrVOs().get(0).getCCntrNo());
			}
			
			bkgRefTpCd = "MSLD";
			List<PoOtherLoadingCntrVO> rPoOtherLoadingCntrVO = dbDao.searchPoNoByLoadingCntr(poOtherNoBkgVO, bkgRefTpCd);
			rPoOtherNoVO.setO_poOtherLoadingCntrVOs(rPoOtherLoadingCntrVO);			
			
			// 2. Search byBKG
			List<PoOtherNoBkgVO> rPoOtherNoBkgVOs = dbDao.searchPoNoByBkg(poOtherNoBkgVO);
			rPoOtherNoVO.setO_poOtherNoBkgVOs(rPoOtherNoBkgVOs);
			//3.Search byCM
			List<PoOtherCmVO> rPoOtherCmVOs = dbDao.searchPoNoByCm(poOtherNoBkgVO);
			rPoOtherNoVO.setO_poOtherCmVOs(rPoOtherCmVOs);
			
			//CHM-201433292 e-BKg & SI Upload화면 > M&D tap > Ship ID항목 추가		
			//4.Search byShip
			List<PoOtherShipVO> rPoOtherShipVOs = dbDao.searchPoNoByShip(poOtherNoBkgVO);
			rPoOtherNoVO.setO_poOtherShipVOs(rPoOtherShipVOs);
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		}
		return rPoOtherNoVO;
	}


	/**
     * booking split 화면에서 split시 CBF를 조회
     * @param BkgBlNoVO bkgBlNoVO
     * @return String
	 * @param SignOnUserAccount account
     * @throws EventException
     */
	public String searchCbfFlag(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException{
		String cbfFlag = "N";
		BookingUtil             util        = new BookingUtil();
		
		try {			
				boolean isCbfFinal = false;
				BkgCloseVO bkgCloseVO = util.searchBkgCbf(bkgBlNoVO);
				if(bkgCloseVO != null && bkgCloseVO.getNewVvd() != null && !bkgCloseVO.getNewVvd().trim().equals("")){
					String[] arrCBF  = dbDao.searchCBFBS(bkgCloseVO.getNewVvd().substring(0, 4), bkgCloseVO.getNewVvd().substring(4, 8), bkgCloseVO.getNewVvd().substring(8, 9), bkgCloseVO.getNewYdCdSeq());
					for (int i=0;i<arrCBF.length;i++){
						if("Final".equals(arrCBF[i])){
							isCbfFinal = true;
							break;
						}
					}
				
					if(arrCBF != null && isCbfFinal == true){
						cbfFlag = "Y";
					} else {
						cbfFlag = "N";
					}
				}
			
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);	
		}
		return cbfFlag;
	}

	/**
     * cargo Closing Time을 수정한다.<br>
     * @param BkgClzTmVO bkgClzTmVO
	 * @exception EventException
	 */
	public void modifyCargoClosingTime(BkgClzTmVO bkgClzTmVO) throws EventException{
		try{
			dbDao.modifyCargoClosingTime(bkgClzTmVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
     * modifySiFlag<br>
     * @param String bkgNo
	 * @param String siFlag
	 * @exception EventException
	 */
	public void modifySiFlag(String bkgNo, String siFlag) throws EventException {
		try{
			dbDao.modifySiFlag(bkgNo, siFlag);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}

	/**
	 * ESM_BKG_0702 : customer click <br>
	 * Customer정보를 Flat File로 생성하여 EDI로 전송한다.<br>
	 * 
	 * @param BkgBlNoVO[] bkgBlNoVO
	 * @param CustTpIdVO[] custTpIdVO
	 * @param String typeGbn
	 * @param SignOnUserAccount account
	 * @return String
	 * @throws EventException
	 */
	public String sendBkgCustEdiMulti(BkgBlNoVO[] bkgBlNoVO, CustTpIdVO[] custTpIdVO, String typeGbn, SignOnUserAccount account) throws EventException {
		BackEndJobManager backEndJobManager = null;
		SendBkgCustEdiMultiBackEndJob backEndJob = null;
		String jobID = null;
		try {
			backEndJobManager = new BackEndJobManager();
			backEndJob = new SendBkgCustEdiMultiBackEndJob(bkgBlNoVO, custTpIdVO, typeGbn, account);
			jobID = backEndJobManager.execute(backEndJob, account.getUsr_id(), "SendBkgCustEdiMultiBackEndJob");
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    } catch (Exception de) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return jobID;
	}

	/**
	 * Customer EDI로 전송 BackEndJob 결과확인<br>
	 * 
	 * @param String key
	 * @return String
	 * @throws EventException
	 */
	public String searchSendBkgCustEdiMulti(String key) throws EventException {
		String result = null;
		try {
			result = eaiDao.searchSendBkgCustEdiMulti(key);
		} catch (DAOException ex) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    } catch (Exception de) {
	        throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		return result;
	}
	
    /**
     * bkg_bl_doc에 ORG_CNT_NM column을 update한다<br>
     * 
     * @author      KimByungKyu
     * @param       BkgBlNoVO bkgBlNoVO
     * @param       String orgCntNm
     * @param       SignOnUserAccount account 
	 * @param 		String oldActCustCd
	 * @param 		String newActCustCd
     * @exception   EventException
     */
    public void modifyBlDocExpCust(BkgBlNoVO bkgBlNoVO, String orgCntNm, SignOnUserAccount account, String oldActCustCd, String newActCustCd) throws EventException {
    	BookingUtil utilBC = new BookingUtil();     
    	try {       

            log.debug("modifyBlDocExpCust oldActCustCd ="+oldActCustCd);
            log.debug("modifyBlDocExpCust newActCustCd ="+newActCustCd);
            if(!oldActCustCd.equals(newActCustCd)){
            	
            	String oldActCustNm = "";
            	String newActCustNm = "";
            	
            	if(!oldActCustCd.equals("") && oldActCustCd.length() == 8){
            		MdmCustVO oldMdmCustVO = utilBC.searchMdmCust(oldActCustCd.substring(0,2), oldActCustCd.substring(2,8), "N");
            		
            		if(oldMdmCustVO != null){
            			oldActCustNm = oldMdmCustVO.getName();
            		}
            	}
            	
            	if(!newActCustCd.equals("") && newActCustCd.length() == 8){
            		MdmCustVO newMdmCustVO = utilBC.searchMdmCust(newActCustCd.substring(0,2), newActCustCd.substring(2,8), "N");
            		
            		if(newMdmCustVO != null){
            			newActCustNm = newMdmCustVO.getName();
            		}
            	}
            	
            	BkgBlMkDescVO blMkDescVO = new BkgBlMkDescVO();
            	
            	blMkDescVO.setBkgNo(bkgBlNoVO.getBkgNo());
            	blMkDescVO.setUpdUsrId(account.getUsr_id());
            	blMkDescVO.setBkgNoSplit(bkgBlNoVO.getCaFlg());
            	int result = dbDao.modifyBlDocExpCust(blMkDescVO, oldActCustCd, newActCustCd, oldActCustNm, newActCustNm);
            	
            	log.debug("result = "+ result);
            	
            	if(result == 0){

                	log.debug("result = "+ result);
                	
            		blMkDescVO.setCreUsrId(account.getUsr_id());
            		blMkDescVO.setCmdtDesc(!newActCustNm.equals("")?newActCustNm:"");
            		//dbDao.addMndByCust(blMkDescVO);
            	}//
            }
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }
	
    /**
     * reactivate 하는 경우 booking status를 F로 변경한다.<br>
     * 
     * @author      KimByungKyu
     * @param       String bkgNo
     * @exception   EventException
     */
    public void reactBkgStatus(String bkgNo) throws EventException {
    	try {       
            dbDao.reactBkgStatus(bkgNo);
        } catch (DAOException ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
    }   
    
    /**
	 * External Remarks "Need D2 within 5 yrs" 문구 추가 및 제거<br>
	 *
	 * @author	Yuntaeseung
	 * @param 	BookingCreationVO bookingCreationVO
	 * @return	BkgBookingInfoVO
	 * @exception Exception
	 */
	private BkgBookingInfoVO modifyExtRmk(BookingCreationVO bookingCreationVO) throws EventException {
		BkgBookingInfoVO 		bkgBookingInfoVO 	=	bookingCreationVO.getBkgBookingInfoVO();
		BkgQuantityVO[] 		bkgQuantityVOs 		= bookingCreationVO.getBkgQuantityVOs();
		
        try {
        	String	bkgPolCd		=	bkgBookingInfoVO.getBkgPolCd();
    		String	bkgPodCd		=	bkgBookingInfoVO.getBkgPodCd();
    		String	xterRmk			=	bkgBookingInfoVO.getXterRmk();
    		
    		String	cntrTpszCd		=	"";
    		for(int i=0 ; i<bkgQuantityVOs.length ;i++ ) {
    			if(bkgQuantityVOs[i].getCntrTpszCd().equals("D2")) {
    				cntrTpszCd = bkgQuantityVOs[i].getCntrTpszCd();
    			}
    		}
    		
    		String	slanCd			=	bkgBookingInfoVO.getSlanCd();
    		String	bkgTrunkVvd		=	bkgBookingInfoVO.getBkgTrunkVvd().substring(8);
    		
    		String	resFlag			=	"N";
    		
    		//ALX / W / D2
    		if("ALX".equals(slanCd) && "W".equals(bkgTrunkVvd) && "D2".equals(cntrTpszCd)) {
    			//CNSHA / CNNBO / CNYIT / CNSHU
    			if("CNSHA".equals(bkgPolCd) || "CNNBO".equals(bkgPolCd) || "CNYIT".equals(bkgPolCd) || "CNSHU".equals(bkgPolCd)) {
    				//BRSSZ / BRRIG / ARBUE
    				if("BRSSZ".equals(bkgPodCd) || "BRRIG".equals(bkgPodCd) || "ARBUE".equals(bkgPodCd)) {
						resFlag = "Y";
						if(!xterRmk.matches(".*Need D2 within 5 yrs.*")) {
							bkgBookingInfoVO.setXterRmk("Need D2 within 5 yrs." + xterRmk );
						}
    				}
    			}
    		}
    		
			if("N".equals(resFlag) && xterRmk.matches(".*Need D2 within 5 yrs.*")) {
				bkgBookingInfoVO.setXterRmk(xterRmk.replace("Need D2 within 5 yrs.", ""));
			}
    		
		} catch (Exception ex) {
			log.error(ex.toString());
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return bkgBookingInfoVO;
	}
	
    /**
	 * sms 를 전송할 조건인지 체크<br>
	 *
	 * @author	jsy
	 * @param 	String bkgNo
	 * @return	boolean
	 * @exception Exception
	 */	
	public boolean chkSmsRequirement(String bkgNo) throws EventException {

		try{
			return dbDao.chkSmsRequirement( bkgNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
    /**
	 * sms 를 전송할 대상 조회<br>
	 *
	 * @author	jsy
	 * @param 	String slanCd
	 * @param 	String bkgOfcCd
	 * @param 	String dirCd
	 * @param 	String polCd
	 * @param   String bkgNo
	 * @return	List<BkgUserSmsListVO>
	 * @exception Exception
	 */	
	public List<BkgUserSmsListVO> getPhnId(String slanCd, String bkgOfcCd, String dirCd, String polCd, String bkgNo) throws EventException {
		try{
			return dbDao.getPhnId( slanCd, bkgOfcCd, dirCd, polCd, bkgNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
		
	}
    /**
	 * sms 를 전송할 조건(VVD변경) 인지 체크<br>
	 *
	 * @author	jsy
	 * @param 	String bkgNo
	 * @param 	String oldFirstVvd
	 * @param 	String newFirstVvd
	 * @param 	String bkgPolCd
	 * @param 	String bkgPolCdOld
	 * @return	boolean
	 * @exception Exception
	 */	
	public boolean chkSmsRequirementVvdChanged(String bkgNo,
			String oldFirstVvd, String newFirstVvd,String bkgPolCd, String bkgPolCdOld) throws EventException {
		try{
			return dbDao.chkSmsRequirementVvdChanged( bkgNo,oldFirstVvd,newFirstVvd,bkgPolCd,bkgPolCdOld );
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
    /**
	 * sms 를 전송할 조건(VVD변경) 결과<br>
	 *
	 * @author	jsy
	 * @param 	String bkgNo
	 * @param 	String oldFirstVvd
	 * @param 	String newFirstVvd
	 * @param 	String bkgPolCd
	 * @param 	String bkgPolCdOld
	 * @return	List<SmsRequirementResultVO>
	 * @exception Exception
	 */	
	public List<SmsRequirementResultVO> getSmsRequirementResult(String bkgNo,
			String oldFirstVvd, String newFirstVvd, String bkgPolCd, String bkgPolCdOld) throws EventException {
		try{
			return dbDao.getSmsRequirementResult( bkgNo,oldFirstVvd,newFirstVvd, bkgPolCd,bkgPolCdOld );
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
    /**
	 * sms 를 위한 vvd조회 <br>
	 *
	 * @author	jsy
	 * @param 	BkgBlNoVO schBkgBlNoVO
	 * @return	List<VslSkdVO>
	 * @exception Exception
	 */	
	public List<VslSkdVO> searchVvdSkdForTsRoute(BkgBlNoVO schBkgBlNoVO)
			throws EventException {
		try {
			return dbDao.searchVvdSkdForTsRoute(schBkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * BKG_Quantity 정보를 조회한다.
	 * @param bkgBlNoVO
	 * @return List<BkgQuantityVO>
	 * @throws EventException
	 */
	public List<BkgQuantityVO> searchBkgQuantity(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchBkgQuantity(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	
	/**
	 * pct를 조회한다.
	 * @param bkgNo
	 * @param String caFlg
	 * @return string pct
	 * @throws EventException
	 */
	public String searchPct(String bkgNo, String caFlg) throws EventException {
		try {
			return dbDao.searchPct(bkgNo, caFlg);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * pct를 수정한다.
	 * @param bkgBlNoVO
	 * @param pct
	 * @throws EventException
	 */
	public void modifyPct(BkgBlNoVO bkgBlNoVO,String pct) throws EventException {
		  try { 
		    	 dbDao.modifyPct(bkgBlNoVO,pct);
					
			} catch (DAOException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
			}	
	}


	/**
	 *  bkg_ref NO를 변경한다.(ESM_BKG_0229)<br>
	 * @param String bkgNo
	 * @param BkgReferenceVO[] bkgReferenceVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageBkgByXter(String bkgNo,BkgReferenceVO[] bkgReferenceVOs, SignOnUserAccount account) throws EventException {
		
		try {
			if (bkgReferenceVOs.length > 0) {
				for (BkgReferenceVO bkgReferenceVO : bkgReferenceVOs) {
					bkgReferenceVO.setBkgNo(bkgNo);
					dbDao.manageXterReference(bkgReferenceVO, account.getUsr_id());
				}			
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	

	/**  searchScType 을 조회한다.(ESM_BKG_0079_01,08)<br>
	 * @param String scNo
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @throws EventException
	 */
	public String searchScType(String scNo, BkgBlNoVO bkgBlNoVO) throws EventException {
		try{
			return dbDao.searchScType(scNo, bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	

	/**
	 * 하위 BKG가 모두 Cancel 된 경우의 bkg_no를 조회한다.
	 * @param String bkgNo
	 * @return List<String>
	 * @throws EventException
	 */
	public List<String> searchMemoSplitFromBkgNo(String bkgNo) throws EventException {
		try {
			return dbDao.searchMemoSplitFromBkgNo(bkgNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);			
		}
	}
	
    /**
     * Memo Split 이 전체 cancel 된 경우 Master BKG의 상태를 변경한다.<br>
     * 
     * @param BkgBlNoVO bkgBlNoVO
     * @param SignOnUserAccount account
     * @exception DAOException
     */
	public void modifyMemoSplitBkgStatus(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException {
		try {
				dbDao.modifyMemoSplitBkgStatus(bkgBlNoVO, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Booking-Special Stowage (MUPG) 자동 지정<br>
	 * 
	 * @param bkgNo
	 * @param stwgCd
	 * @param caFlg
	 * @throws EventException
	 */
	public void modifyCmFlgBySpcl(String bkgNo, String stwgCd, String caFlg) throws EventException {
		try {
			dbDao.modifyCmFlgBySpcl(bkgNo, stwgCd, caFlg);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    } catch(Exception ex) {
	    	log.error(ex.getMessage(),ex);
	    	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}	

	/**
	 * T/S Close에 대한 Notice를 전송한다<br>
	 * 
	 * @param BkgBlNoVO bkgblNoVO
	 * @param String closedtsVvds
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void sendTsCloseNotice(BkgBlNoVO bkgBlNoVO, String closedTsVvds, SignOnUserAccount account) throws EventException{
		try {
			//for t/s booking close
			List<TsBkgCloseNoticeVO> tsBkgCloseNoticeVOs = dbDao.searchTsCloseNotice(bkgBlNoVO, closedTsVvds.split(","));
			if(tsBkgCloseNoticeVOs.size() > 0){
				eaiDao.sendTsCloseNotice(tsBkgCloseNoticeVOs, account);
			}
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    } catch(Exception ex) {
	    	log.error(ex.getMessage(),ex);
	    	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Pre checking Status를 저장한다<br>
	 * 
	 * @param BkgBlNoVO bkgblNoVO
	 * @param DgPreCheckingStatusVO dgPreCheckingStatusVO
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public void modifyDGPreChkSts(BkgBlNoVO bkgBlNoVO, DgPreCheckingStatusVO dgPreCheckingStatusVO,
			SignOnUserAccount account) throws EventException{
		try {
			dbDao.modifyDGPreChkSts(bkgBlNoVO, dgPreCheckingStatusVO, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    } catch(Exception ex) {
	    	log.error(ex.getMessage(),ex);
	    	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}		
	}
	
	/**
	 * Allocation Status를 manage한다.<br>
	 * 
	 * @param BkgBlNoVO bkgblNoVO
	 * @param SignOnUserAccount account
	 * @param String docTpCd
	 * @return AllocStsChgVO
	 * @throws EventException
	 */
	public AllocStsChgVO manageAlocStatus(BkgBlNoVO bkgBlNoVO, SignOnUserAccount account, String docTpCd) throws EventException{
		List<AllocStsVO> allocStsVOs = new ArrayList<AllocStsVO>();
		try {
			BookingUtil util = new BookingUtil();
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId("BKG_VALIDATION");			
			List<BkgHrdCdgCtntVO> alocStatusSwitch = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
			
			AllocStsChgVO allocStsChgVO = new AllocStsChgVO();
			List<BkgNtcHisVO> bkgNtcHisVOs = null;
			
			String alocPopFlg = "N";
			String firmMsgFlg = "N";
			allocStsChgVO.setAlocPopFlg(alocPopFlg);
			allocStsChgVO.setFirmMsgFlg(firmMsgFlg);
			
			if(alocStatusSwitch.size() > 0){
				for(int i = 0; i < alocStatusSwitch.size(); i++){
					if("ALLOC_PROCESS".equals(alocStatusSwitch.get(i).getAttrCtnt1())
							&& "OFF".equals(alocStatusSwitch.get(i).getAttrCtnt2())){
						//return "N";
						allocStsChgVO.setAlocPopFlg("N");
						return allocStsChgVO;
					}
				}
			}
			if(!dbDao.checkEtdForAloc(bkgBlNoVO)){
				//return "N";
				allocStsChgVO.setAlocPopFlg("N");
				return allocStsChgVO;
			}
			
			// PKGSA User 가 SI 한 때에는 Standby BKG Process 적용 안 함
			if(docTpCd != null && ("S".equals(docTpCd))||"U".equals(docTpCd)||"B".equals(docTpCd)){ // 0229_01 에서 호출
				if(("S".equals(docTpCd)||"U".equals(docTpCd)) && "PKGSA".equals(account.getOfc_cd())){
					allocStsChgVO.setAlocPopFlg("N");
					return allocStsChgVO;
				}
			}else{ //0079_01, 0079_05, 0079_08
				String siFlg = dbDao.searchSiFlg(bkgBlNoVO);
				if(siFlg != null && "Y".equals(siFlg) && "PKGSA".equals(account.getOfc_cd())){
					allocStsChgVO.setAlocPopFlg("N");
					return allocStsChgVO;
				}
			}
			
			String mixRsnFlg = "N";
			String manualExistFlg = "N";
			String autoExistFlg = "N";
			
			//trunk lane 
			AllocStsVO allocStsVO = dbDao.searchAllocStsByTrunkLane(bkgBlNoVO);
			if(allocStsVO != null){
				allocStsVOs.add(allocStsVO);
				if("M".equals(allocStsVO.getAlocSvcCd())){
					manualExistFlg = "Y";
				} else if("A".equals(allocStsVO.getAlocSvcCd())){
					autoExistFlg = "Y";
				}
			}
			//t/s
			allocStsVO = dbDao.searchAllocStsByTransshipment(bkgBlNoVO);
			if(allocStsVO != null){
				allocStsVOs.add(allocStsVO);
				if("M".equals(allocStsVO.getAlocSvcCd())){
					manualExistFlg = "Y";
				} else if("A".equals(allocStsVO.getAlocSvcCd())){
					autoExistFlg = "Y";
				}
			}			
			//equipment
			if(allocStsVOs.size() >= 2 && manualExistFlg.equals("Y")){ 
				mixRsnFlg = "Y";
			} else {
				allocStsVO = dbDao.searchAllocStsByEquipment(bkgBlNoVO);
				if(allocStsVO != null){
					allocStsVOs.add(allocStsVO);
					if("M".equals(allocStsVO.getAlocSvcCd())){
						manualExistFlg = "Y";
					} else if("A".equals(allocStsVO.getAlocSvcCd())){
						autoExistFlg = "Y";
					}
				}			
			}					
			//commodity
			if(allocStsVOs.size() >= 2 && manualExistFlg.equals("Y")){
				mixRsnFlg = "Y";
			} else {
				allocStsVO = dbDao.searchAllocStsByCommodity(bkgBlNoVO);
				if(allocStsVO != null){
					allocStsVOs.add(allocStsVO);
					if("M".equals(allocStsVO.getAlocSvcCd())){
						manualExistFlg = "Y";
					} else if("A".equals(allocStsVO.getAlocSvcCd())){
						autoExistFlg = "Y";
					}
				}			
			}			
			//customer
			if(allocStsVOs.size() >= 2 && manualExistFlg.equals("Y")){
				mixRsnFlg = "Y";
			} else {
				allocStsVO = dbDao.searchAllocStsByCustomer(bkgBlNoVO);
				if(allocStsVO != null){
					allocStsVOs.add(allocStsVO);
					if("M".equals(allocStsVO.getAlocSvcCd())){
						manualExistFlg = "Y";
					} else if("A".equals(allocStsVO.getAlocSvcCd())){
						autoExistFlg = "Y";
					}
				}			
			}

			if(allocStsVOs.size() >= 2){
				mixRsnFlg = "Y";
			}
			
			if(allocStsVOs.size() > 0){
				allocStsVO = allocStsVOs.get(0);
			}			
			if(allocStsVO != null){
				if(mixRsnFlg.equals("Y")){
					allocStsVO.setBkgAlocTpCd("X");
				}
				if("Y".equals(manualExistFlg)){
					alocPopFlg = "Y";					
				}
				if("Y".equals(manualExistFlg)){
					allocStsVO.setAlocSvcCd("M");
				} else {
					allocStsVO.setAlocSvcCd("A");
				}
			}
			
			String oriAlocStsCd = dbDao.searchAlocStsCdByBkgNo(bkgBlNoVO);
			int updCnt = dbDao.modifyAllocStatus(bkgBlNoVO, allocStsVO, account);
			
			List<BkgCntcPsonVO> bkgCntcPsonVOs = dbDao.searchBkgCntcPson(bkgBlNoVO);
			String rcvrEml = "";
			for(int i = 0; i < bkgCntcPsonVOs.size(); i++){
				if(bkgCntcPsonVOs.get(i).getBkgCntcPsonTpCd().equals("BK")){
					rcvrEml = bkgCntcPsonVOs.get(i).getCntcPsonEml();
				}
			}	
			// Standby Notice
			if( allocStsVO != null && allocStsVO.getAlocStsCd()!=null && "S".equals(allocStsVO.getAlocStsCd()) && "N".equals(alocPopFlg)
					&& ( oriAlocStsCd==null || "".equals(oriAlocStsCd) || oriAlocStsCd.equals("F") ) ){			
				// popUp 안뜨면서 ""->S, F->S 일 때 Stanby Notice 발송
				if(rcvrEml != null && rcvrEml.length() > 0){
					String custRefNoCtnt = dbDao.searchCustRefNoCtnt(bkgBlNoVO, "EBRF");
					bkgNtcHisVOs = eaiDao.sendStandByNotice(bkgBlNoVO, rcvrEml, account, custRefNoCtnt);
					allocStsChgVO.setBkgNtcHisVOs(bkgNtcHisVOs);
				}
				allocStsChgVO.setNtcKndCd("SB");
			}
			// Booking Reciept Notice
			else if((oriAlocStsCd!=null && oriAlocStsCd.equals("S") && (allocStsVO==null ||(allocStsVO.getAlocStsCd()!=null && allocStsVO.getAlocStsCd().equals("F"))))){
//				// S->F 일 때 Booking Reciept Notice 발송
//				// rcvrEml 에 값 있으면 SC 에서 Booking Reciept Notice 발송
//				if(rcvrEml != null && rcvrEml.length() > 0){
//					allocStsChgVO.setRcvrEml(rcvrEml);
//				}
				firmMsgFlg = "Y";// Reciep Notice 대신 메시지 보여줌
				allocStsChgVO.setNtcKndCd("BK");// SC 에서 Customer301, Vendor301
			}		
			
			log.debug("mixRsnFlg:"+mixRsnFlg+" alocPopFlg:"+alocPopFlg
					+" autoExistFlg:"+autoExistFlg+" manualExistFlg:"+manualExistFlg+" updCnt:"+updCnt);
			
			if(oriAlocStsCd != null){
				allocStsChgVO.setOriAlocStsCd(oriAlocStsCd);
			}else{
				allocStsChgVO.setOriAlocStsCd("");
			}
			if(allocStsVO!=null && allocStsVO.getAlocStsCd()!=null ){
				allocStsChgVO.setAlocStsCd(allocStsVO.getAlocStsCd());
			}else{
				allocStsChgVO.setAlocStsCd("F");
			}
			
			allocStsChgVO.setAlocPopFlg(alocPopFlg);
			allocStsChgVO.setFirmMsgFlg(firmMsgFlg);
			return allocStsChgVO;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    } catch(Exception ex) {
	    	log.error(ex.getMessage(),ex);
	    	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Allocation Status를 Change.<br>
	 * 
	 * @param AllocStsVO allocStsVO
	 * @param BkgBlNoVO bkgblNoVO
	 * @param SignOnUserAccount account
	 * @return AllocStsChgVO
	 * @throws EventException
	 */
	public AllocStsChgVO modifyAllocStatus(AllocStsVO allocStsVO, BkgBlNoVO bkgBlNoVO, SignOnUserAccount account) throws EventException{
		AllocStsChgVO allocStsChgVO = new AllocStsChgVO();
		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
		try {
			String oriAlocStsCd = dbDao.searchAlocStsCdByBkgNo(bkgBlNoVO);
			dbDao.modifyAllocStatus(bkgBlNoVO, allocStsVO, account);
			
			String firmMsgFlg = "N";
			allocStsChgVO.setFirmMsgFlg(firmMsgFlg);
			
			List<BkgCntcPsonVO> bkgCntcPsonVOs = dbDao.searchBkgCntcPson(bkgBlNoVO);
			String rcvrEml = "";
			for(int i = 0; i < bkgCntcPsonVOs.size(); i++){
				if(bkgCntcPsonVOs.get(i).getBkgCntcPsonTpCd().equals("BK")){
					rcvrEml = bkgCntcPsonVOs.get(i).getCntcPsonEml();
				}
			}	
			// F->S
			if( allocStsVO != null 
					&& allocStsVO.getAlocStsCd()!=null && "S".equals(allocStsVO.getAlocStsCd())
					&& (   oriAlocStsCd==null 
						|| oriAlocStsCd.equals("F") 
						|| ( oriAlocStsCd.equals("S") && allocStsVO.getBeforeAlocStsCd()!=null && !"S".equals(allocStsVO.getBeforeAlocStsCd()))
						)
				){	
				// Standby Notice
				if((allocStsVO.getStandbyNtcFlg()==null || !allocStsVO.getStandbyNtcFlg().equals("N"))){
					// null->S, F->S, 
					// F->S->S, ""->S->S (manual popup에서 저장) 일 때 Stanby Notice 발송 
					if(rcvrEml != null && rcvrEml.length() > 0){
						String custRefNoCtnt = dbDao.searchCustRefNoCtnt(bkgBlNoVO, "EBRF");
						bkgNtcHisVOs = eaiDao.sendStandByNotice(bkgBlNoVO, rcvrEml, account, custRefNoCtnt);
						allocStsChgVO.setBkgNtcHisVOs(bkgNtcHisVOs);
					}
				}
				allocStsChgVO.setNtcKndCd("SB");
			}
			// S->F
			else if( allocStsVO != null
					&& (oriAlocStsCd!=null && oriAlocStsCd.equals("S") 
					&& ((allocStsVO.getAlocStsCd()!=null && allocStsVO.getAlocStsCd().equals("F"))))){
				// Booking Reciept Notice (0102)
				if(allocStsVO.getReceiptNtcFlg()==null || !allocStsVO.getReceiptNtcFlg().equals("N")){
					// S->F 일 때 Booking Reciept Notice 발송
					// rcvrEml 에 값 있으면 SC 에서 Booking Reciept Notice 발송
					if(rcvrEml != null && rcvrEml.length() > 0){
						allocStsChgVO.setRcvrEml(rcvrEml);
					}
				}
				firmMsgFlg = "Y";//화면에서 메시지 표시
				allocStsChgVO.setNtcKndCd("BK");// SC 에서 Customer301, Vendor301 // e-BKG Notice (0229_01)
			}
			
			if(oriAlocStsCd != null){
				allocStsChgVO.setOriAlocStsCd(oriAlocStsCd);
			}else{
				allocStsChgVO.setOriAlocStsCd("");
			}
			if( allocStsVO != null && allocStsVO.getAlocStsCd() != null){
				allocStsChgVO.setAlocStsCd(allocStsVO.getAlocStsCd());
			}else{
				allocStsChgVO.setAlocStsCd("");
			}
			
			String ediHldFlg = dbDao.searchAlocStsCdByBkgNo(bkgBlNoVO);
			allocStsChgVO.setEdiHldFlg(ediHldFlg);	
			allocStsChgVO.setFirmMsgFlg(firmMsgFlg);
			return allocStsChgVO;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    } catch(Exception ex) {
	    	log.error(ex.getMessage(),ex);
	    	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}			
	}
	
	/**
	 * SI_FLG 를 조회한다.
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchSiFlg(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchSiFlg(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}	
	
	/**
	 * Full Return CY 를 지운다. <br>
	 * 
	 * @param BkgBlNoVO bkgblNoVO
	 * @throws EventException
	 */
	public void modifyFullRtnCy(BkgBlNoVO bkgBlNoVO) throws EventException{
		try {
			dbDao.modifyFullRtnCy(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * KR_CSTMS_CUST_TP_CD 를 Update 한다. <br>
	 * 
	 * @param BkgBlNoVO bkgblNoVO
	 * @param String mode
	 * @throws EventException
	 */
	public void modifyKrCstmsCustTpCd(BkgBlNoVO bkgBlNoVO, String mode) throws EventException{
		try {
			dbDao.modifyKrCstmsCustTpCd(bkgBlNoVO, mode);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * NO_RT_STS_CD 를 Update 한다. <br>
	 * 
	 * @param BkgBlNoVO bkgblNoVO
	 * @param String noRtStsCd
	 * @return int
	 * @param SignOnUserAccount account
	 * @throws EventException
	 */
	public int modifyNoRtStsCd(BkgBlNoVO bkgblNoVO, String noRtStsCd, SignOnUserAccount account) throws EventException {
		TransferOrderIssueBC	troBC		= new TransferOrderIssueBCImpl();
		TroMstVO troMstVO = new TroMstVO();
		
		try {
			// pol = kr & MTY_PKUP_YD_CD = 'KRSEL1H' & noRtStsCd = 'F'
			troMstVO = dbDao.SearchTroEdiRqst(bkgblNoVO);
			
			if (troMstVO!=null && noRtStsCd!=null && noRtStsCd.equals("F") ) {
				//troBC.createTroEdi(bkgblNoVO, troMstVO.getTroSeq(), "", troMstVO.getRtnTroFlg(),troMstVO.getOwnrTrkFlg(), account);
			}
			
			return dbDao.modifyNoRtStsCd(bkgblNoVO, noRtStsCd, account);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
			
	/**
	 * CUST_REF_NO_CTNT 를 조회한다.
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param String bkgRefTpCd
	 * @return String
	 * @exception EventException
	 */
	public String searchCustRefNoCtnt(BkgBlNoVO bkgBlNoVO, String bkgRefTpCd) throws EventException {
		try {
			return dbDao.searchCustRefNoCtnt(bkgBlNoVO, bkgRefTpCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);			
		}
	}		
	
	/**
	 * Doc User ID 수정<br>
	 * Doc User ID가 HOMEPAGE인 경우 사용자 ID를 업데이트 한다.<br>
	 * @author KIM JIN JOO
	 * @param String bkgNo
	 * @param String caFlg
	 * @param String usrId
	 * @exception EventException
	 */
	public void modifyDocUserId(String bkgNo ,String caFlg, String usrId) throws EventException{   
	    try {	    	
	    	dbDao.modifyDocUserId(bkgNo, caFlg, usrId);	    	 
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}
	
	
	/**
	 * bouble calling 시 vak skd yard chg notice 를 발송한다.<br>
	 * <br>
	 * @author 
	 * @param VslSkdYardCngNoticeVO vslSkdYardCngNoticeVO
	 * @param List<VslSkdCngDoubleCallEtcVO> vslSkdCngDoubleCallEtcVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void sendVskSkdYardCngNotice(VslSkdYardCngNoticeVO vslSkdYardCngNoticeVO, List<VslSkdCngDoubleCallEtcVO> vslSkdCngDoubleCallEtcVOs, SignOnUserAccount account) throws EventException{   
	    try {	    	
	    	eaiDao.sendVskSkdYardCngNotice(vslSkdYardCngNoticeVO, vslSkdCngDoubleCallEtcVOs, account);	    	 
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}
	}
	
	/**
	 * CA 를 통해 첫 배가 바뀌었는지 체크. <br>
	 * <br>
	 * @author 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @return String
	 * @exception EventException
	 */
	public String checkFirstVvdChgByCa(BkgBlNoVO bkgBlNoVO) throws EventException{
		try {
		 	// CA 를 통해 첫 배가 바뀌었는지 체크
			return dbDao.checkFirstVvdChgByCa(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);			
		}	
	}
	
	/**
	 * CA confirm 시에 BKG_ROLL_OVR 를 생성한다. <br>
	 * <br>
	 * @author 
	 * @param BkgBlNoVO bkgBlNoVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void modifyBkgRollOvrForCa(BkgBlNoVO bkgBlNoVO,SignOnUserAccount account) throws EventException{
		try {	    
			// 15. Roll Over 정보 수정
			dbDao.modifyBkgRollOvr(bkgBlNoVO, account);
				
			// 16. Roll Over 정보 저장
			dbDao.addBkgRollOvr(bkgBlNoVO, account);
		} catch (DAOException ex) {
			log.error("err " + ex.toString(), ex);
		throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
		throw new EventException(new ErrorHandler("BKG00391", new String[] {}).getMessage(), ex);
		}		
	}
	
	/**
	 * SPC 로직으로 Allocation Status를 업데이트한다.<br>
	 * 
	 * @param BkgBlNoVO bkgblNoVO
	 * @param AllocStsVO allocStsVO
	 * @param SignOnUserAccount account
	 * @return AllocStsChgVO
	 * @throws EventException
	 */
	public AllocStsChgVO modifyAllocStatusForBkg(BkgBlNoVO bkgBlNoVO, AllocStsVO allocStsVO, SignOnUserAccount account) throws EventException{
		
		AllocStsChgVO allocStsChgVO = new AllocStsChgVO();
		List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
		String firmMsgFlg = "";
		try {
			//String oriAlocStsCd = dbDao.searchAlocStsCdByBkgNo(bkgBlNoVO);
			AllocStsVO oriAllocStsVO = dbDao.searchAlocStsCdByBkgNo2(bkgBlNoVO);
			String oriAlocStsCd = (oriAllocStsVO.getAlocStsCd()!=null)?oriAllocStsVO.getAlocStsCd():"";
			String newAlocStsCd = oriAlocStsCd;
			String polCd = (oriAllocStsVO.getPolCd()!=null)?oriAllocStsVO.getPolCd():"";
			
			// 미주 적용 HardCodingTable 값 조회
			String usCaSpcAlocStr = "";
			String usCaFlg = "N";
			if(polCd.length()>1 && ("US".equals(polCd.substring(0,2))||"CA".equals(polCd.substring(0,2))) ){
				usCaFlg = "Y";
				BookingUtil util = new BookingUtil();
				BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
				bkgHrdCdgCtntListCondVO.setHrdCdgId("NO_RATE_PROC_CTR");			
				List<BkgHrdCdgCtntVO> usCaSpcAloc = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
				if(usCaSpcAloc.size() > 0){
					if("N".equals(usCaSpcAloc.get(0).getAttrCtnt7())){
						usCaSpcAlocStr = "N";
					}
				}
			}
			
			if("N".equals(usCaSpcAlocStr)){
				allocStsVO.setAlocStsCd(oriAlocStsCd);//history 안생김
			}else{//늘 갱신, 구분 로직은 SC 에 있음 
//			}else if(!"F".equals(oriAlocStsCd)
//					|| (allocStsVO.getChangeVvd()!=null && "Y".equals(allocStsVO.getChangeVvd()))// VVD 변경 된 경우엔 다시 바꿔 줌
//					){
				// 01. Allocation Status 업데이트
				dbDao.modifyAllocStatus(bkgBlNoVO, allocStsVO, account);
				newAlocStsCd = allocStsVO.getAlocStsCd();
				// 02. Booking History 생성 (SC에서 수행)
				
				// 03. Standby Notice 발송 (!S(!A)->S(A) 일 때)
				if( (!"S".equals(oriAlocStsCd) && !"A".equals(oriAlocStsCd)) 
					&& ("S".equals(allocStsVO.getAlocStsCd()) || "A".equals(allocStsVO.getAlocStsCd())) ){
					
//					List<BkgCntcPsonVO> bkgCntcPsonVOs = dbDao.searchBkgCntcPson(bkgBlNoVO);
					String rcvrEml = "";
//					for(int i = 0; i < bkgCntcPsonVOs.size(); i++){
//						if(bkgCntcPsonVOs.get(i).getBkgCntcPsonTpCd().equals("BK")){
//							rcvrEml = bkgCntcPsonVOs.get(i).getCntcPsonEml();
//						}
//					}	
					
					rcvrEml =  dbDao.searchBkgStaffEml(bkgBlNoVO,"SB");
					
					// Standby Notice
//					if(allocStsVO.getStandbyNtcFlg()!=null && "Y".equals(allocStsVO.getStandbyNtcFlg()) &&"N".equals(usCaFlg)){
					if("N".equals(usCaFlg) && (allocStsVO.getAlocSvcCd()==null || !"M".equals(allocStsVO.getAlocSvcCd()))){
					// 미주 auto 일 때 notice 발송 없음, manual 은 팝업에서 나감
					// 미주 및 Manual 일 땐 Notice 발송 없음, manual 은 팝업에서 나가기 때문	
						// null->S, F->S, 
						// F->S->S, ""->S->S (manual popup에서 저장) 일 때 Stanby Notice 발송 
						if(rcvrEml != null && rcvrEml.length() > 0){
							
							String custRefNoCtnt = dbDao.searchCustRefNoCtnt(bkgBlNoVO, "EBRF");
							bkgNtcHisVOs = eaiDao.sendStandByNotice2(bkgBlNoVO, rcvrEml, account, custRefNoCtnt);
						}
					}
				}else if("S".equals(oriAlocStsCd) && ("F".equals(allocStsVO.getAlocStsCd())) ){
					String rcvrEml = "";
					rcvrEml =  dbDao.searchBkgStaffEml(bkgBlNoVO,"SB");
					// Standby to frim Notice
					if("N".equals(usCaFlg)){
					// 미주는 auto 일 때 notice 발송 없음, manual 은 팝업에서 나감	
						if(rcvrEml != null && rcvrEml.length() > 0){
							String custRefNoCtnt = dbDao.searchCustRefNoCtnt(bkgBlNoVO, "EBRF");
							bkgNtcHisVOs = eaiDao.sendStandByToConfirmNotice(bkgBlNoVO, rcvrEml, account, custRefNoCtnt);
						}
					}
				}
				
				if( ("S".equals(oriAlocStsCd) || "A".equals(oriAlocStsCd)) 
						&& "F".equals(allocStsVO.getAlocStsCd()) ){
					firmMsgFlg = "Y";
				}
				// 04. EDI 발송 (S->F 일 때) (SC에서 수행)
			}
			// 05. 리턴값 세팅
			allocStsChgVO.setOriAlocStsCd(oriAlocStsCd);
			allocStsChgVO.setAlocStsCd(newAlocStsCd);
			allocStsChgVO.setBkgNtcHisVOs(bkgNtcHisVOs);
			allocStsChgVO.setFirmMsgFlg(firmMsgFlg);
			
			return allocStsChgVO;
			
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    } catch(Exception ex) {
	    	log.error(ex.getMessage(),ex);
	    	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}			
	}
	
	/**
	 * SPC 로직으로 Allocation Status를 업데이트한다.
	 * SPC 에서 호출하는 경우는 전부 F(Firm)<br>
	 * 
	 * @param String bkgNo
	 * @param SignOnUserAccount account
	 * @return boolean
	 * @throws EventException
	 */
	public boolean modifyAllocStatusForSpc(String bkgNo, SignOnUserAccount account) throws EventException{
		
		BookingHistoryMgtBC 	historyBC	= new BookingHistoryMgtBCImpl();
		GeneralBookingSearchBC  searchBC    = new GeneralBookingSearchBCImpl();
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		AllocStsVO allocStsVO = new AllocStsVO();
		boolean  rst = false;
		
		try {
			bkgBlNoVO.setBkgNo(bkgNo);
			bkgBlNoVO.setCaFlg("N");
			allocStsVO.setAlocStsCd("F");
			allocStsVO.setAlocSvcCd("");
			allocStsVO.setBkgAlocTpCd("");
			
//			String oriAlocStsCd = dbDao.searchAlocStsCdByBkgNo(bkgBlNoVO);
			AllocStsVO oriAllocStsVO = dbDao.searchAlocStsCdByBkgNo2(bkgBlNoVO);
			String oriAlocStsCd = (oriAllocStsVO.getAlocStsCd()!=null)?oriAllocStsVO.getAlocStsCd():"";
			String polCd = (oriAllocStsVO.getPolCd()!=null)?oriAllocStsVO.getPolCd():"";
			String usCaFlg = "N";
			if(polCd.length()>1 && ("US".equals(polCd.substring(0,2))||"CA".equals(polCd.substring(0,2))) ){
				usCaFlg = "Y";
			}
			
			// 01. Allocation Status 업데이트
			dbDao.modifyAllocStatus(bkgBlNoVO, allocStsVO, account);
			
			// 02. Booking History 생성
			if(!oriAlocStsCd.equals(allocStsVO.getAlocStsCd())){
				HistoryLineVO historyLineVO = new HistoryLineVO();
				historyLineVO.setUiId("ESM_SPC");			
				historyLineVO.setHisCateNm("Allocation Status");
				historyLineVO.setBkgNo(bkgBlNoVO.getBkgNo());
				historyLineVO.setCaFlg("N");
				historyLineVO.setCrntCtnt("F");
				historyLineVO.setPreCtnt(oriAlocStsCd);
				historyBC.createBkgHistoryLine(historyLineVO, account);
			}
			
			// 03. Standby Notice 발송은 해당 없음
			
			// 04. EDI 및 Mail 발송 (S->F 일 때)
			if( "S".equals(oriAlocStsCd) ){
				// vender301 전송 
				// Vender301ParamVO로 부터 EDI전송에 필요한 Parameter를 설정한다.
				List<BkgNtcHisVO> bkgNtcHisVOs = new ArrayList<BkgNtcHisVO>();
				Vender301ParamVO vender301ParamVO = new Vender301ParamVO(); 
				vender301ParamVO.setBkgBlNoVO(bkgBlNoVO);
				vender301ParamVO.setOldVvdVOs(null);
				vender301ParamVO.setOldQtyVOs(null);
				vender301ParamVO.setOldMtyPkupYdCd(null);
				vender301ParamVO.setBracCd("U");
				vender301ParamVO.setEdiKind("BT"); 
				vender301ParamVO.setAutoManualFlg("Y");
				List<BkgNtcHisVO> bkgNtcHisVOs2 = searchBC.createTmlBkgReceiptEdi(vender301ParamVO, account);	
				for(int i=0; i<bkgNtcHisVOs2.size(); i++){
					bkgNtcHisVOs.add(bkgNtcHisVOs2.get(i));
				}
				// customer301 전송 
				List<BkgNtcHisVO> bkgNtcHisVOs3 = searchBC.createCustBkgReceiptEdi(bkgBlNoVO, null, "Y", account);						
				for(int i=0; i<bkgNtcHisVOs3.size(); i++){
					bkgNtcHisVOs.add(bkgNtcHisVOs3.get(i));
				}
				
				// Standby to frim Notice
				if("N".equals(usCaFlg)){
				// 미주는 auto 일 때 notice 발송 없음, manual 은 팝업에서 나감	
					String rcvrEml = "";
					rcvrEml =  dbDao.searchBkgStaffEml(bkgBlNoVO,"SB");
					if(rcvrEml != null && rcvrEml.length() > 0){
						String custRefNoCtnt = dbDao.searchCustRefNoCtnt(bkgBlNoVO, "EBRF");
						List<BkgNtcHisVO> bkgNtcHisVOs4 = eaiDao.sendStandByToConfirmNotice(bkgBlNoVO, rcvrEml, account, custRefNoCtnt);
						for(int i=0; i<bkgNtcHisVOs4.size(); i++){
							bkgNtcHisVOs.add(bkgNtcHisVOs4.get(i));
						}
					}
				}
				
				// Booking Receip Notice 발송
				List<BkgCntcPsonVO> bkgCntcPsonVOs = dbDao.searchBkgCntcPson(bkgBlNoVO);
				String rcvrEml = "";
				for(int i = 0; i < bkgCntcPsonVOs.size(); i++){
					if(bkgCntcPsonVOs.get(i).getBkgCntcPsonTpCd().equals("BK")){
						rcvrEml = bkgCntcPsonVOs.get(i).getCntcPsonEml();
					}
				}	
				if(!rcvrEml.equals("")){
					String mrdNm = "ESM_BKG_5005G";
					BkgBlNoVO[] bkgBlNoVOs = {bkgBlNoVO};
					String[]    eml        = {rcvrEml};
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
					SignOnUserAccount account2 = new SignOnUserAccount("SYSTEM" ,"" ,"" ,""      ,""
			                ,""      ,"" ,"" ,"SYSTEM" ,""
			                ,"SYSTEM" ,"" ,"" ,""      ,""
			                ,""      ,"" ,"" ,""      ,""
			                ,""      ,""
								);
					List<BkgNtcHisVO> bkgNtcHisVOs5 = searchBC.sendBkgReceiptByEmail(bkgReceiptSendVO, "", account2);
					for(int i=0; i<bkgNtcHisVOs5.size(); i++){
						bkgNtcHisVOs.add(bkgNtcHisVOs5.get(i));
					}
				}
				historyBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_SPC");
			}
			rst = true;
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
	    } catch(Exception ex) {
	    	log.error(ex.getMessage(),ex);
	    	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return rst;
	}
	
	
	/**
	 *  Clause Lock을  관리한다.<br>
	 *
	 * @param 	BkgClauseLockVO[] bkgClauseLockVOs
	 * @param 	SignOnUserAccount account
	 * @exception EventException
	 */
    public void manageBkgClauseLock(BkgClauseLockVO[] bkgClauseLockVOs, SignOnUserAccount account) throws EventException {
        try {
            List<BkgClauseLockVO> insertVoList = new ArrayList<BkgClauseLockVO>();
            List<BkgClauseLockVO> updateVoList = new ArrayList<BkgClauseLockVO>();
            List<BkgClauseLockVO> deleteVoList = new ArrayList<BkgClauseLockVO>();
            if(bkgClauseLockVOs != null){
                for(int i = 0; i < bkgClauseLockVOs.length; i++) {
                    if(bkgClauseLockVOs[i].getIbflag().equals("I")) {

                    	bkgClauseLockVOs[i].setCreUsrId(account.getUsr_id());
                    	bkgClauseLockVOs[i].setUpdUsrId(account.getUsr_id());

                        insertVoList.add(bkgClauseLockVOs[i]);

                    } else if(bkgClauseLockVOs[i].getIbflag().equals("U")) {
                    	bkgClauseLockVOs[i].setUpdUsrId(account.getUsr_id());

                        updateVoList.add(bkgClauseLockVOs[i]);
                    } else if(bkgClauseLockVOs[i].getIbflag().equals("D")) {
                        deleteVoList.add(bkgClauseLockVOs[i]);
                    }
                }
                if(insertVoList.size() > 0) {
                	dbDao.addBkgClauseLock(insertVoList);
                }

                if(updateVoList.size() > 0) {
                    dbDao.modifyBkgClauseLock(updateVoList);
                }

                if(deleteVoList.size() > 0) {
                    dbDao.removeBkgClauseLock(deleteVoList);
                }            	
            }
        } catch(DAOException de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        } catch(Exception de) {
            log.error("err " + de.toString(), de);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
        }
    }
    
	/**
	 * Clause Lock 정보를 조회한다.
	 * @param String bkgNo
	 * @param String  cluzLckTpCd
	 * @return List<BkgClauseLockVOs>
	 * @throws EventException
	 */
	public List<BkgClauseLockVO> searchBkgClauseLock(String bkgNo, String  cluzLckTpCd) throws EventException {
		try {
			return dbDao.searchBkgClauseLock(bkgNo, cluzLckTpCd);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * COP의 UpdateBkg 메서드 call을 BackEndJob으로 처리
	 * 
	 * @author 
	 * @param String bkgNo
	 * @param String mapSeq
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String callCopUpdateBkgBackEnd(String bkgNo, String mapSeq, SignOnUserAccount account) throws EventException {
		CallCopUpdateBkgBackEndJob callCopUpdateBkgBackEndJob = new CallCopUpdateBkgBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			callCopUpdateBkgBackEndJob.setMethodName("updateBkg");
			callCopUpdateBkgBackEndJob.setBkgNo(bkgNo);
			callCopUpdateBkgBackEndJob.setMapSeq(mapSeq);

			return backEndJobManager.execute(callCopUpdateBkgBackEndJob, account.getUsr_id(), "callCopUpdateBkgBackEndJob");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * COP의 SplitBkg 메서드 call을 BackEndJob으로 처리
	 * 
	 * @author 
	 * @param String bkgNo
	 * @param String[] newBkgNoArr
	 * @param String[] copMapSeqArr
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String callCopSplitBkgBackEnd(String bkgNo, String[] newBkgNoArr, String[] copMapSeqArr, SignOnUserAccount account) throws EventException {
		CallCopUpdateBkgBackEndJob callCopUpdateBkgBackEndJob = new CallCopUpdateBkgBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			callCopUpdateBkgBackEndJob.setMethodName("splitBkg");
			callCopUpdateBkgBackEndJob.setBkgNo(bkgNo);
			callCopUpdateBkgBackEndJob.setNewBkgNoArr(newBkgNoArr);
			callCopUpdateBkgBackEndJob.setCopMapSeqArr(copMapSeqArr);

			return backEndJobManager.execute(callCopUpdateBkgBackEndJob, account.getUsr_id(), "callCopUpdateBkgBackEndJob");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * COP의 combineBkg 메서드 call을 BackEndJob으로 처리
	 * 
	 * @author 
	 * @param String[] combinedBkgNo
	 * @param String targetBkg
	 * @param List<CombineTroNewSeqVO> combineTroNewSeqVOs
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String callCopCombineBkgBackEnd(String[] combinedBkgNo, String targetBkg, List<CombineTroNewSeqVO> combineTroNewSeqVOs, SignOnUserAccount account) throws EventException {
		CallCopUpdateBkgBackEndJob callCopUpdateBkgBackEndJob = new CallCopUpdateBkgBackEndJob();
		BackEndJobManager backEndJobManager = new BackEndJobManager();

		try {
			callCopUpdateBkgBackEndJob.setMethodName("combineBkg");
			callCopUpdateBkgBackEndJob.setCombinedBkgNo(combinedBkgNo);
			callCopUpdateBkgBackEndJob.setTargetBkg(targetBkg);
			callCopUpdateBkgBackEndJob.setCombineTroNewSeqVOs(combineTroNewSeqVOs);

			return backEndJobManager.execute(callCopUpdateBkgBackEndJob, account.getUsr_id(), "callCopUpdateBkgBackEndJob");
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * china bkg no가 기존에 생성되어 있는지 조회한다.<br>
	 * 
	 * @param 		BkgBlNoVO bkgBlNoVO
	 * @return 		String
	 * @exception 	EventException
	 */
	public String searchChnBkgNoExist(BkgBlNoVO bkgBlNoVO) throws EventException {
		try {
			return dbDao.searchChnBkgNoExist(bkgBlNoVO);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * Bkg Reactive 화면(0078) 조회.
	 * @param String bkgNo
	 * @param String tVvd
	 * @param String polCd
	 * @param String podCd
	 * @param String sts
	 * @param String cxlRsn
	 * @return List<BkgReactivateVO>
	 * @exception DAOException
	 */
	public List<BkgReactivateVO> searchBkgReactivate(String bkgNo, String tVvd, String polCd, String podCd, String sts, String cxlRsn) throws EventException {
		try {
			return dbDao.searchBkgReactivate(bkgNo, tVvd, polCd, podCd, sts, cxlRsn);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * BKG black 키워드 리스트에 걸리는지 check한다
	 * @param String custNm
	 * @return String
	 * @exception EventException
	 */
	public String checkBlockCustName(String custNm) throws EventException{
		try {
			return dbDao.checkBlockCustName(custNm);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * ESM_BKG_0090 <br>
	 * 지정된 Contract No에 맞는 Stowage Code인지 여부를 체크<br>
	 * @param stwgCd
	 * @param ctrtNo
	 * @return String
	 * @exception EventException
	 */
	public String validateStwgCdbyCtrtNo(String stwgCd, String ctrtNo) throws EventException{

		BookingUtil	util = new BookingUtil();
		String checkFlg = "N";
		String hrdCdgId = "";
		
		try {
			
			if("OBSS".equals(stwgCd)){
				hrdCdgId = "STWG_OBSS";
			} else if("OLBS".equals(stwgCd)){
				hrdCdgId = "STWG_OBLS";
			} else if("OLBL".equals(stwgCd)){
				hrdCdgId = "STWG_OLBL";
			}
			
			if("".equals(hrdCdgId)){
				return "Y";
			}
			
			BkgHrdCdgCtntListCondVO bkgHrdCdgCtntListCondVO = new BkgHrdCdgCtntListCondVO();
			bkgHrdCdgCtntListCondVO.setHrdCdgId(hrdCdgId);
			bkgHrdCdgCtntListCondVO.setAttrCtnt1("SC_NO");
			bkgHrdCdgCtntListCondVO.setAttrCtnt2(ctrtNo);
			List<BkgHrdCdgCtntVO> hrdCdgList = util.searchHardCoding(bkgHrdCdgCtntListCondVO);
			if(hrdCdgList != null && hrdCdgList.size() > 0){
				checkFlg = "Y";
			}
			
			return checkFlg;
			
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
	
	/**
	 * RFA Holder Name이 shpr / cnee / freight forwarder 셋 중 어딘가에 있는지 체크.
	 * @param bkgNo
	 * @param rateFlg
	 * @return List<String>
	 * @throws EventException
	 */
	public List<String> searchRFAHolderNameByShprCneeFF(String bkgNo, String rateFlg) throws EventException{
		
		List<String> list = new ArrayList<String>();
		try {
			list = dbDao.searchRFAHolderNameByShprCneeFF(bkgNo, rateFlg);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        } catch(Exception ex) {
        	log.error(ex.getMessage(),ex);
        	throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);			
		}
		
		return list;
	}
	
	/**
	 * Export Ref.란에 RFA Holder Name을 자동 Copy.
	 * @param bkgNo
	 * @param rfaHolderNm
	 * @return void
	 * @throws EventException
	 */	
	public void modifyExportRefNmByRfaHolderNm(String bkgNo, String rfaHolderNm) throws EventException{

		try {
			dbDao.modifyExportRefNmByRfaHolderNm(bkgNo, rfaHolderNm);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);		
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * R-BKG -> Firm 변경시 Notice 대상인지 체크한다.
	 * @param String bkgNo
	 * @return String
	 * @exception EventException
	 */
	public String searchConfirmBookingNotice(String bkgNo) throws EventException{
		try {
			return dbDao.searchConfirmBookingNotice(bkgNo);
		} catch (DAOException ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		} catch (Exception de) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), de);
		}
	}
}