/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodeManageSC.java
*@FileTitle : TRS CodeManagement
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.16
*@LastModifier : 유선오
*@LastVersion :  1.6
*2009.05.20 kimjin
* 1.0 최초 생성
* ----------------------------------------------------------------------------------------------------------------------------------------------
* History
* 2009.05.20 kimjin 1.1 N200905150040 [TRS]USA RAIL YARD 정보 저장 화면 개발
* 2010.09.17 최 선   1.2 [] SAVE시, Distance 중복 등록  현상 처리
* 2011.03.14 손은주 1.3[CHM-201109256][TRS] Actual customer 상의 중복 Default 지정 Block 요청
* 2011.07.20 김영철 1.4[CHM-201111871][TRS] R4J 소스 품질 조치 내역 수정
* 2011.11.09 유선오 1.5[CHM-201114273][TRS] Invoice 권한등록 프로그램 개발
* 2011.11.16 유선오 1.6[CHM-201114273][TRS] R4J 소스 품질 조치 내역 수정 :Line.No 161 빈 Block 문장들(if, for, while, do)을 점검. Line No.393 메소드 주석을 기술
* 2013.04.22 조인영 [CHM-201323767][TRS] US 204 EDI Setup 신규 화면 개발
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage;


import com.hanjin.apps.alps.esd.trs.codemanage.cnt.basic.CustomerNominatedTruckerRgstBC;
import com.hanjin.apps.alps.esd.trs.codemanage.cnt.basic.CustomerNominatedTruckerRgstBCImpl;
import com.hanjin.apps.alps.esd.trs.codemanage.cnt.event.EsdTrs0086Event;
import com.hanjin.apps.alps.esd.trs.codemanage.commoditygroupcodemanage.basic.CommodityGroupCodeManageBC;
import com.hanjin.apps.alps.esd.trs.codemanage.commoditygroupcodemanage.basic.CommodityGroupCodeManageBCImpl;
import com.hanjin.apps.alps.esd.trs.codemanage.controlofficeexceptioncasemanage.basic.ControlOfficeExceptionCaseManageBC;
import com.hanjin.apps.alps.esd.trs.codemanage.controlofficeexceptioncasemanage.basic.ControlOfficeExceptionCaseManageBCImpl;
import com.hanjin.apps.alps.esd.trs.codemanage.controlofficeexceptioncasemanage.event.EsdTrs0079Event;
import com.hanjin.apps.alps.esd.trs.codemanage.distancecreation.basic.DistanceCreationBC;
import com.hanjin.apps.alps.esd.trs.codemanage.distancecreation.basic.DistanceCreationBCImpl;
import com.hanjin.apps.alps.esd.trs.codemanage.distancecreation.event.EsdTrs0080Event;
import com.hanjin.apps.alps.esd.trs.codemanage.donotificationreport.basic.DoNotificationReportBC;
import com.hanjin.apps.alps.esd.trs.codemanage.donotificationreport.basic.DoNotificationReportBCImpl;
import com.hanjin.apps.alps.esd.trs.codemanage.donotificationreport.event.EsdTrs0291Event;
import com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.basic.DoNotificationSettingBC;
import com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.basic.DoNotificationSettingBCImpl;
import com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.event.EsdTrs0290Event;
import com.hanjin.apps.alps.esd.trs.codemanage.invoiceofficeauthoritymanagement.basic.InvOfcAtrtMgmtBC;
import com.hanjin.apps.alps.esd.trs.codemanage.invoiceofficeauthoritymanagement.basic.InvOfcAtrtMgmtBCImpl;
import com.hanjin.apps.alps.esd.trs.codemanage.invoiceofficeauthoritymanagement.event.EsdTrs0976Event;
import com.hanjin.apps.alps.esd.trs.codemanage.invoiceofficeauthoritymanagement.vo.InvoiceOfficeAuthorityManagementVO;
import com.hanjin.apps.alps.esd.trs.codemanage.us204edisetup.basic.US204EDISetupBC;
import com.hanjin.apps.alps.esd.trs.codemanage.us204edisetup.basic.US204EDISetupBCImpl;
import com.hanjin.apps.alps.esd.trs.codemanage.us204edisetup.event.EsdTrs0085Event;
import com.hanjin.apps.alps.esd.trs.codemanage.usaactualcustomercodemanage.basic.USAActualCustomerCodeManageBC;
import com.hanjin.apps.alps.esd.trs.codemanage.usaactualcustomercodemanage.basic.USAActualCustomerCodeManageBCImpl;
import com.hanjin.apps.alps.esd.trs.codemanage.usaactualcustomercodemanage.event.EsdTrs0082Event;
import com.hanjin.apps.alps.esd.trs.codemanage.usadeliveryordermanage.basic.USADeliveryOrderManageBC;
import com.hanjin.apps.alps.esd.trs.codemanage.usadeliveryordermanage.basic.USADeliveryOrderManageBCImpl;
import com.hanjin.apps.alps.esd.trs.codemanage.usadeliveryordermanage.event.EsdTrs0083Event;
import com.hanjin.apps.alps.esd.trs.codemanage.usalastcitymanage.basic.USALastCityManageBC;
import com.hanjin.apps.alps.esd.trs.codemanage.usalastcitymanage.basic.USALastCityManageBCImpl;
import com.hanjin.apps.alps.esd.trs.codemanage.usalastcitymanage.event.EsdTrs0076Event;
import com.hanjin.apps.alps.esd.trs.codemanage.usarailyardmanage.basic.UsaRailYardManageBC;
import com.hanjin.apps.alps.esd.trs.codemanage.usarailyardmanage.basic.UsaRailYardManageBCImpl;
import com.hanjin.apps.alps.esd.trs.codemanage.usarailyardmanage.event.EsdTrs0084Event;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.apps.alps.esd.trs.codemanage.cnt.basic.CustomerNominatedTruckerAproBC;
import com.hanjin.apps.alps.esd.trs.codemanage.cnt.basic.CustomerNominatedTruckerAproBCImpl;
import com.hanjin.apps.alps.esd.trs.codemanage.cnt.event.EsdTrs0087Event;
import com.hanjin.apps.alps.esd.trs.codemanage.specialcargoavailable.basic.SpecialCargoAvailableBC;
import com.hanjin.apps.alps.esd.trs.codemanage.specialcargoavailable.basic.SpecialCargoAvailableBCImpl;
import com.hanjin.apps.alps.esd.trs.codemanage.specialcargoavailable.event.EsdTrs0088Event;
//import com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.event.EsdTrs0290Event;
//import com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.basic.DoNotificationSettingBC;
//import com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.basic.DoNotificationSettingBCImpl;

/**
 * ESD-TRS Business Logic ServiceCommand<br>
 * - ESD-TRS에 대한 비지니스 트랜잭션을 처리한다.<br>
 * 
 * @author kimjin
 * @see ESD_TRS_076EventResponse,UsaLastCityManagementDBDAO 참조
 * @since J2EE 1.6
 */

public class CodeManageSC extends ServiceCommandSupport {
	// Login User Information
	@SuppressWarnings("unused")
	private SignOnUserAccount account = null;

	/**
	 * TRS 업무 시나리오 선행작업<br>
	 * USALastCityManage업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		try {
			// 일단 comment --> 로그인 체크 부분
			account=getSignOnUserAccount();
		} catch (Exception e) {
			log.error("ESD_TRS_0076SC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * TRS 업무 시나리오 마감작업<br>
	 * UsaLastCityManagement업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("ESD_TRS_0076SC 종료");
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
		EventResponse eventResponse = null;
		
		if (e.getEventName().equalsIgnoreCase("EsdTrs0076Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUSALastCityManageList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiUSALastCityManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchLocalCodeManage(e);	
			} else {
				//eventResponse = searchUSALastCityManageList(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsdTrs0079Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchControlOfficeExceptionCaseManageList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiControlOfficeExceptionCaseManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchYardCodeManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCountryCodeManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchControlOfficeCodeManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchEquipmentSZ(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchEquipmentTP(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = verifyControlOfficeCD(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				// 5. Login 오피스 기준 상위 오피스가 하위 오피스 등록 권한을 가지며 동일한 레벨의 오피스 data는 등록 및 수정 불가
				eventResponse = verifySOOfficeCD(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsdTrs0075Event")) {		
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCommodityGroupCodeManageList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMdm_commodity(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchrep_commodity(e);		
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = search_commodity(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchCmdtCd(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = search_vndr_commodity(e);		
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = search_sub_commodity(e);					
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multi_vndr_commodity(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multi_delete_commodity(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = multi_part_commodity(e);				
			} else {
				//eventResponse = searchCommodityGroupCodeManageList();
			}
		}		
			
		if (e.getEventName().equalsIgnoreCase("EsdTrs0080Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDistanceCreation(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDistanceCreationDuple(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchDistanceHistory(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiDistanceCreation(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiDistanceCreationhis(e);		
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = multiDistanceDelete(e);		
			} else {
				//eventResponse = searchDistanceCreationList();
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsdTrs0082Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUSAActualCustomerCodeManageList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUSAActualCustomerCodeManage(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchUSAActualCustomerName(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchUSAActualCustomerCodeExcel(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchUSAActualCustomerNo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchUSAActualCustomerCheck(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiUSAActualCustomerCodeManageList(e);
			}else {
				//eventResponse = searchUSAActualCustomerCodeManageList(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsdTrs0083Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUSDeliveryOrderConsigneeManage(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUSADeliveryOrderManageList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchUSADeliveryOrderCheck(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiUSADeliveryOrderManage(e);	
			}else {
				//eventResponse = searchUSAActualCustomerCodeManageList(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTrs0976Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {	
				eventResponse = searchInvOfcAtrtMgmtList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {	
				eventResponse = searchOfficeCode(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiInvoiceOfficeAuthorityManagement(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeInvoiceOffice(e);
			}else {
		     return eventResponse;
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTrs0084Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUsaRailYardManage(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiUsaRailYardManage(e);	
			}else {		
				return eventResponse;
	        }			
	    }
		if (e.getEventName().equalsIgnoreCase("EsdTrs0085Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUS204EDISetupList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchUS204EDISetupVndr(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiUS204EDISetup(e);	
			} else {
				//eventResponse = searchUSALastCityManageList(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsdTrs0086Event")) {
			
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchDtDiv(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCntRgst(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchRepYd(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchTrucker(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchCust(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchContractInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchSpNameByScacCd(e);	
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiCntRgst(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = updateCntAproRqst(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = deleteCnt(e);
			}
		}
		
		if(e.getEventName().equalsIgnoreCase("EsdTrs0087Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { //(ESD_TRS_0087) - CNT(Customer Nominated Trucker) Approval 조회 
				eventResponse = searchDtAproDiv(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){ //(ESD_TRS_0087) - Date/Status Combo
				eventResponse = searchCntApproval(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH04)){ //(ESD_TRS_0087) - mty_pkup_rtn_yd_nm 조회
				eventResponse = searchMtRtnYdNm(e);	
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)){ //(ESD_TRS_0087) - Search AGMT No
				eventResponse = searchAgmtNo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH06)){ //(ESD_TRS_0087) - Search AGMT No
				eventResponse = searchCntVendorCheck(e);	
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH07)){ //(ESD_TRS_0087) - Search Door Yard Name	
				eventResponse = searchCntAproDorYdNm(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH08)){ //(ESD_TRS_0087) - Search Door Location Name	
				eventResponse = searchCntAproDorLocNm(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {	//(ESD_TRS_0087) - Save 
				eventResponse = updateCntAproSave(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {	//(ESD_TRS_0087) - Reject
				eventResponse = updateCntRjct(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) {	//(ESD_TRS_0087) - Approval
				eventResponse = updateCntApro(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) {	//(ESD_TRS_0087) - Cancel
				eventResponse = updateCntCxl(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {	//(ESD_TRS_0087) - Save
				eventResponse = saveCntApro(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY05)) {	//(ESD_TRS_0087) - Delete
				eventResponse = updateCntDel(e);
			}
		}
		
		
		if(e.getEventName().equalsIgnoreCase("EsdTrs0088Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { 			//(ESD_TRS_0088) - Special Cargo Available S/P 조회 
				eventResponse = searchSpecialCargoAvailableList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { 	//(ESD_TRS_0088) - Special Cargo Available S/P : 그리드에 입력한 S/P 유효한지 체크 
				eventResponse = searchVendorCheck(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { 	//(ESD_TRS_0088) - Special Cargo Available S/P 조회 : 그리드에 입력한 OFFFICE가 유효한지 체크
				eventResponse = searchSoCreOfc(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { 		//(ESD_TRS_0088) - Special Cargo Available S/P 저장 
				eventResponse = multiSpecialCargoAvailable(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) { 		//(ESD_TRS_0088) - Special Cargo Available S/P 저장 
				eventResponse = removeSpecialCargoAvailable(e);	
			}
		}
		
		if(e.getEventName().equalsIgnoreCase("EsdTrs0290Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { 			//(ESD_TRS_0290) - D/O notification setting 조회 
				eventResponse = searchDoNotificationSetting(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { 	//(ESD_TRS_0290) - 그리드 SC 정보조회:  
				eventResponse = searchDoScNo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { 	//(ESD_TRS_0290) - Dor Yard Name 조회
				eventResponse = searchDorYdNm(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { 		//(ESD_TRS_0290) - D/O notification setting 저장 
				eventResponse = multiDoScNo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) { 		//(ESD_TRS_0290) - D/O notification setting 삭제
				eventResponse = removeDoNotificationSetting(e);	
			}
		}
		
		if(e.getEventName().equalsIgnoreCase("EsdTrs0291Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDoNotificationReportList(e);
			}
		}
		
		    return eventResponse;	
  }

	/**
	 * 멀티 이벤트 처리<br>
	 * InvoiceOfficeAuthorityManagement 화면에 대한 저장 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiInvoiceOfficeAuthorityManagement(Event e) throws EventException{
		EsdTrs0976Event event = (EsdTrs0976Event)e;
		EventResponse eventResponse = null;
    	try {
			begin();
			InvOfcAtrtMgmtBC command = new InvOfcAtrtMgmtBCImpl();
			eventResponse = command.multiInvoiceOfficeAuthorityManagement(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Invoice office Authority Management 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	//invoice office management List 에 대한 화면조회 리스트  search20
    private EventResponse searchInvOfcAtrtMgmtList(Event e) throws EventException{
    	EsdTrs0976Event event = (EsdTrs0976Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			InvOfcAtrtMgmtBC command = new InvOfcAtrtMgmtBCImpl();
			eventResponse = command.searchInvOfcAtrtMgmtList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
    
    /**
	 * 조회 이벤트 처리<br>
	 *  Invoice office Authority Management 화면의 OFFICECODE조회시 OFFICE ENGLISH NAME 불러오는 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	
	private EventResponse searchOfficeCode(Event e) throws EventException{
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0976Event event = (EsdTrs0976Event)e;
		
    	InvoiceOfficeAuthorityManagementVO vo=null;
		try {
			InvOfcAtrtMgmtBC command = new InvOfcAtrtMgmtBCImpl();
			vo = command.searchOfficeCode(event);
			String ofcEngName = vo.getOfcEngNm();
			eventResponse.setETCData("ofcEngName", ofcEngName);
			eventResponse.setRsVo(vo);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
    
    /**
	 * 삭제 이벤트 처리<br>
	 * Invoice office Authority Management 화면에 대한 삭제 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeInvoiceOffice(Event e) throws EventException{
		EsdTrs0976Event event = (EsdTrs0976Event)e;
		EventResponse eventResponse = null;
		try {
			begin();
			InvOfcAtrtMgmtBC command = new InvOfcAtrtMgmtBCImpl();
			eventResponse = command.removeInvoiceOffice(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * UsaLastCityManagement 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSALastCityManageList(Event e) throws EventException {	
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0076Event event = (EsdTrs0076Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
	
		try {
			USALastCityManageBC command = new USALastCityManageBCImpl();
			eventResponse = command.searchUSALastCityManageList(event);
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
   
	
	/**
	 * 멀티 이벤트 처리<br>
	 * UsaLastCityManagement의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiUSALastCityManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			begin();
			USALastCityManageBC command = new USALastCityManageBCImpl();
			command.multiUSALastCityManage(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * InvoiceOfficeManagementManagement 화면에 대한 조회 이벤트 처리<br>
	 * @param e
	 * @return
	 * @throws EventException
	 */
	public EventResponse searchInvOfcAtrtMgmt(Event e) throws EventException {	
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0976Event event = (EsdTrs0976Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			InvOfcAtrtMgmtBC command = new InvOfcAtrtMgmtBCImpl();
			eventResponse = command.searchInvOfcAtrtMgmtList(event);
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * SEARCH01 이벤트 처리<br>
	 * CodeManage의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchLocalCodeManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//ESD_TRS_076Event event = (ESD_TRS_076Event)e;
		//사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {			
			USALastCityManageBC command = new USALastCityManageBCImpl();
			eventResponse = command.searchLocalCodeManage(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	

	
	/**
	 * 조회 이벤트 처리<br>
	 * ControlOfficeExceptionCaseManage의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchControlOfficeExceptionCaseManageList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0079Event event = (EsdTrs0079Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			ControlOfficeExceptionCaseManageBC command = new ControlOfficeExceptionCaseManageBCImpl();
			eventResponse = command.searchControlOfficeExceptionCaseManageList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * ControlOfficeExceptionCaseManage의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiControlOfficeExceptionCaseManage(Event e) throws EventException {
		try {
			begin();
			ControlOfficeExceptionCaseManageBC command = new ControlOfficeExceptionCaseManageBCImpl();
			command.multiControlOfficeExceptionCaseManage(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return this.searchControlOfficeExceptionCaseManageList(e);
	}
	
	/**
	 * SEARCH01 이벤트 처리<br>
	 * CodeManage의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchYardCodeManage(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			ControlOfficeExceptionCaseManageBC command = new ControlOfficeExceptionCaseManageBCImpl();
			eventResponse = command.searchYardCodeManage(e);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}		
		return eventResponse;
	}
	
	/**
	 * SEARCH02 이벤트 처리<br>
	 * CodeManage의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCountryCodeManage(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			ControlOfficeExceptionCaseManageBC command = new ControlOfficeExceptionCaseManageBCImpl();
			eventResponse = command.searchCountryCodeManage(e);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}		
		return eventResponse;
	}
	
	/**
	 * SEARCH02 이벤트 처리<br>
	 * CodeManage의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEquipmentSZ(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			ControlOfficeExceptionCaseManageBC command = new ControlOfficeExceptionCaseManageBCImpl();
			eventResponse = command.searchEquipmentSZ(e);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}		
		return eventResponse;
	}
	
	/**
	 * SEARCH02 이벤트 처리<br>
	 * CodeManage의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchEquipmentTP(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			ControlOfficeExceptionCaseManageBC command = new ControlOfficeExceptionCaseManageBCImpl();
			eventResponse = command.searchEquipmentTP(e);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
	}
	
	/**
	 * SEARCH02 이벤트 처리<br>
	 * CodeManage의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse verifyControlOfficeCD(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			ControlOfficeExceptionCaseManageBC command = new ControlOfficeExceptionCaseManageBCImpl();
			eventResponse = command.verifyControlOfficeCD(e);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}		
		return eventResponse;
	}
	
	/**
	 * SEARCH02 이벤트 처리<br>
	 * CodeManage의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchControlOfficeCodeManage(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			ControlOfficeExceptionCaseManageBC command = new ControlOfficeExceptionCaseManageBCImpl();
			eventResponse = command.searchControlOfficeCodeManage(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}		
		return eventResponse;
	}	
		
	/**
	 * 조회 이벤트 처리<br>
	 * CommodityGroupCodeManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCommodityGroupCodeManageList(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			CommodityGroupCodeManageBC command = new CommodityGroupCodeManageBCImpl();
			eventResponse = command.searchCommodityGroupCodeManageList(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
	}			
	
	/**
	 * 조회 이벤트 처리<br>
	 * CommodityGroupCodeManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchMdm_commodity(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			CommodityGroupCodeManageBC command = new CommodityGroupCodeManageBCImpl();
			eventResponse = command.searchMdm_commodity(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}			
	
	/**
	 * 조회 이벤트 처리<br>
	 * CommodityGroupCodeManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchrep_commodity(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			CommodityGroupCodeManageBC command = new CommodityGroupCodeManageBCImpl();
			eventResponse = command.searchrep_commodity(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
	}	

	
	/**
	 * 조회 이벤트 처리<br>
	 * CommodityGroupCodeManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse search_commodity(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			CommodityGroupCodeManageBC command = new CommodityGroupCodeManageBCImpl();
			eventResponse = command.search_commodity(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}		
		return eventResponse;
	}			
		
	
	/**
	 * 조회 이벤트 처리<br>
	 * CommodityGroupCodeManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCmdtCd(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			CommodityGroupCodeManageBC command = new CommodityGroupCodeManageBCImpl();
			eventResponse = command.search_vndr(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}		
		return eventResponse;
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * CommodityGroupCodeManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse search_vndr_commodity(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			CommodityGroupCodeManageBC command = new CommodityGroupCodeManageBCImpl();
			eventResponse = command.search_vndr_commodity(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}	
		return eventResponse;
	}		
	
	/**
	 * 조회 이벤트 처리<br>
	 * CommodityGroupCodeManage 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse search_sub_commodity(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			CommodityGroupCodeManageBC command = new CommodityGroupCodeManageBCImpl();
			eventResponse = command.search_sub_commodity(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}		
	

	/**
	 * 멀티 이벤트 처리<br>
	 * CommodityGroupCodeManage event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multi_vndr_commodity(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			CommodityGroupCodeManageBC command = new CommodityGroupCodeManageBCImpl();
			command.multi_vndr_commodity(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}		
		return eventResponse;
//		return this.searchCommodityGroupCodeManageList(e);
	}	
	

	/**
	 * 멀티 이벤트 처리<br>
	 * CommodityGroupCodeManage event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multi_delete_commodity(Event e) throws EventException {
		try {
			begin();
			CommodityGroupCodeManageBC command = new CommodityGroupCodeManageBCImpl();
			command.multi_delete_commodity(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}		
		return this.searchCommodityGroupCodeManageList(e);
	}		
	

	/**
	 * 멀티 이벤트 처리<br>
	 * CommodityGroupCodeManage event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multi_part_commodity(Event e) throws EventException {
		try {
			begin();
			CommodityGroupCodeManageBC command = new CommodityGroupCodeManageBCImpl();
			command.multi_part_commodity(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}		
		return this.searchCommodityGroupCodeManageList(e);
	}	

	/**
	 * 조회 이벤트 처리<br>
	 * DistanceCreation의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDistanceCreation(Event e) throws EventException {
		EsdTrs0080Event event = (EsdTrs0080Event)e;
		EventResponse eventResponse = null;
		
		try {
			DistanceCreationBC command = new DistanceCreationBCImpl();
			eventResponse = command.searchDistanceCreation(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * DistanceCreation의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDistanceHistory(Event e) throws EventException {
		EsdTrs0080Event event = (EsdTrs0080Event)e;
		EventResponse eventResponse = null;
		
		try {
			DistanceCreationBC command = new DistanceCreationBCImpl();
			eventResponse = command.searchDistanceHistory(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}		
	
	/**
	 * 조회 이벤트 처리<br>
	 * DistanceCreation의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDistanceCreationDuple(Event e) throws EventException {
		EsdTrs0080Event event = (EsdTrs0080Event)e;
		EventResponse eventResponse = null;
		
		try {
			DistanceCreationBC command = new DistanceCreationBCImpl();
			eventResponse = command.searchDistanceCreationDuple(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * 멀티 이벤트 처리<br>
	 * DistanceCreation의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiDistanceCreation(Event e) throws EventException {
		EsdTrs0080Event event = (EsdTrs0080Event)e;
		EventResponse eventResponse = null;

		try {
			begin();
			DistanceCreationBC command = new DistanceCreationBCImpl();
			eventResponse = command.multiDistanceCreation(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}		

	/**
	 * 멀티 이벤트 처리<br>
	 * DistanceCreation의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiDistanceCreationhis(Event e) throws EventException {
		EsdTrs0080Event event = (EsdTrs0080Event)e;
		EventResponse eventResponse = null;

		try {
			begin();
			DistanceCreationBC command = new DistanceCreationBCImpl();
			eventResponse = command.multiDistanceCreationhis(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}		
		return eventResponse;
	}		
	

	/**
	 * 멀티 이벤트 처리<br>
	 * DistanceCreation의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiDistanceDelete(Event e) throws EventException {
		EsdTrs0080Event event = (EsdTrs0080Event)e;
		EventResponse eventResponse = null;

		try {
			begin();
			DistanceCreationBC command = new DistanceCreationBCImpl();
			eventResponse = command.multiDistanceDelete(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}		
		return eventResponse;
	}	


	/**
	 * 조회 이벤트 처리<br>
	 * Actual Customer의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSAActualCustomerCodeManageList(Event e) throws EventException {
		EsdTrs0082Event event = (EsdTrs0082Event)e;
		EventResponse eventResponse = null;
		
		try {
			USAActualCustomerCodeManageBC command = new USAActualCustomerCodeManageBCImpl();
			eventResponse = command.searchUSAActualCustomerCodeManageList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * DistanceCreation의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSAActualCustomerCodeManage(Event e) throws EventException {
		EsdTrs0082Event event = (EsdTrs0082Event)e;
		EventResponse eventResponse = null;
		
		try {
			USAActualCustomerCodeManageBC command = new USAActualCustomerCodeManageBCImpl();
			eventResponse = command.searchUSAActualCustomerCodeManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}		
	
	/**
	 * 멀티 이벤트 처리<br>
	 * USAActualCustomerCodeManage의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiUSAActualCustomerCodeManageList(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			begin();
			USAActualCustomerCodeManageBC command = new USAActualCustomerCodeManageBCImpl();
			eventResponse = command.multiUSAActualCustomerCodeManageList(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * searchUSAActualCustomerName의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSAActualCustomerName(Event e) throws EventException {

		EventResponse eventResponse = null;
		EsdTrs0082Event event = (EsdTrs0082Event)e;
		
		try {
			USAActualCustomerCodeManageBC command = new USAActualCustomerCodeManageBCImpl();
			eventResponse = command.searchUSAActualCustomerName(event);
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;		
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * searchUSAActualCustomerNo의 event에 대한 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSAActualCustomerNo(Event e) throws EventException {

		EventResponse eventResponse = null;
		EsdTrs0082Event event = (EsdTrs0082Event)e;
		
		try {
			USAActualCustomerCodeManageBC command = new USAActualCustomerCodeManageBCImpl();
			eventResponse = command.searchUSAActualCustomerNo(event);
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;		
	}	
	
	/**
	 * 조회 이벤트 처리<br>
	 * searchUSAActualCustomerCheck의 event에 대한 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSAActualCustomerCheck(Event e) throws EventException {

		EventResponse eventResponse = null;
		EsdTrs0082Event event = (EsdTrs0082Event)e;
		
		try {
			USAActualCustomerCodeManageBC command = new USAActualCustomerCodeManageBCImpl();
			eventResponse = command.searchUSAActualCustomerCheck(event);
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * DowntoExcel 이벤트 처리<br>
	 * searchUSAActualCustomerCodeExcel의 event에 대한 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchUSAActualCustomerCodeExcel(Event e) throws EventException {

		EventResponse eventResponse = null;
		EsdTrs0082Event event = (EsdTrs0082Event)e;
		
		try {
			USAActualCustomerCodeManageBC command = new USAActualCustomerCodeManageBCImpl();
			eventResponse = command.searchUSAActualCustomerCodeExcel(event);
			
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * US D/O INPUT Consignee 조회 이벤트 처리<br>
	 * D/O INPUT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSDeliveryOrderConsigneeManage(Event e) throws EventException {
		EsdTrs0083Event event = (EsdTrs0083Event)e;
		EventResponse eventResponse = null;
		
		try {
			USADeliveryOrderManageBC command = new USADeliveryOrderManageBCImpl();
			eventResponse = command.searchUSDeliveryOrderConsigneeManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * US D/O INPUT Consignee 조회 이벤트 처리<br>
	 * D/O INPUT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSADeliveryOrderManageList(Event e) throws EventException {
		EsdTrs0083Event event = (EsdTrs0083Event)e;
		EventResponse eventResponse = null;
		
		try {
			USADeliveryOrderManageBC command = new USADeliveryOrderManageBCImpl();
			eventResponse = command.searchUSADeliveryOrderManageList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * US D/O INPUT Consignee 저장가능여부 체크 이벤트 처리<br>
	 * D/O INPUT의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSADeliveryOrderCheck(Event e) throws EventException {
		EsdTrs0083Event event = (EsdTrs0083Event)e;
		EventResponse eventResponse = null;
		
		try {
			USADeliveryOrderManageBC command = new USADeliveryOrderManageBCImpl();
			eventResponse = command.searchUSADeliveryOrderCheck(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * 멀티 이벤트 처리<br>
	 * D/O INPUT의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiUSADeliveryOrderManage(Event e) throws EventException {
		try {
			begin();
			USADeliveryOrderManageBC command = new USADeliveryOrderManageBCImpl();
			command.multiUSADeliveryOrderManage(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return this.searchUSADeliveryOrderManageList(e);
	}
	
	/**
	 * USA RAIL YARD 조회 이벤트 처리<br>
	 * USA RAIL YARD의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * * N200903260080 2009-04-07 [TRS-US Rail] AES No 관련 보완 요청
	 */
	private EventResponse searchUsaRailYardManage(Event e) throws EventException {
		EsdTrs0084Event event = (EsdTrs0084Event)e;
		EventResponse eventResponse = null;
		
		try {
			UsaRailYardManageBC command = new UsaRailYardManageBCImpl();
			eventResponse = command.searchUsaRailYardManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * USA RAIL YARD 저장 이벤트 처리<br>
	 * USA RAIL YARD의 event에 대한 특정 리스트 저장 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * * N200903260080 2009-04-07 [TRS-US Rail] AES No 관련 보완 요청
	 */
	private EventResponse multiUsaRailYardManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0084Event event = (EsdTrs0084Event)e;
		
		try {
			begin();
			UsaRailYardManageBC command = new UsaRailYardManageBCImpl();
			command.multiUsaRailYardManage(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return this.searchUsaRailYardManage(e);
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * US204EDI SetUp 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUS204EDISetupList(Event e) throws EventException {	
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0085Event event = (EsdTrs0085Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			US204EDISetupBC command = new US204EDISetupBCImpl();
			eventResponse = command.searchUS204EDISetupList(event);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * US204EDI SetUp 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUS204EDISetupVndr(Event e) throws EventException {	
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0085Event event = (EsdTrs0085Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			US204EDISetupBC command = new US204EDISetupBCImpl();
			eventResponse = command.searchUS204EDISetupVndr(event);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * US204EDI SetUp 화면에 대한 멀티 이벤트 처리<br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiUS204EDISetup(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0085Event event = (EsdTrs0085Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			begin();
			US204EDISetupBC command = new US204EDISetupBCImpl();
			eventResponse = command.multiUS204EDISetup(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Registration 화면에 대한 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntRgst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0086Event event = (EsdTrs0086Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			CustomerNominatedTruckerRgstBC command = new CustomerNominatedTruckerRgstBCImpl();
			eventResponse = command.searchCntRgst(event);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
    /**
	 * 조회 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Registration 화면의 Date 구분 코드를 조회하는 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDtDiv(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0086Event event = (EsdTrs0086Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			CustomerNominatedTruckerRgstBC command = new CustomerNominatedTruckerRgstBCImpl();
			eventResponse = command.searchDtDiv(event);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

    /**
	 * 조회 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Registration 화면의 Trucker 조회시 Trucker Name을 조회하는 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTrucker(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0086Event event = (EsdTrs0086Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			CustomerNominatedTruckerRgstBC command = new CustomerNominatedTruckerRgstBCImpl();
			eventResponse = command.searchTrucker(event);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

    /**
	 * 조회 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Registration 화면의 Custmer 조회시 Custmer Name을 조회하는 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCust(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0086Event event = (EsdTrs0086Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			CustomerNominatedTruckerRgstBC command = new CustomerNominatedTruckerRgstBCImpl();
			eventResponse = command.searchCust(event);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
    /**
	 * 조회 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Registration 화면의 S/C, RFA  조회시 Custmer Contract 정보를 조회하는 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContractInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0086Event event = (EsdTrs0086Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			CustomerNominatedTruckerRgstBC command = new CustomerNominatedTruckerRgstBCImpl();
			eventResponse = command.searchContractInfo(event);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Registration 화면의 Route값에 따른 Origin를 조회하는 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepYd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0086Event event = (EsdTrs0086Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			CustomerNominatedTruckerRgstBC command = new CustomerNominatedTruckerRgstBCImpl();
			eventResponse = command.searchRepYd(event);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Registration 화면의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiCntRgst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0086Event event = (EsdTrs0086Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			begin();
			CustomerNominatedTruckerRgstBC command = new CustomerNominatedTruckerRgstBCImpl();
			eventResponse = command.multiCntRgst(event, account);
			commit();
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Registration 화면의 체크된 Row를 Approval 상태로 변경<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse updateCntAproRqst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0086Event event = (EsdTrs0086Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			begin();
			CustomerNominatedTruckerRgstBC command = new CustomerNominatedTruckerRgstBCImpl();
			eventResponse = command.updateCntAproRqst(event, account);
			commit();
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 멀티 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Registration 화면의 체크된 Row를 삭제<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteCnt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0086Event event = (EsdTrs0086Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			begin();
			CustomerNominatedTruckerRgstBC command = new CustomerNominatedTruckerRgstBCImpl();
			eventResponse = command.deleteCntRgst(event, account);
			commit();
			
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * SCAC CD로 Vendor 조회하는 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpNameByScacCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0086Event event = (EsdTrs0086Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = new GeneralEventResponse();
//		String rtn_val = "";
		try {
			CustomerNominatedTruckerRgstBC command = new CustomerNominatedTruckerRgstBCImpl();
			eventResponse = command.searchSpNameByScacCd(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	

	/**
	 * 조회 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Approval 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntApproval(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0087Event event = (EsdTrs0087Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		
		try {
			CustomerNominatedTruckerAproBC command = new CustomerNominatedTruckerAproBCImpl();
			eventResponse = command.searchCntApproval(event, account);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Approval - Approval Status 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDtAproDiv(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0087Event 	event 			= (EsdTrs0087Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse 		eventResponse 	= null;
		
		try {
			CustomerNominatedTruckerAproBC command = new CustomerNominatedTruckerAproBCImpl();
			eventResponse = command.searchDtAproDiv(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Approval Grid Door Yard 변경시 Yard name 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntAproDorYdNm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0087Event event = (EsdTrs0087Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = new GeneralEventResponse();

		try {
			CustomerNominatedTruckerAproBC command = new CustomerNominatedTruckerAproBCImpl();
			eventResponse = command.searchCntAproDorYdNm(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	

	/**
	 * 멀티 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Approval - Save<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse updateCntAproSave(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0087Event event = (EsdTrs0087Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			CustomerNominatedTruckerAproBC command = new CustomerNominatedTruckerAproBCImpl();
			command.updateCntAproSave(event, account);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	

	/**
	 * 멀티 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Approval - Reject<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse updateCntRjct(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0087Event event = (EsdTrs0087Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			CustomerNominatedTruckerAproBC command = new CustomerNominatedTruckerAproBCImpl();
			command.updateCntRjct(event, account);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	

	/**
	 * 멀티 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Approval - Approval<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse updateCntApro(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0087Event event = (EsdTrs0087Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			CustomerNominatedTruckerAproBC command = new CustomerNominatedTruckerAproBCImpl();
			command.updateCntApro(event, account);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Approval - Save<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse saveCntApro(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0087Event event = (EsdTrs0087Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			CustomerNominatedTruckerAproBC command = new CustomerNominatedTruckerAproBCImpl();
			command.saveCntApro(event, account);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	

	/**
	 * 멀티 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Approval - Cancel<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse updateCntCxl(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0087Event event = (EsdTrs0087Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			CustomerNominatedTruckerAproBC command = new CustomerNominatedTruckerAproBCImpl();
			command.updateCntCxl(event, account);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Registration 화면의 Destination을 조회하는 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMtRtnYdNm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0087Event event = (EsdTrs0087Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			CustomerNominatedTruckerAproBC command = new CustomerNominatedTruckerAproBCImpl();
			eventResponse = command.searchMtRtnYdNm(event);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Registration 화면의 AGMT No를 조회하는 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgmtNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0087Event event = (EsdTrs0087Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			CustomerNominatedTruckerAproBC command = new CustomerNominatedTruckerAproBCImpl();
			eventResponse = command.searchAgmtNo(event);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Special Cargo Available S/P 화면를 조회하는 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpecialCargoAvailableList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0088Event event = (EsdTrs0088Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			SpecialCargoAvailableBC command = new SpecialCargoAvailableBCImpl();
			eventResponse = command.searchSpecialCargoAvailableList(event);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * Special Cargo Available S/P 화면 화면에 대한 멀티 이벤트 처리<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiSpecialCargoAvailable(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0088Event event = (EsdTrs0088Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			begin();
			SpecialCargoAvailableBC command = new SpecialCargoAvailableBCImpl();
			eventResponse = command.multiSpecialCargoAvailable(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * 멀티 이벤트 처리<br>
	 * Special Cargo Available S/P 화면 화면에 대한 Row Delete 이벤트 처리<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeSpecialCargoAvailable(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0088Event event = (EsdTrs0088Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			begin();
			SpecialCargoAvailableBC command = new SpecialCargoAvailableBCImpl();
			eventResponse = command.removeSpecialCargoAvailable(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Special Cargo Available S/P 화면의 Vendor 조회하는 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVendorCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0088Event event = (EsdTrs0088Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = new GeneralEventResponse();
		String rtn_val = "";
		try {
			SpecialCargoAvailableBC command = new SpecialCargoAvailableBCImpl();
			rtn_val = command.searchVendorCheck(event);
			eventResponse.setETCData("vndr_nm",rtn_val);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Approval S/P 화면의 Vendor 조회하는 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntVendorCheck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0087Event event = (EsdTrs0087Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = new GeneralEventResponse();
		String rtn_val = "";
		try {
			CustomerNominatedTruckerAproBC command = new CustomerNominatedTruckerAproBCImpl();
			rtn_val = command.searchCntVendorCheck(event);
			eventResponse.setETCData("vndr_nm",rtn_val);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * 조회 이벤트 처리<br>
	 * Special Cargo Available S/P 화면의 S/O Create Office 조회하는 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSoCreOfc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0088Event event = (EsdTrs0088Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = new GeneralEventResponse();
		String rtn_val = "";

		try {
			SpecialCargoAvailableBC command = new SpecialCargoAvailableBCImpl();
			rtn_val = command.searchSoCreOfc(event);
			eventResponse.setETCData("ofc_cd", rtn_val);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	
	/**
	 * SEARCH02 이벤트 처리<br>
	 * CodeManage의 event에 대한 멀티 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse verifySOOfficeCD(Event e) throws EventException {
		EventResponse eventResponse = null;

		try {
			ControlOfficeExceptionCaseManageBC command = new ControlOfficeExceptionCaseManageBCImpl();
			eventResponse = command.verifySOOfficeCD(e);
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}		
		return eventResponse;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Approval - Delete<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse updateCntDel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0087Event event = (EsdTrs0087Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			CustomerNominatedTruckerAproBC command = new CustomerNominatedTruckerAproBCImpl();
			command.updateCntDel(event, account);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * CNT(Customer Nominated Trucker) Approval Grid Door Yard 변경시 Location name 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntAproDorLocNm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0087Event event = (EsdTrs0087Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = new GeneralEventResponse();

		try {
			CustomerNominatedTruckerAproBC command = new CustomerNominatedTruckerAproBCImpl();
			eventResponse = command.searchCntAproDorLocNm(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}


	/**
	 * 조회 이벤트 처리<br>
	 * D/O Notificatio Setting 화면을 조회하는 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDoNotificationSetting(Event e) throws EventException {
		
		EsdTrs0290Event event = (EsdTrs0290Event)e;
		EventResponse eventResponse = null;

		try {
			DoNotificationSettingBC command = new DoNotificationSettingBCImpl();
			eventResponse = command.searchDoNotificationSetting(event);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * D/O Notification Setting 화면의 S/C 조회하는 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDoScNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0290Event event = (EsdTrs0290Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = new GeneralEventResponse();

		try {
			DoNotificationSettingBC command = new DoNotificationSettingBCImpl();
			eventResponse = command.searchDoScNo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * D/O Notification Setting 화면에 대한 멀티 이벤트 처리<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiDoScNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0290Event event = (EsdTrs0290Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			begin();
			DoNotificationSettingBC command = new DoNotificationSettingBCImpl();
			eventResponse = command.multiDoScNo(event,account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 멀티 이벤트 처리<br>
	 * D/O Notification Setting 화면 화면에 대한 Row Delete 이벤트 처리<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeDoNotificationSetting(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0290Event event = (EsdTrs0290Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;
		try {
			begin();
			DoNotificationSettingBC command = new DoNotificationSettingBCImpl();
			eventResponse = command.removeDoNotificationSetting(event,account);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * Grid Door Yard 변경시 Yard name 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDorYdNm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0290Event event = (EsdTrs0290Event)e;
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = new GeneralEventResponse();

		try {
			DoNotificationSettingBC command = new DoNotificationSettingBCImpl();
			eventResponse = command.searchDorYdNm(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * 조회 이벤트 처리<br>
	 * D/O Notification Report 화면을 조회하는 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDoNotificationReportList(Event e) throws EventException {
		
		EsdTrs0291Event event = (EsdTrs0291Event)e;
		EventResponse eventResponse = null;

		try {
			DoNotificationReportBC command = new DoNotificationReportBCImpl();
			eventResponse = command.searchDoNotificationReportList(event);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}	
}