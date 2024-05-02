/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BlRatingSC.java
 *@FileTitle : Exchange Rate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.18
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.06.18 김영출
 * 1.0 Creation

=========================================================
 * History
 * 2010.11.08 이일민 [CHM-201005869-01] Collection Office / Code자동 업데이트 관련 수정 요청 (Customer Code 변경 및 B/L Issue 화면 연동)
 * 2010.11.22 이일민 [CHM-201005869-01] Collection Office / Code자동 업데이트 관련 수정 요청 (Customer Code 변경 및 B/L Issue 화면 연동) - 파라미터 추가
 * 2011.03.03 정선용 [CHM-201109023-01] Booking 의 Volumn 과 Container Volumn 이 일치 하지 않는 경우 Application Date 를 빨강색으로 표시
 * 2011.04.18 이일민 [CHM-201110112] BKG HISTORY 추가 요청 - bill type change 
 * 2011.07.14 김진승 [CHM-201111820] Split 03-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
 * 2011.10.20 정선용 [CHM-201113441-01] BKG 화면의 C.OFC 및 C.REP SELECT POPUP 추가 요청
 * 2012.04.26 김진주 [CHM-201216859] [BKG/DOC - Revenue Audit System] 미주발 S/C B/L OFT 자동심사
 * 2012.06.13 김진주 [CHM-201217633] 구주 Hinterland 업무 개선 T/F 
 * 2012.06.20 김진주 [CHM-201217633] 구주 Hinterland 업무 개선 T/F
 * 2012.07.02 조정민 [CHM-201218333] BKG Charge 화면에 S/C No 입력및 저장시 Validation 추가
 * 2012.10.05 조정민 [CHM-201219854] [BKG] BKG 생성시 S/C 에 운임 조회 후 부재시 G/W 메일 SALES REP/PRICING STAFF 전송 기능 추가 
 * 2012.10.18 조정민 [CHM-201220680] s/c information 화면에 scope 추가로 복수 scope 일때 user select 후 조회토록 로직 변경
 * 2012.11.06 조정민 [CHM-201220857] Charge의 RFA information 화면에 Scope 정보 추가 요청 (S/C information과 동일)
 * 2012.11.29 조정민 [CHM-201221300] TAA 계약 존재시 bkg 생성및 변경시점 Rate 유무 체크 및 G/W 연계 요청
 * 2012.12.12 조정민 [CHM-201221699] Split 01-bkg 생성및 변경시 운임 체크 경고문 발생시 BST에 Rate check status 컬럼 추가 및 조회
 * 2012.12.18 김진주 [CHM-201220395-04] Add-on management T/F
 * 2013.04.19 김진주 [CHM-201323704] [Charge Adjustment] 팝업 개발 및 오토레이팅 연계 요청
 * 2013.04.24 김진주 [CHM-201323001] [BKG/DOC - Revenud Audit System] S/C 적용 B/L 자동심사기능 개발
 * 2013.05.27 김진주 [CHM-201324374] [TMO - Surcharge 종합 시스템 구축 ] Surcharge tariff 오토레이팅 배치 로직 요청
 * 2017.08.24 김동호 [CSR #1886] RFA HOLDER AUTO COPY 요청
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryTableVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.ManualSurchargeVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.OfcChgProcVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.AllocStsChgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.hanjin.apps.alps.esm.bkg.common.WordWarp;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBC;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBCImpl;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FrtCltLstVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.RfaOftAutoRatingBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.RfaOftAutoRatingBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.ScOftAutoRatingBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.ScOftAutoRatingBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.TaaOftAutoRatingBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.TaaOftAutoRatingBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.SurchargeAutoRatingBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.SurchargeAutoRatingBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg007908Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg0264Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg0265Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg0269Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg0270Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg0739Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg0771Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg0945Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg0961Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg1043Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg1076Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg1077Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg1084Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg1090Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg2006Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg1600Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg1601Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg1604Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.event.EsmBkg1605Event;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration.BlRatingDBDAO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgChgRateVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgCntrVgmInfoListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgModiOfcPrcVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.BkgQtyOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeRemarkVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CntrRtVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.CoveredBlListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ExchangeRateVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.GroupRatingVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.PpdCctCustInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.PpdCctCustOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateMainInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RateOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RfaInformInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.RfaInformOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScInformInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScInformOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScNoteInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScNoteOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ScOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchFocByFreightListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchRatingApplyDateVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchRfaOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchScOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchTaaOftAutoratingListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.SearchTpbInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.TaaInformInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.TaaInformOutVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAdjustmentVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.InvIfDiffVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ServiceScopeVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.OrganizationChartVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAmendAuthRequestVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAmendAuthVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAmendAuthDetailVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAmendAuthRefUserVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.ChargeAmendAuthRequestListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBCImpl;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo.EmailPpdInfoVO;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.basic.UnmatchBLBC;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.basic.UnmatchBLBCImpl;
import com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo.UnmatchBLVO;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBC;
import com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.BkgBookingVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.MasBkgComIfVO;

/**
 * NIS2010-BlRating Business Logic ServiceCommand - NIS2010-BlRating 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Kim Youngchul
 * @see BlRatingDBDAO
 * @since J2EE 1.6
 */
 
public class BlRatingSC extends ServiceCommandSupport {

    // Login User Information
    private SignOnUserAccount account = null;

    /**
     * BlRating system 업무 시나리오 선행작업<br>
     * ESM_BKG_0945업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        log.debug("BlRatingSC 시작");
        try {
            // 일단 comment --> 로그인 체크 부분
            account = getSignOnUserAccount();
        } catch(Exception e) {
            log.error(e.getLocalizedMessage());
        }
    }
 
    /**
     * BlRating system 업무 시나리오 마감작업<br>
     * ESM_BKG_0945 업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        log.debug("BlRatingSC 종료");
    }

    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * NIS2010-BlRating system 업무에서 발생하는 모든 이벤트의 분기처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        // RDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = null;
//        log.debug("::CALL:: BlRatingSC : " + e.getEventName()+"::"+e.getFormCommand());

        // SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
        if(e.getEventName().equalsIgnoreCase("EsmBkg0961Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchPayerCode(e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EsmBkg0270Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchScNote(e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EsmBkg0265Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchChargeRemark(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageChargeRemark(e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EsmBkg0264Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchQtyForRate(e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EsmBkg0269Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchScInform(e);
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchScInformList(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
            	eventResponse = manageScInformList(e);
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
            	eventResponse = searchCmdt(e); 
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
            	eventResponse = searchScSurcharge(e); 
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)){
            	eventResponse = searchScOftPrecheckResult(e); 
            }
/*            
        } else if(e.getEventName().equalsIgnoreCase("EsmBkg0700Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {

            }
*/
        } else if(e.getEventName().equalsIgnoreCase("EsmBkg0771Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchCoveredBl(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageCoveredBl(e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EsmBkg0739Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchRfaInform(e);
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchRfaInfomList(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
            	eventResponse = manageRfaInformList(e);
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
            	eventResponse = searchRfaSurcharge(e);
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)){
            	eventResponse = searchRfaOftPrecheckResult(e);  
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCH07)){
                eventResponse = searchBkgCntrVGMInfoList(e);  
            }
        } else if(e.getEventName().equalsIgnoreCase("EsmBkg0945Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchXchRt(e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EsmBkg007908Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchRateBkgDefault(e);
			}else
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchRate(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageRate(e);
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchAmdtSeq(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchTPFSurcharge(e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EsmBkg1043Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchCntrRate(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageCntrRate(e);
            } else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
                eventResponse = distributeCntrRate(e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EsmBkg1076Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchTaaInform(e);
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchTaaInformList(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
            	eventResponse = manageTaaInformList(e);
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
            	eventResponse = searchCmdt(e); 
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
            	eventResponse = searchTaaSurcharge(e); 
            } else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)){
            	eventResponse = searchTaaOftPrecheckResult(e); 
            }
        } else if(e.getEventName().equalsIgnoreCase("EsmBkg1077Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchAppicationDate(e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg1084Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRateTpbInfo(e);
			}
		}
        else if (e.getEventName().equalsIgnoreCase("EsmBkg1090Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchChargeAdjustment(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
            	eventResponse = modifyDHFAdjustment(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
            	eventResponse = modifyDDCAdjustment(e);
            }
		}
        else if (e.getEventName().equalsIgnoreCase("EsmBkg2006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceInterfaceDifference(e);
			}
		}
        else if (e.getEventName().equalsIgnoreCase("EsmBkg1600Event")) {
        	log.debug("ESM_BKG_1600 SC  START");
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
            	log.debug("ESM_BKG_1600 SC  SEARCH");
        		eventResponse = initChargeAmendRequest(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
            	log.debug("ESM_BKG_1600 SC  MULTI");
        		eventResponse = createChargeAmendAuthRequest(e);
        	}
        }
        else if(e.getEventName().equalsIgnoreCase("EsmBkg1601Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchChargeAmendAuthRequestList(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
        		eventResponse = approveChargeAmendAuthRequest(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
        		eventResponse = rejectChargeAmendAuthRequest(e);
        	} else {
        		eventResponse = initChargeAmendRequestList(e);
        	}
        }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg1604Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchOrganizationChart(e);
        	}        	
        }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg1605Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchGroupRatingList(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
        		eventResponse = modifyGroupRatingList(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
        		eventResponse = manageGroupRatingList(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
        		eventResponse = initGroupRating(e);
        	}
        }
        return eventResponse;
    }

    /**
     * EsmBkg0269Event 조회 이벤트 처리<br>
     * Freight & Charge_S/C Information 를 조회한다<br>
     *  
     * @author LEE JIN SEO
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchScInformList(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == searchScInformList SEARCH caflag]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ScOftAutoRatingBC command = new ScOftAutoRatingBCImpl();

        EsmBkg0269Event event = (EsmBkg0269Event) e;
        List<SearchScOftAutoratingListVO> list = null;

        /* PRC 변수 정의 
         *  v_bkg_no    IN BKG_BOOKING.BKG_NO%TYPE   ,
   		 *	v_ca_flg    IN VARCHAR2          ,
         *	v_ctrt_no    IN VARCHAR2          ,
         *	v_rt_aply_dt  IN VARCHAR2          ,
         *	v_svc_scp_cd  IN BKG_BOOKING.SVC_SCP_CD%TYPE ,
         *	v_cmdt_cd    IN BKG_BOOKING.CMDT_CD%TYPE  ,
         * */
        
        String bkg_no = event.getBkg_no();
        String caflag = event.getCaflag();
        String scpcd  = event.getScpcd();
        String cmdtcd = event.getCmdtcd();
        String rtaplydt = event.getrtAplyDt();
        String scNo = event.getscNo();
        
        try {
        	/* (1) TPE, TJE, MXE, ACE => TPE => TPS
			 * (2) TPW,      MXW, ACW => TPW => TPS
			 * (3) TAE, ASE, SAS => TAE  (2012.6.13 부로 MME 삭제됨)
			 * (4) TAW, ASW, SAN    => TAW
			 * (5) OTHER        => ETC
        	 */
        	if("TPE".equals(scpcd)|"TPW".equals(scpcd)|"TJE".equals(scpcd)|"MXE".equals(scpcd)|"ACE".equals(scpcd)|"MXW".equals(scpcd)|"ACW".equals(scpcd)){
        		 list = command.searchScTPSOftAutoratingList(bkg_no,caflag,scNo,rtaplydt,scpcd,cmdtcd,"");	
        	
        	}else if("TAE".equals(scpcd)|"ASE".equals(scpcd)|"SAS".equals(scpcd)){

        		list = command.searchScTAEOftAutoratingList(bkg_no,caflag,scNo,rtaplydt,scpcd,cmdtcd,"");	
        	
        	}else if("TAW".equals(scpcd)|"ASW".equals(scpcd)|"SAN".equals(scpcd)){
        		
       		 	list = command.searchScTAWOftAutoratingList(bkg_no,caflag,scNo,rtaplydt,scpcd,cmdtcd,"");	
        	
        	}else{
        		
       		 	list = command.searchScETCOftAutoratingList(bkg_no,caflag,scNo,rtaplydt,scpcd,cmdtcd,"");
       		 	
        	}
        	// 결과값 셋팅 
            eventResponse.setRsVoList(list);
     	
       	/* Amount 로직 ScOftAutoRatingBCImpl 에 구현 */
            
        } catch(Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchScInformList SEARCH ]==========");
        return eventResponse;
    }
    /**
     * EsmBkg0269Event Surcharge Insert 이벤트 처리<br>
     * 0269에서 조회된 Grid 항목을 저장한다<br>
     * 
     * @author LEE JIN SEO
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchCmdt(Event e )throws EventException{
        log.debug("[START:: searchCmdt == searchCmdt SEARCH cmdt]==========");
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0269Event event = (EsmBkg0269Event) e;
    	BookingUtil command = new BookingUtil();
    	
    	String cmdtnm = "";
    	String repcmdtcd = "";
    	String repcmdtnm = "";
    	String cmdt = event.getCmdtcd(); 	
    	cmdtnm =  command.searchMdmCmdtDesc(cmdt);
    	repcmdtcd = command.searchMdmCmdt(cmdt);
    	repcmdtnm = command.searchRepCmdtNm(repcmdtcd);
    	eventResponse.setETCData("cmdtnm", cmdtnm);
    	eventResponse.setETCData("repcmdtcd", repcmdtcd);
    	eventResponse.setETCData("repcmdtnm", repcmdtnm);
    	log.debug("repcmdtcd"+repcmdtcd);
    	return eventResponse;
    	
    }
    
    
    /**
     * EsmBkg0269Event Surcharge Insert 이벤트 처리<br>
     * 0269에서 조회된 Grid 항목을 저장한다<br>
     * 
     * @author LEE JIN SEO
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse manageScInformList(Event e) throws EventException {
    	log.debug("[START:: BlRatingSC == manageScInformList Surcharge Start]==========");
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0269Event  event = (EsmBkg0269Event) e; 
        ScOftAutoRatingBC command = new ScOftAutoRatingBCImpl();
        BlRatingBC command2 = new BlRatingBCImpl();
        
        SearchScOftAutoratingListVO[] vos = null;
        
        ScOftAutoratingListVO vo = new ScOftAutoratingListVO();
       
        
        List<SearchScOftAutoratingListVO> list2 = null;
        List<SearchScOftAutoratingListVO> surList = null;
        String bkg_no = event.getBkg_no(); 
        String caflag = event.getCaflag();
        String scpcd  = event.getScpcd();
        String cmdtcd = event.getCmdtcd();
        String ctrtTpCd = event.getctrtTpCd();
        String rtaplydt = event.getrtAplyDt();
        String rtAudTpCd = event.getRtAudTpCd(); 
        String ctrtNo = event.getscNo();
        String frtTermCd = event.getfrtTermCd();

               
        int fnl_frt_rt_amt = 0;
        
        
    	/* 성능향상을 위해 임시 테이블에  조회 데이터를 저장후 조회 한다. */
        try{
        	begin();
        	    	
        	command.manageScInformList(event.getSearchScOftAutoratingListVOS(), account.getUsr_id());
        	//실제 로직은 Insert 후 조회하나 유저는 Select 로 인식하기 때문에 메시지를 띄우지 않음 
        	//eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getMessage());
        	
        	log.debug("===VOS Length=="+event.getSearchScOftAutoratingListVOS().length);
        	vos = event.getSearchScOftAutoratingListVOS();
        	
        	vo.setBkgNo(bkg_no);
    		vo.setCaFlg(caflag);
    		vo.setCmdtCd(cmdtcd);
    		vo.setsvcScpCd(scpcd);
    		vo.setCtrtTpCd(ctrtTpCd);
    		vo.setRtAplyDt(rtaplydt);
    		vo.setRtAudTpCd(rtAudTpCd);
    		vo.setCtrtNo(ctrtNo);
    		vo.setFrtTermCd(frtTermCd);
    		for (int i = 0; i< vos.length; i ++){
    			fnl_frt_rt_amt += (int)Double.parseDouble(JSPUtil.getNullNoTrim(vos[i].getFnlFrtRtAmt(),"0"));
    		}

    		vo.setFnlFrtRtAmt(Integer.toString(fnl_frt_rt_amt));

    		
        	list2 = command.searchSurchargeAutoratingList(vo);
        	

        	//BKG_AUTO_RT_OCN_FRT_TMP TMP 테이블에  Insert 하므로 같은 트랙잰션 안에서 바로 Select 하고  Grid 에 뿌려줌 
//        	list2 = command.searchSurchargeAutoratingList(bkg_no, caflag, scpcd, cmdtcd, ctrtTpCd, rtaplydt);
        	
        	
            eventResponse.setRsVoList(list2);
            
//            list3 = command.searchSurchargePercentBaseChargeList();
        	//eventResponse.setRsVoList(list3); // Grid 에 표시 하지 않으므로  Return 필요 없음
            

        	surList = command.searchTariffSurchargeAutoratingList(vo);
        	command2.addTariffSurchargeRate(surList, caflag, account);
          
			commit();
        }catch(EventException ex){
        	rollback();
        	throw ex;
        }
        return eventResponse;
   	
    }
   	
    /**
     * EsmBkg0739Event 조회 이벤트 처리<br>
     * Freight & Charge_S/C Information 를 조회한다<br>
     * 
     * @author LEE JIN SEO
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
	private EventResponse searchRfaInfomList(Event e) throws EventException {
		log.debug("[START:: BlRatingSC == searchRfaInform SEARCH ]==========");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RfaOftAutoRatingBC command = new RfaOftAutoRatingBCImpl();

		EsmBkg0739Event event = (EsmBkg0739Event) e;

		List<SearchRfaOftAutoratingListVO> list = null;

		String bkg_no = event.getBkg_no();
		String caflag = event.getCaflag();
		String scpcd = event.getScpcd();
		String cmdtCd = event.getCmdtcd();
		String rtAplyDt = event.getRtaplydt();
		String rfaNo = event.getrfaNo();
		String hinterFlg = command.searchHinterlandApplyFlag(rtAplyDt, bkg_no, caflag);

		try {
			
			if ("FIC".equals(hinterFlg)) {
				list = command.searchRfaFICOftAutoratingList(bkg_no, caflag,
						rfaNo, rtAplyDt, scpcd, cmdtCd);
			} else if ("AEE".equals(scpcd) && "Y".equals(hinterFlg)) {
				list = command.searchRfaAEEOftAutoratingList(bkg_no, caflag,
						rfaNo, rtAplyDt, scpcd, cmdtCd);
			} else if ("AEW".equals(scpcd) && "Y".equals(hinterFlg)) {
				list = command.searchRfaAEWOftAutoratingList(bkg_no, caflag,
						rfaNo, rtAplyDt, scpcd, cmdtCd);
			} else {
				list = command.searchRfaOftAutoratingList(bkg_no, caflag,
						rfaNo, rtAplyDt, scpcd, cmdtCd);
			}
			eventResponse.setRsVoList(list);
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("[end:: BlRatingSC == searchRfaInform SEARCH ]==========");
		return eventResponse;
    }
    
    /**
     * EsmBkg0739Event Surcharge Insert 이벤트 처리<br>
     * 0739에서 조회된 Grid 항목을 저장한다<br>
     * 
     * @author LEE JIN SEO
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse manageRfaInformList(Event e) throws EventException{
    	log.debug("[START:: BlRatingSC == searchSurchargeRfaInform SEARCH ]==========");
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        ScOftAutoRatingBC command1 = new ScOftAutoRatingBCImpl();
        BlRatingBC command2 = new BlRatingBCImpl();
        EsmBkg0739Event event = (EsmBkg0739Event) e;
        
        List<SearchScOftAutoratingListVO> list2 = null;
        List<SearchScOftAutoratingListVO> surList = null;
        ScOftAutoratingListVO vo = new ScOftAutoratingListVO();
        
        String bkg_no = event.getBkg_no();
        String caflag = event.getCaflag();
        String scpcd  = event.getScpcd();
        String cmdtcd = event.getCmdtcd();
        String ctrtTpCd = event.getctrtTpCd();
        String rtaplydt = event.getRtaplydt();
        String rtAudTpCd = event.getRtAudTpCd(); 
        String ctrtNo = event.getrfaNo();
        String frtTermCd = event.getfrtTermCd();
        
        
        
        /* 성능향상을 위해 임시 테이블에  조회 데이터를 저장후 조회 한다. */
        try{
        	
        	begin();
        	for(int i =0; i< event.getSearchScOftAutoratingListVOS().length; i++){
        		event.getSearchScOftAutoratingListVOS()[i].setPrcGenSpclRtTpCd("S");
        	}
        	command1.manageScInformList(event.getSearchScOftAutoratingListVOS(),account.getUsr_id());
//			command.manageRfaInformList(event.getSearchRfaOftAutoratingListVOS(),account.getUsr_id());
        	//BKG_AUTO_RT_OCN_FRT_TMP TMP 테이블에  Insert 하므로 같은 트랙잰션 안에서 바로 Select 하고  Grid 에 뿌려줌 
//        	list2 = command1.searchSurchargeAutoratingList(bkg_no, caflag, scpcd, cmdtcd, ctrtTpCd,rtaplydt );
        	
          	
        	vo.setBkgNo(bkg_no);
    		vo.setCaFlg(caflag);
    		vo.setCmdtCd(cmdtcd);
    		vo.setsvcScpCd(scpcd);
    		vo.setCtrtTpCd(ctrtTpCd);
    		vo.setRtAplyDt(rtaplydt);
    		vo.setRtAudTpCd(rtAudTpCd);
    		vo.setCtrtNo(ctrtNo);
    		vo.setFrtTermCd(frtTermCd);
        	
        	list2 = command1.searchSurchargeAutoratingList(vo);
        	eventResponse.setRsVoList(list2);
        	
        	surList = command1.searchTariffSurchargeAutoratingList(vo);
        	command2.addTariffSurchargeRate(surList, caflag, account);
        	
        	commit();
        	
        }catch(EventException ex){
        	rollback();
        	throw ex;
        }
        
    	 return eventResponse;
    }
    
    /**
     * EsmBkg0269Event Surcharge Search03 이벤트 처리<br>
     * 0269에서 조회된 Grid 항목을 저장한다<br>
     * 
     * @author LEE JIN SEO
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    //OFT 가 없을 경우  Surcharge 만 넣는다 
    private EventResponse searchScSurcharge(Event e )throws EventException{
        log.debug("[START:: searchSurcharge == searchScSurcharge SEARCH03 ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ScOftAutoRatingBC command1 = new ScOftAutoRatingBCImpl();
        BlRatingBC command2 = new BlRatingBCImpl();
        EsmBkg0269Event event = (EsmBkg0269Event) e;
        
        List<SearchScOftAutoratingListVO> list2 = null;
        List<SearchScOftAutoratingListVO> surList = null;
        ScOftAutoratingListVO vo = new ScOftAutoratingListVO(); 
        
        String bkg_no = event.getBkg_no(); 
        String caflag = event.getCaflag();
        String scpcd  = event.getScpcd();
        String cmdtcd = event.getCmdtcd();
        String ctrtTpCd = event.getctrtTpCd();
        String rtaplydt = event.getrtAplyDt();
        String rtAudTpCd = event.getRtAudTpCd();
        String frtTermCd = event.getfrtTermCd();
        String ctrtNo = event.getscNo();
        try{
        	
        	begin();
    	  	vo.setBkgNo(bkg_no);
    		vo.setCaFlg(caflag);
    		vo.setCmdtCd(cmdtcd);
    		vo.setsvcScpCd(scpcd);
    		vo.setCtrtTpCd(ctrtTpCd);
    		vo.setRtAplyDt(rtaplydt);
    		vo.setRtAudTpCd(rtAudTpCd);
    		vo.setFrtTermCd(frtTermCd);
    		vo.setCtrtNo(ctrtNo);
    		
    		
        	list2 = command1.searchSurchargeAutoratingList(vo);
        	eventResponse.setRsVoList(list2);
        	
        	surList = command1.searchTariffSurchargeAutoratingList(vo);
        	command2.addTariffSurchargeRate(surList, caflag, account);

        	commit();
        	
        }catch(EventException ex){
        	rollback();
        	throw ex;
        }
        
    	 return eventResponse;
    }
    /**
     * EsmBkg0269Event Surcharge Search03 이벤트 처리<br>
     * 0269에서 조회된 Grid 항목을 저장한다<br>
     * 
     * @author LEE JIN SEO
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    //OFT 가 없을 경우  Surcharge 만 넣는다 
    private EventResponse searchRfaSurcharge(Event e )throws EventException{
        log.debug("[START:: searchSurcharge == searchRfaSurcharge SEARCH03 ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ScOftAutoRatingBC command1 = new ScOftAutoRatingBCImpl();
        BlRatingBC command2 = new BlRatingBCImpl();
        EsmBkg0739Event event = (EsmBkg0739Event) e;
        
        List<SearchScOftAutoratingListVO> list2 = null;
        List<SearchScOftAutoratingListVO> surList = null;
        ScOftAutoratingListVO vo = new ScOftAutoratingListVO(); 
        
        String bkg_no = event.getBkg_no();
        String caflag = event.getCaflag();
        String scpcd  = event.getScpcd();
        String cmdtcd = event.getCmdtcd();
        String ctrtTpCd = event.getctrtTpCd();
        String rtaplydt = event.getRtaplydt();
        String rtAudTpCd = event.getRtAudTpCd();  
        String ctrtNo = event.getrfaNo();

        try{
        	
        	begin();
        	vo.setBkgNo(bkg_no);
    		vo.setCaFlg(caflag);
    		vo.setCmdtCd(cmdtcd);
    		vo.setsvcScpCd(scpcd);
    		vo.setCtrtTpCd(ctrtTpCd);
    		vo.setRtAplyDt(rtaplydt);
    		vo.setRtAudTpCd(rtAudTpCd);
    		vo.setCtrtNo(ctrtNo);
    		
        	list2 = command1.searchSurchargeAutoratingList(vo);
        	eventResponse.setRsVoList(list2);
        	

        	surList = command1.searchTariffSurchargeAutoratingList(vo);
        	command2.addTariffSurchargeRate(surList, caflag, account);

        	commit();
        	
        }catch(EventException ex){
        	rollback();
        	throw ex;
        }
        
    	 return eventResponse;
    }
    
    /**
     * EsmBkg1076Event Surcharge Search03 이벤트 처리<br>
     * 1076에서 조회된 Grid 항목을 저장한다<br>
     * 
     * @author LEE JIN SEO
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    //OFT 가 없을 경우  Surcharge 만 넣는다 
    private EventResponse searchTaaSurcharge(Event e )throws EventException{
        log.debug("[START:: searchSurcharge == searchRfaSurcharge SEARCH03 ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ScOftAutoRatingBC command1 = new ScOftAutoRatingBCImpl();
        BlRatingBC command2 = new BlRatingBCImpl();
        EsmBkg1076Event event = (EsmBkg1076Event) e;
        
        List<SearchScOftAutoratingListVO> list2 = null;
        List<SearchScOftAutoratingListVO> surList = null;
        ScOftAutoratingListVO vo = new ScOftAutoratingListVO(); 
        
        String bkg_no = event.getBkg_no();
        String caflag = event.getCaflag();
        String scpcd  = event.getScpcd();
        String cmdtcd = event.getCmdtcd();
        String ctrtTpCd = event.getctrtTpCd();
        String rtaplydt = event.getrtAplyDt();
        String rtAudTpCd = event.getRtAudTpCd();  
        String ctrtNo = event.gettaaNo();

        try{
        	
        	begin();
        	vo.setBkgNo(bkg_no);
    		vo.setCaFlg(caflag);
    		vo.setCmdtCd(cmdtcd);
    		vo.setsvcScpCd(scpcd);
    		vo.setCtrtTpCd(ctrtTpCd);
    		vo.setRtAplyDt(rtaplydt);
    		vo.setRtAudTpCd(rtAudTpCd);
    		vo.setCtrtNo(ctrtNo);
    		
        	list2 = command1.searchSurchargeAutoratingList(vo);
        	eventResponse.setRsVoList(list2);
        	
        	surList = command1.searchTariffSurchargeAutoratingList(vo);
        	command2.addTariffSurchargeRate(surList, caflag, account);

        	commit();
        	
        }catch(EventException ex){
        	rollback();
        	throw ex;
        }
        
    	 return eventResponse;
    }
    
    
    /**
     * EsmBkg1076Event Surcharge Insert 이벤트 처리<br>
     * 1076에서 조회된 Grid 항목을 저장한다<br>
     * 
     * @author KIM TAE KYOUNG
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse manageTaaInformList(Event e) throws EventException{
    	log.debug("[START:: BlRatingSC == searchSurchargeTaaInform SEARCH ]==========");
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        ScOftAutoRatingBC command1 = new ScOftAutoRatingBCImpl();
        BlRatingBC command2 = new BlRatingBCImpl();
        EsmBkg1076Event event = (EsmBkg1076Event) e;

        List<SearchScOftAutoratingListVO> list2 = null;
        List<SearchScOftAutoratingListVO> surList = null;
        ScOftAutoratingListVO vo = new ScOftAutoratingListVO();
        
        String bkg_no = event.getBkg_no();
        String caflag = event.getCaflag();
        String scpcd  = event.getScpcd();
        String cmdtcd = event.getCmdtcd();
        String ctrtTpCd = event.getctrtTpCd();
        String rtaplydt = event.getrtAplyDt();
        String rtAudTpCd = event.getRtAudTpCd();
        String ctrtNo = event.gettaaNo();
        String frtTermCd = event.getfrtTermCd();
        
        /* 성능향상을 위해 임시 테이블에  조회 데이터를 저장후 조회 한다. */
        try{
        	begin();
        	for(int i =0; i< event.getSearchScOftAutoratingListVOS().length; i++){
        		event.getSearchScOftAutoratingListVOS()[i].setPrcGenSpclRtTpCd("S");
        		event.getSearchScOftAutoratingListVOS()[i].setPrcCmdtHdrSeq("0");
        		event.getSearchScOftAutoratingListVOS()[i].setPrcRoutSeq("0");
        		event.getSearchScOftAutoratingListVOS()[i].setPrcRtSeq("0");
        		
        	}
        	command1.manageScInformList(event.getSearchScOftAutoratingListVOS(), account.getUsr_id());
        	//실제 로직은 Insert 후 조회하나 유저는 Select 로 인식하기 때문에 메시지를 띄우지 않음 
        	//eventResponse.setUserMessage((String) new ErrorHandler("BKG00166",new String[]{}).getMessage());
        	
        	
        	vo.setBkgNo(bkg_no);
    		vo.setCaFlg(caflag);
    		vo.setCmdtCd(cmdtcd);
    		vo.setsvcScpCd(scpcd);
    		vo.setCtrtTpCd(ctrtTpCd);
    		vo.setRtAplyDt(rtaplydt);
    		vo.setRtAudTpCd(rtAudTpCd);
    		vo.setCtrtNo(ctrtNo);
    		vo.setFrtTermCd(frtTermCd);
    		
    		list2 = command1.searchSurchargeAutoratingList(vo);
        	

        	//BKG_AUTO_RT_OCN_FRT_TMP TMP 테이블에  Insert 하므로 같은 트랙잰션 안에서 바로 Select 하고  Grid 에 뿌려줌 
//        	list2 = command.searchSurchargeAutoratingList(bkg_no, caflag, scpcd, cmdtcd, ctrtTpCd, rtaplydt);
        	
        	
            eventResponse.setRsVoList(list2);
            
//            list3 = command.searchSurchargePercentBaseChargeList();
        	//eventResponse.setRsVoList(list3); // Grid 에 표시 하지 않으므로  Return 필요 없음
            
            
            surList = command1.searchTariffSurchargeAutoratingList(vo);
        	command2.addTariffSurchargeRate(surList, caflag, account);
          
            commit();
        }catch(EventException ex){
        	rollback();
        	throw ex;
        }
        
    	 return eventResponse;
    }
    
    /**
     * EsmBkg007908Event 저장 이벤트 처리<br>
     * rating 정보를 저장한다<br>
     * 
     * @author LEE JIN SEO
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse manageRate(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == manageRate update ]==========");
        
        GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        BookingUtil bookingUtil 			= new BookingUtil();
        BlRatingBC blRatingBC 				= new BlRatingBCImpl();
        CostAssignBC masCmd 				= new CostAssignBCImpl();
        GeneralBookingReceiptBC receiptBC	= new GeneralBookingReceiptBCImpl();
        BLDocumentationBLBC  bLDocumentationBLBC = new BLDocumentationBLBCImpl();
        BLIssuanceBC bLIssuanceBC 			= new BLIssuanceBCImpl();
        BookingHistoryMgtBC 	historyBC 	= new BookingHistoryMgtBCImpl();
        EsmBkg007908Event event 			= (EsmBkg007908Event) e;
        BkgChgRateVO[] bkgChgRateVOs 		= event.getBkgChgRateVOs();
        BkgChgRateVO[] bkgChgRateHisVOs 	= event.getBkgChgRateHisVOs();
        RateMainInfoVO[] rateMainInfoVOs	= event.getRateMainInfoVOs();
        String application_date 			= event.getApplication_date();
        
        
        String bkg_no 		= event.getBkg_no();
        String bl_no 		= event.getBl_no();
        String caflag 		= event.getCaflag();
        String m_covered_bl	= event.getCovered_bl();
        String autoRate 	= event.getAutoRate();
        String removeAll 	= event.getRemoveAll();
        
        //by 김태경  13자로로 입력하는 경우는 무조건 12자리로 처리한다.
        if(m_covered_bl != null && m_covered_bl.length()>0){
        	 if(m_covered_bl.length()>12) m_covered_bl = m_covered_bl.substring(0,12);
        }
              
        RateInVO rateInVO = new RateInVO();
        rateInVO.setCaflag(caflag);
        rateInVO.setAccount(account);
        rateInVO.setBkgChgRateVOs(bkgChgRateVOs);
        rateInVO.setRateMainInfoVOs(rateMainInfoVOs);
        rateInVO.setBkg_no(bkg_no);
        rateInVO.setBl_no(bl_no);
        rateInVO.setCovered_bl(m_covered_bl);
        rateInVO.setApplication_date(application_date);
        rateInVO.setAutoRate(autoRate);
        rateInVO.setRemoveAll(removeAll);
        try {
        	//[기능추가]bdr check 를 체크한다.
        	BkgBlNoVO bkgBlNoVo = new BkgBlNoVO();
            bkgBlNoVo.setBkgNo(bkg_no);
    		bkgBlNoVo.setCaUsrId(account.getUsr_id());
    		bkgBlNoVo = bookingUtil.searchBkgBlNoVO(bkgBlNoVo);
    		
            //Perpaid 금액 변경여부 확인을 위해 저장전 금액 조회
            String prePpdAmt = blRatingBC.searchPpdChgAmt(bkg_no);
    		
    		rateInVO.setCaflag(bkgBlNoVo.getCaFlg());//caFlag를 account의 usr_id와 비교

    		//초기 데이터를 저장한다. 
    		if(bkgChgRateHisVOs != null){
        		if(autoRate.equals("Y")&& bkgChgRateHisVOs.length >0){
    				//by 김태경  autorating history 남기기 
    		        RateInVO rateHisInVO = new RateInVO();
    		        rateHisInVO.setBkg_no(bkg_no);
    		        rateHisInVO.setBl_no(bl_no);
    		        rateHisInVO.setCaflag(caflag);
    		        rateHisInVO.setAccount(account);
    		        rateHisInVO.setBkgChgRateVOs(bkgChgRateHisVOs);
    				blRatingBC.autoRatingHistory(rateHisInVO);
    			}
    		}
    		/*
    		//[기능추가] RT_BL_TP_CD , FRT_TERM_CD, BKG_CTRT_TP_CD 값 체크  by 김태경
    		if( rateMainInfoVOs[0].getRtBlTpCd().length() == 0) {
    			throw new EventException((String)new ErrorHandler("BKG95017",new String[]{"RT_BL_TP_CD"}).getMessage());	                	
    		}
    		if( rateMainInfoVOs[0].getFrtTermCd().length() == 0) {
    			throw new EventException((String)new ErrorHandler("BKG95017",new String[]{"FRT_TERM_CD"}).getMessage());	                	
    		}
    		if( rateMainInfoVOs[0].getBkgCtrtTpCd().length() == 0) {
    			throw new EventException((String)new ErrorHandler("BKG95017",new String[]{"BKG_CTRT_TP_CD"}).getMessage());	                	
    		}
    		*/
        	//[기능추가]ppd_rcv_ofc_cd  office cd를 체크한다.
        	String existThird1  = bookingUtil.existThirdCode(rateMainInfoVOs[0].getPpdRcvOfcCd());
        	if(existThird1.equals("N")){
        		 throw new EventException((String)new ErrorHandler("BKG00905").getMessage());// Third Office is not available
        	}
        	//[기능추가]clt_ofc_cd  office cd를 체크한다.
        	String existThird2  = bookingUtil.existThirdCode(rateMainInfoVOs[0].getCltOfcCd());
        	if(existThird2.equals("N")){
        		 throw new EventException((String)new ErrorHandler("BKG00905").getMessage());//Third Office is not available
        	}

        	//[기능추가]getPpdPayrCustSeq  office cd를 체크한다.
    		String r_ppd_rcv_ofc_value = rateMainInfoVOs[0].getPpdPayrCntCd()+"|"+rateMainInfoVOs[0].getPpdPayrCustSeq();
        	String ppd_rcv_ofc  = bookingUtil.existPayerCode(r_ppd_rcv_ofc_value);
        	if(!ppd_rcv_ofc.equals("N")){
        		 throw new EventException((String)new ErrorHandler("BKG00458").getMessage());//  invalid customer code
        	}
        	
        	//[기능추가]getCltPayrCustSeq  office cd를 체크한다.
        	String r_clt_ofc_value = rateMainInfoVOs[0].getCltPayrCntCd()+"|"+rateMainInfoVOs[0].getCltPayrCustSeq();
        	String clt_ofc  = bookingUtil.existPayerCode(r_clt_ofc_value);
        	if(!clt_ofc.equals("N")){
        		 throw new EventException((String)new ErrorHandler("BKG00458").getMessage());//  invalid customer code
        	}
        	
        	//[10] BookingUtil::searchBkgNoByBlNo ( blNo ) 
        	//Master B/L지정시 Validation 여부 체크 기능추가 2009.10.08  by 신자영 
        	if(m_covered_bl != null && m_covered_bl.length()>0){
        		BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
                bkgBlNoIN.setBlNo(m_covered_bl);
                BkgBlNoVO bkgBlNoVO = bookingUtil.searchBkgBlNoVO(bkgBlNoIN);
                
                // Cancle인 경우' X' 저장할수 없다. 
                if(bkgBlNoVO == null || "X".equals(bkgBlNoVO.getBkgStsCd())) {
                	throw new EventException((String)new ErrorHandler("BKG08058",new String[]{m_covered_bl}).getMessage());	                	
                }
        	}
        	
            String rt_bl_tp_cd = rateMainInfoVOs[0].getRtBlTpCd();
            String rt_bl_tp_cd_old = rateMainInfoVOs[0].getRtBlTpCdOld();
       	 	//Covered BL로 변경시 하위 bl이 존재유무 판단 
            if("Y".equals(bkgBlNoVo.getCaFlg())) {
            	List<CoveredBlListVO> list = blRatingBC.searchCoveredBl(bkg_no, bl_no,caflag);
            	if( list.size() > 0){
            		throw new EventException((String)new ErrorHandler("BKG08170",new String[]{}).getMessage());
            	}
            }
            
            //10-27. DEL이 미주인 경우 S/C No에 따라 NVOCC인 경우 1 또는 2, Individual일 경우 3이 아니면 [BKG00308]을 보여주고 중지한다 ");
            String bkgStsCd = rateMainInfoVOs[0].getBkgStsCd();
			List<BkgBookingVO> bkgBookingVOs = bookingUtil.searchBookingSplitNo(bkg_no);
			if((null != bkgStsCd && !"A".equals(bkgStsCd)) && 
					   (null != rateMainInfoVOs[0].getDelCd() && "US".equals(rateMainInfoVOs[0].getDelCd().substring(0,2)))){
						if(null != bkgBookingVOs.get(0).getUsaCstmsFileCd() && !"".equals(bkgBookingVOs.get(0).getUsaCstmsFileCd())){
							if(null != bkgBookingVOs.get(0).getScNo() && bkgBookingVOs.get(0).getScNo().length() > 0 && !"DUM".startsWith(bkgBookingVOs.get(0).getScNo())){
								// 04. Sc Type 조회
								String scType = receiptBC.searchScType(rateMainInfoVOs[0].getScNo1(), bkgBlNoVo);
								// S/C Type이 I이면서 US Filer가 1 or 2라면 [BKG00308]을 보여주고 중지한다
								if("I".equals(scType) && ("1".equals(bkgBookingVOs.get(0).getUsaCstmsFileCd()) || "2".equals(bkgBookingVOs.get(0).getUsaCstmsFileCd()))){
									throw new EventException((String)new ErrorHandler("BKG00308").getMessage());
								}
								// S/C Type이 N이면서 US Filer가 3라면 [BKG00308]을 보여주고 중지한다
								if("N".equals(scType) && "3".equals(bkgBookingVOs.get(0).getUsaCstmsFileCd())){
									throw new EventException((String)new ErrorHandler("BKG00308").getMessage());
								}	
							}
						}
					}

            begin();
            
	        	//[11] IBookingHistoryMgtBC::searchOldBkgForHistory ( uiId , bkgBlNoVo )
				BookingHistoryMgtBC bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
				HistoryTableVO historyTableVO = bookingHistoryMgtBC.searchOldBkgForHistory("ESM_BKG_0079_08", bkgBlNoVo);

				OfcChgProcVO ofcChgProcVO = new OfcChgProcVO();
				ofcChgProcVO.setType("R");  //rating
				ofcChgProcVO.setCaFlg(caflag);
				ofcChgProcVO.setBkgNo(bkg_no);
				ofcChgProcVO.setPpdRcvOfcCd(rateMainInfoVOs[0].getPpdRcvOfcCd());
				ofcChgProcVO.setCltOfcCd(rateMainInfoVOs[0].getCltOfcCd());
				ofcChgProcVO = bookingUtil.searchOfcChgProc(ofcChgProcVO);

				//[12] IBDRCorrectionBC::createTempHist ( bkgBlNoVo , tempHistCd , caRsnCD , caRmk )
				
	            //[13] IBlRatingBC::manageRate ( rateOuts )
	            blRatingBC.manageRate(rateInVO);
	            
	            // PCT+1 이후 OFT 변경 모니터링
	            blRatingBC.modifyRtroactiveKindCd(bkg_no, rateMainInfoVOs[0].getRtroKndCd(), caflag);
	            //[2009.12.12-결함관리지침에 따른 이동]- generalbookingreceipt 로 이동
	            
	            /* UI 0771 과 동일 하게 Covered 인 경우 BL_CVRD_TP_CD은 C로 한다  */
	            if("C".equals(rt_bl_tp_cd)){
	            	rateMainInfoVOs[0].setBlCvrdTpCd("C");
	            }
	            /* Covered B/L 저장시 B/L 이 13 자리 이면 12 자리로 보정 */
	            if(rateMainInfoVOs[0].getMstCvrdBl().length() > 12)
	            {
	            	rateMainInfoVOs[0].setMstCvrdBl(rateMainInfoVOs[0].getMstCvrdBl().substring(0,12));
	            }
	            bLDocumentationBLBC.modifyChgRateBkgBlDoc(rateMainInfoVOs[0], caflag);
	            rateMainInfoVOs[0].setBlCvrdTpCd(""); // BL_CVRD_TP_CD 은 Covered 만 적용  
	            
	            //[2009.12.12-결함관리지침에 따른 이동]- generalbookingreceipt 로 이동
	            //2011.10.21 BKG 화면의 C.OFC 및 C.REP SELECT POPUP 추가 요청에 따른 계약관련 정보 업데이트 로직 추가 jsy
	            String ctrtOfcCd = JSPUtil.getNull(event.getCtrtOfcCd());
	            String ctrtSrepCd = JSPUtil.getNull(event.getCtrtSrepCd());
	            receiptBC.modifyChgRateBkgBooking(rateMainInfoVOs[0], caflag, ctrtOfcCd, ctrtSrepCd);
	            
	            receiptBC.modifyKrCstmsCustTpCd(bkgBlNoVo, "");
	            
                log.debug("=============================================");
                log.debug(" B/L Type 이 C 인 경우 Convered By 값을 Master B/L로 업데이트 한다 by 2010.1.21 김태경 ");
                log.debug("=============================================");
	            
	            if("M".equalsIgnoreCase(rt_bl_tp_cd)){
	            	// 자신 BKG_NO에 따른   mst_cvrd_bl_no, cobiz_auth_no를 null로 변경처리한다.by김태경  
					rateMainInfoVOs[0].setBkgNo(bkg_no);
					rateMainInfoVOs[0].setMstCvrdBl("");
					bLDocumentationBLBC.modifyChgRateBkgBlDoc(rateMainInfoVOs[0], caflag);
					
	            }else if("C".equalsIgnoreCase(rt_bl_tp_cd)){

	            	String m_bkg_no = bookingUtil.searchBkgNoByBlNo(m_covered_bl);
	            	
	            	//by김태경  2-1. BKG_NO, MASTER BL에 관한 BL_type을 M으로 변경한다.
	            	CoveredBlListVO  coveredBlListVO = new CoveredBlListVO();
	    			coveredBlListVO.setBkgNo(m_bkg_no);
	    			coveredBlListVO.setBlNo(m_covered_bl);		
	    			coveredBlListVO.setBlCvrdTpCd("M");
	    			coveredBlListVO.setUserId(account.getUsr_id());
					blRatingBC.modifyCoveredBl(coveredBlListVO,caflag);
					
					// 2-2. master bl에 관한 mst_cvrd_bl_no, cobiz_auth_no를 null로 변경처리한다. 
					rateMainInfoVOs[0].setBkgNo(m_bkg_no);
					rateMainInfoVOs[0].setMstCvrdBl("");
					rateMainInfoVOs[0].setCobizAuthNo("");
					bLDocumentationBLBC.modifyChgRateBkgBlDoc(rateMainInfoVOs[0], caflag);
	            }
	            
	            log.debug("=============================================");
                log.debug(" B/L Type 이 M,C가 아닌  경우  관련된 모든 테이블 관계를 끊는다. by 2010.3.9 김태경 ");
                log.debug("=============================================");
                // 변경된값이  M,C가 아니면서 
                if(!"M".equalsIgnoreCase(rt_bl_tp_cd)&& !"C".equalsIgnoreCase(rt_bl_tp_cd)){
                	//이전데이터가 M,C인경우 
            		if("M".equalsIgnoreCase(rt_bl_tp_cd_old)|| "C".equalsIgnoreCase(rt_bl_tp_cd_old)){
            			// master인경우  하위 bl을 모두 nomal상태로 변경한다. by 김태경
            			if("M".equalsIgnoreCase(rt_bl_tp_cd_old)){
            				blRatingBC.modifyChgRateMaster(rateMainInfoVOs[0],caflag);
            			}
            			//테이블관계를 끊는다.
            			bLDocumentationBLBC.modifyChgRateBkgBlDocMasterCovered(rateMainInfoVOs[0], rt_bl_tp_cd_old,caflag);
            		}
                }
                
                // POD/DEL: JOAQJ 인 Booking 중
                // SC경우, S/C Type 이 Non-BCO인 대상만 문구 자동 삽입
                // RFA경우, Shipper Code가 Non-BCO인 대상만 문구 자동 삽입
                if("Y".equals(rateMainInfoVOs[0].getJordanDesc())){
                	bLDocumentationBLBC.manageMndCmdtDescJOAQJ(bkg_no, account, caflag);
                }
				// 20140122, 류대영 미주 allocation status 관리
				String alocPopFlg = "N";
				String firmMsgFlg = "N";
				if((rateMainInfoVOs[0].getScNo1() != null && rateMainInfoVOs[0].getScNo1().length() > 0
						&& bkgBookingVOs.get(0).getScNo() != null && bkgBookingVOs.get(0).getScNo().length() > 0
						&& !rateMainInfoVOs[0].getScNo1().equals(bkgBookingVOs.get(0).getScNo()))
					||(rateMainInfoVOs[0].getRfaNo() != null && rateMainInfoVOs[0].getRfaNo().length() > 0
							&& bkgBookingVOs.get(0).getRfaNo() != null && bkgBookingVOs.get(0).getRfaNo().length() > 0
							&& !rateMainInfoVOs[0].getRfaNo().equals(bkgBookingVOs.get(0).getRfaNo()))){
					//alocPopFlg = receiptBC.manageAlocStatus(bkgBlNoVo, account);
					AllocStsChgVO allocStsChgVO = receiptBC.manageAlocStatus(bkgBlNoVo, account, "");
					List<BkgNtcHisVO> bkgNtcHisVOs = allocStsChgVO.getBkgNtcHisVOs();
					if (null!=bkgNtcHisVOs) {
						historyBC.createBkgNtcHis(bkgNtcHisVOs, "ESM_BKG_0079_08");
					}
					alocPopFlg = allocStsChgVO.getAlocPopFlg();
					firmMsgFlg = allocStsChgVO.getFirmMsgFlg();
					// Allocation Status History 
					if(allocStsChgVO != null){
						HistoryLineVO historyLineVO = new HistoryLineVO();
						historyLineVO.setUiId("ESM_BKG_0079_08");			
						historyLineVO.setHisCateNm("Booking Status");
						historyLineVO.setBkgNo(bkgBlNoVo.getBkgNo());
						historyLineVO.setCaFlg(bkgBlNoVo.getCaFlg());
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
				
    			BookingUtil utilCmd = new BookingUtil();    			
    			BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
    			bkgBlNoVO.setBkgNo(bkg_no);
//    			bkgBlNoVO.setBlNo(bl_no);	
    			bkgBlNoVO.setCaUsrId(account.getUsr_id());
    			bkgBlNoVO = utilCmd.searchBkgBlNoVO(bkgBlNoVO);
            
    			if (!"Y".equals(bkgBlNoVO.getCaFlg())) {
	            	log.debug("\n======= Auto EDI Send ======\n");
	            	List<BkgNtcHisVO> bkgNtcHisVOs = bLIssuanceBC.createDraftBlEdiAuto(bkgBlNoVO.getBkgNo(), "N",  account);
	
	    			if (bkgNtcHisVOs != null) {
	    				if (bkgNtcHisVOs.size() > 0) {
	    					bookingHistoryMgtBC.createBkgNtcHis(bkgNtcHisVOs,"ESM_BKG_0095");
	    					
							//philips 계약인 BKG에 대해서 DBL전송
							String philips = bLIssuanceBC.searchPhilipsCheck(bkgBlNoVO.getBkgNo());
							
			    			//philips 계약인 BKG에 대해서 DBL전송
			    			if(null!=philips && !"".equals(philips)){
			    				List<BkgNtcHisVO> bkgHisVOs = null;
			    				StringBuilder sbParam = new StringBuilder();
			    				
			    				String draftRemark = bLIssuanceBC.searchDraftRemark(bkgBlNoVO.getBkgNo());
	
			                	
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
			                    bkgHisVOs = bLIssuanceBC.sendDblWblByEmail(dblWblVOs, null, account);
			    				if(bkgHisVOs.size()>0){
			    					bookingHistoryMgtBC.createBkgNtcHis(bkgHisVOs,"ESM_BKG_0095");
			    				}
	
			    			}
	    				}
	    			}	   
    			}
                               
	            //[14] BookingHistoryMgtBC::manageBookingHistory ( '','','' )
	            bookingHistoryMgtBC.manageBookingHistory("ESM_BKG_0079_08", historyTableVO, account);
	            
	            // [2010.01.13 - AutoRating History 를 남기기 위하여 
	            // PerformaceReportBC - PeroformaceReportBCImpl 에 addAutoRtHistory 호출하여줌 ,
	            // Rate 에서 AutoRtHistory 로직 삭제 (2010.03.05 김태경)
	            // pRBC.addAutoRtHistory(bkg_no);

	            
	            
            /* 심영우 과장님 요청 2010.03.25
             * Charge 화면에서 Save 시 Collect 나 3rd Collect 가 0 값일 경우 
             * CargoRelease 쪽 을 호출 하여 EDI 전송 한다 
             * C/A 유무와 상관없이 Charge 에서 Save 된 경우 EDI를 전송 한다 2010.05.04
             * */
	        if(!"Y".equals(caflag)){   
	            List<SearchFocByFreightListVO>  searchFocByFreightListVO = null;
	                
	            searchFocByFreightListVO = blRatingBC.searchFocByFreightList(bkg_no,caflag);
	        	/* 에러 메시지 표시 */
				if(searchFocByFreightListVO == null){
					throw new EventException((String)new ErrorHandler("BKG08058").getMessage());
				}
	
				//Inbound Cr관련 로그
				utilCmd.addBkgLog("BKG_US_CGO_SWB", bkg_no, "11.Rate CHARGE START colAmt:"+searchFocByFreightListVO.get(0).getcolAmt()+", cctAmt:" + searchFocByFreightListVO.get(0).getcctAmt());			
				if(searchFocByFreightListVO.get(0).getcolAmt().equals("0") && searchFocByFreightListVO.get(0).getcctAmt().equals("0")){
	 
				log.debug("===============================================================");
				log.debug("[start][======== [CargoReleaseOrderBCImpl] :: setupFocByFreight ]");
				log.debug("===============================================================");
				
				CargoReleaseOrderBC cargoBC = new CargoReleaseOrderBCImpl();
				FrtCltLstVO frtCltLst = new FrtCltLstVO();
				/* BL No 는 12 자리 까지만 넘김 */
				frtCltLst.setBlNo(bl_no.substring(0,12));
				frtCltLst.setFrtCltFlg("Y");
				frtCltLst.setEvntOfcCd(account.getOfc_cd());
				frtCltLst.setEvntUsrId(account.getUsr_id());
				frtCltLst.setEvntDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
				frtCltLst.setCgorTeamCd("F");
				frtCltLst.setCgoEvntNm("CHARGE");
				
					try{
						utilCmd.addBkgLog("BKG_US_CGO_SWB", bkg_no, "12.Go");					
						cargoBC.setupFocByFreight(frtCltLst);
					}catch(Exception e1){
						log.debug("[end:: CargoReleaseOrderBC == manageRate update ]==========");
						log.error(e1.getMessage()); // 2011.07.15
					}
				} 
				utilCmd.addBkgLog("BKG_US_CGO_SWB", bkg_no, "Rate CHARGE END");
			
	        }
			
			if ("Y".equalsIgnoreCase(ofcChgProcVO.getOfcChgPpdProc()) || "Y".equalsIgnoreCase(ofcChgProcVO.getOfcChgCctProc())) {
				BkgModiOfcPrcVO bkgModiOfcPrcVO = new BkgModiOfcPrcVO();
				bkgModiOfcPrcVO.setInBkgNo(bkg_no);
				bkgModiOfcPrcVO.setInCaFlg(caflag);
				blRatingBC.callBkgModiIssOfcPrc(bkgModiOfcPrcVO);
			}
			
			
			/* [CSR #1886] RFA HOLDER AUTO COPY 요청
			 * 
			 * BKG Creation에서 Charge Tab 저장 시
			 * POL이 CN이고 RFA 인 경우
             * RFA Holder Name이 shpr / cnee / freight forwarder 셋 중 어디에도 없으면 Export Ref.란에 RFA Holder Name을 자동 Copy.
			 */
			if(event.getBkgPolCd() != null 
			        && "CN".equals(event.getBkgPolCd().substring(0, 2)) 
			        && "R".equals(event.getBkgCtrtTpCd())) {
			    
			    // RFA Holder Name이 shpr / cnee / freight forwarder 셋 중 어딘가에 있는지 체크.
                List<String> rfaChkList = receiptBC.searchRFAHolderNameByShprCneeFF(bkg_no, "Y");
                if(rfaChkList != null && rfaChkList.size() > 0){
                    String rfaHolderNm = rfaChkList.get(0);
                    String existsRfaFlg = rfaChkList.get(1);
                    
                    //어디에도 없으면 Export Ref.란에 RFA Holder Name을 자동 Copy
                    if("N".equals(existsRfaFlg)){
                        receiptBC.modifyExportRefNmByRfaHolderNm(bkg_no, rfaHolderNm);
                    }
                }
			}
			// [CSR #1886] 끝
			
			
            commit();			
            //[22] __COA::interfaceToCoa ( bkgBlNoVo )
            
            begin();
            
            /* COA */
            if(!"Y".equals(caflag)){                
                MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
                masBkgComIfVo.setBkgNo(bkg_no);
                masBkgComIfVo.setCostSrcSysCd("BKG");
                masBkgComIfVo.setIfRmk("Manage Rate");
                masBkgComIfVo.setCreUsrId(account.getUsr_id());
                masBkgComIfVo.setUpdUsrId(account.getUsr_id());
                masCmd.modifyMasCommonInterface(masBkgComIfVo);	
                
                // Back End Job으로 호출 
                //[21] IBookingARCreationBC::interfaceBKGARInvoiceToINV ( bkgIfVo )
	                BookingARCreationBC bookingARCreationBC = new BookingARCreationBCImpl();
	                ARBkgInterfaceCreationVO bkgIfVo = new ARBkgInterfaceCreationVO();
	                bkgIfVo.setBkgNo(bkg_no);
	                bkgIfVo.setManDivInd("B");
	                bkgIfVo.setUserId(account.getUsr_id());
	                bookingARCreationBC.interfaceBKGARInvoiceToINV(bkgIfVo);
	                
	                bkgBlNoVO.setBkgNo(bkg_no);
	                bkgBlNoVO.setBlNo(bl_no);	
	                bkgBlNoVO.setCaUsrId(account.getUsr_id());
	                blRatingBC.distributeCntrRate(bkgBlNoVO.getBkgNo(), account);      
            }
            
   		
			//Tariff Surcharge Rating 결과 저장
//			manageTariffSurcharge(e);
			

            //[22] __COA::interfaceToCoa ( bkgBlNoVo )
            
            
            //Perpaid 금액 변경시 e-mail 전송로직 시작
            String postPpdAmt = blRatingBC.searchPpdChgAmt(bkg_no);
            if(!prePpdAmt.equals(postPpdAmt)){
            	// BL Release 담당자 email 조회
            	String usrEml = blRatingBC.searchPpdChgRlsEmail(bkg_no);
            	
            	if(!usrEml.equals("")){
            		// Email에 보낼 Data 조회
                	List<EmailPpdInfoVO> list = blRatingBC.searchPpdChgInfo(bkg_no, account.getUsr_id());
            		if(list.size() > 0){
            			//Send Email
            			blRatingBC.sendEmailPpdAmount(list, usrEml, account.getUsr_eml(), account.getUsr_nm());
            		}
            	}	
            }
            commit();

            eventResponse.setETCData("aloc_pop_flg", alocPopFlg); 
            eventResponse.setETCData("firm_msg_flg", firmMsgFlg);
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException((String)new ErrorHandler("BKG00391").getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == manageRate update ]==========");
        return eventResponse;
    }

    /**
     * 조회 이벤트 처리<br>
     * booking에서 사용되는 MDM Charge Code를 조회한다<br>
     * 
     * @author LEE JIN SEO
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchPayerCode(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == searchPayerCode SEARCH ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command = new BlRatingBCImpl();

        EsmBkg0961Event event = (EsmBkg0961Event) e;
        PpdCctCustInVO ppdCctCustInVO = event.getPpdCctCustInVO();

        try {
            List<PpdCctCustOutVO> list = command.searchPayerCode(ppdCctCustInVO);

            eventResponse.setRsVoList(list);
        } catch(Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchPayerCode SEARCH ]==========");
        return eventResponse;
    }

    /**
     * EsmBkg0270Event 조회 이벤트 처리<br>
     * Freight & Charge_S/C Note 를 조회한다<br>
     * 
     * @author LEE JIN SEO
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchScNote(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == searchScNote SEARCH ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command = new BlRatingBCImpl();

        EsmBkg0270Event event = (EsmBkg0270Event) e;
        ScNoteInVO scNoteInVO = event.getScNoteInVO();
        List<ScNoteOutVO> oftList = null;
        List<ScNoteOutVO> surchargeList = null;

        try {
            // 1. OFT Note를 조회한다.
            scNoteInVO.setNoteChgTpCd("O");
            oftList = command.searchScNote(scNoteInVO);
            // 2. Surcharg Note를 조회한다.
            scNoteInVO.setNoteChgTpCd("S");
            surchargeList = command.searchScNote(scNoteInVO);
            // 3. Arbitrary Note를 조회한다.

            eventResponse.setRsVoList(oftList);
            eventResponse.setRsVoList(surchargeList);
        } catch(Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchScNote SEARCH ]==========");
        return eventResponse;
    }

    /**
     * EsmBkg0265Event 조회 이벤트 처리<br>
     * Freight & Charge_Freight & Charge Remark 를 조회한다<br>
     * 
     * @author LEE JIN SEO
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchChargeRemark(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == searchChargeRemark SEARCH ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command = new BlRatingBCImpl();

        EsmBkg0265Event event = (EsmBkg0265Event) e;
        List<ChargeRemarkVO> list = null;
        String bkg_no = event.getBkg_no();
        String ca_flg = event.getCa_flg();

        try {
            list = command.searchChargeRemark(bkg_no, ca_flg);
            if(list.size() > 0) {
                ChargeRemarkVO vo = list.get(0);
                eventResponse.setETCData("BKG_NO", JSPUtil.getNull(vo.getBkgNo()));
                eventResponse.setETCData("BL_CVRD_TP_CD", JSPUtil.getNull(vo.getBlCvrdTpCd()));
                eventResponse.setETCData("INTER_RMK", JSPUtil.getNull(vo.getInterRmk()));
                eventResponse.setETCData("DIFF_RMK", JSPUtil.getNull(vo.getDiffRmk()));
                eventResponse.setETCData("DOC_INTER_RMK", JSPUtil.getNull(vo.getDocInterRmk()));
                eventResponse.setETCData("MST_CVRD_BL_NO", JSPUtil.getNull(vo.getMstCvrdBlNo()));
                eventResponse.setETCData("THIRD_PARTY_FREIGHT", JSPUtil.getNull(vo.getThirdPartyFreight()));
            }
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchChargeRemark SEARCH ]==========");
        return eventResponse;
    }

    /**
     * EsmBkg0265Event 저장 이벤트 처리<br>
     * rating시 입력한 remark를 수정 저장한다<br>
     * 
     * @author LEE JIN SEO
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse manageChargeRemark(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == manageChargeRemark update ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command = new BlRatingBCImpl();
		BookingHistoryMgtBC 	historyBC 	= new BookingHistoryMgtBCImpl();
		
		HistoryTableVO historyTableVO = new HistoryTableVO();
		BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
		
        EsmBkg0265Event event = (EsmBkg0265Event) e;
        String bkg_no = event.getBkg_no();
        String ca_flg = event.getCa_flg();
        String diff_rmk = 	WordWarp.wrap(event.getDiff_rmk().trim(), 70);
        String inter_rmk =  WordWarp.wrap(event.getInter_rmk().trim(), 70);
        String doc_inter_rmk = WordWarp.wrap(event.getDocInterRmk().trim(), 70);
        String user_id = account.getUsr_id();
        try {
            begin();
            // searchOldBkgForHistory 수행
            bkgBlNoVO.setBkgNo(bkg_no);
            bkgBlNoVO.setCaFlg(ca_flg);
			historyTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0079_08", bkgBlNoVO);
			// Save(변경)
            command.manageChargeRemark(bkg_no, ca_flg, diff_rmk, inter_rmk, doc_inter_rmk, user_id);
			// afterBkgForHistory 수행
			historyBC.manageBookingHistory("ESM_BKG_0079_08", historyTableVO, account);
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == manageChargeRemark update ]==========");
        return eventResponse;
    }

    /**
     * EsmBkg0264Event 조회 이벤트 처리<br>
     * Freight & Charge_BKG Q'TY Inquiry 를 조회한다<br>
     * 
     * @author LEE JIN SEO
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchQtyForRate(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == searchQtyForRate SEARCH ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command = new BlRatingBCImpl();

        EsmBkg0264Event event = (EsmBkg0264Event) e;
        List<BkgQtyOutVO> list = null;
        String bkg_no = event.getBkg_no();

        try {
            list = command.searchQtyForRate(bkg_no);
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchQtyForRate SEARCH ]==========");
        return eventResponse;
    }

    /**
     * EsmBkg0269Event 조회 이벤트 처리<br>
     * Freight & Charge_S/C Information 를 조회한다<br>
     * 
     * @author LEE JIN SEO
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchScInform(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == searchScInform SEARCH ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command = new BlRatingBCImpl();

        EsmBkg0269Event event = (EsmBkg0269Event) e;
        ScInformOutVO scInformOutVO = null;
        ScInformInVO scInformInVO = event.getScInformInVO();
        
        String caFlg = event.getCaflag();
        

        try {
            // rateqtylist정보를 가져온다.
            BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
            bkgBlNoVO.setBkgNo(scInformInVO.getBkgNo());
            bkgBlNoVO.setCaFlg(caFlg);
            scInformInVO.setCaFlg(caFlg);
            eventResponse.setRsVoList(command.searchRateQtyList(bkgBlNoVO));

            // scinfo정보를 가져온다.
            scInformOutVO = command.searchScInform(scInformInVO);
            eventResponse.setRsVo(scInformOutVO.getScBkgInformVOs());
            eventResponse.setRsVo(scInformOutVO.getScCustInformVOs());
            eventResponse.setRsVoList(null);
            
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
        } catch(Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchScInform SEARCH ]==========");
        return eventResponse;
    }

    /**
     * EsmBkg0771Event 조회 이벤트 처리<br>
     * BKG No로 현재 Master BKG가 가지고 있는 Covered B/L No를 조회한다<br>
     * 
     * @author LEE JIN SEO
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchCoveredBl(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == searchCoveredBl SEARCH ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command = new BlRatingBCImpl();

        EsmBkg0771Event event = (EsmBkg0771Event) e;
        List<CoveredBlListVO> list = null;
        String bkg_no = event.getBkg_no();
        String bl_no = event.getBl_no();

        try {
            list = command.searchCoveredBl(bkg_no, bl_no, "");

            eventResponse.setRsVoList(list);
            
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
        } catch(Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchCoveredBl SEARCH ]==========");
        return eventResponse;
    }

    /**
     * EsmBkg0771Event 저장 이벤트 처리<br>
     * 해당 BKG_NO를 Master B/L로 하는 Covered B/L의 Master B/L 정보를 Null로 업데이트 한다.<br>
     * 
     * @author LEE JIN SEO
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse manageCoveredBl(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == manageCoveredBl MULTI ]==========");
        GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
        BlRatingBC 				blRatingBC 			= new BlRatingBCImpl();
        BLDocumentationBLBC 	bLDocumentationBLBC = new BLDocumentationBLBCImpl();
        BookingHistoryMgtBC 	bookingHistoryMgtBC = new BookingHistoryMgtBCImpl();
		BookingUtil 			bookingUtil 		= new BookingUtil();
        
        // 1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
        EsmBkg0771Event event 				= (EsmBkg0771Event) e;
        CoveredBlListVO[] coveredBlListVOs 	= event.getCoveredBlListVOs();
        List<HistoryTableVO> histVOs 		= null;
        BkgBlNoVO bkgBlNoVO 				= null;
        String bkg_no 						= event.getBkg_no();
        String bl_no 						= event.getBl_no();
        String val_code 					= "";
        try {
        	
            // 2.로직 처리 실행
            begin();

            histVOs = new ArrayList<HistoryTableVO>();
            //mst bkg
            bkgBlNoVO = new BkgBlNoVO();
            bkgBlNoVO.setBkgNo(bkg_no);
            bkgBlNoVO.setCaUsrId(account.getUsr_id());
            bkgBlNoVO = bookingUtil.searchBkgBlNoVO(bkgBlNoVO);
            
            if (null==bkgBlNoVO || "".equals(bkgBlNoVO.getBkgNo())) {
				throw new EventException((String)new ErrorHandler("BKG08062", new String[] { bkg_no }).getMessage());
            }
            histVOs.add(bookingHistoryMgtBC.searchOldBkgForHistory("ESM_BKG_0079_08", bkgBlNoVO));
            //coveredBlListVOs
            for (CoveredBlListVO vo : coveredBlListVOs) {
                bkgBlNoVO = new BkgBlNoVO();
                bkgBlNoVO.setBkgNo(vo.getBlNo());
                bkgBlNoVO.setCaUsrId(account.getUsr_id());
                bkgBlNoVO = bookingUtil.searchBkgBlNoVO(bkgBlNoVO);
                if (null==bkgBlNoVO || "".equals(bkgBlNoVO.getBkgNo())) {
    				throw new EventException((String)new ErrorHandler("BKG08062", new String[] { vo.getBlNo() }).getMessage());
                }
                histVOs.add(bookingHistoryMgtBC.searchOldBkgForHistory("ESM_BKG_0079_08", bkgBlNoVO));
            }
            //blRatingBC.manageCoveredBl
            String r_message = blRatingBC.manageCoveredBl(bkg_no, bl_no, coveredBlListVOs, account);
            //bLDocumentationBLBC.manageCoveredBl
            r_message = bLDocumentationBLBC.manageCoveredBl(bkg_no, bl_no, coveredBlListVOs);

            for (HistoryTableVO histVO : histVOs) {
            	bookingHistoryMgtBC.manageBookingHistory("ESM_BKG_0079_08", histVO, account);
            }

            commit();
            
            if(r_message==null || r_message.equals("")) {
        		val_code = "00";
        	}
            // 3.로직 처리후 결과처리
            eventResponse.setETCData("val_code", val_code);
            eventResponse.setUserMessage(r_message); // 결과값 처리 메세지

        } catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
        }
        log.debug("[END::]==========");
        return eventResponse;
    }

    
    
    
    /**
     * EsmBkg0739Event 조회 이벤트 처리<br>
     * Freight & Charge RFA Information 를 조회한다<br>
     * 
     * @author LEE JIN SEO
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchRfaInform(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == searchRfaInform SEARCH ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command = new BlRatingBCImpl();

        EsmBkg0739Event event = (EsmBkg0739Event) e;
        RfaInformOutVO rfaInformOutVO = null;
        RfaInformInVO rfaInformInVO = event.getRfaInformInVO();
        String caFlg = event.getCaflag();

        try {
            // rateqtylist정보를 가져온다.
            BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
            bkgBlNoVO.setBkgNo(rfaInformInVO.getBkgNo());
            bkgBlNoVO.setCaFlg(caFlg);
            rfaInformInVO.setCaFlg(caFlg);
            // + tp/sz
            eventResponse.setRsVoList(command.searchRateQtyList(bkgBlNoVO));

            // rfa정보를 가져온다. RFA Information
            rfaInformOutVO = command.searchRfaInform(rfaInformInVO);
            eventResponse.setRsVo(rfaInformOutVO.getRfaBkgInformVO());
            eventResponse.setRsVo(rfaInformOutVO.getRfaCustInformVO());
            eventResponse.setRsVoList(null);
            
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchRfaInform SEARCH ]==========");
        return eventResponse;
    }
    
    /**
     * EsmBkg1076Event 조회 이벤트 처리<br>
     * Freight & Charge Taa Information 를 조회한다<br>
     * 
     * @author KIM TAE KYOUNG
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchTaaInform(Event e) throws EventException {
    	log.debug("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        log.debug("[START:: BlRatingSC == searchTaaInform SEARCH ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command = new BlRatingBCImpl();

        EsmBkg1076Event event = (EsmBkg1076Event) e;
        TaaInformOutVO taaInformOutVO = null;
        TaaInformInVO taaInformInVO = event.getTaaInformInVO();
        String caFlg = event.getCaflag();

        try {
            // rateqtylist정보를 가져온다.
            BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
            bkgBlNoVO.setBkgNo(taaInformInVO.getBkgNo());
            bkgBlNoVO.setCaFlg(caFlg);
            taaInformInVO.setCaFlg(caFlg);
            eventResponse.setRsVoList(command.searchRateQtyList(bkgBlNoVO));

            // scinfo정보를 가져온다.
            taaInformOutVO = command.searchTaaInform(taaInformInVO);
            eventResponse.setRsVo(taaInformOutVO.getTaaBkgInformVOs());
            eventResponse.setRsVo(taaInformOutVO.getTaaCustInformVOs());
            eventResponse.setRsVoList(null);
            
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
        } catch(Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchScInform SEARCH ]==========");
        return eventResponse;
    }
    
    /**
     * EsmBkg1076Event 조회 이벤트 처리<br>
     * Freight & Charge Taa Information 를 조회한다<br>
     *  
     * @author KIM TAE KYOUNG
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchTaaInformList(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == searchTaaInformList SEARCH caflag]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        TaaOftAutoRatingBC command = new TaaOftAutoRatingBCImpl();

        EsmBkg1076Event event = (EsmBkg1076Event) e;
        List<SearchTaaOftAutoratingListVO> list = null;
   
        String bkg_no = event.getBkg_no();
        String caflag = event.getCaflag();
        String scpcd  = event.getScpcd();
        String cmdtcd = event.getCmdtcd();
        String rtaplydt = event.getrtAplyDt();
        String taaNo = event.gettaaNo();
        
        try {
        	list = command.searchTaaOftAutoratingList(bkg_no,caflag,taaNo,rtaplydt,scpcd,cmdtcd);
        	// 결과값 셋팅 
            eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
        } catch(Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchScInformList SEARCH ]==========");
        return eventResponse;
    }


    /**
     * EsmBkg0945Event 조회 이벤트 처리<br>
     * Exchange Rate 를 조회한다<br>
     * 
     * @author LEE JIN SEO
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchXchRt(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == searchXchRt SEARCH ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command = new BlRatingBCImpl();

        EsmBkg0945Event event = (EsmBkg0945Event) e;
        List<ExchangeRateVO> list = null;
        String bkg_no = event.getBkgNo();

        try {
            list = command.searchXchRt(bkg_no);

            eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
        } catch(Exception ex) {
            throw new EventException((String)new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchXchRt SEARCH ]==========");
        return eventResponse;
    }
	/**
	 * Rating Default 조회.(ESM_BKG_0079_08)<br>
	 *
	 * @author LEE JIN SEO
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateBkgDefault(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil bookingUtil = new BookingUtil();

		try{
			// 01. rt_bl_tp_cd 데이터 조회 
			List<BkgComboVO> rTblTp  = bookingUtil.searchCombo("CD01639");
			eventResponse.setRsVoList(rTblTp);
			// 02 frt_term_cd 데이터 조회 
			List<BkgComboVO> frtTerm  = bookingUtil.searchCombo("CD02080");
			eventResponse.setRsVoList(frtTerm);
			// 03. rTerm 데이터 조회 
			List<BkgComboVO> rTerm  = bookingUtil.searchCombo("CD00764");
			Iterator<BkgComboVO> rlist = rTerm.iterator();
			StringBuffer rbuff = new StringBuffer();
			while (rlist.hasNext()) {
				BkgComboVO bkgComboVO = (BkgComboVO) rlist.next();
				rbuff.append(bkgComboVO.getVal());
			}
			rbuff.append(rbuff.toString().toLowerCase());
			eventResponse.setCustomData("rTerm", rbuff.toString());
			// 04. dTerm 데이터 조회 
			List<BkgComboVO> dTerm  = bookingUtil.searchCombo("CD00765");
			Iterator<BkgComboVO> dlist = dTerm.iterator();
			StringBuffer dbuff = new StringBuffer();
			while (dlist.hasNext()) {
				BkgComboVO bkgComboVO = (BkgComboVO) dlist.next();
				dbuff.append(bkgComboVO.getVal());
			}
			dbuff.append(dbuff.toString().toLowerCase());
			eventResponse.setCustomData("dTerm", dbuff.toString());
			
		}catch(EventException ex){
			log.error("err"+ex.toString(),ex);
			throw ex;
		}catch(Exception ex){
			log.error("err"+ex.toString(),ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;	
	}
    /**
     * EsmBkg007908Event 조회 이벤트 처리<br>
     * Freight & Charge - 를 조회한다<br>
     * 
     * @author LEE JIN SEO
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchRate(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == searchRate SEARCH ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command 		= new BlRatingBCImpl();

        EsmBkg007908Event event = (EsmBkg007908Event) e;
        RateOutVO rateOut 		= null;
        String bkg_no 			= event.getBkg_no();
        String bl_no 			= event.getBl_no();

        try {
        	log.debug("/*************************************************************/");
        	log.debug("/********** [searchRate: bkg_no번호가 없는경우 :  bl_no로 bkg_no가져오기  ]/");
        	log.debug("/*************************************************************/");
			BookingUtil bookingUtil = new BookingUtil();
        	if(bl_no.length()>12) bl_no = bl_no.substring(0,12);
			if(bkg_no.length() == 0 && bl_no.length() != 0 ){ // 2011.07.15
				if(bl_no.length()>12) bl_no = bl_no.substring(0,12);
				bkg_no = bookingUtil.searchBkgNoByBlNo(bl_no);	
			}
        	
			log.debug("/*************************************************************/");
			log.debug("/********** [searchRate: bkg_no 존재유무판단  1] ************/");
			log.debug("/*************************************************************/");
			BkgBlNoVO bkgBlNo = new BkgBlNoVO();
			bkgBlNo.setBkgNo(bkg_no);
			bkgBlNo.setBlNo(bl_no);	
			bkgBlNo.setCaUsrId(account.getUsr_id());
			
			BkgBlNoVO bkgBlNoVO = bookingUtil.searchBkgBlNoVO(bkgBlNo);
			if (bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
				throw new EventException((String)new ErrorHandler("BKG01049", new String[] { bkg_no }).getMessage());
			}
			
			log.debug("/*************************************************************/");
			log.debug("/********** [searchRate: bkg_no가  P 일경우 return 처리  ] *******/");
			log.debug("/*************************************************************/");
        	String bkgStsCd = bookingUtil.searchBkgCgoTp(bkgBlNoVO);
        	if (bkgStsCd.equals("P")) {
        		throw new EventException(new ErrorHandler("BKG40030").getMessage());
        	}
        	
			log.debug("/*************************************************************/");
			log.debug("/********** [searchRate: 메인 searchRate  ] *******************/");
			log.debug("/*************************************************************/");
            RateInVO rateInVO = new RateInVO();
            rateInVO.setBkg_no(bkg_no);
            rateInVO.setBl_no(bl_no);
            rateInVO.setAccount(account);
            rateOut = command.searchRate(rateInVO);

			log.debug("/*************************************************************/");
			log.debug("/********** [searchRate: manualSurchargePC  ] ****************/");
			log.debug("/*[메뉴얼로 Insert 하는 Charge 가 PRI에 Scope 및 CHG CODE 별로 등록 되어있는 항목 ]*/");
			log.debug("/*************************************************************/");
			List<ManualSurchargeVO> manualSurchargeVOs = null;
			List<RateMainInfoVO> rateMainInfoVO = rateOut.getRateMainInfoVOs();
			if(rateMainInfoVO.size() > 0){
				String application_date = rateMainInfoVO.get(0).getRtAplyDt();
				String svc_scp_cd ="";
				if(rateMainInfoVO.get(0).getBkgSvcScpCd() == null || rateMainInfoVO.get(0).getBkgSvcScpCd().length() == 0){
					eventResponse.setETCData("message", new ErrorHandler("BKG08136", new String[] { bkg_no }).getMessage());
				}else{
					if(rateMainInfoVO.get(0).getBkgSvcScpCd().length()>0){
						svc_scp_cd = rateMainInfoVO.get(0).getBkgSvcScpCd().substring(0,3);
					}
		            if(application_date.length()>0 && svc_scp_cd.length()>0){
		            	manualSurchargeVOs = bookingUtil.manualSurcharge(application_date, svc_scp_cd);
		            }
				}
				eventResponse.setETCData("vol_diff_flg", rateMainInfoVO.get(0).getVolDiffFlg());
//				eventResponse.setETCData("vol_diff_flg", "Y");
				
			}
			//---------------jsy 
			BkgBlNoVO schBkgBlNoVO = bookingUtil.searchBkgBlNoVO(bkgBlNoVO);
			// 02. searchBkgBookingInfo(Booking 정보)
			BkgBookingInfoVO bkgBookingInfoVO = command.searchBkgBookingInfo(schBkgBlNoVO);
            eventResponse.setETCData("ctrt_ofc_cd", bkgBookingInfoVO.getCtrtOfcCd());
            eventResponse.setETCData("ctrt_srep_cd", bkgBookingInfoVO.getCtrtSrepCd());
            eventResponse.setETCData("bkg_ofc_cd", bkgBookingInfoVO.getBkgOfcCd()); 
            eventResponse.setETCData("aloc_sts_cd", bkgBookingInfoVO.getAlocStsCd()); 
			//---------------jsy 
			
			log.debug("/*************************************************************/");
			eventResponse.setETCData("oblIssFlg", bookingUtil.oblIssFlgCheck(bkg_no,rateOut.getCaflag()));

			log.debug("/*************************************************************/");
			log.debug("/********** [searchRate: 결과값 return  ] *********************/");
			log.debug("/*************************************************************/");
            eventResponse.setETCData("caflag", rateOut.getCaflag());
            eventResponse.setETCData("bdrflag", rateOut.getBdrflag());
            eventResponse.setETCData("rOfc_cd", rateOut.getROfc_cd());
        	eventResponse.setETCData("corr_flg", bkgBlNoVO.getCaFlg());
            eventResponse.setETCData("ca_exist_flg", bkgBlNoVO.getCaExistFlg());
            eventResponse.setETCData("bkg_no", bkgBlNoVO.getBkgNo());
            
            eventResponse.setRsVoList(rateOut.getRateMainInfoVOs());
            eventResponse.setRsVoList(rateOut.getBkgChgRateVOs());
            eventResponse.setRsVoList(rateOut.getRateEtcInfoVOs());
            eventResponse.setRsVoList(rateOut.getRateEtcInfo1VOs());
            eventResponse.setRsVoList(manualSurchargeVOs);
            /* Vol.difference */
            eventResponse.setRsVoList(rateOut.getRateCntrInfoVOs()); 
		}catch(EventException ex){
			//log.error("err"+ex.toString(),ex);
			throw ex;
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchRate SEARCH ]==========");
        return eventResponse;
    }

    /**
     * 조회 이벤트 처리<br>
     * BlRating의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    // private EventResponse searchTest(Event e) throws EventException {
    // // PDTO(Data Transfer Object including Parameters)
    // GeneralEventResponse eventResponse = new GeneralEventResponse();
    // EsmBkg0945Event event = (EsmBkg0945Event)e;
    // BlRatingBC command = new BlRatingBCImpl();
    //
    // try{
    // List<BkgBlNoVO> list = command.searchTest(event.getBkgBlNoVO());
    // eventResponse.setRsVoList(list);
    // }catch(EventException ex){
    // throw ex;
    // }catch(Exception ex){
    // throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
    // }
    // return eventResponse;
    // }


    /**
     * Container Rate를 조회하는 메소드.
     * 
     * @param e Event
     * @return EventResponse
     * @exception EventException 
     */
    private EventResponse searchCntrRate(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == searchCntrRate SEARCH ]==========");
        EsmBkg1043Event event = (EsmBkg1043Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        BookingUtil bookingUtil = new BookingUtil();
        BlRatingBC rateCmd = new BlRatingBCImpl();

        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(event.getBkgNo());
        bkgBlNoIN.setBlNo(event.getBlNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());
        log.debug("=====> getBkgNo   : " + event.getBkgNo());
        log.debug("=====> getBlNo    : " + event.getBlNo());
        try {
            // searchBkgBlNo
            BkgBlNoVO bkgBlNoVO = bookingUtil.searchBkgBlNoVO(bkgBlNoIN);
            if(bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
                throw new EventException((String)new ErrorHandler("BKG01049", new String[]{event.getBkgNo()}).getMessage());
            }
            log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());

            CntrRtOutVO cntrRtOutVO = rateCmd.searchCntrRate(bkgBlNoVO.getBkgNo());

            eventResponse.setRsVoList(cntrRtOutVO.getCntrRtVOs());
            eventResponse.setETCData(cntrRtOutVO.getCntrRtBkgInfoVO().getColumnValues());
            eventResponse.setRsVoList(cntrRtOutVO.getCntrRtQtyVOs());
            eventResponse.setRsVoList(cntrRtOutVO.getCntrRtAmtVOs());
            eventResponse.setRsVoList(cntrRtOutVO.getCntrRtCustVOs());

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchCntrRate SEARCH ]==========");
        return eventResponse;
    }

    /**
     * Container Rate를 수정하는 메소드.
     * 
     * @param e Event
     * @return EventResponse
     * @exception EventException 
     */
    private EventResponse manageCntrRate(Event e) throws EventException {
        // event.setCntrRtOutVO(cntrRtOutVO);
        log.debug("[START:: BlRatingSC == manageCntrRate SEARCH ]==========");
        EsmBkg1043Event event = (EsmBkg1043Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        BookingUtil bookingUtil = new BookingUtil();
        BlRatingBC rateCmd = new BlRatingBCImpl();

        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(event.getBkgNo());
        bkgBlNoIN.setBlNo(event.getBlNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

        CntrRtOutVO cntrRtOutVO = event.getCntrRtOutVO();
        List<CntrRtVO> cntrRtVOs = cntrRtOutVO.getCntrRtVOs();

        try {
            // searchBkgBlNo
            BkgBlNoVO bkgBlNoVO = bookingUtil.searchBkgBlNoVO(bkgBlNoIN);
            if(bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
                throw new EventException((String)new ErrorHandler("BKG01049", new String[]{event.getBkgNo()}).getMessage());
            }
            log.debug("=====> caFlag    : " + bkgBlNoVO.getCaFlg());

            begin();
            rateCmd.manageCntrRate(cntrRtVOs, account);
            commit();
            eventResponse.setUserMessage("");
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == manageCntrRate SEARCH ]==========");
        return eventResponse;
    }

    /**
     * Container Rate를 분배하는 메소드.
     * 
     * @param e Event
     * @return EventResponse
     * @exception EventException 
     */
    private EventResponse distributeCntrRate(Event e) throws EventException {
        // event.setCntrRtOutVO(cntrRtOutVO);
        log.debug("[START:: BlRatingSC == manageCntrRate SEARCH ]==========");
        EsmBkg1043Event event = (EsmBkg1043Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        BookingUtil bookingUtil = new BookingUtil();
        BlRatingBC rateCmd = new BlRatingBCImpl();

        BkgBlNoVO bkgBlNoIN = new BkgBlNoVO();
        bkgBlNoIN.setBkgNo(event.getBkgNo());
		bkgBlNoIN.setCaUsrId(account.getUsr_id());

        try {
            // searchBkgBlNo
            BkgBlNoVO bkgBlNoVO = bookingUtil.searchBkgBlNoVO(bkgBlNoIN);
            if(bkgBlNoVO == null || bkgBlNoVO.getBkgNo() == null) {
                throw new EventException((String)new ErrorHandler("BKG01049", new String[]{event.getBkgNo()}).getMessage());
            }
            if("X".equals(bkgBlNoVO.getBkgStsCd())) {
                throw new EventException((String)new ErrorHandler("BKG00433", new String[]{event.getBkgNo()}).getMessage());
            }
            if("Y".equals(bkgBlNoVO.getCaFlg())) {
                throw new EventException((String)new ErrorHandler("BKG08036", new String[]{event.getBkgNo()}).getMessage());
            }
            
            begin();
            rateCmd.distributeCntrRate(bkgBlNoVO.getBkgNo(), account);
            commit();
            eventResponse.setUserMessage("");
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("BKG00629", new String[] {}).getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == manageCntrRate SEARCH ]==========");
        return eventResponse;
    }
    
    
    /**
     * EsmBkg1077Event 조회 이벤트 처리<br>
     * Rating Application Date Search <br>
     * 
     * @author KIM TAE KYOUNG
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchAppicationDate(Event e) throws EventException {
    	log.debug("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        log.debug("[START:: Rating Application Date Search SEARCH ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command = new BlRatingBCImpl();

        EsmBkg1077Event event = (EsmBkg1077Event) e;
        List<SearchRatingApplyDateVO> list = null;
        
        String bkg_no = event.getBkgNo();
        String ca_flg = event.getCaFlg();
        
        try {
        	list = command.searchRatingApplyDate(bkg_no,ca_flg);

    	
    	// 결과값 셋팅 
        eventResponse.setRsVoList(list);
        	
        } catch(Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchScInform SEARCH ]==========");
        return eventResponse;
    }
    
    /**
	 * ESM_BKG_1084 : Retrieve<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateTpbInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1084Event event = (EsmBkg1084Event)e;
		BlRatingBC command = new BlRatingBCImpl();
		try{
			List<SearchTpbInfoVO> list = command.searchTpbInfo(event.getBkgNo(),
					                                     event.getNtcSeq());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * 
     * bkg의 Charge화면에 Pricing의 계약 연결 변경 요청(ESM_BKG_0709_08)
     * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse searchAmdtSeq(Event e) throws EventException {
		EsmBkg007908Event event = (EsmBkg007908Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		BlRatingBC command = new BlRatingBCImpl();

		String ctrtType =event.getCtrtType();
		String ctrtNo= event.getCtrtNo();
		String applicationDate = event.getApplication_date();
		try {
			String amdt_seq = command.searchAmdtSeq(ctrtType,  ctrtNo, applicationDate);
			eventResponse.setETCData("amdt_seq", amdt_seq);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * ESM_BKG_0269 : : Retrieve<br>
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchScOftPrecheckResult(Event e) throws EventException{
		try{
			EsmBkg0269Event   event = (EsmBkg0269Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			ScOftAutoRatingBC autoratingBC = new ScOftAutoRatingBCImpl();
			BlRatingBC blRatingBC = new BlRatingBCImpl();
			UnmatchBLBC unmatchBC = new UnmatchBLBCImpl();
			UnmatchBLVO unmatchBLVO = new UnmatchBLVO();
			List<ServiceScopeVO> scope = null;
			List<SearchScOftAutoratingListVO> list = null;
			List<RateMainInfoVO> rate = null;
			String applicationDt = "";
	        String bkg_no = "";
	        String caflag = "";
	        String scpcd  = "";
	        String frtTermCd  = "";
	        String scNo = "";
			String chkOft = "N";
			String porCd = "";
			String polCd = "";
			String podCd = "";
			String delCd = "";
			
	        begin();
			//B/L No 로 BkgNo, ctrtTpCD 를 조회
	        unmatchBLVO= unmatchBC.searchBkgCaFlg(event.getBl_no(), event.getCaflag());
	        
			//Rate Application Date 조회
			if(unmatchBLVO != null){
		        bkg_no = unmatchBLVO.getBkgNo();
		        caflag = unmatchBLVO.getCaFlg();	
		        scpcd  = unmatchBLVO.getSvcScpCd();
		        frtTermCd = unmatchBLVO.getFrtTermCd();
		        scNo = event.getscNo();
			}            
			applicationDt = autoratingBC.searchPreCheckRtAplyDt(bkg_no, caflag);
	        String rtaplydt = applicationDt;
	        scope = blRatingBC.searchServiceScopeList(bkg_no, caflag);   // 복수 Scope 조회

            //India IHC manual rating case
            // POR이나 DEL 이 India 지역일 경우 운임체크 하지 않도록 exception처리
			// 단, POR/POL이 같거나, POD/DEL 이 같아 IHC 가 없는 경우에는 운임체크 진행
            rate = blRatingBC.searchRateMainInfo(bkg_no, caflag);
            porCd = rate.get(0).getPorCd();
            polCd = rate.get(0).getPolCd();
            podCd = rate.get(0).getPodCd();
            delCd = rate.get(0).getDelCd();
            if(("IN".equals(porCd.substring(0, 2)) && (!porCd.equals(polCd)))
            		|| ("IN".equals(delCd.substring(0, 2)) && (!delCd.equals(podCd))) ){
            	chkOft = "Y";
            }

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

        	
        	if("Y".equals(chkOft))
        		blRatingBC.moidfyOftPrecheckResult(bkg_no, caflag, "N", account);
        	else
        		blRatingBC.moidfyOftPrecheckResult(bkg_no, caflag, "Y", account);
        	
        	commit();
        	
        	eventResponse.setETCData("chk_oft", chkOft);
        	eventResponse.setETCData("application_dt", applicationDt);
        	eventResponse.setETCData("frt_term_cd", frtTermCd);
        	eventResponse.setETCData("svc_scp_cd", scpcd);
        	
			return eventResponse;
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * ESM_BKG_0739 : : Retrieve<br>
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRfaOftPrecheckResult(Event e) throws EventException{
		try{
			EsmBkg0739Event   event = (EsmBkg0739Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			RfaOftAutoRatingBC command = new RfaOftAutoRatingBCImpl();
			BlRatingBC blRatingBC = new BlRatingBCImpl();
			UnmatchBLBC unmatchBC = new UnmatchBLBCImpl();
			UnmatchBLVO unmatchBLVO = new UnmatchBLVO();
			List<SearchRfaOftAutoratingListVO> list = null;
			List<RateMainInfoVO> rate = null;
			List<ServiceScopeVO> scope = null;
			String applicationDt = "";
	        String bkg_no = "";
	        String caflag = "";
	        String scpcd  = "";
	        String frtTermCd  = "";
	        String rfaNo = "";
			String chkOft = "N";
			String cmdtCd = "";
			String porCd = "";
			String polCd = "";
			String podCd = "";
			String delCd = "";
			
	        begin();
			//B/L No 로 BkgNo, ctrtTpCD 를 조회
	        unmatchBLVO= unmatchBC.searchBkgCaFlg(event.getBkg_no(), event.getCaflag());
			
			//Rate Application Date 조회
			if(unmatchBLVO != null){
		        bkg_no = unmatchBLVO.getBkgNo();
		        caflag = unmatchBLVO.getCaFlg();	
		        scpcd  = unmatchBLVO.getSvcScpCd();
		        frtTermCd = unmatchBLVO.getFrtTermCd();
		        rfaNo = event.getrfaNo();
		        cmdtCd = event.getCmdtcd();
			}
            
			applicationDt = command.searchPreCheckRtAplyDt(bkg_no, caflag);
			String hinterFlg = command.searchHinterlandApplyFlag(applicationDt, bkg_no, caflag);
	        String rtaplydt = applicationDt;
	        scope = blRatingBC.searchServiceScopeList(bkg_no, caflag);   // 복수 Scope 조회

            //India IHC manual rating case
            // POR이나 DEL 이 India 지역일 경우 운임체크 하지 않도록 exception처리
			// 단, POR/POL이 같거나, POD/DEL 이 같아 IHC 가 없는 경우에는 운임체크 진행
            rate = blRatingBC.searchRateMainInfo(bkg_no, caflag);
            porCd = rate.get(0).getPorCd();
            polCd = rate.get(0).getPolCd();
            podCd = rate.get(0).getPodCd();
            delCd = rate.get(0).getDelCd();
            if(("IN".equals(porCd.substring(0, 2)) && (!porCd.equals(polCd)))
            		|| ("IN".equals(delCd.substring(0, 2)) && (!delCd.equals(podCd))) ){
            	chkOft = "Y";
            }
	        
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
        	
        	if("Y".equals(chkOft))
        		blRatingBC.moidfyOftPrecheckResult(bkg_no, caflag, "N", account);
        	else
        		blRatingBC.moidfyOftPrecheckResult(bkg_no, caflag, "Y", account);
        	commit();
        	
        	eventResponse.setETCData("chk_oft", chkOft);
        	eventResponse.setETCData("application_dt", applicationDt);
        	eventResponse.setETCData("frt_term_cd", frtTermCd);
        	eventResponse.setETCData("svc_scp_cd", scpcd);
        	
			return eventResponse;

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
     * EsmBkg0739Event 조회 이벤트 처리<br>
     * BKG Container VGM 정보를 조회한다<br>
     * 
     * @author KIM DONG HO
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchBkgCntrVGMInfoList(Event e) throws EventException {
        log.debug("[START:: BlRatingSC == searchBkgCntrVGMInfoList SEARCH ]==========");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command = new BlRatingBCImpl();

        EsmBkg0739Event event = (EsmBkg0739Event) e;

        List<BkgCntrVgmInfoListVO> list = null;

        String bkg_no = event.getBkg_no();
        String ca_flg = event.getCaflag();

        try {
            list = command.searchBkgCntrVGMInfoList(bkg_no, ca_flg);
            eventResponse.setRsVoList(list);
        } catch(Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }
        log.debug("[end:: BlRatingSC == searchBkgCntrVGMInfoList SEARCH ]==========");
        return eventResponse;
    }
	
	
	/**
	 * ESM_BKG_1076 : : Retrieve<br>
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTaaOftPrecheckResult(Event e) throws EventException{
		try{
			EsmBkg1076Event   event = (EsmBkg1076Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			TaaOftAutoRatingBC command = new TaaOftAutoRatingBCImpl();
			BlRatingBC blRatingBC = new BlRatingBCImpl();
			UnmatchBLBC unmatchBC = new UnmatchBLBCImpl();
			UnmatchBLVO unmatchBLVO = new UnmatchBLVO();
			List<SearchTaaOftAutoratingListVO> list = null;
			List<RateMainInfoVO> rate = null;
			List<ServiceScopeVO> scope = null;
			String applicationDt = "";
	        String bkg_no = "";
	        String caflag = "";
	        String scpcd  = "";
	        String frtTermCd  = "";
	        String taaNo = "";
			String chkOft = "N";
			String cmdtCd = "";
			String porCd = "";
			String polCd = "";
			String podCd = "";
			String delCd = "";
			
	        begin();
			//B/L No 로 BkgNo, ctrtTpCD 를 조회
	        unmatchBLVO= unmatchBC.searchBkgCaFlg(event.getBkg_no(), event.getCaflag());
	        
			//Rate Application Date 조회
			if(unmatchBLVO != null){
		        bkg_no = unmatchBLVO.getBkgNo();
		        caflag = unmatchBLVO.getCaFlg();	
		        scpcd  = unmatchBLVO.getSvcScpCd();
		        frtTermCd  = unmatchBLVO.getFrtTermCd();
		        taaNo = event.gettaaNo();
		        cmdtCd = event.getCmdtcd();
			}

			applicationDt = command.searchPreCheckRtAplyDt(bkg_no, caflag);
	        String rtaplydt = applicationDt;
	        scope = blRatingBC.searchServiceScopeList(bkg_no, caflag);   // 복수 Scope 조회

            //India IHC manual rating case
            // POR이나 DEL 이 India 지역일 경우 운임체크 하지 않도록 exception처리
			// 단, POR/POL이 같거나, POD/DEL 이 같아 IHC 가 없는 경우에는 운임체크 진행
            rate = blRatingBC.searchRateMainInfo(bkg_no, caflag);
            porCd = rate.get(0).getPorCd();
            polCd = rate.get(0).getPolCd();
            podCd = rate.get(0).getPodCd();
            delCd = rate.get(0).getDelCd();
            if(("IN".equals(porCd.substring(0, 2)) && (!porCd.equals(polCd)))
            		|| ("IN".equals(delCd.substring(0, 2)) && (!delCd.equals(podCd))) ){
            	chkOft = "Y";
            }
            
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
        	
        	if("Y".equals(chkOft))
        		blRatingBC.moidfyOftPrecheckResult(bkg_no, caflag, "N", account);
        	else
        		blRatingBC.moidfyOftPrecheckResult(bkg_no, caflag, "Y", account);        	
        	commit();
        	
        	eventResponse.setETCData("chk_oft", chkOft);
        	eventResponse.setETCData("application_dt", applicationDt);
        	eventResponse.setETCData("frt_term_cd", frtTermCd);
        	eventResponse.setETCData("svc_scp_cd", scpcd);
        	
			return eventResponse;

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
    /**
	 * ESM_BKG_1090 : Retrieve<br>
	 * Charge Currency Adjustment 내역을 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeAdjustment(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1090Event event = (EsmBkg1090Event)e;
		BlRatingBC command = new BlRatingBCImpl();

        ChargeAdjustmentVO dhfVO = null;
        ChargeAdjustmentVO ddcVO = null;
		try{
			dhfVO = command.searchDHFAdjustment(event.getBkgNo(),event.getCaFlg());
			ddcVO = command.searchDDCAdjustment(event.getBkgNo(),event.getCaFlg());
			eventResponse.setRsVo(dhfVO);
			eventResponse.setRsVo(ddcVO);
		} catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
	}
    
    /**
     * DHF Adjustment Location 저장<br>
     * 
     * @author JJ Kim
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse modifyDHFAdjustment(Event e) throws EventException{
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command = new BlRatingBCImpl();
        EsmBkg1090Event event = (EsmBkg1090Event) e;

        try{
        	begin();

            ChargeAdjustmentVO dhfVO = null;
            dhfVO = event.getChargeAdjustmentVO();
            dhfVO.setBkgNo(event.getBkgNo());
            dhfVO.setCaFlg(event.getCaFlg());
            dhfVO.setUsrId(account.getUsr_id());
            
        	command.modifyDHFAdjustment(dhfVO);
      	
        	commit();
        	
        }catch(EventException ex){
        	rollback();
        	throw ex;
        }
        
    	 return eventResponse;
    }
    
    /**
     * DDC Adjustment Currency 저장<br>
     * 
     * @author JJ Kim
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse modifyDDCAdjustment(Event e) throws EventException{
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        BlRatingBC command = new BlRatingBCImpl();
        EsmBkg1090Event event = (EsmBkg1090Event) e;
        
        try{
        	begin();
            
            ChargeAdjustmentVO ddcVO = null;
            ddcVO = event.getChargeAdjustmentVO();
            ddcVO.setBkgNo(event.getBkgNo());
            ddcVO.setCaFlg(event.getCaFlg());
            ddcVO.setUsrId(account.getUsr_id());
        	
        	command.modifyDDCAdjustment(ddcVO);
      	
        	commit();
        	
        }catch(EventException ex){
        	rollback();
        	throw ex;
        }
        
    	 return eventResponse;
    }
	
	/**
	 * ESM_BKG_0079_08 : Save 후 TPF Surcharge 금액 조회<br>
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTPFSurcharge(Event e) throws EventException{
		try{
			EsmBkg007908Event   event = (EsmBkg007908Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
	        SurchargeAutoRatingBC surCmd = new SurchargeAutoRatingBCImpl();
			BkgChgRateVO bkgChgRateVO = null;
			
	        begin();
	        
	        bkgChgRateVO = surCmd.searchTPFSurcharge(event.getBkg_no(), event.getCaflag());
	        
	        if(bkgChgRateVO != null){
	        	eventResponse.setETCData("chg_cd", bkgChgRateVO.getChgCd());
	        	eventResponse.setETCData("curr_cd", bkgChgRateVO.getCurrCd());
	        	eventResponse.setETCData("chg_ut_amt", bkgChgRateVO.getChgUtAmt());
	        	eventResponse.setETCData("rat_ut_cd", bkgChgRateVO.getRatUtCd());
	        	eventResponse.setETCData("frt_term_cd", bkgChgRateVO.getFrtTermCd());
	        	eventResponse.setETCData("n3pty_rcv_ofc_cd", bkgChgRateVO.getN3ptyRcvOfcCd());
	        	eventResponse.setETCData("n3pty_cust_cnt_cd", bkgChgRateVO.getN3ptyCustCntCd());
	        	eventResponse.setETCData("n3pty_cust_seq", bkgChgRateVO.getN3ptyCustSeq());
	        	eventResponse.setETCData("rcv_term_cd", bkgChgRateVO.getRcvTermCd());
	        	eventResponse.setETCData("de_term_cd", bkgChgRateVO.getDeTermCd());
	        }
        	
			return eventResponse;

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
    
    /**
	 * ESM_BKG_2006 : Retrieve<br>
	 * Invoice I/F Temp테이블과 BKG_CHG_RT 테이블을 비교하여 Diff발생한 BKG을 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceInterfaceDifference(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg2006Event event = (EsmBkg2006Event)e;
		BlRatingBC command = new BlRatingBCImpl();
		InvIfDiffVO vo = null;
		try{
			vo = event.getInfoVO();
			List<InvIfDiffVO> list = command.searchInvoiceInterfaceDifference(vo);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) { 
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * Charge Amend Request Reason Code와  Booking의 OFT 정보를 조회한다.<br>
	 * @author    Lee NamKyung
	 * @param     e Event
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse initChargeAmendRequest(Event e) throws EventException {
		EsmBkg1600Event event = (EsmBkg1600Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil utilBC = new BookingUtil();
		BlRatingBC command = new BlRatingBCImpl();
		
		try {
			//01. Amend Reason
			List<BkgComboVO> list = utilBC.searchCombo("CD03364");
			eventResponse.setRsVoList(list);
			
			//02. Charge
			String bkgNo = event.getBkgNo();
			String chgCd = event.getChgCd();
			List<ChargeAmendAuthDetailVO> chgList = command.searchCurrentOftList(bkgNo, chgCd);
			eventResponse.setRsVoList(chgList);
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}

		return eventResponse;
	}
	
	/**
	 * Charge Amend Request Reason Code와  Booking의 OFT 정보를 조회한다.<br>
	 * @author    Lee NamKyung
	 * @param     e Event
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse createChargeAmendAuthRequest(Event e) throws EventException {
		EsmBkg1600Event event = (EsmBkg1600Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BlRatingBC command = new BlRatingBCImpl();
		ChargeAmendAuthVO auth = event.getChargeAmendAuthVO();
		ChargeAmendAuthDetailVO[] authDetail = event.getChargeAmendAuthDetailVOs();
		ChargeAmendAuthRefUserVO[] refUser = event.getChargeAmendAuthRefUserVOs();
		
		try{
        	begin();

        	ChargeAmendAuthRequestVO requestVO = new ChargeAmendAuthRequestVO();
        	requestVO.setBkgNo(event.getBkgNo());
        	requestVO.setChgCd(event.getChgCd());
            requestVO.setChargeAmendAuthVO(auth);
            requestVO.setChargeAmendAuthDetailVOs(authDetail);
            requestVO.setChargeAmendAuthRefUserVOs(refUser);
        	
        	command.createChargeAmendAuthRequest(requestVO, account);
      	
        	commit();
        	
        }catch(EventException ex){
        	rollback();
        	throw ex;
        }

		return eventResponse;
	}


	
    /**
     * ESM_BKG_1601 : Open<br>
     * Charge Amend Request Status 화면을 초기화 합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse initChargeAmendRequestList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BookingUtil utilBC = new BookingUtil();
		BlRatingBC command = new BlRatingBCImpl();
		
		try {
			//01. Amend Reason
			List<BkgComboVO> chg_amd_rqst_sts_cd = utilBC.searchCombo("CD03365");
			eventResponse.setCustomData("chg_amd_rqst_sts_cd",chg_amd_rqst_sts_cd);
			
			//02. 승인권한 유무
			String authUsrFlg = "";
			authUsrFlg = command.searchChargeAmendApprovalAuth(account);
	    	eventResponse.setETCData("auth_usr_flg", authUsrFlg);
			
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}

		return eventResponse;
	}



	/**
	 * ESM_BKG_1601 : Retrieve<br>
	 * Charge Amend권한 승인 요청 목록을 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeAmendAuthRequestList(Event e) throws EventException {
		ChargeAmendAuthRequestListVO paramVo = new ChargeAmendAuthRequestListVO();
		EsmBkg1601Event event = (EsmBkg1601Event) e;
		paramVo = event.getChargeAmendAuthRequestListVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BlRatingBC command = new BlRatingBCImpl();
		try {
			List<ChargeAmendAuthRequestListVO> list = command.searchChargeAmendAuthRequestList(paramVo, account);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00450", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * Charge Amend Request를 Approve.<br>
	 * @author    Lee NamKyung
	 * @param     e Event
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse approveChargeAmendAuthRequest(Event e) throws EventException {
		EsmBkg1601Event event = (EsmBkg1601Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BlRatingBC command = new BlRatingBCImpl();
		BookingUtil bookingUtil = new BookingUtil();
		BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
		CostAssignBC masCmd 				= new CostAssignBCImpl();
		ChargeAmendAuthRequestListVO[] authVOs = event.getChargeAmendAuthRequestListVOs();
		
		try{
        	begin();
        	
        	int cnt = authVOs.length;
			for (int i = 0; i < cnt; i++) {
				BkgBlNoVO bkgBlNoVo = new BkgBlNoVO();
	            bkgBlNoVo.setBkgNo(authVOs[i].getBkgNo());
	    		bkgBlNoVo.setCaUsrId(account.getUsr_id());
	    		bkgBlNoVo = bookingUtil.searchBkgBlNoVO(bkgBlNoVo);
	    		
	    		//history //
	        	HistoryTableVO historyTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_1601", bkgBlNoVo);
	        	
	        	//Exempt Request 승인받은 Interface된 Charge를 삭제
	        	command.removeInterfaceCharge(authVOs[i]);
	        	
	        	command.modifyChargeAmendAuthRequestStatus(authVOs[i], "A", account);
	        	
	        	//history//
	        	historyBC.manageBookingHistory("ESM_BKG_1601", historyTableVO, account);
	        	
	        	//MAS, INV IF
	        	MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
	            masBkgComIfVo.setBkgNo(authVOs[i].getBkgNo());
	            masBkgComIfVo.setCostSrcSysCd("BKG");
	            masBkgComIfVo.setIfRmk("Manage Rate");
	            masBkgComIfVo.setCreUsrId(account.getUsr_id());
	            masBkgComIfVo.setUpdUsrId(account.getUsr_id());
	            masCmd.modifyMasCommonInterface(masBkgComIfVo);	
	            
	            // Back End Job으로 호출 
	            //[21] IBookingARCreationBC::interfaceBKGARInvoiceToINV ( bkgIfVo )
	            BookingARCreationBC bookingARCreationBC = new BookingARCreationBCImpl();
                ARBkgInterfaceCreationVO bkgIfVo = new ARBkgInterfaceCreationVO();
                bkgIfVo.setBkgNo(authVOs[i].getBkgNo());
                bkgIfVo.setManDivInd("B");
                bkgIfVo.setUserId(account.getUsr_id());
                bookingARCreationBC.interfaceBKGARInvoiceToINV(bkgIfVo);
                
                command.distributeCntrRate(bkgBlNoVo.getBkgNo(), account);   
	                
				
			}
        	
        	
        	
        	
        	
        	
        	
      	
        	commit();
        	
        }catch(EventException ex){
        	rollback();
        	throw ex;
        }

		return eventResponse;
	}
	
	/**
	 * Charge Amend Request를 Reject<br>
	 * @author    Lee NamKyung
	 * @param     e Event
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse rejectChargeAmendAuthRequest(Event e) throws EventException {
		EsmBkg1601Event event = (EsmBkg1601Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BlRatingBC command = new BlRatingBCImpl();
		ChargeAmendAuthRequestListVO[] authVOs = event.getChargeAmendAuthRequestListVOs();
		
		try{
        	begin();
        	
        	int cnt = authVOs.length;
			for (int i = 0; i < cnt; i++) {
				command.modifyChargeAmendAuthRequestStatus(authVOs[i], "R", account);
			}
      	
        	commit();
        	
        }catch(EventException ex){
        	rollback();
        	throw ex;
        }

		return eventResponse;
	}


	/**
	 * ESM_BKG_1604 : Open<br>
	 * 조직도를 조회합니다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOrganizationChart(Event e) throws EventException {
		OrganizationChartVO paramVo = new OrganizationChartVO();
		EsmBkg1604Event event = (EsmBkg1604Event) e;
		paramVo = event.getOrganizationChartVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BlRatingBC command = new BlRatingBCImpl();
		try {
			List<OrganizationChartVO> list = command.searchOrganizationChart(paramVo);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00450", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}
	
    /**
     * ESM_BKG_1079 : Open<br>
     * Audit by CNTR Qty Discrepancy 화면의 Combo Item 들을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse initGroupRating(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();

            
        BookingUtil command = new BookingUtil();
        List<BkgComboVO> list = null;
        List<BkgComboVO> list2 = null;
        List<BkgComboVO> list3 = null;
        List<BkgComboVO> list4 = null;
        List<BkgComboVO> list5 = null;
        List<BkgComboVO> list6 = null;
        try {
            command = new BookingUtil();
            list = command.searchCombo("CD03420"); // GROUP RATING RESULT CODE
            eventResponse.setRsVoList(list);
            list2 = command.searchCombo("CD01716"); // CONTRACT TYPE CODE
            eventResponse.setRsVoList(list2);
            list3 = command.searchCombo("CD02080"); // FREIGHT TERM CODE
            eventResponse.setRsVoList(list3);
            list4 = command.searchCombo("CD03425"); // GROUP RATING FAIL REASON CODE
            eventResponse.setRsVoList(list4);
            list5 = command.searchCombo("CD00912"); // YES NO
            eventResponse.setRsVoList(list5);
            list6 = command.searchCombo("CD03438"); // CONTAINER CONFIRM STATUS CODE
            eventResponse.setRsVoList(list6);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("BKG00244",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }	



	/**
	 * ESM_BKG_1605 : Retrieve<br>
	 * Group & Multi B/L Rating을 위한  목록 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupRatingList(Event e) throws EventException {
		GroupRatingVO paramVo = new GroupRatingVO();
		EsmBkg1605Event event = (EsmBkg1605Event) e;
		paramVo = event.getGroupRatingVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BlRatingBC command = new BlRatingBCImpl();
		try {
			List<GroupRatingVO> list = command.searchGroupRatingList(paramVo);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00450", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}



	/**
	 * ESM_BKG_1605 : Save<br>
	 * Group & Multi B/L Rating Self Check저장<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyGroupRatingList(Event e) throws EventException {
		EsmBkg1605Event event = (EsmBkg1605Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GroupRatingVO[] ratinglist = event.getGroupRatingVOs();	
		BlRatingBC command = new BlRatingBCImpl();
		BookingUtil util = new BookingUtil();
		BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
		HistoryTableVO historyTableVO = new HistoryTableVO();
		
		try {
			begin();			
			
			
			for (int i = 0; i < ratinglist.length; i++) {
				if ("U".equals(ratinglist[i].getIbflag()) && "S".equals(ratinglist[i].getGrpRatRsltCd())){
					
					BkgBlNoVO bkgBlNoVo = new BkgBlNoVO();
		            bkgBlNoVo.setBkgNo(ratinglist[i].getBkgNo());
		    		bkgBlNoVo.setCaUsrId(account.getUsr_id());
		    		bkgBlNoVo = util.searchBkgBlNoVO(bkgBlNoVo);
					historyTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_1605", bkgBlNoVo);
					
					ratinglist[i].setUsrId(account.getUsr_id());
					command.modifyGroupRatingList(ratinglist[i]);
					
					historyBC.manageBookingHistory("ESM_BKG_1605", historyTableVO, account);
				}
			}
			
			commit();
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00450", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}



	/**
	 * ESM_BKG_1605 : Retrieve<br>
	 * Group & Multi B/L Rating을 위한  목록 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGroupRatingList(Event e) throws EventException {
		EsmBkg1605Event event = (EsmBkg1605Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BlRatingBC command = new BlRatingBCImpl();
		RfaOftAutoRatingBC rfaOftCmd = new RfaOftAutoRatingBCImpl();  // RFA
		TaaOftAutoRatingBC taaOftCmd = new TaaOftAutoRatingBCImpl();  // TAA
		ScOftAutoRatingBC scOftCmd = new ScOftAutoRatingBCImpl();  // SC
		UnmatchBLBC audCmd = new UnmatchBLBCImpl();
		BookingUtil util = new BookingUtil();
		BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
		BLIssuanceBC bLIssuanceBC = new BLIssuanceBCImpl();
		CostAssignBC masCmd = new CostAssignBCImpl();

		List<SearchRfaOftAutoratingListVO> rfaOftList = null;
		List<SearchTaaOftAutoratingListVO> taaOftList = null;
		List<SearchScOftAutoratingListVO> scOftList = null;
		List<SearchScOftAutoratingListVO> surList = null;
		List<SearchScOftAutoratingListVO> trfSurList = null;		
		RateMainInfoVO rateMainInfoVO = new RateMainInfoVO(); ;
		
		ScOftAutoratingListVO surVo = new ScOftAutoratingListVO();
		
		try {
			GroupRatingVO[] ratinglist = event.getGroupRatingVOs();			
			int cnt = ratinglist.length;
			String bkgNo = "";
			String caFlg = "N";
			String svcScpCd = "";
			String ctrtTpCd = "";
			String rtAplyDt = "";
			String cmdtCd = "";
			String frtTermCd = "";
			String ctrtNo = "";
			String porCd = "";
			String delCd = "";
			String rtStatus = "";
			String rtroKndCd = "";
			String ctrtValid = "";
			String prePpdAmt = "";
			String blNo = "";
			
			for (int i = 0; i < cnt; i++) {				
				begin();
				
				bkgNo = ratinglist[i].getBkgNo();
				svcScpCd = ratinglist[i].getSvcScpCd();
				ctrtTpCd = ratinglist[i].getBkgCtrtTpCd();
				rtAplyDt = ratinglist[i].getRtAplyDt().replace(",", "");
				cmdtCd = ratinglist[i].getCmdtCd();
				frtTermCd = ratinglist[i].getFrtTermCd();
				ctrtNo = ratinglist[i].getCtrtNo();
				porCd = ratinglist[i].getPorCd();
				delCd = ratinglist[i].getDelCd();
				blNo = ratinglist[i].getBlNo();
				rtStatus = "";
	            prePpdAmt = command.searchPpdChgAmt(bkgNo); //Perpaid 금액 변경여부 확인을 위해 저장전 금액 조회
				
				// Rating 실행 전 Contract No Validation
				
				if("R".equals(ctrtTpCd)){
					if("G".equals(ctrtNo.substring(5,6))){
						ctrtValid = util.rfaSpotPricingAvailable(bkgNo+"|"+ctrtNo+"|"+rtAplyDt);
					}else{
						ctrtValid = util.autoratingRfaAvailable(bkgNo+"|"+ctrtNo+"|"+rtAplyDt+"|N");
					}
				// SC는 Customer가 일치하지 않아도 Group Rating 진행. 화면에 Customer 불이치를 보여줌
				//}else if("S".equals(ctrtTpCd)){
				//	ctrtValid = util.autoratingScAvailable(bkgNo+"|"+ctrtNo+"|"+rtAplyDt+"|N");
				}else if("T".equals(ctrtTpCd)){
					ctrtValid = util.autoratingTaaAvailable(bkgNo+"|"+ctrtNo+"|"+rtAplyDt+"|N");
				}
				
				//Contract No가 유효하지 않으면 결과(Fail)/사유를 기록하고 종료
				if("N".equals(ctrtValid)){
					command.modifyGroupRatingStatus(bkgNo, "F", "C");  //Fail, Contract Invalid
					commit();
					continue;
				}
				
				// 변경 전History 관리를 위한 초기 데이터 조회
				BkgBlNoVO bkgBlNoVo = new BkgBlNoVO();
	            bkgBlNoVo.setBkgNo(bkgNo);
	    		bkgBlNoVo.setCaUsrId(account.getUsr_id());
	    		bkgBlNoVo = util.searchBkgBlNoVO(bkgBlNoVo);
				HistoryTableVO historyTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_1605", bkgBlNoVo);
				
				// Autorating 실행
				
				if("R".equals(ctrtTpCd)){
					if("US".equals(porCd.substring(0, 2)) || "CA".equals(porCd.substring(0, 2)) ||
							"US".equals(delCd.substring(0, 2)) || "CA".equals(delCd.substring(0, 2))) {
						rfaOftList = rfaOftCmd.searchRfaOftAutoratingList(bkgNo, caFlg, "", rtAplyDt, svcScpCd, "");  // RFA Temp    				
            		
        			}else{
        				rfaOftList = rfaOftCmd.searchRfaFICOftAutoratingList(bkgNo, caFlg, "", rtAplyDt, svcScpCd, "");
        			}
					audCmd.createRfaSurchargeInput(bkgNo, rfaOftList, account);
				}else if("S".equals(ctrtTpCd)){
					/* (1) TPE, TJE, MXE, ACE => TPE => TPS
					 * (2) TPW,      MXW, ACW => TPW => TPS
					 * (3) TAE, ASE, SAS      => TAE  
					 * (4) TAW, ASW, SAN      => TAW
					 * (5) OTHER              => ETC
		        	 */
		        	if("TPE".equals(svcScpCd)|"TPW".equals(svcScpCd)|"TJE".equals(svcScpCd)|"MXE".equals(svcScpCd)|"ACE".equals(svcScpCd)|"MXW".equals(svcScpCd)|"ACW".equals(svcScpCd)){
		        		scOftList = scOftCmd.searchScTPSOftAutoratingList(bkgNo, caFlg, ctrtNo, rtAplyDt, svcScpCd, cmdtCd, "");	
		        	}else if("TAE".equals(svcScpCd)|"ASE".equals(svcScpCd)|"SAS".equals(svcScpCd)){
		        		scOftList = scOftCmd.searchScTAEOftAutoratingList(bkgNo, caFlg, ctrtNo, rtAplyDt, svcScpCd, cmdtCd, "");		        	
		        	}else if("TAW".equals(svcScpCd)|"ASW".equals(svcScpCd)|"SAN".equals(svcScpCd)){
		        		scOftList = scOftCmd.searchScTAWOftAutoratingList(bkgNo, caFlg, ctrtNo, rtAplyDt, svcScpCd, cmdtCd, "");	
		        	}else{
		        		scOftList = scOftCmd.searchScETCOftAutoratingList(bkgNo, caFlg, ctrtNo, rtAplyDt, svcScpCd, cmdtCd, "");
		        	}
		        	audCmd.createScSurchargeInput(bkgNo, caFlg, scOftList, account);
				}else{
					taaOftList = taaOftCmd.searchTaaOftAutoratingList(bkgNo, caFlg, "", rtAplyDt, svcScpCd, "");    
        			// TAA Surcharge를 생성 : 경우의 수만큼 BKG_AUTO_RT_OCN_FRT_TMP 생성, RFA Surcharge 와 다르게 TAA는 'OAR', 'DAR' 없다.
					audCmd.createTaaSurchargeInput(bkgNo, taaOftList, account);
				}
				
				//Temp DB에 OFT Insert
				audCmd.createRevenueAuditOftForMultiRating(); 
				
				// 조회한 운임으로 Group Rating 가능한 상태인지 확인
				rtStatus = command.searchGroupRatingStatus(bkgNo);
				
				if(!"".equals(rtStatus)){
					//운임이 없거나, 적용 가능한 운임이 다건인 경우  Fail
					command.modifyGroupRatingStatus(bkgNo, "F", rtStatus);
					
				} else {
		        		        
			        surVo.setBkgNo(bkgNo);
			        surVo.setCaFlg("N");
			        surVo.setCmdtCd(cmdtCd);
			        surVo.setsvcScpCd(svcScpCd);
			        surVo.setCtrtTpCd(ctrtTpCd);
			        surVo.setRtAplyDt(rtAplyDt);
			        surVo.setRtAudTpCd("");
			        surVo.setCtrtNo(ctrtNo);
			        surVo.setFrtTermCd(frtTermCd);
			                
			        
			        // Surcharge Rating 실행
			        surList = scOftCmd.searchSurchargeAutoratingList(surVo);
			        audCmd.createRevenueAuditSurcharge(surList, account); 
			        	
									
					// auto_Rt_his 
			        command.autoRatingHistory(bkgNo);
			        
			        //화면에서 변경한 값, Rating결과로 저장되어야 할 값 세팅
			        rateMainInfoVO.setBkgNo(bkgNo);
					rateMainInfoVO.setFrtTermCd(frtTermCd);  // 화면변경
					rateMainInfoVO.setRtAplyDt(rtAplyDt);
					rateMainInfoVO.setCalcCtrtTpCd(ctrtTpCd);
					rateMainInfoVO.setUserId(account.getUsr_id());
					
					if("R".equals(ctrtTpCd) && rfaOftList.size() > 0){
						rateMainInfoVO.setPrcRtMtchPattCd(rfaOftList.get(0).getPrcRtMtchPattCd().substring(1, 7));
						rateMainInfoVO.setPrcGenSpclRtTpCd(rfaOftList.get(0).getPrcGenSpclRtTpCd());
						rateMainInfoVO.setPrcCmdtHdrSeq(rfaOftList.get(0).getPrcCmdtHdrSeq());
						rateMainInfoVO.setPrcRoutSeq(rfaOftList.get(0).getPrcRoutSeq());	
						if(rfaOftList.get(0).getMstRfaRoutId()!=null && rfaOftList.get(0).getMstRfaRoutId().length()>=18)
							rateMainInfoVO.setMstRfaRoutId(rfaOftList.get(0).getMstRfaRoutId());
					}else if("S".equals(ctrtTpCd) && scOftList.size() > 0){
						rateMainInfoVO.setPrcRtMtchPattCd(scOftList.get(0).getRtMtchPattCd());
						rateMainInfoVO.setPrcGenSpclRtTpCd(scOftList.get(0).getPrcGenSpclRtTpCd());
						rateMainInfoVO.setPrcCmdtHdrSeq(scOftList.get(0).getPrcCmdtHdrSeq());
						rateMainInfoVO.setPrcRoutSeq(scOftList.get(0).getPrcRoutSeq());
					}else if("T".equals(ctrtTpCd) && taaOftList.size() > 0){
						rateMainInfoVO.setPrcRtMtchPattCd(taaOftList.get(0).getPrcRtMtchPattCd());
						rateMainInfoVO.setPrcGenSpclRtTpCd(taaOftList.get(0).getPrcGenSpclRtTpCd());
						rateMainInfoVO.setPrcCmdtHdrSeq(taaOftList.get(0).getPrcCmdtHdrSeq());
						rateMainInfoVO.setPrcRoutSeq(taaOftList.get(0).getPrcRoutSeq());					
					}
	
					command.manageGroupRating(rateMainInfoVO, account);
			        
			        
			        rtroKndCd = "";
			        if("R".equals(ctrtTpCd) && rfaOftList.size() > 0){		            
			            // PCT+1 이후 OFT 변경 모니터링
				        for(int r = 0; r < rfaOftList.size(); r++){
				        	if("Y".equals(rfaOftList.get(r).getRtroFlg())){
				        		rtroKndCd = "R";
				        		break;
				        	}							
						}
			        }
			        
			        //Retroactive Kind Code Update
			        //Group Rating에서는 Contract Change, OFT Update가 없기 때문에  RetroactiveRFA만 기록된다.
			        //PCT가 현재시점 이후로 변경될 경우 RTRO_KND_CD를 리셋해 주는 기능 때문에 전체 Contract Type에 대해 메서드 수행
			        command.modifyRtroactiveKindCd(bkgNo, rtroKndCd, caFlg);
		            
	
			        // 4.Tariff Rating 실행
			        trfSurList = scOftCmd.searchTariffSurchargeAutoratingList(surVo);
			        command.addTariffSurchargeRate(trfSurList, "N", account);		
			        
			        
					// 3.History 저장
			        
					//Autorating및 심사를 위해 저장한 Global Temp Table의 데이터 삭제.
		            //BackEndJob 구조상 begin&commit 사용 불가로 인해 삭제 SQL 추가
		            scOftCmd.manageAutoratingTempTables();
		            
                    
					
					// 5.TPF I/F 실행
		            // Group Rating에서는 I/F여부를 사용자에게 확인받지 않고 무조건 I/F진행.
		            if("CN".equals(porCd.substring(0,2)) || "CN".equals(delCd.substring(0,2))){
		            	command.manageTPFSurcharge(bkgNo, "N", account);
		            }

			        
			        // Group Rating 실행결과 저장(Success)
			        command.modifyGroupRatingStatus(bkgNo, "S", rtStatus);
		            
			        // 2017.04.19 iylee Group Auto-Rating을 실행하면 전체 BL에 대한 Self Audit도 완료했다고 Status를 Update 함. [박유숙 부장님 요청]
					command.modifyAudSts(rateMainInfoVO.getBkgNo(), "Y", account, caFlg);

			        
					// 기타 등등.  Contract Change 변경시 실행되는 로직 제외.
		            // BDR 걸리지 않은 BKG만 대상으로 Group Rating. > CA 조건 모두 제외함.
		            
		            historyBC.manageBookingHistory("ESM_BKG_1605", historyTableVO, account);

	            	List<BkgNtcHisVO> bkgNtcHisVOs = bLIssuanceBC.createDraftBlEdiAuto(bkgNo, "N",  account);
	
	    			if (bkgNtcHisVOs != null) {
	    				if (bkgNtcHisVOs.size() > 0) {
	    					historyBC.createBkgNtcHis(bkgNtcHisVOs,"ESM_BKG_0095");
	    					
							//philips 계약인 BKG에 대해서 DBL전송
							String philips = bLIssuanceBC.searchPhilipsCheck(bkgNo);
							
			    			//philips 계약인 BKG에 대해서 DBL전송
			    			if(null!=philips && !"".equals(philips)){
			    				List<BkgNtcHisVO> bkgHisVOs = null;
			    				StringBuilder sbParam = new StringBuilder();
			    				
			    				String draftRemark = bLIssuanceBC.searchDraftRemark(bkgNo);
	
			                	
			            		sbParam.append("/rv");
			            		sbParam.append(" form_bkgNo[('").append(bkgNo).append("')]");
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
			    				dblWblVOs[0].setBkgNo(bkgNo);
			    				dblWblVOs[0].setBlNo(bkgNo);
			    				dblWblVOs[0].setSyscd("BKG");
			    				dblWblVOs[0].setTmplmrd("ESM_BKG_0109_DBL.mrd");
			    				dblWblVOs[0].setBatchflg("N");
			    				dblWblVOs[0].setTmplparam(sbParam.toString());
			    				dblWblVOs[0].setRcveml(philips);
			    				dblWblVOs[0].setTmplmrdpdf("SMLM"+bkgNo+".pdf");
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
			                    bkgHisVOs = bLIssuanceBC.sendDblWblByEmail(dblWblVOs, null, account);
			    				if(bkgHisVOs.size()>0){
			    					historyBC.createBkgNtcHis(bkgHisVOs,"ESM_BKG_0095");
			    				}
	
			    			}
	    				}
	    			}
	                
	                /* 심영우 과장님 요청 2010.03.25
	                 * Charge 화면에서 Save 시 Collect 나 3rd Collect 가 0 값일 경우 
	                 * CargoRelease 쪽 을 호출 하여 EDI 전송 한다 
	                 * C/A 유무와 상관없이 Charge 에서 Save 된 경우 EDI를 전송 한다 2010.05.04
	                 * */  
	                
	                List<SearchFocByFreightListVO>  searchFocByFreightListVO = null;
	                    
	                searchFocByFreightListVO = command.searchFocByFreightList(bkgNo,"N");
	            	/* 에러 메시지 표시 */
	    			if(searchFocByFreightListVO == null){
	    				throw new EventException((String)new ErrorHandler("BKG08058").getMessage());
	    			}

	    			//Inbound Cr관련 로그
	    			util.addBkgLog("BKG_US_CGO_SWB", bkgNo, "11.Group Rate CHARGE START colAmt:"+searchFocByFreightListVO.get(0).getcolAmt()+", cctAmt:" + searchFocByFreightListVO.get(0).getcctAmt());			
	    			if(searchFocByFreightListVO.get(0).getcolAmt().equals("0") && searchFocByFreightListVO.get(0).getcctAmt().equals("0")){
	     
	    			log.debug("===============================================================");
	    			log.debug("[start][======== [CargoReleaseOrderBCImpl] :: setupFocByFreight ]");
	    			log.debug("===============================================================");
	    			
	    			CargoReleaseOrderBC cargoBC = new CargoReleaseOrderBCImpl();
	    			FrtCltLstVO frtCltLst = new FrtCltLstVO();
	    			/* BL No 는 12 자리 까지만 넘김 */
	    			frtCltLst.setBlNo(blNo.substring(0,12));
	    			frtCltLst.setFrtCltFlg("Y");
	    			frtCltLst.setEvntOfcCd(account.getOfc_cd());
	    			frtCltLst.setEvntUsrId(account.getUsr_id());
	    			frtCltLst.setEvntDt(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
	    			frtCltLst.setCgorTeamCd("F");
	    			frtCltLst.setCgoEvntNm("CHARGE");
	    			
	    				try{
	    					util.addBkgLog("BKG_US_CGO_SWB", bkgNo, "12.Go");					
	    					cargoBC.setupFocByFreight(frtCltLst);
	    				}catch(Exception e1){
	    					log.debug("[end:: CargoReleaseOrderBC == manageRate update ]==========");
	    					log.error(e1.getMessage()); // 2011.07.15
	    				}
	    			} 
	    			util.addBkgLog("BKG_US_CGO_SWB", bkgNo, "Group Rate CHARGE END");
	    			
	    			//Perpaid 금액 변경시 e-mail 전송로직 시작
	                String postPpdAmt = command.searchPpdChgAmt(bkgNo);
	                if(!prePpdAmt.equals(postPpdAmt)){
	                	// BL Release 담당자 email 조회
	                	String usrEml = command.searchPpdChgRlsEmail(bkgNo);
	                	
	                	if(!usrEml.equals("")){
	                		// Email에 보낼 Data 조회
	                    	List<EmailPpdInfoVO> list = command.searchPpdChgInfo(bkgNo, account.getUsr_id());
	                		if(list.size() > 0){
	                			//Send Email
	                			command.sendEmailPpdAmount(list, usrEml, account.getUsr_eml(), account.getUsr_nm());
	                		}
	                	}	
	                }
	              
	    			
	    			/* MAS */
                    MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
                    masBkgComIfVo.setBkgNo(bkgNo);
                    masBkgComIfVo.setCostSrcSysCd("BKG");
                    masBkgComIfVo.setIfRmk("Manage Rate");
                    masBkgComIfVo.setCreUsrId(account.getUsr_id());
                    masBkgComIfVo.setUpdUsrId(account.getUsr_id());
                    masCmd.modifyMasCommonInterface(masBkgComIfVo);	
                    
                    // Back End Job으로 호출 
                    //[21] IBookingARCreationBC::interfaceBKGARInvoiceToINV ( bkgIfVo )
	                BookingARCreationBC bookingARCreationBC = new BookingARCreationBCImpl();
	                ARBkgInterfaceCreationVO bkgIfVo = new ARBkgInterfaceCreationVO();
	                bkgIfVo.setBkgNo(bkgNo);
	                bkgIfVo.setManDivInd("B");
	                bkgIfVo.setUserId(account.getUsr_id());
	                bookingARCreationBC.interfaceBKGARInvoiceToINV(bkgIfVo);
	                
	                command.distributeCntrRate(bkgNo, account);     
	                
		            
				}
				commit();
			}
				
				
			
			
			// 6.조회결과 리턴? 하까마까
//			List<GroupRatingVO> list = command.searchGroupRatingList(paramVo);
//			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("BKG00450", new String[] {}).getMessage(), ex);
		}

		return eventResponse;
	}


    
//    /**
//     * Tariff Surcharge Rating결과 저장<br>
//     * 
//     * @author JJ Kim
//     * @param e Event
//     * @exception EventException
//     */
//    private void manageTariffSurcharge(Event e) throws EventException {
//        log.debug("[START:: BlRatingSC == manageTariffSurcharge  ]==========");
//        EsmBkg007908Event event 			= (EsmBkg007908Event) e;
//        BlRatingBC blCmd 				= new BlRatingBCImpl();
//        RfaOftAutoRatingBC rfaCmd = new RfaOftAutoRatingBCImpl();
//        ScOftAutoRatingBC scCmd = new ScOftAutoRatingBCImpl();
//        TaaOftAutoRatingBC taaCmd = new TaaOftAutoRatingBCImpl();
//        SurchargeAutoRatingBC surCmd = new SurchargeAutoRatingBCImpl();
//		UnmatchBLBC rasCmd = new UnmatchBLBCImpl();
//        
//        String bkgNo 		= event.getBkg_no();
//        String caFlag 		= event.getCaflag();
//        RateMainInfoVO[] rateMainInfoVOs	= event.getRateMainInfoVOs();
//        String scNo = rateMainInfoVOs[0].getScNo1()+rateMainInfoVOs[0].getScNo2();
//        String rfaNo = rateMainInfoVOs[0].getRfaNo();
//        String taaNo = rateMainInfoVOs[0].getTaaNo();
//        String rtAplyDt = rateMainInfoVOs[0].getRtAplyDt().replaceAll("-",""); 
//        String svcScpCd = rateMainInfoVOs[0].getSvcScpCd();
//        String cmdtCd = rateMainInfoVOs[0].getCmdtCd();
//        String frtTermCd = rateMainInfoVOs[0].getFrtTermCd();
//        String prcRtMtchPattCd = rateMainInfoVOs[0].getPrcRtMtchPattCd();
//        String prcGenSpclRtTpCd = rateMainInfoVOs[0].getPrcGenSpclRtTpCd();
//        String ctrtNo = "";
//        String ctrtTpCd = "";
//        RateOutVO rateOut 		= null;
//		List<SearchRfaOftAutoratingListVO> rfaOftList = null;
//		List<SearchTaaOftAutoratingListVO> taaOftList = null;
//		List<SearchScOftAutoratingListVO> scOftList = null;
//		List<SearchRfaOftAutoratingListVO> rfaInsList = new ArrayList<SearchRfaOftAutoratingListVO>();
//		List<SearchTaaOftAutoratingListVO> taaInsList = new ArrayList<SearchTaaOftAutoratingListVO>();
//		List<SearchScOftAutoratingListVO> scInsList = new ArrayList<SearchScOftAutoratingListVO>();
//		List<SearchScOftAutoratingListVO> surList = null;
//		
//        
//        try{
//            RateInVO rateInVO = new RateInVO();
//            rateInVO.setBkg_no(bkgNo);
//            rateInVO.setAccount(account);
//            rateOut = blCmd.searchRate(rateInVO);
//            List<BkgChgRateVO> bkgChgRate = rateOut.getBkgChgRateVOs();
//        	
//        	if(!"".equals(rfaNo)){ // "R".equals(ctrtTpCd)
//        		String hinterFlg = rfaCmd.searchHinterlandApplyFlag(rtAplyDt, bkgNo, caFlag);
//        		ctrtNo = rfaNo; ctrtTpCd="R";
//        		if ("FIC".equals(hinterFlg)) {
//        			rfaOftList = rfaCmd.searchRfaFICOftAutoratingList(bkgNo, caFlag, rfaNo, rtAplyDt, svcScpCd, cmdtCd);
//    			} else if ("AEE".equals(svcScpCd) && "Y".equals(hinterFlg)) {
//    				rfaOftList = rfaCmd.searchRfaAEEOftAutoratingList(bkgNo, caFlag, rfaNo, rtAplyDt, svcScpCd, cmdtCd);
//    			} else if ("AEW".equals(svcScpCd) && "Y".equals(hinterFlg)) {
//    				rfaOftList = rfaCmd.searchRfaAEWOftAutoratingList(bkgNo, caFlag, rfaNo, rtAplyDt, svcScpCd, cmdtCd);
//    			} else {
//    				rfaOftList = rfaCmd.searchRfaOftAutoratingList(bkgNo, caFlag, rfaNo, rtAplyDt, svcScpCd, cmdtCd);
//    			}
//        		for(int i =0; i<rfaOftList.size(); i++){
//            		if(!"".equals(prcRtMtchPattCd)){
//            			if(prcRtMtchPattCd.equals(rfaOftList.get(i).getRtMtchPattCd().substring(1, 7))){
//            				
//            				for (int j = 0; j < bkgChgRate.size(); j++) {
//            					if("OFT".equals(bkgChgRate.get(j).getChgCd()))
//            						if( (bkgChgRate.get(j).getRatUtCd().equals(rfaOftList.get(i).getRatUtCd()))
//            								&& (Double.parseDouble(bkgChgRate.get(j).getChgUtAmt()) == Double.parseDouble(rfaOftList.get(i).getFnlFrtRtAmt()))){
//            							rfaInsList.add(rfaOftList.get(i));
//            					}
//            				}
//            			}
//            		}
//            	}
//        		if(rfaInsList.size() > 0){
//        			rasCmd.createRfaSurchargeInput(bkgNo, rfaInsList, account);
//        		}
//        	}else if(!"".equals(scNo)){ // "S".equals(ctrtTpCd)
//        		ctrtNo = scNo; ctrtTpCd="S";
//        		if("TPE".equals(svcScpCd)|"TPW".equals(svcScpCd)|"TJE".equals(svcScpCd)|"MXE".equals(svcScpCd)|"ACE".equals(svcScpCd)|"MXW".equals(svcScpCd)|"ACW".equals(svcScpCd)){
//        			scOftList = scCmd.searchScTPSOftAutoratingList(bkgNo,caFlag,scNo,rtAplyDt,svcScpCd,cmdtCd,"");
//        		}else if("TAE".equals(svcScpCd)|"ASE".equals(svcScpCd)|"SAS".equals(svcScpCd)){
//        			scOftList = scCmd.searchScTAEOftAutoratingList(bkgNo,caFlag,scNo,rtAplyDt,svcScpCd,cmdtCd,"");
//        		}else if("TAW".equals(svcScpCd)|"ASW".equals(svcScpCd)|"SAN".equals(svcScpCd)){
//        			scOftList = scCmd.searchScTAWOftAutoratingList(bkgNo,caFlag,scNo,rtAplyDt,svcScpCd,cmdtCd,"");
//        		}else{
//        			scOftList = scCmd.searchScETCOftAutoratingList(bkgNo,caFlag,scNo,rtAplyDt,svcScpCd,cmdtCd,"");
//        		}
//
//            	for(int i =0; i<scOftList.size(); i++){
//            		if(!"".equals(prcRtMtchPattCd) && !"".equals(prcGenSpclRtTpCd)){
//            			if(prcRtMtchPattCd.equals(scOftList.get(i).getRtMtchPattCd().substring(1, 5)) 
//            					&& prcGenSpclRtTpCd.equals(scOftList.get(i).getPrcGenSpclRtTpCd())){
//            				scInsList.add(scOftList.get(i));
//            			}
//            		}
//            	}
//            	if(scInsList.size() > 0){
//            		rasCmd.createScSurchargeInput(bkgNo, scInsList, account);
//            	}
//        	}else{
//        		ctrtNo = taaNo;  ctrtTpCd="T";
//        		taaOftList = taaCmd.searchTaaOftAutoratingList(bkgNo,caFlag,taaNo,rtAplyDt,svcScpCd,cmdtCd);
//
//        		for(int i =0; i<taaOftList.size(); i++){
//            		for (int j = 0; j < bkgChgRate.size(); j++) {
//    					if("OFT".equals(bkgChgRate.get(j).getChgCd()))
//    						if( (bkgChgRate.get(j).getRatUtCd().equals(taaOftList.get(i).getRatUtCd()))
//    								&& (Double.parseDouble(bkgChgRate.get(j).getChgUtAmt()) == Double.parseDouble(taaOftList.get(i).getFnlFrtRtAmt()))){
//    							taaInsList.add(taaOftList.get(i));
//    					}
//    				}
//            	}
//        		if(taaInsList.size() > 0){
//        			rasCmd.createTaaSurchargeInput(bkgNo, taaInsList, account);
//        		}
//        	}
//        	
//        	ScOftAutoratingListVO surCmdVo = new ScOftAutoratingListVO();
//        	surCmdVo.setBkgNo(bkgNo);
//        	surCmdVo.setCaFlg(caFlag);
//        	surCmdVo.setCtrtNo(ctrtNo);
//        	surCmdVo.setRtAplyDt(rtAplyDt);
//        	surCmdVo.setsvcScpCd(svcScpCd);
//        	surCmdVo.setCmdtCd(cmdtCd);
//        	surCmdVo.setFrtTermCd(frtTermCd);
//        	surCmdVo.setCtrtTpCd(ctrtTpCd);
//        	surList = scCmd.searchTariffSurchargeAutoratingList(surCmdVo);
//        	blCmd.addTariffSurchargeRate(surList, caFlag, account);
//        } catch(EventException ex) {
//			throw ex;
//		} catch(Exception ex) {
//			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
//		}
//    }
}