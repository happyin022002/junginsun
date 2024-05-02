/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpecialCargoQuotationSC.java
*@FileTitle : Awkward Cargo Pricing Application
*Open Issues :
*Change history :
*@LastModifyDate : 2013.02.18
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2013.02.18 문동선
* 1.0 Creation
=========================================================
* History 
* 2013.08.12 송호진 [CHM-201325335] Container Type & Q'ty 정보 Historical 관리 & Route 별 비용 Local Currency 적용
* 2015.01.20 송호진 [CHM-201432778] SCQ AWK/BB Cargo application에서 Approval Office 선택에 대한 제한 설정
* 2015.04.23 송호진 [CHM-201533702] SCQ내에 Unit Dual (cm/Inch) System 개발 요청
=========================================================*/
package com.hanjin.apps.alps.esm.pri.specialcargoquotation;

import java.util.ArrayList;
import java.util.List;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.primasterdata.authorizationassignment.vo.OrganizationVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.basic.ScqAwkwardBC;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.basic.ScqAwkwardBCImpl;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.event.EsmPri8003Event;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.event.EsmPri8102Event;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.event.EsmPri8103Event;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.event.EsmPri8104Event;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.integration.ScqAwkwardDBDAO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.AwkCgoExtraCostByRouteVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.AwkCostByCgoRoutVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkCgoVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkCmdtListVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkCntrTpszVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.PriScqAwkHdrVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqawkward.vo.SearchOceanRouteYDListVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.basic.ScqBreakbulkBC;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.basic.ScqBreakbulkBCImpl;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.event.EsmPri8005Event;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbCgoVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbCntrTpszVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbCntrVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbHdrVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqbreakbulk.vo.PriScqBbRoutCostVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.basic.ScqListBC;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.basic.ScqListBCImpl;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.event.EsmPri8001Event;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.event.EsmPri8002Event;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.event.EsmPri8101Event;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.event.EsmPri8105Event;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo.MdmCustVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo.PriScqAtchFileVO;
import com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo.PriScqAwkBbVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;


/**
 * ALPS-SpecialCargoQuotation Business Logic ServiceCommand - ALPS-SpecialCargoQuotation 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Dong-sun Moon
 * @see ScqAwkwardDBDAO
 * @since J2EE 1.6
 */

public class SpecialCargoQuotationSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * SpecialCargoQuotation system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("SpecialCargoQuotationSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * SpecialCargoQuotation system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("SpecialCargoQuotationSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-SpecialCargoQuotation system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		
		if (e.getEventName().equalsIgnoreCase("EsmPri8001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAwkBbCgoQlist(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAwkDtlCgoQlist(e);
			}else {
				eventResponse = initSCQComboList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri8002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAwkBbCgoAlist(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchAwkDtlCgoAlist(e);
			}else {
				eventResponse = initSCQComboList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri8003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // hdr sheet 조회 
				eventResponse = searchPriScqAwkHdr(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // cargo sheet 조회
				eventResponse = searchPriScqAwkCgo(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // route sheet 조회
				eventResponse = searchAwkCgoExtraCostByRoute(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { // cntr tpsz 콤보 조회
				eventResponse = searchPriScqAwkCntrTpsz(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) { // ver no 콤보 조회
				eventResponse = searchPriScqAwkVerNo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) { // svc scp 콤보 조회
				eventResponse = searchPriScqSvcScp(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // 저장 및 prog 진행
				eventResponse = multiPriScqAwkRqst(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI11)) { // Calculate 
				eventResponse = calcPriScqAwkTmp(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI12)) { // Temporary Data 삭제
				eventResponse = removeTemporary(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI13)) { // Temporary Data 의 CopySave
				eventResponse = copySave(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) { // cargo sheet 조회
				eventResponse = searchPriScqAwkCgoTmp(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) { // route sheet 조회
				eventResponse = searchAwkCgoExtraCostByRouteTmp(e);
			}
			else {
				eventResponse = initSCQComboList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri8004Event")) {
			eventResponse = initSCQComboList(e);
			
		}else if (e.getEventName().equalsIgnoreCase("EsmPri8005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // hdr sheet 조회 
				eventResponse = searchPriScqBbHdr(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // cgo sheet 조회
				eventResponse = searchPriScqBbCgo(e);
			}	
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { // cntr sheet 조회
				eventResponse = searchPriScqBbCntr(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) { // cntr tpsz 콤보 조회
				eventResponse = searchPriScqBbCntrTpsz(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) { // ver no 콤보 조회
				eventResponse = searchPriScqBbVerNo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) { // svc scp 콤보 조회
				eventResponse = searchPriScqBbSvcScp(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // 저장 및 prog 진행
				eventResponse = multiPriScqBbRqst(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) { // RoutCost sheet 조회
				eventResponse = searchPriScqBbRoutCost(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // RoutCost sheet 저장 및 진행
				eventResponse = multiPriScqBbRoutCost(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { // Container sheet New Version No 저장 
				eventResponse = addPriScqBbCntrNewVerNo(e);
			}
			else {
				eventResponse = initSCQComboList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri8006Event")) {
			eventResponse = initSCQComboList(e);
			
		}else if (e.getEventName().equalsIgnoreCase("EsmPri8102Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOceanRouteYDList(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmPri8103Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCommodityList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri8101Event")) {
           	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
           		eventResponse = searchPriScqAtchFile(e);
           	} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = managePriScqAtchFile(e);
           	}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri8104Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOfficeHierarchyList(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmPri8105Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCustomerList(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_8001 : RETRIEVE <br>
	 * Awkward & Break Bulk Quotation List 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAwkBbCgoQlist(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8001Event event = (EsmPri8001Event)e;
		ScqListBC command = new ScqListBCImpl();

		try{
			List<PriScqAwkBbVO> list = command.searchAwkBbCgoQlist(event.getPriScqAwkBbVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}

	
	
	/**
	 * ESM_PRI_8001 : RETRIEVE <br>
	 * Awkward & Break Bulk Quotation List 에서 Break Bulk Case 의 Detail Information 조회.<br>
	 * Awkward & Break Bulk Quotation List 에서 Awkward Case 의 Cargo Information 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAwkDtlCgoQlist(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8001Event event = (EsmPri8001Event)e;
		ScqListBC command = new ScqListBCImpl();

		try{
			if("BB".equals(event.getPriScqAwkBbVO().getTpCd()) ) {
				// BB
				PriScqAwkBbVO priScqAwkBbVO = command.searchBbDtlCgoQlist(event.getPriScqAwkBbVO());
				eventResponse.setRsVoList(priScqAwkBbVO.getPriScqBbCgoDtlVos());
				eventResponse.setRsVoList(priScqAwkBbVO.getPriScqBbCntrVOs());
				eventResponse.setRsVoList(priScqAwkBbVO.getPriScqBbHandlingCstVos());
			} else {
				//AWK
				List<PriScqAwkBbVO> list = command.searchAwkDtlCgoQlist(event.getPriScqAwkBbVO());
				eventResponse.setRsVoList(list);
			}
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_8002 : RETRIEVE <br>
	 * Awkward & Break Bulk Approval List 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAwkBbCgoAlist(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8002Event event = (EsmPri8002Event)e;
		ScqListBC command = new ScqListBCImpl();

		try{
			List<PriScqAwkBbVO> list = command.searchAwkBbCgoAlist(event.getPriScqAwkBbVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}

	
	
	/**
	 * ESM_PRI_8002 : RETRIEVE <br>
	 * Awkward & Break Bulk Approval List 에서 Break Bulk Case 의 Detail Information 조회.<br>
	 * Awkward & Break Bulk Approval List 에서 Awkward Case 의 Cargo Information 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAwkDtlCgoAlist(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8002Event event = (EsmPri8002Event)e;
		ScqListBC command = new ScqListBCImpl();

		try{
			if("BB".equals(event.getPriScqAwkBbVO().getTpCd()) ) {
				// BB
				PriScqAwkBbVO priScqAwkBbVO = command.searchBbDtlCgoAlist(event.getPriScqAwkBbVO());
				eventResponse.setRsVoList(priScqAwkBbVO.getPriScqBbCgoDtlVos());
				eventResponse.setRsVoList(priScqAwkBbVO.getPriScqBbCntrVOs());
				eventResponse.setRsVoList(priScqAwkBbVO.getPriScqBbHandlingCstVos());
			} else {
				//AWK
				List<PriScqAwkBbVO> list = command.searchAwkDtlCgoAlist(event.getPriScqAwkBbVO());
				eventResponse.setRsVoList(list);
			}
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_8003 : RETRIEVE <br>
	 * Awkward Quotation 의 Cargo 정보를 조회 한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPriScqAwkCgo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8003Event event = (EsmPri8003Event)e;
		ScqAwkwardBC command = new ScqAwkwardBCImpl();

		try{
			List<PriScqAwkCgoVO> list = command.searchPriScqAwkCgo(event.getPriScqAwkHdrVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}

	/**
	 * ESM_PRI_8003 : RETRIEVE <br>
	 * Awkward Cargo Quotation 의 Route 및 항목별 비용 정보 조회.<br>
	 * Awkward Cargo Quotation 의 Cargo 별 Route 의 각 항목별 비용 정보 상세 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAwkCgoExtraCostByRoute(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8003Event event = (EsmPri8003Event)e;
		ScqAwkwardBC command = new ScqAwkwardBCImpl();

		try{
			List<AwkCgoExtraCostByRouteVO> list1 = command.searchAwkCgoExtraCostByRoute(event.getPriScqAwkHdrVO());
			List<AwkCostByCgoRoutVO>       list2 = command.searchAwkCostByCgoRout(event.getPriScqAwkHdrVO());
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_8003 : RETRIEVE <br>
	 * Awkward Quotation 의 Header ( Master ) 정보를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPriScqAwkHdr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8003Event event = (EsmPri8003Event)e;
		ScqAwkwardBC command = new ScqAwkwardBCImpl();

		try{
			log.debug("\ntest888 : "+event.getPriScqAwkHdrVO());
			List<PriScqAwkHdrVO> list = command.searchPriScqAwkHdr(event.getPriScqAwkHdrVO(), account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}		
	
	/**
	 * ESM_PRI_8003 : RETRIEVE <br>
	 * Awkward Quotation 의 지정된 Request No 의 Version No List 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPriScqAwkVerNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8003Event event = (EsmPri8003Event)e;
		ScqAwkwardBC command = new ScqAwkwardBCImpl();

		try{
			List<PriScqAwkHdrVO> list = command.searchPriScqAwkVerNo(event.getPriScqAwkHdrVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4027 : Retrieve <br>
	 * 입력값에 따라 대상 Code 혹은 Desc 를 기준으로 하여 Commodity List를 조회한다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommodityList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri8103Event event = (EsmPri8103Event)e;
		ScqAwkwardBC command = new ScqAwkwardBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<PriScqAwkCmdtListVO> list = command.searchCommodityList(event.getPriScqAwkCmdtListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}	
	
	/**
	 * ESM_PRI_8003 : OPEN <br>
	 *  - Awkward Quotation 화면의 Cargo 정보 중 Container Typesize Combo 를 위한 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPriScqAwkCntrTpsz(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8003Event event = (EsmPri8003Event)e;
		ScqAwkwardBC command = new ScqAwkwardBCImpl();

		try{
			List<PriScqAwkCntrTpszVO> list = command.searchPriScqAwkCntrTpsz(event.getPriScqAwkCntrTpszVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_PRI_8102 : RETRIEVE <br>
	 * Product Catalog 상의 Ocean Route 리스트 조회
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchOceanRouteYDList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8102Event event = (EsmPri8102Event) e;
		ScqAwkwardBCImpl command = new ScqAwkwardBCImpl();

		try {
			List<SearchOceanRouteYDListVO> list = command
					.searchOceanRouteYDList(event.getSearchConditionVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_8003 : RETRIEVE <br>
	 * Awkward Quotation 에서 입력된 POL, POD 별로 적용 가능한 Service Scope List 를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPriScqSvcScp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8003Event event = (EsmPri8003Event)e;
		ScqAwkwardBC command = new ScqAwkwardBCImpl();

		try{
			List<PriScqAwkHdrVO> list = command.searchPriScqSvcScp(event.getPriScqAwkHdrVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_PRI_8003 : SAVE <br>
	 * Awkward Cargo Quotation 정보 저장.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiPriScqAwkRqst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8003Event event = (EsmPri8003Event)e;
		ScqAwkwardBC command = new ScqAwkwardBCImpl();
		try{
			begin();
			PriScqAwkHdrVO result = command.multiPriScqAwkRqst(event.getPriScqAwkRqstVO(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
			eventResponse.setRsVo(result);
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_8003 : CALCULATE <br>
	 *  - Awkward Quotation 의 Cargo 정보를 조회 한다.
     *  - Temporary Calculation 에 적용하기 위해 본 테이블 ( PRI_SCQ_AWK_CGO ) 이 아닌 Temporary 테이블 ( PRI_SCQ_AWK_CGO_TMP ) 에 
     *    변경한 데이터를 저장하고 이를 대상으로 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPriScqAwkCgoTmp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8003Event event = (EsmPri8003Event)e;
		ScqAwkwardBC command = new ScqAwkwardBCImpl();

		try{
			List<PriScqAwkCgoVO> list = command.searchPriScqAwkCgoTmp(event.getPriScqAwkHdrVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}

	/**
	 * ESM_PRI_8003 : CALCULATE <br>
	 *  - Awkward Cargo Quotation 의 Route 및 항목별 비용 정보 조회 
	 *  - Awkward Cargo Quotation 의 Cargo 별 Route 의 각 항목별 비용 정보 상세 조회
     *  - Calculation 의 결과로 생성된 TMP 테이블에서 가져온다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAwkCgoExtraCostByRouteTmp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8003Event event = (EsmPri8003Event)e;
		ScqAwkwardBC command = new ScqAwkwardBCImpl();

		try{
			List<AwkCgoExtraCostByRouteVO> list1 = command.searchAwkCgoExtraCostByRouteTmp(event.getPriScqAwkHdrVO());
			List<AwkCostByCgoRoutVO>       list2 = command.searchAwkCostByCgoRoutTmp(event.getPriScqAwkHdrVO());
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_8003 : CALCULATE <br>
     * - Awkward 의 Cargo 와 Route 정보를 TES, TRS 에서 관리하는 테이터에 대조하여 
     *   각각의 비용을 계산한다.
     * - Temporary 하게 계산을 해 볼수 있도록 하기 위해 본 데이터를 TMP Table Set 로 Copy 하여 계산 결과를 저장한다..<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse calcPriScqAwkTmp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8003Event event = (EsmPri8003Event)e;
		ScqAwkwardBC command = new ScqAwkwardBCImpl();
		try{
			begin();
			PriScqAwkHdrVO result = command.calcPriScqAwkTmp(event.getPriScqAwkRqstVO(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			eventResponse.setETCData("scq_ver_no_tmp", result.getScqVerNoTmp());
			commit();
			eventResponse.setRsVo(result);
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_8003 : SAVE <br>
	 * Calculate 를 위해 생성한 Temporary Table 상의 데이터 삭제.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeTemporary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8003Event event = (EsmPri8003Event)e;
		ScqAwkwardBC command = new ScqAwkwardBCImpl();
		try{
			begin();
			command.removeTemporary(event.getPriScqAwkHdrVO(), account, 1);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_8003 : SAVE <br>
	 * TMP Table Set 에 생성된 계산 결과를 Transaction Table 로 옮겨서 저장한다..<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse copySave(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8003Event event = (EsmPri8003Event)e;
		ScqAwkwardBC command = new ScqAwkwardBCImpl();
		try{
			begin();
			command.copySave(event.getPriScqAwkHdrVO(), account );
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	/**
	 * ESM_PRI_8005 : RETRIEVE <br>
	 * Break Bulk Quotation 의 Header ( Master ) 정보를 조회한다.<br>
	 * VVD LIST 를 함께 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPriScqBbHdr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8005Event event = (EsmPri8005Event)e;
		ScqBreakbulkBC command = new ScqBreakbulkBCImpl();

		try{
			List<PriScqBbHdrVO> list1 = command.searchPriScqBbHdr(event.getPriScqBbHdrVO(), account);
			eventResponse.setRsVoList(list1);
			if ( list1.size() > 0 ) {
				event.getPriScqBbHdrVO().setPolCd(list1.get(0).getPolCd());
				event.getPriScqBbHdrVO().setLaneCd(list1.get(0).getLaneCd());
			}
			List<RsltCdListVO> list2 = command.searchVVDETAList(event.getPriScqBbHdrVO());
			eventResponse.setRsVoList(list2);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_PRI_8005 : RETRIEVE <br>
	 * Break Bulk Quotation 의 Cargo 정보 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPriScqBbCgo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8005Event event = (EsmPri8005Event)e;
		ScqBreakbulkBC command = new ScqBreakbulkBCImpl();

		try{
			List<PriScqBbCgoVO> list = command.searchPriScqBbCgo(event.getPriScqBbCgoVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_PRI_8005 : RETREIVE <br>
	 * Break Bulk Quotation 의 Container 정보 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPriScqBbCntr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8005Event event = (EsmPri8005Event)e;
		ScqBreakbulkBC command = new ScqBreakbulkBCImpl();

		try{
			List<PriScqBbCntrVO> list = command.searchPriScqBbCntr(event.getPriScqBbCntrVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_PRI_8005 : RETRIEVE <br>
	 * Break Bulk Quotation 의 지정된 Request No 의 Version No List 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPriScqBbVerNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8005Event event = (EsmPri8005Event)e;
		ScqBreakbulkBC command = new ScqBreakbulkBCImpl();

		try{
			List<PriScqBbHdrVO> list = command.searchPriScqBbVerNo(event.getPriScqBbHdrVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_8003 : OPEN <br>
	 * Break Bulk Quotation 화면의 Container 정보 중 Container Typesize Combo 를 위한 조회. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPriScqBbCntrTpsz(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8005Event event = (EsmPri8005Event)e;
		ScqBreakbulkBC command = new ScqBreakbulkBCImpl();

		try{
			List<PriScqBbCntrTpszVO> list = command.searchPriScqBbCntrTpsz(event.getPriScqBbCntrTpszVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_PRI_8003 : RETRIEVE <br>
	 * Break Bulk Quotation 에서 입력된 POL, POD 별로 적용 가능한 Service Scope List 를 조회한다.<br>
	 * VVD LIST 를 함께 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPriScqBbSvcScp(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8005Event event = (EsmPri8005Event)e;
		ScqBreakbulkBC command = new ScqBreakbulkBCImpl();

		try{
			List<PriScqBbHdrVO> list1 = command.searchPriScqBbSvcScp(event.getPriScqBbHdrVO());
			eventResponse.setRsVoList(list1);
			List<RsltCdListVO> list2 = command.searchVVDETAList(event.getPriScqBbHdrVO());
			eventResponse.setRsVoList(list2);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_PRI_8005 : REQUEST <br>
	 *  Break Bulk Cargo Quotation 의 Request 진행 .<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiPriScqBbRqst(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8005Event event = (EsmPri8005Event)e;
		ScqBreakbulkBC command = new ScqBreakbulkBCImpl();
		try{
			begin();
			PriScqBbHdrVO result = command.multiPriScqBbRqst(event.getPriScqBbRqstVO(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
			eventResponse.setRsVo(result);
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_8005 : RETRIEVE <br>
	 * Break Bulk Cargo Quotation 의 Route 및 항목별 비용 정보 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPriScqBbRoutCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8005Event event = (EsmPri8005Event)e;
		ScqBreakbulkBC command = new ScqBreakbulkBCImpl();
		PriScqBbRoutCostVO priScqBbRoutCostVO = null;

		try{
			priScqBbRoutCostVO = event.getPriScqBbRoutCostVO();
			
			priScqBbRoutCostVO.setRoutSeq("1");
			List<PriScqBbRoutCostVO> list1 = command.searchPriScqBbRoutCost(event.getPriScqBbRoutCostVO());
			eventResponse.setRsVoList(list1);
			priScqBbRoutCostVO.setRoutSeq("2");
			List<PriScqBbRoutCostVO> list2 = command.searchPriScqBbRoutCost(event.getPriScqBbRoutCostVO());
			eventResponse.setRsVoList(list2);
			/* T/S Port Cost 는 화면 크기 문제로 화면에서 사라졌기 때문에 당분간 처리 대상에서 제외 한다. 2013.12.05. 송호진
			priScqBbRoutCostVO.setRoutSeq("3");
			List<PriScqBbRoutCostVO> list3 = command.searchPriScqBbRoutCost(event.getPriScqBbRoutCostVO());
			eventResponse.setRsVoList(list3);
			*/
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_PRI_8005 : SAVE <br>
	 * Break Bulk Cargo Quotation 정보 저장.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiPriScqBbRoutCost(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8005Event event = (EsmPri8005Event)e;
		ScqBreakbulkBC command = new ScqBreakbulkBCImpl();
		try{
			begin();
			command.multiPriScqBbRoutCost(event.getPriScqBbRoutCostVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_PRI_8005 : SAVE <br>
	 * Break Bulk Cargo Quotation Container 정보 저장.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse addPriScqBbCntrNewVerNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8005Event event = (EsmPri8005Event)e;
		ScqBreakbulkBC command = new ScqBreakbulkBCImpl();
		try{
			begin();
			command.addPriScqBbCntrNewVerNo(event.getPriScqBbRqstVO(),account);
			eventResponse.setUserMessage(new ErrorHandler("XXXXXXXXX").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}	
	
    /**
	 * ESM_BKG_1131 조회 이벤트 처리<br>
     *  ImportRestricted Commodities File Upload<br>   
     * 
     * @param e EsmBkg1131Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchPriScqAtchFile(Event e) throws EventException {
    	EsmPri8101Event event = (EsmPri8101Event)e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        ScqListBC command = new ScqListBCImpl();
    
       try {
            // search
    	   List<PriScqAtchFileVO> list = command.searchPriScqAtchFile(event.getPriScqAtchFileVO());
           
    	   eventResponse.setRsVoList(list);
        } catch(EventException ex) {
           throw ex;
        } catch(Exception ex) {
           throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }

	/**
	 * ESM_BKG_1131 저장 이벤트 처리<br>
	 * 특수화물 Quotation 에서 Awkward, Break Bulk 양쪽에서 사용되는 Attachment File 관리 .<br>
     *  ImportRestricted Commodities File Upload<br>
	 * @author Lee InYoung
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse managePriScqAtchFile(Event e) throws EventException {
		log.debug("[START:: SpecialCargoBookingConductSC == manageSpclRider SEARCH ]==========");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ScqListBC command = new ScqListBCImpl();

		//1.로직 처리전 Event 객체에서 값을 입력하거나 선택된 값으로 설정해준다.
		EsmPri8101Event event = (EsmPri8101Event)e;
		PriScqAtchFileVO[] priScqAtchFileVOs = event.getPriScqAtchFileVOs();
		String[] saveIds = event.getSaveIds();
		try{
			
			// File Size 가 5M 이상이면, SC를 호출하여 Error Message 를 표시한다.
			if("Y".equals(event.getFileSizeChkFlg())){
				eventResponse.setUserMessage(new ErrorHandler("BKG00370").getUserMessage());  //BKG00370 : File size can't not exceeds 5MB.
				
			} else {
			
				//2.로직 처리 실행
				begin();
				command.managePriScqAtchFile(priScqAtchFileVOs,saveIds,account);
				commit();
	
				//3.로직 처리후 결과처리
				eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());  //PRI00101 : Data saved successfully.
			}

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		log.debug("[END::]==========");
		return eventResponse;
	}    
	
	/**
	 * ESM_PRI_8104 : RETRIEVE <br>
	 * Office Hierarchy List 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfficeHierarchyList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri8104Event event = (EsmPri8104Event)e;
		ScqAwkwardBC command = new ScqAwkwardBCImpl();

		try{
			List<OrganizationVO> list = command.searchOfficeHierarchyList(event.getPriScqAwkHdrVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_4014 : Retrieve <br>
	 * Customer List를 조회 합니다. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCustomerList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri8105Event event = (EsmPri8105Event)e;
		ScqListBC command = new ScqListBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<MdmCustVO> list = command.searchCustomerList(event.getMdmCustVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
    /**
     * ESM_PRI_8001, 8002, 8003, 8005 : OPEN<br>
     * 화면로딩시 콤보정보를 조회한다<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse initSCQComboList(Event e) throws EventException {
        PRICommonBC command = new PRICommonBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        RsltCdListVO vo = new RsltCdListVO();
        List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

        try {
            ////////////////////COMMON - START/////////////////////
            //PRICING SCQ APPROVAL OFFICE CODE
            vo.setCd("CD03366");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PRC_SCQ_APRO_OFC_CD", list);

            //PRICING SCQ APPROVAL OFFICE CODE
            vo.setCd("CD03380");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("MEAS_SYS_CD", list);

            //////////////////////COMMON - END///////////////////////
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

}

