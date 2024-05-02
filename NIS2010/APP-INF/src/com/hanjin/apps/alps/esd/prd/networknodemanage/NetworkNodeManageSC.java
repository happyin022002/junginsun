/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : NetworkNodeManageSC.java
 *@FileTitle : Geographic Hierarchy 정보관리
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-08-30
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-08-30 kimyoungchul
 * 1.0 최초 생성
 * 2009-07-02 alps framework 구조 변경
 * 2012-06-18 JunKun Lee : Rail Receiving (Cut Off) Date 산출 Logic 변경 및 추가 요청
 * 2012.11.02 정선용 [CHM-201221039] [PRD] Canada rail cut off 기능개선
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage;

import java.util.List;

import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboMGTVO;
import com.hanjin.apps.alps.esd.prd.common.prdcommon.basic.PrdCommonManageBC;
import com.hanjin.apps.alps.esd.prd.common.prdcommon.basic.PrdCommonManageBCImpl;
import com.hanjin.apps.alps.esd.prd.networknodemanage.blockstowage.basic.BlockStowageManageBC;
import com.hanjin.apps.alps.esd.prd.networknodemanage.blockstowage.basic.BlockStowageManageBCImpl;
import com.hanjin.apps.alps.esd.prd.networknodemanage.blockstowage.event.EsdPrd0071Event;
import com.hanjin.apps.alps.esd.prd.networknodemanage.blockstowage.event.EsdPrd0072Event;
import com.hanjin.apps.alps.esd.prd.networknodemanage.blockstowage.vo.GroupCreationVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.basic.CanadaCCTManageBC;
import com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.basic.CanadaCCTManageBCImpl;
import com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.event.EsdPrd0037Event;
import com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.vo.CanadaCCTManageVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.cctmanage.basic.NewCCTManageBC;
import com.hanjin.apps.alps.esd.prd.networknodemanage.cctmanage.basic.NewCCTManageBCImpl;
import com.hanjin.apps.alps.esd.prd.networknodemanage.cctmanage.event.EsdPrd0036Event;
import com.hanjin.apps.alps.esd.prd.networknodemanage.cctmanage.vo.NewCCTManageVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.geohierarchymanage.basic.GeoHierarchyManageBC;
import com.hanjin.apps.alps.esd.prd.networknodemanage.geohierarchymanage.basic.GeoHierarchyManageBCImpl;
import com.hanjin.apps.alps.esd.prd.networknodemanage.geohierarchymanage.event.EsdPrd0001Event;
import com.hanjin.apps.alps.esd.prd.networknodemanage.geohierarchymanage.vo.SearchGeoHierarchyManageVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.pickupreturncy.basic.PickupReturnCyManageBC;
import com.hanjin.apps.alps.esd.prd.networknodemanage.pickupreturncy.basic.PickupReturnCyManageBCImpl;
import com.hanjin.apps.alps.esd.prd.networknodemanage.pickupreturncy.event.EsdPrd0070Event;
import com.hanjin.apps.alps.esd.prd.networknodemanage.pickupreturncy.vo.PickupReturnCYVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.basic.YardManageBC;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.basic.YardManageBCImpl;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.event.EsdPrd0002Event;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.event.EsdPrd0003Event;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.event.EsdPrd0008Event;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.event.EsdPrd0088Event;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchLeaseListVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchNodeDefaultSpInfoListVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchNodeListVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchYardDetailVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchYardDwellHistoryVO;
import com.hanjin.apps.alps.esd.prd.networknodemanage.yardmanage.vo.SearchZoneDetailVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.MdmLocationVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * alps-PRD Business Logic ServiceCommand<br>
 * - alps-PRD에 대한 비지니스 트랜잭션을 처리한다.<br>
 *
 * @author kimyoungchul
 * @see ESD_PRD_001EventResponse,GeoHierarchyManageDBDAO 참조
 * @since J2EE 1.4
 */
public class NetworkNodeManageSC extends ServiceCommandSupport{
	// Login User Information

	private SignOnUserAccount account = null;

	/**
	 * PRD 업무 시나리오 선행작업<br>
	 * GeoHierarchyManage업무 시나리오 호출시 관련 내부객체 생성<br>
	 */
	@Override
	public void doStart(){
		try{
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
			if(account.getUsr_id() == null){
				throw new RuntimeException();
			}
		}catch(Exception e){
			log.error("NetworkNodeManageSC 선행 작업 시 오류 " + e.toString(), e);
		}
	}

	/**
	 * PRD 업무 시나리오 마감작업<br>
	 * GeoHierarchyManage업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	@Override
	public void doEnd(){
		// command.doEnd();
		log.debug("NetworkNodeManageSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * alps-PRD 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException{
		EventResponse eventResponse = null;
		log.debug("\n[CALL] Service Command ----------------------------- "
				+ "\n EventName   : " + e.getEventName()
				+ "\n Program No.  : " + ((String) e.getAttribute("pgmNo"))
				+ "\n Command     : " + e.getFormCommand().getCommand());
		String retCrud = "";
		String usr_id = "";
		if(account!=null){
			usr_id = account.getUsr_id();
		}
		
		PrdCommonManageBC prdComm = new PrdCommonManageBCImpl();
		retCrud = prdComm.getPrdPgmRole(((String) e.getAttribute("pgmNo")),usr_id);
		log.debug("\n\n retCrud:[" + retCrud + "] null con->[" + (retCrud.equals("") ? "R" : retCrud) + "]");
		e.setAttribute("crud", retCrud.equals("") ? "R" : retCrud);
		
		
		// Geo. Hierarcy Manage
		if(e.getEventName().equalsIgnoreCase("EsdPrd0001Event")){
			
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = this.searchGeoHierarchyList(e);
			}else{
				eventResponse = this.searchContinent(e);
			}

		// Yard Manage
		}else if(e.getEventName().equalsIgnoreCase("EsdPrd0002Event")){
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = this.searchNodeList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = this.searchYardDetail(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = this.searchZoneDetail(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
				eventResponse = this.searchZonePostCode(e);
			}else{
				eventResponse = this.searchContinent(e);
			}

		/*
		 * Lease Company yard inquiry
		 * 2009/07/27 kim kwijin 수정
		 */
		}else if(e.getEventName().equalsIgnoreCase("EsdPrd0003Event")){
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = this.searchLeaseList(e);
			}

		// new CCT Manage  2009.02.17
		//CSR: N200903040130 20090608 e-NIS CCT MGMT by Yard UI 수정 관련 PRD SKD Logic 보완
		// 2009.07.20 alps FrameWork 변경 noh seung bae
		}else if(e.getEventName().equalsIgnoreCase("EsdPrd0036Event")){
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = this.searchCCTManage(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = this.multiCCTManage(e);
			} // end if

		}else if(e.getEventName().equalsIgnoreCase("EsdPrd0037event")){
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = this.searchCanadaCCTManage(e);
			} else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)){
				eventResponse = this.searchCanadaCCTInterval(e);
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
//				eventResponse = this.searchMdmLocation(e); // pol check ( ca 만 가능)
				eventResponse = this.searchPolNode(e); // pol check ( ca 만 가능) jsy
				
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH02)){
				eventResponse = this.searchMdmLocation4USCA(e); //por check( us, ca 모두 가능)
			} else if(e.getFormCommand().isCommand(FormCommand.SEARCH03)){
				eventResponse = this.checkDuplicateCanadaCCTManage(e);
				
				if(eventResponse.getRsVoList() != null) {
					eventResponse.setETCData("dupChk", eventResponse.getRsVoList().size() + "");
				}
				else {
					eventResponse.setETCData("dupChk", "0");
				}
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = this.multiCanadaCCTManage(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
				eventResponse = this.multiIntevalCCTManage(e);
			} // end if
		
		// Pickup Return CY 2009.07.27 신규 noh seung bae
		}else if(e.getEventName().equalsIgnoreCase("EsdPrd0070Event")){
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = this.searchPickupList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = this.multiPickupReturnCY(e);
			} // end if

		// Block Stowage Code Inquiry 2009.08.03 신규 noh seung bae
		}else if(e.getEventName().equalsIgnoreCase("EsdPrd0071Event")){
//			EsdPrd0071Event event = (EsdPrd0071Event) e;
//			BlockStowageManageBC command = new BlockStowageManageBCImpl();
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = this.searchGroupCreationList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = this.searchLaneCode(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = this.multiGroupCreation(e);
			} // end if

		// Block Stowage Group Creation 2009.08.10 신규 노승배
		}else if(e.getEventName().equalsIgnoreCase("EsdPrd0072Event")){
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = this.searchCodeInquiryList(e);
			} // end if
		} // end if
		else if(e.getEventName().equalsIgnoreCase("EsdPrd0008Event")){
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = this.searchDwellTimeHIstory(e);
		     }
		// Node Default Service Provider 2014.12.09 신규 kimseungman
		}else if(e.getEventName().equalsIgnoreCase("EsdPrd0088Event")){
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = this.searchNodeDefaultSpInfoList(e);
		    }else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
					eventResponse = searchSubOfficeSOManageList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyNodeDefaultSpInfoList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchSubOfficeCList(e);
			}
		}
		return eventResponse;
	}

	


	

	private EventResponse modifyNodeDefaultSpInfoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0088Event event = (EsdPrd0088Event)e;
		YardManageBC command = new YardManageBCImpl();
		try{
			begin();
			command.modifyNodeDefaultSpInfoList (event.getSearchNodeDefaultSpInfoListVOS(),account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchDwellTimeHIstory(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0008Event event = (EsdPrd0008Event) e;
		YardManageBC command = new YardManageBCImpl();
		
		try{
			List<SearchYardDwellHistoryVO> list = command.searchDwellTimeHIstory(event);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse multiIntevalCCTManage(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0037Event event = (EsdPrd0037Event) e;
		CanadaCCTManageBC command = new CanadaCCTManageBCImpl();
		
		try{
			begin();
			command.multiIntevalCCTManage(event.getCanadaCCTManageVOs(), account);
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
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchPolNode(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0037Event event = (EsdPrd0037Event) e;
		CanadaCCTManageBC command = new CanadaCCTManageBCImpl();
		
		try{
			List<MdmLocationVO> list = command.searchPolNode(event);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchGeoHierarchyList(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0001Event event = (EsdPrd0001Event) e;
		GeoHierarchyManageBC command = new GeoHierarchyManageBCImpl();

		try{
			List<SearchGeoHierarchyManageVO> list = command.searchGeoHierarchyList(event.getSearchGeoHierarchyManageVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchContinent(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PrdCommonManageBC command = new PrdCommonManageBCImpl();
		
		try{
			List list = command.searchContinent();
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchNodeList(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0002Event event = (EsdPrd0002Event) e;
		YardManageBC command = new YardManageBCImpl();
		
		try{
			List<SearchNodeListVO> list = command.searchNodeList(event.getSearchNodeListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchYardDetail(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0002Event event = (EsdPrd0002Event) e;
		YardManageBC command = new YardManageBCImpl();
		
		try{
			List<SearchYardDetailVO> list = command.searchYardDetail(event.getSearchYardDetailVO());
			SearchYardDetailVO vo = null;
			if(list.size() > 0){
				vo = (SearchYardDetailVO) list.get(0);
				eventResponse.setETCData(vo.getColumnValues());
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchZoneDetail(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0002Event event = (EsdPrd0002Event) e;
		YardManageBC command = new YardManageBCImpl();
		
		try{
			List list = command.searchZoneDetail(event.getSearchZoneDetailVO());
			SearchZoneDetailVO vo = null;
			if(list.size() > 0){
				vo = (SearchZoneDetailVO) list.get(0);
				eventResponse.setETCData(vo.getColumnValues());
			}
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchZonePostCode(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0002Event event = (EsdPrd0002Event) e;
		YardManageBC command = new YardManageBCImpl();
		
		try{
			List list2 = command.searchZonePostCode(event.getSearchZonePostCodeVO());
			eventResponse.setRsVoList(list2);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse searchLeaseList(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0003Event event = (EsdPrd0003Event) e;
		YardManageBC command = new YardManageBCImpl();

		try{
			List<SearchLeaseListVO> list = command.searchLeaseList(event.getSearchLeaseListRSQLVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse searchCCTManage(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0036Event event = (EsdPrd0036Event) e;
		NewCCTManageBC command = new NewCCTManageBCImpl();
		
		try{
			List<NewCCTManageVO> list = command.searchCCTManage(event.getNewCCTManageVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * searchCanadaCCTManage
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse searchCanadaCCTManage(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0037Event event = (EsdPrd0037Event) e;
		CanadaCCTManageBC command = new CanadaCCTManageBCImpl();
		
		try{
			List<CanadaCCTManageVO> list = command.searchCanadaCCTManage(event.getCanadaCCTManageVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * searchCanadaCCTInterval
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse searchCanadaCCTInterval(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0037Event event = (EsdPrd0037Event) e;
		CanadaCCTManageBC command = new CanadaCCTManageBCImpl();
		
		try{
			List<CanadaCCTManageVO> list = command.searchCanadaCCTInterval(event.getCanadaCCTManageVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * searchMdmLocation
	 * @param e
	 * @return
	 * @throws EventException
	 */
//	private GeneralEventResponse searchMdmLocation(Event e) throws EventException{
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		EsdPrd0037Event event = (EsdPrd0037Event) e;
//		CanadaCCTManageBC command = new CanadaCCTManageBCImpl();
//		
//		try{
//			List<MdmLocationVO> list = command.searchMdmLocation(event);
//			eventResponse.setRsVoList(list);
//		}catch(EventException ex){
//			throw ex;
//		}catch(Exception ex){
//			throw new EventException(ex.getMessage(), ex);
//		}
//		return eventResponse;
//	}
	
	/**
	 * searchMdmLocation4USCA
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse searchMdmLocation4USCA(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0037Event event = (EsdPrd0037Event) e;
		CanadaCCTManageBC command = new CanadaCCTManageBCImpl();
		
		try{
			event.setFrmCntCd("CA");
			List<MdmLocationVO> list = command.searchMdmLocation(event);
			if(list != null && list.size() > 0) {
				eventResponse.setRsVoList(list);
			} else {
				event.setFrmCntCd("US");
				list = command.searchMdmLocation(event);
				eventResponse.setRsVoList(list);
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * POL, POR Duplication check
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse checkDuplicateCanadaCCTManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0037Event event = (EsdPrd0037Event) e;
		CanadaCCTManageBC command = new CanadaCCTManageBCImpl();

		try {
			List<CanadaCCTManageVO> list = command.checkDuplicateCanadaCCTManage(event.getCanadaCCTManageVOs());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
		
	}
	
	/**
	 * multiCanadaCCTManage
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse multiCanadaCCTManage(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0037Event event = (EsdPrd0037Event) e;
		CanadaCCTManageBC command = new CanadaCCTManageBCImpl();
		
		try{
			begin();
			command.multiCanadaCCTManage(event.getCanadaCCTManageVOs(), account);
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
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse multiCCTManage(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0036Event event = (EsdPrd0036Event) e;
		NewCCTManageBC command = new NewCCTManageBCImpl();
		
		try{
			begin();
			command.multiCCTManage(event.getNewCCTManageVOs(), account);
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
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse searchPickupList(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0070Event event = (EsdPrd0070Event) e;
		PickupReturnCyManageBC command = new PickupReturnCyManageBCImpl();
		
		try{
			List<PickupReturnCYVO> list = command.searchPickupList(event.getPickupReturnCYVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse multiPickupReturnCY(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0070Event event = (EsdPrd0070Event) e;
		PickupReturnCyManageBC command = new PickupReturnCyManageBCImpl();
		
		try{
			begin();
			command.multiPickupReturnCY(event.getPickupReturnCYVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("PRD00063").getUserMessage());
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
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse searchGroupCreationList(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0071Event event = (EsdPrd0071Event) e;
		BlockStowageManageBC command = new BlockStowageManageBCImpl();
		
		try{
			List<GroupCreationVO> list = command.searchGroupCreationList(event.getGroupCreationVO());
			eventResponse.setETCData("rowCount", list.size() + "");
			eventResponse.setRsVoList(list);		
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse searchLaneCode(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0071Event event = (EsdPrd0071Event) e;
		BlockStowageManageBC command = new BlockStowageManageBCImpl();
		
		try{
			List<GroupCreationVO> list = command.searchLaneCode(event.getGroupCreationVO());
			for(int i = 0; i < list.size(); i++){
				GroupCreationVO vo = (GroupCreationVO) list.get(i);
				eventResponse.setETCData(i + "", vo.getLaneCode());
			}
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse multiGroupCreation(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0071Event event = (EsdPrd0071Event) e;
		BlockStowageManageBC command = new BlockStowageManageBCImpl();
		
		try{
			begin();
			command.multiGroupCreation(event.getGroupCreationVOs(), account);
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
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse searchCodeInquiryList(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0072Event event = (EsdPrd0072Event) e;
		BlockStowageManageBC command = new BlockStowageManageBCImpl();
		
		try{
			List list = command.searchCodeInquiryList(event.getCodeInquiryVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse searchNodeDefaultSpInfoList(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0088Event event = (EsdPrd0088Event) e;
		YardManageBC command = new YardManageBCImpl();
		try{
			List list = command.searchNodeDefaultSpInfoList(event.getSearchNodeDefaultSpInfoListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	private EventResponse searchSubOfficeCList(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0088Event event = (EsdPrd0088Event) e;
		YardManageBC command = new YardManageBCImpl();
		try{
			
			List<SearchNodeDefaultSpInfoListVO> list = command.searchSubOfficeCList(event.getSearchNodeDefaultSpInfoListVO());
			
			StringBuffer vndrNm = new StringBuffer("");
			StringBuffer VndrCntCd = new StringBuffer("");
			StringBuffer VndrSeq = new StringBuffer("");
			for(int i=0; i<list.size(); i++){
				SearchNodeDefaultSpInfoListVO searchNodeDefaultSpInfoListVO = (SearchNodeDefaultSpInfoListVO)list.get(i);
				
				vndrNm.append(searchNodeDefaultSpInfoListVO.getVndrLglEngNm());
				VndrCntCd.append(searchNodeDefaultSpInfoListVO.getVndrCntCd());
				VndrSeq.append(searchNodeDefaultSpInfoListVO.getVndrSeq());
				if(i < list.size()-1) {
					vndrNm.append("|");
					VndrCntCd.append("|");
					VndrSeq.append("|");
				}
			}
			eventResponse.setETCData("vndr_Nm", vndrNm.toString());
			eventResponse.setETCData("VndrCntCd", VndrCntCd.toString());
			eventResponse.setETCData("VndrSeq", VndrSeq.toString());

			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse searchSubOfficeSOManageList(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0088Event event = (EsdPrd0088Event) e;
		YardManageBC command = new YardManageBCImpl();
		try{
			List list = command.searchSubOfficeSOManageList(event.getSearchNodeDefaultSpInfoListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	
	
}
