/*==========================================================
*Copyright(c) 2009 CyberLo= gitec
*@FileName       : CargoReleaseOrderMgtSC.java
*@FileTitle      :
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.04.28
*@LastModifier   : 임진영
*@LastVersion    : 1.0
* 2009.04.28 임진영
* 1.0 Creation
* --------------------------------------------------------------------------------------
* History
* 2010.09.06 이지영 [CHM-201005721-01] [ESM-BKG] VVD별 OTS 미수금 수신
* 2011.07.15 김진승 [CHM-201111820] Split 03-R4J Rule Upgrade 관련 소스품질 향상을 위한 조치
* 2011.08.02 김봉균 [CHM-201112547-01]  India Cargo Release 기능 보완 요청
* 2011.10.28 김봉균 [CHM-201113640-01] E-DO Free Time관련 기능 추가(KT-NET)
* 2012.02.21 김보배 [CHM-201216109] [BKG] Japan Cargo Release 의 History 기능 개선 요청
* 2012.02.24 김보배 [CHM-201216327] [BKG] 수입 냉동화물에 대한 자가운송 규제관련(D/O, 자가운송 승인전 팝업요청)
* 2012.08.06 김보배 [CHM-201219299] [BKG] KOREA E-D/O 조회 기능 보완 요청
* 2012.12.03 조정민 [CHM-201221434] [EU Full CNTR RLS화면] 필수값 변경 (P/up date, Rls expiry date)
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBC;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerGrpVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerParmVO;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.basic.StatusInquiryBC;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.basic.StatusInquiryBCImpl;
import com.hanjin.apps.alps.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBStatusByBkgNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBC;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBCImpl;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.EdiSendJapDorBackEndJob;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.ESM0710001Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0128Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0130Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0131Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0132Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0133Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0134Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0135Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0136Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0137Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0272Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0273Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0326Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0579Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0680Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0682Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0684Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0694Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0711Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0737Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0909Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0923Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0936Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0937Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0938Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0939Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0954Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0999Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg1000Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg1001Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg1018Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg1035Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg1052Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg1167Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg1177Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg1515Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.BkgPsaEdoAckSchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseBkbcBlVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CstmsClrVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DmtChargeVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCancelVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCheckListSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoHisVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoHoldVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoMstVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoPfmsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoPrnRmkVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRcvrInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRcvrVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRefVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRlseVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoVtyDtUpdHisVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdiYardInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoCntrRqstsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoRqstVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoRqstsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoTransBlInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoMstVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoRcvrVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FrtCltLstVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrdVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderEdiSendVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderHisSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderHisVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderMailVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdDoEdiTransVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoCancelVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoMstVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseReportVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoSaveVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IndiaDoNtcSendVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoHisListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoHisSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoIssueVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoMstVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDorEdiTransVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoAttorneyDtlVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoAttorneyVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoCancelVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoMstVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoRlseVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OblRdemVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OtsRcvInfoVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.PsaDoEdiTransVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.SearchEdoCntrPtyTrspVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.ToTBilAmtVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseBkbcBlVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseHisVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseSearchVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBCImpl;
import com.hanjin.framework.component.backend.core.BackEndJobManager;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.CheckUtils;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.code.CodeInfo;
import com.hanjin.framework.component.util.code.CodeUtil;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.irep.enisEsm.ESM0710001Document.ESM0710001.DataArea.ROW;
import com.hanjin.syscommon.common.table.BkgBlIssVO;
import com.hanjin.syscommon.common.table.BkgCgoRlseVO;
import com.hanjin.syscommon.common.table.BkgDoFomVO;
import com.hanjin.syscommon.common.table.BkgDoRefVO;
import com.hanjin.syscommon.common.table.BkgDoVO;
import com.hanjin.syscommon.common.table.BkgEdoLogVO;
import com.hanjin.syscommon.common.table.BkgHrdCdgCtntVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.BkgOtsDtlVO;
import com.hanjin.syscommon.common.table.BkgOutstandingVO;

/**
 * ALPUS - cargoreleaseordermgt Business Logic ServiceCommand - ALPS-cargoreleaseordermgt 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author Lim Jinyoung
 * @see InboundNoticeDBDAO
 * @since J2EE 1.4
 */
public class CargoReleaseOrderMgtSC extends ServiceCommandSupport {

    // Login User Information
    private SignOnUserAccount account = null;

    /**
     * CargoReleaseOrderMgt 업무 시나리오 선행작업<br>
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
     * CargoReleaseOrderMgt 업무 시나리오 마감작업<br>
     */
    public void doEnd() {
        log.debug("CargoReleaseOrderMgt 종료");
    }

    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * ALPS-cargoreleaseordermgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        // RDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = null;

        // SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분

    /******************************************************************************************
        Author :Lim JinYoung Start
    *******************************************************************************************/
          if (e.getEventName().equalsIgnoreCase("EsmBkg1001Event")) {
              if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                  eventResponse = searchKorDoCustList(e);
              }
          }else if (e.getEventName().equalsIgnoreCase("EsmBkg0711Event")) {
              if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                  eventResponse = searchDoHistory(e);
              }
          }else if (e.getEventName().equalsIgnoreCase("EsmBkg1000Event")) {
              if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                  eventResponse = searchKorDoCustList(e);
              }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                  eventResponse = manageKorDoCust(e);
              }
          }else if (e.getEventName().equalsIgnoreCase("EsmBkg0999Event")) {
              if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                  eventResponse = searchKorDoAttorneyList(e);
              }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                  eventResponse = manageKorDoAttorney(e);
              }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                  eventResponse = searchKorDoAttorneyDtl(e);
              }
          // Korea D/O 발행 대상 B/L에 대한 정보를 처리 한다.
          }else if (e.getEventName().equalsIgnoreCase("EsmBkg0682Event")) {
              if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
                  eventResponse = searchKorDo(e);
              }else if(e.getFormCommand().isCommand(FormCommand.MODIFY)){
                  eventResponse = this.manageKorDo(e);
              }else if(e.getFormCommand().isCommand(FormCommand.MULTI04)){
                  eventResponse = this.assignDo(e);
              }else if(e.getFormCommand().isCommand(FormCommand.MULTI05)){
                  eventResponse = this.cancelKorDo(e);
              }else if(e.getFormCommand().isCommand(FormCommand.MULTI06)){
                  eventResponse = this.releaseKorDo(e);
              }else if(e.getFormCommand().isCommand(FormCommand.MULTI07)){
                  eventResponse = this.holdDo(e);
              }else if(e.getFormCommand().isCommand(FormCommand.MULTI08)){
                  eventResponse = transmitEdiKorDo(e); //S/T Cancel
              }else if(e.getFormCommand().isCommand(FormCommand.COMMAND06)){
                  eventResponse = searchBkgNoByBlNo(e); //BL NO로 BKG NO 찾기
              }else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
                  eventResponse = this.receiptEdoRqstAck(e);
              }else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
                  eventResponse = receiptEdo(e);
              }else if(e.getFormCommand().isCommand(FormCommand.MULTI03)){
                  eventResponse = receiptEdoLog(e);
              }
          }else if (e.getEventName().equalsIgnoreCase("EsmBkg0737Event")) {
              if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                  eventResponse = this.transmitEdiByEdo(e);
              } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                  eventResponse = this.searchEdoTrasnBlInfo(e);
              }
          //// Japan D/O 발행 대상 B/L에 대한 정보를 처리 한다.
          }else if (e.getEventName().equalsIgnoreCase("EsmBkg0326Event")) {
              if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                  eventResponse = this.searchJapDo(e);
              }else if(e.getFormCommand().isCommand(FormCommand.MODIFY)){
                  eventResponse = this.manageJapDo(e);
              }else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
                  eventResponse = this.issueJapDo(e);
              }else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
                  eventResponse = this.cancelDo(e);
              }else if(e.getFormCommand().isCommand(FormCommand.MULTI03)){
                  eventResponse = this.transmitEdiJapDor(e);
              }else if(e.getFormCommand().isCommand(FormCommand.MULTI06)){
                  eventResponse = this.transmitEdiJapDorCancel(e);
              }else if(e.getFormCommand().isCommand(FormCommand.MULTI05)){
                  eventResponse = this.modifyJapDoId(e);
              }else if(e.getFormCommand().isCommand(FormCommand.MULTI04)){
                  eventResponse = this.holdDo(e);
              }
          }
    /******************************************************************************************
        Author :Lim JinYoung End
    *******************************************************************************************/

    /******************************************************************************************
        Author :Park SungHo Start
    *******************************************************************************************/
        else if  (e.getEventName().equalsIgnoreCase("ESM0710001Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = this.receiveOtsInfo(e);
            }
        }
        //0909
        else if  (e.getEventName().equalsIgnoreCase("EsmBkg0909Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Master 조회
                eventResponse = this.searchUsCgoRlseList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {//Detail 조회
                eventResponse = this.searchUsCgoRlseFoc(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {//OTS,DEM 정보가져오기
                eventResponse = this.searchErpOtsInfo(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {//Original Bill of Lading Status 정보 가져오기
                eventResponse = this.searchUsCgoRlseBlStatus(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {//CHANGE POD : COD 0156, Booking Inquiry 0079_01 CgoRlse Check
                eventResponse = this.searchUsCgoRlseBlStatusChangePod(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {//저장(SAVE) 0909용
                eventResponse = this.manageUsCgoRlse(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {//CHANGE POD : COD 0156, Booking Inquiry 0079_01 CgoRlse
            	eventResponse = this.manageUsCgoRlseChangePod(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI03)) {//Hold
                eventResponse = this.manageUsCgoRlseHold(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI09)) {//저장(SAVE) C/S 쪽
                eventResponse = this.manageDoHldRmk(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI16)) {//FRT 쪽 호출 테스트
                eventResponse = this.setupFocByFreight(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI17)) {//OBL 쪽 호출 테스트
                eventResponse = this.setupFocByObl(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI18)) {//CSTMS 쪽 호출 테스트
                eventResponse = this.setupFocByCstms(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI20)) {//REMARK SAVE
                eventResponse = this.manageDoHldRmk(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI05)) {//WEB B/L Printed Check
                eventResponse = this.manageOblInterSerNoCheck(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)) {//WEB B/L Printed 조회
                eventResponse = this.searchOblInterSerNoCheckInfo(e);
            }
        }
    /******************************************************************************************
        Author :Park SungHo End
    *******************************************************************************************/

    /******************************************************************************************
        Author :An JinEung Start
    *******************************************************************************************/
        // eDO 에 대한 정보를 처리 한다.
        else if (e.getEventName().equalsIgnoreCase("EsmBkg0132Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchEdoRqstList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
                eventResponse = this.removeEdoErrData(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchEdoCntrRqstList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = transmitEdiBySelfTransEdo(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = transmitEdiByInbondTransEdo(e);
            }
        // eDO Issue Application에 대한 정보를 처리 한다.
        }else if (e.getEventName().equalsIgnoreCase("EsmBkg0133Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchEdoByDoRqst(e);
                // rvwFlg 가 N 인 경우에만 UPDATE
                String rvwFlg = ((EsmBkg0133Event)e).getRvwFlg();
                if("N".equals(rvwFlg)) {
                	modifyEdoReviewFlag(e);
                }
            }
        //D/O EDI Transmit Log List Inquiry에 대한 정보를 처리한다.
        }else if (e.getEventName().equalsIgnoreCase("EsmBkg0134Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchEdoTransLog(e);
            }
        //KT-Net으로 들어온 EDI로 들어온 In-bond Transportation Application에 대한 정보를 처리한다.
        }else if (e.getEventName().equalsIgnoreCase("EsmBkg0135Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchEdoByIbdTrspRqst(e);
            }
        //KT-Net으로 들어온 EDI로 들어온 Merchant Haulage Application 에 대한 정보를 처리한다.
        }else if (e.getEventName().equalsIgnoreCase("EsmBkg0136Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchEdoBySelfTrspRqst(e);
            }
        //Cargo Release Order의 Office Default From Setup 에 대한 정보를 처리한다.
        }else if (e.getEventName().equalsIgnoreCase("EsmBkg0137Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchDoForm(e);
            }else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
                eventResponse = removeDoForm(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = setupDoForm(e);
            }
        //
        }else if (e.getEventName().equalsIgnoreCase("EsmBkg0937Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchEuDoRcvrInfo(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
                eventResponse = setupEuDoRcvrInfo(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)){
                eventResponse = sendEuDoByEmail(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI02)){
                eventResponse = sendEuDoByFax(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI03)){
                eventResponse = setupEuDoTruckerInfo(e);
            }
            // EU D/O 발행 대상 B/L에 대한 정보를 처리 한다.
        }else if (e.getEventName().equalsIgnoreCase("EsmBkg0938Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
                eventResponse = searchEuDo(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MODIFY)){
                eventResponse = this.manageEuDo(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
                eventResponse = this.releaseEuDo(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
                eventResponse = this.cancelEuDo(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI03)){
                eventResponse = this.holdDo(e);
            }
        }else if (e.getEventName().equalsIgnoreCase("EsmBkg0128Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
                eventResponse = searchGenDo(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MODIFY)){
                eventResponse = this.manageGenDo(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
                eventResponse = this.releaseGenDo(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
                eventResponse = this.cancelDo(e);
//            }else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)){
//                eventResponse = this.assignDo(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI04)){
                eventResponse = this.holdDo(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI05)){
            	eventResponse = this.transmitEdiPsaEdoAmend(e);
            }
        }else if (e.getEventName().equalsIgnoreCase("EsmBkg1035Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
                eventResponse = searchVetnamPrnCd(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
                eventResponse = this.setupVetnamPrnCd(e);
            }
        }else if (e.getEventName().equalsIgnoreCase("EsmBkg0954Event")) {
            if(e.getFormCommand().isCommand(FormCommand.MODIFY)){
                eventResponse = this.createDoHistory(e);
            }
        }
    /******************************************************************************************
        Author :An JinEung End
    *******************************************************************************************/

    /******************************************************************************************
        Author :Park Mangeon Start
    *******************************************************************************************/
        else if (e.getEventName().equalsIgnoreCase("EsmBkg0936Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchIdaDoRcvrInfo (e);
            }else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
                eventResponse = setupIdaDoRcvrInfo(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)){
                eventResponse = sendIndiaDoByEmail(e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg0694Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchJapDoHistory (e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
            	eventResponse = backEndJobResult(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
            	eventResponse = transmitEdiJapDorBy0694 (e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg0131Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchDoCheckReport (e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg0939Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchIdaDoRlseReport (e);
            } else {
                eventResponse = getComIntgCodes(new String[]{"CD02209",}, new String[]{"dmdt_code"}, new String[]{"dmdt_value"});
            }
        }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg0680Event")) {
            if(e.getFormCommand().isCommand(FormCommand.SEARCH)){  // Retrieve
                eventResponse = searchIdaDo(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MODIFY)){ // Save
                eventResponse = this.manageIdaDo(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){ // Release
                eventResponse = this.releaseIdaDo(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){ // Hold
                eventResponse = holdDo(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI03)){ // Un-Hold
                eventResponse = holdDo(e);
            }else if(e.getFormCommand().isCommand(FormCommand.REMOVE)){ // Cancel
            	eventResponse = cancelIdaDo(e);
            }else if(e.getFormCommand().isCommand(FormCommand.COMMAND06)){
                EsmBkg0682Event event = new EsmBkg0682Event();
                event.setBlNo(((EsmBkg0680Event)e).getBlNo());
                eventResponse = searchBkgNoByBlNo((Event)event); //BL NO로 BKG NO 찾기
            }else if(e.getFormCommand().isCommand(FormCommand.COMMAND07)){ // 2011.08.01 초기화면시 콤보값 설정
            	eventResponse = searchIdaDoDiscTmnlYdList(e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg0923Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchUsCgoRlseHis (e);
            }
        }

    /******************************************************************************************
        Author :Park Mangeon End
    *******************************************************************************************/

    /******************************************************************************************
        Author : Son YunSeuk Start
    *******************************************************************************************/
        else if (e.getEventName().equalsIgnoreCase("EsmBkg1018Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchDoPrnRmk(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
                eventResponse = modifyDoPrnRmk(e);
            }
        }else if (e.getEventName().equalsIgnoreCase("EsmBkg0272Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchFullCntrRlseOrderList (e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
                eventResponse = transmitEdiFullCntrRlseOrder(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
                eventResponse = sendFullCntrRlseOrderByEmail(e);
            }else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)){
                eventResponse = searchFullCntrRlseOrdMailCtntForTmnl(e);
            }else if(e.getFormCommand().isCommand(FormCommand.COMMAND04)){
                eventResponse = searchFullCntrRlseOrdMailCtntForCust(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
                eventResponse = checkEuFullRlseTransmitValid(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
                eventResponse = searchOfcFullCntrRlseOrdBracUpdFlg(e);
            }
        }else if(e.getEventName().equalsIgnoreCase("EsmBkg0273Event")){
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchFullReleaseHistory(e);
            }
        }else if(e.getEventName().equalsIgnoreCase("EsmBkg1052Event")) {
            if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = modifyFullCntrRlseRmk(e);
            }
        }else if(e.getEventName().equalsIgnoreCase("EsmBkg0130Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchDoRcvrInfo(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = setupDoRcvrInfo(e);
            }
         /******************************************************************************************
            Author : Son YunSeuk End
        ******************************************************************************************/

        }else if(e.getEventName().equalsIgnoreCase("EsmBkg0579Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchPsaEdoAckLog(e);
            }

     /******************************************************************************************
        PSA EDI Event
    ******************************************************************************************/
        }else if(e.getEventName().equalsIgnoreCase("ReceiptPsaEdoAckEvent")) {
        	eventResponse = receiptPsaEdoAck(e);
        }

      /******************************************************************************************
          Canada Cargo Release
      ******************************************************************************************/
    else if (e.getEventName().equalsIgnoreCase("EsmBkg1167Event")) {
    	 if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {// 조회
             eventResponse = searchCaCgoRlseList(e);
         }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {//Container 조회
             eventResponse = searchCaCgoRlseCntr(e);
         }else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {//OTS,DEM 정보가져오기
             eventResponse = searchCaErpOtsInfo(e);
         }else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {//Original Bill of Lading Status 정보 가져오기
             eventResponse = searchCaCgoRlseBlStatus(e);
         }else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {//저장(SAVE) 0909용
        	 eventResponse =  manageCaCgoRlse(e);
         }else if(e.getFormCommand().isCommand(FormCommand.MULTI03)) {//Hold
             eventResponse = manageCaCgoRlseHold(e);
         }else if(e.getFormCommand().isCommand(FormCommand.MULTI20)) {//저장(SAVE)
             eventResponse = manageCaCgoHldRmk(e);
         }
    }  else if (e.getEventName().equalsIgnoreCase("EsmBkg1177Event")) {
        if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
            eventResponse = searchDoVtyUptoDthis (e);
        }

	/******************************************************************************************
      EDI Setup
		******************************************************************************************/
     } else if (e.getEventName().equalsIgnoreCase("EsmBkg1515Event")) {
	     if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	         eventResponse = searchEdiSetupList(e);
	       }else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {//저장(SAVE)
	      	eventResponse =  manageEdiSetup(e);
	       }else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	      	 eventResponse = searchEdiSetupHistoryList(e);
	      }
		}

    /******************************************************************************************
      방글라데시 Cargo Release
    ******************************************************************************************/
     else if (e.getEventName().equalsIgnoreCase("EsmBkg0684Event")) {
    	 if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
             eventResponse = searchBdDo(e);
         }else if(e.getFormCommand().isCommand(FormCommand.MODIFY)){
             eventResponse = this.manageBdDo(e);
         }else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
             eventResponse = this.releaseBdDo(e);
         }else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
             eventResponse = this.cancelBdDo(e);
         }else if(e.getFormCommand().isCommand(FormCommand.MULTI03)){
             eventResponse = this.holdDo(e);
         }
     }



        return eventResponse;
    }

    /**
     * VARIABLE UI - Code Selection<br>
     * TODO: Booking Utility로 옮겨가야 할 수 있다(설계자와 협의 필요)
     * @param String[] intgCdIds 가져올 Code들의 코드번호들 EX- 'CD01655'
     * @param String[] intgCdValCtntNames Response에 ETC DATA로 세팅할 Code의 Key Ex 'intg_code'
     * @param String[] intgCdValDpDescNames  Response에 ETC DATA로 세팅할 Code값의 Key 'intg_value'
     * @exception EventException
     * @return EventResponse
     * @author Park Mangeon
     */
    private EventResponse getComIntgCodes(String[] intgCdIds, String[] intgCdValCtntNames, String[] intgCdValDpDescNames ) throws EventException {
        String[] concatStrs = new String[]{"|"}; // default concat value
        // String[][] excludeCodeList = null; // 2011.07.15
        return getComIntgCodes(intgCdIds, intgCdValCtntNames, intgCdValDpDescNames, concatStrs, null);  // 2011.07.15
    }

//    /**
//     * VARIABLE UI - Code Selection<br>
//     * TODO: Booking Utility로 옮겨가야 할 수 있다(설계자와 협의 필요)
//     * @param String[] intgCdIds 가져올 Code들의 코드번호들 EX- 'CD01655'
//     * @param String[] intgCdValCtntNames Response에 ETC DATA로 세팅할 Code의 Key Ex 'intg_code'
//     * @param String[] intgCdValDpDescNames  Response에 ETC DATA로 세팅할 Code값의 Key 'intg_value'
//     * @param String[] concatStrs Code와 Code값들을 연결할 연결문자 Ex '|'  --> 'C|N|S|'
//     * @exception EventException
//     * @return EventResponse
//     * @author Park Mangeon
//     */
//    private EventResponse getComIntgCodes(String[] intgCdIds, String[] intgCdValCtntNames, String[] intgCdValDpDescNames, String[] concatStrs ) throws EventException {
//        String[][] excludeCodeList = null;
//        return getComIntgCodes(intgCdIds, intgCdValCtntNames, intgCdValDpDescNames, concatStrs, excludeCodeList);
//    }

    /**
     * VARIABLE UI - Code Selection<br>
     * TODO: Booking Utility로 옮겨가야 할 수 있다(설계자와 협의 필요)
     * @param String[] intgCdIds 가져올 Code들의 코드번호들 EX- 'CD01655'
     * @param String[] intgCdValCtntNames Response에 ETC DATA로 세팅할 Code의 Key Ex 'intg_code'
     * @param String[] intgCdValDpDescNames  Response에 ETC DATA로 세팅할 Code값의 Key 'intg_value'
     * @param String[] concatStrs Code와 Code값들을 연결할 연결문자 Ex '|'  --> 'C|N|S|'
     * @param String[][] excludeCodeList  코드중 제외할 코드 Ex 'S' --> 'C|N|'  (S가 제외되었음)
     * @exception EventException
     * @return EventResponse
     * @author Park Mangeon
     */
    private EventResponse getComIntgCodes(String[] intgCdIds, String[] intgCdValCtntNames, String[] intgCdValDpDescNames, String[] concatStrs, String[][] excludeCodeList ) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            CodeUtil codeUtil = com.hanjin.framework.component.util.code.CodeUtil.getInstance();

            	// 2015.03.24 소스 보안 적용
            if (intgCdIds != null
                && intgCdIds.length != 0
                && intgCdValCtntNames != null
                && intgCdValCtntNames.length != 0
                && intgCdValDpDescNames != null
                && intgCdValDpDescNames.length != 0
                && intgCdIds.length == intgCdValCtntNames.length
                && intgCdIds.length == intgCdValDpDescNames.length ) {

	                Collection<CodeInfo> codeRslt = null;
	                StringBuffer sbCode = new StringBuffer();
	                StringBuffer sbValue = new StringBuffer();
	                CodeInfo[] codeInfoVOs = null;
	                boolean isExclude = false;
	                String[] excludeCodes = null;

	                for (int idx = 0; idx < intgCdIds.length; idx++) {
	                    codeRslt = (Collection<CodeInfo>)codeUtil.getCodeSelect(intgCdIds[idx], 0);

	                    codeInfoVOs = new CodeInfo[codeRslt.size()];
	                    codeRslt.toArray(codeInfoVOs);

	                    if (excludeCodeList != null) {
	                        excludeCodes = excludeCodeList[idx];
	                    }

	                    for (int i = 0; i< codeInfoVOs.length; i ++) {

	                        if (excludeCodes != null && excludeCodes.length >0) {
	                            for (int j = 0; j < excludeCodes.length; j ++) {
	                                if (codeInfoVOs[i].getCode().equals(excludeCodes[j]) ) {
	                                    isExclude = true;
	                                    break;
	                                }
	                            }
	                        }
	                        if (!isExclude) {
	                            sbCode.append(codeInfoVOs[i].getCode());
	                            sbValue.append(codeInfoVOs[i].getName());
	                            if (i < codeInfoVOs.length -1) {
	                                sbCode.append(concatStrs[idx]);
	                                sbValue.append(concatStrs[idx]);
	                            }
	                        }
	                        isExclude = false;
	                    }

	                    eventResponse.setETCData(intgCdValCtntNames[idx], sbCode.toString());
	                    eventResponse.setETCData(intgCdValDpDescNames[idx], sbValue.toString());

	                    sbCode.delete(0, sbCode.length() );
	                    sbValue.delete(0, sbValue.length());
	                }
	            }

        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;
    }

    /******************************************************************************************
        Author :Lim JinYoung Start
    *******************************************************************************************/

    /**
     * ESM_BKG_1000 : 조회 이벤트 처리<br>
     * FullReleaseOrder의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchKorDoCustList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1001Event event1 = null;
        EsmBkg1000Event event0 = null;
        String mdtrNm = "";
        String mdtrNo = "";

        if (e.getEventName().equalsIgnoreCase("EsmBkg1001Event")) {
            event1 = (EsmBkg1001Event)e;
            mdtrNm = event1.getBkgKorDoAttorneyVO().getAttyCustNm();
            mdtrNo = event1.getBkgKorDoAttorneyVO().getAttyBizNo();
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg1000Event")) {
            event0 = (EsmBkg1000Event)e;
            mdtrNm = event0.getBkgKorDoAttorneyVO().getAttyCustNm();
            mdtrNo = event0.getBkgKorDoAttorneyVO().getAttyBizNo();
        }

        try {
            CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
            List<KorDoAttorneyVO> list = command.searchKorDoCustList(mdtrNm, mdtrNo);
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0711 : 조회 이벤트 처리<br>
     * Cargo Release Order History의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchDoHistory(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0711Event event = (EsmBkg0711Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try {
            List<DoHisVO> list = command.searchDoHistory( event.getDoHisVO().getBkgNo());
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_1000 : 멀티 이벤트 처리<br>
     * Cargo Release Order History의 event에 대한 멀티 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse manageKorDoCust(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1000Event event = (EsmBkg1000Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            begin();
            command.manageKorDoCust(event.getBkgKorDoAttorneyVOs(),account);

            //에러 핸들러에 해당하는 성공  메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0999 : 조회 이벤트 처리<br>
     * Attorney Register Pop-up의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchKorDoAttorneyList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0999Event event = (EsmBkg0999Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try {
            List<KorDoAttorneyDtlVO> list = command.searchKorDoAttorneyList( event.getBkgKorDoAttorneyDtlVO().getCustType(),
                                                                             event.getBkgKorDoAttorneyDtlVO().getCustName(),
                                                                             event.getBkgKorDoAttorneyDtlVO().getCustBizNo());
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0999 : 멀티 이벤트 처리<br>
     * Attorney Register Pop-up의 event에 대한 멀티 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse manageKorDoAttorney(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0999Event event = (EsmBkg0999Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            begin();
            command.manageKorDoAttorney(event.getBkgKorDoAttorneyDtlVOs(),account);
            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0999 : 조회 이벤트 처리<br>
     * Attorney Register Pop-up의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchKorDoAttorneyDtl(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0999Event event = (EsmBkg0999Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            String dupCnt = command.searchKorDoAttorneyDtl( event.getBkgKorDoAttorneyDtlVO().getFmAttyBizNo(),
                                                            event.getBkgKorDoAttorneyDtlVO().getToAttyBizNo()
                                                          );
            eventResponse.setETCData("dupCnt", ""+dupCnt);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0682 : 조회 이벤트 처리<br>
     * Korea D/O 발행 대상 B/L에 대한 정보를 조회한다.
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */

    private EventResponse searchKorDo(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        EsmBkg0682Event event = (EsmBkg0682Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        BookingUtil bookingUtil = null;
        //DEM/DET 에서 받아서 가공한 데이터
        DmtChargeVO dmtChargeVo  = new DmtChargeVO();

        try {
        	bookingUtil = new BookingUtil();

            //BKG_NO가 없을 경우 BL NO로 조회 해 온다.
            if("".equals(event.getBkgNo()) || null == event.getBkgNo()){
                String bkgNo = bookingUtil.searchBkgNoByBlNo(event.getBlNo());
                if(! "".equals(bkgNo)){
                    event.setBkgNo(bkgNo);
                }else{
                    String[] msg = new String[]{event.getBlNo()};
                    throw new EventException(new ErrorHandler("BKG40031", msg).getMessage());
                }
            }

            //List<ToTBilAmtVO> bilAmtVOList = new ArrayList<ToTBilAmtVO>();
            String tpbStatus = ""; //TPB Status

            //Korea D/O 발행 대상 B/L에 대한 정보를 조회한다.
            KorDoMstVO korDoMst = command.searchKorDo(event.getBkgNo(), account);

            if(korDoMst.getKorDoBlInfo() != null){
                try {
                	// DEM/DET I/F 연동
                	dmtChargeVo = this.searchDemDetChargeInfo(event.getBkgNo(),korDoMst.getKorDoBlInfo().getPodCd(),event.getDemurType(),event.getExpDelDt());
                } catch (Exception ex) {
                	log.warn("warring : " + ex.toString(), ex);
                	log.error(ex.getMessage()); // 2011.07.15
                    //중첩 Try문 사용 이유 : Business Logic 상 Exception 처리불가. (DEM.DET 모듈 Exception이 발생해도 InBound 로직은 진행되어야 한다.)
                }

                StatusInquiryBC tpbIF = new StatusInquiryBCImpl(); //TPB BC 선언
                SearchTPBStatusByBkgNoVO searchTpbStatusByBkgNoVO = new SearchTPBStatusByBkgNoVO();
                searchTpbStatusByBkgNoVO.setSbkgno(event.getBkgNo());
                tpbStatus = tpbIF.searchTpbStatusByBkgNo(searchTpbStatusByBkgNoVO);
            }

            //Korea D/O Release 기본 정보 추출
            eventResponse.setRsVo(korDoMst.getKorDoBlInfo());

            //B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보 추출
            eventResponse.setRsVoList(korDoMst.getDoRlseSts());
            
            //운임 결재 여부와 Outstanding Amounts 정보 추출
            eventResponse.setRsVoList(dmtChargeVo.getChargeByBookingCustomerCntrVOS());
            eventResponse.setRsVoList(dmtChargeVo.getChargeByBookingCustomerInvVOS());
            eventResponse.setRsVoList(dmtChargeVo.getBilAmtVOList());

            //Total Vol. 정보 추출 (2018.03.15 추가- 하대성)
            eventResponse.setRsVoList(korDoMst.getBkgQuantity());
            
            //KT-NET을 통해 들어온 E-DO 승인 요청 정보에 대한 Ststus 추출

            eventResponse.setETCData("demurType"  , dmtChargeVo.getDemurType());
            eventResponse.setETCData("mrdId"      , JSPUtil.getNull(korDoMst.getMrdId(), ""));
            eventResponse.setETCData("tpbStatus"  , tpbStatus);


        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    /**
     * 공통 : DEM/DET Charge Info 조회<br>
     * D/O 발행 대상 B/L에 대한DEM/DET Charge Info 정보를 조회한다.
     *
     * @param bkgNo    String
     * @param podCd    String
     * @param dmdtTp   String
     * @param expDelDt String
     * @return dmtChargeVo DmtChargeVO
     * @exception EventException
     */
    private DmtChargeVO searchDemDetChargeInfo( String bkgNo,String podCd,String dmdtTp,String expDelDt ) throws EventException {

    	CargoReleaseOrderBC cargoReleaseOrder = null;
    	ChargeCalculationBC chargeCalculation = null;
    	BookingUtil bookingUtil               = null;

    	ChargeByBookingCustomerParmVO chargeByBookingCustomerParmVo = null;
    	ChargeByBookingCustomerGrpVO chargeByBookingCustomerGrpVo   = null;
    	DmtChargeVO dmtChargeVo                                     = null;
        try{
        	cargoReleaseOrder = new CargoReleaseOrderBCImpl();

        	// DEM.DET I/F를 위한 Booking Number에 연계된 Container Number 조회
        	String[] cntrs =  cargoReleaseOrder.searchDemDetCntrList(bkgNo);

        	chargeByBookingCustomerParmVo = new ChargeByBookingCustomerParmVO();

        	chargeByBookingCustomerParmVo.setBkgNo(bkgNo);
        	chargeByBookingCustomerParmVo.setPodCd(podCd);
        	chargeByBookingCustomerParmVo.setDmdtTp(dmdtTp);
        	chargeByBookingCustomerParmVo.setExpDelDt(expDelDt);
        	chargeByBookingCustomerParmVo.setCntrNo(cntrs);

        	chargeCalculation = new ChargeCalculationBCImpl(); //DEM.DET BC 선언

        	chargeByBookingCustomerGrpVo = chargeCalculation.searchChargeByCustomer(chargeByBookingCustomerParmVo);

        	bookingUtil = new BookingUtil();
        	dmtChargeVo = bookingUtil.searchChargeByCustomer(chargeByBookingCustomerGrpVo);
        }catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return dmtChargeVo;
    }

    /**
     * ESM_BKG_0682 : 단건 입력 이벤트 처리<br>
     * Korea Cargo Release (D/O)의 event의 event에 대한 단건 입력 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse manageKorDo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0682Event event = (EsmBkg0682Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        //타 모듈 인터페이스 호출
        BLIssuanceBC bLIssuanceBC = new BLIssuanceBCImpl();

        try{
            begin();

            if(null != event.getBlIssVOs()){
                event.getBlIssVOs()[0].setOblRdemFlg(event.getAftOblRdemFlg());
                event.getBlIssVOs()[0].setOblRdemOfcCd(account.getOfc_cd());
                event.getBlIssVOs()[0].setOblRdemUsrId(account.getUsr_id());
                event.getBlIssVOs()[0].setOtrDocRcvOfcCd(account.getOfc_cd());
                event.getBlIssVOs()[0].setOtrDocRcvUsrId(account.getUsr_id());
                event.getBlIssVOs()[0].setCreUsrId(account.getUsr_id());
                event.getBlIssVOs()[0].setUpdUsrId(account.getUsr_id());
                //manageOBLIssue 호출
                bLIssuanceBC.manageOblRcv(event.getBlIssVOs()[0]);
            }

            if(null != event.getKorDoSave()){
                //OBL Change 여부 세팅
                event.getKorDoSave()[0].setOblCngFlg(event.getOblCngFlg());
                //세션 정보 세팅하기
                event.getKorDoSave()[0].setCreUsrId(account.getUsr_id());
                event.getKorDoSave()[0].setUpdUsrId(account.getUsr_id());
                event.getKorDoSave()[0].setAcount(account);
                event.getKorDoSave()[0].setOldOblRdemKnt(event.getOldOblRdemKnt());
                event.getKorDoSave()[0].setNewOblRdemKnt(event.getNewOblRdemKnt());
                event.getKorDoSave()[0].setDoCngEvntCd(event.getDoCngEvntCd());
                event.getKorDoSave()[0].setDoSplitFlg("N");
                //manageKorDo 호출
                command.manageKorDo(event.getKorDoSave()[0]);
            }


            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
            commit();
        }catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0682 : 단건 입력 이벤트 처리<br>
     * Korea Cargo Release (D/O)의 event의 event에 대한 단건 입력 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse assignDo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        EsmBkg0682Event event = (EsmBkg0682Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            begin();

//            if(null != event.getDoAsign()){
//                event.getDoAsign()[0].setAcount(account);
//                command.assignDo(event.getDoAsign()[0]);
//            }

            if(e.getEventName().equalsIgnoreCase("EsmBkg0682Event")){

                EsmBkg0682Event korEvent = (EsmBkg0682Event)e;
                korEvent.getDoAsign()[0].setAcount(account);
                command.assignDo(korEvent.getDoAsign()[0]);

//            }else if(e.getEventName().equalsIgnoreCase("EsmBkg0128Event")){
//
//                EsmBkg0128Event geEvent = (EsmBkg0128Event)e;
//                geEvent.getDoAsign()[0].setAcount(account);
//                geEvent.getDoAsign()[0].setRefInfo(geEvent.getRefInfos()[0]);
//
//                log.debug("AsgnCtnt : " + geEvent.getDoAsign()[0].getRefInfo().getCstmsAsgnCtnt() + "    RefCtnt : " + geEvent.getDoAsign()[0].getRefInfo().getCstmsRefCtnt());
//
//                command.assignDo(geEvent.getDoAsign()[0]);

            }

            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00653").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0682 : 대상 B/L에 대해 D/O Release작업을 수행한다.<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     * @author Lim JinYoung
     */
    private EventResponse releaseKorDo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0682Event event = (EsmBkg0682Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            begin();
            KorDoRlseVO korDoRlse = null;
            if(null != event.getDoBlInfo()){
                korDoRlse = new KorDoRlseVO();
                korDoRlse.setBkgNo(event.getDoBlInfo()[0].getBkgNo());

                if(event.getDoRlseSts() !=null){
                    //korDoRlse.setDoNo(event.getDoRlseSts()[0].getDoNo()+event.getDoRlseSts()[0].getDoNoSplit());
                    korDoRlse.setDoNo(event.getDoRlseSts()[0].getDoNo());
                    korDoRlse.setRlseSeq(event.getDoRlseSts()[0].getRlseSeq());
                }

                korDoRlse.setCreUsrId(account.getUsr_id());
                korDoRlse.setUpdUsrId(account.getUsr_id());
                korDoRlse.setAcount(account);
                korDoRlse.setCgorRmk(event.getReleaseRemark());
                korDoRlse.setDiscLocCd(event.getDiscLocCd());
                korDoRlse.setRlseStsCd(event.getRlseStsCd());
                korDoRlse.setSelfTrnsFlg(event.getSelfTrnsFlg());

                korDoRlse.setBlInfo(event.getDoBlInfo()[0]);
                korDoRlse.setDoRef(event.getRefInfos()[0]);

                command.releaseKorDo(korDoRlse);

            }
            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00669").getUserMessage());
            commit();
        }catch(EventException ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0682 : D/O대상 B/L에 대한 Assign 혹은 Release Staus를 Cancel한다.<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     * @author Lim JinYoung     *
     */
    private EventResponse cancelKorDo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = null;
        KorDoCancelVO korDoCancel          = null;
        CargoReleaseOrderBC command        = null;
        EsmBkg0682Event korEvent           = (EsmBkg0682Event)e;

        try{
            begin();

            eventResponse = new GeneralEventResponse();
            korDoCancel = new KorDoCancelVO();
            command = new CargoReleaseOrderBCImpl();


            korDoCancel.setBkgNo(korEvent.getBkgNo());
            //korDoCancel.setDoNo(korEvent.getDoRlseSts()[0].getDoNo()+korEvent.getDoRlseSts()[0].getDoNoSplit());
            korDoCancel.setDoNo(korEvent.getDoRlseSts()[0].getDoNo());
            korDoCancel.setCreUsrId(account.getUsr_id());
            korDoCancel.setUpdUsrId(account.getUsr_id());
            korDoCancel.setEvntOfcCd(account.getOfc_cd());
            korDoCancel.setAcount(account);
            korDoCancel.setDiscLocCd(korEvent.getDiscLocCd());
            korDoCancel.setRlseStsCd(korEvent.getRlseStsCd());
            korDoCancel.setRlseSeq(korEvent.getDoRlseSts()[0].getRlseSeq());
            korDoCancel.setSelfTrnsFlg(korEvent.getSelfTrnsFlg());

            command.cancelKorDo(korDoCancel);

            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00674").getUserMessage());
            commit();
        }catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0326 : D/O대상 B/L에 대한 Assign 혹은 Release Staus를 Cancel한다.<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     * @author Lim JinYoung     *
     */
    private EventResponse cancelDo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        DoCancelVO doCancel = new DoCancelVO();

        if(e.getEventName().equalsIgnoreCase("EsmBkg0326Event")){

            EsmBkg0326Event japEvent = (EsmBkg0326Event)e;

            //doCancel.setDoNo(japEvent.getDoRlseSts()[0].getDoNo()+japEvent.getDoRlseSts()[0].getDoNoSplit());
            doCancel.setDoNo(japEvent.getDoRlseSts()[0].getDoNo());
            doCancel.setRlseStsCd("'I','C'");
        } else if(e.getEventName().equalsIgnoreCase("EsmBkg0128Event")){
            EsmBkg0128Event geEvent = (EsmBkg0128Event)e;

            //doCancel.setDoNo(geEvent.getDoRlseSts()[0].getDoNo()+geEvent.getDoRlseSts()[0].getDoNoSplit());
            doCancel.setDoNo(geEvent.getDoRlseSts()[0].getDoNo());
            doCancel.setRlseStsCd("'R','C'");
            doCancel.setRlseSeq(geEvent.getResetFlg());
        }

        doCancel.setCreUsrId(account.getUsr_id());
        doCancel.setUpdUsrId(account.getUsr_id());
        doCancel.setEvntOfcCd(account.getOfc_cd());

        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            begin();
            command.cancelDo(doCancel);

            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00674").getUserMessage());
            commit();

            if(e.getEventName().equalsIgnoreCase("EsmBkg0128Event")){
            	EsmBkg0128Event geEvent = (EsmBkg0128Event)e;

	            // PSA인 경우 Release 후 Transmit 처리를 한다.
	            if("SG".equals(account.getCnt_cd())){
	            	transmitEdiPsaEdo(geEvent);
	            // Indonesia Surabaya 지점인 경우 Release 후 Transmit 처리를 한다.	
	            } else if ("SUBBA".equals(account.getOfc_cd())) {
	            	transmitEdiSubbaEdo(geEvent);
				}
	         
            }

        }catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        /*
        catch(EventException ex){
            rollback();
            if(ex.getMessage().indexOf("BKG00649") >-1){
                //B/L was Held
                throw new EventException(ex.getMessage(), ex);
            }else if(ex.getMessage().indexOf("BKG00384") >-1){
                //이미 cancel 되었습니다
                throw new EventException(ex.getMessage(), ex);
            }else{
                //작업이 실패하였습니다.
                throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
            }
        }*/
        return eventResponse;
    }

    /**
     * ESM_BKG_0326 : DO 대상 B/L 단위로  HOLD를 셋팅한다.<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     * @author Lim JinYoung     *
     */
    private EventResponse holdDo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        DoHoldVO doHold = new DoHoldVO();
        String evntFlag = "";
        if(e.getEventName().equalsIgnoreCase("EsmBkg0682Event")){

            EsmBkg0682Event korEvent = (EsmBkg0682Event)e;

            doHold.setBkgNo(korEvent.getDoBlInfo()[0].getBkgNo());
            doHold.setUpdUsrId(account.getUsr_id());
            doHold.setCreUsrId(account.getUsr_id());
            doHold.setAcount(account);

            evntFlag = korEvent.getEvntFlag();
            doHold.setEvntFlag(evntFlag);

        }else if(e.getEventName().equalsIgnoreCase("EsmBkg0326Event")){

            EsmBkg0326Event japEvent = (EsmBkg0326Event)e;

            doHold.setBkgNo(japEvent.getDoBlInfo()[0].getBkgNo());
            doHold.setUpdUsrId(account.getUsr_id());
            doHold.setCreUsrId(account.getUsr_id());
            doHold.setAcount(account);

            evntFlag = japEvent.getEvntFlag();
            doHold.setEvntFlag(evntFlag);

        }else if(e.getEventName().equalsIgnoreCase("EsmBkg0680Event")){

            EsmBkg0680Event idaEvent = (EsmBkg0680Event)e;
            //doHold.setBkgNo(idaEvent.getBlInfos()[0].getBkgNo());
            doHold.setBkgNo(idaEvent.getBkgNo());
            doHold.setAcount(account);
            evntFlag = idaEvent.getEvntFlag();
            doHold.setUpdUsrId(account.getUsr_id());
            doHold.setCreUsrId(account.getUsr_id());
            doHold.setEvntFlag(evntFlag);

        }else if(e.getEventName().equalsIgnoreCase("EsmBkg0938Event")){

            EsmBkg0938Event euEvent = (EsmBkg0938Event)e;
            doHold.setBkgNo(euEvent.getDoBlInfo()[0].getBkgNo());
            doHold.setUpdUsrId(account.getUsr_id());
            doHold.setCreUsrId(account.getUsr_id());
            doHold.setAcount(account);
            evntFlag = euEvent.getEvntFlag();
            doHold.setEvntFlag(evntFlag);
        }else if(e.getEventName().equalsIgnoreCase("EsmBkg0128Event")){

            EsmBkg0128Event geEvent = (EsmBkg0128Event)e;
//            doHold.setBkgNo(geEvent.getDoBlInfo()[0].getBkgNo());
            doHold.setBkgNo(geEvent.getGenBlInfos()[0].getBkgNo());
            doHold.setUpdUsrId(account.getUsr_id());
            doHold.setCreUsrId(account.getUsr_id());
            doHold.setAcount(account);
            evntFlag = geEvent.getEvntFlag();
            doHold.setEvntFlag(evntFlag);
        }else if(e.getEventName().equalsIgnoreCase("EsmBkg0909Event")){

        	EsmBkg0909Event geEvent = (EsmBkg0909Event)e;

            doHold.setBkgNo(geEvent.getBkgNo());
            doHold.setUpdUsrId(account.getUsr_id());
            doHold.setCreUsrId(account.getUsr_id());
            doHold.setAcount(account);
            evntFlag = geEvent.getDoRefVOs()[0].getDoHldFlg();
            doHold.setEvntFlag(evntFlag);
        }

        try{
            begin();

            command.holdDo(doHold);
            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            String msg = "";
            if("H".equals(evntFlag)){
                msg = "BKG00660";
            }else if("R".equals(evntFlag)){
                msg = "BKG00661";
            }
            eventResponse.setUserMessage(new ErrorHandler(msg).getUserMessage());
            commit();
        }catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0682 : KT-NET을 통해 들어온 E-DO 요청(Incl. 자가운송, 보세운송동의서)에 대한 결과를 전송 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse transmitEdiByEdo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0737Event event = (EsmBkg0737Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            begin();
            if(null != event.getEdoEdiTrans()){
                for(int idx = 0; idx<event.getEdoEdiTrans().length; idx++){
                    event.getEdoEdiTrans()[idx].setAcount(account);
                }
            }
            command.transmitEdiByEdo(event.getEdoEdiTrans(), "EDO");
            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0682 : EDO 승인 요청에 대한 처리 후 전송 결과(Ack)정보를 기록한다.<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse receiptEdoRqstAck(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0682Event event = (EsmBkg0682Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            begin();
            command.receiptEdoRqstAck(event.getRqstNo(), event.getAckInd());
            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0682 : E서비스 센터에서 수신 받은 EDI정보를 저장<br>
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse receiptEdo(Event e) throws EventException {

        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0682Event event = (EsmBkg0682Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            begin();
            command.receiptEdo(event.getEdoRqstVO(), account);
            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0682 : EDO Log 정보를 기록한다.<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse receiptEdoLog(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0682Event event = (EsmBkg0682Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            begin();
            command.receiptEdoLog(event.getBkgEdoLogVO());
            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0682 : KL-NET을 통해 자가 운송 요청에 대한 취소 요청을 EDI로 전송 후 관련 데이타를 Cancel 처리한다.<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse transmitEdiKorDo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0682Event event = (EsmBkg0682Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            begin();
            event.getKorDoEdiTrans()[0].setAcount(account);
            event.getKorDoEdiTrans()[0].setDoType("KDS");
            event.getKorDoEdiTrans()[0].setSelfTrnsFlg(event.getSelfTrnsFlg());
            event.getKorDoEdiTrans()[0].setDiscLocCd(event.getDiscLocCd());

            command.transmitEdiByKorDo(event.getKorDoEdiTrans()[0]);

            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            String msgId = "";
            if("Y".equals(event.getSelfTrnsFlg())){
                msgId = "BKG00693";  //EDI Send
            }else{
                msgId = "BKG00692";  //S/T Cancel
            }
            eventResponse.setUserMessage(new ErrorHandler(msgId).getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0682 : BL NO로 BKG NO를 조회한다.<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchBkgNoByBlNo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        EsmBkg0682Event event = (EsmBkg0682Event)e;
        BookingUtil bookingUtilBC = new BookingUtil();
        //BKG_NO가 없을 경우 BL NO로 조회 해 온다.
        try{
            String bkgNo = bookingUtilBC.searchBkgNoByBlNo(event.getBlNo());
            DoBlInfoVO doRefVO = new DoBlInfoVO();
            doRefVO.setBkgNo(bkgNo);
            doRefVO.setBlNo(event.getBlNo());
            eventResponse.setRsVo(doRefVO);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0326 : 조회 이벤트 처리<br>
     * Japan D/O 발행 대상 B/L에 대한 정보를 조회한다.
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchJapDo(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        EsmBkg0326Event event = (EsmBkg0326Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        BookingUtil bookingUtil = null;
        //DEM/DET 에서 받아서 가공한 데이터
        DmtChargeVO dmtChargeVo  = null;

        try{
        	bookingUtil = new BookingUtil();

            if("".equals(event.getBkgNo()) || null == event.getBkgNo()){
                //BKG_NO가 없을 경우 BL NO로 조회 해 온다.
                String bkgNo = bookingUtil.searchBkgNoByBlNo(event.getBlNo());
                if(! "".equals(bkgNo)){
                    event.setBkgNo(bkgNo);
                }else{
                    String[] msg = new String[]{event.getBlNo()};
                    throw new EventException(new ErrorHandler("BKG40031", msg).getMessage());
                }
            }
            //DEM/DET 에서 받아서 가공한 데이터


            String tpbStatus = ""; //TPB Status

            JapDoMstVO japDoMst = command.searchJapDo(event.getBkgNo(), account);

            dmtChargeVo = new DmtChargeVO();

            if(japDoMst.getBlInfo() != null){

              	// DEM/DET I/F 연동
                dmtChargeVo = this.searchDemDetChargeInfo(event.getBkgNo(),japDoMst.getBlInfo().getPodCd(),event.getDemurType(),event.getExpDelDt());

                StatusInquiryBC tpbIF = new StatusInquiryBCImpl(); //TPB BC 선언
                SearchTPBStatusByBkgNoVO searchTpbStatusByBkgNoVO = new SearchTPBStatusByBkgNoVO();
                searchTpbStatusByBkgNoVO.setSbkgno(event.getBkgNo());
                tpbStatus = tpbIF.searchTpbStatusByBkgNo(searchTpbStatusByBkgNoVO);
            }

            //Japan D/O Release 기본 정보 추출
            eventResponse.setRsVo(japDoMst.getBlInfo());

            //Japan D/O Release 기본 Reference 정보 추출
            eventResponse.setRsVo(japDoMst.getDoRef());

            //일본세관 신고를 위한 B/L INFO 추출
            eventResponse.setRsVo(japDoMst.getJapCstms());

            //B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보 추출
            eventResponse.setRsVoList(japDoMst.getDoRlseSts());

            //조회된 시점에 조회된 Original B/L 회수 여부와 발행 통수 및  Detail정보 추출
            eventResponse.setRsVo(japDoMst.getBlIss());

            //운임 결재 여부와 Outstanding Amounts 정보 추출
            eventResponse.setRsVo(japDoMst.getOtsRcvInfoVO());
            eventResponse.setRsVoList(dmtChargeVo.getChargeByBookingCustomerCntrVOS());
            eventResponse.setRsVoList(dmtChargeVo.getChargeByBookingCustomerInvVOS());
            eventResponse.setRsVoList(dmtChargeVo.getBilAmtVOList());

            //Dor Interface 발행 실적 및 상태 정보, Jap Do ID 정보 추출
            eventResponse.setRsVo(japDoMst.getJapDorStatus());
           //ETC DATA 처리
            if(japDoMst.getBlInfo() != null){
            	eventResponse.setETCData("demurType"    , dmtChargeVo.getDemurType());
            	eventResponse.setETCData("dorStowage"   , japDoMst.getDorStowage());
            	eventResponse.setETCData("tpbStatus"    , tpbStatus);
            	eventResponse.setETCData("mrdId"        , JSPUtil.getNull(japDoMst.getMrdId(), ""));
            } else {
            	eventResponse.setETCData("demurType"    , "");
            	eventResponse.setETCData("dorStowage"   , "");
            	eventResponse.setETCData("tpbStatus"    , "");
            	eventResponse.setETCData("mrdId"        , "");
            }
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0326 : 단건 입력 이벤트 처리<br>
     * Japan Cargo Release (D/O)의 event의 event에 대한 단건 입력 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse manageJapDo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0326Event event = (EsmBkg0326Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        //타 모듈 인터페이스 호출
        BLIssuanceBC bLIssuanceBC = new BLIssuanceBCImpl();

        try{
            begin();

            if(null != event.getBlIssVOs()){
                event.getBlIssVOs()[0].setOblRdemFlg(event.getAftOblRdemFlg());
                event.getBlIssVOs()[0].setOblRdemOfcCd(account.getOfc_cd());
                event.getBlIssVOs()[0].setOblRdemUsrId(account.getUsr_id());
                event.getBlIssVOs()[0].setOtrDocRcvOfcCd(account.getOfc_cd());
                event.getBlIssVOs()[0].setOtrDocRcvUsrId(account.getUsr_id());
                event.getBlIssVOs()[0].setCreUsrId(account.getUsr_id());
                event.getBlIssVOs()[0].setUpdUsrId(account.getUsr_id());

                //IbdDocRcv관련 정보를 세팅한다.
                event.getBlIssVOs()[0].setIbdDocRcvOfcCd(account.getOfc_cd());
                event.getBlIssVOs()[0].setIbdDocRcvUsrId(account.getUsr_id());

                //manageOBLIssue 호출
                bLIssuanceBC.manageOblRcv(event.getBlIssVOs()[0]);
            }

            if(null != event.getJapDoSave()){
                //OBL Change 여부 세팅
                event.getJapDoSave()[0].setOblCngFlg(event.getOblCngFlg());

                //세션 정보 세팅하기
                event.getJapDoSave()[0].setCreUsrId(account.getUsr_id());
                event.getJapDoSave()[0].setUpdUsrId(account.getUsr_id());
                event.getJapDoSave()[0].setAcount(account);
                event.getJapDoSave()[0].setOldOblRdemKnt(event.getOldOblRdemKnt());
                event.getJapDoSave()[0].setNewOblRdemKnt(event.getNewOblRdemKnt());
                event.getJapDoSave()[0].setDoCngEvntCd(event.getDoCngEvntCd());
                event.getJapDoSave()[0].setDoSplitFlg("N");
                //manageJapDo 호출
                event.getJapDoSave()[0].setBlissOldIbdDocRcvFlg(event.getBlIssVOs()[0].getOldIbdDocRcvFlg());
                event.getJapDoSave()[0].setBlissIbdDocRcvFlg(event.getBlIssVOs()[0].getIbdDocRcvFlg());
                command.manageJapDo(event.getJapDoSave()[0], account);
            }
            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0326 : 대상 B/L에 대해 D/O Assign / Issue 작업을 수행한다.<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse issueJapDo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0326Event event = (EsmBkg0326Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            begin();

            //issueJapDo 호출
            JapDoIssueVO japDoIssue = new JapDoIssueVO();

            japDoIssue.setBkgNo(event.getBkgNo());
            japDoIssue.setRlseStsCd(event.getRlseStsCd());
            japDoIssue.setLastRlseStsCd(event.getLastRlseStsCd());
            japDoIssue.setCntrPrtFlg(event.getCntrPrtFlg());
            japDoIssue.setAcount(account);
            japDoIssue.setOldOblRdemKnt(event.getOldOblRdemKnt());
            japDoIssue.setNewOblRdemKnt(event.getNewOblRdemKnt());
            japDoIssue.setDoCngEvntCd(event.getDoCngEvntCd());
            japDoIssue.setCgorRmk(event.getReleaseRemark());
            if(event.getRefInfos() != null){
                japDoIssue.setRefInfo(event.getRefInfos()[0]);
            }

            if(event.getDoRlseSts() != null){
                japDoIssue.setDoRlseSts(event.getDoRlseSts()[0]);
            }
            command.issueJapDo(japDoIssue);

            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00653").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0326 : DOR 전송 : D/O ID및 그 Detail정보를 EDI로 전송 한다. 일본은 EDI 송신 비용관계로 B/L별로 EDI 전송하지 않고 전송 대상을 10개 단위로 임시 보관 후 일괄 전송처리한다.
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse transmitEdiJapDor(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0326Event event = (EsmBkg0326Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            begin();

            JapDorEdiTransVO japDorEdiTrans = new JapDorEdiTransVO();

            String doNo = event.getDoNo() == null ? event.getDoRlseSts()[0].getDoNo() : event.getDoNo();

            japDorEdiTrans.setBkgNo(event.getDoRlseSts()[0].getBkgNo());
            japDorEdiTrans.setRlseSeq(event.getDoRlseSts()[0].getRlseSeq());
            japDorEdiTrans.setEvntUsrId(account.getUsr_id());
            japDorEdiTrans.setEvntOfcCd(account.getOfc_cd());
            japDorEdiTrans.setCreUsrId(account.getUsr_id());
            japDorEdiTrans.setUpdUsrId(account.getUsr_id());
            japDorEdiTrans.setPreCtnt(event.getPreCtnt());
            japDorEdiTrans.setSvcCd(event.getSvcCd());
            japDorEdiTrans.setBlNo(event.getBlNo());
            japDorEdiTrans.setEvntCd("9");

            japDorEdiTrans.setDoNo(doNo);
            japDorEdiTrans.setUsrId(account.getUsr_id());
            japDorEdiTrans.setOfcCd(account.getOfc_cd());

            command.transmitEdiByJapDor(japDorEdiTrans);
/*
            if(bkgNtcHiss != null){
                hisBC.createBkgNtcHis(bkgNtcHiss, "ESM_BKG_0326");
            }
*/
            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00730").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_BKG_0694 : DOR 전송 : D/O ID및 그 Detail정보를 EDI로 전송 한다. 일본은 EDI 송신 비용관계로 B/L별로 EDI 전송하지 않고 전송 대상을 10개 단위로 임시 보관 후 일괄 전송처리한다.<br>
     * Japan Cargo Release Performance 화면에서 다건으로 전송
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse transmitEdiJapDorBy0694(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0694Event event = (EsmBkg0694Event)e;
        try{
            begin();
            JapDorEdiTransVO[] japDorEdiTransVOs = event.getJapDorEdiTransVOs();

            if(japDorEdiTransVOs != null && japDorEdiTransVOs.length > 0){

            	int size = japDorEdiTransVOs.length;
            	for (int i = 0; i < size; i++) {
            		japDorEdiTransVOs[i].setEvntUsrId(account.getUsr_id());
            		japDorEdiTransVOs[i].setEvntOfcCd(account.getOfc_cd());
            		japDorEdiTransVOs[i].setCreUsrId(account.getUsr_id());
            		japDorEdiTransVOs[i].setUpdUsrId(account.getUsr_id());
//            		japDorEdiTransVOs[i].setPreCtnt(event.getPreCtnt()); DOR I/F시 null
            		japDorEdiTransVOs[i].setSvcCd(event.getSvcCd());
            		japDorEdiTransVOs[i].setEvntCd("9");
            		japDorEdiTransVOs[i].setUsrId(account.getUsr_id());
            		japDorEdiTransVOs[i].setOfcCd(account.getOfc_cd());
				}


	            EdiSendJapDorBackEndJob backEndJob = new EdiSendJapDorBackEndJob();
				backEndJob.setJapDorEdiTransVOs(japDorEdiTransVOs);
				backEndJob.setAccount(account);
				BackEndJobManager backEndJobManager = new BackEndJobManager();

				String key = backEndJobManager.execute(backEndJob , account.getUsr_id(), "Japan DOR  I/F EDI Transmit");
				eventResponse.setETCData("KEY", key);
            }
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    private EventResponse backEndJobResult(Event e) throws EventException{
    	  GeneralEventResponse eventResponse = new GeneralEventResponse();
    	  String sKey = "";
    	  EsmBkg0694Event event =(EsmBkg0694Event) e;
    	  sKey = event.getKey();

    	  String strResult = "";
    	  try
    	  {
    	   BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(sKey);
    	   DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
    	   while(rowSet.next()){
    	    if("2".equals(rowSet.getString("JB_STS_FLG")))
    	    {
    	     // BackEndJob
    	     strResult = "PROCESSING";
    	    }
    	    else if("3".equals(rowSet.getString("JB_STS_FLG")))
    	    {
    	     // success
    	     // Data Transmitted successufully!
    	     eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
    	     strResult = "SUCCESS";
    	    }
    	    else if("4".equals(rowSet.getString("JB_STS_FLG")))
    	    {
    	     if(!"".equals(rowSet.getString("JB_USR_ERR_MSG"))){
    	      eventResponse.setUserMessage(rowSet.getString("JB_USR_ERR_MSG"));
    	     }else{
    	      eventResponse.setUserMessage(new ErrorHandler("BKG00167").getUserMessage());
    	     }
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
     * ESM_BKG_0326 : DOR 취소 : D/O ID및 그 Detail정보를 EDI로 전송 한다. 일본은 EDI 송신 비용관계로 B/L별로 EDI 전송하지 않고 전송 대상을 10개 단위로 임시 보관 후 일괄 전송처리한다.
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse transmitEdiJapDorCancel(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0326Event event = (EsmBkg0326Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try{
            begin();

            JapDorEdiTransVO japDorEdiTrans = new JapDorEdiTransVO();

            String doNo = event.getDoNo() == null ? event.getDoRlseSts()[0].getDoNo() : event.getDoNo();

            japDorEdiTrans.setBkgNo(event.getDoRlseSts()[0].getBkgNo());
            japDorEdiTrans.setRlseSeq(event.getDoRlseSts()[0].getRlseSeq());
            japDorEdiTrans.setEvntUsrId(account.getUsr_id());
            japDorEdiTrans.setEvntOfcCd(account.getOfc_cd());
            japDorEdiTrans.setCreUsrId(account.getUsr_id());
            japDorEdiTrans.setUpdUsrId(account.getUsr_id());
            japDorEdiTrans.setPreCtnt(event.getPreCtnt());
            japDorEdiTrans.setSvcCd(event.getSvcCd());
            japDorEdiTrans.setBlNo(event.getBlNo());
            japDorEdiTrans.setEvntCd("1");

            japDorEdiTrans.setDoNo(doNo);
            japDorEdiTrans.setUsrId(account.getUsr_id());
            japDorEdiTrans.setOfcCd(account.getOfc_cd());

            command.transmitEdiByJapDorCancel(japDorEdiTrans);

            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG40109").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0326 : 단건 입력 이벤트 처리<br>
     * Japan Cargo Release (D/O)의 event의 event에 대한 단건 입력 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse modifyJapDoId(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0326Event event = (EsmBkg0326Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            begin();

            if(null != event.getJapDorStatus()){
                command.modifyJapDoId(event.getJapDorStatus()[0]);
            }
            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0326 : DEM.DET 모듈과 I/F 정보를 조회한다.
     * @param chargeByBookingCustomerParmVO
     * @return chargeByBookingCustomerGrpVO
     * @throws EventException
     */
    /*
    private DmtChargeVO searchChargeByCustomer(ChargeByBookingCustomerParmVO chargeByBookingCustomerParmVO)throws EventException {
        List<ToTBilAmtVO> bilAmtVOList = new ArrayList<ToTBilAmtVO>();
        ChargeByBookingCustomerGrpVO chargeByBookingCustomerGrpVO;

        //DEM.DET 모듈과 I/F 시작
        ChargeCalculationBC commandIF = new ChargeCalculationBCImpl(); //DEM.DET BC 선언
        DmtChargeVO dmtChargeVO = new DmtChargeVO();


        chargeByBookingCustomerGrpVO = commandIF.searchChargeByCustomer(chargeByBookingCustomerParmVO);
        //왼쪽 합계
        List<ChargeByBookingCustomerCntrVO> cntrVOList = new ArrayList<ChargeByBookingCustomerCntrVO>();
        //오른쪽합계
        List<ChargeByBookingCustomerInvVO> invVOList = new ArrayList<ChargeByBookingCustomerInvVO>();

        Iterator iterator = chargeByBookingCustomerGrpVO.getChargeByBookingCustomerCntrVOS().iterator();
        Iterator iterator2 = chargeByBookingCustomerGrpVO.getChargeByBookingCustomerInvVOS().iterator();


        Map map = new HashMap();
        Map map2 = new HashMap();

        while (iterator.hasNext()) {
            ChargeByBookingCustomerCntrVO cntrVO = (ChargeByBookingCustomerCntrVO) iterator.next();

            log.debug("------------------------- cntrVO1   "+cntrVO.getColumnValues());

            //DEM.DET 모듈에서 currCd를 VO의 currCd or bzcTrfCurrCd에 세팅하고 있음 두 값을 확인해서 있는 값을 써야 한다.
            log.debug("==============================");
            log.debug("DEM.DET CurrCd값 확인");
            log.debug("CurrCd       : "+cntrVO.getCurrCd());
            log.debug("BzcTrfCurrCd : "+cntrVO.getBzcTrfCurrCd());
            log.debug("==============================");

            //2010-01-11 DME.DET 이번에는 BzcTrfCurrCd로 currCd를 쓰란다.
            //String currCd = cntrVO.getCurrCd() == null ? cntrVO.getBzcTrfCurrCd() : cntrVO.getCurrCd();
            //cntrVO.setCurrCd(currCd);

            cntrVO.setCurrCd(cntrVO.getBzcTrfCurrCd());

            if( null == cntrVO.getBilAmt()){
                cntrVO.setBilAmt("0");
            }

            if(!map.containsKey(cntrVO.getCurrCd())){
                map.put(cntrVO.getCurrCd(),0);
            }

            map.put(cntrVO.getCurrCd(),Float.parseFloat(cntrVO.getBilAmt()) + Float.parseFloat(map.get(cntrVO.getCurrCd()).toString()));
            cntrVOList.add(cntrVO);
        }
        dmtChargeVO.setChargeByBookingCustomerCntrVOS(cntrVOList);

        while (iterator2.hasNext()) {
            ChargeByBookingCustomerInvVO cntrVO = (ChargeByBookingCustomerInvVO) iterator2.next();
            log.debug("------------------------- cntrVO2   "+cntrVO.getColumnValues());

            //DEM.DET 모듈에서 currCd를 VO의 currCd or bzcTrfCurrCd에 세팅하고 있음 두 값을 확인해서 있는 값을 써야 한다.
            //정말 어처구니 없는일이 아닐 수 없습니다.!!! 각성하라 !!
            log.debug("==============================");
            log.debug("DEM.DET CurrCd값 확인");
            log.debug("CurrCd       : "+cntrVO.getInvCurrCd());
            //log.debug("BzcTrfCurrCd : "+cntrVO.getBzcTrfCurrCd());
            log.debug("==============================");
            //String currCd = cntrVO.getCurrCd() == null ? cntrVO.getBzcTrfCurrCd() : cntrVO.getCurrCd();
            String currCd = cntrVO.getInvCurrCd();
            cntrVO.setInvCurrCd(currCd);

            if( null == cntrVO.getBilAmt()){
                cntrVO.setBilAmt("0");
            }

            if(!map2.containsKey(cntrVO.getInvCurrCd())){
                map2.put(cntrVO.getInvCurrCd(),0);
            }
            //갚은상태면 오른쪽합계에 추가한다.
            if(cntrVO.getDmdtArIfCd() != null && cntrVO.getDmdtArIfCd().equals("Y")){
                map2.put(cntrVO.getInvCurrCd(),Float.parseFloat(cntrVO.getBilAmt()) + Float.parseFloat(map2.get(cntrVO.getInvCurrCd()).toString()));
                invVOList.add(cntrVO);
            }
        }
        dmtChargeVO.setChargeByBookingCustomerInvVOS(invVOList);


        log.debug("-------------------------- left " + map);
        log.debug("-------------------------- right " + map2);

        Set a = map.keySet();
        Iterator b = a.iterator();
        try{
        while(b.hasNext()){
            String currCd = (String) b.next();

            ToTBilAmtVO bilAmtVo = new ToTBilAmtVO();
            bilAmtVo.setCurrCd(currCd);
            //빼기 시작
            float leftSum = 0;
            float rightSum = 0;
            if(map.containsKey(currCd) && map.get(currCd) != null){
                leftSum = Float.parseFloat(map.get(currCd).toString());
            }
            if(map2.containsKey(currCd) && map2.get(currCd) != null){
                rightSum = Float.parseFloat(map2.get(currCd).toString());
            }
            bilAmtVo.setTotBilAmt("" + (leftSum - rightSum));
            log.debug("---------- bilAmtVo "+ bilAmtVo.getColumnValues());
            bilAmtVOList.add(bilAmtVo);

        }
        }catch(Exception e){
            e.printStackTrace();
        }
        //BILL AMT 추가
        dmtChargeVO.setBilAmtVOList(bilAmtVOList);

        //DemType
        log.debug("------------ setDemurType " + chargeByBookingCustomerGrpVO.getDemurType());
        dmtChargeVO.setDemurType(chargeByBookingCustomerGrpVO.getDemurType());
        return dmtChargeVO;
    }
    */
    /******************************************************************************************
        Author :Lim JinYoung End
    *******************************************************************************************/

    /******************************************************************************************
        Author :An JinEung Start
    *******************************************************************************************/
    /**
     * ESM_BKG_0326 : 조회 이벤트 처리<br>
     * INQUIRY OF eDO 화면의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchEdoRqstList(Event e) throws EventException {

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0132Event event = (EsmBkg0132Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try {
            List<EdoRqstsVO> list = command.searchEdoRqstList(event.getEdoSearchVO());
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
     * ESM_BKG_0326 : 삭제 이벤트 처리<br>
     * InboundNotice의 event에 대한 멀티 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse removeEdoErrData(Event e) throws EventException {
        // TODO Auto-generated method stub
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            begin();

            EsmBkg0132Event event = (EsmBkg0132Event )e;
            CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

            EdoRqstsVO[] edoRqstsVOs = event.getEdoRqstsVOs();

            command.removeEdoErrData(edoRqstsVOs, e.getSignOnUserAccount());
            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0326 : 조회 이벤트 처리<br>
     * eDO Issue Application Inquiry 화면의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchEdoByDoRqst(Event e) throws EventException {

        //PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0133Event event = (EsmBkg0133Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try {
            EdoRqstVO edoRqstVO = command.searchEdoByDoRqst(event.getRqstNo(), event.getTpCd());
            // 기본 정보 추출
            eventResponse.setRsVo(edoRqstVO.getBkgEdoMstVO());

            //송금업체 정보 추출
            eventResponse.setRsVo(edoRqstVO.getBkgEdoDoVO());

            //신청업체, 실화주, 세금계산서 공급받는자 정보 추출
            eventResponse.setRsVoList(edoRqstVO.getBkgEdoPtyTrspVOs());
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0326 : 조회 이벤트 처리<br>
     * D/O EDI Transmit Log List Inquiry 화면의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchEdoTransLog(Event e) throws EventException {

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0134Event event = (EsmBkg0134Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try {

            List<BkgEdoLogVO> list = command.searchEdoTransLog(event.getRcvToDt(), event.getRcvFmDt(), event.getBlNo());
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0326 : 조회 이벤트 처리<br>
     * KT-Net으로 들어온 EDI로 들어온 In-bond Transportation Application 화면의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchEdoByIbdTrspRqst(Event e) throws EventException {

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0135Event event = (EsmBkg0135Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try {

            EdoRqstVO edoRqstVO = command.searchEdoByIbdTrspRqst(event.getRqstNo(), event.getTpCd());

            // 기본 정보 추출
            eventResponse.setRsVo(edoRqstVO.getBkgEdoMstVO());
            //
            eventResponse.setRsVo(edoRqstVO.getBkgEdoIbdTrspVO());
            //
            eventResponse.setRsVoList(edoRqstVO.getBkgEdoPtyTrspVOs());
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0326 : 조회 이벤트 처리<br>
     * KT-Net으로 들어온 EDI로 들어온 Merchant Haulage Application 화면의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchEdoBySelfTrspRqst(Event e) throws EventException {

        //PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0136Event event = (EsmBkg0136Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try {
        	//@ DO 신청 정보를 조회해서 제공한다. 2015.10.16 CHM-201538288
            EdoRqstVO edoRqstVO = command.searchEdoByDoRqst(event.getRqstNo(), event.getTpCd());
            // 기본 정보 추출
            eventResponse.setRsVo(edoRqstVO.getBkgEdoMstVO());

            //송금업체 정보 추출
            eventResponse.setRsVo(edoRqstVO.getBkgEdoDoVO());

            //신청업체, 실화주, 세금계산서 공급받는자 정보 추출
            eventResponse.setRsVoList(edoRqstVO.getBkgEdoPtyTrspVOs());

            //@ 컨테이너별 자가운송 정보 조회
            eventResponse.setRsVoList(command.searchEdoCntrPtyTrsp(event.getRqstNo()));

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0326 : 조회 이벤트 처리<br>
     * Cargo Release Order의 Office Default From Setup 화면의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchDoForm(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0137Event event = (EsmBkg0137Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try {

            List<BkgDoFomVO> list = command.searchDoForm(event.getOffice());
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0326 : 삭제 이벤트 처리<br>
     * InboundNotice의 event에 대한 멀티 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse removeDoForm(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0137Event event = (EsmBkg0137Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try{
            begin();
            command.removeDoForm(event.getOffice(), account);
            eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0326 : 저장 이벤트 처리<br>
     * InboundNotice의 event에 대한 멀티 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse setupDoForm(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0137Event event = (EsmBkg0137Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try{
            begin();
            command.setupDoForm(event.getBkgDoFomVOs(), account);
            eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0326 : 조회 이벤트 처리<br>
     * EU_Cargo Release Order의 D/O Receiver Setting 및 Send와 Release를 할 수 있는 Pop-up화면을 조회한다.<br>
     *
     * @param e EsmBkg0937Event
     * @return EventResponse EsmBkg0937EventResponse
     * @exception EventException
     */
    private EventResponse searchEuDoRcvrInfo(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0937Event event = (EsmBkg0937Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try {
            EuDoRcvrVO euDoRcvrVO = command.searchEuDoRcvrInfo(event.getDoNo(), event.getDoNoSplit());
            eventResponse.setRsVoList(euDoRcvrVO.getDoCntrVos());
            eventResponse.setRsVo(euDoRcvrVO.getBkgDoVO());
            eventResponse.setRsVoList(euDoRcvrVO.getBkgDoCntrVOs());
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_BKG_0326 : 저장 이벤트 처리<br>
     * EU_Cargo Release Order의 D/O Receiver Setting을 저장한다.<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse setupEuDoRcvrInfo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0937Event event = (EsmBkg0937Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try{
            begin();
            command.setupEuDoRcvrInfo(event.getBkgDoVOs(), account);
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0326 : 저장 이벤트 처리<br>
     * EU_Cargo Release Order의 D/O Receiver Setting을 저장한다.<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse setupEuDoTruckerInfo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0937Event event = (EsmBkg0937Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try{
            begin();
            command.setupEuDoTruckerInfo(event.getBkgDoCntrVOs(), account);
            eventResponse.setUserMessage(new ErrorHandler("").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0326 : 메일 전송 이벤트 처리<br>
     * EU_Cargo Release Order의 D/O Receiver Setting을 저장 후 메일 전송한다.<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse sendEuDoByEmail(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0937Event event = (EsmBkg0937Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        BookingHistoryMgtBC hisBC = new BookingHistoryMgtBCImpl();

        try{
            begin();
            String uiId = "ESM_BKG_0937";

            List<BkgNtcHisVO> bkgNtcHisVOs = command.sendEuDoByEmail(event.getBkgDoVOs(), account);
            hisBC.createBkgNtcHis(bkgNtcHisVOs, uiId);
            eventResponse.setUserMessage(new ErrorHandler("BKG40054").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("BKG00243").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0326 : Fax 전송 이벤트 처리<br>
     * EU_Cargo Release Order의 D/O Receiver Setting을 저장 후 Fax 전송한다.<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse sendEuDoByFax(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0937Event event = (EsmBkg0937Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        BookingHistoryMgtBC hisBC = new BookingHistoryMgtBCImpl();

        try{
            begin();
            String uiId = "ESM_BKG_0937";
            List<BkgNtcHisVO> bkgNtcHisVOs = command.sendEuDoByFax(event.getBkgDoVOs(), account);
            hisBC.createBkgNtcHis(bkgNtcHisVOs, uiId);
            eventResponse.setUserMessage(new ErrorHandler("BKG40053").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("BKG00242").getMessage(), ex);
        }
        return eventResponse;
    }



    /**
     * ESM_BKG_0938 조회 이벤트 처리<br>
     * EU Cargo Release (D/O)의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchEuDo(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        EsmBkg0938Event event = (EsmBkg0938Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        BookingUtil bookingUtilBC = new BookingUtil();

        try {
            //BKG_NO가 없을 경우 BL NO로 조회 해 온다.
            if("".equals(event.getBkgNo()) || null == event.getBkgNo()){
                String bkgNo = bookingUtilBC.searchBkgNoByBlNo(event.getBlNo());
                if(! "".equals(bkgNo)){
                    event.setBkgNo(bkgNo);
                }else{
                    String[] msg = new String[]{event.getBlNo()};
                    throw new EventException(new ErrorHandler("BKG40031", msg).getMessage());
                }
            }

            EuDoMstVO euDoMst = command.searchEuDo(event.getBkgNo(), account);

            DmtChargeVO dmtChargeVo = new DmtChargeVO();

            String tpbStatus = ""; //TPB Status

          //DEM/DET 에서 받아서 가공한 데이터
            if(euDoMst.getBlInfo() != null){

            	  dmtChargeVo = this.searchDemDetChargeInfo(event.getBkgNo(),euDoMst.getBlInfo().getPodCd(),event.getDemurType(),event.getExpDelDt());

                  StatusInquiryBC tpbIF = new StatusInquiryBCImpl(); //TPB BC 선언
                  SearchTPBStatusByBkgNoVO searchTpbStatusByBkgNoVO = new SearchTPBStatusByBkgNoVO();
                  searchTpbStatusByBkgNoVO.setSbkgno(event.getBkgNo());
                  tpbStatus = tpbIF.searchTpbStatusByBkgNo(searchTpbStatusByBkgNoVO);
            }
            //EU D/O Release 기본 정보 추출
            eventResponse.setRsVo(euDoMst.getBlInfo());

            //EU D/O Release 기본 Reference 정보 추출
            eventResponse.setRsVo(euDoMst.getBkgDoRefVO());

            //EU 세관 신고를 위한 B/L INFO 추출
            eventResponse.setRsVo(euDoMst.getEuCstms());

            //Container별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보를 추출
            eventResponse.setRsVoList(euDoMst.getEuDoCntrRlseStsVOs());

            //B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보 추출
            eventResponse.setRsVoList(euDoMst.getEuDoRlseStsVOs());

            //조회된 시점에 조회된 Original B/L 회수 여부와 발행 통수 및  Detail정보 추출
            eventResponse.setRsVo(euDoMst.getBlIss());

            //운임 결재 여부와 Outstanding Amounts 정보 추출
            eventResponse.setRsVo(euDoMst.getOtsRcvInfoVO());
            eventResponse.setRsVoList(dmtChargeVo.getChargeByBookingCustomerCntrVOS());
            eventResponse.setRsVoList(dmtChargeVo.getChargeByBookingCustomerInvVOS());
            eventResponse.setRsVoList(dmtChargeVo.getBilAmtVOList());

            //ETC DATA 처리
            eventResponse.setETCData("demurType"  , dmtChargeVo.getDemurType());
            eventResponse.setETCData("tpbStatus"  , tpbStatus);
            //SplitFlg를 추출
            eventResponse.setETCData("splitFlg", euDoMst.getSplitFlg());
            //D/O No가 Split Assign되지 않은 Container의 수량 추출
            eventResponse.setETCData("remainCntrCnt", Integer.toString(euDoMst.getCntrCnt()));
            eventResponse.setETCData("mrdId"       , JSPUtil.getNull(euDoMst.getMrdId(), ""));
            eventResponse.setETCData("localLangFlg", JSPUtil.getNull(euDoMst.getLocalLangFlg(), ""));

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0938 : 단건 입력 이벤트 처리<br>
     * EU Cargo Release (D/O)의 event의 event에 대한 단건 입력 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse manageEuDo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0938Event event = (EsmBkg0938Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        //타 모듈 인터페이스 호출
        BLIssuanceBC bLIssuanceBC = new BLIssuanceBCImpl();

        try{
            begin();
            if(null != event.getEuDoSave()){
                log.debug("=======================================");
                log.debug("    manageEuDo 호출");
                log.debug("=======================================");

                //세션 정보 세팅하기
                event.getEuDoSave().setUserId(account.getUsr_id());
                event.getEuDoSave().setAcount(account);
                event.getEuDoSave().setOblCngFlg(event.getOblCngFlg());
                event.getEuDoSave().setDoCngEvntCd(event.getDoCngEvntCd());

                command.manageEuDo(event.getEuDoSave());
            }

            if(null != event.getBlIssVOs() && "U".equals(event.getBlIssVOs()[0].getIbflag())){
                log.debug("=======================================");
                log.debug("    manageOBLIssue 호출                ");
                log.debug("=======================================");
                //Original Bill of Lading Status 변경 값을 세팅한다.
                event.getBlIssVOs()[0].setBkgNo(event.getBkgNo());
                event.getBlIssVOs()[0].setOblIssOfcCd(account.getOfc_cd());
                event.getBlIssVOs()[0].setOblIssUsrId(account.getUsr_id());
                event.getBlIssVOs()[0].setOblRdemOfcCd(account.getOfc_cd());
                event.getBlIssVOs()[0].setOblRdemUsrId(account.getUsr_id());
                event.getBlIssVOs()[0].setOtrDocRcvOfcCd(account.getOfc_cd());
                event.getBlIssVOs()[0].setOtrDocRcvUsrId(account.getUsr_id());
                event.getBlIssVOs()[0].setCreUsrId(account.getUsr_id());
                event.getBlIssVOs()[0].setUpdUsrId(account.getUsr_id());

                bLIssuanceBC.manageOblRcv(event.getBlIssVOs()[0]);
            }

            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0938 : 대상 B/L에 대해 Release 작업을 수행한다.<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse releaseEuDo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0938Event event = (EsmBkg0938Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        //타 모듈 인터페이스 호출

        try{
            begin();
            event.getEuDoRlse().setUsrId(account.getUsr_id());
            event.getEuDoRlse().setUsrOfcCd(account.getOfc_cd());
            command.releaseEuDo(event.getEuDoRlse(), event.getDoCntrs());
            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00669").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0938 :  EU D/O대상 B/L에 대한 Assign 혹은 Release Staus를 Cancel한다.<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     * @author An Jineung
     */
    private EventResponse cancelEuDo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();


        EsmBkg0938Event event = (EsmBkg0938Event)e;

        event.getDoCancel().setCreUsrId(account.getUsr_id());
        event.getDoCancel().setUpdUsrId(account.getUsr_id());
        event.getDoCancel().setEvntOfcCd(account.getOfc_cd());

        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            begin();
            command.cancelEuDo(event.getDoCancel());
            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00674").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_BKG_0128 : 조회 이벤트 처리<br>
     * CY Delivery 인 경우와 CY Unstuffing 인 경우에 따라 D/O Preview에(베트남) Print에 적용할 문구 코드를 조회한다.<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchVetnamPrnCd(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1035Event event = (EsmBkg1035Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try {
            BkgDoVO bkgDoVo = command.searchVetnamPrnCd(event.getBkgNo());
            eventResponse.setRsVo(bkgDoVo);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0128 : 저장 이벤트 처리<br>
     * EU_Cargo Release Order의 D/O Receiver Setting을 저장한다.<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse setupVetnamPrnCd(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1035Event event = (EsmBkg1035Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try{
            begin();
            String bkgNo = event.getBkgDoVo().getBkgNo();
            String rlseSeq = event.getBkgDoVo().getRlseSeq();
            String vnCgoDeCd = event.getBkgDoVo().getVnCgoDeCd();
            command.setupVetnamPrnCd(bkgNo, rlseSeq, vnCgoDeCd, account.getUsr_id());

            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_BKG_0954 : 저장 이벤트 처리<br>
     * History를 저장한다.<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse createDoHistory(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0954Event event = (EsmBkg0954Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try{
            begin();

            event.getBkgDoHis().setCreUsrId(account.getUsr_id());
            event.getBkgDoHis().setUpdUsrId(account.getUsr_id());
            event.getBkgDoHis().setEvntOfcCd(account.getOfc_cd());
            event.getBkgDoHis().setEvntUsrId(account.getUsr_id());

            command.createDoHistory(event.getBkgDoHis());
            eventResponse.setUserMessage(new ErrorHandler("").getUserMessage());

            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_BKG_0128 :  조회 이벤트 처리<br>
     * Cargo Release (D/O)의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchGenDo(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        EsmBkg0128Event event = (EsmBkg0128Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        BookingUtil bookingUtilBC = new BookingUtil();
        try {
            //BKG_NO가 없을 경우 BL NO로 조회 해 온다.
            if("".equals(event.getBkgNo()) || null == event.getBkgNo()){
                String bkgNo = bookingUtilBC.searchBkgNoByBlNo(event.getBlNo());
                if(! "".equals(bkgNo)){
                    event.setBkgNo(bkgNo);
                }else{
                    String[] msg = new String[]{event.getBlNo()};
                    throw new EventException(new ErrorHandler("BKG40031", msg).getMessage());
                }
            }

            DoMstVO doMst = command.searchGenDo(event.getBkgNo(), account);

            //DEM/DET 에서 받아서 가공한 데이터
            DmtChargeVO dmtChargeVo = new DmtChargeVO();
            String tpbStatus = ""; //TPB Status

            if(doMst.getBlInfo() != null){

            	    	// DEM/DET I/F 연동
                  dmtChargeVo = this.searchDemDetChargeInfo(event.getBkgNo(),doMst.getBlInfo().getPodCd(),event.getDemurType(),event.getExpDelDt());

                  StatusInquiryBC tpbIF = new StatusInquiryBCImpl(); //TPB BC 선언
                  SearchTPBStatusByBkgNoVO searchTpbStatusByBkgNoVO = new SearchTPBStatusByBkgNoVO();
                  searchTpbStatusByBkgNoVO.setSbkgno(event.getBkgNo());
                  tpbStatus = tpbIF.searchTpbStatusByBkgNo(searchTpbStatusByBkgNoVO);
            }

            //D/O Release 기본 정보 추출 (2010.02.08) 수정
            eventResponse.setRsVo(doMst.getGenBlInfo());

            //B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보 추출
            eventResponse.setRsVoList(doMst.getDoRlseStsVOs());
            eventResponse.setRsVoList(dmtChargeVo.getChargeByBookingCustomerCntrVOS());
            eventResponse.setRsVoList(dmtChargeVo.getChargeByBookingCustomerInvVOS());

            // 2010.02.08 BilAmtVOList의 데이터를 풀어서 ETC 형태로 보낸다. (수정 필요)
            eventResponse.setRsVoList(dmtChargeVo.getBilAmtVOList());

            //ETC DATA 처리
            eventResponse.setETCData("demurType"    , dmtChargeVo.getDemurType());
            eventResponse.setETCData("mrdId"        , JSPUtil.getNull(doMst.getMrdId(), ""));
            eventResponse.setETCData("localLangFlg" , JSPUtil.getNull(doMst.getLocalLangFlg(), ""));
            eventResponse.setETCData("tpbStatus"  , tpbStatus);

            //
            BkgHrdCdgCtntListCondVO hrdVO = new BkgHrdCdgCtntListCondVO();
            hrdVO.setHrdCdgId("DUBAI_DO_MRD_ID");
            hrdVO.setAttrCtnt1(doMst.getBlInfo().getDelCd());
            List<BkgHrdCdgCtntVO> hrdList = bookingUtilBC.searchHardCoding(hrdVO);
            if (hrdList.size() > 0) {
            	eventResponse.setETCData("DUBAI_MRD_ID", hrdList.get(0).getAttrCtnt2());
            } else {
            	eventResponse.setETCData("DUBAI_MRD_ID", "");
            }

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0128 :  단건 입력 이벤트 처리<br>
     * Cargo Release (D/O)의 event의 event에 대한 단건 입력 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse manageGenDo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0128Event event = (EsmBkg0128Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        //타 모듈 인터페이스 호출
        BLIssuanceBC bLIssuanceBC = new BLIssuanceBCImpl();

        try{
            begin();

            if(null != event.getDoSave()){
                log.debug("=======================================");
                log.debug("    manageDo 호출");
                log.debug("=======================================");
                log.debug("SC  Split Flg : " + event.getDoSave().getDoSplitFlg());

                //세션 정보 세팅하기
                event.getDoSave().setUserId(account.getUsr_id());
                event.getDoSave().setAcount(account);
                event.getDoSave().setOblCngFlg(event.getOblCngFlg());
                event.getDoSave().setDoCngEvntCd(event.getDoCngEvntCd());
                event.getDoSave().setVtyCngFlg(event.getVtyCngFlg());

                command.manageGenDo(event.getDoSave());
            }

            if(null != event.getBlIssVOs() && "U".equals(event.getBlIssVOs()[0].getIbflag())){
                log.debug("=======================================");
                log.debug("    manageOBLIssue 호출                ");
                log.debug("=======================================");
                //Original Bill of Lading Status 변경 값을 세팅한다.
                event.getBlIssVOs()[0].setOblRdemFlg(event.getAftOblRdemFlg());
                event.getBlIssVOs()[0].setOblRdemOfcCd(account.getOfc_cd());
                event.getBlIssVOs()[0].setOblRdemUsrId(account.getUsr_id());
                event.getBlIssVOs()[0].setOtrDocRcvOfcCd(account.getOfc_cd());
                event.getBlIssVOs()[0].setOtrDocRcvUsrId(account.getUsr_id());
                event.getBlIssVOs()[0].setCreUsrId(account.getUsr_id());
                event.getBlIssVOs()[0].setUpdUsrId(account.getUsr_id());

                //IbdDocRcv관련 정보를 세팅한다.
                event.getBlIssVOs()[0].setIbdDocRcvOfcCd(account.getOfc_cd());
                event.getBlIssVOs()[0].setIbdDocRcvUsrId(account.getUsr_id());

                bLIssuanceBC.manageOblRcv(event.getBlIssVOs()[0]);
            }

            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0128 :  대상 B/L에 대해 D/O Release작업을 수행한다.<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     * @author An JinEung
     */
    private EventResponse releaseGenDo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0128Event event = (EsmBkg0128Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            begin();
            DoRlseVO doRlse = null;
            if(null != event.getGenBlInfos()){
                doRlse = new DoRlseVO();

                doRlse.setBkgNo(event.getBkgNo());
                doRlse.setCgorRmk(event.getReleaseRemark());
                doRlse.setCreUsrId(account.getUsr_id());
                doRlse.setUpdUsrId(account.getUsr_id());
                doRlse.setAcount(account);
                doRlse.setRlseStsCd(event.getRlseStsCd());

                doRlse.setGenBlInfos(event.getGenBlInfos()[0]);
                doRlse.setDoSplitFlg("N");

                command.releaseGenDo(doRlse);

            }
            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00669").getUserMessage());
            commit();

            // PSA인 경우 Release 후 Transmit 처리를 한다.
            if("SG".equals(account.getCnt_cd())){
            	transmitEdiPsaEdo(event);
            // Indonesia Surabaya 지점인 경우 Release 후 Transmit 처리를 한다.
            } else if ("SUBBA".equals(account.getOfc_cd())) {
				transmitEdiSubbaEdo(event);
			}

        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /******************************************************************************************
        Author :An JinEung End
    *******************************************************************************************/

    /******************************************************************************************
        Author :Park Mangeon Start
    *******************************************************************************************/

    /**
     * ESM_BKG_0936 : Retrieve D/O Receiver And Ultimate Consignee(Incl. House B/L no) Setting<br>
     * 인디아 DO에 대한 연락처 정보를 조회한다.<br>
     * @param Event e
     * @return EventResponse
     * @exception EventException
     * @author Park Mangeon
     */
    private EventResponse searchIdaDoRcvrInfo(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {
            EsmBkg0936Event event = (EsmBkg0936Event)e;
            CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
            DoRcvrVO doRcvrVO = event.getDoRcvrVO();
       //     String doNo = doRcvrVO.getDoNo() + doRcvrVO.getDoNoSplit();
            DoRcvrVO doRcvr = command.searchIdaDoRcvrInfo(doRcvrVO.getDoNo(), doRcvrVO.getDoNoSplit());

            if (doRcvr != null) {
                eventResponse.setETCData("do_no_split"   ,doRcvr.getDoNoSplit());
                eventResponse.setETCData("hbl_no"        ,doRcvr.getHblNo());
                eventResponse.setETCData("rcvr_cnee_nm"  ,doRcvr.getRcvrCneeNm());
                eventResponse.setETCData("rcvr_cnee_addr"  ,doRcvr.getRcvrCneeAddr());
                eventResponse.setETCData("rcvr_co_nm"    ,doRcvr.getRcvrCoNm());
                eventResponse.setETCData("rcvr_phn_no"   ,doRcvr.getRcvrPhnNo());
                eventResponse.setETCData("pic_nm"        ,doRcvr.getPicNm());
                eventResponse.setETCData("rcvr_eml"      ,doRcvr.getRcvrEml());
                eventResponse.setETCData("cfs_eml"      ,doRcvr.getCfsEml());
                eventResponse.setETCData("mty_yd_eml"      ,doRcvr.getMtyYdEml());
                eventResponse.setETCData("cust_to_ord_flg"      ,doRcvr.getCustToOrdFlg());
                eventResponse.setETCData("ERR_MSG", "");
            } else {
                eventResponse.setETCData("ERR_MSG", "BKG01058");
            }

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0936 : Save  D/O Receiver And Ultimate Consignee(Incl. House B/L no) Setting<br>
     * 인디아 DO에 대한 연락처 정보를 수정한다.<br>
     * @param Event e
     * @return EventResponse
     * @exception EventException
     * @author Park Mangeon
     */
    private EventResponse setupIdaDoRcvrInfo(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            begin();
            EsmBkg0936Event event = (EsmBkg0936Event)e;
            CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
            DoRcvrVO doRcvrVO = event.getDoRcvrVO();
            command.setupIdaDoRcvrInfo(doRcvrVO, account);
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage()); // TODO: 성공 message key
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0694 : Retrieve - Cargo Delivery - DO LIST CHECK REPORT(JAPAN)<br>
     * Japan Cargo Release Report를 조회한다.<br>
     *  @param Event e
     *  @return EventResponse
     *  @exception EventException
     *  @author Park Mangeon
     */
    private EventResponse searchJapDoHistory(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0694Event event = (EsmBkg0694Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try {
            JapDoHisSearchVO japDoHisSearch = event.getJapDoHisSearchVO();
            List<JapDoHisListVO> list = command.searchJapDoHistory(japDoHisSearch);
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0131 : Retrieve Cargo Release Order List Check Report<br>
     * do check list조회를 수행한다.<br>
     *  @param Event e
     *  @return EventResponse
     *  @author Park Mangeon
     */
    private EventResponse searchDoCheckReport (Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0131Event event = (EsmBkg0131Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try {
            DoCheckListSearchVO chkListSearch = event.getDoCheckListSearchVO();
            DoPfmsVO doPfmsVO = command.searchDoCheckReport(chkListSearch);
            eventResponse.setRsVoList(doPfmsVO.getDoCheckListVOs());

         //   eventResponse.setETCData(etcData)(doPfmsVO.getDoCheckListSummaryVO());

            eventResponse.setETCData("totCnt" , doPfmsVO.getDoCheckListSummaryVO().getTotCnt());
            eventResponse.setETCData("totFeu" , doPfmsVO.getDoCheckListSummaryVO().getTotFeu());
            eventResponse.setETCData("totMea" , doPfmsVO.getDoCheckListSummaryVO().getTotMea());
            eventResponse.setETCData("totTeu" , doPfmsVO.getDoCheckListSummaryVO().getTotTeu());
            eventResponse.setETCData("totWgt" , doPfmsVO.getDoCheckListSummaryVO().getTotWgt());

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0939 : Retrieve - India Cargo Release Order list Inquery<br>
     * Indian Office의 DMDT Payment Type별로  D/O 발행 실적을 Weekly별로 조회한다.<br>
     * Indian Office의 DMDT Payment Type별로  D/O 발행 실적을 조회한다.<br>
     *  @param Event e
     *  @return EventResponse
     *  @exception EventException
     *  @author Park Mangeon
     */
    private EventResponse searchIdaDoRlseReport (Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0939Event event = (EsmBkg0939Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try {
            IdaDoRlseSearchVO idaDoRlseSearch = event.getIdaDoRlseSearchVO();
            IdaDoRlseReportVO idaDoRlseReport = command.searchIdaDoRlseReport(idaDoRlseSearch);
            eventResponse.setRsVoList(idaDoRlseReport.getIdaDoWeeklyReportVO());
            eventResponse.setRsVoList(idaDoRlseReport.getIdaDoRlseListVO());
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM-BKG-0680 : Retrieve - 조회 이벤트 처리<br>
     * India Cargo Release (D/O)의 event에 대한 특정 리스트 조회 이벤트 처리<br>
     * @param Event e
     * @return EventResponse response
     * @exception EventException
     * @author Park Mangeon
     */
    private EventResponse searchIdaDo(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        EsmBkg0680Event event = (EsmBkg0680Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        BookingUtil bookingUtilBC = new BookingUtil();

        try {
            //BKG_NO가 없을 경우 BL NO로 조회 해 온다.
            if("".equals(event.getBkgNo()) || null == event.getBkgNo()){
                String bkgNo = bookingUtilBC.searchBkgNoByBlNo(event.getBlNo());
                if(! "".equals(bkgNo)){
                    event.setBkgNo(bkgNo);
                }else{
                    String[] msg = new String[]{event.getBlNo()};
                    throw new EventException(new ErrorHandler("BKG40031", msg).getMessage());
                }
            }

            IdaDoMstVO doMstVO = command.searchIdaDo(event.getBkgNo(), account);

            DmtChargeVO dmtChargeVo  = new DmtChargeVO();
            String tpbStatus = ""; //TPB Status

            //DEM/DET 에서 받아서 가공한 데이터
            if(doMstVO.getDoBlInfoVO() != null){

            	   	// DEM/DET I/F 연동
                 dmtChargeVo = this.searchDemDetChargeInfo(event.getBkgNo(),doMstVO.getDoBlInfoVO().getPodCd(),event.getDemurType(),event.getExpDelDt());

                 StatusInquiryBC tpbIF = new StatusInquiryBCImpl(); //TPB BC 선언
                 SearchTPBStatusByBkgNoVO searchTpbStatusByBkgNoVO = new SearchTPBStatusByBkgNoVO();
                 searchTpbStatusByBkgNoVO.setSbkgno(event.getBkgNo());
                 tpbStatus = tpbIF.searchTpbStatusByBkgNo(searchTpbStatusByBkgNoVO);
            }

            //India D/O Release 기본 정보 추출 - BL에 의해 생성된 정보(blInfo_)
            eventResponse.setRsVo(doMstVO.getDoBlInfoVO());

            // D/O Reference 정보 (refInfo_)
            eventResponse.setRsVo(doMstVO.getBkgDoRefVO());

            //인도세관 신고를 위한 B/L INFO 추출(cstmsInfo_)
            eventResponse.setRsVo(doMstVO.getIdaCstmsVO());

            //DO가 Container별로 Split되어 DO발행(cntrRlseSts_)
            eventResponse.setRsVoList(doMstVO.getIdaDoCntrRlseStsVOList());

            //DO가 Container별로 Split되지 않고 BL별로 DO발행 (doRlseSts_)
            eventResponse.setRsVoList(doMstVO.getIdaDoRlseStsVOList());

            //조회된 시점에 조회된 Original B/L 회수 여부와 발행 통수 및  Detail정보 추출(blIss_)
            eventResponse.setRsVo(doMstVO.getBlIssVO());

            //운임 결재 여부와 Outstanding Amounts 정보 추출
            eventResponse.setRsVo(doMstVO.getOtsRcvInfoVO());
            eventResponse.setRsVoList(dmtChargeVo.getChargeByBookingCustomerCntrVOS()); //(demInfo_)
            eventResponse.setRsVoList(dmtChargeVo.getChargeByBookingCustomerInvVOS());  //(demDtl_)
            eventResponse.setRsVoList(dmtChargeVo.getBilAmtVOList()); //(totBlbAmt)

            // ETC Data 입력
            eventResponse.setETCData("demurType" , dmtChargeVo.getDemurType());
            eventResponse.setETCData("remain_cnt", Integer.valueOf(doMstVO.getRemainCnt()).toString());
            eventResponse.setETCData("tpbStatus" , tpbStatus);
            eventResponse.setETCData("mrdId"     , JSPUtil.getNull(doMstVO.getMrdId(), ""));

        } catch (EventException ee) {
            throw ee;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0680 : Save - India Cargo Release<br>
     * India Cargodml BL레벨의 정보 처리를 저장한다.<br>
     * bkg_do_ref를 변경한다.
     * @param Event e
     * @return EventResponse
     * @exception EventException
     * @author Park Mangeon
     */
    private EventResponse manageIdaDo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0680Event event = (EsmBkg0680Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        //타 모듈 인터페이스 호출
        BLIssuanceBC bLIssuanceBC = new BLIssuanceBCImpl();

        try{
            begin();
            IdaDoSaveVO idaDoSave = event.getIdaDoSave();

            if(null != event.getBlIssVOs() && "U".equals(event.getBlIssVOs()[0].getIbflag())){
                log.debug("=======================================");
                log.debug("    manageOBLIssue 호출                ");
                log.debug("=======================================");
                //Original Bill of Lading Status 변경 값을 세팅한다.
                event.getBlIssVOs()[0].setOblRdemFlg(event.getAftOblRdemFlg());
                event.getBlIssVOs()[0].setCreUsrId(account.getUsr_id());
                event.getBlIssVOs()[0].setUpdUsrId(account.getUsr_id());

                // blIss_bl_otr_doc_rcv_cd 와 관련된 otr_doc_rcv_ofc_cd, otr_doc_rcv_usr_cd 관련 정보를 저장한다.
                if (event.getBlIssVOs()[0].getBlOtrDocRcvCd() == null || event.getBlIssVOs()[0].getBlOtrDocRcvCd().equals("")) {
                    event.getBlIssVOs()[0].setOtrDocCgorFlg("");
                    event.getBlIssVOs()[0].setOtrDocRcvDt("");
                    event.getBlIssVOs()[0].setOtrDocRcvOfcCd("");
                    event.getBlIssVOs()[0].setOtrDocRcvUsrId("");
                } else {
                    event.getBlIssVOs()[0].setOtrDocRcvOfcCd(account.getOfc_cd());
                    event.getBlIssVOs()[0].setOtrDocRcvUsrId(account.getUsr_id());
                }

                // enter rcv관련 정보를 준비한다.
                event.getBlIssVOs()[0].setIbdDocRcvOfcCd(account.getOfc_cd());
                event.getBlIssVOs()[0].setIbdDocRcvUsrId(account.getUsr_id());

                // OBL RDEM관련 정보를 준비한다.
                event.getBlIssVOs()[0].setOblRdemOfcCd(account.getOfc_cd());
                event.getBlIssVOs()[0].setOblRdemUsrId(account.getUsr_id());

                bLIssuanceBC.manageOblRcv(event.getBlIssVOs()[0]);
            }

            //idaDoSave.setOblCngFlg("N");  // 기본적으로 변경되지 않았다고 본다.
            //if( "N".equals(event.getOriOblRdemFlg()) && "Y".equals(event.getAftOblRdemFlg())){
            if(null != event.getIdaDoSave()){

                /*****************************************
                    DO RELEASE STATUS CODE
                ******************************************
                AS  Assigned
                CR  Cancelled O/BL Received
                DC  DOR Cancel
                DF  DOR I/F
                DT  DOR Transmit
                HC  Cancelled Cargo Hold
                PD  Printed D/O
                RB  Received O. B/L <<== 이 값으로 세팅
                RE  Released
                RI  Received In bond Doc
                RO  Received Other Doc
                RR  Remark for Release
                SF  Sent Fax/E-Mail
                XX  Canceled
                ******************************************/

                //OBL Change 여부 세팅
                idaDoSave.setOblCngFlg(event.getOblCngFlg());

                idaDoSave.setDoCngEvntCd(event.getDoCngEvntCd());
                idaDoSave.setPreCtnt(event.getPreCtnt());
                idaDoSave.setCrntCtnt(event.getCrntCtnt());
            }else{
                log.debug("=================================================================");
                log.debug("    ori_obl_rdem_flg : "+event.getOriOblRdemFlg());
                log.debug("    aft_obl_rdem_flg : "+event.getAftOblRdemFlg());
                log.debug("=================================================================");
            }
            log.debug("=======================================");
            log.debug("    manageIdaDo 호출");
            log.debug("=======================================");

            //세션 정보 세팅하기
            idaDoSave.setUsrId(account.getUsr_id());
            idaDoSave.setOfcCd(account.getOfc_cd());
            command.manageIdaDo(idaDoSave);
            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0680 : Release - India Cargo Release<br>
     * India Cargo 를 Release 한다.<br>
     * @param Event e
     * @return EventResponse
     * @exception EventException
     * @author Park Mangeon
     */
    private EventResponse releaseIdaDo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0680Event event = (EsmBkg0680Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        //타 모듈 인터페이스 호출
        //BLIssuanceBC bLIssuanceBC = new BLIssuanceBCImpl();  // remove by mgpark 미사용하는 변수

        try{
            begin();
            IdaDoRlseVO idaDoRlse = event.getIdaDoRlse();

            //세션 정보 세팅하기
            idaDoRlse.setCreUsrId(account.getUsr_id());
            idaDoRlse.setUpdUsrId(account.getUsr_id());
            idaDoRlse.setEvntOfcCd(account.getOfc_cd());
            command.releaseIdaDo(idaDoRlse, event.getDoCntrs(), account);
            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0923 : Retrieve - Us Cargo release Order for POD Office Pop-up history<br>
     *  @author Park Mangeon
     *  @param Event e
     *  @return EventResponse
     *  @exception EventException
     */
    private EventResponse searchUsCgoRlseHis(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0923Event event = (EsmBkg0923Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try{
            String blNo = event.getBlNo();
            List<UsCgoRlseHisVO> list = command.searchUsCgoRlseHis(blNo);
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    /******************************************************************************************
        Author :Park Mangeon End
    *******************************************************************************************/

    /******************************************************************************************
        Author : Son YunSeuk Start
    *******************************************************************************************/
    /**
     * ESM_BKG_1018 : Retrieve - Cargo Release Remark Pop-up<br>
     *  Cargo Release Remark 조회<br>
     * @author Son YunSeuk
     *  @param Event e
     *  @return EventResponse
     *  @exception EventException
     */
    private EventResponse searchDoPrnRmk(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1018Event event = (EsmBkg1018Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try{
            DoPrnRmkVO doPrnRmkVO = event.getDoPrnRmkVO();
            List<DoPrnRmkVO> doPrnRmkVOResults = command.searchDoPrnRmk(doPrnRmkVO.getDoNo(), account);
            eventResponse.setRsVoList(doPrnRmkVOResults);


//            if(doPrnRmkVOResult == null){
//                eventResponse.setETCData("do_prn_rmk" , "");
//                eventResponse.setETCData("status"     , "no_data");
//            }else{
//                eventResponse.setETCData("do_prn_rmk"   ,doPrnRmkVOResult.getDoPrnRmk());
//                eventResponse.setETCData("status"     , "ok");
//            }


        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_1018 : Save - Cargo Release Remark Pop-up<br>
     *  Cargo Release Remark 저장<br>
     * @author Son YunSeuk
     *  @param Event e
     *  @return EventResponse
     *  @exception EventException
     */
    private EventResponse modifyDoPrnRmk(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1018Event event = (EsmBkg1018Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try{
            begin();
            DoPrnRmkVO doPrnRmkVO = event.getDoPrnRmkVO();
            command.modifyDoPrnRmk(doPrnRmkVO, account);
            eventResponse.setETCData("status", "ok");
            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
    * EMS_BKG0272 : Retrieve - Full CNTR Release Order<br>
    *  Full CNTR Release Order 조회<br>
    * @author Son YunSeuk
    *  @param Event e
    *  @return EventResponse
    *  @exception EventException
    */
   private EventResponse searchFullCntrRlseOrderList(Event e) throws EventException{
       GeneralEventResponse eventResponse = new GeneralEventResponse();
       EsmBkg0272Event event = (EsmBkg0272Event)e;
       CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
       try{
           FullCntrRlseOrderSearchVO fullCntrRlseOrderSearch  = event.getFullCntrRlseOrderSearchVO();

           // Login 사용자 국가 코드 정보 셋팅
           fullCntrRlseOrderSearch.setCntCd(account.getCnt_cd());
           fullCntrRlseOrderSearch.setUsrOfcCd(account.getOfc_cd());

           List<FullCntrRlseOrdVO> list = command.searchFullCntrRlseOrderList(fullCntrRlseOrderSearch );
           if(list == null){
               eventResponse.setETCData("status", "no_data");
           }else if(list.size() > 0){
               eventResponse.setETCData("status", "ok");
               eventResponse.setRsVoList(list);
           }else{
               eventResponse.setETCData("status", "no_data");
           }
       } catch(EventException ex) {
           throw ex;
       } catch(Exception ex) {
           log.error("err " + ex.toString(), ex);
           // COM12240 : Unexpected system error took place during data processing. Please try again later.
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
       }
       return eventResponse;
   }


    /**
     * ESM_BKG_0272 : E-Mail - Full CNTR Release Order<br>
     *  Full CNTR Release Order Email, Yard 유효성 체크<br>
     * @author Son YunSeuk
     *  @param Event e
     *  @return EventResponse
     *  @exception EventException
     */
    private EventResponse searchFullCntrRlseOrdMailCtntForTmnl(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0272Event event = (EsmBkg0272Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{

        	FullCntrRlseOrderMailVO fullCntrRlseOrderMailVo = command.searchFullCntrRlseOrdMailCtntForTmnl(event.getFullCntrRlseOrdVOs(), account);

        	eventResponse.setRsVoList(fullCntrRlseOrderMailVo.getFullCntrRlseOrdVos());
        	eventResponse.setRsVoList(fullCntrRlseOrderMailVo.getFullCntrRlseOrderMailSendVos());

        }catch(EventException ex){
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0272 : E-Mail - Full CNTR Release Order<br>
     *  Full CNTR Release Order Email, Yard 유효성 체크<br>
     * @author Son YunSeuk
     *  @param Event e
     *  @return EventResponse
     *  @exception EventException
     */
    private EventResponse searchFullCntrRlseOrdMailCtntForCust(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0272Event event = (EsmBkg0272Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{

        	FullCntrRlseOrderMailVO fullCntrRlseOrderMailVo = command.searchFullCntrRlseOrdMailCtntForCust(event.getFullCntrRlseOrdVOs(), account);

        	eventResponse.setRsVoList(fullCntrRlseOrderMailVo.getFullCntrRlseOrdVos());
        	eventResponse.setRsVoList(fullCntrRlseOrderMailVo.getFullCntrRlseOrderMailSendVos());

        }catch(EventException ex){
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0272 : Send - Full CNTR Release Order<br>
     *  Full CNTR Release Order Email, EDI Trans History Add<br>
     * @author Son YunSeuk
     *  @param Event e
     *  @return EventResponse
     *  @exception EventException
     */
    private EventResponse sendFullCntrRlseOrderByEmail(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0272Event event = (EsmBkg0272Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try{
            begin();

            command.sendEmailFullCntrRlseOrder(event.getCargoSendEmailVOs(), event.getFullCntrRlseOrdVOs(), account, event.getEmlDiff());
            eventResponse.setUserMessage( new ErrorHandler("BKG40054").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00243").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0272 : EDI - Full CNTR Release Order<br>
     *  Full CNTR Release Order Email, Yard 유효성 체크<br>
     * @author Son YunSeuk
     *  @param Event e
     *  @return EventResponse
     *  @exception EventException
     */
    private EventResponse transmitEdiFullCntrRlseOrder(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0272Event event = (EsmBkg0272Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            begin();

            FullCntrRlseOrderEdiSendVO[] list = event.getFullCntrRlseOrderEdiSendVOs();

            command.transmitEdiFullCntrRlseOrder(list, account);

            eventResponse.setUserMessage( new ErrorHandler("BKG06070").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_1052 : Setup - Full CNTR Release Order Remark Pop-up<br>
     * Full CNTR Release Order Remark Save<br>
     * @author Son YunSeuk
     *  @param Event e
     *  @return EventResponse
     *  @exception EventException
     *  @author Son YunSeuk
     */
    private EventResponse modifyFullCntrRlseRmk(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1052Event event = (EsmBkg1052Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try{
            begin();
            int rtn = command.modifyFullCntrRlseRmk(event.getBkgFullCntrRemarkVO(), account);
            if(rtn > 0){
                eventResponse.setETCData("status", "ok");
            }else{
                eventResponse.setETCData("status", "no");
            }
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0273 : Retrieve - Full CNTR Release History<br>
     * Full CNTR Release Order History<br>
     * @author Son YunSeuk
     *  @param Event e
     *  @return EventResponse
     *  @exception EventException
     */
    private EventResponse searchFullReleaseHistory(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0273Event event = (EsmBkg0273Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try{
            FullCntrRlseOrderHisSearchVO fullCntrRlseOrderHisSearchVO = event.getFullCntrRlseOrderHisSearchVO();
            List<FullCntrRlseOrderHisVO> list = command.searchFullCntrRlseOrderHis(fullCntrRlseOrderHisSearchVO, account);
            if(list == null){
                eventResponse.setETCData("status", "no_data");
            }else if(list.size() > 0){
                eventResponse.setETCData("status", "ok");
                eventResponse.setRsVoList(list);
            }else{
                eventResponse.setETCData("status", "no_data");
            }
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0130 : Retrieve - Cargo Release Order_D/O Receiver and Actual Consignee information<br>
     * Receiver Info 조회<br>
     * @author Son YunSeuk
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchDoRcvrInfo(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0130Event event = (EsmBkg0130Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            DoRcvrInfoVO searchRcvrInfoVO = event.getDoRcvrInfoVO();
            String doNo = searchRcvrInfoVO.getDoNo();
            DoRcvrInfoVO doRcvrInfoVO = null;
            doRcvrInfoVO = command.searchDoRcvrInfo(doNo);
            if(doRcvrInfoVO == null){
                eventResponse.setETCData("status", "no_data");
            }else{
                eventResponse.setETCData("status", "ok");
                eventResponse.setETCData("bkg_no",      doRcvrInfoVO.getBkgNo());
                eventResponse.setETCData("do_no",       doRcvrInfoVO.getDoNo());
                eventResponse.setETCData("rcvr_co_nm",  doRcvrInfoVO.getRcvrCoNm());
                eventResponse.setETCData("cntc_phn_no", doRcvrInfoVO.getCntcPhnNo());
                eventResponse.setETCData("pic",         doRcvrInfoVO.getPic());
                eventResponse.setETCData("act_cnee_nm", doRcvrInfoVO.getActCneeNm());
                eventResponse.setETCData("cust_ref_nm", doRcvrInfoVO.getCustRefNm());
                eventResponse.setETCData("order_flg",   doRcvrInfoVO.getOrderFlg());
            }
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0130 : Save - Cargo Release Order_D/O Receiver and Actual Consignee information<br>
     * Receiver Info 저장<br>
     * @param Event e
     * @return EventResponse
     * @exception EventException
     * @author Son YunSeuk
     */
    private EventResponse setupDoRcvrInfo(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0130Event event = (EsmBkg0130Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            begin();
            int updateCount = command.setupDoRcvrInfo(event.getDoRcvrInfoVO(), account);
            if(updateCount == 1){
                eventResponse.setETCData("status", "ok");
            }else{
                eventResponse.setETCData("status", "no");
            }
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /******************************************************************************************
        Author : Son YunSeuk End
    ******************************************************************************************/

    /**
     * [FNS071] OTS 미수금 수신 (VVD별 조회시)
     * I/F
     * @param e
     * @return EventResponse
     */
    private EventResponse receiveOtsInfo(Event e)  throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ESM0710001Event event = (ESM0710001Event)e;
        CargoReleaseOrderBC command = null;

        try{

            //XmlObject obj = event.getXmlObject();
            ROW otsCollectionRes = (ROW)event.getAttribute("otsCollectionRes");

            command = new CargoReleaseOrderBCImpl();
            BkgOutstandingVO ots = new BkgOutstandingVO();

            ots.setOfcCd(otsCollectionRes.getOFC());
            ots.setCltBlNo(otsCollectionRes.getBLNO());
            ots.setInvNo(otsCollectionRes.getINVNO());
            ots.setOfcCurrCd(otsCollectionRes.getOFCCURRENCY());
            ots.setOtsBkgNo(otsCollectionRes.getBKGNO());
            ots.setOtsDueDt(otsCollectionRes.getDUEDT());
            ots.setOtsStlFlg(otsCollectionRes.getSTLMK());
            ots.setXchRtTpCd(otsCollectionRes.getEXCHANGERATETYPE());
            ots.setCltRmk(otsCollectionRes.getCOLLECTIONREMARK());
            ots.setOtsGrpTpCd(otsCollectionRes.getOTSGRPTY());

            ots.setOtsOccrTpCd(otsCollectionRes.getOTSTY());
            ots.setCrFlg(otsCollectionRes.getCRDTMK());
            ots.setOtsBndTpCd(otsCollectionRes.getBND());
            ots.setBilToCustCd(otsCollectionRes.getCUSTBILLTOCD());
            ots.setOtsBndTpCd(otsCollectionRes.getBND());
            ots.setLstCltOfcCd(otsCollectionRes.getCOLLECTIONOFFICE());
            ots.setLstUpdChkDt(otsCollectionRes.getTRXDATE());
            ots.setOtsTjSeq(otsCollectionRes.getTRANSEQ());

            BkgOtsDtlVO otsDtls = new BkgOtsDtlVO();
            otsDtls.setOfcCd(otsCollectionRes.getDTLOFC());
            otsDtls.setCltBlNo(otsCollectionRes.getDTLBLNO());
            otsDtls.setInvNo(otsCollectionRes.getDTLINVNO());
            otsDtls.setBlCurrCd(otsCollectionRes.getBLCURRENCY());
            otsDtls.setInvFrtAmt(otsCollectionRes.getINVFRTAMT());
            otsDtls.setInvWfgAmt(otsCollectionRes.getINVWFTAMT());
            otsDtls.setInvCttAmt(otsCollectionRes.getINVCTTAMT());
            otsDtls.setInvTaxAmt(otsCollectionRes.getINVTAXAMT());
            otsDtls.setInvRsvAmt(otsCollectionRes.getINVRSVAMT());
            otsDtls.setInvLstUpdDt(otsCollectionRes.getINVUPDTDT());

            otsDtls.setCltFrtAmt(otsCollectionRes.getCOLFRTAMT());
            otsDtls.setCltWfgAmt(otsCollectionRes.getCOLWFTAMT());
            otsDtls.setCltCttAmt(otsCollectionRes.getCOLCTTAMT());
            otsDtls.setCltTaxAmt(otsCollectionRes.getCOLTAXAMT());
            otsDtls.setCltRsvAmt(otsCollectionRes.getCOLRSVAMT());
            otsDtls.setCltLstUpdDt(otsCollectionRes.getCOLUPDTDT());

            otsDtls.setAdjFrtAmt(otsCollectionRes.getADJFRTAMT());
            otsDtls.setAdjWfgAmt(otsCollectionRes.getADJWFTAMT());
            otsDtls.setAdjCttAmt(otsCollectionRes.getADJCTTAMT());
            otsDtls.setAdjTaxAmt(otsCollectionRes.getADJTAXAMT());
            otsDtls.setAdjRsvAmt(otsCollectionRes.getADJRSVAMT());
            otsDtls.setAdjLstUpdDt(otsCollectionRes.getADJUPDTDT());

            otsDtls.setBalFrtAmt(otsCollectionRes.getBALFRTAMT());
            otsDtls.setBalWfgAmt(otsCollectionRes.getBALWFTAMT());
            otsDtls.setBalCttAmt(otsCollectionRes.getBALCTTAMT());
            otsDtls.setBalTaxAmt(otsCollectionRes.getBALTAXAMT());
            otsDtls.setBalRsvAmt(otsCollectionRes.getBALRSVAMT());
            otsDtls.setBalLstUpdDt(otsCollectionRes.getBALUPDTDT());

            otsDtls.setWrtfAmt(otsCollectionRes.getWRITEOFFAMT());
            otsDtls.setWrtfLstUpdDt(otsCollectionRes.getWRITEOFFUPDTDT());
            otsDtls.setPpdAmt(otsCollectionRes.getPREAMT());
            otsDtls.setPpdLstUpdDt(otsCollectionRes.getPREUPDTDT());
            otsDtls.setPreCfmOfcCurrRto(otsCollectionRes.getEXRATELCL());
            otsDtls.setPreCfmUsdRto(otsCollectionRes.getEXRATEUSD());
            otsDtls.setCfmOfcCurrRto(otsCollectionRes.getEXRATELCLL());

            otsDtls.setBalFrtOfcCurrAmt(otsCollectionRes.getBALFRTAMTLCL());
            otsDtls.setBalWfgOfcCurrAmt(otsCollectionRes.getBALWFTAMTLCL());
            otsDtls.setBalCttOfcCurrAmt(otsCollectionRes.getBALCTTAMTLCL());
            otsDtls.setBalTaxOfcCurrAmt(otsCollectionRes.getBALTAXAMTLCL());
            otsDtls.setBalRsvOfcCurrAmt(otsCollectionRes.getBALRSVAMTLCL());

            otsDtls.setBalFrtUsdAmt(otsCollectionRes.getBALFRTAMTUSD());
            otsDtls.setBalWfgUsdAmt(otsCollectionRes.getBALWFTAMTUSD());
            otsDtls.setBalCttUsdAmt(otsCollectionRes.getBALCTTAMTUSD());
            otsDtls.setBalTaxUsdAmt(otsCollectionRes.getBALTAXAMTUSD());
            otsDtls.setBalRsvUsdAmt(otsCollectionRes.getBALRSVAMTUSD());

            // OTS Master 생성
            String chkFlg = this.receiveOtsMst(ots);

               // OTS Detail 생성
            this.receiveOtsDtl(otsDtls,chkFlg);

            this.receiveOtsMst(ots);

            // 미주 Cargo Release 생성
            this.searchOtsUsCgo(ots,chkFlg);

        } catch(Exception ex) {
             log.error("receiveOtsInfo err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * [FNS071] OTS 미수금 수신 (VVD별 조회시)
     * I/F
     * @param BkgOutstandingVO ots
     * @return String
     */
    private String receiveOtsMst(BkgOutstandingVO ots) throws EventException {
       CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

       String chkFlg = "N" ;
       try{
           // ERP 데이타 구종상 한 이벤트 발생 시 동일한 Header
           // 데이타에 대해 Detail 변경 이벤트가 두번 발생하므로 중복된 Header정보가 수신됨.
            begin();
            chkFlg = command.receiveOtsMst(ots);
            commit();
       } catch(EventException ex) {
           rollback();
           log.error("receiveOtsMst err " + ex.toString(), ex);
           throw ex;
       } catch(Exception ex) {
           rollback();
           log.error("receiveOtsMst err " + ex.toString(), ex);
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
       }
       return chkFlg;

    }
    /**
     * [FNS071] OTS 미수금 수신 (VVD별 조회시)
     * I/F
     * @param BkgOtsDtlVO otsDtls
     * @param String chkFlg
     * @return void
     */
    private void receiveOtsDtl(BkgOtsDtlVO otsDtls,String chkFlg) throws EventException {
       CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
       try{
    	    begin();
	       	if("Y".equals(chkFlg) ) {
	       		command.receiveOtsDtl( otsDtls);
	       	}
            commit();
       } catch(EventException ex) {
           rollback();
           log.error("receiveOtsDtl err " + ex.toString(), ex);
           throw ex;
       } catch(Exception ex) {
           rollback();
           log.error("receiveOtsDtl err " + ex.toString(), ex);
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
       }
    }

    /**
     * [FNS071] ERP OTS 수신 후 미주 Cargo Release 호출
     * I/F
     * @param BkgOutstandingVO ots
     * @param String chkFlg
     * @return void
     */
    private void searchOtsUsCgo(BkgOutstandingVO ots,String chkFlg) throws EventException {
       CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

       try{
	    	// Inbound 이벤트만 호출
	       	begin();
	       	if("I".equals( ots.getOtsBndTpCd()) && "Y".equals(chkFlg) ) {
	       		command.searchOtsUsCgo(ots);
	       	}
	       	commit();
       }catch(EventException ex) {
           if(ex.getMessage().indexOf("BKG40085") > -1){
               commit();
           }else if(ex.getMessage().indexOf("BKG40086") > -1){
               commit();
           }else if(ex.getMessage().indexOf("BKG40087") > -1){
               commit();
           }else if(ex.getMessage().indexOf("BKG40108") > -1){
               commit();
           }else{
               rollback();
               throw ex;
           }
       }catch(Exception ex){
       	 rollback();
         throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
       }
    }

    /**
     * [0909] 조회 Master
     * 미주 Inbound Cargo Release에 대한 List를 Item별로 조회한다.
     * @param e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchUsCgoRlseList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0909Event event = (EsmBkg0909Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            UsCgoRlseSearchVO searchVO = event.getSearchVO();
            eventResponse.setRsVoList(command.searchUsCgoRlseList(searchVO));
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * [0909] 조회 Detail
     * 미주 Inbound Cargo Release에 대한 List 조회 후,
     * 해당 B/L의 FOC 값 및 HOLD, Remark를 조회한다.
     * @param e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchUsCgoRlseFoc(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0909Event event = (EsmBkg0909Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            String bkgNo = event.getBkgNo();
            //String blNo = event.getBlNo();
            //Container List
            eventResponse.setRsVoList(command.searchUsCgoRlseFoc(bkgNo));


        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw ex;
            //throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * [0909] ERP,DEM DET 정보 조회
     * @param e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchErpOtsInfo(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0909Event event = (EsmBkg0909Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        log.debug("-------------------------------------------------------");
        log.debug("ERP DEM DET 가져오기 시작");
        log.debug("-------------------------------------------------------");

        String bkgNo = event.getBkgNo();
        String blNo = event.getBlNo();
        String podCd = event.getPodCd();

        log.debug("------------------------ bkgNo "+bkgNo);
        log.debug("------------------------ blNo "+blNo);
        log.debug("------------------------ podCd "+podCd);
        try{
            //------------------------------------------------------
            //ERP
            //CURR 개수만큼 그룹지어서 합계.
            //------------------------------------------------------
            OtsRcvInfoVO oriVO = command.searchErpOtsInfo(blNo);

            log.debug("---------- oriVO "+oriVO.getColumnValues());
            Map<String,String> map = oriVO.getColumnValues();




            Map<String,Float> groupMap = new HashMap<String, Float>();
            Vector<String> vec = new Vector<String>();
            log.debug("-------------------- map " + map);
            for(int i=0;i<5;i++){

                String currKey = map.get("tot_ots_curr_cd"+(i+1));
                //CURRENCY 가 없을경우 통과.
                if(map.get("tot_ots_curr_cd"+(i+1)) == null || map.get("tot_ots_curr_cd"+(i+1)).trim().equals("")){
                    continue;
                }
                String amtValue = map.get("tot_ots_amt"+(i+1));

                if(groupMap.containsKey(currKey)){//key값 존재시 합계
                    groupMap.put( currKey, Float.parseFloat(groupMap.get(currKey).toString())
                            + Float.parseFloat(amtValue));
                }else{
                    groupMap.put(currKey, Float.parseFloat(amtValue));
                    vec.add(currKey);
                }
            }
            log.debug("------------ groupMap  "+groupMap);
            log.debug("------------ vec  "+vec);

            //신용화주일경우 2010.04.01
            if(oriVO.getTotOtsStsCd() != null && oriVO.getTotOtsStsCd().equals("C")){
            	eventResponse.setETCData("otsCnt"  , "1");
                eventResponse.setETCData("ots0", "CREDIT");

            //비신용화주일경우   2010.04.01
            }else{
	            //값이 없거나, 0 이라도 USD 를 넣어준다.
	            if(vec.size() == 0){
	                eventResponse.setETCData("otsCnt"  , "1");
	                eventResponse.setETCData("ots0", ""+ " " + oriVO.getTotOtsAmt1() );
	                //eventResponse.setETCData("ots0", ""+ " " + "N/A" );
	            }else{
	                eventResponse.setETCData("otsCnt"  , ""+vec.size());
	                for(int x=0;x<vec.size();x++){
	                    eventResponse.setETCData("ots"+x, vec.get(x)+ " " +groupMap.get(vec.get(x)) );
	                }
	            }
            }

            //------------------------------------------------------
            //DEM DET Container 정보
            //------------------------------------------------------
            String[] demDetChargeInfo = null;

            demDetChargeInfo = command.searchDemDetCntrList(bkgNo);

            //------------------------------------------------------
            //Charge By Customer
            //outstanding 합계는 searchKorDo 참조.
            //status ; outstanding 합계가 0 이면 'Y' 아니면 'N'
            //------------------------------------------------------
            //ChargeCalculationBC ccBc = new ChargeCalculationBCImpl();
            ChargeByBookingCustomerParmVO chargeByBookingCustomerParmVO = new ChargeByBookingCustomerParmVO();
            chargeByBookingCustomerParmVO.setBkgNo(bkgNo);
            chargeByBookingCustomerParmVO.setPodCd(podCd);
            chargeByBookingCustomerParmVO.setCntrNo(demDetChargeInfo);
            chargeByBookingCustomerParmVO.setDmdtTp("");
            chargeByBookingCustomerParmVO.setExpDelDt("");

            //안진응 수정 Dem에서 오류가 난 경우에 대한 처리 시작
            //ChargeByBookingCustomerGrpVO grpVO = null;

            //DEM/DET 에서 받아서 가공한 데이터
            DmtChargeVO dmtChargeVO = new DmtChargeVO();
            ChargeCalculationBC commandIF = new ChargeCalculationBCImpl(); //DEM.DET BC 선언
            BookingUtil bookingUtilBC = new BookingUtil();
            try {
                //dmtChargeVO = this.searchChargeByCustomer(chargeByBookingCustomerParmVO);
                ChargeByBookingCustomerGrpVO chargeByBookingCustomerGrpVO;
                chargeByBookingCustomerGrpVO = commandIF.searchChargeByCustomer(chargeByBookingCustomerParmVO);
                dmtChargeVO = bookingUtilBC.searchChargeByCustomer(chargeByBookingCustomerGrpVO);
                //grpVO = ccBc.searchChargeByCustomer(chargeByBookingCustomerParmVO);
            } catch (Exception ex) {
            	log.warn("warring : " + ex.toString(), ex);
            	log.error(ex.getMessage()); // 2011.07.15
                //Business Logic 상 Exception 처리불가.
                //윤윤한수석 문의
                //dmtChargeVO = null;

            }
            //List<ChargeByBookingCustomerCntrVO> cntrVOList = new ArrayList<ChargeByBookingCustomerCntrVO>();

            log.debug("------------- chargeByBookingCustomerParmVO "+chargeByBookingCustomerParmVO);
            log.debug("------------- dmtChargeVO "+dmtChargeVO);
            //grpVO의 값이 Null이 아닌경우에 대해서만 처리함
            if (dmtChargeVO != null) {
                //log.debug("------------------- gMap "+cntrVO.getBzcTrfCurrCd() + " "+ gMap.get(cntrVO.getBzcTrfCurrCd()));
                List<ToTBilAmtVO> totBilAmtVOList = dmtChargeVO.getBilAmtVOList();

                ToTBilAmtVO totBilAmtVO;
                String currCd = "";
                String demAmt = "";
                float demAmtTmp = 0;
                String demType = "";

                log.debug("---------- totBilAmtVOList "+totBilAmtVOList);

                if(totBilAmtVOList != null && totBilAmtVOList.size() > 0){
                	log.debug("---------- totBilAmtVOList.size() "+totBilAmtVOList.size());
                    totBilAmtVO = totBilAmtVOList.get(0);
                    currCd = totBilAmtVO.getCurrCd();
                    demAmt = totBilAmtVO.getTotBilAmt();
                    demAmtTmp = Float.parseFloat(demAmt);
                    demType = dmtChargeVO.getDemurType();
                }

                eventResponse.setETCData("demAMT"  , currCd + " "+ demAmt);

                log.debug("--------------------- demAmtTmp "+demAmtTmp);

                if(demAmtTmp > 0){
                    eventResponse.setETCData("demStatus"  , "N");
                }else{
                    eventResponse.setETCData("demStatus"  , "Y");
                }
                //log.debug("---------- grpVO.getDemurType() "+dmtChargeVO.getDemurType());
                //log.debug("---------- grpVO.getChargeByBookingCustomerCntrVOS() "+dmtChargeVO.getChargeByBookingCustomerCntrVOS());
                eventResponse.setETCData("demurType"  , demType);
            } else {
                //grpVO의 값이 Null인 경우에 대해서만 처리함
                eventResponse.setETCData("demAMT"     , "");
                eventResponse.setETCData("demStatus"  , "");
                eventResponse.setETCData("demurType"  , "");
            }

            //------------------------------------------------------
            //TPB 구하기
            //------------------------------------------------------
            StatusInquiryBC tpbIF = new StatusInquiryBCImpl(); //TPB BC 선언
            SearchTPBStatusByBkgNoVO searchTpbStatusByBkgNoVO = new SearchTPBStatusByBkgNoVO();
            searchTpbStatusByBkgNoVO.setSbkgno(event.getBkgNo());
            String tpbStatus = tpbIF.searchTpbStatusByBkgNo(searchTpbStatusByBkgNoVO);
            log.debug("---------- tpbStatus     "+tpbStatus);
            eventResponse.setETCData("tpbStatus"  , tpbStatus);

        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw ex;
            //throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * [0909_01] save 저장
     * U.S. Cargo Release에서 F.O.C 변경 내역에 대한 저장을 수행한다.
     * @param e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageUsCgoRlse(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0909Event event = (EsmBkg0909Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        BLIssuanceBC command2 = new BLIssuanceBCImpl();
        try{
            begin();
            BkgCgoRlseVO[] bkgCgoRlseVOs = event.getBkgCgoRlseVOs();
            BkgBlIssVO[] blIssVOs = event.getBlIssVOs();

            //1.Obl 저장
            if(blIssVOs != null){
            	command2.manageOblRcvByUsCgo(blIssVOs, this.getSignOnUserAccount());
            }
            //2. Remark 저장
            if(bkgCgoRlseVOs != null){
            	command.manageUsCgoRlse(bkgCgoRlseVOs[0],this.getSignOnUserAccount());
            }


            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.\
           	eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());

            commit();
        } catch(EventException ex) {

            //log.error("----------------err.toString [" + ex.toString()+"]", ex);
            //log.error("----------------err.getMessage [" + ex.getMessage()+"]", ex);

            if(ex.getMessage().indexOf("BKG40085") > -1){
                commit();
                //log.debug("---------------- commit 했음 msg번호 " + ex.getMessage());
                throw new EventException(new ErrorHandler("BKG40085").getMessage());

            }else if(ex.getMessage().indexOf("BKG40086") > -1){
                commit();
                log.debug("---------------- commit 했음 msg번호 " + ex.getMessage());
              throw new EventException(new ErrorHandler("BKG40086").getMessage());
            }else if(ex.getMessage().indexOf("BKG40087") > -1){
                commit();
                log.debug("---------------- commit 했음 msg번호 " + ex.getMessage());
              throw new EventException(new ErrorHandler("BKG40087").getMessage());
            }else if(ex.getMessage().indexOf("BKG40108") > -1){
                commit();
                log.debug("---------------- commit 했음 msg번호 " + ex.getMessage());
              throw new EventException(new ErrorHandler("BKG40108").getMessage());
            }else{
                rollback();
                throw ex;
            }

        }catch(Exception ex){
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * [0156] COD Application POD 변경시 CgoRlse
     * @param e
     * @return EventResponse
     * @exception EventException
     *
     */
    private EventResponse manageUsCgoRlseChangePod(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0909Event event = (EsmBkg0909Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            begin();

            BkgCgoRlseVO[] bkgCgoRlseVo = event.getBkgCgoRlseVOs();
            command.manageUsCgoRlseChangePod(bkgCgoRlseVo[0] ,this.getSignOnUserAccount());
            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자
           	eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());

            commit();
        } catch(EventException ex) {
        	rollback();
            log.error("err " + ex.toString(), ex);

        }catch(Exception ex){
            rollback();
            log.error("err " + ex.toString(), ex);

        }
        return eventResponse;
    }


    /**
     * [0909_01] hold 저장
     *
     * @param e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageUsCgoRlseHold(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0909Event event = (EsmBkg0909Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try{
            begin();
            DoRefVO[] vos = event.getDoRefVOs();
            command.manageUsCgoRlseHold(vos,this.getSignOnUserAccount());
            //DoPrnRmkVO doPrnRmkVO = event.getDoPrnRmkVO();
            //command.modifyDoPrnRmk(doPrnRmkVO, account);
            //eventResponse.setETCData("status", "ok");
          //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * [0668_09] save 저장 ; C/S 쪽 Remark 만 저장
     *
     * @param e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageDoHldRmk(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0909Event event = (EsmBkg0909Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try{
            begin();
            DoRefVO[] doRefVOs = event.getDoRefVOs();

            BkgDoRefVO bkgDoRefVO = new BkgDoRefVO();

            ObjectCloner.build(doRefVOs[0], bkgDoRefVO);
            bkgDoRefVO.setCreUsrId(this.getSignOnUserAccount().getUsr_id());
            bkgDoRefVO.setUpdUsrId(this.getSignOnUserAccount().getUsr_id());
            //String blNo = event.getBlNo();
            command.manageDoHldRmk(bkgDoRefVO);
            //DoPrnRmkVO doPrnRmkVO = event.getDoPrnRmkVO();
            //command.modifyDoPrnRmk(doPrnRmkVO, account);
            //eventResponse.setETCData("status", "ok");
            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     *  F.O.C 관련 Event 발생 시 관련 정보를 갱신하다.
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse setupFocByFreight(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0909Event event = (EsmBkg0909Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try{
            begin();
            //DoRefVO[] doRefVOs = event.getDoRefVOs();
            //BkgCgoRlseVO[] bkgCgoRlseVOs = event.getBkgCgoRlseVOs();
            //String blNo = event.getBlNo();
            //command.manageUsCgoRlseTrans(doRefVOs,bkgCgoRlseVOs,this.getSignOnUserAccount());
            FrtCltLstVO frtCltLst = new FrtCltLstVO();
            frtCltLst.setBlNo((String) event.getAttribute("test_bl_no"));
            frtCltLst.setFrtCltFlg((String) event.getAttribute("test_foc"));
            frtCltLst.setEvntOfcCd((String) event.getAttribute("test_evnt_ofc_cd"));
            frtCltLst.setEvntUsrId((String) event.getAttribute("test_evnt_usr_id"));
            frtCltLst.setEvntDt((String) event.getAttribute("test_evnt_dt"));
            frtCltLst.setCgorTeamCd((String) event.getAttribute("test_cgor_team_cd"));
            frtCltLst.setCgoEvntNm((String) event.getAttribute("test_cgor_evnt_nm"));

            log.debug("-------------   FRT   ------------");
            log.debug(""+frtCltLst.getColumnValues());

            command.setupFocByFreight(frtCltLst);
            //DoPrnRmkVO doPrnRmkVO = event.getDoPrnRmkVO();
            //command.modifyDoPrnRmk(doPrnRmkVO, account);
            //eventResponse.setETCData("status", "ok");
            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
            commit();
        } catch(EventException ex) {
        	//ERP로 부터 들어오는 데이터는 EDI로 송신되지 않더라도 Freight값 자체는 생성되야 하므로
        	//rollback이 아니라 commit 이다.
        	commit();
            throw ex;
        }catch(Exception ex){
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * F.O.C 관련 Event 발생 시 관련 정보를 갱신하다.
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse setupFocByObl(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0909Event event = (EsmBkg0909Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try{
            begin();
            //DoRefVO[] doRefVOs = event.getDoRefVOs();
            //BkgCgoRlseVO[] bkgCgoRlseVOs = event.getBkgCgoRlseVOs();
            //String blNo = event.getBlNo();
            //command.manageUsCgoRlseTrans(doRefVOs,bkgCgoRlseVOs,this.getSignOnUserAccount());
            OblRdemVO oblRdem = new OblRdemVO();
            oblRdem.setBlNo((String) event.getAttribute("test_bl_no"));
            //oblRdem.setOblClrCd((String) event.getAttribute("test_foc"));
            oblRdem.setOblRdemFlg((String) event.getAttribute("test_foc"));
            oblRdem.setEvntOfcCd((String) event.getAttribute("test_evnt_ofc_cd"));
            oblRdem.setEvntUsrId((String) event.getAttribute("test_evnt_usr_id"));
            oblRdem.setEvntDt((String) event.getAttribute("test_evnt_dt"));
            oblRdem.setCgorTeamCd((String) event.getAttribute("test_cgor_team_cd"));
            oblRdem.setCgoEvntNm((String) event.getAttribute("test_cgor_evnt_nm"));

            log.debug("-------------   OBL   ------------");
            log.debug(""+oblRdem.getColumnValues());


            command.setupFocByObl(oblRdem);
            //DoPrnRmkVO doPrnRmkVO = event.getDoPrnRmkVO();
            //command.modifyDoPrnRmk(doPrnRmkVO, account);
            //eventResponse.setETCData("status", "ok");
            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            log.error("----------------err.toString [" + ex.toString()+"]", ex);
            log.error("----------------err.getMessage [" + ex.getMessage()+"]", ex);

//            if(ex.getMessage().indexOf("BKG40085") > -1){
//              throw new EventException(new ErrorHandler("BKG40085").getMessage(), ex);
//            }else if(ex.getMessage().indexOf("BKG40086") > -1){
//              throw new EventException(new ErrorHandler("BKG40086").getMessage(), ex);
//            }else if(ex.getMessage().indexOf("BKG40087") > -1){
//              throw new EventException(new ErrorHandler("BKG40087").getMessage(), ex);
//            }else{
//              throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
//            }
            throw ex;
        }catch(Exception ex){
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * [0909] F.O.C 관련 Event 발생 시 관련 정보를 갱신하다.
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse setupFocByCstms(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0909Event event = (EsmBkg0909Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try{
            begin();
            //DoRefVO[] doRefVOs = event.getDoRefVOs();
            //BkgCgoRlseVO[] bkgCgoRlseVOs = event.getBkgCgoRlseVOs();
            //String blNo = event.getBlNo();
            //command.manageUsCgoRlseTrans(doRefVOs,bkgCgoRlseVOs,this.getSignOnUserAccount());

            CstmsClrVO cstmsClr = new CstmsClrVO();
            cstmsClr.setBlNo((String) event.getAttribute("test_bl_no"));
            cstmsClr.setCstmsClrCd((String) event.getAttribute("test_foc"));
            cstmsClr.setEvntOfcCd((String) event.getAttribute("test_evnt_ofc_cd"));
            cstmsClr.setEvntUsrId((String) event.getAttribute("test_evnt_usr_id"));
            cstmsClr.setEvntDt((String) event.getAttribute("test_evnt_dt"));
            cstmsClr.setCgorTeamCd((String) event.getAttribute("test_cgor_team_cd"));
            cstmsClr.setCgoEvntNm((String) event.getAttribute("test_cgor_evnt_nm"));
            cstmsClr.setCstmsLocCd((String) event.getAttribute("test_cstms_loc_cd"));
            cstmsClr.setCstmsDsPoCd((String) event.getAttribute("test_cstms_ds_po_cd"));

            log.debug("-------------   CSTMS   ------------");
            log.debug(""+cstmsClr.getColumnValues());

            command.setupFocByCstms(cstmsClr);
            //DoPrnRmkVO doPrnRmkVO = event.getDoPrnRmkVO();
            //command.modifyDoPrnRmk(doPrnRmkVO, account);
            //eventResponse.setETCData("status", "ok");
            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        }catch(Exception ex){
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * [0909]Original Bill of Lading Status
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchUsCgoRlseBlStatus(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0909Event event = (EsmBkg0909Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            String bkgNo = event.getBkgNo();
            String blNo = event.getBlNo();
            //Container List
            eventResponse.setRsVoList(command.searchUsCgoRlseBlStatus(bkgNo,this.getSignOnUserAccount()));

            UsCgoRlseBkbcBlVO usCgoRlseBkbc = new UsCgoRlseBkbcBlVO();
            usCgoRlseBkbc.setBlNo(blNo);
            usCgoRlseBkbc = command.searchPrtlBl(usCgoRlseBkbc);
            if(Integer.parseInt(usCgoRlseBkbc.getPartialCnt()) == 0){
            	eventResponse.setETCData("prt_ind", "N" );
            }else if(Integer.parseInt(usCgoRlseBkbc.getPartialCnt()) > 0){
            	eventResponse.setETCData("prt_ind", "Y" );
            }

        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw ex;
            //throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * [0156] COD Application POD 변경시 CgoRlse Check
     * @param e
     * @return EventResponse
     * @exception EventException
     *
     */
    private EventResponse searchUsCgoRlseBlStatusChangePod(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0909Event event = (EsmBkg0909Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            String blNo = event.getBlNo();

            //Hold 여부 체크
            UsCgoRlseSearchVO searchVO = new UsCgoRlseSearchVO();
            searchVO.setBlNo(blNo);
            List<UsCgoRlseListVO> listVO = command.searchUsCgoRlseList(searchVO);

            if ( listVO.size() > 0 ) {
            	UsCgoRlseListVO usCgoRlseVO = listVO.get(0);
            	eventResponse.setETCData("do_hld_flg"  ,usCgoRlseVO.getDoHldFlg());

            	//CR 발송 여부 체크
            	List<UsCgoRlseListVO> listVO2 = command.searchUsCgoRlseView(blNo);

            	if ( listVO2.size() > 0 ) {
            		UsCgoRlseListVO usCgoRlseVO2 = listVO2.get(0);
            		eventResponse.setETCData("bkg_pod_cd"  ,usCgoRlseVO2.getBkgPodCd());
            		eventResponse.setETCData("bkg_pod_yd_cd"  ,usCgoRlseVO2.getBkgPodYdCd());
            		eventResponse.setETCData("cr_chk_flg"  ,"Y");
            	} else {
            		eventResponse.setETCData("bkg_pod_cd"  , "");
            		eventResponse.setETCData("bkg_pod_yd_cd"  , "");
            		eventResponse.setETCData("cr_chk_flg"  ,"N");
            	}
            } else {
            	eventResponse.setETCData("cr_chk_flg"  ,"N");
            }


        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0132 : 조회 이벤트 처리<br>
     * INQUIRY OF eDO 화면의 자가운송 event에 대한 특정 리스트 조회 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchEdoCntrRqstList(Event e) throws EventException {

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0132Event event = (EsmBkg0132Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try {
            List<EdoCntrRqstsVO> list = command.searchEdoCntrRqstList(event.getEdoSearchVO());
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
     * ESM_BKG_0680 : Cancel - D/O Release 내역을 삭제 처리한다.<br>
     * @param Event e
     * @return EventResponse
     * @exception EventException
     * @author Kim Gyoung Sub
     */
    private EventResponse cancelIdaDo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0680Event event = (EsmBkg0680Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            begin();
            IdaDoCancelVO idaDoCancelVo = new IdaDoCancelVO();
            idaDoCancelVo.setBkgNo(event.getBkgNo());

            command.cancelIdaDo(idaDoCancelVo, account);
            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00674").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

	/**
	 * India Cargo Release조회화면의 COMBO 값 조회 : UI_BKG_0680<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIdaDoDiscTmnlYdList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
        //EsmBkg0680Event event = (EsmBkg0680Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try {
			// Handling Status의 값 리스트 얻기
			List<BkgComboVO> combo_dsch_loc = command.searchIdaDoDiscTmnlYdList();

			eventResponse.setRsVoList(combo_dsch_loc);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * ESM_BKG_0128 : PSA EDI Transmit
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse transmitEdiPsaEdo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0128Event event = (EsmBkg0128Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            begin();

            PsaDoEdiTransVO psaDoEdiTrans = new PsaDoEdiTransVO();

            psaDoEdiTrans.setBkgNo(event.getBkgNo());
            psaDoEdiTrans.setAcount(account);
            psaDoEdiTrans.setCreUsrId(account.getUsr_id());
            psaDoEdiTrans.setUpdUsrId(account.getUsr_id());
            psaDoEdiTrans.setUsrId(account.getUsr_id());
            psaDoEdiTrans.setOfcCd(account.getOfc_cd());
            psaDoEdiTrans.setEventTp(event.getEventTp());

            command.transmitEdiPsaEdo(psaDoEdiTrans);

			// 성공메시지 셋팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0128 : PSA Amend Trasmit
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse transmitEdiPsaEdoAmend(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0128Event event = (EsmBkg0128Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            begin();
            if ("SG".equals(account.getCnt_cd())) {
				PsaDoEdiTransVO psaDoEdiTrans = new PsaDoEdiTransVO();

				psaDoEdiTrans.setBkgNo(event.getBkgNo());
				psaDoEdiTrans.setAcount(account);
				psaDoEdiTrans.setCreUsrId(account.getUsr_id());
				psaDoEdiTrans.setUpdUsrId(account.getUsr_id());
				psaDoEdiTrans.setUsrId(account.getUsr_id());
				psaDoEdiTrans.setOfcCd(account.getOfc_cd());
				psaDoEdiTrans.setEventTp(event.getEventTp());

				command.transmitEdiPsaEdo(psaDoEdiTrans);
			} else if ("SUBBA".equals(account.getOfc_cd())) {
				IdDoEdiTransVO idDoEdiTrans = new IdDoEdiTransVO();

				idDoEdiTrans.setBkgNo(event.getBkgNo());
				idDoEdiTrans.setAcount(account);
				idDoEdiTrans.setCreUsrId(account.getUsr_id());
				idDoEdiTrans.setUpdUsrId(account.getUsr_id());
				idDoEdiTrans.setUsrId(account.getUsr_id());
				idDoEdiTrans.setOfcCd(account.getOfc_cd());
				idDoEdiTrans.setEventTp(event.getEventTp());

				command.transmitEdiIdEdo(idDoEdiTrans);
			}

			// 성공메시지 셋팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0579 : EDI Result
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchPsaEdoAckLog(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0579Event event = (EsmBkg0579Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            begin();

            BkgPsaEdoAckSchVO bkgPsaEdoAckSchVO = new BkgPsaEdoAckSchVO();
            bkgPsaEdoAckSchVO.setBlNo(event.getBlNo());
            List<BkgPsaEdoAckSchVO> list = command.searchPsaEdoAckLog(bkgPsaEdoAckSchVO);
            eventResponse.setRsVoList(list);

            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * PSA 수신 MQ
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse receiptPsaEdoAck(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0128Event event = (EsmBkg0128Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
        	begin();
        	command.receiptPsaEdoAck(event.getBkgPsaEdoRcvLogVO());

        	commit();
        } catch(EventException ex) {
        	rollback();
        	throw ex;
        } catch(Exception ex) {
        	rollback();
        	log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * E-DO 요청 내역이 자가운송의 승인인 경우 냉동 화물 유무를 체크<br>
     *
     * @param e Event
     * @return response EventResponse
     * @throws EventException
     */
    private EventResponse searchEdoTrasnBlInfo(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0737Event event = (EsmBkg0737Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try {
        	EdoTransBlInfoVO edoTransBlInfoVO = command.searchEdoTrasnBlInfo(event.getBkgNo());

            if(edoTransBlInfoVO.getBkgNo().length() > 0){
            	eventResponse.setETCData("rc_flg", edoTransBlInfoVO.getRcFlg());
            	eventResponse.setETCData("cnt_nm", edoTransBlInfoVO.getCntNm());
    			eventResponse.setETCData("conti_nm", edoTransBlInfoVO.getContiNm());
    		}
            eventResponse.setRsVo(edoTransBlInfoVO);

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * BKG_EDO_MST 테이블이 조회 될 때 Review flag 를 업데이트 한다.<br>
     *
     * @param e Event
     * @return response EventResponse
     * @throws EventException
     */
    private EventResponse modifyEdoReviewFlag(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0133Event event = (EsmBkg0133Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try {
        	begin();
        	command.modifyEdoReviewFlag(event.getRqstNo(), event.getTpCd(), account.getUsr_id());
        	commit();
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * Pickup Date 및 Release Expire Date 항목 체크(EsmBkg0272)
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse checkEuFullRlseTransmitValid(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0272Event event = (EsmBkg0272Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{

            FullCntrRlseOrderEdiSendVO[] list = event.getFullCntrRlseOrderEdiSendVOs();
            command.checkEuFullRlseTransmitValid(list);

        } catch(EventException ex){
			eventResponse.setUserMessage(ex.getMessage());
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}

        return eventResponse;
    }

    /**
     * ESM_BKG_0132 : KT-NET을 통해 들어온 E-DO 요청(Incl. 자가운송, 보세운송동의서)에 대한 결과를 전송 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse transmitEdiBySelfTransEdo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0132Event event = (EsmBkg0132Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            begin();
            if(null != event.getEdoEdiTrans()){
                for(int idx = 0; idx<event.getEdoEdiTrans().length; idx++){
                    event.getEdoEdiTrans()[idx].setAcount(account);
                }
            }
            command.transmitEdiBySelfTransEdo(event.getEdoEdiTrans(), "EDO");
            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0132 : KT-NET을 통해 들어온 E-DO 요청(Incl. 자가운송, 보세운송동의서)에 대한 결과를 전송 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse transmitEdiByInbondTransEdo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0132Event event = (EsmBkg0132Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            begin();
            if(null != event.getEdoEdiTrans()){
                for(int idx = 0; idx<event.getEdoEdiTrans().length; idx++){
                    event.getEdoEdiTrans()[idx].setAcount(account);
                }
            }
            command.transmitEdiByInbondTransEdo(event.getEdoEdiTrans(), "EDO");
            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_1167 조회
     * Canada Cargo Release에 대한 List를 Item별로 조회한다.
     * @param e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCaCgoRlseList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1167Event event = (EsmBkg1167Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            CaCgoRlseSearchVO searchVO = event.getSearchVO();
            eventResponse.setRsVoList(command.searchCaCgoRlseList(searchVO));
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_1167 조회 Detail
     * Canada Cargo Release에 대한 List 조회 후,
     * 해당 B/L의 FOC 값 및 HOLD, Remark를 조회한다.
     * @param e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCaCgoRlseCntr(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1167Event event = (EsmBkg1167Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            String bkgNo = event.getBkgNo();
            eventResponse.setRsVoList(command.searchCaCgoRlseFoc(bkgNo));


        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw ex;
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_1167 ERP,DEM DET 정보 조회
     * @param e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCaErpOtsInfo(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1167Event event = (EsmBkg1167Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        String bkgNo = event.getBkgNo();
        String blNo = event.getBlNo();
        String podCd = event.getPodCd();

        try{
            //------------------------------------------------------
            //ERP
            //CURR 개수만큼 그룹지어서 합계.
            //------------------------------------------------------
            OtsRcvInfoVO oriVO = command.searchErpOtsInfo(blNo);

            Map<String,String> map = oriVO.getColumnValues();

            Map<String,Float> groupMap = new HashMap<String, Float>();
            Vector<String> vec = new Vector<String>();
            for(int i=0;i<5;i++){

                String currKey = map.get("tot_ots_curr_cd"+(i+1));
                //CURRENCY 가 없을경우 통과.
                if(map.get("tot_ots_curr_cd"+(i+1)) == null || map.get("tot_ots_curr_cd"+(i+1)).trim().equals("")){
                    continue;
                }
                String amtValue = map.get("tot_ots_amt"+(i+1));

                if(groupMap.containsKey(currKey)){//key값 존재시 합계
                    groupMap.put( currKey, Float.parseFloat(groupMap.get(currKey).toString())
                            + Float.parseFloat(amtValue));
                }else{
                    groupMap.put(currKey, Float.parseFloat(amtValue));
                    vec.add(currKey);
                }
            }

            //신용화주일경우 2010.04.01
            if(oriVO.getTotOtsStsCd() != null && oriVO.getTotOtsStsCd().equals("C")){
            	eventResponse.setETCData("otsCnt"  , "1");
                eventResponse.setETCData("ots0", "CREDIT");

            //비신용화주일경우   2010.04.01
            }else{
	            //값이 없거나, 0 이라도 USD 를 넣어준다.
	            if(vec.size() == 0){
	                eventResponse.setETCData("otsCnt"  , "1");
	                eventResponse.setETCData("ots0", ""+ " " + oriVO.getTotOtsAmt1() );
	                //eventResponse.setETCData("ots0", ""+ " " + "N/A" );
	            }else{
	                eventResponse.setETCData("otsCnt"  , ""+vec.size());
	                for(int x=0;x<vec.size();x++){
	                    eventResponse.setETCData("ots"+x, vec.get(x)+ " " +groupMap.get(vec.get(x)) );
	                }
	            }
            }

            //------------------------------------------------------
            //DEM DET Container 정보
            //------------------------------------------------------
            String[] demDetChargeInfo = null;

            demDetChargeInfo = command.searchDemDetCntrList(bkgNo);

            //------------------------------------------------------
            //Charge By Customer
            //outstanding 합계는 searchKorDo 참조.
            //status ; outstanding 합계가 0 이면 'Y' 아니면 'N'
            //------------------------------------------------------
            //ChargeCalculationBC ccBc = new ChargeCalculationBCImpl();
            ChargeByBookingCustomerParmVO chargeByBookingCustomerParmVO = new ChargeByBookingCustomerParmVO();
            chargeByBookingCustomerParmVO.setBkgNo(bkgNo);
            chargeByBookingCustomerParmVO.setPodCd(podCd);
            chargeByBookingCustomerParmVO.setCntrNo(demDetChargeInfo);
            chargeByBookingCustomerParmVO.setDmdtTp("");
            chargeByBookingCustomerParmVO.setExpDelDt("");


            //DEM/DET 에서 받아서 가공한 데이터
            DmtChargeVO dmtChargeVO = new DmtChargeVO();
            ChargeCalculationBC commandIF = new ChargeCalculationBCImpl(); //DEM.DET BC 선언
            BookingUtil bookingUtilBC = new BookingUtil();
            try {
                //dmtChargeVO = this.searchChargeByCustomer(chargeByBookingCustomerParmVO);
                ChargeByBookingCustomerGrpVO chargeByBookingCustomerGrpVO;
                chargeByBookingCustomerGrpVO = commandIF.searchChargeByCustomer(chargeByBookingCustomerParmVO);
                dmtChargeVO = bookingUtilBC.searchChargeByCustomer(chargeByBookingCustomerGrpVO);
            } catch (Exception ex) {
            	log.warn("warring : " + ex.toString(), ex);
            	log.error(ex.getMessage()); // 2011.07.15

            }
            //grpVO의 값이 Null이 아닌경우에 대해서만 처리함
            if (dmtChargeVO != null) {
                //log.debug("------------------- gMap "+cntrVO.getBzcTrfCurrCd() + " "+ gMap.get(cntrVO.getBzcTrfCurrCd()));
                List<ToTBilAmtVO> totBilAmtVOList = dmtChargeVO.getBilAmtVOList();

                ToTBilAmtVO totBilAmtVO;
                String currCd = "";
                String demAmt = "";
                float demAmtTmp = 0;
                String demType = "";

                if(totBilAmtVOList != null && totBilAmtVOList.size() > 0){
                	log.debug("---------- totBilAmtVOList.size() "+totBilAmtVOList.size());
                    totBilAmtVO = totBilAmtVOList.get(0);
                    currCd = totBilAmtVO.getCurrCd();
                    demAmt = totBilAmtVO.getTotBilAmt();
                    demAmtTmp = Float.parseFloat(demAmt);
                    demType = dmtChargeVO.getDemurType();
                }

                eventResponse.setETCData("demAMT"  , currCd + " "+ demAmt);

                if(demAmtTmp > 0){
                    eventResponse.setETCData("demStatus"  , "N");
                }else{
                    eventResponse.setETCData("demStatus"  , "Y");
                }
                eventResponse.setETCData("demurType"  , demType);
            } else {
                //grpVO의 값이 Null인 경우에 대해서만 처리함
                eventResponse.setETCData("demAMT"     , "");
                eventResponse.setETCData("demStatus"  , "");
                eventResponse.setETCData("demurType"  , "");
            }

            //------------------------------------------------------
            //TPB 구하기
            //------------------------------------------------------
            StatusInquiryBC tpbIF = new StatusInquiryBCImpl(); //TPB BC 선언
            SearchTPBStatusByBkgNoVO searchTpbStatusByBkgNoVO = new SearchTPBStatusByBkgNoVO();
            searchTpbStatusByBkgNoVO.setSbkgno(event.getBkgNo());
            String tpbStatus = tpbIF.searchTpbStatusByBkgNo(searchTpbStatusByBkgNoVO);
            log.debug("---------- tpbStatus     "+tpbStatus);
            eventResponse.setETCData("tpbStatus"  , tpbStatus);

        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw ex;
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_1167 Original Bill of Lading Status
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchCaCgoRlseBlStatus(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1167Event event = (EsmBkg1167Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
            String bkgNo = event.getBkgNo();
            String blNo = event.getBlNo();
            //Container List
            eventResponse.setRsVoList(command.searchCaCgoRlseBlStatus(bkgNo,this.getSignOnUserAccount()));

            CaCgoRlseBkbcBlVO caCgoRlseBkbc = new CaCgoRlseBkbcBlVO();
            caCgoRlseBkbc.setBlNo(blNo);
            caCgoRlseBkbc = command.searchCaPrtlBl(caCgoRlseBkbc);
            if(Integer.parseInt(caCgoRlseBkbc.getPartialCnt()) == 0){
            	eventResponse.setETCData("prt_ind", "N" );
            }else if(Integer.parseInt(caCgoRlseBkbc.getPartialCnt()) > 0){
            	eventResponse.setETCData("prt_ind", "Y" );
            }

        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw ex;
        }catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_1167 Remark 저장
     *
     * @param e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageCaCgoHldRmk(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1167Event event = (EsmBkg1167Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try{
            begin();
            DoRefVO[] doRefVOs = event.getDoRefVOs();

            BkgDoRefVO bkgDoRefVO = new BkgDoRefVO();

            ObjectCloner.build(doRefVOs[0], bkgDoRefVO);
            bkgDoRefVO.setCreUsrId(this.getSignOnUserAccount().getUsr_id());
            bkgDoRefVO.setUpdUsrId(this.getSignOnUserAccount().getUsr_id());
            //String blNo = event.getBlNo();
            command.manageDoHldRmk(bkgDoRefVO);

            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_1167 save 저장
     * Canada Cargo Release에서 F.O.C 변경 내역에 대한 저장을 수행한다.
     * @param e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageCaCgoRlse(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1167Event event = (EsmBkg1167Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        BLIssuanceBC command2 = new BLIssuanceBCImpl();
        try{
            begin();
            BkgCgoRlseVO[] bkgCgoRlseVOs = event.getBkgCgoRlseVOs();
            BkgBlIssVO[] blIssVOs = event.getBlIssVOs();

            // OBL 저장은 US 와 CA 동일
            //1.Obl 저장
            if(blIssVOs != null){
            	command2.manageOblRcvByUsCgo(blIssVOs, this.getSignOnUserAccount());
            }
            //2. Remark 저장
            if(bkgCgoRlseVOs != null){
            	command.manageCaCgoRlse(bkgCgoRlseVOs[0],this.getSignOnUserAccount());
            }

            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.\
           	eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());

            commit();
        } catch(EventException ex) {

            if(ex.getMessage().indexOf("BKG40085") > -1){
                commit();
                throw new EventException(new ErrorHandler("BKG40085").getMessage());

            }else if(ex.getMessage().indexOf("BKG40086") > -1){
                commit();
              throw new EventException(new ErrorHandler("BKG40086").getMessage());
            }else if(ex.getMessage().indexOf("BKG40087") > -1){
                commit();
              throw new EventException(new ErrorHandler("BKG40087").getMessage());
            }else if(ex.getMessage().indexOf("BKG40108") > -1){
                commit();
              throw new EventException(new ErrorHandler("BKG40108").getMessage());
            }else{
                rollback();
                throw ex;
            }

        }catch(Exception ex){
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_1167 hold 저장
     *
     * @param e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageCaCgoRlseHold(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1167Event event = (EsmBkg1167Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        try{
            begin();
            DoRefVO[] vos = event.getDoRefVOs();
            command.manageCaCgoRlseHold(vos,this.getSignOnUserAccount());
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }



    /**
     * release notes 칼럼에 Update 항목이 보여야하는 오피스를 가져온다. ESM_BKG_0272
     *
     * @param e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchOfcFullCntrRlseOrdBracUpdFlg(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0272Event event = (EsmBkg0272Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{
        	String updOfcFlg = command.searchOfcFullCntrRlseOrdBracUpdFlg(event.getSignOnUserAccount().getOfc_cd());
            eventResponse.setETCData("upd_ofc_flg", ""+updOfcFlg);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
	 * 1177   DO validity upto history 조회
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDoVtyUptoDthis(Event e) throws EventException
    {
        // TODO Auto-generated method stub
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try
        {
            EsmBkg1177Event event = (EsmBkg1177Event )e;
            CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
            List<DoVtyDtUpdHisVO> list = new ArrayList<DoVtyDtUpdHisVO>();

            DoVtyDtUpdHisVO doVtyDtUpdHisVO = event.getDoVtyDtUpdHisVO();
           list = command.searchDoVtyUptoDthis(doVtyDtUpdHisVO.getBkgNo());
           eventResponse.setRsVoList(list);

            if(list != null)
            {
            	eventResponse.setETCData("status", "ok");
            }
            else
            {
            	eventResponse.setETCData("status", "no_data");
            }

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
	 * 1515	EDI Setup 조회
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEdiSetupList(Event e) throws EventException
    {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1515Event event = (EsmBkg1515Event) e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{

        	EdiYardInfoVO searchVO = event.getEdiYardInfoVO();
            List<EdiYardInfoVO> ediYardInfoVO = command.searchEdiSetupList(searchVO);
            eventResponse.setRsVoList(ediYardInfoVO);

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
	 * 1515	EDI Setup 저장
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEdiSetup(Event e) throws EventException
    {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1515Event event = (EsmBkg1515Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{

            begin();
        	EdiYardInfoVO[] searchVO = event.getEdiYardInfoVOs();
            command.manageEdiSetup(searchVO,account);
            commit();

        } catch(EventException ex) {
            throw ex;

        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }



    /**
	 * 1515	EDI Setup 조회
	 * @param e
	 * @return searchEdiSetupList
	 * @exception EventException
	 */
	private EventResponse searchEdiSetupHistoryList(Event e) throws EventException
    {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1515Event event = (EsmBkg1515Event) e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

        try{

        	EdiYardInfoVO searchVO = event.getEdiYardInfoVO();
            List<EdiYardInfoVO> ediYardInfoVO = command.searchEdiSetupHistoryList(searchVO);
            eventResponse.setRsVoList(ediYardInfoVO);

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0326 : 메일 전송 이벤트 처리<br>
     * India_Cargo Release Order의 D/O Receiver Setting을 저장 후 메일 전송한다.<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse sendIndiaDoByEmail(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0936Event event = (EsmBkg0936Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        BookingHistoryMgtBC hisBC = new BookingHistoryMgtBCImpl();

        List<BkgNtcHisVO> hisVOS = new ArrayList<BkgNtcHisVO>();
        try{
            begin();
            String uiId = "ESM_BKG_0936";
            HashMap mailMap = new HashMap<String,String>();
            DoRcvrVO doRcvrVO = event.getDoRcvrVO();

            IndiaDoNtcSendVO indiaDoNtcSendVO = new IndiaDoNtcSendVO();
            indiaDoNtcSendVO.setBkgNo    (doRcvrVO.getBkgNo    ());
            indiaDoNtcSendVO.setDoNo     (doRcvrVO.getDoNo     ());
            indiaDoNtcSendVO.setDoNoSplit(doRcvrVO.getDoNoSplit());
            indiaDoNtcSendVO.setInDoOdcyAddrCd(doRcvrVO.getInDoOdcyAddrCd());
            indiaDoNtcSendVO.setEvntDt(doRcvrVO.getEvntDt());
            indiaDoNtcSendVO.setAtchSveyLtrFlg(doRcvrVO.getAtchSveyLtrFlg());

            if (!CheckUtils.isNullAndNullString(doRcvrVO.getRcvrEml())){
            	indiaDoNtcSendVO.setRcvrCd("CU");
	            indiaDoNtcSendVO.setNtcEml   (doRcvrVO.getRcvrEml());
	            indiaDoNtcSendVO.setCustNm   ("B/L Customer");

	           	IndiaDoNtcSendVO reIndiaDoNtcSendVO = command.sendIndiaDoByEmail(indiaDoNtcSendVO, account);

	           	mailMap.put(doRcvrVO.getRcvrEml(),"Y");

	           	//@ 이력 VO세팅 **********************************
				BkgNtcHisVO hisVO = new BkgNtcHisVO();
				hisVO.setBkgNo(indiaDoNtcSendVO.getBkgNo());
				hisVO.setNtcKndCd("DO");
				hisVO.setNtcViaCd("M");
				hisVO.setCustCntcTpCd("CU");// Customer E-mail
				hisVO.setNtcEml(indiaDoNtcSendVO.getNtcEml());
				hisVO.setSndId(reIndiaDoNtcSendVO.getSndId());
				hisVO.setSndOfcCd(account.getOfc_cd());
				hisVO.setSndUsrId(account.getUsr_id());
				hisVO.setCreUsrId(account.getUsr_id());
				hisVO.setUpdUsrId(account.getUsr_id());
				hisVOS.add(hisVO);
				//************************************************



            }

            //@ 같은 메일 주소면 중복 전송 하지 않음.
            if (!CheckUtils.isNullAndNullString(doRcvrVO.getCfsEml()) && mailMap.get(doRcvrVO.getCfsEml()) == null ){
            	indiaDoNtcSendVO.setRcvrCd("CFS");
            	indiaDoNtcSendVO.setNtcEml   (doRcvrVO.getCfsEml());
            	indiaDoNtcSendVO.setCustNm   ("CFS");

            	IndiaDoNtcSendVO reIndiaDoNtcSendVO = command.sendIndiaDoByEmail(indiaDoNtcSendVO, account);

            	mailMap.put(doRcvrVO.getCfsEml(),"Y");

	           	//@ 이력 VO세팅 **********************************
				BkgNtcHisVO hisVO = new BkgNtcHisVO();
				hisVO.setBkgNo(indiaDoNtcSendVO.getBkgNo());
				hisVO.setNtcKndCd("DO");
				hisVO.setNtcViaCd("M");
				hisVO.setCustCntcTpCd("CF");// Customer E-mail
				hisVO.setNtcEml(indiaDoNtcSendVO.getNtcEml());
				hisVO.setSndId(reIndiaDoNtcSendVO.getSndId());
				hisVO.setSndOfcCd(account.getOfc_cd());
				hisVO.setSndUsrId(account.getUsr_id());
				hisVO.setCreUsrId(account.getUsr_id());
				hisVO.setUpdUsrId(account.getUsr_id());
				hisVOS.add(hisVO);
				//************************************************
            }

            //@ 같은 메일 주소면 중복 전송 하지 않음.
            if (!CheckUtils.isNullAndNullString(doRcvrVO.getMtyYdEml()) && mailMap.get(doRcvrVO.getMtyYdEml()) == null ){
            	indiaDoNtcSendVO.setRcvrCd("MT");
            	indiaDoNtcSendVO.setNtcEml   (doRcvrVO.getMtyYdEml());
            	indiaDoNtcSendVO.setCustNm   ("Empty Yard");

            	IndiaDoNtcSendVO reIndiaDoNtcSendVO = command.sendIndiaDoByEmail(indiaDoNtcSendVO, account);

	           	//@ 이력 VO세팅 **********************************
				BkgNtcHisVO hisVO = new BkgNtcHisVO();
				hisVO.setBkgNo(indiaDoNtcSendVO.getBkgNo());
				hisVO.setNtcKndCd("DO");
				hisVO.setNtcViaCd("M");
				hisVO.setCustCntcTpCd("MT");// Customer E-mail
				hisVO.setNtcEml(indiaDoNtcSendVO.getNtcEml());
				hisVO.setSndId(reIndiaDoNtcSendVO.getSndId());
				hisVO.setSndOfcCd(account.getOfc_cd());
				hisVO.setSndUsrId(account.getUsr_id());
				hisVO.setCreUsrId(account.getUsr_id());
				hisVO.setUpdUsrId(account.getUsr_id());
				hisVOS.add(hisVO);
				//************************************************
            }

            if(hisVOS != null){
            	hisBC.createBkgNtcHis(hisVOS, uiId);
            }

            log.debug("===================================================");
            log.debug("    India_Cargo Release Order의 D/O Receiver 저장   ");
            log.debug("===================================================");
            command.setupIdaDoRcvrInfo(doRcvrVO, account);

            eventResponse.setUserMessage(new ErrorHandler("BKG40054").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            //COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("BKG00243").getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * WEB B/L Printed : Serial Number 조회
     * WEB B/L Printed : Serial Number
     * @param e Event
     * @return void
     * @exception EventException
     */
	private EventResponse searchOblInterSerNoCheckInfo(Event e) throws EventException {
        UsCgoRlseListVO searchVO;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0909Event event = (EsmBkg0909Event)e;
        CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
        String bkgNo = event.getBkgNo();

		try {
			searchVO = command.searchOblInterSerNoCheckInfo(bkgNo);
	        eventResponse.setETCData("oblInterSerNo", searchVO.getOblInterSerNo());
	        eventResponse.setETCData("oblInterSerNoChkUsrId", searchVO.getOblInterSerNoChkUsrId());
	        eventResponse.setETCData("oblInterSerNoChkDt", searchVO.getOblInterSerNoChkDt());
		} catch (EventException ex) {
            log.error("err " + ex.toString(), ex);
            // COM12240 : Unexpected system error took place during data processing. Please try again later.
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
    }

    /*
    * WEB B/L Printed Checked
    *
    * @param e Event
    * @return response EventResponse
    * @exception EventException
    */
   private EventResponse manageOblInterSerNoCheck(Event e) throws EventException {
       GeneralEventResponse eventResponse = new GeneralEventResponse();
       EsmBkg0909Event event = (EsmBkg0909Event)e;
       CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
       String bkgNo = event.getBkgNo();
       try{
           begin();
           command.manageOblInterSerNoCheck(bkgNo, account);
           eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
           commit();
       } catch(EventException ex) {
           rollback();
           throw ex;
       } catch(Exception ex) {
           rollback();
           log.error("err " + ex.toString(), ex);
           //COM12240 : Unexpected system error took place during data processing. Please try again later.
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
       }
       return eventResponse;
   }

   /**
    * ESM_BKG_0684 조회 이벤트 처리<br>
    * Bd Cargo Release (D/O)의 event에 대한 특정 리스트 조회 이벤트 처리<br>
    *
    * @param e Event
    * @return response EventResponse
    * @exception EventException
    */
   private EventResponse searchBdDo(Event e) throws EventException {
       GeneralEventResponse eventResponse = new GeneralEventResponse();

       EsmBkg0684Event event = (EsmBkg0684Event)e;
       CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

       BookingUtil bookingUtilBC = new BookingUtil();

       try {
           //BKG_NO가 없을 경우 BL NO로 조회 해 온다.
           if("".equals(event.getBkgNo()) || null == event.getBkgNo()){
               String bkgNo = bookingUtilBC.searchBkgNoByBlNo(event.getBlNo());
               if(! "".equals(bkgNo)){
                   event.setBkgNo(bkgNo);
               }else{
                   String[] msg = new String[]{event.getBlNo()};
                   throw new EventException(new ErrorHandler("BKG40031", msg).getMessage());
               }
           }

           EuDoMstVO euDoMst = command.searchBdDo(event.getBkgNo(), account);

           DmtChargeVO dmtChargeVo = new DmtChargeVO();

           String tpbStatus = ""; //TPB Status

         //DEM/DET 에서 받아서 가공한 데이터
           if(euDoMst.getBlInfo() != null){

           	  dmtChargeVo = this.searchDemDetChargeInfo(event.getBkgNo(),euDoMst.getBlInfo().getPodCd(),event.getDemurType(),event.getExpDelDt());

                 StatusInquiryBC tpbIF = new StatusInquiryBCImpl(); //TPB BC 선언
                 SearchTPBStatusByBkgNoVO searchTpbStatusByBkgNoVO = new SearchTPBStatusByBkgNoVO();
                 searchTpbStatusByBkgNoVO.setSbkgno(event.getBkgNo());
                 tpbStatus = tpbIF.searchTpbStatusByBkgNo(searchTpbStatusByBkgNoVO);
           }
           //EU D/O Release 기본 정보 추출
           eventResponse.setRsVo(euDoMst.getBlInfo());

           //EU D/O Release 기본 Reference 정보 추출
           eventResponse.setRsVo(euDoMst.getBkgDoRefVO());

           //EU 세관 신고를 위한 B/L INFO 추출
           eventResponse.setRsVo(euDoMst.getEuCstms());

           //Container별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보를 추출
           eventResponse.setRsVoList(euDoMst.getEuDoCntrRlseStsVOs());

           //B/L별 D/O의 STATUS(ASSIGN, RELEASE, ISSUE)별 상세 정보 추출
           eventResponse.setRsVoList(euDoMst.getEuDoRlseStsVOs());

           //조회된 시점에 조회된 Original B/L 회수 여부와 발행 통수 및  Detail정보 추출
           eventResponse.setRsVo(euDoMst.getBlIss());

           //운임 결재 여부와 Outstanding Amounts 정보 추출
           eventResponse.setRsVo(euDoMst.getOtsRcvInfoVO());
           eventResponse.setRsVoList(dmtChargeVo.getChargeByBookingCustomerCntrVOS());
           eventResponse.setRsVoList(dmtChargeVo.getChargeByBookingCustomerInvVOS());
           eventResponse.setRsVoList(dmtChargeVo.getBilAmtVOList());

           //ETC DATA 처리
           eventResponse.setETCData("demurType"  , dmtChargeVo.getDemurType());
           eventResponse.setETCData("tpbStatus"  , tpbStatus);
           //SplitFlg를 추출
           eventResponse.setETCData("splitFlg", euDoMst.getSplitFlg());
           //D/O No가 Split Assign되지 않은 Container의 수량 추출
           eventResponse.setETCData("remainCntrCnt", Integer.toString(euDoMst.getCntrCnt()));
           eventResponse.setETCData("mrdId"       , JSPUtil.getNull(euDoMst.getMrdId(), ""));
           eventResponse.setETCData("localLangFlg", JSPUtil.getNull(euDoMst.getLocalLangFlg(), ""));

       } catch(EventException ex) {
           throw ex;
       } catch(Exception ex) {
           log.error("err " + ex.toString(), ex);
           // COM12240 : Unexpected system error took place during data processing. Please try again later.
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
       }
       return eventResponse;
   }

   /**
    * ESM_BKG_0684 : 단건 입력 이벤트 처리<br>
    * Bd Cargo Release (D/O)의 event의 event에 대한 단건 입력 이벤트 처리<br>
    *
    * @param e Event
    * @return response EventResponse
    * @exception EventException
    */
   private EventResponse manageBdDo(Event e) throws EventException {
       // PDTO(Data Transfer Object including Parameters)
       GeneralEventResponse eventResponse = new GeneralEventResponse();
       EsmBkg0684Event event = (EsmBkg0684Event)e;
       CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
       //타 모듈 인터페이스 호출
       BLIssuanceBC bLIssuanceBC = new BLIssuanceBCImpl();

       try{
           begin();
           if(null != event.getEuDoSave()){
               log.debug("=======================================");
               log.debug("    manageBdDo 호출");
               log.debug("=======================================");

               //세션 정보 세팅하기
               event.getEuDoSave().setUserId(account.getUsr_id());
               event.getEuDoSave().setAcount(account);
               event.getEuDoSave().setOblCngFlg(event.getOblCngFlg());
               event.getEuDoSave().setDoCngEvntCd(event.getDoCngEvntCd());

               command.manageBdDo(event.getEuDoSave());
           }

           if(null != event.getBlIssVOs() && "U".equals(event.getBlIssVOs()[0].getIbflag())){
               log.debug("=======================================");
               log.debug("    manageOBLIssue 호출                ");
               log.debug("=======================================");
               //Original Bill of Lading Status 변경 값을 세팅한다.
               event.getBlIssVOs()[0].setBkgNo(event.getBkgNo());
               event.getBlIssVOs()[0].setOblIssOfcCd(account.getOfc_cd());
               event.getBlIssVOs()[0].setOblIssUsrId(account.getUsr_id());
               event.getBlIssVOs()[0].setOblRdemOfcCd(account.getOfc_cd());
               event.getBlIssVOs()[0].setOblRdemUsrId(account.getUsr_id());
               event.getBlIssVOs()[0].setOtrDocRcvOfcCd(account.getOfc_cd());
               event.getBlIssVOs()[0].setOtrDocRcvUsrId(account.getUsr_id());
               event.getBlIssVOs()[0].setCreUsrId(account.getUsr_id());
               event.getBlIssVOs()[0].setUpdUsrId(account.getUsr_id());

               //IbdDocRcv관련 정보를 세팅한다.
               event.getBlIssVOs()[0].setIbdDocRcvOfcCd(account.getOfc_cd());
               event.getBlIssVOs()[0].setIbdDocRcvUsrId(account.getUsr_id());

               bLIssuanceBC.manageOblRcv(event.getBlIssVOs()[0]);
           }

           //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
           eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
           commit();
       } catch(EventException ex) {
           rollback();
           throw ex;
       } catch(Exception ex) {
           rollback();
           log.error("err " + ex.toString(), ex);
           //COM12240 : Unexpected system error took place during data processing. Please try again later.
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
       }
       return eventResponse;
   }

   /**
    * ESM_BKG_0684 : 대상 B/L에 대해 Release 작업을 수행한다.<br>
    *
    * @param e Event
    * @return response EventResponse
    * @exception EventException
    */
   private EventResponse releaseBdDo(Event e) throws EventException {
       // PDTO(Data Transfer Object including Parameters)
       GeneralEventResponse eventResponse = new GeneralEventResponse();
       EsmBkg0684Event event = (EsmBkg0684Event)e;
       CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
       //타 모듈 인터페이스 호출

       try{
           begin();
           event.getEuDoRlse().setUsrId(account.getUsr_id());
           event.getEuDoRlse().setUsrOfcCd(account.getOfc_cd());
           command.releaseBdDo(event.getEuDoRlse(), event.getDoCntrs());
           //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
           eventResponse.setUserMessage(new ErrorHandler("BKG00669").getUserMessage());
           commit();
       } catch(EventException ex) {
           rollback();
           throw ex;
       } catch(Exception ex) {
           rollback();
           log.error("err " + ex.toString(), ex);
           //COM12240 : Unexpected system error took place during data processing. Please try again later.
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
       }
       return eventResponse;
   }

   /**
    * ESM_BKG_0684 :  EU D/O대상 B/L에 대한 Assign 혹은 Release Staus를 Cancel한다.<br>
    *
    * @param e Event
    * @return response EventResponse
    * @exception EventException
    * @author An Jineung
    */
   private EventResponse cancelBdDo(Event e) throws EventException {
       // PDTO(Data Transfer Object including Parameters)
       GeneralEventResponse eventResponse = new GeneralEventResponse();


       EsmBkg0684Event event = (EsmBkg0684Event)e;

       event.getDoCancel().setCreUsrId(account.getUsr_id());
       event.getDoCancel().setUpdUsrId(account.getUsr_id());
       event.getDoCancel().setEvntOfcCd(account.getOfc_cd());

       CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

       try{
           begin();
           command.cancelBdDo(event.getDoCancel(), account);
           //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
           eventResponse.setUserMessage(new ErrorHandler("BKG00674").getUserMessage());
           commit();
       } catch(EventException ex) {
           rollback();
           throw ex;
       } catch(Exception ex) {
           rollback();
           log.error("err " + ex.toString(), ex);
           //COM12240 : Unexpected system error took place during data processing. Please try again later.
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
       }
       return eventResponse;
   }

	/**
	 * ESM_BKG_0128 : Indonesia Surabaya EDI Transmit
	 * 
	 * @param e
	 *            Event
	 * @return eventResponse EventResponse
	 * @throws EventException
	 */
	private EventResponse transmitEdiSubbaEdo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0128Event event = (EsmBkg0128Event) e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try {
			begin();

			IdDoEdiTransVO idDoEdiTrans = new IdDoEdiTransVO();

			idDoEdiTrans.setBkgNo(event.getBkgNo());
			idDoEdiTrans.setAcount(account);
			idDoEdiTrans.setCreUsrId(account.getUsr_id());
			idDoEdiTrans.setUpdUsrId(account.getUsr_id());
			idDoEdiTrans.setUsrId(account.getUsr_id());
			idDoEdiTrans.setOfcCd(account.getOfc_cd());
			idDoEdiTrans.setEventTp(event.getEventTp());

			command.transmitEdiIdEdo(idDoEdiTrans);

			eventResponse.setUserMessage(new ErrorHandler("BKG00204")
					.getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),
					ex);
		}
		return eventResponse;
	}
}