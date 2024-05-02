/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : NetworkNodeManageSC.java
 *@FileTitle : Geographic Hierarchy Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.networknodemanage;

import java.util.List;

import com.clt.apps.opus.esd.prd.common.prdcommon.basic.PrdCommonManageBC;
import com.clt.apps.opus.esd.prd.common.prdcommon.basic.PrdCommonManageBCImpl;
import com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.basic.BlockStowageManageBC;
import com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.basic.BlockStowageManageBCImpl;
import com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.event.EsdPrd0071Event;
import com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.event.EsdPrd0072Event;
import com.clt.apps.opus.esd.prd.networknodemanage.blockstowage.vo.GroupCreationVO;
import com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.basic.NewCCTManageBC;
import com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.basic.NewCCTManageBCImpl;
import com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.event.EsdPrd0036Event;
import com.clt.apps.opus.esd.prd.networknodemanage.cctmanage.event.EsdPrd0039Event;
import com.clt.apps.opus.esd.prd.networknodemanage.geohierarchymanage.basic.GeoHierarchyManageBC;
import com.clt.apps.opus.esd.prd.networknodemanage.geohierarchymanage.basic.GeoHierarchyManageBCImpl;
import com.clt.apps.opus.esd.prd.networknodemanage.geohierarchymanage.event.EsdPrd0001Event;
import com.clt.apps.opus.esd.prd.networknodemanage.geohierarchymanage.vo.SearchGeoHierarchyManageVO;
import com.clt.apps.opus.esd.prd.networknodemanage.inlandcutoff.basic.InlandCutOffTimeManageBC;
import com.clt.apps.opus.esd.prd.networknodemanage.inlandcutoff.basic.InlandCutOffTimeManageBCImpl;
import com.clt.apps.opus.esd.prd.networknodemanage.inlandcutoff.event.EsdPrd0038Event;
import com.clt.apps.opus.esd.prd.networknodemanage.pickupreturncy.basic.PickupReturnCyManageBC;
import com.clt.apps.opus.esd.prd.networknodemanage.pickupreturncy.basic.PickupReturnCyManageBCImpl;
import com.clt.apps.opus.esd.prd.networknodemanage.pickupreturncy.event.EsdPrd0070Event;
import com.clt.apps.opus.esd.prd.networknodemanage.pickupreturncy.vo.PickupReturnCYVO;
import com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.basic.YardManageBC;
import com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.basic.YardManageBCImpl;
import com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.event.EsdPrd0002Event;
import com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.event.EsdPrd0003Event;
import com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.vo.SearchNodeListVO;
import com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.vo.SearchYardDetailVO;
import com.clt.apps.opus.esd.prd.networknodemanage.yardmanage.vo.SearchZoneDetailVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * PRD Business Logic ServiceCommand<br>
 * handling business transaction of PRD<br>
 * 
 * @author kimyoungchul
 * @see ESD_PRD_001EventResponse,GeoHierarchyManageDBDAO
 * @since J2EE 1.4
 */
public class NetworkNodeManageSC extends ServiceCommandSupport {
	private SignOnUserAccount account = null;

	/**
	 * preceding process for biz scenario - PRD<br>
	 * related objects creation<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
			if (account.getUsr_id() == null) {
				throw new RuntimeException();
			}
		} catch (Exception e) {
			log.error(e.toString(), e);
		}
	}

	/**
	 * biz scenario closing - PRD<br>
	 * clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("NetworkNodeManageSC End");
	}

	/**
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("EsdPrd0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchGeoHierarchyList(e);
			} else {
				eventResponse = this.searchContinent(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchNodeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = this.searchYardDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = this.searchZoneDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = this.searchZonePostCode(e);
			} else {
				eventResponse = this.searchContinent(e);
			}

			/*
			 * Lease Company yard inquiry
			 */
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchLeaseList(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0036Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchCCTManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = this.searchCstSkdByPort(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiCCTManage(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = this.multiVslCgoClzDate(e);
			}
			// Pickup Return CY
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0070Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchPickupList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiPickupReturnCY(e);
			} // end if

			// Block Stowage Code Inquiry
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0071Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchGroupCreationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = this.searchLaneCode(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiGroupCreation(e);
			} // end if

			// Block Stowage Group Creation
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0072Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchCodeInquiryList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0038Event")) {
			// Inland Cut Off Time Management
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = this.searchInlandCutOffTime(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = this.searchInlandCutOffTime(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = this.multiInlandCutOffTime(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = this.checkEffectDate(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdPrd0039Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = this.searchPrdTmlVgmCctHis(e);
			}
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchGeoHierarchyList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0001Event event = (EsdPrd0001Event) e;
		GeoHierarchyManageBC command = new GeoHierarchyManageBCImpl();

		try {
			List<SearchGeoHierarchyManageVO> list = command.searchGeoHierarchyList(event.getSearchGeoHierarchyManageVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchContinent(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PrdCommonManageBC command = new PrdCommonManageBCImpl();
		try {
			eventResponse.setRsVoList(command.searchContinent());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchNodeList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0002Event event = (EsdPrd0002Event) e;
		YardManageBC command = new YardManageBCImpl();

		try {
			List<SearchNodeListVO> list = command.searchNodeList(event.getSearchNodeListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchYardDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0002Event event = (EsdPrd0002Event) e;
		YardManageBC command = new YardManageBCImpl();

		try {
			List<SearchYardDetailVO> list = command.searchYardDetail(event.getSearchYardDetailVO());
			SearchYardDetailVO vo = null;
			if (list.size() > 0) {
				vo = (SearchYardDetailVO) list.get(0);
				eventResponse.setETCData(vo.getColumnValues());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse searchZoneDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0002Event event = (EsdPrd0002Event) e;
		YardManageBC command = new YardManageBCImpl();
		try {
			List list = command.searchZoneDetail(event.getSearchZoneDetailVO());
			if (list.size() > 0) {
				SearchZoneDetailVO vo = (SearchZoneDetailVO) list.get(0);
				eventResponse.setETCData(vo.getColumnValues());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchZonePostCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0002Event event = (EsdPrd0002Event) e;
		YardManageBC command = new YardManageBCImpl();
		try {
			eventResponse.setRsVoList(command.searchZonePostCode(event.getSearchZonePostCodeVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse searchLeaseList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0003Event event = (EsdPrd0003Event) e;
		YardManageBC command = new YardManageBCImpl();
		try {
			eventResponse.setRsVoList(command.searchLeaseList(event.getSearchLeaseListRSQLVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse searchCCTManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0036Event event = (EsdPrd0036Event) e;
		NewCCTManageBC command = new NewCCTManageBCImpl();
		try {
			eventResponse.setRs(command.searchCCTManage(event.getNewCCTManageVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse multiCCTManage(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0036Event event = (EsdPrd0036Event) e;
		NewCCTManageBC command = new NewCCTManageBCImpl();
		try {
			begin();
			command.multiCCTManage(event.getNewCCTManageVOs(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse searchPickupList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0070Event event = (EsdPrd0070Event) e;
		PickupReturnCyManageBC command = new PickupReturnCyManageBCImpl();
		try {
			List<PickupReturnCYVO> list = command.searchPickupList(event.getPickupReturnCYVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse multiPickupReturnCY(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0070Event event = (EsdPrd0070Event) e;
		PickupReturnCyManageBC command = new PickupReturnCyManageBCImpl();
		try {
			begin();
			command.multiPickupReturnCY(event.getPickupReturnCYVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("PRD00063").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse searchGroupCreationList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0071Event event = (EsdPrd0071Event) e;
		BlockStowageManageBC command = new BlockStowageManageBCImpl();
		try {
			List<GroupCreationVO> list = command.searchGroupCreationList(event.getGroupCreationVO());
			eventResponse.setETCData("rowCount", list.size() + "");
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse searchLaneCode(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0071Event event = (EsdPrd0071Event) e;
		BlockStowageManageBC command = new BlockStowageManageBCImpl();

		try {
			List<GroupCreationVO> list = command.searchLaneCode(event.getGroupCreationVO());
			for (int i = 0; i < list.size(); i++) {
				GroupCreationVO vo = (GroupCreationVO) list.get(i);
				eventResponse.setETCData(i + "", vo.getLaneCode());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse multiGroupCreation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0071Event event = (EsdPrd0071Event) e;
		BlockStowageManageBC command = new BlockStowageManageBCImpl();
		try {
			begin();
			command.multiGroupCreation(event.getGroupCreationVOs(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse searchCodeInquiryList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0072Event event = (EsdPrd0072Event) e;
		BlockStowageManageBC command = new BlockStowageManageBCImpl();
		try {
			eventResponse.setRsVoList(command.searchCodeInquiryList(event.getCodeInquiryVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchCstSkdByPort(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0036Event event = (EsdPrd0036Event) e;
		NewCCTManageBC command = new NewCCTManageBCImpl();
		try {
			eventResponse.setRs(command.searchCstSkdByPort(event.getPrdCstSkdByPortVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse multiVslCgoClzDate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0036Event event = (EsdPrd0036Event) e;
		NewCCTManageBC command = new NewCCTManageBCImpl();
		try {
			begin();
			command.multiVslCgoClzDate(event.getPrdCstSkdByPortVOs(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse searchInlandCutOffTime(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0038Event event = (EsdPrd0038Event) e;
		InlandCutOffTimeManageBC command = new InlandCutOffTimeManageBCImpl();
		try {
			eventResponse.setRsVoList(command.searchInlandCutOffTime(event.getPrdInlndCutOffTmMgmtVO()));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse multiInlandCutOffTime(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0038Event event = (EsdPrd0038Event) e;
		InlandCutOffTimeManageBC command = new InlandCutOffTimeManageBCImpl();
		try {
			command.multiInlandCutOffTime(event.getPrdInlndCutOffTmMgmtVOs(), account);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private GeneralEventResponse checkEffectDate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0038Event event = (EsdPrd0038Event) e;
		InlandCutOffTimeManageBC command = new InlandCutOffTimeManageBCImpl();
		try {
			eventResponse.setETCData("valid", String.valueOf(command.checkEffectDate(event.getPrdInlndCutOffTmMgmtVO())));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchPrdTmlVgmCctHis(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdPrd0039Event event = (EsdPrd0039Event) e;
		NewCCTManageBC command = new NewCCTManageBCImpl();
		try {
			eventResponse.setRsVoList(command.searchPrdTmlVgmCctHis(event));
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
}
