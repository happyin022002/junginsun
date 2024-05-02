/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AccountReceivableInvoiceMasterDataMgtSC.java
 *@FileTitle : Ex. Rate Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.24
 *@LastModifier : 김세일
 *@LastVersion : 1.0
 * 2009.04.24 김세일
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.09.07 최도순 [CHM-201005726] ALPS > Cut Over VVD Creation for New A/R Office 보완 요청
 * 2010.11.23 이석준 [CHM-201006884] FNS_INV_0114 신규 개발(조회,저장 기능 추가)
 * 2011.01.24 최도순 [CHM-201108418] 베트남지역 ALPS INVOICE 변경 요청
 * 2011.05.12 김태균 [CHM-201110564-01] AR Invoice - VVD 조회 기능 개발 요청 - 신규
 * 2011.08.04 오요한 [CHM-201112323] ALPS 코드 속성 작업 결과에 따른 기 메뉴 삭제된 ALPS INV 소스 삭제
 * 2011.10.11 권   민 [CHM-201113617] FNS_INV_0123 신규 개발(조회,저장 기능 추가)
 * 2012.12.04 오요한 [CHM-201221542] AR INV > PHILIPS EDI 개발 요청
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.xmlbeans.XmlObject;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.basic.ARInvoiceCustomerMgtBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.basic.ARInvoiceCustomerMgtBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0013Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0014Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0015Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0051Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0074Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0075Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0080Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0081Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0082Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0086Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0090Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0091Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0102Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0123Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0127Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0128Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0142Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event.FnsInv0143Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.ARInvoiceBadCustomerHistoryVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.AgentByVesselPortVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CprtItemVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CreditCustomerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CustRepEmlInfoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CustomerListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CustomerSecurityVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.InvCprtCdConvVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.PopCustomerListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.PriCustomerListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.SearchAgentListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.SearchCustomerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.SearchSVATNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.TemplateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.ActPayerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.AutoInvCustomerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.basic.ARInvoiceExRateMgtBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.basic.ARInvoiceExRateMgtBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event.FnsInv0006Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event.FnsInv0007Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event.FnsInv0008Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event.FnsInv0089Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event.FnsInv0100Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event.FnsInv0101Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration.ARInvoiceExRateMgtDBDAO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.CustDailyExRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExRateListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.VVDExrateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.VVDandPortListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.basic.GeneralARInvoiceMasterDataMgtBC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.basic.GeneralARInvoiceMasterDataMgtBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event.Fns0430001Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event.FnsInv0004Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event.FnsInv0020Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event.FnsInv0072Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event.FnsInv0073Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event.FnsInv0076Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event.FnsInv0077Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event.FnsInv0078Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event.FnsInv0107Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event.FnsInv0108Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event.FnsInv0114Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event.FnsInv0117Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event.FnsInv0121Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event.FnsInv0133Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event.FnsInv0134Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvArBankListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvArLoclChgVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvArStupOfcVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvCutOffLaneVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.LaneOrderVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.MdmOrganizationVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.PHILSLocationListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.PrinterbyUserIdVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.ProcessingVvdListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.RevenueProcessParamVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.RevenueVvdListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvChgDescConvVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.basic.INVCommonUtil;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.DateTime;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.syscommon.common.table.ArFincDirConvVO;
import com.hanjin.syscommon.common.table.InvEdiIntgCdDtlVO;
import com.hanjin.syscommon.common.table.InvEdiIntgCdVO;
import com.hanjin.syscommon.common.table.InvRevAcctCdVO;
import com.hanjin.syscommon.common.table.MdmChargeVO;
import com.hanjin.syscommon.common.table.MdmCurrencyVO;

/**
 * ALPS-AccountReceivableInvoiceMasterDataMgt Business Logic ServiceCommand - ALPS-AccountReceivableInvoiceMasterDataMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author saeil kim
 * @see ARInvoiceExRateMgtDBDAO
 * @since J2EE 1.4
 */ 

public class AccountReceivableInvoiceMasterDataMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * AccountReceivableInvoiceMasterDataMgt system 업무 시나리오 선행작업<br>
	 * FNS_INV-0006업무 시나리오 호출시 관련 내부객체 생성<br>
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
	 * AccountReceivableInvoiceMasterDataMgt system 업무 시나리오 마감작업<br>
	 * FNS_INV-0006 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("AccountReceivableInvoiceMasterDataMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-AccountReceivableInvoiceMasterDataMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("FnsInv0006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchServiceScopeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchExchangeRateList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0077Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRevenueLaneOrderList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0078Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRevenueVesselDirectionCodeConversionList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustomerList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBankAccountList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageBankAccount(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchSalesOffice(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0076Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRevenueAccountList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0008Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDailyExchangeRateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCustomerDailyExchangeRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchOfcCurrList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0013Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCreditCustomer(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0007Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCustomerExchangeRateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCustomerDailyExchangeRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchOfcCurrList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0089Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMultiCustomerExRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustomerMonExRate(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0015Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustomerListByOffice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSalesOfcList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0020Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLocalChargeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchLocalChargeLocationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMDMAccount(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchMdmCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageLocalCharge(e);
			}	
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0086Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopCustomerList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0072Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCutOffLaneListByAROffice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCutOffLaneByAROffice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSvcLane(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchVVD(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchAROfficeList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0090Event")) {
			eventResponse = searchRFACustomerList(e);
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0091Event")) {
			eventResponse = searchSCCustomerList(e);
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0080Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAgentByVesselPortList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchOfcCurrList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0073Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIssueStandardByOffice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageIssueStandardByOffice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchChargeCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchLocalChargeExists(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0081Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAgentList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAgentByVslPodList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAgentByVslPod(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0082Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSubAgentList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSubAgent(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0100Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // open
				eventResponse = this.searchPortList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // retrieve I/O
				eventResponse = this.searchPortListByBnd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // retrieve triangle
				eventResponse = this.searchPortListByTri(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { // retrieve EUR
				eventResponse = this.searchEURPortList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.createVVDExchangeRate(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0101Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // open
				eventResponse = this.searchPortList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // retrieve
				eventResponse = this.searchVVDExchangeRateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // retrieve
				eventResponse = this.searchVVDSADate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.manageVVDExchangeRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = this.searchARInvoiceExist(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("Fns0430001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				createRevenueAccountList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0102Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchCodeConversionList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = this.searchCustomerName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = this.searchCustomerName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = this.searchHJSCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.manageCodeConversion(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = this.createCodeConversion(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0074Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSecurityList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageCustomerSecurity(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0051Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSelectedItemList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTemplateName(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchReportItemList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageTemplateItem(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = removeTemplate(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0075Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustomerSecurityList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0107Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMDMOfficeList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0108Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchINVPrinterbyUserId(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageINVPrinterName(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0114Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEDIMappingCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageEDIMappingCodeList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0117Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVIEMappingCodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageVIEMappingCodeList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0118Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCustomerName(e);
		    }
		}
		else if (e.getEventName().equalsIgnoreCase("FnsInv0121Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchErpIfVvdList(e);
		    }
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0123Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSVATNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSVATNo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0127Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBadCustomerList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0128Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBadCustomerHistoryList(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("FnsInv0133Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEdiPHILSLocationList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageEdiPHILSLocationList(e);
			}
		} else if(e.getEventName().equalsIgnoreCase("FnsInv0134Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSurchargeDescriptionList(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageSurchargeDescriptionList(e);
			} 
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0142Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchActualPayerList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("FnsInv0143Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAutoInvCustomerList(e);
			}
		}

		return eventResponse;
	}

	/**
	 * FNS_INV_0006 : 조회<br>
	 * [COMBO BOX List] MDM Service Scope를 조회합니다.<br>
	 * All/OTH 추가
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchServiceScopeList(Event e) throws EventException {
		INVCommonUtil command = new INVCommonUtil();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<String> scpList = command.searchServiceScopeList();
			String svcCd = "ALL";
			StringBuffer svcCdBuff = new StringBuffer();
			
			for (int i = 0; i < scpList.size(); i++) {
				svcCdBuff.append("|" + scpList.get(i));
				//svcCd = svcCd + "|" + scpList.get(i);
			}
			
			svcCd = svcCdBuff.toString();
			svcCd = svcCd + "|" + "OTH";
			eventResponse.setETCData("svc_scp_cd", svcCd);
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
	 * FNS_INV_0077 : 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRevenueLaneOrderList(Event e) throws EventException {
		
		FnsInv0077Event event = (FnsInv0077Event) e;
		GeneralARInvoiceMasterDataMgtBC gmdm = new GeneralARInvoiceMasterDataMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<LaneOrderVO> list = gmdm.searchRevenueLaneOrderList(event.getLaneOrderInPutVO());
			eventResponse.setRsVoList(list);
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
	 * FNS_INV_0078 : 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRevenueVesselDirectionCodeConversionList(Event e) throws EventException {
		
		FnsInv0078Event event = (FnsInv0078Event) e;
		GeneralARInvoiceMasterDataMgtBC gmdm = new GeneralARInvoiceMasterDataMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<ArFincDirConvVO> list = gmdm.searchRevenueVesselDirectionCodeConversionList(event.getArFincDirConvVO());
			eventResponse.setRsVoList(list);
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
	 * FNS_INV_0014 : 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerList(Event e) throws EventException {
		FnsInv0014Event event = (FnsInv0014Event) e;
		ARInvoiceCustomerMgtBC bc = new ARInvoiceCustomerMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<SearchCustomerVO> list = bc.searchCustomerList(event.getSearchCustomerVO());
			eventResponse.setRsVoList(list);
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
	 * FNS_INV_0004 : Retrieve <br>
	 * Office별 Invoice 표기 은행계좌조회. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBankAccountList(Event e) throws EventException {
		FnsInv0004Event event = (FnsInv0004Event) e;
		GeneralARInvoiceMasterDataMgtBC gmdm = new GeneralARInvoiceMasterDataMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<InvArBankListVO> list = gmdm.searchBankAccountList(event.getArOfc(), event.getSaleOfc());

			if (list.size() > 0) {
				eventResponse.setRsVoList(list);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
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
	 * FNS_INV_0004 : Save <br>
	 * Office별 Invoice발행시 표기되는 정보중 하나인 Currency별 은행계좌정보등록 및 수정. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageBankAccount(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0004Event event = (FnsInv0004Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		try {
			begin();
				command.manageBankAccount(event.getInvArBankVOS(), account.getUsr_id());
				eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0004 : Sales OFC@FOCUS OUT <br>
	 * 입력한 Sales Office가 로그인 USER 의 AR Office소속 인지 CHECK한다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSalesOffice(Event e) throws EventException {
		FnsInv0004Event event = (FnsInv0004Event) e;
		GeneralARInvoiceMasterDataMgtBC gmdm = new GeneralARInvoiceMasterDataMgtBCImpl();
		String ofcCd = "";
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			ofcCd = gmdm.searchSalesOffice(event.getArOfc(), event.getSaleOfc());

			if (ofcCd.equals("")) {
				eventResponse.setUserMessage(new ErrorHandler("INV00038").getUserMessage());
				eventResponse.setETCData("ofc_chk", "N");
			} else {
				eventResponse.setETCData("ofc_chk", "Y");
			}
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00038").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * FNS_INV_0076 : Retrieve <br>
	 * ERP에서 Interface 받은 Revenue account를 조회(매출채권 데이터 생성시 charge별 revenue account를 결정함). <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRevenueAccountList(Event e) throws EventException {
		FnsInv0076Event event = (FnsInv0076Event) e;
		GeneralARInvoiceMasterDataMgtBC gmdm = new GeneralARInvoiceMasterDataMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			String source = event.getInvRevAcctCdVO().getInvSrcCd();
			String revGroup = event.getInvRevAcctCdVO().getRevTpGrpCd();
			String del = event.getInvRevAcctCdVO().getDeltFlg();

			List<InvRevAcctCdVO> list = gmdm.searchRevenueAccountList(source, revGroup, del);

			eventResponse.setRsVoList(list);
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
	 * FNS_INV_0008 : 조회<br>
	 * Daily 환율을 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDailyExchangeRateList(Event e) throws EventException {
		FnsInv0008Event event = (FnsInv0008Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<CustDailyExRateVO> list = command.searchDailyExchangeRateList(event.getSearchExRateVO());
			eventResponse.setRsVoList(list);
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
	 * FNS_INV_0008 : 입력, 수정, 삭제 <br>
	 * Daily 환율을 입력,수정,삭제합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCustomerDailyExchangeRate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0008Event event = (FnsInv0008Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		BookingARCreationBC command2 = new BookingARCreationBCImpl();
		try {
			begin();
			command.manageCustomerDailyExchangeRate(event.getCustDailyExRateVOs(), account.getUsr_id());

			String backEndJobKey = command2.manageARInvoiceExRateList(event.getExchangeRateVOs(), account.getUsr_id());
			eventResponse.setCustomData("KEY", backEndJobKey);

			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0007 : 조회 <br>
	 * Customer 환율을 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerExchangeRateList(Event e) throws EventException {
		
		FnsInv0007Event event = (FnsInv0007Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<CustDailyExRateVO> list = command.searchCustomerExchangeRateList(event.getSearchExRateVO());
			eventResponse.setRsVoList(list);
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
	 * FNS_INV_0013 : Retrieve<br>
	 * Customer 테이블 에서 조회조건에 해당하는 기초정보 및 신용정보를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCreditCustomer(Event e) throws EventException {
		FnsInv0013Event event = (FnsInv0013Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		
		List<CreditCustomerVO> list = null;
		List<CustRepEmlInfoVO> list01 = null;
		
		try {
			list = command.searchCreditCustomer(event.getFrmCustCntCd(), event.getFrmCustSeq(), event.getFrmCustRgstNo());
			list01 = command.searchMdmCustRepEmlInfo(event.getFrmCustCntCd(), event.getFrmCustSeq());

			eventResponse.setRsVoList(list);  
			eventResponse.setRsVoList(list01);

			 if(list == null){ 
				 eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage()); 
			 }
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0015 : Retrieve<br>
	 * 관리 Office별 Credit/Sales Customer 정보를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerListByOffice(Event e) throws EventException {
		FnsInv0015Event event = (FnsInv0015Event) e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		//SignOnUserAccount account = event.getSignOnUserAccount();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<CustomerListVO> list = command.searchCustomerListByOffice(event.getCustFlag(), account.getOfc_cd(), event.getOfcCd(), event.getCustRlseCtrlFlg());
			eventResponse.setRsVoList(list);
			if (list.size() <= 0) {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0015 : Option Change<br>
	 * 소속 AR_HD_QTR_OFC_CD 산하의 모든 office code를 가져온다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSalesOfcList(Event e) throws EventException {
		//FnsInv0015Event event = (FnsInv0015Event) e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		//SignOnUserAccount account = event.getSignOnUserAccount();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<String> list = command.searchSalesOfcList(account.getOfc_cd());
			String ofc = "";
			StringBuffer ofcBuff = new StringBuffer();

			for (int i = 0; i < list.size(); i++) {
				ofcBuff.append("|" + list.get(i));
				//ofc = ofc + "|" + list.get(i);
			}
			ofc = ofcBuff.toString();
			eventResponse.setETCData("ofc", ofc);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0007,FNS_INV_0008,FNS_INV_0080,FNS_INV_0100 : 조회<br>
	 * AR Office, currency list, Service Scope 조회 처리합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfcCurrList(Event e) throws EventException {
		INVCommonUtil command = new INVCommonUtil();
		List<String> list = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			if (e.getEventName().equalsIgnoreCase("FnsInv0007Event")) {
				FnsInv0007Event event = (FnsInv0007Event) e;
				list = command.searchAROfficeList(account.getOfc_cd(), event.getPageType());
			} else if (e.getEventName().equalsIgnoreCase("FnsInv0008Event")) {
				FnsInv0008Event event = (FnsInv0008Event) e;
				list = command.searchAROfficeList(account.getOfc_cd(), event.getPageType());
			} else if (e.getEventName().equalsIgnoreCase("FnsInv0080Event")) {
				FnsInv0080Event event = (FnsInv0080Event) e;
				list = command.searchAROfficeList(account.getOfc_cd(), event.getPageType());
			} else if (e.getEventName().equalsIgnoreCase("FnsInv0100Event")) {
				FnsInv0100Event event = (FnsInv0100Event) e;
				list = command.searchAROfficeList(account.getOfc_cd(), event.getPageType());
			}
			
			List<MdmCurrencyVO> currList = command.searchCurrencyCodeList();

			String ar_ofc_info = "";
			String currInfo = "";
			StringBuffer arOfcInfoBuff = new StringBuffer();
			StringBuffer currInfoBuff = new StringBuffer();
			if(list != null){
				for (int i = 0; i < list.size(); i++) {
					arOfcInfoBuff.append("|" + list.get(i));
					//ar_ofc_info = ar_ofc_info + "|" + list.get(i);
				}
			}
			ar_ofc_info = arOfcInfoBuff.toString();
			
			for (int i = 0; i < currList.size(); i++) {
				currInfoBuff.append("|" + currList.get(i).getCurrCd());
				//currInfo = currInfo + "|" + currList.get(i).getCurrCd();
			}
			currInfo = currInfoBuff.toString();

			// 화면 로딩시 Service Scope 조회

			if (e.getEventName().equalsIgnoreCase("FnsInv0100Event")) {
				List<String> scpList = command.searchServiceScopeList();

				String svcCd = "ALL";
				StringBuffer svcCdBuff = new StringBuffer();
				
				for (int i = 0; i < scpList.size(); i++) {
					svcCdBuff.append("|" + scpList.get(i));
					//svcCd = svcCd + "|" + scpList.get(i);
				}
				svcCd = svcCdBuff.toString();
				
				svcCd = svcCd + "|" + "OTH";
				eventResponse.setETCData("svc_scp_cd", svcCd);
			}

			eventResponse.setETCData("ar_ofc_cd", ar_ofc_info);
			eventResponse.setETCData("currInfo", currInfo);
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
	 * FNS_INV_0020 : Retrieve<br>
	 * Local에서 사용하는 Charge code 를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocalChargeList(Event e) throws EventException {
		FnsInv0020Event event = (FnsInv0020Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		// SignOnUserAccount account = event.getSignOnUserAccount();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<InvArLoclChgVO> list = command.searchLocalChargeList(event.getOfc(), event.getLocCd());
			eventResponse.setRsVoList(list);
			if (list.size() <= 0) {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0020 : Open<br>
	 * ofc에 따라 loc_cd 를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocalChargeLocationList(Event e) throws EventException {
		FnsInv0020Event event = (FnsInv0020Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		// SignOnUserAccount account = event.getSignOnUserAccount();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<String> list = command.searchLocalChargeLocationList(event.getOfc());
			String loc_cd = "";
			StringBuffer locCdBuff = new StringBuffer();
			
			for (int i = 0; i < list.size(); i++) {
				locCdBuff.append("|" + list.get(i));
				//loc_cd = loc_cd + "|" + list.get(i);
			}
			loc_cd = locCdBuff.toString();
			eventResponse.setETCData("loc_cd", loc_cd);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0020 : code check<br>
	 * 입력한 acct_cd 를 조회하여 체크한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMDMAccount(Event e) throws EventException {
		FnsInv0020Event event = (FnsInv0020Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		// SignOnUserAccount account = event.getSignOnUserAccount();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			String acct_cd = command.searchMDMAccount(event.getAcctCd());

			eventResponse.setETCData("acct_cd", acct_cd);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0020 : Save<br>
	 * 지역별 Local Charge등록, 수정, 삭제 한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageLocalCharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0020Event event = (FnsInv0020Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		try {
			begin();
			command.manageLocalCharge(event.getInvArLoclChgVOS(), account.getUsr_id());
			// 에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err-->> " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0086 : Retrieve<br>
	 * POP UP UI의 Customer 정보 List를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopCustomerList(Event e) throws EventException {
		FnsInv0086Event event = (FnsInv0086Event) e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<PopCustomerListVO> list = command.searchPopCustomerList(event.getCntry(), event.getCustNm(), event.getZipNo(), event.getChkNm(), event.getCustRgstNo());
			eventResponse.setRsVoList(list);
			if (list.size() <= 0) {
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0089: 입력, 수정, 삭제 <br>
	 * Customer 환율의 Multi 입력,수정,삭제 처리합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMultiCustomerExRate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0089Event event = (FnsInv0089Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		BookingARCreationBC command2 = new BookingARCreationBCImpl();
		try {
			begin();
			command.manageMultiCustomerExRate(event.getMultiCustomerVOs(), event.getCustDailyExRateVOs(), account.getUsr_id());
			commit();
			
			begin();
			String backEndJobKey = command2.manageARInvoiceExRateList(event.getExchangeRateVOs(), account.getUsr_id());
			commit();
			eventResponse.setCustomData("KEY", backEndJobKey);

			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			

		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00001").getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * FNS_INV_0089: 조회<br>
	 * 월별 Customer 환율 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerMonExRate(Event e) throws EventException {
		FnsInv0089Event event = (FnsInv0089Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		int cnt = 0;
		try {
			cnt = command.searchCustomerMonExRate(event.getCustCndCd(), event.getCustSeq(), event.getMon());
			eventResponse.setETCData("cnt", Integer.toString(cnt));
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
	 * FNS_INV_0072 : Retrieve<br>
	 * 신규 AR Office 생성 시 구 Office와 구분 기준조회 한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCutOffLaneListByAROffice(Event e) throws EventException {
		FnsInv0072Event event = (FnsInv0072Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<InvCutOffLaneVO> list = command.searchCutOffLaneListByAROffice(event.getOldOfc(), event.getNewOfc());
			eventResponse.setRsVoList(list);
			if (list.size() <= 0) {
				eventResponse.setUserMessage(new ErrorHandler("COM10053").getUserMessage());
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0072 : Save<br>
	 * A/R Office별 Cut Off Lane정보등록, 수정, 삭제<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCutOffLaneByAROffice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0072Event event = (FnsInv0072Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		try {
			begin();
			command.manageCutOffLaneByAROffice(event.getInvCutOffLaneVOS(), account.getUsr_id());
			// 에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			// eventResponse.setUserMessage("OK");
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0072 : Lane FOCUS OUT<br>
	 * 입력한 lane이 등록된 유효한 code인지를 CHECK한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSvcLane(Event e) throws EventException {
		FnsInv0072Event event = (FnsInv0072Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			String slanCd = command.searchSvcLane(event.getSlanCd());
			eventResponse.setETCData("dataVal", slanCd);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0072 : Port FOCUS OUT, FNS_INV_0020 : LocCd 체크<br>
	 * 입력한 Port가 등록된 유효한 code인지를 CHECK한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocation(Event e) throws EventException {		
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if (e.getEventName().equalsIgnoreCase("FnsInv0072Event")) {
				FnsInv0072Event event = (FnsInv0072Event) e;
				String portCd = command.searchLocation(event.getPortCd());
				eventResponse.setETCData("dataVal", portCd);
			}else{
				FnsInv0020Event event = (FnsInv0020Event) e;
				String portCd = command.searchLocation(event.getLocCd());
				eventResponse.setETCData("loc_cd", portCd);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0072 : vvd FOCUS OUT<br>
	 * 입력한 VVD가 운항스케쥴에 등록된 유효한 VVD인지를 CHECK 한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVVD(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0072Event event = (FnsInv0072Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		INVCommonUtil command2 = new INVCommonUtil();
		try {
			String saDate = "";
			String vslCd = command.searchVVD(event.getVslCd(), event.getSkdVoyNo(), event.getSkdDirCd());
			eventResponse.setETCData("dataVal", vslCd);
			if (vslCd.length() > 0) {
				saDate = command2.searchSADate(event.getVslCd() + event.getSkdVoyNo() + event.getSkdDirCd(), event.getPortCd(), event.getIoBndCd());
				eventResponse.setETCData("saDate", saDate);
			}
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0090 : 조회<br>
	 * RFA 조회 이벤트 처리합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRFACustomerList(Event e) throws EventException {
		FnsInv0090Event event = (FnsInv0090Event) e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<PriCustomerListVO> list = command.searchRFACustomerList(event.getRfaNo());
			eventResponse.setRsVoList(list);
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
	 * FNS_INV_0091 : 조회 <br>
	 * SC 조회 이벤트 처리합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSCCustomerList(Event e) throws EventException {
		FnsInv0091Event event = (FnsInv0091Event) e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<PriCustomerListVO> list = command.searchSCCustomerList(event.getScNo());
			eventResponse.setRsVoList(list);
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
	 * FNS_INV_0080 : 조회<br>
	 * Vessel Port 별 Agent 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgentByVesselPortList(Event e) throws EventException {
		FnsInv0080Event event = (FnsInv0080Event) e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<AgentByVesselPortVO> list = command.searchAgentByVesselPortList(event.getOption(), event.getOfc(), account.getOfc_cd());
			eventResponse.setRsVoList(list);
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
	 * FNS_INV_0073 : Retrieve<br>
	 * Office별 Invoice 발행시 특이사항및 발행유형을 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIssueStandardByOffice(Event e) throws EventException {
		FnsInv0073Event event = (FnsInv0073Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			InvArStupOfcVO invArStupOfcVO = command.searchIssueStandardByOffice(event.getArOfcCd());
			if(invArStupOfcVO != null){
				String chgCd = invArStupOfcVO.getChgCd();
				if(chgCd != null){
					eventResponse.setETCData("chg_cd", chgCd);
				}								
			}else{
				eventResponse.setUserMessage(new ErrorHandler("INV00095").getUserMessage());
			}
			
			if(invArStupOfcVO != null){
				eventResponse.setRsVo(invArStupOfcVO);		
			}
			 
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0073 : Save<br>
	 * 본사수입관리담당자가 Invoice issue정보 관리시 A/R Office 별로 상이한 부분을 항목별로 등록 수정한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageIssueStandardByOffice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0073Event event = (FnsInv0073Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		try {
			begin();
			event.getInvArStupOfcVO().setCreUsrId(account.getUsr_id());
			event.getInvArStupOfcVO().setUpdUsrId(account.getUsr_id());

			command.manageIssueStandardByOffice(event.getInvArStupOfcVO());

			command.manageMriChgcdByOffice(event.getArOfcCd(), event.getChgCd(), account.getUsr_id());

			// 에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			// eventResponse.setUserMessage("OK");
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0081,FNS_INV_0082 : 조회<br>
	 * Agent List 를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgentList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0081Event event = (FnsInv0081Event) e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		List<SearchAgentListVO> list = null;

		try {
			list = command.searchAgentList(event.getArOfcCd(), event.getArCtrlOfcCd());
			StringBuilder comboText = new StringBuilder();
			StringBuilder comboCode = new StringBuilder();
			
			for(int i=0; i<list.size(); i++) {
				String agnCd = list.get(i).getAgnCd();
				String arOfcCd = list.get(i).getArOfcCd();
				String chnAgnCd = list.get(i).getChnAgnCd();
				String custCntCd = list.get(i).getCustCntCd();
				String custSeq = list.get(i).getCustSeq();
				String vndrCntCd = list.get(i).getVndrCntCd();
				String vndrSeq = list.get(i).getVndrSeq();
				comboText.append("|" + agnCd);
				comboCode.append("|" + agnCd + "^" + arOfcCd + "^" + chnAgnCd + "^" + custCntCd + "^" + custSeq + "^" + vndrCntCd + "^" + vndrSeq);
			}
			eventResponse.setETCData("agn_text", comboText.toString());
			eventResponse.setETCData("agn_cd", comboCode.toString());
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

//	/**
//	 * FNS_INV_0082 : 조회<br>
//	 * Port 별 Agent를 조회합니다.<br>
//	 * 
//	 * @param Event e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse searchAgentByPort(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		FnsInv0082Event event = (FnsInv0082Event) e;
//		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
//		try {
//			List<AgentByVesselPortVO> list = command.searchAgentByPort(event.getPod(), event.getLane());
//			eventResponse.setRsVoList(list);
//		} catch (EventException ex) {
//			rollback();
//			throw ex;
//		} catch (Exception ex) {
//			rollback();
//			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
//		}
//		return eventResponse;
//	}
//
//	/**
//	 * FNS_INV_0082 : 입력,수정<br>
//	 * port별 Agent를 입력,수정합니다.<br>
//	 * 
//	 * @param Event e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//
//	private EventResponse manageAgentByPort(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		FnsInv0082Event event = (FnsInv0082Event) e;
//		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
//		try {
//			begin();
//			command.manageAgentByPort(event.getAgentByVesselPortVOS(), account.getUsr_id());
//			// 에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
//			eventResponse.setUserMessage(new ErrorHandler("INV00051").getUserMessage());
//			// eventResponse.setUserMessage("OK");
//
//			commit();
//		} catch (EventException ex) {
//			rollback();
//			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
//		} catch (Exception ex) {
//			rollback();
//			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
//		}
//		return eventResponse;
//	}
//
//	/**
//	 * FNS_INV_0082 : 삭제<br>
//	 * Port별 Agent를 삭제합니다.<br>
//	 * 
//	 * @param Event e
//	 * @return EventResponse
//	 * @exception EventException
//	 */
//	private EventResponse removeAgentByPort(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		FnsInv0082Event event = (FnsInv0082Event) e;
//		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
//		try {
//			begin();
//			command.removeAgentByPort(event.getAgentByVesselPortVOS(), account.getUsr_id());
//			// 에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
//			eventResponse.setUserMessage(new ErrorHandler("INV00057", new String[] {}).getUserMessage());
//			// eventResponse.setUserMessage("OK");
//			commit();
//		} catch (EventException ex) {
//			rollback();
//			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
//		} catch (Exception ex) {
//			rollback();
//			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
//		}
//		return eventResponse;
//	}

	/**
	 * FNS_INV_0100,FNS_INV_0101 : 조회<br>
	 * SvrID,OfcCd로 Port를 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String svrId = "";
		String ofcCd = "";
		String pageType = "";
		try {
			if (e.getEventName().equalsIgnoreCase("FnsInv0100Event")) {
				FnsInv0100Event event = (FnsInv0100Event) e;
				svrId = event.getSvrId();
				ofcCd = event.getOfcCd();

			} else if (e.getEventName().equalsIgnoreCase("FnsInv0101Event")) {
				FnsInv0101Event event = (FnsInv0101Event) e;
				svrId = event.getSvrId();
				ofcCd = event.getOfcCd();
			}

			INVCommonUtil bcommand = new INVCommonUtil();

			List<String> ofcList = null;
			// officeList
			ofcList = bcommand.searchAROfficeList(account.getOfc_cd(), pageType);

			// currList
			List<MdmCurrencyVO> currList = bcommand.searchCurrencyCodeList();

			// log.info(currList);

			String arOfcInfo = "";
			String currInfo = "";
			StringBuffer arOfcInfoBuff = new StringBuffer();
			StringBuffer currInfoBuff = new StringBuffer();
			
			for (int i = 0; i < ofcList.size(); i++) {
				arOfcInfoBuff.append("|" + ofcList.get(i));
				//arOfcInfo = arOfcInfo + "|" + ofcList.get(i);

				StringTokenizer stTemp = new StringTokenizer(ofcList.get(i), "^");
				List<String> ofcTemp = new ArrayList<String>();
				String ofcStrTemp = null;
				while (stTemp.hasMoreTokens()) {
					ofcStrTemp = stTemp.nextToken();
					ofcTemp.add(ofcStrTemp);
				}
				if (account.getOfc_cd().equals(ofcTemp.get(1))) {
					if (svrId.trim().length() < 1) {
						svrId = ofcTemp.get(7).toString();
					}
					if (ofcCd.trim().length() < 1) {
						ofcCd = ofcTemp.get(1).toString();
					}
				}
			}
			arOfcInfo = arOfcInfoBuff.toString();

			for (int i = 0; i < currList.size(); i++) {
				currInfoBuff.append("|" + currList.get(i).getCurrCd() + "^" + currList.get(i).getCurrNm());
				//currInfo = currInfo + "|" + currList.get(i).getCurrCd() + "^" + currList.get(i).getCurrNm();
			}
			currInfo = currInfoBuff.toString();

			// 화면 로딩시 Service Scope 조회
			List<String> scpList = bcommand.searchServiceScopeList();

			String svcCd = "ALL";
			StringBuffer svcCdBuff = new StringBuffer();
			for (int i = 0; i < scpList.size(); i++) {
				svcCdBuff.append("|" + scpList.get(i));
				//svcCd = svcCd + "|" + scpList.get(i);
			}
			svcCd = svcCdBuff.toString();
			svcCd = svcCd + "|" + "OTH";

			ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();

			List<String> list = command.searchPortList(svrId, ofcCd);

			String portList = "ALL";
			StringBuffer portListBuff = new StringBuffer();
			for (int i = 0; i < list.size(); i++) {
				portListBuff.append("|" + list.get(i));
				//portList = portList + "|" + list.get(i);
			}
			portList = portListBuff.toString();

			eventResponse.setETCData("svc_scp_cd", svcCd);
			eventResponse.setETCData("ar_ofc_cd", arOfcInfo);
			eventResponse.setETCData("currInfo", currInfo);
			eventResponse.setETCData("portList", portList);
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
	 * FNS_INV_0100 : 조회 <br>
	 * VVD or 날짜로 운항정보에서 ETD/ETA 에 해당하고 office의 contry code에 해당하는 Port list 조회합니다. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortListByBnd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0100Event event = (FnsInv0100Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		try {
			List<VVDandPortListVO> list = command.searchPortListByBnd(event.getSearchVVDPortVO());
			eventResponse.setRsVoList(list);
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
	 * FNS_INV_0100 : 조회 <br>
	 * [Triangle기준] Triangle로 옵션 선택시 INV_AR_MN, INV_AR_CHG에서 환율이 미반영된 대상 PORT list 조회합니다..<br>
	 * 단 office의 contry code(or Conti CD )가 아닌 Port<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPortListByTri(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0100Event event = (FnsInv0100Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		try {
			List<VVDandPortListVO> list = command.searchPortListByTri(event.getSearchVVDPortVO());
			eventResponse.setRsVoList(list);
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
	 * FNS_INV_0100 : 조회 <br>
	 * SVR_ID 가 EUR일때  INV_AR_MN, INV_AR_CHG에서 환율이 미반영된 대상 PORT list 조회합니다..<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEURPortList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0100Event event = (FnsInv0100Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		try {
			List<VVDandPortListVO> list = command.searchEURPortList(event.getSearchVVDPortVO());
			eventResponse.setRsVoList(list);
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
	 * FNS_INV_0100 : 입력,수정,삭제<br>
	 * VVD 환율일괄등록, VVD별 환율을 Bound/port/service scop/화폐별로 등록합니다.<br>
	 * ERP AR로 해당내용 I/F 합니다.(EAI : FNS019-0002).<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createVVDExchangeRate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0100Event event = (FnsInv0100Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		BookingARCreationBC command2 = new BookingARCreationBCImpl();
		try {
			begin();
			
			String svrId = event.getSvrId();
			String triYn = event.getTriYn();
			String ofc = event.getOfcCd();
			
			List<VVDandPortListVO> vVDandPortListVOs = event.getVvdAndPortListVOs();				
			ExchangeRateVO[] exchangeRateVOs = event.getExchangeRateVOs();
			ExchangeRateVO[] allExchangeRateVOs = null;
			List<VVDExrateVO> vVDExrateVOs = event.getVvdExrateVOs();
			List<VVDExrateVO> allVVDExrateVOs = new ArrayList<VVDExrateVO>();
			
			allVVDExrateVOs.addAll(vVDExrateVOs);
			
			log.debug("allVVDExrateVOs="+allVVDExrateVOs.size());
			
			//구주이고 Bnd가 Triangle이 아닐때
			if(svrId.equals("EUR")&&triYn.equals("N")){
				List<VVDandPortListVO> allVvdPortVOs = new ArrayList<VVDandPortListVO>();
				
				if(vVDandPortListVOs.size()>0){
					for(int i = 0 ; i < vVDandPortListVOs.size() ; i ++){
						List<VVDandPortListVO> vvdPortVOs= command.searchEURVVDList(vVDandPortListVOs.get(i).getVvdCd());						
						allVvdPortVOs.addAll(vvdPortVOs);
					}
				}
				
				
				BigDecimal usdInvXchRt = new BigDecimal("0");
				
				for (int i = 0; i < vVDExrateVOs.size(); i++) {
					if(vVDExrateVOs.get(i).getChgCurrCd().equals("USD")){
						usdInvXchRt = new BigDecimal(vVDExrateVOs.get(i).getInvXchRt());
					}
				}
				
				for (int i = 0; i < vVDExrateVOs.size(); i++) {
					
					//2010.03.08 입력한 Currency가 MDM_ORGANIZATION에 AR_CURR_CD 로 등록 되어 있는 경우만 LoclCurrCd로 세팅
					int currCnt = command.searchARCurrCd( ofc, vVDExrateVOs.get(i).getChgCurrCd() );
					
					if(currCnt > 0){
						if(!vVDExrateVOs.get(i).getChgCurrCd().equals("USD")){
							VVDExrateVO vVDExrateVO = new VVDExrateVO();						
							
							vVDExrateVO.setLoclCurrCd(vVDExrateVOs.get(i).getChgCurrCd());
							vVDExrateVO.setChgCurrCd(vVDExrateVOs.get(i).getLoclCurrCd());
							vVDExrateVO.setInvXchRt(vVDExrateVOs.get(i).getIvsXchRt());
							vVDExrateVO.setIvsXchRt(vVDExrateVOs.get(i).getInvXchRt());
							vVDExrateVO.setArOfcCd(vVDExrateVOs.get(i).getArOfcCd());	
							
							allVVDExrateVOs.add(vVDExrateVO);
							
							if( !usdInvXchRt.toString().equals("0")){
								vVDExrateVO = new VVDExrateVO();	
								
								BigDecimal invXchRt = new BigDecimal(vVDExrateVOs.get(i).getInvXchRt());
								
								//20100302 LOCL CHG CURR 역으로 변경 
								//BigDecimal exRate = invXchRt.divide(usdInvXchRt,6,BigDecimal.ROUND_UP);
								//BigDecimal ivsXchRt = usdInvXchRt.divide(invXchRt,6,BigDecimal.ROUND_UP);
								
								BigDecimal ivsXchRt = invXchRt.divide(usdInvXchRt,6,BigDecimal.ROUND_UP);
								BigDecimal exRate = usdInvXchRt.divide(invXchRt,6,BigDecimal.ROUND_UP);
								
								//vVDExrateVO.setLoclCurrCd("USD");
								//vVDExrateVO.setChgCurrCd(vVDExrateVOs.get(i).getChgCurrCd());
								vVDExrateVO.setLoclCurrCd(vVDExrateVOs.get(i).getChgCurrCd());
								vVDExrateVO.setChgCurrCd("USD");
								
								vVDExrateVO.setInvXchRt(exRate.toString());
								vVDExrateVO.setIvsXchRt(ivsXchRt.toString());
								vVDExrateVO.setArOfcCd(vVDExrateVOs.get(i).getArOfcCd());	
								
								allVVDExrateVOs.add(vVDExrateVO);
							}
						}
					}
				}
				
				log.debug("allVVDExrateVOs2="+allVVDExrateVOs.size());				
				
				command.createVVDExchangeRate(allVvdPortVOs, allVVDExrateVOs, account.getUsr_id());
				
				List<ExchangeRateVO> allExRateVOs = new ArrayList<ExchangeRateVO>();								
				
				for (int i = 0; i < exchangeRateVOs.length; i++) {
					
					for (int j = 0; j < allVvdPortVOs.size(); j++) {					
						ExchangeRateVO exchangeRateVO = new ExchangeRateVO();
						exchangeRateVO.setVslCd(allVvdPortVOs.get(j).getVvdCd().substring(0,4));
						exchangeRateVO.setSkdVoyNo(allVvdPortVOs.get(j).getVvdCd().substring(4,8));
						exchangeRateVO.setSkdDirCd(allVvdPortVOs.get(j).getVvdCd().substring(8,9));
						exchangeRateVO.setIoBndCd(allVvdPortVOs.get(j).getIoBndCd());
						exchangeRateVO.setPortCd(allVvdPortVOs.get(j).getVpsPortCd());
						exchangeRateVO.setSvcScpCd(allVvdPortVOs.get(j).getSvcScpCd());
						exchangeRateVO.setChgCurrCd(exchangeRateVOs[i].getChgCurrCd());
						exchangeRateVO.setLoclCurrCd(exchangeRateVOs[i].getLoclCurrCd());
						exchangeRateVO.setXchRtTpCd(exchangeRateVOs[i].getXchRtTpCd());
						exchangeRateVO.setInvXchRt(exchangeRateVOs[i].getInvXchRt());
						exchangeRateVO.setIbflag(exchangeRateVOs[i].getIbflag());
						allExRateVOs.add(exchangeRateVO);
					}
				}
				
				log.debug("allExRateVOs="+allExRateVOs.size());				
				
				//2010-02-12 추가 USD가 아닌 환율 local curr 대 chg curr 바꿔서 입력 
				for (int i = 0; i < exchangeRateVOs.length; i++) {
					for (int j = 0; j < allVvdPortVOs.size(); j++) {						
						
						//2010.03.08 입력한 Currency가 MDM_ORGANIZATION에 AR_CURR_CD 로 등록 되어 있는 경우만 LoclCurrCd로 세팅
						int currCnt = command.searchARCurrCd( ofc, exchangeRateVOs[i].getChgCurrCd() );
						
						if(!exchangeRateVOs[i].getChgCurrCd().equals("USD") && currCnt > 0){
							ExchangeRateVO exchangeRateVO = new ExchangeRateVO();
							exchangeRateVO.setVslCd(allVvdPortVOs.get(j).getVvdCd().substring(0,4));
							exchangeRateVO.setSkdVoyNo(allVvdPortVOs.get(j).getVvdCd().substring(4,8));
							exchangeRateVO.setSkdDirCd(allVvdPortVOs.get(j).getVvdCd().substring(8,9));
							exchangeRateVO.setIoBndCd(allVvdPortVOs.get(j).getIoBndCd());
							exchangeRateVO.setPortCd(allVvdPortVOs.get(j).getVpsPortCd());
							exchangeRateVO.setSvcScpCd(allVvdPortVOs.get(j).getSvcScpCd());
							exchangeRateVO.setChgCurrCd(exchangeRateVOs[i].getLoclCurrCd());
							exchangeRateVO.setLoclCurrCd(exchangeRateVOs[i].getChgCurrCd());
							exchangeRateVO.setXchRtTpCd(exchangeRateVOs[i].getXchRtTpCd());
							exchangeRateVO.setInvXchRt(exchangeRateVOs[i].getIvsXchRt());
							exchangeRateVO.setIbflag(exchangeRateVOs[i].getIbflag());
							allExRateVOs.add(exchangeRateVO);
							
							if( !usdInvXchRt.toString().equals("0")){
								
								exchangeRateVO = new ExchangeRateVO();
								
								BigDecimal invXchRt = new BigDecimal(exchangeRateVOs[i].getInvXchRt());	
								//20100302 LOCL CHG CURR 역으로 변경 
								//BigDecimal exRate = invXchRt.divide(usdInvXchRt,6,BigDecimal.ROUND_UP);
								BigDecimal exRate = usdInvXchRt.divide(invXchRt,6,BigDecimal.ROUND_UP);
								
								log.debug("invXchRt="+invXchRt);
								log.debug("exRate="+exRate);
								
								exchangeRateVO.setVslCd(allVvdPortVOs.get(j).getVvdCd().substring(0,4));
								exchangeRateVO.setSkdVoyNo(allVvdPortVOs.get(j).getVvdCd().substring(4,8));
								exchangeRateVO.setSkdDirCd(allVvdPortVOs.get(j).getVvdCd().substring(8,9));
								exchangeRateVO.setIoBndCd(allVvdPortVOs.get(j).getIoBndCd());
								exchangeRateVO.setPortCd(allVvdPortVOs.get(j).getVpsPortCd());
								exchangeRateVO.setSvcScpCd(allVvdPortVOs.get(j).getSvcScpCd());
								//exchangeRateVO.setChgCurrCd(exchangeRateVOs[i].getChgCurrCd());
								//exchangeRateVO.setLoclCurrCd("USD");
								exchangeRateVO.setChgCurrCd("USD");
								exchangeRateVO.setLoclCurrCd(exchangeRateVOs[i].getChgCurrCd());
								exchangeRateVO.setXchRtTpCd(exchangeRateVOs[i].getXchRtTpCd());
								exchangeRateVO.setInvXchRt(exRate.toString());
								exchangeRateVO.setIbflag(exchangeRateVOs[i].getIbflag());
								allExRateVOs.add(exchangeRateVO);
							}
						}
					}
				}
				
				log.debug("allExRateVOs2="+allExRateVOs.size());		
				
				allExchangeRateVOs = new ExchangeRateVO[allExRateVOs.size()];
				allExchangeRateVOs = allExRateVOs.toArray(allExchangeRateVOs);
				
			}else{
				command.createVVDExchangeRate(vVDandPortListVOs, event.getVvdExrateVOs(), account.getUsr_id());
				
				List<ExchangeRateVO> allExRateVOs = new ArrayList<ExchangeRateVO>();
				
				for (int i = 0; i < exchangeRateVOs.length; i++) {					
					for (int j = 0; j < vVDandPortListVOs.size(); j++) {
						ExchangeRateVO exchangeRateVO = new ExchangeRateVO();
						exchangeRateVO.setVslCd(vVDandPortListVOs.get(j).getVvdCd().substring(0,4));
						exchangeRateVO.setSkdVoyNo(vVDandPortListVOs.get(j).getVvdCd().substring(4,8));
						exchangeRateVO.setSkdDirCd(vVDandPortListVOs.get(j).getVvdCd().substring(8,9));
						exchangeRateVO.setIoBndCd(vVDandPortListVOs.get(j).getIoBndCd());
						exchangeRateVO.setPortCd(vVDandPortListVOs.get(j).getVpsPortCd());
						exchangeRateVO.setSvcScpCd(vVDandPortListVOs.get(j).getSvcScpCd());
						exchangeRateVO.setChgCurrCd(exchangeRateVOs[i].getChgCurrCd());
						exchangeRateVO.setLoclCurrCd(exchangeRateVOs[i].getLoclCurrCd());
						exchangeRateVO.setXchRtTpCd(exchangeRateVOs[i].getXchRtTpCd());
						exchangeRateVO.setInvXchRt(exchangeRateVOs[i].getInvXchRt());
						exchangeRateVO.setIbflag(exchangeRateVOs[i].getIbflag());
						allExRateVOs.add(exchangeRateVO);
					}
				}
				
				allExchangeRateVOs = new ExchangeRateVO[allExRateVOs.size()];
				allExchangeRateVOs = allExRateVOs.toArray(allExchangeRateVOs);				
			}
			commit();
			
			begin();			
			command2.manageARInvoiceExRateList(allExchangeRateVOs, account.getUsr_id());			
			commit();
			
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			eventResponse.setRsVoList(Arrays.asList(allExchangeRateVOs));
			
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0101 : 조회<br>
	 * VVD 환율조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVVDExchangeRateList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0101Event event = (FnsInv0101Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		try {
			List<VVDExrateVO> list = command.searchVVDExchangeRateList(event.getSearchVVDExRateVO());
			eventResponse.setRsVoList(list);
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
	 * FNS_INV_0101 : 조회<br>
	 * VVD USD경리환율 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVVDSADate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0101Event event = (FnsInv0101Event) e;
		INVCommonUtil command = new INVCommonUtil();
		try {
			
			//2009-11-30 경리환율 체크시 SA Date 가 아닌 SysMon 으로 변경 이상희과장	
			//2011.07.11 김경남 차장 확인 결과. 입출항일 이전에 환율을 입력함에 따라, 익월 초 입출항일인 VVD 에 대하여 전월 중순에 입력할 경우, 익월 경리환율 미존재로 인한 ERROR 방지를 위하여 입력월의 경리 환율 사용 
			String saDt = DateTime.getDateString().replace(".", "").substring(0,6);
			
			String usd_locl_xch_rt = "";
			if (!saDt.equals("")) {
				saDt = saDt.replace("-", "").substring(0, 6);

				String from_currCd = event.getFromCurrCd();
				String to_currCd = event.getToCurrCd();
				String effDt = saDt;

				usd_locl_xch_rt = command.searchAccountRate(from_currCd, to_currCd, effDt);

			} else {
				usd_locl_xch_rt = "saDt";
			}

			eventResponse.setETCData("usd_locl_xch_rt", usd_locl_xch_rt);
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
	 * FNS_INV_0101 : 조회<br>
	 * 해당 환율이 적용된 채권데이터가 있는지 확인합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchARInvoiceExist(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0101Event event = (FnsInv0101Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		try {
			String cnt = command.searchARInvoiceExist(event.getExchangeRateVO());
			eventResponse.setETCData("cnt", cnt);
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
	 * FNS_INV_0101 : 입력,수정,삭제<br>
	 * VVD 환율등록,수정,삭제, VVD별 환율을 Bound/port/service scop/화폐별로 등록합니다.<br>
	 * ERP AR로 해당내용 I/F 합니다.(EAI : FNS019-0002)<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVVDExchangeRate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0101Event event = (FnsInv0101Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		BookingARCreationBC command2 = new BookingARCreationBCImpl();
		try {

			begin();
			command.manageVVDExchangeRate(event.getVvdExrateVOs(), account.getUsr_id());
			commit();
			
			begin();
			String backEndJobKey = command2.manageARInvoiceExRateList(event.getExchangeRateVOs(), account.getUsr_id());
			commit();
			eventResponse.setCustomData("KEY", backEndJobKey);
			
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS043-0001 : Receive <br>
	 * ERP에서 Revenue Type별 Account code를 전송받아 생성함. <br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	private void createRevenueAccountList(Event e) throws EventException {
		// GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		XmlObject xmlObject = ((Fns0430001Event) e).getXmlObject();
		InvRevAcctCdVO[] invRevAcctCds = command.fns0430001Receive(xmlObject);

		try {
			begin();
				command.createRevenueAccountList(invRevAcctCds);
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
	}

	/**
	 * FNS_INV_0102 : Retrieve<br>
	 * CPR(Customer preFerable Report)에서 사용할 code로 조회조건으로 입력한 ,S/C NO, RFA NO, Code 유형으로 조회한다.
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCodeConversionList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0102Event event = (FnsInv0102Event) e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		try {
			List<InvCprtCdConvVO> list = command.searchCodeConversionList(event.getScNo(), event.getRfaNO(), event.getCodeTy());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0102 : S/C NO or RFA NO@FOCUS OUT<br>
	 * CPR 에서 사용.(입력한 S/C NO or RFA NO 로 PRI 정보에서 Customer name를 찾아와 보여준다.
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerName(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0102Event event = (FnsInv0102Event) e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		try {
			String customerName = command.searchCustomerName(event.getScNo(), event.getRfaNO());
			eventResponse.setETCData("customerName", customerName);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0102 : HJS CODE FOCUS OUT<br>
	 * 입력한 CODE가 유형별로 사용 가능한 유효한 code인지를 CHECK한다.
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHJSCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0102Event event = (FnsInv0102Event) e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		try {
			String hjsCode = command.searchHJSCode(event.getCdTp(), event.getCd());
			eventResponse.setETCData("hjsCode", hjsCode);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0102 : Save<br>
	 * CPR(Customer preFerable Report)에서 사용할 code. <br>
	 * 입력된 Conversion code 들을 선택한 유형으로 S/C NO 나 RFA NO 별로 등로가, 수정,삭제한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCodeConversion(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0102Event event = (FnsInv0102Event) e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		try {
			begin();
			command.manageCodeConversion(event.getInvCprtCdConvVOs(), account.getUsr_id());
			// 에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0102 : Copy to now<br>
	 * CPR(Customer preFerable Report)에서 사용할 code. <br>
	 * 이미 입력된 Conversion code 들을 입력한 S/C NO 나 RFA NO 로 동일 하게 신규생성해 준다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createCodeConversion(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0102Event event = (FnsInv0102Event) e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		try {
			begin();
			command.createCodeConversion(event.getInvCprtCdConvVOs(), account);
			// 에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0074 : 조회<br>
	 * Customer 신용담보조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSecurityList(Event e) throws EventException {
		FnsInv0074Event event = (FnsInv0074Event) e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<CustomerSecurityVO> list = command.searchSecurityList(event.getCustCntCd(), event.getCustSeq());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0074 : 입력,수정,삭제<br>
	 * Customer 신용정보인 담보등록,수정,삭제합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCustomerSecurity(Event e) throws EventException {
		FnsInv0074Event event = (FnsInv0074Event) e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			command.manageCustomerSecurity(event.getInvArScrVOs(), account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0051 : Open<br>
	 * CPR(Customer Preferable Report)에서 사용. 선택가능한 모든 항목 List 와 를 가져온다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReportItemList(Event e) throws EventException {
		//FnsInv0051Event event = (FnsInv0051Event) e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			CprtItemVO cprtItemVO = command.searchReportItemList(account.getUsr_id(), account.getOfc_cd());
			eventResponse.setRsVoList(cprtItemVO.getCprtItemListVOs());
			eventResponse.setRsVoList(cprtItemVO.getRptTmpltNmVOs());


		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0051 : TempleteName CHANGE<br>
	 * CPR 에서 사용. Template으로 등록된 선택 item정보를 가져온다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSelectedItemList(Event e) throws EventException {
		FnsInv0051Event event = (FnsInv0051Event) e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			TemplateVO templateVO  = command.searchSelectedItemList(event.getRptTmpltNm(), event.getOfcCd());
			
//			List<TemplateItemVO> templateItemVOs = command.searchSelectedItemList(event.getRptTmpltNm(), account.getOfc_cd());

			//eventResponse.setRsVo(templateVO);

			eventResponse.setRsVoList(templateVO.getListTemplateItemVO());
			eventResponse.setRsVoList(templateVO.getListInvCprtTmpltChgVO());

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0051 : TempleteName CHANGE<br>
	 * CPR 에서 사용. 입력한 Template명이 테이블에 존재하는 Template명인지를 CHECK한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTemplateName(Event e) throws EventException {
		FnsInv0051Event event = (FnsInv0051Event) e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			String tmpleName = command.searchTemplateName(event.getRptTmpltNm());

			eventResponse.setETCData("tmpleName", tmpleName);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0051 : Save<br>
	 * CPR(Customer preFerable Report)에서 사용할 item을 user 가 선택한하여 Template으로 관리 한다.(등록, 수정, 삭제)<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTemplateItem(Event e) throws EventException {
		FnsInv0051Event event = (FnsInv0051Event) e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			command.manageTemplateItem(event.getTemplateVOs(), event.getInvCprtTmpltChgVOs(), account.getUsr_id(), account.getOfc_cd());
			// 에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0051 : Save<br>
	 * CPR(Customer preFerable Report)에서 사용할 item을 user 가 선택한하여 Template으로 관리 한다.(등록, 수정, 삭제)<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeTemplate(Event e) throws EventException {
		FnsInv0051Event event = (FnsInv0051Event) e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			command.removeTemplate(event.getRptTmpltNm(), event.getOfcCd());
			//command.removeTemplate(event.getRptTmpltNm(), account.getOfc_cd());
			// 에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.
			eventResponse.setUserMessage(new ErrorHandler("INV00051", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0075 : 조회<br>
	 * Customer별 신용담보정보조회 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerSecurityList(Event e) throws EventException {
		FnsInv0075Event event = (FnsInv0075Event) e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<CustomerSecurityVO> list = command.searchCustomerSecurityList(event.getSecurityInputVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0107<br>
	 * Office Inquiry<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMDMOfficeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0107Event event = (FnsInv0107Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();

		try {
			List<MdmOrganizationVO> mdmOrganizationVO = command.searchMDMOfficeList(event.getMdmOfcInPutVO());
			eventResponse.setRsVoList(mdmOrganizationVO);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * FNS_INV_0006 : 조회<br>
	 * 환율유형별 리스트를 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExchangeRateList(Event e) throws EventException {
		FnsInv0006Event event = (FnsInv0006Event) e;
		ARInvoiceExRateMgtBC command = new ARInvoiceExRateMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			ExRateListVO exRateListVO = command.searchExchangeRateList(event.getSearchVVDExRateVO());

			String xchRtTpCd = event.getSearchVVDExRateVO().getXchRtTpCd();

			if (xchRtTpCd.equals("V")) {
				eventResponse.setRsVoList(exRateListVO.getVvdExrateList());
			} else if (xchRtTpCd.equals("I") || xchRtTpCd.equals("C") || xchRtTpCd.equals("D")) {
				eventResponse.setRsVoList(exRateListVO.getCustDailyExRateList());
			} else if (xchRtTpCd.equals("A")) {
				eventResponse.setRsVoList(exRateListVO.getGlMonExrateList());
			}
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
	 * FNS_INV_0108<br>
	 * INVOICE Printer Set up정보를 조회한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchINVPrinterbyUserId(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0108Event event = (FnsInv0108Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();

		try {
			List<PrinterbyUserIdVO> printerbyUserIdVO = command.searchINVPrinterbyUserId(event.getOfcCd(), event.getUsrId());
			eventResponse.setETCData("ArOfcCd", printerbyUserIdVO.get(0).getArOfcCd());
			eventResponse.setETCData("InvPrnDvcNm", printerbyUserIdVO.get(0).getInvPrnDvcNm());
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * FNS_INV_0108<br>
	 * INVOICE Printer Set up정보를 수정, 입력한다.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageINVPrinterName(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0108Event event = (FnsInv0108Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		
		try{
			begin();
			command.manageINVPrinterName(event.getArOfcCd(), account.getUsr_id(), event.getInvPrnDvcNm());
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0081<br>
	 * Vessel Port 별 Agent 조회합니다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgentByVslPodList(Event e) throws EventException {
		FnsInv0081Event event = (FnsInv0081Event)e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<AgentByVesselPortVO> list = command.searchAgentByVesselPortList(event.getOptType(), event.getArOfcCd(), account.getOfc_cd());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0081<br>
	 * Vessel 별 Agent를 입력,수정,삭제한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAgentByVslPod(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0081Event event = (FnsInv0081Event) e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		
		try {
			begin();
			command.manageAgentByVslPod(event.getOptType(), event.getAgentByVesselPortVOS(), account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("INV00051").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0082<br>
	 * POD 별 관리 북중국 Inbound Collection Agent를 조회한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSubAgentList(Event e) throws EventException {
		FnsInv0082Event event = (FnsInv0082Event)e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<AgentByVesselPortVO> list = command.searchSubAgentList(event.getArOfcCd());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0082<br>
	 * 미주( USA) 지역 Port 별  Agent 을 Match 하여 등록한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSubAgent(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0082Event event = (FnsInv0082Event) e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		
		try {
			begin();
			command.manageSubAgent(event.getInvSubAgnCustCdVOS(), account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("INV00051").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0073 : Open<br>
	 * ofc cd,chg cd 코드조회 이벤트 처리<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchChargeCodeList(Event e) throws EventException {
		INVCommonUtil command = new INVCommonUtil();
		List<String> ofcList = null;
		List<MdmChargeVO> chgCodeList = null;
		FnsInv0073Event event = (FnsInv0073Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			ofcList = command.searchAROfficeList(account.getOfc_cd(), event.getPageType());
			chgCodeList = command.searchChargeCodeList();

			String arOfcInfo = "";
			StringBuffer arOfcInfoBuff = new StringBuffer();
			for (int i = 0; i < ofcList.size(); i++) {
				arOfcInfoBuff.append("|" + ofcList.get(i));
				//arOfcInfo = arOfcInfo + "|" + ofcList.get(i);
			}
			arOfcInfo = arOfcInfoBuff.toString();
			
			String chgCodeInfo = "";
			StringBuffer chgCodeInfoBuff = new StringBuffer();
			for (int i = 0; i < chgCodeList.size(); i++) {
				if (!chgCodeList.get(i).getChgCd().trim().equals("")) {
					chgCodeInfoBuff.append("|" + chgCodeList.get(i).getChgCd());
					//chgCodeInfo = chgCodeInfo + "|" + chgCodeList.get(i).getChgCd();
				}
			}
			chgCodeInfo = chgCodeInfoBuff.toString();
			
			eventResponse.setETCData("ar_ofc_cd", arOfcInfo);
			eventResponse.setETCData("chg_cd", chgCodeInfo);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0020 : Open<br>
	 * ofc cd,chg cd,svc scp cd 코드조회 이벤트 처리<br>
	 * 
	 * @author Dong Hoon Han
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmCodeList(Event e) throws EventException {
		INVCommonUtil command = new INVCommonUtil();
		//List<String> ofcList = null;
		List<MdmChargeVO> chgCodeList = null;
		FnsInv0020Event event = (FnsInv0020Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			//ofc_cd
			List<String> ofcList = command.searchAROfficeList(account.getOfc_cd(), event.getPageType());
			String ar_ofc_info = "";
			StringBuffer arOfcInfoBuff = new StringBuffer();
			for (int i = 0; i < ofcList.size(); i++) {
				arOfcInfoBuff.append("|" + ofcList.get(i));
				//ar_ofc_info = ar_ofc_info + "|" + ofcList.get(i);
			}
			ar_ofc_info = arOfcInfoBuff.toString();
			
			//svc_scp_cd
			List<String> list = command.searchServiceScopeList();

			String svcCd = "ALL";
			StringBuffer svcCdBuff = new StringBuffer();
			for (int i = 0; i < list.size(); i++) {
				svcCdBuff.append("|" + list.get(i));
				//svcCd = svcCd + "|" + list.get(i);
			}
			svcCd = svcCdBuff.toString();
			svcCd = svcCd + "|" + "OTH";			
			
			//chg_cd
			chgCodeList = command.searchChargeCodeList();
			String chgCodeInfo = "";
			StringBuffer chgCodeInfoBuff = new StringBuffer();
			for (int i = 0; i < chgCodeList.size(); i++) {
				if (!chgCodeList.get(i).getChgCd().trim().equals("")) {
					chgCodeInfoBuff.append("|" + chgCodeList.get(i).getChgCd());
					//chgCodeInfo = chgCodeInfo + "|" + chgCodeList.get(i).getChgCd();
				}
			}
			chgCodeInfo = chgCodeInfoBuff.toString();
			
			//curr_cd
			List<MdmCurrencyVO> currList = command.searchCurrencyCodeList();

			String currInfo = "";
			StringBuffer currInfoBuff = new StringBuffer();
			
			for (int i = 0; i < currList.size(); i++) {
				currInfoBuff.append("|" + currList.get(i).getCurrCd());
				//currInfo = currInfo + "|" + currList.get(i).getCurrCd();
			}
			currInfo = currInfoBuff.toString();
			
			eventResponse.setETCData("ar_ofc_cd", ar_ofc_info);
			eventResponse.setETCData("svc_scp_cd", svcCd);
			eventResponse.setETCData("chg_cd", chgCodeInfo);
			eventResponse.setETCData("currInfo", currInfo);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0072 : Open<br>
	 * A/R Office 리스트(오피스별 기본정보 포함)
	 * INQ 화면인 경우 User ID 소속의 RHQ내의 A/R Office 전체를 조회한다.<br>
	 * ENTRY 화면인 경우 User ID 소속의 A/R Office만 조회한다.<br>
	 * KOR 인 경우 RHQ내의 A/R Office 전체를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAROfficeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();

		
		try {
			List<String> list = command.searchAROfficeList(account.getOfc_cd());

			String arOfcInfo = "";
			StringBuffer arOfcInfoBuff = new StringBuffer();
			if (list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					arOfcInfoBuff.append("|" + list.get(i));
					//arOfcInfo = arOfcInfo + "|" + list.get(i);
				}
				arOfcInfo = arOfcInfoBuff.toString();
				
				eventResponse.setETCData("ar_ofc_cd", arOfcInfo);
			} else {
				eventResponse.setUserMessage(new ErrorHandler("INV00075").getUserMessage());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	/**
	 * FNS_INV_0114 : Open<br>
	 * Glovis Code conversion내용을 조회한다 
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEDIMappingCodeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		FnsInv0114Event event = (FnsInv0114Event) e;
		List<InvEdiIntgCdDtlVO> list =null;
		
		try {
			
			InvEdiIntgCdVO invEdiIntgCdVO = event.getInvEdiIntgCdVO();
			list = command.searchEDIMappingCodeList(invEdiIntgCdVO);
			
			eventResponse.setRsVoList(list);		
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	/**
	 * FNS_INV_0114<br>
	 * Glovis Code 인력/저장/삭제 function.<br>
	 * 
	 * @author 이석준
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEDIMappingCodeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0114Event event = (FnsInv0114Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		
		try {
			begin();

			command.manageEDIMappingCodeList(event.getInvEdiIntgCdDtlVOs(), account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("INV00051").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0117 : 조회<br>
	 * Charge Vietnam어 관리
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVIEMappingCodeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		FnsInv0117Event event = (FnsInv0117Event) e;
		List<InvEdiIntgCdDtlVO> list =null;
		
		try {
			
			InvEdiIntgCdVO invEdiIntgCdVO = event.getInvEdiIntgCdVO();
			list = command.searchEDIMappingCodeList(invEdiIntgCdVO);
			
			eventResponse.setRsVoList(list);		
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}
	/**
	 * FNS_INV_0117: 입력,수정,삭제<br>
	 * Charge Vietnam어 관리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageVIEMappingCodeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0117Event event = (FnsInv0117Event) e;
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		
		try {
			begin();

			command.manageEDIMappingCodeList(event.getInvEdiIntgCdDtlVOs(), account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("INV00051").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0121 : 조회<br>
	 * ERP에서 ALPS로 I/F받은 Revenue와 진행 VVD를 조회 할 수 있다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchErpIfVvdList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		FnsInv0121Event event = (FnsInv0121Event) e;
		List<RevenueVvdListVO> list1 =null;
		List<ProcessingVvdListVO> list2 =null;
		
		try {
			
			RevenueProcessParamVO paramVO = event.getRevenueProcessParamVO();
			if(paramVO.getOptionValue().equals("REV")){
				list1 = command.searchRevenueVvdList(paramVO);
				eventResponse.setRsVoList(list1);		
			}else if(paramVO.getOptionValue().equals("PRD")){
				list2 = command.searchProcessingVvdList(paramVO);
				eventResponse.setRsVoList(list2);		
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0123 : 조회<br>
	 * SVATNo 조회
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSVATNo(Event e) throws EventException {
		FnsInv0123Event event = (FnsInv0123Event)e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<SearchSVATNoVO> list = command.searchSVATNo(event.getSearchSVATNoVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0123<br>
	 * SVAT Reg. No 입력/수정 function.<br>
	 * 
	 * @author		권 민
	 * @param		Event e
	 * @return		EventResponse
	 * @exception	EventException
	 */
	private EventResponse manageSVATNo(Event e) throws EventException {
		FnsInv0123Event event = (FnsInv0123Event)e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			begin();
			command.manageSVATNo(event.getInvArSpndVatRgstNoVO(), account.getUsr_id());
			eventResponse.setUserMessage(new ErrorHandler("INV00051").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * BAD Customer Hist를 조회한다 : Receive <br>
	 * 
	 * @param Event e
	 * @exception EventException
	 */
	private EventResponse searchBadCustomerList (Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0127Event event = (FnsInv0127Event) e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		try {
			List<ARInvoiceBadCustomerHistoryVO> list = command.searchBadCustomerList(event.getArInvoiceBadCustomerHistoryVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * BAD Customer Hist를 조회한다 : Receive
	 * 
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchBadCustomerHistoryList (Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		FnsInv0128Event event = (FnsInv0128Event) e;
		ARInvoiceCustomerMgtBC command = new ARInvoiceCustomerMgtBCImpl();
		try {
			List<ARInvoiceBadCustomerHistoryVO> list = command.searchBadCustomerHistoryList(event.getArInvoiceBadCustomerHistoryVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("INV00053").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	
	/**
	 * FNS_INV_0133 : Retrieve<br>
	 * Philips Location Code 를 조회한다. <br>
	 * 
	 * @author 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEdiPHILSLocationList(Event e) throws EventException {
		
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		List<PHILSLocationListVO> list = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			list = command.searchEdiPHILSLocationList();
			eventResponse.setRsVoList(list);
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0133 : Retrieve<br>
	 * Philips Location Code 를 등록, 수정, 변경한다. <br>
	 * 
	 * @author 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEdiPHILSLocationList(Event e) throws EventException {
		
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		FnsInv0133Event event = (FnsInv0133Event) e;
		try {
			List<PHILSLocationListVO> list = new ArrayList<PHILSLocationListVO>();
			PHILSLocationListVO vos[] = event.getPhilsLocationListVO();
			
			if (vos != null && vos.length > 0) {
				for (int i = 0; i < vos.length; i++) {
					PHILSLocationListVO vo = vos[i];
					vo.setCreUsrId(account.getUsr_id());
					vo.setUpdUsrId(account.getUsr_id());
					list.add(vo);
				}

			}
			if (list.size() > 0)
				command.manageEdiPHILSLocationList(list);
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(
					(new ErrorHandler("COM12240")).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0134 : Retrieve<br>
	 * Surcharge Description 를 조회한다. <br>
	 * 
	 * @author 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSurchargeDescriptionList(Event e) throws EventException {
		
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		FnsInv0134Event event = (FnsInv0134Event) e;
		List<InvChgDescConvVO> list = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			list = command.searchSurchargeDescriptionList(event.getArHdQtrOfcCd(), event.getArOfcCd(), event.getChgCd());
			eventResponse.setRsVoList(list);
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * FNS_INV_0134 : Save<br>
	 * Surcharge Description 를 등록, 수정, 변경한다. <br>
	 * 
	 * @author 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSurchargeDescriptionList(Event e) throws EventException {
		
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		FnsInv0134Event event = (FnsInv0134Event) e;
		try {
			List<InvChgDescConvVO> list = new ArrayList<InvChgDescConvVO>();
			InvChgDescConvVO vos[] = event.getInvChgDescConvVOs();
			
			if (vos != null && vos.length > 0) {
				for (int i = 0; i < vos.length; i++) {
					InvChgDescConvVO vo = vos[i];
					
					vo.setCreUsrId(account.getUsr_id());
					vo.setUpdUsrId(account.getUsr_id());
					list.add(vo);
				}

			}
			if (list.size() > 0)
				command.manageSurchargeDescriptionList(list);
						
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(
					(new ErrorHandler("COM12240")).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * FNS_INV_0142 : 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchActualPayerList(Event e) throws EventException {
		FnsInv0142Event event = (FnsInv0142Event) e;
		ARInvoiceCustomerMgtBC bc = new ARInvoiceCustomerMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<ActPayerVO> list = bc.searchActualPayerList(event.getArOfcCd(), event.getUserOfcCd(), event.getActCustCntCd(), event.getActCustSeq());
			eventResponse.setRsVoList(list);
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
	 * FNS_INV_0143 : 조회<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAutoInvCustomerList(Event e) throws EventException {
		FnsInv0143Event event = (FnsInv0143Event) e;
		ARInvoiceCustomerMgtBC bc = new ARInvoiceCustomerMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<AutoInvCustomerVO> list = bc.searchAutoInvCustomerList(event.getArOfcCd(), event.getIoBndCd(), event.getUserOfcCd(), event.getActCustCntCd(), event.getActCustSeq());
			eventResponse.setRsVoList(list);
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
	 * FNS_INV_0073 : LOCAL Charge 에 등록된 Charge 인지 확인한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocalChargeExists(Event e) throws EventException {		
		GeneralARInvoiceMasterDataMgtBC command = new GeneralARInvoiceMasterDataMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			FnsInv0073Event event = (FnsInv0073Event) e;
			String ofcCd = command.searchLocalChargeExists(event.getArOfcCd(),event.getChgCd());
			eventResponse.setETCData("ofcCd", ofcCd);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
}