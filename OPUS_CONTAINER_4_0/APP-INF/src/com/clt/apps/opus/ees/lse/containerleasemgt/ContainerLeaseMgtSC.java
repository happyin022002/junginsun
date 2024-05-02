/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ContainerLeaseMgtSC.java
*@FileTitle : Long Term Lease CNTR Delivery Plan
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.lse.containerleasemgt;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.basic.AvailableOffHireBC;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.basic.AvailableOffHireBCImpl;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.event.EesLse0020Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.event.EesLse0021Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.event.EesLse0022Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.event.EesLse0023Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.event.EesLse0101Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireConfirmVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireDetailVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireRegisterVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireSummaryVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo.AvailableOffHireYardCodeVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.immediateexit.basic.ImmediateExitBC;
import com.clt.apps.opus.ees.lse.containerleasemgt.immediateexit.basic.ImmediateExitBCImpl;
import com.clt.apps.opus.ees.lse.containerleasemgt.immediateexit.event.EesLse0025Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.immediateexit.vo.ImmediateExitCreationVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.basic.LeaseReportBC;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.basic.LeaseReportBCImpl;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.event.EesLse0036Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.event.EesLse0039Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.event.EesLse0040Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.event.EesLse0052Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.event.EesLse0053Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.event.EesLse0054Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.event.EesLse0057Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.event.EesLse0058Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.event.EesLse0087Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.event.EesLse0088Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.event.EesLse0089Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.event.EesLse0090Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.event.EesLse0092Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.event.EesLse0094Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.InventoryDetailVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.InventorySummaryVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.ReportSearchVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.SubLeaseOutDetailVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.SubLeaseOutSummaryVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.UsingDayDetailVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo.UsingDaySummaryVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.basic.MisUseApprovalBC;
import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.basic.MisUseApprovalBCImpl;
import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.event.EesLse0027Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.event.EesLse0028Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.event.EesLse0093Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.vo.MisUseContainerInfoVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.vo.MisUseInOutInquiryVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.vo.MisUseReqContainerVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.misuseapproval.vo.MisUseRequestVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.basic.OnhireApprovalBC;
import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.basic.OnhireApprovalBCImpl;
import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.event.EesLse0029Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.event.EesLse0030Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.event.EesLse0031Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.event.EesLse0032Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.event.EesLse0047Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalOwnListVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.vo.OnhireApprovalVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.vo.SearchApprovalDetailVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.onhireapproval.vo.SearchApprovalVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.termchange.basic.TermChangeBC;
import com.clt.apps.opus.ees.lse.containerleasemgt.termchange.basic.TermChangeBCImpl;
import com.clt.apps.opus.ees.lse.containerleasemgt.termchange.event.EesLse0005Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.termchange.event.EesLse0006Event;
import com.clt.apps.opus.ees.lse.containerleasemgt.termchange.vo.TermChangeCreationVO;
import com.clt.apps.opus.ees.lse.containerleasemgt.termchange.vo.TermChangeInquiryVO;
import com.clt.apps.opus.ees.lse.lsecommon.cntrtpsz.basic.ContainerTypeSizeBC;
import com.clt.apps.opus.ees.lse.lsecommon.cntrtpsz.basic.ContainerTypeSizeBCImpl;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBC;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBCImpl;
import com.clt.apps.opus.ees.mst.ruLabelmanagement.ruLabelmanagement.vo.RuLabelListVO;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.LseOnhAproVO;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;
import com.clt.apps.opus.ees.lse.lsecommon.lsecommon.vo.CdListVO;
import com.clt.apps.opus.ees.lse.lsecommon.lsecommon.basic.LseCommonBC;
import com.clt.apps.opus.ees.lse.lsecommon.lsecommon.basic.LseCommonBCImpl;


/**
 * -ContainerLeaseMgt Business Logic ServiceCommand - Handling Business Transaction of ContainerLeaseMgt 
 *
 * @author 
 * @see LeasePlanDBDAO
 * @since J2EE 1.4
 */

public class ContainerLeaseMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ContainerLeaseMgt system preceding process for biz scenario<br>
	 *  related objects creation<br>
	 */
	@Override
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getMessage());
		} 
	}

	/**
	 * ContainerLeaseMgt system biz scenario closing<br>
	 * clearing related objects<br>
	 */
	@Override
	public void doEnd() {
		log.debug("ContainerLeaseMgtSC 종료");
	}

	/**
	 * Performing Biz Scenario corresponding to each Event<br>
	 * Branch Processing for All Events of ContainerLeaseMgt system Business<br>
	 *
	 * @param   Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {

		EventResponse eventResponse = null;

		// using in case SC handles several events
		if (e.getEventName().equalsIgnoreCase("EesLse0031Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOnhireApprovalNumberService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOnhireApprovalNumberBrieflyService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0029Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createOnhireApprovalNumberService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOnhireApprovalLiftOnChargeService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchValidaionAgmtTpsz(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0030Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {

				eventResponse = searchOnhireApprovalNumber2Service(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {

				eventResponse = cancelOnhireApprovalNumberService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {

				eventResponse = modifyOnhireApprovalNumberService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchApprovalOwnListService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createApprovalOwnContainerService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAvailParamActivityDateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTermChangeCreationListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBigDataTermChangeCreationListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createTermChangeCreationListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = searchBigDataTempDataCreationListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0006Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTermChangeInquiryListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0047Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPickupStatusSummaryService(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPickupStatusDetailService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0025Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchImmediateExitCreationListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createImmediateExitCreationListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0027Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchNewMisUseRequestNumberService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMisUseReqContainerExistService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchMisUseRequestContainerService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createMisUseRequestNumberListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0028Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchNewMisUseApprovalNumberService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchMisUseRequestNoItemsService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchMisUseRequestInfoService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMisUseReqContainerListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createMisUseApprovalNumberListService(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EesLse0036Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOnHireResultbyLocationAgreementSummaryService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOnHireResultbyLocationAgreementDetailService(e);
			}else{
				eventResponse = initCompanyComboDataService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0039Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffHireResultbyLocationAgreementSummaryService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOffHireResultbyLocationAgreementDetailService(e);
			}else{
				eventResponse = initCompanyComboDataService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0093Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMisUseInOutInquiryListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyMisUseApprovalCancelListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0040Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffHireResultAvgUsingDaySummaryListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOffHireResultAvgUsingDayDetailService(e);
			}else{
				eventResponse = initCompanyComboDataService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0052Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOnHireResultbyTermLessorSummaryService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOnHireResultbyTermLessorDetailService(e);
			}else{
				eventResponse = initCompanyComboDataService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0053Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffHireResultByTermLessorSummaryService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOffHireResultByTermLessorDetailService (e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0054Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffHireResultvsDOLSummaryService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOffHireResultvsDOLDetailService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0057Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTotalContainerInventorySummaryListService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTotalContainerInventoryDetailService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0058Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchNewContainerReceivingDetailService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0094Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSubLeaseOutContainerSummaryListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSubLeaseOutContainerDetailService(e);
			} else {
				eventResponse = initCntrUseCoCdComboDataService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesLse0087Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOnHireReportbyRccSummaryService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesLse0088Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOnHireReportbyMonthSummaryService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesLse0089Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffHireReportbyRccSummaryService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesLse0090Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOffHireReportbyMonthSummaryService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesLse0020Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAvailableOffHireContainerSummaryService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = backEndAvailableOffHireContainerSummaryService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchComBackEndJobStatusService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = loadFileBackEndJobResultService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesLse0021Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAvailableOffHireContainerDetailService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = backEndAvailableOffHireContainerDetailService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchComBackEndJobStatusService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = loadFileBackEndJobResultService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = sendToEmailAvailableOffHireContainerService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = modifyAvailableOffHireContainerService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesLse0022Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAvailableOffHireContainerConfirmService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = backEndAvailableOffHireContainerConfirmService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchComBackEndJobStatusService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = loadFileBackEndJobResultService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyAvailableOffHireContainerConfirmService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesLse0023Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAvailableOffHireContainerTargetService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTargetLocationService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchTargetLocationAgreementService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = backEndAvailableOffHireContainerTargetService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyTargetOffHireContainerRegisterService(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EesLse0092Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOnHireTotalSummaryByLeaseTermYearService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesLse0101Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAvailableOffHireYardCodeListService(e);
			}
		}
		
		return eventResponse;
	}
	
    /**
	 * EES_LSE_0031 : Retrieve<br>
	 * Retrieving Approval number of Equipment which is going to be Onhire<br>
	 *
	 * @param Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOnhireApprovalNumberService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0031Event event = (EesLse0031Event)e;
			OnhireApprovalBC command = new OnhireApprovalBCImpl();
			List<OnhireApprovalVO> list = command.searchOnhireApprovalNumberBasic(event.getOnhireApprovalVO());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0031 : Onblur<br>
	 * Handling Auth No Retrieving Event about OnHireApproval Screen<br>
	 *
	 * @param Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOnhireApprovalNumberBrieflyService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0031Event event = (EesLse0031Event)e;
			OnhireApprovalBC command = new OnhireApprovalBCImpl();

			List<LseOnhAproVO> list = command.searchOnhireApprovalNumberBrieflyBasic(event.getOnhLocCd() ,event.getLstmcd() , event.getCntrOnhAuthNo());
			if(list.size() > 0 ){
				String authNo = list.get(0).getCntrOnhAuthNo();
				String lstmCd = list.get(0).getLstmCd();
				eventResponse.setETCData("cntr_onh_auth_no" , authNo);
				eventResponse.setETCData("lstm_cd" , lstmCd);
				eventResponse.setRsVoList(list);
			}
			
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}
	/**
	 * EES_LSE_0029 : Save<br>
	 * Saving detail pick-up Approval after Hire Contract of hiring Containers(Long-term, Short-term, OF)<br>
	 *
	 * @param Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse createOnhireApprovalNumberService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
 
		// Container Type/Size
		ContainerTypeSizeBC comCommand = new ContainerTypeSizeBCImpl();
		List<MdmCntrTpSzVO> cntrTpSzlist = comCommand.searchCntrTpSzListBasic();

		EesLse0029Event event = (EesLse0029Event)e;
		OnhireApprovalBC command = new OnhireApprovalBCImpl();
		OnhireApprovalVO onhireApprovalVO = new OnhireApprovalVO();
		try{
			begin();     
			onhireApprovalVO.setLocCd(event.getLocCd());
			onhireApprovalVO.setLeaseTerm(event.getLeaseTerm());
			onhireApprovalVO.setPkupFmDt(event.getPkupFmDt()); 
			onhireApprovalVO.setPkupDueDt(event.getPkupDueDt());
			onhireApprovalVO.setAproRmk(event.getAproRmk());
			onhireApprovalVO.setTpszCd(event.getTpszCd());

			String authNo = command.createOnhireApprovalNumberBasic( onhireApprovalVO, event.getOnhireApprovalVOs(),account, cntrTpSzlist);
			eventResponse.setETCData("cntr_onh_auth_no" , authNo);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
	 * EES_LSE_0030 : Retreive<br>
	 * Retrieving Approval number of Equipment which is going to be Onhire<br>
	 *
	 * @param Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOnhireApprovalNumber2Service(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0030Event event = (EesLse0030Event)e;
			OnhireApprovalBC command = new OnhireApprovalBCImpl();
			List<OnhireApprovalVO> list = command.searchOnhireApprovalNumber2Basic(event.getCntrOnhAuthNo() , event.getTysz());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}
	/**
	 * EES_LSE_0030 : Cancel<br>
	 * After Long/Short term Container hiring Contract , Handling Cancel about detail pick-up Approval when cancel implements <br>
	 *
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse cancelOnhireApprovalNumberService(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0030Event event = (EesLse0030Event)e;
		OnhireApprovalBC command = new OnhireApprovalBCImpl();
		try{
			begin();
			command.cancelOnhireApprovalNumberBasic( event.getCntrOnhAuthNo(),event.getAgmtCtyCd(),event.getAgmtSeq(),account);
		    commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0030 : Save<br>
	 * After Long/Short term Container hiring Contract, when there is change in detail pick-up Approval, Updating <br>
	 *
	 * @param  Event e
	 * @return  EventResponse response
	 * @exception EventException
	 */
	private EventResponse modifyOnhireApprovalNumberService(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		// Container Type/Size
		ContainerTypeSizeBC comCommand = new ContainerTypeSizeBCImpl();
		List<MdmCntrTpSzVO> cntrTpSzlist = comCommand.searchCntrTpSzListBasic();

		EesLse0030Event event = (EesLse0030Event)e;
		OnhireApprovalBC command = new OnhireApprovalBCImpl();
		OnhireApprovalVO onhireApprovalVO = new OnhireApprovalVO();

		try{
			onhireApprovalVO.setLocCd(event.getOnhLocCd());
			onhireApprovalVO.setLstmCd(event.getLstmcd());
			onhireApprovalVO.setPkupFmDt(event.getPkupFmDt());
			onhireApprovalVO.setPkupDueDt(event.getPkupDueDt());
			onhireApprovalVO.setAproRmk(event.getAproRmk());
			onhireApprovalVO.setTpszCd(event.getTpszCd());
			onhireApprovalVO.setCntrOnhAuthNo(event.getCntrOnhAuthNo());

			begin();
			command.modifyOnhireApprovalNumberBasic( onhireApprovalVO ,account, event.getOnhireApprovalVOs(), cntrTpSzlist);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
	 * EES_LSE_0032 : Retrieve<br>
	 * Retrieving picked up Own Containers to give Auth No <br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchApprovalOwnListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0032Event event = (EesLse0032Event)e;
			OnhireApprovalBC command = new OnhireApprovalBCImpl();
			List<OnhireApprovalOwnListVO> list = command.searchApprovalOwnListBasic(event.getLocCd() , event.getLocTp());

			List<OnhireApprovalOwnListVO> list2 = command.searchApprovalOwnSumListBasic(event.getLocCd() , event.getLocTp());


			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}

			if ( list2.size() > 0 ) {
				eventResponse.setRsVoList(list2);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0005 : Condition<br>
	 * Verifying Effectiveness about inserted Activity Date<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchAvailParamActivityDateService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0005Event event = (EesLse0005Event)e;
			TermChangeBC command = new TermChangeBCImpl();
			boolean availFlag = command.searchAvailParamActivityDateBasic(event.getSearchParamVO());

			eventResponse.setETCData("checkResult", availFlag ? "TRUE" : "FALSE");
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0005 : Retrieve<br>
	 * Retrieving Equipment List targeting to Term Change Creation<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchTermChangeCreationListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0005Event event = (EesLse0005Event)e;
			TermChangeBC command = new TermChangeBCImpl();
			List<TermChangeCreationVO> list = command.searchTermChangeCreationListBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}
	
	
	/**
	 * EES_LSE_0005 : Excel Upload<br>
	 * Retrieving Equipment List targeting to Term Change Creation<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchBigDataTermChangeCreationListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0005Event event = (EesLse0005Event)e;
			TermChangeBC command = new TermChangeBCImpl();
			List<TermChangeCreationVO> list = command.searchBigDataTermChangeCreationListBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}
	
	
	/**
	 * EES_LSE_0005 : Retrieve<br>
	 * Retrieving Equipment List targeting to Term Change Creation<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchBigDataTempDataCreationListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0005Event event = (EesLse0005Event)e;
			TermChangeBC command = new TermChangeBCImpl();
			begin(); 
			String seqValue = command.createLseTempBasic(event.getSearchParamVOs(), account);
			eventResponse.setETCData("seqValue", seqValue);
			//List<TermChangeCreationVO> list = command.searchTermChangeCreationListBasic(event.getSearchParamVO());
			//eventResponse.setRsVoList(list);
			commit();
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0005 : Save<br>
	 * Saving all Equipment list for Term Change Creation<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse createTermChangeCreationListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0005Event event = (EesLse0005Event)e;
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
		try{
			TermChangeCreationVO[] termChangeCreationVOs = event.getTermChangeCreationVOs();
			List<TermChangeCreationVO> termChangeCreationVoList = new ArrayList<TermChangeCreationVO>();
			for(int i = 0; i < termChangeCreationVOs.length; i++) {
				if(termChangeCreationVOs[i].getDelChk().equals("1")) {
					termChangeCreationVoList.add(termChangeCreationVOs[i]);
				}
			}

			begin();
			TermChangeCreationVO[] termChangeExtractVOs = termChangeCreationVoList.toArray(new TermChangeCreationVO[termChangeCreationVoList.size()]);
			command.createTermChangeCreationListBasic(termChangeCreationVoList. toArray(termChangeExtractVOs), account);
			//eventResponse.setUserMessage(new ErrorHandler("LSE10006", new String[]{"TermChangeCreationList Create"}).getMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0006 : Retrieve<br>
	 * Retrieving Term Change Creation Equipment handling record<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchTermChangeInquiryListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0006Event event = (EesLse0006Event)e;
			TermChangeBC command = new TermChangeBCImpl();
			List<TermChangeInquiryVO> list = command.searchTermChangeInquiryListBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0047 : Retrieve<br>
	 * After Long/Short term Container hiring Contract, Retrieving pick-up amount about pick-up Approval
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchPickupStatusSummaryService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0047Event event = (EesLse0047Event)e;
			OnhireApprovalBC command = new OnhireApprovalBCImpl();
			List<SearchApprovalVO> list = command.searchPickupStatusSummaryBasic(event.getSearchApprovalVO());
			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0047 : Sheet DblClick<br>
	 * After Long/Short term Container hiring Contract, Retrieving pick-up amount about pick-up Approval in dettail
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchPickupStatusDetailService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0047Event event = (EesLse0047Event)e;
			OnhireApprovalBC command = new OnhireApprovalBCImpl();
			List<SearchApprovalDetailVO> list = command.searchPickupStatusDetailBasic(event.getSearchApprovalDetailVO());
			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0025 : Retrieve<br>
	 * Retrieving Equipment List for Immediate Exit Creation <br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchImmediateExitCreationListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0025Event event = (EesLse0025Event)e;
			ImmediateExitBC command = new ImmediateExitBCImpl();
			List<ImmediateExitCreationVO> list = command.searchImmediateExitCreationListBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0025 : Save<br>
	 * Saving all Equipment list for Immediate Exit Creation <br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse createImmediateExitCreationListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0025Event event = (EesLse0025Event)e;
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
		try{
			begin();
			command.updateImmediateExitCreationListBasic(event.getImmediateExitCreationVOs(),account);
			//eventResponse.setUserMessage(new ErrorHandler("LSE10006", new String[]{"ImmediateExitCreationList Create"}).getMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0027 : Open<br>
	 * Retrieving Max Miss Use Request No.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchNewMisUseRequestNumberService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0027Event event = (EesLse0027Event)e;
			MisUseApprovalBC command = new MisUseApprovalBCImpl();
			String rqstNo = command.searchNewMisUseRequestNumberBasic(event.getOfcCd());

			if ( rqstNo != null ) {
				eventResponse.setETCData("rqst_no", rqstNo);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0027 : Condition<br>
	 * Checking duplication of request List about inserted Container No.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchMisUseReqContainerExistService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0027Event event = (EesLse0027Event)e;
			MisUseApprovalBC command = new MisUseApprovalBCImpl();

			boolean existFlag = command.searchMisUseReqContainerExistBasic(event.getCntrNo());
			eventResponse.setETCData("exist_flag", existFlag ? "TRUE" : "FALSE");
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0027 : Condition<br>
	 * Retrieving Basic information of inserted Container No.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchMisUseRequestContainerService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0027Event event = (EesLse0027Event)e;
			MisUseApprovalBC command = new MisUseApprovalBCImpl();
			List<MisUseContainerInfoVO> list = command.searchMisUseRequestContainerBasic(event.getCntrNo(),account);

			if ( list.size() == 1 ) {
				eventResponse.setETCData(list.get(0).getColumnValues());
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0027 : Save<br>
	 * Saving Miss Use Request List and Equipment List<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse createMisUseRequestNumberListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0027Event event = (EesLse0027Event)e;
		MisUseApprovalBC command = new MisUseApprovalBCImpl();

		try{
			begin();
			command.createMisUseRequestNumberListBasic(event.getMisUseRequestVO(),event.getMisUseReqContainerVOs(),account);
			//eventResponse.setUserMessage(new ErrorHandler("LSE10006", new String[]{"MissUseRequestNumberList Create"}).getMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * EES_LSE_0028 : Open<br>
	 * Retrieving Max Miss Use Approval No.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchNewMisUseApprovalNumberService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0028Event event = (EesLse0028Event)e;
			MisUseApprovalBC command = new MisUseApprovalBCImpl();
			String aproNo = command.searchNewMisUseApprovalNumberBasic(event.getOfcCd());

			if ( aproNo != null ) {
				eventResponse.setETCData("apro_no", aproNo);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0028 : Open<br>
	 * Retrieving List of Miss Use Request No. subject to approval<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchMisUseRequestNoItemsService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			MisUseApprovalBC command = new MisUseApprovalBCImpl();
			List<MisUseRequestVO> list = command.searchMisUseRequestNoItemsBasic();
			StringBuffer sRqstNo = new StringBuffer();

			for ( int i = 0 ; i < list.size() ; i++ ) {
				if ( sRqstNo.toString().equals("") ) {
					sRqstNo.append(list.get(i).getRqstNo());
				} else {
					sRqstNo.append("|").append(list.get(i).getRqstNo());
				}
			}

			eventResponse.setETCData("rqst_no", sRqstNo.toString());
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0028 : Retrieve<br>
	 * Retrieving request information of selected Request No.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchMisUseRequestInfoService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0028Event event = (EesLse0028Event)e;
			MisUseApprovalBC command = new MisUseApprovalBCImpl();
			List<MisUseRequestVO> list = command.searchMisUseRequestInfoBasic(event.getRqstNo());

			if ( list.size() == 1 ) {
				eventResponse.setETCData(list.get(0).getColumnValues());
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0028 : Retrieve<br>
	 * Retrieving Equipment List of selected Request No.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchMisUseReqContainerListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0028Event event = (EesLse0028Event)e;
			MisUseApprovalBC command = new MisUseApprovalBCImpl();
			List<MisUseReqContainerVO> list = command.searchMisUseReqContainerListBasic(event.getRqstNo(), account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0028 : Save<br>
	 * Saving Miss Uss Approval List and Equipment List<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse createMisUseApprovalNumberListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0028Event event = (EesLse0028Event)e;
		MisUseApprovalBC command = new MisUseApprovalBCImpl();

		try{
			begin();
			command.createMisUseApprovalNumberListBasic(event.getMisUseRequestVO(),event.getMisUseApprovalVO(),event.getMisUseReqContainerVOs(),account);
			//eventResponse.setUserMessage(new ErrorHandler("LSE10006", new String[]{"MissUseApprovalNumberList Create"}).getMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0036 : Retrieve<br>
	 * Retrieving hiring performance(On Equipment)
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOnHireResultbyLocationAgreementSummaryService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0036Event event = (EesLse0036Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			List<ReportSearchVO > list = command.searchOnHireResultbyLocationAgreementSummaryBasic(event.getReportSearchVO());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0036 : sheet1_OnDblClick<br>
	 * Retrieving hiring performance(On Equipment) in detail
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOnHireResultbyLocationAgreementDetailService (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0036Event event = (EesLse0036Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			List<ReportSearchVO > list = command.searchOnHireResultbyLocationAgreementDetailBasic(event.getReportSearchVO());


			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * EES_LSE_0094 : [OPEN]<br>
	 * Retrieving Combo Data<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initCompanyComboDataService(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		LseCommonBC command = new LseCommonBCImpl();
		CdListVO vo = new CdListVO();
		List<CdListVO> list = new ArrayList<CdListVO>();

		try{
            //Company List
            vo.setEdmCd("CD02500");
            list = command.searchCompanyListBasic(vo);
            eventResponse.setCustomData("COMPANY", list);
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("LSE0094",new String[]{}).getMessage(), ex);
	    }
		return eventResponse;
	}	

	/**
	 * EES_LSE_0039 : Retrieve<br>
	 * Retrieving hiring performance(Off Equipment)
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOffHireResultbyLocationAgreementSummaryService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0039Event event = (EesLse0039Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			List<ReportSearchVO > list = command.searchOffHireResultbyLocationAgreementSummaryBasic(event.getReportSearchVO());


			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0039 : sheet1_OnDblClick<br>
	 * Retrieving hiring performance(Off Equipment) in detail
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOffHireResultbyLocationAgreementDetailService (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0039Event event = (EesLse0039Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			List<ReportSearchVO > list = command.searchOffHireResultbyLocationAgreementDetailBasic(event.getReportSearchVO(), account);

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0093 : Retrieve<br>
	 * Retrieving current state of Miss Used Equipments of Own and Other Company<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchMisUseInOutInquiryListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0093Event event = (EesLse0093Event)e;
			MisUseApprovalBC command = new MisUseApprovalBCImpl();
			List<MisUseInOutInquiryVO> list = command.searchMisUseInOutInquiryListBasic(event.getSearchParamVO(), account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0040 : Retrieve<br>
	 * Retrieving avarage using performance list by Contract No. about returned hiring Equipment<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOffHireResultAvgUsingDaySummaryListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0040Event event = (EesLse0040Event)e;
			LeaseReportBC command = new LeaseReportBCImpl();
			List<UsingDaySummaryVO> list = command.searchOffHireResultAvgUsingDaySummaryListBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0040 : Summary Grid(DbClick)<br>
	 * Retrieving Using performance by hiring Equipment in detail<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOffHireResultAvgUsingDayDetailService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0040Event event = (EesLse0040Event)e;
			LeaseReportBC command = new LeaseReportBCImpl();
			List<UsingDayDetailVO> list = command.searchOffHireResultAvgUsingDayDetailBasic(event.getSearchParamVO(),account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0052 : Retrieve<br>
	 * Retrieving Hiring performance Summary of hiring Equipment(On-Hire Result by Lease Term/Lessor-Option)
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOnHireResultbyTermLessorSummaryService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0052Event event = (EesLse0052Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			List<ReportSearchVO > list = command.searchOnHireResultbyTermLessorSummaryBasic(event.getReportSearchVO());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0052 : sheet1_OnDbClick<br>
	 * Retrieving Hiring performance of hiring Equipment in detail(On-Hire Result by Lease Term/Lessor-Option)
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOnHireResultbyTermLessorDetailService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0052Event event = (EesLse0052Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			List<ReportSearchVO > list = command.searchOnHireResultbyTermLessorDetailBasic (event.getReportSearchVO());


			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * EES_LSE_0053 : Retrieve<br>
	 * Retrieving Hiring performance Summary of hiring Equipment(Off-Hire Result by Lease Term/Lessor-Option)
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOffHireResultByTermLessorSummaryService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0053Event event = (EesLse0053Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			List<ReportSearchVO > list = command.searchOffHireResultByTermLessorSummaryBasic(event.getReportSearchVO());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0053 : sheet1_OnDbClick<br>
	 * Retrieving Hiring performance of hiring Equipment in detail(Off-Hire Result by Lease Term/Lessor-Option)
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOffHireResultByTermLessorDetailService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0053Event event = (EesLse0053Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			List<ReportSearchVO > list = command.searchOffHireResultByTermLessorDetailBasic(event.getReportSearchVO(), account);


			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * EES_LSE_0054 : Retrieve<br>
	 * Retrieving Hiring performance Summary of hiring Equipment(Off-Hire Vs DOL)
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOffHireResultvsDOLSummaryService(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0054Event event = (EesLse0054Event)e;

		LeaseReportBC command = new LeaseReportBCImpl();
		List<ReportSearchVO > list = command.searchOffHireResultvsDOLSummaryBasic(event.getReportSearchVO());

		if ( list.size() > 0 ) {
	           int intRowNum = 0;
	           int intRowMax = 0;
	           //화면 속도 이슈 때문에 변경 처리
	           if (list != null && !list.isEmpty()) {
	           	
	           		List<ReportSearchVO> rList = new ArrayList<ReportSearchVO>();
	            	
	            	for (ReportSearchVO vo : list) { 
	            		//total = vo.getTotal();
	            		ReportSearchVO rVo = new ReportSearchVO();
	            		rVo.setLocation(vo.getLocation());
	            		          		
	            		rVo.setAgmtNo(vo.getAgmtNo());
	            		rVo.setDiv(vo.getDiv());  
	            		
	            		rVo.setDivTotal(vo.getDivTotal());
	            		rVo.setD2(vo.getD2());
	            		rVo.setD4(vo.getD4());
	            		rVo.setD5(vo.getD5());
	            		rVo.setD7(vo.getD7());
	            		rVo.setR2(vo.getR2());
	            		rVo.setR5(vo.getR5());
	            		rVo.setO2(vo.getO2());
	            		rVo.setO4(vo.getO4());
	            		rVo.setO5(vo.getO5());
	            		rVo.setF2(vo.getF2());
	            		rVo.setF4(vo.getF4());
	            		rVo.setF5(vo.getF5());
	            		rVo.setT2(vo.getT2());
	            		rVo.setT4(vo.getT4());
	            		rVo.setO4(vo.getO4());
	            		rVo.setO2(vo.getO2());
	            		rVo.setO5(vo.getO5());
	            		rVo.setR8(vo.getR8());
	            
	            		rVo.setAgmtCtyCd(vo.getAgmtCtyCd());
	            		rVo.setAgmtSeq(vo.getAgmtSeq());
	            		rVo.setSccCd(vo.getSccCd());
	            		
	            		intRowNum = intRowNum +1;
	            		intRowMax = intRowNum % 10000;
	            		rList.add(rVo);
	            		
	            		if(intRowMax == 0) {
	            			eventResponse.setRsVoList(rList);
	            			rList.clear();
	            		}
	            		
	            		if(intRowNum == list.size()) {
	            			eventResponse.setRsVoList(rList);
	            		}	            		
	            	}
	           }else{
	        	   eventResponse.setRsVoList(list);
	           }
			//eventResponse.setRsVoList(list);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0054 : sheet1_OnDbClick<br>
	 * Retrieving Hiring performance of hiring Equipment in detail(Off-Hire Vs DOL)
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOffHireResultvsDOLDetailService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0054Event event = (EesLse0054Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			List<ReportSearchVO > list = command.searchOffHireResultvsDOLDetailBasic(event.getReportSearchVO(), account);

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0057 : Retrieve<br>
	 * Retrieving current state of own and hiring Equipment List managed by Shiipping Company<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchTotalContainerInventorySummaryListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0057Event event = (EesLse0057Event)e;
			LeaseReportBC command = new LeaseReportBCImpl();
			List<InventorySummaryVO> list = command.searchTotalContainerInventorySummaryListBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0057 : Summary Grid(DbClick)<br>
	 * Retrieving Details of own and hiring Equipment managed by Shiipping Company<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchTotalContainerInventoryDetailService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0057Event event = (EesLse0057Event)e;
			LeaseReportBC command = new LeaseReportBCImpl();
			List<InventoryDetailVO> list = command.searchTotalContainerInventoryDetailBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0058 : Retrieve<br>
	 * Retrieving new Container receiving List
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchNewContainerReceivingDetailService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0058Event event = (EesLse0058Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			List<ReportSearchVO> list = command.searchNewContainerReceivingDetailBasic(event.getReportSearchVO());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
				ReportSearchVO temp = list.get(0);
				eventResponse.setETCData("data_cnt", temp.getGTtl());
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0094 : Retrieve<br>
	 * Retrieving current state of Sub Lease own Equipment and Miss Use hiring Equipment<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchSubLeaseOutContainerSummaryListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0094Event event = (EesLse0094Event)e;
			LeaseReportBC command = new LeaseReportBCImpl();
			List<SubLeaseOutSummaryVO> list = command.searchSubLeaseOutContainerSummaryListBasic(event.getSearchParamVO(),account );
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0094_01 : Summary Grid(DbClick)<br>
	 * Retrieving Details of Sub Lease own Equipment and Miss Use hiring Equipment<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchSubLeaseOutContainerDetailService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0094Event event = (EesLse0094Event)e;
			LeaseReportBC command = new LeaseReportBCImpl();
			List<SubLeaseOutDetailVO> list = command.searchSubLeaseOutContainerDetailBasic(event.getSearchParamVO(), account);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_LSE_0094 : [OPEN]<br>
	 * Retrieving Combo Data<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse initCntrUseCoCdComboDataService(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		LseCommonBC command = new LseCommonBCImpl();
		CdListVO vo = new CdListVO();
		List<CdListVO> list = new ArrayList<CdListVO>();

		try{
            //Container Use Company List
            vo.setEdmCd("CD02500");
            list = command.searchCntrUseCoCdListBasic(vo);
            eventResponse.setCustomData("CNTR_USE_CO_CD", list);
		}catch(EventException ex){
	        throw ex;
	    }catch(Exception ex){
	        throw new EventException(new ErrorHandler("LSE0094",new String[]{}).getMessage(), ex);
	    }
		return eventResponse;
	}

	/**
	 * EES_LSE_0034 : Save<br>
	 * Updating Contaeinr Number to OW Term Container which is On hire Approval <br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse createApprovalOwnContainerService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0032Event event = (EesLse0032Event)e;
		ContainerOnOffhireBC command = new ContainerOnOffhireBCImpl();
		try{
			begin();
			command.updateAuthNoBasic(event.getOnhireApprovalOwnListVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("LSE10006", new String[]{""}).getMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * EES_LSE_0087 : Retrieve<br>
	 * Retrieving Hireing performance by RCC
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOnHireReportbyRccSummaryService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0087Event event = (EesLse0087Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			List<ReportSearchVO > list = command.searchOnHireReportbyRccSummaryBasic(event.getReportSearchVO());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0088 : Retrieve<br>
	 * Retrieving Monthly Hiring performance 
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOnHireReportbyMonthSummaryService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0088Event event = (EesLse0088Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			List<ReportSearchVO > list = command.searchOnHireReportbyMonthSummaryBasic(event.getReportSearchVO());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0089 : Retrieve<br>
	 * Retrieving Return Performance by RCC
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOffHireReportbyRccSummaryService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0089Event event = (EesLse0089Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			List<ReportSearchVO > list = command.searchOffHireReportbyRccSummaryBasic(event.getReportSearchVO());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0090 : Retrieve<br>
	 * Retrieving monthly return performance 
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOffHireReportbyMonthSummaryService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0090Event event = (EesLse0090Event)e;

			LeaseReportBC command = new LeaseReportBCImpl();
			List<ReportSearchVO > list = command.searchOffHireReportbyMonthSummaryBasic(event.getReportSearchVO());

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0029 : Retrieve<br>
	 * Handling Event retrieving Lift On Charge information of Equipment which is going to be Onhire
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOnhireApprovalLiftOnChargeService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0029Event event = (EesLse0029Event)e;

			OnhireApprovalBC  command = new OnhireApprovalBCImpl();

			List<OnhireApprovalVO> list = command.searchOnhireApprovalLiftOnChargeBasic(event.getOnhireApprovalVO());
			eventResponse.setETCData("rowCnt" , list.size() + "");

			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0020 : Retrieve<br>
	 * Retrieving current state of equipment possible to return by Region<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchAvailableOffHireContainerSummaryService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0020Event event = (EesLse0020Event)e;
			AvailableOffHireBC command = new AvailableOffHireBCImpl();
			List<AvailableOffHireSummaryVO> list = command.searchAvailableOffHireContainerSummaryBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0020 : Retrieve - BackEndJob<br>
	 * Requesting current state of equipment possible to return by Region<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse backEndAvailableOffHireContainerSummaryService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0020Event event = (EesLse0020Event)e;
			AvailableOffHireBC command = new AvailableOffHireBCImpl();
			String status = command.backEndAvailableOffHireContainerSummaryBasic(event.getSearchParamVO(), account);
			eventResponse.setETCData("BackEndJobKey", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0021 : Retrieve<br>
	 * Retrieving details of equipment available to return <br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchAvailableOffHireContainerDetailService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0021Event event = (EesLse0021Event)e;
			AvailableOffHireBC command = new AvailableOffHireBCImpl();
			List<AvailableOffHireDetailVO> list = command.searchAvailableOffHireContainerDetailBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0021 : Retrieve - BackEndJob<br>
	 * Requesting details of equipment available to return<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse backEndAvailableOffHireContainerDetailService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0021Event event = (EesLse0021Event)e;
			AvailableOffHireBC command = new AvailableOffHireBCImpl();
			String status = command.backEndAvailableOffHireContainerDetailBasic(event.getSearchParamVO(), account);
			eventResponse.setETCData("BackEndJobKey", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0021 : E-mail<br>
	 * Sending details of selected equipment available to return by Email<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse sendToEmailAvailableOffHireContainerService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0021Event event = (EesLse0021Event)e;
		AvailableOffHireBC command = new AvailableOffHireBCImpl();
		try{
			begin();
			command.sendToEmailAvailableOffHireContainerBasic(event.getEmailSendInfoVO(), event.getAvailableOffHireDetailVOs(), account);
			//eventResponse.setUserMessage(new ErrorHandler("LSE10006", new String[]{"EmailAvailableOffHireContainer SendTo"}).getMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_LSE_0021 : Save Only<br>
	 * modify status of selected equipment available to return<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse modifyAvailableOffHireContainerService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0021Event event = (EesLse0021Event)e;
		AvailableOffHireBC command = new AvailableOffHireBCImpl();
		try{
			begin();
			command.modifyAvailableOffHireContainerBasic(event.getAvailableOffHireDetailVOs(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0022 : Retrieve<br>
	 * Retrieving current state of confirmed equipments available to return<br>
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchAvailableOffHireContainerConfirmService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0022Event event = (EesLse0022Event)e;
			AvailableOffHireBC command = new AvailableOffHireBCImpl();
			List<AvailableOffHireConfirmVO> list = command.searchAvailableOffHireContainerConfirmBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0022 : Retrieve - BackEndJob<br>
	 * Requesting current state of confirmed equipments available to return by region<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse backEndAvailableOffHireContainerConfirmService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0022Event event = (EesLse0022Event)e;
			AvailableOffHireBC command = new AvailableOffHireBCImpl();
			String status = command.backEndAvailableOffHireContainerConfirmBasic(event.getSearchParamVO(), account);
			eventResponse.setETCData("BackEndJobKey", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0022 : Save<br>
	 * Saving detail of selected Equipment as return confirmed data <br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse modifyAvailableOffHireContainerConfirmService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0022Event event = (EesLse0022Event)e;
		AvailableOffHireBC command = new AvailableOffHireBCImpl();

		try{
			begin();
			command.modifyAvailableOffHireContainerConfirmBasic(event.getAvailableOffHireConfirmVOs(), account);
			//eventResponse.setUserMessage(new ErrorHandler("LSE10006", new String[]{"AvailableOffHireContainerConfirm Modify"}).getMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0023 : Retrieve<br>
	 * Retrieving current state of confirmed equipments available to return<br>
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	*/
	
	private EventResponse searchAvailableOffHireContainerTargetService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0023Event event = (EesLse0023Event)e;
			AvailableOffHireBC command = new AvailableOffHireBCImpl();
			List<AvailableOffHireRegisterVO> list = command.modifyAvailableOffHireContainerTargetBasic(event.getAvailableOffHireRegisterVO());
			eventResponse.setRsVoList(list);
			//eventResponse.setETCData(list.get(0).getColumnValues());
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * EES_LSE_0023 : Retrieve - BackEndJob<br>
	 * Requesting current state of confirmed equipments available to return by region<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
 */	
	private EventResponse backEndAvailableOffHireContainerTargetService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0023Event event = (EesLse0023Event)e;
			AvailableOffHireBC command = new AvailableOffHireBCImpl();
			String status = command.backEndAvailableOffHireContainerTargetBasic(event.getSearchParamVO(), account);
			eventResponse.setETCData("BackEndJobKey", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0023 : Save<br>
	 * Saving detail of selected Equipment as return confirmed data <br>
	 *
	 * @param Event e
	 * @exception EventException
	 */
	private EventResponse modifyTargetOffHireContainerRegisterService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0023Event event = (EesLse0023Event)e;
			AvailableOffHireBC command = new AvailableOffHireBCImpl();
			AvailableOffHireRegisterVO[] availableOffHireRegisterVOs = event.getAvailableOffHireRegisterVOs();
			begin();			
			command.modifyTargetOffHireContainerRegisterBasic(availableOffHireRegisterVOs, account);
			commit();
			return eventResponse;
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * EES_LSE_0023 : Save<br>
	 * Saving detail of selected Equipment as return confirmed data <br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchTargetLocationAgreementService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0023Event event = (EesLse0023Event)e;
			AvailableOffHireBC command = new AvailableOffHireBCImpl();
			List<AvailableOffHireRegisterVO> list = command.searchTargetOffHireContainerAgreementBasic(event.getAvailableOffHireRegisterVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_LSE_0023_POP : Retrieve<br>
	 * Target Off-Hire Location <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchTargetLocationService(Event e) throws EventException {			
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			EesLse0023Event event = (EesLse0023Event)e;
			AvailableOffHireBC command = new AvailableOffHireBCImpl();
			List<AvailableOffHireRegisterVO> list = command.searchAvailableTargetLocationBasic(event.getAvailableOffHireRegisterVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}			
		return eventResponse;			
	}
	

	/**
	 * EES_LSE_0092 : retrieve<br>
	 * Retrieving Performance comparing with Plan for taking over Owned and Long term equipment by Year/Contract
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchOnHireTotalSummaryByLeaseTermYearService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0092Event event = (EesLse0092Event)e;   

			LeaseReportBC command = new LeaseReportBCImpl();
			List<ReportSearchVO > list = command.searchOnHireTotalSummaryByLeaseTermYearBasic(event.getReportSearchVO());
 
			if ( list.size() > 0 ) {
				eventResponse.setRsVoList(list);
			}
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0093 : Cancel<br>
	 * Cancelling all Miss Use Approval Equipment List.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse modifyMisUseApprovalCancelListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesLse0093Event event = (EesLse0093Event)e;
		MisUseApprovalBC command = new MisUseApprovalBCImpl();

		try{
			begin();
			command.modifyMisUseApprovalCancelListBasic(event.getMisUseInOutInquiryVOs(), account);
			//eventResponse.setUserMessage(new ErrorHandler("LSE10006", new String[]{"MisUseApprovalCancelList Modify"}).getMessage());
			commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0020/EES_LSE_0021/EES_LSE_0022 : BackEndJob<br>
	 * Retrieving state value about result of BackEndJob<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchComBackEndJobStatusService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			AvailableOffHireBC command = new AvailableOffHireBCImpl();
			String key = (String)e.getAttribute("KEY");

			String status = command.searchComBackEndJobStatusBasic(key);
			eventResponse.setETCData("jb_sts_flg", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_LSE_0020/EES_LSE_0021/EES_LSE_0022 : BackEndJob<br>
	 * Loading files generated by implementation of BackEndJob<br>
	 *
	 * @param Event e
	 * @return EventResponse eventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse loadFileBackEndJobResultService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String key = (String)e.getAttribute("KEY");
		List list = null;

		try {
			if(e.getEventName().equalsIgnoreCase("EesLse0020Event")) {
				list = (List<AvailableOffHireSummaryVO>)BackEndJobResult.loadFromFile(key);
			} else if(e.getEventName().equalsIgnoreCase("EesLse0021Event")) {
				list = (List<AvailableOffHireDetailVO>)BackEndJobResult.loadFromFile(key);
			} else if(e.getEventName().equalsIgnoreCase("EesLse0022Event")) {
				list = (List<AvailableOffHireConfirmVO>)BackEndJobResult.loadFromFile(key);
			}
			
			if(list != null) {
				eventResponse.setRsVoList(list);
			}
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_LSE_0101 : Retrieve<br>
	 * Retrieving Code List of AvailableOffHire Yard <br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchAvailableOffHireYardCodeListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesLse0101Event event = (EesLse0101Event)e;
			AvailableOffHireBC command = new AvailableOffHireBCImpl();
			List<AvailableOffHireYardCodeVO> list = command.searchAvailableOffHireYardCodeListBasic(event.getSearchParamVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("LSE10005",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_LSE_0029 &EES_LSE_0030 : Retrieve<br>
	 * Validaion Agmt`s Tp/sz <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */	
	private EventResponse searchValidaionAgmtTpsz(Event e) throws EventException {		 	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			EesLse0029Event event = (EesLse0029Event)e;
			OnhireApprovalBC command = new OnhireApprovalBCImpl();	
			
			String cntrTpszCd = command.searchValidaionAgmtTpsz(event.getOnhireApprovalVO());	
			
			if ( cntrTpszCd != null  ) {
				eventResponse.setETCData("cntr_tpsz_cd", cntrTpszCd);
			}
	
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}			
	
		return eventResponse;			
	}
	
	
}