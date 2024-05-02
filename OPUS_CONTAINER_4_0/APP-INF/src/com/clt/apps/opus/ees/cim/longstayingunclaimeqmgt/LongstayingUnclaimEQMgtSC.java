/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LongstayingUnclaimEQMgtSC.java
*@FileTitle : Container Staying Days (Summary)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 김종준
*@LastVersion : 1.0
* 2009.07.09 김종준
* 1.0 Creation
* =========================================================
* 2010.09.07 남궁진호 [CHM-201005814-01] 소스품질 결함 조치
*            사용하지않는 VO객체 제거,List<vo >공백제거
=========================================================*/
package com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.basic.CIMCommonBC;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.basic.CIMCommonBCImpl;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.basic.CNTRInventoryReportBC;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.basic.CNTRInventoryReportBCImpl;
import com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo.InvtCodeCommonVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.basic.LongstayingUnclaimEQFlaggingBC;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.basic.LongstayingUnclaimEQFlaggingBCImpl;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0021Event;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0022Event;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0024Event;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0025Event;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0041Event;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0042Event;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim0044Event;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.event.EesCim1951Event;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.integration.LongstayingUnclaimEQFlaggingDBDAO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.CntrFdayListVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.FlaggingListSmryVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.LongStayUclmDetailVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.SDaysLisDetailVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.SDaysListSmryVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.OPInventoryForPseudoBookingOptionVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.OPInventoryForPseudoBookingSummayVO;
import com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo.OPInventoryForPseudoBookingDetailVO;
import com.clt.apps.opus.ees.lse.lsecommon.leaseterm.basic.LeaseTermBC;
import com.clt.apps.opus.ees.lse.lsecommon.leaseterm.basic.LeaseTermBCImpl;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBC;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.basic.ContainerOnOffhireBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.MstLseTermVO;


/**
 * LongstayingUnclaimEQMgt Business Logic ServiceCommand 
 * LongstayingUnclaimEQMgt 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author kim jong jun
 * @see LongstayingUnclaimEQFlaggingDBDAO
 * @since J2EE 1.6
 */

public class LongstayingUnclaimEQMgtSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * LongstayingUnclaimEQMgt system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	public void doStart() {
		log.debug("LongstayingUnclaimEQMgtSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * LongstayingUnclaimEQMgt system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("LongstayingUnclaimEQMgtSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * LongstayingUnclaimEQMgt system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = new GeneralEventResponse();
		
		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EesCim0021Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSDaysListSmry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCommon02List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSDaysListByMvmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchSDaysListTotalDays(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {	//Location 코드 체크
				eventResponse = checkLocation(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCim1951Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOPInventoryForPseudoBookingList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
			    eventResponse = searchOPInventoryForPseudoBookingDetailList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesCim0044Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSDaysListDetail(e);
			}			
		} else if (e.getEventName().equalsIgnoreCase("EesCim0041Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSDaysListTotalDaysByMvmt(e);
			}			
		} else if (e.getEventName().equalsIgnoreCase("EesCim0042Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSDaysListTotalDaysDetail(e);
			}			
		} else if (e.getEventName().equalsIgnoreCase("EesCim0022Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFlaggingTargetList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCommon02List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageFlagging(e);
			}			
		} else if (e.getEventName().equalsIgnoreCase("EesCim0024Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFlaggingStatusList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCommon02List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkLocation(e);
			}			
		} else if (e.getEventName().equalsIgnoreCase("EesCim0025Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCntrFdayList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCommon02List(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkLocation(e);
			}	
		}
		return eventResponse;
	}	
	/**
	 * EES_CIM_0021 : Retrieve<br>
	 * Full/ MTY 컨테이너의 장기체류 현황을 지역별,EQ TP&SZ별로 체류 기간을 구분하여 조회합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSDaysListSmry(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0021Event event = (EesCim0021Event)e;
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();

		try{
			List<SDaysListSmryVO> list = command.searchSDaysListSmry(event.getFlaggingSDaysOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_CIM_0021 : Retrieve<br>
	 * Full/ MTY 컨테이너의 장기체류 현황을 지역별,MVMT Status 별, EQ TP&SZ별로 체류 기간을 구분하여 조회.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSDaysListByMvmt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0021Event event = (EesCim0021Event)e;
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		try{
			List<SDaysListSmryVO> list = command.searchSDaysListByMvmt(event.getFlaggingSDaysOptionVO ());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;		
	}	

	/**
	 * EES_CIM_0021 : Retrieve<br>
	 * 조회시점에 체류하고 있는 컨테이너의 과거 MVMT History를 조회하여, 지역별, EQ TP&SZ로  MVMT Status 를 분류하여 체류   일수를 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSDaysListTotalDays(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0021Event event = (EesCim0021Event)e;
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		try{
			List<SDaysListSmryVO> list = command.searchSDaysListTotalDays(event.getFlaggingSDaysOptionVO ());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;		
	}	
	
	/**
	 * EES_CIM_0044 : Retrieve<br>
	 * Full/ MTY 장기체화 장비의 BKG 및 Movement 정보등을 컨테이너 번호별로 일괄적으로 조회한다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSDaysListDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0044Event event = (EesCim0044Event)e;
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		try{
			int rtvTotal = command.searchSDaysTotalCnt(event.getFlaggingSDaysOptionVO());
			eventResponse.setETCData("rtv_total", String.valueOf(rtvTotal));
			
			List<SDaysLisDetailVO> list = command.searchSDaysListDetail(event.getFlaggingSDaysOptionVO ());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;		
	}		
	
	/**
	 * EES_CIM_0041 : Retrieve<br>
	 * 컨테이너 번호별로 Total S/Days의 체류일수를 CNTR MVMT Status별 체류일수를 집계하여 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSDaysListTotalDaysByMvmt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0041Event event = (EesCim0041Event)e;
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		try{
			List<SDaysLisDetailVO> list = command.searchSDaysListTotalDaysByMvmt(event.getFlaggingSDaysOptionVO ());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;		
	}	
	
	/**
	 * EES_CIM_0042 : Retrieve<br>
	 * “Total S/Days” 현황을 컨테이너별 “최초반입일시/야드” 및 “현 MVMT 및 Yard 정보”등을 포함하여 체류일수를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSDaysListTotalDaysDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0042Event event = (EesCim0042Event)e;
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		try{
			int rtvTotal = command.searchSDaysListTotalDaysCnt(event.getFlaggingSDaysOptionVO());
			eventResponse.setETCData("rtv_total", String.valueOf(rtvTotal));
			
			List<SDaysLisDetailVO> list = command.searchSDaysListTotalDaysDetail(event.getFlaggingSDaysOptionVO ());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;		
	}	
	
	/**
	 * 각화면 공통 lease_term,TP/SZ 조회<br>
	 * 각화면 공통 lease_term,TP/SZ  정보 조회<br>
	 * 
	 * @param e 이벤트
	 * @return eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCommon02List(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		CNTRInventoryReportBC command = new CNTRInventoryReportBCImpl();
		List<InvtCodeCommonVO> invtCodeCommonVO = command.searchCntrTypeSizeList( );
		StringBuilder sb = new StringBuilder();
		if(invtCodeCommonVO.size() > 0) {
			for(int i = 0 ; i < invtCodeCommonVO.size()-1 ; i++){
				sb.append(invtCodeCommonVO.get(i).getCntrTpszCd());
				sb.append("|");
			}
			sb.append(invtCodeCommonVO.get(invtCodeCommonVO.size()-1).getCntrTpszCd());
		} 

		Map<String,String> etcData = new HashMap<String,String>();
		 
		etcData.put("cntr_tpsz_cd",sb.toString());		
		
		//Lease Term Combo Object Item
		LeaseTermBC leaseCommand = new LeaseTermBCImpl();
		List<MstLseTermVO> leaseTermList = leaseCommand.searchLeaseTermComboItemBasic();
		StringBuffer sLeaseTermNm = new StringBuffer();
		StringBuffer sLeaseTermCd = new StringBuffer();

		for ( int i = 0 ; i < leaseTermList.size() ; i++ ) {
			if ( sLeaseTermNm.toString().equals("") ) {
				sLeaseTermNm.append(leaseTermList.get(i).getLstmCd());
				sLeaseTermCd.append(leaseTermList.get(i).getLstmCd());
			} else {
				sLeaseTermNm.append("|").append(leaseTermList.get(i).getLstmCd());
				sLeaseTermCd.append("|").append(leaseTermList.get(i).getLstmCd());
			}
		}

		etcData.put("lease_term_nm", sLeaseTermNm.toString());
		etcData.put("lease_term_cd", sLeaseTermCd.toString());

		eventResponse.setETCData(etcData);
		return eventResponse;
	}	    
	
	/**
	 * EES_CIM_0022 : Retrieve<br>
	 * 장기체화장비(L/Staying) 및 Unclaim 요건 장비에 대한 제반 정보를 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFlaggingTargetList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0022Event event = (EesCim0022Event)e;
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		try{
			List<LongStayUclmDetailVO> list = command.searchFlaggingTargetList(event.getFlaggingSDaysOptionVO ());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;		
	}
	
	/**
	 * 화면별 Location 이벤트 체크로직<br>
	 * Location check validate<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkLocation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//EesCim1001Event event = (EesCim1001Event)e;
		CIMCommonBC command = new CIMCommonBCImpl();

		String locLevel = (String)e.getAttribute("inquirylevel");
		String locCD = (String)e.getAttribute("location");
		String check = command.checkLocation(locLevel,locCD);
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		Map<String,String> etcData = new HashMap<String,String>();
		etcData.put("check",check);
		
		eventResponse.setETCData(etcData);
		return eventResponse;
	}
	
	/**
	 * EES_CIM_0022 : 저장<br>
	 * 장기체화장비(L/Staying) 및 Unclaim 장비 Flag 와 해소 방안을 등록한다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageFlagging(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		ContainerOnOffhireBC cntrCommand = new ContainerOnOffhireBCImpl();
		EesCim0022Event event = (EesCim0022Event)e;
		
		try{
			begin();
			cntrCommand.updateCntrMasterByLongStayCreationBasic(event.getLongStayUclmDetailVOS(),account);
			command.manageFlagging(event.getLongStayUclmDetailVOS(),account);
			eventResponse.setUserMessage(new ErrorHandler("CIM00003").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_CIM_0024 : Retrieve<br>
	 * L/S & U/C Creation화면에서 Flag된 L/S 및 U/C 장비의 현황을 조회한다.
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFlaggingStatusList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0024Event event = (EesCim0024Event)e;
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		try{
			List<FlaggingListSmryVO> list = command.searchFlaggingStatusListSmry(event.getFlaggingSDaysOptionVO ());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;		
	}
	/**
	 * EES_CIM_0018 : Retrieve<br>
	 * 조회시점 기준, 지역별로 소재하고 있는 컨테이너 넘버 및 관련 Booking 및 장비관리 정보를 조회<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrFdayList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim0025Event event = (EesCim0025Event)e;
		
		event.getInvtOptionVO().setOfcCd(account.getOfc_cd());
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();
		try{
			List<CntrFdayListVO> list = command.searchCntrFdayList(event.getInvtOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_CIM_1951 : Retrieve<br>
	 * OP Inventory for Pseudo Booking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOPInventoryForPseudoBookingList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim1951Event event = (EesCim1951Event)e;
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();

		try{
			List<OPInventoryForPseudoBookingSummayVO> list = command.searchOPInventoryForPseudoBookingList(event.getOPInventoryForPseudoBookingOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * EES_CIM_1951 : Retrieve<br>
	 * OP Inventory for Pseudo Booking.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOPInventoryForPseudoBookingDetailList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCim1951Event event = (EesCim1951Event)e;
		LongstayingUnclaimEQFlaggingBC command = new LongstayingUnclaimEQFlaggingBCImpl();

		try{
			List<OPInventoryForPseudoBookingDetailVO> list = command.searchOPInventoryForPseudoBookingDetailList(event.getOPInventoryForPseudoBookingOptionVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}		
		return eventResponse;
	}
}