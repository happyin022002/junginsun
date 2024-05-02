/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InboundNoticeMgtSC.java
*@FileTitle : Arrival Notice Form Setting tab#1
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier :
*@LastVersion : 1.0
* 2009.04.28 박만건
* 1.0 Creation
* 2013.02.19 김진주 [CHM-201322860] Customer Code Error Report 보완 요청
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.MdmCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.ArrivalNoticeBC;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.ArrivalNoticeBCImpl;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.HoldNoticeBC;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.HoldNoticeBCImpl;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.PickUpNoticeBC;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.PickUpNoticeBCImpl;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0001Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0052Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0240Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0242Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0243Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0244Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0375Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0381Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0411Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0414Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0510Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0511Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0672Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0760Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0764Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0941Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0946Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0948Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0956Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0992Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0993Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1002Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1020Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1021Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1034Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1044Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg105499Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1054Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1058Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1063Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1064Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1066Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1067Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1068Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1099Event;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustCodeErrListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustRefVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustUploadListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcGrpSendListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcGrpSendVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcInfoListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcMrdSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcMrdVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSendListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcWdVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.BkgArrNtcAntfyVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.BkgNtcSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ConfirmHldNtcSendListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustCdEvaluationVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustCdValidationVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.HoldNoticeFormVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.IbCustCntcHisVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.IbCustCntcVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MrnRtnYdVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.NoticeVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNoMnlUpldVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNoRptVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNoVerifyVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcFormVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcManualListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcSendListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcSentHisListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcSentHisSchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PreHldNtcSendListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.TpbInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBC;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBCImpl;
import com.hanjin.apps.alps.esm.bkg.servicesio.InboundDocumentationProxy;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.CheckUtils;
import com.hanjin.framework.component.util.code.CodeInfo;
import com.hanjin.framework.component.util.code.CodeUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.table.ComBakEndJbVO;
import com.hanjin.syscommon.common.table.BkgArrNtcCntrVO;
import com.hanjin.syscommon.common.table.BkgArrNtcDtlVO;
import com.hanjin.syscommon.common.table.BkgArrNtcWdDtlVO;
import com.hanjin.syscommon.common.table.BkgArrNtcWdVO;
import com.hanjin.syscommon.common.table.BkgCustTmpltVO;
import com.hanjin.syscommon.common.table.BkgHldNtcUsrVO;
import com.hanjin.syscommon.common.table.BkgHldWdVO;
import com.hanjin.syscommon.common.table.BkgIbCmdtCntcVO;
import com.hanjin.syscommon.common.table.BkgIbCustCntcStupVO;
import com.hanjin.syscommon.common.table.BkgIbCustCntcVO;
import com.hanjin.syscommon.common.table.BkgMdmCrCustVO;
import com.hanjin.syscommon.common.table.BkgNtcHisVO;
import com.hanjin.syscommon.common.table.BkgPkupCntrRtnYdVO;
import com.hanjin.syscommon.common.table.BkgPkupNtcPkupNoHisVO;
import com.hanjin.syscommon.common.table.BkgTroActCustVO;
import com.hanjin.syscommon.common.table.BkgVvdVO;
import com.hanjin.syscommon.common.table.MasBkgComIfVO;


/**
 * ALPS-InboundBLMgt Business Logic ServiceCommand - ALPS-InboundBLMgt 대한 비지니스 트랜잭션을 처리한다.
 *
 * @author Park Mangeon
 * @see InboundNoticeDBDAO
 * @since J2EE 1.4
 */

public class InboundNoticeMgtSC extends ServiceCommandSupport {
    // Login User Information
    protected SignOnUserAccount account = null;

    /**
     * InboundBLMgt system 업무 시나리오 선행작업<br>
     * Inbound 업무 시나리오 호출시 관련 내부객체 생성<br>
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
     * InboundBLMgt system 업무 시나리오 마감작업<br>
     * Inbound 업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        log.debug("InboundNoticeMgtSC 종료");

    }

    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * ALPS-InboundBLMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        // RDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = null;
        //log.debug("Proxy-------------------------- AAAA");
        //long startTime = System.currentTimeMillis();
        //log.debug("Proxy-------------------------- e.getEventName()   "+e.getEventName());


        // SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
        if (e.getEventName().equalsIgnoreCase("EsmBkg0375Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//그냥 검색
                eventResponse = searchArrNtcForm(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {//Pod cd
                eventResponse = searchArrNtcFormPodList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {//Agent
                eventResponse = searchArrNtcFormAgentList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = setupArrNtcForm(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
                eventResponse = removeArrNtcForm(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg0001Event")) {  // Notice Sent History
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchBkgNtcHis(e);
        	}
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg0411Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchPkupNtcForm(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchPkupNtcFormDelList(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = setupPkupNtcForm (e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = removePkupNtcForm (e);
            }

        } else if (e.getEventName().equalsIgnoreCase("EsmBkg0760Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHldNtcConfirmForm(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = setupHldNtcConfirmForm(e);
			}
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg1066Event")) {
            if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = modifyPkupNtcSendList (e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchPkupNtcSendList(e);
            }
            // Send Fax
            else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = sendPkupNtcByFax(e);
            }
            // Send Email
            else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
                eventResponse = sendPkupNtcByEmail(e);
            }
            // Stop Send
            else if (e.getFormCommand().isCommand(FormCommand.MULTI11)) {
                eventResponse = stopPkupNtcSend(e);
            }
            // Resume Send
            else if (e.getFormCommand().isCommand(FormCommand.MULTI12)) {
                eventResponse = resumePkupNtcSend(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.MULTI20)) {
                eventResponse = verifyPkupNtcList(e);
            }

        } else if (e.getEventName().equalsIgnoreCase("EsmBkg0511Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchHldNtcFormPodList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHldNtcPreForm(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = setupHldNtcPreForm(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeHldNtcForm(e);
			}

        } else if (e.getEventName().equalsIgnoreCase("EsmBkg1058Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPkupMtRtnCy(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = setupPkupMtRtnCy(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkPkupMtRtnCy(e);
			}

        } else if (e.getEventName().equalsIgnoreCase("EsmBkg0992Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkPkupNtcFormExist(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = copyPkupNtcForm(e);
			}

        } else if (e.getEventName().equalsIgnoreCase("EsmBkg0993Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchPkupNtcListByManual(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = setupPkupNtcListByManual(e);
            }

        } else if (e.getEventName().equalsIgnoreCase("EsmBkg0948Event")) {
    		/* 화면 조회하기 */
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchHldNtcUsr(e);
            }
    		/* 저장하기 */
            else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = setupHldNtcUsr(e);
            }
    		/* Location Code 유효성 체크 */
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = validateLoc(e);
            }
    		/* Hold Code 조회하기 */
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH02))
            {
                eventResponse = searchHldNtcCode(e);
            }
        }else if (e.getEventName().equalsIgnoreCase("EsmBkg0240Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {//Customer Main (MDM)
                eventResponse = searchIntgCustCntcInfo(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {//Detail IB
                //log.debug("==========================================1");
                eventResponse = this.searchIntgCustCntcInfoByIB(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {//Save
                //log.debug("==========================================1");
                eventResponse = this.manageIntgCustCntcInfoByIB(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {//Detail OB
                //log.debug("==========================================1");
                eventResponse = this.searchIntgCustCntcInfoByOB(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {//Detail Invoice
                //log.debug("==========================================1");
                eventResponse = this.searchIntgCustCntcInfoByInvoice(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {//Detail TRO
                //log.debug("==========================================1");
                eventResponse = this.searchIntgCustCntcInfoByTRO(e);
            }
            //공통코드 코드+명칭 테이블
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
				eventResponse = this.searchComCodeDescList(e);
			}

        }else if (e.getEventName().equalsIgnoreCase("EsmBkg0242Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {//(Consignee)
                eventResponse = searchArrNtcCustInfo(e);
            }

        } else if (e.getEventName().equalsIgnoreCase("EsmBkg0510Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // Pre-Hold Notice
				eventResponse = searchHldNtcSendListByPre(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // Confirmation Notice
				eventResponse = searchHldNtcSendListByConfirm(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) { // Confirmation Notice
				eventResponse = checkHldNtcFormExistByNtcType(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // Pre-Hold Fax
				eventResponse = sendPreHldNtcByFax(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // Pre-Hold Email
				eventResponse = sendPreHldNtcByEmail(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI11)) { // Confirm-Hold Fax
				eventResponse = sendConfirmHldNtcByFax(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI12)) { // Confirm-Hold Email
				eventResponse = sendConfirmHldNtcByEmail(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND40)) { // 테스트용 임시!!
				eventResponse = createCstmsHld(e);
			}
        }else if (e.getEventName().equalsIgnoreCase("EsmBkg0672Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {// [672-1] Retrieve Arrival Data
                //eventResponse = searchArrNtcInfoList(e);
                eventResponse = searchArrNtcInfoList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {//(Consignee)[672-2]
                //eventResponse = searchAnCust(e);
            	eventResponse = this.searchArrNtcCustList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {//(Upload_Match)[672-3]
            	eventResponse = this.searchArrNtcCustListForUpload (e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {// [672-1] Update Arrival Data Modify
                eventResponse = this.setupArrNtcInfoList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {// [672-2] Customer
                eventResponse = this.modifyArrNtcCustList (e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {// [672-3] Upload_Match
                eventResponse = this.createArrNtcCustListbyUpload (e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {// [672-2] Customer backend job search
            	eventResponse = backEndJobResult(e);
            }
        }else if  (e.getEventName().equalsIgnoreCase("EsmBkg0941Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.INIT)) {
                eventResponse = searchComCode0941(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchArrNtcCustCodeErrReport(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
                eventResponse = confirmArrNtcCustCodeErrReport(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg1034Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchPkupNtcFormByManual(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = setupPkupNtcFormByManual(e);
            }
        }else if (e.getEventName().equalsIgnoreCase("EsmBkg0243Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = this.searchArrNtcFormDtl (e);
//            }else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
//                eventResponse = new InboundNoticeMgtSC_Sub1().setupArrNtcInfo (e);
            }
        }else if (e.getEventName().equalsIgnoreCase("EsmBkg0052Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                //eventResponse = searchAnMrnRtnYd (e);
                eventResponse = this.searchArrNtcMrnRtnYd(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                //eventResponse = setupAnMrnRtnYd(e);
                eventResponse = this.setupArrNtcMrnRtnYd(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg0764Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // main search
                eventResponse = searchIntgCustCntcInfoHistory (e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // 고객코드에 대한 고객명
                eventResponse = searchMdmCust(e);
//            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // 로그인 사용자 Office의 국가코드
//            	eventResponse =searchMdmOrzByOfcCd(e);
            } else {

            }
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg1002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkHldNtcFormExist(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = copyHldNtcPreForm(e);
			}

        }else if (e.getEventName().equalsIgnoreCase("EsmBkg1021Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchArrNtcBankAcct (e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = setupArrNtcBankAcct(e);
            }else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
                eventResponse = removeArrNtcBankAcct(e);
            }
        }else if (e.getEventName().equalsIgnoreCase("EsmBkg1020Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchArrNtcGrpForm(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = setupArrNtcGrpForm(e);
            }else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
                eventResponse = setupArrNtcGrpForm(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg1044Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchCustCmdtCntcInfo(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageCustCmdtCntcInfo(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg1054Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {//Code Validation
                eventResponse = manageArrNtcCodeValidation(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {// CodeValidation Result (UnMatch List)
                eventResponse = searchArrNtcUnMatchCustList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {// CodeValidation Result (Match List)
                eventResponse = searchArrNtcMatchCustList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {// VVD 별 POD 목록 조회
            	eventResponse = searchPodListByVVD(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {// CodeValidation Validation Unmatch List
                eventResponse = manageArrNtcUnMatchCust(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {// CodeValidation Reject Validation
                eventResponse = cancelArrNtcCustCdVal(e);
            }else {
            	//eventResponse = getCodeSelect("CD01655", 0, "|", new String[]{"C"});
            	eventResponse = getComIntgCodes(new String[]{"CD01655"}, new String[]{"code"}, new String[]{"value"}, new String[]{"|"}, new String[][]{{"C", "X"}});
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg0414Event")) { // Pick-Up Notice Sent History
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {// Search
                eventResponse = searchPkupNtcSentHistory (e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg105499Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Code Validation
                eventResponse = searchManualValInfo(e);
	        }else {
	        	//eventResponse = getCodeSelect("CD01655", 0, "|", new String[]{"C"});
	        	eventResponse = getComIntgCodes(new String[]{"CD01655"}, new String[]{"code"}, new String[]{"value"}, new String[]{"|"}, new String[][]{{"C"}});
	        }
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg0381Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = this.searchArrNtcSendList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {//Fax 전송
            	eventResponse = this.sendArrNtcByFax(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {//Email 전송
            	eventResponse = this.sendArrNtcByEmail(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {//Edi 전송
                eventResponse = this.sendArrNtcByEdi(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)){//RD Type정보
            	eventResponse = this.searchArrNtcMrdId(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg0956Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                //eventResponse = searchAnMrnRtnYd (e);
                eventResponse = this.searchArrNtcHldRmk(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {//수정
                //eventResponse = setupAnMrnRtnYd(e);
                //eventResponse = new InboundNoticeMgtSC_Sub1().setupAnMrnRtnYd(e);
            	eventResponse = this.setupArrNtcHldRmk(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg0946Event")) {

            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                //eventResponse = searchAnMrnRtnYd (e);
                eventResponse = this.searchArrNtcGrpSendList(e);
            //Preview 를 위한
//            }else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
//                //eventResponse = searchAnMrnRtnYd (e);
//                eventResponse = this.searchArrNtcGrpPreview (e);
            //Fax 발송
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {//
            	eventResponse = this.sendArrNtcByGrpFax (e);
            //Mail 발송
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {//
            	eventResponse = this.sendArrNtcByGrpEmail(e);
            //Proxy Test를 위한 데이터
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI11)) {//

            	//vvd별 수신
            	new InboundDocumentationProxy().receiveOtsInfoTest();

            }
        }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg1063Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPkupNoMnlUpldList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPkupNoMnlUpldList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePkupNoMnlUpldList(e);
			}
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = executePickupSetting(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = monitorPickupSetting(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
                eventResponse = isRunningBatch(e);
            }

		}
        else if (e.getEventName().equalsIgnoreCase("EsmBkg1064Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchParsedPkupNoRpt(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchPkupNoVerifyRpt(e);
			}
		}
        else if (e.getEventName().equalsIgnoreCase("EsmBkg1067Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPkupNoHisList(e);
			}
		}
        else if (e.getEventName().equalsIgnoreCase("EsmBkg1068Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = setupTpbInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTpbInfo(e);
			}
		}
        else if (e.getEventName().equalsIgnoreCase("EsmBkg1099Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchIntgCustCntcUpdtStupInfoByOfc (e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageIntgCustCntcUpdtStupInfoByOfc(e);
            }
        }
        else if (e.getEventName().equalsIgnoreCase("EsmBkg0244Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchAlsoNotify(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.setupAlsoNotify(e);
			}
        }
 

        //long endTime = System.currentTimeMillis();
        //log.debug("------------ 실행시간 "+ ((endTime - startTime)/1000) + "초 입니다.");
        return eventResponse;
    }

/* 품질관리를 위해 주석처리 해둔다. */
//    /**
//     * VARIABLE UI - Code Selection<br>
//     * TODO: Booking Utility로 옮겨가야 할 수 있다(설계자와 협의 필요)
//     * @param String[] intgCdIds 가져올 Code들의 코드번호들 EX- 'CD01655'
//     * @param String[] intgCdValCtntNames Response에 ETC DATA로 세팅할 Code의 Key Ex 'intg_code'
//     * @param String[] intgCdValDpDescNames  Response에 ETC DATA로 세팅할 Code값의 Key 'intg_value'
//     * @exception EventException
//     * @return EventResponse
//     * @author Park Mangeon
//     */
//    private EventResponse getComIntgCodes(String[] intgCdIds, String[] intgCdValCtntNames, String[] intgCdValDpDescNames ) throws EventException {
//    	String[] concatStrs = new String[]{"|"}; // default concat value
//    	String[][] excludeCodeList = null;
//    	return getComIntgCodes(intgCdIds, intgCdValCtntNames, intgCdValDpDescNames, concatStrs, excludeCodeList);
//    }
//
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
//    	String[][] excludeCodeList = null;
//    	return getComIntgCodes(intgCdIds, intgCdValCtntNames, intgCdValDpDescNames, concatStrs, excludeCodeList);
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
				    	log.debug("===============================================");
				    	log.debug("======== sbCode.toString()          ===========");
				    	log.debug("===============================================");
				    	log.debug(sbCode.toString());

				    	log.debug("===============================================");
				    	log.debug("======== sbValue.toString()         ===========");
				    	log.debug("===============================================");
				    	log.debug(sbValue.toString());

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

//    /**
//     * Various UI : Various Event 공통 코드에서 데이터를 조회해 온다.<br>
//     * TODO: 설계나 표준에 따라 BC로 옮겨갈 필요가 있다.<br>
//     *  @author Park Mangeon
//     *  @param String mainCode
// 	 *  @param int sortKey
// 	 *  @param String concatStr 연결문자
// 	 *  @param Stringp[] excludeCodes 제거할 코드
//     *  @return EventResponse
//     */
//    @SuppressWarnings("unchecked")
//	private EventResponse getCodeSelect(String mainCode, int sortKey, String concatStr, String[] excludeCodes) throws EventException {
//    	GeneralEventResponse eventResponse = new GeneralEventResponse();
//    	try {
//	    	com.hanjin.framework.component.util.code.CodeUtil codeUtil = com.hanjin.framework.component.util.code.CodeUtil.getInstance();
//	    	Collection<CodeInfo> col = (Collection<CodeInfo>)codeUtil.getCodeSelect(mainCode, sortKey);
//
//	    	CodeInfo[] codeInfoVOs = new CodeInfo[col.size()];
//	    	col.toArray(codeInfoVOs);
//
//	    	StringBuffer sbCode = new StringBuffer();
//	    	StringBuffer sbValue = new StringBuffer();
//	    	boolean isExclude = false;
//	    	for (int i = 0; i< codeInfoVOs.length; i ++) {
//	    		if (excludeCodes != null && excludeCodes.length >0) {
//	    			for (int j = 0; j < excludeCodes.length; j ++) {
//	    				if (codeInfoVOs[i].getCode().equals(excludeCodes[j]) ) {
//	    					isExclude = true;
//	    					break;
//	    				}
//	    			}
//	    		}
//	    		if (!isExclude) {
//	        		sbCode.append(codeInfoVOs[i].getCode());
//	        		sbValue.append(codeInfoVOs[i].getName());
//	        		if (i < codeInfoVOs.length -1) {
//	        			sbCode.append(concatStr);
//	        			sbValue.append(concatStr);
//	        		}
//
//	    		}
//	    		isExclude = false;
//	    	}
//
//	    	eventResponse.setETCData("code", sbCode.toString());
//	    	eventResponse.setETCData("value", sbValue.toString());
//    	} catch(Exception ex) {
//            log.error("err " + ex.toString(), ex);
//            // BKG00450 : 조회에 실패했습니다.
//            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
//        }
//    	return eventResponse;
//    }





    /**
     * ESM_BKG_0375 : 조회 이벤트 처리<br>
     * Arrival Notice Form을 조회<br>
     *
     * @author Park Mangeon
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchArrNtcForm(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try {
	        // PDTO(Data Transfer Object including Parameters)
	        EsmBkg0375Event event = (EsmBkg0375Event)e;
	        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

	        BkgArrNtcWdVO aryBkgArrNtcWdVO = event.getArrNtcWdVO().getBkgArrNtcWdVO();

	        String ofcCd = aryBkgArrNtcWdVO.getOfcCd();
	        String podCd = aryBkgArrNtcWdVO.getPodCd();
	        String chnAgnCd = aryBkgArrNtcWdVO.getChnAgnCd();

	        ArrNtcWdVO arrNtcWdVO= command.searchArrNtcForm(ofcCd, podCd, chnAgnCd);

	        if (arrNtcWdVO.getBkgArrNtcWdVO() != null) {
		        // bkg_arr_ntc_wd를 etc_data에 입력한다.
//		        List<BkgArrNtcWdVO> bkgArrNtcWdList = new ArrayList<BkgArrNtcWdVO>();
//		        bkgArrNtcWdList.add(arrNtcWdVO.getBkgArrNtcWdVO());
//		        eventResponse.setRsVoList(bkgArrNtcWdList);
	        	BkgArrNtcWdVO bkgArrNtcWdVO = arrNtcWdVO.getBkgArrNtcWdVO();
	        	eventResponse.setETCData("an_seq"         , bkgArrNtcWdVO.getAnSeq());
	        	eventResponse.setETCData("arr_prv_fom_cd" , bkgArrNtcWdVO.getArrPrvFomCd());
	        	eventResponse.setETCData("locl_lang_flg"  , bkgArrNtcWdVO.getLoclLangFlg());
	        	eventResponse.setETCData("eclz_bl_cpy_flg", bkgArrNtcWdVO.getEclzBlCpyFlg());

		        // bkg_arr_ntc_wd_dtl을 xml로 변환한다.
		        List<BkgArrNtcWdDtlVO> arrNtcWdDtlList = new ArrayList<BkgArrNtcWdDtlVO>();
		        for (int i = 0; i < arrNtcWdVO.getBkgArrNtcWdDtlVOs().length; i ++) {
		        	arrNtcWdDtlList.add(arrNtcWdVO.getBkgArrNtcWdDtlVOs()[i]);
		        }
		        eventResponse.setRsVoList(arrNtcWdDtlList);
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
	 * ESM_BKG_0375 : Office변경시<br>
	 * Arrival Notice Form에 등록된 POD 목록을 조회합니다.<br>
	 * @author Park Mangeon
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchArrNtcFormPodList(Event e) throws EventException{
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try {
	        EsmBkg0375Event event = (EsmBkg0375Event)e;
	        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

	        List<BkgArrNtcWdVO> list = (List<BkgArrNtcWdVO>)command.searchArrNtcFormPodList(
	                event.getArrNtcWdVO().getBkgArrNtcWdVO().getOfcCd()
	                );

	        StringBuffer podCd = new StringBuffer();
	        StringBuffer anSeq = new StringBuffer();
	        for(int i=0;i<list.size();i++){
	            podCd.append(list.get(i).getPodCd()).append("|");
	            anSeq.append(list.get(i).getAnSeq()).append("|");
	            //eventResponse.setETCData(list.get(i).getColumnValues());
	        }

	        eventResponse.setETCData("code", podCd.toString());
	        eventResponse.setETCData("value", anSeq.toString());
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
	 * ESM_BKG_0375 : POD변경시<br>
	 * Arrival Notice Form에 등록된 Agent 목록을 조회합니다.<br>
	 * @author Park Mangeon
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchArrNtcFormAgentList(Event e) throws EventException{
        // PDTO(Data Transfer Object including Parameters)
        log.debug("-------------------------------");
        log.debug("searchArrNtcFormAgentList method start");
        log.debug("-------------------------------");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try {
	        EsmBkg0375Event event = (EsmBkg0375Event)e;
	        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

	        ArrNtcWdVO anfs = event.getArrNtcWdVO();
	        log.debug("-------------------------------");
	        log.debug("anfs " + anfs);
	        log.debug("-------------------------------");

	        List<BkgArrNtcWdVO> list = (List<BkgArrNtcWdVO>)command.searchArrNtcFormAgentList(
	                anfs.getBkgArrNtcWdVO().getOfcCd()
	                ,anfs.getBkgArrNtcWdVO().getPodCd()
	                );

	        StringBuffer chnAgnCd = new StringBuffer();
	        StringBuffer anSeq = new StringBuffer();
	        for(int i=0;i<list.size();i++){
	            chnAgnCd.append(list.get(i).getChnAgnCd()).append("|");
	            anSeq.append(list.get(i).getAnSeq()).append("|");
	            //eventResponse.setETCData(list.get(i).getColumnValues());
	        }

	        eventResponse.setETCData("code", chnAgnCd.toString());
	        eventResponse.setETCData("value", anSeq.toString());

	        log.debug("-------------------------------");
	        log.debug("searchArrNtcFormAgentList method end");
	        log.debug("-------------------------------");
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
     * ESM_BKG_0375 : Save Arrival Notice Form<br>
     * Arrival Notice Form Data를 수정한다.<br>
     * master 및 detail을 동시에 수정한다.<br>
     * @author Park Mangeon
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse setupArrNtcForm(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0375Event event = (EsmBkg0375Event)e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
        try{
            begin();
            //event.getArrNtcFomStupVOS()
            ArrNtcWdVO arrNtcWdVO = event.getArrNtcWdVO();
            command.setupArrNtcForm(arrNtcWdVO.getBkgArrNtcWdVO(),arrNtcWdVO.getBkgArrNtcWdDtlVOs(),account);
            eventResponse.setETCData("opr_name", "I");
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0375 : Delete Arrival Notice Form<br>
     * Arrival Notice Form 삭제 처리<br>
     * @author Park Mangeon
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse removeArrNtcForm(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0375Event event = (EsmBkg0375Event)e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
        try{
            begin();
            //event.getArrNtcFomStupVOS()

            ArrNtcWdVO arrNtcWdVO = event.getArrNtcWdVO();
            command.removeArrNtcForm(arrNtcWdVO.getBkgArrNtcWdVO().getOfcCd()
            		                ,arrNtcWdVO.getBkgArrNtcWdVO().getPodCd()
            		                ,arrNtcWdVO.getBkgArrNtcWdVO().getChnAgnCd());
            eventResponse.setETCData("opr_name", "D");
            eventResponse.setUserMessage(new ErrorHandler("BKG00593").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
        }
        return eventResponse;
    }

	/**
	 * ESM_BKG_0948 : Search<br>
	 * 특정 국가별로 등록된 Hold Code정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchHldNtcCode(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0948Event event = (EsmBkg0948Event)e;
        HoldNoticeBC command = new HoldNoticeBCImpl();

        try {
            List<BkgComboVO> list = command.searchHldNtcCode(event.getCntCd());
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
	 * ESM_BKG_0948 : Search<br>
	 * Location Code 유효성을 체크한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse validateLoc(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0948Event event = (EsmBkg0948Event)e;
        BookingUtil comboUtil = new BookingUtil();

        String locCd = event.getLocCd();

        try {
            boolean bResult = comboUtil.validateLoc(locCd);

            if (bResult == true) eventResponse.setETCData("loc_validate", "true");
            else eventResponse.setETCData("loc_validate", "false");

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
	 * ESM_BKG_0948 : [이벤트]<br>
	 * 대화주 Hold Notice 송부와 별도로 내부적으로 자동 Mail or/and Alert를  <br>
     * 받기를 희망하는 Staff에 의해 Setting된 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchHldNtcUsr(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0948Event event = (EsmBkg0948Event)e;
        HoldNoticeBC command = new HoldNoticeBCImpl();

        try {
            // 검색조건
            String locCd     = event.getLocCd();
            String userId    = event.getUserId();

            List<BkgHldNtcUsrVO> list = command.searchHldNtcUsr(locCd, userId);
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
	 * ESM_BKG_0948 : setup<br>
	 * Staff에 의해 Hold Notice( Mail or/and Alert ) Setting 정보를 추가/수정/삭제한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse setupHldNtcUsr(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0948Event event = (EsmBkg0948Event)e;
        HoldNoticeBC command = new HoldNoticeBCImpl();

        try{
            begin();
            command.setupHldNtcUsr(event.getBkgHldNtcUsrVOS(),account);
            //eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110", new String[]{"Setup"}).getMessage(), ex);
        }

		return eventResponse;
    }

    /**
     * ESM_BKG_1054 : Save 양하도착통지 - Customer Code Validation<br>
     * Customer code Validation용 Backend job을 수행한다.<br>
     * @author Park Mangeon
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageArrNtcCodeValidation(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            begin();
            EsmBkg1054Event event = (EsmBkg1054Event)e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
            ArrNtcSearchVO anSearch = event.getArrNtcSearchVO();
	        anSearch.setValUsrId(account.getUsr_id()); // 모델변경에 따라 이동
	        anSearch.setValOfcCd(account.getOfc_cd()); // 모델변경에 따라 이동
            String key = command.manageArrNtcCodeValidation(anSearch);
            eventResponse.setETCData("background_job_key", key);
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_BKG_0240-1 : 조회 이벤트 처리<br>
     * Integrated Customer Data Management의 Open 이벤트 처리<br>
     * Master 를 조회
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     * by 박성호
     */
    private EventResponse searchIntgCustCntcInfo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0240Event event = (EsmBkg0240Event)e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{
        	IbCustCntcVO bkgIbCustCntcVO = command.searchIntgCustCntcInfo(event.getIntgCustSearchVO());
	        eventResponse.setRsVoList(bkgIbCustCntcVO.getMdmCustomerVO());
	        eventResponse.setRsVoList(bkgIbCustCntcVO.getDetailBkgIbCustCntcVO());
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }


        //log.debug("============="+eventResponse);
        return eventResponse;
    }

    /**
     * 조회 이벤트 처리<br>
     * Integrated Customer Data Management의 Open 이벤트 처리<br>
     * I/B Tab을 조회
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchIntgCustCntcInfoByIB(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0240Event event = (EsmBkg0240Event)e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

        //event.getIntgCustSearchVO().setCustCntCd("KR");
        //event.getIntgCustSearchVO().setCustSeq("17");

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
        	String custCntCdIb = event.getIntgCustSearchVO().getCustCntCdIb();
        	String custSeqIb = event.getIntgCustSearchVO().getCustSeqIb();
        	String ofcCd = "";
        	//IB Tab 에서 직접 OFC_CD 입력후 조회시.
        	if(event.getIntgCustSearchVO().getOfcCdIb() != null
        			&& !event.getIntgCustSearchVO().getOfcCdIb().equals("")){
        		ofcCd = event.getIntgCustSearchVO().getOfcCdIb();
        	}else{
        		ofcCd = event.getIntgCustSearchVO().getLoginOfcCd();
        	}

        	eventResponse.setRsVoList(
                (List<IbCustCntcVO>)command.searchIntgCustCntcInfoByIB(custCntCdIb ,custSeqIb ,ofcCd));
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
     * ESM_BKG_0240: I/B Customer Info를 저장한다.<br>
     *
     * @param e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageIntgCustCntcInfoByIB(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0240Event event = (EsmBkg0240Event)e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

        try{
            begin();
            BkgIbCustCntcVO[] bkgIbCustCntcVOs = event.getBkgIbCustCntcVOs();
            String ofcCd = "";
            for(int i=0;i<bkgIbCustCntcVOs.length;i++){
            	//IB Tab 에서 직접 OFC_CD 입력후 조회시.
            	if(event.getIntgCustSearchVO().getOfcCdIb() != null
            			&& !event.getIntgCustSearchVO().getOfcCdIb().equals("")){
            		ofcCd = event.getIntgCustSearchVO().getOfcCdIb();
            	}else{
            		ofcCd =	event.getIntgCustSearchVO().getLoginOfcCd();
            	}
            	log.debug("------------------- ofcCd " + ofcCd);
            	log.debug("------------------- event.getIntgCustSearchVO() " + event.getIntgCustSearchVO().getColumnValues());
                bkgIbCustCntcVOs[i].setCustCntCd(event.getIntgCustSearchVO().getCustCntCdIb());
                bkgIbCustCntcVOs[i].setCustSeq(event.getIntgCustSearchVO().getCustSeqIb());
                bkgIbCustCntcVOs[i].setOfcCd(ofcCd);
                log.debug("------------------- bkgIbCustCntcVOs[i] " + bkgIbCustCntcVOs[i].getColumnValues());
            }
            command.manageIntgCustCntcInfoByIB(bkgIbCustCntcVOs,event.getSignOnUserAccount());
            //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            //eventResponse.setUserMessage(new ErrorHandler("").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0240-02 : Integrated Customer Data Management(OB) Open 이벤트 처리<br>
     * 조회 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchIntgCustCntcInfoByOB(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0240Event event = (EsmBkg0240Event)e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

        //event.getIntgCustSearchVO().setCustCntCd("KR");
        //event.getIntgCustSearchVO().setCustSeq("17");

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
        	eventResponse.setRsVoList(
                (List<BkgCustTmpltVO>)command.searchIntgCustCntcInfoByOB(
                        event.getIntgCustSearchVO().getCustCntCdIb()
                        ,event.getIntgCustSearchVO().getCustSeqIb()
                        ));
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
     * ESM_BKG_0240-03 :조회 이벤트 처리<br>
     * Integrated Customer Data Management(Invoice) Open 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchIntgCustCntcInfoByInvoice(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0240Event event = (EsmBkg0240Event)e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

        //event.getIntgCustSearchVO().setCustCntCd("KR");
        //event.getIntgCustSearchVO().setCustSeq("17");

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
        	eventResponse.setRsVoList(
                (List<BkgMdmCrCustVO>)command.searchIntgCustCntcInfoByInvoice(
                        event.getIntgCustSearchVO().getCustCntCdIb()
                        ,event.getIntgCustSearchVO().getCustSeqIb()
                        ));
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
     * 조회 이벤트 처리<br>
     * Integrated Customer Data Management(TRO) Open 이벤트 처리<br>
     * [240-4]
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchIntgCustCntcInfoByTRO(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0240Event event = (EsmBkg0240Event)e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

        //event.getIntgCustSearchVO().setCustCntCd("KR");
        //event.getIntgCustSearchVO().setCustSeq("17");

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
        	eventResponse.setRsVoList(
                (List<BkgTroActCustVO>)command.searchIntgCustCntcInfoByTRO(
                        event.getIntgCustSearchVO().getCustCntCdIb()
                        ,event.getIntgCustSearchVO().getCustSeqIb()
                        ));
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
     * ESM_BKG_0242-01 : 조회 이벤트 처리<br>
     * AN Setting Screen_Customer Information(Consignee)<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchArrNtcCustInfo (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0242Event event = (EsmBkg0242Event)e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

        //event.getIntgCustSearchVO().setCustCntCd("KR");
        //event.getIntgCustSearchVO().setCustSeq("17");

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        String bkgNo = event.getArrNtcCustRefVO().getBkgNo();
        String custTpCd = event.getArrNtcCustRefVO().getBkgCustTpCd();
        try{
        	eventResponse.setRsVoList(
                (List<ArrNtcCustRefVO>)command.searchArrNtcCustInfo(bkgNo,custTpCd));
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
     * ESM_BKG_0672-01 : 조회 이벤트 처리<br>
     * A/N Setting Screen_Arrival Data 정보를 조회한다.(1)<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
//    private EventResponse searchArrNtcInfoList  (Event e) throws EventException {
//        // PDTO(Data Transfer Object including Parameters)
//        EsmBkg0672Event event = (EsmBkg0672Event)e;
//        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
//
//        //event.getIntgCustSearchVO().setCustCntCd("KR");
//        //event.getIntgCustSearchVO().setCustSeq("17");
//
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        eventResponse.setRsVoList((List<ArrNtcVO>)command.searchArrNtcInfoList(event.getArrNtcSearchVO()));
//        //eventResponse.setRsVoList((List<ArrNtcVO>)command.searchArrNtcInfoListByPaging(event.getArrNtcSearchVO()));
//
//        return eventResponse;
//    }
    /**
     * ESM_BKG_0672-01 : 조회 이벤트 처리<br>
     * A/N Setting Screen_Arrival Data 정보를 조회한다.(Paging)(1)<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchArrNtcInfoList  (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0672Event event = (EsmBkg0672Event)e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

        //event.getIntgCustSearchVO().setCustCntCd("KR");
        //event.getIntgCustSearchVO().setCustSeq("17");

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
        	List<ArrNtcInfoListVO> saveVO = (List<ArrNtcInfoListVO>)command.searchArrNtcInfoList(event.getArrNtcSearchVO(),account);
        //log.debug("----------------- " + saveVO.get(0).getColumnValues());
        	eventResponse.setRsVoList(saveVO);
        //eventResponse.setRsVoList((List<ArrNtcVO>)command.searchArrNtcInfoListByPaging(event.getArrNtcSearchVO()));
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
     * [UI-BKG-1054_01] VVD별 POD 목록을 조회합니다.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
    private EventResponse searchPodListByVVD (Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            EsmBkg1054Event event = (EsmBkg1054Event)e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
            ArrNtcSearchVO arrNtcSch = event.getArrNtcSearchVO();

            if(!CheckUtils.isNull(arrNtcSch) && !CheckUtils.isNullAndNullString(arrNtcSch.getVvd())){
	            List<BkgVvdVO> list = command.searchPodListByVVD(arrNtcSch.getVvd());
	            eventResponse.setRsVoList(list);
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
     * ESM_BKG_1054 : Retrieve Customer Code Validation<br>
     * Customer Code Validation 수행 후 결과중 unmatch에 해당하는 정보를 조회한다.<br>
     *
     * @author Park Mangeon
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	@SuppressWarnings("unchecked")
	private EventResponse searchArrNtcUnMatchCustList (Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            EsmBkg1054Event event = (EsmBkg1054Event)e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            ArrNtcSearchVO arrNtcSearchVO = event.getArrNtcSearchVO();
            List<CustCdValidationVO> unmatchList = null;

            if(arrNtcSearchVO.getMtchChkFlg() == null || arrNtcSearchVO.getMtchChkFlg().equals("")) {
                // Backend job이 완료되었는지 검사한다.
                BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(arrNtcSearchVO.getBackgroundJobKey());

                DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
                List<ComBakEndJbVO> dbRowSetlist = (List)RowSetUtil.rowSetToVOs(rowSet, ComBakEndJbVO.class);

                ComBakEndJbVO jobVo = null;
                if (dbRowSetlist.size() == 0) {
                    // Background job framework가 정상적으로 동작하지 않을 경우 발생하는 오류를 회피하기 위함
                    jobVo = new ComBakEndJbVO();
                    jobVo.setJbStsFlg("0");
                } else {
                    jobVo = (ComBakEndJbVO)dbRowSetlist.get(0);
                }

                eventResponse.setETCData("jb_sts_flg", jobVo.getJbStsFlg());
                if (jobVo.getJbStsFlg().equals("3")) {
                    // Backend job이 완료되었으면 조회를 수행한다.
                    unmatchList = command.searchArrNtcUnMatchCustList(arrNtcSearchVO, account);
                    eventResponse.setRsVoList(unmatchList);
                }
            } else if(arrNtcSearchVO.getMtchChkFlg().equals("N")) {
                // unmatch case에 대하여 처리한다.
                unmatchList = command.searchArrNtcUnMatchCustList(arrNtcSearchVO, account);
                eventResponse.setRsVoList(unmatchList);
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
     * ESM_BKG_1054 : Search Customer Code Validation<br>
     * Customer Code Validation 수행 후 결과중 match에 해당하는 정보를 조회한다.<br>
     * @author Park Mangeon
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchArrNtcMatchCustList (Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            EsmBkg1054Event event = (EsmBkg1054Event)e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            ArrNtcSearchVO arrNtcSch = event.getArrNtcSearchVO();
            arrNtcSch.setOfcCd(account.getOfc_cd());  // 모델 변경으로 이동
            List<CustCdValidationVO> list = command.searchArrNtcMatchCustList(arrNtcSch);

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
     * ESM_BKG_1054-99 : Search Customer Code Validation (정규개발목록 아님)<br>
     * Customer Code Validation 수행 후 결과중 match에 해당하는 정보를 조회한다.<br>
     * @author Park Mangeon
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchManualValInfo (Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            EsmBkg105499Event event = (EsmBkg105499Event)e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            ArrNtcSearchVO arrNtcSearchVO = event.getArrNtcSearchVO();

            List<CustCdValidationVO> list = command.searchManualValInfo(arrNtcSearchVO, account);
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
	 * ESM_BKG_0411 : Search<br>
	 * PickUp Notice Form에 대한 Setting 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

    private EventResponse searchPkupNtcForm(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0411Event event = (EsmBkg0411Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();

        try {

            String ntcSndTpCd = event.getNtcSndTpCd();
            String ofcCd = event.getOfcCd();
            String delCd = event.getDelCd();

            PkupNtcFormVO pickUpNoticeFormVO = command.searchPkupNtcForm(ntcSndTpCd, ofcCd, delCd);

            eventResponse.setRsVo(pickUpNoticeFormVO.getBkgPkupNtcStupVO());
            eventResponse.setRsVo(pickUpNoticeFormVO.getBkgPkupWdVO(0));
            eventResponse.setRsVoList(pickUpNoticeFormVO.getBkgPkupNtcHrVO(0));
            eventResponse.setRsVo(pickUpNoticeFormVO.getBkgPkupWdVO(1));
            eventResponse.setRsVoList(pickUpNoticeFormVO.getBkgPkupNtcHrVO(1));

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
	 * ESM_BKG_0411 : Search<br>
	 * PickUp Notice Form에 대한 기등록된 Office별 Del 목록을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

    private EventResponse searchPkupNtcFormDelList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0411Event event = (EsmBkg0411Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();

        try{

            String ntcSndTpCd = event.getNtcSndTpCd();
            String ofcCd = event.getOfcCd();

            List<BkgComboVO> list = command.searchPkupNtcFormDelList(ntcSndTpCd, ofcCd);

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
	 * ESM_BKG_0411 : Setup<br>
	 * PickUp Notice Form 정보를 수정 혹은 저장한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse setupPkupNtcForm (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0411Event event = (EsmBkg0411Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();

        try{
            begin();
            command.setupPkupNtcForm (event.getBkgPkupNtcStupVO(),
                                      event.getBkgPkupWdVOs(),
                                      event.getBkgPkupNtcHrVOs(),
                                      account);
            //eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
            commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00110", new String[]{"Setup"}).getMessage(), ex);
		}

		return eventResponse;
    }



	/**
	 * ESM_BKG_0411 : Delete<br>
	 * PickUp Notice Form 정보를 삭제한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse removePkupNtcForm (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0411Event event = (EsmBkg0411Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();

        try{
            begin();
            command.removePkupNtcForm (event.getPkupNtcSeq());
            //eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
            commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00110", new String[]{"Delete"}).getMessage(), ex);
		}

		return eventResponse;
    }

    /**
     * ESM_BKG_1054 : Save Customer Code Validation<br>
     * Customer Code Validation한  Unmatch 정보를 update 한다.<br>
     * Arrival Notice master 및 Detail을 생성한다.<br>
     * @author Park Mangeon
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
    private EventResponse manageArrNtcUnMatchCust (Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
        	begin();
            EsmBkg1054Event event = (EsmBkg1054Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
            GeneralBookingReceiptBC generalBookingReceiptCommand = new GeneralBookingReceiptBCImpl();

			CustCdEvaluationVO[] custCdEval = event.getCustCdEvaluationVO();

            generalBookingReceiptCommand.modifyCustCdValInfo(custCdEval, account); // 책임테이블 때문에 분리 20091120
            command.manageArrNtcUnMatchCust(custCdEval, account);

            // 20100525 Booking History를 수정하는 로직 추가 mgpark
            BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
            HistoryLineVO historyLineVO = new HistoryLineVO();
            historyLineVO.setCaFlg( "N" );
            historyLineVO.setUiId( "ESM_BKG_1054");
            String strOldVal = null; // 안정적인 검사를 위해 변수 선언
            String strNewVal = null;


            for (int i = 0; i < custCdEval.length; i ++) {
            	if (custCdEval[i].getBkgNo() != null && !custCdEval[i].getBkgNo().equals("")) { // BKG_NO가 없는 것은 Group이므로 제외
	            	strOldVal = custCdEval[i].getMdmCustCd()==null?"":custCdEval[i].getMdmCustCd();
	            	strNewVal = custCdEval[i].getCorCustCd()==null?"":custCdEval[i].getCorCustCd();
	            	if (!strOldVal.equals(strNewVal)) { // 값이 변경될 경우에만 History 남김
		            	historyLineVO.setBkgNo( custCdEval[i].getBkgNo() );
			            historyLineVO.setCrntCtnt( strNewVal );
			            historyLineVO.setPreCtnt( strOldVal );
			            if (custCdEval[i].getBkgCustTpCd().equals("C")) {
			            	historyLineVO.setHisCateNm( "CNEE CD");
			            } else if (custCdEval[i].getBkgCustTpCd().equals("N")) {
			            	historyLineVO.setHisCateNm( "NTFY CD");
			            }
			            historyBC.createBkgHistoryLine(historyLineVO, account);
	            	}
            	}
            }
            commit();


            //별도 트랜잭션으로 처리
            BlRatingBC			ratingBC  = new BlRatingBCImpl();          // Charge I/F 호출
	 		BookingARCreationBC invBc     = new BookingARCreationBCImpl(); // Invoce I/F 호출
			// MAS I/F 호출
			com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBC masBc  = new com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBCImpl();


            //I/F 관련 VO
            MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
            ARBkgInterfaceCreationVO bkgIfVo = new ARBkgInterfaceCreationVO();


            for (int i = 0; i < custCdEval.length; i ++) {
            	if (custCdEval[i].getBkgNo() != null && !custCdEval[i].getBkgNo().equals("")) { // BKG_NO가 없는 것은 Group이므로 제외
	            	strOldVal = custCdEval[i].getMdmCustCd()==null?"":custCdEval[i].getMdmCustCd();
	            	strNewVal = custCdEval[i].getCorCustCd()==null?"":custCdEval[i].getCorCustCd();
	            	if (!strOldVal.equals(strNewVal)) { // 값이 변경될 경우에만 History 남김
				        try{
				            // RATE I/F 추가
				            ratingBC.modifyRateCntCd(custCdEval[i].getBkgNo(), account, "N");
				        } catch (Exception exx) {
							log.error("######## BKG IBD RATE I/F err " + exx.toString(), exx);
						}

				        /*
				         * 2015.07.21 COA I/F 삭제
				        */
				        try{
							// MAS I/F 추가
							masBkgComIfVo = new MasBkgComIfVO();
							masBkgComIfVo.setBkgNo(custCdEval[i].getBkgNo());
							masBkgComIfVo.setCostSrcSysCd("BKG");
							masBkgComIfVo.setIfRmk("Customer Update");
							masBkgComIfVo.setCreUsrId(account.getUsr_id());
							masBkgComIfVo.setUpdUsrId(account.getUsr_id());
							masBc.modifyMasDailyInterface(masBkgComIfVo);
				        } catch (Exception exx) {
							log.error("######## BKG IBD MAS I/F err " + exx.toString(), exx);
						}

				        try{
							// interfaceBkgARInvoiceToINV 호출
				 			bkgIfVo = new ARBkgInterfaceCreationVO();
				 			bkgIfVo.setBkgNo(custCdEval[i].getBkgNo());
				 			bkgIfVo.setBkgCorrNo("N");
				 			bkgIfVo.setUserId(account.getUsr_id());
				 			bkgIfVo.setManDivInd("B");
				 			invBc.interfaceBKGARInvoiceToINV(bkgIfVo);
				        } catch (Exception exx) {
							log.error("######## BKG IBD INVOICE I/F err " + exx.toString(), exx);
						}

	            	}
            	}
            }
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
        }
        return eventResponse;
    }




    /**
     * ESM_BKG_1054 : Save Customer Code Validation<br>
     * Customer Code Validation작업으로 Match된 정보를 Unmatch로 변경한다.<br>
     * Arrival Notice master 와 Detail을 삭제한다.<br>
     * Match 정보를 update 한다.<br>
     * @author Park Mangeon
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
    private EventResponse cancelArrNtcCustCdVal (Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
        	begin();
            EsmBkg1054Event event = (EsmBkg1054Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
            GeneralBookingReceiptBC generalBookingReceiptCommand = new GeneralBookingReceiptBCImpl();

            CustCdEvaluationVO[] custCdEvals = event.getCustCdEvaluationVO();

            command.cancelArrNtcCustCdVal(custCdEvals);
            generalBookingReceiptCommand.removeCustCdValInfo(custCdEvals[0].getBkgNo(),custCdEvals[0].getBkgCustTpCd() , account); // 책임테이블 때문에 분리 20091120

            // 20100525 Booking History를 수정하는 로직 추가 mgpark
            BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
            HistoryLineVO historyLineVO = new HistoryLineVO();
            historyLineVO.setCaFlg( "N" );
            historyLineVO.setUiId( "ESM_BKG_1054");
            String strOldVal = null; // 안정적인 검사를 위해 변수 선언
            String strNewVal = null;
        	strOldVal = custCdEvals[0].getMdmCustCd()==null?"":custCdEvals[0].getMdmCustCd();
        	strNewVal = custCdEvals[0].getOrgCustCd()==null?"":custCdEvals[0].getOrgCustCd();
        	if (!strOldVal.equals(strNewVal)) { // 값이 변경될 경우에만 History 남김
            	historyLineVO.setBkgNo( custCdEvals[0].getBkgNo() );
	            historyLineVO.setCrntCtnt( strNewVal );
	            historyLineVO.setPreCtnt( strOldVal);
	            if (custCdEvals[0].getBkgCustTpCd().equals("C")) {
	            	historyLineVO.setHisCateNm( "CNEE CD");
	            } else if (custCdEvals[0].getBkgCustTpCd().equals("N")) {
	            	historyLineVO.setHisCateNm( "NTFY CD");
	            }
	            historyBC.createBkgHistoryLine(historyLineVO, account);
        	}

            commit();

            //트랜잭션 별도 관리
            if (!strOldVal.equals(strNewVal)) { // 값이 변경될 경우에만 History 남김

	            BlRatingBC			ratingBC  = new BlRatingBCImpl();          // Charge I/F 호출
		 		BookingARCreationBC invBc     = new BookingARCreationBCImpl(); // Invoce I/F 호출
				// MAS I/F 호출
				com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBC masBc  = new com.hanjin.apps.alps.esm.mas.stdunitcost.costassign.basic.CostAssignBCImpl();

				try {
					// RATE I/F 추가
					ratingBC.modifyRateCntCd(custCdEvals[0].getBkgNo(), account, "N");
				} catch (Exception exx) {
					log.error("######## BKG IBD RATE I/F err " + exx.toString(), exx);
				}
	            /*
	             * 2015.07.21 COA I/F 삭제
				*/

				try{
					// MAS I/F 추가
					MasBkgComIfVO masBkgComIfVo = new MasBkgComIfVO();
					masBkgComIfVo.setBkgNo(custCdEvals[0].getBkgNo());
					masBkgComIfVo.setCostSrcSysCd("BKG");
					masBkgComIfVo.setIfRmk("Customer Update");
					masBkgComIfVo.setCreUsrId(account.getUsr_id());
					masBkgComIfVo.setUpdUsrId(account.getUsr_id());
					masBc.modifyMasDailyInterface(masBkgComIfVo);
				} catch (Exception exx) {
					log.error("######## BKG IBD MAS I/F err " + exx.toString(), exx);
				}

				try{
					// INVOICE I/F 추가
					ARBkgInterfaceCreationVO bkgIfVo = new ARBkgInterfaceCreationVO();
		 			bkgIfVo.setBkgNo(custCdEvals[0].getBkgNo());
		 			bkgIfVo.setBkgCorrNo("N");
		 			bkgIfVo.setUserId(account.getUsr_id());
		 			bkgIfVo.setManDivInd("B");
		 			invBc.interfaceBKGARInvoiceToINV(bkgIfVo);
				} catch (Exception exx) {
					log.error("######## BKG IBD INVOICE I/F err " + exx.toString(), exx);
				}

        	}

        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
        }
        return eventResponse;
    }


	/**
	 * ESM_BKG_0992 : 중복 체크<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse checkPkupNtcFormExist(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0992Event event = (EsmBkg0992Event)e;
    	PickUpNoticeBC command = new PickUpNoticeBCImpl();

    	try {
    		boolean bResult = command.checkPkupNtcFormExist(event.getOfcCd(), event.getDelCd());
            if (bResult == true) eventResponse.setETCData("valid", "true");
            else eventResponse.setETCData("valid", "false");

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
	 * ESM_BKG_0992 : Copy<br>
	 * 기 입력된 P/N Notice Form Setup 정보를 Copy한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse copyPkupNtcForm(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0992Event event = (EsmBkg0992Event)e;
    	PickUpNoticeBC command = new PickUpNoticeBCImpl();

        try{
            begin();
            command.copyPkupNtcForm(event.getPkupNtcFormCopy());
            //eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
            commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00110", new String[]{"Copy"}).getMessage(), ex);
		}

    	return eventResponse;
    }

	/**
	 * ESM_BKG_0993 : Search<br>
	 * Manually Pickup Notice를 송부할 대상(Container)을 Upload한후 해당 컨테이너별 상세 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchPkupNtcListByManual(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0993Event event = (EsmBkg0993Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();

        try{
            List<PkupNtcManualListVO> list = command.searchPkupNtcListByManual(event.getBlNo());
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
	 * ESM_BKG_0993 : Setup<br>
	 * Manually Upload한 컨테이너별 P/N 대상 데이타를 Setup한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse setupPkupNtcListByManual(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0993Event event = (EsmBkg0993Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();
        try{
            begin();
            command.setupPkupNtcListByManual(event.getPkupNtcManualListVOs(),account);
            commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00110", new String[]{"Setup"}).getMessage(), ex);
		}
        return eventResponse;
    }

    /**
     * ESM_BKG_0941 : Search Customer code Error Report<br>
     * 화면 초기화를 위해 Combo Item whghl<br>
     *
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchComCode0941(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        BookingUtil command = new BookingUtil();
        BkgComboVO combovo = new BkgComboVO();
        combovo.setVal("");
		combovo.setDesc("All");
		combovo.setName("All");

        //Validation Code - CD02204
        List<BkgComboVO> list1 = command.searchCombo("CD03164");
        list1.add(0,combovo);
        eventResponse.setRsVoList(list1);

        //Region
        List<BkgComboVO> list2 = command.searchRgnOfficeCd();
        list2.add(0,combovo);
        eventResponse.setRsVoList(list2);

        //Customer Type Code
        List<BkgComboVO> list3 = command.searchCombo("CD03165");
        list3.add(0,combovo);
        eventResponse.setRsVoList(list3);

        return eventResponse;
    }

    /**
     * ESM_BKG_0941 : Search Customer code Error Report<br>
     * Customer Code Error Report를 조회한다.<br>
     * @author Park Mangeon
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
    private EventResponse searchArrNtcCustCodeErrReport (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        String errFlg = "";
        String excelFlg = "";
        try{
            EsmBkg0941Event event = (EsmBkg0941Event)e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
            List<ArrNtcCustCodeErrListVO> custCodeErrLists = command.searchArrNtcCustCodeErrReport(event.getArrNtcCustCodeErrSearchVO());
            errFlg = event.getArrNtcCustCodeErrSearchVO().getErrFlg();
            excelFlg = event.getArrNtcCustCodeErrSearchVO().getExcelFlg();
            if( "Y".equals(errFlg) && !"Y".equals(excelFlg)){
            	List<ArrNtcCustCodeErrListVO> custCodeErrLists2 = command.searchArrNtcCustCodeErrRhqReport(event.getArrNtcCustCodeErrSearchVO());
            	eventResponse.setRsVoList(custCodeErrLists);
            	eventResponse.setRsVoList(custCodeErrLists2);
            }
            else{
            	eventResponse.setRsVoList(custCodeErrLists);
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
	 * ESM_BKG_0941 : Customer Code Error Report Confirm<br>
	 * Code Validation결과를 재평가 한다.<br>
     * @author Park Mangeon
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
    private EventResponse confirmArrNtcCustCodeErrReport (Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            EsmBkg0941Event event = (EsmBkg0941Event)e;
            GeneralBookingReceiptBC command = new GeneralBookingReceiptBCImpl();
            //event.getArrNtcCustCodeErrListVOs()[0].setUsrId(account.getUsr_id());
            command.confirmCustCdErrReport(event.getArrNtcCustCodeErrListVOs());
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
	 * ESM_BKG_1034 : search<br>
	 * Manual PickUp Notice Form에 대한  Setting 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchPkupNtcFormByManual(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1034Event event = (EsmBkg1034Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();

        try{
            String ofcCd = event.getOfcCd();

            PkupNtcFormVO pickUpNoticeFormVO = command.searchPkupNtcFormByManual(ofcCd);

            eventResponse.setRsVo(pickUpNoticeFormVO.getBkgPkupNtcStupVO());
            eventResponse.setRsVo(pickUpNoticeFormVO.getBkgPkupWdVO(0));
            eventResponse.setRsVo(pickUpNoticeFormVO.getBkgPkupWdVO(1));
            eventResponse.setRsVo(pickUpNoticeFormVO.getBkgPkupWdVO(2));

            if (pickUpNoticeFormVO.getBkgPkupNtcStupVO() == null) {
            	eventResponse.setUserMessage(new ErrorHandler("BKG04016", new String[] {ofcCd}).getUserMessage());
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
	 * ESM_BKG_1034 : setup<br>
	 * PickUp Notice Form 정보를 수정 혹은 저장한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse setupPkupNtcFormByManual(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1034Event event = (EsmBkg1034Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();

        try{
            begin();
            command.setupPkupNtcFormByManual (event.getBkgPkupNtcStupVO(),
                                              event.getBkgPkupWdVOs(),
                                              account);
            //eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
            commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00110", new String[]{"Setup"}).getMessage(), ex);
		}

        return eventResponse;
    }

	/**
	 * ESM_BKG_1066 : [이벤트]<br>
	 * PickUp Notice를 받을 수화주별에 대한 정보를 변경한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse modifyPkupNtcSendList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg1066Event event = (EsmBkg1066Event) e;
    	PickUpNoticeBC command = new PickUpNoticeBCImpl();

        try{
            begin();
            command.modifyPkupNtcSendList(event.getPkupNtcSendListVOs(), account);
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
            commit();

		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}

        return eventResponse;
    }



	/**
	 * ESM_BKG_1066 : [이벤트]<br>
	 * 픽업 대상정보들을 사용자 확인을 저장한다<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse verifyPkupNtcList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg1066Event event = (EsmBkg1066Event) e;
    	PickUpNoticeBC command = new PickUpNoticeBCImpl();

        try{
            begin();
            command.verifyPkupNtcSendList(event.getPkupNtcSendListVOs(), account);
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
            commit();

		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}

        return eventResponse;
    }


	/**
	 * ESM_BKG_1066 : Search<br>
	 * PickUp Notice를 발송(Success)한 대상 및 미 발송(Fail or 누락)된 대상정보들을 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchPkupNtcSendList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1066Event event = (EsmBkg1066Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();

        try{
            PkupNtcSearchVO search = event.getPkupNtcSearchVO();

            List<PkupNtcSendListVO> list = command.searchPkupNtcSendList(search);
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
	 * ESM_BKG_1066 : Fax<br>
	 * Container 단위로 Fax로 P/N를 송부한다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse sendPkupNtcByFax(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1066Event event = (EsmBkg1066Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();

        try{

        	String uiId = "ESM_BKG_1066";

            begin();
            /* 1. Send Notice */
            List<BkgNtcHisVO> bkgNtcHisVOs = command.sendPkupNtcByFax(event.getPkupNtcSendListVOs(), account);
            /* 2. Register Notice History */
			bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, uiId);
            eventResponse.setUserMessage(new ErrorHandler("BKG40053").getUserMessage());
            commit();

		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00242").getMessage(), ex);
		}

        return eventResponse;
    }


	/**
	 * ESM_BKG_1066 : Email<br>
	 * Container 단위로 Email로 P/N를 송부한다.  <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private GeneralEventResponse sendPkupNtcByEmail(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1066Event event = (EsmBkg1066Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();

        try {
        	String uiId = "ESM_BKG_1066";

            begin();
            /* 1. Send Notice */
            List<BkgNtcHisVO> bkgNtcHisVOs =
            	command.sendPkupNtcByEmail(event.getPkupNtcSendListVOs(), account);
            /* 2. Register Notice History */
			bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, uiId);
            eventResponse.setUserMessage(new ErrorHandler("BKG40054").getUserMessage());
            commit();

		}catch(EventException ex){
			rollback();
			//log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00243").getMessage(), ex);
		}

        return eventResponse;
    }


	/**
	 * ESM_BKG_1066 : Stop<br>
	 * 발송 예정인 Pick-up Notice Email/Fax 자동 전송을 중지한다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private GeneralEventResponse stopPkupNtcSend(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1066Event event = (EsmBkg1066Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();

        try {

            begin();
            command.stopPkupNtcSend(event.getPkupNtcSendListVOs(), account);
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
            commit();

		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

        return eventResponse;
    }


	/**
	 * ESM_BKG_1066 : Resume<br>
	 * 발송 예정인 Pick-up Notice Email/Fax 자동 전송을 중지를 해지한다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private GeneralEventResponse resumePkupNtcSend(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1066Event event = (EsmBkg1066Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();

        try {

            begin();
            command.resumePkupNtcSend(event.getPkupNtcSendListVOs(), account);
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
            commit();

		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

        return eventResponse;
    }


    /**
     * ESM_BKG_0764 : Retrieve Customer Data Management Update History<br>
	 * 인바운드 고객정보 수정 현황을 조회한다.
     *  @author Park Mangeon
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
    private EventResponse searchIntgCustCntcInfoHistory(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try {
	        EsmBkg0764Event event = (EsmBkg0764Event)e;
	        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

	        // 검색조건
	        IbCustCntcHisVO ibCustCntcHis = event.getIbCustCntcHisVO();

	        List<IbCustCntcHisVO> list = command.searchIntgCustCntcInfoHistory(ibCustCntcHis);
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
     * ESM_BKG_0764 : Search Customer Data Management Update History<br>
	 * 인바운드 고객정보에 대한 고객명을 조회한다.<br>
     *  @author Park Mangeon
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
    private EventResponse searchMdmCust(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try {
	        EsmBkg0764Event event = (EsmBkg0764Event)e;
	        BookingUtil command = new BookingUtil();

	        // 검색조건
	        IbCustCntcHisVO search = event.getIbCustCntcHisVO();

	        MdmCustVO mdmCustVO = command.searchMdmCust(search.getCustCntCd(), search.getCustSeq(), "N");

	        eventResponse.setETCData("cust_nm", mdmCustVO.getName());
    	} catch(EventException ex) {
    		throw ex;
    	} catch(Exception ex) {
    		log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
   		}
        return eventResponse;
    }

//    /**
//     * ESM_BKG_0764 : Search Customer Data Management Update History<br>
//	 *  로그인 사용자 세션정보에 있는 Office 코드를 이용하여, MDM정보상 국가코드를 제공한다.<br>
//     *  @author Park Mangeon
//	 * @param Event e
//	 * @return EventResponse
//	 * @exception EventException
//     */
//    private EventResponse searchMdmOrzByOfcCd(Event e) throws EventException {
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        try{
//	        MdmOrganizationVO mdmOrganizationVO = bookingUtilBC.searchMdmOrzByOfcCd(account.getOfc_cd());
//
//	        eventResponse.setETCData("cust_cnt_cd", mdmOrganizationVO.getRepCustCntCd());
//		} catch(EventException ex) {
//			throw ex;
//		} catch(Exception ex) {
//			log.error("err " + ex.toString(), ex);
//			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
//		}
//        return eventResponse;
//
//    }


    /**
     * ESM_BKG_0001 : Search Notice Sent History<br>
     * Bkg Notice History를 이용하여 Inbound Arrival Notice 정보를 추출한다.<br>
     *  @author Park Mangeon
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
    private EventResponse searchBkgNtcHis(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            EsmBkg0001Event event = (EsmBkg0001Event )e;

            // 검색조건
            BkgNtcSearchVO bkgNtcSearch = event.getBkgNtcSearchVO();

            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
	        List<NoticeVO> list = command.searchBkgNtcHis(bkgNtcSearch);
	        eventResponse.setRsVoList(list);

		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
        return eventResponse;

    }

    /**
     * ESM_BKG_0414 : Search Pick-Up Notice Sent History<br>
     * Pick-up Notice Sent  History를 조회한다.<br>
     * @author Park Mangeon
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
    private EventResponse searchPkupNtcSentHistory(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            EsmBkg0414Event event = (EsmBkg0414Event )e;

            // 검색조건
            PkupNtcSentHisSchVO pkupNtcSentHisSch = event.getPkupNtcSentHisSchVO();

            PickUpNoticeBC command = new PickUpNoticeBCImpl();
	        List<PkupNtcSentHisListVO> list = command.searchPkupNtcSentHistory(pkupNtcSentHisSch);
	        eventResponse.setRsVoList(list);

		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
        return eventResponse;

    }

    /**
     * [1021] Bank In Account No Setup for A/N<br>
     * Search<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author Son YunSeuk
     */
    private EventResponse searchArrNtcBankAcct(Event e) throws EventException
    {
        // TODO Auto-generated method stub
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try
        {
            EsmBkg1021Event event = (EsmBkg1021Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            BkgArrNtcWdVO arrNtcBankAcctVO = event.getBkgArrNtcWdVO();
            BkgArrNtcWdVO resultSearch = command.searchArrNtcBankAcct(arrNtcBankAcctVO.getOfcCd());
            eventResponse.setRsVo(resultSearch);

            if(resultSearch != null)
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
     * [1021] Bank In Account No Setup for A/N<br>
     * Update<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author Son YunSeuk
     */
    private EventResponse setupArrNtcBankAcct(Event e) throws EventException
    {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try
        {
        	EsmBkg1021Event event = (EsmBkg1021Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            BkgArrNtcWdVO arrNtcBankAcctVO = event.getBkgArrNtcWdVO();
            begin();
            command.setupArrNtcBankAcct(arrNtcBankAcctVO, account);
            commit();
            eventResponse.setETCData("status", "ok");
        } catch(EventException ex) {
            rollback();
            throw ex;
        }catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * [1021] Bank In Account No Setup for A/N<br>
     * Delete<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author Son YunSeuk
     */
    private EventResponse removeArrNtcBankAcct(Event e) throws EventException
    {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        try
        {
        	EsmBkg1021Event event = (EsmBkg1021Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            BkgArrNtcWdVO arrNtcBankAcctVO = event.getBkgArrNtcWdVO();
            begin();
            command.removeArrNtcBankAcct(arrNtcBankAcctVO.getOfcCd());
            commit();
            eventResponse.setETCData("status", "ok");
        } catch(EventException ex) {
            rollback();
            throw ex;
        }catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * [1020] Group A/N Remark Template<br>
     * Group Arrival Notice Remark Template Search<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author Son YunSeuk
     */
    private EventResponse searchArrNtcGrpForm(Event e) throws EventException
    {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        try
        {
        	EsmBkg1020Event event = (EsmBkg1020Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            BkgArrNtcWdVO bkgArrNtcWdVO = event.getArrNtcWdVO();
            List<BkgArrNtcWdVO> list = command.searchArrNtcGrpForm(bkgArrNtcWdVO.getOfcCd());

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
     * [1020] Group A/N Remark Template<br>
     * Group Arrival Notice Remark Template Setup
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author Son YunSeuk
     */
    private EventResponse setupArrNtcGrpForm(Event e) throws EventException
    {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try
    	{
    		EsmBkg1020Event event = (EsmBkg1020Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
            BkgArrNtcWdVO[] bkgArrNtcWdVOs = event.getArrNtcWdVOs();

    		begin();
    		command.setupArrNtcGrpForm(bkgArrNtcWdVOs, account);
    		commit();
    		eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
    	} catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
        }
        return eventResponse;

    }


    /**
     * [1044] Add Concerned Party Pop-up
     * search
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author Son YunSeuk
     */
    private EventResponse searchCustCmdtCntcInfo(Event e)throws EventException
    {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        try
        {
        	EsmBkg1044Event event = (EsmBkg1044Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            BkgIbCmdtCntcVO bkgIbCmdtCntcVO = event.getBkgIbCmdtCntcVO();
            List<BkgIbCmdtCntcVO> resultSearch = command.searchCustCmdtCntcInfo(account.getOfc_cd()
            		                                                                  , bkgIbCmdtCntcVO.getCustCntCd()
            		                                                                  , bkgIbCmdtCntcVO.getCustSeq()
            		                                                                  , bkgIbCmdtCntcVO.getCustCntcTpCd());


            eventResponse.setRsVoList(resultSearch);


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
     * [1044] Add Concerned Party Pop-up
	 * Insert, Update, Delete
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author Son YunSeuk
     */
    private EventResponse manageCustCmdtCntcInfo(Event e) throws EventException
    {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try
    	{
    		EsmBkg1044Event event = (EsmBkg1044Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
            //by 박성호 , 2009.08.07 사용하지 않는 변수 주석처리
            //BkgIbCmdtCntcVO bkgIbCmdtCntcVO = event.getBkgIbCmdtCntcVO();

            BkgIbCmdtCntcVO[] bkgIbCmdtCntcVOs = event.getBkgIbCmdtCntcVOs();
           	begin();

           	command.manageCustCmdtCntcInfo(bkgIbCmdtCntcVOs, account);


           	commit();
          //에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
    	} catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }


	/**
	 * ESM_BKG_1058 : Retrieve<br>
	 * Pick-up Notice에 기입될 Port(POD), Rail Destination Location, DEL기준으로 Office별로 Empty Return CY코드를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPkupMtRtnCy(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1058Event event = (EsmBkg1058Event)e;
		PickUpNoticeBC command = new PickUpNoticeBCImpl();

		try{
			List<BkgPkupCntrRtnYdVO> list = command.searchPkupMtRtnCy(event.getPkupCntrRtnYdVO());
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
	 * ESM_BKG_1058 : Save<br>
	 * Pick-up Notice에 기입될 Port(POD), Rail Destination Location, DEL기준으로 Office별로 Empty Return CY코드를 등록, 수정,삭제한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse setupPkupMtRtnCy(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1058Event event = (EsmBkg1058Event)e;
		PickUpNoticeBC command = new PickUpNoticeBCImpl();
		try{
			begin();
			command.setupPkupMtRtnCy(event.getBkgPkupCntrRtnYdVOS(),account);
			//eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00167").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1058 : Validation<br>
	 * PICKUP NOTICE 발송시 사용할 EMPTY CONTAINER Return Yard및 Location 코드 등록 혹은 수정 시 Validation 체크 작업을 수행한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkPkupMtRtnCy(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1058Event event = (EsmBkg1058Event)e;
		PickUpNoticeBC command = new PickUpNoticeBCImpl();

		try{
			String chkTp = event.getChkTp();
			String locCd = event.getLocCd();

			command.checkPkupMtRtnCy(chkTp, locCd);

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
	 * ESM_BKG_0511 : POD Search<br>
	 * 기 등록된 Hold Notice Form화면에 POD 목록 정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHldNtcFormPodList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0511Event event = (EsmBkg0511Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();

		try{
			String ofcCd   = event.getOfcCd();
			String ntcTpCd = event.getNtcTpCd();

			List<BkgHldWdVO> list = command.searchHldNtcFormPodList(ofcCd, ntcTpCd);
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
	 * ESM_BKG_0511 : Search<br>
	 * Hold Notice 전송방식과 내용에 따른 Form Setup정보를 조회한다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHldNtcPreForm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0511Event event = (EsmBkg0511Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();

		try{
			String ofcCd = event.getOfcCd();
			String podCd = event.getPodCd();

			HoldNoticeFormVO vo = command.searchHldNtcPreForm(ofcCd, podCd);

            eventResponse.setRsVo(vo.getBkgHldWd());
            eventResponse.setRsVoList(vo.getBkgHldWdDtls());

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
	 * ESM_BKG_0511 : Save<br>
	 * Hold Notice ( Pre-Hold & Confirm-Hold)의 Hold Code별 Form정보를 저장 or수정한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse setupHldNtcPreForm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0511Event event = (EsmBkg0511Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();
		try{
			begin();
			command.setupHldNtcPreForm(event.getBkgHldWdVO(), event.getBkgHldWdDtlVOs(), account);
			//eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00110", new String[]{"Save"}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0511 : Delete<br>
	 * 특정 Location별로 등록된 H/N Form Master정보를 삭제한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeHldNtcForm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0511Event event = (EsmBkg0511Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();
		try{

			begin();

			String ofcCd   = event.getOfcCd();
			String podCd   = event.getPodCd();
			String ntcTpCd = event.getNtcTpCd();

			command.removeHldNtcForm(ofcCd, podCd, ntcTpCd);

			commit();

		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG04011").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1002 : 중복 체크<br>
	 * 기 입력된 Pre-Hold Notice Setup 정보를 Check한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkHldNtcFormExist(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1002Event event = (EsmBkg1002Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();

		try {
            boolean bResult = command.checkHldNtcFormExist(event.getOfcCd(),
										                   event.getPodCd(),
										                   event.getNtcTpCd());

            if (bResult == true) eventResponse.setETCData("exist", "yes");
            else eventResponse.setETCData("exist", "no");

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
	 * ESM_BKG_1002 : Copy<br>
	 * 기 입력된 Pre-Hold Notice Setup 정보를 Copy한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse copyHldNtcPreForm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1002Event event = (EsmBkg1002Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();

		try{
			begin();
			command.copyHldNtcPreForm(event.getOfcCd(),
					                  event.getPodCd(),
					                  event.getFmOfcCd(),
					                  event.getFmPodCd(),
					                  event.getNtcTpCd(),
					                  account);
			//eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00110", new String[]{"Copy"}).getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * ESM_BKG_0510 : Retrieve<br>
	 * 세관 EDI정보에서 Hold정보를 자동  인식해서 발송된 Pre-Hold Notice내역 정보를 조회한다. (미주지역만 해당)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHldNtcSendListByPre(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0510Event event = (EsmBkg0510Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();

		try{
			List<PreHldNtcSendListVO> list = command.searchHldNtcSendListByPre(event.getHldNtcSearchVO());
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
	 * ESM_BKG_0510_01 : Retrieve<br>
	 * 세관 EDI정보에서 Hold에 대한 Clear(Confirm) Event가 발생한 대상 정보를 조화한다.( 미주지역만 해당)<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHldNtcSendListByConfirm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0510Event event = (EsmBkg0510Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();

		try{
			List<ConfirmHldNtcSendListVO> list = command.searchHldNtcSendListByConfirm(event.getHldNtcSearchVO());
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
	 * ESM_BKG_0510 : Fax<br>
	 * 세관 EDI정보에서 발생한 Hold ( Pre or Confirm)정보를 인식해서 Manual로 담당자가 Fax로 Hold Notice를 발송한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendPreHldNtcByFax(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0510Event event = (EsmBkg0510Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();

        try{

        	String uiId = "ESM_BKG_0510";

            begin();
            /* 1. Send Notice */
            List<BkgNtcHisVO> bkgNtcHisVOs = command.sendPreHldNtcByFax(event.getPreHldNtcSendListVOs(), account);
            /* 2. Register Notice History */
			bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, uiId);
            eventResponse.setUserMessage(new ErrorHandler("BKG40053").getUserMessage());
            commit();

		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00242").getMessage(), ex);
		}

        return eventResponse;
	}


	/**
	 * ESM_BKG_0510 : Email<br>
	 * 세관 EDI정보에서 발생한 Hold ( Pre or Confirm)정보를 인식해서 Manual로 담당자가 Email로 Hold Notice를 발송한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendPreHldNtcByEmail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0510Event event = (EsmBkg0510Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();

        try{

        	String uiId = "ESM_BKG_0510";

            begin();
            /* 1. Send Notice */
            List<BkgNtcHisVO> bkgNtcHisVOs =
            	command.sendPreHldNtcByEmail(event.getPreHldNtcSendListVOs(),
                                             account);
            /* 2. Register Notice History */
			bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, uiId);
            eventResponse.setUserMessage(new ErrorHandler("BKG40054").getUserMessage());
            commit();

		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00243").getMessage(), ex);
		}

        return eventResponse;
	}



	/**
	 * ESM_BKG_0510 : Preview<br>
	 * 기 입력된 Hold Notice Setup 정보를 Check한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkHldNtcFormExistByNtcType(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0510Event event = (EsmBkg0510Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();

		try {
            boolean bResult =
            	command.checkHldNtcFormExistByNtcType(event.getOfcCd(), event.getPodCd(), event.getHldNtcTpCd());

            if (bResult == true) eventResponse.setETCData("exist", "yes");
            else eventResponse.setETCData("exist", "no");

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
	 * 	테스트용!!!
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createCstmsHld(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0510Event event = (EsmBkg0510Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();

		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();

        try{

        	String uiId = "ESM_BKG_0510-01";

        	begin();
        	command.sendAmsNtcToObStaff(event.getCstmsHldVO());

            /* 1. Send Notice */
            List<BkgNtcHisVO> bkgNtcHisVOs = command.createCstmsHld(event.getCstmsHldVO());
            /* 2. Register Notice History */
			bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, uiId);

            commit();

		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
		}

        return eventResponse;
	}

	/**
	 * ESM_BKG_0510 : Fax<br>
	 * 세관 EDI정보에서 발생한 Hold ( Pre or Confirm)정보를 인식해서 Manual로 담당자가 Fax로 Hold Notice를 발송한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendConfirmHldNtcByFax(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0510Event event = (EsmBkg0510Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();

        try{

        	String uiId = "ESM_BKG_0510-01";

            begin();
            /* 1. Send Notice */
            List<BkgNtcHisVO> bkgNtcHisVOs = command.sendConfirmHldNtcByFax(event.getConfirmHldNtcSendListVOs(), account);
            /* 2. Register Notice History */
			bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, uiId);
            eventResponse.setUserMessage(new ErrorHandler("BKG40053").getUserMessage());
            commit();

		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00242").getMessage(), ex);
		}

        return eventResponse;
	}


	/**
	 * ESM_BKG_0510 : Email<br>
	 * 세관 EDI정보에서 발생한 Hold ( Pre or Confirm)정보를 인식해서 Manual로 담당자가 Email로 Hold Notice를 발송한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendConfirmHldNtcByEmail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0510Event event = (EsmBkg0510Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();

        try{

        	String uiId = "ESM_BKG_0510-01";

            begin();
            /* 1. Send Notice */
            List<BkgNtcHisVO> bkgNtcHisVOs =
            	command.sendConfirmHldNtcByEmail(event.getConfirmHldNtcSendListVOs(),
            			                         account);
            /* 2. Register Notice History */
			bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, uiId);
            eventResponse.setUserMessage(new ErrorHandler("BKG40054").getUserMessage());
            commit();

		}catch(EventException ex){
			rollback();
			//log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			//log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00243").getMessage(), ex);
		}

        return eventResponse;
	}

	/**
	 * ESM_BKG_0760 : Retrieve<br>
	 * Confirm Hold Notice 전송방식과 내용에 따른 Form Setup정보를 조회한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHldNtcConfirmForm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0760Event event = (EsmBkg0760Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();

		try{
			String ofcCd = event.getOfcCd();
			String podCd = event.getPodCd();

			HoldNoticeFormVO vo = command.searchHldNtcConfirmForm(ofcCd, podCd);

            eventResponse.setRsVo(vo.getBkgHldWd());
            eventResponse.setRsVoList(vo.getBkgHldWdDtls());

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
	 * ESM_BKG_0760 : Save<br>
	 * Hold Notice ( Pre-Hold & Confirm-Hold)의 Hold Code별 Form정보를 저장 or수정 or 삭제한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse setupHldNtcConfirmForm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0760Event event = (EsmBkg0760Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();

		try{
			begin();
			command.setupHldNtcConfirmForm(event.getBkgHldWdVO(), event.getBkgHldWdDtlVOs(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00167").getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1063 : Retrieve<br>
	 * Pick-up No를 수동으로 업로드하기 위해 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPkupNoMnlUpldList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1063Event event = (EsmBkg1063Event)e;
		PickUpNoticeBC command = new PickUpNoticeBCImpl();

		try{
			List<PkupNoMnlUpldVO> list = command.searchPkupNoMnlUpldList(event.getPkupNoMnlUpldSearchVO());
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
	 * ESM_BKG_1063 : Save<br>
	 * 수동으로 입력된 Pick-up No및 부가 정보 저장<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePkupNoMnlUpldList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1063Event event = (EsmBkg1063Event)e;
		PickUpNoticeBC command = new PickUpNoticeBCImpl();

		try{

			begin();
			command.managePkupNoMnlUpldList(event.getPkupNoMnlUpldVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();

		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}



	/**
	 * ESM_BKG_1063 : Batch<br>
	 *  <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private GeneralEventResponse executePickupSetting(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PickUpNoticeBC command = new PickUpNoticeBCImpl();

        try {

            begin();
            String jobId = command.executeBatch("ESM_BKG_B012", "");
            eventResponse.setETCData("JOB_ID", jobId);
            commit();

		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

        return eventResponse;
    }


	/**
	 * ESM_BKG_1063 : Batch Monitor <br>
	 *  <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private GeneralEventResponse monitorPickupSetting(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1063Event event = (EsmBkg1063Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();

        try {

            String jobStatus = command.getBatchStatus(event.getJobId(), "ESM_BKG_B012");
            eventResponse.setETCData("BATCH_STATUS", jobStatus);

		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

        return eventResponse;
    }


	/**
	 * ESM_BKG_1063 : Batch Running Status <br>
	 *  <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private GeneralEventResponse isRunningBatch(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1063Event event = (EsmBkg1063Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();

        try {

            boolean status = command.isRunningBatch(event.getBatchCd());

            if (status == true) {
                eventResponse.setETCData("BATCH_STATUS", "true");
            } else {
                eventResponse.setETCData("BATCH_STATUS", "false");
            }

		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

        return eventResponse;
    }


	/**
	 * ESM_BKG_1064 : File Import<br>
	 * 철도 회사로 부터 받은 e-mail Report를 분석하여 pick up No upload 관련 정보 추출<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchParsedPkupNoRpt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1064Event event = (EsmBkg1064Event)e;
		PickUpNoticeBC command = new PickUpNoticeBCImpl();

		try{
			List<PkupNoRptVO> list = command.searchParsedPkupNoRpt(event.getPkupNoRptEmlUpldVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1064 : Verify<br>
	 * 철송 회사로 부터 e-mail을 받은 pick-up No upload 결과를 검증(Verify) 한다<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPkupNoVerifyRpt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1064Event event = (EsmBkg1064Event)e;
		PickUpNoticeBC command = new PickUpNoticeBCImpl();

		try{
			PkupNoVerifyVO pkupNtcVerifyVO = command.searchPkupNoVerifyRpt(event.getPkupNoRptVOs());

			List<PkupNoRptVO> list = pkupNtcVerifyVO.getPkupNoRptVOs();
			List<PkupNoMnlUpldVO> upList = pkupNtcVerifyVO.getPkupNoMnlUpldVOs();
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(upList);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1067 : Open<br>
	 * Pick-up No를 수동으로 업로드하기 위해 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPkupNoHisList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1067Event event = (EsmBkg1067Event)e;
		PickUpNoticeBC command = new PickUpNoticeBCImpl();

		try{
			List<BkgPkupNtcPkupNoHisVO> list = command.searchPkupNoHisList(event.getBkgNo(),
					                                                       event.getCntrNo(),
					                                                       event.getOfcCd());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * ESM_BKG_1068 : Retrieve<br>
	 * [비즈니스대상]을 [행위]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTpbInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1068Event event = (EsmBkg1068Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();

		try{
			List<TpbInfoVO> list = command.searchTpbInfo(event.getBkgNo(),
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
	 * ESM_BKG_1063 : Save<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse setupTpbInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1068Event event = (EsmBkg1068Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();

		try{
			begin();
			command.setupTpbInfo(event.getTpbInfoVOs(), account);
			//eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00110", new String[]{"Save"}).getMessage(), ex);
		}
		return eventResponse;
	}


	/**[672-02]
	 * Customer Info 정보를 조회한다.
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchArrNtcCustList(Event e) throws EventException {
		EsmBkg0672Event event = (EsmBkg0672Event)e;
		ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
		//ArrivalNoticeBCImpl_Sub1 command = null;
        // 검색조건
        ArrNtcSearchVO search = event.getArrNtcSearchVO();
        search.setOfcCd(account.getOfc_cd());
        //log.debug("-------------------- search.getOfcCd()   "+search.getOfcCd());

        //log.debug("------------------- "+ search.getColumnValues());
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
	        List<ArrNtcCustListVO> list = command.searchArrNtcCustList(search,getSignOnUserAccount());

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
	 * [0381] 사용될 RD ID 정보를 구한다.
	 * @param e
	 * @return EventResponse
	 */
	private EventResponse searchArrNtcMrdId(Event e) throws EventException{
		//MailSendTest test = new MailSendTest();
		//test.sendReportDesignerWithFiles();
		log.debug("0381 조회 SC 시작");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0381Event event = (EsmBkg0381Event) e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
        try{
	        ArrNtcMrdSearchVO arrNtcMrdSearch = event.getArrNtcMrdSearch();
	        arrNtcMrdSearch.setUsrId(account.getUsr_id());
	        arrNtcMrdSearch.setOfcCd(account.getOfc_cd());
	        ArrNtcMrdVO list = command.searchArrNtcMrdId(arrNtcMrdSearch);

	        String mrdId = "";
	        String loclLangFlg = "";
	        String comParam  ="";
	        String arrPrvFomCd  ="";

	        log.debug("------------- list "+list);

	        if(list != null && list.getMrdId() != null && !list.getMrdId().equals("")){
	        	mrdId = list.getMrdId();
	        	loclLangFlg = list.getLoclLangFlg();
	        	comParam = list.getComParam();
	        	arrPrvFomCd = list.getArrPrvFomCd();
	        }

	        eventResponse.setETCData("MRD_ID", mrdId);
	        eventResponse.setETCData("LOCL_LANG_FLG", loclLangFlg);
	        eventResponse.setETCData("COM_PARAM", comParam);//공통 파라미터
	        eventResponse.setETCData("ARR_PRV_FOM_CD", arrPrvFomCd);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        //eventResponse.setRsVoList(list);
        return eventResponse;
	}


	/**
     * [0052]<br>
     * MRN & Return yard 정보를 조회한다.
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
	private EventResponse searchArrNtcMrnRtnYd(Event e) throws EventException {
		log.debug("0052 조회 SC 시작");
        EsmBkg0052Event event = (EsmBkg0052Event) e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

        String vvd = event.getMrnRtnYdVO().getVvd();
        String podCd = event.getMrnRtnYdVO().getPodCd();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
        	List<MrnRtnYdVO> list = command.searchArrNtcMrnRtnYd(vvd, podCd);


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
     * [0052]
     * MRN & Return yard 정보를 저장한다.
     * @param e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse setupArrNtcMrnRtnYd(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
        	begin();
            EsmBkg0052Event event = (EsmBkg0052Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            MrnRtnYdVO[] mrnRtnYdVOS = event.getMrnRtnYdVOs();
            String vvd = event.getMrnRtnYdVO().getVvd();
            for(int i=0;i<mrnRtnYdVOS.length;i++){
            	MrnRtnYdVO vo = mrnRtnYdVOS[i];
            	vo.setVvd(vvd);
            	mrnRtnYdVOS[i] = vo;
            }
            command.setupArrNtcMrnRtnYd(mrnRtnYdVOS,e.getSignOnUserAccount());

            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * [672-1] Update Arrival Data 를 수정한다.
     * BC 호출
     * @param e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse setupArrNtcInfoList(Event e) throws EventException {
    	// PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0672Event event = (EsmBkg0672Event)e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
        try{
        	long startTime = System.currentTimeMillis();
            begin();
            //event.getArrNtcFomStupVOS()
            //ArrNtcFormVO[] arrNtcFormVO = event.getArrNtFormVOS();
            //BkgArrNtcVO[] bkgArrNtcVOS = event.getBkgArrNtcVOS();
            //BkgArrNtcVO[] vos = event.getVos();
            ArrNtcInfoListVO[] arrNtcInfos = event.getArrNtcInfos();

            //command.setupArrNtcInfo(bkgArrNtcVOS,account);
            command.setupArrNtcInfoList(arrNtcInfos, account);

            //eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
            commit();
            long endTime = System.currentTimeMillis();

			log.debug("--------- 실행시간 " + ((endTime-startTime)/1000));
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * [672-2] Customer Info를 수정한다.
     * BC 호출
     * @param e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse modifyArrNtcCustList(Event e) throws EventException {
        // TODO Auto-generated method stub
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try {

        	begin();
            EsmBkg0672Event event = (EsmBkg0672Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            ArrNtcCustListVO[] arrNtcCustListVOS = event.getArrNtcCustListVOS();
//
//            command.modifyArrNtcCustList(arrNtcCustListVOS, e.getSignOnUserAccount());
//
//            GeneralBookingReceiptBC cmd1 = new GeneralBookingReceiptBCImpl();
//            cmd1.modifyArrNtcCustChgFlg(arrNtcCustListVOS);

            // BackEnd
            String key = command.startBackEndJob(account, arrNtcCustListVOS, "ESM_BKG_0672");
            eventResponse.setETCData("KEY", key);
            log.debug("############################ key:"+key);
            eventResponse.setUserMessage(new ErrorHandler("BKG00218").getMessage());


            commit();

        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
        }
        return eventResponse;
    }
    /**
     * [672-3] Upload Match 정보를 조회한다.
     * @param e
     * @return EventResponse
     */
    private EventResponse searchArrNtcCustListForUpload(Event e)
			throws EventException {
    	List<ArrNtcCustUploadListVO> list = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EsmBkg0672Event event = (EsmBkg0672Event) e;
		ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
		try{
			list = command.searchArrNtcCustListForUpload(event.getArrNtcSearchVO());
		} catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }

        eventResponse.setRsVoList(list);
		return eventResponse;
	}

    /**
     * [672-3] Upload_Match 정보를 수정한다.
     * BC 호출
     * @param e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse createArrNtcCustListbyUpload(Event e) throws EventException {
        // TODO Auto-generated method stub
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
        	begin();
            EsmBkg0672Event event = (EsmBkg0672Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            ArrNtcCustUploadListVO[] vos = event.getArrNtcCustUploadListVOS();
            //BkgArrNtcDtlVO[] nVos = new BkgArrNtcDtlVO[vos.length];


    		for(int i=0;i<vos.length;i++){
    			ArrNtcCustUploadListVO  arrNtcCustUploadListVO = vos[i];
    			BkgArrNtcDtlVO nVo = new BkgArrNtcDtlVO();
    			nVo.setBkgNo(arrNtcCustUploadListVO.getBkgNo());
    			nVo.setBkgCustTpCd(arrNtcCustUploadListVO.getBkgCustTpCd());

    			//1.cust_cntc_tp_cd = C2
    			nVo.setCustCntcTpCd("C2");
    			nVo.setFaxNo(arrNtcCustUploadListVO.getFaxNo1());
    			nVo.setNtcEml(arrNtcCustUploadListVO.getNtcEml1());
    			//nVos[i] = nVo;
    			command.createArrNtcCustListbyUpload(nVo, account);

    			//2.cust_cntc_tp_cd = B1
    			nVo.setCustCntcTpCd("B1");
    			nVo.setFaxNo(arrNtcCustUploadListVO.getFaxNo2());
    			nVo.setNtcEml(arrNtcCustUploadListVO.getNtcEml2());
    			//nVos[i] = nVo;
    			command.createArrNtcCustListbyUpload(nVo, account);


    			//3.cust_cntc_tp_cd = B2
    			nVo.setCustCntcTpCd("B2");
    			nVo.setFaxNo(arrNtcCustUploadListVO.getFaxNo3());
    			nVo.setNtcEml(arrNtcCustUploadListVO.getNtcEml3());
    			//nVos[i] = nVo;
    			command.createArrNtcCustListbyUpload(nVo, account);

    		}


            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());


            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            // BKG00110 : 작업이 실패하였습니다. (입력,수정,삭제)
            throw new EventException(new ErrorHandler("BKG00167").getMessage(), ex);
        }
        return eventResponse;
    }



//	    /**[243] 저장
//	     * 1.수정작업만을 한다.
//	     * 2.code validation 이 되지 않은 데이터는 수정화면 자체가 안뜬다.
//	     * @param e
//	     * @return
//	     * @exception EventException
//	     */
//	    public EventResponse setupArrNtcInfo(Event e) throws EventException {
//	        // PDTO(Data Transfer Object including Parameters)
//	        GeneralEventResponse eventResponse = new GeneralEventResponse();
//	        EsmBkg0243Event event = (EsmBkg0243Event)e;
//	        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
//	        try{
//	            begin();
//	            //event.getArrNtcFomStupVOS()
//	            //ArrNtcFormVO[] arrNtcFormVO = event.getArrNtFormVOS();
//	            BkgArrNtcVO[] bkgArrNtcVOS = event.getBkgArrNtcVOS();
//
//	            command.setupArrNtcInfo(bkgArrNtcVOS,account);
//
//	            //eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
//	            commit();
//	        }catch(Exception ex) {
//	        	rollback();
//	        	eventResponse.setUserMessage(new ErrorHandler("BKG00110").getUserMessage());
//	        }
//	        return eventResponse;
//	    }

    /**[243] AN Setup Screen_Arrival Info. Setup에서<br>
     * 그룹핑된 VVD/POD별 입력되는 문구와 정보를 조회한다.
     * @param e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchArrNtcFormDtl(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0243Event event = (EsmBkg0243Event)e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();


        String ofcCd = event.getOfcCd();
        String podCd = event.getPodCd();
        String anFomCd = event.getAnFomCd();
        String agent = event.getAgent();

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
        	List<BkgArrNtcWdDtlVO> arrNtcWdDtlVOS = command.searchArrNtcFormDtl(ofcCd,podCd,anFomCd,agent);
        	eventResponse.setRsVoList(arrNtcWdDtlVOS);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }

//	        BkgArrNtcWdVO aryBkgArrNtcWdVO = event.getArrNtcFomStupVO().getBkgArrNtcWdVO();
//
//	        String anTpCd = aryBkgArrNtcWdVO.getAnTpCd();
//	        String ofcCd = aryBkgArrNtcWdVO.getOfcCd();
//	        String podCd = aryBkgArrNtcWdVO.getPodCd();
//	        String chnAgnCd = aryBkgArrNtcWdVO.getChnAgnCd();
//
//	        List<ArrNtcFormVO> arrNtcFormVO= command.searchArrNtcForm(anTpCd, ofcCd, podCd, chnAgnCd);

        // doc_fom_rmk_dtl을 xml로 변환한다.





        return eventResponse;
    }

    /**[0381] A/N Setting 화면에서 기 Setting된 A/N 발송 대상 정보 및 기 송부실행이 완료된 History를  EDI로 검색한다.
     * @param e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchArrNtcSendList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
	   	EsmBkg0381Event event = (EsmBkg0381Event)e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        try{

	        List<ArrNtcSendListVO> listVOS = null;

	        log.info("ischeck:::"+event.getSearchVO().getIsCheck());

	        if("E".equals(event.getSearchVO().getIsCheck())){
	        	log.info("test!!!!!!!!!!!!");
	            listVOS = command.searchArrNtcSendListByEdi(event.getSearchVO(),account);
	        }else{
	        	listVOS = command.searchArrNtcSendList(event.getSearchVO(),account);
	        }
	        // doc_fom_rmk_dtl을 xml로 변환한다.

	        eventResponse.setRsVoList(listVOS);
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
    * [0381] Fax를 전송한다.
    * @param e
    * @return EventResponse
    * @exception EventException
    */
   private EventResponse sendArrNtcByFax(Event e) throws EventException{
	   GeneralEventResponse eventResponse = new GeneralEventResponse();
	   EsmBkg0381Event event = (EsmBkg0381Event)e;
	   ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
	   BookingHistoryMgtBC hisBC = new BookingHistoryMgtBCImpl();
	   ArrNtcSendListVO[] listVOS = event.getListVOS();

	   try {
		   String uiId = "ESM_BKG_0381";

		   begin();
		   List<BkgNtcHisVO> hisVOS = command.sendArrNtcByFax(listVOS, account);

		   GeneralBookingReceiptBC cmd1 = new GeneralBookingReceiptBCImpl();

		   //2010.03.20 CHG_DP_FLG 정보를 휘발성이 아닌 수정으로(심K요청)
		   ArrNtcCustListVO[] arrNtcCustListVOS = new ArrNtcCustListVO[listVOS.length];
		   for(int i=0;i<listVOS.length;i++){
			   arrNtcCustListVOS[i] = new ArrNtcCustListVO();
			   arrNtcCustListVOS[i].setBkgNo(listVOS[i].getBkgNo());
			   arrNtcCustListVOS[i].setChgDpFlg(listVOS[i].getChgDpFlg());
			   arrNtcCustListVOS[i].setBkgCustTpCd(listVOS[i].getBkgCustTpCd());
		   }
		   cmd1.modifyArrNtcCustChgFlg(arrNtcCustListVOS);

		   hisBC.createBkgNtcHis(hisVOS, uiId);
		   eventResponse.setUserMessage(new ErrorHandler("BKG40053").getUserMessage());
		   commit();
	   }catch(Exception ex) {
           log.error("err " + ex.toString(), ex);
        	rollback();
        	//eventResponse.setUserMessage(new ErrorHandler("BKG00110").getUserMessage());
        	String[] msg = new String[]{"Arrival Notice"};
        	throw new EventException(new ErrorHandler("BKG40035",msg).getMessage());
        }
        return eventResponse;
   }

   /**
    * [0381] Email을 전송한다.
    * @param e
    * @return EventResponse
    * @exception EventException
    */

   private EventResponse sendArrNtcByEmail (Event e) throws EventException{
	   GeneralEventResponse eventResponse = new GeneralEventResponse();
	   EsmBkg0381Event event = (EsmBkg0381Event)e;
	   ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
	   BookingHistoryMgtBC hisBC = new BookingHistoryMgtBCImpl();
	   ArrNtcSendListVO[] listVOS = event.getListVOS();

	   try {
		   String uiId = "ESM_BKG_0381";

		   begin();
		   List<BkgNtcHisVO> hisVOS = command.sendArrNtcByEmail(listVOS, account);

		 //2010.03.20 CHG_DP_FLG 정보를 휘발성이 아닌 수정으로(심K요청)
		   /*
		    * 불필요한 소스 제거 2015.08.20
		   ArrNtcCustListVO[] arrNtcCustListVOS = new ArrNtcCustListVO[listVOS.length];
		   for(int i=0;i<listVOS.length;i++){
			   arrNtcCustListVOS[i] = new ArrNtcCustListVO();
			   arrNtcCustListVOS[i].setBkgNo(listVOS[i].getBkgNo());
			   arrNtcCustListVOS[i].setChgDpFlg(listVOS[i].getChgDpFlg());
			   arrNtcCustListVOS[i].setBkgCustTpCd(listVOS[i].getBkgCustTpCd());
		   }
		   */
		   hisBC.createBkgNtcHis(hisVOS, uiId);
		   eventResponse.setUserMessage(new ErrorHandler("BKG40054").getUserMessage());
		   commit();

	   }catch(EventException ex) {
           throw ex;
       }catch(Exception ex) {
        	rollback();
        	String[] msg = new String[]{"Arrival Notice"};
        	throw new EventException(new ErrorHandler("BKG40036",msg).getMessage());
        }
        return eventResponse;
   }

   /**
    * [0381] Edi를 전송한다.
    * @param e Event
    * @return EventResponse
    * @exception EventException
    */
   private EventResponse sendArrNtcByEdi(Event e) throws EventException{
	   log.info("sendArrNtcByEdi is call!!");
	   GeneralEventResponse eventResponse = new GeneralEventResponse();
	   EsmBkg0381Event event = (EsmBkg0381Event)e;
	   ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
	   BookingHistoryMgtBC hisBC = new BookingHistoryMgtBCImpl();
	   ArrNtcSendListVO[] listVOS = event.getListVOS();
	   List<ArrNtcSendListVO> arrNtcSendListVOS = new ArrayList<ArrNtcSendListVO>();

	   try {

		   String uiId = "ESM_BKG_0381";

		   begin();

		   for(int i=0; i<listVOS.length; i++){
			   arrNtcSendListVOS.add(listVOS[i]);
		   }

		   List<BkgNtcHisVO> hisVOS = command.sendArrivaNoticeEdi(arrNtcSendListVOS,"N", account);



		   hisBC.createBkgNtcHis(hisVOS, uiId);
		   eventResponse.setUserMessage(new ErrorHandler("BKG43053").getUserMessage());
		   commit();
	   }catch(Exception ex) {
           log.error("err " + ex.toString(), ex);
        	rollback();
        	String[] msg = new String[]{"Arrival Notice"};
        	throw new EventException(new ErrorHandler("BKG43051",msg).getMessage());
        }
        return eventResponse;
   }

   /**
     * [0956]Arrival Notice Hold Remark 조회 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
   private EventResponse searchArrNtcHldRmk (Event e) throws EventException {
		log.debug("0956 조회 SC 시작");
        EsmBkg0956Event event = (EsmBkg0956Event) e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        String bkgNo = event.getSearchVO().getBkgNo();
        //String podCd = event.getMrnRtnYdVO().getPodCd();
        try{
	        List<BkgArrNtcCntrVO> list = command.searchArrNtcHldRmk(bkgNo);


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
     * [0956]Arrival Notice Hold Remark 저장
     * @param e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse setupArrNtcHldRmk (Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
        	begin();
            EsmBkg0956Event event = (EsmBkg0956Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            BkgArrNtcCntrVO[] vos = event.getListVOS();

            command.setupArrNtcHldRmk (vos,e.getSignOnUserAccount());
            commit();

        } catch(EventException ex){
            rollback();
            throw new EventException(new ErrorHandler("BKG00110").getMessage());
        } catch (Exception ex) {
			// TODO Auto-generated catch block
			rollback();
            throw new EventException(new ErrorHandler("BKG00110").getMessage());
		}
        return eventResponse;
    }
	   /**
     * [0946]Group A/N Merge Pop-up 조회 이벤트 처리<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
	private EventResponse searchArrNtcGrpSendList(Event e) throws EventException {
		log.debug("0946 조회 SC 시작");
        EsmBkg0946Event event = (EsmBkg0946Event) e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
        	List<ArrNtcGrpSendListVO> list = command.searchArrNtcGrpSendList(event.getSearchVO());
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
	 * [0946] Preview Group 정보를 Preview 한다.
	 * @param e
	 * @return EventResponse
	 */
//	private EventResponse searchArrNtcGrpPreview (Event e) throws EventException {
//		log.debug("0946 조회 SC 시작");
//        EsmBkg0946Event event = (EsmBkg0946Event) e;
//		ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
//		ArrNtcGrpSendListVO[] arrNtcGrpSendLists = event.getListVOS();
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		String grpNtcSeq = "";
//		try {
//			begin();
//
//			grpNtcSeq = command.searchArrNtcGrpPreview(arrNtcGrpSendLists,
//					event.getSignOnUserAccount());
//			commit();
//			eventResponse.setETCData("grpNtcSeq", grpNtcSeq);
//
//		} catch (EventException ex) {
//			rollback();
//			String[] msg = new String[] { "Arrival Notice" };
//			throw new EventException(new ErrorHandler("BKG40036", msg)
//					.getMessage());
//
//		} catch (DAOException ex) {
//			rollback();
//			String[] msg = new String[] { "Arrival Notice" };
//			throw new EventException(new ErrorHandler("BKG40036", msg)
//					.getMessage());
//		}
//		return eventResponse;
//	}

	/**
	 * [0946]Group A/N Merge Pop-up Email 발송한다.
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */

	private EventResponse sendArrNtcByGrpEmail(Event e) throws EventException {
    	// TODO Auto-generated method stub
		log.debug("----0946 Email 발송 SC 시작");
		BookingHistoryMgtBC hisBC = new BookingHistoryMgtBCImpl();

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
        	begin();
        	String uiId = "ESM_BKG_0946";

        	EsmBkg0946Event event = (EsmBkg0946Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
            Vector<String> vEmail = event.getEmail();
            ArrNtcGrpSendVO grpSendVO = event.getGrpSendVO();

            List<BkgNtcHisVO> hisVOS = command.sendArrNtcByGrpEml(grpSendVO,event.getListVOS(), account,vEmail);
            hisBC.createBkgNtcHis(hisVOS, uiId);

            eventResponse.setUserMessage(new ErrorHandler("BKG40054").getUserMessage());
            log.debug("--------------- 메일전송 성공 commit()");
            commit();

        } catch(EventException ex){
            rollback();
         	throw ex;

            //throw new EventException(new ErrorHandler("BKG00110").getMessage());
        } catch(Exception ex){
        	rollback();
            String[] msg = new String[]{"Group Arrival Notice"};
         	throw new EventException(new ErrorHandler("BKG40036",msg).getMessage());
        }
        return eventResponse;

	}

	/**
	 * [0946]Group A/N Merge Pop-up Fax 발송한다.
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse sendArrNtcByGrpFax(Event e) throws EventException {
		// TODO Auto-generated method stub
		log.debug("---------------0946 fax발송 SC 시작");
		BookingHistoryMgtBC hisBC = new BookingHistoryMgtBCImpl();

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
        	begin();
        	String uiId = "ESM_BKG_0946";

        	EsmBkg0946Event event = (EsmBkg0946Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            ArrNtcGrpSendVO grpSendVO = event.getGrpSendVO();

            List<BkgNtcHisVO> hisVOS = command.sendArrNtcByGrpFax(grpSendVO, event.getListVOS(), account,event.getFaxNo());
            hisBC.createBkgNtcHis(hisVOS, uiId);
            eventResponse.setUserMessage(new ErrorHandler("BKG40053").getUserMessage());
            commit();

        } catch(EventException ex){
            rollback();
         	throw ex;

            //throw new EventException(new ErrorHandler("BKG00110").getMessage());
        }catch(Exception ex){
            rollback();
            String[] msg = new String[]{"Group Arrival Notice"};
        	throw new EventException(new ErrorHandler("BKG40035",msg).getMessage());

            //throw new EventException(new ErrorHandler("BKG00110").getMessage());
        }



        return eventResponse;
	}
	/**
	 * 공통코드(코드,명칭)조회 이벤트 처리<br>
	 * PRICommon의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchComCodeDescList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0240Event event = (EsmBkg0240Event)e;
		CodeUtil cdUtil = CodeUtil.getInstance();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			ArrayList<CodeInfo> cdList =(ArrayList<CodeInfo>)cdUtil.getCodeSelect(event.getRsltcdlistvo().getCd(),0);
			List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

			for (int i = 0; i < cdList.size(); i++) {
				RsltCdListVO rsltcdlistvo = new RsltCdListVO() ;
				rsltcdlistvo.setCd(cdList.get(i).getCode());

				if (event.getRsltcdlistvo().getCd().toString().equalsIgnoreCase("CD01701") ){
					rsltcdlistvo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());
				}else if (event.getRsltcdlistvo().getCd().toString().equalsIgnoreCase("CD01714")) {
					rsltcdlistvo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());
				}else if (event.getRsltcdlistvo().getCd().toString().equalsIgnoreCase("CD02128")) {
					rsltcdlistvo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());
				}else if (event.getRsltcdlistvo().getCd().toString().equalsIgnoreCase("CD02141")) {
					rsltcdlistvo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());
				}else if (event.getRsltcdlistvo().getCd().toString().equalsIgnoreCase("CD02085")) {
					rsltcdlistvo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());
				}else {
					rsltcdlistvo.setNm(cdList.get(i).getName());
				}

//				rsltcdlistvo.setNm(cdList.get(i).getCode()+"\t"+cdList.get(i).getName());
//				rsltcdlistvo.setNm(cdList.get(i).getName()+"\t"+cdList.get(i).getCode());
				list.add(rsltcdlistvo);
			}


			eventResponse.setRsVoList(list);

		} catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            // BKG00450 : 조회에 실패했습니다.
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * [1099]Integrated Customer Data Update Setup을 조회한다.
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIntgCustCntcUpdtStupInfoByOfc(Event e) throws EventException
    {
        // TODO Auto-generated method stub
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try
        {
            EsmBkg1099Event event = (EsmBkg1099Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            BkgIbCustCntcStupVO bkgIbCustCntcStupVO = event.getBkgIbCustCntcStupVO();
            BkgIbCustCntcStupVO resultSearch = command.searchIntgCustCntcUpdtStupInfoByOfc(bkgIbCustCntcStupVO.getOfcCd());
            eventResponse.setRsVo(resultSearch);

            if(resultSearch != null)
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
     * ESM_BKG_1099:   Integrated Customer Data Update Setup를 저장한다.<br>
     *
     * @param e
     * @return EventResponse
     * @exception EventException
     * */
    private EventResponse manageIntgCustCntcUpdtStupInfoByOfc(Event e) throws EventException
    {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try
        {
        	EsmBkg1099Event event = (EsmBkg1099Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            BkgIbCustCntcStupVO bkgIbCustCntcStupVo = event.getBkgIbCustCntcStupVO();
            begin();

            command.manageIntgCustCntcUpdtStupInfoByOfc(bkgIbCustCntcStupVo, account);
            commit();

			// 성공메시지세팅
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
            //eventResponse.setETCData("status", "ok");
        } catch(EventException ex) {

            rollback();
            //throw new EventException(new ErrorHandler("BKG06087").getMessage(), ex); BKG00806
            throw new EventException(new ErrorHandler("BKG00820").getMessage(), ex);
        }catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
        }
        return eventResponse;
    }

    private EventResponse backEndJobResult(Event e) throws EventException{
    	  GeneralEventResponse eventResponse = new GeneralEventResponse();
    	  String sKey = "";
    	  EsmBkg0672Event event =(EsmBkg0672Event) e;
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
     * ESM_BKG_0244 : 조회
     * @param e
     * @return
     * @throws EventException
     */
    private EventResponse searchAlsoNotify(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0244Event event = (EsmBkg0244Event) e;
		ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

		try {

			List<BkgArrNtcAntfyVO> list = command.seachAlsoNotify(event.getBkgArrNtcAntfyVO());

			eventResponse.setRsVoList(list);

		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}

		return eventResponse;
	}

    /**
     * ESM_BKG_0244 : 등록, 수정, 삭제
     * @param e
     * @return
     * @throws EventException
     */
    private EventResponse setupAlsoNotify(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0244Event event = (EsmBkg0244Event) e;
		ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

		try{

			BkgArrNtcAntfyVO rtnVo = new BkgArrNtcAntfyVO();

			begin();
			rtnVo = command.setupAlsoNotify(event.getBkgArrNtcAntfyVOs(),account);

			if(rtnVo == null){
				commit();
				eventResponse.setETCData("dupFlag" , "N");
			}else{
				rollback();
				eventResponse.setETCData("dupFlag"		, "Y");
				eventResponse.setETCData("scNo"			, rtnVo.getScNo());
				eventResponse.setETCData("antfyCustCd"	, rtnVo.getAntfyCustCd());
				eventResponse.setETCData("podCd"		, rtnVo.getPodCd());
			}

		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("BKG06086").getMessage(), ex);
		}

		return eventResponse;
	}
}