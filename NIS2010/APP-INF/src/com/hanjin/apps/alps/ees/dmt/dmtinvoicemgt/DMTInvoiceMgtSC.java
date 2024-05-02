/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTInvoiceMgtSC.java
*@FileTitle : Invoice Creation & Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.08.05 김태균
* 1.0 Creation
* 2010.11.11 김태균 [CHM-201007006-01] [EES-DMT] [DMDT] Invoice Currency 선택 기능 추가
* 2010.11.26 김태균 [] [EES-DMT] A/R I/F시 INVOICE CURRECY 없을 경우 에러 처리함
* 2010.12.28 김태균 [] [EES-DMT] THRBA OFFICE 사용자 invoice issue 시 invoice currency ERROR로 인하여 에러로그 추가
* 2011.01.07 김태균 [CHM-201108233-01] [EES-DMT] A/R I/F 시 XA DataSource 호출 및 One Tx 처리
* 2011.04.18 김태균 [] Other I/F 관련 ERP로직 분리
* 2011.05.20 김태균[CHM-201110830-01] [DMT] Issued Invoice Inquiry 화면 보완 요청
* 2011.11.14 권   민[CHM-201114143] [DMT] Manual Invoice with no detail 조건의 Print Preview 개발
* 2012.05.11 김현화 [CHM-201217746-01] 경인항 터미널과의 DMT EDI를 위한 batch set-up 요청(KRGIN 추가)
* 2012.05.18 김현화 [CHM-201217803] 인도용 DMT Invoice format 구성 - GST 적용.   
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBC;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.EDIVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBC;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.ARCurrencyVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.CommonCodeVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.CoverageVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.CurrencyVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.TariffNameVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo.UserRoleVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChrgDtlVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.basic.DemandNoteSendBC;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.basic.DemandNoteSendBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.event.EesDmt3007Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.event.EesDmt3013Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.event.EesDmt3108Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.event.EesDmt3109Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteByBookingVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteGroupListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNotePreviewEtcVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNotePreviewMstVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNotePreviewParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic.InvoiceIssueCollectionMgtBC;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic.InvoiceIssueCollectionMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.ESM0750001Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4001Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4002Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4003Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4004Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4006Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4007Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4008Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4009Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4011Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4013Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4016Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4017Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4018Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4101Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4103Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4104Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4105Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4106Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt5001Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt5002Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt5003Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt5101Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt7006Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt7020Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration.InvoiceIssueCollectionMgtDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ARInterfaceCreationCondVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ARInterfaceStatusVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.CancelInvoiceParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ChargeBookingInvoiceVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ConfirmChargeListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtCommonReturnDataVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtFaxEmlSndHisVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvDtlVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvMnVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvRtVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtPayrCntcPntVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtPayrInfoVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.EDIContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.FAXEmailByPayerVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IdaGstRtoCondVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IdaGstRtoVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceGroupMgtVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceGroupParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceInterfaceARByDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceInterfaceARBySummaryVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueMasterPreviewVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueMgtVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueRDParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceParamVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceSumByPayerVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceIssueVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceIssuedListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceSummaryVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualKeyByBookingVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualKeyByChargeVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OTSCleanDetailExcelListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OTSCleanListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OTSCleanOfficeListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryByDetial2VO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryByDetial3VO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryByDetialVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryBySummaryVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.PayerInfoListVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.PayerInformationVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SearchIndiaGstRateVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionMasterSetVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.VVDCheckDataVO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.usdemurrageaudit.basic.USDemurrageAuditBC;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.usdemurrageaudit.basic.USDemurrageAuditBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.usdemurrageaudit.event.EesDmt4005Event;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.usdemurrageaudit.vo.ChargeForAuditVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.hanjin.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.hanjin.framework.component.backend.support.BackEndJobResult;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-InvoiceMgt Business Logic ServiceCommand - ALPS-InvoiceMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Kim Tae Kyun
 * @see InvoiceIssueCollectionMgtDBDAO
 * @since J2EE 1.6
 */

public class DMTInvoiceMgtSC extends ServiceCommandSupport {
    // Login User Information 
    private SignOnUserAccount account = null;

    /**
     * InvoiceMgt system 업무 시나리오 선행작업<br>
     * 업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        log.debug("DMTInvoiceMgtSC 시작");
        try {
            // 일단 comment --> 로그인 체크 부분
            account = getSignOnUserAccount();
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
        }
    }

    /**
     * InvoiceMgt system 업무 시나리오 마감작업<br>
     * 업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        log.debug("DMTInvoiceMgtSC 종료");
    }

    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * ALPS-InvoiceMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
     * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        // RDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = null;

        // SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
        if (e.getEventName().equalsIgnoreCase("EesDmt3007Event")) {
	    	if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	    		eventResponse = searchDemandNoteIssuePreview(e);
	    	}
        } else if(e.getEventName().equalsIgnoreCase("EesDmt3013Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDemandChargeList(e);
			}
        } else if(e.getEventName().equalsIgnoreCase("EesDmt3108Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	//office별 Tax Rate
        		eventResponse = searchDemandEnvironmentByOffice(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
        		eventResponse = searchDemandNoteByGroup(e);
        	}
		} else if(e.getEventName().equalsIgnoreCase("EesDmt3109Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDemandNoteByBooking(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("EesDmt4001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
			    eventResponse = searchChargeInvoiceList(e);
			} 
			else {
				// 화면 Loading 시 필요한 초기정보
		    	eventResponse = searchInitInfo(e);	
			}
		} else if(e.getEventName().equalsIgnoreCase("EesDmt4002Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchChargeInvoice(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchIssuedInvoice(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchExchangeRate(e);
            }
            //===============================================================
        	// 변경일자 : 2017.07.27 
        	// 변경요건 : 인도 TAX 변경에 따른 수정
            // 변경내용 : Invoice Creation & Issue - Booking 초기정보 조회
           //===============================================================            
            // Invoice Creation & Issue - Booking 초기정보 조회
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
            	eventResponse = searchInvInitInfo(e);
            }
            //===============================================================
        	// 변경일자 : 2017.07.27 
        	// 변경요건 : 인도 TAX 변경에 따른 수정
            // 변경내용 : 인도 TAX Ratio 조회 ( Payer 정보가 필요함 )
           //===============================================================
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchIdaTaxRto(e);
            }              
            else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = issueInvoice(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = modifyInvoice(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
                eventResponse = createInvoiceData(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
                eventResponse = searchFAXEmailByPayer(e);
            }
            //Virtual Invoice Cancel
            else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
            	eventResponse = modifyVirtualInvoiceStatus(e);
            }             
            //Virtual Invoice Cancel
            else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
            	eventResponse = searchExistsVirtualInvoice(e);
            }  
            else {
            	//처음 로딩
            	eventResponse = searchUserRoleCodeDefault (e);
            }
        }
        else if(e.getEventName().equalsIgnoreCase("EesDmt4003Event")) {
        	//1.Retrieve 시 수행하는 Action.
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchInvoiceIssueMasterPreview(e);
            }
        }
        else if(e.getEventName().equalsIgnoreCase("EesDmt4004Event")) {
        	//1.Retrieve 시 수행하는 Action.
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchManualInvoiceByBooking(e);
            } 
            //2.Data Display 버튼 클릭시 Booking 정보와 Charge 정보를 조회하기 위한 Action.
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchManualKeyByBooking(e);
            }
            //3.Charge Grid 에서 Charge No. 입력시 정확한 Charge No. 인지를 체크하기 위한 Action.(조회결과 CNTR Type/Size 정보 반환)
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = checkContainerNo(e);
            }
            //4.VVD CD와 Calling Port 체크 Action
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = checkCallingPort(e);
            }
            //5.Ex. Rate 조회
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchExchangeRate(e);
            }
            //6.VVD CD 유효성 체크
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
                eventResponse = checkVVD(e);
            }
            //7.Local Currency + Rate Currency 를 조회
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
                eventResponse = searchChargeCurrency(e);
            }             
            //8.Save 버튼 클릭시 [Invoice Issue 전]
            else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
            	eventResponse = issueInvoiceByManual(e);
            }
            //9.Save 버튼 클릭시 [Invoice Issue 후]
            else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
            	eventResponse = modifyInvoiceByManual(e);
            }       
            //10.AR/IF 버튼 클릭시
            else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
            	eventResponse = createInvoiceData(e);
            }
			else {
            	//처음 로딩
            	eventResponse = searchUserRoleCodeDefault (e);
            }  
            
        } else if (e.getEventName().equalsIgnoreCase("EesDmt4005Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
        		eventResponse = searchChargeForAudit(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
        		eventResponse = confirmContainerCharge(e);
        	} 
        } else if(e.getEventName().equalsIgnoreCase("EesDmt4006Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchManualInvoiceBySummaryList(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
        		eventResponse = searchManuaLInvoiceReasonList();
        	} 
        } else if(e.getEventName().equalsIgnoreCase("EesDmt4007Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchManualInvoiceByDetailList(e);
        	}
        } else if(e.getEventName().equalsIgnoreCase("EesDmt4008Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchIssuedInvoiceList(e);
        	} 
        	else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
        		eventResponse = searchIssuedInvoiceSumByPayer(e);
        	} 
        	else {
        		// 화면 Loading 시 필요한 초기정보
        		eventResponse = searchInitInfo(e);
        	}
        } else if(e.getEventName().equalsIgnoreCase("EesDmt4009Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH) || e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchOTSInquiryBySummaryList(e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EesDmt4011Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchOTSInquiryByDetailList(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
        		eventResponse = searchOTSInquiryByDetailListRemark(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
        		eventResponse = updateOTSInquiryByDetailListRemark(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
        		eventResponse = searchOTSInquiryByDetailListRemark2(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
        		eventResponse = searchOTSInquiryByDetailList2(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
        		eventResponse = searchOTSInquiryByDetailList3(e);
        	}else{
        		//처음 로딩
        		eventResponse = searchUserRoleCodeDefault (e);
        	}
        } else if ( e.getEventName().equalsIgnoreCase("EesDmt4013Event")) {
        	if ( e.getFormCommand().isCommand(FormCommand.SEARCH) ) {
        		eventResponse = searchEnvironmentByOffice(e);
        	}else if ( e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
        		eventResponse = searchBookingContainerCount(e);
        	}else if ( e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
        		eventResponse = searchChargeByBooking(e);
        	}else if ( e.getFormCommand().isCommand(FormCommand.MULTI) ) {		//Save
        		eventResponse = issueInvoiceByGroup(e);
        	}else if ( e.getFormCommand().isCommand(FormCommand.COMMAND01) ) {	//A/R-I/F
        		eventResponse = createInvoiceData(e);
        	}else if ( e.getFormCommand().isCommand(FormCommand.COMMAND02) ) {	//BackEndJob
        		eventResponse = doBackEndJob(e);
        	}else if ( e.getFormCommand().isCommand(FormCommand.COMMAND03) ) {	//BackEndJob
        		eventResponse = checkBackEndJob(e);
        	}
        } else if(e.getEventName().equalsIgnoreCase("EesDmt4016Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchChargeInvoiceBySZPBB(e);
        	}
        	else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
        		eventResponse = searchIssuedInvoiceBySZPBB(e);
        	}
        	else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
        		eventResponse = searchExchangeRate(e);
        	}
        	else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
        		eventResponse = issueInvoiceBySZPBB(e);
        	}
        	else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
        		eventResponse = modifyInvoice(e);
        	}
        	else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
        		eventResponse = createInvoiceData(e);
        	}
        } else if(e.getEventName().equalsIgnoreCase("EesDmt4101Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchSheetSet(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = saveSheetSet(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = removeSheetSet(e);
            }else{
            	//처음 로딩
            	eventResponse = searchUserRoleCodeDefault (e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EesDmt4103Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchSheetOption(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageSheetOption(e);
            } else {
            	//처음 로딩
            	eventResponse = searchUserRoleCodeDefault (e);
            }
        } else if ( e.getEventName().equalsIgnoreCase("EesDmt4104Event")) {
        	// Payer Code별로 Payer정보를 조회한다.
        	if ( e.getFormCommand().isCommand(FormCommand.SEARCH) ) {
        		eventResponse = searchPayerInformation(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01) ) {
        		eventResponse = searchPayerName(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02) ) {
        		eventResponse = searchPayerAddress(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03) ) {
        		eventResponse = searchPayerContactPointName(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04) ) {
        		eventResponse = searchPayerPhoneNo(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05) ) {
        		eventResponse = searchPayerFaxNo(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST06) ) {
        		eventResponse = searchPayerEmail(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.MULTI) ) {
        		eventResponse = managePayerInformation(e);
        	}else{
        		//처음 로딩
        		eventResponse = searchUserRoleCodeDefault (e);
        	}
        } else if(e.getEventName().equalsIgnoreCase("EesDmt4105Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchInvoiceRemark(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
        		eventResponse = searchOTSRemark(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
        		eventResponse = modifyInvoiceRemark(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
        		eventResponse = modifyOTSRemark(e);
        	}
        }else if(e.getEventName().equalsIgnoreCase("EesDmt4106Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchCancelReason(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
        		eventResponse = cancelInvoice(e);
        	}
        } else if (e.getEventName().equalsIgnoreCase("EesDmt5001Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
        		eventResponse = searchARInterfaceStatusByDMT(e);
        	} 
        	else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
        		eventResponse = searchARInterfaceStatusByBKG(e);
        	}  
        	else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
        		eventResponse = searchARInterfaceStatusByERP(e);
        	} 
        } else if (e.getEventName().equalsIgnoreCase("EesDmt5002Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchInvoiceInterfaceARBySummary(e);
        	}   
        } else if (e.getEventName().equalsIgnoreCase("EesDmt5003Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchInvoiceInterfaceARByDetail(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
        		eventResponse = createInvoiceData(e);
        	}   
        } else if(e.getEventName().equalsIgnoreCase("EesDmt5101Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchHoldReasonCdList(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
        		eventResponse = searchHoldReason(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
        		eventResponse = modifyInvoiceByHold(e);
        	}
        } else if ( e.getEventName().equalsIgnoreCase("EesDmt7006Event") ) {
        	if ( e.getFormCommand().isCommand(FormCommand.SEARCH) ) {
        		eventResponse = searchFaxEmailHistory(e);
        	}
        } else if(e.getEventName().equalsIgnoreCase("EesDmt4017Event")) {
	        if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	            eventResponse = searchOTSCleanList(e);
	        } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
        		eventResponse = searchOTSCleanOfficeList(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
        		eventResponse = searchOTSCleanDetailExcelList(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
        		eventResponse = updateOTSCleanListRemark(e);
        	} else if ( e.getFormCommand().isCommand(FormCommand.COMMAND03) ) {	//BackEndJob
        		eventResponse = backEndJobResult(e);
        	}
        } else if(e.getEventName().equalsIgnoreCase("EesDmt4018Event")) {
	        if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	            eventResponse = searchOTSCleanDetailList(e);
	        } else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
        		eventResponse = searchOTSCleanOfficeDetailList(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
        		eventResponse = searchOTSCleanByDetailListRemark(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
        		eventResponse = updateOTSCleanByDetailListRemark(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
        		eventResponse = searchOTSCleanByDetailListRemark2(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
        		eventResponse = searchOTSCleanByDetailList2(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
        		eventResponse = searchOTSCleanByDetailList3 (e);
        	} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
        		eventResponse = updateOTSCleanDetailListSales(e);
        	} else{
        		//처음 로딩
        		eventResponse = searchUserRoleCodeDefault (e);
        	}
        }
        // ERP 역 I/F 수신정보 처리
        else if  (e.getEventName().equalsIgnoreCase("ESM0750001Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = this.addOtsInfo(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = this.modifyOtsCltFlg(e);
            }
        }
        // Table - Payer Info & Fax/E-mail
        else if  (e.getEventName().equalsIgnoreCase("EesDmt7020Event")) {
        	// Payer Code별로 Payer정보를 조회한다.
        	if ( e.getFormCommand().isCommand(FormCommand.SEARCH) ) {
        		eventResponse = searchPayerInfoList(e);
        	}else{
        		//처음 로딩
        		eventResponse = searchUserRoleCodeDefault (e);
        	}
        }
        
        return eventResponse;
    }
    /**
     * EES_DMT_4001 : Retrieve<br>
     * [Invoice Create & Issue]을 [조회] 합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchChargeInvoiceList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4001Event event = (EesDmt4001Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();

        try{
            List<ConfirmChargeListVO> list = command.searchChargeInvoiceList(event.getIssuedInvoiceParamVO(), account);
            eventResponse.setRsVoList(list);
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
     * EES_DMT_3109 : [Open Event]<br>
     *  [Demand Note Issue by Booking]을 [조회] 합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchDemandNoteByBooking(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        DemandNoteSendBC command = new DemandNoteSendBCImpl();
        InvoiceIssueCollectionMgtBC Issuecommand = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        
        try {
            EesDmt3109Event event = (EesDmt3109Event)e;
            
            DemandNoteParmVO parmVO = event.getDemandNoteParmVO();
            
            //Search Group VO from request
            DemandNoteByBookingVO demandNoteByBookingVO = command.searchDemandNoteByBooking(parmVO, account);
            
            //Extract muli-list data from group vo
            List<InvoiceIssueVO> list = demandNoteByBookingVO.getInvoiceIssueVOs();
            eventResponse.setRsVoList(list);
            
            ChargeBookingInvoiceVO chargeBookingInvoiceVO = demandNoteByBookingVO.getChargeBookingInvoiceVO();
            //==================================================================================================
            // 인도지역 OFC 일 경우, 인도 TAX 관련정보를 추가해준다.
            //==================================================================================================            
            Issuecommand.setIdaTaxInfo(chargeBookingInvoiceVO, parmVO.getUsrCntCd());
            //==================================================================================================
            eventResponse.setETCData(chargeBookingInvoiceVO.getColumnValues());

        } 
        catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            throw ex;
        } 
        catch(Exception ex) {
        	eventResponse.setUserMessage(ex.getMessage());
        	throw new EventException(ex.getMessage(), ex);
        } 
        return eventResponse;           
    }
    
    
    /**
     * EES_DMT_4002 : Retrieve<br>
     * [Invoice Create & Issue]을 [조회] 합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchChargeInvoice(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4002Event event = (EesDmt4002Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        ChargeCalculationBC commandChrge 	= new ChargeCalculationBCImpl();
        
        try {
        	IssuedInvoiceParamVO parmVO = event.getIssuedInvoiceParamVO();
        	
        	//1.searchVVDCheckData
        	VVDCheckDataVO vVDCheckDataVO = command.searchVVDCheckData(parmVO);
        	if (!StringUtils.isEmpty(vVDCheckDataVO.getBkgNo())) {
	        	//2.modifyBookingContainerVVD
	        	commandChrge.modifyBookingContainerVVD(vVDCheckDataVO);
        	}
        	
        	//3.실제 조회 로직 처리
            InvoiceIssueMgtVO invoiceIssueMgtVO = command.searchChargeInvoice(parmVO, account);
            List<InvoiceIssueVO> list = invoiceIssueMgtVO.getInvoiceIssueVOs();
            eventResponse.setRsVoList(list);
            
            ChargeBookingInvoiceVO chargeBookingInvoiceVO = invoiceIssueMgtVO.getChargeBookingInvoiceVO();
            //==================================================================================================
            // 인도지역 OFC 일 경우, 인도 TAX 관련정보를 추가해준다.
            //==================================================================================================            
            command.setIdaTaxInfo(chargeBookingInvoiceVO, parmVO.getUsrCntCd());
            //==================================================================================================            
            eventResponse.setETCData(chargeBookingInvoiceVO.getColumnValues());
        }
        catch(EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }
        catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }   
        return eventResponse;
    }
    
    /**
     * EES_DMT_4002 : Retrieve<br>
     * [Invoice Create & Issue]을 [조회] 합니다.(Invoice Issue 후)<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchIssuedInvoice(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4002Event event = (EesDmt4002Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();

        try {
            InvoiceIssueMgtVO invoiceIssueMgtVO = command.searchIssuedInvoice(event.getIssuedInvoiceParamVO());
            
            List<InvoiceIssueVO> list = invoiceIssueMgtVO.getInvoiceIssueVOs();
            ChargeBookingInvoiceVO chargeBookingInvoiceVO = invoiceIssueMgtVO.getChargeBookingInvoiceVO();
            
            eventResponse.setRsVoList(list);
            eventResponse.setETCData(chargeBookingInvoiceVO.getColumnValues());
            
            if ("IN".equals(chargeBookingInvoiceVO.getCreCntCd())) {
	            // 인도 TAX 변경 전 / 후 인지 조회 ( A : After, B : Before )
	            String invNo = event.getIssuedInvoiceParamVO().getSInvoiceNo();
	            String idaTaxApplTm = command.searchIdaTaxApplTm(invNo);
	            eventResponse.setETCData("ida_tax_appl_tm", idaTaxApplTm);    
            }
        }
        catch(EventException ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        } 
        catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }   
        return eventResponse;
    }
    
    /**
    * EES_DMT_4009 : [Search]<br>
    * [Outstanding Inquiry by Customer N Issue 대상]을 [조회]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchOTSInquiryBySummaryList (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4009Event event = (EesDmt4009Event)e;        
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        List<OtsInquiryBySummaryVO> list = null;
        try {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // Tab 1 - DMT OFC
        		list = command.searchOTSInquiryBySummaryList ( event.getOtsInquiryParmVO() );    	        	
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // Tab 2 - CTRT OFC
            	list = command.searchOTSInquiryBySummaryList2 ( event.getOtsInquiryParm2VO() );	
            }
        	eventResponse.setRsVoList(list);	        
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        
        return eventResponse;
    }
    
   /**
    * EES_DMT_4005 : [Retrieve]<br>
    * [3rd Party DEM/DET Collection Audit]을 [조회]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchChargeForAudit(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4005Event event = (EesDmt4005Event)e;
        USDemurrageAuditBC command = new USDemurrageAuditBCImpl();

        try{
            List<ChargeForAuditVO> list = command.searchChargeForAudit(event.getChargeForAuditParmVOS());
            eventResponse.setRsVoList(list);
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
	 * EES_DMT_3001, EES_DMT_3002, EES_DMT_3003 :  <br>
	 * Charge 발생된 금액에 대해서 확정(Confirm)한다.<br>
	 * 
	 * @param Event e 
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmContainerCharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ChargeCalculationBC command = new ChargeCalculationBCImpl();
		String msg = "";
		
		try{
			begin();

			msg = command.confirmContainerCharge(((EesDmt4005Event)e).getChargeCalculationContainerVOs(),account);
			
			if(!msg.equals("")){
				rollback();
				eventResponse.setUserMessage(msg);
			}else{
				commit();
			}
		}catch(EventException ex){
			log.debug("error (1) "+ex.getMessage());
			rollback();
			//throw ex;
			throw new EventException(ex.getMessage(), ex);
		}catch(Exception ex){
			log.debug("error (2) "+ex.getMessage());
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
    
   /**
    * EES_DMT_5001_1 : [Retrieve]<br>
    * [TAB1:A/R Interface Status Inquiry By DMT]을 [조회]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchARInterfaceStatusByDMT(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt5001Event event = (EesDmt5001Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();

        try{
            List<ARInterfaceStatusVO> list = command.searchARInterfaceStatusByDMT(event.getARInterfaceParmVO());
            eventResponse.setRsVoList(list);
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
    * EES_DMT_5001_2 : [Retrieve]<br>
    * [TAB2:A/R Interface Status Inquiry By BKG]을 [조회]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchARInterfaceStatusByBKG(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt5001Event event = (EesDmt5001Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();

        try{
            List<ARInterfaceStatusVO> list = command.searchARInterfaceStatusByBKG(event.getARInterfaceParmVO());
            eventResponse.setRsVoList(list);
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
    * EES_DMT_5002 : [Retrieve]<br>
    * [Invoice Interface to A/R]을 [조회]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchInvoiceInterfaceARBySummary(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt5002Event event = (EesDmt5002Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();

        try{
            List<InvoiceInterfaceARBySummaryVO> list = command.searchInvoiceInterfaceARBySummary(event.getInvoiceInterfaceARParmVO());
            eventResponse.setRsVoList(list);
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
    * EES_DMT_5003 : [Retrieve]<br>
    * [Invoice Interface to A/R - Detail]을 [조회]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchInvoiceInterfaceARByDetail(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt5003Event event = (EesDmt5003Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();

        try{
            List<InvoiceInterfaceARByDetailVO> list = command.searchInvoiceInterfaceARByDetail(event.getInvoiceInterfaceARParmVO(), account);
            eventResponse.setRsVoList(list);
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
    * EES_DMT_4011 : [Search]<br>
    * [Outstanding Inquiry by Customer N Issue - Detail(s) 대상]을 [조회]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchOTSInquiryByDetailList (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4011Event event = (EesDmt4011Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
	        List<OtsInquiryByDetialVO> list = command.searchOTSInquiryByDetailList ( event.getOtsInquiryParmVO() );
	        eventResponse.setRsVoList(list);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
    * EES_DMT_4011 : [Search]<br>
    * [Outstanding Inquiry by Customer N Issue - Detail(s) 대상]을 [조회]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchOTSInquiryByDetailList2 (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4011Event event = (EesDmt4011Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
	        List<OtsInquiryByDetial2VO> list = command.searchOTSInquiryByDetailList2 ( event.getOtsInquiryParmVO() );
	        eventResponse.setRsVoList(list);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }

    // 신규개발건 ( Auto A/R I/F )
    /**
    * EES_DMT_4002 : [Save]<br>
    * [Invoice Creation & Issue - Booking]을 [저장]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */    
    private EventResponse issueInvoice(Event e) throws EventException {
    	InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	
        EesDmt4002Event event = (EesDmt4002Event)e;
        
        // Invoice 발행을 위한 Charge 목록
        List<InvoiceIssueVO> invoiceIssueVOs = Arrays.asList(event.getInvoiceIssueVOs());
        
    	InvoiceGroupMgtVO invoiceGroupMgtVO = new InvoiceGroupMgtVO();
    	invoiceGroupMgtVO.setChargeBookingInvoiceVO(event.getChargeBookingInvoiceVO());	// Charge Booking 정보
    	invoiceGroupMgtVO.setIssuedInvoiceParamVO(event.getIssuedInvoiceParamVO());		// Invoice 입력정보
    	invoiceGroupMgtVO.setInvoiceIssueList(invoiceIssueVOs);							// Charge 정보목록
    	
    	// INVOICE 발행으로 생성된 정보
    	DmtInvMnVO dmtInvMnVO = new DmtInvMnVO();
    	// 화면으로 전달하기 위한 정보
    	Map<String,String> etcData = new HashMap<String,String>();
    	// 서버 에러메시지
    	StringBuffer sbErrMsg = new StringBuffer();
    	
    	final String SUCCESS = "DMT03064";
    	
    	try {
    		begin();
    		
    		// 1. INVOICE 발행
    		dmtInvMnVO = command.issueInvoice(invoiceGroupMgtVO, account);
            // 1.1 INVOICE 발행에 대한 메시지
    		sbErrMsg.append(new ErrorHandler(dmtInvMnVO.getErrCode()).getUserMessage());
        	
    		// 1.1 INVOICE 발행에 성공한 경우
    		if (SUCCESS.equals(dmtInvMnVO.getErrCode())) {
    		
    			// 화면에서 발행된 Invoice 를 조회하기 위한 기본값 설정
                etcData.put("INVOICE_NO", dmtInvMnVO.getDmdtInvNo());
                etcData.put("CRE_OFC_CD", dmtInvMnVO.getCreOfcCd());
                etcData.put("SUCCESS_YN", "Y");
                
	    		// 2. Auto A/R I/F 대상인지 여부 조회
	    		String autoArIfYn = command.searchAutoARInfYnByOffice(dmtInvMnVO.getCreOfcCd());
	    		etcData.put("AUTO_AR_INF_YN", autoArIfYn);

	    		// 2.1 Auto A/R I/F 대상일 경우
	    		if ("Y".equals(autoArIfYn)) {
		    		// Auto A/R I/F 대상인 경우, A/R I/F 실행
		    		boolean isResult = command.sendInvoiceToAr(dmtInvMnVO, account);
		    		
		    		// Auto A/R I/F 처리에 대한 메시지
		    		sbErrMsg.setLength(0);
		    		sbErrMsg.append(dmtInvMnVO.getErrMsg());
		    		
		    		if (isResult) {
		    			commit();
		    		}
		    		else {
		    			// 트랜잭션 원복
		    			rollback();
		    			log.error("\n[Biz-1] ERROR ==> Transaction rollback for send invoice to A/R!!");
		    			
		    			etcData.put("SUCCESS_YN", "N");
		    		}
	    		}
	    		// 2.2 Auto A/R I/F 대상이 아닐 경우
	    		else {
	    			// 트랜잭션 종료
	    			commit();
	    		}
    		}
    		// 1.2 Invoice 발행에 실패한 경우
    		else {
    			// 트랜잭션 원복
    			rollback();
    			log.error("\n[Biz-2] ERROR ==> Transaction rollback for creating invoice!!");
    			
    			etcData.put("SUCCESS_YN", "N");
    		}
    		
    		eventResponse.setETCData(etcData);
    		eventResponse.setUserMessage(sbErrMsg.toString());
        	eventResponse.setRsVoList(invoiceIssueVOs);	       		
    	}
    	catch(EventException ex) {
    		// 트랜잭션 원복
    		rollback();
    		log.error("\n EventException ERROR ==> " + ex.getMessage());
    		
            throw ex;
    	}
    	catch(Exception ex) {
    		// 트랜잭션 원복
    		rollback();
    		log.error("\n Exception ERROR ==> " + ex.getMessage());
    		
            throw new EventException(ex.getMessage(), ex);
    	}
    	
    	return eventResponse;
    }
    
    /**
     * EES_DMT_4002 : [SAVE]<br>
     * [Invoice Create & Issue]을 [저장] 합니다.(Invoice Issue 전)<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
//    private EventResponse issueInvoice(Event e) throws EventException {
//
//        InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
//        ChargeCalculationBC commandChrge 		= new ChargeCalculationBCImpl();
//        GeneralEventResponse eventResponse 		= new GeneralEventResponse();
//        InvoiceIssueMgtVO invoiceIssueMgtVO 	= new InvoiceIssueMgtVO();
//        ChargeBookingInvoiceVO chargeBookingInvoiceVO = new ChargeBookingInvoiceVO();
//        List<InvoiceIssueVO> list		= null;
//        
//        //searchVVDNEta를 CHECK 로직
//        boolean chg_loc_div_cd_flag = false;
//        List<InvoiceIssueVO> invoiceIssueList 	= null;
//        VVDCheckDataVO vVDCheckDataVO 			= new VVDCheckDataVO();
//        VVDNEtaVO vVDNEtaVO 					= new VVDNEtaVO();
//        
//        
//        DmtInvMnVO dmtInvMnVO = new DmtInvMnVO();
//        Map<String,String> etcData = new HashMap<String,String>();
//
//        EesDmt4002Event event = (EesDmt4002Event)e;
//        IssuedInvoiceParamVO IssuedInvoiceParamVO = event.getIssuedInvoiceParamVO();
//        invoiceIssueMgtVO.setChargeBookingInvoiceVO(event.getChargeBookingInvoiceVO());
//        invoiceIssueMgtVO.setInvoiceIssueVOs(event.getInvoiceIssueVOs());
//        
//        chargeBookingInvoiceVO = event.getChargeBookingInvoiceVO();
//        
//        list = invoiceIssueMgtVO.getInvoiceIssueVOs();
//        
//        try{
//            
//            begin();
//            ///////////////////////////////////////////////////////////////////////////////////////////////
//            //(DMDT_CHG_LOC_DIV_CD = 'TSP'이고 OFC_TRNS_FLG = 'N'), (DMDT_CHG_LOC_DIV_CD = 'SZP') 가 아니면, 
//            //searchVVDNEta를 CALL하여 VVD CD를 Setting한다.
//        	invoiceIssueList = invoiceIssueMgtVO.getInvoiceIssueVOs();
//        	
//        	for (InvoiceIssueVO invoiceIssueParam : invoiceIssueList) {
//                
//                //체크를 하지 않으면 스킵
//                if (!"U".equals(invoiceIssueParam.getIbflag())) continue;
//                
//                if ("TSP".equals(invoiceIssueParam.getDmdtChgLocDivCd()) && "N".equals(invoiceIssueParam.getOfcTrnsFlg())) {
//                	chg_loc_div_cd_flag = true;
//                	break;
//                }
//                else if ("SZP".equals(invoiceIssueParam.getDmdtChgLocDivCd())) {
//                	chg_loc_div_cd_flag = true;
//                	break;
//                }
//            }
//            
//            // 해당 Payer에 대해 DMT_PAYR_INFO 테이블에 데이터가 존재하지 않는다면 저장시킨다. (2016-05-11 수정) 
//            if (!command.checkPayerAndSave(IssuedInvoiceParamVO.getSCustCd(), account)) {
//            	throw new Exception("Error! - Payer Check and Save");
//            }            
//            
//            if (!chg_loc_div_cd_flag) {
//            	vVDCheckDataVO.setBkgNo(invoiceIssueMgtVO.getChargeBookingInvoiceVO().getBkgNo());
//            	vVDCheckDataVO.setPodCd(invoiceIssueMgtVO.getChargeBookingInvoiceVO().getPodCd());
//            	vVDCheckDataVO.setPolCd(invoiceIssueMgtVO.getChargeBookingInvoiceVO().getPolCd());
//            	vVDCheckDataVO.setIoBnd(invoiceIssueMgtVO.getChargeBookingInvoiceVO().getDmdtTrfCd().substring(2,3));
//            	
//            	if (!vVDCheckDataVO.getBkgNo().equals("")
//                		&& !vVDCheckDataVO.getPodCd().equals("")
//                		&& !vVDCheckDataVO.getPolCd().equals("")
//                		&& !vVDCheckDataVO.getIoBnd().equals("")
//                		) {
//
//	                // searchVVDNEta
//	            	vVDNEtaVO = command.searchIssueInvoiceVVD(vVDCheckDataVO);
//	                
//	                if (vVDNEtaVO != null) {
//	                	if (vVDNEtaVO.getVslCd() != null && vVDNEtaVO.getVslCd().length() > 0
//	                			&& vVDNEtaVO.getSkdVoyNo() != null && vVDNEtaVO.getSkdVoyNo().length() > 0
//	                			&& vVDNEtaVO.getSkdDirCd() != null && vVDNEtaVO.getSkdDirCd().length() > 0 ) {
//	                	
//		                    //DMT_CHG_BKG_CNTR update
//		                    commandChrge.modifyBookingContainerVVD(vVDCheckDataVO);	
//		                    
//		                    log.debug("=========== vsl_cd ==>"+vVDNEtaVO.getVslCd());
//		                    log.debug("=========== skd_voy_no ==>"+vVDNEtaVO.getSkdVoyNo());
//		                    log.debug("=========== skd_dir_cd ==>"+vVDNEtaVO.getSkdDirCd());
//		
//		                	chargeBookingInvoiceVO.setVslCd(vVDNEtaVO.getVslCd());
//		                	chargeBookingInvoiceVO.setSkdVoyNo(vVDNEtaVO.getSkdVoyNo());
//		                	chargeBookingInvoiceVO.setSkdDirCd(vVDNEtaVO.getSkdDirCd());
//		                	chargeBookingInvoiceVO.setVvdCd(vVDNEtaVO.getVslCd()+vVDNEtaVO.getSkdVoyNo()+vVDNEtaVO.getSkdDirCd());
//		
//		                    log.debug("=========== chargeBookingInvoiceVO.vsl_cd ==>"+chargeBookingInvoiceVO.getVslCd());
//		                    log.debug("=========== chargeBookingInvoiceVO.skd_voy_no ==>"+chargeBookingInvoiceVO.getSkdVoyNo());
//		                    log.debug("=========== chargeBookingInvoiceVO.skd_dir_cd ==>"+chargeBookingInvoiceVO.getSkdDirCd());
//		                	
//		                    invoiceIssueMgtVO.setChargeBookingInvoiceVO(chargeBookingInvoiceVO);	//invoice Setting
//	                	}
//	                }
//                }
//            }
//            
//            /////////////////////////////////////////////////////////////////////////////////////////////////
//            
//            dmtInvMnVO = command.issueInvoice(invoiceIssueMgtVO, account);
//            log.debug("\n invoice_no == > "+dmtInvMnVO.getDmdtInvNo());
//            
//            //invoice no를 추가한다.
//            chargeBookingInvoiceVO.setDmdtInvNo(dmtInvMnVO.getDmdtInvNo());
//            
//            invoiceIssueMgtVO.setChargeBookingInvoiceVO(chargeBookingInvoiceVO);
//            invoiceIssueMgtVO.setInvoiceIssueList(list);
//            
//            if (dmtInvMnVO.getErrCode().equals("DMT03064")) {//성공
//                commandChrge.changeChargeStatusForInvoice(invoiceIssueMgtVO, account);
//
//                // CHM-201433200 [DMT] 가 INV 생성 및 Billing 2014.12.31
//                log.debug("\n Virtual Invoice NO == > "+ chargeBookingInvoiceVO.getDmdtVtInvNo());
//                log.debug("\n Virtual Invoice YN == > "+ chargeBookingInvoiceVO.getDmdtVtInvYn());
//                // 1. 가상 Invoice 로 신규 Invoice 를 생성할 경우
//                if ("Y".equals(IssuedInvoiceParamVO.getDmdtVtInvYn())) {
//                	// 가상 Invoice 의 상태를 'I'(Invoice) 로 변경한다.
//                	command.modifyVirtualInvoiceStatus(IssuedInvoiceParamVO.getDmdtVtInvNo() , "I", IssuedInvoiceParamVO.getSOfcCd());
//                }
//                // 2. 신규 Invoice 생성할 경우, 동일한 BKG No., Tariff Type 을 갖는 가상 Invoice 존재여부를 체크해서 존재할 경우, 가상 Invoice 를 Cancel 한다.
//                else {
//                	String bkgNo     = chargeBookingInvoiceVO.getBkgNo();
//                	String dmdtTrfCd = chargeBookingInvoiceVO.getDmdtTrfCd();
//                	
//                	if ("Y".equals(command.searchExistsVirtualInvoice(bkgNo, dmdtTrfCd))) {
//                		command.cancelVirtualInvoice(bkgNo, dmdtTrfCd);
//                	}
//                }
//               
//                commit();
//                
//                etcData.put("INVOICE_NO", dmtInvMnVO.getDmdtInvNo());
//                etcData.put("CRE_OFC_CD", dmtInvMnVO.getCreOfcCd());
//                etcData.put("SUCCESS_YN", "Y");
//                etcData.put("AUTO_AR_INF_YN", command.searchAutoARInfYnByOffice(dmtInvMnVO.getCreOfcCd()));
//               
//                eventResponse.setETCData(etcData);
//            	eventResponse.setUserMessage(new ErrorHandler(dmtInvMnVO.getErrCode()).getUserMessage());
//
//            //error처리
//            }
//            else {
//            	if (dmtInvMnVO.getErrCode().equals("DMT01068")){//It's already invoiced. You can't [Value] it !
//            		String message = new ErrorHandler("DMT01068").getUserMessage();
//            		message = JSPUtil.replace(message, "[Value]", "Save");
//            		
//            		log.error("\n SC ERROR [DMT01068] == > "+message);
//	            	eventResponse.setUserMessage(message);
//            	}
//            	else if(dmtInvMnVO.getErrCode().equals("DMT02002")) { 
//            		String message = new ErrorHandler("DMT02002").getUserMessage();
//            		message = JSPUtil.replace(message, "XXX", "INV Cur.");
//            		log.error("\n SC ERROR [DMT02002] == > "+message);
//	            	eventResponse.setUserMessage(message);
//            	}
//            	else {
//            		log.error("\n SC ERROR ["+dmtInvMnVO.getErrCode()+"] == > "+new ErrorHandler(dmtInvMnVO.getErrCode()).getUserMessage());
//	            	eventResponse.setUserMessage(new ErrorHandler(dmtInvMnVO.getErrCode()).getUserMessage());
//            	}
//
//                etcData.put("SUCCESS_YN", "N");
//                eventResponse.setETCData(etcData);
//                eventResponse.setRsVoList(list);
//            	rollback();
//            }
//        } 
//        catch(EventException ex) {
//    		log.error("\n SC EventException ERROR == > "+ex.getMessage());
//            etcData.put("SUCCESS_YN", "N");
//            eventResponse.setETCData(etcData);
//            eventResponse.setRsVoList(list);
//            rollback();
//            throw new EventException(ex.getMessage(), ex);
//        } 
//        catch(Exception ex){
//    		log.error("\n SC Exception ERROR == > "+ex.getMessage());
//            etcData.put("SUCCESS_YN", "N");
//            eventResponse.setETCData(etcData);
//            eventResponse.setRsVoList(list);
//            rollback();
//        	throw new EventException(ex.getMessage(), ex);
//        } 
//        return eventResponse;           
//    }
    
    
    /**
    * EES_DMT_4011 : [Search]<br>
    * [Outstanding Inquiry by Customer N Issue - Detail(s) 대상]을 [조회]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchOTSInquiryByDetailListRemark (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4011Event event = (EesDmt4011Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        Map<String,String> etcData 			= new HashMap<String,String>();
        try {
	        String rtnRemark = command.searchOTSInquiryByDetailListRemark ( event.getOtsInquiryParmVO() );
	        etcData.put("rtnRemark",rtnRemark);
	        eventResponse.setETCData(etcData);

	        String interRmk = command.searchOTSInquiryByDetailListInternalRemark ( event.getOtsInquiryParmVO() );
	        etcData.put("INTER_RMK",interRmk);
	        eventResponse.setETCData(etcData);
	        
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
    * EES_DMT_4011 : [Search]<br>
    * [Outstanding Inquiry by Customer N Issue - Detail(s) 대상]을 [조회]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchOTSInquiryByDetailListRemark2 (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4011Event event = (EesDmt4011Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        Map<String,String> etcData 			= new HashMap<String,String>();
        try {
	        String rtnRemark = command.searchOTSInquiryByDetailListRemark2 ( event.getOtsInquiryParmVO() );
	        etcData.put("rtnRemark",rtnRemark);
	        eventResponse.setETCData(etcData);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }    
    
    /**
    * EES_DMT_4011 : [UPDATE]<br>
    * [Outstanding Inquiry by Customer N Issue - Detail(s) REMARK]을 [UPDATE]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse updateOTSInquiryByDetailListRemark(Event e) throws EventException {
    
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4011Event event = (EesDmt4011Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        try{
            begin();            
            String rtnRemark = command.updateOTSInquiryByDetailListRemark ( event.getOtsInquiryParmVO() , account);
            eventResponse.setUserMessage(new ErrorHandler("MST00003").getUserMessage());
            eventResponse.setETCData("rtnRemark" , rtnRemark);
            commit(); 
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
    }
    
    /**
     * EES_DMT_4002 : Save<br>
     * [Invoice Create & Issue]을 [저장] 합니다.(Invoice Issue 후)<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse modifyInvoice(Event e) throws EventException {
        InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
        ChargeCalculationBC commandChrge 		= new ChargeCalculationBCImpl();
        GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        InvoiceIssueMgtVO invoiceIssueMgtVO 	=  new InvoiceIssueMgtVO();
        
        DmtInvMnVO dmtInvMnVO = new DmtInvMnVO();
        Map<String,String> etcData          	= new HashMap<String,String>();

        
        try {
            //EesDmt4002Event event = (EesDmt4002Event)e;
        	
        	if (e instanceof EesDmt4002Event) {
	            invoiceIssueMgtVO.setChargeBookingInvoiceVO(((EesDmt4002Event)e).getChargeBookingInvoiceVO());
	            invoiceIssueMgtVO.setInvoiceIssueVOs(((EesDmt4002Event)e).getInvoiceIssueVOs());
        	} 
        	else if (e instanceof EesDmt4016Event) {
        		invoiceIssueMgtVO.setChargeBookingInvoiceVO(((EesDmt4016Event)e).getChargeBookingInvoiceVO());
 	            invoiceIssueMgtVO.setInvoiceIssueVOs(((EesDmt4016Event)e).getInvoiceIssueVOs());
        	}
        	
            begin();
            dmtInvMnVO = command.modifyInvoice(invoiceIssueMgtVO, account);
            
            if ("0".equals(dmtInvMnVO.getErrCode())) {	//성공
            	//Trucker 저장
            	if (e instanceof EesDmt4002Event) {
                    commandChrge.changeTruckerForInvoice(invoiceIssueMgtVO, account);
            	}
            	
                etcData.put("SUCCESS_YN", "Y");
                eventResponse.setETCData(etcData);
                eventResponse.setUserMessage(new ErrorHandler("DMT03065").getUserMessage());
                commit(); 
            } 
            else {
            	etcData.put("SUCCESS_YN", "N");
            	eventResponse.setETCData(etcData);
            	eventResponse.setUserMessage(new ErrorHandler(dmtInvMnVO.getErrCode()).getUserMessage());
            	rollback();
            }
        } 
        catch(EventException ex) {
            rollback();
            eventResponse.setUserMessage(ex.getMessage());
            throw ex;
        }
        catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }   
        return eventResponse;           
    }    
    
    /**
     * EES_DMT_4002 : inv_cur onchange Event<br>
     * [Exchange Rate]을 [조회] 합니다.<br>
     * 
     * @param ExchangeRateParmVO exchangeRateParmVO
     * @return double
     * @exception EventException
     */
    private EventResponse searchExchangeRate(Event e) throws EventException {
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        Map<String,String> etcData          = new HashMap<String,String>();
        
        try{
        	double dResult = 0.0d;
        	
            if(e instanceof EesDmt4002Event) {
				dResult = command.searchExchangeRate(((EesDmt4002Event)e).getChargeBookingInvoiceVO());
			} 
            else if(e instanceof EesDmt4004Event) {
				dResult = command.searchExchangeRate(((EesDmt4004Event)e).getChargeBookingInvoiceVO());
			}
            else if(e instanceof EesDmt4016Event) {
				dResult = command.searchExchangeRate(((EesDmt4016Event)e).getChargeBookingInvoiceVO());
			}
            
            etcData.put("EX_RATE", JSPUtil.toDecimalFormat(dResult, "#.######"));
            eventResponse.setETCData(etcData);
        } catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            throw ex;
        } catch(Exception ex){
        	eventResponse.setUserMessage(ex.getMessage());
        	throw new EventException(ex.getMessage(), ex);
        } 
        return eventResponse;           
    }
    
    /**
     * EES_DMT_3013 : [btn_retrieve Event]<br>
     *  [Demand Note Issue]을 [조회] 합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchDemandChargeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        DemandNoteSendBC command = new DemandNoteSendBCImpl();
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        
        try{
            EesDmt3013Event event = (EesDmt3013Event)e;
            List<DemandNoteListVO> list = command.searchDemandChargeList(event.getDemandNoteListParmVO(), account);
            
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            throw ex;
        } catch(Exception ex){
            eventResponse.setUserMessage(ex.getMessage());
        	throw new EventException(ex.getMessage(), ex);
        } 
        return eventResponse;           
    }
    
    /**
     * EES_DMT_3108 : [Open Event]<br>
     *  [Demand Note Issue by Group]을 [조회] 합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchDemandNoteByGroup(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        Map<String,String> etcData 			= new HashMap<String,String>();
        
        try {
            EesDmt3108Event event = (EesDmt3108Event)e;
            //Search Group VO from request
            List<DemandNoteGroupListVO> list = new DemandNoteSendBCImpl().searchDemandNoteByGroup(event.getDemandNoteParmVO());
            eventResponse.setRsVoList(list);

            // Sheet Option - Tax Ratio By Office
            SheetOptionVO paramVO = new SheetOptionVO();
            paramVO.setOfcCd(account.getOfc_cd());
        	String tax_rto = command.searchEnvironmentByOffice(paramVO);
        	etcData.put("TAX_RTO",tax_rto);
        	
	         // 인도 TAX 변경 전 / 후 인지 조회 ( A : After, B : Before )
	         String idaTaxApplTm = command.searchIdaTaxApplTm("");
	         etcData.put("IDA_TAX_APPL_TM",     idaTaxApplTm);
	         
        	// 인도 Tax Ratio
            SearchIndiaGstRateVO indiaGstRateVO = command.searchIndiaGstRate("");
            etcData.put("IDA_EXPN_TAX_RT",      indiaGstRateVO.getIdaExpnTaxRt());
            etcData.put("IDA_EDU_TAX_RT",       indiaGstRateVO.getIdaEduTaxRt());
            etcData.put("IDA_HIGH_EDU_TAX_RT",  indiaGstRateVO.getIdaHighEduTaxRt());
            etcData.put("IDA_LOCL_TAX_RT",      indiaGstRateVO.getIdaLoclTaxRt());
            etcData.put("IDA_N2ND_LOCL_TAX_RT", indiaGstRateVO.getIdaN2ndLoclTaxRt());
        	
        	eventResponse.setETCData(etcData); 	            
        } 
        catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            throw ex;
        } 
        catch(Exception ex) {
            eventResponse.setUserMessage(ex.getMessage());
        	throw new EventException(ex.getMessage(), ex);
        } 
        
        return eventResponse;           
    }
    
    /**
     * EES_DMT_3108 : [doInit Event]<br>
     * [Office별 Tax Rto]을 [SELECT]합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchDemandEnvironmentByOffice(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        EesDmt3108Event event 				= (EesDmt3108Event)e;
        Map<String,String> etcData 			= new HashMap<String,String>();
    	InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        
        try {        
        	String tax_rto = command.searchEnvironmentByOffice( event.getSheetOptionVO() );
        	etcData.put("TAX_RTO",tax_rto);
        	eventResponse.setETCData(etcData);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;

    }
    
    /**
     * EES_DMT_4013 : [SELECT]<br>
     * [Office별 Tax Rto]을 [SELECT]합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchEnvironmentByOffice(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        EesDmt4013Event event 				= (EesDmt4013Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        Map<String,String> etcData 			= new HashMap<String,String>();
        try {
        	String tax_rto = command.searchEnvironmentByOffice( event.getSheetOptionVO() );
        	etcData.put("TAX_RTO",tax_rto);
        	eventResponse.setETCData(etcData);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;

    }
    
    /**
    * EES_DMT_4105 : [Search]<br>
    * [Remark(s) 대상]을 [조회]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchInvoiceRemark (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4105Event event 				= (EesDmt4105Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        Map<String,String> etcData 			= new HashMap<String,String>();
        try {
	        String rtnRemark = command.searchInvoiceRemark ( event.getOtsInquiryParmVO() );
	        etcData.put("rtnRemark",rtnRemark);
	        eventResponse.setETCData(etcData);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }    
    
    /**
    * EES_DMT_4105 : [Search]<br>
    * [Remark(s) 대상]을 [조회]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchOTSRemark (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4105Event event 				= (EesDmt4105Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        Map<String,String> etcData 			= new HashMap<String,String>();
        try {
	        String rtnRemark = command.searchOTSRemark ( event.getOtsInquiryParmVO() );
	        etcData.put("rtnRemark",rtnRemark);
	        eventResponse.setETCData(etcData);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        
        return eventResponse;
    }
    
    /**
    * EES_DMT_4105 : [UPDATE]<br>
    * [Remark(s)]을 [UPDATE]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse modifyInvoiceRemark(Event e) throws EventException {
    
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4105Event event = (EesDmt4105Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        try{
            begin();            
            String rtnRemark = command.modifyInvoiceRemark ( event.getOtsInquiryParmVO() , account);
            eventResponse.setUserMessage(new ErrorHandler("MST00003").getUserMessage());
            eventResponse.setETCData("rtnRemark" , rtnRemark);
            commit(); 
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
    }
    
    /**
    * EES_DMT_4105 : [UPDATE]<br>
    * [Remark(s)]을 [UPDATE]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse modifyOTSRemark(Event e) throws EventException {
    
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4105Event event = (EesDmt4105Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        try{
            begin();            
            String rtnRemark = command.modifyOTSRemark ( event.getOtsInquiryParmVO() , account);
            eventResponse.setUserMessage(new ErrorHandler("MST00003").getUserMessage());
            eventResponse.setETCData("rtnRemark" , rtnRemark);
            commit(); 
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
    }    
    
    /**
    * EES_DMT_4103 : [Search]<br>
    * [Sheet Option]을 [조회]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchSheetOption(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4103Event event = (EesDmt4103Event)e;

        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        
        SheetOptionMasterSetVO sheetOptionMasterSetVO = new SheetOptionMasterSetVO();
        sheetOptionMasterSetVO = command.searchSheetOption( event.getSheetOptionSearchOptionVO() , sheetOptionMasterSetVO );

        String shOptInfo = sheetOptionMasterSetVO.getShOptInfo();
        Map<String,String> etcData = new HashMap<String,String>();
        etcData.put("shOptInfo",shOptInfo);
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        eventResponse.setETCData ( etcData                                                  );
        eventResponse.setRsVoList( sheetOptionMasterSetVO.getSheetOptionTermTitleListUpVO() );
        eventResponse.setRsVoList( sheetOptionMasterSetVO.getSheetOptionTermTitleListDwVO() );

//        for (int i = 0; i < emptyCODMasterSetVO.getListEmptyCODMasterVOS().size(); i++) {
//            eventResponse.setRsVoList(emptyCODMasterSetVO.getListEmptyCODMasterVOS().get(i));
//        }         

        return eventResponse;
    }
    
    /**
    * EES_DMT_4103 : [Delete/Insert]<br>
    * [Sheet Option]을 [저장]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse manageSheetOption(Event e) throws EventException {
    
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4103Event event = (EesDmt4103Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        try{
            begin();            
            String audVerSeq = command.manageSheetOption( event.getSheetOptionSearchOptionVO() , event.getSheetOptionTermTitleListUpVOs() , account);
            eventResponse.setUserMessage(new ErrorHandler("MST00003").getUserMessage());
            eventResponse.setETCData("aud_ver_seq" , audVerSeq);
            commit(); 
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
    }
    
    /**
    * EES_DMT_4101 : [Search]<br>
    * [Sheet Setting Screen 대상]을 [조회]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchSheetSet (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4101Event event = (EesDmt4101Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        String rtnRemark = command.searchSheetSet ( event.getSheetSetSearchOptionVO() );
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        Map<String,String> etcData = new HashMap<String,String>();
        etcData.put("rtnRemark",rtnRemark);
        eventResponse.setETCData(etcData);
        return eventResponse;
    }
    
    /**
    * EES_DMT_4101 : [DELETE/INSERT]<br>
    * [Sheet Setting Screen]을 [DELETE/INSERT]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse saveSheetSet(Event e) throws EventException {
    
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4101Event event = (EesDmt4101Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        try{
            begin();            
            String rtnRemark = command.saveSheetSet ( event.getSheetSetSearchOptionVO() , account);
            eventResponse.setUserMessage(new ErrorHandler("MST00003").getUserMessage());
            eventResponse.setETCData("rtnRemark" , rtnRemark);
            commit(); 
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
    }
    
    /**
    * EES_DMT_4101 : [DELETE]<br>
    * [Sheet Setting Screen]을 [DELETE]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse removeSheetSet(Event e) throws EventException {
    
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4101Event event = (EesDmt4101Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        try{
            begin();            
            String rtnRemark = command.removeSheetSet ( event.getSheetSetSearchOptionVO() , account);
            eventResponse.setUserMessage(new ErrorHandler("MST00003").getUserMessage());
            eventResponse.setETCData("rtnRemark" , rtnRemark);
            commit(); 
            
        }catch(EventException ex){
			rollback();
            throw ex;
        }catch(Exception ex){
			rollback();
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
    }
    
    /**
    * EES_DMT_4101 : [Search]<br>
    * [Sheet Setting Screen 대상]을 [조회]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchManualInvoiceBySummaryList (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4006Event event 				= (EesDmt4006Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        try{
	        List<ManualInvoiceSummaryVO> list = command.searchManualInvoiceBySummaryList ( event.getManualInvoiceIssueParmVO() );
	        eventResponse.setRsVoList(list);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }        
        return eventResponse;
    }
    
    /**
     * [Invoice Group]을 [저장]합니다.<br>
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse issueInvoiceByGroup(Event e) throws EventException {
    	GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        EesDmt4013Event event 				= (EesDmt4013Event)e;
        
        try {
        	InvoiceGroupParamVO invoiceGroupParamVO = event.getInvoiceGroupParamVO();
        	
        	String key = invoiceGroupParamVO.getBackendjobKey();
        	InvoiceGroupMgtVO invoiceGroupMgtVO = (InvoiceGroupMgtVO)BackEndJobResult.loadFromFile(key);
        	
        	InvoiceGroupParamVO paramVO = invoiceGroupMgtVO.getInvoiceGroupParamVO();
        	
        	if (StringUtils.isNotEmpty(paramVO.getErrCode())) {
            	eventResponse.setUserMessage(new ErrorHandler(paramVO.getErrCode()).getUserMessage());
        	} 
        	else {
        		eventResponse.setRsVoList(invoiceGroupMgtVO.getConfirmChargeListVOs());

        		Map<String,String> etcData = new HashMap<String,String>();
        		etcData.put("inv_qty", paramVO.getInvQty());
        		eventResponse.setETCData(etcData);        		
       			eventResponse.setUserMessage(paramVO.getErrMsg());
        	}
        } 
        catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
        
		return eventResponse; 
    }
    
//    /**
//     * [Invoice Group]을 [저장]합니다.<br>
//     * @param Event e
//     * @return EventResponse
//     * @throws EventException
//     */
//    private EventResponse issueInvoiceByGroup(Event e) throws EventException {
//    	GeneralEventResponse eventResponse 	= new GeneralEventResponse();
//        EesDmt4013Event event 				= (EesDmt4013Event)e;
//        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
//        Map<String,String> etcData 			= new HashMap<String,String>();
//        
//        try{
//        	InvoiceGroupParamVO invoiceGroupParamVO = event.getInvoiceGroupParamVO();
//        	
//        	String key = invoiceGroupParamVO.getBackendjobKey();
//        	InvoiceGroupMgtVO invoiceGroupMgtVO = (InvoiceGroupMgtVO)BackEndJobResult.loadFromFile(key);
//        	
//        	if(!invoiceGroupMgtVO.getInvoiceGroupParamVO().getErrCode().equals("")){
//            		eventResponse.setUserMessage(new ErrorHandler(invoiceGroupMgtVO.getInvoiceGroupParamVO().getErrCode()).getUserMessage());
//        	}else{
//        		eventResponse.setRsVoList(invoiceGroupMgtVO.getConfirmChargeListVOs());
//        		etcData.put("inv_qty", invoiceGroupMgtVO.getInvoiceGroupParamVO().getInvQty());
//        		eventResponse.setETCData(etcData);
//        	}
//
//        	// AUTO-INF. 占썬끋六�占쏙옙湲�占싼됵옙 筌ｋ똾寃�--------------------------------------------------
//        	eventResponse.setETCData("AUTO_AR_INF_YN", command.searchAutoARInfYnByOffice(account.getOfc_cd()));
//			// ------------------------------------------------------------------------------------------------
//        	
//        } catch(Exception ex) {
//			throw new EventException(ex.getMessage(), ex);
//		}
//		return eventResponse;    	
///* BackEnd Job 처리하기 전 방식   	
//        InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
//        ChargeCalculationBC commandChrge 		= new ChargeCalculationBCImpl();
//        GeneralEventResponse eventResponse 		= new GeneralEventResponse();
//        InvoiceGroupMgtVO invoiceGroupMgtVO 	= new InvoiceGroupMgtVO();
//        List<ConfirmChargeListVO> list 			= null;
//        InvoiceGroupParamVO groupVO				= new InvoiceGroupParamVO();
//        List<InvoiceIssueVO> chargeList			= null;
//        Map<String,String> etcData 				= new HashMap<String,String>();
//        
//        try{
//            EesDmt4013Event event = (EesDmt4013Event)e;
//
//            begin();
//            invoiceGroupMgtVO = command.issueInvoiceByGroup(event.getInvoiceGroupParamVO(), event.getConfirmChargeListVOs(), account);
//            
//            list = invoiceGroupMgtVO.getConfirmChargeListVOs();
//            groupVO = invoiceGroupMgtVO.getInvoiceGroupParamVO();
//            
//            if(list == null) {
//            	log.debug("\n------------sc list null---------------");
//            }else{
//            	log.debug("\n---size-->"+list.size());
//            }
//            if(groupVO == null) {
//            	log.debug("\n------------sc groupVO null---------------");
//            }
//            
//            InvoiceGroupParamVO reInvoiceGroupParamVO = invoiceGroupMgtVO.getInvoiceGroupParamVO();
//            
//            if(!reInvoiceGroupParamVO.getErrCode().equals("")) {
//            	rollback();
//            	eventResponse.setUserMessage(new ErrorHandler(reInvoiceGroupParamVO.getErrCode()).getUserMessage());
//            }else{
//            	//charge에 전달할 데이터를 생성한다.
//            	chargeList = command.searchChargeBookingGroupInvoiceDetail(invoiceGroupMgtVO);
//            	
//                //commandChrge.changeChargeStatusForInvoiceByGroup(event.getInvoiceGroupParamVO(), event.getConfirmChargeListVOs(), account);
//            	commandChrge.changeChargeStatusForInvoiceByGroup(chargeList, account);
//                eventResponse.setRsVoList(list);
//	            
//	            etcData.put("inv_qty", groupVO.getInvQty());
//	            eventResponse.setETCData(etcData);
//	            commit();
//            }
//
//        } catch(EventException ex) {
//            rollback();
//            log.debug("[SC EXCEPTION]"+ex.getMessage());
//            throw new EventException(ex.getMessage(), ex);
//        }
//        return eventResponse;           
//*/    	
//    }

    /**
    * EES_DMT_4007 : [SEARCH]<br>
    * [Manual Invoice Report by Office - Detail(s)]을 [SEARCH]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchManualInvoiceByDetailList (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4007Event event 				= (EesDmt4007Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        try{
	        List<ManualInvoiceIssuedListVO> list = command.searchManualInvoiceByDetailList ( event.getManualInvoiceIssueParmVO() );
	        eventResponse.setRsVoList(list);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
    * EES_DMT_4011 : [Search]<br>
    * [Outstanding Inquiry by Customer N Issue - Detail(s) 대상]을 [조회]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchOTSInquiryByDetailList3 (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4011Event event 				= (EesDmt4011Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        try {
	        List<OtsInquiryByDetial3VO> list = command.searchOTSInquiryByDetailList3 ( event.getOtsInquiryParmVO() );
	        eventResponse.setRsVoList(list);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
    * EES_DMT_4006 : [SEARCH]<br>
    * [Manual Invoice Report by Office]을 [SEARCH]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchManuaLInvoiceReasonList () throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        Map<String,String> etcData = new HashMap<String,String>();
        try {
	        String reasoncd = command.searchManualInvoiceReasonList();
	        etcData.put("reasoncd",reasoncd);
	        eventResponse.setETCData(etcData);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * EES_DMT_4008 : Retrieve<br>
     * [Issued Invoice Inquiry]을 [조회] 합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchIssuedInvoiceList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4008Event event = (EesDmt4008Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();

        try{
        	List<IssuedInvoiceListVO> list = command.searchIssuedInvoiceList(event.getIssuedInvoiceParamVO());
            eventResponse.setRsVoList(list);
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
     * EES_DMT_4008 : Retrieve<br>
     * [Issued Invoice Inquiry(Payer별 Currency에 대한 합계금액)]을 [조회] 합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchIssuedInvoiceSumByPayer(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4008Event event = (EesDmt4008Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();

        try{
        	List<IssuedInvoiceSumByPayerVO> list = command.searchIssuedInvoiceSumByPayer(event.getIssuedInvoiceParamVO());
            eventResponse.setRsVoList(list);
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
     * EES_DMT_4004 : Retrieve<br>
     * [Invoice Create & Issue]을 [조회] 합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchManualInvoiceByBooking(Event e) throws EventException {
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4004Event event = (EesDmt4004Event)e;

        try{
            ChargeBookingInvoiceVO invoiceVO = event.getChargeBookingInvoiceVO();
            InvoiceIssueMgtVO invoiceIssueMgtVO = command.searchManualInvoiceByBooking(invoiceVO.getDmdtInvNo());
            
            DmtInvMnVO 			dmtInvMnVO 		= null;
            List<DmtInvMnVO> 	dmtInvMnVOS 	= invoiceIssueMgtVO.getDmtInvMnVOS();
            List<DmtInvDtlVO> 	dmtInvDtlVOS 	= invoiceIssueMgtVO.getDmtInvDtlVOS();
            List<DmtInvRtVO> 	dmtInvRtVOS 	= invoiceIssueMgtVO.getDmtInvRtVOS();
            
            if (dmtInvMnVOS != null && dmtInvMnVOS.size() > 0) {
            	
            	dmtInvMnVO = dmtInvMnVOS.get(0);
            	
            	//첫번째 프레임에 설정될 데이터 목록
            	eventResponse.setETCData("ISSUE_DT", 			dmtInvMnVO.getIssueDt() 		!= null ? dmtInvMnVO.getIssueDt() 			: "");
            	eventResponse.setETCData("ISSUE_OFC", 			dmtInvMnVO.getIssueOfcCd() 		!= null ? dmtInvMnVO.getIssueOfcCd() 		: "");
            	eventResponse.setETCData("ISSUE_NM", 			dmtInvMnVO.getIssueUsrNm() 		!= null ? dmtInvMnVO.getIssueUsrNm() 		: "");
            	eventResponse.setETCData("DMDT_INV_STS_CD", 	dmtInvMnVO.getDmdtInvStsCd() 	!= null ? dmtInvMnVO.getDmdtInvStsCd() 		: "");
            	eventResponse.setETCData("DMDT_INV_STS_DESC", 	dmtInvMnVO.getDmdtInvStsDesc() 	!= null ? dmtInvMnVO.getDmdtInvStsDesc() 	: "");
            	eventResponse.setETCData("ARIF", 				dmtInvMnVO.getDmdtArIfCd() 		!= null ? dmtInvMnVO.getDmdtArIfCd() 		: "");
            	eventResponse.setETCData("ARIF_DT", 			dmtInvMnVO.getArIfDt() 			!= null ? dmtInvMnVO.getArIfDt() 			: "");
            	eventResponse.setETCData("ARIF_OFC", 			dmtInvMnVO.getArIfOfcCd() 		!= null ? dmtInvMnVO.getArIfOfcCd() 		: "");
            	eventResponse.setETCData("ARIF_NM", 			dmtInvMnVO.getArIfUsrNm() 		!= null ? dmtInvMnVO.getArIfUsrNm() 		: "");
            	eventResponse.setETCData("ARIF_ID", 			dmtInvMnVO.getArIfUsrId() 		!= null ? dmtInvMnVO.getArIfUsrId() 		: "");
            	eventResponse.setETCData("CR_INV_NO", 			dmtInvMnVO.getCrInvNo() 		!= null ? dmtInvMnVO.getCrInvNo() 			: "");
            	eventResponse.setETCData("CR_AR_IF_CD", 		dmtInvMnVO.getCrArIfCd() 		!= null ? dmtInvMnVO.getCrArIfCd() 			: "");

            	//두번째 프레임에 설정될 데이터 목록
            	eventResponse.setETCData("BKG_NO", 				dmtInvMnVO.getBkgNo() 			!= null ? dmtInvMnVO.getBkgNo() 			: "");
            	eventResponse.setETCData("BL_NO", 				dmtInvMnVO.getBlNo() 			!= null ? dmtInvMnVO.getBlNo() 				: "");
            	eventResponse.setETCData("DMDT_TRF_CD", 		dmtInvMnVO.getDmdtTrfCd() 		!= null ? dmtInvMnVO.getDmdtTrfCd() 		: "");
            	eventResponse.setETCData("INC_CNTR_DTL", 		dmtInvMnVO.getMnlInvSndFlg() 	!= null ? dmtInvMnVO.getMnlInvSndFlg() 		: "");
            	eventResponse.setETCData("VVD_CD", 				dmtInvMnVO.getVvdCd() 			!= null ? dmtInvMnVO.getVvdCd() 			: "");
            	eventResponse.setETCData("POR_CD", 				dmtInvMnVO.getPorCd() 			!= null ? dmtInvMnVO.getPorCd() 			: "");
            	eventResponse.setETCData("POL_CD", 				dmtInvMnVO.getPolCd() 			!= null ? dmtInvMnVO.getPolCd() 			: "");
            	eventResponse.setETCData("POD_CD", 				dmtInvMnVO.getPodCd() 			!= null ? dmtInvMnVO.getPodCd() 			: "");
            	eventResponse.setETCData("DEL_CD", 				dmtInvMnVO.getDelCd() 			!= null ? dmtInvMnVO.getDelCd() 			: "");
            	eventResponse.setETCData("RCV_TERM_CD", 		dmtInvMnVO.getRcvTermCd() 		!= null ? dmtInvMnVO.getRcvTermCd() 		: "");
            	eventResponse.setETCData("DE_TERM_CD", 			dmtInvMnVO.getDeTermCd() 		!= null ? dmtInvMnVO.getDeTermCd() 			: "");
            	eventResponse.setETCData("BKG_CUST_CD", 		dmtInvMnVO.getBkgCustCd() 		!= null ? dmtInvMnVO.getBkgCustCd() 		: "");
            	eventResponse.setETCData("BKG_CUST_NM", 		dmtInvMnVO.getBkgCustNm() 		!= null ? dmtInvMnVO.getBkgCustNm() 		: "");
            	eventResponse.setETCData("ACT_CUST_CD", 		dmtInvMnVO.getActCustCd() 		!= null ? dmtInvMnVO.getActCustCd() 		: "");
            	eventResponse.setETCData("ACT_CUST_NM", 		dmtInvMnVO.getActCustNm() 		!= null ? dmtInvMnVO.getActCustNm() 		: "");
            	eventResponse.setETCData("ACT_PAYR_CUST_CD", 	dmtInvMnVO.getActPayrCustCd() 	!= null ? dmtInvMnVO.getActPayrCustCd() 	: "");
            	eventResponse.setETCData("ACT_PAYR_CUST_NM", 	dmtInvMnVO.getActPayrCustNm() 	!= null ? dmtInvMnVO.getActPayrCustNm() 	: "");         	
            	eventResponse.setETCData("ACT_PAYR_CUST_NM2", 	dmtInvMnVO.getActPayrCustNm2() 	!= null ? dmtInvMnVO.getActPayrCustNm2() 	: ""); // E-mail Send占쏙옙Customer Name      	
            	eventResponse.setETCData("DUE_DT_FLG", 			dmtInvMnVO.getIssDtPrnFlg() 	!= null ? dmtInvMnVO.getIssDtPrnFlg() 		: "");  
            	eventResponse.setETCData("CRDT_TERM", 			dmtInvMnVO.getCrTermDys() 		!= null ? dmtInvMnVO.getCrTermDys() 		: "");
            	
            	//Attention
            	eventResponse.setETCData("DMDT_PAYR_CNTC_PNT_NM", dmtInvMnVO.getDmdtPayrCntcPntNm()	!= null ? dmtInvMnVO.getDmdtPayrCntcPntNm() : "");
            	eventResponse.setETCData("CUST_CNTC_PNT_SEQ", 		dmtInvMnVO.getCustCntcPntSeq()	!= null ? dmtInvMnVO.getCustCntcPntSeq() 	: "");
            	
            	//Trucker
            	eventResponse.setETCData("VNDR_SEQ", 			dmtInvMnVO.getVndrSeq() 		!= null ? dmtInvMnVO.getVndrSeq() 			: "");
            	eventResponse.setETCData("VNDR_NM", 			dmtInvMnVO.getVndrNm() 			!= null ? dmtInvMnVO.getVndrNm() 			: "");
            	//Due Date, Credit Term
            	eventResponse.setETCData("DUE_DATE", 			dmtInvMnVO.getDueDt() 			!= null ? dmtInvMnVO.getDueDt() 			: "");
            	eventResponse.setETCData("CR_TERM_DYS", 		dmtInvMnVO.getCrTermDys() 		!= null ? dmtInvMnVO.getCrTermDys() 		: "");
            	//Notice
            	eventResponse.setETCData("NOTICE", 				dmtInvMnVO.getNtcKntCd() 		!= null ? dmtInvMnVO.getNtcKntCd() 			: "");
            	//Cust. Ref.
            	eventResponse.setETCData("INV_REF_NO", 			dmtInvMnVO.getInvRefNo() 		!= null ? dmtInvMnVO.getInvRefNo() 			: "");
            	//Invoice Remark(s)
            	eventResponse.setETCData("INV_RMK1", 			dmtInvMnVO.getInvRmk1() 		!= null ? dmtInvMnVO.getInvRmk1() 			: "");
            	eventResponse.setETCData("INV_RMK2", 			dmtInvMnVO.getInvRmk2() 		!= null ? dmtInvMnVO.getInvRmk2() 			: "");
            	//Charge Currency
            	eventResponse.setETCData("CHG_CURR_CD", 		dmtInvMnVO.getChgCurrCd() 		!= null ? dmtInvMnVO.getChgCurrCd() 		: "");
            	//Total AMT
            	eventResponse.setETCData("BIL_AMT", 			dmtInvMnVO.getBilAmt() 			!= null ? dmtInvMnVO.getBilAmt() 			: "");
            	//Invoice Currency
            	eventResponse.setETCData("INV_CURR_CD", 		dmtInvMnVO.getInvCurrCd() 		!= null ? dmtInvMnVO.getInvCurrCd() 		: "");
            	//Ex. Rate
            	eventResponse.setETCData("INV_XCH_RT", 			dmtInvMnVO.getInvXchRt() 		!= null ? dmtInvMnVO.getInvXchRt() 			: "");
            	//Billing AMT
            	eventResponse.setETCData("INV_CHG_AMT", 		dmtInvMnVO.getInvChgAmt() 		!= null ? dmtInvMnVO.getInvChgAmt() 		: "");
            	//Tax Rate
            	eventResponse.setETCData("TAX_RTO",  			dmtInvMnVO.getTaxRto() 			!= null ? dmtInvMnVO.getTaxRto() 			: "");
            	//Sheet Option Tax Rate
            	eventResponse.setETCData("DFLT_TAX_RTO",		dmtInvMnVO.getDfltTaxRto()		!= null ? dmtInvMnVO.getDfltTaxRto() 		: "");
            	//Tax AMT 
            	eventResponse.setETCData("TAX_AMT",  			dmtInvMnVO.getTaxAmt() 			!= null ? dmtInvMnVO.getTaxAmt() 			: "");
            	//Payable AMT
            	eventResponse.setETCData("INV_AMT", 			dmtInvMnVO.getInvAmt() 			!= null ? dmtInvMnVO.getInvAmt() 			: "");
            	//Manual Invoice Reason
            	eventResponse.setETCData("DMDT_MNL_INV_RSN_CD", dmtInvMnVO.getDmdtMnlInvRsnCd() != null ? dmtInvMnVO.getDmdtMnlInvRsnCd() 	: "");
            	//Manual Invoice Remark(s)
            	eventResponse.setETCData("MNL_INV_RMK", 		dmtInvMnVO.getMnlInvRmk() 		!= null ? dmtInvMnVO.getMnlInvRmk() 		: "");
            	
            	//C.REMARK, H.REMARK
            	eventResponse.setETCData("DMDT_CXL_RSN_CD", 	dmtInvMnVO.getDmdtCxlRsnCd() 	!= null ? dmtInvMnVO.getDmdtCxlRsnCd() 	: "");
            	eventResponse.setETCData("DMDT_CXL_RSN_NM", 	dmtInvMnVO.getDmdtCxlRsnNm() 	!= null ? dmtInvMnVO.getDmdtCxlRsnNm() 	: "");
            	eventResponse.setETCData("CXL_RMK", 			dmtInvMnVO.getCxlRmk() 			!= null ? dmtInvMnVO.getCxlRmk() 		: "");
            	eventResponse.setETCData("INV_HLD_RSN_CD", 		dmtInvMnVO.getInvHldRsnCd() 	!= null ? dmtInvMnVO.getInvHldRsnCd() 	: "");
            	eventResponse.setETCData("INV_HLD_RSN_NM", 		dmtInvMnVO.getInvHldRsnNm() 	!= null ? dmtInvMnVO.getInvHldRsnNm() 	: "");
            	eventResponse.setETCData("INV_HLD_RMK", 		dmtInvMnVO.getInvHldRmk() 		!= null ? dmtInvMnVO.getInvHldRmk() 	: "");
            	eventResponse.setETCData("UPD_DT", 				dmtInvMnVO.getUpdDt() 			!= null ? dmtInvMnVO.getUpdDt() 		: "");
            	eventResponse.setETCData("UPD_OFC_CD", 			dmtInvMnVO.getUpdOfcCd() 		!= null ? dmtInvMnVO.getUpdOfcCd() 		: "");
            	eventResponse.setETCData("UPD_USR_ID", 			dmtInvMnVO.getUpdUsrId() 		!= null ? dmtInvMnVO.getUpdUsrId() 		: "");
            	eventResponse.setETCData("UPD_USR_NM", 			dmtInvMnVO.getUpdUsrNm() 		!= null ? dmtInvMnVO.getUpdUsrNm() 		: "");
            	
            	//Preview 가  나타날 위치정보
            	eventResponse.setETCData("BIL_TO_LOC_DIV_CD", 	dmtInvMnVO.getBilToLocDivCd() 	!= null ? dmtInvMnVO.getBilToLocDivCd() : "");
            	
            	//Payer 에서 Country 비교를 위해서 사용하는 정보
            	eventResponse.setETCData("CRE_CNT_CD", 			dmtInvMnVO.getCreCntCd() 		!= null ? dmtInvMnVO.getCreCntCd() 		: "");
            	
            	//심천(SZPSC) 일 경우 Save, Cancel 버튼의 상태를 제어하기 위한 정보
            	eventResponse.setETCData("SUTH_CHN_ISS_FLG", 	dmtInvMnVO.getSuthChnIssFlg()	!= null ? dmtInvMnVO.getSuthChnIssFlg() : "");
            	eventResponse.setETCData("RHQ_OFC_CD", 			dmtInvMnVO.getRhqOfcCd() 		!= null ? dmtInvMnVO.getRhqOfcCd() 		: "");            	

            	eventResponse.setETCData("INV_NEW_RPT_FLG", 	dmtInvMnVO.getInvNewRptFlg() 	!= null ? dmtInvMnVO.getInvNewRptFlg() 	: "N");
            	eventResponse.setETCData("OTS_CLT_FLG", 		dmtInvMnVO.getOtsCltFlg() 		!= null ? dmtInvMnVO.getOtsCltFlg()		: "");
            	eventResponse.setETCData("COL_OVER_DAY", 		dmtInvMnVO.getColOverDay() 		!= null ? dmtInvMnVO.getColOverDay() 	: "");
            	eventResponse.setETCData("COL_DATE", 			dmtInvMnVO.getColDate() 		!= null ? dmtInvMnVO.getColDate() 		: "");
            	eventResponse.setETCData("COL_CHARGE", 			dmtInvMnVO.getColCharge() 		!= null ? dmtInvMnVO.getColCharge() 	: "");
            	eventResponse.setETCData("COL_TAX", 			dmtInvMnVO.getColTax() 			!= null ? dmtInvMnVO.getColTax() 		: "");
            	eventResponse.setETCData("VT_COLLECTED", 		dmtInvMnVO.getVtCollected() 	!= null ? dmtInvMnVO.getVtCollected() 	: "");
            	
            	eventResponse.setETCData("INV_COL_CHARGE", 		dmtInvMnVO.getInvColCharge()	!= null ? dmtInvMnVO.getInvColCharge() 	: "");
            	eventResponse.setETCData("INV_COL_TAX", 		dmtInvMnVO.getInvColTax() 		!= null ? dmtInvMnVO.getInvColTax() 	: "");
            	eventResponse.setETCData("CHG_COL_CHARGE", 		dmtInvMnVO.getChgColCharge() 	!= null ? dmtInvMnVO.getChgColCharge() 	: "");
            	eventResponse.setETCData("CHG_COL_TAX", 		dmtInvMnVO.getChgColTax() 		!= null ? dmtInvMnVO.getChgColTax() 	: "");
            	eventResponse.setETCData("INV_UNCOL_AMT", 		dmtInvMnVO.getInvUncolAmt() 	!= null ? dmtInvMnVO.getInvUncolAmt() 	: "");
            	eventResponse.setETCData("CHG_UNCOL_AMT", 		dmtInvMnVO.getChgUncolAmt() 	!= null ? dmtInvMnVO.getChgUncolAmt() 	: "");
            	eventResponse.setETCData("IDA_LOCL_TAX", 		dmtInvMnVO.getIdaLoclTax() 	    != null ? dmtInvMnVO.getIdaLoclTax() 	: "");
            	eventResponse.setETCData("IDA_N2ND_LOCL_TAX", 	dmtInvMnVO.getIdaN2ndLoclTax() 	!= null ? dmtInvMnVO.getIdaN2ndLoclTax(): "");
            	eventResponse.setETCData("IDA_CGST_AMT", 		dmtInvMnVO.getIdaCgstAmt() 		!= null ? dmtInvMnVO.getIdaCgstAmt()	: "");
            	eventResponse.setETCData("IDA_SGST_AMT", 		dmtInvMnVO.getIdaSgstAmt() 		!= null ? dmtInvMnVO.getIdaSgstAmt()	: "");
            	eventResponse.setETCData("IDA_IGST_AMT", 		dmtInvMnVO.getIdaIgstAmt() 		!= null ? dmtInvMnVO.getIdaIgstAmt()	: "");
            	eventResponse.setETCData("IDA_UGST_AMT", 		dmtInvMnVO.getIdaUgstAmt() 		!= null ? dmtInvMnVO.getIdaUgstAmt()	: "");
            	
                if ("IN".equals(dmtInvMnVO.getCreCntCd())) {
    	            // 인도 TAX 변경 전 / 후 인지 조회 ( A : After, B : Before )
    	            String idaTaxApplTm = command.searchIdaTaxApplTm(dmtInvMnVO.getDmdtInvNo());
    	            eventResponse.setETCData("IDA_TAX_APPL_TM", idaTaxApplTm);    
                }            	
            }
            
            eventResponse.setRsVoList(dmtInvDtlVOS);
            eventResponse.setRsVoList(dmtInvRtVOS);
        } 
        catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            throw ex;
        } 
        catch(Exception ex){
        	eventResponse.setUserMessage(ex.getMessage());
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;           
    }
    /**
     * EES_DMT_4004 : Retrieve<br>
     * [Invoice Create & Issue]을 [조회] 합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchManualKeyByBooking(Event e) throws EventException {
    	GeneralEventResponse 			eventResponse 			= new GeneralEventResponse();
        InvoiceIssueCollectionMgtBC 	command 				= new InvoiceIssueCollectionMgtBCImpl();
        EesDmt4004Event 				event					= (EesDmt4004Event)e;

        ManualKeyByBookingVO 			manualKeyByBookingVO 	= null;
        List<ManualKeyByChargeVO> 		manualKeyByChargeVOS 	= null;
        List<ManualKeyByBookingVO> 		manualKeyByBookingVOS 	= null;
        
        try {
        	ChargeBookingInvoiceVO 	invoiceVO = event.getChargeBookingInvoiceVO();
       
            InvoiceIssueMgtVO 		invoiceIssueMgtVO =
            	command.searchManualKeyByBooking(invoiceVO.getBkgNo()
            									, account.getOfc_cd()
            									, invoiceVO.getDmdtTrfCd()
            									, invoiceVO.getMnlInvSndFlg());
            
            manualKeyByBookingVOS = invoiceIssueMgtVO.getManualKeyByBookingVOS();
            if (manualKeyByBookingVOS != null && manualKeyByBookingVOS.size() > 0) {
	       		manualKeyByBookingVO = manualKeyByBookingVOS.get(0);
	       		
	       		//Client 에게 보내줄 조회결과를 Response 객체에 설정해준다.
	       		//1.Booking 정보 설정
            	eventResponse.setETCData("VVD_CD", 			 manualKeyByBookingVO.getVvdCd() 		 != null ? manualKeyByBookingVO.getVvdCd() 			: "");
            	eventResponse.setETCData("POR_CD", 			 manualKeyByBookingVO.getPorCd() 		 != null ? manualKeyByBookingVO.getPorCd() 			: "");
            	eventResponse.setETCData("POL_CD", 			 manualKeyByBookingVO.getPolCd() 		 != null ? manualKeyByBookingVO.getPolCd() 			: "");
            	eventResponse.setETCData("POD_CD", 			 manualKeyByBookingVO.getPodCd() 		 != null ? manualKeyByBookingVO.getPodCd() 			: "");
            	eventResponse.setETCData("DEL_CD", 			 manualKeyByBookingVO.getDelCd() 		 != null ? manualKeyByBookingVO.getDelCd() 			: "");
            	eventResponse.setETCData("RCV_TERM_CD", 	 manualKeyByBookingVO.getRcvTermCd() 	 != null ? manualKeyByBookingVO.getRcvTermCd() 		: "");
            	eventResponse.setETCData("DE_TERM_CD", 		 manualKeyByBookingVO.getDeTermCd() 	 != null ? manualKeyByBookingVO.getDeTermCd() 		: "");
            	eventResponse.setETCData("BKG_CUST_CD", 	 manualKeyByBookingVO.getBkgCustCd() 	 != null ? manualKeyByBookingVO.getBkgCustCd() 		: "");
            	eventResponse.setETCData("BKG_CUST_NM", 	 manualKeyByBookingVO.getBkgCustNm() 	 != null ? manualKeyByBookingVO.getBkgCustNm() 		: "");
            	eventResponse.setETCData("ACT_CUST_CD", 	 manualKeyByBookingVO.getActCustCd() 	 != null ? manualKeyByBookingVO.getActCustCd() 		: "");
            	eventResponse.setETCData("ACT_CUST_NM", 	 manualKeyByBookingVO.getActCustNm() 	 != null ? manualKeyByBookingVO.getActCustNm() 		: "");
            	eventResponse.setETCData("ACT_PAYR_CUST_CD", manualKeyByBookingVO.getActPayrCustCd() != null ? manualKeyByBookingVO.getActPayrCustCd() 	: "");
            	eventResponse.setETCData("ACT_PAYR_CUST_NM", manualKeyByBookingVO.getActPayrCustNm() != null ? manualKeyByBookingVO.getActPayrCustNm() 	: ""); 
            	eventResponse.setETCData("VNDR_SEQ", 		 manualKeyByBookingVO.getVndrSeq() 		 != null ? manualKeyByBookingVO.getVndrSeq() 		: "");
            	eventResponse.setETCData("VNDR_NM", 		 manualKeyByBookingVO.getVndrNm() 		 != null ? manualKeyByBookingVO.getVndrNm() 		: "");
            	//Due Date, Credit Term
            	eventResponse.setETCData("DUE_DATE", 		 manualKeyByBookingVO.getDueDt() 		 != null ? manualKeyByBookingVO.getDueDt() 			: "");
            	eventResponse.setETCData("CR_TERM_DYS", 	 manualKeyByBookingVO.getCrTermDys() 	 != null ? manualKeyByBookingVO.getCrTermDys() 		: "");
            	//Tax Rate
            	eventResponse.setETCData("TAX_RTO", 		 manualKeyByBookingVO.getDfltTaxRto() 	 != null ? manualKeyByBookingVO.getDfltTaxRto() 	: "");
            	//S/C No.
            	eventResponse.setETCData("SC_NO", 			 manualKeyByBookingVO.getScNo() 	 	 != null ? manualKeyByBookingVO.getScNo() 			: "");
            	//RFA No.
            	eventResponse.setETCData("RFA_NO", 			 manualKeyByBookingVO.getRfaNo() 	 	 != null ? manualKeyByBookingVO.getRfaNo() 			: "");
            	
	       		//2.Charge 정보 설정
	       		manualKeyByChargeVOS = invoiceIssueMgtVO.getManualKeyByChargeVOS();
	       		eventResponse.setRsVoList(manualKeyByChargeVOS);
            }
        } catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            throw ex;
        } catch(Exception ex){
            eventResponse.setUserMessage(ex.getMessage());
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;           
    } 
    /**
     * EES_DMT_4004 : Retrieve<br>
     * [Charge Container No. 가 정확성]을 [조회] 합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse checkContainerNo(Event e) throws EventException {
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4004Event event = (EesDmt4004Event)e;

        try {
            ChargeBookingInvoiceVO invoiceVO = event.getChargeBookingInvoiceVO();
            String cntrTpszCd = command.checkContainerNo(invoiceVO.getCntrNo());
            
            if (cntrTpszCd != null && cntrTpszCd.length() > 0) {
            	eventResponse.setETCData("VALIDATE", "Y");
            	eventResponse.setETCData("TPSZ_CD", cntrTpszCd);
            }
            else {
            	eventResponse.setETCData("VALIDATE", "N");
            	eventResponse.setETCData("TPSZ_CD", "");            	
            }
            
        } catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            throw ex;
        } catch(Exception ex){
        	eventResponse.setUserMessage(ex.getMessage());
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;           
    }
    /**
     * EES_DMT_4004 : Retrieve<br>
     * [VVD CD. 의 Calling Port]을 [조회] 합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse checkCallingPort(Event e) throws EventException {
    	GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
        InvoiceIssueCollectionMgtBC command 		= new InvoiceIssueCollectionMgtBCImpl();
        EesDmt4004Event 			event 			= (EesDmt4004Event)e;

        try {
            boolean isCallingPort = command.checkCallingPort(event.getChargeBookingInvoiceVO());
           	eventResponse.setETCData("IS_CALLPORT", isCallingPort ? "Y" : "N");
        } catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            throw ex;
        } catch(Exception ex){
        	eventResponse.setUserMessage(ex.getMessage());
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;           
    }
    /**
     * EES_DMT_4004 : Retrieve<br>
     * [VVD CD. 가 존재하는지]를 [조회] 합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse checkVVD(Event e) throws EventException {
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4004Event event = (EesDmt4004Event)e;

        try {
            boolean isVVD = command.checkVVD(event.getChargeBookingInvoiceVO());
            
        	eventResponse.setETCData("IS_VVD", isVVD ? "Y" : "N");
            
        } catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            throw ex;
        } catch(Exception ex){
        	eventResponse.setUserMessage(ex.getMessage());
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;           
    } 
    /**
     * EES_DMT_4004 : Save<br>
     * [Manual Invoice Creation & Issue]을 [수정] 합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse modifyInvoiceByManual(Event e) throws EventException {
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4004Event event = (EesDmt4004Event)e;

		try {
			ManualInvoiceIssueVO manualInvoiceIssueVO = new ManualInvoiceIssueVO();
			
			manualInvoiceIssueVO.setDmtInvMnVO(event.getDmtInvMnVO());
			manualInvoiceIssueVO.setDmtInvDtlVOS(event.getDmtInvDtlVOS());
			manualInvoiceIssueVO.setDmtInvRtVOS(event.getDmtInvRtVOS());
			
			begin();
			command.modifyInvoiceByManual(manualInvoiceIssueVO, account);
			commit();
			
			eventResponse.setETCData("SUCCESS_YN", "Y");
			eventResponse.setUserMessage(new ErrorHandler("DMT03065").getUserMessage());
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		} 
        return eventResponse;           
    }
    /**
     * EES_DMT_4004 : Save<br>
     * [Manual Invoice Creation & Issue]을 [저장] 합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse issueInvoiceByManual(Event e) throws EventException {
    	GeneralEventResponse 			eventResponse 	= new GeneralEventResponse();
        InvoiceIssueCollectionMgtBC 	command 		= new InvoiceIssueCollectionMgtBCImpl();
        EesDmt4004Event 				event 			= (EesDmt4004Event)e;

		ManualInvoiceIssueVO manualInvoiceIssueVO = new ManualInvoiceIssueVO();
		manualInvoiceIssueVO.setDmtInvMnVO(		event.getDmtInvMnVO()		);
		manualInvoiceIssueVO.setDmtInvDtlVOS(	event.getDmtInvDtlVOS()		);
		manualInvoiceIssueVO.setDmtInvRtVOS(	event.getDmtInvRtVOS()		);

    	// INVOICE 발행으로 생성된 정보
    	DmtInvMnVO dmtInvMnVO = new DmtInvMnVO();
    	// 화면으로 전달하기 위한 정보
    	Map<String,String> etcData = new HashMap<String,String>();
    	// 서버 에러메시지
    	StringBuffer sbErrMsg = new StringBuffer();
    	
    	final String SUCCESS = "DMT03064";
    	
        try {
			begin();
			
			// 1. MANUAL INVOICE 발행
			dmtInvMnVO = command.issueInvoiceByManual(manualInvoiceIssueVO, account);
            // 1.1 INVOICE 발행에 대한 메시지
    		sbErrMsg.append(new ErrorHandler(dmtInvMnVO.getErrCode()).getUserMessage());			
			
			// 1.1 MANUAL INVOICE 발행에 성공한 경우
    		if (SUCCESS.equals(dmtInvMnVO.getErrCode())) {
				
    			// 화면에서 발행된 Invoice 를 조회하기 위한 기본값 설정
                etcData.put("INVOICE_NO", dmtInvMnVO.getDmdtInvNo());
                etcData.put("CRE_OFC_CD", dmtInvMnVO.getCreOfcCd());
                etcData.put("SUCCESS_YN", "Y");
                
	    		// 2. Auto A/R I/F 대상인지 여부 조회
	    		String autoArIfYn = command.searchAutoARInfYnByOffice(account.getOfc_cd());
	    		etcData.put("AUTO_AR_INF_YN", autoArIfYn);
	    		
	    		// 2.1 Auto A/R I/F 대상일 경우
	    		if ("Y".equals(autoArIfYn)) {
		    		// Auto A/R I/F 대상인 경우, A/R I/F 실행
		    		boolean isResult = command.sendInvoiceToAr(dmtInvMnVO, account);
		    		
		    		sbErrMsg.setLength(0);
		    		sbErrMsg.append(dmtInvMnVO.getErrMsg());
		    		
		    		if (isResult) {
		    			commit();
		    		}
		    		else {
		    			// 트랜잭션 원복
		    			rollback();
		    			log.error("\n[Biz-1] ERROR ==> Transaction rollback for send invoice to A/R!!");
		    			
		    			etcData.put("SUCCESS_YN", "N");
		    		}
	    		}
	    		// 2.2 Auto A/R I/F 대상이 아닐 경우
	    		else {
	    			// 트랜잭션 종료
	    			commit();
	    		}	    		
			}
			// 1.2 Invoice 발행에 실패한 경우
			else {
    			// 트랜잭션 원복
    			rollback();
    			log.error("\n[Biz-2] ERROR ==> Transaction rollback for creating invoice!!");
    			
    			etcData.put("SUCCESS_YN", "N");				
			}
			
    		eventResponse.setETCData(etcData);
    		eventResponse.setUserMessage(sbErrMsg.toString());			
        } 
    	catch(EventException ex) {
    		// 트랜잭션 원복
    		rollback();
    		log.error("\n EventException ERROR ==> " + ex.getMessage());
    		
            throw ex;
    	}
    	catch(Exception ex) {
    		// 트랜잭션 원복
    		rollback();
    		log.error("\n Exception ERROR ==> " + ex.getMessage());
    		
            throw new EventException(ex.getMessage(), ex);
    	}
        
        return eventResponse;           
    }       
    
//    /**
//     * EES_DMT_4004 : Save<br>
//     * [Manual Invoice Creation & Issue]을 [저장] 합니다.<br>
//     * 
//     * @param Event e
//     * @return EventResponse
//     * @exception EventException
//     */
//    private EventResponse issueInvoiceByManual(Event e) throws EventException {
//    	GeneralEventResponse 			eventResponse 	= new GeneralEventResponse();
//        InvoiceIssueCollectionMgtBC 	command 		= new InvoiceIssueCollectionMgtBCImpl();
//        EesDmt4004Event 				event 			= (EesDmt4004Event)e;
//
//        try {
//			ManualInvoiceIssueVO manualInvoiceIssueVO = new ManualInvoiceIssueVO();
//			
//			manualInvoiceIssueVO.setDmtInvMnVO(		event.getDmtInvMnVO()		);
//			manualInvoiceIssueVO.setDmtInvDtlVOS(	event.getDmtInvDtlVOS()		);
//			manualInvoiceIssueVO.setDmtInvRtVOS(	event.getDmtInvRtVOS()		);
//			
//			begin();
//			String invoiceNo = command.issueInvoiceByManual(manualInvoiceIssueVO, account);
//			commit();
//			
//        	eventResponse.setETCData("SUCCESS_YN", "Y");
//        	eventResponse.setETCData("INV_NO", invoiceNo);
//        	// AUTO-INF. 占썬끋六�占쏙옙湲�占싼됵옙 筌ｋ똾寃�--------------------------------------------------
//			eventResponse.setETCData("AUTO_AR_INF_YN", command.searchAutoARInfYnByOffice(account.getOfc_cd()));
//			// --------------------------------------------------------------------------------
//        	eventResponse.setUserMessage(new ErrorHandler("DMT03064").getUserMessage());
//        	
//        } 
//        catch(EventException ex) {
//        	rollback();
//        	eventResponse.setETCData("SUCCESS_YN", "N");
//        	
//        	boolean isErr = true;
//        	if (isErr) {
//        		eventResponse.setUserMessage(ex.getMessage());
//        	}
//        	else {
//        		throw ex;
//        	}
//        } 
//        catch(Exception ex){
//        	rollback();
//        	eventResponse.setETCData("SUCCESS_YN", "N");
//        	throw new EventException(ex.getMessage(), ex);
//        }
//        
//        return eventResponse;           
//    }    
    
    /**
     * Invoice Cancel 사유를 조회하는 화면
     * @param e
     * @return
     * @throws EventException
     */
    private EventResponse searchCancelReason(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        EesDmt4106Event event = (EesDmt4106Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();

        try{
        	List<DmtCommonReturnDataVO> list = command.searchCancelReason();
            eventResponse.setRsVoList(list);
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
    * EES_DMT_5101 : SEARCH<br>
    * [Hold Reason Entry]을 [SEARCH] 합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchHoldReasonCdList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        try{
            List<DmtCommonReturnDataVO> list = command.searchHoldReasonCdList();
            eventResponse.setRsVoList(list);
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
    * EES_DMT_5101 : SEARCH<br>
    * [Hold Reason Entry]을 [SERARCH] 합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchHoldReason (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt5101Event event = (EesDmt5101Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        String invoiceNo = (String)event.getAttribute("invoiceNo");
        log.debug("####### SC searchHoldReason invoiceNo [" + invoiceNo + "]");
        String holdReason = command.searchHoldReason ( invoiceNo );
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        Map<String,String> etcData = new HashMap<String,String>();
        etcData.put("holdReason",holdReason);
        eventResponse.setETCData(etcData);
        return eventResponse;
    }
    
    /**
    * EES_DMT_5101 : [UPDATE]<br>
    * [Hold Reason Entry]을 [UPDATE]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse modifyInvoiceByHold (Event e) throws EventException {
    
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt5101Event event = (EesDmt5101Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        String invoiceNo = (String)event.getAttribute("invoiceNo");
        String holdReasn = (String)event.getAttribute("holdReasn");
        String holdRemrk = (String)event.getAttribute("holdRemrk");
        try{
            begin();            
            String holdReason = command.modifyInvoiceByHold ( invoiceNo , holdReasn , holdRemrk , account );
            eventResponse.setUserMessage(new ErrorHandler("MST00003").getUserMessage());
            eventResponse.setETCData("holdReason" , holdReason);
            commit(); 
            
        }catch(EventException ex){
        	rollback();
            throw ex;
        }catch(Exception ex){
        	rollback();
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
    }
    
    
    /**
    * EES_DMT_7006 : [ SEARCH ]<br>
    * [ Fax/E-mail Sending History ]을 [ SEARCH ]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchFaxEmailHistory (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt7006Event event = (EesDmt7006Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();

        try{
            List<DmtFaxEmlSndHisVO> list = command.searchFaxEmailHistory(event.getDmtFaxEmlSndHisParmVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}   
        return eventResponse;
        
    }
    /**
     * [Invoice]을 [Cancel] 합니다.<br>
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse cancelInvoice(Event e) throws EventException {
        GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
        List<ChargeArgumentVO> chargeArgumentVOList = new ArrayList<ChargeArgumentVO>();
		ChargeArgumentVO chargeArgumentVO 		= new ChargeArgumentVO();
		String err_code 	= "";
		String err_msg 		= "";
		String create_note	= "";	//ar-if 할 invoice_no
        ChargeCalculationBC commandChrge 		= new ChargeCalculationBCImpl();
        Map<String,String> etcData = new HashMap<String,String>();
        
    	GeneralARInvoiceCreationBC commandAR	= new GeneralARInvoiceCreationBCImpl("DEFAULTXA");		//2011.01.07 XA DataSource占쎌빘苑�
    	
        List<ARInterfaceCreationVO> genIfVOs	= new ArrayList<ARInterfaceCreationVO>();	//ar-if
		List<ARInterfaceCreationVO> rGenIfVOs	= new ArrayList<ARInterfaceCreationVO>();	//ar-if
		ARInterfaceCreationVO arInterfaceCreationVO = new ARInterfaceCreationVO();			//ar-if
		
		CancelInvoiceParamVO paramVO = ((EesDmt4106Event) e).getCancelInvoiceParamVO();
		
		try {

            begin();            
            chargeArgumentVOList = command.cancelInvoice(paramVO, account);
            
        	chargeArgumentVO = (ChargeArgumentVO)chargeArgumentVOList.get(0);
        	err_code 	= chargeArgumentVO.getErrCode();
        	err_msg		= chargeArgumentVO.getErrMsg();
        	create_note = chargeArgumentVO.getCrInvNo();
        	
        	log.debug("\n create_note===>"+create_note);        	
        	
        	//ERROR 발생했을 경우
        	if ("DMT03024".equals(err_code) || "DMT03063".equals(err_code)) {
            	rollback();
                eventResponse.setUserMessage(err_msg);
                etcData.put("SUCCESS_YN","N");
                eventResponse.setETCData(etcData);   
                log.error("[cancelInvoice ERROR]"+err_msg);
                return eventResponse;
            }
        	else {
            	//manual은 charge 상태를 바꾸지 않는다.
            	String invoiceNo = paramVO.getDmdtInvNo();
          	
    			// [ invoice 유형 조회 ]==========================================================================================================
    			// invoice 가 인도지역에서 발행된 경우, 신규세법적용으로 인해서 invoice no. 체계가 달라져 invoice 유형을 가져오는 방법이 달라짐.
    			//================================================================================================================================			
    			String invTpCd = command.searchInvoiceType(invoiceNo);
    			//================================================================================================================================	            	
            	
            	log.debug(">>>>>>>>>>>>>>>>>>>>>[sub_invoice]"+invTpCd);
            	
            	if (!"M".equals(invTpCd)) {
	            	//charge 데이터를 처리한다.
	            	commandChrge.changeChargeStatusForInvoiceByCancel(chargeArgumentVOList, account);
            	} 
				else {
                	log.debug(">>>>>>>>>>>>>>>>>>>>>Manual Invoice");
            		String suth_chn_iss_flg = command.checkSZPBBInvoice(invoiceNo);
                	log.debug(">>>>>>>>>>>>>>>>>>>>>[suth_chn_iss_flg]"+suth_chn_iss_flg);
            		
            		if ("Y".equals(suth_chn_iss_flg)) {
            			//charge 데이터를 처리한다.
    	            	commandChrge.changeChargeStatusForInvoiceByCancel(chargeArgumentVOList, account);
            		}
            	}
            	
            	//commit();//2011.01.07 One Tx 변경
            	
            	if ("DMT03062".equals(err_code)){//ar-if 를 실행한다.
            		//check logic
            		
            		//------------------------------------------------------------------------------
            		// AR IF 를 실행할 데이터 조회를 위한 매개변수 설정
            		//------------------------------------------------------------------------------
            		ARInterfaceCreationCondVO arInfCondVO = new ARInterfaceCreationCondVO();
            		arInfCondVO.setUsrOfcCd(account.getOfc_cd());
            		arInfCondVO.setDmdtInvNo(create_note);
            		arInfCondVO.setCrInvFlg("Y");
            		arInfCondVO.setCreOfcCd(paramVO.getCreOfcCd());
            		arInfCondVO.setIdaTaxApplTm(paramVO.getIdaTaxApplTm());
            		//------------------------------------------------------------------------------            		
            		// AR IF 를 실행할 데이터를 조회한다.
            		//------------------------------------------------------------------------------
            		arInterfaceCreationVO = command.searchARInterfaceInvoice(arInfCondVO);
            		//------------------------------------------------------------------------------
    	            genIfVOs.add(arInterfaceCreationVO);
    	            
    	            // AR INTERFACE CALL
    	            rGenIfVOs = commandAR.interfaceGeneralARInvoiceToIF(genIfVOs);
    	           	String arIfNo = commandAR.interfaceGeneralARInvoiceToINV(rGenIfVOs);
    	            // AR INTERFACE END
	
    	           	log.debug("\n arIfNo===>"+arIfNo);        	
	    	        
					if (StringUtils.isEmpty(arIfNo)) {
    	            	etcData.put("SUCCESS_YN", "N");
    	                eventResponse.setETCData(etcData);   
    	            	log.error("\n AR_IF_NO NULL===============");
    	            	eventResponse.setUserMessage("Cancelled! A/R I/F failed! Credit Note: "+create_note);//筌롫뗄�놅쭪占쏙㎗�롡봺
    	                log.error("Cancelled! A/R I/F failed! Credit Note: "+create_note);
    	            	rollback();//2011.01.07 One Tx 변경
    	            } 
					else {
    	            	String arIfNo_arr[] = arIfNo.split("::");
    	            	//성공
    	            	if ("S".equals(arIfNo_arr[0])) {
    	            		// DMT TABLE UPDATE
    			        	command.modifyARInterface(account, arIfNo_arr[1], create_note, paramVO.getCreOfcCd());
    			            
    			            //cancel 메시지 처리함
    	    	            eventResponse.setUserMessage(err_msg);
    	                	etcData.put("SUCCESS_YN","Y");
    	                	eventResponse.setETCData(etcData);
    	                	
    	                	//추가 EDI create_note
    	                	//String sub_invoice = invoice_no.substring(2, 3);
    	                	//EDI 변수선언
    	                	String					ydCd	= null;
    	        			EDIVO 					eDIVO 	= null;
    	        			List<EDIVO> 			eDIVOs	= null;
    	        			List<EDIContainerVO>	eDIContainerVOs = null;

    	        			// [ invoice 유형 조회 ]==========================================================================================================
    	        			// invoice 가 인도지역에서 발행된 경우, 신규세법적용으로 인해서 invoice no. 체계가 달라져 invoice 유형을 가져오는 방법이 달라짐.
    	        			//================================================================================================================================			
    	        			invTpCd = command.searchInvoiceType(create_note);
    	        			//================================================================================================================================			    	                	
    	                	
    	                	if (!"M".equals(invTpCd)) {//manual invoice는 edi를 실행 시키지 않는다.
    	                		String ioBndCd = arInterfaceCreationVO.getInvArIfMnVO().getIoBndCd();

    			            	//in bound 만 실행시킨다.
    			            	if ("I".equals(ioBndCd)) {
    					            log.debug("\n =========> AR-IF SUCESS!! EDI SEND data search start !!");
    								eDIContainerVOs = command.searchEDIContainerInfoByInvoice(invoiceNo, paramVO.getCreOfcCd());	//EDI嚥∽옙占쎄쑴�싷옙占쏙옙怨쀬뵠占쎄퀡占�鈺곌퀬�띰옙�뺣뼄.
    								
    								if (eDIContainerVOs != null && eDIContainerVOs.size() > 0 ) {
    									eDIVOs = new ArrayList<EDIVO>(); 
										
										for (EDIContainerVO ediContainerVO : eDIContainerVOs) {
										
    										ydCd = ediContainerVO.getFmMvmtYdCd();
    										
    										if (ydCd == null || ydCd.length() != 7) continue;
    										
    										String locCd = ydCd.substring(0, 5);
    										//2012.05.11 KRGIN 추가 
    										if ("KOR".equals(ediContainerVO.getSvrId()) 
    												&& ("KRPUS".equals(locCd) ||
    													"KRKAN".equals(locCd) ||
														"KRINC".equals(locCd) ||
														"KRPYT".equals(locCd) ||
														"KRUSN".equals(locCd) ||
														"KRGIN".equals(locCd) ||
														"KRPTK".equals(locCd) )) { 
    														
    											eDIVO = new EDIVO();
    											eDIVO.setBkgNo(			ediContainerVO.getBkgNo()		);
    											eDIVO.setSysAreaGrpId(	ediContainerVO.getSvrId()		);
    											eDIVO.setCntrNo(		ediContainerVO.getCntrNo()		);
    											eDIVO.setCntrCycNo(		ediContainerVO.getCntrCycNo()	);
    											eDIVO.setAcount(		account							);
    											eDIVOs.add(eDIVO);
    										}
    									}
    								}
    								
    								if (eDIVOs != null && eDIVOs.size() > 0) {
    									log.debug("\n =========> EDI common module start !!");
    									//공통모듈을 통해서 EDI 전송을 수행한다.
    									commandChrge.sendToEDI(eDIVOs);
    								}
    			            	}
    	                	}
        	            	commit();//2011.01.07 One Tx 변경
        	            	
        	            	//2011.02.23 ERP로직 분리
        	            	begin();
        	            	commandAR.interfaceARInvoiceToERPAR(arIfNo_arr[1]);
        	            	commit();
        	            	
    	            	} 
						else {
        	            	rollback();//2011.01.07 One Tx 변경
        	            	
    		            	etcData.put("SUCCESS_YN", "N");
    		            	eventResponse.setETCData(etcData);   
    		            	log.error("\n AR_IF_ERROR MSG===============>"+arIfNo_arr[1]);
    		            	
        	            	eventResponse.setUserMessage("Cancelled! A/R I/F failed! Credit Note: "+create_note);//筌롫뗄�놅쭪占쏙㎗�롡봺
    	            	}
    	            }
            		//***********************************************************************************
            	} 
				else if ("DMT03061".equals(err_code)) {//메시지만 처리한다.
            		eventResponse.setUserMessage(err_msg);
                	etcData.put("SUCCESS_YN","Y");
                	eventResponse.setETCData(etcData);
                	commit();//2011.01.07 One Tx 변경
                //cancel 만 된 경우는 메시지 처리 하지 않고 끝낸다
            	} 
				else {
            		etcData.put("SUCCESS_YN","Y");
                	eventResponse.setETCData(etcData);
                	commit();//2011.01.07 One Tx 변경
            	}
            }
        } 
		catch(EventException ex) {
            rollback();
            log.error("\n EventException : "+ex.toString());
            throw ex;
        }
		catch(Exception ex) {
        	rollback();
        	log.error("\n Exception : "+ex.toString());
			throw new EventException(ex.getMessage(), ex);
		}
		
        return eventResponse;
    }   
    /**
     * Payer정보를 조회한다.
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchPayerInformation(Event e) throws EventException {
    	GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
		try{
			PayerInformationVO payrInfomationVO = command.searchPayerInformation(((EesDmt4104Event)e).getPayerInfoParamVO());
			List<DmtPayrCntcPntVO> list = payrInfomationVO.getDmtPayrCntcPntVOs();
			DmtPayrInfoVO dmtPayrInfoVO = payrInfomationVO.getDmtPayrInfoVO();
			
            eventResponse.setRsVoList(list);
            eventResponse.setETCData(dmtPayrInfoVO.getColumnValues());
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;

    }    
    
    /**
     * Demand Note Issue Preview 조회한다.
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchDemandNoteIssuePreview(Event e) throws EventException {
    	 DemandNoteSendBC command = new DemandNoteSendBCImpl();
    	 InvoiceIssueCollectionMgtBC invCommand = new InvoiceIssueCollectionMgtBCImpl();
         GeneralEventResponse eventResponse  = new GeneralEventResponse();
         
		try {
			EesDmt3007Event event = (EesDmt3007Event)e;
			DemandNotePreviewParmVO paramVO = event.getDemandNotePreviewParmVO();
			
			paramVO.setSessionUsrId(account.getUsr_id());
			paramVO.setSessionOfcCd(account.getOfc_cd());
			
			DemandNotePreviewMstVO demandNotePreviewMstVO = command.searchDemandNoteIssueMstPreview(paramVO);
            eventResponse.setETCData(demandNotePreviewMstVO.getColumnValues());
            
			if (!"group".equals(paramVO.getCallToRdTp())) {
				DemandNotePreviewEtcVO demandNotePreviewEtcVO = command.searchDemandNoteIssueEtcPreview(paramVO);
	            eventResponse.setETCData(demandNotePreviewEtcVO.getColumnValues());
			}
			
            if ("IN".equals(paramVO.getUsrCntCd())) {
            	
            	String prefix = "Y".equals(paramVO.getRdVarNmFlg()) ? "rd_" : "";

	            if ("B".equals(paramVO.getIdaTaxApplTm())) {
	                 SearchIndiaGstRateVO indiaGstRateVO = invCommand.searchIndiaGstRate("");
	    	        	
	                 // Demand Note Issue - Booking ( EES_DMT_3109 ) 에서 사용됨.
	                 eventResponse.setETCData(prefix + "tax_rgst_no",  indiaGstRateVO.getTaxRgstNo());
	                 eventResponse.setETCData(prefix + "svc_cate_rmk", indiaGstRateVO.getSvcCateRmk());
	                 eventResponse.setETCData(prefix + "pmnt_acct_no", indiaGstRateVO.getPmntAcctNo());
	            }
	            else {
		            String payrCd = paramVO.getPayerCd();
		            IdaGstRtoCondVO condVO = new IdaGstRtoCondVO();
		            condVO.setCondIdaSacCd(paramVO.getCondIdaSacCd());
		            condVO.setOfcCd(account.getOfc_cd());
		            if (payrCd.startsWith("00")) {
		            	condVO.setCustCntCd("");
		            	condVO.setCustSeq(payrCd.substring(2));
		            	condVO.setCustVndrDivCd("V");
		            }
		            else {
		            	condVO.setCustCntCd(payrCd.substring(0, 2));
		            	condVO.setCustSeq(payrCd.substring(2));
		            	condVO.setCustVndrDivCd("C");
		            }
		            
    				// Customer State Code / GSTN # No. / SAC Code
		            IdaGstRtoVO idaGstRtoVO = invCommand.searchIdaGstInfo(condVO);
	                eventResponse.setETCData(prefix + "ida_gst_rgst_no", idaGstRtoVO.getIdaGstRgstNo());	// Customer GSTN
	                eventResponse.setETCData(prefix + "ida_ste_cd",      idaGstRtoVO.getIdaSteCd());
	                eventResponse.setETCData(prefix + "ida_sac_cd",      idaGstRtoVO.getIdaSacCd());
    				
    				// Office GST No., PAN No.
    				idaGstRtoVO = invCommand.searchIdaGstInfoByOffice(condVO);
	                eventResponse.setETCData(prefix + "tax_rgst_no",    idaGstRtoVO.getIdaGstRgstNo());	// Office GST No.
	                eventResponse.setETCData(prefix + "ida_ofc_ste_cd", idaGstRtoVO.getIdaSteCd());
	                eventResponse.setETCData(prefix + "svc_cate_rmk",   idaGstRtoVO.getIdaSvcCateRmk());
	                eventResponse.setETCData(prefix + "pmnt_acct_no",   idaGstRtoVO.getIdaPanNo());
	                eventResponse.setETCData(prefix + "ida_tax_cin",    idaGstRtoVO.getIdaTaxCin());
	            }
            }
        }
		catch(EventException ex) {
            throw ex;
        } 
		catch(Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
    }     
    
    
    /**
     * Payer Name 정보를 조회한다.<br>
     * 
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchPayerName(Event e) throws EventException {
    	GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
		try{
			List<DmtPayrInfoVO> list = command.searchPayerName(((EesDmt4104Event)e).getPayerInfoParamVO());//PayerInfoParamVO
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("=").append(" ").append("|");

				for (int i = 0 ; i < list.size(); i++) {
					//DMT,MDM,BKG = GENERAL,CREDIT, ... = NAME 
					codes.append(list.get(i).getJobTp()).append("=").append(list.get(i).getGubun()).append("=").append(list.get(i).getDmdtPayrNm());
					if (i < list.size() - 1) codes.append("|");
				}
			}		
			log.debug("\n payer_name list--->"+codes.toString());
			eventResponse.setETCData("PAYER_NAME", codes.toString());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
		return eventResponse;
    }
	/**
	 * Payer Address 정보를 조회한다.<br>
	 * 
     * @param e
     * @return EventResponse
     * @throws EventException
	 */
    private EventResponse searchPayerAddress(Event e) throws EventException {
    	GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
		try{
			List<DmtPayrInfoVO> list = command.searchPayerAddress(((EesDmt4104Event)e).getPayerInfoParamVO());//PayerInfoParamVO
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("=").append(" ").append("|").append(" ");

				for (int i = 0 ; i < list.size(); i++) {
					//DMT,MDM,BKG = GENERAL,CREDIT, ... = ADDR 
					codes.append(list.get(i).getJobTp()).append("=").append(list.get(i).getGubun()).append("=").append(list.get(i).getDmdtPayrAddr()).append("=").append(" ");
					if (i < list.size() - 1) codes.append("|");
				}
			}		
			
			log.debug("\n payer_addr list--->"+codes.toString());
			eventResponse.setETCData("PAYER_ADDR", codes.toString());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
		return eventResponse;
    }
	/**
	 * Payer Contact Point 정보를 조회한다.<br>
	 * 
     * @param e
     * @return EventResponse
     * @throws EventException
	 */
    private EventResponse searchPayerContactPointName(Event e) throws EventException {
    	GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
		try{
			List<DmtPayrInfoVO> list = command.searchPayerContactPointName(((EesDmt4104Event)e).getPayerInfoParamVO());//PayerInfoParamVO
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("=").append(" ").append("|");

				for (int i = 0 ; i < list.size(); i++) {
					//DMT,MDM,BKG = GENERAL,CREDIT, ... = ContractPointName 
					codes.append(list.get(i).getJobTp()).append("=").append(list.get(i).getGubun()).append("=").append(list.get(i).getDmdtPayrCntcPntNm());
					if (i < list.size() - 1) codes.append("|");
				}
			}		
			eventResponse.setETCData("PAYER_CNTC_PNT_NM", codes.toString());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
		return eventResponse;
    }
	/**
	 * Payer Phone No 정보를 조회한다.<br>
	 * 
     * @param e
     * @return EventResponse
     * @throws EventException
	 */
    private EventResponse searchPayerPhoneNo(Event e) throws EventException {
    	GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
		try{
			List<DmtPayrInfoVO> list = command.searchPayerPhoneNo(((EesDmt4104Event)e).getPayerInfoParamVO());//PayerInfoParamVO
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("=").append(" ").append("|");

				for (int i = 0 ; i < list.size(); i++) {
					//DMT,MDM,BKG = GENERAL,CREDIT, ... = PhoneNo 
					codes.append(list.get(i).getJobTp()).append("=").append(list.get(i).getGubun()).append("=").append(list.get(i).getDmdtPayrPhnNo());
					if (i < list.size() - 1) codes.append("|");
				}
			}		
			eventResponse.setETCData("PAYER_PHN_NO", codes.toString());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
		return eventResponse;
    }
	/**
	 * Payer Fax No 정보를 조회한다.<br>
	 * 
     * @param e
     * @return EventResponse
     * @throws EventException
	 */
    private EventResponse searchPayerFaxNo(Event e) throws EventException {
    	GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
		try{
			List<DmtPayrInfoVO> list = command.searchPayerFaxNo(((EesDmt4104Event)e).getPayerInfoParamVO());//PayerInfoParamVO
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("=").append(" ").append("|");

				for (int i = 0 ; i < list.size(); i++) {
					//DMT,MDM,BKG = GENERAL,CREDIT, ... = FAX NO 
					codes.append(list.get(i).getJobTp()).append("=").append(list.get(i).getGubun()).append("=").append(list.get(i).getDmdtPayrFaxNo());
					if (i < list.size() - 1) codes.append("|");
				}
			}		
			eventResponse.setETCData("PAYER_FAX_NO", codes.toString());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
		return eventResponse;
    }
	/**
	 * Payer Email 정보를 조회한다.<br>
	 * 
     * @param e
     * @return EventResponse
     * @throws EventException
	 */
    private EventResponse searchPayerEmail(Event e) throws EventException {
    	GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
		try{
			List<DmtPayrInfoVO> list = command.searchPayerEmail(((EesDmt4104Event)e).getPayerInfoParamVO());//PayerInfoParamVO
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("=").append(" ").append("|");

				for (int i = 0 ; i < list.size(); i++) {
					//DMT,MDM,BKG = GENERAL,CREDIT, ... = Email 
					codes.append(list.get(i).getJobTp()).append("=").append(list.get(i).getGubun()).append("=").append(list.get(i).getDmdtPayrN1stEml());
					if (i < list.size() - 1) codes.append("|");
				}
			}		
			eventResponse.setETCData("PAYER_EMAIL", codes.toString());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
		return eventResponse;
    }
    
    /**
     * Payer Info 정보를 저장한다.<BR>
     * @param e
     * @return
     * @throws EventException
     */
    private EventResponse managePayerInformation(Event e) throws EventException {
        InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        PayerInformationVO payerInformationVO 	= new PayerInformationVO();
        Map<String,String> etcData 				= new HashMap<String,String>();
        
        try{
            //EesDmt4002Event event = (EesDmt4002Event)e;
        	payerInformationVO.setDmtPayrInfoVO(((EesDmt4104Event)e).getDmtPayrInfoVO());
        	payerInformationVO.setDmtPayrCntcPntVOs(((EesDmt4104Event)e).getDmtPayrCntcPntVOs());
        	
            begin();
            command.managePayerInformation(payerInformationVO, account);
            etcData.put("SUCCESS_YN", "Y");
            eventResponse.setETCData(etcData);
            commit();

        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex){
        	rollback();
        	throw new EventException(ex.getMessage(), ex);
        } 
        return eventResponse;           
    	
    }
    
    /**
     * Payer Info List를 조회한다.
     * 
     * @param e
     * @return
     * @throws EventException
     */
    private EventResponse searchPayerInfoList(Event e) throws EventException {
    	GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
        try{
			List<PayerInfoListVO> list = command.searchPayerInfoList(((EesDmt7020Event)e).getPayerInfoListVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
		return eventResponse;
    }
    
    /**
     * EES_DMT_4016-1 : Manual Billing<br>
     * Finished된 Booking별  Tariff Type별, "SZPSC"별 Charge 계산된 정보를 조회한다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchChargeInvoiceBySZPBB(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4016Event event = (EesDmt4016Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        ChargeCalculationBC commandChrge 	= new ChargeCalculationBCImpl();
        
        try{
        	//1.searchVVDCheckData
        	VVDCheckDataVO vVDCheckDataVO = command.searchVVDCheckData(event.getIssuedInvoiceParamVO());
        	if(!vVDCheckDataVO.getBkgNo().equals("")) {
	        	//2.modifyBookingContainerVVD
	        	commandChrge.modifyBookingContainerVVD(vVDCheckDataVO);
        	}
        	
        	//3.실제 조회 로직 처리
        	InvoiceIssueMgtVO invoiceIssueMgtVO = command.searchChargeInvoiceBySZPBB(event.getIssuedInvoiceParamVO(), account);
            
            List<InvoiceIssueVO> invIssueVOList = invoiceIssueMgtVO.getInvoiceIssueVOs();
            List<ChrgDtlVO> chrgDtlVOList = invoiceIssueMgtVO.getChrgDtlVOs();
            ChargeBookingInvoiceVO chargeBookingInvoiceVO = invoiceIssueMgtVO.getChargeBookingInvoiceVO();
            
            eventResponse.setRsVoList(invIssueVOList);	// Charge
            eventResponse.setRsVoList(chrgDtlVOList);	// Rate Detail
            
            Map<String, String> etcData = chargeBookingInvoiceVO.getColumnValues();
			Set<String> keys = etcData.keySet();
			Iterator<String> it = keys.iterator();
			
			while(it.hasNext()) {
				String key = (String)it.next();
				if(etcData.get(key) == null)
					etcData.put(key, "");
			}
			
            eventResponse.setETCData(etcData);
            
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
     * EES_DMT_4016 : Retrieve<br>
     * [Invoice Create & Issue]을 [조회] 합니다.(Invoice Issue 후)<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchIssuedInvoiceBySZPBB(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4016Event event = (EesDmt4016Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        
        try{
            InvoiceIssueMgtVO invoiceIssueMgtVO = command.searchIssuedInvoiceBySZPBB(event.getIssuedInvoiceParamVO());
            
            List<InvoiceIssueVO> invIssueVOList = invoiceIssueMgtVO.getInvoiceIssueVOs();
            List<ChrgDtlVO> chrgDtlVOList = invoiceIssueMgtVO.getChrgDtlVOs();
            ChargeBookingInvoiceVO chargeBookingInvoiceVO = invoiceIssueMgtVO.getChargeBookingInvoiceVO();
            
            eventResponse.setRsVoList(invIssueVOList);	// Charge
            eventResponse.setRsVoList(chrgDtlVOList);	// Rate Detail
            eventResponse.setETCData(chargeBookingInvoiceVO.getColumnValues());
            
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
     * EES_DMT_4016 : SAVE<br>
     * Confirm된 Charge를 Invoice Issue한다.(Invoice Issue 전)
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse issueInvoiceBySZPBB(Event e) throws EventException {

    	log.debug("SC start....................");
    	InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
        ChargeCalculationBC commandChrge 		= new ChargeCalculationBCImpl();
        GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        InvoiceIssueMgtVO invoiceIssueMgtVO 	= new InvoiceIssueMgtVO();
        DmtInvMnVO dmtInvMnVO = new DmtInvMnVO();
        Map<String,String> etcData = new HashMap<String,String>();
        try{
            EesDmt4016Event event = (EesDmt4016Event)e;
            invoiceIssueMgtVO.setChargeBookingInvoiceVO(event.getChargeBookingInvoiceVO());
            invoiceIssueMgtVO.setInvoiceIssueVOs(event.getInvoiceIssueVOs());
            invoiceIssueMgtVO.setChrgDtlVOs(event.getChrgDtlVOs());
            
            begin();
            dmtInvMnVO = command.issueInvoiceBySZPBB(invoiceIssueMgtVO, account);
            
            //invoice no를 추가한다.
            invoiceIssueMgtVO.getChargeBookingInvoiceVO().setDmdtInvNo(dmtInvMnVO.getDmdtInvNo());
            
            if(dmtInvMnVO.getErrCode().equals("DMT03064")){//성공
                commandChrge.changeChargeStatusForInvoice(invoiceIssueMgtVO, account);
                
                etcData.put("INVOICE_NO", dmtInvMnVO.getDmdtInvNo());
                etcData.put("SUCCESS_YN", "Y");
                eventResponse.setETCData(etcData);
            	eventResponse.setUserMessage(new ErrorHandler(dmtInvMnVO.getErrCode()).getUserMessage());
                commit();
            	//rollback();
                
            //error처리
            } else {
                etcData.put("SUCCESS_YN", "N");
                eventResponse.setETCData(etcData);
            	eventResponse.setUserMessage(new ErrorHandler(dmtInvMnVO.getErrCode()).getUserMessage());
            	rollback();
            }
            
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex){
        	rollback();
        	throw new EventException(ex.getMessage(), ex);
        } 
        return eventResponse;           
    }
   
    
    /**
	 * [EES_DMT_4002] : [ARIF] <br>
	 * [ARInterface]을 [create]합니다<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
     */
    private EventResponse createInvoiceData(Event e) throws EventException {
    	InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
    	GeneralARInvoiceCreationBC commandAR	= new GeneralARInvoiceCreationBCImpl("DEFAULTXA");//2011.01.07 XA DataSource생성
    	ChargeCalculationBC commandCharge		= new ChargeCalculationBCImpl();
    	
        GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        
        List<ARInterfaceCreationVO> genIfVOs	= new ArrayList<ARInterfaceCreationVO>();	
		List<ARInterfaceCreationVO> rGenIfVOs	= new ArrayList<ARInterfaceCreationVO>();	
		ARInterfaceCreationVO arInterfaceCreationVO = new ARInterfaceCreationVO();
		
		
		Map<String,String> etcData = new HashMap<String,String>();
		String arIfNo 	    = "";
		String invoiceNo    = "";
		String creOfcCd	    = "";
		String idaTaxApplTm = "";

		String[] invoiceNos 	= null;
		String[] idaTaxApplTms  = null;
		ConfirmChargeListVO[] confirmChargeListVOs = null;
		InvoiceInterfaceARByDetailVO[] invoiceInterfaceARByDetailVOs = null;
		List<ConfirmChargeListVO> list = new ArrayList<ConfirmChargeListVO>();
		
		int total_cnt = 0;
		int success_cnt = 0;
		int fail_cnt = 0;
		String msg = "";
		String ar_err_msg = "";
		StringBuffer sb_ar_err_msg = new StringBuffer();
		
		ChargeBookingInvoiceVO chargeBookingInvoiceVO = new ChargeBookingInvoiceVO();
		
        try {
			// 4002 단건 ( Invoice Creation & Issue - Booking )
        	if (e instanceof EesDmt4002Event) {			
				IssuedInvoiceParamVO paramVO = ((EesDmt4002Event)e).getIssuedInvoiceParamVO();
			
        		invoiceNo     = paramVO.getSInvoiceNo();
        		creOfcCd      = paramVO.getSOfcCd();		//creOfcCd 추가
				idaTaxApplTm  = paramVO.getIdaTaxApplTm();
        		invoiceNos    = new String[1];
        		invoiceNos[0] = invoiceNo;	//invoice 배열화				
        	}
			// 4016 ( [ SZPSC ] Invoice Creation & Issue - Booking )
			else if (e instanceof EesDmt4016Event) {	
				ChargeBookingInvoiceVO paramVO = ((EesDmt4016Event)e).getChargeBookingInvoiceVO();
				
        		invoiceNo     = paramVO.getDmdtInvNo();
        		creOfcCd      = paramVO.getCreOfcCd();	//creOfcCd 추가
				idaTaxApplTm  = paramVO.getIdaTaxApplTm();
        		invoiceNos    = new String[1];
        		invoiceNos[0] = invoiceNo;	//invoice 배열화				
        	}
			// 4004 ( Manual Invoice Creation & Issue )
			else if (e instanceof EesDmt4004Event) {	
				DmtInvMnVO paramVO = ((EesDmt4004Event)e).getDmtInvMnVO();
				
        		invoiceNo     = paramVO.getDmdtInvNo();
        		creOfcCd      = paramVO.getCreOfcCd();				//creOfcCd 추가
				idaTaxApplTm  = paramVO.getIdaTaxApplTm();
        		invoiceNos    = new String[1];
        		invoiceNos[0] = invoiceNo;	//invoice 배열화
        	}
			// 4013 다건 ( Invoice Creation - Group )
			else if (e instanceof EesDmt4013Event) {	
        		confirmChargeListVOs = ((EesDmt4013Event)e).getConfirmChargeListVOs();
        		creOfcCd = ((EesDmt4013Event)e).getInvoiceGroupParamVO().getUsrOfc();

        		// 배열을 ArrayList 형으로 변환시켜준다.
        		list = Arrays.asList(confirmChargeListVOs);

        		List<String> invoiceNoList = new ArrayList<String>();
        		List<String> taxApplTmList = new ArrayList<String>();
        		
        		// 중복되지 않은 Invoice No. 목록을 만들어준다.=============================================================
        		final String CHECK = "1";
        		for (ConfirmChargeListVO cfmChgVO : list) {
        			// 목록에서 선택되고, Invoice 발행된 경우에는 A/R I/F 처리를 위한 목록에 추가해 줍니다.
        			if (CHECK.equals(cfmChgVO.getCheckBox()) && StringUtils.isNotEmpty(cfmChgVO.getDmdtInvNo())) {
        				if (!invoiceNoList.contains(cfmChgVO.getDmdtInvNo())) {
        					invoiceNoList.add(cfmChgVO.getDmdtInvNo());
        					taxApplTmList.add(cfmChgVO.getIdaTaxApplTm());
        				}
        			}
        		}
        		
        		invoiceNos = invoiceNoList.toArray(new String[invoiceNoList.size()]);
        		idaTaxApplTms = taxApplTmList.toArray(new String[taxApplTmList.size()]);
        		//==========================================================================================================
        	} 
			//5003 다건 ( Invoice Interface to A/R - Detail )
			else if (e instanceof EesDmt5003Event) {	
        		invoiceInterfaceARByDetailVOs =  ((EesDmt5003Event)e).getInvoiceInterfaceARByDetailVOS();
        		creOfcCd = ((EesDmt5003Event)e).getInvoiceInterfaceARParmVO().getOfcCd();
        		
        		invoiceNos = new String[invoiceInterfaceARByDetailVOs.length];
        		idaTaxApplTms = new String[invoiceInterfaceARByDetailVOs.length];
        		
        		for (int i = 0 ; i < invoiceInterfaceARByDetailVOs.length ; i++) {
        			invoiceNos[i] = invoiceInterfaceARByDetailVOs[i].getDmdtInvNo();
        			idaTaxApplTms[i] = invoiceInterfaceARByDetailVOs[i].getIdaTaxApplTm();
        		}
        	}
        	
        	List<String> invoiceNoList = new ArrayList<String>();
        	int iArIfCnt = 0;
        	
    		//AR-IF 전송 갯수 체크 로직 추가(2010.04.09)
        	invoiceNoList = command.searchARIFCount(invoiceNos, creOfcCd, "1");
        	
			for (String invNo : invoiceNoList) {
				if (!StringUtils.isEmpty(invNo)) iArIfCnt++;
			}

        	
        	//비정상적인 경우 -- AR-IF를 실행한 INVOICE가 존재하면 AR-IF를 실행하면 안된다.
    		if (iArIfCnt > 0) {
    			etcData.put("SUCCESS_YN", "N");
                log.error("ERROR || It's already interfaced to A/R. Please check again ! (AR-IF COUNT =>" + iArIfCnt +")");
                eventResponse.setETCData(etcData);
    			eventResponse.setUserMessage(new ErrorHandler("DMT01024").getUserMessage());
    			
    			if (e instanceof EesDmt4013Event) {
    				//AR-IF 된 INVOICE에 대하여는 AR-IF를 Y로 체크 해준다.
    				for (int i = 0; i < list.size(); i++) {
	            		ConfirmChargeListVO tempVO = (ConfirmChargeListVO)list.get(i);
	            		for (int j = 0; j < invoiceNoList.size(); j++) {
	                		if (!StringUtils.isEmpty(invoiceNoList.get(j))) {	//AR-IF 한 INVOICE는 Y로 변경한다.
	                			if (("1".equals(tempVO.getCheckBox())) && (invoiceNoList.get(j).equals(tempVO.getDmdtInvNo()))) {
	                				tempVO.setDmdtArIfCd("Y");
	                				break;
	                			}
	                		}
	                	}
	            		
	            		list.set(i, tempVO);
	            	}    				
	            	eventResponse.setRsVoList(list);
	            }
                return eventResponse;  
    		}
    		
    		//2010-11-26 invoice currency 존재하지 않으면 에러 처리 함.
        	invoiceNoList = command.searchARIFCount(invoiceNos, creOfcCd, "2");
        	int iCurBlankCnt = 0;
			
			for (String invNo : invoiceNoList) {
				if (!"Y".equals(invNo)) iCurBlankCnt++;
			}

        	if (iCurBlankCnt > 0) {
        		etcData.put("SUCCESS_YN", "N");
        		eventResponse.setETCData(etcData);
        		String message = new ErrorHandler("DMT02002").getUserMessage();
        		message = JSPUtil.replace(message, "XXX", "INV Cur.");
            	eventResponse.setUserMessage(message);
                return eventResponse;
        	}
    		
    		
    		//2010-05-28 invoice status가 "C" 이면 ar_if 할때 flag 값을 "Y"로 넘겨 (-) 금액으로 전달한다.
    		String creditNoteYn = "N";
    		String invStsCd     = "";
    		
        	//EDI 변수선언
        	String					ydCd	= null;
			EDIVO 					eDIVO 	= null;
			List<EDIVO> 			eDIVOs	= null;
			List<EDIContainerVO>	eDIContainerVOs = null;
        	
        	//단건 처리
        	if (e instanceof EesDmt4002Event || e instanceof EesDmt4016Event || e instanceof EesDmt4004Event) {
        		//invoice status 조회
        		invStsCd = command.searchInvoiceStatus(invoiceNo, creOfcCd);
        		
				creditNoteYn = "C".equals(invStsCd) ? "Y" : "N";
        		
				//================ 2010.06.04 ###  ar_ofc_cd = 'LEHSC' and aft_inv_adj_amt > 0 이면 error 처리
        		if ("N".equals(creditNoteYn)){
        			chargeBookingInvoiceVO = command.checkAftInvAdjAmtByInvoiceNo(invoiceNo, creOfcCd, account.getOfc_cd());
        			if (chargeBookingInvoiceVO.getArIfOfcCd().length() > 0 && chargeBookingInvoiceVO.getAftInvAdjAmt().length() > 0) {
	        			if(chargeBookingInvoiceVO.getArIfOfcCd().equals("LEHSC") && !chargeBookingInvoiceVO.getAftInvAdjAmt().equals("0")){
	        				etcData.put("SUCCESS_YN", "N");
	        				log.error("\n LEHSC===============>AFT_INV_ADJ_AMT["+chargeBookingInvoiceVO.getAftInvAdjAmt()+"]");
	        				eventResponse.setUserMessage(new ErrorHandler("DMT03070").getUserMessage());
			                eventResponse.setETCData(etcData);
			    			return eventResponse;  
	        			}
        			}
        		}
				//======================================================================
        		//2010-07-23 invoice status가 "C" 이면 over_day가 0 이 존재하는 charge에 대하여는 ar-if를 하지 않는다.
        		//------------------------------------------------------------------------------
        		// AR IF 를 실행할 데이터 조회를 위한 매개변수 설정
        		//------------------------------------------------------------------------------
        		ARInterfaceCreationCondVO arInfCondVO = new ARInterfaceCreationCondVO();
        		arInfCondVO.setUsrOfcCd(account.getOfc_cd());
        		arInfCondVO.setDmdtInvNo(invoiceNo);
        		arInfCondVO.setCrInvFlg(creditNoteYn);
        		arInfCondVO.setCreOfcCd(creOfcCd);
        		arInfCondVO.setIdaTaxApplTm(idaTaxApplTm);
        		//------------------------------------------------------------------------------            		
        		// AR IF 를 실행할 데이터를 조회한다.
        		//------------------------------------------------------------------------------
        		arInterfaceCreationVO = command.searchARInterfaceInvoice(arInfCondVO);
        		//------------------------------------------------------------------------------
	            
	            if (arInterfaceCreationVO.getInvArIfChgVOs() == null) {
	            	log.debug(arInterfaceCreationVO.getInvArIfMnVO().getArIfNo());	//ERROR MESSAGE
	            	etcData.put("SUCCESS_YN", "N");
	            	log.error("\n AR INTERFACE VO NULL ===============");
	            	eventResponse.setUserMessage(arInterfaceCreationVO.getInvArIfMnVO().getArIfNo());
	            }
				else {
	            	genIfVOs.add(arInterfaceCreationVO);

		            // AR INTERFACE CALL
		            begin();
		            rGenIfVOs = commandAR.interfaceGeneralARInvoiceToIF(genIfVOs);
		     
		            arIfNo = commandAR.interfaceGeneralARInvoiceToINV(rGenIfVOs);
		            // AR INTERFACE END

					if (StringUtils.isEmpty(arIfNo)) {
		            	etcData.put("SUCCESS_YN", "N");
		            	log.error("\n AR_IF_NO NULL===============");
		            	msg = new ErrorHandler("DMT03066").getUserMessage();
		            	eventResponse.setUserMessage(JSPUtil.replace(msg, "XXXXXXXXX", invoiceNo));
		            	log.error("\n "+JSPUtil.replace(msg, "XXXXXXXXX", invoiceNo));
		            	
		                rollback();//2011.01.07 One Tx 으로 처리
		            }
					else {
		            	String arIfNo_arr[] = arIfNo.split("::");
		            	//성공
		            	if ("S".equals(arIfNo_arr[0])) {
		            		// DMT TABLE UPDATE
			        		command.modifyARInterface(account, arIfNo_arr[1], invoiceNo, creOfcCd);		//ar-if 占쎄퉫�э옙�곸뒠占쏙옙UPDATE占쎌뮆��
			        		
				            etcData.put("SUCCESS_YN", "Y");
				            msg = new ErrorHandler("DMT03027").getUserMessage();
				            eventResponse.setUserMessage(JSPUtil.replace(msg, "XXR123456", invoiceNo));
				            
				            //////////////////////////EDI 로 전송할 데이터 객체를 생성합니다.///////////////////////////////////////
				            if (e instanceof EesDmt4002Event) {	//manual invoice는 edi를 실행 시키지 않는다.
				            	String ioBndCd = arInterfaceCreationVO.getInvArIfMnVO().getIoBndCd();
	
				            	//in bound 만 실행시킨다.
				            	if(ioBndCd.equals("I")) {
				            	
						            log.debug("\n =========> AR-IF SUCESS!! EDI SEND data search start !!");
						            
									eDIContainerVOs = command.searchEDIContainerInfoByInvoice(invoiceNo, creOfcCd);	//EDI로 전송할 데이터를 조회한다.
									
									if (eDIContainerVOs != null && eDIContainerVOs.size() > 0 ) {
										eDIVOs = new ArrayList<EDIVO>(); 
										
										for (EDIContainerVO ediContainerVO : eDIContainerVOs) {
											ydCd = ediContainerVO.getFmMvmtYdCd();
											
											if (ydCd == null || ydCd.length() != 7) continue;
											
											String locCd = ydCd.substring(0, 5);
											//2012.05.11 KRGIN 추가
    										if ("KOR".equals(ediContainerVO.getSvrId()) 
    												&& ("KRPUS".equals(locCd) ||
    													"KRKAN".equals(locCd) ||
														"KRINC".equals(locCd) ||
														"KRPYT".equals(locCd) ||
														"KRUSN".equals(locCd) ||
														"KRGIN".equals(locCd) ||
														"KRPTK".equals(locCd) )) { 
															
												eDIVO = new EDIVO();
												eDIVO.setBkgNo(			ediContainerVO.getBkgNo()		);
												eDIVO.setSysAreaGrpId(	ediContainerVO.getSvrId()		);
												eDIVO.setCntrNo(		ediContainerVO.getCntrNo()		);
												eDIVO.setCntrCycNo(		ediContainerVO.getCntrCycNo()	);
												eDIVO.setAcount(		account							);
												eDIVOs.add(eDIVO);
											}
										}
									}
									
									if (eDIVOs != null && eDIVOs.size() > 0) {
										log.debug("\n =========> EDI common module start !!");
										//공통모듈을 통해서 EDI 전송을 수행한다.
										commandCharge.sendToEDI(eDIVOs);
									}
				            	}
				            }
			        		commit();
			        		
			        		//2011.02.23 ERP로직 분리
			        		begin();
			        		commandAR.interfaceARInvoiceToERPAR(arIfNo_arr[1]);
			        		commit();


							/////////////////////////////////////////////////////////////////////////////////////////////////////////
		            	} 
						else {
			        		commit();

			            	etcData.put("SUCCESS_YN", "N");
			            	log.error("\n AR_IF_ERROR MSG===============>"+arIfNo_arr[1]);
			            	msg = new ErrorHandler("DMT03066").getUserMessage();
			            	ar_err_msg = arIfNo_arr[1];
			            	msg = msg + "["+ar_err_msg+"]";
			            	eventResponse.setUserMessage(JSPUtil.replace(msg, "XXXXXXXXX", invoiceNo));
		            	}
		            }
	            }
        	//다건 처리
        	} 
			else if (e instanceof EesDmt4013Event || e instanceof EesDmt5003Event) {
        		total_cnt = invoiceNos.length;
        		//String err_invoiceNos = "";
        		StringBuffer sb_err_inv = new StringBuffer(); 
        		
        		for (int i = 0; i < invoiceNos.length ; i++) {
        			invoiceNo = invoiceNos[i];
        			idaTaxApplTm = idaTaxApplTms[i];
        			
        			//invoice status 조회
            		invStsCd = command.searchInvoiceStatus(invoiceNo, creOfcCd);
            		
					creditNoteYn = "C".equals(invStsCd) ? "Y" : "N";
            		
    				//================ 2010.06.04 ###  ar_ofc_cd = 'LEHSC' and aft_inv_adj_amt > 0 이면 error 처리
            		if ("N".equals(creditNoteYn)){
            			chargeBookingInvoiceVO = command.checkAftInvAdjAmtByInvoiceNo(invoiceNo, creOfcCd, account.getOfc_cd());
            			if(chargeBookingInvoiceVO.getArIfOfcCd().length() > 0 && chargeBookingInvoiceVO.getAftInvAdjAmt().length() > 0 ) {
            				//ar_ofc_cd = 'LEHSC' and aft_inv_adj_amt > 0 이면 error 처리
    	        			if(chargeBookingInvoiceVO.getArIfOfcCd().equals("LEHSC") && !chargeBookingInvoiceVO.getAftInvAdjAmt().equals("0")){
    	        				log.error("\n LEHSC===============>AFT_INV_ADJ_AMT["+chargeBookingInvoiceVO.getAftInvAdjAmt()+"]");
    	    	            	fail_cnt++;
    			            	sb_err_inv.append(invoiceNo).append(",");
    			            	continue;
    	        			}
            			}
            		}
            		//=======================================================================================
            		
        			arIfNo   = "";
					genIfVOs	= new ArrayList<ARInterfaceCreationVO>();

					// [ 인도세법 변경 이전/이후 여부를 판단해주는 구분값 ] =================================
					if (StringUtils.isEmpty(idaTaxApplTm)) {
						// EES_DMT_5003 ( Invoice Interface to A/R - Detail ) 화면에서는 넘겨주지 않음.
						idaTaxApplTm = command.searchIdaTaxApplTm(invoiceNo);
					}
					//=======================================================================================
					
            		//------------------------------------------------------------------------------
            		// AR IF 를 실행할 데이터 조회를 위한 매개변수 설정
            		//------------------------------------------------------------------------------
            		ARInterfaceCreationCondVO arInfCondVO = new ARInterfaceCreationCondVO();
            		arInfCondVO.setUsrOfcCd(account.getOfc_cd());
            		arInfCondVO.setDmdtInvNo(invoiceNo);
            		arInfCondVO.setCrInvFlg(creditNoteYn);
            		arInfCondVO.setCreOfcCd(creOfcCd);
            		arInfCondVO.setIdaTaxApplTm(idaTaxApplTm);
            		//------------------------------------------------------------------------------            		
            		// AR IF 를 실행할 데이터를 조회한다.
            		//------------------------------------------------------------------------------
            		arInterfaceCreationVO = command.searchARInterfaceInvoice(arInfCondVO);
            		//------------------------------------------------------------------------------
        			
        			if (arInterfaceCreationVO.getInvArIfChgVOs() == null) {
    	            	log.debug(arInterfaceCreationVO.getInvArIfMnVO().getArIfNo());
    	            	fail_cnt++;
		            	sb_err_inv.append(invoiceNo).append(",");
    	            } 
					else {
	    	            genIfVOs.add(arInterfaceCreationVO);
	    	            
	    	            // AR INTERFACE CALL
	    	            begin();
	    	            rGenIfVOs = commandAR.interfaceGeneralARInvoiceToIF(genIfVOs);
	    	            arIfNo = commandAR.interfaceGeneralARInvoiceToINV(rGenIfVOs);
	    	            // AR INTERFACE END
	    	            
	    	            if (StringUtils.isEmpty(arIfNo)) {
	    	            	log.debug("\n AR_IF_NO NULL===============");
	    	            	fail_cnt++;
			            	sb_err_inv.append(invoiceNo).append(",");
			            	rollback();
	    	            }
						else {
	    	            	String arIfNo_arr[] =	arIfNo.split("::");
	    	            	if ("S".equals(arIfNo_arr[0])) {
		    	            	success_cnt++;
		    	            	
		        	            // DMT TABLE UPDATE
	        	        		command.modifyARInterface(account, arIfNo_arr[1], invoiceNo, creOfcCd);
		        	            
		        	            String ioBndCd = arInterfaceCreationVO.getInvArIfMnVO().getIoBndCd();
		        	            
		        	            //in bound 만 실행시킨다.
				            	if ("I".equals(ioBndCd)) {
			        	            //////////////////////////EDI 로 전송할 데이터 객체를 생성합니다.///////////////////////////////////////
									eDIContainerVOs = command.searchEDIContainerInfoByInvoice(invoiceNo, creOfcCd);	//EDI로 전송할 데이터를 조회한다.
									
									if (eDIContainerVOs != null && eDIContainerVOs.size() > 0 ) {
										eDIVOs = new ArrayList<EDIVO>(); 
										for (EDIContainerVO ediContainerVO : eDIContainerVOs) {
											ydCd = ediContainerVO.getFmMvmtYdCd();
											
											if (ydCd == null || ydCd.length() != 7) continue;
														
											String locCd = ydCd.substring(0, 5);
											//2012.05.11 KRGIN 추가
											if ("KOR".equals(ediContainerVO.getSvrId())
													&& ("KRPUS".equals(locCd) ||
    													"KRKAN".equals(locCd) ||
														"KRINC".equals(locCd) ||
														"KRPYT".equals(locCd) ||
														"KRUSN".equals(locCd) ||
														"KRGIN".equals(locCd) ||
														"KRPTK".equals(locCd) )) {

												eDIVO = new EDIVO();
												eDIVO.setBkgNo(			ediContainerVO.getBkgNo()		);
												eDIVO.setSysAreaGrpId(	ediContainerVO.getSvrId()		);
												eDIVO.setCntrNo(		ediContainerVO.getCntrNo()		);
												eDIVO.setCntrCycNo(		ediContainerVO.getCntrCycNo()	);
												eDIVO.setAcount(		account							);
												eDIVOs.add(eDIVO);
											}
										}
									}
									
									if (eDIVOs != null && eDIVOs.size() > 0) {
										//공통모듈을 통해서 EDI 전송을 수행한다.
										commandCharge.sendToEDI(eDIVOs);
									}
									/////////////////////////////////////////////////////////////////////////////////////////////////////////
				            	}
			    	            commit();
		        	            
				        		//2011.02.23 ERP로직 분리
				        		begin();
				        		commandAR.interfaceARInvoiceToERPAR(arIfNo_arr[1]);
				        		commit();
	    	            	} 
							else {
			    	            commit();
			    	            
	        	            	fail_cnt++;
	        	            	sb_ar_err_msg.append(arIfNo_arr[1]).append("|");
	    		            	sb_err_inv.append(invoiceNo).append(",");
	    	            	}
	    	            }
	        		}
        		}
        		
	            etcData.put("SUCCESS_YN", "Y");
	            
	            msg = new ErrorHandler("DMT03067").getUserMessage();
	            msg = JSPUtil.replace(msg, "$1", ""+total_cnt);
	            msg = JSPUtil.replace(msg, "$2", ""+success_cnt);
	            msg = JSPUtil.replace(msg, "$3", ""+fail_cnt);
	            msg = JSPUtil.replace(msg, "XXX123456", ""+sb_err_inv.toString());
	            if (fail_cnt > 0) {
	            	msg = msg+"["+sb_ar_err_msg.toString()+"]";
	            }
            	eventResponse.setUserMessage(msg);
	            
	            if (e instanceof EesDmt4013Event) {
	            	for (int i = 0; i < list.size(); i++) {
	            		ConfirmChargeListVO tempVO = (ConfirmChargeListVO)list.get(i);
	            		if ((tempVO.getCheckBox().equals("1")) && (fail_cnt == 0)) {
            				tempVO.setDmdtArIfCd("Y");
	            		}
	            		list.set(i, tempVO);
	            	}
	            	eventResponse.setRsVoList(list);
	            }
        	}
        	eventResponse.setETCData(etcData);
            
        } 
		catch(EventException ex) {
            etcData.put("SUCCESS_YN", "N");
            log.error("EventException " + ex.toString(), ex);
            eventResponse.setETCData(etcData);
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage());
        } 
		catch(Exception ex) {
            etcData.put("SUCCESS_YN", "N");
            log.error("Exception " + ex.toString(), ex);
            eventResponse.setETCData(etcData);
            rollback();
        	throw new EventException(ex.getMessage(), ex);
        } 
        return eventResponse;
    }   
    
    /**
     * EES_DMT_4013 : cntr count 조회<br>
     * Bkg별 cntr 갯수를 조회 합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchBookingContainerCount(Event e) throws EventException {
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        Map<String,String> etcData          = new HashMap<String,String>();
        
        try{
        	int dResult = 0;
        	
        	dResult = command.searchBookingContainerCount(((EesDmt4013Event)e).getIssuedInvoiceParamVO());
			
            etcData.put("CNTR_CNT", String.valueOf(dResult));
            eventResponse.setETCData(etcData);
        } catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex){
            eventResponse.setUserMessage(ex.getMessage());
            log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
        } 
        return eventResponse;           
    }
    
    
    /**
     * EES_DMT_4013 : cntr count 조회<br>
     * Bkg별 container를 조회 합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchChargeByBooking(Event e) throws EventException {
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        ChargeCalculationBC commandChrge 	= new ChargeCalculationBCImpl();
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        List<ConfirmChargeListVO> list 		= null;
        List<VVDCheckDataVO>	  vVDCheckList = null;      

        Map<String,String> etcData = new HashMap<String,String>();
        List<DmtInvMnVO> 		grplist 	= null;
        
        try{
        	//1.searchVVDCheckData
        	vVDCheckList = command.searchVVDCheckDataList(((EesDmt4013Event)e).getIssuedInvoiceParamVO(), account);
        	
        	if (vVDCheckList != null && vVDCheckList.size() > 0) {
	        	for (VVDCheckDataVO vVDCheckDataVO : vVDCheckList) {
		        	//2.modifyBookingContainerVVD
		        	commandChrge.modifyBookingContainerVVD(vVDCheckDataVO);
	        	}
        	}
        	
        	//3.실제 조회 로직        	
        	list = command.searchChargeInvoiceList(((EesDmt4013Event)e).getIssuedInvoiceParamVO(), account);
        	eventResponse.setRsVoList(list);
        	
        	grplist = command.searchChargeInvoiceGrpBkgNo(((EesDmt4013Event)e).getIssuedInvoiceParamVO(), account);
            etcData.put("GRP_BKG_NO",      grplist.get(0).getBkgNo());
            etcData.put("GRP_DMDT_TRF_CD", grplist.get(0).getDmdtTrfCd());
            etcData.put("GRP_POR_CD",      grplist.get(0).getPorCd());
            etcData.put("GRP_DEL_CD",      grplist.get(0).getDelCd());

            // Sheet Option - Tax Ratio By Office
            SheetOptionVO paramVO = new SheetOptionVO();
            paramVO.setOfcCd(account.getOfc_cd());
        	String tax_rto = command.searchEnvironmentByOffice(paramVO);
        	etcData.put("TAX_RTO",tax_rto);
        	
	         // 인도 TAX 변경 전 / 후 인지 조회 ( A : After, B : Before )
	         String idaTaxApplTm = command.searchIdaTaxApplTm("");
	         etcData.put("IDA_TAX_APPL_TM",     idaTaxApplTm);
	         
        	// 인도 Tax Ratio
            SearchIndiaGstRateVO indiaGstRateVO = command.searchIndiaGstRate("");
            etcData.put("IDA_EXPN_TAX_RT",      indiaGstRateVO.getIdaExpnTaxRt());
            etcData.put("IDA_EDU_TAX_RT",       indiaGstRateVO.getIdaEduTaxRt());
            etcData.put("IDA_HIGH_EDU_TAX_RT",  indiaGstRateVO.getIdaHighEduTaxRt());
            etcData.put("IDA_LOCL_TAX_RT",      indiaGstRateVO.getIdaLoclTaxRt());
            etcData.put("IDA_N2ND_LOCL_TAX_RT", indiaGstRateVO.getIdaN2ndLoclTaxRt());
        	
        	eventResponse.setETCData(etcData); 
        } 
        catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            log.error("err " + ex.toString(), ex);
            throw ex;
        } 
        catch(Exception ex){
            eventResponse.setUserMessage(ex.getMessage());
            log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
        } 
        return eventResponse; 
    }
    
    /**
     * Payer별 fax번호,email정보를 조회 합니다.
     * @param Event e
     * @return EventResponse
     * @throws EventExcpetion
     */
    private EventResponse searchFAXEmailByPayer(Event e) throws EventException {
    	InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        Map<String,String> etcData          = new HashMap<String,String>();
        FAXEmailByPayerVO fAXEmailByPayerVO = new FAXEmailByPayerVO();
        
        
        try{
        	fAXEmailByPayerVO = command.searchFAXEmailByPayer(((EesDmt4002Event)e).getFAXEmailByPayerVO());
			
            etcData.put("EMAIL_NO", fAXEmailByPayerVO.getEmailNos());
            etcData.put("FAX_NO", fAXEmailByPayerVO.getFaxNos());
            eventResponse.setETCData(etcData);
        } catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex){
            eventResponse.setUserMessage(ex.getMessage());
            log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
        } 
        return eventResponse; 
    }
    
    /**
     * INVOICE RD의 manual invoice MASTER 데이터를 조회한다.<br>
     * @param Event e
     * @return EventResponse
     * @throws EventExcpetion
     */
    private EventResponse searchInvoiceIssueMasterPreview(Event e) throws EventException {
    	InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        InvoiceIssueMasterPreviewVO invoiceIssueMasterPreviewVO = new InvoiceIssueMasterPreviewVO();
        EesDmt4003Event event = (EesDmt4003Event)e;
        
        InvoiceIssueRDParamVO paramVO = event.getInvoiceIssueRDParamVO();
        
        try {
        	if (("N").equals(event.getIncCntrDtail())) {
        		invoiceIssueMasterPreviewVO = command.searchInvoiceIssueMasterPreviewNo(paramVO);
        	} 
        	else {
        		invoiceIssueMasterPreviewVO = command.searchInvoiceIssueMasterPreview(paramVO);
        	}
        	
        	String creCntCd = invoiceIssueMasterPreviewVO.getRdCreCntCd();
    		if (("IN").equals(creCntCd)) {
    			// 인도세법 변경 전/후 여부
    			String idaTaxApplTm = command.searchIdaTaxApplTm(invoiceIssueMasterPreviewVO.getRdDmdtInvNo());
    			invoiceIssueMasterPreviewVO.setRdIdaTaxApplTm(idaTaxApplTm);
    			
    			// Bank Account 조회
    			IdaGstRtoVO idaGstRtoVO = command.searchIdaBankInfo();
    			if (idaGstRtoVO != null) {
    				invoiceIssueMasterPreviewVO.setRdIdaBankAcctNo(idaGstRtoVO.getIdaBankAcctNo());
    				invoiceIssueMasterPreviewVO.setRdIdaBankIfscCd(idaGstRtoVO.getIdaBankIfscCd());
    			}
    			
    			// 인도 invoice 정보 조회
    			if ("B".equals(idaTaxApplTm)) {
    	    		SearchIndiaGstRateVO indiaGstRateVO = command.searchIndiaGstRate(invoiceIssueMasterPreviewVO.getRdIssueDay());
    	    		invoiceIssueMasterPreviewVO.setRdTaxRgstNo(indiaGstRateVO.getTaxRgstNo());
    	    		invoiceIssueMasterPreviewVO.setRdSvcCateRmk(indiaGstRateVO.getSvcCateRmk());
    	    		invoiceIssueMasterPreviewVO.setRdPmntAcctNo(indiaGstRateVO.getPmntAcctNo());    				
    			}
    			else {
		            String payrCd = paramVO.getPayerCd();
		            IdaGstRtoCondVO condVO = new IdaGstRtoCondVO();
		            condVO.setCondIdaSacCd(paramVO.getCondIdaSacCd());
		            condVO.setOfcCd(paramVO.getCreOfcCd());
		            if (payrCd.startsWith("00")) {
		            	condVO.setCustCntCd("");
		            	condVO.setCustSeq(payrCd.substring(2));
		            	condVO.setCustVndrDivCd("V");
		            }
		            else {
		            	condVO.setCustCntCd(payrCd.substring(0, 2));
		            	condVO.setCustSeq(payrCd.substring(2));
		            	condVO.setCustVndrDivCd("C");
		            }
    				// Customer State Code / GSTN # No. / SAC Code
    				idaGstRtoVO = command.searchIdaGstInfo(condVO);
    				invoiceIssueMasterPreviewVO.setRdIdaGstRgstNo(idaGstRtoVO.getIdaGstRgstNo());	// Customer GSTN
    				invoiceIssueMasterPreviewVO.setRdIdaSteCd(idaGstRtoVO.getIdaSteCd());
    				invoiceIssueMasterPreviewVO.setRdIdaSteNm(idaGstRtoVO.getIdaSteNm());
    				invoiceIssueMasterPreviewVO.setRdIdaSacCd(idaGstRtoVO.getIdaSacCd());
    				
    				// Office GST No., PAN No.
    				idaGstRtoVO = command.searchIdaGstInfoByOffice(condVO);
    				invoiceIssueMasterPreviewVO.setRdTaxRgstNo(idaGstRtoVO.getIdaGstRgstNo());		// Office GST No.
    				invoiceIssueMasterPreviewVO.setRdIdaOfcSteCd(idaGstRtoVO.getIdaSteCd());
    				invoiceIssueMasterPreviewVO.setRdIdaOfcSteNm(idaGstRtoVO.getIdaSteNm());
    				invoiceIssueMasterPreviewVO.setRdPmntAcctNo(idaGstRtoVO.getIdaPanNo());
    				invoiceIssueMasterPreviewVO.setRdSvcCateRmk(idaGstRtoVO.getIdaSvcCateRmk());
    				invoiceIssueMasterPreviewVO.setRdIdaTaxCin(idaGstRtoVO.getIdaTaxCin());
    			}
    		}
        	
        	eventResponse.setETCData(invoiceIssueMasterPreviewVO.getColumnValues());
        } 
        catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            log.error("err " + ex.toString(), ex);
            throw ex;
        } 
        catch(Exception ex) {
            eventResponse.setUserMessage(ex.getMessage());
            log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
        } 
        return eventResponse; 
    }
    
	/**
	 * EES_DMT_4008, EES_DMT_4001 : Open<br>
	 * OFC_CD별 현재일자를 조회 합니다. <br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInitInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CommonFinderBC command = new CommonFinderBCImpl();
		InvoiceIssueCollectionMgtBC invCommand = new InvoiceIssueCollectionMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		// 로그인 사용자 Office 의 현재 시간
		String curr_day = command.searchCurrentDateByOffice(account.getOfc_cd());
				
		// 화면별 User Role 권한을 확인하기 하기 위해 호출
		String role_auth_flag = searchUserRoleCode(e);
		
		// 로그인 사용자의 국가 코드
		String usrCntCd = command.searchUserCntCode(account.getOfc_cd());
		
		// 변경된 인도세법의 시스템 적용일
		String idaTaxApplDt = invCommand.searchIdaTaxApplDt();
		
		eventResponse.setETCData("OFC_CURR_DAY", curr_day);
		eventResponse.setETCData("ROLE_AUTH_FLAG" , role_auth_flag);
		eventResponse.setETCData("USR_CNT_CD", usrCntCd);
		eventResponse.setETCData("IDA_TAX_APPL_DT", idaTaxApplDt);
		
		return eventResponse;
	}
	
	/**
	 * EES_DMT_4013 : Group Invoice Save.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse doBackEndJob(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
		
		try{
			InvoiceGroupParamVO invoiceGroupParamVO = null;
			ConfirmChargeListVO[] confirmChargeListVOs = null;
			String backEndJobKey = null;
			
			invoiceGroupParamVO = ((EesDmt4013Event)e).getInvoiceGroupParamVO();
			confirmChargeListVOs = ((EesDmt4013Event)e).getConfirmChargeListVOs();
				
			//BackEndJob 모듈을 호출한다.
			backEndJobKey = command.doBackEndJob(invoiceGroupParamVO, confirmChargeListVOs, account);
			eventResponse.setETCData("BackEndJobKey", backEndJobKey);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		} 
		return eventResponse;
	}
	/**
	 * EES_DMT_4013 : btn_save<br>
	 * Long Tx 상태 조회<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 * @exception EventException
	 */
	private EventResponse checkBackEndJob(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
		
		try{
			InvoiceGroupParamVO invoiceGroupParamVO = null;
			
			invoiceGroupParamVO = ((EesDmt4013Event)e).getInvoiceGroupParamVO();
			
			//BackEndJob 모듈의 현재 작업상태와  오류 발생시 오류 메세지를 조회한다.
			String[] result = command.checkBackEndJob(invoiceGroupParamVO.getBackendjobKey());
			eventResponse.setETCData("jb_sts_flg",		result[0]);
			eventResponse.setETCData("jb_usr_err_msg",	result[1]);
			
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}  
	


	/**
	 * EES_DMT_4004 : Retrieve <br>
	 * BKG No., Tariff 에 해당되는 Charge Currency 를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 */
	private EventResponse searchChargeCurrency(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		InvoiceIssueCollectionMgtBC invCommand 			= new InvoiceIssueCollectionMgtBCImpl();
		CommonFinderBC 				comCommand 			= new CommonFinderBCImpl();
		EesDmt4004Event				event				= (EesDmt4004Event) e;
		ChargeBookingInvoiceVO		chargeVO			= event.getChargeBookingInvoiceVO();

		try {
       		//1.Rate Currency 정보를 조회한다.===============================================================================================
       		String 		rateCurrency 	= invCommand.searchRateCurrency(chargeVO.getBkgNo(), chargeVO.getDmdtTrfCd());
       		//============================================================================================================================
       		
       		//2.Local Currency 정보를 조회한다.==============================================================================================
       		CoverageVO coverageVO	= new CoverageVO();
   			coverageVO.setCntCd(		chargeVO.getCntCd()			);
   			
   			if (rateCurrency != null &&  !"".equals(rateCurrency)) {
   				coverageVO.setUseRtCurr(	chargeVO.getUseRtCurr()		);
       			coverageVO.setRtCurrCd(		rateCurrency				);
   			}
       		
       		List<CurrencyVO> 	currencyList 	= comCommand.searchCurrencyList(coverageVO);
       		
    		StringBuffer sbCurrency = new StringBuffer();
    		if (currencyList != null && currencyList.size() > 0) {
    			for (int i = 0 ; i < currencyList.size() ; i++) {
    				sbCurrency.append(currencyList.get(i).getCurrCd()).append("=").append(currencyList.get(i).getCurrNm());
    				if (i < currencyList.size() - 1) sbCurrency.append("|");
    			}
    		}
    		eventResponse.setETCData("CHG_CURR_CD", sbCurrency.toString());
    		//============================================================================================================================
    		
        } catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            throw ex;
        } catch(Exception ex){
        	eventResponse.setUserMessage(ex.getMessage());
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse; 
	}
	
	/**
	 *  화면별 User Role 권한을 확인하기 위해 사용<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception String
	 */
	
	private String searchUserRoleCode(Event e) throws EventException {
		CommonFinderBC command = new CommonFinderBCImpl();
		
		try {
			UserRoleVO userRoleVO = new UserRoleVO();
			
			String pgmNo = "";
			if(e.getEventName().equalsIgnoreCase("EesDmt4001Event")) {
				// 어느 화면에서 호출했는지를 파라메터 VO에 담는다.
				// 4001 화면은 DMT01~02
				// 나머지 화면은 DMT01~04
				pgmNo = "EES_DMT_4001";
			}else if(e.getEventName().equalsIgnoreCase("EesDmt7020Event")) {
				// 7020Event에서 7020, 2021 두 URI를 사용하기 때문에 이벤트 객체 내부에 정확한 구분을 위한 PgmNo값을 가져온다
				pgmNo = ((EesDmt7020Event)e).getProgramNo();				
			}
			
			userRoleVO.setUsrId(account.getUsr_id());
			userRoleVO.setPgmNo(pgmNo);
			
			// 호출 화면별 권한이 있을 경우 "Y", 없는 경우 "N"를 호출한다.
			String role_auth_flag = command.searchUserRoleCode(userRoleVO);
			
			return role_auth_flag;
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * DMT User Role 정보를 확인하기 위해 searchUserRoleCode 메소드 호출하는 Windoow Open 시 Default SC <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchUserRoleCodeDefault(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
						
			String role_auth_flag = searchUserRoleCode(e);
			
			eventResponse.setETCData("ROLE_AUTH_FLAG" , role_auth_flag);
			
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		
		return eventResponse;
	}
	

    /**
    * EES_DMT_4017 : [Search]<br>
    * OTS Clean List 조회 <br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
//    private EventResponse searchOTSCleanList (Event e) throws EventException {
//        // PDTO(Data Transfer Object including Parameters)
//        EesDmt4017Event event = (EesDmt4017Event)e;
//        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        
//        try {
//	        List<OTSCleanListVO> list = command.searchOTSCleanList ( event.getOtsInquiryParmVO() );
//	        eventResponse.setRsVoList(list);
//        }catch(EventException ex){
//        	throw ex;
//        }catch(Exception ex){
//        	throw new EventException(ex.getMessage(), ex);
//        }
//        
//        return eventResponse;
//    }
	private EventResponse searchOTSCleanList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
		EesDmt4017Event event = (EesDmt4017Event)e;
		
		try{
			String backEndJobKey = null;
							
			//BackEndJob 모듈을 호출한다.
//			backEndJobKey = command.doBackEndJob(invoiceGroupParamVO, confirmChargeListVOs, account);
			backEndJobKey = command.dobackEndJobOTS( event.getOtsInquiryParmVO(), account );
			eventResponse.setETCData("BackEndJobKey", backEndJobKey);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		} 
		return eventResponse;
	}

	/**
	 * BackEndJob : 
	 * BackEndJob 실행 후 결과코드 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */

	@SuppressWarnings({ "unchecked", "static-access" })
	private EventResponse backEndJobResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String sKey = "";
		
		List<OTSCleanListVO> list = null;
		
		EesDmt4017Event event = (EesDmt4017Event) e;
		sKey = event.getKey();		
		
		String strResult = "";
		String resultMsg = "";
		try
		{
			BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(sKey);
			BackEndJobResult backEndJobResult = new BackEndJobResult();
			DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
			while(rowSet.next()) 
			{
				if ("2".equals(rowSet.getString("JB_STS_FLG")))
				{
					// BackEndJob 처리중
					strResult = "PROCESSING";
				}
				else if ("3".equals(rowSet.getString("JB_STS_FLG")))
				{
					// 성공메시지세팅
							list = (List<OTSCleanListVO>)backEndJobResult.loadFromFile(sKey);
							
							if ( list.size() == 0 )
							{
								eventResponse.setUserMessage(new ErrorHandler("DMT01125").getUserMessage());
							} else {
								eventResponse.setRsVoList(list);
							}
					strResult = "SUCCESS";
				}
				else if ("4".equals(rowSet.getString("JB_STS_FLG")))
				{
					// 에러메시지세팅
					eventResponse.setUserMessage(new ErrorHandler("DMT01125").getUserMessage());
					strResult = "FAIL";
				}
			}
			eventResponse.setETCData("jb_sts_flg", strResult);
			eventResponse.setETCData("resultMsg", resultMsg);
		} catch (Exception ex)
		{
			rollback();
			throw new EventException(new ErrorHandler("DMT01125").getMessage(), ex);
			
		}
		return eventResponse;
	}	

    /**
    * EES_DMT_4017 : [Search]<br>
    * OTS Clean Office 조회<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchOTSCleanOfficeList (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4017Event event = (EesDmt4017Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try {
	        List<OTSCleanOfficeListVO> list = command.searchOTSCleanOfficeList ( event.getOtsInquiryParmVO() );
	        eventResponse.setRsVoList(list);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        
        return eventResponse;
    }

    /**
    * EES_DMT_4017 : [Detailed down Excel 버튼]<br>
    * OTS Clean Detail Excel 다운로드<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchOTSCleanDetailExcelList (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4017Event event = (EesDmt4017Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
	        List<OTSCleanDetailExcelListVO> list = command.searchOTSCleanDetailExcelList ( event.getOtsInquiryParmVO() );
	        eventResponse.setRsVoList(list);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }

    /**
    * EES_DMT_4017 : [UPDATE]<br>
    * [Outstanding Inquiry by Customer N Issue - Detail(s) REMARK]을 [UPDATE]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse updateOTSCleanListRemark(Event e) throws EventException {
    
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4017Event event = (EesDmt4017Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        
        OTSCleanListVO[] OTSCleanListVOs = event.getoTSCleanListVOs();
        OtsInquiryParmVO otsInquiryParmVO = event.getOtsInquiryParmVO();
        String rtnRemark = "";
        try{
            begin();            
            
            for(int j = 0; j < OTSCleanListVOs.length; j++) {
            	otsInquiryParmVO.setSlsRmrk(OTSCleanListVOs[j].getOtsRmk());
            	otsInquiryParmVO.setPayc(OTSCleanListVOs[j].getPayerc());
            	otsInquiryParmVO.setSlsUi("EES_DMT_4017");
	            rtnRemark = command.updateOTSInquiryByDetailListRemark ( otsInquiryParmVO , account);
            }

            eventResponse.setUserMessage(new ErrorHandler("MST00003").getUserMessage());
            eventResponse.setETCData("rtnRemark" , rtnRemark);
            commit(); 
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
    }
    
    /**
    * EES_DMT_4018 : 조회<br>
    * OTS Clean Detail 조회<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchOTSCleanDetailList (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4018Event event = (EesDmt4018Event)e; 
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
	        List<OTSCleanDetailExcelListVO> list = command.searchOTSCleanDetailExcelList ( event.getOtsInquiryParmVO() );
	        eventResponse.setRsVoList(list);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
    

    /**
    * EES_DMT_4018 : [Search]<br>
    * OTS Clean Office Detail 조회<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchOTSCleanOfficeDetailList (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4018Event event = (EesDmt4018Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try {
	        List<OTSCleanOfficeListVO> list = command.searchOTSCleanOfficeList ( event.getOtsInquiryParmVO() );
	        eventResponse.setRsVoList(list);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        
        return eventResponse;
    }
    

    /**
    * EES_DMT_4018 : [Search]<br>
    * [Outstanding Inquiry by Customer N Issue - Detail(s) 대상]을 [조회]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchOTSCleanByDetailListRemark (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4018Event event = (EesDmt4018Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        Map<String,String> etcData 			= new HashMap<String,String>();
        try {
	        String rtnRemark = command.searchOTSInquiryByDetailListRemark ( event.getOtsInquiryParmVO() );
	        etcData.put("rtnRemark",rtnRemark);
	        eventResponse.setETCData(etcData);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
    

    /**
    * EES_DMT_4018 : [UPDATE]<br>
    * [Outstanding Inquiry by Customer N Issue - Detail(s) REMARK]을 [UPDATE]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse updateOTSCleanByDetailListRemark(Event e) throws EventException {
    
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4018Event event = (EesDmt4018Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        try{
            begin();            
            String rtnRemark = command.updateOTSInquiryByDetailListRemark ( event.getOtsInquiryParmVO() , account);
            eventResponse.setUserMessage(new ErrorHandler("MST00003").getUserMessage());
            eventResponse.setETCData("rtnRemark" , rtnRemark);
            commit(); 
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
    }
    

    /**
    * EES_DMT_4018 : [Search]<br>
    * [Outstanding Inquiry by Customer N Issue - Detail(s) 대상]을 [조회]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchOTSCleanByDetailListRemark2 (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4018Event event = (EesDmt4018Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        Map<String,String> etcData 			= new HashMap<String,String>();
        try {
	        String rtnRemark = command.searchOTSInquiryByDetailListRemark2 ( event.getOtsInquiryParmVO() );
	        etcData.put("rtnRemark",rtnRemark);
	        eventResponse.setETCData(etcData);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }    
    
    /**
    * EES_DMT_4018 : [Search]<br>
    * [Outstanding Inquiry by Customer N Issue - Detail(s) 대상]을 [조회]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchOTSCleanByDetailList2 (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4018Event event = (EesDmt4018Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
	        List<OTSCleanDetailExcelListVO> list = command.searchOTSCleanByDetailList2 ( event.getOtsInquiryParmVO() );
	        eventResponse.setRsVoList(list);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
    * EES_DMT_4018 : [Search]<br>
    * [Outstanding Inquiry by Customer N Issue - Detail(s) 대상]을 [조회]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchOTSCleanByDetailList3 (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4018Event event 				= (EesDmt4018Event)e; 
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        try {
	        List<OtsInquiryByDetial3VO> list = command.searchOTSInquiryByDetailList3 ( event.getOtsInquiryParmVO() );
	        eventResponse.setRsVoList(list);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }

    /**
    * EES_DMT_4018 : [UPDATE]<br>
    * [Outstanding Inquiry by Customer N Issue - Detail(s) REMARK]을 [UPDATE]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse updateOTSCleanDetailListSales(Event e) throws EventException {
    
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4018Event event = (EesDmt4018Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        
        OTSCleanDetailExcelListVO[] oTSCleanDetailExcelListVOs = event.getoTSCleanDetailExcelListVOs();

        Map<String,String> etcData 			= new HashMap<String,String>();
        
        try{
            begin();            
            
	        command.updateOTSCleanDetailListSales ( oTSCleanDetailExcelListVOs , account);

            eventResponse.setUserMessage(new ErrorHandler("MST00003").getUserMessage());
            etcData.put("rtnRemark","");
            eventResponse.setETCData(etcData);
            commit(); 
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
    }
    
    /**
    * EES_DMT_4002 : [VIRTUAL INVOICE CANCEL]<br>
    * [Invoice Creation & Issue - Booking Virtual Invoice]을 [Cancel]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse modifyVirtualInvoiceStatus(Event e) throws EventException {
    
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4002Event event = (EesDmt4002Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        Map<String,String> etcData = new HashMap<String,String>();
        
        IssuedInvoiceParamVO issuedInvoiceParamVO = event.getIssuedInvoiceParamVO();

        try {
            begin();
            command.modifyVirtualInvoiceStatus(issuedInvoiceParamVO.getDmdtVtInvNo() , issuedInvoiceParamVO.getDmdtVtInvStsCd(), issuedInvoiceParamVO.getSOfcCd());
            eventResponse.setUserMessage(new ErrorHandler("MST00003").getUserMessage());
            commit();
            
            etcData.put("SUCCESS_YN", "Y");

        	eventResponse.setETCData(etcData); 
        }
        catch(EventException ex) {
            throw ex;
        }
        catch(Exception ex) {
            throw new EventException(ex.getMessage(), ex);
        }       
        
        return eventResponse;
    }
    
    /**
    * EES_DMT_4002 : [Search]<br>
    * [Invoice Creation & Issue - Booking 가상 Invoice 가 존재하는지 여부]을 [조회]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchExistsVirtualInvoice(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4002Event event 				= (EesDmt4002Event)e; 
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        Map<String,String> etcData = new HashMap<String,String>();
        
        try {
        	ChargeBookingInvoiceVO inputParamVO = event.getChargeBookingInvoiceVO();
        			
	        String existsYn = command.searchExistsVirtualInvoice(inputParamVO.getBkgNo(), inputParamVO.getDmdtTrfCd());
            etcData.put("EXISTS_YN", existsYn);

        	eventResponse.setETCData(etcData); 
        }
        catch(EventException ex) {
        	throw ex;
        }
        catch(Exception ex) {
        	throw new EventException(ex.getMessage(), ex);
        }
        
        return eventResponse;
    }
    
    /**
     * EES_DMT_4002 : [SAVE]<br>
     * [ERP 으로부터 수신한 OTS 미수금 수신정보]를 [저장] 합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse addOtsInfo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	ESM0750001Event event 				= (ESM0750001Event)e; 
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        
        try {
	        command.addOtsInfo(event.getOtsPayRcvVO());
        }
        catch(EventException ex) {
        	throw ex;
        }
        catch(Exception ex) {
        	throw new EventException(ex.getMessage(), ex);
        }
        
        return eventResponse;
    }
    
    /**
     * EES_DMT_4002 : [SAVE]<br>
     * [미수금 완납여부]를 [수정] 합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse modifyOtsCltFlg(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	ESM0750001Event event 				= (ESM0750001Event)e; 
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        
        try {
	        //[ERP 으로부터 수신한 OTS 미수금 납부한 금액이 청구한 금액과 동일한지 여부]를 [조회] 합니다.
//	        if (command.isOtsCollected(event.getOtsPayRcvVO())) {
	        	command.modifyOtsCollected(event.otsPayRcvVO);
//	        }
        }
        catch(EventException ex) {
        	throw ex;
        }
        catch(Exception ex) {
        	throw new EventException(ex.getMessage(), ex);
        }
        
        return eventResponse;
    }
    
    
    /**
     * EES_DMT_5001_3 : [Retrieve]<br>
     * [TAB3:A/R Interface Status Inquiry By ERP]을 [조회]합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
     private EventResponse searchARInterfaceStatusByERP(Event e) throws EventException {
         // PDTO(Data Transfer Object including Parameters)
         GeneralEventResponse eventResponse = new GeneralEventResponse();
         EesDmt5001Event event = (EesDmt5001Event)e;
         InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();

         try{
             List<ARInterfaceStatusVO> list = command.searchARInterfaceStatusByERP(event.getARInterfaceParmVO());
             eventResponse.setRsVoList(list);
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
      * EES_DMT_3109, EES_DMT_4002, EES_DMT_4004 : [Loading]<br>
      * [Invoice 발행에 필요한 초기정보]를 [조회]합니다.<br>
      * 
      * @param Event e
      * @return EventResponse
      * @exception EventException
      */     
     private EventResponse searchInvInitInfo(Event e) throws EventException {
         GeneralEventResponse eventResponse = new GeneralEventResponse();
         EesDmt4002Event event = (EesDmt4002Event)e;
         CommonFinderBC comCommand = new CommonFinderBCImpl();
         InvoiceIssueCollectionMgtBC invCommand = new InvoiceIssueCollectionMgtBCImpl();
         
         try {
        	 // 1. 로그인 사용자의 Country Code 조회
        	 String usrCntCd = comCommand.searchUserCntCode(account.getOfc_cd());
        	 eventResponse.setETCData("USR_CNT_CD", usrCntCd);
        	 
        	 // 2. 로그인 사용자 Office 의 현재 일자 조회
 			 String currDt = comCommand.searchCurrentDateByOffice(account.getOfc_cd());
        	 eventResponse.setETCData("OFC_CURR_DAY", currDt);
        	 
        	 IssuedInvoiceParamVO paramVO = event.getIssuedInvoiceParamVO();
        	 
        	 // invoice 발행지역이 인도일 경우
        	 if ("IN".equals(usrCntCd)) {
        		 IdaGstRtoVO idaGstRtoVO = invCommand.searchIdaBankInfo();
        		 eventResponse.setETCData("IDA_BANK_ACCT_NO", idaGstRtoVO.getIdaBankAcctNo());
        		 eventResponse.setETCData("IDA_BANK_IFSC_CD", idaGstRtoVO.getIdaBankIfscCd());
        		 
        		 if ("4004".equals(paramVO.getPgmId())) {
	      			// India Tax 정보를 조회한다.==========================================================================================
	      			ChargeBookingInvoiceVO chgBkgInvVO = new ChargeBookingInvoiceVO();
	      			invCommand.setIdaTaxInfo(chgBkgInvVO, usrCntCd);
	      			eventResponse.setETCData("IDA_TAX_APPL_TM",      chgBkgInvVO.getIdaTaxApplTm());
	      			eventResponse.setETCData("IDA_EXPN_TAX_RT",      chgBkgInvVO.getIdaExpnTaxRt());
	      			eventResponse.setETCData("IDA_EDU_TAX_RT",       chgBkgInvVO.getIdaEduTaxRt());
	      			eventResponse.setETCData("IDA_HIGH_EDU_TAX_RT",  chgBkgInvVO.getIdaHighEduTaxRt());
	      			eventResponse.setETCData("IDA_LOCL_TAX_RT",      chgBkgInvVO.getIdaLoclTax());
	      			eventResponse.setETCData("IDA_N2ND_LOCL_TAX_RT", chgBkgInvVO.getIdaN2ndLoclTaxRt());
	      			//====================================================================================================================
        		 }
        	 }
        	 else {
      			eventResponse.setETCData("IDA_TAX_APPL_TM",      "");
      			eventResponse.setETCData("IDA_EXPN_TAX_RT",      "");
      			eventResponse.setETCData("IDA_EDU_TAX_RT",       "");
      			eventResponse.setETCData("IDA_HIGH_EDU_TAX_RT",  "");
      			eventResponse.setETCData("IDA_LOCL_TAX_RT",      "");
      			eventResponse.setETCData("IDA_N2ND_LOCL_TAX_RT", "");
        	 }
        	 
             // 3. Manual Invoice 에서만 사용되는 초기정보 조회
             if ("4004".equals(paramVO.getPgmId())) {
            	 
     			//1.Tariff Type 정보를 조회한다.===================================================================================
     			List<TariffNameVO> 	tariffList = comCommand.searchTariffTypeList();
     			StringBuffer 		sbTariff   = new StringBuffer();
     			
     			if (tariffList != null && tariffList.size() > 0) {
     				for (TariffNameVO tariffNameVO : tariffList) {
     					sbTariff.append(tariffNameVO.getDmdtTrfCd()).append("=").append(tariffNameVO.getDmdtTrfNm()).append("|");
     				}
     			}
     			
     			if (sbTariff.length() > 0) sbTariff = sbTariff.deleteCharAt(sbTariff.length()-1);
     			eventResponse.setETCData("TARIFF", sbTariff.toString());
     			//===============================================================================================================
     			
     			//2.Manual Invoice Reason 정보를 조회한다.==========================================================================
     			CommonCodeVO			commonCodeVO		= new CommonCodeVO();
     			commonCodeVO.setIntgCdId("CD01975");
     			
     			List<CommonCodeVO> 		mnlInvRsnList 		= comCommand.searchCommonCode(commonCodeVO);
     			StringBuffer 			sbMnlInvRsn			= new StringBuffer();
     			
     			if (mnlInvRsnList != null && mnlInvRsnList.size() > 0) {
     				for (CommonCodeVO mnlInvRsnVO : mnlInvRsnList) {
     					sbMnlInvRsn.append(mnlInvRsnVO.getIntgCdValCtnt()).append("=").append(mnlInvRsnVO.getIntgCdValDpDesc()).append("|");
     				}
     			}
     			
     			if (sbMnlInvRsn.length() > 0) sbMnlInvRsn = sbMnlInvRsn.deleteCharAt(sbMnlInvRsn.length()-1);
     			eventResponse.setETCData("INV_RSN", sbMnlInvRsn.toString());
     			//===============================================================================================================
     			
     			//4.RECEIVE TERM 정보를 조회한다.===================================================================================
     			commonCodeVO.setIntgCdId("CD00764");
     			
     			List<CommonCodeVO> 		rcvTermList 		= comCommand.searchCommonCode(commonCodeVO);
     			StringBuffer 			sbRcvTerm 			= new StringBuffer();
     			
     			if (rcvTermList != null && rcvTermList.size() > 0) {
     				for (CommonCodeVO rcvTermVO : rcvTermList) {
     					sbRcvTerm.append(rcvTermVO.getIntgCdValCtnt()).append("=").append(rcvTermVO.getIntgCdValDpDesc()).append("|");
     				}
     			}
     			
     			if (sbRcvTerm.length() > 0) sbRcvTerm = sbRcvTerm.deleteCharAt(sbRcvTerm.length()-1);
     			eventResponse.setETCData("RCV_TERM", sbRcvTerm.toString());
     			//==================================================================================================================
     			
     			//5.DELIVERY TERM 정보를 조회한다.=====================================================================================
     			commonCodeVO.setIntgCdId("CD00765");
     			
     			List<CommonCodeVO> 		deTermList 			= comCommand.searchCommonCode(commonCodeVO);
     			StringBuffer 			sbDeTerm 			= new StringBuffer();
     			
     			if (deTermList != null && deTermList.size() > 0) {
     				for (CommonCodeVO deTermVO : deTermList) {
     					sbDeTerm.append(deTermVO.getIntgCdValCtnt()).append("=").append(deTermVO.getIntgCdValDpDesc()).append("|");
     				}
     			}
     			
     			if (sbDeTerm.length() > 0) sbDeTerm = sbDeTerm.deleteCharAt(sbDeTerm.length()-1);
     			eventResponse.setETCData("DE_TERM", sbDeTerm.toString());
     			//====================================================================================================================		
     			
     			//7.Invoice Currency Code 정보를 조회한다.================================================================================
     			List<ARCurrencyVO> 		invCurrList 		= comCommand.searchARCurrencyList(paramVO.getOfcCd(), "");
     			StringBuffer 			sbInvCurr			= new StringBuffer();
     			
     			if (invCurrList != null && invCurrList.size() > 0) {
     				for (ARCurrencyVO arCurrencyVO : invCurrList) {
     					sbInvCurr.append(arCurrencyVO.getArCurrCd()).append("=").append(arCurrencyVO.getArCurrCd()).append("|");
     				}
     			}
     			
     			if (sbInvCurr.length() > 0) sbInvCurr = sbInvCurr.deleteCharAt(sbInvCurr.length()-1);
     			eventResponse.setETCData("AR_CURRENCY", sbInvCurr.toString());
     			//====================================================================================================================
             }
         }
         catch(EventException ex) {
             log.error("err " + ex.toString(), ex);
             throw new EventException(new ErrorHandler(ex).getMessage());
         }
         catch(Exception ex) {
             log.error("err " + ex.toString(), ex);
             throw new EventException(new ErrorHandler(ex).getMessage());
         }   
         return eventResponse;
     }
 
     /**
      * EES_DMT_4002 : [Payer 정보입력]<br>
      * [인도 Tax Ratio]를 [조회]합니다.<br>
      * 
      * @param Event e
      * @return EventResponse
      * @exception EventException
      */     
     private EventResponse searchIdaTaxRto(Event e) throws EventException {
         GeneralEventResponse eventResponse = new GeneralEventResponse();
         EesDmt4002Event event = (EesDmt4002Event)e;
         InvoiceIssueCollectionMgtBC invCommand = new InvoiceIssueCollectionMgtBCImpl();
         
         try {
        	 IdaGstRtoCondVO condVO = event.getIdaGstRtoCondVO();
        	 condVO.setOfcCd(account.getOfc_cd());
        	 
        	 IdaGstRtoVO idaGstRtoVO = invCommand.searchIdaTaxRto(condVO);

        	 if (idaGstRtoVO != null) {
        		 // GST Ratio Info
	        	 eventResponse.setETCData("IDA_CGST_RTO", idaGstRtoVO.getIdaCgstRto());
	        	 eventResponse.setETCData("IDA_SGST_RTO", idaGstRtoVO.getIdaSgstRto());
	        	 eventResponse.setETCData("IDA_IGST_RTO", idaGstRtoVO.getIdaIgstRto());
	        	 eventResponse.setETCData("IDA_UGST_RTO", idaGstRtoVO.getIdaUgstRto());
	        	 
	        	 // GST Customer/Vendor Info
	        	 eventResponse.setETCData("IDA_GST_RGST_NO", idaGstRtoVO.getIdaGstRgstNo());
	        	 eventResponse.setETCData("IDA_GST_RGST_STS_NM", idaGstRtoVO.getIdaGstRgstStsNm());
	        	 eventResponse.setETCData("IDA_STE_CD", idaGstRtoVO.getIdaSteCd());
	        	 eventResponse.setETCData("IDA_STE_NM", idaGstRtoVO.getIdaSteNm());
	        	 // SAC Info
	        	 eventResponse.setETCData("IDA_SAC_CD", idaGstRtoVO.getIdaSacCd());
	        	 eventResponse.setETCData("IDA_SAC_NM", idaGstRtoVO.getIdaSacNm());
        	 }
         }
         catch(EventException ex){
             log.error("err " + ex.toString(), ex);
             throw new EventException(new ErrorHandler(ex).getMessage());
         }
         catch(Exception ex){
             log.error("err " + ex.toString(), ex);
             throw new EventException(new ErrorHandler(ex).getMessage());
         }          	 
         return eventResponse;
     }
}