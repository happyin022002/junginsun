/*========================================================= 
*Copyright(c) 2006 CyberLogitec
*@FileName : BizCommonSC.java
*@FileTitle : Vessel조회(공통 Popup)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-02
*@LastModifier : sangyool pak
*@LastVersion : 1.0
* 2006-08-02 sangyool pak
* 1.0 최초 생성
*=====================================================
* 2013.03.26 김현화[CHM-201323759]Location code inquiry 화면에 State에 full description 추가 요청.
* 2013.09.05 조인영 [CHM-201326202] ETS연동에 따른 TRS CSR삭제로직 추가 요청
* 2014.01.28 전윤주 [CHM-201428683] 계약 종료 Notice건 개발  신규 화면 추가
* 2015.04.14 심성윤 [CHM-201534125] 결재라인 체크 로직 추가
* 2015.07.20 심성윤 [CHM-201536387] [Develop]ALPS Auth 사후 결재 기능 탭 로직 추가(0U1,0U2,0V1)
=========================================================*/
package com.hanjin.bizcommon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.basic.CgmValidationBC;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmvalidation.basic.CgmValidationBCImpl;
import com.hanjin.apps.alps.ees.lse.lsecommon.lsecommon.basic.LseCommonBC;
import com.hanjin.apps.alps.ees.lse.lsecommon.lsecommon.basic.LseCommonBCImpl;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.basic.GeneralCodeSearchMgtBC;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodesearchmgt.basic.GeneralCodeSearchMgtBCImpl;
import com.hanjin.apps.alps.esd.tes.common.tescommon.basic.TESCommonBC;
import com.hanjin.apps.alps.esd.tes.common.tescommon.basic.TESCommonBCImpl;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.basic.CARIssueTransferSlipManageBC;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.basic.CARIssueTransferSlipManageBCImpl;
import com.hanjin.apps.alps.esd.trs.common.trscommon.basic.TrsCommonBC;
import com.hanjin.apps.alps.esd.trs.common.trscommon.basic.TrsCommonBCImpl;
import com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.basic.CSRIssueTransferSlipManageBC;
import com.hanjin.apps.alps.esd.trs.invoicemanage.csrissuetranferslip.basic.CSRIssueTransferSlipManageBCImpl;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.basic.WorkOrderInquiryBC;
import com.hanjin.apps.alps.esd.trs.workordermanage.workorderinquiry.basic.WorkOrderInquiryBCImpl;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.basic.AGNCommAgreementBC;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.basic.AGNCommAgreementBCImpl;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.basic.AGNCommApprovalBC;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.basic.AGNCommApprovalBCImpl;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.basic.AGTAuditBC;
import com.hanjin.apps.alps.esm.agt.agtaudit.agtaudit.basic.AGTAuditBCImpl;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.basic.ExternalFinderBC;
import com.hanjin.apps.alps.esm.fms.fmscommon.externalfinder.basic.ExternalFinderBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.basic.TCharterIOConsultationBC;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.basic.TCharterIOConsultationBCImpl;
import com.hanjin.bizcommon.account.basic.AccountBC;
import com.hanjin.bizcommon.account.basic.AccountBCImpl;
import com.hanjin.bizcommon.account.event.ComEnsN11Event;
import com.hanjin.bizcommon.accountpayablecommon.basic.AccountPayableCommonBC;
import com.hanjin.bizcommon.accountpayablecommon.basic.AccountPayableCommonBCImpl;
import com.hanjin.bizcommon.accountpayablecommon.event.ComCom0440Event;
import com.hanjin.bizcommon.accountpayablecommon.vo.CenterListVO;
import com.hanjin.bizcommon.activity.basic.ActivityBC;
import com.hanjin.bizcommon.activity.basic.ActivityBCImpl;
import com.hanjin.bizcommon.activity.event.ComCom0009Event;
import com.hanjin.bizcommon.activity.vo.SearchMdmActivityVO;
import com.hanjin.bizcommon.agreementnotice.basic.AgreementNoticeBC;
import com.hanjin.bizcommon.agreementnotice.basic.AgreementNoticeBCImpl;
import com.hanjin.bizcommon.agreementnotice.event.ComNtc0001Event;
import com.hanjin.bizcommon.agreementnotice.event.ComNtc0002Event;
import com.hanjin.bizcommon.agreementnotice.event.ComNtc0003Event;
import com.hanjin.bizcommon.agreementnotice.event.ComNtc0004Event;
import com.hanjin.bizcommon.agreementnotice.util.AgreementNoticeUtil;
import com.hanjin.bizcommon.agreementnotice.vo.SearchAgreementListVO;
import com.hanjin.bizcommon.agreementnotice.vo.SearchContractCreationUserVO;
import com.hanjin.bizcommon.approval.basic.ApprovalBC;
import com.hanjin.bizcommon.approval.basic.ApprovalBCImpl;
import com.hanjin.bizcommon.approval.event.ComEns0T1Event;
import com.hanjin.bizcommon.approval.event.ComEns0U1Event;
import com.hanjin.bizcommon.approval.event.ComEns0U2Event;
import com.hanjin.bizcommon.approval.event.ComEns0W1Event;
import com.hanjin.bizcommon.approval.event.ComEns0Y1Event;
import com.hanjin.bizcommon.approval.util.ApprovalUtil;
import com.hanjin.bizcommon.approval.vo.ApprovalCsrVO;
import com.hanjin.bizcommon.approval.vo.ApprovalDeptVO;
import com.hanjin.bizcommon.approval.vo.ApprovalInqueryVO;
import com.hanjin.bizcommon.approval.vo.ApprovalRouteVO;
import com.hanjin.bizcommon.approval.vo.ApprovalStaffVO;
import com.hanjin.bizcommon.approval.vo.ApprovalStepVO;
import com.hanjin.bizcommon.approval.vo.SearchApprovalVO;
import com.hanjin.bizcommon.approval.vo.UnApprovalCsrVO;
import com.hanjin.bizcommon.authorization.util.AuthorizationApprovalUtil;
import com.hanjin.bizcommon.authorization.vo.AuthAproStaffVO;
import com.hanjin.bizcommon.authorization.vo.AuthEmlSndVO;
import com.hanjin.bizcommon.authorization.vo.AuthorizationAproVO;
import com.hanjin.bizcommon.authorization.vo.AuthorizationInquiryVO;
import com.hanjin.bizcommon.calendar.basic.CalendarBC;
import com.hanjin.bizcommon.calendar.basic.CalendarBCImpl;
import com.hanjin.bizcommon.carrier.basic.CarrierBC;
import com.hanjin.bizcommon.carrier.basic.CarrierBCImpl;
import com.hanjin.bizcommon.carrier.event.ComEns0N1Event;
import com.hanjin.bizcommon.carrier.vo.CarrierListVO;
import com.hanjin.bizcommon.cntrtpsz.basic.CntrTpSzBC;
import com.hanjin.bizcommon.cntrtpsz.basic.CntrTpSzBCImpl;
import com.hanjin.bizcommon.commodity.basic.CommodityBC;
import com.hanjin.bizcommon.commodity.basic.CommodityBCImpl;
import com.hanjin.bizcommon.commodity.event.ComEns011Event;
import com.hanjin.bizcommon.continent.basic.ContinentBC;
import com.hanjin.bizcommon.continent.basic.ContinentBCImpl;
import com.hanjin.bizcommon.continent.vo.SearchContinentListVO;
import com.hanjin.bizcommon.contractno.basic.ContractNoBC;
import com.hanjin.bizcommon.contractno.basic.ContractNoBCImpl;
import com.hanjin.bizcommon.contractno.event.ComEns021Event;
import com.hanjin.bizcommon.country.basic.CountryBC;
import com.hanjin.bizcommon.country.basic.CountryBCImpl;
import com.hanjin.bizcommon.country.event.ComEns0M1Event;
import com.hanjin.bizcommon.country.vo.CountryListVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.basic.ConsultationSlipRequestMgtBC;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.basic.ConsultationSlipRequestMgtBCImpl;
import com.hanjin.bizcommon.currency.basic.CurrencyBC;
import com.hanjin.bizcommon.currency.basic.CurrencyBCImpl;
import com.hanjin.bizcommon.currency.event.ComEnsN13Event;
import com.hanjin.bizcommon.customer.basic.CustomerBC;
import com.hanjin.bizcommon.customer.basic.CustomerBCImpl;
import com.hanjin.bizcommon.customer.event.ComEns041Event;
import com.hanjin.bizcommon.customer.event.ComEns043Event;
import com.hanjin.bizcommon.daylightsavingtime.basic.DaylightSavingTimeBC;
import com.hanjin.bizcommon.daylightsavingtime.basic.DaylightSavingTimeBCImpl;
import com.hanjin.bizcommon.daylightsavingtime.event.ComCom0005Event;
import com.hanjin.bizcommon.daylightsavingtime.vo.DaylightSavingTimeListVO;
import com.hanjin.bizcommon.eqorgchart.basic.EQOrgChartBC;
import com.hanjin.bizcommon.eqorgchart.basic.EQOrgChartBCImpl;
import com.hanjin.bizcommon.eqorgchart.event.ComEns0O1Event;
import com.hanjin.bizcommon.eqorgchart.vo.EQQrgChartListVO;
import com.hanjin.bizcommon.erpcom.jms.basic.SendQueueBC;
import com.hanjin.bizcommon.erpcom.jms.basic.SendQueueBCImpl;
import com.hanjin.bizcommon.exrate.monthly.basic.MonthlyRateBC;
import com.hanjin.bizcommon.exrate.monthly.basic.MonthlyRateBCImpl;
import com.hanjin.bizcommon.exrate.vvd.basic.VVDRateBC;
import com.hanjin.bizcommon.exrate.vvd.basic.VVDRateBCImpl;
import com.hanjin.bizcommon.exrate.vvd.event.ComEns0F1Event;
import com.hanjin.bizcommon.exrate.vvd.vo.VVDListVO;
import com.hanjin.bizcommon.lane.basic.LaneBC;
import com.hanjin.bizcommon.lane.basic.LaneBCImpl;
import com.hanjin.bizcommon.lane.event.ComEns081Event;
import com.hanjin.bizcommon.lane.vo.SearchLaneListVO;
import com.hanjin.bizcommon.leasingcompanyyard.basic.LeasingCompanyYardBC;
import com.hanjin.bizcommon.leasingcompanyyard.basic.LeasingCompanyYardBCImpl;
import com.hanjin.bizcommon.leasingcompanyyard.event.ComCom0004Event;
import com.hanjin.bizcommon.leasingcompanyyard.vo.SearchLeasingCompanyYardListVO;
import com.hanjin.bizcommon.location.basic.LocationBC;
import com.hanjin.bizcommon.location.basic.LocationBCImpl;
import com.hanjin.bizcommon.location.event.ComEns051Event;
import com.hanjin.bizcommon.location.vo.SearchLocationDetailVO;
import com.hanjin.bizcommon.logicsserviceprovider.basic.LogicsServiceProviderBC;
import com.hanjin.bizcommon.logicsserviceprovider.basic.LogicsServiceProviderBCImpl;
import com.hanjin.bizcommon.logicsserviceprovider.event.UiCtm0435Event;
import com.hanjin.bizcommon.logicsserviceprovider.vo.RMdmVenderVO;
import com.hanjin.bizcommon.movement.basic.MovementBC;
import com.hanjin.bizcommon.movement.basic.MovementBCImpl;
import com.hanjin.bizcommon.movement.event.ComCom0010Event;
import com.hanjin.bizcommon.node.basic.NodeBC;
import com.hanjin.bizcommon.node.basic.NodeBCImpl;
import com.hanjin.bizcommon.node.event.ComEns061Event;
import com.hanjin.bizcommon.node.vo.SearchNodeYardListVO;
import com.hanjin.bizcommon.node.vo.SearchNodeZoneListVO;
import com.hanjin.bizcommon.office.basic.OfficeBC;
import com.hanjin.bizcommon.office.basic.OfficeBCImpl;
import com.hanjin.bizcommon.office.event.ComEns071Event;
import com.hanjin.bizcommon.packagetype.basic.PackageTypeBC;
import com.hanjin.bizcommon.packagetype.basic.PackageTypeBCImpl;
import com.hanjin.bizcommon.packagetype.event.UiBkg0696Event;
import com.hanjin.bizcommon.packagetype.vo.PackageTypeVO;
import com.hanjin.bizcommon.paperless.basic.PaperlessBC;
import com.hanjin.bizcommon.paperless.basic.PaperlessBCImpl;
import com.hanjin.bizcommon.paperless.event.ComPpl0001Event;
import com.hanjin.bizcommon.paperless.vo.SearchPaperlessListVO;
import com.hanjin.bizcommon.pertype.basic.PerTypeBC;
import com.hanjin.bizcommon.pertype.basic.PerTypeBCImpl;
import com.hanjin.bizcommon.pertype.event.UiPri4002Event;
import com.hanjin.bizcommon.region.basic.RegionBC;
import com.hanjin.bizcommon.region.basic.RegionBCImpl;
import com.hanjin.bizcommon.region.event.ComEns0J1Event;
import com.hanjin.bizcommon.region.vo.SearchRegionListVO;
import com.hanjin.bizcommon.repcommodity.basic.RepCommodityBC;
import com.hanjin.bizcommon.repcommodity.basic.RepCommodityBCImpl;
import com.hanjin.bizcommon.repcommodity.event.ComEns0K1Event;
import com.hanjin.bizcommon.repcommodity.vo.SearchRepCommodityListVO;
import com.hanjin.bizcommon.revenuevvd.basic.RevenuevvdBC;
import com.hanjin.bizcommon.revenuevvd.basic.RevenuevvdBCImpl;
import com.hanjin.bizcommon.revenuevvd.event.UiComEnsN12Event;
import com.hanjin.bizcommon.scontinent.basic.SubContinentBC;
import com.hanjin.bizcommon.scontinent.basic.SubContinentBCImpl;
import com.hanjin.bizcommon.scontinent.event.ComEns0I1Event;
import com.hanjin.bizcommon.scontinent.vo.SearchSubContinentListVO;
import com.hanjin.bizcommon.serviceprovider.basic.ServiceProviderBC;
import com.hanjin.bizcommon.serviceprovider.basic.ServiceProviderBCImpl;
import com.hanjin.bizcommon.serviceprovider.event.ComEns0C1Event;
import com.hanjin.bizcommon.serviceprovider.vo.SpListVO;
import com.hanjin.bizcommon.servicescope.basic.ServiceScopeBC;
import com.hanjin.bizcommon.servicescope.basic.ServiceScopeBCImpl;
import com.hanjin.bizcommon.servicescope.event.ComEns0L1Event;
import com.hanjin.bizcommon.servicescope.vo.SearchServiceScopeListVO;
import com.hanjin.bizcommon.staff.basic.StaffBC;
import com.hanjin.bizcommon.staff.basic.StaffBCImpl;
import com.hanjin.bizcommon.staff.event.ComEns091Event;
import com.hanjin.bizcommon.state.basic.StateBC;
import com.hanjin.bizcommon.state.basic.StateBCImpl;
import com.hanjin.bizcommon.vessel.basic.VesselBC;
import com.hanjin.bizcommon.vessel.basic.VesselBCImpl;
import com.hanjin.bizcommon.vessel.event.ComEns0A1Event;
import com.hanjin.bizcommon.vesselskd.basic.VesselSKDBC;
import com.hanjin.bizcommon.vesselskd.basic.VesselSKDBCImpl;
import com.hanjin.bizcommon.vvd.basic.VvdBC;
import com.hanjin.bizcommon.vvd.basic.VvdBCImpl;
import com.hanjin.bizcommon.vvd.event.ComEns0B2Event;
import com.hanjin.bizcommon.vvdchart.basic.VVDChartBC;
import com.hanjin.bizcommon.vvdchart.basic.VVDChartBCImpl;
import com.hanjin.bizcommon.vvdchart.event.ComEns0P1Event;
import com.hanjin.bizcommon.vvdchart.vo.VVDChartListVO;
import com.hanjin.bizcommon.cntrtype.basic.CntrTypeBC;
import com.hanjin.bizcommon.cntrtype.basic.CntrTypeBCImpl;
import com.hanjin.bizcommon.cntrsize.basic.CntrSizeBC;
import com.hanjin.bizcommon.cntrsize.basic.CntrSizeBCImpl;
import com.hanjin.framework.component.backend.core.WorkOnLongTxRemoteServerManager;
import com.hanjin.framework.component.backend.support.BackEndJobException;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.irep.enis.FNS0080003Document;
import com.hanjin.syscommon.common.table.ArMstRevVvdVO;
import com.hanjin.syscommon.common.table.ComAproRqstRoutVO;
import com.hanjin.syscommon.common.table.MdmAccountVO;
import com.hanjin.syscommon.common.table.MdmCurrencyVO;
import com.hanjin.syscommon.common.table.MdmMvmtStsVO;
import com.hanjin.syscommon.common.table.PriRatUtVO;
/**
 * ENIS-BIZCOMMON Business Logic ServiceCommand<br>
 * - ENIS-BIZCOMMON에 1대한 비지니스 트랜잭션을 처리한다.<br>
 * @author sangyool pak
 * @see COM_ENS_0A1EventResponse,VesselDBDAO 참조
 * @since J2EE 1.4  
 */


public class BizCommonSC extends ServiceCommandSupport {
	// Login User Information
    private SignOnUserAccount account = null;

    /**
     * BIZCOMMON 업무 시나리오 선행작업<br>
     * Vessel업무 시나리오 호출시 관련 내부객체 생성<br>
     */
    public void doStart() {
        try {
            // 일단 comment --> 로그인 체크 부분
            account=getSignOnUserAccount();            
        } catch (Exception e) {
            log.error("BizCommonSC 선행 작업 시 오류 " + e.toString(), e);
        }
    }

    /**
     * BIZCOMMON 업무 시나리오 마감작업<br>n
     * Vessel업무 시나리오 종료시 관련 내부객체 해제<br>
     */
    public void doEnd() {
        // command.doEnd();
        log.debug("BizCommonSC 종료");
    }

    /**
     * 각 이벤트에 해당하는 업무 시나리오 수행<br>
     * ENIS-BIZCOMMON 업무에서 발생하는 모든 이벤트의 분기처리<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        // RDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = null;
        /*
         * BizCommonSC에 사용법
         * 1. 각각의 업무에 를 통합하는 SC로써 각 업무에 대한 로직은 아래와 같이 작성한다.
         * 2. BC에 대한 각 업무단 BC를 참조하여야 한다. 
         * */
        
        // 1. Commodity(ComEns011Event)
        if (e.getEventName().equalsIgnoreCase("ComEns011Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
            	eventResponse = searchCommodityList(e);
            }
        }
        
        // 2. Contract(ComEns021Event)
        if (e.getEventName().equalsIgnoreCase("ComEns021Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchContractNoList(e);
            }
        }   
        
        // 3. Customer(ComEns041Event)
        if (e.getEventName().equalsIgnoreCase("ComEns041Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchCustomerList(e);
            } 
        }
        // 4. S.Rep(ComEns043Event)
        if (e.getEventName().equalsIgnoreCase("ComEns043Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchSrepList(e);
            } 
        }
 
        // 5. Location(COM_ENS_051)
        if (e.getEventName().equalsIgnoreCase("ComEns051Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchLocationList(e);
            }else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
            	eventResponse = searchLocationDetail(e);
            }
        }
        
        // 6. Node(COM_ENS_061)
        if (e.getEventName().equalsIgnoreCase("COM_ENS_061Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchNodeList(e);
            } 
        }
        
        // 7. Office(COM_ENS_071)
        if (e.getEventName().equalsIgnoreCase("ComEns071Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchOfficeList(e);
            }
        }
        
        // 8. Lane(COM_ENS_081)
        if (e.getEventName().equalsIgnoreCase("ComEns081Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchLaneList(e);
            } 
        }
        
        // 9.Vessel(COM_ENS_0A1)
        if (e.getEventName().equalsIgnoreCase("ComEns0A1Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchVesselList(e);
            }
            eventResponse = searchVesselList(e);
        }
        
        // 10. Vessel SKD 01(COM_ENS_0B1)
        if (e.getEventName().equalsIgnoreCase("ComEns0B1Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchVesselSKDList(e);
            } 
        }        
        
        // 12. Vessel SKD 02(COM_ENS_0B2)
        if (e.getEventName().equalsIgnoreCase("ComEns0B2Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchVvdList(e);
            } 
        } 

        // 12. Service Provider(COM_ENS_0C1)
        if (e.getEventName().equalsIgnoreCase("ComEns0C1Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
              eventResponse = searchServiceProviderList(e);
        	} 
        }
        
        // 13. EQ Organization Chart(COM_ENS_0O1)
        if (e.getEventName().equalsIgnoreCase("ComEns0O1Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchEQOrgChartList(e);
        	} 
        }
        
        // 14. Service Scope(COM_ENS_0L1)
        if (e.getEventName().equalsIgnoreCase("ComEns0L1Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchServiceScopeList(e);
        	} 
        }
        
        // 15. Country(COM_ENS_0M1)
        if (e.getEventName().equalsIgnoreCase("ComEns0M1Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchCountryList(e);
        	} 
        }
        
        // 16. Continent(COM_ENS_0H1)
        if (e.getEventName().equalsIgnoreCase("ComEns0H1Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchContinentList();
        	} 
        }
        
        // 17. Sub Continent(COM_ENS_0I1)
        if (e.getEventName().equalsIgnoreCase("ComEns0I1Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchSubContinentList(e);
        	} 
        }
        
        // 18. Region(COM_ENS_0J1)
        if (e.getEventName().equalsIgnoreCase("ComEns0J1Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchRegionList(e);
        	} 
        }
        
        // 19. Rep Commodity(COM_ENS_0K1)
        if (e.getEventName().equalsIgnoreCase("ComEns0K1Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchRepCommodityList(e);
        	} 
        }
        
        // 20. Carrier(COM_ENS_0N1)
        if (e.getEventName().equalsIgnoreCase("ComEns0N1Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchCarrierList(e);
        	}
        }
        
        // 21. Container Type Size(COM_ENS_0G1)
        if (e.getEventName().equalsIgnoreCase("ComEns0G1Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchCntrTpSzList(e);
        	} 
        }
        
        // 22. VVD Chart(COM_ENS_0P1)
        if (e.getEventName().equalsIgnoreCase("ComEns0P1Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchVVDChartList(e);
        	} 
        }
        
        // 22. Monthly Exchange Rate(COM_ENS_0E1)
        if (e.getEventName().equalsIgnoreCase("COM_ENS_0E1Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchMonthlyRateList(e);
        	} 
        }
        
        // 23. Vvd Exchange Rate(COM_ENS_0F1)
        if (e.getEventName().equalsIgnoreCase("ComEns0F1Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchVvdRateList(e);
        	} 
        }
        
        // 24. Staff 조회(COM_ENS_091)
        if (e.getEventName().equalsIgnoreCase("ComEns091Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchStaffList(e);
        	}
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchDeptList(e);
            }
        }
        
        // 25. 국가별 Local Calendar 조회(COM_ENS_0S1)
        if (e.getEventName().equalsIgnoreCase("ComEns0S1Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
        		eventResponse = searchCntHolidayList(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) { // SAVE 버튼 클릭시
				eventResponse = modifyCntHoliday(e);
        	}
        }
        
        // 26. State별 Local Calendar 조회(COM_ENS_0S2)
        if (e.getEventName().equalsIgnoreCase("COM_ENS_0S2Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
        		eventResponse = searchSteHolidayList(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) { // SAVE 버튼 클릭시
				eventResponse = modifySteHoliday(e);
        	}
        }
        
        // 27. Location별 Local Calendar 조회(COM_ENS_0S3)
        if (e.getEventName().equalsIgnoreCase("COM_ENS_0S3Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
        		eventResponse = searchLocHolidayList(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) { // SAVE 버튼 클릭시
				eventResponse = modifyLocHoliday(e);
        	}
        }
        
        // 28. Country별(by Month) Calendar 조회(COM_ENS_0S3)
        if (e.getEventName().equalsIgnoreCase("COM_ENS_0S4Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
        		eventResponse = searchMonthlyHolidayList(e);
        	}
        }
        
        // 29. State 조회(COM_ENS_0V1)
        if (e.getEventName().equalsIgnoreCase("COM_ENS_0X1Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchStateList(e);
        	}
        }
        
        // 30. Approval Route Manager 팝업(COM_ENS_0T1) - approval
        if (e.getEventName().equalsIgnoreCase("ComEns0T1Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchApprovalStaffList(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchApprovalDeptList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchApprovalRouteList(e);
            } else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
            	// Save as Default 버튼 클릭시 - Approval Route Manager 팝업의  기본결재라인 수정
				eventResponse = saveApprovalRoute(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
        		// OK 버튼 클릭시 - Approval Route Manager 팝업의  결재요청 라우트 수정
				eventResponse = saveApprovalRouteReq(e);
        	} else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
        		// OK 버튼 클릭시 - Default Approval Step 체크 로직
        		// CHM-201534125 심성윤 (2015.04.14)
				eventResponse = checkApprovalRouteReq(e);				
        	}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchApproval(e);
        	}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchCheckApprovedStep(e);	
        	}else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchCheckApprovedCsr(e);
        	}else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchCheckApprovalUserId(e);
        	}
        	/*Authorization 기능 */
        	else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = saveAuthApprovalRoute(e);
        	}else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchAuthApproval(e);
        	}
        }
        
        // 31. Approval 조회(COM_ENS_0U1) - approval
        if (e.getEventName().equalsIgnoreCase("ComEns0U1Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
        		eventResponse = searchApprovalCsrList(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
        		eventResponse = confirmApproval(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
        		eventResponse = rejectApproval(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
        		eventResponse = confirmCheckInv(e);
        	}
			/* BackEndJob 상태조회 */
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchAccrualBackEndJobStatus(e);
			}
			/* Authorization 작업 / Authorization Approval List 조회*/
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchAuthApprovalList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				/* Authorization 작업 / Approve & Confirm */
				log.error("\n>>>>>>>>>>apro,cfm Command02 진입");
				eventResponse = approveAuthApproval(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				/* Authorization 작업 / Disapprove */
				eventResponse = disapproveAuthApproval(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				/* Authorization 작업 / RQST Remark 작성 */
				eventResponse = saveAuthRqstRmk(e);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND50)) {
				eventResponse = searchAuthApproTrsList(e);
			}
        	
        }
        
        // 31. Approval Inquiry 조회(COM_ENS_0U2) - Approval Inquiry
        if (e.getEventName().equalsIgnoreCase("ComEns0U2Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
        		eventResponse = searchApprovalInqueryCsrList(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchRhqOfcCdList(e);	
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
        		eventResponse = searchRhqOffice(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
        		eventResponse = searchOfcCdList(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
        		eventResponse = searchOfcCdListByRhq(e);	
        	}else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
        		eventResponse = searchAuthSubSysCdList(e);	
        	}else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
        		eventResponse = searchAuthPgmNmList(e);	
        	}else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
        		eventResponse = searchAuthAproInquiry(e);	
        	}else if (e.getFormCommand().isCommand(FormCommand.COMMAND50)) {
        		eventResponse = searchAuthAproTrsInquiry(e);	
        	}
        	
        }
        
        // 32. UnApproved 조회(COM_ENS_0Y1) - approval
        if (e.getEventName().equalsIgnoreCase("ComEns0Y1Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
        		eventResponse = searchUnApprovalCsrList(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchARRHQOfficeList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSelOfficeList(e);
			}
        	
        }
        
        // 33. Approval Step 조회(COM_ENS_0W1) - approval
        if (e.getEventName().equalsIgnoreCase("ComEns0W1Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchApprovalStepList(e);
        	}
        }

        // 34. Per Type 조회(UI_PRI_4002)
		if(e.getEventName().equalsIgnoreCase("UiPri4002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPertypeList(e);
			}
		}

        // 35. Account Code 조회(COM_ENS_N11) Suk Jun Kim 2009.04.22
        if (e.getEventName().equalsIgnoreCase("ComEnsN11Event")) {
        	log.debug("ComEnsN11Event");
        	log.debug("e.getFormCommand() : "+Integer.toString(e.getFormCommand().getCommand()));
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		log.debug("Command.SEARCH");
        		eventResponse = searchAccountList(e);
        	}
        }

        // 36. Currency Code 조회(COM_ENS_N13) Eui-su Park 2009.04.22
        if (e.getEventName().equalsIgnoreCase("ComEnsN13Event")) {
        	log.debug("ComEnsN13Event");
        	log.debug("e.getFormCommand() : "+Integer.toString(e.getFormCommand().getCommand()));
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		log.debug("Command.SEARCH");
        		eventResponse = searchCurrencyList(e);
        	}
        }

        // 37. PackageType 조회(COM_BKG_0696) Ji Seok Woo 2009.04.24
        if (e.getEventName().equalsIgnoreCase("UiBkg0696Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		log.debug("Command.SEARCH");
        		eventResponse = searchPackageTypeList(e);
        	}
        }

        // 38. LogicsServiceProvider 조회(UI_CTM_0435) Ji Seok Woo 2009.04.24
		if (e.getEventName().equalsIgnoreCase("UiCtm0435Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLogicsServiceProvider(e);
			}
		}
		
		//Revenue VVD 
		if (e.getEventName().equalsIgnoreCase("UiComEnsN12Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRevenueVVDList(e);
			}
		}
		
		//Agreement Notice User Management
		if (e.getEventName().equalsIgnoreCase("ComNtc0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMailingList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSystemName(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchOfficeLevel(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchUserName(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchOfficeValid(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageMailingList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = checkAgreementNoValid(e);
			}
		}
		
		//Contract Creation Users 
		if (e.getEventName().equalsIgnoreCase("ComNtc0002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchContractCreationUser(e);
			}
		}
		
		//Notice 대상 검색   
		if (e.getEventName().equalsIgnoreCase("ComNtc0003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchNoticeUser(e);
			}
		}
		
		//Agreement Notice List 조회   
		if (e.getEventName().equalsIgnoreCase("ComNtc0004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAgreementList(e);
			}
		}
		
		//Paperless List 議고쉶(COM_PPL_0001)   
		if (e.getEventName().equalsIgnoreCase("ComPpl0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPaperlessList(e);
			}
		}	
		//Leasing Company yard 조회(COM_COM_0004) KIM MIN SOO 2012.02.21 
		if (e.getEventName().equalsIgnoreCase("ComCom0004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchLeasingCompanyYardList(e);
			}
		}
		
        // DST Code Pop-up (COM_COM_0005) Junbum Lee 2012.02.22
        if (e.getEventName().equalsIgnoreCase("ComCom0005Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchDaylightSavingTimeList(e);
        	}
        }
        //Center Code Inquiry
        if (e.getEventName().equalsIgnoreCase("ComCom0440Event")) {
        	
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPopCenterList(e);
			}
		}

        // Movement Status Code 조회(COM_COM_0010) KIM JONG OCK 2012.02.20 
        if (e.getEventName().equalsIgnoreCase("ComCom0010Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchMovementStatusList(e);
        		//searchAccountList(e);Movement Status
        	}
        }
        
        // Activity Code 조회(COM_COM_0009) Sangbo La 2012.02.20 
        if (e.getEventName().equalsIgnoreCase("ComCom0009Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchActivityList(e);
        		//searchAccountList(e);Movement Status
        	}
        }
        
        // Container Type
        if (e.getEventName().equalsIgnoreCase("ComCom0002Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchMdmCntrTpList(e);
        	}
        }		
			
        // Container Size
        if (e.getEventName().equalsIgnoreCase("ComCom0003Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchMdmCntrSzList(e);
        	}
        } 
        
        return eventResponse;
    }
    
//approval-[--------------------------------------------------------------------------------------------------------------
    /**
     * 승인자 리스트 조회 이벤트 처리<br>
     * Approval Staff 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchApprovalStaffList(Event e) throws EventException { 
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComEns0T1Event event = (ComEns0T1Event)e;
    	ApprovalBC command = new ApprovalBCImpl();
    	
    	try{
    		List<ApprovalStaffVO> approvalStaffVOs = command.searchStaffList(event.getApprovalStaffVO());
    		eventResponse.setRsVoList(approvalStaffVOs);
		}catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval Staff List"}).getMessage(), ex);
		}
        
		return eventResponse;
    }
    
    /**
     * 부서 리스트 조회 이벤트 처리<br>
     * Approval Dept 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchApprovalDeptList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComEns0T1Event event = (ComEns0T1Event)e;
    	ApprovalBC command = new ApprovalBCImpl();
    	
        try {
        	List<ApprovalDeptVO>  approvalDeptVOs = command.searchDeptList(event.getApprovalStaffVO(), account);
        	eventResponse.setRsVoList(approvalDeptVOs);
        }catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval Department List"}).getMessage(), ex);
		}
        
        return eventResponse; 
    }
    
    /**
     * 결제라인 리스트 조회 이벤트 처리<br>
     * Approval Route 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchApprovalRouteList(Event e) throws EventException { 
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComEns0T1Event event = (ComEns0T1Event)e;
    	ApprovalBC command = new ApprovalBCImpl();
    	
    	try {
        	List<ApprovalRouteVO>  approvalRouteVOs = command.searchApprovalRouteList(event.getApprovalStaffVO());
        	eventResponse.setRsVoList(approvalRouteVOs);
        }catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval Route List"}).getMessage(), ex);
		}

        return eventResponse;
    }
    
    /**
	 * 저장 이벤트 처리<br>
	 * Approval Route 화면에 대한 저장 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/
	private EventResponse saveApprovalRoute(Event e) throws EventException { 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComEns0T1Event event = (ComEns0T1Event)e;
    	ApprovalBC command = new ApprovalBCImpl();
    	
    	try{
			begin();
			command.saveApprovalRoute(event.getApprovalStaffVO(), event.getApprovalRouteVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Data"}).getUserMessage());
			commit();			
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Approval Route"}).getMessage(), ex);
		}
        
		return eventResponse;
	}
	
	/**
	 * 저장 이벤트 처리<br>
	 * Approval Route 화면에 대한 저장 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/
	private EventResponse saveAuthApprovalRoute(Event e) throws EventException { 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComEns0T1Event event = (ComEns0T1Event)e;
    	ApprovalBC command = new ApprovalBCImpl();
    	
    	try{
			begin();
			command.saveAuthApprovalRoute(event.getAuthAproStaffVO(), event.getSearchAuthAproVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Data"}).getUserMessage());
			commit();			
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Approval Route"}).getMessage(), ex);
		}
        
		return eventResponse;
	}
	
	/**
	 * 저장 이벤트 처리<br>
	 * Approval Route 화면에 대한 저장 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/
	private EventResponse saveApprovalRouteReq(Event e) throws EventException { 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComEns0T1Event event = (ComEns0T1Event)e;
    	ApprovalBC command = new ApprovalBCImpl();
    	
    	try{
			begin();
			command.saveApprovalRouteReq(event.getApprovalCsrVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Data"}).getUserMessage());
			commit();			
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Approval Route"}).getMessage(), ex);
		}
        
		return eventResponse;
	}
	
	
	
	/**
	 * 결재라인 검색<br>
	 * 결재라인 지정 시 디폴트 값 확인 <br>
	 * CHM-201534125 심성윤 (2015.04.14) 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/
	private EventResponse checkApprovalRouteReq(Event e) throws EventException { 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComEns0T1Event event = (ComEns0T1Event)e;
    	ApprovalBC command = new ApprovalBCImpl();
    	String retval = "";
    	try{
			begin();
			retval = command.checkApprovalRouteReq(event.getApprovalCsrVO(), account);
			eventResponse.setETCData("APRO_STEP_DEF_YN", retval);
			log.error("\n"+ "    >>>>>>>>>>  "+retval+"   <<<<<<<<<<");
			eventResponse.setUserMessage(new ErrorHandler("COM12191", new String[]{"Data"}).getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Approval Route"}).getMessage(), ex);
		}
        
		return eventResponse;
	}
	
	/**
     * 조회 이벤트 처리<br>
     * 부서모듈 사용자별 기본결재라인(COM_APRO_ROUT_DFLT_DTL) 목록을 조회합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchApproval(Event e) throws EventException { 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComEns0T1Event event = (ComEns0T1Event)e;
    	ApprovalBC command = new ApprovalBCImpl();
    	
		try {
			List<SearchApprovalVO>  searchApprovalVOs = command.searchApproval(event.getApprovalStaffVO());
        	eventResponse.setRsVoList(searchApprovalVOs);			
		} catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Approval List"}).getMessage(), ex);
		}
		
		return eventResponse; 
	}

	
	/**
     * 조회 이벤트 처리<br>
     * 부서모듈 사용자별 기본Auth결재라인(COM_AUTH_APRO_DFLT_ROUT_USR) 목록을 조회합니다.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchAuthApproval(Event e) throws EventException { 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComEns0T1Event event = (ComEns0T1Event)e;
    	ApprovalBC command = new ApprovalBCImpl();
    	
		try {
			List<AuthAproStaffVO>  authAproStaffVOs = command.searchAuthApproval(event.getAuthAproStaffVO());
        	eventResponse.setRsVoList(authAproStaffVOs);			
		} catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Approval List"}).getMessage(), ex);
		}
		
		return eventResponse; 
	}
    
    /**
     * 조회 이벤트 처리<br>
     * Approval CSR 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     * @author HyungChoon Roh
     * @date 2006.08.07
     */
    private EventResponse searchApprovalCsrList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComEns0U1Event event = (ComEns0U1Event)e;
    	ApprovalBC command = new ApprovalBCImpl();
    	
        try {
        	List<ApprovalCsrVO>  approvalCsrVOs = command.searchApprovalCsrList(event.getApprovalStaffVO(), account);
        	eventResponse.setRsVoList(approvalCsrVOs);
        } catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval Csr List"}).getMessage(), ex);
		}
        
        return eventResponse;
    }
    
    /**
     * 조회 이벤트처리 <br>
     * COM_ENS_0U1 Authorization <br>
     * 
     * @param e
     * @return eventResponse
     * @throws EventException
     */
    private EventResponse searchAuthApprovalList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComEns0U1Event event = (ComEns0U1Event)e;
    	ApprovalBC command = new ApprovalBCImpl();
    	
        try {
        	List<AuthorizationAproVO>  authorizationAproVOs = command.searchAuthApprovalList(event.getAuthorizationAproVO(), account);
        	eventResponse.setRsVoList(authorizationAproVOs);
        } catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval Csr List"}).getMessage(), ex);
		}
        
        return eventResponse;
    }
    
    
    
    /**
     * 조회 이벤트 처리<br>
     * Approval Inquery 화면에 RHQ OFFICE CODE, OFFICE TYPE CODE 조회<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     * @author SHIN DONG IL
     * @date 2014.01.02
     */
    private EventResponse searchRhqOffice(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComEns0U2Event event = (ComEns0U2Event)e;
    	ApprovalBC command = new ApprovalBCImpl();
    	String rhq_ofc_cd ="";
    	String ofc_tp_cd = "";
    	
        try {
        	rhq_ofc_cd = command.searchRhqOfcCdByOfcCd(event.getSignOnUserAccount().getOfc_cd());
        	ofc_tp_cd = command.searchOfcTpCd(event.getSignOnUserAccount().getOfc_cd());
        	eventResponse.setETCData("rhq_ofc_cd",rhq_ofc_cd);
        	eventResponse.setETCData("ofc_tp_cd",ofc_tp_cd);
        } catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search RHQ Office"}).getMessage(), ex);
		}
        
        return eventResponse;
    }
    /**
     * 조회 이벤트 처리<br>
     * Approval Inquery 화면에 OFFICE COMBO CODE LIST조회<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     * @author SHIN DONG IL
     * @date 2014.01.02
     */
    private EventResponse searchRhqOfcCdList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
//    	ComEns0U2Event event = (ComEns0U2Event)e;
    	ApprovalBC command = new ApprovalBCImpl();
    	
    	String ofc_cd_list = "";
    	
        try {
        	ofc_cd_list = command.searchRhqOfcCdList();
        	
        	if(ofc_cd_list.length() > 0 ){
        		ofc_cd_list = ofc_cd_list.substring(0, ofc_cd_list.length()-1);
        	}
        	eventResponse.setETCData("rhq_ofc_cd_list",ofc_cd_list);
        	
        } catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search RHQ Office"}).getMessage(), ex);
		}
        
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Approval Inquery 화면에 OFFICE COMBO CODE LIST조회<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     * @author SHIN DONG IL
     * @date 2014.01.02
     */
    private EventResponse searchOfcCdList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComEns0U2Event event = (ComEns0U2Event)e;
    	ApprovalBC command = new ApprovalBCImpl();
    	
    	String ofc_cd_list = "";
    	
        try {
        	ofc_cd_list = command.searchOfcCdList(event.getSignOnUserAccount().getOfc_cd());
        	
        	if(ofc_cd_list.length() > 0 ){
        		ofc_cd_list = ofc_cd_list.substring(0, ofc_cd_list.length()-1);
        	}
        	eventResponse.setETCData("ofc_cd_list",ofc_cd_list);
        	
        } catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search RHQ Office"}).getMessage(), ex);
		}
        
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Approval Inquery 화면에서 RHQ콤보 변경시 OFFICE COMBO CODE LIST조회<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     * @author SHIN DONG IL
     * @date 2014.01.02
     */
    private EventResponse searchOfcCdListByRhq(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComEns0U2Event event = (ComEns0U2Event)e;
    	ApprovalBC command = new ApprovalBCImpl();
    	
    	String ofc_cd_list = "";
    	
        try {
        	ofc_cd_list = command.searchOfcCdListByRhq(event.getApprovalInqueryCondtionVO().getRhqOfcCd());
        	
        	if(ofc_cd_list.length() > 0 ){
        		ofc_cd_list = ofc_cd_list.substring(0, ofc_cd_list.length()-1);
        	}
        	eventResponse.setETCData("ofc_cd_list",ofc_cd_list);
        	
        } catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search RHQ Office"}).getMessage(), ex);
		}
        
        return eventResponse;
    }
    
    
    /**
     * 조회 이벤트 처리<br>
     * Authorization Inquiry 화면에서 MODULE CODE LIST조회<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     * @author Sung Yoon SHIM
     * @date 2015.07.15
     */
    private EventResponse searchAuthSubSysCdList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComEns0U2Event event = (ComEns0U2Event)e;
    	ApprovalBC command = new ApprovalBCImpl();
        try {
        	List<AuthorizationInquiryVO> list= command.searchAuthSubSysCdList(event.getAuthorizationInquiryVO());
        	eventResponse.setRsVoList(list);
        } catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search RHQ Office"}).getMessage(), ex);
		}
        
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Authorization Inquiry 화면에서 PROGRAM LIST조회<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     * @author Sung Yoon SHIM
     * @date 2015.07.15
     */
    private EventResponse searchAuthPgmNmList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComEns0U2Event event = (ComEns0U2Event)e;
    	ApprovalBC command = new ApprovalBCImpl();
    	
    	
        try {
        	List<AuthorizationInquiryVO> list= command.searchAuthPgmNmList(event.getAuthorizationInquiryVO());
        	eventResponse.setRsVoList(list);
        } catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search RHQ Office"}).getMessage(), ex);
		}
        
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Authorization Inquiry 화면에서 PROGRAM LIST조회<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     * @author Sung Yoon SHIM
     * @date 2015.07.15
     */
    private EventResponse searchAuthAproInquiry(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComEns0U2Event event = (ComEns0U2Event)e;
    	ApprovalBC command = new ApprovalBCImpl();
    	
        try {
        	List<AuthorizationInquiryVO> list= command.searchAuthAproInquiry(event.getAuthorizationInquiryVO());
        	eventResponse.setRsVoList(list);
        } catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search RHQ Office"}).getMessage(), ex);
		}
        
        return eventResponse;
    }
    
	/**
	 * 조회 이벤트 처리<br>
	 * Authorization Approval Inquiry 화면에 대한 TRS 용 조회 이벤트 처리<br>
	 * COM_ENS_0U2
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuthAproTrsInquiry(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		ComEns0U2Event event = (ComEns0U2Event)e;
		
		try {
			WorkOrderInquiryBC command = new WorkOrderInquiryBCImpl();
			eventResponse = command.searchAuthAproTrsInquiry(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
    
    
    /**
     * 조회 이벤트 처리<br>
     * Approval Inquery 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     * @author SHIN DONG IL
     * @date 2014.01.02
     */
    private EventResponse searchApprovalInqueryCsrList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComEns0U2Event event = (ComEns0U2Event)e;
    	ApprovalBC command = new ApprovalBCImpl();
    	
        try {
        	List<ApprovalInqueryVO>  approvalInqueryVOs = command.searchApprovalInqueryCsrList(event.getApprovalInqueryCondtionVO(), account);
        	eventResponse.setRsVoList(approvalInqueryVOs);
        } catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval Inquery Csr List"}).getMessage(), ex);
		}
        
        return eventResponse;
    }
    
    /**
	 * 저장 이벤트 처리 <br>
	 * Approval Confirm 저장 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/
	private EventResponse confirmApproval(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// Validation Check 부분 제거 2014.12.04
		//ApprovalBC command = new ApprovalBCImpl();
		try{
			confirmCheckInv(e);
			WorkOnLongTxRemoteServerManager mng = new WorkOnLongTxRemoteServerManager();
			
			//Validation Check start
//			ComEns0U1Event event = (ComEns0U1Event)e;
//			ApprovalCsrVO[] approvalCsrVOs = null;
//	    	ApprovalCsrVO approvalCsrVO = null;
	    	
//			approvalCsrVOs = event.getApprovalCsrVOS();
//			if(approvalCsrVOs != null) {
//				String module = "";
//
//        		for (int i=0; i<approvalCsrVOs.length; i++) {
//        			//결재 선택 건 체크 (ibflag = 'U')
//        			if("U".equals(approvalCsrVOs[i].getIbflag())) {
//        				//1) Approval화면에서 선택한 결재대상 기본정보
//        				approvalCsrVO = approvalCsrVOs[i];
//        				
//        				module = approvalCsrVO.getSubSysCd();
//        				
//        				if(module.equals("JOO")){
//        					log.info("confirmApproval() module : "+module);
//        					// TO DO
//        				}else if(module.equals("FMS")){
//        					log.info("confirmApproval() module : "+module);
//        					// TO DO
//        				}else{
//	    					//2) 현 결재자 정보를 조회한다 - Web Service 연동 싱크
//	            			ComAproRqstRoutVO rout = command.searchApprovalCurCsrRoute(approvalCsrVO);
//	            			
//	            			//승인자가 결재라인에 있는지 확인한다.(Start)
//	            			String sAproUsrId = rout!=null?JSPUtil.getNull(rout.getAproUsrId()):"";
//	            			String sLoginUsrId = e!=null&&e.getSignOnUserAccount()!=null?JSPUtil.getNull(e.getSignOnUserAccount().getUsr_id()):"";
//	                         //Approval Step의 Usr Id를 EP ID를 사용할 경우 확인
//	            			String comUsrId = command.searchAproUsrId(sLoginUsrId);
//	            			
//	            			log.error("\n ---------------------------------------------- \n"
//	            					+ "\n - BizCommonSC.confirmApproval() -->> " 
//	            					+ "\n - csr_no:"+(approvalCsrVO!=null?JSPUtil.getNull(approvalCsrVO.getCsrNo()):"")
//	            					+ "\n - sAproUsrId:"+JSPUtil.getNull(sAproUsrId)
//	            					+ "\n - sLoginUsrId:"+JSPUtil.getNull(sLoginUsrId)
//	            					+ "\n - comUsrId:"+JSPUtil.getNull(comUsrId)
//	            					+ "\n ---------------------------------------------- \n");
//	            			
//	            			if(!sAproUsrId.equals("")&&!comUsrId.equals("")){
//	            				if(!sAproUsrId.equals(comUsrId)){
//	            					eventResponse.setUserMessage(new ErrorHandler("CSR10021").getUserMessage());
//	            					throw new EventException((new ErrorHandler("CSR10021", new String[]{approvalCsrVO.getCsrNo()}).getMessage())); 
//	            				}
//	            			}else{
//	            				eventResponse.setUserMessage(new ErrorHandler("COM12240").getUserMessage());
//	            				throw new EventException((new ErrorHandler("COM12240", new String[]{approvalCsrVO.getCsrNo()}).getMessage())); 
//	            			}
//	            			//승인자가 결재라인에 있는지 확인한다.(End)
//        				}
//        			}
//        		}
//			}
			//Validation Check end
			
			//WorkOnRemoteLongTxServer 호출
			String tkKey = mng.execute("com.hanjin.bizcommon.BizCommonSC", "confirmApprovalRemoteServer", e,  e.getSignOnUserAccount().getUsr_id(), "BizCommonSC-confirmApproval");
			
			eventResponse.setETCData("key", tkKey);
		}catch(EventException ex){
			rollback();
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        rollback();
	        throw new EventException(new ErrorHandler("COM12192", new String[]{"Confirm Approval"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
    
    /**
	 * 조회 이벤트 처리 <br>
	 * Approve 버튼 클릭시 Invoice 존재여부 체크<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/
	public EventResponse confirmCheckInv(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ComEns0U1Event event = (ComEns0U1Event)e;
		ApprovalBC command = new ApprovalBCImpl();
		try{
			ApprovalCsrVO[] approvalCsrVOs = null;
	    	ApprovalCsrVO approvalCsrVO = null;
			approvalCsrVOs = event.getApprovalCsrVOS();
			if(approvalCsrVOs != null) {
				String module = "";
				for (int i=0; i<approvalCsrVOs.length; i++) {
					if("U".equals(approvalCsrVOs[i].getIbflag())) {
						approvalCsrVO = approvalCsrVOs[i];
						module = approvalCsrVO.getSubSysCd();
						if("TRS".equals(module)) {
							boolean invoiceCheck = command.searchInvoice(approvalCsrVO);
							if(invoiceCheck){
								throw new EventException(new ErrorHandler("CSR10004").getMessage()); 
							}
						}
					}
				}
			}

		}catch(EventException ex){
			rollback();
			throw new EventException(ex.getMessage());
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        rollback();
	        throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
    /**
	 * 저장 이벤트 처리<br>
	 * Approval Confirm 화면에 대한 저장 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/
	public EventResponse confirmApprovalRemoteServer(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComEns0U1Event event = (ComEns0U1Event)e;
    	ApprovalBC command = new ApprovalBCImpl();
    	
    	//비동기 CSR
		AGTAuditBC agtCommand = new AGTAuditBCImpl();
		AGNCommApprovalBC acmCommand = new AGNCommApprovalBCImpl();
		CARIssueTransferSlipManageBC tesCommand = new CARIssueTransferSlipManageBCImpl();
 		CSRIssueTransferSlipManageBC trsCommand = new CSRIssueTransferSlipManageBCImpl();
		ConsultationSlipRequestMgtBC csrCommand = new ConsultationSlipRequestMgtBCImpl();
		TCharterIOConsultationBC     fmsCommand = new TCharterIOConsultationBCImpl();
		//JointOperationConsultationBC jooCommand = new JointOperationConsultationBCImpl();
		
		ApprovalCsrVO[] approvalCsrVOs = null;
    	ApprovalCsrVO approvalCsrVO = null;
    	String chk_curr_apro_usr_yn = null;
		
		try{			
			
			approvalCsrVOs = event.getApprovalCsrVOS();
			if(approvalCsrVOs != null) {
				String module = "";
				String csrNo  = "";
        		for (int i=0; i<approvalCsrVOs.length; i++) {
        			//결재 선택 건 체크 (ibflag = 'U')
        			if("U".equals(approvalCsrVOs[i].getIbflag())) {
        				
        				begin();
        				
        				//1) Approval화면에서 선택한 결재대상 기본정보
        				approvalCsrVO = approvalCsrVOs[i];
        				
        				chk_curr_apro_usr_yn = approvalCsrVO!=null?(new ApprovalUtil().checkCurrentApprovalUserYN(JSPUtil.getNull(approvalCsrVO.getCsrNo()),e.getSignOnUserAccount().getUsr_id())):"";
        				log.error("\n\n BIZCOMMSC.confirmApprovalRemoteServer - CSRNO : "+ (approvalCsrVO!=null?JSPUtil.getNull(approvalCsrVO.getCsrNo()):"") + " - usrid : " + e.getSignOnUserAccount().getUsr_id() +" - chk_curr_apro_usr_yn : " +  JSPUtil.getNull(chk_curr_apro_usr_yn) + " <<<<< \n\n");
        				
        				if (chk_curr_apro_usr_yn!=null && chk_curr_apro_usr_yn.trim().equals("Y")){
            				module = approvalCsrVO.getSubSysCd();
            				//2) 현 결재자 정보를 조회한다 - Web Service 연동 싱크
                			ComAproRqstRoutVO rout = command.searchApprovalCurCsrRoute(approvalCsrVO);

                			/**
                			 * 현재 결재자의 후결 여부를 먼저 AP_INV_HDR에 update 한다.
                			 * 후결의 경우에는 최종결재 바로 전에서만 결재완료처리 및 A/P로 I/F한다. 
                			 * -> 10만불 3차 후결기능 사용 안한다.
                			 */
                			//command.modifyUrgentPayment(approvalCsrVO);
                			
                			/**
                			 * AP_INV_HDR를 통해서 후결 처리하는 단계가 맞는지 확인한다.
                			 * - 1차에서는 PDT님 바로 앞단계에서만 결재완료 및 A/P I/F를 한다.
                			 * - 2차에서는 현업의 요구사항으로 후결표시를 하는 순간 바로 그 단계에서 나머지 뒤의 모든 결재단계를 완료처리하면서 바로 A/P I/F한다.
                			 * -> 10만불 3차 후결기능 사용 안한다.
                			 */
                			//boolean bUrgPay = command.chkUrgPayFlgAproRout(approvalCsrVO);  
                			
                			
                			//3) 최종 결재 여부를 체크한다 - 최종 결재시에만 CSR AP전송
        	    			boolean bComplete = command.searchLastApprovalRoute(approvalCsrVO);  // COM_APRO_RQST_ROUT를 통해서 최종결재자 여부 : bComplete가 TRUE의 의미는 결재완료되었다는 야그 
        	    			log.error("\n\n ## BIZCOMMSC.confirmApprovalRemoteServer -- "
        	    						+ " / usr_id : " + (e!=null&&e.getSignOnUserAccount()!=null?JSPUtil.getNull(e.getSignOnUserAccount().getUsr_id()):"")
        	    						+ " / csr_no : " + (approvalCsrVO!=null?JSPUtil.getNull(approvalCsrVO.getCsrNo()):"")
    									+ " / bComplete : " + JSPUtil.getNull(bComplete) 
    									//+ " / bUrgPay : " + JSPUtil.getNull(bUrgPay)
    									+ " / aproRqstSeq : " + (approvalCsrVO!=null?JSPUtil.getNull(approvalCsrVO.getAproRqstSeq()):"")
        	    						+ " <<<<<<<<<<<<<<< \n\n");
        	    			;
        	    			
        	    			//if (bUrgPay){
        	    			//	bComplete = bUrgPay; //후결이면 완료처리하고 넘어간다.
        	    			//}
        	    			
        	    			//4) 결재요청헤더의 결재상태 완료 여부 파악 - 완료된 건 중복 결재 피하기 위함
        	    			boolean bAppComplete = command.searchApprovalCompletion(approvalCsrVO); // COM_APRO_RQST_HDR의 apro_sts를 보고 완료 여부를 확인
        	    			if(bAppComplete) {
        	    				throw new EventException((new ErrorHandler("CSR00084", new String[]{approvalCsrVO.getCsrNo()}).getMessage())); 
        	    			}
        	    			
        	    			log.error("\n\n FMS 바로 전 ++++++++++++++++++   \n\n");
        	    			
        	    			//5) 결재
        	    			//5-1) 결재 Update 수행 (Header & Route 정보)
        	    			command.confirmApproval(approvalCsrVO, e.getSignOnUserAccount());
        	    			//5-2) CSR 결재완료시, 각 모듈별 Update 수행 (TES/TRS/AGT/ACM/CSR)
        	    			if("FMS".equals(module)){
            	    			if(bComplete) {
            	    				if("FMS".equals(module)){
            	    					csrNo = approvalCsrVO.getCsrNo();
            	    					log.debug("Call >>> fmsCommand.manageApproveFMS(...) " + csrNo);
            	    					fmsCommand.manageApproveFMS(e.getSignOnUserAccount().getUsr_id(), csrNo, e.getSignOnUserAccount().getOfc_cd());
            	    				}
            	    			}	
        	    			} else {
            	    			if(bComplete) { 	
            	    				csrNo  = approvalCsrVO.getCsrNo();
            	    				
            	    				//ERP IF 하기전에 ASA No가 close 상태이면 그다음 open 되어 있는 ASA NO로 업데이트  2017-04-20
            	    				log.error("\n\n ASA NO Check Start   \n\n");
            	    				command.checkAsaNo(csrNo);
            	    				log.error("\n\n ASA NO Check End    \n\n");
            	    				
            	    				if("TRS".equals(module)) {
            	    					trsCommand.approvalRequestAccount2("C", csrNo, rout);
            	    				} else if("TES".equals(module)) {
            	    					tesCommand.approvalRequestAccount2("C", csrNo, rout);
            	    				} else if("AGT".equals(module)){
            	    					agtCommand.transferAgentActualINFtoAP2("C", csrNo, rout);
            	    				} else if("ACM".equals(module)){
            	    					acmCommand.transferAgentActualINFtoAP2("C", csrNo, rout );
            	    				}
            	    				/* else if("MNR".equals(module) || "TLL".equals(module) || "LSE".equals(module) || "PSO".equals(module) || "CHS".equals(module) || "MGS".equals(module)) {
            	    					csrCommand.approvalRequestAccount2("C", approvalCsrVO.getCsrNo(), rout);
            	    				}*/
            	    			}
            	    			// 7) CSR 결재완료시, ERP Interface 수행
            	    			FNS0080003Document[] docReq = null;
            	    			if(bComplete) {
            	    				String ofcCd = event.getSignOnUserAccount().getOfc_cd();
            	    				
            	    				if("AGT".equals(module)) {
            	    					docReq = agtCommand.transferAgentActualINFtoAP1("C", csrNo, rout);
            	    				} else if("ACM".equals(module)) {
            	    					docReq = acmCommand.transferAgentActualINFtoAP1("C", csrNo, rout);
            	    				} else if("TES".equals(module)) {
            	    					docReq = tesCommand.approvalRequestAccount1("C", csrNo, rout);
            	    				} else if("TRS".equals(module)) {
            	    					docReq = trsCommand.approvalRequestAccount1("C", csrNo, rout);	
            	    				} else if("MNR".equals(module) || "TLL".equals(module) || "LSE".equals(module) || "PSO".equals(module) || "CHS".equals(module) || "MGS".equals(module) || "CNI".equals(module)) {
            	    					//AP I/F 수행할 CSR 데이타를 웹서비스를 위한 표준규격(XML Schema) 을 적용한 XML문서로 변환
            	    					docReq = csrCommand.approvalRequestAccount1("C", csrNo, ofcCd, rout);
            	    				}
            	    				
            	    				//invoice 정산내역을 ERP AP로 인터페이스한다.
            	    				transferInvToERP(docReq, approvalCsrVO);       		    				
            	    				//BIZ스레드처리후 Exception 없다면 비동기(Biz) 커밋 :: Approval 결재 처리    	    				
            	    			}        					
        	    			}        					
        				}
    	    			commit();
        			}
        		}
			}
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Confirm Approval"}).getMessage(), ex);
		}
        
    	return eventResponse;		
	}
	
	
	/**
	 * 저장 이벤트 처리 <br>
	 * Authorization  Disapprove(before) 저장 이벤트 처리<br>
	 * COM_ENS_0U1
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/
	private EventResponse disapproveAuthApproval(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ComEns0U1Event event = (ComEns0U1Event)e;
		String usrId = JSPUtil.getNull(event.getSignOnUserAccount().getUsr_id());
		ApprovalBC command = new ApprovalBCImpl();
		String chkXlsApro = "";
		String authEmlSndNoSeq = "";
		String authAproRqstNo = "";
		
		AuthorizationApprovalUtil authorizationApprovalUtil = new AuthorizationApprovalUtil();
		try{
			AuthorizationAproVO authorizationAproVO = null;			
			authorizationAproVO = event.getAuthorizationAproVO();
			authorizationAproVO.setUsrId(usrId);
			AuthEmlSndVO emlSndVO = null;
			authAproRqstNo = authorizationAproVO.getAuthAproRqstNo();
			String snd_no = "";
			
			//액셀 결재인지 확인
			chkXlsApro = authorizationApprovalUtil.checkXlsApproval(authAproRqstNo);
			
			log.error("\n>>>>>>>>>>>>액셀결제확인>>>>>chkXlsApro>>>"+chkXlsApro+"<<<<<<<<");
			
			if(authorizationAproVO != null) {				
					if("U".equals(authorizationAproVO.getIbflag())) {
												
						//Rout Update
						command.updateAuthDisaproRout(authorizationAproVO);
						
						//Disapprove
						command.disaproAuthApproval(authorizationAproVO);
						
						if("EXCEL_DOWN_DUMMY".equals(chkXlsApro)){
							begin();
							//E-mail 시퀀스 채번
							authEmlSndNoSeq = authorizationApprovalUtil.searchAuthEmlSndSeq();
							//이메일 컨텐츠 준비
							emlSndVO = authorizationApprovalUtil.authRdyToSndEml(authAproRqstNo, authEmlSndNoSeq, account, "R");
							commit();
							
							//이메일 발송
							snd_no = JSPUtil.getNull(authorizationApprovalUtil.authSndEml(emlSndVO));
							log.error("\n\n>>>>>>>>>>>Eml_Snd_No>>>>>"+snd_no+"<<<<<<<<<\n\n");
							emlSndVO.setEmlSndNo(snd_no);
							
							begin();
							//E-mail 성공 여부 Update
							authorizationApprovalUtil.updateAuthEmlSndSuccess(emlSndVO);
							commit();
						}
						
					}
			}			
			 
		}catch(EventException ex){
			rollback();
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        rollback();
	        throw new EventException(new ErrorHandler("COM12192", new String[]{"Confirm Approval"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 저장 이벤트 처리 <br>
	 * Authorization  RQST Rmk 저장 이벤트 처리<br>
	 * COM_ENS_0U1
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/
	private EventResponse saveAuthRqstRmk(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ComEns0U1Event event = (ComEns0U1Event)e;
		ApprovalBC command = new ApprovalBCImpl();
		String usrId = JSPUtil.getNull(event.getSignOnUserAccount().getUsr_id());
		try{
			log.error("\n>>>>>>>>>>authaprkrmk sc 진입");
			AuthorizationAproVO[] authorizationAproVOs = null;		
			authorizationAproVOs = event.getAuthorizationAproVOS();
			
			begin();
			if(authorizationAproVOs != null) {
				for (int i=0; i<authorizationAproVOs.length; i++) {
					if("U".equals(authorizationAproVOs[i].getIbflag())) {
						authorizationAproVOs[i].setUsrId(usrId);
						//Rout Rmk Update
						command.saveAuthRqstRmk(authorizationAproVOs[i]);
					}
				}
			}	
			commit();			
			 
		}catch(EventException ex){
			rollback();
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        rollback();
	        throw new EventException(new ErrorHandler("COM12192", new String[]{"Save Remark"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Authorization Approval Confirm 화면에 대한 TRS 용 조회 이벤트 처리<br>
	 * COM_ENS_0U1
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAuthApproTrsList(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		ComEns0U1Event event = (ComEns0U1Event)e;
		
		try {
			WorkOrderInquiryBC command = new WorkOrderInquiryBCImpl();
			eventResponse = command.searchAuthApproTrsList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 저장 이벤트 처리 <br>
	 * Authorization  Approve(before)/confirm 저장 이벤트 처리<br>
	 * COM_ENS_0U1
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/
	private EventResponse approveAuthApproval(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ComEns0U1Event event = (ComEns0U1Event)e;
		String usrId = JSPUtil.getNull(event.getSignOnUserAccount().getUsr_id());
		
		ApprovalBC command = new ApprovalBCImpl();
		String chkCd = "";
		String duplChk = "";
		String authEmlSndNoSeq = "";
		String chkXlsApro = "";
		try{
			log.error("\n>>>>>>>>>>apro,cfm sc 진입");
			AuthorizationAproVO[] authorizationAproVOs = null;
			AuthorizationAproVO authorizationAproVO = null;			
			authorizationAproVOs = event.getAuthorizationAproVOS();
			AuthorizationApprovalUtil authorizationApprovalUtil = new AuthorizationApprovalUtil();
			if(authorizationAproVOs != null) {
				for (int i=0; i<authorizationAproVOs.length; i++) {
					if("U".equals(authorizationAproVOs[i].getIbflag())) {
						authorizationAproVO = authorizationAproVOs[i];
						authorizationAproVO.setUsrId(usrId);
						AuthEmlSndVO emlSndVO = null;
						String authAproRqstNo = authorizationAproVO.getAuthAproRqstNo();
						String snd_no = "";
						
						//동시 결재 방지 로직
						//Y이면 동시에 결재 시도...N이면 괜찮!
						duplChk = JSPUtil.getNull(authorizationApprovalUtil.checkAuthDuplApro(authorizationAproVO));
						log.error("\n>>>>>>>>>>SC단 auth 중복 결재 duplChk:"+duplChk+"<<<<<<<<");
						if("N".equals(duplChk)){
							begin();
							//Rout Update
							command.updateAuthAproRout(authorizationAproVO);
							commit();
							
							//최종결재인지 확인
							chkCd = command.checkAuthApproval(authorizationAproVO);
							log.error("\n>>>>>>>>>>apro,cfm checkFlag  "+chkCd+"<<<<<<<<");
							
							//액셀 결재인지 확인
							chkXlsApro = authorizationApprovalUtil.checkXlsApproval(authAproRqstNo);
							
							if("C".equals(chkCd)){
								//마지막 결재
								command.confirmAuthAproFinal(authorizationAproVO);
								if("EXCEL_DOWN_DUMMY".equals(chkXlsApro)){
									begin();
									//E-mail 시퀀스 채번
									authEmlSndNoSeq = authorizationApprovalUtil.searchAuthEmlSndSeq();
									//이메일 컨텐츠 준비
									emlSndVO = authorizationApprovalUtil.authRdyToSndEml(authAproRqstNo, authEmlSndNoSeq, account, chkCd);
									commit();
									
									//이메일 발송
									snd_no = JSPUtil.getNull(authorizationApprovalUtil.authSndEml(emlSndVO));
									log.error("\n\n>>>>>>>>>>>Eml_Snd_No>>>>>"+snd_no+"<<<<<<<<<\n\n");
									emlSndVO.setEmlSndNo(snd_no);
									
									begin();
									//E-mail 성공 여부 Update
									authorizationApprovalUtil.updateAuthEmlSndSuccess(emlSndVO);
									commit();
								}
								
								
							}else if("P".equals(chkCd)){
								//결재 진행중
								command.confirmAuthAproProgress(authorizationAproVO);
								if("EXCEL_DOWN_DUMMY".equals(chkXlsApro)){
									begin();
									//E-mail 시퀀스 채번
									authEmlSndNoSeq = authorizationApprovalUtil.searchAuthEmlSndSeq();
									//이메일 컨텐츠 준비
									emlSndVO = authorizationApprovalUtil.authRdyToSndEml(authAproRqstNo, authEmlSndNoSeq, account, chkCd);
									commit();
									
									//이메일 발송
									snd_no = JSPUtil.getNull(authorizationApprovalUtil.authSndEml(emlSndVO));
									log.error("\n\n>>>>>>>>>>>Eml_Snd_No>>>>>"+snd_no+"<<<<<<<<<\n\n");
									emlSndVO.setEmlSndNo(snd_no);
									
									begin();
									//E-mail 성공 여부 Update
									authorizationApprovalUtil.updateAuthEmlSndSuccess(emlSndVO);
									commit();
								}
							}
						}else{
							 throw new EventException("Already confirmed");
						}
					}
				}
			}			
		}catch(EventException ex){
			rollback();
			throw ex;
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        rollback();
	        throw new EventException(new ErrorHandler("COM12192", new String[]{"Confirm Approval"}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	
	/**
	 * 조회 이벤트 처리 <br>
	 * Authorization  Approve / Confirm 버튼 클릭시 최종결재완료 여부 확인<br>
	 * COM_ENS_0U1
	 * @param Event e
	 * @return String
	 * @exception EventException
	*/
	public String checkAuthApproval(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		ComEns0U1Event event = (ComEns0U1Event)e;
		ApprovalBC command = new ApprovalBCImpl();
		String confirmCheck = "";
		try{
			AuthorizationAproVO[] authorizationAproVOs = null;
			AuthorizationAproVO authorizationAproVO = null;
			authorizationAproVOs = event.getAuthorizationAproVOS();
			if(authorizationAproVOs != null) {
				for (int i=0; i<authorizationAproVOs.length; i++) {
					if("U".equals(authorizationAproVOs[i].getIbflag())) {
						authorizationAproVO = authorizationAproVOs[i];
						
							confirmCheck = command.checkAuthApproval(authorizationAproVO);
							
						
					}
				}
			}

		}catch(EventException ex){
			rollback();
			throw new EventException(ex.getMessage());
	    } catch (Exception ex) {
	        log.error("err " + ex.toString(), ex);
	        rollback();
	        throw new EventException(ex.getMessage());
		}
		return confirmCheck;
	}
	
	
    /**
     * 조회 이벤트 처리<br>
     * Approval CSR 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     * @author DS HAM
     */
    private EventResponse searchUnApprovalCsrList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComEns0Y1Event event = (ComEns0Y1Event)e;
    	ApprovalBC command = new ApprovalBCImpl();
    	
        try {
        	List<UnApprovalCsrVO>  unApprovalCsrVOs = command.searchUnApprovalCsrList(event.getUnApprovalCsrVO());
        	eventResponse.setRsVoList(unApprovalCsrVOs);
        } catch(EventException ex){
					throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"UnApproval Csr List"}).getMessage(), ex);
		}
        
        return eventResponse;
    }
    
	/**
	 * COM_ENS_0Y1 : Open<br>
	 * A/R HEAD QUARTER OFFICE CODE를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author DS HAM
	 */
	private EventResponse searchARRHQOfficeList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ApprovalBC command = new ApprovalBCImpl();
    	ComEns0Y1Event event = (ComEns0Y1Event)e;
			try {
				//String ofcCd = event.getSignOnUserAccount().getRhq_ofc_cd();
				//OFC_CD로 RHQ_OFC_CD를 조회 (2010-07-27 추가)
				String ofcCd = command.searchRhqOfcCdByOfcCd(event.getSignOnUserAccount().getOfc_cd());
				
				List<String> list = command.searchARRHQOfficeList();
				String arHdQtrOfcInfo = "";
				StringBuffer tmparHdQtrOfcInfo = new StringBuffer();
				tmparHdQtrOfcInfo.append(arHdQtrOfcInfo);
				
				if(ofcCd.equals("SELHO")){	//본사직원인 경우 조회한 ar_hd_qtr_ofc_cd 정보 모두를 가져온다
				
					if (list.size() > 0) {
						for (int i = 0; i < list.size(); i++) {
							tmparHdQtrOfcInfo.append("|");
							tmparHdQtrOfcInfo.append(list.get(i));
						}
						arHdQtrOfcInfo = tmparHdQtrOfcInfo.toString();
						
						eventResponse.setETCData("ar_hd_qtr_ofc_cd", arHdQtrOfcInfo);
					} else {
						eventResponse.setUserMessage(new ErrorHandler("COM12198").getUserMessage());
					}
					
				}else{	//본사직원이 아닌 경우 조회한 본인의 ar_hd_qtr_ofc_cd 정보를 가져온다 
					eventResponse.setETCData("ar_hd_qtr_ofc_cd", "|" + ofcCd);
				}
				return eventResponse;
			} catch (EventException ex) {
				rollback();
				throw ex;
			} catch (Exception ex) {
				rollback();
				throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
			}
	}
	
	/**
	 * COM_ENS_0Y1 : Open<br>
	 * OFFICE CODE를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author DS HAM
	 */
	private EventResponse searchSelOfficeList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ApprovalBC command = new ApprovalBCImpl();
    	ComEns0Y1Event event = (ComEns0Y1Event)e;
			try {
				List<String> list = command.searchSelOfficeList(event.getUnApprovalCsrVO());
	            eventResponse.setRsVoList( list  );  
				/*
				String ofcInfo = "";
				
				if (list.size() > 0) {
					for (int i = 0; i < list.size(); i++) {
						ofcInfo = ofcInfo + "|" + list.get(i);
					}
					
					eventResponse.setETCData("ofc_cd", ofcInfo);
				} else {
					eventResponse.setUserMessage(new ErrorHandler("COM12198").getUserMessage());
				}
				*/
				return eventResponse;
			} catch (EventException ex) {
				rollback();
				throw ex;
			} catch (Exception ex) {
				rollback();
				throw new EventException(new ErrorHandler("COM12203").getMessage(), ex);
			}
	}
	
	/**
	 * 저장 이벤트 처리 <br>
	 * Approval Reject 저장 이벤트 처리<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	*/
	private EventResponse rejectApproval(Event e) throws EventException { 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComEns0U1Event event = (ComEns0U1Event)e;
    	ApprovalBC command = new ApprovalBCImpl();
    	ApprovalCsrVO[] approvalCsrVOs = null;
    	ApprovalCsrVO approvalCsrVO = null;
    	
    	AGTAuditBC agtCommand = new AGTAuditBCImpl();
    	AGNCommApprovalBC acmCommand = new AGNCommApprovalBCImpl();
    	CARIssueTransferSlipManageBC tesCommand = new CARIssueTransferSlipManageBCImpl();
		CSRIssueTransferSlipManageBC trsCommand = new CSRIssueTransferSlipManageBCImpl();
		TCharterIOConsultationBC     fmsCommand = new TCharterIOConsultationBCImpl();
		//JointOperationConsultationBC jooCommand = new JointOperationConsultationBCImpl();
		String chk_curr_apro_usr_yn = null;
		
    	try{
			begin();
			approvalCsrVOs = event.getApprovalCsrVOS();
			if(approvalCsrVOs != null) {
        		for (int i=0; i<approvalCsrVOs.length; i++) {
        			//결재 선택 건 체크 (ibflag = 'U')
        			if("U".equals(approvalCsrVOs[i].getIbflag())) {
        				//1) 처리할 건에 대한 기본정보
        				approvalCsrVO = approvalCsrVOs[i];
        				
        				chk_curr_apro_usr_yn = approvalCsrVO!=null?(new ApprovalUtil().checkCurrentApprovalUserYN(JSPUtil.getNull(approvalCsrVO.getCsrNo()),e.getSignOnUserAccount().getUsr_id())):"";
        				log.error("\n\n BIZCOMMSC.rejectApproval - CSRNO : "+ (approvalCsrVO!=null?JSPUtil.getNull(approvalCsrVO.getCsrNo()):"") + " - usrid : " + e.getSignOnUserAccount().getUsr_id() + " - chk_curr_apro_usr_yn : " +  JSPUtil.getNull(chk_curr_apro_usr_yn) + " <<<<< \n\n");
        				
        				if (chk_curr_apro_usr_yn!=null && chk_curr_apro_usr_yn.trim().equals("Y")){
            				//2) 현 결재선 정보 세팅
                			ComAproRqstRoutVO rout = command.searchApprovalCurCsrRoute(approvalCsrVO);
                			
                			//승인자가 결재라인에 있는지 확인한다.(Start)
//                			String sAproUsrId = rout!=null?JSPUtil.getNull(rout.getAproUsrId()):"";
//                			String sLoginUsrId = e!=null&&e.getSignOnUserAccount()!=null?JSPUtil.getNull(e.getSignOnUserAccount().getUsr_id()):"";
//                             //Approval Step의 Usr Id를 EP ID를 사용할 경우 확인
//                			String comUsrId = command.searchAproUsrId(sLoginUsrId);
//
//                			log.error("\n ---------------------------------------------- \n"
//                					+ "\n - BizCommonSC.rejectApproval() -->> " 
//                					+ "\n - csr_no :"+(approvalCsrVO!=null?JSPUtil.getNull(approvalCsrVO.getCsrNo()):"")
//                					+ "\n - sAproUsrId:"+JSPUtil.getNull(sAproUsrId)
//                					+ "\n - sLoginUsrId:"+JSPUtil.getNull(sLoginUsrId)
//                					+ "\n - comUsrId:"+JSPUtil.getNull(comUsrId)
//                					+ "\n ---------------------------------------------- \n");
//                			
//                			if(!sAproUsrId.equals("")&&!comUsrId.equals("")){
//                				if(!sAproUsrId.equals(comUsrId)){
//                					throw new EventException((new ErrorHandler("CSR10021", new String[]{approvalCsrVO.getCsrNo()}).getMessage())); 
//                				}
//                			}else{
//                 				throw new EventException((new ErrorHandler("COM12240", new String[]{approvalCsrVO.getCsrNo()}).getMessage())); 
//                			}
                			//승인자가 결재라인에 있는지 확인한다.(End)
                			
                			//3) 결재 정보 Update
                			command.rejectApproval(approvalCsrVO);
                			
                			//4) 각 모듈 Update (TES/TRS/AGT/ACM)
        					if("AGT".equals(approvalCsrVO.getSubSysCd())) {					
        						agtCommand.transferAgentActualINFtoAP1("R", approvalCsrVO.getCsrNo(), rout);
        					} else if("ACM".equals(approvalCsrVO.getSubSysCd())) {
        						acmCommand.transferAgentActualINFtoAP1("R", approvalCsrVO.getCsrNo(), rout);
        					} else if("TES".equals(approvalCsrVO.getSubSysCd())) {
        						tesCommand.approvalRequestAccount1("R", approvalCsrVO.getCsrNo(), rout);
        					} else if("TRS".equals(approvalCsrVO.getSubSysCd())) {
        						trsCommand.approvalRequestAccount1("R", approvalCsrVO.getCsrNo(), rout);
    	    				}
        					if("FMS".equals(approvalCsrVO.getSubSysCd())){
        						fmsCommand.manageDisapproveFMS(e.getSignOnUserAccount().getUsr_id(), approvalCsrVO.getCsrNo(), e.getSignOnUserAccount().getOfc_cd());
        					}
        				}
        			}
        		}
			}
			commit();	
			
			List<ApprovalCsrVO>  resultVOs = command.searchApprovalCsrList(event.getApprovalStaffVO(), account);
        	eventResponse.setRsVoList(resultVOs);
		}catch(EventException ex){
			rollback();
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            rollback();
            throw new EventException(new ErrorHandler("COM12192", new String[]{"Reject Approval"}).getMessage(), ex);
		}
        
		return eventResponse;
	}
	
	/**
     * COM_ENS_0U1 : BackEndJob 상태, 에러 조회 <br>
     * 
     * @param Event e
     * @return EventResponse
     * @throws BackEndJobException
     */
	private EventResponse searchAccrualBackEndJobStatus(Event e) throws EventException { 
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ConsultationSlipRequestMgtBC command = new ConsultationSlipRequestMgtBCImpl();
		
		String key = (String)e.getAttribute("key");
		String statusNerr = command.searchBakEndJobStatus(key);
		
		eventResponse.setETCData("jb_sts_flg", statusNerr.substring(0,1));
		eventResponse.setETCData("jb_usr_err_msg", statusNerr.substring(1));
		
		return eventResponse;
	}
	
	/**
     * COM_CSR_0008 View Approval Step 버튼 -> COM_ENS_0W1 팝업 조회 이벤트 처리<br>
     * Approval Step 화면에 대한 조회 이벤트 처리<br>
     * 
     * @param e 
     * @return response EventResponse
     * @exception EventException
     * @author HyungChoon Roh
     * @date 2007.03.22
     */
    private EventResponse searchApprovalStepList(Event e) throws EventException { //--
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComEns0W1Event event = (ComEns0W1Event)e;
    	ApprovalBC command = new ApprovalBCImpl();
        try {
        	if(!"".equals(event.getApprovalCsrVO().getAproRqstNo())) {
	        	List<ApprovalStepVO>  resultVOs = command.searchApprovalStepList(event.getApprovalCsrVO());
	        	eventResponse.setRsVoList(resultVOs);
        	} else {
        		throw new EventException(new ErrorHandler("COM12111").getMessage());
        	}
        }catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Approval Step List"}).getMessage(), ex);
		}
        
        return eventResponse;
    }
//approval-]--------------------------------------------------------------------------------------------------------------
    
	/**
	 * 조회 이벤트 처리<br>
	 * LogicsServiceProvider의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLogicsServiceProvider(Event e) throws EventException {
		try{
			// PDTO(Data Transfer Object including Parameters)
			UiCtm0435Event event = (UiCtm0435Event)e;
			LogicsServiceProviderBC command = new LogicsServiceProviderBCImpl();
			List<RMdmVenderVO> list = command.searchLogicsServiceProvider(event.getRMdmVenderVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	 /**
     * 조회 이벤트 처리<br>
     * Commodity 화면에 대한 조회 이벤트 처리<br>
     * @param e  
     * @return response EventResponse
     * @exception EventException
     * @author sungseok, choi
     * @date 2006.08.03
     */
    private EventResponse searchCommodityList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try {
        	ComEns011Event event = (ComEns011Event)e;
        	// CommodityBC command = new CommodityBCImpl() 추가
            CommodityBC command = new CommodityBCImpl();
           // String cmdtCd, String repCmdtCd, String repImdgLvlCd, String cmdtNm, int iPage
            eventResponse.setRsVoList(command.searchCommodityList(event.getCmdtCd(),event.getRepCmdtCd(),event.getRepImdgLvlCd(),event.getCmdtNm(),event.getIPage()));
            
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Contract No 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * 
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchContractNoList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComEns021Event event = (ComEns021Event)e;
        try {
        	ContractNoBC command = new ContractNoBCImpl();
            eventResponse.setRsVoList(command.searchContractNoList(event.getContTp(),event.getContNo(),event.getCustNm(),event.getSdate(),event.getEdate(),event.getIPage(),event.getOfc_cd(),event.getCtrt_cust_sls_ofc_cd()));
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * ServiceProvider 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     * @author sungseok, choi
     * @date 2006.08.07
     */
    private EventResponse searchCustomerList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ComEns041Event event = (ComEns041Event)e;
        try {
        	CustomerBC command = new CustomerBCImpl();
        	// custCd, custNm, ofcCd, iPage, include, cust
            eventResponse.setRsVoList(command.searchCustomerList(event.getCustCd(),event.getCustNm(),event.getOfcCd(),event.getIPage(),event.getInclude(),event.getCust(), event.getZipCd()));
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Location 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchLocationList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ComEns051Event event = (ComEns051Event)e;
        try {
            LocationBC command = new LocationBCImpl();
            eventResponse.setRsVoList(command.searchLocationList(event.getLocCd(),event.getLocNm(),event.getUnLocIndCd(),event.getCntCd(),event.getLocEqOfc(),event.getSelect(),event.getRccCd(),event.getLccCd(),event.getLocState(),event.getIPage()));
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
    
    /** Location Detail <br>
     * Location 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchLocationDetail(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ComEns051Event event = (ComEns051Event)e;
        Map<String, String> etcData = new HashMap<String, String>();
        try {
            LocationBC command = new LocationBCImpl();
            List<SearchLocationDetailVO> list = command.searchLocationDetail(event.getLocCd());
            
            if(list.size() > 0){
         	   SearchLocationDetailVO vo = list.get(0);
         	        etcData.put("loc_cd", vo.getLocCd());
           		    etcData.put("loc_nm", vo.getLocNm());
            		etcData.put("un_loc_cd", vo.getUnLocCd());
            		etcData.put("rgn_cd", vo.getRgnCd());
            		etcData.put("loc_state", vo.getLocState());
            		etcData.put("ste_nm", vo.getSteNm());
            		etcData.put("scc_cd", vo.getSccCd());
            		etcData.put("lcc_cd", vo.getLccCd());
            		etcData.put("ecc_cd", vo.getEccCd());
            		etcData.put("sls_ofc_cd", vo.getSlsOfcCd());
            		etcData.put("finc_ctrl_ofc_cd", vo.getFincCtrlOfcCd());
            		etcData.put("eq_ctrl_ofc_cd", vo.getEqCtrlOfcCd());
            		etcData.put("zip_cd", vo.getZipCd());
            		if(vo.getContiNm().trim().length() > 1){
            			etcData.put("conti_nm", vo.getContiNm());
            		}else{
            			etcData.put("conti_nm", "");
            		}
            		etcData.put("port_inlnd_cd", vo.getPortInlndCd());
            		etcData.put("call_port_flg", vo.getCallPortFlg());
            		etcData.put("loc_locl_lang_nm", vo.getLocLoclLangNm());
            		etcData.put("mty_pkup_yd_cd", vo.getMtyPkUpYdCd());
            		etcData.put("rep_zn_cd", vo.getRepZnCd());
            	
            		etcData.put("hub_loc_cd", vo.getHubLocCd());
            		etcData.put("loc_grd_no", vo.getLocGrdNo());
            		etcData.put("cml_zn_flg", vo.getCmlZnFlg());
            		etcData.put("loc_ams_port_cd", vo.getLocAmsPortCd());
            		etcData.put("gmt_hrs", vo.getGmtHrs());
            		etcData.put("cstms_cd", vo.getCstmsCd());
            		etcData.put("sconti_cd", vo.getScontiCd());
            		etcData.put("country", vo.getCountry());
            		etcData.put("port_lat", vo.getPortLat());
            		etcData.put("port_lon", vo.getPortLon());

            	
            }  
            eventResponse.setETCData(etcData);
        } catch(EventException ex) {
 			throw ex;
 		} catch(Exception ex) {
 			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
 		}
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Node 화면에 대한 조회 이벤트 처리<br>
     * @param e  
     * @return response EventResponse
     * @exception EventException
     * @author HyungChoon Roh
     * @date 2006.08.07
     */
    private EventResponse searchNodeList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ComEns061Event event = (ComEns061Event)e;
        try {
            NodeBC command = new NodeBCImpl();
            List<Object> obj = command.searchNodeList(event.getCnt_cd(),event.getLoc_cd(),event.getOfc_cd(),event.getNode_cd(),event.getNode_nm(),event.getMode(),event.getMode_only(),event.getScc_cd(),event.getIPage());
            if(event.getMode().equals("yard")){
            	List<SearchNodeYardListVO> list = (List<SearchNodeYardListVO>) obj.get(0);
            	eventResponse.setRsVoList(list);
			}else{
				List<SearchNodeZoneListVO> list = (List<SearchNodeZoneListVO>) obj.get(0);
            	eventResponse.setRsVoList(list);
			}
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Office 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchOfficeList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ComEns071Event event = (ComEns071Event)e;
        try {
        	OfficeBC command = new OfficeBCImpl();
        	//locCd, ofcLev, ofcPtsCd, ofcCd, ofcNm, calltype, iPage, ofcAddr
            eventResponse.setRsVoList(command.searchOfficeList(event.getLoc_cd(),event.getOfc_lev(),event.getOfc_pts_cd(),event.getOfc_cd(),event.getOfc_nm(),event.getCallType(),event.getIPage(),event.getOfc_addr()));
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Node 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     * @author HyungChoon Roh
     * @date 2006.08.07
     */
    private EventResponse searchLaneList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComEns081Event event = (ComEns081Event)e;
        try {
            LaneBC command = new LaneBCImpl();
            List<SearchLaneListVO> list = command.searchLaneList(event.getTrade_cd(),event.getSub_tradeCd(),event.getSvc_tp(),event.getLane_cd(),event.getLane_nm(),event.getMode(),event.getIPage());
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }

    /**
     * 조회 이벤트 처리<br>
     * Vessel 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchVesselList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ComEns0A1Event event = (ComEns0A1Event)e;
        try {
            VesselBC command = new VesselBCImpl();
            //vslCd, vslEngNm, carCd, iPage , callSgnNo, lloydNo
            eventResponse.setRsVoList(command.searchVesselList(event.getVsl_cd(),event.getVsl_eng_nm(),event.getCar_cd(),event.getIPage(),event.getCall_sgn_no(),event.getLloyd_no()));
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }     
    
    /**
     * 조회 이벤트 처리<br>
     * Vessel SKD 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchVesselSKDList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try {
            VesselSKDBC command = new VesselSKDBCImpl();
            eventResponse.setRs(command.searchVessel_SKDList(e));
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
    

    
    /**
     * 조회 이벤트 처리<br>
     * Vessel SKD 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchVvdList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ComEns0B2Event event = (ComEns0B2Event)e;
        try {
            VvdBC command = new VvdBCImpl();
            //etDeta, sdDate, edDate, vvdCd, locCd, laneCd, oper, iPage
            eventResponse.setRsVoList(command.searchVvdList(event.getEtdeta(),event.getSdate(),event.getEdate(),event.getVvd_cd(),event.getLoc_cd(),event.getLane_cd(),event.getOper(),event.getIPage()));
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * ServiceProvider 화면에 대한 조회 이벤트 처리<br>     
     * @param e  
     * @return response EventResponse
     * @exception EventException
     * @author sungseok, choi
     * @date 2006.08.07
     */
    private EventResponse searchServiceProviderList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
			List<SpListVO> list = new ArrayList<SpListVO>();
			SpListVO   vo = null;
			ComEns0C1Event event = null;
			if(e.getEventName().equalsIgnoreCase("ComEns0C1Event")){
				event = (ComEns0C1Event)e; 
				vo = event.getSpListVO();
			}
        	
            ServiceProviderBC command = new ServiceProviderBCImpl();
            if(event != null){
            	list =command.searchServiceProviderList(vo, event.getIPage());
            }
            
            if ( eventResponse != null && list.size() > 0 ){
            	eventResponse.setRsVoList(list);
            }
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * EQ Organization Chart 화면에 대한 조회 이벤트 처리<br>
     * @param e  
     * @return response EventResponse
     * @exception EventException
     * @author HyungChoon Roh
     * @date 2006.08.07
     */
    private EventResponse searchEQOrgChartList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        List<EQQrgChartListVO> list = new ArrayList<EQQrgChartListVO>();
        try {
        	ComEns0O1Event event=(ComEns0O1Event)e;
            EQOrgChartBC command = new EQOrgChartBCImpl();
            
            String depth = event.getDepth();
            String chkDepth = event.getChkDepth();
            
            list = command.searchEQOrgChartList(depth, chkDepth);
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Service Scope 화면에 대한 조회 이벤트 처리<br>
     * @param e  
     * @return response EventResponse
     * @exception EventException
     * @author HyungChoon Roh
     * @date 2006.08.07
     */
    private EventResponse searchServiceScopeList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
			List<SearchServiceScopeListVO> list = new ArrayList<SearchServiceScopeListVO>();
			SearchServiceScopeListVO   vo = null;
			ComEns0L1Event event = null;
			if(e.getEventName().equalsIgnoreCase("ComEns0L1Event")){
				event = (ComEns0L1Event)e; 
				vo = event.getSearchServiceScopeListVO();
			}
        	
			ServiceScopeBC command = new ServiceScopeBCImpl();
			if(event != null){
				list =command.searchServiceScopeList(vo, event.getIPage());
			}
            if ( eventResponse != null && list.size() > 0 ){
            	eventResponse.setRsVoList(list);
            }
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Country 화면에 대한 조회 이벤트 처리<br>
     * @param e  
     * @return response EventResponse
     * @exception EventException
     * @author HyungChoon Roh
     * @date 2006.08.07
     */
    private EventResponse searchCountryList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
			List<CountryListVO> list = new ArrayList<CountryListVO>();
			CountryListVO   vo = null;
			ComEns0M1Event event = null;
			if(e.getEventName().equalsIgnoreCase("ComEns0M1Event")){
				event = (ComEns0M1Event)e; 
				vo = event.getCountryListVO();
			}
        	
			CountryBC command = new CountryBCImpl();
			if(event != null){
				list =command.searchCountryList(vo, event.getIPage());
			}
            if ( eventResponse != null && list.size() > 0 ){
            	eventResponse.setRsVoList(list);
            }
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Continent 화면에 대한 조회 이벤트 처리<br>
     * @param e  
     * @return response EventResponse
     * @exception EventException
     * @author HyungChoon Roh
     * @date 2006.08.07
     */
    private EventResponse searchContinentList() throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
			List<SearchContinentListVO> list = new ArrayList<SearchContinentListVO>();
			ContinentBC command = new ContinentBCImpl();
			
            list = command.searchContinentList();
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Sub Continent 화면에 대한 조회 이벤트 처리<br>
     * @param e  
     * @return response EventResponse
     * @exception EventException
     * @author HyungChoon Roh     
     * @date 2006.08.07
     */
    private EventResponse searchSubContinentList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
			List<SearchSubContinentListVO> list = new ArrayList<SearchSubContinentListVO>();
			SearchSubContinentListVO   vo = null;
			ComEns0I1Event event = null;
			if(e.getEventName().equalsIgnoreCase("ComEns0I1Event")){
				event = (ComEns0I1Event)e; 
				vo = event.getSearchSubContinentListVO();
			}
        	
			SubContinentBC command = new SubContinentBCImpl();
			if(event != null){
				list =command.searchSubContinentList(vo, event.getIPage());
			}
            if ( eventResponse != null && list.size() > 0 ){
            	eventResponse.setRsVoList(list);
            }
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Region 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     * @author HyungChoon Roh
     * @date 2006.08.07
     */
    private EventResponse searchRegionList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
			List<SearchRegionListVO> list = new ArrayList<SearchRegionListVO>();
			SearchRegionListVO   vo = null;
			ComEns0J1Event event = null;
			if(e.getEventName().equalsIgnoreCase("ComEns0J1Event")){
				event = (ComEns0J1Event)e; 
				vo = event.getSearchRegionListVO();
			}
        	
			RegionBC command = new RegionBCImpl();
			if(event != null){
				list =command.searchRegionList(vo, event.getIPage());
			}
            if ( eventResponse != null && list.size() > 0 ){
            	eventResponse.setRsVoList(list);
            }
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Continent 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     * @author HyungChoon Roh
     * @date 2006.08.07
     */
    private EventResponse searchRepCommodityList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ComEns0K1Event event = (ComEns0K1Event)e;
        try {
			List<SearchRepCommodityListVO> list = new ArrayList<SearchRepCommodityListVO>();
			SearchRepCommodityListVO   vo = null;
			if(e.getEventName().equalsIgnoreCase("ComEns0K1Event")){
				event = (ComEns0K1Event)e; 
				vo = event.getSearchRepCommodityListVO();
			}
        	
			RepCommodityBC command = new RepCommodityBCImpl();
            list =command.searchRepCommodityList(vo);
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Carrier 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     * @author HyungChoon Roh
     * @date 2006.08.07
     */
    private EventResponse searchCarrierList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
			List<CarrierListVO> list = new ArrayList<CarrierListVO>();
			CarrierListVO   vo = null;
			ComEns0N1Event event = null;
			if(e.getEventName().equalsIgnoreCase("ComEns0N1Event")){
				event = (ComEns0N1Event)e; 
				vo = event.getCarrierListVO();
			}
        	
			CarrierBC command = new CarrierBCImpl();
			if(event != null){
				list =command.searchCarrierList(vo, event.getIPage());
			}
            if ( eventResponse != null && list.size() > 0 ){
            	eventResponse.setRsVoList(list);
            }
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
    
    
    /**
     * 조회 이벤트 처리<br>
     * Container Type Size 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     * @author HyungChoon Roh
     * @date 2006.08.07
     */
    private EventResponse searchCntrTpSzList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        try {
        	CntrTpSzBC command = new CntrTpSzBCImpl();
            eventResponse = command.searchCntrTpSzList(e);
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * VVD Chart 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     * @author HyungChoon Roh
     * @date 2006.08.07
     */
    private EventResponse searchVVDChartList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            List<VVDChartListVO> list = new ArrayList<VVDChartListVO>();
            ComEns0P1Event event = (ComEns0P1Event)e;
            VVDChartBC command = new VVDChartBCImpl();
            list =command.searchVVDChartList(event.getScnr_id(), event.getDepth(), event.getChkDepth()); 
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * VVD Chart 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     * @author HyungChoon Roh
     * @date 2006.08.07
     */
    private EventResponse searchMonthlyRateList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        try {
        	MonthlyRateBC command = new MonthlyRateBCImpl();
            eventResponse = command.searchMonthlyRateList(e);
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * VVD Chart 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     * @author HyungChoon Roh
     * @date 2006.08.07
     */
    private EventResponse searchVvdRateList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
			List<VVDListVO> list = new ArrayList<VVDListVO>();
			VVDListVO   vo = null;
			ComEns0F1Event event = null;
			if(e.getEventName().equalsIgnoreCase("ComEns0F1Event")){
				event = (ComEns0F1Event)e; 
				vo = event.getVvdListVO();
			}
        	
			VVDRateBC command = new VVDRateBCImpl();
			if(event != null){
				list =command.searchVVDRateList(vo, event.getIPage());
			}
            if ( eventResponse != null && list.size() > 0 ){
            	eventResponse.setRsVoList(list);
            }
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Staff 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     * @author HyungChoon Roh
     * @date 2006.08.07
     */
    private EventResponse searchStaffList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	GeneralEventResponse response = new GeneralEventResponse();
        try {
        	StaffBC command = new StaffBCImpl();
        	ComEns091Event event = (ComEns091Event)e;
        	response.setRsVoList(command.searchStaffList(event.getOfc_cd(),event.getUser_cd(),event.getUser_nm(),event.getIPage()));
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return response;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Staff 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     * @author HyungChoon Roh
     * @date 2006.08.07
     */
    private EventResponse searchDeptList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
    	GeneralEventResponse response = new GeneralEventResponse();
        ComEns091Event event = (ComEns091Event)e; 
        try {
        	StaffBC command = new StaffBCImpl();
        	response.setRsVoList(command.searchDeptList(event.getSignOnUserAccount().getOfc_cd()));
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return response;
    }
       
    /**
     * 조회 이벤트 처리<br>
     * Local Calendar 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     * @author HyungChoon Roh
     * @date 2006.08.07
     */
    private EventResponse searchCntHolidayList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        try {
        	CalendarBC command = new CalendarBCImpl();
            eventResponse = command.searchCntHolidayList(e);
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
	 * Forecasted Vessel Residual Capacity 저장 <br>
	 * Forecasted Vessel Residual Capacity 저장 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse modifyCntHoliday(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;           
		try {
			CalendarBC command = new CalendarBCImpl();
			eventResponse = command.modifyCntHoliday(e);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * 설명 : AP I/F 수행 <br>
	 * CSR AP 관련 공통 메소드입니다 2009-11-18 HDS
	 * @throws EventException 
	*/
	private void transferInvToERP(FNS0080003Document[] docReq, ApprovalCsrVO approvalCsrVO) throws EventException {
		SendQueueBC apInvCommand = new SendQueueBCImpl();
		ApprovalBC command = new ApprovalBCImpl();
		try {
			apInvCommand.transferInvToERP(docReq, this.account);
		} catch(EventException ex) {
			rollback();
			command.confirmApprovalRemark(approvalCsrVO);
			throw ex;
		} catch(Exception ex) {
			rollback();
			command.confirmApprovalRemark(approvalCsrVO);
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
	}
	
	/**
     * 조회 이벤트 처리<br>
     * Local Calendar 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     * @author HyungChoon Roh
     * @date 2006.08.07
     */
    private EventResponse searchSteHolidayList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        try {
        	CalendarBC command = new CalendarBCImpl();
            eventResponse = command.searchSteHolidayList(e);
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
	 * Forecasted Vessel Residual Capacity 저장 <br>
	 * Forecasted Vessel Residual Capacity 저장 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse modifySteHoliday(Event e) throws EventException {
		
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;           
		
		try {
			CalendarBC command = new CalendarBCImpl();
			eventResponse = command.modifySteHoliday(e);
			return (eventResponse); 
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
	}
	
	/**
     * 조회 이벤트 처리<br>
     * Local Calendar 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     * @author HyungChoon Roh
     * @date 2006.08.07
     */
    private EventResponse searchLocHolidayList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        try {
        	CalendarBC command = new CalendarBCImpl();
            eventResponse = command.searchLocHolidayList(e);
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
	 * Forecasted Vessel Residual Capacity 저장 <br>
	 * Forecasted Vessel Residual Capacity 저장 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	*/
	private EventResponse modifyLocHoliday(Event e) throws EventException {
		
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;           
		
		try {
			CalendarBC command = new CalendarBCImpl();
			eventResponse = command.modifyLocHoliday(e);
			return (eventResponse); 
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
	}
	
	/**
     * 조회 이벤트 처리<br>
     * Local Calendar 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     * @author HyungChoon Roh
     * @date 2006.08.07
     */
    private EventResponse searchMonthlyHolidayList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        try {
        	CalendarBC command = new CalendarBCImpl();
            eventResponse = command.searchMonthlyHolidayList(e);
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Local Calendar 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     * @author HyungChoon Roh
     * @date 2006.08.07
     */
    private EventResponse searchStateList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        try {
        	StateBC command = new StateBCImpl();
            eventResponse = command.searchStateList(e);
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
        return eventResponse;
    }

    
    /**
     * 조회 이벤트 처리<br>
     * Per Type 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     * @author Prak Kwang Seok
     * @date 2009.04.20
     */
    private EventResponse searchPertypeList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
			// PDTO(Data Transfer Object including Parameters)
    		UiPri4002Event event = (UiPri4002Event)e;
			PerTypeBC command = new PerTypeBCImpl();
			List<PriRatUtVO> list = command.searchPertypeList(event.getPretypevo());
			eventResponse.setRsVoList(list);
	    } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
		return eventResponse;
	}
    


    /**
     * AccountList 조회 이벤트 처리
     * Account Code 팝업 조회처리
     * @param e
     * @return
     * @throws EventException
     * @author Suk Jun Kim
     * @date 2007.04.22
     */
    private EventResponse searchAccountList(Event e) throws EventException {
	  // AccountList
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
	    	ComEnsN11Event event = (ComEnsN11Event)e;
	    	AccountBC command = new AccountBCImpl();
	    	List<MdmAccountVO> list = command.searchAccountList(event.getMdmAccountVO());
	    	
	    	eventResponse.setRsVoList(list);
	    } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
    	return eventResponse;
    }

    /**
     * CurrencyList 조회 이벤트 처리
     * Currency Code 팝업 조회처리
     * @param e
     * @return
     * @throws EventException
     * @author Eui-su Park
     * @date 2007.04.22
     */
    private EventResponse searchCurrencyList(Event e) throws EventException {
	  // AccountList
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
	    	ComEnsN13Event event = (ComEnsN13Event)e;
	    	CurrencyBC command = new CurrencyBCImpl();
	    	List<MdmCurrencyVO> list = command.searchCurrencyList(event.getMdmCurrencyVO());
	    	eventResponse.setRsVoList(list);
	    } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
    	return eventResponse;
    }

    /**
     * PackageType 조회 이벤트 처리
     * PackageType 팝업 조회처리
     * @param e
     * @return
     * @throws EventException
     * @author Ji Seok Woo
     * @date 2009.04.24
     */
    private EventResponse searchPackageTypeList(Event e) throws EventException {
	  // AccountList
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
    		UiBkg0696Event event = (UiBkg0696Event)e;
	    	PackageTypeBC command = new PackageTypeBCImpl();
	    	List<PackageTypeVO> list = command.searchPackageTypeList(event.getPackageTypeVO());
	    	eventResponse.setRsVoList(list);
	    } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
    	return eventResponse;
    }
    
    /**
     * 
     * @param e
     * @return
     * @throws EventException
     */
    private EventResponse searchRevenueVVDList(Event e) throws EventException {
	  // AccountList
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
	    	UiComEnsN12Event event = (UiComEnsN12Event)e;
	    	RevenuevvdBC command = new RevenuevvdBCImpl();
	    	List<ArMstRevVvdVO> list = command.searchRevenueVVDList(event.getArMstRevVvdVO());
	    	eventResponse.setRsVoList(list);
	    } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
    	return eventResponse;
    }
    
    /**
     * Pop-up Notice User 조회
     * @param e
     * @return eventResponse
     * @throws EventException
     * @author YJ Jeon
     * @date 2014.01.28
     */
    private EventResponse searchNoticeUser(Event e) throws EventException {
	  // AccountList
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
    		ComNtc0003Event event = (ComNtc0003Event)e;
    		AgreementNoticeBC command = new AgreementNoticeBCImpl();
	    	String Count = command.searchNoticeUser(account.getUsr_id(), event.getPgm_no());
	    	eventResponse.setETCData("Count", Count);
	    } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
    	return eventResponse;
    }
    
    /**
     * Agreement List 조회
     * @param e
     * @return eventResponse
     * @throws EventException
     * @author YJ Jeon
     * @date 2014.01.28
     */
    private EventResponse searchAgreementList(Event e) throws EventException {
	  // AccountList
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
    		ComNtc0004Event event = (ComNtc0004Event)e;
    		AgreementNoticeBC command = new AgreementNoticeBCImpl();
    		List<SearchAgreementListVO> list = command.searchAgreementList(account.getUsr_id(), event.getPgm_no());
    		eventResponse.setRsVoList(list);
	    } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
    	return eventResponse;
    }
    
    /**
     * COM_NTC_0001 : System Name Combo
     * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
    private EventResponse searchSystemName(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	AgreementNoticeBC command = new AgreementNoticeBCImpl();
    	try{
	    	eventResponse.setRsVoList(command.searchSystemName());
	    } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
    	return eventResponse;
    }
    
    /**
     * COM_NTC_0001 : Office Level Combo
     * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
    private EventResponse searchOfficeLevel(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	AgreementNoticeBC command = new AgreementNoticeBCImpl();
    	try{
    		ComNtc0001Event event = (ComNtc0001Event)e;
	    	eventResponse.setRsVoList(command.searchOfficeLevel(event.getCodeNameVO()));
	    } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
    	return eventResponse;
    }

    /**
     * COM_NTC_0001 : Search User Name
     * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
    private EventResponse searchUserName(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	AgreementNoticeBC command = new AgreementNoticeBCImpl();
    	try{
    		ComNtc0001Event event = (ComNtc0001Event)e;
			String userName = command.searchUserName(event.getCodeNameVO());
			eventResponse.setETCData("user_name", userName);
	    } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
    	return eventResponse;
    }
    
    /**
     * COM_NTC_0001 : Search Office valid
     * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
    private EventResponse searchOfficeValid(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	AgreementNoticeBC command = new AgreementNoticeBCImpl();
    	try{
    		ComNtc0001Event event = (ComNtc0001Event)e;
			String officeVal = command.searchOfficeValid(event.getCodeNameVO().getCd(),event.getCodeNameVO().getNm());
			eventResponse.setETCData("officeVal", officeVal);
	    } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
    	return eventResponse;
    }
    
    /**
     * COM_NTC_0001 : Retrieve
     * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
    private EventResponse searchMailingList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	AgreementNoticeBC command = new AgreementNoticeBCImpl();
		String usr_max_knt = "";
		String svr_usr_max_knt = "";

    	try{
    		ComNtc0001Event event = (ComNtc0001Event)e;
    		usr_max_knt = JSPUtil.getNull((String)event.getAttribute("usr_max_knt"));
    		svr_usr_max_knt = JSPUtil.getNull(new AgreementNoticeUtil().searchUsrMaxKnt());
    		log.error("\n BizCommonSC -searchMailingList usr_max_knt =>  input : " + usr_max_knt + " / svr : " + svr_usr_max_knt + "<<<<<<<<");
    		if (usr_max_knt==null || usr_max_knt.trim().equals("") || !usr_max_knt.trim().equals(svr_usr_max_knt)){
    			throw new Exception("[err] usr_max_knt exception!");
    		}
    		
    		log.error("\n >>>>>>>>>>> BIZCOMMSC.searchMailingList - usr_max_knt " + usr_max_knt + "<<<<<<<<<<<<<<<<<<<<<<\n");
	    	eventResponse.setRs(command.searchMailingList(event.getSearchMailingListVO()));
	    } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
    	return eventResponse;
    }
    
    /**
     * COM_NTC_0001 : SAVE
     * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
    private EventResponse manageMailingList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	AgreementNoticeBC command = new AgreementNoticeBCImpl();
		ComNtc0001Event event = (ComNtc0001Event)e;
		String usr_max_knt = "";
		String svr_usr_max_knt = "";
    	try{
    		usr_max_knt = JSPUtil.getNull((String)event.getAttribute("usr_max_knt"));
    		svr_usr_max_knt = JSPUtil.getNull(new AgreementNoticeUtil().searchUsrMaxKnt());
    		log.error("\n BizCommonSC -manageMailingList usr_max_knt =>  input : " + usr_max_knt + " / svr : " + svr_usr_max_knt + "<<<<<<<<");
    		if (usr_max_knt==null || usr_max_knt.trim().equals("") || !usr_max_knt.trim().equals(svr_usr_max_knt)){
    			throw new Exception("[err] usr_max_knt exception!");
    		}
    		log.error("\n >>>>>>>>>>> BIZCOMMSC.manageMailingList - usr_max_knt " + usr_max_knt + "<<<<<<<<<<<<<<<<<<<<<<\n");
    		for (int i=0; usr_max_knt!=null && !usr_max_knt.trim().equals("") && event.getSearchMailingListVOs()!=null && i<event.getSearchMailingListVOs().length; i++){
    			event.getSearchMailingListVOs()[i].setUsrMaxKnt(usr_max_knt);
    		}
    		begin();
	    	command.manageMailingList(event.getSearchMailingListVOs(), account);
	    	commit();
	    } catch(EventException ex) {
	    	rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
    	return eventResponse;
    }

    /**
     * COM_NTC_0002 : Retrieve
     * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
    private EventResponse searchContractCreationUser(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	AgreementNoticeBC command = new AgreementNoticeBCImpl();
    	try{
    		ComNtc0002Event event = (ComNtc0002Event)e;
	    	List<SearchContractCreationUserVO> list = command.searchContractCreationUser(event.getSearchContractCreationUserVO());
	    	eventResponse.setRsVoList(list);
	    } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
    	return eventResponse;
    }
    
    /**
     * COM_NTC_0001 : Agreement No. Valid
     * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
    private EventResponse checkAgreementNoValid(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComNtc0001Event event = (ComNtc0001Event)e;
    	String agmt_mapg_no = "";
    	try{
    		if(event.getSearchMailingListVO().getSysCd().equals("TES")){
    			TESCommonBC command = new TESCommonBCImpl();
    			agmt_mapg_no = command.searchTesAgmtNoBasic(event.getSearchMailingListVO().getAgmtNo());
    		}else if(event.getSearchMailingListVO().getSysCd().equals("LSE")){
    			LseCommonBC command = new LseCommonBCImpl();
    			agmt_mapg_no = command.searchLessorCodeCtrtNtcInfo(event.getSearchMailingListVO().getAgmtNo());
    		}else if(event.getSearchMailingListVO().getSysCd().equals("MNR")){
    			GeneralCodeSearchMgtBC command = new GeneralCodeSearchMgtBCImpl();
    			agmt_mapg_no = command.searchMnrAgmtNoBasic(event.getSearchMailingListVO().getAgmtNo(),"");
    		}else if(event.getSearchMailingListVO().getSysCd().equals("CHS")){
    			CgmValidationBC command = new CgmValidationBCImpl();
    			agmt_mapg_no = command.searchCgmAgmtNoBasic(event.getSearchMailingListVO().getAgmtNo(),"");
    		}else if(event.getSearchMailingListVO().getSysCd().equals("MGS")){
    			CgmValidationBC command = new CgmValidationBCImpl();
    			agmt_mapg_no = command.searchCgmAgmtNoBasic(event.getSearchMailingListVO().getAgmtNo(),"");
    		}else if(event.getSearchMailingListVO().getSysCd().equals("TRS")){
    			TrsCommonBC command = new TrsCommonBCImpl();
    			agmt_mapg_no = command.searchTrsAgmtNoData(event.getSearchMailingListVO().getAgmtNo());
    		}else if(event.getSearchMailingListVO().getSysCd().equals("ACM")){
    			AGNCommAgreementBC command = new AGNCommAgreementBCImpl();
    			agmt_mapg_no = command.searchAcmAgmtNoData(event.getSearchMailingListVO().getAgmtNo());
    		}else if(event.getSearchMailingListVO().getSysCd().equals("FMS")){
    			ExternalFinderBC command = new ExternalFinderBCImpl();
    			agmt_mapg_no = command.searchContractCtrtNtcInfo(event.getSearchMailingListVO().getAgmtNo());
    		}
			eventResponse.setETCData("agmt_mapg_no", agmt_mapg_no);
	    } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
    	return eventResponse;
    }
    
    /**
     * Edit Approval Step시 Del버튼 Validation<br>
     * Approval 된 결제자는 삭제할 수 없다.<br>
     * 
     * @param e Event
     * @return EventResponse
     * @exception EventException
     * @author SHIN DONG IL
     * @date 2014.07.28
     */
    private EventResponse searchCheckApprovedStep(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComEns0T1Event event = (ComEns0T1Event)e;
    	ApprovalBC command = new ApprovalBCImpl();

    	String csr_no = "";
    	String apro_rqst_seq = "";
 
    	
        try {
        	csr_no = event.getApprovalStaffVO().getCsrNo();
        	apro_rqst_seq = event.getApprovalStaffVO().getAproRoutSeq();
        	command.searchCheckApprovedStep(csr_no,apro_rqst_seq);
        	
        } catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Approval Step"}).getMessage(), ex);
		}
        
        return eventResponse;
    }
    
    /**
     * Add버튼 클릭시 CSR Approved된 건은 결재라인 추가 못하도록 한다.<br>
     * COM_ENS_0T1
     * @param e Event
     * @return EventResponse
     * @exception EventException
     * @author SHIN DONG IL
     * @date 2014.07.29
     */
    private EventResponse searchCheckApprovedCsr(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ComEns0T1Event event = (ComEns0T1Event)e;
    	ApprovalBC command = new ApprovalBCImpl();

    	String csr_no = "";
    	
        try {
        	csr_no = event.getApprovalStaffVO().getCsrNo();
        	command.searchCheckApprovedCsr(csr_no);
			        	
        } catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Approval Step"}).getMessage(), ex);
		}
        
        return eventResponse;
    }
    
    /**
     * COM_ENS_0T1화면 Loading시 User ID OR EP ID를 조회
     * Del버튼 클릭시 자기 자신의 결재라인을 지우지 못하게 한다.<br>
     * COM_ENS_0T1
     * @param e Event
     * @return EventResponse
     * @exception EventException
     * @author SHIN DONG IL
     * @date 2014.07.29
     */
    private EventResponse searchCheckApprovalUserId(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	ApprovalBC command = new ApprovalBCImpl();
    	String ep_id = "";
        try {
        	ep_id = command.searchCheckApprovalUserId(account.getUsr_id());
        	eventResponse.setETCData("ep_id", ep_id);
			        	
        } catch(EventException ex){
			throw ex;
        } catch (Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"Search Approval Step"}).getMessage(), ex);
		}
        
        return eventResponse;
    }
    
    /**
     * COM_PPL_0001 : Retrieve
     * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
    private EventResponse searchPaperlessList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	PaperlessBC command = new PaperlessBCImpl();
    	
    	try{
    		ComPpl0001Event event = (ComPpl0001Event)e;
    		
	    	List<SearchPaperlessListVO> list = command.searchPaperlessList(event.getSearchPaperlessListVO());
	    	eventResponse.setRsVoList(list);
	    } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
    	return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     * @author Lim Jin Young
     * @date 2017.07.13
     */
   private EventResponse searchSrepList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ComEns043Event event = (ComEns043Event)e;
        try {
        	CustomerBC command = new CustomerBCImpl();
        	// custCd, custNm, ofcCd, iPage, include, cust
            eventResponse.setRsVoList(command.searchSrepList(event.getSrepCd(),event.getSrepNm(),event.getOfcCd(),event.getGloUsrId(),event.getIPage()));
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
   
   /**
    * searchLeasingCompanyYardList 조회 이벤트 처리
    * Leasing Company Yard 팝업 조회처리
    * @param e
    * @return
    * @throws EventException
    * @author KIM MIN SOO
    * @date 2012.02.21
    */
   private EventResponse searchLeasingCompanyYardList(Event e) throws EventException {
	  // AccountList
   	GeneralEventResponse eventResponse = new GeneralEventResponse();
   	try{
   		ComCom0004Event event = (ComCom0004Event)e;
   		LeasingCompanyYardBC command = new LeasingCompanyYardBCImpl();
	    	List<SearchLeasingCompanyYardListVO> list = command.searchLeasingCompanyYardList(event.getSearchLeasingCompanyYardListVO());
	    	eventResponse.setRsVoList(list);
	    } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
   	return eventResponse;
   }
   
   /**
    * 조회 이벤트 처리<br>
    * Daylight Saving Time 화면에 대한 조회 이벤트 처리<br>
    * @param e 
    * @return response EventResponse
    * @exception EventException
    * @author JunBum Lee
    * @date 2012.02.20
    */
   private EventResponse searchDaylightSavingTimeList(Event e) throws EventException {
       // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
       GeneralEventResponse eventResponse = new GeneralEventResponse();
       try {
			List<DaylightSavingTimeListVO> list = new ArrayList<DaylightSavingTimeListVO>();
			DaylightSavingTimeListVO  vo = null;
			ComCom0005Event event = null;
//			if(e.getEventName().equalsIgnoreCase("ComCom0005Event")){
				event = (ComCom0005Event)e; 
				vo = event.getDaylightSavingTimeListVO();
//			}
       	
			DaylightSavingTimeBC command = new DaylightSavingTimeBCImpl();
           list =command.searchDaylightSavingTimeList(vo, event.getIPage());
           eventResponse.setRsVoList(list);
       } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
       return eventResponse;
   }   
   
   
	/**
	 * [COM_COM_0440] Retrieve<br>
	 * Center Popup event<br>
	 * @author JKKil
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPopCenterList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		ComCom0440Event event = (ComCom0440Event) e;
		AccountPayableCommonBC command = new AccountPayableCommonBCImpl();

		try {
			List<CenterListVO> list = command.searchPopCenterListVO(event.getCenterListVO());
			eventResponse.setRsVoList(list);
			
			if ( list != null && list.size() > 0 ) {
				eventResponse.setETCData("ctr_erp_no",  list.get(0).getCtrErpNo());
				eventResponse.setETCData("ctr_desc", list.get(0).getCtrDesc());				
			} else {
				eventResponse.setETCData("ctr_erp_no", "NO_DATA");
				eventResponse.setETCData("ctr_desc", "NO_DATA");
			}			
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
   
    /**
     * searchMovementStatusList 조회 이벤트 처리
     * Movement Status Code 팝업 조회처리
     * @param e
     * @return
     * @throws EventException
     * @author KIM JONG OCK
     * @date 2012.02.20
     */
    private EventResponse searchMovementStatusList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
    		ComCom0010Event event = (ComCom0010Event)e;
    		MovementBC command = new MovementBCImpl();
	    	List<MdmMvmtStsVO> list = command.searchMovementList(event.getMdmMovementVO());
	    	
	    	eventResponse.setRsVoList(list);
	    } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
    	return eventResponse;
    }   
    
    /**
     * searchActivityList 조회 이벤트 처리
     * Activity Code 팝업 조회처리
     * @param e
     * @return
     * @throws EventException
     * @author Sangbo La
     * @date 2012.02.20
     */
    private EventResponse searchActivityList(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try{
    		ComCom0009Event event = (ComCom0009Event)e;
    		ActivityBC command = new ActivityBCImpl();
	    	List<SearchMdmActivityVO> list = command.searchActivityList(event.getSearchMdmActivityVO());
	    	
	    	eventResponse.setRsVoList(list);
	    } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex.getMessage()).getMessage(), ex);
		}
    	return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Container Type 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     * @author Jae Kwan Lim
     * @date 2018.05.23
     */
    private EventResponse searchMdmCntrTpList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        try {
        	CntrTypeBC command = new CntrTypeBCImpl();
            eventResponse = command.searchCntrTpList(e);
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
    
    /**
     * 조회 이벤트 처리<br>
     * Container Size 화면에 대한 조회 이벤트 처리<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     * @author Jae Kwan Lim
     * @date 2018.05.23
     */
    private EventResponse searchMdmCntrSzList(Event e) throws EventException {
        // 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
        EventResponse eventResponse = null;
        try {
        	CntrSizeBC command = new CntrSizeBCImpl();
            eventResponse = command.searchCntrSzList(e);
        } catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
        return eventResponse;
    }
}
