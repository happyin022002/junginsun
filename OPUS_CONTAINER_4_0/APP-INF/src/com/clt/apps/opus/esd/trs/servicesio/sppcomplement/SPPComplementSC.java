/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : SPPComplementSC.java
*@FileTitle : work order rejection
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-06
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2007-02-06 Lee Sang-Woo
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.sppcomplement;

import java.util.HashMap;

import com.clt.apps.opus.esd.trs.common.trscommon.basic.TrsCommonBC;
import com.clt.apps.opus.esd.trs.common.trscommon.basic.TrsCommonBCImpl;
import com.clt.apps.opus.esd.trs.common.trscommon.vo.TrsSOHistoryVO;
import com.clt.apps.opus.esd.trs.servicesio.sppcomplement.invoicecancelmanage.basic.InvoiceCancelManageBC;
import com.clt.apps.opus.esd.trs.servicesio.sppcomplement.invoicecancelmanage.basic.InvoiceCancelManageBCImpl;
import com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingcancelmanage.basic.RailBillingCancelManageBC;
import com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingcancelmanage.basic.RailBillingCancelManageBCImpl;
import com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingverifymanage.basic.RailBillingVerifyManageBC;
import com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingverifymanage.basic.RailBillingVerifyManageBCImpl;
import com.clt.apps.opus.esd.trs.servicesio.sppcomplement.worejectmanage.basic.WORejectManageBC;
import com.clt.apps.opus.esd.trs.servicesio.sppcomplement.worejectmanage.basic.WORejectManageBCImpl;
import com.clt.apps.opus.esd.trs.servicesio.workorder.event.ExpPap0002EventResponse;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.basic.WorkOrderPreviewBC;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.basic.WorkOrderPreviewBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.event.EsdTrs0024Event;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.vo.WorkOrderPreviewVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * ESD-TRS Business Logic ServiceCommand<br>
 * TRS에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author Lee Sang-Woo
 * @see WORejectEventResponse,WORejectManageDBDAO 참조
 * @since J2EE 1.4
 */
public class SPPComplementSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * TRS 업무 시나리오 선행작업<br>
	 * SingleTransportationSOManage업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account=getSignOnUserAccount();
		} catch (Exception e) {
			log.error("SPPComplementSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * SingleTransportationSOManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("SPPComplementSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ESD-TRS 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		//if (e.getEventName().equalsIgnoreCase("WORejectEvent")) {
		if (e.getEventName().equalsIgnoreCase("ExpPap0002Event")) {  
		    if (e.getFormCommand().isCommand(FormCommand.MULTI)) { //WORejectEvent
				eventResponse = multiWorkOrderManage(e);
			} else {
				eventResponse = null;
			}
		} else if (e.getEventName().equalsIgnoreCase("InvoiceCancelEvent")) {
		    if (e.getFormCommand().isCommand(FormCommand.MULTI)) { //InvoiceCancelEvent
				eventResponse = cancelInvoiceList(e);
			} else {
				eventResponse = null;
			}
		} else if (e.getEventName().equalsIgnoreCase("RailBillingCancelEvent")) {
		    if (e.getFormCommand().isCommand(FormCommand.MULTI)) { //RailBillingCancelEvent
				eventResponse = cancelRailBillingList(e);
			} else {
				eventResponse = null;
			}
		} else if (e.getEventName().equalsIgnoreCase("RailBillingVerifyEvent")) {
		    if (e.getFormCommand().isCommand(FormCommand.MULTI)) { //RailBillingVerifyEvent
				eventResponse = verifyRailBillingCNTRList(e);
			} else {
				eventResponse = null;
			}
		}
		
		return eventResponse;
	}


	/**
	 * 멀티 이벤트 처리<br>
	 * SingleTransportationSOManage의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiWorkOrderManage(Event e) throws EventException {
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		//EventResponse eventResponse = null;
		EventResponse eventResponse1 = null;
		ExpPap0002EventResponse eventResponse = null;
		EsdTrs0024Event event24 = null;

		int resultCount = 0;
		
		try {
			this.begin();
			WORejectManageBC command = new WORejectManageBCImpl();
			event24 = command.multiWorkOrderManage(e);

			WorkOrderPreviewBC command2 = new WorkOrderPreviewBCImpl();					
			command2.searchWorkOrderPreviewIssuedGroup(event24); // temp 에 담김.
     		eventResponse1 = command2.searchWorkOrderPreviewIssueStatus(event24);

			DBRowSet rowSet = ((GeneralEventResponse)eventResponse1).getRs();			
			event24 = command.selectWorkOrderManage(rowSet, event24);	// 2번째 multi
			
			command2.addWorkOrderPreviewIssued(event24, account);		// confirm.
			// CHM-201535923 W/O Inquiry 개선2
			WorkOrderPreviewVO wrkPrvVO  	= event24.getWorkOrderPreviewVO();

			TrsSOHistoryVO soHisVo = new TrsSOHistoryVO();
			TrsCommonBC commCommand =  new TrsCommonBCImpl();

			soHisVo.setWoPrvGrpSeq(wrkPrvVO.getWoPrvGrpSeq());
			soHisVo.setWoIssNo(wrkPrvVO.getWoIssNo());
			if( "N".equals(wrkPrvVO.getWoIssStsCd())){
				soHisVo.setTrspSoEvntCd("WC");
				soHisVo.setTrspSoHisDesc("WO Canceled");
			}else{
				soHisVo.setTrspSoEvntCd("WI");
				if( "R".equals(wrkPrvVO.getWoIssStsCd())){
					soHisVo.setTrspSoHisDesc("WO Reissued");
				}else{
					soHisVo.setTrspSoHisDesc("WO Correction");
				}
			}
			soHisVo.setCreUsrId(event24.getFormCreUsrId());
			soHisVo.setCreOfcCd(event24.getFormUsrOfcCd());
			soHisVo.setRqstSrcSysCd("SPP");
			commCommand.multiSoHistory(soHisVo);

			HashMap hashParam = event24.getHashParam();
			String wo_fax_use_flg = (String) hashParam.get("WO_FAX_USE_FLG");
			
			String usr_id = "";
			if(wo_fax_use_flg != null && wo_fax_use_flg.equals("FAX")){
// TEST				
//				ExpPap0002Event e = new ExpPap0002Event();
//				e.setWorkOrderNo("HAM3000044");
//				e.setVendorCode("132500");
//				e.setUserID("userid");
//				WorkOrderDetailSubmitRejectList[] ls = new WorkOrderDetailSubmitRejectList[1];
//				WorkOrderDetailSubmitRejectList a = new WorkOrderDetailSubmitRejectList();
//				a.setSo_no("HAM10000268");
//				a.setRejectReason("SO SO");
//				ls[0]=a;
//				e.setWorkOrderDetailSubmitRejectList(ls);
				if(account == null)
					usr_id = "SPP_IF";
				else
					usr_id = account.getUsr_id();
				
				command.faxEdiSend(event24,usr_id);
			} 	
			this.commit();
			
			/*String wo_eml_use_flg = (String) hashParam.get("WO_EML_USE_FLG");
			if(wo_eml_use_flg != null && wo_eml_use_flg.equals("EML")){
	        	begin();
	        	//E-MAIL
	        	command.emailSend(event24);
				commit();
			}*/
			
			resultCount++;
			
			eventResponse = new ExpPap0002EventResponse();
        	eventResponse.setCount(resultCount);   
		
		} catch (EventException de) {
			this.rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	

	/**
	 * cancel Invoice 멀티 이벤트 처리<br>
	 * cancelInvoiceList의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException 
	 * @exception EventException
	 */
	private EventResponse cancelInvoiceList(Event e) throws EventException {
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			begin();
			InvoiceCancelManageBC command = new InvoiceCancelManageBCImpl();
			eventResponse = command.cancelInvoiceList(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * cancel Rail Billing 멀티 이벤트 처리<br>
	 * cancelRailBillingList의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException 
	 * @exception EventException
	 */
	private EventResponse cancelRailBillingList(Event e) throws EventException {
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			begin();
			RailBillingCancelManageBC command = new RailBillingCancelManageBCImpl();
			eventResponse = command.cancelRailBillingList(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw de;
		} catch(Exception de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(), de);
		}
		return eventResponse;
	}
	
	/**
	 * Rail Billing verify 멀티 이벤트 처리<br>
	 * verifyRailBillingCNTRList의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException 
	 * @exception EventException
	 */
	private EventResponse verifyRailBillingCNTRList(Event e) throws EventException {
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			begin();
			RailBillingVerifyManageBC command = new RailBillingVerifyManageBCImpl();
			eventResponse = command.verifyRailBillingCNTRList(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw de;
		} catch(Exception de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(new ErrorHandler(de).getMessage(), de);
		}
		return eventResponse;
	}

}